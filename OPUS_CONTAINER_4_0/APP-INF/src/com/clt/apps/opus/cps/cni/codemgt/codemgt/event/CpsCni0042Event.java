/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0042Event.java
 *@FileTitle : CCC VVD & SKD Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;


import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.VvdSkdCondVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0042] CCC VVD & SKD Inquiry
 * @author 진윤오
 * @see CPS_CNI_0042HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0042Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	/* 검색조건 VO */	
	private VvdSkdCondVO vvdSkdCondVO;
	public VvdSkdCondVO getVvdSkdCondVO() {
		return vvdSkdCondVO;
	}
	public void setVvdSkdCondVO(VvdSkdCondVO vvdSkdCondVO) {
		this.vvdSkdCondVO = vvdSkdCondVO;
	} 
	



}