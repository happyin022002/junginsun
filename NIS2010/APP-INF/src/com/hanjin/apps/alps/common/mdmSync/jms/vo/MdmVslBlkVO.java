/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MdmVslBlkVO.java
*@FileTitle : MdmVslBlkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.27 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.mdmSync.jms.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmVslBlkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmVslBlkVO> models = new ArrayList<MdmVslBlkVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tropDwtWgt = null;
	/* Column Info */
	private String ldnWgtSpd2 = null;
	/* Column Info */
	private String ldnWgtSpd1 = null;
	/* Column Info */
	private String smrTpcTonWgt = null;
	/* Column Info */
	private String htFoilCsm = null;
	/* Column Info */
	private String vslCapaUtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String wntDwtWgt = null;
	/* Column Info */
	private String lnchDt = null;
	/* Column Info */
	private String doilCapa = null;
	/* Column Info */
	private String vslOwnCustNm = null;
	/* Column Info */
	private String vslClssFlg = null;
	/* Column Info */
	private String loaUtCd = null;
	/* Column Info */
	private String pmpOilKndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String clnOilKndCd = null;
	/* Column Info */
	private String frshWtrCapa = null;
	/* Column Info */
	private String vslCgoGrNm = null;
	/* Column Info */
	private String portIdleDoilTonCsm = null;
	/* Column Info */
	private String blkMnEngTpCd = null;
	/* Column Info */
	private String vslHldKnt = null;
	/* Column Info */
	private String rgstPortCd = null;
	/* Column Info */
	private String wntTpcTonWgt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String vslOwnIndCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String blkVslClssCd = null;
	/* Column Info */
	private String suzNetTongWgt = null;
	/* Column Info */
	private String tropTpcTonWgt = null;
	/* Column Info */
	private String pnmNetTongWgt = null;
	/* Column Info */
	private String smrDrftHgt = null;
	/* Column Info */
	private String bailTongCapa = null;
	/* Column Info */
	private String smrDwtWgt = null;
	/* Column Info */
	private String entTpCd = null;
	/* Column Info */
	private String vslBmWdt = null;
	/* Column Info */
	private String vslRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String imoNo = null;
	/* Column Info */
	private String wntDrftHgt = null;
	/* Column Info */
	private String vslOwnCustCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String loaLen = null;
	/* Column Info */
	private String mnEngMkrNm = null;
	/* Column Info */
	private String vslBldrNm = null;
	/* Column Info */
	private String vslHtchKnt = null;
	/* Column Info */
	private String grnTongCapa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslBldDt = null;
	/* Column Info */
	private String vslOwnCustSeq = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslBunkUtCd = null;
	/* Column Info */
	private String foilBlstCsm1 = null;
	/* Column Info */
	private String vslDwtUtCd = null;
	/* Column Info */
	private String foilBlstCsm2 = null;
	/* Column Info */
	private String vslKrnNm = null;
	/* Column Info */
	private String tropDrftHgt = null;
	/* Column Info */
	private String blkVslDeDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String seaDoilTonCsm = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String pnmGtWgt = null;
	/* Column Info */
	private String blstWgtSpd2 = null;
	/* Column Info */
	private String pmpOilCsm = null;
	/* Column Info */
	private String blstWgtSpd1 = null;
	/* Column Info */
	private String suzGtWgt = null;
	/* Column Info */
	private String clnOilCsm = null;
	/* Column Info */
	private String portWrkDoilTonCsm = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String lgtShpTongWgt = null;
	/* Column Info */
	private String vslDrftUtCd = null;
	/* Column Info */
	private String blkCrrTpCd = null;
	/* Column Info */
	private String foilCapa = null;
	/* Column Info */
	private String mnEngBhpPwr = null;
	/* Column Info */
	private String tnkTongCapa = null;
	/* Column Info */
	private String portFoilTonCsm = null;
	/* Column Info */
	private String consTonWgt = null;
	/* Column Info */
	private String foilLdnCsm2 = null;
	/* Column Info */
	private String vslBmUtCd = null;
	/* Column Info */
	private String foilLdnCsm1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmVslBlkVO() {}

	public MdmVslBlkVO(String ibflag, String pagerows, String vslCd, String vslClssFlg, String vslEngNm, String vslKrnNm, String foilCapa, String doilCapa, String frshWtrCapa, String grnTongCapa, String bailTongCapa, String tnkTongCapa, String callSgnNo, String rgstPortCd, String vslBldrNm, String loaLen, String smrDrftHgt, String lgtShpTongWgt, String grsRgstTongWgt, String netRgstTongWgt, String pnmGtWgt, String pnmNetTongWgt, String suzGtWgt, String suzNetTongWgt, String mnEngMkrNm, String blkMnEngTpCd, String mnEngBhpPwr, String vslOwnIndCd, String vslRgstCntCd, String vslBldDt, String loaUtCd, String vslBmWdt, String vslBmUtCd, String vslOwnCustCntCd, String vslOwnCustSeq, String vslCgoGrNm, String vslCapaUtCd, String vslDwtUtCd, String blkCrrTpCd, String vslDrftUtCd, String smrTpcTonWgt, String wntTpcTonWgt, String tropTpcTonWgt, String blstWgtSpd1, String ldnWgtSpd1, String blstWgtSpd2, String ldnWgtSpd2, String foilBlstCsm1, String foilLdnCsm1, String foilBlstCsm2, String foilLdnCsm2, String portFoilTonCsm, String seaDoilTonCsm, String portIdleDoilTonCsm, String portWrkDoilTonCsm, String vslBunkUtCd, String consTonWgt, String entTpCd, String wntDrftHgt, String tropDrftHgt, String smrDwtWgt, String wntDwtWgt, String tropDwtWgt, String vslHtchKnt, String vslHldKnt, String blkVslClssCd, String htFoilCsm, String pmpOilKndCd, String pmpOilCsm, String clnOilKndCd, String clnOilCsm, String lnchDt, String rgstDt, String imoNo, String vslRmk, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String vslOwnCustNm, String blkVslDeDt) {
		this.vslCd = vslCd;
		this.tropDwtWgt = tropDwtWgt;
		this.ldnWgtSpd2 = ldnWgtSpd2;
		this.ldnWgtSpd1 = ldnWgtSpd1;
		this.smrTpcTonWgt = smrTpcTonWgt;
		this.htFoilCsm = htFoilCsm;
		this.vslCapaUtCd = vslCapaUtCd;
		this.pagerows = pagerows;
		this.wntDwtWgt = wntDwtWgt;
		this.lnchDt = lnchDt;
		this.doilCapa = doilCapa;
		this.vslOwnCustNm = vslOwnCustNm;
		this.vslClssFlg = vslClssFlg;
		this.loaUtCd = loaUtCd;
		this.pmpOilKndCd = pmpOilKndCd;
		this.updUsrId = updUsrId;
		this.rgstDt = rgstDt;
		this.clnOilKndCd = clnOilKndCd;
		this.frshWtrCapa = frshWtrCapa;
		this.vslCgoGrNm = vslCgoGrNm;
		this.portIdleDoilTonCsm = portIdleDoilTonCsm;
		this.blkMnEngTpCd = blkMnEngTpCd;
		this.vslHldKnt = vslHldKnt;
		this.rgstPortCd = rgstPortCd;
		this.wntTpcTonWgt = wntTpcTonWgt;
		this.callSgnNo = callSgnNo;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.vslOwnIndCd = vslOwnIndCd;
		this.creUsrId = creUsrId;
		this.blkVslClssCd = blkVslClssCd;
		this.suzNetTongWgt = suzNetTongWgt;
		this.tropTpcTonWgt = tropTpcTonWgt;
		this.pnmNetTongWgt = pnmNetTongWgt;
		this.smrDrftHgt = smrDrftHgt;
		this.bailTongCapa = bailTongCapa;
		this.smrDwtWgt = smrDwtWgt;
		this.entTpCd = entTpCd;
		this.vslBmWdt = vslBmWdt;
		this.vslRmk = vslRmk;
		this.deltFlg = deltFlg;
		this.imoNo = imoNo;
		this.wntDrftHgt = wntDrftHgt;
		this.vslOwnCustCntCd = vslOwnCustCntCd;
		this.creDt = creDt;
		this.loaLen = loaLen;
		this.mnEngMkrNm = mnEngMkrNm;
		this.vslBldrNm = vslBldrNm;
		this.vslHtchKnt = vslHtchKnt;
		this.grnTongCapa = grnTongCapa;
		this.ibflag = ibflag;
		this.vslBldDt = vslBldDt;
		this.vslOwnCustSeq = vslOwnCustSeq;
		this.vslEngNm = vslEngNm;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslBunkUtCd = vslBunkUtCd;
		this.foilBlstCsm1 = foilBlstCsm1;
		this.vslDwtUtCd = vslDwtUtCd;
		this.foilBlstCsm2 = foilBlstCsm2;
		this.vslKrnNm = vslKrnNm;
		this.tropDrftHgt = tropDrftHgt;
		this.blkVslDeDt = blkVslDeDt;
		this.updDt = updDt;
		this.seaDoilTonCsm = seaDoilTonCsm;
		this.netRgstTongWgt = netRgstTongWgt;
		this.pnmGtWgt = pnmGtWgt;
		this.blstWgtSpd2 = blstWgtSpd2;
		this.pmpOilCsm = pmpOilCsm;
		this.blstWgtSpd1 = blstWgtSpd1;
		this.suzGtWgt = suzGtWgt;
		this.clnOilCsm = clnOilCsm;
		this.portWrkDoilTonCsm = portWrkDoilTonCsm;
		this.eaiEvntDt = eaiEvntDt;
		this.lgtShpTongWgt = lgtShpTongWgt;
		this.vslDrftUtCd = vslDrftUtCd;
		this.blkCrrTpCd = blkCrrTpCd;
		this.foilCapa = foilCapa;
		this.mnEngBhpPwr = mnEngBhpPwr;
		this.tnkTongCapa = tnkTongCapa;
		this.portFoilTonCsm = portFoilTonCsm;
		this.consTonWgt = consTonWgt;
		this.foilLdnCsm2 = foilLdnCsm2;
		this.vslBmUtCd = vslBmUtCd;
		this.foilLdnCsm1 = foilLdnCsm1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trop_dwt_wgt", getTropDwtWgt());
		this.hashColumns.put("ldn_wgt_spd2", getLdnWgtSpd2());
		this.hashColumns.put("ldn_wgt_spd1", getLdnWgtSpd1());
		this.hashColumns.put("smr_tpc_ton_wgt", getSmrTpcTonWgt());
		this.hashColumns.put("ht_foil_csm", getHtFoilCsm());
		this.hashColumns.put("vsl_capa_ut_cd", getVslCapaUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wnt_dwt_wgt", getWntDwtWgt());
		this.hashColumns.put("lnch_dt", getLnchDt());
		this.hashColumns.put("doil_capa", getDoilCapa());
		this.hashColumns.put("vsl_own_cust_nm", getVslOwnCustNm());
		this.hashColumns.put("vsl_clss_flg", getVslClssFlg());
		this.hashColumns.put("loa_ut_cd", getLoaUtCd());
		this.hashColumns.put("pmp_oil_knd_cd", getPmpOilKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("cln_oil_knd_cd", getClnOilKndCd());
		this.hashColumns.put("frsh_wtr_capa", getFrshWtrCapa());
		this.hashColumns.put("vsl_cgo_gr_nm", getVslCgoGrNm());
		this.hashColumns.put("port_idle_doil_ton_csm", getPortIdleDoilTonCsm());
		this.hashColumns.put("blk_mn_eng_tp_cd", getBlkMnEngTpCd());
		this.hashColumns.put("vsl_hld_knt", getVslHldKnt());
		this.hashColumns.put("rgst_port_cd", getRgstPortCd());
		this.hashColumns.put("wnt_tpc_ton_wgt", getWntTpcTonWgt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("blk_vsl_clss_cd", getBlkVslClssCd());
		this.hashColumns.put("suz_net_tong_wgt", getSuzNetTongWgt());
		this.hashColumns.put("trop_tpc_ton_wgt", getTropTpcTonWgt());
		this.hashColumns.put("pnm_net_tong_wgt", getPnmNetTongWgt());
		this.hashColumns.put("smr_drft_hgt", getSmrDrftHgt());
		this.hashColumns.put("bail_tong_capa", getBailTongCapa());
		this.hashColumns.put("smr_dwt_wgt", getSmrDwtWgt());
		this.hashColumns.put("ent_tp_cd", getEntTpCd());
		this.hashColumns.put("vsl_bm_wdt", getVslBmWdt());
		this.hashColumns.put("vsl_rmk", getVslRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("imo_no", getImoNo());
		this.hashColumns.put("wnt_drft_hgt", getWntDrftHgt());
		this.hashColumns.put("vsl_own_cust_cnt_cd", getVslOwnCustCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("loa_len", getLoaLen());
		this.hashColumns.put("mn_eng_mkr_nm", getMnEngMkrNm());
		this.hashColumns.put("vsl_bldr_nm", getVslBldrNm());
		this.hashColumns.put("vsl_htch_knt", getVslHtchKnt());
		this.hashColumns.put("grn_tong_capa", getGrnTongCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_bld_dt", getVslBldDt());
		this.hashColumns.put("vsl_own_cust_seq", getVslOwnCustSeq());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_bunk_ut_cd", getVslBunkUtCd());
		this.hashColumns.put("foil_blst_csm1", getFoilBlstCsm1());
		this.hashColumns.put("vsl_dwt_ut_cd", getVslDwtUtCd());
		this.hashColumns.put("foil_blst_csm2", getFoilBlstCsm2());
		this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
		this.hashColumns.put("trop_drft_hgt", getTropDrftHgt());
		this.hashColumns.put("blk_vsl_de_dt", getBlkVslDeDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sea_doil_ton_csm", getSeaDoilTonCsm());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("pnm_gt_wgt", getPnmGtWgt());
		this.hashColumns.put("blst_wgt_spd2", getBlstWgtSpd2());
		this.hashColumns.put("pmp_oil_csm", getPmpOilCsm());
		this.hashColumns.put("blst_wgt_spd1", getBlstWgtSpd1());
		this.hashColumns.put("suz_gt_wgt", getSuzGtWgt());
		this.hashColumns.put("cln_oil_csm", getClnOilCsm());
		this.hashColumns.put("port_wrk_doil_ton_csm", getPortWrkDoilTonCsm());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("lgt_shp_tong_wgt", getLgtShpTongWgt());
		this.hashColumns.put("vsl_drft_ut_cd", getVslDrftUtCd());
		this.hashColumns.put("blk_crr_tp_cd", getBlkCrrTpCd());
		this.hashColumns.put("foil_capa", getFoilCapa());
		this.hashColumns.put("mn_eng_bhp_pwr", getMnEngBhpPwr());
		this.hashColumns.put("tnk_tong_capa", getTnkTongCapa());
		this.hashColumns.put("port_foil_ton_csm", getPortFoilTonCsm());
		this.hashColumns.put("cons_ton_wgt", getConsTonWgt());
		this.hashColumns.put("foil_ldn_csm2", getFoilLdnCsm2());
		this.hashColumns.put("vsl_bm_ut_cd", getVslBmUtCd());
		this.hashColumns.put("foil_ldn_csm1", getFoilLdnCsm1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trop_dwt_wgt", "tropDwtWgt");
		this.hashFields.put("ldn_wgt_spd2", "ldnWgtSpd2");
		this.hashFields.put("ldn_wgt_spd1", "ldnWgtSpd1");
		this.hashFields.put("smr_tpc_ton_wgt", "smrTpcTonWgt");
		this.hashFields.put("ht_foil_csm", "htFoilCsm");
		this.hashFields.put("vsl_capa_ut_cd", "vslCapaUtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wnt_dwt_wgt", "wntDwtWgt");
		this.hashFields.put("lnch_dt", "lnchDt");
		this.hashFields.put("doil_capa", "doilCapa");
		this.hashFields.put("vsl_own_cust_nm", "vslOwnCustNm");
		this.hashFields.put("vsl_clss_flg", "vslClssFlg");
		this.hashFields.put("loa_ut_cd", "loaUtCd");
		this.hashFields.put("pmp_oil_knd_cd", "pmpOilKndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("cln_oil_knd_cd", "clnOilKndCd");
		this.hashFields.put("frsh_wtr_capa", "frshWtrCapa");
		this.hashFields.put("vsl_cgo_gr_nm", "vslCgoGrNm");
		this.hashFields.put("port_idle_doil_ton_csm", "portIdleDoilTonCsm");
		this.hashFields.put("blk_mn_eng_tp_cd", "blkMnEngTpCd");
		this.hashFields.put("vsl_hld_knt", "vslHldKnt");
		this.hashFields.put("rgst_port_cd", "rgstPortCd");
		this.hashFields.put("wnt_tpc_ton_wgt", "wntTpcTonWgt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("blk_vsl_clss_cd", "blkVslClssCd");
		this.hashFields.put("suz_net_tong_wgt", "suzNetTongWgt");
		this.hashFields.put("trop_tpc_ton_wgt", "tropTpcTonWgt");
		this.hashFields.put("pnm_net_tong_wgt", "pnmNetTongWgt");
		this.hashFields.put("smr_drft_hgt", "smrDrftHgt");
		this.hashFields.put("bail_tong_capa", "bailTongCapa");
		this.hashFields.put("smr_dwt_wgt", "smrDwtWgt");
		this.hashFields.put("ent_tp_cd", "entTpCd");
		this.hashFields.put("vsl_bm_wdt", "vslBmWdt");
		this.hashFields.put("vsl_rmk", "vslRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("imo_no", "imoNo");
		this.hashFields.put("wnt_drft_hgt", "wntDrftHgt");
		this.hashFields.put("vsl_own_cust_cnt_cd", "vslOwnCustCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("loa_len", "loaLen");
		this.hashFields.put("mn_eng_mkr_nm", "mnEngMkrNm");
		this.hashFields.put("vsl_bldr_nm", "vslBldrNm");
		this.hashFields.put("vsl_htch_knt", "vslHtchKnt");
		this.hashFields.put("grn_tong_capa", "grnTongCapa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_bld_dt", "vslBldDt");
		this.hashFields.put("vsl_own_cust_seq", "vslOwnCustSeq");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_bunk_ut_cd", "vslBunkUtCd");
		this.hashFields.put("foil_blst_csm1", "foilBlstCsm1");
		this.hashFields.put("vsl_dwt_ut_cd", "vslDwtUtCd");
		this.hashFields.put("foil_blst_csm2", "foilBlstCsm2");
		this.hashFields.put("vsl_krn_nm", "vslKrnNm");
		this.hashFields.put("trop_drft_hgt", "tropDrftHgt");
		this.hashFields.put("blk_vsl_de_dt", "blkVslDeDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sea_doil_ton_csm", "seaDoilTonCsm");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("pnm_gt_wgt", "pnmGtWgt");
		this.hashFields.put("blst_wgt_spd2", "blstWgtSpd2");
		this.hashFields.put("pmp_oil_csm", "pmpOilCsm");
		this.hashFields.put("blst_wgt_spd1", "blstWgtSpd1");
		this.hashFields.put("suz_gt_wgt", "suzGtWgt");
		this.hashFields.put("cln_oil_csm", "clnOilCsm");
		this.hashFields.put("port_wrk_doil_ton_csm", "portWrkDoilTonCsm");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("lgt_shp_tong_wgt", "lgtShpTongWgt");
		this.hashFields.put("vsl_drft_ut_cd", "vslDrftUtCd");
		this.hashFields.put("blk_crr_tp_cd", "blkCrrTpCd");
		this.hashFields.put("foil_capa", "foilCapa");
		this.hashFields.put("mn_eng_bhp_pwr", "mnEngBhpPwr");
		this.hashFields.put("tnk_tong_capa", "tnkTongCapa");
		this.hashFields.put("port_foil_ton_csm", "portFoilTonCsm");
		this.hashFields.put("cons_ton_wgt", "consTonWgt");
		this.hashFields.put("foil_ldn_csm2", "foilLdnCsm2");
		this.hashFields.put("vsl_bm_ut_cd", "vslBmUtCd");
		this.hashFields.put("foil_ldn_csm1", "foilLdnCsm1");
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
	 * @return tropDwtWgt
	 */
	public String getTropDwtWgt() {
		return this.tropDwtWgt;
	}
	
	/**
	 * Column Info
	 * @return ldnWgtSpd2
	 */
	public String getLdnWgtSpd2() {
		return this.ldnWgtSpd2;
	}
	
	/**
	 * Column Info
	 * @return ldnWgtSpd1
	 */
	public String getLdnWgtSpd1() {
		return this.ldnWgtSpd1;
	}
	
	/**
	 * Column Info
	 * @return smrTpcTonWgt
	 */
	public String getSmrTpcTonWgt() {
		return this.smrTpcTonWgt;
	}
	
	/**
	 * Column Info
	 * @return htFoilCsm
	 */
	public String getHtFoilCsm() {
		return this.htFoilCsm;
	}
	
	/**
	 * Column Info
	 * @return vslCapaUtCd
	 */
	public String getVslCapaUtCd() {
		return this.vslCapaUtCd;
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
	 * @return wntDwtWgt
	 */
	public String getWntDwtWgt() {
		return this.wntDwtWgt;
	}
	
	/**
	 * Column Info
	 * @return lnchDt
	 */
	public String getLnchDt() {
		return this.lnchDt;
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
	 * @return vslOwnCustNm
	 */
	public String getVslOwnCustNm() {
		return this.vslOwnCustNm;
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
	 * @return loaUtCd
	 */
	public String getLoaUtCd() {
		return this.loaUtCd;
	}
	
	/**
	 * Column Info
	 * @return pmpOilKndCd
	 */
	public String getPmpOilKndCd() {
		return this.pmpOilKndCd;
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
	 * @return clnOilKndCd
	 */
	public String getClnOilKndCd() {
		return this.clnOilKndCd;
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
	 * @return vslCgoGrNm
	 */
	public String getVslCgoGrNm() {
		return this.vslCgoGrNm;
	}
	
	/**
	 * Column Info
	 * @return portIdleDoilTonCsm
	 */
	public String getPortIdleDoilTonCsm() {
		return this.portIdleDoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @return blkMnEngTpCd
	 */
	public String getBlkMnEngTpCd() {
		return this.blkMnEngTpCd;
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
	 * @return wntTpcTonWgt
	 */
	public String getWntTpcTonWgt() {
		return this.wntTpcTonWgt;
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
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return blkVslClssCd
	 */
	public String getBlkVslClssCd() {
		return this.blkVslClssCd;
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
	 * @return tropTpcTonWgt
	 */
	public String getTropTpcTonWgt() {
		return this.tropTpcTonWgt;
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
	 * @return smrDrftHgt
	 */
	public String getSmrDrftHgt() {
		return this.smrDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return bailTongCapa
	 */
	public String getBailTongCapa() {
		return this.bailTongCapa;
	}
	
	/**
	 * Column Info
	 * @return smrDwtWgt
	 */
	public String getSmrDwtWgt() {
		return this.smrDwtWgt;
	}
	
	/**
	 * Column Info
	 * @return entTpCd
	 */
	public String getEntTpCd() {
		return this.entTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslBmWdt
	 */
	public String getVslBmWdt() {
		return this.vslBmWdt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return imoNo
	 */
	public String getImoNo() {
		return this.imoNo;
	}
	
	/**
	 * Column Info
	 * @return wntDrftHgt
	 */
	public String getWntDrftHgt() {
		return this.wntDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return vslOwnCustCntCd
	 */
	public String getVslOwnCustCntCd() {
		return this.vslOwnCustCntCd;
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
	 * @return loaLen
	 */
	public String getLoaLen() {
		return this.loaLen;
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
	 * @return vslBldrNm
	 */
	public String getVslBldrNm() {
		return this.vslBldrNm;
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
	 * @return grnTongCapa
	 */
	public String getGrnTongCapa() {
		return this.grnTongCapa;
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
	 * @return vslBldDt
	 */
	public String getVslBldDt() {
		return this.vslBldDt;
	}
	
	/**
	 * Column Info
	 * @return vslOwnCustSeq
	 */
	public String getVslOwnCustSeq() {
		return this.vslOwnCustSeq;
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
	 * @return vslBunkUtCd
	 */
	public String getVslBunkUtCd() {
		return this.vslBunkUtCd;
	}
	
	/**
	 * Column Info
	 * @return foilBlstCsm1
	 */
	public String getFoilBlstCsm1() {
		return this.foilBlstCsm1;
	}
	
	/**
	 * Column Info
	 * @return vslDwtUtCd
	 */
	public String getVslDwtUtCd() {
		return this.vslDwtUtCd;
	}
	
	/**
	 * Column Info
	 * @return foilBlstCsm2
	 */
	public String getFoilBlstCsm2() {
		return this.foilBlstCsm2;
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
	 * @return tropDrftHgt
	 */
	public String getTropDrftHgt() {
		return this.tropDrftHgt;
	}
	
	/**
	 * Column Info
	 * @return blkVslDeDt
	 */
	public String getBlkVslDeDt() {
		return this.blkVslDeDt;
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
	 * @return seaDoilTonCsm
	 */
	public String getSeaDoilTonCsm() {
		return this.seaDoilTonCsm;
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
	 * @return pnmGtWgt
	 */
	public String getPnmGtWgt() {
		return this.pnmGtWgt;
	}
	
	/**
	 * Column Info
	 * @return blstWgtSpd2
	 */
	public String getBlstWgtSpd2() {
		return this.blstWgtSpd2;
	}
	
	/**
	 * Column Info
	 * @return pmpOilCsm
	 */
	public String getPmpOilCsm() {
		return this.pmpOilCsm;
	}
	
	/**
	 * Column Info
	 * @return blstWgtSpd1
	 */
	public String getBlstWgtSpd1() {
		return this.blstWgtSpd1;
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
	 * @return clnOilCsm
	 */
	public String getClnOilCsm() {
		return this.clnOilCsm;
	}
	
	/**
	 * Column Info
	 * @return portWrkDoilTonCsm
	 */
	public String getPortWrkDoilTonCsm() {
		return this.portWrkDoilTonCsm;
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
	 * @return vslDrftUtCd
	 */
	public String getVslDrftUtCd() {
		return this.vslDrftUtCd;
	}
	
	/**
	 * Column Info
	 * @return blkCrrTpCd
	 */
	public String getBlkCrrTpCd() {
		return this.blkCrrTpCd;
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
	 * @return tnkTongCapa
	 */
	public String getTnkTongCapa() {
		return this.tnkTongCapa;
	}
	
	/**
	 * Column Info
	 * @return portFoilTonCsm
	 */
	public String getPortFoilTonCsm() {
		return this.portFoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @return consTonWgt
	 */
	public String getConsTonWgt() {
		return this.consTonWgt;
	}
	
	/**
	 * Column Info
	 * @return foilLdnCsm2
	 */
	public String getFoilLdnCsm2() {
		return this.foilLdnCsm2;
	}
	
	/**
	 * Column Info
	 * @return vslBmUtCd
	 */
	public String getVslBmUtCd() {
		return this.vslBmUtCd;
	}
	
	/**
	 * Column Info
	 * @return foilLdnCsm1
	 */
	public String getFoilLdnCsm1() {
		return this.foilLdnCsm1;
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
	 * @param tropDwtWgt
	 */
	public void setTropDwtWgt(String tropDwtWgt) {
		this.tropDwtWgt = tropDwtWgt;
	}
	
	/**
	 * Column Info
	 * @param ldnWgtSpd2
	 */
	public void setLdnWgtSpd2(String ldnWgtSpd2) {
		this.ldnWgtSpd2 = ldnWgtSpd2;
	}
	
	/**
	 * Column Info
	 * @param ldnWgtSpd1
	 */
	public void setLdnWgtSpd1(String ldnWgtSpd1) {
		this.ldnWgtSpd1 = ldnWgtSpd1;
	}
	
	/**
	 * Column Info
	 * @param smrTpcTonWgt
	 */
	public void setSmrTpcTonWgt(String smrTpcTonWgt) {
		this.smrTpcTonWgt = smrTpcTonWgt;
	}
	
	/**
	 * Column Info
	 * @param htFoilCsm
	 */
	public void setHtFoilCsm(String htFoilCsm) {
		this.htFoilCsm = htFoilCsm;
	}
	
	/**
	 * Column Info
	 * @param vslCapaUtCd
	 */
	public void setVslCapaUtCd(String vslCapaUtCd) {
		this.vslCapaUtCd = vslCapaUtCd;
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
	 * @param wntDwtWgt
	 */
	public void setWntDwtWgt(String wntDwtWgt) {
		this.wntDwtWgt = wntDwtWgt;
	}
	
	/**
	 * Column Info
	 * @param lnchDt
	 */
	public void setLnchDt(String lnchDt) {
		this.lnchDt = lnchDt;
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
	 * @param vslOwnCustNm
	 */
	public void setVslOwnCustNm(String vslOwnCustNm) {
		this.vslOwnCustNm = vslOwnCustNm;
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
	 * @param loaUtCd
	 */
	public void setLoaUtCd(String loaUtCd) {
		this.loaUtCd = loaUtCd;
	}
	
	/**
	 * Column Info
	 * @param pmpOilKndCd
	 */
	public void setPmpOilKndCd(String pmpOilKndCd) {
		this.pmpOilKndCd = pmpOilKndCd;
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
	 * @param clnOilKndCd
	 */
	public void setClnOilKndCd(String clnOilKndCd) {
		this.clnOilKndCd = clnOilKndCd;
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
	 * @param vslCgoGrNm
	 */
	public void setVslCgoGrNm(String vslCgoGrNm) {
		this.vslCgoGrNm = vslCgoGrNm;
	}
	
	/**
	 * Column Info
	 * @param portIdleDoilTonCsm
	 */
	public void setPortIdleDoilTonCsm(String portIdleDoilTonCsm) {
		this.portIdleDoilTonCsm = portIdleDoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @param blkMnEngTpCd
	 */
	public void setBlkMnEngTpCd(String blkMnEngTpCd) {
		this.blkMnEngTpCd = blkMnEngTpCd;
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
	 * @param wntTpcTonWgt
	 */
	public void setWntTpcTonWgt(String wntTpcTonWgt) {
		this.wntTpcTonWgt = wntTpcTonWgt;
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
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param blkVslClssCd
	 */
	public void setBlkVslClssCd(String blkVslClssCd) {
		this.blkVslClssCd = blkVslClssCd;
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
	 * @param tropTpcTonWgt
	 */
	public void setTropTpcTonWgt(String tropTpcTonWgt) {
		this.tropTpcTonWgt = tropTpcTonWgt;
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
	 * @param smrDrftHgt
	 */
	public void setSmrDrftHgt(String smrDrftHgt) {
		this.smrDrftHgt = smrDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param bailTongCapa
	 */
	public void setBailTongCapa(String bailTongCapa) {
		this.bailTongCapa = bailTongCapa;
	}
	
	/**
	 * Column Info
	 * @param smrDwtWgt
	 */
	public void setSmrDwtWgt(String smrDwtWgt) {
		this.smrDwtWgt = smrDwtWgt;
	}
	
	/**
	 * Column Info
	 * @param entTpCd
	 */
	public void setEntTpCd(String entTpCd) {
		this.entTpCd = entTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslBmWdt
	 */
	public void setVslBmWdt(String vslBmWdt) {
		this.vslBmWdt = vslBmWdt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param imoNo
	 */
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
	}
	
	/**
	 * Column Info
	 * @param wntDrftHgt
	 */
	public void setWntDrftHgt(String wntDrftHgt) {
		this.wntDrftHgt = wntDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param vslOwnCustCntCd
	 */
	public void setVslOwnCustCntCd(String vslOwnCustCntCd) {
		this.vslOwnCustCntCd = vslOwnCustCntCd;
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
	 * @param loaLen
	 */
	public void setLoaLen(String loaLen) {
		this.loaLen = loaLen;
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
	 * @param vslBldrNm
	 */
	public void setVslBldrNm(String vslBldrNm) {
		this.vslBldrNm = vslBldrNm;
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
	 * @param grnTongCapa
	 */
	public void setGrnTongCapa(String grnTongCapa) {
		this.grnTongCapa = grnTongCapa;
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
	 * @param vslBldDt
	 */
	public void setVslBldDt(String vslBldDt) {
		this.vslBldDt = vslBldDt;
	}
	
	/**
	 * Column Info
	 * @param vslOwnCustSeq
	 */
	public void setVslOwnCustSeq(String vslOwnCustSeq) {
		this.vslOwnCustSeq = vslOwnCustSeq;
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
	 * @param vslBunkUtCd
	 */
	public void setVslBunkUtCd(String vslBunkUtCd) {
		this.vslBunkUtCd = vslBunkUtCd;
	}
	
	/**
	 * Column Info
	 * @param foilBlstCsm1
	 */
	public void setFoilBlstCsm1(String foilBlstCsm1) {
		this.foilBlstCsm1 = foilBlstCsm1;
	}
	
	/**
	 * Column Info
	 * @param vslDwtUtCd
	 */
	public void setVslDwtUtCd(String vslDwtUtCd) {
		this.vslDwtUtCd = vslDwtUtCd;
	}
	
	/**
	 * Column Info
	 * @param foilBlstCsm2
	 */
	public void setFoilBlstCsm2(String foilBlstCsm2) {
		this.foilBlstCsm2 = foilBlstCsm2;
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
	 * @param tropDrftHgt
	 */
	public void setTropDrftHgt(String tropDrftHgt) {
		this.tropDrftHgt = tropDrftHgt;
	}
	
	/**
	 * Column Info
	 * @param blkVslDeDt
	 */
	public void setBlkVslDeDt(String blkVslDeDt) {
		this.blkVslDeDt = blkVslDeDt;
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
	 * @param seaDoilTonCsm
	 */
	public void setSeaDoilTonCsm(String seaDoilTonCsm) {
		this.seaDoilTonCsm = seaDoilTonCsm;
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
	 * @param pnmGtWgt
	 */
	public void setPnmGtWgt(String pnmGtWgt) {
		this.pnmGtWgt = pnmGtWgt;
	}
	
	/**
	 * Column Info
	 * @param blstWgtSpd2
	 */
	public void setBlstWgtSpd2(String blstWgtSpd2) {
		this.blstWgtSpd2 = blstWgtSpd2;
	}
	
	/**
	 * Column Info
	 * @param pmpOilCsm
	 */
	public void setPmpOilCsm(String pmpOilCsm) {
		this.pmpOilCsm = pmpOilCsm;
	}
	
	/**
	 * Column Info
	 * @param blstWgtSpd1
	 */
	public void setBlstWgtSpd1(String blstWgtSpd1) {
		this.blstWgtSpd1 = blstWgtSpd1;
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
	 * @param clnOilCsm
	 */
	public void setClnOilCsm(String clnOilCsm) {
		this.clnOilCsm = clnOilCsm;
	}
	
	/**
	 * Column Info
	 * @param portWrkDoilTonCsm
	 */
	public void setPortWrkDoilTonCsm(String portWrkDoilTonCsm) {
		this.portWrkDoilTonCsm = portWrkDoilTonCsm;
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
	 * @param vslDrftUtCd
	 */
	public void setVslDrftUtCd(String vslDrftUtCd) {
		this.vslDrftUtCd = vslDrftUtCd;
	}
	
	/**
	 * Column Info
	 * @param blkCrrTpCd
	 */
	public void setBlkCrrTpCd(String blkCrrTpCd) {
		this.blkCrrTpCd = blkCrrTpCd;
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
	 * @param tnkTongCapa
	 */
	public void setTnkTongCapa(String tnkTongCapa) {
		this.tnkTongCapa = tnkTongCapa;
	}
	
	/**
	 * Column Info
	 * @param portFoilTonCsm
	 */
	public void setPortFoilTonCsm(String portFoilTonCsm) {
		this.portFoilTonCsm = portFoilTonCsm;
	}
	
	/**
	 * Column Info
	 * @param consTonWgt
	 */
	public void setConsTonWgt(String consTonWgt) {
		this.consTonWgt = consTonWgt;
	}
	
	/**
	 * Column Info
	 * @param foilLdnCsm2
	 */
	public void setFoilLdnCsm2(String foilLdnCsm2) {
		this.foilLdnCsm2 = foilLdnCsm2;
	}
	
	/**
	 * Column Info
	 * @param vslBmUtCd
	 */
	public void setVslBmUtCd(String vslBmUtCd) {
		this.vslBmUtCd = vslBmUtCd;
	}
	
	/**
	 * Column Info
	 * @param foilLdnCsm1
	 */
	public void setFoilLdnCsm1(String foilLdnCsm1) {
		this.foilLdnCsm1 = foilLdnCsm1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTropDwtWgt(JSPUtil.getParameter(request, "trop_dwt_wgt", ""));
		setLdnWgtSpd2(JSPUtil.getParameter(request, "ldn_wgt_spd2", ""));
		setLdnWgtSpd1(JSPUtil.getParameter(request, "ldn_wgt_spd1", ""));
		setSmrTpcTonWgt(JSPUtil.getParameter(request, "smr_tpc_ton_wgt", ""));
		setHtFoilCsm(JSPUtil.getParameter(request, "ht_foil_csm", ""));
		setVslCapaUtCd(JSPUtil.getParameter(request, "vsl_capa_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWntDwtWgt(JSPUtil.getParameter(request, "wnt_dwt_wgt", ""));
		setLnchDt(JSPUtil.getParameter(request, "lnch_dt", ""));
		setDoilCapa(JSPUtil.getParameter(request, "doil_capa", ""));
		setVslOwnCustNm(JSPUtil.getParameter(request, "vsl_own_cust_nm", ""));
		setVslClssFlg(JSPUtil.getParameter(request, "vsl_clss_flg", ""));
		setLoaUtCd(JSPUtil.getParameter(request, "loa_ut_cd", ""));
		setPmpOilKndCd(JSPUtil.getParameter(request, "pmp_oil_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setClnOilKndCd(JSPUtil.getParameter(request, "cln_oil_knd_cd", ""));
		setFrshWtrCapa(JSPUtil.getParameter(request, "frsh_wtr_capa", ""));
		setVslCgoGrNm(JSPUtil.getParameter(request, "vsl_cgo_gr_nm", ""));
		setPortIdleDoilTonCsm(JSPUtil.getParameter(request, "port_idle_doil_ton_csm", ""));
		setBlkMnEngTpCd(JSPUtil.getParameter(request, "blk_mn_eng_tp_cd", ""));
		setVslHldKnt(JSPUtil.getParameter(request, "vsl_hld_knt", ""));
		setRgstPortCd(JSPUtil.getParameter(request, "rgst_port_cd", ""));
		setWntTpcTonWgt(JSPUtil.getParameter(request, "wnt_tpc_ton_wgt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, "grs_rgst_tong_wgt", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, "vsl_own_ind_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBlkVslClssCd(JSPUtil.getParameter(request, "blk_vsl_clss_cd", ""));
		setSuzNetTongWgt(JSPUtil.getParameter(request, "suz_net_tong_wgt", ""));
		setTropTpcTonWgt(JSPUtil.getParameter(request, "trop_tpc_ton_wgt", ""));
		setPnmNetTongWgt(JSPUtil.getParameter(request, "pnm_net_tong_wgt", ""));
		setSmrDrftHgt(JSPUtil.getParameter(request, "smr_drft_hgt", ""));
		setBailTongCapa(JSPUtil.getParameter(request, "bail_tong_capa", ""));
		setSmrDwtWgt(JSPUtil.getParameter(request, "smr_dwt_wgt", ""));
		setEntTpCd(JSPUtil.getParameter(request, "ent_tp_cd", ""));
		setVslBmWdt(JSPUtil.getParameter(request, "vsl_bm_wdt", ""));
		setVslRmk(JSPUtil.getParameter(request, "vsl_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setImoNo(JSPUtil.getParameter(request, "imo_no", ""));
		setWntDrftHgt(JSPUtil.getParameter(request, "wnt_drft_hgt", ""));
		setVslOwnCustCntCd(JSPUtil.getParameter(request, "vsl_own_cust_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setLoaLen(JSPUtil.getParameter(request, "loa_len", ""));
		setMnEngMkrNm(JSPUtil.getParameter(request, "mn_eng_mkr_nm", ""));
		setVslBldrNm(JSPUtil.getParameter(request, "vsl_bldr_nm", ""));
		setVslHtchKnt(JSPUtil.getParameter(request, "vsl_htch_knt", ""));
		setGrnTongCapa(JSPUtil.getParameter(request, "grn_tong_capa", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslBldDt(JSPUtil.getParameter(request, "vsl_bld_dt", ""));
		setVslOwnCustSeq(JSPUtil.getParameter(request, "vsl_own_cust_seq", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setVslBunkUtCd(JSPUtil.getParameter(request, "vsl_bunk_ut_cd", ""));
		setFoilBlstCsm1(JSPUtil.getParameter(request, "foil_blst_csm1", ""));
		setVslDwtUtCd(JSPUtil.getParameter(request, "vsl_dwt_ut_cd", ""));
		setFoilBlstCsm2(JSPUtil.getParameter(request, "foil_blst_csm2", ""));
		setVslKrnNm(JSPUtil.getParameter(request, "vsl_krn_nm", ""));
		setTropDrftHgt(JSPUtil.getParameter(request, "trop_drft_hgt", ""));
		setBlkVslDeDt(JSPUtil.getParameter(request, "blk_vsl_de_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSeaDoilTonCsm(JSPUtil.getParameter(request, "sea_doil_ton_csm", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, "net_rgst_tong_wgt", ""));
		setPnmGtWgt(JSPUtil.getParameter(request, "pnm_gt_wgt", ""));
		setBlstWgtSpd2(JSPUtil.getParameter(request, "blst_wgt_spd2", ""));
		setPmpOilCsm(JSPUtil.getParameter(request, "pmp_oil_csm", ""));
		setBlstWgtSpd1(JSPUtil.getParameter(request, "blst_wgt_spd1", ""));
		setSuzGtWgt(JSPUtil.getParameter(request, "suz_gt_wgt", ""));
		setClnOilCsm(JSPUtil.getParameter(request, "cln_oil_csm", ""));
		setPortWrkDoilTonCsm(JSPUtil.getParameter(request, "port_wrk_doil_ton_csm", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setLgtShpTongWgt(JSPUtil.getParameter(request, "lgt_shp_tong_wgt", ""));
		setVslDrftUtCd(JSPUtil.getParameter(request, "vsl_drft_ut_cd", ""));
		setBlkCrrTpCd(JSPUtil.getParameter(request, "blk_crr_tp_cd", ""));
		setFoilCapa(JSPUtil.getParameter(request, "foil_capa", ""));
		setMnEngBhpPwr(JSPUtil.getParameter(request, "mn_eng_bhp_pwr", ""));
		setTnkTongCapa(JSPUtil.getParameter(request, "tnk_tong_capa", ""));
		setPortFoilTonCsm(JSPUtil.getParameter(request, "port_foil_ton_csm", ""));
		setConsTonWgt(JSPUtil.getParameter(request, "cons_ton_wgt", ""));
		setFoilLdnCsm2(JSPUtil.getParameter(request, "foil_ldn_csm2", ""));
		setVslBmUtCd(JSPUtil.getParameter(request, "vsl_bm_ut_cd", ""));
		setFoilLdnCsm1(JSPUtil.getParameter(request, "foil_ldn_csm1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmVslBlkVO[]
	 */
	public MdmVslBlkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmVslBlkVO[]
	 */
	public MdmVslBlkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmVslBlkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tropDwtWgt = (JSPUtil.getParameter(request, prefix	+ "trop_dwt_wgt", length));
			String[] ldnWgtSpd2 = (JSPUtil.getParameter(request, prefix	+ "ldn_wgt_spd2", length));
			String[] ldnWgtSpd1 = (JSPUtil.getParameter(request, prefix	+ "ldn_wgt_spd1", length));
			String[] smrTpcTonWgt = (JSPUtil.getParameter(request, prefix	+ "smr_tpc_ton_wgt", length));
			String[] htFoilCsm = (JSPUtil.getParameter(request, prefix	+ "ht_foil_csm", length));
			String[] vslCapaUtCd = (JSPUtil.getParameter(request, prefix	+ "vsl_capa_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] wntDwtWgt = (JSPUtil.getParameter(request, prefix	+ "wnt_dwt_wgt", length));
			String[] lnchDt = (JSPUtil.getParameter(request, prefix	+ "lnch_dt", length));
			String[] doilCapa = (JSPUtil.getParameter(request, prefix	+ "doil_capa", length));
			String[] vslOwnCustNm = (JSPUtil.getParameter(request, prefix	+ "vsl_own_cust_nm", length));
			String[] vslClssFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_flg", length));
			String[] loaUtCd = (JSPUtil.getParameter(request, prefix	+ "loa_ut_cd", length));
			String[] pmpOilKndCd = (JSPUtil.getParameter(request, prefix	+ "pmp_oil_knd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] clnOilKndCd = (JSPUtil.getParameter(request, prefix	+ "cln_oil_knd_cd", length));
			String[] frshWtrCapa = (JSPUtil.getParameter(request, prefix	+ "frsh_wtr_capa", length));
			String[] vslCgoGrNm = (JSPUtil.getParameter(request, prefix	+ "vsl_cgo_gr_nm", length));
			String[] portIdleDoilTonCsm = (JSPUtil.getParameter(request, prefix	+ "port_idle_doil_ton_csm", length));
			String[] blkMnEngTpCd = (JSPUtil.getParameter(request, prefix	+ "blk_mn_eng_tp_cd", length));
			String[] vslHldKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_hld_knt", length));
			String[] rgstPortCd = (JSPUtil.getParameter(request, prefix	+ "rgst_port_cd", length));
			String[] wntTpcTonWgt = (JSPUtil.getParameter(request, prefix	+ "wnt_tpc_ton_wgt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] blkVslClssCd = (JSPUtil.getParameter(request, prefix	+ "blk_vsl_clss_cd", length));
			String[] suzNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "suz_net_tong_wgt", length));
			String[] tropTpcTonWgt = (JSPUtil.getParameter(request, prefix	+ "trop_tpc_ton_wgt", length));
			String[] pnmNetTongWgt = (JSPUtil.getParameter(request, prefix	+ "pnm_net_tong_wgt", length));
			String[] smrDrftHgt = (JSPUtil.getParameter(request, prefix	+ "smr_drft_hgt", length));
			String[] bailTongCapa = (JSPUtil.getParameter(request, prefix	+ "bail_tong_capa", length));
			String[] smrDwtWgt = (JSPUtil.getParameter(request, prefix	+ "smr_dwt_wgt", length));
			String[] entTpCd = (JSPUtil.getParameter(request, prefix	+ "ent_tp_cd", length));
			String[] vslBmWdt = (JSPUtil.getParameter(request, prefix	+ "vsl_bm_wdt", length));
			String[] vslRmk = (JSPUtil.getParameter(request, prefix	+ "vsl_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] imoNo = (JSPUtil.getParameter(request, prefix	+ "imo_no", length));
			String[] wntDrftHgt = (JSPUtil.getParameter(request, prefix	+ "wnt_drft_hgt", length));
			String[] vslOwnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_cust_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] loaLen = (JSPUtil.getParameter(request, prefix	+ "loa_len", length));
			String[] mnEngMkrNm = (JSPUtil.getParameter(request, prefix	+ "mn_eng_mkr_nm", length));
			String[] vslBldrNm = (JSPUtil.getParameter(request, prefix	+ "vsl_bldr_nm", length));
			String[] vslHtchKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_htch_knt", length));
			String[] grnTongCapa = (JSPUtil.getParameter(request, prefix	+ "grn_tong_capa", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslBldDt = (JSPUtil.getParameter(request, prefix	+ "vsl_bld_dt", length));
			String[] vslOwnCustSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_own_cust_seq", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslBunkUtCd = (JSPUtil.getParameter(request, prefix	+ "vsl_bunk_ut_cd", length));
			String[] foilBlstCsm1 = (JSPUtil.getParameter(request, prefix	+ "foil_blst_csm1", length));
			String[] vslDwtUtCd = (JSPUtil.getParameter(request, prefix	+ "vsl_dwt_ut_cd", length));
			String[] foilBlstCsm2 = (JSPUtil.getParameter(request, prefix	+ "foil_blst_csm2", length));
			String[] vslKrnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_krn_nm", length));
			String[] tropDrftHgt = (JSPUtil.getParameter(request, prefix	+ "trop_drft_hgt", length));
			String[] blkVslDeDt = (JSPUtil.getParameter(request, prefix	+ "blk_vsl_de_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] seaDoilTonCsm = (JSPUtil.getParameter(request, prefix	+ "sea_doil_ton_csm", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] pnmGtWgt = (JSPUtil.getParameter(request, prefix	+ "pnm_gt_wgt", length));
			String[] blstWgtSpd2 = (JSPUtil.getParameter(request, prefix	+ "blst_wgt_spd2", length));
			String[] pmpOilCsm = (JSPUtil.getParameter(request, prefix	+ "pmp_oil_csm", length));
			String[] blstWgtSpd1 = (JSPUtil.getParameter(request, prefix	+ "blst_wgt_spd1", length));
			String[] suzGtWgt = (JSPUtil.getParameter(request, prefix	+ "suz_gt_wgt", length));
			String[] clnOilCsm = (JSPUtil.getParameter(request, prefix	+ "cln_oil_csm", length));
			String[] portWrkDoilTonCsm = (JSPUtil.getParameter(request, prefix	+ "port_wrk_doil_ton_csm", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] lgtShpTongWgt = (JSPUtil.getParameter(request, prefix	+ "lgt_shp_tong_wgt", length));
			String[] vslDrftUtCd = (JSPUtil.getParameter(request, prefix	+ "vsl_drft_ut_cd", length));
			String[] blkCrrTpCd = (JSPUtil.getParameter(request, prefix	+ "blk_crr_tp_cd", length));
			String[] foilCapa = (JSPUtil.getParameter(request, prefix	+ "foil_capa", length));
			String[] mnEngBhpPwr = (JSPUtil.getParameter(request, prefix	+ "mn_eng_bhp_pwr", length));
			String[] tnkTongCapa = (JSPUtil.getParameter(request, prefix	+ "tnk_tong_capa", length));
			String[] portFoilTonCsm = (JSPUtil.getParameter(request, prefix	+ "port_foil_ton_csm", length));
			String[] consTonWgt = (JSPUtil.getParameter(request, prefix	+ "cons_ton_wgt", length));
			String[] foilLdnCsm2 = (JSPUtil.getParameter(request, prefix	+ "foil_ldn_csm2", length));
			String[] vslBmUtCd = (JSPUtil.getParameter(request, prefix	+ "vsl_bm_ut_cd", length));
			String[] foilLdnCsm1 = (JSPUtil.getParameter(request, prefix	+ "foil_ldn_csm1", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmVslBlkVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tropDwtWgt[i] != null)
					model.setTropDwtWgt(tropDwtWgt[i]);
				if (ldnWgtSpd2[i] != null)
					model.setLdnWgtSpd2(ldnWgtSpd2[i]);
				if (ldnWgtSpd1[i] != null)
					model.setLdnWgtSpd1(ldnWgtSpd1[i]);
				if (smrTpcTonWgt[i] != null)
					model.setSmrTpcTonWgt(smrTpcTonWgt[i]);
				if (htFoilCsm[i] != null)
					model.setHtFoilCsm(htFoilCsm[i]);
				if (vslCapaUtCd[i] != null)
					model.setVslCapaUtCd(vslCapaUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (wntDwtWgt[i] != null)
					model.setWntDwtWgt(wntDwtWgt[i]);
				if (lnchDt[i] != null)
					model.setLnchDt(lnchDt[i]);
				if (doilCapa[i] != null)
					model.setDoilCapa(doilCapa[i]);
				if (vslOwnCustNm[i] != null)
					model.setVslOwnCustNm(vslOwnCustNm[i]);
				if (vslClssFlg[i] != null)
					model.setVslClssFlg(vslClssFlg[i]);
				if (loaUtCd[i] != null)
					model.setLoaUtCd(loaUtCd[i]);
				if (pmpOilKndCd[i] != null)
					model.setPmpOilKndCd(pmpOilKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (clnOilKndCd[i] != null)
					model.setClnOilKndCd(clnOilKndCd[i]);
				if (frshWtrCapa[i] != null)
					model.setFrshWtrCapa(frshWtrCapa[i]);
				if (vslCgoGrNm[i] != null)
					model.setVslCgoGrNm(vslCgoGrNm[i]);
				if (portIdleDoilTonCsm[i] != null)
					model.setPortIdleDoilTonCsm(portIdleDoilTonCsm[i]);
				if (blkMnEngTpCd[i] != null)
					model.setBlkMnEngTpCd(blkMnEngTpCd[i]);
				if (vslHldKnt[i] != null)
					model.setVslHldKnt(vslHldKnt[i]);
				if (rgstPortCd[i] != null)
					model.setRgstPortCd(rgstPortCd[i]);
				if (wntTpcTonWgt[i] != null)
					model.setWntTpcTonWgt(wntTpcTonWgt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (vslOwnIndCd[i] != null)
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blkVslClssCd[i] != null)
					model.setBlkVslClssCd(blkVslClssCd[i]);
				if (suzNetTongWgt[i] != null)
					model.setSuzNetTongWgt(suzNetTongWgt[i]);
				if (tropTpcTonWgt[i] != null)
					model.setTropTpcTonWgt(tropTpcTonWgt[i]);
				if (pnmNetTongWgt[i] != null)
					model.setPnmNetTongWgt(pnmNetTongWgt[i]);
				if (smrDrftHgt[i] != null)
					model.setSmrDrftHgt(smrDrftHgt[i]);
				if (bailTongCapa[i] != null)
					model.setBailTongCapa(bailTongCapa[i]);
				if (smrDwtWgt[i] != null)
					model.setSmrDwtWgt(smrDwtWgt[i]);
				if (entTpCd[i] != null)
					model.setEntTpCd(entTpCd[i]);
				if (vslBmWdt[i] != null)
					model.setVslBmWdt(vslBmWdt[i]);
				if (vslRmk[i] != null)
					model.setVslRmk(vslRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (imoNo[i] != null)
					model.setImoNo(imoNo[i]);
				if (wntDrftHgt[i] != null)
					model.setWntDrftHgt(wntDrftHgt[i]);
				if (vslOwnCustCntCd[i] != null)
					model.setVslOwnCustCntCd(vslOwnCustCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (loaLen[i] != null)
					model.setLoaLen(loaLen[i]);
				if (mnEngMkrNm[i] != null)
					model.setMnEngMkrNm(mnEngMkrNm[i]);
				if (vslBldrNm[i] != null)
					model.setVslBldrNm(vslBldrNm[i]);
				if (vslHtchKnt[i] != null)
					model.setVslHtchKnt(vslHtchKnt[i]);
				if (grnTongCapa[i] != null)
					model.setGrnTongCapa(grnTongCapa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslBldDt[i] != null)
					model.setVslBldDt(vslBldDt[i]);
				if (vslOwnCustSeq[i] != null)
					model.setVslOwnCustSeq(vslOwnCustSeq[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslBunkUtCd[i] != null)
					model.setVslBunkUtCd(vslBunkUtCd[i]);
				if (foilBlstCsm1[i] != null)
					model.setFoilBlstCsm1(foilBlstCsm1[i]);
				if (vslDwtUtCd[i] != null)
					model.setVslDwtUtCd(vslDwtUtCd[i]);
				if (foilBlstCsm2[i] != null)
					model.setFoilBlstCsm2(foilBlstCsm2[i]);
				if (vslKrnNm[i] != null)
					model.setVslKrnNm(vslKrnNm[i]);
				if (tropDrftHgt[i] != null)
					model.setTropDrftHgt(tropDrftHgt[i]);
				if (blkVslDeDt[i] != null)
					model.setBlkVslDeDt(blkVslDeDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (seaDoilTonCsm[i] != null)
					model.setSeaDoilTonCsm(seaDoilTonCsm[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (pnmGtWgt[i] != null)
					model.setPnmGtWgt(pnmGtWgt[i]);
				if (blstWgtSpd2[i] != null)
					model.setBlstWgtSpd2(blstWgtSpd2[i]);
				if (pmpOilCsm[i] != null)
					model.setPmpOilCsm(pmpOilCsm[i]);
				if (blstWgtSpd1[i] != null)
					model.setBlstWgtSpd1(blstWgtSpd1[i]);
				if (suzGtWgt[i] != null)
					model.setSuzGtWgt(suzGtWgt[i]);
				if (clnOilCsm[i] != null)
					model.setClnOilCsm(clnOilCsm[i]);
				if (portWrkDoilTonCsm[i] != null)
					model.setPortWrkDoilTonCsm(portWrkDoilTonCsm[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (lgtShpTongWgt[i] != null)
					model.setLgtShpTongWgt(lgtShpTongWgt[i]);
				if (vslDrftUtCd[i] != null)
					model.setVslDrftUtCd(vslDrftUtCd[i]);
				if (blkCrrTpCd[i] != null)
					model.setBlkCrrTpCd(blkCrrTpCd[i]);
				if (foilCapa[i] != null)
					model.setFoilCapa(foilCapa[i]);
				if (mnEngBhpPwr[i] != null)
					model.setMnEngBhpPwr(mnEngBhpPwr[i]);
				if (tnkTongCapa[i] != null)
					model.setTnkTongCapa(tnkTongCapa[i]);
				if (portFoilTonCsm[i] != null)
					model.setPortFoilTonCsm(portFoilTonCsm[i]);
				if (consTonWgt[i] != null)
					model.setConsTonWgt(consTonWgt[i]);
				if (foilLdnCsm2[i] != null)
					model.setFoilLdnCsm2(foilLdnCsm2[i]);
				if (vslBmUtCd[i] != null)
					model.setVslBmUtCd(vslBmUtCd[i]);
				if (foilLdnCsm1[i] != null)
					model.setFoilLdnCsm1(foilLdnCsm1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmVslBlkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmVslBlkVO[]
	 */
	public MdmVslBlkVO[] getMdmVslBlkVOs(){
		MdmVslBlkVO[] vos = (MdmVslBlkVO[])models.toArray(new MdmVslBlkVO[models.size()]);
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
		this.tropDwtWgt = this.tropDwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldnWgtSpd2 = this.ldnWgtSpd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldnWgtSpd1 = this.ldnWgtSpd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smrTpcTonWgt = this.smrTpcTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htFoilCsm = this.htFoilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapaUtCd = this.vslCapaUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wntDwtWgt = this.wntDwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnchDt = this.lnchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilCapa = this.doilCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnCustNm = this.vslOwnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssFlg = this.vslClssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loaUtCd = this.loaUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmpOilKndCd = this.pmpOilKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clnOilKndCd = this.clnOilKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frshWtrCapa = this.frshWtrCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCgoGrNm = this.vslCgoGrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portIdleDoilTonCsm = this.portIdleDoilTonCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkMnEngTpCd = this.blkMnEngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHldKnt = this.vslHldKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstPortCd = this.rgstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wntTpcTonWgt = this.wntTpcTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkVslClssCd = this.blkVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzNetTongWgt = this.suzNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tropTpcTonWgt = this.tropTpcTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmNetTongWgt = this.pnmNetTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smrDrftHgt = this.smrDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bailTongCapa = this.bailTongCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smrDwtWgt = this.smrDwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entTpCd = this.entTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBmWdt = this.vslBmWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRmk = this.vslRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoNo = this.imoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wntDrftHgt = this.wntDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnCustCntCd = this.vslOwnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loaLen = this.loaLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngMkrNm = this.mnEngMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldrNm = this.vslBldrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslHtchKnt = this.vslHtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grnTongCapa = this.grnTongCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldDt = this.vslBldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnCustSeq = this.vslOwnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBunkUtCd = this.vslBunkUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBlstCsm1 = this.foilBlstCsm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDwtUtCd = this.vslDwtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBlstCsm2 = this.foilBlstCsm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKrnNm = this.vslKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tropDrftHgt = this.tropDrftHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkVslDeDt = this.blkVslDeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDoilTonCsm = this.seaDoilTonCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnmGtWgt = this.pnmGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blstWgtSpd2 = this.blstWgtSpd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmpOilCsm = this.pmpOilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blstWgtSpd1 = this.blstWgtSpd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.suzGtWgt = this.suzGtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clnOilCsm = this.clnOilCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portWrkDoilTonCsm = this.portWrkDoilTonCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgtShpTongWgt = this.lgtShpTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDrftUtCd = this.vslDrftUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkCrrTpCd = this.blkCrrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilCapa = this.foilCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnEngBhpPwr = this.mnEngBhpPwr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkTongCapa = this.tnkTongCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portFoilTonCsm = this.portFoilTonCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consTonWgt = this.consTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilLdnCsm2 = this.foilLdnCsm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBmUtCd = this.vslBmUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilLdnCsm1 = this.foilLdnCsm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
