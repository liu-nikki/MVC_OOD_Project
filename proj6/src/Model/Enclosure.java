package Model;

import java.util.List;

/**
 * This interface represents all the operations offered by enclosure housing.
 * Enclosures are much larger and can host a single troop (i.e., a group) of monkeys.
 * Each troop consists of a single species that is found in the New World.
 */
public interface Enclosure {
  /**
   * Move a monkey from isolation to an enclosure
   * @param monkey the monkey to be moved
   * @throws IllegalStateException if the monkey is not healthy or cannot be found in isolation
   */
  void moveMonkeyToEnclosure(Monkey monkey) throws IllegalStateException;

  /**
   * Produce a list of monkeys in an enclosure
   * @param species the species of monkey to be listed
   * @return a list of monkeys in the enclosure
   */
  List produceEnclosureList(Species species);

}
