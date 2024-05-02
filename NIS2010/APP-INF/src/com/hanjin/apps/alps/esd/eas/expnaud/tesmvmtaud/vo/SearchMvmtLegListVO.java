/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchMvmtLegListVO.java
*@FileTitle : SearchMvmtLegListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2015.08.20 yOnghO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author yOnghO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMvmtLegListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMvmtLegListVO> models = new ArrayList<SearchMvmtLegListVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String fmCnmvEvntDt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String mvmtLeg = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String eqTpSzCd = null;
	/* Column Info */
	private String bndCd = null;
	/* Column Info */
	private String outVvd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String toCnmvEvntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMvmtLegListVO() {}

	public SearchMvmtLegListVO(String ibflag, String pagerows, String rdCgoFlg, String orgYdCd, String bndCd, String inVvd, String blNo, String outVvd, String mvmtLeg, String bkgNo, String mvmtStsCd, String toCnmvEvntDt, String eqTpSzCd, String vvdCd, String fmDt, String cntrTpszCd, String days, String fmCnmvEvntDt, String toDt, String cntrNo, String mftDt) {
		this.inVvd = inVvd;
		this.fmCnmvEvntDt = fmCnmvEvntDt;
		this.fmDt = fmDt;
		this.mvmtLeg = mvmtLeg;
		this.rdCgoFlg = rdCgoFlg;
		this.eqTpSzCd = eqTpSzCd;
		this.bndCd = bndCd;
		this.outVvd = outVvd;
		this.orgYdCd = orgYdCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.mftDt = mftDt;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.mvmtStsCd = mvmtStsCd;
		this.days = days;
		this.vvdCd = vvdCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.toCnmvEvntDt = toCnmvEvntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("fm_cnmv_evnt_dt", getFmCnmvEvntDt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("mvmt_leg", getMvmtLeg());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("eq_tp_sz_cd", getEqTpSzCd());
		this.hashColumns.put("bnd_cd", getBndCd());
		this.hashColumns.put("out_vvd", getOutVvd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("to_cnmv_evnt_dt", getToCnmvEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("fm_cnmv_evnt_dt", "fmCnmvEvntDt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("mvmt_leg", "mvmtLeg");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("eq_tp_sz_cd", "eqTpSzCd");
		this.hashFields.put("bnd_cd", "bndCd");
		this.hashFields.put("out_vvd", "outVvd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("days", "days");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("to_cnmv_evnt_dt", "toCnmvEvntDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return fmCnmvEvntDt
	 */
	public String getFmCnmvEvntDt() {
		return this.fmCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtLeg
	 */
	public String getMvmtLeg() {
		return this.mvmtLeg;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return eqTpSzCd
	 */
	public String getEqTpSzCd() {
		return this.eqTpSzCd;
	}
	
	/**
	 * Column Info
	 * @return bndCd
	 */
	public String getBndCd() {
		return this.bndCd;
	}
	
	/**
	 * Column Info
	 * @return outVvd
	 */
	public String getOutVvd() {
		return this.outVvd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return days
	 */
	public String getDays() {
		return this.days;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return toCnmvEvntDt
	 */
	public String getToCnmvEvntDt() {
		return this.toCnmvEvntDt;
	}
	

	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param fmCnmvEvntDt
	 */
	public void setFmCnmvEvntDt(String fmCnmvEvntDt) {
		this.fmCnmvEvntDt = fmCnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtLeg
	 */
	public void setMvmtLeg(String mvmtLeg) {
		this.mvmtLeg = mvmtLeg;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param eqTpSzCd
	 */
	public void setEqTpSzCd(String eqTpSzCd) {
		this.eqTpSzCd = eqTpSzCd;
	}
	
	/**
	 * Column Info
	 * @param bndCd
	 */
	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}
	
	/**
	 * Column Info
	 * @param outVvd
	 */
	public void setOutVvd(String outVvd) {
		this.outVvd = outVvd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param toCnmvEvntDt
	 */
	public void setToCnmvEvntDt(String toCnmvEvntDt) {
		this.toCnmvEvntDt = toCnmvEvntDt;
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
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setFmCnmvEvntDt(JSPUtil.getParameter(request, prefix + "fm_cnmv_evnt_dt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setMvmtLeg(JSPUtil.getParameter(request, prefix + "mvmt_leg", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setEqTpSzCd(JSPUtil.getParameter(request, prefix + "eq_tp_sz_cd", ""));
		setBndCd(JSPUtil.getParameter(request, prefix + "bnd_cd", ""));
		setOutVvd(JSPUtil.getParameter(request, prefix + "out_vvd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setDays(JSPUtil.getParameter(request, prefix + "days", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setToCnmvEvntDt(JSPUtil.getParameter(request, prefix + "to_cnmv_evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMvmtLegListVO[]
	 */
	public SearchMvmtLegListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMvmtLegListVO[]
	 */
	public SearchMvmtLegListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMvmtLegListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] fmCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "fm_cnmv_evnt_dt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] mvmtLeg = (JSPUtil.getParameter(request, prefix	+ "mvmt_leg", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] eqTpSzCd = (JSPUtil.getParameter(request, prefix	+ "eq_tp_sz_cd", length));
			String[] bndCd = (JSPUtil.getParameter(request, prefix	+ "bnd_cd", length));
			String[] outVvd = (JSPUtil.getParameter(request, prefix	+ "out_vvd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] toCnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "to_cnmv_evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMvmtLegListVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (fmCnmvEvntDt[i] != null)
					model.setFmCnmvEvntDt(fmCnmvEvntDt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (mvmtLeg[i] != null)
					model.setMvmtLeg(mvmtLeg[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (eqTpSzCd[i] != null)
					model.setEqTpSzCd(eqTpSzCd[i]);
				if (bndCd[i] != null)
					model.setBndCd(bndCd[i]);
				if (outVvd[i] != null)
					model.setOutVvd(outVvd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (toCnmvEvntDt[i] != null)
					model.setToCnmvEvntDt(toCnmvEvntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMvmtLegListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMvmtLegListVO[]
	 */
	public SearchMvmtLegListVO[] getSearchMvmtLegListVOs(){
		SearchMvmtLegListVO[] vos = (SearchMvmtLegListVO[])models.toArray(new SearchMvmtLegListVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCnmvEvntDt = this.fmCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtLeg = this.mvmtLeg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpSzCd = this.eqTpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndCd = this.bndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outVvd = this.outVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCnmvEvntDt = this.toCnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
