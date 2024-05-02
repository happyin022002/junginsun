/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_920Event.java
*@FileTitle : CY & Door S/O Creation Matchmaking Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;




/**
 * ESD_TRS_920 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_920HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author z_kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0920Event extends EventSupport {
	
	/** parameter */
	String trspCostDtlModCd = "";
	String lstNodPlnDt ="";
	String lstNodPlnDtHms = "";
	String toNodCd = "";
	String toNodYard = "";
	String dorNodPlnDt ="";
	String dorNodPlnDtHms ="";
	String dorNodCd ="";
	String dorNodYard="";
	String creOfcCd="";	
	String eqTpszCd="";
	String ctrlOfcCd="";
	String uiContiCd="";
	String cydoorDiv="";
	String trspSoOfcCtyCd="";

	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}

	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String getUiContiCd() {
		return uiContiCd;
	}

	public void setUiContiCd(String uiContiCd) {
		this.uiContiCd = uiContiCd;
	}

	public String getCydoorDiv() {
		return cydoorDiv;
	}

	public void setCydoorDiv(String cydoorDiv) {
		this.cydoorDiv = cydoorDiv;
	}

	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public String getTrspCostDtlModCd() {
		return trspCostDtlModCd;
	}

	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}

	public String getLstNodPlnDt() {
		return lstNodPlnDt;
	}

	public void setLstNodPlnDt(String lstNodPlnDt) {
		this.lstNodPlnDt = lstNodPlnDt;
	}

	public String getLstNodPlnDtHms() {
		return lstNodPlnDtHms;
	}

	public void setLstNodPlnDtHms(String lstNodPlnDtHms) {
		this.lstNodPlnDtHms = lstNodPlnDtHms;
	}

	public String getToNodCd() {
		return toNodCd;
	}

	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	public String getToNodYard() {
		return toNodYard;
	}

	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}

	public String getDorNodPlnDt() {
		return dorNodPlnDt;
	}

	public void setDorNodPlnDt(String dorNodPlnDt) {
		this.dorNodPlnDt = dorNodPlnDt;
	}

	public String getDorNodPlnDtHms() {
		return dorNodPlnDtHms;
	}

	public void setDorNodPlnDtHms(String dorNodPlnDtHms) {
		this.dorNodPlnDtHms = dorNodPlnDtHms;
	}

	public String getDorNodCd() {
		return dorNodCd;
	}

	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}

	public String getDorNodYard() {
		return dorNodYard;
	}

	public void setDorNodYard(String dorNodYard) {
		this.dorNodYard = dorNodYard;
	}

	public String getCreOfcCd() {
		return creOfcCd;
	}

	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	public String getEqTpszCd() {
		return eqTpszCd;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	

	public String getEventName() {
		return "EsdTrs0920Event";
	}

	public String toString() {
		return "EsdTrs0920Event";
	}

}
