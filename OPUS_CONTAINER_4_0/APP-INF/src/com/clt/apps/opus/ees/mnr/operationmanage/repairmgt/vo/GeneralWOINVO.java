/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralWOINVO.java
*@FileTitle : GeneralWOINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

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

public class GeneralWOINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GeneralWOINVO> models = new ArrayList<GeneralWOINVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String mnrRtTpCd = null;
	/* Column Info */
	private String mnrWoTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String sprPrtSplDt = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String fGubuns = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String sprPrtSplTpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ordHdrRmk = null;
	/* Column Info */
	private String sprPrtSplYdCd = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String ydCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GeneralWOINVO() {}

	public GeneralWOINVO(String ibflag, String pagerows, String currCd, String costOfcCd, String mnrGrpTpCd, String fGubuns, String agmtSeq, String mnrRtTpCd, String costDtlCd, String mnrWoTpCd, String eqKndCd, String ordHdrRmk, String costCd, String mnrOrdSeq, String vndrSeq, String agmtOfcCtyCd, String fileSeq, String rprQty, String agmtVerNo, String sprPrtSplTpCd, String vslCd, String skdVoyNo, String skdDirCd, String sprPrtSplYdCd, String sprPrtSplDt, String ydCd) {
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.mnrRtTpCd = mnrRtTpCd;
		this.mnrWoTpCd = mnrWoTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.sprPrtSplDt = sprPrtSplDt;
		this.rprQty = rprQty;
		this.costOfcCd = costOfcCd;
		this.agmtSeq = agmtSeq;
		this.fGubuns = fGubuns;
		this.costDtlCd = costDtlCd;
		this.sprPrtSplTpCd = sprPrtSplTpCd;
		this.skdVoyNo = skdVoyNo;
		this.eqKndCd = eqKndCd;
		this.skdDirCd = skdDirCd;
		this.ordHdrRmk = ordHdrRmk;
		this.sprPrtSplYdCd = sprPrtSplYdCd;
		this.mnrOrdSeq = mnrOrdSeq;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.fileSeq = fileSeq;
		this.agmtVerNo = agmtVerNo;
		this.ydCd = ydCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("mnr_rt_tp_cd", getMnrRtTpCd());
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("spr_prt_spl_dt", getSprPrtSplDt());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("f_gubuns", getFGubuns());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("spr_prt_spl_tp_cd", getSprPrtSplTpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ord_hdr_rmk", getOrdHdrRmk());
		this.hashColumns.put("spr_prt_spl_yd_cd", getSprPrtSplYdCd());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("yd_cd", getYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("mnr_rt_tp_cd", "mnrRtTpCd");
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("spr_prt_spl_dt", "sprPrtSplDt");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("f_gubuns", "fGubuns");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("spr_prt_spl_tp_cd", "sprPrtSplTpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ord_hdr_rmk", "ordHdrRmk");
		this.hashFields.put("spr_prt_spl_yd_cd", "sprPrtSplYdCd");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("yd_cd", "ydCd");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrRtTpCd
	 */
	public String getMnrRtTpCd() {
		return this.mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrWoTpCd
	 */
	public String getMnrWoTpCd() {
		return this.mnrWoTpCd;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSplDt
	 */
	public String getSprPrtSplDt() {
		return this.sprPrtSplDt;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return fGubuns
	 */
	public String getFGubuns() {
		return this.fGubuns;
	}
	
	/**
	 * Column Info
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSplTpCd
	 */
	public String getSprPrtSplTpCd() {
		return this.sprPrtSplTpCd;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return ordHdrRmk
	 */
	public String getOrdHdrRmk() {
		return this.ordHdrRmk;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSplYdCd
	 */
	public String getSprPrtSplYdCd() {
		return this.sprPrtSplYdCd;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrRtTpCd
	 */
	public void setMnrRtTpCd(String mnrRtTpCd) {
		this.mnrRtTpCd = mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrWoTpCd
	 */
	public void setMnrWoTpCd(String mnrWoTpCd) {
		this.mnrWoTpCd = mnrWoTpCd;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSplDt
	 */
	public void setSprPrtSplDt(String sprPrtSplDt) {
		this.sprPrtSplDt = sprPrtSplDt;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param fGubuns
	 */
	public void setFGubuns(String fGubuns) {
		this.fGubuns = fGubuns;
	}
	
	/**
	 * Column Info
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSplTpCd
	 */
	public void setSprPrtSplTpCd(String sprPrtSplTpCd) {
		this.sprPrtSplTpCd = sprPrtSplTpCd;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param ordHdrRmk
	 */
	public void setOrdHdrRmk(String ordHdrRmk) {
		this.ordHdrRmk = ordHdrRmk;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSplYdCd
	 */
	public void setSprPrtSplYdCd(String sprPrtSplYdCd) {
		this.sprPrtSplYdCd = sprPrtSplYdCd;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setMnrRtTpCd(JSPUtil.getParameter(request, "mnr_rt_tp_cd", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request, "mnr_wo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setSprPrtSplDt(JSPUtil.getParameter(request, "spr_prt_spl_dt", ""));
		setRprQty(JSPUtil.getParameter(request, "rpr_qty", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setFGubuns(JSPUtil.getParameter(request, "f_gubuns", ""));
		setCostDtlCd(JSPUtil.getParameter(request, "cost_dtl_cd", ""));
		setSprPrtSplTpCd(JSPUtil.getParameter(request, "spr_prt_spl_tp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setOrdHdrRmk(JSPUtil.getParameter(request, "ord_hdr_rmk", ""));
		setSprPrtSplYdCd(JSPUtil.getParameter(request, "spr_prt_spl_yd_cd", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, "mnr_ord_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GeneralWOINVO[]
	 */
	public GeneralWOINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GeneralWOINVO[]
	 */
	public GeneralWOINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GeneralWOINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] mnrRtTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rt_tp_cd", length));
			String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] sprPrtSplDt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_dt", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] fGubuns = (JSPUtil.getParameter(request, prefix	+ "f_gubuns", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] sprPrtSplTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_tp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ordHdrRmk = (JSPUtil.getParameter(request, prefix	+ "ord_hdr_rmk", length));
			String[] sprPrtSplYdCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_spl_yd_cd", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GeneralWOINVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (mnrRtTpCd[i] != null)
					model.setMnrRtTpCd(mnrRtTpCd[i]);
				if (mnrWoTpCd[i] != null)
					model.setMnrWoTpCd(mnrWoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (sprPrtSplDt[i] != null)
					model.setSprPrtSplDt(sprPrtSplDt[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (fGubuns[i] != null)
					model.setFGubuns(fGubuns[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (sprPrtSplTpCd[i] != null)
					model.setSprPrtSplTpCd(sprPrtSplTpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ordHdrRmk[i] != null)
					model.setOrdHdrRmk(ordHdrRmk[i]);
				if (sprPrtSplYdCd[i] != null)
					model.setSprPrtSplYdCd(sprPrtSplYdCd[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGeneralWOINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GeneralWOINVO[]
	 */
	public GeneralWOINVO[] getGeneralWOINVOs(){
		GeneralWOINVO[] vos = (GeneralWOINVO[])models.toArray(new GeneralWOINVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRtTpCd = this.mnrRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd = this.mnrWoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplDt = this.sprPrtSplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGubuns = this.fGubuns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplTpCd = this.sprPrtSplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordHdrRmk = this.ordHdrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplYdCd = this.sprPrtSplYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
