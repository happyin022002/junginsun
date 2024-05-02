/*=========================================================
Copyright(c) 2011 CyberLogitec
*@FileName : BkgWebService004VO.java
*@FileTitle : BkgWebService004VO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.17
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.10.17 김종호 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgWebService004VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgWebService004VO> models = new ArrayList<BkgWebService004VO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String loclVerCtnt = null;
	/* Column Info */
	private String wblPrnGdt = null;
	/* Column Info */
	private String ntfySeq = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wblPrnDt = null;
	/* Column Info */
	private String prnUsrId = null;
	/* Column Info */
	private String mrgDt = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String frtFwrdSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String infoSeq = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String wblPrnKnt = null;
	/* Column Info */
	private String prnCustTpCd = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String docEcdProcFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String n1stPrnDt = null;
	/* Column Info */
	private String inetBlSndViaCd = null;
	/* Column Info */
	private String mrgFileNm = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String frtFwrdCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgWebService004VO() {}

	public BkgWebService004VO(String ibflag, String pagerows, String bkgNo, String infoSeq, String blNo, String mrgFileNm, String docEcdProcFlg, String mrgDt, String n1stPrnDt, String wblPrnDt, String wblPrnGdt, String prnUsrId, String prnCustTpCd, String inetBlSndViaCd, String shprCntCd, String shprSeq, String cneeCntCd, String cneeSeq, String ntfyCntCd, String ntfySeq, String frtFwrdCntCd, String frtFwrdSeq, String vslCd, String skdVoyNo, String skdDirCd, String bkgCustTpCd, String loclVerCtnt, String wblPrnKnt, String updUsrId, String result) {
		this.result = result;
		this.vslCd = vslCd;
		this.loclVerCtnt = loclVerCtnt;
		this.wblPrnGdt = wblPrnGdt;
		this.ntfySeq = ntfySeq;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.ibflag = ibflag;
		this.wblPrnDt = wblPrnDt;
		this.prnUsrId = prnUsrId;
		this.mrgDt = mrgDt;
		this.bkgCustTpCd = bkgCustTpCd;
		this.frtFwrdSeq = frtFwrdSeq;
		this.updUsrId = updUsrId;
		this.infoSeq = infoSeq;
		this.ntfyCntCd = ntfyCntCd;
		this.wblPrnKnt = wblPrnKnt;
		this.prnCustTpCd = prnCustTpCd;
		this.shprCntCd = shprCntCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.docEcdProcFlg = docEcdProcFlg;
		this.bkgNo = bkgNo;
		this.cneeSeq = cneeSeq;
		this.n1stPrnDt = n1stPrnDt;
		this.inetBlSndViaCd = inetBlSndViaCd;
		this.mrgFileNm = mrgFileNm;
		this.shprSeq = shprSeq;
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("locl_ver_ctnt", getLoclVerCtnt());
		this.hashColumns.put("wbl_prn_gdt", getWblPrnGdt());
		this.hashColumns.put("ntfy_seq", getNtfySeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wbl_prn_dt", getWblPrnDt());
		this.hashColumns.put("prn_usr_id", getPrnUsrId());
		this.hashColumns.put("mrg_dt", getMrgDt());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("frt_fwrd_seq", getFrtFwrdSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("info_seq", getInfoSeq());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("wbl_prn_knt", getWblPrnKnt());
		this.hashColumns.put("prn_cust_tp_cd", getPrnCustTpCd());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("doc_ecd_proc_flg", getDocEcdProcFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("n1st_prn_dt", getN1stPrnDt());
		this.hashColumns.put("inet_bl_snd_via_cd", getInetBlSndViaCd());
		this.hashColumns.put("mrg_file_nm", getMrgFileNm());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("locl_ver_ctnt", "loclVerCtnt");
		this.hashFields.put("wbl_prn_gdt", "wblPrnGdt");
		this.hashFields.put("ntfy_seq", "ntfySeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wbl_prn_dt", "wblPrnDt");
		this.hashFields.put("prn_usr_id", "prnUsrId");
		this.hashFields.put("mrg_dt", "mrgDt");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("frt_fwrd_seq", "frtFwrdSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("info_seq", "infoSeq");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("wbl_prn_knt", "wblPrnKnt");
		this.hashFields.put("prn_cust_tp_cd", "prnCustTpCd");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("doc_ecd_proc_flg", "docEcdProcFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("n1st_prn_dt", "n1stPrnDt");
		this.hashFields.put("inet_bl_snd_via_cd", "inetBlSndViaCd");
		this.hashFields.put("mrg_file_nm", "mrgFileNm");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
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
	 * @return loclVerCtnt
	 */
	public String getLoclVerCtnt() {
		return this.loclVerCtnt;
	}
	
	/**
	 * Column Info
	 * @return wblPrnGdt
	 */
	public String getWblPrnGdt() {
		return this.wblPrnGdt;
	}
	
	/**
	 * Column Info
	 * @return ntfySeq
	 */
	public String getNtfySeq() {
		return this.ntfySeq;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
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
	 * @return wblPrnDt
	 */
	public String getWblPrnDt() {
		return this.wblPrnDt;
	}
	
	/**
	 * Column Info
	 * @return prnUsrId
	 */
	public String getPrnUsrId() {
		return this.prnUsrId;
	}
	
	/**
	 * Column Info
	 * @return mrgDt
	 */
	public String getMrgDt() {
		return this.mrgDt;
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
	 * @return frtFwrdSeq
	 */
	public String getFrtFwrdSeq() {
		return this.frtFwrdSeq;
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
	 * @return infoSeq
	 */
	public String getInfoSeq() {
		return this.infoSeq;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @return wblPrnKnt
	 */
	public String getWblPrnKnt() {
		return this.wblPrnKnt;
	}
	
	/**
	 * Column Info
	 * @return prnCustTpCd
	 */
	public String getPrnCustTpCd() {
		return this.prnCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return docEcdProcFlg
	 */
	public String getDocEcdProcFlg() {
		return this.docEcdProcFlg;
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
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stPrnDt
	 */
	public String getN1stPrnDt() {
		return this.n1stPrnDt;
	}
	
	/**
	 * Column Info
	 * @return inetBlSndViaCd
	 */
	public String getInetBlSndViaCd() {
		return this.inetBlSndViaCd;
	}
	
	/**
	 * Column Info
	 * @return mrgFileNm
	 */
	public String getMrgFileNm() {
		return this.mrgFileNm;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
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
	 * @param loclVerCtnt
	 */
	public void setLoclVerCtnt(String loclVerCtnt) {
		this.loclVerCtnt = loclVerCtnt;
	}
	
	/**
	 * Column Info
	 * @param wblPrnGdt
	 */
	public void setWblPrnGdt(String wblPrnGdt) {
		this.wblPrnGdt = wblPrnGdt;
	}
	
	/**
	 * Column Info
	 * @param ntfySeq
	 */
	public void setNtfySeq(String ntfySeq) {
		this.ntfySeq = ntfySeq;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
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
	 * @param wblPrnDt
	 */
	public void setWblPrnDt(String wblPrnDt) {
		this.wblPrnDt = wblPrnDt;
	}
	
	/**
	 * Column Info
	 * @param prnUsrId
	 */
	public void setPrnUsrId(String prnUsrId) {
		this.prnUsrId = prnUsrId;
	}
	
	/**
	 * Column Info
	 * @param mrgDt
	 */
	public void setMrgDt(String mrgDt) {
		this.mrgDt = mrgDt;
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
	 * @param frtFwrdSeq
	 */
	public void setFrtFwrdSeq(String frtFwrdSeq) {
		this.frtFwrdSeq = frtFwrdSeq;
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
	 * @param infoSeq
	 */
	public void setInfoSeq(String infoSeq) {
		this.infoSeq = infoSeq;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @param wblPrnKnt
	 */
	public void setWblPrnKnt(String wblPrnKnt) {
		this.wblPrnKnt = wblPrnKnt;
	}
	
	/**
	 * Column Info
	 * @param prnCustTpCd
	 */
	public void setPrnCustTpCd(String prnCustTpCd) {
		this.prnCustTpCd = prnCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param docEcdProcFlg
	 */
	public void setDocEcdProcFlg(String docEcdProcFlg) {
		this.docEcdProcFlg = docEcdProcFlg;
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
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stPrnDt
	 */
	public void setN1stPrnDt(String n1stPrnDt) {
		this.n1stPrnDt = n1stPrnDt;
	}
	
	/**
	 * Column Info
	 * @param inetBlSndViaCd
	 */
	public void setInetBlSndViaCd(String inetBlSndViaCd) {
		this.inetBlSndViaCd = inetBlSndViaCd;
	}
	
	/**
	 * Column Info
	 * @param mrgFileNm
	 */
	public void setMrgFileNm(String mrgFileNm) {
		this.mrgFileNm = mrgFileNm;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
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
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLoclVerCtnt(JSPUtil.getParameter(request, prefix + "locl_ver_ctnt", ""));
		setWblPrnGdt(JSPUtil.getParameter(request, prefix + "wbl_prn_gdt", ""));
		setNtfySeq(JSPUtil.getParameter(request, prefix + "ntfy_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWblPrnDt(JSPUtil.getParameter(request, prefix + "wbl_prn_dt", ""));
		setPrnUsrId(JSPUtil.getParameter(request, prefix + "prn_usr_id", ""));
		setMrgDt(JSPUtil.getParameter(request, prefix + "mrg_dt", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setFrtFwrdSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInfoSeq(JSPUtil.getParameter(request, prefix + "info_seq", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setWblPrnKnt(JSPUtil.getParameter(request, prefix + "wbl_prn_knt", ""));
		setPrnCustTpCd(JSPUtil.getParameter(request, prefix + "prn_cust_tp_cd", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setDocEcdProcFlg(JSPUtil.getParameter(request, prefix + "doc_ecd_proc_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setN1stPrnDt(JSPUtil.getParameter(request, prefix + "n1st_prn_dt", ""));
		setInetBlSndViaCd(JSPUtil.getParameter(request, prefix + "inet_bl_snd_via_cd", ""));
		setMrgFileNm(JSPUtil.getParameter(request, prefix + "mrg_file_nm", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgWebService004VO[]
	 */
	public BkgWebService004VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgWebService004VO[]
	 */
	public BkgWebService004VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgWebService004VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] loclVerCtnt = (JSPUtil.getParameter(request, prefix	+ "locl_ver_ctnt", length));
			String[] wblPrnGdt = (JSPUtil.getParameter(request, prefix	+ "wbl_prn_gdt", length));
			String[] ntfySeq = (JSPUtil.getParameter(request, prefix	+ "ntfy_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wblPrnDt = (JSPUtil.getParameter(request, prefix	+ "wbl_prn_dt", length));
			String[] prnUsrId = (JSPUtil.getParameter(request, prefix	+ "prn_usr_id", length));
			String[] mrgDt = (JSPUtil.getParameter(request, prefix	+ "mrg_dt", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] frtFwrdSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] infoSeq = (JSPUtil.getParameter(request, prefix	+ "info_seq", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] wblPrnKnt = (JSPUtil.getParameter(request, prefix	+ "wbl_prn_knt", length));
			String[] prnCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prn_cust_tp_cd", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] docEcdProcFlg = (JSPUtil.getParameter(request, prefix	+ "doc_ecd_proc_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] n1stPrnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_prn_dt", length));
			String[] inetBlSndViaCd = (JSPUtil.getParameter(request, prefix	+ "inet_bl_snd_via_cd", length));
			String[] mrgFileNm = (JSPUtil.getParameter(request, prefix	+ "mrg_file_nm", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgWebService004VO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (loclVerCtnt[i] != null)
					model.setLoclVerCtnt(loclVerCtnt[i]);
				if (wblPrnGdt[i] != null)
					model.setWblPrnGdt(wblPrnGdt[i]);
				if (ntfySeq[i] != null)
					model.setNtfySeq(ntfySeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wblPrnDt[i] != null)
					model.setWblPrnDt(wblPrnDt[i]);
				if (prnUsrId[i] != null)
					model.setPrnUsrId(prnUsrId[i]);
				if (mrgDt[i] != null)
					model.setMrgDt(mrgDt[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (frtFwrdSeq[i] != null)
					model.setFrtFwrdSeq(frtFwrdSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (infoSeq[i] != null)
					model.setInfoSeq(infoSeq[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (wblPrnKnt[i] != null)
					model.setWblPrnKnt(wblPrnKnt[i]);
				if (prnCustTpCd[i] != null)
					model.setPrnCustTpCd(prnCustTpCd[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (docEcdProcFlg[i] != null)
					model.setDocEcdProcFlg(docEcdProcFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (n1stPrnDt[i] != null)
					model.setN1stPrnDt(n1stPrnDt[i]);
				if (inetBlSndViaCd[i] != null)
					model.setInetBlSndViaCd(inetBlSndViaCd[i]);
				if (mrgFileNm[i] != null)
					model.setMrgFileNm(mrgFileNm[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgWebService004VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgWebService004VO[]
	 */
	public BkgWebService004VO[] getBkgWebService004VOs(){
		BkgWebService004VO[] vos = (BkgWebService004VO[])models.toArray(new BkgWebService004VO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVerCtnt = this.loclVerCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblPrnGdt = this.wblPrnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfySeq = this.ntfySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblPrnDt = this.wblPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnUsrId = this.prnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrgDt = this.mrgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdSeq = this.frtFwrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoSeq = this.infoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblPrnKnt = this.wblPrnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnCustTpCd = this.prnCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docEcdProcFlg = this.docEcdProcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPrnDt = this.n1stPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inetBlSndViaCd = this.inetBlSndViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrgFileNm = this.mrgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
