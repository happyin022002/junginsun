/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBInterfaceVO.java
*@FileTitle : TPBInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.06 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.common.tpbinterface.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TPBInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TPBInterfaceVO> models = new ArrayList<TPBInterfaceVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String trspIfOfcCd = null;
	/* Column Info */
	private String tmlIfSeq = null;
	/* Column Info */
	private String estmSvrId = null;
	/* Column Info */
	private String ignoreCase = null;
	/* Column Info */
	private String bizModeFlag = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String estmSeqNo = null;
	/* Column Info */
	private String trspIfSeq = null;
	/* Column Info */
	private String tmlIfOfcCd = null;
	/* Column Info */
	private String srcVndrSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String estmRvisNo = null;
	/* Column Info */
	private String srcVndrCntCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String estmDtlSeqNo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String n3ptySrcNo = null;
	/* Column Info */
	private String csrNoCxlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TPBInterfaceVO() {}

	public TPBInterfaceVO(String ibflag, String pagerows, String bizModeFlag, String ignoreCase, String tmlIfOfcCd, String tmlIfSeq, String userOfcCd, String userId, String trspIfOfcCd, String trspIfSeq, String eqKndCd, String ifOfcCd, String n3ptySrcNo, String srcVndrCntCd, String srcVndrSeq, String eqNo, String eqTpszCd, String ifCurrCd, String lgsCostCd, String acctCd, String ifAmt, String estmSvrId, String estmDtlSeqNo, String estmRvisNo, String estmSeqNo, String creUsrId, String currCd, String csrNoCxlFlg) {
		this.userOfcCd = userOfcCd;
		this.currCd = currCd;
		this.ifOfcCd = ifOfcCd;
		this.trspIfOfcCd = trspIfOfcCd;
		this.tmlIfSeq = tmlIfSeq;
		this.estmSvrId = estmSvrId;
		this.ignoreCase = ignoreCase;
		this.bizModeFlag = bizModeFlag;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.userId = userId;
		this.acctCd = acctCd;
		this.estmSeqNo = estmSeqNo;
		this.trspIfSeq = trspIfSeq;
		this.tmlIfOfcCd = tmlIfOfcCd;
		this.srcVndrSeq = srcVndrSeq;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.estmRvisNo = estmRvisNo;
		this.srcVndrCntCd = srcVndrCntCd;
		this.lgsCostCd = lgsCostCd;
		this.ifCurrCd = ifCurrCd;
		this.ifAmt = ifAmt;
		this.estmDtlSeqNo = estmDtlSeqNo;
		this.eqKndCd = eqKndCd;
		this.n3ptySrcNo = n3ptySrcNo;
		this.csrNoCxlFlg = csrNoCxlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("trsp_if_ofc_cd", getTrspIfOfcCd());
		this.hashColumns.put("tml_if_seq", getTmlIfSeq());
		this.hashColumns.put("estm_svr_id", getEstmSvrId());
		this.hashColumns.put("ignore_case", getIgnoreCase());
		this.hashColumns.put("biz_mode_flag", getBizModeFlag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("estm_seq_no", getEstmSeqNo());
		this.hashColumns.put("trsp_if_seq", getTrspIfSeq());
		this.hashColumns.put("tml_if_ofc_cd", getTmlIfOfcCd());
		this.hashColumns.put("src_vndr_seq", getSrcVndrSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("estm_rvis_no", getEstmRvisNo());
		this.hashColumns.put("src_vndr_cnt_cd", getSrcVndrCntCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("estm_dtl_seq_no", getEstmDtlSeqNo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		this.hashColumns.put("csr_no_cxl_flg", getCsrNoCxlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("trsp_if_ofc_cd", "trspIfOfcCd");
		this.hashFields.put("tml_if_seq", "tmlIfSeq");
		this.hashFields.put("estm_svr_id", "estmSvrId");
		this.hashFields.put("ignore_case", "ignoreCase");
		this.hashFields.put("biz_mode_flag", "bizModeFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("estm_seq_no", "estmSeqNo");
		this.hashFields.put("trsp_if_seq", "trspIfSeq");
		this.hashFields.put("tml_if_ofc_cd", "tmlIfOfcCd");
		this.hashFields.put("src_vndr_seq", "srcVndrSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("estm_rvis_no", "estmRvisNo");
		this.hashFields.put("src_vndr_cnt_cd", "srcVndrCntCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("estm_dtl_seq_no", "estmDtlSeqNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		this.hashFields.put("csr_no_cxl_flg", "csrNoCxlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return ifOfcCd
	 */
	public String getIfOfcCd() {
		return this.ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspIfOfcCd
	 */
	public String getTrspIfOfcCd() {
		return this.trspIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tmlIfSeq
	 */
	public String getTmlIfSeq() {
		return this.tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @return estmSvrId
	 */
	public String getEstmSvrId() {
		return this.estmSvrId;
	}
	
	/**
	 * Column Info
	 * @return ignoreCase
	 */
	public String getIgnoreCase() {
		return this.ignoreCase;
	}
	
	/**
	 * Column Info
	 * @return bizModeFlag
	 */
	public String getBizModeFlag() {
		return this.bizModeFlag;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return estmSeqNo
	 */
	public String getEstmSeqNo() {
		return this.estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @return trspIfSeq
	 */
	public String getTrspIfSeq() {
		return this.trspIfSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlIfOfcCd
	 */
	public String getTmlIfOfcCd() {
		return this.tmlIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srcVndrSeq
	 */
	public String getSrcVndrSeq() {
		return this.srcVndrSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return estmRvisNo
	 */
	public String getEstmRvisNo() {
		return this.estmRvisNo;
	}
	
	/**
	 * Column Info
	 * @return srcVndrCntCd
	 */
	public String getSrcVndrCntCd() {
		return this.srcVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return ifCurrCd
	 */
	public String getIfCurrCd() {
		return this.ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return estmDtlSeqNo
	 */
	public String getEstmDtlSeqNo() {
		return this.estmDtlSeqNo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @return csrNoCxlFlg
	 */
	public String getCsrNoCxlFlg() {
		return this.csrNoCxlFlg;
	}
	

	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param ifOfcCd
	 */
	public void setIfOfcCd(String ifOfcCd) {
		this.ifOfcCd = ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspIfOfcCd
	 */
	public void setTrspIfOfcCd(String trspIfOfcCd) {
		this.trspIfOfcCd = trspIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tmlIfSeq
	 */
	public void setTmlIfSeq(String tmlIfSeq) {
		this.tmlIfSeq = tmlIfSeq;
	}
	
	/**
	 * Column Info
	 * @param estmSvrId
	 */
	public void setEstmSvrId(String estmSvrId) {
		this.estmSvrId = estmSvrId;
	}
	
	/**
	 * Column Info
	 * @param ignoreCase
	 */
	public void setIgnoreCase(String ignoreCase) {
		this.ignoreCase = ignoreCase;
	}
	
	/**
	 * Column Info
	 * @param bizModeFlag
	 */
	public void setBizModeFlag(String bizModeFlag) {
		this.bizModeFlag = bizModeFlag;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param estmSeqNo
	 */
	public void setEstmSeqNo(String estmSeqNo) {
		this.estmSeqNo = estmSeqNo;
	}
	
	/**
	 * Column Info
	 * @param trspIfSeq
	 */
	public void setTrspIfSeq(String trspIfSeq) {
		this.trspIfSeq = trspIfSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlIfOfcCd
	 */
	public void setTmlIfOfcCd(String tmlIfOfcCd) {
		this.tmlIfOfcCd = tmlIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srcVndrSeq
	 */
	public void setSrcVndrSeq(String srcVndrSeq) {
		this.srcVndrSeq = srcVndrSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param estmRvisNo
	 */
	public void setEstmRvisNo(String estmRvisNo) {
		this.estmRvisNo = estmRvisNo;
	}
	
	/**
	 * Column Info
	 * @param srcVndrCntCd
	 */
	public void setSrcVndrCntCd(String srcVndrCntCd) {
		this.srcVndrCntCd = srcVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param ifCurrCd
	 */
	public void setIfCurrCd(String ifCurrCd) {
		this.ifCurrCd = ifCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param estmDtlSeqNo
	 */
	public void setEstmDtlSeqNo(String estmDtlSeqNo) {
		this.estmDtlSeqNo = estmDtlSeqNo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @param csrNoCxlFlg
	 */
	public void setCsrNoCxlFlg(String csrNoCxlFlg) {
		this.csrNoCxlFlg = csrNoCxlFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setTrspIfOfcCd(JSPUtil.getParameter(request, "trsp_if_ofc_cd", ""));
		setTmlIfSeq(JSPUtil.getParameter(request, "tml_if_seq", ""));
		setEstmSvrId(JSPUtil.getParameter(request, "estm_svr_id", ""));
		setIgnoreCase(JSPUtil.getParameter(request, "ignore_case", ""));
		setBizModeFlag(JSPUtil.getParameter(request, "biz_mode_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setEstmSeqNo(JSPUtil.getParameter(request, "estm_seq_no", ""));
		setTrspIfSeq(JSPUtil.getParameter(request, "trsp_if_seq", ""));
		setTmlIfOfcCd(JSPUtil.getParameter(request, "tml_if_ofc_cd", ""));
		setSrcVndrSeq(JSPUtil.getParameter(request, "src_vndr_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEstmRvisNo(JSPUtil.getParameter(request, "estm_rvis_no", ""));
		setSrcVndrCntCd(JSPUtil.getParameter(request, "src_vndr_cnt_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setIfCurrCd(JSPUtil.getParameter(request, "if_curr_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, "if_amt", ""));
		setEstmDtlSeqNo(JSPUtil.getParameter(request, "estm_dtl_seq_no", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, "n3pty_src_no", ""));
		setCsrNoCxlFlg(JSPUtil.getParameter(request, "csr_no_cxl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TPBInterfaceVO[]
	 */
	public TPBInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TPBInterfaceVO[]
	 */
	public TPBInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TPBInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] trspIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "trsp_if_ofc_cd", length));
			String[] tmlIfSeq = (JSPUtil.getParameter(request, prefix	+ "tml_if_seq", length));
			String[] estmSvrId = (JSPUtil.getParameter(request, prefix	+ "estm_svr_id", length));
			String[] ignoreCase = (JSPUtil.getParameter(request, prefix	+ "ignore_case", length));
			String[] bizModeFlag = (JSPUtil.getParameter(request, prefix	+ "biz_mode_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] estmSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_seq_no", length));
			String[] trspIfSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_if_seq", length));
			String[] tmlIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "tml_if_ofc_cd", length));
			String[] srcVndrSeq = (JSPUtil.getParameter(request, prefix	+ "src_vndr_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] estmRvisNo = (JSPUtil.getParameter(request, prefix	+ "estm_rvis_no", length));
			String[] srcVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "src_vndr_cnt_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] estmDtlSeqNo = (JSPUtil.getParameter(request, prefix	+ "estm_dtl_seq_no", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			String[] csrNoCxlFlg = (JSPUtil.getParameter(request, prefix	+ "csr_no_cxl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new TPBInterfaceVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (trspIfOfcCd[i] != null)
					model.setTrspIfOfcCd(trspIfOfcCd[i]);
				if (tmlIfSeq[i] != null)
					model.setTmlIfSeq(tmlIfSeq[i]);
				if (estmSvrId[i] != null)
					model.setEstmSvrId(estmSvrId[i]);
				if (ignoreCase[i] != null)
					model.setIgnoreCase(ignoreCase[i]);
				if (bizModeFlag[i] != null)
					model.setBizModeFlag(bizModeFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (estmSeqNo[i] != null)
					model.setEstmSeqNo(estmSeqNo[i]);
				if (trspIfSeq[i] != null)
					model.setTrspIfSeq(trspIfSeq[i]);
				if (tmlIfOfcCd[i] != null)
					model.setTmlIfOfcCd(tmlIfOfcCd[i]);
				if (srcVndrSeq[i] != null)
					model.setSrcVndrSeq(srcVndrSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (estmRvisNo[i] != null)
					model.setEstmRvisNo(estmRvisNo[i]);
				if (srcVndrCntCd[i] != null)
					model.setSrcVndrCntCd(srcVndrCntCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (estmDtlSeqNo[i] != null)
					model.setEstmDtlSeqNo(estmDtlSeqNo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				if (csrNoCxlFlg[i] != null)
					model.setCsrNoCxlFlg(csrNoCxlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTPBInterfaceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TPBInterfaceVO[]
	 */
	public TPBInterfaceVO[] getTPBInterfaceVOs(){
		TPBInterfaceVO[] vos = (TPBInterfaceVO[])models.toArray(new TPBInterfaceVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspIfOfcCd = this.trspIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfSeq = this.tmlIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSvrId = this.estmSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ignoreCase = this.ignoreCase .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizModeFlag = this.bizModeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeqNo = this.estmSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspIfSeq = this.trspIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlIfOfcCd = this.tmlIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcVndrSeq = this.srcVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmRvisNo = this.estmRvisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcVndrCntCd = this.srcVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDtlSeqNo = this.estmDtlSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNoCxlFlg = this.csrNoCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
