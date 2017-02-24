

public class Macrophage extends WhiteBloodCell {

	private int count = 0; //keeps track of how many invaders have been ingested.

	public Macrophage(String nucleusType, Entity[] targets) {
		super(nucleusType, targets);
		super.setDNA("macrophage");
	}

	@Override
	public void absorb(Entity in) {
		//This implements the abstract method of the parent class
		in.kill();
		count++;
		this.release();
		
	}

	@Override
	public void release() {
		/*
		 * This implements the abstract method of the parent class, and will
		 * kill the current object after 100 invaders have been absorbed.
		 */
		if (count == 100) {
			this.kill();
		}
	}

	@Override
	public void touchNeighbor(Entity neighbor) {
		/*
		 * This implements the abstract method of the parent class. It will
		 * first call the parent's touchNeighbor method, to chomp away at any
		 * existing targets, and will then see if the neighbor is a neutrophil,
		 * in which case it will kill this neighbor if the neighbor is LOW on
		 * strength. On the other hand, if the object is dead, this method will
		 * simply return without doing anything.
		 */
		if (!this.getStrength().equals(Strength.DEAD)) {
			super.touchNeighbor(neighbor);
			if (neighbor != null && neighbor.getDNA().equals("neutrophil")
					&& neighbor.getStrength().equals(Strength.LOW)) {
				
				absorb(neighbor); 
				
				
			
			}
		}
	}

	

	
}
