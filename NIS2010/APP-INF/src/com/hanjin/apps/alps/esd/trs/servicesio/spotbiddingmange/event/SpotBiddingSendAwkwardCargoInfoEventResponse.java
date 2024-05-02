/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingSendAwkwardCargoInfoEventResponse.java
*@FileTitle : BKG Awkward Cargo Info
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-11-04 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;


import java.util.Arrays;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * -SpotBiddingListRequest 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageRSC 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSendAwkwardCargoInfoEventResponse {
	private String if_flg;
	private String if_err_msg;
	private SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo;
	
	public SpotBiddingSendAwkwardCargoInfoEventResponse(){
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


	public SpotBiddingSendAwkwardCargoInfo[] getSpotBiddingSendAwkwardCargoInfo() {
		SpotBiddingSendAwkwardCargoInfo[] rtnArr = null;
		if(this.spotBiddingSendAwkwardCargoInfo != null){
			rtnArr = Arrays.copyOf(spotBiddingSendAwkwardCargoInfo,spotBiddingSendAwkwardCargoInfo.length);
		}
		return rtnArr;
	}


	public void setSpotBiddingSendAwkwardCargoInfo(SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo) {
		if(spotBiddingSendAwkwardCargoInfo != null){
			SpotBiddingSendAwkwardCargoInfo[] tmpArr =  Arrays.copyOf(spotBiddingSendAwkwardCargoInfo,spotBiddingSendAwkwardCargoInfo.length);
			this.spotBiddingSendAwkwardCargoInfo = tmpArr;
		}
	}


	/**
	 * 조호결과 리턴
	 * @param spotBiddingSendAwkwardCargoInfo
	 */
	public SpotBiddingSendAwkwardCargoInfoEventResponse(SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo) {
		this.spotBiddingSendAwkwardCargoInfo = spotBiddingSendAwkwardCargoInfo;
	}
	
	public String getEventName() {
    	return "SpotBiddingSendAwkwardCargoInfoEventResponse";
    }
}