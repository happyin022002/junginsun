/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3020Event.java
*@FileTitle : Inland Cost Batch Error Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.30 변종건 [CHM-201217633] Inland Cost Batch Error Inquiry
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event;

import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchInlandCostBatchErrorVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_3020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs3020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs3020Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchInlandCostBatchErrorVO searchInlandCostBatchErrorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchInlandCostBatchErrorVO[] searchInlandCostBatchErrorVOs = null;

	
	public SearchInlandCostBatchErrorVO getSearchInlandCostBatchErrorVO() {
		return searchInlandCostBatchErrorVO;
	}

	public void setSearchInlandCostBatchErrorVO(
			SearchInlandCostBatchErrorVO searchInlandCostBatchErrorVO) {
		this.searchInlandCostBatchErrorVO = searchInlandCostBatchErrorVO;
	}

	public SearchInlandCostBatchErrorVO[] getSearchInlandCostBatchErrorVOs() {
		return searchInlandCostBatchErrorVOs;
	}

	public void setSearchInlandCostBatchErrorVOs(
			SearchInlandCostBatchErrorVO[] searchInlandCostBatchErrorVOs) {
		this.searchInlandCostBatchErrorVOs = searchInlandCostBatchErrorVOs;
	}
}
