/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCancelManifestTransmitVO.java
*@FileTitle : KorCancelManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.05.13 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CancelManifestTransmitVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see CancelManifestTransmitVO
 */

public class KorCancelManifestTransmitVO extends CancelManifestTransmitVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorCancelManifestTransmitVO> models = new ArrayList<KorCancelManifestTransmitVO>();

	/* Column Info */
	private String ttlMeasUtCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String callYear = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
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
	private String ioTmlLocCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String ttlMeasQty = null;
	/* Column Info */
	private String ttlPckUtCd = null;
	/* Column Info */
	private String ktPa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCancelManifestTransmitVO() {}

	public KorCancelManifestTransmitVO(String ibflag, String pagerows, String blNo, String vvd, String ktPa, String polCd, String podCd, String ioBndCd, String ttlMeasQty, String ttlMeasUtCd, String ttlWgt, String ttlPckUtCd, String bdAreaCd, String ioTmlLocCd, String dchgMzdCd, String vslNm, String vslCntCd, String mrnNo, String vslCallSgnCd, String callKnt, String callYear, String userId, String ofcCd, String portCd, String bkgNo, String cstmsDeclTpCd, String inType) {
		this.ttlMeasUtCd = ttlMeasUtCd;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.callYear = callYear;
		this.inType = inType;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.userId = userId;
		this.callKnt = callKnt;
		this.vslCallSgnCd = vslCallSgnCd;
		this.portCd = portCd;
		this.vslCntCd = vslCntCd;
		this.ioTmlLocCd = ioTmlLocCd;
		this.vslNm = vslNm;
		this.bdAreaCd = bdAreaCd;
		this.ioBndCd = ioBndCd;
		this.dchgMzdCd = dchgMzdCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.ttlWgt = ttlWgt;
		this.ttlMeasQty = ttlMeasQty;
		this.ttlPckUtCd = ttlPckUtCd;
		this.ktPa = ktPa;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_meas_ut_cd", getTtlMeasUtCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("call_year", getCallYear());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("ttl_meas_qty", getTtlMeasQty());
		this.hashColumns.put("ttl_pck_ut_cd", getTtlPckUtCd());
		this.hashColumns.put("kt_pa", getKtPa());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_meas_ut_cd", "ttlMeasUtCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("call_year", "callYear");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("ttl_meas_qty", "ttlMeasQty");
		this.hashFields.put("ttl_pck_ut_cd", "ttlPckUtCd");
		this.hashFields.put("kt_pa", "ktPa");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ttlMeasUtCd
	 */
	public String getTtlMeasUtCd() {
		return this.ttlMeasUtCd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return callYear
	 */
	public String getCallYear() {
		return this.callYear;
	}

	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
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
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
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
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
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
	 * @return dchgMzdCd
	 */
	public String getDchgMzdCd() {
		return this.dchgMzdCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return ttlWgt
	 */
	public String getTtlWgt() {
		return this.ttlWgt;
	}

	/**
	 * Column Info
	 * @return ttlMeasQty
	 */
	public String getTtlMeasQty() {
		return this.ttlMeasQty;
	}

	/**
	 * Column Info
	 * @return ttlPckUtCd
	 */
	public String getTtlPckUtCd() {
		return this.ttlPckUtCd;
	}

	/**
	 * Column Info
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
	}


	/**
	 * Column Info
	 * @param ttlMeasUtCd
	 */
	public void setTtlMeasUtCd(String ttlMeasUtCd) {
		this.ttlMeasUtCd = ttlMeasUtCd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param callYear
	 */
	public void setCallYear(String callYear) {
		this.callYear = callYear;
	}

	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
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
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
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
	 * @param dchgMzdCd
	 */
	public void setDchgMzdCd(String dchgMzdCd) {
		this.dchgMzdCd = dchgMzdCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param ttlWgt
	 */
	public void setTtlWgt(String ttlWgt) {
		this.ttlWgt = ttlWgt;
	}

	/**
	 * Column Info
	 * @param ttlMeasQty
	 */
	public void setTtlMeasQty(String ttlMeasQty) {
		this.ttlMeasQty = ttlMeasQty;
	}

	/**
	 * Column Info
	 * @param ttlPckUtCd
	 */
	public void setTtlPckUtCd(String ttlPckUtCd) {
		this.ttlPckUtCd = ttlPckUtCd;
	}

	/**
	 * Column Info
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
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
		setTtlMeasUtCd(JSPUtil.getParameter(request, prefix + "ttl_meas_ut_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCallYear(JSPUtil.getParameter(request, prefix + "call_year", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, prefix + "call_knt", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, prefix + "vsl_call_sgn_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, prefix + "io_tml_loc_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setBdAreaCd(JSPUtil.getParameter(request, prefix + "bd_area_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, prefix + "dchg_mzd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTtlWgt(JSPUtil.getParameter(request, prefix + "ttl_wgt", ""));
		setTtlMeasQty(JSPUtil.getParameter(request, prefix + "ttl_meas_qty", ""));
		setTtlPckUtCd(JSPUtil.getParameter(request, prefix + "ttl_pck_ut_cd", ""));
		setKtPa(JSPUtil.getParameter(request, prefix + "kt_pa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCancelManifestTransmitVO[]
	 */
	public KorCancelManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCancelManifestTransmitVO[]
	 */
	public KorCancelManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCancelManifestTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ttlMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_ut_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] callYear = (JSPUtil.getParameter(request, prefix	+ "call_year", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] ttlMeasQty = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_qty", length));
			String[] ttlPckUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_ut_cd", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));

			for (int i = 0; i < length; i++) {
				model = new KorCancelManifestTransmitVO();
				if (ttlMeasUtCd[i] != null)
					model.setTtlMeasUtCd(ttlMeasUtCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (callYear[i] != null)
					model.setCallYear(callYear[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
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
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (ttlMeasQty[i] != null)
					model.setTtlMeasQty(ttlMeasQty[i]);
				if (ttlPckUtCd[i] != null)
					model.setTtlPckUtCd(ttlPckUtCd[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCancelManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCancelManifestTransmitVO[]
	 */
	public KorCancelManifestTransmitVO[] getKorCancelManifestTransmitVOs(){
		KorCancelManifestTransmitVO[] vos = (KorCancelManifestTransmitVO[])models.toArray(new KorCancelManifestTransmitVO[models.size()]);
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
		this.ttlMeasUtCd = this.ttlMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYear = this.callYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasQty = this.ttlMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckUtCd = this.ttlPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
