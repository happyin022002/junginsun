/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0041Event.java
*@FileTitle : MNR Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event;

import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0041Event(){}

	private PayableInvoiceGRPVO payableInvoiceGRPVO = null;

	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOs = null;
	
	
	public PayableInvoiceGRPVO getPayableInvoiceGRPVO() {
		return payableInvoiceGRPVO; 
	}

	public void setPayableInvoiceGRPVO(PayableInvoiceGRPVO payableInvoiceGRPVO) {
		this.payableInvoiceGRPVO = payableInvoiceGRPVO;
	} 
	
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOs() {
		return customMnrDatVrfyVOs;
	}
	public void setCustomMnrDatVrfyVOs(CustomMnrDatVrfyVO[] customMnrDatVrfyVOs) {
		this.customMnrDatVrfyVOs = customMnrDatVrfyVOs;
	}
}