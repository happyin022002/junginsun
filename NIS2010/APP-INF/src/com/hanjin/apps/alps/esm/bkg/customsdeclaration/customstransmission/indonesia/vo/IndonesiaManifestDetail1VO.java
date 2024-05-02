/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaManifestDetail1VO.java
*@FileTitle : IndonesiaManifestDetail1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.30 민동진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndonesiaManifestDetail1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndonesiaManifestDetail1VO> models = new ArrayList<IndonesiaManifestDetail1VO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String dtlVslEngNm = null;
	/* Column Info */
	private String dtlCallSgnNo = null;
	/* Column Info */
	private String dtlVslCd = null;
	/* Column Info */
	private String dtlSkdVoyNo = null;
	/* Column Info */
	private String dtlSkdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndonesiaManifestDetail1VO() {}

	public IndonesiaManifestDetail1VO(String ibflag, String pagerows, String bkgNo, String blNo, String porCd, String polCd, String podCd, String delCd, String oblIssDt, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String dtlVslEngNm, String dtlCallSgnNo, String dtlVslCd, String dtlSkdVoyNo, String dtlSkdDirCd) {
		this.porCd = porCd;
		this.oblIssDt = oblIssDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.delCd = delCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.dtlVslEngNm = dtlVslEngNm;
		this.dtlCallSgnNo = dtlCallSgnNo;
		this.dtlVslCd = dtlVslCd;
		this.dtlSkdVoyNo = dtlSkdVoyNo;
		this.dtlSkdDirCd = dtlSkdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("dtl_vsl_eng_nm", getDtlVslEngNm());
		this.hashColumns.put("dtl_call_sgn_no", getDtlCallSgnNo());
		this.hashColumns.put("dtl_vsl_cd", getDtlVslCd());
		this.hashColumns.put("dtl_skd_voy_no", getDtlSkdVoyNo());
		this.hashColumns.put("dtl_skd_dir_cd", getDtlSkdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("dtl_vsl_eng_nm", "dtlVslEngNm");
		this.hashFields.put("dtl_call_sgn_no", "dtlCallSgnNo");
		this.hashFields.put("dtl_vsl_cd", "dtlVslCd");
		this.hashFields.put("dtl_skd_voy_no", "dtlSkdVoyNo");
		this.hashFields.put("dtl_skd_dir_cd", "dtlSkdDirCd");
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
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return dtlVslEngNm
	 */
	public String getDtlVslEngNm() {
		return this.dtlVslEngNm;
	}
	
	/**
	 * Column Info
	 * @return dtlCallSgnNo
	 */
	public String getDtlCallSgnNo() {
		return this.dtlCallSgnNo;
	}
	
	/**
	 * Column Info
	 * @return dtlVslCd
	 */
	public String getDtlVslCd() {
		return this.dtlVslCd;
	}
	
	/**
	 * Column Info
	 * @return dtlSkdVoyNo
	 */
	public String getDtlSkdVoyNo() {
		return this.dtlSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return dtlSkdDirCd
	 */
	public String getDtlSkdDirCd() {
		return this.dtlSkdDirCd;
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
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param dtlVslEngNm
	 */
	public void setDtlVslEngNm(String dtlVslEngNm) {
		this.dtlVslEngNm = dtlVslEngNm;
	}
		
	/**
	 * Column Info
	 * @param dtlCallSgnNo
	 */
	public void setDtlCallSgnNo(String dtlCallSgnNo) {
		this.dtlCallSgnNo = dtlCallSgnNo;
	}
	
	/**
	 * Column Info
	 * @param dtlVslCd
	 */
	public void setDtlVslCd(String dtlVslCd) {
		this.dtlVslCd = dtlVslCd;
	}
	
	/**
	 * Column Info
	 * @param dtlSkdVoyNo
	 */
	public void setDtlSkdVoyNo(String dtlSkdVoyNo) {
		this.dtlSkdVoyNo = dtlSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param dtlSkdDirCd
	 */
	public void setDtlSkdDirCd(String dtlSkdDirCd) {
		this.dtlSkdDirCd = dtlSkdDirCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setOblIssDt(JSPUtil.getParameter(request, "obl_iss_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setDtlVslEngNm(JSPUtil.getParameter(request, "dtl_vsl_eng_nm", ""));
		setDtlCallSgnNo(JSPUtil.getParameter(request, "dtl_call_sgn_no", ""));
		setDtlVslCd(JSPUtil.getParameter(request, "dtl_vsl_cd", ""));
		setDtlSkdVoyNo(JSPUtil.getParameter(request, "dtl_skd_voy_no", ""));
		setDtlSkdDirCd(JSPUtil.getParameter(request, "dtl_skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndonesiaManifestDetail1VO[]
	 */
	public IndonesiaManifestDetail1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndonesiaManifestDetail1VO[]
	 */
	public IndonesiaManifestDetail1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndonesiaManifestDetail1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] dtlVslEngNm = (JSPUtil.getParameter(request, prefix	+ "dtl_vsl_eng_nm", length));
			String[] dtlCallSgnNo = (JSPUtil.getParameter(request, prefix	+ "dtl_call_sgn_no", length));
			String[] dtlVslCd = (JSPUtil.getParameter(request, prefix	+ "dtl_vsl_cd", length));
			String[] dtlSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "dtl_skd_voy_no", length));
			String[] dtlSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "dtl_skd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndonesiaManifestDetail1VO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (dtlVslEngNm[i] != null)
					model.setDtlVslEngNm(dtlVslEngNm[i]);
				if (dtlCallSgnNo[i] != null)
					model.setDtlCallSgnNo(dtlCallSgnNo[i]);
				if (dtlVslCd[i] != null)
					model.setDtlVslCd(dtlVslCd[i]);
				if (dtlSkdVoyNo[i] != null)
					model.setDtlSkdVoyNo(dtlSkdVoyNo[i]);
				if (dtlSkdDirCd[i] != null)
					model.setDtlSkdDirCd(dtlSkdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndonesiaManifestDetail1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndonesiaManifestDetail1VO[]
	 */
	public IndonesiaManifestDetail1VO[] getIndonesiaManifestDetail1VOs(){
		IndonesiaManifestDetail1VO[] vos = (IndonesiaManifestDetail1VO[])models.toArray(new IndonesiaManifestDetail1VO[models.size()]);
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
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlVslEngNm = this.dtlVslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlCallSgnNo = this.dtlCallSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlVslCd = this.dtlVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSkdVoyNo = this.dtlSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSkdDirCd = this.dtlSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
