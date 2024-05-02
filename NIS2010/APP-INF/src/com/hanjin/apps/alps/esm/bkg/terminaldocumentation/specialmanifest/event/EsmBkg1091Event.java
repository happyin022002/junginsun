/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1091Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2010.04.15 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_1091HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg1091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BayPlanCondVO bayPlanCondVO = null;

	/**
	 * @return the bayPlanCondVO
	 */
	public BayPlanCondVO getBayPlanCondVO() {
		return bayPlanCondVO;
	}

	/**
	 * @param bayPlanCondVO the bayPlanCondVO to set
	 */
	public void setBayPlanCondVO(BayPlanCondVO bayPlanCondVO) {
		this.bayPlanCondVO = bayPlanCondVO;
	}
	
	
	
}
