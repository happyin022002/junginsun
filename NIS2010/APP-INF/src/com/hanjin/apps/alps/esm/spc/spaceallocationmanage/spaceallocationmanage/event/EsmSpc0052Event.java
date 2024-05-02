/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0052Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 占쎌뮇湲쏙옙占�
*@LastVersion : 1.0
* 2009.09.22 占쎌뮇湲쏙옙占�
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 占쎄쑬以덌옙�븍뱜 - 占쎄퉮�붹묾占쏙옙醫딅궗占쎈똻��揶쏆뮇苑묕옙占쏙옙袁る립 T/F�곕뗄彛�
* 2015.06.11 繹먲옙苑�옙占�CHM-201535211] SPC BKG 占쎄퀡猷�
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.CustomerControlGroupVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchOfficeBKGInControlVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchOfficeInControlVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;

/**
 * ESM_SPC_0053 占쏙옙占쏙옙釉�PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0053HTMLAction占쎈Ŋ苑�占쎈쵐苑�br>
 * - ServiceCommand Layer嚥∽옙占쎄쑬�뽳옙�롫뮉 PDTO嚥∽옙占싼딆뒠<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0053HTMLAction 筌〓챷��
 * @since J2EE 1.6
 */


public class EsmSpc0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 鈺곌퀬��鈺곌퀗援�獄쏉옙占썩몿援�筌ｌ꼶�� */
	private SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO = null;
	
	/** Table Value Object Multi Data 筌ｌ꼶��*/
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
