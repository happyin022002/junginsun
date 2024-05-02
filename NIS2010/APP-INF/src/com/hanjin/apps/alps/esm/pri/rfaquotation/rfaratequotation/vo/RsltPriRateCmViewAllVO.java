/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriRateCmViewAllVO.java
*@FileTitle : RsltPriRateCmViewAllVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.06 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriRateCmViewAllVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriRateCmViewAllVO> models = new ArrayList<RsltPriRateCmViewAllVO>();
	
	/* Column Info */
	private String dstRoutPntLocDefCd = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String prsPreLodQty = null;
	/* Column Info */
	private String dstRoutViaPortDefCd = null;
	/* Column Info */
	private String pfmcUnit = null;
	/* Column Info */
	private String oriRoutViaPortDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prsPreRespbOpbAmt = null;
	/* Column Info */
	private String prsRatUtCd = null;
	/* Column Info */
	private String oriRoutPntLocDefCd = null;
	/* Column Info */
	private String prsEstmRespbOpbAmt = null;
	/* Column Info */
	private String oriPrsEstmLodQty = null;
	/* Column Info */
	private String preShare = null;
	/* Column Info */
	private String prsEstmLodQty = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String estmOp = null;
	/* Column Info */
	private String estmCm = null;
	/* Column Info */
	private String prsEstmRespbCmpbAmt = null;
	/* Column Info */
	private String preOp = null;
	/* Column Info */
	private String estmShare = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String preCm = null;
	/* Column Info */
	private String prsPreRespbCmpbAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriRateCmViewAllVO() {}

	public RsltPriRateCmViewAllVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String cmdtHdrSeq, String routSeq, String prcCmdtDefCd, String oriRoutPntLocDefCd, String dstRoutPntLocDefCd, String oriRoutViaPortDefCd, String dstRoutViaPortDefCd, String prsPreLodQty, String preShare, String prsPreRespbCmpbAmt, String preCm, String prsEstmLodQty, String estmShare, String prsEstmRespbCmpbAmt, String estmCm, String prsPreRespbOpbAmt, String preOp, String prsEstmRespbOpbAmt, String estmOp, String prsRatUtCd, String cntrSzCd, String oriPrsEstmLodQty, String pfmcUnit) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
		this.cntrSzCd = cntrSzCd;
		this.prsPreLodQty = prsPreLodQty;
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
		this.pfmcUnit = pfmcUnit;
		this.oriRoutViaPortDefCd = oriRoutViaPortDefCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.prsPreRespbOpbAmt = prsPreRespbOpbAmt;
		this.prsRatUtCd = prsRatUtCd;
		this.oriRoutPntLocDefCd = oriRoutPntLocDefCd;
		this.prsEstmRespbOpbAmt = prsEstmRespbOpbAmt;
		this.oriPrsEstmLodQty = oriPrsEstmLodQty;
		this.preShare = preShare;
		this.prsEstmLodQty = prsEstmLodQty;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.estmOp = estmOp;
		this.estmCm = estmCm;
		this.prsEstmRespbCmpbAmt = prsEstmRespbCmpbAmt;
		this.preOp = preOp;
		this.estmShare = estmShare;
		this.routSeq = routSeq;
		this.qttnVerNo = qttnVerNo;
		this.qttnNo = qttnNo;
		this.preCm = preCm;
		this.prsPreRespbCmpbAmt = prsPreRespbCmpbAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dst_rout_pnt_loc_def_cd", getDstRoutPntLocDefCd());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("prs_pre_lod_qty", getPrsPreLodQty());
		this.hashColumns.put("dst_rout_via_port_def_cd", getDstRoutViaPortDefCd());
		this.hashColumns.put("pfmc_unit", getPfmcUnit());
		this.hashColumns.put("ori_rout_via_port_def_cd", getOriRoutViaPortDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prs_pre_respb_opb_amt", getPrsPreRespbOpbAmt());
		this.hashColumns.put("prs_rat_ut_cd", getPrsRatUtCd());
		this.hashColumns.put("ori_rout_pnt_loc_def_cd", getOriRoutPntLocDefCd());
		this.hashColumns.put("prs_estm_respb_opb_amt", getPrsEstmRespbOpbAmt());
		this.hashColumns.put("ori_prs_estm_lod_qty", getOriPrsEstmLodQty());
		this.hashColumns.put("pre_share", getPreShare());
		this.hashColumns.put("prs_estm_lod_qty", getPrsEstmLodQty());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("estm_op", getEstmOp());
		this.hashColumns.put("estm_cm", getEstmCm());
		this.hashColumns.put("prs_estm_respb_cmpb_amt", getPrsEstmRespbCmpbAmt());
		this.hashColumns.put("pre_op", getPreOp());
		this.hashColumns.put("estm_share", getEstmShare());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("pre_cm", getPreCm());
		this.hashColumns.put("prs_pre_respb_cmpb_amt", getPrsPreRespbCmpbAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dst_rout_pnt_loc_def_cd", "dstRoutPntLocDefCd");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("prs_pre_lod_qty", "prsPreLodQty");
		this.hashFields.put("dst_rout_via_port_def_cd", "dstRoutViaPortDefCd");
		this.hashFields.put("pfmc_unit", "pfmcUnit");
		this.hashFields.put("ori_rout_via_port_def_cd", "oriRoutViaPortDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prs_pre_respb_opb_amt", "prsPreRespbOpbAmt");
		this.hashFields.put("prs_rat_ut_cd", "prsRatUtCd");
		this.hashFields.put("ori_rout_pnt_loc_def_cd", "oriRoutPntLocDefCd");
		this.hashFields.put("prs_estm_respb_opb_amt", "prsEstmRespbOpbAmt");
		this.hashFields.put("ori_prs_estm_lod_qty", "oriPrsEstmLodQty");
		this.hashFields.put("pre_share", "preShare");
		this.hashFields.put("prs_estm_lod_qty", "prsEstmLodQty");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("estm_op", "estmOp");
		this.hashFields.put("estm_cm", "estmCm");
		this.hashFields.put("prs_estm_respb_cmpb_amt", "prsEstmRespbCmpbAmt");
		this.hashFields.put("pre_op", "preOp");
		this.hashFields.put("estm_share", "estmShare");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("pre_cm", "preCm");
		this.hashFields.put("prs_pre_respb_cmpb_amt", "prsPreRespbCmpbAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dstRoutPntLocDefCd
	 */
	public String getDstRoutPntLocDefCd() {
		return this.dstRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return prsPreLodQty
	 */
	public String getPrsPreLodQty() {
		return this.prsPreLodQty;
	}
	
	/**
	 * Column Info
	 * @return dstRoutViaPortDefCd
	 */
	public String getDstRoutViaPortDefCd() {
		return this.dstRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return pfmcUnit
	 */
	public String getPfmcUnit() {
		return this.pfmcUnit;
	}
	
	/**
	 * Column Info
	 * @return oriRoutViaPortDefCd
	 */
	public String getOriRoutViaPortDefCd() {
		return this.oriRoutViaPortDefCd;
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
	 * @return prsPreRespbOpbAmt
	 */
	public String getPrsPreRespbOpbAmt() {
		return this.prsPreRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return prsRatUtCd
	 */
	public String getPrsRatUtCd() {
		return this.prsRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return oriRoutPntLocDefCd
	 */
	public String getOriRoutPntLocDefCd() {
		return this.oriRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return prsEstmRespbOpbAmt
	 */
	public String getPrsEstmRespbOpbAmt() {
		return this.prsEstmRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @return oriPrsEstmLodQty
	 */
	public String getOriPrsEstmLodQty() {
		return this.oriPrsEstmLodQty;
	}
	
	/**
	 * Column Info
	 * @return preShare
	 */
	public String getPreShare() {
		return this.preShare;
	}
	
	/**
	 * Column Info
	 * @return prsEstmLodQty
	 */
	public String getPrsEstmLodQty() {
		return this.prsEstmLodQty;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return estmOp
	 */
	public String getEstmOp() {
		return this.estmOp;
	}
	
	/**
	 * Column Info
	 * @return estmCm
	 */
	public String getEstmCm() {
		return this.estmCm;
	}
	
	/**
	 * Column Info
	 * @return prsEstmRespbCmpbAmt
	 */
	public String getPrsEstmRespbCmpbAmt() {
		return this.prsEstmRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return preOp
	 */
	public String getPreOp() {
		return this.preOp;
	}
	
	/**
	 * Column Info
	 * @return estmShare
	 */
	public String getEstmShare() {
		return this.estmShare;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return preCm
	 */
	public String getPreCm() {
		return this.preCm;
	}
	
	/**
	 * Column Info
	 * @return prsPreRespbCmpbAmt
	 */
	public String getPrsPreRespbCmpbAmt() {
		return this.prsPreRespbCmpbAmt;
	}
	

	/**
	 * Column Info
	 * @param dstRoutPntLocDefCd
	 */
	public void setDstRoutPntLocDefCd(String dstRoutPntLocDefCd) {
		this.dstRoutPntLocDefCd = dstRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param prsPreLodQty
	 */
	public void setPrsPreLodQty(String prsPreLodQty) {
		this.prsPreLodQty = prsPreLodQty;
	}
	
	/**
	 * Column Info
	 * @param dstRoutViaPortDefCd
	 */
	public void setDstRoutViaPortDefCd(String dstRoutViaPortDefCd) {
		this.dstRoutViaPortDefCd = dstRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param pfmcUnit
	 */
	public void setPfmcUnit(String pfmcUnit) {
		this.pfmcUnit = pfmcUnit;
	}
	
	/**
	 * Column Info
	 * @param oriRoutViaPortDefCd
	 */
	public void setOriRoutViaPortDefCd(String oriRoutViaPortDefCd) {
		this.oriRoutViaPortDefCd = oriRoutViaPortDefCd;
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
	 * @param prsPreRespbOpbAmt
	 */
	public void setPrsPreRespbOpbAmt(String prsPreRespbOpbAmt) {
		this.prsPreRespbOpbAmt = prsPreRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param prsRatUtCd
	 */
	public void setPrsRatUtCd(String prsRatUtCd) {
		this.prsRatUtCd = prsRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param oriRoutPntLocDefCd
	 */
	public void setOriRoutPntLocDefCd(String oriRoutPntLocDefCd) {
		this.oriRoutPntLocDefCd = oriRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param prsEstmRespbOpbAmt
	 */
	public void setPrsEstmRespbOpbAmt(String prsEstmRespbOpbAmt) {
		this.prsEstmRespbOpbAmt = prsEstmRespbOpbAmt;
	}
	
	/**
	 * Column Info
	 * @param oriPrsEstmLodQty
	 */
	public void setOriPrsEstmLodQty(String oriPrsEstmLodQty) {
		this.oriPrsEstmLodQty = oriPrsEstmLodQty;
	}
	
	/**
	 * Column Info
	 * @param preShare
	 */
	public void setPreShare(String preShare) {
		this.preShare = preShare;
	}
	
	/**
	 * Column Info
	 * @param prsEstmLodQty
	 */
	public void setPrsEstmLodQty(String prsEstmLodQty) {
		this.prsEstmLodQty = prsEstmLodQty;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
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
	 * @param estmOp
	 */
	public void setEstmOp(String estmOp) {
		this.estmOp = estmOp;
	}
	
	/**
	 * Column Info
	 * @param estmCm
	 */
	public void setEstmCm(String estmCm) {
		this.estmCm = estmCm;
	}
	
	/**
	 * Column Info
	 * @param prsEstmRespbCmpbAmt
	 */
	public void setPrsEstmRespbCmpbAmt(String prsEstmRespbCmpbAmt) {
		this.prsEstmRespbCmpbAmt = prsEstmRespbCmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param preOp
	 */
	public void setPreOp(String preOp) {
		this.preOp = preOp;
	}
	
	/**
	 * Column Info
	 * @param estmShare
	 */
	public void setEstmShare(String estmShare) {
		this.estmShare = estmShare;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param preCm
	 */
	public void setPreCm(String preCm) {
		this.preCm = preCm;
	}
	
	/**
	 * Column Info
	 * @param prsPreRespbCmpbAmt
	 */
	public void setPrsPreRespbCmpbAmt(String prsPreRespbCmpbAmt) {
		this.prsPreRespbCmpbAmt = prsPreRespbCmpbAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDstRoutPntLocDefCd(JSPUtil.getParameter(request, "dst_rout_pnt_loc_def_cd", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setPrsPreLodQty(JSPUtil.getParameter(request, "prs_pre_lod_qty", ""));
		setDstRoutViaPortDefCd(JSPUtil.getParameter(request, "dst_rout_via_port_def_cd", ""));
		setPfmcUnit(JSPUtil.getParameter(request, "pfmc_unit", ""));
		setOriRoutViaPortDefCd(JSPUtil.getParameter(request, "ori_rout_via_port_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrsPreRespbOpbAmt(JSPUtil.getParameter(request, "prs_pre_respb_opb_amt", ""));
		setPrsRatUtCd(JSPUtil.getParameter(request, "prs_rat_ut_cd", ""));
		setOriRoutPntLocDefCd(JSPUtil.getParameter(request, "ori_rout_pnt_loc_def_cd", ""));
		setPrsEstmRespbOpbAmt(JSPUtil.getParameter(request, "prs_estm_respb_opb_amt", ""));
		setOriPrsEstmLodQty(JSPUtil.getParameter(request, "ori_prs_estm_lod_qty", ""));
		setPreShare(JSPUtil.getParameter(request, "pre_share", ""));
		setPrsEstmLodQty(JSPUtil.getParameter(request, "prs_estm_lod_qty", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setEstmOp(JSPUtil.getParameter(request, "estm_op", ""));
		setEstmCm(JSPUtil.getParameter(request, "estm_cm", ""));
		setPrsEstmRespbCmpbAmt(JSPUtil.getParameter(request, "prs_estm_respb_cmpb_amt", ""));
		setPreOp(JSPUtil.getParameter(request, "pre_op", ""));
		setEstmShare(JSPUtil.getParameter(request, "estm_share", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setQttnVerNo(JSPUtil.getParameter(request, "qttn_ver_no", ""));
		setQttnNo(JSPUtil.getParameter(request, "qttn_no", ""));
		setPreCm(JSPUtil.getParameter(request, "pre_cm", ""));
		setPrsPreRespbCmpbAmt(JSPUtil.getParameter(request, "prs_pre_respb_cmpb_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRateCmViewAllVO[]
	 */
	public RsltPriRateCmViewAllVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriRateCmViewAllVO[]
	 */
	public RsltPriRateCmViewAllVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriRateCmViewAllVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dstRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_pnt_loc_def_cd", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] prsPreLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_pre_lod_qty", length));
			String[] dstRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dst_rout_via_port_def_cd", length));
			String[] pfmcUnit = (JSPUtil.getParameter(request, prefix	+ "pfmc_unit", length));
			String[] oriRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_via_port_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prsPreRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pre_respb_opb_amt", length));
			String[] prsRatUtCd = (JSPUtil.getParameter(request, prefix	+ "prs_rat_ut_cd", length));
			String[] oriRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "ori_rout_pnt_loc_def_cd", length));
			String[] prsEstmRespbOpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_respb_opb_amt", length));
			String[] oriPrsEstmLodQty = (JSPUtil.getParameter(request, prefix	+ "ori_prs_estm_lod_qty", length));
			String[] preShare = (JSPUtil.getParameter(request, prefix	+ "pre_share", length));
			String[] prsEstmLodQty = (JSPUtil.getParameter(request, prefix	+ "prs_estm_lod_qty", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] estmOp = (JSPUtil.getParameter(request, prefix	+ "estm_op", length));
			String[] estmCm = (JSPUtil.getParameter(request, prefix	+ "estm_cm", length));
			String[] prsEstmRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_estm_respb_cmpb_amt", length));
			String[] preOp = (JSPUtil.getParameter(request, prefix	+ "pre_op", length));
			String[] estmShare = (JSPUtil.getParameter(request, prefix	+ "estm_share", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] preCm = (JSPUtil.getParameter(request, prefix	+ "pre_cm", length));
			String[] prsPreRespbCmpbAmt = (JSPUtil.getParameter(request, prefix	+ "prs_pre_respb_cmpb_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriRateCmViewAllVO();
				if (dstRoutPntLocDefCd[i] != null)
					model.setDstRoutPntLocDefCd(dstRoutPntLocDefCd[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (prsPreLodQty[i] != null)
					model.setPrsPreLodQty(prsPreLodQty[i]);
				if (dstRoutViaPortDefCd[i] != null)
					model.setDstRoutViaPortDefCd(dstRoutViaPortDefCd[i]);
				if (pfmcUnit[i] != null)
					model.setPfmcUnit(pfmcUnit[i]);
				if (oriRoutViaPortDefCd[i] != null)
					model.setOriRoutViaPortDefCd(oriRoutViaPortDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prsPreRespbOpbAmt[i] != null)
					model.setPrsPreRespbOpbAmt(prsPreRespbOpbAmt[i]);
				if (prsRatUtCd[i] != null)
					model.setPrsRatUtCd(prsRatUtCd[i]);
				if (oriRoutPntLocDefCd[i] != null)
					model.setOriRoutPntLocDefCd(oriRoutPntLocDefCd[i]);
				if (prsEstmRespbOpbAmt[i] != null)
					model.setPrsEstmRespbOpbAmt(prsEstmRespbOpbAmt[i]);
				if (oriPrsEstmLodQty[i] != null)
					model.setOriPrsEstmLodQty(oriPrsEstmLodQty[i]);
				if (preShare[i] != null)
					model.setPreShare(preShare[i]);
				if (prsEstmLodQty[i] != null)
					model.setPrsEstmLodQty(prsEstmLodQty[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (estmOp[i] != null)
					model.setEstmOp(estmOp[i]);
				if (estmCm[i] != null)
					model.setEstmCm(estmCm[i]);
				if (prsEstmRespbCmpbAmt[i] != null)
					model.setPrsEstmRespbCmpbAmt(prsEstmRespbCmpbAmt[i]);
				if (preOp[i] != null)
					model.setPreOp(preOp[i]);
				if (estmShare[i] != null)
					model.setEstmShare(estmShare[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (preCm[i] != null)
					model.setPreCm(preCm[i]);
				if (prsPreRespbCmpbAmt[i] != null)
					model.setPrsPreRespbCmpbAmt(prsPreRespbCmpbAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriRateCmViewAllVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriRateCmViewAllVO[]
	 */
	public RsltPriRateCmViewAllVO[] getRsltPriRateCmViewAllVOs(){
		RsltPriRateCmViewAllVO[] vos = (RsltPriRateCmViewAllVO[])models.toArray(new RsltPriRateCmViewAllVO[models.size()]);
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
		this.dstRoutPntLocDefCd = this.dstRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPreLodQty = this.prsPreLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstRoutViaPortDefCd = this.dstRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcUnit = this.pfmcUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutViaPortDefCd = this.oriRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPreRespbOpbAmt = this.prsPreRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsRatUtCd = this.prsRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriRoutPntLocDefCd = this.oriRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmRespbOpbAmt = this.prsEstmRespbOpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriPrsEstmLodQty = this.oriPrsEstmLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preShare = this.preShare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmLodQty = this.prsEstmLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmOp = this.estmOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCm = this.estmCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmRespbCmpbAmt = this.prsEstmRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preOp = this.preOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmShare = this.estmShare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCm = this.preCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPreRespbCmpbAmt = this.prsPreRespbCmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
