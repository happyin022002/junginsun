/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : searchVesselArrivalVO.java
*@FileTitle : searchVesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchVesselArrivalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchVesselArrivalVO> models = new ArrayList<searchVesselArrivalVO>();
	
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
	private String grsooTon = null;
	/* Column Info */
	private String callRefNo = null;
	/* Column Info */
	private String positionOfShip = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String transTypeCd = null;
	/* Column Info */
	private String etaEu = null;
	/* Column Info */
	private String vslName = null;
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
	private String noOfPassenger = null;
	/* Column Info */
	private String certRegLoc = null;
	/* Column Info */
	private String transNation = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchVesselArrivalVO() {}

	public searchVesselArrivalVO(String ibflag, String pagerows, String docNo, String callRefNo, String tradeRefNo, String purposeOfCall, String crn, String transMode, String transTypeCd, String lloydNo, String vslName, String transNation, String eta, String etaEu, String ata, String etd, String firstOffice, String positionOfShip, String prevPort, String arrivalPort, String nextPort, String certRegNo, String certRegDt, String certRegLoc, String grsooTon, String netTon, String noOfCrew, String noOfPassenger) {
		this.eta = eta;
		this.arrivalPort = arrivalPort;
		this.docNo = docNo;
		this.ata = ata;
		this.etd = etd;
		this.tradeRefNo = tradeRefNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.firstOffice = firstOffice;
		this.netTon = netTon;
		this.certRegDt = certRegDt;
		this.prevPort = prevPort;
		this.crn = crn;
		this.grsooTon = grsooTon;
		this.callRefNo = callRefNo;
		this.positionOfShip = positionOfShip;
		this.nextPort = nextPort;
		this.transTypeCd = transTypeCd;
		this.etaEu = etaEu;
		this.vslName = vslName;
		this.noOfCrew = noOfCrew;
		this.transMode = transMode;
		this.lloydNo = lloydNo;
		this.purposeOfCall = purposeOfCall;
		this.certRegNo = certRegNo;
		this.noOfPassenger = noOfPassenger;
		this.certRegLoc = certRegLoc;
		this.transNation = transNation;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("arrival_port", getArrivalPort());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("ata", getAta());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("trade_ref_no", getTradeRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("first_office", getFirstOffice());
		this.hashColumns.put("net_ton", getNetTon());
		this.hashColumns.put("cert_reg_dt", getCertRegDt());
		this.hashColumns.put("prev_port", getPrevPort());
		this.hashColumns.put("crn", getCrn());
		this.hashColumns.put("grsoo_ton", getGrsooTon());
		this.hashColumns.put("call_ref_no", getCallRefNo());
		this.hashColumns.put("position_of_ship", getPositionOfShip());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("trans_type_cd", getTransTypeCd());
		this.hashColumns.put("eta_eu", getEtaEu());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("no_of_crew", getNoOfCrew());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("purpose_of_call", getPurposeOfCall());
		this.hashColumns.put("cert_reg_no", getCertRegNo());
		this.hashColumns.put("no_of_passenger", getNoOfPassenger());
		this.hashColumns.put("cert_reg_loc", getCertRegLoc());
		this.hashColumns.put("trans_nation", getTransNation());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("arrival_port", "arrivalPort");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("ata", "ata");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("trade_ref_no", "tradeRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("first_office", "firstOffice");
		this.hashFields.put("net_ton", "netTon");
		this.hashFields.put("cert_reg_dt", "certRegDt");
		this.hashFields.put("prev_port", "prevPort");
		this.hashFields.put("crn", "crn");
		this.hashFields.put("grsoo_ton", "grsooTon");
		this.hashFields.put("call_ref_no", "callRefNo");
		this.hashFields.put("position_of_ship", "positionOfShip");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("trans_type_cd", "transTypeCd");
		this.hashFields.put("eta_eu", "etaEu");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("no_of_crew", "noOfCrew");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("purpose_of_call", "purposeOfCall");
		this.hashFields.put("cert_reg_no", "certRegNo");
		this.hashFields.put("no_of_passenger", "noOfPassenger");
		this.hashFields.put("cert_reg_loc", "certRegLoc");
		this.hashFields.put("trans_nation", "transNation");
		return this.hashFields;
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
	 * @return grsooTon
	 */
	public String getGrsooTon() {
		return this.grsooTon;
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
	 * @return vslName
	 */
	public String getVslName() {
		return this.vslName;
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
	 * @param grsooTon
	 */
	public void setGrsooTon(String grsooTon) {
		this.grsooTon = grsooTon;
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
	 * @param vslName
	 */
	public void setVslName(String vslName) {
		this.vslName = vslName;
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
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setArrivalPort(JSPUtil.getParameter(request, prefix + "arrival_port", ""));
		setDocNo(JSPUtil.getParameter(request, prefix + "doc_no", ""));
		setAta(JSPUtil.getParameter(request, prefix + "ata", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setTradeRefNo(JSPUtil.getParameter(request, prefix + "trade_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFirstOffice(JSPUtil.getParameter(request, prefix + "first_office", ""));
		setNetTon(JSPUtil.getParameter(request, prefix + "net_ton", ""));
		setCertRegDt(JSPUtil.getParameter(request, prefix + "cert_reg_dt", ""));
		setPrevPort(JSPUtil.getParameter(request, prefix + "prev_port", ""));
		setCrn(JSPUtil.getParameter(request, prefix + "crn", ""));
		setGrsooTon(JSPUtil.getParameter(request, prefix + "grsoo_ton", ""));
		setCallRefNo(JSPUtil.getParameter(request, prefix + "call_ref_no", ""));
		setPositionOfShip(JSPUtil.getParameter(request, prefix + "position_of_ship", ""));
		setNextPort(JSPUtil.getParameter(request, prefix + "next_port", ""));
		setTransTypeCd(JSPUtil.getParameter(request, prefix + "trans_type_cd", ""));
		setEtaEu(JSPUtil.getParameter(request, prefix + "eta_eu", ""));
		setVslName(JSPUtil.getParameter(request, prefix + "vsl_name", ""));
		setNoOfCrew(JSPUtil.getParameter(request, prefix + "no_of_crew", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setPurposeOfCall(JSPUtil.getParameter(request, prefix + "purpose_of_call", ""));
		setCertRegNo(JSPUtil.getParameter(request, prefix + "cert_reg_no", ""));
		setNoOfPassenger(JSPUtil.getParameter(request, prefix + "no_of_passenger", ""));
		setCertRegLoc(JSPUtil.getParameter(request, prefix + "cert_reg_loc", ""));
		setTransNation(JSPUtil.getParameter(request, prefix + "trans_nation", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchVesselArrivalVO[]
	 */
	public searchVesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchVesselArrivalVO[]
	 */
	public searchVesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchVesselArrivalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] arrivalPort = (JSPUtil.getParameter(request, prefix	+ "arrival_port", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] ata = (JSPUtil.getParameter(request, prefix	+ "ata", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] tradeRefNo = (JSPUtil.getParameter(request, prefix	+ "trade_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] firstOffice = (JSPUtil.getParameter(request, prefix	+ "first_office", length));
			String[] netTon = (JSPUtil.getParameter(request, prefix	+ "net_ton", length));
			String[] certRegDt = (JSPUtil.getParameter(request, prefix	+ "cert_reg_dt", length));
			String[] prevPort = (JSPUtil.getParameter(request, prefix	+ "prev_port", length));
			String[] crn = (JSPUtil.getParameter(request, prefix	+ "crn", length));
			String[] grsooTon = (JSPUtil.getParameter(request, prefix	+ "grsoo_ton", length));
			String[] callRefNo = (JSPUtil.getParameter(request, prefix	+ "call_ref_no", length));
			String[] positionOfShip = (JSPUtil.getParameter(request, prefix	+ "position_of_ship", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] transTypeCd = (JSPUtil.getParameter(request, prefix	+ "trans_type_cd", length));
			String[] etaEu = (JSPUtil.getParameter(request, prefix	+ "eta_eu", length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name", length));
			String[] noOfCrew = (JSPUtil.getParameter(request, prefix	+ "no_of_crew", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] purposeOfCall = (JSPUtil.getParameter(request, prefix	+ "purpose_of_call", length));
			String[] certRegNo = (JSPUtil.getParameter(request, prefix	+ "cert_reg_no", length));
			String[] noOfPassenger = (JSPUtil.getParameter(request, prefix	+ "no_of_passenger", length));
			String[] certRegLoc = (JSPUtil.getParameter(request, prefix	+ "cert_reg_loc", length));
			String[] transNation = (JSPUtil.getParameter(request, prefix	+ "trans_nation", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchVesselArrivalVO();
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
				if (grsooTon[i] != null)
					model.setGrsooTon(grsooTon[i]);
				if (callRefNo[i] != null)
					model.setCallRefNo(callRefNo[i]);
				if (positionOfShip[i] != null)
					model.setPositionOfShip(positionOfShip[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (transTypeCd[i] != null)
					model.setTransTypeCd(transTypeCd[i]);
				if (etaEu[i] != null)
					model.setEtaEu(etaEu[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
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
				if (noOfPassenger[i] != null)
					model.setNoOfPassenger(noOfPassenger[i]);
				if (certRegLoc[i] != null)
					model.setCertRegLoc(certRegLoc[i]);
				if (transNation[i] != null)
					model.setTransNation(transNation[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchVesselArrivalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchVesselArrivalVO[]
	 */
	public searchVesselArrivalVO[] getsearchVesselArrivalVOs(){
		searchVesselArrivalVO[] vos = (searchVesselArrivalVO[])models.toArray(new searchVesselArrivalVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalPort = this.arrivalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ata = this.ata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeRefNo = this.tradeRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstOffice = this.firstOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netTon = this.netTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certRegDt = this.certRegDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevPort = this.prevPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crn = this.crn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsooTon = this.grsooTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callRefNo = this.callRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.positionOfShip = this.positionOfShip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTypeCd = this.transTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaEu = this.etaEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfCrew = this.noOfCrew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.purposeOfCall = this.purposeOfCall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certRegNo = this.certRegNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfPassenger = this.noOfPassenger .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certRegLoc = this.certRegLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transNation = this.transNation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
