package br.com.alura.alugames.models.plans

import br.com.alura.alugames.models.plans.Plan
import br.com.alura.alugames.models.plans.Rent

class separatePlan(type: String) : Plan(type) {
    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if (rent.gamer.average > 8) {
            originalValue -= originalValue * 0.1
        }
        return originalValue
    }
}
