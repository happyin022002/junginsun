/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6029Event.java
*@FileTitle : SM,OP Summary-Multi Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.08 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPriCMSummaryCustomerListVO;


/**
 * ESM_PRI_6029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriCMSummaryCustomerListVO[] rsltPriCMSummaryCustomerListVOs = null;

	public EsmPri6029Event(){}
	
	public void setRsltPriCMSummaryCustomerListVO(RsltPriCMSummaryCustomerListVO rsltPriCMSummaryCustomerListVO){
		this. rsltPriCMSummaryCustomerListVO = rsltPriCMSummaryCustomerListVO;
	}

	public void setRsltPriCMSummaryCustomerListVOS(RsltPriCMSummaryCustomerListVO[] rsltPriCMSummaryCustomerListVOs){
		this. rsltPriCMSummaryCustomerListVOs = rsltPriCMSummaryCustomerListVOs;
	}

	public RsltPriCMSummaryCustomerListVO getRsltPriCMSummaryCustomerListVO(){
		return rsltPriCMSummaryCustomerListVO;
	}

	public RsltPriCMSummaryCustomerListVO[] getRsltPriCMSummaryCustomerListVOS(){
		return rsltPriCMSummaryCustomerListVOs;
	}

}