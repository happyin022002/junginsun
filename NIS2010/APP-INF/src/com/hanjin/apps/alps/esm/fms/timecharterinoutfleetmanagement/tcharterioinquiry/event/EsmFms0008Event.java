/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0008Event.java
*@FileTitle : Capital Budgeting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String effDt = ""; 
	
	private String expDt = ""; 
	
	private String vslCd = "";
	
	public EsmFms0008Event(){}
	
	public void setEffDt(String effDt){
		this. effDt = effDt;
	}
	
	public void setExpDt(String expDt){
		this. expDt = expDt;
	}
	
	public void setVslCd(String vslCd){
		this. vslCd = vslCd;
	}
	
	public String getEffDt(){
		return effDt;
	}
	
	public String getExpDt(){
		return expDt;
	}
	
	public String getVslCd(){
		return vslCd;
	}
}