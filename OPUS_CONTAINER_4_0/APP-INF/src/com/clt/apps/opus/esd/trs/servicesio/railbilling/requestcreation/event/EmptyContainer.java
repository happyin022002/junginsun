/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EmptyContainer.java
*@FileTitle : EmptyContainer Info
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
public class EmptyContainer implements java.io.Serializable {
	/** (Param 객체) */
	private String cntrNo = null;
	private String cntrTpszCd = null;
	private String cntrTpszNm = null;
	private String routeOrgNodCd = null;
	private String routeDestNodCd = null;
	private String routeSeq = null;
	private String railRoute = null;
	
	private String repoPlnId = null;
	private String plnYrwk = null;
	private String refId = null;
	private String refSeq = null;
	
	private String vrfyRstCd = null;
	private String vrfyRstMsg = null;
	private String vrfyRsnCd = null;
	private String vrfyLangTpCd = null;
	private String vrfyRsnMsg = null;
	
	private String submitFlag = null;
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
	 * @return Returns the rail_route.
	 */
	public String getRail_route() {
		return railRoute;
	}
	/**
	 * @param rail_route The rail_route to set.
	 */
	public void setRail_route(String rail_route) {
		this.railRoute = rail_route;
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
	 * @return Returns the pln_yrwk.
	 */
	public String getPln_yrwk() {
		return plnYrwk;
	}
	/**
	 * @param pln_yrwk The pln_yrwk to set.
	 */
	public void setPln_yrwk(String pln_yrwk) {
		this.plnYrwk = pln_yrwk;
	}
	/**
	 * @return Returns the ref_id.
	 */
	public String getRef_id() {
		return refId;
	}
	/**
	 * @param ref_id The ref_id to set.
	 */
	public void setRef_id(String ref_id) {
		this.refId = ref_id;
	}
	/**
	 * @return Returns the ref_seq.
	 */
	public String getRef_seq() {
		return refSeq;
	}
	/**
	 * @param ref_seq The ref_seq to set.
	 */
	public void setRef_seq(String ref_seq) {
		this.refSeq = ref_seq;
	}
	/**
	 * @return Returns the repo_pln_id.
	 */
	public String getRepo_pln_id() {
		return repoPlnId;
	}
	/**
	 * @param repo_pln_id The repo_pln_id to set.
	 */
	public void setRepo_pln_id(String repo_pln_id) {
		this.repoPlnId = repo_pln_id;
	}
	/**
	 * @return Returns the route_dest_nod_cd.
	 */
	public String getRoute_dest_nod_cd() {
		return routeDestNodCd;
	}
	/**
	 * @param route_dest_nod_cd The route_dest_nod_cd to set.
	 */
	public void setRoute_dest_nod_cd(String route_dest_nod_cd) {
		this.routeDestNodCd = route_dest_nod_cd;
	}
	/**
	 * @return Returns the route_org_nod_cd.
	 */
	public String getRoute_org_nod_cd() {
		return routeOrgNodCd;
	}
	/**
	 * @param route_org_nod_cd The route_org_nod_cd to set.
	 */
	public void setRoute_org_nod_cd(String route_org_nod_cd) {
		this.routeOrgNodCd = route_org_nod_cd;
	}
	/**
	 * @return Returns the route_seq.
	 */
	public String getRoute_seq() {
		return routeSeq;
	}
	/**
	 * @param route_seq The route_seq to set.
	 */
	public void setRoute_seq(String route_seq) {
		this.routeSeq = route_seq;
	}
	/**
	 * @return Returns the submitFlag.
	 */
	public String getSubmitFlag() {
		return submitFlag;
	}
	/**
	 * @param submitFlag The submitFlag to set.
	 */
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}
	
	
	
	
	
}
