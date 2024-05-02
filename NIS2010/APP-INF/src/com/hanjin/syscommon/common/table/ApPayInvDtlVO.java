/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApPayInvDtlVO.java
*@FileTitle : ApPayInvDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.09.29 함대성 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.15 김영철 [CHM-201006348-01] CSR 전표 Remark 보완 - INV_DESC 추가
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ApPayInvDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApPayInvDtlVO> models = new ArrayList<ApPayInvDtlVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invRgstSeq = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String so20ftQty = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String so40ftQty = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String soOfcCtyCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String soTeuQty = null;
	/* Column Info */
	private String soUtQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String actVvdCd = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String orgSoDtlSeq = null;
	/* Column Info */
	private String n3PtyBilIfFlg = null;
	/* Column Info */
	private String costCalcEffFmDt = null;	//2015.03.12	
	/* Column Info */
	private String costCalcEffToDt = null;	//2015.03.12


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ApPayInvDtlVO() {}

	public ApPayInvDtlVO(String ibflag, String pagerows, String invRgstNo, String invRgstSeq, String lgsCostCd, String acctCd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String slanCd, String actVvdCd, String portCd, String ydCd, String cntrTpszCd, String invAmt, String so20ftQty, String so40ftQty, String soTeuQty, String soUtQty, String soOfcCtyCd, String soSeq, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String invDesc, String orgSoDtlSeq, String n3PtyBilIfFlg, String costCalcEffFmDt,String costCalcEffToDt) {
		this.orgSoDtlSeq = orgSoDtlSeq;
		this.n3PtyBilIfFlg = n3PtyBilIfFlg;
		this.vslCd = vslCd;
		this.deltFlg = deltFlg;
		this.soSeq = soSeq;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.invRgstSeq = invRgstSeq;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.so20ftQty = so20ftQty;
		this.acctCd = acctCd;
		this.cntrTpszCd = cntrTpszCd;
		this.so40ftQty = so40ftQty;
		this.invAmt = invAmt;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.invRgstNo = invRgstNo;
		this.updDt = updDt;
		this.soOfcCtyCd = soOfcCtyCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.soTeuQty = soTeuQty;
		this.soUtQty = soUtQty;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.ydCd = ydCd;
		this.lgsCostCd = lgsCostCd;
		this.actVvdCd = actVvdCd;
		this.invDesc = invDesc;
		this.costCalcEffFmDt = costCalcEffFmDt;
		this.costCalcEffToDt = costCalcEffToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_rgst_seq", getInvRgstSeq());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("so_20ft_qty", getSo20ftQty());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("so_40ft_qty", getSo40ftQty());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("so_ofc_cty_cd", getSoOfcCtyCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("so_teu_qty", getSoTeuQty());
		this.hashColumns.put("so_ut_qty", getSoUtQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("act_vvd_cd", getActVvdCd());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("org_so_dtl_seq", getOrgSoDtlSeq());
		this.hashColumns.put("n3pty_bil_if_flg", getN3ptyBilIfFlg());
		this.hashColumns.put("cost_calc_eff_fm_dt", getCostCalcEffFmDt());
		this.hashColumns.put("cost_calc_eff_to_dt", getCostCalcEffToDt());
		
		return this.hashColumns;

	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_rgst_seq", "invRgstSeq");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("so_20ft_qty", "so20ftQty");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("so_40ft_qty", "so40ftQty");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("so_ofc_cty_cd", "soOfcCtyCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("so_teu_qty", "soTeuQty");
		this.hashFields.put("so_ut_qty", "soUtQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("act_vvd_cd", "actVvdCd");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("org_so_dtl_seq", "orgSoDtlSeq");
		this.hashFields.put("n3pty_bil_if_flg", "n3PtyBilIfFlg");
		this.hashFields.put("cost_calc_eff_fm_dt", "costCalcEffFmDt");
		this.hashFields.put("cost_calc_eff_to_dt", "costCalcEffToDt");
		
		return this.hashFields;

	}
	
	/**
	 * Column Info
	 * @return costCalcEffFmDt
	 */
	public String getCostCalcEffFmDt() {
		return this.costCalcEffFmDt;
	}
	
	/**
	 * Column Info
	 * @return costCalcEffToDt
	 */
	public String getCostCalcEffToDt() {
		return this.costCalcEffToDt;
	}
	/**
	 * Column Info
	 * @return orgSoDtlSeq
	 */
	public String getOrgSoDtlSeq() {
		return this.orgSoDtlSeq;
	}
	/**
	 * Column Info
	 * @return n3PtyBilIfFlg
	 */
	public String getN3ptyBilIfFlg() {
		return this.n3PtyBilIfFlg;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return invRgstSeq
	 */
	public String getInvRgstSeq() {
		return this.invRgstSeq;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return so20ftQty
	 */
	public String getSo20ftQty() {
		return this.so20ftQty;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return so40ftQty
	 */
	public String getSo40ftQty() {
		return this.so40ftQty;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return invRgstNo
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
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
	 * @return soOfcCtyCd
	 */
	public String getSoOfcCtyCd() {
		return this.soOfcCtyCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return soTeuQty
	 */
	public String getSoTeuQty() {
		return this.soTeuQty;
	}
	
	/**
	 * Column Info
	 * @return soUtQty
	 */
	public String getSoUtQty() {
		return this.soUtQty;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return actVvdCd
	 */
	public String getActVvdCd() {
		return this.actVvdCd;
	}
	
	/**
	 * Column Info
	 * @param orgSoDtlSeq
	 */
	public void setOrgSoDtlSeq(String orgSoDtlSeq) {
		this.orgSoDtlSeq = orgSoDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setN3ptyBilIfFlg(String n3PtyBilIfFlg) {
		this.n3PtyBilIfFlg = n3PtyBilIfFlg;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param invRgstSeq
	 */
	public void setInvRgstSeq(String invRgstSeq) {
		this.invRgstSeq = invRgstSeq;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param so20ftQty
	 */
	public void setSo20ftQty(String so20ftQty) {
		this.so20ftQty = so20ftQty;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param so40ftQty
	 */
	public void setSo40ftQty(String so40ftQty) {
		this.so40ftQty = so40ftQty;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
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
	 * @param soOfcCtyCd
	 */
	public void setSoOfcCtyCd(String soOfcCtyCd) {
		this.soOfcCtyCd = soOfcCtyCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param soTeuQty
	 */
	public void setSoTeuQty(String soTeuQty) {
		this.soTeuQty = soTeuQty;
	}
	
	/**
	 * Column Info
	 * @param soUtQty
	 */
	public void setSoUtQty(String soUtQty) {
		this.soUtQty = soUtQty;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param actVvdCd
	 */
	public void setActVvdCd(String actVvdCd) {
		this.actVvdCd = actVvdCd;
	}
	
	public String getInvDesc() {
		return invDesc;
	}

	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
	}
	/**
	 * Column Info
	 * @param costCalcEffFmDt
	 */
	public void setCostCalcEffFmDt(String costCalcEffFmDt) {
		this.costCalcEffFmDt = costCalcEffFmDt;
	}
	
	/**
	 * Column Info
	 * @param costCalcEffToDt
	 */
	public void setCostCalcEffToDt(String costCalcEffToDt) {
		this.costCalcEffToDt = costCalcEffToDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSoSeq(JSPUtil.getParameter(request, "so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvRgstSeq(JSPUtil.getParameter(request, "inv_rgst_seq", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSo20ftQty(JSPUtil.getParameter(request, "so_20ft_qty", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setSo40ftQty(JSPUtil.getParameter(request, "so_40ft_qty", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvRgstNo(JSPUtil.getParameter(request, "inv_rgst_no", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSoOfcCtyCd(JSPUtil.getParameter(request, "so_ofc_cty_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSoTeuQty(JSPUtil.getParameter(request, "so_teu_qty", ""));
		setSoUtQty(JSPUtil.getParameter(request, "so_ut_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setActVvdCd(JSPUtil.getParameter(request, "act_vvd_cd", ""));
		setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
		setOrgSoDtlSeq(JSPUtil.getParameter(request, "org_so_dtl_seq", ""));
		setN3ptyBilIfFlg(JSPUtil.getParameter(request, "n3pty_bil_if_flg", ""));
		setCostCalcEffFmDt(JSPUtil.getParameter(request, "cost_calc_eff_fm_dt", ""));
		setCostCalcEffToDt(JSPUtil.getParameter(request, "cost_calc_eff_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApPayInvDtlVO[]
	 */
	public ApPayInvDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApPayInvDtlVO[]
	 */
	public ApPayInvDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApPayInvDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invRgstSeq = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_seq", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] so20ftQty = (JSPUtil.getParameter(request, prefix	+ "so_20ft_qty", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] so40ftQty = (JSPUtil.getParameter(request, prefix	+ "so_40ft_qty", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] soOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "so_ofc_cty_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] soTeuQty = (JSPUtil.getParameter(request, prefix	+ "so_teu_qty", length));
			String[] soUtQty = (JSPUtil.getParameter(request, prefix	+ "so_ut_qty", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] actVvdCd = (JSPUtil.getParameter(request, prefix	+ "act_vvd_cd", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] orgSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "org_so_dtl_seq", length));
			String[] n3PtyBilIfFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_if_flg", length));
			String[] costCalcEffFmDt = (JSPUtil.getParameter(request, prefix	+ "cost_calc_eff_fm_dt", length));
			String[] costCalcEffToDt = (JSPUtil.getParameter(request, prefix	+ "cost_calc_eff_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApPayInvDtlVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invRgstSeq[i] != null)
					model.setInvRgstSeq(invRgstSeq[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (so20ftQty[i] != null)
					model.setSo20ftQty(so20ftQty[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (so40ftQty[i] != null)
					model.setSo40ftQty(so40ftQty[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (soOfcCtyCd[i] != null)
					model.setSoOfcCtyCd(soOfcCtyCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (soTeuQty[i] != null)
					model.setSoTeuQty(soTeuQty[i]);
				if (soUtQty[i] != null)
					model.setSoUtQty(soUtQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (actVvdCd[i] != null)
					model.setActVvdCd(actVvdCd[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (orgSoDtlSeq[i] != null)
					model.setOrgSoDtlSeq(orgSoDtlSeq[i]);
				if (n3PtyBilIfFlg[i] != null)
					model.setN3ptyBilIfFlg(n3PtyBilIfFlg[i]);
				if (costCalcEffFmDt[i] != null)
					 model.setCostCalcEffFmDt(costCalcEffFmDt[i]);	
				if (costCalcEffToDt[i] != null)
					 model.setCostCalcEffToDt(costCalcEffToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApPayInvDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApPayInvDtlVO[]
	 */
	public ApPayInvDtlVO[] getApPayInvDtlVOs(){
		ApPayInvDtlVO[] vos = (ApPayInvDtlVO[])models.toArray(new ApPayInvDtlVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstSeq = this.invRgstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so20ftQty = this.so20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so40ftQty = this.so40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soOfcCtyCd = this.soOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soTeuQty = this.soTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUtQty = this.soUtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actVvdCd = this.actVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSoDtlSeq = this.orgSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3PtyBilIfFlg = this.n3PtyBilIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCalcEffFmDt = this.costCalcEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.costCalcEffToDt = this.costCalcEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
