/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0105Event.java
*@FileTitle : dailyforecastinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.03 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTSBookingListVO searchTSBookingListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTSBookingListVO[] searchTSBookingListVOs = null;
	
	private SearchTSBookingListConditionVO searchTSBookingListConditionVO = null;

	public EsmSpc0105Event(){}
	
	public void setSpcFcastOfcPolMapgVO(SearchTSBookingListVO searchTSBookingListVO){
		this. searchTSBookingListVO = searchTSBookingListVO;
	}

	public void setSpcFcastOfcPolMapgVOS(SearchTSBookingListVO[] searchTSBookingListVOs){
		if (searchTSBookingListVOs != null) {
			SearchTSBookingListVO[] tmpVOs = new SearchTSBookingListVO[searchTSBookingListVOs.length];
			System.arraycopy(searchTSBookingListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchTSBookingListVOs = tmpVOs;
		}
	}

	public SearchTSBookingListVO getSearchTSBookingListVO(){
		return searchTSBookingListVO;
	}

	public SearchTSBookingListVO[] getSearchTSBookingListVOS(){
		SearchTSBookingListVO[] rtnVOs = null;
		if (this.searchTSBookingListVOs != null) {
			rtnVOs = new SearchTSBookingListVO[searchTSBookingListVOs.length];
			System.arraycopy(searchTSBookingListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public SearchTSBookingListConditionVO getSearchTSBookingListConditionVO() {
		return searchTSBookingListConditionVO;
	}

	public void setSearchTSBookingListConditionVO(
			SearchTSBookingListConditionVO searchTSBookingListConditionVO) {
		this.searchTSBookingListConditionVO = searchTSBookingListConditionVO;
	}

}