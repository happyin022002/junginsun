/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0161Event.java
*@FileTitle : Disposal Invoice Issue & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.event;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_0161 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0161HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_0161HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0161Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnr0161Event(){}

	private ReceivableInvoiceGRPVO receivableInvoiceGRPVO = null;
	private DisposalGRPVO disposalGRPVO = null;
	
	public ReceivableInvoiceGRPVO getReceivableInvoiceGRPVO() {
		return receivableInvoiceGRPVO; 
	}

	public void setReceivableInvoiceGRPVO(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) {
		this.receivableInvoiceGRPVO = receivableInvoiceGRPVO;
	} 

	public DisposalGRPVO getDisposalGRPVO() {
		return disposalGRPVO; 
	}

	public void setDisposalGRPVO(DisposalGRPVO disposalGRPVO) {
		this.disposalGRPVO = disposalGRPVO;
	} 
	
	
	
	
}