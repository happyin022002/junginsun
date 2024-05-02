/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltRtListExcelVO.java
*@FileTitle : RsltRtListExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtListExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtListExcelVO> models = new ArrayList<RsltRtListExcelVO>();
	
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String mqcRngToQty = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String mqcRngFmQty = null;
	/* Column Info */
	private String destRcvDeTermNm = null;
	/* Column Info */
	private String prcCmdtDefCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtListExcelVO() {}

	public RsltRtListExcelVO(String ibflag, String pagerows, String cmdtDpSeq, String routDpSeq, String prcCmdtDefCd, String prcCmdtDefNm, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRcvDeTermNm, String orgPrcTrspModNm, String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String destRcvDeTermNm, String destPrcTrspModNm, String dirCallFlg, String mqcRngFmQty, String mqcRngToQty, String ratUtCd, String prcCgoTpCd, String currCd, String frtRtAmt) {
		this.dirCallFlg = dirCallFlg;
		this.currCd = currCd;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.mqcRngToQty = mqcRngToQty;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.ratUtCd = ratUtCd;
		this.pagerows = pagerows;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.ibflag = ibflag;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.cmdtDpSeq = cmdtDpSeq;
		this.routDpSeq = routDpSeq;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.frtRtAmt = frtRtAmt;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.mqcRngFmQty = mqcRngFmQty;
		this.destRcvDeTermNm = destRcvDeTermNm;
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("mqc_rng_to_qty", getMqcRngToQty());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("mqc_rng_fm_qty", getMqcRngFmQty());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("mqc_rng_to_qty", "mqcRngToQty");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("mqc_rng_fm_qty", "mqcRngFmQty");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mqcRngToQty
	 */
	public String getMqcRngToQty() {
		return this.mqcRngToQty;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
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
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public String getDestPrcTrspModNm() {
		return this.destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return mqcRngFmQty
	 */
	public String getMqcRngFmQty() {
		return this.mqcRngFmQty;
	}
	
	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public String getDestRcvDeTermNm() {
		return this.destRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	

	/**
	 * Column Info
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mqcRngToQty
	 */
	public void setMqcRngToQty(String mqcRngToQty) {
		this.mqcRngToQty = mqcRngToQty;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
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
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param destPrcTrspModNm
	 */
	public void setDestPrcTrspModNm(String destPrcTrspModNm) {
		this.destPrcTrspModNm = destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param frtRtAmt
	 */
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param mqcRngFmQty
	 */
	public void setMqcRngFmQty(String mqcRngFmQty) {
		this.mqcRngFmQty = mqcRngFmQty;
	}
	
	/**
	 * Column Info
	 * @param destRcvDeTermNm
	 */
	public void setDestRcvDeTermNm(String destRcvDeTermNm) {
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
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
		setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setMqcRngToQty(JSPUtil.getParameter(request, prefix + "mqc_rng_to_qty", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_nm", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_nm", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setMqcRngFmQty(JSPUtil.getParameter(request, prefix + "mqc_rng_fm_qty", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtListExcelVO[]
	 */
	public RsltRtListExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtListExcelVO[]
	 */
	public RsltRtListExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] mqcRngToQty = (JSPUtil.getParameter(request, prefix	+ "mqc_rng_to_qty", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_nm", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] mqcRngFmQty = (JSPUtil.getParameter(request, prefix	+ "mqc_rng_fm_qty", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtListExcelVO();
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (mqcRngToQty[i] != null)
					model.setMqcRngToQty(mqcRngToQty[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (mqcRngFmQty[i] != null)
					model.setMqcRngFmQty(mqcRngFmQty[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtListExcelVO[]
	 */
	public RsltRtListExcelVO[] getRsltRtListExcelVOs(){
		RsltRtListExcelVO[] vos = (RsltRtListExcelVO[])models.toArray(new RsltRtListExcelVO[models.size()]);
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
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngToQty = this.mqcRngToQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngFmQty = this.mqcRngFmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
