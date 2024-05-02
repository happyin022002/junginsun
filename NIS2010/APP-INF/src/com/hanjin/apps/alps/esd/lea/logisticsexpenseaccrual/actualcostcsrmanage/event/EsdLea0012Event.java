/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0012Event.java
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.08.17 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRListVO;


/**
 * ESD_LEA_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActualCostCSRListVO searchActualCostCSRListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchActualCostCSRListVO[] searchActualCostCSRListVOs = null;

	public EsdLea0012Event(){}
	
	public void setSearchActualCostCSRListVO(SearchActualCostCSRListVO searchActualCostCSRListVO){
		this. searchActualCostCSRListVO = searchActualCostCSRListVO;
	}

	public void setSearchActualCostCSRListVOS(SearchActualCostCSRListVO[] searchActualCostCSRListVOs){
		this. searchActualCostCSRListVOs = searchActualCostCSRListVOs;
	}

	public SearchActualCostCSRListVO getSearchActualCostCSRListVO(){
		return searchActualCostCSRListVO;
	}

	public SearchActualCostCSRListVO[] getSearchActualCostCSRListVOS(){
		return searchActualCostCSRListVOs;
	}

}