/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0020Event.java
*@FileTitle : Rail Billing Request Creation Excel 조회 (Full)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Hashtable;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.RailBillingReqCreateRSC;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EXP_PAP_020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0020Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private TrsRailOrderKey[] trsRailOrderKeyList = null;
	

    /**
     * ExpPap0020Event 객체를 생성
     */
    public ExpPap0020Event(){}

    /**
     * ExpPap0020Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param trsRailOrderKeyList
     */
    public ExpPap0020Event(
    		String user_id,
    		String vender_cd,
    		TrsRailOrderKey[] trsRailOrderKeyList
    		) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.trsRailOrderKeyList	= trsRailOrderKeyList;
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
	 * @return Returns the trsRailOrderKeyList.
	 */
	public TrsRailOrderKey[] getTrsRailOrderKeyList() {
		return trsRailOrderKeyList;
	}
	/**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0020Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0020Event";
    }
}