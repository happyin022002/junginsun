/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpaceControlInquiryOfficeListVO.java
*@FileTitle : SearchSpaceControlInquiryOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.lang.reflect.Field;
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

public class SearchSpaceControlInquiryOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryOfficeListVO> models = new ArrayList<SearchSpaceControlInquiryOfficeListVO>();
	
	/* Column Info */
	private String fctWgt = null;
	/* Column Info */
	private String fctTsWgt = null;
	/* Column Info */
	private String fctTsVol = null;
	/* Column Info */
	private String qtaVol = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String alcVol = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alcWgt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bkgTsVol = null;
	/* Column Info */
	private String bkgTsWgt = null;
	/* Column Info */
	private String alcTsWgt = null;
	/* Column Info */
	private String bkgWait = null;
	/* Column Info */
	private String fctVol = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgWgt = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String alcTsVol = null;
	/* Column Info */
	private String bkgFirm = null;
	/* Column Info */
	private String qtaCmb = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bkgVol = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceControlInquiryOfficeListVO() {}

	public SearchSpaceControlInquiryOfficeListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String costYr, String costWk, String vvd, String qtaVol, String qtaCmb, String fctVol, String fctWgt, String fctTsVol, String fctTsWgt, String alcVol, String alcWgt, String alcTsVol, String alcTsWgt, String bkgFirm, String bkgWait, String bkgVol, String bkgWgt, String bkgTsVol, String bkgTsWgt, String ratio) {
		this.fctWgt = fctWgt;
		this.fctTsWgt = fctTsWgt;
		this.fctTsVol = fctTsVol;
		this.qtaVol = qtaVol;
		this.trdCd = trdCd;
		this.alcVol = alcVol;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.alcWgt = alcWgt;
		this.dirCd = dirCd;
		this.bkgTsVol = bkgTsVol;
		this.bkgTsWgt = bkgTsWgt;
		this.alcTsWgt = alcTsWgt;
		this.bkgWait = bkgWait;
		this.fctVol = fctVol;
		this.vvd = vvd;
		this.bkgWgt = bkgWgt;
		this.ratio = ratio;
		this.costYr = costYr;
		this.costWk = costWk;
		this.alcTsVol = alcTsVol;
		this.bkgFirm = bkgFirm;
		this.qtaCmb = qtaCmb;
		this.subTrdCd = subTrdCd;
		this.bkgVol = bkgVol;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fct_wgt", getFctWgt());
		this.hashColumns.put("fct_ts_wgt", getFctTsWgt());
		this.hashColumns.put("fct_ts_vol", getFctTsVol());
		this.hashColumns.put("qta_vol", getQtaVol());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("alc_vol", getAlcVol());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("alc_wgt", getAlcWgt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bkg_ts_vol", getBkgTsVol());
		this.hashColumns.put("bkg_ts_wgt", getBkgTsWgt());
		this.hashColumns.put("alc_ts_wgt", getAlcTsWgt());
		this.hashColumns.put("bkg_wait", getBkgWait());
		this.hashColumns.put("fct_vol", getFctVol());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_wgt", getBkgWgt());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("alc_ts_vol", getAlcTsVol());
		this.hashColumns.put("bkg_firm", getBkgFirm());
		this.hashColumns.put("qta_cmb", getQtaCmb());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bkg_vol", getBkgVol());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fct_wgt", "fctWgt");
		this.hashFields.put("fct_ts_wgt", "fctTsWgt");
		this.hashFields.put("fct_ts_vol", "fctTsVol");
		this.hashFields.put("qta_vol", "qtaVol");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("alc_vol", "alcVol");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("alc_wgt", "alcWgt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bkg_ts_vol", "bkgTsVol");
		this.hashFields.put("bkg_ts_wgt", "bkgTsWgt");
		this.hashFields.put("alc_ts_wgt", "alcTsWgt");
		this.hashFields.put("bkg_wait", "bkgWait");
		this.hashFields.put("fct_vol", "fctVol");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_wgt", "bkgWgt");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("alc_ts_vol", "alcTsVol");
		this.hashFields.put("bkg_firm", "bkgFirm");
		this.hashFields.put("qta_cmb", "qtaCmb");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bkg_vol", "bkgVol");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fctWgt
	 */
	public String getFctWgt() {
		return this.fctWgt;
	}
	
	/**
	 * Column Info
	 * @return fctTsWgt
	 */
	public String getFctTsWgt() {
		return this.fctTsWgt;
	}
	
	/**
	 * Column Info
	 * @return fctTsVol
	 */
	public String getFctTsVol() {
		return this.fctTsVol;
	}
	
	/**
	 * Column Info
	 * @return qtaVol
	 */
	public String getQtaVol() {
		return this.qtaVol;
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
	 * @return alcVol
	 */
	public String getAlcVol() {
		return this.alcVol;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return alcWgt
	 */
	public String getAlcWgt() {
		return this.alcWgt;
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
	 * @return bkgTsVol
	 */
	public String getBkgTsVol() {
		return this.bkgTsVol;
	}
	
	/**
	 * Column Info
	 * @return bkgTsWgt
	 */
	public String getBkgTsWgt() {
		return this.bkgTsWgt;
	}
	
	/**
	 * Column Info
	 * @return alcTsWgt
	 */
	public String getAlcTsWgt() {
		return this.alcTsWgt;
	}
	
	/**
	 * Column Info
	 * @return bkgWait
	 */
	public String getBkgWait() {
		return this.bkgWait;
	}
	
	/**
	 * Column Info
	 * @return fctVol
	 */
	public String getFctVol() {
		return this.fctVol;
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
	 * @return bkgWgt
	 */
	public String getBkgWgt() {
		return this.bkgWgt;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return alcTsVol
	 */
	public String getAlcTsVol() {
		return this.alcTsVol;
	}
	
	/**
	 * Column Info
	 * @return bkgFirm
	 */
	public String getBkgFirm() {
		return this.bkgFirm;
	}
	
	/**
	 * Column Info
	 * @return qtaCmb
	 */
	public String getQtaCmb() {
		return this.qtaCmb;
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
	 * @return bkgVol
	 */
	public String getBkgVol() {
		return this.bkgVol;
	}
	

	/**
	 * Column Info
	 * @param fctWgt
	 */
	public void setFctWgt(String fctWgt) {
		this.fctWgt = fctWgt;
	}
	
	/**
	 * Column Info
	 * @param fctTsWgt
	 */
	public void setFctTsWgt(String fctTsWgt) {
		this.fctTsWgt = fctTsWgt;
	}
	
	/**
	 * Column Info
	 * @param fctTsVol
	 */
	public void setFctTsVol(String fctTsVol) {
		this.fctTsVol = fctTsVol;
	}
	
	/**
	 * Column Info
	 * @param qtaVol
	 */
	public void setQtaVol(String qtaVol) {
		this.qtaVol = qtaVol;
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
	 * @param alcVol
	 */
	public void setAlcVol(String alcVol) {
		this.alcVol = alcVol;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param alcWgt
	 */
	public void setAlcWgt(String alcWgt) {
		this.alcWgt = alcWgt;
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
	 * @param bkgTsVol
	 */
	public void setBkgTsVol(String bkgTsVol) {
		this.bkgTsVol = bkgTsVol;
	}
	
	/**
	 * Column Info
	 * @param bkgTsWgt
	 */
	public void setBkgTsWgt(String bkgTsWgt) {
		this.bkgTsWgt = bkgTsWgt;
	}
	
	/**
	 * Column Info
	 * @param alcTsWgt
	 */
	public void setAlcTsWgt(String alcTsWgt) {
		this.alcTsWgt = alcTsWgt;
	}
	
	/**
	 * Column Info
	 * @param bkgWait
	 */
	public void setBkgWait(String bkgWait) {
		this.bkgWait = bkgWait;
	}
	
	/**
	 * Column Info
	 * @param fctVol
	 */
	public void setFctVol(String fctVol) {
		this.fctVol = fctVol;
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
	 * @param bkgWgt
	 */
	public void setBkgWgt(String bkgWgt) {
		this.bkgWgt = bkgWgt;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param alcTsVol
	 */
	public void setAlcTsVol(String alcTsVol) {
		this.alcTsVol = alcTsVol;
	}
	
	/**
	 * Column Info
	 * @param bkgFirm
	 */
	public void setBkgFirm(String bkgFirm) {
		this.bkgFirm = bkgFirm;
	}
	
	/**
	 * Column Info
	 * @param qtaCmb
	 */
	public void setQtaCmb(String qtaCmb) {
		this.qtaCmb = qtaCmb;
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
	 * @param bkgVol
	 */
	public void setBkgVol(String bkgVol) {
		this.bkgVol = bkgVol;
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
		setFctWgt(JSPUtil.getParameter(request, prefix + "fct_wgt", ""));
		setFctTsWgt(JSPUtil.getParameter(request, prefix + "fct_ts_wgt", ""));
		setFctTsVol(JSPUtil.getParameter(request, prefix + "fct_ts_vol", ""));
		setQtaVol(JSPUtil.getParameter(request, prefix + "qta_vol", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAlcVol(JSPUtil.getParameter(request, prefix + "alc_vol", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlcWgt(JSPUtil.getParameter(request, prefix + "alc_wgt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBkgTsVol(JSPUtil.getParameter(request, prefix + "bkg_ts_vol", ""));
		setBkgTsWgt(JSPUtil.getParameter(request, prefix + "bkg_ts_wgt", ""));
		setAlcTsWgt(JSPUtil.getParameter(request, prefix + "alc_ts_wgt", ""));
		setBkgWait(JSPUtil.getParameter(request, prefix + "bkg_wait", ""));
		setFctVol(JSPUtil.getParameter(request, prefix + "fct_vol", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgWgt(JSPUtil.getParameter(request, prefix + "bkg_wgt", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setAlcTsVol(JSPUtil.getParameter(request, prefix + "alc_ts_vol", ""));
		setBkgFirm(JSPUtil.getParameter(request, prefix + "bkg_firm", ""));
		setQtaCmb(JSPUtil.getParameter(request, prefix + "qta_cmb", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBkgVol(JSPUtil.getParameter(request, prefix + "bkg_vol", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryOfficeListVO[]
	 */
	public SearchSpaceControlInquiryOfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryOfficeListVO[]
	 */
	public SearchSpaceControlInquiryOfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryOfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fctWgt = (JSPUtil.getParameter(request, prefix	+ "fct_wgt", length));
			String[] fctTsWgt = (JSPUtil.getParameter(request, prefix	+ "fct_ts_wgt", length));
			String[] fctTsVol = (JSPUtil.getParameter(request, prefix	+ "fct_ts_vol", length));
			String[] qtaVol = (JSPUtil.getParameter(request, prefix	+ "qta_vol", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] alcVol = (JSPUtil.getParameter(request, prefix	+ "alc_vol", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alcWgt = (JSPUtil.getParameter(request, prefix	+ "alc_wgt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bkgTsVol = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_vol", length));
			String[] bkgTsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_wgt", length));
			String[] alcTsWgt = (JSPUtil.getParameter(request, prefix	+ "alc_ts_wgt", length));
			String[] bkgWait = (JSPUtil.getParameter(request, prefix	+ "bkg_wait", length));
			String[] fctVol = (JSPUtil.getParameter(request, prefix	+ "fct_vol", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] alcTsVol = (JSPUtil.getParameter(request, prefix	+ "alc_ts_vol", length));
			String[] bkgFirm = (JSPUtil.getParameter(request, prefix	+ "bkg_firm", length));
			String[] qtaCmb = (JSPUtil.getParameter(request, prefix	+ "qta_cmb", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bkgVol = (JSPUtil.getParameter(request, prefix	+ "bkg_vol", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryOfficeListVO();
				if (fctWgt[i] != null)
					model.setFctWgt(fctWgt[i]);
				if (fctTsWgt[i] != null)
					model.setFctTsWgt(fctTsWgt[i]);
				if (fctTsVol[i] != null)
					model.setFctTsVol(fctTsVol[i]);
				if (qtaVol[i] != null)
					model.setQtaVol(qtaVol[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (alcVol[i] != null)
					model.setAlcVol(alcVol[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alcWgt[i] != null)
					model.setAlcWgt(alcWgt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bkgTsVol[i] != null)
					model.setBkgTsVol(bkgTsVol[i]);
				if (bkgTsWgt[i] != null)
					model.setBkgTsWgt(bkgTsWgt[i]);
				if (alcTsWgt[i] != null)
					model.setAlcTsWgt(alcTsWgt[i]);
				if (bkgWait[i] != null)
					model.setBkgWait(bkgWait[i]);
				if (fctVol[i] != null)
					model.setFctVol(fctVol[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgWgt[i] != null)
					model.setBkgWgt(bkgWgt[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (alcTsVol[i] != null)
					model.setAlcTsVol(alcTsVol[i]);
				if (bkgFirm[i] != null)
					model.setBkgFirm(bkgFirm[i]);
				if (qtaCmb[i] != null)
					model.setQtaCmb(qtaCmb[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bkgVol[i] != null)
					model.setBkgVol(bkgVol[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryOfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryOfficeListVO[]
	 */
	public SearchSpaceControlInquiryOfficeListVO[] getSearchSpaceControlInquiryOfficeListVOs(){
		SearchSpaceControlInquiryOfficeListVO[] vos = (SearchSpaceControlInquiryOfficeListVO[])models.toArray(new SearchSpaceControlInquiryOfficeListVO[models.size()]);
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
		this.fctWgt = this.fctWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctTsWgt = this.fctTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctTsVol = this.fctTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVol = this.qtaVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcVol = this.alcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcWgt = this.alcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsVol = this.bkgTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsWgt = this.bkgTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcTsWgt = this.alcTsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWait = this.bkgWait .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctVol = this.fctVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgt = this.bkgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcTsVol = this.alcTsVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFirm = this.bkgFirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaCmb = this.qtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVol = this.bkgVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
