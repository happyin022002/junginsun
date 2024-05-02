package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

public class AmsReportListCondVO extends AbstractValueObject {

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
	/* Column Info */
	private String pgmNo = null;


	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
	}


	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
}