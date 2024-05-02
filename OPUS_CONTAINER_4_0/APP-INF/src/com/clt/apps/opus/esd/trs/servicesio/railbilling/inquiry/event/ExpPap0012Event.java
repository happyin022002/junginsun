/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0012Event.java
*@FileTitle : Rail Billing Inquiry 조회 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EXP_PAP_012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0012Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String userRoleCd = null; // 2007-10-26 almighty 계정 구분 추가 
	private RailBillingInquiryCond railBillingInquiryCond   = null;

    /**
     * ExpPap0012Event 객체를 생성
     */
    public ExpPap0012Event(){}

    /**
     * ExpPap0012Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param user_role_cd
     * @param railBillingInquiryCond
     */
    public ExpPap0012Event(String user_id,
							String vender_cd,	
							String user_role_cd,
							RailBillingInquiryCond railBillingInquiryCond) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.userRoleCd	= user_role_cd;
    	this.railBillingInquiryCond	= railBillingInquiryCond;
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
	 * @return Returns the user_role_cd.
	 */
	public String getUser_role_cd() {
		return userRoleCd;
	}

	/**
     * 
     * @return
     */
	public RailBillingInquiryCond getRailBillingInquiryCond() {
		return railBillingInquiryCond;
	}
    /**
     * 
     * @return
     */
	public void setRailBillingInquiryCond(RailBillingInquiryCond railBillingInquiryCond) {
		this.railBillingInquiryCond = railBillingInquiryCond;
	}
    /**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0012Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0012Event";
    }

}