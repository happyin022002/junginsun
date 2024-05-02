/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DmtTimeClockStopVO.java
*@FileTitle : DmtTimeClockStopVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.23 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtTimeClockStopVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtTimeClockStopVO> models = new ArrayList<DmtTimeClockStopVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String clkStopFmDt = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String clkStopOfcCd = null;
	/* Column Info */
	private String clkStopYdNm = null;
	/* Column Info */
	private String dupYn = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dmdtTrfNm = null;
	/* Column Info */
	private String authYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clkStopNo = null;
	/* Column Info */
	private String clkStopToDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clkStopRmk = null;
	/* Column Info */
	private String stopDays = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String allYdFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String clkStopOfcNm = null;
	/* Column Info */
	private String clkStopYdCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String dmdtBkgTermCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtTimeClockStopVO() {}

	public DmtTimeClockStopVO(String ibflag, String pagerows, String clkStopNo, String cxlFlg, String dmdtTrfCd, String dmdtTrfNm, String clkStopOfcCd, String clkStopOfcNm, String clkStopYdCd, String clkStopYdNm, String allYdFlg, String clkStopFmDt, String clkStopToDt, String stopDays, String clkStopRmk, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String authYn, String dupYn, String seq, String dmdtBkgTermCtnt) {
		this.updDt = updDt;
		this.clkStopFmDt = clkStopFmDt;
		this.cxlFlg = cxlFlg;
		this.clkStopOfcCd = clkStopOfcCd;
		this.clkStopYdNm = clkStopYdNm;
		this.dupYn = dupYn;
		this.creDt = creDt;
		this.dmdtTrfNm = dmdtTrfNm;
		this.authYn = authYn;
		this.pagerows = pagerows;
		this.clkStopNo = clkStopNo;
		this.clkStopToDt = clkStopToDt;
		this.creUsrId = creUsrId;
		this.clkStopRmk = clkStopRmk;
		this.stopDays = stopDays;
		this.ibflag = ibflag;
		this.allYdFlg = allYdFlg;
		this.creOfcCd = creOfcCd;
		this.seq = seq;
		this.clkStopOfcNm = clkStopOfcNm;
		this.clkStopYdCd = clkStopYdCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.dmdtBkgTermCtnt = dmdtBkgTermCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("clk_stop_fm_dt", getClkStopFmDt());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("clk_stop_ofc_cd", getClkStopOfcCd());
		this.hashColumns.put("clk_stop_yd_nm", getClkStopYdNm());
		this.hashColumns.put("dup_yn", getDupYn());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dmdt_trf_nm", getDmdtTrfNm());
		this.hashColumns.put("auth_yn", getAuthYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clk_stop_no", getClkStopNo());
		this.hashColumns.put("clk_stop_to_dt", getClkStopToDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clk_stop_rmk", getClkStopRmk());
		this.hashColumns.put("stop_days", getStopDays());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("all_yd_flg", getAllYdFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("clk_stop_ofc_nm", getClkStopOfcNm());
		this.hashColumns.put("clk_stop_yd_cd", getClkStopYdCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("dmdt_bkg_term_ctnt", getDmdtBkgTermCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("clk_stop_fm_dt", "clkStopFmDt");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("clk_stop_ofc_cd", "clkStopOfcCd");
		this.hashFields.put("clk_stop_yd_nm", "clkStopYdNm");
		this.hashFields.put("dup_yn", "dupYn");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dmdt_trf_nm", "dmdtTrfNm");
		this.hashFields.put("auth_yn", "authYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clk_stop_no", "clkStopNo");
		this.hashFields.put("clk_stop_to_dt", "clkStopToDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clk_stop_rmk", "clkStopRmk");
		this.hashFields.put("stop_days", "stopDays");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("all_yd_flg", "allYdFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("clk_stop_ofc_nm", "clkStopOfcNm");
		this.hashFields.put("clk_stop_yd_cd", "clkStopYdCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("dmdt_bkg_term_ctnt", "dmdtBkgTermCtnt");
		return this.hashFields;
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
	 * @return clkStopFmDt
	 */
	public String getClkStopFmDt() {
		return this.clkStopFmDt;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return clkStopOfcCd
	 */
	public String getClkStopOfcCd() {
		return this.clkStopOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clkStopYdNm
	 */
	public String getClkStopYdNm() {
		return this.clkStopYdNm;
	}
	
	/**
	 * Column Info
	 * @return dupYn
	 */
	public String getDupYn() {
		return this.dupYn;
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
	 * @return dmdtTrfNm
	 */
	public String getDmdtTrfNm() {
		return this.dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @return authYn
	 */
	public String getAuthYn() {
		return this.authYn;
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
	 * @return clkStopNo
	 */
	public String getClkStopNo() {
		return this.clkStopNo;
	}
	
	/**
	 * Column Info
	 * @return clkStopToDt
	 */
	public String getClkStopToDt() {
		return this.clkStopToDt;
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
	 * @return clkStopRmk
	 */
	public String getClkStopRmk() {
		return this.clkStopRmk;
	}
	
	/**
	 * Column Info
	 * @return stopDays
	 */
	public String getStopDays() {
		return this.stopDays;
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
	 * @return allYdFlg
	 */
	public String getAllYdFlg() {
		return this.allYdFlg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return clkStopOfcNm
	 */
	public String getClkStopOfcNm() {
		return this.clkStopOfcNm;
	}
	
	/**
	 * Column Info
	 * @return clkStopYdCd
	 */
	public String getClkStopYdCd() {
		return this.clkStopYdCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtBkgTermCtnt
	 */
	public String getDmdtBkgTermCtnt() {
		return dmdtBkgTermCtnt;
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
	 * @param clkStopFmDt
	 */
	public void setClkStopFmDt(String clkStopFmDt) {
		this.clkStopFmDt = clkStopFmDt;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param clkStopOfcCd
	 */
	public void setClkStopOfcCd(String clkStopOfcCd) {
		this.clkStopOfcCd = clkStopOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clkStopYdNm
	 */
	public void setClkStopYdNm(String clkStopYdNm) {
		this.clkStopYdNm = clkStopYdNm;
	}
	
	/**
	 * Column Info
	 * @param dupYn
	 */
	public void setDupYn(String dupYn) {
		this.dupYn = dupYn;
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
	 * @param dmdtTrfNm
	 */
	public void setDmdtTrfNm(String dmdtTrfNm) {
		this.dmdtTrfNm = dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @param authYn
	 */
	public void setAuthYn(String authYn) {
		this.authYn = authYn;
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
	 * @param clkStopNo
	 */
	public void setClkStopNo(String clkStopNo) {
		this.clkStopNo = clkStopNo;
	}
	
	/**
	 * Column Info
	 * @param clkStopToDt
	 */
	public void setClkStopToDt(String clkStopToDt) {
		this.clkStopToDt = clkStopToDt;
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
	 * @param clkStopRmk
	 */
	public void setClkStopRmk(String clkStopRmk) {
		this.clkStopRmk = clkStopRmk;
	}
	
	/**
	 * Column Info
	 * @param stopDays
	 */
	public void setStopDays(String stopDays) {
		this.stopDays = stopDays;
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
	 * @param allYdFlg
	 */
	public void setAllYdFlg(String allYdFlg) {
		this.allYdFlg = allYdFlg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param clkStopOfcNm
	 */
	public void setClkStopOfcNm(String clkStopOfcNm) {
		this.clkStopOfcNm = clkStopOfcNm;
	}
	
	/**
	 * Column Info
	 * @param clkStopYdCd
	 */
	public void setClkStopYdCd(String clkStopYdCd) {
		this.clkStopYdCd = clkStopYdCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}

	/**
	 * Column Info
	 * @return dmdtBkgTermCtnt
	 */
	public void setDmdtBkgTermCtnt(String dmdtBkgTermCtnt) {
		this.dmdtBkgTermCtnt = dmdtBkgTermCtnt;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setClkStopFmDt(JSPUtil.getParameter(request, prefix + "clk_stop_fm_dt", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setClkStopOfcCd(JSPUtil.getParameter(request, prefix + "clk_stop_ofc_cd", ""));
		setClkStopYdNm(JSPUtil.getParameter(request, prefix + "clk_stop_yd_nm", ""));
		setDupYn(JSPUtil.getParameter(request, prefix + "dup_yn", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDmdtTrfNm(JSPUtil.getParameter(request, prefix + "dmdt_trf_nm", ""));
		setAuthYn(JSPUtil.getParameter(request, prefix + "auth_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClkStopNo(JSPUtil.getParameter(request, prefix + "clk_stop_no", ""));
		setClkStopToDt(JSPUtil.getParameter(request, prefix + "clk_stop_to_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setClkStopRmk(JSPUtil.getParameter(request, prefix + "clk_stop_rmk", ""));
		setStopDays(JSPUtil.getParameter(request, prefix + "stop_days", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAllYdFlg(JSPUtil.getParameter(request, prefix + "all_yd_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setClkStopOfcNm(JSPUtil.getParameter(request, prefix + "clk_stop_ofc_nm", ""));
		setClkStopYdCd(JSPUtil.getParameter(request, prefix + "clk_stop_yd_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDmdtBkgTermCtnt(JSPUtil.getParameter(request, prefix + "dmdt_bkg_term_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtTimeClockStopVO[]
	 */
	public DmtTimeClockStopVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtTimeClockStopVO[]
	 */
	public DmtTimeClockStopVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtTimeClockStopVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] clkStopFmDt = (JSPUtil.getParameter(request, prefix	+ "clk_stop_fm_dt", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] clkStopOfcCd = (JSPUtil.getParameter(request, prefix	+ "clk_stop_ofc_cd", length));
			String[] clkStopYdNm = (JSPUtil.getParameter(request, prefix	+ "clk_stop_yd_nm", length));
			String[] dupYn = (JSPUtil.getParameter(request, prefix	+ "dup_yn", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dmdtTrfNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_nm", length));
			String[] authYn = (JSPUtil.getParameter(request, prefix	+ "auth_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clkStopNo = (JSPUtil.getParameter(request, prefix	+ "clk_stop_no", length));
			String[] clkStopToDt = (JSPUtil.getParameter(request, prefix	+ "clk_stop_to_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] clkStopRmk = (JSPUtil.getParameter(request, prefix	+ "clk_stop_rmk", length));
			String[] stopDays = (JSPUtil.getParameter(request, prefix	+ "stop_days", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] allYdFlg = (JSPUtil.getParameter(request, prefix	+ "all_yd_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] clkStopOfcNm = (JSPUtil.getParameter(request, prefix	+ "clk_stop_ofc_nm", length));
			String[] clkStopYdCd = (JSPUtil.getParameter(request, prefix	+ "clk_stop_yd_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] dmdtBkgTermCtnt = (JSPUtil.getParameter(request, prefix	+ "dmdt_bkg_term_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtTimeClockStopVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (clkStopFmDt[i] != null)
					model.setClkStopFmDt(clkStopFmDt[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (clkStopOfcCd[i] != null)
					model.setClkStopOfcCd(clkStopOfcCd[i]);
				if (clkStopYdNm[i] != null)
					model.setClkStopYdNm(clkStopYdNm[i]);
				if (dupYn[i] != null)
					model.setDupYn(dupYn[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dmdtTrfNm[i] != null)
					model.setDmdtTrfNm(dmdtTrfNm[i]);
				if (authYn[i] != null)
					model.setAuthYn(authYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clkStopNo[i] != null)
					model.setClkStopNo(clkStopNo[i]);
				if (clkStopToDt[i] != null)
					model.setClkStopToDt(clkStopToDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clkStopRmk[i] != null)
					model.setClkStopRmk(clkStopRmk[i]);
				if (stopDays[i] != null)
					model.setStopDays(stopDays[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (allYdFlg[i] != null)
					model.setAllYdFlg(allYdFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (clkStopOfcNm[i] != null)
					model.setClkStopOfcNm(clkStopOfcNm[i]);
				if (clkStopYdCd[i] != null)
					model.setClkStopYdCd(clkStopYdCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (dmdtBkgTermCtnt[i] != null)
					model.setDmdtBkgTermCtnt(dmdtBkgTermCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtTimeClockStopVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtTimeClockStopVO[]
	 */
	public DmtTimeClockStopVO[] getDmtTimeClockStopVOs(){
		DmtTimeClockStopVO[] vos = (DmtTimeClockStopVO[])models.toArray(new DmtTimeClockStopVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopFmDt = this.clkStopFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopOfcCd = this.clkStopOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopYdNm = this.clkStopYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupYn = this.dupYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfNm = this.dmdtTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authYn = this.authYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopNo = this.clkStopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopToDt = this.clkStopToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopRmk = this.clkStopRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopDays = this.stopDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allYdFlg = this.allYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopOfcNm = this.clkStopOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopYdCd = this.clkStopYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBkgTermCtnt = this.dmdtBkgTermCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
