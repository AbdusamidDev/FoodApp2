package Models

class Food {
    var name: String? = null
    var ingredient: String? = null
    var preparationOrder: String? = null

    constructor(name: String?, ingredient: String?, preparationOrder: String?) {
        this.name = name
        this.ingredient = ingredient
        this.preparationOrder = preparationOrder
    }
}