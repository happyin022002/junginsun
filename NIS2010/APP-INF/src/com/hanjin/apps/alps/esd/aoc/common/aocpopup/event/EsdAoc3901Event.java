/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3901Event.java
*@FileTitle : Inland Cost Batch Error Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Inland Cost Batch Error Inquiry
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aocpopup.event;

import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.InlandCostBatchErrorVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3901 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_AOC_3901HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdAoc3901Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3901Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InlandCostBatchErrorVO inlandCostBatchErrorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InlandCostBatchErrorVO[] inlandCostBatchErrorVOs = null;

	
	public InlandCostBatchErrorVO getSearchInlandCostBatchErrorVO() {
		return inlandCostBatchErrorVO;
	}

	public void setSearchInlandCostBatchErrorVO(
			InlandCostBatchErrorVO inlandCostBatchErrorVO) {
		this.inlandCostBatchErrorVO = inlandCostBatchErrorVO;
	}

	public InlandCostBatchErrorVO[] getSearchInlandCostBatchErrorVOs() {
		InlandCostBatchErrorVO[] rtnVOs = null;
		if (this.inlandCostBatchErrorVOs != null) {
			rtnVOs = new InlandCostBatchErrorVO[inlandCostBatchErrorVOs.length];
			System.arraycopy(inlandCostBatchErrorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchInlandCostBatchErrorVOs(InlandCostBatchErrorVO[] searchInlandCostBatchErrorVOs){
		if(searchInlandCostBatchErrorVOs != null){
			InlandCostBatchErrorVO[] tmpVOs = new InlandCostBatchErrorVO[searchInlandCostBatchErrorVOs.length];
			System.arraycopy(searchInlandCostBatchErrorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inlandCostBatchErrorVOs = tmpVOs;
		}
	}
}
