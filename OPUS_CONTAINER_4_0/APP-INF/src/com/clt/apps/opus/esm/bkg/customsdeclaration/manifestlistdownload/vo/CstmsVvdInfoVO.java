/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CstmsVvdInfoVO.java
*@FileTitle : CstmsVvdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.28 김민정
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsVvdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CstmsVvdInfoVO> models = new ArrayList<CstmsVvdInfoVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String preCrr = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String isCrnNo = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String checkFlag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String updCrn = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String uiNm = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CstmsVvdInfoVO() {}

	public CstmsVvdInfoVO(String ibflag, String pagerows, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String vvdCd, String crrCd, String vpsPortCd, String vpsEtaDt, String cvyRefNo, String updUsrId, String isCrnNo, String capNm, String etaDt, String uiNm, String checkFlag, String updCrn, String preCrr) {
		this.vslCd = vslCd;
		this.preCrr = preCrr;
		this.etaDt = etaDt;
		this.skdVoyNo = skdVoyNo;
		this.cvyRefNo = cvyRefNo;
		this.isCrnNo = isCrnNo;
		this.vpsEtaDt = vpsEtaDt;
		this.skdDirCd = skdDirCd;
		this.crrCd = crrCd;
		this.checkFlag = checkFlag;
		this.pagerows = pagerows;
		this.updCrn = updCrn;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.vvdCd = vvdCd;
		this.uiNm = uiNm;
		this.capNm = capNm;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pre_crr", getPreCrr());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("is_crn_no", getIsCrnNo());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("check_flag", getCheckFlag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_crn", getUpdCrn());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ui_nm", getUiNm());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pre_crr", "preCrr");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("is_crn_no", "isCrnNo");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("check_flag", "checkFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("upd_crn", "updCrn");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ui_nm", "uiNm");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return preCrr
	 */
	public String getPreCrr() {
		return this.preCrr;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return cvyRefNo
	 */
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}

	/**
	 * Column Info
	 * @return isCrnNo
	 */
	public String getIsCrnNo() {
		return this.isCrnNo;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}

	/**
	 * Column Info
	 * @return checkFlag
	 */
	public String getCheckFlag() {
		return this.checkFlag;
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
	 * @return updCrn
	 */
	public String getUpdCrn() {
		return this.updCrn;
	}

	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return uiNm
	 */
	public String getUiNm() {
		return this.uiNm;
	}

	/**
	 * Column Info
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * @param preCrr
	 */
	public void setPreCrr(String preCrr) {
		this.preCrr = preCrr;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * @param cvyRefNo
	 */
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
	}

	/**
	 * Column Info
	 * @param isCrnNo
	 */
	public void setIsCrnNo(String isCrnNo) {
		this.isCrnNo = isCrnNo;
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
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}

	/**
	 * Column Info
	 * @param checkFlag
	 */
	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
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
	 * @param updCrn
	 */
	public void setUpdCrn(String updCrn) {
		this.updCrn = updCrn;
	}

	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * @param uiNm
	 */
	public void setUiNm(String uiNm) {
		this.uiNm = uiNm;
	}

	/**
	 * Column Info
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}

	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPreCrr(JSPUtil.getParameter(request, prefix + "pre_crr", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
		setIsCrnNo(JSPUtil.getParameter(request, prefix + "is_crn_no", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setCheckFlag(JSPUtil.getParameter(request, prefix + "check_flag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUpdCrn(JSPUtil.getParameter(request, prefix + "upd_crn", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUiNm(JSPUtil.getParameter(request, prefix + "ui_nm", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsVvdInfoVO[]
	 */
	public CstmsVvdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CstmsVvdInfoVO[]
	 */
	public CstmsVvdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsVvdInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] preCrr = (JSPUtil.getParameter(request, prefix	+ "pre_crr", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no", length));
			String[] isCrnNo = (JSPUtil.getParameter(request, prefix	+ "is_crn_no", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] checkFlag = (JSPUtil.getParameter(request, prefix	+ "check_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] updCrn = (JSPUtil.getParameter(request, prefix	+ "upd_crn", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] uiNm = (JSPUtil.getParameter(request, prefix	+ "ui_nm", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new CstmsVvdInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (preCrr[i] != null)
					model.setPreCrr(preCrr[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (isCrnNo[i] != null)
					model.setIsCrnNo(isCrnNo[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (checkFlag[i] != null)
					model.setCheckFlag(checkFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (updCrn[i] != null)
					model.setUpdCrn(updCrn[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (uiNm[i] != null)
					model.setUiNm(uiNm[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsVvdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsVvdInfoVO[]
	 */
	public CstmsVvdInfoVO[] getCstmsVvdInfoVOs(){
		CstmsVvdInfoVO[] vos = (CstmsVvdInfoVO[])models.toArray(new CstmsVvdInfoVO[models.size()]);
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
		this.preCrr = this.preCrr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isCrnNo = this.isCrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkFlag = this.checkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updCrn = this.updCrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiNm = this.uiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
