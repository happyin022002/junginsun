/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0016Event.java
*@FileTitle : EsmAcm0016Event
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.24 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.event;

import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.AGNCommCalcHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommCalcHistoryVO agnCommCalcHistoryVO = null;

	public EsmAcm0016Event() {}

	public AGNCommCalcHistoryVO getAGNCommCalcHistoryVO() {
		return agnCommCalcHistoryVO;
	}

	public void setAGNCommCalcHistoryVO(AGNCommCalcHistoryVO agnCommCalcHistoryVO) {
		this.agnCommCalcHistoryVO = agnCommCalcHistoryVO;
	}

}