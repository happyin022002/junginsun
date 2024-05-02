/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0013Event.java
*@FileTitle : CSR Monitoring Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.02 Jeon Jae Hong
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.event;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo.SearchActualCostCSRMonitoringListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_LEA_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchActualCostCSRMonitoringListVO[] searchActualCostCSRMonitoringListVOs = null;

	public EsdLea0013Event(){}
	
	public void setSearchActualCostCSRMonitoringListVO(SearchActualCostCSRMonitoringListVO searchActualCostCSRMonitoringListVO){
		this. searchActualCostCSRMonitoringListVO = searchActualCostCSRMonitoringListVO;
	}

	public void setSearchActualCostCSRMonitoringListVOS(SearchActualCostCSRMonitoringListVO[] searchActualCostCSRMonitoringListVOs){
		this. searchActualCostCSRMonitoringListVOs = searchActualCostCSRMonitoringListVOs;
	}

	public SearchActualCostCSRMonitoringListVO getSearchActualCostCSRMonitoringListVO(){
		return searchActualCostCSRMonitoringListVO;
	}

	public SearchActualCostCSRMonitoringListVO[] getSearchActualCostCSRMonitoringListVOS(){
		return searchActualCostCSRMonitoringListVOs;
	}

}