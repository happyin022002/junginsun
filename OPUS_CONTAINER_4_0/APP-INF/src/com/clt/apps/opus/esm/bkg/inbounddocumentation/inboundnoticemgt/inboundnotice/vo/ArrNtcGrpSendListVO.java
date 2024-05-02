/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcGrpSendListVO.java
*@FileTitle : ArrNtcGrpSendListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class ArrNtcGrpSendListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcGrpSendListVO> models = new ArrayList<ArrNtcGrpSendListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String vpsEtaDtEnd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String rvisFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String vpsEtaDtStart = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String knt = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String sNo = null;
	/* Column Info */
	private String bkgCustTpCdOdr = null;
	/* Column Info */
	private String a = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String schTp = null;
	/* Column Info */
	private String cNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String address = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String importantNotice = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcGrpSendListVO() {}

	public ArrNtcGrpSendListVO(String ibflag, String pagerows, String a, String custCd, String scNo, String custCntCd, String custSeq, String gubun, String custNm, String schTp, String vpsEtaDtStart, String vpsEtaDtEnd, String podCd, String custRefNo, String sNo, String cNo, String blNo, String knt, String cstmsDesc, String etaDt, String vvd, String polCd, String delCd, String address, String importantNotice, String vslCd, String skdVoyNo, String skdDirCd, String bkgNo, String bkgCustTpCd, String bkgCustTpCdOdr, String rvisFlg, String tsFlg) {
		this.vslCd = vslCd;
		this.gubun = gubun;
		this.custNm = custNm;
		this.vpsEtaDtEnd = vpsEtaDtEnd;
		this.etaDt = etaDt;
		this.rvisFlg = rvisFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.tsFlg = tsFlg;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.scNo = scNo;
		this.cstmsDesc = cstmsDesc;
		this.vpsEtaDtStart = vpsEtaDtStart;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.knt = knt;
		this.custRefNo = custRefNo;
		this.sNo = sNo;
		this.bkgCustTpCdOdr = bkgCustTpCdOdr;
		this.a = a;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.schTp = schTp;
		this.cNo = cNo;
		this.bkgNo = bkgNo;
		this.address = address;
		this.custCd = custCd;
		this.importantNotice = importantNotice;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("vps_eta_dt_end", getVpsEtaDtEnd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("rvis_flg", getRvisFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("vps_eta_dt_start", getVpsEtaDtStart());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("knt", getKnt());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("s_no", getSNo());
		this.hashColumns.put("bkg_cust_tp_cd_odr", getBkgCustTpCdOdr());
		this.hashColumns.put("a", getA());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sch_tp", getSchTp());
		this.hashColumns.put("c_no", getCNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("address", getAddress());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("important_notice", getImportantNotice());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("vps_eta_dt_end", "vpsEtaDtEnd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("rvis_flg", "rvisFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("vps_eta_dt_start", "vpsEtaDtStart");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("knt", "knt");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("s_no", "sNo");
		this.hashFields.put("bkg_cust_tp_cd_odr", "bkgCustTpCdOdr");
		this.hashFields.put("a", "a");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sch_tp", "schTp");
		this.hashFields.put("c_no", "cNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("address", "address");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("important_notice", "importantNotice");
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
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
	 * @return vpsEtaDtEnd
	 */
	public String getVpsEtaDtEnd() {
		return this.vpsEtaDtEnd;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return rvisFlg
	 */
	public String getRvisFlg() {
		return this.rvisFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtStart
	 */
	public String getVpsEtaDtStart() {
		return this.vpsEtaDtStart;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return knt
	 */
	public String getKnt() {
		return this.knt;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return sNo
	 */
	public String getSNo() {
		return this.sNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCdOdr
	 */
	public String getBkgCustTpCdOdr() {
		return this.bkgCustTpCdOdr;
	}
	
	/**
	 * Column Info
	 * @return a
	 */
	public String getA() {
		return this.a;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return schTp
	 */
	public String getSchTp() {
		return this.schTp;
	}
	
	/**
	 * Column Info
	 * @return cNo
	 */
	public String getCNo() {
		return this.cNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return importantNotice
	 */
	public String getImportantNotice() {
		return this.importantNotice;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
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
	 * @param vpsEtaDtEnd
	 */
	public void setVpsEtaDtEnd(String vpsEtaDtEnd) {
		this.vpsEtaDtEnd = vpsEtaDtEnd;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param rvisFlg
	 */
	public void setRvisFlg(String rvisFlg) {
		this.rvisFlg = rvisFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtStart
	 */
	public void setVpsEtaDtStart(String vpsEtaDtStart) {
		this.vpsEtaDtStart = vpsEtaDtStart;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param knt
	 */
	public void setKnt(String knt) {
		this.knt = knt;
	}
	
	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param sNo
	 */
	public void setSNo(String sNo) {
		this.sNo = sNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCdOdr
	 */
	public void setBkgCustTpCdOdr(String bkgCustTpCdOdr) {
		this.bkgCustTpCdOdr = bkgCustTpCdOdr;
	}
	
	/**
	 * Column Info
	 * @param a
	 */
	public void setA(String a) {
		this.a = a;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param schTp
	 */
	public void setSchTp(String schTp) {
		this.schTp = schTp;
	}
	
	/**
	 * Column Info
	 * @param cNo
	 */
	public void setCNo(String cNo) {
		this.cNo = cNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param importantNotice
	 */
	public void setImportantNotice(String importantNotice) {
		this.importantNotice = importantNotice;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setVpsEtaDtEnd(JSPUtil.getParameter(request, "vps_eta_dt_end", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setRvisFlg(JSPUtil.getParameter(request, "rvis_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTsFlg(JSPUtil.getParameter(request, "ts_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setVpsEtaDtStart(JSPUtil.getParameter(request, "vps_eta_dt_start", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setKnt(JSPUtil.getParameter(request, "knt", ""));
		setCustRefNo(JSPUtil.getParameter(request, "cust_ref_no", ""));
		setSNo(JSPUtil.getParameter(request, "s_no", ""));
		setBkgCustTpCdOdr(JSPUtil.getParameter(request, "bkg_cust_tp_cd_odr", ""));
		setA(JSPUtil.getParameter(request, "a", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSchTp(JSPUtil.getParameter(request, "sch_tp", ""));
		setCNo(JSPUtil.getParameter(request, "c_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setAddress(JSPUtil.getParameter(request, "address", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setImportantNotice(JSPUtil.getParameter(request, "important_notice", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcGrpSendListVO[]
	 */
	public ArrNtcGrpSendListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcGrpSendListVO[]
	 */
	public ArrNtcGrpSendListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcGrpSendListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] vpsEtaDtEnd = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_end", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] rvisFlg = (JSPUtil.getParameter(request, prefix	+ "rvis_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] vpsEtaDtStart = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_start", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] knt = (JSPUtil.getParameter(request, prefix	+ "knt", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] sNo = (JSPUtil.getParameter(request, prefix	+ "s_no", length));
			String[] bkgCustTpCdOdr = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd_odr", length));
			String[] a = (JSPUtil.getParameter(request, prefix	+ "a", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] schTp = (JSPUtil.getParameter(request, prefix	+ "sch_tp", length));
			String[] cNo = (JSPUtil.getParameter(request, prefix	+ "c_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] address = (JSPUtil.getParameter(request, prefix	+ "address", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] importantNotice = (JSPUtil.getParameter(request, prefix	+ "important_notice", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcGrpSendListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (vpsEtaDtEnd[i] != null)
					model.setVpsEtaDtEnd(vpsEtaDtEnd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (rvisFlg[i] != null)
					model.setRvisFlg(rvisFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (vpsEtaDtStart[i] != null)
					model.setVpsEtaDtStart(vpsEtaDtStart[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (knt[i] != null)
					model.setKnt(knt[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (sNo[i] != null)
					model.setSNo(sNo[i]);
				if (bkgCustTpCdOdr[i] != null)
					model.setBkgCustTpCdOdr(bkgCustTpCdOdr[i]);
				if (a[i] != null)
					model.setA(a[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (schTp[i] != null)
					model.setSchTp(schTp[i]);
				if (cNo[i] != null)
					model.setCNo(cNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (address[i] != null)
					model.setAddress(address[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (importantNotice[i] != null)
					model.setImportantNotice(importantNotice[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcGrpSendListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcGrpSendListVO[]
	 */
	public ArrNtcGrpSendListVO[] getArrNtcGrpSendListVOs(){
		ArrNtcGrpSendListVO[] vos = (ArrNtcGrpSendListVO[])models.toArray(new ArrNtcGrpSendListVO[models.size()]);
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
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtEnd = this.vpsEtaDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisFlg = this.rvisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtStart = this.vpsEtaDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.knt = this.knt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNo = this.sNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCdOdr = this.bkgCustTpCdOdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a = this.a .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schTp = this.schTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNo = this.cNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.address = this.address .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.importantNotice = this.importantNotice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
