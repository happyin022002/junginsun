/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceRecoveryByVvdVO.java
*@FileTitle : InsuranceRecoveryByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.18 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InsuranceRecoveryByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InsuranceRecoveryByVvdVO> models = new ArrayList<InsuranceRecoveryByVvdVO>();
	
	/* Column Info */
	private String cgoClmStlXchRt = null;
	/* Column Info */
	private String dataSeq = null;
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String insurFmalClmDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String rcvrUsdAmt = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String insurDmndUsdAmt = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String cgoClmStlLoclCurrCd = null;
	/* Column Info */
	private String lodgDt = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String insurRcvrDt = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String hdlrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InsuranceRecoveryByVvdVO() {}

	public InsuranceRecoveryByVvdVO(String ibflag, String pagerows, String trnkRefVvdNo, String cgoClmNo, String cgoClmStsCd, String clmtUsdAmt, String fmalClmRcvDt, String cgoClmStlUsdAmt, String cgoClmStlDt, String rcvrUsdAmt, String insurDmndUsdAmt, String insurFmalClmDt, String insurRcvrUsdAmt, String insurRcvrDt, String lablPtyRcvrUsdAmt, String lablPtyRcvrDt, String lodgDt, String rctDt, String insurClmPtyNo, String insurPlcyYr, String cgoClmStlLoclCurrCd, String cgoClmStlXchRt, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String dataSeq) {
		this.cgoClmStlXchRt = cgoClmStlXchRt;
		this.dataSeq = dataSeq;
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.insurFmalClmDt = insurFmalClmDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cgoClmStsCd = cgoClmStsCd;
		this.rcvrUsdAmt = rcvrUsdAmt;
		this.insurPlcyYr = insurPlcyYr;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.cgoClmNo = cgoClmNo;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.insurDmndUsdAmt = insurDmndUsdAmt;
		this.cgoClmStlDt = cgoClmStlDt;
		this.hdlrUsrId = hdlrUsrId;
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
		this.lodgDt = lodgDt;
		this.rctDt = rctDt;
		this.clmtUsdAmt = clmtUsdAmt;
		this.insurClmPtyNo = insurClmPtyNo;
		this.insurRcvrDt = insurRcvrDt;
		this.clmAreaCd = clmAreaCd;
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_clm_stl_xch_rt", getCgoClmStlXchRt());
		this.hashColumns.put("data_seq", getDataSeq());
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("insur_fmal_clm_dt", getInsurFmalClmDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("rcvr_usd_amt", getRcvrUsdAmt());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("insur_dmnd_usd_amt", getInsurDmndUsdAmt());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("cgo_clm_stl_locl_curr_cd", getCgoClmStlLoclCurrCd());
		this.hashColumns.put("lodg_dt", getLodgDt());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("insur_rcvr_dt", getInsurRcvrDt());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_clm_stl_xch_rt", "cgoClmStlXchRt");
		this.hashFields.put("data_seq", "dataSeq");
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("insur_fmal_clm_dt", "insurFmalClmDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("rcvr_usd_amt", "rcvrUsdAmt");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("insur_dmnd_usd_amt", "insurDmndUsdAmt");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("cgo_clm_stl_locl_curr_cd", "cgoClmStlLoclCurrCd");
		this.hashFields.put("lodg_dt", "lodgDt");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("insur_rcvr_dt", "insurRcvrDt");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlXchRt
	 */
	public String getCgoClmStlXchRt() {
		return this.cgoClmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @return dataSeq
	 */
	public String getDataSeq() {
		return this.dataSeq;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrUsdAmt
	 */
	public String getInsurRcvrUsdAmt() {
		return this.insurRcvrUsdAmt;
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
	 * @return lablPtyRcvrUsdAmt
	 */
	public String getLablPtyRcvrUsdAmt() {
		return this.lablPtyRcvrUsdAmt;
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
	 * @return insurFmalClmDt
	 */
	public String getInsurFmalClmDt() {
		return this.insurFmalClmDt;
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
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return rcvrUsdAmt
	 */
	public String getRcvrUsdAmt() {
		return this.rcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlUsdAmt
	 */
	public String getCgoClmStlUsdAmt() {
		return this.cgoClmStlUsdAmt;
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
	 * @return lablPtyRcvrDt
	 */
	public String getLablPtyRcvrDt() {
		return this.lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return insurDmndUsdAmt
	 */
	public String getInsurDmndUsdAmt() {
		return this.insurDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
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
	 * @return cgoClmStlLoclCurrCd
	 */
	public String getCgoClmStlLoclCurrCd() {
		return this.cgoClmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return lodgDt
	 */
	public String getLodgDt() {
		return this.lodgDt;
	}
	
	/**
	 * Column Info
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
	}
	
	/**
	 * Column Info
	 * @return clmtUsdAmt
	 */
	public String getClmtUsdAmt() {
		return this.clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrDt
	 */
	public String getInsurRcvrDt() {
		return this.insurRcvrDt;
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
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	

	/**
	 * Column Info
	 * @param cgoClmStlXchRt
	 */
	public void setCgoClmStlXchRt(String cgoClmStlXchRt) {
		this.cgoClmStlXchRt = cgoClmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @param dataSeq
	 */
	public void setDataSeq(String dataSeq) {
		this.dataSeq = dataSeq;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrUsdAmt
	 */
	public void setInsurRcvrUsdAmt(String insurRcvrUsdAmt) {
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
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
	 * @param lablPtyRcvrUsdAmt
	 */
	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
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
	 * @param insurFmalClmDt
	 */
	public void setInsurFmalClmDt(String insurFmalClmDt) {
		this.insurFmalClmDt = insurFmalClmDt;
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
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param rcvrUsdAmt
	 */
	public void setRcvrUsdAmt(String rcvrUsdAmt) {
		this.rcvrUsdAmt = rcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlUsdAmt
	 */
	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
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
	 * @param lablPtyRcvrDt
	 */
	public void setLablPtyRcvrDt(String lablPtyRcvrDt) {
		this.lablPtyRcvrDt = lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param insurDmndUsdAmt
	 */
	public void setInsurDmndUsdAmt(String insurDmndUsdAmt) {
		this.insurDmndUsdAmt = insurDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
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
	 * @param cgoClmStlLoclCurrCd
	 */
	public void setCgoClmStlLoclCurrCd(String cgoClmStlLoclCurrCd) {
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param lodgDt
	 */
	public void setLodgDt(String lodgDt) {
		this.lodgDt = lodgDt;
	}
	
	/**
	 * Column Info
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
	
	/**
	 * Column Info
	 * @param clmtUsdAmt
	 */
	public void setClmtUsdAmt(String clmtUsdAmt) {
		this.clmtUsdAmt = clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrDt
	 */
	public void setInsurRcvrDt(String insurRcvrDt) {
		this.insurRcvrDt = insurRcvrDt;
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
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
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
		setCgoClmStlXchRt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_xch_rt", ""));
		setDataSeq(JSPUtil.getParameter(request, prefix + "data_seq", ""));
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_usd_amt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setInsurFmalClmDt(JSPUtil.getParameter(request, prefix + "insur_fmal_clm_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "rcvr_usd_amt", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, prefix + "insur_plcy_yr", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_usd_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setInsurDmndUsdAmt(JSPUtil.getParameter(request, prefix + "insur_dmnd_usd_amt", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_dt", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setCgoClmStlLoclCurrCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_curr_cd", ""));
		setLodgDt(JSPUtil.getParameter(request, prefix + "lodg_dt", ""));
		setRctDt(JSPUtil.getParameter(request, prefix + "rct_dt", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setInsurRcvrDt(JSPUtil.getParameter(request, prefix + "insur_rcvr_dt", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InsuranceRecoveryByVvdVO[]
	 */
	public InsuranceRecoveryByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InsuranceRecoveryByVvdVO[]
	 */
	public InsuranceRecoveryByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InsuranceRecoveryByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoClmStlXchRt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_xch_rt", length));
			String[] dataSeq = (JSPUtil.getParameter(request, prefix	+ "data_seq", length));
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] insurFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "insur_fmal_clm_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] rcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rcvr_usd_amt", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] insurDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_usd_amt", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] cgoClmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_curr_cd", length));
			String[] lodgDt = (JSPUtil.getParameter(request, prefix	+ "lodg_dt", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] insurRcvrDt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_dt", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InsuranceRecoveryByVvdVO();
				if (cgoClmStlXchRt[i] != null)
					model.setCgoClmStlXchRt(cgoClmStlXchRt[i]);
				if (dataSeq[i] != null)
					model.setDataSeq(dataSeq[i]);
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (insurFmalClmDt[i] != null)
					model.setInsurFmalClmDt(insurFmalClmDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (rcvrUsdAmt[i] != null)
					model.setRcvrUsdAmt(rcvrUsdAmt[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (insurDmndUsdAmt[i] != null)
					model.setInsurDmndUsdAmt(insurDmndUsdAmt[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (cgoClmStlLoclCurrCd[i] != null)
					model.setCgoClmStlLoclCurrCd(cgoClmStlLoclCurrCd[i]);
				if (lodgDt[i] != null)
					model.setLodgDt(lodgDt[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (insurRcvrDt[i] != null)
					model.setInsurRcvrDt(insurRcvrDt[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInsuranceRecoveryByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InsuranceRecoveryByVvdVO[]
	 */
	public InsuranceRecoveryByVvdVO[] getInsuranceRecoveryByVvdVOs(){
		InsuranceRecoveryByVvdVO[] vos = (InsuranceRecoveryByVvdVO[])models.toArray(new InsuranceRecoveryByVvdVO[models.size()]);
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
		this.cgoClmStlXchRt = this.cgoClmStlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataSeq = this.dataSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFmalClmDt = this.insurFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrUsdAmt = this.rcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndUsdAmt = this.insurDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclCurrCd = this.cgoClmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDt = this.lodgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrDt = this.insurRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
