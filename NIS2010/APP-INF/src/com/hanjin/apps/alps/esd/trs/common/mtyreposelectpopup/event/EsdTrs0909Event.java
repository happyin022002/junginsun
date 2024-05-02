/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_909Event.java
*@FileTitle : Empty Repo Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-25
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-03-25 eunju son
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.event;

import java.util.Collection;

import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TRS_909 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_909HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0909Event extends EventSupport {

	private Collection trsTrspSvcOrds = null;
	private String mtyBkgNo = null;
	
	public EsdTrs0909Event(){}

	/**
	 * @param trsTrspSvcOrdsValue
	 */
	public EsdTrs0909Event(Collection trsTrspSvcOrdsValue){
		this.trsTrspSvcOrds = trsTrspSvcOrdsValue;
	}
		
	public Collection getTRS_TRSP_SVC_ORDs(){
		return this.trsTrspSvcOrds;
	}
	
	public String getEventName() {
		return "EsdTrs0909Event";
	}

	public String toString() {
		return "EsdTrs0909Event";
	}

	public void setMty_bkg_no(String mtyBkgNo) {
		this.mtyBkgNo = mtyBkgNo;
	}

	public String getMty_bkg_no() {
		return mtyBkgNo;
	}

}
