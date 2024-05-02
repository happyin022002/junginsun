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
*
* History
* 2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
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

public class EsmSpc0046Event extends EventSupport {

private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0042MListVO searchSpaceAllocation0042MListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0042MListVO[] searchSpaceAllocation0042MListVOs = null;


	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcAlocPolPodVO spcAlocPolPodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;
	
	public EsmSpc0046Event(){}
	
	private String grpAcct = null;
	
	
	public void setSearchSpaceAllocation0042MListVO(SearchSpaceAllocation0042MListVO searchSpaceAllocation0042MListVO){
		this. searchSpaceAllocation0042MListVO = searchSpaceAllocation0042MListVO;
	}

	public void setSearchSpaceAllocation0042MListVOS(SearchSpaceAllocation0042MListVO[] searchSpaceAllocation0042MListVOs){
		if (searchSpaceAllocation0042MListVOs != null) {
			SearchSpaceAllocation0042MListVO[] tmpVOs = new SearchSpaceAllocation0042MListVO[searchSpaceAllocation0042MListVOs.length];
			System.arraycopy(searchSpaceAllocation0042MListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0042MListVOs = tmpVOs;
		}
	}

	public SearchSpaceAllocation0042MListVO getSearchSpaceAllocation0042MListVO(){
		return searchSpaceAllocation0042MListVO;
	}

	public SearchSpaceAllocation0042MListVO[] getSearchSpaceAllocation0042MListVOS(){
		SearchSpaceAllocation0042MListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0042MListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0042MListVO[searchSpaceAllocation0042MListVOs.length];
			System.arraycopy(searchSpaceAllocation0042MListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	
	public void setSpcAlocPolPodVO(SpcAlocPolPodVO spcAlocPolPodVO){
		this. spcAlocPolPodVO = spcAlocPolPodVO;
	}

	public void setSpcAlocPolPodVOS(SpcAlocPolPodVO[] spcAlocPolPodVOs){
		if (spcAlocPolPodVOs != null) {
			SpcAlocPolPodVO[] tmpVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocPolPodVOs = tmpVOs;
		}
		this. spcAlocPolPodVOs = spcAlocPolPodVOs;
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
	
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	public String getGrpAcct() {
		return grpAcct;
	}

	public void setGrpAcct(String grpAcct) {
		this.grpAcct = grpAcct;
	}

}