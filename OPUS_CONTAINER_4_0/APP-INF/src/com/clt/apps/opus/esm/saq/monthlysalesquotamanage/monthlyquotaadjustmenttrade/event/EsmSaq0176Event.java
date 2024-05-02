/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_SAQ_176Event.java
*@FileTitle : Monthly Sales Quota Adjustment TRD - Excel Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2008-01-24 Lee Ho Ik
* 1.0 RHQ 버전 최초 생성
* 2008-01-29 Lee Ho Ik : Excel Upload 기능 구현
* 2010.02.17 김종호 : TRD 용 화면 추가
* 2010.04.30 Lee Sang Yong : new F/W 전환작업
* 2010.06.28 Kim Min Ah : [CHM-201004282] 소스 품질검토 결과 적용
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeForExcelListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;

 
/**
 * ESM_SAQ_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0161HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0176Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaTrdVO saqMonQtaTrdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaTrdVO[] saqMonQtaTrdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMonthlyQuotaAdjustmentTradeForExcelListVO searchMonthlyQuotaAdjustmentTradeForExcelListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] searchMonthlyQuotaAdjustmentTradeForExcelListVOs = null;

	public EsmSaq0176Event(){}

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
	
	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO getSearchMonthlyQuotaAdjustmentTradeForExcelListVO() {
		return searchMonthlyQuotaAdjustmentTradeForExcelListVO;
	}

	public void setSearchMonthlyQuotaAdjustmentTradeForExcelListVO(
			SearchMonthlyQuotaAdjustmentTradeForExcelListVO SearchMonthlyQuotaAdjustmentTradeForExcelListVO) {
		this.searchMonthlyQuotaAdjustmentTradeForExcelListVO = SearchMonthlyQuotaAdjustmentTradeForExcelListVO;
	}

	public SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] getSearchMonthlyQuotaAdjustmentTradeForExcelListVOs() {
		SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] rtnVOs = null;
		if (this.searchMonthlyQuotaAdjustmentTradeForExcelListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMonthlyQuotaAdjustmentTradeForExcelListVOs, searchMonthlyQuotaAdjustmentTradeForExcelListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchMonthlyQuotaAdjustmentTradeForExcelListVOs(SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] SearchMonthlyQuotaAdjustmentTradeForExcelListVOs) {
		if(searchMonthlyQuotaAdjustmentTradeForExcelListVOs != null){
			SearchMonthlyQuotaAdjustmentTradeForExcelListVO[] tmpVOs = Arrays.copyOf(searchMonthlyQuotaAdjustmentTradeForExcelListVOs, searchMonthlyQuotaAdjustmentTradeForExcelListVOs.length);
			this.searchMonthlyQuotaAdjustmentTradeForExcelListVOs  = tmpVOs;
		}
	}
	
}