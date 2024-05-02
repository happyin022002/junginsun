/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PartnerApprovalRequestVO.java
 *@FileTitle : PartnerApprovalRequestVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.01
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.01 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
public class PartnerApprovalRequestVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PartnerApprovalRequestVO> models = new ArrayList<PartnerApprovalRequestVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /*	Column Info	*/
    private String n3rdImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String spclCgoRqstSeq = null;

    /*	Column Info	*/
    private String etaDt = null;

    /*	Column Info	*/
    private String imdgUnNoSeq = null;

    /*	Column Info	*/
    private String imdgAmdtNo = null;

    /*	Column Info	*/
    private String imdgSubsRskLblRmk = null;

    /*	Column Info	*/
    private String scgFlg = null;

    /*	Column Info	*/
    private String radaSkdNo = null;

    /*	Column Info	*/
    private String n4thImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String imdgCompGrpCd = null;

    /*	Column Info	*/
    private String toEtaDt = null;

    /*	Column Info	*/
    private String cntrTpszCd = null;

    /*	Column Info	*/
    private String hcdgFlg = null;

    /*	Column Info	*/
    private String imdgUnNo = null;

    /*	Column Info	*/
    private String updUsrId = null;

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
    private String podClptIndSeq = null;

    /*	Column Info	*/
    private String hgtOvrDimLen = null;

    /*	Column Info	*/
    private String radaAmt = null;

    /*	Column Info	*/
    private String cmdtDesc = null;

    /*	Column Info	*/
    private String netExploWgt = null;

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
    private String authFlg = null;

    /*	Column Info	*/
    private String emerCntcPhnNo = null;

    /*	Column Info	*/
    private String measTpCd = null;

    /*	Column Info	*/
    private String imdgPckGrpCd = null;

    /*	Column Info	*/
    private String flshPntCdoTemp = null;

    /*	Column Info	*/
    private String imdgLmtQtyMeasUtCd = null;

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
    private String pckTpCd = null;

    /*	Column Info	*/
    private String imdgSubsRskLblCd = null;

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
    private String vslNm = null;

    /*	Column Info	*/
    private String ttlDimWdt = null;

    /*	Column Info	*/
    private String psaNo = null;

    /*	Column Info	*/
    private String inN2ndImdgPckQty = null;

    /*	Column Info	*/
    private String netWgtSum = null;

    /*	Column Info	*/
    private String dcgoStsCd = null;

    /*	Column Info	*/
    private String emerCntcPsonNm = null;

    /*	Column Info	*/
    private String imdgSpclProviNo = null;

    /*	Column Info	*/
    private String outN2ndImdgPckCd = null;

    /*	Column Info	*/
    private String crrCd = null;

    /*	Column Info	*/
    private String lfSdOvrDimLen = null;

    /*	Column Info	*/
    private String polCd = null;

    /*	Column Info	*/
    private String polClptIndSeq = null;

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
    private String rgnShpOprCd = null;

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
    private String slanCd1 = null;

    /*	Column Info	*/
    private String radaTrspNo = null;

    /*	Column Info	*/
    private String radaUtCd = null;

    /*	Column Info	*/
    private String maxInPckTpCd = null;

    /*	Column Info	*/
    private String wgtUtCd2 = null;

    /*	Column Info	*/
    private String imdgExptQtyCd = null;

    /*	Column Info	*/
    private String certiNo = null;

    /*	Column Info	*/
    private String measQty = null;

    /*	Column Info	*/
    private String pckQty = null;

    /*	Column Info	*/
    private String fromEtaDt = null;

    /*	Column Info	*/
    private String outN1stImdgPckQty = null;

    /*	Column Info	*/
    private String hcdgPckRstrDesc = null;

    /*	Column Info	*/
    private String inN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String imdgExptQtyFlg = null;

    /*	Column Info	*/
    private String n2ndImdgSubsRskLblCd = null;

    /*	Column Info	*/
    private String updDt = null;

    /*	Column Info	*/
    private String clodFlg = null;

    /*	Column Info	*/
    private String bookingNo = null;

    /*	Column Info	*/
    private String stsCt = null;

    /*	Column Info	*/
    private String bkwdOvrDimLen = null;

    /*	Column Info	*/
    private String imdgCoGrpCd = null;

    /*	Column Info	*/
    private String skdDirCd = null;

    /*	Column Info	*/
    private String bkgRefNo = null;

    /*	Column Info	*/
    private String cgoOprCd = null;

    /*	Column Info	*/
    private String dgFlg = null;

    /*	Column Info	*/
    private String ctrlTempCtnt = null;

    /*	Column Info	*/
    private String hcdgTnkRstrDesc = null;

    /*	Column Info	*/
    private String prpShpNm = null;

    /*	Column Info	*/
    private String outN1stImdgPckDesc = null;

    /*	Column Info	*/
    private String imdgLmtQtyFlg = null;

    /*	Column Info	*/
    private String slanCd2 = null;

    /*	Column Info	*/
    private String slanCd3 = null;

    /*	Column Info	*/
    private String slanCd4 = null;

    /*	Column Info	*/
    private String slanCd5 = null;

    /*	Column Info	*/
    private String slanCd6 = null;

    /*	Column Info	*/
    private String slanCd7 = null;

    /*	Column Info	*/
    private String slanCd8 = null;

    /*	Column Info	*/
    private String slanCd9 = null;

    /*	Column Info	*/
    private String slanCd10 = null;

    /*	Column Info	*/
    private String slanCd11 = null;

    /*	Column Info	*/
    private String vpsEtaDt = null;

    /*	Column Info	*/
    private String imdgSegrGrpNm = null;

    /*	Column Info	*/
    private String imdgSegrGrpNo = null;

    /*	Column Info	*/
    private String stgCate = null;

    /*	Column Info	*/
    private String ediTrsmStsCd = null;

    /*	Column Info	*/
    private String srcTpCd = null;

    /*	Column Info	*/
    private String rsdFlg = null;

    /* Column Info */
    private String dcgoRefNo = null;

    /* Column Info */
    private String spclCgoAuthRjctCd = null;

    /* Column Info */
    private String spclCgoAuthRmk = null;

    /*	Column Info	*/
    private String emlSndHisFlg = null;

    /*	Column Info	*/
    private String ediSndHisFlg = null;

    /*	Column Info	*/
    private String itmStsCd = null;

    /* VO Info */
    private ScgPrnrAproRqstVO scgPrnrAproRqstVO = null;

    /* VO Info */
    private List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOl = null;

    /* VO Info */
    private List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOl = null;

    /* VO Info */
    private ScgPrnrAproRqstVO[] scgPrnrAproRqstVOs = null;

    /* VO Info */
    private ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs = null;

    /* VO Info */
    private ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs = null;

    /* Column Info */
    private String trsmDt = null;

    /* Column Info */
    private String prnrSpclCgoSeq = null;

    /* Column Info */
    private String prnrCgoRqstSeq = null;

    /* Column Info */
    private String ediUnmapKndCd = null;

    /* Column Info */
    private String updIndicator = null;

    /* Column Info */
    private String ediUnmapDtlCd = null;
    
	/*	Column Info	*/
	private String srchType = null;

	/*	Column Info	*/
	private String spclCgoQty = null;
	
    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    private String mode = "";

    /* 검색조건 : Manual/EDI, request Date */
    private HashMap<String, String> searchCondition = new HashMap<String, String>();

    /**	Constructor	*/
    public PartnerApprovalRequestVO() {
    }

    public PartnerApprovalRequestVO(String ibflag, String pagerows, String n3rdImdgSubsRskLblCd, String spclCgoRqstSeq, String etaDt, String imdgUnNoSeq, String imdgAmdtNo, String imdgSubsRskLblRmk, String scgFlg, String radaSkdNo, String n4thImdgSubsRskLblCd, String imdgCompGrpCd, String toEtaDt, String cntrTpszCd, String hcdgFlg, String imdgUnNo, String updUsrId, String authOfcCd, String hcdgIntmdBcRstrDesc, String spclCgoCateCd, String skdVoyNo, String voidSltQty, String podCd, String podClptIndSeq, String hgtOvrDimLen, String radaAmt, String cmdtDesc, String netExploWgt, String awkFlg, String emerRspnGidNo, String authUsrId, String cneeDtlDesc, String imdgClssCd, String authFlg, String emerCntcPhnNo, String measTpCd, String imdgPckGrpCd, String flshPntCdoTemp, String imdgLmtQtyMeasUtCd, String n1stImdgSubsRskLblCd, String imdgLmtQty, String inN1stImdgPckCd, String outN2ndImdgPckQty, String emsNo, String maxInPckQty, String inN2ndImdgPckDesc, String pckTpCd, String imdgSubsRskLblCd, String spclStwgRqstDesc, String slanCd, String diffRmk, String outN2ndImdgPckDesc, String authStsCd, String outN1stImdgPckCd, String vslCd, String vslNm, String ttlDimWdt, String psaNo, String inN2ndImdgPckQty, String netWgtSum, String dcgoStsCd, String emerCntcPsonNm, String imdgSpclProviNo, String outN2ndImdgPckCd, String crrCd, String lfSdOvrDimLen, String polCd, String polClptIndSeq, String inN2ndImdgPckCd, String fwrdOvrDimLen, String wgtUtCd, String inN1stImdgPckQty, String mrnPolutFlg, String cntrRefNo, String rgnShpOprCd, String authDt, String netWgt, String spclCntrSeq, String ttlDimHgt, String creUsrId, String cgoLclFlg, String hzdDesc, String ttlDimLen, String cgoRqstDt, String emerRspnGidChrNo, String aproRefNo, String emerTempCtnt, String grsWgt, String rtSdOvrDimLen, String spclCgoSeq, String slanCd1, String radaTrspNo, String radaUtCd, String maxInPckTpCd, String wgtUtCd2, String imdgExptQtyCd, String certiNo, String measQty, String pckQty, String fromEtaDt, String outN1stImdgPckQty, String hcdgPckRstrDesc, String inN1stImdgPckDesc, String imdgExptQtyFlg, String n2ndImdgSubsRskLblCd, String updDt, String clodFlg, String bookingNo, String stsCt, String bkwdOvrDimLen, String imdgCoGrpCd, String skdDirCd, String bkgRefNo, String cgoOprCd, String dgFlg, String ctrlTempCtnt, String hcdgTnkRstrDesc, String prpShpNm, String outN1stImdgPckDesc, String imdgLmtQtyFlg, String slanCd2, String slanCd3, String slanCd4, String slanCd5, String slanCd6, String slanCd7, String slanCd8, String slanCd9, String slanCd10, String slanCd11, String vpsEtaDt, String imdgSegrGrpNm, String imdgSegrGrpNo, String stgCate, String ediTrsmStsCd, String srcTpCd, String rsdFlg, String dcgoRefNo, String spclCgoAuthRjctCd, String spclCgoAuthRmk, String mode, String itmStsCd, String trsmDt, String prnrSpclCgoSeq, String prnrCgoRqstSeq, String ediUnmapKndCd, String updIndicator, String ediUnmapDtlCd, String srchType, String spclCgoQty) {
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.n3rdImdgSubsRskLblCd = n3rdImdgSubsRskLblCd;
        this.spclCgoRqstSeq = spclCgoRqstSeq;
        this.etaDt = etaDt;
        this.imdgUnNoSeq = imdgUnNoSeq;
        this.imdgAmdtNo = imdgAmdtNo;
        this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
        this.scgFlg = scgFlg;
        this.radaSkdNo = radaSkdNo;
        this.n4thImdgSubsRskLblCd = n4thImdgSubsRskLblCd;
        this.imdgCompGrpCd = imdgCompGrpCd;
        this.toEtaDt = toEtaDt;
        this.cntrTpszCd = cntrTpszCd;
        this.hcdgFlg = hcdgFlg;
        this.imdgUnNo = imdgUnNo;
        this.updUsrId = updUsrId;
        this.authOfcCd = authOfcCd;
        this.hcdgIntmdBcRstrDesc = hcdgIntmdBcRstrDesc;
        this.spclCgoCateCd = spclCgoCateCd;
        this.skdVoyNo = skdVoyNo;
        this.voidSltQty = voidSltQty;
        this.podCd = podCd;
        this.podClptIndSeq = podClptIndSeq;
        this.hgtOvrDimLen = hgtOvrDimLen;
        this.radaAmt = radaAmt;
        this.cmdtDesc = cmdtDesc;
        this.netExploWgt = netExploWgt;
        this.awkFlg = awkFlg;
        this.emerRspnGidNo = emerRspnGidNo;
        this.authUsrId = authUsrId;
        this.cneeDtlDesc = cneeDtlDesc;
        this.imdgClssCd = imdgClssCd;
        this.authFlg = authFlg;
        this.emerCntcPhnNo = emerCntcPhnNo;
        this.measTpCd = measTpCd;
        this.imdgPckGrpCd = imdgPckGrpCd;
        this.flshPntCdoTemp = flshPntCdoTemp;
        this.imdgLmtQtyMeasUtCd = imdgLmtQtyMeasUtCd;
        this.n1stImdgSubsRskLblCd = n1stImdgSubsRskLblCd;
        this.imdgLmtQty = imdgLmtQty;
        this.inN1stImdgPckCd = inN1stImdgPckCd;
        this.outN2ndImdgPckQty = outN2ndImdgPckQty;
        this.emsNo = emsNo;
        this.maxInPckQty = maxInPckQty;
        this.inN2ndImdgPckDesc = inN2ndImdgPckDesc;
        this.pckTpCd = pckTpCd;
        this.imdgSubsRskLblCd = imdgSubsRskLblCd;
        this.spclStwgRqstDesc = spclStwgRqstDesc;
        this.slanCd = slanCd;
        this.diffRmk = diffRmk;
        this.outN2ndImdgPckDesc = outN2ndImdgPckDesc;
        this.authStsCd = authStsCd;
        this.outN1stImdgPckCd = outN1stImdgPckCd;
        this.vslCd = vslCd;
        this.vslNm = vslNm;
        this.ttlDimWdt = ttlDimWdt;
        this.psaNo = psaNo;
        this.inN2ndImdgPckQty = inN2ndImdgPckQty;
        this.netWgtSum = netWgtSum;
        this.dcgoStsCd = dcgoStsCd;
        this.emerCntcPsonNm = emerCntcPsonNm;
        this.imdgSpclProviNo = imdgSpclProviNo;
        this.outN2ndImdgPckCd = outN2ndImdgPckCd;
        this.crrCd = crrCd;
        this.lfSdOvrDimLen = lfSdOvrDimLen;
        this.polCd = polCd;
        this.polClptIndSeq = polClptIndSeq;
        this.inN2ndImdgPckCd = inN2ndImdgPckCd;
        this.fwrdOvrDimLen = fwrdOvrDimLen;
        this.wgtUtCd = wgtUtCd;
        this.inN1stImdgPckQty = inN1stImdgPckQty;
        this.mrnPolutFlg = mrnPolutFlg;
        this.cntrRefNo = cntrRefNo;
        this.rgnShpOprCd = rgnShpOprCd;
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
        this.slanCd1 = slanCd1;
        this.radaTrspNo = radaTrspNo;
        this.radaUtCd = radaUtCd;
        this.maxInPckTpCd = maxInPckTpCd;
        this.wgtUtCd2 = wgtUtCd2;
        this.imdgExptQtyCd = imdgExptQtyCd;
        this.certiNo = certiNo;
        this.measQty = measQty;
        this.pckQty = pckQty;
        this.fromEtaDt = fromEtaDt;
        this.outN1stImdgPckQty = outN1stImdgPckQty;
        this.hcdgPckRstrDesc = hcdgPckRstrDesc;
        this.inN1stImdgPckDesc = inN1stImdgPckDesc;
        this.imdgExptQtyFlg = imdgExptQtyFlg;
        this.n2ndImdgSubsRskLblCd = n2ndImdgSubsRskLblCd;
        this.updDt = updDt;
        this.clodFlg = clodFlg;
        this.bookingNo = bookingNo;
        this.stsCt = stsCt;
        this.bkwdOvrDimLen = bkwdOvrDimLen;
        this.imdgCoGrpCd = imdgCoGrpCd;
        this.skdDirCd = skdDirCd;
        this.bkgRefNo = bkgRefNo;
        this.cgoOprCd = cgoOprCd;
        this.dgFlg = dgFlg;
        this.ctrlTempCtnt = ctrlTempCtnt;
        this.hcdgTnkRstrDesc = hcdgTnkRstrDesc;
        this.prpShpNm = prpShpNm;
        this.outN1stImdgPckDesc = outN1stImdgPckDesc;
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
        this.slanCd2 = slanCd2;
        this.slanCd3 = slanCd3;
        this.slanCd4 = slanCd4;
        this.slanCd5 = slanCd5;
        this.slanCd6 = slanCd6;
        this.slanCd7 = slanCd7;
        this.slanCd8 = slanCd8;
        this.slanCd9 = slanCd9;
        this.slanCd10 = slanCd10;
        this.slanCd11 = slanCd11;
        this.vpsEtaDt = vpsEtaDt;
        this.imdgSegrGrpNm = imdgSegrGrpNm;
        this.stgCate = stgCate;
        this.ediTrsmStsCd = ediTrsmStsCd;
        this.srcTpCd = srcTpCd;
        this.rsdFlg = rsdFlg;
        this.dcgoRefNo = dcgoRefNo;
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
        this.spclCgoAuthRmk = spclCgoAuthRmk;
        this.mode = mode;
        this.itmStsCd = itmStsCd;
        this.trsmDt = trsmDt;
        this.prnrSpclCgoSeq = prnrSpclCgoSeq;
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
        this.ediUnmapKndCd = ediUnmapKndCd;
        this.updIndicator = updIndicator;
        this.ediUnmapDtlCd = ediUnmapDtlCd;
        this.srchType = srchType;
        this.spclCgoQty = spclCgoQty;
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
        this.hashColumns.put("eta_dt", getEtaDt());
        this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
        this.hashColumns.put("imdg_amdt_no", getImdgAmdtNo());
        this.hashColumns.put("imdg_subs_rsk_lbl_rmk", getImdgSubsRskLblRmk());
        this.hashColumns.put("scg_flg", getScgFlg());
        this.hashColumns.put("rada_skd_no", getRadaSkdNo());
        this.hashColumns.put("n4th_imdg_subs_rsk_lbl_cd", getN4thImdgSubsRskLblCd());
        this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
        this.hashColumns.put("to_eta_dt", getToEtaDt());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("hcdg_flg", getHcdgFlg());
        this.hashColumns.put("imdg_un_no", getImdgUnNo());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
        this.hashColumns.put("hcdg_intmd_bc_rstr_desc", getHcdgIntmdBcRstrDesc());
        this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("void_slt_qty", getVoidSltQty());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
        this.hashColumns.put("hgt_ovr_dim_len", getHgtOvrDimLen());
        this.hashColumns.put("rada_amt", getRadaAmt());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("net_explo_wgt", getNetExploWgt());
        this.hashColumns.put("awk_flg", getAwkFlg());
        this.hashColumns.put("emer_rspn_gid_no", getEmerRspnGidNo());
        this.hashColumns.put("auth_usr_id", getAuthUsrId());
        this.hashColumns.put("cnee_dtl_desc", getCneeDtlDesc());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("auth_flg", getAuthFlg());
        this.hashColumns.put("emer_cntc_phn_no", getEmerCntcPhnNo());
        this.hashColumns.put("meas_tp_cd", getMeasTpCd());
        this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
        this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
        this.hashColumns.put("imdg_lmt_qty_meas_ut_cd", getImdgLmtQtyMeasUtCd());
        this.hashColumns.put("n1st_imdg_subs_rsk_lbl_cd", getN1stImdgSubsRskLblCd());
        this.hashColumns.put("imdg_lmt_qty", getImdgLmtQty());
        this.hashColumns.put("in_n1st_imdg_pck_cd", getInN1stImdgPckCd());
        this.hashColumns.put("out_n2nd_imdg_pck_qty", getOutN2ndImdgPckQty());
        this.hashColumns.put("ems_no", getEmsNo());
        this.hashColumns.put("max_in_pck_qty", getMaxInPckQty());
        this.hashColumns.put("in_n2nd_imdg_pck_desc", getInN2ndImdgPckDesc());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
        this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("diff_rmk", getDiffRmk());
        this.hashColumns.put("out_n2nd_imdg_pck_desc", getOutN2ndImdgPckDesc());
        this.hashColumns.put("auth_sts_cd", getAuthStsCd());
        this.hashColumns.put("out_n1st_imdg_pck_cd", getOutN1stImdgPckCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vsl_nm", getVslNm());
        this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
        this.hashColumns.put("psa_no", getPsaNo());
        this.hashColumns.put("in_n2nd_imdg_pck_qty", getInN2ndImdgPckQty());
        this.hashColumns.put("net_wgt_sum", getNetWgtSum());
        this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
        this.hashColumns.put("emer_cntc_pson_nm", getEmerCntcPsonNm());
        this.hashColumns.put("imdg_spcl_provi_no", getImdgSpclProviNo());
        this.hashColumns.put("out_n2nd_imdg_pck_cd", getOutN2ndImdgPckCd());
        this.hashColumns.put("crr_cd", getCrrCd());
        this.hashColumns.put("lf_sd_ovr_dim_len", getLfSdOvrDimLen());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
        this.hashColumns.put("in_n2nd_imdg_pck_cd", getInN2ndImdgPckCd());
        this.hashColumns.put("fwrd_ovr_dim_len", getFwrdOvrDimLen());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("in_n1st_imdg_pck_qty", getInN1stImdgPckQty());
        this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
        this.hashColumns.put("cntr_ref_no", getCntrRefNo());
        this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
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
        this.hashColumns.put("slan_cd1", getSlanCd1());
        this.hashColumns.put("rada_trsp_no", getRadaTrspNo());
        this.hashColumns.put("rada_ut_cd", getRadaUtCd());
        this.hashColumns.put("max_in_pck_tp_cd", getMaxInPckTpCd());
        this.hashColumns.put("wgt_ut_cd2", getWgtUtCd2());
        this.hashColumns.put("imdg_expt_qty_cd", getImdgExptQtyCd());
        this.hashColumns.put("certi_no", getCertiNo());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("from_eta_dt", getFromEtaDt());
        this.hashColumns.put("out_n1st_imdg_pck_qty", getOutN1stImdgPckQty());
        this.hashColumns.put("hcdg_pck_rstr_desc", getHcdgPckRstrDesc());
        this.hashColumns.put("in_n1st_imdg_pck_desc", getInN1stImdgPckDesc());
        this.hashColumns.put("imdg_expt_qty_flg", getImdgExptQtyFlg());
        this.hashColumns.put("n2nd_imdg_subs_rsk_lbl_cd", getN2ndImdgSubsRskLblCd());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("clod_flg", getClodFlg());
        this.hashColumns.put("booking_no", getBookingNo());
        this.hashColumns.put("sts_ct", getStsCt());
        this.hashColumns.put("bkwd_ovr_dim_len", getBkwdOvrDimLen());
        this.hashColumns.put("imdg_co_grp_cd", getImdgCoGrpCd());
        this.hashColumns.put("skd_dir_cd", getSkdDirCd());
        this.hashColumns.put("bkg_ref_no", getBkgRefNo());
        this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
        this.hashColumns.put("dg_flg", getDgFlg());
        this.hashColumns.put("ctrl_temp_ctnt", getCtrlTempCtnt());
        this.hashColumns.put("hcdg_tnk_rstr_desc", getHcdgTnkRstrDesc());
        this.hashColumns.put("prp_shp_nm", getPrpShpNm());
        this.hashColumns.put("out_n1st_imdg_pck_desc", getOutN1stImdgPckDesc());
        this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
        this.hashColumns.put("slan_cd2", getSlanCd2());
        this.hashColumns.put("slan_cd3", getSlanCd3());
        this.hashColumns.put("slan_cd4", getSlanCd4());
        this.hashColumns.put("slan_cd5", getSlanCd5());
        this.hashColumns.put("slan_cd6", getSlanCd6());
        this.hashColumns.put("slan_cd7", getSlanCd7());
        this.hashColumns.put("slan_cd8", getSlanCd8());
        this.hashColumns.put("slan_cd9", getSlanCd9());
        this.hashColumns.put("slan_cd10", getSlanCd10());
        this.hashColumns.put("slan_cd11", getSlanCd11());
        this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
        this.hashColumns.put("imdg_segr_grp_nm", getImdgSegrGrpNm());
        this.hashColumns.put("imdg_segr_grp_no", getImdgSegrGrpNo());
        this.hashColumns.put("stg_cate", getStgCate());
        this.hashColumns.put("edi_trsm_sts_cd", getEdiTrsmStsCd());
        this.hashColumns.put("src_tp_cd", getSrcTpCd());
        this.hashColumns.put("rsd_flg", getRsdFlg());
        this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
        this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
        this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
        this.hashColumns.put("mode", getMode());
        this.hashColumns.put("eml_snd_his_flg", getEmlSndHisFlg());
        this.hashColumns.put("edi_snd_his_flg", getEdiSndHisFlg());
        this.hashColumns.put("itm_sts_cd", getItmStsCd());
        this.hashColumns.put("trsm_dt", getTrsmDt());
        this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
        this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
        this.hashColumns.put("edi_unmap_knd_cd", getEdiUnmapKndCd());
        this.hashColumns.put("upd_indicator", getUpdIndicator());
        this.hashColumns.put("edi_unmap_dtl_cd", getEdiUnmapDtlCd());
        this.hashColumns.put("srch_type", getSrchType());
        this.hashColumns.put("spcl_cgo_qty", getSpclCgoQty());
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
        this.hashFields.put("eta_dt", "etaDt");
        this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
        this.hashFields.put("imdg_amdt_no", "imdgAmdtNo");
        this.hashFields.put("imdg_subs_rsk_lbl_rmk", "imdgSubsRskLblRmk");
        this.hashFields.put("scg_flg", "scgFlg");
        this.hashFields.put("rada_skd_no", "radaSkdNo");
        this.hashFields.put("n4th_imdg_subs_rsk_lbl_cd", "n4thImdgSubsRskLblCd");
        this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
        this.hashFields.put("to_eta_dt", "toEtaDt");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("hcdg_flg", "hcdgFlg");
        this.hashFields.put("imdg_un_no", "imdgUnNo");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("auth_ofc_cd", "authOfcCd");
        this.hashFields.put("hcdg_intmd_bc_rstr_desc", "hcdgIntmdBcRstrDesc");
        this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("void_slt_qty", "voidSltQty");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
        this.hashFields.put("hgt_ovr_dim_len", "hgtOvrDimLen");
        this.hashFields.put("rada_amt", "radaAmt");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("net_explo_wgt", "netExploWgt");
        this.hashFields.put("awk_flg", "awkFlg");
        this.hashFields.put("emer_rspn_gid_no", "emerRspnGidNo");
        this.hashFields.put("auth_usr_id", "authUsrId");
        this.hashFields.put("cnee_dtl_desc", "cneeDtlDesc");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("auth_flg", "authFlg");
        this.hashFields.put("emer_cntc_phn_no", "emerCntcPhnNo");
        this.hashFields.put("meas_tp_cd", "measTpCd");
        this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
        this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
        this.hashFields.put("imdg_lmt_qty_meas_ut_cd", "imdgLmtQtyMeasUtCd");
        this.hashFields.put("n1st_imdg_subs_rsk_lbl_cd", "n1stImdgSubsRskLblCd");
        this.hashFields.put("imdg_lmt_qty", "imdgLmtQty");
        this.hashFields.put("in_n1st_imdg_pck_cd", "inN1stImdgPckCd");
        this.hashFields.put("out_n2nd_imdg_pck_qty", "outN2ndImdgPckQty");
        this.hashFields.put("ems_no", "emsNo");
        this.hashFields.put("max_in_pck_qty", "maxInPckQty");
        this.hashFields.put("in_n2nd_imdg_pck_desc", "inN2ndImdgPckDesc");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
        this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
        this.hashFields.put("diff_rmk", "diffRmk");
        this.hashFields.put("out_n2nd_imdg_pck_desc", "outN2ndImdgPckDesc");
        this.hashFields.put("auth_sts_cd", "authStsCd");
        this.hashFields.put("out_n1st_imdg_pck_cd", "outN1stImdgPckCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vsl_nm", "vslNm");
        this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
        this.hashFields.put("psa_no", "psaNo");
        this.hashFields.put("in_n2nd_imdg_pck_qty", "inN2ndImdgPckQty");
        this.hashFields.put("net_wgt_sum", "netWgtSum");
        this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
        this.hashFields.put("emer_cntc_pson_nm", "emerCntcPsonNm");
        this.hashFields.put("imdg_spcl_provi_no", "imdgSpclProviNo");
        this.hashFields.put("out_n2nd_imdg_pck_cd", "outN2ndImdgPckCd");
        this.hashFields.put("crr_cd", "crrCd");
        this.hashFields.put("lf_sd_ovr_dim_len", "lfSdOvrDimLen");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
        this.hashFields.put("in_n2nd_imdg_pck_cd", "inN2ndImdgPckCd");
        this.hashFields.put("fwrd_ovr_dim_len", "fwrdOvrDimLen");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("in_n1st_imdg_pck_qty", "inN1stImdgPckQty");
        this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
        this.hashFields.put("cntr_ref_no", "cntrRefNo");
        this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
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
        this.hashFields.put("rada_trsp_no", "radaTrspNo");
        this.hashFields.put("rada_ut_cd", "radaUtCd");
        this.hashFields.put("max_in_pck_tp_cd", "maxInPckTpCd");
        this.hashFields.put("wgt_ut_cd2", "wgtUtCd2");
        this.hashFields.put("imdg_expt_qty_cd", "imdgExptQtyCd");
        this.hashFields.put("certi_no", "certiNo");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("from_eta_dt", "fromEtaDt");
        this.hashFields.put("out_n1st_imdg_pck_qty", "outN1stImdgPckQty");
        this.hashFields.put("hcdg_pck_rstr_desc", "hcdgPckRstrDesc");
        this.hashFields.put("in_n1st_imdg_pck_desc", "inN1stImdgPckDesc");
        this.hashFields.put("imdg_expt_qty_flg", "imdgExptQtyFlg");
        this.hashFields.put("n2nd_imdg_subs_rsk_lbl_cd", "n2ndImdgSubsRskLblCd");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("clod_flg", "clodFlg");
        this.hashFields.put("booking_no", "bookingNo");
        this.hashFields.put("sts_ct", "stsCt");
        this.hashFields.put("bkwd_ovr_dim_len", "bkwdOvrDimLen");
        this.hashFields.put("imdg_co_grp_cd", "imdgCoGrpCd");
        this.hashFields.put("skd_dir_cd", "skdDirCd");
        this.hashFields.put("bkg_ref_no", "bkgRefNo");
        this.hashFields.put("cgo_opr_cd", "cgoOprCd");
        this.hashFields.put("dg_flg", "dgFlg");
        this.hashFields.put("ctrl_temp_ctnt", "ctrlTempCtnt");
        this.hashFields.put("hcdg_tnk_rstr_desc", "hcdgTnkRstrDesc");
        this.hashFields.put("prp_shp_nm", "prpShpNm");
        this.hashFields.put("out_n1st_imdg_pck_desc", "outN1stImdgPckDesc");
        this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("slan_cd1", "slanCd1");
        this.hashFields.put("slan_cd2", "slanCd2");
        this.hashFields.put("slan_cd3", "slanCd3");
        this.hashFields.put("slan_cd4", "slanCd4");
        this.hashFields.put("slan_cd5", "slanCd5");
        this.hashFields.put("slan_cd6", "slanCd6");
        this.hashFields.put("slan_cd7", "slanCd7");
        this.hashFields.put("slan_cd8", "slanCd8");
        this.hashFields.put("slan_cd9", "slanCd9");
        this.hashFields.put("slan_cd10", "slanCd10");
        this.hashFields.put("slan_cd11", "slanCd11");
        this.hashFields.put("vps_eta_dt", "vpsEtaDt");
        this.hashFields.put("imdg_segr_grp_nm", "imdgSegrGrpNm");
        this.hashFields.put("imdg_segr_grp_no", "imdgSegrGrpNo");
        this.hashFields.put("stg_cate", "stgCate");
        this.hashFields.put("edi_trsm_sts_cd", "ediTrsmStsCd");
        this.hashFields.put("src_tp_cd", "srcTpCd");
        this.hashFields.put("rsd_flg", "rsdFlg");
        this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
        this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
        this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
        this.hashFields.put("mode", "mode");
        this.hashFields.put("eml_snd_his_flg", "emlSndHisFlg");
        this.hashFields.put("edi_snd_his_flg", "ediSndHisFlg");
        this.hashFields.put("itm_sts_cd", "itmStsCd");
        this.hashFields.put("trsm_dt", "trsmDt");
        this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
        this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
        this.hashFields.put("edi_unmap_knd_cd", "ediUnmapKndCd");
        this.hashFields.put("upd_indicator", "updIndicator");
        this.hashFields.put("edi_unmap_dtl_cd", "ediUnmapDtlCd");
        this.hashFields.put("srch_type", "srchType");
        this.hashFields.put("spcl_cgo_qty", "spclCgoQty");
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
	 * @return etaDt
	 */
    public String getEtaDt() {
        return this.etaDt;
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
	 * @return imdgAmdtNo
	 */
    public String getImdgAmdtNo() {
        return this.imdgAmdtNo;
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
	 * @return scgFlg
	 */
    public String getScgFlg() {
        return this.scgFlg;
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
	 * @return toEtaDt
	 */
    public String getToEtaDt() {
        return this.toEtaDt;
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
	 * @return hcdgFlg
	 */
    public String getHcdgFlg() {
        return this.hcdgFlg;
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
	 * @return podClptIndSeq
	 */
    public String getPodClptIndSeq() {
        return this.podClptIndSeq;
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
	 * @return radaAmt
	 */
    public String getRadaAmt() {
        return this.radaAmt;
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
	 * @return netExploWgt
	 */
    public String getNetExploWgt() {
        return this.netExploWgt;
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
	 * @return authFlg
	 */
    public String getAuthFlg() {
        return this.authFlg;
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
	 * @return measTpCd
	 */
    public String getMeasTpCd() {
        return this.measTpCd;
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
	 * @return pckTpCd
	 */
    public String getPckTpCd() {
        return this.pckTpCd;
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
	 * @return vslNm
	 */
    public String getVslNm() {
        return this.vslNm;
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
	 * @return netWgtSum
	 */
    public String getNetWgtSum() {
        return this.netWgtSum;
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
	 * @return imdgSpclProviNo
	 */
    public String getImdgSpclProviNo() {
        return this.imdgSpclProviNo;
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
	 * @return polClptIndSeq
	 */
    public String getPolClptIndSeq() {
        return this.polClptIndSeq;
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
	 * @return rgnShpOprCd
	 */
    public String getRgnShpOprCd() {
        return this.rgnShpOprCd;
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
	 * @return slanCd1
	 */
    public String getSlanCd1() {
        return this.slanCd1;
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
	 * @return radaUtCd
	 */
    public String getRadaUtCd() {
        return this.radaUtCd;
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
	 * @return wgtUtCd2
	 */
    public String getWgtUtCd2() {
        return this.wgtUtCd2;
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
	 * @return fromEtaDt
	 */
    public String getFromEtaDt() {
        return this.fromEtaDt;
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
	 * @return bookingNo
	 */
    public String getBookingNo() {
        return this.bookingNo;
    }

    /**
	 * Column Info
	 * @return stsCt
	 */
    public String getStsCt() {
        return this.stsCt;
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
	 * @return cgoOprCd
	 */
    public String getCgoOprCd() {
        return this.cgoOprCd;
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
	 * @return prpShpNm
	 */
    public String getPrpShpNm() {
        return this.prpShpNm;
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
	 * @return imdgLmtQtyFlg
	 */
    public String getImdgLmtQtyFlg() {
        return this.imdgLmtQtyFlg;
    }

    /**
	 * Column Info
	 * @return slanCd2
	 */
    public String getSlanCd2() {
        return this.slanCd2;
    }

    /**
	 * Column Info
	 * @return slanCd3
	 */
    public String getSlanCd3() {
        return this.slanCd3;
    }

    /**
	 * Column Info
	 * @return slanCd4
	 */
    public String getSlanCd4() {
        return this.slanCd4;
    }

    /**
	 * Column Info
	 * @return slanCd5
	 */
    public String getSlanCd5() {
        return this.slanCd5;
    }

    /**
	 * Column Info
	 * @return slanCd6
	 */
    public String getSlanCd6() {
        return this.slanCd6;
    }

    /**
	 * Column Info
	 * @return slanCd7
	 */
    public String getSlanCd7() {
        return this.slanCd7;
    }

    /**
	 * Column Info
	 * @return slanCd8
	 */
    public String getSlanCd8() {
        return this.slanCd8;
    }

    /**
	 * Column Info
	 * @return slanCd9
	 */
    public String getSlanCd9() {
        return this.slanCd9;
    }

    /**
	 * Column Info
	 * @return slanCd10
	 */
    public String getSlanCd10() {
        return this.slanCd10;
    }

    /**
	 * Column Info
	 * @return slanCd11
	 */
    public String getSlanCd11() {
        return this.slanCd11;
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
	 * @return imdgSegrGrpNm
	 */
    public String getImdgSegrGrpNm() {
        return this.imdgSegrGrpNm;
    }

    /**
	 * Column Info
	 * @return imdgSegrGrpNm
	 */
    public String getImdgSegrGrpNo() {
        return this.imdgSegrGrpNo;
    }

    /**
	 * Column Info
	 * @return stgCate
	 */
    public String getStgCate() {
        return this.stgCate;
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
	 * @return srcTpCd
	 */
    public String getSrcTpCd() {
        return this.srcTpCd;
    }

    /**
	 * Column Info
	 * @return dcgoRefNo
	 */
    public String getDcgoRefNo() {
        return this.dcgoRefNo;
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
	 * Column Info
	 * @return mode
	 */
    public String getMode() {
        return this.mode;
    }

    /**
	 * Column Info
	 * @return emlSndHisFlg
	 */
    public String getEmlSndHisFlg() {
        return this.emlSndHisFlg;
    }

    /**
	 * Column Info
	 * @return ediSndHisFlg
	 */
    public String getEdiSndHisFlg() {
        return this.ediSndHisFlg;
    }

    /**
	 * Column Info
	 * @return ItmStsCd
	 */
    public String getItmStsCd() {
        return this.itmStsCd;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  emlSndHisFlg
 	 */
    public void setEmlSndHisFlg(String emlSndHisFlg) {
        this.emlSndHisFlg = emlSndHisFlg;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ediSndHisFlg
 	 */
    public void setEdiSndHisFlg(String ediSndHisFlg) {
        this.ediSndHisFlg = ediSndHisFlg;
    }

    /**
	 * VO Data Value
	 * @param  itmStsCd
 	 */
    public void setItmStsCd(String itmStsCd) {
        this.itmStsCd = itmStsCd;
    }

    /**
	 * VO Info
	 * @return scgPrnrAproRqstVO
	 */
    public ScgPrnrAproRqstVO getScgPrnrAproRqstVO() {
        return this.scgPrnrAproRqstVO;
    }

    /**
	 * VO Info
	 * @return scgPrnrAproRqstCgoVOl
	 */
    public List<ScgPrnrAproRqstCgoVO> getScgPrnrAproRqstCgoVOl() {
        return this.scgPrnrAproRqstCgoVOl;
    }

    /**
	 * VO Info
	 * @return scgPrnrAproRqstFileVOl
	 */
    public List<ScgPrnrAproRqstFileVO> getScgPrnrAproRqstFileVOl() {
        return this.scgPrnrAproRqstFileVOl;
    }

    /**
	 * VO Info
	 * @return scgPrnrAproRqstVOs
	 */
    public ScgPrnrAproRqstVO[] getScgPrnrAproRqstVOs() {
        return this.scgPrnrAproRqstVOs;
    }

    /**
	 * VO Info
	 * @return scgPrnrAproRqstCgoVOs
	 */
    public ScgPrnrAproRqstCgoVO[] getScgPrnrAproRqstCgoVOs() {
        return this.scgPrnrAproRqstCgoVOs;
    }

    /**
	 * VO Info
	 * @return scgPrnrAproRqstFileVOs
	 */
    public ScgPrnrAproRqstFileVO[] getScgPrnrAproRqstFileVOs() {
        return this.scgPrnrAproRqstFileVOs;
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
	 * @param  etaDt
 	 */
    public void setEtaDt(String etaDt) {
        this.etaDt = etaDt;
    }

    /**
	 * Column Info
	 * @param  imdgAmdtNo
 	 */
    public void setImdgAmdtNo(String imdgAmdtNo) {
        this.imdgAmdtNo = imdgAmdtNo;
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
	 * @param  scgFlg
 	 */
    public void setScgFlg(String scgFlg) {
        this.scgFlg = scgFlg;
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
	 * @param  toEtaDt
 	 */
    public void setToEtaDt(String toEtaDt) {
        this.toEtaDt = toEtaDt;
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
	 * @param  hcdgFlg
 	 */
    public void setHcdgFlg(String hcdgFlg) {
        this.hcdgFlg = hcdgFlg;
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
	 * @param  podClptIndSeq
 	 */
    public void setPodClptIndSeq(String podClptIndSeq) {
        this.podClptIndSeq = podClptIndSeq;
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
	 * @param  radaAmt
 	 */
    public void setRadaAmt(String radaAmt) {
        this.radaAmt = radaAmt;
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
	 * @param  netExploWgt
 	 */
    public void setNetExploWgt(String netExploWgt) {
        this.netExploWgt = netExploWgt;
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
	 * @param  authFlg
 	 */
    public void setAuthFlg(String authFlg) {
        this.authFlg = authFlg;
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
	 * @param  measTpCd
 	 */
    public void setMeasTpCd(String measTpCd) {
        this.measTpCd = measTpCd;
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
	 * @param  pckTpCd
 	 */
    public void setPckTpCd(String pckTpCd) {
        this.pckTpCd = pckTpCd;
    }

    /**
	 * Column Info
	 * @param  imdgSubsRskLblCd
 	 */
    public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
        this.imdgSubsRskLblCd = imdgSubsRskLblCd;
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
	 * @param  vslNm
 	 */
    public void setVslNm(String vslNm) {
        this.vslNm = vslNm;
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
	 * @param  netWgtSum
 	 */
    public void setNetWgtSum(String netWgtSum) {
        this.netWgtSum = netWgtSum;
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
	 * @param  imdgSpclProviNo
 	 */
    public void setImdgSpclProviNo(String imdgSpclProviNo) {
        this.imdgSpclProviNo = imdgSpclProviNo;
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
	 * @param  polClptIndSeq
 	 */
    public void setPolClptIndSeq(String polClptIndSeq) {
        this.polClptIndSeq = polClptIndSeq;
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
	 * @param  rgnShpOprCd
 	 */
    public void setRgnShpOprCd(String rgnShpOprCd) {
        this.rgnShpOprCd = rgnShpOprCd;
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
	 * @param  slanCd1
 	 */
    public void setSlanCd1(String slanCd1) {
        this.slanCd1 = slanCd1;
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
	 * @param  radaUtCd
 	 */
    public void setRadaUtCd(String radaUtCd) {
        this.radaUtCd = radaUtCd;
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
	 * @param  wgtUtCd2
 	 */
    public void setWgtUtCd2(String wgtUtCd2) {
        this.wgtUtCd2 = wgtUtCd2;
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
	 * @param  fromEtaDt
 	 */
    public void setFromEtaDt(String fromEtaDt) {
        this.fromEtaDt = fromEtaDt;
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
	 * @param  bookingNo
 	 */
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    /**
	 * Column Info
	 * @param  stsCt
 	 */
    public void setStsCt(String stsCt) {
        this.stsCt = stsCt;
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
	 * @param  cgoOprCd
 	 */
    public void setCgoOprCd(String cgoOprCd) {
        this.cgoOprCd = cgoOprCd;
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
	 * @param  prpShpNm
 	 */
    public void setPrpShpNm(String prpShpNm) {
        this.prpShpNm = prpShpNm;
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
	 * @param  imdgLmtQtyFlg
 	 */
    public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
        this.imdgLmtQtyFlg = imdgLmtQtyFlg;
    }

    /**
	 * Column Info
	 * @param  slanCd2
 	 */
    public void setSlanCd2(String slanCd2) {
        this.slanCd2 = slanCd2;
    }

    /**
	 * Column Info
	 * @param  slanCd3
 	 */
    public void setSlanCd3(String slanCd3) {
        this.slanCd3 = slanCd3;
    }

    /**
	 * Column Info
	 * @param  slanCd4
 	 */
    public void setSlanCd4(String slanCd4) {
        this.slanCd4 = slanCd4;
    }

    /**
	 * Column Info
	 * @param  slanCd5
 	 */
    public void setSlanCd5(String slanCd5) {
        this.slanCd5 = slanCd5;
    }

    /**
	 * Column Info
	 * @param  slanCd6
 	 */
    public void setSlanCd6(String slanCd6) {
        this.slanCd6 = slanCd6;
    }

    /**
	 * Column Info
	 * @param  slanCd7
 	 */
    public void setSlanCd7(String slanCd7) {
        this.slanCd7 = slanCd7;
    }

    /**
	 * Column Info
	 * @param  slanCd8
 	 */
    public void setSlanCd8(String slanCd8) {
        this.slanCd8 = slanCd8;
    }

    /**
	 * Column Info
	 * @param  slanCd9
 	 */
    public void setSlanCd9(String slanCd9) {
        this.slanCd9 = slanCd9;
    }

    /**
	 * Column Info
	 * @param  slanCd10
 	 */
    public void setSlanCd10(String slanCd10) {
        this.slanCd10 = slanCd10;
    }

    /**
	 * Column Info
	 * @param  slanCd11
 	 */
    public void setSlanCd11(String slanCd11) {
        this.slanCd11 = slanCd11;
    }

    /**
	 * Column Info
	 * @param  vpsEtaDt
 	 */
    public void setVpsEtaDt(String vpsEtaDt) {
        this.vpsEtaDt = vpsEtaDt;
    }

    /**
	 * Column Info
	 * @param  imdgSegrGrpNm
 	 */
    public void setImdgSegrGrpNm(String imdgSegrGrpNm) {
        this.imdgSegrGrpNm = imdgSegrGrpNm;
    }

    /**
	 * Column Info
	 * @param  imdgSegrGrpNo
 	 */
    public void setImdgSegrGrpNo(String imdgSegrGrpNo) {
        this.imdgSegrGrpNo = imdgSegrGrpNo;
    }

    /**
	 * Column Info
	 * @param  stgCate
 	 */
    public void setStgCate(String stgCate) {
        this.stgCate = stgCate;
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
	 * @param  srcTpCd
 	 */
    public void setSrcTpCd(String srcTpCd) {
        this.srcTpCd = srcTpCd;
    }

    /**
	 * Column Info
	 * @param  dcgoRefNo
 	 */
    public void setDcgoRefNo(String dcgoRefNo) {
        this.dcgoRefNo = dcgoRefNo;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthRjctCd
 	 */
    public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
        this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
    }

    /**
	 * Column Info
	 * @param  spclCgoAuthRmk
 	 */
    public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
        this.spclCgoAuthRmk = spclCgoAuthRmk;
    }

    /**
	 * Column Info
	 * @param  mode
 	 */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
	 * VO Info
	 * @param scgPrnrAproRqstVOs
	 */
    public void setScgPrnrAproRqstVOs(ScgPrnrAproRqstVO[] scgPrnrAproRqstVOs) {
        this.scgPrnrAproRqstVOs = scgPrnrAproRqstVOs;
    }

    /**
	 * VO Info
	 * @param scgPrnrAproRqstCgoVOs
	 */
    public void setScgPrnrAproRqstCgoVOs(ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs) {
        this.scgPrnrAproRqstCgoVOs = scgPrnrAproRqstCgoVOs;
    }

    /**
	 * VO Info
	 * @param scgPrnrAproRqstFileVOs
	 */
    public void setScgPrnrAproRqstFileVOs(ScgPrnrAproRqstFileVO[] scgPrnrAproRqstFileVOs) {
        this.scgPrnrAproRqstFileVOs = scgPrnrAproRqstFileVOs;
    }

    /**
	 * VO Info
	 * @param scgPrnrAproRqstVO
	 */
    public void setScgPrnrAproRqstVO(ScgPrnrAproRqstVO scgPrnrAproRqstVO) {
        this.scgPrnrAproRqstVO = scgPrnrAproRqstVO;
    }

    /**
	 * VO Info
	 * @param scgPrnrAproRqstCgoVOl
	 */
    public void setScgPrnrAproRqstCgoVOl(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOl) {
        this.scgPrnrAproRqstCgoVOl = scgPrnrAproRqstCgoVOl;
    }

    /**
	 * VO Info
	 * @param scgPrnrAproRqstFileVOl
	 */
    public void setScgPrnrAproRqstFileVOl(List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOl) {
        this.scgPrnrAproRqstFileVOl = scgPrnrAproRqstFileVOl;
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

    public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
        this.prnrCgoRqstSeq = prnrCgoRqstSeq;
    }

    public String getPrnrCgoRqstSeq() {
        return this.prnrCgoRqstSeq;
    }

    public void setEdiUnmapKndCd(String ediUnmapKndCd) {
        this.ediUnmapKndCd = ediUnmapKndCd;
    }

    public String getEdiUnmapKndCd() {
        return this.ediUnmapKndCd;
    }

    public void setUpdIndicator(String updIndicator) {
        this.updIndicator = updIndicator;
    }

    public String getUpdIndicator() {
        return this.updIndicator;
    }

    public void setEdiUnmapDtlCd(String ediUnmapDtlCd) {
        this.ediUnmapDtlCd = ediUnmapDtlCd;
    }

    public String getEdiUnmapDtlCd() {
        return this.ediUnmapDtlCd;
    }

    public void setSrchType(String srchType) {
        this.srchType = srchType;
    }

    public String getSrchType() {
        return this.srchType;
    }

    public void setSpclCgoQty(String spclCgoQty) {
        this.spclCgoQty = spclCgoQty;
    }

    public String getSpclCgoQty() {
        return this.spclCgoQty;
    }
    
    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    public String getRsdFlg() {
        return rsdFlg;
    }

    public void setRsdFlg(String rsdFlg) {
        this.rsdFlg = rsdFlg;
    }

    public void setSearchConditon(String key, String value) {
        this.searchCondition.put(key, value);
    }

    public String getSearchConditon(String key) {
        return this.searchCondition.get(key);
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
        setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
        setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
        setImdgAmdtNo(JSPUtil.getParameter(request, prefix + "imdg_amdt_no", ""));
        setImdgSubsRskLblRmk(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_rmk", ""));
        setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
        setRadaSkdNo(JSPUtil.getParameter(request, prefix + "rada_skd_no", ""));
        setN4thImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n4th_imdg_subs_rsk_lbl_cd", ""));
        setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
        setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setHcdgFlg(JSPUtil.getParameter(request, prefix + "hcdg_flg", ""));
        setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
        setHcdgIntmdBcRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_intmd_bc_rstr_desc", ""));
        setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
        setVoidSltQty(JSPUtil.getParameter(request, prefix + "void_slt_qty", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
        setHgtOvrDimLen(JSPUtil.getParameter(request, prefix + "hgt_ovr_dim_len", ""));
        setRadaAmt(JSPUtil.getParameter(request, prefix + "rada_amt", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setNetExploWgt(JSPUtil.getParameter(request, prefix + "net_explo_wgt", ""));
        setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
        setEmerRspnGidNo(JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", ""));
        setAuthUsrId(JSPUtil.getParameter(request, prefix + "auth_usr_id", ""));
        setCneeDtlDesc(JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
        setEmerCntcPhnNo(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", ""));
        setMeasTpCd(JSPUtil.getParameter(request, prefix + "meas_tp_cd", ""));
        setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
        setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
        setImdgLmtQtyMeasUtCd(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_meas_ut_cd", ""));
        setN1stImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n1st_imdg_subs_rsk_lbl_cd", ""));
        setImdgLmtQty(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty", ""));
        setInN1stImdgPckCd(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_cd", ""));
        setOutN2ndImdgPckQty(JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_qty", ""));
        setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
        setMaxInPckQty(JSPUtil.getParameter(request, prefix + "max_in_pck_qty", ""));
        setInN2ndImdgPckDesc(JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_desc", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
        setSpclStwgRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
        setOutN2ndImdgPckDesc(JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_desc", ""));
        setAuthStsCd(JSPUtil.getParameter(request, prefix + "auth_sts_cd", ""));
        setOutN1stImdgPckCd(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_cd", ""));
        setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
        setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
        setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
        setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
        setInN2ndImdgPckQty(JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_qty", ""));
        setNetWgtSum(JSPUtil.getParameter(request, prefix + "net_wgt_sum", ""));
        setDcgoStsCd(JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", ""));
        setEmerCntcPsonNm(JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", ""));
        setImdgSpclProviNo(JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", ""));
        setOutN2ndImdgPckCd(JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_cd", ""));
        setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
        setLfSdOvrDimLen(JSPUtil.getParameter(request, prefix + "lf_sd_ovr_dim_len", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
        setInN2ndImdgPckCd(JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_cd", ""));
        setFwrdOvrDimLen(JSPUtil.getParameter(request, prefix + "fwrd_ovr_dim_len", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setInN1stImdgPckQty(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_qty", ""));
        setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
        setCntrRefNo(JSPUtil.getParameter(request, prefix + "cntr_ref_no", ""));
        setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
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
        setSlanCd1(JSPUtil.getParameter(request, prefix + "slan_cd1", ""));
        setRadaTrspNo(JSPUtil.getParameter(request, prefix + "rada_trsp_no", ""));
        setRadaUtCd(JSPUtil.getParameter(request, prefix + "rada_ut_cd", ""));
        setMaxInPckTpCd(JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", ""));
        setWgtUtCd2(JSPUtil.getParameter(request, prefix + "wgt_ut_cd2", ""));
        setImdgExptQtyCd(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_cd", ""));
        setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setFromEtaDt(JSPUtil.getParameter(request, prefix + "from_eta_dt", ""));
        setOutN1stImdgPckQty(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_qty", ""));
        setHcdgPckRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_pck_rstr_desc", ""));
        setInN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_desc", ""));
        setImdgExptQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", ""));
        setN2ndImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_subs_rsk_lbl_cd", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setClodFlg(JSPUtil.getParameter(request, prefix + "clod_flg", ""));
        setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
        setStsCt(JSPUtil.getParameter(request, prefix + "sts_ct", ""));
        setBkwdOvrDimLen(JSPUtil.getParameter(request, prefix + "bkwd_ovr_dim_len", ""));
        setImdgCoGrpCd(JSPUtil.getParameter(request, prefix + "imdg_co_grp_cd", ""));
        setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
        setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
        setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
        setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
        setCtrlTempCtnt(JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", ""));
        setHcdgTnkRstrDesc(JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc", ""));
        setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
        setOutN1stImdgPckDesc(JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_desc", ""));
        setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
        setSlanCd2(JSPUtil.getParameter(request, prefix + "slan_cd2", ""));
        setSlanCd3(JSPUtil.getParameter(request, prefix + "slan_cd3", ""));
        setSlanCd4(JSPUtil.getParameter(request, prefix + "slan_cd4", ""));
        setSlanCd5(JSPUtil.getParameter(request, prefix + "slan_cd5", ""));
        setSlanCd6(JSPUtil.getParameter(request, prefix + "slan_cd6", ""));
        setSlanCd7(JSPUtil.getParameter(request, prefix + "slan_cd7", ""));
        setSlanCd8(JSPUtil.getParameter(request, prefix + "slan_cd8", ""));
        setSlanCd9(JSPUtil.getParameter(request, prefix + "slan_cd9", ""));
        setSlanCd10(JSPUtil.getParameter(request, prefix + "slan_cd10", ""));
        setSlanCd11(JSPUtil.getParameter(request, prefix + "slan_cd11", ""));
        setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
        setImdgSegrGrpNm(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", ""));
        setImdgSegrGrpNo(JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", ""));
        setStgCate(JSPUtil.getParameter(request, prefix + "stg_cate", ""));
        setEdiTrsmStsCd(JSPUtil.getParameter(request, prefix + "edi_trsm_sts_cd", ""));
        setSrcTpCd(JSPUtil.getParameter(request, prefix + "src_tp_cd", ""));
        setRsdFlg(JSPUtil.getParameter(request, prefix + "rsd_flg", ""));
        setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
        setSpclCgoAuthRjctCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", ""));
        setSpclCgoAuthRmk(JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", ""));
        setEmlSndHisFlg(JSPUtil.getParameter(request, prefix + "eml_snd_his_flg", ""));
        setEdiSndHisFlg(JSPUtil.getParameter(request, prefix + "edi_snd_his_flg", ""));
        setItmStsCd(JSPUtil.getParameter(request, prefix + "itm_sts_cd", ""));
        setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
        setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
        setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
        setEdiUnmapKndCd(JSPUtil.getParameter(request, prefix + "edi_unmap_knd_cd", ""));
        setUpdIndicator(JSPUtil.getParameter(request, prefix + "upd_indicator", ""));
        setEdiUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", ""));
        setSrchType(JSPUtil.getParameter(request, prefix + "srch_type", ""));
        setSpclCgoQty(JSPUtil.getParameter(request, prefix + "spcl_cgo_qty", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PartnerApprovalRequestVO[]
	 */
    public PartnerApprovalRequestVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PartnerApprovalRequestVO[]
	 */
    public PartnerApprovalRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PartnerApprovalRequestVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] n3rdImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n3rd_imdg_subs_rsk_lbl_cd", length));
            String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", length));
            String[] etaDt = (JSPUtil.getParameter(request, prefix + "eta_dt", length));
            String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", length));
            String[] imdgAmdtNo = (JSPUtil.getParameter(request, prefix + "imdg_amdt_no", length));
            String[] imdgSubsRskLblRmk = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_rmk", length));
            String[] scgFlg = (JSPUtil.getParameter(request, prefix + "scg_flg", length));
            String[] radaSkdNo = (JSPUtil.getParameter(request, prefix + "rada_skd_no", length));
            String[] n4thImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n4th_imdg_subs_rsk_lbl_cd", length));
            String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", length));
            String[] toEtaDt = (JSPUtil.getParameter(request, prefix + "to_eta_dt", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] hcdgFlg = (JSPUtil.getParameter(request, prefix + "hcdg_flg", length));
            String[] imdgUnNo = (JSPUtil.getParameter(request, prefix + "imdg_un_no", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] authOfcCd = (JSPUtil.getParameter(request, prefix + "auth_ofc_cd", length));
            String[] hcdgIntmdBcRstrDesc = (JSPUtil.getParameter(request, prefix + "hcdg_intmd_bc_rstr_desc", length));
            String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] voidSltQty = (JSPUtil.getParameter(request, prefix + "void_slt_qty", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", length));
            String[] hgtOvrDimLen = (JSPUtil.getParameter(request, prefix + "hgt_ovr_dim_len", length));
            String[] radaAmt = (JSPUtil.getParameter(request, prefix + "rada_amt", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] netExploWgt = (JSPUtil.getParameter(request, prefix + "net_explo_wgt", length));
            String[] awkFlg = (JSPUtil.getParameter(request, prefix + "awk_flg", length));
            String[] emerRspnGidNo = (JSPUtil.getParameter(request, prefix + "emer_rspn_gid_no", length));
            String[] authUsrId = (JSPUtil.getParameter(request, prefix + "auth_usr_id", length));
            String[] cneeDtlDesc = (JSPUtil.getParameter(request, prefix + "cnee_dtl_desc", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] authFlg = (JSPUtil.getParameter(request, prefix + "auth_flg", length));
            String[] emerCntcPhnNo = (JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no", length));
            String[] measTpCd = (JSPUtil.getParameter(request, prefix + "meas_tp_cd", length));
            String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", length));
            String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", length));
            String[] imdgLmtQtyMeasUtCd = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_meas_ut_cd", length));
            String[] n1stImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n1st_imdg_subs_rsk_lbl_cd", length));
            String[] imdgLmtQty = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty", length));
            String[] inN1stImdgPckCd = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_cd", length));
            String[] outN2ndImdgPckQty = (JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_qty", length));
            String[] emsNo = (JSPUtil.getParameter(request, prefix + "ems_no", length));
            String[] maxInPckQty = (JSPUtil.getParameter(request, prefix + "max_in_pck_qty", length));
            String[] inN2ndImdgPckDesc = (JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_desc", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", length));
            String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] diffRmk = (JSPUtil.getParameter(request, prefix + "diff_rmk", length));
            String[] outN2ndImdgPckDesc = (JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_desc", length));
            String[] authStsCd = (JSPUtil.getParameter(request, prefix + "auth_sts_cd", length));
            String[] outN1stImdgPckCd = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vslNm = (JSPUtil.getParameter(request, prefix + "vsl_nm", length));
            String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", length));
            String[] psaNo = (JSPUtil.getParameter(request, prefix + "psa_no", length));
            String[] inN2ndImdgPckQty = (JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_qty", length));
            String[] netWgtSum = (JSPUtil.getParameter(request, prefix + "net_wgt_sum", length));
            String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix + "dcgo_sts_cd", length));
            String[] emerCntcPsonNm = (JSPUtil.getParameter(request, prefix + "emer_cntc_pson_nm", length));
            String[] imdgSpclProviNo = (JSPUtil.getParameter(request, prefix + "imdg_spcl_provi_no", length));
            String[] outN2ndImdgPckCd = (JSPUtil.getParameter(request, prefix + "out_n2nd_imdg_pck_cd", length));
            String[] crrCd = (JSPUtil.getParameter(request, prefix + "crr_cd", length));
            String[] lfSdOvrDimLen = (JSPUtil.getParameter(request, prefix + "lf_sd_ovr_dim_len", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", length));
            String[] inN2ndImdgPckCd = (JSPUtil.getParameter(request, prefix + "in_n2nd_imdg_pck_cd", length));
            String[] fwrdOvrDimLen = (JSPUtil.getParameter(request, prefix + "fwrd_ovr_dim_len", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] inN1stImdgPckQty = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_qty", length));
            String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix + "mrn_polut_flg", length));
            String[] cntrRefNo = (JSPUtil.getParameter(request, prefix + "cntr_ref_no", length));
            String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", length));
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
            String[] slanCd1 = (JSPUtil.getParameter(request, prefix + "slan_cd1", length));
            String[] radaTrspNo = (JSPUtil.getParameter(request, prefix + "rada_trsp_no", length));
            String[] radaUtCd = (JSPUtil.getParameter(request, prefix + "rada_ut_cd", length));
            String[] maxInPckTpCd = (JSPUtil.getParameter(request, prefix + "max_in_pck_tp_cd", length));
            String[] wgtUtCd2 = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd2", length));
            String[] imdgExptQtyCd = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_cd", length));
            String[] certiNo = (JSPUtil.getParameter(request, prefix + "certi_no", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] fromEtaDt = (JSPUtil.getParameter(request, prefix + "from_eta_dt", length));
            String[] outN1stImdgPckQty = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_qty", length));
            String[] hcdgPckRstrDesc = (JSPUtil.getParameter(request, prefix + "hcdg_pck_rstr_desc", length));
            String[] inN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "in_n1st_imdg_pck_desc", length));
            String[] imdgExptQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_expt_qty_flg", length));
            String[] n2ndImdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix + "n2nd_imdg_subs_rsk_lbl_cd", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] clodFlg = (JSPUtil.getParameter(request, prefix + "clod_flg", length));
            String[] bookingNo = (JSPUtil.getParameter(request, prefix + "booking_no", length));
            String[] stsCt = (JSPUtil.getParameter(request, prefix + "sts_ct", length));
            String[] bkwdOvrDimLen = (JSPUtil.getParameter(request, prefix + "bkwd_ovr_dim_len", length));
            String[] imdgCoGrpCd = (JSPUtil.getParameter(request, prefix + "imdg_co_grp_cd", length));
            String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
            String[] bkgRefNo = (JSPUtil.getParameter(request, prefix + "bkg_ref_no", length));
            String[] cgoOprCd = (JSPUtil.getParameter(request, prefix + "cgo_opr_cd", length));
            String[] dgFlg = (JSPUtil.getParameter(request, prefix + "dg_flg", length));
            String[] ctrlTempCtnt = (JSPUtil.getParameter(request, prefix + "ctrl_temp_ctnt", length));
            String[] hcdgTnkRstrDesc = (JSPUtil.getParameter(request, prefix + "hcdg_tnk_rstr_desc", length));
            String[] prpShpNm = (JSPUtil.getParameter(request, prefix + "prp_shp_nm", length));
            String[] outN1stImdgPckDesc = (JSPUtil.getParameter(request, prefix + "out_n1st_imdg_pck_desc", length));
            String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", length));
            String[] slanCd2 = (JSPUtil.getParameter(request, prefix + "slan_cd2", length));
            String[] slanCd3 = (JSPUtil.getParameter(request, prefix + "slan_cd3", length));
            String[] slanCd4 = (JSPUtil.getParameter(request, prefix + "slan_cd4", length));
            String[] slanCd5 = (JSPUtil.getParameter(request, prefix + "slan_cd5", length));
            String[] slanCd6 = (JSPUtil.getParameter(request, prefix + "slan_cd6", length));
            String[] slanCd7 = (JSPUtil.getParameter(request, prefix + "slan_cd7", length));
            String[] slanCd8 = (JSPUtil.getParameter(request, prefix + "slan_cd8", length));
            String[] slanCd9 = (JSPUtil.getParameter(request, prefix + "slan_cd9", length));
            String[] slanCd10 = (JSPUtil.getParameter(request, prefix + "slan_cd10", length));
            String[] slanCd11 = (JSPUtil.getParameter(request, prefix + "slan_cd11", length));
            String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix + "vps_eta_dt", length));
            String[] imdgSegrGrpNm = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_nm", length));
            String[] imdgSegrGrpNo = (JSPUtil.getParameter(request, prefix + "imdg_segr_grp_no", length));
            String[] stgCate = (JSPUtil.getParameter(request, prefix + "stg_cate", length));
            String[] ediTrsmStsCd = (JSPUtil.getParameter(request, prefix + "edi_trsm_sts_cd", length));
            String[] srcTpCd = (JSPUtil.getParameter(request, prefix + "src_tp_cd", length));
            String[] rsdFlg = (JSPUtil.getParameter(request, prefix + "rsd_flg", length));
            String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix + "dcgo_ref_no", length));
            String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rjct_cd", length));
            String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix + "spcl_cgo_auth_rmk", length));
            String[] emlSndHisFlg = (JSPUtil.getParameter(request, prefix + "eml_snd_his_flg", length));
            String[] ediSndHisFlg = (JSPUtil.getParameter(request, prefix + "edi_snd_his_flg", length));
            String[] itmStsCd = (JSPUtil.getParameter(request, prefix + "itm_sts_cd", length));
            String[] trsmDt = (JSPUtil.getParameter(request, prefix + "trsm_dt", length));
            String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", length));
            String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", length));
            String[] ediUnmapKndCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_knd_cd", length));
            String[] updIndicator = (JSPUtil.getParameter(request, prefix + "upd_indicator", length));
            String[] ediUnmapDtlCd = (JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", length));
            String[] srchType = (JSPUtil.getParameter(request, prefix + "srch_type", length));
            String[] spclCgoQty = (JSPUtil.getParameter(request, prefix + "spcl_cgo_qty", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PartnerApprovalRequestVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (n3rdImdgSubsRskLblCd[i] != null)
                    model.setN3rdImdgSubsRskLblCd(n3rdImdgSubsRskLblCd[i]);
                if (spclCgoRqstSeq[i] != null)
                    model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
                if (etaDt[i] != null)
                    model.setEtaDt(etaDt[i]);
                if (imdgUnNoSeq[i] != null)
                    model.setImdgUnNoSeq(imdgUnNoSeq[i]);
                if (imdgAmdtNo[i] != null)
                    model.setImdgAmdtNo(imdgAmdtNo[i]);
                if (imdgSubsRskLblRmk[i] != null)
                    model.setImdgSubsRskLblRmk(imdgSubsRskLblRmk[i]);
                if (scgFlg[i] != null)
                    model.setScgFlg(scgFlg[i]);
                if (radaSkdNo[i] != null)
                    model.setRadaSkdNo(radaSkdNo[i]);
                if (n4thImdgSubsRskLblCd[i] != null)
                    model.setN4thImdgSubsRskLblCd(n4thImdgSubsRskLblCd[i]);
                if (imdgCompGrpCd[i] != null)
                    model.setImdgCompGrpCd(imdgCompGrpCd[i]);
                if (toEtaDt[i] != null)
                    model.setToEtaDt(toEtaDt[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (hcdgFlg[i] != null)
                    model.setHcdgFlg(hcdgFlg[i]);
                if (imdgUnNo[i] != null)
                    model.setImdgUnNo(imdgUnNo[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
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
                if (podClptIndSeq[i] != null)
                    model.setPodClptIndSeq(podClptIndSeq[i]);
                if (hgtOvrDimLen[i] != null)
                    model.setHgtOvrDimLen(hgtOvrDimLen[i]);
                if (radaAmt[i] != null)
                    model.setRadaAmt(radaAmt[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (netExploWgt[i] != null)
                    model.setNetExploWgt(netExploWgt[i]);
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
                if (authFlg[i] != null)
                    model.setAuthFlg(authFlg[i]);
                if (emerCntcPhnNo[i] != null)
                    model.setEmerCntcPhnNo(emerCntcPhnNo[i]);
                if (measTpCd[i] != null)
                    model.setMeasTpCd(measTpCd[i]);
                if (imdgPckGrpCd[i] != null)
                    model.setImdgPckGrpCd(imdgPckGrpCd[i]);
                if (flshPntCdoTemp[i] != null)
                    model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
                if (imdgLmtQtyMeasUtCd[i] != null)
                    model.setImdgLmtQtyMeasUtCd(imdgLmtQtyMeasUtCd[i]);
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
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (imdgSubsRskLblCd[i] != null)
                    model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
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
                if (vslNm[i] != null)
                    model.setVslNm(vslNm[i]);
                if (ttlDimWdt[i] != null)
                    model.setTtlDimWdt(ttlDimWdt[i]);
                if (psaNo[i] != null)
                    model.setPsaNo(psaNo[i]);
                if (inN2ndImdgPckQty[i] != null)
                    model.setInN2ndImdgPckQty(inN2ndImdgPckQty[i]);
                if (netWgtSum[i] != null)
                    model.setNetWgtSum(netWgtSum[i]);
                if (dcgoStsCd[i] != null)
                    model.setDcgoStsCd(dcgoStsCd[i]);
                if (emerCntcPsonNm[i] != null)
                    model.setEmerCntcPsonNm(emerCntcPsonNm[i]);
                if (imdgSpclProviNo[i] != null)
                    model.setImdgSpclProviNo(imdgSpclProviNo[i]);
                if (outN2ndImdgPckCd[i] != null)
                    model.setOutN2ndImdgPckCd(outN2ndImdgPckCd[i]);
                if (crrCd[i] != null)
                    model.setCrrCd(crrCd[i]);
                if (lfSdOvrDimLen[i] != null)
                    model.setLfSdOvrDimLen(lfSdOvrDimLen[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (polClptIndSeq[i] != null)
                    model.setPolClptIndSeq(polClptIndSeq[i]);
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
                if (rgnShpOprCd[i] != null)
                    model.setRgnShpOprCd(rgnShpOprCd[i]);
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
                if (slanCd1[i] != null)
                    model.setSlanCd1(slanCd1[i]);
                if (radaTrspNo[i] != null)
                    model.setRadaTrspNo(radaTrspNo[i]);
                if (radaUtCd[i] != null)
                    model.setRadaUtCd(radaUtCd[i]);
                if (maxInPckTpCd[i] != null)
                    model.setMaxInPckTpCd(maxInPckTpCd[i]);
                if (wgtUtCd2[i] != null)
                    model.setWgtUtCd2(wgtUtCd2[i]);
                if (imdgExptQtyCd[i] != null)
                    model.setImdgExptQtyCd(imdgExptQtyCd[i]);
                if (certiNo[i] != null)
                    model.setCertiNo(certiNo[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (fromEtaDt[i] != null)
                    model.setFromEtaDt(fromEtaDt[i]);
                if (outN1stImdgPckQty[i] != null)
                    model.setOutN1stImdgPckQty(outN1stImdgPckQty[i]);
                if (hcdgPckRstrDesc[i] != null)
                    model.setHcdgPckRstrDesc(hcdgPckRstrDesc[i]);
                if (inN1stImdgPckDesc[i] != null)
                    model.setInN1stImdgPckDesc(inN1stImdgPckDesc[i]);
                if (imdgExptQtyFlg[i] != null)
                    model.setImdgExptQtyFlg(imdgExptQtyFlg[i]);
                if (n2ndImdgSubsRskLblCd[i] != null)
                    model.setN2ndImdgSubsRskLblCd(n2ndImdgSubsRskLblCd[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (clodFlg[i] != null)
                    model.setClodFlg(clodFlg[i]);
                if (bookingNo[i] != null)
                    model.setBookingNo(bookingNo[i]);
                if (stsCt[i] != null)
                    model.setStsCt(stsCt[i]);
                if (bkwdOvrDimLen[i] != null)
                    model.setBkwdOvrDimLen(bkwdOvrDimLen[i]);
                if (imdgCoGrpCd[i] != null)
                    model.setImdgCoGrpCd(imdgCoGrpCd[i]);
                if (skdDirCd[i] != null)
                    model.setSkdDirCd(skdDirCd[i]);
                if (bkgRefNo[i] != null)
                    model.setBkgRefNo(bkgRefNo[i]);
                if (cgoOprCd[i] != null)
                    model.setCgoOprCd(cgoOprCd[i]);
                if (dgFlg[i] != null)
                    model.setDgFlg(dgFlg[i]);
                if (ctrlTempCtnt[i] != null)
                    model.setCtrlTempCtnt(ctrlTempCtnt[i]);
                if (hcdgTnkRstrDesc[i] != null)
                    model.setHcdgTnkRstrDesc(hcdgTnkRstrDesc[i]);
                if (prpShpNm[i] != null)
                    model.setPrpShpNm(prpShpNm[i]);
                if (outN1stImdgPckDesc[i] != null)
                    model.setOutN1stImdgPckDesc(outN1stImdgPckDesc[i]);
                if (imdgLmtQtyFlg[i] != null)
                    model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
                if (slanCd2[i] != null)
                    model.setSlanCd2(slanCd2[i]);
                if (slanCd3[i] != null)
                    model.setSlanCd3(slanCd3[i]);
                if (slanCd4[i] != null)
                    model.setSlanCd4(slanCd4[i]);
                if (slanCd5[i] != null)
                    model.setSlanCd5(slanCd5[i]);
                if (slanCd6[i] != null)
                    model.setSlanCd6(slanCd6[i]);
                if (slanCd7[i] != null)
                    model.setSlanCd7(slanCd7[i]);
                if (slanCd8[i] != null)
                    model.setSlanCd8(slanCd8[i]);
                if (slanCd9[i] != null)
                    model.setSlanCd9(slanCd9[i]);
                if (slanCd10[i] != null)
                    model.setSlanCd10(slanCd10[i]);
                if (slanCd11[i] != null)
                    model.setSlanCd11(slanCd11[i]);
                if (vpsEtaDt[i] != null)
                    model.setVpsEtaDt(vpsEtaDt[i]);
                if (imdgSegrGrpNm[i] != null)
                    model.setImdgSegrGrpNm(imdgSegrGrpNm[i]);
                if (imdgSegrGrpNo[i] != null)
                    model.setImdgSegrGrpNo(imdgSegrGrpNo[i]);
                if (stgCate[i] != null)
                    model.setStgCate(stgCate[i]);
                if (ediTrsmStsCd[i] != null)
                    model.setEdiTrsmStsCd(ediTrsmStsCd[i]);
                if (srcTpCd[i] != null)
                    model.setSrcTpCd(srcTpCd[i]);
                if (rsdFlg[i] != null)
                    model.setRsdFlg(rsdFlg[i]);
                if (dcgoRefNo[i] != null)
                    model.setDcgoRefNo(dcgoRefNo[i]);
                if (spclCgoAuthRjctCd[i] != null)
                    model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
                if (spclCgoAuthRmk[i] != null)
                    model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
                if (emlSndHisFlg[i] != null)
                    model.setEmlSndHisFlg(emlSndHisFlg[i]);
                if (ediSndHisFlg[i] != null)
                    model.setEdiSndHisFlg(ediSndHisFlg[i]);
                if (itmStsCd[i] != null)
                    model.setItmStsCd(itmStsCd[i]);
                if (trsmDt[i] != null)
                    model.setTrsmDt(trsmDt[i]);
                if (prnrSpclCgoSeq[i] != null)
                    model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
                if (prnrCgoRqstSeq[i] != null)
                    model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
                if (ediUnmapKndCd[i] != null)
                    model.setEdiUnmapKndCd(ediUnmapKndCd[i]);
                if (updIndicator[i] != null) 
		    		model.setUpdIndicator(updIndicator[i]);
                if (ediUnmapDtlCd[i] != null) 
		    		model.setEdiUnmapDtlCd(ediUnmapDtlCd[i]);
                if (srchType[i] != null) 
		    		model.setSrchType(srchType[i]);
                if (spclCgoQty[i] != null) 
		    		model.setSpclCgoQty(spclCgoQty[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPartnerApprovalRequestVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return PartnerApprovalRequestVO[]
	 */
    public PartnerApprovalRequestVO[] getPartnerApprovalRequestVOs() {
        PartnerApprovalRequestVO[] vos = (PartnerApprovalRequestVO[]) models.toArray(new PartnerApprovalRequestVO[models.size()]);
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
        this.etaDt = this.etaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNoSeq = this.imdgUnNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgAmdtNo = this.imdgAmdtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblRmk = this.imdgSubsRskLblRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scgFlg = this.scgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaSkdNo = this.radaSkdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n4thImdgSubsRskLblCd = this.n4thImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCompGrpCd = this.imdgCompGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.toEtaDt = this.toEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgFlg = this.hcdgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgUnNo = this.imdgUnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authOfcCd = this.authOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgIntmdBcRstrDesc = this.hcdgIntmdBcRstrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoCateCd = this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.voidSltQty = this.voidSltQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podClptIndSeq = this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hgtOvrDimLen = this.hgtOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaAmt = this.radaAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netExploWgt = this.netExploWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkFlg = this.awkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerRspnGidNo = this.emerRspnGidNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authUsrId = this.authUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cneeDtlDesc = this.cneeDtlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authFlg = this.authFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPhnNo = this.emerCntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measTpCd = this.measTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgPckGrpCd = this.imdgPckGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flshPntCdoTemp = this.flshPntCdoTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyMeasUtCd = this.imdgLmtQtyMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n1stImdgSubsRskLblCd = this.n1stImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQty = this.imdgLmtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckCd = this.inN1stImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN2ndImdgPckQty = this.outN2ndImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emsNo = this.emsNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxInPckQty = this.maxInPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN2ndImdgPckDesc = this.inN2ndImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSubsRskLblCd = this.imdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclStwgRqstDesc = this.spclStwgRqstDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diffRmk = this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN2ndImdgPckDesc = this.outN2ndImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.authStsCd = this.authStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckCd = this.outN1stImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslNm = this.vslNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlDimWdt = this.ttlDimWdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.psaNo = this.psaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN2ndImdgPckQty = this.inN2ndImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.netWgtSum = this.netWgtSum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoStsCd = this.dcgoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.emerCntcPsonNm = this.emerCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSpclProviNo = this.imdgSpclProviNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN2ndImdgPckCd = this.outN2ndImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.crrCd = this.crrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lfSdOvrDimLen = this.lfSdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polClptIndSeq = this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN2ndImdgPckCd = this.inN2ndImdgPckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fwrdOvrDimLen = this.fwrdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckQty = this.inN1stImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mrnPolutFlg = this.mrnPolutFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrRefNo = this.cntrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rgnShpOprCd = this.rgnShpOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.slanCd1 = this.slanCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaTrspNo = this.radaTrspNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.radaUtCd = this.radaUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.maxInPckTpCd = this.maxInPckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd2 = this.wgtUtCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyCd = this.imdgExptQtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.certiNo = this.certiNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fromEtaDt = this.fromEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckQty = this.outN1stImdgPckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgPckRstrDesc = this.hcdgPckRstrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inN1stImdgPckDesc = this.inN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgExptQtyFlg = this.imdgExptQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n2ndImdgSubsRskLblCd = this.n2ndImdgSubsRskLblCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clodFlg = this.clodFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bookingNo = this.bookingNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stsCt = this.stsCt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkwdOvrDimLen = this.bkwdOvrDimLen.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgCoGrpCd = this.imdgCoGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgRefNo = this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoOprCd = this.cgoOprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgFlg = this.dgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrlTempCtnt = this.ctrlTempCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hcdgTnkRstrDesc = this.hcdgTnkRstrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prpShpNm = this.prpShpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outN1stImdgPckDesc = this.outN1stImdgPckDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgLmtQtyFlg = this.imdgLmtQtyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd2 = this.slanCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd3 = this.slanCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd4 = this.slanCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd5 = this.slanCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd6 = this.slanCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd7 = this.slanCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd8 = this.slanCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd9 = this.slanCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd10 = this.slanCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd11 = this.slanCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsEtaDt = this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNm = this.imdgSegrGrpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgSegrGrpNo = this.imdgSegrGrpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stgCate = this.stgCate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediTrsmStsCd = this.ediTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srcTpCd = this.srcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rsdFlg = this.rsdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoRefNo = this.dcgoRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoAuthRmk = this.spclCgoAuthRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trsmDt = this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrSpclCgoSeq = this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prnrCgoRqstSeq = this.prnrCgoRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapKndCd = this.ediUnmapKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updIndicator = this.updIndicator.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediUnmapDtlCd = this.ediUnmapDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.srchType = this.srchType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoQty = this.spclCgoQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
