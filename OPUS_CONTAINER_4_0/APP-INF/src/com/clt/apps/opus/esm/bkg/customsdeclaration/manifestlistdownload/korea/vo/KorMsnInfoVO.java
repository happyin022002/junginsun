/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMsnInfoVO.java
*@FileTitle : KorMsnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.06 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMsnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorMsnInfoVO> models = new ArrayList<KorMsnInfoVO>();

	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String icdCstmLoc = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String discCd = null;
	/* Column Info */
	private String localTs = null;
	/* Column Info */
	private String updateChk = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String mfRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mrnChk = null;
	/* Column Info */
	private String cstmsClrLocCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String icdCstmTp = null;
	/* Column Info */
	private String icdCstmWh = null;
	/* Column Info */
	private String skdVoyageNo = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String cstmsClrWhCd = null;
	/* Column Info */
	private String blTp = null;
	private String userid = null;
	/* Column Info */
	private String cntBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorMsnInfoVO() {}

	public KorMsnInfoVO(String ibflag, String pagerows, String localTs, String vslCd, String skdVoyageNo, String skdDirCd, String polCd, String podCd, String podYdCd, String vpsEtdDt, String vpsEtaDt, String mrnNbr, String cstmsDchgLocWhCd, String icdCstmLoc, String discCd, String mfRefNo, String cstmsClrLocCd, String mrnChk, String bkgNo, String cstmsClrTpCd, String icdCstmWh, String icdCstmTp, String cstmsClrWhCd, String updateChk, String blTp, String userid, String vvd, String cntBlNo) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.vslCd = vslCd;
		this.icdCstmLoc = icdCstmLoc;
		this.vpsEtdDt = vpsEtdDt;
		this.discCd = discCd;
		this.localTs = localTs;
		this.updateChk = updateChk;
		this.vpsEtaDt = vpsEtaDt;
		this.skdDirCd = skdDirCd;
		this.mfRefNo = mfRefNo;
		this.pagerows = pagerows;
		this.mrnChk = mrnChk;
		this.cstmsClrLocCd = cstmsClrLocCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.icdCstmTp = icdCstmTp;
		this.icdCstmWh = icdCstmWh;
		this.skdVoyageNo = skdVoyageNo;
		this.mrnNbr = mrnNbr;
		this.podYdCd = podYdCd;
		this.cstmsClrWhCd = cstmsClrWhCd;
		this.blTp = blTp;
		this.userid = userid;
		this.vvd = vvd;
		this.cntBlNo = cntBlNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("icd_cstm_loc", getIcdCstmLoc());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("disc_cd", getDiscCd());
		this.hashColumns.put("local_ts", getLocalTs());
		this.hashColumns.put("update_chk", getUpdateChk());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("mf_ref_no", getMfRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mrn_chk", getMrnChk());
		this.hashColumns.put("cstms_clr_loc_cd", getCstmsClrLocCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("icd_cstm_tp", getIcdCstmTp());
		this.hashColumns.put("icd_cstm_wh", getIcdCstmWh());
		this.hashColumns.put("skd_voyage_no", getSkdVoyageNo());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("cstms_clr_wh_cd", getCstmsClrWhCd());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("userid", getUserid());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cnt_bl_no", getCntBlNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("icd_cstm_loc", "icdCstmLoc");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("disc_cd", "discCd");
		this.hashFields.put("local_ts", "localTs");
		this.hashFields.put("update_chk", "updateChk");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("mf_ref_no", "mfRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mrn_chk", "mrnChk");
		this.hashFields.put("cstms_clr_loc_cd", "cstmsClrLocCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("icd_cstm_tp", "icdCstmTp");
		this.hashFields.put("icd_cstm_wh", "icdCstmWh");
		this.hashFields.put("skd_voyage_no", "skdVoyageNo");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("cstms_clr_wh_cd", "cstmsClrWhCd");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("userid", "userid");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cnt_bl_no", "cntBlNo");
		return this.hashFields;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @return the cntBlNo
	 */
	public String getCntBlNo() {
		return cntBlNo;
	}

	/**
	 * @param cntBlNo the cntBlNo to set
	 */
	public void setCntBlNo(String cntBlNo) {
		this.cntBlNo = cntBlNo;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the blTp
	 */
	public String getBlTp() {
		return blTp;
	}

	/**
	 * @param blTp the blTp to set
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}

	/**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
	public String getCstmsDchgLocWhCd() {
		return this.cstmsDchgLocWhCd;
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
	 * @return icdCstmLoc
	 */
	public String getIcdCstmLoc() {
		return this.icdCstmLoc;
	}

	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}

	/**
	 * Column Info
	 * @return discCd
	 */
	public String getDiscCd() {
		return this.discCd;
	}

	/**
	 * Column Info
	 * @return localTs
	 */
	public String getLocalTs() {
		return this.localTs;
	}

	/**
	 * Column Info
	 * @return updateChk
	 */
	public String getUpdateChk() {
		return this.updateChk;
	}

	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return mfRefNo
	 */
	public String getMfRefNo() {
		return this.mfRefNo;
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
	 * @return mrnChk
	 */
	public String getMrnChk() {
		return this.mrnChk;
	}

	/**
	 * Column Info
	 * @return cstmsClrLocCd
	 */
	public String getCstmsClrLocCd() {
		return this.cstmsClrLocCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}

	/**
	 * Column Info
	 * @return icdCstmTp
	 */
	public String getIcdCstmTp() {
		return this.icdCstmTp;
	}

	/**
	 * Column Info
	 * @return icdCstmWh
	 */
	public String getIcdCstmWh() {
		return this.icdCstmWh;
	}

	/**
	 * Column Info
	 * @return skdVoyageNo
	 */
	public String getSkdVoyageNo() {
		return this.skdVoyageNo;
	}

	/**
	 * Column Info
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
	}

	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}

	/**
	 * Column Info
	 * @return cstmsClrWhCd
	 */
	public String getCstmsClrWhCd() {
		return this.cstmsClrWhCd;
	}


	/**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
	public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
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
	 * @param icdCstmLoc
	 */
	public void setIcdCstmLoc(String icdCstmLoc) {
		this.icdCstmLoc = icdCstmLoc;
	}

	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}

	/**
	 * Column Info
	 * @param discCd
	 */
	public void setDiscCd(String discCd) {
		this.discCd = discCd;
	}

	/**
	 * Column Info
	 * @param localTs
	 */
	public void setLocalTs(String localTs) {
		this.localTs = localTs;
	}

	/**
	 * Column Info
	 * @param updateChk
	 */
	public void setUpdateChk(String updateChk) {
		this.updateChk = updateChk;
	}

	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param mfRefNo
	 */
	public void setMfRefNo(String mfRefNo) {
		this.mfRefNo = mfRefNo;
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
	 * @param mrnChk
	 */
	public void setMrnChk(String mrnChk) {
		this.mrnChk = mrnChk;
	}

	/**
	 * Column Info
	 * @param cstmsClrLocCd
	 */
	public void setCstmsClrLocCd(String cstmsClrLocCd) {
		this.cstmsClrLocCd = cstmsClrLocCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}

	/**
	 * Column Info
	 * @param icdCstmTp
	 */
	public void setIcdCstmTp(String icdCstmTp) {
		this.icdCstmTp = icdCstmTp;
	}

	/**
	 * Column Info
	 * @param icdCstmWh
	 */
	public void setIcdCstmWh(String icdCstmWh) {
		this.icdCstmWh = icdCstmWh;
	}

	/**
	 * Column Info
	 * @param skdVoyageNo
	 */
	public void setSkdVoyageNo(String skdVoyageNo) {
		this.skdVoyageNo = skdVoyageNo;
	}

	/**
	 * Column Info
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
	}

	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}

	/**
	 * Column Info
	 * @param cstmsClrWhCd
	 */
	public void setCstmsClrWhCd(String cstmsClrWhCd) {
		this.cstmsClrWhCd = cstmsClrWhCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmsDchgLocWhCd(JSPUtil.getParameter(request, "cstms_dchg_loc_wh_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIcdCstmLoc(JSPUtil.getParameter(request, "icd_cstm_loc", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setDiscCd(JSPUtil.getParameter(request, "disc_cd", ""));
		setLocalTs(JSPUtil.getParameter(request, "local_ts", ""));
		setUpdateChk(JSPUtil.getParameter(request, "update_chk", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setMfRefNo(JSPUtil.getParameter(request, "mf_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMrnChk(JSPUtil.getParameter(request, "mrn_chk", ""));
		setCstmsClrLocCd(JSPUtil.getParameter(request, "cstms_clr_loc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, "cstms_clr_tp_cd", ""));
		setIcdCstmTp(JSPUtil.getParameter(request, "icd_cstm_tp", ""));
		setIcdCstmWh(JSPUtil.getParameter(request, "icd_cstm_wh", ""));
		setSkdVoyageNo(JSPUtil.getParameter(request, "skd_voyage_no", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setCstmsClrWhCd(JSPUtil.getParameter(request, "cstms_clr_wh_cd", ""));
		setBlTp(JSPUtil.getParameter(request, "bl_tp", ""));
		setUserid(JSPUtil.getParameter(request, "userid", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCntBlNo(JSPUtil.getParameter(request, "cnt_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMsnInfoVO[]
	 */
	public KorMsnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorMsnInfoVO[]
	 */
	public KorMsnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMsnInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] icdCstmLoc = (JSPUtil.getParameter(request, prefix	+ "icd_cstm_loc", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] discCd = (JSPUtil.getParameter(request, prefix	+ "disc_cd", length));
			String[] localTs = (JSPUtil.getParameter(request, prefix	+ "local_ts", length));
			String[] updateChk = (JSPUtil.getParameter(request, prefix	+ "update_chk", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] mfRefNo = (JSPUtil.getParameter(request, prefix	+ "mf_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mrnChk = (JSPUtil.getParameter(request, prefix	+ "mrn_chk", length));
			String[] cstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_loc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] icdCstmTp = (JSPUtil.getParameter(request, prefix	+ "icd_cstm_tp", length));
			String[] icdCstmWh = (JSPUtil.getParameter(request, prefix	+ "icd_cstm_wh", length));
			String[] skdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "skd_voyage_no", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] cstmsClrWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_wh_cd", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] userid = (JSPUtil.getParameter(request, prefix	+ "userid", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] cntBlNo = (JSPUtil.getParameter(request, prefix	+ "cnt_bl_no", length));

			for (int i = 0; i < length; i++) {
				model = new KorMsnInfoVO();
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (icdCstmLoc[i] != null)
					model.setIcdCstmLoc(icdCstmLoc[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (discCd[i] != null)
					model.setDiscCd(discCd[i]);
				if (localTs[i] != null)
					model.setLocalTs(localTs[i]);
				if (updateChk[i] != null)
					model.setUpdateChk(updateChk[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (mfRefNo[i] != null)
					model.setMfRefNo(mfRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mrnChk[i] != null)
					model.setMrnChk(mrnChk[i]);
				if (cstmsClrLocCd[i] != null)
					model.setCstmsClrLocCd(cstmsClrLocCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (icdCstmTp[i] != null)
					model.setIcdCstmTp(icdCstmTp[i]);
				if (icdCstmWh[i] != null)
					model.setIcdCstmWh(icdCstmWh[i]);
				if (skdVoyageNo[i] != null)
					model.setSkdVoyageNo(skdVoyageNo[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (cstmsClrWhCd[i] != null)
					model.setCstmsClrWhCd(cstmsClrWhCd[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (userid[i] != null)
					model.setUserid(userid[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (cntBlNo[i] != null)
					model.setCntBlNo(cntBlNo[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMsnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMsnInfoVO[]
	 */
	public KorMsnInfoVO[] getKorMsnInfoVOs(){
		KorMsnInfoVO[] vos = (KorMsnInfoVO[])models.toArray(new KorMsnInfoVO[models.size()]);
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
		this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icdCstmLoc = this.icdCstmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discCd = this.discCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTs = this.localTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateChk = this.updateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRefNo = this.mfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChk = this.mrnChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrLocCd = this.cstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icdCstmTp = this.icdCstmTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icdCstmWh = this.icdCstmWh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyageNo = this.skdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrWhCd = this.cstmsClrWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userid = this.userid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntBlNo = this.cntBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
