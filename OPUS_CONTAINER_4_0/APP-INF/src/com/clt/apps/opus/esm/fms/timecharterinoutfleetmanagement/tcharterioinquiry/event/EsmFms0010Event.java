/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0010Event.java
*@FileTitle : Statement of Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.10 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see ESM_FMS_0010HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String fletCtrtNo =  "";
	
	private String hirNo =  "";

	public EsmFms0010Event(){}
	
	public void setFletCtrtNo(String fletCtrtNo){
		this. fletCtrtNo = fletCtrtNo;
	}

	public String getFletCtrtNo(){
		return fletCtrtNo;
	}
	
	public void setHirNo(String hirNo){
		this. hirNo = hirNo;
	}

	public String getHirNo(){
		return hirNo;
	}
}