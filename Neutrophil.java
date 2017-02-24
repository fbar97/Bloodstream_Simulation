
public class Neutrophil extends WhiteBloodCell {
	private boolean sniffCytokines; // If this attribute is set, the cell can
									// react to cytokines in the bloodstream.

	public Neutrophil(String nucleusType, Entity[] targets, boolean sniffCytokines) {

		super(nucleusType, targets);
		super.setDNA("neutrophil");
		this.sniffCytokines = sniffCytokines;

	}

	@Override
	public void absorb(Entity in) {
		// This overrides the parent's method 
		in.kill();
		this.reduceStrength();
		this.release();

	}

	@Override
	public void release() {
		/*
		 * This method will release three new Cytokines into the bloodstream in
		 * the first null entries it finds , unless the object has been infected
		 * by a virus, as reflected in its DNA. In such a case, it will
		 * similarly release three new high-strength Virus particles into the
		 * bloodstream instead.
		 */
		int entries = 0;
		for (int i = 0; i < Entity.bloodstream.length; i++) {
			if (Entity.bloodstream[i] == null & entries < 3) {
				if (this.getDNA().equals("virus")) {
					Virus virus = new Virus(Strength.HIGH);
					Entity.bloodstream[i] = virus;
				} else {
					Cytokine cyto = new Cytokine();
					Entity.bloodstream[i] = cyto;
				}
				entries++;
			}
		}
	}
	
	@Override
	public void touchNeighbor(Entity neighbor) {
		/*
		 * This implements the abstract method of the parent class, to simulate
		 * a neutrophil sniffing for cytokines. It will first call the parent's
		 * touchNeighbor method, to chomp away at any existing targets, and will
		 * then see if the neighbor is a cytokine, in which case it will
		 * increase its own strength. On the other hand, if the object is dead,
		 * this method will simply return without doing anything.
		 */
		if (neighbor != null && !this.getStrength().equals(Strength.DEAD)) {
			super.touchNeighbor(neighbor);
			if (neighbor.getDNA().equals("cytokine") && sniffCytokines) {
				this.increaseStrength();
			}
		}
	}
}
