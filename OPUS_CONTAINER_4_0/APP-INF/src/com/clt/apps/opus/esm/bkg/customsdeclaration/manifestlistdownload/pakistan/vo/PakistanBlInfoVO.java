/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistanBlInfoVO.java
*@FileTitle : PakistanBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.31 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PakistanBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PakistanBlInfoVO> models = new ArrayList<PakistanBlInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String tsPort2 = null;
	/* Column Info */
	private String tsPort1 = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String vvdNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String aNtfyNm = null;
	/* Column Info */
	private String lastPort = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String tsVvd1 = null;
	/* Column Info */
	private String tsVvd2 = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String aNtfyAddr = null;
	/* Column Info */
	private String totalBl = null;
	/* Column Info */
	private String rdTermCd = null;
	/* Column Info */
	private String voyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PakistanBlInfoVO() {}

	public PakistanBlInfoVO(String ibflag, String pagerows, String chgCd, String ratUtCd, String currCd, String frtTermCd, String chgAmt, String totalBl, String vslCd, String skdVoyNo, String skdDirCd, String vvdNm, String voyCd, String bkgNo, String blNo, String shprNm, String shprAddr, String cneeNm, String cneeAddr, String ntfyNm, String ntfyAddr, String aNtfyNm, String aNtfyAddr, String polCd, String podCd, String delCd, String lastPort, String tsPort1, String tsVvd1, String tsPort2, String tsVvd2, String rdTermCd, String oblIssDt, String cstmsDesc, String mkDesc, String cmdtDesc) {
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.cneeAddr = cneeAddr;
		this.tsPort2 = tsPort2;
		this.tsPort1 = tsPort1;
		this.oblIssDt = oblIssDt;
		this.mkDesc = mkDesc;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.vvdNm = vvdNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.shprAddr = shprAddr;
		this.cstmsDesc = cstmsDesc;
		this.chgAmt = chgAmt;
		this.shprNm = shprNm;
		this.ntfyAddr = ntfyAddr;
		this.aNtfyNm = aNtfyNm;
		this.lastPort = lastPort;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.tsVvd1 = tsVvd1;
		this.tsVvd2 = tsVvd2;
		this.ratUtCd = ratUtCd;
		this.ntfyNm = ntfyNm;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.cmdtDesc = cmdtDesc;
		this.aNtfyAddr = aNtfyAddr;
		this.totalBl = totalBl;
		this.rdTermCd = rdTermCd;
		this.voyCd = voyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("ts_port2", getTsPort2());
		this.hashColumns.put("ts_port1", getTsPort1());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("a_ntfy_nm", getANtfyNm());
		this.hashColumns.put("last_port", getLastPort());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ts_vvd1", getTsVvd1());
		this.hashColumns.put("ts_vvd2", getTsVvd2());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("a_ntfy_addr", getANtfyAddr());
		this.hashColumns.put("total_bl", getTotalBl());
		this.hashColumns.put("rd_term_cd", getRdTermCd());
		this.hashColumns.put("voy_cd", getVoyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("ts_port2", "tsPort2");
		this.hashFields.put("ts_port1", "tsPort1");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("a_ntfy_nm", "aNtfyNm");
		this.hashFields.put("last_port", "lastPort");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ts_vvd1", "tsVvd1");
		this.hashFields.put("ts_vvd2", "tsVvd2");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("a_ntfy_addr", "aNtfyAddr");
		this.hashFields.put("total_bl", "totalBl");
		this.hashFields.put("rd_term_cd", "rdTermCd");
		this.hashFields.put("voy_cd", "voyCd");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return tsPort2
	 */
	public String getTsPort2() {
		return this.tsPort2;
	}
	
	/**
	 * Column Info
	 * @return tsPort1
	 */
	public String getTsPort1() {
		return this.tsPort1;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
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
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return aNtfyNm
	 */
	public String getANtfyNm() {
		return this.aNtfyNm;
	}
	
	/**
	 * Column Info
	 * @return lastPort
	 */
	public String getLastPort() {
		return this.lastPort;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return tsVvd1
	 */
	public String getTsVvd1() {
		return this.tsVvd1;
	}
	
	/**
	 * Column Info
	 * @return tsVvd2
	 */
	public String getTsVvd2() {
		return this.tsVvd2;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return aNtfyAddr
	 */
	public String getANtfyAddr() {
		return this.aNtfyAddr;
	}
	
	/**
	 * Column Info
	 * @return totalBl
	 */
	public String getTotalBl() {
		return this.totalBl;
	}
	
	/**
	 * Column Info
	 * @return rdTermCd
	 */
	public String getRdTermCd() {
		return this.rdTermCd;
	}
	
	/**
	 * Column Info
	 * @return voyCd
	 */
	public String getVoyCd() {
		return this.voyCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param tsPort2
	 */
	public void setTsPort2(String tsPort2) {
		this.tsPort2 = tsPort2;
	}
	
	/**
	 * Column Info
	 * @param tsPort1
	 */
	public void setTsPort1(String tsPort1) {
		this.tsPort1 = tsPort1;
	}
	
	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
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
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param aNtfyNm
	 */
	public void setANtfyNm(String aNtfyNm) {
		this.aNtfyNm = aNtfyNm;
	}
	
	/**
	 * Column Info
	 * @param lastPort
	 */
	public void setLastPort(String lastPort) {
		this.lastPort = lastPort;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param tsVvd1
	 */
	public void setTsVvd1(String tsVvd1) {
		this.tsVvd1 = tsVvd1;
	}
	
	/**
	 * Column Info
	 * @param tsVvd2
	 */
	public void setTsVvd2(String tsVvd2) {
		this.tsVvd2 = tsVvd2;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param aNtfyAddr
	 */
	public void setANtfyAddr(String aNtfyAddr) {
		this.aNtfyAddr = aNtfyAddr;
	}
	
	/**
	 * Column Info
	 * @param totalBl
	 */
	public void setTotalBl(String totalBl) {
		this.totalBl = totalBl;
	}
	
	/**
	 * Column Info
	 * @param rdTermCd
	 */
	public void setRdTermCd(String rdTermCd) {
		this.rdTermCd = rdTermCd;
	}
	
	/**
	 * Column Info
	 * @param voyCd
	 */
	public void setVoyCd(String voyCd) {
		this.voyCd = voyCd;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setTsPort2(JSPUtil.getParameter(request, prefix + "ts_port2", ""));
		setTsPort1(JSPUtil.getParameter(request, prefix + "ts_port1", ""));
		setOblIssDt(JSPUtil.getParameter(request, prefix + "obl_iss_dt", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setVvdNm(JSPUtil.getParameter(request, prefix + "vvd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setANtfyNm(JSPUtil.getParameter(request, prefix + "a_ntfy_nm", ""));
		setLastPort(JSPUtil.getParameter(request, prefix + "last_port", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTsVvd1(JSPUtil.getParameter(request, prefix + "ts_vvd1", ""));
		setTsVvd2(JSPUtil.getParameter(request, prefix + "ts_vvd2", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setANtfyAddr(JSPUtil.getParameter(request, prefix + "a_ntfy_addr", ""));
		setTotalBl(JSPUtil.getParameter(request, prefix + "total_bl", ""));
		setRdTermCd(JSPUtil.getParameter(request, prefix + "rd_term_cd", ""));
		setVoyCd(JSPUtil.getParameter(request, prefix + "voy_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PakistanBlInfoVO[]
	 */
	public PakistanBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PakistanBlInfoVO[]
	 */
	public PakistanBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PakistanBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] tsPort2 = (JSPUtil.getParameter(request, prefix	+ "ts_port2", length));
			String[] tsPort1 = (JSPUtil.getParameter(request, prefix	+ "ts_port1", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] aNtfyNm = (JSPUtil.getParameter(request, prefix	+ "a_ntfy_nm", length));
			String[] lastPort = (JSPUtil.getParameter(request, prefix	+ "last_port", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tsVvd1 = (JSPUtil.getParameter(request, prefix	+ "ts_vvd1", length));
			String[] tsVvd2 = (JSPUtil.getParameter(request, prefix	+ "ts_vvd2", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] aNtfyAddr = (JSPUtil.getParameter(request, prefix	+ "a_ntfy_addr", length));
			String[] totalBl = (JSPUtil.getParameter(request, prefix	+ "total_bl", length));
			String[] rdTermCd = (JSPUtil.getParameter(request, prefix	+ "rd_term_cd", length));
			String[] voyCd = (JSPUtil.getParameter(request, prefix	+ "voy_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PakistanBlInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (tsPort2[i] != null)
					model.setTsPort2(tsPort2[i]);
				if (tsPort1[i] != null)
					model.setTsPort1(tsPort1[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (aNtfyNm[i] != null)
					model.setANtfyNm(aNtfyNm[i]);
				if (lastPort[i] != null)
					model.setLastPort(lastPort[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (tsVvd1[i] != null)
					model.setTsVvd1(tsVvd1[i]);
				if (tsVvd2[i] != null)
					model.setTsVvd2(tsVvd2[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (aNtfyAddr[i] != null)
					model.setANtfyAddr(aNtfyAddr[i]);
				if (totalBl[i] != null)
					model.setTotalBl(totalBl[i]);
				if (rdTermCd[i] != null)
					model.setRdTermCd(rdTermCd[i]);
				if (voyCd[i] != null)
					model.setVoyCd(voyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPakistanBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PakistanBlInfoVO[]
	 */
	public PakistanBlInfoVO[] getPakistanBlInfoVOs(){
		PakistanBlInfoVO[] vos = (PakistanBlInfoVO[])models.toArray(new PakistanBlInfoVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort2 = this.tsPort2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPort1 = this.tsPort1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aNtfyNm = this.aNtfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPort = this.lastPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvd1 = this.tsVvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsVvd2 = this.tsVvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aNtfyAddr = this.aNtfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBl = this.totalBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTermCd = this.rdTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyCd = this.voyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
