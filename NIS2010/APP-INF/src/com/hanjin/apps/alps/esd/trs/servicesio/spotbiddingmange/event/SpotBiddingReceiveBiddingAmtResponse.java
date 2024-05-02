/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingReceiveBiddingAmtResponse.java
*@FileTitle : Send Bidding Amount
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-06
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-07-06  SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmt;
import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - SpotBiddingManageWSProxy Out Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingReceiveBiddingAmtResponse extends EventResponseSupport {
	/** (Param 객체) */
    private SpotBiddingReceiveBiddingAmt[] spotBiddingReceiveBiddingAmt = null;
    
	public SpotBiddingReceiveBiddingAmtResponse(){
	}

	public SpotBiddingReceiveBiddingAmt[] getSpotBiddingSendBiddingAmt() {
		 SpotBiddingReceiveBiddingAmt[] rtnArr = null;
		 if(this.spotBiddingReceiveBiddingAmt !=null){
			 rtnArr = Arrays.copyOf(spotBiddingReceiveBiddingAmt,spotBiddingReceiveBiddingAmt.length);
		 }
		return rtnArr;
	}

	public void setSpotBiddingSendBiddingAmt(SpotBiddingReceiveBiddingAmt[] spotBiddingReceiveBiddingAmt) {
		if(spotBiddingReceiveBiddingAmt != null){
			SpotBiddingReceiveBiddingAmt[] tmpArr = Arrays.copyOf(spotBiddingReceiveBiddingAmt,spotBiddingReceiveBiddingAmt.length);
			this.spotBiddingReceiveBiddingAmt = tmpArr;			
		}

	}
	
}
