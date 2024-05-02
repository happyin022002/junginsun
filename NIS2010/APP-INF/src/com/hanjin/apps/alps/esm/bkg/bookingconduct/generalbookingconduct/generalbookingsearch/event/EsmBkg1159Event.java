/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1159Event.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.21
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2009.05.21 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchCustomerInqryCondVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;


/**
 * ESM_BKG_1159 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1159HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author wonjoo cho
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */public class EsmBkg1159Event extends EventSupport {

    private String custCd = "";
    private String custNm = "";
    private String ofcCd  = "";
    private String include = "";
    private String cust = "";
    int    iPage   = 0;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerInqryCondVO searchCustomerInqryCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchCustomerInqryCondVO[] searchCustomerInqryCondVOs = null;

    /**
     * Constructor<br>
     */
    public EsmBkg1159Event(){}

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
	
	public void setSearchCustomerInqryCondVO(SearchCustomerInqryCondVO searchCustomerInqryCondVO){
		this. searchCustomerInqryCondVO = searchCustomerInqryCondVO;
	}

	public void setSearchCustomerInqryCondVOS(SearchCustomerInqryCondVO[] searchCustomerInqryCondVOs){
		this. searchCustomerInqryCondVOs = searchCustomerInqryCondVOs;
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
    public EsmBkg1159Event(String custCd, String custNm, String ofcCd, int iPage, String include, String cust) {
        this.custCd = custCd;
        this.custNm = custNm;
        this.ofcCd  = ofcCd;
        this.iPage   = iPage;
        this.include = include;
        this.cust = cust;
    }

    /**
     * Event 명을 반환<br>
     * @return String
     */
    public String getEventName() {
        return "EsmBkg1159Event";
    }

    /**
     * Class 명을 반환<br>
     * @return String
     */
    public String toString() {
        return "EsmBkg1159Event";
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
	
	public SearchCustomerInqryCondVO getSearchCustomerInqryCondVO(){
		return searchCustomerInqryCondVO;
	}

	public SearchCustomerInqryCondVO[] getSearchCustomerInqryCondVOS(){
		return searchCustomerInqryCondVOs;
	}
}
