/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3010Event.java
*@FileTitle : Deleted Charge Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.DeleteInquiryParmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DeleteInquiryParmVO deleteInquiryParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DeleteInquiryParmVO[] deleteInquiryParmVOs = null;

	public EesDmt3010Event(){}
	
	public void setDeleteInquiryParmVO(DeleteInquiryParmVO deleteInquiryParmVO){
		this. deleteInquiryParmVO = deleteInquiryParmVO;
	}

	public void setDeleteInquiryParmVOS(DeleteInquiryParmVO[] deleteInquiryParmVOs){
		if (deleteInquiryParmVOs != null) {
			DeleteInquiryParmVO[] tmpVOs = new DeleteInquiryParmVO[deleteInquiryParmVOs.length];
			System.arraycopy(deleteInquiryParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.deleteInquiryParmVOs = tmpVOs;
		}
	}

	public DeleteInquiryParmVO getDeleteInquiryParmVO(){
		return deleteInquiryParmVO;
	}

	public DeleteInquiryParmVO[] getDeleteInquiryParmVOS(){
		DeleteInquiryParmVO[] tmpVOs = null;
		if (this.deleteInquiryParmVOs != null) {
			tmpVOs = new DeleteInquiryParmVO[deleteInquiryParmVOs.length];
			System.arraycopy(deleteInquiryParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}