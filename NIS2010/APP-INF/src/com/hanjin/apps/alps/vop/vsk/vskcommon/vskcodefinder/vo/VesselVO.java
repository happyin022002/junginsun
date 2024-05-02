/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselVO.java
*@FileTitle : VesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.19 유혁 
* 1.0 Creation
* 
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리 - pageNo, totalCnt 추가
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 유혁
 * @since J2EE 1.5
 * @see ..
 */

public class VesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselVO> models = new ArrayList<VesselVO>();
	
	/* Column Info */
	private String vslDeDt = null;
	/* Column Info */
	private String bwthstRpmPwr = null;
	/* Column Info */
	private String mnEngTpDesc = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vslDpth = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Column Info */
	private String mnEngRpmPwr = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String vslSftEqCertiExpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dplCapa = null;
	/* Column Info */
	private String gnrTpDesc = null;
	/* Column Info */
	private String fbdCapa = null;
	/* Column Info */
	private String vslHgt = null;
	/* Column Info */
	private String doilCapa = null;
	/* Column Info */
	private String vslLodLineCertiExpDt = null;
	/* Column Info */
	private String vslSftRdoCertiExpDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String frshWtrCapa = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String vslHldKnt = null;
	/* Column Info */
	private String rgstPortCd = null;
	/* Column Info */
	private String lbpLen = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String clssNoRgstAreaNm = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String tlxNo = null;
	/* Column Info */
	private String cntrOpCapa = null;
	/* Column Info */
	private String piclbDesc = null;
	/* Column Info */
	private String rfRcptKnt = null;
	/* Column Info */
	private String vslOwnIndCd = null;
	/* Column Info */
	private String vslHlNo = null;
	/* Column Info */
	private String frshWtrCsm = null;
	/* Column Info */
	private String cntrDznCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String suzNetTongWgt = null;
	/* Column Info */
	private String fdrDivCd = null;
	/* Column Info */
	private String pnmNetTongWgt = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String vslDeltOfcCd = null;
	/* Column Info */
	private String smrDrftHgt = null;
	/* Column Info */
	private String rgstNo = null;
	/* Column Info */
	private String bwthstBhpPwr = null;
	/* Column Info */
	private String vslEdiNm = null;
	/* Column Info */
	private String vslRmk = null;
	/* Column Info */
	private String vslEml = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rfRcptMaxKnt = null;
	/* Column Info */
	private String loaLen = null;
	/* Column Info */
	private String vslLnchDt = null;
	/* Column Info */
	private String vslBldAreaNm = null;
	/* Column Info */
	private String vslBldrNm = null;
	/* Column Info */
	private String mnEngMkrNm = null;
	/* Column Info */
	private String vslHtchKnt = null;
	/* Column Info */
	private String gnrBhpPwr = null;
	/* Column Info */
	private String crwKnt = null;
	/* Column Info */
	private String vslCreOfcCd = null;
	/* Column Info */
	private String vslClssCd = null;
	/* Column Info */
	private String vslSftCstruCertiExpDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String maxSpd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String cntrPnmCapa = null;
	/* Column Info */
	private String gnrRpmPwr = null;
	/* Column Info */
	private String blstTnkCapa = null;
	/* Column Info */
	private String vslKrnNm = null;
	/* Column Info */
	private String vslClssNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String bwthstMkrNm = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String pnmGtWgt = null;
	/* Column Info */
	private String vslClzDt = null;
	/* Column Info */
	private String vslBldCd = null;
	/* Column Info */
	private String bwthstTpDesc = null;
	/* Column Info */
	private String suzGtWgt = null;
	/* Column Info */
	private String ecnSpd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String lgtShpTongWgt = null;
	/* Column Info */
	private String foilCapa = null;
	/* Column Info */
	private String mnEngBhpPwr = null;
	/* Column Info */
	private String vslKelLyDt = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Column Info */
	private String vslDeratCertiExpDt = null;
	/* Column Info */
	private String intlTongCertiFlg = null;
	/* Column Info */
	private String ttlTeuKnt = null;
	/* Column Info */
	private String vslWdt = null;
	/* Column Info */
	private String foilCsm = null;
	/* Column Info */
	private String vslSvcSpd = null;
	/* Column Info */
	private String gnrMkrNm = null;
	/* Column Info */
	private String doilCsm = null;
	/* Column Info */
	private String vslClssFlg = null;
	/* Column Info */
	private String incDelVsl = null;
	/* Column Info */
	private String vslLoclNm = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String totalCnt = null;
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VesselVO() {}

	public VesselVO(String ibflag, String pagerows, String vslCd, String vslClssCd, String vslEngNm, String vslKrnNm, String foilCapa, String doilCapa, String frshWtrCapa, String callSgnNo, String rgstNo, String phnNo, String faxNo, String tlxNo, String vslEml, String piclbDesc, String rgstPortCd, String clssNoRgstAreaNm, String vslClssNo, String vslBldrNm, String loaLen, String lbpLen, String vslWdt, String vslDpth, String smrDrftHgt, String dwtWgt, String lgtShpTongWgt, String grsRgstTongWgt, String netRgstTongWgt, String pnmGtWgt, String pnmNetTongWgt, String suzGtWgt, String suzNetTongWgt, String mnEngMkrNm, String mnEngTpDesc, String mnEngBhpPwr, String vslOwnIndCd, String vslRgstCntCd, String vslBldCd, String crrCd, String fdrDivCd, String vslSvcSpd, String maxSpd, String ecnSpd, String crwKnt, String cntrDznCapa, String cntrOpCapa, String cntrPnmCapa, String cntrVslClssCapa, String rfRcptKnt, String rfRcptMaxKnt, String fbdCapa, String dplCapa, String blstTnkCapa, String foilCsm, String doilCsm, String frshWtrCsm, String mnEngRpmPwr, String gnrRpmPwr, String vslHgt, String rgstDt, String vslEdiNm, String coCd, String vslClzDt, String vslCreOfcCd, String vslDeltOfcCd, String vslBldAreaNm, String gnrMkrNm, String gnrTpDesc, String gnrBhpPwr, String bwthstMkrNm, String bwthstTpDesc, String bwthstBhpPwr, String bwthstRpmPwr, String lloydNo, String vslLnchDt, String vslDeDt, String vslKelLyDt, String vslHlNo, String ttlTeuKnt, String vslHtchKnt, String vslHldKnt, String vslRmk, String intlTongCertiFlg, String vslSftCstruCertiExpDt, String vslSftRdoCertiExpDt, String vslSftEqCertiExpDt, String vslLodLineCertiExpDt, String vslDeratCertiExpDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String vslClssFlg, String incDelVsl, String vslLoclNm, String pageNo, String totalCnt) {
		this.vslDeDt = vslDeDt;
		this.bwthstRpmPwr = bwthstRpmPwr;
		this.mnEngTpDesc = mnEngTpDesc;
		this.vslCd = vslCd;
		this.vslDpth = vslDpth;
		this.dwtWgt = dwtWgt;
		this.mnEngRpmPwr = mnEngRpmPwr;
		this.crrCd = crrCd;
		this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
		this.pagerows = pagerows;
		this.dplCapa = dplCapa;
		this.gnrTpDesc = gnrTpDesc;
		this.fbdCapa = fbdCapa;
		this.vslHgt = vslHgt;
		this.doilCapa = doilCapa;
		this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
		this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
		this.updUsrId = updUsrId;
		this.rgstDt = rgstDt;
		this.frshWtrCapa = frshWtrCapa;
		this.phnNo = phnNo;
		this.vslHldKnt = vslHldKnt;
		this.rgstPortCd = rgstPortCd;
		this.lbpLen = lbpLen;
		this.callSgnNo = callSgnNo;
		this.clssNoRgstAreaNm = clssNoRgstAreaNm;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.tlxNo = tlxNo;
		this.cntrOpCapa = cntrOpCapa;
		this.piclbDesc = piclbDesc;
		this.rfRcptKnt = rfRcptKnt;
		this.vslOwnIndCd = vslOwnIndCd;
		this.vslHlNo = vslHlNo;
		this.frshWtrCsm = frshWtrCsm;
		this.cntrDznCapa = cntrDznCapa;
		this.creUsrId = creUsrId;
		this.lloydNo = lloydNo;
		this.suzNetTongWgt = suzNetTongWgt;
		this.fdrDivCd = fdrDivCd;
		this.pnmNetTongWgt = pnmNetTongWgt;
		this.faxNo = faxNo;
		this.vslDeltOfcCd = vslDeltOfcCd;
		this.smrDrftHgt = smrDrftHgt;
		this.rgstNo = rgstNo;
		this.bwthstBhpPwr = bwthstBhpPwr;
		this.vslEdiNm = vslEdiNm;
		this.vslRmk = vslRmk;
		this.vslEml = vslEml;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.rfRcptMaxKnt = rfRcptMaxKnt;
		this.loaLen = loaLen;
		this.vslLnchDt = vslLnchDt;
		this.vslBldAreaNm = vslBldAreaNm;
		this.vslBldrNm = vslBldrNm;
		this.mnEngMkrNm = mnEngMkrNm;
		this.vslHtchKnt = vslHtchKnt;
		this.gnrBhpPwr = gnrBhpPwr;
		this.crwKnt = crwKnt;
		this.vslCreOfcCd = vslCreOfcCd;
		this.vslClssCd = vslClssCd;
		this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
		this.ibflag = ibflag;
		this.maxSpd = maxSpd;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.cntrPnmCapa = cntrPnmCapa;
		this.gnrRpmPwr = gnrRpmPwr;
		this.blstTnkCapa = blstTnkCapa;
		this.vslKrnNm = vslKrnNm;
		this.vslClssNo = vslClssNo;
		this.updDt = updDt;
		this.netRgstTongWgt = netRgstTongWgt;
		this.bwthstMkrNm = bwthstMkrNm;
		this.coCd = coCd;
		this.pnmGtWgt = pnmGtWgt;
		this.vslClzDt = vslClzDt;
		this.vslBldCd = vslBldCd;
		this.bwthstTpDesc = bwthstTpDesc;
		this.suzGtWgt = suzGtWgt;
		this.ecnSpd = ecnSpd;
		this.eaiEvntDt = eaiEvntDt;
		this.lgtShpTongWgt = lgtShpTongWgt;
		this.foilCapa = foilCapa;
		this.mnEngBhpPwr = mnEngBhpPwr;
		this.vslKelLyDt = vslKelLyDt;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.vslDeratCertiExpDt = vslDeratCertiExpDt;
		this.intlTongCertiFlg = intlTongCertiFlg;
		this.ttlTeuKnt = ttlTeuKnt;
		this.vslWdt = vslWdt;
		this.foilCsm = foilCsm;
		this.vslSvcSpd = vslSvcSpd;
		this.gnrMkrNm = gnrMkrNm;
		this.doilCsm = doilCsm;
		this.vslClssFlg = vslClssFlg;
		this.incDelVsl = incDelVsl;
		this.vslLoclNm = vslLoclNm;
		this.pageNo = pageNo;
		this.totalCnt = totalCnt;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_de_dt", getVslDeDt());
		this.hashColumns.put("bwthst_rpm_pwr", getBwthstRpmPwr());
		this.hashColumns.put("mn_eng_tp_desc", getMnEngTpDesc());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vsl_dpth", getVslDpth());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("mn_eng_rpm_pwr", getMnEngRpmPwr());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("vsl_sft_eq_certi_exp_dt", getVslSftEqCertiExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dpl_capa", getDplCapa());
		this.hashColumns.put("gnr_tp_desc", getGnrTpDesc());
		this.hashColumns.put("fbd_capa", getFbdCapa());
		this.hashColumns.put("vsl_hgt", getVslHgt());
		this.hashColumns.put("doil_capa", getDoilCapa());
		this.hashColumns.put("vsl_lod_line_certi_exp_dt", getVslLodLineCertiExpDt());
		this.hashColumns.put("vsl_sft_rdo_certi_exp_dt", getVslSftRdoCertiExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("frsh_wtr_capa", getFrshWtrCapa());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("vsl_hld_knt", getVslHldKnt());
		this.hashColumns.put("rgst_port_cd", getRgstPortCd());
		this.hashColumns.put("lbp_len", getLbpLen());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("clss_no_rgst_area_nm", getClssNoRgstAreaNm());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("tlx_no", getTlxNo());
		this.hashColumns.put("cntr_op_capa", getCntrOpCapa());
		this.hashColumns.put("piclb_desc", getPiclbDesc());
		this.hashColumns.put("rf_rcpt_knt", getRfRcptKnt());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("vsl_hl_no", getVslHlNo());
		this.hashColumns.put("frsh_wtr_csm", getFrshWtrCsm());
		this.hashColumns.put("cntr_dzn_capa", getCntrDznCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
		this.hashColumns.put("fdr_div_cd", getFdrDivCd());
		this.hashColumns.put("pnm_net_tong_wgt", getPnmNetTongWgt());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("vsl_delt_ofc_cd", getVslDeltOfcCd());
		this.hashColumns.put("smr_drft_hgt", getSmrDrftHgt());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("bwthst_bhp_pwr", getBwthstBhpPwr());
		this.hashColumns.put("vsl_edi_nm", getVslEdiNm());
		this.hashColumns.put("vsl_rmk", getVslRmk());
		this.hashColumns.put("vsl_eml", getVslEml());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rf_rcpt_max_knt", getRfRcptMaxKnt());
		this.hashColumns.put("loa_len", getLoaLen());
		this.hashColumns.put("vsl_lnch_dt", getVslLnchDt());
		this.hashColumns.put("vsl_bld_area_nm", getVslBldAreaNm());
		this.hashColumns.put("vsl_bldr_nm", getVslBldrNm());
		this.hashColumns.put("mn_eng_mkr_nm", getMnEngMkrNm());
		this.hashColumns.put("vsl_htch_knt", getVslHtchKnt());
		this.hashColumns.put("gnr_bhp_pwr", getGnrBhpPwr());
		this.hashColumns.put("crw_knt", getCrwKnt());
		this.hashColumns.put("vsl_cre_ofc_cd", getVslCreOfcCd());
		this.hashColumns.put("vsl_clss_cd", getVslClssCd());
		this.hashColumns.put("vsl_sft_cstru_certi_exp_dt", getVslSftCstruCertiExpDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_spd", getMaxSpd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("cntr_pnm_capa", getCntrPnmCapa());
		this.hashColumns.put("gnr_rpm_pwr", getGnrRpmPwr());
		this.hashColumns.put("blst_tnk_capa", getBlstTnkCapa());
		this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
		this.hashColumns.put("vsl_clss_no", getVslClssNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("bwthst_mkr_nm", getBwthstMkrNm());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("pnm_gt_wgt", getPnmGtWgt());
		this.hashColumns.put("vsl_clz_dt", getVslClzDt());
		this.hashColumns.put("vsl_bld_cd", getVslBldCd());
		this.hashColumns.put("bwthst_tp_desc", getBwthstTpDesc());
		this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
		this.hashColumns.put("ecn_spd", getEcnSpd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("lgt_shp_tong_wgt", getLgtShpTongWgt());
		this.hashColumns.put("foil_capa", getFoilCapa());
		this.hashColumns.put("mn_eng_bhp_pwr", getMnEngBhpPwr());
		this.hashColumns.put("vsl_kel_ly_dt", getVslKelLyDt());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("vsl_derat_certi_exp_dt", getVslDeratCertiExpDt());
		this.hashColumns.put("intl_tong_certi_flg", getIntlTongCertiFlg());
		this.hashColumns.put("ttl_teu_knt", getTtlTeuKnt());
		this.hashColumns.put("vsl_wdt", getVslWdt());
		this.hashColumns.put("foil_csm", getFoilCsm());
		this.hashColumns.put("vsl_svc_spd", getVslSvcSpd());
		this.hashColumns.put("gnr_mkr_nm", getGnrMkrNm());
		this.hashColumns.put("doil_csm", getDoilCsm());
		this.hashColumns.put("vsl_clss_flg", getVslClssFlg());
		this.hashColumns.put("inc_del_vsl", getIncDelVsl());
		this.hashColumns.put("vsl_locl_nm", getVslLoclNm());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("total_cnt", getTotalCnt());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_de_dt", "vslDeDt");
		this.hashFields.put("bwthst_rpm_pwr", "bwthstRpmPwr");
		this.hashFields.put("mn_eng_tp_desc", "mnEngTpDesc");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_dpth", "vslDpth");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("mn_eng_rpm_pwr", "mnEngRpmPwr");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("vsl_sft_eq_certi_exp_dt", "vslSftEqCertiExpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dpl_capa", "dplCapa");
		this.hashFields.put("gnr_tp_desc", "gnrTpDesc");
		this.hashFields.put("fbd_capa", "fbdCapa");
		this.hashFields.put("vsl_hgt", "vslHgt");
		this.hashFields.put("doil_capa", "doilCapa");
		this.hashFields.put("vsl_lod_line_certi_exp_dt", "vslLodLineCertiExpDt");
		this.hashFields.put("vsl_sft_rdo_certi_exp_dt", "vslSftRdoCertiExpDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("frsh_wtr_capa", "frshWtrCapa");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("vsl_hld_knt", "vslHldKnt");
		this.hashFields.put("rgst_port_cd", "rgstPortCd");
		this.hashFields.put("lbp_len", "lbpLen");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("clss_no_rgst_area_nm", "clssNoRgstAreaNm");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("tlx_no", "tlxNo");
		this.hashFields.put("cntr_op_capa", "cntrOpCapa");
		this.hashFields.put("piclb_desc", "piclbDesc");
		this.hashFields.put("rf_rcpt_knt", "rfRcptKnt");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("vsl_hl_no", "vslHlNo");
		this.hashFields.put("frsh_wtr_csm", "frshWtrCsm");
		this.hashFields.put("cntr_dzn_capa", "cntrDznCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
		this.hashFields.put("fdr_div_cd", "fdrDivCd");
		this.hashFields.put("pnm_net_tong_wgt", "pnmNetTongWgt");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("vsl_delt_ofc_cd", "vslDeltOfcCd");
		this.hashFields.put("smr_drft_hgt", "smrDrftHgt");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("bwthst_bhp_pwr", "bwthstBhpPwr");
		this.hashFields.put("vsl_edi_nm", "vslEdiNm");
		this.hashFields.put("vsl_rmk", "vslRmk");
		this.hashFields.put("vsl_eml", "vslEml");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rf_rcpt_max_knt", "rfRcptMaxKnt");
		this.hashFields.put("loa_len", "loaLen");
		this.hashFields.put("vsl_lnch_dt", "vslLnchDt");
		this.hashFields.put("vsl_bld_area_nm", "vslBldAreaNm");
		this.hashFields.put("vsl_bldr_nm", "vslBldrNm");
		this.hashFields.put("mn_eng_mkr_nm", "mnEngMkrNm");
		this.hashFields.put("vsl_htch_knt", "vslHtchKnt");
		this.hashFields.put("gnr_bhp_pwr", "gnrBhpPwr");
		this.hashFields.put("crw_knt", "crwKnt");
		this.hashFields.put("vsl_cre_ofc_cd", "vslCreOfcCd");
		this.hashFields.put("vsl_clss_cd", "vslClssCd");
		this.hashFields.put("vsl_sft_cstru_certi_exp_dt", "vslSftCstruCertiExpDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_spd", "maxSpd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("cntr_pnm_capa", "cntrPnmCapa");
		this.hashFields.put("gnr_rpm_pwr", "gnrRpmPwr");
		this.hashFields.put("blst_tnk_capa", "blstTnkCapa");
		this.hashFields.put("vsl_krn_nm", "vslKrnNm");
		this.hashFields.put("vsl_clss_no", "vslClssNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("bwthst_mkr_nm", "bwthstMkrNm");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("pnm_gt_wgt", "pnmGtWgt");
		this.hashFields.put("vsl_clz_dt", "vslClzDt");
		this.hashFields.put("vsl_bld_cd", "vslBldCd");
		this.hashFields.put("bwthst_tp_desc", "bwthstTpDesc");
		this.hashFields.put("suz_gt_wgt", "suzGtWgt");
		this.hashFields.put("ecn_spd", "ecnSpd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("lgt_shp_tong_wgt", "lgtShpTongWgt");
		this.hashFields.put("foil_capa", "foilCapa");
		this.hashFields.put("mn_eng_bhp_pwr", "mnEngBhpPwr");
		this.hashFields.put("vsl_kel_ly_dt", "vslKelLyDt");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("vsl_derat_certi_exp_dt", "vslDeratCertiExpDt");
		this.hashFields.put("intl_tong_certi_flg", "intlTongCertiFlg");
		this.hashFields.put("ttl_teu_knt", "ttlTeuKnt");
		this.hashFields.put("vsl_wdt", "vslWdt");
		this.hashFields.put("foil_csm", "foilCsm");
		this.hashFields.put("vsl_svc_spd", "vslSvcSpd");
		this.hashFields.put("gnr_mkr_nm", "gnrMkrNm");
		this.hashFields.put("doil_csm", "doilCsm");
		this.hashFields.put("vsl_clss_flg", "vslClssFlg");
		this.hashFields.put("inc_del_vsl", "incDelVsl");
		this.hashFields.put("vsl_locl_nm", "vslLoclNm");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("total_cnt", "totalCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDeDt
	 */
	public String getVslDeDt() {
		return this.vslDeDt;
	}
	
	/**
	 * Column Info
	 * @return bwthstRpmPwr
	 */
	public String getBwthstRpmPwr() {
		return this.bwthstRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return mnEngTpDesc
	 */
	public String getMnEngTpDesc() {
		return this.mnEngTpDesc;
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
	 * @return vslDpth
	 */
	public String getVslDpth() {
		return this.vslDpth;
	}
	
	/**
	 * Column Info
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
	}
	
	/**
	 * Column Info
	 * @return mnEngRpmPwr
	 */
	public String getMnEngRpmPwr() {
		return this.mnEngRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return vslSftEqCertiExpDt
	 */
	public String getVslSftEqCertiExpDt() {
		return this.vslSftEqCertiExpDt;
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
	 * @return dplCapa
	 */
	public String getDplCapa() {
		return this.dplCapa;
	}
	
	/**
	 * Column Info
	 * @return gnrTpDesc
	 */
	public String getGnrTpDesc() {
		return this.gnrTpDesc;
	}
	
	/**
	 * Column Info
	 * @return fbdCapa
	 */
	public String getFbdCapa() {
		return this.fbdCapa;
	}
	
	/**
	 * Column Info
	 * @return vslHgt
	 */
	public String getVslHgt() {
		return this.vslHgt;
	}
	
	/**
	 * Column Info
	 * @return doilCapa
	 */
	public String getDoilCapa() {
		return this.doilCapa;
	}
	
	/**
	 * Column Info
	 * @return vslLodLineCertiExpDt
	 */
	public String getVslLodLineCertiExpDt() {
		return this.vslLodLineCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return vslSftRdoCertiExpDt
	 */
	public String getVslSftRdoCertiExpDt() {
		return this.vslSftRdoCertiExpDt;
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
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return frshWtrCapa
	 */
	public String getFrshWtrCapa() {
		return this.frshWtrCapa;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return vslHldKnt
	 */
	public String getVslHldKnt() {
		return this.vslHldKnt;
	}
	
	/**
	 * Column Info
	 * @return rgstPortCd
	 */
	public String getRgstPortCd() {
		return this.rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @return lbpLen
	 */
	public String getLbpLen() {
		return this.lbpLen;
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
	 * @return clssNoRgstAreaNm
	 */
	public String getClssNoRgstAreaNm() {
		return this.clssNoRgstAreaNm;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return tlxNo
	 */
	public String getTlxNo() {
		return this.tlxNo;
	}
	
	/**
	 * Column Info
	 * @return cntrOpCapa
	 */
	public String getCntrOpCapa() {
		return this.cntrOpCapa;
	}
	
	/**
	 * Column Info
	 * @return piclbDesc
	 */
	public String getPiclbDesc() {
		return this.piclbDesc;
	}
	
	/**
	 * Column Info
	 * @return rfRcptKnt
	 */
	public String getRfRcptKnt() {
		return this.rfRcptKnt;
	}
	
	/**
	 * Column Info
	 * @return vslOwnIndCd
	 */
	public String getVslOwnIndCd() {
		return this.vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @return vslHlNo
	 */
	public String getVslHlNo() {
		return this.vslHlNo;
	}
	
	/**
	 * Column Info
	 * @return frshWtrCsm
	 */
	public String getFrshWtrCsm() {
		return this.frshWtrCsm;
	}
	
	/**
	 * Column Info
	 * @return cntrDznCapa
	 */
	public String getCntrDznCapa() {
		return this.cntrDznCapa;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return suzNetTongWgt
	 */
	public String getSuzNetTongWgt() {
		return this.suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return fdrDivCd
	 */
	public String getFdrDivCd() {
		return this.fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @return pnmNetTongWgt
	 */
	public String getPnmNetTongWgt() {
		return this.pnmNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return vslDeltOfcCd
	 */
	public String getVslDeltOfcCd() {
		return this.vslDeltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return smrDrftHgt
	 */
	public String getSmrDrftHgt() {
		return this.smrDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	
	/**
	 * Column Info
	 * @return bwthstBhpPwr
	 */
	public String getBwthstBhpPwr() {
		return this.bwthstBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return vslEdiNm
	 */
	public String getVslEdiNm() {
		return this.vslEdiNm;
	}
	
	/**
	 * Column Info
	 * @return vslRmk
	 */
	public String getVslRmk() {
		return this.vslRmk;
	}
	
	/**
	 * Column Info
	 * @return vslEml
	 */
	public String getVslEml() {
		return this.vslEml;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return rfRcptMaxKnt
	 */
	public String getRfRcptMaxKnt() {
		return this.rfRcptMaxKnt;
	}
	
	/**
	 * Column Info
	 * @return loaLen
	 */
	public String getLoaLen() {
		return this.loaLen;
	}
	
	/**
	 * Column Info
	 * @return vslLnchDt
	 */
	public String getVslLnchDt() {
		return this.vslLnchDt;
	}
	
	/**
	 * Column Info
	 * @return vslBldAreaNm
	 */
	public String getVslBldAreaNm() {
		return this.vslBldAreaNm;
	}
	
	/**
	 * Column Info
	 * @return vslBldrNm
	 */
	public String getVslBldrNm() {
		return this.vslBldrNm;
	}
	
	/**
	 * Column Info
	 * @return mnEngMkrNm
	 */
	public String getMnEngMkrNm() {
		return this.mnEngMkrNm;
	}
	
	/**
	 * Column Info
	 * @return vslHtchKnt
	 */
	public String getVslHtchKnt() {
		return this.vslHtchKnt;
	}
	
	/**
	 * Column Info
	 * @return gnrBhpPwr
	 */
	public String getGnrBhpPwr() {
		return this.gnrBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return crwKnt
	 */
	public String getCrwKnt() {
		return this.crwKnt;
	}
	
	/**
	 * Column Info
	 * @return vslCreOfcCd
	 */
	public String getVslCreOfcCd() {
		return this.vslCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCd
	 */
	public String getVslClssCd() {
		return this.vslClssCd;
	}
	
	/**
	 * Column Info
	 * @return vslSftCstruCertiExpDt
	 */
	public String getVslSftCstruCertiExpDt() {
		return this.vslSftCstruCertiExpDt;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return maxSpd
	 */
	public String getMaxSpd() {
		return this.maxSpd;
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
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPnmCapa
	 */
	public String getCntrPnmCapa() {
		return this.cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @return gnrRpmPwr
	 */
	public String getGnrRpmPwr() {
		return this.gnrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @return blstTnkCapa
	 */
	public String getBlstTnkCapa() {
		return this.blstTnkCapa;
	}
	
	/**
	 * Column Info
	 * @return vslKrnNm
	 */
	public String getVslKrnNm() {
		return this.vslKrnNm;
	}
	
	/**
	 * Column Info
	 * @return vslClssNo
	 */
	public String getVslClssNo() {
		return this.vslClssNo;
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
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return bwthstMkrNm
	 */
	public String getBwthstMkrNm() {
		return this.bwthstMkrNm;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return pnmGtWgt
	 */
	public String getPnmGtWgt() {
		return this.pnmGtWgt;
	}
	
	/**
	 * Column Info
	 * @return vslClzDt
	 */
	public String getVslClzDt() {
		return this.vslClzDt;
	}
	
	/**
	 * Column Info
	 * @return vslBldCd
	 */
	public String getVslBldCd() {
		return this.vslBldCd;
	}
	
	/**
	 * Column Info
	 * @return bwthstTpDesc
	 */
	public String getBwthstTpDesc() {
		return this.bwthstTpDesc;
	}
	
	/**
	 * Column Info
	 * @return suzGtWgt
	 */
	public String getSuzGtWgt() {
		return this.suzGtWgt;
	}
	
	/**
	 * Column Info
	 * @return ecnSpd
	 */
	public String getEcnSpd() {
		return this.ecnSpd;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return lgtShpTongWgt
	 */
	public String getLgtShpTongWgt() {
		return this.lgtShpTongWgt;
	}
	
	/**
	 * Column Info
	 * @return foilCapa
	 */
	public String getFoilCapa() {
		return this.foilCapa;
	}
	
	/**
	 * Column Info
	 * @return mnEngBhpPwr
	 */
	public String getMnEngBhpPwr() {
		return this.mnEngBhpPwr;
	}
	
	/**
	 * Column Info
	 * @return vslKelLyDt
	 */
	public String getVslKelLyDt() {
		return this.vslKelLyDt;
	}
	
	/**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslDeratCertiExpDt
	 */
	public String getVslDeratCertiExpDt() {
		return this.vslDeratCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return intlTongCertiFlg
	 */
	public String getIntlTongCertiFlg() {
		return this.intlTongCertiFlg;
	}
	
	/**
	 * Column Info
	 * @return ttlTeuKnt
	 */
	public String getTtlTeuKnt() {
		return this.ttlTeuKnt;
	}
	
	/**
	 * Column Info
	 * @return vslWdt
	 */
	public String getVslWdt() {
		return this.vslWdt;
	}
	
	/**
	 * Column Info
	 * @return foilCsm
	 */
	public String getFoilCsm() {
		return this.foilCsm;
	}
	
	/**
	 * Column Info
	 * @return vslSvcSpd
	 */
	public String getVslSvcSpd() {
		return this.vslSvcSpd;
	}
	
	/**
	 * Column Info
	 * @return gnrMkrNm
	 */
	public String getGnrMkrNm() {
		return this.gnrMkrNm;
	}
	
	/**
	 * Column Info
	 * @return doilCsm
	 */
	public String getDoilCsm() {
		return this.doilCsm;
	}
	
	/**
	 * Column Info
	 * @return vslClssFlg
	 */
	public String getVslClssFlg() {
		return this.vslClssFlg;
	}
	
	/**
	 * Column Info
	 * @return incDelVsl
	 */
	public String getIncDelVsl() {
		return this.incDelVsl;
	}
	
	/**
	 * Column Info
	 * @return vslLoclNm
	 */
	public String getVslLoclNm() {
		return this.vslLoclNm;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}

	/**
	 * Column Info
	 * @param vslDeDt
	 */
	public void setVslDeDt(String vslDeDt) {
		this.vslDeDt = vslDeDt;
	}
	
	/**
	 * Column Info
	 * @param bwthstRpmPwr
	 */
	public void setBwthstRpmPwr(String bwthstRpmPwr) {
		this.bwthstRpmPwr = bwthstRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param mnEngTpDesc
	 */
	public void setMnEngTpDesc(String mnEngTpDesc) {
		this.mnEngTpDesc = mnEngTpDesc;
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
	 * @param vslDpth
	 */
	public void setVslDpth(String vslDpth) {
		this.vslDpth = vslDpth;
	}
	
	/**
	 * Column Info
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
	}
	
	/**
	 * Column Info
	 * @param mnEngRpmPwr
	 */
	public void setMnEngRpmPwr(String mnEngRpmPwr) {
		this.mnEngRpmPwr = mnEngRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param vslSftEqCertiExpDt
	 */
	public void setVslSftEqCertiExpDt(String vslSftEqCertiExpDt) {
		this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
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
	 * @param dplCapa
	 */
	public void setDplCapa(String dplCapa) {
		this.dplCapa = dplCapa;
	}
	
	/**
	 * Column Info
	 * @param gnrTpDesc
	 */
	public void setGnrTpDesc(String gnrTpDesc) {
		this.gnrTpDesc = gnrTpDesc;
	}
	
	/**
	 * Column Info
	 * @param fbdCapa
	 */
	public void setFbdCapa(String fbdCapa) {
		this.fbdCapa = fbdCapa;
	}
	
	/**
	 * Column Info
	 * @param vslHgt
	 */
	public void setVslHgt(String vslHgt) {
		this.vslHgt = vslHgt;
	}
	
	/**
	 * Column Info
	 * @param doilCapa
	 */
	public void setDoilCapa(String doilCapa) {
		this.doilCapa = doilCapa;
	}
	
	/**
	 * Column Info
	 * @param vslLodLineCertiExpDt
	 */
	public void setVslLodLineCertiExpDt(String vslLodLineCertiExpDt) {
		this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param vslSftRdoCertiExpDt
	 */
	public void setVslSftRdoCertiExpDt(String vslSftRdoCertiExpDt) {
		this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
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
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param frshWtrCapa
	 */
	public void setFrshWtrCapa(String frshWtrCapa) {
		this.frshWtrCapa = frshWtrCapa;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param vslHldKnt
	 */
	public void setVslHldKnt(String vslHldKnt) {
		this.vslHldKnt = vslHldKnt;
	}
	
	/**
	 * Column Info
	 * @param rgstPortCd
	 */
	public void setRgstPortCd(String rgstPortCd) {
		this.rgstPortCd = rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @param lbpLen
	 */
	public void setLbpLen(String lbpLen) {
		this.lbpLen = lbpLen;
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
	 * @param clssNoRgstAreaNm
	 */
	public void setClssNoRgstAreaNm(String clssNoRgstAreaNm) {
		this.clssNoRgstAreaNm = clssNoRgstAreaNm;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param tlxNo
	 */
	public void setTlxNo(String tlxNo) {
		this.tlxNo = tlxNo;
	}
	
	/**
	 * Column Info
	 * @param cntrOpCapa
	 */
	public void setCntrOpCapa(String cntrOpCapa) {
		this.cntrOpCapa = cntrOpCapa;
	}
	
	/**
	 * Column Info
	 * @param piclbDesc
	 */
	public void setPiclbDesc(String piclbDesc) {
		this.piclbDesc = piclbDesc;
	}
	
	/**
	 * Column Info
	 * @param rfRcptKnt
	 */
	public void setRfRcptKnt(String rfRcptKnt) {
		this.rfRcptKnt = rfRcptKnt;
	}
	
	/**
	 * Column Info
	 * @param vslOwnIndCd
	 */
	public void setVslOwnIndCd(String vslOwnIndCd) {
		this.vslOwnIndCd = vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @param vslHlNo
	 */
	public void setVslHlNo(String vslHlNo) {
		this.vslHlNo = vslHlNo;
	}
	
	/**
	 * Column Info
	 * @param frshWtrCsm
	 */
	public void setFrshWtrCsm(String frshWtrCsm) {
		this.frshWtrCsm = frshWtrCsm;
	}
	
	/**
	 * Column Info
	 * @param cntrDznCapa
	 */
	public void setCntrDznCapa(String cntrDznCapa) {
		this.cntrDznCapa = cntrDznCapa;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param suzNetTongWgt
	 */
	public void setSuzNetTongWgt(String suzNetTongWgt) {
		this.suzNetTongWgt = suzNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param fdrDivCd
	 */
	public void setFdrDivCd(String fdrDivCd) {
		this.fdrDivCd = fdrDivCd;
	}
	
	/**
	 * Column Info
	 * @param pnmNetTongWgt
	 */
	public void setPnmNetTongWgt(String pnmNetTongWgt) {
		this.pnmNetTongWgt = pnmNetTongWgt;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param vslDeltOfcCd
	 */
	public void setVslDeltOfcCd(String vslDeltOfcCd) {
		this.vslDeltOfcCd = vslDeltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param smrDrftHgt
	 */
	public void setSmrDrftHgt(String smrDrftHgt) {
		this.smrDrftHgt = smrDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Column Info
	 * @param bwthstBhpPwr
	 */
	public void setBwthstBhpPwr(String bwthstBhpPwr) {
		this.bwthstBhpPwr = bwthstBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param vslEdiNm
	 */
	public void setVslEdiNm(String vslEdiNm) {
		this.vslEdiNm = vslEdiNm;
	}
	
	/**
	 * Column Info
	 * @param vslRmk
	 */
	public void setVslRmk(String vslRmk) {
		this.vslRmk = vslRmk;
	}
	
	/**
	 * Column Info
	 * @param vslEml
	 */
	public void setVslEml(String vslEml) {
		this.vslEml = vslEml;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param rfRcptMaxKnt
	 */
	public void setRfRcptMaxKnt(String rfRcptMaxKnt) {
		this.rfRcptMaxKnt = rfRcptMaxKnt;
	}
	
	/**
	 * Column Info
	 * @param loaLen
	 */
	public void setLoaLen(String loaLen) {
		this.loaLen = loaLen;
	}
	
	/**
	 * Column Info
	 * @param vslLnchDt
	 */
	public void setVslLnchDt(String vslLnchDt) {
		this.vslLnchDt = vslLnchDt;
	}
	
	/**
	 * Column Info
	 * @param vslBldAreaNm
	 */
	public void setVslBldAreaNm(String vslBldAreaNm) {
		this.vslBldAreaNm = vslBldAreaNm;
	}
	
	/**
	 * Column Info
	 * @param vslBldrNm
	 */
	public void setVslBldrNm(String vslBldrNm) {
		this.vslBldrNm = vslBldrNm;
	}
	
	/**
	 * Column Info
	 * @param mnEngMkrNm
	 */
	public void setMnEngMkrNm(String mnEngMkrNm) {
		this.mnEngMkrNm = mnEngMkrNm;
	}
	
	/**
	 * Column Info
	 * @param vslHtchKnt
	 */
	public void setVslHtchKnt(String vslHtchKnt) {
		this.vslHtchKnt = vslHtchKnt;
	}
	
	/**
	 * Column Info
	 * @param gnrBhpPwr
	 */
	public void setGnrBhpPwr(String gnrBhpPwr) {
		this.gnrBhpPwr = gnrBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param crwKnt
	 */
	public void setCrwKnt(String crwKnt) {
		this.crwKnt = crwKnt;
	}
	
	/**
	 * Column Info
	 * @param vslCreOfcCd
	 */
	public void setVslCreOfcCd(String vslCreOfcCd) {
		this.vslCreOfcCd = vslCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCd
	 */
	public void setVslClssCd(String vslClssCd) {
		this.vslClssCd = vslClssCd;
	}
	
	/**
	 * Column Info
	 * @param vslSftCstruCertiExpDt
	 */
	public void setVslSftCstruCertiExpDt(String vslSftCstruCertiExpDt) {
		this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param maxSpd
	 */
	public void setMaxSpd(String maxSpd) {
		this.maxSpd = maxSpd;
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
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPnmCapa
	 */
	public void setCntrPnmCapa(String cntrPnmCapa) {
		this.cntrPnmCapa = cntrPnmCapa;
	}
	
	/**
	 * Column Info
	 * @param gnrRpmPwr
	 */
	public void setGnrRpmPwr(String gnrRpmPwr) {
		this.gnrRpmPwr = gnrRpmPwr;
	}
	
	/**
	 * Column Info
	 * @param blstTnkCapa
	 */
	public void setBlstTnkCapa(String blstTnkCapa) {
		this.blstTnkCapa = blstTnkCapa;
	}
	
	/**
	 * Column Info
	 * @param vslKrnNm
	 */
	public void setVslKrnNm(String vslKrnNm) {
		this.vslKrnNm = vslKrnNm;
	}
	
	/**
	 * Column Info
	 * @param vslClssNo
	 */
	public void setVslClssNo(String vslClssNo) {
		this.vslClssNo = vslClssNo;
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
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param bwthstMkrNm
	 */
	public void setBwthstMkrNm(String bwthstMkrNm) {
		this.bwthstMkrNm = bwthstMkrNm;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param pnmGtWgt
	 */
	public void setPnmGtWgt(String pnmGtWgt) {
		this.pnmGtWgt = pnmGtWgt;
	}
	
	/**
	 * Column Info
	 * @param vslClzDt
	 */
	public void setVslClzDt(String vslClzDt) {
		this.vslClzDt = vslClzDt;
	}
	
	/**
	 * Column Info
	 * @param vslBldCd
	 */
	public void setVslBldCd(String vslBldCd) {
		this.vslBldCd = vslBldCd;
	}
	
	/**
	 * Column Info
	 * @param bwthstTpDesc
	 */
	public void setBwthstTpDesc(String bwthstTpDesc) {
		this.bwthstTpDesc = bwthstTpDesc;
	}
	
	/**
	 * Column Info
	 * @param suzGtWgt
	 */
	public void setSuzGtWgt(String suzGtWgt) {
		this.suzGtWgt = suzGtWgt;
	}
	
	/**
	 * Column Info
	 * @param ecnSpd
	 */
	public void setEcnSpd(String ecnSpd) {
		this.ecnSpd = ecnSpd;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param lgtShpTongWgt
	 */
	public void setLgtShpTongWgt(String lgtShpTongWgt) {
		this.lgtShpTongWgt = lgtShpTongWgt;
	}
	
	/**
	 * Column Info
	 * @param foilCapa
	 */
	public void setFoilCapa(String foilCapa) {
		this.foilCapa = foilCapa;
	}
	
	/**
	 * Column Info
	 * @param mnEngBhpPwr
	 */
	public void setMnEngBhpPwr(String mnEngBhpPwr) {
		this.mnEngBhpPwr = mnEngBhpPwr;
	}
	
	/**
	 * Column Info
	 * @param vslKelLyDt
	 */
	public void setVslKelLyDt(String vslKelLyDt) {
		this.vslKelLyDt = vslKelLyDt;
	}
	
	/**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslDeratCertiExpDt
	 */
	public void setVslDeratCertiExpDt(String vslDeratCertiExpDt) {
		this.vslDeratCertiExpDt = vslDeratCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param intlTongCertiFlg
	 */
	public void setIntlTongCertiFlg(String intlTongCertiFlg) {
		this.intlTongCertiFlg = intlTongCertiFlg;
	}
	
	/**
	 * Column Info
	 * @param ttlTeuKnt
	 */
	public void setTtlTeuKnt(String ttlTeuKnt) {
		this.ttlTeuKnt = ttlTeuKnt;
	}
	
	/**
	 * Column Info
	 * @param vslWdt
	 */
	public void setVslWdt(String vslWdt) {
		this.vslWdt = vslWdt;
	}
	
	/**
	 * Column Info
	 * @param foilCsm
	 */
	public void setFoilCsm(String foilCsm) {
		this.foilCsm = foilCsm;
	}
	
	/**
	 * Column Info
	 * @param vslSvcSpd
	 */
	public void setVslSvcSpd(String vslSvcSpd) {
		this.vslSvcSpd = vslSvcSpd;
	}
	
	/**
	 * Column Info
	 * @param gnrMkrNm
	 */
	public void setGnrMkrNm(String gnrMkrNm) {
		this.gnrMkrNm = gnrMkrNm;
	}
	
	/**
	 * Column Info
	 * @param doilCsm
	 */
	public void setDoilCsm(String doilCsm) {
		this.doilCsm = doilCsm;
	}
	
	/**
	 * Column Info
	 * @param vslClssFlg
	 */
	public void setVslClssFlg(String vslClssFlg) {
		this.vslClssFlg = vslClssFlg;
	}
	
	/**
	 * Column Info
	 * @param incDelVsl
	 */
	public void setIncDelVsl(String incDelVsl) {
		this.incDelVsl = incDelVsl;
	}
	
	/**
	 * Column Info
	 * @param vslLoclNm
	 */
	public void setVslLoclNm(String vslLoclNm) {
		this.vslLoclNm = vslLoclNm;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslDeDt(JSPUtil.getParameter(request, "vsl_de_dt", ""));
		setBwthstRpmPwr(JSPUtil.getParameter(request, "bwthst_rpm_pwr", ""));
		setMnEngTpDesc(JSPUtil.getParameter(request, "mn_eng_tp_desc", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVslDpth(JSPUtil.getParameter(request, "vsl_dpth", ""));
		setDwtWgt(JSPUtil.getParameter(request, "dwt_wgt", ""));
		setMnEngRpmPwr(JSPUtil.getParameter(request, "mn_eng_rpm_pwr", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setVslSftEqCertiExpDt(JSPUtil.getParameter(request, "vsl_sft_eq_certi_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDplCapa(JSPUtil.getParameter(request, "dpl_capa", ""));
		setGnrTpDesc(JSPUtil.getParameter(request, "gnr_tp_desc", ""));
		setFbdCapa(JSPUtil.getParameter(request, "fbd_capa", ""));
		setVslHgt(JSPUtil.getParameter(request, "vsl_hgt", ""));
		setDoilCapa(JSPUtil.getParameter(request, "doil_capa", ""));
		setVslLodLineCertiExpDt(JSPUtil.getParameter(request, "vsl_lod_line_certi_exp_dt", ""));
		setVslSftRdoCertiExpDt(JSPUtil.getParameter(request, "vsl_sft_rdo_certi_exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setFrshWtrCapa(JSPUtil.getParameter(request, "frsh_wtr_capa", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setVslHldKnt(JSPUtil.getParameter(request, "vsl_hld_knt", ""));
		setRgstPortCd(JSPUtil.getParameter(request, "rgst_port_cd", ""));
		setLbpLen(JSPUtil.getParameter(request, "lbp_len", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setClssNoRgstAreaNm(JSPUtil.getParameter(request, "clss_no_rgst_area_nm", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, "grs_rgst_tong_wgt", ""));
		setTlxNo(JSPUtil.getParameter(request, "tlx_no", ""));
		setCntrOpCapa(JSPUtil.getParameter(request, "cntr_op_capa", ""));
		setPiclbDesc(JSPUtil.getParameter(request, "piclb_desc", ""));
		setRfRcptKnt(JSPUtil.getParameter(request, "rf_rcpt_knt", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, "vsl_own_ind_cd", ""));
		setVslHlNo(JSPUtil.getParameter(request, "vsl_hl_no", ""));
		setFrshWtrCsm(JSPUtil.getParameter(request, "frsh_wtr_csm", ""));
		setCntrDznCapa(JSPUtil.getParameter(request, "cntr_dzn_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setLloydNo(JSPUtil.getParameter(request, "lloyd_no", ""));
		setSuzNetTongWgt(JSPUtil.getParameter(request, "suz_net_tong_wgt", ""));
		setFdrDivCd(JSPUtil.getParameter(request, "fdr_div_cd", ""));
		setPnmNetTongWgt(JSPUtil.getParameter(request, "pnm_net_tong_wgt", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setVslDeltOfcCd(JSPUtil.getParameter(request, "vsl_delt_ofc_cd", ""));
		setSmrDrftHgt(JSPUtil.getParameter(request, "smr_drft_hgt", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
		setBwthstBhpPwr(JSPUtil.getParameter(request, "bwthst_bhp_pwr", ""));
		setVslEdiNm(JSPUtil.getParameter(request, "vsl_edi_nm", ""));
		setVslRmk(JSPUtil.getParameter(request, "vsl_rmk", ""));
		setVslEml(JSPUtil.getParameter(request, "vsl_eml", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRfRcptMaxKnt(JSPUtil.getParameter(request, "rf_rcpt_max_knt", ""));
		setLoaLen(JSPUtil.getParameter(request, "loa_len", ""));
		setVslLnchDt(JSPUtil.getParameter(request, "vsl_lnch_dt", ""));
		setVslBldAreaNm(JSPUtil.getParameter(request, "vsl_bld_area_nm", ""));
		setVslBldrNm(JSPUtil.getParameter(request, "vsl_bldr_nm", ""));
		setMnEngMkrNm(JSPUtil.getParameter(request, "mn_eng_mkr_nm", ""));
		setVslHtchKnt(JSPUtil.getParameter(request, "vsl_htch_knt", ""));
		setGnrBhpPwr(JSPUtil.getParameter(request, "gnr_bhp_pwr", ""));
		setCrwKnt(JSPUtil.getParameter(request, "crw_knt", ""));
		setVslCreOfcCd(JSPUtil.getParameter(request, "vsl_cre_ofc_cd", ""));
		setVslClssCd(JSPUtil.getParameter(request, "vsl_clss_cd", ""));
		setVslSftCstruCertiExpDt(JSPUtil.getParameter(request, "vsl_sft_cstru_certi_exp_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMaxSpd(JSPUtil.getParameter(request, "max_spd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setCntrPnmCapa(JSPUtil.getParameter(request, "cntr_pnm_capa", ""));
		setGnrRpmPwr(JSPUtil.getParameter(request, "gnr_rpm_pwr", ""));
		setBlstTnkCapa(JSPUtil.getParameter(request, "blst_tnk_capa", ""));
		setVslKrnNm(JSPUtil.getParameter(request, "vsl_krn_nm", ""));
		setVslClssNo(JSPUtil.getParameter(request, "vsl_clss_no", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, "net_rgst_tong_wgt", ""));
		setBwthstMkrNm(JSPUtil.getParameter(request, "bwthst_mkr_nm", ""));
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setPnmGtWgt(JSPUtil.getParameter(request, "pnm_gt_wgt", ""));
		setVslClzDt(JSPUtil.getParameter(request, "vsl_clz_dt", ""));
		setVslBldCd(JSPUtil.getParameter(request, "vsl_bld_cd", ""));
		setBwthstTpDesc(JSPUtil.getParameter(request, "bwthst_tp_desc", ""));
		setSuzGtWgt(JSPUtil.getParameter(request, "suz_gt_wgt", ""));
		setEcnSpd(JSPUtil.getParameter(request, "ecn_spd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setLgtShpTongWgt(JSPUtil.getParameter(request, "lgt_shp_tong_wgt", ""));
		setFoilCapa(JSPUtil.getParameter(request, "foil_capa", ""));
		setMnEngBhpPwr(JSPUtil.getParameter(request, "mn_eng_bhp_pwr", ""));
		setVslKelLyDt(JSPUtil.getParameter(request, "vsl_kel_ly_dt", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, "cntr_vsl_clss_capa", ""));
		setVslDeratCertiExpDt(JSPUtil.getParameter(request, "vsl_derat_certi_exp_dt", ""));
		setIntlTongCertiFlg(JSPUtil.getParameter(request, "intl_tong_certi_flg", ""));
		setTtlTeuKnt(JSPUtil.getParameter(request, "ttl_teu_knt", ""));
		setVslWdt(JSPUtil.getParameter(request, "vsl_wdt", ""));
		setFoilCsm(JSPUtil.getParameter(request, "foil_csm", ""));
		setVslSvcSpd(JSPUtil.getParameter(request, "vsl_svc_spd", ""));
		setGnrMkrNm(JSPUtil.getParameter(request, "gnr_mkr_nm", ""));
		setDoilCsm(JSPUtil.getParameter(request, "doil_csm", ""));
		setVslClssFlg(JSPUtil.getParameter(request, "vsl_clss_flg", ""));
		setIncDelVsl(JSPUtil.getParameter(request, "inc_del_vsl", ""));
		setVslLoclNm(JSPUtil.getParameter(request, "vsl_locl_nm", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return VesselVO[]
	 */
	public VesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselVO[]
	 */
	public VesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDeDt = (JSPUtil.getParameter(request, prefix	+ "vsl_de_dt".trim(), length));
			String[] bwthstRpmPwr = (JSPUtil.getParameter(request, prefix	+ "bwthst_rpm_pwr".trim(), length));
			String[] mnEngTpDesc = (JSPUtil.getParameter(request, prefix	+ "mn_eng_tp_desc".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] vslDpth = (JSPUtil.getParameter(request, prefix	+ "vsl_dpth".trim(), length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt".trim(), length));
			String[] mnEngRpmPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_rpm_pwr".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] vslSftEqCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_eq_certi_exp_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] dplCapa = (JSPUtil.getParameter(request, prefix	+ "dpl_capa".trim(), length));
			String[] gnrTpDesc = (JSPUtil.getParameter(request, prefix	+ "gnr_tp_desc".trim(), length));
			String[] fbdCapa = (JSPUtil.getParameter(request, prefix	+ "fbd_capa".trim(), length));
			String[] vslHgt = (JSPUtil.getParameter(request, prefix	+ "vsl_hgt".trim(), length));
			String[] doilCapa = (JSPUtil.getParameter(request, prefix	+ "doil_capa".trim(), length));
			String[] vslLodLineCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_lod_line_certi_exp_dt".trim(), length));
			String[] vslSftRdoCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_rdo_certi_exp_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt".trim(), length));
			String[] frshWtrCapa = (JSPUtil.getParameter(request, prefix	+ "frsh_wtr_capa".trim(), length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no".trim(), length));
			String[] vslHldKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_hld_knt".trim(), length));
			String[] rgstPortCd = (JSPUtil.getParameter(request, prefix	+ "rgst_port_cd".trim(), length));
			String[] lbpLen = (JSPUtil.getParameter(request, prefix	+ "lbp_len".trim(), length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no".trim(), length));
			String[] clssNoRgstAreaNm = (JSPUtil.getParameter(request, prefix	+ "clss_no_rgst_area_nm".trim(), length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt".trim(), length));
			String[] tlxNo = (JSPUtil.getParameter(request, prefix	+ "tlx_no".trim(), length));
			String[] cntrOpCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_op_capa".trim(), length));
			String[] piclbDesc = (JSPUtil.getParameter(request, prefix	+ "piclb_desc".trim(), length));
			String[] rfRcptKnt = (JSPUtil.getParameter(request, prefix	+ "rf_rcpt_knt".trim(), length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd".trim(), length));
			String[] vslHlNo = (JSPUtil.getParameter(request, prefix	+ "vsl_hl_no".trim(), length));
			String[] frshWtrCsm = (JSPUtil.getParameter(request, prefix	+ "frsh_wtr_csm".trim(), length));
			String[] cntrDznCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_dzn_capa".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no".trim(), length));
			String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "suz_net_tong_wgt".trim(), length));
			String[] fdrDivCd = (JSPUtil.getParameter(request, prefix	+ "fdr_div_cd".trim(), length));
			String[] pnmNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "pnm_net_tong_wgt".trim(), length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no".trim(), length));
			String[] vslDeltOfcCd = (JSPUtil.getParameter(request, prefix	+ "vsl_delt_ofc_cd".trim(), length));
			String[] smrDrftHgt = (JSPUtil.getParameter(request, prefix	+ "smr_drft_hgt".trim(), length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no".trim(), length));
			String[] bwthstBhpPwr = (JSPUtil.getParameter(request, prefix	+ "bwthst_bhp_pwr".trim(), length));
			String[] vslEdiNm = (JSPUtil.getParameter(request, prefix	+ "vsl_edi_nm".trim(), length));
			String[] vslRmk = (JSPUtil.getParameter(request, prefix	+ "vsl_rmk".trim(), length));
			String[] vslEml = (JSPUtil.getParameter(request, prefix	+ "vsl_eml".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] rfRcptMaxKnt = (JSPUtil.getParameter(request, prefix	+ "rf_rcpt_max_knt".trim(), length));
			String[] loaLen = (JSPUtil.getParameter(request, prefix	+ "loa_len".trim(), length));
			String[] vslLnchDt = (JSPUtil.getParameter(request, prefix	+ "vsl_lnch_dt".trim(), length));
			String[] vslBldAreaNm = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_area_nm".trim(), length));
			String[] vslBldrNm = (JSPUtil.getParameter(request, prefix	+ "vsl_bldr_nm".trim(), length));
			String[] mnEngMkrNm = (JSPUtil.getParameter(request, prefix	+ "mn_eng_mkr_nm".trim(), length));
			String[] vslHtchKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_htch_knt".trim(), length));
			String[] gnrBhpPwr = (JSPUtil.getParameter(request, prefix	+ "gnr_bhp_pwr".trim(), length));
			String[] crwKnt = (JSPUtil.getParameter(request, prefix	+ "crw_knt".trim(), length));
			String[] vslCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cre_ofc_cd".trim(), length));
			String[] vslClssCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_cd".trim(), length));
			String[] vslSftCstruCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_cstru_certi_exp_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] maxSpd = (JSPUtil.getParameter(request, prefix	+ "max_spd".trim(), length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm".trim(), length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd".trim(), length));
			String[] cntrPnmCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_pnm_capa".trim(), length));
			String[] gnrRpmPwr = (JSPUtil.getParameter(request, prefix	+ "gnr_rpm_pwr".trim(), length));
			String[] blstTnkCapa = (JSPUtil.getParameter(request, prefix	+ "blst_tnk_capa".trim(), length));
			String[] vslKrnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_krn_nm".trim(), length));
			String[] vslClssNo = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_no".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt".trim(), length));
			String[] bwthstMkrNm = (JSPUtil.getParameter(request, prefix	+ "bwthst_mkr_nm".trim(), length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd".trim(), length));
			String[] pnmGtWgt = (JSPUtil.getParameter(request, prefix	+ "pnm_gt_wgt".trim(), length));
			String[] vslClzDt = (JSPUtil.getParameter(request, prefix	+ "vsl_clz_dt".trim(), length));
			String[] vslBldCd = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_cd".trim(), length));
			String[] bwthstTpDesc = (JSPUtil.getParameter(request, prefix	+ "bwthst_tp_desc".trim(), length));
			String[] suzGtWgt = (JSPUtil.getParameter(request, prefix	+ "suz_gt_wgt".trim(), length));
			String[] ecnSpd = (JSPUtil.getParameter(request, prefix	+ "ecn_spd".trim(), length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt".trim(), length));
			String[] lgtShpTongWgt = (JSPUtil.getParameter(request, prefix	+ "lgt_shp_tong_wgt".trim(), length));
			String[] foilCapa = (JSPUtil.getParameter(request, prefix	+ "foil_capa".trim(), length));
			String[] mnEngBhpPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_bhp_pwr".trim(), length));
			String[] vslKelLyDt = (JSPUtil.getParameter(request, prefix	+ "vsl_kel_ly_dt".trim(), length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa".trim(), length));
			String[] vslDeratCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_derat_certi_exp_dt".trim(), length));
			String[] intlTongCertiFlg = (JSPUtil.getParameter(request, prefix	+ "intl_tong_certi_flg".trim(), length));
			String[] ttlTeuKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_teu_knt".trim(), length));
			String[] vslWdt = (JSPUtil.getParameter(request, prefix	+ "vsl_wdt".trim(), length));
			String[] foilCsm = (JSPUtil.getParameter(request, prefix	+ "foil_csm".trim(), length));
			String[] vslSvcSpd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_spd".trim(), length));
			String[] gnrMkrNm = (JSPUtil.getParameter(request, prefix	+ "gnr_mkr_nm".trim(), length));
			String[] doilCsm = (JSPUtil.getParameter(request, prefix	+ "doil_csm".trim(), length));
			String[] vslClssFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_flg".trim(), length));
			String[] incDelVsl = (JSPUtil.getParameter(request, prefix	+ "inc_del_vsl".trim(), length));
			String[] vslLoclNm = (JSPUtil.getParameter(request, prefix	+ "vsl_locl_nm".trim(), length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no".trim(), length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselVO();
				if (vslDeDt[i] != null)
					model.setVslDeDt(vslDeDt[i]);
				if (bwthstRpmPwr[i] != null)
					model.setBwthstRpmPwr(bwthstRpmPwr[i]);
				if (mnEngTpDesc[i] != null)
					model.setMnEngTpDesc(mnEngTpDesc[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vslDpth[i] != null)
					model.setVslDpth(vslDpth[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (mnEngRpmPwr[i] != null)
					model.setMnEngRpmPwr(mnEngRpmPwr[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (vslSftEqCertiExpDt[i] != null)
					model.setVslSftEqCertiExpDt(vslSftEqCertiExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dplCapa[i] != null)
					model.setDplCapa(dplCapa[i]);
				if (gnrTpDesc[i] != null)
					model.setGnrTpDesc(gnrTpDesc[i]);
				if (fbdCapa[i] != null)
					model.setFbdCapa(fbdCapa[i]);
				if (vslHgt[i] != null)
					model.setVslHgt(vslHgt[i]);
				if (doilCapa[i] != null)
					model.setDoilCapa(doilCapa[i]);
				if (vslLodLineCertiExpDt[i] != null)
					model.setVslLodLineCertiExpDt(vslLodLineCertiExpDt[i]);
				if (vslSftRdoCertiExpDt[i] != null)
					model.setVslSftRdoCertiExpDt(vslSftRdoCertiExpDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (frshWtrCapa[i] != null)
					model.setFrshWtrCapa(frshWtrCapa[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (vslHldKnt[i] != null)
					model.setVslHldKnt(vslHldKnt[i]);
				if (rgstPortCd[i] != null)
					model.setRgstPortCd(rgstPortCd[i]);
				if (lbpLen[i] != null)
					model.setLbpLen(lbpLen[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (clssNoRgstAreaNm[i] != null)
					model.setClssNoRgstAreaNm(clssNoRgstAreaNm[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (tlxNo[i] != null)
					model.setTlxNo(tlxNo[i]);
				if (cntrOpCapa[i] != null)
					model.setCntrOpCapa(cntrOpCapa[i]);
				if (piclbDesc[i] != null)
					model.setPiclbDesc(piclbDesc[i]);
				if (rfRcptKnt[i] != null)
					model.setRfRcptKnt(rfRcptKnt[i]);
				if (vslOwnIndCd[i] != null)
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (vslHlNo[i] != null)
					model.setVslHlNo(vslHlNo[i]);
				if (frshWtrCsm[i] != null)
					model.setFrshWtrCsm(frshWtrCsm[i]);
				if (cntrDznCapa[i] != null)
					model.setCntrDznCapa(cntrDznCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (suzNetTongWgt[i] != null)
					model.setSuzNetTongWgt(suzNetTongWgt[i]);
				if (fdrDivCd[i] != null)
					model.setFdrDivCd(fdrDivCd[i]);
				if (pnmNetTongWgt[i] != null)
					model.setPnmNetTongWgt(pnmNetTongWgt[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (vslDeltOfcCd[i] != null)
					model.setVslDeltOfcCd(vslDeltOfcCd[i]);
				if (smrDrftHgt[i] != null)
					model.setSmrDrftHgt(smrDrftHgt[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (bwthstBhpPwr[i] != null)
					model.setBwthstBhpPwr(bwthstBhpPwr[i]);
				if (vslEdiNm[i] != null)
					model.setVslEdiNm(vslEdiNm[i]);
				if (vslRmk[i] != null)
					model.setVslRmk(vslRmk[i]);
				if (vslEml[i] != null)
					model.setVslEml(vslEml[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rfRcptMaxKnt[i] != null)
					model.setRfRcptMaxKnt(rfRcptMaxKnt[i]);
				if (loaLen[i] != null)
					model.setLoaLen(loaLen[i]);
				if (vslLnchDt[i] != null)
					model.setVslLnchDt(vslLnchDt[i]);
				if (vslBldAreaNm[i] != null)
					model.setVslBldAreaNm(vslBldAreaNm[i]);
				if (vslBldrNm[i] != null)
					model.setVslBldrNm(vslBldrNm[i]);
				if (mnEngMkrNm[i] != null)
					model.setMnEngMkrNm(mnEngMkrNm[i]);
				if (vslHtchKnt[i] != null)
					model.setVslHtchKnt(vslHtchKnt[i]);
				if (gnrBhpPwr[i] != null)
					model.setGnrBhpPwr(gnrBhpPwr[i]);
				if (crwKnt[i] != null)
					model.setCrwKnt(crwKnt[i]);
				if (vslCreOfcCd[i] != null)
					model.setVslCreOfcCd(vslCreOfcCd[i]);
				if (vslClssCd[i] != null)
					model.setVslClssCd(vslClssCd[i]);
				if (vslSftCstruCertiExpDt[i] != null)
					model.setVslSftCstruCertiExpDt(vslSftCstruCertiExpDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxSpd[i] != null)
					model.setMaxSpd(maxSpd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (cntrPnmCapa[i] != null)
					model.setCntrPnmCapa(cntrPnmCapa[i]);
				if (gnrRpmPwr[i] != null)
					model.setGnrRpmPwr(gnrRpmPwr[i]);
				if (blstTnkCapa[i] != null)
					model.setBlstTnkCapa(blstTnkCapa[i]);
				if (vslKrnNm[i] != null)
					model.setVslKrnNm(vslKrnNm[i]);
				if (vslClssNo[i] != null)
					model.setVslClssNo(vslClssNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (bwthstMkrNm[i] != null)
					model.setBwthstMkrNm(bwthstMkrNm[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (pnmGtWgt[i] != null)
					model.setPnmGtWgt(pnmGtWgt[i]);
				if (vslClzDt[i] != null)
					model.setVslClzDt(vslClzDt[i]);
				if (vslBldCd[i] != null)
					model.setVslBldCd(vslBldCd[i]);
				if (bwthstTpDesc[i] != null)
					model.setBwthstTpDesc(bwthstTpDesc[i]);
				if (suzGtWgt[i] != null)
					model.setSuzGtWgt(suzGtWgt[i]);
				if (ecnSpd[i] != null)
					model.setEcnSpd(ecnSpd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (lgtShpTongWgt[i] != null)
					model.setLgtShpTongWgt(lgtShpTongWgt[i]);
				if (foilCapa[i] != null)
					model.setFoilCapa(foilCapa[i]);
				if (mnEngBhpPwr[i] != null)
					model.setMnEngBhpPwr(mnEngBhpPwr[i]);
				if (vslKelLyDt[i] != null)
					model.setVslKelLyDt(vslKelLyDt[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (vslDeratCertiExpDt[i] != null)
					model.setVslDeratCertiExpDt(vslDeratCertiExpDt[i]);
				if (intlTongCertiFlg[i] != null)
					model.setIntlTongCertiFlg(intlTongCertiFlg[i]);
				if (ttlTeuKnt[i] != null)
					model.setTtlTeuKnt(ttlTeuKnt[i]);
				if (vslWdt[i] != null)
					model.setVslWdt(vslWdt[i]);
				if (foilCsm[i] != null)
					model.setFoilCsm(foilCsm[i]);
				if (vslSvcSpd[i] != null)
					model.setVslSvcSpd(vslSvcSpd[i]);
				if (gnrMkrNm[i] != null)
					model.setGnrMkrNm(gnrMkrNm[i]);
				if (doilCsm[i] != null)
					model.setDoilCsm(doilCsm[i]);
				if (vslClssFlg[i] != null)
					model.setVslClssFlg(vslClssFlg[i]);
				if (incDelVsl[i] != null)
					model.setIncDelVsl(incDelVsl[i]);
				if (vslLoclNm[i] != null)
					model.setVslLoclNm(vslLoclNm[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return VesselVO[]
	 */
	public VesselVO[] getVesselVOs(){
		VesselVO[] vos = (VesselVO[])models.toArray(new VesselVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.vslDeDt = this.vslDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstRpmPwr = this.bwthstRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngTpDesc = this.mnEngTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDpth = this.vslDpth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngRpmPwr = this.mnEngRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftEqCertiExpDt = this.vslSftEqCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dplCapa = this.dplCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrTpDesc = this.gnrTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fbdCapa = this.fbdCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHgt = this.vslHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCapa = this.doilCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLodLineCertiExpDt = this.vslLodLineCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftRdoCertiExpDt = this.vslSftRdoCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frshWtrCapa = this.frshWtrCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHldKnt = this.vslHldKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstPortCd = this.rgstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbpLen = this.lbpLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssNoRgstAreaNm = this.clssNoRgstAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tlxNo = this.tlxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOpCapa = this.cntrOpCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.piclbDesc = this.piclbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRcptKnt = this.rfRcptKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHlNo = this.vslHlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frshWtrCsm = this.frshWtrCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDznCapa = this.cntrDznCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzNetTongWgt = this.suzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrDivCd = this.fdrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmNetTongWgt = this.pnmNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeltOfcCd = this.vslDeltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smrDrftHgt = this.smrDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstBhpPwr = this.bwthstBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEdiNm = this.vslEdiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRmk = this.vslRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEml = this.vslEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRcptMaxKnt = this.rfRcptMaxKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loaLen = this.loaLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLnchDt = this.vslLnchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldAreaNm = this.vslBldAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldrNm = this.vslBldrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngMkrNm = this.mnEngMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHtchKnt = this.vslHtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrBhpPwr = this.gnrBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crwKnt = this.crwKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCreOfcCd = this.vslCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCd = this.vslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftCstruCertiExpDt = this.vslSftCstruCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpd = this.maxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPnmCapa = this.cntrPnmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrRpmPwr = this.gnrRpmPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blstTnkCapa = this.blstTnkCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKrnNm = this.vslKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssNo = this.vslClssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstMkrNm = this.bwthstMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmGtWgt = this.pnmGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClzDt = this.vslClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldCd = this.vslBldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwthstTpDesc = this.bwthstTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzGtWgt = this.suzGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecnSpd = this.ecnSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgtShpTongWgt = this.lgtShpTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCapa = this.foilCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngBhpPwr = this.mnEngBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKelLyDt = this.vslKelLyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeratCertiExpDt = this.vslDeratCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlTongCertiFlg = this.intlTongCertiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTeuKnt = this.ttlTeuKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslWdt = this.vslWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCsm = this.foilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcSpd = this.vslSvcSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnrMkrNm = this.gnrMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCsm = this.doilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssFlg = this.vslClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incDelVsl = this.incDelVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLoclNm = this.vslLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
