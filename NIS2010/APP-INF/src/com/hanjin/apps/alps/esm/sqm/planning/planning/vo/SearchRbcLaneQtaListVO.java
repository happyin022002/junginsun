/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchRbcLaneQtaListVO.java
*@FileTitle : SearchRbcLaneQtaListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.08.23 조정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.planning.planning.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRbcLaneQtaListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRbcLaneQtaListVO> models = new ArrayList<SearchRbcLaneQtaListVO>();
	
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String gidLodQty = null;
	/* Column Info */
	private String paCmAmt = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String gidGrsRev = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String gidRaCmAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String gidPaCmAmt = null;
	/* Column Info */
	private String raCmAmt = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRbcLaneQtaListVO() {}

	public SearchRbcLaneQtaListVO(String ibflag, String pagerows, String bseTpCd, String bseYr, String bseQtrCd, String ofcVwCd, String trdCd, String rlaneCd, String dirCd, String rgnOfcCd, String rhqCd, String subTrdCd, String gidLodQty, String gidGrsRev, String gidPaCmAmt, String gidRaCmAmt, String lodQty, String grsRev, String paCmAmt, String raCmAmt) {
		this.lodQty = lodQty;
		this.rhqCd = rhqCd;
		this.gidLodQty = gidLodQty;
		this.paCmAmt = paCmAmt;
		this.ofcVwCd = ofcVwCd;
		this.gidGrsRev = gidGrsRev;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.gidRaCmAmt = gidRaCmAmt;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.ibflag = ibflag;
		this.grsRev = grsRev;
		this.gidPaCmAmt = gidPaCmAmt;
		this.raCmAmt = raCmAmt;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("gid_lod_qty", getGidLodQty());
		this.hashColumns.put("pa_cm_amt", getPaCmAmt());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("gid_grs_rev", getGidGrsRev());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("gid_ra_cm_amt", getGidRaCmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("gid_pa_cm_amt", getGidPaCmAmt());
		this.hashColumns.put("ra_cm_amt", getRaCmAmt());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("gid_lod_qty", "gidLodQty");
		this.hashFields.put("pa_cm_amt", "paCmAmt");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("gid_grs_rev", "gidGrsRev");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("gid_ra_cm_amt", "gidRaCmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("gid_pa_cm_amt", "gidPaCmAmt");
		this.hashFields.put("ra_cm_amt", "raCmAmt");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
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
	 * @return gidLodQty
	 */
	public String getGidLodQty() {
		return this.gidLodQty;
	}
	
	/**
	 * Column Info
	 * @return paCmAmt
	 */
	public String getPaCmAmt() {
		return this.paCmAmt;
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
	 * @return gidGrsRev
	 */
	public String getGidGrsRev() {
		return this.gidGrsRev;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return gidRaCmAmt
	 */
	public String getGidRaCmAmt() {
		return this.gidRaCmAmt;
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
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return gidPaCmAmt
	 */
	public String getGidPaCmAmt() {
		return this.gidPaCmAmt;
	}
	
	/**
	 * Column Info
	 * @return raCmAmt
	 */
	public String getRaCmAmt() {
		return this.raCmAmt;
	}
	
	/**
	 * Column Info
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param gidLodQty
	 */
	public void setGidLodQty(String gidLodQty) {
		this.gidLodQty = gidLodQty;
	}
	
	/**
	 * Column Info
	 * @param paCmAmt
	 */
	public void setPaCmAmt(String paCmAmt) {
		this.paCmAmt = paCmAmt;
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
	 * @param gidGrsRev
	 */
	public void setGidGrsRev(String gidGrsRev) {
		this.gidGrsRev = gidGrsRev;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param gidRaCmAmt
	 */
	public void setGidRaCmAmt(String gidRaCmAmt) {
		this.gidRaCmAmt = gidRaCmAmt;
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
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param gidPaCmAmt
	 */
	public void setGidPaCmAmt(String gidPaCmAmt) {
		this.gidPaCmAmt = gidPaCmAmt;
	}
	
	/**
	 * Column Info
	 * @param raCmAmt
	 */
	public void setRaCmAmt(String raCmAmt) {
		this.raCmAmt = raCmAmt;
	}
	
	/**
	 * Column Info
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setGidLodQty(JSPUtil.getParameter(request, prefix + "gid_lod_qty", ""));
		setPaCmAmt(JSPUtil.getParameter(request, prefix + "pa_cm_amt", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setGidGrsRev(JSPUtil.getParameter(request, prefix + "gid_grs_rev", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setGidRaCmAmt(JSPUtil.getParameter(request, prefix + "gid_ra_cm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setGidPaCmAmt(JSPUtil.getParameter(request, prefix + "gid_pa_cm_amt", ""));
		setRaCmAmt(JSPUtil.getParameter(request, prefix + "ra_cm_amt", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRbcLaneQtaListVO[]
	 */
	public SearchRbcLaneQtaListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRbcLaneQtaListVO[]
	 */
	public SearchRbcLaneQtaListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRbcLaneQtaListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] gidLodQty = (JSPUtil.getParameter(request, prefix	+ "gid_lod_qty", length));
			String[] paCmAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_amt", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] gidGrsRev = (JSPUtil.getParameter(request, prefix	+ "gid_grs_rev", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] gidRaCmAmt = (JSPUtil.getParameter(request, prefix	+ "gid_ra_cm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] gidPaCmAmt = (JSPUtil.getParameter(request, prefix	+ "gid_pa_cm_amt", length));
			String[] raCmAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_amt", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRbcLaneQtaListVO();
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (gidLodQty[i] != null)
					model.setGidLodQty(gidLodQty[i]);
				if (paCmAmt[i] != null)
					model.setPaCmAmt(paCmAmt[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (gidGrsRev[i] != null)
					model.setGidGrsRev(gidGrsRev[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (gidRaCmAmt[i] != null)
					model.setGidRaCmAmt(gidRaCmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (gidPaCmAmt[i] != null)
					model.setGidPaCmAmt(gidPaCmAmt[i]);
				if (raCmAmt[i] != null)
					model.setRaCmAmt(raCmAmt[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRbcLaneQtaListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRbcLaneQtaListVO[]
	 */
	public SearchRbcLaneQtaListVO[] getSearchRbcLaneQtaListVOs(){
		SearchRbcLaneQtaListVO[] vos = (SearchRbcLaneQtaListVO[])models.toArray(new SearchRbcLaneQtaListVO[models.size()]);
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
		this.gidLodQty = this.gidLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmAmt = this.paCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidGrsRev = this.gidGrsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidRaCmAmt = this.gidRaCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidPaCmAmt = this.gidPaCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmAmt = this.raCmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
