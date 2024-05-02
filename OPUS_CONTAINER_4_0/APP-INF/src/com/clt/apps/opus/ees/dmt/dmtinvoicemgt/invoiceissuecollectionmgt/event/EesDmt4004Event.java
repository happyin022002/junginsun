/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4004Event.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.30 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_DMT_4004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sung Hoon
 * @see EES_DMT_4001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	private DmtInvMnVO dmtInvMnVO = null;
	
	private DmtInvDtlVO[] dmtInvDtlVOS = null;
	
	private DmtInvRtVO[] dmtInvRtVOS = null;
	
	public void setChargeBookingInvoiceVO(ChargeBookingInvoiceVO chargeBookingInvoiceVO) {
		this.chargeBookingInvoiceVO = chargeBookingInvoiceVO;
	}
	
	public void setDmtInvMnVO(DmtInvMnVO dmtInvMnVO) {
		this.dmtInvMnVO = dmtInvMnVO;
	}	
	
	public void setDmtInvDtlVOS(DmtInvDtlVO[] dmtInvDtlVOS) {
		if (dmtInvDtlVOS != null) {
			DmtInvDtlVO[] tmpVOs = new DmtInvDtlVO[dmtInvDtlVOS.length];
			System.arraycopy(dmtInvDtlVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtInvDtlVOS = tmpVOs;
		}
	}
	
	public void setDmtInvRtVOS(DmtInvRtVO[] dmtInvRtVOS) {
		if (dmtInvRtVOS != null) {
			DmtInvRtVO[] tmpVOs = new DmtInvRtVO[dmtInvRtVOS.length];
			System.arraycopy(dmtInvRtVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.dmtInvRtVOS = tmpVOs;
		}
	}
	
	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}
	
	public DmtInvMnVO getDmtInvMnVO() {
		return dmtInvMnVO;
	}
	
	public DmtInvDtlVO[] getDmtInvDtlVOS() {
		DmtInvDtlVO[] tmpVOs = null;
		if (this.dmtInvDtlVOS != null) {
			tmpVOs = new DmtInvDtlVO[dmtInvDtlVOS.length];
			System.arraycopy(dmtInvDtlVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public DmtInvRtVO[] getDmtInvRtVOS() {
		DmtInvRtVO[] tmpVOs = null;
		if (this.dmtInvRtVOS != null) {
			tmpVOs = new DmtInvRtVO[dmtInvRtVOS.length];
			System.arraycopy(dmtInvRtVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
}
