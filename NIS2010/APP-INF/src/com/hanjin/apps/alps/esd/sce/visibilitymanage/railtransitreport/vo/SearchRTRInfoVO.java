/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SearchRTRInfoVO.java
*@FileTitle : SearchRTRInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchRTRInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRTRInfoVO> models = new ArrayList<SearchRTRInfoVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String rCustCntCd = null;
	/* Column Info */
	private String cstmsAcptFlg = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String dwellTime = null;
	/* Column Info */
	private String rVvd = null;
	/* Column Info */
	private String customerLoc = null;
	/* Column Info */
	private String podPol = null;
	/* Column Info */
	private String rBlNo = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String curPage = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rCustSeq = null;
	/* Column Info */
	private String dateKind = null;
	/* Column Info */
	private String rBkgNo = null;
	/* Column Info */
	private String rPolpod = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String searchtype = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String rScno = null;
	/* Column Info */
	private String rDest = null;
	/* Column Info */
	private String cntrTpsz = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tDep = null;
	/* Column Info */
	private String dwellKind = null;
	/* Column Info */
	private String rOrigin = null;
	/* Column Info */
	private String railcomp = null;
	/* Column Info */
	private String rCntrNo = null;
	/* Column Info */
	private String oDep = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchRTRInfoVO() {}

	public SearchRTRInfoVO(String ibflag, String pagerows, String rScno, String rBkgNo, String toDt, String cgoTpCd, String custCntSeq, String customerLoc, String toNodCd, String bkgNo, String rCntrNo, String blNo, String rVvd, String bkgOfcCd, String eqNo, String rBlNo, String cstmsAcptFlg, String podPol, String trspBndCd, String rCustCntCd, String fmNodCd, String rOrigin, String vvd, String rPolpod, String scNo, String rDest, String fmDt, String railcomp, String rCustSeq, String dateKind, String searchtype, String dwellKind, String dwellTime, String tDep, String type, String curPage, String cntrTpsz, String oDep) {
		this.toNodCd = toNodCd;
		this.rCustCntCd = rCustCntCd;
		this.cstmsAcptFlg = cstmsAcptFlg;
		this.cgoTpCd = cgoTpCd;
		this.dwellTime = dwellTime;
		this.rVvd = rVvd;
		this.customerLoc = customerLoc;
		this.podPol = podPol;
		this.rBlNo = rBlNo;
		this.type = type;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.curPage = curPage;
		this.scNo = scNo;
		this.bkgOfcCd = bkgOfcCd;
		this.rCustSeq = rCustSeq;
		this.dateKind = dateKind;
		this.rBkgNo = rBkgNo;
		this.rPolpod = rPolpod;
		this.trspBndCd = trspBndCd;
		this.searchtype = searchtype;
		this.fmDt = fmDt;
		this.rScno = rScno;
		this.rDest = rDest;
		this.cntrTpsz = cntrTpsz;
		this.custCntSeq = custCntSeq;
		this.toDt = toDt;
		this.fmNodCd = fmNodCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.tDep = tDep;
		this.dwellKind = dwellKind;
		this.rOrigin = rOrigin;
		this.railcomp = railcomp;
		this.rCntrNo = rCntrNo;
		this.oDep = oDep;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("r_cust_cnt_cd", getRCustCntCd());
		this.hashColumns.put("cstms_acpt_flg", getCstmsAcptFlg());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("dwell_time", getDwellTime());
		this.hashColumns.put("r_vvd", getRVvd());
		this.hashColumns.put("customer_loc", getCustomerLoc());
		this.hashColumns.put("pod_pol", getPodPol());
		this.hashColumns.put("r_bl_no", getRBlNo());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cur_page", getCurPage());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("r_cust_seq", getRCustSeq());
		this.hashColumns.put("date_kind", getDateKind());
		this.hashColumns.put("r_bkg_no", getRBkgNo());
		this.hashColumns.put("r_polpod", getRPolpod());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("searchtype", getSearchtype());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("r_scno", getRScno());
		this.hashColumns.put("r_dest", getRDest());
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t_dep", getTDep());
		this.hashColumns.put("dwell_kind", getDwellKind());
		this.hashColumns.put("r_origin", getROrigin());
		this.hashColumns.put("railcomp", getRailcomp());
		this.hashColumns.put("r_cntr_no", getRCntrNo());
		this.hashColumns.put("o_dep", getODep());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("r_cust_cnt_cd", "rCustCntCd");
		this.hashFields.put("cstms_acpt_flg", "cstmsAcptFlg");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("dwell_time", "dwellTime");
		this.hashFields.put("r_vvd", "rVvd");
		this.hashFields.put("customer_loc", "customerLoc");
		this.hashFields.put("pod_pol", "podPol");
		this.hashFields.put("r_bl_no", "rBlNo");
		this.hashFields.put("type", "type");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cur_page", "curPage");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("r_cust_seq", "rCustSeq");
		this.hashFields.put("date_kind", "dateKind");
		this.hashFields.put("r_bkg_no", "rBkgNo");
		this.hashFields.put("r_polpod", "rPolpod");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("searchtype", "searchtype");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("r_scno", "rScno");
		this.hashFields.put("r_dest", "rDest");
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t_dep", "tDep");
		this.hashFields.put("dwell_kind", "dwellKind");
		this.hashFields.put("r_origin", "rOrigin");
		this.hashFields.put("railcomp", "railcomp");
		this.hashFields.put("r_cntr_no", "rCntrNo");
		this.hashFields.put("o_dep", "oDep");
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
	 * @return rCustCntCd
	 */
	public String getRCustCntCd() {
		return this.rCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsAcptFlg
	 */
	public String getCstmsAcptFlg() {
		return this.cstmsAcptFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return dwellTime
	 */
	public String getDwellTime() {
		return this.dwellTime;
	}
	
	/**
	 * Column Info
	 * @return rVvd
	 */
	public String getRVvd() {
		return this.rVvd;
	}
	
	/**
	 * Column Info
	 * @return customerLoc
	 */
	public String getCustomerLoc() {
		return this.customerLoc;
	}
	
	/**
	 * Column Info
	 * @return podPol
	 */
	public String getPodPol() {
		return this.podPol;
	}
	
	/**
	 * Column Info
	 * @return rBlNo
	 */
	public String getRBlNo() {
		return this.rBlNo;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return curPage
	 */
	public String getCurPage() {
		return this.curPage;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rCustSeq
	 */
	public String getRCustSeq() {
		return this.rCustSeq;
	}
	
	/**
	 * Column Info
	 * @return dateKind
	 */
	public String getDateKind() {
		return this.dateKind;
	}
	
	/**
	 * Column Info
	 * @return rBkgNo
	 */
	public String getRBkgNo() {
		return this.rBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rPolpod
	 */
	public String getRPolpod() {
		return this.rPolpod;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return searchtype
	 */
	public String getSearchtype() {
		return this.searchtype;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return rScno
	 */
	public String getRScno() {
		return this.rScno;
	}
	
	/**
	 * Column Info
	 * @return rDest
	 */
	public String getRDest() {
		return this.rDest;
	}
	
	/**
	 * Column Info
	 * @return cntrTpsz
	 */
	public String getCntrTpsz() {
		return this.cntrTpsz;
	}
	
	/**
	 * Column Info
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return tDep
	 */
	public String getTDep() {
		return this.tDep;
	}
	
	/**
	 * Column Info
	 * @return dwellKind
	 */
	public String getDwellKind() {
		return this.dwellKind;
	}
	
	/**
	 * Column Info
	 * @return rOrigin
	 */
	public String getROrigin() {
		return this.rOrigin;
	}
	
	/**
	 * Column Info
	 * @return railcomp
	 */
	public String getRailcomp() {
		return this.railcomp;
	}
	
	/**
	 * Column Info
	 * @return rCntrNo
	 */
	public String getRCntrNo() {
		return this.rCntrNo;
	}

	/**
	 * Column Info
	 * @return oDep
	 */
	public String getODep() {
		return oDep;
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
	 * @param rCustCntCd
	 */
	public void setRCustCntCd(String rCustCntCd) {
		this.rCustCntCd = rCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsAcptFlg
	 */
	public void setCstmsAcptFlg(String cstmsAcptFlg) {
		this.cstmsAcptFlg = cstmsAcptFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param dwellTime
	 */
	public void setDwellTime(String dwellTime) {
		this.dwellTime = dwellTime;
	}
	
	/**
	 * Column Info
	 * @param rVvd
	 */
	public void setRVvd(String rVvd) {
		this.rVvd = rVvd;
	}
	
	/**
	 * Column Info
	 * @param customerLoc
	 */
	public void setCustomerLoc(String customerLoc) {
		this.customerLoc = customerLoc;
	}
	
	/**
	 * Column Info
	 * @param podPol
	 */
	public void setPodPol(String podPol) {
		this.podPol = podPol;
	}
	
	/**
	 * Column Info
	 * @param rBlNo
	 */
	public void setRBlNo(String rBlNo) {
		this.rBlNo = rBlNo;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param curPage
	 */
	public void setCurPage(String curPage) {
		this.curPage = curPage;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rCustSeq
	 */
	public void setRCustSeq(String rCustSeq) {
		this.rCustSeq = rCustSeq;
	}
	
	/**
	 * Column Info
	 * @param dateKind
	 */
	public void setDateKind(String dateKind) {
		this.dateKind = dateKind;
	}
	
	/**
	 * Column Info
	 * @param rBkgNo
	 */
	public void setRBkgNo(String rBkgNo) {
		this.rBkgNo = rBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rPolpod
	 */
	public void setRPolpod(String rPolpod) {
		this.rPolpod = rPolpod;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param searchtype
	 */
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param rScno
	 */
	public void setRScno(String rScno) {
		this.rScno = rScno;
	}
	
	/**
	 * Column Info
	 * @param rDest
	 */
	public void setRDest(String rDest) {
		this.rDest = rDest;
	}
	
	/**
	 * Column Info
	 * @param cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
	}
	
	/**
	 * Column Info
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param tDep
	 */
	public void setTDep(String tDep) {
		this.tDep = tDep;
	}
	
	/**
	 * Column Info
	 * @param dwellKind
	 */
	public void setDwellKind(String dwellKind) {
		this.dwellKind = dwellKind;
	}
	
	/**
	 * Column Info
	 * @param rOrigin
	 */
	public void setROrigin(String rOrigin) {
		this.rOrigin = rOrigin;
	}
	
	/**
	 * Column Info
	 * @param railcomp
	 */
	public void setRailcomp(String railcomp) {
		this.railcomp = railcomp;
	}
	
	/**
	 * Column Info
	 * @param rCntrNo
	 */
	public void setRCntrNo(String rCntrNo) {
		this.rCntrNo = rCntrNo;
	}
	
	/**
	 * Column Info
	 * @param oDep
	 */
	public void setODep(String oDep) {
		this.oDep = oDep;
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
		setRCustCntCd(JSPUtil.getParameter(request, prefix + "r_cust_cnt_cd", ""));
		setCstmsAcptFlg(JSPUtil.getParameter(request, prefix + "cstms_acpt_flg", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setDwellTime(JSPUtil.getParameter(request, prefix + "dwell_time", ""));
		setRVvd(JSPUtil.getParameter(request, prefix + "r_vvd", ""));
		setCustomerLoc(JSPUtil.getParameter(request, prefix + "customer_loc", ""));
		setPodPol(JSPUtil.getParameter(request, prefix + "pod_pol", ""));
		setRBlNo(JSPUtil.getParameter(request, prefix + "r_bl_no", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCurPage(JSPUtil.getParameter(request, prefix + "cur_page", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRCustSeq(JSPUtil.getParameter(request, prefix + "r_cust_seq", ""));
		setDateKind(JSPUtil.getParameter(request, prefix + "date_kind", ""));
		setRBkgNo(JSPUtil.getParameter(request, prefix + "r_bkg_no", ""));
		setRPolpod(JSPUtil.getParameter(request, prefix + "r_polpod", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setSearchtype(JSPUtil.getParameter(request, prefix + "searchtype", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRScno(JSPUtil.getParameter(request, prefix + "r_scno", ""));
		setRDest(JSPUtil.getParameter(request, prefix + "r_dest", ""));
		setCntrTpsz(JSPUtil.getParameter(request, prefix + "cntr_tpsz", ""));
		setCustCntSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_seq", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTDep(JSPUtil.getParameter(request, prefix + "t_dep", ""));
		setDwellKind(JSPUtil.getParameter(request, prefix + "dwell_kind", ""));
		setROrigin(JSPUtil.getParameter(request, prefix + "r_origin", ""));
		setRailcomp(JSPUtil.getParameter(request, prefix + "railcomp", ""));
		setRCntrNo(JSPUtil.getParameter(request, prefix + "r_cntr_no", ""));
		setODep(JSPUtil.getParameter(request, prefix + "o_dep", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRTRInfoVO[]
	 */
	public SearchRTRInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRTRInfoVO[]
	 */
	public SearchRTRInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRTRInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] rCustCntCd = (JSPUtil.getParameter(request, prefix	+ "r_cust_cnt_cd", length));
			String[] cstmsAcptFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_acpt_flg", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] dwellTime = (JSPUtil.getParameter(request, prefix	+ "dwell_time", length));
			String[] rVvd = (JSPUtil.getParameter(request, prefix	+ "r_vvd", length));
			String[] customerLoc = (JSPUtil.getParameter(request, prefix	+ "customer_loc", length));
			String[] podPol = (JSPUtil.getParameter(request, prefix	+ "pod_pol", length));
			String[] rBlNo = (JSPUtil.getParameter(request, prefix	+ "r_bl_no", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] curPage = (JSPUtil.getParameter(request, prefix	+ "cur_page", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rCustSeq = (JSPUtil.getParameter(request, prefix	+ "r_cust_seq", length));
			String[] dateKind = (JSPUtil.getParameter(request, prefix	+ "date_kind", length));
			String[] rBkgNo = (JSPUtil.getParameter(request, prefix	+ "r_bkg_no", length));
			String[] rPolpod = (JSPUtil.getParameter(request, prefix	+ "r_polpod", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] searchtype = (JSPUtil.getParameter(request, prefix	+ "searchtype", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] rScno = (JSPUtil.getParameter(request, prefix	+ "r_scno", length));
			String[] rDest = (JSPUtil.getParameter(request, prefix	+ "r_dest", length));
			String[] cntrTpsz = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tDep = (JSPUtil.getParameter(request, prefix	+ "t_dep", length));
			String[] dwellKind = (JSPUtil.getParameter(request, prefix	+ "dwell_kind", length));
			String[] rOrigin = (JSPUtil.getParameter(request, prefix	+ "r_origin", length));
			String[] railcomp = (JSPUtil.getParameter(request, prefix	+ "railcomp", length));
			String[] rCntrNo = (JSPUtil.getParameter(request, prefix	+ "r_cntr_no", length));
			String[] oDep = (JSPUtil.getParameter(request, prefix	+ "o_dep", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRTRInfoVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (rCustCntCd[i] != null)
					model.setRCustCntCd(rCustCntCd[i]);
				if (cstmsAcptFlg[i] != null)
					model.setCstmsAcptFlg(cstmsAcptFlg[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (dwellTime[i] != null)
					model.setDwellTime(dwellTime[i]);
				if (rVvd[i] != null)
					model.setRVvd(rVvd[i]);
				if (customerLoc[i] != null)
					model.setCustomerLoc(customerLoc[i]);
				if (podPol[i] != null)
					model.setPodPol(podPol[i]);
				if (rBlNo[i] != null)
					model.setRBlNo(rBlNo[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (curPage[i] != null)
					model.setCurPage(curPage[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rCustSeq[i] != null)
					model.setRCustSeq(rCustSeq[i]);
				if (dateKind[i] != null)
					model.setDateKind(dateKind[i]);
				if (rBkgNo[i] != null)
					model.setRBkgNo(rBkgNo[i]);
				if (rPolpod[i] != null)
					model.setRPolpod(rPolpod[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (searchtype[i] != null)
					model.setSearchtype(searchtype[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (rScno[i] != null)
					model.setRScno(rScno[i]);
				if (rDest[i] != null)
					model.setRDest(rDest[i]);
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tDep[i] != null)
					model.setTDep(tDep[i]);
				if (dwellKind[i] != null)
					model.setDwellKind(dwellKind[i]);
				if (rOrigin[i] != null)
					model.setROrigin(rOrigin[i]);
				if (railcomp[i] != null)
					model.setRailcomp(railcomp[i]);
				if (rCntrNo[i] != null)
					model.setRCntrNo(rCntrNo[i]);
				if (oDep[i] != null)
					model.setODep(oDep[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRTRInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRTRInfoVO[]
	 */
	public SearchRTRInfoVO[] getSearchRTRInfoVOs(){
		SearchRTRInfoVO[] vos = (SearchRTRInfoVO[])models.toArray(new SearchRTRInfoVO[models.size()]);
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
		this.rCustCntCd = this.rCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAcptFlg = this.cstmsAcptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwellTime = this.dwellTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rVvd = this.rVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerLoc = this.customerLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPol = this.podPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBlNo = this.rBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curPage = this.curPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCustSeq = this.rCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateKind = this.dateKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBkgNo = this.rBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rPolpod = this.rPolpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchtype = this.searchtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rScno = this.rScno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rDest = this.rDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDep = this.tDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwellKind = this.dwellKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rOrigin = this.rOrigin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railcomp = this.railcomp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCntrNo = this.rCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oDep = this.oDep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
