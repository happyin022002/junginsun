/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchSCPerformanceDetailListVO.java
*@FileTitle : RsltSearchSCPerformanceDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.20 류선우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author 류선우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCPerformanceDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCPerformanceDetailListVO> models = new ArrayList<RsltSearchSCPerformanceDetailListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String chkGenSpclRtTpCd = null;
	/* Column Info */
	private String chkVvd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String chkSlanCd = null;
	/* Column Info */
	private String skdDirCdTxt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String blObrdDtTo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usaSvcModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String chkUsaSvcModCd = null;
	/* Column Info */
	private String chkPodCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String chkActCustNm = null;
	/* Column Info */
	private String blObrdDtFrom = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String chkCmdtNm = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String chkPolCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String actCustNm = null;
	/* Column Info */
	private String chkDelCd = null;
	/* Column Info */
	private String chkPorCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCPerformanceDetailListVO() {}

	public RsltSearchSCPerformanceDetailListVO(String ibflag, String pagerows, String trdCd, String skdDirCd, String subTrdCd, String svcScpCd, String slanCd, String vvd, String genSpclRtTpCd, String cmdtNm, String actCustNm, String usaSvcModCd, String porCd, String polCd, String podCd, String delCd, String opCntrQty, String scNo, String vslCd, String skdVoyNo, String blObrdDtFrom, String blObrdDtTo, String skdDirCdTxt, String cmdtHdrSeq, String chkSlanCd, String chkVvd, String chkGenSpclRtTpCd, String chkCmdtNm, String chkActCustNm, String chkUsaSvcModCd, String chkPorCd, String chkPolCd, String chkPodCd, String chkDelCd) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.chkGenSpclRtTpCd = chkGenSpclRtTpCd;
		this.chkVvd = chkVvd;
		this.svcScpCd = svcScpCd;
		this.chkSlanCd = chkSlanCd;
		this.skdDirCdTxt = skdDirCdTxt;
		this.trdCd = trdCd;
		this.blObrdDtTo = blObrdDtTo;
		this.pagerows = pagerows;
		this.usaSvcModCd = usaSvcModCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.chkUsaSvcModCd = chkUsaSvcModCd;
		this.chkPodCd = chkPodCd;
		this.scNo = scNo;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.chkActCustNm = chkActCustNm;
		this.blObrdDtFrom = blObrdDtFrom;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.chkCmdtNm = chkCmdtNm;
		this.cmdtNm = cmdtNm;
		this.skdDirCd = skdDirCd;
		this.chkPolCd = chkPolCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.slanCd = slanCd;
		this.actCustNm = actCustNm;
		this.chkDelCd = chkDelCd;
		this.chkPorCd = chkPorCd;
		this.opCntrQty = opCntrQty;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("chk_gen_spcl_rt_tp_cd", getChkGenSpclRtTpCd());
		this.hashColumns.put("chk_vvd", getChkVvd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("chk_slan_cd", getChkSlanCd());
		this.hashColumns.put("skd_dir_cd_txt", getSkdDirCdTxt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bl_obrd_dt_to", getBlObrdDtTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usa_svc_mod_cd", getUsaSvcModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("chk_usa_svc_mod_cd", getChkUsaSvcModCd());
		this.hashColumns.put("chk_pod_cd", getChkPodCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("chk_act_cust_nm", getChkActCustNm());
		this.hashColumns.put("bl_obrd_dt_from", getBlObrdDtFrom());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("chk_cmdt_nm", getChkCmdtNm());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("chk_pol_cd", getChkPolCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("chk_del_cd", getChkDelCd());
		this.hashColumns.put("chk_por_cd", getChkPorCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("chk_gen_spcl_rt_tp_cd", "chkGenSpclRtTpCd");
		this.hashFields.put("chk_vvd", "chkVvd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("chk_slan_cd", "chkSlanCd");
		this.hashFields.put("skd_dir_cd_txt", "skdDirCdTxt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bl_obrd_dt_to", "blObrdDtTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usa_svc_mod_cd", "usaSvcModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("chk_usa_svc_mod_cd", "chkUsaSvcModCd");
		this.hashFields.put("chk_pod_cd", "chkPodCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("chk_act_cust_nm", "chkActCustNm");
		this.hashFields.put("bl_obrd_dt_from", "blObrdDtFrom");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("chk_cmdt_nm", "chkCmdtNm");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("chk_pol_cd", "chkPolCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("chk_del_cd", "chkDelCd");
		this.hashFields.put("chk_por_cd", "chkPorCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return chkGenSpclRtTpCd
	 */
	public String getChkGenSpclRtTpCd() {
		return this.chkGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkVvd
	 */
	public String getChkVvd() {
		return this.chkVvd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return chkSlanCd
	 */
	public String getChkSlanCd() {
		return this.chkSlanCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCdTxt
	 */
	public String getSkdDirCdTxt() {
		return this.skdDirCdTxt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtTo
	 */
	public String getBlObrdDtTo() {
		return this.blObrdDtTo;
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
	 * @return usaSvcModCd
	 */
	public String getUsaSvcModCd() {
		return this.usaSvcModCd;
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
	 * @return chkUsaSvcModCd
	 */
	public String getChkUsaSvcModCd() {
		return this.chkUsaSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return chkPodCd
	 */
	public String getChkPodCd() {
		return this.chkPodCd;
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
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkActCustNm
	 */
	public String getChkActCustNm() {
		return this.chkActCustNm;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtFrom
	 */
	public String getBlObrdDtFrom() {
		return this.blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return chkCmdtNm
	 */
	public String getChkCmdtNm() {
		return this.chkCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return chkPolCd
	 */
	public String getChkPolCd() {
		return this.chkPolCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return actCustNm
	 */
	public String getActCustNm() {
		return this.actCustNm;
	}
	
	/**
	 * Column Info
	 * @return chkDelCd
	 */
	public String getChkDelCd() {
		return this.chkDelCd;
	}
	
	/**
	 * Column Info
	 * @return chkPorCd
	 */
	public String getChkPorCd() {
		return this.chkPorCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param chkGenSpclRtTpCd
	 */
	public void setChkGenSpclRtTpCd(String chkGenSpclRtTpCd) {
		this.chkGenSpclRtTpCd = chkGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param chkVvd
	 */
	public void setChkVvd(String chkVvd) {
		this.chkVvd = chkVvd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param chkSlanCd
	 */
	public void setChkSlanCd(String chkSlanCd) {
		this.chkSlanCd = chkSlanCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCdTxt
	 */
	public void setSkdDirCdTxt(String skdDirCdTxt) {
		this.skdDirCdTxt = skdDirCdTxt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtTo
	 */
	public void setBlObrdDtTo(String blObrdDtTo) {
		this.blObrdDtTo = blObrdDtTo;
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
	 * @param usaSvcModCd
	 */
	public void setUsaSvcModCd(String usaSvcModCd) {
		this.usaSvcModCd = usaSvcModCd;
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
	 * @param chkUsaSvcModCd
	 */
	public void setChkUsaSvcModCd(String chkUsaSvcModCd) {
		this.chkUsaSvcModCd = chkUsaSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param chkPodCd
	 */
	public void setChkPodCd(String chkPodCd) {
		this.chkPodCd = chkPodCd;
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
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param chkActCustNm
	 */
	public void setChkActCustNm(String chkActCustNm) {
		this.chkActCustNm = chkActCustNm;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtFrom
	 */
	public void setBlObrdDtFrom(String blObrdDtFrom) {
		this.blObrdDtFrom = blObrdDtFrom;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param chkCmdtNm
	 */
	public void setChkCmdtNm(String chkCmdtNm) {
		this.chkCmdtNm = chkCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param chkPolCd
	 */
	public void setChkPolCd(String chkPolCd) {
		this.chkPolCd = chkPolCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param actCustNm
	 */
	public void setActCustNm(String actCustNm) {
		this.actCustNm = actCustNm;
	}
	
	/**
	 * Column Info
	 * @param chkDelCd
	 */
	public void setChkDelCd(String chkDelCd) {
		this.chkDelCd = chkDelCd;
	}
	
	/**
	 * Column Info
	 * @param chkPorCd
	 */
	public void setChkPorCd(String chkPorCd) {
		this.chkPorCd = chkPorCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setChkGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "chk_gen_spcl_rt_tp_cd", ""));
		setChkVvd(JSPUtil.getParameter(request, prefix + "chk_vvd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setChkSlanCd(JSPUtil.getParameter(request, prefix + "chk_slan_cd", ""));
		setSkdDirCdTxt(JSPUtil.getParameter(request, prefix + "skd_dir_cd_txt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBlObrdDtTo(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_to", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsaSvcModCd(JSPUtil.getParameter(request, prefix + "usa_svc_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setChkUsaSvcModCd(JSPUtil.getParameter(request, prefix + "chk_usa_svc_mod_cd", ""));
		setChkPodCd(JSPUtil.getParameter(request, prefix + "chk_pod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setChkActCustNm(JSPUtil.getParameter(request, prefix + "chk_act_cust_nm", ""));
		setBlObrdDtFrom(JSPUtil.getParameter(request, prefix + "bl_obrd_dt_from", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setChkCmdtNm(JSPUtil.getParameter(request, prefix + "chk_cmdt_nm", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setChkPolCd(JSPUtil.getParameter(request, prefix + "chk_pol_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setActCustNm(JSPUtil.getParameter(request, prefix + "act_cust_nm", ""));
		setChkDelCd(JSPUtil.getParameter(request, prefix + "chk_del_cd", ""));
		setChkPorCd(JSPUtil.getParameter(request, prefix + "chk_por_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCPerformanceDetailListVO[]
	 */
	public RsltSearchSCPerformanceDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCPerformanceDetailListVO[]
	 */
	public RsltSearchSCPerformanceDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCPerformanceDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] chkGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "chk_gen_spcl_rt_tp_cd", length));
			String[] chkVvd = (JSPUtil.getParameter(request, prefix	+ "chk_vvd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] chkSlanCd = (JSPUtil.getParameter(request, prefix	+ "chk_slan_cd", length));
			String[] skdDirCdTxt = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd_txt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] blObrdDtTo = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usaSvcModCd = (JSPUtil.getParameter(request, prefix	+ "usa_svc_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] chkUsaSvcModCd = (JSPUtil.getParameter(request, prefix	+ "chk_usa_svc_mod_cd", length));
			String[] chkPodCd = (JSPUtil.getParameter(request, prefix	+ "chk_pod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] chkActCustNm = (JSPUtil.getParameter(request, prefix	+ "chk_act_cust_nm", length));
			String[] blObrdDtFrom = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_from", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] chkCmdtNm = (JSPUtil.getParameter(request, prefix	+ "chk_cmdt_nm", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] chkPolCd = (JSPUtil.getParameter(request, prefix	+ "chk_pol_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] actCustNm = (JSPUtil.getParameter(request, prefix	+ "act_cust_nm", length));
			String[] chkDelCd = (JSPUtil.getParameter(request, prefix	+ "chk_del_cd", length));
			String[] chkPorCd = (JSPUtil.getParameter(request, prefix	+ "chk_por_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCPerformanceDetailListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (chkGenSpclRtTpCd[i] != null)
					model.setChkGenSpclRtTpCd(chkGenSpclRtTpCd[i]);
				if (chkVvd[i] != null)
					model.setChkVvd(chkVvd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (chkSlanCd[i] != null)
					model.setChkSlanCd(chkSlanCd[i]);
				if (skdDirCdTxt[i] != null)
					model.setSkdDirCdTxt(skdDirCdTxt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (blObrdDtTo[i] != null)
					model.setBlObrdDtTo(blObrdDtTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usaSvcModCd[i] != null)
					model.setUsaSvcModCd(usaSvcModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (chkUsaSvcModCd[i] != null)
					model.setChkUsaSvcModCd(chkUsaSvcModCd[i]);
				if (chkPodCd[i] != null)
					model.setChkPodCd(chkPodCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (chkActCustNm[i] != null)
					model.setChkActCustNm(chkActCustNm[i]);
				if (blObrdDtFrom[i] != null)
					model.setBlObrdDtFrom(blObrdDtFrom[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (chkCmdtNm[i] != null)
					model.setChkCmdtNm(chkCmdtNm[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (chkPolCd[i] != null)
					model.setChkPolCd(chkPolCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (actCustNm[i] != null)
					model.setActCustNm(actCustNm[i]);
				if (chkDelCd[i] != null)
					model.setChkDelCd(chkDelCd[i]);
				if (chkPorCd[i] != null)
					model.setChkPorCd(chkPorCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCPerformanceDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCPerformanceDetailListVO[]
	 */
	public RsltSearchSCPerformanceDetailListVO[] getRsltSearchSCPerformanceDetailListVOs(){
		RsltSearchSCPerformanceDetailListVO[] vos = (RsltSearchSCPerformanceDetailListVO[])models.toArray(new RsltSearchSCPerformanceDetailListVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkGenSpclRtTpCd = this.chkGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkVvd = this.chkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSlanCd = this.chkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCdTxt = this.skdDirCdTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtTo = this.blObrdDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSvcModCd = this.usaSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkUsaSvcModCd = this.chkUsaSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPodCd = this.chkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkActCustNm = this.chkActCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtFrom = this.blObrdDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCmdtNm = this.chkCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPolCd = this.chkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm = this.actCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDelCd = this.chkDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPorCd = this.chkPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
