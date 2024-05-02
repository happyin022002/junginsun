/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TxsBkgListForAuditVO.java
*@FileTitle : TxsBkgListForAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.27 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TxsBkgListForAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TxsBkgListForAuditVO> models = new ArrayList<TxsBkgListForAuditVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String trsBkgNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String triAxlFlg = null;
	/* Column Info */
	private String woRmk = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String tpbBkgNo = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String sub = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String cfmCurrCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TxsBkgListForAuditVO() {}

	public TxsBkgListForAuditVO(String ibflag, String bkgNo, String svcScpCd, String porCd, String polCd, String podCd, String delCd, String ctrtNo, String ratUtCd, String currCd, String chgAmt, String trsBkgNo, String eqTpszCd, String eqNo, String triAxlFlg, String woRmk, String loclCreDt, String woNo, String tpbBkgNo, String n3ptyExpnTpCd, String sub, String n3ptyNo, String cfmCurrCd, String invAmt, String bkgCnt, String rcvTermCd, String deTermCd, String pagerows ) {
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.svcScpCd = svcScpCd;
		this.porCd = porCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
		this.ctrtNo = ctrtNo;
		this.ratUtCd = ratUtCd;
		this.currCd = currCd;
		this.chgAmt = chgAmt;
		this.trsBkgNo = trsBkgNo;
		this.eqTpszCd = eqTpszCd;
		this.eqNo = eqNo;
		this.triAxlFlg = triAxlFlg;
		this.woRmk = woRmk;
		this.loclCreDt = loclCreDt;
		this.woNo = woNo;
		this.tpbBkgNo = tpbBkgNo;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.sub = sub;
		this.n3ptyNo = n3ptyNo;
		this.cfmCurrCd = cfmCurrCd;
		this.invAmt = invAmt;
		this.bkgCnt = bkgCnt;
		this.rcvTermCd = rcvTermCd;
		this.deTermCd = deTermCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("trs_bkg_no", getTrsBkgNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("tri_axl_flg", getTriAxlFlg());
		this.hashColumns.put("wo_rmk", getWoRmk());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("tpb_bkg_no", getTpbBkgNo());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("sub", getSub());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("cfm_curr_cd", getCfmCurrCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("trs_bkg_no", "trsBkgNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("tri_axl_flg", "triAxlFlg");
		this.hashFields.put("wo_rmk", "woRmk");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("tpb_bkg_no", "tpbBkgNo");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("sub", "sub");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("cfm_curr_cd", "cfmCurrCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return trsBkgNo
	 */
	public String getTrsBkgNo() {
		return this.trsBkgNo;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return triAxlFlg
	 */
	public String getTriAxlFlg() {
		return this.triAxlFlg;
	}
	
	/**
	 * Column Info
	 * @return woRmk
	 */
	public String getWoRmk() {
		return this.woRmk;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return tpbBkgNo
	 */
	public String getTpbBkgNo() {
		return this.tpbBkgNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return sub
	 */
	public String getSub() {
		return this.sub;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return cfmCurrCd
	 */
	public String getCfmCurrCd() {
		return this.cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param trsBkgNo
	 */
	public void setTrsBkgNo(String trsBkgNo) {
		this.trsBkgNo = trsBkgNo;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param triAxlFlg
	 */
	public void setTriAxlFlg(String triAxlFlg) {
		this.triAxlFlg = triAxlFlg;
	}
	
	/**
	 * Column Info
	 * @param woRmk
	 */
	public void setWoRmk(String woRmk) {
		this.woRmk = woRmk;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param tpbBkgNo
	 */
	public void setTpbBkgNo(String tpbBkgNo) {
		this.tpbBkgNo = tpbBkgNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param sub
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param cfmCurrCd
	 */
	public void setCfmCurrCd(String cfmCurrCd) {
		this.cfmCurrCd = cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setTrsBkgNo(JSPUtil.getParameter(request, prefix + "trs_bkg_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setTriAxlFlg(JSPUtil.getParameter(request, prefix + "tri_axl_flg", ""));
		setWoRmk(JSPUtil.getParameter(request, prefix + "wo_rmk", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setTpbBkgNo(JSPUtil.getParameter(request, prefix + "tpb_bkg_no", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, prefix + "n3pty_expn_tp_cd", ""));
		setSub(JSPUtil.getParameter(request, prefix + "sub", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setCfmCurrCd(JSPUtil.getParameter(request, prefix + "cfm_curr_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchRetroActFilterVO[]
	 */
	public TxsBkgListForAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchRetroActFilterVO[]
	 */
	public TxsBkgListForAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TxsBkgListForAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] trsBkgNo = (JSPUtil.getParameter(request, prefix	+ "trs_bkg_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] triAxlFlg = (JSPUtil.getParameter(request, prefix	+ "tri_axl_flg", length));
			String[] woRmk = (JSPUtil.getParameter(request, prefix	+ "wo_rmk", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] tpbBkgNo = (JSPUtil.getParameter(request, prefix	+ "tpb_bkg_no", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] sub = (JSPUtil.getParameter(request, prefix	+ "sub", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] cfmCurrCd = (JSPUtil.getParameter(request, prefix	+ "cfm_curr_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TxsBkgListForAuditVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (trsBkgNo[i] != null)
					model.setTrsBkgNo(trsBkgNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (triAxlFlg[i] != null)
					model.setTriAxlFlg(triAxlFlg[i]);
				if (woRmk[i] != null)
					model.setWoRmk(woRmk[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (tpbBkgNo[i] != null)
					model.setTpbBkgNo(tpbBkgNo[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (sub[i] != null)
					model.setSub(sub[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (cfmCurrCd[i] != null)
					model.setCfmCurrCd(cfmCurrCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTxsBkgListForAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchBkgStatusVO[]
	 */
	public TxsBkgListForAuditVO[] getTxsBkgListForAuditVOs(){
		TxsBkgListForAuditVO[] vos = (TxsBkgListForAuditVO[])models.toArray(new TxsBkgListForAuditVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsBkgNo = this.trsBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAxlFlg = this.triAxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woRmk = this.woRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbBkgNo = this.tpbBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sub = this.sub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCurrCd = this.cfmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
