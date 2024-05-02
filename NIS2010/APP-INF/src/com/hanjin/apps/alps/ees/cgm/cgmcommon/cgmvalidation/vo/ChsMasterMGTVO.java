/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChsMasterMGTVO.java
*@FileTitle : ChsMasterMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.08 최민회 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChsMasterMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChsMasterMGTVO> models = new ArrayList<ChsMasterMGTVO>();
	
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String faEqNo = null;
	/* Column Info */
	private String ifSeq = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String chssRgstPrdCd = null;
	/* Column Info */
	private String chssMvmtDt = null;
	/* Column Info */
	private String mgstRunHrsUpdDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String chssTareWgt = null;
	/* Column Info */
	private String actOnhDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String gateIoCd = null;
	/* Column Info */
	private String chssRgstUpdDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String chssRgstLicNo = null;
	/* Column Info */
	private String mgstMchnSerNo = null;
	/* Column Info */
	private String chssRgstExpDt = null;
	/* Column Info */
	private String chssRgstUpdId = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String chssRgstYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String chssVehIdNo = null;
	/* Column Info */
	private String lstUseCoCd = null;
	/* Column Info */
	private String chssTmlUseFlg = null;
	/* Column Info */
	private String ifTtlRowKnt = null;
	/* Column Info */
	private String retAproNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mgstFuelCapa = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String faIfStsCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String mgstWarrEndDt = null;
	/* Column Info */
	private String chssOwnrCoCd = null;
	/* Column Info */
	private String chssRgstCntCd = null;
	/* Column Info */
	private String onhOfcCd = null;
	/* Column Info */
	private String chssAlsNo = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mgstRunHrs = null;
	/* Column Info */
	private String chssRgstUpdOfcCd = null;
	/* Column Info */
	private String chssTitNo = null;
	/* Column Info */
	private String mgstVltgCapa = null;
	/* Column Info */
	private String faIfTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eaiIfNo = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String eqLotNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String faIfDt = null;
	/* Column Info */
	private String atchMgstNo = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String chssMvmtDestYdCd = null;
	/* Column Info */
	private String faIfErrMsg = null;
	/* Column Info */
	private String chssRgstSteCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChsMasterMGTVO() {}

	public ChsMasterMGTVO(String ibflag, String pagerows, String dispFlg, String chssMvmtStsCd, String agmtSeq, String onhYdCd, String updUsrId, String updDt, String agmtLstmCd, String eqKndCd, String chssMvmtDestYdCd, String chssRgstPrdCd, String crntLocCd, String onhDt,  String chssRgstExpDt, String onhOfcCd, String eqLotNo, String mgstFuelCapa, String mgstVltgCapa, String crntYdCd, String actOnhDt, String chssTmlUseFlg, String mftDt, String mgstWarrEndDt, String eqNo, String chssOwnrCoCd, String chssRgstYr, String chssTareWgt, String faIfErrMsg, String gateIoCd, String mgstRunHrsUpdDt, String dmgFlg, String faIfDt, String mgstRunHrs, String chssTitNo, String agmtVerNo, String ifSeq, String chssRgstSteCd, String chssRgstUpdOfcCd, String faIfTpCd, String chssAlsNo, String agmtOfcCtyCd, String ifTtlRowKnt, String chssRgstCntCd, String chssRgstLicNo, String eqTpszCd, String chssRgstUpdDt, String retAproNo, String atchMgstNo, String aciacDivCd, String faIfStsCd, String chssRgstUpdId, String eqSpecNo, String mgstMchnSerNo, String eaiIfNo, String lstUseCoCd, String chssMvmtDt, String creDt, String faEqNo, String creUsrId,  String chssVehIdNo, String chssPoolCd, String cntrTpszCd, String cntrNo) {		this.onhYdCd = onhYdCd;
		this.chssPoolCd = chssPoolCd;
		this.faEqNo = faEqNo;
		this.ifSeq = ifSeq;
		this.pagerows = pagerows;
		this.chssRgstPrdCd = chssRgstPrdCd;
		this.chssMvmtDt = chssMvmtDt;
		this.mgstRunHrsUpdDt = mgstRunHrsUpdDt;
		this.cntrTpszCd = cntrTpszCd;
		this.chssTareWgt = chssTareWgt;
		this.actOnhDt = actOnhDt;
		this.updUsrId = updUsrId;
		this.gateIoCd = gateIoCd;
		this.chssRgstUpdDt = chssRgstUpdDt;
		this.agmtSeq = agmtSeq;
		this.chssRgstLicNo = chssRgstLicNo;
		this.mgstMchnSerNo = mgstMchnSerNo;
		this.chssRgstExpDt = chssRgstExpDt;
		this.chssRgstUpdId = chssRgstUpdId;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.eqTpszCd = eqTpszCd;
		this.dispFlg = dispFlg;
		this.chssRgstYr = chssRgstYr;
		this.creUsrId = creUsrId;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtVerNo = agmtVerNo;
		this.chssVehIdNo = chssVehIdNo;
		this.lstUseCoCd = lstUseCoCd;
		this.chssTmlUseFlg = chssTmlUseFlg;
		this.ifTtlRowKnt = ifTtlRowKnt;
		this.retAproNo = retAproNo;
		this.creDt = creDt;
		this.mgstFuelCapa = mgstFuelCapa;
		this.crntYdCd = crntYdCd;
		this.dmgFlg = dmgFlg;
		this.onhDt = onhDt;
		this.faIfStsCd = faIfStsCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.mgstWarrEndDt = mgstWarrEndDt;
		this.chssOwnrCoCd = chssOwnrCoCd;
		this.chssRgstCntCd = chssRgstCntCd;
		this.onhOfcCd = onhOfcCd;
		this.chssAlsNo = chssAlsNo;
		this.eqSpecNo = eqSpecNo;
		this.updDt = updDt;
		this.mgstRunHrs = mgstRunHrs;
		this.chssRgstUpdOfcCd = chssRgstUpdOfcCd;
		this.chssTitNo = chssTitNo;
		this.mgstVltgCapa = mgstVltgCapa;
		this.faIfTpCd = faIfTpCd;
		this.eqKndCd = eqKndCd;
		this.eaiIfNo = eaiIfNo;
		this.mftDt = mftDt;
		this.eqLotNo = eqLotNo;
		this.cntrNo = cntrNo;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.faIfDt = faIfDt;
		this.atchMgstNo = atchMgstNo;
		this.crntLocCd = crntLocCd;
		this.chssMvmtDestYdCd = chssMvmtDestYdCd;
		this.faIfErrMsg = faIfErrMsg;
		this.chssRgstSteCd = chssRgstSteCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("fa_eq_no", getFaEqNo());
		this.hashColumns.put("if_seq", getIfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_rgst_prd_cd", getChssRgstPrdCd());
		this.hashColumns.put("chss_mvmt_dt", getChssMvmtDt());
		this.hashColumns.put("mgst_run_hrs_upd_dt", getMgstRunHrsUpdDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("chss_tare_wgt", getChssTareWgt());
		this.hashColumns.put("act_onh_dt", getActOnhDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gate_io_cd", getGateIoCd());
		this.hashColumns.put("chss_rgst_upd_dt", getChssRgstUpdDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("chss_rgst_lic_no", getChssRgstLicNo());
		this.hashColumns.put("mgst_mchn_ser_no", getMgstMchnSerNo());
		this.hashColumns.put("chss_rgst_exp_dt", getChssRgstExpDt());
		this.hashColumns.put("chss_rgst_upd_id", getChssRgstUpdId());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("chss_rgst_yr", getChssRgstYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("chss_veh_id_no", getChssVehIdNo());
		this.hashColumns.put("lst_use_co_cd", getLstUseCoCd());
		this.hashColumns.put("chss_tml_use_flg", getChssTmlUseFlg());
		this.hashColumns.put("if_ttl_row_knt", getIfTtlRowKnt());
		this.hashColumns.put("ret_apro_no", getRetAproNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mgst_fuel_capa", getMgstFuelCapa());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("fa_if_sts_cd", getFaIfStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("mgst_warr_end_dt", getMgstWarrEndDt());
		this.hashColumns.put("chss_ownr_co_cd", getChssOwnrCoCd());
		this.hashColumns.put("chss_rgst_cnt_cd", getChssRgstCntCd());
		this.hashColumns.put("onh_ofc_cd", getOnhOfcCd());
		this.hashColumns.put("chss_als_no", getChssAlsNo());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mgst_run_hrs", getMgstRunHrs());
		this.hashColumns.put("chss_rgst_upd_ofc_cd", getChssRgstUpdOfcCd());
		this.hashColumns.put("chss_tit_no", getChssTitNo());
		this.hashColumns.put("mgst_vltg_capa", getMgstVltgCapa());
		this.hashColumns.put("fa_if_tp_cd", getFaIfTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eai_if_no", getEaiIfNo());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("eq_lot_no", getEqLotNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("fa_if_dt", getFaIfDt());
		this.hashColumns.put("atch_mgst_no", getAtchMgstNo());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("chss_mvmt_dest_yd_cd", getChssMvmtDestYdCd());
		this.hashColumns.put("fa_if_err_msg", getFaIfErrMsg());
		this.hashColumns.put("chss_rgst_ste_cd", getChssRgstSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("fa_eq_no", "faEqNo");
		this.hashFields.put("if_seq", "ifSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_rgst_prd_cd", "chssRgstPrdCd");
		this.hashFields.put("chss_mvmt_dt", "chssMvmtDt");
		this.hashFields.put("mgst_run_hrs_upd_dt", "mgstRunHrsUpdDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chss_tare_wgt", "chssTareWgt");
		this.hashFields.put("act_onh_dt", "actOnhDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gate_io_cd", "gateIoCd");
		this.hashFields.put("chss_rgst_upd_dt", "chssRgstUpdDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("chss_rgst_lic_no", "chssRgstLicNo");
		this.hashFields.put("mgst_mchn_ser_no", "mgstMchnSerNo");
		this.hashFields.put("chss_rgst_exp_dt", "chssRgstExpDt");
		this.hashFields.put("chss_rgst_upd_id", "chssRgstUpdId");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("chss_rgst_yr", "chssRgstYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("chss_veh_id_no", "chssVehIdNo");
		this.hashFields.put("lst_use_co_cd", "lstUseCoCd");
		this.hashFields.put("chss_tml_use_flg", "chssTmlUseFlg");
		this.hashFields.put("if_ttl_row_knt", "ifTtlRowKnt");
		this.hashFields.put("ret_apro_no", "retAproNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mgst_fuel_capa", "mgstFuelCapa");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("fa_if_sts_cd", "faIfStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mgst_warr_end_dt", "mgstWarrEndDt");
		this.hashFields.put("chss_ownr_co_cd", "chssOwnrCoCd");
		this.hashFields.put("chss_rgst_cnt_cd", "chssRgstCntCd");
		this.hashFields.put("onh_ofc_cd", "onhOfcCd");
		this.hashFields.put("chss_als_no", "chssAlsNo");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mgst_run_hrs", "mgstRunHrs");
		this.hashFields.put("chss_rgst_upd_ofc_cd", "chssRgstUpdOfcCd");
		this.hashFields.put("chss_tit_no", "chssTitNo");
		this.hashFields.put("mgst_vltg_capa", "mgstVltgCapa");
		this.hashFields.put("fa_if_tp_cd", "faIfTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eai_if_no", "eaiIfNo");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("eq_lot_no", "eqLotNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("fa_if_dt", "faIfDt");
		this.hashFields.put("atch_mgst_no", "atchMgstNo");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("chss_mvmt_dest_yd_cd", "chssMvmtDestYdCd");
		this.hashFields.put("fa_if_err_msg", "faIfErrMsg");
		this.hashFields.put("chss_rgst_ste_cd", "chssRgstSteCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
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
	 * @return faEqNo
	 */
	public String getFaEqNo() {
		return this.faEqNo;
	}
	
	/**
	 * Column Info
	 * @return ifSeq
	 */
	public String getIfSeq() {
		return this.ifSeq;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return chssRgstPrdCd
	 */
	public String getChssRgstPrdCd() {
		return this.chssRgstPrdCd;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDt
	 */
	public String getChssMvmtDt() {
		return this.chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return mgstRunHrsUpdDt
	 */
	public String getMgstRunHrsUpdDt() {
		return this.mgstRunHrsUpdDt;
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
	 * @return chssTareWgt
	 */
	public String getChssTareWgt() {
		return this.chssTareWgt;
	}
	
	/**
	 * Column Info
	 * @return actOnhDt
	 */
	public String getActOnhDt() {
		return this.actOnhDt;
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
	 * @return gateIoCd
	 */
	public String getGateIoCd() {
		return this.gateIoCd;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdDt
	 */
	public String getChssRgstUpdDt() {
		return this.chssRgstUpdDt;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return chssRgstLicNo
	 */
	public String getChssRgstLicNo() {
		return this.chssRgstLicNo;
	}
	
	/**
	 * Column Info
	 * @return mgstMchnSerNo
	 */
	public String getMgstMchnSerNo() {
		return this.mgstMchnSerNo;
	}
	
	/**
	 * Column Info
	 * @return chssRgstExpDt
	 */
	public String getChssRgstExpDt() {
		return this.chssRgstExpDt;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdId
	 */
	public String getChssRgstUpdId() {
		return this.chssRgstUpdId;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
	}
	
	/**
	 * Column Info
	 * @return chssRgstYr
	 */
	public String getChssRgstYr() {
		return this.chssRgstYr;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return chssVehIdNo
	 */
	public String getChssVehIdNo() {
		return this.chssVehIdNo;
	}
	
	/**
	 * Column Info
	 * @return lstUseCoCd
	 */
	public String getLstUseCoCd() {
		return this.lstUseCoCd;
	}
	
	/**
	 * Column Info
	 * @return chssTmlUseFlg
	 */
	public String getChssTmlUseFlg() {
		return this.chssTmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return ifTtlRowKnt
	 */
	public String getIfTtlRowKnt() {
		return this.ifTtlRowKnt;
	}
	
	/**
	 * Column Info
	 * @return retAproNo
	 */
	public String getRetAproNo() {
		return this.retAproNo;
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
	 * @return mgstFuelCapa
	 */
	public String getMgstFuelCapa() {
		return this.mgstFuelCapa;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return faIfStsCd
	 */
	public String getFaIfStsCd() {
		return this.faIfStsCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return mgstWarrEndDt
	 */
	public String getMgstWarrEndDt() {
		return this.mgstWarrEndDt;
	}
	
	/**
	 * Column Info
	 * @return chssOwnrCoCd
	 */
	public String getChssOwnrCoCd() {
		return this.chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return chssRgstCntCd
	 */
	public String getChssRgstCntCd() {
		return this.chssRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return onhOfcCd
	 */
	public String getOnhOfcCd() {
		return this.onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chssAlsNo
	 */
	public String getChssAlsNo() {
		return this.chssAlsNo;
	}
	
	/**
	 * Column Info
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
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
	 * @return mgstRunHrs
	 */
	public String getMgstRunHrs() {
		return this.mgstRunHrs;
	}
	
	/**
	 * Column Info
	 * @return chssRgstUpdOfcCd
	 */
	public String getChssRgstUpdOfcCd() {
		return this.chssRgstUpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chssTitNo
	 */
	public String getChssTitNo() {
		return this.chssTitNo;
	}
	
	/**
	 * Column Info
	 * @return mgstVltgCapa
	 */
	public String getMgstVltgCapa() {
		return this.mgstVltgCapa;
	}
	
	/**
	 * Column Info
	 * @return faIfTpCd
	 */
	public String getFaIfTpCd() {
		return this.faIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eaiIfNo
	 */
	public String getEaiIfNo() {
		return this.eaiIfNo;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return eqLotNo
	 */
	public String getEqLotNo() {
		return this.eqLotNo;
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
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return faIfDt
	 */
	public String getFaIfDt() {
		return this.faIfDt;
	}
	
	/**
	 * Column Info
	 * @return atchMgstNo
	 */
	public String getAtchMgstNo() {
		return this.atchMgstNo;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	
	/**
	 * Column Info
	 * @return chssMvmtDestYdCd
	 */
	public String getChssMvmtDestYdCd() {
		return this.chssMvmtDestYdCd;
	}
	
	/**
	 * Column Info
	 * @return faIfErrMsg
	 */
	public String getFaIfErrMsg() {
		return this.faIfErrMsg;
	}
	
	/**
	 * Column Info
	 * @return chssRgstSteCd
	 */
	public String getChssRgstSteCd() {
		return this.chssRgstSteCd;
	}
	

	/**
	 * Column Info
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
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
	 * @param faEqNo
	 */
	public void setFaEqNo(String faEqNo) {
		this.faEqNo = faEqNo;
	}
	
	/**
	 * Column Info
	 * @param ifSeq
	 */
	public void setIfSeq(String ifSeq) {
		this.ifSeq = ifSeq;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param chssRgstPrdCd
	 */
	public void setChssRgstPrdCd(String chssRgstPrdCd) {
		this.chssRgstPrdCd = chssRgstPrdCd;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDt
	 */
	public void setChssMvmtDt(String chssMvmtDt) {
		this.chssMvmtDt = chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param mgstRunHrsUpdDt
	 */
	public void setMgstRunHrsUpdDt(String mgstRunHrsUpdDt) {
		this.mgstRunHrsUpdDt = mgstRunHrsUpdDt;
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
	 * @param chssTareWgt
	 */
	public void setChssTareWgt(String chssTareWgt) {
		this.chssTareWgt = chssTareWgt;
	}
	
	/**
	 * Column Info
	 * @param actOnhDt
	 */
	public void setActOnhDt(String actOnhDt) {
		this.actOnhDt = actOnhDt;
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
	 * @param gateIoCd
	 */
	public void setGateIoCd(String gateIoCd) {
		this.gateIoCd = gateIoCd;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdDt
	 */
	public void setChssRgstUpdDt(String chssRgstUpdDt) {
		this.chssRgstUpdDt = chssRgstUpdDt;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param chssRgstLicNo
	 */
	public void setChssRgstLicNo(String chssRgstLicNo) {
		this.chssRgstLicNo = chssRgstLicNo;
	}
	
	/**
	 * Column Info
	 * @param mgstMchnSerNo
	 */
	public void setMgstMchnSerNo(String mgstMchnSerNo) {
		this.mgstMchnSerNo = mgstMchnSerNo;
	}
	
	/**
	 * Column Info
	 * @param chssRgstExpDt
	 */
	public void setChssRgstExpDt(String chssRgstExpDt) {
		this.chssRgstExpDt = chssRgstExpDt;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdId
	 */
	public void setChssRgstUpdId(String chssRgstUpdId) {
		this.chssRgstUpdId = chssRgstUpdId;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
	}
	
	/**
	 * Column Info
	 * @param chssRgstYr
	 */
	public void setChssRgstYr(String chssRgstYr) {
		this.chssRgstYr = chssRgstYr;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param chssVehIdNo
	 */
	public void setChssVehIdNo(String chssVehIdNo) {
		this.chssVehIdNo = chssVehIdNo;
	}
	
	/**
	 * Column Info
	 * @param lstUseCoCd
	 */
	public void setLstUseCoCd(String lstUseCoCd) {
		this.lstUseCoCd = lstUseCoCd;
	}
	
	/**
	 * Column Info
	 * @param chssTmlUseFlg
	 */
	public void setChssTmlUseFlg(String chssTmlUseFlg) {
		this.chssTmlUseFlg = chssTmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param ifTtlRowKnt
	 */
	public void setIfTtlRowKnt(String ifTtlRowKnt) {
		this.ifTtlRowKnt = ifTtlRowKnt;
	}
	
	/**
	 * Column Info
	 * @param retAproNo
	 */
	public void setRetAproNo(String retAproNo) {
		this.retAproNo = retAproNo;
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
	 * @param mgstFuelCapa
	 */
	public void setMgstFuelCapa(String mgstFuelCapa) {
		this.mgstFuelCapa = mgstFuelCapa;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param faIfStsCd
	 */
	public void setFaIfStsCd(String faIfStsCd) {
		this.faIfStsCd = faIfStsCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param mgstWarrEndDt
	 */
	public void setMgstWarrEndDt(String mgstWarrEndDt) {
		this.mgstWarrEndDt = mgstWarrEndDt;
	}
	
	/**
	 * Column Info
	 * @param chssOwnrCoCd
	 */
	public void setChssOwnrCoCd(String chssOwnrCoCd) {
		this.chssOwnrCoCd = chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param chssRgstCntCd
	 */
	public void setChssRgstCntCd(String chssRgstCntCd) {
		this.chssRgstCntCd = chssRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param onhOfcCd
	 */
	public void setOnhOfcCd(String onhOfcCd) {
		this.onhOfcCd = onhOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chssAlsNo
	 */
	public void setChssAlsNo(String chssAlsNo) {
		this.chssAlsNo = chssAlsNo;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
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
	 * @param mgstRunHrs
	 */
	public void setMgstRunHrs(String mgstRunHrs) {
		this.mgstRunHrs = mgstRunHrs;
	}
	
	/**
	 * Column Info
	 * @param chssRgstUpdOfcCd
	 */
	public void setChssRgstUpdOfcCd(String chssRgstUpdOfcCd) {
		this.chssRgstUpdOfcCd = chssRgstUpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chssTitNo
	 */
	public void setChssTitNo(String chssTitNo) {
		this.chssTitNo = chssTitNo;
	}
	
	/**
	 * Column Info
	 * @param mgstVltgCapa
	 */
	public void setMgstVltgCapa(String mgstVltgCapa) {
		this.mgstVltgCapa = mgstVltgCapa;
	}
	
	/**
	 * Column Info
	 * @param faIfTpCd
	 */
	public void setFaIfTpCd(String faIfTpCd) {
		this.faIfTpCd = faIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eaiIfNo
	 */
	public void setEaiIfNo(String eaiIfNo) {
		this.eaiIfNo = eaiIfNo;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param eqLotNo
	 */
	public void setEqLotNo(String eqLotNo) {
		this.eqLotNo = eqLotNo;
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
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param faIfDt
	 */
	public void setFaIfDt(String faIfDt) {
		this.faIfDt = faIfDt;
	}
	
	/**
	 * Column Info
	 * @param atchMgstNo
	 */
	public void setAtchMgstNo(String atchMgstNo) {
		this.atchMgstNo = atchMgstNo;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Column Info
	 * @param chssMvmtDestYdCd
	 */
	public void setChssMvmtDestYdCd(String chssMvmtDestYdCd) {
		this.chssMvmtDestYdCd = chssMvmtDestYdCd;
	}
	
	/**
	 * Column Info
	 * @param faIfErrMsg
	 */
	public void setFaIfErrMsg(String faIfErrMsg) {
		this.faIfErrMsg = faIfErrMsg;
	}
	
	/**
	 * Column Info
	 * @param chssRgstSteCd
	 */
	public void setChssRgstSteCd(String chssRgstSteCd) {
		this.chssRgstSteCd = chssRgstSteCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOnhYdCd(JSPUtil.getParameter(request, "onh_yd_cd", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setFaEqNo(JSPUtil.getParameter(request, "fa_eq_no", ""));
		setIfSeq(JSPUtil.getParameter(request, "if_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChssRgstPrdCd(JSPUtil.getParameter(request, "chss_rgst_prd_cd", ""));
		setChssMvmtDt(JSPUtil.getParameter(request, "chss_mvmt_dt", ""));
		setMgstRunHrsUpdDt(JSPUtil.getParameter(request, "mgst_run_hrs_upd_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setChssTareWgt(JSPUtil.getParameter(request, "chss_tare_wgt", ""));
		setActOnhDt(JSPUtil.getParameter(request, "act_onh_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGateIoCd(JSPUtil.getParameter(request, "gate_io_cd", ""));
		setChssRgstUpdDt(JSPUtil.getParameter(request, "chss_rgst_upd_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setChssRgstLicNo(JSPUtil.getParameter(request, "chss_rgst_lic_no", ""));
		setMgstMchnSerNo(JSPUtil.getParameter(request, "mgst_mchn_ser_no", ""));
		setChssRgstExpDt(JSPUtil.getParameter(request, "chss_rgst_exp_dt", ""));
		setChssRgstUpdId(JSPUtil.getParameter(request, "chss_rgst_upd_id", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setChssRgstYr(JSPUtil.getParameter(request, "chss_rgst_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setChssVehIdNo(JSPUtil.getParameter(request, "chss_veh_id_no", ""));
		setLstUseCoCd(JSPUtil.getParameter(request, "lst_use_co_cd", ""));
		setChssTmlUseFlg(JSPUtil.getParameter(request, "chss_tml_use_flg", ""));
		setIfTtlRowKnt(JSPUtil.getParameter(request, "if_ttl_row_knt", ""));
		setRetAproNo(JSPUtil.getParameter(request, "ret_apro_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMgstFuelCapa(JSPUtil.getParameter(request, "mgst_fuel_capa", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setFaIfStsCd(JSPUtil.getParameter(request, "fa_if_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setMgstWarrEndDt(JSPUtil.getParameter(request, "mgst_warr_end_dt", ""));
		setChssOwnrCoCd(JSPUtil.getParameter(request, "chss_ownr_co_cd", ""));
		setChssRgstCntCd(JSPUtil.getParameter(request, "chss_rgst_cnt_cd", ""));
		setOnhOfcCd(JSPUtil.getParameter(request, "onh_ofc_cd", ""));
		setChssAlsNo(JSPUtil.getParameter(request, "chss_als_no", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMgstRunHrs(JSPUtil.getParameter(request, "mgst_run_hrs", ""));
		setChssRgstUpdOfcCd(JSPUtil.getParameter(request, "chss_rgst_upd_ofc_cd", ""));
		setChssTitNo(JSPUtil.getParameter(request, "chss_tit_no", ""));
		setMgstVltgCapa(JSPUtil.getParameter(request, "mgst_vltg_capa", ""));
		setFaIfTpCd(JSPUtil.getParameter(request, "fa_if_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEaiIfNo(JSPUtil.getParameter(request, "eai_if_no", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setEqLotNo(JSPUtil.getParameter(request, "eq_lot_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setFaIfDt(JSPUtil.getParameter(request, "fa_if_dt", ""));
		setAtchMgstNo(JSPUtil.getParameter(request, "atch_mgst_no", ""));
		setCrntLocCd(JSPUtil.getParameter(request, "crnt_loc_cd", ""));
		setChssMvmtDestYdCd(JSPUtil.getParameter(request, "chss_mvmt_dest_yd_cd", ""));
		setFaIfErrMsg(JSPUtil.getParameter(request, "fa_if_err_msg", ""));
		setChssRgstSteCd(JSPUtil.getParameter(request, "chss_rgst_ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChsMasterMGTVO[]
	 */
	public ChsMasterMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChsMasterMGTVO[]
	 */
	public ChsMasterMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChsMasterMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] faEqNo = (JSPUtil.getParameter(request, prefix	+ "fa_eq_no", length));
			String[] ifSeq = (JSPUtil.getParameter(request, prefix	+ "if_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssRgstPrdCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_prd_cd", length));
			String[] chssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt", length));
			String[] mgstRunHrsUpdDt = (JSPUtil.getParameter(request, prefix	+ "mgst_run_hrs_upd_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] chssTareWgt = (JSPUtil.getParameter(request, prefix	+ "chss_tare_wgt", length));
			String[] actOnhDt = (JSPUtil.getParameter(request, prefix	+ "act_onh_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] gateIoCd = (JSPUtil.getParameter(request, prefix	+ "gate_io_cd", length));
			String[] chssRgstUpdDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] chssRgstLicNo = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_lic_no", length));
			String[] mgstMchnSerNo = (JSPUtil.getParameter(request, prefix	+ "mgst_mchn_ser_no", length));
			String[] chssRgstExpDt = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_exp_dt", length));
			String[] chssRgstUpdId = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_id", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] chssRgstYr = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] chssVehIdNo = (JSPUtil.getParameter(request, prefix	+ "chss_veh_id_no", length));
			String[] lstUseCoCd = (JSPUtil.getParameter(request, prefix	+ "lst_use_co_cd", length));
			String[] chssTmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "chss_tml_use_flg", length));
			String[] ifTtlRowKnt = (JSPUtil.getParameter(request, prefix	+ "if_ttl_row_knt", length));
			String[] retAproNo = (JSPUtil.getParameter(request, prefix	+ "ret_apro_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mgstFuelCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_fuel_capa", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] faIfStsCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] mgstWarrEndDt = (JSPUtil.getParameter(request, prefix	+ "mgst_warr_end_dt", length));
			String[] chssOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "chss_ownr_co_cd", length));
			String[] chssRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_cnt_cd", length));
			String[] onhOfcCd = (JSPUtil.getParameter(request, prefix	+ "onh_ofc_cd", length));
			String[] chssAlsNo = (JSPUtil.getParameter(request, prefix	+ "chss_als_no", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mgstRunHrs = (JSPUtil.getParameter(request, prefix	+ "mgst_run_hrs", length));
			String[] chssRgstUpdOfcCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_upd_ofc_cd", length));
			String[] chssTitNo = (JSPUtil.getParameter(request, prefix	+ "chss_tit_no", length));
			String[] mgstVltgCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_vltg_capa", length));
			String[] faIfTpCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eaiIfNo = (JSPUtil.getParameter(request, prefix	+ "eai_if_no", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] eqLotNo = (JSPUtil.getParameter(request, prefix	+ "eq_lot_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] faIfDt = (JSPUtil.getParameter(request, prefix	+ "fa_if_dt", length));
			String[] atchMgstNo = (JSPUtil.getParameter(request, prefix	+ "atch_mgst_no", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] chssMvmtDestYdCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dest_yd_cd", length));
			String[] faIfErrMsg = (JSPUtil.getParameter(request, prefix	+ "fa_if_err_msg", length));
			String[] chssRgstSteCd = (JSPUtil.getParameter(request, prefix	+ "chss_rgst_ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChsMasterMGTVO();
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (faEqNo[i] != null)
					model.setFaEqNo(faEqNo[i]);
				if (ifSeq[i] != null)
					model.setIfSeq(ifSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssRgstPrdCd[i] != null)
					model.setChssRgstPrdCd(chssRgstPrdCd[i]);
				if (chssMvmtDt[i] != null)
					model.setChssMvmtDt(chssMvmtDt[i]);
				if (mgstRunHrsUpdDt[i] != null)
					model.setMgstRunHrsUpdDt(mgstRunHrsUpdDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (chssTareWgt[i] != null)
					model.setChssTareWgt(chssTareWgt[i]);
				if (actOnhDt[i] != null)
					model.setActOnhDt(actOnhDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (gateIoCd[i] != null)
					model.setGateIoCd(gateIoCd[i]);
				if (chssRgstUpdDt[i] != null)
					model.setChssRgstUpdDt(chssRgstUpdDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (chssRgstLicNo[i] != null)
					model.setChssRgstLicNo(chssRgstLicNo[i]);
				if (mgstMchnSerNo[i] != null)
					model.setMgstMchnSerNo(mgstMchnSerNo[i]);
				if (chssRgstExpDt[i] != null)
					model.setChssRgstExpDt(chssRgstExpDt[i]);
				if (chssRgstUpdId[i] != null)
					model.setChssRgstUpdId(chssRgstUpdId[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (chssRgstYr[i] != null)
					model.setChssRgstYr(chssRgstYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (chssVehIdNo[i] != null)
					model.setChssVehIdNo(chssVehIdNo[i]);
				if (lstUseCoCd[i] != null)
					model.setLstUseCoCd(lstUseCoCd[i]);
				if (chssTmlUseFlg[i] != null)
					model.setChssTmlUseFlg(chssTmlUseFlg[i]);
				if (ifTtlRowKnt[i] != null)
					model.setIfTtlRowKnt(ifTtlRowKnt[i]);
				if (retAproNo[i] != null)
					model.setRetAproNo(retAproNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mgstFuelCapa[i] != null)
					model.setMgstFuelCapa(mgstFuelCapa[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (faIfStsCd[i] != null)
					model.setFaIfStsCd(faIfStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (mgstWarrEndDt[i] != null)
					model.setMgstWarrEndDt(mgstWarrEndDt[i]);
				if (chssOwnrCoCd[i] != null)
					model.setChssOwnrCoCd(chssOwnrCoCd[i]);
				if (chssRgstCntCd[i] != null)
					model.setChssRgstCntCd(chssRgstCntCd[i]);
				if (onhOfcCd[i] != null)
					model.setOnhOfcCd(onhOfcCd[i]);
				if (chssAlsNo[i] != null)
					model.setChssAlsNo(chssAlsNo[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mgstRunHrs[i] != null)
					model.setMgstRunHrs(mgstRunHrs[i]);
				if (chssRgstUpdOfcCd[i] != null)
					model.setChssRgstUpdOfcCd(chssRgstUpdOfcCd[i]);
				if (chssTitNo[i] != null)
					model.setChssTitNo(chssTitNo[i]);
				if (mgstVltgCapa[i] != null)
					model.setMgstVltgCapa(mgstVltgCapa[i]);
				if (faIfTpCd[i] != null)
					model.setFaIfTpCd(faIfTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eaiIfNo[i] != null)
					model.setEaiIfNo(eaiIfNo[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (eqLotNo[i] != null)
					model.setEqLotNo(eqLotNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (faIfDt[i] != null)
					model.setFaIfDt(faIfDt[i]);
				if (atchMgstNo[i] != null)
					model.setAtchMgstNo(atchMgstNo[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (chssMvmtDestYdCd[i] != null)
					model.setChssMvmtDestYdCd(chssMvmtDestYdCd[i]);
				if (faIfErrMsg[i] != null)
					model.setFaIfErrMsg(faIfErrMsg[i]);
				if (chssRgstSteCd[i] != null)
					model.setChssRgstSteCd(chssRgstSteCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChsMasterMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChsMasterMGTVO[]
	 */
	public ChsMasterMGTVO[] getChsMasterMGTVOs(){
		ChsMasterMGTVO[] vos = (ChsMasterMGTVO[])models.toArray(new ChsMasterMGTVO[models.size()]);
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
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faEqNo = this.faEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSeq = this.ifSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstPrdCd = this.chssRgstPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt = this.chssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstRunHrsUpdDt = this.mgstRunHrsUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTareWgt = this.chssTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actOnhDt = this.actOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIoCd = this.gateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdDt = this.chssRgstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstLicNo = this.chssRgstLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstMchnSerNo = this.mgstMchnSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstExpDt = this.chssRgstExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdId = this.chssRgstUpdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstYr = this.chssRgstYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssVehIdNo = this.chssVehIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUseCoCd = this.lstUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTmlUseFlg = this.chssTmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTtlRowKnt = this.ifTtlRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retAproNo = this.retAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstFuelCapa = this.mgstFuelCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfStsCd = this.faIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstWarrEndDt = this.mgstWarrEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOwnrCoCd = this.chssOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstCntCd = this.chssRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhOfcCd = this.onhOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssAlsNo = this.chssAlsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstRunHrs = this.mgstRunHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstUpdOfcCd = this.chssRgstUpdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTitNo = this.chssTitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstVltgCapa = this.mgstVltgCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfTpCd = this.faIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfNo = this.eaiIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLotNo = this.eqLotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfDt = this.faIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchMgstNo = this.atchMgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDestYdCd = this.chssMvmtDestYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfErrMsg = this.faIfErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssRgstSteCd = this.chssRgstSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
