/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeVO.java
*@FileTitle : SurchargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.05 DONG- IL, SHIN 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo;

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
 * @author DONG- IL, SHIN
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SurchargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SurchargeVO> models = new ArrayList<SurchargeVO>();
	
	/* Column Info */
	private String invLftgKnt = null;
	/* Column Info */
	private String ovrWgtOtrFlg = null;
	/* Column Info */
	private String invOvrWgtOtrFlg = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String inspRfPtiCstmsTpCd = null;
	/* Column Info */
	private String invDryRunRlblPtyTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyDesc = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String wtHrs = null;
	/* Column Info */
	private String lftgCuzDesc = null;
	/* Column Info */
	private String otrRmk = null;
	/* Column Info */
	private String invObBkgNo = null;
	/* Column Info */
	private String invOvrWgtRmk = null;
	/* Column Info */
	private String uniqueCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String incrtDt = null;
	/* Column Info */
	private String trspAgmtBfrExtdFlg = null;
	/* Column Info */
	private String n3ptyVndrSeq = null;
	/* Column Info */
	private String invChssMgstTpszCd = null;
	/* Column Info */
	private String invWtHrs = null;
	/* Column Info */
	private String invFumgCostTpCd = null;
	/* Column Info */
	private String invTriAxlFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hjlNo = null;
	/* Column Info */
	private String stopLocNodCd = null;
	/* Column Info */
	private String invRfMgstUsgFlg = null;
	/* Column Info */
	private String invIncrtDt = null;
	/* Column Info */
	private String invRfHndlFlg = null;
	/* Column Info */
	private String ovrWgtRmk = null;
	/* Column Info */
	private String invLftgCuzDesc = null;
	/* Column Info */
	private String invGrsWgtMeasUtCd = null;
	/* Column Info */
	private String incurDt = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String triAxlFlg = null;
	/* Column Info */
	private String mgstTpszCd = null;
	/* Column Info */
	private String invSclStopPlcNodCd = null;
	/* Column Info */
	private String n3ptyAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lftgKnt = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String invMgstTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stoDys = null;
	/* Column Info */
	private String invStoDys = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String fneCuzDesc = null;
	/* Column Info */
	private String obBkgNo = null;
	/* Column Info */
	private String rfMgstUsgFlg = null;
	/* Column Info */
	private String invOvrWgtPrmtFlg = null;
	/* Column Info */
	private String invGrsWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invInspRfPtiCstmsTpCd = null;
	/* Column Info */
	private String invIncurDt = null;
	/* Column Info */
	private String woGrsWgtMeasUtCd = null;
	/* Column Info */
	private String dryRunRlblPtyTpCd = null;
	/* Column Info */
	private String invOtrRmk = null;
	/* Column Info */
	private String chssMgstTpszCd = null;
	/* Column Info */
	private String sclStopPlcNodCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ovrWgtPrmtFlg = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String invScgAmt = null;
	/* Column Info */
	private String fumgCostTpCd = null;
	/* Column Info */
	private String invStopLocNodCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String scgAmt = null;
	/* Column Info */
	private String invChssNo = null;
	/* Column Info */
	private String rfHndlFlg = null;
	/* Column Info */
	private String invFneCuzDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SurchargeVO() {}

	public SurchargeVO(String ibflag, String pagerows, String trspAgmtBfrExtdFlg, String invLftgKnt, String ovrWgtOtrFlg, String invOvrWgtOtrFlg, String chssNo, String trspSoSeq, String inspRfPtiCstmsTpCd, String invDryRunRlblPtyTpCd, String n3ptyDesc, String n3ptyOfcCd, String wtHrs, String lftgCuzDesc, String otrRmk, String invOvrWgtRmk, String invObBkgNo, String uniqueCd, String custCntCd, String updUsrId, String incrtDt, String n3ptyVndrSeq, String invChssMgstTpszCd, String invWtHrs, String invFumgCostTpCd, String invTriAxlFlg, String creUsrId, String hjlNo, String stopLocNodCd, String invRfMgstUsgFlg, String invIncrtDt, String invRfHndlFlg, String ovrWgtRmk, String invLftgCuzDesc, String invGrsWgtMeasUtCd, String incurDt, String loclUpdDt, String grsWgt, String triAxlFlg, String mgstTpszCd, String invSclStopPlcNodCd, String n3ptyAmt, String creDt, String lftgKnt, String trspSoOfcCtyCd, String invMgstTpszCd, String stoDys, String invStoDys, String creOfcCd, String fneCuzDesc, String rfMgstUsgFlg, String obBkgNo, String invOvrWgtPrmtFlg, String invGrsWgt, String updDt, String invIncurDt, String invInspRfPtiCstmsTpCd, String woGrsWgtMeasUtCd, String dryRunRlblPtyTpCd, String invOtrRmk, String sclStopPlcNodCd, String chssMgstTpszCd, String loclCreDt, String custSeq, String ovrWgtPrmtFlg, String n3ptyBilFlg, String invScgAmt, String fumgCostTpCd, String invStopLocNodCd, String scgAmt, String lgsCostCd, String rfHndlFlg, String invChssNo, String invFneCuzDesc) {
		this.invLftgKnt = invLftgKnt;
		this.ovrWgtOtrFlg = ovrWgtOtrFlg;
		this.invOvrWgtOtrFlg = invOvrWgtOtrFlg;
		this.chssNo = chssNo;
		this.trspSoSeq = trspSoSeq;
		this.inspRfPtiCstmsTpCd = inspRfPtiCstmsTpCd;
		this.invDryRunRlblPtyTpCd = invDryRunRlblPtyTpCd;
		this.pagerows = pagerows;
		this.n3ptyDesc = n3ptyDesc;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.wtHrs = wtHrs;
		this.lftgCuzDesc = lftgCuzDesc;
		this.otrRmk = otrRmk;
		this.invObBkgNo = invObBkgNo;
		this.invOvrWgtRmk = invOvrWgtRmk;
		this.uniqueCd = uniqueCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.incrtDt = incrtDt;
		this.trspAgmtBfrExtdFlg = trspAgmtBfrExtdFlg;
		this.n3ptyVndrSeq = n3ptyVndrSeq;
		this.invChssMgstTpszCd = invChssMgstTpszCd;
		this.invWtHrs = invWtHrs;
		this.invFumgCostTpCd = invFumgCostTpCd;
		this.invTriAxlFlg = invTriAxlFlg;
		this.creUsrId = creUsrId;
		this.hjlNo = hjlNo;
		this.stopLocNodCd = stopLocNodCd;
		this.invRfMgstUsgFlg = invRfMgstUsgFlg;
		this.invIncrtDt = invIncrtDt;
		this.invRfHndlFlg = invRfHndlFlg;
		this.ovrWgtRmk = ovrWgtRmk;
		this.invLftgCuzDesc = invLftgCuzDesc;
		this.invGrsWgtMeasUtCd = invGrsWgtMeasUtCd;
		this.incurDt = incurDt;
		this.loclUpdDt = loclUpdDt;
		this.grsWgt = grsWgt;
		this.triAxlFlg = triAxlFlg;
		this.mgstTpszCd = mgstTpszCd;
		this.invSclStopPlcNodCd = invSclStopPlcNodCd;
		this.n3ptyAmt = n3ptyAmt;
		this.creDt = creDt;
		this.lftgKnt = lftgKnt;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.invMgstTpszCd = invMgstTpszCd;
		this.ibflag = ibflag;
		this.stoDys = stoDys;
		this.invStoDys = invStoDys;
		this.creOfcCd = creOfcCd;
		this.fneCuzDesc = fneCuzDesc;
		this.obBkgNo = obBkgNo;
		this.rfMgstUsgFlg = rfMgstUsgFlg;
		this.invOvrWgtPrmtFlg = invOvrWgtPrmtFlg;
		this.invGrsWgt = invGrsWgt;
		this.updDt = updDt;
		this.invInspRfPtiCstmsTpCd = invInspRfPtiCstmsTpCd;
		this.invIncurDt = invIncurDt;
		this.woGrsWgtMeasUtCd = woGrsWgtMeasUtCd;
		this.dryRunRlblPtyTpCd = dryRunRlblPtyTpCd;
		this.invOtrRmk = invOtrRmk;
		this.chssMgstTpszCd = chssMgstTpszCd;
		this.sclStopPlcNodCd = sclStopPlcNodCd;
		this.loclCreDt = loclCreDt;
		this.custSeq = custSeq;
		this.ovrWgtPrmtFlg = ovrWgtPrmtFlg;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.invScgAmt = invScgAmt;
		this.fumgCostTpCd = fumgCostTpCd;
		this.invStopLocNodCd = invStopLocNodCd;
		this.lgsCostCd = lgsCostCd;
		this.scgAmt = scgAmt;
		this.invChssNo = invChssNo;
		this.rfHndlFlg = rfHndlFlg;
		this.invFneCuzDesc = invFneCuzDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_lftg_knt", getInvLftgKnt());
		this.hashColumns.put("ovr_wgt_otr_flg", getOvrWgtOtrFlg());
		this.hashColumns.put("inv_ovr_wgt_otr_flg", getInvOvrWgtOtrFlg());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("insp_rf_pti_cstms_tp_cd", getInspRfPtiCstmsTpCd());
		this.hashColumns.put("inv_dry_run_rlbl_pty_tp_cd", getInvDryRunRlblPtyTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_desc", getN3ptyDesc());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("wt_hrs", getWtHrs());
		this.hashColumns.put("lftg_cuz_desc", getLftgCuzDesc());
		this.hashColumns.put("otr_rmk", getOtrRmk());
		this.hashColumns.put("inv_ob_bkg_no", getInvObBkgNo());
		this.hashColumns.put("inv_ovr_wgt_rmk", getInvOvrWgtRmk());
		this.hashColumns.put("unique_cd", getUniqueCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("incrt_dt", getIncrtDt());
		this.hashColumns.put("trsp_agmt_bfr_extd_flg", getTrspAgmtBfrExtdFlg());
		this.hashColumns.put("n3pty_vndr_seq", getN3ptyVndrSeq());
		this.hashColumns.put("inv_chss_mgst_tpsz_cd", getInvChssMgstTpszCd());
		this.hashColumns.put("inv_wt_hrs", getInvWtHrs());
		this.hashColumns.put("inv_fumg_cost_tp_cd", getInvFumgCostTpCd());
		this.hashColumns.put("inv_tri_axl_flg", getInvTriAxlFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hjl_no", getHjlNo());
		this.hashColumns.put("stop_loc_nod_cd", getStopLocNodCd());
		this.hashColumns.put("inv_rf_mgst_usg_flg", getInvRfMgstUsgFlg());
		this.hashColumns.put("inv_incrt_dt", getInvIncrtDt());
		this.hashColumns.put("inv_rf_hndl_flg", getInvRfHndlFlg());
		this.hashColumns.put("ovr_wgt_rmk", getOvrWgtRmk());
		this.hashColumns.put("inv_lftg_cuz_desc", getInvLftgCuzDesc());
		this.hashColumns.put("inv_grs_wgt_meas_ut_cd", getInvGrsWgtMeasUtCd());
		this.hashColumns.put("incur_dt", getIncurDt());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("tri_axl_flg", getTriAxlFlg());
		this.hashColumns.put("mgst_tpsz_cd", getMgstTpszCd());
		this.hashColumns.put("inv_scl_stop_plc_nod_cd", getInvSclStopPlcNodCd());
		this.hashColumns.put("n3pty_amt", getN3ptyAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lftg_knt", getLftgKnt());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("inv_mgst_tpsz_cd", getInvMgstTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sto_dys", getStoDys());
		this.hashColumns.put("inv_sto_dys", getInvStoDys());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("fne_cuz_desc", getFneCuzDesc());
		this.hashColumns.put("ob_bkg_no", getObBkgNo());
		this.hashColumns.put("rf_mgst_usg_flg", getRfMgstUsgFlg());
		this.hashColumns.put("inv_ovr_wgt_prmt_flg", getInvOvrWgtPrmtFlg());
		this.hashColumns.put("inv_grs_wgt", getInvGrsWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_insp_rf_pti_cstms_tp_cd", getInvInspRfPtiCstmsTpCd());
		this.hashColumns.put("inv_incur_dt", getInvIncurDt());
		this.hashColumns.put("wo_grs_wgt_meas_ut_cd", getWoGrsWgtMeasUtCd());
		this.hashColumns.put("dry_run_rlbl_pty_tp_cd", getDryRunRlblPtyTpCd());
		this.hashColumns.put("inv_otr_rmk", getInvOtrRmk());
		this.hashColumns.put("chss_mgst_tpsz_cd", getChssMgstTpszCd());
		this.hashColumns.put("scl_stop_plc_nod_cd", getSclStopPlcNodCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ovr_wgt_prmt_flg", getOvrWgtPrmtFlg());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("inv_scg_amt", getInvScgAmt());
		this.hashColumns.put("fumg_cost_tp_cd", getFumgCostTpCd());
		this.hashColumns.put("inv_stop_loc_nod_cd", getInvStopLocNodCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("inv_chss_no", getInvChssNo());
		this.hashColumns.put("rf_hndl_flg", getRfHndlFlg());
		this.hashColumns.put("inv_fne_cuz_desc", getInvFneCuzDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_lftg_knt", "invLftgKnt");
		this.hashFields.put("ovr_wgt_otr_flg", "ovrWgtOtrFlg");
		this.hashFields.put("inv_ovr_wgt_otr_flg", "invOvrWgtOtrFlg");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("insp_rf_pti_cstms_tp_cd", "inspRfPtiCstmsTpCd");
		this.hashFields.put("inv_dry_run_rlbl_pty_tp_cd", "invDryRunRlblPtyTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_desc", "n3ptyDesc");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("wt_hrs", "wtHrs");
		this.hashFields.put("lftg_cuz_desc", "lftgCuzDesc");
		this.hashFields.put("otr_rmk", "otrRmk");
		this.hashFields.put("inv_ob_bkg_no", "invObBkgNo");
		this.hashFields.put("inv_ovr_wgt_rmk", "invOvrWgtRmk");
		this.hashFields.put("unique_cd", "uniqueCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("incrt_dt", "incrtDt");
		this.hashFields.put("trsp_agmt_bfr_extd_flg", "trspAgmtBfrExtdFlg");
		this.hashFields.put("n3pty_vndr_seq", "n3ptyVndrSeq");
		this.hashFields.put("inv_chss_mgst_tpsz_cd", "invChssMgstTpszCd");
		this.hashFields.put("inv_wt_hrs", "invWtHrs");
		this.hashFields.put("inv_fumg_cost_tp_cd", "invFumgCostTpCd");
		this.hashFields.put("inv_tri_axl_flg", "invTriAxlFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hjl_no", "hjlNo");
		this.hashFields.put("stop_loc_nod_cd", "stopLocNodCd");
		this.hashFields.put("inv_rf_mgst_usg_flg", "invRfMgstUsgFlg");
		this.hashFields.put("inv_incrt_dt", "invIncrtDt");
		this.hashFields.put("inv_rf_hndl_flg", "invRfHndlFlg");
		this.hashFields.put("ovr_wgt_rmk", "ovrWgtRmk");
		this.hashFields.put("inv_lftg_cuz_desc", "invLftgCuzDesc");
		this.hashFields.put("inv_grs_wgt_meas_ut_cd", "invGrsWgtMeasUtCd");
		this.hashFields.put("incur_dt", "incurDt");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("tri_axl_flg", "triAxlFlg");
		this.hashFields.put("mgst_tpsz_cd", "mgstTpszCd");
		this.hashFields.put("inv_scl_stop_plc_nod_cd", "invSclStopPlcNodCd");
		this.hashFields.put("n3pty_amt", "n3ptyAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lftg_knt", "lftgKnt");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("inv_mgst_tpsz_cd", "invMgstTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sto_dys", "stoDys");
		this.hashFields.put("inv_sto_dys", "invStoDys");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("fne_cuz_desc", "fneCuzDesc");
		this.hashFields.put("ob_bkg_no", "obBkgNo");
		this.hashFields.put("rf_mgst_usg_flg", "rfMgstUsgFlg");
		this.hashFields.put("inv_ovr_wgt_prmt_flg", "invOvrWgtPrmtFlg");
		this.hashFields.put("inv_grs_wgt", "invGrsWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_insp_rf_pti_cstms_tp_cd", "invInspRfPtiCstmsTpCd");
		this.hashFields.put("inv_incur_dt", "invIncurDt");
		this.hashFields.put("wo_grs_wgt_meas_ut_cd", "woGrsWgtMeasUtCd");
		this.hashFields.put("dry_run_rlbl_pty_tp_cd", "dryRunRlblPtyTpCd");
		this.hashFields.put("inv_otr_rmk", "invOtrRmk");
		this.hashFields.put("chss_mgst_tpsz_cd", "chssMgstTpszCd");
		this.hashFields.put("scl_stop_plc_nod_cd", "sclStopPlcNodCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ovr_wgt_prmt_flg", "ovrWgtPrmtFlg");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("inv_scg_amt", "invScgAmt");
		this.hashFields.put("fumg_cost_tp_cd", "fumgCostTpCd");
		this.hashFields.put("inv_stop_loc_nod_cd", "invStopLocNodCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("inv_chss_no", "invChssNo");
		this.hashFields.put("rf_hndl_flg", "rfHndlFlg");
		this.hashFields.put("inv_fne_cuz_desc", "invFneCuzDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invLftgKnt
	 */
	public String getInvLftgKnt() {
		return this.invLftgKnt;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtOtrFlg
	 */
	public String getOvrWgtOtrFlg() {
		return this.ovrWgtOtrFlg;
	}
	
	/**
	 * Column Info
	 * @return invOvrWgtOtrFlg
	 */
	public String getInvOvrWgtOtrFlg() {
		return this.invOvrWgtOtrFlg;
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
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return inspRfPtiCstmsTpCd
	 */
	public String getInspRfPtiCstmsTpCd() {
		return this.inspRfPtiCstmsTpCd;
	}
	
	/**
	 * Column Info
	 * @return invDryRunRlblPtyTpCd
	 */
	public String getInvDryRunRlblPtyTpCd() {
		return this.invDryRunRlblPtyTpCd;
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
	 * @return n3ptyDesc
	 */
	public String getN3ptyDesc() {
		return this.n3ptyDesc;
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
	 * @return wtHrs
	 */
	public String getWtHrs() {
		return this.wtHrs;
	}
	
	/**
	 * Column Info
	 * @return lftgCuzDesc
	 */
	public String getLftgCuzDesc() {
		return this.lftgCuzDesc;
	}
	
	/**
	 * Column Info
	 * @return otrRmk
	 */
	public String getOtrRmk() {
		return this.otrRmk;
	}
	
	/**
	 * Column Info
	 * @return invObBkgNo
	 */
	public String getInvObBkgNo() {
		return this.invObBkgNo;
	}
	
	/**
	 * Column Info
	 * @return invOvrWgtRmk
	 */
	public String getInvOvrWgtRmk() {
		return this.invOvrWgtRmk;
	}
	
	/**
	 * Column Info
	 * @return uniqueCd
	 */
	public String getUniqueCd() {
		return this.uniqueCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return incrtDt
	 */
	public String getIncrtDt() {
		return this.incrtDt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtBfrExtdFlg
	 */
	public String getTrspAgmtBfrExtdFlg() {
		return this.trspAgmtBfrExtdFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyVndrSeq
	 */
	public String getN3ptyVndrSeq() {
		return this.n3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invChssMgstTpszCd
	 */
	public String getInvChssMgstTpszCd() {
		return this.invChssMgstTpszCd;
	}
	
	/**
	 * Column Info
	 * @return invWtHrs
	 */
	public String getInvWtHrs() {
		return this.invWtHrs;
	}
	
	/**
	 * Column Info
	 * @return invFumgCostTpCd
	 */
	public String getInvFumgCostTpCd() {
		return this.invFumgCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return invTriAxlFlg
	 */
	public String getInvTriAxlFlg() {
		return this.invTriAxlFlg;
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
	 * @return hjlNo
	 */
	public String getHjlNo() {
		return this.hjlNo;
	}
	
	/**
	 * Column Info
	 * @return stopLocNodCd
	 */
	public String getStopLocNodCd() {
		return this.stopLocNodCd;
	}
	
	/**
	 * Column Info
	 * @return invRfMgstUsgFlg
	 */
	public String getInvRfMgstUsgFlg() {
		return this.invRfMgstUsgFlg;
	}
	
	/**
	 * Column Info
	 * @return invIncrtDt
	 */
	public String getInvIncrtDt() {
		return this.invIncrtDt;
	}
	
	/**
	 * Column Info
	 * @return invRfHndlFlg
	 */
	public String getInvRfHndlFlg() {
		return this.invRfHndlFlg;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtRmk
	 */
	public String getOvrWgtRmk() {
		return this.ovrWgtRmk;
	}
	
	/**
	 * Column Info
	 * @return invLftgCuzDesc
	 */
	public String getInvLftgCuzDesc() {
		return this.invLftgCuzDesc;
	}
	
	/**
	 * Column Info
	 * @return invGrsWgtMeasUtCd
	 */
	public String getInvGrsWgtMeasUtCd() {
		return this.invGrsWgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return incurDt
	 */
	public String getIncurDt() {
		return this.incurDt;
	}
	
	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return triAxlFlg
	 */
	public String getTriAxlFlg() {
		return this.triAxlFlg;
	}
	
	/**
	 * Column Info
	 * @return mgstTpszCd
	 */
	public String getMgstTpszCd() {
		return this.mgstTpszCd;
	}
	
	/**
	 * Column Info
	 * @return invSclStopPlcNodCd
	 */
	public String getInvSclStopPlcNodCd() {
		return this.invSclStopPlcNodCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyAmt
	 */
	public String getN3ptyAmt() {
		return this.n3ptyAmt;
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
	 * @return lftgKnt
	 */
	public String getLftgKnt() {
		return this.lftgKnt;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return invMgstTpszCd
	 */
	public String getInvMgstTpszCd() {
		return this.invMgstTpszCd;
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
	 * @return stoDys
	 */
	public String getStoDys() {
		return this.stoDys;
	}
	
	/**
	 * Column Info
	 * @return invStoDys
	 */
	public String getInvStoDys() {
		return this.invStoDys;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fneCuzDesc
	 */
	public String getFneCuzDesc() {
		return this.fneCuzDesc;
	}
	
	/**
	 * Column Info
	 * @return obBkgNo
	 */
	public String getObBkgNo() {
		return this.obBkgNo;
	}
	
	/**
	 * Column Info
	 * @return rfMgstUsgFlg
	 */
	public String getRfMgstUsgFlg() {
		return this.rfMgstUsgFlg;
	}
	
	/**
	 * Column Info
	 * @return invOvrWgtPrmtFlg
	 */
	public String getInvOvrWgtPrmtFlg() {
		return this.invOvrWgtPrmtFlg;
	}
	
	/**
	 * Column Info
	 * @return invGrsWgt
	 */
	public String getInvGrsWgt() {
		return this.invGrsWgt;
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
	 * @return invInspRfPtiCstmsTpCd
	 */
	public String getInvInspRfPtiCstmsTpCd() {
		return this.invInspRfPtiCstmsTpCd;
	}
	
	/**
	 * Column Info
	 * @return invIncurDt
	 */
	public String getInvIncurDt() {
		return this.invIncurDt;
	}
	
	/**
	 * Column Info
	 * @return woGrsWgtMeasUtCd
	 */
	public String getWoGrsWgtMeasUtCd() {
		return this.woGrsWgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return dryRunRlblPtyTpCd
	 */
	public String getDryRunRlblPtyTpCd() {
		return this.dryRunRlblPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @return invOtrRmk
	 */
	public String getInvOtrRmk() {
		return this.invOtrRmk;
	}
	
	/**
	 * Column Info
	 * @return chssMgstTpszCd
	 */
	public String getChssMgstTpszCd() {
		return this.chssMgstTpszCd;
	}
	
	/**
	 * Column Info
	 * @return sclStopPlcNodCd
	 */
	public String getSclStopPlcNodCd() {
		return this.sclStopPlcNodCd;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
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
	 * @return ovrWgtPrmtFlg
	 */
	public String getOvrWgtPrmtFlg() {
		return this.ovrWgtPrmtFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @return invScgAmt
	 */
	public String getInvScgAmt() {
		return this.invScgAmt;
	}
	
	/**
	 * Column Info
	 * @return fumgCostTpCd
	 */
	public String getFumgCostTpCd() {
		return this.fumgCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return invStopLocNodCd
	 */
	public String getInvStopLocNodCd() {
		return this.invStopLocNodCd;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return scgAmt
	 */
	public String getScgAmt() {
		return this.scgAmt;
	}
	
	/**
	 * Column Info
	 * @return invChssNo
	 */
	public String getInvChssNo() {
		return this.invChssNo;
	}
	
	/**
	 * Column Info
	 * @return rfHndlFlg
	 */
	public String getRfHndlFlg() {
		return this.rfHndlFlg;
	}
	
	/**
	 * Column Info
	 * @return invFneCuzDesc
	 */
	public String getInvFneCuzDesc() {
		return this.invFneCuzDesc;
	}
	

	/**
	 * Column Info
	 * @param invLftgKnt
	 */
	public void setInvLftgKnt(String invLftgKnt) {
		this.invLftgKnt = invLftgKnt;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtOtrFlg
	 */
	public void setOvrWgtOtrFlg(String ovrWgtOtrFlg) {
		this.ovrWgtOtrFlg = ovrWgtOtrFlg;
	}
	
	/**
	 * Column Info
	 * @param invOvrWgtOtrFlg
	 */
	public void setInvOvrWgtOtrFlg(String invOvrWgtOtrFlg) {
		this.invOvrWgtOtrFlg = invOvrWgtOtrFlg;
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
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param inspRfPtiCstmsTpCd
	 */
	public void setInspRfPtiCstmsTpCd(String inspRfPtiCstmsTpCd) {
		this.inspRfPtiCstmsTpCd = inspRfPtiCstmsTpCd;
	}
	
	/**
	 * Column Info
	 * @param invDryRunRlblPtyTpCd
	 */
	public void setInvDryRunRlblPtyTpCd(String invDryRunRlblPtyTpCd) {
		this.invDryRunRlblPtyTpCd = invDryRunRlblPtyTpCd;
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
	 * @param n3ptyDesc
	 */
	public void setN3ptyDesc(String n3ptyDesc) {
		this.n3ptyDesc = n3ptyDesc;
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
	 * @param wtHrs
	 */
	public void setWtHrs(String wtHrs) {
		this.wtHrs = wtHrs;
	}
	
	/**
	 * Column Info
	 * @param lftgCuzDesc
	 */
	public void setLftgCuzDesc(String lftgCuzDesc) {
		this.lftgCuzDesc = lftgCuzDesc;
	}
	
	/**
	 * Column Info
	 * @param otrRmk
	 */
	public void setOtrRmk(String otrRmk) {
		this.otrRmk = otrRmk;
	}
	
	/**
	 * Column Info
	 * @param invObBkgNo
	 */
	public void setInvObBkgNo(String invObBkgNo) {
		this.invObBkgNo = invObBkgNo;
	}
	
	/**
	 * Column Info
	 * @param invOvrWgtRmk
	 */
	public void setInvOvrWgtRmk(String invOvrWgtRmk) {
		this.invOvrWgtRmk = invOvrWgtRmk;
	}
	
	/**
	 * Column Info
	 * @param uniqueCd
	 */
	public void setUniqueCd(String uniqueCd) {
		this.uniqueCd = uniqueCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param incrtDt
	 */
	public void setIncrtDt(String incrtDt) {
		this.incrtDt = incrtDt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtBfrExtdFlg
	 */
	public void setTrspAgmtBfrExtdFlg(String trspAgmtBfrExtdFlg) {
		this.trspAgmtBfrExtdFlg = trspAgmtBfrExtdFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyVndrSeq
	 */
	public void setN3ptyVndrSeq(String n3ptyVndrSeq) {
		this.n3ptyVndrSeq = n3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invChssMgstTpszCd
	 */
	public void setInvChssMgstTpszCd(String invChssMgstTpszCd) {
		this.invChssMgstTpszCd = invChssMgstTpszCd;
	}
	
	/**
	 * Column Info
	 * @param invWtHrs
	 */
	public void setInvWtHrs(String invWtHrs) {
		this.invWtHrs = invWtHrs;
	}
	
	/**
	 * Column Info
	 * @param invFumgCostTpCd
	 */
	public void setInvFumgCostTpCd(String invFumgCostTpCd) {
		this.invFumgCostTpCd = invFumgCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param invTriAxlFlg
	 */
	public void setInvTriAxlFlg(String invTriAxlFlg) {
		this.invTriAxlFlg = invTriAxlFlg;
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
	 * @param hjlNo
	 */
	public void setHjlNo(String hjlNo) {
		this.hjlNo = hjlNo;
	}
	
	/**
	 * Column Info
	 * @param stopLocNodCd
	 */
	public void setStopLocNodCd(String stopLocNodCd) {
		this.stopLocNodCd = stopLocNodCd;
	}
	
	/**
	 * Column Info
	 * @param invRfMgstUsgFlg
	 */
	public void setInvRfMgstUsgFlg(String invRfMgstUsgFlg) {
		this.invRfMgstUsgFlg = invRfMgstUsgFlg;
	}
	
	/**
	 * Column Info
	 * @param invIncrtDt
	 */
	public void setInvIncrtDt(String invIncrtDt) {
		this.invIncrtDt = invIncrtDt;
	}
	
	/**
	 * Column Info
	 * @param invRfHndlFlg
	 */
	public void setInvRfHndlFlg(String invRfHndlFlg) {
		this.invRfHndlFlg = invRfHndlFlg;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtRmk
	 */
	public void setOvrWgtRmk(String ovrWgtRmk) {
		this.ovrWgtRmk = ovrWgtRmk;
	}
	
	/**
	 * Column Info
	 * @param invLftgCuzDesc
	 */
	public void setInvLftgCuzDesc(String invLftgCuzDesc) {
		this.invLftgCuzDesc = invLftgCuzDesc;
	}
	
	/**
	 * Column Info
	 * @param invGrsWgtMeasUtCd
	 */
	public void setInvGrsWgtMeasUtCd(String invGrsWgtMeasUtCd) {
		this.invGrsWgtMeasUtCd = invGrsWgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param incurDt
	 */
	public void setIncurDt(String incurDt) {
		this.incurDt = incurDt;
	}
	
	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param triAxlFlg
	 */
	public void setTriAxlFlg(String triAxlFlg) {
		this.triAxlFlg = triAxlFlg;
	}
	
	/**
	 * Column Info
	 * @param mgstTpszCd
	 */
	public void setMgstTpszCd(String mgstTpszCd) {
		this.mgstTpszCd = mgstTpszCd;
	}
	
	/**
	 * Column Info
	 * @param invSclStopPlcNodCd
	 */
	public void setInvSclStopPlcNodCd(String invSclStopPlcNodCd) {
		this.invSclStopPlcNodCd = invSclStopPlcNodCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyAmt
	 */
	public void setN3ptyAmt(String n3ptyAmt) {
		this.n3ptyAmt = n3ptyAmt;
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
	 * @param lftgKnt
	 */
	public void setLftgKnt(String lftgKnt) {
		this.lftgKnt = lftgKnt;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param invMgstTpszCd
	 */
	public void setInvMgstTpszCd(String invMgstTpszCd) {
		this.invMgstTpszCd = invMgstTpszCd;
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
	 * @param stoDys
	 */
	public void setStoDys(String stoDys) {
		this.stoDys = stoDys;
	}
	
	/**
	 * Column Info
	 * @param invStoDys
	 */
	public void setInvStoDys(String invStoDys) {
		this.invStoDys = invStoDys;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fneCuzDesc
	 */
	public void setFneCuzDesc(String fneCuzDesc) {
		this.fneCuzDesc = fneCuzDesc;
	}
	
	/**
	 * Column Info
	 * @param obBkgNo
	 */
	public void setObBkgNo(String obBkgNo) {
		this.obBkgNo = obBkgNo;
	}
	
	/**
	 * Column Info
	 * @param rfMgstUsgFlg
	 */
	public void setRfMgstUsgFlg(String rfMgstUsgFlg) {
		this.rfMgstUsgFlg = rfMgstUsgFlg;
	}
	
	/**
	 * Column Info
	 * @param invOvrWgtPrmtFlg
	 */
	public void setInvOvrWgtPrmtFlg(String invOvrWgtPrmtFlg) {
		this.invOvrWgtPrmtFlg = invOvrWgtPrmtFlg;
	}
	
	/**
	 * Column Info
	 * @param invGrsWgt
	 */
	public void setInvGrsWgt(String invGrsWgt) {
		this.invGrsWgt = invGrsWgt;
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
	 * @param invInspRfPtiCstmsTpCd
	 */
	public void setInvInspRfPtiCstmsTpCd(String invInspRfPtiCstmsTpCd) {
		this.invInspRfPtiCstmsTpCd = invInspRfPtiCstmsTpCd;
	}
	
	/**
	 * Column Info
	 * @param invIncurDt
	 */
	public void setInvIncurDt(String invIncurDt) {
		this.invIncurDt = invIncurDt;
	}
	
	/**
	 * Column Info
	 * @param woGrsWgtMeasUtCd
	 */
	public void setWoGrsWgtMeasUtCd(String woGrsWgtMeasUtCd) {
		this.woGrsWgtMeasUtCd = woGrsWgtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param dryRunRlblPtyTpCd
	 */
	public void setDryRunRlblPtyTpCd(String dryRunRlblPtyTpCd) {
		this.dryRunRlblPtyTpCd = dryRunRlblPtyTpCd;
	}
	
	/**
	 * Column Info
	 * @param invOtrRmk
	 */
	public void setInvOtrRmk(String invOtrRmk) {
		this.invOtrRmk = invOtrRmk;
	}
	
	/**
	 * Column Info
	 * @param chssMgstTpszCd
	 */
	public void setChssMgstTpszCd(String chssMgstTpszCd) {
		this.chssMgstTpszCd = chssMgstTpszCd;
	}
	
	/**
	 * Column Info
	 * @param sclStopPlcNodCd
	 */
	public void setSclStopPlcNodCd(String sclStopPlcNodCd) {
		this.sclStopPlcNodCd = sclStopPlcNodCd;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
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
	 * @param ovrWgtPrmtFlg
	 */
	public void setOvrWgtPrmtFlg(String ovrWgtPrmtFlg) {
		this.ovrWgtPrmtFlg = ovrWgtPrmtFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @param invScgAmt
	 */
	public void setInvScgAmt(String invScgAmt) {
		this.invScgAmt = invScgAmt;
	}
	
	/**
	 * Column Info
	 * @param fumgCostTpCd
	 */
	public void setFumgCostTpCd(String fumgCostTpCd) {
		this.fumgCostTpCd = fumgCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param invStopLocNodCd
	 */
	public void setInvStopLocNodCd(String invStopLocNodCd) {
		this.invStopLocNodCd = invStopLocNodCd;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param scgAmt
	 */
	public void setScgAmt(String scgAmt) {
		this.scgAmt = scgAmt;
	}
	
	/**
	 * Column Info
	 * @param invChssNo
	 */
	public void setInvChssNo(String invChssNo) {
		this.invChssNo = invChssNo;
	}
	
	/**
	 * Column Info
	 * @param rfHndlFlg
	 */
	public void setRfHndlFlg(String rfHndlFlg) {
		this.rfHndlFlg = rfHndlFlg;
	}
	
	/**
	 * Column Info
	 * @param invFneCuzDesc
	 */
	public void setInvFneCuzDesc(String invFneCuzDesc) {
		this.invFneCuzDesc = invFneCuzDesc;
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
		setInvLftgKnt(JSPUtil.getParameter(request, prefix + "inv_lftg_knt", ""));
		setOvrWgtOtrFlg(JSPUtil.getParameter(request, prefix + "ovr_wgt_otr_flg", ""));
		setInvOvrWgtOtrFlg(JSPUtil.getParameter(request, prefix + "inv_ovr_wgt_otr_flg", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setInspRfPtiCstmsTpCd(JSPUtil.getParameter(request, prefix + "insp_rf_pti_cstms_tp_cd", ""));
		setInvDryRunRlblPtyTpCd(JSPUtil.getParameter(request, prefix + "inv_dry_run_rlbl_pty_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyDesc(JSPUtil.getParameter(request, prefix + "n3pty_desc", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd", ""));
		setWtHrs(JSPUtil.getParameter(request, prefix + "wt_hrs", ""));
		setLftgCuzDesc(JSPUtil.getParameter(request, prefix + "lftg_cuz_desc", ""));
		setOtrRmk(JSPUtil.getParameter(request, prefix + "otr_rmk", ""));
		setInvObBkgNo(JSPUtil.getParameter(request, prefix + "inv_ob_bkg_no", ""));
		setInvOvrWgtRmk(JSPUtil.getParameter(request, prefix + "inv_ovr_wgt_rmk", ""));
		setUniqueCd(JSPUtil.getParameter(request, prefix + "unique_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setIncrtDt(JSPUtil.getParameter(request, prefix + "incrt_dt", ""));
		setTrspAgmtBfrExtdFlg(JSPUtil.getParameter(request, prefix + "trsp_agmt_bfr_extd_flg", ""));
		setN3ptyVndrSeq(JSPUtil.getParameter(request, prefix + "n3pty_vndr_seq", ""));
		setInvChssMgstTpszCd(JSPUtil.getParameter(request, prefix + "inv_chss_mgst_tpsz_cd", ""));
		setInvWtHrs(JSPUtil.getParameter(request, prefix + "inv_wt_hrs", ""));
		setInvFumgCostTpCd(JSPUtil.getParameter(request, prefix + "inv_fumg_cost_tp_cd", ""));
		setInvTriAxlFlg(JSPUtil.getParameter(request, prefix + "inv_tri_axl_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHjlNo(JSPUtil.getParameter(request, prefix + "hjl_no", ""));
		setStopLocNodCd(JSPUtil.getParameter(request, prefix + "stop_loc_nod_cd", ""));
		setInvRfMgstUsgFlg(JSPUtil.getParameter(request, prefix + "inv_rf_mgst_usg_flg", ""));
		setInvIncrtDt(JSPUtil.getParameter(request, prefix + "inv_incrt_dt", ""));
		setInvRfHndlFlg(JSPUtil.getParameter(request, prefix + "inv_rf_hndl_flg", ""));
		setOvrWgtRmk(JSPUtil.getParameter(request, prefix + "ovr_wgt_rmk", ""));
		setInvLftgCuzDesc(JSPUtil.getParameter(request, prefix + "inv_lftg_cuz_desc", ""));
		setInvGrsWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "inv_grs_wgt_meas_ut_cd", ""));
		setIncurDt(JSPUtil.getParameter(request, prefix + "incur_dt", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setTriAxlFlg(JSPUtil.getParameter(request, prefix + "tri_axl_flg", ""));
		setMgstTpszCd(JSPUtil.getParameter(request, prefix + "mgst_tpsz_cd", ""));
		setInvSclStopPlcNodCd(JSPUtil.getParameter(request, prefix + "inv_scl_stop_plc_nod_cd", ""));
		setN3ptyAmt(JSPUtil.getParameter(request, prefix + "n3pty_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLftgKnt(JSPUtil.getParameter(request, prefix + "lftg_knt", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setInvMgstTpszCd(JSPUtil.getParameter(request, prefix + "inv_mgst_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStoDys(JSPUtil.getParameter(request, prefix + "sto_dys", ""));
		setInvStoDys(JSPUtil.getParameter(request, prefix + "inv_sto_dys", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setFneCuzDesc(JSPUtil.getParameter(request, prefix + "fne_cuz_desc", ""));
		setObBkgNo(JSPUtil.getParameter(request, prefix + "ob_bkg_no", ""));
		setRfMgstUsgFlg(JSPUtil.getParameter(request, prefix + "rf_mgst_usg_flg", ""));
		setInvOvrWgtPrmtFlg(JSPUtil.getParameter(request, prefix + "inv_ovr_wgt_prmt_flg", ""));
		setInvGrsWgt(JSPUtil.getParameter(request, prefix + "inv_grs_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setInvInspRfPtiCstmsTpCd(JSPUtil.getParameter(request, prefix + "inv_insp_rf_pti_cstms_tp_cd", ""));
		setInvIncurDt(JSPUtil.getParameter(request, prefix + "inv_incur_dt", ""));
		setWoGrsWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wo_grs_wgt_meas_ut_cd", ""));
		setDryRunRlblPtyTpCd(JSPUtil.getParameter(request, prefix + "dry_run_rlbl_pty_tp_cd", ""));
		setInvOtrRmk(JSPUtil.getParameter(request, prefix + "inv_otr_rmk", ""));
		setChssMgstTpszCd(JSPUtil.getParameter(request, prefix + "chss_mgst_tpsz_cd", ""));
		setSclStopPlcNodCd(JSPUtil.getParameter(request, prefix + "scl_stop_plc_nod_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOvrWgtPrmtFlg(JSPUtil.getParameter(request, prefix + "ovr_wgt_prmt_flg", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setInvScgAmt(JSPUtil.getParameter(request, prefix + "inv_scg_amt", ""));
		setFumgCostTpCd(JSPUtil.getParameter(request, prefix + "fumg_cost_tp_cd", ""));
		setInvStopLocNodCd(JSPUtil.getParameter(request, prefix + "inv_stop_loc_nod_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setScgAmt(JSPUtil.getParameter(request, prefix + "scg_amt", ""));
		setInvChssNo(JSPUtil.getParameter(request, prefix + "inv_chss_no", ""));
		setRfHndlFlg(JSPUtil.getParameter(request, prefix + "rf_hndl_flg", ""));
		setInvFneCuzDesc(JSPUtil.getParameter(request, prefix + "inv_fne_cuz_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SurchargeVO[]
	 */
	public SurchargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SurchargeVO[]
	 */
	public SurchargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SurchargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invLftgKnt = (JSPUtil.getParameter(request, prefix	+ "inv_lftg_knt", length));
			String[] ovrWgtOtrFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_otr_flg", length));
			String[] invOvrWgtOtrFlg = (JSPUtil.getParameter(request, prefix	+ "inv_ovr_wgt_otr_flg", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] inspRfPtiCstmsTpCd = (JSPUtil.getParameter(request, prefix	+ "insp_rf_pti_cstms_tp_cd", length));
			String[] invDryRunRlblPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_dry_run_rlbl_pty_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyDesc = (JSPUtil.getParameter(request, prefix	+ "n3pty_desc", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] wtHrs = (JSPUtil.getParameter(request, prefix	+ "wt_hrs", length));
			String[] lftgCuzDesc = (JSPUtil.getParameter(request, prefix	+ "lftg_cuz_desc", length));
			String[] otrRmk = (JSPUtil.getParameter(request, prefix	+ "otr_rmk", length));
			String[] invObBkgNo = (JSPUtil.getParameter(request, prefix	+ "inv_ob_bkg_no", length));
			String[] invOvrWgtRmk = (JSPUtil.getParameter(request, prefix	+ "inv_ovr_wgt_rmk", length));
			String[] uniqueCd = (JSPUtil.getParameter(request, prefix	+ "unique_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] incrtDt = (JSPUtil.getParameter(request, prefix	+ "incrt_dt", length));
			String[] trspAgmtBfrExtdFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_bfr_extd_flg", length));
			String[] n3ptyVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_vndr_seq", length));
			String[] invChssMgstTpszCd = (JSPUtil.getParameter(request, prefix	+ "inv_chss_mgst_tpsz_cd", length));
			String[] invWtHrs = (JSPUtil.getParameter(request, prefix	+ "inv_wt_hrs", length));
			String[] invFumgCostTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_fumg_cost_tp_cd", length));
			String[] invTriAxlFlg = (JSPUtil.getParameter(request, prefix	+ "inv_tri_axl_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hjlNo = (JSPUtil.getParameter(request, prefix	+ "hjl_no", length));
			String[] stopLocNodCd = (JSPUtil.getParameter(request, prefix	+ "stop_loc_nod_cd", length));
			String[] invRfMgstUsgFlg = (JSPUtil.getParameter(request, prefix	+ "inv_rf_mgst_usg_flg", length));
			String[] invIncrtDt = (JSPUtil.getParameter(request, prefix	+ "inv_incrt_dt", length));
			String[] invRfHndlFlg = (JSPUtil.getParameter(request, prefix	+ "inv_rf_hndl_flg", length));
			String[] ovrWgtRmk = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_rmk", length));
			String[] invLftgCuzDesc = (JSPUtil.getParameter(request, prefix	+ "inv_lftg_cuz_desc", length));
			String[] invGrsWgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "inv_grs_wgt_meas_ut_cd", length));
			String[] incurDt = (JSPUtil.getParameter(request, prefix	+ "incur_dt", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] triAxlFlg = (JSPUtil.getParameter(request, prefix	+ "tri_axl_flg", length));
			String[] mgstTpszCd = (JSPUtil.getParameter(request, prefix	+ "mgst_tpsz_cd", length));
			String[] invSclStopPlcNodCd = (JSPUtil.getParameter(request, prefix	+ "inv_scl_stop_plc_nod_cd", length));
			String[] n3ptyAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lftgKnt = (JSPUtil.getParameter(request, prefix	+ "lftg_knt", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] invMgstTpszCd = (JSPUtil.getParameter(request, prefix	+ "inv_mgst_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stoDys = (JSPUtil.getParameter(request, prefix	+ "sto_dys", length));
			String[] invStoDys = (JSPUtil.getParameter(request, prefix	+ "inv_sto_dys", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] fneCuzDesc = (JSPUtil.getParameter(request, prefix	+ "fne_cuz_desc", length));
			String[] obBkgNo = (JSPUtil.getParameter(request, prefix	+ "ob_bkg_no", length));
			String[] rfMgstUsgFlg = (JSPUtil.getParameter(request, prefix	+ "rf_mgst_usg_flg", length));
			String[] invOvrWgtPrmtFlg = (JSPUtil.getParameter(request, prefix	+ "inv_ovr_wgt_prmt_flg", length));
			String[] invGrsWgt = (JSPUtil.getParameter(request, prefix	+ "inv_grs_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invInspRfPtiCstmsTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_insp_rf_pti_cstms_tp_cd", length));
			String[] invIncurDt = (JSPUtil.getParameter(request, prefix	+ "inv_incur_dt", length));
			String[] woGrsWgtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "wo_grs_wgt_meas_ut_cd", length));
			String[] dryRunRlblPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "dry_run_rlbl_pty_tp_cd", length));
			String[] invOtrRmk = (JSPUtil.getParameter(request, prefix	+ "inv_otr_rmk", length));
			String[] chssMgstTpszCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_tpsz_cd", length));
			String[] sclStopPlcNodCd = (JSPUtil.getParameter(request, prefix	+ "scl_stop_plc_nod_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ovrWgtPrmtFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_prmt_flg", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] invScgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_scg_amt", length));
			String[] fumgCostTpCd = (JSPUtil.getParameter(request, prefix	+ "fumg_cost_tp_cd", length));
			String[] invStopLocNodCd = (JSPUtil.getParameter(request, prefix	+ "inv_stop_loc_nod_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] scgAmt = (JSPUtil.getParameter(request, prefix	+ "scg_amt", length));
			String[] invChssNo = (JSPUtil.getParameter(request, prefix	+ "inv_chss_no", length));
			String[] rfHndlFlg = (JSPUtil.getParameter(request, prefix	+ "rf_hndl_flg", length));
			String[] invFneCuzDesc = (JSPUtil.getParameter(request, prefix	+ "inv_fne_cuz_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SurchargeVO();
				if (invLftgKnt[i] != null)
					model.setInvLftgKnt(invLftgKnt[i]);
				if (ovrWgtOtrFlg[i] != null)
					model.setOvrWgtOtrFlg(ovrWgtOtrFlg[i]);
				if (invOvrWgtOtrFlg[i] != null)
					model.setInvOvrWgtOtrFlg(invOvrWgtOtrFlg[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (inspRfPtiCstmsTpCd[i] != null)
					model.setInspRfPtiCstmsTpCd(inspRfPtiCstmsTpCd[i]);
				if (invDryRunRlblPtyTpCd[i] != null)
					model.setInvDryRunRlblPtyTpCd(invDryRunRlblPtyTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyDesc[i] != null)
					model.setN3ptyDesc(n3ptyDesc[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (wtHrs[i] != null)
					model.setWtHrs(wtHrs[i]);
				if (lftgCuzDesc[i] != null)
					model.setLftgCuzDesc(lftgCuzDesc[i]);
				if (otrRmk[i] != null)
					model.setOtrRmk(otrRmk[i]);
				if (invObBkgNo[i] != null)
					model.setInvObBkgNo(invObBkgNo[i]);
				if (invOvrWgtRmk[i] != null)
					model.setInvOvrWgtRmk(invOvrWgtRmk[i]);
				if (uniqueCd[i] != null)
					model.setUniqueCd(uniqueCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (incrtDt[i] != null)
					model.setIncrtDt(incrtDt[i]);
				if (trspAgmtBfrExtdFlg[i] != null)
					model.setTrspAgmtBfrExtdFlg(trspAgmtBfrExtdFlg[i]);
				if (n3ptyVndrSeq[i] != null)
					model.setN3ptyVndrSeq(n3ptyVndrSeq[i]);
				if (invChssMgstTpszCd[i] != null)
					model.setInvChssMgstTpszCd(invChssMgstTpszCd[i]);
				if (invWtHrs[i] != null)
					model.setInvWtHrs(invWtHrs[i]);
				if (invFumgCostTpCd[i] != null)
					model.setInvFumgCostTpCd(invFumgCostTpCd[i]);
				if (invTriAxlFlg[i] != null)
					model.setInvTriAxlFlg(invTriAxlFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hjlNo[i] != null)
					model.setHjlNo(hjlNo[i]);
				if (stopLocNodCd[i] != null)
					model.setStopLocNodCd(stopLocNodCd[i]);
				if (invRfMgstUsgFlg[i] != null)
					model.setInvRfMgstUsgFlg(invRfMgstUsgFlg[i]);
				if (invIncrtDt[i] != null)
					model.setInvIncrtDt(invIncrtDt[i]);
				if (invRfHndlFlg[i] != null)
					model.setInvRfHndlFlg(invRfHndlFlg[i]);
				if (ovrWgtRmk[i] != null)
					model.setOvrWgtRmk(ovrWgtRmk[i]);
				if (invLftgCuzDesc[i] != null)
					model.setInvLftgCuzDesc(invLftgCuzDesc[i]);
				if (invGrsWgtMeasUtCd[i] != null)
					model.setInvGrsWgtMeasUtCd(invGrsWgtMeasUtCd[i]);
				if (incurDt[i] != null)
					model.setIncurDt(incurDt[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (triAxlFlg[i] != null)
					model.setTriAxlFlg(triAxlFlg[i]);
				if (mgstTpszCd[i] != null)
					model.setMgstTpszCd(mgstTpszCd[i]);
				if (invSclStopPlcNodCd[i] != null)
					model.setInvSclStopPlcNodCd(invSclStopPlcNodCd[i]);
				if (n3ptyAmt[i] != null)
					model.setN3ptyAmt(n3ptyAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lftgKnt[i] != null)
					model.setLftgKnt(lftgKnt[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (invMgstTpszCd[i] != null)
					model.setInvMgstTpszCd(invMgstTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stoDys[i] != null)
					model.setStoDys(stoDys[i]);
				if (invStoDys[i] != null)
					model.setInvStoDys(invStoDys[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (fneCuzDesc[i] != null)
					model.setFneCuzDesc(fneCuzDesc[i]);
				if (obBkgNo[i] != null)
					model.setObBkgNo(obBkgNo[i]);
				if (rfMgstUsgFlg[i] != null)
					model.setRfMgstUsgFlg(rfMgstUsgFlg[i]);
				if (invOvrWgtPrmtFlg[i] != null)
					model.setInvOvrWgtPrmtFlg(invOvrWgtPrmtFlg[i]);
				if (invGrsWgt[i] != null)
					model.setInvGrsWgt(invGrsWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invInspRfPtiCstmsTpCd[i] != null)
					model.setInvInspRfPtiCstmsTpCd(invInspRfPtiCstmsTpCd[i]);
				if (invIncurDt[i] != null)
					model.setInvIncurDt(invIncurDt[i]);
				if (woGrsWgtMeasUtCd[i] != null)
					model.setWoGrsWgtMeasUtCd(woGrsWgtMeasUtCd[i]);
				if (dryRunRlblPtyTpCd[i] != null)
					model.setDryRunRlblPtyTpCd(dryRunRlblPtyTpCd[i]);
				if (invOtrRmk[i] != null)
					model.setInvOtrRmk(invOtrRmk[i]);
				if (chssMgstTpszCd[i] != null)
					model.setChssMgstTpszCd(chssMgstTpszCd[i]);
				if (sclStopPlcNodCd[i] != null)
					model.setSclStopPlcNodCd(sclStopPlcNodCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ovrWgtPrmtFlg[i] != null)
					model.setOvrWgtPrmtFlg(ovrWgtPrmtFlg[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (invScgAmt[i] != null)
					model.setInvScgAmt(invScgAmt[i]);
				if (fumgCostTpCd[i] != null)
					model.setFumgCostTpCd(fumgCostTpCd[i]);
				if (invStopLocNodCd[i] != null)
					model.setInvStopLocNodCd(invStopLocNodCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (scgAmt[i] != null)
					model.setScgAmt(scgAmt[i]);
				if (invChssNo[i] != null)
					model.setInvChssNo(invChssNo[i]);
				if (rfHndlFlg[i] != null)
					model.setRfHndlFlg(rfHndlFlg[i]);
				if (invFneCuzDesc[i] != null)
					model.setInvFneCuzDesc(invFneCuzDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSurchargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SurchargeVO[]
	 */
	public SurchargeVO[] getSurchargeVOs(){
		SurchargeVO[] vos = (SurchargeVO[])models.toArray(new SurchargeVO[models.size()]);
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
		this.invLftgKnt = this.invLftgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtOtrFlg = this.ovrWgtOtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOvrWgtOtrFlg = this.invOvrWgtOtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inspRfPtiCstmsTpCd = this.inspRfPtiCstmsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDryRunRlblPtyTpCd = this.invDryRunRlblPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyDesc = this.n3ptyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtHrs = this.wtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftgCuzDesc = this.lftgCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrRmk = this.otrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invObBkgNo = this.invObBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOvrWgtRmk = this.invOvrWgtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uniqueCd = this.uniqueCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incrtDt = this.incrtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtBfrExtdFlg = this.trspAgmtBfrExtdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyVndrSeq = this.n3ptyVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChssMgstTpszCd = this.invChssMgstTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invWtHrs = this.invWtHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFumgCostTpCd = this.invFumgCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTriAxlFlg = this.invTriAxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlNo = this.hjlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopLocNodCd = this.stopLocNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRfMgstUsgFlg = this.invRfMgstUsgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIncrtDt = this.invIncrtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRfHndlFlg = this.invRfHndlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtRmk = this.ovrWgtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLftgCuzDesc = this.invLftgCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invGrsWgtMeasUtCd = this.invGrsWgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incurDt = this.incurDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAxlFlg = this.triAxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstTpszCd = this.mgstTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSclStopPlcNodCd = this.invSclStopPlcNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyAmt = this.n3ptyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftgKnt = this.lftgKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMgstTpszCd = this.invMgstTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDys = this.stoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStoDys = this.invStoDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fneCuzDesc = this.fneCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obBkgNo = this.obBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMgstUsgFlg = this.rfMgstUsgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOvrWgtPrmtFlg = this.invOvrWgtPrmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invGrsWgt = this.invGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invInspRfPtiCstmsTpCd = this.invInspRfPtiCstmsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIncurDt = this.invIncurDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woGrsWgtMeasUtCd = this.woGrsWgtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryRunRlblPtyTpCd = this.dryRunRlblPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOtrRmk = this.invOtrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstTpszCd = this.chssMgstTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sclStopPlcNodCd = this.sclStopPlcNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtPrmtFlg = this.ovrWgtPrmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invScgAmt = this.invScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgCostTpCd = this.fumgCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStopLocNodCd = this.invStopLocNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt = this.scgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invChssNo = this.invChssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHndlFlg = this.rfHndlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFneCuzDesc = this.invFneCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
