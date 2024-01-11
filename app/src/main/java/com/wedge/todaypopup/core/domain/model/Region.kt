package com.wedge.todaypopup.core.domain.model

data class Region(
    val id: Long,
    val name: String,
    val isSelected: Boolean = false
) {
    fun select() = Region(id = this.id, name = this.name, isSelected = true)
    fun unSelect() = Region(id = this.id, name = this.name, isSelected = false)
}