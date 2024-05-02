/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OTSForApplyAdjustVO.java
*@FileTitle : OTSForApplyAdjustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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

public class OTSForApplyAdjustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OTSForApplyAdjustVO> models = new ArrayList<OTSForApplyAdjustVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bilToCustCntCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String bkgIoBndCd = null;
	/* Column Info */
	private String tjSrcNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgBalAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String otsSrcCd = null;
	/* Column Info */
	private String otsHisSeq = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String shpToCustSeq = null;
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String bilToCustSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String shpToCustCntCd = null;
	/* Column Info */
	private String otsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OTSForApplyAdjustVO() {}

	public OTSForApplyAdjustVO(String ibflag, String pagerows, String ifNo, String rhqCd, String otsOfcCd, String blNo, String invNo, String otsHisSeq, String currCd, String otsSrcCd, String invOfcCd, String shpToCustCntCd, String shpToCustSeq, String bilToCustCntCd, String bilToCustSeq, String vslCd, String skdVoyNo, String dirCd, String svcScpCd, String xchRtTpCd, String loclXchRt, String usdXchRt, String bkgIoBndCd, String xchRtDt, String polCd, String podCd, String chgTpCd, String chgBalAmt, String glDt, String tjSrcNm, String dpSeq) {
		this.dpSeq = dpSeq;
		this.xchRtDt = xchRtDt;
		this.vslCd = vslCd;
		this.xchRtTpCd = xchRtTpCd;
		this.glDt = glDt;
		this.chgTpCd = chgTpCd;
		this.currCd = currCd;
		this.bilToCustCntCd = bilToCustCntCd;
		this.svcScpCd = svcScpCd;
		this.usdXchRt = usdXchRt;
		this.bkgIoBndCd = bkgIoBndCd;
		this.tjSrcNm = tjSrcNm;
		this.blNo = blNo;
		this.chgBalAmt = chgBalAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.dirCd = dirCd;
		this.otsSrcCd = otsSrcCd;
		this.otsHisSeq = otsHisSeq;
		this.invOfcCd = invOfcCd;
		this.loclXchRt = loclXchRt;
		this.shpToCustSeq = shpToCustSeq;
		this.ifNo = ifNo;
		this.rhqCd = rhqCd;
		this.bilToCustSeq = bilToCustSeq;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.invNo = invNo;
		this.shpToCustCntCd = shpToCustCntCd;
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("bkg_io_bnd_cd", getBkgIoBndCd());
		this.hashColumns.put("tj_src_nm", getTjSrcNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_bal_amt", getChgBalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());
		this.hashColumns.put("ots_his_seq", getOtsHisSeq());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("shp_to_cust_seq", getShpToCustSeq());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("shp_to_cust_cnt_cd", getShpToCustCntCd());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("bkg_io_bnd_cd", "bkgIoBndCd");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_bal_amt", "chgBalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("ots_his_seq", "otsHisSeq");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("shp_to_cust_seq", "shpToCustSeq");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("shp_to_cust_cnt_cd", "shpToCustCntCd");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return xchRtDt
	 */
	public String getXchRtDt() {
		return this.xchRtDt;
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
	 * @return xchRtTpCd
	 */
	public String getXchRtTpCd() {
		return this.xchRtTpCd;
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
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
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
	 * @return bilToCustCntCd
	 */
	public String getBilToCustCntCd() {
		return this.bilToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
	}
	
	/**
	 * Column Info
	 * @return bkgIoBndCd
	 */
	public String getBkgIoBndCd() {
		return this.bkgIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return tjSrcNm
	 */
	public String getTjSrcNm() {
		return this.tjSrcNm;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return chgBalAmt
	 */
	public String getChgBalAmt() {
		return this.chgBalAmt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return otsSrcCd
	 */
	public String getOtsSrcCd() {
		return this.otsSrcCd;
	}
	
	/**
	 * Column Info
	 * @return otsHisSeq
	 */
	public String getOtsHisSeq() {
		return this.otsHisSeq;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return shpToCustSeq
	 */
	public String getShpToCustSeq() {
		return this.shpToCustSeq;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return bilToCustSeq
	 */
	public String getBilToCustSeq() {
		return this.bilToCustSeq;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return shpToCustCntCd
	 */
	public String getShpToCustCntCd() {
		return this.shpToCustCntCd;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param xchRtDt
	 */
	public void setXchRtDt(String xchRtDt) {
		this.xchRtDt = xchRtDt;
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
	 * @param xchRtTpCd
	 */
	public void setXchRtTpCd(String xchRtTpCd) {
		this.xchRtTpCd = xchRtTpCd;
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
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
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
	 * @param bilToCustCntCd
	 */
	public void setBilToCustCntCd(String bilToCustCntCd) {
		this.bilToCustCntCd = bilToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}
	
	/**
	 * Column Info
	 * @param bkgIoBndCd
	 */
	public void setBkgIoBndCd(String bkgIoBndCd) {
		this.bkgIoBndCd = bkgIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param tjSrcNm
	 */
	public void setTjSrcNm(String tjSrcNm) {
		this.tjSrcNm = tjSrcNm;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param chgBalAmt
	 */
	public void setChgBalAmt(String chgBalAmt) {
		this.chgBalAmt = chgBalAmt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param otsSrcCd
	 */
	public void setOtsSrcCd(String otsSrcCd) {
		this.otsSrcCd = otsSrcCd;
	}
	
	/**
	 * Column Info
	 * @param otsHisSeq
	 */
	public void setOtsHisSeq(String otsHisSeq) {
		this.otsHisSeq = otsHisSeq;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param shpToCustSeq
	 */
	public void setShpToCustSeq(String shpToCustSeq) {
		this.shpToCustSeq = shpToCustSeq;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param bilToCustSeq
	 */
	public void setBilToCustSeq(String bilToCustSeq) {
		this.bilToCustSeq = bilToCustSeq;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param shpToCustCntCd
	 */
	public void setShpToCustCntCd(String shpToCustCntCd) {
		this.shpToCustCntCd = shpToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setXchRtDt(JSPUtil.getParameter(request, prefix + "xch_rt_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setXchRtTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_tp_cd", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request, prefix + "bil_to_cust_cnt_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request, prefix + "usd_xch_rt", ""));
		setBkgIoBndCd(JSPUtil.getParameter(request, prefix + "bkg_io_bnd_cd", ""));
		setTjSrcNm(JSPUtil.getParameter(request, prefix + "tj_src_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChgBalAmt(JSPUtil.getParameter(request, prefix + "chg_bal_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setOtsSrcCd(JSPUtil.getParameter(request, prefix + "ots_src_cd", ""));
		setOtsHisSeq(JSPUtil.getParameter(request, prefix + "ots_his_seq", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setLoclXchRt(JSPUtil.getParameter(request, prefix + "locl_xch_rt", ""));
		setShpToCustSeq(JSPUtil.getParameter(request, prefix + "shp_to_cust_seq", ""));
		setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request, prefix + "bil_to_cust_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setShpToCustCntCd(JSPUtil.getParameter(request, prefix + "shp_to_cust_cnt_cd", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OTSForApplyAdjustVO[]
	 */
	public OTSForApplyAdjustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OTSForApplyAdjustVO[]
	 */
	public OTSForApplyAdjustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OTSForApplyAdjustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_cd", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bilToCustCntCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_cnt_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] bkgIoBndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_io_bnd_cd", length));
			String[] tjSrcNm = (JSPUtil.getParameter(request, prefix	+ "tj_src_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgBalAmt = (JSPUtil.getParameter(request, prefix	+ "chg_bal_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] otsSrcCd = (JSPUtil.getParameter(request, prefix	+ "ots_src_cd", length));
			String[] otsHisSeq = (JSPUtil.getParameter(request, prefix	+ "ots_his_seq", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] shpToCustSeq = (JSPUtil.getParameter(request, prefix	+ "shp_to_cust_seq", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] bilToCustSeq = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] shpToCustCntCd = (JSPUtil.getParameter(request, prefix	+ "shp_to_cust_cnt_cd", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OTSForApplyAdjustVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bilToCustCntCd[i] != null)
					model.setBilToCustCntCd(bilToCustCntCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (bkgIoBndCd[i] != null)
					model.setBkgIoBndCd(bkgIoBndCd[i]);
				if (tjSrcNm[i] != null)
					model.setTjSrcNm(tjSrcNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgBalAmt[i] != null)
					model.setChgBalAmt(chgBalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (otsSrcCd[i] != null)
					model.setOtsSrcCd(otsSrcCd[i]);
				if (otsHisSeq[i] != null)
					model.setOtsHisSeq(otsHisSeq[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (shpToCustSeq[i] != null)
					model.setShpToCustSeq(shpToCustSeq[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (bilToCustSeq[i] != null)
					model.setBilToCustSeq(bilToCustSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (shpToCustCntCd[i] != null)
					model.setShpToCustCntCd(shpToCustCntCd[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOTSForApplyAdjustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OTSForApplyAdjustVO[]
	 */
	public OTSForApplyAdjustVO[] getOTSForApplyAdjustVOs(){
		OTSForApplyAdjustVO[] vos = (OTSForApplyAdjustVO[])models.toArray(new OTSForApplyAdjustVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt = this.xchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd = this.xchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd = this.bilToCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoBndCd = this.bkgIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm = this.tjSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgBalAmt = this.chgBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd = this.otsSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisSeq = this.otsHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustSeq = this.shpToCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq = this.bilToCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCntCd = this.shpToCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
