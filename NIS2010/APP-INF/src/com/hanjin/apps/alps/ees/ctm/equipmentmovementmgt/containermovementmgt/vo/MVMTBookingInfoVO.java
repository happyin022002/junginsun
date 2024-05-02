/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : MVMTBookingInfoVO.java
 * @FileTitle : MVMTBookingInfoVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.06.13
 * @LastModifier : 
 * @LastVersion : 1.0
 * 2013.07.16 김상수 1.0 Creation.
 * 2016.05.30 김상현 1.1 [CHM-201641787] 야드 정보 표시 기능 추가
 * 2016.06.13 김상현 [CHM-201641731] VGM 항목 추가
 */

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * Table Value Object.
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MVMTBookingInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MVMTBookingInfoVO> models = new ArrayList<MVMTBookingInfoVO>();
	
	/* Column Info */
	private String lstFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cnmvLvlNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrId = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String preStsFlg = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String ctrtSeq = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String cntrSvrId = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String orgYdNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ext = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vrSeq = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String modiTp = null;
	/* Column Info */
	private String cnmvHisColNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String cnmvSplitNo = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String vgm = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String lstBkgNo = null;
	/* Column Info */
	private String nlsCnt = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String destYdNm = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MVMTBookingInfoVO() {}

	public MVMTBookingInfoVO(String ibflag, String pagerows, String crntSkdVoyNo, String bkgCgoTpCd, String mvmtEdiMsgTpId, String cnmvSeq, String chssNo, String mvmtTrspModCd, String mvmtEdiMsgSeq, String destYdCd, String ctrtSeq, String blNo, String ext, String blNoChk, String pDate1, String cntrXchCd, String vvdCd, String pDate2, String cntrTpszCd, String cntrId, String mvmtEdiTpCd, String blNoTp, String cntrHngrBarAtchKnt, String cntrRfubFlg, String updUsrId, String mvmtEdiMsgAreaCd, String nlsCnt, String wblNo, String updLoclDt, String cnmvEvntDt, String spclCgoFlg, String mvmtCreTpCd, String vrSeq, String cnmvIdNo, String pCntrno, String bkgNo, String creUsrId, String cnmvRmk, String creLoclDt, String mvmtEdiMsgYrmondy, String vndrSeq, String cntrDispFlg, String vndrAbbrNm, String pkupNo, String cntrHngrRckCd, String cnmvCycNo, String cnmvLvlNo, String checkDigit, String creDt, String fcntrFlg, String cntrSvrId, String cnmvSplitNo, String cntrDmgFlg, String svrId, String lstFlg, String bkgKnt, String usrNm, String updDt, String bkgNoSplit, String crntSkdDirCd, String mgstNo, String orgYdCd, String preStsFlg, String obCntrFlg, String ofcCd, String mvmtStsCd, String cntrNo, String imdtExtFlg, String cntrSealNo, String cnmvCoCd, String cnmvYr, String crntVslCd, String lstBkgNo, String modiTp, String cnmvHisColNm, String orgYdNm, String destYdNm, String vgm) {
		this.lstFlg = lstFlg;
		this.blNo = blNo;
		this.bkgNo = bkgNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.updUsrId = updUsrId;
		this.pkupNo = pkupNo;
		this.cnmvLvlNo = cnmvLvlNo;
		this.vvdCd = vvdCd;
		this.cntrId = cntrId;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvIdNo = cnmvIdNo;
		this.preStsFlg = preStsFlg;
		this.crntVslCd = crntVslCd;
		this.blNoChk = blNoChk;
		this.wblNo = wblNo;
		this.destYdCd = destYdCd;
		this.cntrDmgFlg = cntrDmgFlg;
		this.ctrtSeq = ctrtSeq;
		this.cntrSealNo = cntrSealNo;
		this.checkDigit = checkDigit;
		this.cntrSvrId = cntrSvrId;
		this.bkgKnt = bkgKnt;
		this.bkgNoSplit = bkgNoSplit;
		this.cnmvSeq = cnmvSeq;
		this.orgYdNm = orgYdNm;
		this.pagerows = pagerows;
		this.ext = ext;
		this.ofcCd = ofcCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.cnmvEvntDt = cnmvEvntDt;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtStsCd = mvmtStsCd;
		this.creDt = creDt;
		this.vrSeq = vrSeq;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.vndrSeq = vndrSeq;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.pDate1 = pDate1;
		this.cntrTpszCd = cntrTpszCd;
		this.updDt = updDt;
		this.cnmvYr = cnmvYr;
		this.pDate2 = pDate2;
		this.cnmvCoCd = cnmvCoCd;
		this.ibflag = ibflag;
		this.cntrRfubFlg = cntrRfubFlg;
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.obCntrFlg = obCntrFlg;
		this.modiTp = modiTp;
		this.cnmvHisColNm = cnmvHisColNm;
		this.creUsrId = creUsrId;
		this.imdtExtFlg = imdtExtFlg;
		this.updLoclDt = updLoclDt;
		this.cnmvSplitNo = cnmvSplitNo;
		this.cntrDispFlg = cntrDispFlg;
		this.usrNm = usrNm;
		this.blNoTp = blNoTp;
		this.cnmvCycNo = cnmvCycNo;
		this.crntSkdDirCd = crntSkdDirCd;
		this.vgm = vgm;
		this.creLoclDt = creLoclDt;
		this.fcntrFlg = fcntrFlg;
		this.svrId = svrId;
		this.orgYdCd = orgYdCd;
		this.lstBkgNo = lstBkgNo;
		this.nlsCnt = nlsCnt;
		this.cnmvRmk = cnmvRmk;
		this.pCntrno = pCntrno;
		this.cntrXchCd = cntrXchCd;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.destYdNm = destYdNm;
		this.chssNo = chssNo;
		this.mgstNo = mgstNo;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lst_flg", getLstFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_id", getCntrId());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("pre_sts_flg", getPreStsFlg());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("ctrt_seq", getCtrtSeq());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("org_yd_nm", getOrgYdNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ext", getExt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vr_seq", getVrSeq());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("modi_tp", getModiTp());
		this.hashColumns.put("cnmv_his_col_nm", getCnmvHisColNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("vgm", getVgm());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("lst_bkg_no", getLstBkgNo());
		this.hashColumns.put("nls_cnt", getNlsCnt());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("dest_yd_nm", getDestYdNm());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lst_flg", "lstFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pre_sts_flg", "preStsFlg");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("ctrt_seq", "ctrtSeq");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("org_yd_nm", "orgYdNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ext", "ext");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vr_seq", "vrSeq");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("modi_tp", "modiTp");
		this.hashFields.put("cnmv_his_col_nm", "cnmvHisColNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("vgm", "vgm");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("lst_bkg_no", "lstBkgNo");
		this.hashFields.put("nls_cnt", "nlsCnt");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("dest_yd_nm", "destYdNm");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
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
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return mvmtEdiTpCd
	 */
	public String getMvmtEdiTpCd() {
		return this.mvmtEdiTpCd;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
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
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
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
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
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
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
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
	 * @return cntrSvrId
	 */
	public String getCntrSvrId() {
		return this.cntrSvrId;
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
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return orgYdNm
	 */
	public String getOrgYdNm() {
		return this.orgYdNm;
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
	 * @return ext
	 */
	public String getExt() {
		return this.ext;
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
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
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
	 * @return mvmtCreTpCd
	 */
	public String getMvmtCreTpCd() {
		return this.mvmtCreTpCd;
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
	 * @return spclCgoFlg
	 */
	public String getSpclCgoFlg() {
		return this.spclCgoFlg;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
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
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
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
	 * @return cnmvCoCd
	 */
	public String getCnmvCoCd() {
		return this.cnmvCoCd;
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
	 * @return cntrRfubFlg
	 */
	public String getCntrRfubFlg() {
		return this.cntrRfubFlg;
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
	 * @return obCntrFlg
	 */
	public String getObCntrFlg() {
		return this.obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return modiTp
	 */
	public String getModiTp() {
		return this.modiTp;
	}
	
	/**
	 * Column Info
	 * @return cnmvHisColNm
	 */
	public String getCnmvHisColNm() {
		return this.cnmvHisColNm;
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
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
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
	 * @return cnmvSplitNo
	 */
	public String getCnmvSplitNo() {
		return this.cnmvSplitNo;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
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
	 * @return vgm
	 */
	public String getVgm() {
		return this.vgm;
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
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return lstBkgNo
	 */
	public String getLstBkgNo() {
		return this.lstBkgNo;
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
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
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
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
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
	 * @return mvmtEdiMsgAreaCd
	 */
	public String getMvmtEdiMsgAreaCd() {
		return this.mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @return destYdNm
	 */
	public String getDestYdNm() {
		return this.destYdNm;
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
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
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
	 * @param lstFlg
	 */
	public void setLstFlg(String lstFlg) {
		this.lstFlg = lstFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param cnmvLvlNo
	 */
	public void setCnmvLvlNo(String cnmvLvlNo) {
		this.cnmvLvlNo = cnmvLvlNo;
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
	 * @param cntrId
	 */
	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param preStsFlg
	 */
	public void setPreStsFlg(String preStsFlg) {
		this.preStsFlg = preStsFlg;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
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
	 * @param ctrtSeq
	 */
	public void setCtrtSeq(String ctrtSeq) {
		this.ctrtSeq = ctrtSeq;
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
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
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
	 * @param bkgKnt
	 */
	public void setBkgKnt(String bkgKnt) {
		this.bkgKnt = bkgKnt;
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
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param orgYdNm
	 */
	public void setOrgYdNm(String orgYdNm) {
		this.orgYdNm = orgYdNm;
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
	 * @param ext
	 */
	public void setExt(String ext) {
		this.ext = ext;
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
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
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
	 * @param mvmtCreTpCd
	 */
	public void setMvmtCreTpCd(String mvmtCreTpCd) {
		this.mvmtCreTpCd = mvmtCreTpCd;
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
	 * @param spclCgoFlg
	 */
	public void setSpclCgoFlg(String spclCgoFlg) {
		this.spclCgoFlg = spclCgoFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
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
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
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
	 * @param cnmvCoCd
	 */
	public void setCnmvCoCd(String cnmvCoCd) {
		this.cnmvCoCd = cnmvCoCd;
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
	 * @param cntrRfubFlg
	 */
	public void setCntrRfubFlg(String cntrRfubFlg) {
		this.cntrRfubFlg = cntrRfubFlg;
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
	 * @param obCntrFlg
	 */
	public void setObCntrFlg(String obCntrFlg) {
		this.obCntrFlg = obCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param modiTp
	 */
	public void setModiTp(String modiTp) {
		this.modiTp = modiTp;
	}
	
	/**
	 * Column Info
	 * @param cnmvHisColNm
	 */
	public void setCnmvHisColNm(String cnmvHisColNm) {
		this.cnmvHisColNm = cnmvHisColNm;
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
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
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
	 * @param cnmvSplitNo
	 */
	public void setCnmvSplitNo(String cnmvSplitNo) {
		this.cnmvSplitNo = cnmvSplitNo;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
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
	 * @param vgm
	 */
	public void setVgm(String vgm) {
		this.vgm = vgm;
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
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param lstBkgNo
	 */
	public void setLstBkgNo(String lstBkgNo) {
		this.lstBkgNo = lstBkgNo;
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
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
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
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
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
	 * @param mvmtEdiMsgAreaCd
	 */
	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @param destYdNm
	 */
	public void setDestYdNm(String destYdNm) {
		this.destYdNm = destYdNm;
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
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setLstFlg(JSPUtil.getParameter(request, prefix + "lst_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, prefix + "cnmv_lvl_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrId(JSPUtil.getParameter(request, prefix + "cntr_id", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_tp_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setPreStsFlg(JSPUtil.getParameter(request, prefix + "pre_sts_flg", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setBlNoChk(JSPUtil.getParameter(request, prefix + "bl_no_chk", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setCtrtSeq(JSPUtil.getParameter(request, prefix + "ctrt_seq", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setCntrSvrId(JSPUtil.getParameter(request, prefix + "cntr_svr_id", ""));
		setBkgKnt(JSPUtil.getParameter(request, prefix + "bkg_knt", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setCnmvSeq(JSPUtil.getParameter(request, prefix + "cnmv_seq", ""));
		setOrgYdNm(JSPUtil.getParameter(request, prefix + "org_yd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExt(JSPUtil.getParameter(request, prefix + "ext", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, prefix + "cntr_hngr_bar_atch_knt", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_seq", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVrSeq(JSPUtil.getParameter(request, prefix + "vr_seq", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_yrmondy", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, prefix + "cntr_rfub_flg", ""));
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setModiTp(JSPUtil.getParameter(request, prefix + "modi_tp", ""));
		setCnmvHisColNm(JSPUtil.getParameter(request, prefix + "cnmv_his_col_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, prefix + "cnmv_split_no", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, prefix + "cntr_disp_flg", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setBlNoTp(JSPUtil.getParameter(request, prefix + "bl_no_tp", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setVgm(JSPUtil.getParameter(request, prefix + "vgm", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setLstBkgNo(JSPUtil.getParameter(request, prefix + "lst_bkg_no", ""));
		setNlsCnt(JSPUtil.getParameter(request, prefix + "nls_cnt", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setCntrXchCd(JSPUtil.getParameter(request, prefix + "cntr_xch_cd", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_cd", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_area_cd", ""));
		setDestYdNm(JSPUtil.getParameter(request, prefix + "dest_yd_nm", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
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
			String[] lstFlg = (JSPUtil.getParameter(request, prefix	+ "lst_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrId = (JSPUtil.getParameter(request, prefix	+ "cntr_id", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] preStsFlg = (JSPUtil.getParameter(request, prefix	+ "pre_sts_flg", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] ctrtSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_seq", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] cntrSvrId = (JSPUtil.getParameter(request, prefix	+ "cntr_svr_id", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] orgYdNm = (JSPUtil.getParameter(request, prefix	+ "org_yd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ext = (JSPUtil.getParameter(request, prefix	+ "ext", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vrSeq = (JSPUtil.getParameter(request, prefix	+ "vr_seq", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] modiTp = (JSPUtil.getParameter(request, prefix	+ "modi_tp", length));
			String[] cnmvHisColNm = (JSPUtil.getParameter(request, prefix	+ "cnmv_his_col_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] vgm = (JSPUtil.getParameter(request, prefix	+ "vgm", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] lstBkgNo = (JSPUtil.getParameter(request, prefix	+ "lst_bkg_no", length));
			String[] nlsCnt = (JSPUtil.getParameter(request, prefix	+ "nls_cnt", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] destYdNm = (JSPUtil.getParameter(request, prefix	+ "dest_yd_nm", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MVMTBookingInfoVO();
				if (lstFlg[i] != null)
					model.setLstFlg(lstFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrId[i] != null)
					model.setCntrId(cntrId[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (preStsFlg[i] != null)
					model.setPreStsFlg(preStsFlg[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (ctrtSeq[i] != null)
					model.setCtrtSeq(ctrtSeq[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (cntrSvrId[i] != null)
					model.setCntrSvrId(cntrSvrId[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (orgYdNm[i] != null)
					model.setOrgYdNm(orgYdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ext[i] != null)
					model.setExt(ext[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vrSeq[i] != null)
					model.setVrSeq(vrSeq[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (modiTp[i] != null)
					model.setModiTp(modiTp[i]);
				if (cnmvHisColNm[i] != null)
					model.setCnmvHisColNm(cnmvHisColNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (vgm[i] != null)
					model.setVgm(vgm[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (lstBkgNo[i] != null)
					model.setLstBkgNo(lstBkgNo[i]);
				if (nlsCnt[i] != null)
					model.setNlsCnt(nlsCnt[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (destYdNm[i] != null)
					model.setDestYdNm(destYdNm[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
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
		this.lstFlg = this.lstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId = this.cntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preStsFlg = this.preStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSeq = this.ctrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId = this.cntrSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdNm = this.orgYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ext = this.ext .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrSeq = this.vrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiTp = this.modiTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisColNm = this.cnmvHisColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgm = this.vgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstBkgNo = this.lstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nlsCnt = this.nlsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdNm = this.destYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
