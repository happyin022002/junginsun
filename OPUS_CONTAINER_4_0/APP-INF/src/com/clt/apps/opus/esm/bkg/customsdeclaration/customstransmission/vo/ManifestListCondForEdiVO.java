/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CstmsManifestAmendmentCondVO.java
 *@FileTitle : CstmsManifestAmendmentCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.19 김민정
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김민정
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class ManifestListCondForEdiVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	/**
	 * hashColumnInpo
	 *
	 * @return HashMap
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * hashFildInpo
	 *
	 * @return
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}