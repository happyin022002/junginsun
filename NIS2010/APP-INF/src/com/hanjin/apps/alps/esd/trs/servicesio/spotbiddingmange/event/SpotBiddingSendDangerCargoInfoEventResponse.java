/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingSendDangerCargoInfoEventResponse.java
*@FileTitle : BKG Danger Cargo Info
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
public class SpotBiddingSendDangerCargoInfoEventResponse {
	private String if_flg;
	private String if_err_msg;
	private SpotBiddingSendDangerCargoInfo[] spotBiddingSendDangerCargoInfo;
	
	public SpotBiddingSendDangerCargoInfoEventResponse(){
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


	public SpotBiddingSendDangerCargoInfo[] getSpotBiddingSendDangerCargoInfo() {
		SpotBiddingSendDangerCargoInfo[] rtnArr = null;
		if(this.spotBiddingSendDangerCargoInfo != null){
			rtnArr = Arrays.copyOf(spotBiddingSendDangerCargoInfo,spotBiddingSendDangerCargoInfo.length);
		}
		return rtnArr;
	}


	public void setSpotBiddingSendDangerCargoInfo(SpotBiddingSendDangerCargoInfo[] spotBiddingSendDangerCargoInfo) {
		if(spotBiddingSendDangerCargoInfo != null){
			SpotBiddingSendDangerCargoInfo[] tmpArr =  Arrays.copyOf(spotBiddingSendDangerCargoInfo,spotBiddingSendDangerCargoInfo.length);
			this.spotBiddingSendDangerCargoInfo = tmpArr;
		}
	}


	/**
	 * 조호결과 리턴
	 * @param spotBiddingSendDangerCargoInfo
	 */
	public SpotBiddingSendDangerCargoInfoEventResponse(SpotBiddingSendDangerCargoInfo[] spotBiddingSendDangerCargoInfo) {
		this.spotBiddingSendDangerCargoInfo = spotBiddingSendDangerCargoInfo;
	}
	
	public String getEventName() {
    	return "SpotBiddingSendAwkwardCargoInfoEventResponse";
    }
}