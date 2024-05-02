/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlInfoCondVO.java
*@FileTitle : BlInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo;

import java.util.HashMap;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이수빈
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class BlInfoCondVO extends AbstractValueObject {

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
	
	private String blNo = "";
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getBlNo() {
		return blNo;
	}

	private UsaManifestSearchDetailVO[] usaManifestSearchDetailVOs = null;
	public void setUsaManifestSearchDetailVOs(UsaManifestSearchDetailVO[] usaManifestSearchDetailVOs) {
		this.usaManifestSearchDetailVOs = usaManifestSearchDetailVOs;
	}
	public UsaManifestSearchDetailVO[] getUsaManifestSearchDetailVOs() {
		return usaManifestSearchDetailVOs;
	}
}
