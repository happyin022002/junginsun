package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo;

import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

public class TransmitHistFileDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private String filePath = null;
	
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
		
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}