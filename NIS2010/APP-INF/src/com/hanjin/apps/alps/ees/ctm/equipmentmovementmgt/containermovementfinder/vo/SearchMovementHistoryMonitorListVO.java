/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchMovementHistoryMonitorListVO.java
*@FileTitle : SearchMovementHistoryMonitorListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2016.04.25 홍성필 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 홍성필
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMovementHistoryMonitorListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMovementHistoryMonitorListVO> models = new ArrayList<SearchMovementHistoryMonitorListVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cnmvCorrRsnNm = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String atchFileSavId = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String destYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvEvntDtCnt = null;
	/* Column Info */
	private String eventToDt = null;
	/* Column Info */
	private String yardCd1 = null;
	/* Column Info */
	private String etcCnt = null;
	/* Column Info */
	private String yardCd2 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pkupNoCnt = null;
	/* Column Info */
	private String cntrRfubFlg = null;
	/* Column Info */
	private String serviceProvider = null;
	/* Column Info */
	private String divflag = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String cngYn = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String delCnt = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String uptFromDt = null;
	/* Column Info */
	private String vndrCnt = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String uptToDt = null;
	/* Column Info */
	private String mvmtStsCdCnt = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String cntrSealNoCnt = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String vndr = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcntrFlgCnt = null;
	/* Column Info */
	private String insCnt = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String orgYdCdCnt = null;
	/* Column Info */
	private String eventFromDt = null;
	/* Column Info */
	private String atchFileSavYn = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cnmvHisColNm = null;
	/* Column Info */
	private String inpDivFlg = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cnmvCorrRsn = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String obCntrFlgCnt = null;
	/* Column Info */
	private String correctionType = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String mvmtTrspModCdCnt = null;
	/* Column Info */
	private String cnmvCoCd = null;
	/* Column Info */
	private String cnmvCorrRsnCd = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String wblNoCnt = null;
	/* Column Info */
	private String lvl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMovementHistoryMonitorListVO() {}

	public SearchMovementHistoryMonitorListVO(String ibflag, String pagerows, String bkgCgoTpCd, String mvmtEdiMsgTpId, String vvd, String chssNo, String atchFileSavId, String mvmtTrspModCd, String destYdCd, String eventToDt, String cntrTpszCd, String cntrRfubFlg, String serviceProvider, String divflag, String cnmvEvntDt, String wblNo, String updLoclDt, String spclCgoFlg, String mvmtCreTpCd, String bkgNo, String creLoclDt, String cnmvRmk, String vndr, String uptFromDt, String cntrDispFlg, String vndrAbbrNm, String uptToDt, String pkupNo, String cnmvCycNo, String creDt, String fcntrFlg, String cntrDmgFlg, String usrNm, String eventFromDt, String atchFileSavYn, String updDt, String cnmvHisColNm, String inpDivFlg, String orgYdCd, String mgstNo, String cnmvCorrRsn, String obCntrFlg, String ofcCd, String mvmtStsCd, String cntrNo, String correctionType, String seq, String imdtExtFlg, String cntrSealNo, String cnmvCoCd, String cngYn, String rccCd, String lccCd, String yardCd1, String yardCd2, String cnmvCorrRsnCd, String cnmvCorrRsnNm, String delCnt, String insCnt, String mvmtStsCdCnt, String cnmvEvntDtCnt, String orgYdCdCnt, String vvdCnt, String fcntrFlgCnt, String obCntrFlgCnt, String vndrCnt, String mvmtTrspModCdCnt, String cntrSealNoCnt, String wblNoCnt, String pkupNoCnt, String etcCnt, String totCnt, String lvl) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cnmvCorrRsnNm = cnmvCorrRsnNm;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.chssNo = chssNo;
		this.atchFileSavId = atchFileSavId;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.destYdCd = destYdCd;
		this.pagerows = pagerows;
		this.cnmvEvntDtCnt = cnmvEvntDtCnt;
		this.eventToDt = eventToDt;
		this.yardCd1 = yardCd1;
		this.etcCnt = etcCnt;
		this.yardCd2 = yardCd2;
		this.cntrTpszCd = cntrTpszCd;
		this.pkupNoCnt = pkupNoCnt;
		this.cntrRfubFlg = cntrRfubFlg;
		this.serviceProvider = serviceProvider;
		this.divflag = divflag;
		this.totCnt = totCnt;
		this.cngYn = cngYn;
		this.updLoclDt = updLoclDt;
		this.wblNo = wblNo;
		this.cnmvEvntDt = cnmvEvntDt;
		this.spclCgoFlg = spclCgoFlg;
		this.delCnt = delCnt;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.cnmvRmk = cnmvRmk;
		this.creLoclDt = creLoclDt;
		this.uptFromDt = uptFromDt;
		this.vndrCnt = vndrCnt;
		this.cntrDispFlg = cntrDispFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.uptToDt = uptToDt;
		this.mvmtStsCdCnt = mvmtStsCdCnt;
		this.pkupNo = pkupNo;
		this.cntrSealNoCnt = cntrSealNoCnt;
		this.cnmvCycNo = cnmvCycNo;
		this.creDt = creDt;
		this.fcntrFlg = fcntrFlg;
		this.vndr = vndr;
		this.cntrDmgFlg = cntrDmgFlg;
		this.ibflag = ibflag;
		this.fcntrFlgCnt = fcntrFlgCnt;
		this.insCnt = insCnt;
		this.usrNm = usrNm;
		this.orgYdCdCnt = orgYdCdCnt;
		this.eventFromDt = eventFromDt;
		this.atchFileSavYn = atchFileSavYn;
		this.updDt = updDt;
		this.cnmvHisColNm = cnmvHisColNm;
		this.inpDivFlg = inpDivFlg;
		this.rccCd = rccCd;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.cnmvCorrRsn = cnmvCorrRsn;
		this.obCntrFlg = obCntrFlg;
		this.lccCd = lccCd;
		this.ofcCd = ofcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.cntrNo = cntrNo;
		this.obCntrFlgCnt = obCntrFlgCnt;
		this.correctionType = correctionType;
		this.seq = seq;
		this.imdtExtFlg = imdtExtFlg;
		this.cntrSealNo = cntrSealNo;
		this.mvmtTrspModCdCnt = mvmtTrspModCdCnt;
		this.cnmvCoCd = cnmvCoCd;
		this.cnmvCorrRsnCd = cnmvCorrRsnCd;
		this.vvdCnt = vvdCnt;
		this.wblNoCnt = wblNoCnt;
		this.lvl = lvl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cnmv_corr_rsn_nm", getCnmvCorrRsnNm());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("atch_file_sav_id", getAtchFileSavId());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_evnt_dt_cnt", getCnmvEvntDtCnt());
		this.hashColumns.put("event_to_dt", getEventToDt());
		this.hashColumns.put("yard_cd1", getYardCd1());
		this.hashColumns.put("etc_cnt", getEtcCnt());
		this.hashColumns.put("yard_cd2", getYardCd2());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pkup_no_cnt", getPkupNoCnt());
		this.hashColumns.put("cntr_rfub_flg", getCntrRfubFlg());
		this.hashColumns.put("service_provider", getServiceProvider());
		this.hashColumns.put("divflag", getDivflag());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("cng_yn", getCngYn());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("del_cnt", getDelCnt());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("upt_from_dt", getUptFromDt());
		this.hashColumns.put("vndr_cnt", getVndrCnt());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("upt_to_dt", getUptToDt());
		this.hashColumns.put("mvmt_sts_cd_cnt", getMvmtStsCdCnt());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("cntr_seal_no_cnt", getCntrSealNoCnt());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("vndr", getVndr());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fcntr_flg_cnt", getFcntrFlgCnt());
		this.hashColumns.put("ins_cnt", getInsCnt());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("org_yd_cd_cnt", getOrgYdCdCnt());
		this.hashColumns.put("event_from_dt", getEventFromDt());
		this.hashColumns.put("atch_file_sav_yn", getAtchFileSavYn());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cnmv_his_col_nm", getCnmvHisColNm());
		this.hashColumns.put("inp_div_flg", getInpDivFlg());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cnmv_corr_rsn", getCnmvCorrRsn());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ob_cntr_flg_cnt", getObCntrFlgCnt());
		this.hashColumns.put("correction_type", getCorrectionType());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("mvmt_trsp_mod_cd_cnt", getMvmtTrspModCdCnt());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		this.hashColumns.put("cnmv_corr_rsn_cd", getCnmvCorrRsnCd());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("wbl_no_cnt", getWblNoCnt());
		this.hashColumns.put("lvl",getLvl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cnmv_corr_rsn_nm", "cnmvCorrRsnNm");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("atch_file_sav_id", "atchFileSavId");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_evnt_dt_cnt", "cnmvEvntDtCnt");
		this.hashFields.put("event_to_dt", "eventToDt");
		this.hashFields.put("yard_cd1", "yardCd1");
		this.hashFields.put("etc_cnt", "etcCnt");
		this.hashFields.put("yard_cd2", "yardCd2");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pkup_no_cnt", "pkupNoCnt");
		this.hashFields.put("cntr_rfub_flg", "cntrRfubFlg");
		this.hashFields.put("service_provider", "serviceProvider");
		this.hashFields.put("divflag", "divflag");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("cng_yn", "cngYn");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("del_cnt", "delCnt");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("upt_from_dt", "uptFromDt");
		this.hashFields.put("vndr_cnt", "vndrCnt");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("upt_to_dt", "uptToDt");
		this.hashFields.put("mvmt_sts_cd_cnt", "mvmtStsCdCnt");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("cntr_seal_no_cnt", "cntrSealNoCnt");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("vndr", "vndr");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fcntr_flg_cnt", "fcntrFlgCnt");
		this.hashFields.put("ins_cnt", "insCnt");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("org_yd_cd_cnt", "orgYdCdCnt");
		this.hashFields.put("event_from_dt", "eventFromDt");
		this.hashFields.put("atch_file_sav_yn", "atchFileSavYn");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cnmv_his_col_nm", "cnmvHisColNm");
		this.hashFields.put("inp_div_flg", "inpDivFlg");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cnmv_corr_rsn", "cnmvCorrRsn");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ob_cntr_flg_cnt", "obCntrFlgCnt");
		this.hashFields.put("correction_type", "correctionType");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("mvmt_trsp_mod_cd_cnt", "mvmtTrspModCdCnt");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
		this.hashFields.put("cnmv_corr_rsn_cd", "cnmvCorrRsnCd");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("wbl_no_cnt", "wblNoCnt");
		this.hashFields.put("lvl", "lvl");
		return this.hashFields;
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
	 * @return cnmvCorrRsnNm
	 */
	public String getCnmvCorrRsnNm() {
		return this.cnmvCorrRsnNm;
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
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return atchFileSavId
	 */
	public String getAtchFileSavId() {
		return this.atchFileSavId;
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
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
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
	 * @return cnmvEvntDtCnt
	 */
	public String getCnmvEvntDtCnt() {
		return this.cnmvEvntDtCnt;
	}
	
	/**
	 * Column Info
	 * @return eventToDt
	 */
	public String getEventToDt() {
		return this.eventToDt;
	}
	
	/**
	 * Column Info
	 * @return yardCd1
	 */
	public String getYardCd1() {
		return this.yardCd1;
	}
	
	/**
	 * Column Info
	 * @return etcCnt
	 */
	public String getEtcCnt() {
		return this.etcCnt;
	}
	
	/**
	 * Column Info
	 * @return yardCd2
	 */
	public String getYardCd2() {
		return this.yardCd2;
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
	 * @return pkupNoCnt
	 */
	public String getPkupNoCnt() {
		return this.pkupNoCnt;
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
	 * @return serviceProvider
	 */
	public String getServiceProvider() {
		return this.serviceProvider;
	}
	
	/**
	 * Column Info
	 * @return divflag
	 */
	public String getDivflag() {
		return this.divflag;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return cngYn
	 */
	public String getCngYn() {
		return this.cngYn;
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
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
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
	 * @return delCnt
	 */
	public String getDelCnt() {
		return this.delCnt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return uptFromDt
	 */
	public String getUptFromDt() {
		return this.uptFromDt;
	}
	
	/**
	 * Column Info
	 * @return vndrCnt
	 */
	public String getVndrCnt() {
		return this.vndrCnt;
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
	 * @return uptToDt
	 */
	public String getUptToDt() {
		return this.uptToDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCdCnt
	 */
	public String getMvmtStsCdCnt() {
		return this.mvmtStsCdCnt;
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
	 * @return cntrSealNoCnt
	 */
	public String getCntrSealNoCnt() {
		return this.cntrSealNoCnt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return vndr
	 */
	public String getVndr() {
		return this.vndr;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
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
	 * @return fcntrFlgCnt
	 */
	public String getFcntrFlgCnt() {
		return this.fcntrFlgCnt;
	}
	
	/**
	 * Column Info
	 * @return insCnt
	 */
	public String getInsCnt() {
		return this.insCnt;
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
	 * @return orgYdCdCnt
	 */
	public String getOrgYdCdCnt() {
		return this.orgYdCdCnt;
	}
	
	/**
	 * Column Info
	 * @return eventFromDt
	 */
	public String getEventFromDt() {
		return this.eventFromDt;
	}
	
	/**
	 * Column Info
	 * @return atchFileSavYn
	 */
	public String getAtchFileSavYn() {
		return this.atchFileSavYn;
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
	 * @return cnmvHisColNm
	 */
	public String getCnmvHisColNm() {
		return this.cnmvHisColNm;
	}
	
	/**
	 * Column Info
	 * @return inpDivFlg
	 */
	public String getInpDivFlg() {
		return this.inpDivFlg;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @return cnmvCorrRsn
	 */
	public String getCnmvCorrRsn() {
		return this.cnmvCorrRsn;
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
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return obCntrFlgCnt
	 */
	public String getObCntrFlgCnt() {
		return this.obCntrFlgCnt;
	}
	
	/**
	 * Column Info
	 * @return correctionType
	 */
	public String getCorrectionType() {
		return this.correctionType;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCdCnt
	 */
	public String getMvmtTrspModCdCnt() {
		return this.mvmtTrspModCdCnt;
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
	 * @return cnmvCorrRsnCd
	 */
	public String getCnmvCorrRsnCd() {
		return this.cnmvCorrRsnCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	
	/**
	 * Column Info
	 * @return wblNoCnt
	 */
	public String getWblNoCnt() {
		return this.wblNoCnt;
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
	 * @param cnmvCorrRsnNm
	 */
	public void setCnmvCorrRsnNm(String cnmvCorrRsnNm) {
		this.cnmvCorrRsnNm = cnmvCorrRsnNm;
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
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param atchFileSavId
	 */
	public void setAtchFileSavId(String atchFileSavId) {
		this.atchFileSavId = atchFileSavId;
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
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
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
	 * @param cnmvEvntDtCnt
	 */
	public void setCnmvEvntDtCnt(String cnmvEvntDtCnt) {
		this.cnmvEvntDtCnt = cnmvEvntDtCnt;
	}
	
	/**
	 * Column Info
	 * @param eventToDt
	 */
	public void setEventToDt(String eventToDt) {
		this.eventToDt = eventToDt;
	}
	
	/**
	 * Column Info
	 * @param yardCd1
	 */
	public void setYardCd1(String yardCd1) {
		this.yardCd1 = yardCd1;
	}
	
	/**
	 * Column Info
	 * @param etcCnt
	 */
	public void setEtcCnt(String etcCnt) {
		this.etcCnt = etcCnt;
	}
	
	/**
	 * Column Info
	 * @param yardCd2
	 */
	public void setYardCd2(String yardCd2) {
		this.yardCd2 = yardCd2;
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
	 * @param pkupNoCnt
	 */
	public void setPkupNoCnt(String pkupNoCnt) {
		this.pkupNoCnt = pkupNoCnt;
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
	 * @param serviceProvider
	 */
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
	/**
	 * Column Info
	 * @param divflag
	 */
	public void setDivflag(String divflag) {
		this.divflag = divflag;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param cngYn
	 */
	public void setCngYn(String cngYn) {
		this.cngYn = cngYn;
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
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
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
	 * @param delCnt
	 */
	public void setDelCnt(String delCnt) {
		this.delCnt = delCnt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param uptFromDt
	 */
	public void setUptFromDt(String uptFromDt) {
		this.uptFromDt = uptFromDt;
	}
	
	/**
	 * Column Info
	 * @param vndrCnt
	 */
	public void setVndrCnt(String vndrCnt) {
		this.vndrCnt = vndrCnt;
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
	 * @param uptToDt
	 */
	public void setUptToDt(String uptToDt) {
		this.uptToDt = uptToDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCdCnt
	 */
	public void setMvmtStsCdCnt(String mvmtStsCdCnt) {
		this.mvmtStsCdCnt = mvmtStsCdCnt;
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
	 * @param cntrSealNoCnt
	 */
	public void setCntrSealNoCnt(String cntrSealNoCnt) {
		this.cntrSealNoCnt = cntrSealNoCnt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param vndr
	 */
	public void setVndr(String vndr) {
		this.vndr = vndr;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
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
	 * @param fcntrFlgCnt
	 */
	public void setFcntrFlgCnt(String fcntrFlgCnt) {
		this.fcntrFlgCnt = fcntrFlgCnt;
	}
	
	/**
	 * Column Info
	 * @param insCnt
	 */
	public void setInsCnt(String insCnt) {
		this.insCnt = insCnt;
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
	 * @param orgYdCdCnt
	 */
	public void setOrgYdCdCnt(String orgYdCdCnt) {
		this.orgYdCdCnt = orgYdCdCnt;
	}
	
	/**
	 * Column Info
	 * @param eventFromDt
	 */
	public void setEventFromDt(String eventFromDt) {
		this.eventFromDt = eventFromDt;
	}
	
	/**
	 * Column Info
	 * @param atchFileSavYn
	 */
	public void setAtchFileSavYn(String atchFileSavYn) {
		this.atchFileSavYn = atchFileSavYn;
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
	 * @param cnmvHisColNm
	 */
	public void setCnmvHisColNm(String cnmvHisColNm) {
		this.cnmvHisColNm = cnmvHisColNm;
	}
	
	/**
	 * Column Info
	 * @param inpDivFlg
	 */
	public void setInpDivFlg(String inpDivFlg) {
		this.inpDivFlg = inpDivFlg;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * @param cnmvCorrRsn
	 */
	public void setCnmvCorrRsn(String cnmvCorrRsn) {
		this.cnmvCorrRsn = cnmvCorrRsn;
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
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param obCntrFlgCnt
	 */
	public void setObCntrFlgCnt(String obCntrFlgCnt) {
		this.obCntrFlgCnt = obCntrFlgCnt;
	}
	
	/**
	 * Column Info
	 * @param correctionType
	 */
	public void setCorrectionType(String correctionType) {
		this.correctionType = correctionType;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCdCnt
	 */
	public void setMvmtTrspModCdCnt(String mvmtTrspModCdCnt) {
		this.mvmtTrspModCdCnt = mvmtTrspModCdCnt;
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
	 * @param cnmvCorrRsnCd
	 */
	public void setCnmvCorrRsnCd(String cnmvCorrRsnCd) {
		this.cnmvCorrRsnCd = cnmvCorrRsnCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}
	
	/**
	 * Column Info
	 * @param wblNoCnt
	 */
	public void setWblNoCnt(String wblNoCnt) {
		this.wblNoCnt = wblNoCnt;
	}
	
	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCnmvCorrRsnNm(JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn_nm", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setAtchFileSavId(JSPUtil.getParameter(request, prefix + "atch_file_sav_id", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnmvEvntDtCnt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt_cnt", ""));
		setEventToDt(JSPUtil.getParameter(request, prefix + "event_to_dt", ""));
		setYardCd1(JSPUtil.getParameter(request, prefix + "yard_cd1", ""));
		setEtcCnt(JSPUtil.getParameter(request, prefix + "etc_cnt", ""));
		setYardCd2(JSPUtil.getParameter(request, prefix + "yard_cd2", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPkupNoCnt(JSPUtil.getParameter(request, prefix + "pkup_no_cnt", ""));
		setCntrRfubFlg(JSPUtil.getParameter(request, prefix + "cntr_rfub_flg", ""));
		setServiceProvider(JSPUtil.getParameter(request, prefix + "service_provider", ""));
		setDivflag(JSPUtil.getParameter(request, prefix + "divflag", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setCngYn(JSPUtil.getParameter(request, prefix + "cng_yn", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, prefix + "upd_locl_dt", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_flg", ""));
		setDelCnt(JSPUtil.getParameter(request, prefix + "del_cnt", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, prefix + "mvmt_cre_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setUptFromDt(JSPUtil.getParameter(request, prefix + "upt_from_dt", ""));
		setVndrCnt(JSPUtil.getParameter(request, prefix + "vndr_cnt", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, prefix + "cntr_disp_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setUptToDt(JSPUtil.getParameter(request, prefix + "upt_to_dt", ""));
		setMvmtStsCdCnt(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd_cnt", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setCntrSealNoCnt(JSPUtil.getParameter(request, prefix + "cntr_seal_no_cnt", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setVndr(JSPUtil.getParameter(request, prefix + "vndr", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcntrFlgCnt(JSPUtil.getParameter(request, prefix + "fcntr_flg_cnt", ""));
		setInsCnt(JSPUtil.getParameter(request, prefix + "ins_cnt", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setOrgYdCdCnt(JSPUtil.getParameter(request, prefix + "org_yd_cd_cnt", ""));
		setEventFromDt(JSPUtil.getParameter(request, prefix + "event_from_dt", ""));
		setAtchFileSavYn(JSPUtil.getParameter(request, prefix + "atch_file_sav_yn", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCnmvHisColNm(JSPUtil.getParameter(request, prefix + "cnmv_his_col_nm", ""));
		setInpDivFlg(JSPUtil.getParameter(request, prefix + "inp_div_flg", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCnmvCorrRsn(JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn", ""));
		setObCntrFlg(JSPUtil.getParameter(request, prefix + "ob_cntr_flg", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setObCntrFlgCnt(JSPUtil.getParameter(request, prefix + "ob_cntr_flg_cnt", ""));
		setCorrectionType(JSPUtil.getParameter(request, prefix + "correction_type", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, prefix + "imdt_ext_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setMvmtTrspModCdCnt(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd_cnt", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, prefix + "cnmv_co_cd", ""));
		setCnmvCorrRsnCd(JSPUtil.getParameter(request, prefix + "cnmv_corr_rsn_cd", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setWblNoCnt(JSPUtil.getParameter(request, prefix + "wbl_no_cnt", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMovementHistoryMonitorListVO[]
	 */
	public SearchMovementHistoryMonitorListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMovementHistoryMonitorListVO[]
	 */
	public SearchMovementHistoryMonitorListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMovementHistoryMonitorListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cnmvCorrRsnNm = (JSPUtil.getParameter(request, prefix	+ "cnmv_corr_rsn_nm", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] atchFileSavId = (JSPUtil.getParameter(request, prefix	+ "atch_file_sav_id", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvEvntDtCnt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt_cnt", length));
			String[] eventToDt = (JSPUtil.getParameter(request, prefix	+ "event_to_dt", length));
			String[] yardCd1 = (JSPUtil.getParameter(request, prefix	+ "yard_cd1", length));
			String[] etcCnt = (JSPUtil.getParameter(request, prefix	+ "etc_cnt", length));
			String[] yardCd2 = (JSPUtil.getParameter(request, prefix	+ "yard_cd2", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pkupNoCnt = (JSPUtil.getParameter(request, prefix	+ "pkup_no_cnt", length));
			String[] cntrRfubFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_rfub_flg", length));
			String[] serviceProvider = (JSPUtil.getParameter(request, prefix	+ "service_provider", length));
			String[] divflag = (JSPUtil.getParameter(request, prefix	+ "divflag", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] cngYn = (JSPUtil.getParameter(request, prefix	+ "cng_yn", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] delCnt = (JSPUtil.getParameter(request, prefix	+ "del_cnt", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] uptFromDt = (JSPUtil.getParameter(request, prefix	+ "upt_from_dt", length));
			String[] vndrCnt = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] uptToDt = (JSPUtil.getParameter(request, prefix	+ "upt_to_dt", length));
			String[] mvmtStsCdCnt = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd_cnt", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] cntrSealNoCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no_cnt", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] vndr = (JSPUtil.getParameter(request, prefix	+ "vndr", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcntrFlgCnt = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg_cnt", length));
			String[] insCnt = (JSPUtil.getParameter(request, prefix	+ "ins_cnt", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] orgYdCdCnt = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd_cnt", length));
			String[] eventFromDt = (JSPUtil.getParameter(request, prefix	+ "event_from_dt", length));
			String[] atchFileSavYn = (JSPUtil.getParameter(request, prefix	+ "atch_file_sav_yn", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cnmvHisColNm = (JSPUtil.getParameter(request, prefix	+ "cnmv_his_col_nm", length));
			String[] inpDivFlg = (JSPUtil.getParameter(request, prefix	+ "inp_div_flg", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cnmvCorrRsn = (JSPUtil.getParameter(request, prefix	+ "cnmv_corr_rsn", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] obCntrFlgCnt = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg_cnt", length));
			String[] correctionType = (JSPUtil.getParameter(request, prefix	+ "correction_type", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] mvmtTrspModCdCnt = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd_cnt", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			String[] cnmvCorrRsnCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_corr_rsn_cd", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] wblNoCnt = (JSPUtil.getParameter(request, prefix	+ "wbl_no_cnt", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMovementHistoryMonitorListVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cnmvCorrRsnNm[i] != null)
					model.setCnmvCorrRsnNm(cnmvCorrRsnNm[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (atchFileSavId[i] != null)
					model.setAtchFileSavId(atchFileSavId[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvEvntDtCnt[i] != null)
					model.setCnmvEvntDtCnt(cnmvEvntDtCnt[i]);
				if (eventToDt[i] != null)
					model.setEventToDt(eventToDt[i]);
				if (yardCd1[i] != null)
					model.setYardCd1(yardCd1[i]);
				if (etcCnt[i] != null)
					model.setEtcCnt(etcCnt[i]);
				if (yardCd2[i] != null)
					model.setYardCd2(yardCd2[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pkupNoCnt[i] != null)
					model.setPkupNoCnt(pkupNoCnt[i]);
				if (cntrRfubFlg[i] != null)
					model.setCntrRfubFlg(cntrRfubFlg[i]);
				if (serviceProvider[i] != null)
					model.setServiceProvider(serviceProvider[i]);
				if (divflag[i] != null)
					model.setDivflag(divflag[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (cngYn[i] != null)
					model.setCngYn(cngYn[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (delCnt[i] != null)
					model.setDelCnt(delCnt[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (uptFromDt[i] != null)
					model.setUptFromDt(uptFromDt[i]);
				if (vndrCnt[i] != null)
					model.setVndrCnt(vndrCnt[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (uptToDt[i] != null)
					model.setUptToDt(uptToDt[i]);
				if (mvmtStsCdCnt[i] != null)
					model.setMvmtStsCdCnt(mvmtStsCdCnt[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (cntrSealNoCnt[i] != null)
					model.setCntrSealNoCnt(cntrSealNoCnt[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (vndr[i] != null)
					model.setVndr(vndr[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcntrFlgCnt[i] != null)
					model.setFcntrFlgCnt(fcntrFlgCnt[i]);
				if (insCnt[i] != null)
					model.setInsCnt(insCnt[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (orgYdCdCnt[i] != null)
					model.setOrgYdCdCnt(orgYdCdCnt[i]);
				if (eventFromDt[i] != null)
					model.setEventFromDt(eventFromDt[i]);
				if (atchFileSavYn[i] != null)
					model.setAtchFileSavYn(atchFileSavYn[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cnmvHisColNm[i] != null)
					model.setCnmvHisColNm(cnmvHisColNm[i]);
				if (inpDivFlg[i] != null)
					model.setInpDivFlg(inpDivFlg[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cnmvCorrRsn[i] != null)
					model.setCnmvCorrRsn(cnmvCorrRsn[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (obCntrFlgCnt[i] != null)
					model.setObCntrFlgCnt(obCntrFlgCnt[i]);
				if (correctionType[i] != null)
					model.setCorrectionType(correctionType[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (mvmtTrspModCdCnt[i] != null)
					model.setMvmtTrspModCdCnt(mvmtTrspModCdCnt[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				if (cnmvCorrRsnCd[i] != null)
					model.setCnmvCorrRsnCd(cnmvCorrRsnCd[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (wblNoCnt[i] != null)
					model.setWblNoCnt(wblNoCnt[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMovementHistoryMonitorListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMovementHistoryMonitorListVO[]
	 */
	public SearchMovementHistoryMonitorListVO[] getSearchMovementHistoryMonitorListVOs(){
		SearchMovementHistoryMonitorListVO[] vos = (SearchMovementHistoryMonitorListVO[])models.toArray(new SearchMovementHistoryMonitorListVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCorrRsnNm = this.cnmvCorrRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileSavId = this.atchFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDtCnt = this.cnmvEvntDtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventToDt = this.eventToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd1 = this.yardCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcCnt = this.etcCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd2 = this.yardCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNoCnt = this.pkupNoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRfubFlg = this.cntrRfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceProvider = this.serviceProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divflag = this.divflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngYn = this.cngYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCnt = this.delCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uptFromDt = this.uptFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCnt = this.vndrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uptToDt = this.uptToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCdCnt = this.mvmtStsCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNoCnt = this.cntrSealNoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr = this.vndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlgCnt = this.fcntrFlgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insCnt = this.insCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCdCnt = this.orgYdCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventFromDt = this.eventFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileSavYn = this.atchFileSavYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvHisColNm = this.cnmvHisColNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDivFlg = this.inpDivFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCorrRsn = this.cnmvCorrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlgCnt = this.obCntrFlgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.correctionType = this.correctionType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCdCnt = this.mvmtTrspModCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCorrRsnCd = this.cnmvCorrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNoCnt = this.wblNoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
