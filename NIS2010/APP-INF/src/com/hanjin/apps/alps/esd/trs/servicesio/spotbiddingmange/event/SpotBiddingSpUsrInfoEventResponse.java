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

/**
 * WebService Document Object including Parameters<br>
 * - SpotBiddingManageWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSpUsrInfoEventResponse {
	/** (Param 객체) */
	private String if_flg = "";
	private String if_err_msg = "";
	
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

	


}
