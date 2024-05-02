/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0003Event.java
*@FileTitle : Register Cost Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 박상희
*@LastVersion : 1.0
* 2009.07.23 박상희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchSoCodeListVO;



/**
 * ESM_MAS_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author park sang hee
 * @see ESM_MAS_0003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CostStructureConditionVO searchSoCodeVO = null;
	
	/** Table Value Object  단건 처리  */
	private SearchSoCodeListVO searchSoCodeListVO = null;
	
	/** Table Value Object  멀티 처리  */
	private SearchSoCodeListVO[] searchSoCodeListVOs = null;
	
	public EsmMas0003Event(){}
	
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
	
	public void setSearchSoCodeListVOs(SearchSoCodeListVO[] searchSoCodeVOs){
		this.searchSoCodeListVOs = searchSoCodeVOs;
	}

	public SearchSoCodeListVO[] getSearchSoCodeListVOs(){
		return searchSoCodeListVOs;
	}

}