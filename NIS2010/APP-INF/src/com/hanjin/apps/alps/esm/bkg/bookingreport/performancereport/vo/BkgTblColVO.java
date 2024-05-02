/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgTblColVO.java
*@FileTitle : BkgTblColVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.04 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTblColVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgTblColVO> models = new ArrayList<BkgTblColVO>();
	
	/* Column Info */
	private String stsRptFlg = null;
	/* Column Info */
	private String dpNm = null;
	/* Column Info */
	private String colNm = null;
	/* Column Info */
	private String vipRptFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String caRptFlg = null;
	/* Column Info */
	private String sqlCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hisCateNm = null;
	/* Column Info */
	private String invIfFlg = null;
	/* Column Info */
	private String caExptFlg = null;
	/* Column Info */
	private String bkgRptKndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String updGrpCd = null;
	/* Column Info */
	private String hisFlg = null;
	/* Column Info */
	private String copIfFlg = null;
	/* Column Info */
	private String coaIfFlg = null;
	/* Column Info */
	private String caRevFlg = null;
	/* Column Info */
	private String ordSeq = null;
	/* Column Info */
	private String tblColNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String caCostFlg = null;
	/* Column Info */
	private String updSubGrpCd = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String tblNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgTblColVO() {}

	public BkgTblColVO(String ibflag, String pagerows, String tblNm, String colNm, String stsRptFlg, String caRptFlg, String vipRptFlg, String hisCateNm, String tblColNm, String dpNm, String sqlCtnt, String hisFlg, String caExptFlg, String caRevFlg, String caCostFlg, String invIfFlg, String copIfFlg, String coaIfFlg, String updGrpCd, String updSubGrpCd, String creUsrId, String creDt, String updUsrId, String updDt, String rptId, String bkgRptKndCd, String ordSeq) {
		this.stsRptFlg = stsRptFlg;
		this.dpNm = dpNm;
		this.colNm = colNm;
		this.vipRptFlg = vipRptFlg;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.caRptFlg = caRptFlg;
		this.sqlCtnt = sqlCtnt;
		this.ibflag = ibflag;
		this.hisCateNm = hisCateNm;
		this.invIfFlg = invIfFlg;
		this.caExptFlg = caExptFlg;
		this.bkgRptKndCd = bkgRptKndCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.updGrpCd = updGrpCd;
		this.hisFlg = hisFlg;
		this.copIfFlg = copIfFlg;
		this.coaIfFlg = coaIfFlg;
		this.caRevFlg = caRevFlg;
		this.ordSeq = ordSeq;
		this.tblColNm = tblColNm;
		this.creUsrId = creUsrId;
		this.caCostFlg = caCostFlg;
		this.updSubGrpCd = updSubGrpCd;
		this.rptId = rptId;
		this.tblNm = tblNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sts_rpt_flg", getStsRptFlg());
		this.hashColumns.put("dp_nm", getDpNm());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("vip_rpt_flg", getVipRptFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ca_rpt_flg", getCaRptFlg());
		this.hashColumns.put("sql_ctnt", getSqlCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("his_cate_nm", getHisCateNm());
		this.hashColumns.put("inv_if_flg", getInvIfFlg());
		this.hashColumns.put("ca_expt_flg", getCaExptFlg());
		this.hashColumns.put("bkg_rpt_knd_cd", getBkgRptKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_grp_cd", getUpdGrpCd());
		this.hashColumns.put("his_flg", getHisFlg());
		this.hashColumns.put("cop_if_flg", getCopIfFlg());
		this.hashColumns.put("coa_if_flg", getCoaIfFlg());
		this.hashColumns.put("ca_rev_flg", getCaRevFlg());
		this.hashColumns.put("ord_seq", getOrdSeq());
		this.hashColumns.put("tbl_col_nm", getTblColNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ca_cost_flg", getCaCostFlg());
		this.hashColumns.put("upd_sub_grp_cd", getUpdSubGrpCd());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("tbl_nm", getTblNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sts_rpt_flg", "stsRptFlg");
		this.hashFields.put("dp_nm", "dpNm");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("vip_rpt_flg", "vipRptFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ca_rpt_flg", "caRptFlg");
		this.hashFields.put("sql_ctnt", "sqlCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("his_cate_nm", "hisCateNm");
		this.hashFields.put("inv_if_flg", "invIfFlg");
		this.hashFields.put("ca_expt_flg", "caExptFlg");
		this.hashFields.put("bkg_rpt_knd_cd", "bkgRptKndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_grp_cd", "updGrpCd");
		this.hashFields.put("his_flg", "hisFlg");
		this.hashFields.put("cop_if_flg", "copIfFlg");
		this.hashFields.put("coa_if_flg", "coaIfFlg");
		this.hashFields.put("ca_rev_flg", "caRevFlg");
		this.hashFields.put("ord_seq", "ordSeq");
		this.hashFields.put("tbl_col_nm", "tblColNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ca_cost_flg", "caCostFlg");
		this.hashFields.put("upd_sub_grp_cd", "updSubGrpCd");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("tbl_nm", "tblNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stsRptFlg
	 */
	public String getStsRptFlg() {
		return this.stsRptFlg;
	}
	
	/**
	 * Column Info
	 * @return dpNm
	 */
	public String getDpNm() {
		return this.dpNm;
	}
	
	/**
	 * Column Info
	 * @return colNm
	 */
	public String getColNm() {
		return this.colNm;
	}
	
	/**
	 * Column Info
	 * @return vipRptFlg
	 */
	public String getVipRptFlg() {
		return this.vipRptFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return caRptFlg
	 */
	public String getCaRptFlg() {
		return this.caRptFlg;
	}
	
	/**
	 * Column Info
	 * @return sqlCtnt
	 */
	public String getSqlCtnt() {
		return this.sqlCtnt;
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
	 * @return hisCateNm
	 */
	public String getHisCateNm() {
		return this.hisCateNm;
	}
	
	/**
	 * Column Info
	 * @return invIfFlg
	 */
	public String getInvIfFlg() {
		return this.invIfFlg;
	}
	
	/**
	 * Column Info
	 * @return caExptFlg
	 */
	public String getCaExptFlg() {
		return this.caExptFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgRptKndCd
	 */
	public String getBkgRptKndCd() {
		return this.bkgRptKndCd;
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
	 * @return updGrpCd
	 */
	public String getUpdGrpCd() {
		return this.updGrpCd;
	}
	
	/**
	 * Column Info
	 * @return hisFlg
	 */
	public String getHisFlg() {
		return this.hisFlg;
	}
	
	/**
	 * Column Info
	 * @return copIfFlg
	 */
	public String getCopIfFlg() {
		return this.copIfFlg;
	}
	
	/**
	 * Column Info
	 * @return coaIfFlg
	 */
	public String getCoaIfFlg() {
		return this.coaIfFlg;
	}
	
	/**
	 * Column Info
	 * @return caRevFlg
	 */
	public String getCaRevFlg() {
		return this.caRevFlg;
	}
	
	/**
	 * Column Info
	 * @return ordSeq
	 */
	public String getOrdSeq() {
		return this.ordSeq;
	}
	
	/**
	 * Column Info
	 * @return tblColNm
	 */
	public String getTblColNm() {
		return this.tblColNm;
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
	 * @return caCostFlg
	 */
	public String getCaCostFlg() {
		return this.caCostFlg;
	}
	
	/**
	 * Column Info
	 * @return updSubGrpCd
	 */
	public String getUpdSubGrpCd() {
		return this.updSubGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rptId
	 */
	public String getRptId() {
		return this.rptId;
	}
	
	/**
	 * Column Info
	 * @return tblNm
	 */
	public String getTblNm() {
		return this.tblNm;
	}
	

	/**
	 * Column Info
	 * @param stsRptFlg
	 */
	public void setStsRptFlg(String stsRptFlg) {
		this.stsRptFlg = stsRptFlg;
	}
	
	/**
	 * Column Info
	 * @param dpNm
	 */
	public void setDpNm(String dpNm) {
		this.dpNm = dpNm;
	}
	
	/**
	 * Column Info
	 * @param colNm
	 */
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	
	/**
	 * Column Info
	 * @param vipRptFlg
	 */
	public void setVipRptFlg(String vipRptFlg) {
		this.vipRptFlg = vipRptFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param caRptFlg
	 */
	public void setCaRptFlg(String caRptFlg) {
		this.caRptFlg = caRptFlg;
	}
	
	/**
	 * Column Info
	 * @param sqlCtnt
	 */
	public void setSqlCtnt(String sqlCtnt) {
		this.sqlCtnt = sqlCtnt;
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
	 * @param hisCateNm
	 */
	public void setHisCateNm(String hisCateNm) {
		this.hisCateNm = hisCateNm;
	}
	
	/**
	 * Column Info
	 * @param invIfFlg
	 */
	public void setInvIfFlg(String invIfFlg) {
		this.invIfFlg = invIfFlg;
	}
	
	/**
	 * Column Info
	 * @param caExptFlg
	 */
	public void setCaExptFlg(String caExptFlg) {
		this.caExptFlg = caExptFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgRptKndCd
	 */
	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
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
	 * @param updGrpCd
	 */
	public void setUpdGrpCd(String updGrpCd) {
		this.updGrpCd = updGrpCd;
	}
	
	/**
	 * Column Info
	 * @param hisFlg
	 */
	public void setHisFlg(String hisFlg) {
		this.hisFlg = hisFlg;
	}
	
	/**
	 * Column Info
	 * @param copIfFlg
	 */
	public void setCopIfFlg(String copIfFlg) {
		this.copIfFlg = copIfFlg;
	}
	
	/**
	 * Column Info
	 * @param coaIfFlg
	 */
	public void setCoaIfFlg(String coaIfFlg) {
		this.coaIfFlg = coaIfFlg;
	}
	
	/**
	 * Column Info
	 * @param caRevFlg
	 */
	public void setCaRevFlg(String caRevFlg) {
		this.caRevFlg = caRevFlg;
	}
	
	/**
	 * Column Info
	 * @param ordSeq
	 */
	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}
	
	/**
	 * Column Info
	 * @param tblColNm
	 */
	public void setTblColNm(String tblColNm) {
		this.tblColNm = tblColNm;
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
	 * @param caCostFlg
	 */
	public void setCaCostFlg(String caCostFlg) {
		this.caCostFlg = caCostFlg;
	}
	
	/**
	 * Column Info
	 * @param updSubGrpCd
	 */
	public void setUpdSubGrpCd(String updSubGrpCd) {
		this.updSubGrpCd = updSubGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rptId
	 */
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	/**
	 * Column Info
	 * @param tblNm
	 */
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStsRptFlg(JSPUtil.getParameter(request, "sts_rpt_flg", ""));
		setDpNm(JSPUtil.getParameter(request, "dp_nm", ""));
		setColNm(JSPUtil.getParameter(request, "col_nm", ""));
		setVipRptFlg(JSPUtil.getParameter(request, "vip_rpt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCaRptFlg(JSPUtil.getParameter(request, "ca_rpt_flg", ""));
		setSqlCtnt(JSPUtil.getParameter(request, "sql_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHisCateNm(JSPUtil.getParameter(request, "his_cate_nm", ""));
		setInvIfFlg(JSPUtil.getParameter(request, "inv_if_flg", ""));
		setCaExptFlg(JSPUtil.getParameter(request, "ca_expt_flg", ""));
		setBkgRptKndCd(JSPUtil.getParameter(request, "bkg_rpt_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setUpdGrpCd(JSPUtil.getParameter(request, "upd_grp_cd", ""));
		setHisFlg(JSPUtil.getParameter(request, "his_flg", ""));
		setCopIfFlg(JSPUtil.getParameter(request, "cop_if_flg", ""));
		setCoaIfFlg(JSPUtil.getParameter(request, "coa_if_flg", ""));
		setCaRevFlg(JSPUtil.getParameter(request, "ca_rev_flg", ""));
		setOrdSeq(JSPUtil.getParameter(request, "ord_seq", ""));
		setTblColNm(JSPUtil.getParameter(request, "tbl_col_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCaCostFlg(JSPUtil.getParameter(request, "ca_cost_flg", ""));
		setUpdSubGrpCd(JSPUtil.getParameter(request, "upd_sub_grp_cd", ""));
		setRptId(JSPUtil.getParameter(request, "rpt_id", ""));
		setTblNm(JSPUtil.getParameter(request, "tbl_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTblColVO[]
	 */
	public BkgTblColVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgTblColVO[]
	 */
	public BkgTblColVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTblColVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stsRptFlg = (JSPUtil.getParameter(request, prefix	+ "sts_rpt_flg".trim(), length));
			String[] dpNm = (JSPUtil.getParameter(request, prefix	+ "dp_nm".trim(), length));
			String[] colNm = (JSPUtil.getParameter(request, prefix	+ "col_nm".trim(), length));
			String[] vipRptFlg = (JSPUtil.getParameter(request, prefix	+ "vip_rpt_flg".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] caRptFlg = (JSPUtil.getParameter(request, prefix	+ "ca_rpt_flg".trim(), length));
			String[] sqlCtnt = (JSPUtil.getParameter(request, prefix	+ "sql_ctnt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] hisCateNm = (JSPUtil.getParameter(request, prefix	+ "his_cate_nm".trim(), length));
			String[] invIfFlg = (JSPUtil.getParameter(request, prefix	+ "inv_if_flg".trim(), length));
			String[] caExptFlg = (JSPUtil.getParameter(request, prefix	+ "ca_expt_flg".trim(), length));
			String[] bkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rpt_knd_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] updGrpCd = (JSPUtil.getParameter(request, prefix	+ "upd_grp_cd".trim(), length));
			String[] hisFlg = (JSPUtil.getParameter(request, prefix	+ "his_flg".trim(), length));
			String[] copIfFlg = (JSPUtil.getParameter(request, prefix	+ "cop_if_flg".trim(), length));
			String[] coaIfFlg = (JSPUtil.getParameter(request, prefix	+ "coa_if_flg".trim(), length));
			String[] caRevFlg = (JSPUtil.getParameter(request, prefix	+ "ca_rev_flg".trim(), length));
			String[] ordSeq = (JSPUtil.getParameter(request, prefix	+ "ord_seq".trim(), length));
			String[] tblColNm = (JSPUtil.getParameter(request, prefix	+ "tbl_col_nm".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] caCostFlg = (JSPUtil.getParameter(request, prefix	+ "ca_cost_flg".trim(), length));
			String[] updSubGrpCd = (JSPUtil.getParameter(request, prefix	+ "upd_sub_grp_cd".trim(), length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id".trim(), length));
			String[] tblNm = (JSPUtil.getParameter(request, prefix	+ "tbl_nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgTblColVO();
				if (stsRptFlg[i] != null)
					model.setStsRptFlg(stsRptFlg[i]);
				if (dpNm[i] != null)
					model.setDpNm(dpNm[i]);
				if (colNm[i] != null)
					model.setColNm(colNm[i]);
				if (vipRptFlg[i] != null)
					model.setVipRptFlg(vipRptFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (caRptFlg[i] != null)
					model.setCaRptFlg(caRptFlg[i]);
				if (sqlCtnt[i] != null)
					model.setSqlCtnt(sqlCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hisCateNm[i] != null)
					model.setHisCateNm(hisCateNm[i]);
				if (invIfFlg[i] != null)
					model.setInvIfFlg(invIfFlg[i]);
				if (caExptFlg[i] != null)
					model.setCaExptFlg(caExptFlg[i]);
				if (bkgRptKndCd[i] != null)
					model.setBkgRptKndCd(bkgRptKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (updGrpCd[i] != null)
					model.setUpdGrpCd(updGrpCd[i]);
				if (hisFlg[i] != null)
					model.setHisFlg(hisFlg[i]);
				if (copIfFlg[i] != null)
					model.setCopIfFlg(copIfFlg[i]);
				if (coaIfFlg[i] != null)
					model.setCoaIfFlg(coaIfFlg[i]);
				if (caRevFlg[i] != null)
					model.setCaRevFlg(caRevFlg[i]);
				if (ordSeq[i] != null)
					model.setOrdSeq(ordSeq[i]);
				if (tblColNm[i] != null)
					model.setTblColNm(tblColNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (caCostFlg[i] != null)
					model.setCaCostFlg(caCostFlg[i]);
				if (updSubGrpCd[i] != null)
					model.setUpdSubGrpCd(updSubGrpCd[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (tblNm[i] != null)
					model.setTblNm(tblNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTblColVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTblColVO[]
	 */
	public BkgTblColVO[] getBkgTblColVOs(){
		BkgTblColVO[] vos = (BkgTblColVO[])models.toArray(new BkgTblColVO[models.size()]);
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
		this.stsRptFlg = this.stsRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpNm = this.dpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm = this.colNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipRptFlg = this.vipRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRptFlg = this.caRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqlCtnt = this.sqlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCateNm = this.hisCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIfFlg = this.invIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caExptFlg = this.caExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRptKndCd = this.bkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updGrpCd = this.updGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisFlg = this.hisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copIfFlg = this.copIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaIfFlg = this.coaIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRevFlg = this.caRevFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordSeq = this.ordSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblColNm = this.tblColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caCostFlg = this.caCostFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updSubGrpCd = this.updSubGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm = this.tblNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
