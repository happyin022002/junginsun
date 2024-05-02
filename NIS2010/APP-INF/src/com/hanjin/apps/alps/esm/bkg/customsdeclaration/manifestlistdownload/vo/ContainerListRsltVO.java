package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

public class ContainerListRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private String cntCd = null;
	
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
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}

	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
}
