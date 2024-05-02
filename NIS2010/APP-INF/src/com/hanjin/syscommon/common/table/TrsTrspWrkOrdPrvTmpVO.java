/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrsTrspWrkOrdPrvTmpVO.java
*@FileTitle : TrsTrspWrkOrdPrvTmpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.23 DONG- IL, SHIN 
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
 * @author DONG- IL, SHIN
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsTrspWrkOrdPrvTmpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsTrspWrkOrdPrvTmpVO> models = new ArrayList<TrsTrspWrkOrdPrvTmpVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String dtnUseFlg = null;
	/* Column Info */
	private String woCxlFlg = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String fdrSkdVoyNo = null;
	/* Column Info */
	private String usdTtlAmt = null;
	/* Column Info */
	private String trspAgmtRtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyDesc = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String dorPstCd = null;
	/* Column Info */
	private String cntcPsonFaxNo = null;
	/* Column Info */
	private String hjlVndrSeq = null;
	/* Column Info */
	private String hjlN3ptyDesc = null;
	/* Column Info */
	private String woIssKnt = null;
	/* Column Info */
	private String fdrVslCd = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String dorNodPlnDt = null;
	/* Column Info */
	private String trspFrstFlg = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String trspAgmtRtSeq = null;
	/* Column Info */
	private String woFmtTpCd = null;
	/* Column Info */
	private String woBlNoIssFlg = null;
	/* Column Info */
	private String tollFeeAmt = null;
	/* Column Info */
	private String hjlEtcAddAmt = null;
	/* Column Info */
	private String hjlBzcAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String n3ptyVndrSeq = null;
	/* Column Info */
	private String trspSoCmbTpCd = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String trspDfltVndrFlg = null;
	/* Column Info */
	private String trspAgmtCfmFlg = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hjlN3ptyCustSeq = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String hjlUsdTtlAmt = null;
	/* Column Info */
	private String hjlN3ptyBilTpCd = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String scgVatAmt = null;
	/* Column Info */
	private String n3ptyBilBzcAmt = null;
	/* Column Info */
	private String n3ptyCurrCd = null;
	/* Column Info */
	private String n3ptyCustSeq = null;
	/* Column Info */
	private String trspAgmtUpdDt = null;
	/* Column Info */
	private String fdrSkdDirCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String woIssStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String agmtMorCnddtAplyFlg = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String n3ptyCustCntCd = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String hjlN3ptyBilFlg = null;
	/* Column Info */
	private String hjlN3ptyVndrSeq = null;
	/* Column Info */
	private String hjlN3ptyOfcCd = null;
	/* Column Info */
	private String ovrWgtScgAmt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String hjlCurrCd = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hjlNegoAmt = null;
	/* Column Info */
	private String hjlN3ptyBilBzcAmt = null;
	/* Column Info */
	private String trspAgmtWyTpCd = null;
	/* Column Info */
	private String trspRjctRsnCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String lstNodPlnDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String hjlFuelScgAmt = null;
	/* Column Info */
	private String woIssNo = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String trspSoNo = null;
	/* Column Info */
	private String n1stNodPlnDt = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String woPrvGrpSeq = null;
	/* Column Info */
	private String hjlN3ptyCustCntCd = null;
	/* Column Info */
	private String custNomiTrkrFlg = null;
	/* Column Info */
	private String negoRmk = null;
	/* Column Info */
	private String glineNegoAmt = null;
	/* Column Info */
	private String glineUsdTtlAmt = null;
	/* Column Info */
	private String glineBzcAmt = null;
	/* Column Info */
	private String glineScgVatAmt = null;
	/* Column Info */
	private String glineFuelScgAmt = null;
	/* Column Info */
	private String glineTollFeeAmt = null;
	/* Column Info */
	private String glineEtcAddAmt = null;
	/* Column Info */
	private String glineCurrCd = null;
	/* Column Info */
	private String glineVndrSeq = null;
	/* Column Info */
	private String glineTtlAmt = null;
	/* Column Info */
	private String custNomiTrkrIndCd = null;
	/* Column Info */
	private String trspSpCngRsnCd = null;
	/* Column Info */
	private String trspSpCngRsnRmk = null;
	/* Column Info */
	private String vgmFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrsTrspWrkOrdPrvTmpVO() {}

	public TrsTrspWrkOrdPrvTmpVO(String ibflag, String pagerows, String toNodCd, String dtnUseFlg, String woCxlFlg, String trspSoSeq, String cgoTpCd, String fdrSkdVoyNo, String usdTtlAmt, String trspAgmtRtTpCd, String n3ptyDesc, String n3ptyOfcCd, String dorPstCd, String hjlN3ptyDesc, String hjlVndrSeq, String cntcPsonFaxNo, String n3ptyBilTpCd, String fdrVslCd, String woIssKnt, String trspCostDtlModCd, String trspFrstFlg, String dorNodPlnDt, String woFmtTpCd, String woBlNoIssFlg, String hjlEtcAddAmt, String hjlBzcAmt, String updUsrId, String custCntCd, String n3ptyVndrSeq, String trspSoCmbTpCd, String trspWoSeq, String trspDfltVndrFlg, String cntcPsonPhnNo, String negoAmt, String creUsrId, String hjlN3ptyCustSeq, String fctryNm, String trspAgmtSeq, String vndrSeq, String hjlUsdTtlAmt, String hjlN3ptyBilTpCd, String loclUpdDt, String currCd, String creDt, String trspAgmtOfcCtyCd, String scgVatAmt, String n3ptyBilBzcAmt, String n3ptyCurrCd, String n3ptyCustSeq, String fdrSkdDirCd, String trspSoOfcCtyCd, String woIssStsCd, String interRmk, String cntcPsonNm, String creOfcCd, String dorNodCd, String trspSoStsCd, String n3ptyCustCntCd, String hjlN3ptyOfcCd, String hjlN3ptyVndrSeq, String hjlN3ptyBilFlg, String spclInstrRmk, String trspCrrModCd, String ovrWgtScgAmt, String hjlCurrCd, String updDt, String etcAddAmt, String hjlN3ptyBilBzcAmt, String hjlNegoAmt, String trspAgmtWyTpCd, String loclCreDt, String trspRjctRsnCd, String lstNodPlnDt, String hjlFuelScgAmt, String bzcAmt, String custSeq, String woIssNo, String trspWoOfcCtyCd, String fuelScgAmt, String fmNodCd, String n3ptyBilFlg, String n1stNodPlnDt, String viaNodCd, String hjlN3ptyCustCntCd, String woPrvGrpSeq, String custNomiTrkrFlg, String wtrRcvTermCd, String wtrDeTermCd, String trspSoNo, String trspAgmtCfmFlg, String trspAgmtRtSeq, String trspAgmtUpdDt, String agmtMorCnddtAplyFlg, String tollFeeAmt, String negoRmk, String glineNegoAmt, String glineUsdTtlAmt, String glineBzcAmt, String glineScgVatAmt, String glineFuelScgAmt, String glineTollFeeAmt, String glineEtcAddAmt, String glineCurrCd, String glineVndrSeq, String glineTtlAmt, String custNomiTrkrIndCd, String trspSpCngRsnCd, String trspSpCngRsnRmk, String vgmFlg) {
		this.toNodCd = toNodCd;
		this.dtnUseFlg = dtnUseFlg;
		this.woCxlFlg = woCxlFlg;
		this.trspSoSeq = trspSoSeq;
		this.cgoTpCd = cgoTpCd;
		this.fdrSkdVoyNo = fdrSkdVoyNo;
		this.usdTtlAmt = usdTtlAmt;
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
		this.pagerows = pagerows;
		this.n3ptyDesc = n3ptyDesc;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.dorPstCd = dorPstCd;
		this.cntcPsonFaxNo = cntcPsonFaxNo;
		this.hjlVndrSeq = hjlVndrSeq;
		this.hjlN3ptyDesc = hjlN3ptyDesc;
		this.woIssKnt = woIssKnt;
		this.fdrVslCd = fdrVslCd;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.dorNodPlnDt = dorNodPlnDt;
		this.trspFrstFlg = trspFrstFlg;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.trspAgmtRtSeq = trspAgmtRtSeq;
		this.woFmtTpCd = woFmtTpCd;
		this.woBlNoIssFlg = woBlNoIssFlg;
		this.tollFeeAmt = tollFeeAmt;
		this.hjlEtcAddAmt = hjlEtcAddAmt;
		this.hjlBzcAmt = hjlBzcAmt;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.n3ptyVndrSeq = n3ptyVndrSeq;
		this.trspSoCmbTpCd = trspSoCmbTpCd;
		this.trspWoSeq = trspWoSeq;
		this.trspDfltVndrFlg = trspDfltVndrFlg;
		this.trspAgmtCfmFlg = trspAgmtCfmFlg;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.negoAmt = negoAmt;
		this.creUsrId = creUsrId;
		this.hjlN3ptyCustSeq = hjlN3ptyCustSeq;
		this.fctryNm = fctryNm;
		this.trspAgmtSeq = trspAgmtSeq;
		this.vndrSeq = vndrSeq;
		this.hjlUsdTtlAmt = hjlUsdTtlAmt;
		this.hjlN3ptyBilTpCd = hjlN3ptyBilTpCd;
		this.loclUpdDt = loclUpdDt;
		this.currCd = currCd;
		this.creDt = creDt;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.scgVatAmt = scgVatAmt;
		this.n3ptyBilBzcAmt = n3ptyBilBzcAmt;
		this.n3ptyCurrCd = n3ptyCurrCd;
		this.n3ptyCustSeq = n3ptyCustSeq;
		this.trspAgmtUpdDt = trspAgmtUpdDt;
		this.fdrSkdDirCd = fdrSkdDirCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.woIssStsCd = woIssStsCd;
		this.ibflag = ibflag;
		this.interRmk = interRmk;
		this.agmtMorCnddtAplyFlg = agmtMorCnddtAplyFlg;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.creOfcCd = creOfcCd;
		this.cntcPsonNm = cntcPsonNm;
		this.dorNodCd = dorNodCd;
		this.wtrDeTermCd = wtrDeTermCd;
		this.n3ptyCustCntCd = n3ptyCustCntCd;
		this.trspSoStsCd = trspSoStsCd;
		this.spclInstrRmk = spclInstrRmk;
		this.hjlN3ptyBilFlg = hjlN3ptyBilFlg;
		this.hjlN3ptyVndrSeq = hjlN3ptyVndrSeq;
		this.hjlN3ptyOfcCd = hjlN3ptyOfcCd;
		this.ovrWgtScgAmt = ovrWgtScgAmt;
		this.trspCrrModCd = trspCrrModCd;
		this.hjlCurrCd = hjlCurrCd;
		this.etcAddAmt = etcAddAmt;
		this.updDt = updDt;
		this.hjlNegoAmt = hjlNegoAmt;
		this.hjlN3ptyBilBzcAmt = hjlN3ptyBilBzcAmt;
		this.trspAgmtWyTpCd = trspAgmtWyTpCd;
		this.trspRjctRsnCd = trspRjctRsnCd;
		this.loclCreDt = loclCreDt;
		this.lstNodPlnDt = lstNodPlnDt;
		this.custSeq = custSeq;
		this.bzcAmt = bzcAmt;
		this.hjlFuelScgAmt = hjlFuelScgAmt;
		this.woIssNo = woIssNo;
		this.fuelScgAmt = fuelScgAmt;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.fmNodCd = fmNodCd;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.trspSoNo = trspSoNo;
		this.n1stNodPlnDt = n1stNodPlnDt;
		this.viaNodCd = viaNodCd;
		this.woPrvGrpSeq = woPrvGrpSeq;
		this.hjlN3ptyCustCntCd = hjlN3ptyCustCntCd;
		this.custNomiTrkrFlg = custNomiTrkrFlg;
		this.negoRmk = negoRmk;
		this.glineNegoAmt = glineNegoAmt;
		this.glineUsdTtlAmt = glineUsdTtlAmt;
		this.glineBzcAmt = glineBzcAmt;
		this.glineScgVatAmt = glineScgVatAmt;
		this.glineFuelScgAmt = glineFuelScgAmt;
		this.glineTollFeeAmt = glineTollFeeAmt;
		this.glineEtcAddAmt = glineEtcAddAmt;
		this.glineCurrCd = glineCurrCd;
		this.glineVndrSeq = glineVndrSeq;
		this.glineTtlAmt = glineTtlAmt;
		this.custNomiTrkrIndCd = custNomiTrkrIndCd;
		this.trspSpCngRsnCd = trspSpCngRsnCd;
		this.trspSpCngRsnRmk = trspSpCngRsnRmk;
		this.vgmFlg = vgmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("dtn_use_flg", getDtnUseFlg());
		this.hashColumns.put("wo_cxl_flg", getWoCxlFlg());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("fdr_skd_voy_no", getFdrSkdVoyNo());
		this.hashColumns.put("usd_ttl_amt", getUsdTtlAmt());
		this.hashColumns.put("trsp_agmt_rt_tp_cd", getTrspAgmtRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_desc", getN3ptyDesc());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("dor_pst_cd", getDorPstCd());
		this.hashColumns.put("cntc_pson_fax_no", getCntcPsonFaxNo());
		this.hashColumns.put("hjl_vndr_seq", getHjlVndrSeq());
		this.hashColumns.put("hjl_n3pty_desc", getHjlN3ptyDesc());
		this.hashColumns.put("wo_iss_knt", getWoIssKnt());
		this.hashColumns.put("fdr_vsl_cd", getFdrVslCd());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("dor_nod_pln_dt", getDorNodPlnDt());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("trsp_agmt_rt_seq", getTrspAgmtRtSeq());
		this.hashColumns.put("wo_fmt_tp_cd", getWoFmtTpCd());
		this.hashColumns.put("wo_bl_no_iss_flg", getWoBlNoIssFlg());
		this.hashColumns.put("toll_fee_amt", getTollFeeAmt());
		this.hashColumns.put("hjl_etc_add_amt", getHjlEtcAddAmt());
		this.hashColumns.put("hjl_bzc_amt", getHjlBzcAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("n3pty_vndr_seq", getN3ptyVndrSeq());
		this.hashColumns.put("trsp_so_cmb_tp_cd", getTrspSoCmbTpCd());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trsp_dflt_vndr_flg", getTrspDfltVndrFlg());
		this.hashColumns.put("trsp_agmt_cfm_flg", getTrspAgmtCfmFlg());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hjl_n3pty_cust_seq", getHjlN3ptyCustSeq());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("hjl_usd_ttl_amt", getHjlUsdTtlAmt());
		this.hashColumns.put("hjl_n3pty_bil_tp_cd", getHjlN3ptyBilTpCd());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("scg_vat_amt", getScgVatAmt());
		this.hashColumns.put("n3pty_bil_bzc_amt", getN3ptyBilBzcAmt());
		this.hashColumns.put("n3pty_curr_cd", getN3ptyCurrCd());
		this.hashColumns.put("n3pty_cust_seq", getN3ptyCustSeq());
		this.hashColumns.put("trsp_agmt_upd_dt", getTrspAgmtUpdDt());
		this.hashColumns.put("fdr_skd_dir_cd", getFdrSkdDirCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("wo_iss_sts_cd", getWoIssStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("agmt_mor_cnddt_aply_flg", getAgmtMorCnddtAplyFlg());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("n3pty_cust_cnt_cd", getN3ptyCustCntCd());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("hjl_n3pty_bil_flg", getHjlN3ptyBilFlg());
		this.hashColumns.put("hjl_n3pty_vndr_seq", getHjlN3ptyVndrSeq());
		this.hashColumns.put("hjl_n3pty_ofc_cd", getHjlN3ptyOfcCd());
		this.hashColumns.put("ovr_wgt_scg_amt", getOvrWgtScgAmt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("hjl_curr_cd", getHjlCurrCd());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hjl_nego_amt", getHjlNegoAmt());
		this.hashColumns.put("hjl_n3pty_bil_bzc_amt", getHjlN3ptyBilBzcAmt());
		this.hashColumns.put("trsp_agmt_wy_tp_cd", getTrspAgmtWyTpCd());
		this.hashColumns.put("trsp_rjct_rsn_cd", getTrspRjctRsnCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("hjl_fuel_scg_amt", getHjlFuelScgAmt());
		this.hashColumns.put("wo_iss_no", getWoIssNo());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("trsp_so_no", getTrspSoNo());
		this.hashColumns.put("n1st_nod_pln_dt", getN1stNodPlnDt());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("wo_prv_grp_seq", getWoPrvGrpSeq());
		this.hashColumns.put("hjl_n3pty_cust_cnt_cd", getHjlN3ptyCustCntCd());
		this.hashColumns.put("cust_nomi_trkr_flg", getCustNomiTrkrFlg());
		this.hashColumns.put("nego_rmk", getNegoRmk());
		this.hashColumns.put("gline_nego_amt", getGlineNegoAmt());
		this.hashColumns.put("gline_usd_ttl_amt", getGlineUsdTtlAmt());
		this.hashColumns.put("gline_bzc_amt", getGlineBzcAmt());
		this.hashColumns.put("gline_scg_vat_amt", getGlineScgVatAmt());
		this.hashColumns.put("gline_fuel_scg_amt", getGlineFuelScgAmt());
		this.hashColumns.put("gline_toll_fee_amt", getGlineTollFeeAmt());
		this.hashColumns.put("gline_etc_add_amt", getGlineEtcAddAmt());
		this.hashColumns.put("gline_curr_cd", getGlineCurrCd());
		this.hashColumns.put("gline_vndr_seq", getGlineVndrSeq());
		this.hashColumns.put("gline_ttl_amt", getGlineTtlAmt());
		this.hashColumns.put("cust_nomi_trkr_ind_cd", getCustNomiTrkrIndCd());
		this.hashColumns.put("trsp_sp_cng_rsn_cd", getTrspSpCngRsnCd());
		this.hashColumns.put("trsp_sp_cng_rsn_rmk", getTrspSpCngRsnRmk());
		this.hashColumns.put("vgm_flg", getVgmFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("dtn_use_flg", "dtnUseFlg");
		this.hashFields.put("wo_cxl_flg", "woCxlFlg");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("fdr_skd_voy_no", "fdrSkdVoyNo");
		this.hashFields.put("usd_ttl_amt", "usdTtlAmt");
		this.hashFields.put("trsp_agmt_rt_tp_cd", "trspAgmtRtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_desc", "n3ptyDesc");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("dor_pst_cd", "dorPstCd");
		this.hashFields.put("cntc_pson_fax_no", "cntcPsonFaxNo");
		this.hashFields.put("hjl_vndr_seq", "hjlVndrSeq");
		this.hashFields.put("hjl_n3pty_desc", "hjlN3ptyDesc");
		this.hashFields.put("wo_iss_knt", "woIssKnt");
		this.hashFields.put("fdr_vsl_cd", "fdrVslCd");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("dor_nod_pln_dt", "dorNodPlnDt");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("trsp_agmt_rt_seq", "trspAgmtRtSeq");
		this.hashFields.put("wo_fmt_tp_cd", "woFmtTpCd");
		this.hashFields.put("wo_bl_no_iss_flg", "woBlNoIssFlg");
		this.hashFields.put("toll_fee_amt", "tollFeeAmt");
		this.hashFields.put("hjl_etc_add_amt", "hjlEtcAddAmt");
		this.hashFields.put("hjl_bzc_amt", "hjlBzcAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("n3pty_vndr_seq", "n3ptyVndrSeq");
		this.hashFields.put("trsp_so_cmb_tp_cd", "trspSoCmbTpCd");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trsp_dflt_vndr_flg", "trspDfltVndrFlg");
		this.hashFields.put("trsp_agmt_cfm_flg", "trspAgmtCfmFlg");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hjl_n3pty_cust_seq", "hjlN3ptyCustSeq");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("hjl_usd_ttl_amt", "hjlUsdTtlAmt");
		this.hashFields.put("hjl_n3pty_bil_tp_cd", "hjlN3ptyBilTpCd");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("scg_vat_amt", "scgVatAmt");
		this.hashFields.put("n3pty_bil_bzc_amt", "n3ptyBilBzcAmt");
		this.hashFields.put("n3pty_curr_cd", "n3ptyCurrCd");
		this.hashFields.put("n3pty_cust_seq", "n3ptyCustSeq");
		this.hashFields.put("trsp_agmt_upd_dt", "trspAgmtUpdDt");
		this.hashFields.put("fdr_skd_dir_cd", "fdrSkdDirCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("wo_iss_sts_cd", "woIssStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("agmt_mor_cnddt_aply_flg", "agmtMorCnddtAplyFlg");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("n3pty_cust_cnt_cd", "n3ptyCustCntCd");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("hjl_n3pty_bil_flg", "hjlN3ptyBilFlg");
		this.hashFields.put("hjl_n3pty_vndr_seq", "hjlN3ptyVndrSeq");
		this.hashFields.put("hjl_n3pty_ofc_cd", "hjlN3ptyOfcCd");
		this.hashFields.put("ovr_wgt_scg_amt", "ovrWgtScgAmt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("hjl_curr_cd", "hjlCurrCd");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hjl_nego_amt", "hjlNegoAmt");
		this.hashFields.put("hjl_n3pty_bil_bzc_amt", "hjlN3ptyBilBzcAmt");
		this.hashFields.put("trsp_agmt_wy_tp_cd", "trspAgmtWyTpCd");
		this.hashFields.put("trsp_rjct_rsn_cd", "trspRjctRsnCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("hjl_fuel_scg_amt", "hjlFuelScgAmt");
		this.hashFields.put("wo_iss_no", "woIssNo");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("trsp_so_no", "trspSoNo");
		this.hashFields.put("n1st_nod_pln_dt", "n1stNodPlnDt");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("wo_prv_grp_seq", "woPrvGrpSeq");
		this.hashFields.put("hjl_n3pty_cust_cnt_cd", "hjlN3ptyCustCntCd");
		this.hashFields.put("cust_nomi_trkr_flg", "custNomiTrkrFlg");
		this.hashFields.put("nego_rmk", "negoRmk");
		this.hashFields.put("gline_nego_amt", "glineNegoAmt");
		this.hashFields.put("gline_usd_ttl_amt", "glineUsdTtlAmt");
		this.hashFields.put("gline_bzc_amt", "glineBzcAmt");
		this.hashFields.put("gline_scg_vat_amt", "glineScgVatAmt");
		this.hashFields.put("gline_fuel_scg_amt", "glineFuelScgAmt");
		this.hashFields.put("gline_toll_fee_amt", "glineTollFeeAmt");
		this.hashFields.put("gline_etc_add_amt", "glineEtcAddAmt");
		this.hashFields.put("gline_curr_cd", "glineCurrCd");
		this.hashFields.put("gline_vndr_seq", "glineVndrSeq");
		this.hashFields.put("gline_ttl_amt", "glineTtlAmt");
		this.hashFields.put("cust_nomi_trkr_ind_cd", "custNomiTrkrIndCd");
		this.hashFields.put("trsp_sp_cng_rsn_cd", "trspSpCngRsnCd");
		this.hashFields.put("trsp_sp_cng_rsn_rmk", "trspSpCngRsnRmk");
		this.hashFields.put("vgm_flg", "vgmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return dtnUseFlg
	 */
	public String getDtnUseFlg() {
		return this.dtnUseFlg;
	}
	
	/**
	 * Column Info
	 * @return woCxlFlg
	 */
	public String getWoCxlFlg() {
		return this.woCxlFlg;
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
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return fdrSkdVoyNo
	 */
	public String getFdrSkdVoyNo() {
		return this.fdrSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return usdTtlAmt
	 */
	public String getUsdTtlAmt() {
		return this.usdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtTpCd
	 */
	public String getTrspAgmtRtTpCd() {
		return this.trspAgmtRtTpCd;
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
	 * @return dorPstCd
	 */
	public String getDorPstCd() {
		return this.dorPstCd;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonFaxNo
	 */
	public String getCntcPsonFaxNo() {
		return this.cntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @return hjlVndrSeq
	 */
	public String getHjlVndrSeq() {
		return this.hjlVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyDesc
	 */
	public String getHjlN3ptyDesc() {
		return this.hjlN3ptyDesc;
	}
	
	/**
	 * Column Info
	 * @return woIssKnt
	 */
	public String getWoIssKnt() {
		return this.woIssKnt;
	}
	
	/**
	 * Column Info
	 * @return fdrVslCd
	 */
	public String getFdrVslCd() {
		return this.fdrVslCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodPlnDt
	 */
	public String getDorNodPlnDt() {
		return this.dorNodPlnDt;
	}
	
	/**
	 * Column Info
	 * @return trspFrstFlg
	 */
	public String getTrspFrstFlg() {
		return this.trspFrstFlg;
	}
	
	/**
	 * Column Info
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtRtSeq
	 */
	public String getTrspAgmtRtSeq() {
		return this.trspAgmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @return woFmtTpCd
	 */
	public String getWoFmtTpCd() {
		return this.woFmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return woBlNoIssFlg
	 */
	public String getWoBlNoIssFlg() {
		return this.woBlNoIssFlg;
	}
	
	/**
	 * Column Info
	 * @return tollFeeAmt
	 */
	public String getTollFeeAmt() {
		return this.tollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @return hjlEtcAddAmt
	 */
	public String getHjlEtcAddAmt() {
		return this.hjlEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @return hjlBzcAmt
	 */
	public String getHjlBzcAmt() {
		return this.hjlBzcAmt;
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
	 * @return n3ptyVndrSeq
	 */
	public String getN3ptyVndrSeq() {
		return this.n3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trspSoCmbTpCd
	 */
	public String getTrspSoCmbTpCd() {
		return this.trspSoCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return trspDfltVndrFlg
	 */
	public String getTrspDfltVndrFlg() {
		return this.trspDfltVndrFlg;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtCfmFlg
	 */
	public String getTrspAgmtCfmFlg() {
		return this.trspAgmtCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonPhnNo
	 */
	public String getCntcPsonPhnNo() {
		return this.cntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
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
	 * @return hjlN3ptyCustSeq
	 */
	public String getHjlN3ptyCustSeq() {
		return this.hjlN3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @return fctryNm
	 */
	public String getFctryNm() {
		return this.fctryNm;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
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
	 * @return hjlUsdTtlAmt
	 */
	public String getHjlUsdTtlAmt() {
		return this.hjlUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyBilTpCd
	 */
	public String getHjlN3ptyBilTpCd() {
		return this.hjlN3ptyBilTpCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return this.trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return scgVatAmt
	 */
	public String getScgVatAmt() {
		return this.scgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilBzcAmt
	 */
	public String getN3ptyBilBzcAmt() {
		return this.n3ptyBilBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCurrCd
	 */
	public String getN3ptyCurrCd() {
		return this.n3ptyCurrCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCustSeq
	 */
	public String getN3ptyCustSeq() {
		return this.n3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtUpdDt
	 */
	public String getTrspAgmtUpdDt() {
		return this.trspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @return fdrSkdDirCd
	 */
	public String getFdrSkdDirCd() {
		return this.fdrSkdDirCd;
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
	 * @return woIssStsCd
	 */
	public String getWoIssStsCd() {
		return this.woIssStsCd;
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
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return agmtMorCnddtAplyFlg
	 */
	public String getAgmtMorCnddtAplyFlg() {
		return this.agmtMorCnddtAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
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
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCustCntCd
	 */
	public String getN3ptyCustCntCd() {
		return this.n3ptyCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyBilFlg
	 */
	public String getHjlN3ptyBilFlg() {
		return this.hjlN3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyVndrSeq
	 */
	public String getHjlN3ptyVndrSeq() {
		return this.hjlN3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyOfcCd
	 */
	public String getHjlN3ptyOfcCd() {
		return this.hjlN3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtScgAmt
	 */
	public String getOvrWgtScgAmt() {
		return this.ovrWgtScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return hjlCurrCd
	 */
	public String getHjlCurrCd() {
		return this.hjlCurrCd;
	}
	
	/**
	 * Column Info
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
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
	 * @return hjlNegoAmt
	 */
	public String getHjlNegoAmt() {
		return this.hjlNegoAmt;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyBilBzcAmt
	 */
	public String getHjlN3ptyBilBzcAmt() {
		return this.hjlN3ptyBilBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmtWyTpCd
	 */
	public String getTrspAgmtWyTpCd() {
		return this.trspAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return trspRjctRsnCd
	 */
	public String getTrspRjctRsnCd() {
		return this.trspRjctRsnCd;
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
	 * @return lstNodPlnDt
	 */
	public String getLstNodPlnDt() {
		return this.lstNodPlnDt;
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
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}
	
	/**
	 * Column Info
	 * @return hjlFuelScgAmt
	 */
	public String getHjlFuelScgAmt() {
		return this.hjlFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return woIssNo
	 */
	public String getWoIssNo() {
		return this.woIssNo;
	}
	
	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return trspSoNo
	 */
	public String getTrspSoNo() {
		return this.trspSoNo;
	}
	
	/**
	 * Column Info
	 * @return n1stNodPlnDt
	 */
	public String getN1stNodPlnDt() {
		return this.n1stNodPlnDt;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return woPrvGrpSeq
	 */
	public String getWoPrvGrpSeq() {
		return this.woPrvGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return hjlN3ptyCustCntCd
	 */
	public String getHjlN3ptyCustCntCd() {
		return this.hjlN3ptyCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return custNomiTrkrFlg
	 */
	public String getCustNomiTrkrFlg() {
		return this.custNomiTrkrFlg;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param dtnUseFlg
	 */
	public void setDtnUseFlg(String dtnUseFlg) {
		this.dtnUseFlg = dtnUseFlg;
	}
	
	/**
	 * Column Info
	 * @param woCxlFlg
	 */
	public void setWoCxlFlg(String woCxlFlg) {
		this.woCxlFlg = woCxlFlg;
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
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param fdrSkdVoyNo
	 */
	public void setFdrSkdVoyNo(String fdrSkdVoyNo) {
		this.fdrSkdVoyNo = fdrSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param usdTtlAmt
	 */
	public void setUsdTtlAmt(String usdTtlAmt) {
		this.usdTtlAmt = usdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtTpCd
	 */
	public void setTrspAgmtRtTpCd(String trspAgmtRtTpCd) {
		this.trspAgmtRtTpCd = trspAgmtRtTpCd;
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
	 * @param dorPstCd
	 */
	public void setDorPstCd(String dorPstCd) {
		this.dorPstCd = dorPstCd;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonFaxNo
	 */
	public void setCntcPsonFaxNo(String cntcPsonFaxNo) {
		this.cntcPsonFaxNo = cntcPsonFaxNo;
	}
	
	/**
	 * Column Info
	 * @param hjlVndrSeq
	 */
	public void setHjlVndrSeq(String hjlVndrSeq) {
		this.hjlVndrSeq = hjlVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyDesc
	 */
	public void setHjlN3ptyDesc(String hjlN3ptyDesc) {
		this.hjlN3ptyDesc = hjlN3ptyDesc;
	}
	
	/**
	 * Column Info
	 * @param woIssKnt
	 */
	public void setWoIssKnt(String woIssKnt) {
		this.woIssKnt = woIssKnt;
	}
	
	/**
	 * Column Info
	 * @param fdrVslCd
	 */
	public void setFdrVslCd(String fdrVslCd) {
		this.fdrVslCd = fdrVslCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodPlnDt
	 */
	public void setDorNodPlnDt(String dorNodPlnDt) {
		this.dorNodPlnDt = dorNodPlnDt;
	}
	
	/**
	 * Column Info
	 * @param trspFrstFlg
	 */
	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
	}
	
	/**
	 * Column Info
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtRtSeq
	 */
	public void setTrspAgmtRtSeq(String trspAgmtRtSeq) {
		this.trspAgmtRtSeq = trspAgmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @param woFmtTpCd
	 */
	public void setWoFmtTpCd(String woFmtTpCd) {
		this.woFmtTpCd = woFmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param woBlNoIssFlg
	 */
	public void setWoBlNoIssFlg(String woBlNoIssFlg) {
		this.woBlNoIssFlg = woBlNoIssFlg;
	}
	
	/**
	 * Column Info
	 * @param tollFeeAmt
	 */
	public void setTollFeeAmt(String tollFeeAmt) {
		this.tollFeeAmt = tollFeeAmt;
	}
	
	/**
	 * Column Info
	 * @param hjlEtcAddAmt
	 */
	public void setHjlEtcAddAmt(String hjlEtcAddAmt) {
		this.hjlEtcAddAmt = hjlEtcAddAmt;
	}
	
	/**
	 * Column Info
	 * @param hjlBzcAmt
	 */
	public void setHjlBzcAmt(String hjlBzcAmt) {
		this.hjlBzcAmt = hjlBzcAmt;
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
	 * @param n3ptyVndrSeq
	 */
	public void setN3ptyVndrSeq(String n3ptyVndrSeq) {
		this.n3ptyVndrSeq = n3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trspSoCmbTpCd
	 */
	public void setTrspSoCmbTpCd(String trspSoCmbTpCd) {
		this.trspSoCmbTpCd = trspSoCmbTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param trspDfltVndrFlg
	 */
	public void setTrspDfltVndrFlg(String trspDfltVndrFlg) {
		this.trspDfltVndrFlg = trspDfltVndrFlg;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtCfmFlg
	 */
	public void setTrspAgmtCfmFlg(String trspAgmtCfmFlg) {
		this.trspAgmtCfmFlg = trspAgmtCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonPhnNo
	 */
	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
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
	 * @param hjlN3ptyCustSeq
	 */
	public void setHjlN3ptyCustSeq(String hjlN3ptyCustSeq) {
		this.hjlN3ptyCustSeq = hjlN3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @param fctryNm
	 */
	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
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
	 * @param hjlUsdTtlAmt
	 */
	public void setHjlUsdTtlAmt(String hjlUsdTtlAmt) {
		this.hjlUsdTtlAmt = hjlUsdTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyBilTpCd
	 */
	public void setHjlN3ptyBilTpCd(String hjlN3ptyBilTpCd) {
		this.hjlN3ptyBilTpCd = hjlN3ptyBilTpCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param scgVatAmt
	 */
	public void setScgVatAmt(String scgVatAmt) {
		this.scgVatAmt = scgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilBzcAmt
	 */
	public void setN3ptyBilBzcAmt(String n3ptyBilBzcAmt) {
		this.n3ptyBilBzcAmt = n3ptyBilBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCurrCd
	 */
	public void setN3ptyCurrCd(String n3ptyCurrCd) {
		this.n3ptyCurrCd = n3ptyCurrCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCustSeq
	 */
	public void setN3ptyCustSeq(String n3ptyCustSeq) {
		this.n3ptyCustSeq = n3ptyCustSeq;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtUpdDt
	 */
	public void setTrspAgmtUpdDt(String trspAgmtUpdDt) {
		this.trspAgmtUpdDt = trspAgmtUpdDt;
	}
	
	/**
	 * Column Info
	 * @param fdrSkdDirCd
	 */
	public void setFdrSkdDirCd(String fdrSkdDirCd) {
		this.fdrSkdDirCd = fdrSkdDirCd;
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
	 * @param woIssStsCd
	 */
	public void setWoIssStsCd(String woIssStsCd) {
		this.woIssStsCd = woIssStsCd;
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
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param agmtMorCnddtAplyFlg
	 */
	public void setAgmtMorCnddtAplyFlg(String agmtMorCnddtAplyFlg) {
		this.agmtMorCnddtAplyFlg = agmtMorCnddtAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
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
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCustCntCd
	 */
	public void setN3ptyCustCntCd(String n3ptyCustCntCd) {
		this.n3ptyCustCntCd = n3ptyCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyBilFlg
	 */
	public void setHjlN3ptyBilFlg(String hjlN3ptyBilFlg) {
		this.hjlN3ptyBilFlg = hjlN3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyVndrSeq
	 */
	public void setHjlN3ptyVndrSeq(String hjlN3ptyVndrSeq) {
		this.hjlN3ptyVndrSeq = hjlN3ptyVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyOfcCd
	 */
	public void setHjlN3ptyOfcCd(String hjlN3ptyOfcCd) {
		this.hjlN3ptyOfcCd = hjlN3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtScgAmt
	 */
	public void setOvrWgtScgAmt(String ovrWgtScgAmt) {
		this.ovrWgtScgAmt = ovrWgtScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param hjlCurrCd
	 */
	public void setHjlCurrCd(String hjlCurrCd) {
		this.hjlCurrCd = hjlCurrCd;
	}
	
	/**
	 * Column Info
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
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
	 * @param hjlNegoAmt
	 */
	public void setHjlNegoAmt(String hjlNegoAmt) {
		this.hjlNegoAmt = hjlNegoAmt;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyBilBzcAmt
	 */
	public void setHjlN3ptyBilBzcAmt(String hjlN3ptyBilBzcAmt) {
		this.hjlN3ptyBilBzcAmt = hjlN3ptyBilBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmtWyTpCd
	 */
	public void setTrspAgmtWyTpCd(String trspAgmtWyTpCd) {
		this.trspAgmtWyTpCd = trspAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param trspRjctRsnCd
	 */
	public void setTrspRjctRsnCd(String trspRjctRsnCd) {
		this.trspRjctRsnCd = trspRjctRsnCd;
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
	 * @param lstNodPlnDt
	 */
	public void setLstNodPlnDt(String lstNodPlnDt) {
		this.lstNodPlnDt = lstNodPlnDt;
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
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}
	
	/**
	 * Column Info
	 * @param hjlFuelScgAmt
	 */
	public void setHjlFuelScgAmt(String hjlFuelScgAmt) {
		this.hjlFuelScgAmt = hjlFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param woIssNo
	 */
	public void setWoIssNo(String woIssNo) {
		this.woIssNo = woIssNo;
	}
	
	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param trspSoNo
	 */
	public void setTrspSoNo(String trspSoNo) {
		this.trspSoNo = trspSoNo;
	}
	
	/**
	 * Column Info
	 * @param n1stNodPlnDt
	 */
	public void setN1stNodPlnDt(String n1stNodPlnDt) {
		this.n1stNodPlnDt = n1stNodPlnDt;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param woPrvGrpSeq
	 */
	public void setWoPrvGrpSeq(String woPrvGrpSeq) {
		this.woPrvGrpSeq = woPrvGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param hjlN3ptyCustCntCd
	 */
	public void setHjlN3ptyCustCntCd(String hjlN3ptyCustCntCd) {
		this.hjlN3ptyCustCntCd = hjlN3ptyCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param custNomiTrkrFlg
	 */
	public void setCustNomiTrkrFlg(String custNomiTrkrFlg) {
		this.custNomiTrkrFlg = custNomiTrkrFlg;
	}

	/**
	 * @return the negoRmk
	 */
	public String getNegoRmk() {
		return negoRmk;
	}

	/**
	 * @param negoRmk the negoRmk to set
	 */
	public void setNegoRmk(String negoRmk) {
		this.negoRmk = negoRmk;
	}
	
	/**
	 * @return the glineNegoAmt
	 */
	public String getGlineNegoAmt() {
		return glineNegoAmt;
	}

	/**
	 * @param glineNegoAmt the glineNegoAmt to set
	 */
	public void setGlineNegoAmt(String glineNegoAmt) {
		this.glineNegoAmt = glineNegoAmt;
	}

	/**
	 * @return the glineUsdTtlAmt
	 */
	public String getGlineUsdTtlAmt() {
		return glineUsdTtlAmt;
	}

	/**
	 * @param glineUsdTtlAmt the glineUsdTtlAmt to set
	 */
	public void setGlineUsdTtlAmt(String glineUsdTtlAmt) {
		this.glineUsdTtlAmt = glineUsdTtlAmt;
	}

	/**
	 * @return the glineBzcAmt
	 */
	public String getGlineBzcAmt() {
		return glineBzcAmt;
	}

	/**
	 * @param glineBzcAmt the glineBzcAmt to set
	 */
	public void setGlineBzcAmt(String glineBzcAmt) {
		this.glineBzcAmt = glineBzcAmt;
	}

	/**
	 * @return the glineScgVatAmt
	 */
	public String getGlineScgVatAmt() {
		return glineScgVatAmt;
	}

	/**
	 * @param glineScgVatAmt the glineScgVatAmt to set
	 */
	public void setGlineScgVatAmt(String glineScgVatAmt) {
		this.glineScgVatAmt = glineScgVatAmt;
	}

	/**
	 * @return the glineFuelScgAmt
	 */
	public String getGlineFuelScgAmt() {
		return glineFuelScgAmt;
	}

	/**
	 * @param glineFuelScgAmt the glineFuelScgAmt to set
	 */
	public void setGlineFuelScgAmt(String glineFuelScgAmt) {
		this.glineFuelScgAmt = glineFuelScgAmt;
	}

	/**
	 * @return the glineTollFeeAmt
	 */
	public String getGlineTollFeeAmt() {
		return glineTollFeeAmt;
	}

	/**
	 * @param glineTollFeeAmt the glineTollFeeAmt to set
	 */
	public void setGlineTollFeeAmt(String glineTollFeeAmt) {
		this.glineTollFeeAmt = glineTollFeeAmt;
	}

	/**
	 * @return the glineEtcAddAmt
	 */
	public String getGlineEtcAddAmt() {
		return glineEtcAddAmt;
	}

	/**
	 * @param glineEtcAddAmt the glineEtcAddAmt to set
	 */
	public void setGlineEtcAddAmt(String glineEtcAddAmt) {
		this.glineEtcAddAmt = glineEtcAddAmt;
	}

	/**
	 * @return the glineCurrCd
	 */
	public String getGlineCurrCd() {
		return glineCurrCd;
	}

	/**
	 * @param glineCurrCd the glineCurrCd to set
	 */
	public void setGlineCurrCd(String glineCurrCd) {
		this.glineCurrCd = glineCurrCd;
	}

	/**
	 * @return the glineVndrSeq
	 */
	public String getGlineVndrSeq() {
		return glineVndrSeq;
	}

	/**
	 * @param glineVndrSeq the glineVndrSeq to set
	 */
	public void setGlineVndrSeq(String glineVndrSeq) {
		this.glineVndrSeq = glineVndrSeq;
	}

	/**
	 * @return the glineTtlAmt
	 */
	public String getGlineTtlAmt() {
		return glineTtlAmt;
	}

	/**
	 * @param glineTtlAmt the glineTtlAmt to set
	 */
	public void setGlineTtlAmt(String glineTtlAmt) {
		this.glineTtlAmt = glineTtlAmt;
	}
	
	

	/**
	 * @return the custNomiTrkrIndCd
	 */
	public String getCustNomiTrkrIndCd() {
		return custNomiTrkrIndCd;
	}

	/**
	 * @param custNomiTrkrIndCd the custNomiTrkrIndCd to set
	 */
	public void setCustNomiTrkrIndCd(String custNomiTrkrIndCd) {
		this.custNomiTrkrIndCd = custNomiTrkrIndCd;
	}
	

	/**
	 * @return the trspSpCngRsnCd
	 */
	public String getTrspSpCngRsnCd() {
		return trspSpCngRsnCd;
	}

	/**
	 * @param trspSpCngRsnCd the trspSpCngRsnCd to set
	 */
	public void setTrspSpCngRsnCd(String trspSpCngRsnCd) {
		this.trspSpCngRsnCd = trspSpCngRsnCd;
	}
	
	/**
	 * @return the trspSpCngRsnRmk
	 */
	public String getTrspSpCngRsnRmk() {
		return trspSpCngRsnRmk;
	}
	
	/**
	 * @param trspSpCngRsnRmk the trspSpCngRsnRmk to set
	 */
	public void setTrspSpCngRsnRmk(String trspSpCngRsnRmk) {
		this.trspSpCngRsnRmk = trspSpCngRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return vgmFlg
	 */
	public String getVgmFlg() {
		return vgmFlg;
	}
	
	/**
	 * Column Info
	 * @param vgmFlg
	 */
	public void setVgmFlg(String vgmFlg) {
		this.vgmFlg = vgmFlg;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setDtnUseFlg(JSPUtil.getParameter(request, prefix + "dtn_use_flg", ""));
		setWoCxlFlg(JSPUtil.getParameter(request, prefix + "wo_cxl_flg", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setFdrSkdVoyNo(JSPUtil.getParameter(request, prefix + "fdr_skd_voy_no", ""));
		setUsdTtlAmt(JSPUtil.getParameter(request, prefix + "usd_ttl_amt", ""));
		setTrspAgmtRtTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyDesc(JSPUtil.getParameter(request, prefix + "n3pty_desc", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd", ""));
		setDorPstCd(JSPUtil.getParameter(request, prefix + "dor_pst_cd", ""));
		setCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "cntc_pson_fax_no", ""));
		setHjlVndrSeq(JSPUtil.getParameter(request, prefix + "hjl_vndr_seq", ""));
		setHjlN3ptyDesc(JSPUtil.getParameter(request, prefix + "hjl_n3pty_desc", ""));
		setWoIssKnt(JSPUtil.getParameter(request, prefix + "wo_iss_knt", ""));
		setFdrVslCd(JSPUtil.getParameter(request, prefix + "fdr_vsl_cd", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
		setDorNodPlnDt(JSPUtil.getParameter(request, prefix + "dor_nod_pln_dt", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, prefix + "trsp_frst_flg", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setTrspAgmtRtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_seq", ""));
		setWoFmtTpCd(JSPUtil.getParameter(request, prefix + "wo_fmt_tp_cd", ""));
		setWoBlNoIssFlg(JSPUtil.getParameter(request, prefix + "wo_bl_no_iss_flg", ""));
		setTollFeeAmt(JSPUtil.getParameter(request, prefix + "toll_fee_amt", ""));
		setHjlEtcAddAmt(JSPUtil.getParameter(request, prefix + "hjl_etc_add_amt", ""));
		setHjlBzcAmt(JSPUtil.getParameter(request, prefix + "hjl_bzc_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setN3ptyVndrSeq(JSPUtil.getParameter(request, prefix + "n3pty_vndr_seq", ""));
		setTrspSoCmbTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_cmb_tp_cd", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setTrspDfltVndrFlg(JSPUtil.getParameter(request, prefix + "trsp_dflt_vndr_flg", ""));
		setTrspAgmtCfmFlg(JSPUtil.getParameter(request, prefix + "trsp_agmt_cfm_flg", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHjlN3ptyCustSeq(JSPUtil.getParameter(request, prefix + "hjl_n3pty_cust_seq", ""));
		setFctryNm(JSPUtil.getParameter(request, prefix + "fctry_nm", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setHjlUsdTtlAmt(JSPUtil.getParameter(request, prefix + "hjl_usd_ttl_amt", ""));
		setHjlN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "hjl_n3pty_bil_tp_cd", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));
		setScgVatAmt(JSPUtil.getParameter(request, prefix + "scg_vat_amt", ""));
		setN3ptyBilBzcAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_bzc_amt", ""));
		setN3ptyCurrCd(JSPUtil.getParameter(request, prefix + "n3pty_curr_cd", ""));
		setN3ptyCustSeq(JSPUtil.getParameter(request, prefix + "n3pty_cust_seq", ""));
		setTrspAgmtUpdDt(JSPUtil.getParameter(request, prefix + "trsp_agmt_upd_dt", ""));
		setFdrSkdDirCd(JSPUtil.getParameter(request, prefix + "fdr_skd_dir_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setWoIssStsCd(JSPUtil.getParameter(request, prefix + "wo_iss_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setAgmtMorCnddtAplyFlg(JSPUtil.getParameter(request, prefix + "agmt_mor_cnddt_aply_flg", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setN3ptyCustCntCd(JSPUtil.getParameter(request, prefix + "n3pty_cust_cnt_cd", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setHjlN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "hjl_n3pty_bil_flg", ""));
		setHjlN3ptyVndrSeq(JSPUtil.getParameter(request, prefix + "hjl_n3pty_vndr_seq", ""));
		setHjlN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "hjl_n3pty_ofc_cd", ""));
		setOvrWgtScgAmt(JSPUtil.getParameter(request, prefix + "ovr_wgt_scg_amt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setHjlCurrCd(JSPUtil.getParameter(request, prefix + "hjl_curr_cd", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setHjlNegoAmt(JSPUtil.getParameter(request, prefix + "hjl_nego_amt", ""));
		setHjlN3ptyBilBzcAmt(JSPUtil.getParameter(request, prefix + "hjl_n3pty_bil_bzc_amt", ""));
		setTrspAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_wy_tp_cd", ""));
		setTrspRjctRsnCd(JSPUtil.getParameter(request, prefix + "trsp_rjct_rsn_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setHjlFuelScgAmt(JSPUtil.getParameter(request, prefix + "hjl_fuel_scg_amt", ""));
		setWoIssNo(JSPUtil.getParameter(request, prefix + "wo_iss_no", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setTrspSoNo(JSPUtil.getParameter(request, prefix + "trsp_so_no", ""));
		setN1stNodPlnDt(JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setWoPrvGrpSeq(JSPUtil.getParameter(request, prefix + "wo_prv_grp_seq", ""));
		setHjlN3ptyCustCntCd(JSPUtil.getParameter(request, prefix + "hjl_n3pty_cust_cnt_cd", ""));
		setCustNomiTrkrFlg(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_flg", ""));
		setNegoRmk(JSPUtil.getParameter(request, prefix + "nego_rmk", ""));
		setGlineNegoAmt(JSPUtil.getParameter(request, prefix + "gline_nego_amt", ""));
		setGlineUsdTtlAmt(JSPUtil.getParameter(request, prefix + "gline_usd_ttl_amt", ""));
		setGlineBzcAmt(JSPUtil.getParameter(request, prefix + "gline_bzc_amt", ""));
		setGlineScgVatAmt(JSPUtil.getParameter(request, prefix + "gline_scg_vat_amt", ""));
		setGlineFuelScgAmt(JSPUtil.getParameter(request, prefix + "gline_fuel_scg_amt", ""));
		setGlineTollFeeAmt(JSPUtil.getParameter(request, prefix + "gline_toll_fee_amt", ""));
		setGlineEtcAddAmt(JSPUtil.getParameter(request, prefix + "gline_etc_add_amt", ""));
		setGlineCurrCd(JSPUtil.getParameter(request, prefix + "gline_curr_cd", ""));
		setGlineVndrSeq(JSPUtil.getParameter(request, prefix + "gline_vndr_seq", ""));
		setGlineTtlAmt(JSPUtil.getParameter(request, prefix + "gline_ttl_amt", ""));
		setCustNomiTrkrIndCd(JSPUtil.getParameter(request, prefix + "cust_nomi_trkr_ind_cd", ""));
		setTrspSpCngRsnCd(JSPUtil.getParameter(request, prefix + "trsp_sp_cng_rsn_cd", ""));
		setTrspSpCngRsnRmk(JSPUtil.getParameter(request, prefix + "trsp_sp_cng_rsn_rmk", ""));
		setVgmFlg(JSPUtil.getParameter(request, prefix + "vgm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsTrspWrkOrdPrvTmpVO[]
	 */
	public TrsTrspWrkOrdPrvTmpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsTrspWrkOrdPrvTmpVO[]
	 */
	public TrsTrspWrkOrdPrvTmpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsTrspWrkOrdPrvTmpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] dtnUseFlg = (JSPUtil.getParameter(request, prefix	+ "dtn_use_flg", length));
			String[] woCxlFlg = (JSPUtil.getParameter(request, prefix	+ "wo_cxl_flg", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] fdrSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "fdr_skd_voy_no", length));
			String[] usdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "usd_ttl_amt", length));
			String[] trspAgmtRtTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyDesc = (JSPUtil.getParameter(request, prefix	+ "n3pty_desc", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] dorPstCd = (JSPUtil.getParameter(request, prefix	+ "dor_pst_cd", length));
			String[] cntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_fax_no", length));
			String[] hjlVndrSeq = (JSPUtil.getParameter(request, prefix	+ "hjl_vndr_seq", length));
			String[] hjlN3ptyDesc = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_desc", length));
			String[] woIssKnt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_knt", length));
			String[] fdrVslCd = (JSPUtil.getParameter(request, prefix	+ "fdr_vsl_cd", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] dorNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "dor_nod_pln_dt", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_frst_flg", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] trspAgmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_rt_seq", length));
			String[] woFmtTpCd = (JSPUtil.getParameter(request, prefix	+ "wo_fmt_tp_cd", length));
			String[] woBlNoIssFlg = (JSPUtil.getParameter(request, prefix	+ "wo_bl_no_iss_flg", length));
			String[] tollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt", length));
			String[] hjlEtcAddAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_etc_add_amt", length));
			String[] hjlBzcAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_bzc_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] n3ptyVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_vndr_seq", length));
			String[] trspSoCmbTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_cmb_tp_cd", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trspDfltVndrFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_dflt_vndr_flg", length));
			String[] trspAgmtCfmFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_cfm_flg", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hjlN3ptyCustSeq = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_cust_seq", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] hjlUsdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_usd_ttl_amt", length));
			String[] hjlN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_bil_tp_cd", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_ofc_cty_cd", length));
			String[] scgVatAmt = (JSPUtil.getParameter(request, prefix	+ "scg_vat_amt", length));
			String[] n3ptyBilBzcAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_bzc_amt", length));
			String[] n3ptyCurrCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_curr_cd", length));
			String[] n3ptyCustSeq = (JSPUtil.getParameter(request, prefix	+ "n3pty_cust_seq", length));
			String[] trspAgmtUpdDt = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_upd_dt", length));
			String[] fdrSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "fdr_skd_dir_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] woIssStsCd = (JSPUtil.getParameter(request, prefix	+ "wo_iss_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] agmtMorCnddtAplyFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_mor_cnddt_aply_flg", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] n3ptyCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_cust_cnt_cd", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] hjlN3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_bil_flg", length));
			String[] hjlN3ptyVndrSeq = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_vndr_seq", length));
			String[] hjlN3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_ofc_cd", length));
			String[] ovrWgtScgAmt = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_scg_amt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] hjlCurrCd = (JSPUtil.getParameter(request, prefix	+ "hjl_curr_cd", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hjlNegoAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_nego_amt", length));
			String[] hjlN3ptyBilBzcAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_bil_bzc_amt", length));
			String[] trspAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_wy_tp_cd", length));
			String[] trspRjctRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsp_rjct_rsn_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] lstNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "lst_nod_pln_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] hjlFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_fuel_scg_amt", length));
			String[] woIssNo = (JSPUtil.getParameter(request, prefix	+ "wo_iss_no", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] trspSoNo = (JSPUtil.getParameter(request, prefix	+ "trsp_so_no", length));
			String[] n1stNodPlnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_pln_dt", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] woPrvGrpSeq = (JSPUtil.getParameter(request, prefix	+ "wo_prv_grp_seq", length));
			String[] hjlN3ptyCustCntCd = (JSPUtil.getParameter(request, prefix	+ "hjl_n3pty_cust_cnt_cd", length));
			String[] custNomiTrkrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_flg", length));
			String[] negoRmk = (JSPUtil.getParameter(request, prefix	+ "nego_rmk", length));
			String[] glineNegoAmt = (JSPUtil.getParameter(request, prefix	+ "gline_nego_amt", length));
			String[] glineUsdTtlAmt = (JSPUtil.getParameter(request, prefix	+ "gline_usd_ttl_amt", length));
			String[] glineBzcAmt = (JSPUtil.getParameter(request, prefix	+ "gline_bzc_amt", length));
			String[] glineScgVatAmt = (JSPUtil.getParameter(request, prefix	+ "gline_scg_vat_amt", length));
			String[] glineFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "gline_fuel_scg_amt", length));
			String[] glineTollFeeAmt = (JSPUtil.getParameter(request, prefix	+ "gline_toll_fee_amt", length));
			String[] glineEtcAddAmt = (JSPUtil.getParameter(request, prefix	+ "gline_etc_add_amt", length));
			String[] glineCurrCd = (JSPUtil.getParameter(request, prefix	+ "gline_curr_cd", length));
			String[] glineVndrSeq = (JSPUtil.getParameter(request, prefix	+ "gline_vndr_seq", length));
			String[] glineTtlAmt = (JSPUtil.getParameter(request, prefix	+ "gline_ttl_amt", length));
			String[] custNomiTrkrIndCd = (JSPUtil.getParameter(request, prefix	+ "cust_nomi_trkr_ind_cd", length));
			String[] trspSpCngRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsp_sp_cng_rsn_cd", length));
			String[] trspSpCngRsnRmk = (JSPUtil.getParameter(request, prefix	+ "trsp_sp_cng_rsn_rmk", length));
			String[] vgmFlg = (JSPUtil.getParameter(request, prefix	+ "vgm_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsTrspWrkOrdPrvTmpVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (dtnUseFlg[i] != null)
					model.setDtnUseFlg(dtnUseFlg[i]);
				if (woCxlFlg[i] != null)
					model.setWoCxlFlg(woCxlFlg[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (fdrSkdVoyNo[i] != null)
					model.setFdrSkdVoyNo(fdrSkdVoyNo[i]);
				if (usdTtlAmt[i] != null)
					model.setUsdTtlAmt(usdTtlAmt[i]);
				if (trspAgmtRtTpCd[i] != null)
					model.setTrspAgmtRtTpCd(trspAgmtRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyDesc[i] != null)
					model.setN3ptyDesc(n3ptyDesc[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (dorPstCd[i] != null)
					model.setDorPstCd(dorPstCd[i]);
				if (cntcPsonFaxNo[i] != null)
					model.setCntcPsonFaxNo(cntcPsonFaxNo[i]);
				if (hjlVndrSeq[i] != null)
					model.setHjlVndrSeq(hjlVndrSeq[i]);
				if (hjlN3ptyDesc[i] != null)
					model.setHjlN3ptyDesc(hjlN3ptyDesc[i]);
				if (woIssKnt[i] != null)
					model.setWoIssKnt(woIssKnt[i]);
				if (fdrVslCd[i] != null)
					model.setFdrVslCd(fdrVslCd[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (dorNodPlnDt[i] != null)
					model.setDorNodPlnDt(dorNodPlnDt[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (trspAgmtRtSeq[i] != null)
					model.setTrspAgmtRtSeq(trspAgmtRtSeq[i]);
				if (woFmtTpCd[i] != null)
					model.setWoFmtTpCd(woFmtTpCd[i]);
				if (woBlNoIssFlg[i] != null)
					model.setWoBlNoIssFlg(woBlNoIssFlg[i]);
				if (tollFeeAmt[i] != null)
					model.setTollFeeAmt(tollFeeAmt[i]);
				if (hjlEtcAddAmt[i] != null)
					model.setHjlEtcAddAmt(hjlEtcAddAmt[i]);
				if (hjlBzcAmt[i] != null)
					model.setHjlBzcAmt(hjlBzcAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (n3ptyVndrSeq[i] != null)
					model.setN3ptyVndrSeq(n3ptyVndrSeq[i]);
				if (trspSoCmbTpCd[i] != null)
					model.setTrspSoCmbTpCd(trspSoCmbTpCd[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trspDfltVndrFlg[i] != null)
					model.setTrspDfltVndrFlg(trspDfltVndrFlg[i]);
				if (trspAgmtCfmFlg[i] != null)
					model.setTrspAgmtCfmFlg(trspAgmtCfmFlg[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hjlN3ptyCustSeq[i] != null)
					model.setHjlN3ptyCustSeq(hjlN3ptyCustSeq[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (hjlUsdTtlAmt[i] != null)
					model.setHjlUsdTtlAmt(hjlUsdTtlAmt[i]);
				if (hjlN3ptyBilTpCd[i] != null)
					model.setHjlN3ptyBilTpCd(hjlN3ptyBilTpCd[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (scgVatAmt[i] != null)
					model.setScgVatAmt(scgVatAmt[i]);
				if (n3ptyBilBzcAmt[i] != null)
					model.setN3ptyBilBzcAmt(n3ptyBilBzcAmt[i]);
				if (n3ptyCurrCd[i] != null)
					model.setN3ptyCurrCd(n3ptyCurrCd[i]);
				if (n3ptyCustSeq[i] != null)
					model.setN3ptyCustSeq(n3ptyCustSeq[i]);
				if (trspAgmtUpdDt[i] != null)
					model.setTrspAgmtUpdDt(trspAgmtUpdDt[i]);
				if (fdrSkdDirCd[i] != null)
					model.setFdrSkdDirCd(fdrSkdDirCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (woIssStsCd[i] != null)
					model.setWoIssStsCd(woIssStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (agmtMorCnddtAplyFlg[i] != null)
					model.setAgmtMorCnddtAplyFlg(agmtMorCnddtAplyFlg[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (n3ptyCustCntCd[i] != null)
					model.setN3ptyCustCntCd(n3ptyCustCntCd[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (hjlN3ptyBilFlg[i] != null)
					model.setHjlN3ptyBilFlg(hjlN3ptyBilFlg[i]);
				if (hjlN3ptyVndrSeq[i] != null)
					model.setHjlN3ptyVndrSeq(hjlN3ptyVndrSeq[i]);
				if (hjlN3ptyOfcCd[i] != null)
					model.setHjlN3ptyOfcCd(hjlN3ptyOfcCd[i]);
				if (ovrWgtScgAmt[i] != null)
					model.setOvrWgtScgAmt(ovrWgtScgAmt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (hjlCurrCd[i] != null)
					model.setHjlCurrCd(hjlCurrCd[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hjlNegoAmt[i] != null)
					model.setHjlNegoAmt(hjlNegoAmt[i]);
				if (hjlN3ptyBilBzcAmt[i] != null)
					model.setHjlN3ptyBilBzcAmt(hjlN3ptyBilBzcAmt[i]);
				if (trspAgmtWyTpCd[i] != null)
					model.setTrspAgmtWyTpCd(trspAgmtWyTpCd[i]);
				if (trspRjctRsnCd[i] != null)
					model.setTrspRjctRsnCd(trspRjctRsnCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (lstNodPlnDt[i] != null)
					model.setLstNodPlnDt(lstNodPlnDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (hjlFuelScgAmt[i] != null)
					model.setHjlFuelScgAmt(hjlFuelScgAmt[i]);
				if (woIssNo[i] != null)
					model.setWoIssNo(woIssNo[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (trspSoNo[i] != null)
					model.setTrspSoNo(trspSoNo[i]);
				if (n1stNodPlnDt[i] != null)
					model.setN1stNodPlnDt(n1stNodPlnDt[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (woPrvGrpSeq[i] != null)
					model.setWoPrvGrpSeq(woPrvGrpSeq[i]);
				if (hjlN3ptyCustCntCd[i] != null)
					model.setHjlN3ptyCustCntCd(hjlN3ptyCustCntCd[i]);
				if (custNomiTrkrFlg[i] != null)
					model.setCustNomiTrkrFlg(custNomiTrkrFlg[i]);
				if (negoRmk[i] != null)
					model.setNegoRmk(negoRmk[i]);
				if (glineNegoAmt[i] != null)
					model.setGlineNegoAmt(glineNegoAmt[i]);
				if (glineUsdTtlAmt[i] != null)
					model.setGlineUsdTtlAmt(glineUsdTtlAmt[i]);
				if (glineBzcAmt[i] != null)
					model.setGlineBzcAmt(glineBzcAmt[i]);
				if (glineScgVatAmt[i] != null)
					model.setGlineScgVatAmt(glineScgVatAmt[i]);
				if (glineFuelScgAmt[i] != null)
					model.setGlineFuelScgAmt(glineFuelScgAmt[i]);
				if (glineTollFeeAmt[i] != null)
					model.setGlineTollFeeAmt(glineTollFeeAmt[i]);
				if (glineEtcAddAmt[i] != null)
					model.setGlineEtcAddAmt(glineEtcAddAmt[i]);
				if (glineCurrCd[i] != null)
					model.setGlineCurrCd(glineCurrCd[i]);
				if (glineVndrSeq[i] != null)
					model.setGlineVndrSeq(glineVndrSeq[i]);
				if (glineTtlAmt[i] != null)
					model.setGlineTtlAmt(glineTtlAmt[i]);
				if (custNomiTrkrIndCd[i] != null)
					model.setCustNomiTrkrIndCd(custNomiTrkrIndCd[i]);
				if (trspSpCngRsnCd[i] != null)
					model.setTrspSpCngRsnCd(trspSpCngRsnCd[i]);
				if (trspSpCngRsnRmk[i] != null)
					model.setTrspSpCngRsnRmk(trspSpCngRsnRmk[i]);
				if (vgmFlg[i] != null)
					model.setVgmFlg(vgmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsTrspWrkOrdPrvTmpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsTrspWrkOrdPrvTmpVO[]
	 */
	public TrsTrspWrkOrdPrvTmpVO[] getTrsTrspWrkOrdPrvTmpVOs(){
		TrsTrspWrkOrdPrvTmpVO[] vos = (TrsTrspWrkOrdPrvTmpVO[])models.toArray(new TrsTrspWrkOrdPrvTmpVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtnUseFlg = this.dtnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCxlFlg = this.woCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrSkdVoyNo = this.fdrSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdTtlAmt = this.usdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpCd = this.trspAgmtRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyDesc = this.n3ptyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstCd = this.dorPstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonFaxNo = this.cntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlVndrSeq = this.hjlVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyDesc = this.hjlN3ptyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssKnt = this.woIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVslCd = this.fdrVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDt = this.dorNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtSeq = this.trspAgmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woFmtTpCd = this.woFmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woBlNoIssFlg = this.woBlNoIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt = this.tollFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlEtcAddAmt = this.hjlEtcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlBzcAmt = this.hjlBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyVndrSeq = this.n3ptyVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoCmbTpCd = this.trspSoCmbTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDfltVndrFlg = this.trspDfltVndrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtCfmFlg = this.trspAgmtCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyCustSeq = this.hjlN3ptyCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlUsdTtlAmt = this.hjlUsdTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyBilTpCd = this.hjlN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgVatAmt = this.scgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilBzcAmt = this.n3ptyBilBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCurrCd = this.n3ptyCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCustSeq = this.n3ptyCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtUpdDt = this.trspAgmtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrSkdDirCd = this.fdrSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssStsCd = this.woIssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtMorCnddtAplyFlg = this.agmtMorCnddtAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCustCntCd = this.n3ptyCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyBilFlg = this.hjlN3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyVndrSeq = this.hjlN3ptyVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyOfcCd = this.hjlN3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtScgAmt = this.ovrWgtScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlCurrCd = this.hjlCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlNegoAmt = this.hjlNegoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyBilBzcAmt = this.hjlN3ptyBilBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtWyTpCd = this.trspAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRjctRsnCd = this.trspRjctRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt = this.lstNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlFuelScgAmt = this.hjlFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssNo = this.woIssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoNo = this.trspSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDt = this.n1stNodPlnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPrvGrpSeq = this.woPrvGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlN3ptyCustCntCd = this.hjlN3ptyCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrFlg = this.custNomiTrkrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoRmk = this.negoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineNegoAmt = this.glineNegoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineUsdTtlAmt = this.glineUsdTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineBzcAmt = this.glineBzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineScgVatAmt = this.glineScgVatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineFuelScgAmt = this.glineFuelScgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineTollFeeAmt = this.glineTollFeeAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineEtcAddAmt = this.glineEtcAddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineCurrCd = this.glineCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineVndrSeq = this.glineVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineTtlAmt = this.glineTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNomiTrkrIndCd = this.custNomiTrkrIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSpCngRsnCd = this.trspSpCngRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSpCngRsnRmk = this.trspSpCngRsnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmFlg = this.vgmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
