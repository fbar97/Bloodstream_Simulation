
abstract class WhiteBloodCell extends Entity {

	private String nucleusType; // white blood cells all have a nucleus.

	private Entity[] targets; // This is an array of the types of entities this
								// blood cell can neutralize.

	public abstract void absorb(Entity in);
	// This abstract method will allow the white blood cell to absorb an
	// invader.

	public abstract void release();
	// This abstract method will allow the white blood cell to release something
	// into the bloodstream.

	public WhiteBloodCell(String nucleusType, Entity[] targets) {
		// This constructor initializes all four attributes (including inherited
		// ones). The strength will be set to high
		super(Strength.HIGH);
		this.nucleusType = nucleusType;
		this.targets = targets;
		
	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		/*
		 * This implements the abstract method of the parent class, by searching
		 * for matches of entities in the targets attribute against the incoming
		 * argument (by DNA). If a match is found, a battle is fought, using the
		 * following code which assigns a random number between 1 and 10 to the
		 * variable:
		 */
		
		for (int i = 0; i < targets.length; i++){
			if (neighbor != null && !this.getStrength().equals(Strength.DEAD) && neighbor.getDNA().equals(targets[i].getDNA())){
			
				int battle = 1 + (int) (Math.random() * ((10 - 1) + 1));
				
				if (this.getStrength().equals(Strength.MEDIUM) & battle > 5){
					absorb(neighbor);
				}
				else if (this.getStrength().equals(Strength.HIGH) & battle > 1){
					
					absorb(neighbor);
				}
			}
		}
		
		/*
		 * If the object's strength is MEDIUM and the battle's value is greater
		 * than five, or the strength is HIGH and the battle's value is greater
		 * than one, the object will call its absorb method. On the other hand,
		 * if the object is dead, this method will simply return without doing
		 * anything. Remember, a neighbor can also have a null value.
		 */
	}

	public void increaseStrength() {
		switch (getStrength()) {
		case LOW:
			setStrength(Strength.MEDIUM);
			break;
		case MEDIUM:
			setStrength(Strength.HIGH);
			break;
		}
	}

	public void reduceStrength() {
		switch (getStrength()) {
		case LOW:
			setStrength(Strength.DEAD);
			break;
		case MEDIUM:
			setStrength(Strength.LOW);
			break;
		case HIGH:
			setStrength(Strength.MEDIUM);
			break;
		}
	}
}
