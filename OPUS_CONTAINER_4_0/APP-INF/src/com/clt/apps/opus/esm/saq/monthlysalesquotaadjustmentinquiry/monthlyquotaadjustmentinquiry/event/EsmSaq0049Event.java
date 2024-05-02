/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0049Event.java
*@FileTitle      : Trade Group
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.event;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAQ_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SAQ_0049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;

	public EsmSaq0049Event(){}	
	
	public QuotaConditionVO getQuotaConditionVO() {
		return quotaConditionVO;
	}

	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO) {
		this.quotaConditionVO = quotaConditionVO;
	}


	
}