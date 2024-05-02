/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzFeeInvDtlVO.java
*@FileTitle : CanalTzFeeInvDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.20 김진일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeInvDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeInvDtlVO> models = new ArrayList<CanalTzFeeInvDtlVO>();
	
	/* Column Info */
	private String rqstAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String psoBztpCd = null;
	/* Column Info */
	private String callSeq = null;
	/* Column Info */
	private String credits = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String balance = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dfltXprDesc = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String sysXprDesc = null;
	/* Column Info */
	private String lastInv = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String suzNetTongWgt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String dfltSysXprDesc = null;
	/* Column Info */
	private String scgRtAmt = null;
	/* Column Info */
	private String trVolVal = null;
	/* 2009.12.15. add */
	private String invRgstNo = null; //INV_RGST_NO
	/* 2010.01.07 add */
	private String flg = null ;//tuple 의 속성 구분 플래그 값 
	
	private String vvd = null;
	
	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeInvDtlVO() {}

	public CanalTzFeeInvDtlVO(String ibflag, String pagerows, String credits, String vndrSeq, String psoBztpCd, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String callSeq, String lgsCostCd, String lgsCostFullNm, String lastInv, String rqstAmt, String balance, String diffRmk, String calcAmt, String ydChgNo, String ydChgVerSeq, String dfltXprDesc, String sysXprDesc, String dfltSysXprDesc, String invNo, String suzNetTongWgt, String loclXchRt, String trVolVal, String scgRtAmt, String invRgstNo, String flg, String vvd) {
		this.rqstAmt = rqstAmt;
		this.vslCd = vslCd;
		this.psoBztpCd = psoBztpCd;
		this.callSeq = callSeq;
		this.credits = credits;
		this.pagerows = pagerows;
		this.balance = balance;
		this.ibflag = ibflag;
		this.dfltXprDesc = dfltXprDesc;
		this.ydChgVerSeq = ydChgVerSeq;
		this.ydChgNo = ydChgNo;
		this.lgsCostFullNm = lgsCostFullNm;
		this.loclXchRt = loclXchRt;
		this.sysXprDesc = sysXprDesc;
		this.lastInv = lastInv;
		this.skdVoyNo = skdVoyNo;
		this.calcAmt = calcAmt;
		this.skdDirCd = skdDirCd;
		this.invNo = invNo;
		this.diffRmk = diffRmk;
		this.suzNetTongWgt = suzNetTongWgt;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.dfltSysXprDesc = dfltSysXprDesc;
		this.scgRtAmt = scgRtAmt;
		this.trVolVal = trVolVal;
		this.invRgstNo = invRgstNo;
		this.flg = flg;
		this.vvd = vvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_amt", getRqstAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pso_bztp_cd", getPsoBztpCd());
		this.hashColumns.put("call_seq", getCallSeq());
		this.hashColumns.put("credits", getCredits());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("balance", getBalance());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dflt_xpr_desc", getDfltXprDesc());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("sys_xpr_desc", getSysXprDesc());
		this.hashColumns.put("last_inv", getLastInv());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("dflt_sys_xpr_desc", getDfltSysXprDesc());
		this.hashColumns.put("scg_rt_amt", getScgRtAmt());
		this.hashColumns.put("tr_vol_val", getTrVolVal());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("vvd", getVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_amt", "rqstAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pso_bztp_cd", "psoBztpCd");
		this.hashFields.put("call_seq", "callSeq");
		this.hashFields.put("credits", "credits");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("balance", "balance");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dflt_xpr_desc", "dfltXprDesc");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("sys_xpr_desc", "sysXprDesc");
		this.hashFields.put("last_inv", "lastInv");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("dflt_sys_xpr_desc", "dfltSysXprDesc");
		this.hashFields.put("scg_rt_amt", "scgRtAmt");
		this.hashFields.put("tr_vol_val", "trVolVal");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("vvd", "vvd");
		return this.hashFields;
	}
	

	/**
	 * Column Info
	 * @return rqstAmt
	 */
	public String getRqstAmt() {
		return this.rqstAmt;
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
	 * @return psoBztpCd
	 */
	public String getPsoBztpCd() {
		return this.psoBztpCd;
	}
	
	/**
	 * Column Info
	 * @return callSeq
	 */
	public String getCallSeq() {
		return this.callSeq;
	}
	
	/**
	 * Column Info
	 * @return credits
	 */
	public String getCredits() {
		return this.credits;
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
	 * @return balance
	 */
	public String getBalance() {
		return this.balance;
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
	 * @return dfltXprDesc
	 */
	public String getDfltXprDesc() {
		return this.dfltXprDesc;
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
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @return loclXchRt
	 */
	public String getLoclXchRt() {
		return this.loclXchRt;
	}
	
	/**
	 * Column Info
	 * @return sysXprDesc
	 */
	public String getSysXprDesc() {
		return this.sysXprDesc;
	}
	
	/**
	 * Column Info
	 * @return lastInv
	 */
	public String getLastInv() {
		return this.lastInv;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return suzNetTongWgt
	 */
	public String getSuzNetTongWgt() {
		return this.suzNetTongWgt;
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
	 * @return dfltSysXprDesc
	 */
	public String getDfltSysXprDesc() {
		return this.dfltSysXprDesc;
	}
	
	/**
	 * Column Info
	 * @return scgRtAmt
	 */
	public String getScgRtAmt() {
		return this.scgRtAmt;
	}
	
	/**
	 * Column Info
	 * @return trVolVal
	 */
	public String getTrVolVal() {
		return this.trVolVal;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFlg(){
		return this.flg;
	}

	/**
	 * Column Info
	 * @param rqstAmt
	 */
	public void setRqstAmt(String rqstAmt) {
		this.rqstAmt = rqstAmt;
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
	 * @param psoBztpCd
	 */
	public void setPsoBztpCd(String psoBztpCd) {
		this.psoBztpCd = psoBztpCd;
	}
	
	/**
	 * Column Info
	 * @param callSeq
	 */
	public void setCallSeq(String callSeq) {
		this.callSeq = callSeq;
	}
	
	/**
	 * Column Info
	 * @param credits
	 */
	public void setCredits(String credits) {
		this.credits = credits;
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
	 * @param balance
	 */
	public void setBalance(String balance) {
		this.balance = balance;
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
	 * @param dfltXprDesc
	 */
	public void setDfltXprDesc(String dfltXprDesc) {
		this.dfltXprDesc = dfltXprDesc;
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
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @param loclXchRt
	 */
	public void setLoclXchRt(String loclXchRt) {
		this.loclXchRt = loclXchRt;
	}
	
	/**
	 * Column Info
	 * @param sysXprDesc
	 */
	public void setSysXprDesc(String sysXprDesc) {
		this.sysXprDesc = sysXprDesc;
	}
	
	/**
	 * Column Info
	 * @param lastInv
	 */
	public void setLastInv(String lastInv) {
		this.lastInv = lastInv;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param suzNetTongWgt
	 */
	public void setSuzNetTongWgt(String suzNetTongWgt) {
		this.suzNetTongWgt = suzNetTongWgt;
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
	 * @param dfltSysXprDesc
	 */
	public void setDfltSysXprDesc(String dfltSysXprDesc) {
		this.dfltSysXprDesc = dfltSysXprDesc;
	}
	
	/**
	 * Column Info
	 * @param scgRtAmt
	 */
	public void setScgRtAmt(String scgRtAmt) {
		this.scgRtAmt = scgRtAmt;
	}
	
	/**
	 * Column Info
	 * @param trVolVal
	 */
	public void setTrVolVal(String trVolVal) {
		this.trVolVal = trVolVal;
	}
	
	/**
	 * 
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
	}
	
	/**
	 * 
	 * @param flg
	 */
	public void setFlg(String flg){
		this.flg = flg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRqstAmt(JSPUtil.getParameter(request, "rqst_amt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPsoBztpCd(JSPUtil.getParameter(request, "pso_bztp_cd", ""));
		setCallSeq(JSPUtil.getParameter(request, "call_seq", ""));
		setCredits(JSPUtil.getParameter(request, "credits", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBalance(JSPUtil.getParameter(request, "balance", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDfltXprDesc(JSPUtil.getParameter(request, "dflt_xpr_desc", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, "lgs_cost_full_nm", ""));
		setLoclXchRt(JSPUtil.getParameter(request, "locl_xch_rt", ""));
		setSysXprDesc(JSPUtil.getParameter(request, "sys_xpr_desc", ""));
		setLastInv(JSPUtil.getParameter(request, "last_inv", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCalcAmt(JSPUtil.getParameter(request, "calc_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setSuzNetTongWgt(JSPUtil.getParameter(request, "suz_net_tong_wgt", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setDfltSysXprDesc(JSPUtil.getParameter(request, "dflt_sys_xpr_desc", ""));
		setScgRtAmt(JSPUtil.getParameter(request, "scg_rt_amt", ""));
		setTrVolVal(JSPUtil.getParameter(request, "tr_vol_val", ""));
		setInvRgstNo(JSPUtil.getParameter(request, "inv_rgst_no", ""));
		setFlg(JSPUtil.getParameter(request, "flg", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeInvDtlVO[]
	 */
	public CanalTzFeeInvDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeInvDtlVO[]
	 */
	public CanalTzFeeInvDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeInvDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstAmt = (JSPUtil.getParameter(request, prefix	+ "rqst_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] psoBztpCd = (JSPUtil.getParameter(request, prefix	+ "pso_bztp_cd", length));
			String[] callSeq = (JSPUtil.getParameter(request, prefix	+ "call_seq", length));
			String[] credits = (JSPUtil.getParameter(request, prefix	+ "credits", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] balance = (JSPUtil.getParameter(request, prefix	+ "balance", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dfltXprDesc = (JSPUtil.getParameter(request, prefix	+ "dflt_xpr_desc", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] sysXprDesc = (JSPUtil.getParameter(request, prefix	+ "sys_xpr_desc", length));
			String[] lastInv = (JSPUtil.getParameter(request, prefix	+ "last_inv", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "suz_net_tong_wgt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] dfltSysXprDesc = (JSPUtil.getParameter(request, prefix	+ "dflt_sys_xpr_desc", length));
			String[] scgRtAmt = (JSPUtil.getParameter(request, prefix	+ "scg_rt_amt", length));
			String[] trVolVal = (JSPUtil.getParameter(request, prefix	+ "tr_vol_val", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeInvDtlVO();
				if (rqstAmt[i] != null)
					model.setRqstAmt(rqstAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (psoBztpCd[i] != null)
					model.setPsoBztpCd(psoBztpCd[i]);
				if (callSeq[i] != null)
					model.setCallSeq(callSeq[i]);
				if (credits[i] != null)
					model.setCredits(credits[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (balance[i] != null)
					model.setBalance(balance[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dfltXprDesc[i] != null)
					model.setDfltXprDesc(dfltXprDesc[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (sysXprDesc[i] != null)
					model.setSysXprDesc(sysXprDesc[i]);
				if (lastInv[i] != null)
					model.setLastInv(lastInv[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (suzNetTongWgt[i] != null)
					model.setSuzNetTongWgt(suzNetTongWgt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (dfltSysXprDesc[i] != null)
					model.setDfltSysXprDesc(dfltSysXprDesc[i]);
				if (scgRtAmt[i] != null)
					model.setScgRtAmt(scgRtAmt[i]);
				if (trVolVal[i] != null)
					model.setTrVolVal(trVolVal[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (vvd[i] != null)
					model.setFlg(vvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeInvDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeInvDtlVO[]
	 */
	public CanalTzFeeInvDtlVO[] getCanalTzFeeInvDtlVOs(){
		CanalTzFeeInvDtlVO[] vos = (CanalTzFeeInvDtlVO[])models.toArray(new CanalTzFeeInvDtlVO[models.size()]);
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
		this.rqstAmt = this.rqstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoBztpCd = this.psoBztpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSeq = this.callSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credits = this.credits .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balance = this.balance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltXprDesc = this.dfltXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysXprDesc = this.sysXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastInv = this.lastInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzNetTongWgt = this.suzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltSysXprDesc = this.dfltSysXprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgRtAmt = this.scgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trVolVal = this.trVolVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
