/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24VesselArrivalVO.java
*@FileTitle : Eur24VesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.24  
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.12.23 김보배 [CHM-201328033] [ENS] Arrival notification 상 Flat file 수정요청
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24VesselArrivalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24VesselArrivalVO> models = new ArrayList<Eur24VesselArrivalVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String arrivalPort = null;
	/* Column Info */
	private String docNo = null;
	/* Column Info */
	private String ata = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String ptConName = null;
	/* Column Info */
	private String ptEmNo = null;
	/* Column Info */
	private String ptFaxNo = null;
	/* Column Info */
	private String grossTon = null;
	/* Column Info */
	private String tradeRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String firstOffice = null;
	/* Column Info */
	private String netTon = null;
	/* Column Info */
	private String certRegDt = null;
	/* Column Info */
	private String prevPort = null;
	/* Column Info */
	private String crn = null;
	/* Column Info */
	private String ptConCmpy = null;
	/* Column Info */
	private String callRefNo = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String positionOfShip = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String ptTelNo = null;
	/* Column Info */
	private String transTypeCd = null;
	/* Column Info */
	private String etaEu = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String noOfCrew = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String purposeOfCall = null;
	/* Column Info */
	private String certRegNo = null;
	/* Column Info */
	private String originalPort = null;
	/* Column Info */
	private String noOfPassenger = null;
	/* Column Info */
	private String certRegLoc = null;
	/* Column Info */
	private String transNation = null;
	/* Column Info */
	private String itemCountTotal = null;
	/* Column Info */
	private String pkgCountTotal = null;
	/* Column Info */
	private String dtmPresentation = null;
	/* Column Info */
	private String unloadInd = null;
	/* Column Info */
	private String unloadLoc = null;
	/* Column Info */
	private String customsRef = null;
	/* Column Info */
	private String firstOfficeEns = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24VesselArrivalVO() {}

	public Eur24VesselArrivalVO(String ibflag, String pagerows, String docNo, String callRefNo, String vslCd, String skdVoyNo, String skdDirCd, String tradeRefNo, String purposeOfCall, String crn, String transMode, String transTypeCd, String lloydNo, String vslName, String originalPort, String transNation, String eta, String etaEu, String ata, String etd, String firstOffice, String positionOfShip, String prevPort, String arrivalPort, String nextPort, String certRegNo, String certRegDt, String certRegLoc, String grossTon, String netTon, String noOfCrew, String noOfPassenger, String cstmsPortCd, String ptConName, String ptConCmpy, String ptEmNo, String ptTelNo, String ptFaxNo, String customsRef, String dtmPresentation, String itemCountTotal, String pkgCountTotal, String unloadInd, String unloadLoc, String firstOfficeEns) {
		this.vslCd = vslCd;
		this.eta = eta;
		this.arrivalPort = arrivalPort;
		this.docNo = docNo;
		this.ata = ata;
		this.etd = etd;
		this.ptConName = ptConName;
		this.ptEmNo = ptEmNo;
		this.ptFaxNo = ptFaxNo;
		this.grossTon = grossTon;
		this.tradeRefNo = tradeRefNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.firstOffice = firstOffice;
		this.netTon = netTon;
		this.certRegDt = certRegDt;
		this.prevPort = prevPort;
		this.crn = crn;
		this.ptConCmpy = ptConCmpy;
		this.callRefNo = callRefNo;
		this.cstmsPortCd = cstmsPortCd;
		this.positionOfShip = positionOfShip;
		this.nextPort = nextPort;
		this.ptTelNo = ptTelNo;
		this.transTypeCd = transTypeCd;
		this.etaEu = etaEu;
		this.skdVoyNo = skdVoyNo;
		this.vslName = vslName;
		this.skdDirCd = skdDirCd;
		this.noOfCrew = noOfCrew;
		this.transMode = transMode;
		this.lloydNo = lloydNo;
		this.purposeOfCall = purposeOfCall;
		this.certRegNo = certRegNo;
		this.originalPort = originalPort;
		this.noOfPassenger = noOfPassenger;
		this.certRegLoc = certRegLoc;
		this.transNation = transNation;
		this.itemCountTotal = itemCountTotal;
		this.pkgCountTotal = pkgCountTotal;
		this.dtmPresentation = dtmPresentation;
		this.unloadInd = unloadInd;
		this.unloadLoc = unloadLoc;
		this.customsRef = customsRef;
		this.firstOfficeEns = firstOfficeEns;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("arrival_port", getArrivalPort());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("ata", getAta());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pt_con_name", getPtConName());
		this.hashColumns.put("pt_em_no", getPtEmNo());
		this.hashColumns.put("pt_fax_no", getPtFaxNo());
		this.hashColumns.put("gross_ton", getGrossTon());
		this.hashColumns.put("trade_ref_no", getTradeRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("first_office", getFirstOffice());
		this.hashColumns.put("net_ton", getNetTon());
		this.hashColumns.put("cert_reg_dt", getCertRegDt());
		this.hashColumns.put("prev_port", getPrevPort());
		this.hashColumns.put("crn", getCrn());
		this.hashColumns.put("pt_con_cmpy", getPtConCmpy());
		this.hashColumns.put("call_ref_no", getCallRefNo());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("position_of_ship", getPositionOfShip());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("pt_tel_no", getPtTelNo());
		this.hashColumns.put("trans_type_cd", getTransTypeCd());
		this.hashColumns.put("eta_eu", getEtaEu());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("no_of_crew", getNoOfCrew());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("purpose_of_call", getPurposeOfCall());
		this.hashColumns.put("cert_reg_no", getCertRegNo());
		this.hashColumns.put("original_port", getOriginalPort());
		this.hashColumns.put("no_of_passenger", getNoOfPassenger());
		this.hashColumns.put("cert_reg_loc", getCertRegLoc());
		this.hashColumns.put("trans_nation", getTransNation());
		this.hashColumns.put("item_count_total", getItemCountTotal());
		this.hashColumns.put("pkg_count_total", getPkgCountTotal());
		this.hashColumns.put("dtm_presentation", getDtmPresentation());
		this.hashColumns.put("unload_ind", getUnloadInd());
		this.hashColumns.put("unload_loc", getUnloadLoc());
		this.hashColumns.put("customs_ref", getCustomsRef());
		this.hashColumns.put("first_office_ens", getFirstOfficeEns());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("arrival_port", "arrivalPort");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("ata", "ata");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pt_con_name", "ptConName");
		this.hashFields.put("pt_em_no", "ptEmNo");
		this.hashFields.put("pt_fax_no", "ptFaxNo");
		this.hashFields.put("gross_ton", "grossTon");
		this.hashFields.put("trade_ref_no", "tradeRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("first_office", "firstOffice");
		this.hashFields.put("net_ton", "netTon");
		this.hashFields.put("cert_reg_dt", "certRegDt");
		this.hashFields.put("prev_port", "prevPort");
		this.hashFields.put("crn", "crn");
		this.hashFields.put("pt_con_cmpy", "ptConCmpy");
		this.hashFields.put("call_ref_no", "callRefNo");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("position_of_ship", "positionOfShip");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("pt_tel_no", "ptTelNo");
		this.hashFields.put("trans_type_cd", "transTypeCd");
		this.hashFields.put("eta_eu", "etaEu");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("no_of_crew", "noOfCrew");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("purpose_of_call", "purposeOfCall");
		this.hashFields.put("cert_reg_no", "certRegNo");
		this.hashFields.put("original_port", "originalPort");
		this.hashFields.put("no_of_passenger", "noOfPassenger");
		this.hashFields.put("cert_reg_loc", "certRegLoc");
		this.hashFields.put("trans_nation", "transNation");
		this.hashFields.put("item_count_total", "itemCountTotal");
		this.hashFields.put("pkg_count_total", "pkgCountTotal");
		this.hashFields.put("dtm_presentation", "dtmPresentation");
		this.hashFields.put("unload_ind", "unloadInd");
		this.hashFields.put("unload_loc", "unloadLoc");
		this.hashFields.put("customs_ref", "customsRef");
		this.hashFields.put("first_office_ens", "firstOfficeEns");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return arrivalPort
	 */
	public String getArrivalPort() {
		return this.arrivalPort;
	}
	
	/**
	 * Column Info
	 * @return docNo
	 */
	public String getDocNo() {
		return this.docNo;
	}
	
	/**
	 * Column Info
	 * @return ata
	 */
	public String getAta() {
		return this.ata;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return ptConName
	 */
	public String getPtConName() {
		return this.ptConName;
	}
	
	/**
	 * Column Info
	 * @return ptEmNo
	 */
	public String getPtEmNo() {
		return this.ptEmNo;
	}
	
	/**
	 * Column Info
	 * @return ptFaxNo
	 */
	public String getPtFaxNo() {
		return this.ptFaxNo;
	}
	
	/**
	 * Column Info
	 * @return grossTon
	 */
	public String getGrossTon() {
		return this.grossTon;
	}
	
	/**
	 * Column Info
	 * @return tradeRefNo
	 */
	public String getTradeRefNo() {
		return this.tradeRefNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return firstOffice
	 */
	public String getFirstOffice() {
		return this.firstOffice;
	}
	
	/**
	 * Column Info
	 * @return netTon
	 */
	public String getNetTon() {
		return this.netTon;
	}
	
	/**
	 * Column Info
	 * @return certRegDt
	 */
	public String getCertRegDt() {
		return this.certRegDt;
	}
	
	/**
	 * Column Info
	 * @return prevPort
	 */
	public String getPrevPort() {
		return this.prevPort;
	}
	
	/**
	 * Column Info
	 * @return crn
	 */
	public String getCrn() {
		return this.crn;
	}
	
	/**
	 * Column Info
	 * @return ptConCmpy
	 */
	public String getPtConCmpy() {
		return this.ptConCmpy;
	}
	
	/**
	 * Column Info
	 * @return callRefNo
	 */
	public String getCallRefNo() {
		return this.callRefNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return positionOfShip
	 */
	public String getPositionOfShip() {
		return this.positionOfShip;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	
	/**
	 * Column Info
	 * @return ptTelNo
	 */
	public String getPtTelNo() {
		return this.ptTelNo;
	}
	
	/**
	 * Column Info
	 * @return transTypeCd
	 */
	public String getTransTypeCd() {
		return this.transTypeCd;
	}
	
	/**
	 * Column Info
	 * @return etaEu
	 */
	public String getEtaEu() {
		return this.etaEu;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslName
	 */
	public String getVslName() {
		return this.vslName;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return noOfCrew
	 */
	public String getNoOfCrew() {
		return this.noOfCrew;
	}
	
	/**
	 * Column Info
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return purposeOfCall
	 */
	public String getPurposeOfCall() {
		return this.purposeOfCall;
	}
	
	/**
	 * Column Info
	 * @return certRegNo
	 */
	public String getCertRegNo() {
		return this.certRegNo;
	}
	
	/**
	 * Column Info
	 * @return originalPort
	 */
	public String getOriginalPort() {
		return this.originalPort;
	}
	
	/**
	 * Column Info
	 * @return noOfPassenger
	 */
	public String getNoOfPassenger() {
		return this.noOfPassenger;
	}
	
	/**
	 * Column Info
	 * @return certRegLoc
	 */
	public String getCertRegLoc() {
		return this.certRegLoc;
	}
	
	/**
	 * Column Info
	 * @return transNation
	 */
	public String getTransNation() {
		return this.transNation;
	}
	
	/**
	 * Column Info
	 * @return itemCountTotal
	 */
	public String getItemCountTotal() {
		return this.itemCountTotal;
	}
	
	/**
	 * Column Info
	 * @return pkgCountTotal
	 */
	public String getPkgCountTotal() {
		return this.pkgCountTotal;
	}
	
	/**
	 * Column Info
	 * @return dtmPresentation
	 */
	public String getDtmPresentation() {
		return this.dtmPresentation;
	}
	
	/**
	 * Column Info
	 * @return unloadInd
	 */
	public String getUnloadInd() {
		return this.unloadInd;
	}
	
	/**
	 * Column Info
	 * @return unloadLoc
	 */
	public String getUnloadLoc() {
		return this.unloadLoc;
	}
	
	/**
	 * Column Info
	 * @return customsRef
	 */
	public String getCustomsRef() {
		return this.customsRef;
	}
	
	/**
	 * Column Info
	 * @return firstOfficeEns
	 */
	public String getFirstOfficeEns() {
		return this.firstOfficeEns;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param arrivalPort
	 */
	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}
	
	/**
	 * Column Info
	 * @param docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	/**
	 * Column Info
	 * @param ata
	 */
	public void setAta(String ata) {
		this.ata = ata;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param ptConName
	 */
	public void setPtConName(String ptConName) {
		this.ptConName = ptConName;
	}
	
	/**
	 * Column Info
	 * @param ptEmNo
	 */
	public void setPtEmNo(String ptEmNo) {
		this.ptEmNo = ptEmNo;
	}
	
	/**
	 * Column Info
	 * @param ptFaxNo
	 */
	public void setPtFaxNo(String ptFaxNo) {
		this.ptFaxNo = ptFaxNo;
	}
	
	/**
	 * Column Info
	 * @param grossTon
	 */
	public void setGrossTon(String grossTon) {
		this.grossTon = grossTon;
	}
	
	/**
	 * Column Info
	 * @param tradeRefNo
	 */
	public void setTradeRefNo(String tradeRefNo) {
		this.tradeRefNo = tradeRefNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param firstOffice
	 */
	public void setFirstOffice(String firstOffice) {
		this.firstOffice = firstOffice;
	}
	
	/**
	 * Column Info
	 * @param netTon
	 */
	public void setNetTon(String netTon) {
		this.netTon = netTon;
	}
	
	/**
	 * Column Info
	 * @param certRegDt
	 */
	public void setCertRegDt(String certRegDt) {
		this.certRegDt = certRegDt;
	}
	
	/**
	 * Column Info
	 * @param prevPort
	 */
	public void setPrevPort(String prevPort) {
		this.prevPort = prevPort;
	}
	
	/**
	 * Column Info
	 * @param crn
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}
	
	/**
	 * Column Info
	 * @param ptConCmpy
	 */
	public void setPtConCmpy(String ptConCmpy) {
		this.ptConCmpy = ptConCmpy;
	}
	
	/**
	 * Column Info
	 * @param callRefNo
	 */
	public void setCallRefNo(String callRefNo) {
		this.callRefNo = callRefNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param positionOfShip
	 */
	public void setPositionOfShip(String positionOfShip) {
		this.positionOfShip = positionOfShip;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Column Info
	 * @param ptTelNo
	 */
	public void setPtTelNo(String ptTelNo) {
		this.ptTelNo = ptTelNo;
	}
	
	/**
	 * Column Info
	 * @param transTypeCd
	 */
	public void setTransTypeCd(String transTypeCd) {
		this.transTypeCd = transTypeCd;
	}
	
	/**
	 * Column Info
	 * @param etaEu
	 */
	public void setEtaEu(String etaEu) {
		this.etaEu = etaEu;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslName
	 */
	public void setVslName(String vslName) {
		this.vslName = vslName;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param noOfCrew
	 */
	public void setNoOfCrew(String noOfCrew) {
		this.noOfCrew = noOfCrew;
	}
	
	/**
	 * Column Info
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param purposeOfCall
	 */
	public void setPurposeOfCall(String purposeOfCall) {
		this.purposeOfCall = purposeOfCall;
	}
	
	/**
	 * Column Info
	 * @param certRegNo
	 */
	public void setCertRegNo(String certRegNo) {
		this.certRegNo = certRegNo;
	}
	
	/**
	 * Column Info
	 * @param originalPort
	 */
	public void setOriginalPort(String originalPort) {
		this.originalPort = originalPort;
	}
	
	/**
	 * Column Info
	 * @param noOfPassenger
	 */
	public void setNoOfPassenger(String noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	
	/**
	 * Column Info
	 * @param certRegLoc
	 */
	public void setCertRegLoc(String certRegLoc) {
		this.certRegLoc = certRegLoc;
	}
	
	/**
	 * Column Info
	 * @param transNation
	 */
	public void setTransNation(String transNation) {
		this.transNation = transNation;
	}
	
	/**
	 * Column Info
	 * @param itemCountTotal
	 */
	public void setItemCountTotal(String itemCountTotal) {
		this.itemCountTotal = itemCountTotal;
	}
	
	/**
	 * Column Info
	 * @param pkgCountTotal
	 */
	public void setPkgCountTotal(String pkgCountTotal) {
		this.pkgCountTotal = pkgCountTotal;
	}
	
	/**
	 * Column Info
	 * @param dtmPresentation
	 */
	public void setDtmPresentation(String dtmPresentation) {
		this.dtmPresentation = dtmPresentation;
	}
	
	/**
	 * Column Info
	 * @param unloadInd
	 */
	public void setUnloadInd(String unloadInd) {
		this.unloadInd = unloadInd;
	}
	
	/**
	 * Column Info
	 * @param unloadLoc
	 */
	public void setUnloadLoc(String unloadLoc) {
		this.unloadLoc = unloadLoc;
	}
	
	/**
	 * Column Info
	 * @param customsRef
	 */
	public void setCustomsRef(String customsRef) {
		this.customsRef = customsRef;
	}
	
	/**
	 * Column Info
	 * @param firstOfficeEns
	 */
	public void setFirstOfficeEns(String firstOfficeEns) {
		this.firstOfficeEns = firstOfficeEns;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setArrivalPort(JSPUtil.getParameter(request, prefix + "arrival_port", ""));
		setDocNo(JSPUtil.getParameter(request, prefix + "doc_no", ""));
		setAta(JSPUtil.getParameter(request, prefix + "ata", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setPtConName(JSPUtil.getParameter(request, prefix + "pt_con_name", ""));
		setPtEmNo(JSPUtil.getParameter(request, prefix + "pt_em_no", ""));
		setPtFaxNo(JSPUtil.getParameter(request, prefix + "pt_fax_no", ""));
		setGrossTon(JSPUtil.getParameter(request, prefix + "gross_ton", ""));
		setTradeRefNo(JSPUtil.getParameter(request, prefix + "trade_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFirstOffice(JSPUtil.getParameter(request, prefix + "first_office", ""));
		setNetTon(JSPUtil.getParameter(request, prefix + "net_ton", ""));
		setCertRegDt(JSPUtil.getParameter(request, prefix + "cert_reg_dt", ""));
		setPrevPort(JSPUtil.getParameter(request, prefix + "prev_port", ""));
		setCrn(JSPUtil.getParameter(request, prefix + "crn", ""));
		setPtConCmpy(JSPUtil.getParameter(request, prefix + "pt_con_cmpy", ""));
		setCallRefNo(JSPUtil.getParameter(request, prefix + "call_ref_no", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setPositionOfShip(JSPUtil.getParameter(request, prefix + "position_of_ship", ""));
		setNextPort(JSPUtil.getParameter(request, prefix + "next_port", ""));
		setPtTelNo(JSPUtil.getParameter(request, prefix + "pt_tel_no", ""));
		setTransTypeCd(JSPUtil.getParameter(request, prefix + "trans_type_cd", ""));
		setEtaEu(JSPUtil.getParameter(request, prefix + "eta_eu", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslName(JSPUtil.getParameter(request, prefix + "vsl_name", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setNoOfCrew(JSPUtil.getParameter(request, prefix + "no_of_crew", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setPurposeOfCall(JSPUtil.getParameter(request, prefix + "purpose_of_call", ""));
		setCertRegNo(JSPUtil.getParameter(request, prefix + "cert_reg_no", ""));
		setOriginalPort(JSPUtil.getParameter(request, prefix + "original_port", ""));
		setNoOfPassenger(JSPUtil.getParameter(request, prefix + "no_of_passenger", ""));
		setCertRegLoc(JSPUtil.getParameter(request, prefix + "cert_reg_loc", ""));
		setTransNation(JSPUtil.getParameter(request, prefix + "trans_nation", ""));
		setItemCountTotal(JSPUtil.getParameter(request, prefix + "item_count_total", ""));
		setPkgCountTotal(JSPUtil.getParameter(request, prefix + "pkg_count_total", ""));
		setDtmPresentation(JSPUtil.getParameter(request, prefix + "dtm_presentation", ""));
		setUnloadInd(JSPUtil.getParameter(request, prefix + "unload_ind", ""));
		setUnloadLoc(JSPUtil.getParameter(request, prefix + "unload_loc", ""));
		setCustomsRef(JSPUtil.getParameter(request, prefix + "customs_ref", ""));
		setFirstOfficeEns(JSPUtil.getParameter(request, prefix + "first_office_ens", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24VesselArrivalVO[]
	 */
	public Eur24VesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24VesselArrivalVO[]
	 */
	public Eur24VesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24VesselArrivalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] arrivalPort = (JSPUtil.getParameter(request, prefix	+ "arrival_port", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] ata = (JSPUtil.getParameter(request, prefix	+ "ata", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] ptConName = (JSPUtil.getParameter(request, prefix	+ "pt_con_name", length));
			String[] ptEmNo = (JSPUtil.getParameter(request, prefix	+ "pt_em_no", length));
			String[] ptFaxNo = (JSPUtil.getParameter(request, prefix	+ "pt_fax_no", length));
			String[] grossTon = (JSPUtil.getParameter(request, prefix	+ "gross_ton", length));
			String[] tradeRefNo = (JSPUtil.getParameter(request, prefix	+ "trade_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] firstOffice = (JSPUtil.getParameter(request, prefix	+ "first_office", length));
			String[] netTon = (JSPUtil.getParameter(request, prefix	+ "net_ton", length));
			String[] certRegDt = (JSPUtil.getParameter(request, prefix	+ "cert_reg_dt", length));
			String[] prevPort = (JSPUtil.getParameter(request, prefix	+ "prev_port", length));
			String[] crn = (JSPUtil.getParameter(request, prefix	+ "crn", length));
			String[] ptConCmpy = (JSPUtil.getParameter(request, prefix	+ "pt_con_cmpy", length));
			String[] callRefNo = (JSPUtil.getParameter(request, prefix	+ "call_ref_no", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] positionOfShip = (JSPUtil.getParameter(request, prefix	+ "position_of_ship", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] ptTelNo = (JSPUtil.getParameter(request, prefix	+ "pt_tel_no", length));
			String[] transTypeCd = (JSPUtil.getParameter(request, prefix	+ "trans_type_cd", length));
			String[] etaEu = (JSPUtil.getParameter(request, prefix	+ "eta_eu", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] noOfCrew = (JSPUtil.getParameter(request, prefix	+ "no_of_crew", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] purposeOfCall = (JSPUtil.getParameter(request, prefix	+ "purpose_of_call", length));
			String[] certRegNo = (JSPUtil.getParameter(request, prefix	+ "cert_reg_no", length));
			String[] originalPort = (JSPUtil.getParameter(request, prefix	+ "original_port", length));
			String[] noOfPassenger = (JSPUtil.getParameter(request, prefix	+ "no_of_passenger", length));
			String[] certRegLoc = (JSPUtil.getParameter(request, prefix	+ "cert_reg_loc", length));
			String[] transNation = (JSPUtil.getParameter(request, prefix	+ "trans_nation", length));
			String[] itemCountTotal = (JSPUtil.getParameter(request, prefix	+ "item_count_total", length));
			String[] pkgCountTotal = (JSPUtil.getParameter(request, prefix	+ "pkg_count_total", length));
			String[] dtmPresentation = (JSPUtil.getParameter(request, prefix	+ "dtm_presentation", length));
			String[] unloadInd = (JSPUtil.getParameter(request, prefix	+ "unload_ind", length));
			String[] unloadLoc = (JSPUtil.getParameter(request, prefix	+ "unload_loc", length));
			String[] customsRef = (JSPUtil.getParameter(request, prefix	+ "customs_ref", length));
			String[] firstOfficeEns = (JSPUtil.getParameter(request, prefix	+ "first_office_ens", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24VesselArrivalVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (arrivalPort[i] != null)
					model.setArrivalPort(arrivalPort[i]);
				if (docNo[i] != null)
					model.setDocNo(docNo[i]);
				if (ata[i] != null)
					model.setAta(ata[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (ptConName[i] != null)
					model.setPtConName(ptConName[i]);
				if (ptEmNo[i] != null)
					model.setPtEmNo(ptEmNo[i]);
				if (ptFaxNo[i] != null)
					model.setPtFaxNo(ptFaxNo[i]);
				if (grossTon[i] != null)
					model.setGrossTon(grossTon[i]);
				if (tradeRefNo[i] != null)
					model.setTradeRefNo(tradeRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (firstOffice[i] != null)
					model.setFirstOffice(firstOffice[i]);
				if (netTon[i] != null)
					model.setNetTon(netTon[i]);
				if (certRegDt[i] != null)
					model.setCertRegDt(certRegDt[i]);
				if (prevPort[i] != null)
					model.setPrevPort(prevPort[i]);
				if (crn[i] != null)
					model.setCrn(crn[i]);
				if (ptConCmpy[i] != null)
					model.setPtConCmpy(ptConCmpy[i]);
				if (callRefNo[i] != null)
					model.setCallRefNo(callRefNo[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (positionOfShip[i] != null)
					model.setPositionOfShip(positionOfShip[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (ptTelNo[i] != null)
					model.setPtTelNo(ptTelNo[i]);
				if (transTypeCd[i] != null)
					model.setTransTypeCd(transTypeCd[i]);
				if (etaEu[i] != null)
					model.setEtaEu(etaEu[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (noOfCrew[i] != null)
					model.setNoOfCrew(noOfCrew[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (purposeOfCall[i] != null)
					model.setPurposeOfCall(purposeOfCall[i]);
				if (certRegNo[i] != null)
					model.setCertRegNo(certRegNo[i]);
				if (originalPort[i] != null)
					model.setOriginalPort(originalPort[i]);
				if (noOfPassenger[i] != null)
					model.setNoOfPassenger(noOfPassenger[i]);
				if (certRegLoc[i] != null)
					model.setCertRegLoc(certRegLoc[i]);
				if (transNation[i] != null)
					model.setTransNation(transNation[i]);
				if (itemCountTotal[i] != null)
					model.setItemCountTotal(itemCountTotal[i]);
				if (pkgCountTotal[i] != null)
					model.setPkgCountTotal(pkgCountTotal[i]);
				if (dtmPresentation[i] != null)
					model.setDtmPresentation(dtmPresentation[i]);
				if (unloadInd[i] != null)
					model.setUnloadInd(unloadInd[i]);
				if (unloadLoc[i] != null)
					model.setUnloadLoc(unloadLoc[i]);
				if (customsRef[i] != null)
					model.setCustomsRef(customsRef[i]);
				if (firstOfficeEns[i] != null)
					model.setFirstOfficeEns(firstOfficeEns[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24VesselArrivalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24VesselArrivalVO[]
	 */
	public Eur24VesselArrivalVO[] getEur24VesselArrivalVOs(){
		Eur24VesselArrivalVO[] vos = (Eur24VesselArrivalVO[])models.toArray(new Eur24VesselArrivalVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalPort = this.arrivalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ata = this.ata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptConName = this.ptConName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptEmNo = this.ptEmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptFaxNo = this.ptFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossTon = this.grossTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeRefNo = this.tradeRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstOffice = this.firstOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netTon = this.netTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certRegDt = this.certRegDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevPort = this.prevPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crn = this.crn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptConCmpy = this.ptConCmpy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callRefNo = this.callRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.positionOfShip = this.positionOfShip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptTelNo = this.ptTelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTypeCd = this.transTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaEu = this.etaEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfCrew = this.noOfCrew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purposeOfCall = this.purposeOfCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certRegNo = this.certRegNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalPort = this.originalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfPassenger = this.noOfPassenger .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certRegLoc = this.certRegLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transNation = this.transNation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemCountTotal = this.itemCountTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCountTotal = this.pkgCountTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtmPresentation = this.dtmPresentation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadInd = this.unloadInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadLoc = this.unloadLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsRef = this.customsRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstOfficeEns = this.firstOfficeEns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
