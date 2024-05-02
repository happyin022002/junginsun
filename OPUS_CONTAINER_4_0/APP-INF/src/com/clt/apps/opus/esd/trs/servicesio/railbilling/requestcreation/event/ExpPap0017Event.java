/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0017Event.java
*@FileTitle : Rail Billing Request Creation Verify 조회 (Empty)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.RailBillingReqCreateRSC;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *  ExpPap0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0017Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String locCd   = null;
	private String ydCd   = null;
	private EmptyContainer[] emptyContainerList = null;
	

    /**
     * ExpPap0017Event 객체를 생성
     */
    public ExpPap0017Event(){}

    /**
     * ExpPap0017Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param loc_cd
     * @param yd_cd
     * @param emptyContainerList
     */
    public ExpPap0017Event(
    		String user_id,
    		String vender_cd,
    		String loc_cd,
    		String yd_cd,
    		EmptyContainer[] emptyContainerList
    		) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.locCd	= loc_cd;
    	this.ydCd	= yd_cd;
    	this.emptyContainerList	= emptyContainerList;
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
	public EmptyContainer[] getEmptyContainerList() {
		EmptyContainer[] rtnList = null;
		if(this.emptyContainerList != null){
			rtnList = Arrays.copyOf(emptyContainerList, emptyContainerList.length);
		}
		return rtnList;
	}
	
    /**
	 * @return Returns the loc_cd.
	 */
	public String getLoc_cd() {
		return locCd;
	}

	/**
	 * @return Returns the yd_cd.
	 */
	public String getYd_cd() {
		return ydCd;
	}

	/**
     * 
     * @return
     */
	public String getEventName() {
        return "ExpPap0017Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0017Event";
    }
}