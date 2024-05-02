/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0140Event.java
*@FileTitle : Feeder Term Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.08.03 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SearchCostStructure0140ListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaTrnsTermCalcVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0140 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0140HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Yun Joo
 * @see ESM_COA_0140HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0140Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostStructure0140ListVO searchCostStructure0140List = null;
	private SearchConditionVO searchCondition = null;
	private CoaTrnsTermCalcVO coaTrnsTermCalcVO = null;
	
	/** Table Value Object Multi Data 처리 */	
	private CoaTrnsTermCalcVO[] coaTrnsTermCalcVOs = null;

	public EsmCoa0140Event(){}
	
	public void setSearchCostStructure0140ListVO(SearchCostStructure0140ListVO searchCostStructure0140List){
		this. searchCostStructure0140List = searchCostStructure0140List;
	}
	public void setSearchConditionVO(SearchConditionVO searchCondition){
		this. searchCondition = searchCondition;
	}

	public void setCoaTrnsTermCalcVO(CoaTrnsTermCalcVO coaTrnsTermCalcVO){
		this. coaTrnsTermCalcVO = coaTrnsTermCalcVO;
	}
	//SJH.20150508.소스품질
	public void setCoaTrnsTermCalcVOS(CoaTrnsTermCalcVO[] coaTrnsTermCalcVOs){
		if(coaTrnsTermCalcVOs != null){
			CoaTrnsTermCalcVO[] tmpVOs = Arrays.copyOf(coaTrnsTermCalcVOs, coaTrnsTermCalcVOs.length);
			this.coaTrnsTermCalcVOs = tmpVOs;
		}
	}

	public SearchCostStructure0140ListVO getSearchCostStructure0140ListVO(){
		return searchCostStructure0140List;
	}
	public SearchConditionVO getSearchConditionVO(){
		return searchCondition;
	}

	public CoaTrnsTermCalcVO getCoaTrnsTermCalcVO(){
		return coaTrnsTermCalcVO;
	}
	//SJH.20150508.소스품질
	public CoaTrnsTermCalcVO[] getCoaTrnsTermCalcVOS(){
		CoaTrnsTermCalcVO[] rtnVOs = null;
		if (this.coaTrnsTermCalcVOs != null) {
			rtnVOs = Arrays.copyOf(coaTrnsTermCalcVOs, coaTrnsTermCalcVOs.length);
		}
		return rtnVOs;
	}
}