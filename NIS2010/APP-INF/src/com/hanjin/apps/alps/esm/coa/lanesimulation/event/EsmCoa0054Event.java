/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_054Event.java
*@FileTitle : 항로 Simulation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-26
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-09-26 Park Eun Ju
* 1.0 최초 생성
* 2009.03.31 임옥영 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import com.hanjin.apps.alps.esm.coa.common.event.COAEvent;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchReportConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;


/**
 * ESM_COA_054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Eun Ju
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0054Event extends COAEvent {
	private static final long serialVersionUID = 1L;
	private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;
	private SearchReportConditionVO searchReportConditionVO = null;
	public SearchReportConditionVO getSearchReportConditionVO() {
		return searchReportConditionVO;
	}

	public void setSearchReportConditionVO(
			SearchReportConditionVO searchReportConditionVO) {
		this.searchReportConditionVO = searchReportConditionVO;
	}

	public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
		return searchSimLaneListConditionVO;
	}

	public void setSearchSimLaneListConditionVO(
			SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
		this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
	}

	/**
	 * EsmCoa0054Event 생성자함수
	 */
	public EsmCoa0054Event(){
		//
	}
	
    /**
     * EsmCoa0054Event명 반환
     */
	public String getEventName() {
		return "EsmCoa0054Event";
	}

	/**
	 * EsmCoa0054Event명 반환
	 */
	public String toString() {
		return "EsmCoa0054Event";
	}

}
