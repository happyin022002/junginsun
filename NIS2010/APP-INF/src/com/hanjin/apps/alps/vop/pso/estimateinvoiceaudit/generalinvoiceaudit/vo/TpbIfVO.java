/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TpbIfVO.java
*@FileTitle : TpbIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.15 진마리아 
* 1.0 Creation
* 
* History
* 2012.11.26 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

import java.lang.reflect.Field;
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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TpbIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TpbIfVO> models = new ArrayList<TpbIfVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String ifSeq = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ifRmk = null;
	/* Column Info */
	private String ifUsrId = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String ifCurrCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String acctEngNm = null;
	/* Column Info */
	private String vvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TpbIfVO() {}

	public TpbIfVO(String ibflag, String pagerows, String issCtyCd, String soSeq, String soDtlSeq, String ifSeq, String n3ptyBilTpCd, String ifOfcCd, String costOfcCd, String invNo, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String vndrCntCd, String vndrSeq, String ifCurrCd, String ifAmt, String ifRmk, String acctCd, String lgsCostCd, String vpsEtdDt, String ifUsrId, String ifDt, String ifFlg, String n3ptyBilTpNm, String creUsrId, String updUsrId, String vndrLglEngNm, String ydNm, String acctEngNm, String vvd) {
		this.ifDt = ifDt;
		this.vslCd = vslCd;
		this.vndrCntCd = vndrCntCd;
		this.ifOfcCd = ifOfcCd;
		this.soSeq = soSeq;
		this.ifSeq = ifSeq;
		this.issCtyCd = issCtyCd;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.pagerows = pagerows;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.updUsrId = updUsrId;
		this.ifRmk = ifRmk;
		this.ifUsrId = ifUsrId;
		this.costOfcCd = costOfcCd;
		this.vpsEtdDt = vpsEtdDt;
		this.skdVoyNo = skdVoyNo;
		this.ifFlg = ifFlg;
		this.skdDirCd = skdDirCd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.soDtlSeq = soDtlSeq;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.ifCurrCd = ifCurrCd;
		this.ifAmt = ifAmt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ydNm = ydNm;
		this.acctEngNm = acctEngNm;
		this.vvd = vvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("if_seq", getIfSeq());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("if_rmk", getIfRmk());
		this.hashColumns.put("if_usr_id", getIfUsrId());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("if_curr_cd", getIfCurrCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("vvd", getVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("if_seq", "ifSeq");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("if_rmk", "ifRmk");
		this.hashFields.put("if_usr_id", "ifUsrId");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("if_curr_cd", "ifCurrCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("vvd", "vvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
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
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
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
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return ifSeq
	 */
	public String getIfSeq() {
		return this.ifSeq;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
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
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return ifRmk
	 */
	public String getIfRmk() {
		return this.ifRmk;
	}
	
	/**
	 * Column Info
	 * @return ifUsrId
	 */
	public String getIfUsrId() {
		return this.ifUsrId;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return soDtlSeq
	 */
	public String getSoDtlSeq() {
		return this.soDtlSeq;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
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
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
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
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
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
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param ifSeq
	 */
	public void setIfSeq(String ifSeq) {
		this.ifSeq = ifSeq;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
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
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param ifRmk
	 */
	public void setIfRmk(String ifRmk) {
		this.ifRmk = ifRmk;
	}
	
	/**
	 * Column Info
	 * @param ifUsrId
	 */
	public void setIfUsrId(String ifUsrId) {
		this.ifUsrId = ifUsrId;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param soDtlSeq
	 */
	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, prefix + "vndr_cnt_cd", ""));
		setIfOfcCd(JSPUtil.getParameter(request, prefix + "if_ofc_cd", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setIfSeq(JSPUtil.getParameter(request, prefix + "if_seq", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIfRmk(JSPUtil.getParameter(request, prefix + "if_rmk", ""));
		setIfUsrId(JSPUtil.getParameter(request, prefix + "if_usr_id", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setIfCurrCd(JSPUtil.getParameter(request, prefix + "if_curr_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TpbIfVO[]
	 */
	public TpbIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TpbIfVO[]
	 */
	public TpbIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TpbIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] ifSeq = (JSPUtil.getParameter(request, prefix	+ "if_seq", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ifRmk = (JSPUtil.getParameter(request, prefix	+ "if_rmk", length));
			String[] ifUsrId = (JSPUtil.getParameter(request, prefix	+ "if_usr_id", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] ifCurrCd = (JSPUtil.getParameter(request, prefix	+ "if_curr_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TpbIfVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (ifSeq[i] != null)
					model.setIfSeq(ifSeq[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ifRmk[i] != null)
					model.setIfRmk(ifRmk[i]);
				if (ifUsrId[i] != null)
					model.setIfUsrId(ifUsrId[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (ifCurrCd[i] != null)
					model.setIfCurrCd(ifCurrCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTpbIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TpbIfVO[]
	 */
	public TpbIfVO[] getTpbIfVOs(){
		TpbIfVO[] vos = (TpbIfVO[])models.toArray(new TpbIfVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSeq = this.ifSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRmk = this.ifRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifUsrId = this.ifUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCurrCd = this.ifCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
