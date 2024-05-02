/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchQtaAdjustmentForSectorListVO.java
*@FileTitle : SearchQtaAdjustmentForSectorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo;

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

public class SearchQtaAdjustmentForSectorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaAdjustmentForSectorListVO> models = new ArrayList<SearchQtaAdjustmentForSectorListVO>();
	
	/* Column Info */
	private String qtaRlseVerNo = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String fClick = null;
	/* Column Info */
	private String coaBseWk = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String coaBseMon = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String iasRgnCd = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String coaFnlBsaCapa = null;
	/* Column Info */
	private String coaVvd = null;
	/* Column Info */
	private String fnlBsaCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchQtaAdjustmentForSectorListVO() {}

	public SearchQtaAdjustmentForSectorListVO(String ibflag, String pagerows, String qtaRlseVerNo, String trdCd, String rlaneCd, String subTrdCd, String dirCd, String iasRgnCd, String iocCd, String bseMon, String bseWk, String vvd, String fnlBsaCapa, String lodQty, String grsRev, String coaBseMon, String coaBseWk, String coaVvd, String coaFnlBsaCapa, String flag, String fClick, String bseTpCd, String bseYr, String bseQtrCd) {
		this.qtaRlseVerNo = qtaRlseVerNo;
		this.iocCd = iocCd;
		this.lodQty = lodQty;
		this.fClick = fClick;
		this.coaBseWk = coaBseWk;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.coaBseMon = coaBseMon;
		this.rlaneCd = rlaneCd;
		this.iasRgnCd = iasRgnCd;
		this.bseWk = bseWk;
		this.coaFnlBsaCapa = coaFnlBsaCapa;
		this.coaVvd = coaVvd;
		this.fnlBsaCapa = fnlBsaCapa;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.bseMon = bseMon;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.flag = flag;
		this.grsRev = grsRev;
		this.bseTpCd = bseTpCd;
		this.dirCd = dirCd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qta_rlse_ver_no", getQtaRlseVerNo());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("f_click", getFClick());
		this.hashColumns.put("coa_bse_wk", getCoaBseWk());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("coa_bse_mon", getCoaBseMon());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("coa_fnl_bsa_capa", getCoaFnlBsaCapa());
		this.hashColumns.put("coa_vvd", getCoaVvd());
		this.hashColumns.put("fnl_bsa_capa", getFnlBsaCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qta_rlse_ver_no", "qtaRlseVerNo");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("f_click", "fClick");
		this.hashFields.put("coa_bse_wk", "coaBseWk");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("coa_bse_mon", "coaBseMon");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("coa_fnl_bsa_capa", "coaFnlBsaCapa");
		this.hashFields.put("coa_vvd", "coaVvd");
		this.hashFields.put("fnl_bsa_capa", "fnlBsaCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qtaRlseVerNo
	 */
	public String getQtaRlseVerNo() {
		return this.qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return fClick
	 */
	public String getFClick() {
		return this.fClick;
	}
	
	/**
	 * Column Info
	 * @return coaBseWk
	 */
	public String getCoaBseWk() {
		return this.coaBseWk;
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
	 * @return coaBseMon
	 */
	public String getCoaBseMon() {
		return this.coaBseMon;
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
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
	}
	
	/**
	 * Column Info
	 * @return coaFnlBsaCapa
	 */
	public String getCoaFnlBsaCapa() {
		return this.coaFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return coaVvd
	 */
	public String getCoaVvd() {
		return this.coaVvd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaCapa
	 */
	public String getFnlBsaCapa() {
		return this.fnlBsaCapa;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param qtaRlseVerNo
	 */
	public void setQtaRlseVerNo(String qtaRlseVerNo) {
		this.qtaRlseVerNo = qtaRlseVerNo;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param fClick
	 */
	public void setFClick(String fClick) {
		this.fClick = fClick;
	}
	
	/**
	 * Column Info
	 * @param coaBseWk
	 */
	public void setCoaBseWk(String coaBseWk) {
		this.coaBseWk = coaBseWk;
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
	 * @param coaBseMon
	 */
	public void setCoaBseMon(String coaBseMon) {
		this.coaBseMon = coaBseMon;
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
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
	}
	
	/**
	 * Column Info
	 * @param coaFnlBsaCapa
	 */
	public void setCoaFnlBsaCapa(String coaFnlBsaCapa) {
		this.coaFnlBsaCapa = coaFnlBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param coaVvd
	 */
	public void setCoaVvd(String coaVvd) {
		this.coaVvd = coaVvd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaCapa
	 */
	public void setFnlBsaCapa(String fnlBsaCapa) {
		this.fnlBsaCapa = fnlBsaCapa;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
		setQtaRlseVerNo(JSPUtil.getParameter(request, prefix + "qta_rlse_ver_no", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setFClick(JSPUtil.getParameter(request, prefix + "f_click", ""));
		setCoaBseWk(JSPUtil.getParameter(request, prefix + "coa_bse_wk", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setCoaBseMon(JSPUtil.getParameter(request, prefix + "coa_bse_mon", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, prefix + "ias_rgn_cd", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setCoaFnlBsaCapa(JSPUtil.getParameter(request, prefix + "coa_fnl_bsa_capa", ""));
		setCoaVvd(JSPUtil.getParameter(request, prefix + "coa_vvd", ""));
		setFnlBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_bsa_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setBseMon(JSPUtil.getParameter(request, prefix + "bse_mon", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaAdjustmentForSectorListVO[]
	 */
	public SearchQtaAdjustmentForSectorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaAdjustmentForSectorListVO[]
	 */
	public SearchQtaAdjustmentForSectorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaAdjustmentForSectorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qtaRlseVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_rlse_ver_no", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] fClick = (JSPUtil.getParameter(request, prefix	+ "f_click", length));
			String[] coaBseWk = (JSPUtil.getParameter(request, prefix	+ "coa_bse_wk", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] coaBseMon = (JSPUtil.getParameter(request, prefix	+ "coa_bse_mon", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] coaFnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "coa_fnl_bsa_capa", length));
			String[] coaVvd = (JSPUtil.getParameter(request, prefix	+ "coa_vvd", length));
			String[] fnlBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaAdjustmentForSectorListVO();
				if (qtaRlseVerNo[i] != null)
					model.setQtaRlseVerNo(qtaRlseVerNo[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (fClick[i] != null)
					model.setFClick(fClick[i]);
				if (coaBseWk[i] != null)
					model.setCoaBseWk(coaBseWk[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (coaBseMon[i] != null)
					model.setCoaBseMon(coaBseMon[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (coaFnlBsaCapa[i] != null)
					model.setCoaFnlBsaCapa(coaFnlBsaCapa[i]);
				if (coaVvd[i] != null)
					model.setCoaVvd(coaVvd[i]);
				if (fnlBsaCapa[i] != null)
					model.setFnlBsaCapa(fnlBsaCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaAdjustmentForSectorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaAdjustmentForSectorListVO[]
	 */
	public SearchQtaAdjustmentForSectorListVO[] getSearchQtaAdjustmentForSectorListVOs(){
		SearchQtaAdjustmentForSectorListVO[] vos = (SearchQtaAdjustmentForSectorListVO[])models.toArray(new SearchQtaAdjustmentForSectorListVO[models.size()]);
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
		this.qtaRlseVerNo = this.qtaRlseVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fClick = this.fClick .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaBseWk = this.coaBseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaBseMon = this.coaBseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaFnlBsaCapa = this.coaFnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaVvd = this.coaVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaCapa = this.fnlBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
