/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0165Event.java
*@FileTitle : Monthly Sales Cfm Quota Adjustment - QTA Editing
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2008-04-04 Y.S.CHOI (CSR No. N200804035819)
* 1.0 Creation
* 2008-04-10 Lee Ho Ik  : QTA Editing (CSR No. N200804140003)
* 2009-10-19 Kim Min Ah : 조회 권한에 따른 변수 추가 (CSR No.CHM-200901271) 
*                         -  ofcTpCd, ofcCd 추가
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonCfmQtaVO;
import com.clt.syscommon.common.table.SaqMonCfmTgtVvdVO;


/**
 * ESM_SAQ_0165 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0165HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0165HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0165Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonCfmQtaVO saqMonCfmQtaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonCfmQtaVO[] saqMonCfmQtaVOs = null;
	

	public EsmSaq0165Event(){}

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

	public SaqMonCfmQtaVO getSaqMonCfmQtaVO() {
		return saqMonCfmQtaVO;
	}

	public void setSaqMonCfmQtaVO(SaqMonCfmQtaVO saqMonCfmQtaVO) {
		this.saqMonCfmQtaVO = saqMonCfmQtaVO;
	}

	public SaqMonCfmQtaVO[] getSaqMonCfmQtaVOs() {
		SaqMonCfmQtaVO[] rtnVOs = null;
		if (this.saqMonCfmQtaVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonCfmQtaVOs, saqMonCfmQtaVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonCfmQtaVOs(SaqMonCfmQtaVO[] saqMonCfmQtaVOs) {
		if(saqMonCfmQtaVOs != null){
			SaqMonCfmQtaVO[] tmpVOs = Arrays.copyOf(saqMonCfmQtaVOs, saqMonCfmQtaVOs.length);
			this.saqMonCfmQtaVOs  = tmpVOs;
		}
	}
	
}