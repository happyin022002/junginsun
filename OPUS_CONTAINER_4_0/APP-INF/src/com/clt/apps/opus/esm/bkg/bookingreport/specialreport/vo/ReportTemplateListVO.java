/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportTemplateListVO.java
*@FileTitle : ReportTemplateListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.07.22 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReportTemplateListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReportTemplateListVO> models = new ArrayList<ReportTemplateListVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String colNm = null;
	/* Column Info */
	private String comFlg = null;
	/* Column Info */
	private String typeGubun = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sqlCtntColNm = null;
	/* Column Info */
	private String bzcCondSqlCtnt = null;
	/* Column Info */
	private String ownrUsrId = null;
	/* Column Info */
	private String visFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String selectedColNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String bkgRptKndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String typeNm = null;
	/* Column Info */
	private String rptNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String pBkgRptKndCd = null;
	/* Column Info */
	private String searchOption = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String itemOption = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String modifiedColNm = null;
	/* Column Info */
	private String tblNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReportTemplateListVO() {}

	public ReportTemplateListVO(String ibflag, String pagerows, String usrId, String bkgRptKndCd, String pBkgRptKndCd, String rptId, String rptNm, String comFlg, String ownrUsrId, String dpSeq, String scNo, String custCntCd, String custSeq, String visFlg, String typeGubun, String searchOption, String itemOption, String typeNm, String bzcCondSqlCtnt, String selectedColNm, String modifiedColNm, String sqlCtntColNm, String tblNm, String colNm, String usrNm, String ofcCd, String bkgCustTpCd, String creDt, String creUsrId, String updDt, String updUsrId) {
		this.dpSeq = dpSeq;
		this.colNm = colNm;
		this.comFlg = comFlg;
		this.typeGubun = typeGubun;
		this.creDt = creDt;
		this.sqlCtntColNm = sqlCtntColNm;
		this.bzcCondSqlCtnt = bzcCondSqlCtnt;
		this.ownrUsrId = ownrUsrId;
		this.visFlg = visFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.selectedColNm = selectedColNm;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.scNo = scNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.bkgRptKndCd = bkgRptKndCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.typeNm = typeNm;
		this.rptNm = rptNm;
		this.custSeq = custSeq;
		this.pBkgRptKndCd = pBkgRptKndCd;
		this.searchOption = searchOption;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.itemOption = itemOption;
		this.rptId = rptId;
		this.modifiedColNm = modifiedColNm;
		this.tblNm = tblNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("com_flg", getComFlg());
		this.hashColumns.put("type_gubun", getTypeGubun());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sql_ctnt_col_nm", getSqlCtntColNm());
		this.hashColumns.put("bzc_cond_sql_ctnt", getBzcCondSqlCtnt());
		this.hashColumns.put("ownr_usr_id", getOwnrUsrId());
		this.hashColumns.put("vis_flg", getVisFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("selected_col_nm", getSelectedColNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("bkg_rpt_knd_cd", getBkgRptKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("type_nm", getTypeNm());
		this.hashColumns.put("rpt_nm", getRptNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("p_bkg_rpt_knd_cd", getPBkgRptKndCd());
		this.hashColumns.put("search_option", getSearchOption());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("item_option", getItemOption());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("modified_col_nm", getModifiedColNm());
		this.hashColumns.put("tbl_nm", getTblNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("com_flg", "comFlg");
		this.hashFields.put("type_gubun", "typeGubun");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sql_ctnt_col_nm", "sqlCtntColNm");
		this.hashFields.put("bzc_cond_sql_ctnt", "bzcCondSqlCtnt");
		this.hashFields.put("ownr_usr_id", "ownrUsrId");
		this.hashFields.put("vis_flg", "visFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("selected_col_nm", "selectedColNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("bkg_rpt_knd_cd", "bkgRptKndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("type_nm", "typeNm");
		this.hashFields.put("rpt_nm", "rptNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("p_bkg_rpt_knd_cd", "pBkgRptKndCd");
		this.hashFields.put("search_option", "searchOption");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("item_option", "itemOption");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("modified_col_nm", "modifiedColNm");
		this.hashFields.put("tbl_nm", "tblNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return comFlg
	 */
	public String getComFlg() {
		return this.comFlg;
	}
	
	/**
	 * Column Info
	 * @return typeGubun
	 */
	public String getTypeGubun() {
		return this.typeGubun;
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
	 * @return sqlCtntColNm
	 */
	public String getSqlCtntColNm() {
		return this.sqlCtntColNm;
	}
	
	/**
	 * Column Info
	 * @return bzcCondSqlCtnt
	 */
	public String getBzcCondSqlCtnt() {
		return this.bzcCondSqlCtnt;
	}
	
	/**
	 * Column Info
	 * @return ownrUsrId
	 */
	public String getOwnrUsrId() {
		return this.ownrUsrId;
	}
	
	/**
	 * Column Info
	 * @return visFlg
	 */
	public String getVisFlg() {
		return this.visFlg;
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
	 * @return selectedColNm
	 */
	public String getSelectedColNm() {
		return this.selectedColNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return typeNm
	 */
	public String getTypeNm() {
		return this.typeNm;
	}
	
	/**
	 * Column Info
	 * @return rptNm
	 */
	public String getRptNm() {
		return this.rptNm;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return pBkgRptKndCd
	 */
	public String getPBkgRptKndCd() {
		return this.pBkgRptKndCd;
	}
	
	/**
	 * Column Info
	 * @return searchOption
	 */
	public String getSearchOption() {
		return this.searchOption;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return itemOption
	 */
	public String getItemOption() {
		return this.itemOption;
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
	 * @return modifiedColNm
	 */
	public String getModifiedColNm() {
		return this.modifiedColNm;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param comFlg
	 */
	public void setComFlg(String comFlg) {
		this.comFlg = comFlg;
	}
	
	/**
	 * Column Info
	 * @param typeGubun
	 */
	public void setTypeGubun(String typeGubun) {
		this.typeGubun = typeGubun;
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
	 * @param sqlCtntColNm
	 */
	public void setSqlCtntColNm(String sqlCtntColNm) {
		this.sqlCtntColNm = sqlCtntColNm;
	}
	
	/**
	 * Column Info
	 * @param bzcCondSqlCtnt
	 */
	public void setBzcCondSqlCtnt(String bzcCondSqlCtnt) {
		this.bzcCondSqlCtnt = bzcCondSqlCtnt;
	}
	
	/**
	 * Column Info
	 * @param ownrUsrId
	 */
	public void setOwnrUsrId(String ownrUsrId) {
		this.ownrUsrId = ownrUsrId;
	}
	
	/**
	 * Column Info
	 * @param visFlg
	 */
	public void setVisFlg(String visFlg) {
		this.visFlg = visFlg;
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
	 * @param selectedColNm
	 */
	public void setSelectedColNm(String selectedColNm) {
		this.selectedColNm = selectedColNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param typeNm
	 */
	public void setTypeNm(String typeNm) {
		this.typeNm = typeNm;
	}
	
	/**
	 * Column Info
	 * @param rptNm
	 */
	public void setRptNm(String rptNm) {
		this.rptNm = rptNm;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param pBkgRptKndCd
	 */
	public void setPBkgRptKndCd(String pBkgRptKndCd) {
		this.pBkgRptKndCd = pBkgRptKndCd;
	}
	
	/**
	 * Column Info
	 * @param searchOption
	 */
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param itemOption
	 */
	public void setItemOption(String itemOption) {
		this.itemOption = itemOption;
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
	 * @param modifiedColNm
	 */
	public void setModifiedColNm(String modifiedColNm) {
		this.modifiedColNm = modifiedColNm;
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
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setColNm(JSPUtil.getParameter(request, "col_nm", ""));
		setComFlg(JSPUtil.getParameter(request, "com_flg", ""));
		setTypeGubun(JSPUtil.getParameter(request, "type_gubun", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSqlCtntColNm(JSPUtil.getParameter(request, "sql_ctnt_col_nm", ""));
		setBzcCondSqlCtnt(JSPUtil.getParameter(request, "bzc_cond_sql_ctnt", ""));
		setOwnrUsrId(JSPUtil.getParameter(request, "ownr_usr_id", ""));
		setVisFlg(JSPUtil.getParameter(request, "vis_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSelectedColNm(JSPUtil.getParameter(request, "selected_col_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setBkgRptKndCd(JSPUtil.getParameter(request, "bkg_rpt_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTypeNm(JSPUtil.getParameter(request, "type_nm", ""));
		setRptNm(JSPUtil.getParameter(request, "rpt_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPBkgRptKndCd(JSPUtil.getParameter(request, "p_bkg_rpt_knd_cd", ""));
		setSearchOption(JSPUtil.getParameter(request, "search_option", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setItemOption(JSPUtil.getParameter(request, "item_option", ""));
		setRptId(JSPUtil.getParameter(request, "rpt_id", ""));
		setModifiedColNm(JSPUtil.getParameter(request, "modified_col_nm", ""));
		setTblNm(JSPUtil.getParameter(request, "tbl_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReportTemplateListVO[]
	 */
	public ReportTemplateListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportTemplateListVO[]
	 */
	public ReportTemplateListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReportTemplateListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] colNm = (JSPUtil.getParameter(request, prefix	+ "col_nm", length));
			String[] comFlg = (JSPUtil.getParameter(request, prefix	+ "com_flg", length));
			String[] typeGubun = (JSPUtil.getParameter(request, prefix	+ "type_gubun", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sqlCtntColNm = (JSPUtil.getParameter(request, prefix	+ "sql_ctnt_col_nm", length));
			String[] bzcCondSqlCtnt = (JSPUtil.getParameter(request, prefix	+ "bzc_cond_sql_ctnt", length));
			String[] ownrUsrId = (JSPUtil.getParameter(request, prefix	+ "ownr_usr_id", length));
			String[] visFlg = (JSPUtil.getParameter(request, prefix	+ "vis_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] selectedColNm = (JSPUtil.getParameter(request, prefix	+ "selected_col_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] bkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rpt_knd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] typeNm = (JSPUtil.getParameter(request, prefix	+ "type_nm", length));
			String[] rptNm = (JSPUtil.getParameter(request, prefix	+ "rpt_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pBkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "p_bkg_rpt_knd_cd", length));
			String[] searchOption = (JSPUtil.getParameter(request, prefix	+ "search_option", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] itemOption = (JSPUtil.getParameter(request, prefix	+ "item_option", length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id", length));
			String[] modifiedColNm = (JSPUtil.getParameter(request, prefix	+ "modified_col_nm", length));
			String[] tblNm = (JSPUtil.getParameter(request, prefix	+ "tbl_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReportTemplateListVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (colNm[i] != null)
					model.setColNm(colNm[i]);
				if (comFlg[i] != null)
					model.setComFlg(comFlg[i]);
				if (typeGubun[i] != null)
					model.setTypeGubun(typeGubun[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sqlCtntColNm[i] != null)
					model.setSqlCtntColNm(sqlCtntColNm[i]);
				if (bzcCondSqlCtnt[i] != null)
					model.setBzcCondSqlCtnt(bzcCondSqlCtnt[i]);
				if (ownrUsrId[i] != null)
					model.setOwnrUsrId(ownrUsrId[i]);
				if (visFlg[i] != null)
					model.setVisFlg(visFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (selectedColNm[i] != null)
					model.setSelectedColNm(selectedColNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (bkgRptKndCd[i] != null)
					model.setBkgRptKndCd(bkgRptKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (typeNm[i] != null)
					model.setTypeNm(typeNm[i]);
				if (rptNm[i] != null)
					model.setRptNm(rptNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pBkgRptKndCd[i] != null)
					model.setPBkgRptKndCd(pBkgRptKndCd[i]);
				if (searchOption[i] != null)
					model.setSearchOption(searchOption[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (itemOption[i] != null)
					model.setItemOption(itemOption[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (modifiedColNm[i] != null)
					model.setModifiedColNm(modifiedColNm[i]);
				if (tblNm[i] != null)
					model.setTblNm(tblNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportTemplateListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReportTemplateListVO[]
	 */
	public ReportTemplateListVO[] getReportTemplateListVOs(){
		ReportTemplateListVO[] vos = (ReportTemplateListVO[])models.toArray(new ReportTemplateListVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm = this.colNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlg = this.comFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeGubun = this.typeGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sqlCtntColNm = this.sqlCtntColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcCondSqlCtnt = this.bzcCondSqlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrUsrId = this.ownrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.visFlg = this.visFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectedColNm = this.selectedColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRptKndCd = this.bkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeNm = this.typeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptNm = this.rptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgRptKndCd = this.pBkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchOption = this.searchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemOption = this.itemOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modifiedColNm = this.modifiedColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblNm = this.tblNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
