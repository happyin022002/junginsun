/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1003Event.java
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffSummaryParamVO;


/**
 * EES-DMT-1003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-1003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-1003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt1003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBasicTariffSummaryListVO searchBasicTariffSummaryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBasicTariffSummaryListVO[] searchBasicTariffSummaryListVOs = null;
	
	/** Param Value Object */
	private SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO = null;
	
	public EesDmt1003Event(){}

	public SearchBasicTariffSummaryListVO getSearchBasicTariffSummaryListVO() {
		return searchBasicTariffSummaryListVO;
	}

	public void setSearchBasicTariffSummaryListVO(SearchBasicTariffSummaryListVO searchBasicTariffSummaryListVO) {
		this.searchBasicTariffSummaryListVO = searchBasicTariffSummaryListVO;
	}

	public SearchBasicTariffSummaryListVO[] getSearchBasicTariffSummaryListVOs() {
		return searchBasicTariffSummaryListVOs;
	}

	public void setSearchBasicTariffSummaryListVOs(SearchBasicTariffSummaryListVO[] searchBasicTariffSummaryListVOs) {
		this.searchBasicTariffSummaryListVOs = searchBasicTariffSummaryListVOs;
	}

	public SearchBasicTariffSummaryParamVO getSearchBasicTariffSummaryParamVO() {
		return searchBasicTariffSummaryParamVO;
	}

	public void setSearchBasicTariffSummaryParamVO(SearchBasicTariffSummaryParamVO searchBasicTariffSummaryParamVO) {
		this.searchBasicTariffSummaryParamVO = searchBasicTariffSummaryParamVO;
	}

}