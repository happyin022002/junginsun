/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptDistributionVO.java
*@FileTitle : ReceiptDistributionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class ReceiptDistributionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptDistributionVO> models = new ArrayList<ReceiptDistributionVO>();
	
	/* Column Info */
	private String inpDrAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dtrbSrcTblCd = null;
	/* Column Info */
	private String cltDtrbSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dtrbCdCmbSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acctXchRtLvl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmInpCrAmt = null;
	/* Column Info */
	private String convXchRt = null;
	/* Column Info */
	private String acctXchRtDt = null;
	/* Column Info */
	private String acctDrAmt = null;
	/* Column Info */
	private String fmAcctDrAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String acctCrAmt = null;
	/* Column Info */
	private String fmInpDrAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dtrbSrcTpCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String orzSeq = null;
	/* Column Info */
	private String inpCrAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmDtrbSrcSeq = null;
	/* Column Info */
	private String rvsSrcSeq = null;
	/* Column Info */
	private String fmAcctCrAmt = null;
	/* Column Info */
	private String dtrbSrcSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptDistributionVO() {}

	public ReceiptDistributionVO(String ibflag, String pagerows, String cltDtrbSeq, String dtrbSrcSeq, String dtrbSrcTblCd, String dtrbSrcTpCd, String dtrbCdCmbSeq, String inpDrAmt, String inpCrAmt, String acctDrAmt, String acctCrAmt, String orzSeq, String fmDtrbSrcSeq, String currCd, String convXchRt, String acctXchRtLvl, String acctXchRtDt, String custCntCd, String custSeq, String rvsSrcSeq, String fmInpDrAmt, String fmInpCrAmt, String fmAcctDrAmt, String fmAcctCrAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.inpDrAmt = inpDrAmt;
		this.currCd = currCd;
		this.dtrbSrcTblCd = dtrbSrcTblCd;
		this.cltDtrbSeq = cltDtrbSeq;
		this.creDt = creDt;
		this.dtrbCdCmbSeq = dtrbCdCmbSeq;
		this.pagerows = pagerows;
		this.acctXchRtLvl = acctXchRtLvl;
		this.ibflag = ibflag;
		this.fmInpCrAmt = fmInpCrAmt;
		this.convXchRt = convXchRt;
		this.acctXchRtDt = acctXchRtDt;
		this.acctDrAmt = acctDrAmt;
		this.fmAcctDrAmt = fmAcctDrAmt;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.acctCrAmt = acctCrAmt;
		this.fmInpDrAmt = fmInpDrAmt;
		this.updDt = updDt;
		this.dtrbSrcTpCd = dtrbSrcTpCd;
		this.custSeq = custSeq;
		this.orzSeq = orzSeq;
		this.inpCrAmt = inpCrAmt;
		this.creUsrId = creUsrId;
		this.fmDtrbSrcSeq = fmDtrbSrcSeq;
		this.rvsSrcSeq = rvsSrcSeq;
		this.fmAcctCrAmt = fmAcctCrAmt;
		this.dtrbSrcSeq = dtrbSrcSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dtrb_src_tbl_cd", getDtrbSrcTblCd());
		this.hashColumns.put("clt_dtrb_seq", getCltDtrbSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dtrb_cd_cmb_seq", getDtrbCdCmbSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_xch_rt_lvl", getAcctXchRtLvl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_inp_cr_amt", getFmInpCrAmt());
		this.hashColumns.put("conv_xch_rt", getConvXchRt());
		this.hashColumns.put("acct_xch_rt_dt", getAcctXchRtDt());
		this.hashColumns.put("acct_dr_amt", getAcctDrAmt());
		this.hashColumns.put("fm_acct_dr_amt", getFmAcctDrAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("acct_cr_amt", getAcctCrAmt());
		this.hashColumns.put("fm_inp_dr_amt", getFmInpDrAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dtrb_src_tp_cd", getDtrbSrcTpCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("orz_seq", getOrzSeq());
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_dtrb_src_seq", getFmDtrbSrcSeq());
		this.hashColumns.put("rvs_src_seq", getRvsSrcSeq());
		this.hashColumns.put("fm_acct_cr_amt", getFmAcctCrAmt());
		this.hashColumns.put("dtrb_src_seq", getDtrbSrcSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dtrb_src_tbl_cd", "dtrbSrcTblCd");
		this.hashFields.put("clt_dtrb_seq", "cltDtrbSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dtrb_cd_cmb_seq", "dtrbCdCmbSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_xch_rt_lvl", "acctXchRtLvl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_inp_cr_amt", "fmInpCrAmt");
		this.hashFields.put("conv_xch_rt", "convXchRt");
		this.hashFields.put("acct_xch_rt_dt", "acctXchRtDt");
		this.hashFields.put("acct_dr_amt", "acctDrAmt");
		this.hashFields.put("fm_acct_dr_amt", "fmAcctDrAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("acct_cr_amt", "acctCrAmt");
		this.hashFields.put("fm_inp_dr_amt", "fmInpDrAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dtrb_src_tp_cd", "dtrbSrcTpCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("orz_seq", "orzSeq");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_dtrb_src_seq", "fmDtrbSrcSeq");
		this.hashFields.put("rvs_src_seq", "rvsSrcSeq");
		this.hashFields.put("fm_acct_cr_amt", "fmAcctCrAmt");
		this.hashFields.put("dtrb_src_seq", "dtrbSrcSeq");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbSrcTblCd
	 */
	public String getDtrbSrcTblCd() {
		return this.dtrbSrcTblCd;
	}
	
	/**
	 * Column Info
	 * @return cltDtrbSeq
	 */
	public String getCltDtrbSeq() {
		return this.cltDtrbSeq;
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
	 * @return dtrbCdCmbSeq
	 */
	public String getDtrbCdCmbSeq() {
		return this.dtrbCdCmbSeq;
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
	 * @return acctXchRtLvl
	 */
	public String getAcctXchRtLvl() {
		return this.acctXchRtLvl;
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
	 * @return fmInpCrAmt
	 */
	public String getFmInpCrAmt() {
		return this.fmInpCrAmt;
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
	 * @return fmAcctDrAmt
	 */
	public String getFmAcctDrAmt() {
		return this.fmAcctDrAmt;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return fmInpDrAmt
	 */
	public String getFmInpDrAmt() {
		return this.fmInpDrAmt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return orzSeq
	 */
	public String getOrzSeq() {
		return this.orzSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmDtrbSrcSeq
	 */
	public String getFmDtrbSrcSeq() {
		return this.fmDtrbSrcSeq;
	}
	
	/**
	 * Column Info
	 * @return rvsSrcSeq
	 */
	public String getRvsSrcSeq() {
		return this.rvsSrcSeq;
	}
	
	/**
	 * Column Info
	 * @return fmAcctCrAmt
	 */
	public String getFmAcctCrAmt() {
		return this.fmAcctCrAmt;
	}
	
	/**
	 * Column Info
	 * @return dtrbSrcSeq
	 */
	public String getDtrbSrcSeq() {
		return this.dtrbSrcSeq;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbSrcTblCd
	 */
	public void setDtrbSrcTblCd(String dtrbSrcTblCd) {
		this.dtrbSrcTblCd = dtrbSrcTblCd;
	}
	
	/**
	 * Column Info
	 * @param cltDtrbSeq
	 */
	public void setCltDtrbSeq(String cltDtrbSeq) {
		this.cltDtrbSeq = cltDtrbSeq;
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
	 * @param dtrbCdCmbSeq
	 */
	public void setDtrbCdCmbSeq(String dtrbCdCmbSeq) {
		this.dtrbCdCmbSeq = dtrbCdCmbSeq;
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
	 * @param acctXchRtLvl
	 */
	public void setAcctXchRtLvl(String acctXchRtLvl) {
		this.acctXchRtLvl = acctXchRtLvl;
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
	 * @param fmInpCrAmt
	 */
	public void setFmInpCrAmt(String fmInpCrAmt) {
		this.fmInpCrAmt = fmInpCrAmt;
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
	 * @param fmAcctDrAmt
	 */
	public void setFmAcctDrAmt(String fmAcctDrAmt) {
		this.fmAcctDrAmt = fmAcctDrAmt;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param fmInpDrAmt
	 */
	public void setFmInpDrAmt(String fmInpDrAmt) {
		this.fmInpDrAmt = fmInpDrAmt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param orzSeq
	 */
	public void setOrzSeq(String orzSeq) {
		this.orzSeq = orzSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmDtrbSrcSeq
	 */
	public void setFmDtrbSrcSeq(String fmDtrbSrcSeq) {
		this.fmDtrbSrcSeq = fmDtrbSrcSeq;
	}
	
	/**
	 * Column Info
	 * @param rvsSrcSeq
	 */
	public void setRvsSrcSeq(String rvsSrcSeq) {
		this.rvsSrcSeq = rvsSrcSeq;
	}
	
	/**
	 * Column Info
	 * @param fmAcctCrAmt
	 */
	public void setFmAcctCrAmt(String fmAcctCrAmt) {
		this.fmAcctCrAmt = fmAcctCrAmt;
	}
	
	/**
	 * Column Info
	 * @param dtrbSrcSeq
	 */
	public void setDtrbSrcSeq(String dtrbSrcSeq) {
		this.dtrbSrcSeq = dtrbSrcSeq;
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
		setInpDrAmt(JSPUtil.getParameter(request, prefix + "inp_dr_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDtrbSrcTblCd(JSPUtil.getParameter(request, prefix + "dtrb_src_tbl_cd", ""));
		setCltDtrbSeq(JSPUtil.getParameter(request, prefix + "clt_dtrb_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDtrbCdCmbSeq(JSPUtil.getParameter(request, prefix + "dtrb_cd_cmb_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAcctXchRtLvl(JSPUtil.getParameter(request, prefix + "acct_xch_rt_lvl", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmInpCrAmt(JSPUtil.getParameter(request, prefix + "fm_inp_cr_amt", ""));
		setConvXchRt(JSPUtil.getParameter(request, prefix + "conv_xch_rt", ""));
		setAcctXchRtDt(JSPUtil.getParameter(request, prefix + "acct_xch_rt_dt", ""));
		setAcctDrAmt(JSPUtil.getParameter(request, prefix + "acct_dr_amt", ""));
		setFmAcctDrAmt(JSPUtil.getParameter(request, prefix + "fm_acct_dr_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setAcctCrAmt(JSPUtil.getParameter(request, prefix + "acct_cr_amt", ""));
		setFmInpDrAmt(JSPUtil.getParameter(request, prefix + "fm_inp_dr_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDtrbSrcTpCd(JSPUtil.getParameter(request, prefix + "dtrb_src_tp_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOrzSeq(JSPUtil.getParameter(request, prefix + "orz_seq", ""));
		setInpCrAmt(JSPUtil.getParameter(request, prefix + "inp_cr_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFmDtrbSrcSeq(JSPUtil.getParameter(request, prefix + "fm_dtrb_src_seq", ""));
		setRvsSrcSeq(JSPUtil.getParameter(request, prefix + "rvs_src_seq", ""));
		setFmAcctCrAmt(JSPUtil.getParameter(request, prefix + "fm_acct_cr_amt", ""));
		setDtrbSrcSeq(JSPUtil.getParameter(request, prefix + "dtrb_src_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptDistributionVO[]
	 */
	public ReceiptDistributionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptDistributionVO[]
	 */
	public ReceiptDistributionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptDistributionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inpDrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_dr_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dtrbSrcTblCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_tbl_cd", length));
			String[] cltDtrbSeq = (JSPUtil.getParameter(request, prefix	+ "clt_dtrb_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dtrbCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "dtrb_cd_cmb_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acctXchRtLvl = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_lvl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmInpCrAmt = (JSPUtil.getParameter(request, prefix	+ "fm_inp_cr_amt", length));
			String[] convXchRt = (JSPUtil.getParameter(request, prefix	+ "conv_xch_rt", length));
			String[] acctXchRtDt = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_dt", length));
			String[] acctDrAmt = (JSPUtil.getParameter(request, prefix	+ "acct_dr_amt", length));
			String[] fmAcctDrAmt = (JSPUtil.getParameter(request, prefix	+ "fm_acct_dr_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] acctCrAmt = (JSPUtil.getParameter(request, prefix	+ "acct_cr_amt", length));
			String[] fmInpDrAmt = (JSPUtil.getParameter(request, prefix	+ "fm_inp_dr_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dtrbSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_tp_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] orzSeq = (JSPUtil.getParameter(request, prefix	+ "orz_seq", length));
			String[] inpCrAmt = (JSPUtil.getParameter(request, prefix	+ "inp_cr_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fmDtrbSrcSeq = (JSPUtil.getParameter(request, prefix	+ "fm_dtrb_src_seq", length));
			String[] rvsSrcSeq = (JSPUtil.getParameter(request, prefix	+ "rvs_src_seq", length));
			String[] fmAcctCrAmt = (JSPUtil.getParameter(request, prefix	+ "fm_acct_cr_amt", length));
			String[] dtrbSrcSeq = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptDistributionVO();
				if (inpDrAmt[i] != null)
					model.setInpDrAmt(inpDrAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dtrbSrcTblCd[i] != null)
					model.setDtrbSrcTblCd(dtrbSrcTblCd[i]);
				if (cltDtrbSeq[i] != null)
					model.setCltDtrbSeq(cltDtrbSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dtrbCdCmbSeq[i] != null)
					model.setDtrbCdCmbSeq(dtrbCdCmbSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acctXchRtLvl[i] != null)
					model.setAcctXchRtLvl(acctXchRtLvl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmInpCrAmt[i] != null)
					model.setFmInpCrAmt(fmInpCrAmt[i]);
				if (convXchRt[i] != null)
					model.setConvXchRt(convXchRt[i]);
				if (acctXchRtDt[i] != null)
					model.setAcctXchRtDt(acctXchRtDt[i]);
				if (acctDrAmt[i] != null)
					model.setAcctDrAmt(acctDrAmt[i]);
				if (fmAcctDrAmt[i] != null)
					model.setFmAcctDrAmt(fmAcctDrAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (acctCrAmt[i] != null)
					model.setAcctCrAmt(acctCrAmt[i]);
				if (fmInpDrAmt[i] != null)
					model.setFmInpDrAmt(fmInpDrAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dtrbSrcTpCd[i] != null)
					model.setDtrbSrcTpCd(dtrbSrcTpCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (orzSeq[i] != null)
					model.setOrzSeq(orzSeq[i]);
				if (inpCrAmt[i] != null)
					model.setInpCrAmt(inpCrAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmDtrbSrcSeq[i] != null)
					model.setFmDtrbSrcSeq(fmDtrbSrcSeq[i]);
				if (rvsSrcSeq[i] != null)
					model.setRvsSrcSeq(rvsSrcSeq[i]);
				if (fmAcctCrAmt[i] != null)
					model.setFmAcctCrAmt(fmAcctCrAmt[i]);
				if (dtrbSrcSeq[i] != null)
					model.setDtrbSrcSeq(dtrbSrcSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptDistributionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptDistributionVO[]
	 */
	public ReceiptDistributionVO[] getReceiptDistributionVOs(){
		ReceiptDistributionVO[] vos = (ReceiptDistributionVO[])models.toArray(new ReceiptDistributionVO[models.size()]);
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
		this.inpDrAmt = this.inpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTblCd = this.dtrbSrcTblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltDtrbSeq = this.cltDtrbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCdCmbSeq = this.dtrbCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtLvl = this.acctXchRtLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInpCrAmt = this.fmInpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRt = this.convXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtDt = this.acctXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDrAmt = this.acctDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAcctDrAmt = this.fmAcctDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCrAmt = this.acctCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInpDrAmt = this.fmInpDrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTpCd = this.dtrbSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orzSeq = this.orzSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt = this.inpCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDtrbSrcSeq = this.fmDtrbSrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsSrcSeq = this.rvsSrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAcctCrAmt = this.fmAcctCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcSeq = this.dtrbSrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
