/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0045Event.java
*@FileTitle      : Bottleneck Check
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.24
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.09.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045QtyListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocationManage045VVDListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocationManage045QtyListVO searchSpaceAllocationManage045QtyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocationManage045QtyListVO[] searchSpaceAllocationManage045QtyListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocationManage045VVDListVO searchSpaceAllocationManage045VVDListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocationManage045VVDListVO[] searchSpaceAllocationManage045VVDListVOs = null;

	private ConditionVO conditionVO = null;
	
	public EsmSpc0045Event(){}
	
	public void setSearchSpaceAllocationManage045QtyListVO(SearchSpaceAllocationManage045QtyListVO searchSpaceAllocationManage045QtyListVO){
		this.searchSpaceAllocationManage045QtyListVO = searchSpaceAllocationManage045QtyListVO;
	}

	public void setSearchSpaceAllocationManage045QtyListVOS(SearchSpaceAllocationManage045QtyListVO[] searchSpaceAllocationManage045QtyListVOs){
		if(searchSpaceAllocationManage045QtyListVOs != null){
			SearchSpaceAllocationManage045QtyListVO[] tmpVOs = Arrays.copyOf(searchSpaceAllocationManage045QtyListVOs, searchSpaceAllocationManage045QtyListVOs.length);
			this.searchSpaceAllocationManage045QtyListVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceAllocationManage045VVDListVO(SearchSpaceAllocationManage045VVDListVO searchSpaceAllocationManage045VVDListVO){
		this.searchSpaceAllocationManage045VVDListVO = searchSpaceAllocationManage045VVDListVO;
	}

	public void setSearchSpaceAllocationManage045VVDListVOS(SearchSpaceAllocationManage045VVDListVO[] searchSpaceAllocationManage045VVDListVOs){
		if(searchSpaceAllocationManage045VVDListVOs != null){
			SearchSpaceAllocationManage045VVDListVO[] tmpVOs = Arrays.copyOf(searchSpaceAllocationManage045VVDListVOs, searchSpaceAllocationManage045VVDListVOs.length);
			this.searchSpaceAllocationManage045VVDListVOs  = tmpVOs;
		}
	}

	public SearchSpaceAllocationManage045QtyListVO getSearchSpaceAllocationManage045QtyListVO(){
		return searchSpaceAllocationManage045QtyListVO;
	}

	public SearchSpaceAllocationManage045QtyListVO[] getSearchSpaceAllocationManage045QtyListVOS(){
		SearchSpaceAllocationManage045QtyListVO[] rtnVOs = null;
		if (this.searchSpaceAllocationManage045QtyListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceAllocationManage045QtyListVOs, searchSpaceAllocationManage045QtyListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocationManage045VVDListVO getSearchSpaceAllocationManage045VVDListVO(){
		return searchSpaceAllocationManage045VVDListVO;
	}

	public SearchSpaceAllocationManage045VVDListVO[] getSearchSpaceAllocationManage045VVDListVOS(){
		SearchSpaceAllocationManage045VVDListVO[] rtnVOs = null;
		if (this.searchSpaceAllocationManage045VVDListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceAllocationManage045VVDListVOs, searchSpaceAllocationManage045VVDListVOs.length);
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