/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManifestListCondVO.java
*@FileTitle : ManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.11 김승민 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김승민
 * @since J2EE 1.5
 * @see ..
 */
public  class  ManifestListCondVO extends AbstractValueObject {


	private static final long serialVersionUID = 1L;

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * hashFildInpo
	 * @return
	 */	
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

	private String pgmNo = null;
	private String customsCd = null;
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
	
	/**
	 * 화면ID
	 * @return customsCd
	 */
	public String getCustomsCd () {
		return customsCd; 
	}
	
	/**
	 * 화면ID세팅
	 * @param customsCd
	 */
	public void setCustomsCd(String customsCd) {
		this.customsCd = customsCd;
	}
}
