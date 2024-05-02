/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SendEdiFromBkgDtlVO.java
 *@FileTitle : SendEdiFromBkgDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.11
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.11 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.vo;

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
public class SendEdiFromBkgDtlVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SendEdiFromBkgDtlVO> models = new ArrayList<SendEdiFromBkgDtlVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String bkgNo = null;

    /*	Column Info	*/
    private String dcgoSeq = null;

    /*	Column Info	*/
    private String dgCntrSeq = null;

    /*	Column Info	*/
    private String cntrCgoSeq = null;

    /*	Column Info	*/
    private String cntrNo = null;

    /*	Column Info	*/
    private String cntrVolQty = null;

    /*	Column Info	*/
    private String cntrTpszCd = null;

    /*	Column Info	*/
    private String cntrTpszIsoCd = null;

    /*	Column Info	*/
    private String imdgUnNo = null;

    /*	Column Info	*/
    private String imdgUnNoSeq = null;

    /*	Column Info	*/
    private String imdgClssCd = null;

    /*	Column Info	*/
    private String imdgCompGrpCd = null;

    /*	Column Info	*/
    private String imdgSubsRskLblCd1 = null;

    /*	Column Info	*/
    private String imdgSubsRskLblCd2 = null;

    /*	Column Info	*/
    private String imdgSubsRskLblCd3 = null;

    /*	Column Info	*/
    private String imdgSubsRskLblCd4 = null;

    /*	Column Info	*/
    private String imdgLmtQtyFlg = null;

    /*	Column Info	*/
    private String imdgExptQtyFlg = null;

    /*	Column Info	*/
    private String netWgt = null;

    /*	Column Info	*/
    private String grsWgt = null;

    /*	Column Info	*/
    private String wgtUtCd = null;

    /*	Column Info	*/
    private String flshPntCdoTemp = null;

    /*	Column Info	*/
    private String prpShpNm = null;

    /*	Column Info	*/
    private String hzdDesc = null;

    /*	Column Info	*/
    private String measQty = null;

    /*	Column Info	*/
    private String measUtCd = null;

    /*	Column Info	*/
    private String clodFlg = null;

    /*	Column Info	*/
    private String spclStwgRqstDesc = null;

    /*	Column Info	*/
    private String dcgoStsCd = null;

    /*	Column Info	*/
    private String cgoLclFlg = null;

    /*	Column Info	*/
    private String emerRspnGidNo = null;

    /*	Column Info	*/
    private String emerRspnGidChrNo = null;

    /*	Column Info	*/
    private String emerCntcPhnNoCtnt = null;

    /*	Column Info	*/
    private String emerCntcPsonNm = null;

    /*	Column Info	*/
    private String emerTempCtnt = null;

    /*	Column Info	*/
    private String ctrlTempCtnt = null;

    /*	Column Info	*/
    private String emsNo = null;

    /*	Column Info	*/
    private String imdgPckGrpCd = null;

    /*	Column Info	*/
    private String mrnPolutFlg = null;

    /*	Column Info	*/
    private String psaNo = null;

    /*	Column Info	*/
    private String certiNo = null;

    /*	Column Info	*/
    private String inImdgPckQty1 = null;

    /*	Column Info	*/
    private String inImdgPckCd1 = null;

    /*	Column Info	*/
    private String inImdgPckDesc1 = null;

    /*	Column Info	*/
    private String inImdgPckQty2 = null;

    /*	Column Info	*/
    private String inImdgPckCd2 = null;

    /*	Column Info	*/
    private String inImdgPckDesc2 = null;

    /*	Column Info	*/
    private String intmdImdgPckQty1 = null;

    /*	Column Info	*/
    private String intmdImdgPckCd1 = null;

    /*	Column Info	*/
    private String intmdImdgPckDesc1 = null;

    /*	Column Info	*/
    private String intmdImdgPckQty2 = null;

    /*	Column Info	*/
    private String intmdImdgPckCd2 = null;

    /*	Column Info	*/
    private String intmdImdgPckDesc2 = null;

    /*	Column Info	*/
    private String outImdgPckQty1 = null;

    /*	Column Info	*/
    private String outImdgPckCd1 = null;

    /*	Column Info	*/
    private String outImdgPckDesc1 = null;

    /*	Column Info	*/
    private String outImdgPckQty2 = null;

    /*	Column Info	*/
    private String outImdgPckCd2 = null;

    /*	Column Info	*/
    private String outImdgPckDesc2 = null;

    /*	Column Info	*/
    private String maxInPckQty = null;

    /*	Column Info	*/
    private String maxInPckTpCd = null;

    /*	Column Info	*/
    private String cneeDtlDesc = null;

    /*	Column Info	*/
    private String netExploWgt = null;

    /*	Column Info	*/
    private String radaSkdNo = null;

    /*	Column Info	*/
    private String radaAmt = null;

    /*	Column Info	*/
    private String radaUtCd = null;

    /*	Column Info	*/
    private String rcFlg = null;

    /*	Column Info	*/
    private String awkCgoFlg = null;

    /*	Column Info	*/
    private String bbCgoFlg = null;

    /*	Column Info	*/
    private String rcSeq = null;

    /*	Column Info	*/
    private String awkCgoSeq = null;

    /*	Column Info	*/
    private String bbCgoSeq = null;

    /*	Column Info	*/
    private String hcdgFlg = null;

    /*	Column Info	*/
    private String hcdgDpndQtyFlg = null;

    /*	Column Info	*/
    private String rqstDt = null;

    /*	Column Info	*/
    private String rqstGdt = null;

    /*	Column Info	*/
    private String rqstUsrId = null;

    /*	Column Info	*/
    private String aplyNo = null;

    /*	Column Info	*/
    private String spclCgoAproCd = null;

    /*	Column Info	*/
    private String spclRqstFlg = null;

    /*	Column Info	*/
    private String spclRqstDesc = null;

    /*	Column Info	*/
    private String diffRmk = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String radaTrspNo = null;

    /*	Column Info	*/
    private String hzdCtnt = null;

    /*	Column Info	*/
    private String stwgTempCtnt = null;

    /*	Column Info	*/
    private String grsCapaQty = null;

    /*	Column Info	*/
    private String dcgoRqstGrpEml1 = null;

    /*	Column Info	*/
    private String dcgoRqstGrpEml2 = null;

    /*	Column Info	*/
    private String cfrFlg = null;

    /*	Column Info	*/
    private String rsdFlg = null;

    /*	Column Info	*/
    private String imdgSegrGrpNo = null;

    /*	Column Info	*/
    private String dcgoRefNo = null;

    /* Column Info */
    private String imdgAmdtNo = null;

    /* Column Info */
    private String ttlCntrKnt = null;

    /* Column Info */
    private String cntrDmyRefNo = null;

    /* Column Info */
    private String imdgN1stSegrGrpNo = null;

    /* Column Info */
    private String imdgN2ndSegrGrpNo = null;

    /* Column Info */
    private String imdgN3rdSegrGrpNo = null;

    /* Column Info */
    private String imdgN4thSegrGrpNo = null;

    /* Column Info */
    private String imdgSegrGrpNos = null;

    /* Column Info */
    private String imdgSegrGrpNm = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public SendEdiFromBkgDtlVO() {
    }

    public SendEdiFromBkgDtlVO(String ibflag, String pagerows, String bkgNo, String dcgoSeq, String dgCntrSeq, String cntrCgoSeq, String cntrNo, String cntrVolQty, String cntrTpszCd, String cntrTpszIsoCd, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String imdgCompGrpCd, String imdgSubsRskLblCd1, String imdgSubsRskLblCd2, String imdgSubsRskLblCd3, String imdgSubsRskLblCd4, String imdgLmtQtyFlg, String imdgExptQtyFlg, String netWgt, String grsWgt, String wgtUtCd, String flshPntCdoTemp, String prpShpNm, String hzdDesc, String measQty, String measUtCd, String clodFlg, String spclStwgRqstDesc, String dcgoStsCd, String cgoLclFlg, String emerRspnGidNo, String emerRspnGidChrNo, String emerCntcPhnNoCtnt, String emerCntcPsonNm, String emerTempCtnt, String ctrlTempCtnt, String emsNo, String imdgPckGrpCd, String mrnPolutFlg, String psaNo, String certiNo, String inImdgPckQty1, String inImdgPckCd1, String inImdgPckDesc1, String inImdgPckQty2, String inImdgPckCd2, String inImdgPckDesc2, String intmdImdgPckQty1, String intmdImdgPckCd1, String intmdImdgPckDesc1, String intmdImdgPckQty2, String intmdImdgPckCd2, String intmdImdgPckDesc2, String outImdgPckQty1, String outImdgPckCd1, String outImdgPckDesc1, String outImdgPckQty2, String outImdgPckCd2, String outImdgPckDesc2, String maxInPckQty, String maxInPckTpCd, String cneeDtlDesc, String netExploWgt, String radaSkdNo, String radaAmt, String radaUtCd, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rcSeq, String awkCgoSeq, String bbCgoSeq, String hcdgFlg, String hcdgDpndQtyFlg, String rqstDt, String rqstGdt, String rqstUsrId, String aplyNo, String spclCgoAproCd, String spclRqstFlg, String spclRqstDesc, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String radaTrspNo, String hzdCtnt, String stwgTempCtnt, String grsCapaQty, String dcgoRqstGrpEml1, String dcgoRqstGrpEml2, String cfrFlg, String rsdFlg, String imdgSegrGrpNo, String imdgAmdtNo, String ttlCntrKnt, String cntrDmyRefNo, String imdgN1stSegrGrpNo, String imdgN2ndSegrGrpNo, String imdgN3rdSegrGrpNo, String imdgN4thSegrGrpNo, String imdgSegrGrpNos, String imdgSegrGrpNm) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.bkgNo = bkgNo;
        this.dcgoSeq = dcgoSeq;
        this.dgCntrSeq = dgCntrSeq;
        this.cntrCgoSeq = cntrCgoSeq;
        this.cntrNo = cntrNo;
        this.cntrVolQty = cntrVolQty;
        this.cntrTpszCd = cntrTpszCd;
        this.cntrTpszIsoCd = cntrTpszIsoCd;
        this.imdgUnNo = imdgUnNo;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.imdgClssCd = imdgClssCd;
        this.imdgCompGrpCd = imdgCompGrpCd;
        this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
        this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
        this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
        this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
        this.imdgExptQtyFlg = imdgExptQtyFlg;
        this.netWgt = netWgt;
        this.grsWgt = grsWgt;
        this.wgtUtCd = wgtUtCd;
        this.flshPntCdoTemp = flshPntCdoTemp;
        this.prpShpNm = prpShpNm;
        this.hzdDesc = hzdDesc;
        this.measQty = measQty;
        this.measUtCd = measUtCd;
        this.clodFlg = clodFlg;
        this.spclStwgRqstDesc = spclStwgRqstDesc;
        this.dcgoStsCd = dcgoStsCd;
        this.cgoLclFlg = cgoLclFlg;
        this.emerRspnGidNo = emerRspnGidNo;
        this.emerRspnGidChrNo = emerRspnGidChrNo;
        this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
        this.emerCntcPsonNm = emerCntcPsonNm;
        this.emerTempCtnt = emerTempCtnt;
        this.ctrlTempCtnt = ctrlTempCtnt;
        this.emsNo = emsNo;
        this.imdgPckGrpCd = imdgPckGrpCd;
        this.mrnPolutFlg = mrnPolutFlg;
        this.psaNo = psaNo;
        this.certiNo = certiNo;
        this.inImdgPckQty1 = inImdgPckQty1;
        this.inImdgPckCd1 = inImdgPckCd1;
        this.inImdgPckDesc1 = inImdgPckDesc1;
        this.inImdgPckQty2 = inImdgPckQty2;
        this.inImdgPckCd2 = inImdgPckCd2;
        this.inImdgPckDesc2 = inImdgPckDesc2;
        this.intmdImdgPckQty1 = intmdImdgPckQty1;
        this.intmdImdgPckCd1 = intmdImdgPckCd1;
        this.intmdImdgPckDesc1 = intmdImdgPckDesc1;
        this.intmdImdgPckQty2 = intmdImdgPckQty2;
        this.intmdImdgPckCd2 = intmdImdgPckCd2;
        this.intmdImdgPckDesc2 = intmdImdgPckDesc2;
        this.outImdgPckQty1 = outImdgPckQty1;
        this.outImdgPckCd1 = outImdgPckCd1;
        this.outImdgPckDesc1 = outImdgPckDesc1;
        this.outImdgPckQty2 = outImdgPckQty2;
        this.outImdgPckCd2 = outImdgPckCd2;
        this.outImdgPckDesc2 = outImdgPckDesc2;
        this.maxInPckQty = maxInPckQty;
        this.maxInPckTpCd = maxInPckTpCd;
        this.cneeDtlDesc = cneeDtlDesc;
        this.netExploWgt = netExploWgt;
        this.radaSkdNo = radaSkdNo;
        this.radaAmt = radaAmt;
        this.radaUtCd = radaUtCd;
        this.rcFlg = rcFlg;
        this.awkCgoFlg = awkCgoFlg;
        this.bbCgoFlg = bbCgoFlg;
        this.rcSeq = rcSeq;
        this.awkCgoSeq = awkCgoSeq;
        this.bbCgoSeq = bbCgoSeq;
        this.hcdgFlg = hcdgFlg;
        this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
        this.rqstDt = rqstDt;
        this.rqstGdt = rqstGdt;
        this.rqstUsrId = rqstUsrId;
        this.aplyNo = aplyNo;
        this.spclCgoAproCd = spclCgoAproCd;
        this.spclRqstFlg = spclRqstFlg;
        this.spclRqstDesc = spclRqstDesc;
        this.diffRmk = diffRmk;
        this.creUsrId = creUsrId;
        this.creDt = creDt;
        this.updUsrId = updUsrId;
        this.updDt = updDt;
        this.radaTrspNo = radaTrspNo;
        this.hzdCtnt = hzdCtnt;
        this.stwgTempCtnt = stwgTempCtnt;
        this.grsCapaQty = grsCapaQty;
        this.dcgoRqstGrpEml1 = dcgoRqstGrpEml1;
        this.dcgoRqstGrpEml2 = dcgoRqstGrpEml2;
        this.cfrFlg = cfrFlg;
        this.rsdFlg = rsdFlg;
        this.imdgSegrGrpNo = imdgSegrGrpNo;
        this.imdgAmdtNo = imdgAmdtNo;
        this.ttlCntrKnt = ttlCntrKnt;
        this.cntrDmyRefNo = cntrDmyRefNo;
        this.imdgN1stSegrGrpNo = imdgN1stSegrGrpNo;
        this.imdgN2ndSegrGrpNo = imdgN2ndSegrGrpNo;
        this.imdgN3rdSegrGrpNo = imdgN3rdSegrGrpNo;
        this.imdgN4thSegrGrpNo = imdgN4thSegrGrpNo;
        this.imdgSegrGrpNos = imdgSegrGrpNos;
        this.imdgSegrGrpNm = imdgSegrGrpNm;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("dcgo_seq", getDcgoSeq());
        this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
        this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd3", getImdgSubsRskLblCd3());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd4", getImdgSubsRskLblCd4());
        this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
        this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("hzd_desc", getHzdDesc());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("meas_ut_cd", getMeasUtCd());
        this.hashColumns.put("clod_flg", getClodFlg());
        this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
        this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
        this.hashColumns.put("cgo_lcl_flg", getCgoLclFlg());
        this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
        this.hashColumns.put("emer_rspn_gid_chr_no", getEmerRspnGidChrNo());
        this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());
        this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());
        this.hashColumns.put("emer_temp_ctnt", getEmerTempCtnt());
        this.hashColumns.put("ctrl_temp_ctnt", getCtrlTempCtnt());
        this.hashColumns.put("ems_no", getEmsNo());
        this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
        this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
        this.hashColumns.put("psa_no", getPsaNo());
        this.hashColumns.put("certi_no", getCertiNo());
        this.hashColumns.put("in_imdg_pck_qty1", getInImdgPckQty1());
        this.hashColumns.put("in_imdg_pck_cd1", getInImdgPckCd1());
        this.hashColumns.put("in_imdg_pck_desc1", getInImdgPckDesc1());
        this.hashColumns.put("in_imdg_pck_qty2", getInImdgPckQty2());
        this.hashColumns.put("in_imdg_pck_cd2", getInImdgPckCd2());
        this.hashColumns.put("in_imdg_pck_desc2", getInImdgPckDesc2());
        this.hashColumns.put("intmd_imdg_pck_qty1", getIntmdImdgPckQty1());
        this.hashColumns.put("intmd_imdg_pck_cd1", getIntmdImdgPckCd1());
        this.hashColumns.put("intmd_imdg_pck_desc1", getIntmdImdgPckDesc1());
        this.hashColumns.put("intmd_imdg_pck_qty2", getIntmdImdgPckQty2());
        this.hashColumns.put("intmd_imdg_pck_cd2", getIntmdImdgPckCd2());
        this.hashColumns.put("intmd_imdg_pck_desc2", getIntmdImdgPckDesc2());
        this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
        this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
        this.hashColumns.put("out_imdg_pck_desc1", getOutImdgPckDesc1());
        this.hashColumns.put("out_imdg_pck_qty2", getOutImdgPckQty2());
        this.hashColumns.put("out_imdg_pck_cd2", getOutImdgPckCd2());
        this.hashColumns.put("out_imdg_pck_desc2", getOutImdgPckDesc2());
        this.hashColumns.put("max_in_pck_qty", getMaxInPckQty());
        this.hashColumns.put("max_in_pck_tp_cd", getMaxInPckTpCd());
        this.hashColumns.put("cnee_dtl_desc", getCneeDtlDesc());
        this.hashColumns.put("net_explo_wgt", getNetExploWgt());
        this.hashColumns.put("rada_skd_no", getRadaSkdNo());
        this.hashColumns.put("rada_amt", getRadaAmt());
        this.hashColumns.put("rada_ut_cd", getRadaUtCd());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("rc_seq", getRcSeq());
        this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
        this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
        this.hashColumns.put("hcdg_flg", getHcdgFlg());
        this.hashColumns.put("hcdg_dpnd_qty_flg", getHcdgDpndQtyFlg());
        this.hashColumns.put("rqst_dt", getRqstDt());
        this.hashColumns.put("rqst_gdt", getRqstGdt());
        this.hashColumns.put("rqst_usr_id", getRqstUsrId());
        this.hashColumns.put("aply_no", getAplyNo());
        this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
        this.hashColumns.put("spcl_rqst_flg", getSpclRqstFlg());
        this.hashColumns.put("spcl_rqst_desc", getSpclRqstDesc());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("rada_trsp_no", getRadaTrspNo());
        this.hashColumns.put("hzd_ctnt", getHzdCtnt());
        this.hashColumns.put("stwg_temp_ctnt", getStwgTempCtnt());
        this.hashColumns.put("grs_capa_qty", getGrsCapaQty());
        this.hashColumns.put("dcgo_rqst_grp_eml1", getDcgoRqstGrpEml1());
        this.hashColumns.put("dcgo_rqst_grp_eml2", getDcgoRqstGrpEml2());
        this.hashColumns.put("cfr_flg", getCfrFlg());
        this.hashColumns.put("rsd_flg", getRsdFlg());
        this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("imdg_amdt_no", getImdgAmdtNo());
        this.hashColumns.put("ttl_cntr_knt", getTtlCntrKnt());
        this.hashColumns.put("cntr_dmy_ref_no", getCntrDmyRefNo());
        this.hashColumns.put("imdg_n1st_segr_grp_no", getImdgN1stSegrGrpNo());
        this.hashColumns.put("imdg_n2nd_segr_grp_no", getImdgN2ndSegrGrpNo());
        this.hashColumns.put("imdg_n3rd_segr_grp_no", getImdgN3rdSegrGrpNo());
        this.hashColumns.put("imdg_n4th_segr_grp_no", getImdgN4thSegrGrpNo());
        this.hashColumns.put("imdg_segr_grp_nos", getImdgSegrGrpNos());
        this.hashColumns.put("imdg_segr_grp_nm", getImdgSegrGrpNm());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("dcgo_seq", "dcgoSeq");
        this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
        this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("cntr_vol_qty", "cntrVolQty");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
        this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
        this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
        this.hashFields.put("imdg_subs_rsk_lbl_cd3", "imdgSubsRskLblCd3");
        this.hashFields.put("imdg_subs_rsk_lbl_cd4", "imdgSubsRskLblCd4");
        this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
        this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("hzd_desc", "hzdDesc");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("meas_ut_cd", "measUtCd");
        this.hashFields.put("clod_flg", "clodFlg");
        this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
        this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
        this.hashFields.put("cgo_lcl_flg", "cgoLclFlg");
        this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
        this.hashFields.put("emer_rspn_gid_chr_no", "emerRspnGidChrNo");
        this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
        this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
        this.hashFields.put("emer_temp_ctnt", "emerTempCtnt");
        this.hashFields.put("ctrl_temp_ctnt", "ctrlTempCtnt");
        this.hashFields.put("ems_no", "emsNo");
        this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
        this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
        this.hashFields.put("psa_no", "psaNo");
        this.hashFields.put("certi_no", "certiNo");
        this.hashFields.put("in_imdg_pck_qty1", "inImdgPckQty1");
        this.hashFields.put("in_imdg_pck_cd1", "inImdgPckCd1");
        this.hashFields.put("in_imdg_pck_desc1", "inImdgPckDesc1");
        this.hashFields.put("in_imdg_pck_qty2", "inImdgPckQty2");
        this.hashFields.put("in_imdg_pck_cd2", "inImdgPckCd2");
        this.hashFields.put("in_imdg_pck_desc2", "inImdgPckDesc2");
        this.hashFields.put("intmd_imdg_pck_qty1", "intmdImdgPckQty1");
        this.hashFields.put("intmd_imdg_pck_cd1", "intmdImdgPckCd1");
        this.hashFields.put("intmd_imdg_pck_desc1", "intmdImdgPckDesc1");
        this.hashFields.put("intmd_imdg_pck_qty2", "intmdImdgPckQty2");
        this.hashFields.put("intmd_imdg_pck_cd2", "intmdImdgPckCd2");
        this.hashFields.put("intmd_imdg_pck_desc2", "intmdImdgPckDesc2");
        this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
        this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
        this.hashFields.put("out_imdg_pck_desc1", "outImdgPckDesc1");
        this.hashFields.put("out_imdg_pck_qty2", "outImdgPckQty2");
        this.hashFields.put("out_imdg_pck_cd2", "outImdgPckCd2");
        this.hashFields.put("out_imdg_pck_desc2", "outImdgPckDesc2");
        this.hashFields.put("max_in_pck_qty", "maxInPckQty");
        this.hashFields.put("max_in_pck_tp_cd", "maxInPckTpCd");
        this.hashFields.put("cnee_dtl_desc", "cneeDtlDesc");
        this.hashFields.put("net_explo_wgt", "netExploWgt");
        this.hashFields.put("rada_skd_no", "radaSkdNo");
        this.hashFields.put("rada_amt", "radaAmt");
        this.hashFields.put("rada_ut_cd", "radaUtCd");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("rc_seq", "rcSeq");
        this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
        this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
        this.hashFields.put("hcdg_flg", "hcdgFlg");
        this.hashFields.put("hcdg_dpnd_qty_flg", "hcdgDpndQtyFlg");
        this.hashFields.put("rqst_dt", "rqstDt");
        this.hashFields.put("rqst_gdt", "rqstGdt");
        this.hashFields.put("rqst_usr_id", "rqstUsrId");
        this.hashFields.put("aply_no", "aplyNo");
        this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
        this.hashFields.put("spcl_rqst_flg", "spclRqstFlg");
        this.hashFields.put("spcl_rqst_desc", "spclRqstDesc");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("rada_trsp_no", "radaTrspNo");
        this.hashFields.put("hzd_ctnt", "hzdCtnt");
        this.hashFields.put("stwg_temp_ctnt", "stwgTempCtnt");
        this.hashFields.put("grs_capa_qty", "grsCapaQty");
        this.hashFields.put("dcgo_rqst_grp_eml1", "dcgoRqstGrpEml1");
        this.hashFields.put("dcgo_rqst_grp_eml2", "dcgoRqstGrpEml2");
        this.hashFields.put("cfr_flg", "cfrFlg");
        this.hashFields.put("rsd_flg", "rsdFlg");
        this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("imdg_amdt_no", "imdgAmdtNo");
        this.hashFields.put("ttl_cntr_knt", "ttlCntrKnt");
        this.hashFields.put("cntr_dmy_ref_no", "cntrDmyRefNo");
        this.hashFields.put("imdg_n1st_segr_grp_no", "imdgN1stSegrGrpNo");
        this.hashFields.put("imdg_n2nd_segr_grp_no", "imdgN2ndSegrGrpNo");
        this.hashFields.put("imdg_n3rd_segr_grp_no", "imdgN3rdSegrGrpNo");
        this.hashFields.put("imdg_n4th_segr_grp_no", "imdgN4thSegrGrpNo");
        this.hashFields.put("imdg_segr_grp_nos", "imdgSegrGrpNos");
        this.hashFields.put("imdg_segr_grp_nm", "imdgSegrGrpNm");
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return dcgoSeq
	 */
    public String getDcgoSeq() {
        return this.dcgoSeq;
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
	 * @return cntrCgoSeq
	 */
    public String getCntrCgoSeq() {
        return this.cntrCgoSeq;
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
	 * @return cntrVolQty
	 */
    public String getCntrVolQty() {
        return this.cntrVolQty;
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
	 * @return cntrTpszIsoCd
	 */
    public String getCntrTpszIsoCd() {
        return this.cntrTpszIsoCd;
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
	 * @return imdgUnNoSeq
	 */
    public String getImdgUnNoSeq() {
        return this.imdgUnNoSeq;
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
	 * @return imdgCompGrpCd
	 */
    public String getImdgCompGrpCd() {
        return this.imdgCompGrpCd;
    }

    /**
	 * Column Info
	 * @return imdgSubsRskLblCd1
	 */
    public String getImdgSubsRskLblCd1() {
        return this.imdgSubsRskLblCd1;
    }

    /**
	 * Column Info
	 * @return imdgSubsRskLblCd2
	 */
    public String getImdgSubsRskLblCd2() {
        return this.imdgSubsRskLblCd2;
    }

    /**
	 * Column Info
	 * @return imdgSubsRskLblCd3
	 */
    public String getImdgSubsRskLblCd3() {
        return this.imdgSubsRskLblCd3;
    }

    /**
	 * Column Info
	 * @return imdgSubsRskLblCd4
	 */
    public String getImdgSubsRskLblCd4() {
        return this.imdgSubsRskLblCd4;
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
	 * @return imdgExptQtyFlg
	 */
    public String getImdgExptQtyFlg() {
        return this.imdgExptQtyFlg;
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
	 * @return grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
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
	 * @return flshPntCdoTemp
	 */
    public String getFlshPntCdoTemp() {
        return this.flshPntCdoTemp;
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
	 * @return hzdDesc
	 */
    public String getHzdDesc() {
        return this.hzdDesc;
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
	 * @return measUtCd
	 */
    public String getMeasUtCd() {
        return this.measUtCd;
    }

    /**
	 * Column Info
	 * @return clodFlg
	 */
    public String getClodFlg() {
        return this.clodFlg;
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
	 * @return dcgoStsCd
	 */
    public String getDcgoStsCd() {
        return this.dcgoStsCd;
    }

    /**
	 * Column Info
	 * @return cgoLclFlg
	 */
    public String getCgoLclFlg() {
        return this.cgoLclFlg;
    }

    /**
	 * Column Info
	 * @return emerRspnGidNo
	 */
    public String getEmerRspnGidNo() {
        return this.emerRspnGidNo;
    }

    /**
	 * Column Info
	 * @return emerRspnGidChrNo
	 */
    public String getEmerRspnGidChrNo() {
        return this.emerRspnGidChrNo;
    }

    /**
	 * Column Info
	 * @return emerCntcPhnNoCtnt
	 */
    public String getEmerCntcPhnNoCtnt() {
        return this.emerCntcPhnNoCtnt;
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
	 * @return emerTempCtnt
	 */
    public String getEmerTempCtnt() {
        return this.emerTempCtnt;
    }

    /**
	 * Column Info
	 * @return ctrlTempCtnt
	 */
    public String getCtrlTempCtnt() {
        return this.ctrlTempCtnt;
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
	 * @return imdgPckGrpCd
	 */
    public String getImdgPckGrpCd() {
        return this.imdgPckGrpCd;
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
	 * @return psaNo
	 */
    public String getPsaNo() {
        return this.psaNo;
    }

    /**
	 * Column Info
	 * @return certiNo
	 */
    public String getCertiNo() {
        return this.certiNo;
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
	 * @return inImdgPckCd1
	 */
    public String getInImdgPckCd1() {
        return this.inImdgPckCd1;
    }

    /**
	 * Column Info
	 * @return inImdgPckDesc1
	 */
    public String getInImdgPckDesc1() {
        return this.inImdgPckDesc1;
    }

    /**
	 * Column Info
	 * @return inImdgPckQty2
	 */
    public String getInImdgPckQty2() {
        return this.inImdgPckQty2;
    }

    /**
	 * Column Info
	 * @return inImdgPckCd2
	 */
    public String getInImdgPckCd2() {
        return this.inImdgPckCd2;
    }

    /**
	 * Column Info
	 * @return inImdgPckDesc2
	 */
    public String getInImdgPckDesc2() {
        return this.inImdgPckDesc2;
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
	 * @return intmdImdgPckCd1
	 */
    public String getIntmdImdgPckCd1() {
        return this.intmdImdgPckCd1;
    }

    /**
	 * Column Info
	 * @return intmdImdgPckDesc1
	 */
    public String getIntmdImdgPckDesc1() {
        return this.intmdImdgPckDesc1;
    }

    /**
	 * Column Info
	 * @return intmdImdgPckQty2
	 */
    public String getIntmdImdgPckQty2() {
        return this.intmdImdgPckQty2;
    }

    /**
	 * Column Info
	 * @return intmdImdgPckCd2
	 */
    public String getIntmdImdgPckCd2() {
        return this.intmdImdgPckCd2;
    }

    /**
	 * Column Info
	 * @return intmdImdgPckDesc2
	 */
    public String getIntmdImdgPckDesc2() {
        return this.intmdImdgPckDesc2;
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
	 * @return outImdgPckCd1
	 */
    public String getOutImdgPckCd1() {
        return this.outImdgPckCd1;
    }

    /**
	 * Column Info
	 * @return outImdgPckDesc1
	 */
    public String getOutImdgPckDesc1() {
        return this.outImdgPckDesc1;
    }

    /**
	 * Column Info
	 * @return outImdgPckQty2
	 */
    public String getOutImdgPckQty2() {
        return this.outImdgPckQty2;
    }

    /**
	 * Column Info
	 * @return outImdgPckCd2
	 */
    public String getOutImdgPckCd2() {
        return this.outImdgPckCd2;
    }

    /**
	 * Column Info
	 * @return outImdgPckDesc2
	 */
    public String getOutImdgPckDesc2() {
        return this.outImdgPckDesc2;
    }

    /**
	 * Column Info
	 * @return maxInPckQty
	 */
    public String getMaxInPckQty() {
        return this.maxInPckQty;
    }

    /**
	 * Column Info
	 * @return maxInPckTpCd
	 */
    public String getMaxInPckTpCd() {
        return this.maxInPckTpCd;
    }

    /**
	 * Column Info
	 * @return cneeDtlDesc
	 */
    public String getCneeDtlDesc() {
        return this.cneeDtlDesc;
    }

    /**
	 * Column Info
	 * @return netExploWgt
	 */
    public String getNetExploWgt() {
        return this.netExploWgt;
    }

    /**
	 * Column Info
	 * @return radaSkdNo
	 */
    public String getRadaSkdNo() {
        return this.radaSkdNo;
    }

    /**
	 * Column Info
	 * @return radaAmt
	 */
    public String getRadaAmt() {
        return this.radaAmt;
    }

    /**
	 * Column Info
	 * @return radaUtCd
	 */
    public String getRadaUtCd() {
        return this.radaUtCd;
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
	 * @return awkCgoFlg
	 */
    public String getAwkCgoFlg() {
        return this.awkCgoFlg;
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
	 * @return rcSeq
	 */
    public String getRcSeq() {
        return this.rcSeq;
    }

    /**
	 * Column Info
	 * @return awkCgoSeq
	 */
    public String getAwkCgoSeq() {
        return this.awkCgoSeq;
    }

    /**
	 * Column Info
	 * @return bbCgoSeq
	 */
    public String getBbCgoSeq() {
        return this.bbCgoSeq;
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
	 * @return hcdgDpndQtyFlg
	 */
    public String getHcdgDpndQtyFlg() {
        return this.hcdgDpndQtyFlg;
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
	 * @return rqstGdt
	 */
    public String getRqstGdt() {
        return this.rqstGdt;
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
	 * @return aplyNo
	 */
    public String getAplyNo() {
        return this.aplyNo;
    }

    /**
	 * Column Info
	 * @return spclCgoAproCd
	 */
    public String getSpclCgoAproCd() {
        return this.spclCgoAproCd;
    }

    /**
	 * Column Info
	 * @return spclRqstFlg
	 */
    public String getSpclRqstFlg() {
        return this.spclRqstFlg;
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
	 * @return diffRmk
	 */
    public String getDiffRmk() {
        return this.diffRmk;
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
	 * @return radaTrspNo
	 */
    public String getRadaTrspNo() {
        return this.radaTrspNo;
    }

    /**
	 * Column Info
	 * @return hzdCtnt
	 */
    public String getHzdCtnt() {
        return this.hzdCtnt;
    }

    /**
	 * Column Info
	 * @return stwgTempCtnt
	 */
    public String getStwgTempCtnt() {
        return this.stwgTempCtnt;
    }

    /**
	 * Column Info
	 * @return grsCapaQty
	 */
    public String getGrsCapaQty() {
        return this.grsCapaQty;
    }

    /**
	 * Column Info
	 * @return dcgoRqstGrpEml1
	 */
    public String getDcgoRqstGrpEml1() {
        return this.dcgoRqstGrpEml1;
    }

    /**
	 * Column Info
	 * @return dcgoRqstGrpEml2
	 */
    public String getDcgoRqstGrpEml2() {
        return this.dcgoRqstGrpEml2;
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
	 * @return rsdFlg
	 */
    public String getRsdFlg() {
        return this.rsdFlg;
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
	 * @param  bkgNo
 	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param  dcgoSeq
 	 */
    public void setDcgoSeq(String dcgoSeq) {
        this.dcgoSeq = dcgoSeq;
    }

    /**
	 * Column Info
	 * @param  dgCntrSeq
 	 */
    public void setDgCntrSeq(String dgCntrSeq) {
        this.dgCntrSeq = dgCntrSeq;
    }

    /**
	 * Column Info
	 * @param  cntrCgoSeq
 	 */
    public void setCntrCgoSeq(String cntrCgoSeq) {
        this.cntrCgoSeq = cntrCgoSeq;
    }

    /**
	 * Column Info
	 * @param  cntrNo
 	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param  cntrVolQty
 	 */
    public void setCntrVolQty(String cntrVolQty) {
        this.cntrVolQty = cntrVolQty;
    }

    /**
	 * Column Info
	 * @param  cntrTpszCd
 	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

    /**
	 * Column Info
	 * @param  cntrTpszIsoCd
 	 */
    public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
        this.cntrTpszIsoCd = cntrTpszIsoCd;
    }

    /**
	 * Column Info
	 * @param  imdgUnNo
 	 */
    public void setImdgUnNo(String imdgUnNo) {
        this.imdgUnNo = imdgUnNo;
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
	 * @param  imdgClssCd
 	 */
    public void setImdgClssCd(String imdgClssCd) {
        this.imdgClssCd = imdgClssCd;
    }

    /**
	 * Column Info
	 * @param  imdgCompGrpCd
 	 */
    public void setImdgCompGrpCd(String imdgCompGrpCd) {
        this.imdgCompGrpCd = imdgCompGrpCd;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblCd1
 	 */
    public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
        this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblCd2
 	 */
    public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
        this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblCd3
 	 */
    public void setImdgSubsRskLblCd3(String imdgSubsRskLblCd3) {
        this.imdgSubsRskLblCd3 = imdgSubsRskLblCd3;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblCd4
 	 */
    public void setImdgSubsRskLblCd4(String imdgSubsRskLblCd4) {
        this.imdgSubsRskLblCd4 = imdgSubsRskLblCd4;
    }

    /**
	 * Column Info
	 * @param  imdgLmtQtyFlg
 	 */
    public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
    }

    /**
	 * Column Info
	 * @param  imdgExptQtyFlg
 	 */
    public void setImdgExptQtyFlg(String imdgExptQtyFlg) {
        this.imdgExptQtyFlg = imdgExptQtyFlg;
    }

    /**
	 * Column Info
	 * @param  netWgt
 	 */
    public void setNetWgt(String netWgt) {
        this.netWgt = netWgt;
    }

    /**
	 * Column Info
	 * @param  grsWgt
 	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * Column Info
	 * @param  wgtUtCd
 	 */
    public void setWgtUtCd(String wgtUtCd) {
        this.wgtUtCd = wgtUtCd;
    }

    /**
	 * Column Info
	 * @param  flshPntCdoTemp
 	 */
    public void setFlshPntCdoTemp(String flshPntCdoTemp) {
        this.flshPntCdoTemp = flshPntCdoTemp;
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
	 * @param  hzdDesc
 	 */
    public void setHzdDesc(String hzdDesc) {
        this.hzdDesc = hzdDesc;
    }

    /**
	 * Column Info
	 * @param  measQty
 	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * Column Info
	 * @param  measUtCd
 	 */
    public void setMeasUtCd(String measUtCd) {
        this.measUtCd = measUtCd;
    }

    /**
	 * Column Info
	 * @param  clodFlg
 	 */
    public void setClodFlg(String clodFlg) {
        this.clodFlg = clodFlg;
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
	 * @param  dcgoStsCd
 	 */
    public void setDcgoStsCd(String dcgoStsCd) {
        this.dcgoStsCd = dcgoStsCd;
    }

    /**
	 * Column Info
	 * @param  cgoLclFlg
 	 */
    public void setCgoLclFlg(String cgoLclFlg) {
        this.cgoLclFlg = cgoLclFlg;
    }

    /**
	 * Column Info
	 * @param  emerRspnGidNo
 	 */
    public void setEmerRspnGidNo(String emerRspnGidNo) {
        this.emerRspnGidNo = emerRspnGidNo;
    }

    /**
	 * Column Info
	 * @param  emerRspnGidChrNo
 	 */
    public void setEmerRspnGidChrNo(String emerRspnGidChrNo) {
        this.emerRspnGidChrNo = emerRspnGidChrNo;
    }

    /**
	 * Column Info
	 * @param  emerCntcPhnNoCtnt
 	 */
    public void setEmerCntcPhnNoCtnt(String emerCntcPhnNoCtnt) {
        this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
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
	 * @param  emerTempCtnt
 	 */
    public void setEmerTempCtnt(String emerTempCtnt) {
        this.emerTempCtnt = emerTempCtnt;
    }

    /**
	 * Column Info
	 * @param  ctrlTempCtnt
 	 */
    public void setCtrlTempCtnt(String ctrlTempCtnt) {
        this.ctrlTempCtnt = ctrlTempCtnt;
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
	 * @param  imdgPckGrpCd
 	 */
    public void setImdgPckGrpCd(String imdgPckGrpCd) {
        this.imdgPckGrpCd = imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @param  mrnPolutFlg
 	 */
    public void setMrnPolutFlg(String mrnPolutFlg) {
        this.mrnPolutFlg = mrnPolutFlg;
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
	 * @param  certiNo
 	 */
    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    /**
	 * Column Info
	 * @param  inImdgPckQty1
 	 */
    public void setInImdgPckQty1(String inImdgPckQty1) {
        this.inImdgPckQty1 = inImdgPckQty1;
    }

    /**
	 * Column Info
	 * @param  inImdgPckCd1
 	 */
    public void setInImdgPckCd1(String inImdgPckCd1) {
        this.inImdgPckCd1 = inImdgPckCd1;
    }

    /**
	 * Column Info
	 * @param  inImdgPckDesc1
 	 */
    public void setInImdgPckDesc1(String inImdgPckDesc1) {
        this.inImdgPckDesc1 = inImdgPckDesc1;
    }

    /**
	 * Column Info
	 * @param  inImdgPckQty2
 	 */
    public void setInImdgPckQty2(String inImdgPckQty2) {
        this.inImdgPckQty2 = inImdgPckQty2;
    }

    /**
	 * Column Info
	 * @param  inImdgPckCd2
 	 */
    public void setInImdgPckCd2(String inImdgPckCd2) {
        this.inImdgPckCd2 = inImdgPckCd2;
    }

    /**
	 * Column Info
	 * @param  inImdgPckDesc2
 	 */
    public void setInImdgPckDesc2(String inImdgPckDesc2) {
        this.inImdgPckDesc2 = inImdgPckDesc2;
    }

    /**
	 * Column Info
	 * @param  intmdImdgPckQty1
 	 */
    public void setIntmdImdgPckQty1(String intmdImdgPckQty1) {
        this.intmdImdgPckQty1 = intmdImdgPckQty1;
    }

    /**
	 * Column Info
	 * @param  intmdImdgPckCd1
 	 */
    public void setIntmdImdgPckCd1(String intmdImdgPckCd1) {
        this.intmdImdgPckCd1 = intmdImdgPckCd1;
    }

    /**
	 * Column Info
	 * @param  intmdImdgPckDesc1
 	 */
    public void setIntmdImdgPckDesc1(String intmdImdgPckDesc1) {
        this.intmdImdgPckDesc1 = intmdImdgPckDesc1;
    }

    /**
	 * Column Info
	 * @param  intmdImdgPckQty2
 	 */
    public void setIntmdImdgPckQty2(String intmdImdgPckQty2) {
        this.intmdImdgPckQty2 = intmdImdgPckQty2;
    }

    /**
	 * Column Info
	 * @param  intmdImdgPckCd2
 	 */
    public void setIntmdImdgPckCd2(String intmdImdgPckCd2) {
        this.intmdImdgPckCd2 = intmdImdgPckCd2;
    }

    /**
	 * Column Info
	 * @param  intmdImdgPckDesc2
 	 */
    public void setIntmdImdgPckDesc2(String intmdImdgPckDesc2) {
        this.intmdImdgPckDesc2 = intmdImdgPckDesc2;
    }

    /**
	 * Column Info
	 * @param  outImdgPckQty1
 	 */
    public void setOutImdgPckQty1(String outImdgPckQty1) {
        this.outImdgPckQty1 = outImdgPckQty1;
    }

    /**
	 * Column Info
	 * @param  outImdgPckCd1
 	 */
    public void setOutImdgPckCd1(String outImdgPckCd1) {
        this.outImdgPckCd1 = outImdgPckCd1;
    }

    /**
	 * Column Info
	 * @param  outImdgPckDesc1
 	 */
    public void setOutImdgPckDesc1(String outImdgPckDesc1) {
        this.outImdgPckDesc1 = outImdgPckDesc1;
    }

    /**
	 * Column Info
	 * @param  outImdgPckQty2
 	 */
    public void setOutImdgPckQty2(String outImdgPckQty2) {
        this.outImdgPckQty2 = outImdgPckQty2;
    }

    /**
	 * Column Info
	 * @param  outImdgPckCd2
 	 */
    public void setOutImdgPckCd2(String outImdgPckCd2) {
        this.outImdgPckCd2 = outImdgPckCd2;
    }

    /**
	 * Column Info
	 * @param  outImdgPckDesc2
 	 */
    public void setOutImdgPckDesc2(String outImdgPckDesc2) {
        this.outImdgPckDesc2 = outImdgPckDesc2;
    }

    /**
	 * Column Info
	 * @param  maxInPckQty
 	 */
    public void setMaxInPckQty(String maxInPckQty) {
        this.maxInPckQty = maxInPckQty;
    }

    /**
	 * Column Info
	 * @param  maxInPckTpCd
 	 */
    public void setMaxInPckTpCd(String maxInPckTpCd) {
        this.maxInPckTpCd = maxInPckTpCd;
    }

    /**
	 * Column Info
	 * @param  cneeDtlDesc
 	 */
    public void setCneeDtlDesc(String cneeDtlDesc) {
        this.cneeDtlDesc = cneeDtlDesc;
    }

    /**
	 * Column Info
	 * @param  netExploWgt
 	 */
    public void setNetExploWgt(String netExploWgt) {
        this.netExploWgt = netExploWgt;
    }

    /**
	 * Column Info
	 * @param  radaSkdNo
 	 */
    public void setRadaSkdNo(String radaSkdNo) {
        this.radaSkdNo = radaSkdNo;
    }

    /**
	 * Column Info
	 * @param  radaAmt
 	 */
    public void setRadaAmt(String radaAmt) {
        this.radaAmt = radaAmt;
    }

    /**
	 * Column Info
	 * @param  radaUtCd
 	 */
    public void setRadaUtCd(String radaUtCd) {
        this.radaUtCd = radaUtCd;
    }

    /**
	 * Column Info
	 * @param  rcFlg
 	 */
    public void setRcFlg(String rcFlg) {
        this.rcFlg = rcFlg;
    }

    /**
	 * Column Info
	 * @param  awkCgoFlg
 	 */
    public void setAwkCgoFlg(String awkCgoFlg) {
        this.awkCgoFlg = awkCgoFlg;
    }

    /**
	 * Column Info
	 * @param  bbCgoFlg
 	 */
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
    }

    /**
	 * Column Info
	 * @param  rcSeq
 	 */
    public void setRcSeq(String rcSeq) {
        this.rcSeq = rcSeq;
    }

    /**
	 * Column Info
	 * @param  awkCgoSeq
 	 */
    public void setAwkCgoSeq(String awkCgoSeq) {
        this.awkCgoSeq = awkCgoSeq;
    }

    /**
	 * Column Info
	 * @param  bbCgoSeq
 	 */
    public void setBbCgoSeq(String bbCgoSeq) {
        this.bbCgoSeq = bbCgoSeq;
    }

    /**
	 * Column Info
	 * @param  hcdgFlg
 	 */
    public void setHcdgFlg(String hcdgFlg) {
        this.hcdgFlg = hcdgFlg;
    }

    /**
	 * Column Info
	 * @param  hcdgDpndQtyFlg
 	 */
    public void setHcdgDpndQtyFlg(String hcdgDpndQtyFlg) {
        this.hcdgDpndQtyFlg = hcdgDpndQtyFlg;
    }

    /**
	 * Column Info
	 * @param  rqstDt
 	 */
    public void setRqstDt(String rqstDt) {
        this.rqstDt = rqstDt;
    }

    /**
	 * Column Info
	 * @param  rqstGdt
 	 */
    public void setRqstGdt(String rqstGdt) {
        this.rqstGdt = rqstGdt;
    }

    /**
	 * Column Info
	 * @param  rqstUsrId
 	 */
    public void setRqstUsrId(String rqstUsrId) {
        this.rqstUsrId = rqstUsrId;
    }

    /**
	 * Column Info
	 * @param  aplyNo
 	 */
    public void setAplyNo(String aplyNo) {
        this.aplyNo = aplyNo;
    }

    /**
	 * Column Info
	 * @param  spclCgoAproCd
 	 */
    public void setSpclCgoAproCd(String spclCgoAproCd) {
        this.spclCgoAproCd = spclCgoAproCd;
    }

    /**
	 * Column Info
	 * @param  spclRqstFlg
 	 */
    public void setSpclRqstFlg(String spclRqstFlg) {
        this.spclRqstFlg = spclRqstFlg;
    }

    /**
	 * Column Info
	 * @param  spclRqstDesc
 	 */
    public void setSpclRqstDesc(String spclRqstDesc) {
        this.spclRqstDesc = spclRqstDesc;
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

    /**
	 * Column Info
	 * @param  radaTrspNo
 	 */
    public void setRadaTrspNo(String radaTrspNo) {
        this.radaTrspNo = radaTrspNo;
    }

    /**
	 * Column Info
	 * @param  hzdCtnt
 	 */
    public void setHzdCtnt(String hzdCtnt) {
        this.hzdCtnt = hzdCtnt;
    }

    /**
	 * Column Info
	 * @param  stwgTempCtnt
 	 */
    public void setStwgTempCtnt(String stwgTempCtnt) {
        this.stwgTempCtnt = stwgTempCtnt;
    }

    /**
	 * Column Info
	 * @param  grsCapaQty
 	 */
    public void setGrsCapaQty(String grsCapaQty) {
        this.grsCapaQty = grsCapaQty;
    }

    /**
	 * Column Info
	 * @param  dcgoRqstGrpEml1
 	 */
    public void setDcgoRqstGrpEml1(String dcgoRqstGrpEml1) {
        this.dcgoRqstGrpEml1 = dcgoRqstGrpEml1;
    }

    /**
	 * Column Info
	 * @param  dcgoRqstGrpEml2
 	 */
    public void setDcgoRqstGrpEml2(String dcgoRqstGrpEml2) {
        this.dcgoRqstGrpEml2 = dcgoRqstGrpEml2;
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
	 * @param  rsdFlg
 	 */
    public void setRsdFlg(String rsdFlg) {
        this.rsdFlg = rsdFlg;
    }

    /**
	 * Column Info
	 * @param  imdgSegrGrpNo
 	 */
    public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
        this.imdgSegrGrpNo = imdgSegrGrpNo;
    }

    public void setImdgAmdtNo(String imdgAmdtNo) {
        this.imdgAmdtNo = imdgAmdtNo;
    }

    public String getImdgAmdtNo() {
        return this.imdgAmdtNo;
    }

    public void setTtlCntrKnt(String ttlCntrKnt) {
        this.ttlCntrKnt = ttlCntrKnt;
    }

    public String getTtlCntrKnt() {
        return this.ttlCntrKnt;
    }

    public void setCntrDmyRefNo(String cntrDmyRefNo) {
        this.cntrDmyRefNo = cntrDmyRefNo;
    }

    public String getCntrDmyRefNo() {
        return this.cntrDmyRefNo;
    }

    public void setImdgN1stSegrGrpNo(String imdgN1stSegrGrpNo) {
        this.imdgN1stSegrGrpNo = imdgN1stSegrGrpNo;
    }

    public String getImdgN1stSegrGrpNo() {
        return this.imdgN1stSegrGrpNo;
    }

    public void setImdgN2ndSegrGrpNo(String imdgN2ndSegrGrpNo) {
        this.imdgN2ndSegrGrpNo = imdgN2ndSegrGrpNo;
    }

    public String getImdgN2ndSegrGrpNo() {
        return this.imdgN2ndSegrGrpNo;
    }

    public void setImdgN3rdSegrGrpNo(String imdgN3rdSegrGrpNo) {
        this.imdgN3rdSegrGrpNo = imdgN3rdSegrGrpNo;
    }

    public String getImdgN3rdSegrGrpNo() {
        return this.imdgN3rdSegrGrpNo;
    }

    public void setImdgN4thSegrGrpNo(String imdgN4thSegrGrpNo) {
        this.imdgN4thSegrGrpNo = imdgN4thSegrGrpNo;
    }

    public String getImdgN4thSegrGrpNo() {
        return this.imdgN4thSegrGrpNo;
    }

    public void setImdgSegrGrpNos(String imdgSegrGrpNos) {
        this.imdgSegrGrpNos = imdgSegrGrpNos;
    }

    public String getImdgSegrGrpNos() {
        return this.imdgSegrGrpNos;
    }

    public void setImdgSegrGrpNm(String imdgSegrGrpNm) {
        this.imdgSegrGrpNm = imdgSegrGrpNm;
    }

    public String getImdgSegrGrpNm() {
        return this.imdgSegrGrpNm;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
        setDgCntrSeq(JSPUtil.getParameter(request, prefix + "dg_cntr_seq", ""));
        setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
        setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
        setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
        setImdgSubsRskLblCd3(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", ""));
        setImdgSubsRskLblCd4(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", ""));
        setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
        setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
        setClodFlg(JSPUtil.getParameter(request, prefix + "clod_flg", ""));
        setSpclStwgRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", ""));
        setDcgoStsCd(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", ""));
        setCgoLclFlg(JSPUtil.getParameter(request, prefix + "cgo_lcl_flg", ""));
        setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
        setEmerRspnGidChrNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_chr_no", ""));
        setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", ""));
        setEmerCntcPsonNm(JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", ""));
        setEmerTempCtnt(JSPUtil.getParameter(request, prefix + "emer_temp_ctnt", ""));
        setCtrlTempCtnt(JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", ""));
        setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
        setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
        setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
        setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
        setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
        setInImdgPckQty1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", ""));
        setInImdgPckCd1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", ""));
        setInImdgPckDesc1(JSPUtil.getParameter(request, prefix + "in_imdg_pck_desc1", ""));
        setInImdgPckQty2(JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty2", ""));
        setInImdgPckCd2(JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd2", ""));
        setInImdgPckDesc2(JSPUtil.getParameter(request, prefix + "in_imdg_pck_desc2", ""));
        setIntmdImdgPckQty1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", ""));
        setIntmdImdgPckCd1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd1", ""));
        setIntmdImdgPckDesc1(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_desc1", ""));
        setIntmdImdgPckQty2(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty2", ""));
        setIntmdImdgPckCd2(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd2", ""));
        setIntmdImdgPckDesc2(JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_desc2", ""));
        setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
        setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
        setOutImdgPckDesc1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_desc1", ""));
        setOutImdgPckQty2(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty2", ""));
        setOutImdgPckCd2(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd2", ""));
        setOutImdgPckDesc2(JSPUtil.getParameter(request, prefix + "out_imdg_pck_desc2", ""));
        setMaxInPckQty(JSPUtil.getParameter(request, prefix + "max_in_pck_qty", ""));
        setMaxInPckTpCd(JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", ""));
        setCneeDtlDesc(JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", ""));
        setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
        setRadaSkdNo(JSPUtil.getParameter(request, prefix + "rada_skd_no", ""));
        setRadaAmt(JSPUtil.getParameter(request, prefix + "rada_amt", ""));
        setRadaUtCd(JSPUtil.getParameter(request, prefix + "rada_ut_cd", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setRcSeq(JSPUtil.getParameter(request, prefix + "rc_seq", ""));
        setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
        setBbCgoSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_seq", ""));
        setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
        setHcdgDpndQtyFlg(JSPUtil.getParameter(request, prefix + "hcdg_dpnd_qty_flg", ""));
        setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
        setRqstGdt(JSPUtil.getParameter(request, prefix + "rqst_gdt", ""));
        setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
        setAplyNo(JSPUtil.getParameter(request, prefix + "aply_no", ""));
        setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
        setSpclRqstFlg(JSPUtil.getParameter(request, prefix + "spcl_rqst_flg", ""));
        setSpclRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setRadaTrspNo(JSPUtil.getParameter(request, prefix + "rada_trsp_no", ""));
        setHzdCtnt(JSPUtil.getParameter(request, prefix + "hzd_ctnt", ""));
        setStwgTempCtnt(JSPUtil.getParameter(request, prefix + "stwg_temp_ctnt", ""));
        setGrsCapaQty(JSPUtil.getParameter(request, prefix + "grs_capa_qty", ""));
        setDcgoRqstGrpEml1(JSPUtil.getParameter(request, prefix + "dcgo_rqst_grp_eml1", ""));
        setDcgoRqstGrpEml2(JSPUtil.getParameter(request, prefix + "dcgo_rqst_grp_eml2", ""));
        setCfrFlg(JSPUtil.getParameter(request, prefix + "cfr_flg", ""));
        setRsdFlg(JSPUtil.getParameter(request, prefix + "rsd_flg", ""));
        setImdgSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", ""));
        setImdgAmdtNo(JSPUtil.getParameter(request, prefix + "imdg_amdt_no", ""));
        setTtlCntrKnt(JSPUtil.getParameter(request, prefix + "ttl_cntr_knt", ""));
        setCntrDmyRefNo(JSPUtil.getParameter(request, prefix + "cntr_dmy_ref_no", ""));
        setImdgN1stSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_n1st_segr_grp_no", ""));
        setImdgN2ndSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_n2nd_segr_grp_no", ""));
        setImdgN3rdSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_n3rd_segr_grp_no", ""));
        setImdgN4thSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_n4th_segr_grp_no", ""));
        setImdgSegrGrpNos(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nos", ""));
        setImdgSegrGrpNm(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendEdiFromBkgDtlVO[]
	 */
    public SendEdiFromBkgDtlVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendEdiFromBkgDtlVO[]
	 */
    public SendEdiFromBkgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SendEdiFromBkgDtlVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] dcgoSeq = (JSPUtil.getParameter(request, prefix + "dcgo_seq", length));
            String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix + "dg_cntr_seq", length));
            String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] cntrVolQty = (JSPUtil.getParameter(request, prefix + "cntr_vol_qty", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", length));
            String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", length));
            String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", length));
            String[] imdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd3", length));
            String[] imdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd4", length));
            String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", length));
            String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] hzdDesc = (JSPUtil.getParameter(request, prefix + "hzd_desc", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] measUtCd = (JSPUtil.getParameter(request, prefix + "meas_ut_cd", length));
            String[] clodFlg = (JSPUtil.getParameter(request, prefix + "clod_flg", length));
            String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", length));
            String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", length));
            String[] cgoLclFlg = (JSPUtil.getParameter(request, prefix + "cgo_lcl_flg", length));
            String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", length));
            String[] emerRspnGidChrNo = (JSPUtil.getParameter(request, prefix + "emer_rspn_gid_chr_no", length));
            String[] emerCntcPhnNoCtnt = (JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", length));
            String[] emerCntcPsonNm = (JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", length));
            String[] emerTempCtnt = (JSPUtil.getParameter(request, prefix + "emer_temp_ctnt", length));
            String[] ctrlTempCtnt = (JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", length));
            String[] emsNo = (JSPUtil.getParameter(request, prefix + "ems_no", length));
            String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", length));
            String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix + "mrn_polut_flg", length));
            String[] psaNo = (JSPUtil.getParameter(request, prefix + "psa_no", length));
            String[] certiNo = (JSPUtil.getParameter(request, prefix + "certi_no", length));
            String[] inImdgPckQty1 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty1", length));
            String[] inImdgPckCd1 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd1", length));
            String[] inImdgPckDesc1 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_desc1", length));
            String[] inImdgPckQty2 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_qty2", length));
            String[] inImdgPckCd2 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_cd2", length));
            String[] inImdgPckDesc2 = (JSPUtil.getParameter(request, prefix + "in_imdg_pck_desc2", length));
            String[] intmdImdgPckQty1 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty1", length));
            String[] intmdImdgPckCd1 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd1", length));
            String[] intmdImdgPckDesc1 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_desc1", length));
            String[] intmdImdgPckQty2 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_qty2", length));
            String[] intmdImdgPckCd2 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_cd2", length));
            String[] intmdImdgPckDesc2 = (JSPUtil.getParameter(request, prefix + "intmd_imdg_pck_desc2", length));
            String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", length));
            String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", length));
            String[] outImdgPckDesc1 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_desc1", length));
            String[] outImdgPckQty2 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty2", length));
            String[] outImdgPckCd2 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd2", length));
            String[] outImdgPckDesc2 = (JSPUtil.getParameter(request, prefix + "out_imdg_pck_desc2", length));
            String[] maxInPckQty = (JSPUtil.getParameter(request, prefix + "max_in_pck_qty", length));
            String[] maxInPckTpCd = (JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", length));
            String[] cneeDtlDesc = (JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", length));
            String[] netExploWgt = (JSPUtil.getParameter(request, prefix + "net_explo_wgt", length));
            String[] radaSkdNo = (JSPUtil.getParameter(request, prefix + "rada_skd_no", length));
            String[] radaAmt = (JSPUtil.getParameter(request, prefix + "rada_amt", length));
            String[] radaUtCd = (JSPUtil.getParameter(request, prefix + "rada_ut_cd", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] rcSeq = (JSPUtil.getParameter(request, prefix + "rc_seq", length));
            String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix + "awk_cgo_seq", length));
            String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix + "bb_cgo_seq", length));
            String[] hcdgFlg = (JSPUtil.getParameter(request, prefix + "hcdg_flg", length));
            String[] hcdgDpndQtyFlg = (JSPUtil.getParameter(request, prefix + "hcdg_dpnd_qty_flg", length));
            String[] rqstDt = (JSPUtil.getParameter(request, prefix + "rqst_dt", length));
            String[] rqstGdt = (JSPUtil.getParameter(request, prefix + "rqst_gdt", length));
            String[] rqstUsrId = (JSPUtil.getParameter(request, prefix + "rqst_usr_id", length));
            String[] aplyNo = (JSPUtil.getParameter(request, prefix + "aply_no", length));
            String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", length));
            String[] spclRqstFlg = (JSPUtil.getParameter(request, prefix + "spcl_rqst_flg", length));
            String[] spclRqstDesc = (JSPUtil.getParameter(request, prefix + "spcl_rqst_desc", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] radaTrspNo = (JSPUtil.getParameter(request, prefix + "rada_trsp_no", length));
            String[] hzdCtnt = (JSPUtil.getParameter(request, prefix + "hzd_ctnt", length));
            String[] stwgTempCtnt = (JSPUtil.getParameter(request, prefix + "stwg_temp_ctnt", length));
            String[] grsCapaQty = (JSPUtil.getParameter(request, prefix + "grs_capa_qty", length));
            String[] dcgoRqstGrpEml1 = (JSPUtil.getParameter(request, prefix + "dcgo_rqst_grp_eml1", length));
            String[] dcgoRqstGrpEml2 = (JSPUtil.getParameter(request, prefix + "dcgo_rqst_grp_eml2", length));
            String[] cfrFlg = (JSPUtil.getParameter(request, prefix + "cfr_flg", length));
            String[] rsdFlg = (JSPUtil.getParameter(request, prefix + "rsd_flg", length));
            String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", length));
            String[] imdgAmdtNo = (JSPUtil.getParameter(request, prefix + "imdg_amdt_no", length));
            String[] ttlCntrKnt = (JSPUtil.getParameter(request, prefix + "ttl_cntr_knt", length));
            String[] cntrDmyRefNo = (JSPUtil.getParameter(request, prefix + "cntr_dmy_ref_no", length));
            String[] imdgN1stSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_n1st_segr_grp_no", length));
            String[] imdgN2ndSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_n2nd_segr_grp_no", length));
            String[] imdgN3rdSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_n3rd_segr_grp_no", length));
            String[] imdgN4thSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_n4th_segr_grp_no", length));
            String[] imdgSegrGrpNos = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nos", length));
            String[] imdgSegrGrpNm = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new SendEdiFromBkgDtlVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (dgCntrSeq[i] != null)
                    model.setDgCntrSeq(dgCntrSeq[i]);
                if (cntrCgoSeq[i] != null)
                    model.setCntrCgoSeq(cntrCgoSeq[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (cntrVolQty[i] != null)
                    model.setCntrVolQty(cntrVolQty[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (cntrTpszIsoCd[i] != null)
                    model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (imdgCompGrpCd[i] != null)
                    model.setImdgCompGrpCd(imdgCompGrpCd[i]);
                if (imdgSubsRskLblCd1[i] != null)
                    model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
                if (imdgSubsRskLblCd2[i] != null)
                    model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
                if (imdgSubsRskLblCd3[i] != null)
                    model.setImdgSubsRskLblCd3(imdgSubsRskLblCd3[i]);
                if (imdgSubsRskLblCd4[i] != null)
                    model.setImdgSubsRskLblCd4(imdgSubsRskLblCd4[i]);
                if (imdgLmtQtyFlg[i] != null)
                    model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
                if (imdgExptQtyFlg[i] != null)
                    model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (flshPntCdoTemp[i] != null)
                    model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (hzdDesc[i] != null)
                    model.setHzdDesc(hzdDesc[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (measUtCd[i] != null)
                    model.setMeasUtCd(measUtCd[i]);
                if (clodFlg[i] != null)
                    model.setClodFlg(clodFlg[i]);
                if (spclStwgRqstDesc[i] != null)
                    model.setSpclStwgRqstDesc(spclStwgRqstDesc[i]);
                if (dcgoStsCd[i] != null)
                    model.setDcgoStsCd(dcgoStsCd[i]);
                if (cgoLclFlg[i] != null)
                    model.setCgoLclFlg(cgoLclFlg[i]);
                if (emerRspnGidNo[i] != null)
                    model.setEmerRspnGidNo(emerRspnGidNo[i]);
                if (emerRspnGidChrNo[i] != null)
                    model.setEmerRspnGidChrNo(emerRspnGidChrNo[i]);
                if (emerCntcPhnNoCtnt[i] != null)
                    model.setEmerCntcPhnNoCtnt(emerCntcPhnNoCtnt[i]);
                if (emerCntcPsonNm[i] != null)
                    model.setEmerCntcPsonNm(emerCntcPsonNm[i]);
                if (emerTempCtnt[i] != null)
                    model.setEmerTempCtnt(emerTempCtnt[i]);
                if (ctrlTempCtnt[i] != null)
                    model.setCtrlTempCtnt(ctrlTempCtnt[i]);
                if (emsNo[i] != null)
                    model.setEmsNo(emsNo[i]);
                if (imdgPckGrpCd[i] != null)
                    model.setImdgPckGrpCd(imdgPckGrpCd[i]);
                if (mrnPolutFlg[i] != null)
                    model.setMrnPolutFlg(mrnPolutFlg[i]);
                if (psaNo[i] != null)
                    model.setPsaNo(psaNo[i]);
                if (certiNo[i] != null)
                    model.setCertiNo(certiNo[i]);
                if (inImdgPckQty1[i] != null)
                    model.setInImdgPckQty1(inImdgPckQty1[i]);
                if (inImdgPckCd1[i] != null)
                    model.setInImdgPckCd1(inImdgPckCd1[i]);
                if (inImdgPckDesc1[i] != null)
                    model.setInImdgPckDesc1(inImdgPckDesc1[i]);
                if (inImdgPckQty2[i] != null)
                    model.setInImdgPckQty2(inImdgPckQty2[i]);
                if (inImdgPckCd2[i] != null)
                    model.setInImdgPckCd2(inImdgPckCd2[i]);
                if (inImdgPckDesc2[i] != null)
                    model.setInImdgPckDesc2(inImdgPckDesc2[i]);
                if (intmdImdgPckQty1[i] != null)
                    model.setIntmdImdgPckQty1(intmdImdgPckQty1[i]);
                if (intmdImdgPckCd1[i] != null)
                    model.setIntmdImdgPckCd1(intmdImdgPckCd1[i]);
                if (intmdImdgPckDesc1[i] != null)
                    model.setIntmdImdgPckDesc1(intmdImdgPckDesc1[i]);
                if (intmdImdgPckQty2[i] != null)
                    model.setIntmdImdgPckQty2(intmdImdgPckQty2[i]);
                if (intmdImdgPckCd2[i] != null)
                    model.setIntmdImdgPckCd2(intmdImdgPckCd2[i]);
                if (intmdImdgPckDesc2[i] != null)
                    model.setIntmdImdgPckDesc2(intmdImdgPckDesc2[i]);
                if (outImdgPckQty1[i] != null)
                    model.setOutImdgPckQty1(outImdgPckQty1[i]);
                if (outImdgPckCd1[i] != null)
                    model.setOutImdgPckCd1(outImdgPckCd1[i]);
                if (outImdgPckDesc1[i] != null)
                    model.setOutImdgPckDesc1(outImdgPckDesc1[i]);
                if (outImdgPckQty2[i] != null)
                    model.setOutImdgPckQty2(outImdgPckQty2[i]);
                if (outImdgPckCd2[i] != null)
                    model.setOutImdgPckCd2(outImdgPckCd2[i]);
                if (outImdgPckDesc2[i] != null)
                    model.setOutImdgPckDesc2(outImdgPckDesc2[i]);
                if (maxInPckQty[i] != null)
                    model.setMaxInPckQty(maxInPckQty[i]);
                if (maxInPckTpCd[i] != null)
                    model.setMaxInPckTpCd(maxInPckTpCd[i]);
                if (cneeDtlDesc[i] != null)
                    model.setCneeDtlDesc(cneeDtlDesc[i]);
                if (netExploWgt[i] != null)
                    model.setNetExploWgt(netExploWgt[i]);
                if (radaSkdNo[i] != null)
                    model.setRadaSkdNo(radaSkdNo[i]);
                if (radaAmt[i] != null)
                    model.setRadaAmt(radaAmt[i]);
                if (radaUtCd[i] != null)
                    model.setRadaUtCd(radaUtCd[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (rcSeq[i] != null)
                    model.setRcSeq(rcSeq[i]);
                if (awkCgoSeq[i] != null)
                    model.setAwkCgoSeq(awkCgoSeq[i]);
                if (bbCgoSeq[i] != null)
                    model.setBbCgoSeq(bbCgoSeq[i]);
                if (hcdgFlg[i] != null)
                    model.setHcdgFlg(hcdgFlg[i]);
                if (hcdgDpndQtyFlg[i] != null)
                    model.setHcdgDpndQtyFlg(hcdgDpndQtyFlg[i]);
                if (rqstDt[i] != null)
                    model.setRqstDt(rqstDt[i]);
                if (rqstGdt[i] != null)
                    model.setRqstGdt(rqstGdt[i]);
                if (rqstUsrId[i] != null)
                    model.setRqstUsrId(rqstUsrId[i]);
                if (aplyNo[i] != null)
                    model.setAplyNo(aplyNo[i]);
                if (spclCgoAproCd[i] != null)
                    model.setSpclCgoAproCd(spclCgoAproCd[i]);
                if (spclRqstFlg[i] != null)
                    model.setSpclRqstFlg(spclRqstFlg[i]);
                if (spclRqstDesc[i] != null)
                    model.setSpclRqstDesc(spclRqstDesc[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (radaTrspNo[i] != null)
                    model.setRadaTrspNo(radaTrspNo[i]);
                if (hzdCtnt[i] != null)
                    model.setHzdCtnt(hzdCtnt[i]);
                if (stwgTempCtnt[i] != null)
                    model.setStwgTempCtnt(stwgTempCtnt[i]);
                if (grsCapaQty[i] != null)
                    model.setGrsCapaQty(grsCapaQty[i]);
                if (dcgoRqstGrpEml1[i] != null)
                    model.setDcgoRqstGrpEml1(dcgoRqstGrpEml1[i]);
                if (dcgoRqstGrpEml2[i] != null)
                    model.setDcgoRqstGrpEml2(dcgoRqstGrpEml2[i]);
                if (cfrFlg[i] != null)
                    model.setCfrFlg(cfrFlg[i]);
                if (rsdFlg[i] != null)
                    model.setRsdFlg(rsdFlg[i]);
                if (imdgSegrGrpNo[i] != null)
                    model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);
                if (imdgAmdtNo[i] != null)
                    model.setImdgAmdtNo(imdgAmdtNo[i]);
                if (ttlCntrKnt[i] != null)
                    model.setTtlCntrKnt(ttlCntrKnt[i]);
                if (cntrDmyRefNo[i] != null)
                    model.setCntrDmyRefNo(cntrDmyRefNo[i]);
                if (imdgN1stSegrGrpNo[i] != null)
                    model.setImdgN1stSegrGrpNo(imdgN1stSegrGrpNo[i]);
                if (imdgN2ndSegrGrpNo[i] != null)
                    model.setImdgN2ndSegrGrpNo(imdgN2ndSegrGrpNo[i]);
                if (imdgN3rdSegrGrpNo[i] != null)
                    model.setImdgN3rdSegrGrpNo(imdgN3rdSegrGrpNo[i]);
                if (imdgN4thSegrGrpNo[i] != null)
                    model.setImdgN4thSegrGrpNo(imdgN4thSegrGrpNo[i]);
                if (imdgSegrGrpNos[i] != null)
                    model.setImdgSegrGrpNos(imdgSegrGrpNos[i]);
                if (imdgSegrGrpNm[i] != null) 
		    		model.setImdgSegrGrpNm(imdgSegrGrpNm[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSendEdiFromBkgDtlVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return SendEdiFromBkgDtlVO[]
	 */
    public SendEdiFromBkgDtlVO[] getSendEdiFromBkgDtlVOs() {
        SendEdiFromBkgDtlVO[] vos = (SendEdiFromBkgDtlVO[]) models.toArray(new SendEdiFromBkgDtlVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoSeq = this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgCntrSeq = this.dgCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrCgoSeq = this.cntrCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrVolQty = this.cntrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszIsoCd = this.cntrTpszIsoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCompGrpCd = this.imdgCompGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd3 = this.imdgSubsRskLblCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd4 = this.imdgSubsRskLblCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyFlg = this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyFlg = this.imdgExptQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntCdoTemp = this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hzdDesc = this.hzdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measUtCd = this.measUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clodFlg = this.clodFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclStwgRqstDesc = this.spclStwgRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoStsCd = this.dcgoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoLclFlg = this.cgoLclFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerRspnGidNo = this.emerRspnGidNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerRspnGidChrNo = this.emerRspnGidChrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPhnNoCtnt = this.emerCntcPhnNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPsonNm = this.emerCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerTempCtnt = this.emerTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlTempCtnt = this.ctrlTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emsNo = this.emsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCd = this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnPolutFlg = this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psaNo = this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.certiNo = this.certiNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckQty1 = this.inImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckCd1 = this.inImdgPckCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckDesc1 = this.inImdgPckDesc1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckQty2 = this.inImdgPckQty2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckCd2 = this.inImdgPckCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inImdgPckDesc2 = this.inImdgPckDesc2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckQty1 = this.intmdImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckCd1 = this.intmdImdgPckCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckDesc1 = this.intmdImdgPckDesc1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckQty2 = this.intmdImdgPckQty2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckCd2 = this.intmdImdgPckCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdImdgPckDesc2 = this.intmdImdgPckDesc2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckQty1 = this.outImdgPckQty1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckCd1 = this.outImdgPckCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckDesc1 = this.outImdgPckDesc1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckQty2 = this.outImdgPckQty2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckCd2 = this.outImdgPckCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outImdgPckDesc2 = this.outImdgPckDesc2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxInPckQty = this.maxInPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxInPckTpCd = this.maxInPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeDtlDesc = this.cneeDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExploWgt = this.netExploWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaSkdNo = this.radaSkdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaAmt = this.radaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaUtCd = this.radaUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcSeq = this.rcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoSeq = this.awkCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoSeq = this.bbCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgFlg = this.hcdgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgDpndQtyFlg = this.hcdgDpndQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstDt = this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstGdt = this.rqstGdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rqstUsrId = this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aplyNo = this.aplyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAproCd = this.spclCgoAproCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclRqstFlg = this.spclRqstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclRqstDesc = this.spclRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaTrspNo = this.radaTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hzdCtnt = this.hzdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgTempCtnt = this.stwgTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsCapaQty = this.grsCapaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRqstGrpEml1 = this.dcgoRqstGrpEml1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRqstGrpEml2 = this.dcgoRqstGrpEml2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfrFlg = this.cfrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsdFlg = this.rsdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNo = this.imdgSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgAmdtNo = this.imdgAmdtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlCntrKnt = this.ttlCntrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrDmyRefNo = this.cntrDmyRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgN1stSegrGrpNo = this.imdgN1stSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgN2ndSegrGrpNo = this.imdgN2ndSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgN3rdSegrGrpNo = this.imdgN3rdSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgN4thSegrGrpNo = this.imdgN4thSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNos = this.imdgSegrGrpNos.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNm = this.imdgSegrGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
