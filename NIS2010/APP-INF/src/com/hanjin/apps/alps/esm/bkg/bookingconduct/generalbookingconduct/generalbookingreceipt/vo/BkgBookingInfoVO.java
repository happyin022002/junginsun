/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgBookingInfoVO.java
*@FileTitle : BkgBookingInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgBookingInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgBookingInfoVO> models = new ArrayList<BkgBookingInfoVO>();
	
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String taaAvailable = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String agmtActCntCd = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String oldBkgNo = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String blFntOfcFlg = null;
	/* Column Info */
	private String newCustAproMarkFlg = null;
	/* Column Info */
	private String xterSiRefNo = null;
	/* Column Info */
	private String dcgoFlgOld = null;
	/* Column Info */
	private String mtyDorArrDtOld = null;
	/* Column Info */
	private String lodgDueDt = null;
	/* Column Info */
	private String ediHldFlg = null;
	/* Column Info */
	private String awkFlg = null;
	/* Column Info */
	private String spclHideFlg = null;
	/* Column Info */
	private String partialVvdAssignFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String preRlyPortYdCd = null;
	/* Column Info */
	private String bkgPolYdCd = null;
	/* Column Info */
	private String waitRsn = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* Column Info */
	private String siCntcPsonPhnNo = null;
	/* Column Info */
	private String lodgDueDtOld = null;
	/* Column Info */
	private String stopOffLocCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String fdGrdFlg = null;
	/* Column Info */
	private String spclHideLnrFlg = null;
	/* Column Info */
	private String returnCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String newCustAproRmk = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String stopOffCntcPsonNm = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String porYdCdOld = null;
	/* Column Info */
	private String mtyDorArrDt = null;
	/* Column Info */
	private String polCdOld = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String pctlNoOld = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String firstPolCd = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String bkgCntcPsonPhnNo = null;
	/* Column Info */
	private String ocpCd = null;
	/* Column Info */
	private String caUser = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String vehCmdtFlg = null;
	/* Column Info */
	private String fumgLocCd = null;
	/* Column Info */
	private String eurTroCfm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rollOvrCnt = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String taaNoOld = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String rfaNoOld = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String xterSiCd = null;
	/* Column Info */
	private String mtyPkupDt = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String bbCgoFlgOld = null;
	/* Column Info */
	private String pstVvdCd = null;
	/* Column Info */
	private String indivPsonFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fumgCntcPhnNo = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String fullRtnYdCdOld = null;
	/* Column Info */
	private String xtnPhnNo = null;
	/* Column Info */
	private String mnlCctFlg = null;
	/* Column Info */
	private String siCntcPsonEml = null;
	/* Column Info */
	private String stopOffDiffRmk = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String blDrftFaxOutFlg = null;
	/* Column Info */
	private String idaHlgTpCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String deTermCdOld = null;
	/* Column Info */
	private String fumgDiffRmk = null;
	/* Column Info */
	private String delYdCdOld = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgPorYdCd = null;
	/* Column Info */
	private String firstPolClptIndSeq = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	/* Column Info */
	private String firstVvdCd = null;
	/* Column Info */
	private String tvvdModifyFlg = null;
	/* Column Info */
	private String bkgDelYdCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String awkCgoFlgOld = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String blRtFlg = null;
	/* Column Info */
	private String cmdtCdOld = null;
	/* Column Info */
	private String polYdCdOld = null;
	/* Column Info */
	private String bkgCntcPsonFaxNo = null;
	/* Column Info */
	private String mtyPkupDtOld = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String fnlDestNm = null;
	/* Column Info */
	private String porCdOld = null;
	/* Column Info */
	private String bbFlg = null;
	/* Column Info */
	private String refFlg = null;
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
	private String mnlBkgNoFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String orgScontiCd = null;
	/* Column Info */
	private String agmtActCustSeq = null;
	/* Column Info */
	private String bkgCntcPsonEml = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String deDueDt = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String siCntcPsonFaxNo = null;
	/* Column Info */
	private String stwgFlg = null;
	/* Column Info */
	private String splitRsnCd = null;
	/* Column Info */
	private String newCustAproCmdtNm = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String portSkpFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String webSvcFlg = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String rcvTermCdOld = null;
	/* Column Info */
	private String fullPkupYdCd = null;
	/* Column Info */
	private String isRatedFlg = null;
	/* Column Info */
	private String mtyPkupYdCdOld = null;
	/* Column Info */
	private String actCustListExistFlg = null;
	/* Column Info */
	private String stopOffFlg = null;
	/* Column Info */
	private String bkgPodYdCd = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String filerCd = null;
	/* Column Info */
	private String xterRqstAutoNtcFlg = null;
	/* Column Info */
	private String destScontiCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String siCntcPsonMphnNo = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String cntrFlg = null;
	/* Column Info */
	private String lastVvdCd = null;
	/* Column Info */
	private String rejectFlag = null;
	/* Column Info */
	private String blAudFlg = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String bkgTrunkVvd = null;
	/* Column Info */
	private String podYdCdOld = null;
	/* Column Info */
	private String nonDgChemFlg = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String xterBkgRqstCd = null;
	/* Column Info */
	private String blDocInpFlg = null;
	/* Column Info */
	private String lastPodCd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String stopOffCntcPhnNo = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String rfaAvailable = null;
	/* Column Info */
	private String fumgCntcPsonNm = null;
	/* Column Info */
	private String xterBkgRqstRefNo = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String orgTrnsSvcModCd = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String pstRlyPortYdCd = null;
	/* Column Info */
	private String scNoOld = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String rcFlgOld = null;
	/* Column Info */
	private String bkgCntcPsonNm = null;
	/* Column Info */
	private String advShtgCd = null;
	/* Column Info */
	private String hotDeFlg = null;
	/* Column Info */
	private String eqSubstFlg = null;
	/* Column Info */
	private String vvdFlag = null;
	/* Column Info */
	private String fumgFlg = null;
	/* Column Info */
	private String fmcNo = null;
	/* Column Info */
	private String railBlkCd = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String krCstmsCustTpCd = null;
	/* Column Info */
	private String bkgCntcPsonMphnNo = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String siCntcPsonNm = null;
	/* Column Info */
	private String scAvailable = null;
	/* Column Info */
	private String premiumAvailableFlg = null;
	/* Column Info */
	private String lastPodClptIndSeq = null;
	/* Column Info */
	private String twnSoNo = null;
	/* Column Info */
	private String bkgTrunkVvdOld = null;
	/* Column Info */
	private String deDueDtOld = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String newCustAproFlg = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String nonRtStsCd = null;
	/* Column Info */
	private String delCdOld = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String preVvdCd = null;
	/* Column Info */
	private String prgFlg = null;
	/* Column Info */
	private String crrSocFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgBookingInfoVO() {}

	public BkgBookingInfoVO(String ibflag, String pagerows, String bkgNo, String oldBkgNo, String mnlBkgNoFlg, String splitFlg, String splitRsnCd, String advShtgCd, String ediHldFlg, String blNo, String siFlg, String bdrFlg, String caFlg, String caUser, String bkgStsCd, String waitRsn, String alocStsCd, String bkgAlocTpCd, String newCustAproFlg, String newCustAproCmdtNm, String newCustAproRmk, String newCustAproMarkFlg, String indivPsonFlg, String prgFlg, String nonRtStsCd, String idaHlgTpCd, String slanCd, String svcScpCd, String bkgTrunkVvd, String bkgTrunkVvdOld, String bkgPorCd, String porCdOld, String porNm, String bkgPorYdCd, String porYdCdOld, String bkgPolCd, String polCdOld, String polNm, String bkgPolYdCd, String polYdCdOld, String bkgPodCd, String podCdOld, String podNm, String bkgPodYdCd, String podYdCdOld, String bkgDelCd, String delCdOld, String delNm, String bkgDelYdCd, String delYdCdOld, String fnlDestNm, String ocpCd, String rcvTermCd, String rcvTermCdOld, String deTermCd, String deTermCdOld, String preRlyPortCd, String preRlyPortYdCd, String preVvdCd, String pstRlyPortCd, String pstRlyPortYdCd, String pstVvdCd, String sCustCntCd, String sCustSeq, String pctlNo, String pctlNoOld, String usaCstmsFileCd, String cndCstmsFileCd, String scacCd, String krCstmsCustTpCd, String rfaNo, String rfaNoOld, String rfaAvailable, String scNo, String scNoOld, String scAvailable, String taaNo, String taaNoOld, String taaAvailable, String ctrtOfcCd, String ctrtSrepCd, String actWgt, String wgtUtCd, String cmdtCd, String cmdtCdOld, String repCmdtCd, String cmdtDesc, String blDocInpFlg, String blRtFlg, String blAudFlg, String blDrftFaxOutFlg, String returnCd, String blFntOfcFlg, String flexHgtFlg, String dcgoFlg, String dcgoFlgOld, String rcFlg, String rcFlgOld, String awkCgoFlg, String awkCgoFlgOld, String bbCgoFlg, String bbCgoFlgOld, String rdCgoFlg, String socFlg, String eqSubstFlg, String rejectFlag, String portSkpFlg, String dgFlg, String rfFlg, String awkFlg, String bbFlg, String stwgFlg, String stwgCd, String stwgRmk, String hngrFlg, String stopOffFlg, String stopOffLocCd, String stopOffCntcPsonNm, String stopOffCntcPhnNo, String stopOffDiffRmk, String fumgFlg, String fumgLocCd, String fumgCntcPsonNm, String fumgCntcPhnNo, String fumgDiffRmk, String railBlkCd, String spclHideFlg, String spclHideLnrFlg, String fdGrdFlg, String prctFlg, String vehCmdtFlg, String twnSoNo, String bkgCgoTpCd, String crrSocFlg, String nonDgChemFlg, String mtyDorArrDt, String mtyDorArrDtOld, String lodgDueDt, String lodgDueDtOld, String deDueDt, String deDueDtOld, String mtyPkupYdCd, String mtyPkupYdCdOld, String mtyPkupDt, String mtyPkupDtOld, String fullRtnYdCd, String fullRtnYdCdOld, String mtyRtnYdCd, String fullPkupYdCd, String partialVvdAssignFlg, String cntrFlg, String orgScontiCd, String destScontiCd, String orgTrnsSvcModCd, String destTrnsSvcModCd, String orgTrnsModCd, String destTrnsModCd, String blckStwgCd, String refFlg, String rollOvrCnt, String obSlsOfcCd, String obSrepCd, String bkgOfcCd, String usrNm, String docUsrId, String ofcCd, String usrEml, String xtnPhnNo, String xterBkgRqstCd, String xterBkgRqstRefNo, String xterSiCd, String xterSiRefNo, String xterRqstAutoNtcFlg, String interRmk, String xterRmk, String mnlCctFlg, String agmtActCntCd, String agmtActCustSeq, String bkgCreDt, String fmcNo, String revDirCd, String firstPolCd, String firstPolClptIndSeq, String firstVvdCd, String lastPodCd, String lastPodClptIndSeq, String lastVvdCd, String creUsrId, String updUsrId, String vvdFlag, String filerCd, String isRatedFlg, String eurTroCfm, String tvvdModifyFlg, String hotDeFlg, String premiumAvailableFlg, String webSvcFlg, String actCustListExistFlg, String bkgCntcPsonNm, String bkgCntcPsonEml, String bkgCntcPsonFaxNo, String bkgCntcPsonMphnNo, String bkgCntcPsonPhnNo, String siCntcPsonNm, String siCntcPsonEml, String siCntcPsonFaxNo, String siCntcPsonMphnNo, String siCntcPsonPhnNo) {
		this.orgTrnsModCd = orgTrnsModCd;
		this.taaAvailable = taaAvailable;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.agmtActCntCd = agmtActCntCd;
		this.alocStsCd = alocStsCd;
		this.pagerows = pagerows;
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.oldBkgNo = oldBkgNo;
		this.bkgCreDt = bkgCreDt;
		this.blFntOfcFlg = blFntOfcFlg;
		this.newCustAproMarkFlg = newCustAproMarkFlg;
		this.xterSiRefNo = xterSiRefNo;
		this.dcgoFlgOld = dcgoFlgOld;
		this.mtyDorArrDtOld = mtyDorArrDtOld;
		this.lodgDueDt = lodgDueDt;
		this.ediHldFlg = ediHldFlg;
		this.awkFlg = awkFlg;
		this.spclHideFlg = spclHideFlg;
		this.partialVvdAssignFlg = partialVvdAssignFlg;
		this.rcFlg = rcFlg;
		this.preRlyPortYdCd = preRlyPortYdCd;
		this.bkgPolYdCd = bkgPolYdCd;
		this.waitRsn = waitRsn;
		this.destTrnsModCd = destTrnsModCd;
		this.siCntcPsonPhnNo = siCntcPsonPhnNo;
		this.lodgDueDtOld = lodgDueDtOld;
		this.stopOffLocCd = stopOffLocCd;
		this.rdCgoFlg = rdCgoFlg;
		this.fdGrdFlg = fdGrdFlg;
		this.spclHideLnrFlg = spclHideLnrFlg;
		this.returnCd = returnCd;
		this.interRmk = interRmk;
		this.newCustAproRmk = newCustAproRmk;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.stopOffCntcPsonNm = stopOffCntcPsonNm;
		this.podNm = podNm;
		this.porYdCdOld = porYdCdOld;
		this.mtyDorArrDt = mtyDorArrDt;
		this.polCdOld = polCdOld;
		this.ofcCd = ofcCd;
		this.taaNo = taaNo;
		this.pctlNoOld = pctlNoOld;
		this.repCmdtCd = repCmdtCd;
		this.firstPolCd = firstPolCd;
		this.sCustSeq = sCustSeq;
		this.bkgCntcPsonPhnNo = bkgCntcPsonPhnNo;
		this.ocpCd = ocpCd;
		this.caUser = caUser;
		this.polNm = polNm;
		this.vehCmdtFlg = vehCmdtFlg;
		this.fumgLocCd = fumgLocCd;
		this.eurTroCfm = eurTroCfm;
		this.scNo = scNo;
		this.rollOvrCnt = rollOvrCnt;
		this.wgtUtCd = wgtUtCd;
		this.taaNoOld = taaNoOld;
		this.prctFlg = prctFlg;
		this.rfaNoOld = rfaNoOld;
		this.obSlsOfcCd = obSlsOfcCd;
		this.xterSiCd = xterSiCd;
		this.mtyPkupDt = mtyPkupDt;
		this.bkgPorCd = bkgPorCd;
		this.bbCgoFlgOld = bbCgoFlgOld;
		this.pstVvdCd = pstVvdCd;
		this.indivPsonFlg = indivPsonFlg;
		this.creUsrId = creUsrId;
		this.fumgCntcPhnNo = fumgCntcPhnNo;
		this.xterRmk = xterRmk;
		this.pstRlyPortCd = pstRlyPortCd;
		this.fullRtnYdCdOld = fullRtnYdCdOld;
		this.xtnPhnNo = xtnPhnNo;
		this.mnlCctFlg = mnlCctFlg;
		this.siCntcPsonEml = siCntcPsonEml;
		this.stopOffDiffRmk = stopOffDiffRmk;
		this.rfaNo = rfaNo;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.caFlg = caFlg;
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
		this.idaHlgTpCd = idaHlgTpCd;
		this.bkgPolCd = bkgPolCd;
		this.deTermCdOld = deTermCdOld;
		this.fumgDiffRmk = fumgDiffRmk;
		this.delYdCdOld = delYdCdOld;
		this.actWgt = actWgt;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.bkgPorYdCd = bkgPorYdCd;
		this.firstPolClptIndSeq = firstPolClptIndSeq;
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.firstVvdCd = firstVvdCd;
		this.tvvdModifyFlg = tvvdModifyFlg;
		this.bkgDelYdCd = bkgDelYdCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.awkCgoFlgOld = awkCgoFlgOld;
		this.svcScpCd = svcScpCd;
		this.blRtFlg = blRtFlg;
		this.cmdtCdOld = cmdtCdOld;
		this.polYdCdOld = polYdCdOld;
		this.bkgCntcPsonFaxNo = bkgCntcPsonFaxNo;
		this.mtyPkupDtOld = mtyPkupDtOld;
		this.obSrepCd = obSrepCd;
		this.bkgPodCd = bkgPodCd;
		this.fnlDestNm = fnlDestNm;
		this.porCdOld = porCdOld;
		this.bbFlg = bbFlg;
		this.refFlg = refFlg;
		this.stwgRmk = stwgRmk;
		this.stwgCd = stwgCd;
		this.podCdOld = podCdOld;
		this.siFlg = siFlg;
		this.updUsrId = updUsrId;
		this.mnlBkgNoFlg = mnlBkgNoFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.orgScontiCd = orgScontiCd;
		this.agmtActCustSeq = agmtActCustSeq;
		this.bkgCntcPsonEml = bkgCntcPsonEml;
		this.fullRtnYdCd = fullRtnYdCd;
		this.bkgNo = bkgNo;
		this.deDueDt = deDueDt;
		this.cmdtDesc = cmdtDesc;
		this.ctrtSrepCd = ctrtSrepCd;
		this.siCntcPsonFaxNo = siCntcPsonFaxNo;
		this.stwgFlg = stwgFlg;
		this.splitRsnCd = splitRsnCd;
		this.newCustAproCmdtNm = newCustAproCmdtNm;
		this.rfFlg = rfFlg;
		this.portSkpFlg = portSkpFlg;
		this.bkgStsCd = bkgStsCd;
		this.webSvcFlg = webSvcFlg;
		this.scacCd = scacCd;
		this.cmdtCd = cmdtCd;
		this.rcvTermCdOld = rcvTermCdOld;
		this.fullPkupYdCd = fullPkupYdCd;
		this.isRatedFlg = isRatedFlg;
		this.mtyPkupYdCdOld = mtyPkupYdCdOld;
		this.actCustListExistFlg = actCustListExistFlg;
		this.stopOffFlg = stopOffFlg;
		this.bkgPodYdCd = bkgPodYdCd;
		this.delNm = delNm;
		this.filerCd = filerCd;
		this.xterRqstAutoNtcFlg = xterRqstAutoNtcFlg;
		this.destScontiCd = destScontiCd;
		this.slanCd = slanCd;
		this.siCntcPsonMphnNo = siCntcPsonMphnNo;
		this.flexHgtFlg = flexHgtFlg;
		this.cntrFlg = cntrFlg;
		this.lastVvdCd = lastVvdCd;
		this.rejectFlag = rejectFlag;
		this.blAudFlg = blAudFlg;
		this.blckStwgCd = blckStwgCd;
		this.blNo = blNo;
		this.pctlNo = pctlNo;
		this.bkgTrunkVvd = bkgTrunkVvd;
		this.podYdCdOld = podYdCdOld;
		this.nonDgChemFlg = nonDgChemFlg;
		this.usrEml = usrEml;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.xterBkgRqstCd = xterBkgRqstCd;
		this.blDocInpFlg = blDocInpFlg;
		this.lastPodCd = lastPodCd;
		this.preRlyPortCd = preRlyPortCd;
		this.awkCgoFlg = awkCgoFlg;
		this.stopOffCntcPhnNo = stopOffCntcPhnNo;
		this.sCustCntCd = sCustCntCd;
		this.porNm = porNm;
		this.rfaAvailable = rfaAvailable;
		this.fumgCntcPsonNm = fumgCntcPsonNm;
		this.xterBkgRqstRefNo = xterBkgRqstRefNo;
		this.splitFlg = splitFlg;
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
		this.docUsrId = docUsrId;
		this.pstRlyPortYdCd = pstRlyPortYdCd;
		this.scNoOld = scNoOld;
		this.bdrFlg = bdrFlg;
		this.rcFlgOld = rcFlgOld;
		this.bkgCntcPsonNm = bkgCntcPsonNm;
		this.advShtgCd = advShtgCd;
		this.hotDeFlg = hotDeFlg;
		this.eqSubstFlg = eqSubstFlg;
		this.vvdFlag = vvdFlag;
		this.fumgFlg = fumgFlg;
		this.fmcNo = fmcNo;
		this.railBlkCd = railBlkCd;
		this.bkgDelCd = bkgDelCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.krCstmsCustTpCd = krCstmsCustTpCd;
		this.bkgCntcPsonMphnNo = bkgCntcPsonMphnNo;
		this.rcvTermCd = rcvTermCd;
		this.siCntcPsonNm = siCntcPsonNm;
		this.scAvailable = scAvailable;
		this.premiumAvailableFlg = premiumAvailableFlg;
		this.lastPodClptIndSeq = lastPodClptIndSeq;
		this.twnSoNo = twnSoNo;
		this.bkgTrunkVvdOld = bkgTrunkVvdOld;
		this.deDueDtOld = deDueDtOld;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.newCustAproFlg = newCustAproFlg;
		this.dgFlg = dgFlg;
		this.nonRtStsCd = nonRtStsCd;
		this.delCdOld = delCdOld;
		this.hngrFlg = hngrFlg;
		this.preVvdCd = preVvdCd;
		this.prgFlg = prgFlg;
		this.crrSocFlg = crrSocFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
		this.hashColumns.put("taa_available", getTaaAvailable());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("old_bkg_no", getOldBkgNo());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("bl_fnt_ofc_flg", getBlFntOfcFlg());
		this.hashColumns.put("new_cust_apro_mark_flg", getNewCustAproMarkFlg());
		this.hashColumns.put("xter_si_ref_no", getXterSiRefNo());
		this.hashColumns.put("dcgo_flg_old", getDcgoFlgOld());
		this.hashColumns.put("mty_dor_arr_dt_old", getMtyDorArrDtOld());
		this.hashColumns.put("lodg_due_dt", getLodgDueDt());
		this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
		this.hashColumns.put("awk_flg", getAwkFlg());
		this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
		this.hashColumns.put("partial_vvd_assign_flg", getPartialVvdAssignFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("pre_rly_port_yd_cd", getPreRlyPortYdCd());
		this.hashColumns.put("bkg_pol_yd_cd", getBkgPolYdCd());
		this.hashColumns.put("wait_rsn", getWaitRsn());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		this.hashColumns.put("si_cntc_pson_phn_no", getSiCntcPsonPhnNo());
		this.hashColumns.put("lodg_due_dt_old", getLodgDueDtOld());
		this.hashColumns.put("stop_off_loc_cd", getStopOffLocCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
		this.hashColumns.put("spcl_hide_lnr_flg", getSpclHideLnrFlg());
		this.hashColumns.put("return_cd", getReturnCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("new_cust_apro_rmk", getNewCustAproRmk());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("stop_off_cntc_pson_nm", getStopOffCntcPsonNm());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("por_yd_cd_old", getPorYdCdOld());
		this.hashColumns.put("mty_dor_arr_dt", getMtyDorArrDt());
		this.hashColumns.put("pol_cd_old", getPolCdOld());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("pctl_no_old", getPctlNoOld());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("first_pol_cd", getFirstPolCd());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("bkg_cntc_pson_phn_no", getBkgCntcPsonPhnNo());
		this.hashColumns.put("ocp_cd", getOcpCd());
		this.hashColumns.put("ca_user", getCaUser());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("veh_cmdt_flg", getVehCmdtFlg());
		this.hashColumns.put("fumg_loc_cd", getFumgLocCd());
		this.hashColumns.put("eur_tro_cfm", getEurTroCfm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("roll_ovr_cnt", getRollOvrCnt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("taa_no_old", getTaaNoOld());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("rfa_no_old", getRfaNoOld());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("xter_si_cd", getXterSiCd());
		this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("bb_cgo_flg_old", getBbCgoFlgOld());
		this.hashColumns.put("pst_vvd_cd", getPstVvdCd());
		this.hashColumns.put("indiv_pson_flg", getIndivPsonFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fumg_cntc_phn_no", getFumgCntcPhnNo());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("full_rtn_yd_cd_old", getFullRtnYdCdOld());
		this.hashColumns.put("xtn_phn_no", getXtnPhnNo());
		this.hashColumns.put("mnl_cct_flg", getMnlCctFlg());
		this.hashColumns.put("si_cntc_pson_eml", getSiCntcPsonEml());
		this.hashColumns.put("stop_off_diff_rmk", getStopOffDiffRmk());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("bl_drft_fax_out_flg", getBlDrftFaxOutFlg());
		this.hashColumns.put("ida_hlg_tp_cd", getIdaHlgTpCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("de_term_cd_old", getDeTermCdOld());
		this.hashColumns.put("fumg_diff_rmk", getFumgDiffRmk());
		this.hashColumns.put("del_yd_cd_old", getDelYdCdOld());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_por_yd_cd", getBkgPorYdCd());
		this.hashColumns.put("first_pol_clpt_ind_seq", getFirstPolClptIndSeq());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
		this.hashColumns.put("first_vvd_cd", getFirstVvdCd());
		this.hashColumns.put("tvvd_modify_flg", getTvvdModifyFlg());
		this.hashColumns.put("bkg_del_yd_cd", getBkgDelYdCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("awk_cgo_flg_old", getAwkCgoFlgOld());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bl_rt_flg", getBlRtFlg());
		this.hashColumns.put("cmdt_cd_old", getCmdtCdOld());
		this.hashColumns.put("pol_yd_cd_old", getPolYdCdOld());
		this.hashColumns.put("bkg_cntc_pson_fax_no", getBkgCntcPsonFaxNo());
		this.hashColumns.put("mty_pkup_dt_old", getMtyPkupDtOld());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("fnl_dest_nm", getFnlDestNm());
		this.hashColumns.put("por_cd_old", getPorCdOld());
		this.hashColumns.put("bb_flg", getBbFlg());
		this.hashColumns.put("ref_flg", getRefFlg());
		this.hashColumns.put("stwg_rmk", getStwgRmk());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("pod_cd_old", getPodCdOld());
		this.hashColumns.put("si_flg", getSiFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnl_bkg_no_flg", getMnlBkgNoFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("org_sconti_cd", getOrgScontiCd());
		this.hashColumns.put("agmt_act_cust_seq", getAgmtActCustSeq());
		this.hashColumns.put("bkg_cntc_pson_eml", getBkgCntcPsonEml());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("de_due_dt", getDeDueDt());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("si_cntc_pson_fax_no", getSiCntcPsonFaxNo());
		this.hashColumns.put("stwg_flg", getStwgFlg());
		this.hashColumns.put("split_rsn_cd", getSplitRsnCd());
		this.hashColumns.put("new_cust_apro_cmdt_nm", getNewCustAproCmdtNm());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("port_skp_flg", getPortSkpFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("web_svc_flg", getWebSvcFlg());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("rcv_term_cd_old", getRcvTermCdOld());
		this.hashColumns.put("full_pkup_yd_cd", getFullPkupYdCd());
		this.hashColumns.put("is_rated_flg", getIsRatedFlg());
		this.hashColumns.put("mty_pkup_yd_cd_old", getMtyPkupYdCdOld());
		this.hashColumns.put("act_cust_list_exist_flg", getActCustListExistFlg());
		this.hashColumns.put("stop_off_flg", getStopOffFlg());
		this.hashColumns.put("bkg_pod_yd_cd", getBkgPodYdCd());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("filer_cd", getFilerCd());
		this.hashColumns.put("xter_rqst_auto_ntc_flg", getXterRqstAutoNtcFlg());
		this.hashColumns.put("dest_sconti_cd", getDestScontiCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("si_cntc_pson_mphn_no", getSiCntcPsonMphnNo());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("cntr_flg", getCntrFlg());
		this.hashColumns.put("last_vvd_cd", getLastVvdCd());
		this.hashColumns.put("reject_flag", getRejectFlag());
		this.hashColumns.put("bl_aud_flg", getBlAudFlg());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("bkg_trunk_vvd", getBkgTrunkVvd());
		this.hashColumns.put("pod_yd_cd_old", getPodYdCdOld());
		this.hashColumns.put("non_dg_chem_flg", getNonDgChemFlg());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("xter_bkg_rqst_cd", getXterBkgRqstCd());
		this.hashColumns.put("bl_doc_inp_flg", getBlDocInpFlg());
		this.hashColumns.put("last_pod_cd", getLastPodCd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("stop_off_cntc_phn_no", getStopOffCntcPhnNo());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("rfa_available", getRfaAvailable());
		this.hashColumns.put("fumg_cntc_pson_nm", getFumgCntcPsonNm());
		this.hashColumns.put("xter_bkg_rqst_ref_no", getXterBkgRqstRefNo());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("pst_rly_port_yd_cd", getPstRlyPortYdCd());
		this.hashColumns.put("sc_no_old", getScNoOld());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("rc_flg_old", getRcFlgOld());
		this.hashColumns.put("bkg_cntc_pson_nm", getBkgCntcPsonNm());
		this.hashColumns.put("adv_shtg_cd", getAdvShtgCd());
		this.hashColumns.put("hot_de_flg", getHotDeFlg());
		this.hashColumns.put("eq_subst_flg", getEqSubstFlg());
		this.hashColumns.put("vvd_flag", getVvdFlag());
		this.hashColumns.put("fumg_flg", getFumgFlg());
		this.hashColumns.put("fmc_no", getFmcNo());
		this.hashColumns.put("rail_blk_cd", getRailBlkCd());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("kr_cstms_cust_tp_cd", getKrCstmsCustTpCd());
		this.hashColumns.put("bkg_cntc_pson_mphn_no", getBkgCntcPsonMphnNo());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("si_cntc_pson_nm", getSiCntcPsonNm());
		this.hashColumns.put("sc_available", getScAvailable());
		this.hashColumns.put("premium_available_flg", getPremiumAvailableFlg());
		this.hashColumns.put("last_pod_clpt_ind_seq", getLastPodClptIndSeq());
		this.hashColumns.put("twn_so_no", getTwnSoNo());
		this.hashColumns.put("bkg_trunk_vvd_old", getBkgTrunkVvdOld());
		this.hashColumns.put("de_due_dt_old", getDeDueDtOld());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("new_cust_apro_flg", getNewCustAproFlg());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
		this.hashColumns.put("del_cd_old", getDelCdOld());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("pre_vvd_cd", getPreVvdCd());
		this.hashColumns.put("prg_flg", getPrgFlg());
		this.hashColumns.put("crr_soc_flg", getCrrSocFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("taa_available", "taaAvailable");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("old_bkg_no", "oldBkgNo");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("bl_fnt_ofc_flg", "blFntOfcFlg");
		this.hashFields.put("new_cust_apro_mark_flg", "newCustAproMarkFlg");
		this.hashFields.put("xter_si_ref_no", "xterSiRefNo");
		this.hashFields.put("dcgo_flg_old", "dcgoFlgOld");
		this.hashFields.put("mty_dor_arr_dt_old", "mtyDorArrDtOld");
		this.hashFields.put("lodg_due_dt", "lodgDueDt");
		this.hashFields.put("edi_hld_flg", "ediHldFlg");
		this.hashFields.put("awk_flg", "awkFlg");
		this.hashFields.put("spcl_hide_flg", "spclHideFlg");
		this.hashFields.put("partial_vvd_assign_flg", "partialVvdAssignFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("pre_rly_port_yd_cd", "preRlyPortYdCd");
		this.hashFields.put("bkg_pol_yd_cd", "bkgPolYdCd");
		this.hashFields.put("wait_rsn", "waitRsn");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("si_cntc_pson_phn_no", "siCntcPsonPhnNo");
		this.hashFields.put("lodg_due_dt_old", "lodgDueDtOld");
		this.hashFields.put("stop_off_loc_cd", "stopOffLocCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("fd_grd_flg", "fdGrdFlg");
		this.hashFields.put("spcl_hide_lnr_flg", "spclHideLnrFlg");
		this.hashFields.put("return_cd", "returnCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("new_cust_apro_rmk", "newCustAproRmk");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("stop_off_cntc_pson_nm", "stopOffCntcPsonNm");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("por_yd_cd_old", "porYdCdOld");
		this.hashFields.put("mty_dor_arr_dt", "mtyDorArrDt");
		this.hashFields.put("pol_cd_old", "polCdOld");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("pctl_no_old", "pctlNoOld");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("first_pol_cd", "firstPolCd");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("bkg_cntc_pson_phn_no", "bkgCntcPsonPhnNo");
		this.hashFields.put("ocp_cd", "ocpCd");
		this.hashFields.put("ca_user", "caUser");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("veh_cmdt_flg", "vehCmdtFlg");
		this.hashFields.put("fumg_loc_cd", "fumgLocCd");
		this.hashFields.put("eur_tro_cfm", "eurTroCfm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("roll_ovr_cnt", "rollOvrCnt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("taa_no_old", "taaNoOld");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("rfa_no_old", "rfaNoOld");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("xter_si_cd", "xterSiCd");
		this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("bb_cgo_flg_old", "bbCgoFlgOld");
		this.hashFields.put("pst_vvd_cd", "pstVvdCd");
		this.hashFields.put("indiv_pson_flg", "indivPsonFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fumg_cntc_phn_no", "fumgCntcPhnNo");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("full_rtn_yd_cd_old", "fullRtnYdCdOld");
		this.hashFields.put("xtn_phn_no", "xtnPhnNo");
		this.hashFields.put("mnl_cct_flg", "mnlCctFlg");
		this.hashFields.put("si_cntc_pson_eml", "siCntcPsonEml");
		this.hashFields.put("stop_off_diff_rmk", "stopOffDiffRmk");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("bl_drft_fax_out_flg", "blDrftFaxOutFlg");
		this.hashFields.put("ida_hlg_tp_cd", "idaHlgTpCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("de_term_cd_old", "deTermCdOld");
		this.hashFields.put("fumg_diff_rmk", "fumgDiffRmk");
		this.hashFields.put("del_yd_cd_old", "delYdCdOld");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_por_yd_cd", "bkgPorYdCd");
		this.hashFields.put("first_pol_clpt_ind_seq", "firstPolClptIndSeq");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("first_vvd_cd", "firstVvdCd");
		this.hashFields.put("tvvd_modify_flg", "tvvdModifyFlg");
		this.hashFields.put("bkg_del_yd_cd", "bkgDelYdCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("awk_cgo_flg_old", "awkCgoFlgOld");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bl_rt_flg", "blRtFlg");
		this.hashFields.put("cmdt_cd_old", "cmdtCdOld");
		this.hashFields.put("pol_yd_cd_old", "polYdCdOld");
		this.hashFields.put("bkg_cntc_pson_fax_no", "bkgCntcPsonFaxNo");
		this.hashFields.put("mty_pkup_dt_old", "mtyPkupDtOld");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("fnl_dest_nm", "fnlDestNm");
		this.hashFields.put("por_cd_old", "porCdOld");
		this.hashFields.put("bb_flg", "bbFlg");
		this.hashFields.put("ref_flg", "refFlg");
		this.hashFields.put("stwg_rmk", "stwgRmk");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("pod_cd_old", "podCdOld");
		this.hashFields.put("si_flg", "siFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnl_bkg_no_flg", "mnlBkgNoFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("org_sconti_cd", "orgScontiCd");
		this.hashFields.put("agmt_act_cust_seq", "agmtActCustSeq");
		this.hashFields.put("bkg_cntc_pson_eml", "bkgCntcPsonEml");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("de_due_dt", "deDueDt");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("si_cntc_pson_fax_no", "siCntcPsonFaxNo");
		this.hashFields.put("stwg_flg", "stwgFlg");
		this.hashFields.put("split_rsn_cd", "splitRsnCd");
		this.hashFields.put("new_cust_apro_cmdt_nm", "newCustAproCmdtNm");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("port_skp_flg", "portSkpFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("web_svc_flg", "webSvcFlg");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("rcv_term_cd_old", "rcvTermCdOld");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("is_rated_flg", "isRatedFlg");
		this.hashFields.put("mty_pkup_yd_cd_old", "mtyPkupYdCdOld");
		this.hashFields.put("act_cust_list_exist_flg", "actCustListExistFlg");
		this.hashFields.put("stop_off_flg", "stopOffFlg");
		this.hashFields.put("bkg_pod_yd_cd", "bkgPodYdCd");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("filer_cd", "filerCd");
		this.hashFields.put("xter_rqst_auto_ntc_flg", "xterRqstAutoNtcFlg");
		this.hashFields.put("dest_sconti_cd", "destScontiCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("si_cntc_pson_mphn_no", "siCntcPsonMphnNo");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("cntr_flg", "cntrFlg");
		this.hashFields.put("last_vvd_cd", "lastVvdCd");
		this.hashFields.put("reject_flag", "rejectFlag");
		this.hashFields.put("bl_aud_flg", "blAudFlg");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("bkg_trunk_vvd", "bkgTrunkVvd");
		this.hashFields.put("pod_yd_cd_old", "podYdCdOld");
		this.hashFields.put("non_dg_chem_flg", "nonDgChemFlg");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("xter_bkg_rqst_cd", "xterBkgRqstCd");
		this.hashFields.put("bl_doc_inp_flg", "blDocInpFlg");
		this.hashFields.put("last_pod_cd", "lastPodCd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("stop_off_cntc_phn_no", "stopOffCntcPhnNo");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("rfa_available", "rfaAvailable");
		this.hashFields.put("fumg_cntc_pson_nm", "fumgCntcPsonNm");
		this.hashFields.put("xter_bkg_rqst_ref_no", "xterBkgRqstRefNo");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("pst_rly_port_yd_cd", "pstRlyPortYdCd");
		this.hashFields.put("sc_no_old", "scNoOld");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("rc_flg_old", "rcFlgOld");
		this.hashFields.put("bkg_cntc_pson_nm", "bkgCntcPsonNm");
		this.hashFields.put("adv_shtg_cd", "advShtgCd");
		this.hashFields.put("hot_de_flg", "hotDeFlg");
		this.hashFields.put("eq_subst_flg", "eqSubstFlg");
		this.hashFields.put("vvd_flag", "vvdFlag");
		this.hashFields.put("fumg_flg", "fumgFlg");
		this.hashFields.put("fmc_no", "fmcNo");
		this.hashFields.put("rail_blk_cd", "railBlkCd");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("kr_cstms_cust_tp_cd", "krCstmsCustTpCd");
		this.hashFields.put("bkg_cntc_pson_mphn_no", "bkgCntcPsonMphnNo");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("si_cntc_pson_nm", "siCntcPsonNm");
		this.hashFields.put("sc_available", "scAvailable");
		this.hashFields.put("premium_available_flg", "premiumAvailableFlg");
		this.hashFields.put("last_pod_clpt_ind_seq", "lastPodClptIndSeq");
		this.hashFields.put("twn_so_no", "twnSoNo");
		this.hashFields.put("bkg_trunk_vvd_old", "bkgTrunkVvdOld");
		this.hashFields.put("de_due_dt_old", "deDueDtOld");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("new_cust_apro_flg", "newCustAproFlg");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
		this.hashFields.put("del_cd_old", "delCdOld");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("pre_vvd_cd", "preVvdCd");
		this.hashFields.put("prg_flg", "prgFlg");
		this.hashFields.put("crr_soc_flg", "crrSocFlg");
		return this.hashFields;
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
	 * @return agmtActCntCd
	 */
	public String getAgmtActCntCd() {
		return this.agmtActCntCd;
	}
	
	/**
	 * Column Info
	 * @return alocStsCd
	 */
	public String getAlocStsCd() {
		return this.alocStsCd;
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
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return oldBkgNo
	 */
	public String getOldBkgNo() {
		return this.oldBkgNo;
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
	 * @return blFntOfcFlg
	 */
	public String getBlFntOfcFlg() {
		return this.blFntOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return newCustAproMarkFlg
	 */
	public String getNewCustAproMarkFlg() {
		return this.newCustAproMarkFlg;
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
	 * @return lodgDueDt
	 */
	public String getLodgDueDt() {
		return this.lodgDueDt;
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
	 * @return awkFlg
	 */
	public String getAwkFlg() {
		return this.awkFlg;
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
	 * @return fdGrdFlg
	 */
	public String getFdGrdFlg() {
		return this.fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @return spclHideLnrFlg
	 */
	public String getSpclHideLnrFlg() {
		return this.spclHideLnrFlg;
	}
	
	/**
	 * Column Info
	 * @return returnCd
	 */
	public String getReturnCd() {
		return this.returnCd;
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
	 * @return newCustAproRmk
	 */
	public String getNewCustAproRmk() {
		return this.newCustAproRmk;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocTpCd
	 */
	public String getBkgAlocTpCd() {
		return this.bkgAlocTpCd;
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
	 * @return porYdCdOld
	 */
	public String getPorYdCdOld() {
		return this.porYdCdOld;
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
	 * @return polCdOld
	 */
	public String getPolCdOld() {
		return this.polCdOld;
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
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return pctlNoOld
	 */
	public String getPctlNoOld() {
		return this.pctlNoOld;
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
	 * @return firstPolCd
	 */
	public String getFirstPolCd() {
		return this.firstPolCd;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
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
	 * @return caUser
	 */
	public String getCaUser() {
		return this.caUser;
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
	 * @return vehCmdtFlg
	 */
	public String getVehCmdtFlg() {
		return this.vehCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @return fumgLocCd
	 */
	public String getFumgLocCd() {
		return this.fumgLocCd;
	}
	
	/**
	 * Column Info
	 * @return eurTroCfm
	 */
	public String getEurTroCfm() {
		return this.eurTroCfm;
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
	 * @return rollOvrCnt
	 */
	public String getRollOvrCnt() {
		return this.rollOvrCnt;
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
	 * @return taaNoOld
	 */
	public String getTaaNoOld() {
		return this.taaNoOld;
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
	 * @return rfaNoOld
	 */
	public String getRfaNoOld() {
		return this.rfaNoOld;
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
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
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
	 * @return pstVvdCd
	 */
	public String getPstVvdCd() {
		return this.pstVvdCd;
	}
	
	/**
	 * Column Info
	 * @return indivPsonFlg
	 */
	public String getIndivPsonFlg() {
		return this.indivPsonFlg;
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
	 * @return fumgCntcPhnNo
	 */
	public String getFumgCntcPhnNo() {
		return this.fumgCntcPhnNo;
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
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
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
	 * @return mnlCctFlg
	 */
	public String getMnlCctFlg() {
		return this.mnlCctFlg;
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
	 * @return stopOffDiffRmk
	 */
	public String getStopOffDiffRmk() {
		return this.stopOffDiffRmk;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return blDrftFaxOutFlg
	 */
	public String getBlDrftFaxOutFlg() {
		return this.blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @return idaHlgTpCd
	 */
	public String getIdaHlgTpCd() {
		return this.idaHlgTpCd;
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
	 * @return fumgDiffRmk
	 */
	public String getFumgDiffRmk() {
		return this.fumgDiffRmk;
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
	 * @return bkgPorYdCd
	 */
	public String getBkgPorYdCd() {
		return this.bkgPorYdCd;
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
	 * @return tvvdModifyFlg
	 */
	public String getTvvdModifyFlg() {
		return this.tvvdModifyFlg;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return blRtFlg
	 */
	public String getBlRtFlg() {
		return this.blRtFlg;
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
	 * @return polYdCdOld
	 */
	public String getPolYdCdOld() {
		return this.polYdCdOld;
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
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return bbFlg
	 */
	public String getBbFlg() {
		return this.bbFlg;
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
	 * @return mnlBkgNoFlg
	 */
	public String getMnlBkgNoFlg() {
		return this.mnlBkgNoFlg;
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
	 * @return orgScontiCd
	 */
	public String getOrgScontiCd() {
		return this.orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @return agmtActCustSeq
	 */
	public String getAgmtActCustSeq() {
		return this.agmtActCustSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return splitRsnCd
	 */
	public String getSplitRsnCd() {
		return this.splitRsnCd;
	}
	
	/**
	 * Column Info
	 * @return newCustAproCmdtNm
	 */
	public String getNewCustAproCmdtNm() {
		return this.newCustAproCmdtNm;
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
	 * @return portSkpFlg
	 */
	public String getPortSkpFlg() {
		return this.portSkpFlg;
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
	 * @return webSvcFlg
	 */
	public String getWebSvcFlg() {
		return this.webSvcFlg;
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
	 * @return rcvTermCdOld
	 */
	public String getRcvTermCdOld() {
		return this.rcvTermCdOld;
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
	 * @return actCustListExistFlg
	 */
	public String getActCustListExistFlg() {
		return this.actCustListExistFlg;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return rejectFlag
	 */
	public String getRejectFlag() {
		return this.rejectFlag;
	}
	
	/**
	 * Column Info
	 * @return blAudFlg
	 */
	public String getBlAudFlg() {
		return this.blAudFlg;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return podYdCdOld
	 */
	public String getPodYdCdOld() {
		return this.podYdCdOld;
	}
	
	/**
	 * Column Info
	 * @return nonDgChemFlg
	 */
	public String getNonDgChemFlg() {
		return this.nonDgChemFlg;
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
	 * @return blDocInpFlg
	 */
	public String getBlDocInpFlg() {
		return this.blDocInpFlg;
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
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
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
	 * @return fumgCntcPsonNm
	 */
	public String getFumgCntcPsonNm() {
		return this.fumgCntcPsonNm;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
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
	 * @return fumgFlg
	 */
	public String getFumgFlg() {
		return this.fumgFlg;
	}
	
	/**
	 * Column Info
	 * @return fmcNo
	 */
	public String getFmcNo() {
		return this.fmcNo;
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
	 * @return krCstmsCustTpCd
	 */
	public String getKrCstmsCustTpCd() {
		return this.krCstmsCustTpCd;
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
	 * @return scAvailable
	 */
	public String getScAvailable() {
		return this.scAvailable;
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
	 * @return lastPodClptIndSeq
	 */
	public String getLastPodClptIndSeq() {
		return this.lastPodClptIndSeq;
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
	 * @return bkgTrunkVvdOld
	 */
	public String getBkgTrunkVvdOld() {
		return this.bkgTrunkVvdOld;
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
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return newCustAproFlg
	 */
	public String getNewCustAproFlg() {
		return this.newCustAproFlg;
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
	 * @return nonRtStsCd
	 */
	public String getNonRtStsCd() {
		return this.nonRtStsCd;
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
	 * @return preVvdCd
	 */
	public String getPreVvdCd() {
		return this.preVvdCd;
	}
	
	/**
	 * Column Info
	 * @return prgFlg
	 */
	public String getPrgFlg() {
		return this.prgFlg;
	}
	
	/**
	 * Column Info
	 * @return crrSocFlg
	 */
	public String getCrrSocFlg() {
		return this.crrSocFlg;
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
	 * @param agmtActCntCd
	 */
	public void setAgmtActCntCd(String agmtActCntCd) {
		this.agmtActCntCd = agmtActCntCd;
	}
	
	/**
	 * Column Info
	 * @param alocStsCd
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
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
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param oldBkgNo
	 */
	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
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
	 * @param blFntOfcFlg
	 */
	public void setBlFntOfcFlg(String blFntOfcFlg) {
		this.blFntOfcFlg = blFntOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param newCustAproMarkFlg
	 */
	public void setNewCustAproMarkFlg(String newCustAproMarkFlg) {
		this.newCustAproMarkFlg = newCustAproMarkFlg;
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
	 * @param lodgDueDt
	 */
	public void setLodgDueDt(String lodgDueDt) {
		this.lodgDueDt = lodgDueDt;
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
	 * @param awkFlg
	 */
	public void setAwkFlg(String awkFlg) {
		this.awkFlg = awkFlg;
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
	 * @param fdGrdFlg
	 */
	public void setFdGrdFlg(String fdGrdFlg) {
		this.fdGrdFlg = fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @param spclHideLnrFlg
	 */
	public void setSpclHideLnrFlg(String spclHideLnrFlg) {
		this.spclHideLnrFlg = spclHideLnrFlg;
	}
	
	/**
	 * Column Info
	 * @param returnCd
	 */
	public void setReturnCd(String returnCd) {
		this.returnCd = returnCd;
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
	 * @param newCustAproRmk
	 */
	public void setNewCustAproRmk(String newCustAproRmk) {
		this.newCustAproRmk = newCustAproRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocTpCd
	 */
	public void setBkgAlocTpCd(String bkgAlocTpCd) {
		this.bkgAlocTpCd = bkgAlocTpCd;
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
	 * @param porYdCdOld
	 */
	public void setPorYdCdOld(String porYdCdOld) {
		this.porYdCdOld = porYdCdOld;
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
	 * @param polCdOld
	 */
	public void setPolCdOld(String polCdOld) {
		this.polCdOld = polCdOld;
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
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}
	
	/**
	 * Column Info
	 * @param pctlNoOld
	 */
	public void setPctlNoOld(String pctlNoOld) {
		this.pctlNoOld = pctlNoOld;
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
	 * @param firstPolCd
	 */
	public void setFirstPolCd(String firstPolCd) {
		this.firstPolCd = firstPolCd;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
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
	 * @param caUser
	 */
	public void setCaUser(String caUser) {
		this.caUser = caUser;
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
	 * @param vehCmdtFlg
	 */
	public void setVehCmdtFlg(String vehCmdtFlg) {
		this.vehCmdtFlg = vehCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @param fumgLocCd
	 */
	public void setFumgLocCd(String fumgLocCd) {
		this.fumgLocCd = fumgLocCd;
	}
	
	/**
	 * Column Info
	 * @param eurTroCfm
	 */
	public void setEurTroCfm(String eurTroCfm) {
		this.eurTroCfm = eurTroCfm;
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
	 * @param rollOvrCnt
	 */
	public void setRollOvrCnt(String rollOvrCnt) {
		this.rollOvrCnt = rollOvrCnt;
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
	 * @param taaNoOld
	 */
	public void setTaaNoOld(String taaNoOld) {
		this.taaNoOld = taaNoOld;
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
	 * @param rfaNoOld
	 */
	public void setRfaNoOld(String rfaNoOld) {
		this.rfaNoOld = rfaNoOld;
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
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
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
	 * @param pstVvdCd
	 */
	public void setPstVvdCd(String pstVvdCd) {
		this.pstVvdCd = pstVvdCd;
	}
	
	/**
	 * Column Info
	 * @param indivPsonFlg
	 */
	public void setIndivPsonFlg(String indivPsonFlg) {
		this.indivPsonFlg = indivPsonFlg;
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
	 * @param fumgCntcPhnNo
	 */
	public void setFumgCntcPhnNo(String fumgCntcPhnNo) {
		this.fumgCntcPhnNo = fumgCntcPhnNo;
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
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
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
	 * @param mnlCctFlg
	 */
	public void setMnlCctFlg(String mnlCctFlg) {
		this.mnlCctFlg = mnlCctFlg;
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
	 * @param stopOffDiffRmk
	 */
	public void setStopOffDiffRmk(String stopOffDiffRmk) {
		this.stopOffDiffRmk = stopOffDiffRmk;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param blDrftFaxOutFlg
	 */
	public void setBlDrftFaxOutFlg(String blDrftFaxOutFlg) {
		this.blDrftFaxOutFlg = blDrftFaxOutFlg;
	}
	
	/**
	 * Column Info
	 * @param idaHlgTpCd
	 */
	public void setIdaHlgTpCd(String idaHlgTpCd) {
		this.idaHlgTpCd = idaHlgTpCd;
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
	 * @param fumgDiffRmk
	 */
	public void setFumgDiffRmk(String fumgDiffRmk) {
		this.fumgDiffRmk = fumgDiffRmk;
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
	 * @param bkgPorYdCd
	 */
	public void setBkgPorYdCd(String bkgPorYdCd) {
		this.bkgPorYdCd = bkgPorYdCd;
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
	 * @param tvvdModifyFlg
	 */
	public void setTvvdModifyFlg(String tvvdModifyFlg) {
		this.tvvdModifyFlg = tvvdModifyFlg;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param blRtFlg
	 */
	public void setBlRtFlg(String blRtFlg) {
		this.blRtFlg = blRtFlg;
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
	 * @param polYdCdOld
	 */
	public void setPolYdCdOld(String polYdCdOld) {
		this.polYdCdOld = polYdCdOld;
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
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param bbFlg
	 */
	public void setBbFlg(String bbFlg) {
		this.bbFlg = bbFlg;
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
	 * @param mnlBkgNoFlg
	 */
	public void setMnlBkgNoFlg(String mnlBkgNoFlg) {
		this.mnlBkgNoFlg = mnlBkgNoFlg;
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
	 * @param orgScontiCd
	 */
	public void setOrgScontiCd(String orgScontiCd) {
		this.orgScontiCd = orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @param agmtActCustSeq
	 */
	public void setAgmtActCustSeq(String agmtActCustSeq) {
		this.agmtActCustSeq = agmtActCustSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param splitRsnCd
	 */
	public void setSplitRsnCd(String splitRsnCd) {
		this.splitRsnCd = splitRsnCd;
	}
	
	/**
	 * Column Info
	 * @param newCustAproCmdtNm
	 */
	public void setNewCustAproCmdtNm(String newCustAproCmdtNm) {
		this.newCustAproCmdtNm = newCustAproCmdtNm;
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
	 * @param portSkpFlg
	 */
	public void setPortSkpFlg(String portSkpFlg) {
		this.portSkpFlg = portSkpFlg;
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
	 * @param webSvcFlg
	 */
	public void setWebSvcFlg(String webSvcFlg) {
		this.webSvcFlg = webSvcFlg;
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
	 * @param rcvTermCdOld
	 */
	public void setRcvTermCdOld(String rcvTermCdOld) {
		this.rcvTermCdOld = rcvTermCdOld;
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
	 * @param actCustListExistFlg
	 */
	public void setActCustListExistFlg(String actCustListExistFlg) {
		this.actCustListExistFlg = actCustListExistFlg;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param rejectFlag
	 */
	public void setRejectFlag(String rejectFlag) {
		this.rejectFlag = rejectFlag;
	}
	
	/**
	 * Column Info
	 * @param blAudFlg
	 */
	public void setBlAudFlg(String blAudFlg) {
		this.blAudFlg = blAudFlg;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param podYdCdOld
	 */
	public void setPodYdCdOld(String podYdCdOld) {
		this.podYdCdOld = podYdCdOld;
	}
	
	/**
	 * Column Info
	 * @param nonDgChemFlg
	 */
	public void setNonDgChemFlg(String nonDgChemFlg) {
		this.nonDgChemFlg = nonDgChemFlg;
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
	 * @param blDocInpFlg
	 */
	public void setBlDocInpFlg(String blDocInpFlg) {
		this.blDocInpFlg = blDocInpFlg;
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
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
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
	 * @param fumgCntcPsonNm
	 */
	public void setFumgCntcPsonNm(String fumgCntcPsonNm) {
		this.fumgCntcPsonNm = fumgCntcPsonNm;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
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
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
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
	 * @param fumgFlg
	 */
	public void setFumgFlg(String fumgFlg) {
		this.fumgFlg = fumgFlg;
	}
	
	/**
	 * Column Info
	 * @param fmcNo
	 */
	public void setFmcNo(String fmcNo) {
		this.fmcNo = fmcNo;
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
	 * @param krCstmsCustTpCd
	 */
	public void setKrCstmsCustTpCd(String krCstmsCustTpCd) {
		this.krCstmsCustTpCd = krCstmsCustTpCd;
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
	 * @param scAvailable
	 */
	public void setScAvailable(String scAvailable) {
		this.scAvailable = scAvailable;
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
	 * @param lastPodClptIndSeq
	 */
	public void setLastPodClptIndSeq(String lastPodClptIndSeq) {
		this.lastPodClptIndSeq = lastPodClptIndSeq;
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
	 * @param bkgTrunkVvdOld
	 */
	public void setBkgTrunkVvdOld(String bkgTrunkVvdOld) {
		this.bkgTrunkVvdOld = bkgTrunkVvdOld;
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
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param newCustAproFlg
	 */
	public void setNewCustAproFlg(String newCustAproFlg) {
		this.newCustAproFlg = newCustAproFlg;
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
	 * @param nonRtStsCd
	 */
	public void setNonRtStsCd(String nonRtStsCd) {
		this.nonRtStsCd = nonRtStsCd;
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
	 * @param preVvdCd
	 */
	public void setPreVvdCd(String preVvdCd) {
		this.preVvdCd = preVvdCd;
	}
	
	/**
	 * Column Info
	 * @param prgFlg
	 */
	public void setPrgFlg(String prgFlg) {
		this.prgFlg = prgFlg;
	}
	
	/**
	 * Column Info
	 * @param crrSocFlg
	 */
	public void setCrrSocFlg(String crrSocFlg) {
		this.crrSocFlg = crrSocFlg;
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
		setOrgTrnsModCd(JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", ""));
		setTaaAvailable(JSPUtil.getParameter(request, prefix + "taa_available", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setAgmtActCntCd(JSPUtil.getParameter(request, prefix + "agmt_act_cnt_cd", ""));
		setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setOldBkgNo(JSPUtil.getParameter(request, prefix + "old_bkg_no", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setBlFntOfcFlg(JSPUtil.getParameter(request, prefix + "bl_fnt_ofc_flg", ""));
		setNewCustAproMarkFlg(JSPUtil.getParameter(request, prefix + "new_cust_apro_mark_flg", ""));
		setXterSiRefNo(JSPUtil.getParameter(request, prefix + "xter_si_ref_no", ""));
		setDcgoFlgOld(JSPUtil.getParameter(request, prefix + "dcgo_flg_old", ""));
		setMtyDorArrDtOld(JSPUtil.getParameter(request, prefix + "mty_dor_arr_dt_old", ""));
		setLodgDueDt(JSPUtil.getParameter(request, prefix + "lodg_due_dt", ""));
		setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
		setAwkFlg(JSPUtil.getParameter(request, prefix + "awk_flg", ""));
		setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
		setPartialVvdAssignFlg(JSPUtil.getParameter(request, prefix + "partial_vvd_assign_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setPreRlyPortYdCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_yd_cd", ""));
		setBkgPolYdCd(JSPUtil.getParameter(request, prefix + "bkg_pol_yd_cd", ""));
		setWaitRsn(JSPUtil.getParameter(request, prefix + "wait_rsn", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
		setSiCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_phn_no", ""));
		setLodgDueDtOld(JSPUtil.getParameter(request, prefix + "lodg_due_dt_old", ""));
		setStopOffLocCd(JSPUtil.getParameter(request, prefix + "stop_off_loc_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
		setSpclHideLnrFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_lnr_flg", ""));
		setReturnCd(JSPUtil.getParameter(request, prefix + "return_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setNewCustAproRmk(JSPUtil.getParameter(request, prefix + "new_cust_apro_rmk", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setStopOffCntcPsonNm(JSPUtil.getParameter(request, prefix + "stop_off_cntc_pson_nm", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setPorYdCdOld(JSPUtil.getParameter(request, prefix + "por_yd_cd_old", ""));
		setMtyDorArrDt(JSPUtil.getParameter(request, prefix + "mty_dor_arr_dt", ""));
		setPolCdOld(JSPUtil.getParameter(request, prefix + "pol_cd_old", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setPctlNoOld(JSPUtil.getParameter(request, prefix + "pctl_no_old", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setFirstPolCd(JSPUtil.getParameter(request, prefix + "first_pol_cd", ""));
		setSCustSeq(JSPUtil.getParameter(request, prefix + "s_cust_seq", ""));
		setBkgCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_phn_no", ""));
		setOcpCd(JSPUtil.getParameter(request, prefix + "ocp_cd", ""));
		setCaUser(JSPUtil.getParameter(request, prefix + "ca_user", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setVehCmdtFlg(JSPUtil.getParameter(request, prefix + "veh_cmdt_flg", ""));
		setFumgLocCd(JSPUtil.getParameter(request, prefix + "fumg_loc_cd", ""));
		setEurTroCfm(JSPUtil.getParameter(request, prefix + "eur_tro_cfm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRollOvrCnt(JSPUtil.getParameter(request, prefix + "roll_ovr_cnt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setTaaNoOld(JSPUtil.getParameter(request, prefix + "taa_no_old", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setRfaNoOld(JSPUtil.getParameter(request, prefix + "rfa_no_old", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setXterSiCd(JSPUtil.getParameter(request, prefix + "xter_si_cd", ""));
		setMtyPkupDt(JSPUtil.getParameter(request, prefix + "mty_pkup_dt", ""));
		setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
		setBbCgoFlgOld(JSPUtil.getParameter(request, prefix + "bb_cgo_flg_old", ""));
		setPstVvdCd(JSPUtil.getParameter(request, prefix + "pst_vvd_cd", ""));
		setIndivPsonFlg(JSPUtil.getParameter(request, prefix + "indiv_pson_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFumgCntcPhnNo(JSPUtil.getParameter(request, prefix + "fumg_cntc_phn_no", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setFullRtnYdCdOld(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd_old", ""));
		setXtnPhnNo(JSPUtil.getParameter(request, prefix + "xtn_phn_no", ""));
		setMnlCctFlg(JSPUtil.getParameter(request, prefix + "mnl_cct_flg", ""));
		setSiCntcPsonEml(JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", ""));
		setStopOffDiffRmk(JSPUtil.getParameter(request, prefix + "stop_off_diff_rmk", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setBlDrftFaxOutFlg(JSPUtil.getParameter(request, prefix + "bl_drft_fax_out_flg", ""));
		setIdaHlgTpCd(JSPUtil.getParameter(request, prefix + "ida_hlg_tp_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setDeTermCdOld(JSPUtil.getParameter(request, prefix + "de_term_cd_old", ""));
		setFumgDiffRmk(JSPUtil.getParameter(request, prefix + "fumg_diff_rmk", ""));
		setDelYdCdOld(JSPUtil.getParameter(request, prefix + "del_yd_cd_old", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgPorYdCd(JSPUtil.getParameter(request, prefix + "bkg_por_yd_cd", ""));
		setFirstPolClptIndSeq(JSPUtil.getParameter(request, prefix + "first_pol_clpt_ind_seq", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_rtn_yd_cd", ""));
		setFirstVvdCd(JSPUtil.getParameter(request, prefix + "first_vvd_cd", ""));
		setTvvdModifyFlg(JSPUtil.getParameter(request, prefix + "tvvd_modify_flg", ""));
		setBkgDelYdCd(JSPUtil.getParameter(request, prefix + "bkg_del_yd_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setAwkCgoFlgOld(JSPUtil.getParameter(request, prefix + "awk_cgo_flg_old", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setBlRtFlg(JSPUtil.getParameter(request, prefix + "bl_rt_flg", ""));
		setCmdtCdOld(JSPUtil.getParameter(request, prefix + "cmdt_cd_old", ""));
		setPolYdCdOld(JSPUtil.getParameter(request, prefix + "pol_yd_cd_old", ""));
		setBkgCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_fax_no", ""));
		setMtyPkupDtOld(JSPUtil.getParameter(request, prefix + "mty_pkup_dt_old", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setFnlDestNm(JSPUtil.getParameter(request, prefix + "fnl_dest_nm", ""));
		setPorCdOld(JSPUtil.getParameter(request, prefix + "por_cd_old", ""));
		setBbFlg(JSPUtil.getParameter(request, prefix + "bb_flg", ""));
		setRefFlg(JSPUtil.getParameter(request, prefix + "ref_flg", ""));
		setStwgRmk(JSPUtil.getParameter(request, prefix + "stwg_rmk", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setPodCdOld(JSPUtil.getParameter(request, prefix + "pod_cd_old", ""));
		setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMnlBkgNoFlg(JSPUtil.getParameter(request, prefix + "mnl_bkg_no_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setOrgScontiCd(JSPUtil.getParameter(request, prefix + "org_sconti_cd", ""));
		setAgmtActCustSeq(JSPUtil.getParameter(request, prefix + "agmt_act_cust_seq", ""));
		setBkgCntcPsonEml(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDeDueDt(JSPUtil.getParameter(request, prefix + "de_due_dt", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
		setSiCntcPsonFaxNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_fax_no", ""));
		setStwgFlg(JSPUtil.getParameter(request, prefix + "stwg_flg", ""));
		setSplitRsnCd(JSPUtil.getParameter(request, prefix + "split_rsn_cd", ""));
		setNewCustAproCmdtNm(JSPUtil.getParameter(request, prefix + "new_cust_apro_cmdt_nm", ""));
		setRfFlg(JSPUtil.getParameter(request, prefix + "rf_flg", ""));
		setPortSkpFlg(JSPUtil.getParameter(request, prefix + "port_skp_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setWebSvcFlg(JSPUtil.getParameter(request, prefix + "web_svc_flg", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setRcvTermCdOld(JSPUtil.getParameter(request, prefix + "rcv_term_cd_old", ""));
		setFullPkupYdCd(JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", ""));
		setIsRatedFlg(JSPUtil.getParameter(request, prefix + "is_rated_flg", ""));
		setMtyPkupYdCdOld(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd_old", ""));
		setActCustListExistFlg(JSPUtil.getParameter(request, prefix + "act_cust_list_exist_flg", ""));
		setStopOffFlg(JSPUtil.getParameter(request, prefix + "stop_off_flg", ""));
		setBkgPodYdCd(JSPUtil.getParameter(request, prefix + "bkg_pod_yd_cd", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setFilerCd(JSPUtil.getParameter(request, prefix + "filer_cd", ""));
		setXterRqstAutoNtcFlg(JSPUtil.getParameter(request, prefix + "xter_rqst_auto_ntc_flg", ""));
		setDestScontiCd(JSPUtil.getParameter(request, prefix + "dest_sconti_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSiCntcPsonMphnNo(JSPUtil.getParameter(request, prefix + "si_cntc_pson_mphn_no", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setCntrFlg(JSPUtil.getParameter(request, prefix + "cntr_flg", ""));
		setLastVvdCd(JSPUtil.getParameter(request, prefix + "last_vvd_cd", ""));
		setRejectFlag(JSPUtil.getParameter(request, prefix + "reject_flag", ""));
		setBlAudFlg(JSPUtil.getParameter(request, prefix + "bl_aud_flg", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setBkgTrunkVvd(JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd", ""));
		setPodYdCdOld(JSPUtil.getParameter(request, prefix + "pod_yd_cd_old", ""));
		setNonDgChemFlg(JSPUtil.getParameter(request, prefix + "non_dg_chem_flg", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, prefix + "cnd_cstms_file_cd", ""));
		setXterBkgRqstCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_cd", ""));
		setBlDocInpFlg(JSPUtil.getParameter(request, prefix + "bl_doc_inp_flg", ""));
		setLastPodCd(JSPUtil.getParameter(request, prefix + "last_pod_cd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setStopOffCntcPhnNo(JSPUtil.getParameter(request, prefix + "stop_off_cntc_phn_no", ""));
		setSCustCntCd(JSPUtil.getParameter(request, prefix + "s_cust_cnt_cd", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setRfaAvailable(JSPUtil.getParameter(request, prefix + "rfa_available", ""));
		setFumgCntcPsonNm(JSPUtil.getParameter(request, prefix + "fumg_cntc_pson_nm", ""));
		setXterBkgRqstRefNo(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_ref_no", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setPstRlyPortYdCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_yd_cd", ""));
		setScNoOld(JSPUtil.getParameter(request, prefix + "sc_no_old", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setRcFlgOld(JSPUtil.getParameter(request, prefix + "rc_flg_old", ""));
		setBkgCntcPsonNm(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_nm", ""));
		setAdvShtgCd(JSPUtil.getParameter(request, prefix + "adv_shtg_cd", ""));
		setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
		setEqSubstFlg(JSPUtil.getParameter(request, prefix + "eq_subst_flg", ""));
		setVvdFlag(JSPUtil.getParameter(request, prefix + "vvd_flag", ""));
		setFumgFlg(JSPUtil.getParameter(request, prefix + "fumg_flg", ""));
		setFmcNo(JSPUtil.getParameter(request, prefix + "fmc_no", ""));
		setRailBlkCd(JSPUtil.getParameter(request, prefix + "rail_blk_cd", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setKrCstmsCustTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_cust_tp_cd", ""));
		setBkgCntcPsonMphnNo(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_mphn_no", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setSiCntcPsonNm(JSPUtil.getParameter(request, prefix + "si_cntc_pson_nm", ""));
		setScAvailable(JSPUtil.getParameter(request, prefix + "sc_available", ""));
		setPremiumAvailableFlg(JSPUtil.getParameter(request, prefix + "premium_available_flg", ""));
		setLastPodClptIndSeq(JSPUtil.getParameter(request, prefix + "last_pod_clpt_ind_seq", ""));
		setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
		setBkgTrunkVvdOld(JSPUtil.getParameter(request, prefix + "bkg_trunk_vvd_old", ""));
		setDeDueDtOld(JSPUtil.getParameter(request, prefix + "de_due_dt_old", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, prefix + "usa_cstms_file_cd", ""));
		setNewCustAproFlg(JSPUtil.getParameter(request, prefix + "new_cust_apro_flg", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setNonRtStsCd(JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", ""));
		setDelCdOld(JSPUtil.getParameter(request, prefix + "del_cd_old", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setPreVvdCd(JSPUtil.getParameter(request, prefix + "pre_vvd_cd", ""));
		setPrgFlg(JSPUtil.getParameter(request, prefix + "prg_flg", ""));
		setCrrSocFlg(JSPUtil.getParameter(request, prefix + "crr_soc_flg", ""));
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
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] taaAvailable = (JSPUtil.getParameter(request, prefix	+ "taa_available", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] agmtActCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cnt_cd", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] oldBkgNo = (JSPUtil.getParameter(request, prefix	+ "old_bkg_no", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] blFntOfcFlg = (JSPUtil.getParameter(request, prefix	+ "bl_fnt_ofc_flg", length));
			String[] newCustAproMarkFlg = (JSPUtil.getParameter(request, prefix	+ "new_cust_apro_mark_flg", length));
			String[] xterSiRefNo = (JSPUtil.getParameter(request, prefix	+ "xter_si_ref_no", length));
			String[] dcgoFlgOld = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg_old", length));
			String[] mtyDorArrDtOld = (JSPUtil.getParameter(request, prefix	+ "mty_dor_arr_dt_old", length));
			String[] lodgDueDt = (JSPUtil.getParameter(request, prefix	+ "lodg_due_dt", length));
			String[] ediHldFlg = (JSPUtil.getParameter(request, prefix	+ "edi_hld_flg", length));
			String[] awkFlg = (JSPUtil.getParameter(request, prefix	+ "awk_flg", length));
			String[] spclHideFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_flg", length));
			String[] partialVvdAssignFlg = (JSPUtil.getParameter(request, prefix	+ "partial_vvd_assign_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] preRlyPortYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_yd_cd", length));
			String[] bkgPolYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_yd_cd", length));
			String[] waitRsn = (JSPUtil.getParameter(request, prefix	+ "wait_rsn", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] siCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_phn_no", length));
			String[] lodgDueDtOld = (JSPUtil.getParameter(request, prefix	+ "lodg_due_dt_old", length));
			String[] stopOffLocCd = (JSPUtil.getParameter(request, prefix	+ "stop_off_loc_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_flg", length));
			String[] spclHideLnrFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_lnr_flg", length));
			String[] returnCd = (JSPUtil.getParameter(request, prefix	+ "return_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] newCustAproRmk = (JSPUtil.getParameter(request, prefix	+ "new_cust_apro_rmk", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] stopOffCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "stop_off_cntc_pson_nm", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] porYdCdOld = (JSPUtil.getParameter(request, prefix	+ "por_yd_cd_old", length));
			String[] mtyDorArrDt = (JSPUtil.getParameter(request, prefix	+ "mty_dor_arr_dt", length));
			String[] polCdOld = (JSPUtil.getParameter(request, prefix	+ "pol_cd_old", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] pctlNoOld = (JSPUtil.getParameter(request, prefix	+ "pctl_no_old", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] firstPolCd = (JSPUtil.getParameter(request, prefix	+ "first_pol_cd", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] bkgCntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_phn_no", length));
			String[] ocpCd = (JSPUtil.getParameter(request, prefix	+ "ocp_cd", length));
			String[] caUser = (JSPUtil.getParameter(request, prefix	+ "ca_user", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] vehCmdtFlg = (JSPUtil.getParameter(request, prefix	+ "veh_cmdt_flg", length));
			String[] fumgLocCd = (JSPUtil.getParameter(request, prefix	+ "fumg_loc_cd", length));
			String[] eurTroCfm = (JSPUtil.getParameter(request, prefix	+ "eur_tro_cfm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rollOvrCnt = (JSPUtil.getParameter(request, prefix	+ "roll_ovr_cnt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] taaNoOld = (JSPUtil.getParameter(request, prefix	+ "taa_no_old", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] rfaNoOld = (JSPUtil.getParameter(request, prefix	+ "rfa_no_old", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] xterSiCd = (JSPUtil.getParameter(request, prefix	+ "xter_si_cd", length));
			String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] bbCgoFlgOld = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg_old", length));
			String[] pstVvdCd = (JSPUtil.getParameter(request, prefix	+ "pst_vvd_cd", length));
			String[] indivPsonFlg = (JSPUtil.getParameter(request, prefix	+ "indiv_pson_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fumgCntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "fumg_cntc_phn_no", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] fullRtnYdCdOld = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd_old", length));
			String[] xtnPhnNo = (JSPUtil.getParameter(request, prefix	+ "xtn_phn_no", length));
			String[] mnlCctFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_cct_flg", length));
			String[] siCntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_eml", length));
			String[] stopOffDiffRmk = (JSPUtil.getParameter(request, prefix	+ "stop_off_diff_rmk", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] blDrftFaxOutFlg = (JSPUtil.getParameter(request, prefix	+ "bl_drft_fax_out_flg", length));
			String[] idaHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_hlg_tp_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] deTermCdOld = (JSPUtil.getParameter(request, prefix	+ "de_term_cd_old", length));
			String[] fumgDiffRmk = (JSPUtil.getParameter(request, prefix	+ "fumg_diff_rmk", length));
			String[] delYdCdOld = (JSPUtil.getParameter(request, prefix	+ "del_yd_cd_old", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgPorYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_yd_cd", length));
			String[] firstPolClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "first_pol_clpt_ind_seq", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			String[] firstVvdCd = (JSPUtil.getParameter(request, prefix	+ "first_vvd_cd", length));
			String[] tvvdModifyFlg = (JSPUtil.getParameter(request, prefix	+ "tvvd_modify_flg", length));
			String[] bkgDelYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_yd_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] awkCgoFlgOld = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg_old", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] blRtFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rt_flg", length));
			String[] cmdtCdOld = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd_old", length));
			String[] polYdCdOld = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd_old", length));
			String[] bkgCntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_fax_no", length));
			String[] mtyPkupDtOld = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt_old", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] fnlDestNm = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_nm", length));
			String[] porCdOld = (JSPUtil.getParameter(request, prefix	+ "por_cd_old", length));
			String[] bbFlg = (JSPUtil.getParameter(request, prefix	+ "bb_flg", length));
			String[] refFlg = (JSPUtil.getParameter(request, prefix	+ "ref_flg", length));
			String[] stwgRmk = (JSPUtil.getParameter(request, prefix	+ "stwg_rmk", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] podCdOld = (JSPUtil.getParameter(request, prefix	+ "pod_cd_old", length));
			String[] siFlg = (JSPUtil.getParameter(request, prefix	+ "si_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnlBkgNoFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_bkg_no_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] orgScontiCd = (JSPUtil.getParameter(request, prefix	+ "org_sconti_cd", length));
			String[] agmtActCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_act_cust_seq", length));
			String[] bkgCntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_eml", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] deDueDt = (JSPUtil.getParameter(request, prefix	+ "de_due_dt", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			String[] siCntcPsonFaxNo = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_fax_no", length));
			String[] stwgFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_flg", length));
			String[] splitRsnCd = (JSPUtil.getParameter(request, prefix	+ "split_rsn_cd", length));
			String[] newCustAproCmdtNm = (JSPUtil.getParameter(request, prefix	+ "new_cust_apro_cmdt_nm", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] portSkpFlg = (JSPUtil.getParameter(request, prefix	+ "port_skp_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] webSvcFlg = (JSPUtil.getParameter(request, prefix	+ "web_svc_flg", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] rcvTermCdOld = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd_old", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "full_pkup_yd_cd", length));
			String[] isRatedFlg = (JSPUtil.getParameter(request, prefix	+ "is_rated_flg", length));
			String[] mtyPkupYdCdOld = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd_old", length));
			String[] actCustListExistFlg = (JSPUtil.getParameter(request, prefix	+ "act_cust_list_exist_flg", length));
			String[] stopOffFlg = (JSPUtil.getParameter(request, prefix	+ "stop_off_flg", length));
			String[] bkgPodYdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_yd_cd", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] filerCd = (JSPUtil.getParameter(request, prefix	+ "filer_cd", length));
			String[] xterRqstAutoNtcFlg = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_auto_ntc_flg", length));
			String[] destScontiCd = (JSPUtil.getParameter(request, prefix	+ "dest_sconti_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] siCntcPsonMphnNo = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_mphn_no", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] cntrFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_flg", length));
			String[] lastVvdCd = (JSPUtil.getParameter(request, prefix	+ "last_vvd_cd", length));
			String[] rejectFlag = (JSPUtil.getParameter(request, prefix	+ "reject_flag", length));
			String[] blAudFlg = (JSPUtil.getParameter(request, prefix	+ "bl_aud_flg", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] bkgTrunkVvd = (JSPUtil.getParameter(request, prefix	+ "bkg_trunk_vvd", length));
			String[] podYdCdOld = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd_old", length));
			String[] nonDgChemFlg = (JSPUtil.getParameter(request, prefix	+ "non_dg_chem_flg", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] xterBkgRqstCd = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_cd", length));
			String[] blDocInpFlg = (JSPUtil.getParameter(request, prefix	+ "bl_doc_inp_flg", length));
			String[] lastPodCd = (JSPUtil.getParameter(request, prefix	+ "last_pod_cd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] stopOffCntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "stop_off_cntc_phn_no", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] rfaAvailable = (JSPUtil.getParameter(request, prefix	+ "rfa_available", length));
			String[] fumgCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "fumg_cntc_pson_nm", length));
			String[] xterBkgRqstRefNo = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_ref_no", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_svc_mod_cd", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] pstRlyPortYdCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_yd_cd", length));
			String[] scNoOld = (JSPUtil.getParameter(request, prefix	+ "sc_no_old", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] rcFlgOld = (JSPUtil.getParameter(request, prefix	+ "rc_flg_old", length));
			String[] bkgCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_nm", length));
			String[] advShtgCd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] hotDeFlg = (JSPUtil.getParameter(request, prefix	+ "hot_de_flg", length));
			String[] eqSubstFlg = (JSPUtil.getParameter(request, prefix	+ "eq_subst_flg", length));
			String[] vvdFlag = (JSPUtil.getParameter(request, prefix	+ "vvd_flag", length));
			String[] fumgFlg = (JSPUtil.getParameter(request, prefix	+ "fumg_flg", length));
			String[] fmcNo = (JSPUtil.getParameter(request, prefix	+ "fmc_no", length));
			String[] railBlkCd = (JSPUtil.getParameter(request, prefix	+ "rail_blk_cd", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] krCstmsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_cust_tp_cd", length));
			String[] bkgCntcPsonMphnNo = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_mphn_no", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] siCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_nm", length));
			String[] scAvailable = (JSPUtil.getParameter(request, prefix	+ "sc_available", length));
			String[] premiumAvailableFlg = (JSPUtil.getParameter(request, prefix	+ "premium_available_flg", length));
			String[] lastPodClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "last_pod_clpt_ind_seq", length));
			String[] twnSoNo = (JSPUtil.getParameter(request, prefix	+ "twn_so_no", length));
			String[] bkgTrunkVvdOld = (JSPUtil.getParameter(request, prefix	+ "bkg_trunk_vvd_old", length));
			String[] deDueDtOld = (JSPUtil.getParameter(request, prefix	+ "de_due_dt_old", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] newCustAproFlg = (JSPUtil.getParameter(request, prefix	+ "new_cust_apro_flg", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix	+ "non_rt_sts_cd", length));
			String[] delCdOld = (JSPUtil.getParameter(request, prefix	+ "del_cd_old", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] preVvdCd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd_cd", length));
			String[] prgFlg = (JSPUtil.getParameter(request, prefix	+ "prg_flg", length));
			String[] crrSocFlg = (JSPUtil.getParameter(request, prefix	+ "crr_soc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgBookingInfoVO();
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (taaAvailable[i] != null)
					model.setTaaAvailable(taaAvailable[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (agmtActCntCd[i] != null)
					model.setAgmtActCntCd(agmtActCntCd[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (oldBkgNo[i] != null)
					model.setOldBkgNo(oldBkgNo[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (blFntOfcFlg[i] != null)
					model.setBlFntOfcFlg(blFntOfcFlg[i]);
				if (newCustAproMarkFlg[i] != null)
					model.setNewCustAproMarkFlg(newCustAproMarkFlg[i]);
				if (xterSiRefNo[i] != null)
					model.setXterSiRefNo(xterSiRefNo[i]);
				if (dcgoFlgOld[i] != null)
					model.setDcgoFlgOld(dcgoFlgOld[i]);
				if (mtyDorArrDtOld[i] != null)
					model.setMtyDorArrDtOld(mtyDorArrDtOld[i]);
				if (lodgDueDt[i] != null)
					model.setLodgDueDt(lodgDueDt[i]);
				if (ediHldFlg[i] != null)
					model.setEdiHldFlg(ediHldFlg[i]);
				if (awkFlg[i] != null)
					model.setAwkFlg(awkFlg[i]);
				if (spclHideFlg[i] != null)
					model.setSpclHideFlg(spclHideFlg[i]);
				if (partialVvdAssignFlg[i] != null)
					model.setPartialVvdAssignFlg(partialVvdAssignFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (preRlyPortYdCd[i] != null)
					model.setPreRlyPortYdCd(preRlyPortYdCd[i]);
				if (bkgPolYdCd[i] != null)
					model.setBkgPolYdCd(bkgPolYdCd[i]);
				if (waitRsn[i] != null)
					model.setWaitRsn(waitRsn[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (siCntcPsonPhnNo[i] != null)
					model.setSiCntcPsonPhnNo(siCntcPsonPhnNo[i]);
				if (lodgDueDtOld[i] != null)
					model.setLodgDueDtOld(lodgDueDtOld[i]);
				if (stopOffLocCd[i] != null)
					model.setStopOffLocCd(stopOffLocCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (fdGrdFlg[i] != null)
					model.setFdGrdFlg(fdGrdFlg[i]);
				if (spclHideLnrFlg[i] != null)
					model.setSpclHideLnrFlg(spclHideLnrFlg[i]);
				if (returnCd[i] != null)
					model.setReturnCd(returnCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (newCustAproRmk[i] != null)
					model.setNewCustAproRmk(newCustAproRmk[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (stopOffCntcPsonNm[i] != null)
					model.setStopOffCntcPsonNm(stopOffCntcPsonNm[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (porYdCdOld[i] != null)
					model.setPorYdCdOld(porYdCdOld[i]);
				if (mtyDorArrDt[i] != null)
					model.setMtyDorArrDt(mtyDorArrDt[i]);
				if (polCdOld[i] != null)
					model.setPolCdOld(polCdOld[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (pctlNoOld[i] != null)
					model.setPctlNoOld(pctlNoOld[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (firstPolCd[i] != null)
					model.setFirstPolCd(firstPolCd[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (bkgCntcPsonPhnNo[i] != null)
					model.setBkgCntcPsonPhnNo(bkgCntcPsonPhnNo[i]);
				if (ocpCd[i] != null)
					model.setOcpCd(ocpCd[i]);
				if (caUser[i] != null)
					model.setCaUser(caUser[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (vehCmdtFlg[i] != null)
					model.setVehCmdtFlg(vehCmdtFlg[i]);
				if (fumgLocCd[i] != null)
					model.setFumgLocCd(fumgLocCd[i]);
				if (eurTroCfm[i] != null)
					model.setEurTroCfm(eurTroCfm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rollOvrCnt[i] != null)
					model.setRollOvrCnt(rollOvrCnt[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (taaNoOld[i] != null)
					model.setTaaNoOld(taaNoOld[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (rfaNoOld[i] != null)
					model.setRfaNoOld(rfaNoOld[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (xterSiCd[i] != null)
					model.setXterSiCd(xterSiCd[i]);
				if (mtyPkupDt[i] != null)
					model.setMtyPkupDt(mtyPkupDt[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (bbCgoFlgOld[i] != null)
					model.setBbCgoFlgOld(bbCgoFlgOld[i]);
				if (pstVvdCd[i] != null)
					model.setPstVvdCd(pstVvdCd[i]);
				if (indivPsonFlg[i] != null)
					model.setIndivPsonFlg(indivPsonFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fumgCntcPhnNo[i] != null)
					model.setFumgCntcPhnNo(fumgCntcPhnNo[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (fullRtnYdCdOld[i] != null)
					model.setFullRtnYdCdOld(fullRtnYdCdOld[i]);
				if (xtnPhnNo[i] != null)
					model.setXtnPhnNo(xtnPhnNo[i]);
				if (mnlCctFlg[i] != null)
					model.setMnlCctFlg(mnlCctFlg[i]);
				if (siCntcPsonEml[i] != null)
					model.setSiCntcPsonEml(siCntcPsonEml[i]);
				if (stopOffDiffRmk[i] != null)
					model.setStopOffDiffRmk(stopOffDiffRmk[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (blDrftFaxOutFlg[i] != null)
					model.setBlDrftFaxOutFlg(blDrftFaxOutFlg[i]);
				if (idaHlgTpCd[i] != null)
					model.setIdaHlgTpCd(idaHlgTpCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (deTermCdOld[i] != null)
					model.setDeTermCdOld(deTermCdOld[i]);
				if (fumgDiffRmk[i] != null)
					model.setFumgDiffRmk(fumgDiffRmk[i]);
				if (delYdCdOld[i] != null)
					model.setDelYdCdOld(delYdCdOld[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgPorYdCd[i] != null)
					model.setBkgPorYdCd(bkgPorYdCd[i]);
				if (firstPolClptIndSeq[i] != null)
					model.setFirstPolClptIndSeq(firstPolClptIndSeq[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				if (firstVvdCd[i] != null)
					model.setFirstVvdCd(firstVvdCd[i]);
				if (tvvdModifyFlg[i] != null)
					model.setTvvdModifyFlg(tvvdModifyFlg[i]);
				if (bkgDelYdCd[i] != null)
					model.setBkgDelYdCd(bkgDelYdCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (awkCgoFlgOld[i] != null)
					model.setAwkCgoFlgOld(awkCgoFlgOld[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (blRtFlg[i] != null)
					model.setBlRtFlg(blRtFlg[i]);
				if (cmdtCdOld[i] != null)
					model.setCmdtCdOld(cmdtCdOld[i]);
				if (polYdCdOld[i] != null)
					model.setPolYdCdOld(polYdCdOld[i]);
				if (bkgCntcPsonFaxNo[i] != null)
					model.setBkgCntcPsonFaxNo(bkgCntcPsonFaxNo[i]);
				if (mtyPkupDtOld[i] != null)
					model.setMtyPkupDtOld(mtyPkupDtOld[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (fnlDestNm[i] != null)
					model.setFnlDestNm(fnlDestNm[i]);
				if (porCdOld[i] != null)
					model.setPorCdOld(porCdOld[i]);
				if (bbFlg[i] != null)
					model.setBbFlg(bbFlg[i]);
				if (refFlg[i] != null)
					model.setRefFlg(refFlg[i]);
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
				if (mnlBkgNoFlg[i] != null)
					model.setMnlBkgNoFlg(mnlBkgNoFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (orgScontiCd[i] != null)
					model.setOrgScontiCd(orgScontiCd[i]);
				if (agmtActCustSeq[i] != null)
					model.setAgmtActCustSeq(agmtActCustSeq[i]);
				if (bkgCntcPsonEml[i] != null)
					model.setBkgCntcPsonEml(bkgCntcPsonEml[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (deDueDt[i] != null)
					model.setDeDueDt(deDueDt[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (siCntcPsonFaxNo[i] != null)
					model.setSiCntcPsonFaxNo(siCntcPsonFaxNo[i]);
				if (stwgFlg[i] != null)
					model.setStwgFlg(stwgFlg[i]);
				if (splitRsnCd[i] != null)
					model.setSplitRsnCd(splitRsnCd[i]);
				if (newCustAproCmdtNm[i] != null)
					model.setNewCustAproCmdtNm(newCustAproCmdtNm[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (portSkpFlg[i] != null)
					model.setPortSkpFlg(portSkpFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (webSvcFlg[i] != null)
					model.setWebSvcFlg(webSvcFlg[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (rcvTermCdOld[i] != null)
					model.setRcvTermCdOld(rcvTermCdOld[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (isRatedFlg[i] != null)
					model.setIsRatedFlg(isRatedFlg[i]);
				if (mtyPkupYdCdOld[i] != null)
					model.setMtyPkupYdCdOld(mtyPkupYdCdOld[i]);
				if (actCustListExistFlg[i] != null)
					model.setActCustListExistFlg(actCustListExistFlg[i]);
				if (stopOffFlg[i] != null)
					model.setStopOffFlg(stopOffFlg[i]);
				if (bkgPodYdCd[i] != null)
					model.setBkgPodYdCd(bkgPodYdCd[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (filerCd[i] != null)
					model.setFilerCd(filerCd[i]);
				if (xterRqstAutoNtcFlg[i] != null)
					model.setXterRqstAutoNtcFlg(xterRqstAutoNtcFlg[i]);
				if (destScontiCd[i] != null)
					model.setDestScontiCd(destScontiCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (siCntcPsonMphnNo[i] != null)
					model.setSiCntcPsonMphnNo(siCntcPsonMphnNo[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (cntrFlg[i] != null)
					model.setCntrFlg(cntrFlg[i]);
				if (lastVvdCd[i] != null)
					model.setLastVvdCd(lastVvdCd[i]);
				if (rejectFlag[i] != null)
					model.setRejectFlag(rejectFlag[i]);
				if (blAudFlg[i] != null)
					model.setBlAudFlg(blAudFlg[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (bkgTrunkVvd[i] != null)
					model.setBkgTrunkVvd(bkgTrunkVvd[i]);
				if (podYdCdOld[i] != null)
					model.setPodYdCdOld(podYdCdOld[i]);
				if (nonDgChemFlg[i] != null)
					model.setNonDgChemFlg(nonDgChemFlg[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (xterBkgRqstCd[i] != null)
					model.setXterBkgRqstCd(xterBkgRqstCd[i]);
				if (blDocInpFlg[i] != null)
					model.setBlDocInpFlg(blDocInpFlg[i]);
				if (lastPodCd[i] != null)
					model.setLastPodCd(lastPodCd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (stopOffCntcPhnNo[i] != null)
					model.setStopOffCntcPhnNo(stopOffCntcPhnNo[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (rfaAvailable[i] != null)
					model.setRfaAvailable(rfaAvailable[i]);
				if (fumgCntcPsonNm[i] != null)
					model.setFumgCntcPsonNm(fumgCntcPsonNm[i]);
				if (xterBkgRqstRefNo[i] != null)
					model.setXterBkgRqstRefNo(xterBkgRqstRefNo[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (orgTrnsSvcModCd[i] != null)
					model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (pstRlyPortYdCd[i] != null)
					model.setPstRlyPortYdCd(pstRlyPortYdCd[i]);
				if (scNoOld[i] != null)
					model.setScNoOld(scNoOld[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (rcFlgOld[i] != null)
					model.setRcFlgOld(rcFlgOld[i]);
				if (bkgCntcPsonNm[i] != null)
					model.setBkgCntcPsonNm(bkgCntcPsonNm[i]);
				if (advShtgCd[i] != null)
					model.setAdvShtgCd(advShtgCd[i]);
				if (hotDeFlg[i] != null)
					model.setHotDeFlg(hotDeFlg[i]);
				if (eqSubstFlg[i] != null)
					model.setEqSubstFlg(eqSubstFlg[i]);
				if (vvdFlag[i] != null)
					model.setVvdFlag(vvdFlag[i]);
				if (fumgFlg[i] != null)
					model.setFumgFlg(fumgFlg[i]);
				if (fmcNo[i] != null)
					model.setFmcNo(fmcNo[i]);
				if (railBlkCd[i] != null)
					model.setRailBlkCd(railBlkCd[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (krCstmsCustTpCd[i] != null)
					model.setKrCstmsCustTpCd(krCstmsCustTpCd[i]);
				if (bkgCntcPsonMphnNo[i] != null)
					model.setBkgCntcPsonMphnNo(bkgCntcPsonMphnNo[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (siCntcPsonNm[i] != null)
					model.setSiCntcPsonNm(siCntcPsonNm[i]);
				if (scAvailable[i] != null)
					model.setScAvailable(scAvailable[i]);
				if (premiumAvailableFlg[i] != null)
					model.setPremiumAvailableFlg(premiumAvailableFlg[i]);
				if (lastPodClptIndSeq[i] != null)
					model.setLastPodClptIndSeq(lastPodClptIndSeq[i]);
				if (twnSoNo[i] != null)
					model.setTwnSoNo(twnSoNo[i]);
				if (bkgTrunkVvdOld[i] != null)
					model.setBkgTrunkVvdOld(bkgTrunkVvdOld[i]);
				if (deDueDtOld[i] != null)
					model.setDeDueDtOld(deDueDtOld[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (newCustAproFlg[i] != null)
					model.setNewCustAproFlg(newCustAproFlg[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (nonRtStsCd[i] != null)
					model.setNonRtStsCd(nonRtStsCd[i]);
				if (delCdOld[i] != null)
					model.setDelCdOld(delCdOld[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (preVvdCd[i] != null)
					model.setPreVvdCd(preVvdCd[i]);
				if (prgFlg[i] != null)
					model.setPrgFlg(prgFlg[i]);
				if (crrSocFlg[i] != null)
					model.setCrrSocFlg(crrSocFlg[i]);
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
	public BkgBookingInfoVO[] getBkgBookingInfoVOs(){
		BkgBookingInfoVO[] vos = (BkgBookingInfoVO[])models.toArray(new BkgBookingInfoVO[models.size()]);
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
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaAvailable = this.taaAvailable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCntCd = this.agmtActCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBkgNo = this.oldBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blFntOfcFlg = this.blFntOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCustAproMarkFlg = this.newCustAproMarkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiRefNo = this.xterSiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlgOld = this.dcgoFlgOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyDorArrDtOld = this.mtyDorArrDtOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDueDt = this.lodgDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHldFlg = this.ediHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkFlg = this.awkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideFlg = this.spclHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partialVvdAssignFlg = this.partialVvdAssignFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortYdCd = this.preRlyPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolYdCd = this.bkgPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitRsn = this.waitRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonPhnNo = this.siCntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDueDtOld = this.lodgDueDtOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffLocCd = this.stopOffLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdFlg = this.fdGrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideLnrFlg = this.spclHideLnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCd = this.returnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCustAproRmk = this.newCustAproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffCntcPsonNm = this.stopOffCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdCdOld = this.porYdCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyDorArrDt = this.mtyDorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdOld = this.polCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNoOld = this.pctlNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolCd = this.firstPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonPhnNo = this.bkgCntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocpCd = this.ocpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caUser = this.caUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vehCmdtFlg = this.vehCmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgLocCd = this.fumgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurTroCfm = this.eurTroCfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rollOvrCnt = this.rollOvrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNoOld = this.taaNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNoOld = this.rfaNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiCd = this.xterSiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDt = this.mtyPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlgOld = this.bbCgoFlgOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstVvdCd = this.pstVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indivPsonFlg = this.indivPsonFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgCntcPhnNo = this.fumgCntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCdOld = this.fullRtnYdCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xtnPhnNo = this.xtnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlCctFlg = this.mnlCctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonEml = this.siCntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffDiffRmk = this.stopOffDiffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFaxOutFlg = this.blDrftFaxOutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHlgTpCd = this.idaHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCdOld = this.deTermCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgDiffRmk = this.fumgDiffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCdOld = this.delYdCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorYdCd = this.bkgPorYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolClptIndSeq = this.firstPolClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstVvdCd = this.firstVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvdModifyFlg = this.tvvdModifyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelYdCd = this.bkgDelYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlgOld = this.awkCgoFlgOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtFlg = this.blRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCdOld = this.cmdtCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCdOld = this.polYdCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonFaxNo = this.bkgCntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDtOld = this.mtyPkupDtOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestNm = this.fnlDestNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCdOld = this.porCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbFlg = this.bbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refFlg = this.refFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgRmk = this.stwgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCdOld = this.podCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siFlg = this.siFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBkgNoFlg = this.mnlBkgNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgScontiCd = this.orgScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCustSeq = this.agmtActCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonEml = this.bkgCntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDueDt = this.deDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonFaxNo = this.siCntcPsonFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgFlg = this.stwgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitRsnCd = this.splitRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCustAproCmdtNm = this.newCustAproCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSkpFlg = this.portSkpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webSvcFlg = this.webSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCdOld = this.rcvTermCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPkupYdCd = this.fullPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isRatedFlg = this.isRatedFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCdOld = this.mtyPkupYdCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustListExistFlg = this.actCustListExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffFlg = this.stopOffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodYdCd = this.bkgPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filerCd = this.filerCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstAutoNtcFlg = this.xterRqstAutoNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destScontiCd = this.destScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonMphnNo = this.siCntcPsonMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFlg = this.cntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastVvdCd = this.lastVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectFlag = this.rejectFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAudFlg = this.blAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrunkVvd = this.bkgTrunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCdOld = this.podYdCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDgChemFlg = this.nonDgChemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstCd = this.xterBkgRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDocInpFlg = this.blDocInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodCd = this.lastPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stopOffCntcPhnNo = this.stopOffCntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaAvailable = this.rfaAvailable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgCntcPsonNm = this.fumgCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstRefNo = this.xterBkgRqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsSvcModCd = this.orgTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortYdCd = this.pstRlyPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNoOld = this.scNoOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlgOld = this.rcFlgOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonNm = this.bkgCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advShtgCd = this.advShtgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hotDeFlg = this.hotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstFlg = this.eqSubstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdFlag = this.vvdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgFlg = this.fumgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmcNo = this.fmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBlkCd = this.railBlkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCustTpCd = this.krCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonMphnNo = this.bkgCntcPsonMphnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonNm = this.siCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scAvailable = this.scAvailable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.premiumAvailableFlg = this.premiumAvailableFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodClptIndSeq = this.lastPodClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnSoNo = this.twnSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrunkVvdOld = this.bkgTrunkVvdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDueDtOld = this.deDueDtOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCustAproFlg = this.newCustAproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonRtStsCd = this.nonRtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCdOld = this.delCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvdCd = this.preVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prgFlg = this.prgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrSocFlg = this.crrSocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
