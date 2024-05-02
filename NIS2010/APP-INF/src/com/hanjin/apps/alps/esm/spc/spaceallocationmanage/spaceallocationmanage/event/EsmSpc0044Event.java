/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0044Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.15 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0044MasterListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;


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
	private SpcAlocCustPolPodVO spcAlocCustPolPodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;
	private SpcAlocCustPolPodVO[] spcAlocCustPolPodVOs = null;

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
		this. spcAlocPolPodVO = spcAlocPolPodVO;
	}

	public void setSpcAlocPolPodVOS(SpcAlocPolPodVO[] spcAlocPolPodVOs){
		if (spcAlocPolPodVOs != null) {
			SpcAlocPolPodVO[] tmpVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocPolPodVOs = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0044MasterListVO(SearchSpaceAllocation0044MasterListVO searchSpaceAllocation0044MasterListVO){
		this. searchSpaceAllocation0044MasterListVO = searchSpaceAllocation0044MasterListVO;
	}

	public void setSearchSpaceAllocation0044MasterListVOS(SearchSpaceAllocation0044MasterListVO[] searchSpaceAllocation0044MasterListVOs){
		if (searchSpaceAllocation0044MasterListVOs != null) {
			SearchSpaceAllocation0044MasterListVO[] tmpVOs = new SearchSpaceAllocation0044MasterListVO[searchSpaceAllocation0044MasterListVOs.length];
			System.arraycopy(searchSpaceAllocation0044MasterListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0044MasterListVOs = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0044DetailListVO(SearchSpaceAllocation0044DetailListVO searchSpaceAllocation0044DetailListVO){
		this. searchSpaceAllocation0044DetailListVO = searchSpaceAllocation0044DetailListVO;
	}

	public void setSearchSpaceAllocation0044DetailListVOS(SearchSpaceAllocation0044DetailListVO[] searchSpaceAllocation0044DetailListVOs){
		if (searchSpaceAllocation0044DetailListVOs != null) {
			SearchSpaceAllocation0044DetailListVO[] tmpVOs = new SearchSpaceAllocation0044DetailListVO[searchSpaceAllocation0044DetailListVOs.length];
			System.arraycopy(searchSpaceAllocation0044DetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0044DetailListVOs = tmpVOs;
		}
	}

	public SpcAlocPolPodVO getSpcAlocPolPodVO(){
		return spcAlocPolPodVO;
	}

	public SpcAlocPolPodVO[] getSpcAlocPolPodVOS(){
		SpcAlocPolPodVO[] rtnVOs = null;
		if (this.spcAlocPolPodVOs != null) {
			rtnVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0044MasterListVO getSearchSpaceAllocation0044MasterListVO(){
		return searchSpaceAllocation0044MasterListVO;
	}

	public SearchSpaceAllocation0044MasterListVO[] getSearchSpaceAllocation0044MasterListVOS(){
		SearchSpaceAllocation0044MasterListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0044MasterListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0044MasterListVO[searchSpaceAllocation0044MasterListVOs.length];
			System.arraycopy(searchSpaceAllocation0044MasterListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0044DetailListVO getSearchSpaceAllocation0044DetailListVO(){
		return searchSpaceAllocation0044DetailListVO;
	}

	public SearchSpaceAllocation0044DetailListVO[] getSearchSpaceAllocation0044DetailListVOS(){
		SearchSpaceAllocation0044DetailListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0044DetailListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0044DetailListVO[searchSpaceAllocation0044DetailListVOs.length];
			System.arraycopy(searchSpaceAllocation0044DetailListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	public SpcAlocCustPolPodVO getSpcAlocCustPolPodVO() {
		return spcAlocCustPolPodVO;
	}

	public void setSpcAlocCustPolPodVO(SpcAlocCustPolPodVO spcAlocCustPolPodVO) {
		this.spcAlocCustPolPodVO = spcAlocCustPolPodVO;
	}

	public SpcAlocCustPolPodVO[] getSpcAlocCustPolPodVOs() {
		SpcAlocCustPolPodVO[] rtnVOs = null;
		if (this.spcAlocCustPolPodVOs != null) {
			rtnVOs = new SpcAlocCustPolPodVO[spcAlocCustPolPodVOs.length];
			System.arraycopy(spcAlocCustPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSpcAlocCustPolPodVOs(SpcAlocCustPolPodVO[] spcAlocCustPolPodVOs) {
		if (spcAlocCustPolPodVOs != null) {
			SpcAlocCustPolPodVO[] tmpVOs = new SpcAlocCustPolPodVO[spcAlocCustPolPodVOs.length];
			System.arraycopy(spcAlocCustPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocCustPolPodVOs = tmpVOs;
		}
	}

}