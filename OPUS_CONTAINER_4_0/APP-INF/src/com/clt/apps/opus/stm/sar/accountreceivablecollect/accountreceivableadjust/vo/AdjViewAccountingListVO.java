/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjViewAccountingListVO.java
*@FileTitle : AdjViewAccountingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class AdjViewAccountingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjViewAccountingListVO> models = new ArrayList<AdjViewAccountingListVO>();
	
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String inpDrAmt = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convXchRt = null;
	/* Column Info */
	private String acctXchRtDt = null;
	/* Column Info */
	private String acctDrAmt = null;
	/* Column Info */
	private String adjNo = null;
	/* Column Info */
	private String adjTpCd = null;
	/* Column Info */
	private String acctCrAmt = null;
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String dtrbSrcTpCd = null;
	/* Column Info */
	private String actionType = null;
	/* Column Info */
	private String adjStsCd = null;
	/* Column Info */
	private String inpCrAmt = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String sgmCtnt2 = null;
	/* Column Info */
	private String sgmCtnt3 = null;
	/* Column Info */
	private String sgmCtnt1 = null;
	/* Column Info */
	private String sgmCtnt6 = null;
	/* Column Info */
	private String sgmCtnt4 = null;
	/* Column Info */
	private String sgmCtnt5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdjViewAccountingListVO() {}

	public AdjViewAccountingListVO(String ibflag, String pagerows, String glDt, String inpDrAmt, String ifNo, String chgTpCd, String currCd, String dtrbSrcTpCd, String actionType, String adjStsCd, String inpCrAmt, String blNo, String otsOfcCd, String convXchRt, String acctXchRtDt, String sgmCtnt2, String sgmCtnt3, String acctDrAmt, String adjNo, String sgmCtnt1, String sgmCtnt6, String sgmCtnt4, String sgmCtnt5, String acctCrAmt, String adjTpCd) {
		this.chgTpCd = chgTpCd;
		this.inpDrAmt = inpDrAmt;
		this.glDt = glDt;
		this.currCd = currCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.convXchRt = convXchRt;
		this.acctXchRtDt = acctXchRtDt;
		this.acctDrAmt = acctDrAmt;
		this.adjNo = adjNo;
		this.adjTpCd = adjTpCd;
		this.acctCrAmt = acctCrAmt;
		this.ifNo = ifNo;
		this.dtrbSrcTpCd = dtrbSrcTpCd;
		this.actionType = actionType;
		this.adjStsCd = adjStsCd;
		this.inpCrAmt = inpCrAmt;
		this.otsOfcCd = otsOfcCd;
		this.sgmCtnt2 = sgmCtnt2;
		this.sgmCtnt3 = sgmCtnt3;
		this.sgmCtnt1 = sgmCtnt1;
		this.sgmCtnt6 = sgmCtnt6;
		this.sgmCtnt4 = sgmCtnt4;
		this.sgmCtnt5 = sgmCtnt5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_xch_rt", getConvXchRt());
		this.hashColumns.put("acct_xch_rt_dt", getAcctXchRtDt());
		this.hashColumns.put("acct_dr_amt", getAcctDrAmt());
		this.hashColumns.put("adj_no", getAdjNo());
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());
		this.hashColumns.put("acct_cr_amt", getAcctCrAmt());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("dtrb_src_tp_cd", getDtrbSrcTpCd());
		this.hashColumns.put("action_type", getActionType());
		this.hashColumns.put("adj_sts_cd", getAdjStsCd());
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("sgm_ctnt2", getSgmCtnt2());
		this.hashColumns.put("sgm_ctnt3", getSgmCtnt3());
		this.hashColumns.put("sgm_ctnt1", getSgmCtnt1());
		this.hashColumns.put("sgm_ctnt6", getSgmCtnt6());
		this.hashColumns.put("sgm_ctnt4", getSgmCtnt4());
		this.hashColumns.put("sgm_ctnt5", getSgmCtnt5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_xch_rt", "convXchRt");
		this.hashFields.put("acct_xch_rt_dt", "acctXchRtDt");
		this.hashFields.put("acct_dr_amt", "acctDrAmt");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("acct_cr_amt", "acctCrAmt");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("dtrb_src_tp_cd", "dtrbSrcTpCd");
		this.hashFields.put("action_type", "actionType");
		this.hashFields.put("adj_sts_cd", "adjStsCd");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("sgm_ctnt2", "sgmCtnt2");
		this.hashFields.put("sgm_ctnt3", "sgmCtnt3");
		this.hashFields.put("sgm_ctnt1", "sgmCtnt1");
		this.hashFields.put("sgm_ctnt6", "sgmCtnt6");
		this.hashFields.put("sgm_ctnt4", "sgmCtnt4");
		this.hashFields.put("sgm_ctnt5", "sgmCtnt5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
	}
	
	/**
	 * Column Info
	 * @return inpDrAmt
	 */
	public String getInpDrAmt() {
		return this.inpDrAmt;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return convXchRt
	 */
	public String getConvXchRt() {
		return this.convXchRt;
	}
	
	/**
	 * Column Info
	 * @return acctXchRtDt
	 */
	public String getAcctXchRtDt() {
		return this.acctXchRtDt;
	}
	
	/**
	 * Column Info
	 * @return acctDrAmt
	 */
	public String getAcctDrAmt() {
		return this.acctDrAmt;
	}
	
	/**
	 * Column Info
	 * @return adjNo
	 */
	public String getAdjNo() {
		return this.adjNo;
	}
	
	/**
	 * Column Info
	 * @return adjTpCd
	 */
	public String getAdjTpCd() {
		return this.adjTpCd;
	}
	
	/**
	 * Column Info
	 * @return acctCrAmt
	 */
	public String getAcctCrAmt() {
		return this.acctCrAmt;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
	}
	
	/**
	 * Column Info
	 * @return dtrbSrcTpCd
	 */
	public String getDtrbSrcTpCd() {
		return this.dtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return actionType
	 */
	public String getActionType() {
		return this.actionType;
	}
	
	/**
	 * Column Info
	 * @return adjStsCd
	 */
	public String getAdjStsCd() {
		return this.adjStsCd;
	}
	
	/**
	 * Column Info
	 * @return inpCrAmt
	 */
	public String getInpCrAmt() {
		return this.inpCrAmt;
	}
	
	/**
	 * Column Info
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt2
	 */
	public String getSgmCtnt2() {
		return this.sgmCtnt2;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt3
	 */
	public String getSgmCtnt3() {
		return this.sgmCtnt3;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt1
	 */
	public String getSgmCtnt1() {
		return this.sgmCtnt1;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt6
	 */
	public String getSgmCtnt6() {
		return this.sgmCtnt6;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt4
	 */
	public String getSgmCtnt4() {
		return this.sgmCtnt4;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt5
	 */
	public String getSgmCtnt5() {
		return this.sgmCtnt5;
	}
	

	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
	}
	
	/**
	 * Column Info
	 * @param inpDrAmt
	 */
	public void setInpDrAmt(String inpDrAmt) {
		this.inpDrAmt = inpDrAmt;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param convXchRt
	 */
	public void setConvXchRt(String convXchRt) {
		this.convXchRt = convXchRt;
	}
	
	/**
	 * Column Info
	 * @param acctXchRtDt
	 */
	public void setAcctXchRtDt(String acctXchRtDt) {
		this.acctXchRtDt = acctXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param acctDrAmt
	 */
	public void setAcctDrAmt(String acctDrAmt) {
		this.acctDrAmt = acctDrAmt;
	}
	
	/**
	 * Column Info
	 * @param adjNo
	 */
	public void setAdjNo(String adjNo) {
		this.adjNo = adjNo;
	}
	
	/**
	 * Column Info
	 * @param adjTpCd
	 */
	public void setAdjTpCd(String adjTpCd) {
		this.adjTpCd = adjTpCd;
	}
	
	/**
	 * Column Info
	 * @param acctCrAmt
	 */
	public void setAcctCrAmt(String acctCrAmt) {
		this.acctCrAmt = acctCrAmt;
	}
	
	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}
	
	/**
	 * Column Info
	 * @param dtrbSrcTpCd
	 */
	public void setDtrbSrcTpCd(String dtrbSrcTpCd) {
		this.dtrbSrcTpCd = dtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param actionType
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	/**
	 * Column Info
	 * @param adjStsCd
	 */
	public void setAdjStsCd(String adjStsCd) {
		this.adjStsCd = adjStsCd;
	}
	
	/**
	 * Column Info
	 * @param inpCrAmt
	 */
	public void setInpCrAmt(String inpCrAmt) {
		this.inpCrAmt = inpCrAmt;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt2
	 */
	public void setSgmCtnt2(String sgmCtnt2) {
		this.sgmCtnt2 = sgmCtnt2;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt3
	 */
	public void setSgmCtnt3(String sgmCtnt3) {
		this.sgmCtnt3 = sgmCtnt3;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt1
	 */
	public void setSgmCtnt1(String sgmCtnt1) {
		this.sgmCtnt1 = sgmCtnt1;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt6
	 */
	public void setSgmCtnt6(String sgmCtnt6) {
		this.sgmCtnt6 = sgmCtnt6;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt4
	 */
	public void setSgmCtnt4(String sgmCtnt4) {
		this.sgmCtnt4 = sgmCtnt4;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt5
	 */
	public void setSgmCtnt5(String sgmCtnt5) {
		this.sgmCtnt5 = sgmCtnt5;
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
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setInpDrAmt(JSPUtil.getParameter(request, prefix + "inp_dr_amt", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setConvXchRt(JSPUtil.getParameter(request, prefix + "conv_xch_rt", ""));
		setAcctXchRtDt(JSPUtil.getParameter(request, prefix + "acct_xch_rt_dt", ""));
		setAcctDrAmt(JSPUtil.getParameter(request, prefix + "acct_dr_amt", ""));
		setAdjNo(JSPUtil.getParameter(request, prefix + "adj_no", ""));
		setAdjTpCd(JSPUtil.getParameter(request, prefix + "adj_tp_cd", ""));
		setAcctCrAmt(JSPUtil.getParameter(request, prefix + "acct_cr_amt", ""));
		setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
		setDtrbSrcTpCd(JSPUtil.getParameter(request, prefix + "dtrb_src_tp_cd", ""));
		setActionType(JSPUtil.getParameter(request, prefix + "action_type", ""));
		setAdjStsCd(JSPUtil.getParameter(request, prefix + "adj_sts_cd", ""));
		setInpCrAmt(JSPUtil.getParameter(request, prefix + "inp_cr_amt", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setSgmCtnt2(JSPUtil.getParameter(request, prefix + "sgm_ctnt2", ""));
		setSgmCtnt3(JSPUtil.getParameter(request, prefix + "sgm_ctnt3", ""));
		setSgmCtnt1(JSPUtil.getParameter(request, prefix + "sgm_ctnt1", ""));
		setSgmCtnt6(JSPUtil.getParameter(request, prefix + "sgm_ctnt6", ""));
		setSgmCtnt4(JSPUtil.getParameter(request, prefix + "sgm_ctnt4", ""));
		setSgmCtnt5(JSPUtil.getParameter(request, prefix + "sgm_ctnt5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjViewAccountingListVO[]
	 */
	public AdjViewAccountingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjViewAccountingListVO[]
	 */
	public AdjViewAccountingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjViewAccountingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] inpDrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_dr_amt", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convXchRt = (JSPUtil.getParameter(request, prefix	+ "conv_xch_rt", length));
			String[] acctXchRtDt = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_dt", length));
			String[] acctDrAmt = (JSPUtil.getParameter(request, prefix	+ "acct_dr_amt", length));
			String[] adjNo = (JSPUtil.getParameter(request, prefix	+ "adj_no", length));
			String[] adjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tp_cd", length));
			String[] acctCrAmt = (JSPUtil.getParameter(request, prefix	+ "acct_cr_amt", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] dtrbSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_tp_cd", length));
			String[] actionType = (JSPUtil.getParameter(request, prefix	+ "action_type", length));
			String[] adjStsCd = (JSPUtil.getParameter(request, prefix	+ "adj_sts_cd", length));
			String[] inpCrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_cr_amt", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] sgmCtnt2 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt2", length));
			String[] sgmCtnt3 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt3", length));
			String[] sgmCtnt1 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt1", length));
			String[] sgmCtnt6 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt6", length));
			String[] sgmCtnt4 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt4", length));
			String[] sgmCtnt5 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt5", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjViewAccountingListVO();
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (inpDrAmt[i] != null)
					model.setInpDrAmt(inpDrAmt[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convXchRt[i] != null)
					model.setConvXchRt(convXchRt[i]);
				if (acctXchRtDt[i] != null)
					model.setAcctXchRtDt(acctXchRtDt[i]);
				if (acctDrAmt[i] != null)
					model.setAcctDrAmt(acctDrAmt[i]);
				if (adjNo[i] != null)
					model.setAdjNo(adjNo[i]);
				if (adjTpCd[i] != null)
					model.setAdjTpCd(adjTpCd[i]);
				if (acctCrAmt[i] != null)
					model.setAcctCrAmt(acctCrAmt[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (dtrbSrcTpCd[i] != null)
					model.setDtrbSrcTpCd(dtrbSrcTpCd[i]);
				if (actionType[i] != null)
					model.setActionType(actionType[i]);
				if (adjStsCd[i] != null)
					model.setAdjStsCd(adjStsCd[i]);
				if (inpCrAmt[i] != null)
					model.setInpCrAmt(inpCrAmt[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (sgmCtnt2[i] != null)
					model.setSgmCtnt2(sgmCtnt2[i]);
				if (sgmCtnt3[i] != null)
					model.setSgmCtnt3(sgmCtnt3[i]);
				if (sgmCtnt1[i] != null)
					model.setSgmCtnt1(sgmCtnt1[i]);
				if (sgmCtnt6[i] != null)
					model.setSgmCtnt6(sgmCtnt6[i]);
				if (sgmCtnt4[i] != null)
					model.setSgmCtnt4(sgmCtnt4[i]);
				if (sgmCtnt5[i] != null)
					model.setSgmCtnt5(sgmCtnt5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjViewAccountingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjViewAccountingListVO[]
	 */
	public AdjViewAccountingListVO[] getAdjViewAccountingListVOs(){
		AdjViewAccountingListVO[] vos = (AdjViewAccountingListVO[])models.toArray(new AdjViewAccountingListVO[models.size()]);
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
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDrAmt = this.inpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRt = this.convXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtDt = this.acctXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDrAmt = this.acctDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo = this.adjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd = this.adjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCrAmt = this.acctCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTpCd = this.dtrbSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionType = this.actionType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjStsCd = this.adjStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt = this.inpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt2 = this.sgmCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt3 = this.sgmCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt1 = this.sgmCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt6 = this.sgmCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt4 = this.sgmCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt5 = this.sgmCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
