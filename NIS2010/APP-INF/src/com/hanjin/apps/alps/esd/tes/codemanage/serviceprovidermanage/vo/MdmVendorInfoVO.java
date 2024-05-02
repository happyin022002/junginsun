/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MdmVendorInfoVO.java
*@FileTitle : MdmVendorInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class MdmVendorInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmVendorInfoVO> models = new ArrayList<MdmVendorInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String rgstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String genPayTermCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String payTermTpCd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String idaVndrEml = null;
	/* Column Info */
	private String idaSpclEcnZnDocDesc = null;
	/* Column Info */
	private String idaSteNm = null;
	/* Column Info */
	private String idaGstRgstNo = null;
	/* Column Info */
	private String idaVndrNm = null;
	/* Column Info */
	private String idaCntcPsonNm = null;
	/* Column Info */
	private String idaGstRgstStsCd = null;
	/* Column Info */
	private String idaGstRgstTpCd = null;
	/* Column Info */
	private String idaPanNo = null;
	/* Column Info */
	private String idaSpclEcnZnDocNo = null;
	/* Column Info */
	private String idaVndrSeq = null;
	/* Column Info */
	private String idaCoTypeCd = null;
	/* Column Info */
	private String idaAltnRcvrNm = null;
	/* Column Info */
	private String idaSteCd = null;
	/* Column Info */
	private String idaSpclEcnZnUtFlg = null;
	/* Column Info */
	private String zipCode = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MdmVendorInfoVO() {}

	public MdmVendorInfoVO(String ibflag, String pagerows, String vndrSeq, String vndrLglEngNm, String vndrCntCd, String engAddr, String locCd, String ofcCd, String phnNo, String faxNo, String vndrEml, String vndrAbbrNm, String rgstNo, String cntcPsonNm, String payTermTpCd, String genPayTermCd, String updUsrId, String steCd, String idaVndrEml, String idaSpclEcnZnDocDesc, String idaSteNm, String idaGstRgstNo, String idaVndrNm, String idaCntcPsonNm, String idaGstRgstStsCd, String idaGstRgstTpCd, String idaPanNo, String idaSpclEcnZnDocNo, String idaVndrSeq, String idaCoTypeCd, String idaAltnRcvrNm, String idaSteCd, String idaSpclEcnZnUtFlg, String zipCode) {
		this.ibflag = ibflag;
		this.vndrLglEngNm = vndrLglEngNm;
		this.vndrAbbrNm = vndrAbbrNm;
		this.phnNo = phnNo;
		this.updUsrId = updUsrId;
		this.vndrEml = vndrEml;
		this.cntcPsonNm = cntcPsonNm;
		this.rgstNo = rgstNo;
		this.pagerows = pagerows;
		this.genPayTermCd = genPayTermCd;
		this.ofcCd = ofcCd;
		this.vndrCntCd = vndrCntCd;
		this.locCd = locCd;
		this.steCd = steCd;
		this.vndrSeq = vndrSeq;
		this.payTermTpCd = payTermTpCd;
		this.faxNo = faxNo;
		this.engAddr = engAddr;
		this.idaVndrEml = idaVndrEml;
		this.idaSpclEcnZnDocDesc = idaSpclEcnZnDocDesc;
		this.idaSteNm = idaSteNm;
		this.idaGstRgstNo = idaGstRgstNo;
		this.idaVndrNm = idaVndrNm;
		this.idaCntcPsonNm = idaCntcPsonNm;
		this.idaGstRgstStsCd = idaGstRgstStsCd;
		this.idaGstRgstTpCd = idaGstRgstTpCd;
		this.idaPanNo = idaPanNo;
		this.idaSpclEcnZnDocNo = idaSpclEcnZnDocNo;
		this.idaVndrSeq = idaVndrSeq;
		this.idaCoTypeCd = idaCoTypeCd;
		this.idaAltnRcvrNm = idaAltnRcvrNm;
		this.idaSteCd = idaSteCd;
		this.idaSpclEcnZnUtFlg = idaSpclEcnZnUtFlg;
		this.zipCode = zipCode;
		
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gen_pay_term_cd", getGenPayTermCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pay_term_tp_cd", getPayTermTpCd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("ida_vndr_eml", getIdaVndrEml());
		this.hashColumns.put("ida_spcl_ecn_zn_doc_desc", getIdaSpclEcnZnDocDesc());
		this.hashColumns.put("ida_ste_nm", getIdaSteNm());
		this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
		this.hashColumns.put("ida_vndr_nm", getIdaVndrNm());
		this.hashColumns.put("ida_cntc_pson_nm", getIdaCntcPsonNm());
		this.hashColumns.put("ida_gst_rgst_sts_cd", getIdaGstRgstStsCd());
		this.hashColumns.put("ida_gst_rgst_tp_cd", getIdaGstRgstTpCd());
		this.hashColumns.put("ida_pan_no", getIdaPanNo());
		this.hashColumns.put("ida_spcl_ecn_zn_doc_no", getIdaSpclEcnZnDocNo());
		this.hashColumns.put("ida_vndr_seq", getIdaVndrSeq());
		this.hashColumns.put("ida_co_type_cd", getIdaCoTypeCd());
		this.hashColumns.put("ida_altn_rcvr_nm", getIdaAltnRcvrNm());
		this.hashColumns.put("ida_ste_cd", getIdaSteCd());
		this.hashColumns.put("ida_spcl_ecn_zn_ut_flg", getIdaSpclEcnZnUtFlg());
		this.hashColumns.put("zip_code", getZipCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gen_pay_term_cd", "genPayTermCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pay_term_tp_cd", "payTermTpCd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("eng_addr", "engAddr");	
		this.hashFields.put("ida_vndr_eml", "idaVndrEml");
		this.hashFields.put("ida_spcl_ecn_zn_doc_desc", "idaSpclEcnZnDocDesc");
		this.hashFields.put("ida_ste_nm", "idaSteNm");
		this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
		this.hashFields.put("ida_vndr_nm", "idaVndrNm");
		this.hashFields.put("ida_cntc_pson_nm", "idaCntcPsonNm");
		this.hashFields.put("ida_gst_rgst_sts_cd", "idaGstRgstStsCd");
		this.hashFields.put("ida_gst_rgst_tp_cd", "idaGstRgstTpCd");
		this.hashFields.put("ida_pan_no", "idaPanNo");
		this.hashFields.put("ida_spcl_ecn_zn_doc_no", "idaSpclEcnZnDocNo");
		this.hashFields.put("ida_vndr_seq", "idaVndrSeq");
		this.hashFields.put("ida_co_type_cd", "idaCoTypeCd");
		this.hashFields.put("ida_altn_rcvr_nm", "idaAltnRcvrNm");
		this.hashFields.put("ida_ste_cd", "idaSteCd");
		this.hashFields.put("ida_spcl_ecn_zn_ut_flg", "idaSpclEcnZnUtFlg");
		this.hashFields.put("zip_cd", "zipCode");
		return this.hashFields;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
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
	 * @return genPayTermCd
	 */
	public String getGenPayTermCd() {
		return this.genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return payTermTpCd
	 */
	public String getPayTermTpCd() {
		return this.payTermTpCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return idaVndrEml
	 */
	public String getIdaVndrEml() {
		return idaVndrEml;
	}
	
	/**
	 * Column Info
	 * @return idaSpclEcnZnDocDesc
	 */
	public String getIdaSpclEcnZnDocDesc() {
		return idaSpclEcnZnDocDesc;
	}
	
	/**
	 * Column Info
	 * @return idaSteNm
	 */
	public String getIdaSteNm() {
		return idaSteNm;
	}
	
	/**
	 * Column Info
	 * @return idaGstRgstNo
	 */
	public String getIdaGstRgstNo() {
		return idaGstRgstNo;
	}
	
	/**
	 * Column Info
	 * @return idaVndrNm
	 */
	public String getIdaVndrNm() {
		return idaVndrNm;
	}
	
	/**
	 * Column Info
	 * @return idaCntcPsonNm
	 */
	public String getIdaCntcPsonNm() {
		return idaCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return idaGstRgstStsCd
	 */
	public String getIdaGstRgstStsCd() {
		return idaGstRgstStsCd;
	}
	
	/**
	 * Column Info
	 * @return idaGstRgstTpCd
	 */
	public String getIdaGstRgstTpCd() {
		return idaGstRgstTpCd;
	}
	
	/**
	 * Column Info
	 * @return idaPanNo
	 */
	public String getIdaPanNo() {
		return idaPanNo;
	}
	
	/**
	 * Column Info
	 * @return idaSpclEcnZnDocNo
	 */
	public String getIdaSpclEcnZnDocNo() {
		return idaSpclEcnZnDocNo;
	}
	
	/**
	 * Column Info
	 * @return idaVndrSeq
	 */
	public String getIdaVndrSeq() {
		return idaVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return idaCoTypeCd
	 */
	public String getIdaCoTypeCd() {
		return idaCoTypeCd;
	}
	
	/**
	 * Column Info
	 * @return idaAltnRcvrNm
	 */
	public String getIdaAltnRcvrNm() {
		return idaAltnRcvrNm;
	}
	
	/**
	 * Column Info
	 * @return idaSteCd
	 */
	public String getIdaSteCd() {
		return idaSteCd;
	}
	
	/**
	 * Column Info
	 * @return idaSpclEcnZnUtFlg
	 */
	public String getIdaSpclEcnZnUtFlg() {
		return idaSpclEcnZnUtFlg;
	}
	
	
	/**
	 * Column Info
	 * @return zipCode
	 */
	public String getZipCode() {
		return zipCode;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
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
	 * @param genPayTermCd
	 */
	public void setGenPayTermCd(String genPayTermCd) {
		this.genPayTermCd = genPayTermCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param payTermTpCd
	 */
	public void setPayTermTpCd(String payTermTpCd) {
		this.payTermTpCd = payTermTpCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param idaVndrEml
	 */
	public void setIdaVndrEml(String idaVndrEml) {
		this.idaVndrEml = idaVndrEml;
	}
	/**
	 * Column Info
	 * @param idaSpclEcnZnDocDesc
	 */
	public void setIdaSpclEcnZnDocDesc(String idaSpclEcnZnDocDesc) {
		this.idaSpclEcnZnDocDesc = idaSpclEcnZnDocDesc;
	}
	/**
	 * Column Info
	 * @param idaSteNm
	 */
	public void setIdaSteNm(String idaSteNm) {
		this.idaSteNm = idaSteNm;
	}
	/**
	 * Column Info
	 * @param idaGstRgstNo
	 */
	public void setIdaGstRgstNo(String idaGstRgstNo) {
		this.idaGstRgstNo = idaGstRgstNo;
	}
	/**
	 * Column Info
	 * @param idaVndrNm
	 */
	public void setIdaVndrNm(String idaVndrNm) {
		this.idaVndrNm = idaVndrNm;
	}
	/**
	 * Column Info
	 * @param idaCntcPsonNm
	 */
	public void setIdaCntcPsonNm(String idaCntcPsonNm) {
		this.idaCntcPsonNm = idaCntcPsonNm;
	}
	/**
	 * Column Info
	 * @param idaGstRgstStsCd
	 */
	public void setIdaGstRgstStsCd(String idaGstRgstStsCd) {
		this.idaGstRgstStsCd = idaGstRgstStsCd;
	}
	/**
	 * Column Info
	 * @param idaGstRgstTpCd
	 */
	public void setIdaGstRgstTpCd(String idaGstRgstTpCd) {
		this.idaGstRgstTpCd = idaGstRgstTpCd;
	}
	/**
	 * Column Info
	 * @param idaPanNo
	 */
	public void setIdaPanNo(String idaPanNo) {
		this.idaPanNo = idaPanNo;
	}
	/**
	 * Column Info
	 * @param idaSpclEcnZnDocNo
	 */
	public void setIdaSpclEcnZnDocNo(String idaSpclEcnZnDocNo) {
		this.idaSpclEcnZnDocNo = idaSpclEcnZnDocNo;
	}
	/**
	 * Column Info
	 * @param idaVndrSeq
	 */
	public void setIdaVndrSeq(String idaVndrSeq) {
		this.idaVndrSeq = idaVndrSeq;
	}
	/**
	 * Column Info
	 * @param idaCoTypeCd
	 */
	public void setIdaCoTypeCd(String idaCoTypeCd) {
		this.idaCoTypeCd = idaCoTypeCd;
	}
	/**
	 * Column Info
	 * @param idaAltnRcvrNm
	 */
	public void setIdaAltnRcvrNm(String idaAltnRcvrNm) {
		this.idaAltnRcvrNm = idaAltnRcvrNm;
	}
	/**
	 * Column Info
	 * @param idaSteCd
	 */
	public void setIdaSteCd(String idaSteCd) {
		this.idaSteCd = idaSteCd;
	}
	/**
	 * Column Info
	 * @param idaSpclEcnZnUtFlg
	 */
	public void setIdaSpclEcnZnUtFlg(String idaSpclEcnZnUtFlg) {
		this.idaSpclEcnZnUtFlg = idaSpclEcnZnUtFlg;
	}
	
	/**
	 * Column Info
	 * @return zipCode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setRgstNo(JSPUtil.getParameter(request, prefix + "rgst_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setGenPayTermCd(JSPUtil.getParameter(request, prefix + "gen_pay_term_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPayTermTpCd(JSPUtil.getParameter(request, prefix + "pay_term_tp_cd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setEngAddr(JSPUtil.getParameter(request, prefix + "eng_addr", ""));
		setIdaVndrEml(JSPUtil.getParameter(request, prefix + "ida_vndr_eml", ""));
		setIdaSpclEcnZnDocDesc(JSPUtil.getParameter(request, prefix + "ida_spcl_ecn_zn_doc_desc", ""));
		setIdaSteNm(JSPUtil.getParameter(request, prefix + "ida_ste_nm", ""));
		setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
		setIdaVndrNm(JSPUtil.getParameter(request, prefix + "ida_vndr_nm", ""));
		setIdaCntcPsonNm(JSPUtil.getParameter(request, prefix + "ida_cntc_pson_nm", ""));
		setIdaGstRgstStsCd(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_sts_cd", ""));
		setIdaGstRgstTpCd(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_tp_cd", ""));
		setIdaPanNo(JSPUtil.getParameter(request, prefix + "ida_pan_no", ""));
		setIdaSpclEcnZnDocNo(JSPUtil.getParameter(request, prefix + "ida_spcl_ecn_zn_doc_no", ""));
		setIdaVndrSeq(JSPUtil.getParameter(request, prefix + "ida_vndr_seq", ""));
		setIdaCoTypeCd(JSPUtil.getParameter(request, prefix + "ida_co_type_cd", ""));
		setIdaAltnRcvrNm(JSPUtil.getParameter(request, prefix + "ida_altn_rcvr_nm", ""));
		setIdaSteNm(JSPUtil.getParameter(request, prefix + "ida_ste_cd", ""));
		setIdaSteCd(JSPUtil.getParameter(request, prefix + "ida_spcl_ecn_zn_ut_flg", ""));
		setZipCode(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmVendorInfoVO[]
	 */
	public MdmVendorInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmVendorInfoVO[]
	 */
	public MdmVendorInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmVendorInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] genPayTermCd = (JSPUtil.getParameter(request, prefix	+ "gen_pay_term_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] payTermTpCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_tp_cd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] idaVndrEml = (JSPUtil.getParameter(request, prefix	+ "ida_vndr_eml", length));
			String[] idaSpclEcnZnDocDesc = (JSPUtil.getParameter(request, prefix	+ "ida_spcl_ecn_zn_doc_desc", length));
			String[] idaSteNm = (JSPUtil.getParameter(request, prefix	+ "ida_ste_nm", length));
			String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix	+ "ida_gst_rgst_no", length));
			String[] idaVndrNm = (JSPUtil.getParameter(request, prefix	+ "ida_vndr_nm", length));
			String[] idaCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "ida_cntc_pson_nm", length));
			String[] idaGstRgstStsCd = (JSPUtil.getParameter(request, prefix	+ "ida_gst_rgst_sts_cd", length));
			String[] idaGstRgstTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_gst_rgst_tp_cd", length));
			String[] idaPanNo = (JSPUtil.getParameter(request, prefix	+ "ida_pan_no", length));
			String[] idaSpclEcnZnDocNo = (JSPUtil.getParameter(request, prefix	+ "ida_spcl_ecn_zn_doc_no", length));
			String[] idaVndrSeq = (JSPUtil.getParameter(request, prefix	+ "ida_vndr_seq", length));
			String[] idaCoTypeCd = (JSPUtil.getParameter(request, prefix	+ "ida_co_type_cd", length));
			String[] idaAltnRcvrNm = (JSPUtil.getParameter(request, prefix	+ "ida_altn_rcvr_nm", length));
			String[] idaSteCd = (JSPUtil.getParameter(request, prefix	+ "ida_ste_cd", length));
			String[] idaSpclEcnZnUtFlg = (JSPUtil.getParameter(request, prefix	+ "ida_spcl_ecn_zn_ut_flg", length));
			String[] zipCode = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmVendorInfoVO();
			
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);		
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);		
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (genPayTermCd[i] != null)
					model.setGenPayTermCd(genPayTermCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (payTermTpCd[i] != null)
					model.setPayTermTpCd(payTermTpCd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (idaVndrEml[i] != null)
					model.setIdaVndrEml(idaVndrEml[i]);
				if (idaSpclEcnZnDocDesc[i] != null)
					model.setIdaSpclEcnZnDocDesc(idaSpclEcnZnDocDesc[i]);
				if (idaSteNm[i] != null)
					model.setIdaSteNm(idaSteNm[i]);
				if (idaGstRgstNo[i] != null)
					model.setIdaGstRgstNo(idaGstRgstNo[i]);
				if (idaVndrNm[i] != null)
					model.setIdaVndrNm(idaVndrNm[i]);
				if (idaCntcPsonNm[i] != null)
					model.setIdaCntcPsonNm(idaCntcPsonNm[i]);
				if (idaGstRgstStsCd[i] != null)
					model.setIdaGstRgstStsCd(idaGstRgstStsCd[i]);
				if (idaGstRgstTpCd[i] != null)
					model.setIdaGstRgstTpCd(idaGstRgstTpCd[i]);
				if (idaPanNo[i] != null)
					model.setIdaPanNo(idaPanNo[i]);
				if (idaSpclEcnZnDocNo[i] != null)
					model.setIdaSpclEcnZnDocNo(idaSpclEcnZnDocNo[i]);
				if (idaVndrSeq[i] != null)
					model.setIdaVndrSeq(idaVndrSeq[i]);
				if (idaCoTypeCd[i] != null)
					model.setIdaCoTypeCd(idaCoTypeCd[i]);
				if (idaAltnRcvrNm[i] != null)
					model.setIdaAltnRcvrNm(idaAltnRcvrNm[i]);
				if (idaSteCd[i] != null)
					model.setIdaSteCd(idaSteCd[i]);
				if (idaSpclEcnZnUtFlg[i] != null)
					model.setIdaSpclEcnZnUtFlg(idaSpclEcnZnUtFlg[i]);
				if (zipCode[i] != null)
					model.setZipCode(zipCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmVendorInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmVendorInfoVO[]
	 */
	public MdmVendorInfoVO[] getMdmVendorInfoVOs(){
		MdmVendorInfoVO[] vos = (MdmVendorInfoVO[])models.toArray(new MdmVendorInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genPayTermCd = this.genPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermTpCd = this.payTermTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaVndrEml = this.idaVndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSpclEcnZnDocDesc = this.idaSpclEcnZnDocDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSteNm = this.idaSteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRgstNo = this.idaGstRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaVndrNm = this.idaVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCntcPsonNm = this.idaCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRgstStsCd = this.idaGstRgstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRgstTpCd = this.idaGstRgstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaPanNo = this.idaPanNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSpclEcnZnDocNo = this.idaSpclEcnZnDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaVndrSeq = this.idaVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCoTypeCd = this.idaCoTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaAltnRcvrNm = this.idaAltnRcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSteCd = this.idaSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSpclEcnZnUtFlg = this.idaSpclEcnZnUtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCode = this.zipCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
