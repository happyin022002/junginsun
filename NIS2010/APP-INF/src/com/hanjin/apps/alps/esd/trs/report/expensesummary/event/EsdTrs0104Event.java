/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_104Event.java
*@FileTitle : Expense Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009-01-08
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2009-01-08 ah young Han
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* N200901080024  2009-02-27 'Report(Expense Summary by Office) 메뉴 개발 요청 '
* 2012.02.15 금병주 1.6 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.event;

import com.hanjin.apps.alps.esd.trs.report.expensesummary.vo.SearchHeaderVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TRS_104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ah young Han
 * @see HTMLAction 참조
 * @since J2EE 1.4    
 */  
public class EsdTrs0104Event extends EventSupport {
	
	//grid_flg 추가 2012.02.15 kbj
	private String grid_flg = null;
	
	private SearchHeaderVO searchHeaderVO = null;
	
	public EsdTrs0104Event(){}

	public String getEventName() {
		return "EsdTrs0104Event";
	}

	public String toString() {
		return "EsdTrs0104Event";
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
