/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : StowageManifestCondVO.java
 *@FileTitle : StowageManifestCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.12
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.08.12 김도완 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo;

import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 김도완
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class StowageManifestCondVO extends AbstractValueObject {

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
