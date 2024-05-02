/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TSListBy1st2ndVVDListVO.java
*@FileTitle : TSListBy1st2ndVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.05.25 김태경 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.09.14 변종건 [CHM-201005873-01]	 T/S List by 1st VSL & 2nd VSL 엑셀 다운 폼 수정 요청 (Location Full Name 추가)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSListBy1st2ndVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSListBy1st2ndVVDListVO> models = new ArrayList<TSListBy1st2ndVVDListVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String tsRmk = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String disc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String terminal = null;
	/* Column Info */
	private String nextlane = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String bsCd = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String firstetb = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String nextetd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String firstvvd = null;
	/* Column Info */
	private String nextvvd = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String firstlane = null;
	/* Column Info */
	private String cntrVol = null;
	/* Column Info */
	private String auth = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String delNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSListBy1st2ndVVDListVO() {}

	public TSListBy1st2ndVVDListVO(String ibflag, String pagerows, String etb, String rmk, String tsRmk, String delCd, String vslNm, String orgYdCd, String blNo, String cmdtNm, String disc, String podCd, String bkgNo, String podNodCd, String polCd, String wgt, String cntrNo, String cntrTpszCd, String firstvvd, String stwgCd, String nextvvd, String special, String cntrSealNo, String auth, String cntrVol, String opCd, String firstlane, String nextlane, String firstetb, String nextetd, String terminal, String bsCd, String teu, String feu, String polNm, String podNm, String delNm) {
		this.etb = etb;
		this.tsRmk = tsRmk;
		this.blNo = blNo;
		this.disc = disc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.terminal = terminal;
		this.nextlane = nextlane;
		this.wgt = wgt;
		this.cntrTpszCd = cntrTpszCd;
		this.stwgCd = stwgCd;
		this.bsCd = bsCd;
		this.rmk = rmk;
		this.feu = feu;
		this.firstetb = firstetb;
		this.delCd = delCd;
		this.vslNm = vslNm;
		this.orgYdCd = orgYdCd;
		this.cmdtNm = cmdtNm;
		this.nextetd = nextetd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.cntrNo = cntrNo;
		this.opCd = opCd;
		this.firstvvd = firstvvd;
		this.nextvvd = nextvvd;
		this.special = special;
		this.cntrSealNo = cntrSealNo;
		this.teu = teu;
		this.firstlane = firstlane;
		this.cntrVol = cntrVol;
		this.auth = auth;
		this.polNm = polNm;
		this.podNm = podNm;
		this.delNm = delNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("ts_rmk", getTsRmk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("disc", getDisc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("terminal", getTerminal());
		this.hashColumns.put("nextlane", getNextlane());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("bs_cd", getBsCd());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("firstetb", getFirstetb());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("nextetd", getNextetd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("firstvvd", getFirstvvd());
		this.hashColumns.put("nextvvd", getNextvvd());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("firstlane", getFirstlane());
		this.hashColumns.put("cntr_vol", getCntrVol());
		this.hashColumns.put("auth", getAuth());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("del_nm", getDelNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("ts_rmk", "tsRmk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("disc", "disc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("terminal", "terminal");
		this.hashFields.put("nextlane", "nextlane");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("bs_cd", "bsCd");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("firstetb", "firstetb");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("nextetd", "nextetd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("firstvvd", "firstvvd");
		this.hashFields.put("nextvvd", "nextvvd");
		this.hashFields.put("special", "special");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("firstlane", "firstlane");
		this.hashFields.put("cntr_vol", "cntrVol");
		this.hashFields.put("auth", "auth");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("del_nm", "delNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return tsRmk
	 */
	public String getTsRmk() {
		return this.tsRmk;
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
	 * @return disc
	 */
	public String getDisc() {
		return this.disc;
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
	 * @return terminal
	 */
	public String getTerminal() {
		return this.terminal;
	}
	
	/**
	 * Column Info
	 * @return nextlane
	 */
	public String getNextlane() {
		return this.nextlane;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
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
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return bsCd
	 */
	public String getBsCd() {
		return this.bsCd;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return firstetb
	 */
	public String getFirstetb() {
		return this.firstetb;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return nextetd
	 */
	public String getNextetd() {
		return this.nextetd;
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
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return firstvvd
	 */
	public String getFirstvvd() {
		return this.firstvvd;
	}
	
	/**
	 * Column Info
	 * @return nextvvd
	 */
	public String getNextvvd() {
		return this.nextvvd;
	}
	
	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return firstlane
	 */
	public String getFirstlane() {
		return this.firstlane;
	}
	
	/**
	 * Column Info
	 * @return cntrVol
	 */
	public String getCntrVol() {
		return this.cntrVol;
	}
	
	/**
	 * Column Info
	 * @return auth
	 */
	public String getAuth() {
		return this.auth;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param tsRmk
	 */
	public void setTsRmk(String tsRmk) {
		this.tsRmk = tsRmk;
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
	 * @param disc
	 */
	public void setDisc(String disc) {
		this.disc = disc;
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
	 * @param terminal
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	
	/**
	 * Column Info
	 * @param nextlane
	 */
	public void setNextlane(String nextlane) {
		this.nextlane = nextlane;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
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
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param bsCd
	 */
	public void setBsCd(String bsCd) {
		this.bsCd = bsCd;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param firstetb
	 */
	public void setFirstetb(String firstetb) {
		this.firstetb = firstetb;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param nextetd
	 */
	public void setNextetd(String nextetd) {
		this.nextetd = nextetd;
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
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param firstvvd
	 */
	public void setFirstvvd(String firstvvd) {
		this.firstvvd = firstvvd;
	}
	
	/**
	 * Column Info
	 * @param nextvvd
	 */
	public void setNextvvd(String nextvvd) {
		this.nextvvd = nextvvd;
	}
	
	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param firstlane
	 */
	public void setFirstlane(String firstlane) {
		this.firstlane = firstlane;
	}
	
	/**
	 * Column Info
	 * @param cntrVol
	 */
	public void setCntrVol(String cntrVol) {
		this.cntrVol = cntrVol;
	}
	
	/**
	 * Column Info
	 * @param auth
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.polNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
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
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setTsRmk(JSPUtil.getParameter(request, prefix + "ts_rmk", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDisc(JSPUtil.getParameter(request, prefix + "disc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTerminal(JSPUtil.getParameter(request, prefix + "terminal", ""));
		setNextlane(JSPUtil.getParameter(request, prefix + "nextlane", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setBsCd(JSPUtil.getParameter(request, prefix + "bs_cd", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setFirstetb(JSPUtil.getParameter(request, prefix + "firstetb", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setNextetd(JSPUtil.getParameter(request, prefix + "nextetd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOpCd(JSPUtil.getParameter(request, prefix + "op_cd", ""));
		setFirstvvd(JSPUtil.getParameter(request, prefix + "firstvvd", ""));
		setNextvvd(JSPUtil.getParameter(request, prefix + "nextvvd", ""));
		setSpecial(JSPUtil.getParameter(request, prefix + "special", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setFirstlane(JSPUtil.getParameter(request, prefix + "firstlane", ""));
		setCntrVol(JSPUtil.getParameter(request, prefix + "cntr_vol", ""));
		setAuth(JSPUtil.getParameter(request, prefix + "auth", ""));
		setPolNm(JSPUtil.getParameter(request, "pol_nm", ""));
		setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
		setDelNm(JSPUtil.getParameter(request, "del_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSListBy1st2ndVVDListVO[]
	 */
	public TSListBy1st2ndVVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSListBy1st2ndVVDListVO[]
	 */
	public TSListBy1st2ndVVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSListBy1st2ndVVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] tsRmk = (JSPUtil.getParameter(request, prefix	+ "ts_rmk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] disc = (JSPUtil.getParameter(request, prefix	+ "disc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] terminal = (JSPUtil.getParameter(request, prefix	+ "terminal", length));
			String[] nextlane = (JSPUtil.getParameter(request, prefix	+ "nextlane", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] bsCd = (JSPUtil.getParameter(request, prefix	+ "bs_cd", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] firstetb = (JSPUtil.getParameter(request, prefix	+ "firstetb", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] nextetd = (JSPUtil.getParameter(request, prefix	+ "nextetd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] firstvvd = (JSPUtil.getParameter(request, prefix	+ "firstvvd", length));
			String[] nextvvd = (JSPUtil.getParameter(request, prefix	+ "nextvvd", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] firstlane = (JSPUtil.getParameter(request, prefix	+ "firstlane", length));
			String[] cntrVol = (JSPUtil.getParameter(request, prefix	+ "cntr_vol", length));
			String[] auth = (JSPUtil.getParameter(request, prefix	+ "auth", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm".trim(), length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm".trim(), length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TSListBy1st2ndVVDListVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (tsRmk[i] != null)
					model.setTsRmk(tsRmk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (disc[i] != null)
					model.setDisc(disc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (terminal[i] != null)
					model.setTerminal(terminal[i]);
				if (nextlane[i] != null)
					model.setNextlane(nextlane[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (bsCd[i] != null)
					model.setBsCd(bsCd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (firstetb[i] != null)
					model.setFirstetb(firstetb[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (nextetd[i] != null)
					model.setNextetd(nextetd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (firstvvd[i] != null)
					model.setFirstvvd(firstvvd[i]);
				if (nextvvd[i] != null)
					model.setNextvvd(nextvvd[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (firstlane[i] != null)
					model.setFirstlane(firstlane[i]);
				if (cntrVol[i] != null)
					model.setCntrVol(cntrVol[i]);
				if (auth[i] != null)
					model.setAuth(auth[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSListBy1st2ndVVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSListBy1st2ndVVDListVO[]
	 */
	public TSListBy1st2ndVVDListVO[] getTSListBy1st2ndVVDListVOs(){
		TSListBy1st2ndVVDListVO[] vos = (TSListBy1st2ndVVDListVO[])models.toArray(new TSListBy1st2ndVVDListVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRmk = this.tsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disc = this.disc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.terminal = this.terminal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextlane = this.nextlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsCd = this.bsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstetb = this.firstetb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextetd = this.nextetd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstvvd = this.firstvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextvvd = this.nextvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstlane = this.firstlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVol = this.cntrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auth = this.auth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
