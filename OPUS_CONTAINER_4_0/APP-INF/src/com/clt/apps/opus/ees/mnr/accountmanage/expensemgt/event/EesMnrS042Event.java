/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnrS042Event.java
*@FileTitle : MNR Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_mnr_S042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_S042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 함형석
 * @see ees_mnr_S042HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnrS042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesMnrS042Event(){}

	private PayableInvoiceGRPVO payableInvoiceGRPVO = null;

	public PayableInvoiceGRPVO getPayableInvoiceGRPVO() {
		return payableInvoiceGRPVO; 
	}

	public void setPayableInvoiceGRPVO(PayableInvoiceGRPVO payableInvoiceGRPVO) {
		this.payableInvoiceGRPVO = payableInvoiceGRPVO;
	} 
	
	
}