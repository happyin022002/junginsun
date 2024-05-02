/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TrsTrspRailBilOrdVO.java
 *@FileTitle : TrsTrspRailBilOrdVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 박준용
 *@LastVersion : 1.0
 * 2009.09.29 박준용 
 * 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * @author 박준용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsTrspRailBilOrdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TrsTrspRailBilOrdVO> models = new ArrayList<TrsTrspRailBilOrdVO>();

	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String provVndrSeq = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String destAvalDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fincVslCd = null;
	/* Column Info */
	private String itchgArrSplcLocNm = null;
	/* Column Info */
	private String trspFrstFlg = null;
	/* Column Info */
	private String depSplcCd = null;
	/* Column Info */
	private String ibdCstmsClrLocCd = null;
	/* Column Info */
	private String shprFaxNo = null;
	/* Column Info */
	private String bkgRcvdeTermCd = null;
	/* Column Info */
	private String coilShpFlg = null;
	/* Column Info */
	private String cxlRqstRsn = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgGateInDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String dwUpdDt = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String woIssDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String orgCopNo = null;
	/* Column Info */
	private String soProgCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String cntrPkupNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String orgGateOutDt = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String trspRqstOrdCfmFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String highValCgoTpCd = null;
	/* Column Info */
	private String orgBkgNo = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String fincSkdDirCd = null;
	/* Column Info */
	private String depSteCd = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String bkgNoRvisFlg = null;
	/* Column Info */
	private String logUpdDt = null;
	/* Column Info */
	private String provFaxNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String clmSghtCd = null;
	/* Column Info */
	private String rvisBkgNo = null;
	/* Column Info */
	private String rvisCopNo = null;
	/* Column Info */
	private String provPhnNo = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String lstFreeDt = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String arrSplcCd = null;
	/* Column Info */
	private String provCfmMzdCd = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String spndLangTpCd = null;
	/* Column Info */
	private String clmUpdStsCd = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String copEqNo = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String autoXptSysCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String lstNodPlnDt = null;
	/* Column Info */
	private String spndErrMsgCd = null;
	/* Column Info */
	private String depDt = null;
	/* Column Info */
	private String itchgSplcLocNm = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String inlndRoutRmk = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cxlRqstDt = null;
	/* Column Info */
	private String autoXptSysNo = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String n1stNodPlnDt = null;
	/* Column Info */
	private String rvisCostActGrpSeq = null;
	/* Column Info */
	private String cxlRqstRjctFlg = null;
	/* Column Info */
	private String eqTpCd = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String destGateOutDt = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrPkupYdCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String spclCgoCntrTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String corrFlg = null;
	/* Column Info */
	private String fcarNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bilIssStsCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String stndCmdtNo = null;
	/* Column Info */
	private String provUsrId = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String itchgGateInDt = null;
	/* Column Info */
	private String rvisEqNo = null;
	/* Column Info */
	private String ownrCoCd = null;
	/* Column Info */
	private String trspModTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cxlRqstRjctDt = null;
	/* Column Info */
	private String spndFlg = null;
	/* Column Info */
	private String trspMtyRqstDt = null;
	/* Column Info */
	private String delSccCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costActGrpCd = null;
	/* Column Info */
	private String clmCrrNm = null;
	/* Column Info */
	private String arrSteCd = null;
	/* Column Info */
	private String wgtMeasUtCd = null;
	/* Column Info */
	private String trspRqstOrdCfmDt = null;
	/* Column Info */
	private String ibdNo = null;
	/* Column Info */
	private String stelWireFlg = null;
	/* Column Info */
	private String arrLocNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String itchgDt = null;
	/* Column Info */
	private String ibdIpiLoclIndCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bilIssKnt = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String trspRqstBkgFlg = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String orgSplcLocNm = null;
	/* Column Info */
	private String trspMtyCostModCd = null;
	/* Column Info */
	private String itchgGateOutDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fumgFlg = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String nvoccFileNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cxlRqstRjctRsn = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String depLocNm = null;
	/* Column Info */
	private String provEml = null;
	/* Column Info */
	private String trspRailBilTpCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String blkFlg = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String railCmbThruTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String vdDt = null;
	/* Column Info */
	private String fincSkdVoyNo = null;
	/* Column Info */
	private String invBilPattDivFlg = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String cxlRqstFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String routPlnCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String trnNo = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String orgCostActGrpSeq = null;
	/* Column Info */
	private String tmlNodCd = null;
	/* Column Info */
	private String avalDt = null;
	/* Column Info */
	private String destGateInDt = null;
	/* Column Info */
	private String destLocNm = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String ntfyCustNm = null;
	/* Column Info */
	private String fmNodYard = null;
	/* Column Info */
	private String toNodYard = null;
	/* Column Info */
	private String trunkvvd = null;
	/* Column Info */
	private String podCdYard = null;
	/* Column Info */
	private String polCdYard = null;
	/* Column Info */
	private String porNodCdYard = null;
	/* Column Info */
	private String delNodCdYard = null;
	/* Column Info */
	private String n1stNodPlnDtHms = null;
	/* Column Info */
	private String lstNodPlnDtHms = null;
	/* Column Info */
	private String strCostActGrpCd = null;
	/* Column Info */
	private String strOfc = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String orgFmNodCd = null;
	/* Column Info */
	private String orgFmNodYard = null;
	/* Column Info */
	private String orgToNodCd = null;
	/* Column Info */
	private String orgToNodYard = null;
	/* Column Info */
	private String actGrpCd = null;
	/* Column Info */
	private String bkgSpe = null;
	/* Column Info */
	private String cmdtName = null;
	/* Column Info */
	private String RoutDtlSeq = null;
	/* Column Info */
	private String Expt = null;
	/* Column Info */
	private String Interchange1Loc = null;
	/* Column Info */
	private String Interchange2Loc = null;
	/* Column Info */
	private String rtrDivCnt = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String lnkOrgNodCd = null;
	/* Column Info */
	private String lnkDestNodCd = null;
	/* Column Info */
	private String trspAgmtOfcCtyCd = null;
	/* Column Info */
	private String trspAgmtSeq = null;
	/* Column Info */
	private String railRcvCoffFmDt = null;
	/* Column Info */
	private String railRcvCoffToDt = null;
	/* Column Info */
	private String gTime = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String stccCd = null;
	/* Column Info */
	private String stccDesc = null;
	/* Column Info */
	private String woExeDt = null;
	/* Column Info */
	private String cndCstmsClrFlg = null;
	/* Column Info */
	private String uplnSoFlg = null;
	/* Column Info */
	private String rvisIndFlg = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TrsTrspRailBilOrdVO() {
	}

	public TrsTrspRailBilOrdVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String railCmbThruTpCd, String trspSoStsCd, String trspRailBilTpCd, String costActGrpCd, String fmNodCd, String toNodCd, String vslCd, String skdVoyNo, String skdDirCd, String slanCd,
			String fincVslCd, String fincSkdVoyNo, String fincSkdDirCd, String routOrgNodCd, String routDestNodCd, String routSeq, String routPlnCd, String invBilPattDivFlg, String inlndRoutRmk, String eqTpCd, String eqNo, String eqTpszCd, String trspBndCd, String bkgNo, String blNo,
			String bkgCgoTpCd, String custCntCd, String custSeq, String trspCostDtlModCd, String trspMtyCostModCd, String n3ptyBilFlg, String cntrWgt, String wgtMeasUtCd, String pckTpCd, String pckQty, String cgoTpCd, String cmdtCd, String stndCmdtNo, String autoXptSysCd, String autoXptSysNo,
			String copNo, String costActGrpSeq, String spclCgoCntrTpCd, String ibdCstmsClrLocCd, String ibdIpiLoclIndCd, String ibdNo, String repoPlnId, String plnYrwk, String plnSeq, String refId, String refSeq, String porNodCd, String porCd, String polCd, String podCd, String delCd,
			String delNodCd, String podNodCd, String polNodCd, String delSccCd, String nvoccFileNo, String cntrSealNo, String cntrPkupNo, String cntrPkupYdCd, String shprCustNm, String cneeCustNm, String ntfyCustNm, String trspMtyRqstDt, String bkgRcvdeTermCd, String ownrCoCd, String lstmCd,
			String imdtExtFlg, String avalDt, String lstFreeDt, String n1stNodPlnDt, String lstNodPlnDt, String scNo, String soProgCd, String interRmk, String spclInstrRmk, String blkFlg, String stelWireFlg, String coilShpFlg, String fumgFlg, String spndErrMsgCd, String spndLangTpCd,
			String spndFlg, String shprFaxNo, String provUsrId, String provVndrSeq, String provPhnNo, String provFaxNo, String provEml, String provCfmMzdCd, String cxlRqstDt, String cxlRqstRsn, String cxlRqstFlg, String cxlRqstRjctRsn, String cxlRqstRjctFlg, String cxlRqstRjctDt,
			String orgSplcLocNm, String orgGateInDt, String orgGateOutDt, String destLocNm, String destGateInDt, String destAvalDt, String destGateOutDt, String itchgArrSplcLocNm, String itchgGateInDt, String itchgSplcLocNm, String itchgDt, String itchgGateOutDt, String arrDt, String arrLocNm,
			String arrSteCd, String arrSplcCd, String depDt, String depLocNm, String depSteCd, String depSplcCd, String tmlNodCd, String clmSghtCd, String trspModTpCd, String clmCrrNm, String trnNo, String fcarNo, String vdDt, String clmUpdStsCd, String trspRqstOrdCfmFlg, String trspRqstOrdCfmDt,
			String rvisCopNo, String rvisCostActGrpSeq, String rvisBkgNo, String rvisEqNo, String orgCopNo, String orgCostActGrpSeq, String orgBkgNo, String trspFrstFlg, String trspRqstBkgFlg, String highValCgoTpCd, String corrFlg, String woIssDt, String bilIssKnt, String bilIssStsCd,
			String deltFlg, String creOfcCd, String logUpdDt, String copEqNo, String bkgNoRvisFlg, String costOfcCd, String dwUpdDt, String creUsrId, String creDt, String updUsrId, String updDt, String loclCreDt, String loclUpdDt, String locCreDt, String locUpdDt, String fmNodYard,
			String toNodYard, String trunkvvd, String podCdYard, String polCdYard, String porNodCdYard, String delNodCdYard, String n1stNodPlnDtHms, String lstNodPlnDtHms, String strCostActGrpCd, String strOfc, String vndrSeq, String orgFmNodCd, String orgFmNodYard, String orgToNodCd,
			String orgToNodYard, String actGrpCd, String bkgSpe, String cmdtName, String RoutDtlSeq, String Expt, String Interchange1Loc, String Interchange2Loc, String rtrDivCnt, String blckStwgCd, String refNo, String lnkOrgNodCd, String lnkDestNodCd, String trspAgmtOfcCtyCd, String trspAgmtSeq,
			String railRcvCoffFmDt, String railRcvCoffToDt, String gTime, String eqKndCd, String stccCd, String stccDesc, String woExeDt, String cndCstmsClrFlg, String uplnSoFlg, String rvisIndFlg) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cgoTpCd = cgoTpCd;
		this.provVndrSeq = provVndrSeq;
		this.routOrgNodCd = routOrgNodCd;
		this.destAvalDt = destAvalDt;
		this.pagerows = pagerows;
		this.fincVslCd = fincVslCd;
		this.itchgArrSplcLocNm = itchgArrSplcLocNm;
		this.trspFrstFlg = trspFrstFlg;
		this.depSplcCd = depSplcCd;
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
		this.shprFaxNo = shprFaxNo;
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
		this.coilShpFlg = coilShpFlg;
		this.cxlRqstRsn = cxlRqstRsn;
		this.updUsrId = updUsrId;
		this.orgGateInDt = orgGateInDt;
		this.custCntCd = custCntCd;
		this.dwUpdDt = dwUpdDt;
		this.cntrWgt = cntrWgt;
		this.woIssDt = woIssDt;
		this.skdVoyNo = skdVoyNo;
		this.orgCopNo = orgCopNo;
		this.soProgCd = soProgCd;
		this.eqTpszCd = eqTpszCd;
		this.routSeq = routSeq;
		this.cntrPkupNo = cntrPkupNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.orgGateOutDt = orgGateOutDt;
		this.loclUpdDt = loclUpdDt;
		this.trspRqstOrdCfmFlg = trspRqstOrdCfmFlg;
		this.deltFlg = deltFlg;
		this.highValCgoTpCd = highValCgoTpCd;
		this.orgBkgNo = orgBkgNo;
		this.arrDt = arrDt;
		this.fincSkdDirCd = fincSkdDirCd;
		this.depSteCd = depSteCd;
		this.plnYrwk = plnYrwk;
		this.bkgNoRvisFlg = bkgNoRvisFlg;
		this.logUpdDt = logUpdDt;
		this.provFaxNo = provFaxNo;
		this.interRmk = interRmk;
		this.cmdtCd = cmdtCd;
		this.clmSghtCd = clmSghtCd;
		this.rvisBkgNo = rvisBkgNo;
		this.rvisCopNo = rvisCopNo;
		this.provPhnNo = provPhnNo;
		this.trspSoStsCd = trspSoStsCd;
		this.lstFreeDt = lstFreeDt;
		this.pckTpCd = pckTpCd;
		this.arrSplcCd = arrSplcCd;
		this.provCfmMzdCd = provCfmMzdCd;
		this.shprCustNm = shprCustNm;
		this.spndLangTpCd = spndLangTpCd;
		this.clmUpdStsCd = clmUpdStsCd;
		this.costOfcCd = costOfcCd;
		this.copEqNo = copEqNo;
		this.porNodCd = porNodCd;
		this.autoXptSysCd = autoXptSysCd;
		this.loclCreDt = loclCreDt;
		this.lstNodPlnDt = lstNodPlnDt;
		this.spndErrMsgCd = spndErrMsgCd;
		this.depDt = depDt;
		this.itchgSplcLocNm = itchgSplcLocNm;
		this.fmNodCd = fmNodCd;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.inlndRoutRmk = inlndRoutRmk;
		this.slanCd = slanCd;
		this.cxlRqstDt = cxlRqstDt;
		this.autoXptSysNo = autoXptSysNo;
		this.costActGrpSeq = costActGrpSeq;
		this.cneeCustNm = cneeCustNm;
		this.n1stNodPlnDt = n1stNodPlnDt;
		this.rvisCostActGrpSeq = rvisCostActGrpSeq;
		this.cxlRqstRjctFlg = cxlRqstRjctFlg;
		this.eqTpCd = eqTpCd;
		this.imdtExtFlg = imdtExtFlg;
		this.destGateOutDt = destGateOutDt;
		this.toNodCd = toNodCd;
		this.vslCd = vslCd;
		this.cntrPkupYdCd = cntrPkupYdCd;
		this.trspSoSeq = trspSoSeq;
		this.copNo = copNo;
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
		this.blNo = blNo;
		this.corrFlg = corrFlg;
		this.fcarNo = fcarNo;
		this.polCd = polCd;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.scNo = scNo;
		this.bilIssStsCd = bilIssStsCd;
		this.delNodCd = delNodCd;
		this.stndCmdtNo = stndCmdtNo;
		this.provUsrId = provUsrId;
		this.lstmCd = lstmCd;
		this.itchgGateInDt = itchgGateInDt;
		this.rvisEqNo = rvisEqNo;
		this.ownrCoCd = ownrCoCd;
		this.trspModTpCd = trspModTpCd;
		this.delCd = delCd;
		this.cxlRqstRjctDt = cxlRqstRjctDt;
		this.spndFlg = spndFlg;
		this.trspMtyRqstDt = trspMtyRqstDt;
		this.delSccCd = delSccCd;
		this.creUsrId = creUsrId;
		this.costActGrpCd = costActGrpCd;
		this.clmCrrNm = clmCrrNm;
		this.arrSteCd = arrSteCd;
		this.wgtMeasUtCd = wgtMeasUtCd;
		this.trspRqstOrdCfmDt = trspRqstOrdCfmDt;
		this.ibdNo = ibdNo;
		this.stelWireFlg = stelWireFlg;
		this.arrLocNm = arrLocNm;
		this.porCd = porCd;
		this.itchgDt = itchgDt;
		this.ibdIpiLoclIndCd = ibdIpiLoclIndCd;
		this.creDt = creDt;
		this.bilIssKnt = bilIssKnt;
		this.refId = refId;
		this.trspRqstBkgFlg = trspRqstBkgFlg;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.orgSplcLocNm = orgSplcLocNm;
		this.trspMtyCostModCd = trspMtyCostModCd;
		this.itchgGateOutDt = itchgGateOutDt;
		this.ibflag = ibflag;
		this.fumgFlg = fumgFlg;
		this.eqNo = eqNo;
		this.nvoccFileNo = nvoccFileNo;
		this.creOfcCd = creOfcCd;
		this.cxlRqstRjctRsn = cxlRqstRjctRsn;
		this.pckQty = pckQty;
		this.depLocNm = depLocNm;
		this.provEml = provEml;
		this.trspRailBilTpCd = trspRailBilTpCd;
		this.routDestNodCd = routDestNodCd;
		this.blkFlg = blkFlg;
		this.spclInstrRmk = spclInstrRmk;
		this.railCmbThruTpCd = railCmbThruTpCd;
		this.updDt = updDt;
		this.trspBndCd = trspBndCd;
		this.vdDt = vdDt;
		this.fincSkdVoyNo = fincSkdVoyNo;
		this.invBilPattDivFlg = invBilPattDivFlg;
		this.plnSeq = plnSeq;
		this.polNodCd = polNodCd;
		this.cxlRqstFlg = cxlRqstFlg;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.routPlnCd = routPlnCd;
		this.repoPlnId = repoPlnId;
		this.trnNo = trnNo;
		this.refSeq = refSeq;
		this.orgCostActGrpSeq = orgCostActGrpSeq;
		this.tmlNodCd = tmlNodCd;
		this.avalDt = avalDt;
		this.destGateInDt = destGateInDt;
		this.destLocNm = destLocNm;
		this.cntrSealNo = cntrSealNo;
		this.ntfyCustNm = ntfyCustNm;
		this.fmNodYard = fmNodYard;
		this.toNodYard = toNodYard;
		this.trunkvvd = trunkvvd;
		this.podCdYard = podCdYard;
		this.polCdYard = polCdYard;
		this.podCdYard = porNodCdYard;
		this.polCdYard = delNodCdYard;
		this.n1stNodPlnDtHms = n1stNodPlnDtHms;
		this.lstNodPlnDtHms = lstNodPlnDtHms;
		this.strCostActGrpCd = strCostActGrpCd;
		this.strOfc = strOfc;
		this.vndrSeq = vndrSeq;
		this.orgFmNodCd = orgFmNodCd;
		this.orgFmNodYard = orgFmNodYard;
		this.orgToNodCd = orgToNodCd;
		this.orgToNodYard = orgToNodYard;
		this.actGrpCd = actGrpCd;
		this.bkgSpe = bkgSpe;
		this.cmdtName = cmdtName;
		this.RoutDtlSeq = RoutDtlSeq;
		this.Expt = Expt;
		this.Interchange1Loc = Interchange1Loc;
		this.Interchange2Loc = Interchange2Loc;
		this.rtrDivCnt = rtrDivCnt;
		this.blckStwgCd = blckStwgCd;
		this.refNo = refNo;
		this.lnkOrgNodCd = lnkOrgNodCd;
		this.lnkDestNodCd = lnkDestNodCd;
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
		this.trspAgmtSeq = trspAgmtSeq;
		this.railRcvCoffFmDt = railRcvCoffFmDt;
		this.railRcvCoffToDt = railRcvCoffToDt;
		this.gTime = gTime;
		this.eqKndCd = eqKndCd;
		this.stccCd = stccCd;
		this.stccDesc = stccDesc;
		this.woExeDt = woExeDt;
		this.cndCstmsClrFlg = cndCstmsClrFlg;
		this.uplnSoFlg = uplnSoFlg;
		this.rvisIndFlg = rvisIndFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("prov_vndr_seq", getProvVndrSeq());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("dest_aval_dt", getDestAvalDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("finc_vsl_cd", getFincVslCd());
		this.hashColumns.put("itchg_arr_splc_loc_nm", getItchgArrSplcLocNm());
		this.hashColumns.put("trsp_frst_flg", getTrspFrstFlg());
		this.hashColumns.put("dep_splc_cd", getDepSplcCd());
		this.hashColumns.put("ibd_cstms_clr_loc_cd", getIbdCstmsClrLocCd());
		this.hashColumns.put("shpr_fax_no", getShprFaxNo());
		this.hashColumns.put("bkg_rcvde_term_cd", getBkgRcvdeTermCd());
		this.hashColumns.put("coil_shp_flg", getCoilShpFlg());
		this.hashColumns.put("cxl_rqst_rsn", getCxlRqstRsn());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_gate_in_dt", getOrgGateInDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dw_upd_dt", getDwUpdDt());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("wo_iss_dt", getWoIssDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("org_cop_no", getOrgCopNo());
		this.hashColumns.put("so_prog_cd", getSoProgCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("cntr_pkup_no", getCntrPkupNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("org_gate_out_dt", getOrgGateOutDt());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("trsp_rqst_ord_cfm_flg", getTrspRqstOrdCfmFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("high_val_cgo_tp_cd", getHighValCgoTpCd());
		this.hashColumns.put("org_bkg_no", getOrgBkgNo());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("finc_skd_dir_cd", getFincSkdDirCd());
		this.hashColumns.put("dep_ste_cd", getDepSteCd());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("bkg_no_rvis_flg", getBkgNoRvisFlg());
		this.hashColumns.put("log_upd_dt", getLogUpdDt());
		this.hashColumns.put("prov_fax_no", getProvFaxNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("clm_sght_cd", getClmSghtCd());
		this.hashColumns.put("rvis_bkg_no", getRvisBkgNo());
		this.hashColumns.put("rvis_cop_no", getRvisCopNo());
		this.hashColumns.put("prov_phn_no", getProvPhnNo());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("lst_free_dt", getLstFreeDt());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("arr_splc_cd", getArrSplcCd());
		this.hashColumns.put("prov_cfm_mzd_cd", getProvCfmMzdCd());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("spnd_lang_tp_cd", getSpndLangTpCd());
		this.hashColumns.put("clm_upd_sts_cd", getClmUpdStsCd());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("cop_eq_no", getCopEqNo());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("auto_xpt_sys_cd", getAutoXptSysCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("spnd_err_msg_cd", getSpndErrMsgCd());
		this.hashColumns.put("dep_dt", getDepDt());
		this.hashColumns.put("itchg_splc_loc_nm", getItchgSplcLocNm());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("inlnd_rout_rmk", getInlndRoutRmk());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cxl_rqst_dt", getCxlRqstDt());
		this.hashColumns.put("auto_xpt_sys_no", getAutoXptSysNo());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("n1st_nod_pln_dt", getN1stNodPlnDt());
		this.hashColumns.put("rvis_cost_act_grp_seq", getRvisCostActGrpSeq());
		this.hashColumns.put("cxl_rqst_rjct_flg", getCxlRqstRjctFlg());
		this.hashColumns.put("eq_tp_cd", getEqTpCd());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("dest_gate_out_dt", getDestGateOutDt());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_pkup_yd_cd", getCntrPkupYdCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("spcl_cgo_cntr_tp_cd", getSpclCgoCntrTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("corr_flg", getCorrFlg());
		this.hashColumns.put("fcar_no", getFcarNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bil_iss_sts_cd", getBilIssStsCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("stnd_cmdt_no", getStndCmdtNo());
		this.hashColumns.put("prov_usr_id", getProvUsrId());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("itchg_gate_in_dt", getItchgGateInDt());
		this.hashColumns.put("rvis_eq_no", getRvisEqNo());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("trsp_mod_tp_cd", getTrspModTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cxl_rqst_rjct_dt", getCxlRqstRjctDt());
		this.hashColumns.put("spnd_flg", getSpndFlg());
		this.hashColumns.put("trsp_mty_rqst_dt", getTrspMtyRqstDt());
		this.hashColumns.put("del_scc_cd", getDelSccCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_act_grp_cd", getCostActGrpCd());
		this.hashColumns.put("clm_crr_nm", getClmCrrNm());
		this.hashColumns.put("arr_ste_cd", getArrSteCd());
		this.hashColumns.put("wgt_meas_ut_cd", getWgtMeasUtCd());
		this.hashColumns.put("trsp_rqst_ord_cfm_dt", getTrspRqstOrdCfmDt());
		this.hashColumns.put("ibd_no", getIbdNo());
		this.hashColumns.put("stel_wire_flg", getStelWireFlg());
		this.hashColumns.put("arr_loc_nm", getArrLocNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("itchg_dt", getItchgDt());
		this.hashColumns.put("ibd_ipi_locl_ind_cd", getIbdIpiLoclIndCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bil_iss_knt", getBilIssKnt());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("trsp_rqst_bkg_flg", getTrspRqstBkgFlg());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("org_splc_loc_nm", getOrgSplcLocNm());
		this.hashColumns.put("trsp_mty_cost_mod_cd", getTrspMtyCostModCd());
		this.hashColumns.put("itchg_gate_out_dt", getItchgGateOutDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fumg_flg", getFumgFlg());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("nvocc_file_no", getNvoccFileNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cxl_rqst_rjct_rsn", getCxlRqstRjctRsn());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("dep_loc_nm", getDepLocNm());
		this.hashColumns.put("prov_eml", getProvEml());
		this.hashColumns.put("trsp_rail_bil_tp_cd", getTrspRailBilTpCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("blk_flg", getBlkFlg());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("rail_cmb_thru_tp_cd", getRailCmbThruTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("vd_dt", getVdDt());
		this.hashColumns.put("finc_skd_voy_no", getFincSkdVoyNo());
		this.hashColumns.put("inv_bil_patt_div_flg", getInvBilPattDivFlg());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("cxl_rqst_flg", getCxlRqstFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("trn_no", getTrnNo());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("org_cost_act_grp_seq", getOrgCostActGrpSeq());
		this.hashColumns.put("tml_nod_cd", getTmlNodCd());
		this.hashColumns.put("aval_dt", getAvalDt());
		this.hashColumns.put("dest_gate_in_dt", getDestGateInDt());
		this.hashColumns.put("dest_loc_nm", getDestLocNm());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("trunkvvd", getTrunkvvd());
		this.hashColumns.put("pod_cd_yard", getPodCdYard());
		this.hashColumns.put("pol_cd_yard", getPolCdYard());
		this.hashColumns.put("por_nod_cd_yard", getPorNodCdYard());
		this.hashColumns.put("del_nod_cd_yard", getDelNodCdYard());
		this.hashColumns.put("n1st_nod_pln_dt_hms", getN1stNodPlnDtHms());
		this.hashColumns.put("lst_nod_pln_dt_hms", getLstNodPlnDtHms());
		this.hashColumns.put("strCostActGrpCd", getStrCostActGrpCd());
		this.hashColumns.put("strOfc", getStrOfc());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("org_fm_nod_cd", getOrgFmNodCd());
		this.hashColumns.put("org_fm_nod_yard", getOrgFmNodYard());
		this.hashColumns.put("org_to_nod_cd", getOrgToNodCd());
		this.hashColumns.put("org_to_nod_yard", getOrgToNodYard());
		this.hashColumns.put("act_grp_cd", getActGrpCd());
		this.hashColumns.put("bkg_spe", getBkgSpe());
		this.hashColumns.put("cmdt_name", getCmdtName());
		this.hashColumns.put("rout_dtl_seq", getRoutDtlSeq());
		this.hashColumns.put("expt", getExpt());
		this.hashColumns.put("interchange1_loc", getInterchange1Loc());
		this.hashColumns.put("interchange2_loc", getInterchange2Loc());
		this.hashColumns.put("rtr_div_cnt", getRtrDivCnt());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("lnk_org_nod_cd", getLnkOrgNodCd());
		this.hashColumns.put("lnk_dest_nod_cd", getLnkDestNodCd());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd", getTrspAgmtOfcCtyCd());
		this.hashColumns.put("trsp_agmt_seq", getTrspAgmtSeq());
		this.hashColumns.put("rail_rcv_coff_fm_dt", getRailRcvCoffFmDt());
		this.hashColumns.put("rail_rcv_coff_to_dt", getRailRcvCoffToDt());
		this.hashColumns.put("g_time", getGTime());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("stcc_cd", getStccCd());
		this.hashColumns.put("stcc_desc", getStccDesc());
		this.hashColumns.put("wo_exe_dt", getWoExeDt());
		this.hashColumns.put("cnd_cstms_clr_flg", getCndCstmsClrFlg());
		this.hashColumns.put("upln_so_flg", getUplnSoFlg());
		this.hashColumns.put("rvis_ind_flg", getRvisIndFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("prov_vndr_seq", "provVndrSeq");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("dest_aval_dt", "destAvalDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("finc_vsl_cd", "fincVslCd");
		this.hashFields.put("itchg_arr_splc_loc_nm", "itchgArrSplcLocNm");
		this.hashFields.put("trsp_frst_flg", "trspFrstFlg");
		this.hashFields.put("dep_splc_cd", "depSplcCd");
		this.hashFields.put("ibd_cstms_clr_loc_cd", "ibdCstmsClrLocCd");
		this.hashFields.put("shpr_fax_no", "shprFaxNo");
		this.hashFields.put("bkg_rcvde_term_cd", "bkgRcvdeTermCd");
		this.hashFields.put("coil_shp_flg", "coilShpFlg");
		this.hashFields.put("cxl_rqst_rsn", "cxlRqstRsn");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_gate_in_dt", "orgGateInDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dw_upd_dt", "dwUpdDt");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("wo_iss_dt", "woIssDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("org_cop_no", "orgCopNo");
		this.hashFields.put("so_prog_cd", "soProgCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("cntr_pkup_no", "cntrPkupNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("org_gate_out_dt", "orgGateOutDt");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("trsp_rqst_ord_cfm_flg", "trspRqstOrdCfmFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("high_val_cgo_tp_cd", "highValCgoTpCd");
		this.hashFields.put("org_bkg_no", "orgBkgNo");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("finc_skd_dir_cd", "fincSkdDirCd");
		this.hashFields.put("dep_ste_cd", "depSteCd");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("bkg_no_rvis_flg", "bkgNoRvisFlg");
		this.hashFields.put("log_upd_dt", "logUpdDt");
		this.hashFields.put("prov_fax_no", "provFaxNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("clm_sght_cd", "clmSghtCd");
		this.hashFields.put("rvis_bkg_no", "rvisBkgNo");
		this.hashFields.put("rvis_cop_no", "rvisCopNo");
		this.hashFields.put("prov_phn_no", "provPhnNo");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("lst_free_dt", "lstFreeDt");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("arr_splc_cd", "arrSplcCd");
		this.hashFields.put("prov_cfm_mzd_cd", "provCfmMzdCd");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("spnd_lang_tp_cd", "spndLangTpCd");
		this.hashFields.put("clm_upd_sts_cd", "clmUpdStsCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("cop_eq_no", "copEqNo");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("auto_xpt_sys_cd", "autoXptSysCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("spnd_err_msg_cd", "spndErrMsgCd");
		this.hashFields.put("dep_dt", "depDt");
		this.hashFields.put("itchg_splc_loc_nm", "itchgSplcLocNm");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("inlnd_rout_rmk", "inlndRoutRmk");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cxl_rqst_dt", "cxlRqstDt");
		this.hashFields.put("auto_xpt_sys_no", "autoXptSysNo");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("n1st_nod_pln_dt", "n1stNodPlnDt");
		this.hashFields.put("rvis_cost_act_grp_seq", "rvisCostActGrpSeq");
		this.hashFields.put("cxl_rqst_rjct_flg", "cxlRqstRjctFlg");
		this.hashFields.put("eq_tp_cd", "eqTpCd");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("dest_gate_out_dt", "destGateOutDt");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_pkup_yd_cd", "cntrPkupYdCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("spcl_cgo_cntr_tp_cd", "spclCgoCntrTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("corr_flg", "corrFlg");
		this.hashFields.put("fcar_no", "fcarNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bil_iss_sts_cd", "bilIssStsCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("stnd_cmdt_no", "stndCmdtNo");
		this.hashFields.put("prov_usr_id", "provUsrId");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("itchg_gate_in_dt", "itchgGateInDt");
		this.hashFields.put("rvis_eq_no", "rvisEqNo");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("trsp_mod_tp_cd", "trspModTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cxl_rqst_rjct_dt", "cxlRqstRjctDt");
		this.hashFields.put("spnd_flg", "spndFlg");
		this.hashFields.put("trsp_mty_rqst_dt", "trspMtyRqstDt");
		this.hashFields.put("del_scc_cd", "delSccCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_act_grp_cd", "costActGrpCd");
		this.hashFields.put("clm_crr_nm", "clmCrrNm");
		this.hashFields.put("arr_ste_cd", "arrSteCd");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("trsp_rqst_ord_cfm_dt", "trspRqstOrdCfmDt");
		this.hashFields.put("ibd_no", "ibdNo");
		this.hashFields.put("stel_wire_flg", "stelWireFlg");
		this.hashFields.put("arr_loc_nm", "arrLocNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("itchg_dt", "itchgDt");
		this.hashFields.put("ibd_ipi_locl_ind_cd", "ibdIpiLoclIndCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bil_iss_knt", "bilIssKnt");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("trsp_rqst_bkg_flg", "trspRqstBkgFlg");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("org_splc_loc_nm", "orgSplcLocNm");
		this.hashFields.put("trsp_mty_cost_mod_cd", "trspMtyCostModCd");
		this.hashFields.put("itchg_gate_out_dt", "itchgGateOutDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fumg_flg", "fumgFlg");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("nvocc_file_no", "nvoccFileNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cxl_rqst_rjct_rsn", "cxlRqstRjctRsn");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("dep_loc_nm", "depLocNm");
		this.hashFields.put("prov_eml", "provEml");
		this.hashFields.put("trsp_rail_bil_tp_cd", "trspRailBilTpCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("blk_flg", "blkFlg");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("rail_cmb_thru_tp_cd", "railCmbThruTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("vd_dt", "vdDt");
		this.hashFields.put("finc_skd_voy_no", "fincSkdVoyNo");
		this.hashFields.put("inv_bil_patt_div_flg", "invBilPattDivFlg");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("cxl_rqst_flg", "cxlRqstFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("trn_no", "trnNo");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("org_cost_act_grp_seq", "orgCostActGrpSeq");
		this.hashFields.put("tml_nod_cd", "tmlNodCd");
		this.hashFields.put("aval_dt", "avalDt");
		this.hashFields.put("dest_gate_in_dt", "destGateInDt");
		this.hashFields.put("dest_loc_nm", "destLocNm");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("fm_nod_yard", "fmNodYard");
		this.hashFields.put("to_nod_yard", "toNodYard");
		this.hashFields.put("trunkvvd", "trunkvvd");
		this.hashFields.put("pod_cd_yard", "podCdYard");
		this.hashFields.put("pol_cd_yard", "polCdYard");
		this.hashFields.put("por_nod_cd_yard", "porNodCdYard");
		this.hashFields.put("del_nod_cd_yard", "delNodCdYard");
		this.hashFields.put("n1st_nod_pln_dt_hms", "n1stNodPlnDtHms");
		this.hashFields.put("lst_nod_pln_dt_hms", "lstNodPlnDtHms");
		this.hashFields.put("strCostActGrpCd", "strCostActGrpCd");
		this.hashFields.put("strOfc", "strOfc");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("org_fm_nod_cd", "orgFmNodCd");
		this.hashFields.put("org_fm_nod_yard", "orgFmNodYard");
		this.hashFields.put("org_to_nod_cd", "orgToNodCd");
		this.hashFields.put("org_to_nod_yard", "orgToNodYard");
		this.hashFields.put("act_grp_cd", "actGrpCd");
		this.hashFields.put("bkg_spe", "bkgSpe");
		this.hashFields.put("cmdt_name", "cmdtName");
		this.hashFields.put("rout_dtl_seq", "RoutDtlSeq");
		this.hashFields.put("expt", "Expt");
		this.hashFields.put("interchange1_loc", "Interchange1Loc");
		this.hashFields.put("interchange2_loc", "Interchange2Loc");
		this.hashFields.put("rtr_div_cnt", "rtrDivCnt");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lnk_org_nod_cd", "lnkOrgNodCd");
		this.hashFields.put("lnk_dest_nod_cd", "lnkDestNodCd");
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("rail_rcv_coff_fm_dt", "railRcvCoffFmDt");
		this.hashFields.put("rail_rcv_coff_to_dt", "railRcvCoffToDt");
		this.hashFields.put("g_time", "gTime");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("stcc_cd", "stccCd");
		this.hashFields.put("stcc_desc", "stccDesc");
		this.hashFields.put("wo_exe_dt", "woExeDt");
		this.hashFields.put("cnd_cstms_clr_flg", "cndCstmsClrFlg");
		this.hashFields.put("upln_so_flg", "uplnSoFlg");
		this.hashFields.put("rvis_ind_flg", "rvisIndFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return provVndrSeq
	 */
	public String getProvVndrSeq() {
		return this.provVndrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return destAvalDt
	 */
	public String getDestAvalDt() {
		return this.destAvalDt;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return fincVslCd
	 */
	public String getFincVslCd() {
		return this.fincVslCd;
	}

	/**
	 * Column Info
	 * 
	 * @return itchgArrSplcLocNm
	 */
	public String getItchgArrSplcLocNm() {
		return this.itchgArrSplcLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @return trspFrstFlg
	 */
	public String getTrspFrstFlg() {
		return this.trspFrstFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return depSplcCd
	 */
	public String getDepSplcCd() {
		return this.depSplcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ibdCstmsClrLocCd
	 */
	public String getIbdCstmsClrLocCd() {
		return this.ibdCstmsClrLocCd;
	}

	/**
	 * Column Info
	 * 
	 * @return shprFaxNo
	 */
	public String getShprFaxNo() {
		return this.shprFaxNo;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgRcvdeTermCd
	 */
	public String getBkgRcvdeTermCd() {
		return this.bkgRcvdeTermCd;
	}

	/**
	 * Column Info
	 * 
	 * @return coilShpFlg
	 */
	public String getCoilShpFlg() {
		return this.coilShpFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstRsn
	 */
	public String getCxlRqstRsn() {
		return this.cxlRqstRsn;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return orgGateInDt
	 */
	public String getOrgGateInDt() {
		return this.orgGateInDt;
	}

	/**
	 * Column Info
	 * 
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @return dwUpdDt
	 */
	public String getDwUpdDt() {
		return this.dwUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * 
	 * @return woIssDt
	 */
	public String getWoIssDt() {
		return this.woIssDt;
	}

	/**
	 * Column Info
	 * 
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @return orgCopNo
	 */
	public String getOrgCopNo() {
		return this.orgCopNo;
	}

	/**
	 * Column Info
	 * 
	 * @return soProgCd
	 */
	public String getSoProgCd() {
		return this.soProgCd;
	}

	/**
	 * Column Info
	 * 
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrPkupNo
	 */
	public String getCntrPkupNo() {
		return this.cntrPkupNo;
	}

	/**
	 * Column Info
	 * 
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return orgGateOutDt
	 */
	public String getOrgGateOutDt() {
		return this.orgGateOutDt;
	}

	/**
	 * Column Info
	 * 
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return trspRqstOrdCfmFlg
	 */
	public String getTrspRqstOrdCfmFlg() {
		return this.trspRqstOrdCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return highValCgoTpCd
	 */
	public String getHighValCgoTpCd() {
		return this.highValCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return orgBkgNo
	 */
	public String getOrgBkgNo() {
		return this.orgBkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}

	/**
	 * Column Info
	 * 
	 * @return fincSkdDirCd
	 */
	public String getFincSkdDirCd() {
		return this.fincSkdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return depSteCd
	 */
	public String getDepSteCd() {
		return this.depSteCd;
	}

	/**
	 * Column Info
	 * 
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNoRvisFlg
	 */
	public String getBkgNoRvisFlg() {
		return this.bkgNoRvisFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return logUpdDt
	 */
	public String getLogUpdDt() {
		return this.logUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return provFaxNo
	 */
	public String getProvFaxNo() {
		return this.provFaxNo;
	}

	/**
	 * Column Info
	 * 
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * 
	 * @return clmSghtCd
	 */
	public String getClmSghtCd() {
		return this.clmSghtCd;
	}

	/**
	 * Column Info
	 * 
	 * @return rvisBkgNo
	 */
	public String getRvisBkgNo() {
		return this.rvisBkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @return rvisCopNo
	 */
	public String getRvisCopNo() {
		return this.rvisCopNo;
	}

	/**
	 * Column Info
	 * 
	 * @return provPhnNo
	 */
	public String getProvPhnNo() {
		return this.provPhnNo;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return lstFreeDt
	 */
	public String getLstFreeDt() {
		return this.lstFreeDt;
	}

	/**
	 * Column Info
	 * 
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return arrSplcCd
	 */
	public String getArrSplcCd() {
		return this.arrSplcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return provCfmMzdCd
	 */
	public String getProvCfmMzdCd() {
		return this.provCfmMzdCd;
	}

	/**
	 * Column Info
	 * 
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @return spndLangTpCd
	 */
	public String getSpndLangTpCd() {
		return this.spndLangTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return clmUpdStsCd
	 */
	public String getClmUpdStsCd() {
		return this.clmUpdStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return copEqNo
	 */
	public String getCopEqNo() {
		return this.copEqNo;
	}

	/**
	 * Column Info
	 * 
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return autoXptSysCd
	 */
	public String getAutoXptSysCd() {
		return this.autoXptSysCd;
	}

	/**
	 * Column Info
	 * 
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}

	/**
	 * Column Info
	 * 
	 * @return lstNodPlnDt
	 */
	public String getLstNodPlnDt() {
		return this.lstNodPlnDt;
	}

	/**
	 * Column Info
	 * 
	 * @return spndErrMsgCd
	 */
	public String getSpndErrMsgCd() {
		return this.spndErrMsgCd;
	}

	/**
	 * Column Info
	 * 
	 * @return depDt
	 */
	public String getDepDt() {
		return this.depDt;
	}

	/**
	 * Column Info
	 * 
	 * @return itchgSplcLocNm
	 */
	public String getItchgSplcLocNm() {
		return this.itchgSplcLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return inlndRoutRmk
	 */
	public String getInlndRoutRmk() {
		return this.inlndRoutRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstDt
	 */
	public String getCxlRqstDt() {
		return this.cxlRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @return autoXptSysNo
	 */
	public String getAutoXptSysNo() {
		return this.autoXptSysNo;
	}

	/**
	 * Column Info
	 * 
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return cneeCustNm
	 */
	public String getCneeCustNm() {
		return this.cneeCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @return n1stNodPlnDt
	 */
	public String getN1stNodPlnDt() {
		return this.n1stNodPlnDt;
	}

	/**
	 * Column Info
	 * 
	 * @return rvisCostActGrpSeq
	 */
	public String getRvisCostActGrpSeq() {
		return this.rvisCostActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstRjctFlg
	 */
	public String getCxlRqstRjctFlg() {
		return this.cxlRqstRjctFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return eqTpCd
	 */
	public String getEqTpCd() {
		return this.eqTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return destGateOutDt
	 */
	public String getDestGateOutDt() {
		return this.destGateOutDt;
	}

	/**
	 * Column Info
	 * 
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrPkupYdCd
	 */
	public String getCntrPkupYdCd() {
		return this.cntrPkupYdCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}

	/**
	 * Column Info
	 * 
	 * @return spclCgoCntrTpCd
	 */
	public String getSpclCgoCntrTpCd() {
		return this.spclCgoCntrTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * 
	 * @return corrFlg
	 */
	public String getCorrFlg() {
		return this.corrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return fcarNo
	 */
	public String getFcarNo() {
		return this.fcarNo;
	}

	/**
	 * Column Info
	 * 
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}

	/**
	 * Column Info
	 * 
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}

	/**
	 * Column Info
	 * 
	 * @return bilIssStsCd
	 */
	public String getBilIssStsCd() {
		return this.bilIssStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return stndCmdtNo
	 */
	public String getStndCmdtNo() {
		return this.stndCmdtNo;
	}

	/**
	 * Column Info
	 * 
	 * @return provUsrId
	 */
	public String getProvUsrId() {
		return this.provUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}

	/**
	 * Column Info
	 * 
	 * @return itchgGateInDt
	 */
	public String getItchgGateInDt() {
		return this.itchgGateInDt;
	}

	/**
	 * Column Info
	 * 
	 * @return rvisEqNo
	 */
	public String getRvisEqNo() {
		return this.rvisEqNo;
	}

	/**
	 * Column Info
	 * 
	 * @return ownrCoCd
	 */
	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspModTpCd
	 */
	public String getTrspModTpCd() {
		return this.trspModTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstRjctDt
	 */
	public String getCxlRqstRjctDt() {
		return this.cxlRqstRjctDt;
	}

	/**
	 * Column Info
	 * 
	 * @return spndFlg
	 */
	public String getSpndFlg() {
		return this.spndFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return trspMtyRqstDt
	 */
	public String getTrspMtyRqstDt() {
		return this.trspMtyRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @return delSccCd
	 */
	public String getDelSccCd() {
		return this.delSccCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return costActGrpCd
	 */
	public String getCostActGrpCd() {
		return this.costActGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return clmCrrNm
	 */
	public String getClmCrrNm() {
		return this.clmCrrNm;
	}

	/**
	 * Column Info
	 * 
	 * @return arrSteCd
	 */
	public String getArrSteCd() {
		return this.arrSteCd;
	}

	/**
	 * Column Info
	 * 
	 * @return wgtMeasUtCd
	 */
	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspRqstOrdCfmDt
	 */
	public String getTrspRqstOrdCfmDt() {
		return this.trspRqstOrdCfmDt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibdNo
	 */
	public String getIbdNo() {
		return this.ibdNo;
	}

	/**
	 * Column Info
	 * 
	 * @return stelWireFlg
	 */
	public String getStelWireFlg() {
		return this.stelWireFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return arrLocNm
	 */
	public String getArrLocNm() {
		return this.arrLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * 
	 * @return itchgDt
	 */
	public String getItchgDt() {
		return this.itchgDt;
	}

	/**
	 * Column Info
	 * 
	 * @return ibdIpiLoclIndCd
	 */
	public String getIbdIpiLoclIndCd() {
		return this.ibdIpiLoclIndCd;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return bilIssKnt
	 */
	public String getBilIssKnt() {
		return this.bilIssKnt;
	}

	/**
	 * Column Info
	 * 
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}

	/**
	 * Column Info
	 * 
	 * @return trspRqstBkgFlg
	 */
	public String getTrspRqstBkgFlg() {
		return this.trspRqstBkgFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @return orgSplcLocNm
	 */
	public String getOrgSplcLocNm() {
		return this.orgSplcLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @return trspMtyCostModCd
	 */
	public String getTrspMtyCostModCd() {
		return this.trspMtyCostModCd;
	}

	/**
	 * Column Info
	 * 
	 * @return itchgGateOutDt
	 */
	public String getItchgGateOutDt() {
		return this.itchgGateOutDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return fumgFlg
	 */
	public String getFumgFlg() {
		return this.fumgFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}

	/**
	 * Column Info
	 * 
	 * @return nvoccFileNo
	 */
	public String getNvoccFileNo() {
		return this.nvoccFileNo;
	}

	/**
	 * Column Info
	 * 
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstRjctRsn
	 */
	public String getCxlRqstRjctRsn() {
		return this.cxlRqstRjctRsn;
	}

	/**
	 * Column Info
	 * 
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * 
	 * @return depLocNm
	 */
	public String getDepLocNm() {
		return this.depLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @return provEml
	 */
	public String getProvEml() {
		return this.provEml;
	}

	/**
	 * Column Info
	 * 
	 * @return trspRailBilTpCd
	 */
	public String getTrspRailBilTpCd() {
		return this.trspRailBilTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return blkFlg
	 */
	public String getBlkFlg() {
		return this.blkFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}

	/**
	 * Column Info
	 * 
	 * @return railCmbThruTpCd
	 */
	public String getRailCmbThruTpCd() {
		return this.railCmbThruTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}

	/**
	 * Column Info
	 * 
	 * @return vdDt
	 */
	public String getVdDt() {
		return this.vdDt;
	}

	/**
	 * Column Info
	 * 
	 * @return fincSkdVoyNo
	 */
	public String getFincSkdVoyNo() {
		return this.fincSkdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @return invBilPattDivFlg
	 */
	public String getInvBilPattDivFlg() {
		return this.invBilPattDivFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cxlRqstFlg
	 */
	public String getCxlRqstFlg() {
		return this.cxlRqstFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return routPlnCd
	 */
	public String getRoutPlnCd() {
		return this.routPlnCd;
	}

	/**
	 * Column Info
	 * 
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}

	/**
	 * Column Info
	 * 
	 * @return trnNo
	 */
	public String getTrnNo() {
		return this.trnNo;
	}

	/**
	 * Column Info
	 * 
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return orgCostActGrpSeq
	 */
	public String getOrgCostActGrpSeq() {
		return this.orgCostActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return tmlNodCd
	 */
	public String getTmlNodCd() {
		return this.tmlNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return avalDt
	 */
	public String getAvalDt() {
		return this.avalDt;
	}

	/**
	 * Column Info
	 * 
	 * @return destGateInDt
	 */
	public String getDestGateInDt() {
		return this.destGateInDt;
	}

	/**
	 * Column Info
	 * 
	 * @return destLocNm
	 */
	public String getDestLocNm() {
		return this.destLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}

	/**
	 * Column Info
	 * 
	 * @return ntfyCustNm
	 */
	public String getNtfyCustNm() {
		return this.ntfyCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @return fmNodYard
	 */
	public String getFmNodYard() {
		return fmNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @return toNodYard
	 */
	public String getToNodYard() {
		return toNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @return trunkvvd
	 */
	public String getTrunkvvd() {
		return trunkvvd;
	}

	/**
	 * Column Info
	 * 
	 * @return podCdYard
	 */
	public String getPodCdYard() {
		return podCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @return polCdYard
	 */
	public String getPolCdYard() {
		return polCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @return porNodCdYard
	 */
	public String getPorNodCdYard() {
		return porNodCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @return delNodCdYard
	 */
	public String getDelNodCdYard() {
		return delNodCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @return n1stNodPlnDtHms
	 */
	public String getN1stNodPlnDtHms() {
		return n1stNodPlnDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @return lstNodPlnDtHms
	 */
	public String getLstNodPlnDtHms() {
		return lstNodPlnDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @return strCostActGrpCd
	 */
	public String getStrCostActGrpCd() {
		return strCostActGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return strOfc
	 */
	public String getStrOfc() {
		return strOfc;
	}

	/**
	 * Column Info
	 * 
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return orgFmNodCd
	 */
	public String getOrgFmNodCd() {
		return orgFmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return orgFmNodYard
	 */
	public String getOrgFmNodYard() {
		return orgFmNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @return orgToNodCd
	 */
	public String getOrgToNodCd() {
		return orgToNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return orgToNodYard
	 */
	public String getOrgToNodYard() {
		return orgToNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @return actGrpCd
	 */
	public String getActGrpCd() {
		return actGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgSpe
	 */
	public String getBkgSpe() {
		return bkgSpe;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtName
	 */
	public String getCmdtName() {
		return cmdtName;
	}

	/**
	 * Column Info
	 * 
	 * @return RoutDtlSeq
	 */
	public String getRoutDtlSeq() {
		return RoutDtlSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return Expt
	 */
	public String getExpt() {
		return Expt;
	}

	/**
	 * Column Info
	 * 
	 * @return Interchange1Loc
	 */
	public String getInterchange1Loc() {
		return Interchange1Loc;
	}

	/**
	 * Column Info
	 * 
	 * @return Interchange2Loc
	 */
	public String getInterchange2Loc() {
		return Interchange2Loc;
	}

	/**
	 * Column Info
	 * 
	 * @return rtrDivCnt
	 */
	public String getRtrDivCnt() {
		return rtrDivCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return blckStwgCd;
	}

	/**
	 * Column Info
	 * 
	 * @return refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Column Info
	 * 
	 * @return lnkOrgNodCd
	 */
	public String getLnkOrgNodCd() {
		return lnkOrgNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return lnkDestNodCd
	 */
	public String getLnkDestNodCd() {
		return lnkDestNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspAgmtOfcCtyCd
	 */
	public String getTrspAgmtOfcCtyCd() {
		return trspAgmtOfcCtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @return trspAgmtSeq
	 */
	public String getTrspAgmtSeq() {
		return trspAgmtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return railRcvCoffFmDt
	 */
	public String getRailRcvCoffFmDt() {
		return railRcvCoffFmDt;
	}

	/**
	 * Column Info
	 * 
	 * @return railRcvCoffToDt
	 */
	public String getRailRcvCoffToDt() {
		return railRcvCoffToDt;
	}

	/**
	 * Column Info
	 * 
	 * @return gTime
	 */
	public String getGTime() {
		return gTime;
	}

	/**
	 * Column Info
	 * 
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return eqKndCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param provVndrSeq
	 */
	public void setProvVndrSeq(String provVndrSeq) {
		this.provVndrSeq = provVndrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param destAvalDt
	 */
	public void setDestAvalDt(String destAvalDt) {
		this.destAvalDt = destAvalDt;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param fincVslCd
	 */
	public void setFincVslCd(String fincVslCd) {
		this.fincVslCd = fincVslCd;
	}

	/**
	 * Column Info
	 * 
	 * @param itchgArrSplcLocNm
	 */
	public void setItchgArrSplcLocNm(String itchgArrSplcLocNm) {
		this.itchgArrSplcLocNm = itchgArrSplcLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @param trspFrstFlg
	 */
	public void setTrspFrstFlg(String trspFrstFlg) {
		this.trspFrstFlg = trspFrstFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param depSplcCd
	 */
	public void setDepSplcCd(String depSplcCd) {
		this.depSplcCd = depSplcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ibdCstmsClrLocCd
	 */
	public void setIbdCstmsClrLocCd(String ibdCstmsClrLocCd) {
		this.ibdCstmsClrLocCd = ibdCstmsClrLocCd;
	}

	/**
	 * Column Info
	 * 
	 * @param shprFaxNo
	 */
	public void setShprFaxNo(String shprFaxNo) {
		this.shprFaxNo = shprFaxNo;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgRcvdeTermCd
	 */
	public void setBkgRcvdeTermCd(String bkgRcvdeTermCd) {
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
	}

	/**
	 * Column Info
	 * 
	 * @param coilShpFlg
	 */
	public void setCoilShpFlg(String coilShpFlg) {
		this.coilShpFlg = coilShpFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstRsn
	 */
	public void setCxlRqstRsn(String cxlRqstRsn) {
		this.cxlRqstRsn = cxlRqstRsn;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param orgGateInDt
	 */
	public void setOrgGateInDt(String orgGateInDt) {
		this.orgGateInDt = orgGateInDt;
	}

	/**
	 * Column Info
	 * 
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * Column Info
	 * 
	 * @param dwUpdDt
	 */
	public void setDwUpdDt(String dwUpdDt) {
		this.dwUpdDt = dwUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * 
	 * @param woIssDt
	 */
	public void setWoIssDt(String woIssDt) {
		this.woIssDt = woIssDt;
	}

	/**
	 * Column Info
	 * 
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @param orgCopNo
	 */
	public void setOrgCopNo(String orgCopNo) {
		this.orgCopNo = orgCopNo;
	}

	/**
	 * Column Info
	 * 
	 * @param soProgCd
	 */
	public void setSoProgCd(String soProgCd) {
		this.soProgCd = soProgCd;
	}

	/**
	 * Column Info
	 * 
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}

	/**
	 * Column Info
	 * 
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrPkupNo
	 */
	public void setCntrPkupNo(String cntrPkupNo) {
		this.cntrPkupNo = cntrPkupNo;
	}

	/**
	 * Column Info
	 * 
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param orgGateOutDt
	 */
	public void setOrgGateOutDt(String orgGateOutDt) {
		this.orgGateOutDt = orgGateOutDt;
	}

	/**
	 * Column Info
	 * 
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param trspRqstOrdCfmFlg
	 */
	public void setTrspRqstOrdCfmFlg(String trspRqstOrdCfmFlg) {
		this.trspRqstOrdCfmFlg = trspRqstOrdCfmFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param highValCgoTpCd
	 */
	public void setHighValCgoTpCd(String highValCgoTpCd) {
		this.highValCgoTpCd = highValCgoTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param orgBkgNo
	 */
	public void setOrgBkgNo(String orgBkgNo) {
		this.orgBkgNo = orgBkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}

	/**
	 * Column Info
	 * 
	 * @param fincSkdDirCd
	 */
	public void setFincSkdDirCd(String fincSkdDirCd) {
		this.fincSkdDirCd = fincSkdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param depSteCd
	 */
	public void setDepSteCd(String depSteCd) {
		this.depSteCd = depSteCd;
	}

	/**
	 * Column Info
	 * 
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNoRvisFlg
	 */
	public void setBkgNoRvisFlg(String bkgNoRvisFlg) {
		this.bkgNoRvisFlg = bkgNoRvisFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param logUpdDt
	 */
	public void setLogUpdDt(String logUpdDt) {
		this.logUpdDt = logUpdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param provFaxNo
	 */
	public void setProvFaxNo(String provFaxNo) {
		this.provFaxNo = provFaxNo;
	}

	/**
	 * Column Info
	 * 
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * 
	 * @param clmSghtCd
	 */
	public void setClmSghtCd(String clmSghtCd) {
		this.clmSghtCd = clmSghtCd;
	}

	/**
	 * Column Info
	 * 
	 * @param rvisBkgNo
	 */
	public void setRvisBkgNo(String rvisBkgNo) {
		this.rvisBkgNo = rvisBkgNo;
	}

	/**
	 * Column Info
	 * 
	 * @param rvisCopNo
	 */
	public void setRvisCopNo(String rvisCopNo) {
		this.rvisCopNo = rvisCopNo;
	}

	/**
	 * Column Info
	 * 
	 * @param provPhnNo
	 */
	public void setProvPhnNo(String provPhnNo) {
		this.provPhnNo = provPhnNo;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param lstFreeDt
	 */
	public void setLstFreeDt(String lstFreeDt) {
		this.lstFreeDt = lstFreeDt;
	}

	/**
	 * Column Info
	 * 
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param arrSplcCd
	 */
	public void setArrSplcCd(String arrSplcCd) {
		this.arrSplcCd = arrSplcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param provCfmMzdCd
	 */
	public void setProvCfmMzdCd(String provCfmMzdCd) {
		this.provCfmMzdCd = provCfmMzdCd;
	}

	/**
	 * Column Info
	 * 
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @param spndLangTpCd
	 */
	public void setSpndLangTpCd(String spndLangTpCd) {
		this.spndLangTpCd = spndLangTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param clmUpdStsCd
	 */
	public void setClmUpdStsCd(String clmUpdStsCd) {
		this.clmUpdStsCd = clmUpdStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param copEqNo
	 */
	public void setCopEqNo(String copEqNo) {
		this.copEqNo = copEqNo;
	}

	/**
	 * Column Info
	 * 
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param autoXptSysCd
	 */
	public void setAutoXptSysCd(String autoXptSysCd) {
		this.autoXptSysCd = autoXptSysCd;
	}

	/**
	 * Column Info
	 * 
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}

	/**
	 * Column Info
	 * 
	 * @param lstNodPlnDt
	 */
	public void setLstNodPlnDt(String lstNodPlnDt) {
		this.lstNodPlnDt = lstNodPlnDt;
	}

	/**
	 * Column Info
	 * 
	 * @param spndErrMsgCd
	 */
	public void setSpndErrMsgCd(String spndErrMsgCd) {
		this.spndErrMsgCd = spndErrMsgCd;
	}

	/**
	 * Column Info
	 * 
	 * @param depDt
	 */
	public void setDepDt(String depDt) {
		this.depDt = depDt;
	}

	/**
	 * Column Info
	 * 
	 * @param itchgSplcLocNm
	 */
	public void setItchgSplcLocNm(String itchgSplcLocNm) {
		this.itchgSplcLocNm = itchgSplcLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param inlndRoutRmk
	 */
	public void setInlndRoutRmk(String inlndRoutRmk) {
		this.inlndRoutRmk = inlndRoutRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstDt
	 */
	public void setCxlRqstDt(String cxlRqstDt) {
		this.cxlRqstDt = cxlRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @param autoXptSysNo
	 */
	public void setAutoXptSysNo(String autoXptSysNo) {
		this.autoXptSysNo = autoXptSysNo;
	}

	/**
	 * Column Info
	 * 
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param cneeCustNm
	 */
	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @param n1stNodPlnDt
	 */
	public void setN1stNodPlnDt(String n1stNodPlnDt) {
		this.n1stNodPlnDt = n1stNodPlnDt;
	}

	/**
	 * Column Info
	 * 
	 * @param rvisCostActGrpSeq
	 */
	public void setRvisCostActGrpSeq(String rvisCostActGrpSeq) {
		this.rvisCostActGrpSeq = rvisCostActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstRjctFlg
	 */
	public void setCxlRqstRjctFlg(String cxlRqstRjctFlg) {
		this.cxlRqstRjctFlg = cxlRqstRjctFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param eqTpCd
	 */
	public void setEqTpCd(String eqTpCd) {
		this.eqTpCd = eqTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param destGateOutDt
	 */
	public void setDestGateOutDt(String destGateOutDt) {
		this.destGateOutDt = destGateOutDt;
	}

	/**
	 * Column Info
	 * 
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrPkupYdCd
	 */
	public void setCntrPkupYdCd(String cntrPkupYdCd) {
		this.cntrPkupYdCd = cntrPkupYdCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * Column Info
	 * 
	 * @param spclCgoCntrTpCd
	 */
	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * 
	 * @param corrFlg
	 */
	public void setCorrFlg(String corrFlg) {
		this.corrFlg = corrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param fcarNo
	 */
	public void setFcarNo(String fcarNo) {
		this.fcarNo = fcarNo;
	}

	/**
	 * Column Info
	 * 
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}

	/**
	 * Column Info
	 * 
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * Column Info
	 * 
	 * @param bilIssStsCd
	 */
	public void setBilIssStsCd(String bilIssStsCd) {
		this.bilIssStsCd = bilIssStsCd;
	}

	/**
	 * Column Info
	 * 
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param stndCmdtNo
	 */
	public void setStndCmdtNo(String stndCmdtNo) {
		this.stndCmdtNo = stndCmdtNo;
	}

	/**
	 * Column Info
	 * 
	 * @param provUsrId
	 */
	public void setProvUsrId(String provUsrId) {
		this.provUsrId = provUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}

	/**
	 * Column Info
	 * 
	 * @param itchgGateInDt
	 */
	public void setItchgGateInDt(String itchgGateInDt) {
		this.itchgGateInDt = itchgGateInDt;
	}

	/**
	 * Column Info
	 * 
	 * @param rvisEqNo
	 */
	public void setRvisEqNo(String rvisEqNo) {
		this.rvisEqNo = rvisEqNo;
	}

	/**
	 * Column Info
	 * 
	 * @param ownrCoCd
	 */
	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspModTpCd
	 */
	public void setTrspModTpCd(String trspModTpCd) {
		this.trspModTpCd = trspModTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstRjctDt
	 */
	public void setCxlRqstRjctDt(String cxlRqstRjctDt) {
		this.cxlRqstRjctDt = cxlRqstRjctDt;
	}

	/**
	 * Column Info
	 * 
	 * @param spndFlg
	 */
	public void setSpndFlg(String spndFlg) {
		this.spndFlg = spndFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param trspMtyRqstDt
	 */
	public void setTrspMtyRqstDt(String trspMtyRqstDt) {
		this.trspMtyRqstDt = trspMtyRqstDt;
	}

	/**
	 * Column Info
	 * 
	 * @param delSccCd
	 */
	public void setDelSccCd(String delSccCd) {
		this.delSccCd = delSccCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param costActGrpCd
	 */
	public void setCostActGrpCd(String costActGrpCd) {
		this.costActGrpCd = costActGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param clmCrrNm
	 */
	public void setClmCrrNm(String clmCrrNm) {
		this.clmCrrNm = clmCrrNm;
	}

	/**
	 * Column Info
	 * 
	 * @param arrSteCd
	 */
	public void setArrSteCd(String arrSteCd) {
		this.arrSteCd = arrSteCd;
	}

	/**
	 * Column Info
	 * 
	 * @param wgtMeasUtCd
	 */
	public void setWgtMeasUtCd(String wgtMeasUtCd) {
		this.wgtMeasUtCd = wgtMeasUtCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspRqstOrdCfmDt
	 */
	public void setTrspRqstOrdCfmDt(String trspRqstOrdCfmDt) {
		this.trspRqstOrdCfmDt = trspRqstOrdCfmDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibdNo
	 */
	public void setIbdNo(String ibdNo) {
		this.ibdNo = ibdNo;
	}

	/**
	 * Column Info
	 * 
	 * @param stelWireFlg
	 */
	public void setStelWireFlg(String stelWireFlg) {
		this.stelWireFlg = stelWireFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param arrLocNm
	 */
	public void setArrLocNm(String arrLocNm) {
		this.arrLocNm = arrLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * 
	 * @param itchgDt
	 */
	public void setItchgDt(String itchgDt) {
		this.itchgDt = itchgDt;
	}

	/**
	 * Column Info
	 * 
	 * @param ibdIpiLoclIndCd
	 */
	public void setIbdIpiLoclIndCd(String ibdIpiLoclIndCd) {
		this.ibdIpiLoclIndCd = ibdIpiLoclIndCd;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param bilIssKnt
	 */
	public void setBilIssKnt(String bilIssKnt) {
		this.bilIssKnt = bilIssKnt;
	}

	/**
	 * Column Info
	 * 
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * Column Info
	 * 
	 * @param trspRqstBkgFlg
	 */
	public void setTrspRqstBkgFlg(String trspRqstBkgFlg) {
		this.trspRqstBkgFlg = trspRqstBkgFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @param orgSplcLocNm
	 */
	public void setOrgSplcLocNm(String orgSplcLocNm) {
		this.orgSplcLocNm = orgSplcLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @param trspMtyCostModCd
	 */
	public void setTrspMtyCostModCd(String trspMtyCostModCd) {
		this.trspMtyCostModCd = trspMtyCostModCd;
	}

	/**
	 * Column Info
	 * 
	 * @param itchgGateOutDt
	 */
	public void setItchgGateOutDt(String itchgGateOutDt) {
		this.itchgGateOutDt = itchgGateOutDt;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param fumgFlg
	 */
	public void setFumgFlg(String fumgFlg) {
		this.fumgFlg = fumgFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * Column Info
	 * 
	 * @param nvoccFileNo
	 */
	public void setNvoccFileNo(String nvoccFileNo) {
		this.nvoccFileNo = nvoccFileNo;
	}

	/**
	 * Column Info
	 * 
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstRjctRsn
	 */
	public void setCxlRqstRjctRsn(String cxlRqstRjctRsn) {
		this.cxlRqstRjctRsn = cxlRqstRjctRsn;
	}

	/**
	 * Column Info
	 * 
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * 
	 * @param depLocNm
	 */
	public void setDepLocNm(String depLocNm) {
		this.depLocNm = depLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @param provEml
	 */
	public void setProvEml(String provEml) {
		this.provEml = provEml;
	}

	/**
	 * Column Info
	 * 
	 * @param trspRailBilTpCd
	 */
	public void setTrspRailBilTpCd(String trspRailBilTpCd) {
		this.trspRailBilTpCd = trspRailBilTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param blkFlg
	 */
	public void setBlkFlg(String blkFlg) {
		this.blkFlg = blkFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}

	/**
	 * Column Info
	 * 
	 * @param railCmbThruTpCd
	 */
	public void setRailCmbThruTpCd(String railCmbThruTpCd) {
		this.railCmbThruTpCd = railCmbThruTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}

	/**
	 * Column Info
	 * 
	 * @param vdDt
	 */
	public void setVdDt(String vdDt) {
		this.vdDt = vdDt;
	}

	/**
	 * Column Info
	 * 
	 * @param fincSkdVoyNo
	 */
	public void setFincSkdVoyNo(String fincSkdVoyNo) {
		this.fincSkdVoyNo = fincSkdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @param invBilPattDivFlg
	 */
	public void setInvBilPattDivFlg(String invBilPattDivFlg) {
		this.invBilPattDivFlg = invBilPattDivFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cxlRqstFlg
	 */
	public void setCxlRqstFlg(String cxlRqstFlg) {
		this.cxlRqstFlg = cxlRqstFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param routPlnCd
	 */
	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}

	/**
	 * Column Info
	 * 
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}

	/**
	 * Column Info
	 * 
	 * @param trnNo
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Column Info
	 * 
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param orgCostActGrpSeq
	 */
	public void setOrgCostActGrpSeq(String orgCostActGrpSeq) {
		this.orgCostActGrpSeq = orgCostActGrpSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param tmlNodCd
	 */
	public void setTmlNodCd(String tmlNodCd) {
		this.tmlNodCd = tmlNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param avalDt
	 */
	public void setAvalDt(String avalDt) {
		this.avalDt = avalDt;
	}

	/**
	 * Column Info
	 * 
	 * @param destGateInDt
	 */
	public void setDestGateInDt(String destGateInDt) {
		this.destGateInDt = destGateInDt;
	}

	/**
	 * Column Info
	 * 
	 * @param destLocNm
	 */
	public void setDestLocNm(String destLocNm) {
		this.destLocNm = destLocNm;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * Column Info
	 * 
	 * @param ntfyCustNm
	 */
	public void setNtfyCustNm(String ntfyCustNm) {
		this.ntfyCustNm = ntfyCustNm;
	}

	/**
	 * Column Info
	 * 
	 * @param fmNodYard
	 */
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param toNodYard
	 */
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param trunkvvd
	 */
	public void setTrunkvvd(String trunkvvd) {
		this.trunkvvd = trunkvvd;
	}

	/**
	 * Column Info
	 * 
	 * @param podCdYard
	 */
	public void setPodCdYard(String podCdYard) {
		this.podCdYard = podCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @param polCdYard
	 */
	public void setPolCdYard(String polCdYard) {
		this.polCdYard = polCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @param porNodCdYard
	 */
	public void setPorNodCdYard(String porNodCdYard) {
		this.porNodCdYard = porNodCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @param delNodCdYard
	 */
	public void setDelNodCdYard(String delNodCdYard) {
		this.delNodCdYard = delNodCdYard;
	}

	/**
	 * Column Info
	 * 
	 * @param n1stNodPlnDtHms
	 */
	public void setN1stNodPlnDtHms(String nodPlnDtHms) {
		n1stNodPlnDtHms = nodPlnDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @param lstNodPlnDtHms
	 */
	public void setLstNodPlnDtHms(String lstNodPlnDtHms) {
		this.lstNodPlnDtHms = lstNodPlnDtHms;
	}

	/**
	 * Column Info
	 * 
	 * @param strCostActGrpCd
	 */
	public void setStrCostActGrpCd(String strCostActGrpCd) {
		this.strCostActGrpCd = strCostActGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param strOfc
	 */
	public void setStrOfc(String strOfc) {
		this.strOfc = strOfc;
	}

	/**
	 * Column Info
	 * 
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param orgFmNodCd
	 */
	public void setOrgFmNodCd(String orgFmNodCd) {
		this.orgFmNodCd = orgFmNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param orgFmNodYard
	 */
	public void setOrgFmNodYard(String orgFmNodYard) {
		this.orgFmNodYard = orgFmNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param orgToNodCd
	 */
	public void setOrgToNodCd(String orgToNodCd) {
		this.orgToNodCd = orgToNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param orgToNodYard
	 */
	public void setOrgToNodYard(String orgToNodYard) {
		this.orgToNodYard = orgToNodYard;
	}

	/**
	 * Column Info
	 * 
	 * @param actGrpCd
	 */
	public void setActGrpCd(String actGrpCd) {
		this.actGrpCd = actGrpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgSpe
	 */
	public void setBkgSpe(String bkgSpe) {
		this.bkgSpe = bkgSpe;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtName
	 */
	public void setCmdtName(String cmdtName) {
		this.cmdtName = cmdtName;
	}

	/**
	 * Column Info
	 * 
	 * @param routDtlSeq
	 */
	public void setRoutDtlSeq(String routDtlSeq) {
		RoutDtlSeq = routDtlSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param expt
	 */
	public void setExpt(String expt) {
		Expt = expt;
	}

	/**
	 * Column Info
	 * 
	 * @param interchange1Loc
	 */
	public void setInterchange1Loc(String interchange1Loc) {
		Interchange1Loc = interchange1Loc;
	}

	/**
	 * Column Info
	 * 
	 * @param interchange2Loc
	 */
	public void setInterchange2Loc(String interchange2Loc) {
		Interchange2Loc = interchange2Loc;
	}

	/**
	 * Column Info
	 * 
	 * @param rtrDivCnt
	 */
	public void setRtrDivCnt(String rtrDivCnt) {
		this.rtrDivCnt = rtrDivCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}

	/**
	 * Column Info
	 * 
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Column Info
	 * 
	 * @param lnkOrgNodCd
	 */
	public void setLnkOrgNodCd(String lnkOrgNodCd) {
		this.lnkOrgNodCd = lnkOrgNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param lnkDestNodCd
	 */
	public void setLnkDestNodCd(String lnkDestNodCd) {
		this.lnkDestNodCd = lnkDestNodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspAgmtOfcCtyCd
	 */
	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}

	/**
	 * Column Info
	 * 
	 * @param trspAgmtSeq
	 */
	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param railRcvCoffFmDt
	 */
	public void setRailRcvCoffFmDt(String railRcvCoffFmDt) {
		this.railRcvCoffFmDt = railRcvCoffFmDt;
	}

	/**
	 * Column Info
	 * 
	 * @param railRcvCoffToDt
	 */
	public void setRailRcvCoffToDt(String railRcvCoffToDt) {
		this.railRcvCoffToDt = railRcvCoffToDt;
	}

	/**
	 * Column Info
	 * 
	 * @param time
	 */
	public void setGTime(String time) {
		gTime = time;
	}

	/**
	 * Column Info
	 * 
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getStccCd() {
		return stccCd;
	}

	/**
	 * Column Info
	 * 
	 * @param stccCd
	 */
	public void setStccCd(String stccCd) {
		this.stccCd = stccCd;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getStccDesc() {
		return stccDesc;
	}

	/**
	 * Column Info
	 * 
	 * @param stccDesc
	 */
	public void setStccDesc(String stccDesc) {
		this.stccDesc = stccDesc;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getWoExeDt() {
		return woExeDt;
	}

	/**
	 * Column Info
	 * 
	 * @param woExeDt
	 */
	public void setWoExeDt(String woExeDt) {
		this.woExeDt = woExeDt;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getCndCstmsClrFlg() {
		return cndCstmsClrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param cndCstmsClrFlg
	 */
	public void setCndCstmsClrFlg(String cndCstmsClrFlg) {
		this.cndCstmsClrFlg = cndCstmsClrFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return
	 */
	public String getUplnSoFlg() {
		return uplnSoFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param uplnSoFlg 
	 */
	public void setUplnSoFlg(String uplnSoFlg) {
		this.uplnSoFlg = uplnSoFlg;
	}

	/**
	 * 
	 * @return
	 */
	public String getRvisIndFlg() {
		return rvisIndFlg;
	}

	/**
	 * 
	 * @param rvisIndFlg
	 */
	public void setRvisIndFlg(String rvisIndFlg) {
		this.rvisIndFlg = rvisIndFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setProvVndrSeq(JSPUtil.getParameter(request, "prov_vndr_seq", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, "rout_org_nod_cd", ""));
		setDestAvalDt(JSPUtil.getParameter(request, "dest_aval_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFincVslCd(JSPUtil.getParameter(request, "finc_vsl_cd", ""));
		setItchgArrSplcLocNm(JSPUtil.getParameter(request, "itchg_arr_splc_loc_nm", ""));
		setTrspFrstFlg(JSPUtil.getParameter(request, "trsp_frst_flg", ""));
		setDepSplcCd(JSPUtil.getParameter(request, "dep_splc_cd", ""));
		setIbdCstmsClrLocCd(JSPUtil.getParameter(request, "ibd_cstms_clr_loc_cd", ""));
		setShprFaxNo(JSPUtil.getParameter(request, "shpr_fax_no", ""));
		setBkgRcvdeTermCd(JSPUtil.getParameter(request, "bkg_rcvde_term_cd", ""));
		setCoilShpFlg(JSPUtil.getParameter(request, "coil_shp_flg", ""));
		setCxlRqstRsn(JSPUtil.getParameter(request, "cxl_rqst_rsn", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOrgGateInDt(JSPUtil.getParameter(request, "org_gate_in_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setDwUpdDt(JSPUtil.getParameter(request, "dw_upd_dt", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setWoIssDt(JSPUtil.getParameter(request, "wo_iss_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setOrgCopNo(JSPUtil.getParameter(request, "org_cop_no", ""));
		setSoProgCd(JSPUtil.getParameter(request, "so_prog_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setCntrPkupNo(JSPUtil.getParameter(request, "cntr_pkup_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setOrgGateOutDt(JSPUtil.getParameter(request, "org_gate_out_dt", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, "locl_upd_dt", ""));
		setTrspRqstOrdCfmFlg(JSPUtil.getParameter(request, "trsp_rqst_ord_cfm_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setHighValCgoTpCd(JSPUtil.getParameter(request, "high_val_cgo_tp_cd", ""));
		setOrgBkgNo(JSPUtil.getParameter(request, "org_bkg_no", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setFincSkdDirCd(JSPUtil.getParameter(request, "finc_skd_dir_cd", ""));
		setDepSteCd(JSPUtil.getParameter(request, "dep_ste_cd", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setBkgNoRvisFlg(JSPUtil.getParameter(request, "bkg_no_rvis_flg", ""));
		setLogUpdDt(JSPUtil.getParameter(request, "log_upd_dt", ""));
		setProvFaxNo(JSPUtil.getParameter(request, "prov_fax_no", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setClmSghtCd(JSPUtil.getParameter(request, "clm_sght_cd", ""));
		setRvisBkgNo(JSPUtil.getParameter(request, "rvis_bkg_no", ""));
		setRvisCopNo(JSPUtil.getParameter(request, "rvis_cop_no", ""));
		setProvPhnNo(JSPUtil.getParameter(request, "prov_phn_no", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, "trsp_so_sts_cd", ""));
		setLstFreeDt(JSPUtil.getParameter(request, "lst_free_dt", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setArrSplcCd(JSPUtil.getParameter(request, "arr_splc_cd", ""));
		setProvCfmMzdCd(JSPUtil.getParameter(request, "prov_cfm_mzd_cd", ""));
		setShprCustNm(JSPUtil.getParameter(request, "shpr_cust_nm", ""));
		setSpndLangTpCd(JSPUtil.getParameter(request, "spnd_lang_tp_cd", ""));
		setClmUpdStsCd(JSPUtil.getParameter(request, "clm_upd_sts_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setCopEqNo(JSPUtil.getParameter(request, "cop_eq_no", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setAutoXptSysCd(JSPUtil.getParameter(request, "auto_xpt_sys_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, "locl_cre_dt", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request, "lst_nod_pln_dt", ""));
		setSpndErrMsgCd(JSPUtil.getParameter(request, "spnd_err_msg_cd", ""));
		setDepDt(JSPUtil.getParameter(request, "dep_dt", ""));
		setItchgSplcLocNm(JSPUtil.getParameter(request, "itchg_splc_loc_nm", ""));
		setFmNodCd(JSPUtil.getParameter(request, "fm_nod_cd", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, "n3pty_bil_flg", ""));
		setInlndRoutRmk(JSPUtil.getParameter(request, "inlnd_rout_rmk", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCxlRqstDt(JSPUtil.getParameter(request, "cxl_rqst_dt", ""));
		setAutoXptSysNo(JSPUtil.getParameter(request, "auto_xpt_sys_no", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setCneeCustNm(JSPUtil.getParameter(request, "cnee_cust_nm", ""));
		setN1stNodPlnDt(JSPUtil.getParameter(request, "n1st_nod_pln_dt", ""));
		setRvisCostActGrpSeq(JSPUtil.getParameter(request, "rvis_cost_act_grp_seq", ""));
		setCxlRqstRjctFlg(JSPUtil.getParameter(request, "cxl_rqst_rjct_flg", ""));
		setEqTpCd(JSPUtil.getParameter(request, "eq_tp_cd", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setDestGateOutDt(JSPUtil.getParameter(request, "dest_gate_out_dt", ""));
		setToNodCd(JSPUtil.getParameter(request, "to_nod_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCntrPkupYdCd(JSPUtil.getParameter(request, "cntr_pkup_yd_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setSpclCgoCntrTpCd(JSPUtil.getParameter(request, "spcl_cgo_cntr_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCorrFlg(JSPUtil.getParameter(request, "corr_flg", ""));
		setFcarNo(JSPUtil.getParameter(request, "fcar_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, "trsp_cost_dtl_mod_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setBilIssStsCd(JSPUtil.getParameter(request, "bil_iss_sts_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setStndCmdtNo(JSPUtil.getParameter(request, "stnd_cmdt_no", ""));
		setProvUsrId(JSPUtil.getParameter(request, "prov_usr_id", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setItchgGateInDt(JSPUtil.getParameter(request, "itchg_gate_in_dt", ""));
		setRvisEqNo(JSPUtil.getParameter(request, "rvis_eq_no", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, "ownr_co_cd", ""));
		setTrspModTpCd(JSPUtil.getParameter(request, "trsp_mod_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCxlRqstRjctDt(JSPUtil.getParameter(request, "cxl_rqst_rjct_dt", ""));
		setSpndFlg(JSPUtil.getParameter(request, "spnd_flg", ""));
		setTrspMtyRqstDt(JSPUtil.getParameter(request, "trsp_mty_rqst_dt", ""));
		setDelSccCd(JSPUtil.getParameter(request, "del_scc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCostActGrpCd(JSPUtil.getParameter(request, "cost_act_grp_cd", ""));
		setClmCrrNm(JSPUtil.getParameter(request, "clm_crr_nm", ""));
		setArrSteCd(JSPUtil.getParameter(request, "arr_ste_cd", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, "wgt_meas_ut_cd", ""));
		setTrspRqstOrdCfmDt(JSPUtil.getParameter(request, "trsp_rqst_ord_cfm_dt", ""));
		setIbdNo(JSPUtil.getParameter(request, "ibd_no", ""));
		setStelWireFlg(JSPUtil.getParameter(request, "stel_wire_flg", ""));
		setArrLocNm(JSPUtil.getParameter(request, "arr_loc_nm", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setItchgDt(JSPUtil.getParameter(request, "itchg_dt", ""));
		setIbdIpiLoclIndCd(JSPUtil.getParameter(request, "ibd_ipi_locl_ind_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBilIssKnt(JSPUtil.getParameter(request, "bil_iss_knt", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setTrspRqstBkgFlg(JSPUtil.getParameter(request, "trsp_rqst_bkg_flg", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setOrgSplcLocNm(JSPUtil.getParameter(request, "org_splc_loc_nm", ""));
		setTrspMtyCostModCd(JSPUtil.getParameter(request, "trsp_mty_cost_mod_cd", ""));
		setItchgGateOutDt(JSPUtil.getParameter(request, "itchg_gate_out_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFumgFlg(JSPUtil.getParameter(request, "fumg_flg", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setNvoccFileNo(JSPUtil.getParameter(request, "nvocc_file_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCxlRqstRjctRsn(JSPUtil.getParameter(request, "cxl_rqst_rjct_rsn", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setDepLocNm(JSPUtil.getParameter(request, "dep_loc_nm", ""));
		setProvEml(JSPUtil.getParameter(request, "prov_eml", ""));
		setTrspRailBilTpCd(JSPUtil.getParameter(request, "trsp_rail_bil_tp_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, "rout_dest_nod_cd", ""));
		setBlkFlg(JSPUtil.getParameter(request, "blk_flg", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, "spcl_instr_rmk", ""));
		setRailCmbThruTpCd(JSPUtil.getParameter(request, "rail_cmb_thru_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd", ""));
		setVdDt(JSPUtil.getParameter(request, "vd_dt", ""));
		setFincSkdVoyNo(JSPUtil.getParameter(request, "finc_skd_voy_no", ""));
		setInvBilPattDivFlg(JSPUtil.getParameter(request, "inv_bil_patt_div_flg", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setCxlRqstFlg(JSPUtil.getParameter(request, "cxl_rqst_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setTrnNo(JSPUtil.getParameter(request, "trn_no", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setOrgCostActGrpSeq(JSPUtil.getParameter(request, "org_cost_act_grp_seq", ""));
		setTmlNodCd(JSPUtil.getParameter(request, "tml_nod_cd", ""));
		setAvalDt(JSPUtil.getParameter(request, "aval_dt", ""));
		setDestGateInDt(JSPUtil.getParameter(request, "dest_gate_in_dt", ""));
		setDestLocNm(JSPUtil.getParameter(request, "dest_loc_nm", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, "ntfy_cust_nm", ""));
		setFmNodYard(JSPUtil.getParameter(request, "fm_nod_yard", ""));
		setToNodYard(JSPUtil.getParameter(request, "to_nod_yard", ""));
		setTrunkvvd(JSPUtil.getParameter(request, "trunkvvd", ""));
		setPodCdYard(JSPUtil.getParameter(request, "pod_cd_yard", ""));
		setPolCdYard(JSPUtil.getParameter(request, "pol_cd_yard", ""));
		setPorNodCdYard(JSPUtil.getParameter(request, "por_nod_cd_yard", ""));
		setDelNodCdYard(JSPUtil.getParameter(request, "del_nod_cd_yard", ""));
		setN1stNodPlnDtHms(JSPUtil.getParameter(request, "n1st_nod_pln_dt_hms", ""));
		setLstNodPlnDtHms(JSPUtil.getParameter(request, "lst_nod_pln_dt_hms", ""));
		setStrCostActGrpCd(JSPUtil.getParameter(request, "strCostActGrpCd", ""));
		setStrOfc(JSPUtil.getParameter(request, "strOfc", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOrgFmNodCd(JSPUtil.getParameter(request, "org_fm_nod_cd", ""));
		setOrgFmNodYard(JSPUtil.getParameter(request, "org_fm_nod_yard", ""));
		setOrgToNodCd(JSPUtil.getParameter(request, "org_to_nod_cd", ""));
		setOrgToNodYard(JSPUtil.getParameter(request, "org_to_nod_yard", ""));
		setActGrpCd(JSPUtil.getParameter(request, "act_grp_cd", ""));
		setBkgSpe(JSPUtil.getParameter(request, "bkg_spe", ""));
		setCmdtName(JSPUtil.getParameter(request, "cmdt_name", ""));
		setRoutDtlSeq(JSPUtil.getParameter(request, "rout_dtl_seq", ""));
		setExpt(JSPUtil.getParameter(request, "expt", ""));
		setInterchange1Loc(JSPUtil.getParameter(request, "interchange1_loc", ""));
		setInterchange2Loc(JSPUtil.getParameter(request, "interchange2_loc", ""));
		setRtrDivCnt(JSPUtil.getParameter(request, "rtr_div_cnt", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, "blck_stwg_cd", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setLnkOrgNodCd(JSPUtil.getParameter(request, "lnk_org_nod_cd", ""));
		setLnkDestNodCd(JSPUtil.getParameter(request, "lnk_dest_nod_cd", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, "trsp_agmt_ofc_cty_cd", ""));
		setTrspAgmtSeq(JSPUtil.getParameter(request, "trsp_agmt_seq", ""));
		setRailRcvCoffFmDt(JSPUtil.getParameter(request, "rail_rcv_coff_fm_dt", ""));
		setRailRcvCoffToDt(JSPUtil.getParameter(request, "rail_rcv_coff_to_dt", ""));
		setGTime(JSPUtil.getParameter(request, "g_time", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setStccCd(JSPUtil.getParameter(request, "stcc_cd", ""));
		setStccDesc(JSPUtil.getParameter(request, "stcc_desc", ""));
		setWoExeDt(JSPUtil.getParameter(request, "wo_exe_dt", ""));
		setCndCstmsClrFlg(JSPUtil.getParameter(request, "cnd_cstms_clr_flg", ""));
		setUplnSoFlg(JSPUtil.getParameter(request, "upln_so_flg", ""));
		setRvisIndFlg(JSPUtil.getParameter(request, "rvis_ind_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return TrsTrspRailBilOrdVO[]
	 */
	public TrsTrspRailBilOrdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return TrsTrspRailBilOrdVO[]
	 */
	public TrsTrspRailBilOrdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsTrspRailBilOrdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix + "cgo_tp_cd", length));
			String[] provVndrSeq = (JSPUtil.getParameter(request, prefix + "prov_vndr_seq", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", length));
			String[] destAvalDt = (JSPUtil.getParameter(request, prefix + "dest_aval_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] fincVslCd = (JSPUtil.getParameter(request, prefix + "finc_vsl_cd", length));
			String[] itchgArrSplcLocNm = (JSPUtil.getParameter(request, prefix + "itchg_arr_splc_loc_nm", length));
			String[] trspFrstFlg = (JSPUtil.getParameter(request, prefix + "trsp_frst_flg", length));
			String[] depSplcCd = (JSPUtil.getParameter(request, prefix + "dep_splc_cd", length));
			String[] ibdCstmsClrLocCd = (JSPUtil.getParameter(request, prefix + "ibd_cstms_clr_loc_cd", length));
			String[] shprFaxNo = (JSPUtil.getParameter(request, prefix + "shpr_fax_no", length));
			String[] bkgRcvdeTermCd = (JSPUtil.getParameter(request, prefix + "bkg_rcvde_term_cd", length));
			String[] coilShpFlg = (JSPUtil.getParameter(request, prefix + "coil_shp_flg", length));
			String[] cxlRqstRsn = (JSPUtil.getParameter(request, prefix + "cxl_rqst_rsn", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] orgGateInDt = (JSPUtil.getParameter(request, prefix + "org_gate_in_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
			String[] dwUpdDt = (JSPUtil.getParameter(request, prefix + "dw_upd_dt", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
			String[] woIssDt = (JSPUtil.getParameter(request, prefix + "wo_iss_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
			String[] orgCopNo = (JSPUtil.getParameter(request, prefix + "org_cop_no", length));
			String[] soProgCd = (JSPUtil.getParameter(request, prefix + "so_prog_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq", length));
			String[] cntrPkupNo = (JSPUtil.getParameter(request, prefix + "cntr_pkup_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
			String[] orgGateOutDt = (JSPUtil.getParameter(request, prefix + "org_gate_out_dt", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix + "locl_upd_dt", length));
			String[] trspRqstOrdCfmFlg = (JSPUtil.getParameter(request, prefix + "trsp_rqst_ord_cfm_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
			String[] highValCgoTpCd = (JSPUtil.getParameter(request, prefix + "high_val_cgo_tp_cd", length));
			String[] orgBkgNo = (JSPUtil.getParameter(request, prefix + "org_bkg_no", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix + "arr_dt", length));
			String[] fincSkdDirCd = (JSPUtil.getParameter(request, prefix + "finc_skd_dir_cd", length));
			String[] depSteCd = (JSPUtil.getParameter(request, prefix + "dep_ste_cd", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix + "pln_yrwk", length));
			String[] bkgNoRvisFlg = (JSPUtil.getParameter(request, prefix + "bkg_no_rvis_flg", length));
			String[] logUpdDt = (JSPUtil.getParameter(request, prefix + "log_upd_dt", length));
			String[] provFaxNo = (JSPUtil.getParameter(request, prefix + "prov_fax_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix + "inter_rmk", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix + "cmdt_cd", length));
			String[] clmSghtCd = (JSPUtil.getParameter(request, prefix + "clm_sght_cd", length));
			String[] rvisBkgNo = (JSPUtil.getParameter(request, prefix + "rvis_bkg_no", length));
			String[] rvisCopNo = (JSPUtil.getParameter(request, prefix + "rvis_cop_no", length));
			String[] provPhnNo = (JSPUtil.getParameter(request, prefix + "prov_phn_no", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", length));
			String[] lstFreeDt = (JSPUtil.getParameter(request, prefix + "lst_free_dt", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
			String[] arrSplcCd = (JSPUtil.getParameter(request, prefix + "arr_splc_cd", length));
			String[] provCfmMzdCd = (JSPUtil.getParameter(request, prefix + "prov_cfm_mzd_cd", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix + "shpr_cust_nm", length));
			String[] spndLangTpCd = (JSPUtil.getParameter(request, prefix + "spnd_lang_tp_cd", length));
			String[] clmUpdStsCd = (JSPUtil.getParameter(request, prefix + "clm_upd_sts_cd", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix + "cost_ofc_cd", length));
			String[] copEqNo = (JSPUtil.getParameter(request, prefix + "cop_eq_no", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
			String[] autoXptSysCd = (JSPUtil.getParameter(request, prefix + "auto_xpt_sys_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix + "locl_cre_dt", length));
			String[] lstNodPlnDt = (JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt", length));
			String[] spndErrMsgCd = (JSPUtil.getParameter(request, prefix + "spnd_err_msg_cd", length));
			String[] depDt = (JSPUtil.getParameter(request, prefix + "dep_dt", length));
			String[] itchgSplcLocNm = (JSPUtil.getParameter(request, prefix + "itchg_splc_loc_nm", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix + "fm_nod_cd", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", length));
			String[] inlndRoutRmk = (JSPUtil.getParameter(request, prefix + "inlnd_rout_rmk", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
			String[] cxlRqstDt = (JSPUtil.getParameter(request, prefix + "cxl_rqst_dt", length));
			String[] autoXptSysNo = (JSPUtil.getParameter(request, prefix + "auto_xpt_sys_no", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix + "cnee_cust_nm", length));
			String[] n1stNodPlnDt = (JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt", length));
			String[] rvisCostActGrpSeq = (JSPUtil.getParameter(request, prefix + "rvis_cost_act_grp_seq", length));
			String[] cxlRqstRjctFlg = (JSPUtil.getParameter(request, prefix + "cxl_rqst_rjct_flg", length));
			String[] eqTpCd = (JSPUtil.getParameter(request, prefix + "eq_tp_cd", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix + "imdt_ext_flg", length));
			String[] destGateOutDt = (JSPUtil.getParameter(request, prefix + "dest_gate_out_dt", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix + "to_nod_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
			String[] cntrPkupYdCd = (JSPUtil.getParameter(request, prefix + "cntr_pkup_yd_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix + "trsp_so_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
			String[] spclCgoCntrTpCd = (JSPUtil.getParameter(request, prefix + "spcl_cgo_cntr_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
			String[] corrFlg = (JSPUtil.getParameter(request, prefix + "corr_flg", length));
			String[] fcarNo = (JSPUtil.getParameter(request, prefix + "fcar_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix + "sc_no", length));
			String[] bilIssStsCd = (JSPUtil.getParameter(request, prefix + "bil_iss_sts_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
			String[] stndCmdtNo = (JSPUtil.getParameter(request, prefix + "stnd_cmdt_no", length));
			String[] provUsrId = (JSPUtil.getParameter(request, prefix + "prov_usr_id", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix + "lstm_cd", length));
			String[] itchgGateInDt = (JSPUtil.getParameter(request, prefix + "itchg_gate_in_dt", length));
			String[] rvisEqNo = (JSPUtil.getParameter(request, prefix + "rvis_eq_no", length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix + "ownr_co_cd", length));
			String[] trspModTpCd = (JSPUtil.getParameter(request, prefix + "trsp_mod_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
			String[] cxlRqstRjctDt = (JSPUtil.getParameter(request, prefix + "cxl_rqst_rjct_dt", length));
			String[] spndFlg = (JSPUtil.getParameter(request, prefix + "spnd_flg", length));
			String[] trspMtyRqstDt = (JSPUtil.getParameter(request, prefix + "trsp_mty_rqst_dt", length));
			String[] delSccCd = (JSPUtil.getParameter(request, prefix + "del_scc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] costActGrpCd = (JSPUtil.getParameter(request, prefix + "cost_act_grp_cd", length));
			String[] clmCrrNm = (JSPUtil.getParameter(request, prefix + "clm_crr_nm", length));
			String[] arrSteCd = (JSPUtil.getParameter(request, prefix + "arr_ste_cd", length));
			String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", length));
			String[] trspRqstOrdCfmDt = (JSPUtil.getParameter(request, prefix + "trsp_rqst_ord_cfm_dt", length));
			String[] ibdNo = (JSPUtil.getParameter(request, prefix + "ibd_no", length));
			String[] stelWireFlg = (JSPUtil.getParameter(request, prefix + "stel_wire_flg", length));
			String[] arrLocNm = (JSPUtil.getParameter(request, prefix + "arr_loc_nm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
			String[] itchgDt = (JSPUtil.getParameter(request, prefix + "itchg_dt", length));
			String[] ibdIpiLoclIndCd = (JSPUtil.getParameter(request, prefix + "ibd_ipi_locl_ind_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] bilIssKnt = (JSPUtil.getParameter(request, prefix + "bil_iss_knt", length));
			String[] refId = (JSPUtil.getParameter(request, prefix + "ref_id", length));
			String[] trspRqstBkgFlg = (JSPUtil.getParameter(request, prefix + "trsp_rqst_bkg_flg", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", length));
			String[] orgSplcLocNm = (JSPUtil.getParameter(request, prefix + "org_splc_loc_nm", length));
			String[] trspMtyCostModCd = (JSPUtil.getParameter(request, prefix + "trsp_mty_cost_mod_cd", length));
			String[] itchgGateOutDt = (JSPUtil.getParameter(request, prefix + "itchg_gate_out_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] fumgFlg = (JSPUtil.getParameter(request, prefix + "fumg_flg", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix + "eq_no", length));
			String[] nvoccFileNo = (JSPUtil.getParameter(request, prefix + "nvocc_file_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix + "cre_ofc_cd", length));
			String[] cxlRqstRjctRsn = (JSPUtil.getParameter(request, prefix + "cxl_rqst_rjct_rsn", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
			String[] depLocNm = (JSPUtil.getParameter(request, prefix + "dep_loc_nm", length));
			String[] provEml = (JSPUtil.getParameter(request, prefix + "prov_eml", length));
			String[] trspRailBilTpCd = (JSPUtil.getParameter(request, prefix + "trsp_rail_bil_tp_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", length));
			String[] blkFlg = (JSPUtil.getParameter(request, prefix + "blk_flg", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", length));
			String[] railCmbThruTpCd = (JSPUtil.getParameter(request, prefix + "rail_cmb_thru_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", length));
			String[] vdDt = (JSPUtil.getParameter(request, prefix + "vd_dt", length));
			String[] fincSkdVoyNo = (JSPUtil.getParameter(request, prefix + "finc_skd_voy_no", length));
			String[] invBilPattDivFlg = (JSPUtil.getParameter(request, prefix + "inv_bil_patt_div_flg", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix + "pln_seq", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
			String[] cxlRqstFlg = (JSPUtil.getParameter(request, prefix + "cxl_rqst_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix + "rout_pln_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix + "repo_pln_id", length));
			String[] trnNo = (JSPUtil.getParameter(request, prefix + "trn_no", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix + "ref_seq", length));
			String[] orgCostActGrpSeq = (JSPUtil.getParameter(request, prefix + "org_cost_act_grp_seq", length));
			String[] tmlNodCd = (JSPUtil.getParameter(request, prefix + "tml_nod_cd", length));
			String[] avalDt = (JSPUtil.getParameter(request, prefix + "aval_dt", length));
			String[] destGateInDt = (JSPUtil.getParameter(request, prefix + "dest_gate_in_dt", length));
			String[] destLocNm = (JSPUtil.getParameter(request, prefix + "dest_loc_nm", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix + "ntfy_cust_nm", length));
			String[] fmNodYard = (JSPUtil.getParameter(request, prefix + "fm_nod_yard", length));
			String[] toNodYard = (JSPUtil.getParameter(request, prefix + "to_nod_yard", length));
			String[] trunkvvd = (JSPUtil.getParameter(request, prefix + "trunkvvd", length));
			String[] podCdYard = (JSPUtil.getParameter(request, prefix + "pod_cd_yard", length));
			String[] polCdYard = (JSPUtil.getParameter(request, prefix + "pol_cd_yard", length));
			String[] porNodCdYard = (JSPUtil.getParameter(request, prefix + "por_nod_cd_yard", length));
			String[] delNodCdYard = (JSPUtil.getParameter(request, prefix + "del_nod_cd_yard", length));
			String[] n1stNodPlnDtHms = (JSPUtil.getParameter(request, prefix + "n1st_nod_pln_dt_hms", length));
			String[] lstNodPlnDtHms = (JSPUtil.getParameter(request, prefix + "lst_nod_pln_dt_hms", length));
			String[] strCostActGrpCd = (JSPUtil.getParameter(request, prefix + "strCostActGrpCd", length));
			String[] strOfc = (JSPUtil.getParameter(request, prefix + "strOfc", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
			String[] orgFmNodCd = (JSPUtil.getParameter(request, prefix + "org_fm_nod_cd", length));
			String[] orgFmNodYard = (JSPUtil.getParameter(request, prefix + "org_fm_nod_yard", length));
			String[] orgToNodCd = (JSPUtil.getParameter(request, prefix + "org_to_nod_cd", length));
			String[] orgToNodYard = (JSPUtil.getParameter(request, prefix + "org_to_nod_yard", length));
			String[] actGrpCd = (JSPUtil.getParameter(request, prefix + "act_grp_cd", length));
			String[] bkgSpe = (JSPUtil.getParameter(request, prefix + "bkg_spe", length));
			String[] cmdtName = (JSPUtil.getParameter(request, prefix + "cmdt_name", length));
			String[] RoutDtlSeq = (JSPUtil.getParameter(request, prefix + "rout_dtl_seq", length));
			String[] Expt = (JSPUtil.getParameter(request, prefix + "expt", length));
			String[] Interchange1Loc = (JSPUtil.getParameter(request, prefix + "interchange1_loc", length));
			String[] Interchange2Loc = (JSPUtil.getParameter(request, prefix + "interchange2_loc", length));
			String[] rtrDivCnt = (JSPUtil.getParameter(request, prefix + "rtr_div_cnt", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix + "ref_no", length));
			String[] lnkOrgNodCd = (JSPUtil.getParameter(request, prefix + "lnk_org_nod_cd", length));
			String[] lnkDestNodCd = (JSPUtil.getParameter(request, prefix + "lnk_dest_nod_cd", length));
			String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", length));
			String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", length));
			String[] railRcvCoffFmDt = (JSPUtil.getParameter(request, prefix + "rail_rcv_coff_fm_dt", length));
			String[] railRcvCoffToDt = (JSPUtil.getParameter(request, prefix + "rail_rcv_coff_to_dt", length));
			String[] gTime = (JSPUtil.getParameter(request, prefix + "g_time", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix + "eq_knd_cd", length));
			String[] stccCd = (JSPUtil.getParameter(request, prefix + "stcc_cd", length));
			String[] stccDesc = (JSPUtil.getParameter(request, prefix + "stcc_desc", length));
			String[] woExeDt = (JSPUtil.getParameter(request, prefix + "wo_exe_dt", length));
			String[] cndCstmsClrFlg = (JSPUtil.getParameter(request, prefix + "cnd_cstms_clr_flg", length));
			String[] uplnSoFlg = (JSPUtil.getParameter(request, prefix + "upln_so_flg", length));
			String[] rvisIndFlg = (JSPUtil.getParameter(request, prefix + "rvis_ind_flg", length));

			for (int i = 0; i < length; i++) {
				model = new TrsTrspRailBilOrdVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (provVndrSeq[i] != null)
					model.setProvVndrSeq(provVndrSeq[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (destAvalDt[i] != null)
					model.setDestAvalDt(destAvalDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fincVslCd[i] != null)
					model.setFincVslCd(fincVslCd[i]);
				if (itchgArrSplcLocNm[i] != null)
					model.setItchgArrSplcLocNm(itchgArrSplcLocNm[i]);
				if (trspFrstFlg[i] != null)
					model.setTrspFrstFlg(trspFrstFlg[i]);
				if (depSplcCd[i] != null)
					model.setDepSplcCd(depSplcCd[i]);
				if (ibdCstmsClrLocCd[i] != null)
					model.setIbdCstmsClrLocCd(ibdCstmsClrLocCd[i]);
				if (shprFaxNo[i] != null)
					model.setShprFaxNo(shprFaxNo[i]);
				if (bkgRcvdeTermCd[i] != null)
					model.setBkgRcvdeTermCd(bkgRcvdeTermCd[i]);
				if (coilShpFlg[i] != null)
					model.setCoilShpFlg(coilShpFlg[i]);
				if (cxlRqstRsn[i] != null)
					model.setCxlRqstRsn(cxlRqstRsn[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgGateInDt[i] != null)
					model.setOrgGateInDt(orgGateInDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (dwUpdDt[i] != null)
					model.setDwUpdDt(dwUpdDt[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (woIssDt[i] != null)
					model.setWoIssDt(woIssDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (orgCopNo[i] != null)
					model.setOrgCopNo(orgCopNo[i]);
				if (soProgCd[i] != null)
					model.setSoProgCd(soProgCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (cntrPkupNo[i] != null)
					model.setCntrPkupNo(cntrPkupNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (orgGateOutDt[i] != null)
					model.setOrgGateOutDt(orgGateOutDt[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (trspRqstOrdCfmFlg[i] != null)
					model.setTrspRqstOrdCfmFlg(trspRqstOrdCfmFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (highValCgoTpCd[i] != null)
					model.setHighValCgoTpCd(highValCgoTpCd[i]);
				if (orgBkgNo[i] != null)
					model.setOrgBkgNo(orgBkgNo[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (fincSkdDirCd[i] != null)
					model.setFincSkdDirCd(fincSkdDirCd[i]);
				if (depSteCd[i] != null)
					model.setDepSteCd(depSteCd[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (bkgNoRvisFlg[i] != null)
					model.setBkgNoRvisFlg(bkgNoRvisFlg[i]);
				if (logUpdDt[i] != null)
					model.setLogUpdDt(logUpdDt[i]);
				if (provFaxNo[i] != null)
					model.setProvFaxNo(provFaxNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (clmSghtCd[i] != null)
					model.setClmSghtCd(clmSghtCd[i]);
				if (rvisBkgNo[i] != null)
					model.setRvisBkgNo(rvisBkgNo[i]);
				if (rvisCopNo[i] != null)
					model.setRvisCopNo(rvisCopNo[i]);
				if (provPhnNo[i] != null)
					model.setProvPhnNo(provPhnNo[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (lstFreeDt[i] != null)
					model.setLstFreeDt(lstFreeDt[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (arrSplcCd[i] != null)
					model.setArrSplcCd(arrSplcCd[i]);
				if (provCfmMzdCd[i] != null)
					model.setProvCfmMzdCd(provCfmMzdCd[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (spndLangTpCd[i] != null)
					model.setSpndLangTpCd(spndLangTpCd[i]);
				if (clmUpdStsCd[i] != null)
					model.setClmUpdStsCd(clmUpdStsCd[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (copEqNo[i] != null)
					model.setCopEqNo(copEqNo[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (autoXptSysCd[i] != null)
					model.setAutoXptSysCd(autoXptSysCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (lstNodPlnDt[i] != null)
					model.setLstNodPlnDt(lstNodPlnDt[i]);
				if (spndErrMsgCd[i] != null)
					model.setSpndErrMsgCd(spndErrMsgCd[i]);
				if (depDt[i] != null)
					model.setDepDt(depDt[i]);
				if (itchgSplcLocNm[i] != null)
					model.setItchgSplcLocNm(itchgSplcLocNm[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (inlndRoutRmk[i] != null)
					model.setInlndRoutRmk(inlndRoutRmk[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cxlRqstDt[i] != null)
					model.setCxlRqstDt(cxlRqstDt[i]);
				if (autoXptSysNo[i] != null)
					model.setAutoXptSysNo(autoXptSysNo[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (n1stNodPlnDt[i] != null)
					model.setN1stNodPlnDt(n1stNodPlnDt[i]);
				if (rvisCostActGrpSeq[i] != null)
					model.setRvisCostActGrpSeq(rvisCostActGrpSeq[i]);
				if (cxlRqstRjctFlg[i] != null)
					model.setCxlRqstRjctFlg(cxlRqstRjctFlg[i]);
				if (eqTpCd[i] != null)
					model.setEqTpCd(eqTpCd[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (destGateOutDt[i] != null)
					model.setDestGateOutDt(destGateOutDt[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrPkupYdCd[i] != null)
					model.setCntrPkupYdCd(cntrPkupYdCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (spclCgoCntrTpCd[i] != null)
					model.setSpclCgoCntrTpCd(spclCgoCntrTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (corrFlg[i] != null)
					model.setCorrFlg(corrFlg[i]);
				if (fcarNo[i] != null)
					model.setFcarNo(fcarNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bilIssStsCd[i] != null)
					model.setBilIssStsCd(bilIssStsCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (stndCmdtNo[i] != null)
					model.setStndCmdtNo(stndCmdtNo[i]);
				if (provUsrId[i] != null)
					model.setProvUsrId(provUsrId[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (itchgGateInDt[i] != null)
					model.setItchgGateInDt(itchgGateInDt[i]);
				if (rvisEqNo[i] != null)
					model.setRvisEqNo(rvisEqNo[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (trspModTpCd[i] != null)
					model.setTrspModTpCd(trspModTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cxlRqstRjctDt[i] != null)
					model.setCxlRqstRjctDt(cxlRqstRjctDt[i]);
				if (spndFlg[i] != null)
					model.setSpndFlg(spndFlg[i]);
				if (trspMtyRqstDt[i] != null)
					model.setTrspMtyRqstDt(trspMtyRqstDt[i]);
				if (delSccCd[i] != null)
					model.setDelSccCd(delSccCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costActGrpCd[i] != null)
					model.setCostActGrpCd(costActGrpCd[i]);
				if (clmCrrNm[i] != null)
					model.setClmCrrNm(clmCrrNm[i]);
				if (arrSteCd[i] != null)
					model.setArrSteCd(arrSteCd[i]);
				if (wgtMeasUtCd[i] != null)
					model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if (trspRqstOrdCfmDt[i] != null)
					model.setTrspRqstOrdCfmDt(trspRqstOrdCfmDt[i]);
				if (ibdNo[i] != null)
					model.setIbdNo(ibdNo[i]);
				if (stelWireFlg[i] != null)
					model.setStelWireFlg(stelWireFlg[i]);
				if (arrLocNm[i] != null)
					model.setArrLocNm(arrLocNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (itchgDt[i] != null)
					model.setItchgDt(itchgDt[i]);
				if (ibdIpiLoclIndCd[i] != null)
					model.setIbdIpiLoclIndCd(ibdIpiLoclIndCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bilIssKnt[i] != null)
					model.setBilIssKnt(bilIssKnt[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (trspRqstBkgFlg[i] != null)
					model.setTrspRqstBkgFlg(trspRqstBkgFlg[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (orgSplcLocNm[i] != null)
					model.setOrgSplcLocNm(orgSplcLocNm[i]);
				if (trspMtyCostModCd[i] != null)
					model.setTrspMtyCostModCd(trspMtyCostModCd[i]);
				if (itchgGateOutDt[i] != null)
					model.setItchgGateOutDt(itchgGateOutDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fumgFlg[i] != null)
					model.setFumgFlg(fumgFlg[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (nvoccFileNo[i] != null)
					model.setNvoccFileNo(nvoccFileNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cxlRqstRjctRsn[i] != null)
					model.setCxlRqstRjctRsn(cxlRqstRjctRsn[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (depLocNm[i] != null)
					model.setDepLocNm(depLocNm[i]);
				if (provEml[i] != null)
					model.setProvEml(provEml[i]);
				if (trspRailBilTpCd[i] != null)
					model.setTrspRailBilTpCd(trspRailBilTpCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (blkFlg[i] != null)
					model.setBlkFlg(blkFlg[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (railCmbThruTpCd[i] != null)
					model.setRailCmbThruTpCd(railCmbThruTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (vdDt[i] != null)
					model.setVdDt(vdDt[i]);
				if (fincSkdVoyNo[i] != null)
					model.setFincSkdVoyNo(fincSkdVoyNo[i]);
				if (invBilPattDivFlg[i] != null)
					model.setInvBilPattDivFlg(invBilPattDivFlg[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (cxlRqstFlg[i] != null)
					model.setCxlRqstFlg(cxlRqstFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (trnNo[i] != null)
					model.setTrnNo(trnNo[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (orgCostActGrpSeq[i] != null)
					model.setOrgCostActGrpSeq(orgCostActGrpSeq[i]);
				if (tmlNodCd[i] != null)
					model.setTmlNodCd(tmlNodCd[i]);
				if (avalDt[i] != null)
					model.setAvalDt(avalDt[i]);
				if (destGateInDt[i] != null)
					model.setDestGateInDt(destGateInDt[i]);
				if (destLocNm[i] != null)
					model.setDestLocNm(destLocNm[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (fmNodYard[i] != null)
					model.setFmNodYard(fmNodYard[i]);
				if (toNodYard[i] != null)
					model.setToNodYard(toNodYard[i]);
				if (trunkvvd[i] != null)
					model.setTrunkvvd(trunkvvd[i]);
				if (podCdYard[i] != null)
					model.setPodCdYard(podCdYard[i]);
				if (polCdYard[i] != null)
					model.setPolCdYard(polCdYard[i]);
				if (porNodCdYard[i] != null)
					model.setPorNodCdYard(porNodCdYard[i]);
				if (delNodCdYard[i] != null)
					model.setDelNodCdYard(delNodCdYard[i]);
				if (n1stNodPlnDtHms[i] != null)
					model.setN1stNodPlnDtHms(n1stNodPlnDtHms[i]);
				if (lstNodPlnDtHms[i] != null)
					model.setLstNodPlnDtHms(lstNodPlnDtHms[i]);
				if (strCostActGrpCd[i] != null)
					model.setStrCostActGrpCd(strCostActGrpCd[i]);
				if (strOfc[i] != null)
					model.setStrOfc(strOfc[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (orgFmNodCd[i] != null)
					model.setOrgFmNodCd(orgFmNodCd[i]);
				if (orgFmNodYard[i] != null)
					model.setOrgFmNodYard(orgFmNodYard[i]);
				if (orgToNodCd[i] != null)
					model.setOrgToNodCd(orgToNodCd[i]);
				if (orgToNodYard[i] != null)
					model.setOrgToNodYard(orgToNodYard[i]);
				if (actGrpCd[i] != null)
					model.setActGrpCd(actGrpCd[i]);
				if (bkgSpe[i] != null)
					model.setBkgSpe(bkgSpe[i]);
				if (cmdtName[i] != null)
					model.setCmdtName(cmdtName[i]);
				if (RoutDtlSeq[i] != null)
					model.setRoutDtlSeq(RoutDtlSeq[i]);
				if (Expt[i] != null)
					model.setExpt(Expt[i]);
				if (Interchange1Loc[i] != null)
					model.setInterchange1Loc(Interchange1Loc[i]);
				if (Interchange2Loc[i] != null)
					model.setInterchange2Loc(Interchange2Loc[i]);
				if (rtrDivCnt[i] != null)
					model.setRtrDivCnt(rtrDivCnt[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (lnkOrgNodCd[i] != null)
					model.setLnkOrgNodCd(lnkOrgNodCd[i]);
				if (lnkDestNodCd[i] != null)
					model.setLnkDestNodCd(lnkDestNodCd[i]);
				if (trspAgmtOfcCtyCd[i] != null)
					model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if (trspAgmtSeq[i] != null)
					model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if (railRcvCoffFmDt[i] != null)
					model.setRailRcvCoffFmDt(railRcvCoffFmDt[i]);
				if (railRcvCoffToDt[i] != null)
					model.setRailRcvCoffToDt(railRcvCoffToDt[i]);
				if (gTime[i] != null)
					model.setGTime(gTime[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (stccCd[i] != null)
					model.setStccCd(stccCd[i]);
				if (stccDesc[i] != null)
					model.setStccDesc(stccDesc[i]);
				if (woExeDt[i] != null)
					model.setWoExeDt(woExeDt[i]);
				if (cndCstmsClrFlg[i] != null)
					model.setCndCstmsClrFlg(cndCstmsClrFlg[i]);
				if (uplnSoFlg[i] != null)
					model.setUplnSoFlg(uplnSoFlg[i]);
				if (rvisIndFlg[i] != null)
					model.setRvisIndFlg(rvisIndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsTrspRailBilOrdVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return TrsTrspRailBilOrdVO[]
	 */
	public TrsTrspRailBilOrdVO[] getTrsTrspRailBilOrdVOs() {
		TrsTrspRailBilOrdVO[] vos = (TrsTrspRailBilOrdVO[]) models.toArray(new TrsTrspRailBilOrdVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provVndrSeq = this.provVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destAvalDt = this.destAvalDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincVslCd = this.fincVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgArrSplcLocNm = this.itchgArrSplcLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspFrstFlg = this.trspFrstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depSplcCd = this.depSplcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdCstmsClrLocCd = this.ibdCstmsClrLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprFaxNo = this.shprFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvdeTermCd = this.bkgRcvdeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coilShpFlg = this.coilShpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstRsn = this.cxlRqstRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateInDt = this.orgGateInDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwUpdDt = this.dwUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssDt = this.woIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCopNo = this.orgCopNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soProgCd = this.soProgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupNo = this.cntrPkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgGateOutDt = this.orgGateOutDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdCfmFlg = this.trspRqstOrdCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highValCgoTpCd = this.highValCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBkgNo = this.orgBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincSkdDirCd = this.fincSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depSteCd = this.depSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoRvisFlg = this.bkgNoRvisFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logUpdDt = this.logUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provFaxNo = this.provFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmSghtCd = this.clmSghtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisBkgNo = this.rvisBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCopNo = this.rvisCopNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provPhnNo = this.provPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFreeDt = this.lstFreeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSplcCd = this.arrSplcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provCfmMzdCd = this.provCfmMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spndLangTpCd = this.spndLangTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmUpdStsCd = this.clmUpdStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copEqNo = this.copEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoXptSysCd = this.autoXptSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt = this.lstNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spndErrMsgCd = this.spndErrMsgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDt = this.depDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgSplcLocNm = this.itchgSplcLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutRmk = this.inlndRoutRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstDt = this.cxlRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoXptSysNo = this.autoXptSysNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDt = this.n1stNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCostActGrpSeq = this.rvisCostActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstRjctFlg = this.cxlRqstRjctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpCd = this.eqTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateOutDt = this.destGateOutDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupYdCd = this.cntrPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCntrTpCd = this.spclCgoCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrFlg = this.corrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcarNo = this.fcarNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilIssStsCd = this.bilIssStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCmdtNo = this.stndCmdtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provUsrId = this.provUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgGateInDt = this.itchgGateInDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisEqNo = this.rvisEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModTpCd = this.trspModTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstRjctDt = this.cxlRqstRjctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spndFlg = this.spndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyRqstDt = this.trspMtyRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSccCd = this.delSccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpCd = this.costActGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCrrNm = this.clmCrrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSteCd = this.arrSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdCfmDt = this.trspRqstOrdCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdNo = this.ibdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stelWireFlg = this.stelWireFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLocNm = this.arrLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgDt = this.itchgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdIpiLoclIndCd = this.ibdIpiLoclIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilIssKnt = this.bilIssKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstBkgFlg = this.trspRqstBkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSplcLocNm = this.orgSplcLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMtyCostModCd = this.trspMtyCostModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgGateOutDt = this.itchgGateOutDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fumgFlg = this.fumgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nvoccFileNo = this.nvoccFileNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstRjctRsn = this.cxlRqstRjctRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLocNm = this.depLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provEml = this.provEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRailBilTpCd = this.trspRailBilTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkFlg = this.blkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railCmbThruTpCd = this.railCmbThruTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdDt = this.vdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincSkdVoyNo = this.fincSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBilPattDivFlg = this.invBilPattDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRqstFlg = this.cxlRqstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnNo = this.trnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCostActGrpSeq = this.orgCostActGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlNodCd = this.tmlNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDt = this.avalDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destGateInDt = this.destGateInDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocNm = this.destLocNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard = this.fmNodYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard = this.toNodYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkvvd = this.trunkvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCdYard = this.podCdYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdYard = this.polCdYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCdYard = this.porNodCdYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCdYard = this.delNodCdYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodPlnDtHms = this.n1stNodPlnDtHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDtHms = this.lstNodPlnDtHms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strCostActGrpCd = this.strCostActGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strOfc = this.strOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFmNodCd = this.orgFmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFmNodYard = this.orgFmNodYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgToNodCd = this.orgToNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgToNodYard = this.orgToNodYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGrpCd = this.actGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpe = this.bkgSpe.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtName = this.cmdtName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.RoutDtlSeq = this.RoutDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.Expt = this.Expt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.Interchange1Loc = this.Interchange1Loc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.Interchange2Loc = this.Interchange2Loc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtrDivCnt = this.rtrDivCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkOrgNodCd = this.lnkOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDestNodCd = this.lnkDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtSeq = this.trspAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRcvCoffFmDt = this.railRcvCoffFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRcvCoffToDt = this.railRcvCoffToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gTime = this.gTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stccCd = this.stccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stccDesc = this.stccDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woExeDt = this.woExeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsClrFlg = this.cndCstmsClrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uplnSoFlg = this.uplnSoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisIndFlg = this.rvisIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	
}
