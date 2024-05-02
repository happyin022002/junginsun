/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0064Event.java
*@FileTitle : Hire Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.20 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0064HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String rngYr =  "";

	public EsmFms0064Event(){}
	
	public void setRngYr(String rngYr){
		this. rngYr = rngYr;
	}

	public String getRngYr(){
		return rngYr;
	}

}