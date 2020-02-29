package com.mi.mvi.koin

import androidx.room.Room
import com.mi.mvi.data.database.AppDatabase
import com.mi.mvi.data.session.SessionManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().getAccountDao() }
    single { get<AppDatabase>().getAuthTokenDao() }
    single { SessionManager(get(), androidContext()) }
}