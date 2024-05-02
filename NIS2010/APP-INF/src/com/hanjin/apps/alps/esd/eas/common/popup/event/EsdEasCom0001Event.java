/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : 
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2007-11-27
*@LastModifier : yujin
*@LastVersion : 1.0
* 2007-11-27 yujin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.common.popup.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.eas.common.util.RequestDataSet;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_COM_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_EAS_COM_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yujin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdEasCom0001Event extends EventSupport {

	private String ctrlOfcCd = null;
	private String selOfcCd  = null;
	
	/**
	 * EsdEasCom0001Event 초기 클래스 생성
	 */
	public EsdEasCom0001Event(){}
	
	
	public String getCtrl_ofc_cd() {
		return ctrlOfcCd;
	}


	public void setCtrl_ofc_cd(String ctrl_ofc_cd) {
		this.ctrlOfcCd = ctrl_ofc_cd;
	}


	public String getSel_ofc_cd() {
		return selOfcCd;
	}


	public void setSel_ofc_cd(String sel_ofc_cd) {
		this.selOfcCd = sel_ofc_cd;
	}


	public String getEventName() {
		return "EsdEasCom0001Event";
	}

	public String toString() {
		return "EsdEasCom0001Event";
	}

}
