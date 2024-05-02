/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostCreatVO.java
*@FileTitle : PayableRentalCostCreatVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.25 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableRentalCostCreatVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableRentalCostCreatVO> models = new ArrayList<PayableRentalCostCreatVO>();
	
	/* Column Info */
	private String agmtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String payRntlCostAmt = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String lseCtrtNo = null;
	/* Column Info */
	private String agmtLstVerSeq = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String chgStsCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String hjsTtlChgAmt = null;
	/* Column Info */
	private String crTtlAmt = null;
	/* Column Info */
	private String invTtlChgAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String invFilFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ifRgstNo = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String invEffDt = null;
	/* Column Info */
	private String offcCd = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String vndrTermNm = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String payVndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayableRentalCostCreatVO() {}

	public PayableRentalCostCreatVO(String ibflag, String pagerows, String chgStsCd, String agmtNo, String agmtLstVerSeq, String lstmCd, String refNo
			                      , String effDt, String expDt, String invNo, String lseCtrtNo, String hjsTtlChgAmt, String invTtlChgAmt, String crTtlAmt
			                      , String payRntlCostAmt, String currCd, String agmtCtyCd, String agmtSeq, String chgSeq, String invFilFlg, String creDt
			                      , String creUsrId, String ifRgstNo, String invRcvDt, String invIssDt, String invEffDt, String offcCd, String invRmk
			                      , String vndrTermNm, String invOfcCd, String costOfcCd, String payVndrSeq) {
		this.agmtNo = agmtNo;
		this.pagerows = pagerows;
		this.payRntlCostAmt = payRntlCostAmt;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.lseCtrtNo = lseCtrtNo;
		this.agmtLstVerSeq = agmtLstVerSeq;
		this.refNo = refNo;
		this.chgStsCd = chgStsCd;
		this.expDt = expDt;
		this.lstmCd = lstmCd;
		this.hjsTtlChgAmt = hjsTtlChgAmt;
		this.crTtlAmt = crTtlAmt;
		this.invTtlChgAmt = invTtlChgAmt;
		this.currCd = currCd;
		this.agmtCtyCd = agmtCtyCd;
		this.agmtSeq = agmtSeq;
		this.chgSeq = chgSeq;
		this.invFilFlg = invFilFlg;
		this.creDt= creDt;
		this.creUsrId = creUsrId;
		this.ifRgstNo = ifRgstNo;
		this.invRcvDt = invRcvDt;
		this.invIssDt = invIssDt;
		this.invEffDt = invEffDt;
		this.offcCd = offcCd;
		this.invRmk = invRmk;
		this.vndrTermNm = vndrTermNm;
		this.invOfcCd = invOfcCd;
		this.costOfcCd = costOfcCd;
		this.payVndrSeq = payVndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pay_rntl_cost_amt", getPayRntlCostAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());
		this.hashColumns.put("agmt_lst_ver_seq", getAgmtLstVerSeq());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("chg_sts_cd", getChgStsCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("hjs_ttl_chg_amt", getHjsTtlChgAmt());
		this.hashColumns.put("cr_ttl_amt", getCrTtlAmt());
		this.hashColumns.put("inv_ttl_chg_amt", getInvTtlChgAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("inv_fil_flg", getInvFilFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("if_rgst_no", getIfRgstNo());
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("inv_eff_dt", getInvEffDt());
		this.hashColumns.put("offc_cd", getOffcCd());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("pay_vndr_seq", getPayVndrSeq());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_rntl_cost_amt", "payRntlCostAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("agmt_lst_ver_seq", "agmtLstVerSeq");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("chg_sts_cd", "chgStsCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("hjs_ttl_chg_amt", "hjsTtlChgAmt");
		this.hashFields.put("cr_ttl_amt", "crTtlAmt");
		this.hashFields.put("inv_ttl_chg_amt", "invTtlChgAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_fil_flg", "invFilFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("if_rgst_no", "ifRgstNo");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("inv_eff_dt", "invEffDt");
		this.hashFields.put("offc_cd", "offcCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("pay_vndr_seq", "payVndrSeq");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return payRntlCostAmt
	 */
	public String getPayRntlCostAmt() {
		return this.payRntlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return lseCtrtNo
	 */
	public String getLseCtrtNo() {
		return this.lseCtrtNo;
	}
	
	/**
	 * Column Info
	 * @return agmtLstVerSeq
	 */
	public String getAgmtLstVerSeq() {
		return this.agmtLstVerSeq;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return chgStsCd
	 */
	public String getChgStsCd() {
		return this.chgStsCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return hjsTtlChgAmt
	 */
	public String getHjsTtlChgAmt() {
		return this.hjsTtlChgAmt;
	}
	
	/**
	 * Column Info
	 * @return crTtlAmt
	 */
	public String getCrTtlAmt() {
		return this.crTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invTtlChgAmt
	 */
	public String getInvTtlChgAmt() {
		return this.invTtlChgAmt;
	}
	

	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param payRntlCostAmt
	 */
	public void setPayRntlCostAmt(String payRntlCostAmt) {
		this.payRntlCostAmt = payRntlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param lseCtrtNo
	 */
	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
	}
	
	/**
	 * Column Info
	 * @param agmtLstVerSeq
	 */
	public void setAgmtLstVerSeq(String agmtLstVerSeq) {
		this.agmtLstVerSeq = agmtLstVerSeq;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param chgStsCd
	 */
	public void setChgStsCd(String chgStsCd) {
		this.chgStsCd = chgStsCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param hjsTtlChgAmt
	 */
	public void setHjsTtlChgAmt(String hjsTtlChgAmt) {
		this.hjsTtlChgAmt = hjsTtlChgAmt;
	}
	
	/**
	 * Column Info
	 * @param crTtlAmt
	 */
	public void setCrTtlAmt(String crTtlAmt) {
		this.crTtlAmt = crTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invTtlChgAmt
	 */
	public void setInvTtlChgAmt(String invTtlChgAmt) {
		this.invTtlChgAmt = invTtlChgAmt;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	public String getAgmtSeq() {
		return agmtSeq;
	}

	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}

	public String getChgSeq() {
		return chgSeq;
	}

	public void setInvFilFlg(String invFilFlg) {
		this.invFilFlg = invFilFlg;
	}

	public String getInvFilFlg() {
		return invFilFlg;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setIfRgstNo(String ifRgstNo) {
		this.ifRgstNo = ifRgstNo;
	}

	public String getIfRgstNo() {
		return ifRgstNo;
	}

	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
	}

	public String getInvRcvDt() {
		return invRcvDt;
	}

	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
	}

	public String getInvIssDt() {
		return invIssDt;
	}

	public void setInvEffDt(String invEffDt) {
		this.invEffDt = invEffDt;
	}

	public String getInvEffDt() {
		return invEffDt;
	}

	public void setOffcCd(String offcCd) {
		this.offcCd = offcCd;
	}

	public String getOffcCd() {
		return offcCd;
	}

	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}

	public String getInvRmk() {
		return invRmk;
	}

	public void setVndrTermNm(String vndrTermNm) {
		this.vndrTermNm = vndrTermNm;
	}

	public String getVndrTermNm() {
		return vndrTermNm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPayRntlCostAmt(JSPUtil.getParameter(request, "pay_rntl_cost_amt", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setLseCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
		setAgmtLstVerSeq(JSPUtil.getParameter(request, "agmt_lst_ver_seq", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setChgStsCd(JSPUtil.getParameter(request, "chg_sts_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setHjsTtlChgAmt(JSPUtil.getParameter(request, "hjs_ttl_chg_amt", ""));
		setCrTtlAmt(JSPUtil.getParameter(request, "cr_ttl_amt", ""));
		setInvTtlChgAmt(JSPUtil.getParameter(request, "inv_ttl_chg_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setInvFilFlg(JSPUtil.getParameter(request, "inv_fil_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIfRgstNo(JSPUtil.getParameter(request, "if_rgst_no", ""));
		setInvRcvDt(JSPUtil.getParameter(request, "inv_rcv_dt", ""));
		setInvIssDt(JSPUtil.getParameter(request, "inv_iss_dt", ""));
		setInvEffDt(JSPUtil.getParameter(request, "inv_eff_dt", ""));
		setOffcCd(JSPUtil.getParameter(request, "offc_cd", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setVndrTermNm(JSPUtil.getParameter(request, "vndr_term_nm", ""));
		setInvOfcCd(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setPayVndrSeq(JSPUtil.getParameter(request, "pay_vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableRentalCostCreationVO[]
	 */
	public PayableRentalCostCreatVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableRentalCostCreationVO[]
	 */
	public PayableRentalCostCreatVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableRentalCostCreatVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] payRntlCostAmt = (JSPUtil.getParameter(request, prefix	+ "pay_rntl_cost_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] lseCtrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no", length));
			String[] agmtLstVerSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_lst_ver_seq", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] chgStsCd = (JSPUtil.getParameter(request, prefix	+ "chg_sts_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] hjsTtlChgAmt = (JSPUtil.getParameter(request, prefix	+ "hjs_ttl_chg_amt", length));
			String[] crTtlAmt = (JSPUtil.getParameter(request, prefix	+ "cr_ttl_amt", length));
			String[] invTtlChgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_chg_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] invFilFlg = (JSPUtil.getParameter(request, prefix	+ "inv_fil_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ifRgstNo = (JSPUtil.getParameter(request, prefix	+ "if_rgst_no", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] invEffDt = (JSPUtil.getParameter(request, prefix	+ "inv_eff_dt", length));
			String[] offcCd = (JSPUtil.getParameter(request, prefix	+ "offc_cd", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] vndrTermNm = (JSPUtil.getParameter(request, prefix	+ "vndr_term_nm", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] payVndrSeq = (JSPUtil.getParameter(request, prefix	+ "pay_vndr_seq", length));

			for (int i = 0; i < length; i++) {
				model = new PayableRentalCostCreatVO();
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (payRntlCostAmt[i] != null)
					model.setPayRntlCostAmt(payRntlCostAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (lseCtrtNo[i] != null)
					model.setLseCtrtNo(lseCtrtNo[i]);
				if (agmtLstVerSeq[i] != null)
					model.setAgmtLstVerSeq(agmtLstVerSeq[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (chgStsCd[i] != null)
					model.setChgStsCd(chgStsCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (hjsTtlChgAmt[i] != null)
					model.setHjsTtlChgAmt(hjsTtlChgAmt[i]);
				if (crTtlAmt[i] != null)
					model.setCrTtlAmt(crTtlAmt[i]);
				if (invTtlChgAmt[i] != null)
					model.setInvTtlChgAmt(invTtlChgAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (invFilFlg[i] != null)
					model.setInvFilFlg(invFilFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ifRgstNo[i] != null)
					model.setIfRgstNo(ifRgstNo[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (invEffDt[i] != null)
					model.setInvEffDt(invEffDt[i]);
				if (offcCd[i] != null)
					model.setOffcCd(offcCd[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (vndrTermNm[i] != null)
					model.setVndrTermNm(vndrTermNm[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (payVndrSeq[i] != null)
					model.setPayVndrSeq(payVndrSeq[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableRentalCostCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableRentalCostCreationVO[]
	 */
	public PayableRentalCostCreatVO[] getPayableRentalCostCreationVOs(){
		PayableRentalCostCreatVO[] vos = (PayableRentalCostCreatVO[])models.toArray(new PayableRentalCostCreatVO[models.size()]);
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
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRntlCostAmt = this.payRntlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo = this.lseCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstVerSeq = this.agmtLstVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgStsCd = this.chgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsTtlChgAmt = this.hjsTtlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTtlAmt = this.crTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlChgAmt = this.invTtlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFilFlg = this.invFilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRgstNo = this.ifRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffDt = this.invEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offcCd = this.offcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm = this.vndrTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVndrSeq = this.payVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}

	public String getInvOfcCd() {
		return invOfcCd;
	}

	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}

	public String getCostOfcCd() {
		return costOfcCd;
	}

	public void setPayVndrSeq(String payVndrSeq) {
		this.payVndrSeq = payVndrSeq;
	}

	public String getPayVndrSeq() {
		return payVndrSeq;
	}
}