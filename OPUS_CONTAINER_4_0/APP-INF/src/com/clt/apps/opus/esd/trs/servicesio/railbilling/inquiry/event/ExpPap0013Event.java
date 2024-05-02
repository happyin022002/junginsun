/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0013Event.java
*@FileTitle : Rail Billing Request Cancel 처리 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * EXP_PAP_013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0013Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private RailBillingInquiry[] railBillingInquiryList   = null;

    /**
     * ExpPap0013Event 객체를 생성
     */
    public ExpPap0013Event(){}

    /**
     * ExpPap0013Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param railBillingInquiryList
     */
    public ExpPap0013Event(String user_id,
    						String vender_cd,
    						RailBillingInquiry[] railBillingInquiryList) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.railBillingInquiryList	= railBillingInquiryList;
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
	public RailBillingInquiry[] getRailBillingInquiryList() {
		RailBillingInquiry[] rtnList = null;
		if(this.railBillingInquiryList != null){
			rtnList = Arrays.copyOf(railBillingInquiryList, railBillingInquiryList.length);
		}
		return rtnList;
	}
    /**
     * 
     * @return
     */
	public void setRailBillingInquiryList(RailBillingInquiry[] railBillingInquiryList) {
		if(railBillingInquiryList != null){
			RailBillingInquiry[] tmpList = Arrays.copyOf(railBillingInquiryList, railBillingInquiryList.length);
			this.railBillingInquiryList = tmpList;
		}
	}
    /**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0013Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0013Event";
    }
}