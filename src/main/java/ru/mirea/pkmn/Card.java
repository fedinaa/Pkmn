package ru.mirea.pkmn;

import java.util.List;
import java.io.Serializable;

public class Card implements Serializable {
    public static final long serialVersionUID = 1L;
    private PokemonStage pokemonStage;
    private String name;
    private int hp;
    private EnergyType pokemonType;
    private Card evolvesFrom;
    private List<AttackSkill> skills;
    private EnergyType weaknessType;
    private EnergyType resistanceType;
    private String retreatCost;
    private String gameSet;
    private char regulationMark;
    private Student pokemonOwner;
    private String evolvesFromPath;

    public Card(PokemonStage pokemonStage, String name, int hp, EnergyType pokemonType,
                Card evolvesFrom, List<AttackSkill> skills, EnergyType weaknessType,
                EnergyType resistanceType, String retreatCost, String gameSet,
                char regulationMark, Student pokemonOwner, String evolvesFromPath) {
        this.pokemonStage = pokemonStage;
        this.name = name;
        this.hp = hp;
        this.pokemonType = pokemonType;
        this.evolvesFrom = evolvesFrom;
        this.skills = skills;
        this.weaknessType = weaknessType;
        this.resistanceType = resistanceType;
        this.retreatCost = retreatCost;
        this.gameSet = gameSet;
        this.regulationMark = regulationMark;
        this.pokemonOwner = pokemonOwner;
        this.evolvesFromPath = evolvesFromPath;
    }

    public PokemonStage getPokemonStage() {
        return pokemonStage;
    }

    public void setPokemonStage(PokemonStage pokemonStage) {
        this.pokemonStage = pokemonStage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public EnergyType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(EnergyType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public Card getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(Card evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public List<AttackSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<AttackSkill> skills) {
        this.skills = skills;
    }

    public EnergyType getWeaknessType() {
        return weaknessType;
    }

    public void setWeaknessType(EnergyType weaknessType) {
        this.weaknessType = weaknessType;
    }

    public EnergyType getResistanceType() {
        return resistanceType;
    }

    public void setResistanceType(EnergyType resistanceType) {
        this.resistanceType = resistanceType;
    }

    public String getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(String retreatCost) {
        this.retreatCost = retreatCost;
    }

    public String getGameSet() {
        return gameSet;
    }

    public void setGameSet(String gameSet) {
        this.gameSet = gameSet;
    }

    public char getRegulationMark() {
        return regulationMark;
    }

    public void setRegulationMark(char regulationMark) {
        this.regulationMark = regulationMark;
    }

    public Student getPokemonOwner() {
        return pokemonOwner;
    }

    public void setPokemonOwner(Student pokemonOwner) {
        this.pokemonOwner = pokemonOwner;
    }

    public String getEvolvesFromPath() {
        return evolvesFromPath;
    }

    public void setEvolvesFromPath(String evolvesFromPath) {
        this.evolvesFromPath = evolvesFromPath;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Card{").append("\n")
                .append("PokemonStage = ").append(pokemonStage).append("\n")
                .append("Name = ").append(name).append("\n")
                .append("HP = ").append(hp).append("\n")
                .append("PokemonType = ").append(pokemonType).append("\n")
                .append("EvolvesFrom = ").append(evolvesFrom != null ? evolvesFrom.getName() : "None").append("\n")
                .append("Skills = ").append(skills).append("\n")
                .append("WeaknessType = ").append(weaknessType).append("\n")
                .append("ResistanceType = ").append(resistanceType).append("\n")
                .append("RetreatCost = ").append(retreatCost).append("\n")
                .append("GameSet = ").append(gameSet).append("\n")
                .append("RegulationMark = ").append(regulationMark).append("\n")
                .append("PokemonOwner = ").append(pokemonOwner != null ? pokemonOwner : "None").append("\n")
                .append("EvolvesFromPath = ").append(evolvesFromPath).append("\n\n");

        if (evolvesFrom != null) {
            sb.append("EvolvesFromPokemon = {").append("\n")
                    .append(evolvesFrom.toString())
                    .append("}");
        }

        sb.append('}');
        return sb.toString();
    }

}
