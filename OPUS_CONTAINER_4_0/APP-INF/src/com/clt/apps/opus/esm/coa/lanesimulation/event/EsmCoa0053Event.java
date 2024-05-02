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
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import com.clt.apps.opus.esm.coa.common.event.COAEvent;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.CreateSimDailyHireVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimBunkerListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimCgoCostConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimDailyHireInfoVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimPortChargeListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.syscommon.common.table.CoaSimBnkCostVO;
import com.clt.syscommon.common.table.CoaSimCtrbMgnCostVO;
import com.clt.syscommon.common.table.CoaSimDlyHirVO;
import com.clt.syscommon.common.table.CoaSimPortChgVO;
import java.util.Arrays;									//SJH.20150507.소스품질

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
	/* Table VO*/	//SJH.20150507.소스품질
	public CoaSimDlyHirVO[] getSimDlyHirVOS() {
		CoaSimDlyHirVO[] rtnVOs = null;
		if (this.simDlyHirVOS != null) {
			rtnVOs = Arrays.copyOf(simDlyHirVOS, simDlyHirVOS.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSimDlyHirVOS(CoaSimDlyHirVO[] simDlyHirVOS){
		if(simDlyHirVOS != null){
			CoaSimDlyHirVO[] tmpVOs = Arrays.copyOf(simDlyHirVOS, simDlyHirVOS.length);
			this.simDlyHirVOS = tmpVOs;
		}
	}	
	//SJH.20150507.소스품질
	public CoaSimCtrbMgnCostVO[] getSimCtrbMgnCostVOS() {
		CoaSimCtrbMgnCostVO[] rtnVOs = null;
		if (this.simCtrbMgnCostVOS != null) {
			rtnVOs = Arrays.copyOf(simCtrbMgnCostVOS, simCtrbMgnCostVOS.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSimCtrbMgnCostVOS(CoaSimCtrbMgnCostVO[] simCtrbMgnCostVOS){
		if(simCtrbMgnCostVOS != null){
			CoaSimCtrbMgnCostVO[] tmpVOs = Arrays.copyOf(simCtrbMgnCostVOS, simCtrbMgnCostVOS.length);
			this.simCtrbMgnCostVOS = tmpVOs;
		}
	}
	//SJH.20150507.소스품질
	public CoaSimPortChgVO[] getSimPortChgVOS() {
		CoaSimPortChgVO[] rtnVOs = null;
		if (this.simPortChgVOS != null) {
			rtnVOs = Arrays.copyOf(simPortChgVOS, simPortChgVOS.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSimPortChgVOS(CoaSimPortChgVO[] simPortChgVOS){
		if(simPortChgVOS != null){
			CoaSimPortChgVO[] tmpVOs = Arrays.copyOf(simPortChgVOS, simPortChgVOS.length);
			this.simPortChgVOS = tmpVOs;
		}
	}
	//SJH.20150507.소스품질
	public CoaSimBnkCostVO[] getSimBnkCostVOS() {
		CoaSimBnkCostVO[] rtnVOs = null;
		if (this.simBnkVOS != null) {
			rtnVOs = Arrays.copyOf(simBnkVOS, simBnkVOS.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSimBnkCostVOS(CoaSimBnkCostVO[] simBnkVOS){
		if(simBnkVOS != null){
			CoaSimBnkCostVO[] tmpVOs = Arrays.copyOf(simBnkVOS, simBnkVOS.length);
			this.simBnkVOS = tmpVOs;
		}
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
	
	//SJH.20150507.소스품질
	public SearchSimPortChargeListVO[] getSearchSimPortChargeListVOS() {
		SearchSimPortChargeListVO[] rtnVOs = null;
		if (this.portChargerVO != null) {
			rtnVOs = Arrays.copyOf(portChargerVO, portChargerVO.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSearchSimPortChargeListVOS(SearchSimPortChargeListVO[] portChargerVO){
		if(portChargerVO != null){
			SearchSimPortChargeListVO[] tmpVOs = Arrays.copyOf(portChargerVO, portChargerVO.length);
			this.portChargerVO = tmpVOs;
		}
	}
	//SJH.20150507.소스품질
	public SearchSimBunkerListVO[] getSearchSimBunkerListVOS() {
		SearchSimBunkerListVO[] rtnVOs = null;
		if (this.bunkerVO != null) {
			rtnVOs = Arrays.copyOf(bunkerVO, bunkerVO.length);
		}
		return rtnVOs;
	}
	//SJH.20150507.소스품질
	public void setSearchSimBunkerListVOS(SearchSimBunkerListVO[] bunkerVO){
		if(bunkerVO != null){
			SearchSimBunkerListVO[] tmpVOs = Arrays.copyOf(bunkerVO, bunkerVO.length);
			this.bunkerVO = tmpVOs;
		}
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
