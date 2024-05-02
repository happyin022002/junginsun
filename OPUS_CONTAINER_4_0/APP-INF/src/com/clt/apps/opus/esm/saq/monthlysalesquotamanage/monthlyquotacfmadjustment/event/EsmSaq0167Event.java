/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0167Event.java
*@FileTitle : QTA Edit - Office Add
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2008-04-28 Y.S.CHOI (Project No. S2S-08U-002)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonCfmQtaOfcAddVO;


/**
 * ESM_SAQ_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0167HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0167Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonCfmQtaOfcAddVO saqMonCfmQtaOfcAddVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonCfmQtaOfcAddVO[] saqMonCfmQtaOfcAddVOs = null;
	

	public EsmSaq0167Event(){}

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

	public SaqMonCfmQtaOfcAddVO getSaqMonCfmQtaOfcAddVO() {
		return saqMonCfmQtaOfcAddVO;
	}

	public void setSaqMonCfmQtaOfcAddVO(SaqMonCfmQtaOfcAddVO saqMonCfmQtaOfcAddVO) {
		this.saqMonCfmQtaOfcAddVO = saqMonCfmQtaOfcAddVO;
	}

	public SaqMonCfmQtaOfcAddVO[] getSaqMonCfmQtaOfcAddVOs() {
		SaqMonCfmQtaOfcAddVO[] rtnVOs = null;
		if (this.saqMonCfmQtaOfcAddVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonCfmQtaOfcAddVOs, saqMonCfmQtaOfcAddVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonCfmQtaOfcAddVOs(SaqMonCfmQtaOfcAddVO[] saqMonCfmQtaOfcAddVOs) {
		if(saqMonCfmQtaOfcAddVOs != null){
			SaqMonCfmQtaOfcAddVO[] tmpVOs = Arrays.copyOf(saqMonCfmQtaOfcAddVOs, saqMonCfmQtaOfcAddVOs.length);
			this.saqMonCfmQtaOfcAddVOs  = tmpVOs;
		}
	}
	
}