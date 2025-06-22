package com.example

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun configureDatabases() {
    // Подключение к SQLite (база будет создана в корне проекта)
    val db = Database.connect(
        url = "jdbc:sqlite:switchDB.db",
        driver = "org.sqlite.JDBC"
    )

    transaction(db) {
        // Создать таблицы, если их нет
        SchemaUtils.create(
            SwitchName,
            SwitchType,
            KeycapType,
            KeycapMaterial,
            LayoutTypes,
            Keyboards,
            Switches,
            Keycaps,
            UserProfile,
            Repair
        )


    }



}
