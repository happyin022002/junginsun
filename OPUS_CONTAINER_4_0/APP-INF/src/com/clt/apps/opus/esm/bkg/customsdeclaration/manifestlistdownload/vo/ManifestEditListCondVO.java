/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManifestEditListCondVO.java
*@FileTitle : ManifestEditListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.20 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박상훈
 * @since J2EE 1.5
 * @see ..
 */
public  class  ManifestEditListCondVO extends AbstractValueObject {


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
