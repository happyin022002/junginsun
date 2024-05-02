/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24DiversionRequestVO.java
*@FileTitle : Eur24DiversionRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.26  
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

public class Eur24DiversionRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24DiversionRequestVO> models = new ArrayList<Eur24DiversionRequestVO>();
	
	/* Column Info */
	private String ptName = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String itSeq = null;
	/* Column Info */
	private String docNo = null;
	/* Column Info */
	private String infoType = null;
	/* Column Info */
	private String ptConName = null;
	/* Column Info */
	private String ptEmNo = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String actFirstOffice = null;
	/* Column Info */
	private String ptEori = null;
	/* Column Info */
	private String ptFaxNo = null;
	/* Column Info */
	private String ptCntCd = null;
	/* Column Info */
	private String orgRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ptStreet = null;
	/* Column Info */
	private String prevPort = null;
	/* Column Info */
	private String ptTin = null;
	/* Column Info */
	private String ptAddress = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String crn = null;
	/* Column Info */
	private String ptConCmpy = null;
	/* Column Info */
	private String routingPort = null;
	/* Column Info */
	private String callRefNo = null;
	/* Column Info */
	private String orgFirstOffice = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String itFileSeq = null;
	/* Column Info */
	private String ptCity = null;
	/* Column Info */
	private String ptTelNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String originalPort = null;
	/* Column Info */
	private String ptType = null;
	/* Column Info */
	private String ptPostalCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24DiversionRequestVO() {}

	public Eur24DiversionRequestVO(String ibflag, String pagerows, String docNo, String callRefNo, String orgRefNo, String crn, String divRefNo, String transMode, String lloydCd, String vslName, String eta, String cntCd, String originalPort, String infoType, String orgFirstOffice, String actFirstOffice, String prevPort, String routingPort, String ptType, String ptTin, String ptEori, String ptName, String ptAddress, String ptStreet, String ptCity, String ptPostalCd, String ptCntCd, String ptConName, String ptConCmpy, String ptFaxNo, String ptEmNo, String ptTelNo, String vslCd, String skdVoyNo, String skdDirCd, String cstmsPortCd, String itSeq, String itFileSeq) {
		this.ptName = ptName;
		this.vslCd = vslCd;
		this.eta = eta;
		this.itSeq = itSeq;
		this.docNo = docNo;
		this.infoType = infoType;
		this.ptConName = ptConName;
		this.ptEmNo = ptEmNo;
		this.lloydCd = lloydCd;
		this.actFirstOffice = actFirstOffice;
		this.ptEori = ptEori;
		this.ptFaxNo = ptFaxNo;
		this.ptCntCd = ptCntCd;
		this.orgRefNo = orgRefNo;
		this.pagerows = pagerows;
		this.divRefNo = divRefNo;
		this.ibflag = ibflag;
		this.ptStreet = ptStreet;
		this.prevPort = prevPort;
		this.ptTin = ptTin;
		this.ptAddress = ptAddress;
		this.cntCd = cntCd;
		this.crn = crn;
		this.ptConCmpy = ptConCmpy;
		this.routingPort = routingPort;
		this.callRefNo = callRefNo;
		this.orgFirstOffice = orgFirstOffice;
		this.cstmsPortCd = cstmsPortCd;
		this.itFileSeq = itFileSeq;
		this.ptCity = ptCity;
		this.ptTelNo = ptTelNo;
		this.skdVoyNo = skdVoyNo;
		this.vslName = vslName;
		this.skdDirCd = skdDirCd;
		this.transMode = transMode;
		this.originalPort = originalPort;
		this.ptType = ptType;
		this.ptPostalCd = ptPostalCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pt_name", getPtName());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("it_seq", getItSeq());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("info_type", getInfoType());
		this.hashColumns.put("pt_con_name", getPtConName());
		this.hashColumns.put("pt_em_no", getPtEmNo());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("act_first_office", getActFirstOffice());
		this.hashColumns.put("pt_eori", getPtEori());
		this.hashColumns.put("pt_fax_no", getPtFaxNo());
		this.hashColumns.put("pt_cnt_cd", getPtCntCd());
		this.hashColumns.put("org_ref_no", getOrgRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("div_ref_no", getDivRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pt_street", getPtStreet());
		this.hashColumns.put("prev_port", getPrevPort());
		this.hashColumns.put("pt_tin", getPtTin());
		this.hashColumns.put("pt_address", getPtAddress());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("crn", getCrn());
		this.hashColumns.put("pt_con_cmpy", getPtConCmpy());
		this.hashColumns.put("routing_port", getRoutingPort());
		this.hashColumns.put("call_ref_no", getCallRefNo());
		this.hashColumns.put("org_first_office", getOrgFirstOffice());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("it_file_seq", getItFileSeq());
		this.hashColumns.put("pt_city", getPtCity());
		this.hashColumns.put("pt_tel_no", getPtTelNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("original_port", getOriginalPort());
		this.hashColumns.put("pt_type", getPtType());
		this.hashColumns.put("pt_postal_cd", getPtPostalCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pt_name", "ptName");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("it_seq", "itSeq");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("info_type", "infoType");
		this.hashFields.put("pt_con_name", "ptConName");
		this.hashFields.put("pt_em_no", "ptEmNo");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("act_first_office", "actFirstOffice");
		this.hashFields.put("pt_eori", "ptEori");
		this.hashFields.put("pt_fax_no", "ptFaxNo");
		this.hashFields.put("pt_cnt_cd", "ptCntCd");
		this.hashFields.put("org_ref_no", "orgRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("div_ref_no", "divRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pt_street", "ptStreet");
		this.hashFields.put("prev_port", "prevPort");
		this.hashFields.put("pt_tin", "ptTin");
		this.hashFields.put("pt_address", "ptAddress");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("crn", "crn");
		this.hashFields.put("pt_con_cmpy", "ptConCmpy");
		this.hashFields.put("routing_port", "routingPort");
		this.hashFields.put("call_ref_no", "callRefNo");
		this.hashFields.put("org_first_office", "orgFirstOffice");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("it_file_seq", "itFileSeq");
		this.hashFields.put("pt_city", "ptCity");
		this.hashFields.put("pt_tel_no", "ptTelNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("original_port", "originalPort");
		this.hashFields.put("pt_type", "ptType");
		this.hashFields.put("pt_postal_cd", "ptPostalCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ptName
	 */
	public String getPtName() {
		return this.ptName;
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
	 * @return itSeq
	 */
	public String getItSeq() {
		return this.itSeq;
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
	 * @return infoType
	 */
	public String getInfoType() {
		return this.infoType;
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
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return actFirstOffice
	 */
	public String getActFirstOffice() {
		return this.actFirstOffice;
	}
	
	/**
	 * Column Info
	 * @return ptEori
	 */
	public String getPtEori() {
		return this.ptEori;
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
	 * @return ptCntCd
	 */
	public String getPtCntCd() {
		return this.ptCntCd;
	}
	
	/**
	 * Column Info
	 * @return orgRefNo
	 */
	public String getOrgRefNo() {
		return this.orgRefNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return divRefNo
	 */
	public String getDivRefNo() {
		return this.divRefNo;
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
	 * @return ptStreet
	 */
	public String getPtStreet() {
		return this.ptStreet;
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
	 * @return ptTin
	 */
	public String getPtTin() {
		return this.ptTin;
	}
	
	/**
	 * Column Info
	 * @return ptAddress
	 */
	public String getPtAddress() {
		return this.ptAddress;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return routingPort
	 */
	public String getRoutingPort() {
		return this.routingPort;
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
	 * @return orgFirstOffice
	 */
	public String getOrgFirstOffice() {
		return this.orgFirstOffice;
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
	 * @return itFileSeq
	 */
	public String getItFileSeq() {
		return this.itFileSeq;
	}
	
	/**
	 * Column Info
	 * @return ptCity
	 */
	public String getPtCity() {
		return this.ptCity;
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
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
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
	 * @return ptType
	 */
	public String getPtType() {
		return this.ptType;
	}
	
	/**
	 * Column Info
	 * @return ptPostalCd
	 */
	public String getPtPostalCd() {
		return this.ptPostalCd;
	}
	

	/**
	 * Column Info
	 * @param ptName
	 */
	public void setPtName(String ptName) {
		this.ptName = ptName;
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
	 * @param itSeq
	 */
	public void setItSeq(String itSeq) {
		this.itSeq = itSeq;
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
	 * @param infoType
	 */
	public void setInfoType(String infoType) {
		this.infoType = infoType;
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
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param actFirstOffice
	 */
	public void setActFirstOffice(String actFirstOffice) {
		this.actFirstOffice = actFirstOffice;
	}
	
	/**
	 * Column Info
	 * @param ptEori
	 */
	public void setPtEori(String ptEori) {
		this.ptEori = ptEori;
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
	 * @param ptCntCd
	 */
	public void setPtCntCd(String ptCntCd) {
		this.ptCntCd = ptCntCd;
	}
	
	/**
	 * Column Info
	 * @param orgRefNo
	 */
	public void setOrgRefNo(String orgRefNo) {
		this.orgRefNo = orgRefNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param divRefNo
	 */
	public void setDivRefNo(String divRefNo) {
		this.divRefNo = divRefNo;
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
	 * @param ptStreet
	 */
	public void setPtStreet(String ptStreet) {
		this.ptStreet = ptStreet;
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
	 * @param ptTin
	 */
	public void setPtTin(String ptTin) {
		this.ptTin = ptTin;
	}
	
	/**
	 * Column Info
	 * @param ptAddress
	 */
	public void setPtAddress(String ptAddress) {
		this.ptAddress = ptAddress;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param routingPort
	 */
	public void setRoutingPort(String routingPort) {
		this.routingPort = routingPort;
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
	 * @param orgFirstOffice
	 */
	public void setOrgFirstOffice(String orgFirstOffice) {
		this.orgFirstOffice = orgFirstOffice;
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
	 * @param itFileSeq
	 */
	public void setItFileSeq(String itFileSeq) {
		this.itFileSeq = itFileSeq;
	}
	
	/**
	 * Column Info
	 * @param ptCity
	 */
	public void setPtCity(String ptCity) {
		this.ptCity = ptCity;
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
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
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
	 * @param ptType
	 */
	public void setPtType(String ptType) {
		this.ptType = ptType;
	}
	
	/**
	 * Column Info
	 * @param ptPostalCd
	 */
	public void setPtPostalCd(String ptPostalCd) {
		this.ptPostalCd = ptPostalCd;
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
		setPtName(JSPUtil.getParameter(request, prefix + "pt_name", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setItSeq(JSPUtil.getParameter(request, prefix + "it_seq", ""));
		setDocNo(JSPUtil.getParameter(request, prefix + "doc_no", ""));
		setInfoType(JSPUtil.getParameter(request, prefix + "info_type", ""));
		setPtConName(JSPUtil.getParameter(request, prefix + "pt_con_name", ""));
		setPtEmNo(JSPUtil.getParameter(request, prefix + "pt_em_no", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setActFirstOffice(JSPUtil.getParameter(request, prefix + "act_first_office", ""));
		setPtEori(JSPUtil.getParameter(request, prefix + "pt_eori", ""));
		setPtFaxNo(JSPUtil.getParameter(request, prefix + "pt_fax_no", ""));
		setPtCntCd(JSPUtil.getParameter(request, prefix + "pt_cnt_cd", ""));
		setOrgRefNo(JSPUtil.getParameter(request, prefix + "org_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDivRefNo(JSPUtil.getParameter(request, prefix + "div_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPtStreet(JSPUtil.getParameter(request, prefix + "pt_street", ""));
		setPrevPort(JSPUtil.getParameter(request, prefix + "prev_port", ""));
		setPtTin(JSPUtil.getParameter(request, prefix + "pt_tin", ""));
		setPtAddress(JSPUtil.getParameter(request, prefix + "pt_address", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCrn(JSPUtil.getParameter(request, prefix + "crn", ""));
		setPtConCmpy(JSPUtil.getParameter(request, prefix + "pt_con_cmpy", ""));
		setRoutingPort(JSPUtil.getParameter(request, prefix + "routing_port", ""));
		setCallRefNo(JSPUtil.getParameter(request, prefix + "call_ref_no", ""));
		setOrgFirstOffice(JSPUtil.getParameter(request, prefix + "org_first_office", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setItFileSeq(JSPUtil.getParameter(request, prefix + "it_file_seq", ""));
		setPtCity(JSPUtil.getParameter(request, prefix + "pt_city", ""));
		setPtTelNo(JSPUtil.getParameter(request, prefix + "pt_tel_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslName(JSPUtil.getParameter(request, prefix + "vsl_name", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setOriginalPort(JSPUtil.getParameter(request, prefix + "original_port", ""));
		setPtType(JSPUtil.getParameter(request, prefix + "pt_type", ""));
		setPtPostalCd(JSPUtil.getParameter(request, prefix + "pt_postal_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24DiversionRequestVO[]
	 */
	public Eur24DiversionRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24DiversionRequestVO[]
	 */
	public Eur24DiversionRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24DiversionRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ptName = (JSPUtil.getParameter(request, prefix	+ "pt_name", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] itSeq = (JSPUtil.getParameter(request, prefix	+ "it_seq", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] infoType = (JSPUtil.getParameter(request, prefix	+ "info_type", length));
			String[] ptConName = (JSPUtil.getParameter(request, prefix	+ "pt_con_name", length));
			String[] ptEmNo = (JSPUtil.getParameter(request, prefix	+ "pt_em_no", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] actFirstOffice = (JSPUtil.getParameter(request, prefix	+ "act_first_office", length));
			String[] ptEori = (JSPUtil.getParameter(request, prefix	+ "pt_eori", length));
			String[] ptFaxNo = (JSPUtil.getParameter(request, prefix	+ "pt_fax_no", length));
			String[] ptCntCd = (JSPUtil.getParameter(request, prefix	+ "pt_cnt_cd", length));
			String[] orgRefNo = (JSPUtil.getParameter(request, prefix	+ "org_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divRefNo = (JSPUtil.getParameter(request, prefix	+ "div_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ptStreet = (JSPUtil.getParameter(request, prefix	+ "pt_street", length));
			String[] prevPort = (JSPUtil.getParameter(request, prefix	+ "prev_port", length));
			String[] ptTin = (JSPUtil.getParameter(request, prefix	+ "pt_tin", length));
			String[] ptAddress = (JSPUtil.getParameter(request, prefix	+ "pt_address", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] crn = (JSPUtil.getParameter(request, prefix	+ "crn", length));
			String[] ptConCmpy = (JSPUtil.getParameter(request, prefix	+ "pt_con_cmpy", length));
			String[] routingPort = (JSPUtil.getParameter(request, prefix	+ "routing_port", length));
			String[] callRefNo = (JSPUtil.getParameter(request, prefix	+ "call_ref_no", length));
			String[] orgFirstOffice = (JSPUtil.getParameter(request, prefix	+ "org_first_office", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] itFileSeq = (JSPUtil.getParameter(request, prefix	+ "it_file_seq", length));
			String[] ptCity = (JSPUtil.getParameter(request, prefix	+ "pt_city", length));
			String[] ptTelNo = (JSPUtil.getParameter(request, prefix	+ "pt_tel_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] originalPort = (JSPUtil.getParameter(request, prefix	+ "original_port", length));
			String[] ptType = (JSPUtil.getParameter(request, prefix	+ "pt_type", length));
			String[] ptPostalCd = (JSPUtil.getParameter(request, prefix	+ "pt_postal_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24DiversionRequestVO();
				if (ptName[i] != null)
					model.setPtName(ptName[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (itSeq[i] != null)
					model.setItSeq(itSeq[i]);
				if (docNo[i] != null)
					model.setDocNo(docNo[i]);
				if (infoType[i] != null)
					model.setInfoType(infoType[i]);
				if (ptConName[i] != null)
					model.setPtConName(ptConName[i]);
				if (ptEmNo[i] != null)
					model.setPtEmNo(ptEmNo[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (actFirstOffice[i] != null)
					model.setActFirstOffice(actFirstOffice[i]);
				if (ptEori[i] != null)
					model.setPtEori(ptEori[i]);
				if (ptFaxNo[i] != null)
					model.setPtFaxNo(ptFaxNo[i]);
				if (ptCntCd[i] != null)
					model.setPtCntCd(ptCntCd[i]);
				if (orgRefNo[i] != null)
					model.setOrgRefNo(orgRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divRefNo[i] != null)
					model.setDivRefNo(divRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ptStreet[i] != null)
					model.setPtStreet(ptStreet[i]);
				if (prevPort[i] != null)
					model.setPrevPort(prevPort[i]);
				if (ptTin[i] != null)
					model.setPtTin(ptTin[i]);
				if (ptAddress[i] != null)
					model.setPtAddress(ptAddress[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (crn[i] != null)
					model.setCrn(crn[i]);
				if (ptConCmpy[i] != null)
					model.setPtConCmpy(ptConCmpy[i]);
				if (routingPort[i] != null)
					model.setRoutingPort(routingPort[i]);
				if (callRefNo[i] != null)
					model.setCallRefNo(callRefNo[i]);
				if (orgFirstOffice[i] != null)
					model.setOrgFirstOffice(orgFirstOffice[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (itFileSeq[i] != null)
					model.setItFileSeq(itFileSeq[i]);
				if (ptCity[i] != null)
					model.setPtCity(ptCity[i]);
				if (ptTelNo[i] != null)
					model.setPtTelNo(ptTelNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (originalPort[i] != null)
					model.setOriginalPort(originalPort[i]);
				if (ptType[i] != null)
					model.setPtType(ptType[i]);
				if (ptPostalCd[i] != null)
					model.setPtPostalCd(ptPostalCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24DiversionRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24DiversionRequestVO[]
	 */
	public Eur24DiversionRequestVO[] getEur24DiversionRequestVOs(){
		Eur24DiversionRequestVO[] vos = (Eur24DiversionRequestVO[])models.toArray(new Eur24DiversionRequestVO[models.size()]);
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
		this.ptName = this.ptName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itSeq = this.itSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoType = this.infoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptConName = this.ptConName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptEmNo = this.ptEmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFirstOffice = this.actFirstOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptEori = this.ptEori .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptFaxNo = this.ptFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCntCd = this.ptCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRefNo = this.orgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divRefNo = this.divRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptStreet = this.ptStreet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevPort = this.prevPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptTin = this.ptTin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress = this.ptAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crn = this.crn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptConCmpy = this.ptConCmpy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routingPort = this.routingPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callRefNo = this.callRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFirstOffice = this.orgFirstOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itFileSeq = this.itFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCity = this.ptCity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptTelNo = this.ptTelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalPort = this.originalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptType = this.ptType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptPostalCd = this.ptPostalCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
