/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3902Event.java
*@FileTitle : Ocean Feeder Cost Batch Error Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Ocean Feeder Cost Batch Error Inquiry
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aocpopup.event;

import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.FdrCostBatchErrorVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3902 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_AOC_3902HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdAoc3902Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3902Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FdrCostBatchErrorVO fdrCostBatchErrorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FdrCostBatchErrorVO[] fdrCostBatchErrorVOs = null;

	public FdrCostBatchErrorVO getSearchFdrCostBatchErrorVO() {
		return fdrCostBatchErrorVO;
	}

	public void setSearchFdrCostBatchErrorVO(
			FdrCostBatchErrorVO fdrCostBatchErrorVO) {
		this.fdrCostBatchErrorVO = fdrCostBatchErrorVO;
	}

	public FdrCostBatchErrorVO[] getSearchFdrCostBatchErrorVOs() {
		FdrCostBatchErrorVO[] rtnVOs = null;
		if (this.fdrCostBatchErrorVOs != null) {
			rtnVOs = new FdrCostBatchErrorVO[fdrCostBatchErrorVOs.length];
			System.arraycopy(fdrCostBatchErrorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchFdrCostBatchErrorVOs(FdrCostBatchErrorVO[] searchFdrCostBatchErrorVOs){
		if(searchFdrCostBatchErrorVOs != null){
			FdrCostBatchErrorVO[] tmpVOs = new FdrCostBatchErrorVO[searchFdrCostBatchErrorVOs.length];
			System.arraycopy(searchFdrCostBatchErrorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fdrCostBatchErrorVOs = tmpVOs;
		}
	}

}
