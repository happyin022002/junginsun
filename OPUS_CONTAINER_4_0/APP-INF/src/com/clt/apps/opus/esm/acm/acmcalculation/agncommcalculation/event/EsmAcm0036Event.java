/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0036Event.java
*@FileTitle : Agent Commission Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.08.05 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationDetailVO;
import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0036Event extends EventSupport {


	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgCalculationVO bkgCalculationVO = null;
	private BkgCalculationVO[] bkgCalculationVOs = null;
	private BkgCalculationDetailVO bkgCalculationDetailVO = null;

	public EsmAcm0036Event() {}

	public BkgCalculationVO getBkgCalculationVO() {
		return bkgCalculationVO;
	}

	public void setBkgCalculationVO(BkgCalculationVO bkgCalculationVO) {
		this.bkgCalculationVO = bkgCalculationVO;
	}

	public BkgCalculationVO[] getBkgCalculationVOs() {
		BkgCalculationVO[] rtnVOs = null;
		if (this.bkgCalculationVOs != null) {
			rtnVOs = Arrays.copyOf(bkgCalculationVOs, bkgCalculationVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgCalculationVOs(BkgCalculationVO[] bkgCalculationVOs) {
		if(bkgCalculationVOs != null){
			BkgCalculationVO[] tmpVOs = Arrays.copyOf(bkgCalculationVOs, bkgCalculationVOs.length);
			this.bkgCalculationVOs  = tmpVOs;
		}
	}
	public BkgCalculationDetailVO getBkgCalculationDetailVO() {
		return bkgCalculationDetailVO;
	}

	public void setBkgCalculationDetailVO(
			BkgCalculationDetailVO bkgCalculationDetailVO) {
		this.bkgCalculationDetailVO = bkgCalculationDetailVO;
	}

}