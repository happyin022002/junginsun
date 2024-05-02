/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0022Event.java
 *@FileTitle : Prevention
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.22 진윤오
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.vo.PreventionCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0022] Prevention
 * @author 진윤오
 * @see CPS_CNI_0022HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PreventionCondVO preventionCondVO = null;

	public PreventionCondVO getPreventionCondVO() {
		return preventionCondVO;
	}

	public void setPreventionCondVO(PreventionCondVO preventionCondVO) {
		this.preventionCondVO = preventionCondVO;
	}
	

}