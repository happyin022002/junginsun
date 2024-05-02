/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0050Event.java
*@FileTitle : Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0050HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	 private String chgCd = null;
	 private String chgNm = null;
	 private String repChgCd  = null;
	 private String status  = null;
	    
	    
	    /**
	     * Constructor<br>
	     */
	 public BcmCcd0050Event(){}

	    /**
	     * Constructor<br>
	     * @param chgCd
	     * @param chgNm
	     * @param repChgCd
	     * @param status
	     */
	 public BcmCcd0050Event(String chgCd,String chgNm,String repChgCd,String status) {
	    	this.chgCd    = chgCd;
	    	this.chgNm    = chgNm;
	    	this.repChgCd = repChgCd;
	    	this.status   = status;
	  }

		public String getChgCd() {
			return chgCd;
		}

		public void setChgCd(String chgCd) {
			this.chgCd = chgCd;
		}

		public String getChgNm() {
			return chgNm;
		}

		public void setChgNm(String chgNm) {
			this.chgNm = chgNm;
		}

		public String getRepChgCd() {
			return repChgCd;
		}

		public void setRepChgCd(String repChgCd) {
			this.repChgCd = repChgCd;
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