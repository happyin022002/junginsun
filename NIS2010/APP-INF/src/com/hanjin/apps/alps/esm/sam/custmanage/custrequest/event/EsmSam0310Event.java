/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_SAM_0310Event.java
*@FileTitle : CustomerGroup
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-21
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2012-02-21 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM0310 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SAM0310HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lim Jaekwan
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmSam0310Event extends EventSupport {

	    private String rqstNo = "";
	    private String custNm = "";
	    private String ofcCd  = "";
	    private String deltFlg = "";
	    private String rqstFmDt = "";
	    private String rqstToDt = "";
	    private String creFmDt = "";
	    private String creToDt = "";
	    int    iPage   = 0;

	    /**
	     * Constructor<br>
	     */
	    public EsmSam0310Event(){}

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
	    public String getDeltFlg() {
			return deltFlg;
		}
		
		/**
		 * Delt flag 세팅<br>
		 * @param deltFlg
		 */
		public void setDeltFlg(String deltFlg) {
			this.deltFlg = deltFlg;
		}
		
	    /**
	     * rqst date 반환<br>
	     * @return
	     */
	    public String getRqstFmDt() {
			return rqstFmDt;
		}
		
		/**
		 * rqst date 세팅<br>
		 * @param deltFlg
		 */
		public void setRqstFmDt(String rqstFmDt) {
			this.rqstFmDt = rqstFmDt;
		}
		
	    /**
	     * rqst date 반환<br>
	     * @return
	     */
	    public String getRqstToDt() {
			return rqstToDt;
		}
		
		/**
		 * rqst date 세팅<br>
		 * @param deltFlg
		 */
		public void setRqstToDt(String rqstToDt) {
			this.rqstToDt = rqstToDt;
		}
		
		/**
	     * cre date 반환<br>
	     * @return
	     */
	    public String getCreFmDt() {
			return creFmDt;
		}
		
		/**
		 * cre date 세팅<br>
		 * @param creFmDt
		 */
		public void setCreFmDt(String creFmDt) {
			this.creFmDt = creFmDt;
		}
		
	    /**
	     * cre date 반환<br>
	     * @return
	     */
	    public String getCreToDt() {
			return creToDt;
		}
		
		/**
		 * cre date 세팅<br>
		 * @param creToDt
		 */
		public void setCreToDt(String creToDt) {
			this.creToDt = creToDt;
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
	    public EsmSam0310Event(String rqstNo, String custNm, String ofcCd, int iPage, String deltFlg, String rqst_fm_dt, String rqst_to_dt, String cre_fm_dt, String cre_to_dt) {
	        this.rqstNo = rqstNo;
	        this.custNm = custNm;
	        this.ofcCd  = ofcCd;
	        this.iPage   = iPage;
	        this.deltFlg = deltFlg;
	        this.rqstFmDt   = rqst_fm_dt;
	        this.rqstToDt = rqst_to_dt;
	        this.creFmDt   = cre_fm_dt;
	        this.creToDt = cre_to_dt;
	    }

	    /**
	     * Event 명을 반환<br>
	     * @return String
	     */
	    public String getEventName() {
	        return "EsmSam0310Event";
	    }

	    /**
	     * Class 명을 반환<br>
	     * @return String
	     */
	    public String toString() {
	        return "EsmSam0310Event";
	    }

		/**
		 * Cust Code 반환<br>
		 * @return
		 */
		public String getRqstNo() {
			return rqstNo;
		}

		/**
		 * Cust Code 세팅<br>
		 * @param custCd
		 */
		public void setRqstNo(String rqstNo) {
			this.rqstNo = rqstNo;
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

	
}
