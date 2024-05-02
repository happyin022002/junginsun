/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0112Event.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-21 O Wan-Ki 			1.0	최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.event;

import com.hanjin.apps.alps.esd.tpb.logisticsrevenue.logisticsrevenue.vo.LogisticsRevenueInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0139HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0139Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LogisticsRevenueInvoiceVO[] logisticsRevenueInvoiceVOs = null;

	public EsdTpb0139Event(){}
	
	public void setLogisticsRevenueInvoiceVO(LogisticsRevenueInvoiceVO logisticsRevenueInvoiceVO){
		this. logisticsRevenueInvoiceVO = logisticsRevenueInvoiceVO;
	}

	public void setLogisticsRevenueInvoiceVOS(LogisticsRevenueInvoiceVO[] logisticsRevenueInvoiceVOs){
		this. logisticsRevenueInvoiceVOs = logisticsRevenueInvoiceVOs;
	}

	public LogisticsRevenueInvoiceVO getLogisticsRevenueInvoiceVO(){
		return logisticsRevenueInvoiceVO;
	}

	public LogisticsRevenueInvoiceVO[] getLogisticsRevenueInvoiceVOS(){
		return logisticsRevenueInvoiceVOs;
	}

}