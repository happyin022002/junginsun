/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3021Event.java
*@FileTitle : Ocean Feeder Cost Batch Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012-10-04
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Ocean Feeder Cost Batch Creation
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.event;

import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * PDTO(Data Transfer Object including Parameters)<br>
 * - HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdAoc3021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3021Event(){}
	
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
		SearchCostCalcListVO[] rtnVOs = null;
		if (this.searchCostCalcListVOs != null) {
			rtnVOs = new SearchCostCalcListVO[searchCostCalcListVOs.length];
			System.arraycopy(searchCostCalcListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchCostCalcListVOs(SearchCostCalcListVO[] searchCostCalcListVOs){
		if(searchCostCalcListVOs != null){
			SearchCostCalcListVO[] tmpVOs = new SearchCostCalcListVO[searchCostCalcListVOs.length];
			System.arraycopy(searchCostCalcListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchCostCalcListVOs = tmpVOs;
		}
	}
}
