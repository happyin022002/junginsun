/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0017Event.java
*@FileTitle : CSR Inquiry By Office
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event;

import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchCsrListByGLMonthVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_LEA_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 2015.06.15
 * @see ESD_LEA_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCsrListByGLMonthVO searchCsrListByGLMonthVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCsrListByGLMonthVO[] searchCsrListByGLMonthVOs = null;

	public EsdLea0017Event(){}
	
	public void setSearchCsrListByGLMonthVO(SearchCsrListByGLMonthVO searchCsrListByGLMonthVO){
		this.searchCsrListByGLMonthVO = searchCsrListByGLMonthVO;
	}

	public void setSearchCsrListByGLMonthVOS(SearchCsrListByGLMonthVO[] searchCsrListByGLMonthVOs){
		if(searchCsrListByGLMonthVOs != null){
			SearchCsrListByGLMonthVO[] tmpVOs = new SearchCsrListByGLMonthVO[searchCsrListByGLMonthVOs.length];
			System.arraycopy(searchCsrListByGLMonthVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchCsrListByGLMonthVOs = tmpVOs;
		}
	}

	public SearchCsrListByGLMonthVO getSearchCsrListByGLMonthVO(){
		return searchCsrListByGLMonthVO;
	}

	public SearchCsrListByGLMonthVO[] getSearchCsrListByGLMonthVOS(){
		SearchCsrListByGLMonthVO[] rtnVOs = null;
		if (this.searchCsrListByGLMonthVOs != null) {
			rtnVOs = new SearchCsrListByGLMonthVO[searchCsrListByGLMonthVOs.length];
			System.arraycopy(searchCsrListByGLMonthVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}