/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpPap0018Event.java
*@FileTitle : Rail Billing Request Creation 처리 (Empty)
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
 * EXP_PAP_018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - RailBillingReqCreateRSC에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author leebh
 * @see RailBillingReqCreateRSC 참조
 * @since J2EE 1.4
 */
public class ExpPap0018Event extends EventSupport {

    /** (Param 객체) */
	private String userId   = null;
	private String venderCd   = null;
	private String locCd   = null;
	private String ydCd   = null;
	private VndrUserDetail vndrUserDetailInfo = null;
	private EmptyContainer[] emptyContainerList = null;
	

    /**
     * ExpPap0018Event 객체를 생성
     */
    public ExpPap0018Event(){}

    /**
     * ExpPap0018Event 객체를 생성
     * @param user_id
     * @param vender_cd
     * @param loc_cd
     * @param yd_cd
     * @param vndrUserDetailInfo
     * @param emptyContainerList
     */
    public ExpPap0018Event(
    		String user_id,
    		String vender_cd,
    		String loc_cd,
    		String yd_cd,
    		VndrUserDetail vndrUserDetailInfo,
    		EmptyContainer[] emptyContainerList
    		) {
    	this.userId	= user_id;
    	this.venderCd	= vender_cd;
    	this.locCd	= loc_cd;
    	this.ydCd	= yd_cd;
    	this.vndrUserDetailInfo	= vndrUserDetailInfo;
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
	 * @param emptyContainerList The emptyContainerList to set.
	 */
	public void setEmptyContainerList(EmptyContainer[] emptyContainerList) {
		if(emptyContainerList != null){
			EmptyContainer[] tmpList = Arrays.copyOf(emptyContainerList, emptyContainerList.length);
			this.emptyContainerList = tmpList;
		}
	}

	/**
	 * @return Returns the loc_cd.
	 */
	public String getLoc_cd() {
		return locCd;
	}

	/**
	 * @return Returns the vndrUserDetailInfo.
	 */
	public VndrUserDetail getVndrUserDetailInfo() {
		return vndrUserDetailInfo;
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
        return "ExpPap0018Event";
    }
    /**
     * 
     * @return
     */
    public String toString() {
        return "ExpPap0018Event";
    }
}