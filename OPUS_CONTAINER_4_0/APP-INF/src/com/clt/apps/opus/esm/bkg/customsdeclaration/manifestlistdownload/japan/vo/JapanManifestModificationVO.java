/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestModificationVO.java
*@FileTitle : JapanManifestModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier :
*@LastVersion : 1.0
* 2016.03.29
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class JapanManifestModificationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<JapanManifestModificationVO> models = new ArrayList<JapanManifestModificationVO>();

	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inCallSgnNo = null;
	/* Column Info */
	private String inCyOprCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blNumber = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bdTr = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String vvdPolCd = null;
	/* Column Info */
	private String inVpsEtaDt = null;
	/* Column Info */
	private String inPodSplitCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inVoyageNo = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String podBnd = null;
	/* Column Info */
	private String delBnd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public JapanManifestModificationVO() {}

	public JapanManifestModificationVO(String ibflag, String pagerows, String aproNo, String bdTr, String bkgNo, String blNo, String blNumber, String blSplitNo, String creUsrId, String delBnd, String inCallSgnNo, String inCyOprCd, String inPodCd, String inPodSplitCd, String inSkdDirCd, String inSkdVoyNo, String inVoyageNo, String inVpsEtaDt, String inVslCd, String inVvdCd, String podBnd, String bkgPolCd, String vvdPolCd, String trspModCd, String updUsrId) {
		this.inSkdDirCd = inSkdDirCd;
		this.inCallSgnNo = inCallSgnNo;
		this.inCyOprCd = inCyOprCd;
		this.blNo = blNo;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.blNumber = blNumber;
		this.ibflag = ibflag;
		this.bdTr = bdTr;
		this.inPodCd = inPodCd;
		this.blSplitNo = blSplitNo;
		this.updUsrId = updUsrId;
		this.bkgPolCd = bkgPolCd;
		this.aproNo = aproNo;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inVslCd = inVslCd;
		this.vvdPolCd = vvdPolCd;
		this.inVpsEtaDt = inVpsEtaDt;
		this.inPodSplitCd = inPodSplitCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.inVoyageNo = inVoyageNo;
		this.inVvdCd = inVvdCd;
		this.podBnd = podBnd;
		this.delBnd = delBnd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_call_sgn_no", getInCallSgnNo());
		this.hashColumns.put("in_cy_opr_cd", getInCyOprCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_number", getBlNumber());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bd_tr", getBdTr());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("vvd_pol_cd", getVvdPolCd());
		this.hashColumns.put("in_vps_eta_dt", getInVpsEtaDt());
		this.hashColumns.put("in_pod_split_cd", getInPodSplitCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_voyage_no", getInVoyageNo());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("pod_bnd", getPodBnd());
		this.hashColumns.put("del_bnd", getDelBnd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_call_sgn_no", "inCallSgnNo");
		this.hashFields.put("in_cy_opr_cd", "inCyOprCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_number", "blNumber");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bd_tr", "bdTr");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("vvd_pol_cd", "vvdPolCd");
		this.hashFields.put("in_vps_eta_dt", "inVpsEtaDt");
		this.hashFields.put("in_pod_split_cd", "inPodSplitCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_voyage_no", "inVoyageNo");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("pod_bnd", "podBnd");
		this.hashFields.put("del_bnd", "delBnd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}

	/**
	 * Column Info
	 * @return inCallSgnNo
	 */
	public String getInCallSgnNo() {
		return this.inCallSgnNo;
	}

	/**
	 * Column Info
	 * @return inCyOprCd
	 */
	public String getInCyOprCd() {
		return this.inCyOprCd;
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
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return blNumber
	 */
	public String getBlNumber() {
		return this.blNumber;
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
	 * @return bdTr
	 */
	public String getBdTr() {
		return this.bdTr;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
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
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}

	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
	}

	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}

	/**
	 * Column Info
	 * @return vvdPolCd
	 */
	public String getVvdPolCd() {
		return this.vvdPolCd;
	}

	/**
	 * Column Info
	 * @return inVpsEtaDt
	 */
	public String getInVpsEtaDt() {
		return this.inVpsEtaDt;
	}

	/**
	 * Column Info
	 * @return inPodSplitCd
	 */
	public String getInPodSplitCd() {
		return this.inPodSplitCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return inVoyageNo
	 */
	public String getInVoyageNo() {
		return this.inVoyageNo;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return podBnd
	 */
	public String getPodBnd() {
		return this.podBnd;
	}

	/**
	 * Column Info
	 * @return delBnd
	 */
	public String getDelBnd() {
		return this.delBnd;
	}


	/**
	 * Column Info
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}

	/**
	 * Column Info
	 * @param inCallSgnNo
	 */
	public void setInCallSgnNo(String inCallSgnNo) {
		this.inCallSgnNo = inCallSgnNo;
	}

	/**
	 * Column Info
	 * @param inCyOprCd
	 */
	public void setInCyOprCd(String inCyOprCd) {
		this.inCyOprCd = inCyOprCd;
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
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param blNumber
	 */
	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
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
	 * @param bdTr
	 */
	public void setBdTr(String bdTr) {
		this.bdTr = bdTr;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
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
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}

	/**
	 * Column Info
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
	}

	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}

	/**
	 * Column Info
	 * @param vvdPolCd
	 */
	public void setVvdPolCd(String vvdPolCd) {
		this.vvdPolCd = vvdPolCd;
	}

	/**
	 * Column Info
	 * @param inVpsEtaDt
	 */
	public void setInVpsEtaDt(String inVpsEtaDt) {
		this.inVpsEtaDt = inVpsEtaDt;
	}

	/**
	 * Column Info
	 * @param inPodSplitCd
	 */
	public void setInPodSplitCd(String inPodSplitCd) {
		this.inPodSplitCd = inPodSplitCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param inVoyageNo
	 */
	public void setInVoyageNo(String inVoyageNo) {
		this.inVoyageNo = inVoyageNo;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param podBnd
	 */
	public void setPodBnd(String podBnd) {
		this.podBnd = podBnd;
	}

	/**
	 * Column Info
	 * @param delBnd
	 */
	public void setDelBnd(String delBnd) {
		this.delBnd = delBnd;
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
		setInSkdDirCd(JSPUtil.getParameter(request, prefix + "in_skd_dir_cd", ""));
		setInCallSgnNo(JSPUtil.getParameter(request, prefix + "in_call_sgn_no", ""));
		setInCyOprCd(JSPUtil.getParameter(request, prefix + "in_cy_opr_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlNumber(JSPUtil.getParameter(request, prefix + "bl_number", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBdTr(JSPUtil.getParameter(request, prefix + "bd_tr", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, prefix + "in_skd_voy_no", ""));
		setInVslCd(JSPUtil.getParameter(request, prefix + "in_vsl_cd", ""));
		setVvdPolCd(JSPUtil.getParameter(request, prefix + "vvd_pol_cd", ""));
		setInVpsEtaDt(JSPUtil.getParameter(request, prefix + "in_vps_eta_dt", ""));
		setInPodSplitCd(JSPUtil.getParameter(request, prefix + "in_pod_split_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInVoyageNo(JSPUtil.getParameter(request, prefix + "in_voyage_no", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setPodBnd(JSPUtil.getParameter(request, prefix + "pod_bnd", ""));
		setDelBnd(JSPUtil.getParameter(request, prefix + "del_bnd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestModificationVO[]
	 */
	public JapanManifestModificationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return JapanManifestModificationVO[]
	 */
	public JapanManifestModificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestModificationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "in_call_sgn_no", length));
			String[] inCyOprCd = (JSPUtil.getParameter(request, prefix	+ "in_cy_opr_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNumber = (JSPUtil.getParameter(request, prefix	+ "bl_number", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bdTr = (JSPUtil.getParameter(request, prefix	+ "bd_tr", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] vvdPolCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_cd", length));
			String[] inVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "in_vps_eta_dt", length));
			String[] inPodSplitCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_split_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inVoyageNo = (JSPUtil.getParameter(request, prefix	+ "in_voyage_no", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] podBnd = (JSPUtil.getParameter(request, prefix	+ "pod_bnd", length));
			String[] delBnd = (JSPUtil.getParameter(request, prefix	+ "del_bnd", length));

			for (int i = 0; i < length; i++) {
				model = new JapanManifestModificationVO();
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inCallSgnNo[i] != null)
					model.setInCallSgnNo(inCallSgnNo[i]);
				if (inCyOprCd[i] != null)
					model.setInCyOprCd(inCyOprCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNumber[i] != null)
					model.setBlNumber(blNumber[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bdTr[i] != null)
					model.setBdTr(bdTr[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (vvdPolCd[i] != null)
					model.setVvdPolCd(vvdPolCd[i]);
				if (inVpsEtaDt[i] != null)
					model.setInVpsEtaDt(inVpsEtaDt[i]);
				if (inPodSplitCd[i] != null)
					model.setInPodSplitCd(inPodSplitCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inVoyageNo[i] != null)
					model.setInVoyageNo(inVoyageNo[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (podBnd[i] != null)
					model.setPodBnd(podBnd[i]);
				if (delBnd[i] != null)
					model.setDelBnd(delBnd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestModificationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestModificationVO[]
	 */
	public JapanManifestModificationVO[] getJapanManifestModificationVOs(){
		JapanManifestModificationVO[] vos = (JapanManifestModificationVO[])models.toArray(new JapanManifestModificationVO[models.size()]);
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
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCallSgnNo = this.inCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCyOprCd = this.inCyOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNumber = this.blNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdTr = this.bdTr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolCd = this.vvdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVpsEtaDt = this.inVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodSplitCd = this.inPodSplitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVoyageNo = this.inVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBnd = this.podBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delBnd = this.delBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
