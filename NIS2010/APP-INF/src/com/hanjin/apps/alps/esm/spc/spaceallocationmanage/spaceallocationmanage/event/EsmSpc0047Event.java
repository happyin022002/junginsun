/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0047Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.03 한상훈
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0047MasterListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;


/**
 * ESM_SPC_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcAlocPolPodVO spcAlocPolPodVO = null;
	private SpcAlocCustPolPodVO spcAlocCustPolPodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;
	private SpcAlocCustPolPodVO[] spcAlocCustPolPodVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0047DetailListVO searchSpaceAllocation0047DetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0047DetailListVO[] searchSpaceAllocation0047DetailListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0047MasterListVO searchSpaceAllocation0047MasterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0047MasterListVO[] searchSpaceAllocation0047MasterListVOs = null;

	
	private ConditionVO conditionVO = null;
	
	
	
	
	
	public EsmSpc0047Event(){}
	
	public void setSpcAlocPolPodVO(SpcAlocPolPodVO spcAlocPolPodVO){
		this. spcAlocPolPodVO = spcAlocPolPodVO;
	}
	
	public void setSpcAlocCustPolPodVO(SpcAlocCustPolPodVO spcAlocCustPolPodVO){
		this. spcAlocCustPolPodVO = spcAlocCustPolPodVO;
	}

	public void setSpcAlocPolPodVOS(SpcAlocPolPodVO[] spcAlocPolPodVOs){
		if (spcAlocPolPodVOs != null) {
			SpcAlocPolPodVO[] tmpVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocPolPodVOs = tmpVOs;
		}
	}
	
	public void setSpcAlocCustPolPodVOS(SpcAlocCustPolPodVO[] spcAlocCustPolPodVOs){
		if (spcAlocCustPolPodVOs != null) {
			SpcAlocCustPolPodVO[] tmpVOs = new SpcAlocCustPolPodVO[spcAlocCustPolPodVOs.length];
			System.arraycopy(spcAlocCustPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocCustPolPodVOs = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0047DetailListVO(SearchSpaceAllocation0047DetailListVO searchSpaceAllocation0047DetailListVO){
		this. searchSpaceAllocation0047DetailListVO = searchSpaceAllocation0047DetailListVO;
	}

	public void setSearchSpaceAllocation0047DetailListVOS(SearchSpaceAllocation0047DetailListVO[] searchSpaceAllocation0047DetailListVOs){
		if (searchSpaceAllocation0047DetailListVOs != null) {
			SearchSpaceAllocation0047DetailListVO[] tmpVOs = new SearchSpaceAllocation0047DetailListVO[searchSpaceAllocation0047DetailListVOs.length];
			System.arraycopy(searchSpaceAllocation0047DetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0047DetailListVOs = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0047MasterListVO(SearchSpaceAllocation0047MasterListVO searchSpaceAllocation0047MasterListVO){
		this. searchSpaceAllocation0047MasterListVO = searchSpaceAllocation0047MasterListVO;
	}

	public void setSearchSpaceAllocation0047MasterListVOS(SearchSpaceAllocation0047MasterListVO[] searchSpaceAllocation0047MasterListVOs){
		if (searchSpaceAllocation0047MasterListVOs != null) {
			SearchSpaceAllocation0047MasterListVO[] tmpVOs = new SearchSpaceAllocation0047MasterListVO[searchSpaceAllocation0047MasterListVOs.length];
			System.arraycopy(searchSpaceAllocation0047MasterListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0047MasterListVOs = tmpVOs;
		}
	}

	public SpcAlocPolPodVO getSpcAlocPolPodVO(){
		return spcAlocPolPodVO;
	}
	
	public SpcAlocCustPolPodVO getSpcAlocCustPolPodVO(){
		return spcAlocCustPolPodVO;
	}

	public SpcAlocPolPodVO[] getSpcAlocPolPodVOS(){
		SpcAlocPolPodVO[] rtnVOs = null;
		if (this.spcAlocPolPodVOs != null) {
			rtnVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public SpcAlocCustPolPodVO[] getSpcAlocCustPolPodVOS(){
		SpcAlocCustPolPodVO[] rtnVOs = null;
		if (this.spcAlocCustPolPodVOs != null) {
			rtnVOs = new SpcAlocCustPolPodVO[spcAlocCustPolPodVOs.length];
			System.arraycopy(spcAlocCustPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchSpaceAllocation0047DetailListVO getSearchSpaceAllocation0047DetailListVO(){
		return searchSpaceAllocation0047DetailListVO;
	}

	public SearchSpaceAllocation0047DetailListVO[] getSearchSpaceAllocation0047DetailListVOS(){
		SearchSpaceAllocation0047DetailListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0047DetailListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0047DetailListVO[searchSpaceAllocation0047DetailListVOs.length];
			System.arraycopy(searchSpaceAllocation0047DetailListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0047MasterListVO getSearchSpaceAllocation0047MasterListVO(){
		return searchSpaceAllocation0047MasterListVO;
	}

	public SearchSpaceAllocation0047MasterListVO[] getSearchSpaceAllocation0047MasterListVOS(){
		SearchSpaceAllocation0047MasterListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0047MasterListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0047MasterListVO[searchSpaceAllocation0047MasterListVOs.length];
			System.arraycopy(searchSpaceAllocation0047MasterListVOs, 0, rtnVOs, 0, rtnVOs.length);
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