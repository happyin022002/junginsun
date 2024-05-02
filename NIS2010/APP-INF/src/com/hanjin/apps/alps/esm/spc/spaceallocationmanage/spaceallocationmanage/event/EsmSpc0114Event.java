/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0114Event.java
*@FileTitle : Import Control Option Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
* 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationLaneControlOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocationLaneControlOptionVO searchSpaceAllocationLaneControlOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocationLaneControlOptionVO[] searchSpaceAllocationLaneControlOptionVOs = null;

	private ConditionVO conditionVO = null;
	
	public EsmSpc0114Event(){}

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


	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

}