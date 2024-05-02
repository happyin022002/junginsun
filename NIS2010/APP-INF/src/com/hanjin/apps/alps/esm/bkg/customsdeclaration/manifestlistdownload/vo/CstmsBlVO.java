package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

public class CstmsBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

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
	
	private String pgmNo = null;
	
	/**
	 * 화면ID
	 * @return pgmNo
	 */
	public String getPgmNo () {
		return pgmNo; 
	}
	
	/**
	 * 화면ID세팅
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
}
