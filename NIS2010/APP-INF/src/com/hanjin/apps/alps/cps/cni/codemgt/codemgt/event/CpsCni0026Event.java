/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0026Event.java
 *@FileTitle : Main Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event;


import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyInquiryCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0026] Main Code Creation
 * @author 진윤오
 * @see CPS_CNI_0026HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0026Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	
	private PartyInquiryCondVO partyInquiryCondVO = null;

	public PartyInquiryCondVO getPartyInquiryCondVO() {
		return partyInquiryCondVO;
	}

	public void setPartyInquiryCondVO(PartyInquiryCondVO partyInquiryCondVO) {
		this.partyInquiryCondVO = partyInquiryCondVO;
	}


}