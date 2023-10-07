package Model;

public class Monkey {
  private String name;
  private Species species;
  private Sex sex;
  private String size;
  private double weight;
  private int age;
  private Food favoriteFood;
  private boolean isHealthy = false;

  public Monkey(String name, Species species, Sex sex, String size, double weight, int age, Food favoriteFood) {
    if (name.isEmpty() || name == null || weight < 0 || age < 0) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favoriteFood = favoriteFood;
  }

  public String getName() {
    return name;
  }

  public Species getSpecies() {
    return species;
  }

  public Sex getSex() {
    return sex;
  }

  public String getSize() {
    return size;
  }

  public double getWeight() {
    return weight;
  }

  public int getAge() {
    return age;
  }

  public Food getFavoriteFood() {
    return favoriteFood;
  }

  public void receivedMedicalAttention(boolean healthy) {
    isHealthy = healthy;
  }

  public boolean isHealthy() {
    return isHealthy;
  }
  @Override
  public String toString() {
    return name + " (" + sex + ", " + favoriteFood + ")";
  }
}
