
public class Bacteria extends Entity {

	public Bacteria(Strength strength) {
		// This constructor initializes both attributes (including inherited
		// ones).
		super(strength);
		setDNA("bacteria");
	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		/*
		 * This implements the abstract method of the parent class, to simulate
		 * bacteria multiplying. It will search the parent class' list of
		 * entities for the first null entry, and insert a new bacteria with
		 * HIGH strength into that location. On the other hand, if the object is
		 * dead, this method will simply return without doing anything.
		 */
		boolean found = false;
		if (!(this.getStrength().equals(Strength.DEAD))) {
			for (int i = 0; i < Entity.bloodstream.length & !found; i++) {
				if (Entity.bloodstream[i] == null) {
					Entity.bloodstream[i] = new Bacteria(Strength.HIGH);
					found = true;
				}
			}
		}
	}

	
	
}
