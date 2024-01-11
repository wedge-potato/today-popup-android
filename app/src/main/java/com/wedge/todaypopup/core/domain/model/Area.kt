package com.wedge.todaypopup.core.domain.model

data class Area(
    val id: Long,
    val name: String,
    val isSelected: Boolean = false
) {
    fun select() = Area(id = this.id, name = this.name, isSelected = true)
    fun unSelect() = Area(id = this.id, name = this.name, isSelected = false)
}
