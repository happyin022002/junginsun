/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri7012Event.java
*@FileTitle : Add-on Tariff Creation & Amendment - Amend
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRProgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_7012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7012Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri7012Event(){}
	
	private FDRMainVO fDRMainVO = null;   
	
	private FDRProgVO fDRProgVO = null;

	public FDRMainVO getfDRMainVO() {
		return fDRMainVO;
	}

	public void setfDRMainVO(FDRMainVO fDRMainVO) {
		this.fDRMainVO = fDRMainVO;
	}

	public FDRProgVO getfDRProgVO() {
		return fDRProgVO;
	}

	public void setfDRProgVO(FDRProgVO fDRProgVO) {
		this.fDRProgVO = fDRProgVO;
	}

	
}