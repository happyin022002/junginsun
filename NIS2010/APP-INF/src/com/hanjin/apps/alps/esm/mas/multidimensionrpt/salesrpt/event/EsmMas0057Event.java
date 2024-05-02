/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0057Event.java
*@FileTitle : Monthly Average U/C(PFMC-Based) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.06 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgConditionVO;


/**
 * ESM_MAS_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_MAS_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO = null;

	public EsmMas0057Event(){}	
	
	public void setSearchMonthlyAvgConditionVO(
			SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) {
		this.searchMonthlyAvgConditionVO = searchMonthlyAvgConditionVO;
	}	

	public SearchMonthlyAvgConditionVO getSearchMonthlyAvgConditionVO() {
		return searchMonthlyAvgConditionVO;
	}

	

}