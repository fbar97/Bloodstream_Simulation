/*The purpose of this class is to model the chemicals various blood 
cells can use to communicate. It extends the Entity class.*/

public class Cytokine extends Entity{
	
	public Cytokine(){
		super(Strength.DEAD);
		setDNA("cytokine");
	}
	
	@Override	
	public void touchNeighbor(Entity neighbor){
		if (neighbor != null && neighbor.getDNA().compareTo("neutrophil") == 0)
			kill();
	}

}
