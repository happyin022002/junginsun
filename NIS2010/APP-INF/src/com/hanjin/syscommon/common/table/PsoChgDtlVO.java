/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PsoChgDtlVO.java
*@FileTitle : PsoChgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.22 진마리아 
* 1.0 Creation
* 
* History
* 2012.11.28 진마리아 CHM-201220618-01 TPB 비용 정보 지정시 해당 정보를 TPB IF용 테이블에 저장하고 제어함(n3ptyBilIfFlg 추가)
* 2014.08.05 이성훈 CHM-201430972 	[PSO] Invoice내 Exchanage Rate 칼럼 추가
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class PsoChgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsoChgDtlVO> models = new ArrayList<PsoChgDtlVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String invCondDesc = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String arYrmon = null;
	/* Column Info */
	private String n3ptyBilIfFlg = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpIoBndCd = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String orgSoDtlSeq = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String xprDesc = null;
	/* Column Info */
	private String mnlInpXchRt = null;	
	/* Column Info */
	private String costCalcEffFmDt = null;	//2015.03.12	
	/* Column Info */
	private String costCalcEffToDt = null;	//2015.03.12	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsoChgDtlVO() {}

	public PsoChgDtlVO(String ibflag, String pagerows, String issCtyCd, String soSeq, String soDtlSeq, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String rlaneCd, String lgsCostCd, String dpIoBndCd, String ioBndCd, String orgSoDtlSeq, String loclAmt, String usdAmt, String calcAmt, String adjAmt, String xprDesc, String fomlDesc, String ydChgVerSeq, String ydChgNo, String arYrmon, String diffRmk, String invCondDesc, String creUsrId, String creDt, String updUsrId, String updDt, String n3ptyBilIfFlg, String mnlInpXchRt, String costCalcEffFmDt,String costCalcEffToDt) {
		this.vslCd = vslCd;
		this.invCondDesc = invCondDesc;
		this.soSeq = soSeq;
		this.fomlDesc = fomlDesc;
		this.creDt = creDt;
		this.rlaneCd = rlaneCd;
		this.issCtyCd = issCtyCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.ydChgVerSeq = ydChgVerSeq;
		this.arYrmon = arYrmon;
		this.n3ptyBilIfFlg = n3ptyBilIfFlg;
		this.ydChgNo = ydChgNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.dpIoBndCd = dpIoBndCd;
		this.loclAmt = loclAmt;
		this.skdVoyNo = skdVoyNo;
		this.adjAmt = adjAmt;
		this.ioBndCd = ioBndCd;
		this.calcAmt = calcAmt;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.usdAmt = usdAmt;
		this.orgSoDtlSeq = orgSoDtlSeq;
		this.diffRmk = diffRmk;
		this.soDtlSeq = soDtlSeq;
		this.lgsCostCd = lgsCostCd;
		this.xprDesc = xprDesc;
		this.mnlInpXchRt = mnlInpXchRt;		
		this.costCalcEffFmDt = costCalcEffFmDt;
		this.costCalcEffToDt = costCalcEffToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("inv_cond_desc", getInvCondDesc());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("foml_desc", getFomlDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("ar_yrmon", getArYrmon());
		this.hashColumns.put("n3pty_bil_if_flg", getN3ptyBilIfFlg());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dp_io_bnd_cd", getDpIoBndCd());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("org_so_dtl_seq", getOrgSoDtlSeq());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("xpr_desc", getXprDesc());
		this.hashColumns.put("mnl_inp_xch_rt", getMnlInpXchRt());
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
		this.hashFields.put("inv_cond_desc", "invCondDesc");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("foml_desc", "fomlDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("ar_yrmon", "arYrmon");
		this.hashFields.put("n3pty_bil_if_flg", "n3ptyBilIfFlg");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_io_bnd_cd", "dpIoBndCd");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("org_so_dtl_seq", "orgSoDtlSeq");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("xpr_desc", "xprDesc");
		this.hashFields.put("mnl_inp_xch_rt", "mnlInpXchRt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return invCondDesc
	 */
	public String getInvCondDesc() {
		return this.invCondDesc;
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
	 * @return fomlDesc
	 */
	public String getFomlDesc() {
		return this.fomlDesc;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
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
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @return arYrmon
	 */
	public String getArYrmon() {
		return this.arYrmon;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilIfFlg
	 */
	public String getN3ptyBilIfFlg() {
		return this.n3ptyBilIfFlg;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dpIoBndCd
	 */
	public String getDpIoBndCd() {
		return this.dpIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
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
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return xprDesc
	 */
	public String getXprDesc() {
		return this.xprDesc;
	}
	
	/**
	 * Column Info
	 * @return mnlInpXchRt
	 */
	public String getMnlInpXchRt() {
		return this.mnlInpXchRt;
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
	 * @param invCondDesc
	 */
	public void setInvCondDesc(String invCondDesc) {
		this.invCondDesc = invCondDesc;
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
	 * @param fomlDesc
	 */
	public void setFomlDesc(String fomlDesc) {
		this.fomlDesc = fomlDesc;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
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
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @param arYrmon
	 */
	public void setArYrmon(String arYrmon) {
		this.arYrmon = arYrmon;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilIfFlg
	 */
	public void setN3ptyBilIfFlg(String n3ptyBilIfFlg) {
		this.n3ptyBilIfFlg = n3ptyBilIfFlg;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dpIoBndCd
	 */
	public void setDpIoBndCd(String dpIoBndCd) {
		this.dpIoBndCd = dpIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
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
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param xprDesc
	 */
	public void setXprDesc(String xprDesc) {
		this.xprDesc = xprDesc;
	}
	
	/**
	 * Column Info
	 * @param mnlInpXchRt
	 */
	public void setMnlInpXchRt(String mnlInpXchRt) {
		this.mnlInpXchRt = mnlInpXchRt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setInvCondDesc(JSPUtil.getParameter(request, prefix + "inv_cond_desc", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", ""));
		setArYrmon(JSPUtil.getParameter(request, prefix + "ar_yrmon", ""));
		setN3ptyBilIfFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_if_flg", ""));
		setYdChgNo(JSPUtil.getParameter(request, prefix + "yd_chg_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDpIoBndCd(JSPUtil.getParameter(request, prefix + "dp_io_bnd_cd", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setOrgSoDtlSeq(JSPUtil.getParameter(request, prefix + "org_so_dtl_seq", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
		setMnlInpXchRt(JSPUtil.getParameter(request, prefix + "mnl_inp_xch_rt", ""));
		setCostCalcEffFmDt(JSPUtil.getParameter(request, prefix + "cost_calc_eff_fm_dt", ""));
		setCostCalcEffToDt(JSPUtil.getParameter(request, prefix + "cost_calc_eff_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsoChgDtlVO[]
	 */
	public PsoChgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsoChgDtlVO[]
	 */
	public PsoChgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsoChgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] invCondDesc = (JSPUtil.getParameter(request, prefix	+ "inv_cond_desc", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] arYrmon = (JSPUtil.getParameter(request, prefix	+ "ar_yrmon", length));
			String[] n3ptyBilIfFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_if_flg", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dpIoBndCd = (JSPUtil.getParameter(request, prefix	+ "dp_io_bnd_cd", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] orgSoDtlSeq = (JSPUtil.getParameter(request, prefix	+ "org_so_dtl_seq", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] xprDesc = (JSPUtil.getParameter(request, prefix	+ "xpr_desc", length));
			String[] mnlInpXchRt = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_xch_rt", length));
			String[] costCalcEffFmDt = (JSPUtil.getParameter(request, prefix	+ "cost_calc_eff_fm_dt", length));
			String[] costCalcEffToDt = (JSPUtil.getParameter(request, prefix	+ "cost_calc_eff_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsoChgDtlVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (invCondDesc[i] != null)
					model.setInvCondDesc(invCondDesc[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (arYrmon[i] != null)
					model.setArYrmon(arYrmon[i]);
				if (n3ptyBilIfFlg[i] != null)
					model.setN3ptyBilIfFlg(n3ptyBilIfFlg[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpIoBndCd[i] != null)
					model.setDpIoBndCd(dpIoBndCd[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (orgSoDtlSeq[i] != null)
					model.setOrgSoDtlSeq(orgSoDtlSeq[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (xprDesc[i] != null)
					model.setXprDesc(xprDesc[i]);
				if (mnlInpXchRt[i] != null)
					model.setMnlInpXchRt(mnlInpXchRt[i]);	
				if (costCalcEffFmDt[i] != null)
					 model.setCostCalcEffFmDt(costCalcEffFmDt[i]);	
				if (costCalcEffToDt[i] != null)
					 model.setCostCalcEffToDt(costCalcEffToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsoChgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsoChgDtlVO[]
	 */
	public PsoChgDtlVO[] getPsoChgDtlVOs(){
		PsoChgDtlVO[] vos = (PsoChgDtlVO[])models.toArray(new PsoChgDtlVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCondDesc = this.invCondDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlDesc = this.fomlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arYrmon = this.arYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilIfFlg = this.n3ptyBilIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpIoBndCd = this.dpIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSoDtlSeq = this.orgSoDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xprDesc = this.xprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpXchRt = this.mnlInpXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCalcEffFmDt = this.costCalcEffFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.costCalcEffToDt = this.costCalcEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
