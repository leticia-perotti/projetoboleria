package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name ="bolo")
data class BoloEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val cliente: String,
    val observacao: String,
    val valor: Double,
    val dataEntrega: Date,

    @OneToOne
    @JoinColumn(name = "decoracao")
    val decoracao: DecoracaoEntity,

   /* @OneToMany(cascade = [CascadeType.ALL], mappedBy = "bolo")
    //@JoinColumn(name = "bolo", referencedColumnName = "bolo")
    val coberturas: List<BoloCoberturaEntity>,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "bolo")
    //@JoinColumn(name = "bolo", referencedColumnName = "bolo")
    val massas: List<BoloMassaEntity>,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "bolo")
    //@JoinColumn(name = "bolo", referencedColumnName = "bolo")
    val recheio: List<BoloRecheioEntity>,*/


    )