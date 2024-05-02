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
 * COM_ENS_043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_ENS_043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sangyool pak
 * @see HTMLAction 참조 
 * @since J2EE 1.4
 */
public class ComEns043Event extends EventSupport {

    private String srepCd = "";
    private String srepNm = "";
    private String ofcCd  = "";
    private String gloUsrId  = "";
    //private String deltFlg = "";
    int    iPage   = 0;

    /**
     * Constructor<br>
     */
    public ComEns043Event(){}

	/**
     * S.Rep Code 반환<br>
     * @return
     */
    
    public String getSrepCd() {
		return srepCd;
	}

	/**
	 * S.Rep Code 세팅<br>
	 * @param ofcCd
	 */

	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}

	/**
     * S.Rep Name  반환<br>
     * @return
     */

	public String getSrepNm() {
		return srepNm;
	}

	/**
	 * S.Rep Name 세팅<br>
	 * @param ofcCd
	 */

	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}

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
     * Global User ID 반환<br>
     * @return
     */
    public String getGloUsrId() {
		return gloUsrId;
	}

	/**
	 * Global User ID 세팅<br>
	 * @param ofcCd
	 */
	public void setGloUsrId(String gloUsrId) {
		this.gloUsrId = gloUsrId;
	}
	
    
    /**
     * 
     * @param String srepCd
     * @param String srepNm
     * @param String ofcCd
     * @param int iPage
     */
    public ComEns043Event(String srepCd, String srepNm, String ofcCd, String gloUsrId, int iPage) {
        this.srepCd = srepCd;
        this.srepNm = srepNm;
        this.ofcCd  = ofcCd;
        this.gloUsrId = gloUsrId;
        this.iPage   = iPage;
        //this.deltFlg = deltFlg;
    }

    /**
     * Event 명을 반환<br>
     * @return String
     */
    public String getEventName() {
        return "ComEns043Event";
    }

    /**
     * Class 명을 반환<br>
     * @return String
     */
    public String toString() {
        return "ComEns043Event";
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
	
	/**
	 * Delt Flg 반환<br>
	 * @return String
	 */
/*	public String getDeltFlg() {
		return deltFlg;
	}
	*//**
	 * Delt Flg 세팅<br>
	 * @param deltFlg
	 *//*
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}*/


}
