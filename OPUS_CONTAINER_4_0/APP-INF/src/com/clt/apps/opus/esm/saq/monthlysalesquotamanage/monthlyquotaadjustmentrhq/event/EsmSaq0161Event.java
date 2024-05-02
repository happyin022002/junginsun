/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0161Event.java
*@FileTitle : Regional Group Vs. Trade Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2008-01-24 Lee Ho Ik
* 1.0 Creation
* 2008-01-29 Lee Ho Ik : Excel Upload 기능 구현
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaAdjustmentRhqModifyListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaForExcelListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaOfcAddVO;
import com.clt.syscommon.common.table.SaqMonQtaRhqVO;


/**
 * ESM_SAQ_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0161HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0161Event extends EventSupport {

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
	private SaqMonQtaOfcAddVO saqMonQtaOfcAddVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaOfcAddVO[] saqMonQtaOfcAddVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMonthlyQuotaForExcelListVO searchMonthlyQuotaForExcelListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthlyQuotaForExcelListVO[] searchMonthlyQuotaForExcelListVOs = null;

	public EsmSaq0161Event(){}

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

	public SaqMonQtaOfcAddVO getSaqMonQtaOfcAddVO() {
		return saqMonQtaOfcAddVO;
	}

	public void setSaqMonQtaOfcAddVO(SaqMonQtaOfcAddVO saqMonQtaOfcAddVO) {
		this.saqMonQtaOfcAddVO = saqMonQtaOfcAddVO;
	}

	public SaqMonQtaOfcAddVO[] getSaqMonQtaOfcAddVOs() {
		SaqMonQtaOfcAddVO[] rtnVOs = null;
		if (this.saqMonQtaOfcAddVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonQtaOfcAddVOs, saqMonQtaOfcAddVOs.length);
		}
		return rtnVOs;
	}

	public void setSaqMonQtaOfcAddVOs(SaqMonQtaOfcAddVO[] saqMonQtaOfcAddVOs) {
		if(saqMonQtaOfcAddVOs != null){
			SaqMonQtaOfcAddVO[] tmpVOs = Arrays.copyOf(saqMonQtaOfcAddVOs, saqMonQtaOfcAddVOs.length);
			this.saqMonQtaOfcAddVOs  = tmpVOs;
		}
	}
	
	public SearchMonthlyQuotaForExcelListVO getSearchMonthlyQuotaForExcelListVO() {
		return searchMonthlyQuotaForExcelListVO;
	}

	public void setSearchMonthlyQuotaForExcelListVO(
			SearchMonthlyQuotaForExcelListVO searchMonthlyQuotaForExcelListVO) {
		this.searchMonthlyQuotaForExcelListVO = searchMonthlyQuotaForExcelListVO;
	}

	public SearchMonthlyQuotaForExcelListVO[] getSearchMonthlyQuotaForExcelListVOs() {
		SearchMonthlyQuotaForExcelListVO[] rtnVOs = null;
		if (this.searchMonthlyQuotaForExcelListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMonthlyQuotaForExcelListVOs, searchMonthlyQuotaForExcelListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchMonthlyQuotaForExcelListVOs(SearchMonthlyQuotaForExcelListVO[] searchMonthlyQuotaForExcelListVOs) {
		if(searchMonthlyQuotaForExcelListVOs != null){
			SearchMonthlyQuotaForExcelListVO[] tmpVOs = Arrays.copyOf(searchMonthlyQuotaForExcelListVOs, searchMonthlyQuotaForExcelListVOs.length);
			this.searchMonthlyQuotaForExcelListVOs  = tmpVOs;
		}
	}	
}