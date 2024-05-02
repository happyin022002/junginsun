/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0012Event.java
*@FileTitle : EsmAcm0012Event
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.16 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.event;

import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo.AGNCommMassCalVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommMassCalVO agnCommMassCalVO = null;

	public EsmAcm0012Event() {}

	public AGNCommMassCalVO getAGNCommMassCalVO() {
		return agnCommMassCalVO;
	}

	public void setAGNCommMassCalVO(AGNCommMassCalVO agnCommMassCalVO) {
		this.agnCommMassCalVO = agnCommMassCalVO;
	}

}