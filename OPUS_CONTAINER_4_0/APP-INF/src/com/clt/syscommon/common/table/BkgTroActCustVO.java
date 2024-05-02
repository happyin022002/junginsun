/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgTroActCustVO.java
*@FileTitle : BkgTroActCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.01 박성호 
* 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTroActCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgTroActCustVO> models = new ArrayList<BkgTroActCustVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dorZipId = null;
	/* Column Info */
	private String cntcEml = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cntcPhnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String troActCustKndCd = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String troVndrSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntcFaxNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String troActRepSeq = null;
	/* Column Info */
	private String cntcMphnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String actShprNm = null;
	/* Column Info */
	private String actShprAddr = null;
	/* Column Info */
	private String actShprAddr1 = null;
	/* Column Info */
	private String actShprAddr2 = null;
	/* Column Info */
	private String actShprAddr3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgTroActCustVO() {}
/**
 * 
 * @param ibflag
 * @param pagerows
 * @param troActCustKndCd
 * @param troVndrSeq
 * @param ofcCd
 * @param troActRepSeq
 * @param cntCd
 * @param custSeq
 * @param vndrSeq
 * @param locCd
 * @param znCd
 * @param actShprNm
 * @param actShprAddr
 * @param cntcPsonNm
 * @param cntcPhnNo
 * @param cntcFaxNo
 * @param cntcMphnNo
 * @param cntcEml
 * @param dorZipId
 * @param diffRmk
 * @param creUsrId
 * @param creDt
 * @param updUsrId
 * @param updDt
 * @param actShprAddr1
 * @param actShprAddr2
 * @param actShprAddr3
 */
	public BkgTroActCustVO(String ibflag, String pagerows, String troActCustKndCd, String troVndrSeq, String ofcCd, String troActRepSeq, String cntCd, String custSeq, String vndrSeq, String locCd, String znCd, String actShprNm, String actShprAddr, String cntcPsonNm, String cntcPhnNo, String cntcFaxNo, String cntcMphnNo, String cntcEml, String dorZipId, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String actShprAddr1, String actShprAddr2, String actShprAddr3) {
		this.updDt = updDt;
		this.znCd = znCd;
		this.creDt = creDt;
		this.dorZipId = dorZipId;
		this.cntcEml = cntcEml;
		this.custSeq = custSeq;
		this.cntcPhnNo = cntcPhnNo;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.diffRmk = diffRmk;
		this.troActCustKndCd = troActCustKndCd;
		this.cntcPsonNm = cntcPsonNm;
		this.troVndrSeq = troVndrSeq;
		this.vndrSeq = vndrSeq;
		this.cntcFaxNo = cntcFaxNo;
		this.cntCd = cntCd;
		this.troActRepSeq = troActRepSeq;
		this.cntcMphnNo = cntcMphnNo;
		this.updUsrId = updUsrId;
		this.actShprNm = actShprNm;
		this.actShprAddr = actShprAddr;
		this.actShprAddr1 = actShprAddr1;
		this.actShprAddr2 = actShprAddr2;
		this.actShprAddr3 = actShprAddr3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dor_zip_id", getDorZipId());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("tro_act_cust_knd_cd", getTroActCustKndCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("tro_vndr_seq", getTroVndrSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntc_fax_no", getCntcFaxNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("tro_act_rep_seq", getTroActRepSeq());
		this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("act_shpr_nm", getActShprNm());
		this.hashColumns.put("act_shpr_addr", getActShprAddr());
		this.hashColumns.put("act_shpr_addr1", getActShprAddr1());
		this.hashColumns.put("act_shpr_addr2", getActShprAddr2());
		this.hashColumns.put("act_shpr_addr3", getActShprAddr3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dor_zip_id", "dorZipId");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("tro_act_cust_knd_cd", "troActCustKndCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("tro_vndr_seq", "troVndrSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntc_fax_no", "cntcFaxNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("tro_act_rep_seq", "troActRepSeq");
		this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("act_shpr_addr", "actShprAddr");
		this.hashFields.put("act_shpr_addr1", "actShprAddr1");
		this.hashFields.put("act_shpr_addr2", "actShprAddr2");
		this.hashFields.put("act_shpr_addr3", "actShprAddr3");
		return this.hashFields;
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
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
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
	 * @return dorZipId
	 */
	public String getDorZipId() {
		return this.dorZipId;
	}
	
	/**
	 * Column Info
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
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
	 * @return cntcPhnNo
	 */
	public String getCntcPhnNo() {
		return this.cntcPhnNo;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return troActCustKndCd
	 */
	public String getTroActCustKndCd() {
		return this.troActCustKndCd;
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
	 * @return troVndrSeq
	 */
	public String getTroVndrSeq() {
		return this.troVndrSeq;
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
	 * @return cntcFaxNo
	 */
	public String getCntcFaxNo() {
		return this.cntcFaxNo;
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
	 * @return troActRepSeq
	 */
	public String getTroActRepSeq() {
		return this.troActRepSeq;
	}
	
	/**
	 * Column Info
	 * @return cntcMphnNo
	 */
	public String getCntcMphnNo() {
		return this.cntcMphnNo;
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
	 * @return actShprNm
	 */
	public String getActShprNm() {
		return this.actShprNm;
	}
	
	/**
	 * Column Info
	 * @return actShprAddr
	 */
	public String getActShprAddr() {
		return this.actShprAddr;
	}
	
	/**
	 * Column Info
	 * @return actShprAddr1
	 */
	public String getActShprAddr1() {
		return this.actShprAddr1;
	}
	
	/**
	 * Column Info
	 * @return actShprAddr2
	 */
	public String getActShprAddr2() {
		return this.actShprAddr2;
	}
	
	/**
	 * Column Info
	 * @return actShprAddr3
	 */
	public String getActShprAddr3() {
		return this.actShprAddr3;
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
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
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
	 * @param dorZipId
	 */
	public void setDorZipId(String dorZipId) {
		this.dorZipId = dorZipId;
	}
	
	/**
	 * Column Info
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
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
	 * @param cntcPhnNo
	 */
	public void setCntcPhnNo(String cntcPhnNo) {
		this.cntcPhnNo = cntcPhnNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param troActCustKndCd
	 */
	public void setTroActCustKndCd(String troActCustKndCd) {
		this.troActCustKndCd = troActCustKndCd;
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
	 * @param troVndrSeq
	 */
	public void setTroVndrSeq(String troVndrSeq) {
		this.troVndrSeq = troVndrSeq;
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
	 * @param cntcFaxNo
	 */
	public void setCntcFaxNo(String cntcFaxNo) {
		this.cntcFaxNo = cntcFaxNo;
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
	 * @param troActRepSeq
	 */
	public void setTroActRepSeq(String troActRepSeq) {
		this.troActRepSeq = troActRepSeq;
	}
	
	/**
	 * Column Info
	 * @param cntcMphnNo
	 */
	public void setCntcMphnNo(String cntcMphnNo) {
		this.cntcMphnNo = cntcMphnNo;
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
	 * @param actShprNm
	 */
	public void setActShprNm(String actShprNm) {
		this.actShprNm = actShprNm;
	}
	
	/**
	 * Column Info
	 * @param actShprAddr
	 */
	public void setActShprAddr(String actShprAddr) {
		this.actShprAddr = actShprAddr;
	}
	
	/**
	 * Column Info
	 * @param actShprAddr1
	 */
	public void setActShprAddr1(String actShprAddr1) {
		this.actShprAddr1 = actShprAddr1;
	}
	
	/**
	 * Column Info
	 * @param actShprAddr2
	 */
	public void setActShprAddr2(String actShprAddr2) {
		this.actShprAddr2 = actShprAddr2;
	}
	
	/**
	 * Column Info
	 * @param actShprAddr3
	 */
	public void setActShprAddr3(String actShprAddr3) {
		this.actShprAddr3 = actShprAddr3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setZnCd(JSPUtil.getParameter(request, "zn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDorZipId(JSPUtil.getParameter(request, "dor_zip_id", ""));
		setCntcEml(JSPUtil.getParameter(request, "cntc_eml", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCntcPhnNo(JSPUtil.getParameter(request, "cntc_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setTroActCustKndCd(JSPUtil.getParameter(request, "tro_act_cust_knd_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setTroVndrSeq(JSPUtil.getParameter(request, "tro_vndr_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntcFaxNo(JSPUtil.getParameter(request, "cntc_fax_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setTroActRepSeq(JSPUtil.getParameter(request, "tro_act_rep_seq", ""));
		setCntcMphnNo(JSPUtil.getParameter(request, "cntc_mphn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setActShprNm(JSPUtil.getParameter(request, "act_shpr_nm", ""));
		setActShprAddr(JSPUtil.getParameter(request, "act_shpr_addr", ""));
		setActShprAddr1(JSPUtil.getParameter(request, "act_shpr_addr1", ""));
		setActShprAddr2(JSPUtil.getParameter(request, "act_shpr_addr2", ""));
		setActShprAddr3(JSPUtil.getParameter(request, "act_shpr_addr3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTroActCustVO[]
	 */
	public BkgTroActCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgTroActCustVO[]
	 */
	public BkgTroActCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTroActCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] dorZipId = (JSPUtil.getParameter(request, prefix	+ "dor_zip_id".trim(), length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_phn_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] troActCustKndCd = (JSPUtil.getParameter(request, prefix	+ "tro_act_cust_knd_cd".trim(), length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm".trim(), length));
			String[] troVndrSeq = (JSPUtil.getParameter(request, prefix	+ "tro_vndr_seq".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] cntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_fax_no".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] troActRepSeq = (JSPUtil.getParameter(request, prefix	+ "tro_act_rep_seq".trim(), length));
			String[] cntcMphnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_mphn_no".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] actShprNm = (JSPUtil.getParameter(request, prefix	+ "act_shpr_nm".trim(), length));
			String[] actShprAddr = (JSPUtil.getParameter(request, prefix	+ "act_shpr_addr".trim(), length));
			String[] actShprAddr1 = (JSPUtil.getParameter(request, prefix	+ "act_shpr_addr1".trim(), length));
			String[] actShprAddr2 = (JSPUtil.getParameter(request, prefix	+ "act_shpr_addr2".trim(), length));
			String[] actShprAddr3 = (JSPUtil.getParameter(request, prefix	+ "act_shpr_addr3".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgTroActCustVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dorZipId[i] != null)
					model.setDorZipId(dorZipId[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cntcPhnNo[i] != null)
					model.setCntcPhnNo(cntcPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (troActCustKndCd[i] != null)
					model.setTroActCustKndCd(troActCustKndCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (troVndrSeq[i] != null)
					model.setTroVndrSeq(troVndrSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntcFaxNo[i] != null)
					model.setCntcFaxNo(cntcFaxNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (troActRepSeq[i] != null)
					model.setTroActRepSeq(troActRepSeq[i]);
				if (cntcMphnNo[i] != null)
					model.setCntcMphnNo(cntcMphnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (actShprNm[i] != null)
					model.setActShprNm(actShprNm[i]);
				if (actShprAddr[i] != null)
					model.setActShprAddr(actShprAddr[i]);
				if (actShprAddr1[i] != null)
					model.setActShprAddr1(actShprAddr1[i]);
				if (actShprAddr2[i] != null)
					model.setActShprAddr2(actShprAddr2[i]);
				if (actShprAddr3[i] != null)
					model.setActShprAddr3(actShprAddr3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTroActCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTroActCustVO[]
	 */
	public BkgTroActCustVO[] getBkgTroActCustVOs(){
		BkgTroActCustVO[] vos = (BkgTroActCustVO[])models.toArray(new BkgTroActCustVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorZipId = this.dorZipId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo = this.cntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troActCustKndCd = this.troActCustKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troVndrSeq = this.troVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcFaxNo = this.cntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troActRepSeq = this.troActRepSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcMphnNo = this.cntcMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm = this.actShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr = this.actShprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr1= this.actShprAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr2 = this.actShprAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr3 = this.actShprAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
