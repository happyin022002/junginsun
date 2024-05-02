/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchQtaByRhqSimulationVO.java
*@FileTitle : SearchQtaByRhqSimulationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.09.12 조정민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.planning.planning.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQtaByRhqSimulationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaByRhqSimulationVO> models = new ArrayList<SearchQtaByRhqSimulationVO>();
	
	/* Column Info */
	private String ofcQty = null;
	/* Column Info */
	private String obDivCd = null;
	/* Column Info */
	private String ofcWkQty = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String diffQtyRto = null;
	/* Column Info */
	private String diffRevRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String ofcRevRto = null;
	/* Column Info */
	private String ofcQtyRto = null;
	/* Column Info */
	private String ofcRev = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String pstQtyRto = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String pstWkRev = null;
	/* Column Info */
	private String ofcWkRev = null;
	/* Column Info */
	private String diffRev = null;
	/* Column Info */
	private String pstRevRto = null;
	/* Column Info */
	private String diffQty = null;
	/* Column Info */
	private String pstWkQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchQtaByRhqSimulationVO() {}

	public SearchQtaByRhqSimulationVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String obDivCd, String ofcVwCd, String trdCd, String convDirCd, String rhqCd, String rgnOfcCd, String ofcQty, String ofcWkQty, String ofcQtyRto, String ofcRev, String ofcWkRev, String ofcRevRto, String pstWkQty, String pstQtyRto, String pstWkRev, String pstRevRto, String diffQty, String diffQtyRto, String diffRev, String diffRevRto) {
		this.ofcQty = ofcQty;
		this.obDivCd = obDivCd;
		this.ofcWkQty = ofcWkQty;
		this.ofcVwCd = ofcVwCd;
		this.trdCd = trdCd;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.diffQtyRto = diffQtyRto;
		this.diffRevRto = diffRevRto;
		this.ibflag = ibflag;
		this.convDirCd = convDirCd;
		this.ofcRevRto = ofcRevRto;
		this.ofcQtyRto = ofcQtyRto;
		this.ofcRev = ofcRev;
		this.rgnOfcCd = rgnOfcCd;
		this.pstQtyRto = pstQtyRto;
		this.rhqCd = rhqCd;
		this.bseYr = bseYr;
		this.pstWkRev = pstWkRev;
		this.ofcWkRev = ofcWkRev;
		this.diffRev = diffRev;
		this.pstRevRto = pstRevRto;
		this.diffQty = diffQty;
		this.pstWkQty = pstWkQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_qty", getOfcQty());
		this.hashColumns.put("ob_div_cd", getObDivCd());
		this.hashColumns.put("ofc_wk_qty", getOfcWkQty());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("diff_qty_rto", getDiffQtyRto());
		this.hashColumns.put("diff_rev_rto", getDiffRevRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("ofc_rev_rto", getOfcRevRto());
		this.hashColumns.put("ofc_qty_rto", getOfcQtyRto());
		this.hashColumns.put("ofc_rev", getOfcRev());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("pst_qty_rto", getPstQtyRto());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("pst_wk_rev", getPstWkRev());
		this.hashColumns.put("ofc_wk_rev", getOfcWkRev());
		this.hashColumns.put("diff_rev", getDiffRev());
		this.hashColumns.put("pst_rev_rto", getPstRevRto());
		this.hashColumns.put("diff_qty", getDiffQty());
		this.hashColumns.put("pst_wk_qty", getPstWkQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_qty", "ofcQty");
		this.hashFields.put("ob_div_cd", "obDivCd");
		this.hashFields.put("ofc_wk_qty", "ofcWkQty");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("diff_qty_rto", "diffQtyRto");
		this.hashFields.put("diff_rev_rto", "diffRevRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("ofc_rev_rto", "ofcRevRto");
		this.hashFields.put("ofc_qty_rto", "ofcQtyRto");
		this.hashFields.put("ofc_rev", "ofcRev");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("pst_qty_rto", "pstQtyRto");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("pst_wk_rev", "pstWkRev");
		this.hashFields.put("ofc_wk_rev", "ofcWkRev");
		this.hashFields.put("diff_rev", "diffRev");
		this.hashFields.put("pst_rev_rto", "pstRevRto");
		this.hashFields.put("diff_qty", "diffQty");
		this.hashFields.put("pst_wk_qty", "pstWkQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcQty
	 */
	public String getOfcQty() {
		return this.ofcQty;
	}
	
	/**
	 * Column Info
	 * @return obDivCd
	 */
	public String getObDivCd() {
		return this.obDivCd;
	}
	
	/**
	 * Column Info
	 * @return ofcWkQty
	 */
	public String getOfcWkQty() {
		return this.ofcWkQty;
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
	 * Column Info
	 * @return diffQtyRto
	 */
	public String getDiffQtyRto() {
		return this.diffQtyRto;
	}
	
	/**
	 * Column Info
	 * @return diffRevRto
	 */
	public String getDiffRevRto() {
		return this.diffRevRto;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return ofcRevRto
	 */
	public String getOfcRevRto() {
		return this.ofcRevRto;
	}
	
	/**
	 * Column Info
	 * @return ofcQtyRto
	 */
	public String getOfcQtyRto() {
		return this.ofcQtyRto;
	}
	
	/**
	 * Column Info
	 * @return ofcRev
	 */
	public String getOfcRev() {
		return this.ofcRev;
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
	 * @return pstQtyRto
	 */
	public String getPstQtyRto() {
		return this.pstQtyRto;
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
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return pstWkRev
	 */
	public String getPstWkRev() {
		return this.pstWkRev;
	}
	
	/**
	 * Column Info
	 * @return ofcWkRev
	 */
	public String getOfcWkRev() {
		return this.ofcWkRev;
	}
	
	/**
	 * Column Info
	 * @return diffRev
	 */
	public String getDiffRev() {
		return this.diffRev;
	}
	
	/**
	 * Column Info
	 * @return pstRevRto
	 */
	public String getPstRevRto() {
		return this.pstRevRto;
	}
	
	/**
	 * Column Info
	 * @return diffQty
	 */
	public String getDiffQty() {
		return this.diffQty;
	}
	
	/**
	 * Column Info
	 * @return pstWkQty
	 */
	public String getPstWkQty() {
		return this.pstWkQty;
	}
	

	/**
	 * Column Info
	 * @param ofcQty
	 */
	public void setOfcQty(String ofcQty) {
		this.ofcQty = ofcQty;
	}
	
	/**
	 * Column Info
	 * @param obDivCd
	 */
	public void setObDivCd(String obDivCd) {
		this.obDivCd = obDivCd;
	}
	
	/**
	 * Column Info
	 * @param ofcWkQty
	 */
	public void setOfcWkQty(String ofcWkQty) {
		this.ofcWkQty = ofcWkQty;
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
	 * Column Info
	 * @param diffQtyRto
	 */
	public void setDiffQtyRto(String diffQtyRto) {
		this.diffQtyRto = diffQtyRto;
	}
	
	/**
	 * Column Info
	 * @param diffRevRto
	 */
	public void setDiffRevRto(String diffRevRto) {
		this.diffRevRto = diffRevRto;
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
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param ofcRevRto
	 */
	public void setOfcRevRto(String ofcRevRto) {
		this.ofcRevRto = ofcRevRto;
	}
	
	/**
	 * Column Info
	 * @param ofcQtyRto
	 */
	public void setOfcQtyRto(String ofcQtyRto) {
		this.ofcQtyRto = ofcQtyRto;
	}
	
	/**
	 * Column Info
	 * @param ofcRev
	 */
	public void setOfcRev(String ofcRev) {
		this.ofcRev = ofcRev;
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
	 * @param pstQtyRto
	 */
	public void setPstQtyRto(String pstQtyRto) {
		this.pstQtyRto = pstQtyRto;
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
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param pstWkRev
	 */
	public void setPstWkRev(String pstWkRev) {
		this.pstWkRev = pstWkRev;
	}
	
	/**
	 * Column Info
	 * @param ofcWkRev
	 */
	public void setOfcWkRev(String ofcWkRev) {
		this.ofcWkRev = ofcWkRev;
	}
	
	/**
	 * Column Info
	 * @param diffRev
	 */
	public void setDiffRev(String diffRev) {
		this.diffRev = diffRev;
	}
	
	/**
	 * Column Info
	 * @param pstRevRto
	 */
	public void setPstRevRto(String pstRevRto) {
		this.pstRevRto = pstRevRto;
	}
	
	/**
	 * Column Info
	 * @param diffQty
	 */
	public void setDiffQty(String diffQty) {
		this.diffQty = diffQty;
	}
	
	/**
	 * Column Info
	 * @param pstWkQty
	 */
	public void setPstWkQty(String pstWkQty) {
		this.pstWkQty = pstWkQty;
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
		setOfcQty(JSPUtil.getParameter(request, prefix + "ofc_qty", ""));
		setObDivCd(JSPUtil.getParameter(request, prefix + "ob_div_cd", ""));
		setOfcWkQty(JSPUtil.getParameter(request, prefix + "ofc_wk_qty", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setDiffQtyRto(JSPUtil.getParameter(request, prefix + "diff_qty_rto", ""));
		setDiffRevRto(JSPUtil.getParameter(request, prefix + "diff_rev_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setOfcRevRto(JSPUtil.getParameter(request, prefix + "ofc_rev_rto", ""));
		setOfcQtyRto(JSPUtil.getParameter(request, prefix + "ofc_qty_rto", ""));
		setOfcRev(JSPUtil.getParameter(request, prefix + "ofc_rev", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setPstQtyRto(JSPUtil.getParameter(request, prefix + "pst_qty_rto", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setPstWkRev(JSPUtil.getParameter(request, prefix + "pst_wk_rev", ""));
		setOfcWkRev(JSPUtil.getParameter(request, prefix + "ofc_wk_rev", ""));
		setDiffRev(JSPUtil.getParameter(request, prefix + "diff_rev", ""));
		setPstRevRto(JSPUtil.getParameter(request, prefix + "pst_rev_rto", ""));
		setDiffQty(JSPUtil.getParameter(request, prefix + "diff_qty", ""));
		setPstWkQty(JSPUtil.getParameter(request, prefix + "pst_wk_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaByRhqSimulationVO[]
	 */
	public SearchQtaByRhqSimulationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaByRhqSimulationVO[]
	 */
	public SearchQtaByRhqSimulationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaByRhqSimulationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcQty = (JSPUtil.getParameter(request, prefix	+ "ofc_qty", length));
			String[] obDivCd = (JSPUtil.getParameter(request, prefix	+ "ob_div_cd", length));
			String[] ofcWkQty = (JSPUtil.getParameter(request, prefix	+ "ofc_wk_qty", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] diffQtyRto = (JSPUtil.getParameter(request, prefix	+ "diff_qty_rto", length));
			String[] diffRevRto = (JSPUtil.getParameter(request, prefix	+ "diff_rev_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] ofcRevRto = (JSPUtil.getParameter(request, prefix	+ "ofc_rev_rto", length));
			String[] ofcQtyRto = (JSPUtil.getParameter(request, prefix	+ "ofc_qty_rto", length));
			String[] ofcRev = (JSPUtil.getParameter(request, prefix	+ "ofc_rev", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] pstQtyRto = (JSPUtil.getParameter(request, prefix	+ "pst_qty_rto", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] pstWkRev = (JSPUtil.getParameter(request, prefix	+ "pst_wk_rev", length));
			String[] ofcWkRev = (JSPUtil.getParameter(request, prefix	+ "ofc_wk_rev", length));
			String[] diffRev = (JSPUtil.getParameter(request, prefix	+ "diff_rev", length));
			String[] pstRevRto = (JSPUtil.getParameter(request, prefix	+ "pst_rev_rto", length));
			String[] diffQty = (JSPUtil.getParameter(request, prefix	+ "diff_qty", length));
			String[] pstWkQty = (JSPUtil.getParameter(request, prefix	+ "pst_wk_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaByRhqSimulationVO();
				if (ofcQty[i] != null)
					model.setOfcQty(ofcQty[i]);
				if (obDivCd[i] != null)
					model.setObDivCd(obDivCd[i]);
				if (ofcWkQty[i] != null)
					model.setOfcWkQty(ofcWkQty[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (diffQtyRto[i] != null)
					model.setDiffQtyRto(diffQtyRto[i]);
				if (diffRevRto[i] != null)
					model.setDiffRevRto(diffRevRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (ofcRevRto[i] != null)
					model.setOfcRevRto(ofcRevRto[i]);
				if (ofcQtyRto[i] != null)
					model.setOfcQtyRto(ofcQtyRto[i]);
				if (ofcRev[i] != null)
					model.setOfcRev(ofcRev[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (pstQtyRto[i] != null)
					model.setPstQtyRto(pstQtyRto[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (pstWkRev[i] != null)
					model.setPstWkRev(pstWkRev[i]);
				if (ofcWkRev[i] != null)
					model.setOfcWkRev(ofcWkRev[i]);
				if (diffRev[i] != null)
					model.setDiffRev(diffRev[i]);
				if (pstRevRto[i] != null)
					model.setPstRevRto(pstRevRto[i]);
				if (diffQty[i] != null)
					model.setDiffQty(diffQty[i]);
				if (pstWkQty[i] != null)
					model.setPstWkQty(pstWkQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaByRhqSimulationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaByRhqSimulationVO[]
	 */
	public SearchQtaByRhqSimulationVO[] getSearchQtaByRhqSimulationVOs(){
		SearchQtaByRhqSimulationVO[] vos = (SearchQtaByRhqSimulationVO[])models.toArray(new SearchQtaByRhqSimulationVO[models.size()]);
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
		this.ofcQty = this.ofcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDivCd = this.obDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWkQty = this.ofcWkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffQtyRto = this.diffQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRevRto = this.diffRevRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRevRto = this.ofcRevRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcQtyRto = this.ofcQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRev = this.ofcRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstQtyRto = this.pstQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstWkRev = this.pstWkRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWkRev = this.ofcWkRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRev = this.diffRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRevRto = this.pstRevRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffQty = this.diffQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstWkQty = this.pstWkQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
