/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmCoa0004Event.java
*@FileTitle : Node Cost (PA/RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.11.27 임옥영  최초 생성
* 2009.07.24 박수훈  0004 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMonthYardCodeListVO searchMonthYardCodeListVO = null;
	private SearchMonthNodeCostListVO searchMonthNodeCostListVO = null;
	private SearchConditionVO searchConditionVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthYardCodeListVO[] searchMonthYardCodeListVOs = null;
	private SearchMonthNodeCostListVO[] searchMonthNodeCostListVOs = null;

	public EsmCoa0004Event(){}
	
	public void setSearchMonthYardCodeListVO(SearchMonthYardCodeListVO searchMonthYardCodeListVO ){
		this. searchMonthYardCodeListVO = searchMonthYardCodeListVO;
	}
	
	public void setSearchMonthNodeCostListVO(SearchMonthNodeCostListVO searchMonthNodeCostListVO){
		this. searchMonthNodeCostListVO = searchMonthNodeCostListVO;
	}
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	//SJH.20150508.소스품질
	public void setSearchMonthYardCodeListVOS(SearchMonthYardCodeListVO[] searchMonthYardCodeListVOs){
		if(searchMonthYardCodeListVOs != null){
			SearchMonthYardCodeListVO[] tmpVOs = Arrays.copyOf(searchMonthYardCodeListVOs, searchMonthYardCodeListVOs.length);
			this.searchMonthYardCodeListVOs = tmpVOs;
		}
	}
	//SJH.20150508.소스품질
	public void setSearchMonthNodeCostListVOS(SearchMonthNodeCostListVO[] searchMonthNodeCostListVOs){
		if(searchMonthNodeCostListVOs != null){
			SearchMonthNodeCostListVO[] tmpVOs = Arrays.copyOf(searchMonthNodeCostListVOs, searchMonthNodeCostListVOs.length);
			this.searchMonthNodeCostListVOs = tmpVOs;
		}
	}
	
	public SearchMonthYardCodeListVO getSearchMonthYardCodeListVO(){
		return searchMonthYardCodeListVO;
	}
	//SJH.20150508.소스품질
	public SearchMonthYardCodeListVO[] getSearchMonthYardCodeListVOS(){
		SearchMonthYardCodeListVO[] rtnVOs = null;
		if (this.searchMonthYardCodeListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMonthYardCodeListVOs, searchMonthYardCodeListVOs.length);
		}
		return rtnVOs;
	}

	public SearchMonthNodeCostListVO getSearchMonthNodeCostListVO(){
		return searchMonthNodeCostListVO;
	}
	//SJH.20150508.소스품질
	public SearchMonthNodeCostListVO[] getSearchMonthNodeCostListVOS(){
		SearchMonthNodeCostListVO[] rtnVOs = null;
		if (this.searchMonthNodeCostListVOs != null) {
			rtnVOs = Arrays.copyOf(searchMonthNodeCostListVOs, searchMonthNodeCostListVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}