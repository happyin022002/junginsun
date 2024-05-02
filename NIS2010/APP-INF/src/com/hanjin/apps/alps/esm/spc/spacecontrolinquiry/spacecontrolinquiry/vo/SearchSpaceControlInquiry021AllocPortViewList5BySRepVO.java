/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchSpaceControlInquiry021AllocPortViewList5BySRepVO.java
*@FileTitle : SearchSpaceControlInquiry021AllocPortViewList5BySRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiry021AllocPortViewList5BySRepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> models = new ArrayList<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO>();
	
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String bkg20ftQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fcast20ftQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String alocQty = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String pfmcTtl = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String qtaQty = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bseDt = null;
	/* Column Info */
	private String fcast40ftQty = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String pfmc20ft = null;
	/* Column Info */
	private String pfmc40ft = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String gid = null;
	/* Column Info */
	private String gid2 = null;
	/* Column Info */
	private String bkg40ftQty = null;
	/* Column Info */
	private String slsRgnOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiry021AllocPortViewList5BySRepVO() {}

	public SearchSpaceControlInquiry021AllocPortViewList5BySRepVO(String ibflag, String pagerows, String gid, String lvl, String bseDt, String slsRgnOfcCd, String srepCd, String srepNm, String custCntCd, String custSeq, String ctrtCustCntCd, String ctrtCustSeq, String polYdCd, String podYdCd, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String alocQty, String qtaQty, String fcastTtlQty, String fcast20ftQty, String fcast40ftQty, String bkgTtlQty, String bkg20ftQty, String bkg40ftQty, String pfmcTtl, String pfmc20ft, String pfmc40ft, String rnum, String gid2) {
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.vslCd = vslCd;
		this.rlaneCd = rlaneCd;
		this.srepCd = srepCd;
		this.bkg20ftQty = bkg20ftQty;
		this.pagerows = pagerows;
		this.fcast20ftQty = fcast20ftQty;
		this.ibflag = ibflag;
		this.fcastTtlQty = fcastTtlQty;
		this.alocQty = alocQty;
		this.rnum = rnum;
		this.srepNm = srepNm;
		this.pfmcTtl = pfmcTtl;
		this.podYdCd = podYdCd;
		this.custCntCd = custCntCd;
		this.qtaQty = qtaQty;
		this.ctrtCustSeq = ctrtCustSeq;
		this.bkgTtlQty = bkgTtlQty;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.bseDt = bseDt;
		this.fcast40ftQty = fcast40ftQty;
		this.lvl = lvl;
		this.pfmc20ft = pfmc20ft;
		this.pfmc40ft = pfmc40ft;
		this.polYdCd = polYdCd;
		this.gid = gid;
		this.gid2 = gid2;
		this.bkg40ftQty = bkg40ftQty;
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("bkg_20ft_qty", getBkg20ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fcast_20ft_qty", getFcast20ftQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("aloc_qty", getAlocQty());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("pfmc_ttl", getPfmcTtl());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("qta_qty", getQtaQty());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bse_dt", getBseDt());
		this.hashColumns.put("fcast_40ft_qty", getFcast40ftQty());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("pfmc_20ft", getPfmc20ft());
		this.hashColumns.put("pfmc_40ft", getPfmc40ft());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("gid", getGid());
		this.hashColumns.put("gid2", getGid2());
		this.hashColumns.put("bkg_40ft_qty", getBkg40ftQty());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("bkg_20ft_qty", "bkg20ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fcast_20ft_qty", "fcast20ftQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("aloc_qty", "alocQty");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("pfmc_ttl", "pfmcTtl");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("qta_qty", "qtaQty");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("fcast_40ft_qty", "fcast40ftQty");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("pfmc_20ft", "pfmc20ft");
		this.hashFields.put("pfmc_40ft", "pfmc40ft");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("gid", "gid");
		this.hashFields.put("gid2", "gid2");
		this.hashFields.put("bkg_40ft_qty", "bkg40ftQty");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return bkg20ftQty
	 */
	public String getBkg20ftQty() {
		return this.bkg20ftQty;
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
	 * @return fcast20ftQty
	 */
	public String getFcast20ftQty() {
		return this.fcast20ftQty;
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
	 * @return fcastTtlQty
	 */
	public String getFcastTtlQty() {
		return this.fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @return alocQty
	 */
	public String getAlocQty() {
		return this.alocQty;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return pfmcTtl
	 */
	public String getPfmcTtl() {
		return this.pfmcTtl;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return qtaQty
	 */
	public String getQtaQty() {
		return this.qtaQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return bseDt
	 */
	public String getBseDt() {
		return this.bseDt;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftQty
	 */
	public String getFcast40ftQty() {
		return this.fcast40ftQty;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return pfmc20ft
	 */
	public String getPfmc20ft() {
		return this.pfmc20ft;
	}
	
	/**
	 * Column Info
	 * @return pfmc40ft
	 */
	public String getPfmc40ft() {
		return this.pfmc40ft;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return gid
	 */
	public String getGid() {
		return this.gid;
	}
	
	/**
	 * Column Info
	 * @return gid
	 */
	public String getGid2() {
		return this.gid2;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftQty
	 */
	public String getBkg40ftQty() {
		return this.bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	

	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param bkg20ftQty
	 */
	public void setBkg20ftQty(String bkg20ftQty) {
		this.bkg20ftQty = bkg20ftQty;
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
	 * @param fcast20ftQty
	 */
	public void setFcast20ftQty(String fcast20ftQty) {
		this.fcast20ftQty = fcast20ftQty;
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
	 * @param fcastTtlQty
	 */
	public void setFcastTtlQty(String fcastTtlQty) {
		this.fcastTtlQty = fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @param alocQty
	 */
	public void setAlocQty(String alocQty) {
		this.alocQty = alocQty;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param pfmcTtl
	 */
	public void setPfmcTtl(String pfmcTtl) {
		this.pfmcTtl = pfmcTtl;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param qtaQty
	 */
	public void setQtaQty(String qtaQty) {
		this.qtaQty = qtaQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param bseDt
	 */
	public void setBseDt(String bseDt) {
		this.bseDt = bseDt;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftQty
	 */
	public void setFcast40ftQty(String fcast40ftQty) {
		this.fcast40ftQty = fcast40ftQty;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param pfmc20ft
	 */
	public void setPfmc20ft(String pfmc20ft) {
		this.pfmc20ft = pfmc20ft;
	}
	
	/**
	 * Column Info
	 * @param pfmc40ft
	 */
	public void setPfmc40ft(String pfmc40ft) {
		this.pfmc40ft = pfmc40ft;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param gid
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	/**
	 * Column Info
	 * @param gid2
	 */
	public void setGid2(String gid2) {
		this.gid2 = gid2;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftQty
	 */
	public void setBkg40ftQty(String bkg40ftQty) {
		this.bkg40ftQty = bkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
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
		setCtrtCustCntCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_cnt_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setBkg20ftQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFcast20ftQty(JSPUtil.getParameter(request, prefix + "fcast_20ft_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, prefix + "fcast_ttl_qty", ""));
		setAlocQty(JSPUtil.getParameter(request, prefix + "aloc_qty", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setPfmcTtl(JSPUtil.getParameter(request, prefix + "pfmc_ttl", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setQtaQty(JSPUtil.getParameter(request, prefix + "qta_qty", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, prefix + "ctrt_cust_seq", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, prefix + "bkg_ttl_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBseDt(JSPUtil.getParameter(request, prefix + "bse_dt", ""));
		setFcast40ftQty(JSPUtil.getParameter(request, prefix + "fcast_40ft_qty", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setPfmc20ft(JSPUtil.getParameter(request, prefix + "pfmc_20ft", ""));
		setPfmc40ft(JSPUtil.getParameter(request, prefix + "pfmc_40ft", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setGid(JSPUtil.getParameter(request, prefix + "gid", ""));
		setGid2(JSPUtil.getParameter(request, prefix + "gid2", ""));
		setBkg40ftQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_qty", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiry021AllocPortViewList5BySRepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] bkg20ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fcast20ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_20ft_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcastTtlQty = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty", length));
			String[] alocQty = (JSPUtil.getParameter(request, prefix	+ "aloc_qty", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] pfmcTtl = (JSPUtil.getParameter(request, prefix	+ "pfmc_ttl", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] qtaQty = (JSPUtil.getParameter(request, prefix	+ "qta_qty", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bseDt = (JSPUtil.getParameter(request, prefix	+ "bse_dt", length));
			String[] fcast40ftQty = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_qty", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] pfmc20ft = (JSPUtil.getParameter(request, prefix	+ "pfmc_20ft", length));
			String[] pfmc40ft = (JSPUtil.getParameter(request, prefix	+ "pfmc_40ft", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] gid = (JSPUtil.getParameter(request, prefix	+ "gid", length));
			String[] gid2 = (JSPUtil.getParameter(request, prefix	+ "gid2", length));
			String[] bkg40ftQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_qty", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiry021AllocPortViewList5BySRepVO();
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (bkg20ftQty[i] != null)
					model.setBkg20ftQty(bkg20ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fcast20ftQty[i] != null)
					model.setFcast20ftQty(fcast20ftQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (alocQty[i] != null)
					model.setAlocQty(alocQty[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (pfmcTtl[i] != null)
					model.setPfmcTtl(pfmcTtl[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (qtaQty[i] != null)
					model.setQtaQty(qtaQty[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bseDt[i] != null)
					model.setBseDt(bseDt[i]);
				if (fcast40ftQty[i] != null)
					model.setFcast40ftQty(fcast40ftQty[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (pfmc20ft[i] != null)
					model.setPfmc20ft(pfmc20ft[i]);
				if (pfmc40ft[i] != null)
					model.setPfmc40ft(pfmc40ft[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (gid[i] != null)
					model.setGid(gid[i]);
				if (gid2[i] != null)
					model.setGid2(gid2[i]);
				if (bkg40ftQty[i] != null)
					model.setBkg40ftQty(bkg40ftQty[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiry021AllocPortViewList5BySRepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[]
	 */
	public SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[] getSearchSpaceControlInquiry021AllocPortViewList5BySRepVOs(){
		SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[] vos = (SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[])models.toArray(new SearchSpaceControlInquiry021AllocPortViewList5BySRepVO[models.size()]);
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
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftQty = this.bkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast20ftQty = this.fcast20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocQty = this.alocQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmcTtl = this.pfmcTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaQty = this.qtaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt = this.bseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftQty = this.fcast40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc20ft = this.pfmc20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmc40ft = this.pfmc40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gid = this.gid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftQty = this.bkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
