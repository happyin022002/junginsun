/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingSpUsrInfoRequest.java
*@FileTitle : Service Provider User Info
*Open Issues :
*Change history :
*@LastModifyDate : 2015-07-03
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-07-03 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;

import java.util.Arrays;

/**
 * WebService Document Object including Parameters<br>
 * - SpotBiddingManageWSProxy Input Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSpUsrInfoRequest implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** (Param 객체) */
    private SpotBiddingSpUsrInfo[] spotBiddingSpUsrInfo = null;
 
	public SpotBiddingSpUsrInfo[] getSpotBiddingSpUsrInfo() {
		SpotBiddingSpUsrInfo[] rtnArr = null;
		 if(this.spotBiddingSpUsrInfo !=null){
			 rtnArr = Arrays.copyOf(spotBiddingSpUsrInfo,spotBiddingSpUsrInfo.length);
		 }
		return rtnArr;
	}

	public void setSpotBiddingSpUsrInfo(SpotBiddingSpUsrInfo[] spotBiddingSpUsrInfo) {
		if(spotBiddingSpUsrInfo != null){
			SpotBiddingSpUsrInfo[] tmpArr = Arrays.copyOf(spotBiddingSpUsrInfo,spotBiddingSpUsrInfo.length);
			this.spotBiddingSpUsrInfo = tmpArr;			
		}
	}
}
