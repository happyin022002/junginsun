/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_168Event.java
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
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import com.clt.apps.opus.esm.coa.common.event.COAEvent;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.MultiSimSummaryRptVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.framework.core.controller.html.HTMLAction;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 * ESM_COA_0168 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_COA_0168HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Eun Ju
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0168Event extends COAEvent {
	private static final long serialVersionUID = 1L;
	private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;
	private SearchSimLaneListConditionVO[] searchSimLaneListConditionVOS = null;
	
	//SJH.20150507.소스품질
	public SearchSimLaneListConditionVO[] getSearchSimLaneListConditionVOS() {
		SearchSimLaneListConditionVO[] rtnVOs = null;
		if (this.searchSimLaneListConditionVOS != null) {
			rtnVOs = Arrays.copyOf(searchSimLaneListConditionVOS, searchSimLaneListConditionVOS.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSearchSimLaneListConditionVOS(SearchSimLaneListConditionVO[] searchSimLaneListConditionVOS){
		if(searchSimLaneListConditionVOS != null){
			SearchSimLaneListConditionVO[] tmpVOs = Arrays.copyOf(searchSimLaneListConditionVOS, searchSimLaneListConditionVOS.length);
			this.searchSimLaneListConditionVOS = tmpVOs;
		}
	}

	private MultiSimSummaryRptVO multiSimSummaryRptVO = null;
	private MultiSimSummaryRptVO[] multiSimSummaryRptVOS = null;
	
	//SJH.20150507.소스품질
	public MultiSimSummaryRptVO[] getMultiSimSummaryRptVOS() {
		MultiSimSummaryRptVO[] rtnVOs = null;
		if (this.multiSimSummaryRptVOS != null) {
			rtnVOs = Arrays.copyOf(multiSimSummaryRptVOS, multiSimSummaryRptVOS.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setMultiSimSummaryRptVOS(MultiSimSummaryRptVO[] multiSimSummaryRptVOS){
		if(multiSimSummaryRptVOS != null){
			MultiSimSummaryRptVO[] tmpVOs = Arrays.copyOf(multiSimSummaryRptVOS, multiSimSummaryRptVOS.length);
			this.multiSimSummaryRptVOS = tmpVOs;
		}
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
	 * EsmCoa0168Event 생성자함수
	 */
	public EsmCoa0168Event(){
		//
	}
	
    /**
     * EsmCoa0168Event명 반환
     */
	public String getEventName() {
		return "EsmCoa0168Event";
	}

	/**
	 * EsmCoa0168Event명 반환
	 */
	public String toString() {
		return "EsmCoa0168Event";
	}

}
