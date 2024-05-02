/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0044Event.java
*@FileTitle      : Allocation Control by Main Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.15
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.09.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpcAlocPolPodVO;


/**
 * ESM_SPC_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0044Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcAlocPolPodVO spcAlocPolPodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0044MasterListVO searchSpaceAllocation0044MasterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0044MasterListVO[] searchSpaceAllocation0044MasterListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0044DetailListVO searchSpaceAllocation0044DetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0044DetailListVO[] searchSpaceAllocation0044DetailListVOs = null;

	private ConditionVO conditionVO = null;
	
	public EsmSpc0044Event(){}
	
	public void setSpcAlocPolPodVO(SpcAlocPolPodVO spcAlocPolPodVO){
		this.spcAlocPolPodVO = spcAlocPolPodVO;
	}

	public void setSpcAlocPolPodVOS(SpcAlocPolPodVO[] spcAlocPolPodVOs){
		if(spcAlocPolPodVOs != null){
			SpcAlocPolPodVO[] tmpVOs = Arrays.copyOf(spcAlocPolPodVOs, spcAlocPolPodVOs.length);
			this.spcAlocPolPodVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0044MasterListVO(SearchSpaceAllocation0044MasterListVO searchSpaceAllocation0044MasterListVO){
		this.searchSpaceAllocation0044MasterListVO = searchSpaceAllocation0044MasterListVO;
	}

	public void setSearchSpaceAllocation0044MasterListVOS(SearchSpaceAllocation0044MasterListVO[] searchSpaceAllocation0044MasterListVOs){
		if(searchSpaceAllocation0044MasterListVOs != null){
			SearchSpaceAllocation0044MasterListVO[] tmpVOs = Arrays.copyOf(searchSpaceAllocation0044MasterListVOs, searchSpaceAllocation0044MasterListVOs.length);
			this.searchSpaceAllocation0044MasterListVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0044DetailListVO(SearchSpaceAllocation0044DetailListVO searchSpaceAllocation0044DetailListVO){
		this.searchSpaceAllocation0044DetailListVO = searchSpaceAllocation0044DetailListVO;
	}

	public void setSearchSpaceAllocation0044DetailListVOS(SearchSpaceAllocation0044DetailListVO[] searchSpaceAllocation0044DetailListVOs){
		if(searchSpaceAllocation0044DetailListVOs != null){
			SearchSpaceAllocation0044DetailListVO[] tmpVOs = Arrays.copyOf(searchSpaceAllocation0044DetailListVOs, searchSpaceAllocation0044DetailListVOs.length);
			this.searchSpaceAllocation0044DetailListVOs  = tmpVOs;
		}
	}

	public SpcAlocPolPodVO getSpcAlocPolPodVO(){
		return spcAlocPolPodVO;
	}

	public SpcAlocPolPodVO[] getSpcAlocPolPodVOS(){
		SpcAlocPolPodVO[] rtnVOs = null;
		if (this.spcAlocPolPodVOs != null) {
			rtnVOs = Arrays.copyOf(spcAlocPolPodVOs, spcAlocPolPodVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0044MasterListVO getSearchSpaceAllocation0044MasterListVO(){
		return searchSpaceAllocation0044MasterListVO;
	}

	public SearchSpaceAllocation0044MasterListVO[] getSearchSpaceAllocation0044MasterListVOS(){
		SearchSpaceAllocation0044MasterListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0044MasterListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceAllocation0044MasterListVOs, searchSpaceAllocation0044MasterListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0044DetailListVO getSearchSpaceAllocation0044DetailListVO(){
		return searchSpaceAllocation0044DetailListVO;
	}

	public SearchSpaceAllocation0044DetailListVO[] getSearchSpaceAllocation0044DetailListVOS(){
		SearchSpaceAllocation0044DetailListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0044DetailListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceAllocation0044DetailListVOs, searchSpaceAllocation0044DetailListVOs.length);
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