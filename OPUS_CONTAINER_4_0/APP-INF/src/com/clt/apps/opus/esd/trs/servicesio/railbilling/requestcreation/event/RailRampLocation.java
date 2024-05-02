/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailRampLocation.java
*@FileTitle : Rail Ramp Origin/Destination Info
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
public class RailRampLocation {
	/** (Param 객체) */
	private String routOrgNodCd = null;
	private String routDestNodCd = null;
	private String routSeq = null;
	private String pctlIoBndCd = null;
	private String orgLocCd = null;
	private String orgLocNm = null;
	private String orgYdCd = null;
	private String orgYdNm = null;
	private String orgYdAddr = null;
	private String destLocCd = null;
	private String destLocNm = null;
	private String destYdCd = null;
	private String destYdNm = null;
	private String destYdAddr = null;
	private String dockStatus = null;
	private String blockVndrFlg = null;
	private String railBulkVndrFlg = null;
	private String billTypeFlg = null;
	private String embargoFlg = null;
	private String tofcFlg = null;
	private String wrsFullFlg = null;
	private String autoIrgFlg = null;
	private String railNsVndrFlg = null;
	
	
	/**
	 * @return Returns the rout_dest_nod_cd.
	 */
	public String getRout_dest_nod_cd() {
		return routDestNodCd;
	}
	/**
	 * @param rout_dest_nod_cd The rout_dest_nod_cd to set.
	 */
	public void setRout_dest_nod_cd(String rout_dest_nod_cd) {
		this.routDestNodCd = rout_dest_nod_cd;
	}
	/**
	 * @return Returns the rout_org_nod_cd.
	 */
	public String getRout_org_nod_cd() {
		return routOrgNodCd;
	}
	/**
	 * @param rout_org_nod_cd The rout_org_nod_cd to set.
	 */
	public void setRout_org_nod_cd(String rout_org_nod_cd) {
		this.routOrgNodCd = rout_org_nod_cd;
	}
	/**
	 * @return Returns the bill_type_flg.
	 */
	public String getBill_type_flg() {
		return billTypeFlg;
	}
	/**
	 * @param bill_type_flg The bill_type_flg to set.
	 */
	public void setBill_type_flg(String bill_type_flg) {
		this.billTypeFlg = bill_type_flg;
	}
	/**
	 * @return Returns the block_vndr_flg.
	 */
	public String getBlock_vndr_flg() {
		return blockVndrFlg;
	}
	/**
	 * @param block_vndr_flg The block_vndr_flg to set.
	 */
	public void setBlock_vndr_flg(String block_vndr_flg) {
		this.blockVndrFlg = block_vndr_flg;
	}
	/**
	 * @return Returns the dest_loc_cd.
	 */
	public String getDest_loc_cd() {
		return destLocCd;
	}
	/**
	 * @param dest_loc_cd The dest_loc_cd to set.
	 */
	public void setDest_loc_cd(String dest_loc_cd) {
		this.destLocCd = dest_loc_cd;
	}
	/**
	 * @return Returns the dest_loc_nm.
	 */
	public String getDest_loc_nm() {
		return destLocNm;
	}
	/**
	 * @param dest_loc_nm The dest_loc_nm to set.
	 */
	public void setDest_loc_nm(String dest_loc_nm) {
		this.destLocNm = dest_loc_nm;
	}
	/**
	 * @return Returns the dest_yd_addr.
	 */
	public String getDest_yd_addr() {
		return destYdAddr;
	}
	/**
	 * @param dest_yd_addr The dest_yd_addr to set.
	 */
	public void setDest_yd_addr(String dest_yd_addr) {
		this.destYdAddr = dest_yd_addr;
	}
	/**
	 * @return Returns the dest_yd_cd.
	 */
	public String getDest_yd_cd() {
		return destYdCd;
	}
	/**
	 * @param dest_yd_cd The dest_yd_cd to set.
	 */
	public void setDest_yd_cd(String dest_yd_cd) {
		this.destYdCd = dest_yd_cd;
	}
	/**
	 * @return Returns the dest_yd_nm.
	 */
	public String getDest_yd_nm() {
		return destYdNm;
	}
	/**
	 * @param dest_yd_nm The dest_yd_nm to set.
	 */
	public void setDest_yd_nm(String dest_yd_nm) {
		this.destYdNm = dest_yd_nm;
	}
	/**
	 * @return Returns the dock_status.
	 */
	public String getDock_status() {
		return dockStatus;
	}
	/**
	 * @param dock_status The dock_status to set.
	 */
	public void setDock_status(String dock_status) {
		this.dockStatus = dock_status;
	}
	/**
	 * @return Returns the embargo_flg.
	 */
	public String getEmbargo_flg() {
		return embargoFlg;
	}
	/**
	 * @param embargo_flg The embargo_flg to set.
	 */
	public void setEmbargo_flg(String embargo_flg) {
		this.embargoFlg = embargo_flg;
	}
	/**
	 * @return Returns the org_loc_cd.
	 */
	public String getOrg_loc_cd() {
		return orgLocCd;
	}
	/**
	 * @param org_loc_cd The org_loc_cd to set.
	 */
	public void setOrg_loc_cd(String org_loc_cd) {
		this.orgLocCd = org_loc_cd;
	}
	/**
	 * @return Returns the org_loc_nm.
	 */
	public String getOrg_loc_nm() {
		return orgLocNm;
	}
	/**
	 * @param org_loc_nm The org_loc_nm to set.
	 */
	public void setOrg_loc_nm(String org_loc_nm) {
		this.orgLocNm = org_loc_nm;
	}
	/**
	 * @return Returns the org_yd_addr.
	 */
	public String getOrg_yd_addr() {
		return orgYdAddr;
	}
	/**
	 * @param org_yd_addr The org_yd_addr to set.
	 */
	public void setOrg_yd_addr(String org_yd_addr) {
		this.orgYdAddr = org_yd_addr;
	}
	/**
	 * @return Returns the org_yd_cd.
	 */
	public String getOrg_yd_cd() {
		return orgYdCd;
	}
	/**
	 * @param org_yd_cd The org_yd_cd to set.
	 */
	public void setOrg_yd_cd(String org_yd_cd) {
		this.orgYdCd = org_yd_cd;
	}
	/**
	 * @return Returns the org_yd_nm.
	 */
	public String getOrg_yd_nm() {
		return orgYdNm;
	}
	/**
	 * @param org_yd_nm The org_yd_nm to set.
	 */
	public void setOrg_yd_nm(String org_yd_nm) {
		this.orgYdNm = org_yd_nm;
	}
	/**
	 * @return Returns the tofc_flg.
	 */
	public String getTofc_flg() {
		return tofcFlg;
	}
	/**
	 * @param tofc_flg The tofc_flg to set.
	 */
	public void setTofc_flg(String tofc_flg) {
		this.tofcFlg = tofc_flg;
	}
	/**
	 * @return Returns the auto_irg_flg.
	 */
	public String getAuto_irg_flg() {
		return autoIrgFlg;
	}
	/**
	 * @param auto_irg_flg The auto_irg_flg to set.
	 */
	public void setAuto_irg_flg(String auto_irg_flg) {
		this.autoIrgFlg = auto_irg_flg;
	}
	/**
	 * @return Returns the wrs_full_flg.
	 */
	public String getWrs_full_flg() {
		return wrsFullFlg;
	}
	/**
	 * @param wrs_full_flg The wrs_full_flg to set.
	 */
	public void setWrs_full_flg(String wrs_full_flg) {
		this.wrsFullFlg = wrs_full_flg;
	}
	/**
	 * @return Returns the rout_seq.
	 */
	public String getRout_seq() {
		return routSeq;
	}
	/**
	 * @param rout_seq The rout_seq to set.
	 */
	public void setRout_seq(String rout_seq) {
		this.routSeq = rout_seq;
	}
	/**
	 * @return Returns the pctl_io_bnd_cd.
	 */
	public String getPctl_io_bnd_cd() {
		return pctlIoBndCd;
	}
	/**
	 * @param pctl_io_bnd_cd The pctl_io_bnd_cd to set.
	 */
	public void setPctl_io_bnd_cd(String pctl_io_bnd_cd) {
		this.pctlIoBndCd = pctl_io_bnd_cd;
	}
	/**
	 * @return Returns the rail_bulk_vndr_flg.
	 */
	public String getRail_bulk_vndr_flg() {
		return railBulkVndrFlg;
	}
	/**
	 * @param rail_bulk_vndr_flg The rail_bulk_vndr_flg to set.
	 */
	public void setRail_bulk_vndr_flg(String rail_bulk_vndr_flg) {
		this.railBulkVndrFlg = rail_bulk_vndr_flg;
	}
	
	/**
	 * @return Returns the rail_ns_vndr_flg.
	 */
	public String getRail_ns_vndr_flg() {
		return railNsVndrFlg;
	}
	/**
	 * @param rail_ns_vndr_flg The rail_ns_vndr_flg to set.
	 */
	public void setRail_ns_vndr_flg(String rail_ns_vndr_flg) {
		this.railNsVndrFlg = rail_ns_vndr_flg;
	}
	
}
