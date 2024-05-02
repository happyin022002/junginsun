/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : APCInvoiceGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2015. 01. 13.
*@LastModifier : 
*@LastVersion : 1.0
*2015. 01. 13. 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.util.List;

public class APCInvoiceGRPVO {
	private InvEDIHdrVO invEDIHdrVO;
	private List<InvEDIChgVO> invEDIChgVOs;
	private List<InvEDICntrVO> invEDICntrVOs;
	public InvEDIHdrVO getInvEDIHdrVO() {
		return invEDIHdrVO;
	}
	public void setInvEDIHdrVO(InvEDIHdrVO invEDIHdrVO) {
		this.invEDIHdrVO = invEDIHdrVO;
	}
	public List<InvEDIChgVO> getInvEDIChgVOs() {
		return invEDIChgVOs;
	}
	public void setInvEDIChgVOs(List<InvEDIChgVO> invEDIChgVOs) {
		this.invEDIChgVOs = invEDIChgVOs;
	}
	public List<InvEDICntrVO> getInvEDICntrVOs() {
		return invEDICntrVOs;
	}
	public void setInvEDICntrVOs(List<InvEDICntrVO> invEDICntrVOs) {
		this.invEDICntrVOs = invEDICntrVOs;
	}
}
