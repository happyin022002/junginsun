/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgTerminalEdiJapanBlVO.java
*@FileTitle : BkgTerminalEdiJapanBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTerminalEdiJapanBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgTerminalEdiJapanBlVO> models = new ArrayList<BkgTerminalEdiJapanBlVO>();
	
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String snaccsTmlEdiRcvTermCd = null;
	/* Column Info */
	private String ediSndUsrId = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String snaccsTmlEdiStsCngFlg = null;
	/* Column Info */
	private String vvdChkStsCnt = null;
	/* Column Info */
	private String frtFwrdCustNm = null;
	/* Column Info */
	private String prtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fnlDestNm = null;
	/* Column Info */
	private String rStsCnt = null;
	/* Column Info */
	private String bkgCreDtYmd = null;
	/* Column Info */
	private String ttlPckTpCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String stwgRmk = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String snaccsTmlEdiCgoKndCd = null;
	/* Column Info */
	private String snaccsTmlEdiStwgCd = null;
	/* Column Info */
	private String cntrVolQty5 = null;
	/* Column Info */
	private String cntrVolQty4 = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrVolQty1 = null;
	/* Column Info */
	private String bkgSkdSeq = null;
	/* Column Info */
	private String fnlDestCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cntrVolQty3 = null;
	/* Column Info */
	private String etdDtYmd = null;
	/* Column Info */
	private String cntrVolQty2 = null;
	/* Column Info */
	private String frtFwrdCustSeq = null;
	/* Column Info */
	private String snaccsTmlEdiDeTermCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String mcntrFlg = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String ediSndDt = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String jpTmlVslNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cntrVolQtyTot = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgSkdDeltFlg = null;
	/* Column Info */
	private String eqSubstFlg = null;
	/* Column Info */
	private String porYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String rfRemark = null;
	/* Column Info */
	private String ediSndOfcCd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String snaccsTmlEdiCgoTpCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String otrNtfyYdCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String mtyPYdNm = null;
	/* Column Info */
	private String cntrTpszCd5 = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String shprCustSeq = null;
	/* Column Info */
	private String cntrTpszCd2 = null;
	/* Column Info */
	private String mtyPYd = null;
	/* Column Info */
	private String cntrTpszCd1 = null;
	/* Column Info */
	private String cntrTpszCd4 = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String snaccsTmlEdiStsCd = null;
	/* Column Info */
	private String cntrTpszCd3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgTerminalEdiJapanBlVO() {}

	public BkgTerminalEdiJapanBlVO(String ibflag, String pagerows, String awkCgoFlg, String bbCgoFlg, String bkgCreDt, String bkgCreDtYmd, String bkgNo, String bkgSkdDeltFlg, String bkgSkdSeq, String blckStwgCd, String callSgnNo, String cmdtNm, String cntrTpszCd1, String cntrTpszCd2, String cntrTpszCd3, String cntrTpszCd4, String cntrTpszCd5, String cntrVolQty1, String cntrVolQty2, String cntrVolQty3, String cntrVolQty4, String cntrVolQty5, String cntrVolQtyTot, String dcgoFlg, String delCd, String deTermCd, String dryCgoFlg, String ediSndDt, String ediSndOfcCd, String ediSndUsrId, String eqSubstFlg, String etdDt, String etdDtYmd, String fnlDestCd, String fnlDestNm, String frtFwrdCntCd, String frtFwrdCustNm, String frtFwrdCustSeq, String grsWgt, String jpTmlVslNo, String mcntrFlg, String measQty, String measUtCd, String mtyPYd, String mtyPYdNm, String otrNtfyYdCd, String pckQty, String pckTpCd, String podCd, String podYdCd, String polCd, String polYdCd, String porCd, String porYdCd, String prtFlg, String rcvTermCd, String rdCgoFlg, String rStsCnt, String scacCd, String shprCntCd, String shprCustNm, String shprCustSeq, String skdDirCd, String skdVoyNo, String snaccsTmlEdiCgoKndCd, String snaccsTmlEdiCgoTpCd, String snaccsTmlEdiDeTermCd, String snaccsTmlEdiRcvTermCd, String snaccsTmlEdiStsCd, String snaccsTmlEdiStsCngFlg, String snaccsTmlEdiStwgCd, String socFlg, String stwgRmk, String ttlPckTpCd, String vslCd, String vslEngNm, String vvdChkStsCnt, String wgtUtCd, String xterRmk, String rfRemark) {
		this.dryCgoFlg = dryCgoFlg;
		this.vslCd = vslCd;
		this.snaccsTmlEdiRcvTermCd = snaccsTmlEdiRcvTermCd;
		this.ediSndUsrId = ediSndUsrId;
		this.blckStwgCd = blckStwgCd;
		this.snaccsTmlEdiStsCngFlg = snaccsTmlEdiStsCngFlg;
		this.vvdChkStsCnt = vvdChkStsCnt;
		this.frtFwrdCustNm = frtFwrdCustNm;
		this.prtFlg = prtFlg;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.fnlDestNm = fnlDestNm;
		this.rStsCnt = rStsCnt;
		this.bkgCreDtYmd = bkgCreDtYmd;
		this.ttlPckTpCd = ttlPckTpCd;
		this.wgtUtCd = wgtUtCd;
		this.stwgRmk = stwgRmk;
		this.bkgCreDt = bkgCreDt;
		this.snaccsTmlEdiCgoKndCd = snaccsTmlEdiCgoKndCd;
		this.snaccsTmlEdiStwgCd = snaccsTmlEdiStwgCd;
		this.cntrVolQty5 = cntrVolQty5;
		this.cntrVolQty4 = cntrVolQty4;
		this.awkCgoFlg = awkCgoFlg;
		this.callSgnNo = callSgnNo;
		this.shprCntCd = shprCntCd;
		this.delCd = delCd;
		this.cntrVolQty1 = cntrVolQty1;
		this.bkgSkdSeq = bkgSkdSeq;
		this.fnlDestCd = fnlDestCd;
		this.skdVoyNo = skdVoyNo;
		this.cntrVolQty3 = cntrVolQty3;
		this.etdDtYmd = etdDtYmd;
		this.cntrVolQty2 = cntrVolQty2;
		this.frtFwrdCustSeq = frtFwrdCustSeq;
		this.snaccsTmlEdiDeTermCd = snaccsTmlEdiDeTermCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.mcntrFlg = mcntrFlg;
		this.xterRmk = xterRmk;
		this.ediSndDt = ediSndDt;
		this.grsWgt = grsWgt;
		this.jpTmlVslNo = jpTmlVslNo;
		this.porCd = porCd;
		this.cntrVolQtyTot = cntrVolQtyTot;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgSkdDeltFlg = bkgSkdDeltFlg;
		this.eqSubstFlg = eqSubstFlg;
		this.porYdCd = porYdCd;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.scacCd = scacCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.podYdCd = podYdCd;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.shprCustNm = shprCustNm;
		this.rfRemark = rfRemark;
		this.ediSndOfcCd = ediSndOfcCd;
		this.etdDt = etdDt;
		this.snaccsTmlEdiCgoTpCd = snaccsTmlEdiCgoTpCd;
		this.skdDirCd = skdDirCd;
		this.cmdtNm = cmdtNm;
		this.otrNtfyYdCd = otrNtfyYdCd;
		this.socFlg = socFlg;
		this.mtyPYdNm = mtyPYdNm;
		this.cntrTpszCd5 = cntrTpszCd5;
		this.deTermCd = deTermCd;
		this.polYdCd = polYdCd;
		this.shprCustSeq = shprCustSeq;
		this.cntrTpszCd2 = cntrTpszCd2;
		this.mtyPYd = mtyPYd;
		this.cntrTpszCd1 = cntrTpszCd1;
		this.cntrTpszCd4 = cntrTpszCd4;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.snaccsTmlEdiStsCd = snaccsTmlEdiStsCd;
		this.cntrTpszCd3 = cntrTpszCd3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("snaccs_tml_edi_rcv_term_cd", getSnaccsTmlEdiRcvTermCd());
		this.hashColumns.put("edi_snd_usr_id", getEdiSndUsrId());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("snaccs_tml_edi_sts_cng_flg", getSnaccsTmlEdiStsCngFlg());
		this.hashColumns.put("vvd_chk_sts_cnt", getVvdChkStsCnt());
		this.hashColumns.put("frt_fwrd_cust_nm", getFrtFwrdCustNm());
		this.hashColumns.put("prt_flg", getPrtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("fnl_dest_nm", getFnlDestNm());
		this.hashColumns.put("r_sts_cnt", getRStsCnt());
		this.hashColumns.put("bkg_cre_dt_ymd", getBkgCreDtYmd());
		this.hashColumns.put("ttl_pck_tp_cd", getTtlPckTpCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("stwg_rmk", getStwgRmk());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("snaccs_tml_edi_cgo_knd_cd", getSnaccsTmlEdiCgoKndCd());
		this.hashColumns.put("snaccs_tml_edi_stwg_cd", getSnaccsTmlEdiStwgCd());
		this.hashColumns.put("cntr_vol_qty5", getCntrVolQty5());
		this.hashColumns.put("cntr_vol_qty4", getCntrVolQty4());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_vol_qty1", getCntrVolQty1());
		this.hashColumns.put("bkg_skd_seq", getBkgSkdSeq());
		this.hashColumns.put("fnl_dest_cd", getFnlDestCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cntr_vol_qty3", getCntrVolQty3());
		this.hashColumns.put("etd_dt_ymd", getEtdDtYmd());
		this.hashColumns.put("cntr_vol_qty2", getCntrVolQty2());
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());
		this.hashColumns.put("snaccs_tml_edi_de_term_cd", getSnaccsTmlEdiDeTermCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("mcntr_flg", getMcntrFlg());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("jp_tml_vsl_no", getJpTmlVslNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cntr_vol_qty_tot", getCntrVolQtyTot());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_skd_delt_flg", getBkgSkdDeltFlg());
		this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
		this.hashColumns.put("por_yd_cd", getPorYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("rf_remark", getRfRemark());
		this.hashColumns.put("edi_snd_ofc_cd", getEdiSndOfcCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("snaccs_tml_edi_cgo_tp_cd", getSnaccsTmlEdiCgoTpCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("otr_ntfy_yd_cd", getOtrNtfyYdCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("mty_p_yd_nm", getMtyPYdNm());
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("shpr_cust_seq", getShprCustSeq());
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());
		this.hashColumns.put("mty_p_yd", getMtyPYd());
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("snaccs_tml_edi_sts_cd", getSnaccsTmlEdiStsCd());
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("snaccs_tml_edi_rcv_term_cd", "snaccsTmlEdiRcvTermCd");
		this.hashFields.put("edi_snd_usr_id", "ediSndUsrId");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("snaccs_tml_edi_sts_cng_flg", "snaccsTmlEdiStsCngFlg");
		this.hashFields.put("vvd_chk_sts_cnt", "vvdChkStsCnt");
		this.hashFields.put("frt_fwrd_cust_nm", "frtFwrdCustNm");
		this.hashFields.put("prt_flg", "prtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("fnl_dest_nm", "fnlDestNm");
		this.hashFields.put("r_sts_cnt", "rStsCnt");
		this.hashFields.put("bkg_cre_dt_ymd", "bkgCreDtYmd");
		this.hashFields.put("ttl_pck_tp_cd", "ttlPckTpCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("stwg_rmk", "stwgRmk");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("snaccs_tml_edi_cgo_knd_cd", "snaccsTmlEdiCgoKndCd");
		this.hashFields.put("snaccs_tml_edi_stwg_cd", "snaccsTmlEdiStwgCd");
		this.hashFields.put("cntr_vol_qty5", "cntrVolQty5");
		this.hashFields.put("cntr_vol_qty4", "cntrVolQty4");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_vol_qty1", "cntrVolQty1");
		this.hashFields.put("bkg_skd_seq", "bkgSkdSeq");
		this.hashFields.put("fnl_dest_cd", "fnlDestCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cntr_vol_qty3", "cntrVolQty3");
		this.hashFields.put("etd_dt_ymd", "etdDtYmd");
		this.hashFields.put("cntr_vol_qty2", "cntrVolQty2");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("snaccs_tml_edi_de_term_cd", "snaccsTmlEdiDeTermCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("mcntr_flg", "mcntrFlg");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("jp_tml_vsl_no", "jpTmlVslNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cntr_vol_qty_tot", "cntrVolQtyTot");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_skd_delt_flg", "bkgSkdDeltFlg");
		this.hashFields.put("eq_subst_flg", "eqSubstFlg");
		this.hashFields.put("por_yd_cd", "porYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("rf_remark", "rfRemark");
		this.hashFields.put("edi_snd_ofc_cd", "ediSndOfcCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("snaccs_tml_edi_cgo_tp_cd", "snaccsTmlEdiCgoTpCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("otr_ntfy_yd_cd", "otrNtfyYdCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("mty_p_yd_nm", "mtyPYdNm");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("shpr_cust_seq", "shprCustSeq");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("mty_p_yd", "mtyPYd");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("snaccs_tml_edi_sts_cd", "snaccsTmlEdiStsCd");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dryCgoFlg
	 */
	public String getDryCgoFlg() {
		return this.dryCgoFlg;
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
	 * @return snaccsTmlEdiRcvTermCd
	 */
	public String getSnaccsTmlEdiRcvTermCd() {
		return this.snaccsTmlEdiRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndUsrId
	 */
	public String getEdiSndUsrId() {
		return this.ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return snaccsTmlEdiStsCngFlg
	 */
	public String getSnaccsTmlEdiStsCngFlg() {
		return this.snaccsTmlEdiStsCngFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdChkStsCnt
	 */
	public String getVvdChkStsCnt() {
		return this.vvdChkStsCnt;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCustNm
	 */
	public String getFrtFwrdCustNm() {
		return this.frtFwrdCustNm;
	}
	
	/**
	 * Column Info
	 * @return prtFlg
	 */
	public String getPrtFlg() {
		return this.prtFlg;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestNm
	 */
	public String getFnlDestNm() {
		return this.fnlDestNm;
	}
	
	/**
	 * Column Info
	 * @return rStsCnt
	 */
	public String getRStsCnt() {
		return this.rStsCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDtYmd
	 */
	public String getBkgCreDtYmd() {
		return this.bkgCreDtYmd;
	}
	
	/**
	 * Column Info
	 * @return ttlPckTpCd
	 */
	public String getTtlPckTpCd() {
		return this.ttlPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return stwgRmk
	 */
	public String getStwgRmk() {
		return this.stwgRmk;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return snaccsTmlEdiCgoKndCd
	 */
	public String getSnaccsTmlEdiCgoKndCd() {
		return this.snaccsTmlEdiCgoKndCd;
	}
	
	/**
	 * Column Info
	 * @return snaccsTmlEdiStwgCd
	 */
	public String getSnaccsTmlEdiStwgCd() {
		return this.snaccsTmlEdiStwgCd;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty5
	 */
	public String getCntrVolQty5() {
		return this.cntrVolQty5;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty4
	 */
	public String getCntrVolQty4() {
		return this.cntrVolQty4;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
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
	 * @return cntrVolQty1
	 */
	public String getCntrVolQty1() {
		return this.cntrVolQty1;
	}
	
	/**
	 * Column Info
	 * @return bkgSkdSeq
	 */
	public String getBkgSkdSeq() {
		return this.bkgSkdSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlDestCd
	 */
	public String getFnlDestCd() {
		return this.fnlDestCd;
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
	 * @return cntrVolQty3
	 */
	public String getCntrVolQty3() {
		return this.cntrVolQty3;
	}
	
	/**
	 * Column Info
	 * @return etdDtYmd
	 */
	public String getEtdDtYmd() {
		return this.etdDtYmd;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty2
	 */
	public String getCntrVolQty2() {
		return this.cntrVolQty2;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCustSeq
	 */
	public String getFrtFwrdCustSeq() {
		return this.frtFwrdCustSeq;
	}
	
	/**
	 * Column Info
	 * @return snaccsTmlEdiDeTermCd
	 */
	public String getSnaccsTmlEdiDeTermCd() {
		return this.snaccsTmlEdiDeTermCd;
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
	 * @return mcntrFlg
	 */
	public String getMcntrFlg() {
		return this.mcntrFlg;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
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
	 * @return jpTmlVslNo
	 */
	public String getJpTmlVslNo() {
		return this.jpTmlVslNo;
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
	 * @return cntrVolQtyTot
	 */
	public String getCntrVolQtyTot() {
		return this.cntrVolQtyTot;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgSkdDeltFlg
	 */
	public String getBkgSkdDeltFlg() {
		return this.bkgSkdDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return eqSubstFlg
	 */
	public String getEqSubstFlg() {
		return this.eqSubstFlg;
	}
	
	/**
	 * Column Info
	 * @return porYdCd
	 */
	public String getPorYdCd() {
		return this.porYdCd;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return rfRemark
	 */
	public String getRfRemark() {
		return this.rfRemark;
	}
	
	/**
	 * Column Info
	 * @return ediSndOfcCd
	 */
	public String getEdiSndOfcCd() {
		return this.ediSndOfcCd;
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
	 * @return snaccsTmlEdiCgoTpCd
	 */
	public String getSnaccsTmlEdiCgoTpCd() {
		return this.snaccsTmlEdiCgoTpCd;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return otrNtfyYdCd
	 */
	public String getOtrNtfyYdCd() {
		return this.otrNtfyYdCd;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return mtyPYdNm
	 */
	public String getMtyPYdNm() {
		return this.mtyPYdNm;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd5
	 */
	public String getCntrTpszCd5() {
		return this.cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return shprCustSeq
	 */
	public String getShprCustSeq() {
		return this.shprCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd2
	 */
	public String getCntrTpszCd2() {
		return this.cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @return mtyPYd
	 */
	public String getMtyPYd() {
		return this.mtyPYd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd1
	 */
	public String getCntrTpszCd1() {
		return this.cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd4
	 */
	public String getCntrTpszCd4() {
		return this.cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return snaccsTmlEdiStsCd
	 */
	public String getSnaccsTmlEdiStsCd() {
		return this.snaccsTmlEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd3
	 */
	public String getCntrTpszCd3() {
		return this.cntrTpszCd3;
	}
	

	/**
	 * Column Info
	 * @param dryCgoFlg
	 */
	public void setDryCgoFlg(String dryCgoFlg) {
		this.dryCgoFlg = dryCgoFlg;
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
	 * @param snaccsTmlEdiRcvTermCd
	 */
	public void setSnaccsTmlEdiRcvTermCd(String snaccsTmlEdiRcvTermCd) {
		this.snaccsTmlEdiRcvTermCd = snaccsTmlEdiRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndUsrId
	 */
	public void setEdiSndUsrId(String ediSndUsrId) {
		this.ediSndUsrId = ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param snaccsTmlEdiStsCngFlg
	 */
	public void setSnaccsTmlEdiStsCngFlg(String snaccsTmlEdiStsCngFlg) {
		this.snaccsTmlEdiStsCngFlg = snaccsTmlEdiStsCngFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdChkStsCnt
	 */
	public void setVvdChkStsCnt(String vvdChkStsCnt) {
		this.vvdChkStsCnt = vvdChkStsCnt;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCustNm
	 */
	public void setFrtFwrdCustNm(String frtFwrdCustNm) {
		this.frtFwrdCustNm = frtFwrdCustNm;
	}
	
	/**
	 * Column Info
	 * @param prtFlg
	 */
	public void setPrtFlg(String prtFlg) {
		this.prtFlg = prtFlg;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestNm
	 */
	public void setFnlDestNm(String fnlDestNm) {
		this.fnlDestNm = fnlDestNm;
	}
	
	/**
	 * Column Info
	 * @param rStsCnt
	 */
	public void setRStsCnt(String rStsCnt) {
		this.rStsCnt = rStsCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDtYmd
	 */
	public void setBkgCreDtYmd(String bkgCreDtYmd) {
		this.bkgCreDtYmd = bkgCreDtYmd;
	}
	
	/**
	 * Column Info
	 * @param ttlPckTpCd
	 */
	public void setTtlPckTpCd(String ttlPckTpCd) {
		this.ttlPckTpCd = ttlPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param stwgRmk
	 */
	public void setStwgRmk(String stwgRmk) {
		this.stwgRmk = stwgRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param snaccsTmlEdiCgoKndCd
	 */
	public void setSnaccsTmlEdiCgoKndCd(String snaccsTmlEdiCgoKndCd) {
		this.snaccsTmlEdiCgoKndCd = snaccsTmlEdiCgoKndCd;
	}
	
	/**
	 * Column Info
	 * @param snaccsTmlEdiStwgCd
	 */
	public void setSnaccsTmlEdiStwgCd(String snaccsTmlEdiStwgCd) {
		this.snaccsTmlEdiStwgCd = snaccsTmlEdiStwgCd;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty5
	 */
	public void setCntrVolQty5(String cntrVolQty5) {
		this.cntrVolQty5 = cntrVolQty5;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty4
	 */
	public void setCntrVolQty4(String cntrVolQty4) {
		this.cntrVolQty4 = cntrVolQty4;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
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
	 * @param cntrVolQty1
	 */
	public void setCntrVolQty1(String cntrVolQty1) {
		this.cntrVolQty1 = cntrVolQty1;
	}
	
	/**
	 * Column Info
	 * @param bkgSkdSeq
	 */
	public void setBkgSkdSeq(String bkgSkdSeq) {
		this.bkgSkdSeq = bkgSkdSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlDestCd
	 */
	public void setFnlDestCd(String fnlDestCd) {
		this.fnlDestCd = fnlDestCd;
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
	 * @param cntrVolQty3
	 */
	public void setCntrVolQty3(String cntrVolQty3) {
		this.cntrVolQty3 = cntrVolQty3;
	}
	
	/**
	 * Column Info
	 * @param etdDtYmd
	 */
	public void setEtdDtYmd(String etdDtYmd) {
		this.etdDtYmd = etdDtYmd;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty2
	 */
	public void setCntrVolQty2(String cntrVolQty2) {
		this.cntrVolQty2 = cntrVolQty2;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCustSeq
	 */
	public void setFrtFwrdCustSeq(String frtFwrdCustSeq) {
		this.frtFwrdCustSeq = frtFwrdCustSeq;
	}
	
	/**
	 * Column Info
	 * @param snaccsTmlEdiDeTermCd
	 */
	public void setSnaccsTmlEdiDeTermCd(String snaccsTmlEdiDeTermCd) {
		this.snaccsTmlEdiDeTermCd = snaccsTmlEdiDeTermCd;
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
	 * @param mcntrFlg
	 */
	public void setMcntrFlg(String mcntrFlg) {
		this.mcntrFlg = mcntrFlg;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
	 * @param jpTmlVslNo
	 */
	public void setJpTmlVslNo(String jpTmlVslNo) {
		this.jpTmlVslNo = jpTmlVslNo;
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
	 * @param cntrVolQtyTot
	 */
	public void setCntrVolQtyTot(String cntrVolQtyTot) {
		this.cntrVolQtyTot = cntrVolQtyTot;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgSkdDeltFlg
	 */
	public void setBkgSkdDeltFlg(String bkgSkdDeltFlg) {
		this.bkgSkdDeltFlg = bkgSkdDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param eqSubstFlg
	 */
	public void setEqSubstFlg(String eqSubstFlg) {
		this.eqSubstFlg = eqSubstFlg;
	}
	
	/**
	 * Column Info
	 * @param porYdCd
	 */
	public void setPorYdCd(String porYdCd) {
		this.porYdCd = porYdCd;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param rfRemark
	 */
	public void setRfRemark(String rfRemark) {
		this.rfRemark = rfRemark;
	}
	
	/**
	 * Column Info
	 * @param ediSndOfcCd
	 */
	public void setEdiSndOfcCd(String ediSndOfcCd) {
		this.ediSndOfcCd = ediSndOfcCd;
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
	 * @param snaccsTmlEdiCgoTpCd
	 */
	public void setSnaccsTmlEdiCgoTpCd(String snaccsTmlEdiCgoTpCd) {
		this.snaccsTmlEdiCgoTpCd = snaccsTmlEdiCgoTpCd;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param otrNtfyYdCd
	 */
	public void setOtrNtfyYdCd(String otrNtfyYdCd) {
		this.otrNtfyYdCd = otrNtfyYdCd;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param mtyPYdNm
	 */
	public void setMtyPYdNm(String mtyPYdNm) {
		this.mtyPYdNm = mtyPYdNm;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd5
	 */
	public void setCntrTpszCd5(String cntrTpszCd5) {
		this.cntrTpszCd5 = cntrTpszCd5;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param shprCustSeq
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd2
	 */
	public void setCntrTpszCd2(String cntrTpszCd2) {
		this.cntrTpszCd2 = cntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @param mtyPYd
	 */
	public void setMtyPYd(String mtyPYd) {
		this.mtyPYd = mtyPYd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd1
	 */
	public void setCntrTpszCd1(String cntrTpszCd1) {
		this.cntrTpszCd1 = cntrTpszCd1;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd4
	 */
	public void setCntrTpszCd4(String cntrTpszCd4) {
		this.cntrTpszCd4 = cntrTpszCd4;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param snaccsTmlEdiStsCd
	 */
	public void setSnaccsTmlEdiStsCd(String snaccsTmlEdiStsCd) {
		this.snaccsTmlEdiStsCd = snaccsTmlEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd3
	 */
	public void setCntrTpszCd3(String cntrTpszCd3) {
		this.cntrTpszCd3 = cntrTpszCd3;
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
		setDryCgoFlg(JSPUtil.getParameter(request, prefix + "dry_cgo_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSnaccsTmlEdiRcvTermCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_rcv_term_cd", ""));
		setEdiSndUsrId(JSPUtil.getParameter(request, prefix + "edi_snd_usr_id", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setSnaccsTmlEdiStsCngFlg(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_sts_cng_flg", ""));
		setVvdChkStsCnt(JSPUtil.getParameter(request, prefix + "vvd_chk_sts_cnt", ""));
		setFrtFwrdCustNm(JSPUtil.getParameter(request, prefix + "frt_fwrd_cust_nm", ""));
		setPrtFlg(JSPUtil.getParameter(request, prefix + "prt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFnlDestNm(JSPUtil.getParameter(request, prefix + "fnl_dest_nm", ""));
		setRStsCnt(JSPUtil.getParameter(request, prefix + "r_sts_cnt", ""));
		setBkgCreDtYmd(JSPUtil.getParameter(request, prefix + "bkg_cre_dt_ymd", ""));
		setTtlPckTpCd(JSPUtil.getParameter(request, prefix + "ttl_pck_tp_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setStwgRmk(JSPUtil.getParameter(request, prefix + "stwg_rmk", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setSnaccsTmlEdiCgoKndCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_cgo_knd_cd", ""));
		setSnaccsTmlEdiStwgCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_stwg_cd", ""));
		setCntrVolQty5(JSPUtil.getParameter(request, prefix + "cntr_vol_qty5", ""));
		setCntrVolQty4(JSPUtil.getParameter(request, prefix + "cntr_vol_qty4", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrVolQty1(JSPUtil.getParameter(request, prefix + "cntr_vol_qty1", ""));
		setBkgSkdSeq(JSPUtil.getParameter(request, prefix + "bkg_skd_seq", ""));
		setFnlDestCd(JSPUtil.getParameter(request, prefix + "fnl_dest_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCntrVolQty3(JSPUtil.getParameter(request, prefix + "cntr_vol_qty3", ""));
		setEtdDtYmd(JSPUtil.getParameter(request, prefix + "etd_dt_ymd", ""));
		setCntrVolQty2(JSPUtil.getParameter(request, prefix + "cntr_vol_qty2", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_cust_seq", ""));
		setSnaccsTmlEdiDeTermCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_de_term_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setMcntrFlg(JSPUtil.getParameter(request, prefix + "mcntr_flg", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setJpTmlVslNo(JSPUtil.getParameter(request, prefix + "jp_tml_vsl_no", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCntrVolQtyTot(JSPUtil.getParameter(request, prefix + "cntr_vol_qty_tot", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setBkgSkdDeltFlg(JSPUtil.getParameter(request, prefix + "bkg_skd_delt_flg", ""));
		setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
		setPorYdCd(JSPUtil.getParameter(request, prefix + "por_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setShprCustNm(JSPUtil.getParameter(request, prefix + "shpr_cust_nm", ""));
		setRfRemark(JSPUtil.getParameter(request, prefix + "rf_remark", ""));
		setEdiSndOfcCd(JSPUtil.getParameter(request, prefix + "edi_snd_ofc_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setSnaccsTmlEdiCgoTpCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_cgo_tp_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setOtrNtfyYdCd(JSPUtil.getParameter(request, prefix + "otr_ntfy_yd_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setMtyPYdNm(JSPUtil.getParameter(request, prefix + "mty_p_yd_nm", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd5", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setShprCustSeq(JSPUtil.getParameter(request, prefix + "shpr_cust_seq", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd2", ""));
		setMtyPYd(JSPUtil.getParameter(request, prefix + "mty_p_yd", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd1", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd4", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_cd", ""));
		setSnaccsTmlEdiStsCd(JSPUtil.getParameter(request, prefix + "snaccs_tml_edi_sts_cd", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTerminalEdiJapanBlVO[]
	 */
	public BkgTerminalEdiJapanBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgTerminalEdiJapanBlVO[]
	 */
	public BkgTerminalEdiJapanBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTerminalEdiJapanBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] snaccsTmlEdiRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_rcv_term_cd", length));
			String[] ediSndUsrId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_usr_id", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] snaccsTmlEdiStsCngFlg = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_sts_cng_flg", length));
			String[] vvdChkStsCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_chk_sts_cnt", length));
			String[] frtFwrdCustNm = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_nm", length));
			String[] prtFlg = (JSPUtil.getParameter(request, prefix	+ "prt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fnlDestNm = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_nm", length));
			String[] rStsCnt = (JSPUtil.getParameter(request, prefix	+ "r_sts_cnt", length));
			String[] bkgCreDtYmd = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt_ymd", length));
			String[] ttlPckTpCd = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_tp_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] stwgRmk = (JSPUtil.getParameter(request, prefix	+ "stwg_rmk", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] snaccsTmlEdiCgoKndCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_cgo_knd_cd", length));
			String[] snaccsTmlEdiStwgCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_stwg_cd", length));
			String[] cntrVolQty5 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty5", length));
			String[] cntrVolQty4 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty4", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrVolQty1 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty1", length));
			String[] bkgSkdSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_seq", length));
			String[] fnlDestCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cntrVolQty3 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty3", length));
			String[] etdDtYmd = (JSPUtil.getParameter(request, prefix	+ "etd_dt_ymd", length));
			String[] cntrVolQty2 = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty2", length));
			String[] frtFwrdCustSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cust_seq", length));
			String[] snaccsTmlEdiDeTermCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_de_term_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mcntrFlg = (JSPUtil.getParameter(request, prefix	+ "mcntr_flg", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] jpTmlVslNo = (JSPUtil.getParameter(request, prefix	+ "jp_tml_vsl_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cntrVolQtyTot = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty_tot", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgSkdDeltFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_delt_flg", length));
			String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix	+ "eq_subst_flg", length));
			String[] porYdCd = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] rfRemark = (JSPUtil.getParameter(request, prefix	+ "rf_remark", length));
			String[] ediSndOfcCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_ofc_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] snaccsTmlEdiCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_cgo_tp_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] otrNtfyYdCd = (JSPUtil.getParameter(request, prefix	+ "otr_ntfy_yd_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] mtyPYdNm = (JSPUtil.getParameter(request, prefix	+ "mty_p_yd_nm", length));
			String[] cntrTpszCd5 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd5", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] shprCustSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_seq", length));
			String[] cntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd2", length));
			String[] mtyPYd = (JSPUtil.getParameter(request, prefix	+ "mty_p_yd", length));
			String[] cntrTpszCd1 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd1", length));
			String[] cntrTpszCd4 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd4", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] snaccsTmlEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "snaccs_tml_edi_sts_cd", length));
			String[] cntrTpszCd3 = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd3", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgTerminalEdiJapanBlVO();
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (snaccsTmlEdiRcvTermCd[i] != null)
					model.setSnaccsTmlEdiRcvTermCd(snaccsTmlEdiRcvTermCd[i]);
				if (ediSndUsrId[i] != null)
					model.setEdiSndUsrId(ediSndUsrId[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (snaccsTmlEdiStsCngFlg[i] != null)
					model.setSnaccsTmlEdiStsCngFlg(snaccsTmlEdiStsCngFlg[i]);
				if (vvdChkStsCnt[i] != null)
					model.setVvdChkStsCnt(vvdChkStsCnt[i]);
				if (frtFwrdCustNm[i] != null)
					model.setFrtFwrdCustNm(frtFwrdCustNm[i]);
				if (prtFlg[i] != null)
					model.setPrtFlg(prtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fnlDestNm[i] != null)
					model.setFnlDestNm(fnlDestNm[i]);
				if (rStsCnt[i] != null)
					model.setRStsCnt(rStsCnt[i]);
				if (bkgCreDtYmd[i] != null)
					model.setBkgCreDtYmd(bkgCreDtYmd[i]);
				if (ttlPckTpCd[i] != null)
					model.setTtlPckTpCd(ttlPckTpCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (stwgRmk[i] != null)
					model.setStwgRmk(stwgRmk[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (snaccsTmlEdiCgoKndCd[i] != null)
					model.setSnaccsTmlEdiCgoKndCd(snaccsTmlEdiCgoKndCd[i]);
				if (snaccsTmlEdiStwgCd[i] != null)
					model.setSnaccsTmlEdiStwgCd(snaccsTmlEdiStwgCd[i]);
				if (cntrVolQty5[i] != null)
					model.setCntrVolQty5(cntrVolQty5[i]);
				if (cntrVolQty4[i] != null)
					model.setCntrVolQty4(cntrVolQty4[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrVolQty1[i] != null)
					model.setCntrVolQty1(cntrVolQty1[i]);
				if (bkgSkdSeq[i] != null)
					model.setBkgSkdSeq(bkgSkdSeq[i]);
				if (fnlDestCd[i] != null)
					model.setFnlDestCd(fnlDestCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cntrVolQty3[i] != null)
					model.setCntrVolQty3(cntrVolQty3[i]);
				if (etdDtYmd[i] != null)
					model.setEtdDtYmd(etdDtYmd[i]);
				if (cntrVolQty2[i] != null)
					model.setCntrVolQty2(cntrVolQty2[i]);
				if (frtFwrdCustSeq[i] != null)
					model.setFrtFwrdCustSeq(frtFwrdCustSeq[i]);
				if (snaccsTmlEdiDeTermCd[i] != null)
					model.setSnaccsTmlEdiDeTermCd(snaccsTmlEdiDeTermCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (mcntrFlg[i] != null)
					model.setMcntrFlg(mcntrFlg[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (jpTmlVslNo[i] != null)
					model.setJpTmlVslNo(jpTmlVslNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cntrVolQtyTot[i] != null)
					model.setCntrVolQtyTot(cntrVolQtyTot[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgSkdDeltFlg[i] != null)
					model.setBkgSkdDeltFlg(bkgSkdDeltFlg[i]);
				if (eqSubstFlg[i] != null)
					model.setEqSubstFlg(eqSubstFlg[i]);
				if (porYdCd[i] != null)
					model.setPorYdCd(porYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (rfRemark[i] != null)
					model.setRfRemark(rfRemark[i]);
				if (ediSndOfcCd[i] != null)
					model.setEdiSndOfcCd(ediSndOfcCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (snaccsTmlEdiCgoTpCd[i] != null)
					model.setSnaccsTmlEdiCgoTpCd(snaccsTmlEdiCgoTpCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (otrNtfyYdCd[i] != null)
					model.setOtrNtfyYdCd(otrNtfyYdCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (mtyPYdNm[i] != null)
					model.setMtyPYdNm(mtyPYdNm[i]);
				if (cntrTpszCd5[i] != null)
					model.setCntrTpszCd5(cntrTpszCd5[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (shprCustSeq[i] != null)
					model.setShprCustSeq(shprCustSeq[i]);
				if (cntrTpszCd2[i] != null)
					model.setCntrTpszCd2(cntrTpszCd2[i]);
				if (mtyPYd[i] != null)
					model.setMtyPYd(mtyPYd[i]);
				if (cntrTpszCd1[i] != null)
					model.setCntrTpszCd1(cntrTpszCd1[i]);
				if (cntrTpszCd4[i] != null)
					model.setCntrTpszCd4(cntrTpszCd4[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (snaccsTmlEdiStsCd[i] != null)
					model.setSnaccsTmlEdiStsCd(snaccsTmlEdiStsCd[i]);
				if (cntrTpszCd3[i] != null)
					model.setCntrTpszCd3(cntrTpszCd3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTerminalEdiJapanBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTerminalEdiJapanBlVO[]
	 */
	public BkgTerminalEdiJapanBlVO[] getBkgTerminalEdiJapanBlVOs(){
		BkgTerminalEdiJapanBlVO[] vos = (BkgTerminalEdiJapanBlVO[])models.toArray(new BkgTerminalEdiJapanBlVO[models.size()]);
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
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiRcvTermCd = this.snaccsTmlEdiRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndUsrId = this.ediSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiStsCngFlg = this.snaccsTmlEdiStsCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdChkStsCnt = this.vvdChkStsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustNm = this.frtFwrdCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtFlg = this.prtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestNm = this.fnlDestNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rStsCnt = this.rStsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDtYmd = this.bkgCreDtYmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckTpCd = this.ttlPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgRmk = this.stwgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiCgoKndCd = this.snaccsTmlEdiCgoKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiStwgCd = this.snaccsTmlEdiStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty5 = this.cntrVolQty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty4 = this.cntrVolQty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty1 = this.cntrVolQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdSeq = this.bkgSkdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestCd = this.fnlDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty3 = this.cntrVolQty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDtYmd = this.etdDtYmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty2 = this.cntrVolQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq = this.frtFwrdCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiDeTermCd = this.snaccsTmlEdiDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrFlg = this.mcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpTmlVslNo = this.jpTmlVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQtyTot = this.cntrVolQtyTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdDeltFlg = this.bkgSkdDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstFlg = this.eqSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCd = this.porYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRemark = this.rfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndOfcCd = this.ediSndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiCgoTpCd = this.snaccsTmlEdiCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrNtfyYdCd = this.otrNtfyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPYdNm = this.mtyPYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 = this.cntrTpszCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustSeq = this.shprCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 = this.cntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPYd = this.mtyPYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 = this.cntrTpszCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 = this.cntrTpszCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snaccsTmlEdiStsCd = this.snaccsTmlEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 = this.cntrTpszCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
