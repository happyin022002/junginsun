/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisLongStayingVO.java
*@FileTitle : ChassisLongStayingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이율규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChassisLongStayingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChassisLongStayingVO> models = new ArrayList<ChassisLongStayingVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String vvdNo = null;
	/* Column Info */
	private String chssVndrSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String boundCd = null;
	/* Column Info */
	private String fmMvmtEvntDt = null;
	/* Column Info */
	private String ydStayDys = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String tmlFreeDys = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mvmtEvntDt = null;
	/* Column Info */
	private String locList = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String polPodYdCd = null;
	/* Column Info */
	private String scCustNm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String trkVndrSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String chssDlyChgAmt = null;
	/* Column Info */
	private String deRcvTermCd = null;
	/* Column Info */
	private String clkStopDys = null;
	/* Column Info */
	private String etdEtaDt = null;
	/* Column Info */
	private String trkVndrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ltDt = null;
	/* Column Info */
	private String invtSeq = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssExptFlg = null;
	/* Column Info */
	private String chssTtlChgAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chssPayFlg = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String beyondFdays = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String mvmtFshFlg = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String stayingDays = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String chssVndrNm = null;
	/* Column Info */
	private String porDelYdCd = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String clkStopFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChassisLongStayingVO() {}

	public ChassisLongStayingVO(String ibflag, String pagerows, String locList, String fmDt, String ltDt, String boundCd, String cntrTpszCd, String stayingDays, String beyondFdays, String mvmtStsCd, String scCustNm, String locCd, String vvdNo, String bkgNo, String scNo, String cntrNo, String eccCd, String invtSeq, String vslCd, String skdVoyNo, String skdDirCd, String chssNo, String ydCd, String fullMtyCd, String ioBndCd, String mvmtFshFlg, String mvmtEvntDt, String fmMvmtStsCd, String fmMvmtEvntDt, String ydStayDys, String tmlFreeDys, String clkStopDys, String deRcvTermCd, String chssExptFlg, String clkStopFlg, String chssPayFlg, String agnAgmtNo, String chssPoolCd, String chssVndrSeq, String chssDlyChgAmt, String chssTtlChgAmt, String trkVndrSeq, String polPodYdCd, String porDelYdCd, String etdEtaDt, String creUsrId, String creDt, String updUsrId, String updDt, String scRfaNo, String chssVndrNm, String trkVndrNm, String shpr, String cnee, String cmdtNm) {
		this.vslCd = vslCd;
		this.chssPoolCd = chssPoolCd;
		this.chssNo = chssNo;
		this.vvdNo = vvdNo;
		this.chssVndrSeq = chssVndrSeq;
		this.pagerows = pagerows;
		this.boundCd = boundCd;
		this.fmMvmtEvntDt = fmMvmtEvntDt;
		this.ydStayDys = ydStayDys;
		this.locCd = locCd;
		this.tmlFreeDys = tmlFreeDys;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.mvmtEvntDt = mvmtEvntDt;
		this.locList = locList;
		this.updUsrId = updUsrId;
		this.polPodYdCd = polPodYdCd;
		this.scCustNm = scCustNm;
		this.skdVoyNo = skdVoyNo;
		this.trkVndrSeq = trkVndrSeq;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.fullMtyCd = fullMtyCd;
		this.chssDlyChgAmt = chssDlyChgAmt;
		this.deRcvTermCd = deRcvTermCd;
		this.clkStopDys = clkStopDys;
		this.etdEtaDt = etdEtaDt;
		this.trkVndrNm = trkVndrNm;
		this.creDt = creDt;
		this.ltDt = ltDt;
		this.invtSeq = invtSeq;
		this.agnAgmtNo = agnAgmtNo;
		this.ibflag = ibflag;
		this.chssExptFlg = chssExptFlg;
		this.chssTtlChgAmt = chssTtlChgAmt;
		this.updDt = updDt;
		this.chssPayFlg = chssPayFlg;
		this.fmDt = fmDt;
		this.beyondFdays = beyondFdays;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.eccCd = eccCd;
		this.mvmtFshFlg = mvmtFshFlg;
		this.ioBndCd = ioBndCd;
		this.cmdtNm = cmdtNm;
		this.skdDirCd = skdDirCd;
		this.mvmtStsCd = mvmtStsCd;
		this.scRfaNo = scRfaNo;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.stayingDays = stayingDays;
		this.cnee = cnee;
		this.chssVndrNm = chssVndrNm;
		this.porDelYdCd = porDelYdCd;
		this.shpr = shpr;
		this.clkStopFlg = clkStopFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("vvd_no", getVvdNo());
		this.hashColumns.put("chss_vndr_seq", getChssVndrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bound_cd", getBoundCd());
		this.hashColumns.put("fm_mvmt_evnt_dt", getFmMvmtEvntDt());
		this.hashColumns.put("yd_stay_dys", getYdStayDys());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("tml_free_dys", getTmlFreeDys());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mvmt_evnt_dt", getMvmtEvntDt());
		this.hashColumns.put("loc_list", getLocList());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pol_pod_yd_cd", getPolPodYdCd());
		this.hashColumns.put("sc_cust_nm", getScCustNm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("trk_vndr_seq", getTrkVndrSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("chss_dly_chg_amt", getChssDlyChgAmt());
		this.hashColumns.put("de_rcv_term_cd", getDeRcvTermCd());
		this.hashColumns.put("clk_stop_dys", getClkStopDys());
		this.hashColumns.put("etd_eta_dt", getEtdEtaDt());
		this.hashColumns.put("trk_vndr_nm", getTrkVndrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lt_dt", getLtDt());
		this.hashColumns.put("invt_seq", getInvtSeq());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_expt_flg", getChssExptFlg());
		this.hashColumns.put("chss_ttl_chg_amt", getChssTtlChgAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chss_pay_flg", getChssPayFlg());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("beyond_fdays", getBeyondFdays());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("mvmt_fsh_flg", getMvmtFshFlg());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("staying_days", getStayingDays());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("chss_vndr_nm", getChssVndrNm());
		this.hashColumns.put("por_del_yd_cd", getPorDelYdCd());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("clk_stop_flg", getClkStopFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("vvd_no", "vvdNo");
		this.hashFields.put("chss_vndr_seq", "chssVndrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bound_cd", "boundCd");
		this.hashFields.put("fm_mvmt_evnt_dt", "fmMvmtEvntDt");
		this.hashFields.put("yd_stay_dys", "ydStayDys");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("tml_free_dys", "tmlFreeDys");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_evnt_dt", "mvmtEvntDt");
		this.hashFields.put("loc_list", "locList");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pol_pod_yd_cd", "polPodYdCd");
		this.hashFields.put("sc_cust_nm", "scCustNm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("trk_vndr_seq", "trkVndrSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("chss_dly_chg_amt", "chssDlyChgAmt");
		this.hashFields.put("de_rcv_term_cd", "deRcvTermCd");
		this.hashFields.put("clk_stop_dys", "clkStopDys");
		this.hashFields.put("etd_eta_dt", "etdEtaDt");
		this.hashFields.put("trk_vndr_nm", "trkVndrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lt_dt", "ltDt");
		this.hashFields.put("invt_seq", "invtSeq");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_expt_flg", "chssExptFlg");
		this.hashFields.put("chss_ttl_chg_amt", "chssTtlChgAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chss_pay_flg", "chssPayFlg");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("beyond_fdays", "beyondFdays");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("mvmt_fsh_flg", "mvmtFshFlg");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("staying_days", "stayingDays");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("chss_vndr_nm", "chssVndrNm");
		this.hashFields.put("por_del_yd_cd", "porDelYdCd");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("clk_stop_flg", "clkStopFlg");
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return vvdNo
	 */
	public String getVvdNo() {
		return this.vvdNo;
	}
	
	/**
	 * Column Info
	 * @return chssVndrSeq
	 */
	public String getChssVndrSeq() {
		return this.chssVndrSeq;
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
	 * @return boundCd
	 */
	public String getBoundCd() {
		return this.boundCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtEvntDt
	 */
	public String getFmMvmtEvntDt() {
		return this.fmMvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @return ydStayDys
	 */
	public String getYdStayDys() {
		return this.ydStayDys;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return tmlFreeDys
	 */
	public String getTmlFreeDys() {
		return this.tmlFreeDys;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return mvmtEvntDt
	 */
	public String getMvmtEvntDt() {
		return this.mvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @return locList
	 */
	public String getLocList() {
		return this.locList;
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
	 * @return polPodYdCd
	 */
	public String getPolPodYdCd() {
		return this.polPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return scCustNm
	 */
	public String getScCustNm() {
		return this.scCustNm;
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
	 * @return trkVndrSeq
	 */
	public String getTrkVndrSeq() {
		return this.trkVndrSeq;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return chssDlyChgAmt
	 */
	public String getChssDlyChgAmt() {
		return this.chssDlyChgAmt;
	}
	
	/**
	 * Column Info
	 * @return deRcvTermCd
	 */
	public String getDeRcvTermCd() {
		return this.deRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return clkStopDys
	 */
	public String getClkStopDys() {
		return this.clkStopDys;
	}
	
	/**
	 * Column Info
	 * @return etdEtaDt
	 */
	public String getEtdEtaDt() {
		return this.etdEtaDt;
	}
	
	/**
	 * Column Info
	 * @return trkVndrNm
	 */
	public String getTrkVndrNm() {
		return this.trkVndrNm;
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
	 * @return ltDt
	 */
	public String getLtDt() {
		return this.ltDt;
	}
	
	/**
	 * Column Info
	 * @return invtSeq
	 */
	public String getInvtSeq() {
		return this.invtSeq;
	}
	
	/**
	 * Column Info
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
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
	 * @return chssExptFlg
	 */
	public String getChssExptFlg() {
		return this.chssExptFlg;
	}
	
	/**
	 * Column Info
	 * @return chssTtlChgAmt
	 */
	public String getChssTtlChgAmt() {
		return this.chssTtlChgAmt;
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
	 * @return chssPayFlg
	 */
	public String getChssPayFlg() {
		return this.chssPayFlg;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return beyondFdays
	 */
	public String getBeyondFdays() {
		return this.beyondFdays;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtFshFlg
	 */
	public String getMvmtFshFlg() {
		return this.mvmtFshFlg;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return stayingDays
	 */
	public String getStayingDays() {
		return this.stayingDays;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return chssVndrNm
	 */
	public String getChssVndrNm() {
		return this.chssVndrNm;
	}
	
	/**
	 * Column Info
	 * @return porDelYdCd
	 */
	public String getPorDelYdCd() {
		return this.porDelYdCd;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return clkStopFlg
	 */
	public String getClkStopFlg() {
		return this.clkStopFlg;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param vvdNo
	 */
	public void setVvdNo(String vvdNo) {
		this.vvdNo = vvdNo;
	}
	
	/**
	 * Column Info
	 * @param chssVndrSeq
	 */
	public void setChssVndrSeq(String chssVndrSeq) {
		this.chssVndrSeq = chssVndrSeq;
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
	 * @param boundCd
	 */
	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtEvntDt
	 */
	public void setFmMvmtEvntDt(String fmMvmtEvntDt) {
		this.fmMvmtEvntDt = fmMvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @param ydStayDys
	 */
	public void setYdStayDys(String ydStayDys) {
		this.ydStayDys = ydStayDys;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param tmlFreeDys
	 */
	public void setTmlFreeDys(String tmlFreeDys) {
		this.tmlFreeDys = tmlFreeDys;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param mvmtEvntDt
	 */
	public void setMvmtEvntDt(String mvmtEvntDt) {
		this.mvmtEvntDt = mvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @param locList
	 */
	public void setLocList(String locList) {
		this.locList = locList;
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
	 * @param polPodYdCd
	 */
	public void setPolPodYdCd(String polPodYdCd) {
		this.polPodYdCd = polPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param scCustNm
	 */
	public void setScCustNm(String scCustNm) {
		this.scCustNm = scCustNm;
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
	 * @param trkVndrSeq
	 */
	public void setTrkVndrSeq(String trkVndrSeq) {
		this.trkVndrSeq = trkVndrSeq;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param chssDlyChgAmt
	 */
	public void setChssDlyChgAmt(String chssDlyChgAmt) {
		this.chssDlyChgAmt = chssDlyChgAmt;
	}
	
	/**
	 * Column Info
	 * @param deRcvTermCd
	 */
	public void setDeRcvTermCd(String deRcvTermCd) {
		this.deRcvTermCd = deRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param clkStopDys
	 */
	public void setClkStopDys(String clkStopDys) {
		this.clkStopDys = clkStopDys;
	}
	
	/**
	 * Column Info
	 * @param etdEtaDt
	 */
	public void setEtdEtaDt(String etdEtaDt) {
		this.etdEtaDt = etdEtaDt;
	}
	
	/**
	 * Column Info
	 * @param trkVndrNm
	 */
	public void setTrkVndrNm(String trkVndrNm) {
		this.trkVndrNm = trkVndrNm;
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
	 * @param ltDt
	 */
	public void setLtDt(String ltDt) {
		this.ltDt = ltDt;
	}
	
	/**
	 * Column Info
	 * @param invtSeq
	 */
	public void setInvtSeq(String invtSeq) {
		this.invtSeq = invtSeq;
	}
	
	/**
	 * Column Info
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
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
	 * @param chssExptFlg
	 */
	public void setChssExptFlg(String chssExptFlg) {
		this.chssExptFlg = chssExptFlg;
	}
	
	/**
	 * Column Info
	 * @param chssTtlChgAmt
	 */
	public void setChssTtlChgAmt(String chssTtlChgAmt) {
		this.chssTtlChgAmt = chssTtlChgAmt;
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
	 * @param chssPayFlg
	 */
	public void setChssPayFlg(String chssPayFlg) {
		this.chssPayFlg = chssPayFlg;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param beyondFdays
	 */
	public void setBeyondFdays(String beyondFdays) {
		this.beyondFdays = beyondFdays;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtFshFlg
	 */
	public void setMvmtFshFlg(String mvmtFshFlg) {
		this.mvmtFshFlg = mvmtFshFlg;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param stayingDays
	 */
	public void setStayingDays(String stayingDays) {
		this.stayingDays = stayingDays;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param chssVndrNm
	 */
	public void setChssVndrNm(String chssVndrNm) {
		this.chssVndrNm = chssVndrNm;
	}
	
	/**
	 * Column Info
	 * @param porDelYdCd
	 */
	public void setPorDelYdCd(String porDelYdCd) {
		this.porDelYdCd = porDelYdCd;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param clkStopFlg
	 */
	public void setClkStopFlg(String clkStopFlg) {
		this.clkStopFlg = clkStopFlg;
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
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setVvdNo(JSPUtil.getParameter(request, prefix + "vvd_no", ""));
		setChssVndrSeq(JSPUtil.getParameter(request, prefix + "chss_vndr_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBoundCd(JSPUtil.getParameter(request, prefix + "bound_cd", ""));
		setFmMvmtEvntDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_evnt_dt", ""));
		setYdStayDys(JSPUtil.getParameter(request, prefix + "yd_stay_dys", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setTmlFreeDys(JSPUtil.getParameter(request, prefix + "tml_free_dys", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMvmtEvntDt(JSPUtil.getParameter(request, prefix + "mvmt_evnt_dt", ""));
		setLocList(JSPUtil.getParameter(request, prefix + "loc_list", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPolPodYdCd(JSPUtil.getParameter(request, prefix + "pol_pod_yd_cd", ""));
		setScCustNm(JSPUtil.getParameter(request, prefix + "sc_cust_nm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTrkVndrSeq(JSPUtil.getParameter(request, prefix + "trk_vndr_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setChssDlyChgAmt(JSPUtil.getParameter(request, prefix + "chss_dly_chg_amt", ""));
		setDeRcvTermCd(JSPUtil.getParameter(request, prefix + "de_rcv_term_cd", ""));
		setClkStopDys(JSPUtil.getParameter(request, prefix + "clk_stop_dys", ""));
		setEtdEtaDt(JSPUtil.getParameter(request, prefix + "etd_eta_dt", ""));
		setTrkVndrNm(JSPUtil.getParameter(request, prefix + "trk_vndr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLtDt(JSPUtil.getParameter(request, prefix + "lt_dt", ""));
		setInvtSeq(JSPUtil.getParameter(request, prefix + "invt_seq", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChssExptFlg(JSPUtil.getParameter(request, prefix + "chss_expt_flg", ""));
		setChssTtlChgAmt(JSPUtil.getParameter(request, prefix + "chss_ttl_chg_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setChssPayFlg(JSPUtil.getParameter(request, prefix + "chss_pay_flg", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setBeyondFdays(JSPUtil.getParameter(request, prefix + "beyond_fdays", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setMvmtFshFlg(JSPUtil.getParameter(request, prefix + "mvmt_fsh_flg", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setStayingDays(JSPUtil.getParameter(request, prefix + "staying_days", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setChssVndrNm(JSPUtil.getParameter(request, prefix + "chss_vndr_nm", ""));
		setPorDelYdCd(JSPUtil.getParameter(request, prefix + "por_del_yd_cd", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setClkStopFlg(JSPUtil.getParameter(request, prefix + "clk_stop_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChassisLongStayingVO[]
	 */
	public ChassisLongStayingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChassisLongStayingVO[]
	 */
	public ChassisLongStayingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChassisLongStayingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] vvdNo = (JSPUtil.getParameter(request, prefix	+ "vvd_no", length));
			String[] chssVndrSeq = (JSPUtil.getParameter(request, prefix	+ "chss_vndr_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] boundCd = (JSPUtil.getParameter(request, prefix	+ "bound_cd", length));
			String[] fmMvmtEvntDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_evnt_dt", length));
			String[] ydStayDys = (JSPUtil.getParameter(request, prefix	+ "yd_stay_dys", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] tmlFreeDys = (JSPUtil.getParameter(request, prefix	+ "tml_free_dys", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mvmtEvntDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_evnt_dt", length));
			String[] locList = (JSPUtil.getParameter(request, prefix	+ "loc_list", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] polPodYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_pod_yd_cd", length));
			String[] scCustNm = (JSPUtil.getParameter(request, prefix	+ "sc_cust_nm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] trkVndrSeq = (JSPUtil.getParameter(request, prefix	+ "trk_vndr_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] chssDlyChgAmt = (JSPUtil.getParameter(request, prefix	+ "chss_dly_chg_amt", length));
			String[] deRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "de_rcv_term_cd", length));
			String[] clkStopDys = (JSPUtil.getParameter(request, prefix	+ "clk_stop_dys", length));
			String[] etdEtaDt = (JSPUtil.getParameter(request, prefix	+ "etd_eta_dt", length));
			String[] trkVndrNm = (JSPUtil.getParameter(request, prefix	+ "trk_vndr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ltDt = (JSPUtil.getParameter(request, prefix	+ "lt_dt", length));
			String[] invtSeq = (JSPUtil.getParameter(request, prefix	+ "invt_seq", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssExptFlg = (JSPUtil.getParameter(request, prefix	+ "chss_expt_flg", length));
			String[] chssTtlChgAmt = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_chg_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chssPayFlg = (JSPUtil.getParameter(request, prefix	+ "chss_pay_flg", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] beyondFdays = (JSPUtil.getParameter(request, prefix	+ "beyond_fdays", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] mvmtFshFlg = (JSPUtil.getParameter(request, prefix	+ "mvmt_fsh_flg", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] stayingDays = (JSPUtil.getParameter(request, prefix	+ "staying_days", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] chssVndrNm = (JSPUtil.getParameter(request, prefix	+ "chss_vndr_nm", length));
			String[] porDelYdCd = (JSPUtil.getParameter(request, prefix	+ "por_del_yd_cd", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] clkStopFlg = (JSPUtil.getParameter(request, prefix	+ "clk_stop_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChassisLongStayingVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (vvdNo[i] != null)
					model.setVvdNo(vvdNo[i]);
				if (chssVndrSeq[i] != null)
					model.setChssVndrSeq(chssVndrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (boundCd[i] != null)
					model.setBoundCd(boundCd[i]);
				if (fmMvmtEvntDt[i] != null)
					model.setFmMvmtEvntDt(fmMvmtEvntDt[i]);
				if (ydStayDys[i] != null)
					model.setYdStayDys(ydStayDys[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (tmlFreeDys[i] != null)
					model.setTmlFreeDys(tmlFreeDys[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mvmtEvntDt[i] != null)
					model.setMvmtEvntDt(mvmtEvntDt[i]);
				if (locList[i] != null)
					model.setLocList(locList[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (polPodYdCd[i] != null)
					model.setPolPodYdCd(polPodYdCd[i]);
				if (scCustNm[i] != null)
					model.setScCustNm(scCustNm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (trkVndrSeq[i] != null)
					model.setTrkVndrSeq(trkVndrSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (chssDlyChgAmt[i] != null)
					model.setChssDlyChgAmt(chssDlyChgAmt[i]);
				if (deRcvTermCd[i] != null)
					model.setDeRcvTermCd(deRcvTermCd[i]);
				if (clkStopDys[i] != null)
					model.setClkStopDys(clkStopDys[i]);
				if (etdEtaDt[i] != null)
					model.setEtdEtaDt(etdEtaDt[i]);
				if (trkVndrNm[i] != null)
					model.setTrkVndrNm(trkVndrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ltDt[i] != null)
					model.setLtDt(ltDt[i]);
				if (invtSeq[i] != null)
					model.setInvtSeq(invtSeq[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssExptFlg[i] != null)
					model.setChssExptFlg(chssExptFlg[i]);
				if (chssTtlChgAmt[i] != null)
					model.setChssTtlChgAmt(chssTtlChgAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chssPayFlg[i] != null)
					model.setChssPayFlg(chssPayFlg[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (beyondFdays[i] != null)
					model.setBeyondFdays(beyondFdays[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (mvmtFshFlg[i] != null)
					model.setMvmtFshFlg(mvmtFshFlg[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (stayingDays[i] != null)
					model.setStayingDays(stayingDays[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (chssVndrNm[i] != null)
					model.setChssVndrNm(chssVndrNm[i]);
				if (porDelYdCd[i] != null)
					model.setPorDelYdCd(porDelYdCd[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (clkStopFlg[i] != null)
					model.setClkStopFlg(clkStopFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChassisLongStayingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChassisLongStayingVO[]
	 */
	public ChassisLongStayingVO[] getChassisLongStayingVOs(){
		ChassisLongStayingVO[] vos = (ChassisLongStayingVO[])models.toArray(new ChassisLongStayingVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNo = this.vvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVndrSeq = this.chssVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundCd = this.boundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtEvntDt = this.fmMvmtEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydStayDys = this.ydStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlFreeDys = this.tmlFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEvntDt = this.mvmtEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locList = this.locList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodYdCd = this.polPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustNm = this.scCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVndrSeq = this.trkVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssDlyChgAmt = this.chssDlyChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deRcvTermCd = this.deRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopDys = this.clkStopDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdEtaDt = this.etdEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVndrNm = this.trkVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltDt = this.ltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtSeq = this.invtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssExptFlg = this.chssExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlChgAmt = this.chssTtlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPayFlg = this.chssPayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beyondFdays = this.beyondFdays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtFshFlg = this.mvmtFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayingDays = this.stayingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVndrNm = this.chssVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDelYdCd = this.porDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopFlg = this.clkStopFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
