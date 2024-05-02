/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchBDRTimeVO.java
*@FileTitle : SearchBDRTimeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.31 김기종 
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.09.01 김영철 [CHM-201004943-01] BDR 로직보완 ( Manual BDR이 되면 DB에 로그를 남김 )
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBDRTimeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBDRTimeVO> models = new ArrayList<SearchBDRTimeVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String bdrCxlDt = null;
	/* Column Info */
	private String bdrCxlUsrId = null;
	/* Column Info */
	private String bdrRsnRmk = null;
	/* Column Info */
	private String bdrRsnCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cgoEvntNm = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String cgorTeamCd = null;
	/* Column Info */
	private String rdoTrunkFeeder = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String oblChk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String totBookingCnt = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String btrBookingCnt = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String vvdBdr = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bdrDys = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String oblIssFlag = null;
	/* Column Info */
	private String bdrDate = null;
	/* Column Info */
	private String bkgBdrUsrId = null;
	/* Column Info */
	private String bkgMnlBdrUpdDt = null;
	/* Column Info */
	private String vvdBdrUsrId = null;
	/* Column Info */
	private String vvdMnlBdrUpdDt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vvdOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBDRTimeVO() {}

	public SearchBDRTimeVO(String ibflag, String pagerows, String bkgNo, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String vvdCd, String slanCd, String polCd, String podCd, String vpsPortCd, String bdrDys, String etdDt, String bdrDate, String bdrFlg, String bkgStsCd, String creUsrId, String creDt, String updUsrId, String usrNm, String ofcCd, String updDt, String rdoTrunkFeeder, String totBookingCnt, String vvdBdr, String btrBookingCnt, String cgorTeamCd, String cgoEvntNm, String evntDt, String evntOfcCd, String evntUsrId, String oblChk, String oblIssFlag, String bkgBdrUsrId, String bkgMnlBdrUpdDt, String vvdBdrUsrId, String vvdMnlBdrUpdDt, String bkgOfcCd, String vvdOfcCd, String bdrRsnCd, String bdrRsnRmk, String bdrCxlUsrId, String bdrCxlDt, String fromDt, String toDt, String rhqOfcCd) {
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.rhqOfcCd = rhqOfcCd;
		this.bdrCxlDt = bdrCxlDt;
		this.bdrCxlUsrId = bdrCxlUsrId;
		this.bdrRsnRmk = bdrRsnRmk;
		this.bdrRsnCd = bdrRsnCd;
		this.vslCd = vslCd;
		this.cgoEvntNm = cgoEvntNm;
		this.bdrFlg = bdrFlg;
		this.bkgStsCd = bkgStsCd;
		this.creDt = creDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.usrNm = usrNm;
		this.evntUsrId = evntUsrId;
		this.cgorTeamCd = cgorTeamCd;
		this.rdoTrunkFeeder = rdoTrunkFeeder;
		this.updUsrId = updUsrId;
		this.evntDt = evntDt;
		this.oblChk = oblChk;
		this.updDt = updDt;
		this.totBookingCnt = totBookingCnt;
		this.evntOfcCd = evntOfcCd;
		this.skdVoyNo = skdVoyNo;
		this.btrBookingCnt = btrBookingCnt;
		this.etdDt = etdDt;
		this.vvdBdr = vvdBdr;
		this.skdDirCd = skdDirCd;
		this.bdrDys = bdrDys;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.oblIssFlag = oblIssFlag;
		this.bdrDate = bdrDate;
		this.bkgBdrUsrId = bkgBdrUsrId;
		this.bkgMnlBdrUpdDt = bkgMnlBdrUpdDt;
		this.vvdBdrUsrId = vvdBdrUsrId;
		this.vvdMnlBdrUpdDt = vvdMnlBdrUpdDt;
		this.bkgOfcCd = bkgOfcCd;
		this.vvdOfcCd = vvdOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("bdr_cxl_dt", getBdrCxlDt());
		this.hashColumns.put("bdr_cxl_usr_id", getBdrCxlUsrId());
		this.hashColumns.put("bdr_rsn_rmk", getBdrRsnRmk());
		this.hashColumns.put("bdr_rsn_cd", getBdrRsnCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cgo_evnt_nm", getCgoEvntNm());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("cgor_team_cd", getCgorTeamCd());
		this.hashColumns.put("rdo_trunk_feeder", getRdoTrunkFeeder());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("obl_chk", getOblChk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tot_booking_cnt", getTotBookingCnt());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("btr_booking_cnt", getBtrBookingCnt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("vvd_bdr", getVvdBdr());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bdr_dys", getBdrDys());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("obl_iss_flag", getOblIssFlag());
		this.hashColumns.put("bdr_date", getBdrDate());
		this.hashColumns.put("bkg_bdr_usr_id", getBkgBdrUsrId());
		this.hashColumns.put("bkg_mnl_bdr_upd_dt", getBkgMnlBdrUpdDt());
		this.hashColumns.put("vvd_bdr_usr_id", getVvdBdrUsrId());
		this.hashColumns.put("vvd_mnl_bdr_upd_dt", getVvdMnlBdrUpdDt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vvd_ofc_cd", getVvdOfcCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("bdr_cxl_dt", "bdrCxlDt");
		this.hashFields.put("bdr_cxl_usr_id", "bdrCxlUsrId");
		this.hashFields.put("bdr_rsn_rmk", "bdrRsnRmk");
		this.hashFields.put("bdr_rsn_cd", "bdrRsnCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cgo_evnt_nm", "cgoEvntNm");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("cgor_team_cd", "cgorTeamCd");
		this.hashFields.put("rdo_trunk_feeder", "rdoTrunkFeeder");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("obl_chk", "oblChk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tot_booking_cnt", "totBookingCnt");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("btr_booking_cnt", "btrBookingCnt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("vvd_bdr", "vvdBdr");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bdr_dys", "bdrDys");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("obl_iss_flag", "oblIssFlag");
		this.hashFields.put("bdr_date", "bdrDate");
		this.hashFields.put("bkg_bdr_usr_id", "bkgBdrUsrId");
		this.hashFields.put("bkg_mnl_bdr_upd_dt", "bkgMnlBdrUpdDt");
		this.hashFields.put("vvd_bdr_usr_id", "vvdBdrUsrId");
		this.hashFields.put("vvd_mnl_bdr_upd_dt", "vvdMnlBdrUpdDt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vvd_ofc_cd", "vvdOfcCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bdrCxlUsrId
	 */
	public String getBdrCxlUsrId() {
		return this.bdrCxlUsrId;
	}
	
	/**
	 * Column Info
	 * @return bdrRsnRmk
	 */
	public String getBdrRsnRmk() {
		return this.bdrRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return bdrRsnCd
	 */
	public String getBdrRsnCd() {
		return this.bdrRsnCd;
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
	 * @return cgoEvntNm
	 */
	public String getCgoEvntNm() {
		return this.cgoEvntNm;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return cgorTeamCd
	 */
	public String getCgorTeamCd() {
		return this.cgorTeamCd;
	}
	
	/**
	 * Column Info
	 * @return rdoTrunkFeeder
	 */
	public String getRdoTrunkFeeder() {
		return this.rdoTrunkFeeder;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return oblChk
	 */
	public String getOblChk() {
		return this.oblChk;
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
	 * @return totBookingCnt
	 */
	public String getTotBookingCnt() {
		return this.totBookingCnt;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
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
	 * @return btrBookingCnt
	 */
	public String getBtrBookingCnt() {
		return this.btrBookingCnt;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return vvdBdr
	 */
	public String getVvdBdr() {
		return this.vvdBdr;
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
	 * @return bdrDys
	 */
	public String getBdrDys() {
		return this.bdrDys;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlag
	 */
	public String getOblIssFlag() {
		return this.oblIssFlag;
	}
	
	/**
	 * Column Info
	 * @return bdrDate
	 */
	public String getBdrDate() {
		return this.bdrDate;
	}
	
	/**
	 * Column Info
	 * @return bdrCxlDt
	 */
	public String getBdrCxlDt() {
		return this.bdrCxlDt;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bdrCxlUsrId
	 */
	public void setBdrCxlUsrId(String bdrCxlUsrId) {
		this.bdrCxlUsrId = bdrCxlUsrId;
	}
	
	/**
	 * Column Info
	 * @param bdrRsnRmk
	 */
	public void setBdrRsnRmk(String bdrRsnRmk) {
		this.bdrRsnRmk = bdrRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param bdrRsnCd
	 */
	public void setBdrRsnCd(String bdrRsnCd) {
		this.bdrRsnCd = bdrRsnCd;
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
	 * @param cgoEvntNm
	 */
	public void setCgoEvntNm(String cgoEvntNm) {
		this.cgoEvntNm = cgoEvntNm;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param cgorTeamCd
	 */
	public void setCgorTeamCd(String cgorTeamCd) {
		this.cgorTeamCd = cgorTeamCd;
	}
	
	/**
	 * Column Info
	 * @param rdoTrunkFeeder
	 */
	public void setRdoTrunkFeeder(String rdoTrunkFeeder) {
		this.rdoTrunkFeeder = rdoTrunkFeeder;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param oblChk
	 */
	public void setOblChk(String oblChk) {
		this.oblChk = oblChk;
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
	 * @param totBookingCnt
	 */
	public void setTotBookingCnt(String totBookingCnt) {
		this.totBookingCnt = totBookingCnt;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
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
	 * @param btrBookingCnt
	 */
	public void setBtrBookingCnt(String btrBookingCnt) {
		this.btrBookingCnt = btrBookingCnt;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param vvdBdr
	 */
	public void setVvdBdr(String vvdBdr) {
		this.vvdBdr = vvdBdr;
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
	 * @param bdrDys
	 */
	public void setBdrDys(String bdrDys) {
		this.bdrDys = bdrDys;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlag
	 */
	public void setOblIssFlag(String oblIssFlag) {
		this.oblIssFlag = oblIssFlag;
	}
	
	/**
	 * Column Info
	 * @param bdrCxlDt
	 */
	public void setBdrCxlDt(String bdrCxlDt) {
		this.bdrCxlDt = bdrCxlDt;
	}
	
	/**
	 * Column Info
	 * @param bdrDate
	 */
	public void setBdrDate(String bdrDate) {
		this.bdrDate = bdrDate;
	}
	
	public String getBkgBdrUsrId() {
		return bkgBdrUsrId;
	}

	public String getBkgMnlBdrUpdDt() {
		return bkgMnlBdrUpdDt;
	}

	public void setBkgMnlBdrUpdDt(String bkgMnlBdrUpdDt) {
		this.bkgMnlBdrUpdDt = bkgMnlBdrUpdDt;
	}

	public String getVvdBdrUsrId() {
		return vvdBdrUsrId;
	}

	public void setVvdBdrUsrId(String vvdBdrUsrId) {
		this.vvdBdrUsrId = vvdBdrUsrId;
	}

	public String getVvdMnlBdrUpdDt() {
		return vvdMnlBdrUpdDt;
	}

	public void setVvdMnlBdrUpdDt(String vvdMnlBdrUpdDt) {
		this.vvdMnlBdrUpdDt = vvdMnlBdrUpdDt;
	}

	public void setBkgBdrUsrId(String bkgBdrUsrId) {
		this.bkgBdrUsrId = bkgBdrUsrId;
	}

	public String getBkgOfcCd() {
		return bkgOfcCd;
	}

	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}

	public String getVvdOfcCd() {
		return vvdOfcCd;
	}

	public void setVvdOfcCd(String vvdOfcCd) {
		this.vvdOfcCd = vvdOfcCd;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setBdrCxlDt(JSPUtil.getParameter(request, prefix + "bdr_cxl_dt", ""));
		setBdrCxlUsrId(JSPUtil.getParameter(request, prefix + "bdr_cxl_usr_id", ""));
		setBdrRsnRmk(JSPUtil.getParameter(request, prefix + "bdr_rsn_rmk", ""));
		setBdrRsnCd(JSPUtil.getParameter(request, prefix + "bdr_rsn_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCgoEvntNm(JSPUtil.getParameter(request, prefix + "cgo_evnt_nm", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setEvntUsrId(JSPUtil.getParameter(request, prefix + "evnt_usr_id", ""));
		setCgorTeamCd(JSPUtil.getParameter(request, prefix + "cgor_team_cd", ""));
		setRdoTrunkFeeder(JSPUtil.getParameter(request, prefix + "rdo_trunk_feeder", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setOblChk(JSPUtil.getParameter(request, prefix + "obl_chk", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTotBookingCnt(JSPUtil.getParameter(request, prefix + "tot_booking_cnt", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, prefix + "evnt_ofc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBtrBookingCnt(JSPUtil.getParameter(request, prefix + "btr_booking_cnt", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setVvdBdr(JSPUtil.getParameter(request, prefix + "vvd_bdr", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBdrDys(JSPUtil.getParameter(request, prefix + "bdr_dys", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setOblIssFlag(JSPUtil.getParameter(request, prefix + "obl_iss_flag", ""));
		setBdrDate(JSPUtil.getParameter(request, prefix + "bdr_date", ""));
		setBkgBdrUsrId(JSPUtil.getParameter(request, prefix + "bkg_bdr_usr_id", ""));
		setBkgMnlBdrUpdDt(JSPUtil.getParameter(request, prefix + "bkg_mnl_bdr_upd_dt", ""));
		setVvdBdrUsrId(JSPUtil.getParameter(request, prefix + "vvd_bdr_usr_id", ""));
		setVvdMnlBdrUpdDt(JSPUtil.getParameter(request, prefix + "vvd_mnl_bdr_upd_dt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setVvdOfcCd(JSPUtil.getParameter(request, prefix + "vvd_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBDRTimeVO[]
	 */
	public SearchBDRTimeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBDRTimeVO[]
	 */
	public SearchBDRTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBDRTimeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] bdrCxlUsrId = (JSPUtil.getParameter(request, prefix	+ "bdr_cxl_usr_id", length));
			String[] bdrCxlDt = (JSPUtil.getParameter(request, prefix	+ "bdr_cxl_dt", length));
			String[] bdrRsnRmk = (JSPUtil.getParameter(request, prefix	+ "bdr_rsn_rmk", length));
			String[] bdrRsnCd = (JSPUtil.getParameter(request, prefix	+ "bdr_rsn_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cgoEvntNm = (JSPUtil.getParameter(request, prefix	+ "cgo_evnt_nm", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] cgorTeamCd = (JSPUtil.getParameter(request, prefix	+ "cgor_team_cd", length));
			String[] rdoTrunkFeeder = (JSPUtil.getParameter(request, prefix	+ "rdo_trunk_feeder", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] oblChk = (JSPUtil.getParameter(request, prefix	+ "obl_chk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] totBookingCnt = (JSPUtil.getParameter(request, prefix	+ "tot_booking_cnt", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] btrBookingCnt = (JSPUtil.getParameter(request, prefix	+ "btr_booking_cnt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] vvdBdr = (JSPUtil.getParameter(request, prefix	+ "vvd_bdr", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bdrDys = (JSPUtil.getParameter(request, prefix	+ "bdr_dys", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] oblIssFlag = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flag", length));
			String[] bdrDate = (JSPUtil.getParameter(request, prefix	+ "bdr_date", length));
			String[] bkgBdrUsrId = (JSPUtil.getParameter(request, prefix	+ "bkg_bdr_usr_id", length));
			String[] bkgMnlBdrUpdDt = (JSPUtil.getParameter(request, prefix	+ "bkg_mnl_bdr_upd_dt", length));
			String[] vvdBdrUsrId = (JSPUtil.getParameter(request, prefix	+ "vvd_bdr_usr_id", length));
			String[] vvdMnlBdrUpdDt = (JSPUtil.getParameter(request, prefix	+ "vvd_mnl_bdr_upd_dt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vvdOfcCd = (JSPUtil.getParameter(request, prefix	+ "vvd_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBDRTimeVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cgoEvntNm[i] != null)
					model.setCgoEvntNm(cgoEvntNm[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (cgorTeamCd[i] != null)
					model.setCgorTeamCd(cgorTeamCd[i]);
				if (rdoTrunkFeeder[i] != null)
					model.setRdoTrunkFeeder(rdoTrunkFeeder[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (oblChk[i] != null)
					model.setOblChk(oblChk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (totBookingCnt[i] != null)
					model.setTotBookingCnt(totBookingCnt[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (btrBookingCnt[i] != null)
					model.setBtrBookingCnt(btrBookingCnt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (vvdBdr[i] != null)
					model.setVvdBdr(vvdBdr[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bdrDys[i] != null)
					model.setBdrDys(bdrDys[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (oblIssFlag[i] != null)
					model.setOblIssFlag(oblIssFlag[i]);
				if (bdrDate[i] != null)
					model.setBdrDate(bdrDate[i]);
				if (bkgBdrUsrId[i] != null)
					model.setBkgBdrUsrId(bkgBdrUsrId[i]);
				if (bkgMnlBdrUpdDt[i] != null)
					model.setBkgMnlBdrUpdDt(bkgMnlBdrUpdDt[i]);
				if (vvdBdrUsrId[i] != null)
					model.setVvdBdrUsrId(vvdBdrUsrId[i]);
				if (vvdMnlBdrUpdDt[i] != null)
					model.setVvdMnlBdrUpdDt(vvdMnlBdrUpdDt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vvdOfcCd[i] != null)
					model.setVvdOfcCd(vvdOfcCd[i]);
				if (bdrRsnCd[i] != null)
					model.setBdrRsnCd(bdrRsnCd[i]);
				if (bdrRsnRmk[i] != null)
					model.setBdrRsnRmk(bdrRsnRmk[i]);
				if (bdrCxlUsrId[i] != null)
					model.setBdrCxlUsrId(bdrCxlUsrId[i]);
				if (bdrCxlDt[i] != null)
					model.setBdrCxlDt(bdrCxlDt[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBDRTimeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBDRTimeVO[]
	 */
	public SearchBDRTimeVO[] getSearchBDRTimeVOs(){
		SearchBDRTimeVO[] vos = (SearchBDRTimeVO[])models.toArray(new SearchBDRTimeVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrCxlDt = this.bdrCxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrCxlUsrId = this.bdrCxlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrRsnRmk = this.bdrRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrRsnCd = this.bdrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoEvntNm = this.cgoEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorTeamCd = this.cgorTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdoTrunkFeeder = this.rdoTrunkFeeder .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblChk = this.oblChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBookingCnt = this.totBookingCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btrBookingCnt = this.btrBookingCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBdr = this.vvdBdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDys = this.bdrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlag = this.oblIssFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDate = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBdrUsrId = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMnlBdrUpdDt = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBdrUsrId = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdMnlBdrUpdDt = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdOfcCd = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
