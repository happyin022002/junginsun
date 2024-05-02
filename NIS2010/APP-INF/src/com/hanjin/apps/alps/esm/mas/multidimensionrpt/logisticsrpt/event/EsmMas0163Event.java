/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0163Event.java
*@FileTitle : US Inbound Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.30 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.vo.SearchUSInlandCost0163ListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0163 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0163HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0163HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0163Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;

	public EsmMas0163Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}
	
	public void setSearchUSInlandCost0163ListVO(SearchUSInlandCost0163ListVO searchUSInlandCost0163ListVO){
		this. searchUSInlandCost0163ListVO = searchUSInlandCost0163ListVO;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	public SearchUSInlandCost0163ListVO getSearchUSInlandCost0163ListVO(){
		return searchUSInlandCost0163ListVO;
	}

}