/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1009Event.java
*@FileTitle : COD Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.30 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_1009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
    private String isPop=null;
	public EsmBkg1009Event(){}
	public String getIsPop() {
		return isPop;
	}
	public void setIsPop(String isPop) {
		this.isPop = isPop;
	}
	  
}