/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrAproRqstCgoVO.java
 *@FileTitle : ScgPrnrAproRqstCgoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.01
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.01 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

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
public class ScgPrnrAproRqstCgoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgPrnrAproRqstCgoVO> models = new ArrayList<ScgPrnrAproRqstCgoVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String n3rdImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String spclCgoRqstSeq = null;

    /*	Column Info	*/
    private String imdgUnNoSeq = null;

    /*	Column Info	*/
    private String imdgSubsRskLblRmk = null;

    /*	Column Info	*/
    private String radaSkdNo = null;

    /*	Column Info	*/
    private String n4thImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String imdgCompGrpCd = null;

    /*	Column Info	*/
    private String cntrTpszCd = null;

    /*	Column Info	*/
    private String imdgUnNo = null;

    /*	Column Info	*/
    private String updUsrId = null;

    /*	Column Info	*/
    private String hcdgFlg = null;

    /*	Column Info	*/
    private String authOfcCd = null;

    /*	Column Info	*/
    private String hcdgIntmdBcRstrDesc = null;

    /*	Column Info	*/
    private String spclCgoCateCd = null;

    /*	Column Info	*/
    private String skdVoyNo = null;

    /*	Column Info	*/
    private String voidSltQty = null;

    /*	Column Info	*/
    private String podCd = null;

    /*	Column Info	*/
    private String hgtOvrDimLen = null;

    /*	Column Info	*/
    private String intmdN2ndImdgPckDesc = null;

    /*	Column Info	*/
    private String radaAmt = null;

    /*	Column Info	*/
    private String netExploWgt = null;

    /*	Column Info	*/
    private String cmdtDesc = null;

    /*	Column Info	*/
    private String awkFlg = null;

    /*	Column Info	*/
    private String emerRspnGidNo = null;

    /*	Column Info	*/
    private String authUsrId = null;

    /*	Column Info	*/
    private String cneeDtlDesc = null;

    /*	Column Info	*/
    private String imdgClssCd = null;

    /*	Column Info	*/
    private String emerCntcPhnNo = null;

    /*	Column Info	*/
    private String imdgPckGrpCd = null;

    /*	Column Info	*/
    private String measTpCd = null;

    /*	Column Info	*/
    private String flshPntCdoTemp = null;

    /*	Column Info	*/
    private String imdgLmtQtyMeasUtCd = null;

    /*	Column Info	*/
    private String intmdN2ndImdgPckQty = null;

    /*	Column Info	*/
    private String intmdN1stImdgPckQty = null;

    /*	Column Info	*/
    private String n1stImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String imdgLmtQty = null;

    /*	Column Info	*/
    private String inN1stImdgPckCd = null;

    /*	Column Info	*/
    private String outN2ndImdgPckQty = null;

    /*	Column Info	*/
    private String emsNo = null;

    /*	Column Info	*/
    private String maxInPckQty = null;

    /*	Column Info	*/
    private String inN2ndImdgPckDesc = null;

    /*	Column Info	*/
    private String intmdN1stImdgPckCd = null;

    /*	Column Info	*/
    private String pckTpCd = null;

    /*	Column Info	*/
    private String spclStwgRqstDesc = null;

    /*	Column Info	*/
    private String slanCd = null;

    /*	Column Info	*/
    private String diffRmk = null;

    /*	Column Info	*/
    private String outN2ndImdgPckDesc = null;

    /*	Column Info	*/
    private String authStsCd = null;

    /*	Column Info	*/
    private String outN1stImdgPckCd = null;

    /*	Column Info	*/
    private String vslCd = null;

    /*	Column Info	*/
    private String ttlDimWdt = null;

    /*	Column Info	*/
    private String psaNo = null;

    /*	Column Info	*/
    private String inN2ndImdgPckQty = null;

    /*	Column Info	*/
    private String dcgoStsCd = null;

    /*	Column Info	*/
    private String emerCntcPsonNm = null;

    /*	Column Info	*/
    private String outN2ndImdgPckCd = null;

    /*	Column Info	*/
    private String imdgSpclProviNo = null;

    /*	Column Info	*/
    private String crrCd = null;

    /*	Column Info	*/
    private String lfSdOvrDimLen = null;

    /*	Column Info	*/
    private String polCd = null;
 
    /*	Column Info	*/
    private String inN2ndImdgPckCd = null;

    /*	Column Info	*/
    private String fwrdOvrDimLen = null;

    /*	Column Info	*/
    private String wgtUtCd = null;

    /*	Column Info	*/
    private String inN1stImdgPckQty = null;

    /*	Column Info	*/
    private String mrnPolutFlg = null;

    /*	Column Info	*/
    private String cntrRefNo = null;

    /*	Column Info	*/
    private String authDt = null;

    /*	Column Info	*/
    private String netWgt = null;

    /*	Column Info	*/
    private String spclCntrSeq = null;

    /*	Column Info	*/
    private String ttlDimHgt = null;

    /*	Column Info	*/
    private String creUsrId = null;

    /*	Column Info	*/
    private String cgoLclFlg = null;

    /*	Column Info	*/
    private String hzdDesc = null;

    /*	Column Info	*/
    private String ttlDimLen = null;

    /*	Column Info	*/
    private String cgoRqstDt = null;

    /*	Column Info	*/
    private String emerRspnGidChrNo = null;

    /*	Column Info	*/
    private String aproRefNo = null;

    /*	Column Info	*/
    private String emerTempCtnt = null;

    /*	Column Info	*/
    private String grsWgt = null;

    /*	Column Info	*/
    private String rtSdOvrDimLen = null;

    /*	Column Info	*/
    private String spclCgoSeq = null;

    /*	Column Info	*/
    private String creDt = null;

    /*	Column Info	*/
    private String radaTrspNo = null;

    /*	Column Info	*/
    private String maxInPckTpCd = null;

    /*	Column Info	*/
    private String radaUtCd = null;

    /*	Column Info	*/
    private String intmdN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String imdgExptQtyCd = null;

    /*	Column Info	*/
    private String certiNo = null;

    /*	Column Info	*/
    private String measQty = null;

    /*	Column Info	*/
    private String pckQty = null;

    /*	Column Info	*/
    private String outN1stImdgPckQty = null;

    /*	Column Info	*/
    private String hcdgPckRstrDesc = null;

    /*	Column Info	*/
    private String inN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String intmdN2ndImdgPckCd = null;

    /*	Column Info	*/
    private String imdgExptQtyFlg = null;

    /*	Column Info	*/
    private String n2ndImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String clodFlg = null;

    /*	Column Info	*/
    private String bkwdOvrDimLen = null;

    /*	Column Info	*/
    private String imdgCoGrpCd = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String bkgRefNo = null;

    /*	Column Info	*/
    private String dgFlg = null;

    /*	Column Info	*/
    private String cgoOprCd = null;

    /*	Column Info	*/
    private String ctrlTempCtnt = null;

    /*	Column Info	*/
    private String hcdgTnkRstrDesc = null;

    /*	Column Info	*/
    private String outN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String prpShpNm = null;

    /*	Column Info	*/
    private String imdgLmtQtyFlg = null;

    /*	Column Info	*/
    private String cfrFlg = null;

    /*	Column Info	*/
    private String refNo = null;

    /*	Column Info	*/
    private String ediTrsmStsCd = null;

    /* Column Info */
    private String dcgoRefNo = null;

    /* Column Info */
    private String orgDcgoRefNo = null;

    /* Column Info */
    private String hcdgTnkRstrDesc1 = null;

    /* Column Info */
    private String hcdgTnkRstrDesc2 = null;

    /* Column Info */
    private String hcdgTnkRstrDesc3 = null;

    /* Column Info */
    private String hcdgTnkRstrDesc4 = null;

    /* Column Info */
    private String spclCgoAuthRjctCd = null;

    /* Column Info */
    private String spclCgoAuthRmk = null;

    private String imdgSegrGrpNo = null;

    private String rsdFlg = null;

    /* Column Info */
    private String imdgAmdtNo = null;

    /* Column Info */
    private String imdgTecNm = null;

    /* Column Info */
    private String prnrCgoRqstSeq = null;

    /* Column Info */
    private String trsmDt = null;

    /* Column Info */
    private String prnrSpclCgoSeq = null;

    /* Column Info */
    private String dcgoSeq = null;

    /* Column Info */
    private String ediItmSeq = null;

    /* Column Info */
    private String ediUnmapDtlCd = null;

    /* Column Info */
    private String ediUnmapCorrRmk = null;

    /*	Column Info	*/
    private String unmapCntrTpszCd = null;

    /* Info */
    private boolean skip = false;

    /* Column Info */
    private String allAproStsCd = null;

    /* Column Info */
    private String n5thImdgSubsRskLblCd = null;

    /* Column Info */
    private String n6thImdgSubsRskLblCd = null;

    /* Column Info */
    private String n7thImdgSubsRskLblCd = null;

    /* Column Info */
    private String n8thImdgSubsRskLblCd = null;

    /* Column Info */
    private String imdgLmtQtyDesc = null;

    /* Column Info */
    private String imdgExptQtyDesc = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public ScgPrnrAproRqstCgoVO() {
    }

    public ScgPrnrAproRqstCgoVO(String ibflag, String pagerows, String n3rdImdgSubsRskLblCd, String spclCgoRqstSeq, String imdgUnNoSeq, String imdgSubsRskLblRmk, String radaSkdNo, String n4thImdgSubsRskLblCd, String imdgCompGrpCd, String cntrTpszCd, String imdgUnNo, String updUsrId, String hcdgFlg, String authOfcCd, String hcdgIntmdBcRstrDesc, String spclCgoCateCd, String skdVoyNo, String voidSltQty, String podCd, String hgtOvrDimLen, String intmdN2ndImdgPckDesc, String radaAmt, String netExploWgt, String cmdtDesc, String awkFlg, String emerRspnGidNo, String authUsrId, String cneeDtlDesc, String imdgClssCd, String emerCntcPhnNo, String imdgPckGrpCd, String measTpCd, String flshPntCdoTemp, String imdgLmtQtyMeasUtCd, String intmdN2ndImdgPckQty, String intmdN1stImdgPckQty, String n1stImdgSubsRskLblCd, String imdgLmtQty, String inN1stImdgPckCd, String outN2ndImdgPckQty, String emsNo, String maxInPckQty, String inN2ndImdgPckDesc, String intmdN1stImdgPckCd, String pckTpCd, String spclStwgRqstDesc, String slanCd, String diffRmk, String outN2ndImdgPckDesc, String authStsCd, String outN1stImdgPckCd, String vslCd, String ttlDimWdt, String psaNo, String inN2ndImdgPckQty, String dcgoStsCd, String emerCntcPsonNm, String outN2ndImdgPckCd, String imdgSpclProviNo, String crrCd, String lfSdOvrDimLen, String polCd, String inN2ndImdgPckCd, String fwrdOvrDimLen, String wgtUtCd, String inN1stImdgPckQty, String mrnPolutFlg, String cntrRefNo, String authDt, String netWgt, String spclCntrSeq, String ttlDimHgt, String creUsrId, String cgoLclFlg, String hzdDesc, String ttlDimLen, String cgoRqstDt, String emerRspnGidChrNo, String aproRefNo, String emerTempCtnt, String grsWgt, String rtSdOvrDimLen, String spclCgoSeq, String creDt, String radaTrspNo, String maxInPckTpCd, String radaUtCd, String intmdN1stImdgPckDesc, String imdgExptQtyCd, String certiNo, String measQty, String pckQty, String outN1stImdgPckQty, String hcdgPckRstrDesc, String inN1stImdgPckDesc, String intmdN2ndImdgPckCd, String imdgExptQtyFlg, String n2ndImdgSubsRskLblCd, String updDt, String clodFlg, String bkwdOvrDimLen, String imdgCoGrpCd, String skdDirCd, String bkgRefNo, String dgFlg, String cgoOprCd, String ctrlTempCtnt, String hcdgTnkRstrDesc, String outN1stImdgPckDesc, String prpShpNm, String imdgLmtQtyFlg, String cfrFlg, String refNo, String ediTrsmStsCd, String imdgSegrGrpNo, String rsdFlg, String dcgoRefNo, String orgDcgoRefNo, String hcdgTnkRstrDesc1, String hcdgTnkRstrDesc2, String hcdgTnkRstrDesc3, String hcdgTnkRstrDesc4, String spcl_cgo_auth_rjct_cd, String spcl_cgo_auth_rmk, String imdgAmdtNo, String imdgTecNm, String prnrCgoRqstSeq, String trsmDt, String prnrSpclCgoSeq, String dcgoSeq, String ediItmSeq, String ediUnmapDtlCd, String ediUnmapCorrRmk, String unmapCntrTpszCd, String allAproStsCd, String n5thImdgSubsRskLblCd, String n6thImdgSubsRskLblCd, String n7thImdgSubsRskLblCd, String n8thImdgSubsRskLblCd, String imdgLmtQtyDesc, String imdgExptQtyDesc) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.n3rdImdgSubsRskLblCd = n3rdImdgSubsRskLblCd;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
        this.radaSkdNo = radaSkdNo;
        this.n4thImdgSubsRskLblCd = n4thImdgSubsRskLblCd;
        this.imdgCompGrpCd = imdgCompGrpCd;
        this.cntrTpszCd = cntrTpszCd;
        this.imdgUnNo = imdgUnNo;
        this.updUsrId = updUsrId;
        this.hcdgFlg = hcdgFlg;
        this.authOfcCd = authOfcCd;
        this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
        this.spclCgoCateCd = spclCgoCateCd;
        this.skdVoyNo = skdVoyNo;
        this.voidSltQty = voidSltQty;
        this.podCd = podCd;
        this.hgtOvrDimLen = hgtOvrDimLen;
        this.intmdN2ndImdgPckDesc = intmdN2ndImdgPckDesc;
        this.radaAmt = radaAmt;
        this.netExploWgt = netExploWgt;
        this.cmdtDesc = cmdtDesc;
        this.awkFlg = awkFlg;
        this.emerRspnGidNo = emerRspnGidNo;
        this.authUsrId = authUsrId;
        this.cneeDtlDesc = cneeDtlDesc;
        this.imdgClssCd = imdgClssCd;
        this.emerCntcPhnNo = emerCntcPhnNo;
        this.imdgPckGrpCd = imdgPckGrpCd;
        this.measTpCd = measTpCd;
        this.flshPntCdoTemp = flshPntCdoTemp;
        this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
        this.intmdN2ndImdgPckQty = intmdN2ndImdgPckQty;
        this.intmdN1stImdgPckQty = intmdN1stImdgPckQty;
        this.n1stImdgSubsRskLblCd = n1stImdgSubsRskLblCd;
        this.imdgLmtQty = imdgLmtQty;
        this.inN1stImdgPckCd = inN1stImdgPckCd;
        this.outN2ndImdgPckQty = outN2ndImdgPckQty;
        this.emsNo = emsNo;
        this.maxInPckQty = maxInPckQty;
        this.inN2ndImdgPckDesc = inN2ndImdgPckDesc;
        this.intmdN1stImdgPckCd = intmdN1stImdgPckCd;
        this.pckTpCd = pckTpCd;
        this.spclStwgRqstDesc = spclStwgRqstDesc;
        this.slanCd = slanCd;
        this.diffRmk = diffRmk;
        this.outN2ndImdgPckDesc = outN2ndImdgPckDesc;
        this.authStsCd = authStsCd;
        this.outN1stImdgPckCd = outN1stImdgPckCd;
        this.vslCd = vslCd;
        this.ttlDimWdt = ttlDimWdt;
        this.psaNo = psaNo;
        this.inN2ndImdgPckQty = inN2ndImdgPckQty;
        this.dcgoStsCd = dcgoStsCd;
        this.emerCntcPsonNm = emerCntcPsonNm;
        this.outN2ndImdgPckCd = outN2ndImdgPckCd;
        this.imdgSpclProviNo = imdgSpclProviNo;
        this.crrCd = crrCd;
        this.lfSdOvrDimLen = lfSdOvrDimLen;
        this.polCd = polCd;
        this.inN2ndImdgPckCd = inN2ndImdgPckCd;
        this.fwrdOvrDimLen = fwrdOvrDimLen;
        this.wgtUtCd = wgtUtCd;
        this.inN1stImdgPckQty = inN1stImdgPckQty;
        this.mrnPolutFlg = mrnPolutFlg;
        this.cntrRefNo = cntrRefNo;
        this.authDt = authDt;
        this.netWgt = netWgt;
        this.spclCntrSeq = spclCntrSeq;
        this.ttlDimHgt = ttlDimHgt;
        this.creUsrId = creUsrId;
        this.cgoLclFlg = cgoLclFlg;
        this.hzdDesc = hzdDesc;
        this.ttlDimLen = ttlDimLen;
        this.cgoRqstDt = cgoRqstDt;
        this.emerRspnGidChrNo = emerRspnGidChrNo;
        this.aproRefNo = aproRefNo;
        this.emerTempCtnt = emerTempCtnt;
        this.grsWgt = grsWgt;
        this.rtSdOvrDimLen = rtSdOvrDimLen;
        this.spclCgoSeq = spclCgoSeq;
        this.creDt = creDt;
        this.radaTrspNo = radaTrspNo;
        this.maxInPckTpCd = maxInPckTpCd;
        this.radaUtCd = radaUtCd;
        this.intmdN1stImdgPckDesc = intmdN1stImdgPckDesc;
        this.imdgExptQtyCd = imdgExptQtyCd;
        this.certiNo = certiNo;
        this.measQty = measQty;
        this.pckQty = pckQty;
        this.outN1stImdgPckQty = outN1stImdgPckQty;
        this.hcdgPckRstrDesc = hcdgPckRstrDesc;
        this.inN1stImdgPckDesc = inN1stImdgPckDesc;
        this.intmdN2ndImdgPckCd = intmdN2ndImdgPckCd;
        this.imdgExptQtyFlg = imdgExptQtyFlg;
        this.n2ndImdgSubsRskLblCd = n2ndImdgSubsRskLblCd;
        this.updDt = updDt;
        this.clodFlg = clodFlg;
        this.bkwdOvrDimLen = bkwdOvrDimLen;
        this.imdgCoGrpCd = imdgCoGrpCd;
        this.skdDirCd = skdDirCd;
        this.bkgRefNo = bkgRefNo;
        this.dgFlg = dgFlg;
        this.cgoOprCd = cgoOprCd;
        this.ctrlTempCtnt = ctrlTempCtnt;
        this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
        this.outN1stImdgPckDesc = outN1stImdgPckDesc;
        this.prpShpNm = prpShpNm;
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
        this.cfrFlg = cfrFlg;
        this.refNo = refNo;
        this.ediTrsmStsCd = ediTrsmStsCd;
        this.imdgSegrGrpNo = imdgSegrGrpNo;
        this.rsdFlg = rsdFlg;
        this.dcgoRefNo = dcgoRefNo;
        this.orgDcgoRefNo = orgDcgoRefNo;
        this.hcdgTnkRstrDesc1 = hcdgTnkRstrDesc1;
        this.hcdgTnkRstrDesc2 = hcdgTnkRstrDesc2;
        this.hcdgTnkRstrDesc3 = hcdgTnkRstrDesc3;
        this.hcdgTnkRstrDesc4 = hcdgTnkRstrDesc4;
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
        this.spclCgoAuthRmk = spclCgoAuthRmk;
        this.imdgAmdtNo = imdgAmdtNo;
        this.imdgTecNm = imdgTecNm;
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
        this.trsmDt = trsmDt;
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
        this.dcgoSeq = dcgoSeq;
        this.ediItmSeq = ediItmSeq;
        this.ediUnmapDtlCd = ediUnmapDtlCd;
        this.ediUnmapCorrRmk = ediUnmapCorrRmk;
        this.unmapCntrTpszCd = unmapCntrTpszCd;
        this.allAproStsCd = allAproStsCd;
        this.n5thImdgSubsRskLblCd = n5thImdgSubsRskLblCd;
        this.n6thImdgSubsRskLblCd = n6thImdgSubsRskLblCd;
        this.n7thImdgSubsRskLblCd = n7thImdgSubsRskLblCd;
        this.n8thImdgSubsRskLblCd = n8thImdgSubsRskLblCd;
        this.imdgLmtQtyDesc = imdgLmtQtyDesc;
        this.imdgExptQtyDesc = imdgExptQtyDesc;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("n3rd_imdg_subs_rsk_lbl_cd", getN3rdImdgSubsRskLblCd());
        this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("imdg_subs_rsk_lbl_rmk", getImdgSubsRskLblRmk());
        this.hashColumns.put("rada_skd_no", getRadaSkdNo());
        this.hashColumns.put("n4th_imdg_subs_rsk_lbl_cd", getN4thImdgSubsRskLblCd());
        this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("hcdg_flg", getHcdgFlg());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("hcdg_intmd_bc_rstr_desc", getHcdgIntmdBcRstrDesc());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("void_slt_qty", getVoidSltQty());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("hgt_ovr_dim_len", getHgtOvrDimLen());
        this.hashColumns.put("intmd_n2nd_imdg_pck_desc", getIntmdN2ndImdgPckDesc());
        this.hashColumns.put("rada_amt", getRadaAmt());
        this.hashColumns.put("net_explo_wgt", getNetExploWgt());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("awk_flg", getAwkFlg());
        this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
        this.hashColumns.put("auth_usr_id", getAuthUsrId());
        this.hashColumns.put("cnee_dtl_desc", getCneeDtlDesc());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("emer_cntc_phn_no", getEmerCntcPhnNo());
        this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
        this.hashColumns.put("meas_tp_cd", getMeasTpCd());
        this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
        this.hashColumns.put("imdg_lmt_qty_meas_ut_cd", getImdgLmtQtyMeasUtCd());
        this.hashColumns.put("intmd_n2nd_imdg_pck_qty", getIntmdN2ndImdgPckQty());
        this.hashColumns.put("intmd_n1st_imdg_pck_qty", getIntmdN1stImdgPckQty());
        this.hashColumns.put("n1st_imdg_subs_rsk_lbl_cd", getN1stImdgSubsRskLblCd());
        this.hashColumns.put("imdg_lmt_qty", getImdgLmtQty());
        this.hashColumns.put("in_n1st_imdg_pck_cd", getInN1stImdgPckCd());
        this.hashColumns.put("out_n2nd_imdg_pck_qty", getOutN2ndImdgPckQty());
        this.hashColumns.put("ems_no", getEmsNo());
        this.hashColumns.put("max_in_pck_qty", getMaxInPckQty());
        this.hashColumns.put("in_n2nd_imdg_pck_desc", getInN2ndImdgPckDesc());
        this.hashColumns.put("intmd_n1st_imdg_pck_cd", getIntmdN1stImdgPckCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("out_n2nd_imdg_pck_desc", getOutN2ndImdgPckDesc());
        this.hashColumns.put("auth_sts_cd", getAuthStsCd());
        this.hashColumns.put("out_n1st_imdg_pck_cd", getOutN1stImdgPckCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
        this.hashColumns.put("psa_no", getPsaNo());
        this.hashColumns.put("in_n2nd_imdg_pck_qty", getInN2ndImdgPckQty());
        this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
        this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());
        this.hashColumns.put("out_n2nd_imdg_pck_cd", getOutN2ndImdgPckCd());
        this.hashColumns.put("imdg_spcl_provi_no", getImdgSpclProviNo());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("lf_sd_ovr_dim_len", getLfSdOvrDimLen());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("in_n2nd_imdg_pck_cd", getInN2ndImdgPckCd());
        this.hashColumns.put("fwrd_ovr_dim_len", getFwrdOvrDimLen());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("in_n1st_imdg_pck_qty", getInN1stImdgPckQty());
        this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
        this.hashColumns.put("cntr_ref_no", getCntrRefNo());
        this.hashColumns.put("auth_dt", getAuthDt());
        this.hashColumns.put("net_wgt", getNetWgt());
        this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
        this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("cgo_lcl_flg", getCgoLclFlg());
        this.hashColumns.put("hzd_desc", getHzdDesc());
        this.hashColumns.put("ttl_dim_len", getTtlDimLen());
        this.hashColumns.put("cgo_rqst_dt", getCgoRqstDt());
        this.hashColumns.put("emer_rspn_gid_chr_no", getEmerRspnGidChrNo());
        this.hashColumns.put("apro_ref_no", getAproRefNo());
        this.hashColumns.put("emer_temp_ctnt", getEmerTempCtnt());
        this.hashColumns.put("grs_wgt", getGrsWgt());
        this.hashColumns.put("rt_sd_ovr_dim_len", getRtSdOvrDimLen());
        this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
        this.hashColumns.put("cre_dt", getCreDt());
        this.hashColumns.put("rada_trsp_no", getRadaTrspNo());
        this.hashColumns.put("max_in_pck_tp_cd", getMaxInPckTpCd());
        this.hashColumns.put("rada_ut_cd", getRadaUtCd());
        this.hashColumns.put("intmd_n1st_imdg_pck_desc", getIntmdN1stImdgPckDesc());
        this.hashColumns.put("imdg_expt_qty_cd", getImdgExptQtyCd());
        this.hashColumns.put("certi_no", getCertiNo());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("out_n1st_imdg_pck_qty", getOutN1stImdgPckQty());
        this.hashColumns.put("hcdg_pck_rstr_desc", getHcdgPckRstrDesc());
        this.hashColumns.put("in_n1st_imdg_pck_desc", getInN1stImdgPckDesc());
        this.hashColumns.put("intmd_n2nd_imdg_pck_cd", getIntmdN2ndImdgPckCd());
        this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
        this.hashColumns.put("n2nd_imdg_subs_rsk_lbl_cd", getN2ndImdgSubsRskLblCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("clod_flg", getClodFlg());
        this.hashColumns.put("bkwd_ovr_dim_len", getBkwdOvrDimLen());
        this.hashColumns.put("imdg_co_grp_cd", getImdgCoGrpCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("dg_flg", getDgFlg());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("ctrl_temp_ctnt", getCtrlTempCtnt());
        this.hashColumns.put("hcdg_tnk_rstr_desc", getHcdgTnkRstrDesc());
        this.hashColumns.put("out_n1st_imdg_pck_desc", getOutN1stImdgPckDesc());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
        this.hashColumns.put("cfr_flg", getCfrFlg());
        this.hashColumns.put("ref_no", getRefNo());
        this.hashColumns.put("edi_trsm_sts_cd", getEdiTrsmStsCd());
        this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
        this.hashColumns.put("rsd_flg", getRsdFlg());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("org_dcgo_ref_no", getOrgDcgoRefNo());
        this.hashColumns.put("hcdg_tnk_rstr_desc1", getHcdgTnkRstrDesc1());
        this.hashColumns.put("hcdg_tnk_rstr_desc2", getHcdgTnkRstrDesc2());
        this.hashColumns.put("hcdg_tnk_rstr_desc3", getHcdgTnkRstrDesc3());
        this.hashColumns.put("hcdg_tnk_rstr_desc4", getHcdgTnkRstrDesc4());
        this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
        this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
        this.hashColumns.put("imdg_amdt_no", getImdgAmdtNo());
        this.hashColumns.put("imdg_tec_nm", getImdgTecNm());
        this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
        this.hashColumns.put("trsm_dt", getTrsmDt());
        this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
        this.hashColumns.put("dcgo_seq", getDcgoSeq());
        this.hashColumns.put("edi_itm_seq", getEdiItmSeq());
        this.hashColumns.put("edi_unmap_dtl_cd", getEdiUnmapDtlCd());
        this.hashColumns.put("edi_unmap_corr_rmk", getEdiUnmapCorrRmk());
        this.hashColumns.put("unmap_cntr_tpsz_cd", getUnmapCntrTpszCd());
        this.hashColumns.put("all_apro_sts_cd", getAllAproStsCd());
        this.hashColumns.put("n5th_imdg_subs_rsk_lbl_cd", getN5thImdgSubsRskLblCd());
        this.hashColumns.put("n6th_imdg_subs_rsk_lbl_cd", getN6thImdgSubsRskLblCd());
        this.hashColumns.put("n7th_imdg_subs_rsk_lbl_cd", getN7thImdgSubsRskLblCd());
        this.hashColumns.put("n8th_imdg_subs_rsk_lbl_cd", getN8thImdgSubsRskLblCd());
        this.hashColumns.put("imdg_lmt_qty_desc", getImdgLmtQtyDesc());
        this.hashColumns.put("imdg_expt_qty_desc", getImdgExptQtyDesc());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("n3rd_imdg_subs_rsk_lbl_cd", "n3rdImdgSubsRskLblCd");
        this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("imdg_subs_rsk_lbl_rmk", "imdgSubsRskLblRmk");
        this.hashFields.put("rada_skd_no", "radaSkdNo");
        this.hashFields.put("n4th_imdg_subs_rsk_lbl_cd", "n4thImdgSubsRskLblCd");
        this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("hcdg_flg", "hcdgFlg");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("hcdg_intmd_bc_rstr_desc", "hcdgIntmdBcRstrDesc");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("void_slt_qty", "voidSltQty");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("hgt_ovr_dim_len", "hgtOvrDimLen");
        this.hashFields.put("intmd_n2nd_imdg_pck_desc", "intmdN2ndImdgPckDesc");
        this.hashFields.put("rada_amt", "radaAmt");
        this.hashFields.put("net_explo_wgt", "netExploWgt");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("awk_flg", "awkFlg");
        this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
        this.hashFields.put("auth_usr_id", "authUsrId");
        this.hashFields.put("cnee_dtl_desc", "cneeDtlDesc");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("emer_cntc_phn_no", "emerCntcPhnNo");
        this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
        this.hashFields.put("meas_tp_cd", "measTpCd");
        this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
        this.hashFields.put("imdg_lmt_qty_meas_ut_cd", "imdgLmtQtyMeasUtCd");
        this.hashFields.put("intmd_n2nd_imdg_pck_qty", "intmdN2ndImdgPckQty");
        this.hashFields.put("intmd_n1st_imdg_pck_qty", "intmdN1stImdgPckQty");
        this.hashFields.put("n1st_imdg_subs_rsk_lbl_cd", "n1stImdgSubsRskLblCd");
        this.hashFields.put("imdg_lmt_qty", "imdgLmtQty");
        this.hashFields.put("in_n1st_imdg_pck_cd", "inN1stImdgPckCd");
        this.hashFields.put("out_n2nd_imdg_pck_qty", "outN2ndImdgPckQty");
        this.hashFields.put("ems_no", "emsNo");
        this.hashFields.put("max_in_pck_qty", "maxInPckQty");
        this.hashFields.put("in_n2nd_imdg_pck_desc", "inN2ndImdgPckDesc");
        this.hashFields.put("intmd_n1st_imdg_pck_cd", "intmdN1stImdgPckCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("out_n2nd_imdg_pck_desc", "outN2ndImdgPckDesc");
        this.hashFields.put("auth_sts_cd", "authStsCd");
        this.hashFields.put("out_n1st_imdg_pck_cd", "outN1stImdgPckCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
        this.hashFields.put("psa_no", "psaNo");
        this.hashFields.put("in_n2nd_imdg_pck_qty", "inN2ndImdgPckQty");
        this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
        this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
        this.hashFields.put("out_n2nd_imdg_pck_cd", "outN2ndImdgPckCd");
        this.hashFields.put("imdg_spcl_provi_no", "imdgSpclProviNo");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("lf_sd_ovr_dim_len", "lfSdOvrDimLen");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("in_n2nd_imdg_pck_cd", "inN2ndImdgPckCd");
        this.hashFields.put("fwrd_ovr_dim_len", "fwrdOvrDimLen");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("in_n1st_imdg_pck_qty", "inN1stImdgPckQty");
        this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
        this.hashFields.put("cntr_ref_no", "cntrRefNo");
        this.hashFields.put("auth_dt", "authDt");
        this.hashFields.put("net_wgt", "netWgt");
        this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
        this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("cgo_lcl_flg", "cgoLclFlg");
        this.hashFields.put("hzd_desc", "hzdDesc");
        this.hashFields.put("ttl_dim_len", "ttlDimLen");
        this.hashFields.put("cgo_rqst_dt", "cgoRqstDt");
        this.hashFields.put("emer_rspn_gid_chr_no", "emerRspnGidChrNo");
        this.hashFields.put("apro_ref_no", "aproRefNo");
        this.hashFields.put("emer_temp_ctnt", "emerTempCtnt");
        this.hashFields.put("grs_wgt", "grsWgt");
        this.hashFields.put("rt_sd_ovr_dim_len", "rtSdOvrDimLen");
        this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
        this.hashFields.put("cre_dt", "creDt");
        this.hashFields.put("rada_trsp_no", "radaTrspNo");
        this.hashFields.put("max_in_pck_tp_cd", "maxInPckTpCd");
        this.hashFields.put("rada_ut_cd", "radaUtCd");
        this.hashFields.put("intmd_n1st_imdg_pck_desc", "intmdN1stImdgPckDesc");
        this.hashFields.put("imdg_expt_qty_cd", "imdgExptQtyCd");
        this.hashFields.put("certi_no", "certiNo");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("out_n1st_imdg_pck_qty", "outN1stImdgPckQty");
        this.hashFields.put("hcdg_pck_rstr_desc", "hcdgPckRstrDesc");
        this.hashFields.put("in_n1st_imdg_pck_desc", "inN1stImdgPckDesc");
        this.hashFields.put("intmd_n2nd_imdg_pck_cd", "intmdN2ndImdgPckCd");
        this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
        this.hashFields.put("n2nd_imdg_subs_rsk_lbl_cd", "n2ndImdgSubsRskLblCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("clod_flg", "clodFlg");
        this.hashFields.put("bkwd_ovr_dim_len", "bkwdOvrDimLen");
        this.hashFields.put("imdg_co_grp_cd", "imdgCoGrpCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("dg_flg", "dgFlg");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("ctrl_temp_ctnt", "ctrlTempCtnt");
        this.hashFields.put("hcdg_tnk_rstr_desc", "hcdgTnkRstrDesc");
        this.hashFields.put("out_n1st_imdg_pck_desc", "outN1stImdgPckDesc");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
        this.hashFields.put("cfr_flg", "cfrFlg");
        this.hashFields.put("ref_no", "refNo");
        this.hashFields.put("edi_trsm_sts_cd", "ediTrsmStsCd");
        this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
        this.hashFields.put("rsd_flg", "rsdFlg");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("org_dcgo_ref_no", "orgDcgoRefNo");
        this.hashFields.put("hcdg_tnk_rstr_desc1", "hcdgTnkRstrDesc1");
        this.hashFields.put("hcdg_tnk_rstr_desc2", "hcdgTnkRstrDesc2");
        this.hashFields.put("hcdg_tnk_rstr_desc3", "hcdgTnkRstrDesc3");
        this.hashFields.put("hcdg_tnk_rstr_desc4", "hcdgTnkRstrDesc4");
        this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
        this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
        this.hashFields.put("imdg_amdt_no", "imdgAmdtNo");
        this.hashFields.put("imdg_tec_nm", "imdgTecNm");
        this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
        this.hashFields.put("trsm_dt", "trsmDt");
        this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
        this.hashFields.put("dcgo_seq", "dcgoSeq");
        this.hashFields.put("edi_itm_seq", "ediItmSeq");
        this.hashFields.put("edi_unmap_dtl_cd", "ediUnmapDtlCd");
        this.hashFields.put("edi_unmap_corr_rmk", "ediUnmapCorrRmk");
        this.hashFields.put("unmap_cntr_tpsz_cd", "unmapCntrTpszCd");
        this.hashFields.put("all_apro_sts_cd", "allAproStsCd");
        this.hashFields.put("n5th_imdg_subs_rsk_lbl_cd", "n5thImdgSubsRskLblCd");
        this.hashFields.put("n6th_imdg_subs_rsk_lbl_cd", "n6thImdgSubsRskLblCd");
        this.hashFields.put("n7th_imdg_subs_rsk_lbl_cd", "n7thImdgSubsRskLblCd");
        this.hashFields.put("n8th_imdg_subs_rsk_lbl_cd", "n8thImdgSubsRskLblCd");
        this.hashFields.put("imdg_lmt_qty_desc", "imdgLmtQtyDesc");
        this.hashFields.put("imdg_expt_qty_desc", "imdgExptQtyDesc");
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
	 * @return n3rdImdgSubsRskLblCd
	 */
    public String getN3rdImdgSubsRskLblCd() {
        return this.n3rdImdgSubsRskLblCd;
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
	 * @return imdgUnNoSeq
	 */
    public String getImdgUnNoSeq() {
        return this.imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @return imdgSubsRskLblRmk
	 */
    public String getImdgSubsRskLblRmk() {
        return this.imdgSubsRskLblRmk;
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
	 * @return n4thImdgSubsRskLblCd
	 */
    public String getN4thImdgSubsRskLblCd() {
        return this.n4thImdgSubsRskLblCd;
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
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
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
	 * @return updUsrId
	 */
    public String getUpdUsrId() {
        return this.updUsrId;
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
	 * @return authOfcCd
	 */
    public String getAuthOfcCd() {
        return this.authOfcCd;
    }

    /**
	 * Column Info
	 * @return hcdgIntmdBcRstrDesc
	 */
    public String getHcdgIntmdBcRstrDesc() {
        return this.hcdgIntmdBcRstrDesc;
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
	 * @return voidSltQty
	 */
    public String getVoidSltQty() {
        return this.voidSltQty;
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
	 * @return hgtOvrDimLen
	 */
    public String getHgtOvrDimLen() {
        return this.hgtOvrDimLen;
    }

    /**
	 * Column Info
	 * @return intmdN2ndImdgPckDesc
	 */
    public String getIntmdN2ndImdgPckDesc() {
        return this.intmdN2ndImdgPckDesc;
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
	 * @return netExploWgt
	 */
    public String getNetExploWgt() {
        return this.netExploWgt;
    }

    /**
	 * Column Info
	 * @return cmdtDesc
	 */
    public String getCmdtDesc() {
        return this.cmdtDesc;
    }

    /**
	 * Column Info
	 * @return awkFlg
	 */
    public String getAwkFlg() {
        return this.awkFlg;
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
	 * @return authUsrId
	 */
    public String getAuthUsrId() {
        return this.authUsrId;
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
	 * @return imdgClssCd
	 */
    public String getImdgClssCd() {
        return this.imdgClssCd;
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
	 * @return imdgPckGrpCd
	 */
    public String getImdgPckGrpCd() {
        return this.imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @return measTpCd
	 */
    public String getMeasTpCd() {
        return this.measTpCd;
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
	 * @return imdgLmtQtyMeasUtCd
	 */
    public String getImdgLmtQtyMeasUtCd() {
        return this.imdgLmtQtyMeasUtCd;
    }

    /**
	 * Column Info
	 * @return intmdN2ndImdgPckQty
	 */
    public String getIntmdN2ndImdgPckQty() {
        return this.intmdN2ndImdgPckQty;
    }

    /**
	 * Column Info
	 * @return intmdN1stImdgPckQty
	 */
    public String getIntmdN1stImdgPckQty() {
        return this.intmdN1stImdgPckQty;
    }

    /**
	 * Column Info
	 * @return n1stImdgSubsRskLblCd
	 */
    public String getN1stImdgSubsRskLblCd() {
        return this.n1stImdgSubsRskLblCd;
    }

    /**
	 * Column Info
	 * @return imdgLmtQty
	 */
    public String getImdgLmtQty() {
        return this.imdgLmtQty;
    }

    /**
	 * Column Info
	 * @return inN1stImdgPckCd
	 */
    public String getInN1stImdgPckCd() {
        return this.inN1stImdgPckCd;
    }

    /**
	 * Column Info
	 * @return outN2ndImdgPckQty
	 */
    public String getOutN2ndImdgPckQty() {
        return this.outN2ndImdgPckQty;
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
	 * @return maxInPckQty
	 */
    public String getMaxInPckQty() {
        return this.maxInPckQty;
    }

    /**
	 * Column Info
	 * @return inN2ndImdgPckDesc
	 */
    public String getInN2ndImdgPckDesc() {
        return this.inN2ndImdgPckDesc;
    }

    /**
	 * Column Info
	 * @return intmdN1stImdgPckCd
	 */
    public String getIntmdN1stImdgPckCd() {
        return this.intmdN1stImdgPckCd;
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
	 * @return spclStwgRqstDesc
	 */
    public String getSpclStwgRqstDesc() {
        return this.spclStwgRqstDesc;
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
	 * @return outN2ndImdgPckDesc
	 */
    public String getOutN2ndImdgPckDesc() {
        return this.outN2ndImdgPckDesc;
    }

    /**
	 * Column Info
	 * @return authStsCd
	 */
    public String getAuthStsCd() {
        return this.authStsCd;
    }

    /**
	 * Column Info
	 * @return outN1stImdgPckCd
	 */
    public String getOutN1stImdgPckCd() {
        return this.outN1stImdgPckCd;
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
	 * @return ttlDimWdt
	 */
    public String getTtlDimWdt() {
        return this.ttlDimWdt;
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
	 * @return inN2ndImdgPckQty
	 */
    public String getInN2ndImdgPckQty() {
        return this.inN2ndImdgPckQty;
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
	 * @return emerCntcPsonNm
	 */
    public String getEmerCntcPsonNm() {
        return this.emerCntcPsonNm;
    }

    /**
	 * Column Info
	 * @return outN2ndImdgPckCd
	 */
    public String getOutN2ndImdgPckCd() {
        return this.outN2ndImdgPckCd;
    }

    /**
	 * Column Info
	 * @return imdgSpclProviNo
	 */
    public String getImdgSpclProviNo() {
        return this.imdgSpclProviNo;
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
	 * @return lfSdOvrDimLen
	 */
    public String getLfSdOvrDimLen() {
        return this.lfSdOvrDimLen;
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
	 * @return inN2ndImdgPckCd
	 */
    public String getInN2ndImdgPckCd() {
        return this.inN2ndImdgPckCd;
    }

    /**
	 * Column Info
	 * @return fwrdOvrDimLen
	 */
    public String getFwrdOvrDimLen() {
        return this.fwrdOvrDimLen;
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
	 * @return inN1stImdgPckQty
	 */
    public String getInN1stImdgPckQty() {
        return this.inN1stImdgPckQty;
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
	 * @return cntrRefNo
	 */
    public String getCntrRefNo() {
        return this.cntrRefNo;
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
	 * @return netWgt
	 */
    public String getNetWgt() {
        return this.netWgt;
    }

    /**
	 * Column Info
	 * @return spclCntrSeq
	 */
    public String getSpclCntrSeq() {
        return this.spclCntrSeq;
    }

    /**
	 * Column Info
	 * @return ttlDimHgt
	 */
    public String getTtlDimHgt() {
        return this.ttlDimHgt;
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
	 * @return cgoLclFlg
	 */
    public String getCgoLclFlg() {
        return this.cgoLclFlg;
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
	 * @return ttlDimLen
	 */
    public String getTtlDimLen() {
        return this.ttlDimLen;
    }

    /**
	 * Column Info
	 * @return cgoRqstDt
	 */
    public String getCgoRqstDt() {
        return this.cgoRqstDt;
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
	 * @return aproRefNo
	 */
    public String getAproRefNo() {
        return this.aproRefNo;
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
	 * @return grsWgt
	 */
    public String getGrsWgt() {
        return this.grsWgt;
    }

    /**
	 * Column Info
	 * @return rtSdOvrDimLen
	 */
    public String getRtSdOvrDimLen() {
        return this.rtSdOvrDimLen;
    }

    /**
	 * Column Info
	 * @return spclCgoSeq
	 */
    public String getSpclCgoSeq() {
        return this.spclCgoSeq;
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
	 * @return radaTrspNo
	 */
    public String getRadaTrspNo() {
        return this.radaTrspNo;
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
	 * @return radaUtCd
	 */
    public String getRadaUtCd() {
        return this.radaUtCd;
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
	 * @return imdgExptQtyCd
	 */
    public String getImdgExptQtyCd() {
        return this.imdgExptQtyCd;
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
	 * @return outN1stImdgPckQty
	 */
    public String getOutN1stImdgPckQty() {
        return this.outN1stImdgPckQty;
    }

    /**
	 * Column Info
	 * @return hcdgPckRstrDesc
	 */
    public String getHcdgPckRstrDesc() {
        return this.hcdgPckRstrDesc;
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
	 * @return intmdN2ndImdgPckCd
	 */
    public String getIntmdN2ndImdgPckCd() {
        return this.intmdN2ndImdgPckCd;
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
	 * @return n2ndImdgSubsRskLblCd
	 */
    public String getN2ndImdgSubsRskLblCd() {
        return this.n2ndImdgSubsRskLblCd;
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
	 * @return clodFlg
	 */
    public String getClodFlg() {
        return this.clodFlg;
    }

    /**
	 * Column Info
	 * @return bkwdOvrDimLen
	 */
    public String getBkwdOvrDimLen() {
        return this.bkwdOvrDimLen;
    }

    /**
	 * Column Info
	 * @return imdgCoGrpCd
	 */
    public String getImdgCoGrpCd() {
        return this.imdgCoGrpCd;
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
	 * @return bkgRefNo
	 */
    public String getBkgRefNo() {
        return this.bkgRefNo;
    }

    /**
	 * Column Info
	 * @return dgFlg
	 */
    public String getDgFlg() {
        return this.dgFlg;
    }

    /**
	 * Column Info
	 * @return cgoOprCd
	 */
    public String getCgoOprCd() {
        return this.cgoOprCd;
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
	 * @return hcdgTnkRstrDesc
	 */
    public String getHcdgTnkRstrDesc() {
        return this.hcdgTnkRstrDesc;
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
	 * @return prpShpNm
	 */
    public String getPrpShpNm() {
        return this.prpShpNm;
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
	 * @return cfrFlg
	 */
    public String getCfrFlg() {
        return this.cfrFlg;
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
	 * @return ediTrsmStsCd
	 */
    public String getEdiTrsmStsCd() {
        return this.ediTrsmStsCd;
    }

    /**
	 * Column Info
	 * @return hcdgTnkRstrDesc1
	 */
    public String getHcdgTnkRstrDesc1() {
        return this.hcdgTnkRstrDesc1;
    }

    /**
	 * Column Info
	 * @return hcdgTnkRstrDesc2
	 */
    public String getHcdgTnkRstrDesc2() {
        return this.hcdgTnkRstrDesc2;
    }

    /**
	 * Column Info
	 * @return hcdgTnkRstrDesc3
	 */
    public String getHcdgTnkRstrDesc3() {
        return this.hcdgTnkRstrDesc3;
    }

    /**
	 * Column Info
	 * @return hcdgTnkRstrDesc4
	 */
    public String getHcdgTnkRstrDesc4() {
        return this.hcdgTnkRstrDesc4;
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
	 * @return spclCgoAuthRmk
	 */
    public String getSpclCgoAuthRmk() {
        return this.spclCgoAuthRmk;
    }

    /**
	 * Info
	 * @return skip
	 */
    public boolean getSkip() {
        return this.skip;
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
	 * @param  n3rdImdgSubsRskLblCd
 	 */
    public void setN3rdImdgSubsRskLblCd(String n3rdImdgSubsRskLblCd) {
        this.n3rdImdgSubsRskLblCd = n3rdImdgSubsRskLblCd;
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
	 * @param  imdgUnNoSeq
 	 */
    public void setImdgUnNoSeq(String imdgUnNoSeq) {
        this.imdgUnNoSeq = imdgUnNoSeq;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblRmk
 	 */
    public void setImdgSubsRskLblRmk(String imdgSubsRskLblRmk) {
        this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
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
	 * @param  n4thImdgSubsRskLblCd
 	 */
    public void setN4thImdgSubsRskLblCd(String n4thImdgSubsRskLblCd) {
        this.n4thImdgSubsRskLblCd = n4thImdgSubsRskLblCd;
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
	 * @param  cntrTpszCd
 	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
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
	 * @param  updUsrId
 	 */
    public void setUpdUsrId(String updUsrId) {
        this.updUsrId = updUsrId;
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
	 * @param  authOfcCd
 	 */
    public void setAuthOfcCd(String authOfcCd) {
        this.authOfcCd = authOfcCd;
    }

    /**
	 * Column Info
	 * @param  hcdgIntmdBcRstrDesc
 	 */
    public void setHcdgIntmdBcRstrDesc(String hcdgIntmdBcRstrDesc) {
        this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
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
	 * @param  skdVoyNo
 	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param  voidSltQty
 	 */
    public void setVoidSltQty(String voidSltQty) {
        this.voidSltQty = voidSltQty;
    }

    /**
	 * Column Info
	 * @param  podCd
 	 */
    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    /**
	 * Column Info
	 * @param  hgtOvrDimLen
 	 */
    public void setHgtOvrDimLen(String hgtOvrDimLen) {
        this.hgtOvrDimLen = hgtOvrDimLen;
    }

    /**
	 * Column Info
	 * @param  intmdN2ndImdgPckDesc
 	 */
    public void setIntmdN2ndImdgPckDesc(String intmdN2ndImdgPckDesc) {
        this.intmdN2ndImdgPckDesc = intmdN2ndImdgPckDesc;
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
	 * @param  netExploWgt
 	 */
    public void setNetExploWgt(String netExploWgt) {
        this.netExploWgt = netExploWgt;
    }

    /**
	 * Column Info
	 * @param  cmdtDesc
 	 */
    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    /**
	 * Column Info
	 * @param  awkFlg
 	 */
    public void setAwkFlg(String awkFlg) {
        this.awkFlg = awkFlg;
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
	 * @param  authUsrId
 	 */
    public void setAuthUsrId(String authUsrId) {
        this.authUsrId = authUsrId;
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
	 * @param  imdgClssCd
 	 */
    public void setImdgClssCd(String imdgClssCd) {
        this.imdgClssCd = imdgClssCd;
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
	 * @param  imdgPckGrpCd
 	 */
    public void setImdgPckGrpCd(String imdgPckGrpCd) {
        this.imdgPckGrpCd = imdgPckGrpCd;
    }

    /**
	 * Column Info
	 * @param  measTpCd
 	 */
    public void setMeasTpCd(String measTpCd) {
        this.measTpCd = measTpCd;
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
	 * @param  imdgLmtQtyMeasUtCd
 	 */
    public void setImdgLmtQtyMeasUtCd(String imdgLmtQtyMeasUtCd) {
        this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
    }

    /**
	 * Column Info
	 * @param  intmdN2ndImdgPckQty
 	 */
    public void setIntmdN2ndImdgPckQty(String intmdN2ndImdgPckQty) {
        this.intmdN2ndImdgPckQty = intmdN2ndImdgPckQty;
    }

    /**
	 * Column Info
	 * @param  intmdN1stImdgPckQty
 	 */
    public void setIntmdN1stImdgPckQty(String intmdN1stImdgPckQty) {
        this.intmdN1stImdgPckQty = intmdN1stImdgPckQty;
    }

    /**
	 * Column Info
	 * @param  n1stImdgSubsRskLblCd
 	 */
    public void setN1stImdgSubsRskLblCd(String n1stImdgSubsRskLblCd) {
        this.n1stImdgSubsRskLblCd = n1stImdgSubsRskLblCd;
    }

    /**
	 * Column Info
	 * @param  imdgLmtQty
 	 */
    public void setImdgLmtQty(String imdgLmtQty) {
        this.imdgLmtQty = imdgLmtQty;
    }

    /**
	 * Column Info
	 * @param  inN1stImdgPckCd
 	 */
    public void setInN1stImdgPckCd(String inN1stImdgPckCd) {
        this.inN1stImdgPckCd = inN1stImdgPckCd;
    }

    /**
	 * Column Info
	 * @param  outN2ndImdgPckQty
 	 */
    public void setOutN2ndImdgPckQty(String outN2ndImdgPckQty) {
        this.outN2ndImdgPckQty = outN2ndImdgPckQty;
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
	 * @param  maxInPckQty
 	 */
    public void setMaxInPckQty(String maxInPckQty) {
        this.maxInPckQty = maxInPckQty;
    }

    /**
	 * Column Info
	 * @param  inN2ndImdgPckDesc
 	 */
    public void setInN2ndImdgPckDesc(String inN2ndImdgPckDesc) {
        this.inN2ndImdgPckDesc = inN2ndImdgPckDesc;
    }

    /**
	 * Column Info
	 * @param  intmdN1stImdgPckCd
 	 */
    public void setIntmdN1stImdgPckCd(String intmdN1stImdgPckCd) {
        this.intmdN1stImdgPckCd = intmdN1stImdgPckCd;
    }

    /**
	 * Column Info
	 * @param  pckTpCd
 	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
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
	 * @param  slanCd
 	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
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
	 * @param  outN2ndImdgPckDesc
 	 */
    public void setOutN2ndImdgPckDesc(String outN2ndImdgPckDesc) {
        this.outN2ndImdgPckDesc = outN2ndImdgPckDesc;
    }

    /**
	 * Column Info
	 * @param  authStsCd
 	 */
    public void setAuthStsCd(String authStsCd) {
        this.authStsCd = authStsCd;
    }

    /**
	 * Column Info
	 * @param  outN1stImdgPckCd
 	 */
    public void setOutN1stImdgPckCd(String outN1stImdgPckCd) {
        this.outN1stImdgPckCd = outN1stImdgPckCd;
    }

    /**
	 * Column Info
	 * @param  vslCd
 	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param  ttlDimWdt
 	 */
    public void setTtlDimWdt(String ttlDimWdt) {
        this.ttlDimWdt = ttlDimWdt;
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
	 * @param  inN2ndImdgPckQty
 	 */
    public void setInN2ndImdgPckQty(String inN2ndImdgPckQty) {
        this.inN2ndImdgPckQty = inN2ndImdgPckQty;
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
	 * @param  emerCntcPsonNm
 	 */
    public void setEmerCntcPsonNm(String emerCntcPsonNm) {
        this.emerCntcPsonNm = emerCntcPsonNm;
    }

    /**
	 * Column Info
	 * @param  outN2ndImdgPckCd
 	 */
    public void setOutN2ndImdgPckCd(String outN2ndImdgPckCd) {
        this.outN2ndImdgPckCd = outN2ndImdgPckCd;
    }

    /**
	 * Column Info
	 * @param  imdgSpclProviNo
 	 */
    public void setImdgSpclProviNo(String imdgSpclProviNo) {
        this.imdgSpclProviNo = imdgSpclProviNo;
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
	 * @param  lfSdOvrDimLen
 	 */
    public void setLfSdOvrDimLen(String lfSdOvrDimLen) {
        this.lfSdOvrDimLen = lfSdOvrDimLen;
    }

    /**
	 * Column Info
	 * @param  polCd
 	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    /**
	 * Column Info
	 * @param  inN2ndImdgPckCd
 	 */
    public void setInN2ndImdgPckCd(String inN2ndImdgPckCd) {
        this.inN2ndImdgPckCd = inN2ndImdgPckCd;
    }

    /**
	 * Column Info
	 * @param  fwrdOvrDimLen
 	 */
    public void setFwrdOvrDimLen(String fwrdOvrDimLen) {
        this.fwrdOvrDimLen = fwrdOvrDimLen;
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
	 * @param  inN1stImdgPckQty
 	 */
    public void setInN1stImdgPckQty(String inN1stImdgPckQty) {
        this.inN1stImdgPckQty = inN1stImdgPckQty;
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
	 * @param  cntrRefNo
 	 */
    public void setCntrRefNo(String cntrRefNo) {
        this.cntrRefNo = cntrRefNo;
    }

    /**
	 * Column Info
	 * @param  authDt
 	 */
    public void setAuthDt(String authDt) {
        this.authDt = authDt;
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
	 * @param  spclCntrSeq
 	 */
    public void setSpclCntrSeq(String spclCntrSeq) {
        this.spclCntrSeq = spclCntrSeq;
    }

    /**
	 * Column Info
	 * @param  ttlDimHgt
 	 */
    public void setTtlDimHgt(String ttlDimHgt) {
        this.ttlDimHgt = ttlDimHgt;
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
	 * @param  cgoLclFlg
 	 */
    public void setCgoLclFlg(String cgoLclFlg) {
        this.cgoLclFlg = cgoLclFlg;
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
	 * @param  ttlDimLen
 	 */
    public void setTtlDimLen(String ttlDimLen) {
        this.ttlDimLen = ttlDimLen;
    }

    /**
	 * Column Info
	 * @param  cgoRqstDt
 	 */
    public void setCgoRqstDt(String cgoRqstDt) {
        this.cgoRqstDt = cgoRqstDt;
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
	 * @param  aproRefNo
 	 */
    public void setAproRefNo(String aproRefNo) {
        this.aproRefNo = aproRefNo;
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
	 * @param  grsWgt
 	 */
    public void setGrsWgt(String grsWgt) {
        this.grsWgt = grsWgt;
    }

    /**
	 * Column Info
	 * @param  rtSdOvrDimLen
 	 */
    public void setRtSdOvrDimLen(String rtSdOvrDimLen) {
        this.rtSdOvrDimLen = rtSdOvrDimLen;
    }

    /**
	 * Column Info
	 * @param  spclCgoSeq
 	 */
    public void setSpclCgoSeq(String spclCgoSeq) {
        this.spclCgoSeq = spclCgoSeq;
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
	 * @param  radaTrspNo
 	 */
    public void setRadaTrspNo(String radaTrspNo) {
        this.radaTrspNo = radaTrspNo;
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
	 * @param  radaUtCd
 	 */
    public void setRadaUtCd(String radaUtCd) {
        this.radaUtCd = radaUtCd;
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
	 * @param  imdgExptQtyCd
 	 */
    public void setImdgExptQtyCd(String imdgExptQtyCd) {
        this.imdgExptQtyCd = imdgExptQtyCd;
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
	 * @param  measQty
 	 */
    public void setMeasQty(String measQty) {
        this.measQty = measQty;
    }

    /**
	 * Column Info
	 * @param  pckQty
 	 */
    public void setPckQty(String pckQty) {
        this.pckQty = pckQty;
    }

    /**
	 * Column Info
	 * @param  outN1stImdgPckQty
 	 */
    public void setOutN1stImdgPckQty(String outN1stImdgPckQty) {
        this.outN1stImdgPckQty = outN1stImdgPckQty;
    }

    /**
	 * Column Info
	 * @param  hcdgPckRstrDesc
 	 */
    public void setHcdgPckRstrDesc(String hcdgPckRstrDesc) {
        this.hcdgPckRstrDesc = hcdgPckRstrDesc;
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
	 * @param  intmdN2ndImdgPckCd
 	 */
    public void setIntmdN2ndImdgPckCd(String intmdN2ndImdgPckCd) {
        this.intmdN2ndImdgPckCd = intmdN2ndImdgPckCd;
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
	 * @param  n2ndImdgSubsRskLblCd
 	 */
    public void setN2ndImdgSubsRskLblCd(String n2ndImdgSubsRskLblCd) {
        this.n2ndImdgSubsRskLblCd = n2ndImdgSubsRskLblCd;
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
	 * @param  clodFlg
 	 */
    public void setClodFlg(String clodFlg) {
        this.clodFlg = clodFlg;
    }

    /**
	 * Column Info
	 * @param  bkwdOvrDimLen
 	 */
    public void setBkwdOvrDimLen(String bkwdOvrDimLen) {
        this.bkwdOvrDimLen = bkwdOvrDimLen;
    }

    /**
	 * Column Info
	 * @param  imdgCoGrpCd
 	 */
    public void setImdgCoGrpCd(String imdgCoGrpCd) {
        this.imdgCoGrpCd = imdgCoGrpCd;
    }

    /**
	 * Column Info
	 * @param  skdDirCd
 	 */
    public void setSkdDirCd(String skdDirCd) {
        this.skdDirCd = skdDirCd;
    }

    /**
	 * Column Info
	 * @param  bkgRefNo
 	 */
    public void setBkgRefNo(String bkgRefNo) {
        this.bkgRefNo = bkgRefNo;
    }

    /**
	 * Column Info
	 * @param  dgFlg
 	 */
    public void setDgFlg(String dgFlg) {
        this.dgFlg = dgFlg;
    }

    /**
	 * Column Info
	 * @param  cgoOprCd
 	 */
    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
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
	 * @param  hcdgTnkRstrDesc
 	 */
    public void setHcdgTnkRstrDesc(String hcdgTnkRstrDesc) {
        this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
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
	 * @param  prpShpNm
 	 */
    public void setPrpShpNm(String prpShpNm) {
        this.prpShpNm = prpShpNm;
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
	 * @param  cfrFlg
 	 */
    public void setCfrFlg(String cfrFlg) {
        this.cfrFlg = cfrFlg;
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
	 * @param  ediTrsmStsCd
 	 */
    public void setEdiTrsmStsCd(String ediTrsmStsCd) {
        this.ediTrsmStsCd = ediTrsmStsCd;
    }

    /**
	 * Column Info
	 * @param  hcdgTnkRstrDesc1
 	 */
    public void setHcdgTnkRstrDesc1(String hcdgTnkRstrDesc1) {
        this.hcdgTnkRstrDesc1 = hcdgTnkRstrDesc1;
    }

    /**
	 * Column Info
	 * @param  hcdgTnkRstrDesc2
 	 */
    public void setHcdgTnkRstrDesc2(String hcdgTnkRstrDesc2) {
        this.hcdgTnkRstrDesc2 = hcdgTnkRstrDesc2;
    }

    /**
	 * Column Info
	 * @param  hcdgTnkRstrDesc3
 	 */
    public void setHcdgTnkRstrDesc3(String hcdgTnkRstrDesc3) {
        this.hcdgTnkRstrDesc3 = hcdgTnkRstrDesc3;
    }

    /**
	 * Column Info
	 * @param  hcdgTnkRstrDesc4
 	 */
    public void setHcdgTnkRstrDesc4(String hcdgTnkRstrDesc4) {
        this.hcdgTnkRstrDesc4 = hcdgTnkRstrDesc4;
    }

    public void setImdgAmdtNo(String imdgAmdtNo) {
        this.imdgAmdtNo = imdgAmdtNo;
    }

    public String getImdgAmdtNo() {
        return this.imdgAmdtNo;
    }

    public void setImdgTecNm(String imdgTecNm) {
        this.imdgTecNm = imdgTecNm;
    }

    public String getImdgTecNm() {
        return this.imdgTecNm;
    }

    public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
    }

    public String getPrnrCgoRqstSeq() {
        return this.prnrCgoRqstSeq;
    }

    public void setTrsmDt(String trsmDt) {
        this.trsmDt = trsmDt;
    }

    public String getTrsmDt() {
        return this.trsmDt;
    }

    public void setPrnrSpclCgoSeq(String prnrSpclCgoSeq) {
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
    }

    public String getPrnrSpclCgoSeq() {
        return this.prnrSpclCgoSeq;
    }

    public void setDcgoSeq(String dcgoSeq) {
        this.dcgoSeq = dcgoSeq;
    }

    public String getDcgoSeq() {
        return this.dcgoSeq;
    }

    public void setEdiItmSeq(String ediItmSeq) {
        this.ediItmSeq = ediItmSeq;
    }

    public String getEdiItmSeq() {
        return this.ediItmSeq;
    }

    public void setEdiUnmapDtlCd(String ediUnmapDtlCd) {
        this.ediUnmapDtlCd = ediUnmapDtlCd;
    }

    public String getEdiUnmapDtlCd() {
        return this.ediUnmapDtlCd;
    }

    public void setEdiUnmapCorrRmk(String ediUnmapCorrRmk) {
        this.ediUnmapCorrRmk = ediUnmapCorrRmk;
    }

    public String getEdiUnmapCorrRmk() {
        return this.ediUnmapCorrRmk;
    }

    public void setUnmapCntrTpszCd(String unmapCntrTpszCd) {
        this.unmapCntrTpszCd = unmapCntrTpszCd;
    }

    public String getUnmapCntrTpszCd() {
        return this.unmapCntrTpszCd;
    }

    public void setAllAproStsCd(String allAproStsCd) {
        this.allAproStsCd = allAproStsCd;
    }

    public String getAllAproStsCd() {
        return this.allAproStsCd;
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

    public void setImdgLmtQtyDesc(String imdgLmtQtyDesc) {
        this.imdgLmtQtyDesc = imdgLmtQtyDesc;
    }

    public String getImdgLmtQtyDesc() {
        return this.imdgLmtQtyDesc;
    }

    public void setImdgExptQtyDesc(String imdgExptQtyDesc) {
        this.imdgExptQtyDesc = imdgExptQtyDesc;
    }

    public String getImdgExptQtyDesc() {
        return this.imdgExptQtyDesc;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    public String getImdgSegrGrpNo() {
        return imdgSegrGrpNo;
    }

    public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
        this.imdgSegrGrpNo = imdgSegrGrpNo;
    }

    public String getRsdFlg() {
        return rsdFlg;
    }

    public void setRsdFlg(String rsdFlg) {
        this.rsdFlg = rsdFlg;
    }

    public String getDcgoRefNo() {
        return this.dcgoRefNo;
    }

    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
    }

    public String getOrgDcgoRefNo() {
        return this.orgDcgoRefNo;
    }

    public void setOrgDcgoRefNo(String orgDcgoRefNo) {
        this.orgDcgoRefNo = orgDcgoRefNo;
    }

    public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
    }

    public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
        this.spclCgoAuthRmk = spclCgoAuthRmk;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setN3rdImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_subs_rsk_lbl_cd", ""));
        setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setImdgSubsRskLblRmk(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_rmk", ""));
        setRadaSkdNo(JSPUtil.getParameter(request, prefix + "rada_skd_no", ""));
        setN4thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_subs_rsk_lbl_cd", ""));
        setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setHcdgIntmdBcRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_intmd_bc_rstr_desc", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setVoidSltQty(JSPUtil.getParameter(request, prefix + "void_slt_qty", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setHgtOvrDimLen(JSPUtil.getParameter(request, prefix + "hgt_ovr_dim_len", ""));
        setIntmdN2ndImdgPckDesc(JSPUtil.getParameter(request, prefix + "intmd_n2nd_imdg_pck_desc", ""));
        setRadaAmt(JSPUtil.getParameter(request, prefix + "rada_amt", ""));
        setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
        setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
        setAuthUsrId(JSPUtil.getParameter(request, prefix + "auth_usr_id", ""));
        setCneeDtlDesc(JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setEmerCntcPhnNo(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", ""));
        setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
        setMeasTpCd(JSPUtil.getParameter(request, prefix + "meas_tp_cd", ""));
        setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
        setImdgLmtQtyMeasUtCd(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_meas_ut_cd", ""));
        setIntmdN2ndImdgPckQty(JSPUtil.getParameter(request, prefix + "intmd_n2nd_imdg_pck_qty", ""));
        setIntmdN1stImdgPckQty(JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_qty", ""));
        setN1stImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_subs_rsk_lbl_cd", ""));
        setImdgLmtQty(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty", ""));
        setInN1stImdgPckCd(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_cd", ""));
        setOutN2ndImdgPckQty(JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_qty", ""));
        setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
        setMaxInPckQty(JSPUtil.getParameter(request, prefix + "max_in_pck_qty", ""));
        setInN2ndImdgPckDesc(JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_desc", ""));
        setIntmdN1stImdgPckCd(JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setSpclStwgRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setOutN2ndImdgPckDesc(JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_desc", ""));
        setAuthStsCd(JSPUtil.getParameter(request, prefix + "auth_sts_cd", ""));
        setOutN1stImdgPckCd(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
        setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
        setInN2ndImdgPckQty(JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_qty", ""));
        setDcgoStsCd(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", ""));
        setEmerCntcPsonNm(JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", ""));
        setOutN2ndImdgPckCd(JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_cd", ""));
        setImdgSpclProviNo(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setLfSdOvrDimLen(JSPUtil.getParameter(request, prefix + "lf_sd_ovr_dim_len", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setInN2ndImdgPckCd(JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_cd", ""));
        setFwrdOvrDimLen(JSPUtil.getParameter(request, prefix + "fwrd_ovr_dim_len", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setInN1stImdgPckQty(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_qty", ""));
        setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
        setCntrRefNo(JSPUtil.getParameter(request, prefix + "cntr_ref_no", ""));
        setAuthDt(JSPUtil.getParameter(request, prefix + "auth_dt", ""));
        setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
        setSpclCntrSeq(JSPUtil.getParameter(request, prefix + "spcl_cntr_seq", ""));
        setTtlDimHgt(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setCgoLclFlg(JSPUtil.getParameter(request, prefix + "cgo_lcl_flg", ""));
        setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
        setTtlDimLen(JSPUtil.getParameter(request, prefix + "ttl_dim_len", ""));
        setCgoRqstDt(JSPUtil.getParameter(request, prefix + "cgo_rqst_dt", ""));
        setEmerRspnGidChrNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_chr_no", ""));
        setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
        setEmerTempCtnt(JSPUtil.getParameter(request, prefix + "emer_temp_ctnt", ""));
        setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
        setRtSdOvrDimLen(JSPUtil.getParameter(request, prefix + "rt_sd_ovr_dim_len", ""));
        setSpclCgoSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_seq", ""));
        setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
        setRadaTrspNo(JSPUtil.getParameter(request, prefix + "rada_trsp_no", ""));
        setMaxInPckTpCd(JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", ""));
        setRadaUtCd(JSPUtil.getParameter(request, prefix + "rada_ut_cd", ""));
        setIntmdN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_desc", ""));
        setImdgExptQtyCd(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_cd", ""));
        setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setOutN1stImdgPckQty(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_qty", ""));
        setHcdgPckRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_pck_rstr_desc", ""));
        setInN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_desc", ""));
        setIntmdN2ndImdgPckCd(JSPUtil.getParameter(request, prefix + "intmd_n2nd_imdg_pck_cd", ""));
        setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
        setN2ndImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_subs_rsk_lbl_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setClodFlg(JSPUtil.getParameter(request, prefix + "clod_flg", ""));
        setBkwdOvrDimLen(JSPUtil.getParameter(request, prefix + "bkwd_ovr_dim_len", ""));
        setImdgCoGrpCd(JSPUtil.getParameter(request, prefix + "imdg_co_grp_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setCtrlTempCtnt(JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc", ""));
        setOutN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_desc", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
        setCfrFlg(JSPUtil.getParameter(request, prefix + "cfr_flg", ""));
        setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
        setEdiTrsmStsCd(JSPUtil.getParameter(request, prefix + "edi_trsm_sts_cd", ""));
        setImdgSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", ""));
        setRsdFlg(JSPUtil.getParameter(request, prefix + "rsd_flg", ""));
        setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
        setOrgDcgoRefNo(JSPUtil.getParameter(request, prefix + "org_dcgo_ref_no", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc1", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc2", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc3", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc4", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", ""));
        setImdgAmdtNo(JSPUtil.getParameter(request, prefix + "imdg_amdt_no", ""));
        setImdgTecNm(JSPUtil.getParameter(request, prefix + "imdg_tec_nm", ""));
        setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
        setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
        setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
        setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
        setEdiItmSeq(JSPUtil.getParameter(request, prefix + "edi_itm_seq", ""));
        setEdiUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", ""));
        setEdiUnmapCorrRmk(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rmk", ""));
        setUnmapCntrTpszCd(JSPUtil.getParameter(request, prefix + "unmap_cntr_tpsz_cd", ""));
        setAllAproStsCd(JSPUtil.getParameter(request, prefix + "all_apro_sts_cd", ""));
        setN5thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n5th_imdg_subs_rsk_lbl_cd", ""));
        setN6thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n6th_imdg_subs_rsk_lbl_cd", ""));
        setN7thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n7th_imdg_subs_rsk_lbl_cd", ""));
        setN8thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n8th_imdg_subs_rsk_lbl_cd", ""));
        setImdgLmtQtyDesc(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_desc", ""));
        setImdgExptQtyDesc(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_desc", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrAproRqstCgoVO[]
	 */
    public ScgPrnrAproRqstCgoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrAproRqstCgoVO[]
	 */
    public ScgPrnrAproRqstCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgPrnrAproRqstCgoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] n3rdImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n3rd_imdg_subs_rsk_lbl_cd", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] imdgSubsRskLblRmk = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_rmk", length));
            String[] radaSkdNo = (JSPUtil.getParameter(request, prefix + "rada_skd_no", length));
            String[] n4thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n4th_imdg_subs_rsk_lbl_cd", length));
            String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] hcdgFlg = (JSPUtil.getParameter(request, prefix + "hcdg_flg", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] hcdgIntmdBcRstrDesc = (JSPUtil.getParameter(request, prefix + "hcdg_intmd_bc_rstr_desc", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] voidSltQty = (JSPUtil.getParameter(request, prefix + "void_slt_qty", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] hgtOvrDimLen = (JSPUtil.getParameter(request, prefix + "hgt_ovr_dim_len", length));
            String[] intmdN2ndImdgPckDesc = (JSPUtil.getParameter(request, prefix + "intmd_n2nd_imdg_pck_desc", length));
            String[] radaAmt = (JSPUtil.getParameter(request, prefix + "rada_amt", length));
            String[] netExploWgt = (JSPUtil.getParameter(request, prefix + "net_explo_wgt", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] awkFlg = (JSPUtil.getParameter(request, prefix + "awk_flg", length));
            String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", length));
            String[] authUsrId = (JSPUtil.getParameter(request, prefix + "auth_usr_id", length));
            String[] cneeDtlDesc = (JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] emerCntcPhnNo = (JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", length));
            String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", length));
            String[] measTpCd = (JSPUtil.getParameter(request, prefix + "meas_tp_cd", length));
            String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", length));
            String[] imdgLmtQtyMeasUtCd = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_meas_ut_cd", length));
            String[] intmdN2ndImdgPckQty = (JSPUtil.getParameter(request, prefix + "intmd_n2nd_imdg_pck_qty", length));
            String[] intmdN1stImdgPckQty = (JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_qty", length));
            String[] n1stImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n1st_imdg_subs_rsk_lbl_cd", length));
            String[] imdgLmtQty = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty", length));
            String[] inN1stImdgPckCd = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_cd", length));
            String[] outN2ndImdgPckQty = (JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_qty", length));
            String[] emsNo = (JSPUtil.getParameter(request, prefix + "ems_no", length));
            String[] maxInPckQty = (JSPUtil.getParameter(request, prefix + "max_in_pck_qty", length));
            String[] inN2ndImdgPckDesc = (JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_desc", length));
            String[] intmdN1stImdgPckCd = (JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] outN2ndImdgPckDesc = (JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_desc", length));
            String[] authStsCd = (JSPUtil.getParameter(request, prefix + "auth_sts_cd", length));
            String[] outN1stImdgPckCd = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", length));
            String[] psaNo = (JSPUtil.getParameter(request, prefix + "psa_no", length));
            String[] inN2ndImdgPckQty = (JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_qty", length));
            String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", length));
            String[] emerCntcPsonNm = (JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", length));
            String[] outN2ndImdgPckCd = (JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_cd", length));
            String[] imdgSpclProviNo = (JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] lfSdOvrDimLen = (JSPUtil.getParameter(request, prefix + "lf_sd_ovr_dim_len", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] inN2ndImdgPckCd = (JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_cd", length));
            String[] fwrdOvrDimLen = (JSPUtil.getParameter(request, prefix + "fwrd_ovr_dim_len", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] inN1stImdgPckQty = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_qty", length));
            String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix + "mrn_polut_flg", length));
            String[] cntrRefNo = (JSPUtil.getParameter(request, prefix + "cntr_ref_no", length));
            String[] authDt = (JSPUtil.getParameter(request, prefix + "auth_dt", length));
            String[] netWgt = (JSPUtil.getParameter(request, prefix + "net_wgt", length));
            String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix + "spcl_cntr_seq", length));
            String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] cgoLclFlg = (JSPUtil.getParameter(request, prefix + "cgo_lcl_flg", length));
            String[] hzdDesc = (JSPUtil.getParameter(request, prefix + "hzd_desc", length));
            String[] ttlDimLen = (JSPUtil.getParameter(request, prefix + "ttl_dim_len", length));
            String[] cgoRqstDt = (JSPUtil.getParameter(request, prefix + "cgo_rqst_dt", length));
            String[] emerRspnGidChrNo = (JSPUtil.getParameter(request, prefix + "emer_rspn_gid_chr_no", length));
            String[] aproRefNo = (JSPUtil.getParameter(request, prefix + "apro_ref_no", length));
            String[] emerTempCtnt = (JSPUtil.getParameter(request, prefix + "emer_temp_ctnt", length));
            String[] grsWgt = (JSPUtil.getParameter(request, prefix + "grs_wgt", length));
            String[] rtSdOvrDimLen = (JSPUtil.getParameter(request, prefix + "rt_sd_ovr_dim_len", length));
            String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_seq", length));
            String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
            String[] radaTrspNo = (JSPUtil.getParameter(request, prefix + "rada_trsp_no", length));
            String[] maxInPckTpCd = (JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", length));
            String[] radaUtCd = (JSPUtil.getParameter(request, prefix + "rada_ut_cd", length));
            String[] intmdN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "intmd_n1st_imdg_pck_desc", length));
            String[] imdgExptQtyCd = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_cd", length));
            String[] certiNo = (JSPUtil.getParameter(request, prefix + "certi_no", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] outN1stImdgPckQty = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_qty", length));
            String[] hcdgPckRstrDesc = (JSPUtil.getParameter(request, prefix + "hcdg_pck_rstr_desc", length));
            String[] inN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_desc", length));
            String[] intmdN2ndImdgPckCd = (JSPUtil.getParameter(request, prefix + "intmd_n2nd_imdg_pck_cd", length));
            String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", length));
            String[] n2ndImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n2nd_imdg_subs_rsk_lbl_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] clodFlg = (JSPUtil.getParameter(request, prefix + "clod_flg", length));
            String[] bkwdOvrDimLen = (JSPUtil.getParameter(request, prefix + "bkwd_ovr_dim_len", length));
            String[] imdgCoGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_co_grp_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no", length));
            String[] dgFlg = (JSPUtil.getParameter(request, prefix + "dg_flg", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] ctrlTempCtnt = (JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", length));
            String[] hcdgTnkRstrDesc = (JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc", length));
            String[] outN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_desc", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", length));
            String[] cfrFlg = (JSPUtil.getParameter(request, prefix + "cfr_flg", length));
            String[] refNo = (JSPUtil.getParameter(request, prefix + "ref_no", length));
            String[] ediTrsmStsCd = (JSPUtil.getParameter(request, prefix + "edi_trsm_sts_cd", length));
            String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", length));
            String[] rsdFlg = (JSPUtil.getParameter(request, prefix + "rsd_flg", length));
            String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix + "dcgo_ref_no", length));
            String[] orgDcgoRefNo = (JSPUtil.getParameter(request, prefix + "org_dcgo_ref_no", length));
            String[] hcdgTnkRstrDesc1 = (JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc1", length));
            String[] hcdgTnkRstrDesc2 = (JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc2", length));
            String[] hcdgTnkRstrDesc3 = (JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc3", length));
            String[] hcdgTnkRstrDesc4 = (JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc4", length));
            String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", length));
            String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", length));
            String[] imdgAmdtNo = (JSPUtil.getParameter(request, prefix + "imdg_amdt_no", length));
            String[] imdgTecNm = (JSPUtil.getParameter(request, prefix + "imdg_tec_nm", length));
            String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", length));
            String[] trsmDt = (JSPUtil.getParameter(request, prefix + "trsm_dt", length));
            String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", length));
            String[] dcgoSeq = (JSPUtil.getParameter(request, prefix + "dcgo_seq", length));
            String[] ediItemSeq = (JSPUtil.getParameter(request, prefix + "edi_item_seq", length));
            String[] ediItmSeq = (JSPUtil.getParameter(request, prefix + "edi_itm_seq", length));
            String[] ediUnmapDtlCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", length));
            String[] ediUnmapCorrRmk = (JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rmk", length));
            String[] unmapCntrTpszCd = (JSPUtil.getParameter(request, prefix + "unmap_cntr_tpsz_cd", length));
            String[] allAproStsCd = (JSPUtil.getParameter(request, prefix + "all_apro_sts_cd", length));
            String[] n5thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n5th_imdg_subs_rsk_lbl_cd", length));
            String[] n6thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n6th_imdg_subs_rsk_lbl_cd", length));
            String[] n7thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n7th_imdg_subs_rsk_lbl_cd", length));
            String[] n8thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n8th_imdg_subs_rsk_lbl_cd", length));
            String[] imdgLmtQtyDesc = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_desc", length));
	    	String[] imdgExptQtyDesc = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_desc", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgPrnrAproRqstCgoVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (n3rdImdgSubsRskLblCd[i] != null)
                    model.setN3rdImdgSubsRskLblCd(n3rdImdgSubsRskLblCd[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (imdgSubsRskLblRmk[i] != null)
                    model.setImdgSubsRskLblRmk(imdgSubsRskLblRmk[i]);
                if (radaSkdNo[i] != null)
                    model.setRadaSkdNo(radaSkdNo[i]);
                if (n4thImdgSubsRskLblCd[i] != null)
                    model.setN4thImdgSubsRskLblCd(n4thImdgSubsRskLblCd[i]);
                if (imdgCompGrpCd[i] != null)
                    model.setImdgCompGrpCd(imdgCompGrpCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (hcdgFlg[i] != null)
                    model.setHcdgFlg(hcdgFlg[i]);
                if (authOfcCd[i] != null)
                    model.setAuthOfcCd(authOfcCd[i]);
                if (hcdgIntmdBcRstrDesc[i] != null)
                    model.setHcdgIntmdBcRstrDesc(hcdgIntmdBcRstrDesc[i]);
                if (spclCgoCateCd[i] != null)
                    model.setSpclCgoCateCd(spclCgoCateCd[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (voidSltQty[i] != null)
                    model.setVoidSltQty(voidSltQty[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (hgtOvrDimLen[i] != null)
                    model.setHgtOvrDimLen(hgtOvrDimLen[i]);
                if (intmdN2ndImdgPckDesc[i] != null)
                    model.setIntmdN2ndImdgPckDesc(intmdN2ndImdgPckDesc[i]);
                if (radaAmt[i] != null)
                    model.setRadaAmt(radaAmt[i]);
                if (netExploWgt[i] != null)
                    model.setNetExploWgt(netExploWgt[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (awkFlg[i] != null)
                    model.setAwkFlg(awkFlg[i]);
                if (emerRspnGidNo[i] != null)
                    model.setEmerRspnGidNo(emerRspnGidNo[i]);
                if (authUsrId[i] != null)
                    model.setAuthUsrId(authUsrId[i]);
                if (cneeDtlDesc[i] != null)
                    model.setCneeDtlDesc(cneeDtlDesc[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (emerCntcPhnNo[i] != null)
                    model.setEmerCntcPhnNo(emerCntcPhnNo[i]);
                if (imdgPckGrpCd[i] != null)
                    model.setImdgPckGrpCd(imdgPckGrpCd[i]);
                if (measTpCd[i] != null)
                    model.setMeasTpCd(measTpCd[i]);
                if (flshPntCdoTemp[i] != null)
                    model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
                if (imdgLmtQtyMeasUtCd[i] != null)
                    model.setImdgLmtQtyMeasUtCd(imdgLmtQtyMeasUtCd[i]);
                if (intmdN2ndImdgPckQty[i] != null)
                    model.setIntmdN2ndImdgPckQty(intmdN2ndImdgPckQty[i]);
                if (intmdN1stImdgPckQty[i] != null)
                    model.setIntmdN1stImdgPckQty(intmdN1stImdgPckQty[i]);
                if (n1stImdgSubsRskLblCd[i] != null)
                    model.setN1stImdgSubsRskLblCd(n1stImdgSubsRskLblCd[i]);
                if (imdgLmtQty[i] != null)
                    model.setImdgLmtQty(imdgLmtQty[i]);
                if (inN1stImdgPckCd[i] != null)
                    model.setInN1stImdgPckCd(inN1stImdgPckCd[i]);
                if (outN2ndImdgPckQty[i] != null)
                    model.setOutN2ndImdgPckQty(outN2ndImdgPckQty[i]);
                if (emsNo[i] != null)
                    model.setEmsNo(emsNo[i]);
                if (maxInPckQty[i] != null)
                    model.setMaxInPckQty(maxInPckQty[i]);
                if (inN2ndImdgPckDesc[i] != null)
                    model.setInN2ndImdgPckDesc(inN2ndImdgPckDesc[i]);
                if (intmdN1stImdgPckCd[i] != null)
                    model.setIntmdN1stImdgPckCd(intmdN1stImdgPckCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (spclStwgRqstDesc[i] != null)
                    model.setSpclStwgRqstDesc(spclStwgRqstDesc[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (diffRmk[i] != null)
                    model.setDiffRmk(diffRmk[i]);
                if (outN2ndImdgPckDesc[i] != null)
                    model.setOutN2ndImdgPckDesc(outN2ndImdgPckDesc[i]);
                if (authStsCd[i] != null)
                    model.setAuthStsCd(authStsCd[i]);
                if (outN1stImdgPckCd[i] != null)
                    model.setOutN1stImdgPckCd(outN1stImdgPckCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (ttlDimWdt[i] != null)
                    model.setTtlDimWdt(ttlDimWdt[i]);
                if (psaNo[i] != null)
                    model.setPsaNo(psaNo[i]);
                if (inN2ndImdgPckQty[i] != null)
                    model.setInN2ndImdgPckQty(inN2ndImdgPckQty[i]);
                if (dcgoStsCd[i] != null)
                    model.setDcgoStsCd(dcgoStsCd[i]);
                if (emerCntcPsonNm[i] != null)
                    model.setEmerCntcPsonNm(emerCntcPsonNm[i]);
                if (outN2ndImdgPckCd[i] != null)
                    model.setOutN2ndImdgPckCd(outN2ndImdgPckCd[i]);
                if (imdgSpclProviNo[i] != null)
                    model.setImdgSpclProviNo(imdgSpclProviNo[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (lfSdOvrDimLen[i] != null)
                    model.setLfSdOvrDimLen(lfSdOvrDimLen[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (inN2ndImdgPckCd[i] != null)
                    model.setInN2ndImdgPckCd(inN2ndImdgPckCd[i]);
                if (fwrdOvrDimLen[i] != null)
                    model.setFwrdOvrDimLen(fwrdOvrDimLen[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (inN1stImdgPckQty[i] != null)
                    model.setInN1stImdgPckQty(inN1stImdgPckQty[i]);
                if (mrnPolutFlg[i] != null)
                    model.setMrnPolutFlg(mrnPolutFlg[i]);
                if (cntrRefNo[i] != null)
                    model.setCntrRefNo(cntrRefNo[i]);
                if (authDt[i] != null)
                    model.setAuthDt(authDt[i]);
                if (netWgt[i] != null)
                    model.setNetWgt(netWgt[i]);
                if (spclCntrSeq[i] != null)
                    model.setSpclCntrSeq(spclCntrSeq[i]);
                if (ttlDimHgt[i] != null)
                    model.setTtlDimHgt(ttlDimHgt[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (cgoLclFlg[i] != null)
                    model.setCgoLclFlg(cgoLclFlg[i]);
                if (hzdDesc[i] != null)
                    model.setHzdDesc(hzdDesc[i]);
                if (ttlDimLen[i] != null)
                    model.setTtlDimLen(ttlDimLen[i]);
                if (cgoRqstDt[i] != null)
                    model.setCgoRqstDt(cgoRqstDt[i]);
                if (emerRspnGidChrNo[i] != null)
                    model.setEmerRspnGidChrNo(emerRspnGidChrNo[i]);
                if (aproRefNo[i] != null)
                    model.setAproRefNo(aproRefNo[i]);
                if (emerTempCtnt[i] != null)
                    model.setEmerTempCtnt(emerTempCtnt[i]);
                if (grsWgt[i] != null)
                    model.setGrsWgt(grsWgt[i]);
                if (rtSdOvrDimLen[i] != null)
                    model.setRtSdOvrDimLen(rtSdOvrDimLen[i]);
                if (spclCgoSeq[i] != null)
                    model.setSpclCgoSeq(spclCgoSeq[i]);
                if (creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if (radaTrspNo[i] != null)
                    model.setRadaTrspNo(radaTrspNo[i]);
                if (maxInPckTpCd[i] != null)
                    model.setMaxInPckTpCd(maxInPckTpCd[i]);
                if (radaUtCd[i] != null)
                    model.setRadaUtCd(radaUtCd[i]);
                if (intmdN1stImdgPckDesc[i] != null)
                    model.setIntmdN1stImdgPckDesc(intmdN1stImdgPckDesc[i]);
                if (imdgExptQtyCd[i] != null)
                    model.setImdgExptQtyCd(imdgExptQtyCd[i]);
                if (certiNo[i] != null)
                    model.setCertiNo(certiNo[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (outN1stImdgPckQty[i] != null)
                    model.setOutN1stImdgPckQty(outN1stImdgPckQty[i]);
                if (hcdgPckRstrDesc[i] != null)
                    model.setHcdgPckRstrDesc(hcdgPckRstrDesc[i]);
                if (inN1stImdgPckDesc[i] != null)
                    model.setInN1stImdgPckDesc(inN1stImdgPckDesc[i]);
                if (intmdN2ndImdgPckCd[i] != null)
                    model.setIntmdN2ndImdgPckCd(intmdN2ndImdgPckCd[i]);
                if (imdgExptQtyFlg[i] != null)
                    model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
                if (n2ndImdgSubsRskLblCd[i] != null)
                    model.setN2ndImdgSubsRskLblCd(n2ndImdgSubsRskLblCd[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (clodFlg[i] != null)
                    model.setClodFlg(clodFlg[i]);
                if (bkwdOvrDimLen[i] != null)
                    model.setBkwdOvrDimLen(bkwdOvrDimLen[i]);
                if (imdgCoGrpCd[i] != null)
                    model.setImdgCoGrpCd(imdgCoGrpCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (dgFlg[i] != null)
                    model.setDgFlg(dgFlg[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (ctrlTempCtnt[i] != null)
                    model.setCtrlTempCtnt(ctrlTempCtnt[i]);
                if (hcdgTnkRstrDesc[i] != null)
                    model.setHcdgTnkRstrDesc(hcdgTnkRstrDesc[i]);
                if (outN1stImdgPckDesc[i] != null)
                    model.setOutN1stImdgPckDesc(outN1stImdgPckDesc[i]);
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (imdgLmtQtyFlg[i] != null)
                    model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
                if (cfrFlg[i] != null)
                    model.setCfrFlg(cfrFlg[i]);
                if (refNo[i] != null)
                    model.setRefNo(refNo[i]);
                if (ediTrsmStsCd[i] != null)
                    model.setEdiTrsmStsCd(ediTrsmStsCd[i]);
                if (imdgSegrGrpNo[i] != null)
                    model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);
                if (rsdFlg[i] != null)
                    model.setRsdFlg(rsdFlg[i]);
                if (dcgoRefNo[i] != null)
                    model.setDcgoRefNo(dcgoRefNo[i]);
                if (orgDcgoRefNo[i] != null)
                    model.setOrgDcgoRefNo(orgDcgoRefNo[i]);
                if (spclCgoAuthRjctCd[i] != null)
                    model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
                if (spclCgoAuthRmk[i] != null)
                    model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
                if (imdgAmdtNo[i] != null)
                    model.setImdgAmdtNo(imdgAmdtNo[i]);
                if (imdgTecNm[i] != null)
                    model.setImdgTecNm(imdgTecNm[i]);
                if (prnrCgoRqstSeq[i] != null)
                    model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
                if (trsmDt[i] != null)
                    model.setTrsmDt(trsmDt[i]);
                if (prnrSpclCgoSeq[i] != null)
                    model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
                if (dcgoSeq[i] != null)
                    model.setDcgoSeq(dcgoSeq[i]);
                if (ediItmSeq[i] != null)
                    model.setEdiItmSeq(ediItmSeq[i]);
                if (ediUnmapDtlCd[i] != null)
                    model.setEdiUnmapDtlCd(ediUnmapDtlCd[i]);
                if (ediUnmapCorrRmk[i] != null)
                    model.setEdiUnmapCorrRmk(ediUnmapCorrRmk[i]);
                if (unmapCntrTpszCd[i] != null)
                    model.setUnmapCntrTpszCd(unmapCntrTpszCd[i]);
                if (allAproStsCd[i] != null)
                    model.setAllAproStsCd(allAproStsCd[i]);
                if (n5thImdgSubsRskLblCd[i] != null)
                    model.setN5thImdgSubsRskLblCd(n5thImdgSubsRskLblCd[i]);
                if (n6thImdgSubsRskLblCd[i] != null)
                    model.setN6thImdgSubsRskLblCd(n6thImdgSubsRskLblCd[i]);
                if (n7thImdgSubsRskLblCd[i] != null)
                    model.setN7thImdgSubsRskLblCd(n7thImdgSubsRskLblCd[i]);
                if (n8thImdgSubsRskLblCd[i] != null)
                    model.setN8thImdgSubsRskLblCd(n8thImdgSubsRskLblCd[i]);
                if (imdgLmtQtyDesc[i] != null) 
		    		model.setImdgLmtQtyDesc(imdgLmtQtyDesc[i]);
				if (imdgExptQtyDesc[i] != null) 
		    		model.setImdgExptQtyDesc(imdgExptQtyDesc[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgPrnrAproRqstCgoVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ScgPrnrAproRqstCgoVO[]
	 */
    public ScgPrnrAproRqstCgoVO[] getScgPrnrAproRqstCgoVOs() {
        ScgPrnrAproRqstCgoVO[] vos = (ScgPrnrAproRqstCgoVO[]) models.toArray(new ScgPrnrAproRqstCgoVO[models.size()]);
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
        this.n3rdImdgSubsRskLblCd = this.n3rdImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoRqstSeq = this.spclCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblRmk = this.imdgSubsRskLblRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaSkdNo = this.radaSkdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n4thImdgSubsRskLblCd = this.n4thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCompGrpCd = this.imdgCompGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgFlg = this.hcdgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgIntmdBcRstrDesc = this.hcdgIntmdBcRstrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voidSltQty = this.voidSltQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hgtOvrDimLen = this.hgtOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN2ndImdgPckDesc = this.intmdN2ndImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaAmt = this.radaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExploWgt = this.netExploWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkFlg = this.awkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerRspnGidNo = this.emerRspnGidNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authUsrId = this.authUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeDtlDesc = this.cneeDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPhnNo = this.emerCntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCd = this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measTpCd = this.measTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntCdoTemp = this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyMeasUtCd = this.imdgLmtQtyMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN2ndImdgPckQty = this.intmdN2ndImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN1stImdgPckQty = this.intmdN1stImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stImdgSubsRskLblCd = this.n1stImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQty = this.imdgLmtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckCd = this.inN1stImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN2ndImdgPckQty = this.outN2ndImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emsNo = this.emsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxInPckQty = this.maxInPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN2ndImdgPckDesc = this.inN2ndImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN1stImdgPckCd = this.intmdN1stImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclStwgRqstDesc = this.spclStwgRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN2ndImdgPckDesc = this.outN2ndImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authStsCd = this.authStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckCd = this.outN1stImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimWdt = this.ttlDimWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psaNo = this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN2ndImdgPckQty = this.inN2ndImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoStsCd = this.dcgoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPsonNm = this.emerCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN2ndImdgPckCd = this.outN2ndImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSpclProviNo = this.imdgSpclProviNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lfSdOvrDimLen = this.lfSdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN2ndImdgPckCd = this.inN2ndImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fwrdOvrDimLen = this.fwrdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckQty = this.inN1stImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnPolutFlg = this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrRefNo = this.cntrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authDt = this.authDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgt = this.netWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCntrSeq = this.spclCntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimHgt = this.ttlDimHgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoLclFlg = this.cgoLclFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hzdDesc = this.hzdDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimLen = this.ttlDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoRqstDt = this.cgoRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerRspnGidChrNo = this.emerRspnGidChrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerTempCtnt = this.emerTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.grsWgt = this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtSdOvrDimLen = this.rtSdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoSeq = this.spclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaTrspNo = this.radaTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxInPckTpCd = this.maxInPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaUtCd = this.radaUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN1stImdgPckDesc = this.intmdN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyCd = this.imdgExptQtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.certiNo = this.certiNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckQty = this.outN1stImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgPckRstrDesc = this.hcdgPckRstrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckDesc = this.inN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.intmdN2ndImdgPckCd = this.intmdN2ndImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyFlg = this.imdgExptQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndImdgSubsRskLblCd = this.n2ndImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clodFlg = this.clodFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkwdOvrDimLen = this.bkwdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCoGrpCd = this.imdgCoGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgFlg = this.dgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlTempCtnt = this.ctrlTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgTnkRstrDesc = this.hcdgTnkRstrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckDesc = this.outN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyFlg = this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cfrFlg = this.cfrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.refNo = this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediTrsmStsCd = this.ediTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNo = this.imdgSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsdFlg = this.rsdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRefNo = this.dcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgDcgoRefNo = this.orgDcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRmk = this.spclCgoAuthRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgAmdtNo = this.imdgAmdtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgTecNm = this.imdgTecNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrCgoRqstSeq = this.prnrCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmDt = this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSeq = this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoSeq = this.dcgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediItmSeq = this.ediItmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapDtlCd = this.ediUnmapDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapCorrRmk = this.ediUnmapCorrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.unmapCntrTpszCd = this.unmapCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.allAproStsCd = this.allAproStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n5thImdgSubsRskLblCd = this.n5thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n6thImdgSubsRskLblCd = this.n6thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n7thImdgSubsRskLblCd = this.n7thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n8thImdgSubsRskLblCd = this.n8thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyDesc = this.imdgLmtQtyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyDesc = this.imdgExptQtyDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
 