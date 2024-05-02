/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : YardDetail.java
*@FileTitle : YardDetail Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmt;
import java.util.Arrays;
/**
 * WebService Document Object including Parameters<br>
 * - SpotBiddingManageWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.4
 */
public class SpotBiddingLowestAmtRequest implements java.io.Serializable {
	/** (Param 객체) */
	private SpotBiddingLowestAmt[] spotBiddingLowestAmt;
	private String vndr_seq = "";
	
	public String getVndr_seq() {
		return vndr_seq;
	}

	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}

	public SpotBiddingLowestAmt[] getSpotBiddingLowestAmt() {
		SpotBiddingLowestAmt[] rtnArr = null;
		if (this.spotBiddingLowestAmt != null) {
			rtnArr = Arrays.copyOf(spotBiddingLowestAmt, spotBiddingLowestAmt.length);
		}
		return rtnArr;
	}

	public void setSpotBiddingLowestAmt(SpotBiddingLowestAmt[] spotBiddingLowestAmt) {
		if (spotBiddingLowestAmt != null) {
			SpotBiddingLowestAmt[] tmpArr = Arrays.copyOf(spotBiddingLowestAmt,spotBiddingLowestAmt.length);
			this.spotBiddingLowestAmt = tmpArr;
		}
	}
	
}
