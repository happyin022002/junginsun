/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EsdEas0360Event.java
*@FileTitle : M&R Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-13 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrInvoiceChargeINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EsdEas0360Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0360Event extends EventSupport {

	private static final long serialVersionUID = 2453667971767080933L;

	private MnrInvoiceChargeINVO mnrInvoiceChargeINVO = null;
	
	private MnrChargeListVO[] mnrChargeListVOS = null;

	public MnrInvoiceChargeINVO getMnrInvoiceChargeINVO() {
		return mnrInvoiceChargeINVO;
	}

	public void setMnrInvoiceChargeINVO(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) {
		this.mnrInvoiceChargeINVO = mnrInvoiceChargeINVO;
	}

	
	public MnrChargeListVO[] getMnrChargeListVOS() {
		MnrChargeListVO[] rtnVOs = null;
		if (this.mnrChargeListVOS != null) {
			rtnVOs = new MnrChargeListVO[mnrChargeListVOS.length];
			System.arraycopy(mnrChargeListVOS, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	
	public void setMnrChargeListVOS(MnrChargeListVO[] mnrChargeListVOS) {
		if(mnrChargeListVOS != null){
			MnrChargeListVO[] tmpVOs = Arrays.copyOf(mnrChargeListVOS, mnrChargeListVOS.length);
			this.mnrChargeListVOS = tmpVOs;
		}
	}

}
