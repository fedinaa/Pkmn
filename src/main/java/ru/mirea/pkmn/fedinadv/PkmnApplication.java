package ru.mirea.pkmn.fedinadv;

import ru.mirea.pkmn.Card;
import java.io.IOException;
import java.util.Scanner;

public class PkmnApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardImport cardImport = new CardImport();
        CardExport cardExport = new CardExport();

        String filename = "src/main/resources/my_card.txt";
        try {
            Card card = cardImport.loadCard(filename);
            System.out.println("Загруженная карта:\n" + card);
            cardExport.exportCard(card);


            System.out.println("Введите имя файла (.crd) для импорта:");
            String importFileName = scanner.nextLine();
            Card importedCard = cardImport.importCard(importFileName);
            System.out.println("Импортированная карта:\n" + importedCard);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

}

