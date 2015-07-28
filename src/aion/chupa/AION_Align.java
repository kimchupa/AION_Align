package aion.chupa;

import java.util.HashMap;
import java.util.Map;

public class AION_Align {

	private Map<Integer, AION_Data> sourceData = new HashMap<Integer, AION_Data>();
	private Map<Integer, AION_Data> targetData = new HashMap<Integer, AION_Data>();
	private Map<Integer, Object[]> aionData = new HashMap<Integer, Object[]>();



	public AION_Align(Map<Integer, AION_Data> source, Map<Integer, AION_Data> target){

		this.sourceData = source;
		this.targetData = target;

	}


	public void Align(){
		
		System.out.println("Align Started...");
		//System.out.println(targetData.size());
		
		int keySize = sourceData.keySet().size(); 
		//System.out.println(sourceData.get(1).getTextData());
		//System.out.println(targetData.get(1).getIdData());
		Map<Integer, Object[]> texData = new HashMap<Integer, Object[]>();
		for(int i = 1; i <= sourceData.keySet().size(); i++) {
			if(keySize%10000 == 0){
				System.out.println(keySize);
			}
			keySize--;			
			//System.out.println("Source START.......");
			for(int j = 1; j < targetData.keySet().size(); j++) {
				//System.out.println("Target START.......");
				if(targetData.get(j).getIdData().equalsIgnoreCase(sourceData.get(i).getIdData())){
					texData.put(i, new Object[] {
							sourceData.get(i).getFilename(),
							sourceData.get(i).getIdData(),
							sourceData.get(i).getTextData(),
							targetData.get(j).getTextData()
					});
					
				}
				
				
			}
			
		}
		
		this.aionData = texData;
		
	}
	

	public Map<Integer, Object[]> getAIONData() {
		return aionData;
	}
	
	public Map<Integer, AION_Data> getSourceData() {
		return sourceData;
	}


	public void setSourceData(Map<Integer, AION_Data> sourceData) {
		this.sourceData = sourceData;
	}


	public Map<Integer, AION_Data> getTargetData() {
		return targetData;
	}


	public void setTargetData(Map<Integer, AION_Data> targetData) {
		this.targetData = targetData;
	}


}
