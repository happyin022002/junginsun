/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3011Event.java
*@FileTitle : Ocean Feeder Cost Batch Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012-05-07
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.03 변종건 [CHM-201217633] Ocean Feeder Cost Batch Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event;

import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_3011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs3011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs3011Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCostCalcListVO searchCostCalcListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCostCalcListVO[] searchCostCalcListVOs = null;

	
	public SearchCostCalcListVO getSearchCostCalcListVO() {
		return searchCostCalcListVO;
	}

	public void setSearchCostCalcListVO(SearchCostCalcListVO searchCostCalcListVO) {
		this.searchCostCalcListVO = searchCostCalcListVO;
	}

	public SearchCostCalcListVO[] getSearchCostCalcListVOs() {
		return searchCostCalcListVOs;
	}

	public void setSearchCostCalcListVOs(SearchCostCalcListVO[] searchCostCalcListVOs) {
		this.searchCostCalcListVOs = searchCostCalcListVOs;
	}
}
