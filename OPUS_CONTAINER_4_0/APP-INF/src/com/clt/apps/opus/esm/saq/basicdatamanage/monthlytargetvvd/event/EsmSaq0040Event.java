/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0040Event.java
*@FileTitle      : Target VVD/Supply Management
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonDirConvVO;
import com.clt.syscommon.common.table.SaqMonTgtVvdVO;


/**
 * ESM_SAQ_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author taeho, Kim
 * @see ESM_SAQ_0040HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	private SaqMonTgtVvdVO[] saqMonTgtVvdVOs = null;
	
	public EsmSaq0040Event(){}
	
	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO){
		this. quotaConditionVO = quotaConditionVO;
	}

	public QuotaConditionVO getQuotaConditionVO(){
		return quotaConditionVO;
	}
	
	public void setSaqMonTgtVvdVOS(SaqMonTgtVvdVO[] saqMonTgtVvdVOs){		
		if(saqMonTgtVvdVOs != null){
			SaqMonTgtVvdVO[] tmpVOs = Arrays.copyOf(saqMonTgtVvdVOs, saqMonTgtVvdVOs.length);
			this.saqMonTgtVvdVOs  = tmpVOs;
		}
	}
	
	public SaqMonTgtVvdVO[] getSaqMonTgtVvdVOS(){		
		SaqMonTgtVvdVO[] rtnVOs = null;
		if (this.saqMonTgtVvdVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonTgtVvdVOs, saqMonTgtVvdVOs.length);
		}
		return rtnVOs;
	}
}