
abstract class Entity {

	private String DNA; //used to determine the type 
	private Strength strength; 
	protected static Entity[] bloodstream; 
	
	public Entity(Strength strength) { 
		this.strength = strength;
	}

	public String getDNA() {
		return DNA;
	}

	public void setDNA(String dna) {
		DNA = dna;
	}

	public Strength getStrength() {
		return strength;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public void kill() { 
		this.setStrength(Strength.DEAD);
	}

	public abstract void touchNeighbor(Entity neighbor);
		/*This abstract method will be implemented by Entity's child classes, to decide what happens 
		 * when two entities touch in the bloodstream
		 */
	

	public static void setEntity(int size) {
		bloodstream = new Entity[size];
	}
}
