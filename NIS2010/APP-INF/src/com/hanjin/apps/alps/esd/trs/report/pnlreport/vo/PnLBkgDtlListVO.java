/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLBkgDtlListVO.java
*@FileTitle : PnLBkgDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.pnlreport.vo;

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

public class PnLBkgDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PnLBkgDtlListVO> models = new ArrayList<PnLBkgDtlListVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String glineFrtRtAmt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String inlndCostUsdAmt = null;
	/* Column Info */
	private String woUsdAmt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String inlndCostTrspUsdAmt = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String ioBndNm = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sBkgArr = null;
	/* Column Info */
	private String viaNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PnLBkgDtlListVO() {}

	public PnLBkgDtlListVO(String ibflag, String pagerows, String bkgNo, String woNo, String soNo, String copNo, String eqNo, String eqTpszCd, String woOfcCd, String ioBndNm, String trspCostDtlModCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String trspCrrModCd, String glineFrtRtAmt, String inlndCostUsdAmt, String inlndCostTrspUsdAmt, String woUsdAmt, String porCd, String polCd, String podCd, String delCd, String troSeq, String sBkgArr) {
		this.toNodCd = toNodCd;
		this.glineFrtRtAmt = glineFrtRtAmt;
		this.porCd = porCd;
		this.inlndCostUsdAmt = inlndCostUsdAmt;
		this.woUsdAmt = woUsdAmt;
		this.copNo = copNo;
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
		this.woOfcCd = woOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.eqNo = eqNo;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.ioBndNm = ioBndNm;
		this.trspCrrModCd = trspCrrModCd;
		this.soNo = soNo;
		this.troSeq = troSeq;
		this.delCd = delCd;
		this.eqTpszCd = eqTpszCd;
		this.fmNodCd = fmNodCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.sBkgArr = sBkgArr;
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("gline_frt_rt_amt", getGlineFrtRtAmt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("inlnd_cost_usd_amt", getInlndCostUsdAmt());
		this.hashColumns.put("wo_usd_amt", getWoUsdAmt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("inlnd_cost_trsp_usd_amt", getInlndCostTrspUsdAmt());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("s_bkg_arr", getSBkgArr());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("gline_frt_rt_amt", "glineFrtRtAmt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("inlnd_cost_usd_amt", "inlndCostUsdAmt");
		this.hashFields.put("wo_usd_amt", "woUsdAmt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("inlnd_cost_trsp_usd_amt", "inlndCostTrspUsdAmt");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("s_bkg_arr", "sBkgArr");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return glineFrtRtAmt
	 */
	public String getGlineFrtRtAmt() {
		return this.glineFrtRtAmt;
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
	 * @return inlndCostUsdAmt
	 */
	public String getInlndCostUsdAmt() {
		return this.inlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return woUsdAmt
	 */
	public String getWoUsdAmt() {
		return this.woUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return inlndCostTrspUsdAmt
	 */
	public String getInlndCostTrspUsdAmt() {
		return this.inlndCostTrspUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return ioBndNm
	 */
	public String getIoBndNm() {
		return this.ioBndNm;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return sBkgArr
	 */
	public String getSBkgArr() {
		return this.sBkgArr;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param glineFrtRtAmt
	 */
	public void setGlineFrtRtAmt(String glineFrtRtAmt) {
		this.glineFrtRtAmt = glineFrtRtAmt;
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
	 * @param inlndCostUsdAmt
	 */
	public void setInlndCostUsdAmt(String inlndCostUsdAmt) {
		this.inlndCostUsdAmt = inlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param woUsdAmt
	 */
	public void setWoUsdAmt(String woUsdAmt) {
		this.woUsdAmt = woUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param inlndCostTrspUsdAmt
	 */
	public void setInlndCostTrspUsdAmt(String inlndCostTrspUsdAmt) {
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param ioBndNm
	 */
	public void setIoBndNm(String ioBndNm) {
		this.ioBndNm = ioBndNm;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param sBkgArr
	 */
	public void setSBkgArr(String sBkgArr) {
		this.sBkgArr = sBkgArr;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setGlineFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_frt_rt_amt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_usd_amt", ""));
		setWoUsdAmt(JSPUtil.getParameter(request, prefix + "wo_usd_amt", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_trsp_usd_amt", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSBkgArr(JSPUtil.getParameter(request, prefix + "s_bkg_arr", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PnLBkgDtlListVO[]
	 */
	public PnLBkgDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PnLBkgDtlListVO[]
	 */
	public PnLBkgDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PnLBkgDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] glineFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_frt_rt_amt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] inlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_usd_amt", length));
			String[] woUsdAmt = (JSPUtil.getParameter(request, prefix	+ "wo_usd_amt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] inlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_trsp_usd_amt", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sBkgArr = (JSPUtil.getParameter(request, prefix	+ "s_bkg_arr", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PnLBkgDtlListVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (glineFrtRtAmt[i] != null)
					model.setGlineFrtRtAmt(glineFrtRtAmt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (inlndCostUsdAmt[i] != null)
					model.setInlndCostUsdAmt(inlndCostUsdAmt[i]);
				if (woUsdAmt[i] != null)
					model.setWoUsdAmt(woUsdAmt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (inlndCostTrspUsdAmt[i] != null)
					model.setInlndCostTrspUsdAmt(inlndCostTrspUsdAmt[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (ioBndNm[i] != null)
					model.setIoBndNm(ioBndNm[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sBkgArr[i] != null)
					model.setSBkgArr(sBkgArr[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPnLBkgDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PnLBkgDtlListVO[]
	 */
	public PnLBkgDtlListVO[] getPnLBkgDtlListVOs(){
		PnLBkgDtlListVO[] vos = (PnLBkgDtlListVO[])models.toArray(new PnLBkgDtlListVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineFrtRtAmt = this.glineFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostUsdAmt = this.inlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUsdAmt = this.woUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostTrspUsdAmt = this.inlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgArr = this.sBkgArr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
