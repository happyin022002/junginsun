/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_933Event.java
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TRS_933 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_933HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0933Event extends EventSupport {

	String bkgNumber;
	String blNumber;
	String cntrNumber;
	String tpSzNumber;
	String troSeq;
	
	
	public void setBkgNumber(String bkgNumber){
		this.bkgNumber = bkgNumber;
	}
	
	public String getBkgNumber(){
		return bkgNumber;
	}
	
	public void setBlNumber(String blNumber){
		this.blNumber = blNumber;
	}
	
	public String getBlNumber(){
		return blNumber;
	}
	
	public void setCntrNumber(String cntrNumber){
		this.cntrNumber = cntrNumber;
	}
	
	public String getCntrNumber(){
		return cntrNumber;
	}
	
	public void setTpSzNumber(String tpSzNumber){
		this.tpSzNumber = tpSzNumber;
	}
	
	public String getTpSzNumber(){
		return tpSzNumber;
	}
	
	public void setTroSeq(String troSeq){
		this.troSeq = troSeq;
	}
	
	public String getTroSeq(){
		return troSeq;
	}

	/** getEventName */
	public String getEventName() {
		return "EsdTrs0933Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0933Event";
	}

}
