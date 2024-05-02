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
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;


import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.VvdSkdCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0042] CCC VVD & SKD Inquiry
 * @author 진윤오
 * @see CPS_CNI_0042HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0043Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	/* 검색조건 VO */	
	private String tbDt = "";
	
	private String condFor = "";

	public String getTbDt() {
		return tbDt;
	}

	public void setTbDt(String tbDt) {
		this.tbDt = tbDt;
	}

	public String getCondFor() {
		return condFor;
	}

	public void setCondFor(String condFor) {
		this.condFor = condFor;
	}



}