/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMultiDimension068ListVO.java
*@FileTitle : SearchMultiDimension068ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.25 김기식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo;

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
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMultiDimension068ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMultiDimension068ListVO> models = new ArrayList<SearchMultiDimension068ListVO>();
	
	/* Column Info */
	private String rcmdt = null;
	/* Column Info */
	private String costRoutNo = null;
	/* Column Info */
	private String spclAk = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String rterm = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ts3 = null;
	/* Column Info */
	private String ts2 = null;
	/* Column Info */
	private String ts1 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String inter1 = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String inter2 = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String lane3 = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String dterm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String spclBb = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String spclRf = null;
	/* Column Info */
	private String spclDg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMultiDimension068ListVO() {}

	public SearchMultiDimension068ListVO(String ibflag, String pagerows, String pctlNo, String bkgNo, String costRoutNo, String por, String pol, String ts1, String ts2, String ts3, String pod, String del, String inter1, String inter2, String spclDg, String spclRf, String spclAk, String spclBb, String lane1, String lane2, String lane3, String lane4, String cltOfcCd, String slsOfcCd, String shipper, String iocCd, String vvd, String dterm, String rterm, String rcmdt, String shprNm, String rlaneCd, String hrs) {
		this.rcmdt = rcmdt;
		this.costRoutNo = costRoutNo;
		this.spclAk = spclAk;
		this.por = por;
		this.cltOfcCd = cltOfcCd;
		this.rlaneCd = rlaneCd;
		this.rterm = rterm;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.hrs = hrs;
		this.ibflag = ibflag;
		this.ts3 = ts3;
		this.ts2 = ts2;
		this.ts1 = ts1;
		this.pol = pol;
		this.slsOfcCd = slsOfcCd;
		this.del = del;
		this.shprNm = shprNm;
		this.pod = pod;
		this.iocCd = iocCd;
		this.inter1 = inter1;
		this.lane4 = lane4;
		this.inter2 = inter2;
		this.shipper = shipper;
		this.lane2 = lane2;
		this.lane3 = lane3;
		this.lane1 = lane1;
		this.dterm = dterm;
		this.vvd = vvd;
		this.spclBb = spclBb;
		this.bkgNo = bkgNo;
		this.spclRf = spclRf;
		this.spclDg = spclDg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcmdt", getRcmdt());
		this.hashColumns.put("cost_rout_no", getCostRoutNo());
		this.hashColumns.put("spcl_ak", getSpclAk());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rterm", getRterm());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hrs", getHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts3", getTs3());
		this.hashColumns.put("ts2", getTs2());
		this.hashColumns.put("ts1", getTs1());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("inter1", getInter1());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("inter2", getInter2());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("dterm", getDterm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("spcl_bb", getSpclBb());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("spcl_rf", getSpclRf());
		this.hashColumns.put("spcl_dg", getSpclDg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcmdt", "rcmdt");
		this.hashFields.put("cost_rout_no", "costRoutNo");
		this.hashFields.put("spcl_ak", "spclAk");
		this.hashFields.put("por", "por");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rterm", "rterm");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hrs", "hrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts3", "ts3");
		this.hashFields.put("ts2", "ts2");
		this.hashFields.put("ts1", "ts1");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("inter1", "inter1");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("inter2", "inter2");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("dterm", "dterm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("spcl_bb", "spclBb");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("spcl_rf", "spclRf");
		this.hashFields.put("spcl_dg", "spclDg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcmdt
	 */
	public String getRcmdt() {
		return this.rcmdt;
	}
	
	/**
	 * Column Info
	 * @return costRoutNo
	 */
	public String getCostRoutNo() {
		return this.costRoutNo;
	}
	
	/**
	 * Column Info
	 * @return spclAk
	 */
	public String getSpclAk() {
		return this.spclAk;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
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
	 * @return rterm
	 */
	public String getRterm() {
		return this.rterm;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return hrs
	 */
	public String getHrs() {
		return this.hrs;
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
	 * @return ts3
	 */
	public String getTs3() {
		return this.ts3;
	}
	
	/**
	 * Column Info
	 * @return ts2
	 */
	public String getTs2() {
		return this.ts2;
	}
	
	/**
	 * Column Info
	 * @return ts1
	 */
	public String getTs1() {
		return this.ts1;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return inter1
	 */
	public String getInter1() {
		return this.inter1;
	}
	
	/**
	 * Column Info
	 * @return lane4
	 */
	public String getLane4() {
		return this.lane4;
	}
	
	/**
	 * Column Info
	 * @return inter2
	 */
	public String getInter2() {
		return this.inter2;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}
	
	/**
	 * Column Info
	 * @return lane3
	 */
	public String getLane3() {
		return this.lane3;
	}
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}
	
	/**
	 * Column Info
	 * @return dterm
	 */
	public String getDterm() {
		return this.dterm;
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
	 * @return spclBb
	 */
	public String getSpclBb() {
		return this.spclBb;
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
	 * @return spclRf
	 */
	public String getSpclRf() {
		return this.spclRf;
	}
	
	/**
	 * Column Info
	 * @return spclDg
	 */
	public String getSpclDg() {
		return this.spclDg;
	}
	

	/**
	 * Column Info
	 * @param rcmdt
	 */
	public void setRcmdt(String rcmdt) {
		this.rcmdt = rcmdt;
	}
	
	/**
	 * Column Info
	 * @param costRoutNo
	 */
	public void setCostRoutNo(String costRoutNo) {
		this.costRoutNo = costRoutNo;
	}
	
	/**
	 * Column Info
	 * @param spclAk
	 */
	public void setSpclAk(String spclAk) {
		this.spclAk = spclAk;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
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
	 * @param rterm
	 */
	public void setRterm(String rterm) {
		this.rterm = rterm;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param hrs
	 */
	public void setHrs(String hrs) {
		this.hrs = hrs;
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
	 * @param ts3
	 */
	public void setTs3(String ts3) {
		this.ts3 = ts3;
	}
	
	/**
	 * Column Info
	 * @param ts2
	 */
	public void setTs2(String ts2) {
		this.ts2 = ts2;
	}
	
	/**
	 * Column Info
	 * @param ts1
	 */
	public void setTs1(String ts1) {
		this.ts1 = ts1;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param inter1
	 */
	public void setInter1(String inter1) {
		this.inter1 = inter1;
	}
	
	/**
	 * Column Info
	 * @param lane4
	 */
	public void setLane4(String lane4) {
		this.lane4 = lane4;
	}
	
	/**
	 * Column Info
	 * @param inter2
	 */
	public void setInter2(String inter2) {
		this.inter2 = inter2;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param lane3
	 */
	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	
	/**
	 * Column Info
	 * @param dterm
	 */
	public void setDterm(String dterm) {
		this.dterm = dterm;
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
	 * @param spclBb
	 */
	public void setSpclBb(String spclBb) {
		this.spclBb = spclBb;
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
	 * @param spclRf
	 */
	public void setSpclRf(String spclRf) {
		this.spclRf = spclRf;
	}
	
	/**
	 * Column Info
	 * @param spclDg
	 */
	public void setSpclDg(String spclDg) {
		this.spclDg = spclDg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRcmdt(JSPUtil.getParameter(request, "rcmdt", ""));
		setCostRoutNo(JSPUtil.getParameter(request, "cost_rout_no", ""));
		setSpclAk(JSPUtil.getParameter(request, "spcl_ak", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setCltOfcCd(JSPUtil.getParameter(request, "clt_ofc_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRterm(JSPUtil.getParameter(request, "rterm", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHrs(JSPUtil.getParameter(request, "hrs", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTs3(JSPUtil.getParameter(request, "ts3", ""));
		setTs2(JSPUtil.getParameter(request, "ts2", ""));
		setTs1(JSPUtil.getParameter(request, "ts1", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setInter1(JSPUtil.getParameter(request, "inter1", ""));
		setLane4(JSPUtil.getParameter(request, "lane4", ""));
		setInter2(JSPUtil.getParameter(request, "inter2", ""));
		setShipper(JSPUtil.getParameter(request, "shipper", ""));
		setLane2(JSPUtil.getParameter(request, "lane2", ""));
		setLane3(JSPUtil.getParameter(request, "lane3", ""));
		setLane1(JSPUtil.getParameter(request, "lane1", ""));
		setDterm(JSPUtil.getParameter(request, "dterm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSpclBb(JSPUtil.getParameter(request, "spcl_bb", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSpclRf(JSPUtil.getParameter(request, "spcl_rf", ""));
		setSpclDg(JSPUtil.getParameter(request, "spcl_dg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMultiDimension068ListVO[]
	 */
	public SearchMultiDimension068ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMultiDimension068ListVO[]
	 */
	public SearchMultiDimension068ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMultiDimension068ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcmdt = (JSPUtil.getParameter(request, prefix	+ "rcmdt", length));
			String[] costRoutNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_no", length));
			String[] spclAk = (JSPUtil.getParameter(request, prefix	+ "spcl_ak", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rterm = (JSPUtil.getParameter(request, prefix	+ "rterm", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hrs = (JSPUtil.getParameter(request, prefix	+ "hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ts3 = (JSPUtil.getParameter(request, prefix	+ "ts3", length));
			String[] ts2 = (JSPUtil.getParameter(request, prefix	+ "ts2", length));
			String[] ts1 = (JSPUtil.getParameter(request, prefix	+ "ts1", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] inter1 = (JSPUtil.getParameter(request, prefix	+ "inter1", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix	+ "lane4", length));
			String[] inter2 = (JSPUtil.getParameter(request, prefix	+ "inter2", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix	+ "lane3", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] dterm = (JSPUtil.getParameter(request, prefix	+ "dterm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] spclBb = (JSPUtil.getParameter(request, prefix	+ "spcl_bb", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] spclRf = (JSPUtil.getParameter(request, prefix	+ "spcl_rf", length));
			String[] spclDg = (JSPUtil.getParameter(request, prefix	+ "spcl_dg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMultiDimension068ListVO();
				if (rcmdt[i] != null)
					model.setRcmdt(rcmdt[i]);
				if (costRoutNo[i] != null)
					model.setCostRoutNo(costRoutNo[i]);
				if (spclAk[i] != null)
					model.setSpclAk(spclAk[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rterm[i] != null)
					model.setRterm(rterm[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hrs[i] != null)
					model.setHrs(hrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ts3[i] != null)
					model.setTs3(ts3[i]);
				if (ts2[i] != null)
					model.setTs2(ts2[i]);
				if (ts1[i] != null)
					model.setTs1(ts1[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (inter1[i] != null)
					model.setInter1(inter1[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (inter2[i] != null)
					model.setInter2(inter2[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (lane3[i] != null)
					model.setLane3(lane3[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (dterm[i] != null)
					model.setDterm(dterm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (spclBb[i] != null)
					model.setSpclBb(spclBb[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (spclRf[i] != null)
					model.setSpclRf(spclRf[i]);
				if (spclDg[i] != null)
					model.setSpclDg(spclDg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMultiDimension068ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMultiDimension068ListVO[]
	 */
	public SearchMultiDimension068ListVO[] getSearchMultiDimension068ListVOs(){
		SearchMultiDimension068ListVO[] vos = (SearchMultiDimension068ListVO[])models.toArray(new SearchMultiDimension068ListVO[models.size()]);
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
		this.rcmdt = this.rcmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutNo = this.costRoutNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAk = this.spclAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rterm = this.rterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrs = this.hrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts3 = this.ts3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts2 = this.ts2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts1 = this.ts1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inter1 = this.inter1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inter2 = this.inter2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dterm = this.dterm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBb = this.spclBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRf = this.spclRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclDg = this.spclDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
