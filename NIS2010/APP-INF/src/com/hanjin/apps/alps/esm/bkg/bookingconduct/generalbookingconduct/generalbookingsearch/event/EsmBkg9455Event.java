/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg9455Event.java
*@FileTitle : Container No Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.25 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9455 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9455HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_9455HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9455Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	String ydCd = null;

	public void setYdCd(String ydCd){
		this. ydCd = ydCd;
	}

	public String getYdCd(){
		return ydCd;
	}	

	String vvd = null;

	public void setVvd(String vvd){
		this. vvd = vvd;
	}

	public String getVvd(){
		return vvd;
	}	

	String cntrTpsz = null;

	public void setCntrTpsz(String cntrTpsz){
		this. cntrTpsz = cntrTpsz;
	}

	public String getCntrTpsz(){
		return cntrTpsz;
	}		
}