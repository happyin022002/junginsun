/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0085Event.java
*@FileTitle : Regional Group Vs. Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2007-02-23 byyoo
* 1.0 Creation
* 2008.1.25 : 조회조건 추가 관련 search_sub_trd_cd 추가. Y.S.CHOI
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;


/**
 * ESM_SAQ_0085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChoiI.M.C
 * @see ESM_SAQ_0085HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaTrdVO saqMonQtaTrdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaTrdVO[] saqMonQtaTrdVOs = null;

	public EsmSaq0085Event(){}
	
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
	
	public SaqMonQtaTrdVO getSaqMonQtaTrdVO() {
		return saqMonQtaTrdVO;
	}

	public void setSaqMonQtaTrdVO(SaqMonQtaTrdVO saqMonQtaTrdVO) {
		this.saqMonQtaTrdVO = saqMonQtaTrdVO;
	}

	public SaqMonQtaTrdVO[] getSaqMonQtaTrdVOs() {
		SaqMonQtaTrdVO[] rtnVOs = null;
		if (this.saqMonQtaTrdVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonQtaTrdVOs, saqMonQtaTrdVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonQtaTrdVOs(SaqMonQtaTrdVO[] saqMonQtaTrdVOs) {
		if(saqMonQtaTrdVOs != null){
			SaqMonQtaTrdVO[] tmpVOs = Arrays.copyOf(saqMonQtaTrdVOs, saqMonQtaTrdVOs.length);
			this.saqMonQtaTrdVOs  = tmpVOs;
		}
	}

}