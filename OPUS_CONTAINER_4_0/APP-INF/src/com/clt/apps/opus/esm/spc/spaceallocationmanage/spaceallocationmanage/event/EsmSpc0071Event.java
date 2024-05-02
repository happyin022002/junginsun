/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0071Event.java
*@FileTitle      : SKD Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.09.29
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.09.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchNoShowDownloadDateListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpcFcastDwnLodSkdVO;


/**
 * ESM_SPC_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0071HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0071Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVesselSKDListVO searchVesselSKDListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVesselSKDListVO[] searchVesselSKDListVOs = null;

	public EsmSpc0071Event(){}
	
	public void setSearchVesselSKDListVO(SearchVesselSKDListVO searchVesselSKDListVO){
		this.searchVesselSKDListVO = searchVesselSKDListVO;
	}

	public void setSearchVesselSKDListVOS(SearchVesselSKDListVO[] searchVesselSKDListVOs){
		if(searchVesselSKDListVOs != null){
			SearchVesselSKDListVO[] tmpVOs = Arrays.copyOf(searchVesselSKDListVOs, searchVesselSKDListVOs.length);
			this.searchVesselSKDListVOs  = tmpVOs;
		}
	}

	public SearchVesselSKDListVO getSearchVesselSKDListVO(){
		return searchVesselSKDListVO;
	}

	public SearchVesselSKDListVO[] getSearchVesselSKDListVOS(){
		SearchVesselSKDListVO[] rtnVOs = null;
		if (this.searchVesselSKDListVOs != null) {
			rtnVOs = Arrays.copyOf(searchVesselSKDListVOs, searchVesselSKDListVOs.length);
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