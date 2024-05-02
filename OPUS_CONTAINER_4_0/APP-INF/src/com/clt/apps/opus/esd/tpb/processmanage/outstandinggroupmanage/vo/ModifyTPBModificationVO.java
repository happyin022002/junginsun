/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModifyTPBModificationVO.java
*@FileTitle : ModifyTPBModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.08 최 선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifyTPBModificationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifyTPBModificationVO> models = new ArrayList<ModifyTPBModificationVO>();
	
	/* Column Info */
	private String vslCd = null; //
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String otsDtlSeq = null; //
	/* Column Info */
	private String sUserOfcCd = null; //
	/* Column Info */
	private String blNo = null; //
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Column Info */
	private String n3ptyOfcCd = null; //
	/* Column Info */
	private String vndrCustDivCd = null;
	/* Column Info */
	private String sN3ptyNoStrsLink = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String ibflag = null; //
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String eqNo = null; //
	/* Column Info */
	private String vvdCd = null; //
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String fincDirCd = null; //
	/* Column Info */
	private String n3ptySrcNoVisible = null;
	/* Column Info */
	private String blNoTp = null; //
	/* Column Info */
	private String sOfficeLevel = null;
	/* Column Info */
	private String blNoAll = null; //
	/* Column Info */
	private String custCntCd = null; //
	/* Column Info */
	private String bkgNoAll = null; //
	/* Column Info */
	private String sN3ptyNo = null; //
	/* Column Info */
	private String bkgNoSplit = null; //
	/* Column Info */
	private String skdVoyNo = null; //
	/* Column Info */
	private String sVndrCustDivCd = null; //
	/* Column Info */
	private String custSeq = null; //
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Column Info */
	private String n3ptyNoDpSeq = null; //
	/* Column Info */
	private String bkgNo = null; //
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String vndrSeq = null; //
	/* Column Info */
	private String gVvd = null;
	/* Column Info */
	private String trdPartyVal = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;
	/* Column Info */
	private String sUserId = null; //
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifyTPBModificationVO() {}

	public ModifyTPBModificationVO(String vslCd, String currCd, String sTrdPartyVal, String otsDtlSeq, String sN3ptyNoStrsLink, String sUserOfcCd, String sN3ptyNo, String ibflag,  String blNo, String n3ptyBilTpNm, String n3ptyOfcCd, String vndrCustDivCd, String blNoChk, String n3ptyBilTpCd, String cfmAmt, String eqNo, String vvdCd, String n3ptyNo, String fincDirCd, String n3ptySrcNoVisible, String blNoTp, String sOfficeLevel, String blNoAll, String custCntCd, String skdVoyNo, String vndrSeq, String bkgNoAll, String bkgNoSplit, String sVndrCustDivCd, String custSeq, String sOfcCdForRhq, String n3ptyNoDpSeq, String bkgNo, String otsStsNm, String sRhqCdForRhq, String gVvd, String trdPartyVal, String n3ptySrcSubSysCd, String sUserId) {
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.sTrdPartyVal = sTrdPartyVal;
		this.otsDtlSeq = otsDtlSeq;
		this.sUserOfcCd = sUserOfcCd;
		this.blNo = blNo;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.vndrCustDivCd = vndrCustDivCd;
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
		this.blNoChk = blNoChk;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ibflag = ibflag;
		this.cfmAmt = cfmAmt;
		this.eqNo = eqNo; 
		this.vvdCd = vvdCd;
		this.n3ptyNo = n3ptyNo;
		this.fincDirCd = fincDirCd;
		this.n3ptySrcNoVisible = n3ptySrcNoVisible;
		this.blNoTp = blNoTp;
		this.sOfficeLevel = sOfficeLevel;
		this.blNoAll = blNoAll;
		this.custCntCd = custCntCd;
		this.bkgNoAll = bkgNoAll;
		this.sN3ptyNo = sN3ptyNo;
		this.bkgNoSplit = bkgNoSplit;
		this.skdVoyNo = skdVoyNo;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.custSeq = custSeq;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
		this.bkgNo = bkgNo;
		this.otsStsNm = otsStsNm;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.vndrSeq = vndrSeq;
		this.gVvd = gVvd;
		this.trdPartyVal = trdPartyVal;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
		this.sUserId = sUserId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("s_n3pty_no_strs_link", getSN3ptyNoStrsLink());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("finc_dir_cd", getFincDirCd());
		this.hashColumns.put("n3pty_src_no_visible", getN3ptySrcNoVisible());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("n3pty_no_dp_seq", getN3ptyNoDpSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("g_vvd", getGVvd());
		this.hashColumns.put("trd_party_val", getTrdPartyVal());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		this.hashColumns.put("s_user_id", getSUserId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("s_n3pty_no_strs_link", "sN3ptyNoStrsLink");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("finc_dir_cd", "fincDirCd");
		this.hashFields.put("n3pty_src_no_visible", "n3ptySrcNoVisible");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("s_date", "sDate");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("editable", "editable");
		this.hashFields.put("n3pty_no_dp_seq", "n3ptyNoDpSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("g_vvd", "gVvd");
		this.hashFields.put("trd_party_val", "trdPartyVal");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		this.hashFields.put("s_user_id", "sUserId");
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
	 * @return sTrdPartyVal
	 */
	public String getSTrdPartyVal() {
		return this.sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return otsDtlSeq
	 */
	public String getOtsDtlSeq() {
		return this.otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return sUserOfcCd
	 */
	public String getSUserOfcCd() {
		return this.sUserOfcCd;
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
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCustDivCd
	 */
	public String getVndrCustDivCd() {
		return this.vndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNoStrsLink
	 */
	public String getSN3ptyNoStrsLink() {
		return this.sN3ptyNoStrsLink;
	}
	
	/**
	 * Column Info
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cfmAmt
	 */
	public String getCfmAmt() {
		return this.cfmAmt;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return fincDirCd
	 */
	public String getFincDirCd() {
		return this.fincDirCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNoVisible
	 */
	public String getN3ptySrcNoVisible() {
		return this.n3ptySrcNoVisible;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return sOfficeLevel
	 */
	public String getSOfficeLevel() {
		return this.sOfficeLevel;
	}
	
	/**
	 * Column Info
	 * @return blNoAll
	 */
	public String getBlNoAll() {
		return this.blNoAll;
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
	 * @return bkgNoAll
	 */
	public String getBkgNoAll() {
		return this.bkgNoAll;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return sVndrCustDivCd
	 */
	public String getSVndrCustDivCd() {
		return this.sVndrCustDivCd;
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
	 * @return sOfcCdForRhq
	 */
	public String getSOfcCdForRhq() {
		return this.sOfcCdForRhq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNoDpSeq
	 */
	public String getN3ptyNoDpSeq() {
		return this.n3ptyNoDpSeq;
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
	 * @return otsStsNm
	 */
	public String getOtsStsNm() {
		return this.otsStsNm;
	}
	
	/**
	 * Column Info
	 * @return sRhqCdForRhq
	 */
	public String getSRhqCdForRhq() {
		return this.sRhqCdForRhq;
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
	 * @return gVvd
	 */
	public String getGVvd() {
		return this.gVvd;
	}
	
	/**
	 * Column Info
	 * @return trdPartyVal
	 */
	public String getTrdPartyVal() {
		return this.trdPartyVal;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcSubSysCd
	 */
	public String getN3ptySrcSubSysCd() {
		return this.n3ptySrcSubSysCd;
	}
	
	/**
	 * Column Info
	 * @return sUserId
	 */
	public String getSUserId() {
		return this.sUserId;
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
	 * @param sTrdPartyVal
	 */
	public void setSTrdPartyVal(String sTrdPartyVal) {
		this.sTrdPartyVal = sTrdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param otsDtlSeq
	 */
	public void setOtsDtlSeq(String otsDtlSeq) {
		this.otsDtlSeq = otsDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param sUserOfcCd
	 */
	public void setSUserOfcCd(String sUserOfcCd) {
		this.sUserOfcCd = sUserOfcCd;
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
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
	}
	
	/**
	 * Column Info
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCustDivCd
	 */
	public void setVndrCustDivCd(String vndrCustDivCd) {
		this.vndrCustDivCd = vndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNoStrsLink
	 */
	public void setSN3ptyNoStrsLink(String sN3ptyNoStrsLink) {
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
	}
	
	/**
	 * Column Info
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cfmAmt
	 */
	public void setCfmAmt(String cfmAmt) {
		this.cfmAmt = cfmAmt;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param fincDirCd
	 */
	public void setFincDirCd(String fincDirCd) {
		this.fincDirCd = fincDirCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNoVisible
	 */
	public void setN3ptySrcNoVisible(String n3ptySrcNoVisible) {
		this.n3ptySrcNoVisible = n3ptySrcNoVisible;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param sOfficeLevel
	 */
	public void setSOfficeLevel(String sOfficeLevel) {
		this.sOfficeLevel = sOfficeLevel;
	}
	
	/**
	 * Column Info
	 * @param blNoAll
	 */
	public void setBlNoAll(String blNoAll) {
		this.blNoAll = blNoAll;
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
	 * @param bkgNoAll
	 */
	public void setBkgNoAll(String bkgNoAll) {
		this.bkgNoAll = bkgNoAll;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param sVndrCustDivCd
	 */
	public void setSVndrCustDivCd(String sVndrCustDivCd) {
		this.sVndrCustDivCd = sVndrCustDivCd;
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
	 * @param sOfcCdForRhq
	 */
	public void setSOfcCdForRhq(String sOfcCdForRhq) {
		this.sOfcCdForRhq = sOfcCdForRhq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNoDpSeq
	 */
	public void setN3ptyNoDpSeq(String n3ptyNoDpSeq) {
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
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
	 * @param otsStsNm
	 */
	public void setOtsStsNm(String otsStsNm) {
		this.otsStsNm = otsStsNm;
	}
	
	/**
	 * Column Info
	 * @param sRhqCdForRhq
	 */
	public void setSRhqCdForRhq(String sRhqCdForRhq) {
		this.sRhqCdForRhq = sRhqCdForRhq;
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
	 * @param gVvd
	 */
	public void setGVvd(String gVvd) {
		this.gVvd = gVvd;
	}
	
	/**
	 * Column Info
	 * @param trdPartyVal
	 */
	public void setTrdPartyVal(String trdPartyVal) {
		this.trdPartyVal = trdPartyVal;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcSubSysCd
	 */
	public void setN3ptySrcSubSysCd(String n3ptySrcSubSysCd) {
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
	}
	
	/**
	 * Column Info
	 * @param sUserId
	 */
	public void setSUserId(String sUserId) {
		this.sUserId = sUserId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setSUserOfcCd(JSPUtil.getParameter(request, "s_user_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, "n3pty_ofc_cd", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setSN3ptyNoStrsLink(JSPUtil.getParameter(request, "s_n3pty_no_strs_link", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCfmAmt(JSPUtil.getParameter(request, "cfm_amt", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setFincDirCd(JSPUtil.getParameter(request, "finc_dir_cd", ""));
		setN3ptySrcNoVisible(JSPUtil.getParameter(request, "n3pty_src_no_visible", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
		setBlNoAll(JSPUtil.getParameter(request, "bl_no_all", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setBkgNoAll(JSPUtil.getParameter(request, "bkg_no_all", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setN3ptyNoDpSeq(JSPUtil.getParameter(request, "n3pty_no_dp_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOtsStsNm(JSPUtil.getParameter(request, "ots_sts_nm", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setGVvd(JSPUtil.getParameter(request, "g_vvd", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, "trd_party_val", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, "n3pty_src_sub_sys_cd", ""));
		setSUserId(JSPUtil.getParameter(request, "s_user_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ModifyTPBModificationVO[]
	 */
	public ModifyTPBModificationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ModifyTPBModificationVO[]
	 */
	public ModifyTPBModificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifyTPBModificationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] sN3ptyNoStrsLink = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_strs_link", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] fincDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_dir_cd", length));
			String[] n3ptySrcNoVisible = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no_visible", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] n3ptyNoDpSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_dp_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] gVvd = (JSPUtil.getParameter(request, prefix	+ "g_vvd", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			String[] sUserId = (JSPUtil.getParameter(request, prefix	+ "s_user_id", length));

			for (int i = 0; i < length; i++) {
				model = new ModifyTPBModificationVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (sN3ptyNoStrsLink[i] != null)
					model.setSN3ptyNoStrsLink(sN3ptyNoStrsLink[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfmAmt[i] != null)
					model.setCfmAmt(cfmAmt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (fincDirCd[i] != null)
					model.setFincDirCd(fincDirCd[i]);
				if (n3ptySrcNoVisible[i] != null)
					model.setN3ptySrcNoVisible(n3ptySrcNoVisible[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (sOfficeLevel[i] != null)
					model.setSOfficeLevel(sOfficeLevel[i]);
				if (blNoAll[i] != null)
					model.setBlNoAll(blNoAll[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgNoAll[i] != null)
					model.setBkgNoAll(bkgNoAll[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (n3ptyNoDpSeq[i] != null)
					model.setN3ptyNoDpSeq(n3ptyNoDpSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (gVvd[i] != null)
					model.setGVvd(gVvd[i]);
				if (trdPartyVal[i] != null)
					model.setTrdPartyVal(trdPartyVal[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				if (sUserId[i] != null)
					model.setSUserId(sUserId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getModifyTPBModificationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ModifyTPBModificationVO[]
	 */
	public ModifyTPBModificationVO[] getModifyTPBModificationVOs(){
		ModifyTPBModificationVO[] vos = (ModifyTPBModificationVO[])models.toArray(new ModifyTPBModificationVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoStrsLink = this.sN3ptyNoStrsLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincDirCd = this.fincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNoVisible = this.n3ptySrcNoVisible .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoDpSeq = this.n3ptyNoDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gVvd = this.gVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserId = this.sUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
