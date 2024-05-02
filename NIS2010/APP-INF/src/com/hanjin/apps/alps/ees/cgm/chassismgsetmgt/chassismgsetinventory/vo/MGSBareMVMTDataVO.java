/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBareMGSetDataVO.java
*@FileTitle : SearchBareMGSetDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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

public class MGSBareMVMTDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSBareMVMTDataVO> models = new ArrayList<MGSBareMVMTDataVO>();
	
	/* Column Info */
	private String lsdays = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fromlocation = null;
	/* Column Info */
	private String chkChsno = null;
	/* Column Info */
	private String chkMgset = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String mgstBareBmtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String eqTrspModCd = null;
	/* Column Info */
	private String fromdate = null;
	/* Column Info */
	private String tolocation = null;
	/* Column Info */
	private String fromstatus = null;
	/* Column Info */
	private String tostatus = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String mvmt = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String chkEqno = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String mgstBareBmpFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bareMgstRmk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mgstBareStsSeq = null;
	/* Column Info */
	private String mgstBareStsCd = null;	
	/* Column Info */
	private String mgstBareEvntDt = null;	
	/* Column Info */
	private String updDt = null;		

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MGSBareMVMTDataVO() {}

	public MGSBareMVMTDataVO(String ibflag, String pagerows, String mgstNo, String mgstBareBmpFlg, String mgstBareBmtFlg, String eqTpszCd, String mvmt, String chssNo, String cntrNo, String lsdays, String vndrLglEngNm, String eqTrspModCd, String orgYdCd, String rtnYdCd, String creDt, String bareMgstRmk, String vndrSeq, String mgstBareStsSeq, String fromdate, String todate, String status, String fromlocation, String fromstatus, String tolocation, String tostatus, String chkMgset, String chkChsno, String chkEqno, String creOfcCd, String creUsrId, String updUsrId, String delChk, String mgstBareStsCd, String mgstBareEvntDt, String updDt) {
		this.lsdays = lsdays;
		this.chssNo = chssNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.fromlocation = fromlocation;
		this.chkChsno = chkChsno;
		this.chkMgset = chkMgset;
		this.todate = todate;
		this.mgstBareBmtFlg = mgstBareBmtFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.eqTrspModCd = eqTrspModCd;
		this.fromdate = fromdate;
		this.tolocation = tolocation;
		this.fromstatus = fromstatus;
		this.tostatus = tostatus;
		this.updUsrId = updUsrId;
		this.status = status;
		this.mvmt = mvmt;
		this.rtnYdCd = rtnYdCd;
		this.chkEqno = chkEqno;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.eqTpszCd = eqTpszCd;
		this.delChk = delChk;
		this.mgstBareBmpFlg = mgstBareBmpFlg;
		this.creUsrId = creUsrId;
		this.bareMgstRmk = bareMgstRmk;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.mgstBareStsSeq = mgstBareStsSeq;
		
		this.mgstBareStsCd = mgstBareStsCd;
		this.mgstBareEvntDt = mgstBareEvntDt;		
		this.updDt = updDt;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lsdays", getLsdays());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fromlocation", getFromlocation());
		this.hashColumns.put("chk_chsno", getChkChsno());
		this.hashColumns.put("chk_mgset", getChkMgset());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("mgst_bare_bmt_flg", getMgstBareBmtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("eq_trsp_mod_cd", getEqTrspModCd());
		this.hashColumns.put("fromdate", getFromdate());
		this.hashColumns.put("tolocation", getTolocation());
		this.hashColumns.put("fromstatus", getFromstatus());
		this.hashColumns.put("tostatus", getTostatus());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("mvmt", getMvmt());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("chk_eqno", getChkEqno());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("mgst_bare_bmp_flg", getMgstBareBmpFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bare_mgst_rmk", getBareMgstRmk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mgst_bare_sts_seq", getMgstBareStsSeq());
		
		this.hashColumns.put("mgst_bare_sts_cd", getMgstBareStsCd());
		this.hashColumns.put("mgst_bare_evnt_dt", getMgstBareEvntDt());	
		this.hashColumns.put("upd_dt", getUpdDt());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lsdays", "lsdays");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fromlocation", "fromlocation");
		this.hashFields.put("chk_chsno", "chkChsno");
		this.hashFields.put("chk_mgset", "chkMgset");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("mgst_bare_bmt_flg", "mgstBareBmtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("eq_trsp_mod_cd", "eqTrspModCd");
		this.hashFields.put("fromdate", "fromdate");
		this.hashFields.put("tolocation", "tolocation");
		this.hashFields.put("fromstatus", "fromstatus");
		this.hashFields.put("tostatus", "tostatus");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("status", "status");
		this.hashFields.put("mvmt", "mvmt");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("chk_eqno", "chkEqno");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("mgst_bare_bmp_flg", "mgstBareBmpFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bare_mgst_rmk", "bareMgstRmk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mgst_bare_sts_seq", "mgstBareStsSeq");
		
		this.hashFields.put("mgst_bare_sts_cd", "mgstBareStsCd");
		this.hashFields.put("mgst_bare_evnt_dt", "mgstBareEvntDt");
		this.hashFields.put("upd_dt", "updDt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lsdays
	 */
	public String getLsdays() {
		return this.lsdays;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return fromlocation
	 */
	public String getFromlocation() {
		return this.fromlocation;
	}
	
	/**
	 * Column Info
	 * @return chkChsno
	 */
	public String getChkChsno() {
		return this.chkChsno;
	}
	
	/**
	 * Column Info
	 * @return chkMgset
	 */
	public String getChkMgset() {
		return this.chkMgset;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return mgstBareBmtFlg
	 */
	public String getMgstBareBmtFlg() {
		return this.mgstBareBmtFlg;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqTrspModCd
	 */
	public String getEqTrspModCd() {
		return this.eqTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return fromdate
	 */
	public String getFromdate() {
		return this.fromdate;
	}
	
	/**
	 * Column Info
	 * @return tolocation
	 */
	public String getTolocation() {
		return this.tolocation;
	}
	
	/**
	 * Column Info
	 * @return fromstatus
	 */
	public String getFromstatus() {
		return this.fromstatus;
	}
	
	/**
	 * Column Info
	 * @return tostatus
	 */
	public String getTostatus() {
		return this.tostatus;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return mvmt
	 */
	public String getMvmt() {
		return this.mvmt;
	}
	
	/**
	 * Column Info
	 * @return rtnYdCd
	 */
	public String getRtnYdCd() {
		return this.rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return chkEqno
	 */
	public String getChkEqno() {
		return this.chkEqno;
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
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
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
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return mgstBareBmpFlg
	 */
	public String getMgstBareBmpFlg() {
		return this.mgstBareBmpFlg;
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
	 * @return bareMgstRmk
	 */
	public String getBareMgstRmk() {
		return this.bareMgstRmk;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return mgstBareStsSeq
	 */
	public String getMgstBareStsSeq() {
		return this.mgstBareStsSeq;
	}
	

	/**
	 * Column Info
	 * @param lsdays
	 */
	public void setLsdays(String lsdays) {
		this.lsdays = lsdays;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param fromlocation
	 */
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	
	/**
	 * Column Info
	 * @param chkChsno
	 */
	public void setChkChsno(String chkChsno) {
		this.chkChsno = chkChsno;
	}
	
	/**
	 * Column Info
	 * @param chkMgset
	 */
	public void setChkMgset(String chkMgset) {
		this.chkMgset = chkMgset;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param mgstBareBmtFlg
	 */
	public void setMgstBareBmtFlg(String mgstBareBmtFlg) {
		this.mgstBareBmtFlg = mgstBareBmtFlg;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqTrspModCd
	 */
	public void setEqTrspModCd(String eqTrspModCd) {
		this.eqTrspModCd = eqTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param fromdate
	 */
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	
	/**
	 * Column Info
	 * @param tolocation
	 */
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	
	/**
	 * Column Info
	 * @param fromstatus
	 */
	public void setFromstatus(String fromstatus) {
		this.fromstatus = fromstatus;
	}
	
	/**
	 * Column Info
	 * @param tostatus
	 */
	public void setTostatus(String tostatus) {
		this.tostatus = tostatus;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param mvmt
	 */
	public void setMvmt(String mvmt) {
		this.mvmt = mvmt;
	}
	
	/**
	 * Column Info
	 * @param rtnYdCd
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param chkEqno
	 */
	public void setChkEqno(String chkEqno) {
		this.chkEqno = chkEqno;
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
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
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
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param mgstBareBmpFlg
	 */
	public void setMgstBareBmpFlg(String mgstBareBmpFlg) {
		this.mgstBareBmpFlg = mgstBareBmpFlg;
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
	 * @param bareMgstRmk
	 */
	public void setBareMgstRmk(String bareMgstRmk) {
		this.bareMgstRmk = bareMgstRmk;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param mgstBareStsSeq
	 */
	public void setMgstBareStsSeq(String mgstBareStsSeq) {
		this.mgstBareStsSeq = mgstBareStsSeq;
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
		setLsdays(JSPUtil.getParameter(request, prefix + "lsdays", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFromlocation(JSPUtil.getParameter(request, prefix + "fromlocation", ""));
		setChkChsno(JSPUtil.getParameter(request, prefix + "chk_chsno", ""));
		setChkMgset(JSPUtil.getParameter(request, prefix + "chk_mgset", ""));
		setTodate(JSPUtil.getParameter(request, prefix + "todate", ""));
		setMgstBareBmtFlg(JSPUtil.getParameter(request, prefix + "mgst_bare_bmt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setEqTrspModCd(JSPUtil.getParameter(request, prefix + "eq_trsp_mod_cd", ""));
		setFromdate(JSPUtil.getParameter(request, prefix + "fromdate", ""));
		setTolocation(JSPUtil.getParameter(request, prefix + "tolocation", ""));
		setFromstatus(JSPUtil.getParameter(request, prefix + "fromstatus", ""));
		setTostatus(JSPUtil.getParameter(request, prefix + "tostatus", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setMvmt(JSPUtil.getParameter(request, prefix + "mvmt", ""));
		setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
		setChkEqno(JSPUtil.getParameter(request, prefix + "chk_eqno", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setMgstBareBmpFlg(JSPUtil.getParameter(request, prefix + "mgst_bare_bmp_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBareMgstRmk(JSPUtil.getParameter(request, prefix + "bare_mgst_rmk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMgstBareStsSeq(JSPUtil.getParameter(request, prefix + "mgst_bare_sts_seq", ""));
		
		setMgstBareStsCd(JSPUtil.getParameter(request, prefix + "mgst_bare_sts_cd", ""));
		setMgstBareEvntDt(JSPUtil.getParameter(request, prefix + "mgst_bare_evnt_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBareMGSetDataVO[]
	 */
	public MGSBareMVMTDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBareMGSetDataVO[]
	 */
	public MGSBareMVMTDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSBareMVMTDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lsdays = (JSPUtil.getParameter(request, prefix	+ "lsdays", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fromlocation = (JSPUtil.getParameter(request, prefix	+ "fromlocation", length));
			String[] chkChsno = (JSPUtil.getParameter(request, prefix	+ "chk_chsno", length));
			String[] chkMgset = (JSPUtil.getParameter(request, prefix	+ "chk_mgset", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] mgstBareBmtFlg = (JSPUtil.getParameter(request, prefix	+ "mgst_bare_bmt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] eqTrspModCd = (JSPUtil.getParameter(request, prefix	+ "eq_trsp_mod_cd", length));
			String[] fromdate = (JSPUtil.getParameter(request, prefix	+ "fromdate", length));
			String[] tolocation = (JSPUtil.getParameter(request, prefix	+ "tolocation", length));
			String[] fromstatus = (JSPUtil.getParameter(request, prefix	+ "fromstatus", length));
			String[] tostatus = (JSPUtil.getParameter(request, prefix	+ "tostatus", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] mvmt = (JSPUtil.getParameter(request, prefix	+ "mvmt", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] chkEqno = (JSPUtil.getParameter(request, prefix	+ "chk_eqno", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] mgstBareBmpFlg = (JSPUtil.getParameter(request, prefix	+ "mgst_bare_bmp_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bareMgstRmk = (JSPUtil.getParameter(request, prefix	+ "bare_mgst_rmk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mgstBareStsSeq = (JSPUtil.getParameter(request, prefix	+ "mgst_bare_sts_seq", length));
			
			String[] mgstBareStsCd  = (JSPUtil.getParameter(request, prefix	+ "mgst_bare_sts_cd", length));
			String[] mgstBareEvntDt = (JSPUtil.getParameter(request, prefix	+ "mgst_bare_evnt_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSBareMVMTDataVO();
				if (lsdays[i] != null)
					model.setLsdays(lsdays[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fromlocation[i] != null)
					model.setFromlocation(fromlocation[i]);
				if (chkChsno[i] != null)
					model.setChkChsno(chkChsno[i]);
				if (chkMgset[i] != null)
					model.setChkMgset(chkMgset[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (mgstBareBmtFlg[i] != null)
					model.setMgstBareBmtFlg(mgstBareBmtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (eqTrspModCd[i] != null)
					model.setEqTrspModCd(eqTrspModCd[i]);
				if (fromdate[i] != null)
					model.setFromdate(fromdate[i]);
				if (tolocation[i] != null)
					model.setTolocation(tolocation[i]);
				if (fromstatus[i] != null)
					model.setFromstatus(fromstatus[i]);
				if (tostatus[i] != null)
					model.setTostatus(tostatus[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (mvmt[i] != null)
					model.setMvmt(mvmt[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (chkEqno[i] != null)
					model.setChkEqno(chkEqno[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (mgstBareBmpFlg[i] != null)
					model.setMgstBareBmpFlg(mgstBareBmpFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bareMgstRmk[i] != null)
					model.setBareMgstRmk(bareMgstRmk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mgstBareStsSeq[i] != null)
					model.setMgstBareStsSeq(mgstBareStsSeq[i]);
				
				if (mgstBareStsCd[i] != null)
					model.setMgstBareStsCd(mgstBareStsCd[i]);
				if (mgstBareEvntDt[i] != null)
					model.setMgstBareEvntDt(mgstBareEvntDt[i]);			
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBareMGSetDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBareMGSetDataVO[]
	 */
	public MGSBareMVMTDataVO[] getSearchBareMGSetDataVOs(){
		MGSBareMVMTDataVO[] vos = (MGSBareMVMTDataVO[])models.toArray(new MGSBareMVMTDataVO[models.size()]);
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
		this.lsdays = this.lsdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromlocation = this.fromlocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkChsno = this.chkChsno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkMgset = this.chkMgset .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBareBmtFlg = this.mgstBareBmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTrspModCd = this.eqTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromdate = this.fromdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tolocation = this.tolocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromstatus = this.fromstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tostatus = this.tostatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmt = this.mvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkEqno = this.chkEqno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBareBmpFlg = this.mgstBareBmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bareMgstRmk = this.bareMgstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBareStsSeq = this.mgstBareStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.mgstBareStsCd = this.mgstBareStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.mgstBareEvntDt = this.mgstBareEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getMgstBareStsCd() {
		return mgstBareStsCd;
	}

	public void setMgstBareStsCd(String mgstBareStsCd) {
		this.mgstBareStsCd = mgstBareStsCd;
	}

	public String getMgstBareEvntDt() {
		return mgstBareEvntDt;
	}

	public void setMgstBareEvntDt(String mgstBareEvntDt) {
		this.mgstBareEvntDt = mgstBareEvntDt;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
}
