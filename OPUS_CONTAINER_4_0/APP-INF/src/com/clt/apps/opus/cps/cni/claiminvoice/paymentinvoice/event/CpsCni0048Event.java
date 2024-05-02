/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0048Event.java
 *@FileTitle : [CPS_CNI_0048] CSR Manager
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.event;


import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0048] CSR Manager
 * @author 진윤오
 * @see CPS_CNI_0048HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0048Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	
	private CsrManagerListCondVO csrManagerListCondVO = null;

	public CsrManagerListCondVO getCsrManagerListCondVO() {
		return csrManagerListCondVO;
	}

	public void setCsrManagerListCondVO(CsrManagerListCondVO csrManagerListCondVO) {
		this.csrManagerListCondVO = csrManagerListCondVO;
	}

}