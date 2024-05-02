/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorTransCancellCustVO.java
*@FileTitle : KorTransCancellCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier :
*@LastVersion : 1.0
* 2011.11.16
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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

public class KorTransCancellCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorTransCancellCustVO> models = new ArrayList<KorTransCancellCustVO>();

	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String sndDate = null;
	/* Column Info */
	private String smpBlKnt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String loclCstmsCd = null;
	/* Column Info */
	private String mstBlKnt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String mtyBlKnt = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String loclCstmsPrtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trsmCxlDesc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnslBlKnt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String trsmCxlTpCd = null;
	/* Column Info */
	private String trsmCxlRsnCd = null;
	/* Column Info */
	private String hblKnt = null;
	/* Column Info */
	private String sndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorTransCancellCustVO() {}

	public KorTransCancellCustVO(String ibflag, String pagerows, String rqstDt, String smpBlKnt, String loclCstmsCd, String mstBlKnt, String etdDt, String etaDt, String mtyBlKnt, String mrnNo, String loclCstmsPrtCd, String trsmCxlDesc, String vvd, String vslNm, String polCd, String podCd, String cnslBlKnt, String trsmCxlTpCd, String trsmCxlRsnCd, String sndDate, String ioBndCd, String ofcCd, String userId, String hblKnt, String sndSeq) {
		this.rqstDt = rqstDt;
		this.sndDate = sndDate;
		this.smpBlKnt = smpBlKnt;
		this.etaDt = etaDt;
		this.loclCstmsCd = loclCstmsCd;
		this.mstBlKnt = mstBlKnt;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.ioBndCd = ioBndCd;
		this.mtyBlKnt = mtyBlKnt;
		this.mrnNo = mrnNo;
		this.loclCstmsPrtCd = loclCstmsPrtCd;
		this.pagerows = pagerows;
		this.trsmCxlDesc = trsmCxlDesc;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cnslBlKnt = cnslBlKnt;
		this.userId = userId;
		this.trsmCxlTpCd = trsmCxlTpCd;
		this.trsmCxlRsnCd = trsmCxlRsnCd;
		this.hblKnt = hblKnt;
		this.sndSeq = sndSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("snd_date", getSndDate());
		this.hashColumns.put("smp_bl_knt", getSmpBlKnt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("locl_cstms_cd", getLoclCstmsCd());
		this.hashColumns.put("mst_bl_knt", getMstBlKnt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("mty_bl_knt", getMtyBlKnt());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("locl_cstms_prt_cd", getLoclCstmsPrtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsm_cxl_desc", getTrsmCxlDesc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnsl_bl_knt", getCnslBlKnt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("trsm_cxl_tp_cd", getTrsmCxlTpCd());
		this.hashColumns.put("trsm_cxl_rsn_cd", getTrsmCxlRsnCd());
		this.hashColumns.put("hbl_knt", getHblKnt());
		this.hashColumns.put("snd_seq", getSndSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("snd_date", "sndDate");
		this.hashFields.put("smp_bl_knt", "smpBlKnt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("locl_cstms_cd", "loclCstmsCd");
		this.hashFields.put("mst_bl_knt", "mstBlKnt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("mty_bl_knt", "mtyBlKnt");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("locl_cstms_prt_cd", "loclCstmsPrtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsm_cxl_desc", "trsmCxlDesc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnsl_bl_knt", "cnslBlKnt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("trsm_cxl_tp_cd", "trsmCxlTpCd");
		this.hashFields.put("trsm_cxl_rsn_cd", "trsmCxlRsnCd");
		this.hashFields.put("hbl_knt", "hblKnt");
		this.hashFields.put("snd_seq", "sndSeq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}

	/**
	 * Column Info
	 * @return sndDate
	 */
	public String getSndDate() {
		return this.sndDate;
	}

	/**
	 * Column Info
	 * @return smpBlKnt
	 */
	public String getSmpBlKnt() {
		return this.smpBlKnt;
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
	 * @return loclCstmsCd
	 */
	public String getLoclCstmsCd() {
		return this.loclCstmsCd;
	}

	/**
	 * Column Info
	 * @return mstBlKnt
	 */
	public String getMstBlKnt() {
		return this.mstBlKnt;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return mtyBlKnt
	 */
	public String getMtyBlKnt() {
		return this.mtyBlKnt;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}

	/**
	 * Column Info
	 * @return loclCstmsPrtCd
	 */
	public String getLoclCstmsPrtCd() {
		return this.loclCstmsPrtCd;
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
	 * @return trsmCxlDesc
	 */
	public String getTrsmCxlDesc() {
		return this.trsmCxlDesc;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cnslBlKnt
	 */
	public String getCnslBlKnt() {
		return this.cnslBlKnt;
	}

	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return trsmCxlTpCd
	 */
	public String getTrsmCxlTpCd() {
		return this.trsmCxlTpCd;
	}

	/**
	 * Column Info
	 * @return trsmCxlRsnCd
	 */
	public String getTrsmCxlRsnCd() {
		return this.trsmCxlRsnCd;
	}

	/**
	 * Column Info
	 * @return hblKnt
	 */
	public String getHblKnt() {
		return this.hblKnt;
	}

	/**
	 * Column Info
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	/**
	 * Column Info
	 * @param sndDate
	 */
	public void setSndDate(String sndDate) {
		this.sndDate = sndDate;
	}

	/**
	 * Column Info
	 * @param smpBlKnt
	 */
	public void setSmpBlKnt(String smpBlKnt) {
		this.smpBlKnt = smpBlKnt;
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
	 * @param loclCstmsCd
	 */
	public void setLoclCstmsCd(String loclCstmsCd) {
		this.loclCstmsCd = loclCstmsCd;
	}

	/**
	 * Column Info
	 * @param mstBlKnt
	 */
	public void setMstBlKnt(String mstBlKnt) {
		this.mstBlKnt = mstBlKnt;
	}

	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param mtyBlKnt
	 */
	public void setMtyBlKnt(String mtyBlKnt) {
		this.mtyBlKnt = mtyBlKnt;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * Column Info
	 * @param loclCstmsPrtCd
	 */
	public void setLoclCstmsPrtCd(String loclCstmsPrtCd) {
		this.loclCstmsPrtCd = loclCstmsPrtCd;
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
	 * @param trsmCxlDesc
	 */
	public void setTrsmCxlDesc(String trsmCxlDesc) {
		this.trsmCxlDesc = trsmCxlDesc;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cnslBlKnt
	 */
	public void setCnslBlKnt(String cnslBlKnt) {
		this.cnslBlKnt = cnslBlKnt;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param trsmCxlTpCd
	 */
	public void setTrsmCxlTpCd(String trsmCxlTpCd) {
		this.trsmCxlTpCd = trsmCxlTpCd;
	}

	/**
	 * Column Info
	 * @param trsmCxlRsnCd
	 */
	public void setTrsmCxlRsnCd(String trsmCxlRsnCd) {
		this.trsmCxlRsnCd = trsmCxlRsnCd;
	}

	/**
	 * Column Info
	 * @param hblKnt
	 */
	public void setHblKnt(String hblKnt) {
		this.hblKnt = hblKnt;
	}

	/**
	 * Column Info
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setSndDate(JSPUtil.getParameter(request, prefix + "snd_date", ""));
		setSmpBlKnt(JSPUtil.getParameter(request, prefix + "smp_bl_knt", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setLoclCstmsCd(JSPUtil.getParameter(request, prefix + "locl_cstms_cd", ""));
		setMstBlKnt(JSPUtil.getParameter(request, prefix + "mst_bl_knt", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setMtyBlKnt(JSPUtil.getParameter(request, prefix + "mty_bl_knt", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setLoclCstmsPrtCd(JSPUtil.getParameter(request, prefix + "locl_cstms_prt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrsmCxlDesc(JSPUtil.getParameter(request, prefix + "trsm_cxl_desc", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnslBlKnt(JSPUtil.getParameter(request, prefix + "cnsl_bl_knt", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setTrsmCxlTpCd(JSPUtil.getParameter(request, prefix + "trsm_cxl_tp_cd", ""));
		setTrsmCxlRsnCd(JSPUtil.getParameter(request, prefix + "trsm_cxl_rsn_cd", ""));
		setHblKnt(JSPUtil.getParameter(request, prefix + "hbl_knt", ""));
		setSndSeq(JSPUtil.getParameter(request, prefix + "snd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorTransCancellCustVO[]
	 */
	public KorTransCancellCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorTransCancellCustVO[]
	 */
	public KorTransCancellCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorTransCancellCustVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] sndDate = (JSPUtil.getParameter(request, prefix	+ "snd_date", length));
			String[] smpBlKnt = (JSPUtil.getParameter(request, prefix	+ "smp_bl_knt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] loclCstmsCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_cd", length));
			String[] mstBlKnt = (JSPUtil.getParameter(request, prefix	+ "mst_bl_knt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] mtyBlKnt = (JSPUtil.getParameter(request, prefix	+ "mty_bl_knt", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] loclCstmsPrtCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_prt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trsmCxlDesc = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_desc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnslBlKnt = (JSPUtil.getParameter(request, prefix	+ "cnsl_bl_knt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] trsmCxlTpCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_tp_cd", length));
			String[] trsmCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_rsn_cd", length));
			String[] hblKnt = (JSPUtil.getParameter(request, prefix	+ "hbl_knt", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));

			for (int i = 0; i < length; i++) {
				model = new KorTransCancellCustVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (sndDate[i] != null)
					model.setSndDate(sndDate[i]);
				if (smpBlKnt[i] != null)
					model.setSmpBlKnt(smpBlKnt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (loclCstmsCd[i] != null)
					model.setLoclCstmsCd(loclCstmsCd[i]);
				if (mstBlKnt[i] != null)
					model.setMstBlKnt(mstBlKnt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (mtyBlKnt[i] != null)
					model.setMtyBlKnt(mtyBlKnt[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (loclCstmsPrtCd[i] != null)
					model.setLoclCstmsPrtCd(loclCstmsPrtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trsmCxlDesc[i] != null)
					model.setTrsmCxlDesc(trsmCxlDesc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnslBlKnt[i] != null)
					model.setCnslBlKnt(cnslBlKnt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (trsmCxlTpCd[i] != null)
					model.setTrsmCxlTpCd(trsmCxlTpCd[i]);
				if (trsmCxlRsnCd[i] != null)
					model.setTrsmCxlRsnCd(trsmCxlRsnCd[i]);
				if (hblKnt[i] != null)
					model.setHblKnt(hblKnt[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorTransCancellCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorTransCancellCustVO[]
	 */
	public KorTransCancellCustVO[] getKorTransCancellCustVOs(){
		KorTransCancellCustVO[] vos = (KorTransCancellCustVO[])models.toArray(new KorTransCancellCustVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDate = this.sndDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smpBlKnt = this.smpBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsCd = this.loclCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlKnt = this.mstBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBlKnt = this.mtyBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsPrtCd = this.loclCstmsPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlDesc = this.trsmCxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnslBlKnt = this.cnslBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlTpCd = this.trsmCxlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlRsnCd = this.trsmCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblKnt = this.hblKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
