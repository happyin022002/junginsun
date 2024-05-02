/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0105Event.java
*@FileTitle : Calculation Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.05 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.event;

import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.CalcDtlBkgRevenueVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CalcDtlBkgRevenueVO calcDtlBkgRevenueVO = null;

	public EsmAcm0105Event() {}

	public CalcDtlBkgRevenueVO getCalcDtlBkgRevenueVO() {
		return calcDtlBkgRevenueVO;
	}

	public void setCalcDtlBkgRevenueVO(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) {
		this.calcDtlBkgRevenueVO = calcDtlBkgRevenueVO;
	}

}