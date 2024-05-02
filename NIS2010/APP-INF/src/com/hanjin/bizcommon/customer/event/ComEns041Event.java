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
package com.hanjin.bizcommon.customer.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_ENS_041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sangyool pak
 * @see HTMLAction 참조 
 * @since J2EE 1.4
 */public class ComEns041Event extends EventSupport {

    private String custCd = "";
    private String custNm = "";
    private String ofcCd  = "";
    private String include = "";
    private String cust = "";
    private String zipCd = "";
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
    public ComEns041Event(String custCd, String custNm, String ofcCd, int iPage, String include, String cust, String zipCd) {
        this.custCd = custCd;
        this.custNm = custNm;
        this.ofcCd  = ofcCd;
        this.iPage   = iPage;
        this.include = include;
        this.zipCd = zipCd;
        this.cust = cust;
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
}
