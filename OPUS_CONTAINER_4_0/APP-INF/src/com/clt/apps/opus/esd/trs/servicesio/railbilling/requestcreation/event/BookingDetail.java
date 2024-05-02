/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BookingDetail.java
*@FileTitle : Booking Detail Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class BookingDetail implements java.io.Serializable {
	/** (Param 객체) */
	private String soOfcCity = null;
	private String soSeq = null;
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String cntrTpszNm = null;
	private String weight = null;
	private String bulk = null;
	private String steelwire = null;
	private String coilShipment = null;
	private String fumigation = null;
	private String piece = null;
	private String aesTp = null;
	private String aesNo = null;
	private String vrfyRstCd = null;
	private String vrfyRstMsg = null;
	private String vrfyRsnCd = null;
	private String vrfyLangTpCd = null;
	private String vrfyRsnMsg = null;
	private String ioFlag = null;
	private String rowIdx = null;
	private String selectText = null;
	private String bkgQty = null;
	private String remark = null;
	private String copNo = null;
	private String costActGrpSeq = null;
	private String usRegion = null;
	private String rartDvsn = null;
	private String rcvDt = null;
	private String pctlNo = null;
	private String tareWgt = null;
	private String vgmWgt = null;
	
	/**
	 * @return Returns the aes_no.
	 */
	public String getAes_no() {
		return aesNo;
	}
	/**
	 * @param aes_no The aes_no to set.
	 */
	public void setAes_no(String aes_no) {
		this.aesNo = aes_no;
	}
	/**
	 * @return Returns the aes_tp.
	 */
	public String getAes_tp() {
		return aesTp;
	}
	/**
	 * @param aes_tp The aes_tp to set.
	 */
	public void setAes_tp(String aes_tp) {
		this.aesTp = aes_tp;
	}
	/**
	 * @return Returns the bkg_qty.
	 */
	public String getBkg_qty() {
		return bkgQty;
	}
	/**
	 * @param bkg_qty The bkg_qty to set.
	 */
	public void setBkg_qty(String bkg_qty) {
		this.bkgQty = bkg_qty;
	}
	/**
	 * @return Returns the bulk.
	 */
	public String getBulk() {
		return bulk;
	}
	/**
	 * @param bulk The bulk to set.
	 */
	public void setBulk(String bulk) {
		this.bulk = bulk;
	}
	/**
	 * @return Returns the cntr_no.
	 */
	public String getCntr_no() {
		return cntrNo;
	}
	/**
	 * @param cntr_no The cntr_no to set.
	 */
	public void setCntr_no(String cntr_no) {
		this.cntrNo = cntr_no;
	}
	/**
	 * @return Returns the cntr_tpsz_cd.
	 */
	public String getCntr_tpsz_cd() {
		return cntrTpszCd;
	}
	/**
	 * @param cntr_tpsz_cd The cntr_tpsz_cd to set.
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntrTpszCd = cntr_tpsz_cd;
	}
	/**
	 * @return Returns the cntr_tpsz_nm.
	 */
	public String getCntr_tpsz_nm() {
		return cntrTpszNm;
	}
	/**
	 * @param cntr_tpsz_nm The cntr_tpsz_nm to set.
	 */
	public void setCntr_tpsz_nm(String cntr_tpsz_nm) {
		this.cntrTpszNm = cntr_tpsz_nm;
	}
	/**
	 * @return Returns the coil_shipment.
	 */
	public String getCoil_shipment() {
		return coilShipment;
	}
	/**
	 * @param coil_shipment The coil_shipment to set.
	 */
	public void setCoil_shipment(String coil_shipment) {
		this.coilShipment = coil_shipment;
	}
	/**
	 * @return Returns the fumigation.
	 */
	public String getFumigation() {
		return fumigation;
	}
	/**
	 * @param fumigation The fumigation to set.
	 */
	public void setFumigation(String fumigation) {
		this.fumigation = fumigation;
	}
	/**
	 * @return Returns the io_flag.
	 */
	public String getIo_flag() {
		return ioFlag;
	}
	/**
	 * @param io_flag The io_flag to set.
	 */
	public void setIo_flag(String io_flag) {
		this.ioFlag = io_flag;
	}
	/**
	 * @return Returns the piece.
	 */
	public String getPiece() {
		return piece;
	}
	/**
	 * @param piece The piece to set.
	 */
	public void setPiece(String piece) {
		this.piece = piece;
	}
	/**
	 * @return Returns the remark.
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark The remark to set.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return Returns the row_idx.
	 */
	public String getRow_idx() {
		return rowIdx;
	}
	/**
	 * @param row_idx The row_idx to set.
	 */
	public void setRow_idx(String row_idx) {
		this.rowIdx = row_idx;
	}
	/**
	 * @return Returns the select_text.
	 */
	public String getSelect_text() {
		return selectText;
	}
	/**
	 * @param select_text The select_text to set.
	 */
	public void setSelect_text(String select_text) {
		this.selectText = select_text;
	}
	/**
	 * @return Returns the so_ofc_city.
	 */
	public String getSo_ofc_city() {
		return soOfcCity;
	}
	/**
	 * @param so_ofc_city The so_ofc_city to set.
	 */
	public void setSo_ofc_city(String so_ofc_city) {
		this.soOfcCity = so_ofc_city;
	}
	/**
	 * @return Returns the so_seq.
	 */
	public String getSo_seq() {
		return soSeq;
	}
	/**
	 * @param so_seq The so_seq to set.
	 */
	public void setSo_seq(String so_seq) {
		this.soSeq = so_seq;
	}
	/**
	 * @return Returns the steelwire.
	 */
	public String getSteelwire() {
		return steelwire;
	}
	/**
	 * @param steelwire The steelwire to set.
	 */
	public void setSteelwire(String steelwire) {
		this.steelwire = steelwire;
	}
	/**
	 * @return Returns the vrfy_rsn_cd.
	 */
	public String getVrfy_rsn_cd() {
		return vrfyRsnCd;
	}
	/**
	 * @param vrfy_rsn_cd The vrfy_rsn_cd to set.
	 */
	public void setVrfy_rsn_cd(String vrfy_rsn_cd) {
		this.vrfyRsnCd = vrfy_rsn_cd;
	}
	/**
	 * @return Returns the vrfy_rsn_msg.
	 */
	public String getVrfy_rsn_msg() {
		return vrfyRsnMsg;
	}
	/**
	 * @param vrfy_rsn_msg The vrfy_rsn_msg to set.
	 */
	public void setVrfy_rsn_msg(String vrfy_rsn_msg) {
		this.vrfyRsnMsg = vrfy_rsn_msg;
	}
	/**
	 * @return Returns the vrfy_rst_cd.
	 */
	public String getVrfy_rst_cd() {
		return vrfyRstCd;
	}
	/**
	 * @param vrfy_rst_cd The vrfy_rst_cd to set.
	 */
	public void setVrfy_rst_cd(String vrfy_rst_cd) {
		this.vrfyRstCd = vrfy_rst_cd;
	}
	/**
	 * @return Returns the vrfy_rst_msg.
	 */
	public String getVrfy_rst_msg() {
		return vrfyRstMsg;
	}
	/**
	 * @param vrfy_rst_msg The vrfy_rst_msg to set.
	 */
	public void setVrfy_rst_msg(String vrfy_rst_msg) {
		this.vrfyRstMsg = vrfy_rst_msg;
	}
	/**
	 * @return Returns the weight.
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight The weight to set.
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * @return Returns the cop_no.
	 */
	public String getCop_no() {
		return copNo;
	}
	/**
	 * @param cop_no The cop_no to set.
	 */
	public void setCop_no(String cop_no) {
		this.copNo = cop_no;
	}
	/**
	 * @return Returns the vrfy_lang_tp_cd.
	 */
	public String getVrfy_lang_tp_cd() {
		return vrfyLangTpCd;
	}
	/**
	 * @param vrfy_lang_tp_cd The vrfy_lang_tp_cd to set.
	 */
	public void setVrfy_lang_tp_cd(String vrfy_lang_tp_cd) {
		this.vrfyLangTpCd = vrfy_lang_tp_cd;
	}
	/**
	 * @return Returns the cost_act_grp_seq.
	 */
	public String getCost_act_grp_seq() {
		return costActGrpSeq;
	}
	/**
	 * @param cost_act_grp_seq The cost_act_grp_seq to set.
	 */
	public void setCost_act_grp_seq(String cost_act_grp_seq) {
		this.costActGrpSeq = cost_act_grp_seq;
	}
	/**
	 * @return Returns the us_region.
	 */
	public String getUs_region() {
		return usRegion;
	}
	/**
	 * @param us_region The us_region to set.
	 */
	public void setUs_region(String us_region) {
		this.usRegion = us_region;
	}
	/**
	 * @return Returns the rart_dvsn.
	 */
	public String getRart_dvsn() {
		return rartDvsn;
	}
	/**
	 * @param rart_dvsn The rart_dvsn to set.
	 */
	public void setRart_dvsn(String rart_dvsn) {
		this.rartDvsn = rart_dvsn;
	}
	/**
	 * @return Returns the rcv_dt.
	 */
	public String getRcv_dt() {
		return rcvDt;
	}
	/**
	 * @param rcv_dt The rcv_dt to set.
	 */
	public void setRcv_dt(String rcv_dt) {
		this.rcvDt = rcv_dt;
	}
	/**
	 * @return Returns the pctl_no.
	 */
	public String getPctl_no() {
		return pctlNo;
	}
	/**
	 * @param pctl_no The pctl_no to set.
	 */
	public void setPctl_no(String pctl_no) {
		this.pctlNo = pctl_no;
	}
	/**
	 * @return Returns the tare_wgt.
	 */
	public String getTare_wgt() {
		return tareWgt;
	}
	/**
	 * @param tare_wgt The tare_wgt to set.
	 */
	public void setTare_wgt(String tare_wgt) {
		this.tareWgt = tare_wgt;
	}
	/**
	 * @return Returns the vgm_wgt.
	 */
	public String getVgm_wgt() {
		return vgmWgt;
	}
	/**
	 * @param vgm_wgt The vgm_wgt to set.
	 */
	public void setVgm_wgt(String vgm_wgt) {
		this.vgmWgt = vgm_wgt;
	}
}
