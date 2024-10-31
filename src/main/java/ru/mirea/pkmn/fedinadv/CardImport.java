package ru.mirea.pkmn.fedinadv;

import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.AttackSkill;
import ru.mirea.pkmn.EnergyType;
import ru.mirea.pkmn.PokemonStage;
import ru.mirea.pkmn.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardImport {

    public static final long serialVersionUID = 1L;

    public Card loadCard(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            PokemonStage pokemonStage = PokemonStage.valueOf(reader.readLine());
            String name = reader.readLine();
            int hp = Integer.parseInt(reader.readLine());
            EnergyType pokemonType = EnergyType.valueOf(reader.readLine());
            String evolvesFromPath = reader.readLine();

            List<AttackSkill> skills = new ArrayList<>();
            String[] attackData = reader.readLine().split(",");
            for (String skillData : attackData) {
                String[] parts = skillData.trim().split(" / ");
                String cost = parts.length > 0 ? parts[0] : "0";
                String attackName = parts.length > 1 ? parts[1] : "Unnamed";
                int damage = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
                skills.add(new AttackSkill(attackName, "Описание:", cost, damage));
            }

            String weaknessLine = reader.readLine();
            EnergyType weaknessType = weaknessLine.equals("-") ? EnergyType.NONE : EnergyType.valueOf(weaknessLine);

            String resistanceLine = reader.readLine();
            EnergyType resistanceType = resistanceLine.equals("-") ? EnergyType.NONE : EnergyType.valueOf(resistanceLine);

            String retreatCost = reader.readLine();
            String gameSet = reader.readLine();
            char regulationMark = reader.readLine().charAt(0);
            String[] ownerData = reader.readLine().split(" / ");
            Student owner = new Student(ownerData[1], ownerData[0], ownerData[2], ownerData[3]);

            Card evolvesFrom = loadEvolvesFromCard(evolvesFromPath);

            return new Card(pokemonStage, name, hp, pokemonType, evolvesFrom, skills, weaknessType,
                    resistanceType, retreatCost, gameSet, regulationMark, owner, evolvesFromPath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    private Card loadEvolvesFromCard(String filePath) throws IOException {
        if (filePath.equals("-")) {
            return null;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            PokemonStage pokemonStage = PokemonStage.valueOf(reader.readLine());
            String name = reader.readLine();
            int hp = Integer.parseInt(reader.readLine());
            EnergyType pokemonType = EnergyType.valueOf(reader.readLine());
            String evolvesFromPath = reader.readLine(); // Пропускаем строку с evolvesFromPath

            List<AttackSkill> skills = new ArrayList<>();
            String[] attackData = reader.readLine().split(",");
            for (String skillData : attackData) {
                String[] parts = skillData.trim().split(" / ");
                String cost = parts.length > 0 ? parts[0] : "0";
                String attackName = parts.length > 1 ? parts[1] : "Unnamed";
                int damage = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
                skills.add(new AttackSkill(attackName, "", cost, damage));
            }

            String weaknessLine = reader.readLine();
            EnergyType weaknessType = weaknessLine.equals("-") ? EnergyType.NONE : EnergyType.valueOf(weaknessLine);

            String resistanceLine = reader.readLine();
            EnergyType resistanceType = resistanceLine.equals("-") ? EnergyType.NONE : EnergyType.valueOf(resistanceLine);

            String retreatCost = reader.readLine();
            String gameSet = reader.readLine();
            char regulationMark = reader.readLine().charAt(0);

            reader.readLine();

            return new Card(pokemonStage, name, hp, pokemonType, null, skills, weaknessType,
                    resistanceType, retreatCost, gameSet, regulationMark, null, evolvesFromPath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public Card importCard(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Card) objectInputStream.readObject();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw e;
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
