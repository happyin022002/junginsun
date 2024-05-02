/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0116Event.java
*@FileTitle : Calculation Detail from History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.event;

import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.CalcDtlHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0116HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0116Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CalcDtlHistoryVO calcDtlHistoryVO = null;

	public EsmAcm0116Event() {}

	public CalcDtlHistoryVO getCalcDtlHistoryVO() {
		return calcDtlHistoryVO;
	}

	public void setCalcDtlHistoryVO(CalcDtlHistoryVO calcDtlHistoryVO) {
		this.calcDtlHistoryVO = calcDtlHistoryVO;
	}

}