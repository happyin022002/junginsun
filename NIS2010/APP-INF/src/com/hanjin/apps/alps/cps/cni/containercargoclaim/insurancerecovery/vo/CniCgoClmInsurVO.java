/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCgoClmInsurVO.java
*@FileTitle : CniCgoClmInsurVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.03
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.11.03 정행룡 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmInsurVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmInsurVO> models = new ArrayList<CniCgoClmInsurVO>();
	
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String insurFmalClmDt = null;
	/* Column Info */
	private String agnCrspnTpCd = null;
	/* Column Info */
	private String insurRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agnCrspnApntDt = null;
	/* Column Info */
	private String insurRmk = null;
	/* Column Info */
	private String rcvrUsdAmt = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String agnCrspnRefNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String insurDmndUsdAmt = null;
	/* Column Info */
	private String insurXchRt = null;
	/* Column Info */
	private String insurDmndCurrCd = null;
	/* Column Info */
	private String insurRcvrLoclCurrCd = null;
	/* Column Info */
	private String insurRcvrAmt = null;
	/* Column Info */
	private String insurRcvrXchRt = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String insurRcvrDt = null;
	/* Column Info */
	private String insurDmndAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmInsurVO() {}

	public CniCgoClmInsurVO(String ibflag, String pagerows, String cgoClmNo, String insurClmPtyNo, String insurRefNo, String clmPtyNo, String agnCrspnTpCd, String agnCrspnApntDt, String agnCrspnRefNo, String insurPlcyYr, String rcvrUsdAmt, String insurFmalClmDt, String insurDmndUsdAmt, String insurDmndCurrCd, String insurDmndAmt, String insurXchRt, String insurRcvrDt, String insurRcvrUsdAmt, String insurRcvrLoclCurrCd, String insurRcvrAmt, String insurRcvrXchRt, String insurRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.creDt = creDt;
		this.insurFmalClmDt = insurFmalClmDt;
		this.agnCrspnTpCd = agnCrspnTpCd;
		this.insurRefNo = insurRefNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.agnCrspnApntDt = agnCrspnApntDt;
		this.insurRmk = insurRmk;
		this.rcvrUsdAmt = rcvrUsdAmt;
		this.insurPlcyYr = insurPlcyYr;
		this.cgoClmNo = cgoClmNo;
		this.agnCrspnRefNo = agnCrspnRefNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.insurDmndUsdAmt = insurDmndUsdAmt;
		this.insurXchRt = insurXchRt;
		this.insurDmndCurrCd = insurDmndCurrCd;
		this.insurRcvrLoclCurrCd = insurRcvrLoclCurrCd;
		this.insurRcvrAmt = insurRcvrAmt;
		this.insurRcvrXchRt = insurRcvrXchRt;
		this.clmPtyNo = clmPtyNo;
		this.creUsrId = creUsrId;
		this.insurClmPtyNo = insurClmPtyNo;
		this.insurRcvrDt = insurRcvrDt;
		this.insurDmndAmt = insurDmndAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("insur_fmal_clm_dt", getInsurFmalClmDt());
		this.hashColumns.put("agn_crspn_tp_cd", getAgnCrspnTpCd());
		this.hashColumns.put("insur_ref_no", getInsurRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agn_crspn_apnt_dt", getAgnCrspnApntDt());
		this.hashColumns.put("insur_rmk", getInsurRmk());
		this.hashColumns.put("rcvr_usd_amt", getRcvrUsdAmt());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("agn_crspn_ref_no", getAgnCrspnRefNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("insur_dmnd_usd_amt", getInsurDmndUsdAmt());
		this.hashColumns.put("insur_xch_rt", getInsurXchRt());
		this.hashColumns.put("insur_dmnd_curr_cd", getInsurDmndCurrCd());
		this.hashColumns.put("insur_rcvr_locl_curr_cd", getInsurRcvrLoclCurrCd());
		this.hashColumns.put("insur_rcvr_amt", getInsurRcvrAmt());
		this.hashColumns.put("insur_rcvr_xch_rt", getInsurRcvrXchRt());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("insur_rcvr_dt", getInsurRcvrDt());
		this.hashColumns.put("insur_dmnd_amt", getInsurDmndAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("insur_fmal_clm_dt", "insurFmalClmDt");
		this.hashFields.put("agn_crspn_tp_cd", "agnCrspnTpCd");
		this.hashFields.put("insur_ref_no", "insurRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agn_crspn_apnt_dt", "agnCrspnApntDt");
		this.hashFields.put("insur_rmk", "insurRmk");
		this.hashFields.put("rcvr_usd_amt", "rcvrUsdAmt");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("agn_crspn_ref_no", "agnCrspnRefNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("insur_dmnd_usd_amt", "insurDmndUsdAmt");
		this.hashFields.put("insur_xch_rt", "insurXchRt");
		this.hashFields.put("insur_dmnd_curr_cd", "insurDmndCurrCd");
		this.hashFields.put("insur_rcvr_locl_curr_cd", "insurRcvrLoclCurrCd");
		this.hashFields.put("insur_rcvr_amt", "insurRcvrAmt");
		this.hashFields.put("insur_rcvr_xch_rt", "insurRcvrXchRt");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("insur_rcvr_dt", "insurRcvrDt");
		this.hashFields.put("insur_dmnd_amt", "insurDmndAmt");
		return this.hashFields;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return insurFmalClmDt
	 */
	public String getInsurFmalClmDt() {
		return this.insurFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @return agnCrspnTpCd
	 */
	public String getAgnCrspnTpCd() {
		return this.agnCrspnTpCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return agnCrspnApntDt
	 */
	public String getAgnCrspnApntDt() {
		return this.agnCrspnApntDt;
	}
	
	/**
	 * Column Info
	 * @return insurRmk
	 */
	public String getInsurRmk() {
		return this.insurRmk;
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
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return agnCrspnRefNo
	 */
	public String getAgnCrspnRefNo() {
		return this.agnCrspnRefNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return insurDmndUsdAmt
	 */
	public String getInsurDmndUsdAmt() {
		return this.insurDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return insurXchRt
	 */
	public String getInsurXchRt() {
		return this.insurXchRt;
	}
	
	/**
	 * Column Info
	 * @return insurDmndCurrCd
	 */
	public String getInsurDmndCurrCd() {
		return this.insurDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrLoclCurrCd
	 */
	public String getInsurRcvrLoclCurrCd() {
		return this.insurRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrAmt
	 */
	public String getInsurRcvrAmt() {
		return this.insurRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrXchRt
	 */
	public String getInsurRcvrXchRt() {
		return this.insurRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return insurDmndAmt
	 */
	public String getInsurDmndAmt() {
		return this.insurDmndAmt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param insurFmalClmDt
	 */
	public void setInsurFmalClmDt(String insurFmalClmDt) {
		this.insurFmalClmDt = insurFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @param agnCrspnTpCd
	 */
	public void setAgnCrspnTpCd(String agnCrspnTpCd) {
		this.agnCrspnTpCd = agnCrspnTpCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param agnCrspnApntDt
	 */
	public void setAgnCrspnApntDt(String agnCrspnApntDt) {
		this.agnCrspnApntDt = agnCrspnApntDt;
	}
	
	/**
	 * Column Info
	 * @param insurRmk
	 */
	public void setInsurRmk(String insurRmk) {
		this.insurRmk = insurRmk;
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
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param agnCrspnRefNo
	 */
	public void setAgnCrspnRefNo(String agnCrspnRefNo) {
		this.agnCrspnRefNo = agnCrspnRefNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param insurDmndUsdAmt
	 */
	public void setInsurDmndUsdAmt(String insurDmndUsdAmt) {
		this.insurDmndUsdAmt = insurDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param insurXchRt
	 */
	public void setInsurXchRt(String insurXchRt) {
		this.insurXchRt = insurXchRt;
	}
	
	/**
	 * Column Info
	 * @param insurDmndCurrCd
	 */
	public void setInsurDmndCurrCd(String insurDmndCurrCd) {
		this.insurDmndCurrCd = insurDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrLoclCurrCd
	 */
	public void setInsurRcvrLoclCurrCd(String insurRcvrLoclCurrCd) {
		this.insurRcvrLoclCurrCd = insurRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrAmt
	 */
	public void setInsurRcvrAmt(String insurRcvrAmt) {
		this.insurRcvrAmt = insurRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrXchRt
	 */
	public void setInsurRcvrXchRt(String insurRcvrXchRt) {
		this.insurRcvrXchRt = insurRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param insurDmndAmt
	 */
	public void setInsurDmndAmt(String insurDmndAmt) {
		this.insurDmndAmt = insurDmndAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, "insur_rcvr_usd_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInsurFmalClmDt(JSPUtil.getParameter(request, "insur_fmal_clm_dt", ""));
		setAgnCrspnTpCd(JSPUtil.getParameter(request, "agn_crspn_tp_cd", ""));
		setInsurRefNo(JSPUtil.getParameter(request, "insur_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgnCrspnApntDt(JSPUtil.getParameter(request, "agn_crspn_apnt_dt", ""));
		setInsurRmk(JSPUtil.getParameter(request, "insur_rmk", ""));
		setRcvrUsdAmt(JSPUtil.getParameter(request, "rcvr_usd_amt", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, "insur_plcy_yr", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setAgnCrspnRefNo(JSPUtil.getParameter(request, "agn_crspn_ref_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInsurDmndUsdAmt(JSPUtil.getParameter(request, "insur_dmnd_usd_amt", ""));
		setInsurXchRt(JSPUtil.getParameter(request, "insur_xch_rt", ""));
		setInsurDmndCurrCd(JSPUtil.getParameter(request, "insur_dmnd_curr_cd", ""));
		setInsurRcvrLoclCurrCd(JSPUtil.getParameter(request, "insur_rcvr_locl_curr_cd", ""));
		setInsurRcvrAmt(JSPUtil.getParameter(request, "insur_rcvr_amt", ""));
		setInsurRcvrXchRt(JSPUtil.getParameter(request, "insur_rcvr_xch_rt", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
		setInsurRcvrDt(JSPUtil.getParameter(request, "insur_rcvr_dt", ""));
		setInsurDmndAmt(JSPUtil.getParameter(request, "insur_dmnd_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmInsurVO[]
	 */
	public CniCgoClmInsurVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmInsurVO[]
	 */
	public CniCgoClmInsurVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmInsurVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] insurFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "insur_fmal_clm_dt", length));
			String[] agnCrspnTpCd = (JSPUtil.getParameter(request, prefix	+ "agn_crspn_tp_cd", length));
			String[] insurRefNo = (JSPUtil.getParameter(request, prefix	+ "insur_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agnCrspnApntDt = (JSPUtil.getParameter(request, prefix	+ "agn_crspn_apnt_dt", length));
			String[] insurRmk = (JSPUtil.getParameter(request, prefix	+ "insur_rmk", length));
			String[] rcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rcvr_usd_amt", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] agnCrspnRefNo = (JSPUtil.getParameter(request, prefix	+ "agn_crspn_ref_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] insurDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_usd_amt", length));
			String[] insurXchRt = (JSPUtil.getParameter(request, prefix	+ "insur_xch_rt", length));
			String[] insurDmndCurrCd = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_curr_cd", length));
			String[] insurRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_locl_curr_cd", length));
			String[] insurRcvrAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_amt", length));
			String[] insurRcvrXchRt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_xch_rt", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] insurRcvrDt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_dt", length));
			String[] insurDmndAmt = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmInsurVO();
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (insurFmalClmDt[i] != null)
					model.setInsurFmalClmDt(insurFmalClmDt[i]);
				if (agnCrspnTpCd[i] != null)
					model.setAgnCrspnTpCd(agnCrspnTpCd[i]);
				if (insurRefNo[i] != null)
					model.setInsurRefNo(insurRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agnCrspnApntDt[i] != null)
					model.setAgnCrspnApntDt(agnCrspnApntDt[i]);
				if (insurRmk[i] != null)
					model.setInsurRmk(insurRmk[i]);
				if (rcvrUsdAmt[i] != null)
					model.setRcvrUsdAmt(rcvrUsdAmt[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (agnCrspnRefNo[i] != null)
					model.setAgnCrspnRefNo(agnCrspnRefNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (insurDmndUsdAmt[i] != null)
					model.setInsurDmndUsdAmt(insurDmndUsdAmt[i]);
				if (insurXchRt[i] != null)
					model.setInsurXchRt(insurXchRt[i]);
				if (insurDmndCurrCd[i] != null)
					model.setInsurDmndCurrCd(insurDmndCurrCd[i]);
				if (insurRcvrLoclCurrCd[i] != null)
					model.setInsurRcvrLoclCurrCd(insurRcvrLoclCurrCd[i]);
				if (insurRcvrAmt[i] != null)
					model.setInsurRcvrAmt(insurRcvrAmt[i]);
				if (insurRcvrXchRt[i] != null)
					model.setInsurRcvrXchRt(insurRcvrXchRt[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (insurRcvrDt[i] != null)
					model.setInsurRcvrDt(insurRcvrDt[i]);
				if (insurDmndAmt[i] != null)
					model.setInsurDmndAmt(insurDmndAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmInsurVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmInsurVO[]
	 */
	public CniCgoClmInsurVO[] getCniCgoClmInsurVOs(){
		CniCgoClmInsurVO[] vos = (CniCgoClmInsurVO[])models.toArray(new CniCgoClmInsurVO[models.size()]);
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
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFmalClmDt = this.insurFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCrspnTpCd = this.agnCrspnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRefNo = this.insurRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCrspnApntDt = this.agnCrspnApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRmk = this.insurRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrUsdAmt = this.rcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCrspnRefNo = this.agnCrspnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndUsdAmt = this.insurDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurXchRt = this.insurXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndCurrCd = this.insurDmndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrLoclCurrCd = this.insurRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrAmt = this.insurRcvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrXchRt = this.insurRcvrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrDt = this.insurRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndAmt = this.insurDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
