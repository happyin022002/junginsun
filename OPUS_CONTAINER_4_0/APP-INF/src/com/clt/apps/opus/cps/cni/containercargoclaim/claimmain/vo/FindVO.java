/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FindVO.java
*@FileTitle : FindVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.11.11 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FindVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FindVO> models = new ArrayList<FindVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String insurRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pastCgoClmNo = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String cgoClmRefBlNo = null;
	/* Column Info */
	private String clmPtyAbbrNm = null;
	/* Column Info */
	private String cgoClmDivCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cgoClmStlLoclAmt = null;
	/* Column Info */
	private String clmtClmTpCd = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String cgoClmRefCntrNo = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String liableParty = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String claimant = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FindVO() {}

	public FindVO(String ibflag, String pagerows, String cgoClmDivCd, String cgoClmNo, String cgoClmRefBlNo, String cgoClmRefCntrNo, String trnkRefVvdNo, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String stsCd, String fmalClmRcvDt, String cgoClmInciNo, String crmVocNo, String updDt, String clmtClmTpCd, String claimant, String clmtLoclAmt, String cgoClmStlTpCd, String cgoClmStlLoclAmt, String liableParty, String clmPtyAbbrNm, String insurRefNo, String pastCgoClmNo, String rowNum, String total) {
		this.total = total;
		this.clmtLoclAmt = clmtLoclAmt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.insurRefNo = insurRefNo;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.ibflag = ibflag;
		this.pastCgoClmNo = pastCgoClmNo;
		this.cgoClmNo = cgoClmNo;
		this.cgoClmRefBlNo = cgoClmRefBlNo;
		this.clmPtyAbbrNm = clmPtyAbbrNm;
		this.cgoClmDivCd = cgoClmDivCd;
		this.updDt = updDt;
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
		this.clmtClmTpCd = clmtClmTpCd;
		this.hdlrUsrId = hdlrUsrId;
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.liableParty = liableParty;
		this.cgoClmInciNo = cgoClmInciNo;
		this.crmVocNo = crmVocNo;
		this.rowNum = rowNum;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmAreaCd = clmAreaCd;
		this.claimant = claimant;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("insur_ref_no", getInsurRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("past_cgo_clm_no", getPastCgoClmNo());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("cgo_clm_ref_bl_no", getCgoClmRefBlNo());
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());
		this.hashColumns.put("cgo_clm_div_cd", getCgoClmDivCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cgo_clm_stl_locl_amt", getCgoClmStlLoclAmt());
		this.hashColumns.put("clmt_clm_tp_cd", getClmtClmTpCd());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("cgo_clm_ref_cntr_no", getCgoClmRefCntrNo());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("liable_party", getLiableParty());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("claimant", getClaimant());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("insur_ref_no", "insurRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("past_cgo_clm_no", "pastCgoClmNo");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("cgo_clm_ref_bl_no", "cgoClmRefBlNo");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("cgo_clm_div_cd", "cgoClmDivCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cgo_clm_stl_locl_amt", "cgoClmStlLoclAmt");
		this.hashFields.put("clmt_clm_tp_cd", "clmtClmTpCd");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("cgo_clm_ref_cntr_no", "cgoClmRefCntrNo");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("liable_party", "liableParty");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("claimant", "claimant");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return clmtLoclAmt
	 */
	public String getClmtLoclAmt() {
		return this.clmtLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @return insurRefNo
	 */
	public String getInsurRefNo() {
		return this.insurRefNo;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return pastCgoClmNo
	 */
	public String getPastCgoClmNo() {
		return this.pastCgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmRefBlNo
	 */
	public String getCgoClmRefBlNo() {
		return this.cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm
	 */
	public String getClmPtyAbbrNm() {
		return this.clmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cgoClmDivCd
	 */
	public String getCgoClmDivCd() {
		return this.cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlLoclAmt
	 */
	public String getCgoClmStlLoclAmt() {
		return this.cgoClmStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return clmtClmTpCd
	 */
	public String getClmtClmTpCd() {
		return this.clmtClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return cgoClmRefCntrNo
	 */
	public String getCgoClmRefCntrNo() {
		return this.cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return liableParty
	 */
	public String getLiableParty() {
		return this.liableParty;
	}
	
	/**
	 * Column Info
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @return crmVocNo
	 */
	public String getCrmVocNo() {
		return this.crmVocNo;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @return claimant
	 */
	public String getClaimant() {
		return this.claimant;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param clmtLoclAmt
	 */
	public void setClmtLoclAmt(String clmtLoclAmt) {
		this.clmtLoclAmt = clmtLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @param insurRefNo
	 */
	public void setInsurRefNo(String insurRefNo) {
		this.insurRefNo = insurRefNo;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param pastCgoClmNo
	 */
	public void setPastCgoClmNo(String pastCgoClmNo) {
		this.pastCgoClmNo = pastCgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmRefBlNo
	 */
	public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
		this.cgoClmRefBlNo = cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm
	 */
	public void setClmPtyAbbrNm(String clmPtyAbbrNm) {
		this.clmPtyAbbrNm = clmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cgoClmDivCd
	 */
	public void setCgoClmDivCd(String cgoClmDivCd) {
		this.cgoClmDivCd = cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlLoclAmt
	 */
	public void setCgoClmStlLoclAmt(String cgoClmStlLoclAmt) {
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param clmtClmTpCd
	 */
	public void setClmtClmTpCd(String clmtClmTpCd) {
		this.clmtClmTpCd = clmtClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param cgoClmRefCntrNo
	 */
	public void setCgoClmRefCntrNo(String cgoClmRefCntrNo) {
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param liableParty
	 */
	public void setLiableParty(String liableParty) {
		this.liableParty = liableParty;
	}
	
	/**
	 * Column Info
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @param crmVocNo
	 */
	public void setCrmVocNo(String crmVocNo) {
		this.crmVocNo = crmVocNo;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @param claimant
	 */
	public void setClaimant(String claimant) {
		this.claimant = claimant;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, "clmt_locl_amt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, "trnk_ref_vvd_no", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, "fmal_clm_rcv_dt", ""));
		setInsurRefNo(JSPUtil.getParameter(request, "insur_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPastCgoClmNo(JSPUtil.getParameter(request, "past_cgo_clm_no", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setCgoClmRefBlNo(JSPUtil.getParameter(request, "cgo_clm_ref_bl_no", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request, "clm_pty_abbr_nm", ""));
		setCgoClmDivCd(JSPUtil.getParameter(request, "cgo_clm_div_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCgoClmStlLoclAmt(JSPUtil.getParameter(request, "cgo_clm_stl_locl_amt", ""));
		setClmtClmTpCd(JSPUtil.getParameter(request, "clmt_clm_tp_cd", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, "hdlr_usr_id", ""));
		setCgoClmRefCntrNo(JSPUtil.getParameter(request, "cgo_clm_ref_cntr_no", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, "cgo_clm_stl_tp_cd", ""));
		setLiableParty(JSPUtil.getParameter(request, "liable_party", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, "cgo_clm_inci_no", ""));
		setCrmVocNo(JSPUtil.getParameter(request, "crm_voc_no", ""));
		setRowNum(JSPUtil.getParameter(request, "row_num", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, "hdlr_ofc_cd", ""));
		setClmAreaCd(JSPUtil.getParameter(request, "clm_area_cd", ""));
		setClaimant(JSPUtil.getParameter(request, "claimant", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FindVO[]
	 */
	public FindVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FindVO[]
	 */
	public FindVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FindVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] insurRefNo = (JSPUtil.getParameter(request, prefix	+ "insur_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pastCgoClmNo = (JSPUtil.getParameter(request, prefix	+ "past_cgo_clm_no", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] cgoClmRefBlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_bl_no", length));
			String[] clmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm", length));
			String[] cgoClmDivCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cgoClmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_amt", length));
			String[] clmtClmTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_tp_cd", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] cgoClmRefCntrNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_cntr_no", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] liableParty = (JSPUtil.getParameter(request, prefix	+ "liable_party", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] claimant = (JSPUtil.getParameter(request, prefix	+ "claimant", length));
			
			for (int i = 0; i < length; i++) {
				model = new FindVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (insurRefNo[i] != null)
					model.setInsurRefNo(insurRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pastCgoClmNo[i] != null)
					model.setPastCgoClmNo(pastCgoClmNo[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (cgoClmRefBlNo[i] != null)
					model.setCgoClmRefBlNo(cgoClmRefBlNo[i]);
				if (clmPtyAbbrNm[i] != null)
					model.setClmPtyAbbrNm(clmPtyAbbrNm[i]);
				if (cgoClmDivCd[i] != null)
					model.setCgoClmDivCd(cgoClmDivCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cgoClmStlLoclAmt[i] != null)
					model.setCgoClmStlLoclAmt(cgoClmStlLoclAmt[i]);
				if (clmtClmTpCd[i] != null)
					model.setClmtClmTpCd(clmtClmTpCd[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (cgoClmRefCntrNo[i] != null)
					model.setCgoClmRefCntrNo(cgoClmRefCntrNo[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (liableParty[i] != null)
					model.setLiableParty(liableParty[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (claimant[i] != null)
					model.setClaimant(claimant[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFindVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FindVO[]
	 */
	public FindVO[] getFindVOs(){
		FindVO[] vos = (FindVO[])models.toArray(new FindVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRefNo = this.insurRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastCgoClmNo = this.pastCgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefBlNo = this.cgoClmRefBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm = this.clmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivCd = this.cgoClmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclAmt = this.cgoClmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmTpCd = this.clmtClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefCntrNo = this.cgoClmRefCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liableParty = this.liableParty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.claimant = this.claimant .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
