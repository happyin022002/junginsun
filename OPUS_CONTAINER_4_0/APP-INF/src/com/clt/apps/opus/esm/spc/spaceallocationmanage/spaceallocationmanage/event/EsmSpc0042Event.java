/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0042Event.java
*@FileTitle      : Control by HO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.29
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.07.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042DetailListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpcAlocCtrlOptVO;
import com.clt.syscommon.common.table.SpcAlocPolPodVO;

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
	private SpcAlocCtrlOptVO spcAlocCtrlOptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;
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
		this.spcAlocPolPodVO = spcAlocPolPodVO;
	}

	public void setSpcAlocPolPodVOS(SpcAlocPolPodVO[] spcAlocPolPodVOs){
		if(spcAlocPolPodVOs != null){
			SpcAlocPolPodVO[] tmpVOs = Arrays.copyOf(spcAlocPolPodVOs, spcAlocPolPodVOs.length);
			this.spcAlocPolPodVOs  = tmpVOs;
		}
	}
	
	public void setSpcAlocCtrlOptVO(SpcAlocCtrlOptVO spcAlocCtrlOptVO){
		this.spcAlocCtrlOptVO = spcAlocCtrlOptVO;
	}

	public void setSpcAlocCtrlOptVOS(SpcAlocCtrlOptVO[] spcAlocCtrlOptVOs){
		if(spcAlocCtrlOptVOs != null){
			SpcAlocCtrlOptVO[] tmpVOs = Arrays.copyOf(spcAlocCtrlOptVOs, spcAlocCtrlOptVOs.length);
			this.spcAlocCtrlOptVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0042DetailListVO(SearchSpaceAllocation0042DetailListVO searchSpaceAllocation0042DetailListVO){
		this.searchSpaceAllocation0042DetailListVO = searchSpaceAllocation0042DetailListVO;
	}

	public void setSearchSpaceAllocation0042DetailListVOS(SearchSpaceAllocation0042DetailListVO[] searchSpaceAllocation0042DetailListVOs){
		if(searchSpaceAllocation0042DetailListVOs != null){
			SearchSpaceAllocation0042DetailListVO[] tmpVOs = Arrays.copyOf(searchSpaceAllocation0042DetailListVOs, searchSpaceAllocation0042DetailListVOs.length);
			this.searchSpaceAllocation0042DetailListVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceAllocation0042MListVO(SearchSpaceAllocation0042MListVO searchSpaceAllocation0042MListVO){
		this.searchSpaceAllocation0042MListVO = searchSpaceAllocation0042MListVO;
	}

	public void setSearchSpaceAllocation0042MListVOS(SearchSpaceAllocation0042MListVO[] searchSpaceAllocation0042MListVOs){
		if(searchSpaceAllocation0042MListVOs != null){
			SearchSpaceAllocation0042MListVO[] tmpVOs = Arrays.copyOf(searchSpaceAllocation0042MListVOs, searchSpaceAllocation0042MListVOs.length);
			this.searchSpaceAllocation0042MListVOs  = tmpVOs;
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
	
	public SpcAlocCtrlOptVO getSpcAlocCtrlOptVO(){
		return spcAlocCtrlOptVO;
	}

	public SpcAlocCtrlOptVO[] getSpcAlocCtrlOptVOS(){
		SpcAlocCtrlOptVO[] rtnVOs = null;
		if (this.spcAlocCtrlOptVOs != null) {
			rtnVOs = Arrays.copyOf(spcAlocCtrlOptVOs, spcAlocCtrlOptVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0042DetailListVO getSearchSpaceAllocation0042DetailListVO(){
		return searchSpaceAllocation0042DetailListVO;
	}

	public SearchSpaceAllocation0042DetailListVO[] getSearchSpaceAllocation0042DetailListVOS(){
		SearchSpaceAllocation0042DetailListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0042DetailListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceAllocation0042DetailListVOs, searchSpaceAllocation0042DetailListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceAllocation0042MListVO getSearchSpaceAllocation0042MListVO(){
		return searchSpaceAllocation0042MListVO;
	}

	public SearchSpaceAllocation0042MListVO[] getSearchSpaceAllocation0042MListVOS(){
		SearchSpaceAllocation0042MListVO[] rtnVOs = null;
		if (this.searchSpaceAllocation0042MListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceAllocation0042MListVOs, searchSpaceAllocation0042MListVOs.length);
		}
		return rtnVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this.conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}