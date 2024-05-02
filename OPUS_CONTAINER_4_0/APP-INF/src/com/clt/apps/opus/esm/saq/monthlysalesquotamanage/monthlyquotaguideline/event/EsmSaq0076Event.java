/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0076Event.java
*@FileTitle : Master Version Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2007-02-02 byyoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAQ_0076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Min Ah
 * @see ESM_SAQ_0076HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;

	public EsmSaq0076Event(){}
	
	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO){
		this.quotaConditionVO = quotaConditionVO;
	}

	public void setQuotaConditionVOS(QuotaConditionVO[] quotaConditionVOs){
		if(quotaConditionVOs != null){
			QuotaConditionVO[] tmpVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
			this.quotaConditionVOs  = tmpVOs;
		}
	}

	public QuotaConditionVO getQuotaConditionVO(){
		return quotaConditionVO;
	}

	public QuotaConditionVO[] getQuotaConditionVOS(){
		QuotaConditionVO[] rtnVOs = null;
		if (this.quotaConditionVOs != null) {
			rtnVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
		}
		return rtnVOs;
	}

}