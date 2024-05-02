/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingListResponse.java
*@FileTitle : BKG Reefer Cargo Info
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

import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * -SpotBiddingListRequest 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageRSC 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSendAwkwardCargoInfoResponse extends EventResponseSupport{
	private SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo;
	
	public SpotBiddingSendAwkwardCargoInfoResponse(){
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
	public SpotBiddingSendAwkwardCargoInfoResponse(SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo) {
		this.spotBiddingSendAwkwardCargoInfo = spotBiddingSendAwkwardCargoInfo;
	}
	
	public String getEventName() {
    	return "SpotBiddingSendReeferCargoInfoResponse";
    }
}