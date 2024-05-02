/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDischManifestTransmitVO.java
*@FileTitle : KorDischManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.07 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see DischManifestTransmitVO
 */

public class KorDischManifestTransmitVO extends DischManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorDischManifestTransmitVO> models = new ArrayList<KorDischManifestTransmitVO>();

	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String mstBlKnt = null;
	/* Column Info */
	private String cstmsDchgCd = null;
	/* Column Info */
	private String loclCstmsPrtCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String loclCstmsCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String podTml = null;
	/* Column Info */
	private String noneBlInType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorDischManifestTransmitVO() {}

	public KorDischManifestTransmitVO(String ibflag, String pagerows, String bdAreaCd, String ioBndCd, String inType, String callKnt, String vslNm, String vslCallSgnCd, String etaDt, String etdDt, String cstmsDchgCd, String dchgMzdCd, String ioTmlLocCd, String loclCstmsCd, String loclCstmsPrtCd, String vslCntCd, String mrnNo, String vvdSeq, String vvd, String portCd, String polCd, String podCd, String podTml, String tmlCd, String userId, String ofcCd, String mstBlKnt, String noneBlInType) {
		this.etaDt = etaDt;
		this.mstBlKnt = mstBlKnt;
		this.cstmsDchgCd = cstmsDchgCd;
		this.loclCstmsPrtCd = loclCstmsPrtCd;
		this.mrnNo = mrnNo;
		this.tmlCd = tmlCd;
		this.pagerows = pagerows;
		this.inType = inType;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.userId = userId;
		this.callKnt = callKnt;
		this.vslCallSgnCd = vslCallSgnCd;
		this.portCd = portCd;
		this.vslCntCd = vslCntCd;
		this.vvdSeq = vvdSeq;
		this.ioTmlLocCd = ioTmlLocCd;
		this.loclCstmsCd = loclCstmsCd;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.ioBndCd = ioBndCd;
		this.bdAreaCd = bdAreaCd;
		this.dchgMzdCd = dchgMzdCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.podTml = podTml;
		this.noneBlInType = noneBlInType;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("mst_bl_knt", getMstBlKnt());
		this.hashColumns.put("cstms_dchg_cd", getCstmsDchgCd());
		this.hashColumns.put("locl_cstms_prt_cd", getLoclCstmsPrtCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("locl_cstms_cd", getLoclCstmsCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pod_tml", getPodTml());
		this.hashColumns.put("none_bl_in_type", getNoneBlInType());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("mst_bl_knt", "mstBlKnt");
		this.hashFields.put("cstms_dchg_cd", "cstmsDchgCd");
		this.hashFields.put("locl_cstms_prt_cd", "loclCstmsPrtCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("locl_cstms_cd", "loclCstmsCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pod_tml", "podTml");
		this.hashFields.put("none_bl_in_type", "nonBlInType");
		return this.hashFields;
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
	 * @return mstBlKnt
	 */
	public String getMstBlKnt() {
		return this.mstBlKnt;
	}

	/**
	 * Column Info
	 * @return cstmsDchgCd
	 */
	public String getCstmsDchgCd() {
		return this.cstmsDchgCd;
	}

	/**
	 * Column Info
	 * @return loclCstmsPrtCd
	 */
	public String getLoclCstmsPrtCd() {
		return this.loclCstmsPrtCd;
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
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
	}

	/**
	 * Column Info
	 * @return vslCallSgnCd
	 */
	public String getVslCallSgnCd() {
		return this.vslCallSgnCd;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}

	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}

	/**
	 * Column Info
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
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
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}

	/**
	 * Column Info
	 * @return dchgMzdCd
	 */
	public String getDchgMzdCd() {
		return this.dchgMzdCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return podTml
	 */
	public String getPodTml() {
		return this.podTml;
	}

	/**
	 * Column Info
	 * @return noneBlInType
	 */
	public String getNoneBlInType() {
		return this.noneBlInType;
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
	 * @param mstBlKnt
	 */
	public void setMstBlKnt(String mstBlKnt) {
		this.mstBlKnt = mstBlKnt;
	}

	/**
	 * Column Info
	 * @param cstmsDchgCd
	 */
	public void setCstmsDchgCd(String cstmsDchgCd) {
		this.cstmsDchgCd = cstmsDchgCd;
	}

	/**
	 * Column Info
	 * @param loclCstmsPrtCd
	 */
	public void setLoclCstmsPrtCd(String loclCstmsPrtCd) {
		this.loclCstmsPrtCd = loclCstmsPrtCd;
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
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
	}

	/**
	 * Column Info
	 * @param vslCallSgnCd
	 */
	public void setVslCallSgnCd(String vslCallSgnCd) {
		this.vslCallSgnCd = vslCallSgnCd;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}

	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}

	/**
	 * Column Info
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
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
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}

	/**
	 * Column Info
	 * @param dchgMzdCd
	 */
	public void setDchgMzdCd(String dchgMzdCd) {
		this.dchgMzdCd = dchgMzdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param podTml
	 */
	public void setPodTml(String podTml) {
		this.podTml = podTml;
	}

	/**
	 * Column Info
	 * @param noneBlInType
	 */
	public void setNoneBlInType(String noneBlInType) {
		this.noneBlInType = noneBlInType;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setMstBlKnt(JSPUtil.getParameter(request, "mst_bl_knt", ""));
		setCstmsDchgCd(JSPUtil.getParameter(request, "cstms_dchg_cd", ""));
		setLoclCstmsPrtCd(JSPUtil.getParameter(request, "locl_cstms_prt_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInType(JSPUtil.getParameter(request, "in_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, "vsl_call_sgn_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, "io_tml_loc_cd", ""));
		setLoclCstmsCd(JSPUtil.getParameter(request, "locl_cstms_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, "dchg_mzd_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setPodTml(JSPUtil.getParameter(request, "pod_tml", ""));
		setNoneBlInType(JSPUtil.getParameter(request, "none_bl_in_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDischManifestTransmitVO[]
	 */
	public KorDischManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorDischManifestTransmitVO[]
	 */
	public KorDischManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDischManifestTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] mstBlKnt = (JSPUtil.getParameter(request, prefix	+ "mst_bl_knt", length));
			String[] cstmsDchgCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_cd", length));
			String[] loclCstmsPrtCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_prt_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] loclCstmsCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
			String[] noneBlInType = (JSPUtil.getParameter(request, prefix	+ "none_bl_in_type", length));

			for (int i = 0; i < length; i++) {
				model = new KorDischManifestTransmitVO();
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (mstBlKnt[i] != null)
					model.setMstBlKnt(mstBlKnt[i]);
				if (cstmsDchgCd[i] != null)
					model.setCstmsDchgCd(cstmsDchgCd[i]);
				if (loclCstmsPrtCd[i] != null)
					model.setLoclCstmsPrtCd(loclCstmsPrtCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (loclCstmsCd[i] != null)
					model.setLoclCstmsCd(loclCstmsCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (podTml[i] != null)
					model.setPodTml(podTml[i]);
				if (noneBlInType[i] != null)
					model.setNoneBlInType(noneBlInType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDischManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDischManifestTransmitVO[]
	 */
	public KorDischManifestTransmitVO[] getKorDischManifestTransmitVOs(){
		KorDischManifestTransmitVO[] vos = (KorDischManifestTransmitVO[])models.toArray(new KorDischManifestTransmitVO[models.size()]);
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
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlKnt = this.mstBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgCd = this.cstmsDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsPrtCd = this.loclCstmsPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsCd = this.loclCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noneBlInType = this.noneBlInType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
