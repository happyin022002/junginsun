/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1002Event.java
*@FileTitle : Pre-Hold Notice Setup copy Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1002Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String fmOfcCd = "";
	
	private String fmPodCd = "";

	private String ofcCd = "";
	
	private String podCd = "";
	
	private String ntcTpCd = "";

	public EsmBkg1002Event(){}

	/**
	 * @param fmOfcCd the fmOfcCd to set
	 */
	public void setFmOfcCd(String fmOfcCd) {
		this.fmOfcCd = fmOfcCd;
	}

	/**
	 * @return the fmOfcCd
	 */
	public String getFmOfcCd() {
		return fmOfcCd;
	}

	/**
	 * @param fmPodCd the fmPodCd to set
	 */
	public void setFmPodCd(String fmPodCd) {
		this.fmPodCd = fmPodCd;
	}

	/**
	 * @return the fmPodCd
	 */
	public String getFmPodCd() {
		return fmPodCd;
	}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param ntcTpCd the ntcTpCd to set
	 */
	public void setNtcTpCd(String ntcTpCd) {
		this.ntcTpCd = ntcTpCd;
	}

	/**
	 * @return the ntcTpCd
	 */
	public String getNtcTpCd() {
		return ntcTpCd;
	}
	

}