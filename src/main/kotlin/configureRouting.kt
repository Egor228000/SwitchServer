package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {
    routing {
        get("/keyboards") {
            // Вызываем suspend‑функцию из UserService
            val list = UserService.getAllKeyboards()
            call.respond(list)
        }
        // Список имён свитчей
        get("/switch-names") {
            val names = transaction {
                val rows = SwitchName.selectAll().map { it[SwitchName.name] }
                rows
            }
            call.respond(names)
        }

        // Список типов свитчей
        get("/switch-types") {
            val types = transaction {
                SwitchType
                    .selectAll()
                    .map { it[SwitchType.type] }
            }
            call.respond(types)
        }

        // Список профилей кейкапов
        get("/keycap-profiles") {
            val profiles = transaction {
                KeycapType
                    .selectAll()
                    .map { it[KeycapType.type] }
            }
            call.respond(profiles)
        }

        // Список материалов кейкапов
        get("/keycap-materials") {
            val materials = transaction {
                KeycapMaterial
                    .selectAll()
                    .map { it[KeycapMaterial.material] }
            }
            call.respond(materials)
        }

        // Список размеров раскладок
        get("/layout-scales") {
            val scales = transaction {
                LayoutTypes
                    .selectAll()
                    .map { it[LayoutTypes.scale] }
            }
            call.respond(scales)
        }
    }
}
