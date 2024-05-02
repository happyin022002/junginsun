/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgBookingInfoVO.java
*@FileTitle : BkgBookingInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.30
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.07.30 김민정 
* 1.0 Creation
 * --------------------------------------------------------
 * History 
 * 2014.09.02 김태균 ESM_BKG_0079_01 화면중 Vendor Remark 개발
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BkgBookingInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BkgBookingInfoVO> models = new ArrayList<BkgBookingInfoVO>();

    /* Column Info */
    private String bkgDelYdCd = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String awkCgoFlgOld = null;

    /* Column Info */
    private String orgTrnsModCd = null;

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String taaAvailable = null;

    /* Column Info */
    private String mtyPkupYdCd = null;

    /* Column Info */
    private String polYdCdOld = null;

    /* Column Info */
    private String cmdtCdOld = null;

    /* Column Info */
    private String bkgCntcPsonFaxNo = null;

    /* Column Info */
    private String mtyPkupDtOld = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String obSrepCd = null;

    /* Column Info */
    private String destTrnsSvcModCd = null;

    /* Column Info */
    private String bkgPodCd = null;

    /* Column Info */
    private String fnlDestNm = null;

    /* Column Info */
    private String porCdOld = null;

    /* Column Info */
    private String oldBkgNo = null;

    /* Column Info */
    private String ctrtOfcCd = null;

    /* Column Info */
    private String refFlg = null;

    /* Column Info */
    private String bbFlg = null;

    /* Column Info */
    private String stwgRmk = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String podCdOld = null;

    /* Column Info */
    private String siFlg = null;

    /* Column Info */
    private String updUsrId = null;

    /* Column Info */
    private String bkgOfcCd = null;

    /* Column Info */
    private String mnlBkgNoFlg = null;

    /* Column Info */
    private String xterSiRefNo = null;

    /* Column Info */
    private String orgScontiCd = null;

    /* Column Info */
    private String bkgCntcPsonEml = null;

    /* Column Info */
    private String fullRtnYdCd = null;

    /* Column Info */
    private String dcgoFlgOld = null;

    /* Column Info */
    private String mtyDorArrDtOld = null;

    /* Column Info */
    private String deDueDt = null;

    /* Column Info */
    private String lodgDueDt = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String ediHldFlg = null;

    /* Column Info */
    private String cmdtDesc = null;

    /* Column Info */
    private String spclHideFlg = null;

    /* Column Info */
    private String ctrtSrepCd = null;

    /* Column Info */
    private String awkFlg = null;

    /* Column Info */
    private String siCntcPsonFaxNo = null;

    /* Column Info */
    private String stwgFlg = null;

    /* Column Info */
    private String partialVvdAssignFlg = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String preRlyPortYdCd = null;

    /* Column Info */
    private String bkgPolYdCd = null;

    /* Column Info */
    private String splitRsnCd = null;

    /* Column Info */
    private String waitRsn = null;

    /* Column Info */
    private String destTrnsModCd = null;

    /* Column Info */
    private String siCntcPsonPhnNo = null;

    /* Column Info */
    private String rfFlg = null;

    /* Column Info */
    private String lodgDueDtOld = null;

    /* Column Info */
    private String stopOffLocCd = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String bkgStsCd = null;

    /* Column Info */
    private String fdGrdFlg = null;

    /* Column Info */
    private String interRmk = null;

    /* Column Info */
    private String scacCd = null;

    /* Column Info */
    private String cmdtCd = null;

    /* Column Info */
    private String fullPkupYdCd = null;

    /* Column Info */
    private String rcvTermCdOld = null;

    /* Column Info */
    private String isRatedFlg = null;

    /* Column Info */
    private String mtyPkupYdCdOld = null;

    /* Column Info */
    private String stopOffCntcPsonNm = null;

    /* Column Info */
    private String podNm = null;

    /* Column Info */
    private String stopOffFlg = null;

    /* Column Info */
    private String bkgPodYdCd = null;

    /* Column Info */
    private String delNm = null;

    /* Column Info */
    private String porYdCdOld = null;

    /* Column Info */
    private String filerCd = null;

    /* Column Info */
    private String xterRqstAutoNtcFlg = null;

    /* Column Info */
    private String destScontiCd = null;

    /* Column Info */
    private String mtyDorArrDt = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String polCdOld = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String taaNo = null;

    /* Column Info */
    private String siCntcPsonMphnNo = null;

    /* Column Info */
    private String flexHgtFlg = null;

    /* Column Info */
    private String cntrFlg = null;

    /* Column Info */
    private String lastVvdCd = null;

    /* Column Info */
    private String repCmdtCd = null;

    /* Column Info */
    private String rejectFlag = null;

    /* Column Info */
    private String firstPolCd = null;

    /* Column Info */
    private String bkgCntcPsonPhnNo = null;

    /* Column Info */
    private String ocpCd = null;

    /* Column Info */
    private String polNm = null;

    /* Column Info */
    private String caUser = null;

    /* Column Info */
    private String blckStwgCd = null;

    /* Column Info */
    private String blNo = null;

    /* Column Info */
    private String bkgTrunkVvd = null;

    /* Column Info */
    private String pctlNo = null;

    /* Column Info */
    private String podYdCdOld = null;

    /* Column Info */
    private String rollOvrCnt = null;

    /* Column Info */
    private String scNo = null;

    /* Column Info */
    private String prctFlg = null;

    /* Column Info */
    private String taaNoOld = null;

    /* Column Info */
    private String wgtUtCd = null;

    /* Column Info */
    private String rfaNoOld = null;

    /* Column Info */
    private String usrEml = null;

    /* Column Info */
    private String obSlsOfcCd = null;

    /* Column Info */
    private String xterSiCd = null;

    /* Column Info */
    private String mtyPkupDt = null;

    /* Column Info */
    private String cndCstmsFileCd = null;

    /* Column Info */
    private String xterBkgRqstCd = null;

    /* Column Info */
    private String bkgPorCd = null;

    /* Column Info */
    private String lastPodCd = null;

    /* Column Info */
    private String preRlyPortCd = null;

    /* Column Info */
    private String bbCgoFlgOld = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String stopOffCntcPhnNo = null;

    /* Column Info */
    private String pstVvdCd = null;

    /* Column Info */
    private String creUsrId = null;

    /* Column Info */
    private String porNm = null;

    /* Column Info */
    private String rfaAvailable = null;

    /* Column Info */
    private String xterRmk = null;

    /* Column Info */
    private String xterBkgRqstRefNo = null;

    /* Column Info */
    private String pstRlyPortCd = null;

    /* Column Info */
    private String splitFlg = null;

    /* Column Info */
    private String fullRtnYdCdOld = null;

    /* Column Info */
    private String xtnPhnNo = null;

    /* Column Info */
    private String docUsrId = null;

    /* Column Info */
    private String orgTrnsSvcModCd = null;

    /* Column Info */
    private String pstRlyPortYdCd = null;

    /* Column Info */
    private String scNoOld = null;

    /* Column Info */
    private String bdrFlg = null;

    /* Column Info */
    private String siCntcPsonEml = null;

    /* Column Info */
    private String rcFlgOld = null;

    /* Column Info */
    private String bkgCntcPsonNm = null;

    /* Column Info */
    private String stopOffDiffRmk = null;

    /* Column Info */
    private String advShtgCd = null;

    /* Column Info */
    private String hotDeFlg = null;

    /* Column Info */
    private String eqSubstFlg = null;

    /* Column Info */
    private String vvdFlag = null;

    /* Column Info */
    private String revDirCd = null;

    /* Column Info */
    private String rfaNo = null;

    /* Column Info */
    private String fmcNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String railBlkCd = null;

    /* Column Info */
    private String usrNm = null;

    /* Column Info */
    private String bkgDelCd = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String caFlg = null;

    /* Column Info */
    private String bkgCntcPsonMphnNo = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String siCntcPsonNm = null;

    /* Column Info */
    private String bkgPolCd = null;

    /* Column Info */
    private String deTermCdOld = null;

    /* Column Info */
    private String scAvailable = null;

    /* Column Info */
    private String delYdCdOld = null;

    /* Column Info */
    private String lastPodClptIndSeq = null;

    /* Column Info */
    private String premiumAvailableFlg = null;

    /* Column Info */
    private String twnSoNo = null;

    /* Column Info */
    private String deDueDtOld = null;

    /* Column Info */
    private String bkgTrunkVvdOld = null;

    /* Column Info */
    private String usaCstmsFileCd = null;

    /* Column Info */
    private String actWgt = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String dgFlg = null;

    /* Column Info */
    private String firstPolClptIndSeq = null;

    /* Column Info */
    private String bkgPorYdCd = null;

    /* Column Info */
    private String delCdOld = null;

    /* Column Info */
    private String hngrFlg = null;

    /* Column Info */
    private String mtyRtnYdCd = null;

    /* Column Info */
    private String firstVvdCd = null;

    /* Column Info */
    private String preVvdCd = null;

    /* Column Info */
    private String vndrRmk = null;

    /* Column Info */
    private String bkgCtrlPtyCustCntCd = null;

    /* Column Info */
    private String bkgCtrlPtyCustSeq = null;

    /* Column Info */
    private String bkgCtrlPtyCustNm = null;

    /* Column Info */
    private String bkgWtChkFlg = null;

    /* Column Info */
    private String xterRqstSeq = null;

    /* Column Info */
    private String irrBlNoFlg = null;

    /* Column Info */
    private String bkgTyFlg = null;

    /* Column Info */
    private String xterVgmRqstCd = null;

    /* Column Info */
    private String bkgPtyCntCd = null;

    /* Column Info */
    private String bkgPtyCustSeq = null;

    /* Column Info */
    private String bkgPtyCustNm = null;

    /* Column Info */
    private String updDt = null;

    /* Column Info */
    private String lstSavDt = null;

    /* Column Info */
    private String modifyCargoFlg = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public BkgBookingInfoVO() {
    }

    public BkgBookingInfoVO(String ibflag, String pagerows, String bkgNo, String oldBkgNo, String mnlBkgNoFlg, String splitFlg, String splitRsnCd, String advShtgCd, String ediHldFlg, String blNo, String siFlg, String bdrFlg, String caFlg, String caUser, String bkgStsCd, String waitRsn, String slanCd, String svcScpCd, String bkgTrunkVvd, String bkgTrunkVvdOld, String bkgPorCd, String porCdOld, String porNm, String bkgPorYdCd, String porYdCdOld, String bkgPolCd, String polCdOld, String polNm, String bkgPolYdCd, String polYdCdOld, String bkgPodCd, String podCdOld, String podNm, String bkgPodYdCd, String podYdCdOld, String bkgDelCd, String delCdOld, String delNm, String bkgDelYdCd, String delYdCdOld, String fnlDestNm, String ocpCd, String rcvTermCd, String rcvTermCdOld, String deTermCd, String deTermCdOld, String preRlyPortCd, String preRlyPortYdCd, String preVvdCd, String pstRlyPortCd, String pstRlyPortYdCd, String pstVvdCd, String pctlNo, String usaCstmsFileCd, String cndCstmsFileCd, String scacCd, String rfaNo, String rfaNoOld, String rfaAvailable, String scNo, String scNoOld, String scAvailable, String taaNo, String taaNoOld, String taaAvailable, String ctrtOfcCd, String ctrtSrepCd, String actWgt, String wgtUtCd, String cmdtCd, String cmdtCdOld, String repCmdtCd, String cmdtDesc, String flexHgtFlg, String dcgoFlg, String dcgoFlgOld, String rcFlg, String rcFlgOld, String awkCgoFlg, String awkCgoFlgOld, String bbCgoFlg, String bbCgoFlgOld, String rdCgoFlg, String socFlg, String eqSubstFlg, String rejectFlag, String dgFlg, String rfFlg, String awkFlg, String bbFlg, String stwgFlg, String stwgCd, String stwgRmk, String hngrFlg, String stopOffFlg, String stopOffLocCd, String stopOffCntcPsonNm, String stopOffCntcPhnNo, String stopOffDiffRmk, String railBlkCd, String hotDeFlg, String spclHideFlg, String fdGrdFlg, String prctFlg, String twnSoNo, String bkgCgoTpCd, String premiumAvailableFlg, String mtyDorArrDt, String mtyDorArrDtOld, String lodgDueDt, String lodgDueDtOld, String deDueDt, String deDueDtOld, String mtyPkupYdCd, String mtyPkupYdCdOld, String mtyPkupDt, String mtyPkupDtOld, String fullRtnYdCd, String fullRtnYdCdOld, String mtyRtnYdCd, String fullPkupYdCd, String partialVvdAssignFlg, String cntrFlg, String orgScontiCd, String destScontiCd, String orgTrnsSvcModCd, String destTrnsSvcModCd, String orgTrnsModCd, String destTrnsModCd, String blckStwgCd, String refFlg, String rollOvrCnt, String obSlsOfcCd, String obSrepCd, String bkgOfcCd, String usrNm, String docUsrId, String ofcCd, String usrEml, String xtnPhnNo, String xterBkgRqstCd, String xterBkgRqstRefNo, String xterSiCd, String xterSiRefNo, String xterRqstAutoNtcFlg, String interRmk, String xterRmk, String fmcNo, String revDirCd, String firstPolCd, String firstPolClptIndSeq, String firstVvdCd, String lastPodCd, String lastPodClptIndSeq, String lastVvdCd, String creUsrId, String updUsrId, String vvdFlag, String filerCd, String isRatedFlg, String bkgCntcPsonNm, String bkgCntcPsonEml, String bkgCntcPsonFaxNo, String bkgCntcPsonMphnNo, String bkgCntcPsonPhnNo, String siCntcPsonNm, String siCntcPsonEml, String siCntcPsonFaxNo, String siCntcPsonMphnNo, String siCntcPsonPhnNo, String vndrRmk, String bkgCtrlPtyCustCntCd, String bkgCtrlPtyCustSeq, String bkgCtrlPtyCustNm, String bkgWtChkFlg, String xterRqstSeq, String irrBlNoFlg, String bkgTyFlg, String xterVgmRqstCd, String bkgPtyCntCd, String bkgPtyCustSeq, String bkgPtyCustNm, String updDt, String lstSavDt, String modifyCargoFlg) {
        this.bkgDelYdCd = bkgDelYdCd;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.awkCgoFlgOld = awkCgoFlgOld;
        this.orgTrnsModCd = orgTrnsModCd;
        this.svcScpCd = svcScpCd;
        this.taaAvailable = taaAvailable;
        this.mtyPkupYdCd = mtyPkupYdCd;
        this.polYdCdOld = polYdCdOld;
        this.cmdtCdOld = cmdtCdOld;
        this.bkgCntcPsonFaxNo = bkgCntcPsonFaxNo;
        this.mtyPkupDtOld = mtyPkupDtOld;
        this.pagerows = pagerows;
        this.obSrepCd = obSrepCd;
        this.destTrnsSvcModCd = destTrnsSvcModCd;
        this.bkgPodCd = bkgPodCd;
        this.fnlDestNm = fnlDestNm;
        this.porCdOld = porCdOld;
        this.oldBkgNo = oldBkgNo;
        this.ctrtOfcCd = ctrtOfcCd;
        this.refFlg = refFlg;
        this.bbFlg = bbFlg;
        this.stwgRmk = stwgRmk;
        this.stwgCd = stwgCd;
        this.podCdOld = podCdOld;
        this.siFlg = siFlg;
        this.updUsrId = updUsrId;
        this.bkgOfcCd = bkgOfcCd;
        this.mnlBkgNoFlg = mnlBkgNoFlg;
        this.xterSiRefNo = xterSiRefNo;
        this.orgScontiCd = orgScontiCd;
        this.bkgCntcPsonEml = bkgCntcPsonEml;
        this.fullRtnYdCd = fullRtnYdCd;
        this.dcgoFlgOld = dcgoFlgOld;
        this.mtyDorArrDtOld = mtyDorArrDtOld;
        this.deDueDt = deDueDt;
        this.lodgDueDt = lodgDueDt;
        this.bkgNo = bkgNo;
        this.ediHldFlg = ediHldFlg;
        this.cmdtDesc = cmdtDesc;
        this.spclHideFlg = spclHideFlg;
        this.ctrtSrepCd = ctrtSrepCd;
        this.awkFlg = awkFlg;
        this.siCntcPsonFaxNo = siCntcPsonFaxNo;
        this.stwgFlg = stwgFlg;
        this.partialVvdAssignFlg = partialVvdAssignFlg;
        this.rcFlg = rcFlg;
        this.preRlyPortYdCd = preRlyPortYdCd;
        this.bkgPolYdCd = bkgPolYdCd;
        this.splitRsnCd = splitRsnCd;
        this.waitRsn = waitRsn;
        this.destTrnsModCd = destTrnsModCd;
        this.siCntcPsonPhnNo = siCntcPsonPhnNo;
        this.rfFlg = rfFlg;
        this.lodgDueDtOld = lodgDueDtOld;
        this.stopOffLocCd = stopOffLocCd;
        this.rdCgoFlg = rdCgoFlg;
        this.bkgStsCd = bkgStsCd;
        this.fdGrdFlg = fdGrdFlg;
        this.interRmk = interRmk;
        this.scacCd = scacCd;
        this.cmdtCd = cmdtCd;
        this.fullPkupYdCd = fullPkupYdCd;
        this.rcvTermCdOld = rcvTermCdOld;
        this.isRatedFlg = isRatedFlg;
        this.mtyPkupYdCdOld = mtyPkupYdCdOld;
        this.stopOffCntcPsonNm = stopOffCntcPsonNm;
        this.podNm = podNm;
        this.stopOffFlg = stopOffFlg;
        this.bkgPodYdCd = bkgPodYdCd;
        this.delNm = delNm;
        this.porYdCdOld = porYdCdOld;
        this.filerCd = filerCd;
        this.xterRqstAutoNtcFlg = xterRqstAutoNtcFlg;
        this.destScontiCd = destScontiCd;
        this.mtyDorArrDt = mtyDorArrDt;
        this.ofcCd = ofcCd;
        this.polCdOld = polCdOld;
        this.slanCd = slanCd;
        this.taaNo = taaNo;
        this.siCntcPsonMphnNo = siCntcPsonMphnNo;
        this.flexHgtFlg = flexHgtFlg;
        this.cntrFlg = cntrFlg;
        this.lastVvdCd = lastVvdCd;
        this.repCmdtCd = repCmdtCd;
        this.rejectFlag = rejectFlag;
        this.firstPolCd = firstPolCd;
        this.bkgCntcPsonPhnNo = bkgCntcPsonPhnNo;
        this.ocpCd = ocpCd;
        this.polNm = polNm;
        this.caUser = caUser;
        this.blckStwgCd = blckStwgCd;
        this.blNo = blNo;
        this.bkgTrunkVvd = bkgTrunkVvd;
        this.pctlNo = pctlNo;
        this.podYdCdOld = podYdCdOld;
        this.rollOvrCnt = rollOvrCnt;
        this.scNo = scNo;
        this.prctFlg = prctFlg;
        this.taaNoOld = taaNoOld;
        this.wgtUtCd = wgtUtCd;
        this.rfaNoOld = rfaNoOld;
        this.usrEml = usrEml;
        this.obSlsOfcCd = obSlsOfcCd;
        this.xterSiCd = xterSiCd;
        this.mtyPkupDt = mtyPkupDt;
        this.cndCstmsFileCd = cndCstmsFileCd;
        this.xterBkgRqstCd = xterBkgRqstCd;
        this.bkgPorCd = bkgPorCd;
        this.lastPodCd = lastPodCd;
        this.preRlyPortCd = preRlyPortCd;
        this.bbCgoFlgOld = bbCgoFlgOld;
        this.awkCgoFlg = awkCgoFlg;
        this.stopOffCntcPhnNo = stopOffCntcPhnNo;
        this.pstVvdCd = pstVvdCd;
        this.creUsrId = creUsrId;
        this.porNm = porNm;
        this.rfaAvailable = rfaAvailable;
        this.xterRmk = xterRmk;
        this.xterBkgRqstRefNo = xterBkgRqstRefNo;
        this.pstRlyPortCd = pstRlyPortCd;
        this.splitFlg = splitFlg;
        this.fullRtnYdCdOld = fullRtnYdCdOld;
        this.xtnPhnNo = xtnPhnNo;
        this.docUsrId = docUsrId;
        this.orgTrnsSvcModCd = orgTrnsSvcModCd;
        this.pstRlyPortYdCd = pstRlyPortYdCd;
        this.scNoOld = scNoOld;
        this.bdrFlg = bdrFlg;
        this.siCntcPsonEml = siCntcPsonEml;
        this.rcFlgOld = rcFlgOld;
        this.bkgCntcPsonNm = bkgCntcPsonNm;
        this.stopOffDiffRmk = stopOffDiffRmk;
        this.advShtgCd = advShtgCd;
        this.hotDeFlg = hotDeFlg;
        this.eqSubstFlg = eqSubstFlg;
        this.vvdFlag = vvdFlag;
        this.revDirCd = revDirCd;
        this.rfaNo = rfaNo;
        this.fmcNo = fmcNo;
        this.ibflag = ibflag;
        this.railBlkCd = railBlkCd;
        this.usrNm = usrNm;
        this.bkgDelCd = bkgDelCd;
        this.bbCgoFlg = bbCgoFlg;
        this.dcgoFlg = dcgoFlg;
        this.caFlg = caFlg;
        this.bkgCntcPsonMphnNo = bkgCntcPsonMphnNo;
        this.rcvTermCd = rcvTermCd;
        this.siCntcPsonNm = siCntcPsonNm;
        this.bkgPolCd = bkgPolCd;
        this.deTermCdOld = deTermCdOld;
        this.scAvailable = scAvailable;
        this.delYdCdOld = delYdCdOld;
        this.lastPodClptIndSeq = lastPodClptIndSeq;
        this.premiumAvailableFlg = premiumAvailableFlg;
        this.twnSoNo = twnSoNo;
        this.deDueDtOld = deDueDtOld;
        this.bkgTrunkVvdOld = bkgTrunkVvdOld;
        this.usaCstmsFileCd = usaCstmsFileCd;
        this.actWgt = actWgt;
        this.socFlg = socFlg;
        this.deTermCd = deTermCd;
        this.dgFlg = dgFlg;
        this.firstPolClptIndSeq = firstPolClptIndSeq;
        this.bkgPorYdCd = bkgPorYdCd;
        this.delCdOld = delCdOld;
        this.hngrFlg = hngrFlg;
        this.mtyRtnYdCd = mtyRtnYdCd;
        this.firstVvdCd = firstVvdCd;
        this.preVvdCd = preVvdCd;
        this.vndrRmk = vndrRmk;
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustNm;
        this.bkgWtChkFlg = bkgWtChkFlg;
        this.xterRqstSeq = xterRqstSeq;
        this.irrBlNoFlg = irrBlNoFlg;
        this.bkgTyFlg = bkgTyFlg;
        this.xterVgmRqstCd = xterVgmRqstCd;
        this.bkgPtyCntCd = bkgPtyCntCd;
        this.bkgPtyCustSeq = bkgPtyCustSeq;
        this.bkgPtyCustNm = bkgPtyCustNm;
        this.updDt = updDt;
        this.lstSavDt = lstSavDt;
        this.modifyCargoFlg = modifyCargoFlg;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_del_yd_cd", getBkgDelYdCd());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("awk_cgo_flg_old", getAwkCgoFlgOld());
        this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("taa_available", getTaaAvailable());
        this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
        this.hashColumns.put("pol_yd_cd_old", getPolYdCdOld());
        this.hashColumns.put("cmdt_cd_old", getCmdtCdOld());
        this.hashColumns.put("bkg_cntc_pson_fax_no", getBkgCntcPsonFaxNo());
        this.hashColumns.put("mty_pkup_dt_old", getMtyPkupDtOld());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ob_srep_cd", getObSrepCd());
        this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
        this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
        this.hashColumns.put("fnl_dest_nm", getFnlDestNm());
        this.hashColumns.put("por_cd_old", getPorCdOld());
        this.hashColumns.put("old_bkg_no", getOldBkgNo());
        this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
        this.hashColumns.put("ref_flg", getRefFlg());
        this.hashColumns.put("bb_flg", getBbFlg());
        this.hashColumns.put("stwg_rmk", getStwgRmk());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("pod_cd_old", getPodCdOld());
        this.hashColumns.put("si_flg", getSiFlg());
        this.hashColumns.put("upd_usr_id", getUpdUsrId());
        this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
        this.hashColumns.put("mnl_bkg_no_flg", getMnlBkgNoFlg());
        this.hashColumns.put("xter_si_ref_no", getXterSiRefNo());
        this.hashColumns.put("org_sconti_cd", getOrgScontiCd());
        this.hashColumns.put("bkg_cntc_pson_eml", getBkgCntcPsonEml());
        this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
        this.hashColumns.put("dcgo_flg_old", getDcgoFlgOld());
        this.hashColumns.put("mty_dor_arr_dt_old", getMtyDorArrDtOld());
        this.hashColumns.put("de_due_dt", getDeDueDt());
        this.hashColumns.put("lodg_due_dt", getLodgDueDt());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
        this.hashColumns.put("cmdt_desc", getCmdtDesc());
        this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
        this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
        this.hashColumns.put("awk_flg", getAwkFlg());
        this.hashColumns.put("si_cntc_pson_fax_no", getSiCntcPsonFaxNo());
        this.hashColumns.put("stwg_flg", getStwgFlg());
        this.hashColumns.put("partial_vvd_assign_flg", getPartialVvdAssignFlg());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("pre_rly_port_yd_cd", getPreRlyPortYdCd());
        this.hashColumns.put("bkg_pol_yd_cd", getBkgPolYdCd());
        this.hashColumns.put("split_rsn_cd", getSplitRsnCd());
        this.hashColumns.put("wait_rsn", getWaitRsn());
        this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
        this.hashColumns.put("si_cntc_pson_phn_no", getSiCntcPsonPhnNo());
        this.hashColumns.put("rf_flg", getRfFlg());
        this.hashColumns.put("lodg_due_dt_old", getLodgDueDtOld());
        this.hashColumns.put("stop_off_loc_cd", getStopOffLocCd());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
        this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
        this.hashColumns.put("inter_rmk", getInterRmk());
        this.hashColumns.put("scac_cd", getScacCd());
        this.hashColumns.put("cmdt_cd", getCmdtCd());
        this.hashColumns.put("full_pkup_yd_cd", getFullPkupYdCd());
        this.hashColumns.put("rcv_term_cd_old", getRcvTermCdOld());
        this.hashColumns.put("is_rated_flg", getIsRatedFlg());
        this.hashColumns.put("mty_pkup_yd_cd_old", getMtyPkupYdCdOld());
        this.hashColumns.put("stop_off_cntc_pson_nm", getStopOffCntcPsonNm());
        this.hashColumns.put("pod_nm", getPodNm());
        this.hashColumns.put("stop_off_flg", getStopOffFlg());
        this.hashColumns.put("bkg_pod_yd_cd", getBkgPodYdCd());
        this.hashColumns.put("del_nm", getDelNm());
        this.hashColumns.put("por_yd_cd_old", getPorYdCdOld());
        this.hashColumns.put("filer_cd", getFilerCd());
        this.hashColumns.put("xter_rqst_auto_ntc_flg", getXterRqstAutoNtcFlg());
        this.hashColumns.put("dest_sconti_cd", getDestScontiCd());
        this.hashColumns.put("mty_dor_arr_dt", getMtyDorArrDt());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("pol_cd_old", getPolCdOld());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("taa_no", getTaaNo());
        this.hashColumns.put("si_cntc_pson_mphn_no", getSiCntcPsonMphnNo());
        this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
        this.hashColumns.put("cntr_flg", getCntrFlg());
        this.hashColumns.put("last_vvd_cd", getLastVvdCd());
        this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
        this.hashColumns.put("reject_flag", getRejectFlag());
        this.hashColumns.put("first_pol_cd", getFirstPolCd());
        this.hashColumns.put("bkg_cntc_pson_phn_no", getBkgCntcPsonPhnNo());
        this.hashColumns.put("ocp_cd", getOcpCd());
        this.hashColumns.put("pol_nm", getPolNm());
        this.hashColumns.put("ca_user", getCaUser());
        this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("bkg_trunk_vvd", getBkgTrunkVvd());
        this.hashColumns.put("pctl_no", getPctlNo());
        this.hashColumns.put("pod_yd_cd_old", getPodYdCdOld());
        this.hashColumns.put("roll_ovr_cnt", getRollOvrCnt());
        this.hashColumns.put("sc_no", getScNo());
        this.hashColumns.put("prct_flg", getPrctFlg());
        this.hashColumns.put("taa_no_old", getTaaNoOld());
        this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
        this.hashColumns.put("rfa_no_old", getRfaNoOld());
        this.hashColumns.put("usr_eml", getUsrEml());
        this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
        this.hashColumns.put("xter_si_cd", getXterSiCd());
        this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
        this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
        this.hashColumns.put("xter_bkg_rqst_cd", getXterBkgRqstCd());
        this.hashColumns.put("bkg_por_cd", getBkgPorCd());
        this.hashColumns.put("last_pod_cd", getLastPodCd());
        this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
        this.hashColumns.put("bb_cgo_flg_old", getBbCgoFlgOld());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("stop_off_cntc_phn_no", getStopOffCntcPhnNo());
        this.hashColumns.put("pst_vvd_cd", getPstVvdCd());
        this.hashColumns.put("cre_usr_id", getCreUsrId());
        this.hashColumns.put("por_nm", getPorNm());
        this.hashColumns.put("rfa_available", getRfaAvailable());
        this.hashColumns.put("xter_rmk", getXterRmk());
        this.hashColumns.put("xter_bkg_rqst_ref_no", getXterBkgRqstRefNo());
        this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
        this.hashColumns.put("split_flg", getSplitFlg());
        this.hashColumns.put("full_rtn_yd_cd_old", getFullRtnYdCdOld());
        this.hashColumns.put("xtn_phn_no", getXtnPhnNo());
        this.hashColumns.put("doc_usr_id", getDocUsrId());
        this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
        this.hashColumns.put("pst_rly_port_yd_cd", getPstRlyPortYdCd());
        this.hashColumns.put("sc_no_old", getScNoOld());
        this.hashColumns.put("bdr_flg", getBdrFlg());
        this.hashColumns.put("si_cntc_pson_eml", getSiCntcPsonEml());
        this.hashColumns.put("rc_flg_old", getRcFlgOld());
        this.hashColumns.put("bkg_cntc_pson_nm", getBkgCntcPsonNm());
        this.hashColumns.put("stop_off_diff_rmk", getStopOffDiffRmk());
        this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
        this.hashColumns.put("hot_de_flg", getHotDeFlg());
        this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
        this.hashColumns.put("vvd_flag", getVvdFlag());
        this.hashColumns.put("rev_dir_cd", getRevDirCd());
        this.hashColumns.put("rfa_no", getRfaNo());
        this.hashColumns.put("fmc_no", getFmcNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("rail_blk_cd", getRailBlkCd());
        this.hashColumns.put("usr_nm", getUsrNm());
        this.hashColumns.put("bkg_del_cd", getBkgDelCd());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("ca_flg", getCaFlg());
        this.hashColumns.put("bkg_cntc_pson_mphn_no", getBkgCntcPsonMphnNo());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("si_cntc_pson_nm", getSiCntcPsonNm());
        this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
        this.hashColumns.put("de_term_cd_old", getDeTermCdOld());
        this.hashColumns.put("sc_available", getScAvailable());
        this.hashColumns.put("del_yd_cd_old", getDelYdCdOld());
        this.hashColumns.put("last_pod_clpt_ind_seq", getLastPodClptIndSeq());
        this.hashColumns.put("premium_available_flg", getPremiumAvailableFlg());
        this.hashColumns.put("twn_so_no", getTwnSoNo());
        this.hashColumns.put("de_due_dt_old", getDeDueDtOld());
        this.hashColumns.put("bkg_trunk_vvd_old", getBkgTrunkVvdOld());
        this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
        this.hashColumns.put("act_wgt", getActWgt());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("dg_flg", getDgFlg());
        this.hashColumns.put("first_pol_clpt_ind_seq", getFirstPolClptIndSeq());
        this.hashColumns.put("bkg_por_yd_cd", getBkgPorYdCd());
        this.hashColumns.put("del_cd_old", getDelCdOld());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
        this.hashColumns.put("first_vvd_cd", getFirstVvdCd());
        this.hashColumns.put("pre_vvd_cd", getPreVvdCd());
        this.hashColumns.put("vndr_rmk", getVndrRmk());
        this.hashColumns.put("bkg_ctrl_pty_cust_cnt_cd", getBkgCtrlPtyCustCntCd());
        this.hashColumns.put("bkg_ctrl_pty_cust_seq", getBkgCtrlPtyCustSeq());
        this.hashColumns.put("bkg_ctrl_pty_cust_nm", getBkgCtrlPtyCustNm());
        this.hashColumns.put("bkg_wt_chk_flg", getBkgWtChkFlg());
        this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
        this.hashColumns.put("irr_bl_no_flg", getIrrBlNoFlg());
        this.hashColumns.put("bkg_ty_flg", getBkgTyFlg());
        this.hashColumns.put("xter_vgm_rqst_cd", getXterVgmRqstCd());
        this.hashColumns.put("bkg_pty_cnt_cd", getBkgPtyCntCd());
        this.hashColumns.put("bkg_pty_cust_seq", getBkgPtyCustSeq());
        this.hashColumns.put("bkg_pty_cust_nm", getBkgPtyCustNm());
        this.hashColumns.put("upd_dt", getUpdDt());
        this.hashColumns.put("lst_sav_dt", getLstSavDt());
        this.hashColumns.put("modify_cargo_flg", getModifyCargoFlg());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_del_yd_cd", "bkgDelYdCd");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("awk_cgo_flg_old", "awkCgoFlgOld");
        this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("taa_available", "taaAvailable");
        this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
        this.hashFields.put("pol_yd_cd_old", "polYdCdOld");
        this.hashFields.put("cmdt_cd_old", "cmdtCdOld");
        this.hashFields.put("bkg_cntc_pson_fax_no", "bkgCntcPsonFaxNo");
        this.hashFields.put("mty_pkup_dt_old", "mtyPkupDtOld");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ob_srep_cd", "obSrepCd");
        this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
        this.hashFields.put("bkg_pod_cd", "bkgPodCd");
        this.hashFields.put("fnl_dest_nm", "fnlDestNm");
        this.hashFields.put("por_cd_old", "porCdOld");
        this.hashFields.put("old_bkg_no", "oldBkgNo");
        this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
        this.hashFields.put("ref_flg", "refFlg");
        this.hashFields.put("bb_flg", "bbFlg");
        this.hashFields.put("stwg_rmk", "stwgRmk");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("pod_cd_old", "podCdOld");
        this.hashFields.put("si_flg", "siFlg");
        this.hashFields.put("upd_usr_id", "updUsrId");
        this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
        this.hashFields.put("mnl_bkg_no_flg", "mnlBkgNoFlg");
        this.hashFields.put("xter_si_ref_no", "xterSiRefNo");
        this.hashFields.put("org_sconti_cd", "orgScontiCd");
        this.hashFields.put("bkg_cntc_pson_eml", "bkgCntcPsonEml");
        this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
        this.hashFields.put("dcgo_flg_old", "dcgoFlgOld");
        this.hashFields.put("mty_dor_arr_dt_old", "mtyDorArrDtOld");
        this.hashFields.put("de_due_dt", "deDueDt");
        this.hashFields.put("lodg_due_dt", "lodgDueDt");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("edi_hld_flg", "ediHldFlg");
        this.hashFields.put("cmdt_desc", "cmdtDesc");
        this.hashFields.put("spcl_hide_flg", "spclHideFlg");
        this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
        this.hashFields.put("awk_flg", "awkFlg");
        this.hashFields.put("si_cntc_pson_fax_no", "siCntcPsonFaxNo");
        this.hashFields.put("stwg_flg", "stwgFlg");
        this.hashFields.put("partial_vvd_assign_flg", "partialVvdAssignFlg");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("pre_rly_port_yd_cd", "preRlyPortYdCd");
        this.hashFields.put("bkg_pol_yd_cd", "bkgPolYdCd");
        this.hashFields.put("split_rsn_cd", "splitRsnCd");
        this.hashFields.put("wait_rsn", "waitRsn");
        this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
        this.hashFields.put("si_cntc_pson_phn_no", "siCntcPsonPhnNo");
        this.hashFields.put("rf_flg", "rfFlg");
        this.hashFields.put("lodg_due_dt_old", "lodgDueDtOld");
        this.hashFields.put("stop_off_loc_cd", "stopOffLocCd");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("bkg_sts_cd", "bkgStsCd");
        this.hashFields.put("fd_grd_flg", "fdGrdFlg");
        this.hashFields.put("inter_rmk", "interRmk");
        this.hashFields.put("scac_cd", "scacCd");
        this.hashFields.put("cmdt_cd", "cmdtCd");
        this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
        this.hashFields.put("rcv_term_cd_old", "rcvTermCdOld");
        this.hashFields.put("is_rated_flg", "isRatedFlg");
        this.hashFields.put("mty_pkup_yd_cd_old", "mtyPkupYdCdOld");
        this.hashFields.put("stop_off_cntc_pson_nm", "stopOffCntcPsonNm");
        this.hashFields.put("pod_nm", "podNm");
        this.hashFields.put("stop_off_flg", "stopOffFlg");
        this.hashFields.put("bkg_pod_yd_cd", "bkgPodYdCd");
        this.hashFields.put("del_nm", "delNm");
        this.hashFields.put("por_yd_cd_old", "porYdCdOld");
        this.hashFields.put("filer_cd", "filerCd");
        this.hashFields.put("xter_rqst_auto_ntc_flg", "xterRqstAutoNtcFlg");
        this.hashFields.put("dest_sconti_cd", "destScontiCd");
        this.hashFields.put("mty_dor_arr_dt", "mtyDorArrDt");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("pol_cd_old", "polCdOld");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("taa_no", "taaNo");
        this.hashFields.put("si_cntc_pson_mphn_no", "siCntcPsonMphnNo");
        this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
        this.hashFields.put("cntr_flg", "cntrFlg");
        this.hashFields.put("last_vvd_cd", "lastVvdCd");
        this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
        this.hashFields.put("reject_flag", "rejectFlag");
        this.hashFields.put("first_pol_cd", "firstPolCd");
        this.hashFields.put("bkg_cntc_pson_phn_no", "bkgCntcPsonPhnNo");
        this.hashFields.put("ocp_cd", "ocpCd");
        this.hashFields.put("pol_nm", "polNm");
        this.hashFields.put("ca_user", "caUser");
        this.hashFields.put("blck_stwg_cd", "blckStwgCd");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("bkg_trunk_vvd", "bkgTrunkVvd");
        this.hashFields.put("pctl_no", "pctlNo");
        this.hashFields.put("pod_yd_cd_old", "podYdCdOld");
        this.hashFields.put("roll_ovr_cnt", "rollOvrCnt");
        this.hashFields.put("sc_no", "scNo");
        this.hashFields.put("prct_flg", "prctFlg");
        this.hashFields.put("taa_no_old", "taaNoOld");
        this.hashFields.put("wgt_ut_cd", "wgtUtCd");
        this.hashFields.put("rfa_no_old", "rfaNoOld");
        this.hashFields.put("usr_eml", "usrEml");
        this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
        this.hashFields.put("xter_si_cd", "xterSiCd");
        this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
        this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
        this.hashFields.put("xter_bkg_rqst_cd", "xterBkgRqstCd");
        this.hashFields.put("bkg_por_cd", "bkgPorCd");
        this.hashFields.put("last_pod_cd", "lastPodCd");
        this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
        this.hashFields.put("bb_cgo_flg_old", "bbCgoFlgOld");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("stop_off_cntc_phn_no", "stopOffCntcPhnNo");
        this.hashFields.put("pst_vvd_cd", "pstVvdCd");
        this.hashFields.put("cre_usr_id", "creUsrId");
        this.hashFields.put("por_nm", "porNm");
        this.hashFields.put("rfa_available", "rfaAvailable");
        this.hashFields.put("xter_rmk", "xterRmk");
        this.hashFields.put("xter_bkg_rqst_ref_no", "xterBkgRqstRefNo");
        this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
        this.hashFields.put("split_flg", "splitFlg");
        this.hashFields.put("full_rtn_yd_cd_old", "fullRtnYdCdOld");
        this.hashFields.put("xtn_phn_no", "xtnPhnNo");
        this.hashFields.put("doc_usr_id", "docUsrId");
        this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
        this.hashFields.put("pst_rly_port_yd_cd", "pstRlyPortYdCd");
        this.hashFields.put("sc_no_old", "scNoOld");
        this.hashFields.put("bdr_flg", "bdrFlg");
        this.hashFields.put("si_cntc_pson_eml", "siCntcPsonEml");
        this.hashFields.put("rc_flg_old", "rcFlgOld");
        this.hashFields.put("bkg_cntc_pson_nm", "bkgCntcPsonNm");
        this.hashFields.put("stop_off_diff_rmk", "stopOffDiffRmk");
        this.hashFields.put("adv_shtg_cd", "advShtgCd");
        this.hashFields.put("hot_de_flg", "hotDeFlg");
        this.hashFields.put("eq_subst_flg", "eqSubstFlg");
        this.hashFields.put("vvd_flag", "vvdFlag");
        this.hashFields.put("rev_dir_cd", "revDirCd");
        this.hashFields.put("rfa_no", "rfaNo");
        this.hashFields.put("fmc_no", "fmcNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("rail_blk_cd", "railBlkCd");
        this.hashFields.put("usr_nm", "usrNm");
        this.hashFields.put("bkg_del_cd", "bkgDelCd");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("ca_flg", "caFlg");
        this.hashFields.put("bkg_cntc_pson_mphn_no", "bkgCntcPsonMphnNo");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("si_cntc_pson_nm", "siCntcPsonNm");
        this.hashFields.put("bkg_pol_cd", "bkgPolCd");
        this.hashFields.put("de_term_cd_old", "deTermCdOld");
        this.hashFields.put("sc_available", "scAvailable");
        this.hashFields.put("del_yd_cd_old", "delYdCdOld");
        this.hashFields.put("last_pod_clpt_ind_seq", "lastPodClptIndSeq");
        this.hashFields.put("premium_available_flg", "premiumAvailableFlg");
        this.hashFields.put("twn_so_no", "twnSoNo");
        this.hashFields.put("de_due_dt_old", "deDueDtOld");
        this.hashFields.put("bkg_trunk_vvd_old", "bkgTrunkVvdOld");
        this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
        this.hashFields.put("act_wgt", "actWgt");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("dg_flg", "dgFlg");
        this.hashFields.put("first_pol_clpt_ind_seq", "firstPolClptIndSeq");
        this.hashFields.put("bkg_por_yd_cd", "bkgPorYdCd");
        this.hashFields.put("del_cd_old", "delCdOld");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
        this.hashFields.put("first_vvd_cd", "firstVvdCd");
        this.hashFields.put("pre_vvd_cd", "preVvdCd");
        this.hashFields.put("vndr_rmk", "vndrRmk");
        this.hashFields.put("bkg_ctrl_pty_cust_cnt_cd", "bkgCtrlPtyCustCntCd");
        this.hashFields.put("bkg_ctrl_pty_cust_seq", "bkgCtrlPtyCustSeq");
        this.hashFields.put("bkg_ctrl_pty_cust_nm", "bkgCtrlPtyCustNm");
        this.hashFields.put("bkg_wt_chk_flg", "bkgWtChkFlg");
        this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
        this.hashFields.put("irr_bl_no_flg", "irrBlNoFlg");
        this.hashFields.put("bkg_ty_flg", "bkgTyFlg");
        this.hashFields.put("xter_vgm_rqst_cd", "xterVgmRqstCd");
        this.hashFields.put("bkg_pty_cnt_cd", "bkgPtyCntCd");
        this.hashFields.put("bkg_pty_cust_seq", "bkgPtyCustSeq");
        this.hashFields.put("bkg_pty_cust_nm", "bkgPtyCustNm");
        this.hashFields.put("upd_dt", "updDt");
        this.hashFields.put("lst_sav_dt", "lstSavDt");
        this.hashFields.put("modify_cargo_flg", "modifyCargoFlg");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bkgDelYdCd
	 */
    public String getBkgDelYdCd() {
        return this.bkgDelYdCd;
    }

    /**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
    public String getBkgCgoTpCd() {
        return this.bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @return awkCgoFlgOld
	 */
    public String getAwkCgoFlgOld() {
        return this.awkCgoFlgOld;
    }

    /**
	 * Column Info
	 * @return orgTrnsModCd
	 */
    public String getOrgTrnsModCd() {
        return this.orgTrnsModCd;
    }

    /**
	 * Column Info
	 * @return svcScpCd
	 */
    public String getSvcScpCd() {
        return this.svcScpCd;
    }

    /**
	 * Column Info
	 * @return taaAvailable
	 */
    public String getTaaAvailable() {
        return this.taaAvailable;
    }

    /**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
    public String getMtyPkupYdCd() {
        return this.mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @return polYdCdOld
	 */
    public String getPolYdCdOld() {
        return this.polYdCdOld;
    }

    /**
	 * Column Info
	 * @return cmdtCdOld
	 */
    public String getCmdtCdOld() {
        return this.cmdtCdOld;
    }

    /**
	 * Column Info
	 * @return bkgCntcPsonFaxNo
	 */
    public String getBkgCntcPsonFaxNo() {
        return this.bkgCntcPsonFaxNo;
    }

    /**
	 * Column Info
	 * @return mtyPkupDtOld
	 */
    public String getMtyPkupDtOld() {
        return this.mtyPkupDtOld;
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
	 * @return obSrepCd
	 */
    public String getObSrepCd() {
        return this.obSrepCd;
    }

    /**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
    public String getDestTrnsSvcModCd() {
        return this.destTrnsSvcModCd;
    }

    /**
	 * Column Info
	 * @return bkgPodCd
	 */
    public String getBkgPodCd() {
        return this.bkgPodCd;
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
	 * @return porCdOld
	 */
    public String getPorCdOld() {
        return this.porCdOld;
    }

    /**
	 * Column Info
	 * @return oldBkgNo
	 */
    public String getOldBkgNo() {
        return this.oldBkgNo;
    }

    /**
	 * Column Info
	 * @return ctrtOfcCd
	 */
    public String getCtrtOfcCd() {
        return this.ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @return refFlg
	 */
    public String getRefFlg() {
        return this.refFlg;
    }

    /**
	 * Column Info
	 * @return bbFlg
	 */
    public String getBbFlg() {
        return this.bbFlg;
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
	 * @return stwgCd
	 */
    public String getStwgCd() {
        return this.stwgCd;
    }

    /**
	 * Column Info
	 * @return podCdOld
	 */
    public String getPodCdOld() {
        return this.podCdOld;
    }

    /**
	 * Column Info
	 * @return siFlg
	 */
    public String getSiFlg() {
        return this.siFlg;
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
	 * @return bkgOfcCd
	 */
    public String getBkgOfcCd() {
        return this.bkgOfcCd;
    }

    /**
	 * Column Info
	 * @return mnlBkgNoFlg
	 */
    public String getMnlBkgNoFlg() {
        return this.mnlBkgNoFlg;
    }

    /**
	 * Column Info
	 * @return xterSiRefNo
	 */
    public String getXterSiRefNo() {
        return this.xterSiRefNo;
    }

    /**
	 * Column Info
	 * @return orgScontiCd
	 */
    public String getOrgScontiCd() {
        return this.orgScontiCd;
    }

    /**
	 * Column Info
	 * @return bkgCntcPsonEml
	 */
    public String getBkgCntcPsonEml() {
        return this.bkgCntcPsonEml;
    }

    /**
	 * Column Info
	 * @return fullRtnYdCd
	 */
    public String getFullRtnYdCd() {
        return this.fullRtnYdCd;
    }

    /**
	 * Column Info
	 * @return dcgoFlgOld
	 */
    public String getDcgoFlgOld() {
        return this.dcgoFlgOld;
    }

    /**
	 * Column Info
	 * @return mtyDorArrDtOld
	 */
    public String getMtyDorArrDtOld() {
        return this.mtyDorArrDtOld;
    }

    /**
	 * Column Info
	 * @return deDueDt
	 */
    public String getDeDueDt() {
        return this.deDueDt;
    }

    /**
	 * Column Info
	 * @return lodgDueDt
	 */
    public String getLodgDueDt() {
        return this.lodgDueDt;
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
	 * @return ediHldFlg
	 */
    public String getEdiHldFlg() {
        return this.ediHldFlg;
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
	 * @return spclHideFlg
	 */
    public String getSpclHideFlg() {
        return this.spclHideFlg;
    }

    /**
	 * Column Info
	 * @return ctrtSrepCd
	 */
    public String getCtrtSrepCd() {
        return this.ctrtSrepCd;
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
	 * @return siCntcPsonFaxNo
	 */
    public String getSiCntcPsonFaxNo() {
        return this.siCntcPsonFaxNo;
    }

    /**
	 * Column Info
	 * @return stwgFlg
	 */
    public String getStwgFlg() {
        return this.stwgFlg;
    }

    /**
	 * Column Info
	 * @return partialVvdAssignFlg
	 */
    public String getPartialVvdAssignFlg() {
        return this.partialVvdAssignFlg;
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
	 * @return preRlyPortYdCd
	 */
    public String getPreRlyPortYdCd() {
        return this.preRlyPortYdCd;
    }

    /**
	 * Column Info
	 * @return bkgPolYdCd
	 */
    public String getBkgPolYdCd() {
        return this.bkgPolYdCd;
    }

    /**
	 * Column Info
	 * @return splitRsnCd
	 */
    public String getSplitRsnCd() {
        return this.splitRsnCd;
    }

    /**
	 * Column Info
	 * @return waitRsn
	 */
    public String getWaitRsn() {
        return this.waitRsn;
    }

    /**
	 * Column Info
	 * @return destTrnsModCd
	 */
    public String getDestTrnsModCd() {
        return this.destTrnsModCd;
    }

    /**
	 * Column Info
	 * @return siCntcPsonPhnNo
	 */
    public String getSiCntcPsonPhnNo() {
        return this.siCntcPsonPhnNo;
    }

    /**
	 * Column Info
	 * @return rfFlg
	 */
    public String getRfFlg() {
        return this.rfFlg;
    }

    /**
	 * Column Info
	 * @return lodgDueDtOld
	 */
    public String getLodgDueDtOld() {
        return this.lodgDueDtOld;
    }

    /**
	 * Column Info
	 * @return stopOffLocCd
	 */
    public String getStopOffLocCd() {
        return this.stopOffLocCd;
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
	 * @return bkgStsCd
	 */
    public String getBkgStsCd() {
        return this.bkgStsCd;
    }

    /**
	 * Column Info
	 * @return fdGrdFlg
	 */
    public String getFdGrdFlg() {
        return this.fdGrdFlg;
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
	 * @return scacCd
	 */
    public String getScacCd() {
        return this.scacCd;
    }

    /**
	 * Column Info
	 * @return cmdtCd
	 */
    public String getCmdtCd() {
        return this.cmdtCd;
    }

    /**
	 * Column Info
	 * @return fullPkupYdCd
	 */
    public String getFullPkupYdCd() {
        return this.fullPkupYdCd;
    }

    /**
	 * Column Info
	 * @return rcvTermCdOld
	 */
    public String getRcvTermCdOld() {
        return this.rcvTermCdOld;
    }

    /**
	 * Column Info
	 * @return isRatedFlg
	 */
    public String getIsRatedFlg() {
        return this.isRatedFlg;
    }

    /**
	 * Column Info
	 * @return mtyPkupYdCdOld
	 */
    public String getMtyPkupYdCdOld() {
        return this.mtyPkupYdCdOld;
    }

    /**
	 * Column Info
	 * @return stopOffCntcPsonNm
	 */
    public String getStopOffCntcPsonNm() {
        return this.stopOffCntcPsonNm;
    }

    /**
	 * Column Info
	 * @return podNm
	 */
    public String getPodNm() {
        return this.podNm;
    }

    /**
	 * Column Info
	 * @return stopOffFlg
	 */
    public String getStopOffFlg() {
        return this.stopOffFlg;
    }

    /**
	 * Column Info
	 * @return bkgPodYdCd
	 */
    public String getBkgPodYdCd() {
        return this.bkgPodYdCd;
    }

    /**
	 * Column Info
	 * @return delNm
	 */
    public String getDelNm() {
        return this.delNm;
    }

    /**
	 * Column Info
	 * @return porYdCdOld
	 */
    public String getPorYdCdOld() {
        return this.porYdCdOld;
    }

    /**
	 * Column Info
	 * @return filerCd
	 */
    public String getFilerCd() {
        return this.filerCd;
    }

    /**
	 * Column Info
	 * @return xterRqstAutoNtcFlg
	 */
    public String getXterRqstAutoNtcFlg() {
        return this.xterRqstAutoNtcFlg;
    }

    /**
	 * Column Info
	 * @return destScontiCd
	 */
    public String getDestScontiCd() {
        return this.destScontiCd;
    }

    /**
	 * Column Info
	 * @return mtyDorArrDt
	 */
    public String getMtyDorArrDt() {
        return this.mtyDorArrDt;
    }

    /**
	 * Column Info
	 * @return ofcCd
	 */
    public String getOfcCd() {
        return this.ofcCd;
    }

    /**
	 * Column Info
	 * @return polCdOld
	 */
    public String getPolCdOld() {
        return this.polCdOld;
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
	 * @return taaNo
	 */
    public String getTaaNo() {
        return this.taaNo;
    }

    /**
	 * Column Info
	 * @return siCntcPsonMphnNo
	 */
    public String getSiCntcPsonMphnNo() {
        return this.siCntcPsonMphnNo;
    }

    /**
	 * Column Info
	 * @return flexHgtFlg
	 */
    public String getFlexHgtFlg() {
        return this.flexHgtFlg;
    }

    /**
	 * Column Info
	 * @return cntrFlg
	 */
    public String getCntrFlg() {
        return this.cntrFlg;
    }

    /**
	 * Column Info
	 * @return lastVvdCd
	 */
    public String getLastVvdCd() {
        return this.lastVvdCd;
    }

    /**
	 * Column Info
	 * @return repCmdtCd
	 */
    public String getRepCmdtCd() {
        return this.repCmdtCd;
    }

    /**
	 * Column Info
	 * @return rejectFlag
	 */
    public String getRejectFlag() {
        return this.rejectFlag;
    }

    /**
	 * Column Info
	 * @return firstPolCd
	 */
    public String getFirstPolCd() {
        return this.firstPolCd;
    }

    /**
	 * Column Info
	 * @return bkgCntcPsonPhnNo
	 */
    public String getBkgCntcPsonPhnNo() {
        return this.bkgCntcPsonPhnNo;
    }

    /**
	 * Column Info
	 * @return ocpCd
	 */
    public String getOcpCd() {
        return this.ocpCd;
    }

    /**
	 * Column Info
	 * @return polNm
	 */
    public String getPolNm() {
        return this.polNm;
    }

    /**
	 * Column Info
	 * @return caUser
	 */
    public String getCaUser() {
        return this.caUser;
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
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
    }

    /**
	 * Column Info
	 * @return bkgTrunkVvd
	 */
    public String getBkgTrunkVvd() {
        return this.bkgTrunkVvd;
    }

    /**
	 * Column Info
	 * @return pctlNo
	 */
    public String getPctlNo() {
        return this.pctlNo;
    }

    /**
	 * Column Info
	 * @return podYdCdOld
	 */
    public String getPodYdCdOld() {
        return this.podYdCdOld;
    }

    /**
	 * Column Info
	 * @return rollOvrCnt
	 */
    public String getRollOvrCnt() {
        return this.rollOvrCnt;
    }

    /**
	 * Column Info
	 * @return scNo
	 */
    public String getScNo() {
        return this.scNo;
    }

    /**
	 * Column Info
	 * @return prctFlg
	 */
    public String getPrctFlg() {
        return this.prctFlg;
    }

    /**
	 * Column Info
	 * @return taaNoOld
	 */
    public String getTaaNoOld() {
        return this.taaNoOld;
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
	 * @return rfaNoOld
	 */
    public String getRfaNoOld() {
        return this.rfaNoOld;
    }

    /**
	 * Column Info
	 * @return usrEml
	 */
    public String getUsrEml() {
        return this.usrEml;
    }

    /**
	 * Column Info
	 * @return obSlsOfcCd
	 */
    public String getObSlsOfcCd() {
        return this.obSlsOfcCd;
    }

    /**
	 * Column Info
	 * @return xterSiCd
	 */
    public String getXterSiCd() {
        return this.xterSiCd;
    }

    /**
	 * Column Info
	 * @return mtyPkupDt
	 */
    public String getMtyPkupDt() {
        return this.mtyPkupDt;
    }

    /**
	 * Column Info
	 * @return cndCstmsFileCd
	 */
    public String getCndCstmsFileCd() {
        return this.cndCstmsFileCd;
    }

    /**
	 * Column Info
	 * @return xterBkgRqstCd
	 */
    public String getXterBkgRqstCd() {
        return this.xterBkgRqstCd;
    }

    /**
	 * Column Info
	 * @return bkgPorCd
	 */
    public String getBkgPorCd() {
        return this.bkgPorCd;
    }

    /**
	 * Column Info
	 * @return lastPodCd
	 */
    public String getLastPodCd() {
        return this.lastPodCd;
    }

    /**
	 * Column Info
	 * @return preRlyPortCd
	 */
    public String getPreRlyPortCd() {
        return this.preRlyPortCd;
    }

    /**
	 * Column Info
	 * @return bbCgoFlgOld
	 */
    public String getBbCgoFlgOld() {
        return this.bbCgoFlgOld;
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
	 * @return stopOffCntcPhnNo
	 */
    public String getStopOffCntcPhnNo() {
        return this.stopOffCntcPhnNo;
    }

    /**
	 * Column Info
	 * @return pstVvdCd
	 */
    public String getPstVvdCd() {
        return this.pstVvdCd;
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
	 * @return porNm
	 */
    public String getPorNm() {
        return this.porNm;
    }

    /**
	 * Column Info
	 * @return rfaAvailable
	 */
    public String getRfaAvailable() {
        return this.rfaAvailable;
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
	 * @return xterBkgRqstRefNo
	 */
    public String getXterBkgRqstRefNo() {
        return this.xterBkgRqstRefNo;
    }

    /**
	 * Column Info
	 * @return pstRlyPortCd
	 */
    public String getPstRlyPortCd() {
        return this.pstRlyPortCd;
    }

    /**
	 * Column Info
	 * @return splitFlg
	 */
    public String getSplitFlg() {
        return this.splitFlg;
    }

    /**
	 * Column Info
	 * @return fullRtnYdCdOld
	 */
    public String getFullRtnYdCdOld() {
        return this.fullRtnYdCdOld;
    }

    /**
	 * Column Info
	 * @return xtnPhnNo
	 */
    public String getXtnPhnNo() {
        return this.xtnPhnNo;
    }

    /**
	 * Column Info
	 * @return docUsrId
	 */
    public String getDocUsrId() {
        return this.docUsrId;
    }

    /**
	 * Column Info
	 * @return orgTrnsSvcModCd
	 */
    public String getOrgTrnsSvcModCd() {
        return this.orgTrnsSvcModCd;
    }

    /**
	 * Column Info
	 * @return pstRlyPortYdCd
	 */
    public String getPstRlyPortYdCd() {
        return this.pstRlyPortYdCd;
    }

    /**
	 * Column Info
	 * @return scNoOld
	 */
    public String getScNoOld() {
        return this.scNoOld;
    }

    /**
	 * Column Info
	 * @return bdrFlg
	 */
    public String getBdrFlg() {
        return this.bdrFlg;
    }

    /**
	 * Column Info
	 * @return siCntcPsonEml
	 */
    public String getSiCntcPsonEml() {
        return this.siCntcPsonEml;
    }

    /**
	 * Column Info
	 * @return rcFlgOld
	 */
    public String getRcFlgOld() {
        return this.rcFlgOld;
    }

    /**
	 * Column Info
	 * @return bkgCntcPsonNm
	 */
    public String getBkgCntcPsonNm() {
        return this.bkgCntcPsonNm;
    }

    /**
	 * Column Info
	 * @return stopOffDiffRmk
	 */
    public String getStopOffDiffRmk() {
        return this.stopOffDiffRmk;
    }

    /**
	 * Column Info
	 * @return advShtgCd
	 */
    public String getAdvShtgCd() {
        return this.advShtgCd;
    }

    /**
	 * Column Info
	 * @return hotDeFlg
	 */
    public String getHotDeFlg() {
        return this.hotDeFlg;
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
	 * @return vvdFlag
	 */
    public String getVvdFlag() {
        return this.vvdFlag;
    }

    /**
	 * Column Info
	 * @return revDirCd
	 */
    public String getRevDirCd() {
        return this.revDirCd;
    }

    /**
	 * Column Info
	 * @return rfaNo
	 */
    public String getRfaNo() {
        return this.rfaNo;
    }

    /**
	 * Column Info
	 * @return fmcNo
	 */
    public String getFmcNo() {
        return this.fmcNo;
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
	 * @return railBlkCd
	 */
    public String getRailBlkCd() {
        return this.railBlkCd;
    }

    /**
	 * Column Info
	 * @return usrNm
	 */
    public String getUsrNm() {
        return this.usrNm;
    }

    /**
	 * Column Info
	 * @return bkgDelCd
	 */
    public String getBkgDelCd() {
        return this.bkgDelCd;
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
	 * @return caFlg
	 */
    public String getCaFlg() {
        return this.caFlg;
    }

    /**
	 * Column Info
	 * @return bkgCntcPsonMphnNo
	 */
    public String getBkgCntcPsonMphnNo() {
        return this.bkgCntcPsonMphnNo;
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
	 * @return siCntcPsonNm
	 */
    public String getSiCntcPsonNm() {
        return this.siCntcPsonNm;
    }

    /**
	 * Column Info
	 * @return bkgPolCd
	 */
    public String getBkgPolCd() {
        return this.bkgPolCd;
    }

    /**
	 * Column Info
	 * @return deTermCdOld
	 */
    public String getDeTermCdOld() {
        return this.deTermCdOld;
    }

    /**
	 * Column Info
	 * @return scAvailable
	 */
    public String getScAvailable() {
        return this.scAvailable;
    }

    /**
	 * Column Info
	 * @return delYdCdOld
	 */
    public String getDelYdCdOld() {
        return this.delYdCdOld;
    }

    /**
	 * Column Info
	 * @return lastPodClptIndSeq
	 */
    public String getLastPodClptIndSeq() {
        return this.lastPodClptIndSeq;
    }

    /**
	 * Column Info
	 * @return premiumAvailableFlg
	 */
    public String getPremiumAvailableFlg() {
        return this.premiumAvailableFlg;
    }

    /**
	 * Column Info
	 * @return twnSoNo
	 */
    public String getTwnSoNo() {
        return this.twnSoNo;
    }

    /**
	 * Column Info
	 * @return deDueDtOld
	 */
    public String getDeDueDtOld() {
        return this.deDueDtOld;
    }

    /**
	 * Column Info
	 * @return bkgTrunkVvdOld
	 */
    public String getBkgTrunkVvdOld() {
        return this.bkgTrunkVvdOld;
    }

    /**
	 * Column Info
	 * @return usaCstmsFileCd
	 */
    public String getUsaCstmsFileCd() {
        return this.usaCstmsFileCd;
    }

    /**
	 * Column Info
	 * @return actWgt
	 */
    public String getActWgt() {
        return this.actWgt;
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
	 * @return deTermCd
	 */
    public String getDeTermCd() {
        return this.deTermCd;
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
	 * @return firstPolClptIndSeq
	 */
    public String getFirstPolClptIndSeq() {
        return this.firstPolClptIndSeq;
    }

    /**
	 * Column Info
	 * @return bkgPorYdCd
	 */
    public String getBkgPorYdCd() {
        return this.bkgPorYdCd;
    }

    /**
	 * Column Info
	 * @return delCdOld
	 */
    public String getDelCdOld() {
        return this.delCdOld;
    }

    /**
	 * Column Info
	 * @return hngrFlg
	 */
    public String getHngrFlg() {
        return this.hngrFlg;
    }

    /**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
    public String getMtyRtnYdCd() {
        return this.mtyRtnYdCd;
    }

    /**
	 * Column Info
	 * @return firstVvdCd
	 */
    public String getFirstVvdCd() {
        return this.firstVvdCd;
    }

    /**
	 * Column Info
	 * @return preVvdCd
	 */
    public String getPreVvdCd() {
        return this.preVvdCd;
    }

    /**
	 * Column Info
	 * @return vndrRmk
	 */
    public String getVndrRmk() {
        return this.vndrRmk;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustCntCd
	 */
    public String getBkgCtrlPtyCustCntCd() {
        return this.bkgCtrlPtyCustCntCd;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustSeq
	 */
    public String getBkgCtrlPtyCustSeq() {
        return this.bkgCtrlPtyCustSeq;
    }

    /**
	 * Column Info
	 * @return bkgCtrlPtyCustNm
	 */
    public String getBkgCtrlPtyCustNm() {
        return this.bkgCtrlPtyCustNm;
    }

    /**
	 * Column Info
	 * @param bkgDelYdCd
	 */
    public void setBkgDelYdCd(String bkgDelYdCd) {
        this.bkgDelYdCd = bkgDelYdCd;
    }

    /**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
    public void setBkgCgoTpCd(String bkgCgoTpCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @param awkCgoFlgOld
	 */
    public void setAwkCgoFlgOld(String awkCgoFlgOld) {
        this.awkCgoFlgOld = awkCgoFlgOld;
    }

    /**
	 * Column Info
	 * @param orgTrnsModCd
	 */
    public void setOrgTrnsModCd(String orgTrnsModCd) {
        this.orgTrnsModCd = orgTrnsModCd;
    }

    /**
	 * Column Info
	 * @param svcScpCd
	 */
    public void setSvcScpCd(String svcScpCd) {
        this.svcScpCd = svcScpCd;
    }

    /**
	 * Column Info
	 * @param taaAvailable
	 */
    public void setTaaAvailable(String taaAvailable) {
        this.taaAvailable = taaAvailable;
    }

    /**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
    public void setMtyPkupYdCd(String mtyPkupYdCd) {
        this.mtyPkupYdCd = mtyPkupYdCd;
    }

    /**
	 * Column Info
	 * @param polYdCdOld
	 */
    public void setPolYdCdOld(String polYdCdOld) {
        this.polYdCdOld = polYdCdOld;
    }

    /**
	 * Column Info
	 * @param cmdtCdOld
	 */
    public void setCmdtCdOld(String cmdtCdOld) {
        this.cmdtCdOld = cmdtCdOld;
    }

    /**
	 * Column Info
	 * @param bkgCntcPsonFaxNo
	 */
    public void setBkgCntcPsonFaxNo(String bkgCntcPsonFaxNo) {
        this.bkgCntcPsonFaxNo = bkgCntcPsonFaxNo;
    }

    /**
	 * Column Info
	 * @param mtyPkupDtOld
	 */
    public void setMtyPkupDtOld(String mtyPkupDtOld) {
        this.mtyPkupDtOld = mtyPkupDtOld;
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
	 * @param obSrepCd
	 */
    public void setObSrepCd(String obSrepCd) {
        this.obSrepCd = obSrepCd;
    }

    /**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
    public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
        this.destTrnsSvcModCd = destTrnsSvcModCd;
    }

    /**
	 * Column Info
	 * @param bkgPodCd
	 */
    public void setBkgPodCd(String bkgPodCd) {
        this.bkgPodCd = bkgPodCd;
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
	 * @param porCdOld
	 */
    public void setPorCdOld(String porCdOld) {
        this.porCdOld = porCdOld;
    }

    /**
	 * Column Info
	 * @param oldBkgNo
	 */
    public void setOldBkgNo(String oldBkgNo) {
        this.oldBkgNo = oldBkgNo;
    }

    /**
	 * Column Info
	 * @param ctrtOfcCd
	 */
    public void setCtrtOfcCd(String ctrtOfcCd) {
        this.ctrtOfcCd = ctrtOfcCd;
    }

    /**
	 * Column Info
	 * @param refFlg
	 */
    public void setRefFlg(String refFlg) {
        this.refFlg = refFlg;
    }

    /**
	 * Column Info
	 * @param bbFlg
	 */
    public void setBbFlg(String bbFlg) {
        this.bbFlg = bbFlg;
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
	 * @param stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    /**
	 * Column Info
	 * @param podCdOld
	 */
    public void setPodCdOld(String podCdOld) {
        this.podCdOld = podCdOld;
    }

    /**
	 * Column Info
	 * @param siFlg
	 */
    public void setSiFlg(String siFlg) {
        this.siFlg = siFlg;
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
	 * @param bkgOfcCd
	 */
    public void setBkgOfcCd(String bkgOfcCd) {
        this.bkgOfcCd = bkgOfcCd;
    }

    /**
	 * Column Info
	 * @param mnlBkgNoFlg
	 */
    public void setMnlBkgNoFlg(String mnlBkgNoFlg) {
        this.mnlBkgNoFlg = mnlBkgNoFlg;
    }

    /**
	 * Column Info
	 * @param xterSiRefNo
	 */
    public void setXterSiRefNo(String xterSiRefNo) {
        this.xterSiRefNo = xterSiRefNo;
    }

    /**
	 * Column Info
	 * @param orgScontiCd
	 */
    public void setOrgScontiCd(String orgScontiCd) {
        this.orgScontiCd = orgScontiCd;
    }

    /**
	 * Column Info
	 * @param bkgCntcPsonEml
	 */
    public void setBkgCntcPsonEml(String bkgCntcPsonEml) {
        this.bkgCntcPsonEml = bkgCntcPsonEml;
    }

    /**
	 * Column Info
	 * @param fullRtnYdCd
	 */
    public void setFullRtnYdCd(String fullRtnYdCd) {
        this.fullRtnYdCd = fullRtnYdCd;
    }

    /**
	 * Column Info
	 * @param dcgoFlgOld
	 */
    public void setDcgoFlgOld(String dcgoFlgOld) {
        this.dcgoFlgOld = dcgoFlgOld;
    }

    /**
	 * Column Info
	 * @param mtyDorArrDtOld
	 */
    public void setMtyDorArrDtOld(String mtyDorArrDtOld) {
        this.mtyDorArrDtOld = mtyDorArrDtOld;
    }

    /**
	 * Column Info
	 * @param deDueDt
	 */
    public void setDeDueDt(String deDueDt) {
        this.deDueDt = deDueDt;
    }

    /**
	 * Column Info
	 * @param lodgDueDt
	 */
    public void setLodgDueDt(String lodgDueDt) {
        this.lodgDueDt = lodgDueDt;
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
	 * @param ediHldFlg
	 */
    public void setEdiHldFlg(String ediHldFlg) {
        this.ediHldFlg = ediHldFlg;
    }

    /**
	 * Column Info
	 * @param cmdtDesc
	 */
    public void setCmdtDesc(String cmdtDesc) {
        this.cmdtDesc = cmdtDesc;
    }

    /**
	 * Column Info
	 * @param spclHideFlg
	 */
    public void setSpclHideFlg(String spclHideFlg) {
        this.spclHideFlg = spclHideFlg;
    }

    /**
	 * Column Info
	 * @param ctrtSrepCd
	 */
    public void setCtrtSrepCd(String ctrtSrepCd) {
        this.ctrtSrepCd = ctrtSrepCd;
    }

    /**
	 * Column Info
	 * @param awkFlg
	 */
    public void setAwkFlg(String awkFlg) {
        this.awkFlg = awkFlg;
    }

    /**
	 * Column Info
	 * @param siCntcPsonFaxNo
	 */
    public void setSiCntcPsonFaxNo(String siCntcPsonFaxNo) {
        this.siCntcPsonFaxNo = siCntcPsonFaxNo;
    }

    /**
	 * Column Info
	 * @param stwgFlg
	 */
    public void setStwgFlg(String stwgFlg) {
        this.stwgFlg = stwgFlg;
    }

    /**
	 * Column Info
	 * @param partialVvdAssignFlg
	 */
    public void setPartialVvdAssignFlg(String partialVvdAssignFlg) {
        this.partialVvdAssignFlg = partialVvdAssignFlg;
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
	 * @param preRlyPortYdCd
	 */
    public void setPreRlyPortYdCd(String preRlyPortYdCd) {
        this.preRlyPortYdCd = preRlyPortYdCd;
    }

    /**
	 * Column Info
	 * @param bkgPolYdCd
	 */
    public void setBkgPolYdCd(String bkgPolYdCd) {
        this.bkgPolYdCd = bkgPolYdCd;
    }

    /**
	 * Column Info
	 * @param splitRsnCd
	 */
    public void setSplitRsnCd(String splitRsnCd) {
        this.splitRsnCd = splitRsnCd;
    }

    /**
	 * Column Info
	 * @param waitRsn
	 */
    public void setWaitRsn(String waitRsn) {
        this.waitRsn = waitRsn;
    }

    /**
	 * Column Info
	 * @param destTrnsModCd
	 */
    public void setDestTrnsModCd(String destTrnsModCd) {
        this.destTrnsModCd = destTrnsModCd;
    }

    /**
	 * Column Info
	 * @param siCntcPsonPhnNo
	 */
    public void setSiCntcPsonPhnNo(String siCntcPsonPhnNo) {
        this.siCntcPsonPhnNo = siCntcPsonPhnNo;
    }

    /**
	 * Column Info
	 * @param rfFlg
	 */
    public void setRfFlg(String rfFlg) {
        this.rfFlg = rfFlg;
    }

    /**
	 * Column Info
	 * @param lodgDueDtOld
	 */
    public void setLodgDueDtOld(String lodgDueDtOld) {
        this.lodgDueDtOld = lodgDueDtOld;
    }

    /**
	 * Column Info
	 * @param stopOffLocCd
	 */
    public void setStopOffLocCd(String stopOffLocCd) {
        this.stopOffLocCd = stopOffLocCd;
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
	 * @param bkgStsCd
	 */
    public void setBkgStsCd(String bkgStsCd) {
        this.bkgStsCd = bkgStsCd;
    }

    /**
	 * Column Info
	 * @param fdGrdFlg
	 */
    public void setFdGrdFlg(String fdGrdFlg) {
        this.fdGrdFlg = fdGrdFlg;
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
	 * @param scacCd
	 */
    public void setScacCd(String scacCd) {
        this.scacCd = scacCd;
    }

    /**
	 * Column Info
	 * @param cmdtCd
	 */
    public void setCmdtCd(String cmdtCd) {
        this.cmdtCd = cmdtCd;
    }

    /**
	 * Column Info
	 * @param fullPkupYdCd
	 */
    public void setFullPkupYdCd(String fullPkupYdCd) {
        this.fullPkupYdCd = fullPkupYdCd;
    }

    /**
	 * Column Info
	 * @param rcvTermCdOld
	 */
    public void setRcvTermCdOld(String rcvTermCdOld) {
        this.rcvTermCdOld = rcvTermCdOld;
    }

    /**
	 * Column Info
	 * @param isRatedFlg
	 */
    public void setIsRatedFlg(String isRatedFlg) {
        this.isRatedFlg = isRatedFlg;
    }

    /**
	 * Column Info
	 * @param mtyPkupYdCdOld
	 */
    public void setMtyPkupYdCdOld(String mtyPkupYdCdOld) {
        this.mtyPkupYdCdOld = mtyPkupYdCdOld;
    }

    /**
	 * Column Info
	 * @param stopOffCntcPsonNm
	 */
    public void setStopOffCntcPsonNm(String stopOffCntcPsonNm) {
        this.stopOffCntcPsonNm = stopOffCntcPsonNm;
    }

    /**
	 * Column Info
	 * @param podNm
	 */
    public void setPodNm(String podNm) {
        this.podNm = podNm;
    }

    /**
	 * Column Info
	 * @param stopOffFlg
	 */
    public void setStopOffFlg(String stopOffFlg) {
        this.stopOffFlg = stopOffFlg;
    }

    /**
	 * Column Info
	 * @param bkgPodYdCd
	 */
    public void setBkgPodYdCd(String bkgPodYdCd) {
        this.bkgPodYdCd = bkgPodYdCd;
    }

    /**
	 * Column Info
	 * @param delNm
	 */
    public void setDelNm(String delNm) {
        this.delNm = delNm;
    }

    /**
	 * Column Info
	 * @param porYdCdOld
	 */
    public void setPorYdCdOld(String porYdCdOld) {
        this.porYdCdOld = porYdCdOld;
    }

    /**
	 * Column Info
	 * @param filerCd
	 */
    public void setFilerCd(String filerCd) {
        this.filerCd = filerCd;
    }

    /**
	 * Column Info
	 * @param xterRqstAutoNtcFlg
	 */
    public void setXterRqstAutoNtcFlg(String xterRqstAutoNtcFlg) {
        this.xterRqstAutoNtcFlg = xterRqstAutoNtcFlg;
    }

    /**
	 * Column Info
	 * @param destScontiCd
	 */
    public void setDestScontiCd(String destScontiCd) {
        this.destScontiCd = destScontiCd;
    }

    /**
	 * Column Info
	 * @param mtyDorArrDt
	 */
    public void setMtyDorArrDt(String mtyDorArrDt) {
        this.mtyDorArrDt = mtyDorArrDt;
    }

    /**
	 * Column Info
	 * @param ofcCd
	 */
    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    /**
	 * Column Info
	 * @param polCdOld
	 */
    public void setPolCdOld(String polCdOld) {
        this.polCdOld = polCdOld;
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
	 * @param taaNo
	 */
    public void setTaaNo(String taaNo) {
        this.taaNo = taaNo;
    }

    /**
	 * Column Info
	 * @param siCntcPsonMphnNo
	 */
    public void setSiCntcPsonMphnNo(String siCntcPsonMphnNo) {
        this.siCntcPsonMphnNo = siCntcPsonMphnNo;
    }

    /**
	 * Column Info
	 * @param flexHgtFlg
	 */
    public void setFlexHgtFlg(String flexHgtFlg) {
        this.flexHgtFlg = flexHgtFlg;
    }

    /**
	 * Column Info
	 * @param cntrFlg
	 */
    public void setCntrFlg(String cntrFlg) {
        this.cntrFlg = cntrFlg;
    }

    /**
	 * Column Info
	 * @param lastVvdCd
	 */
    public void setLastVvdCd(String lastVvdCd) {
        this.lastVvdCd = lastVvdCd;
    }

    /**
	 * Column Info
	 * @param repCmdtCd
	 */
    public void setRepCmdtCd(String repCmdtCd) {
        this.repCmdtCd = repCmdtCd;
    }

    /**
	 * Column Info
	 * @param rejectFlag
	 */
    public void setRejectFlag(String rejectFlag) {
        this.rejectFlag = rejectFlag;
    }

    /**
	 * Column Info
	 * @param firstPolCd
	 */
    public void setFirstPolCd(String firstPolCd) {
        this.firstPolCd = firstPolCd;
    }

    /**
	 * Column Info
	 * @param bkgCntcPsonPhnNo
	 */
    public void setBkgCntcPsonPhnNo(String bkgCntcPsonPhnNo) {
        this.bkgCntcPsonPhnNo = bkgCntcPsonPhnNo;
    }

    /**
	 * Column Info
	 * @param ocpCd
	 */
    public void setOcpCd(String ocpCd) {
        this.ocpCd = ocpCd;
    }

    /**
	 * Column Info
	 * @param polNm
	 */
    public void setPolNm(String polNm) {
        this.polNm = polNm;
    }

    /**
	 * Column Info
	 * @param caUser
	 */
    public void setCaUser(String caUser) {
        this.caUser = caUser;
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
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Column Info
	 * @param bkgTrunkVvd
	 */
    public void setBkgTrunkVvd(String bkgTrunkVvd) {
        this.bkgTrunkVvd = bkgTrunkVvd;
    }

    /**
	 * Column Info
	 * @param pctlNo
	 */
    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    /**
	 * Column Info
	 * @param podYdCdOld
	 */
    public void setPodYdCdOld(String podYdCdOld) {
        this.podYdCdOld = podYdCdOld;
    }

    /**
	 * Column Info
	 * @param rollOvrCnt
	 */
    public void setRollOvrCnt(String rollOvrCnt) {
        this.rollOvrCnt = rollOvrCnt;
    }

    /**
	 * Column Info
	 * @param scNo
	 */
    public void setScNo(String scNo) {
        this.scNo = scNo;
    }

    /**
	 * Column Info
	 * @param prctFlg
	 */
    public void setPrctFlg(String prctFlg) {
        this.prctFlg = prctFlg;
    }

    /**
	 * Column Info
	 * @param taaNoOld
	 */
    public void setTaaNoOld(String taaNoOld) {
        this.taaNoOld = taaNoOld;
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
	 * @param rfaNoOld
	 */
    public void setRfaNoOld(String rfaNoOld) {
        this.rfaNoOld = rfaNoOld;
    }

    /**
	 * Column Info
	 * @param usrEml
	 */
    public void setUsrEml(String usrEml) {
        this.usrEml = usrEml;
    }

    /**
	 * Column Info
	 * @param obSlsOfcCd
	 */
    public void setObSlsOfcCd(String obSlsOfcCd) {
        this.obSlsOfcCd = obSlsOfcCd;
    }

    /**
	 * Column Info
	 * @param xterSiCd
	 */
    public void setXterSiCd(String xterSiCd) {
        this.xterSiCd = xterSiCd;
    }

    /**
	 * Column Info
	 * @param mtyPkupDt
	 */
    public void setMtyPkupDt(String mtyPkupDt) {
        this.mtyPkupDt = mtyPkupDt;
    }

    /**
	 * Column Info
	 * @param cndCstmsFileCd
	 */
    public void setCndCstmsFileCd(String cndCstmsFileCd) {
        this.cndCstmsFileCd = cndCstmsFileCd;
    }

    /**
	 * Column Info
	 * @param xterBkgRqstCd
	 */
    public void setXterBkgRqstCd(String xterBkgRqstCd) {
        this.xterBkgRqstCd = xterBkgRqstCd;
    }

    /**
	 * Column Info
	 * @param bkgPorCd
	 */
    public void setBkgPorCd(String bkgPorCd) {
        this.bkgPorCd = bkgPorCd;
    }

    /**
	 * Column Info
	 * @param lastPodCd
	 */
    public void setLastPodCd(String lastPodCd) {
        this.lastPodCd = lastPodCd;
    }

    /**
	 * Column Info
	 * @param preRlyPortCd
	 */
    public void setPreRlyPortCd(String preRlyPortCd) {
        this.preRlyPortCd = preRlyPortCd;
    }

    /**
	 * Column Info
	 * @param bbCgoFlgOld
	 */
    public void setBbCgoFlgOld(String bbCgoFlgOld) {
        this.bbCgoFlgOld = bbCgoFlgOld;
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
	 * @param stopOffCntcPhnNo
	 */
    public void setStopOffCntcPhnNo(String stopOffCntcPhnNo) {
        this.stopOffCntcPhnNo = stopOffCntcPhnNo;
    }

    /**
	 * Column Info
	 * @param pstVvdCd
	 */
    public void setPstVvdCd(String pstVvdCd) {
        this.pstVvdCd = pstVvdCd;
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
	 * @param porNm
	 */
    public void setPorNm(String porNm) {
        this.porNm = porNm;
    }

    /**
	 * Column Info
	 * @param rfaAvailable
	 */
    public void setRfaAvailable(String rfaAvailable) {
        this.rfaAvailable = rfaAvailable;
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
	 * @param xterBkgRqstRefNo
	 */
    public void setXterBkgRqstRefNo(String xterBkgRqstRefNo) {
        this.xterBkgRqstRefNo = xterBkgRqstRefNo;
    }

    /**
	 * Column Info
	 * @param pstRlyPortCd
	 */
    public void setPstRlyPortCd(String pstRlyPortCd) {
        this.pstRlyPortCd = pstRlyPortCd;
    }

    /**
	 * Column Info
	 * @param splitFlg
	 */
    public void setSplitFlg(String splitFlg) {
        this.splitFlg = splitFlg;
    }

    /**
	 * Column Info
	 * @param fullRtnYdCdOld
	 */
    public void setFullRtnYdCdOld(String fullRtnYdCdOld) {
        this.fullRtnYdCdOld = fullRtnYdCdOld;
    }

    /**
	 * Column Info
	 * @param xtnPhnNo
	 */
    public void setXtnPhnNo(String xtnPhnNo) {
        this.xtnPhnNo = xtnPhnNo;
    }

    /**
	 * Column Info
	 * @param docUsrId
	 */
    public void setDocUsrId(String docUsrId) {
        this.docUsrId = docUsrId;
    }

    /**
	 * Column Info
	 * @param orgTrnsSvcModCd
	 */
    public void setOrgTrnsSvcModCd(String orgTrnsSvcModCd) {
        this.orgTrnsSvcModCd = orgTrnsSvcModCd;
    }

    /**
	 * Column Info
	 * @param pstRlyPortYdCd
	 */
    public void setPstRlyPortYdCd(String pstRlyPortYdCd) {
        this.pstRlyPortYdCd = pstRlyPortYdCd;
    }

    /**
	 * Column Info
	 * @param scNoOld
	 */
    public void setScNoOld(String scNoOld) {
        this.scNoOld = scNoOld;
    }

    /**
	 * Column Info
	 * @param bdrFlg
	 */
    public void setBdrFlg(String bdrFlg) {
        this.bdrFlg = bdrFlg;
    }

    /**
	 * Column Info
	 * @param siCntcPsonEml
	 */
    public void setSiCntcPsonEml(String siCntcPsonEml) {
        this.siCntcPsonEml = siCntcPsonEml;
    }

    /**
	 * Column Info
	 * @param rcFlgOld
	 */
    public void setRcFlgOld(String rcFlgOld) {
        this.rcFlgOld = rcFlgOld;
    }

    /**
	 * Column Info
	 * @param bkgCntcPsonNm
	 */
    public void setBkgCntcPsonNm(String bkgCntcPsonNm) {
        this.bkgCntcPsonNm = bkgCntcPsonNm;
    }

    /**
	 * Column Info
	 * @param stopOffDiffRmk
	 */
    public void setStopOffDiffRmk(String stopOffDiffRmk) {
        this.stopOffDiffRmk = stopOffDiffRmk;
    }

    /**
	 * Column Info
	 * @param advShtgCd
	 */
    public void setAdvShtgCd(String advShtgCd) {
        this.advShtgCd = advShtgCd;
    }

    /**
	 * Column Info
	 * @param hotDeFlg
	 */
    public void setHotDeFlg(String hotDeFlg) {
        this.hotDeFlg = hotDeFlg;
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
	 * @param vvdFlag
	 */
    public void setVvdFlag(String vvdFlag) {
        this.vvdFlag = vvdFlag;
    }

    /**
	 * Column Info
	 * @param revDirCd
	 */
    public void setRevDirCd(String revDirCd) {
        this.revDirCd = revDirCd;
    }

    /**
	 * Column Info
	 * @param rfaNo
	 */
    public void setRfaNo(String rfaNo) {
        this.rfaNo = rfaNo;
    }

    /**
	 * Column Info
	 * @param fmcNo
	 */
    public void setFmcNo(String fmcNo) {
        this.fmcNo = fmcNo;
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
	 * @param railBlkCd
	 */
    public void setRailBlkCd(String railBlkCd) {
        this.railBlkCd = railBlkCd;
    }

    /**
	 * Column Info
	 * @param usrNm
	 */
    public void setUsrNm(String usrNm) {
        this.usrNm = usrNm;
    }

    /**
	 * Column Info
	 * @param bkgDelCd
	 */
    public void setBkgDelCd(String bkgDelCd) {
        this.bkgDelCd = bkgDelCd;
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
	 * @param caFlg
	 */
    public void setCaFlg(String caFlg) {
        this.caFlg = caFlg;
    }

    /**
	 * Column Info
	 * @param bkgCntcPsonMphnNo
	 */
    public void setBkgCntcPsonMphnNo(String bkgCntcPsonMphnNo) {
        this.bkgCntcPsonMphnNo = bkgCntcPsonMphnNo;
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
	 * @param siCntcPsonNm
	 */
    public void setSiCntcPsonNm(String siCntcPsonNm) {
        this.siCntcPsonNm = siCntcPsonNm;
    }

    /**
	 * Column Info
	 * @param bkgPolCd
	 */
    public void setBkgPolCd(String bkgPolCd) {
        this.bkgPolCd = bkgPolCd;
    }

    /**
	 * Column Info
	 * @param deTermCdOld
	 */
    public void setDeTermCdOld(String deTermCdOld) {
        this.deTermCdOld = deTermCdOld;
    }

    /**
	 * Column Info
	 * @param scAvailable
	 */
    public void setScAvailable(String scAvailable) {
        this.scAvailable = scAvailable;
    }

    /**
	 * Column Info
	 * @param delYdCdOld
	 */
    public void setDelYdCdOld(String delYdCdOld) {
        this.delYdCdOld = delYdCdOld;
    }

    /**
	 * Column Info
	 * @param lastPodClptIndSeq
	 */
    public void setLastPodClptIndSeq(String lastPodClptIndSeq) {
        this.lastPodClptIndSeq = lastPodClptIndSeq;
    }

    /**
	 * Column Info
	 * @param premiumAvailableFlg
	 */
    public void setPremiumAvailableFlg(String premiumAvailableFlg) {
        this.premiumAvailableFlg = premiumAvailableFlg;
    }

    /**
	 * Column Info
	 * @param twnSoNo
	 */
    public void setTwnSoNo(String twnSoNo) {
        this.twnSoNo = twnSoNo;
    }

    /**
	 * Column Info
	 * @param deDueDtOld
	 */
    public void setDeDueDtOld(String deDueDtOld) {
        this.deDueDtOld = deDueDtOld;
    }

    /**
	 * Column Info
	 * @param bkgTrunkVvdOld
	 */
    public void setBkgTrunkVvdOld(String bkgTrunkVvdOld) {
        this.bkgTrunkVvdOld = bkgTrunkVvdOld;
    }

    /**
	 * Column Info
	 * @param usaCstmsFileCd
	 */
    public void setUsaCstmsFileCd(String usaCstmsFileCd) {
        this.usaCstmsFileCd = usaCstmsFileCd;
    }

    /**
	 * Column Info
	 * @param actWgt
	 */
    public void setActWgt(String actWgt) {
        this.actWgt = actWgt;
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
	 * @param deTermCd
	 */
    public void setDeTermCd(String deTermCd) {
        this.deTermCd = deTermCd;
    }

    /**
	 * Column Info
	 * @param dgFlg
	 */
    public void setDgFlg(String dgFlg) {
        this.dgFlg = dgFlg;
    }

    /**
	 * Column Info
	 * @param firstPolClptIndSeq
	 */
    public void setFirstPolClptIndSeq(String firstPolClptIndSeq) {
        this.firstPolClptIndSeq = firstPolClptIndSeq;
    }

    /**
	 * Column Info
	 * @param bkgPorYdCd
	 */
    public void setBkgPorYdCd(String bkgPorYdCd) {
        this.bkgPorYdCd = bkgPorYdCd;
    }

    /**
	 * Column Info
	 * @param delCdOld
	 */
    public void setDelCdOld(String delCdOld) {
        this.delCdOld = delCdOld;
    }

    /**
	 * Column Info
	 * @param hngrFlg
	 */
    public void setHngrFlg(String hngrFlg) {
        this.hngrFlg = hngrFlg;
    }

    /**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
    public void setMtyRtnYdCd(String mtyRtnYdCd) {
        this.mtyRtnYdCd = mtyRtnYdCd;
    }

    /**
	 * Column Info
	 * @param firstVvdCd
	 */
    public void setFirstVvdCd(String firstVvdCd) {
        this.firstVvdCd = firstVvdCd;
    }

    /**
	 * Column Info
	 * @param preVvdCd
	 */
    public void setPreVvdCd(String preVvdCd) {
        this.preVvdCd = preVvdCd;
    }

    /**
	 * Column Info
	 * @param vndrRmk
	 */
    public void setVndrRmk(String vndrRmk) {
        this.vndrRmk = vndrRmk;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustCntCd
	 */
    public void setBkgCtrlPtyCustCntCd(String bkgCtrlPtyCustCntCd) {
        this.bkgCtrlPtyCustCntCd = bkgCtrlPtyCustCntCd;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustSeq
	 */
    public void setBkgCtrlPtyCustSeq(String bkgCtrlPtyCustSeq) {
        this.bkgCtrlPtyCustSeq = bkgCtrlPtyCustSeq;
    }

    /**
	 * Column Info
	 * @param bkgCtrlPtyCustSeq
	 */
    public void setBkgCtrlPtyCustNm(String bkgCtrlPtyCustNm) {
        this.bkgCtrlPtyCustNm = bkgCtrlPtyCustNm;
    }

    public void setBkgWtChkFlg(String bkgWtChkFlg) {
        this.bkgWtChkFlg = bkgWtChkFlg;
    }

    public String getBkgWtChkFlg() {
        return this.bkgWtChkFlg;
    }

    public void setXterRqstSeq(String xterRqstSeq) {
        this.xterRqstSeq = xterRqstSeq;
    }

    public String getXterRqstSeq() {
        return this.xterRqstSeq;
    }

    public void setIrrBlNoFlg(String irrBlNoFlg) {
        this.irrBlNoFlg = irrBlNoFlg;
    }

    public String getIrrBlNoFlg() {
        return this.irrBlNoFlg;
    }

    public void setBkgTyFlg(String bkgTyFlg) {
        this.bkgTyFlg = bkgTyFlg;
    }

    public String getBkgTyFlg() {
        return this.bkgTyFlg;
    }

    public void setXterVgmRqstCd(String xterVgmRqstCd) {
        this.xterVgmRqstCd = xterVgmRqstCd;
    }

    public String getXterVgmRqstCd() {
        return this.xterVgmRqstCd;
    }

    public void setBkgPtyCntCd(String bkgPtyCntCd) {
        this.bkgPtyCntCd = bkgPtyCntCd;
    }

    public String getBkgPtyCntCd() {
        return this.bkgPtyCntCd;
    }

    public void setBkgPtyCustSeq(String bkgPtyCustSeq) {
        this.bkgPtyCustSeq = bkgPtyCustSeq;
    }

    public String getBkgPtyCustSeq() {
        return this.bkgPtyCustSeq;
    }

    public void setBkgPtyCustNm(String bkgPtyCustNm) {
        this.bkgPtyCustNm = bkgPtyCustNm;
    }

    public String getBkgPtyCustNm() {
        return this.bkgPtyCustNm;
    }

    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    public String getUpdDt() {
        return this.updDt;
    }

    public void setLstSavDt(String lstSavDt) {
        this.lstSavDt = lstSavDt;
    }

    public String getLstSavDt() {
        return this.lstSavDt;
    }

    public void setModifyCargoFlg(String modifyCargoFlg) {
        this.modifyCargoFlg = modifyCargoFlg;
    }

    public String getModifyCargoFlg() {
        return this.modifyCargoFlg;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setBkgDelYdCd(JSPUtil.getParameter(request, prefix + "bkg_del_yd_cd", ""));
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setAwkCgoFlgOld(JSPUtil.getParameter(request, prefix + "awk_cgo_flg_old", ""));
        setOrgTrnsModCd(JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        setTaaAvailable(JSPUtil.getParameter(request, prefix + "taa_available", ""));
        setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
        setPolYdCdOld(JSPUtil.getParameter(request, prefix + "pol_yd_cd_old", ""));
        setCmdtCdOld(JSPUtil.getParameter(request, prefix + "cmdt_cd_old", ""));
        setBkgCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_fax_no", ""));
        setMtyPkupDtOld(JSPUtil.getParameter(request, prefix + "mty_pkup_dt_old", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
        setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
        setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
        setFnlDestNm(JSPUtil.getParameter(request, prefix + "fnl_dest_nm", ""));
        setPorCdOld(JSPUtil.getParameter(request, prefix + "por_cd_old", ""));
        setOldBkgNo(JSPUtil.getParameter(request, prefix + "old_bkg_no", ""));
        setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
        setRefFlg(JSPUtil.getParameter(request, prefix + "ref_flg", ""));
        setBbFlg(JSPUtil.getParameter(request, prefix + "bb_flg", ""));
        setStwgRmk(JSPUtil.getParameter(request, prefix + "stwg_rmk", ""));
        setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
        setPodCdOld(JSPUtil.getParameter(request, prefix + "pod_cd_old", ""));
        setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
        setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
        setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
        setMnlBkgNoFlg(JSPUtil.getParameter(request, prefix + "mnl_bkg_no_flg", ""));
        setXterSiRefNo(JSPUtil.getParameter(request, prefix + "xter_si_ref_no", ""));
        setOrgScontiCd(JSPUtil.getParameter(request, prefix + "org_sconti_cd", ""));
        setBkgCntcPsonEml(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", ""));
        setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
        setDcgoFlgOld(JSPUtil.getParameter(request, prefix + "dcgo_flg_old", ""));
        setMtyDorArrDtOld(JSPUtil.getParameter(request, prefix + "mty_dor_arr_dt_old", ""));
        setDeDueDt(JSPUtil.getParameter(request, prefix + "de_due_dt", ""));
        setLodgDueDt(JSPUtil.getParameter(request, prefix + "lodg_due_dt", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
        setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
        setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
        setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
        setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
        setSiCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_fax_no", ""));
        setStwgFlg(JSPUtil.getParameter(request, prefix + "stwg_flg", ""));
        setPartialVvdAssignFlg(JSPUtil.getParameter(request, prefix + "partial_vvd_assign_flg", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setPreRlyPortYdCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_yd_cd", ""));
        setBkgPolYdCd(JSPUtil.getParameter(request, prefix + "bkg_pol_yd_cd", ""));
        setSplitRsnCd(JSPUtil.getParameter(request, prefix + "split_rsn_cd", ""));
        setWaitRsn(JSPUtil.getParameter(request, prefix + "wait_rsn", ""));
        setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
        setSiCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_phn_no", ""));
        setRfFlg(JSPUtil.getParameter(request, prefix + "rf_flg", ""));
        setLodgDueDtOld(JSPUtil.getParameter(request, prefix + "lodg_due_dt_old", ""));
        setStopOffLocCd(JSPUtil.getParameter(request, prefix + "stop_off_loc_cd", ""));
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
        setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
        setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
        setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
        setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
        setFullPkupYdCd(JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", ""));
        setRcvTermCdOld(JSPUtil.getParameter(request, prefix + "rcv_term_cd_old", ""));
        setIsRatedFlg(JSPUtil.getParameter(request, prefix + "is_rated_flg", ""));
        setMtyPkupYdCdOld(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd_old", ""));
        setStopOffCntcPsonNm(JSPUtil.getParameter(request, prefix + "stop_off_cntc_pson_nm", ""));
        setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
        setStopOffFlg(JSPUtil.getParameter(request, prefix + "stop_off_flg", ""));
        setBkgPodYdCd(JSPUtil.getParameter(request, prefix + "bkg_pod_yd_cd", ""));
        setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
        setPorYdCdOld(JSPUtil.getParameter(request, prefix + "por_yd_cd_old", ""));
        setFilerCd(JSPUtil.getParameter(request, prefix + "filer_cd", ""));
        setXterRqstAutoNtcFlg(JSPUtil.getParameter(request, prefix + "xter_rqst_auto_ntc_flg", ""));
        setDestScontiCd(JSPUtil.getParameter(request, prefix + "dest_sconti_cd", ""));
        setMtyDorArrDt(JSPUtil.getParameter(request, prefix + "mty_dor_arr_dt", ""));
        setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
        setPolCdOld(JSPUtil.getParameter(request, prefix + "pol_cd_old", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
        setSiCntcPsonMphnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_mphn_no", ""));
        setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
        setCntrFlg(JSPUtil.getParameter(request, prefix + "cntr_flg", ""));
        setLastVvdCd(JSPUtil.getParameter(request, prefix + "last_vvd_cd", ""));
        setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
        setRejectFlag(JSPUtil.getParameter(request, prefix + "reject_flag", ""));
        setFirstPolCd(JSPUtil.getParameter(request, prefix + "first_pol_cd", ""));
        setBkgCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_phn_no", ""));
        setOcpCd(JSPUtil.getParameter(request, prefix + "ocp_cd", ""));
        setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
        setCaUser(JSPUtil.getParameter(request, prefix + "ca_user", ""));
        setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setBkgTrunkVvd(JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setPodYdCdOld(JSPUtil.getParameter(request, prefix + "pod_yd_cd_old", ""));
        setRollOvrCnt(JSPUtil.getParameter(request, prefix + "roll_ovr_cnt", ""));
        setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
        setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
        setTaaNoOld(JSPUtil.getParameter(request, prefix + "taa_no_old", ""));
        setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
        setRfaNoOld(JSPUtil.getParameter(request, prefix + "rfa_no_old", ""));
        setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
        setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
        setXterSiCd(JSPUtil.getParameter(request, prefix + "xter_si_cd", ""));
        setMtyPkupDt(JSPUtil.getParameter(request, prefix + "mty_pkup_dt", ""));
        setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
        setXterBkgRqstCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", ""));
        setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
        setLastPodCd(JSPUtil.getParameter(request, prefix + "last_pod_cd", ""));
        setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
        setBbCgoFlgOld(JSPUtil.getParameter(request, prefix + "bb_cgo_flg_old", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setStopOffCntcPhnNo(JSPUtil.getParameter(request, prefix + "stop_off_cntc_phn_no", ""));
        setPstVvdCd(JSPUtil.getParameter(request, prefix + "pst_vvd_cd", ""));
        setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
        setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
        setRfaAvailable(JSPUtil.getParameter(request, prefix + "rfa_available", ""));
        setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
        setXterBkgRqstRefNo(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", ""));
        setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
        setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
        setFullRtnYdCdOld(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd_old", ""));
        setXtnPhnNo(JSPUtil.getParameter(request, prefix + "xtn_phn_no", ""));
        setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
        setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
        setPstRlyPortYdCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_yd_cd", ""));
        setScNoOld(JSPUtil.getParameter(request, prefix + "sc_no_old", ""));
        setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
        setSiCntcPsonEml(JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", ""));
        setRcFlgOld(JSPUtil.getParameter(request, prefix + "rc_flg_old", ""));
        setBkgCntcPsonNm(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_nm", ""));
        setStopOffDiffRmk(JSPUtil.getParameter(request, prefix + "stop_off_diff_rmk", ""));
        setAdvShtgCd(JSPUtil.getParameter(request, prefix + "adv_shtg_cd", ""));
        setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
        setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
        setVvdFlag(JSPUtil.getParameter(request, prefix + "vvd_flag", ""));
        setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
        setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
        setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setRailBlkCd(JSPUtil.getParameter(request, prefix + "rail_blk_cd", ""));
        setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
        setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
        setBkgCntcPsonMphnNo(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_mphn_no", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setSiCntcPsonNm(JSPUtil.getParameter(request, prefix + "si_cntc_pson_nm", ""));
        setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
        setDeTermCdOld(JSPUtil.getParameter(request, prefix + "de_term_cd_old", ""));
        setScAvailable(JSPUtil.getParameter(request, prefix + "sc_available", ""));
        setDelYdCdOld(JSPUtil.getParameter(request, prefix + "del_yd_cd_old", ""));
        setLastPodClptIndSeq(JSPUtil.getParameter(request, prefix + "last_pod_clpt_ind_seq", ""));
        setPremiumAvailableFlg(JSPUtil.getParameter(request, prefix + "premium_available_flg", ""));
        setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
        setDeDueDtOld(JSPUtil.getParameter(request, prefix + "de_due_dt_old", ""));
        setBkgTrunkVvdOld(JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd_old", ""));
        setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
        setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
        setFirstPolClptIndSeq(JSPUtil.getParameter(request, prefix + "first_pol_clpt_ind_seq", ""));
        setBkgPorYdCd(JSPUtil.getParameter(request, prefix + "bkg_por_yd_cd", ""));
        setDelCdOld(JSPUtil.getParameter(request, prefix + "del_cd_old", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_rtn_yd_cd", ""));
        setFirstVvdCd(JSPUtil.getParameter(request, prefix + "first_vvd_cd", ""));
        setPreVvdCd(JSPUtil.getParameter(request, prefix + "pre_vvd_cd", ""));
        setVndrRmk(JSPUtil.getParameter(request, prefix + "vndr_rmk", ""));
        setBkgCtrlPtyCustCntCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_cnt_cd", ""));
        setBkgCtrlPtyCustSeq(JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_seq", ""));
        setBkgCtrlPtyCustNm(JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_nm", ""));
        setBkgWtChkFlg(JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", ""));
        setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
        setIrrBlNoFlg(JSPUtil.getParameter(request, prefix + "irr_bl_no_flg", ""));
        setBkgTyFlg(JSPUtil.getParameter(request, prefix + "bkg_ty_flg", ""));
        setXterVgmRqstCd(JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_cd", ""));
        setBkgPtyCntCd(JSPUtil.getParameter(request, prefix + "bkg_pty_cnt_cd", ""));
        setBkgPtyCustSeq(JSPUtil.getParameter(request, prefix + "bkg_pty_cust_seq", ""));
        setBkgPtyCustNm(JSPUtil.getParameter(request, prefix + "bkg_pty_cust_nm", ""));
        setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
        setLstSavDt(JSPUtil.getParameter(request, prefix + "lst_sav_dt", ""));
        setModifyCargoFlg(JSPUtil.getParameter(request, prefix + "modify_cargo_flg", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBookingInfoVO[]
	 */
    public BkgBookingInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBookingInfoVO[]
	 */
    public BkgBookingInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BkgBookingInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgDelYdCd = (JSPUtil.getParameter(request, prefix + "bkg_del_yd_cd", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] awkCgoFlgOld = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg_old", length));
            String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] taaAvailable = (JSPUtil.getParameter(request, prefix + "taa_available", length));
            String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", length));
            String[] polYdCdOld = (JSPUtil.getParameter(request, prefix + "pol_yd_cd_old", length));
            String[] cmdtCdOld = (JSPUtil.getParameter(request, prefix + "cmdt_cd_old", length));
            String[] bkgCntcPsonFaxNo = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_fax_no", length));
            String[] mtyPkupDtOld = (JSPUtil.getParameter(request, prefix + "mty_pkup_dt_old", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
            String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", length));
            String[] bkgPodCd = (JSPUtil.getParameter(request, prefix + "bkg_pod_cd", length));
            String[] fnlDestNm = (JSPUtil.getParameter(request, prefix + "fnl_dest_nm", length));
            String[] porCdOld = (JSPUtil.getParameter(request, prefix + "por_cd_old", length));
            String[] oldBkgNo = (JSPUtil.getParameter(request, prefix + "old_bkg_no", length));
            String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", length));
            String[] refFlg = (JSPUtil.getParameter(request, prefix + "ref_flg", length));
            String[] bbFlg = (JSPUtil.getParameter(request, prefix + "bb_flg", length));
            String[] stwgRmk = (JSPUtil.getParameter(request, prefix + "stwg_rmk", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] podCdOld = (JSPUtil.getParameter(request, prefix + "pod_cd_old", length));
            String[] siFlg = (JSPUtil.getParameter(request, prefix + "si_flg", length));
            String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
            String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
            String[] mnlBkgNoFlg = (JSPUtil.getParameter(request, prefix + "mnl_bkg_no_flg", length));
            String[] xterSiRefNo = (JSPUtil.getParameter(request, prefix + "xter_si_ref_no", length));
            String[] orgScontiCd = (JSPUtil.getParameter(request, prefix + "org_sconti_cd", length));
            String[] bkgCntcPsonEml = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", length));
            String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", length));
            String[] dcgoFlgOld = (JSPUtil.getParameter(request, prefix + "dcgo_flg_old", length));
            String[] mtyDorArrDtOld = (JSPUtil.getParameter(request, prefix + "mty_dor_arr_dt_old", length));
            String[] deDueDt = (JSPUtil.getParameter(request, prefix + "de_due_dt", length));
            String[] lodgDueDt = (JSPUtil.getParameter(request, prefix + "lodg_due_dt", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ediHldFlg = (JSPUtil.getParameter(request, prefix + "edi_hld_flg", length));
            String[] cmdtDesc = (JSPUtil.getParameter(request, prefix + "cmdt_desc", length));
            String[] spclHideFlg = (JSPUtil.getParameter(request, prefix + "spcl_hide_flg", length));
            String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", length));
            String[] awkFlg = (JSPUtil.getParameter(request, prefix + "awk_flg", length));
            String[] siCntcPsonFaxNo = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_fax_no", length));
            String[] stwgFlg = (JSPUtil.getParameter(request, prefix + "stwg_flg", length));
            String[] partialVvdAssignFlg = (JSPUtil.getParameter(request, prefix + "partial_vvd_assign_flg", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] preRlyPortYdCd = (JSPUtil.getParameter(request, prefix + "pre_rly_port_yd_cd", length));
            String[] bkgPolYdCd = (JSPUtil.getParameter(request, prefix + "bkg_pol_yd_cd", length));
            String[] splitRsnCd = (JSPUtil.getParameter(request, prefix + "split_rsn_cd", length));
            String[] waitRsn = (JSPUtil.getParameter(request, prefix + "wait_rsn", length));
            String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", length));
            String[] siCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_phn_no", length));
            String[] rfFlg = (JSPUtil.getParameter(request, prefix + "rf_flg", length));
            String[] lodgDueDtOld = (JSPUtil.getParameter(request, prefix + "lodg_due_dt_old", length));
            String[] stopOffLocCd = (JSPUtil.getParameter(request, prefix + "stop_off_loc_cd", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
            String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix + "fd_grd_flg", length));
            String[] interRmk = (JSPUtil.getParameter(request, prefix + "inter_rmk", length));
            String[] scacCd = (JSPUtil.getParameter(request, prefix + "scac_cd", length));
            String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
            String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", length));
            String[] rcvTermCdOld = (JSPUtil.getParameter(request, prefix + "rcv_term_cd_old", length));
            String[] isRatedFlg = (JSPUtil.getParameter(request, prefix + "is_rated_flg", length));
            String[] mtyPkupYdCdOld = (JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd_old", length));
            String[] stopOffCntcPsonNm = (JSPUtil.getParameter(request, prefix + "stop_off_cntc_pson_nm", length));
            String[] podNm = (JSPUtil.getParameter(request, prefix + "pod_nm", length));
            String[] stopOffFlg = (JSPUtil.getParameter(request, prefix + "stop_off_flg", length));
            String[] bkgPodYdCd = (JSPUtil.getParameter(request, prefix + "bkg_pod_yd_cd", length));
            String[] delNm = (JSPUtil.getParameter(request, prefix + "del_nm", length));
            String[] porYdCdOld = (JSPUtil.getParameter(request, prefix + "por_yd_cd_old", length));
            String[] filerCd = (JSPUtil.getParameter(request, prefix + "filer_cd", length));
            String[] xterRqstAutoNtcFlg = (JSPUtil.getParameter(request, prefix + "xter_rqst_auto_ntc_flg", length));
            String[] destScontiCd = (JSPUtil.getParameter(request, prefix + "dest_sconti_cd", length));
            String[] mtyDorArrDt = (JSPUtil.getParameter(request, prefix + "mty_dor_arr_dt", length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd", length));
            String[] polCdOld = (JSPUtil.getParameter(request, prefix + "pol_cd_old", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] taaNo = (JSPUtil.getParameter(request, prefix + "taa_no", length));
            String[] siCntcPsonMphnNo = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_mphn_no", length));
            String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix + "flex_hgt_flg", length));
            String[] cntrFlg = (JSPUtil.getParameter(request, prefix + "cntr_flg", length));
            String[] lastVvdCd = (JSPUtil.getParameter(request, prefix + "last_vvd_cd", length));
            String[] repCmdtCd = (JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", length));
            String[] rejectFlag = (JSPUtil.getParameter(request, prefix + "reject_flag", length));
            String[] firstPolCd = (JSPUtil.getParameter(request, prefix + "first_pol_cd", length));
            String[] bkgCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_phn_no", length));
            String[] ocpCd = (JSPUtil.getParameter(request, prefix + "ocp_cd", length));
            String[] polNm = (JSPUtil.getParameter(request, prefix + "pol_nm", length));
            String[] caUser = (JSPUtil.getParameter(request, prefix + "ca_user", length));
            String[] blckStwgCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_cd", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] bkgTrunkVvd = (JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", length));
            String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
            String[] podYdCdOld = (JSPUtil.getParameter(request, prefix + "pod_yd_cd_old", length));
            String[] rollOvrCnt = (JSPUtil.getParameter(request, prefix + "roll_ovr_cnt", length));
            String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
            String[] prctFlg = (JSPUtil.getParameter(request, prefix + "prct_flg", length));
            String[] taaNoOld = (JSPUtil.getParameter(request, prefix + "taa_no_old", length));
            String[] wgtUtCd = (JSPUtil.getParameter(request, prefix + "wgt_ut_cd", length));
            String[] rfaNoOld = (JSPUtil.getParameter(request, prefix + "rfa_no_old", length));
            String[] usrEml = (JSPUtil.getParameter(request, prefix + "usr_eml", length));
            String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
            String[] xterSiCd = (JSPUtil.getParameter(request, prefix + "xter_si_cd", length));
            String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix + "mty_pkup_dt", length));
            String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", length));
            String[] xterBkgRqstCd = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", length));
            String[] bkgPorCd = (JSPUtil.getParameter(request, prefix + "bkg_por_cd", length));
            String[] lastPodCd = (JSPUtil.getParameter(request, prefix + "last_pod_cd", length));
            String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", length));
            String[] bbCgoFlgOld = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg_old", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] stopOffCntcPhnNo = (JSPUtil.getParameter(request, prefix + "stop_off_cntc_phn_no", length));
            String[] pstVvdCd = (JSPUtil.getParameter(request, prefix + "pst_vvd_cd", length));
            String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
            String[] porNm = (JSPUtil.getParameter(request, prefix + "por_nm", length));
            String[] rfaAvailable = (JSPUtil.getParameter(request, prefix + "rfa_available", length));
            String[] xterRmk = (JSPUtil.getParameter(request, prefix + "xter_rmk", length));
            String[] xterBkgRqstRefNo = (JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", length));
            String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", length));
            String[] splitFlg = (JSPUtil.getParameter(request, prefix + "split_flg", length));
            String[] fullRtnYdCdOld = (JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd_old", length));
            String[] xtnPhnNo = (JSPUtil.getParameter(request, prefix + "xtn_phn_no", length));
            String[] docUsrId = (JSPUtil.getParameter(request, prefix + "doc_usr_id", length));
            String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", length));
            String[] pstRlyPortYdCd = (JSPUtil.getParameter(request, prefix + "pst_rly_port_yd_cd", length));
            String[] scNoOld = (JSPUtil.getParameter(request, prefix + "sc_no_old", length));
            String[] bdrFlg = (JSPUtil.getParameter(request, prefix + "bdr_flg", length));
            String[] siCntcPsonEml = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", length));
            String[] rcFlgOld = (JSPUtil.getParameter(request, prefix + "rc_flg_old", length));
            String[] bkgCntcPsonNm = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_nm", length));
            String[] stopOffDiffRmk = (JSPUtil.getParameter(request, prefix + "stop_off_diff_rmk", length));
            String[] advShtgCd = (JSPUtil.getParameter(request, prefix + "adv_shtg_cd", length));
            String[] hotDeFlg = (JSPUtil.getParameter(request, prefix + "hot_de_flg", length));
            String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix + "eq_subst_flg", length));
            String[] vvdFlag = (JSPUtil.getParameter(request, prefix + "vvd_flag", length));
            String[] revDirCd = (JSPUtil.getParameter(request, prefix + "rev_dir_cd", length));
            String[] rfaNo = (JSPUtil.getParameter(request, prefix + "rfa_no", length));
            String[] fmcNo = (JSPUtil.getParameter(request, prefix + "fmc_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] railBlkCd = (JSPUtil.getParameter(request, prefix + "rail_blk_cd", length));
            String[] usrNm = (JSPUtil.getParameter(request, prefix + "usr_nm", length));
            String[] bkgDelCd = (JSPUtil.getParameter(request, prefix + "bkg_del_cd", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] caFlg = (JSPUtil.getParameter(request, prefix + "ca_flg", length));
            String[] bkgCntcPsonMphnNo = (JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_mphn_no", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] siCntcPsonNm = (JSPUtil.getParameter(request, prefix + "si_cntc_pson_nm", length));
            String[] bkgPolCd = (JSPUtil.getParameter(request, prefix + "bkg_pol_cd", length));
            String[] deTermCdOld = (JSPUtil.getParameter(request, prefix + "de_term_cd_old", length));
            String[] scAvailable = (JSPUtil.getParameter(request, prefix + "sc_available", length));
            String[] delYdCdOld = (JSPUtil.getParameter(request, prefix + "del_yd_cd_old", length));
            String[] lastPodClptIndSeq = (JSPUtil.getParameter(request, prefix + "last_pod_clpt_ind_seq", length));
            String[] premiumAvailableFlg = (JSPUtil.getParameter(request, prefix + "premium_available_flg", length));
            String[] twnSoNo = (JSPUtil.getParameter(request, prefix + "twn_so_no", length));
            String[] deDueDtOld = (JSPUtil.getParameter(request, prefix + "de_due_dt_old", length));
            String[] bkgTrunkVvdOld = (JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd_old", length));
            String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", length));
            String[] actWgt = (JSPUtil.getParameter(request, prefix + "act_wgt", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] dgFlg = (JSPUtil.getParameter(request, prefix + "dg_flg", length));
            String[] firstPolClptIndSeq = (JSPUtil.getParameter(request, prefix + "first_pol_clpt_ind_seq", length));
            String[] bkgPorYdCd = (JSPUtil.getParameter(request, prefix + "bkg_por_yd_cd", length));
            String[] delCdOld = (JSPUtil.getParameter(request, prefix + "del_cd_old", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix + "mty_rtn_yd_cd", length));
            String[] firstVvdCd = (JSPUtil.getParameter(request, prefix + "first_vvd_cd", length));
            String[] preVvdCd = (JSPUtil.getParameter(request, prefix + "pre_vvd_cd", length));
            String[] vndrRmk = (JSPUtil.getParameter(request, prefix + "vndr_rmk", length));
            String[] bkgCtrlPtyCustCntCd = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_cnt_cd", length));
            String[] bkgCtrlPtyCustSeq = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_seq", length));
            String[] bkgCtrlPtyCustNm = (JSPUtil.getParameter(request, prefix + "bkg_ctrl_pty_cust_nm", length));
            String[] bkgWtChkFlg = (JSPUtil.getParameter(request, prefix + "bkg_wt_chk_flg", length));
            String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix + "xter_rqst_seq", length));
            String[] irrBlNoFlg = (JSPUtil.getParameter(request, prefix + "irr_bl_no_flg", length));
            String[] bkgTyFlg = (JSPUtil.getParameter(request, prefix + "bkg_ty_flg", length));
            String[] xterVgmRqstCd = (JSPUtil.getParameter(request, prefix + "xter_vgm_rqst_cd", length));
            String[] bkgPtyCntCd = (JSPUtil.getParameter(request, prefix + "bkg_pty_cnt_cd", length));
            String[] bkgPtyCustSeq = (JSPUtil.getParameter(request, prefix + "bkg_pty_cust_seq", length));
            String[] bkgPtyCustNm = (JSPUtil.getParameter(request, prefix + "bkg_pty_cust_nm", length));
            String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
            String[] lstSavDt = (JSPUtil.getParameter(request, prefix + "lst_sav_dt", length));
            String[] modifyCargoFlg = (JSPUtil.getParameter(request, prefix + "modify_cargo_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BkgBookingInfoVO();
                if (bkgDelYdCd[i] != null)
                    model.setBkgDelYdCd(bkgDelYdCd[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (awkCgoFlgOld[i] != null)
                    model.setAwkCgoFlgOld(awkCgoFlgOld[i]);
                if (orgTrnsModCd[i] != null)
                    model.setOrgTrnsModCd(orgTrnsModCd[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (taaAvailable[i] != null)
                    model.setTaaAvailable(taaAvailable[i]);
                if (mtyPkupYdCd[i] != null)
                    model.setMtyPkupYdCd(mtyPkupYdCd[i]);
                if (polYdCdOld[i] != null)
                    model.setPolYdCdOld(polYdCdOld[i]);
                if (cmdtCdOld[i] != null)
                    model.setCmdtCdOld(cmdtCdOld[i]);
                if (bkgCntcPsonFaxNo[i] != null)
                    model.setBkgCntcPsonFaxNo(bkgCntcPsonFaxNo[i]);
                if (mtyPkupDtOld[i] != null)
                    model.setMtyPkupDtOld(mtyPkupDtOld[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (obSrepCd[i] != null)
                    model.setObSrepCd(obSrepCd[i]);
                if (destTrnsSvcModCd[i] != null)
                    model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
                if (bkgPodCd[i] != null)
                    model.setBkgPodCd(bkgPodCd[i]);
                if (fnlDestNm[i] != null)
                    model.setFnlDestNm(fnlDestNm[i]);
                if (porCdOld[i] != null)
                    model.setPorCdOld(porCdOld[i]);
                if (oldBkgNo[i] != null)
                    model.setOldBkgNo(oldBkgNo[i]);
                if (ctrtOfcCd[i] != null)
                    model.setCtrtOfcCd(ctrtOfcCd[i]);
                if (refFlg[i] != null)
                    model.setRefFlg(refFlg[i]);
                if (bbFlg[i] != null)
                    model.setBbFlg(bbFlg[i]);
                if (stwgRmk[i] != null)
                    model.setStwgRmk(stwgRmk[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (podCdOld[i] != null)
                    model.setPodCdOld(podCdOld[i]);
                if (siFlg[i] != null)
                    model.setSiFlg(siFlg[i]);
                if (updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if (bkgOfcCd[i] != null)
                    model.setBkgOfcCd(bkgOfcCd[i]);
                if (mnlBkgNoFlg[i] != null)
                    model.setMnlBkgNoFlg(mnlBkgNoFlg[i]);
                if (xterSiRefNo[i] != null)
                    model.setXterSiRefNo(xterSiRefNo[i]);
                if (orgScontiCd[i] != null)
                    model.setOrgScontiCd(orgScontiCd[i]);
                if (bkgCntcPsonEml[i] != null)
                    model.setBkgCntcPsonEml(bkgCntcPsonEml[i]);
                if (fullRtnYdCd[i] != null)
                    model.setFullRtnYdCd(fullRtnYdCd[i]);
                if (dcgoFlgOld[i] != null)
                    model.setDcgoFlgOld(dcgoFlgOld[i]);
                if (mtyDorArrDtOld[i] != null)
                    model.setMtyDorArrDtOld(mtyDorArrDtOld[i]);
                if (deDueDt[i] != null)
                    model.setDeDueDt(deDueDt[i]);
                if (lodgDueDt[i] != null)
                    model.setLodgDueDt(lodgDueDt[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ediHldFlg[i] != null)
                    model.setEdiHldFlg(ediHldFlg[i]);
                if (cmdtDesc[i] != null)
                    model.setCmdtDesc(cmdtDesc[i]);
                if (spclHideFlg[i] != null)
                    model.setSpclHideFlg(spclHideFlg[i]);
                if (ctrtSrepCd[i] != null)
                    model.setCtrtSrepCd(ctrtSrepCd[i]);
                if (awkFlg[i] != null)
                    model.setAwkFlg(awkFlg[i]);
                if (siCntcPsonFaxNo[i] != null)
                    model.setSiCntcPsonFaxNo(siCntcPsonFaxNo[i]);
                if (stwgFlg[i] != null)
                    model.setStwgFlg(stwgFlg[i]);
                if (partialVvdAssignFlg[i] != null)
                    model.setPartialVvdAssignFlg(partialVvdAssignFlg[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (preRlyPortYdCd[i] != null)
                    model.setPreRlyPortYdCd(preRlyPortYdCd[i]);
                if (bkgPolYdCd[i] != null)
                    model.setBkgPolYdCd(bkgPolYdCd[i]);
                if (splitRsnCd[i] != null)
                    model.setSplitRsnCd(splitRsnCd[i]);
                if (waitRsn[i] != null)
                    model.setWaitRsn(waitRsn[i]);
                if (destTrnsModCd[i] != null)
                    model.setDestTrnsModCd(destTrnsModCd[i]);
                if (siCntcPsonPhnNo[i] != null)
                    model.setSiCntcPsonPhnNo(siCntcPsonPhnNo[i]);
                if (rfFlg[i] != null)
                    model.setRfFlg(rfFlg[i]);
                if (lodgDueDtOld[i] != null)
                    model.setLodgDueDtOld(lodgDueDtOld[i]);
                if (stopOffLocCd[i] != null)
                    model.setStopOffLocCd(stopOffLocCd[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (bkgStsCd[i] != null)
                    model.setBkgStsCd(bkgStsCd[i]);
                if (fdGrdFlg[i] != null)
                    model.setFdGrdFlg(fdGrdFlg[i]);
                if (interRmk[i] != null)
                    model.setInterRmk(interRmk[i]);
                if (scacCd[i] != null)
                    model.setScacCd(scacCd[i]);
                if (cmdtCd[i] != null)
                    model.setCmdtCd(cmdtCd[i]);
                if (fullPkupYdCd[i] != null)
                    model.setFullPkupYdCd(fullPkupYdCd[i]);
                if (rcvTermCdOld[i] != null)
                    model.setRcvTermCdOld(rcvTermCdOld[i]);
                if (isRatedFlg[i] != null)
                    model.setIsRatedFlg(isRatedFlg[i]);
                if (mtyPkupYdCdOld[i] != null)
                    model.setMtyPkupYdCdOld(mtyPkupYdCdOld[i]);
                if (stopOffCntcPsonNm[i] != null)
                    model.setStopOffCntcPsonNm(stopOffCntcPsonNm[i]);
                if (podNm[i] != null)
                    model.setPodNm(podNm[i]);
                if (stopOffFlg[i] != null)
                    model.setStopOffFlg(stopOffFlg[i]);
                if (bkgPodYdCd[i] != null)
                    model.setBkgPodYdCd(bkgPodYdCd[i]);
                if (delNm[i] != null)
                    model.setDelNm(delNm[i]);
                if (porYdCdOld[i] != null)
                    model.setPorYdCdOld(porYdCdOld[i]);
                if (filerCd[i] != null)
                    model.setFilerCd(filerCd[i]);
                if (xterRqstAutoNtcFlg[i] != null)
                    model.setXterRqstAutoNtcFlg(xterRqstAutoNtcFlg[i]);
                if (destScontiCd[i] != null)
                    model.setDestScontiCd(destScontiCd[i]);
                if (mtyDorArrDt[i] != null)
                    model.setMtyDorArrDt(mtyDorArrDt[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (polCdOld[i] != null)
                    model.setPolCdOld(polCdOld[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (taaNo[i] != null)
                    model.setTaaNo(taaNo[i]);
                if (siCntcPsonMphnNo[i] != null)
                    model.setSiCntcPsonMphnNo(siCntcPsonMphnNo[i]);
                if (flexHgtFlg[i] != null)
                    model.setFlexHgtFlg(flexHgtFlg[i]);
                if (cntrFlg[i] != null)
                    model.setCntrFlg(cntrFlg[i]);
                if (lastVvdCd[i] != null)
                    model.setLastVvdCd(lastVvdCd[i]);
                if (repCmdtCd[i] != null)
                    model.setRepCmdtCd(repCmdtCd[i]);
                if (rejectFlag[i] != null)
                    model.setRejectFlag(rejectFlag[i]);
                if (firstPolCd[i] != null)
                    model.setFirstPolCd(firstPolCd[i]);
                if (bkgCntcPsonPhnNo[i] != null)
                    model.setBkgCntcPsonPhnNo(bkgCntcPsonPhnNo[i]);
                if (ocpCd[i] != null)
                    model.setOcpCd(ocpCd[i]);
                if (polNm[i] != null)
                    model.setPolNm(polNm[i]);
                if (caUser[i] != null)
                    model.setCaUser(caUser[i]);
                if (blckStwgCd[i] != null)
                    model.setBlckStwgCd(blckStwgCd[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (bkgTrunkVvd[i] != null)
                    model.setBkgTrunkVvd(bkgTrunkVvd[i]);
                if (pctlNo[i] != null)
                    model.setPctlNo(pctlNo[i]);
                if (podYdCdOld[i] != null)
                    model.setPodYdCdOld(podYdCdOld[i]);
                if (rollOvrCnt[i] != null)
                    model.setRollOvrCnt(rollOvrCnt[i]);
                if (scNo[i] != null)
                    model.setScNo(scNo[i]);
                if (prctFlg[i] != null)
                    model.setPrctFlg(prctFlg[i]);
                if (taaNoOld[i] != null)
                    model.setTaaNoOld(taaNoOld[i]);
                if (wgtUtCd[i] != null)
                    model.setWgtUtCd(wgtUtCd[i]);
                if (rfaNoOld[i] != null)
                    model.setRfaNoOld(rfaNoOld[i]);
                if (usrEml[i] != null)
                    model.setUsrEml(usrEml[i]);
                if (obSlsOfcCd[i] != null)
                    model.setObSlsOfcCd(obSlsOfcCd[i]);
                if (xterSiCd[i] != null)
                    model.setXterSiCd(xterSiCd[i]);
                if (mtyPkupDt[i] != null)
                    model.setMtyPkupDt(mtyPkupDt[i]);
                if (cndCstmsFileCd[i] != null)
                    model.setCndCstmsFileCd(cndCstmsFileCd[i]);
                if (xterBkgRqstCd[i] != null)
                    model.setXterBkgRqstCd(xterBkgRqstCd[i]);
                if (bkgPorCd[i] != null)
                    model.setBkgPorCd(bkgPorCd[i]);
                if (lastPodCd[i] != null)
                    model.setLastPodCd(lastPodCd[i]);
                if (preRlyPortCd[i] != null)
                    model.setPreRlyPortCd(preRlyPortCd[i]);
                if (bbCgoFlgOld[i] != null)
                    model.setBbCgoFlgOld(bbCgoFlgOld[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (stopOffCntcPhnNo[i] != null)
                    model.setStopOffCntcPhnNo(stopOffCntcPhnNo[i]);
                if (pstVvdCd[i] != null)
                    model.setPstVvdCd(pstVvdCd[i]);
                if (creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if (porNm[i] != null)
                    model.setPorNm(porNm[i]);
                if (rfaAvailable[i] != null)
                    model.setRfaAvailable(rfaAvailable[i]);
                if (xterRmk[i] != null)
                    model.setXterRmk(xterRmk[i]);
                if (xterBkgRqstRefNo[i] != null)
                    model.setXterBkgRqstRefNo(xterBkgRqstRefNo[i]);
                if (pstRlyPortCd[i] != null)
                    model.setPstRlyPortCd(pstRlyPortCd[i]);
                if (splitFlg[i] != null)
                    model.setSplitFlg(splitFlg[i]);
                if (fullRtnYdCdOld[i] != null)
                    model.setFullRtnYdCdOld(fullRtnYdCdOld[i]);
                if (xtnPhnNo[i] != null)
                    model.setXtnPhnNo(xtnPhnNo[i]);
                if (docUsrId[i] != null)
                    model.setDocUsrId(docUsrId[i]);
                if (orgTrnsSvcModCd[i] != null)
                    model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
                if (pstRlyPortYdCd[i] != null)
                    model.setPstRlyPortYdCd(pstRlyPortYdCd[i]);
                if (scNoOld[i] != null)
                    model.setScNoOld(scNoOld[i]);
                if (bdrFlg[i] != null)
                    model.setBdrFlg(bdrFlg[i]);
                if (siCntcPsonEml[i] != null)
                    model.setSiCntcPsonEml(siCntcPsonEml[i]);
                if (rcFlgOld[i] != null)
                    model.setRcFlgOld(rcFlgOld[i]);
                if (bkgCntcPsonNm[i] != null)
                    model.setBkgCntcPsonNm(bkgCntcPsonNm[i]);
                if (stopOffDiffRmk[i] != null)
                    model.setStopOffDiffRmk(stopOffDiffRmk[i]);
                if (advShtgCd[i] != null)
                    model.setAdvShtgCd(advShtgCd[i]);
                if (hotDeFlg[i] != null)
                    model.setHotDeFlg(hotDeFlg[i]);
                if (eqSubstFlg[i] != null)
                    model.setEqSubstFlg(eqSubstFlg[i]);
                if (vvdFlag[i] != null)
                    model.setVvdFlag(vvdFlag[i]);
                if (revDirCd[i] != null)
                    model.setRevDirCd(revDirCd[i]);
                if (rfaNo[i] != null)
                    model.setRfaNo(rfaNo[i]);
                if (fmcNo[i] != null)
                    model.setFmcNo(fmcNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (railBlkCd[i] != null)
                    model.setRailBlkCd(railBlkCd[i]);
                if (usrNm[i] != null)
                    model.setUsrNm(usrNm[i]);
                if (bkgDelCd[i] != null)
                    model.setBkgDelCd(bkgDelCd[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (caFlg[i] != null)
                    model.setCaFlg(caFlg[i]);
                if (bkgCntcPsonMphnNo[i] != null)
                    model.setBkgCntcPsonMphnNo(bkgCntcPsonMphnNo[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (siCntcPsonNm[i] != null)
                    model.setSiCntcPsonNm(siCntcPsonNm[i]);
                if (bkgPolCd[i] != null)
                    model.setBkgPolCd(bkgPolCd[i]);
                if (deTermCdOld[i] != null)
                    model.setDeTermCdOld(deTermCdOld[i]);
                if (scAvailable[i] != null)
                    model.setScAvailable(scAvailable[i]);
                if (delYdCdOld[i] != null)
                    model.setDelYdCdOld(delYdCdOld[i]);
                if (lastPodClptIndSeq[i] != null)
                    model.setLastPodClptIndSeq(lastPodClptIndSeq[i]);
                if (premiumAvailableFlg[i] != null)
                    model.setPremiumAvailableFlg(premiumAvailableFlg[i]);
                if (twnSoNo[i] != null)
                    model.setTwnSoNo(twnSoNo[i]);
                if (deDueDtOld[i] != null)
                    model.setDeDueDtOld(deDueDtOld[i]);
                if (bkgTrunkVvdOld[i] != null)
                    model.setBkgTrunkVvdOld(bkgTrunkVvdOld[i]);
                if (usaCstmsFileCd[i] != null)
                    model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
                if (actWgt[i] != null)
                    model.setActWgt(actWgt[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (dgFlg[i] != null)
                    model.setDgFlg(dgFlg[i]);
                if (firstPolClptIndSeq[i] != null)
                    model.setFirstPolClptIndSeq(firstPolClptIndSeq[i]);
                if (bkgPorYdCd[i] != null)
                    model.setBkgPorYdCd(bkgPorYdCd[i]);
                if (delCdOld[i] != null)
                    model.setDelCdOld(delCdOld[i]);
                if (hngrFlg[i] != null)
                    model.setHngrFlg(hngrFlg[i]);
                if (mtyRtnYdCd[i] != null)
                    model.setMtyRtnYdCd(mtyRtnYdCd[i]);
                if (firstVvdCd[i] != null)
                    model.setFirstVvdCd(firstVvdCd[i]);
                if (preVvdCd[i] != null)
                    model.setPreVvdCd(preVvdCd[i]);
                if (vndrRmk[i] != null)
                    model.setVndrRmk(vndrRmk[i]);
                if (bkgCtrlPtyCustCntCd[i] != null)
                    model.setBkgCtrlPtyCustCntCd(bkgCtrlPtyCustCntCd[i]);
                if (bkgCtrlPtyCustSeq[i] != null)
                    model.setBkgCtrlPtyCustSeq(bkgCtrlPtyCustSeq[i]);
                if (bkgCtrlPtyCustNm[i] != null)
                    model.setBkgCtrlPtyCustNm(bkgCtrlPtyCustNm[i]);
                if (bkgWtChkFlg[i] != null)
                    model.setBkgWtChkFlg(bkgWtChkFlg[i]);
                if (xterRqstSeq[i] != null)
                    model.setXterRqstSeq(xterRqstSeq[i]);
                if (irrBlNoFlg[i] != null)
                    model.setIrrBlNoFlg(irrBlNoFlg[i]);
                if (bkgTyFlg[i] != null)
                    model.setBkgTyFlg(bkgTyFlg[i]);
                if (xterVgmRqstCd[i] != null)
                    model.setXterVgmRqstCd(xterVgmRqstCd[i]);
                if (bkgPtyCntCd[i] != null)
                    model.setBkgPtyCntCd(bkgPtyCntCd[i]);
                if (bkgPtyCustSeq[i] != null)
                    model.setBkgPtyCustSeq(bkgPtyCustSeq[i]);
                if (bkgPtyCustNm[i] != null)
                    model.setBkgPtyCustNm(bkgPtyCustNm[i]);
                if (updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if (lstSavDt[i] != null)
                    model.setLstSavDt(lstSavDt[i]);
                if (modifyCargoFlg[i] != null) 
		    		model.setModifyCargoFlg(modifyCargoFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBkgBookingInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BkgBookingInfoVO[]
	 */
    public BkgBookingInfoVO[] getBkgBookingInfoVOs() {
        BkgBookingInfoVO[] vos = (BkgBookingInfoVO[]) models.toArray(new BkgBookingInfoVO[models.size()]);
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
        this.bkgDelYdCd = this.bkgDelYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlgOld = this.awkCgoFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrnsModCd = this.orgTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaAvailable = this.taaAvailable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCd = this.mtyPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCdOld = this.polYdCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCdOld = this.cmdtCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonFaxNo = this.bkgCntcPsonFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupDtOld = this.mtyPkupDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSrepCd = this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destTrnsSvcModCd = this.destTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPodCd = this.bkgPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlDestNm = this.fnlDestNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCdOld = this.porCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oldBkgNo = this.oldBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtOfcCd = this.ctrtOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.refFlg = this.refFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbFlg = this.bbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgRmk = this.stwgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCdOld = this.podCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siFlg = this.siFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgOfcCd = this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mnlBkgNoFlg = this.mnlBkgNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSiRefNo = this.xterSiRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgScontiCd = this.orgScontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonEml = this.bkgCntcPsonEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullRtnYdCd = this.fullRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlgOld = this.dcgoFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyDorArrDtOld = this.mtyDorArrDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deDueDt = this.deDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lodgDueDt = this.lodgDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ediHldFlg = this.ediHldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtDesc = this.cmdtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclHideFlg = this.spclHideFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtSrepCd = this.ctrtSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkFlg = this.awkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonFaxNo = this.siCntcPsonFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgFlg = this.stwgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.partialVvdAssignFlg = this.partialVvdAssignFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preRlyPortYdCd = this.preRlyPortYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPolYdCd = this.bkgPolYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitRsnCd = this.splitRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.waitRsn = this.waitRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destTrnsModCd = this.destTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonPhnNo = this.siCntcPsonPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfFlg = this.rfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lodgDueDtOld = this.lodgDueDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stopOffLocCd = this.stopOffLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgStsCd = this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fdGrdFlg = this.fdGrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scacCd = this.scacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullPkupYdCd = this.fullPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCdOld = this.rcvTermCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.isRatedFlg = this.isRatedFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupYdCdOld = this.mtyPkupYdCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stopOffCntcPsonNm = this.stopOffCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNm = this.podNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stopOffFlg = this.stopOffFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPodYdCd = this.bkgPodYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNm = this.delNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porYdCdOld = this.porYdCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.filerCd = this.filerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstAutoNtcFlg = this.xterRqstAutoNtcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destScontiCd = this.destScontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyDorArrDt = this.mtyDorArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCdOld = this.polCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNo = this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonMphnNo = this.siCntcPsonMphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flexHgtFlg = this.flexHgtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrFlg = this.cntrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastVvdCd = this.lastVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.repCmdtCd = this.repCmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rejectFlag = this.rejectFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstPolCd = this.firstPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonPhnNo = this.bkgCntcPsonPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ocpCd = this.ocpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNm = this.polNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caUser = this.caUser.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTrunkVvd = this.bkgTrunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCdOld = this.podYdCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rollOvrCnt = this.rollOvrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prctFlg = this.prctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taaNoOld = this.taaNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.wgtUtCd = this.wgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNoOld = this.rfaNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrEml = this.usrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.obSlsOfcCd = this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterSiCd = this.xterSiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyPkupDt = this.mtyPkupDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cndCstmsFileCd = this.cndCstmsFileCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstCd = this.xterBkgRqstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPorCd = this.bkgPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastPodCd = this.lastPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preRlyPortCd = this.preRlyPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlgOld = this.bbCgoFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stopOffCntcPhnNo = this.stopOffCntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pstVvdCd = this.pstVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNm = this.porNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaAvailable = this.rfaAvailable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRmk = this.xterRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterBkgRqstRefNo = this.xterBkgRqstRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pstRlyPortCd = this.pstRlyPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.splitFlg = this.splitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fullRtnYdCdOld = this.fullRtnYdCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xtnPhnNo = this.xtnPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.docUsrId = this.docUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrnsSvcModCd = this.orgTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pstRlyPortYdCd = this.pstRlyPortYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scNoOld = this.scNoOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bdrFlg = this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonEml = this.siCntcPsonEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlgOld = this.rcFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonNm = this.bkgCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stopOffDiffRmk = this.stopOffDiffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.advShtgCd = this.advShtgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hotDeFlg = this.hotDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstFlg = this.eqSubstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdFlag = this.vvdFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.revDirCd = this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rfaNo = this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fmcNo = this.fmcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.railBlkCd = this.railBlkCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrNm = this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgDelCd = this.bkgDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.caFlg = this.caFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCntcPsonMphnNo = this.bkgCntcPsonMphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.siCntcPsonNm = this.siCntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPolCd = this.bkgPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCdOld = this.deTermCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.scAvailable = this.scAvailable.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delYdCdOld = this.delYdCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastPodClptIndSeq = this.lastPodClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.premiumAvailableFlg = this.premiumAvailableFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.twnSoNo = this.twnSoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deDueDtOld = this.deDueDtOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTrunkVvdOld = this.bkgTrunkVvdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usaCstmsFileCd = this.usaCstmsFileCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.actWgt = this.actWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dgFlg = this.dgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstPolClptIndSeq = this.firstPolClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPorYdCd = this.bkgPorYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCdOld = this.delCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.mtyRtnYdCd = this.mtyRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.firstVvdCd = this.firstVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVvdCd = this.preVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrRmk = this.vndrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustCntCd = this.bkgCtrlPtyCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustSeq = this.bkgCtrlPtyCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCtrlPtyCustNm = this.bkgCtrlPtyCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgWtChkFlg = this.bkgWtChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterRqstSeq = this.xterRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.irrBlNoFlg = this.irrBlNoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgTyFlg = this.bkgTyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.xterVgmRqstCd = this.xterVgmRqstCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPtyCntCd = this.bkgPtyCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPtyCustSeq = this.bkgPtyCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgPtyCustNm = this.bkgPtyCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lstSavDt = this.lstSavDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.modifyCargoFlg = this.modifyCargoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
