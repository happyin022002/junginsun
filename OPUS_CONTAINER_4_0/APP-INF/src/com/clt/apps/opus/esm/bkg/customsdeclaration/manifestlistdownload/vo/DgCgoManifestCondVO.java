/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgCgoManifestCondVO.java
*@FileTitle : DgCgoManifestCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.21 박상훈
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
 * @see AbstractValueObject
 */

public class DgCgoManifestCondVO extends AbstractValueObject   {

	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		return null;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}

}
