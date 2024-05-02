/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0306Event.java
*@FileTitle : Vessel Code & Particular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.28 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0306 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0306HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0306HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** VVD Cd */
	private String vvdCd = "";
	
	/** Vessel Name */
	private String vslEngNm = "";

	public CpsCni0306Event(){}
	
	public void setVvdCd(String vvdCd){
		this. vvdCd = vvdCd;
	}
	
	public void setVslEngNm(String vslEngNm){
		this. vslEngNm = vslEngNm;
	}

	public String getVvdCd(){
		return vvdCd;
	}

	public String getVslEngNm(){
		return vslEngNm;
	}

}