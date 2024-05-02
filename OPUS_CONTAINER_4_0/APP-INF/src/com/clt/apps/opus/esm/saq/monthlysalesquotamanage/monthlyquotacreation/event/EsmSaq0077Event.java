/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0077Event.java
*@FileTitle : Model Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김종호
*@LastVersion : 1.1
* 2006-12-21 byyoo
* 1.0 최초 생성
* 2009.08.31 김종호
* 1.1 Creation (new F/W 전환작업)   
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAQ_0077 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0077HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0077HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0077Event extends EventSupport {

	private static final long serialVersionUID = 1L;


	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOS = null;

	
	public QuotaConditionVO getQuotaConditionVO() {
		return quotaConditionVO;
	}

	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO) {
		this.quotaConditionVO = quotaConditionVO;
	}

	public QuotaConditionVO[] getQuotaConditionVOS() {
		QuotaConditionVO[] rtnVOs = null;
		if (this.quotaConditionVOS != null) {
			rtnVOs = Arrays.copyOf(quotaConditionVOS, quotaConditionVOS.length);
		}
		return rtnVOs;
	}

	public void setQuotaConditionVOS(QuotaConditionVO[] quotaConditionVOS) {
		if(quotaConditionVOS != null){
			QuotaConditionVO[] tmpVOs = Arrays.copyOf(quotaConditionVOS, quotaConditionVOS.length);
			this.quotaConditionVOS  = tmpVOs;
		}
	}

	public EsmSaq0077Event(){}

}