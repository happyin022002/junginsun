/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFFSADateVO.java
*@FileTitle : SearchFFSADateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFFSADateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFFSADateVO> models = new ArrayList<SearchFFSADateVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String preFeederCheck = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String postFeederCheck = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vslPolCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vslPodCd = null;
	/* Column Info */
	private String rlaneDirCd = null;
	/* Column Info */
	private String osContiCd = null;
	/* Column Info */
	private String fincCtrlOfcCd = null;
	/* Column Info */
	private String saDtSeq = null;
	/* Column Info */
	private String sinwaTsSaDt = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String saDtDiv = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFFSADateVO() {}

	public SearchFFSADateVO(String ibflag, String pagerows, String vslCd, String preFeederCheck, String postFeederCheck, String skdVoyNo, String rlaneCd, String vslSeq, String vslPolCd, String arOfcCd, String skdDirCd, String slanCd, String rlaneDirCd, String vslPodCd, String fincCtrlOfcCd, String osContiCd, String vslPrePstCd, String saDtDiv, String vpsEtdDt, String vpsEtaDt, String sinwaTsSaDt, String saDtSeq) {
		this.vslCd = vslCd;
		this.preFeederCheck = preFeederCheck;
		this.vpsEtdDt = vpsEtdDt;
		this.postFeederCheck = postFeederCheck;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.vslSeq = vslSeq;
		this.vpsEtaDt = vpsEtaDt;
		this.vslPolCd = vslPolCd;
		this.arOfcCd = arOfcCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.vslPodCd = vslPodCd;
		this.rlaneDirCd = rlaneDirCd;
		this.osContiCd = osContiCd;
		this.fincCtrlOfcCd = fincCtrlOfcCd;
		this.saDtSeq = saDtSeq;
		this.sinwaTsSaDt = sinwaTsSaDt;
		this.vslPrePstCd = vslPrePstCd;
		this.saDtDiv = saDtDiv;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pre_feeder_check", getPreFeederCheck());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("post_feeder_check", getPostFeederCheck());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vsl_pol_cd", getVslPolCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_pod_cd", getVslPodCd());
		this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
		this.hashColumns.put("os_conti_cd", getOsContiCd());
		this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
		this.hashColumns.put("sa_dt_seq", getSaDtSeq());
		this.hashColumns.put("sinwa_ts_sa_dt", getSinwaTsSaDt());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("sa_dt_div", getSaDtDiv());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pre_feeder_check", "preFeederCheck");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("post_feeder_check", "postFeederCheck");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vsl_pol_cd", "vslPolCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_pod_cd", "vslPodCd");
		this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
		this.hashFields.put("os_conti_cd", "osContiCd");
		this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
		this.hashFields.put("sa_dt_seq", "saDtSeq");
		this.hashFields.put("sinwa_ts_sa_dt", "sinwaTsSaDt");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("sa_dt_div", "saDtDiv");
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
	 * @return preFeederCheck
	 */
	public String getPreFeederCheck() {
		return this.preFeederCheck;
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
	 * @return postFeederCheck
	 */
	public String getPostFeederCheck() {
		return this.postFeederCheck;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
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
	 * @return vslPolCd
	 */
	public String getVslPolCd() {
		return this.vslPolCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return vslPodCd
	 */
	public String getVslPodCd() {
		return this.vslPodCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneDirCd
	 */
	public String getRlaneDirCd() {
		return this.rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @return osContiCd
	 */
	public String getOsContiCd() {
		return this.osContiCd;
	}
	
	/**
	 * Column Info
	 * @return fincCtrlOfcCd
	 */
	public String getFincCtrlOfcCd() {
		return this.fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return saDtSeq
	 */
	public String getSaDtSeq() {
		return this.saDtSeq;
	}
	
	/**
	 * Column Info
	 * @return sinwaTsSaDt
	 */
	public String getSinwaTsSaDt() {
		return this.sinwaTsSaDt;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return saDtDiv
	 */
	public String getSaDtDiv() {
		return this.saDtDiv;
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
	 * @param preFeederCheck
	 */
	public void setPreFeederCheck(String preFeederCheck) {
		this.preFeederCheck = preFeederCheck;
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
	 * @param postFeederCheck
	 */
	public void setPostFeederCheck(String postFeederCheck) {
		this.postFeederCheck = postFeederCheck;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
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
	 * @param vslPolCd
	 */
	public void setVslPolCd(String vslPolCd) {
		this.vslPolCd = vslPolCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param vslPodCd
	 */
	public void setVslPodCd(String vslPodCd) {
		this.vslPodCd = vslPodCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneDirCd
	 */
	public void setRlaneDirCd(String rlaneDirCd) {
		this.rlaneDirCd = rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @param osContiCd
	 */
	public void setOsContiCd(String osContiCd) {
		this.osContiCd = osContiCd;
	}
	
	/**
	 * Column Info
	 * @param fincCtrlOfcCd
	 */
	public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
		this.fincCtrlOfcCd = fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param saDtSeq
	 */
	public void setSaDtSeq(String saDtSeq) {
		this.saDtSeq = saDtSeq;
	}
	
	/**
	 * Column Info
	 * @param sinwaTsSaDt
	 */
	public void setSinwaTsSaDt(String sinwaTsSaDt) {
		this.sinwaTsSaDt = sinwaTsSaDt;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param saDtDiv
	 */
	public void setSaDtDiv(String saDtDiv) {
		this.saDtDiv = saDtDiv;
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
		setPreFeederCheck(JSPUtil.getParameter(request, prefix + "pre_feeder_check", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPostFeederCheck(JSPUtil.getParameter(request, prefix + "post_feeder_check", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setVslPolCd(JSPUtil.getParameter(request, prefix + "vsl_pol_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVslPodCd(JSPUtil.getParameter(request, prefix + "vsl_pod_cd", ""));
		setRlaneDirCd(JSPUtil.getParameter(request, prefix + "rlane_dir_cd", ""));
		setOsContiCd(JSPUtil.getParameter(request, prefix + "os_conti_cd", ""));
		setFincCtrlOfcCd(JSPUtil.getParameter(request, prefix + "finc_ctrl_ofc_cd", ""));
		setSaDtSeq(JSPUtil.getParameter(request, prefix + "sa_dt_seq", ""));
		setSinwaTsSaDt(JSPUtil.getParameter(request, prefix + "sinwa_ts_sa_dt", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setSaDtDiv(JSPUtil.getParameter(request, prefix + "sa_dt_div", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFFSADateVO[]
	 */
	public SearchFFSADateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFFSADateVO[]
	 */
	public SearchFFSADateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFFSADateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] preFeederCheck = (JSPUtil.getParameter(request, prefix	+ "pre_feeder_check", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] postFeederCheck = (JSPUtil.getParameter(request, prefix	+ "post_feeder_check", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] vslPolCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pol_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vslPodCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pod_cd", length));
			String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix	+ "rlane_dir_cd", length));
			String[] osContiCd = (JSPUtil.getParameter(request, prefix	+ "os_conti_cd", length));
			String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ctrl_ofc_cd", length));
			String[] saDtSeq = (JSPUtil.getParameter(request, prefix	+ "sa_dt_seq", length));
			String[] sinwaTsSaDt = (JSPUtil.getParameter(request, prefix	+ "sinwa_ts_sa_dt", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] saDtDiv = (JSPUtil.getParameter(request, prefix	+ "sa_dt_div", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFFSADateVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (preFeederCheck[i] != null)
					model.setPreFeederCheck(preFeederCheck[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (postFeederCheck[i] != null)
					model.setPostFeederCheck(postFeederCheck[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vslPolCd[i] != null)
					model.setVslPolCd(vslPolCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vslPodCd[i] != null)
					model.setVslPodCd(vslPodCd[i]);
				if (rlaneDirCd[i] != null)
					model.setRlaneDirCd(rlaneDirCd[i]);
				if (osContiCd[i] != null)
					model.setOsContiCd(osContiCd[i]);
				if (fincCtrlOfcCd[i] != null)
					model.setFincCtrlOfcCd(fincCtrlOfcCd[i]);
				if (saDtSeq[i] != null)
					model.setSaDtSeq(saDtSeq[i]);
				if (sinwaTsSaDt[i] != null)
					model.setSinwaTsSaDt(sinwaTsSaDt[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (saDtDiv[i] != null)
					model.setSaDtDiv(saDtDiv[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFFSADateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFFSADateVO[]
	 */
	public SearchFFSADateVO[] getSearchFFSADateVOs(){
		SearchFFSADateVO[] vos = (SearchFFSADateVO[])models.toArray(new SearchFFSADateVO[models.size()]);
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
		this.preFeederCheck = this.preFeederCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postFeederCheck = this.postFeederCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPolCd = this.vslPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPodCd = this.vslPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDirCd = this.rlaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.osContiCd = this.osContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincCtrlOfcCd = this.fincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDtSeq = this.saDtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sinwaTsSaDt = this.sinwaTsSaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDtDiv = this.saDtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
