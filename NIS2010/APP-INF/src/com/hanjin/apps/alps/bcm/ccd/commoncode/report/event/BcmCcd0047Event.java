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
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.event;
 
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0047Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	 private String znCd = null;
	 private String znNm = null;
	 private String locCd  = null;
	 private String repYdCd  = null;
	 private String status  = null;
	    
	    
	    /**
	     * Constructor<br>
	     */
	 public BcmCcd0047Event(){}

	    /**
	     * Constructor<br>
	     * @param znCd
	     * @param znNm
	     * @param locCd
	     * @param repYdCd
	     * @param status
	     */
	 public BcmCcd0047Event(String znCd,String znNm,String locCd,String repYdCd,String status) {
	    	this.znCd     	= znCd;
	    	this.znNm 	    = znNm;
	    	this.locCd     	= locCd;
	    	this.repYdCd    = repYdCd;
	    	this.status     = status;
	  }

		public String getZnCd() {
			return znCd;
		}

		public void setZnCd(String znCd) {
			this.znCd = znCd;
		}

		public String getZnNm() {
			return znNm;
		}

		public void setZnNm(String znNm) {
			this.znNm = znNm;
		}

		public String getLocCd() {
			return locCd;
		}

		public void setLocCd(String locCd) {
			this.locCd = locCd;
		}

		public String getRepYdCd() {
			return repYdCd;
		}

		public void setRepYdCd(String repYdCd) {
			this.repYdCd = repYdCd;
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