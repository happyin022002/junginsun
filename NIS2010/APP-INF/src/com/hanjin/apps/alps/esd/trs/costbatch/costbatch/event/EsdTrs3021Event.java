/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3021Event.java
*@FileTitle : Ocean Feeder Cost Batch Error Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.31 변종건 [CHM-201217633] Ocean Feeder Cost Batch Error Inquiry
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event;

import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchFdrCostBatchErrorVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_3021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs3021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs3021Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchFdrCostBatchErrorVO searchFdrCostBatchErrorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchFdrCostBatchErrorVO[] searchFdrCostBatchErrorVOs = null;

	public SearchFdrCostBatchErrorVO getSearchFdrCostBatchErrorVO() {
		return searchFdrCostBatchErrorVO;
	}

	public void setSearchFdrCostBatchErrorVO(
			SearchFdrCostBatchErrorVO searchFdrCostBatchErrorVO) {
		this.searchFdrCostBatchErrorVO = searchFdrCostBatchErrorVO;
	}

	public SearchFdrCostBatchErrorVO[] getSearchFdrCostBatchErrorVOs() {
		return searchFdrCostBatchErrorVOs;
	}

	public void setSearchFdrCostBatchErrorVOs(
			SearchFdrCostBatchErrorVO[] searchFdrCostBatchErrorVOs) {
		this.searchFdrCostBatchErrorVOs = searchFdrCostBatchErrorVOs;
	}

}
