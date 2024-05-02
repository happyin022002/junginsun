/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSurchargeAutoratingListVO.java
*@FileTitle : SearchSurchargeAutoratingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSurchargeAutoratingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSurchargeAutoratingListVO> models = new ArrayList<SearchSurchargeAutoratingListVO>();
	
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String fltPctTpCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String inGaFlg = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String oftCmbSeq = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String prcHngrBarTpCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pctBseCd = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSurchargeAutoratingListVO() {}

	public SearchSurchargeAutoratingListVO(String ibflag, String pagerows, String bkgNo, String oftCmbSeq, String chgCd, String fltPctTpCd, String pctBseCd, String currCd, String chgUtAmt, String ratAsQty, String ratUtCd, String chgAmt, String frtInclXcldDivCd, String frtTermCd, String cgoTpCd, String rcvTermCd, String deTermCd, String imdgClssCd, String socFlg, String prcHngrBarTpCd, String inGaFlg, String cntrWgt) {
		this.chgUtAmt = chgUtAmt;
		this.fltPctTpCd = fltPctTpCd;
		this.cntrWgt = cntrWgt;
		this.currCd = currCd;
		this.inGaFlg = inGaFlg;
		this.frtTermCd = frtTermCd;
		this.cgoTpCd = cgoTpCd;
		this.ratUtCd = ratUtCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.socFlg = socFlg;
		this.oftCmbSeq = oftCmbSeq;
		this.deTermCd = deTermCd;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.chgAmt = chgAmt;
		this.ratAsQty = ratAsQty;
		this.rcvTermCd = rcvTermCd;
		this.pctBseCd = pctBseCd;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("in_ga_flg", getInGaFlg());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("oft_cmb_seq", getOftCmbSeq());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pct_bse_cd", getPctBseCd());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("in_ga_flg", "inGaFlg");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("oft_cmb_seq", "oftCmbSeq");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pct_bse_cd", "pctBseCd");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return fltPctTpCd
	 */
	public String getFltPctTpCd() {
		return this.fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return inGaFlg
	 */
	public String getInGaFlg() {
		return this.inGaFlg;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return oftCmbSeq
	 */
	public String getOftCmbSeq() {
		return this.oftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
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
	 * @return prcHngrBarTpCd
	 */
	public String getPrcHngrBarTpCd() {
		return this.prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return pctBseCd
	 */
	public String getPctBseCd() {
		return this.pctBseCd;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param fltPctTpCd
	 */
	public void setFltPctTpCd(String fltPctTpCd) {
		this.fltPctTpCd = fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param inGaFlg
	 */
	public void setInGaFlg(String inGaFlg) {
		this.inGaFlg = inGaFlg;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param oftCmbSeq
	 */
	public void setOftCmbSeq(String oftCmbSeq) {
		this.oftCmbSeq = oftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param frtInclXcldDivCd
	 */
	public void setFrtInclXcldDivCd(String frtInclXcldDivCd) {
		this.frtInclXcldDivCd = frtInclXcldDivCd;
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
	 * @param prcHngrBarTpCd
	 */
	public void setPrcHngrBarTpCd(String prcHngrBarTpCd) {
		this.prcHngrBarTpCd = prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param pctBseCd
	 */
	public void setPctBseCd(String pctBseCd) {
		this.pctBseCd = pctBseCd;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChgUtAmt(JSPUtil.getParameter(request, "chg_ut_amt", ""));
		setFltPctTpCd(JSPUtil.getParameter(request, "flt_pct_tp_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setInGaFlg(JSPUtil.getParameter(request, "in_ga_flg", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setOftCmbSeq(JSPUtil.getParameter(request, "oft_cmb_seq", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, "frt_incl_xcld_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request, "prc_hngr_bar_tp_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setPctBseCd(JSPUtil.getParameter(request, "pct_bse_cd", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSurchargeAutoratingListVO[]
	 */
	public SearchSurchargeAutoratingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSurchargeAutoratingListVO[]
	 */
	public SearchSurchargeAutoratingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSurchargeAutoratingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] fltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "flt_pct_tp_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] inGaFlg = (JSPUtil.getParameter(request, prefix	+ "in_ga_flg", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] oftCmbSeq = (JSPUtil.getParameter(request, prefix	+ "oft_cmb_seq", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pctBseCd = (JSPUtil.getParameter(request, prefix	+ "pct_bse_cd", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSurchargeAutoratingListVO();
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (fltPctTpCd[i] != null)
					model.setFltPctTpCd(fltPctTpCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (inGaFlg[i] != null)
					model.setInGaFlg(inGaFlg[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (oftCmbSeq[i] != null)
					model.setOftCmbSeq(oftCmbSeq[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (prcHngrBarTpCd[i] != null)
					model.setPrcHngrBarTpCd(prcHngrBarTpCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pctBseCd[i] != null)
					model.setPctBseCd(pctBseCd[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSurchargeAutoratingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSurchargeAutoratingListVO[]
	 */
	public SearchSurchargeAutoratingListVO[] getSearchSurchargeAutoratingListVOs(){
		SearchSurchargeAutoratingListVO[] vos = (SearchSurchargeAutoratingListVO[])models.toArray(new SearchSurchargeAutoratingListVO[models.size()]);
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
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd = this.fltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inGaFlg = this.inGaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCmbSeq = this.oftCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd = this.prcHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctBseCd = this.pctBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
