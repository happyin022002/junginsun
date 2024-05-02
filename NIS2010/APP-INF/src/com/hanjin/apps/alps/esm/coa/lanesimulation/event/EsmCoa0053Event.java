/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_053Event.java
*@FileTitle : 항로_구간별 물량 Forecast 생성/조회/변경 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-09-07 Park Eun Ju
* 1.0 최초 생성
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import com.hanjin.apps.alps.esm.coa.common.event.COAEvent;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.CreateSimDailyHireVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimBunkerListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimCgoCostConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimDailyHireInfoVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimPortChargeListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.syscommon.common.table.CoaSimBnkCostVO;
import com.hanjin.syscommon.common.table.CoaSimCtrbMgnCostVO;
import com.hanjin.syscommon.common.table.CoaSimDlyHirVO;
import com.hanjin.syscommon.common.table.CoaSimPortChgVO;


/**
 *  1. 기능 : ESM_COA_053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_COA_053HTMLAction에서 작성<br>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Park Eun Ju/2006.09.07<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 * @author Park Eun Ju
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmCoa0053Event extends COAEvent {
	private static final long serialVersionUID = 1L;
	/* Search Condition VO */
	private SearchSimConditionVO cnditionVO = null;
	
	/* Table VO*/
	private CoaSimCtrbMgnCostVO[] simCtrbMgnCostVOS = null;
	private CoaSimPortChgVO[] simPortChgVOS = null;
	private CoaSimBnkCostVO[] simBnkVOS = null;
	private CoaSimCtrbMgnCostVO coaSimCtrbMgnCostVO = null;
	private CoaSimDlyHirVO[] simDlyHirVOS = null;

	/* Search List VO*/
	private SearchSimCgoCostConditionVO searchSimCgoCostConditionVO = null;
	private SearchSimPortChargeListVO[] portChargerVO = null;
	private SearchSimBunkerListVO[] bunkerVO = null;
	private SearchSimDailyHireInfoVO searchSimDailyHireInfoVO = null;
	private CreateSimDailyHireVO createSimDailyHireVO = null;
	private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;

	public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
		return searchSimLaneListConditionVO;
	}

	public void setSearchSimLaneListConditionVO(
			SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
		this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
	}

	/* Search Condition VO */
	public void setSearchSimDailyHireInfoVO(
			SearchSimDailyHireInfoVO searchSimDailyHireInfoVO) {
		this.searchSimDailyHireInfoVO = searchSimDailyHireInfoVO;
	}
	
	public void setSearchSimConditionVO(SearchSimConditionVO cnditionVO){
		this. cnditionVO = cnditionVO;
	}
	
	public SearchSimConditionVO getSearchSimConditionVO(){
		return this.cnditionVO;
	}

	public CreateSimDailyHireVO getCreateSimDailyHireVO() {
		return createSimDailyHireVO;
	}

	public void setCreateSimDailyHireVO(CreateSimDailyHireVO createSimDailyHireVO) {
		this.createSimDailyHireVO = createSimDailyHireVO;
	}	
	/* Table VO*/
	public CoaSimDlyHirVO[] getSimDlyHirVOS() {
		return simDlyHirVOS;
	}

	public void setSimDlyHirVOS(CoaSimDlyHirVO[] simDlyHirVOS) {
		this.simDlyHirVOS = simDlyHirVOS;
	}	
	public CoaSimCtrbMgnCostVO[] getSimCtrbMgnCostVOS() {
		return simCtrbMgnCostVOS;
	}

	public void setSimCtrbMgnCostVOS(CoaSimCtrbMgnCostVO[] simCtrbMgnCostVOS) {
		this.simCtrbMgnCostVOS = simCtrbMgnCostVOS;
	}
	
	public CoaSimPortChgVO[] getSimPortChgVOS() {
		return simPortChgVOS;
	}
	
	public void setSimPortChgVOS(CoaSimPortChgVO[] simPortChgVOS) {
		this.simPortChgVOS = simPortChgVOS;
	}
	
	public CoaSimBnkCostVO[] getSimBnkCostVOS() {
		return simBnkVOS;
	}
	
	public void setSimBnkCostVOS(CoaSimBnkCostVO[] simBnkVOS) {
		this.simBnkVOS = simBnkVOS;
	}
	public CoaSimCtrbMgnCostVO getCoaSimCtrbMgnCostVO() {
		return coaSimCtrbMgnCostVO;
	}

	public void setCoaSimCtrbMgnCostVO(CoaSimCtrbMgnCostVO coaSimCtrbMgnCostVO) {
		this.coaSimCtrbMgnCostVO = coaSimCtrbMgnCostVO;
	}
	
	/* Search List VO*/
	public SearchSimDailyHireInfoVO getSearchSimDailyHireInfoVO() {
		return searchSimDailyHireInfoVO;
	}
	
	public SearchSimCgoCostConditionVO getSearchSimCgoCostConditionVO() {
		return searchSimCgoCostConditionVO;
	}

	public void setSearchSimCgoCostConditionVO(SearchSimCgoCostConditionVO searchSimCgoCostConditionVO) {
		this.searchSimCgoCostConditionVO = searchSimCgoCostConditionVO;
	}
	
	public SearchSimPortChargeListVO[] getSearchSimPortChargeListVOS() {
		return portChargerVO;
	}
	
	public void setSearchSimPortChargeListVOS(SearchSimPortChargeListVO[] portChargerVO) {
		this.portChargerVO = portChargerVO;
	}
	
	public SearchSimBunkerListVO[] getSearchSimBunkerListVOS() {
		return bunkerVO;
	}
	
	public void setSearchSimBunkerListVOS(SearchSimBunkerListVO[] bunkerVO) {
		this.bunkerVO = bunkerVO;
	}

	

	/**
     * EsmCoa0053Event 생성자함수
     */
    public EsmCoa0053Event(){
    	//
    }
    
    /**
     * Event 명을 반환한다.
     */
    public String getEventName() {
        return "EsmCoa0053Event";
    }

    /**
     * Event 명을 반환한다.
     */
    public String toString() {
        return "EsmCoa0053Event";
    }

}
