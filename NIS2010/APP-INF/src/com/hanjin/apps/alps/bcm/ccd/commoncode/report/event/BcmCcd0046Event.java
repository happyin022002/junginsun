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
 * BCM_CCD_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0046HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0046Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	 private String ydCd = null;
	 private String ydNm = null;
	 private String locCd  = null;
	 private String ofcCd  = null;
	 private String dmdtOfcCd  = null;
	 private String status  = null;
	    
	    
	    /**
	     * Constructor<br>
	     */
	 public BcmCcd0046Event(){}

	    /**
	     * Constructor<br>
	     * @param ydCd
	     * @param ydNm
	     * @param locCd
	     * @param ofcCd
	     * @param dmdtOfcCd
	     * @param status
	     */
	 public BcmCcd0046Event(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) {
	    	this.ydCd     	= ydCd;
	    	this.ydNm 	    = ydNm;
	    	this.locCd     	= locCd;
	    	this.ofcCd     	= ofcCd;
	    	this.dmdtOfcCd  = dmdtOfcCd;
	    	this.status     = status;
	  }

		public String getYdCd() {
			return ydCd;
		}

		public void setYdCd(String ydCd) {
			this.ydCd = ydCd;
		}

		public String getYdNm() {
			return ydNm;
		}

		public void setYdNm(String ydNm) {
			this.ydNm = ydNm;
		}

		public String getLocCd() {
			return locCd;
		}

		public void setLocCd(String locCd) {
			this.locCd = locCd;
		}

		public String getOfcCd() {
			return ofcCd;
		}

		public void setOfcCd(String ofcCd) {
			this.ofcCd = ofcCd;
		}
		
		public String getDmdtOfcCd() {
			return dmdtOfcCd;
		}

		public void setDmdtOfcCd(String dmdtOfcCd) {
			this.dmdtOfcCd = dmdtOfcCd;
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