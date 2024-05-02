/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0004Event.java
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
package com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;


/**
 * ESM_MAS_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchMonthYardCodeListVO searchMonthYardCodeListVO = null;
	private SearchMonthNodeCostListVO searchMonthNodeCostListVO = null;
	private SearchConditionVO searchConditionVO = null;
	
	
	/** Table Value Object Multi Data 처리 */
	private SearchMonthYardCodeListVO[] searchMonthYardCodeListVOs = null;
	private SearchMonthNodeCostListVO[] searchMonthNodeCostListVOs = null;

	public EsmMas0004Event(){}
	
	public void setSearchMonthYardCodeListVO(SearchMonthYardCodeListVO searchMonthYardCodeListVO ){
		this. searchMonthYardCodeListVO = searchMonthYardCodeListVO;
	}
	
	public void setSearchMonthNodeCostListVO(SearchMonthNodeCostListVO searchMonthNodeCostListVO){
		this. searchMonthNodeCostListVO = searchMonthNodeCostListVO;
	}
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchMonthYardCodeListVOS(SearchMonthYardCodeListVO[] searchMonthYardCodeListVOs){
		this. searchMonthYardCodeListVOs = searchMonthYardCodeListVOs;
	}
	
	public void setSearchMonthNodeCostListVOS(SearchMonthNodeCostListVO[] searchMonthNodeCostListVOs){
		this. searchMonthNodeCostListVOs = searchMonthNodeCostListVOs;
	}
	
	public SearchMonthYardCodeListVO getSearchMonthYardCodeListVO(){
		return searchMonthYardCodeListVO;
	}
	
	public SearchMonthYardCodeListVO[] getSearchMonthYardCodeListVOS(){
		return searchMonthYardCodeListVOs;
	}

	public SearchMonthNodeCostListVO getSearchMonthNodeCostListVO(){
		return searchMonthNodeCostListVO;
	}

	public SearchMonthNodeCostListVO[] getSearchMonthNodeCostListVOS(){
		return searchMonthNodeCostListVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}