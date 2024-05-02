/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnDetailBasicbyBlVO.java
*@FileTitle : FFCmpnDetailBasicbyBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.16 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FFCmpnDetailBasicbyBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FFCmpnDetailBasicbyBlVO> models = new ArrayList<FFCmpnDetailBasicbyBlVO>();

	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ffNm = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String fmcNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String ffRefNo = null;
	/* Column Info */
	private String ffKndCd = null;
	/* Column Info */
	private String vslDepDt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String commVsl = null;
	/* Column Info */
	private String vndrCntSeq = null;
	/* Column Info */
	private String shprCntSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FFCmpnDetailBasicbyBlVO() {}

	public FFCmpnDetailBasicbyBlVO(String ibflag, String pagerows, String vslDepDt, String bkgNo, String blNo, String shprCntSeq, String shprNm, String ffCntSeq, String vndrCntSeq, String ffNm, String commVsl, String porCd, String polCd, String podCd, String delCd, String ffRefNo, String fmcNo, String scRfaNo, String ffKndCd) {
		this.porCd = porCd;
		this.delCd = delCd;
		this.blNo = blNo;
		this.ffNm = ffNm;
		this.ffCntSeq = ffCntSeq;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.fmcNo = fmcNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.scRfaNo = scRfaNo;
		this.ffRefNo = ffRefNo;
		this.ffKndCd = ffKndCd;
		this.vslDepDt = vslDepDt;
		this.shprNm = shprNm;
		this.commVsl = commVsl;
		this.vndrCntSeq = vndrCntSeq;
		this.shprCntSeq = shprCntSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ff_nm", getFfNm());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("ff_ref_no", getFfRefNo());
		this.hashColumns.put("ff_knd_cd", getFfKndCd());
		this.hashColumns.put("vsl_dep_dt", getVslDepDt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("comm_vsl", getCommVsl());
		this.hashColumns.put("vndr_cnt_seq", getVndrCntSeq());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ff_nm", "ffNm");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("ff_ref_no", "ffRefNo");
		this.hashFields.put("ff_knd_cd", "ffKndCd");
		this.hashFields.put("vsl_dep_dt", "vslDepDt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("comm_vsl", "commVsl");
		this.hashFields.put("vndr_cnt_seq", "vndrCntSeq");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return ffNm
	 */
	public String getFfNm() {
		return this.ffNm;
	}

	/**
	 * Column Info
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
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
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}

	/**
	 * Column Info
	 * @return ffRefNo
	 */
	public String getFfRefNo() {
		return this.ffRefNo;
	}

	/**
	 * Column Info
	 * @return ffKndCd
	 */
	public String getFfKndCd() {
		return this.ffKndCd;
	}

	/**
	 * Column Info
	 * @return vslDepDt
	 */
	public String getVslDepDt() {
		return this.vslDepDt;
	}

	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}

	/**
	 * Column Info
	 * @return commVsl
	 */
	public String getCommVsl() {
		return this.commVsl;
	}

	/**
	 * Column Info
	 * @return vndrCntSeq
	 */
	public String getVndrCntSeq() {
		return this.vndrCntSeq;
	}

	/**
	 * Column Info
	 * @return shprCntSeq
	 */
	public String getShprCntSeq() {
		return this.shprCntSeq;
	}


	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param ffNm
	 */
	public void setFfNm(String ffNm) {
		this.ffNm = ffNm;
	}

	/**
	 * Column Info
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
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
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}

	/**
	 * Column Info
	 * @param ffRefNo
	 */
	public void setFfRefNo(String ffRefNo) {
		this.ffRefNo = ffRefNo;
	}

	/**
	 * Column Info
	 * @param ffKndCd
	 */
	public void setFfKndCd(String ffKndCd) {
		this.ffKndCd = ffKndCd;
	}

	/**
	 * Column Info
	 * @param vslDepDt
	 */
	public void setVslDepDt(String vslDepDt) {
		this.vslDepDt = vslDepDt;
	}

	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}

	/**
	 * Column Info
	 * @param commVsl
	 */
	public void setCommVsl(String commVsl) {
		this.commVsl = commVsl;
	}

	/**
	 * Column Info
	 * @param vndrCntSeq
	 */
	public void setVndrCntSeq(String vndrCntSeq) {
		this.vndrCntSeq = vndrCntSeq;
	}

	/**
	 * Column Info
	 * @param shprCntSeq
	 */
	public void setShprCntSeq(String shprCntSeq) {
		this.shprCntSeq = shprCntSeq;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFfNm(JSPUtil.getParameter(request, prefix + "ff_nm", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setFfRefNo(JSPUtil.getParameter(request, prefix + "ff_ref_no", ""));
		setFfKndCd(JSPUtil.getParameter(request, prefix + "ff_knd_cd", ""));
		setVslDepDt(JSPUtil.getParameter(request, prefix + "vsl_dep_dt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setCommVsl(JSPUtil.getParameter(request, prefix + "comm_vsl", ""));
		setVndrCntSeq(JSPUtil.getParameter(request, prefix + "vndr_cnt_seq", ""));
		setShprCntSeq(JSPUtil.getParameter(request, prefix + "shpr_cnt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnDetailBasicbyBlVO[]
	 */
	public FFCmpnDetailBasicbyBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FFCmpnDetailBasicbyBlVO[]
	 */
	public FFCmpnDetailBasicbyBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnDetailBasicbyBlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ffNm = (JSPUtil.getParameter(request, prefix	+ "ff_nm", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] ffRefNo = (JSPUtil.getParameter(request, prefix	+ "ff_ref_no", length));
			String[] ffKndCd = (JSPUtil.getParameter(request, prefix	+ "ff_knd_cd", length));
			String[] vslDepDt = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_dt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] commVsl = (JSPUtil.getParameter(request, prefix	+ "comm_vsl", length));
			String[] vndrCntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_seq", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));

			for (int i = 0; i < length; i++) {
				model = new FFCmpnDetailBasicbyBlVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ffNm[i] != null)
					model.setFfNm(ffNm[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (ffRefNo[i] != null)
					model.setFfRefNo(ffRefNo[i]);
				if (ffKndCd[i] != null)
					model.setFfKndCd(ffKndCd[i]);
				if (vslDepDt[i] != null)
					model.setVslDepDt(vslDepDt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (commVsl[i] != null)
					model.setCommVsl(commVsl[i]);
				if (vndrCntSeq[i] != null)
					model.setVndrCntSeq(vndrCntSeq[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnDetailBasicbyBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnDetailBasicbyBlVO[]
	 */
	public FFCmpnDetailBasicbyBlVO[] getFFCmpnDetailBasicbyBlVOs(){
		FFCmpnDetailBasicbyBlVO[] vos = (FFCmpnDetailBasicbyBlVO[])models.toArray(new FFCmpnDetailBasicbyBlVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffNm = this.ffNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRefNo = this.ffRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffKndCd = this.ffKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepDt = this.vslDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVsl = this.commVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntSeq = this.vndrCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
