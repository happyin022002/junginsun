/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0658Event.java
*@FileTitle : Stop Off Cargo Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.13 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0658 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0658HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0658HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0658Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String stopOffLocCd	 			= null;

	public void setStopOffLocCd(String stopOffLocCd){
		this. stopOffLocCd = stopOffLocCd;
	}


	public String getStopOffLocCd(){
		return stopOffLocCd;
	}
}