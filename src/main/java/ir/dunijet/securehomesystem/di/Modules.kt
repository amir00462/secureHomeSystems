package ir.dunijet.securehomesystem.di

import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import ir.dunijet.securehomesystem.model.db.AppDatabase
import ir.dunijet.securehomesystem.service.local.LocalRepository
import ir.dunijet.securehomesystem.service.sms.SmsRepository
import ir.dunijet.securehomesystem.util.FIRST_LOGIC_DATA
import ir.dunijet.securehomesystem.util.SECOND_LOGIC_DATA
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val myModules = module {

    single {
        EncryptedSharedPreferences.create(
            FIRST_LOGIC_DATA,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            androidContext(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, SECOND_LOGIC_DATA).build()
    }

    single { SmsRepository(androidContext()) }
    single {
        LocalRepository(
            get(),
            get<AppDatabase>().logDao(),
            get<AppDatabase>().memberDao(),
            get<AppDatabase>().remoteDao(),
            get<AppDatabase>().zoneDao(),
        )
    }

    // viewModel { (isNetConnected: Boolean) -> MainViewModel(get(), get() , isNetConnected) }

}