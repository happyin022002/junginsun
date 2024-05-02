/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingListResponse.java
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


import java.util.Arrays;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * -SpotBiddingListRequest 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageRSC 참조
 * @since J2EE 1.6
 */
public class SpotBiddingListEventResponse{
	private String if_flg = "";
	private String if_err_msg = "";
	private SpotBiddingListSend[] spotBiddingListSend;
	
	public SpotBiddingListEventResponse(){
	}

	public String getIf_flg() {
		return if_flg;
	}

	public void setIf_flg(String if_flg) {
		this.if_flg = if_flg;
	}

	public String getIf_err_msg() {
		return if_err_msg;
	}

	public void setIf_err_msg(String if_err_msg) {
		this.if_err_msg = if_err_msg;
	}

	public SpotBiddingListSend[] getSpotBiddingListSend() {
		SpotBiddingListSend[] rtnArr = null;
		if(this.spotBiddingListSend != null){
			rtnArr = Arrays.copyOf(spotBiddingListSend,spotBiddingListSend.length);
		}
		return rtnArr;
	}

	public void setSpotBiddingListSend(SpotBiddingListSend[] spotBiddingListSend) {
		if(spotBiddingListSend != null){
			SpotBiddingListSend[] tmpArr =  Arrays.copyOf(spotBiddingListSend,spotBiddingListSend.length);
			this.spotBiddingListSend = tmpArr;			
		}

	}
/*
 * 조회 결과 리턴
 * @param spotBiddingListSend SpotBiddingListSend[]
 */
	public SpotBiddingListEventResponse(SpotBiddingListSend[] spotBiddingListSend) {
		this.spotBiddingListSend = spotBiddingListSend;
	}
	
	public String getEventName() {
    	return "SpotBiddingListResponse";
    }
}