/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTPBGroupModifyListVO.java
*@FileTitle : SearchTPBGroupModifyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.26 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTPBGroupModifyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTPBGroupModifyListVO> models = new ArrayList<SearchTPBGroupModifyListVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sTrdPartyVal = null;
	/* Column Info */
	private String otsDtlSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* Column Info */
	private String sN3ptyNoStrsLink = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfmAmt = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String fincDirCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String n3ptySrcNoVisible = null;
	/* Column Info */
	private String sOfficeLevel = null;
	/* Column Info */
	private String blNoAll = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgNoAll = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String sVndrCustDivCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Column Info */
	private String editable = null;
	/* Column Info */
	private String csrvalid = null;
	/* Column Info */
	private String n3ptyNoDpSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String gVvd = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String trdPartyVal = null;
	/* Column Info */
	private String n3ptySrcSubSysCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTPBGroupModifyListVO() {}

	public SearchTPBGroupModifyListVO(String ibflag, String pagerows, String sTrdPartyVal, String sVndrCustDivCd, String sdate, String edate, String sOfficeLevel, String sRhqCdForRhq, String sOfcCdForRhq, String sN3ptyNoStrsLink, String sN3ptyNo, String userOfcCd, String userId, String csrvalid, String editable, String otsDtlSeq, String n3ptyNo, String n3ptyNoDpSeq, String n3ptySrcSubSysCd, String n3ptyBilTpNm, String n3ptySrcNoVisible, String bkgNoAll, String blNoAll, String gVvd, String eqNo, String vndrCustDivCd, String trdPartyVal, String otsStsNm, String currCd, String cfmAmt, String n3ptyBilTpCd, String bkgNo, String blNo, String vslCd, String skdVoyNo, String fincDirCd, String vvdCd, String vndrSeq, String custCntCd, String custSeq, String n3ptyOfcCd) {
		this.userOfcCd = userOfcCd;
		this.vslCd = vslCd;
		this.currCd = currCd;
		this.sTrdPartyVal = sTrdPartyVal;
		this.otsDtlSeq = otsDtlSeq;
		this.blNo = blNo;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.pagerows = pagerows;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.vndrCustDivCd = vndrCustDivCd;
		this.sN3ptyNoStrsLink = sN3ptyNoStrsLink;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.ibflag = ibflag;
		this.cfmAmt = cfmAmt;
		this.eqNo = eqNo;
		this.vvdCd = vvdCd;
		this.edate = edate;
		this.n3ptyNo = n3ptyNo;
		this.fincDirCd = fincDirCd;
		this.userId = userId;
		this.n3ptySrcNoVisible = n3ptySrcNoVisible;
		this.sOfficeLevel = sOfficeLevel;
		this.blNoAll = blNoAll;
		this.custCntCd = custCntCd;
		this.bkgNoAll = bkgNoAll;
		this.sN3ptyNo = sN3ptyNo;
		this.skdVoyNo = skdVoyNo;
		this.sVndrCustDivCd = sVndrCustDivCd;
		this.custSeq = custSeq;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.editable = editable;
		this.csrvalid = csrvalid;
		this.n3ptyNoDpSeq = n3ptyNoDpSeq;
		this.bkgNo = bkgNo;
		this.otsStsNm = otsStsNm;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.vndrSeq = vndrSeq;
		this.gVvd = gVvd;
		this.sdate = sdate;
		this.trdPartyVal = trdPartyVal;
		this.n3ptySrcSubSysCd = n3ptySrcSubSysCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_trd_party_val", getSTrdPartyVal());
		this.hashColumns.put("ots_dtl_seq", getOtsDtlSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("s_n3pty_no_strs_link", getSN3ptyNoStrsLink());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_amt", getCfmAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("finc_dir_cd", getFincDirCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("n3pty_src_no_visible", getN3ptySrcNoVisible());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		this.hashColumns.put("bl_no_all", getBlNoAll());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_no_all", getBkgNoAll());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("s_vndr_cust_div_cd", getSVndrCustDivCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("editable", getEditable());
		this.hashColumns.put("csrvalid", getCsrvalid());
		this.hashColumns.put("n3pty_no_dp_seq", getN3ptyNoDpSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("g_vvd", getGVvd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("trd_party_val", getTrdPartyVal());
		this.hashColumns.put("n3pty_src_sub_sys_cd", getN3ptySrcSubSysCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_trd_party_val", "sTrdPartyVal");
		this.hashFields.put("ots_dtl_seq", "otsDtlSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("s_n3pty_no_strs_link", "sN3ptyNoStrsLink");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_amt", "cfmAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("finc_dir_cd", "fincDirCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("n3pty_src_no_visible", "n3ptySrcNoVisible");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		this.hashFields.put("bl_no_all", "blNoAll");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_no_all", "bkgNoAll");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("s_vndr_cust_div_cd", "sVndrCustDivCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("editable", "editable");
		this.hashFields.put("csrvalid", "csrvalid");
		this.hashFields.put("n3pty_no_dp_seq", "n3ptyNoDpSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("g_vvd", "gVvd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("trd_party_val", "trdPartyVal");
		this.hashFields.put("n3pty_src_sub_sys_cd", "n3ptySrcSubSysCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return edate
	 */
	public String getEdate() {
		return this.edate;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return editable
	 */
	public String getEditable() {
		return this.editable;
	}
	
	/**
	 * Column Info
	 * @return csrvalid
	 */
	public String getCsrvalid() {
		return this.csrvalid;
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
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param editable
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}
	
	/**
	 * Column Info
	 * @param csrvalid
	 */
	public void setCsrvalid(String csrvalid) {
		this.csrvalid = csrvalid;
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
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSTrdPartyVal(JSPUtil.getParameter(request, "s_trd_party_val", ""));
		setOtsDtlSeq(JSPUtil.getParameter(request, "ots_dtl_seq", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, "n3pty_ofc_cd", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setSN3ptyNoStrsLink(JSPUtil.getParameter(request, "s_n3pty_no_strs_link", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCfmAmt(JSPUtil.getParameter(request, "cfm_amt", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setEdate(JSPUtil.getParameter(request, "edate", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setFincDirCd(JSPUtil.getParameter(request, "finc_dir_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setN3ptySrcNoVisible(JSPUtil.getParameter(request, "n3pty_src_no_visible", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
		setBlNoAll(JSPUtil.getParameter(request, "bl_no_all", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setBkgNoAll(JSPUtil.getParameter(request, "bkg_no_all", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSVndrCustDivCd(JSPUtil.getParameter(request, "s_vndr_cust_div_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setEditable(JSPUtil.getParameter(request, "editable", ""));
		setCsrvalid(JSPUtil.getParameter(request, "csrvalid", ""));
		setN3ptyNoDpSeq(JSPUtil.getParameter(request, "n3pty_no_dp_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOtsStsNm(JSPUtil.getParameter(request, "ots_sts_nm", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setGVvd(JSPUtil.getParameter(request, "g_vvd", ""));
		setSdate(JSPUtil.getParameter(request, "sdate", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, "trd_party_val", ""));
		setN3ptySrcSubSysCd(JSPUtil.getParameter(request, "n3pty_src_sub_sys_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTPBGroupModifyListVO[]
	 */
	public SearchTPBGroupModifyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTPBGroupModifyListVO[]
	 */
	public SearchTPBGroupModifyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTPBGroupModifyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sTrdPartyVal = (JSPUtil.getParameter(request, prefix	+ "s_trd_party_val", length));
			String[] otsDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] sN3ptyNoStrsLink = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no_strs_link", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_amt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] fincDirCd = (JSPUtil.getParameter(request, prefix	+ "finc_dir_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] n3ptySrcNoVisible = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no_visible", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			String[] blNoAll = (JSPUtil.getParameter(request, prefix	+ "bl_no_all", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgNoAll = (JSPUtil.getParameter(request, prefix	+ "bkg_no_all", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] sVndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "s_vndr_cust_div_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] editable = (JSPUtil.getParameter(request, prefix	+ "editable", length));
			String[] csrvalid = (JSPUtil.getParameter(request, prefix	+ "csrvalid", length));
			String[] n3ptyNoDpSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_dp_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] gVvd = (JSPUtil.getParameter(request, prefix	+ "g_vvd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			String[] n3ptySrcSubSysCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_sub_sys_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTPBGroupModifyListVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sTrdPartyVal[i] != null)
					model.setSTrdPartyVal(sTrdPartyVal[i]);
				if (otsDtlSeq[i] != null)
					model.setOtsDtlSeq(otsDtlSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (sN3ptyNoStrsLink[i] != null)
					model.setSN3ptyNoStrsLink(sN3ptyNoStrsLink[i]);
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
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (fincDirCd[i] != null)
					model.setFincDirCd(fincDirCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (n3ptySrcNoVisible[i] != null)
					model.setN3ptySrcNoVisible(n3ptySrcNoVisible[i]);
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
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (sVndrCustDivCd[i] != null)
					model.setSVndrCustDivCd(sVndrCustDivCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (editable[i] != null)
					model.setEditable(editable[i]);
				if (csrvalid[i] != null)
					model.setCsrvalid(csrvalid[i]);
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
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (trdPartyVal[i] != null)
					model.setTrdPartyVal(trdPartyVal[i]);
				if (n3ptySrcSubSysCd[i] != null)
					model.setN3ptySrcSubSysCd(n3ptySrcSubSysCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTPBGroupModifyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTPBGroupModifyListVO[]
	 */
	public SearchTPBGroupModifyListVO[] getSearchTPBGroupModifyListVOs(){
		SearchTPBGroupModifyListVO[] vos = (SearchTPBGroupModifyListVO[])models.toArray(new SearchTPBGroupModifyListVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrdPartyVal = this.sTrdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlSeq = this.otsDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNoStrsLink = this.sN3ptyNoStrsLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAmt = this.cfmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincDirCd = this.fincDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNoVisible = this.n3ptySrcNoVisible .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAll = this.blNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoAll = this.bkgNoAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVndrCustDivCd = this.sVndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editable = this.editable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrvalid = this.csrvalid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoDpSeq = this.n3ptyNoDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gVvd = this.gVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcSubSysCd = this.n3ptySrcSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
