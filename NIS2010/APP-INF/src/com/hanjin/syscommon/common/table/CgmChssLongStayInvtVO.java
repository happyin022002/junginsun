/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CgmChssLongStayInvtVO.java
*@FileTitle : CgmChssLongStayInvtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CgmChssLongStayInvtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CgmChssLongStayInvtVO> models = new ArrayList<CgmChssLongStayInvtVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String clkStopDys = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String etdEtaDt = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chssVndrSeq = null;
	/* Column Info */
	private String invtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String fmMvmtEvntDt = null;
	/* Column Info */
	private String ydStayDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmlFreeDys = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String chssExptFlg = null;
	/* Column Info */
	private String chssTtlChgAmt = null;
	/* Column Info */
	private String mvmtEvntDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String polPodYdCd = null;
	/* Column Info */
	private String chssPayFlg = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String mvmtFshFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String trkVndrSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String porDelYdCd = null;
	/* Column Info */
	private String chssDlyChgAmt = null;
	/* Column Info */
	private String deRcvTermCd = null;
	/* Column Info */
	private String clkStopFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CgmChssLongStayInvtVO() {}

	public CgmChssLongStayInvtVO(String ibflag, String pagerows, String invtSeq, String vslCd, String skdVoyNo, String skdDirCd, String bkgNo, String cntrNo, String cntrTpszCd, String chssNo, String ydCd, String fullMtyCd, String ioBndCd, String mvmtFshFlg, String mvmtStsCd, String mvmtEvntDt, String fmMvmtStsCd, String fmMvmtEvntDt, String ydStayDys, String tmlFreeDys, String clkStopDys, String deRcvTermCd, String chssExptFlg, String clkStopFlg, String chssPayFlg, String agnAgmtNo, String chssPoolCd, String chssVndrSeq, String chssDlyChgAmt, String chssTtlChgAmt, String trkVndrSeq, String polPodYdCd, String porDelYdCd, String etdEtaDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.clkStopDys = clkStopDys;
		this.chssPoolCd = chssPoolCd;
		this.etdEtaDt = etdEtaDt;
		this.chssNo = chssNo;
		this.creDt = creDt;
		this.chssVndrSeq = chssVndrSeq;
		this.invtSeq = invtSeq;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.fmMvmtEvntDt = fmMvmtEvntDt;
		this.ydStayDys = ydStayDys;
		this.ibflag = ibflag;
		this.tmlFreeDys = tmlFreeDys;
		this.cntrTpszCd = cntrTpszCd;
		this.chssExptFlg = chssExptFlg;
		this.chssTtlChgAmt = chssTtlChgAmt;
		this.mvmtEvntDt = mvmtEvntDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.polPodYdCd = polPodYdCd;
		this.chssPayFlg = chssPayFlg;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.mvmtFshFlg = mvmtFshFlg;
		this.skdVoyNo = skdVoyNo;
		this.ioBndCd = ioBndCd;
		this.trkVndrSeq = trkVndrSeq;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.mvmtStsCd = mvmtStsCd;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.fullMtyCd = fullMtyCd;
		this.porDelYdCd = porDelYdCd;
		this.chssDlyChgAmt = chssDlyChgAmt;
		this.deRcvTermCd = deRcvTermCd;
		this.clkStopFlg = clkStopFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("clk_stop_dys", getClkStopDys());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("etd_eta_dt", getEtdEtaDt());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chss_vndr_seq", getChssVndrSeq());
		this.hashColumns.put("invt_seq", getInvtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("fm_mvmt_evnt_dt", getFmMvmtEvntDt());
		this.hashColumns.put("yd_stay_dys", getYdStayDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tml_free_dys", getTmlFreeDys());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("chss_expt_flg", getChssExptFlg());
		this.hashColumns.put("chss_ttl_chg_amt", getChssTtlChgAmt());
		this.hashColumns.put("mvmt_evnt_dt", getMvmtEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pol_pod_yd_cd", getPolPodYdCd());
		this.hashColumns.put("chss_pay_flg", getChssPayFlg());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("mvmt_fsh_flg", getMvmtFshFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("trk_vndr_seq", getTrkVndrSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("por_del_yd_cd", getPorDelYdCd());
		this.hashColumns.put("chss_dly_chg_amt", getChssDlyChgAmt());
		this.hashColumns.put("de_rcv_term_cd", getDeRcvTermCd());
		this.hashColumns.put("clk_stop_flg", getClkStopFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("clk_stop_dys", "clkStopDys");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("etd_eta_dt", "etdEtaDt");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chss_vndr_seq", "chssVndrSeq");
		this.hashFields.put("invt_seq", "invtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("fm_mvmt_evnt_dt", "fmMvmtEvntDt");
		this.hashFields.put("yd_stay_dys", "ydStayDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tml_free_dys", "tmlFreeDys");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chss_expt_flg", "chssExptFlg");
		this.hashFields.put("chss_ttl_chg_amt", "chssTtlChgAmt");
		this.hashFields.put("mvmt_evnt_dt", "mvmtEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pol_pod_yd_cd", "polPodYdCd");
		this.hashFields.put("chss_pay_flg", "chssPayFlg");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("mvmt_fsh_flg", "mvmtFshFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("trk_vndr_seq", "trkVndrSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("por_del_yd_cd", "porDelYdCd");
		this.hashFields.put("chss_dly_chg_amt", "chssDlyChgAmt");
		this.hashFields.put("de_rcv_term_cd", "deRcvTermCd");
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
	 * @return clkStopDys
	 */
	public String getClkStopDys() {
		return this.clkStopDys;
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
	 * @return etdEtaDt
	 */
	public String getEtdEtaDt() {
		return this.etdEtaDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return chssVndrSeq
	 */
	public String getChssVndrSeq() {
		return this.chssVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invtSeq
	 */
	public String getInvtSeq() {
		return this.invtSeq;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return mvmtEvntDt
	 */
	public String getMvmtEvntDt() {
		return this.mvmtEvntDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return chssPayFlg
	 */
	public String getChssPayFlg() {
		return this.chssPayFlg;
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
	 * @return mvmtFshFlg
	 */
	public String getMvmtFshFlg() {
		return this.mvmtFshFlg;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
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
	 * @param clkStopDys
	 */
	public void setClkStopDys(String clkStopDys) {
		this.clkStopDys = clkStopDys;
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
	 * @param etdEtaDt
	 */
	public void setEtdEtaDt(String etdEtaDt) {
		this.etdEtaDt = etdEtaDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param chssVndrSeq
	 */
	public void setChssVndrSeq(String chssVndrSeq) {
		this.chssVndrSeq = chssVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invtSeq
	 */
	public void setInvtSeq(String invtSeq) {
		this.invtSeq = invtSeq;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param mvmtEvntDt
	 */
	public void setMvmtEvntDt(String mvmtEvntDt) {
		this.mvmtEvntDt = mvmtEvntDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param chssPayFlg
	 */
	public void setChssPayFlg(String chssPayFlg) {
		this.chssPayFlg = chssPayFlg;
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
	 * @param mvmtFshFlg
	 */
	public void setMvmtFshFlg(String mvmtFshFlg) {
		this.mvmtFshFlg = mvmtFshFlg;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
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
		setClkStopDys(JSPUtil.getParameter(request, prefix + "clk_stop_dys", ""));
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setEtdEtaDt(JSPUtil.getParameter(request, prefix + "etd_eta_dt", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChssVndrSeq(JSPUtil.getParameter(request, prefix + "chss_vndr_seq", ""));
		setInvtSeq(JSPUtil.getParameter(request, prefix + "invt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setFmMvmtEvntDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_evnt_dt", ""));
		setYdStayDys(JSPUtil.getParameter(request, prefix + "yd_stay_dys", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTmlFreeDys(JSPUtil.getParameter(request, prefix + "tml_free_dys", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setChssExptFlg(JSPUtil.getParameter(request, prefix + "chss_expt_flg", ""));
		setChssTtlChgAmt(JSPUtil.getParameter(request, prefix + "chss_ttl_chg_amt", ""));
		setMvmtEvntDt(JSPUtil.getParameter(request, prefix + "mvmt_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPolPodYdCd(JSPUtil.getParameter(request, prefix + "pol_pod_yd_cd", ""));
		setChssPayFlg(JSPUtil.getParameter(request, prefix + "chss_pay_flg", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setMvmtFshFlg(JSPUtil.getParameter(request, prefix + "mvmt_fsh_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setTrkVndrSeq(JSPUtil.getParameter(request, prefix + "trk_vndr_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setPorDelYdCd(JSPUtil.getParameter(request, prefix + "por_del_yd_cd", ""));
		setChssDlyChgAmt(JSPUtil.getParameter(request, prefix + "chss_dly_chg_amt", ""));
		setDeRcvTermCd(JSPUtil.getParameter(request, prefix + "de_rcv_term_cd", ""));
		setClkStopFlg(JSPUtil.getParameter(request, prefix + "clk_stop_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgmChssLongStayInvtVO[]
	 */
	public CgmChssLongStayInvtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgmChssLongStayInvtVO[]
	 */
	public CgmChssLongStayInvtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CgmChssLongStayInvtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] clkStopDys = (JSPUtil.getParameter(request, prefix	+ "clk_stop_dys", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] etdEtaDt = (JSPUtil.getParameter(request, prefix	+ "etd_eta_dt", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chssVndrSeq = (JSPUtil.getParameter(request, prefix	+ "chss_vndr_seq", length));
			String[] invtSeq = (JSPUtil.getParameter(request, prefix	+ "invt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] fmMvmtEvntDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_evnt_dt", length));
			String[] ydStayDys = (JSPUtil.getParameter(request, prefix	+ "yd_stay_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmlFreeDys = (JSPUtil.getParameter(request, prefix	+ "tml_free_dys", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] chssExptFlg = (JSPUtil.getParameter(request, prefix	+ "chss_expt_flg", length));
			String[] chssTtlChgAmt = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_chg_amt", length));
			String[] mvmtEvntDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_evnt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] polPodYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_pod_yd_cd", length));
			String[] chssPayFlg = (JSPUtil.getParameter(request, prefix	+ "chss_pay_flg", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] mvmtFshFlg = (JSPUtil.getParameter(request, prefix	+ "mvmt_fsh_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] trkVndrSeq = (JSPUtil.getParameter(request, prefix	+ "trk_vndr_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] porDelYdCd = (JSPUtil.getParameter(request, prefix	+ "por_del_yd_cd", length));
			String[] chssDlyChgAmt = (JSPUtil.getParameter(request, prefix	+ "chss_dly_chg_amt", length));
			String[] deRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "de_rcv_term_cd", length));
			String[] clkStopFlg = (JSPUtil.getParameter(request, prefix	+ "clk_stop_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CgmChssLongStayInvtVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (clkStopDys[i] != null)
					model.setClkStopDys(clkStopDys[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (etdEtaDt[i] != null)
					model.setEtdEtaDt(etdEtaDt[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chssVndrSeq[i] != null)
					model.setChssVndrSeq(chssVndrSeq[i]);
				if (invtSeq[i] != null)
					model.setInvtSeq(invtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (fmMvmtEvntDt[i] != null)
					model.setFmMvmtEvntDt(fmMvmtEvntDt[i]);
				if (ydStayDys[i] != null)
					model.setYdStayDys(ydStayDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmlFreeDys[i] != null)
					model.setTmlFreeDys(tmlFreeDys[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (chssExptFlg[i] != null)
					model.setChssExptFlg(chssExptFlg[i]);
				if (chssTtlChgAmt[i] != null)
					model.setChssTtlChgAmt(chssTtlChgAmt[i]);
				if (mvmtEvntDt[i] != null)
					model.setMvmtEvntDt(mvmtEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (polPodYdCd[i] != null)
					model.setPolPodYdCd(polPodYdCd[i]);
				if (chssPayFlg[i] != null)
					model.setChssPayFlg(chssPayFlg[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (mvmtFshFlg[i] != null)
					model.setMvmtFshFlg(mvmtFshFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (trkVndrSeq[i] != null)
					model.setTrkVndrSeq(trkVndrSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (porDelYdCd[i] != null)
					model.setPorDelYdCd(porDelYdCd[i]);
				if (chssDlyChgAmt[i] != null)
					model.setChssDlyChgAmt(chssDlyChgAmt[i]);
				if (deRcvTermCd[i] != null)
					model.setDeRcvTermCd(deRcvTermCd[i]);
				if (clkStopFlg[i] != null)
					model.setClkStopFlg(clkStopFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgmChssLongStayInvtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgmChssLongStayInvtVO[]
	 */
	public CgmChssLongStayInvtVO[] getCgmChssLongStayInvtVOs(){
		CgmChssLongStayInvtVO[] vos = (CgmChssLongStayInvtVO[])models.toArray(new CgmChssLongStayInvtVO[models.size()]);
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
		this.clkStopDys = this.clkStopDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdEtaDt = this.etdEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVndrSeq = this.chssVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtSeq = this.invtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtEvntDt = this.fmMvmtEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydStayDys = this.ydStayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlFreeDys = this.tmlFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssExptFlg = this.chssExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlChgAmt = this.chssTtlChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEvntDt = this.mvmtEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodYdCd = this.polPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPayFlg = this.chssPayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtFshFlg = this.mvmtFshFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVndrSeq = this.trkVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDelYdCd = this.porDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssDlyChgAmt = this.chssDlyChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deRcvTermCd = this.deRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clkStopFlg = this.clkStopFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
