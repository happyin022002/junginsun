/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchBasicCmcbListVO.java
*@FileTitle : SearchBasicCmcbListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicCmcbListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicCmcbListVO> models = new ArrayList<SearchBasicCmcbListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currentCmpbRa = null;
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String raCmUcAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String initialRpb = null;
	/* Column Info */
	private String gidRaCmUcAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String gidPaCmUcAmt = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String gidPaCmXcldEqUcAmt = null;
	/* Column Info */
	private String initialCmpbRa = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String currentRpb = null;
	/* Column Info */
	private String paCmUcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBasicCmcbListVO() {}

	public SearchBasicCmcbListVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String ofcVwCd, String trdCd, String rlaneCd, String dirCd, String rhqCd, String rgnOfcCd, String gidPaCmXcldEqUcAmt, String gidPaCmUcAmt, String gidRaCmUcAmt, String initialRpb, String initialCmpbRa, String paCmUcAmt, String raCmUcAmt, String currentRpb, String currentCmpbRa) {
		this.pagerows = pagerows;
		this.currentCmpbRa = currentCmpbRa;
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.raCmUcAmt = raCmUcAmt;
		this.rhqCd = rhqCd;
		this.initialRpb = initialRpb;
		this.gidRaCmUcAmt = gidRaCmUcAmt;
		this.trdCd = trdCd;
		this.rgnOfcCd = rgnOfcCd;
		this.ofcVwCd = ofcVwCd;
		this.gidPaCmUcAmt = gidPaCmUcAmt;
		this.bseYr = bseYr;
		this.bseQtrCd = bseQtrCd;
		this.gidPaCmXcldEqUcAmt = gidPaCmXcldEqUcAmt;
		this.initialCmpbRa = initialCmpbRa;
		this.dirCd = dirCd;
		this.currentRpb = currentRpb;
		this.paCmUcAmt = paCmUcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("current_cmpb_ra", getCurrentCmpbRa());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ra_cm_uc_amt", getRaCmUcAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("initial_rpb", getInitialRpb());
		this.hashColumns.put("gid_ra_cm_uc_amt", getGidRaCmUcAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("gid_pa_cm_uc_amt", getGidPaCmUcAmt());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("gid_pa_cm_xcld_eq_uc_amt", getGidPaCmXcldEqUcAmt());
		this.hashColumns.put("initial_cmpb_ra", getInitialCmpbRa());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("current_rpb", getCurrentRpb());
		this.hashColumns.put("pa_cm_uc_amt", getPaCmUcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("current_cmpb_ra", "currentCmpbRa");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ra_cm_uc_amt", "raCmUcAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("initial_rpb", "initialRpb");
		this.hashFields.put("gid_ra_cm_uc_amt", "gidRaCmUcAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("gid_pa_cm_uc_amt", "gidPaCmUcAmt");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("gid_pa_cm_xcld_eq_uc_amt", "gidPaCmXcldEqUcAmt");
		this.hashFields.put("initial_cmpb_ra", "initialCmpbRa");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("current_rpb", "currentRpb");
		this.hashFields.put("pa_cm_uc_amt", "paCmUcAmt");
		return this.hashFields;
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
	 * @return currentCmpbRa
	 */
	public String getCurrentCmpbRa() {
		return this.currentCmpbRa;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return raCmUcAmt
	 */
	public String getRaCmUcAmt() {
		return this.raCmUcAmt;
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
	 * @return initialRpb
	 */
	public String getInitialRpb() {
		return this.initialRpb;
	}
	
	/**
	 * Column Info
	 * @return gidRaCmUcAmt
	 */
	public String getGidRaCmUcAmt() {
		return this.gidRaCmUcAmt;
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
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
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
	 * @return gidPaCmUcAmt
	 */
	public String getGidPaCmUcAmt() {
		return this.gidPaCmUcAmt;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return gidPaCmXcldEqUcAmt
	 */
	public String getGidPaCmXcldEqUcAmt() {
		return this.gidPaCmXcldEqUcAmt;
	}
	
	/**
	 * Column Info
	 * @return initialCmpbRa
	 */
	public String getInitialCmpbRa() {
		return this.initialCmpbRa;
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
	 * @return currentRpb
	 */
	public String getCurrentRpb() {
		return this.currentRpb;
	}
	
	/**
	 * Column Info
	 * @return paCmUcAmt
	 */
	public String getPaCmUcAmt() {
		return this.paCmUcAmt;
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
	 * @param currentCmpbRa
	 */
	public void setCurrentCmpbRa(String currentCmpbRa) {
		this.currentCmpbRa = currentCmpbRa;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param raCmUcAmt
	 */
	public void setRaCmUcAmt(String raCmUcAmt) {
		this.raCmUcAmt = raCmUcAmt;
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
	 * @param initialRpb
	 */
	public void setInitialRpb(String initialRpb) {
		this.initialRpb = initialRpb;
	}
	
	/**
	 * Column Info
	 * @param gidRaCmUcAmt
	 */
	public void setGidRaCmUcAmt(String gidRaCmUcAmt) {
		this.gidRaCmUcAmt = gidRaCmUcAmt;
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
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
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
	 * @param gidPaCmUcAmt
	 */
	public void setGidPaCmUcAmt(String gidPaCmUcAmt) {
		this.gidPaCmUcAmt = gidPaCmUcAmt;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param gidPaCmXcldEqUcAmt
	 */
	public void setGidPaCmXcldEqUcAmt(String gidPaCmXcldEqUcAmt) {
		this.gidPaCmXcldEqUcAmt = gidPaCmXcldEqUcAmt;
	}
	
	/**
	 * Column Info
	 * @param initialCmpbRa
	 */
	public void setInitialCmpbRa(String initialCmpbRa) {
		this.initialCmpbRa = initialCmpbRa;
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
	 * @param currentRpb
	 */
	public void setCurrentRpb(String currentRpb) {
		this.currentRpb = currentRpb;
	}
	
	/**
	 * Column Info
	 * @param paCmUcAmt
	 */
	public void setPaCmUcAmt(String paCmUcAmt) {
		this.paCmUcAmt = paCmUcAmt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCurrentCmpbRa(JSPUtil.getParameter(request, prefix + "current_cmpb_ra", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRaCmUcAmt(JSPUtil.getParameter(request, prefix + "ra_cm_uc_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setInitialRpb(JSPUtil.getParameter(request, prefix + "initial_rpb", ""));
		setGidRaCmUcAmt(JSPUtil.getParameter(request, prefix + "gid_ra_cm_uc_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setGidPaCmUcAmt(JSPUtil.getParameter(request, prefix + "gid_pa_cm_uc_amt", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setGidPaCmXcldEqUcAmt(JSPUtil.getParameter(request, prefix + "gid_pa_cm_xcld_eq_uc_amt", ""));
		setInitialCmpbRa(JSPUtil.getParameter(request, prefix + "initial_cmpb_ra", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCurrentRpb(JSPUtil.getParameter(request, prefix + "current_rpb", ""));
		setPaCmUcAmt(JSPUtil.getParameter(request, prefix + "pa_cm_uc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicCmcbListVO[]
	 */
	public SearchBasicCmcbListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicCmcbListVO[]
	 */
	public SearchBasicCmcbListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicCmcbListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currentCmpbRa = (JSPUtil.getParameter(request, prefix	+ "current_cmpb_ra", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] raCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "ra_cm_uc_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] initialRpb = (JSPUtil.getParameter(request, prefix	+ "initial_rpb", length));
			String[] gidRaCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "gid_ra_cm_uc_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] gidPaCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "gid_pa_cm_uc_amt", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] gidPaCmXcldEqUcAmt = (JSPUtil.getParameter(request, prefix	+ "gid_pa_cm_xcld_eq_uc_amt", length));
			String[] initialCmpbRa = (JSPUtil.getParameter(request, prefix	+ "initial_cmpb_ra", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] currentRpb = (JSPUtil.getParameter(request, prefix	+ "current_rpb", length));
			String[] paCmUcAmt = (JSPUtil.getParameter(request, prefix	+ "pa_cm_uc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicCmcbListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currentCmpbRa[i] != null)
					model.setCurrentCmpbRa(currentCmpbRa[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (raCmUcAmt[i] != null)
					model.setRaCmUcAmt(raCmUcAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (initialRpb[i] != null)
					model.setInitialRpb(initialRpb[i]);
				if (gidRaCmUcAmt[i] != null)
					model.setGidRaCmUcAmt(gidRaCmUcAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (gidPaCmUcAmt[i] != null)
					model.setGidPaCmUcAmt(gidPaCmUcAmt[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (gidPaCmXcldEqUcAmt[i] != null)
					model.setGidPaCmXcldEqUcAmt(gidPaCmXcldEqUcAmt[i]);
				if (initialCmpbRa[i] != null)
					model.setInitialCmpbRa(initialCmpbRa[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (currentRpb[i] != null)
					model.setCurrentRpb(currentRpb[i]);
				if (paCmUcAmt[i] != null)
					model.setPaCmUcAmt(paCmUcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicCmcbListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicCmcbListVO[]
	 */
	public SearchBasicCmcbListVO[] getSearchBasicCmcbListVOs(){
		SearchBasicCmcbListVO[] vos = (SearchBasicCmcbListVO[])models.toArray(new SearchBasicCmcbListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currentCmpbRa = this.currentCmpbRa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmUcAmt = this.raCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialRpb = this.initialRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidRaCmUcAmt = this.gidRaCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidPaCmUcAmt = this.gidPaCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidPaCmXcldEqUcAmt = this.gidPaCmXcldEqUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initialCmpbRa = this.initialCmpbRa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currentRpb = this.currentRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmUcAmt = this.paCmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
