/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSaq0158Event.java
*@FileTitle : Monthly Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : ChoiI.M.C
*@LastVersion : 1.0
* 2007-07-05 Lee Ho Ik
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.vo.SearchMonthlyQuotaForExcelListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtVO;


/**
 * ESM_SAQ_0158 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0158HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi.M.C
 * @see ESM_SAQ_0158HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0158Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO quotaConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private QuotaConditionVO[] quotaConditionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqMonQtaLodTgtVO saqMonQtaLodTgtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqMonQtaLodTgtVO[] saqMonQtaLodTgtVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMonthlyQuotaForExcelListVO searchMonthlyQuotaForExcelListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthlyQuotaForExcelListVO[] searchMonthlyQuotaForExcelListVOs = null;

	public EsmSaq0158Event(){}

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

	public SearchMonthlyQuotaForExcelListVO getSearchMonthlyQuotaForExcelListVO() {
		return searchMonthlyQuotaForExcelListVO;
	}

	public void setSearchMonthlyQuotaForExcelListVO(SearchMonthlyQuotaForExcelListVO searchMonthlyQuotaForExcelListVO) {
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