import java.util.*;

class CardCollectionSystem {
    private Map<String, List<String>> cards;

    public CardCollectionSystem() {
        cards = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(cardName);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cards.getOrDefault(symbol, Collections.emptyList());
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardCollectionSystem collection = new CardCollectionSystem();
        while (true) {
            System.out.println("1. Add Card\n2. Search by Symbol\n3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter Symbol and Card Name:");
                String symbol = sc.next();
                String cardName = sc.next();
                collection.addCard(symbol, cardName);
            } else if (choice == 2) {
                System.out.println("Enter Symbol to Search:");
                String symbol = sc.next();
                List<String> cards = collection.getCardsBySymbol(symbol);
                if (cards.isEmpty()) {
                    System.out.println("No cards found for " + symbol);
                } else {
                    System.out.println("Cards: " + cards);
                }
            } else {
                break;
            }
        }
        sc.close();
    }
}
