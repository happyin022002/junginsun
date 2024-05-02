/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpotBiddingSendReeferCargoInfo.java
*@FileTitle : BKG Reefer Cargo Info
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;
/**
 * WebService Document Object including Parameters<br>
 * - SpotBiddingManageRSC Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author SHIN DONG IL
 * @see SpotBiddingManageWSProxy 참조
 * @since J2EE 1.6
 */
public class SpotBiddingSendReeferCargoInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String bkg_no		    = "";
	private String eq_no            = "";
	private String ctrl_atms_flg    = "";
	private String modi_atms_flg    = "";
	private String humid_ctrl_flg   = "";
	private String cmdt_cd          = "";
	private String cmdt_nm          = "";
	private String clng_tp_cd       = "";
	private String cdo_temp         = "";
	private String fdo_temp         = "";
	private String humid_no         = "";
	private String vent_rto         = "";
	private String pck_qty          = "";
	private String pck_tp_cd        = "";
	private String grs_wgt_tp_cd    = "";
	private String net_wgt_tp_cd    = "";
	private String grs_wgt          = "";
	private String net_wgt          = "";
	private String cntr_drn_cd      = "";
	private String pwr_spl_cbl_flg  = "";
	private String vltg_no          = "";
	private String diff_rmk         = "";
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
	public String getCtrl_atms_flg() {
		return ctrl_atms_flg;
	}
	public void setCtrl_atms_flg(String ctrl_atms_flg) {
		this.ctrl_atms_flg = ctrl_atms_flg;
	}
	public String getModi_atms_flg() {
		return modi_atms_flg;
	}
	public void setModi_atms_flg(String modi_atms_flg) {
		this.modi_atms_flg = modi_atms_flg;
	}
	public String getHumid_ctrl_flg() {
		return humid_ctrl_flg;
	}
	public void setHumid_ctrl_flg(String humid_ctrl_flg) {
		this.humid_ctrl_flg = humid_ctrl_flg;
	}
	public String getCmdt_cd() {
		return cmdt_cd;
	}
	public void setCmdt_cd(String cmdt_cd) {
		this.cmdt_cd = cmdt_cd;
	}
	public String getCmdt_nm() {
		return cmdt_nm;
	}
	public void setCmdt_nm(String cmdt_nm) {
		this.cmdt_nm = cmdt_nm;
	}
	public String getClng_tp_cd() {
		return clng_tp_cd;
	}
	public void setClng_tp_cd(String clng_tp_cd) {
		this.clng_tp_cd = clng_tp_cd;
	}
	public String getCdo_temp() {
		return cdo_temp;
	}
	public void setCdo_temp(String cdo_temp) {
		this.cdo_temp = cdo_temp;
	}
	public String getFdo_temp() {
		return fdo_temp;
	}
	public void setFdo_temp(String fdo_temp) {
		this.fdo_temp = fdo_temp;
	}
	public String getHumid_no() {
		return humid_no;
	}
	public void setHumid_no(String humid_no) {
		this.humid_no = humid_no;
	}
	public String getVent_rto() {
		return vent_rto;
	}
	public void setVent_rto(String vent_rto) {
		this.vent_rto = vent_rto;
	}
	public String getPck_qty() {
		return pck_qty;
	}
	public void setPck_qty(String pck_qty) {
		this.pck_qty = pck_qty;
	}
	public String getPck_tp_cd() {
		return pck_tp_cd;
	}
	public void setPck_tp_cd(String pck_tp_cd) {
		this.pck_tp_cd = pck_tp_cd;
	}
	public String getGrs_wgt_tp_cd() {
		return grs_wgt_tp_cd;
	}
	public void setGrs_wgt_tp_cd(String grs_wgt_tp_cd) {
		this.grs_wgt_tp_cd = grs_wgt_tp_cd;
	}
	public String getNet_wgt_tp_cd() {
		return net_wgt_tp_cd;
	}
	public void setNet_wgt_tp_cd(String net_wgt_tp_cd) {
		this.net_wgt_tp_cd = net_wgt_tp_cd;
	}
	public String getGrs_wgt() {
		return grs_wgt;
	}
	public void setGrs_wgt(String grs_wgt) {
		this.grs_wgt = grs_wgt;
	}
	public String getNet_wgt() {
		return net_wgt;
	}
	public void setNet_wgt(String net_wgt) {
		this.net_wgt = net_wgt;
	}
	public String getCntr_drn_cd() {
		return cntr_drn_cd;
	}
	public void setCntr_drn_cd(String cntr_drn_cd) {
		this.cntr_drn_cd = cntr_drn_cd;
	}
	public String getPwr_spl_cbl_flg() {
		return pwr_spl_cbl_flg;
	}
	public void setPwr_spl_cbl_flg(String pwr_spl_cbl_flg) {
		this.pwr_spl_cbl_flg = pwr_spl_cbl_flg;
	}
	public String getVltg_no() {
		return vltg_no;
	}
	public void setVltg_no(String vltg_no) {
		this.vltg_no = vltg_no;
	}
	public String getDiff_rmk() {
		return diff_rmk;
	}
	public void setDiff_rmk(String diff_rmk) {
		this.diff_rmk = diff_rmk;
	}
	
	
}