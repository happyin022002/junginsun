/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartyVO.java
*@FileTitle : PartyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.03 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PartyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PartyVO> models = new ArrayList<PartyVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ptyNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String zipCdCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String prntClmPtyNo = null;
	/* Column Info */
	private String clmPtyAbbrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String clmPtyClrCd = null;
	/* Column Info */
	private String clmPtyClrNo = null;
	/* Column Info */
	private String ptyAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ptyRmk = null;
	/* Column Info */
	private String prntClmPtyAbbrNm = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ptyEml = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String intlPhnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PartyVO() {}

	public PartyVO(String ibflag, String pagerows, String clmPtyNo, String clmPtyAbbrNm, String prntClmPtyNo, String prntClmPtyAbbrNm, String ptyNm, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String ptyEml, String ptyAddr, String ptyRmk, String locCd, String zipCdCtnt, String cntCd, String custSeq, String vndrSeq, String clmPtyClrNo, String clmPtyClrCd, String deltFlg, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String clmAreaCd, String custNm) {
		this.custNm = custNm;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.ptyNm = ptyNm;
		this.pagerows = pagerows;
		this.zipCdCtnt = zipCdCtnt;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creOfcCd = creOfcCd;
		this.cntCd = cntCd;
		this.intlFaxNo = intlFaxNo;
		this.prntClmPtyNo = prntClmPtyNo;
		this.clmPtyAbbrNm = clmPtyAbbrNm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.phnNo = phnNo;
		this.clmPtyClrCd = clmPtyClrCd;
		this.clmPtyClrNo = clmPtyClrNo;
		this.ptyAddr = ptyAddr;
		this.custSeq = custSeq;
		this.ptyRmk = ptyRmk;
		this.prntClmPtyAbbrNm = prntClmPtyAbbrNm;
		this.clmPtyNo = clmPtyNo;
		this.creUsrId = creUsrId;
		this.ptyEml = ptyEml;
		this.vndrSeq = vndrSeq;
		this.faxNo = faxNo;
		this.clmAreaCd = clmAreaCd;
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("zip_cd_ctnt", getZipCdCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("prnt_clm_pty_no", getPrntClmPtyNo());
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("clm_pty_clr_cd", getClmPtyClrCd());
		this.hashColumns.put("clm_pty_clr_no", getClmPtyClrNo());
		this.hashColumns.put("pty_addr", getPtyAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pty_rmk", getPtyRmk());
		this.hashColumns.put("prnt_clm_pty_abbr_nm", getPrntClmPtyAbbrNm());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pty_eml", getPtyEml());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("zip_cd_ctnt", "zipCdCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("prnt_clm_pty_no", "prntClmPtyNo");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("clm_pty_clr_cd", "clmPtyClrCd");
		this.hashFields.put("clm_pty_clr_no", "clmPtyClrNo");
		this.hashFields.put("pty_addr", "ptyAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pty_rmk", "ptyRmk");
		this.hashFields.put("prnt_clm_pty_abbr_nm", "prntClmPtyAbbrNm");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pty_eml", "ptyEml");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
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
	 * @return zipCdCtnt
	 */
	public String getZipCdCtnt() {
		return this.zipCdCtnt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @return prntClmPtyNo
	 */
	public String getPrntClmPtyNo() {
		return this.prntClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm
	 */
	public String getClmPtyAbbrNm() {
		return this.clmPtyAbbrNm;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return clmPtyClrCd
	 */
	public String getClmPtyClrCd() {
		return this.clmPtyClrCd;
	}
	
	/**
	 * Column Info
	 * @return clmPtyClrNo
	 */
	public String getClmPtyClrNo() {
		return this.clmPtyClrNo;
	}
	
	/**
	 * Column Info
	 * @return ptyAddr
	 */
	public String getPtyAddr() {
		return this.ptyAddr;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return ptyRmk
	 */
	public String getPtyRmk() {
		return this.ptyRmk;
	}
	
	/**
	 * Column Info
	 * @return prntClmPtyAbbrNm
	 */
	public String getPrntClmPtyAbbrNm() {
		return this.prntClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ptyEml
	 */
	public String getPtyEml() {
		return this.ptyEml;
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
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
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
	 * @param zipCdCtnt
	 */
	public void setZipCdCtnt(String zipCdCtnt) {
		this.zipCdCtnt = zipCdCtnt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * Column Info
	 * @param prntClmPtyNo
	 */
	public void setPrntClmPtyNo(String prntClmPtyNo) {
		this.prntClmPtyNo = prntClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm
	 */
	public void setClmPtyAbbrNm(String clmPtyAbbrNm) {
		this.clmPtyAbbrNm = clmPtyAbbrNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param clmPtyClrCd
	 */
	public void setClmPtyClrCd(String clmPtyClrCd) {
		this.clmPtyClrCd = clmPtyClrCd;
	}
	
	/**
	 * Column Info
	 * @param clmPtyClrNo
	 */
	public void setClmPtyClrNo(String clmPtyClrNo) {
		this.clmPtyClrNo = clmPtyClrNo;
	}
	
	/**
	 * Column Info
	 * @param ptyAddr
	 */
	public void setPtyAddr(String ptyAddr) {
		this.ptyAddr = ptyAddr;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param ptyRmk
	 */
	public void setPtyRmk(String ptyRmk) {
		this.ptyRmk = ptyRmk;
	}
	
	/**
	 * Column Info
	 * @param prntClmPtyAbbrNm
	 */
	public void setPrntClmPtyAbbrNm(String prntClmPtyAbbrNm) {
		this.prntClmPtyAbbrNm = prntClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ptyEml
	 */
	public void setPtyEml(String ptyEml) {
		this.ptyEml = ptyEml;
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
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPtyNm(JSPUtil.getParameter(request, "pty_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setZipCdCtnt(JSPUtil.getParameter(request, "zip_cd_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, "intl_fax_no", ""));
		setPrntClmPtyNo(JSPUtil.getParameter(request, "prnt_clm_pty_no", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request, "clm_pty_abbr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setClmPtyClrCd(JSPUtil.getParameter(request, "clm_pty_clr_cd", ""));
		setClmPtyClrNo(JSPUtil.getParameter(request, "clm_pty_clr_no", ""));
		setPtyAddr(JSPUtil.getParameter(request, "pty_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPtyRmk(JSPUtil.getParameter(request, "pty_rmk", ""));
		setPrntClmPtyAbbrNm(JSPUtil.getParameter(request, "prnt_clm_pty_abbr_nm", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPtyEml(JSPUtil.getParameter(request, "pty_eml", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setClmAreaCd(JSPUtil.getParameter(request, "clm_area_cd", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, "intl_phn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PartyVO[]
	 */
	public PartyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PartyVO[]
	 */
	public PartyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PartyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] zipCdCtnt = (JSPUtil.getParameter(request, prefix	+ "zip_cd_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] prntClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "prnt_clm_pty_no", length));
			String[] clmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] clmPtyClrCd = (JSPUtil.getParameter(request, prefix	+ "clm_pty_clr_cd", length));
			String[] clmPtyClrNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_clr_no", length));
			String[] ptyAddr = (JSPUtil.getParameter(request, prefix	+ "pty_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ptyRmk = (JSPUtil.getParameter(request, prefix	+ "pty_rmk", length));
			String[] prntClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "prnt_clm_pty_abbr_nm", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ptyEml = (JSPUtil.getParameter(request, prefix	+ "pty_eml", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PartyVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (zipCdCtnt[i] != null)
					model.setZipCdCtnt(zipCdCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (prntClmPtyNo[i] != null)
					model.setPrntClmPtyNo(prntClmPtyNo[i]);
				if (clmPtyAbbrNm[i] != null)
					model.setClmPtyAbbrNm(clmPtyAbbrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (clmPtyClrCd[i] != null)
					model.setClmPtyClrCd(clmPtyClrCd[i]);
				if (clmPtyClrNo[i] != null)
					model.setClmPtyClrNo(clmPtyClrNo[i]);
				if (ptyAddr[i] != null)
					model.setPtyAddr(ptyAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ptyRmk[i] != null)
					model.setPtyRmk(ptyRmk[i]);
				if (prntClmPtyAbbrNm[i] != null)
					model.setPrntClmPtyAbbrNm(prntClmPtyAbbrNm[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ptyEml[i] != null)
					model.setPtyEml(ptyEml[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPartyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PartyVO[]
	 */
	public PartyVO[] getPartyVOs(){
		PartyVO[] vos = (PartyVO[])models.toArray(new PartyVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCdCtnt = this.zipCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntClmPtyNo = this.prntClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm = this.clmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyClrCd = this.clmPtyClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyClrNo = this.clmPtyClrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyAddr = this.ptyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyRmk = this.ptyRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntClmPtyAbbrNm = this.prntClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyEml = this.ptyEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
