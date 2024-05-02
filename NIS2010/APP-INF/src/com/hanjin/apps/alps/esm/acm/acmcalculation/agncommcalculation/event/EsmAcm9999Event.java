/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm9999Event.java
*@FileTitle : Agent Commission Simulation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.event;

import com.hanjin.apps.alps.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_9999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_9999HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_9999HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm9999Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCalculationVO bkgCalculationVO = null;
	private BkgCalculationVO[] bkgCalculationVOs = null;

	public EsmAcm9999Event() {}

	public BkgCalculationVO getBkgCalculationVO() {
		return bkgCalculationVO;
	}

	public void setBkgCalculationVO(BkgCalculationVO bkgCalculationVO) {
		this.bkgCalculationVO = bkgCalculationVO;
	}

	public BkgCalculationVO[] getBkgCalculationVOs() {
		return bkgCalculationVOs;
	}

	public void setBkgCalculationVOs(BkgCalculationVO[] bkgCalculationVOs) {
		this.bkgCalculationVOs = bkgCalculationVOs;
	}
}