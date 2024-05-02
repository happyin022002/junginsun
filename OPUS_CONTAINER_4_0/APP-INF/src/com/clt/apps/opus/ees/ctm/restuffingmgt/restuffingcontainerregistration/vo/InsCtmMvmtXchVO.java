/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsCtmMvmtXchVO.java
*@FileTitle : InsCtmMvmtXchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.11 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InsCtmMvmtXchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InsCtmMvmtXchVO> models = new ArrayList<InsCtmMvmtXchVO>();
	
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrXchSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xchCntrCycNo = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrXchRefMon = null;
	/* Column Info */
	private String xchCntrTpszCd = null;
	/* Column Info */
	private String xchOfcCd = null;
	/* Column Info */
	private String xchCntrYr = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrXchRefYr = null;
	/* Column Info */
	private String xchCnmvIdNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String preCnmvStsCd = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String xchRmk = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrXchRefSeq = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String xchCntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InsCtmMvmtXchVO() {}

	public InsCtmMvmtXchVO(String ibflag, String pagerows, String cntrNo, String cnmvYr, String cnmvIdNo, String cntrXchRefSeq, String cntrXchSeq, String cntrTpszCd, String cnmvCycNo, String cnmvStsCd, String xchCntrNo, String xchCntrYr, String xchCnmvIdNo, String xchCntrTpszCd, String xchCntrCycNo, String preCnmvStsCd, String xchRmk, String xchOfcCd, String cntrXchRefYr, String cntrXchRefMon, String orgYdCd, String creLoclDt, String creDt, String updUsrId, String creUsrId, String updLoclDt, String updDt) {
		this.cnmvCycNo = cnmvCycNo;
		this.creDt = creDt;
		this.cntrXchSeq = cntrXchSeq;
		this.pagerows = pagerows;
		this.xchCntrCycNo = xchCntrCycNo;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.cntrXchRefMon = cntrXchRefMon;
		this.xchCntrTpszCd = xchCntrTpszCd;
		this.xchOfcCd = xchOfcCd;
		this.xchCntrYr = xchCntrYr;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrXchRefYr = cntrXchRefYr;
		this.xchCnmvIdNo = xchCnmvIdNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.preCnmvStsCd = preCnmvStsCd;
		this.updLoclDt = updLoclDt;
		this.orgYdCd = orgYdCd;
		this.xchRmk = xchRmk;
		this.cnmvIdNo = cnmvIdNo;
		this.creUsrId = creUsrId;
		this.cntrXchRefSeq = cntrXchRefSeq;
		this.creLoclDt = creLoclDt;
		this.cntrNo = cntrNo;
		this.cnmvYr = cnmvYr;
		this.xchCntrNo = xchCntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_xch_seq", getCntrXchSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xch_cntr_cyc_no", getXchCntrCycNo());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_xch_ref_mon", getCntrXchRefMon());
		this.hashColumns.put("xch_cntr_tpsz_cd", getXchCntrTpszCd());
		this.hashColumns.put("xch_ofc_cd", getXchOfcCd());
		this.hashColumns.put("xch_cntr_yr", getXchCntrYr());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_xch_ref_yr", getCntrXchRefYr());
		this.hashColumns.put("xch_cnmv_id_no", getXchCnmvIdNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pre_cnmv_sts_cd", getPreCnmvStsCd());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("xch_rmk", getXchRmk());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_xch_ref_seq", getCntrXchRefSeq());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("xch_cntr_no", getXchCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_xch_seq", "cntrXchSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xch_cntr_cyc_no", "xchCntrCycNo");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_xch_ref_mon", "cntrXchRefMon");
		this.hashFields.put("xch_cntr_tpsz_cd", "xchCntrTpszCd");
		this.hashFields.put("xch_ofc_cd", "xchOfcCd");
		this.hashFields.put("xch_cntr_yr", "xchCntrYr");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_xch_ref_yr", "cntrXchRefYr");
		this.hashFields.put("xch_cnmv_id_no", "xchCnmvIdNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pre_cnmv_sts_cd", "preCnmvStsCd");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("xch_rmk", "xchRmk");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_xch_ref_seq", "cntrXchRefSeq");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("xch_cntr_no", "xchCntrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
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
	 * @return cntrXchSeq
	 */
	public String getCntrXchSeq() {
		return this.cntrXchSeq;
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
	 * @return xchCntrCycNo
	 */
	public String getXchCntrCycNo() {
		return this.xchCntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return cntrXchRefMon
	 */
	public String getCntrXchRefMon() {
		return this.cntrXchRefMon;
	}
	
	/**
	 * Column Info
	 * @return xchCntrTpszCd
	 */
	public String getXchCntrTpszCd() {
		return this.xchCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return xchOfcCd
	 */
	public String getXchOfcCd() {
		return this.xchOfcCd;
	}
	
	/**
	 * Column Info
	 * @return xchCntrYr
	 */
	public String getXchCntrYr() {
		return this.xchCntrYr;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrXchRefYr
	 */
	public String getCntrXchRefYr() {
		return this.cntrXchRefYr;
	}
	
	/**
	 * Column Info
	 * @return xchCnmvIdNo
	 */
	public String getXchCnmvIdNo() {
		return this.xchCnmvIdNo;
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
	 * @return preCnmvStsCd
	 */
	public String getPreCnmvStsCd() {
		return this.preCnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return xchRmk
	 */
	public String getXchRmk() {
		return this.xchRmk;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return cntrXchRefSeq
	 */
	public String getCntrXchRefSeq() {
		return this.cntrXchRefSeq;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return xchCntrNo
	 */
	public String getXchCntrNo() {
		return this.xchCntrNo;
	}
	

	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
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
	 * @param cntrXchSeq
	 */
	public void setCntrXchSeq(String cntrXchSeq) {
		this.cntrXchSeq = cntrXchSeq;
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
	 * @param xchCntrCycNo
	 */
	public void setXchCntrCycNo(String xchCntrCycNo) {
		this.xchCntrCycNo = xchCntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param cntrXchRefMon
	 */
	public void setCntrXchRefMon(String cntrXchRefMon) {
		this.cntrXchRefMon = cntrXchRefMon;
	}
	
	/**
	 * Column Info
	 * @param xchCntrTpszCd
	 */
	public void setXchCntrTpszCd(String xchCntrTpszCd) {
		this.xchCntrTpszCd = xchCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param xchOfcCd
	 */
	public void setXchOfcCd(String xchOfcCd) {
		this.xchOfcCd = xchOfcCd;
	}
	
	/**
	 * Column Info
	 * @param xchCntrYr
	 */
	public void setXchCntrYr(String xchCntrYr) {
		this.xchCntrYr = xchCntrYr;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrXchRefYr
	 */
	public void setCntrXchRefYr(String cntrXchRefYr) {
		this.cntrXchRefYr = cntrXchRefYr;
	}
	
	/**
	 * Column Info
	 * @param xchCnmvIdNo
	 */
	public void setXchCnmvIdNo(String xchCnmvIdNo) {
		this.xchCnmvIdNo = xchCnmvIdNo;
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
	 * @param preCnmvStsCd
	 */
	public void setPreCnmvStsCd(String preCnmvStsCd) {
		this.preCnmvStsCd = preCnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param xchRmk
	 */
	public void setXchRmk(String xchRmk) {
		this.xchRmk = xchRmk;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
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
	 * @param cntrXchRefSeq
	 */
	public void setCntrXchRefSeq(String cntrXchRefSeq) {
		this.cntrXchRefSeq = cntrXchRefSeq;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param xchCntrNo
	 */
	public void setXchCntrNo(String xchCntrNo) {
		this.xchCntrNo = xchCntrNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrXchSeq(JSPUtil.getParameter(request, "cntr_xch_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setXchCntrCycNo(JSPUtil.getParameter(request, "xch_cntr_cyc_no", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrXchRefMon(JSPUtil.getParameter(request, "cntr_xch_ref_mon", ""));
		setXchCntrTpszCd(JSPUtil.getParameter(request, "xch_cntr_tpsz_cd", ""));
		setXchOfcCd(JSPUtil.getParameter(request, "xch_ofc_cd", ""));
		setXchCntrYr(JSPUtil.getParameter(request, "xch_cntr_yr", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrXchRefYr(JSPUtil.getParameter(request, "cntr_xch_ref_yr", ""));
		setXchCnmvIdNo(JSPUtil.getParameter(request, "xch_cnmv_id_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setPreCnmvStsCd(JSPUtil.getParameter(request, "pre_cnmv_sts_cd", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, "upd_locl_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setXchRmk(JSPUtil.getParameter(request, "xch_rmk", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntrXchRefSeq(JSPUtil.getParameter(request, "cntr_xch_ref_seq", ""));
		setCreLoclDt(JSPUtil.getParameter(request, "cre_locl_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setXchCntrNo(JSPUtil.getParameter(request, "xch_cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InsCtmMvmtXchVO[]
	 */
	public InsCtmMvmtXchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InsCtmMvmtXchVO[]
	 */
	public InsCtmMvmtXchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InsCtmMvmtXchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrXchSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xchCntrCycNo = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_cyc_no", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrXchRefMon = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_ref_mon", length));
			String[] xchCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_tpsz_cd", length));
			String[] xchOfcCd = (JSPUtil.getParameter(request, prefix	+ "xch_ofc_cd", length));
			String[] xchCntrYr = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_yr", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrXchRefYr = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_ref_yr", length));
			String[] xchCnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "xch_cnmv_id_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] preCnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "pre_cnmv_sts_cd", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] xchRmk = (JSPUtil.getParameter(request, prefix	+ "xch_rmk", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrXchRefSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_ref_seq", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] xchCntrNo = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InsCtmMvmtXchVO();
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrXchSeq[i] != null)
					model.setCntrXchSeq(cntrXchSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xchCntrCycNo[i] != null)
					model.setXchCntrCycNo(xchCntrCycNo[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrXchRefMon[i] != null)
					model.setCntrXchRefMon(cntrXchRefMon[i]);
				if (xchCntrTpszCd[i] != null)
					model.setXchCntrTpszCd(xchCntrTpszCd[i]);
				if (xchOfcCd[i] != null)
					model.setXchOfcCd(xchOfcCd[i]);
				if (xchCntrYr[i] != null)
					model.setXchCntrYr(xchCntrYr[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrXchRefYr[i] != null)
					model.setCntrXchRefYr(cntrXchRefYr[i]);
				if (xchCnmvIdNo[i] != null)
					model.setXchCnmvIdNo(xchCnmvIdNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (preCnmvStsCd[i] != null)
					model.setPreCnmvStsCd(preCnmvStsCd[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (xchRmk[i] != null)
					model.setXchRmk(xchRmk[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrXchRefSeq[i] != null)
					model.setCntrXchRefSeq(cntrXchRefSeq[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (xchCntrNo[i] != null)
					model.setXchCntrNo(xchCntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInsCtmMvmtXchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InsCtmMvmtXchVO[]
	 */
	public InsCtmMvmtXchVO[] getInsCtmMvmtXchVOs(){
		InsCtmMvmtXchVO[] vos = (InsCtmMvmtXchVO[])models.toArray(new InsCtmMvmtXchVO[models.size()]);
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
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchSeq = this.cntrXchSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrCycNo = this.xchCntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchRefMon = this.cntrXchRefMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrTpszCd = this.xchCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchOfcCd = this.xchOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrYr = this.xchCntrYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchRefYr = this.cntrXchRefYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCnmvIdNo = this.xchCnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCnmvStsCd = this.preCnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRmk = this.xchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchRefSeq = this.cntrXchRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrNo = this.xchCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
