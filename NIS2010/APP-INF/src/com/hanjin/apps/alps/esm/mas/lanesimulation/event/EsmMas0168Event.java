/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_168Event.java
*@FileTitle : Creation (Variant Change)
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-12
*@LastModifier : Ari
*@LastVersion : 1.0
* 2009-03-12 Ari
* 1.0 최초 생성
* =========================================================
* History
* 2009.03.31 임옥영 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.apps.alps.esm.mas.common.event.MASEvent;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.MultiSimSummaryRptVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;


/**
 * ESM_MAS_0168 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_MAS_0168HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Eun Ju
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0168Event extends MASEvent {
	private static final long serialVersionUID = 1L;
	private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;
	private SearchSimLaneListConditionVO[] searchSimLaneListConditionVOS = null;
	public SearchSimLaneListConditionVO[] getSearchSimLaneListConditionVOS() {
		return searchSimLaneListConditionVOS;
	}

	public void setSearchSimLaneListConditionVOS(
			SearchSimLaneListConditionVO[] searchSimLaneListConditionVOS) {
		this.searchSimLaneListConditionVOS = searchSimLaneListConditionVOS;
	}

	private MultiSimSummaryRptVO multiSimSummaryRptVO = null;
	private MultiSimSummaryRptVO[] multiSimSummaryRptVOS = null;
	
	public MultiSimSummaryRptVO[] getMultiSimSummaryRptVOS() {
		return multiSimSummaryRptVOS;
	}

	public void setMultiSimSummaryRptVOS(
			MultiSimSummaryRptVO[] multiSimSummaryRptVOS) {
		this.multiSimSummaryRptVOS = multiSimSummaryRptVOS;
	}

	public MultiSimSummaryRptVO getMultiSimSummaryRptVO() {
		return multiSimSummaryRptVO;
	}

	public void setMultiSimSummaryRptVO(MultiSimSummaryRptVO multiSimSummaryRptVO) {
		this.multiSimSummaryRptVO = multiSimSummaryRptVO;
	}

	public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
		return searchSimLaneListConditionVO;
	}

	public void setSearchSimLaneListConditionVO(
			SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
		this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
	}

	/**
	 * EsmMas0168Event 생성자함수
	 */
	public EsmMas0168Event(){
		//
	}
	
    /**
     * EsmMas0168Event명 반환
     */
	public String getEventName() {
		return "EsmMas0168Event";
	}

	/**
	 * EsmMas0168Event명 반환
	 */
	public String toString() {
		return "EsmMas0168Event";
	}

}
