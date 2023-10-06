package Model;

import java.util.*;

public class Sanctuary implements Isolation, Enclosure{
  private List<Monkey> isolation;
  private Map<Species, List<Monkey>> enclosures;
  private final int MAX_ISOLATION_CAPACITY = 20;

  /**
   * Constructs a new sanctuary with an empty isolation and an empty map of enclosures.
   */
  public Sanctuary() {
    isolation = new ArrayList<Monkey>(MAX_ISOLATION_CAPACITY);
    enclosures = new HashMap<Species, List<Monkey>>();
  }

  public void addMonkeyToIsolation(Monkey monkey) {
    if (isolation.size() < MAX_ISOLATION_CAPACITY) {
      isolation.add(monkey);
      monkey.receivedMedicalAttention(true);
    } else {
      throw new IllegalStateException("Isolation is full.");
    }
  }

  public void moveMonkeyToEnclosure(Monkey monkey) {
    if (isolation.remove(monkey) && monkey.isHealthy()) {
      if (!enclosures.containsKey(monkey.getSpecies())) {
        enclosures.put(monkey.getSpecies(), new ArrayList<>());
      }
      enclosures.get(monkey.getSpecies()).add(monkey);
    } else {
      throw new IllegalStateException();
    }
  }

  public List produceEnclosureList(Species species) {
    List<String> res = new LinkedList<>();
    List<Monkey> monkeys = enclosures.get(species);
    for (Monkey monkey : monkeys) {
      res.add(monkey.toString());
    }
    return res;
  }

  /**
   * Produce an alphabetical list (by name) of all the monkeys housed in the Sanctuary.
   * @return a list of all monkeys in the sanctuary
   */
  public List<Monkey> getAllMonkeys() {
    List<Monkey> allMonkeys = new ArrayList<Monkey>();
    allMonkeys.addAll(isolation);
    for (List<Monkey> monkeyList : enclosures.values()) {
      allMonkeys.addAll(monkeyList);
    }
    // Sort the list of monkeys alphabetically by name
    Collections.sort(allMonkeys, (m1, m2) -> m1.getName().compareTo(m2.getName()));
    return allMonkeys;
  }
}