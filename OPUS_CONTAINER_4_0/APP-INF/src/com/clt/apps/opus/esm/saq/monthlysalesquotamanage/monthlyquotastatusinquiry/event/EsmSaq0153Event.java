/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0153Event.java
*@FileTitle : Process Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaRlseTrdVO;


/**
 * ESM_SAQ_0153 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0153HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SAQ_0153HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0153Event extends EventSupport {
	
	public EsmSaq0153Event(){}
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	private QuotaConditionVO[] quotaConditionVOs = null;		
	
	public QuotaConditionVO getQuotaConditionVO() {
		return quotaConditionVO;
	}	

	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO) {
		this.quotaConditionVO = quotaConditionVO;
	}

	public QuotaConditionVO[] getQuotaConditionVOs() {
		QuotaConditionVO[] rtnVOs = null;
		if (this.quotaConditionVOs != null) {
			rtnVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
		}
		return rtnVOs;
	}

	public void setQuotaConditionVOs(QuotaConditionVO[] quotaConditionVOs) {
		if(quotaConditionVOs != null){
			QuotaConditionVO[] tmpVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
			this.quotaConditionVOs  = tmpVOs;
		}
	}
}