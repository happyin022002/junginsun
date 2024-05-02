package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.clt.framework.component.common.AbstractValueObject;

public class VermasEdiMsgVO extends AbstractValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1374170871516586041L;
	private HashMap<String, List<AbstractValueObject>> ediData = new HashMap<String, List<AbstractValueObject>>();
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void addValueObject(String key, AbstractValueObject value){
		List<AbstractValueObject> list = null;
		if(ediData.containsKey(key)){
			list = ediData.get(key);
		}else{
			list = new ArrayList<AbstractValueObject>();
		}
		ediData.put(key, list);
	}
	
	/**
	 * 
	 * @param key
	 * @param index
	 * @param value
	 */
	public void changeValueObject(String key, int index, AbstractValueObject value){
		List<AbstractValueObject> list = ediData.get(key);
		list.add(index, value);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public List<AbstractValueObject> getValueObjects(String key){
		return ediData.get(key);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public AbstractValueObject getValueObject(String key){
		return getValueObject(key, 0);
	}
	
	/**
	 * 
	 * @param key
	 * @param index
	 * @return
	 */
	public AbstractValueObject getValueObject(String key, int index){
		return ediData.get(key).get(index);
	}
	
	@Override
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}
}
