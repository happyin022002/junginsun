/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0019Event.java
 *@FileTitle : Detail_Yearly Expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.17
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;

import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.DetailYearlyExpenseVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchYearlyExpenseVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * CPS_GEM_0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0019HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0019Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public CpsGem0019Event() {
	}

	/** Popup 처리 판단 */
	public String popup = null;

	public String getPopup() {
		return popup;
	}

	public void setPopup(String popup) {
		this.popup = popup;
	}
	
	private String popYear = "";
	private String popLang = "";
	private String popBuCd = "";
	private String popOfcCd = "";
	private String popExpnCd = "";
		
	public String getPopYear() {
		return popYear;
	}

	public void setPopYear(String popYear) {
		this.popYear = popYear;
	}

	public String getPopLang() {
		return popLang;
	}

	public void setPopLang(String popLang) {
		this.popLang = popLang;
	}

	public String getPopBuCd() {
		return popBuCd;
	}

	public void setPopBuCd(String popBuCd) {
		this.popBuCd = popBuCd;
	}

	public String getPopOfcCd() {
		return popOfcCd;
	}

	public void setPopOfcCd(String popOfcCd) {
		this.popOfcCd = popOfcCd;
	}

	public String getPopExpnCd() {
		return popExpnCd;
	}

	public void setPopExpnCd(String popExpnCd) {
		this.popExpnCd = popExpnCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리 */
	private DetailYearlyExpenseVO detailYearlyExpenseVO = null;
	private SearchYearlyExpenseVO searchYearlyExpenseVO = null;

	/** Table Value Object Multi Data 처리 */
	private DetailYearlyExpenseVO[] detailYearlyExpenseVOs = null;
	private SearchYearlyExpenseVO[] searchYearlyExpenseVOs = null;

	public DetailYearlyExpenseVO getDetailYearlyExpenseVO() {
		return detailYearlyExpenseVO;
	}

	public void setDetailYearlyExpenseVO(
			DetailYearlyExpenseVO detailYearlyExpenseVO) {
		this.detailYearlyExpenseVO = detailYearlyExpenseVO;
	}

	public SearchYearlyExpenseVO getSearchYearlyExpenseVO() {
		return searchYearlyExpenseVO;
	}

	public void setSearchYearlyExpenseVO(
			SearchYearlyExpenseVO searchYearlyExpenseVO) {
		this.searchYearlyExpenseVO = searchYearlyExpenseVO;
	}

	public DetailYearlyExpenseVO[] getDetailYearlyExpenseVOs() {
		return detailYearlyExpenseVOs;
	}

	public void setDetailYearlyExpenseVOs(
			DetailYearlyExpenseVO[] detailYearlyExpenseVOs) {
		this.detailYearlyExpenseVOs = detailYearlyExpenseVOs;
	}

	public SearchYearlyExpenseVO[] getSearchYearlyExpenseVOs() {
		return searchYearlyExpenseVOs;
	}

	public void setSearchYearlyExpenseVOs(
			SearchYearlyExpenseVO[] searchYearlyExpenseVOs) {
		this.searchYearlyExpenseVOs = searchYearlyExpenseVOs;
	}

}