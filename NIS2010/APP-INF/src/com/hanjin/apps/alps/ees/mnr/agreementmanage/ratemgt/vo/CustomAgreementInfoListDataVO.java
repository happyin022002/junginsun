/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAgreementInfoListDataVO.java
*@FileTitle : CustomAgreementInfoListDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.10.08 함형석 
* 1.0 Creation
* 2014-03-21 Ticket No : CHM-201429420 Title : ALPS MNR-Agreement-Tariff-Agreement List에 Expiry Date 추가 요청 TD : Jonghee HAN DEV : JongHee HAN -> exp_dt Column 추가
* 2014-11-06 CSR ID : CHM-201432660 : ALPS MNR-AGMT_TARIFF 화면에서 GW-Contract Document와 ALPS MNR-AGMT와 Interface된 결과 값을 보여줄수 있도록 구현 : AA Chang Young Kim, DEV 이상근
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomAgreementInfoListDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomAgreementInfoListDataVO> models = new ArrayList<CustomAgreementInfoListDataVO>();
	
	/* Column Info */
	private String hgChk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String svChk = null;
	/* Column Info */
	private String otChk = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Column Info */
	private String adChk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tpChk = null;
	/* Column Info */
	private String rpChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prChk = null;
	/* Column Info */
	private String mnrCdDpDesc = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ptChk = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String clChk = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String pmChk = null;
	/* Column Info */
	private String rhqOfc = null;
	/* Column Info */
	private String gwUqDocNo;
	/* Column Info */
	private String gwUqDocDocTitNm;
	/* Column Info */
	private String fileAtchFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomAgreementInfoListDataVO() {}

	public CustomAgreementInfoListDataVO(String ibflag, String pagerows, String hgChk, String svChk, String otChk, String agmtNo, String deltFlg, String vndrLglEngNm, String agmtOfcCd, String adChk, String tpChk, String rpChk, String effDt, String expDt, String prChk, String mnrCdDpDesc, String ptChk, String vndrSeq, String trfNo, String refNo, String clChk, String pmChk, String agmtVerNo, String rhqOfc, String gwUqDocNo, String gwUqDocDocTitNm, String fileAtchFlg) {
		this.hgChk = hgChk;
		this.deltFlg = deltFlg;
		this.svChk = svChk;
		this.otChk = otChk;
		this.agmtNo = agmtNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agmtOfcCd = agmtOfcCd;
		this.adChk = adChk;
		this.pagerows = pagerows;
		this.tpChk = tpChk;
		this.rpChk = rpChk;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.expDt = expDt;
		this.prChk = prChk;
		this.mnrCdDpDesc = mnrCdDpDesc;
		this.trfNo = trfNo;
		this.vndrSeq = vndrSeq;
		this.ptChk = ptChk;
		this.refNo = refNo;
		this.clChk = clChk;
		this.agmtVerNo = agmtVerNo;
		this.pmChk = pmChk;
		this.rhqOfc = rhqOfc;
		this.gwUqDocNo = gwUqDocNo;
		this.gwUqDocDocTitNm = gwUqDocDocTitNm;
		this.fileAtchFlg = fileAtchFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hg_chk", getHgChk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("sv_chk", getSvChk());
		this.hashColumns.put("ot_chk", getOtChk());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("ad_chk", getAdChk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tp_chk", getTpChk());
		this.hashColumns.put("rp_chk", getRpChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("pr_chk", getPrChk());
		this.hashColumns.put("mnr_cd_dp_desc", getMnrCdDpDesc());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pt_chk", getPtChk());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cl_chk", getClChk());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("pm_chk", getPmChk());
		this.hashColumns.put("rhq_ofc", getRhqOfc());
		this.hashColumns.put("gw_uq_doc_no", getGwUqDocNo());
		this.hashColumns.put("gw_uq_doc_tit_nm", getGwUqDocDocTitNm());
		this.hashColumns.put("file_atch_flg", getFileAtchFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hg_chk", "hgChk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("sv_chk", "svChk");
		this.hashFields.put("ot_chk", "otChk");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("ad_chk", "adChk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tp_chk", "tpChk");
		this.hashFields.put("rp_chk", "rpChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("pr_chk", "prChk");
		this.hashFields.put("mnr_cd_dp_desc", "mnrCdDpDesc");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pt_chk", "ptChk");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cl_chk", "clChk");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("pm_chk", "pmChk");
		this.hashFields.put("rhq_ofc", "rhqOfc");
		this.hashFields.put("gw_uq_doc_no", "gwUqDocNo");
		this.hashFields.put("gw_uq_doc_tit_nm", "gwUqDocDocTitNm");
		this.hashFields.put("file_atch_flg", "fileAtchFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hgChk
	 */
	public String getHgChk() {
		return this.hgChk;
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
	 * @return svChk
	 */
	public String getSvChk() {
		return this.svChk;
	}
	
	/**
	 * Column Info
	 * @return otChk
	 */
	public String getOtChk() {
		return this.otChk;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return agmtOfcCd
	 */
	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adChk
	 */
	public String getAdChk() {
		return this.adChk;
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
	 * @return tpChk
	 */
	public String getTpChk() {
		return this.tpChk;
	}
	
	/**
	 * Column Info
	 * @return rpChk
	 */
	public String getRpChk() {
		return this.rpChk;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return prChk
	 */
	public String getPrChk() {
		return this.prChk;
	}
	
	/**
	 * Column Info
	 * @return mnrCdDpDesc
	 */
	public String getMnrCdDpDesc() {
		return this.mnrCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @return ptChk
	 */
	public String getPtChk() {
		return this.ptChk;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return clChk
	 */
	public String getClChk() {
		return this.clChk;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return pmChk
	 */
	public String getPmChk() {
		return this.pmChk;
	}
	
	/**
	 * Column Info
	 * @return rhqOfc
	 */
	public String getRhqOfc() {
		return this.rhqOfc;
	}
	
	/**
	 * Column Info
	 * @return gwUqDocNo
	 */
	public String getGwUqDocNo() {
		return gwUqDocNo;
	}
	
	/**
	 * Column Info
	 * @return gwUqDocDocTitNm
	 */
	public String getGwUqDocDocTitNm() {
		return gwUqDocDocTitNm;
	}	
	

	/**
	 * Column Info
	 * @param hgChk
	 */
	public void setHgChk(String hgChk) {
		this.hgChk = hgChk;
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
	 * @param svChk
	 */
	public void setSvChk(String svChk) {
		this.svChk = svChk;
	}
	
	/**
	 * Column Info
	 * @param otChk
	 */
	public void setOtChk(String otChk) {
		this.otChk = otChk;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param agmtOfcCd
	 */
	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adChk
	 */
	public void setAdChk(String adChk) {
		this.adChk = adChk;
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
	 * @param tpChk
	 */
	public void setTpChk(String tpChk) {
		this.tpChk = tpChk;
	}
	
	/**
	 * Column Info
	 * @param rpChk
	 */
	public void setRpChk(String rpChk) {
		this.rpChk = rpChk;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param prChk
	 */
	public void setPrChk(String prChk) {
		this.prChk = prChk;
	}
	
	/**
	 * Column Info
	 * @param mnrCdDpDesc
	 */
	public void setMnrCdDpDesc(String mnrCdDpDesc) {
		this.mnrCdDpDesc = mnrCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
	 * @param ptChk
	 */
	public void setPtChk(String ptChk) {
		this.ptChk = ptChk;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param clChk
	 */
	public void setClChk(String clChk) {
		this.clChk = clChk;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param pmChk
	 */
	public void setPmChk(String pmChk) {
		this.pmChk = pmChk;
	}
	
	/**
	 * Column Info
	 * @param rhqOfc
	 */
	public void setRhqOfc(String rhqOfc) {
		this.rhqOfc = rhqOfc;
	}

	/**
	 * Column Info
	 * @param gwUqDocNo
	 */	
	public void setGwUqDocNo(String gwUqDocNo) {
		this.gwUqDocNo = gwUqDocNo;
	}

	/**
	 * Column Info
	 * @param gwUqDocDocTitNm
	 */
	public void setGwUqDocDocTitNm(String gwUqDocDocTitNm) {
		this.gwUqDocDocTitNm = gwUqDocDocTitNm;
	}
	
	/**
	 * Column Info
	 * @return fileAtchFlg
	 */
	public String getFileAtchFlg() {
		return this.fileAtchFlg;
	}
	
	/**
	 * Column Info
	 * @return fileAtchFlg
	 */
	public void setFileAtchFlg(String fileAtchFlg) {
		this.fileAtchFlg = fileAtchFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHgChk(JSPUtil.getParameter(request, "hg_chk", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSvChk(JSPUtil.getParameter(request, "sv_chk", ""));
		setOtChk(JSPUtil.getParameter(request, "ot_chk", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setAdChk(JSPUtil.getParameter(request, "ad_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTpChk(JSPUtil.getParameter(request, "tp_chk", ""));
		setRpChk(JSPUtil.getParameter(request, "rp_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPrChk(JSPUtil.getParameter(request, "pr_chk", ""));
		setMnrCdDpDesc(JSPUtil.getParameter(request, "mnr_cd_dp_desc", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPtChk(JSPUtil.getParameter(request, "pt_chk", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setClChk(JSPUtil.getParameter(request, "cl_chk", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setPmChk(JSPUtil.getParameter(request, "pm_chk", ""));
		setRhqOfc(JSPUtil.getParameter(request, "rhq_ofc", ""));
		setGwUqDocNo(JSPUtil.getParameter(request, "gw_uq_doc_no", ""));
		setGwUqDocDocTitNm(JSPUtil.getParameter(request, "gw_uq_doc_tit_nm", ""));
		setFileAtchFlg(JSPUtil.getParameter(request, "file_atch_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomAgreementInfoListDataVO[]
	 */
	public CustomAgreementInfoListDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomAgreementInfoListDataVO[]
	 */
	public CustomAgreementInfoListDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomAgreementInfoListDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hgChk = (JSPUtil.getParameter(request, prefix	+ "hg_chk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] svChk = (JSPUtil.getParameter(request, prefix	+ "sv_chk", length));
			String[] otChk = (JSPUtil.getParameter(request, prefix	+ "ot_chk", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] adChk = (JSPUtil.getParameter(request, prefix	+ "ad_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tpChk = (JSPUtil.getParameter(request, prefix	+ "tp_chk", length));
			String[] rpChk = (JSPUtil.getParameter(request, prefix	+ "rp_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prChk = (JSPUtil.getParameter(request, prefix	+ "pr_chk", length));
			String[] mnrCdDpDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dp_desc", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ptChk = (JSPUtil.getParameter(request, prefix	+ "pt_chk", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] clChk = (JSPUtil.getParameter(request, prefix	+ "cl_chk", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] pmChk = (JSPUtil.getParameter(request, prefix	+ "pm_chk", length));
			String[] rhqOfc = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc", length));
			String[] gwUqDocNo = (JSPUtil.getParameter(request, prefix	+ "gwUqDocNo", length));
			String[] gwUqDocDocTitNm = (JSPUtil.getParameter(request, prefix	+ "gwUqDocDocTitNm", length));
			String[] fileAtchFlg = (JSPUtil.getParameter(request, prefix + "file_atch_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomAgreementInfoListDataVO();
				if (hgChk[i] != null)
					model.setHgChk(hgChk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (svChk[i] != null)
					model.setSvChk(svChk[i]);
				if (otChk[i] != null)
					model.setOtChk(otChk[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (adChk[i] != null)
					model.setAdChk(adChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tpChk[i] != null)
					model.setTpChk(tpChk[i]);
				if (rpChk[i] != null)
					model.setRpChk(rpChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prChk[i] != null)
					model.setPrChk(prChk[i]);
				if (mnrCdDpDesc[i] != null)
					model.setMnrCdDpDesc(mnrCdDpDesc[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ptChk[i] != null)
					model.setPtChk(ptChk[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (clChk[i] != null)
					model.setClChk(clChk[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (pmChk[i] != null)
					model.setPmChk(pmChk[i]);
				if (rhqOfc[i] != null)
					model.setRhqOfc(rhqOfc[i]);
				if (gwUqDocNo[i] != null)
					model.setGwUqDocNo(gwUqDocNo[i]);
				if (gwUqDocDocTitNm[i] != null)
					model.setGwUqDocDocTitNm(gwUqDocDocTitNm[i]);
				if (fileAtchFlg[i] != null)
					model.setFileAtchFlg(fileAtchFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomAgreementInfoListDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomAgreementInfoListDataVO[]
	 */
	public CustomAgreementInfoListDataVO[] getCustomAgreementInfoListDataVOs(){
		CustomAgreementInfoListDataVO[] vos = (CustomAgreementInfoListDataVO[])models.toArray(new CustomAgreementInfoListDataVO[models.size()]);
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
		this.hgChk = this.hgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svChk = this.svChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otChk = this.otChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adChk = this.adChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpChk = this.tpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpChk = this.rpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prChk = this.prChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDpDesc = this.mnrCdDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptChk = this.ptChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clChk = this.clChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmChk = this.pmChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfc = this.rhqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocNo = this.gwUqDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocDocTitNm = this.gwUqDocDocTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileAtchFlg = this.fileAtchFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
