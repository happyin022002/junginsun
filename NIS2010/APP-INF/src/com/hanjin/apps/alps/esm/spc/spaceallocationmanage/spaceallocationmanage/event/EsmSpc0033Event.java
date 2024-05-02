/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0033Event.java
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.24 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0033LaneRgstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs = null;

	public EsmSpc0033Event(){} 
	
	public void setSearchSpaceAllocation0033LaneRgstVO(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO){
		this. searchSpaceAllocation0033LaneRgstVO = searchSpaceAllocation0033LaneRgstVO;
	}

	public void setSearchSpaceAllocation0033LaneRgstVOS(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs){
		if (searchSpaceAllocation0033LaneRgstVOs != null) {
			SearchSpaceAllocation0033LaneRgstVO[] tmpVOs = new SearchSpaceAllocation0033LaneRgstVO[searchSpaceAllocation0033LaneRgstVOs.length];
			System.arraycopy(searchSpaceAllocation0033LaneRgstVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceAllocation0033LaneRgstVOs = tmpVOs;
		}
	}

	public SearchSpaceAllocation0033LaneRgstVO getSearchSpaceAllocation0033LaneRgstVO(){
		return searchSpaceAllocation0033LaneRgstVO;
	}

	public SearchSpaceAllocation0033LaneRgstVO[] getSearchSpaceAllocation0033LaneRgstVOS(){
		SearchSpaceAllocation0033LaneRgstVO[] rtnVOs = null;
		if( this.searchSpaceAllocation0033LaneRgstVOs != null ){
			rtnVOs = new SearchSpaceAllocation0033LaneRgstVO[searchSpaceAllocation0033LaneRgstVOs.length];
			System.arraycopy(searchSpaceAllocation0033LaneRgstVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}