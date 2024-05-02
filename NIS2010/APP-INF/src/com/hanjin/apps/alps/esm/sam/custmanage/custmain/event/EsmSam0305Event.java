/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmSam0305Event.java
*@FileTitle : Customer Main List 
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-21
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2012-02-21 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_COM_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_COM_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jaekwan
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */public class EsmSam0305Event extends EventSupport {

	    private String custCd = "";
	    private String custNm = "";
	    private String ofcCd  = "";
	    private String include = ""; 
	    private String cust = "";
	    private String zipCd = "";
	    private String custGrpId = "";
	    private String locCd = "";
	    private String steCd = "";
	    private String srepCd = "";
	    private String deltFlg = "";
	    int    iPage   = 0;

	    /**
	     * Constructor<br>
	     */
	    public EsmSam0305Event(){}

	    /**
	     * Office Code 반환<br>
	     * @return
	     */
	    public String getOfcCd() {
			return ofcCd;
		}

		/**
		 * Office Code 세팅<br>
		 * @param ofcCd
		 */
		public void setOfcCd(String ofcCd) {
			this.ofcCd = ofcCd;
		}	
		
	    /**
	     * Zip Code 반환<br>
	     * @return
	     */
	    public String getZipCd() {
			return zipCd;
		}
		
		/**
		 * Zip Code 세팅<br>
		 * @param zipCd
		 */
		public void setZipCd(String zipCd) {
			this.zipCd = zipCd;
		}
	    
	    /**
	     * 
	     * @param String custCd
	     * @param String custNm
	     * @param String ofcCd
	     * @param int iPage
	     * @param String include
	     * @param String cust
	     * @param String zipCd
	     */
	    public EsmSam0305Event(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd, String custGrpId, String locCd, String steCd, String srepCd, String deltFlg) {
	        this.custCd = custCd;
	        this.custNm = custNm;
	        this.ofcCd  = ofcCd;
	        this.iPage   = iPage;
	        this.include = include;
	        this.zipCd = zipCd;
	        this.cust = cust;
	        this.custGrpId = custGrpId;
	        this.locCd = locCd;
	        this.steCd = steCd;
	        this.srepCd = srepCd;
	        this.deltFlg = deltFlg;
	    }

	    /**
	     * Event 명을 반환<br>
	     * @return String
	     */
	    public String getEventName() {
	        return "EsmSam0305Event";
	    }

	    /**
	     * Class 명을 반환<br>
	     * @return String
	     */
	    public String toString() {
	        return "EsmSam0305Event";
	    }

		/**
		 * Cust Code 반환<br>
		 * @return
		 */
		public String getCustCd() {
			return custCd;
		}

		/**
		 * Cust Code 세팅<br>
		 * @param custCd
		 */
		public void setCustCd(String custCd) {
			this.custCd = custCd;
		}

		/**
		 * Cust Name 반환<br>
		 * @return
		 */
		public String getCustNm() {
			return custNm;
		}

		/**
		 * Cust Name 세팅<br>
		 * @param custNm
		 */
		public void setCustNm(String custNm) {
			this.custNm = custNm;
		}

		/**
		 * Page No 반환<br>
		 * @return
		 */
		public int getIPage() {
			return iPage;
		}

		/**
		 * Page No 세팅<br>
		 * @param page
		 */
		public void setIPage(int page) {
			iPage = page;
		}

		public String getInclude() {
			return include;
		}

		public void setInclude(String include) {
			this.include = include;
		}

		public String getCust() {
			return cust;
		}

		public void setCust(String cust) {
			this.cust = cust;
		}
		
		public String getCustGrpId() {
			return custGrpId;
		}

		public void setCustGrpId(String custGrpId) {
			this.custGrpId = custGrpId;
		}
		
		public String getLocCd() {
			return locCd;
		}

		public void setLocCd(String locCd) {
			this.locCd = locCd;
		}
	
		public String getSteCd() {
			return steCd;
		}

		public void setSteCd(String steCd) {
			this.steCd = steCd;
		}
		
		public String getSrepCd() {
			return srepCd;
		}

		public void setSrepCd(String srepCd) {
			this.srepCd = srepCd;
		}
		
		/**
		 * Delt Flg 반환<br>
		 * @return String
		 */
		public String getDeltFlg() {
			return deltFlg;
		}
		/**
		 * Delt Flg 세팅<br>
		 * @param deltFlg
		 */
		public void setDeltFlg(String deltFlg) {
			this.deltFlg = deltFlg;
		}
	
}
