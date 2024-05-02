/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0149Event.java
*@FileTitle : Monthly Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.09.11 최민철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaAdjustmentRhqModifyListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaRhqVO;


/**
 * ESM_SAQ_0149 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0149HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0149HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0149Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaRhqVO saqMonQtaRhqVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaRhqVO[] saqMonQtaRhqVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMonthlyQuotaAdjustmentRhqModifyListVO searchMonthlyQuotaAdjustmentRhqModifyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthlyQuotaAdjustmentRhqModifyListVO[] searchMonthlyQuotaAdjustmentRhqModifyListVOs = null;

	public EsmSaq0149Event(){}

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

	public SaqMonQtaRhqVO getSaqMonQtaRhqVO() {
		return saqMonQtaRhqVO;
	}

	public void setSaqMonQtaRhqVO(SaqMonQtaRhqVO saqMonQtaRhqVO) {
		this.saqMonQtaRhqVO = saqMonQtaRhqVO;
	}

	public SaqMonQtaRhqVO[] getSaqMonQtaRhqVOs() {
		SaqMonQtaRhqVO[] rtnVOs = null;
		if (this.saqMonQtaRhqVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonQtaRhqVOs, saqMonQtaRhqVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonQtaRhqVOs(SaqMonQtaRhqVO[] saqMonQtaRhqVOs) {
		if(saqMonQtaRhqVOs != null){
			SaqMonQtaRhqVO[] tmpVOs = Arrays.copyOf(saqMonQtaRhqVOs, saqMonQtaRhqVOs.length);
			this.saqMonQtaRhqVOs  = tmpVOs;
		}
	}

	public SearchMonthlyQuotaAdjustmentRhqModifyListVO getSearchMonthlyQuotaAdjustmentRhqModifyListVO() {
		return searchMonthlyQuotaAdjustmentRhqModifyListVO;
	}

	public void setSearchMonthlyQuotaAdjustmentRhqModifyListVO(SearchMonthlyQuotaAdjustmentRhqModifyListVO searchMonthlyQuotaAdjustmentRhqModifyListVO) {
		this.searchMonthlyQuotaAdjustmentRhqModifyListVO = searchMonthlyQuotaAdjustmentRhqModifyListVO;
	}

	public SearchMonthlyQuotaAdjustmentRhqModifyListVO[] getSearchMonthlyQuotaAdjustmentRhqModifyListVOs() {
		SearchMonthlyQuotaAdjustmentRhqModifyListVO[] rtnVOs = null;
		if (this.searchMonthlyQuotaAdjustmentRhqModifyListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMonthlyQuotaAdjustmentRhqModifyListVOs, searchMonthlyQuotaAdjustmentRhqModifyListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchMonthlyQuotaAdjustmentRhqModifyListVOs(	SearchMonthlyQuotaAdjustmentRhqModifyListVO[] searchMonthlyQuotaAdjustmentRhqModifyListVOs) {
		if(searchMonthlyQuotaAdjustmentRhqModifyListVOs != null){
			SearchMonthlyQuotaAdjustmentRhqModifyListVO[] tmpVOs = Arrays.copyOf(searchMonthlyQuotaAdjustmentRhqModifyListVOs, searchMonthlyQuotaAdjustmentRhqModifyListVOs.length);
			this.searchMonthlyQuotaAdjustmentRhqModifyListVOs  = tmpVOs;
		}
	}	
}