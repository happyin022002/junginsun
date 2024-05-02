/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBasicDataCreationForSecterListVO.java
*@FileTitle : SearchBasicDataCreationForSecterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo;

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

public class SearchBasicDataCreationForSecterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicDataCreationForSecterListVO> models = new ArrayList<SearchBasicDataCreationForSecterListVO>();
	
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String period = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String paCm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String grsTtlRev = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String paCmUcAmt = null;
	/* Column Info */
	private String raCm = null;
	/* Column Info */
	private String sqmMnSctrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicDataCreationForSecterListVO() {}

	public SearchBasicDataCreationForSecterListVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String ofcVwCd, String trdCd, String subTrdCd, String iasRgnCd, String rlaneCd, String dirCd, String rhqCd, String rgnOfcCd, String polCd, String podCd, String lodQty, String grsTtlRev, String paCm, String raCm, String paCmUcAmt, String raCmUcAmt, String period, String sqmMnSctrFlg) {
		this.lodQty = lodQty;
		this.rhqCd = rhqCd;
		this.ofcVwCd = ofcVwCd;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.iasRgnCd = iasRgnCd;
		this.rlaneCd = rlaneCd;
		this.period = period;
		this.pagerows = pagerows;
		this.paCm = paCm;
		this.podCd = podCd;
		this.bseQtrCd = bseQtrCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.raCmUcAmt = raCmUcAmt;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.grsTtlRev = grsTtlRev;
		this.subTrdCd = subTrdCd;
		this.paCmUcAmt = paCmUcAmt;
		this.raCm = raCm;
		this.sqmMnSctrFlg = sqmMnSctrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pa_cm", getPaCm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("grs_ttl_rev", getGrsTtlRev());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		this.hashColumns.put("ra_cm", getRaCm());
		this.hashColumns.put("sqm_mn_sctr_flg", getSqmMnSctrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("period", "period");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pa_cm", "paCm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("grs_ttl_rev", "grsTtlRev");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
		this.hashFields.put("ra_cm", "raCm");
		this.hashFields.put("sqm_mn_sctr_flg", "sqmMnSctrFlg");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
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
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
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
	 * @return paCm
	 */
	public String getPaCm() {
		return this.paCm;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return grsTtlRev
	 */
	public String getGrsTtlRev() {
		return this.grsTtlRev;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return paCmUcAmt
	 */
	public String getPaCmUcAmt() {
		return this.paCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return raCm
	 */
	public String getRaCm() {
		return this.raCm;
	}
	
	/**
	 * Column Info
	 * @return sqmMnSctrFlg
	 */
	public String getSqmMnSctrFlg() {
		return this.sqmMnSctrFlg;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
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
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
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
	 * @param paCm
	 */
	public void setPaCm(String paCm) {
		this.paCm = paCm;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param grsTtlRev
	 */
	public void setGrsTtlRev(String grsTtlRev) {
		this.grsTtlRev = grsTtlRev;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param paCmUcAmt
	 */
	public void setPaCmUcAmt(String paCmUcAmt) {
		this.paCmUcAmt = paCmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param raCm
	 */
	public void setRaCm(String raCm) {
		this.raCm = raCm;
	}
	
	/**
	 * Column Info
	 * @param sqmMnSctrFlg
	 */
	public void setSqmMnSctrFlg(String sqmMnSctrFlg) {
		this.sqmMnSctrFlg = sqmMnSctrFlg;
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
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPaCm(JSPUtil.getParameter(request, prefix + "pa_cm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setGrsTtlRev(JSPUtil.getParameter(request, prefix + "grs_ttl_rev", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
		setRaCm(JSPUtil.getParameter(request, prefix + "ra_cm", ""));
		setSqmMnSctrFlg(JSPUtil.getParameter(request, prefix + "sqm_mn_sctr_flg", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicDataCreationForSecterListVO[]
	 */
	public SearchBasicDataCreationForSecterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicDataCreationForSecterListVO[]
	 */
	public SearchBasicDataCreationForSecterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicDataCreationForSecterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] paCm = (JSPUtil.getParameter(request, prefix	+ "pa_cm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] grsTtlRev = (JSPUtil.getParameter(request, prefix	+ "grs_ttl_rev", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			String[] raCm = (JSPUtil.getParameter(request, prefix	+ "ra_cm", length));
			String[] sqmMnSctrFlg = (JSPUtil.getParameter(request, prefix	+ "sqm_mn_sctr_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SearchBasicDataCreationForSecterListVO();
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (paCm[i] != null)
					model.setPaCm(paCm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (grsTtlRev[i] != null)
					model.setGrsTtlRev(grsTtlRev[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				if (raCm[i] != null)
					model.setRaCm(raCm[i]);
				if (sqmMnSctrFlg[i] != null)
					model.setSqmMnSctrFlg(sqmMnSctrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicDataCreationForSecterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicDataCreationForSecterListVO[]
	 */
	public SearchBasicDataCreationForSecterListVO[] getSearchBasicDataCreationForSecterListVOs(){
		SearchBasicDataCreationForSecterListVO[] vos = (SearchBasicDataCreationForSecterListVO[])models.toArray(new SearchBasicDataCreationForSecterListVO[models.size()]);
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
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCm = this.paCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsTtlRev = this.grsTtlRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCm = this.raCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqmMnSctrFlg = this.sqmMnSctrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
