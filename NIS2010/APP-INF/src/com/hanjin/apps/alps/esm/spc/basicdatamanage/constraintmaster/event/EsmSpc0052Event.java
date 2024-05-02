/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0052Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchOfficeInControlVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * ESM_SPC_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0053HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs = null;

	private ConditionVO conditionVO = null;
	
	private SqmQtaLaneOfcVO sqmQtaLaneOfcVO = null;
	
	private SearchOfficeInControlVO searchOfficeInControlVO = null;
	
	private SearchOfficeInControlVO[] searchOfficeInControlVOs = null;
	
	private SearchOfficeBKGInControlVO searchOfficeBKGInControlVO = null;
	
	private SearchOfficeBKGInControlVO[] searchOfficeBKGInControlVOs = null;
	
	private CustomerControlGroupVO customerControlGroupVO = null;
	
	private CustomerControlGroupVO[] customerControlGroupVOs = null;
	
	private String scNo = "";

	
	public EsmSpc0052Event(){}

	/**
	 * @return the searchSpaceAllocationLaneControlOptionVO
	 */
	public SearchSpaceAllocationLaneControlOptionVO getSearchSpaceAllocationLaneControlOptionVO() {
		return searchSpaceAllocationLaneControlOptionVO;
	}


	/**
	 * @param searchSpaceAllocationLaneControlOptionVO the searchSpaceAllocationLaneControlOptionVO to set
	 */
	public void setSearchSpaceAllocationLaneControlOptionVO(SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO) {
		this.searchSpaceAllocationLaneControlOptionVO = searchSpaceAllocationLaneControlOptionVO;
	}


	/**
	 * @return the searchSpaceAllocationLaneControlOptionVOs
	 */
	public SearchSpaceAllocationLaneControlOptionVO[] getSearchSpaceAllocationLaneControlOptionVOs() {
		return searchSpaceAllocationLaneControlOptionVOs;
	}


	/**
	 * @param searchSpaceAllocationLaneControlOptionVOs the searchSpaceAllocationLaneControlOptionVOs to set
	 */
	public void setSearchSpaceAllocationLaneControlOptionVOs(
			SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs) {
		this.searchSpaceAllocationLaneControlOptionVOs = searchSpaceAllocationLaneControlOptionVOs;
	}

	/**
	 * @return ConditionVO
	 */
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param ConditionVO conditionVO
	 */
	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	/**
	 * @param SearchOfficeInControlVO searchOfficeInControlVO
	 */
	public void setSearchOfficeInControlVO( SearchOfficeInControlVO searchOfficeInControlVO ){
		this.searchOfficeInControlVO = searchOfficeInControlVO;
	}
	
	/**
	 * @return SearchOfficeInControlVO
	 */
	public SearchOfficeInControlVO getSearchOfficeInControlVO(){
		return this.searchOfficeInControlVO;
	}
	
	/**
	 * @param SearchOfficeInControlVO[] searchOfficeInControlVOs
	 */
	public void setSearchOfficeInControlVOs( SearchOfficeInControlVO[] searchOfficeInControlVOs ){
		this.searchOfficeInControlVOs = searchOfficeInControlVOs;
	}
	
	/**
	 * @return SearchOfficeInControlVO[]
	 */
	public SearchOfficeInControlVO[] getSearchOfficeInControlVOs(){
		return this.searchOfficeInControlVOs;
	}
	
	
	/**
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 */
	public void setSearchSpaceAllocationControlofficeVO(SqmQtaLaneOfcVO sqmQtaLaneOfcVO){
		this.sqmQtaLaneOfcVO = sqmQtaLaneOfcVO;		
	}
	
	/**
	 * @return SqmQtaLaneOfcVO
	 */
	public SqmQtaLaneOfcVO getSearchSpaceAllocationControlofficeVO(){
		return sqmQtaLaneOfcVO;
	}
	
	/**
	 * @param SearchOfficeBKGInControlVO searchOfficeBKGInControlVO
	 */
	public void setSearchOfficeBKGInControlVO( SearchOfficeBKGInControlVO searchOfficeBKGInControlVO ){
		this.searchOfficeBKGInControlVO = searchOfficeBKGInControlVO;
	}
	
	/**
	 * @return SearchOfficeBKGInControlVO
	 */
	public SearchOfficeBKGInControlVO getSearchOfficeBKGInControlVO(){
		return this.searchOfficeBKGInControlVO;
	}
	
	/**
	 * @param SearchOfficeBKGInControlVO[] searchOfficeInControlVOs
	 */
	public void setSearchOfficeBKGInControlVOs( SearchOfficeBKGInControlVO[] searchOfficeBKGInControlVOs ){
		this.searchOfficeBKGInControlVOs = searchOfficeBKGInControlVOs;
	}
	
	/**
	 * @return SearchOfficeBKGInControlVO[]
	 */
	public SearchOfficeBKGInControlVO[] getSearchOfficeBKGInControlVOs(){
		return this.searchOfficeBKGInControlVOs;
	}
	
	/**
	 * @param SearchOfficeBKGInControlVO searchOfficeBKGInControlVO
	 */
	public void setSearchSpaceAllocationBKGControlofficeVO( SearchOfficeBKGInControlVO searchOfficeBKGInControlVO ){
		this.searchOfficeBKGInControlVO = searchOfficeBKGInControlVO;
	}
	
	/**
	 * @return SearchOfficeBKGInControlVO
	 */
	public SearchOfficeBKGInControlVO getSearchSpaceAllocationBKGControlofficeVO(){
		return this.searchOfficeBKGInControlVO;
	}

	/**
	 * 
	 * @param customerControlGroupVO
	 */
	public void setSearchCustomerControlCodeVO( CustomerControlGroupVO customerControlGroupVO ) {
		this.customerControlGroupVO = customerControlGroupVO;
	}
	
	/**
	 * 
	 * @return CustomerControlGroupVO
	 */
	public CustomerControlGroupVO getSearchCustomerControlCodeVO() {
		return this.customerControlGroupVO;
	}
	
	/**
	 * 
	 * @param customerControlGroupVOs
	 */
	public void setSearchCustomerControlCodeVOs( CustomerControlGroupVO[] customerControlGroupVOs ) {
		this.customerControlGroupVOs = customerControlGroupVOs;
	}
	
	/**
	 * 
	 * @return CustomerControlGroupVO[]
	 */
	public CustomerControlGroupVO[] getSearchCustomerControlCodeVOs() {
		return this.customerControlGroupVOs;
	}
	
	/**
	 * @return scNo
	 */
	public String getScNo() {
		return scNo;
	}

	/**
	 * @param String scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
}
