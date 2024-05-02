/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ZZZVO.java
*@FileTitle : ZZZVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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

public class BkgBlckListMntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgBlckListMntrVO> models = new ArrayList<BkgBlckListMntrVO>();
	
	/* Column Info */
	private String custDescKwNm = null;
	/* Column Info */
	private String cstmsDescKwNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fwrdCntCd = null;
	/* Column Info */
	private String interXterRmkKwNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cmdtDescKwNm = null;
	/* Column Info */
	private String shprKwNm = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String blckKwTpCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String fwrdSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrMfGdsDescKwNm = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cneeKwNm = null;
	/* Column Info */
	private String blckKwTpSeq = null;
	/* Column Info */
	private String blckKwNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String fwrdKwNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgBlckListMntrVO() {}

	public BkgBlckListMntrVO(String ibflag, String pagerows, String blckKwTpCd, String blckKwTpSeq, String bkgNo, String blckKwNm, String blNo, String obSlsOfcCd, String ctrtOfcCd, String opCntrQty, String shprCntCd, String shprSeq, String shprKwNm, String fwrdCntCd, String fwrdSeq, String fwrdKwNm, String cneeCntCd, String cneeSeq, String cneeKwNm, String porCd, String polCd, String podCd, String delCd, String cmdtCd, String interXterRmkKwNm, String cntrMfGdsDescKwNm, String cmdtDescKwNm, String cstmsDescKwNm, String creUsrId, String creDt, String updUsrId, String custDescKwNm) {
		this.custDescKwNm = custDescKwNm;
		this.cstmsDescKwNm = cstmsDescKwNm;
		this.porCd = porCd;
		this.fwrdCntCd = fwrdCntCd;
		this.interXterRmkKwNm = interXterRmkKwNm;
		this.creDt = creDt;
		this.cmdtDescKwNm = cmdtDescKwNm;
		this.shprKwNm = shprKwNm;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cneeCntCd = cneeCntCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cmdtCd = cmdtCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.blckKwTpCd = blckKwTpCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.fwrdSeq = fwrdSeq;
		this.updUsrId = updUsrId;
		this.cntrMfGdsDescKwNm = cntrMfGdsDescKwNm;
		this.shprCntCd = shprCntCd;
		this.delCd = delCd;
		this.cneeKwNm = cneeKwNm;
		this.blckKwTpSeq = blckKwTpSeq;
		this.blckKwNm = blckKwNm;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cneeSeq = cneeSeq;
		this.opCntrQty = opCntrQty;
		this.shprSeq = shprSeq;
		this.fwrdKwNm = fwrdKwNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_desc_kw_nm", getCustDescKwNm());
		this.hashColumns.put("cstms_desc_kw_nm", getCstmsDescKwNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("fwrd_cnt_cd", getFwrdCntCd());
		this.hashColumns.put("inter_xter_rmk_kw_nm", getInterXterRmkKwNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cmdt_desc_kw_nm", getCmdtDescKwNm());
		this.hashColumns.put("shpr_kw_nm", getShprKwNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("blck_kw_tp_cd", getBlckKwTpCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("fwrd_seq", getFwrdSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_mf_gds_desc_kw_nm", getCntrMfGdsDescKwNm());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cnee_kw_nm", getCneeKwNm());
		this.hashColumns.put("blck_kw_tp_seq", getBlckKwTpSeq());
		this.hashColumns.put("blck_kw_nm", getBlckKwNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("fwrd_kw_nm", getFwrdKwNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_desc_kw_nm", "custDescKwNm");
		this.hashFields.put("cstms_desc_kw_nm", "cstmsDescKwNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("fwrd_cnt_cd", "fwrdCntCd");
		this.hashFields.put("inter_xter_rmk_kw_nm", "interXterRmkKwNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cmdt_desc_kw_nm", "cmdtDescKwNm");
		this.hashFields.put("shpr_kw_nm", "shprKwNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("blck_kw_tp_cd", "blckKwTpCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("fwrd_seq", "fwrdSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_mf_gds_desc_kw_nm", "cntrMfGdsDescKwNm");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cnee_kw_nm", "cneeKwNm");
		this.hashFields.put("blck_kw_tp_seq", "blckKwTpSeq");
		this.hashFields.put("blck_kw_nm", "blckKwNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("fwrd_kw_nm", "fwrdKwNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custDescKwNm
	 */
	public String getCustDescKwNm() {
		return this.custDescKwNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsDescKwNm
	 */
	public String getCstmsDescKwNm() {
		return this.cstmsDescKwNm;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return fwrdCntCd
	 */
	public String getFwrdCntCd() {
		return this.fwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return interXterRmkKwNm
	 */
	public String getInterXterRmkKwNm() {
		return this.interXterRmkKwNm;
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
	 * @return cmdtDescKwNm
	 */
	public String getCmdtDescKwNm() {
		return this.cmdtDescKwNm;
	}
	
	/**
	 * Column Info
	 * @return shprKwNm
	 */
	public String getShprKwNm() {
		return this.shprKwNm;
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
	 * Column Info
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blckKwTpCd
	 */
	public String getBlckKwTpCd() {
		return this.blckKwTpCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fwrdSeq
	 */
	public String getFwrdSeq() {
		return this.fwrdSeq;
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
	 * @return cntrMfGdsDescKwNm
	 */
	public String getCntrMfGdsDescKwNm() {
		return this.cntrMfGdsDescKwNm;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return cneeKwNm
	 */
	public String getCneeKwNm() {
		return this.cneeKwNm;
	}
	
	/**
	 * Column Info
	 * @return blckKwTpSeq
	 */
	public String getBlckKwTpSeq() {
		return this.blckKwTpSeq;
	}
	
	/**
	 * Column Info
	 * @return blckKwNm
	 */
	public String getBlckKwNm() {
		return this.blckKwNm;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return fwrdKwNm
	 */
	public String getFwrdKwNm() {
		return this.fwrdKwNm;
	}
	
	/**
	 * Column Info
	 * @param custDescKwNm
	 */
	public void setCustDescKwNm(String custDescKwNm) {
		this.custDescKwNm = custDescKwNm;
	}
	

	/**
	 * Column Info
	 * @param cstmsDescKwNm
	 */
	public void setCstmsDescKwNm(String cstmsDescKwNm) {
		this.cstmsDescKwNm = cstmsDescKwNm;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param fwrdCntCd
	 */
	public void setFwrdCntCd(String fwrdCntCd) {
		this.fwrdCntCd = fwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param interXterRmkKwNm
	 */
	public void setInterXterRmkKwNm(String interXterRmkKwNm) {
		this.interXterRmkKwNm = interXterRmkKwNm;
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
	 * @param cmdtDescKwNm
	 */
	public void setCmdtDescKwNm(String cmdtDescKwNm) {
		this.cmdtDescKwNm = cmdtDescKwNm;
	}
	
	/**
	 * Column Info
	 * @param shprKwNm
	 */
	public void setShprKwNm(String shprKwNm) {
		this.shprKwNm = shprKwNm;
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
	 * Column Info
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blckKwTpCd
	 */
	public void setBlckKwTpCd(String blckKwTpCd) {
		this.blckKwTpCd = blckKwTpCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fwrdSeq
	 */
	public void setFwrdSeq(String fwrdSeq) {
		this.fwrdSeq = fwrdSeq;
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
	 * @param cntrMfGdsDescKwNm
	 */
	public void setCntrMfGdsDescKwNm(String cntrMfGdsDescKwNm) {
		this.cntrMfGdsDescKwNm = cntrMfGdsDescKwNm;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param cneeKwNm
	 */
	public void setCneeKwNm(String cneeKwNm) {
		this.cneeKwNm = cneeKwNm;
	}
	
	/**
	 * Column Info
	 * @param blckKwTpSeq
	 */
	public void setBlckKwTpSeq(String blckKwTpSeq) {
		this.blckKwTpSeq = blckKwTpSeq;
	}
	
	/**
	 * Column Info
	 * @param blckKwNm
	 */
	public void setBlckKwNm(String blckKwNm) {
		this.blckKwNm = blckKwNm;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param fwrdKwNm
	 */
	public void setFwrdKwNm(String fwrdKwNm) {
		this.fwrdKwNm = fwrdKwNm;
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
		setCustDescKwNm(JSPUtil.getParameter(request, prefix + "cust_desc_kw_nm", ""));
		setCstmsDescKwNm(JSPUtil.getParameter(request, prefix + "cstms_desc_kw_nm", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setFwrdCntCd(JSPUtil.getParameter(request, prefix + "fwrd_cnt_cd", ""));
		setInterXterRmkKwNm(JSPUtil.getParameter(request, prefix + "inter_xter_rmk_kw_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCmdtDescKwNm(JSPUtil.getParameter(request, prefix + "cmdt_desc_kw_nm", ""));
		setShprKwNm(JSPUtil.getParameter(request, prefix + "shpr_kw_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setBlckKwTpCd(JSPUtil.getParameter(request, prefix + "blck_kw_tp_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setFwrdSeq(JSPUtil.getParameter(request, prefix + "fwrd_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrMfGdsDescKwNm(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc_kw_nm", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCneeKwNm(JSPUtil.getParameter(request, prefix + "cnee_kw_nm", ""));
		setBlckKwTpSeq(JSPUtil.getParameter(request, prefix + "blck_kw_tp_seq", ""));
		setBlckKwNm(JSPUtil.getParameter(request, prefix + "blck_kw_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setFwrdKwNm(JSPUtil.getParameter(request, prefix + "fwrd_kw_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ZZZVO[]
	 */
	public BkgBlckListMntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ZZZVO[]
	 */
	public BkgBlckListMntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgBlckListMntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custDescKwNm = (JSPUtil.getParameter(request, prefix	+ "cust_desc_kw_nm", length));
			String[] cstmsDescKwNm = (JSPUtil.getParameter(request, prefix	+ "cstms_desc_kw_nm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "fwrd_cnt_cd", length));
			String[] interXterRmkKwNm = (JSPUtil.getParameter(request, prefix	+ "inter_xter_rmk_kw_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cmdtDescKwNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc_kw_nm", length));
			String[] shprKwNm = (JSPUtil.getParameter(request, prefix	+ "shpr_kw_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] blckKwTpCd = (JSPUtil.getParameter(request, prefix	+ "blck_kw_tp_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] fwrdSeq = (JSPUtil.getParameter(request, prefix	+ "fwrd_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrMfGdsDescKwNm = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc_kw_nm", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cneeKwNm = (JSPUtil.getParameter(request, prefix	+ "cnee_kw_nm", length));
			String[] blckKwTpSeq = (JSPUtil.getParameter(request, prefix	+ "blck_kw_tp_seq", length));
			String[] blckKwNm = (JSPUtil.getParameter(request, prefix	+ "blck_kw_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] fwrdKwNm = (JSPUtil.getParameter(request, prefix	+ "fwrd_kw_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgBlckListMntrVO();
				if (cstmsDescKwNm[i] != null)
					model.setCstmsDescKwNm(cstmsDescKwNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fwrdCntCd[i] != null)
					model.setFwrdCntCd(fwrdCntCd[i]);
				if (interXterRmkKwNm[i] != null)
					model.setInterXterRmkKwNm(interXterRmkKwNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cmdtDescKwNm[i] != null)
					model.setCmdtDescKwNm(cmdtDescKwNm[i]);
				if (shprKwNm[i] != null)
					model.setShprKwNm(shprKwNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (blckKwTpCd[i] != null)
					model.setBlckKwTpCd(blckKwTpCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (fwrdSeq[i] != null)
					model.setFwrdSeq(fwrdSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrMfGdsDescKwNm[i] != null)
					model.setCntrMfGdsDescKwNm(cntrMfGdsDescKwNm[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cneeKwNm[i] != null)
					model.setCneeKwNm(cneeKwNm[i]);
				if (blckKwTpSeq[i] != null)
					model.setBlckKwTpSeq(blckKwTpSeq[i]);
				if (blckKwNm[i] != null)
					model.setBlckKwNm(blckKwNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (fwrdKwNm[i] != null)
					model.setFwrdKwNm(fwrdKwNm[i]);
				if (custDescKwNm[i] != null)
					model.setCustDescKwNm(custDescKwNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgBlckListMntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ZZZVO[]
	 */
	public BkgBlckListMntrVO[] getBkgBlckListMntrVOs(){
		BkgBlckListMntrVO[] vos = (BkgBlckListMntrVO[])models.toArray(new BkgBlckListMntrVO[models.size()]);
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
		this.custDescKwNm = this.custDescKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDescKwNm = this.cstmsDescKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdCntCd = this.fwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interXterRmkKwNm = this.interXterRmkKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDescKwNm = this.cmdtDescKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprKwNm = this.shprKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwTpCd = this.blckKwTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdSeq = this.fwrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDescKwNm = this.cntrMfGdsDescKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeKwNm = this.cneeKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwTpSeq = this.blckKwTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwNm = this.blckKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdKwNm = this.fwrdKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
