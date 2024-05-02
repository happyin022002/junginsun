/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_052Event.java
*@FileTitle : Proforma SKD 조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-06
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-09-06 Park Eun Ju
* 1.0 최초 생성
* 2009.03.31 박상희 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.coa.lanesimulation.event;

import com.hanjin.apps.alps.esm.coa.common.event.COAEvent;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.CreateSimVolProjConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.MergyVolProjConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimCalcVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimLaneRPBListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimPortListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimYardConditionVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchSimYardListVO;
import com.hanjin.apps.alps.esm.coa.lanesimulation.vo.SearchTMLOPDysListVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.syscommon.common.table.CoaSimTmlInfoVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;

/**
 *  1. 기능 : ESM_COA_052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_COA_052HTMLAction에서 작성<br>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Park Eun Ju/2006.09.06<br>
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
 public class EsmCoa0052Event extends COAEvent {
	private static final long serialVersionUID = 1L;
    /**
     * EsmCoa0052Event생성자함수
     */
    public EsmCoa0052Event(){
    	//
    }
    /*
     *  step02 - tab2 1번 sheet 
     */
    private SearchSimLaneRPBListVO searchSimLaneRPBListVO = null;
    private SearchSimLaneRPBListVO[] searchSimLaneRPBListVOS = null;
    private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;
    private MergyVolProjConditionVO mergyVolProjConditionVO = null;
	private MergyVolProjConditionVO[] mergyVolProjConditionVOS = null;
	private CreateSimVolProjConditionVO createSimVolProjConditionVO = null;
	private SearchTMLOPDysListVO searchTMLOPDysListVO = null;
	private SearchTMLOPDysListVO[] searchTMLOPDysListVOS = null;
	private SearchSimPortListVO searchSimPortListVO = null;
	private SearchSimPortListVO[] searchSimPortListVOS = null;
	private SearchSimYardConditionVO searchSimYardConditionVO = null; 
	private SearchSimYardListVO searchSimYardListVO = null;
	private CoaSimTmlInfoVO coaSimTmlInfoVO = null;
	private CoaSimTmlInfoVO[] coaSimTmlInfoVOS = null;
	private SearchSimConditionVO cnditionVO = null;
	private VskPfSkdVO vskPfSkdVO = null;
	private VskPfSkdDtlVO vskPfSkdDtlVO = null;
	private VskPfSkdVO[] vskPfSkdVOs = null;
	private VskPfSkdDtlVO[] vskPfSkdDtlVOs = null;
	private SearchSimCalcVO searchSimCalcVO = null;
	private SearchSimCalcVO[] searchSimCalcVOS = null;
	private PfSkdGRPVO pfSkdGRPVO = null;
	
	public PfSkdGRPVO getPfSkdGRPVO() {
		return pfSkdGRPVO;
	}
	public void setPfSkdGRPVO(PfSkdGRPVO pfSkdGRPVO) {
		this.pfSkdGRPVO = pfSkdGRPVO;
	}
	public VskPfSkdVO getVskPfSkdVO() {
		return vskPfSkdVO;
	}
	public void setVskPfSkdVO(VskPfSkdVO vskPfSkdVO) {
		this.vskPfSkdVO = vskPfSkdVO;
	}
	public VskPfSkdDtlVO getVskPfSkdDtlVO() {
		return vskPfSkdDtlVO;
	}
	public void setVskPfSkdDtlVO(VskPfSkdDtlVO vskPfSkdDtlVO) {
		this.vskPfSkdDtlVO = vskPfSkdDtlVO;
	}
	public VskPfSkdVO[] getVskPfSkdVOs() {
		return vskPfSkdVOs;
	}
	public void setVskPfSkdVOs(VskPfSkdVO[] vskPfSkdVOs) {
		this.vskPfSkdVOs = vskPfSkdVOs;
	}
	public VskPfSkdDtlVO[] getVskPfSkdDtlVOs() {
		return vskPfSkdDtlVOs;
	}
	public void setVskPfSkdDtlVOs(VskPfSkdDtlVO[] vskPfSkdDtlVOs) {
		this.vskPfSkdDtlVOs = vskPfSkdDtlVOs;
	}
	public void setSearchSimConditionVO(SearchSimConditionVO cnditionVO){
		this. cnditionVO = cnditionVO;
	}
	public SearchSimConditionVO getSearchSimConditionVO(){
		return this.cnditionVO;
	}
	public SearchSimCalcVO getSearchSimCalcVO() {
		return searchSimCalcVO;
	}

	public SearchSimPortListVO[] getSearchSimPortListVOS() {
		return searchSimPortListVOS;
	}
	public void setSearchSimCalcVO(SearchSimCalcVO searchSimCalcVO) {
		this.searchSimCalcVO = searchSimCalcVO;
	}
	
	public SearchSimCalcVO[] getSearchSimCalcVOS() {
		return searchSimCalcVOS;
	}

	public void setSearchSimCalcVOS(SearchSimCalcVO[] searchSimCalcVOS) {
		this.searchSimCalcVOS = searchSimCalcVOS;
	}

	public CoaSimTmlInfoVO[] getCoaSimTmlInfoVOS() {
		return coaSimTmlInfoVOS;
	}

	public void setCoaSimTmlInfoVOS(CoaSimTmlInfoVO[] coaSimTmlInfoVOS) {
		this.coaSimTmlInfoVOS = coaSimTmlInfoVOS;
	}

	public CoaSimTmlInfoVO getCoaSimTmlInfoVO() {
		return coaSimTmlInfoVO;
	}

	public void setCoaSimTmlInfoVO(CoaSimTmlInfoVO coaSimTmlInfoVO) {
		this.coaSimTmlInfoVO = coaSimTmlInfoVO;
	}
	
	public SearchSimYardListVO getSearchSimYardListVO() {
		return searchSimYardListVO;
	}

	public void setSearchSimYardListVO(SearchSimYardListVO searchSimYardListVO) {
		this.searchSimYardListVO = searchSimYardListVO;
	}

	public SearchSimYardConditionVO getSearchSimYardConditionVO() {
		return searchSimYardConditionVO;
	}

	public void setSearchSimYardConditionVO(
			SearchSimYardConditionVO searchSimYardConditionVO) {
		this.searchSimYardConditionVO = searchSimYardConditionVO;
	}

	public SearchSimPortListVO getSearchSimPortListVO() {
		return searchSimPortListVO;
	}

	public void setSearchSimPortListVO(SearchSimPortListVO searchSimPortListVO) {
		this.searchSimPortListVO = searchSimPortListVO;
	}

	public SearchTMLOPDysListVO[] getSearchTMLOPDysListVOS() {
		return searchTMLOPDysListVOS;
	}

	public void setSearchTMLOPDysListVOS(
			SearchTMLOPDysListVO[] searchTMLOPDysListVOS) {
		this.searchTMLOPDysListVOS = searchTMLOPDysListVOS;
	}

	public SearchTMLOPDysListVO getSearchTMLOPDysListVO() {
		return searchTMLOPDysListVO;
	}

	public void setSearchTMLOPDysListVO(SearchTMLOPDysListVO searchTMLOPDysListVO) {
		this.searchTMLOPDysListVO = searchTMLOPDysListVO;
	}
    
	public CreateSimVolProjConditionVO getCreateSimVolProjConditionVO() {
		return createSimVolProjConditionVO;
	}

	public void setCreateSimVolProjConditionVO(
			CreateSimVolProjConditionVO createSimVolProjConditionVO) {
		this.createSimVolProjConditionVO = createSimVolProjConditionVO;
	}

	public MergyVolProjConditionVO getMergyVolProjConditionVO() {
		return mergyVolProjConditionVO;
	}

	public void setMergyVolProjConditionVO(
			MergyVolProjConditionVO mergyVolProjConditionVO) {
		this.mergyVolProjConditionVO = mergyVolProjConditionVO;
	}
    
    public MergyVolProjConditionVO[] getMergyVolProjConditionVOS() {
		return mergyVolProjConditionVOS;
	}

	public void setMergyVolProjConditionVOS(
			MergyVolProjConditionVO[] mergyVolProjConditionVOS) {
		this.mergyVolProjConditionVOS = mergyVolProjConditionVOS;
	}

	public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
		return searchSimLaneListConditionVO;
	}

	public void setSearchSimLaneListConditionVO(
			SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
		this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
	}

	public SearchSimLaneRPBListVO[] getSearchSimLaneRPBListVOS() {
		return searchSimLaneRPBListVOS;
	}

	public void setSearchSimLaneRPBListVOS(
			SearchSimLaneRPBListVO[] searchSimLaneRPBListVOS) {
		this.searchSimLaneRPBListVOS = searchSimLaneRPBListVOS;
	}

	public SearchSimLaneRPBListVO getSearchSimLaneRPBListVO() {
		return searchSimLaneRPBListVO;
	}

	public void setSearchSimLaneRPBListVO(
			SearchSimLaneRPBListVO searchSimLaneRPBListVO) {
		this.searchSimLaneRPBListVO = searchSimLaneRPBListVO;
	}

	public void setSearchSimPortListVOS(SearchSimPortListVO[] searchSimPortListVOS) {
		this.searchSimPortListVOS = searchSimPortListVOS;
	}

	/**
     * Event 명을 반환한다.
     */
    public String getEventName() {
        return "EsmCoa0052Event";
    }

    /**
     * Event 명을 반환한다.
     */
    public String toString() {
        return "EsmCoa0052Event";
    }

}
