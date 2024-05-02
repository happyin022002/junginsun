/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0014Event.java
*@FileTitle : Service Order 생성화면 - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.04
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2011.01.04 조풍연
* 1.0 최초 생성
* ----------------------------------------------------------
* History
* 2011.01.04 최 선         1.1 [CHM-201108174] Report 화면 중 S/P code 선택 시 오류팝업 수정요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
/**
 * ESD_TRS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0014Event extends EventSupport {
	
	ChassisGensetVO[] chassisGensetVOs = null;
	TrsTrspSvcOrdVO[] trsTrspSvcOrdVOs = null;
	
	String formCreUsrId = "";
	String formUsrOfcCd = "";
	String trspSoTpCd = "";
	String trspSoStsCd = "";
	String fmdate = "";
	String todate = "";
	String kindChassis = "";
	String trsTpCd = "";
	String searchFmLoc = "";
	String searchFmYard = "";
	String searchToLoc = "";
	String searchToYard = "";
	String trsMdCd = "";
	String eqNo = "";
	String formEqNo = "";
	String hireLoc = "";
	String hireYd = "";
	String kindHire="";
	String eqTpszCd = "";
	String vndrCntCd="";
	String vndrComboSearchBound="";
	String row="";
	String trspSoVndrNo = "";
	String spotBidCnddtTermSeq = "";

	
	public String getTrspSoVndrNo() {
		return trspSoVndrNo;
	}

	public void setTrspSoVndrNo(String trspSoVndrNo) {
		this.trspSoVndrNo = trspSoVndrNo;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getVndrCntCd() {
		return vndrCntCd;
	}

	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}

	public String getVndrComboSearchBound() {
		return vndrComboSearchBound;
	}

	public void setVndrComboSearchBound(String vndrComboSearchBound) {
		this.vndrComboSearchBound = vndrComboSearchBound;
	}

	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String comboSvcProvider = "";
	
	public void setComboSvcProvider(String comboSvcProvider){
		this.comboSvcProvider = comboSvcProvider;
	}		
	
	public String getComboSvcProvider() {
		return comboSvcProvider;
	}
	
	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String comboSvcProviderChld = "";
	
	public void setComboSvcProviderChld(String comboSvcProviderChld){
		this.comboSvcProviderChld = comboSvcProviderChld;
	}		
	
	public String getComboSvcProviderChld() {
		return comboSvcProviderChld;
	}
	
	/** HASHPARAM을 대치할 파라미터 set/get START*/
	
	private String comboSvcProviderPrnt = "";
	
	public void setComboSvcProviderPrnt(String comboSvcProviderPrnt){
		this.comboSvcProviderPrnt = comboSvcProviderPrnt;
	}		
	
	public String getComboSvcProviderPrnt() {
		return comboSvcProviderPrnt;
	}
	
	/** HASHPARAM을 대치할 파라미터 set/get END*/
	
	private HashMap hashParam = new HashMap();

	public EsdTrs0014Event(){}


	public ChassisGensetVO[] getChassisGensetVOs(){
		return chassisGensetVOs;
	}
	
	public void setChassisGensetVOs(ChassisGensetVO[] ChassisGensetVOs){
		this.chassisGensetVOs = ChassisGensetVOs;
	}
	
	public TrsTrspSvcOrdVO[] getTrsTrspSvcOrdVOs(){
		return trsTrspSvcOrdVOs;
	}
	
	public void setTrsTrspSvcOrdVOs(TrsTrspSvcOrdVO[] TrsTrspSvcOrdVOs){
		this.trsTrspSvcOrdVOs = TrsTrspSvcOrdVOs;
	}
	
	public String getEventName() {
		return "EsdTrs0014Event";
	}
	
	public HashMap getHashParam() {
		return hashParam;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	

	
	public String toString() {
		return "EsdTrs0014Event";
	}
	
	public String getFormUsrId(){
		return formCreUsrId;
	}
	
	public void setFormUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}
	
	public String getFormUsrOfcCd(){
		return formUsrOfcCd;
	}
	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
		
	}

	public String getFmdate(){
		return fmdate;
	}
	
	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
	}

	
	public String getTodate(){
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getKndChassis(){
		return kindChassis;
	}
	public void setKndChassis(String kindChassis) {
		this.kindChassis = kindChassis;
	}

	public String getTrsTpCd() {
		return trsTpCd;
	}
	public void setTrsTpCd(String trsTpCd) {
		this.trsTpCd = trsTpCd;
	}

	public String getSearchFmLoc() {
		return searchFmLoc;
	}

	public void setSearchFmLoc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}

	public String getSearchFmYard() {
		return searchFmYard;
	}
	public void setSearchFmYard(String searchFmYard) {
		this.searchFmYard = searchFmYard;
	}

	
	public String getSearchToLoc() {
		return searchToLoc;
	}
	public void setSearchToLoc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
	}

	public String getSearchToYard() {
		return searchToYard;
	}
	public void setSearchToYard(String searchToYard) {
		this.searchToYard = searchToYard;
	}

	public String getTrsMdCd() {
		return trsMdCd;
	}
	public void setTrsMdCd(String trsMdCd) {
		this.trsMdCd = trsMdCd;
	}
	
	public String getEqNo() {
		return eqNo;
	}
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	public String getFormEqNo() {
		return formEqNo;
	}
	public void setFormEqNo(String formEqNo) {
		this.formEqNo = formEqNo;
	}
	
	public String getHireLoc() {
		return hireLoc;
	}
	public void setHireLoc(String hireLoc) {
		this.hireLoc = hireLoc;
	}

	
	public String getHireYd() {
		return hireYd;
	}
	public void setHireYd(String hireYd) {
		this.hireYd = hireYd;
	}
	
	public String getKindHire() {
		return kindHire;
	}
	public void setKindHire(String kindHire) {
		this.kindHire = kindHire;
	}

	public String getSoTpCd() {
		return trspSoTpCd;
	}
	public void setSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
	}

	public String getSoStsCd() {
		return trspSoStsCd;
	}
	public void setSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	

	public String getEqTpszCd() {
		return eqTpszCd;
	}

	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	/**
	 * @return the spotBidCnddtTermSeq
	 */
	public String getSpotBidCnddtTermSeq() {
		return spotBidCnddtTermSeq;
	}

	/**
	 * @param spotBidCnddtTermSeq the spotBidCnddtTermSeq to set
	 */
	public void setSpotBidCnddtTermSeq(String spotBidCnddtTermSeq) {
		this.spotBidCnddtTermSeq = spotBidCnddtTermSeq;
	}
	
}
