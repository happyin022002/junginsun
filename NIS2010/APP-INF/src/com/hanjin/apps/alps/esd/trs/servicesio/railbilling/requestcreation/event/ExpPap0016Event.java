/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0016Event.java
*@FileTitle : Rail Billing Request Creation 조회 (Empty)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EXP_PAP_016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0016Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;

    /**
     * ExpPap0016Event 객체를 생성
     */
    public ExpPap0016Event(){}

    /**
     * ExpPap0016Event 객체를 생성
     * @param user_id
     * @param vender_cd
     */
    public ExpPap0016Event(String user_id,
    						String vender_cd) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
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
	public String getEventName() {
        return "ExpPap0016Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0016Event";
    }
}