/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0023Event.java
 *@FileTitle : Prevention Register
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.22 진윤오
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.event;


import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.CniClmPrveVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0023] Prevention Register
 * @author 진윤오
 * @see CPS_CNI_0023HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private CniClmPrveVO cniClmPrveVO = null;

	public CniClmPrveVO getCniClmPrveVO() {
		return cniClmPrveVO;
	}

	public void setCniClmPrveVO(CniClmPrveVO cniClmPrveVO) {
		this.cniClmPrveVO = cniClmPrveVO;
	}
	


}