/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0103Event.java
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2007-12-19
*@LastModifier : Jun Ho Kim
*@LastVersion : 1.0
* 2007-12-19 Jun Ho Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.usarailperformance.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.report.usarailperformance.vo.SearchRailPerformanceVO;


/**
 * ESD_TRS_102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Ho Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0103Event extends EventSupport {

	
	private SearchRailPerformanceVO searchRailPerformanceVo = null;

	public EsdTrs0103Event(){}
	
	public SearchRailPerformanceVO getSearchRailPerformanceVo() {
		return searchRailPerformanceVo;
	}

	public void setSearchRailPerformanceVo(SearchRailPerformanceVO searchRailPerformanceVo) {
		this.searchRailPerformanceVo = searchRailPerformanceVo;
	}

	public String getEventName() {
		return "EsdTrs0103Event";
	}

	public String toString() {
		return "EsdTrs0103Event";
	}

}
