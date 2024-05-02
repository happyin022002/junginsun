/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MVMTBookingInfoVO.java
*@FileTitle : MVMTBookingInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.22 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MVMTBookingInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MVMTBookingInfoVO> models = new ArrayList<MVMTBookingInfoVO>();
	
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ext = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String cntrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String nlsCnt = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String vrSeq = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mtyPlnNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrSvrId = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String dmgFlgDt = null;
	/* Column Info */
	private String dmgUnflgDt = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String lstFlg = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String cntrRfubFlg = null;	
	/* Column Info */
	private String usaEdiCd = null;	
	/* Column Info */
	private String cntrStwgPsnCtnt = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MVMTBookingInfoVO() {}

	public MVMTBookingInfoVO(String ibflag, String pagerows, String bkgCgoTpCd, String bkgKnt, String bkgNo, String mtyPlnNo, String bkgNoSplit, String blNo, String blNoChk, String blNoTp, String checkDigit, String chssNo, String cnmvCoCd, String cnmvCycNo, String cnmvEvntDt, String cnmvIdNo, String cnmvLvlNo, String cnmvRmk, String cnmvSeq, String cnmvSplitNo, String cnmvYr, String cntrDispFlg, String cntrDmgFlg, String dmgFlgDt, String dmgUnflgDt, String cntrHngrBarAtchKnt, String cntrHngrRckCd, String cntrId, String cntrNo, String cntrSealNo, String cntrSvrId, String cntrTpszCd, String cntrXchCd, String creDt, String creLoclDt, String creUsrId, String crntSkdDirCd, String crntSkdVoyNo, String crntVslCd, String ctrtSeq, String destYdCd, String ext, String fcntrFlg, String imdtExtFlg, String lstFlg, String mgstNo, String mvmtCreTpCd, String mvmtEdiMsgAreaCd, String mvmtEdiMsgSeq, String mvmtEdiMsgTpId, String mvmtEdiMsgYrmondy, String mvmtEdiTpCd, String mvmtStsCd, String mvmtTrspModCd, String nlsCnt, String obCntrFlg, String ofcCd, String orgYdCd, String pkupNo, String preStsFlg, String pCntrno, String pDate1, String pDate2, String spclCgoFlg, String svrId, String updDt, String updLoclDt, String updUsrId, String usrNm, String vndrAbbrNm, String vndrSeq, String vrSeq, String vvdCd, String wblNo, String cntrRfubFlg, String usaEdiCd, String cntrStwgPsnCtnt) {
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.cnmvSeq = cnmvSeq;
		this.chssNo = chssNo;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.destYdCd = destYdCd;
		this.ctrtSeq = ctrtSeq;
		this.blNo = blNo;
		this.ext = ext;
		this.pagerows = pagerows;
		this.pDate1 = pDate1;
		this.blNoChk = blNoChk;
		this.vvdCd = vvdCd;
		this.cntrXchCd = cntrXchCd;
		this.pDate2 = pDate2;
		this.cntrId = cntrId;
		this.cntrTpszCd = cntrTpszCd;
		this.blNoTp = blNoTp;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.updUsrId = updUsrId;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.nlsCnt = nlsCnt;
		this.wblNo = wblNo;
		this.updLoclDt = updLoclDt;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.vrSeq = vrSeq;
		this.cnmvIdNo = cnmvIdNo;
		this.pCntrno = pCntrno;
		this.bkgNo = bkgNo;
		this.mtyPlnNo = mtyPlnNo;
		this.creUsrId = creUsrId;
		this.cnmvRmk = cnmvRmk;
		this.creLoclDt = creLoclDt;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.vndrSeq = vndrSeq;
		this.cntrDispFlg = cntrDispFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.pkupNo = pkupNo;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.cnmvCycNo = cnmvCycNo;
		this.cnmvLvlNo = cnmvLvlNo;
		this.checkDigit = checkDigit;
		this.creDt = creDt;
		this.cntrSvrId = cntrSvrId;
		this.fcntrFlg = fcntrFlg;
		this.svrId = svrId;
		this.cntrDmgFlg = cntrDmgFlg;
		this.dmgFlgDt = dmgFlgDt;
		this.dmgUnflgDt = dmgUnflgDt;
		this.cnmvSplitNo = cnmvSplitNo;
		this.ibflag = ibflag;
		this.bkgKnt = bkgKnt;
		this.lstFlg = lstFlg;
		this.usrNm = usrNm;
		this.updDt = updDt;
		this.bkgNoSplit = bkgNoSplit;
		this.crntSkdDirCd = crntSkdDirCd;
		this.preStsFlg = preStsFlg;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.obCntrFlg = obCntrFlg;
		this.ofcCd = ofcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.cntrNo = cntrNo;
		this.cntrSealNo = cntrSealNo;
		this.imdtExtFlg = imdtExtFlg;
		this.cnmvYr = cnmvYr;
		this.cnmvCoCd = cnmvCoCd;
		this.crntVslCd = crntVslCd;
		this.cntrRfubFlg = cntrRfubFlg;
		this.usaEdiCd = usaEdiCd;
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ext", getExt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cntr_id", getCntrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("nls_cnt", getNlsCnt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("vr_seq", getVrSeq());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("lst_flg", getLstFlg());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());	
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());	
		this.hashColumns.put("cntr_stwg_psn_ctnt", getCntrStwgPsnCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ext", "ext");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("nls_cnt", "nlsCnt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("vr_seq", "vrSeq");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("lst_flg", "lstFlg");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("cntr_stwg_psn_ctnt", "cntrStwgPsnCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
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
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgSeq
	 */
	public String getMvmtEdiMsgSeq() {
		return this.mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtSeq
	 */
	public String getCtrtSeq() {
		return this.ctrtSeq;
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
	 * @return ext
	 */
	public String getExt() {
		return this.ext;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return cntrId
	 */
	public String getCntrId() {
		return this.cntrId;
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
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiTpCd
	 */
	public String getMvmtEdiTpCd() {
		return this.mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
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
	 * @return mvmtEdiMsgAreaCd
	 */
	public String getMvmtEdiMsgAreaCd() {
		return this.mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @return nlsCnt
	 */
	public String getNlsCnt() {
		return this.nlsCnt;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return updLoclDt
	 */
	public String getUpdLoclDt() {
		return this.updLoclDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @return vrSeq
	 */
	public String getVrSeq() {
		return this.vrSeq;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
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
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgYrmondy
	 */
	public String getMvmtEdiMsgYrmondy() {
		return this.mvmtEdiMsgYrmondy;
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
	 * @return cntrDispFlg
	 */
	public String getCntrDispFlg() {
		return this.cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvLvlNo
	 */
	public String getCnmvLvlNo() {
		return this.cnmvLvlNo;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
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
	 * @return cntrSvrId
	 */
	public String getCntrSvrId() {
		return this.cntrSvrId;
	}
	
	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return dmgFlgDt
	 */
	public String getDmgFlgDt() {
		return this.dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @return dmgUnflgDt
	 */
	public String getDmgUnflgDt() {
		return this.dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
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
	 * @return bkgKnt
	 */
	public String getBkgKnt() {
		return this.bkgKnt;
	}
	
	/**
	 * Column Info
	 * @return lstFlg
	 */
	public String getLstFlg() {
		return this.lstFlg;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return preStsFlg
	 */
	public String getPreStsFlg() {
		return this.preStsFlg;
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
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
	}
	
	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgPsnCtnt
	 */
	public String getCntrStwgPsnCtnt() {
		return this.cntrStwgPsnCtnt;
	}
	

	/**
	 * Column Info
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
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
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgSeq
	 */
	public void setMvmtEdiMsgSeq(String mvmtEdiMsgSeq) {
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
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
	 * @param ext
	 */
	public void setExt(String ext) {
		this.ext = ext;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param cntrId
	 */
	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
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
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiTpCd
	 */
	public void setMvmtEdiTpCd(String mvmtEdiTpCd) {
		this.mvmtEdiTpCd = mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
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
	 * @param mvmtEdiMsgAreaCd
	 */
	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @param nlsCnt
	 */
	public void setNlsCnt(String nlsCnt) {
		this.nlsCnt = nlsCnt;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param updLoclDt
	 */
	public void setUpdLoclDt(String updLoclDt) {
		this.updLoclDt = updLoclDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
	}
	
	/**
	 * Column Info
	 * @param vrSeq
	 */
	public void setVrSeq(String vrSeq) {
		this.vrSeq = vrSeq;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param bkgNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
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
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgYrmondy
	 */
	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
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
	 * @param cntrDispFlg
	 */
	public void setCntrDispFlg(String cntrDispFlg) {
		this.cntrDispFlg = cntrDispFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
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
	 * @param cntrSvrId
	 */
	public void setCntrSvrId(String cntrSvrId) {
		this.cntrSvrId = cntrSvrId;
	}
	
	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param dmgFlgDt
	 */
	public void setDmgFlgDt(String dmgFlgDt) {
		this.dmgFlgDt = dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @param dmgUnflgDt
	 */
	public void setDmgUnflgDt(String dmgUnflgDt) {
		this.dmgUnflgDt = dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
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
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
	}
	
	/**
	 * Column Info
	 * @param lstFlg
	 */
	public void setLstFlg(String lstFlg) {
		this.lstFlg = lstFlg;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param preStsFlg
	 */
	public void setPreStsFlg(String preStsFlg) {
		this.preStsFlg = preStsFlg;
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
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * Column Info
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}

	/**
	 * Column Info
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
	}

	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}

	/**
	 * Column Info
	 * @param cntrStwgPsnCtnt
	 */
	public void setCntrStwgPsnCtnt(String cntrStwgPsnCtnt) {
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
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
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_seq", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setCtrtSeq(JSPUtil.getParameter(request, prefix + "ctrt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setExt(JSPUtil.getParameter(request, prefix + "ext", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request, prefix + "cntr_xch_cd", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setCntrId(JSPUtil.getParameter(request, prefix + "cntr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_tp_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "cntr_hngr_bar_atch_knt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_area_cd", ""));
		setNlsCnt(JSPUtil.getParameter(request, prefix + "nls_cnt", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setVrSeq(JSPUtil.getParameter(request, prefix + "vr_seq", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_yrmondy", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, prefix + "cntr_disp_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, prefix + "cnmv_lvl_no", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntrSvrId(JSPUtil.getParameter(request, prefix + "cntr_svr_id", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setDmgFlgDt(JSPUtil.getParameter(request, prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request, prefix + "dmg_unflg_dt", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgKnt(JSPUtil.getParameter(request, prefix + "bkg_knt", ""));
		setLstFlg(JSPUtil.getParameter(request, prefix + "lst_flg", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setPreStsFlg(JSPUtil.getParameter(request, prefix + "pre_sts_flg", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, prefix + "cntr_rfub_flg", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setCntrStwgPsnCtnt(JSPUtil.getParameter(request, prefix + "cntr_stwg_psn_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MVMTBookingInfoVO[]
	 */
	public MVMTBookingInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MVMTBookingInfoVO[]
	 */
	public MVMTBookingInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MVMTBookingInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ext = (JSPUtil.getParameter(request, prefix	+ "ext", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] cntrId = (JSPUtil.getParameter(request, prefix	+ "cntr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] nlsCnt = (JSPUtil.getParameter(request, prefix	+ "nls_cnt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] vrSeq = (JSPUtil.getParameter(request, prefix	+ "vr_seq", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrSvrId = (JSPUtil.getParameter(request, prefix	+ "cntr_svr_id", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] dmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_flg_dt", length));
			String[] dmgUnflgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_unflg_dt", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] lstFlg = (JSPUtil.getParameter(request, prefix	+ "lst_flg", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] preStsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_sts_flg", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] cntrStwgPsnCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_psn_ctnt", length));	
			
			for (int i = 0; i < length; i++) {
				model = new MVMTBookingInfoVO();
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ext[i] != null)
					model.setExt(ext[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (cntrId[i] != null)
					model.setCntrId(cntrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (nlsCnt[i] != null)
					model.setNlsCnt(nlsCnt[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (vrSeq[i] != null)
					model.setVrSeq(vrSeq[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrSvrId[i] != null)
					model.setCntrSvrId(cntrSvrId[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (dmgFlgDt[i] != null)
					model.setDmgFlgDt(dmgFlgDt[i]);
				if (dmgUnflgDt[i] != null)
					model.setDmgUnflgDt(dmgUnflgDt[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (lstFlg[i] != null)
					model.setLstFlg(lstFlg[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (preStsFlg[i] != null)
					model.setPreStsFlg(preStsFlg[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (cntrStwgPsnCtnt[i] != null)
					model.setCntrStwgPsnCtnt(cntrStwgPsnCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMVMTBookingInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MVMTBookingInfoVO[]
	 */
	public MVMTBookingInfoVO[] getMVMTBookingInfoVOs(){
		MVMTBookingInfoVO[] vos = (MVMTBookingInfoVO[])models.toArray(new MVMTBookingInfoVO[models.size()]);
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
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ext = this.ext .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId = this.cntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nlsCnt = this.nlsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrSeq = this.vrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId = this.cntrSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt = this.dmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt = this.dmgUnflgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFlg = this.lstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg = this.preStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgPsnCtnt = this.cntrStwgPsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
