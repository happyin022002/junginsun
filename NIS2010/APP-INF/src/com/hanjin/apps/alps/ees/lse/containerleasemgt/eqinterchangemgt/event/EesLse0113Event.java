/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0113Event.java
*@FileTitle : Available Oneway Inventory 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.10
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.04.10 두기민
* 1.0 Creation
* 2016-04-10 [CHM-201640528] Oneway Loading PFMC 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Doo Ki Min
 * @see EES_LSE_0113HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String orgCntrTpszCd = null;
	private String dpsl = null;
	private String trd = null;
	private String locTo = null;
	private String period = null;
	private String froms = null;
	private String tos = null;
	private String delDol = null;
	private String porDol = null;
	private String ifFlg = null;
	private String mvmt = null;
	private String locTp = null;
	private String tabFlg = null;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AvailableOnewayInventoryVO availableOnewayInventoryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public AvailableOnewayInventoryVO[] availableOnewayInventoryVOs = null;

	public EesLse0113Event(){}
	

	public String getTabFlg() {
		return tabFlg;
	}

	public void setTabFlg(String tabFlg) {
		this.tabFlg = tabFlg;
	}
	
	public String getLocTp() {
		return locTp;
	}

	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	
	public void setOrgCntrTpszCd(String orgCntrTpszCd) {
		this.orgCntrTpszCd = orgCntrTpszCd;
	}
	public String getOrgCntrTpszCd() {
		return orgCntrTpszCd;
	}
		
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getFroms() {
		return froms;
	}

	public void setFroms(String froms) {
		this.froms = froms;
	}

	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	public String getDelDol() {
		return delDol;
	}

	public void setDelDol(String delDol) {
		this.delDol = delDol;
	}

	public String getPorDol() {
		return porDol;
	}

	public void setPorDol(String porDol) {
		this.porDol = porDol;
	}

	public String getIfFlg() {
		return ifFlg;
	}

	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}

	public String getMvmt() {
		return mvmt;
	}

	public void setMvmt(String mvmt) {
		this.mvmt = mvmt;
	}

	public String getDpsl() {
		return dpsl;
	}

	public void setDpsl(String dpsl) {
		this.dpsl = dpsl;
	}

	public String getTrd() {
		return trd;
	}

	public void setTrd(String trd) {
		this.trd = trd;
	}

	public String getLocTo() {
		return locTo;
	}

	public void setLocTo(String locTo) {
		this.locTo = locTo;
	}
	
	public void setAvailableOnewayInventoryVO(AvailableOnewayInventoryVO availableOnewayInventoryVO){
		this. availableOnewayInventoryVO = availableOnewayInventoryVO;
	}

	public void setAvailableOnewayInventoryVOS(AvailableOnewayInventoryVO[] availableOnewayInventoryVOs){
		this. availableOnewayInventoryVOs = availableOnewayInventoryVOs;
	}

	public AvailableOnewayInventoryVO getAvailableOnewayInventoryVO(){
		return availableOnewayInventoryVO;
	}

	public AvailableOnewayInventoryVO[] getAvailableOnewayInventoryVOS(){
		return availableOnewayInventoryVOs;
	}

}