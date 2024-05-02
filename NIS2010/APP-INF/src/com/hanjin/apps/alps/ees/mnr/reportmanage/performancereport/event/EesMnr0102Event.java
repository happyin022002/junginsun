/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0102Event.java
*@FileTitle : Total Loss Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.06 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceVO;


/**
 * EES_MNR_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0102HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TotalLossPerformanceINVO totalLossPerformanceINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TotalLossPerformanceVO[] totalLossPerformanceVOs = null;

	public EesMnr0102Event(){}
	
	public void setTotalLossPerformanceINVO(TotalLossPerformanceINVO totalLossPerformanceINVO){
		this. totalLossPerformanceINVO = totalLossPerformanceINVO;
	}

	public void setTotalLossPerformanceVOS(TotalLossPerformanceVO[] totalLossPerformanceVOs){
		this. totalLossPerformanceVOs = totalLossPerformanceVOs;
	}

	public TotalLossPerformanceINVO getTotalLossPerformanceINVO(){
		return totalLossPerformanceINVO;
	}

	public TotalLossPerformanceVO[] getTotalLossPerformanceVOS(){
		return totalLossPerformanceVOs;
	}

}