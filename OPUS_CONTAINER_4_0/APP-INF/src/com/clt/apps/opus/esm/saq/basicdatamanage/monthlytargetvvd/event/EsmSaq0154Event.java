/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0154Event.java
*@FileTitle      : Target VVD/Supply Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAQ_0154 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0154HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author taeho, Kim
 * @see ESM_SAQ_0154HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0154Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO conditionVO = null;
	
	public EsmSaq0154Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	public void setMonthlyTargetVVDInquiryConditionVO(QuotaConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	public QuotaConditionVO getMonthlyTargetVVDInquiryConditionVO(){
		return conditionVO;
	}
}