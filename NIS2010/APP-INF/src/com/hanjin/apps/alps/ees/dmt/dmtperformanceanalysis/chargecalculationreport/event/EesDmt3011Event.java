/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3011Event.java
*@FileTitle : Deleted Charge Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.17 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;


/**
 * EES_DMT_3011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DeleteInquiryParmVO deleteInquiryParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DeleteInquiryParmVO[] deleteInquiryParmVOs = null;

	public EesDmt3011Event(){}
	
	public void setDeleteInquiryParmVO(DeleteInquiryParmVO deleteInquiryParmVO){
		this. deleteInquiryParmVO = deleteInquiryParmVO;
	}

	public void setDeleteInquiryParmVOS(DeleteInquiryParmVO[] deleteInquiryParmVOs){
		this. deleteInquiryParmVOs = deleteInquiryParmVOs;
	}

	public DeleteInquiryParmVO getDeleteInquiryParmVO(){
		return deleteInquiryParmVO;
	}

	public DeleteInquiryParmVO[] getDeleteInquiryParmVOS(){
		return deleteInquiryParmVOs;
	}

}