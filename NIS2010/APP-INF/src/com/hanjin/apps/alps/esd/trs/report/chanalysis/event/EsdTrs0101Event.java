/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_001Event.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0 
* 2009-10-01 kimjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.event;

import java.util.Collection;
import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SCE_COST_ACT_GRP;


/**
 * ESD_TRS_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTrs0101Event extends EventSupport {

	/** sce_cost_act_grp Table  Value Object */
	private SCE_COST_ACT_GRP sceCostActGrp = null;

	/** sce_cost_act_grps Multi Action을 위한 Collection */
	private Collection sceCostActGrps = null;
	
	/** select 변수 (Form 객체) */
	private HashMap hashParam = new HashMap();

	/** HASHPARAM을 대치할 파라미터 set/get START*/

	private String soFmdt 		= "";
	private String soTodt 		= "";
	private String inputOffice 	= "";
	private String hidBoundmode = "";
	private String hidBkgterm 	= "";
	private String hidTrosts 	= "";
	private String hidInclmty 	= "";
	private String frmNode  	= "";
	private String toNode  		= "";
	private String frmYard		= "";
	private String toYard 		= "";
	private String hidWeek		= "";
	private String hidPeriod	= "";
	private String hidRhq		= "";
	private String trunkVvd		= "";
	
	public String getHidRhq() {
		return hidRhq;
	}

	public void setHidRhq(String hidRhq) {
		this.hidRhq = hidRhq;
	}

	public String getTrunkVvd() {
		return trunkVvd;
	}

	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}

	public String getHidWeek() {
		return hidWeek;
	}

	public void setHidWeek(String hidWeek) {
		this.hidWeek = hidWeek;
	}

	public String getHidPeriod() {
		return hidPeriod;
	}

	public void setHidPeriod(String hidPeriod) {
		this.hidPeriod = hidPeriod;
	}

	public String getFrmYard() {
		return frmYard;
	}

	public void setFrmYard(String frmYard) {
		this.frmYard = frmYard;
	}

	public String getToYard() {
		return toYard;
	}

	public void setToYard(String toYard) {
		this.toYard = toYard;
	}

	public String getSoFmdt() {
		return soFmdt;
	}

	public void setSoFmdt(String soFmdt) {
		this.soFmdt = soFmdt;
	}

	public String getSoTodt() {
		return soTodt;
	}

	public void setSoTodt(String soTodt) {
		this.soTodt = soTodt;
	}

	public String getInputOffice() {
		return inputOffice;
	}

	public void setInputOffice(String inputOffice) {
		this.inputOffice = inputOffice;
	}

	public String getHidBoundmode() {
		return hidBoundmode;
	}

	public void setHidBoundmode(String hidBoundmode) {
		this.hidBoundmode = hidBoundmode;
	}

	public String getHidBkgterm() {
		return hidBkgterm;
	}

	public void setHidBkgterm(String hidBkgterm) {
		this.hidBkgterm = hidBkgterm;
	}

	public String getHidTrosts() {
		return hidTrosts;
	}

	public void setHidTrosts(String hidTrosts) {
		this.hidTrosts = hidTrosts;
	}

	public String getHidInclmty() {
		return hidInclmty;
	}

	public void setHidInclmty(String hidInclmty) {
		this.hidInclmty = hidInclmty;
	}

	public String getFrmNode() {
		return frmNode;
	}

	public void setFrmNode(String frmNode) {
		this.frmNode = frmNode;
	}

	public String getToNode() {
		return toNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
	}
	
	/** HASHPARAM을 대치할 파라미터 set/get END*/

	/** ESD_TRS_001Event */
	public EsdTrs0101Event(){}

	/**
	 * @param sceCostActGrp
	 */
	public EsdTrs0101Event(SCE_COST_ACT_GRP sceCostActGrp) {
		this.sceCostActGrp = sceCostActGrp;
    }

	/**
	 * @param sceCostActGrp
	 * @param sceCostActGrps
	 */
	public EsdTrs0101Event(SCE_COST_ACT_GRP sceCostActGrp, Collection sceCostActGrps) {
		this.sceCostActGrp = sceCostActGrp;
		this.sceCostActGrps = sceCostActGrps;
    }

	/** getSCE_COST_ACT_GRP */
	public SCE_COST_ACT_GRP getSCE_COST_ACT_GRP(){
		return sceCostActGrp;
	}

	/** getSCE_COST_ACT_GRPS  */
	public Collection getSCE_COST_ACT_GRPS(){
		return sceCostActGrps;
	}

	/** getEventName */
	public String getEventName() {
		return "EsdTrs0101Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0101Event";
	}
	
	/** getHashParam */
	public HashMap getHashParam() {
		return hashParam;
	}
	
	/** setHashParam */
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}	
}