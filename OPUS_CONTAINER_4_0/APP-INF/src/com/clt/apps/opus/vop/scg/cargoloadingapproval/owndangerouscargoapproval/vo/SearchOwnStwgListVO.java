/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchOwnStwgListVO.java
*@FileTitle : SearchOwnStwgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SearchOwnStwgListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchOwnStwgListVO> models = new ArrayList<SearchOwnStwgListVO>();

    /* Column Info */
    private String spclCgoRqstSeq = null;

    /* Column Info */
    private String dcgoQty = null;

    /* Column Info */
    private String scgStwgCd = null;

    /* Column Info */
    private String no = null;

    /* Column Info */
    private String imdgUnNoSeq = null;

    /* Column Info */
    private String scgFlg = null;

    /* Column Info */
    private String dcgoSeq = null;

    /* Column Info */
    private String outImdgPckQty1 = null;

    /* Column Info */
    private String emlChk = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String polClptIndSeq = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String imdgUnNo = null;

    /* Column Info */
    private String hcdgFlg = null;

    /* Column Info */
    private String intmdImdgPckQty1 = null;

    /* Column Info */
    private String spclCgoAuthNo = null;

    /* Column Info */
    private String authOfcCd = null;

    /* Column Info */
    private String rsdFlg = null;

    /* Column Info */
    private String spclCgoCateCd = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String imdgSegrGrpNm = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String spclRqstDesc = null;

    /* Column Info */
    private String imdgSegrGrpNo = null;

    /* Column Info */
    private String mapgTrsmBndCd = null;

    /* Column Info */
    private String authUsrId = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String imdgClssCd = null;

    /* Column Info */
    private String mapgTrsmDt = null;

    /* Column Info */
    private String imdgPckGrpCd = null;

    /* Column Info */
    private String rqstDay = null;

    /* Column Info */
    private String flshPntCdoTemp = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String vslSeq = null;

    /* Column Info */
    private String mapgPrnrSpclCgoSeq = null;

    /* Column Info */
    private String spclCgoAproRqstSeq = null;

    /* Column Info */
    private String dgCntrSeq = null;

    /* Column Info */
    private String rqstDt = null;

    /* Column Info */
    private String imdgSubsRskLblCd = null;

    /* Column Info */
    private String emlSndNo = null;

    /* Column Info */
    private String mapgTrsmSpclCgoCateCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String diffRmk = null;

    /* Column Info */
    private String authGdt = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String inImdgPckQty1 = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String psaNo = null;

    /* Column Info */
    private String dcgoStsCd = null;

    /* Column Info */
    private String netWgtSum = null;

    /* Column Info */
    private String crrCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cfrFlg = null;

    /* Column Info */
    private String mrnPolutFlg = null;

    /* Column Info */
    private String rgnShpOprCd = null;

    /* Column Info */
    private String dgTp = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String netWgt = null;

    /* Column Info */
    private String authDt = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String podClptIndSeq = null;

    /* Column Info */
    private String spclCgoAuthRjctCd = null;

    /* Column Info */
    private String cntrCgoSeq = null;

    /* Column Info */
    private String rankSeq = null;

    private String rankCnt = null;

    /* Column Info */
    private String spclCgoAuthRmk = null;

    /* Column Info */
    private String spclCgoAuthSeq = null;

    /* Column Info */
    private String ediChk = null;

    /* Column Info */
    private String aproRefNo = null;

    /* Column Info */
    private String grsWgt = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String rqstUsrId = null;

    /* Column Info */
    private String bkgStwgCd = null;

    /* Column Info */
    private String bkgRcvTermCd = null;

    /* Column Info */
    private String vpsEtaDt = null;

    /* Column Info */
    private String rqstGdt = null;

    /* Column Info */
    private String lstRqstDatFlg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String vslPrePstCd = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String imdgExptQtyFlg = null;

    /* Column Info */
    private String rqstAuthCd = null;

    /* Column Info */
    private String spclCgoAuthCd = null;

    /* Column Info */
    private String bookingNo = null;

    /* Column Info */
    private String vslNm = null;

    /* Column Info */
    private String ediSndNo = null;

    /* Column Info */
    private String skdDirCd = null;

    /* Column Info */
    private String crrCode = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String rqstOfcCd = null;

    /* Column Info */
    private String prpShpNm = null;

    /* Column Info */
    private String mapgEdiTrsmStsCd = null;

    /* Column Info */
    private String bkgDeTermCd = null;

    /* Column Info */
    private String imdgLmtQtyFlg = null;

    private String stwgSeq = null;

    private String stwgFlg = null;

    private String vslPrePstNm = null;

    private String cmdtNm = null;

    private String awkCgoSeq = null;

    private String bbCgoSeq = null;

    private String rcSeq = null;

    private String opCntrQty = null;

    /* Column Info */
    private String updDt = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public SearchOwnStwgListVO() {
    }

    public SearchOwnStwgListVO(String ibflag, String pagerows, String no, String rankSeq, String bookingNo, String bkgStsCd, String dgCntrSeq, String cntrCgoSeq, String rqstDay, String spclCgoAuthCd, String spclCgoAuthRjctCd, String aproRefNo, String ediSndNo, String emlSndNo, String emlChk, String slanCd, String vslCd, String vslNm, String skdVoyNo, String skdDirCd, String prpShpNm, String diffRmk, String dcgoStsCd, String crrCd, String crrCode, String porCd, String polCd, String ediChk, String mapgTrsmBndCd, String mapgTrsmDt, String mapgTrsmSpclCgoCateCd, String mapgPrnrSpclCgoSeq, String mapgEdiTrsmStsCd, String vpsEtaDt, String podCd, String delCd, String cntrTpszCd, String dgTp, String imdgUnNo, String imdgSegrGrpNm, String imdgUnNoSeq, String imdgClssCd, String imdgSubsRskLblCd, String mrnPolutFlg, String imdgPckGrpCd, String imdgLmtQtyFlg, String imdgExptQtyFlg, String flshPntCdoTemp, String grsWgt, String netWgt, String psaNo, String hcdgFlg, String bkgNo, String spclCgoAproRqstSeq, String spclCgoRqstSeq, String vslPrePstCd, String vslSeq, String cntrNo, String dcgoQty, String lstRqstDatFlg, String bkgRcvTermCd, String bkgDeTermCd, String polClptIndSeq, String podClptIndSeq, String polYdCd, String podYdCd, String rgnShpOprCd, String spclCgoCateCd, String spclCgoAuthNo, String authOfcCd, String spclCgoAuthSeq, String netWgtSum, String scgFlg, String rqstAuthCd, String rqstOfcCd, String rqstDt, String rqstGdt, String rqstUsrId, String authDt, String authGdt, String authUsrId, String spclCgoAuthRmk, String spclRqstDesc, String inImdgPckQty1, String outImdgPckQty1, String intmdImdgPckQty1, String imdgSegrGrpNo, String rsdFlg, String cfrFlg, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String stwgCd, String bkgStwgCd, String scgStwgCd, String dcgoSeq, String awkCgoSeq, String bbCgoSeq, String rcSeq, String stwgSeq, String stwgFlg, String vslPrePstNm, String rankCnt, String cmdtNm, String opCntrQty, String updDt) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.dcgoQty = dcgoQty;
        this.scgStwgCd = scgStwgCd;
        this.no = no;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.scgFlg = scgFlg;
        this.dcgoSeq = dcgoSeq;
        this.awkCgoSeq = awkCgoSeq;
        this.bbCgoSeq = bbCgoSeq;
        this.rcSeq = rcSeq;
        this.stwgSeq = stwgSeq;
        this.stwgFlg = stwgFlg;
        this.vslPrePstNm = vslPrePstNm;
        this.outImdgPckQty1 = outImdgPckQty1;
        this.emlChk = emlChk;
        this.pagerows = pagerows;
        this.cntrTpszCd = cntrTpszCd;
        this.polClptIndSeq = polClptIndSeq;
        this.stwgCd = stwgCd;
        this.imdgUnNo = imdgUnNo;
        this.hcdgFlg = hcdgFlg;
        this.intmdImdgPckQty1 = intmdImdgPckQty1;
        this.spclCgoAuthNo = spclCgoAuthNo;
        this.authOfcCd = authOfcCd;
        this.rsdFlg = rsdFlg;
        this.spclCgoCateCd = spclCgoCateCd;
        this.skdVoyNo = skdVoyNo;
        this.podCd = podCd;
        this.imdgSegrGrpNm = imdgSegrGrpNm;
        this.bkgNo = bkgNo;
        this.spclRqstDesc = spclRqstDesc;
        this.imdgSegrGrpNo = imdgSegrGrpNo;
        this.mapgTrsmBndCd = mapgTrsmBndCd;
        this.authUsrId = authUsrId;
        this.rcFlg = rcFlg;
        this.imdgClssCd = imdgClssCd;
        this.mapgTrsmDt = mapgTrsmDt;
        this.imdgPckGrpCd = imdgPckGrpCd;
        this.rqstDay = rqstDay;
        this.flshPntCdoTemp = flshPntCdoTemp;
        this.bkgStsCd = bkgStsCd;
        this.vslSeq = vslSeq;
        this.mapgPrnrSpclCgoSeq = mapgPrnrSpclCgoSeq;
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
        this.dgCntrSeq = dgCntrSeq;
        this.rqstDt = rqstDt;
        this.imdgSubsRskLblCd = imdgSubsRskLblCd;
        this.emlSndNo = emlSndNo;
        this.mapgTrsmSpclCgoCateCd = mapgTrsmSpclCgoCateCd;
        this.slanCd = slanCd;
        this.diffRmk = diffRmk;
        this.authGdt = authGdt;
        this.cntrNo = cntrNo;
        this.inImdgPckQty1 = inImdgPckQty1;
        this.vslCd = vslCd;
        this.psaNo = psaNo;
        this.dcgoStsCd = dcgoStsCd;
        this.netWgtSum = netWgtSum;
        this.crrCd = crrCd;
        this.polCd = polCd;
        this.cfrFlg = cfrFlg;
        this.mrnPolutFlg = mrnPolutFlg;
        this.rgnShpOprCd = rgnShpOprCd;
        this.dgTp = dgTp;
        this.awkCgoFlg = awkCgoFlg;
        this.netWgt = netWgt;
        this.authDt = authDt;
        this.delCd = delCd;
        this.podClptIndSeq = podClptIndSeq;
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
        this.cntrCgoSeq = cntrCgoSeq;
        this.rankSeq = rankSeq;
        this.spclCgoAuthRmk = spclCgoAuthRmk;
        this.spclCgoAuthSeq = spclCgoAuthSeq;
        this.ediChk = ediChk;
        this.aproRefNo = aproRefNo;
        this.grsWgt = grsWgt;
        this.porCd = porCd;
        this.rqstUsrId = rqstUsrId;
        this.bkgStwgCd = bkgStwgCd;
        this.bkgRcvTermCd = bkgRcvTermCd;
        this.vpsEtaDt = vpsEtaDt;
        this.rqstGdt = rqstGdt;
        this.lstRqstDatFlg = lstRqstDatFlg;
        this.ibflag = ibflag;
        this.bbCgoFlg = bbCgoFlg;
        this.dcgoFlg = dcgoFlg;
        this.vslPrePstCd = vslPrePstCd;
        this.podYdCd = podYdCd;
        this.imdgExptQtyFlg = imdgExptQtyFlg;
        this.rqstAuthCd = rqstAuthCd;
        this.spclCgoAuthCd = spclCgoAuthCd;
        this.bookingNo = bookingNo;
        this.vslNm = vslNm;
        this.ediSndNo = ediSndNo;
        this.skdDirCd = skdDirCd;
        this.crrCode = crrCode;
        this.polYdCd = polYdCd;
        this.rqstOfcCd = rqstOfcCd;
        this.prpShpNm = prpShpNm;
        this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
        this.bkgDeTermCd = bkgDeTermCd;
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
        this.rankCnt = rankCnt;
        this.cmdtNm = cmdtNm;
        this.opCntrQty = opCntrQty;
        this.updDt = updDt;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("dcgo_qty", getDcgoQty());
        this.hashColumns.put("scg_stwg_cd", getScgStwgCd());
        this.hashColumns.put("no", getNo());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("scg_flg", getScgFlg());
        this.hashColumns.put("dcgo_seq", getDcgoSeq());
        this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
        this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
        this.hashColumns.put("rc_seq", getRcSeq());
        this.hashColumns.put("stwg_seq", getStwgSeq());
        this.hashColumns.put("stwg_flg", getStwgFlg());
        this.hashColumns.put("vsl_pre_pst_nm", getVslPrePstNm());
        this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
        this.hashColumns.put("eml_chk", getEmlChk());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("hcdg_flg", getHcdgFlg());
        this.hashColumns.put("intmd_imdg_pck_qty1", getIntmdImdgPckQty1());
        this.hashColumns.put("spcl_cgo_auth_no", getSpclCgoAuthNo());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("rsd_flg", getRsdFlg());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("imdg_segr_grp_nm", getImdgSegrGrpNm());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("spcl_rqst_desc", getSpclRqstDesc());
        this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
        this.hashColumns.put("mapg_trsm_bnd_cd", getMapgTrsmBndCd());
        this.hashColumns.put("auth_usr_id", getAuthUsrId());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("mapg_trsm_dt", getMapgTrsmDt());
        this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
        this.hashColumns.put("rqst_day", getRqstDay());
        this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("vsl_seq", getVslSeq());
        this.hashColumns.put("mapg_prnr_spcl_cgo_seq", getMapgPrnrSpclCgoSeq());
        this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
        this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
        this.hashColumns.put("eml_snd_no", getEmlSndNo());
        this.hashColumns.put("mapg_trsm_spcl_cgo_cate_cd", getMapgTrsmSpclCgoCateCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("auth_gdt", getAuthGdt());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("psa_no", getPsaNo());
        this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
        this.hashColumns.put("net_wgt_sum", getNetWgtSum());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cfr_flg", getCfrFlg());
        this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
        this.hashColumns.put("dg_tp", getDgTp());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("auth_dt", getAuthDt());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
        this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
        this.hashColumns.put("rank_seq", getRankSeq());
        this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
        this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
        this.hashColumns.put("edi_chk", getEdiChk());
        this.hashColumns.put("apro_ref_no", getAproRefNo());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("rqst_usr_id", getRqstUsrId());
        this.hashColumns.put("bkg_stwg_cd", getBkgStwgCd());
        this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("rqst_gdt", getRqstGdt());
        this.hashColumns.put("lst_rqst_dat_flg", getLstRqstDatFlg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
        this.hashColumns.put("rqst_auth_cd", getRqstAuthCd());
        this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
        this.hashColumns.put("booking_no", getBookingNo());
        this.hashColumns.put("vsl_nm", getVslNm());
        this.hashColumns.put("edi_snd_no", getEdiSndNo());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("crr_code", getCrrCode());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("mapg_edi_trsm_sts_cd", getMapgEdiTrsmStsCd());
        this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
        this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
        this.hashColumns.put("rank_cnt", getRankCnt());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("op_cntr_qty", getOpCntrQty());
        this.hashColumns.put("upd_dt", getUpdDt());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("dcgo_qty", "dcgoQty");
        this.hashFields.put("scg_stwg_cd", "scgStwgCd");
        this.hashFields.put("no", "no");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("scg_flg", "scgFlg");
        this.hashFields.put("dcgo_seq", "dcgoSeq");
        this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
        this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
        this.hashFields.put("rc_seq", "rcSeq");
        this.hashFields.put("stwg_seq", "stwgSeq");
        this.hashFields.put("stwg_flg", "stwgFlg");
        this.hashFields.put("vsl_pre_pst_nm", "vslPrePstNm");
        this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
        this.hashFields.put("eml_chk", "emlChk");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("hcdg_flg", "hcdgFlg");
        this.hashFields.put("intmd_imdg_pck_qty1", "intmdImdgPckQty1");
        this.hashFields.put("spcl_cgo_auth_no", "spclCgoAuthNo");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("rsd_flg", "rsdFlg");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("imdg_segr_grp_nm", "imdgSegrGrpNm");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("spcl_rqst_desc", "spclRqstDesc");
        this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
        this.hashFields.put("mapg_trsm_bnd_cd", "mapgTrsmBndCd");
        this.hashFields.put("auth_usr_id", "authUsrId");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("mapg_trsm_dt", "mapgTrsmDt");
        this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
        this.hashFields.put("rqst_day", "rqstDay");
        this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("vsl_seq", "vslSeq");
        this.hashFields.put("mapg_prnr_spcl_cgo_seq", "mapgPrnrSpclCgoSeq");
        this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
        this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
        this.hashFields.put("eml_snd_no", "emlSndNo");
        this.hashFields.put("mapg_trsm_spcl_cgo_cate_cd", "mapgTrsmSpclCgoCateCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("auth_gdt", "authGdt");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("psa_no", "psaNo");
        this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
        this.hashFields.put("net_wgt_sum", "netWgtSum");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cfr_flg", "cfrFlg");
        this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
        this.hashFields.put("dg_tp", "dgTp");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("auth_dt", "authDt");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
        this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
        this.hashFields.put("rank_seq", "rankSeq");
        this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
        this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
        this.hashFields.put("edi_chk", "ediChk");
        this.hashFields.put("apro_ref_no", "aproRefNo");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("rqst_usr_id", "rqstUsrId");
        this.hashFields.put("bkg_stwg_cd", "bkgStwgCd");
        this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("rqst_gdt", "rqstGdt");
        this.hashFields.put("lst_rqst_dat_flg", "lstRqstDatFlg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
        this.hashFields.put("rqst_auth_cd", "rqstAuthCd");
        this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
        this.hashFields.put("booking_no", "bookingNo");
        this.hashFields.put("vsl_nm", "vslNm");
        this.hashFields.put("edi_snd_no", "ediSndNo");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("crr_code", "crrCode");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("mapg_edi_trsm_sts_cd", "mapgEdiTrsmStsCd");
        this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
        this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
        this.hashFields.put("rank_cnt", "rankCnt");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("op_cntr_qty", "opCntrQty");
        this.hashFields.put("upd_dt", "updDt");
        return this.hashFields;
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
	 * @return dcgoQty
	 */
    public String getDcgoQty() {
        return this.dcgoQty;
    }

    /**
	 * Column Info
	 * @return scgStwgCd
	 */
    public String getScgStwgCd() {
        return this.scgStwgCd;
    }

    /**
	 * Column Info
	 * @return no
	 */
    public String getNo() {
        return this.no;
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
	 * @return scgFlg
	 */
    public String getScgFlg() {
        return this.scgFlg;
    }

    public String getStwgSeq() {
        return stwgSeq;
    }

    public void setStwgSeq(String stwgSeq) {
        this.stwgSeq = stwgSeq;
    }

    public String getStwgFlg() {
        return stwgFlg;
    }

    public void setStwgFlg(String stwgFlg) {
        this.stwgFlg = stwgFlg;
    }

    public String getVslPrePstNm() {
        return vslPrePstNm;
    }

    public void setVslPrePstNm(String vslPrePstNm) {
        this.vslPrePstNm = vslPrePstNm;
    }

    /**
	 * Column Info
	 * @return dcgoSeq
	 */
    public String getDcgoSeq() {
        return this.dcgoSeq;
    }

    public String getAwkCgoSeq() {
        return awkCgoSeq;
    }

    public void setAwkCgoSeq(String awkCgoSeq) {
        this.awkCgoSeq = awkCgoSeq;
    }

    public String getBbCgoSeq() {
        return bbCgoSeq;
    }

    public void setBbCgoSeq(String bbCgoSeq) {
        this.bbCgoSeq = bbCgoSeq;
    }

    public String getRcSeq() {
        return rcSeq;
    }

    public void setRcSeq(String rcSeq) {
        this.rcSeq = rcSeq;
    }

    /**
	 * Column Info
	 * @return outImdgPckQty1
	 */
    public String getOutImdgPckQty1() {
        return this.outImdgPckQty1;
    }

    /**
	 * Column Info
	 * @return emlChk
	 */
    public String getEmlChk() {
        return this.emlChk;
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
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

    /**
	 * Column Info
	 * @return polClptIndSeq
	 */
    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
    }

    /**
	 * Column Info
	 * @return stwgCd
	 */
    public String getStwgCd() {
        return this.stwgCd;
    }

    /**
	 * Column Info
	 * @return imdgUnNo
	 */
    public String getImdgUnNo() {
        return this.imdgUnNo;
    }

    /**
	 * Column Info
	 * @return hcdgFlg
	 */
    public String getHcdgFlg() {
        return this.hcdgFlg;
    }

    /**
	 * Column Info
	 * @return intmdImdgPckQty1
	 */
    public String getIntmdImdgPckQty1() {
        return this.intmdImdgPckQty1;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthNo
	 */
    public String getSpclCgoAuthNo() {
        return this.spclCgoAuthNo;
    }

    /**
	 * Column Info
	 * @return authOfcCd
	 */
    public String getAuthOfcCd() {
        return this.authOfcCd;
    }

    /**
	 * Column Info
	 * @return rsdFlg
	 */
    public String getRsdFlg() {
        return this.rsdFlg;
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
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
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
	 * @return imdgSegrGrpNm
	 */
    public String getImdgSegrGrpNm() {
        return this.imdgSegrGrpNm;
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
	 * @return spclRqstDesc
	 */
    public String getSpclRqstDesc() {
        return this.spclRqstDesc;
    }

    /**
	 * Column Info
	 * @return imdgSegrGrpNo
	 */
    public String getImdgSegrGrpNo() {
        return this.imdgSegrGrpNo;
    }

    /**
	 * Column Info
	 * @return mapgTrsmBndCd
	 */
    public String getMapgTrsmBndCd() {
        return this.mapgTrsmBndCd;
    }

    /**
	 * Column Info
	 * @return authUsrId
	 */
    public String getAuthUsrId() {
        return this.authUsrId;
    }

    /**
	 * Column Info
	 * @return rcFlg
	 */
    public String getRcFlg() {
        return this.rcFlg;
    }

    /**
	 * Column Info
	 * @return imdgClssCd
	 */
    public String getImdgClssCd() {
        return this.imdgClssCd;
    }

    /**
	 * Column Info
	 * @return mapgTrsmDt
	 */
    public String getMapgTrsmDt() {
        return this.mapgTrsmDt;
    }

    /**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
    public String getImdgPckGrpCd() {
        return this.imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @return rqstDay
	 */
    public String getRqstDay() {
        return this.rqstDay;
    }

    /**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
    public String getFlshPntCdoTemp() {
        return this.flshPntCdoTemp;
    }

    /**
	 * Column Info
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * @return vslSeq
	 */
    public String getVslSeq() {
        return this.vslSeq;
    }

    /**
	 * Column Info
	 * @return mapgPrnrSpclCgoSeq
	 */
    public String getMapgPrnrSpclCgoSeq() {
        return this.mapgPrnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
    public String getSpclCgoAproRqstSeq() {
        return this.spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @return dgCntrSeq
	 */
    public String getDgCntrSeq() {
        return this.dgCntrSeq;
    }

    /**
	 * Column Info
	 * @return rqstDt
	 */
    public String getRqstDt() {
        return this.rqstDt;
    }

    /**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
    public String getImdgSubsRskLblCd() {
        return this.imdgSubsRskLblCd;
    }

    /**
	 * Column Info
	 * @return emlSndNo
	 */
    public String getEmlSndNo() {
        return this.emlSndNo;
    }

    /**
	 * Column Info
	 * @return mapgTrsmSpclCgoCateCd
	 */
    public String getMapgTrsmSpclCgoCateCd() {
        return this.mapgTrsmSpclCgoCateCd;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
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
	 * @return authGdt
	 */
    public String getAuthGdt() {
        return this.authGdt;
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
	 * @return inImdgPckQty1
	 */
    public String getInImdgPckQty1() {
        return this.inImdgPckQty1;
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
	 * @return psaNo
	 */
    public String getPsaNo() {
        return this.psaNo;
    }

    /**
	 * Column Info
	 * @return dcgoStsCd
	 */
    public String getDcgoStsCd() {
        return this.dcgoStsCd;
    }

    /**
	 * Column Info
	 * @return netWgtSum
	 */
    public String getNetWgtSum() {
        return this.netWgtSum;
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
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return mrnPolutFlg
	 */
    public String getMrnPolutFlg() {
        return this.mrnPolutFlg;
    }

    /**
	 * Column Info
	 * @return rgnShpOprCd
	 */
    public String getRgnShpOprCd() {
        return this.rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @return dgTp
	 */
    public String getDgTp() {
        return this.dgTp;
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
	 * @return netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 * Column Info
	 * @return authDt
	 */
    public String getAuthDt() {
        return this.authDt;
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
	 * @return podClptIndSeq
	 */
    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthRjctCd
	 */
    public String getSpclCgoAuthRjctCd() {
        return this.spclCgoAuthRjctCd;
    }

    /**
	 * Column Info
	 * @return cntrCgoSeq
	 */
    public String getCntrCgoSeq() {
        return this.cntrCgoSeq;
    }

    public String getRankCnt() {
        return rankCnt;
    }

    public void setRankCnt(String rankCnt) {
        this.rankCnt = rankCnt;
    }

    /**
	 * Column Info
	 * @return rankSeq
	 */
    public String getRankSeq() {
        return this.rankSeq;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthRmk
	 */
    public String getSpclCgoAuthRmk() {
        return this.spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthSeq
	 */
    public String getSpclCgoAuthSeq() {
        return this.spclCgoAuthSeq;
    }

    /**
	 * Column Info
	 * @return ediChk
	 */
    public String getEdiChk() {
        return this.ediChk;
    }

    /**
	 * Column Info
	 * @return aproRefNo
	 */
    public String getAproRefNo() {
        return this.aproRefNo;
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
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return rqstUsrId
	 */
    public String getRqstUsrId() {
        return this.rqstUsrId;
    }

    /**
	 * Column Info
	 * @return bkgStwgCd
	 */
    public String getBkgStwgCd() {
        return this.bkgStwgCd;
    }

    /**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
    public String getBkgRcvTermCd() {
        return this.bkgRcvTermCd;
    }

    /**
	 * Column Info
	 * @return vpsEtaDt
	 */
    public String getVpsEtaDt() {
        return this.vpsEtaDt;
    }

    /**
	 * Column Info
	 * @return rqstGdt
	 */
    public String getRqstGdt() {
        return this.rqstGdt;
    }

    /**
	 * Column Info
	 * @return lstRqstDatFlg
	 */
    public String getLstRqstDatFlg() {
        return this.lstRqstDatFlg;
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
	 * @return vslPrePstCd
	 */
    public String getVslPrePstCd() {
        return this.vslPrePstCd;
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
	 * @return imdgExptQtyFlg
	 */
    public String getImdgExptQtyFlg() {
        return this.imdgExptQtyFlg;
    }

    /**
	 * Column Info
	 * @return rqstAuthCd
	 */
    public String getRqstAuthCd() {
        return this.rqstAuthCd;
    }

    /**
	 * Column Info
	 * @return spclCgoAuthCd
	 */
    public String getSpclCgoAuthCd() {
        return this.spclCgoAuthCd;
    }

    /**
	 * Column Info
	 * @return bookingNo
	 */
    public String getBookingNo() {
        return this.bookingNo;
    }

    /**
	 * Column Info
	 * @return vslNm
	 */
    public String getVslNm() {
        return this.vslNm;
    }

    /**
	 * Column Info
	 * @return ediSndNo
	 */
    public String getEdiSndNo() {
        return this.ediSndNo;
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
	 * @return crrCode
	 */
    public String getCrrCode() {
        return this.crrCode;
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
	 * @return rqstOfcCd
	 */
    public String getRqstOfcCd() {
        return this.rqstOfcCd;
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
	 * @return mapgEdiTrsmStsCd
	 */
    public String getMapgEdiTrsmStsCd() {
        return this.mapgEdiTrsmStsCd;
    }

    /**
	 * Column Info
	 * @return bkgDeTermCd
	 */
    public String getBkgDeTermCd() {
        return this.bkgDeTermCd;
    }

    /**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
    public String getImdgLmtQtyFlg() {
        return this.imdgLmtQtyFlg;
    }

    /**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
    public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
        this.spclCgoRqstSeq = spclCgoRqstSeq;
    }

    /**
	 * Column Info
	 * @param dcgoQty
	 */
    public void setDcgoQty(String dcgoQty) {
        this.dcgoQty = dcgoQty;
    }

    /**
	 * Column Info
	 * @param scgStwgCd
	 */
    public void setScgStwgCd(String scgStwgCd) {
        this.scgStwgCd = scgStwgCd;
    }

    /**
	 * Column Info
	 * @param no
	 */
    public void setNo(String no) {
        this.no = no;
    }

    /**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
    public void setImdgUnNoSeq(String imdgUnNoSeq) {
        this.imdgUnNoSeq = imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @param scgFlg
	 */
    public void setScgFlg(String scgFlg) {
        this.scgFlg = scgFlg;
    }

    /**
	 * Column Info
	 * @param dcgoSeq
	 */
    public void setDcgoSeq(String dcgoSeq) {
        this.dcgoSeq = dcgoSeq;
    }

    /**
	 * Column Info
	 * @param outImdgPckQty1
	 */
    public void setOutImdgPckQty1(String outImdgPckQty1) {
        this.outImdgPckQty1 = outImdgPckQty1;
    }

    /**
	 * Column Info
	 * @param emlChk
	 */
    public void setEmlChk(String emlChk) {
        this.emlChk = emlChk;
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
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param polClptIndSeq
	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
    }

    /**
	 * Column Info
	 * @param stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    /**
	 * Column Info
	 * @param imdgUnNo
	 */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
    }

    /**
	 * Column Info
	 * @param hcdgFlg
	 */
    public void setHcdgFlg(String hcdgFlg) {
        this.hcdgFlg = hcdgFlg;
    }

    /**
	 * Column Info
	 * @param intmdImdgPckQty1
	 */
    public void setIntmdImdgPckQty1(String intmdImdgPckQty1) {
        this.intmdImdgPckQty1 = intmdImdgPckQty1;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthNo
	 */
    public void setSpclCgoAuthNo(String spclCgoAuthNo) {
        this.spclCgoAuthNo = spclCgoAuthNo;
    }

    /**
	 * Column Info
	 * @param authOfcCd
	 */
    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    /**
	 * Column Info
	 * @param rsdFlg
	 */
    public void setRsdFlg(String rsdFlg) {
        this.rsdFlg = rsdFlg;
    }

    /**
	 * Column Info
	 * @param spclCgoCateCd
	 */
    public void setSpclCgoCateCd(String spclCgoCateCd) {
        this.spclCgoCateCd = spclCgoCateCd;
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
	 * @param podCd
	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param imdgSegrGrpNm
	 */
    public void setImdgSegrGrpNm(String imdgSegrGrpNm) {
        this.imdgSegrGrpNm = imdgSegrGrpNm;
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
	 * @param spclRqstDesc
	 */
    public void setSpclRqstDesc(String spclRqstDesc) {
        this.spclRqstDesc = spclRqstDesc;
    }

    /**
	 * Column Info
	 * @param imdgSegrGrpNo
	 */
    public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
        this.imdgSegrGrpNo = imdgSegrGrpNo;
    }

    /**
	 * Column Info
	 * @param mapgTrsmBndCd
	 */
    public void setMapgTrsmBndCd(String mapgTrsmBndCd) {
        this.mapgTrsmBndCd = mapgTrsmBndCd;
    }

    /**
	 * Column Info
	 * @param authUsrId
	 */
    public void setAuthUsrId(String authUsrId) {
        this.authUsrId = authUsrId;
    }

    /**
	 * Column Info
	 * @param rcFlg
	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param imdgClssCd
	 */
    public void setImdgClssCd(String imdgClssCd) {
        this.imdgClssCd = imdgClssCd;
    }

    /**
	 * Column Info
	 * @param mapgTrsmDt
	 */
    public void setMapgTrsmDt(String mapgTrsmDt) {
        this.mapgTrsmDt = mapgTrsmDt;
    }

    /**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
    public void setImdgPckGrpCd(String imdgPckGrpCd) {
        this.imdgPckGrpCd = imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @param rqstDay
	 */
    public void setRqstDay(String rqstDay) {
        this.rqstDay = rqstDay;
    }

    /**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
    public void setFlshPntCdoTemp(String flshPntCdoTemp) {
        this.flshPntCdoTemp = flshPntCdoTemp;
    }

    /**
	 * Column Info
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param vslSeq
	 */
    public void setVslSeq(String vslSeq) {
        this.vslSeq = vslSeq;
    }

    /**
	 * Column Info
	 * @param mapgPrnrSpclCgoSeq
	 */
    public void setMapgPrnrSpclCgoSeq(String mapgPrnrSpclCgoSeq) {
        this.mapgPrnrSpclCgoSeq = mapgPrnrSpclCgoSeq;
    }

    /**
	 * Column Info
	 * @param spclCgoAproRqstSeq
	 */
    public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
        this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
    }

    /**
	 * Column Info
	 * @param dgCntrSeq
	 */
    public void setDgCntrSeq(String dgCntrSeq) {
        this.dgCntrSeq = dgCntrSeq;
    }

    /**
	 * Column Info
	 * @param rqstDt
	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
    public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
        this.imdgSubsRskLblCd = imdgSubsRskLblCd;
    }

    /**
	 * Column Info
	 * @param emlSndNo
	 */
    public void setEmlSndNo(String emlSndNo) {
        this.emlSndNo = emlSndNo;
    }

    /**
	 * Column Info
	 * @param mapgTrsmSpclCgoCateCd
	 */
    public void setMapgTrsmSpclCgoCateCd(String mapgTrsmSpclCgoCateCd) {
        this.mapgTrsmSpclCgoCateCd = mapgTrsmSpclCgoCateCd;
    }

    /**
	 * Column Info
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param diffRmk
	 */
    public void setDiffRmk(String diffRmk) {
        this.diffRmk = diffRmk;
    }

    /**
	 * Column Info
	 * @param authGdt
	 */
    public void setAuthGdt(String authGdt) {
        this.authGdt = authGdt;
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
	 * @param inImdgPckQty1
	 */
    public void setInImdgPckQty1(String inImdgPckQty1) {
        this.inImdgPckQty1 = inImdgPckQty1;
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
	 * @param psaNo
	 */
    public void setPsaNo(String psaNo) {
        this.psaNo = psaNo;
    }

    /**
	 * Column Info
	 * @param dcgoStsCd
	 */
    public void setDcgoStsCd(String dcgoStsCd) {
        this.dcgoStsCd = dcgoStsCd;
    }

    /**
	 * Column Info
	 * @param netWgtSum
	 */
    public void setNetWgtSum(String netWgtSum) {
        this.netWgtSum = netWgtSum;
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
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param cfrFlg
	 */
    public void setCfrFlg(String cfrFlg) {
        this.cfrFlg = cfrFlg;
    }

    /**
	 * Column Info
	 * @param mrnPolutFlg
	 */
    public void setMrnPolutFlg(String mrnPolutFlg) {
        this.mrnPolutFlg = mrnPolutFlg;
    }

    /**
	 * Column Info
	 * @param rgnShpOprCd
	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
    }

    /**
	 * Column Info
	 * @param dgTp
	 */
    public void setDgTp(String dgTp) {
        this.dgTp = dgTp;
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
	 * @param netWgt
	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * Column Info
	 * @param authDt
	 */
    public void setAuthDt(String authDt) {
        this.authDt = authDt;
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
	 * @param podClptIndSeq
	 */
    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthRjctCd
	 */
    public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
    }

    /**
	 * Column Info
	 * @param cntrCgoSeq
	 */
    public void setCntrCgoSeq(String cntrCgoSeq) {
        this.cntrCgoSeq = cntrCgoSeq;
    }

    /**
	 * Column Info
	 * @param rankSeq
	 */
    public void setRankSeq(String rankSeq) {
        this.rankSeq = rankSeq;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthRmk
	 */
    public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
        this.spclCgoAuthRmk = spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthSeq
	 */
    public void setSpclCgoAuthSeq(String spclCgoAuthSeq) {
        this.spclCgoAuthSeq = spclCgoAuthSeq;
    }

    /**
	 * Column Info
	 * @param ediChk
	 */
    public void setEdiChk(String ediChk) {
        this.ediChk = ediChk;
    }

    /**
	 * Column Info
	 * @param aproRefNo
	 */
    public void setAproRefNo(String aproRefNo) {
        this.aproRefNo = aproRefNo;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param rqstUsrId
	 */
    public void setRqstUsrId(String rqstUsrId) {
        this.rqstUsrId = rqstUsrId;
    }

    /**
	 * Column Info
	 * @param bkgStwgCd
	 */
    public void setBkgStwgCd(String bkgStwgCd) {
        this.bkgStwgCd = bkgStwgCd;
    }

    /**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
    public void setBkgRcvTermCd(String bkgRcvTermCd) {
        this.bkgRcvTermCd = bkgRcvTermCd;
    }

    /**
	 * Column Info
	 * @param vpsEtaDt
	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param rqstGdt
	 */
    public void setRqstGdt(String rqstGdt) {
        this.rqstGdt = rqstGdt;
    }

    /**
	 * Column Info
	 * @param lstRqstDatFlg
	 */
    public void setLstRqstDatFlg(String lstRqstDatFlg) {
        this.lstRqstDatFlg = lstRqstDatFlg;
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
	 * @param vslPrePstCd
	 */
    public void setVslPrePstCd(String vslPrePstCd) {
        this.vslPrePstCd = vslPrePstCd;
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
	 * @param imdgExptQtyFlg
	 */
    public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
        this.imdgExptQtyFlg = imdgExptQtyFlg;
    }

    /**
	 * Column Info
	 * @param rqstAuthCd
	 */
    public void setRqstAuthCd(String rqstAuthCd) {
        this.rqstAuthCd = rqstAuthCd;
    }

    /**
	 * Column Info
	 * @param spclCgoAuthCd
	 */
    public void setSpclCgoAuthCd(String spclCgoAuthCd) {
        this.spclCgoAuthCd = spclCgoAuthCd;
    }

    /**
	 * Column Info
	 * @param bookingNo
	 */
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    /**
	 * Column Info
	 * @param vslNm
	 */
    public void setVslNm(String vslNm) {
        this.vslNm = vslNm;
    }

    /**
	 * Column Info
	 * @param ediSndNo
	 */
    public void setEdiSndNo(String ediSndNo) {
        this.ediSndNo = ediSndNo;
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
	 * @param crrCode
	 */
    public void setCrrCode(String crrCode) {
        this.crrCode = crrCode;
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
	 * @param rqstOfcCd
	 */
    public void setRqstOfcCd(String rqstOfcCd) {
        this.rqstOfcCd = rqstOfcCd;
    }

    /**
	 * Column Info
	 * @param prpShpNm
	 */
    public void setPrpShpNm(String prpShpNm) {
        this.prpShpNm = prpShpNm;
    }

    /**
	 * Column Info
	 * @param mapgEdiTrsmStsCd
	 */
    public void setMapgEdiTrsmStsCd(String mapgEdiTrsmStsCd) {
        this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
    }

    /**
	 * Column Info
	 * @param bkgDeTermCd
	 */
    public void setBkgDeTermCd(String bkgDeTermCd) {
        this.bkgDeTermCd = bkgDeTermCd;
    }

    /**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
    public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    public String getCmdtNm() {
        return cmdtNm;
    }

    public void setCmdtNm(String cmdtNm) {
        this.cmdtNm = cmdtNm;
    }

    public String getOpCntrQty() {
        return opCntrQty;
    }

    public void setOpCntrQty(String opCntrQty) {
        this.opCntrQty = opCntrQty;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setDcgoQty(JSPUtil.getParameter(request, prefix + "dcgo_qty", ""));
        setScgStwgCd(JSPUtil.getParameter(request, prefix + "scg_stwg_cd", ""));
        setNo(JSPUtil.getParameter(request, prefix + "no", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
        setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
        setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
        setBbCgoSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_seq", ""));
        setRcSeq(JSPUtil.getParameter(request, prefix + "rc_seq", ""));
        setStwgSeq(JSPUtil.getParameter(request, prefix + "stwg_seq", ""));
        setStwgFlg(JSPUtil.getParameter(request, prefix + "stwg_flg", ""));
        setVslPrePstNm(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_nm", ""));
        setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
        setEmlChk(JSPUtil.getParameter(request, prefix + "eml_chk", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
        setIntmdImdgPckQty1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", ""));
        setSpclCgoAuthNo(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_no", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setRsdFlg(JSPUtil.getParameter(request, prefix + "rsd_flg", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setImdgSegrGrpNm(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setSpclRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", ""));
        setImdgSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", ""));
        setMapgTrsmBndCd(JSPUtil.getParameter(request, prefix + "mapg_trsm_bnd_cd", ""));
        setAuthUsrId(JSPUtil.getParameter(request, prefix + "auth_usr_id", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setMapgTrsmDt(JSPUtil.getParameter(request, prefix + "mapg_trsm_dt", ""));
        setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
        setRqstDay(JSPUtil.getParameter(request, prefix + "rqst_day", ""));
        setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
        setMapgPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "mapg_prnr_spcl_cgo_seq", ""));
        setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
        setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
        setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
        setMapgTrsmSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "mapg_trsm_spcl_cgo_cate_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setAuthGdt(JSPUtil.getParameter(request, prefix + "auth_gdt", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
        setDcgoStsCd(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", ""));
        setNetWgtSum(JSPUtil.getParameter(request, prefix + "net_wgt_sum", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCfrFlg(JSPUtil.getParameter(request, prefix + "cfr_flg", ""));
        setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
        setDgTp(JSPUtil.getParameter(request, prefix + "dg_tp", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setAuthDt(JSPUtil.getParameter(request, prefix + "auth_dt", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
        setSpclCgoAuthRjctCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", ""));
        setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
        setRankSeq(JSPUtil.getParameter(request, prefix + "rank_seq", ""));
        setRankCnt(JSPUtil.getParameter(request, prefix + "rank_cnt", ""));
        setSpclCgoAuthRmk(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", ""));
        setSpclCgoAuthSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", ""));
        setEdiChk(JSPUtil.getParameter(request, prefix + "edi_chk", ""));
        setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
        setBkgStwgCd(JSPUtil.getParameter(request, prefix + "bkg_stwg_cd", ""));
        setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setRqstGdt(JSPUtil.getParameter(request, prefix + "rqst_gdt", ""));
        setLstRqstDatFlg(JSPUtil.getParameter(request, prefix + "lst_rqst_dat_flg", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
        setRqstAuthCd(JSPUtil.getParameter(request, prefix + "rqst_auth_cd", ""));
        setSpclCgoAuthCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", ""));
        setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
        setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
        setEdiSndNo(JSPUtil.getParameter(request, prefix + "edi_snd_no", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setCrrCode(JSPUtil.getParameter(request, prefix + "crr_code", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setMapgEdiTrsmStsCd(JSPUtil.getParameter(request, prefix + "mapg_edi_trsm_sts_cd", ""));
        setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
        setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnStwgListVO[]
	 */
    public SearchOwnStwgListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnStwgListVO[]
	 */
    public SearchOwnStwgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchOwnStwgListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] dcgoQty = (JSPUtil.getParameter(request, prefix + "dcgo_qty", length));
            String[] scgStwgCd = (JSPUtil.getParameter(request, prefix + "scg_stwg_cd", length));
            String[] no = (JSPUtil.getParameter(request, prefix + "no", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] scgFlg = (JSPUtil.getParameter(request, prefix + "scg_flg", length));
            String[] dcgoSeq = (JSPUtil.getParameter(request, prefix + "dcgo_seq", length));
            String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix + "awk_cgo_seq", length));
            String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix + "bb_cgo_seq", length));
            String[] rcSeq = (JSPUtil.getParameter(request, prefix + "rc_seq", length));
            String[] stwgSeq = (JSPUtil.getParameter(request, prefix + "stwg_seq", length));
            String[] stwgFlg = (JSPUtil.getParameter(request, prefix + "stwg_flg", length));
            String[] vslPrePstNm = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_nm", length));
            String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", length));
            String[] emlChk = (JSPUtil.getParameter(request, prefix + "eml_chk", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] hcdgFlg = (JSPUtil.getParameter(request, prefix + "hcdg_flg", length));
            String[] intmdImdgPckQty1 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", length));
            String[] spclCgoAuthNo = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_no", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] rsdFlg = (JSPUtil.getParameter(request, prefix + "rsd_flg", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] imdgSegrGrpNm = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] spclRqstDesc = (JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", length));
            String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", length));
            String[] mapgTrsmBndCd = (JSPUtil.getParameter(request, prefix + "mapg_trsm_bnd_cd", length));
            String[] authUsrId = (JSPUtil.getParameter(request, prefix + "auth_usr_id", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] mapgTrsmDt = (JSPUtil.getParameter(request, prefix + "mapg_trsm_dt", length));
            String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", length));
            String[] rqstDay = (JSPUtil.getParameter(request, prefix + "rqst_day", length));
            String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] vslSeq = (JSPUtil.getParameter(request, prefix + "vsl_seq", length));
            String[] mapgPrnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "mapg_prnr_spcl_cgo_seq", length));
            String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", length));
            String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix + "dg_cntr_seq", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", length));
            String[] emlSndNo = (JSPUtil.getParameter(request, prefix + "eml_snd_no", length));
            String[] mapgTrsmSpclCgoCateCd = (JSPUtil.getParameter(request, prefix + "mapg_trsm_spcl_cgo_cate_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] authGdt = (JSPUtil.getParameter(request, prefix + "auth_gdt", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] psaNo = (JSPUtil.getParameter(request, prefix + "psa_no", length));
            String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", length));
            String[] netWgtSum = (JSPUtil.getParameter(request, prefix + "net_wgt_sum", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cfrFlg = (JSPUtil.getParameter(request, prefix + "cfr_flg", length));
            String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix + "mrn_polut_flg", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
            String[] dgTp = (JSPUtil.getParameter(request, prefix + "dg_tp", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] authDt = (JSPUtil.getParameter(request, prefix + "auth_dt", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
            String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", length));
            String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", length));
            String[] rankSeq = (JSPUtil.getParameter(request, prefix + "rank_seq", length));
            String[] rankCnt = (JSPUtil.getParameter(request, prefix + "rank_cnt", length));
            String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", length));
            String[] spclCgoAuthSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_seq", length));
            String[] ediChk = (JSPUtil.getParameter(request, prefix + "edi_chk", length));
            String[] aproRefNo = (JSPUtil.getParameter(request, prefix + "apro_ref_no", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] rqstUsrId = (JSPUtil.getParameter(request, prefix + "rqst_usr_id", length));
            String[] bkgStwgCd = (JSPUtil.getParameter(request, prefix + "bkg_stwg_cd", length));
            String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] rqstGdt = (JSPUtil.getParameter(request, prefix + "rqst_gdt", length));
            String[] lstRqstDatFlg = (JSPUtil.getParameter(request, prefix + "lst_rqst_dat_flg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", length));
            String[] rqstAuthCd = (JSPUtil.getParameter(request, prefix + "rqst_auth_cd", length));
            String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_cd", length));
            String[] bookingNo = (JSPUtil.getParameter(request, prefix + "booking_no", length));
            String[] vslNm = (JSPUtil.getParameter(request, prefix + "vsl_nm", length));
            String[] ediSndNo = (JSPUtil.getParameter(request, prefix + "edi_snd_no", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] crrCode = (JSPUtil.getParameter(request, prefix + "crr_code", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] mapgEdiTrsmStsCd = (JSPUtil.getParameter(request, prefix + "mapg_edi_trsm_sts_cd", length));
            String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", length));
            String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] opCntrQty = (JSPUtil.getParameter(request, prefix + "op_cntr_qty", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SearchOwnStwgListVO();
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (dcgoQty[i] != null)
                    model.setDcgoQty(dcgoQty[i]);
                if (scgStwgCd[i] != null)
                    model.setScgStwgCd(scgStwgCd[i]);
                if (no[i] != null)
                    model.setNo(no[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (scgFlg[i] != null)
                    model.setScgFlg(scgFlg[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (awkCgoSeq[i] != null)
                    model.setAwkCgoSeq(awkCgoSeq[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (bbCgoSeq[i] != null)
                    model.setBbCgoSeq(bbCgoSeq[i]);
                if (rcSeq[i] != null)
                    model.setRcSeq(rcSeq[i]);
                if (stwgFlg[i] != null)
                    model.setStwgFlg(stwgFlg[i]);
                if (vslPrePstNm[i] != null)
                    model.setVslPrePstNm(vslPrePstNm[i]);
                if (outImdgPckQty1[i] != null)
                    model.setOutImdgPckQty1(outImdgPckQty1[i]);
                if (emlChk[i] != null)
                    model.setEmlChk(emlChk[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (hcdgFlg[i] != null)
                    model.setHcdgFlg(hcdgFlg[i]);
                if (intmdImdgPckQty1[i] != null)
                    model.setIntmdImdgPckQty1(intmdImdgPckQty1[i]);
                if (spclCgoAuthNo[i] != null)
                    model.setSpclCgoAuthNo(spclCgoAuthNo[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (rsdFlg[i] != null)
                    model.setRsdFlg(rsdFlg[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (imdgSegrGrpNm[i] != null)
                    model.setImdgSegrGrpNm(imdgSegrGrpNm[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (spclRqstDesc[i] != null)
                    model.setSpclRqstDesc(spclRqstDesc[i]);
                if (imdgSegrGrpNo[i] != null)
                    model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);
                if (mapgTrsmBndCd[i] != null)
                    model.setMapgTrsmBndCd(mapgTrsmBndCd[i]);
                if (authUsrId[i] != null)
                    model.setAuthUsrId(authUsrId[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (mapgTrsmDt[i] != null)
                    model.setMapgTrsmDt(mapgTrsmDt[i]);
                if (imdgPckGrpCd[i] != null)
                    model.setImdgPckGrpCd(imdgPckGrpCd[i]);
                if (rqstDay[i] != null)
                    model.setRqstDay(rqstDay[i]);
                if (flshPntCdoTemp[i] != null)
                    model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (vslSeq[i] != null)
                    model.setVslSeq(vslSeq[i]);
                if (mapgPrnrSpclCgoSeq[i] != null)
                    model.setMapgPrnrSpclCgoSeq(mapgPrnrSpclCgoSeq[i]);
                if (spclCgoAproRqstSeq[i] != null)
                    model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
                if (dgCntrSeq[i] != null)
                    model.setDgCntrSeq(dgCntrSeq[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (imdgSubsRskLblCd[i] != null)
                    model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
                if (emlSndNo[i] != null)
                    model.setEmlSndNo(emlSndNo[i]);
                if (mapgTrsmSpclCgoCateCd[i] != null)
                    model.setMapgTrsmSpclCgoCateCd(mapgTrsmSpclCgoCateCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (authGdt[i] != null)
                    model.setAuthGdt(authGdt[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (inImdgPckQty1[i] != null)
                    model.setInImdgPckQty1(inImdgPckQty1[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (psaNo[i] != null)
                    model.setPsaNo(psaNo[i]);
                if (dcgoStsCd[i] != null)
                    model.setDcgoStsCd(dcgoStsCd[i]);
                if (netWgtSum[i] != null)
                    model.setNetWgtSum(netWgtSum[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cfrFlg[i] != null)
                    model.setCfrFlg(cfrFlg[i]);
                if (mrnPolutFlg[i] != null)
                    model.setMrnPolutFlg(mrnPolutFlg[i]);
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
                if (dgTp[i] != null)
                    model.setDgTp(dgTp[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (authDt[i] != null)
                    model.setAuthDt(authDt[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (spclCgoAuthRjctCd[i] != null)
                    model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
                if (cntrCgoSeq[i] != null)
                    model.setCntrCgoSeq(cntrCgoSeq[i]);
                if (rankSeq[i] != null)
                    model.setRankSeq(rankSeq[i]);
                if (rankCnt[i] != null)
                    model.setRankCnt(rankCnt[i]);
                if (spclCgoAuthRmk[i] != null)
                    model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
                if (spclCgoAuthSeq[i] != null)
                    model.setSpclCgoAuthSeq(spclCgoAuthSeq[i]);
                if (ediChk[i] != null)
                    model.setEdiChk(ediChk[i]);
                if (aproRefNo[i] != null)
                    model.setAproRefNo(aproRefNo[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (rqstUsrId[i] != null)
                    model.setRqstUsrId(rqstUsrId[i]);
                if (bkgStwgCd[i] != null)
                    model.setBkgStwgCd(bkgStwgCd[i]);
                if (bkgRcvTermCd[i] != null)
                    model.setBkgRcvTermCd(bkgRcvTermCd[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (rqstGdt[i] != null)
                    model.setRqstGdt(rqstGdt[i]);
                if (lstRqstDatFlg[i] != null)
                    model.setLstRqstDatFlg(lstRqstDatFlg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (vslPrePstCd[i] != null)
                    model.setVslPrePstCd(vslPrePstCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (imdgExptQtyFlg[i] != null)
                    model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
                if (rqstAuthCd[i] != null)
                    model.setRqstAuthCd(rqstAuthCd[i]);
                if (spclCgoAuthCd[i] != null)
                    model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
                if (bookingNo[i] != null)
                    model.setBookingNo(bookingNo[i]);
                if (vslNm[i] != null)
                    model.setVslNm(vslNm[i]);
                if (ediSndNo[i] != null)
                    model.setEdiSndNo(ediSndNo[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (crrCode[i] != null)
                    model.setCrrCode(crrCode[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (rqstOfcCd[i] != null)
                    model.setRqstOfcCd(rqstOfcCd[i]);
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (mapgEdiTrsmStsCd[i] != null)
                    model.setMapgEdiTrsmStsCd(mapgEdiTrsmStsCd[i]);
                if (bkgDeTermCd[i] != null)
                    model.setBkgDeTermCd(bkgDeTermCd[i]);
                if (imdgLmtQtyFlg[i] != null)
                    model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (opCntrQty[i] != null)
                    model.setOpCntrQty(opCntrQty[i]);
                if (updDt[i] != null) 
		    		model.setUpdDt(updDt[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            } 
        } catch (Exception e) {
            return null;
        }
        return getSearchOwnStwgListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchOwnStwgListVO[]
	 */
    public SearchOwnStwgListVO[] getSearchOwnStwgListVOs() {
        SearchOwnStwgListVO[] vos = (SearchOwnStwgListVO[]) models.toArray(new SearchOwnStwgListVO[models.size()]);
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
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoQty = this.dcgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgStwgCd = this.scgStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.no = this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgFlg = this.scgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoSeq = this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoSeq = this.awkCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoSeq = this.bbCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcSeq = this.rcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgSeq = this.stwgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgFlg = this.stwgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstNm = this.vslPrePstNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckQty1 = this.outImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlChk = this.emlChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgFlg = this.hcdgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckQty1 = this.intmdImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthNo = this.spclCgoAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsdFlg = this.rsdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNm = this.imdgSegrGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclRqstDesc = this.spclRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNo = this.imdgSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgTrsmBndCd = this.mapgTrsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authUsrId = this.authUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgTrsmDt = this.mapgTrsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCd = this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDay = this.rqstDay.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntCdoTemp = this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslSeq = this.vslSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgPrnrSpclCgoSeq = this.mapgPrnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCntrSeq = this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd = this.imdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emlSndNo = this.emlSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgTrsmSpclCgoCateCd = this.mapgTrsmSpclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authGdt = this.authGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckQty1 = this.inImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psaNo = this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoStsCd = this.dcgoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgtSum = this.netWgtSum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfrFlg = this.cfrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnPolutFlg = this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgTp = this.dgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authDt = this.authDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoSeq = this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rankSeq = this.rankSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rankCnt = this.rankCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRmk = this.spclCgoAuthRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthSeq = this.spclCgoAuthSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediChk = this.ediChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrId = this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStwgCd = this.bkgStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRcvTermCd = this.bkgRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstGdt = this.rqstGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstRqstDatFlg = this.lstRqstDatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslPrePstCd = this.vslPrePstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyFlg = this.imdgExptQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstAuthCd = this.rqstAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthCd = this.spclCgoAuthCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bookingNo = this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslNm = this.vslNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediSndNo = this.ediSndNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCode = this.crrCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstOfcCd = this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mapgEdiTrsmStsCd = this.mapgEdiTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgDeTermCd = this.bkgDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyFlg = this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opCntrQty = this.opCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
