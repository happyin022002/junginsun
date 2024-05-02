/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingSendReeferCargoRequest.java
*@FileTitle : BKG Danger Cargo Info
*Open Issues :
*Change history :
*@LastModifyDate :2015-11-04
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-11-04 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;


/**
 * WebService Document Object including Parameters<br>
 * - SpotBiddingManageWSProxy Input Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSendDangerCargoInfoRequest{
	private static final long serialVersionUID = 1L;
	private String bkg_no = "";
	private String eq_no = "";
	
	public String getBkg_no() {
		return bkg_no;
	}
	public void setBkg_no(String bkg_no) {
		this.bkg_no = bkg_no;
	}
	public String getEq_no() {
		return eq_no;
	}
	public void setEq_no(String eq_no) {
		this.eq_no = eq_no;
	}

}
