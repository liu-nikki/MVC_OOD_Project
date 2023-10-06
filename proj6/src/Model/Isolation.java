package Model;

/**
 * This interface represents all the operations offered by isolation housing.
 * Isolation is used to keep monkeys when they first arrive at the sanctuary and
 * anytime they are receiving medical attention.
 * Isolation consists of a series of cages each of which can house a single animal.
 */
public interface Isolation {
  /**
   * Add a monkey to the sanctuary by adding them to isolation
   * @param monkey the monkey to be added to isolation
   * @throws IllegalStateException if the isolation is full
   */
  void addMonkeyToIsolation(Monkey monkey) throws IllegalStateException;

}
