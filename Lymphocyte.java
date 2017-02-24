

public class Lymphocyte extends WhiteBloodCell {

	public Lymphocyte(String nucleusType, Entity[] targets){
		super(nucleusType,targets);
		super.setDNA("lymphocyte");
		
	}
	
	@Override
	public void absorb(Entity in)	{
		//This implements the abstract method of the parent class
		in.kill();
		this.release();
		
	}
	
	@Override
	public void release(){
		/*This implements the abstract method of the parent class, and will kill the current object 
		 * with a ten percent chance every time it is called. You should google for a way to calculate a ten percent chance.
		 */
		double num = Math.random() * 10;
		if (num > 1) { 
			this.kill();
		}
	}

}
