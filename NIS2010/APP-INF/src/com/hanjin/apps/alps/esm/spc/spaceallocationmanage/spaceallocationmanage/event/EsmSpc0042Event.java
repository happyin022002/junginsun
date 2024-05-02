/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0042Event.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.29 최윤성
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcAlocCtrlOptVO;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;


/**
 * ESM_SPC_0042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0042HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcAlocPolPodVO spcAlocPolPodVO = null;
	private SpcAlocCustPolPodVO spcAlocCustPolPodVO = null;
	private SpcAlocCtrlOptVO spcAlocCtrlOptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;
	private SpcAlocCustPolPodVO[] spcAlocCustPolPodVOs = null;
	private SpcAlocCtrlOptVO[] spcAlocCtrlOptVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0042DetailListVO searchSpaceAllocation0042DetailListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0042DetailListVO[] searchSpaceAllocation0042DetailListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0042MListVO searchSpaceAllocation0042MListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0042MListVO[] searchSpaceAllocation0042MListVOs = null;

	public EsmSpc0042Event(){}
	
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
	
	public void setSpcAlocCustPolPodVO(SpcAlocCustPolPodVO spcAlocCustPolPodVO){
		this. spcAlocCustPolPodVO = spcAlocCustPolPodVO;
	}
	
	public void setSpcAlocCustPolPodVOS(SpcAlocCustPolPodVO[] spcAlocCustPolPodVOs){
		if (spcAlocCustPolPodVOs != null) {
			SpcAlocCustPolPodVO[] tmpVOs = new SpcAlocCustPolPodVO[spcAlocCustPolPodVOs.length];
			System.arraycopy(spcAlocCustPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocCustPolPodVOs = tmpVOs;
		}
	}
	
	public void setSpcAlocCtrlOptVO(SpcAlocCtrlOptVO spcAlocCtrlOptVO){
		this. spcAlocCtrlOptVO = spcAlocCtrlOptVO;
	}

	public void setSpcAlocCtrlOptVOS(SpcAlocCtrlOptVO[] spcAlocCtrlOptVOs){
		if (spcAlocCtrlOptVOs != null) {
			SpcAlocCtrlOptVO[] tmpVOs = new SpcAlocCtrlOptVO[spcAlocCtrlOptVOs.length];
			System.arraycopy(spcAlocCtrlOptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocCtrlOptVOs = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0042DetailListVO(SearchSpaceAllocation0042DetailListVO searchSpaceAllocation0042DetailListVO){
		this. searchSpaceAllocation0042DetailListVO = searchSpaceAllocation0042DetailListVO;
	}

	public void setSearchSpaceAllocation0042DetailListVOS(SearchSpaceAllocation0042DetailListVO[] searchSpaceAllocation0042DetailListVOs){
		if (searchSpaceAllocation0042DetailListVOs != null) {
			SearchSpaceAllocation0042DetailListVO[] tmpVOs = new SearchSpaceAllocation0042DetailListVO[searchSpaceAllocation0042DetailListVOs.length];
			System.arraycopy(searchSpaceAllocation0042DetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0042DetailListVOs = tmpVOs;
		}
	}

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
	
	public SpcAlocCustPolPodVO getSpcAlocCustPolPodVO(){
		return spcAlocCustPolPodVO;
	}
	
	public SpcAlocCustPolPodVO[] getSpcAlocCustPolPodVOS(){
		SpcAlocCustPolPodVO[] rtnVOs = null;
		if (this.spcAlocCustPolPodVOs != null) {
			rtnVOs = new SpcAlocCustPolPodVO[spcAlocCustPolPodVOs.length];
			System.arraycopy(spcAlocCustPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public SpcAlocCtrlOptVO getSpcAlocCtrlOptVO(){
		return spcAlocCtrlOptVO;
	}

	public SpcAlocCtrlOptVO[] getSpcAlocCtrlOptVOS(){
		SpcAlocCtrlOptVO[] rtnVOs = null;
		if (this.spcAlocCtrlOptVOs != null) {
			rtnVOs = new SpcAlocCtrlOptVO[spcAlocCtrlOptVOs.length];
			System.arraycopy(spcAlocCtrlOptVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0042DetailListVO getSearchSpaceAllocation0042DetailListVO(){
		return searchSpaceAllocation0042DetailListVO;
	}

	public SearchSpaceAllocation0042DetailListVO[] getSearchSpaceAllocation0042DetailListVOS(){
		SearchSpaceAllocation0042DetailListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0042DetailListVOs != null) {
			rtnVOs = new SearchSpaceAllocation0042DetailListVO[searchSpaceAllocation0042DetailListVOs.length];
			System.arraycopy(searchSpaceAllocation0042DetailListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
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
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}