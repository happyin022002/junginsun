/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0003Event.java
*@FileTitle : Register Cost Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박상희
*@LastVersion : 1.0
* 2009.07.23 박상희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchSoCodeListVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park sang hee
 * @see ESM_COA_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CostStructureConditionVO searchSoCodeVO = null;
	
	/** Table Value Object  단건 처리  */
	private SearchSoCodeListVO searchSoCodeListVO = null;
	
	/** Table Value Object  멀티 처리  */
	private SearchSoCodeListVO[] searchSoCodeListVOs = null;
	
	public EsmCoa0003Event(){}
	
	public void setCostStructureConditionVO(CostStructureConditionVO searchSoCodeVO){
		this. searchSoCodeVO = searchSoCodeVO;
	}

	public CostStructureConditionVO getCostStructureConditionVO(){
		return searchSoCodeVO;
	}
	
	public void setSearchSoCodeListVO(SearchSoCodeListVO searchSoCodeVO){
		this.searchSoCodeListVO = searchSoCodeVO;
	}

	public SearchSoCodeListVO getSearchSoCodeListVO(){
		return searchSoCodeListVO;
	}
	//SJH.20150508.소스품질
	public void setSearchSoCodeListVOs(SearchSoCodeListVO[] searchSoCodeVOs){
		if(searchSoCodeVOs != null){
			SearchSoCodeListVO[] tmpVOs = Arrays.copyOf(searchSoCodeVOs, searchSoCodeVOs.length);
			this.searchSoCodeListVOs = tmpVOs;
		}
	}
	//SJH.20150508.소스품질
	public SearchSoCodeListVO[] getSearchSoCodeListVOs(){
		SearchSoCodeListVO[] rtnVOs = null;
		if (this.searchSoCodeListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSoCodeListVOs, searchSoCodeListVOs.length);
		}
		return rtnVOs;
	}

}