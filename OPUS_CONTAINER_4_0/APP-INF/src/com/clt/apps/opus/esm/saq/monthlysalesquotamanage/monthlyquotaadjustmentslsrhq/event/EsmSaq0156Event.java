/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0156Event.java
*@FileTitle : Monthly Sales Quota Adjustment Sales RHQ
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2007-03-05 Lee Ho Ik
* 1.0 Creation
* 2008.1.28 : 조회조건 추가 관련 search_rlane_cd 추가. Y.S.CHOI
* 2008-04-02 YJBYEON : CSR - N200803255636, cfm_qta 표기시 Direction Conversion 적용
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtVO;
import com.clt.syscommon.common.table.SaqMonQtaOfcAddVO;


/**
 * ESM_SAQ_0156 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0156HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChoiI.M.C
 * @see ESM_SAQ_0156HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0156Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaLodTgtVO saqMonQtaLodTgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaLodTgtVO[] saqMonQtaLodTgtVOs = null;
	
	public EsmSaq0156Event(){}
	
	public void setQuotaConditionVO(QuotaConditionVO quotaConditionVO){
		this.quotaConditionVO = quotaConditionVO;
	}

	public QuotaConditionVO[] getQuotaConditionVOS(){
		QuotaConditionVO[] rtnVOs = null;
		if (this.quotaConditionVOs != null) {
			rtnVOs = Arrays.copyOf(quotaConditionVOs, quotaConditionVOs.length);
		}
		return rtnVOs;
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

	public SaqMonQtaLodTgtVO getSaqMonQtaLodTgtVO() {
		return saqMonQtaLodTgtVO;
	}

	public void setSaqMonQtaLodTgtVO(SaqMonQtaLodTgtVO saqMonQtaLodTgtVO) {
		this.saqMonQtaLodTgtVO = saqMonQtaLodTgtVO;
	}

	public SaqMonQtaLodTgtVO[] getSaqMonQtaLodTgtVOs() {
		SaqMonQtaLodTgtVO[] rtnVOs = null;
		if (this.saqMonQtaLodTgtVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonQtaLodTgtVOs, saqMonQtaLodTgtVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonQtaLodTgtVOs(SaqMonQtaLodTgtVO[] saqMonQtaLodTgtVOs) {
		if(saqMonQtaLodTgtVOs != null){
			SaqMonQtaLodTgtVO[] tmpVOs = Arrays.copyOf(saqMonQtaLodTgtVOs, saqMonQtaLodTgtVOs.length);
			this.saqMonQtaLodTgtVOs  = tmpVOs;
		}
	}



}