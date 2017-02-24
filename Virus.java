
public class Virus extends Entity{
	public Virus(Strength strength)	{
		//This constructor initializes both attributes (including inherited ones).
		super(strength);
		super.setDNA("virus");
	}
	
	@Override
	public void touchNeighbor(Entity neighbor){
		/*This implements the abstract method of the parent class, to simulate viruses 
		 * taking over a host cell. If the neighbor's DNA is a neutrophil, it will change the 
		 * neighbor's DNA to a virus (that is, the object's type in Java will still be a Neutrophil,
		 *  but its DNA attribute will now store the string virus). On the other hand, if the object is dead,
		 *   this method will simply return without doing anything.
		 */
		if (neighbor != null && neighbor.getDNA().equals("neutrophil") & !this.getStrength().equals(Strength.DEAD)){
			neighbor.setDNA("virus");
		}
	}
}
