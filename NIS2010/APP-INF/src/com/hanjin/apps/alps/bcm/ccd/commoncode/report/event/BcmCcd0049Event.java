/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0049Event.java
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
 * BCM_CCD_0049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0049HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	 private String vslCd = null;
	 private String vslEngNm = null;
	 private String crrCd  = null;
	 private String fdrDivCd  = null;
	 private String status  = null;
	    
	    
	    /**
	     * Constructor<br>
	     */
	 public BcmCcd0049Event(){}

	    /**
	     * Constructor<br>
	     * @param vslCd
	     * @param vslEngNm
	     * @param crrCd
	     * @param fdrDivCd
	     * @param status
	     */
	 public BcmCcd0049Event(String vslCd,String vslEngNm,String crrCd,String fdrDivCd,String status) {
	    	this.vslCd     	= vslCd;
	    	this.vslEngNm   = vslEngNm;
	    	this.crrCd     	= crrCd;
	    	this.fdrDivCd   = fdrDivCd;
	    	this.status     = status;
	  }

		public String getVslCd() {
			return vslCd;
		}

		public void setVslCd(String vslCd) {
			this.vslCd = vslCd;
		}

		
		public String getVslEngNm() {
			return vslEngNm;
		}

		public void setVslEngNm(String vslEngNm) {
			this.vslEngNm = vslEngNm;
		}

		public String getCrrCd() {
			return crrCd;
		}

		public void setCrrCd(String crrCd) {
			this.crrCd = crrCd;
		}

		public String getFdrDivCd() {
			return fdrDivCd;
		}

		public void setFdrDivCd(String fdrDivCd) {
			this.fdrDivCd = fdrDivCd;
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