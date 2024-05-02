/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0001Event.java
 *@FileTitle : Client Default Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0002] Find
 * @author 양정란 
 * @see CPS_CNI_0002HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String ofcCd = "";
	private String clmAreaCd = "";
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getClmAreaCd() {
		return clmAreaCd;
	}
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
   
}