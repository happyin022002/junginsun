/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0147Event.java
*@FileTitle : ESM_SAQ_0147
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Choi.M.C
*@LastVersion : 1.0
* 2007-06-29 변영주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeModifyListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;


/**
 * ESM_SAQ_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0147HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0147Event extends EventSupport {

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
	private SearchMonthlyQuotaAdjustmentTradeModifyListVO searchMonthlyQuotaAdjustmentTradeModifyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthlyQuotaAdjustmentTradeModifyListVO[] searchMonthlyQuotaAdjustmentTradeModifyListVOs = null;


	public EsmSaq0147Event(){}

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

	public SearchMonthlyQuotaAdjustmentTradeModifyListVO getSearchMonthlyQuotaAdjustmentTradeModifyListVO() {
		return searchMonthlyQuotaAdjustmentTradeModifyListVO;
	}

	public void setSearchMonthlyQuotaAdjustmentTradeModifyListVO(SearchMonthlyQuotaAdjustmentTradeModifyListVO searchMonthlyQuotaAdjustmentTradeModifyListVO) {
		this.searchMonthlyQuotaAdjustmentTradeModifyListVO = searchMonthlyQuotaAdjustmentTradeModifyListVO;
	}

	public SearchMonthlyQuotaAdjustmentTradeModifyListVO[] getSearchMonthlyQuotaAdjustmentTradeModifyListVOs() {
		SearchMonthlyQuotaAdjustmentTradeModifyListVO[] rtnVOs = null;
		if (this.searchMonthlyQuotaAdjustmentTradeModifyListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMonthlyQuotaAdjustmentTradeModifyListVOs, searchMonthlyQuotaAdjustmentTradeModifyListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchMonthlyQuotaAdjustmentTradeModifyListVOs(SearchMonthlyQuotaAdjustmentTradeModifyListVO[] searchMonthlyQuotaAdjustmentTradeModifyListVOs) {
		if(searchMonthlyQuotaAdjustmentTradeModifyListVOs != null){
			SearchMonthlyQuotaAdjustmentTradeModifyListVO[] tmpVOs = Arrays.copyOf(searchMonthlyQuotaAdjustmentTradeModifyListVOs, searchMonthlyQuotaAdjustmentTradeModifyListVOs.length);
			this.searchMonthlyQuotaAdjustmentTradeModifyListVOs  = tmpVOs;
		}
	}
	
}