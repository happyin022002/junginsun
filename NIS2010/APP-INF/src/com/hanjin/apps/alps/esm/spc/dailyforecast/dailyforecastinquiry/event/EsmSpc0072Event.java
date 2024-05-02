/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmSpc0072Event.java
*@FileTitle : Booking List
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.14 신자영
* 1.0 Creation
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SpcFcastBkgListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListConditionVO;


/**
 * ESM_SPC_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0072HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcFcastBkgListVO spcFcastBkgListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcFcastBkgListVO[] spcFcastBkgListVOs = null;

	public EsmSpc0072Event(){}
	
	public void setSpcFcastBkgListVO(SpcFcastBkgListVO spcFcastBkgListVO){
		this. spcFcastBkgListVO = spcFcastBkgListVO;
	}

	public void setSpcFcastBkgListVOS(SpcFcastBkgListVO[] spcFcastBkgListVOs){
		if (spcFcastBkgListVOs != null) {
			SpcFcastBkgListVO[] tmpVOs = new SpcFcastBkgListVO[spcFcastBkgListVOs.length];
			System.arraycopy(spcFcastBkgListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcFcastBkgListVOs = tmpVOs;
		}
	}

	public SpcFcastBkgListVO getSpcFcastBkgListVO(){
		return spcFcastBkgListVO;
	}

	public SpcFcastBkgListVO[] getSpcFcastBkgListVOS(){
		SpcFcastBkgListVO[] rtnVOs = null;
		if (this.spcFcastBkgListVOs != null) {
			rtnVOs = new SpcFcastBkgListVO[spcFcastBkgListVOs.length];
			System.arraycopy(spcFcastBkgListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
	private SearchTSBookingListConditionVO searchTSBookingListConditionVO = null;
	
	public void setSearchTSBookingListConditionVO(SearchTSBookingListConditionVO searchTSBookingListConditionVO){
		this. searchTSBookingListConditionVO = searchTSBookingListConditionVO;
	}
	
	public SearchTSBookingListConditionVO getSearchTSBookingListConditionVO(){
		return searchTSBookingListConditionVO;
	}

}