/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CtmMvmtXchVO.java
*@FileTitle : CtmMvmtXchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 우경민
 * @since J2EE 1.5
 */

public class CtmMvmtXchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CtmMvmtXchVO> models = new ArrayList<CtmMvmtXchVO>();

	/* Column Info */
	private String dp = null;
	/* Column Info */
	private String rc = null;
	/* Column Info */
	private String xchCntrTpszCd = null;
	/* Column Info */
	private String pOffice = null;
	/* Column Info */
	private String xchCntrCycNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String preCnmvStsCd = null;
	/* Column Info */
	private String rp = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String et = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String pReson = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ot = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ow = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String be = null;
	/* Column Info */
	private String dm = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String sm = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String xchOfcCd = null;
	/* Column Info */
	private String xchCntrNo = null;
	/* Column Info */
	private String oz = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String od = null;
	/* Column Info */
	private String cn = null;
	/* Column Info */
	private String pSplit  = null;
	/* Column Info */
	private String xchRmk = null;
	/* Column Info */
	private String dt = null;
	/* Page Number */
	private String pagerows = null;
	/* Log출력 */
	private Logger log = Logger.getLogger("org.apache.log4j.Logger");

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	/* 생성자 */
	public CtmMvmtXchVO() {}

	/* 생성자 */
	public CtmMvmtXchVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String cnmvStsCd, String cnmvCycNo, String bkgNo, String bkgNoSplit, String xchCntrNo, String xchCntrTpszCd, String preCnmvStsCd, String xchCntrCycNo, String dt, String orgYdCd, String xchOfcCd, String xchRmk, String be, String cm, String cn, String dm, String dp, String et, String od, String ot, String ow, String oz, String rc, String rp, String sm, String pOffice, String pYard1, String pYard2, String pDate1, String pDate2, String pCntrno, String pSplit , String pReson) {
		this.dp = dp;
		this.rc = rc;
		this.xchCntrTpszCd = xchCntrTpszCd;
		this.pOffice = pOffice;
		this.xchCntrCycNo = xchCntrCycNo;
		this.bkgNoSplit = bkgNoSplit;
		this.orgYdCd = orgYdCd;
		this.cnmvCycNo = cnmvCycNo;
		this.preCnmvStsCd = preCnmvStsCd;
		this.rp = rp;
		this.bkgNo = bkgNo;
		this.pYard1 = pYard1;
		this.et = et;
		this.pCntrno = pCntrno;
		this.pReson = pReson;
		this.cntrNo = cntrNo;
		this.ot = ot;
		this.cntrTpszCd = cntrTpszCd;
		this.ow = ow;
		this.ibflag = ibflag;
		this.pDate1 = pDate1;
		this.be = be;
		this.dm = dm;
		this.pYard2 = pYard2;
		this.sm = sm;
		this.cm = cm;
		this.pDate2 = pDate2;
		this.xchOfcCd = xchOfcCd;
		this.xchCntrNo = xchCntrNo;
		this.oz = oz;
		this.cnmvStsCd = cnmvStsCd;
		this.od = od;
		this.cn = cn;
		this.pSplit  = pSplit ;
		this.xchRmk = xchRmk;
		this.dt = dt;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp", getDp());
		this.hashColumns.put("rc", getRc());
		this.hashColumns.put("xch_cntr_tpsz_cd", getXchCntrTpszCd());
		this.hashColumns.put("p_office", getPOffice());
		this.hashColumns.put("xch_cntr_cyc_no", getXchCntrCycNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("pre_cnmv_sts_cd", getPreCnmvStsCd());
		this.hashColumns.put("rp", getRp());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("et", getEt());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("p_reson", getPReson());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ot", getOt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ow", getOw());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("be", getBe());
		this.hashColumns.put("dm", getDm());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("sm", getSm());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("xch_ofc_cd", getXchOfcCd());
		this.hashColumns.put("xch_cntr_no", getXchCntrNo());
		this.hashColumns.put("oz", getOz());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("od", getOd());
		this.hashColumns.put("cn", getCn());
		this.hashColumns.put("p_split ", getPSplit ());
		this.hashColumns.put("xch_rmk", getXchRmk());
		this.hashColumns.put("dt", getDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp", "dp");
		this.hashFields.put("rc", "rc");
		this.hashFields.put("xch_cntr_tpsz_cd", "xchCntrTpszCd");
		this.hashFields.put("p_office", "pOffice");
		this.hashFields.put("xch_cntr_cyc_no", "xchCntrCycNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("pre_cnmv_sts_cd", "preCnmvStsCd");
		this.hashFields.put("rp", "rp");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("et", "et");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("p_reson", "pReson");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ot", "ot");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ow", "ow");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("be", "be");
		this.hashFields.put("dm", "dm");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("sm", "sm");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("xch_ofc_cd", "xchOfcCd");
		this.hashFields.put("xch_cntr_no", "xchCntrNo");
		this.hashFields.put("oz", "oz");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("od", "od");
		this.hashFields.put("cn", "cn");
		this.hashFields.put("p_split ", "pSplit ");
		this.hashFields.put("xch_rmk", "xchRmk");
		this.hashFields.put("dt", "dt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getDp() {
		return this.dp;
	}
	public String getRc() {
		return this.rc;
	}
	public String getXchCntrTpszCd() {
		return this.xchCntrTpszCd;
	}
	public String getPOffice() {
		return this.pOffice;
	}
	public String getXchCntrCycNo() {
		return this.xchCntrCycNo;
	}
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	public String getPreCnmvStsCd() {
		return this.preCnmvStsCd;
	}
	public String getRp() {
		return this.rp;
	}
	public String getBkgNo() {
		return this.bkgNo;
	}
	public String getPYard1() {
		return this.pYard1;
	}
	public String getEt() {
		return this.et;
	}
	public String getPCntrno() {
		return this.pCntrno;
	}
	public String getPReson() {
		return this.pReson;
	}
	public String getCntrNo() {
		return this.cntrNo;
	}
	public String getOt() {
		return this.ot;
	}
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	public String getOw() {
		return this.ow;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPDate1() {
		return this.pDate1;
	}
	public String getBe() {
		return this.be;
	}
	public String getDm() {
		return this.dm;
	}
	public String getPYard2() {
		return this.pYard2;
	}
	public String getSm() {
		return this.sm;
	}
	public String getCm() {
		return this.cm;
	}
	public String getPDate2() {
		return this.pDate2;
	}
	public String getXchOfcCd() {
		return this.xchOfcCd;
	}
	public String getXchCntrNo() {
		return this.xchCntrNo;
	}
	public String getOz() {
		return this.oz;
	}
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	public String getOd() {
		return this.od;
	}
	public String getCn() {
		return this.cn;
	}
	public String getPSplit () {
		return this.pSplit ;
	}
	public String getXchRmk() {
		return this.xchRmk;
	}
	public String getDt() {
		return this.dt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setDp(String dp) {
		this.dp = dp;
		//this.dp=true;
	}
	public void setRc(String rc) {
		this.rc = rc;
		//this.rc=true;
	}
	public void setXchCntrTpszCd(String xchCntrTpszCd) {
		this.xchCntrTpszCd = xchCntrTpszCd;
		//this.xchCntrTpszCd=true;
	}
	public void setPOffice(String pOffice) {
		this.pOffice = pOffice;
		//this.pOffice=true;
	}
	public void setXchCntrCycNo(String xchCntrCycNo) {
		this.xchCntrCycNo = xchCntrCycNo;
		//this.xchCntrCycNo=true;
	}
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
		//this.bkgNoSplit=true;
	}
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
		//this.orgYdCd=true;
	}
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
		//this.cnmvCycNo=true;
	}
	public void setPreCnmvStsCd(String preCnmvStsCd) {
		this.preCnmvStsCd = preCnmvStsCd;
		//this.preCnmvStsCd=true;
	}
	public void setRp(String rp) {
		this.rp = rp;
		//this.rp=true;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
		//this.bkgNo=true;
	}
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
		//this.pYard1=true;
	}
	public void setEt(String et) {
		this.et = et;
		//this.et=true;
	}
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
		//this.pCntrno=true;
	}
	public void setPReson(String pReson) {
		this.pReson = pReson;
		//this.pReson=true;
	}
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
		//this.cntrNo=true;
	}
	public void setOt(String ot) {
		this.ot = ot;
		//this.ot=true;
	}
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
		//this.cntrTpszCd=true;
	}
	public void setOw(String ow) {
		this.ow = ow;
		//this.ow=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
		//this.pDate1=true;
	}
	public void setBe(String be) {
		this.be = be;
		//this.be=true;
	}
	public void setDm(String dm) {
		this.dm = dm;
		//this.dm=true;
	}
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
		//this.pYard2=true;
	}
	public void setSm(String sm) {
		this.sm = sm;
		//this.sm=true;
	}
	public void setCm(String cm) {
		this.cm = cm;
		//this.cm=true;
	}
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
		//this.pDate2=true;
	}
	public void setXchOfcCd(String xchOfcCd) {
		this.xchOfcCd = xchOfcCd;
		//this.xchOfcCd=true;
	}
	public void setXchCntrNo(String xchCntrNo) {
		this.xchCntrNo = xchCntrNo;
		//this.xchCntrNo=true;
	}
	public void setOz(String oz) {
		this.oz = oz;
		//this.oz=true;
	}
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
		//this.cnmvStsCd=true;
	}
	public void setOd(String od) {
		this.od = od;
		//this.od=true;
	}
	public void setCn(String cn) {
		this.cn = cn;
		//this.cn=true;
	}
	public void setPSplit (String pSplit ) {
		this.pSplit  = pSplit ;
		//this.pSplit =true;
	}
	public void setXchRmk(String xchRmk) {
		this.xchRmk = xchRmk;
		//this.xchRmk=true;
	}
	public void setDt(String dt) {
		this.dt = dt;
		//this.dt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setDp(JSPUtil.getParameter(request, "dp", ""));
		setRc(JSPUtil.getParameter(request, "rc", ""));
		setXchCntrTpszCd(JSPUtil.getParameter(request, "xch_cntr_tpsz_cd", ""));
		setPOffice(JSPUtil.getParameter(request, "p_office", ""));
		setXchCntrCycNo(JSPUtil.getParameter(request, "xch_cntr_cyc_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setPreCnmvStsCd(JSPUtil.getParameter(request, "pre_cnmv_sts_cd", ""));
		setRp(JSPUtil.getParameter(request, "rp", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
		setEt(JSPUtil.getParameter(request, "et", ""));
		setPCntrno(JSPUtil.getParameter(request, "p_cntrno", ""));
		setPReson(JSPUtil.getParameter(request, "p_reson", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOt(JSPUtil.getParameter(request, "ot", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOw(JSPUtil.getParameter(request, "ow", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPDate1(JSPUtil.getParameter(request, "p_date1", ""));
		setBe(JSPUtil.getParameter(request, "be", ""));
		setDm(JSPUtil.getParameter(request, "dm", ""));
		setPYard2(JSPUtil.getParameter(request, "p_yard2", ""));
		setSm(JSPUtil.getParameter(request, "sm", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setPDate2(JSPUtil.getParameter(request, "p_date2", ""));
		setXchOfcCd(JSPUtil.getParameter(request, "xch_ofc_cd", ""));
		setXchCntrNo(JSPUtil.getParameter(request, "xch_cntr_no", ""));
		setOz(JSPUtil.getParameter(request, "oz", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setOd(JSPUtil.getParameter(request, "od", ""));
		setCn(JSPUtil.getParameter(request, "cn", ""));
		setPSplit (JSPUtil.getParameter(request, "p_split ", ""));
		setXchRmk(JSPUtil.getParameter(request, "xch_rmk", ""));
		setDt(JSPUtil.getParameter(request, "dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CtmMvmtXchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CtmMvmtXchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CtmMvmtXchVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dp = (JSPUtil.getParameter(request, prefix	+ "dp".trim(), length));
			String[] rc = (JSPUtil.getParameter(request, prefix	+ "rc".trim(), length));
			String[] xchCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_tpsz_cd".trim(), length));
			String[] pOffice = (JSPUtil.getParameter(request, prefix	+ "p_office".trim(), length));
			String[] xchCntrCycNo = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_cyc_no".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd".trim(), length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no".trim(), length));
			String[] preCnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "pre_cnmv_sts_cd".trim(), length));
			String[] rp = (JSPUtil.getParameter(request, prefix	+ "rp".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1".trim(), length));
			String[] et = (JSPUtil.getParameter(request, prefix	+ "et".trim(), length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno".trim(), length));
			String[] pReson = (JSPUtil.getParameter(request, prefix	+ "p_reson".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] ot = (JSPUtil.getParameter(request, prefix	+ "ot".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] ow = (JSPUtil.getParameter(request, prefix	+ "ow".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1".trim(), length));
			String[] be = (JSPUtil.getParameter(request, prefix	+ "be".trim(), length));
			String[] dm = (JSPUtil.getParameter(request, prefix	+ "dm".trim(), length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2".trim(), length));
			String[] sm = (JSPUtil.getParameter(request, prefix	+ "sm".trim(), length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm".trim(), length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2".trim(), length));
			String[] xchOfcCd = (JSPUtil.getParameter(request, prefix	+ "xch_ofc_cd".trim(), length));
			String[] xchCntrNo = (JSPUtil.getParameter(request, prefix	+ "xch_cntr_no".trim(), length));
			String[] oz = (JSPUtil.getParameter(request, prefix	+ "oz".trim(), length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd".trim(), length));
			String[] od = (JSPUtil.getParameter(request, prefix	+ "od".trim(), length));
			String[] cn = (JSPUtil.getParameter(request, prefix	+ "cn".trim(), length));
			String[] pSplit  = (JSPUtil.getParameter(request, prefix	+ "p_split ".trim(), length));
			String[] xchRmk = (JSPUtil.getParameter(request, prefix	+ "xch_rmk".trim(), length));
			String[] dt = (JSPUtil.getParameter(request, prefix	+ "dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new CtmMvmtXchVO();
				if (dp[i] != null)
					model.setDp(dp[i]);
				if (rc[i] != null)
					model.setRc(rc[i]);
				if (xchCntrTpszCd[i] != null)
					model.setXchCntrTpszCd(xchCntrTpszCd[i]);
				if (pOffice[i] != null)
					model.setPOffice(pOffice[i]);
				if (xchCntrCycNo[i] != null)
					model.setXchCntrCycNo(xchCntrCycNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (preCnmvStsCd[i] != null)
					model.setPreCnmvStsCd(preCnmvStsCd[i]);
				if (rp[i] != null)
					model.setRp(rp[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (et[i] != null)
					model.setEt(et[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (pReson[i] != null)
					model.setPReson(pReson[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ot[i] != null)
					model.setOt(ot[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ow[i] != null)
					model.setOw(ow[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (be[i] != null)
					model.setBe(be[i]);
				if (dm[i] != null)
					model.setDm(dm[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (sm[i] != null)
					model.setSm(sm[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (xchOfcCd[i] != null)
					model.setXchOfcCd(xchOfcCd[i]);
				if (xchCntrNo[i] != null)
					model.setXchCntrNo(xchCntrNo[i]);
				if (oz[i] != null)
					model.setOz(oz[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (od[i] != null)
					model.setOd(od[i]);
				if (cn[i] != null)
					model.setCn(cn[i]);
				if (pSplit [i] != null)
					model.setPSplit (pSplit [i]);
				if (xchRmk[i] != null)
					model.setXchRmk(xchRmk[i]);
				if (dt[i] != null)
					model.setDt(dt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {log.error("err " + e.toString(), e);}
		return getCtmMvmtXchVOs();
	}

	public CtmMvmtXchVO[] getCtmMvmtXchVOs(){
		CtmMvmtXchVO[] vos = (CtmMvmtXchVO[])models.toArray(new CtmMvmtXchVO[models.size()]);
		return vos;
	}

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
		} catch (Exception ex) {log.error("err " + ex.toString(), ex);}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.dp = this.dp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rc = this.rc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrTpszCd = this.xchCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOffice = this.pOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrCycNo = this.xchCntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCnmvStsCd = this.preCnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rp = this.rp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.et = this.et .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pReson = this.pReson .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot = this.ot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ow = this.ow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.be = this.be .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dm = this.dm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sm = this.sm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchOfcCd = this.xchOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchCntrNo = this.xchCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oz = this.oz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.od = this.od .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cn = this.cn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSplit  = this.pSplit  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRmk = this.xchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt = this.dt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
