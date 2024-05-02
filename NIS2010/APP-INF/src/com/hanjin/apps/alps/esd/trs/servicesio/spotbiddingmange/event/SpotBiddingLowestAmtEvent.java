/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingListSendEvent.java
*@FileTitle : Spot Bidding Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmt;
import java.util.Arrays;

/**
* DTO(Data Transfer Object including Parameters)<br>
* RailBillingReqCreateRSC에서 작성<br>
* - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
*
* @author SHIN DONG IL
* @see SpotBiddingManageRSC 참조
* @since J2EE 1.6
*/
public class SpotBiddingLowestAmtEvent extends EventSupport {
	
	private SpotBiddingLowestAmt[] spotBiddingLowestAmt = null;
	private String vndr_seq = "";
	
	public String getVndr_seq() {
		return vndr_seq;
	}

	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}

	public SpotBiddingLowestAmt[] getSpotBiddingLowestAmt() {
		SpotBiddingLowestAmt[] rtnArr = null;
		if(this.spotBiddingLowestAmt != null){
			rtnArr = Arrays.copyOf(spotBiddingLowestAmt,spotBiddingLowestAmt.length);
						
		}
		return rtnArr;
	}

	public void setSpotBiddingLowestAmt(SpotBiddingLowestAmt[] spotBiddingLowestAmt) {
		if(spotBiddingLowestAmt != null){
			SpotBiddingLowestAmt[] tmpArr = Arrays.copyOf(spotBiddingLowestAmt,spotBiddingLowestAmt.length);
		   this.spotBiddingLowestAmt = tmpArr;
		}
	}
	
	/**
	 * 
	 * @param spotBiddingLowestAmt
	 */
	public SpotBiddingLowestAmtEvent(SpotBiddingLowestAmt[] spotBiddingLowestAmt,String vndr_seq){
		this.spotBiddingLowestAmt = spotBiddingLowestAmt;
		this.vndr_seq = vndr_seq;
	}
}