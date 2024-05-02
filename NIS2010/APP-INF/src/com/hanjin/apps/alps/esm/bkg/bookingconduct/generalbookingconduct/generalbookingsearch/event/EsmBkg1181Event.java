/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1181Event.java
*@FileTitle : Fumigation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1181 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1181HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_BKG_1181HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1181Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String fumgLocCd	 			= null;

	public void setFumgLocCd(String fumgLocCd){
		this. fumgLocCd = fumgLocCd;
	}


	public String getFumgLocCd(){
		return fumgLocCd;
	}
}