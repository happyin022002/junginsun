/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0053Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;


/**
 * ESM_SPC_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0053ManageListVO searchSpaceAllocation0053ManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0053ManageListVO[] searchSpaceAllocation0053ManageListVOs = null;

	private ConditionVO conditionVO = null;
	
	public EsmSpc0053Event(){}
	
	public void setSearchSpaceAllocation0053ManageListVO(SearchSpaceAllocation0053ManageListVO searchSpaceAllocation0053ManageListVO){
		this. searchSpaceAllocation0053ManageListVO = searchSpaceAllocation0053ManageListVO;
	}

	public void setSearchSpaceAllocation0053ManageListVOS(SearchSpaceAllocation0053ManageListVO[] searchSpaceAllocation0053ManageListVOs){
		if (searchSpaceAllocation0053ManageListVOs != null) {
			SearchSpaceAllocation0053ManageListVO[] tmpVOs = new SearchSpaceAllocation0053ManageListVO[searchSpaceAllocation0053ManageListVOs.length];
			System.arraycopy(searchSpaceAllocation0053ManageListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0053ManageListVOs = tmpVOs;
		}
	}

	public SearchSpaceAllocation0053ManageListVO getSearchSpaceAllocation0053ManageListVO(){
		return searchSpaceAllocation0053ManageListVO;
	}

	public SearchSpaceAllocation0053ManageListVO[] getSearchSpaceAllocation0053ManageListVOS(){
		SearchSpaceAllocation0053ManageListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0053ManageListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0053ManageListVO[searchSpaceAllocation0053ManageListVOs.length];
			System.arraycopy(searchSpaceAllocation0053ManageListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

}