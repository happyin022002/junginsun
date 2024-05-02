/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManifestModificationVO.java
*@FileTitle : ManifestModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.22 경종윤 
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
 * @author 경종윤
 * @since J2EE 1.5
 */

public class ManifestModificationVO extends AbstractValueObject   {

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