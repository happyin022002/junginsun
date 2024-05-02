/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_SAQ_0116Event.java
*@FileTitle      : Monthly Quota Adjustment VVD
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.event;


import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *
 * @author 
 * @see ESM_SAQ_0116HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmSaq0116Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	

	public EsmSaq0116Event(){}

	

	public QuotaConditionVO getQuotaConditionVO() {
		return quotaConditionVO;
	}

	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO) {
		this.quotaConditionVO = quotaConditionVO;
	}

	
	
}