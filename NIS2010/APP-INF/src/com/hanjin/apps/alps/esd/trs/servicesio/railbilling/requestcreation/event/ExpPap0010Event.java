/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0010Event.java
*@FileTitle : Rail Billing Request Creation 조회 (Full)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.RailBillingReqCreateRSC;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EXP_PAP_010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0010Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String bkgNo   = null;

    /**
     * ExpPap0010Event 객체를 생성
     */
    public ExpPap0010Event(){}

    /**
     * ExpPap0010Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param bkg_no
     */
    public ExpPap0010Event(
    		String user_id,
    		String vender_cd,
    		String bkg_no) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.bkgNo	= bkg_no;
    }
    
    /**
     * 
     * @return
     */
	public String getUser_id() {
		return userId;
	}
    /**
     * 
     * @return
     */
	public String getVender_cd() {
		return venderCd;
	}
    /**
     * 
     * @return
     */
	public String getBkg_no() {
		return bkgNo;
	}
    /**
     * 
     * @return
     */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}
	
	/**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0010Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0010Event";
    }
}