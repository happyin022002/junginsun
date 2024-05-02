/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_019Event.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0 
* 2006-11-10 juhyun
* 1.0 최초 생성
* 2011.01.03 이윤정 [CHM-201007768-01] DMDT 관련 컬럼 추가
=========================================================*/
package com.clt.apps.opus.esd.trs.soinquiry.soinquiry.event;

import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0019Event extends EventSupport {

	/** select 변수 (Form 객체) */
	private HashMap hashParam = new HashMap();
	
	String officeCd="";
	String opener = "";				// popup 을 통해 열수도 있음,.(chreport)            
	String hidWrkofc = "";		 	// popup 을 통해 열수도 있음,.(chreport)          
	String hidTrosts = ""; 			// popup 을 통해 열수도 있음,.(chreport)          
	String hidTpsz = "";		 	// popup 을 통해 열수도 있음,.(chreport)            
	String trunkVvd = "";			//trunk_vvd                                         
	String bkgnumber = "";			//bkgnumber                                         
	String blnumber = "";			//blnumber                                          
	String sonumber = "";			//S/O  INPUT BOX                                    
	String wonumber = "";			// W/O No. INPUT BOX                                
	String copnumber = "";			// W/O No. INPUT BOX                                
	String invoicenumber = "";		//Invoice No.                                     
	String eqnumber = "";			//EQ No.                                            
	String zipCode = "";			//EQ No.                                            
	String hidRadioEq = "";		//EQ No.                                          
	String mtyrefnumber = "";		//MTY REF No.                                   	
	String hidGridFlg = "";		//MTY REF No.                                     
	String hidUnplanned = "";		//EQ No.                                          
	String hidPeriod = "";     		//S/O Creation    W/O Issue    Invoice Confirm  
	String hidFromDate = "";		//hid_from_date                                   
	String hidToDate = "";		//hid_to_date                                       
	String hidRadioOffice = "";	//hid_radio_office                              
	String inputOffice = "";		//input_office                                    
	String hidSomode = "";			//S/O combo                                       
	String hidWomode = "";			//WO combo                                        
	String hidInvoicemode = "";	//invoice combo                                   
	String hidCargomode = "";		//cargo combo                                     
	String hidBoundmode = "";		//bound combo                                     
	String hidRadioUser = "";		//radio_user                                    
	String userId = "";			//user_id                                             
	String hidCostmode = "";		//costmode                                        
	String hidTransmode = "";		//transmode                                       
	String hidSotype = "";			//sotype                                          
	String hidProvider = "";		//provider                                        
	String hidProviderType = "";	//provider type                                 
	String hidAmount = "";			//amount combo                                    
	String hidRadioNumber = "";	//S/C No.  RFA No. RADIO                        
	String scRfaCd = "";			//S/C No.  RFA No. INPUT BOX                        
	String hidFromNode = "";		//from_node                                       
	String hidViaNode = "";		//via_node                                        
	String hidToNode = "";		//to_node                                           
	String hidDoorNode = "";		//door_node                                       
	String invarTerm = "";			//door_node                                       
	String invarOnlycy = "";		//door_node                                       
	String invarTrosts = "";		//door_node                                       
	String hidUsrail = "";			//door_node  
	String hidUsdropnpull = "";		//dmdt [CHM-201007768-01]
	// 2015.04.13
	private String searchFmNode = null;
	private String searchToNode = null;
	private String portIo = null;
	private String portCd = null;
	private String cntrSltNo = null;


	public String getHidTroSts() {
		return hidTrosts;
	}

	public void setHidTroSts(String hid_trosts) {
		this.hidTrosts = hid_trosts;
	}

	public String getHidTpsz() {
		return hidTpsz;
	}

	public void setHidTpsz(String hid_tpsz) {
		this.hidTpsz = hid_tpsz;
	}

	public String getTrunkVvd() {
		return trunkVvd;
	}

	public void setTrunkVvd(String trunk_vvd) {
		this.trunkVvd = trunk_vvd;
	}

	public String getBkgNumber() {
		return bkgnumber;
	}

	public void setBkgNumber(String bkgnumber) {
		this.bkgnumber = bkgnumber;
	}

	public String getBlNumber() {
		return blnumber;
	}

	public void setBlNumber(String blnumber) {
		this.blnumber = blnumber;
	}

	public String getSoNumber() {
		return sonumber;
	}

	public void setSoNumber(String sonumber) {
		this.sonumber = sonumber;
	}

	public String getWoNumber() {
		return wonumber;
	}

	public void setWoNumber(String wonumber) {
		this.wonumber = wonumber;
	}

	public String getCopNumber() {
		return copnumber;
	}

	public void setCopNumber(String copnumber) {
		this.copnumber = copnumber;
	}

	public String getInvoiceNumber() {
		return invoicenumber;
	}

	public void setInvoiceNumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public String getEqNumber() {
		return eqnumber;
	}

	public void setEqNumber(String eqnumber) {
		this.eqnumber = eqnumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zip_code) {
		this.zipCode = zip_code;
	}

	public String getHidRadioEq() {
		return hidRadioEq;
	}

	public void setHidRadioEq(String hid_radio_eq) {
		this.hidRadioEq = hid_radio_eq;
	}

	public String getMtyRefNumber() {
		return mtyrefnumber;
	}

	public void setMtyRefNumber(String mtyrefnumber) {
		this.mtyrefnumber = mtyrefnumber;
	}

	public String getHidGridFlg() {
		return hidGridFlg;
	}

	public void setHidGridFlg(String hid_grid_flg) {
		this.hidGridFlg = hid_grid_flg;
	}

	public String getHidUnplanned() {
		return hidUnplanned;
	}

	public void setHidUnplanned(String hid_unplanned) {
		this.hidUnplanned = hid_unplanned;
	}

	public String getHidPeriod() {
		return hidPeriod;
	}

	public void setHidPeriod(String hid_period) {
		this.hidPeriod = hid_period;
	}

	public String getHidFromDate() {
		return hidFromDate;
	}

	public void setHidFromDate(String hid_from_date) {
		this.hidFromDate = hid_from_date;
	}

	public String getHidToDate() {
		return hidToDate;
	}

	public void setHidToDate(String hid_to_date) {
		this.hidToDate = hid_to_date;
	}

	public String getHidRadioOffice() {
		return hidRadioOffice;
	}

	public void setHidRadioOffice(String hid_radio_office) {
		this.hidRadioOffice = hid_radio_office;
	}

	public String getInputOffice() {
		return inputOffice;
	}

	public void setInputOffice(String input_office) {
		this.inputOffice = input_office;
	}

	public String getHidSoMode() {
		return hidSomode;
	}

	public void setHidSoMode(String hid_somode) {
		this.hidSomode = hid_somode;
	}

	public String getHidWoMode() {
		return hidWomode;
	}

	public void setHidWoMode(String hid_womode) {
		this.hidWomode = hid_womode;
	}

	public String getHidInvoiceMode() {
		return hidInvoicemode;
	}

	public void setHidInvoiceMode(String hid_invoicemode) {
		this.hidInvoicemode = hid_invoicemode;
	}

	public String getHidCargoMode() {
		return hidCargomode;
	}

	public void setHidCargoMode(String hid_cargomode) {
		this.hidCargomode = hid_cargomode;
	}

	public String getHidBoundMode() {
		return hidBoundmode;
	}

	public void setHidBoundMode(String hid_boundmode) {
		this.hidBoundmode = hid_boundmode;
	}

	public String getHidRadioUser() {
		return hidRadioUser;
	}

	public void setHidRadioUser(String hid_radio_user) {
		this.hidRadioUser = hid_radio_user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user_id) {
		this.userId = user_id;
	}

	public String getHidCostMode() {
		return hidCostmode;
	}

	public void setHidCostMode(String hid_costmode) {
		this.hidCostmode = hid_costmode;
	}

	public String getHidTransMode() {
		return hidTransmode;
	}

	public void setHidTransMode(String hid_transmode) {
		this.hidTransmode = hid_transmode;
	}

	public String getHidSoType() {
		return hidSotype;
	}

	public void setHidSoType(String hid_sotype) {
		this.hidSotype = hid_sotype;
	}

	public String getHidProvider() {
		return hidProvider;
	}

	public void setHidProvider(String hid_provider) {
		this.hidProvider = hid_provider;
	}

	public String getHidProviderType() {
		return hidProviderType;
	}

	public void setHidProviderType(String hid_provider_type) {
		this.hidProviderType = hid_provider_type;
	}

	public String getHidAmount() {
		return hidAmount;
	}

	public void setHidAmount(String hid_amount) {
		this.hidAmount = hid_amount;
	}

	public String getHidRadioNumber() {
		return hidRadioNumber;
	}

	public void setHidRadioNumber(String hid_radio_number) {
		this.hidRadioNumber = hid_radio_number;
	}

	public String getScRfaCd() {
		return scRfaCd;
	}

	public void setScRfaCd(String sc_rfa_cd) {
		this.scRfaCd = sc_rfa_cd;
	}

	public String getHidFromNode() {
		return hidFromNode;
	}

	public void setHidFromNode(String hid_from_node) {
		this.hidFromNode = hid_from_node;
	}

	public String getHidViaNode() {
		return hidViaNode;
	}

	public void setHidViaNode(String hid_via_node) {
		this.hidViaNode = hid_via_node;
	}

	public String getHidToNode() {
		return hidToNode;
	}

	public void setHidToNode(String hid_to_node) {
		this.hidToNode = hid_to_node;
	}

	public String getHidDoorNode() {
		return hidDoorNode;
	}

	public void setHidDoorNode(String hid_door_node) {
		this.hidDoorNode = hid_door_node;
	}

	public String getInvarTerm() {
		return invarTerm;
	}

	public void setInvarTerm(String invar_term) {
		this.invarTerm = invar_term;
	}

	public String getInvarOnlyCy() {
		return invarOnlycy;
	}

	public void setInvarOnlyCy(String invar_onlycy) {
		this.invarOnlycy = invar_onlycy;
	}

	public String getInvarTroSts() {
		return invarTrosts;
	}

	public void setInvarTroSts(String invar_trosts) {
		this.invarTrosts = invar_trosts;
	}

	public String getHidUsRail() {
		return hidUsrail;
	}

	public void setHidUsRail(String hid_usrail) {
		this.hidUsrail = hid_usrail;
	}
	
	public String getHidUsDropNPull() {
		return hidUsdropnpull;
	}

	public void setHidUsDropNPull(String hid_dropnpull) {
		this.hidUsdropnpull = hid_dropnpull;
	}
	/** ESD_TRS_019Event */
	public EsdTrs0019Event(){}

	/** getHashParam */
	public HashMap getHashParam() {
		return hashParam;
	}
	
	/** setHashParam */
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}	

	/** getEventName */
	public String getEventName() {
		return "EsdTrs0019Event";
	}

	/** getOfficeCd */
	public String getOfficeCd() {
		return officeCd;
	}
	/** setOfficeCd */
	public void setOfficeCd(String office_cd) {
		this.officeCd = office_cd;
	}
	
	/** getOfficeCd */
	public String getOpener() {
		return opener;
	}
	/** setOfficeCd */
	public void setOpener(String opener) {
		this.opener = opener;
	}
	
	/** getOfficeCd */
	public String getHidWrkOfc() {
		return hidWrkofc;
	}
	/** setOfficeCd */
	public void setHidWrkOfc(String hid_wrkofc) {
		this.hidWrkofc = hid_wrkofc;
	}

	public String getSearchFmNode() {
		return searchFmNode;
	}

	public void setSearchFmNode(String searchFmNode) {
		this.searchFmNode = searchFmNode;
	}

	public String getSearchToNode() {
		return searchToNode;
	}

	public void setSearchToNode(String searchToNode) {
		this.searchToNode = searchToNode;
	}

	public String getPortIo() {
		return portIo;
	}

	public void setPortIo(String portIo) {
		this.portIo = portIo;
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/** toString */
	public String toString() {
		return "EsdTrs0019Event";
	}

	public String getCntrSltNo() {
		return cntrSltNo;
	}

	public void setCntrSltNo(String cntrSltNo) {
		this.cntrSltNo = cntrSltNo;
	}
}
