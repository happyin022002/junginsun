/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0140Event.java
*@FileTitle : Feeder Term Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.08.03 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.hanjin.syscommon.common.table.MasTrnsTermCalcVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;


/**
 * ESM_MAS_0140 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0140HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_MAS_0140HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0140Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostStructure0140ListVO searchCostStructure0140List = null;
	private SearchConditionVO searchCondition = null;
	private MasTrnsTermCalcVO masTrnsTermCalcVO = null;
	
	/** Table Value Object Multi Data 처리 */	
	private MasTrnsTermCalcVO[] masTrnsTermCalcVOs = null;

	public EsmMas0140Event(){}
	
	public void setSearchCostStructure0140ListVO(SearchCostStructure0140ListVO searchCostStructure0140List){
		this. searchCostStructure0140List = searchCostStructure0140List;
	}
	public void setSearchConditionVO(SearchConditionVO searchCondition){
		this. searchCondition = searchCondition;
	}

	public void setMasTrnsTermCalcVO(MasTrnsTermCalcVO masTrnsTermCalcVO){
		this. masTrnsTermCalcVO = masTrnsTermCalcVO;
	}

	public void setMasTrnsTermCalcVOS(MasTrnsTermCalcVO[] masTrnsTermCalcVOs){
		this. masTrnsTermCalcVOs = masTrnsTermCalcVOs;
	}

	public SearchCostStructure0140ListVO getSearchCostStructure0140ListVO(){
		return searchCostStructure0140List;
	}
	public SearchConditionVO getSearchConditionVO(){
		return searchCondition;
	}

	public MasTrnsTermCalcVO getMasTrnsTermCalcVO(){
		return masTrnsTermCalcVO;
	}

	public MasTrnsTermCalcVO[] getMasTrnsTermCalcVOS(){
		return masTrnsTermCalcVOs;
	}
}