/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0164Event.java
*@FileTitle : Quota Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2008-04-04 Y.S.CHOI (CSR No. N200804035819)
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonCfmTgtVvdVO;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;
import com.clt.syscommon.common.table.SaqMonTgtVvdVO;


/**
 * ESM_SAQ_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0164HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0164Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonCfmTgtVvdVO saqMonCfmTgtVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonCfmTgtVvdVO[] saqMonCfmTgtVvdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonTgtVvdVO saqMonTgtVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonTgtVvdVO[] saqMonTgtVvdVOs = null;

	public EsmSaq0164Event(){}

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

	public SaqMonCfmTgtVvdVO getSaqMonCfmTgtVvdVO() {
		return saqMonCfmTgtVvdVO;
	}

	public void setSaqMonCfmTgtVvdVO(SaqMonCfmTgtVvdVO saqMonCfmTgtVvdVO) {
		this.saqMonCfmTgtVvdVO = saqMonCfmTgtVvdVO;
	}

	public SaqMonCfmTgtVvdVO[] getSaqMonCfmTgtVvdVOs() {
		SaqMonCfmTgtVvdVO[] rtnVOs = null;
		if (this.saqMonCfmTgtVvdVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonCfmTgtVvdVOs, saqMonCfmTgtVvdVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonCfmTgtVvdVOs(SaqMonCfmTgtVvdVO[] saqMonCfmTgtVvdVOs) {
		if(saqMonCfmTgtVvdVOs != null){
			SaqMonCfmTgtVvdVO[] tmpVOs = Arrays.copyOf(saqMonCfmTgtVvdVOs, saqMonCfmTgtVvdVOs.length);
			this.saqMonCfmTgtVvdVOs  = tmpVOs;
		}
	}

	public SaqMonTgtVvdVO getSaqMonTgtVvdVO() {
		return saqMonTgtVvdVO;
	}

	public void setSaqMonTgtVvdVO(SaqMonTgtVvdVO saqMonTgtVvdVO) {
		this.saqMonTgtVvdVO = saqMonTgtVvdVO;
	}

	public SaqMonTgtVvdVO[] getSaqMonTgtVvdVOs() {
		SaqMonTgtVvdVO[] rtnVOs = null;
		if (this.saqMonTgtVvdVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonTgtVvdVOs, saqMonTgtVvdVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonTgtVvdVOs(SaqMonTgtVvdVO[] saqMonTgtVvdVOs) {
		if(saqMonTgtVvdVOs != null){
			SaqMonTgtVvdVO[] tmpVOs = Arrays.copyOf(saqMonTgtVvdVOs, saqMonTgtVvdVOs.length);
			this.saqMonTgtVvdVOs  = tmpVOs;
		}
	}
	
	
}