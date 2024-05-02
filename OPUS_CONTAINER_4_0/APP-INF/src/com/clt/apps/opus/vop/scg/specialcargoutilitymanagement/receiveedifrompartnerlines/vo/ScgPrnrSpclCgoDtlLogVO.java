/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrSpclCgoDtlLogVO.java
 *@FileTitle : ScgPrnrSpclCgoDtlLogVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.11
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.11 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

import java.lang.reflect.Field;
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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ScgPrnrSpclCgoDtlLogVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgPrnrSpclCgoDtlLogVO> models = new ArrayList<ScgPrnrSpclCgoDtlLogVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String trsmBndCd = null;

    /*	Column Info	*/
    private String trsmDt = null;

    /*	Column Info	*/
    private String spclCgoCateCd = null;

    /*	Column Info	*/
    private String prnrSpclCgoSeq = null;

    /*	Column Info	*/
    private String prnrSpclCgoSubSeq = null;

    /*	Column Info	*/
    private String cntrRefNo = null;

    /*	Column Info	*/
    private String cntrTpszCdCtnt = null;

    /*	Column Info	*/
    private String isoCntrTpszCd = null;

    /*	Column Info	*/
    private String cgoSeq = null;

    /*	Column Info	*/
    private String dcgoStsCdCtnt = null;

    /*	Column Info	*/
    private String refNo = null;

    /*	Column Info	*/
    private String mvmtSpclTpCd = null;

    /*	Column Info	*/
    private String outN1stImdgPckCdCtnt = null;

    /*	Column Info	*/
    private String outN1stImdgPckQtyCtnt = null;

    /*	Column Info	*/
    private String outN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String intmdN1stImdgPckCdCtnt = null;

    /*	Column Info	*/
    private String intmdN1stImdgPckQtyCtnt = null;

    /*	Column Info	*/
    private String intmdN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String inN1stImdgPckCdCtnt = null;

    /*	Column Info	*/
    private String inN1stImdgPckQtyCtnt = null;

    /*	Column Info	*/
    private String inN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String hzdDesc = null;

    /*	Column Info	*/
    private String prpShpNm = null;

    /*	Column Info	*/
    private String imdgTecNm = null;

    /*	Column Info	*/
    private String imdgClssCdCtnt = null;

    /*	Column Info	*/
    private String imdgPprNo = null;

    /*	Column Info	*/
    private String imdgUnNoCtnt = null;

    /*	Column Info	*/
    private String imdgUnNoSeq = null;

    /*	Column Info	*/
    private String cfrFlg = null;

    /*	Column Info	*/
    private String cfrNo = null;

    /*	Column Info	*/
    private String flshPntUtCdCtnt = null;

    /*	Column Info	*/
    private String flshPntTempCtnt = null;

    /*	Column Info	*/
    private String imdgPckGrpCdCtnt = null;

    /*	Column Info	*/
    private String emsNo = null;

    /*	Column Info	*/
    private String mfagNo = null;

    /*	Column Info	*/
    private String espNo = null;

    /*	Column Info	*/
    private String imdgMrnPolutFlg = null;

    /*	Column Info	*/
    private String imdgMrnPolutCdCtnt = null;

    /*	Column Info	*/
    private String imdgLmtQtyFlgCtnt = null;

    /*	Column Info	*/
    private String imdgExptQtyFlgCtnt = null;

    /*	Column Info	*/
    private String grsWgtUtCdCtnt = null;

    /*	Column Info	*/
    private String grsWgtCtnt = null;

    /*	Column Info	*/
    private String netWgtUtCdCtnt = null;

    /*	Column Info	*/
    private String netWgtCtnt = null;

    /*	Column Info	*/
    private String pckTpCdCtnt = null;

    /*	Column Info	*/
    private String pckQtyCtnt = null;

    /*	Column Info	*/
    private String diffRmk = null;

    /*	Column Info	*/
    private String emerCntcPhnNo = null;

    /*	Column Info	*/
    private String emerCntcPsonNm = null;

    /*	Column Info	*/
    private String psaNo = null;

    /*	Column Info	*/
    private String spclStwgRqstDesc = null;

    /*	Column Info	*/
    private String rsdFlgCtnt = null;

    /*	Column Info	*/
    private String cntrSeq = null;

    /*	Column Info	*/
    private String netExploWgtUtCdCtnt = null;

    /*	Column Info	*/
    private String netExploWgtCtnt = null;

    /*	Column Info	*/
    private String crrCd = null;

    /*	Column Info	*/
    private String spclCgoRqstSeq = null;

    /*	Column Info	*/
    private String cntrDmyRefNo = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String dcgoRefNo = null;

    /* Column Info */
    private String dcgoSeq = null;

    /* Column Info */
    private String imdgAmdtNo = null;

    /* Column Info */
    private String imdgCompGrpCd = null;

    /* Column Info */
    private String n1stImdgSubsRskLblCd = null;

    /* Column Info */
    private String n2ndImdgSubsRskLblCd = null;

    /* Column Info */
    private String n3rdImdgSubsRskLblCd = null;

    /* Column Info */
    private String n4thImdgSubsRskLblCd = null;

    /* Column Info */
    private String ediItmSeq = null;

    /* Column Info */
    private String n5thImdgSubsRskLblCd = null;

    /* Column Info */
    private String n6thImdgSubsRskLblCd = null;

    /* Column Info */
    private String n7thImdgSubsRskLblCd = null;

    /* Column Info */
    private String n8thImdgSubsRskLblCd = null;

    /* Column Info */
    private String ediCgoUnmapDtlCd = null;

    /* Column Info */
    private String dcgoDtlStsCdCtnt = null;

    /* Column Info */
    private String imdgAddSegrGrpNoCtnt = null;

    /* Column Info */
    private String imdgSegrGrpNoCtnt = null;

    /* Column Info */
    private String ctrlTempCtnt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public ScgPrnrSpclCgoDtlLogVO() {
    }

    public ScgPrnrSpclCgoDtlLogVO(String ibflag, String pagerows, String trsmBndCd, String trsmDt, String spclCgoCateCd, String prnrSpclCgoSeq, String prnrSpclCgoSubSeq, String cntrRefNo, String cntrTpszCdCtnt, String isoCntrTpszCd, String cgoSeq, String dcgoStsCdCtnt, String refNo, String mvmtSpclTpCd, String outN1stImdgPckCdCtnt, String outN1stImdgPckQtyCtnt, String outN1stImdgPckDesc, String intmdN1stImdgPckCdCtnt, String intmdN1stImdgPckQtyCtnt, String intmdN1stImdgPckDesc, String inN1stImdgPckCdCtnt, String inN1stImdgPckQtyCtnt, String inN1stImdgPckDesc, String hzdDesc, String prpShpNm, String imdgTecNm, String imdgClssCdCtnt, String imdgPprNo, String imdgUnNoCtnt, String imdgUnNoSeq, String cfrFlg, String cfrNo, String flshPntUtCdCtnt, String flshPntTempCtnt, String imdgPckGrpCdCtnt, String emsNo, String mfagNo, String espNo, String imdgMrnPolutFlg, String imdgMrnPolutCdCtnt, String imdgLmtQtyFlgCtnt, String imdgExptQtyFlgCtnt, String grsWgtUtCdCtnt, String grsWgtCtnt, String netWgtUtCdCtnt, String netWgtCtnt, String pckTpCdCtnt, String pckQtyCtnt, String diffRmk, String emerCntcPhnNo, String emerCntcPsonNm, String psaNo, String spclStwgRqstDesc, String rsdFlgCtnt, String cntrSeq, String netExploWgtUtCdCtnt, String netExploWgtCtnt, String crrCd, String spclCgoRqstSeq, String cntrDmyRefNo, String creUsrId, String creDt, String updUsrId, String updDt, String dcgoSeq, String imdgAmdtNo, String imdgCompGrpCd, String n1stImdgSubsRskLblCd, String n2ndImdgSubsRskLblCd, String n3rdImdgSubsRskLblCd, String n4thImdgSubsRskLblCd, String ediItmSeq, String n5thImdgSubsRskLblCd, String n6thImdgSubsRskLblCd, String n7thImdgSubsRskLblCd, String n8thImdgSubsRskLblCd, String ediCgoUnmapDtlCd, String dcgoDtlStsCdCtnt, String imdgAddSegrGrpNoCtnt, String imdgSegrGrpNoCtnt, String ctrlTempCtnt) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.trsmBndCd = trsmBndCd;
        this.trsmDt = trsmDt;
        this.spclCgoCateCd = spclCgoCateCd;
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
        this.prnrSpclCgoSubSeq = prnrSpclCgoSubSeq;
        this.cntrRefNo = cntrRefNo;
        this.cntrTpszCdCtnt = cntrTpszCdCtnt;
        this.isoCntrTpszCd = isoCntrTpszCd;
        this.cgoSeq = cgoSeq;
        this.dcgoStsCdCtnt = dcgoStsCdCtnt;
        this.refNo = refNo;
        this.mvmtSpclTpCd = mvmtSpclTpCd;
        this.outN1stImdgPckCdCtnt = outN1stImdgPckCdCtnt;
        this.outN1stImdgPckQtyCtnt = outN1stImdgPckQtyCtnt;
        this.outN1stImdgPckDesc = outN1stImdgPckDesc;
        this.intmdN1stImdgPckCdCtnt = intmdN1stImdgPckCdCtnt;
        this.intmdN1stImdgPckQtyCtnt = intmdN1stImdgPckQtyCtnt;
        this.intmdN1stImdgPckDesc = intmdN1stImdgPckDesc;
        this.inN1stImdgPckCdCtnt = inN1stImdgPckCdCtnt;
        this.inN1stImdgPckQtyCtnt = inN1stImdgPckQtyCtnt;
        this.inN1stImdgPckDesc = inN1stImdgPckDesc;
        this.hzdDesc = hzdDesc;
        this.prpShpNm = prpShpNm;
        this.imdgTecNm = imdgTecNm;
        this.imdgClssCdCtnt = imdgClssCdCtnt;
        this.imdgPprNo = imdgPprNo;
        this.imdgUnNoCtnt = imdgUnNoCtnt;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.cfrFlg = cfrFlg;
        this.cfrNo = cfrNo;
        this.flshPntUtCdCtnt = flshPntUtCdCtnt;
        this.flshPntTempCtnt = flshPntTempCtnt;
        this.imdgPckGrpCdCtnt = imdgPckGrpCdCtnt;
        this.emsNo = emsNo;
        this.mfagNo = mfagNo;
        this.espNo = espNo;
        this.imdgMrnPolutFlg = imdgMrnPolutFlg;
        this.imdgMrnPolutCdCtnt = imdgMrnPolutCdCtnt;
        this.imdgLmtQtyFlgCtnt = imdgLmtQtyFlgCtnt;
        this.imdgExptQtyFlgCtnt = imdgExptQtyFlgCtnt;
        this.grsWgtUtCdCtnt = grsWgtUtCdCtnt;
        this.grsWgtCtnt = grsWgtCtnt;
        this.netWgtUtCdCtnt = netWgtUtCdCtnt;
        this.netWgtCtnt = netWgtCtnt;
        this.pckTpCdCtnt = pckTpCdCtnt;
        this.pckQtyCtnt = pckQtyCtnt;
        this.diffRmk = diffRmk;
        this.emerCntcPhnNo = emerCntcPhnNo;
        this.emerCntcPsonNm = emerCntcPsonNm;
        this.psaNo = psaNo;
        this.spclStwgRqstDesc = spclStwgRqstDesc;
        this.rsdFlgCtnt = rsdFlgCtnt;
        this.cntrSeq = cntrSeq;
        this.netExploWgtUtCdCtnt = netExploWgtUtCdCtnt;
        this.netExploWgtCtnt = netExploWgtCtnt;
        this.crrCd = crrCd;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.cntrDmyRefNo = cntrDmyRefNo;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.dcgoSeq = dcgoSeq;
        this.imdgAmdtNo = imdgAmdtNo;
        this.imdgCompGrpCd = imdgCompGrpCd;
        this.n1stImdgSubsRskLblCd = n1stImdgSubsRskLblCd;
        this.n2ndImdgSubsRskLblCd = n2ndImdgSubsRskLblCd;
        this.n3rdImdgSubsRskLblCd = n3rdImdgSubsRskLblCd;
        this.n4thImdgSubsRskLblCd = n4thImdgSubsRskLblCd;
        this.ediItmSeq = ediItmSeq;
        this.n5thImdgSubsRskLblCd = n5thImdgSubsRskLblCd;
        this.n6thImdgSubsRskLblCd = n6thImdgSubsRskLblCd;
        this.n7thImdgSubsRskLblCd = n7thImdgSubsRskLblCd;
        this.n8thImdgSubsRskLblCd = n8thImdgSubsRskLblCd;
        this.ediCgoUnmapDtlCd = ediCgoUnmapDtlCd;
        this.dcgoDtlStsCdCtnt = dcgoDtlStsCdCtnt;
        this.imdgAddSegrGrpNoCtnt = imdgAddSegrGrpNoCtnt;
        this.imdgSegrGrpNoCtnt = imdgSegrGrpNoCtnt;
        this.ctrlTempCtnt = ctrlTempCtnt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("trsm_bnd_cd", getTrsmBndCd());
        this.hashColumns.put("trsm_dt", getTrsmDt());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
        this.hashColumns.put("prnr_spcl_cgo_sub_seq", getPrnrSpclCgoSubSeq());
        this.hashColumns.put("cntr_ref_no", getCntrRefNo());
        this.hashColumns.put("cntr_tpsz_cd_ctnt", getCntrTpszCdCtnt());
        this.hashColumns.put("iso_cntr_tpsz_cd", getIsoCntrTpszCd());
        this.hashColumns.put("cgo_seq", getCgoSeq());
        this.hashColumns.put("dcgo_sts_cd_ctnt", getDcgoStsCdCtnt());
        this.hashColumns.put("ref_no", getRefNo());
        this.hashColumns.put("mvmt_spcl_tp_cd", getMvmtSpclTpCd());
        this.hashColumns.put("out_n1st_imdg_pck_cd_ctnt", getOutN1stImdgPckCdCtnt());
        this.hashColumns.put("out_n1st_imdg_pck_qty_ctnt", getOutN1stImdgPckQtyCtnt());
        this.hashColumns.put("out_n1st_imdg_pck_desc", getOutN1stImdgPckDesc());
        this.hashColumns.put("intmd_n1st_imdg_pck_cd_ctnt", getIntmdN1stImdgPckCdCtnt());
        this.hashColumns.put("intmd_n1st_imdg_pck_qty_ctnt", getIntmdN1stImdgPckQtyCtnt());
        this.hashColumns.put("intmd_n1st_imdg_pck_desc", getIntmdN1stImdgPckDesc());
        this.hashColumns.put("in_n1st_imdg_pck_cd_ctnt", getInN1stImdgPckCdCtnt());
        this.hashColumns.put("in_n1st_imdg_pck_qty_ctnt", getInN1stImdgPckQtyCtnt());
        this.hashColumns.put("in_n1st_imdg_pck_desc", getInN1stImdgPckDesc());
        this.hashColumns.put("hzd_desc", getHzdDesc());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
        this.hashColumns.put("imdg_clss_cd_ctnt", getImdgClssCdCtnt());
        this.hashColumns.put("imdg_ppr_no", getImdgPprNo());
        this.hashColumns.put("imdg_un_no_ctnt", getImdgUnNoCtnt());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("cfr_flg", getCfrFlg());
        this.hashColumns.put("cfr_no", getCfrNo());
        this.hashColumns.put("flsh_pnt_ut_cd_ctnt", getFlshPntUtCdCtnt());
        this.hashColumns.put("flsh_pnt_temp_ctnt", getFlshPntTempCtnt());
        this.hashColumns.put("imdg_pck_grp_cd_ctnt", getImdgPckGrpCdCtnt());
        this.hashColumns.put("ems_no", getEmsNo());
        this.hashColumns.put("mfag_no", getMfagNo());
        this.hashColumns.put("esp_no", getEspNo());
        this.hashColumns.put("imdg_mrn_polut_flg", getImdgMrnPolutFlg());
        this.hashColumns.put("imdg_mrn_polut_cd_ctnt", getImdgMrnPolutCdCtnt());
        this.hashColumns.put("imdg_lmt_qty_flg_ctnt", getImdgLmtQtyFlgCtnt());
        this.hashColumns.put("imdg_expt_qty_flg_ctnt", getImdgExptQtyFlgCtnt());
        this.hashColumns.put("grs_wgt_ut_cd_ctnt", getGrsWgtUtCdCtnt());
        this.hashColumns.put("grs_wgt_ctnt", getGrsWgtCtnt());
        this.hashColumns.put("net_wgt_ut_cd_ctnt", getNetWgtUtCdCtnt());
        this.hashColumns.put("net_wgt_ctnt", getNetWgtCtnt());
        this.hashColumns.put("pck_tp_cd_ctnt", getPckTpCdCtnt());
        this.hashColumns.put("pck_qty_ctnt", getPckQtyCtnt());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("emer_cntc_phn_no", getEmerCntcPhnNo());
        this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());
        this.hashColumns.put("psa_no", getPsaNo());
        this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
        this.hashColumns.put("rsd_flg_ctnt", getRsdFlgCtnt());
        this.hashColumns.put("cntr_seq", getCntrSeq());
        this.hashColumns.put("net_explo_wgt_ut_cd_ctnt", getNetExploWgtUtCdCtnt());
        this.hashColumns.put("net_explo_wgt_ctnt", getNetExploWgtCtnt());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("cntr_dmy_ref_no", getCntrDmyRefNo());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("dcgo_seq", getDcgoSeq());
        this.hashColumns.put("imdg_amdt_no", getImdgAmdtNo());
        this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
        this.hashColumns.put("n1st_imdg_subs_rsk_lbl_cd", getN1stImdgSubsRskLblCd());
        this.hashColumns.put("n2nd_imdg_subs_rsk_lbl_cd", getN2ndImdgSubsRskLblCd());
        this.hashColumns.put("n3rd_imdg_subs_rsk_lbl_cd", getN3rdImdgSubsRskLblCd());
        this.hashColumns.put("n4th_imdg_subs_rsk_lbl_cd", getN4thImdgSubsRskLblCd());
        this.hashColumns.put("edi_itm_seq", getEdiItmSeq());
        this.hashColumns.put("n5th_imdg_subs_rsk_lbl_cd", getN5thImdgSubsRskLblCd());
        this.hashColumns.put("n6th_imdg_subs_rsk_lbl_cd", getN6thImdgSubsRskLblCd());
        this.hashColumns.put("n7th_imdg_subs_rsk_lbl_cd", getN7thImdgSubsRskLblCd());
        this.hashColumns.put("n8th_imdg_subs_rsk_lbl_cd", getN8thImdgSubsRskLblCd());
        this.hashColumns.put("edi_cgo_unmap_dtl_cd", getEdiCgoUnmapDtlCd());
        this.hashColumns.put("dcgo_dtl_sts_cd_ctnt", getDcgoDtlStsCdCtnt());
        this.hashColumns.put("imdg_add_segr_grp_no_ctnt", getImdgAddSegrGrpNoCtnt());
        this.hashColumns.put("imdg_segr_grp_no_ctnt", getImdgSegrGrpNoCtnt());
        this.hashColumns.put("ctrl_temp_ctnt", getCtrlTempCtnt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("trsm_bnd_cd", "trsmBndCd");
        this.hashFields.put("trsm_dt", "trsmDt");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
        this.hashFields.put("prnr_spcl_cgo_sub_seq", "prnrSpclCgoSubSeq");
        this.hashFields.put("cntr_ref_no", "cntrRefNo");
        this.hashFields.put("cntr_tpsz_cd_ctnt", "cntrTpszCdCtnt");
        this.hashFields.put("iso_cntr_tpsz_cd", "isoCntrTpszCd");
        this.hashFields.put("cgo_seq", "cgoSeq");
        this.hashFields.put("dcgo_sts_cd_ctnt", "dcgoStsCdCtnt");
        this.hashFields.put("ref_no", "refNo");
        this.hashFields.put("mvmt_spcl_tp_cd", "mvmtSpclTpCd");
        this.hashFields.put("out_n1st_imdg_pck_cd_ctnt", "outN1stImdgPckCdCtnt");
        this.hashFields.put("out_n1st_imdg_pck_qty_ctnt", "outN1stImdgPckQtyCtnt");
        this.hashFields.put("out_n1st_imdg_pck_desc", "outN1stImdgPckDesc");
        this.hashFields.put("intmd_n1st_imdg_pck_cd_ctnt", "intmdN1stImdgPckCdCtnt");
        this.hashFields.put("intmd_n1st_imdg_pck_qty_ctnt", "intmdN1stImdgPckQtyCtnt");
        this.hashFields.put("intmd_n1st_imdg_pck_desc", "intmdN1stImdgPckDesc");
        this.hashFields.put("in_n1st_imdg_pck_cd_ctnt", "inN1stImdgPckCdCtnt");
        this.hashFields.put("in_n1st_imdg_pck_qty_ctnt", "inN1stImdgPckQtyCtnt");
        this.hashFields.put("in_n1st_imdg_pck_desc", "inN1stImdgPckDesc");
        this.hashFields.put("hzd_desc", "hzdDesc");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("imdg_tec_nm", "imdgTecNm");
        this.hashFields.put("imdg_clss_cd_ctnt", "imdgClssCdCtnt");
        this.hashFields.put("imdg_ppr_no", "imdgPprNo");
        this.hashFields.put("imdg_un_no_ctnt", "imdgUnNoCtnt");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("cfr_flg", "cfrFlg");
        this.hashFields.put("cfr_no", "cfrNo");
        this.hashFields.put("flsh_pnt_ut_cd_ctnt", "flshPntUtCdCtnt");
        this.hashFields.put("flsh_pnt_temp_ctnt", "flshPntTempCtnt");
        this.hashFields.put("imdg_pck_grp_cd_ctnt", "imdgPckGrpCdCtnt");
        this.hashFields.put("ems_no", "emsNo");
        this.hashFields.put("mfag_no", "mfagNo");
        this.hashFields.put("esp_no", "espNo");
        this.hashFields.put("imdg_mrn_polut_flg", "imdgMrnPolutFlg");
        this.hashFields.put("imdg_mrn_polut_cd_ctnt", "imdgMrnPolutCdCtnt");
        this.hashFields.put("imdg_lmt_qty_flg_ctnt", "imdgLmtQtyFlgCtnt");
        this.hashFields.put("imdg_expt_qty_flg_ctnt", "imdgExptQtyFlgCtnt");
        this.hashFields.put("grs_wgt_ut_cd_ctnt", "grsWgtUtCdCtnt");
        this.hashFields.put("grs_wgt_ctnt", "grsWgtCtnt");
        this.hashFields.put("net_wgt_ut_cd_ctnt", "netWgtUtCdCtnt");
        this.hashFields.put("net_wgt_ctnt", "netWgtCtnt");
        this.hashFields.put("pck_tp_cd_ctnt", "pckTpCdCtnt");
        this.hashFields.put("pck_qty_ctnt", "pckQtyCtnt");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("emer_cntc_phn_no", "emerCntcPhnNo");
        this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
        this.hashFields.put("psa_no", "psaNo");
        this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
        this.hashFields.put("rsd_flg_ctnt", "rsdFlgCtnt");
        this.hashFields.put("cntr_seq", "cntrSeq");
        this.hashFields.put("net_explo_wgt_ut_cd_ctnt", "netExploWgtUtCdCtnt");
        this.hashFields.put("net_explo_wgt_ctnt", "netExploWgtCtnt");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("cntr_dmy_ref_no", "cntrDmyRefNo");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("dcgo_seq", "dcgoSeq");
        this.hashFields.put("imdg_amdt_no", "imdgAmdtNo");
        this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
        this.hashFields.put("n1st_imdg_subs_rsk_lbl_cd", "n1stImdgSubsRskLblCd");
        this.hashFields.put("n2nd_imdg_subs_rsk_lbl_cd", "n2ndImdgSubsRskLblCd");
        this.hashFields.put("n3rd_imdg_subs_rsk_lbl_cd", "n3rdImdgSubsRskLblCd");
        this.hashFields.put("n4th_imdg_subs_rsk_lbl_cd", "n4thImdgSubsRskLblCd");
        this.hashFields.put("edi_itm_seq", "ediItmSeq");
        this.hashFields.put("n5th_imdg_subs_rsk_lbl_cd", "n5thImdgSubsRskLblCd");
        this.hashFields.put("n6th_imdg_subs_rsk_lbl_cd", "n6thImdgSubsRskLblCd");
        this.hashFields.put("n7th_imdg_subs_rsk_lbl_cd", "n7thImdgSubsRskLblCd");
        this.hashFields.put("n8th_imdg_subs_rsk_lbl_cd", "n8thImdgSubsRskLblCd");
        this.hashFields.put("edi_cgo_unmap_dtl_cd", "ediCgoUnmapDtlCd");
        this.hashFields.put("dcgo_dtl_sts_cd_ctnt", "dcgoDtlStsCdCtnt");
        this.hashFields.put("imdg_add_segr_grp_no_ctnt", "imdgAddSegrGrpNoCtnt");
        this.hashFields.put("imdg_segr_grp_no_ctnt", "imdgSegrGrpNoCtnt");
        this.hashFields.put("ctrl_temp_ctnt", "ctrlTempCtnt");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @return trsmBndCd
	 */
    public String getTrsmBndCd() {
        return this.trsmBndCd;
    }

    /**
	 * Column Info
	 * @return trsmDt
	 */
    public String getTrsmDt() {
        return this.trsmDt;
    }

    /**
	 * Column Info
	 * @return spclCgoCateCd
	 */
    public String getSpclCgoCateCd() {
        return this.spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @return prnrSpclCgoSeq
	 */
    public String getPrnrSpclCgoSeq() {
        return this.prnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @return prnrSpclCgoSubSeq
	 */
    public String getPrnrSpclCgoSubSeq() {
        return this.prnrSpclCgoSubSeq;
    }

    /**
	 * Column Info
	 * @return cntrRefNo
	 */
    public String getCntrRefNo() {
        return this.cntrRefNo;
    }

    /**
	 * Column Info
	 * @return cntrTpszCdCtnt
	 */
    public String getCntrTpszCdCtnt() {
        return this.cntrTpszCdCtnt;
    }

    /**
	 * Column Info
	 * @return isoCntrTpszCd
	 */
    public String getIsoCntrTpszCd() {
        return this.isoCntrTpszCd;
    }

    /**
	 * Column Info
	 * @return cgoSeq
	 */
    public String getCgoSeq() {
        return this.cgoSeq;
    }

    /**
	 * Column Info
	 * @return dcgoStsCdCtnt
	 */
    public String getDcgoStsCdCtnt() {
        return this.dcgoStsCdCtnt;
    }

    /**
	 * Column Info
	 * @return refNo
	 */
    public String getRefNo() {
        return this.refNo;
    }

    /**
	 * Column Info
	 * @return mvmtSpclTpCd
	 */
    public String getMvmtSpclTpCd() {
        return this.mvmtSpclTpCd;
    }

    /**
	 * Column Info
	 * @return outN1stImdgPckCdCtnt
	 */
    public String getOutN1stImdgPckCdCtnt() {
        return this.outN1stImdgPckCdCtnt;
    }

    /**
	 * Column Info
	 * @return outN1stImdgPckQtyCtnt
	 */
    public String getOutN1stImdgPckQtyCtnt() {
        return this.outN1stImdgPckQtyCtnt;
    }

    /**
	 * Column Info
	 * @return outN1stImdgPckDesc
	 */
    public String getOutN1stImdgPckDesc() {
        return this.outN1stImdgPckDesc;
    }

    /**
	 * Column Info
	 * @return intmdN1stImdgPckCdCtnt
	 */
    public String getIntmdN1stImdgPckCdCtnt() {
        return this.intmdN1stImdgPckCdCtnt;
    }

    /**
	 * Column Info
	 * @return intmdN1stImdgPckQtyCtnt
	 */
    public String getIntmdN1stImdgPckQtyCtnt() {
        return this.intmdN1stImdgPckQtyCtnt;
    }

    /**
	 * Column Info
	 * @return intmdN1stImdgPckDesc
	 */
    public String getIntmdN1stImdgPckDesc() {
        return this.intmdN1stImdgPckDesc;
    }

    /**
	 * Column Info
	 * @return inN1stImdgPckCdCtnt
	 */
    public String getInN1stImdgPckCdCtnt() {
        return this.inN1stImdgPckCdCtnt;
    }

    /**
	 * Column Info
	 * @return inN1stImdgPckQtyCtnt
	 */
    public String getInN1stImdgPckQtyCtnt() {
        return this.inN1stImdgPckQtyCtnt;
    }

    /**
	 * Column Info
	 * @return inN1stImdgPckDesc
	 */
    public String getInN1stImdgPckDesc() {
        return this.inN1stImdgPckDesc;
    }

    /**
	 * Column Info
	 * @return hzdDesc
	 */
    public String getHzdDesc() {
        return this.hzdDesc;
    }

    /**
	 * Column Info
	 * @return prpShpNm
	 */
    public String getPrpShpNm() {
        return this.prpShpNm;
    }

    /**
	 * Column Info
	 * @return imdgTecNm
	 */
    public String getImdgTecNm() {
        return this.imdgTecNm;
    }

    /**
	 * Column Info
	 * @return imdgClssCdCtnt
	 */
    public String getImdgClssCdCtnt() {
        return this.imdgClssCdCtnt;
    }

    /**
	 * Column Info
	 * @return imdgPprNo
	 */
    public String getImdgPprNo() {
        return this.imdgPprNo;
    }

    /**
	 * Column Info
	 * @return imdgUnNoCtnt
	 */
    public String getImdgUnNoCtnt() {
        return this.imdgUnNoCtnt;
    }

    /**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
    public String getImdgUnNoSeq() {
        return this.imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @return cfrFlg
	 */
    public String getCfrFlg() {
        return this.cfrFlg;
    }

    /**
	 * Column Info
	 * @return cfrNo
	 */
    public String getCfrNo() {
        return this.cfrNo;
    }

    /**
	 * Column Info
	 * @return flshPntUtCdCtnt
	 */
    public String getFlshPntUtCdCtnt() {
        return this.flshPntUtCdCtnt;
    }

    /**
	 * Column Info
	 * @return flshPntTempCtnt
	 */
    public String getFlshPntTempCtnt() {
        return this.flshPntTempCtnt;
    }

    /**
	 * Column Info
	 * @return imdgPckGrpCdCtnt
	 */
    public String getImdgPckGrpCdCtnt() {
        return this.imdgPckGrpCdCtnt;
    }

    /**
	 * Column Info
	 * @return emsNo
	 */
    public String getEmsNo() {
        return this.emsNo;
    }

    /**
	 * Column Info
	 * @return mfagNo
	 */
    public String getMfagNo() {
        return this.mfagNo;
    }

    /**
	 * Column Info
	 * @return espNo
	 */
    public String getEspNo() {
        return this.espNo;
    }

    /**
	 * Column Info
	 * @return imdgMrnPolutFlg
	 */
    public String getImdgMrnPolutFlg() {
        return this.imdgMrnPolutFlg;
    }

    /**
	 * Column Info
	 * @return imdgMrnPolutCdCtnt
	 */
    public String getImdgMrnPolutCdCtnt() {
        return this.imdgMrnPolutCdCtnt;
    }

    /**
	 * Column Info
	 * @return imdgLmtQtyFlgCtnt
	 */
    public String getImdgLmtQtyFlgCtnt() {
        return this.imdgLmtQtyFlgCtnt;
    }

    /**
	 * Column Info
	 * @return imdgExptQtyFlgCtnt
	 */
    public String getImdgExptQtyFlgCtnt() {
        return this.imdgExptQtyFlgCtnt;
    }

    /**
	 * Column Info
	 * @return grsWgtUtCdCtnt
	 */
    public String getGrsWgtUtCdCtnt() {
        return this.grsWgtUtCdCtnt;
    }

    /**
	 * Column Info
	 * @return grsWgtCtnt
	 */
    public String getGrsWgtCtnt() {
        return this.grsWgtCtnt;
    }

    /**
	 * Column Info
	 * @return netWgtUtCdCtnt
	 */
    public String getNetWgtUtCdCtnt() {
        return this.netWgtUtCdCtnt;
    }

    /**
	 * Column Info
	 * @return netWgtCtnt
	 */
    public String getNetWgtCtnt() {
        return this.netWgtCtnt;
    }

    /**
	 * Column Info
	 * @return pckTpCdCtnt
	 */
    public String getPckTpCdCtnt() {
        return this.pckTpCdCtnt;
    }

    /**
	 * Column Info
	 * @return pckQtyCtnt
	 */
    public String getPckQtyCtnt() {
        return this.pckQtyCtnt;
    }

    /**
	 * Column Info
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
    }

    /**
	 * Column Info
	 * @return emerCntcPhnNo
	 */
    public String getEmerCntcPhnNo() {
        return this.emerCntcPhnNo;
    }

    /**
	 * Column Info
	 * @return emerCntcPsonNm
	 */
    public String getEmerCntcPsonNm() {
        return this.emerCntcPsonNm;
    }

    /**
	 * Column Info
	 * @return psaNo
	 */
    public String getPsaNo() {
        return this.psaNo;
    }

    /**
	 * Column Info
	 * @return spclStwgRqstDesc
	 */
    public String getSpclStwgRqstDesc() {
        return this.spclStwgRqstDesc;
    }

    /**
	 * Column Info
	 * @return rsdFlgCtnt
	 */
    public String getRsdFlgCtnt() {
        return this.rsdFlgCtnt;
    }

    /**
	 * Column Info
	 * @return cntrSeq
	 */
    public String getCntrSeq() {
        return this.cntrSeq;
    }

    /**
	 * Column Info
	 * @return netExploWgtUtCdCtnt
	 */
    public String getNetExploWgtUtCdCtnt() {
        return this.netExploWgtUtCdCtnt;
    }

    /**
	 * Column Info
	 * @return netExploWgtCtnt
	 */
    public String getNetExploWgtCtnt() {
        return this.netExploWgtCtnt;
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
	 * @return spclCgoRqstSeq
	 */
    public String getSpclCgoRqstSeq() {
        return this.spclCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @return cntrDmyRefNo
	 */
    public String getCntrDmyRefNo() {
        return this.cntrDmyRefNo;
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
	 * @return creDt
	 */
    public String getCreDt() {
        return this.creDt;
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
	 * @return updDt
	 */
    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Column Info
	 * @return dcgoRefNo
	 */
    public String getDcgoRefNo() {
        return this.dcgoRefNo;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  dcgoRefNo
 	 */
    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param  pagerows
 	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    /**
	 * Column Info
	 * @param  trsmBndCd
 	 */
    public void setTrsmBndCd(String trsmBndCd) {
        this.trsmBndCd = trsmBndCd;
    }

    /**
	 * Column Info
	 * @param  trsmDt
 	 */
    public void setTrsmDt(String trsmDt) {
        this.trsmDt = trsmDt;
    }

    /**
	 * Column Info
	 * @param  spclCgoCateCd
 	 */
    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param  prnrSpclCgoSeq
 	 */
    public void setPrnrSpclCgoSeq(String prnrSpclCgoSeq) {
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @param  prnrSpclCgoSubSeq
 	 */
    public void setPrnrSpclCgoSubSeq(String prnrSpclCgoSubSeq) {
        this.prnrSpclCgoSubSeq = prnrSpclCgoSubSeq;
    }

    /**
	 * Column Info
	 * @param  cntrRefNo
 	 */
    public void setCntrRefNo(String cntrRefNo) {
        this.cntrRefNo = cntrRefNo;
    }

    /**
	 * Column Info
	 * @param  cntrTpszCdCtnt
 	 */
    public void setCntrTpszCdCtnt(String cntrTpszCdCtnt) {
        this.cntrTpszCdCtnt = cntrTpszCdCtnt;
    }

    /**
	 * Column Info
	 * @param  isoCntrTpszCd
 	 */
    public void setIsoCntrTpszCd(String isoCntrTpszCd) {
        this.isoCntrTpszCd = isoCntrTpszCd;
    }

    /**
	 * Column Info
	 * @param  cgoSeq
 	 */
    public void setCgoSeq(String cgoSeq) {
        this.cgoSeq = cgoSeq;
    }

    /**
	 * Column Info
	 * @param  dcgoStsCdCtnt
 	 */
    public void setDcgoStsCdCtnt(String dcgoStsCdCtnt) {
        this.dcgoStsCdCtnt = dcgoStsCdCtnt;
    }

    /**
	 * Column Info
	 * @param  refNo
 	 */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    /**
	 * Column Info
	 * @param  mvmtSpclTpCd
 	 */
    public void setMvmtSpclTpCd(String mvmtSpclTpCd) {
        this.mvmtSpclTpCd = mvmtSpclTpCd;
    }

    /**
	 * Column Info
	 * @param  outN1stImdgPckCdCtnt
 	 */
    public void setOutN1stImdgPckCdCtnt(String outN1stImdgPckCdCtnt) {
        this.outN1stImdgPckCdCtnt = outN1stImdgPckCdCtnt;
    }

    /**
	 * Column Info
	 * @param  outN1stImdgPckQtyCtnt
 	 */
    public void setOutN1stImdgPckQtyCtnt(String outN1stImdgPckQtyCtnt) {
        this.outN1stImdgPckQtyCtnt = outN1stImdgPckQtyCtnt;
    }

    /**
	 * Column Info
	 * @param  outN1stImdgPckDesc
 	 */
    public void setOutN1stImdgPckDesc(String outN1stImdgPckDesc) {
        this.outN1stImdgPckDesc = outN1stImdgPckDesc;
    }

    /**
	 * Column Info
	 * @param  intmdN1stImdgPckCdCtnt
 	 */
    public void setIntmdN1stImdgPckCdCtnt(String intmdN1stImdgPckCdCtnt) {
        this.intmdN1stImdgPckCdCtnt = intmdN1stImdgPckCdCtnt;
    }

    /**
	 * Column Info
	 * @param  intmdN1stImdgPckQtyCtnt
 	 */
    public void setIntmdN1stImdgPckQtyCtnt(String intmdN1stImdgPckQtyCtnt) {
        this.intmdN1stImdgPckQtyCtnt = intmdN1stImdgPckQtyCtnt;
    }

    /**
	 * Column Info
	 * @param  intmdN1stImdgPckDesc
 	 */
    public void setIntmdN1stImdgPckDesc(String intmdN1stImdgPckDesc) {
        this.intmdN1stImdgPckDesc = intmdN1stImdgPckDesc;
    }

    /**
	 * Column Info
	 * @param  inN1stImdgPckCdCtnt
 	 */
    public void setInN1stImdgPckCdCtnt(String inN1stImdgPckCdCtnt) {
        this.inN1stImdgPckCdCtnt = inN1stImdgPckCdCtnt;
    }

    /**
	 * Column Info
	 * @param  inN1stImdgPckQtyCtnt
 	 */
    public void setInN1stImdgPckQtyCtnt(String inN1stImdgPckQtyCtnt) {
        this.inN1stImdgPckQtyCtnt = inN1stImdgPckQtyCtnt;
    }

    /**
	 * Column Info
	 * @param  inN1stImdgPckDesc
 	 */
    public void setInN1stImdgPckDesc(String inN1stImdgPckDesc) {
        this.inN1stImdgPckDesc = inN1stImdgPckDesc;
    }

    /**
	 * Column Info
	 * @param  hzdDesc
 	 */
    public void setHzdDesc(String hzdDesc) {
        this.hzdDesc = hzdDesc;
    }

    /**
	 * Column Info
	 * @param  prpShpNm
 	 */
    public void setPrpShpNm(String prpShpNm) {
        this.prpShpNm = prpShpNm;
    }

    /**
	 * Column Info
	 * @param  imdgTecNm
 	 */
    public void setImdgTecNm(String imdgTecNm) {
        this.imdgTecNm = imdgTecNm;
    }

    /**
	 * Column Info
	 * @param  imdgClssCdCtnt
 	 */
    public void setImdgClssCdCtnt(String imdgClssCdCtnt) {
        this.imdgClssCdCtnt = imdgClssCdCtnt;
    }

    /**
	 * Column Info
	 * @param  imdgPprNo
 	 */
    public void setImdgPprNo(String imdgPprNo) {
        this.imdgPprNo = imdgPprNo;
    }

    /**
	 * Column Info
	 * @param  imdgUnNoCtnt
 	 */
    public void setImdgUnNoCtnt(String imdgUnNoCtnt) {
        this.imdgUnNoCtnt = imdgUnNoCtnt;
    }

    /**
	 * Column Info
	 * @param  imdgUnNoSeq
 	 */
    public void setImdgUnNoSeq(String imdgUnNoSeq) {
        this.imdgUnNoSeq = imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @param  cfrFlg
 	 */
    public void setCfrFlg(String cfrFlg) {
        this.cfrFlg = cfrFlg;
    }

    /**
	 * Column Info
	 * @param  cfrNo
 	 */
    public void setCfrNo(String cfrNo) {
        this.cfrNo = cfrNo;
    }

    /**
	 * Column Info
	 * @param  flshPntUtCdCtnt
 	 */
    public void setFlshPntUtCdCtnt(String flshPntUtCdCtnt) {
        this.flshPntUtCdCtnt = flshPntUtCdCtnt;
    }

    /**
	 * Column Info
	 * @param  flshPntTempCtnt
 	 */
    public void setFlshPntTempCtnt(String flshPntTempCtnt) {
        this.flshPntTempCtnt = flshPntTempCtnt;
    }

    /**
	 * Column Info
	 * @param  imdgPckGrpCdCtnt
 	 */
    public void setImdgPckGrpCdCtnt(String imdgPckGrpCdCtnt) {
        this.imdgPckGrpCdCtnt = imdgPckGrpCdCtnt;
    }

    /**
	 * Column Info
	 * @param  emsNo
 	 */
    public void setEmsNo(String emsNo) {
        this.emsNo = emsNo;
    }

    /**
	 * Column Info
	 * @param  mfagNo
 	 */
    public void setMfagNo(String mfagNo) {
        this.mfagNo = mfagNo;
    }

    /**
	 * Column Info
	 * @param  espNo
 	 */
    public void setEspNo(String espNo) {
        this.espNo = espNo;
    }

    /**
	 * Column Info
	 * @param  imdgMrnPolutFlg
 	 */
    public void setImdgMrnPolutFlg(String imdgMrnPolutFlg) {
        this.imdgMrnPolutFlg = imdgMrnPolutFlg;
    }

    /**
	 * Column Info
	 * @param  imdgMrnPolutCdCtnt
 	 */
    public void setImdgMrnPolutCdCtnt(String imdgMrnPolutCdCtnt) {
        this.imdgMrnPolutCdCtnt = imdgMrnPolutCdCtnt;
    }

    /**
	 * Column Info
	 * @param  imdgLmtQtyFlgCtnt
 	 */
    public void setImdgLmtQtyFlgCtnt(String imdgLmtQtyFlgCtnt) {
        this.imdgLmtQtyFlgCtnt = imdgLmtQtyFlgCtnt;
    }

    /**
	 * Column Info
	 * @param  imdgExptQtyFlgCtnt
 	 */
    public void setImdgExptQtyFlgCtnt(String imdgExptQtyFlgCtnt) {
        this.imdgExptQtyFlgCtnt = imdgExptQtyFlgCtnt;
    }

    /**
	 * Column Info
	 * @param  grsWgtUtCdCtnt
 	 */
    public void setGrsWgtUtCdCtnt(String grsWgtUtCdCtnt) {
        this.grsWgtUtCdCtnt = grsWgtUtCdCtnt;
    }

    /**
	 * Column Info
	 * @param  grsWgtCtnt
 	 */
    public void setGrsWgtCtnt(String grsWgtCtnt) {
        this.grsWgtCtnt = grsWgtCtnt;
    }

    /**
	 * Column Info
	 * @param  netWgtUtCdCtnt
 	 */
    public void setNetWgtUtCdCtnt(String netWgtUtCdCtnt) {
        this.netWgtUtCdCtnt = netWgtUtCdCtnt;
    }

    /**
	 * Column Info
	 * @param  netWgtCtnt
 	 */
    public void setNetWgtCtnt(String netWgtCtnt) {
        this.netWgtCtnt = netWgtCtnt;
    }

    /**
	 * Column Info
	 * @param  pckTpCdCtnt
 	 */
    public void setPckTpCdCtnt(String pckTpCdCtnt) {
        this.pckTpCdCtnt = pckTpCdCtnt;
    }

    /**
	 * Column Info
	 * @param  pckQtyCtnt
 	 */
    public void setPckQtyCtnt(String pckQtyCtnt) {
        this.pckQtyCtnt = pckQtyCtnt;
    }

    /**
	 * Column Info
	 * @param  diffRmk
 	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param  emerCntcPhnNo
 	 */
    public void setEmerCntcPhnNo(String emerCntcPhnNo) {
        this.emerCntcPhnNo = emerCntcPhnNo;
    }

    /**
	 * Column Info
	 * @param  emerCntcPsonNm
 	 */
    public void setEmerCntcPsonNm(String emerCntcPsonNm) {
        this.emerCntcPsonNm = emerCntcPsonNm;
    }

    /**
	 * Column Info
	 * @param  psaNo
 	 */
    public void setPsaNo(String psaNo) {
        this.psaNo = psaNo;
    }

    /**
	 * Column Info
	 * @param  spclStwgRqstDesc
 	 */
    public void setSpclStwgRqstDesc(String spclStwgRqstDesc) {
        this.spclStwgRqstDesc = spclStwgRqstDesc;
    }

    /**
	 * Column Info
	 * @param  rsdFlgCtnt
 	 */
    public void setRsdFlgCtnt(String rsdFlgCtnt) {
        this.rsdFlgCtnt = rsdFlgCtnt;
    }

    /**
	 * Column Info
	 * @param  cntrSeq
 	 */
    public void setCntrSeq(String cntrSeq) {
        this.cntrSeq = cntrSeq;
    }

    /**
	 * Column Info
	 * @param  netExploWgtUtCdCtnt
 	 */
    public void setNetExploWgtUtCdCtnt(String netExploWgtUtCdCtnt) {
        this.netExploWgtUtCdCtnt = netExploWgtUtCdCtnt;
    }

    /**
	 * Column Info
	 * @param  netExploWgtCtnt
 	 */
    public void setNetExploWgtCtnt(String netExploWgtCtnt) {
        this.netExploWgtCtnt = netExploWgtCtnt;
    }

    /**
	 * Column Info
	 * @param  crrCd
 	 */
    public void setCrrCd(String crrCd) {
        this.crrCd = crrCd;
    }

    /**
	 * Column Info
	 * @param  spclCgoRqstSeq
 	 */
    public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @param  cntrDmyRefNo
 	 */
    public void setCntrDmyRefNo(String cntrDmyRefNo) {
        this.cntrDmyRefNo = cntrDmyRefNo;
    }

    /**
	 * Column Info
	 * @param  creUsrId
 	 */
    public void setCreUsrId(String creUsrId) {
        this.creUsrId = creUsrId;
    }

    /**
	 * Column Info
	 * @param  creDt
 	 */
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }

    /**
	 * Column Info
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
    }

    /**
	 * Column Info
	 * @param  updDt
 	 */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public void setDcgoSeq(String dcgoSeq) {
        this.dcgoSeq = dcgoSeq;
    }

    public String getDcgoSeq() {
        return this.dcgoSeq;
    }

    public void setImdgAmdtNo(String imdgAmdtNo) {
        this.imdgAmdtNo = imdgAmdtNo;
    }

    public String getImdgAmdtNo() {
        return this.imdgAmdtNo;
    }

    public void setImdgCompGrpCd(String imdgCompGrpCd) {
        this.imdgCompGrpCd = imdgCompGrpCd;
    }

    public String getImdgCompGrpCd() {
        return this.imdgCompGrpCd;
    }

    public void setN1stImdgSubsRskLblCd(String n1stImdgSubsRskLblCd) {
        this.n1stImdgSubsRskLblCd = n1stImdgSubsRskLblCd;
    }

    public String getN1stImdgSubsRskLblCd() {
        return this.n1stImdgSubsRskLblCd;
    }

    public void setN2ndImdgSubsRskLblCd(String n2ndImdgSubsRskLblCd) {
        this.n2ndImdgSubsRskLblCd = n2ndImdgSubsRskLblCd;
    }

    public String getN2ndImdgSubsRskLblCd() {
        return this.n2ndImdgSubsRskLblCd;
    }

    public void setN3rdImdgSubsRskLblCd(String n3rdImdgSubsRskLblCd) {
        this.n3rdImdgSubsRskLblCd = n3rdImdgSubsRskLblCd;
    }

    public String getN3rdImdgSubsRskLblCd() {
        return this.n3rdImdgSubsRskLblCd;
    }

    public void setN4thImdgSubsRskLblCd(String n4thImdgSubsRskLblCd) {
        this.n4thImdgSubsRskLblCd = n4thImdgSubsRskLblCd;
    }

    public String getN4thImdgSubsRskLblCd() {
        return this.n4thImdgSubsRskLblCd;
    }

    public void setEdiItmSeq(String ediItmSeq) {
        this.ediItmSeq = ediItmSeq;
    }

    public String getEdiItmSeq() {
        return this.ediItmSeq;
    }

    public void setN5thImdgSubsRskLblCd(String n5thImdgSubsRskLblCd) {
        this.n5thImdgSubsRskLblCd = n5thImdgSubsRskLblCd;
    }

    public String getN5thImdgSubsRskLblCd() {
        return this.n5thImdgSubsRskLblCd;
    }

    public void setN6thImdgSubsRskLblCd(String n6thImdgSubsRskLblCd) {
        this.n6thImdgSubsRskLblCd = n6thImdgSubsRskLblCd;
    }

    public String getN6thImdgSubsRskLblCd() {
        return this.n6thImdgSubsRskLblCd;
    }

    public void setN7thImdgSubsRskLblCd(String n7thImdgSubsRskLblCd) {
        this.n7thImdgSubsRskLblCd = n7thImdgSubsRskLblCd;
    }

    public String getN7thImdgSubsRskLblCd() {
        return this.n7thImdgSubsRskLblCd;
    }

    public void setN8thImdgSubsRskLblCd(String n8thImdgSubsRskLblCd) {
        this.n8thImdgSubsRskLblCd = n8thImdgSubsRskLblCd;
    }

    public String getN8thImdgSubsRskLblCd() {
        return this.n8thImdgSubsRskLblCd;
    }

    public void setEdiCgoUnmapDtlCd(String ediCgoUnmapDtlCd) {
        this.ediCgoUnmapDtlCd = ediCgoUnmapDtlCd;
    }

    public String getEdiCgoUnmapDtlCd() {
        return this.ediCgoUnmapDtlCd;
    }

    public void setDcgoDtlStsCdCtnt(String dcgoDtlStsCdCtnt) {
        this.dcgoDtlStsCdCtnt = dcgoDtlStsCdCtnt;
    }

    public String getDcgoDtlStsCdCtnt() {
        return this.dcgoDtlStsCdCtnt;
    }

    public void setImdgAddSegrGrpNoCtnt(String imdgAddSegrGrpNoCtnt) {
        this.imdgAddSegrGrpNoCtnt = imdgAddSegrGrpNoCtnt;
    }

    public String getImdgAddSegrGrpNoCtnt() {
        return this.imdgAddSegrGrpNoCtnt;
    }

    public void setImdgSegrGrpNoCtnt(String imdgSegrGrpNoCtnt) {
        this.imdgSegrGrpNoCtnt = imdgSegrGrpNoCtnt;
    }

    public String getImdgSegrGrpNoCtnt() {
        return this.imdgSegrGrpNoCtnt;
    }

    public void setCtrlTempCtnt(String ctrlTempCtnt) {
        this.ctrlTempCtnt = ctrlTempCtnt;
    }

    public String getCtrlTempCtnt() {
        return this.ctrlTempCtnt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setTrsmBndCd(JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", ""));
        setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
        setPrnrSpclCgoSubSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_sub_seq", ""));
        setCntrRefNo(JSPUtil.getParameter(request, prefix + "cntr_ref_no", ""));
        setCntrTpszCdCtnt(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd_ctnt", ""));
        setIsoCntrTpszCd(JSPUtil.getParameter(request, prefix + "iso_cntr_tpsz_cd", ""));
        setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
        setDcgoStsCdCtnt(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd_ctnt", ""));
        setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
        setMvmtSpclTpCd(JSPUtil.getParameter(request, prefix + "mvmt_spcl_tp_cd", ""));
        setOutN1stImdgPckCdCtnt(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_cd_ctnt", ""));
        setOutN1stImdgPckQtyCtnt(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_qty_ctnt", ""));
        setOutN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_desc", ""));
        setIntmdN1stImdgPckCdCtnt(JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_cd_ctnt", ""));
        setIntmdN1stImdgPckQtyCtnt(JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_qty_ctnt", ""));
        setIntmdN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_desc", ""));
        setInN1stImdgPckCdCtnt(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_cd_ctnt", ""));
        setInN1stImdgPckQtyCtnt(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_qty_ctnt", ""));
        setInN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_desc", ""));
        setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setImdgTecNm(JSPUtil.getParameter(request, prefix + "imdg_tec_nm", ""));
        setImdgClssCdCtnt(JSPUtil.getParameter(request, prefix + "imdg_clss_cd_ctnt", ""));
        setImdgPprNo(JSPUtil.getParameter(request, prefix + "imdg_ppr_no", ""));
        setImdgUnNoCtnt(JSPUtil.getParameter(request, prefix + "imdg_un_no_ctnt", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setCfrFlg(JSPUtil.getParameter(request, prefix + "cfr_flg", ""));
        setCfrNo(JSPUtil.getParameter(request, prefix + "cfr_no", ""));
        setFlshPntUtCdCtnt(JSPUtil.getParameter(request, prefix + "flsh_pnt_ut_cd_ctnt", ""));
        setFlshPntTempCtnt(JSPUtil.getParameter(request, prefix + "flsh_pnt_temp_ctnt", ""));
        setImdgPckGrpCdCtnt(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd_ctnt", ""));
        setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
        setMfagNo(JSPUtil.getParameter(request, prefix + "mfag_no", ""));
        setEspNo(JSPUtil.getParameter(request, prefix + "esp_no", ""));
        setImdgMrnPolutFlg(JSPUtil.getParameter(request, prefix + "imdg_mrn_polut_flg", ""));
        setImdgMrnPolutCdCtnt(JSPUtil.getParameter(request, prefix + "imdg_mrn_polut_cd_ctnt", ""));
        setImdgLmtQtyFlgCtnt(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg_ctnt", ""));
        setImdgExptQtyFlgCtnt(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg_ctnt", ""));
        setGrsWgtUtCdCtnt(JSPUtil.getParameter(request, prefix + "grs_wgt_ut_cd_ctnt", ""));
        setGrsWgtCtnt(JSPUtil.getParameter(request, prefix + "grs_wgt_ctnt", ""));
        setNetWgtUtCdCtnt(JSPUtil.getParameter(request, prefix + "net_wgt_ut_cd_ctnt", ""));
        setNetWgtCtnt(JSPUtil.getParameter(request, prefix + "net_wgt_ctnt", ""));
        setPckTpCdCtnt(JSPUtil.getParameter(request, prefix + "pck_tp_cd_ctnt", ""));
        setPckQtyCtnt(JSPUtil.getParameter(request, prefix + "pck_qty_ctnt", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setEmerCntcPhnNo(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", ""));
        setEmerCntcPsonNm(JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", ""));
        setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
        setSpclStwgRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", ""));
        setRsdFlgCtnt(JSPUtil.getParameter(request, prefix + "rsd_flg_ctnt", ""));
        setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
        setNetExploWgtUtCdCtnt(JSPUtil.getParameter(request, prefix + "net_explo_wgt_ut_cd_ctnt", ""));
        setNetExploWgtCtnt(JSPUtil.getParameter(request, prefix + "net_explo_wgt_ctnt", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setCntrDmyRefNo(JSPUtil.getParameter(request, prefix + "cntr_dmy_ref_no", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
        setImdgAmdtNo(JSPUtil.getParameter(request, prefix + "imdg_amdt_no", ""));
        setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
        setN1stImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_subs_rsk_lbl_cd", ""));
        setN2ndImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_subs_rsk_lbl_cd", ""));
        setN3rdImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_subs_rsk_lbl_cd", ""));
        setN4thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_subs_rsk_lbl_cd", ""));
        setEdiItmSeq(JSPUtil.getParameter(request, prefix + "edi_itm_seq", ""));
        setN5thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n5th_imdg_subs_rsk_lbl_cd", ""));
        setN6thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n6th_imdg_subs_rsk_lbl_cd", ""));
        setN7thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n7th_imdg_subs_rsk_lbl_cd", ""));
        setN8thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n8th_imdg_subs_rsk_lbl_cd", ""));
        setEdiCgoUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_cgo_unmap_dtl_cd", ""));
        setDcgoDtlStsCdCtnt(JSPUtil.getParameter(request, prefix + "dcgo_dtl_sts_cd_ctnt", ""));
        setImdgAddSegrGrpNoCtnt(JSPUtil.getParameter(request, prefix + "imdg_add_segr_grp_no_ctnt", ""));
        setImdgSegrGrpNoCtnt(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no_ctnt", ""));
        setCtrlTempCtnt(JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrSpclCgoDtlLogVO[]
	 */
    public ScgPrnrSpclCgoDtlLogVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrSpclCgoDtlLogVO[]
	 */
    public ScgPrnrSpclCgoDtlLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgPrnrSpclCgoDtlLogVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] trsmBndCd = (JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", length));
            String[] trsmDt = (JSPUtil.getParameter(request, prefix + "trsm_dt", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", length));
            String[] prnrSpclCgoSubSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_sub_seq", length));
            String[] cntrRefNo = (JSPUtil.getParameter(request, prefix + "cntr_ref_no", length));
            String[] cntrTpszCdCtnt = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd_ctnt", length));
            String[] isoCntrTpszCd = (JSPUtil.getParameter(request, prefix + "iso_cntr_tpsz_cd", length));
            String[] cgoSeq = (JSPUtil.getParameter(request, prefix + "cgo_seq", length));
            String[] dcgoStsCdCtnt = (JSPUtil.getParameter(request, prefix + "dcgo_sts_cd_ctnt", length));
            String[] refNo = (JSPUtil.getParameter(request, prefix + "ref_no", length));
            String[] mvmtSpclTpCd = (JSPUtil.getParameter(request, prefix + "mvmt_spcl_tp_cd", length));
            String[] outN1stImdgPckCdCtnt = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_cd_ctnt", length));
            String[] outN1stImdgPckQtyCtnt = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_qty_ctnt", length));
            String[] outN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_desc", length));
            String[] intmdN1stImdgPckCdCtnt = (JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_cd_ctnt", length));
            String[] intmdN1stImdgPckQtyCtnt = (JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_qty_ctnt", length));
            String[] intmdN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_desc", length));
            String[] inN1stImdgPckCdCtnt = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_cd_ctnt", length));
            String[] inN1stImdgPckQtyCtnt = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_qty_ctnt", length));
            String[] inN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_desc", length));
            String[] hzdDesc = (JSPUtil.getParameter(request, prefix + "hzd_desc", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] imdgTecNm = (JSPUtil.getParameter(request, prefix + "imdg_tec_nm", length));
            String[] imdgClssCdCtnt = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd_ctnt", length));
            String[] imdgPprNo = (JSPUtil.getParameter(request, prefix + "imdg_ppr_no", length));
            String[] imdgUnNoCtnt = (JSPUtil.getParameter(request, prefix + "imdg_un_no_ctnt", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] cfrFlg = (JSPUtil.getParameter(request, prefix + "cfr_flg", length));
            String[] cfrNo = (JSPUtil.getParameter(request, prefix + "cfr_no", length));
            String[] flshPntUtCdCtnt = (JSPUtil.getParameter(request, prefix + "flsh_pnt_ut_cd_ctnt", length));
            String[] flshPntTempCtnt = (JSPUtil.getParameter(request, prefix + "flsh_pnt_temp_ctnt", length));
            String[] imdgPckGrpCdCtnt = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd_ctnt", length));
            String[] emsNo = (JSPUtil.getParameter(request, prefix + "ems_no", length));
            String[] mfagNo = (JSPUtil.getParameter(request, prefix + "mfag_no", length));
            String[] espNo = (JSPUtil.getParameter(request, prefix + "esp_no", length));
            String[] imdgMrnPolutFlg = (JSPUtil.getParameter(request, prefix + "imdg_mrn_polut_flg", length));
            String[] imdgMrnPolutCdCtnt = (JSPUtil.getParameter(request, prefix + "imdg_mrn_polut_cd_ctnt", length));
            String[] imdgLmtQtyFlgCtnt = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg_ctnt", length));
            String[] imdgExptQtyFlgCtnt = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg_ctnt", length));
            String[] grsWgtUtCdCtnt = (JSPUtil.getParameter(request, prefix + "grs_wgt_ut_cd_ctnt", length));
            String[] grsWgtCtnt = (JSPUtil.getParameter(request, prefix + "grs_wgt_ctnt", length));
            String[] netWgtUtCdCtnt = (JSPUtil.getParameter(request, prefix + "net_wgt_ut_cd_ctnt", length));
            String[] netWgtCtnt = (JSPUtil.getParameter(request, prefix + "net_wgt_ctnt", length));
            String[] pckTpCdCtnt = (JSPUtil.getParameter(request, prefix + "pck_tp_cd_ctnt", length));
            String[] pckQtyCtnt = (JSPUtil.getParameter(request, prefix + "pck_qty_ctnt", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] emerCntcPhnNo = (JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", length));
            String[] emerCntcPsonNm = (JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", length));
            String[] psaNo = (JSPUtil.getParameter(request, prefix + "psa_no", length));
            String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", length));
            String[] rsdFlgCtnt = (JSPUtil.getParameter(request, prefix + "rsd_flg_ctnt", length));
            String[] cntrSeq = (JSPUtil.getParameter(request, prefix + "cntr_seq", length));
            String[] netExploWgtUtCdCtnt = (JSPUtil.getParameter(request, prefix + "net_explo_wgt_ut_cd_ctnt", length));
            String[] netExploWgtCtnt = (JSPUtil.getParameter(request, prefix + "net_explo_wgt_ctnt", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] cntrDmyRefNo = (JSPUtil.getParameter(request, prefix + "cntr_dmy_ref_no", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] dcgoSeq = (JSPUtil.getParameter(request, prefix + "dcgo_seq", length));
            String[] imdgAmdtNo = (JSPUtil.getParameter(request, prefix + "imdg_amdt_no", length));
            String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", length));
            String[] n1stImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n1st_imdg_subs_rsk_lbl_cd", length));
            String[] n2ndImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n2nd_imdg_subs_rsk_lbl_cd", length));
            String[] n3rdImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n3rd_imdg_subs_rsk_lbl_cd", length));
            String[] n4thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n4th_imdg_subs_rsk_lbl_cd", length));
            String[] ediItmSeq = (JSPUtil.getParameter(request, prefix + "edi_itm_seq", length));
            String[] n5thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n5th_imdg_subs_rsk_lbl_cd", length));
            String[] n6thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n6th_imdg_subs_rsk_lbl_cd", length));
            String[] n7thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n7th_imdg_subs_rsk_lbl_cd", length));
            String[] n8thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n8th_imdg_subs_rsk_lbl_cd", length));
            String[] ediCgoUnmapDtlCd = (JSPUtil.getParameter(request, prefix + "edi_cgo_unmap_dtl_cd", length));
            String[] dcgoDtlStsCdCtnt = (JSPUtil.getParameter(request, prefix + "dcgo_dtl_sts_cd_ctnt", length));
            String[] imdgAddSegrGrpNoCtnt = (JSPUtil.getParameter(request, prefix + "imdg_add_segr_grp_no_ctnt", length));
            String[] imdgSegrGrpNoCtnt = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no_ctnt", length));
            String[] ctrlTempCtnt = (JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgPrnrSpclCgoDtlLogVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (trsmBndCd[i] != null)
                    model.setTrsmBndCd(trsmBndCd[i]);
                if (trsmDt[i] != null)
                    model.setTrsmDt(trsmDt[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (prnrSpclCgoSeq[i] != null)
                    model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
                if (prnrSpclCgoSubSeq[i] != null)
                    model.setPrnrSpclCgoSubSeq(prnrSpclCgoSubSeq[i]);
                if (cntrRefNo[i] != null)
                    model.setCntrRefNo(cntrRefNo[i]);
                if (cntrTpszCdCtnt[i] != null)
                    model.setCntrTpszCdCtnt(cntrTpszCdCtnt[i]);
                if (isoCntrTpszCd[i] != null)
                    model.setIsoCntrTpszCd(isoCntrTpszCd[i]);
                if (cgoSeq[i] != null)
                    model.setCgoSeq(cgoSeq[i]);
                if (dcgoStsCdCtnt[i] != null)
                    model.setDcgoStsCdCtnt(dcgoStsCdCtnt[i]);
                if (refNo[i] != null)
                    model.setRefNo(refNo[i]);
                if (mvmtSpclTpCd[i] != null)
                    model.setMvmtSpclTpCd(mvmtSpclTpCd[i]);
                if (outN1stImdgPckCdCtnt[i] != null)
                    model.setOutN1stImdgPckCdCtnt(outN1stImdgPckCdCtnt[i]);
                if (outN1stImdgPckQtyCtnt[i] != null)
                    model.setOutN1stImdgPckQtyCtnt(outN1stImdgPckQtyCtnt[i]);
                if (outN1stImdgPckDesc[i] != null)
                    model.setOutN1stImdgPckDesc(outN1stImdgPckDesc[i]);
                if (intmdN1stImdgPckCdCtnt[i] != null)
                    model.setIntmdN1stImdgPckCdCtnt(intmdN1stImdgPckCdCtnt[i]);
                if (intmdN1stImdgPckQtyCtnt[i] != null)
                    model.setIntmdN1stImdgPckQtyCtnt(intmdN1stImdgPckQtyCtnt[i]);
                if (intmdN1stImdgPckDesc[i] != null)
                    model.setIntmdN1stImdgPckDesc(intmdN1stImdgPckDesc[i]);
                if (inN1stImdgPckCdCtnt[i] != null)
                    model.setInN1stImdgPckCdCtnt(inN1stImdgPckCdCtnt[i]);
                if (inN1stImdgPckQtyCtnt[i] != null)
                    model.setInN1stImdgPckQtyCtnt(inN1stImdgPckQtyCtnt[i]);
                if (inN1stImdgPckDesc[i] != null)
                    model.setInN1stImdgPckDesc(inN1stImdgPckDesc[i]);
                if (hzdDesc[i] != null)
                    model.setHzdDesc(hzdDesc[i]);
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (imdgTecNm[i] != null)
                    model.setImdgTecNm(imdgTecNm[i]);
                if (imdgClssCdCtnt[i] != null)
                    model.setImdgClssCdCtnt(imdgClssCdCtnt[i]);
                if (imdgPprNo[i] != null)
                    model.setImdgPprNo(imdgPprNo[i]);
                if (imdgUnNoCtnt[i] != null)
                    model.setImdgUnNoCtnt(imdgUnNoCtnt[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (cfrFlg[i] != null)
                    model.setCfrFlg(cfrFlg[i]);
                if (cfrNo[i] != null)
                    model.setCfrNo(cfrNo[i]);
                if (flshPntUtCdCtnt[i] != null)
                    model.setFlshPntUtCdCtnt(flshPntUtCdCtnt[i]);
                if (flshPntTempCtnt[i] != null)
                    model.setFlshPntTempCtnt(flshPntTempCtnt[i]);
                if (imdgPckGrpCdCtnt[i] != null)
                    model.setImdgPckGrpCdCtnt(imdgPckGrpCdCtnt[i]);
                if (emsNo[i] != null)
                    model.setEmsNo(emsNo[i]);
                if (mfagNo[i] != null)
                    model.setMfagNo(mfagNo[i]);
                if (espNo[i] != null)
                    model.setEspNo(espNo[i]);
                if (imdgMrnPolutFlg[i] != null)
                    model.setImdgMrnPolutFlg(imdgMrnPolutFlg[i]);
                if (imdgMrnPolutCdCtnt[i] != null)
                    model.setImdgMrnPolutCdCtnt(imdgMrnPolutCdCtnt[i]);
                if (imdgLmtQtyFlgCtnt[i] != null)
                    model.setImdgLmtQtyFlgCtnt(imdgLmtQtyFlgCtnt[i]);
                if (imdgExptQtyFlgCtnt[i] != null)
                    model.setImdgExptQtyFlgCtnt(imdgExptQtyFlgCtnt[i]);
                if (grsWgtUtCdCtnt[i] != null)
                    model.setGrsWgtUtCdCtnt(grsWgtUtCdCtnt[i]);
                if (grsWgtCtnt[i] != null)
                    model.setGrsWgtCtnt(grsWgtCtnt[i]);
                if (netWgtUtCdCtnt[i] != null)
                    model.setNetWgtUtCdCtnt(netWgtUtCdCtnt[i]);
                if (netWgtCtnt[i] != null)
                    model.setNetWgtCtnt(netWgtCtnt[i]);
                if (pckTpCdCtnt[i] != null)
                    model.setPckTpCdCtnt(pckTpCdCtnt[i]);
                if (pckQtyCtnt[i] != null)
                    model.setPckQtyCtnt(pckQtyCtnt[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (emerCntcPhnNo[i] != null)
                    model.setEmerCntcPhnNo(emerCntcPhnNo[i]);
                if (emerCntcPsonNm[i] != null)
                    model.setEmerCntcPsonNm(emerCntcPsonNm[i]);
                if (psaNo[i] != null)
                    model.setPsaNo(psaNo[i]);
                if (spclStwgRqstDesc[i] != null)
                    model.setSpclStwgRqstDesc(spclStwgRqstDesc[i]);
                if (rsdFlgCtnt[i] != null)
                    model.setRsdFlgCtnt(rsdFlgCtnt[i]);
                if (cntrSeq[i] != null)
                    model.setCntrSeq(cntrSeq[i]);
                if (netExploWgtUtCdCtnt[i] != null)
                    model.setNetExploWgtUtCdCtnt(netExploWgtUtCdCtnt[i]);
                if (netExploWgtCtnt[i] != null)
                    model.setNetExploWgtCtnt(netExploWgtCtnt[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (cntrDmyRefNo[i] != null)
                    model.setCntrDmyRefNo(cntrDmyRefNo[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (imdgAmdtNo[i] != null)
                    model.setImdgAmdtNo(imdgAmdtNo[i]);
                if (imdgCompGrpCd[i] != null)
                    model.setImdgCompGrpCd(imdgCompGrpCd[i]);
                if (n1stImdgSubsRskLblCd[i] != null)
                    model.setN1stImdgSubsRskLblCd(n1stImdgSubsRskLblCd[i]);
                if (n2ndImdgSubsRskLblCd[i] != null)
                    model.setN2ndImdgSubsRskLblCd(n2ndImdgSubsRskLblCd[i]);
                if (n3rdImdgSubsRskLblCd[i] != null)
                    model.setN3rdImdgSubsRskLblCd(n3rdImdgSubsRskLblCd[i]);
                if (n4thImdgSubsRskLblCd[i] != null)
                    model.setN4thImdgSubsRskLblCd(n4thImdgSubsRskLblCd[i]);
                if (ediItmSeq[i] != null)
                    model.setEdiItmSeq(ediItmSeq[i]);
                if (n5thImdgSubsRskLblCd[i] != null)
                    model.setN5thImdgSubsRskLblCd(n5thImdgSubsRskLblCd[i]);
                if (n6thImdgSubsRskLblCd[i] != null)
                    model.setN6thImdgSubsRskLblCd(n6thImdgSubsRskLblCd[i]);
                if (n7thImdgSubsRskLblCd[i] != null)
                    model.setN7thImdgSubsRskLblCd(n7thImdgSubsRskLblCd[i]);
                if (n8thImdgSubsRskLblCd[i] != null)
                    model.setN8thImdgSubsRskLblCd(n8thImdgSubsRskLblCd[i]);
                if (ediCgoUnmapDtlCd[i] != null)
                    model.setEdiCgoUnmapDtlCd(ediCgoUnmapDtlCd[i]);
                if (dcgoDtlStsCdCtnt[i] != null)
                    model.setDcgoDtlStsCdCtnt(dcgoDtlStsCdCtnt[i]);
                if (imdgAddSegrGrpNoCtnt[i] != null)
                    model.setImdgAddSegrGrpNoCtnt(imdgAddSegrGrpNoCtnt[i]);
                if (imdgSegrGrpNoCtnt[i] != null)
                    model.setImdgSegrGrpNoCtnt(imdgSegrGrpNoCtnt[i]);
                if (ctrlTempCtnt[i] != null) 
		    		model.setCtrlTempCtnt(ctrlTempCtnt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgPrnrSpclCgoDtlLogVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ScgPrnrSpclCgoDtlLogVO[]
	 */
    public ScgPrnrSpclCgoDtlLogVO[] getScgPrnrSpclCgoDtlLogVOs() {
        ScgPrnrSpclCgoDtlLogVO[] vos = (ScgPrnrSpclCgoDtlLogVO[]) models.toArray(new ScgPrnrSpclCgoDtlLogVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
    public void unDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmBndCd = this.trsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmDt = this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSeq = this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSubSeq = this.prnrSpclCgoSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrRefNo = this.cntrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCdCtnt = this.cntrTpszCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isoCntrTpszCd = this.isoCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoSeq = this.cgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoStsCdCtnt = this.dcgoStsCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.refNo = this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mvmtSpclTpCd = this.mvmtSpclTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckCdCtnt = this.outN1stImdgPckCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckQtyCtnt = this.outN1stImdgPckQtyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckDesc = this.outN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN1stImdgPckCdCtnt = this.intmdN1stImdgPckCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN1stImdgPckQtyCtnt = this.intmdN1stImdgPckQtyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN1stImdgPckDesc = this.intmdN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckCdCtnt = this.inN1stImdgPckCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckQtyCtnt = this.inN1stImdgPckQtyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckDesc = this.inN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hzdDesc = this.hzdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgTecNm = this.imdgTecNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCdCtnt = this.imdgClssCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPprNo = this.imdgPprNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoCtnt = this.imdgUnNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfrFlg = this.cfrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfrNo = this.cfrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntUtCdCtnt = this.flshPntUtCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntTempCtnt = this.flshPntTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCdCtnt = this.imdgPckGrpCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emsNo = this.emsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mfagNo = this.mfagNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.espNo = this.espNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgMrnPolutFlg = this.imdgMrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgMrnPolutCdCtnt = this.imdgMrnPolutCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyFlgCtnt = this.imdgLmtQtyFlgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyFlgCtnt = this.imdgExptQtyFlgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgtUtCdCtnt = this.grsWgtUtCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgtCtnt = this.grsWgtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgtUtCdCtnt = this.netWgtUtCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgtCtnt = this.netWgtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCdCtnt = this.pckTpCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQtyCtnt = this.pckQtyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPhnNo = this.emerCntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPsonNm = this.emerCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psaNo = this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclStwgRqstDesc = this.spclStwgRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsdFlgCtnt = this.rsdFlgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSeq = this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExploWgtUtCdCtnt = this.netExploWgtUtCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExploWgtCtnt = this.netExploWgtCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrDmyRefNo = this.cntrDmyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoSeq = this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgAmdtNo = this.imdgAmdtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCompGrpCd = this.imdgCompGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stImdgSubsRskLblCd = this.n1stImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndImdgSubsRskLblCd = this.n2ndImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3rdImdgSubsRskLblCd = this.n3rdImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n4thImdgSubsRskLblCd = this.n4thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediItmSeq = this.ediItmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n5thImdgSubsRskLblCd = this.n5thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n6thImdgSubsRskLblCd = this.n6thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n7thImdgSubsRskLblCd = this.n7thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n8thImdgSubsRskLblCd = this.n8thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediCgoUnmapDtlCd = this.ediCgoUnmapDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoDtlStsCdCtnt = this.dcgoDtlStsCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgAddSegrGrpNoCtnt = this.imdgAddSegrGrpNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNoCtnt = this.imdgSegrGrpNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlTempCtnt = this.ctrlTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
