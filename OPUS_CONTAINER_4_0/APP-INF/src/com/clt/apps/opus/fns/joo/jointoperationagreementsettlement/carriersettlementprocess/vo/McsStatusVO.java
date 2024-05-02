/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : McsStatusVO.java
*@FileTitle : McsStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.10.26 김영오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class McsStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<McsStatusVO> models = new ArrayList<McsStatusVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String joSmryRmk = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String benefitLine = null;
	/* Column Info */
	private String joBalance = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Column Info */
	private String joExp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String joRev = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String vvdChk = null;
	/* Column Info */
	private String usdamountChk = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String viewFlag = null;
	/* Column Info */
	private String combinedChk = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String summarydetail = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public McsStatusVO() {}

	public McsStatusVO(String ibflag, String pagerows, String fromDt, String joSmryRmk, String trdCd, String benefitLine, String rlaneCd, String joBalance, String joExp, String joStlItmCd, String effDt, String joRev, String revYrmon, String loclCurrCd, String joCrrCd, String vvdChk, String usdamountChk, String toDt, String vvd, String ofcCd, String acctYrmon, String creUsrId, String viewFlag, String combinedChk, String stlCmbSeq, String summarydetail) {
		this.fromDt = fromDt;
		this.joSmryRmk = joSmryRmk;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.benefitLine = benefitLine;
		this.joBalance = joBalance;
		this.joStlItmCd = joStlItmCd;
		this.joExp = joExp;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.joRev = joRev;
		this.revYrmon = revYrmon;
		this.loclCurrCd = loclCurrCd;
		this.joCrrCd = joCrrCd;
		this.vvdChk = vvdChk;
		this.usdamountChk = usdamountChk;
		this.toDt = toDt;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.acctYrmon = acctYrmon;
		this.creUsrId = creUsrId;
		this.viewFlag = viewFlag;
		this.combinedChk = combinedChk;
		this.stlCmbSeq = stlCmbSeq;
		this.summarydetail = summarydetail;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("jo_smry_rmk", getJoSmryRmk());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("benefit_line", getBenefitLine());
		this.hashColumns.put("jo_balance", getJoBalance());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("jo_exp", getJoExp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_rev", getJoRev());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("vvd_chk", getVvdChk());
		this.hashColumns.put("usdamount_chk", getUsdamountChk());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("view_flag", getViewFlag());
		this.hashColumns.put("combined_chk", getCombinedChk());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("summarydetail", getSummarydetail());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("jo_smry_rmk", "joSmryRmk");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("benefit_line", "benefitLine");
		this.hashFields.put("jo_balance", "joBalance");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("jo_exp", "joExp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_rev", "joRev");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("vvd_chk", "vvdChk");
		this.hashFields.put("usdamount_chk", "usdamountChk");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("view_flag", "viewFlag");
		this.hashFields.put("combined_chk", "combinedChk");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("summarydetail", "summarydetail");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return joSmryRmk
	 */
	public String getJoSmryRmk() {
		return this.joSmryRmk;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return benefitLine
	 */
	public String getBenefitLine() {
		return this.benefitLine;
	}
	
	/**
	 * Column Info
	 * @return joBalance
	 */
	public String getJoBalance() {
		return this.joBalance;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
	}
	
	/**
	 * Column Info
	 * @return joExp
	 */
	public String getJoExp() {
		return this.joExp;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return joRev
	 */
	public String getJoRev() {
		return this.joRev;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return vvdChk
	 */
	public String getVvdChk() {
		return this.vvdChk;
	}
	
	/**
	 * Column Info
	 * @return usdamountChk
	 */
	public String getUsdamountChk() {
		return this.usdamountChk;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
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
	 * @return viewFlag
	 */
	public String getViewFlag() {
		return this.viewFlag;
	}
	
	/**
	 * Column Info
	 * @return combinedChk
	 */
	public String getCombinedChk() {
		return this.combinedChk;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return summarydetail
	 */
	public String getSummarydetail() {
		return this.summarydetail;
	}

		
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param joSmryRmk
	 */
	public void setJoSmryRmk(String joSmryRmk) {
		this.joSmryRmk = joSmryRmk;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param benefitLine
	 */
	public void setBenefitLine(String benefitLine) {
		this.benefitLine = benefitLine;
	}
	
	/**
	 * Column Info
	 * @param joBalance
	 */
	public void setJoBalance(String joBalance) {
		this.joBalance = joBalance;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
	}
	
	/**
	 * Column Info
	 * @param joExp
	 */
	public void setJoExp(String joExp) {
		this.joExp = joExp;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param joRev
	 */
	public void setJoRev(String joRev) {
		this.joRev = joRev;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param vvdChk
	 */
	public void setVvdChk(String vvdChk) {
		this.vvdChk = vvdChk;
	}
	
	/**
	 * Column Info
	 * @param usdamountChk
	 */
	public void setUsdamountChk(String usdamountChk) {
		this.usdamountChk = usdamountChk;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
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
	 * @param viewFlag
	 */
	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}
	
	/**
	 * Column Info
	 * @param combinedChk
	 */
	public void setCombinedChk(String combinedChk) {
		this.combinedChk = combinedChk;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	
	/**
	 * Column Info
	 * @param summarydetail
	 */
	public void setSummarydetail(String summarydetail) {
		this.summarydetail = summarydetail;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setJoSmryRmk(JSPUtil.getParameter(request, prefix + "jo_smry_rmk", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBenefitLine(JSPUtil.getParameter(request, prefix + "benefit_line", ""));
		setJoBalance(JSPUtil.getParameter(request, prefix + "jo_balance", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
		setJoExp(JSPUtil.getParameter(request, prefix + "jo_exp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setJoRev(JSPUtil.getParameter(request, prefix + "jo_rev", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setVvdChk(JSPUtil.getParameter(request, prefix + "vvd_chk", ""));
		setUsdamountChk(JSPUtil.getParameter(request, prefix + "usdamount_chk", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setViewFlag(JSPUtil.getParameter(request, prefix + "view_flag", ""));
		setCombinedChk(JSPUtil.getParameter(request, prefix + "combined_chk", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, prefix + "stl_cmb_seq", ""));
		setSummarydetail(JSPUtil.getParameter(request, prefix + "summarydetail", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return McsStatusVO[]
	 */
	public McsStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return McsStatusVO[]
	 */
	public McsStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		McsStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] joSmryRmk = (JSPUtil.getParameter(request, prefix	+ "jo_smry_rmk", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] benefitLine = (JSPUtil.getParameter(request, prefix	+ "benefit_line", length));
			String[] joBalance = (JSPUtil.getParameter(request, prefix	+ "jo_balance", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] joExp = (JSPUtil.getParameter(request, prefix	+ "jo_exp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] joRev = (JSPUtil.getParameter(request, prefix	+ "jo_rev", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] vvdChk = (JSPUtil.getParameter(request, prefix	+ "vvd_chk", length));
			String[] usdamountChk = (JSPUtil.getParameter(request, prefix	+ "usdamount_chk", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] viewFlag = (JSPUtil.getParameter(request, prefix	+ "view_flag", length));
			String[] combinedChk = (JSPUtil.getParameter(request, prefix	+ "combined_chk", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] summarydetail = (JSPUtil.getParameter(request, prefix	+ "summarydetail", length));

			/* Add a field line, do not delete */
			for (int i = 0; i < length; i++) {
				model = new McsStatusVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (joSmryRmk[i] != null)
					model.setJoSmryRmk(joSmryRmk[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (benefitLine[i] != null)
					model.setBenefitLine(benefitLine[i]);
				if (joBalance[i] != null)
					model.setJoBalance(joBalance[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (joExp[i] != null)
					model.setJoExp(joExp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (joRev[i] != null)
					model.setJoRev(joRev[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (vvdChk[i] != null)
					model.setVvdChk(vvdChk[i]);
				if (usdamountChk[i] != null)
					model.setUsdamountChk(usdamountChk[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (viewFlag[i] != null)
					model.setViewFlag(viewFlag[i]);
				if (combinedChk[i] != null)
					model.setCombinedChk(combinedChk[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (summarydetail[i] != null)
					model.setSummarydetail(summarydetail[i]);
				/* Add a Method line, do not delete */
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMcsStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return McsStatusVO[]
	 */
	public McsStatusVO[] getMcsStatusVOs(){
		McsStatusVO[] vos = (McsStatusVO[])models.toArray(new McsStatusVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joSmryRmk = this.joSmryRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.benefitLine = this.benefitLine .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBalance = this.joBalance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joExp = this.joExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRev = this.joRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdChk = this.vvdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdamountChk = this.usdamountChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewFlag = this.viewFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combinedChk = this.combinedChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.summarydetail = this.summarydetail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
