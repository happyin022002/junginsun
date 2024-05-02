/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_ENS_041Event.java
*@FileTitle : Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-09 sangyool pak
* 1.0 최초 생성
=========================================================*/
package com.clt.bizcommon.customer.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sangyool pak
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */public class ComEns041Event extends EventSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custCd = "";
    private String custNm = "";
    private String ofcCd  = "";
    private String include = "";
    private String cust = "";
    private String locCd = "";
    
    /*
     * 20120207 added by JUN SUNG, KIM
     * mdm yn 관련 추가 param
     * mdmyn , deltflg
     */
    private String mdmYN = "";
    private String deltFlg = "";
    private String creditFlg = "";
    
    int    iPage   = 0;

    /**
     * Constructor<br>
     */
    public ComEns041Event(){}

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
     * 
     * @param String custCd
     * @param String custNm
     * @param String ofcCd
     * @param int iPage
     * @param String include
     * @param String cust
     */
    public ComEns041Event(String custCd, String custNm, String ofcCd, int iPage, String include, String cust) {
        this.custCd = custCd;
        this.custNm = custNm;
        this.ofcCd  = ofcCd;
        this.iPage   = iPage;
        this.include = include;
        this.cust = cust;
    }
    
    /**
     * 
     * @param String custCd
     * @param String custNm
     * @param String ofcCd
     * @param int iPage
     * @param String include
     * @param String cust
     * @param String mdm_yn
     * @param String delt_flg
     * @param String locCd
     * @param String creditFlg
     */
    public ComEns041Event(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String mdm_yn, String delt_flg, String locCd, String creditFlg) {
    	this.custCd = custCd;
    	this.custNm = custNm;
    	this.ofcCd  = ofcCd;
    	this.iPage   = iPage;
    	this.include = include;
    	this.cust = cust;
    	this.mdmYN = mdm_yn;
    	this.deltFlg = delt_flg;
    	this.locCd = locCd;
        this.creditFlg = creditFlg;
	}

	/**
     * Event 명을 반환<br>
     * @return String
     */
    public String getEventName() {
        return "ComEns041Event";
    }

    /**
     * Class 명을 반환<br>
     * @return String
     */
    public String toString() {
        return "ComEns041Event";
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

	public String getMdmYN() {
		return mdmYN;
	}

	public void setMdmYN(String mdmYN) {
		this.mdmYN = mdmYN;
	}

	public String getDeltFlg() {
		return deltFlg;
	}

	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getCreditFlg() {
		return creditFlg;
	}

	public void setCreditFlg(String creditFlg) {
		this.creditFlg = creditFlg;
	}
	
}
