/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRMvmtMGTVO.java
*@FileTitle : CNTRMvmtMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.09.08 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CNTRMvmtMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CNTRMvmtMGTVO> models = new ArrayList<CNTRMvmtMGTVO>();
	
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
	private String mvmtDt2 = null;
	/* Column Info */
	private String mvmtDt1 = null;
	/* Column Info */
	private String chssState = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrXchCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrId = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String updLoclDt = null;
	/* Column Info */
	private String spclCgoFlg = null;
	/* Column Info */
	private String mvmtCreTpCd = null;
	/* Column Info */
	private String vrSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mgstNo2 = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrDispFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String vl = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String cnmvLvlNo = null;
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
	private String cnmvSplitNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgKnt = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String gateIoCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String obCntrFlg = null;
	/* Column Info */
	private String mvmtRsnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mgstState = null;
	/* Column Info */
	private String chssNo2 = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cnmvCoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CNTRMvmtMGTVO() {}

	public CNTRMvmtMGTVO(String ibflag, String pagerows, String vl, String porCd, String polCd, String podCd, String delCd, String bkgNo, String blNo, String cntrNo, String cnmvCycNo, String cnmvLvlNo, String cnmvCoCd, String mvmtStsCd, String mvmtCreTpCd, String orgYdCd, String destYdCd, String cnmvEvntDt, String cntrId, String fcntrFlg, String obCntrFlg, String mvmtEdiMsgTpId, String bkgCgoTpCd, String cntrDmgFlg, String cntrDispFlg, String imdtExtFlg, String cntrXchCd, String spclCgoFlg, String vndrSeq, String vndrAbbrNm, String mvmtTrspModCd, String chssNo, String mgstNo, String chssNo2, String mgstNo2, String cntrSealNo, String wblNo, String pkupNo, String updLoclDt, String creLoclDt, String ofcCd, String usrNm, String cnmvRmk, String cnmvIdNo, String cnmvSeq, String cnmvSplitNo, String creDt, String creUsrId, String updDt, String updUsrId, String bkgNoSplit, String bkgKnt, String blNoTp, String blNoChk, String cnmvYr, String cntrTpszCd, String vrSeq, String svrId, String cntrSvrId, String ioBndCd, String eqTpszCd, String chssState, String mgstState, String mvmtRsnCd, String mvmtDt1, String mvmtDt2, String gateIoCd, String mvmtDt) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.cnmvSeq = cnmvSeq;
		this.chssNo = chssNo;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtDt2 = mvmtDt2;
		this.mvmtDt1 = mvmtDt1;
		this.chssState = chssState;
		this.destYdCd = destYdCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blNoChk = blNoChk;
		this.polCd = polCd;
		this.cntrXchCd = cntrXchCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrId = cntrId;
		this.blNoTp = blNoTp;
		this.updUsrId = updUsrId;
		this.delCd = delCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.wblNo = wblNo;
		this.updLoclDt = updLoclDt;
		this.spclCgoFlg = spclCgoFlg;
		this.mvmtCreTpCd = mvmtCreTpCd;
		this.vrSeq = vrSeq;
		this.eqTpszCd = eqTpszCd;
		this.cnmvIdNo = cnmvIdNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.mgstNo2 = mgstNo2;
		this.creLoclDt = creLoclDt;
		this.cnmvRmk = cnmvRmk;
		this.vndrSeq = vndrSeq;
		this.cntrDispFlg = cntrDispFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.mvmtDt = mvmtDt;
		this.pkupNo = pkupNo;
		this.vl = vl;
		this.porCd = porCd;
		this.cnmvCycNo = cnmvCycNo;
		this.cnmvLvlNo = cnmvLvlNo;
		this.creDt = creDt;
		this.cntrSvrId = cntrSvrId;
		this.fcntrFlg = fcntrFlg;
		this.svrId = svrId;
		this.cntrDmgFlg = cntrDmgFlg;
		this.cnmvSplitNo = cnmvSplitNo;
		this.ibflag = ibflag;
		this.bkgKnt = bkgKnt;
		this.usrNm = usrNm;
		this.gateIoCd = gateIoCd;
		this.updDt = updDt;
		this.bkgNoSplit = bkgNoSplit;
		this.ioBndCd = ioBndCd;
		this.orgYdCd = orgYdCd;
		this.mgstNo = mgstNo;
		this.obCntrFlg = obCntrFlg;
		this.mvmtRsnCd = mvmtRsnCd;
		this.ofcCd = ofcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.cntrNo = cntrNo;
		this.mgstState = mgstState;
		this.chssNo2 = chssNo2;
		this.imdtExtFlg = imdtExtFlg;
		this.cntrSealNo = cntrSealNo;
		this.cnmvYr = cnmvYr;
		this.cnmvCoCd = cnmvCoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_dt_2", getMvmtDt2());
		this.hashColumns.put("mvmt_dt_1", getMvmtDt1());
		this.hashColumns.put("chss_state", getChssState());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_xch_cd", getCntrXchCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_id", getCntrId());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("upd_locl_dt", getUpdLoclDt());
		this.hashColumns.put("spcl_cgo_flg", getSpclCgoFlg());
		this.hashColumns.put("mvmt_cre_tp_cd", getMvmtCreTpCd());
		this.hashColumns.put("vr_seq", getVrSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mgst_no_2", getMgstNo2());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_disp_flg", getCntrDispFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("vl", getVl());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cnmv_lvl_no", getCnmvLvlNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_svr_id", getCntrSvrId());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("cnmv_split_no", getCnmvSplitNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_knt", getBkgKnt());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("gate_io_cd", getGateIoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("ob_cntr_flg", getObCntrFlg());
		this.hashColumns.put("mvmt_rsn_cd", getMvmtRsnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mgst_state", getMgstState());
		this.hashColumns.put("chss_no_2", getChssNo2());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cnmv_co_cd", getCnmvCoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_dt_2", "mvmtDt2");
		this.hashFields.put("mvmt_dt_1", "mvmtDt1");
		this.hashFields.put("chss_state", "chssState");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_xch_cd", "cntrXchCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_id", "cntrId");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("upd_locl_dt", "updLoclDt");
		this.hashFields.put("spcl_cgo_flg", "spclCgoFlg");
		this.hashFields.put("mvmt_cre_tp_cd", "mvmtCreTpCd");
		this.hashFields.put("vr_seq", "vrSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mgst_no_2", "mgstNo2");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_disp_flg", "cntrDispFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("vl", "vl");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cnmv_lvl_no", "cnmvLvlNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_svr_id", "cntrSvrId");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("cnmv_split_no", "cnmvSplitNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_knt", "bkgKnt");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("gate_io_cd", "gateIoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("ob_cntr_flg", "obCntrFlg");
		this.hashFields.put("mvmt_rsn_cd", "mvmtRsnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mgst_state", "mgstState");
		this.hashFields.put("chss_no_2", "chssNo2");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cnmv_co_cd", "cnmvCoCd");
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
	 * @return mvmtDt2
	 */
	public String getMvmtDt2() {
		return this.mvmtDt2;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt1
	 */
	public String getMvmtDt1() {
		return this.mvmtDt1;
	}
	
	/**
	 * Column Info
	 * @return chssState
	 */
	public String getChssState() {
		return this.chssState;
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
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return cntrXchCd
	 */
	public String getCntrXchCd() {
		return this.cntrXchCd;
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
	 * @return cntrId
	 */
	public String getCntrId() {
		return this.cntrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return mgstNo2
	 */
	public String getMgstNo2() {
		return this.mgstNo2;
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
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
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
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
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
	 * @return vl
	 */
	public String getVl() {
		return this.vl;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return gateIoCd
	 */
	public String getGateIoCd() {
		return this.gateIoCd;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return mvmtRsnCd
	 */
	public String getMvmtRsnCd() {
		return this.mvmtRsnCd;
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
	 * @return mgstState
	 */
	public String getMgstState() {
		return this.mgstState;
	}
	
	/**
	 * Column Info
	 * @return chssNo2
	 */
	public String getChssNo2() {
		return this.chssNo2;
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
	 * @param mvmtDt2
	 */
	public void setMvmtDt2(String mvmtDt2) {
		this.mvmtDt2 = mvmtDt2;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt1
	 */
	public void setMvmtDt1(String mvmtDt1) {
		this.mvmtDt1 = mvmtDt1;
	}
	
	/**
	 * Column Info
	 * @param chssState
	 */
	public void setChssState(String chssState) {
		this.chssState = chssState;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param cntrXchCd
	 */
	public void setCntrXchCd(String cntrXchCd) {
		this.cntrXchCd = cntrXchCd;
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
	 * @param cntrId
	 */
	public void setCntrId(String cntrId) {
		this.cntrId = cntrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param mgstNo2
	 */
	public void setMgstNo2(String mgstNo2) {
		this.mgstNo2 = mgstNo2;
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
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
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
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
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
	 * @param vl
	 */
	public void setVl(String vl) {
		this.vl = vl;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param gateIoCd
	 */
	public void setGateIoCd(String gateIoCd) {
		this.gateIoCd = gateIoCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param mvmtRsnCd
	 */
	public void setMvmtRsnCd(String mvmtRsnCd) {
		this.mvmtRsnCd = mvmtRsnCd;
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
	 * @param mgstState
	 */
	public void setMgstState(String mgstState) {
		this.mgstState = mgstState;
	}
	
	/**
	 * Column Info
	 * @param chssNo2
	 */
	public void setChssNo2(String chssNo2) {
		this.chssNo2 = chssNo2;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, "mvmt_edi_msg_tp_id", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, "mvmt_trsp_mod_cd", ""));
		setMvmtDt2(JSPUtil.getParameter(request, "mvmt_dt_2", ""));
		setMvmtDt1(JSPUtil.getParameter(request, "mvmt_dt_1", ""));
		setChssState(JSPUtil.getParameter(request, "chss_state", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrXchCd(JSPUtil.getParameter(request, "cntr_xch_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrId(JSPUtil.getParameter(request, "cntr_id", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setWblNo(JSPUtil.getParameter(request, "wbl_no", ""));
		setUpdLoclDt(JSPUtil.getParameter(request, "upd_locl_dt", ""));
		setSpclCgoFlg(JSPUtil.getParameter(request, "spcl_cgo_flg", ""));
		setMvmtCreTpCd(JSPUtil.getParameter(request, "mvmt_cre_tp_cd", ""));
		setVrSeq(JSPUtil.getParameter(request, "vr_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMgstNo2(JSPUtil.getParameter(request, "mgst_no_2", ""));
		setCreLoclDt(JSPUtil.getParameter(request, "cre_locl_dt", ""));
		setCnmvRmk(JSPUtil.getParameter(request, "cnmv_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCntrDispFlg(JSPUtil.getParameter(request, "cntr_disp_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
		setVl(JSPUtil.getParameter(request, "vl", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setCnmvLvlNo(JSPUtil.getParameter(request, "cnmv_lvl_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrSvrId(JSPUtil.getParameter(request, "cntr_svr_id", ""));
		setFcntrFlg(JSPUtil.getParameter(request, "fcntr_flg", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, "cntr_dmg_flg", ""));
		setCnmvSplitNo(JSPUtil.getParameter(request, "cnmv_split_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgKnt(JSPUtil.getParameter(request, "bkg_knt", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setGateIoCd(JSPUtil.getParameter(request, "gate_io_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setObCntrFlg(JSPUtil.getParameter(request, "ob_cntr_flg", ""));
		setMvmtRsnCd(JSPUtil.getParameter(request, "mvmt_rsn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMgstState(JSPUtil.getParameter(request, "mgst_state", ""));
		setChssNo2(JSPUtil.getParameter(request, "chss_no_2", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setCnmvCoCd(JSPUtil.getParameter(request, "cnmv_co_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CNTRMvmtMGTVO[]
	 */
	public CNTRMvmtMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CNTRMvmtMGTVO[]
	 */
	public CNTRMvmtMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CNTRMvmtMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtDt2 = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt_2", length));
			String[] mvmtDt1 = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt_1", length));
			String[] chssState = (JSPUtil.getParameter(request, prefix	+ "chss_state", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrXchCd = (JSPUtil.getParameter(request, prefix	+ "cntr_xch_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrId = (JSPUtil.getParameter(request, prefix	+ "cntr_id", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] updLoclDt = (JSPUtil.getParameter(request, prefix	+ "upd_locl_dt", length));
			String[] spclCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_flg", length));
			String[] mvmtCreTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_cre_tp_cd", length));
			String[] vrSeq = (JSPUtil.getParameter(request, prefix	+ "vr_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mgstNo2 = (JSPUtil.getParameter(request, prefix	+ "mgst_no_2", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrDispFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_disp_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] vl = (JSPUtil.getParameter(request, prefix	+ "vl", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] cnmvLvlNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_lvl_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrSvrId = (JSPUtil.getParameter(request, prefix	+ "cntr_svr_id", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] cnmvSplitNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_split_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgKnt = (JSPUtil.getParameter(request, prefix	+ "bkg_knt", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] gateIoCd = (JSPUtil.getParameter(request, prefix	+ "gate_io_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] obCntrFlg = (JSPUtil.getParameter(request, prefix	+ "ob_cntr_flg", length));
			String[] mvmtRsnCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_rsn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mgstState = (JSPUtil.getParameter(request, prefix	+ "mgst_state", length));
			String[] chssNo2 = (JSPUtil.getParameter(request, prefix	+ "chss_no_2", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cnmvCoCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_co_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CNTRMvmtMGTVO();
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
				if (mvmtDt2[i] != null)
					model.setMvmtDt2(mvmtDt2[i]);
				if (mvmtDt1[i] != null)
					model.setMvmtDt1(mvmtDt1[i]);
				if (chssState[i] != null)
					model.setChssState(chssState[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrXchCd[i] != null)
					model.setCntrXchCd(cntrXchCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrId[i] != null)
					model.setCntrId(cntrId[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (updLoclDt[i] != null)
					model.setUpdLoclDt(updLoclDt[i]);
				if (spclCgoFlg[i] != null)
					model.setSpclCgoFlg(spclCgoFlg[i]);
				if (mvmtCreTpCd[i] != null)
					model.setMvmtCreTpCd(mvmtCreTpCd[i]);
				if (vrSeq[i] != null)
					model.setVrSeq(vrSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mgstNo2[i] != null)
					model.setMgstNo2(mgstNo2[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrDispFlg[i] != null)
					model.setCntrDispFlg(cntrDispFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (vl[i] != null)
					model.setVl(vl[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (cnmvLvlNo[i] != null)
					model.setCnmvLvlNo(cnmvLvlNo[i]);
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
				if (cnmvSplitNo[i] != null)
					model.setCnmvSplitNo(cnmvSplitNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgKnt[i] != null)
					model.setBkgKnt(bkgKnt[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (gateIoCd[i] != null)
					model.setGateIoCd(gateIoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (obCntrFlg[i] != null)
					model.setObCntrFlg(obCntrFlg[i]);
				if (mvmtRsnCd[i] != null)
					model.setMvmtRsnCd(mvmtRsnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mgstState[i] != null)
					model.setMgstState(mgstState[i]);
				if (chssNo2[i] != null)
					model.setChssNo2(chssNo2[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cnmvCoCd[i] != null)
					model.setCnmvCoCd(cnmvCoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCNTRMvmtMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CNTRMvmtMGTVO[]
	 */
	public CNTRMvmtMGTVO[] getCNTRMvmtMGTVOs(){
		CNTRMvmtMGTVO[] vos = (CNTRMvmtMGTVO[])models.toArray(new CNTRMvmtMGTVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt2 = this.mvmtDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt1 = this.mvmtDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssState = this.chssState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrXchCd = this.cntrXchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrId = this.cntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updLoclDt = this.updLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoFlg = this.spclCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCreTpCd = this.mvmtCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrSeq = this.vrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo2 = this.mgstNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDispFlg = this.cntrDispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vl = this.vl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvLvlNo = this.cnmvLvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSvrId = this.cntrSvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplitNo = this.cnmvSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKnt = this.bkgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIoCd = this.gateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCntrFlg = this.obCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRsnCd = this.mvmtRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstState = this.mgstState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo2 = this.chssNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCoCd = this.cnmvCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
