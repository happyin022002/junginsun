/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_107Event.java
*@FileTitle : Expense Summary by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-07
*@LastModifier : jh choi
*@LastVersion : 1.2
* 2009-01-07 jh choi
* 1.0 최초 생성
* @history
* N200901080023 2009-03-04 Expense Summary Report S/P 메뉴개발
* 2012.02.23 금병주 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.event;


import com.hanjin.apps.alps.esd.trs.report.expensesummary.vo.SearchHeaderVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TRS_107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong yeon cho
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0107Event extends EventSupport {
	
	private SearchHeaderVO searchHeaderVO = null;
	
	public EsdTrs0107Event(){}
	
	//grid_flg 추가 2012.02.23 kbj
	private String grid_flg = null;
	
	public String getEventName() {
		return "EsdTrs0107Event";
	}

	public String toString() {
		return "EsdTrs0107Event";
	}

	public void setSearchHeaderVO(SearchHeaderVO searchHeaderVO) {
		this.searchHeaderVO = searchHeaderVO;
	}

	public SearchHeaderVO getSearchHeaderVO() {
		return searchHeaderVO;
	}

	public String getGrid_flg() {
		return grid_flg;
	}

	public void setGrid_flg(String grid_flg) {
		this.grid_flg = grid_flg;
	}
	
	

}
