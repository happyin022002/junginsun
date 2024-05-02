/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0025Event.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.event;

import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	 private String ofcCd = null;
	 private String ofcEngNm = null;
	 private String locCd  = null;
	 private String ofcKndCd  = null;
	 private String status  = null;
	    
	    
	    /**
	     * Constructor<br>
	     */
	 public BcmCcd0048Event(){}

	    /**
	     * Constructor<br>
	     * @param ofcCd
	     * @param ofcEngNm
	     * @param locCd
	     * @param ofcKndCd
	     * @param status
	     */
	 public BcmCcd0048Event(String ofcCd,String ofcEngNm,String locCd,String ofcKndCd,String status) {
	    	this.ofcCd     	= ofcCd;
	    	this.ofcEngNm 	    = ofcEngNm;
	    	this.locCd     	= locCd;
	    	this.ofcKndCd    = ofcKndCd;
	    	this.status     = status;
	  }

		public String getOfcCd() {
			return ofcCd;
		}

		public void setOfcCd(String ofcCd) {
			this.ofcCd = ofcCd;
		}

		public String getOfcEngNm() {
			return ofcEngNm;
		}

		public void setOfcEngNm(String ofcEngNm) {
			this.ofcEngNm = ofcEngNm;
		}

		public String getLocCd() {
			return locCd;
		}

		public void setLocCd(String locCd) {
			this.locCd = locCd;
		}

		public String getOfcKndCd() {
			return ofcKndCd;
		}

		public void setOfcKndCd(String ofcKndCd) {
			this.ofcKndCd = ofcKndCd;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public static long getSerialVersionUID() {
			return serialVersionUID;
		}

		
	 
	
}