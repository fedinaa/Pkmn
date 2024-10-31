package ru.mirea.pkmn.fedinadv;

import ru.mirea.pkmn.Card;
import java.io.*;

public class CardExport {

    public void exportCard(Card card) throws IOException {
        String filename = card.getName() + ".crd";
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(card);
            System.out.println("Карта экспортирована в файл: " + filename);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
