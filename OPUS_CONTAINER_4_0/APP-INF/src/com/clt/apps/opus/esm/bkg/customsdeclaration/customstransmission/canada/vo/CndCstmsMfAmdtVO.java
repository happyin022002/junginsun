/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsManifestAmendmentVO.java
*@FileTitle : CndCstmsManifestAmendmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.19 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsMfAmdtVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsMfAmdtVO extends CstmsMfAmdtVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsMfAmdtVO> models = new ArrayList<CndCstmsMfAmdtVO>();
	
	/* Column Info */
	private String cstmsFileTpCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String aiType = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String hblCnt = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String amsRefNo = null;
	/* Column Info */
	private String mh = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String bVvdCd = null;
	/* Column Info */
	private String cntrMfCnt = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String bMi = null;
	/* Column Info */
	private String error = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String vMi = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String actionCode = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String miSndDt = null;
	/* Column Info */
	private String tVvdCd = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String actionDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsMfAmdtVO() {}

	public CndCstmsMfAmdtVO(String ibflag, String pagerows, String aiType, String amsRefNo, String bkgNo, String mh, String cndCstmsFileCd, String mblNo, String bkgStsCd, String tVvdCd, String polCd, String podCd, String vMi, String bMi, String bVvdCd, String miSndDt, String cstmsFileTpCd, String mfStsCd, String actionCode, String actionDesc, String error, String bkgCgoTpCd, String hblCnt, String cntrMfCnt, String cntrCnt, String custToOrdFlg, String cCustNm, String cCustAddr, String nCustNm, String nCustAddr) {
		this.cstmsFileTpCd = cstmsFileTpCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.aiType = aiType;
		this.bkgStsCd = bkgStsCd;
		this.cCustNm = cCustNm;
		this.hblCnt = hblCnt;
		this.nCustAddr = nCustAddr;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.amsRefNo = amsRefNo;
		this.mh = mh;
		this.custToOrdFlg = custToOrdFlg;
		this.bVvdCd = bVvdCd;
		this.cntrMfCnt = cntrMfCnt;
		this.nCustNm = nCustNm;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.bMi = bMi;
		this.error = error;
		this.cntrCnt = cntrCnt;
		this.vMi = vMi;
		this.podCd = podCd;
		this.actionCode = actionCode;
		this.bkgNo = bkgNo;
		this.miSndDt = miSndDt;
		this.tVvdCd = tVvdCd;
		this.mblNo = mblNo;
		this.actionDesc = actionDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("ai_type", getAiType());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("hbl_cnt", getHblCnt());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("ams_ref_no", getAmsRefNo());
		this.hashColumns.put("mh", getMh());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("b_vvd_cd", getBVvdCd());
		this.hashColumns.put("cntr_mf_cnt", getCntrMfCnt());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("b_mi", getBMi());
		this.hashColumns.put("error", getError());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("v_mi", getVMi());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("action_code", getActionCode());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mi_snd_dt", getMiSndDt());
		this.hashColumns.put("t_vvd_cd", getTVvdCd());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("action_desc", getActionDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("ai_type", "aiType");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("hbl_cnt", "hblCnt");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("ams_ref_no", "amsRefNo");
		this.hashFields.put("mh", "mh");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("b_vvd_cd", "bVvdCd");
		this.hashFields.put("cntr_mf_cnt", "cntrMfCnt");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("b_mi", "bMi");
		this.hashFields.put("error", "error");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("v_mi", "vMi");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("action_code", "actionCode");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mi_snd_dt", "miSndDt");
		this.hashFields.put("t_vvd_cd", "tVvdCd");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("action_desc", "actionDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsFileTpCd
	 */
	public String getCstmsFileTpCd() {
		return this.cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return aiType
	 */
	public String getAiType() {
		return this.aiType;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return hblCnt
	 */
	public String getHblCnt() {
		return this.hblCnt;
	}
	
	/**
	 * Column Info
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
	}
	
	/**
	 * Column Info
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}
	
	/**
	 * Column Info
	 * @return amsRefNo
	 */
	public String getAmsRefNo() {
		return this.amsRefNo;
	}
	
	/**
	 * Column Info
	 * @return mh
	 */
	public String getMh() {
		return this.mh;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return bVvdCd
	 */
	public String getBVvdCd() {
		return this.bVvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfCnt
	 */
	public String getCntrMfCnt() {
		return this.cntrMfCnt;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return cndCstmsFileCd
	 */
	public String getCndCstmsFileCd() {
		return this.cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return bMi
	 */
	public String getBMi() {
		return this.bMi;
	}
	
	/**
	 * Column Info
	 * @return error
	 */
	public String getError() {
		return this.error;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return vMi
	 */
	public String getVMi() {
		return this.vMi;
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
	 * @return actionCode
	 */
	public String getActionCode() {
		return this.actionCode;
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
	 * @return miSndDt
	 */
	public String getMiSndDt() {
		return this.miSndDt;
	}
	
	/**
	 * Column Info
	 * @return tVvdCd
	 */
	public String getTVvdCd() {
		return this.tVvdCd;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
	}
	
	/**
	 * Column Info
	 * @return actionDesc
	 */
	public String getActionDesc() {
		return this.actionDesc;
	}
	

	/**
	 * Column Info
	 * @param cstmsFileTpCd
	 */
	public void setCstmsFileTpCd(String cstmsFileTpCd) {
		this.cstmsFileTpCd = cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param aiType
	 */
	public void setAiType(String aiType) {
		this.aiType = aiType;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param hblCnt
	 */
	public void setHblCnt(String hblCnt) {
		this.hblCnt = hblCnt;
	}
	
	/**
	 * Column Info
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
	}
	
	/**
	 * Column Info
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}
	
	/**
	 * Column Info
	 * @param amsRefNo
	 */
	public void setAmsRefNo(String amsRefNo) {
		this.amsRefNo = amsRefNo;
	}
	
	/**
	 * Column Info
	 * @param mh
	 */
	public void setMh(String mh) {
		this.mh = mh;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param bVvdCd
	 */
	public void setBVvdCd(String bVvdCd) {
		this.bVvdCd = bVvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfCnt
	 */
	public void setCntrMfCnt(String cntrMfCnt) {
		this.cntrMfCnt = cntrMfCnt;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param cndCstmsFileCd
	 */
	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param bMi
	 */
	public void setBMi(String bMi) {
		this.bMi = bMi;
	}
	
	/**
	 * Column Info
	 * @param error
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param vMi
	 */
	public void setVMi(String vMi) {
		this.vMi = vMi;
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
	 * @param actionCode
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
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
	 * @param miSndDt
	 */
	public void setMiSndDt(String miSndDt) {
		this.miSndDt = miSndDt;
	}
	
	/**
	 * Column Info
	 * @param tVvdCd
	 */
	public void setTVvdCd(String tVvdCd) {
		this.tVvdCd = tVvdCd;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	
	/**
	 * Column Info
	 * @param actionDesc
	 */
	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmsFileTpCd(JSPUtil.getParameter(request, "cstms_file_tp_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setAiType(JSPUtil.getParameter(request, "ai_type", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setHblCnt(JSPUtil.getParameter(request, "hbl_cnt", ""));
		setNCustAddr(JSPUtil.getParameter(request, "n_cust_addr", ""));
		setMfStsCd(JSPUtil.getParameter(request, "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, "c_cust_addr", ""));
		setAmsRefNo(JSPUtil.getParameter(request, "ams_ref_no", ""));
		setMh(JSPUtil.getParameter(request, "mh", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, "cust_to_ord_flg", ""));
		setBVvdCd(JSPUtil.getParameter(request, "b_vvd_cd", ""));
		setCntrMfCnt(JSPUtil.getParameter(request, "cntr_mf_cnt", ""));
		setNCustNm(JSPUtil.getParameter(request, "n_cust_nm", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, "cnd_cstms_file_cd", ""));
		setBMi(JSPUtil.getParameter(request, "b_mi", ""));
		setError(JSPUtil.getParameter(request, "error", ""));
		setCntrCnt(JSPUtil.getParameter(request, "cntr_cnt", ""));
		setVMi(JSPUtil.getParameter(request, "v_mi", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setActionCode(JSPUtil.getParameter(request, "action_code", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMiSndDt(JSPUtil.getParameter(request, "mi_snd_dt", ""));
		setTVvdCd(JSPUtil.getParameter(request, "t_vvd_cd", ""));
		setMblNo(JSPUtil.getParameter(request, "mbl_no", ""));
		setActionDesc(JSPUtil.getParameter(request, "action_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsMfAmdtVO[]
	 */
	public CndCstmsMfAmdtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsMfAmdtVO[]
	 */
	public CndCstmsMfAmdtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsMfAmdtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_tp_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] aiType = (JSPUtil.getParameter(request, prefix	+ "ai_type", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] hblCnt = (JSPUtil.getParameter(request, prefix	+ "hbl_cnt", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] amsRefNo = (JSPUtil.getParameter(request, prefix	+ "ams_ref_no", length));
			String[] mh = (JSPUtil.getParameter(request, prefix	+ "mh", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] bVvdCd = (JSPUtil.getParameter(request, prefix	+ "b_vvd_cd", length));
			String[] cntrMfCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_cnt", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] bMi = (JSPUtil.getParameter(request, prefix	+ "b_mi", length));
			String[] error = (JSPUtil.getParameter(request, prefix	+ "error", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] vMi = (JSPUtil.getParameter(request, prefix	+ "v_mi", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] actionCode = (JSPUtil.getParameter(request, prefix	+ "action_code", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] miSndDt = (JSPUtil.getParameter(request, prefix	+ "mi_snd_dt", length));
			String[] tVvdCd = (JSPUtil.getParameter(request, prefix	+ "t_vvd_cd", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] actionDesc = (JSPUtil.getParameter(request, prefix	+ "action_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsMfAmdtVO();
				if (cstmsFileTpCd[i] != null)
					model.setCstmsFileTpCd(cstmsFileTpCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (aiType[i] != null)
					model.setAiType(aiType[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (hblCnt[i] != null)
					model.setHblCnt(hblCnt[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (amsRefNo[i] != null)
					model.setAmsRefNo(amsRefNo[i]);
				if (mh[i] != null)
					model.setMh(mh[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (bVvdCd[i] != null)
					model.setBVvdCd(bVvdCd[i]);
				if (cntrMfCnt[i] != null)
					model.setCntrMfCnt(cntrMfCnt[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (bMi[i] != null)
					model.setBMi(bMi[i]);
				if (error[i] != null)
					model.setError(error[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (vMi[i] != null)
					model.setVMi(vMi[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (actionCode[i] != null)
					model.setActionCode(actionCode[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (miSndDt[i] != null)
					model.setMiSndDt(miSndDt[i]);
				if (tVvdCd[i] != null)
					model.setTVvdCd(tVvdCd[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (actionDesc[i] != null)
					model.setActionDesc(actionDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsMfAmdtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsMfAmdtVO[]
	 */
	public CndCstmsMfAmdtVO[] getCndCstmsMfAmdtVOs(){
		CndCstmsMfAmdtVO[] vos = (CndCstmsMfAmdtVO[])models.toArray(new CndCstmsMfAmdtVO[models.size()]);
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
		this.cstmsFileTpCd = this.cstmsFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aiType = this.aiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCnt = this.hblCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsRefNo = this.amsRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mh = this.mh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bVvdCd = this.bVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfCnt = this.cntrMfCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bMi = this.bMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.error = this.error .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vMi = this.vMi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionCode = this.actionCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miSndDt = this.miSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvdCd = this.tVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionDesc = this.actionDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
