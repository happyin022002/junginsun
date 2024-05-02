/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsdEas0502Event.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event;

import java.util.Arrays;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0502 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0502HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see ESD_EAS_0501HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0502Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	public EsdEas0502Event(){}
	
	private String bseYr = "";
	private String fmDt = "";
	private String toDt = "";
	private String smmrDivCd = "";
	private String rhqCd = "";
	private String crSrcCd = "";
	public String getBseYr() {
		return bseYr;
	}
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	public String getFmDt() {
		return fmDt;
	}
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	public String getToDt() {
		return toDt;
	}
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	public String getSmmrDivCd() {
		return smmrDivCd;
	}
	public void setSmmrDivCd(String smmrDivCd) {
		this.smmrDivCd = smmrDivCd;
	}
	public String getRhqCd() {
		return rhqCd;
	}
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	public String getCrSrcCd() {
		return crSrcCd;
	}
	public void setCrSrcCd(String crSrcCd) {
		this.crSrcCd = crSrcCd;
	}
	
	
}	