/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri7002Event.java
*@FileTitle : IHC Tariff Creation & Amendment - Amend
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event;

import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfIhcProgVO;


/**
 * ESM_PRI_7002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_7002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO MI JIN
 * @see ESM_PRI_7002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri7002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmPri7002Event(){}
	
	private IHCGuidelineMainVO iHCGuidelineMainVO = null;
	
	private PriTrfIhcProgVO priTrfIhcProgVO = null;

	public IHCGuidelineMainVO getiHCGuidelineMainVO() {
		return iHCGuidelineMainVO;
	}

	public void setiHCGuidelineMainVO(IHCGuidelineMainVO iHCGuidelineMainVO) {
		this.iHCGuidelineMainVO = iHCGuidelineMainVO;
	}

	public PriTrfIhcProgVO getPriTrfIhcProgVO() {
		return priTrfIhcProgVO;
	}

	public void setPriTrfIhcProgVO(PriTrfIhcProgVO priTrfIhcProgVO) {
		this.priTrfIhcProgVO = priTrfIhcProgVO;
	}
	
	
	
}