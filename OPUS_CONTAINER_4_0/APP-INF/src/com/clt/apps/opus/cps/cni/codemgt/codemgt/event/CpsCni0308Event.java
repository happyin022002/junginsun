/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0308Event.java
*@FileTitle : CCC Vessel Code & Name Inquiry
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
 * CPS_CNI_0308 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0308HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0308HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0308Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Vessel Code */
	private String vslCd = "";
	
	/** Vessel Name */
	private String vslNm = "";

	public CpsCni0308Event(){}
	
	public void setVslCd(String vslCd){
		this. vslCd = vslCd;
	}
	
	public void setVslNm(String vslNm){
		this. vslNm = vslNm;
	}

	public String getVslCd(){
		return vslCd;
	}

	public String getVslNm(){
		return vslNm;
	}

}