/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmSam0304Event.java
*@FileTitle : customer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.event;

import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM_0304 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0304HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESM_SAM_0304HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0304Event extends EventSupport {

    private String custCntCd = "";
    private String custNm = "";
    private String locCd  = "";
    private String custRgstNo= "";
    private String matchRule= "";
    
   
    int    iPage   = 0;

    /**
     * Constructor<br>
     */
    public EsmSam0304Event(){}

    
    /**
     * 
     * @param String custCntCd
     * @param String custNm
     * @param String locCd
     * @param String custRgstNo
     * @param String matchRule
     * @param int iPage
     */
    public EsmSam0304Event(String custCntCd, String custNm, String locCd, String custRgstNo, String matchRule, int iPage) {
        this.custCntCd = custCntCd;
        this.custNm = custNm;
        this.locCd  = locCd;
        this.custRgstNo =  custRgstNo;
        this.matchRule = matchRule;
        this.iPage   = iPage;

    }

  
	/**
     * Event 명을 반환<br>
     * @return String
     */
    public String getEventName() {
        return "EsmSam0304Event";
    }

    /**
     * Class 명을 반환<br>
     * @return String
     */
    public String toString() {
        return "EsmSam0304Event";
    }

	/**
	 * Cust Code 반환<br>
	 * @return
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * Cust Code 세팅<br>
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
     * locCd 반환<br>
     * @return
     */
    public String getLocCd() {
		return locCd;
	}

	/**
	 *locCd 세팅<br>
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}	
	
	/**
	 * Cust RgstNo 세팅<br>
	 * @param custRgstNo
	 */	
	public String getCustRgstNo() {
		return custRgstNo;
	}

	/**
	 * Cust RgstNo 세팅<br>
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
	}
	/**
	 * match_rule 세팅<br>
	 * @param matchRule
	 */
	
	public String getMatchRule() {
		return matchRule;
	}

	public void setMatchRule(String matchRule) {
		this.matchRule = matchRule;
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