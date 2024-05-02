/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCstmsVnSndLogVO.java
*@FileTitle : BkgCstmsVnSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier :
*@LastVersion : 1.0
* 2014.04.22
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo;

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

public class BkgCstmsVnSndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgCstmsVnSndLogVO> models = new ArrayList<BkgCstmsVnSndLogVO>();

	/* Column Info */
	private String toVslCd = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String vnMfSndIndCd = null;
	/* Column Info */
	private String toSkdVoyNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vnCstmsBndCd = null;
	/* Column Info */
	private String toSkdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public BkgCstmsVnSndLogVO() {}

	public BkgCstmsVnSndLogVO(String ibflag, String pagerows, String podCd, String vvd, String ofcCd, String bkgNo, String polCd, String usrId, String cntrNo, String fltFileRefNo, String vnCstmsBndCd, String vnMfSndIndCd, String toVslCd, String toSkdVoyNo, String toSkdDirCd) {
		this.toVslCd = toVslCd;
		this.fltFileRefNo = fltFileRefNo;
		this.vnMfSndIndCd = vnMfSndIndCd;
		this.toSkdVoyNo = toSkdVoyNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.usrId = usrId;
		this.cntrNo = cntrNo;
		this.vnCstmsBndCd = vnCstmsBndCd;
		this.toSkdDirCd = toSkdDirCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_vsl_cd", getToVslCd());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("vn_mf_snd_ind_cd", getVnMfSndIndCd());
		this.hashColumns.put("to_skd_voy_no", getToSkdVoyNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vn_cstms_bnd_cd", getVnCstmsBndCd());
		this.hashColumns.put("to_skd_dir_cd", getToSkdDirCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_vsl_cd", "toVslCd");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("vn_mf_snd_ind_cd", "vnMfSndIndCd");
		this.hashFields.put("to_skd_voy_no", "toSkdVoyNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vn_cstms_bnd_cd", "vnCstmsBndCd");
		this.hashFields.put("to_skd_dir_cd", "toSkdDirCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return toVslCd
	 */
	public String getToVslCd() {
		return this.toVslCd;
	}

	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}

	/**
	 * Column Info
	 * @return vnMfSndIndCd
	 */
	public String getVnMfSndIndCd() {
		return this.vnMfSndIndCd;
	}

	/**
	 * Column Info
	 * @return toSkdVoyNo
	 */
	public String getToSkdVoyNo() {
		return this.toSkdVoyNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return vnCstmsBndCd
	 */
	public String getVnCstmsBndCd() {
		return this.vnCstmsBndCd;
	}

	/**
	 * Column Info
	 * @return toSkdDirCd
	 */
	public String getToSkdDirCd() {
		return this.toSkdDirCd;
	}


	/**
	 * Column Info
	 * @param toVslCd
	 */
	public void setToVslCd(String toVslCd) {
		this.toVslCd = toVslCd;
	}

	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}

	/**
	 * Column Info
	 * @param vnMfSndIndCd
	 */
	public void setVnMfSndIndCd(String vnMfSndIndCd) {
		this.vnMfSndIndCd = vnMfSndIndCd;
	}

	/**
	 * Column Info
	 * @param toSkdVoyNo
	 */
	public void setToSkdVoyNo(String toSkdVoyNo) {
		this.toSkdVoyNo = toSkdVoyNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param vnCstmsBndCd
	 */
	public void setVnCstmsBndCd(String vnCstmsBndCd) {
		this.vnCstmsBndCd = vnCstmsBndCd;
	}

	/**
	 * Column Info
	 * @param toSkdDirCd
	 */
	public void setToSkdDirCd(String toSkdDirCd) {
		this.toSkdDirCd = toSkdDirCd;
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
		setToVslCd(JSPUtil.getParameter(request, prefix + "to_vsl_cd", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setVnMfSndIndCd(JSPUtil.getParameter(request, prefix + "vn_mf_snd_ind_cd", ""));
		setToSkdVoyNo(JSPUtil.getParameter(request, prefix + "to_skd_voy_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVnCstmsBndCd(JSPUtil.getParameter(request, prefix + "vn_cstms_bnd_cd", ""));
		setToSkdDirCd(JSPUtil.getParameter(request, prefix + "to_skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsVnSndLogVO[]
	 */
	public BkgCstmsVnSndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgCstmsVnSndLogVO[]
	 */
	public BkgCstmsVnSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsVnSndLogVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] toVslCd = (JSPUtil.getParameter(request, prefix	+ "to_vsl_cd", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] vnMfSndIndCd = (JSPUtil.getParameter(request, prefix	+ "vn_mf_snd_ind_cd", length));
			String[] toSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "to_skd_voy_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vnCstmsBndCd = (JSPUtil.getParameter(request, prefix	+ "vn_cstms_bnd_cd", length));
			String[] toSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "to_skd_dir_cd", length));

			for (int i = 0; i < length; i++) {
				model = new BkgCstmsVnSndLogVO();
				if (toVslCd[i] != null)
					model.setToVslCd(toVslCd[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (vnMfSndIndCd[i] != null)
					model.setVnMfSndIndCd(vnMfSndIndCd[i]);
				if (toSkdVoyNo[i] != null)
					model.setToSkdVoyNo(toSkdVoyNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vnCstmsBndCd[i] != null)
					model.setVnCstmsBndCd(vnCstmsBndCd[i]);
				if (toSkdDirCd[i] != null)
					model.setToSkdDirCd(toSkdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsVnSndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsVnSndLogVO[]
	 */
	public BkgCstmsVnSndLogVO[] getBkgCstmsVnSndLogVOs(){
		BkgCstmsVnSndLogVO[] vos = (BkgCstmsVnSndLogVO[])models.toArray(new BkgCstmsVnSndLogVO[models.size()]);
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
		this.toVslCd = this.toVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnMfSndIndCd = this.vnMfSndIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSkdVoyNo = this.toSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vnCstmsBndCd = this.vnCstmsBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSkdDirCd = this.toSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
