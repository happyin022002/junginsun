/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0019Event.java
*@FileTitle : Rail Billing Common 조회 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.railbillingcommon.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * ExpPap0019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0019Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String mainFlag = null; //2007-09-10 main 화면 조회 구분 추가

    /**
     * ExpPap0019Event 객체를 생성
     */
    public ExpPap0019Event(){}

    /**
     * ExpPap0019Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param mainFlag
     */
    public ExpPap0019Event(
    		String user_id,
    		String vender_cd,
    		String mainFlag
    		) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.mainFlag	= mainFlag;
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
	 * @return Returns the mainFlag.
	 */
	public String getMainFlag() {
		return mainFlag;
	}

	/**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0019Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0019Event";
    }
}