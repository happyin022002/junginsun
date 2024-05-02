/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BokCntrListOutVO.java
*@FileTitle : BokCntrListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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

public class BokCntrListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BokCntrListOutVO> models = new ArrayList<BokCntrListOutVO>();
	
	/* Column Info */
	private String ebffRefNo = null;
	/* Column Info */
	private String vvd4PodCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String fCust = null;
	/* Column Info */
	private String mtyRtnLoc = null;
	/* Column Info */
	private String awkRmk = null;
	/* Column Info */
	private String vndrRmk = null;
	/* Column Info */
	private String vvd1PolCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cgoAvalDt = null;
	/* Column Info */
	private String trspModIb = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String vvd3PolCd = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String ctrlAtmsFlg = null;
	/* Column Info */
	private String ctrtCust = null;
	/* Column Info */
	private String actPkupDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String awkOvrBkwdLen = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String grsWgtKg = null;
	/* Column Info */
	private String siFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String awkOvrHgt = null;
	/* Column Info */
	private String trafModIb = null;
	/* Column Info */
	private String vvd4PolCd = null;
	/* Column Info */
	private String vvd1PodNm = null;
	/* Column Info */
	private String cntr1 = null;
	/* Column Info */
	private String ttlGrsWgtKg = null;
	/* Column Info */
	private String fSteCd = null;
	/* Column Info */
	private String ebrfRefNo = null;
	/* Column Info */
	private String post1Vvd = null;
	/* Column Info */
	private String esffRefNo = null;
	/* Column Info */
	private String poNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ttlGrsWgtLb = null;
	/* Column Info */
	private String grsWgtLb = null;
	/* Column Info */
	private String cntrSealCnt = null;
	/* Column Info */
	private String lclPckQty = null;
	/* Column Info */
	private String vvd3PodNm = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String spclHndlInst = null;
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String slsCd = null;
	/* Column Info */
	private String ttlFeu = null;
	/* Column Info */
	private String rfTemp = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String lastPodEtb = null;
	/* Column Info */
	private String rfRmk = null;
	/* Column Info */
	private String lastPodEta = null;
	/* Column Info */
	private String vvd1PolNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String finvRefNo = null;
	/* Column Info */
	private String cgoCutoffDt = null;
	/* Column Info */
	private String trunkVslCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String actRtnDt = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String ttlTeu = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String trunkPodCd = null;
	/* Column Info */
	private String htsCd = null;
	/* Column Info */
	private String dgCertiFlg = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ibPkupYdNm = null;
	/* Column Info */
	private String lastPodAta = null;
	/* Column Info */
	private String obHlgBkg = null;
	/* Column Info */
	private String slsArea = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String cucrRefNo = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String fullRtnLoc = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String tVslNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String lclPckTpCd = null;
	/* Column Info */
	private String fCntcNm = null;
	/* Column Info */
	private String trafModOb = null;
	/* Column Info */
	private String sGrpCust = null;
	/* Column Info */
	private String awkNetWgt = null;
	/* Column Info */
	private String rgbkRefNo = null;
	/* Column Info */
	private String trunkPolCd = null;
	/* Column Info */
	private String pre1Vvd = null;
	/* Column Info */
	private String bkg1 = null;
	/* Column Info */
	private String totalBkg = null;
	/* Column Info */
	private String xptDeclRcv = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fCntcNo = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cgoWgtLb = null;
	/* Column Info */
	private String lclMeasUtCd = null;
	/* Column Info */
	private String ebshRefNo = null;
	/* Column Info */
	private String post4Vvd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String vvd2PolCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String tareLbs = null;
	/* Column Info */
	private String ttlTareWgtKg = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String eqSubstTp = null;
	/* Column Info */
	private String exsMrn = null;
	/* Column Info */
	private String vvd1PodCd = null;
	/* Column Info */
	private String vvd3PolNm = null;
	/* Column Info */
	private String lastPodCd = null;
	/* Column Info */
	private String ttlTareWgtLb = null;
	/* Column Info */
	private String ibPkupYdCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String trunkSlanCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cCust = null;
	/* Column Info */
	private String awkOvrLfLen = null;
	/* Column Info */
	private String awkGrsWgt = null;
	/* Column Info */
	private String awkTtlDimWdt = null;
	/* Column Info */
	private String awkOvrRtLen = null;
	/* Column Info */
	private String cmrnRefNo = null;
	/* Column Info */
	private String lclMeasQty = null;
	/* Column Info */
	private String estPkupDt = null;
	/* Column Info */
	private String esrfRefNo = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lclCntrMfGdsDesc = null;
	/* Column Info */
	private String pre3Vvd = null;
	/* Column Info */
	private String sCntcNo = null;
	/* Column Info */
	private String cgoWgtKg = null;
	/* Column Info */
	private String sCntcNm = null;
	/* Column Info */
	private String post3Vvd = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String modiAtmsFlg = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String totalCntr = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String ibHlgBkg = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String cnmvStsDesc = null;
	/* Column Info */
	private String esshRefNo = null;
	/* Column Info */
	private String ncmNo = null;
	/* Column Info */
	private String ctrlPty = null;
	/* Column Info */
	private String firstPolCutoffDt = null;
	/* Column Info */
	private String rateSts = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String lastPodNm = null;
	/* Column Info */
	private String vvd2PodCd = null;
	/* Column Info */
	private String awkOvrFwrdLen = null;
	/* Column Info */
	private String awkTtlDimHgt = null;
	/* Column Info */
	private String cmdtHsGrpCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String firstPolEtb = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoN = null;
	/* Column Info */
	private String vvd4PolNm = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String wgtBnd = null;
	/* Column Info */
	private String pre2Vvd = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String vvd2PodNm = null;
	/* Column Info */
	private String firstPolEtd = null;
	/* Column Info */
	private String firstPolAtd = null;
	/* Column Info */
	private String ensMrn = null;
	/* Column Info */
	private String obCfsLoc = null;
	/* Column Info */
	private String ttlCgoWgtKg = null;
	/* Column Info */
	private String dgRmk = null;
	/* Column Info */
	private String trspModOb = null;
	/* Column Info */
	private String twnSoNo = null;
	/* Column Info */
	private String vvd3PodCd = null;
	/* Column Info */
	private String aesItnNo = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String post2Vvd = null;
	/* Column Info */
	private String estRtnDt = null;
	/* Column Info */
	private String pre4Vvd = null;
	/* Column Info */
	private String ibClrLocCd = null;
	/* Column Info */
	private String awkTtlDimLen = null;
	/* Column Info */
	private String ttlCgoWgtLb = null;
	/* Column Info */
	private String fCntCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String vvd2PolNm = null;
	/* Column Info */
	private String vvd4PodNm = null;
	/* Column Info */
	private String mtyPkupLoc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BokCntrListOutVO() {}

	public BokCntrListOutVO(String ibflag, String pagerows, String totalBkg, String totalCntr, String ttlPckQty, String ttlTeu, String ttlFeu, String ttlGrsWgtKg, String ttlGrsWgtLb, String ttlTareWgtKg, String ttlTareWgtLb, String ttlCgoWgtKg, String ttlCgoWgtLb, String wgtBnd, String ibPkupYdNm, String estPkupDt, String actPkupDt, String mtyPkupLoc, String estRtnDt, String actRtnDt, String fullRtnLoc, String mtyRtnLoc, String cgoAvalDt, String ctrtCust, String xptDeclRcv, String bkg1, String cntr1, String blNo, String oblIssOfcCd, String creDt, String bkgNo, String bkgOfcCd, String creUsrId, String bkgStsCd, String ctrtSrepCd, String obSrepCd, String rateSts, String slsArea, String slsCd, String obSlsOfcCd, String scacCd, String spclHndlInst, String splitFlg, String xterRmk, String interRmk, String vndrRmk, String lclMeasQty, String lclMeasUtCd, String cgoN, String cgoWgtKg, String cgoWgtLb, String cmdtCd, String cmdtDesc, String cmdtHsCd, String cmdtHsGrpCd, String htsCd, String ncmNo, String lclPckQty, String obCfsLoc, String lclCntrMfGdsDesc, String lclPckTpCd, String cgoCutoffDt, String grsWgtKg, String grsWgtLb, String cntrNo, String cntrVolQty, String teu, String feu, String cntrTpszCd, String cnmvStsCd, String cnmvStsDesc, String tareWgt, String tareLbs, String ibPkupYdCd, String ibClrLocCd, String ibHlgBkg, String obHlgBkg, String pckTpCd, String pckQty, String cntrSealNo, String cntrSealCnt, String eqSubstTp, String cCust, String fCust, String fCntcNm, String fCntcNo, String fCntCd, String fSteCd, String sGrpCust, String ctrlPty, String sCustNm, String sCntcNm, String sCntcNo, String ebffRefNo, String ebrfRefNo, String ebshRefNo, String dgCertiFlg, String ensMrn, String cmrnRefNo, String exsMrn, String finvRefNo, String aesItnNo, String poNo, String rgbkRefNo, String esshRefNo, String esffRefNo, String esrfRefNo, String twnSoNo, String siFlg, String cucrRefNo, String blckStwgCd, String tVvd, String tVslNm, String trdCd, String svcScpCd, String deTermCd, String rcvTermCd, String porCntCd, String porCd, String porNm, String vvd1PolCd, String vvd1PolNm, String vvd2PolCd, String vvd2PolNm, String vvd3PolCd, String vvd3PolNm, String vvd4PolCd, String vvd4PolNm, String vvd1PodCd, String vvd1PodNm, String vvd2PodCd, String vvd2PodNm, String vvd3PodCd, String vvd3PodNm, String vvd4PodCd, String vvd4PodNm, String lastPodCd, String lastPodNm, String delCntCd, String delCd, String delNm, String pre1Vvd, String pre2Vvd, String pre3Vvd, String pre4Vvd, String post1Vvd, String post2Vvd, String post3Vvd, String post4Vvd, String trafModIb, String trafModOb, String trspModIb, String trspModOb, String trunkSlanCd, String trunkPodCd, String trunkPolCd, String trunkVslCd, String firstPolCutoffDt, String firstPolEtb, String firstPolEtd, String firstPolAtd, String lastPodEtb, String lastPodEta, String lastPodAta, String rfaNo, String scNo, String taaNo, String ctrlAtmsFlg, String modiAtmsFlg, String rfRmk, String rfTemp, String vent, String awkRmk, String awkGrsWgt, String awkNetWgt, String awkOvrFwrdLen, String awkOvrHgt, String awkOvrLfLen, String awkOvrBkwdLen, String awkOvrRtLen, String awkTtlDimHgt, String awkTtlDimLen, String awkTtlDimWdt, String dgRmk, String imdgClssCd, String imdgUnNo) {
		this.ebffRefNo = ebffRefNo;
		this.vvd4PodCd = vvd4PodCd;
		this.svcScpCd = svcScpCd;
		this.fCust = fCust;
		this.mtyRtnLoc = mtyRtnLoc;
		this.awkRmk = awkRmk;
		this.vndrRmk = vndrRmk;
		this.vvd1PolCd = vvd1PolCd;
		this.pagerows = pagerows;
		this.cgoAvalDt = cgoAvalDt;
		this.trspModIb = trspModIb;
		this.obSrepCd = obSrepCd;
		this.vvd3PolCd = vvd3PolCd;
		this.tVvd = tVvd;
		this.ctrlAtmsFlg = ctrlAtmsFlg;
		this.ctrtCust = ctrtCust;
		this.actPkupDt = actPkupDt;
		this.cntrTpszCd = cntrTpszCd;
		this.awkOvrBkwdLen = awkOvrBkwdLen;
		this.cmdtHsCd = cmdtHsCd;
		this.grsWgtKg = grsWgtKg;
		this.siFlg = siFlg;
		this.imdgUnNo = imdgUnNo;
		this.oblIssOfcCd = oblIssOfcCd;
		this.bkgOfcCd = bkgOfcCd;
		this.feu = feu;
		this.awkOvrHgt = awkOvrHgt;
		this.trafModIb = trafModIb;
		this.vvd4PolCd = vvd4PolCd;
		this.vvd1PodNm = vvd1PodNm;
		this.cntr1 = cntr1;
		this.ttlGrsWgtKg = ttlGrsWgtKg;
		this.fSteCd = fSteCd;
		this.ebrfRefNo = ebrfRefNo;
		this.post1Vvd = post1Vvd;
		this.esffRefNo = esffRefNo;
		this.poNo = poNo;
		this.bkgNo = bkgNo;
		this.ttlGrsWgtLb = ttlGrsWgtLb;
		this.grsWgtLb = grsWgtLb;
		this.cntrSealCnt = cntrSealCnt;
		this.lclPckQty = lclPckQty;
		this.vvd3PodNm = vvd3PodNm;
		this.cmdtDesc = cmdtDesc;
		this.spclHndlInst = spclHndlInst;
		this.ctrtSrepCd = ctrtSrepCd;
		this.slsCd = slsCd;
		this.ttlFeu = ttlFeu;
		this.rfTemp = rfTemp;
		this.imdgClssCd = imdgClssCd;
		this.lastPodEtb = lastPodEtb;
		this.rfRmk = rfRmk;
		this.lastPodEta = lastPodEta;
		this.vvd1PolNm = vvd1PolNm;
		this.bkgStsCd = bkgStsCd;
		this.finvRefNo = finvRefNo;
		this.cgoCutoffDt = cgoCutoffDt;
		this.trunkVslCd = trunkVslCd;
		this.cnmvStsCd = cnmvStsCd;
		this.actRtnDt = actRtnDt;
		this.interRmk = interRmk;
		this.scacCd = scacCd;
		this.ttlTeu = ttlTeu;
		this.cmdtCd = cmdtCd;
		this.trunkPodCd = trunkPodCd;
		this.htsCd = htsCd;
		this.dgCertiFlg = dgCertiFlg;
		this.pckTpCd = pckTpCd;
		this.ibPkupYdNm = ibPkupYdNm;
		this.lastPodAta = lastPodAta;
		this.obHlgBkg = obHlgBkg;
		this.slsArea = slsArea;
		this.sCustNm = sCustNm;
		this.delNm = delNm;
		this.cucrRefNo = cucrRefNo;
		this.vent = vent;
		this.fullRtnLoc = fullRtnLoc;
		this.taaNo = taaNo;
		this.tVslNm = tVslNm;
		this.cntrNo = cntrNo;
		this.lclPckTpCd = lclPckTpCd;
		this.fCntcNm = fCntcNm;
		this.trafModOb = trafModOb;
		this.sGrpCust = sGrpCust;
		this.awkNetWgt = awkNetWgt;
		this.rgbkRefNo = rgbkRefNo;
		this.trunkPolCd = trunkPolCd;
		this.pre1Vvd = pre1Vvd;
		this.bkg1 = bkg1;
		this.totalBkg = totalBkg;
		this.xptDeclRcv = xptDeclRcv;
		this.trdCd = trdCd;
		this.fCntcNo = fCntcNo;
		this.blckStwgCd = blckStwgCd;
		this.blNo = blNo;
		this.cgoWgtLb = cgoWgtLb;
		this.lclMeasUtCd = lclMeasUtCd;
		this.ebshRefNo = ebshRefNo;
		this.post4Vvd = post4Vvd;
		this.scNo = scNo;
		this.vvd2PolCd = vvd2PolCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.tareLbs = tareLbs;
		this.ttlTareWgtKg = ttlTareWgtKg;
		this.tareWgt = tareWgt;
		this.eqSubstTp = eqSubstTp;
		this.exsMrn = exsMrn;
		this.vvd1PodCd = vvd1PodCd;
		this.vvd3PolNm = vvd3PolNm;
		this.lastPodCd = lastPodCd;
		this.ttlTareWgtLb = ttlTareWgtLb;
		this.ibPkupYdCd = ibPkupYdCd;
		this.delCntCd = delCntCd;
		this.trunkSlanCd = trunkSlanCd;
		this.delCd = delCd;
		this.cCust = cCust;
		this.awkOvrLfLen = awkOvrLfLen;
		this.awkGrsWgt = awkGrsWgt;
		this.awkTtlDimWdt = awkTtlDimWdt;
		this.awkOvrRtLen = awkOvrRtLen;
		this.cmrnRefNo = cmrnRefNo;
		this.lclMeasQty = lclMeasQty;
		this.estPkupDt = estPkupDt;
		this.esrfRefNo = esrfRefNo;
		this.porNm = porNm;
		this.creUsrId = creUsrId;
		this.lclCntrMfGdsDesc = lclCntrMfGdsDesc;
		this.pre3Vvd = pre3Vvd;
		this.sCntcNo = sCntcNo;
		this.cgoWgtKg = cgoWgtKg;
		this.sCntcNm = sCntcNm;
		this.post3Vvd = post3Vvd;
		this.xterRmk = xterRmk;
		this.modiAtmsFlg = modiAtmsFlg;
		this.teu = teu;
		this.totalCntr = totalCntr;
		this.cntrVolQty = cntrVolQty;
		this.ibHlgBkg = ibHlgBkg;
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.cnmvStsDesc = cnmvStsDesc;
		this.esshRefNo = esshRefNo;
		this.ncmNo = ncmNo;
		this.ctrlPty = ctrlPty;
		this.firstPolCutoffDt = firstPolCutoffDt;
		this.rateSts = rateSts;
		this.creDt = creDt;
		this.lastPodNm = lastPodNm;
		this.vvd2PodCd = vvd2PodCd;
		this.awkOvrFwrdLen = awkOvrFwrdLen;
		this.awkTtlDimHgt = awkTtlDimHgt;
		this.cmdtHsGrpCd = cmdtHsGrpCd;
		this.rfaNo = rfaNo;
		this.firstPolEtb = firstPolEtb;
		this.ibflag = ibflag;
		this.cgoN = cgoN;
		this.vvd4PolNm = vvd4PolNm;
		this.pckQty = pckQty;
		this.ttlPckQty = ttlPckQty;
		this.rcvTermCd = rcvTermCd;
		this.wgtBnd = wgtBnd;
		this.pre2Vvd = pre2Vvd;
		this.porCntCd = porCntCd;
		this.vvd2PodNm = vvd2PodNm;
		this.firstPolEtd = firstPolEtd;
		this.firstPolAtd = firstPolAtd;
		this.ensMrn = ensMrn;
		this.obCfsLoc = obCfsLoc;
		this.ttlCgoWgtKg = ttlCgoWgtKg;
		this.dgRmk = dgRmk;
		this.trspModOb = trspModOb;
		this.twnSoNo = twnSoNo;
		this.vvd3PodCd = vvd3PodCd;
		this.aesItnNo = aesItnNo;
		this.deTermCd = deTermCd;
		this.post2Vvd = post2Vvd;
		this.estRtnDt = estRtnDt;
		this.pre4Vvd = pre4Vvd;
		this.ibClrLocCd = ibClrLocCd;
		this.awkTtlDimLen = awkTtlDimLen;
		this.ttlCgoWgtLb = ttlCgoWgtLb;
		this.fCntCd = fCntCd;
		this.cntrSealNo = cntrSealNo;
		this.vvd2PolNm = vvd2PolNm;
		this.vvd4PodNm = vvd4PodNm;
		this.mtyPkupLoc = mtyPkupLoc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ebff_ref_no", getEbffRefNo());
		this.hashColumns.put("vvd4_pod_cd", getVvd4PodCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("f_cust", getFCust());
		this.hashColumns.put("mty_rtn_loc", getMtyRtnLoc());
		this.hashColumns.put("awk_rmk", getAwkRmk());
		this.hashColumns.put("vndr_rmk", getVndrRmk());
		this.hashColumns.put("vvd1_pol_cd", getVvd1PolCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cgo_aval_dt", getCgoAvalDt());
		this.hashColumns.put("trsp_mod_ib", getTrspModIb());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("vvd3_pol_cd", getVvd3PolCd());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("ctrl_atms_flg", getCtrlAtmsFlg());
		this.hashColumns.put("ctrt_cust", getCtrtCust());
		this.hashColumns.put("act_pkup_dt", getActPkupDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("awk_ovr_bkwd_len", getAwkOvrBkwdLen());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("grs_wgt_kg", getGrsWgtKg());
		this.hashColumns.put("si_flg", getSiFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("awk_ovr_hgt", getAwkOvrHgt());
		this.hashColumns.put("traf_mod_ib", getTrafModIb());
		this.hashColumns.put("vvd4_pol_cd", getVvd4PolCd());
		this.hashColumns.put("vvd1_pod_nm", getVvd1PodNm());
		this.hashColumns.put("cntr_1", getCntr1());
		this.hashColumns.put("ttl_grs_wgt_kg", getTtlGrsWgtKg());
		this.hashColumns.put("f_ste_cd", getFSteCd());
		this.hashColumns.put("ebrf_ref_no", getEbrfRefNo());
		this.hashColumns.put("post1_vvd", getPost1Vvd());
		this.hashColumns.put("esff_ref_no", getEsffRefNo());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ttl_grs_wgt_lb", getTtlGrsWgtLb());
		this.hashColumns.put("grs_wgt_lb", getGrsWgtLb());
		this.hashColumns.put("cntr_seal_cnt", getCntrSealCnt());
		this.hashColumns.put("lcl_pck_qty", getLclPckQty());
		this.hashColumns.put("vvd3_pod_nm", getVvd3PodNm());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("spcl_hndl_inst", getSpclHndlInst());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("sls_cd", getSlsCd());
		this.hashColumns.put("ttl_feu", getTtlFeu());
		this.hashColumns.put("rf_temp", getRfTemp());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("last_pod_etb", getLastPodEtb());
		this.hashColumns.put("rf_rmk", getRfRmk());
		this.hashColumns.put("last_pod_eta", getLastPodEta());
		this.hashColumns.put("vvd1_pol_nm", getVvd1PolNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("finv_ref_no", getFinvRefNo());
		this.hashColumns.put("cgo_cutoff_dt", getCgoCutoffDt());
		this.hashColumns.put("trunk_vsl_cd", getTrunkVslCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("act_rtn_dt", getActRtnDt());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("ttl_teu", getTtlTeu());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("trunk_pod_cd", getTrunkPodCd());
		this.hashColumns.put("hts_cd", getHtsCd());
		this.hashColumns.put("dg_certi_flg", getDgCertiFlg());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ib_pkup_yd_nm", getIbPkupYdNm());
		this.hashColumns.put("last_pod_ata", getLastPodAta());
		this.hashColumns.put("ob_hlg_bkg", getObHlgBkg());
		this.hashColumns.put("sls_area", getSlsArea());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("cucr_ref_no", getCucrRefNo());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("full_rtn_loc", getFullRtnLoc());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("t_vsl_nm", getTVslNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("lcl_pck_tp_cd", getLclPckTpCd());
		this.hashColumns.put("f_cntc_nm", getFCntcNm());
		this.hashColumns.put("traf_mod_ob", getTrafModOb());
		this.hashColumns.put("s_grp_cust", getSGrpCust());
		this.hashColumns.put("awk_net_wgt", getAwkNetWgt());
		this.hashColumns.put("rgbk_ref_no", getRgbkRefNo());
		this.hashColumns.put("trunk_pol_cd", getTrunkPolCd());
		this.hashColumns.put("pre1_vvd", getPre1Vvd());
		this.hashColumns.put("bkg_1", getBkg1());
		this.hashColumns.put("total_bkg", getTotalBkg());
		this.hashColumns.put("xpt_decl_rcv", getXptDeclRcv());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("f_cntc_no", getFCntcNo());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cgo_wgt_lb", getCgoWgtLb());
		this.hashColumns.put("lcl_meas_ut_cd", getLclMeasUtCd());
		this.hashColumns.put("ebsh_ref_no", getEbshRefNo());
		this.hashColumns.put("post4_vvd", getPost4Vvd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("vvd2_pol_cd", getVvd2PolCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("tare_lbs", getTareLbs());
		this.hashColumns.put("ttl_tare_wgt_kg", getTtlTareWgtKg());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("eq_subst_tp", getEqSubstTp());
		this.hashColumns.put("exs_mrn", getExsMrn());
		this.hashColumns.put("vvd1_pod_cd", getVvd1PodCd());
		this.hashColumns.put("vvd3_pol_nm", getVvd3PolNm());
		this.hashColumns.put("last_pod_cd", getLastPodCd());
		this.hashColumns.put("ttl_tare_wgt_lb", getTtlTareWgtLb());
		this.hashColumns.put("ib_pkup_yd_cd", getIbPkupYdCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("trunk_slan_cd", getTrunkSlanCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("c_cust", getCCust());
		this.hashColumns.put("awk_ovr_lf_len", getAwkOvrLfLen());
		this.hashColumns.put("awk_grs_wgt", getAwkGrsWgt());
		this.hashColumns.put("awk_ttl_dim_wdt", getAwkTtlDimWdt());
		this.hashColumns.put("awk_ovr_rt_len", getAwkOvrRtLen());
		this.hashColumns.put("cmrn_ref_no", getCmrnRefNo());
		this.hashColumns.put("lcl_meas_qty", getLclMeasQty());
		this.hashColumns.put("est_pkup_dt", getEstPkupDt());
		this.hashColumns.put("esrf_ref_no", getEsrfRefNo());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lcl_cntr_mf_gds_desc", getLclCntrMfGdsDesc());
		this.hashColumns.put("pre3_vvd", getPre3Vvd());
		this.hashColumns.put("s_cntc_no", getSCntcNo());
		this.hashColumns.put("cgo_wgt_kg", getCgoWgtKg());
		this.hashColumns.put("s_cntc_nm", getSCntcNm());
		this.hashColumns.put("post3_vvd", getPost3Vvd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("modi_atms_flg", getModiAtmsFlg());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("total_cntr", getTotalCntr());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("ib_hlg_bkg", getIbHlgBkg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("cnmv_sts_desc", getCnmvStsDesc());
		this.hashColumns.put("essh_ref_no", getEsshRefNo());
		this.hashColumns.put("ncm_no", getNcmNo());
		this.hashColumns.put("ctrl_pty", getCtrlPty());
		this.hashColumns.put("first_pol_cutoff_dt", getFirstPolCutoffDt());
		this.hashColumns.put("rate_sts", getRateSts());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("last_pod_nm", getLastPodNm());
		this.hashColumns.put("vvd2_pod_cd", getVvd2PodCd());
		this.hashColumns.put("awk_ovr_fwrd_len", getAwkOvrFwrdLen());
		this.hashColumns.put("awk_ttl_dim_hgt", getAwkTtlDimHgt());
		this.hashColumns.put("cmdt_hs_grp_cd", getCmdtHsGrpCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("first_pol_etb", getFirstPolEtb());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_n", getCgoN());
		this.hashColumns.put("vvd4_pol_nm", getVvd4PolNm());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("wgt_bnd", getWgtBnd());
		this.hashColumns.put("pre2_vvd", getPre2Vvd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("vvd2_pod_nm", getVvd2PodNm());
		this.hashColumns.put("first_pol_etd", getFirstPolEtd());
		this.hashColumns.put("first_pol_atd", getFirstPolAtd());
		this.hashColumns.put("ens_mrn", getEnsMrn());
		this.hashColumns.put("ob_cfs_loc", getObCfsLoc());
		this.hashColumns.put("ttl_cgo_wgt_kg", getTtlCgoWgtKg());
		this.hashColumns.put("dg_rmk", getDgRmk());
		this.hashColumns.put("trsp_mod_ob", getTrspModOb());
		this.hashColumns.put("twn_so_no", getTwnSoNo());
		this.hashColumns.put("vvd3_pod_cd", getVvd3PodCd());
		this.hashColumns.put("aes_itn_no", getAesItnNo());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("post2_vvd", getPost2Vvd());
		this.hashColumns.put("est_rtn_dt", getEstRtnDt());
		this.hashColumns.put("pre4_vvd", getPre4Vvd());
		this.hashColumns.put("ib_clr_loc_cd", getIbClrLocCd());
		this.hashColumns.put("awk_ttl_dim_len", getAwkTtlDimLen());
		this.hashColumns.put("ttl_cgo_wgt_lb", getTtlCgoWgtLb());
		this.hashColumns.put("f_cnt_cd", getFCntCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("vvd2_pol_nm", getVvd2PolNm());
		this.hashColumns.put("vvd4_pod_nm", getVvd4PodNm());
		this.hashColumns.put("mty_pkup_loc", getMtyPkupLoc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ebff_ref_no", "ebffRefNo");
		this.hashFields.put("vvd4_pod_cd", "vvd4PodCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("f_cust", "fCust");
		this.hashFields.put("mty_rtn_loc", "mtyRtnLoc");
		this.hashFields.put("awk_rmk", "awkRmk");
		this.hashFields.put("vndr_rmk", "vndrRmk");
		this.hashFields.put("vvd1_pol_cd", "vvd1PolCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cgo_aval_dt", "cgoAvalDt");
		this.hashFields.put("trsp_mod_ib", "trspModIb");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("vvd3_pol_cd", "vvd3PolCd");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("ctrl_atms_flg", "ctrlAtmsFlg");
		this.hashFields.put("ctrt_cust", "ctrtCust");
		this.hashFields.put("act_pkup_dt", "actPkupDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("awk_ovr_bkwd_len", "awkOvrBkwdLen");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("grs_wgt_kg", "grsWgtKg");
		this.hashFields.put("si_flg", "siFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("awk_ovr_hgt", "awkOvrHgt");
		this.hashFields.put("traf_mod_ib", "trafModIb");
		this.hashFields.put("vvd4_pol_cd", "vvd4PolCd");
		this.hashFields.put("vvd1_pod_nm", "vvd1PodNm");
		this.hashFields.put("cntr_1", "cntr1");
		this.hashFields.put("ttl_grs_wgt_kg", "ttlGrsWgtKg");
		this.hashFields.put("f_ste_cd", "fSteCd");
		this.hashFields.put("ebrf_ref_no", "ebrfRefNo");
		this.hashFields.put("post1_vvd", "post1Vvd");
		this.hashFields.put("esff_ref_no", "esffRefNo");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ttl_grs_wgt_lb", "ttlGrsWgtLb");
		this.hashFields.put("grs_wgt_lb", "grsWgtLb");
		this.hashFields.put("cntr_seal_cnt", "cntrSealCnt");
		this.hashFields.put("lcl_pck_qty", "lclPckQty");
		this.hashFields.put("vvd3_pod_nm", "vvd3PodNm");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("spcl_hndl_inst", "spclHndlInst");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("sls_cd", "slsCd");
		this.hashFields.put("ttl_feu", "ttlFeu");
		this.hashFields.put("rf_temp", "rfTemp");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("last_pod_etb", "lastPodEtb");
		this.hashFields.put("rf_rmk", "rfRmk");
		this.hashFields.put("last_pod_eta", "lastPodEta");
		this.hashFields.put("vvd1_pol_nm", "vvd1PolNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("finv_ref_no", "finvRefNo");
		this.hashFields.put("cgo_cutoff_dt", "cgoCutoffDt");
		this.hashFields.put("trunk_vsl_cd", "trunkVslCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("act_rtn_dt", "actRtnDt");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("ttl_teu", "ttlTeu");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("trunk_pod_cd", "trunkPodCd");
		this.hashFields.put("hts_cd", "htsCd");
		this.hashFields.put("dg_certi_flg", "dgCertiFlg");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ib_pkup_yd_nm", "ibPkupYdNm");
		this.hashFields.put("last_pod_ata", "lastPodAta");
		this.hashFields.put("ob_hlg_bkg", "obHlgBkg");
		this.hashFields.put("sls_area", "slsArea");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("cucr_ref_no", "cucrRefNo");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("full_rtn_loc", "fullRtnLoc");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("t_vsl_nm", "tVslNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("lcl_pck_tp_cd", "lclPckTpCd");
		this.hashFields.put("f_cntc_nm", "fCntcNm");
		this.hashFields.put("traf_mod_ob", "trafModOb");
		this.hashFields.put("s_grp_cust", "sGrpCust");
		this.hashFields.put("awk_net_wgt", "awkNetWgt");
		this.hashFields.put("rgbk_ref_no", "rgbkRefNo");
		this.hashFields.put("trunk_pol_cd", "trunkPolCd");
		this.hashFields.put("pre1_vvd", "pre1Vvd");
		this.hashFields.put("bkg_1", "bkg1");
		this.hashFields.put("total_bkg", "totalBkg");
		this.hashFields.put("xpt_decl_rcv", "xptDeclRcv");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("f_cntc_no", "fCntcNo");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cgo_wgt_lb", "cgoWgtLb");
		this.hashFields.put("lcl_meas_ut_cd", "lclMeasUtCd");
		this.hashFields.put("ebsh_ref_no", "ebshRefNo");
		this.hashFields.put("post4_vvd", "post4Vvd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("vvd2_pol_cd", "vvd2PolCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("tare_lbs", "tareLbs");
		this.hashFields.put("ttl_tare_wgt_kg", "ttlTareWgtKg");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("eq_subst_tp", "eqSubstTp");
		this.hashFields.put("exs_mrn", "exsMrn");
		this.hashFields.put("vvd1_pod_cd", "vvd1PodCd");
		this.hashFields.put("vvd3_pol_nm", "vvd3PolNm");
		this.hashFields.put("last_pod_cd", "lastPodCd");
		this.hashFields.put("ttl_tare_wgt_lb", "ttlTareWgtLb");
		this.hashFields.put("ib_pkup_yd_cd", "ibPkupYdCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("trunk_slan_cd", "trunkSlanCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("c_cust", "cCust");
		this.hashFields.put("awk_ovr_lf_len", "awkOvrLfLen");
		this.hashFields.put("awk_grs_wgt", "awkGrsWgt");
		this.hashFields.put("awk_ttl_dim_wdt", "awkTtlDimWdt");
		this.hashFields.put("awk_ovr_rt_len", "awkOvrRtLen");
		this.hashFields.put("cmrn_ref_no", "cmrnRefNo");
		this.hashFields.put("lcl_meas_qty", "lclMeasQty");
		this.hashFields.put("est_pkup_dt", "estPkupDt");
		this.hashFields.put("esrf_ref_no", "esrfRefNo");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lcl_cntr_mf_gds_desc", "lclCntrMfGdsDesc");
		this.hashFields.put("pre3_vvd", "pre3Vvd");
		this.hashFields.put("s_cntc_no", "sCntcNo");
		this.hashFields.put("cgo_wgt_kg", "cgoWgtKg");
		this.hashFields.put("s_cntc_nm", "sCntcNm");
		this.hashFields.put("post3_vvd", "post3Vvd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("modi_atms_flg", "modiAtmsFlg");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("total_cntr", "totalCntr");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("ib_hlg_bkg", "ibHlgBkg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("cnmv_sts_desc", "cnmvStsDesc");
		this.hashFields.put("essh_ref_no", "esshRefNo");
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("ctrl_pty", "ctrlPty");
		this.hashFields.put("first_pol_cutoff_dt", "firstPolCutoffDt");
		this.hashFields.put("rate_sts", "rateSts");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("last_pod_nm", "lastPodNm");
		this.hashFields.put("vvd2_pod_cd", "vvd2PodCd");
		this.hashFields.put("awk_ovr_fwrd_len", "awkOvrFwrdLen");
		this.hashFields.put("awk_ttl_dim_hgt", "awkTtlDimHgt");
		this.hashFields.put("cmdt_hs_grp_cd", "cmdtHsGrpCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("first_pol_etb", "firstPolEtb");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_n", "cgoN");
		this.hashFields.put("vvd4_pol_nm", "vvd4PolNm");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("wgt_bnd", "wgtBnd");
		this.hashFields.put("pre2_vvd", "pre2Vvd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("vvd2_pod_nm", "vvd2PodNm");
		this.hashFields.put("first_pol_etd", "firstPolEtd");
		this.hashFields.put("first_pol_atd", "firstPolAtd");
		this.hashFields.put("ens_mrn", "ensMrn");
		this.hashFields.put("ob_cfs_loc", "obCfsLoc");
		this.hashFields.put("ttl_cgo_wgt_kg", "ttlCgoWgtKg");
		this.hashFields.put("dg_rmk", "dgRmk");
		this.hashFields.put("trsp_mod_ob", "trspModOb");
		this.hashFields.put("twn_so_no", "twnSoNo");
		this.hashFields.put("vvd3_pod_cd", "vvd3PodCd");
		this.hashFields.put("aes_itn_no", "aesItnNo");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("post2_vvd", "post2Vvd");
		this.hashFields.put("est_rtn_dt", "estRtnDt");
		this.hashFields.put("pre4_vvd", "pre4Vvd");
		this.hashFields.put("ib_clr_loc_cd", "ibClrLocCd");
		this.hashFields.put("awk_ttl_dim_len", "awkTtlDimLen");
		this.hashFields.put("ttl_cgo_wgt_lb", "ttlCgoWgtLb");
		this.hashFields.put("f_cnt_cd", "fCntCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("vvd2_pol_nm", "vvd2PolNm");
		this.hashFields.put("vvd4_pod_nm", "vvd4PodNm");
		this.hashFields.put("mty_pkup_loc", "mtyPkupLoc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ebffRefNo
	 */
	public String getEbffRefNo() {
		return this.ebffRefNo;
	}
	
	/**
	 * Column Info
	 * @return vvd4PodCd
	 */
	public String getVvd4PodCd() {
		return this.vvd4PodCd;
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
	 * @return fCust
	 */
	public String getFCust() {
		return this.fCust;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnLoc
	 */
	public String getMtyRtnLoc() {
		return this.mtyRtnLoc;
	}
	
	/**
	 * Column Info
	 * @return awkRmk
	 */
	public String getAwkRmk() {
		return this.awkRmk;
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
	 * @return vvd1PolCd
	 */
	public String getVvd1PolCd() {
		return this.vvd1PolCd;
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
	 * @return cgoAvalDt
	 */
	public String getCgoAvalDt() {
		return this.cgoAvalDt;
	}
	
	/**
	 * Column Info
	 * @return trspModIb
	 */
	public String getTrspModIb() {
		return this.trspModIb;
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
	 * @return vvd3PolCd
	 */
	public String getVvd3PolCd() {
		return this.vvd3PolCd;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return ctrlAtmsFlg
	 */
	public String getCtrlAtmsFlg() {
		return this.ctrlAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtCust
	 */
	public String getCtrtCust() {
		return this.ctrtCust;
	}
	
	/**
	 * Column Info
	 * @return actPkupDt
	 */
	public String getActPkupDt() {
		return this.actPkupDt;
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
	 * @return awkOvrBkwdLen
	 */
	public String getAwkOvrBkwdLen() {
		return this.awkOvrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return grsWgtKg
	 */
	public String getGrsWgtKg() {
		return this.grsWgtKg;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
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
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return awkOvrHgt
	 */
	public String getAwkOvrHgt() {
		return this.awkOvrHgt;
	}
	
	/**
	 * Column Info
	 * @return trafModIb
	 */
	public String getTrafModIb() {
		return this.trafModIb;
	}
	
	/**
	 * Column Info
	 * @return vvd4PolCd
	 */
	public String getVvd4PolCd() {
		return this.vvd4PolCd;
	}
	
	/**
	 * Column Info
	 * @return vvd1PodNm
	 */
	public String getVvd1PodNm() {
		return this.vvd1PodNm;
	}
	
	/**
	 * Column Info
	 * @return cntr1
	 */
	public String getCntr1() {
		return this.cntr1;
	}
	
	/**
	 * Column Info
	 * @return ttlGrsWgtKg
	 */
	public String getTtlGrsWgtKg() {
		return this.ttlGrsWgtKg;
	}
	
	/**
	 * Column Info
	 * @return fSteCd
	 */
	public String getFSteCd() {
		return this.fSteCd;
	}
	
	/**
	 * Column Info
	 * @return ebrfRefNo
	 */
	public String getEbrfRefNo() {
		return this.ebrfRefNo;
	}
	
	/**
	 * Column Info
	 * @return post1Vvd
	 */
	public String getPost1Vvd() {
		return this.post1Vvd;
	}
	
	/**
	 * Column Info
	 * @return esffRefNo
	 */
	public String getEsffRefNo() {
		return this.esffRefNo;
	}
	
	/**
	 * Column Info
	 * @return poNo
	 */
	public String getPoNo() {
		return this.poNo;
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
	 * @return ttlGrsWgtLb
	 */
	public String getTtlGrsWgtLb() {
		return this.ttlGrsWgtLb;
	}
	
	/**
	 * Column Info
	 * @return grsWgtLb
	 */
	public String getGrsWgtLb() {
		return this.grsWgtLb;
	}
	
	/**
	 * Column Info
	 * @return cntrSealCnt
	 */
	public String getCntrSealCnt() {
		return this.cntrSealCnt;
	}
	
	/**
	 * Column Info
	 * @return lclPckQty
	 */
	public String getLclPckQty() {
		return this.lclPckQty;
	}
	
	/**
	 * Column Info
	 * @return vvd3PodNm
	 */
	public String getVvd3PodNm() {
		return this.vvd3PodNm;
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
	 * @return spclHndlInst
	 */
	public String getSpclHndlInst() {
		return this.spclHndlInst;
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
	 * @return slsCd
	 */
	public String getSlsCd() {
		return this.slsCd;
	}
	
	/**
	 * Column Info
	 * @return ttlFeu
	 */
	public String getTtlFeu() {
		return this.ttlFeu;
	}
	
	/**
	 * Column Info
	 * @return rfTemp
	 */
	public String getRfTemp() {
		return this.rfTemp;
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
	 * @return lastPodEtb
	 */
	public String getLastPodEtb() {
		return this.lastPodEtb;
	}
	
	/**
	 * Column Info
	 * @return rfRmk
	 */
	public String getRfRmk() {
		return this.rfRmk;
	}
	
	/**
	 * Column Info
	 * @return lastPodEta
	 */
	public String getLastPodEta() {
		return this.lastPodEta;
	}
	
	/**
	 * Column Info
	 * @return vvd1PolNm
	 */
	public String getVvd1PolNm() {
		return this.vvd1PolNm;
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
	 * @return finvRefNo
	 */
	public String getFinvRefNo() {
		return this.finvRefNo;
	}
	
	/**
	 * Column Info
	 * @return cgoCutoffDt
	 */
	public String getCgoCutoffDt() {
		return this.cgoCutoffDt;
	}
	
	/**
	 * Column Info
	 * @return trunkVslCd
	 */
	public String getTrunkVslCd() {
		return this.trunkVslCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return actRtnDt
	 */
	public String getActRtnDt() {
		return this.actRtnDt;
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
	 * @return ttlTeu
	 */
	public String getTtlTeu() {
		return this.ttlTeu;
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
	 * @return trunkPodCd
	 */
	public String getTrunkPodCd() {
		return this.trunkPodCd;
	}
	
	/**
	 * Column Info
	 * @return htsCd
	 */
	public String getHtsCd() {
		return this.htsCd;
	}
	
	/**
	 * Column Info
	 * @return dgCertiFlg
	 */
	public String getDgCertiFlg() {
		return this.dgCertiFlg;
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
	 * @return ibPkupYdNm
	 */
	public String getIbPkupYdNm() {
		return this.ibPkupYdNm;
	}
	
	/**
	 * Column Info
	 * @return lastPodAta
	 */
	public String getLastPodAta() {
		return this.lastPodAta;
	}
	
	/**
	 * Column Info
	 * @return obHlgBkg
	 */
	public String getObHlgBkg() {
		return this.obHlgBkg;
	}
	
	/**
	 * Column Info
	 * @return slsArea
	 */
	public String getSlsArea() {
		return this.slsArea;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
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
	 * @return cucrRefNo
	 */
	public String getCucrRefNo() {
		return this.cucrRefNo;
	}
	
	/**
	 * Column Info
	 * @return vent
	 */
	public String getVent() {
		return this.vent;
	}
	
	/**
	 * Column Info
	 * @return fullRtnLoc
	 */
	public String getFullRtnLoc() {
		return this.fullRtnLoc;
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
	 * @return tVslNm
	 */
	public String getTVslNm() {
		return this.tVslNm;
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
	 * @return lclPckTpCd
	 */
	public String getLclPckTpCd() {
		return this.lclPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return fCntcNm
	 */
	public String getFCntcNm() {
		return this.fCntcNm;
	}
	
	/**
	 * Column Info
	 * @return trafModOb
	 */
	public String getTrafModOb() {
		return this.trafModOb;
	}
	
	/**
	 * Column Info
	 * @return sGrpCust
	 */
	public String getSGrpCust() {
		return this.sGrpCust;
	}
	
	/**
	 * Column Info
	 * @return awkNetWgt
	 */
	public String getAwkNetWgt() {
		return this.awkNetWgt;
	}
	
	/**
	 * Column Info
	 * @return rgbkRefNo
	 */
	public String getRgbkRefNo() {
		return this.rgbkRefNo;
	}
	
	/**
	 * Column Info
	 * @return trunkPolCd
	 */
	public String getTrunkPolCd() {
		return this.trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @return pre1Vvd
	 */
	public String getPre1Vvd() {
		return this.pre1Vvd;
	}
	
	/**
	 * Column Info
	 * @return bkg1
	 */
	public String getBkg1() {
		return this.bkg1;
	}
	
	/**
	 * Column Info
	 * @return totalBkg
	 */
	public String getTotalBkg() {
		return this.totalBkg;
	}
	
	/**
	 * Column Info
	 * @return xptDeclRcv
	 */
	public String getXptDeclRcv() {
		return this.xptDeclRcv;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return fCntcNo
	 */
	public String getFCntcNo() {
		return this.fCntcNo;
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
	 * @return cgoWgtLb
	 */
	public String getCgoWgtLb() {
		return this.cgoWgtLb;
	}
	
	/**
	 * Column Info
	 * @return lclMeasUtCd
	 */
	public String getLclMeasUtCd() {
		return this.lclMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return ebshRefNo
	 */
	public String getEbshRefNo() {
		return this.ebshRefNo;
	}
	
	/**
	 * Column Info
	 * @return post4Vvd
	 */
	public String getPost4Vvd() {
		return this.post4Vvd;
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
	 * @return vvd2PolCd
	 */
	public String getVvd2PolCd() {
		return this.vvd2PolCd;
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
	 * @return tareLbs
	 */
	public String getTareLbs() {
		return this.tareLbs;
	}
	
	/**
	 * Column Info
	 * @return ttlTareWgtKg
	 */
	public String getTtlTareWgtKg() {
		return this.ttlTareWgtKg;
	}
	
	/**
	 * Column Info
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
	}
	
	/**
	 * Column Info
	 * @return eqSubstTp
	 */
	public String getEqSubstTp() {
		return this.eqSubstTp;
	}
	
	/**
	 * Column Info
	 * @return exsMrn
	 */
	public String getExsMrn() {
		return this.exsMrn;
	}
	
	/**
	 * Column Info
	 * @return vvd1PodCd
	 */
	public String getVvd1PodCd() {
		return this.vvd1PodCd;
	}
	
	/**
	 * Column Info
	 * @return vvd3PolNm
	 */
	public String getVvd3PolNm() {
		return this.vvd3PolNm;
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
	 * @return ttlTareWgtLb
	 */
	public String getTtlTareWgtLb() {
		return this.ttlTareWgtLb;
	}
	
	/**
	 * Column Info
	 * @return ibPkupYdCd
	 */
	public String getIbPkupYdCd() {
		return this.ibPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return trunkSlanCd
	 */
	public String getTrunkSlanCd() {
		return this.trunkSlanCd;
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
	 * @return cCust
	 */
	public String getCCust() {
		return this.cCust;
	}
	
	/**
	 * Column Info
	 * @return awkOvrLfLen
	 */
	public String getAwkOvrLfLen() {
		return this.awkOvrLfLen;
	}
	
	/**
	 * Column Info
	 * @return awkGrsWgt
	 */
	public String getAwkGrsWgt() {
		return this.awkGrsWgt;
	}
	
	/**
	 * Column Info
	 * @return awkTtlDimWdt
	 */
	public String getAwkTtlDimWdt() {
		return this.awkTtlDimWdt;
	}
	
	/**
	 * Column Info
	 * @return awkOvrRtLen
	 */
	public String getAwkOvrRtLen() {
		return this.awkOvrRtLen;
	}
	
	/**
	 * Column Info
	 * @return cmrnRefNo
	 */
	public String getCmrnRefNo() {
		return this.cmrnRefNo;
	}
	
	/**
	 * Column Info
	 * @return lclMeasQty
	 */
	public String getLclMeasQty() {
		return this.lclMeasQty;
	}
	
	/**
	 * Column Info
	 * @return estPkupDt
	 */
	public String getEstPkupDt() {
		return this.estPkupDt;
	}
	
	/**
	 * Column Info
	 * @return esrfRefNo
	 */
	public String getEsrfRefNo() {
		return this.esrfRefNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return lclCntrMfGdsDesc
	 */
	public String getLclCntrMfGdsDesc() {
		return this.lclCntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return pre3Vvd
	 */
	public String getPre3Vvd() {
		return this.pre3Vvd;
	}
	
	/**
	 * Column Info
	 * @return sCntcNo
	 */
	public String getSCntcNo() {
		return this.sCntcNo;
	}
	
	/**
	 * Column Info
	 * @return cgoWgtKg
	 */
	public String getCgoWgtKg() {
		return this.cgoWgtKg;
	}
	
	/**
	 * Column Info
	 * @return sCntcNm
	 */
	public String getSCntcNm() {
		return this.sCntcNm;
	}
	
	/**
	 * Column Info
	 * @return post3Vvd
	 */
	public String getPost3Vvd() {
		return this.post3Vvd;
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
	 * @return modiAtmsFlg
	 */
	public String getModiAtmsFlg() {
		return this.modiAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return totalCntr
	 */
	public String getTotalCntr() {
		return this.totalCntr;
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
	 * @return ibHlgBkg
	 */
	public String getIbHlgBkg() {
		return this.ibHlgBkg;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsDesc
	 */
	public String getCnmvStsDesc() {
		return this.cnmvStsDesc;
	}
	
	/**
	 * Column Info
	 * @return esshRefNo
	 */
	public String getEsshRefNo() {
		return this.esshRefNo;
	}
	
	/**
	 * Column Info
	 * @return ncmNo
	 */
	public String getNcmNo() {
		return this.ncmNo;
	}
	
	/**
	 * Column Info
	 * @return ctrlPty
	 */
	public String getCtrlPty() {
		return this.ctrlPty;
	}
	
	/**
	 * Column Info
	 * @return firstPolCutoffDt
	 */
	public String getFirstPolCutoffDt() {
		return this.firstPolCutoffDt;
	}
	
	/**
	 * Column Info
	 * @return rateSts
	 */
	public String getRateSts() {
		return this.rateSts;
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
	 * @return lastPodNm
	 */
	public String getLastPodNm() {
		return this.lastPodNm;
	}
	
	/**
	 * Column Info
	 * @return vvd2PodCd
	 */
	public String getVvd2PodCd() {
		return this.vvd2PodCd;
	}
	
	/**
	 * Column Info
	 * @return awkOvrFwrdLen
	 */
	public String getAwkOvrFwrdLen() {
		return this.awkOvrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @return awkTtlDimHgt
	 */
	public String getAwkTtlDimHgt() {
		return this.awkTtlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsGrpCd
	 */
	public String getCmdtHsGrpCd() {
		return this.cmdtHsGrpCd;
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
	 * @return firstPolEtb
	 */
	public String getFirstPolEtb() {
		return this.firstPolEtb;
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
	 * @return cgoN
	 */
	public String getCgoN() {
		return this.cgoN;
	}
	
	/**
	 * Column Info
	 * @return vvd4PolNm
	 */
	public String getVvd4PolNm() {
		return this.vvd4PolNm;
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
	 * @return ttlPckQty
	 */
	public String getTtlPckQty() {
		return this.ttlPckQty;
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
	 * @return wgtBnd
	 */
	public String getWgtBnd() {
		return this.wgtBnd;
	}
	
	/**
	 * Column Info
	 * @return pre2Vvd
	 */
	public String getPre2Vvd() {
		return this.pre2Vvd;
	}
	
	/**
	 * Column Info
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
	}
	
	/**
	 * Column Info
	 * @return vvd2PodNm
	 */
	public String getVvd2PodNm() {
		return this.vvd2PodNm;
	}
	
	/**
	 * Column Info
	 * @return firstPolEtd
	 */
	public String getFirstPolEtd() {
		return this.firstPolEtd;
	}
	
	/**
	 * Column Info
	 * @return firstPolAtd
	 */
	public String getFirstPolAtd() {
		return this.firstPolAtd;
	}
	
	/**
	 * Column Info
	 * @return ensMrn
	 */
	public String getEnsMrn() {
		return this.ensMrn;
	}
	
	/**
	 * Column Info
	 * @return obCfsLoc
	 */
	public String getObCfsLoc() {
		return this.obCfsLoc;
	}
	
	/**
	 * Column Info
	 * @return ttlCgoWgtKg
	 */
	public String getTtlCgoWgtKg() {
		return this.ttlCgoWgtKg;
	}
	
	/**
	 * Column Info
	 * @return dgRmk
	 */
	public String getDgRmk() {
		return this.dgRmk;
	}
	
	/**
	 * Column Info
	 * @return trspModOb
	 */
	public String getTrspModOb() {
		return this.trspModOb;
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
	 * @return vvd3PodCd
	 */
	public String getVvd3PodCd() {
		return this.vvd3PodCd;
	}
	
	/**
	 * Column Info
	 * @return aesItnNo
	 */
	public String getAesItnNo() {
		return this.aesItnNo;
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
	 * @return post2Vvd
	 */
	public String getPost2Vvd() {
		return this.post2Vvd;
	}
	
	/**
	 * Column Info
	 * @return estRtnDt
	 */
	public String getEstRtnDt() {
		return this.estRtnDt;
	}
	
	/**
	 * Column Info
	 * @return pre4Vvd
	 */
	public String getPre4Vvd() {
		return this.pre4Vvd;
	}
	
	/**
	 * Column Info
	 * @return ibClrLocCd
	 */
	public String getIbClrLocCd() {
		return this.ibClrLocCd;
	}
	
	/**
	 * Column Info
	 * @return awkTtlDimLen
	 */
	public String getAwkTtlDimLen() {
		return this.awkTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @return ttlCgoWgtLb
	 */
	public String getTtlCgoWgtLb() {
		return this.ttlCgoWgtLb;
	}
	
	/**
	 * Column Info
	 * @return fCntCd
	 */
	public String getFCntCd() {
		return this.fCntCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return vvd2PolNm
	 */
	public String getVvd2PolNm() {
		return this.vvd2PolNm;
	}
	
	/**
	 * Column Info
	 * @return vvd4PodNm
	 */
	public String getVvd4PodNm() {
		return this.vvd4PodNm;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupLoc
	 */
	public String getMtyPkupLoc() {
		return this.mtyPkupLoc;
	}
	

	/**
	 * Column Info
	 * @param ebffRefNo
	 */
	public void setEbffRefNo(String ebffRefNo) {
		this.ebffRefNo = ebffRefNo;
	}
	
	/**
	 * Column Info
	 * @param vvd4PodCd
	 */
	public void setVvd4PodCd(String vvd4PodCd) {
		this.vvd4PodCd = vvd4PodCd;
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
	 * @param fCust
	 */
	public void setFCust(String fCust) {
		this.fCust = fCust;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnLoc
	 */
	public void setMtyRtnLoc(String mtyRtnLoc) {
		this.mtyRtnLoc = mtyRtnLoc;
	}
	
	/**
	 * Column Info
	 * @param awkRmk
	 */
	public void setAwkRmk(String awkRmk) {
		this.awkRmk = awkRmk;
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
	 * @param vvd1PolCd
	 */
	public void setVvd1PolCd(String vvd1PolCd) {
		this.vvd1PolCd = vvd1PolCd;
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
	 * @param cgoAvalDt
	 */
	public void setCgoAvalDt(String cgoAvalDt) {
		this.cgoAvalDt = cgoAvalDt;
	}
	
	/**
	 * Column Info
	 * @param trspModIb
	 */
	public void setTrspModIb(String trspModIb) {
		this.trspModIb = trspModIb;
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
	 * @param vvd3PolCd
	 */
	public void setVvd3PolCd(String vvd3PolCd) {
		this.vvd3PolCd = vvd3PolCd;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param ctrlAtmsFlg
	 */
	public void setCtrlAtmsFlg(String ctrlAtmsFlg) {
		this.ctrlAtmsFlg = ctrlAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtCust
	 */
	public void setCtrtCust(String ctrtCust) {
		this.ctrtCust = ctrtCust;
	}
	
	/**
	 * Column Info
	 * @param actPkupDt
	 */
	public void setActPkupDt(String actPkupDt) {
		this.actPkupDt = actPkupDt;
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
	 * @param awkOvrBkwdLen
	 */
	public void setAwkOvrBkwdLen(String awkOvrBkwdLen) {
		this.awkOvrBkwdLen = awkOvrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param grsWgtKg
	 */
	public void setGrsWgtKg(String grsWgtKg) {
		this.grsWgtKg = grsWgtKg;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
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
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param awkOvrHgt
	 */
	public void setAwkOvrHgt(String awkOvrHgt) {
		this.awkOvrHgt = awkOvrHgt;
	}
	
	/**
	 * Column Info
	 * @param trafModIb
	 */
	public void setTrafModIb(String trafModIb) {
		this.trafModIb = trafModIb;
	}
	
	/**
	 * Column Info
	 * @param vvd4PolCd
	 */
	public void setVvd4PolCd(String vvd4PolCd) {
		this.vvd4PolCd = vvd4PolCd;
	}
	
	/**
	 * Column Info
	 * @param vvd1PodNm
	 */
	public void setVvd1PodNm(String vvd1PodNm) {
		this.vvd1PodNm = vvd1PodNm;
	}
	
	/**
	 * Column Info
	 * @param cntr1
	 */
	public void setCntr1(String cntr1) {
		this.cntr1 = cntr1;
	}
	
	/**
	 * Column Info
	 * @param ttlGrsWgtKg
	 */
	public void setTtlGrsWgtKg(String ttlGrsWgtKg) {
		this.ttlGrsWgtKg = ttlGrsWgtKg;
	}
	
	/**
	 * Column Info
	 * @param fSteCd
	 */
	public void setFSteCd(String fSteCd) {
		this.fSteCd = fSteCd;
	}
	
	/**
	 * Column Info
	 * @param ebrfRefNo
	 */
	public void setEbrfRefNo(String ebrfRefNo) {
		this.ebrfRefNo = ebrfRefNo;
	}
	
	/**
	 * Column Info
	 * @param post1Vvd
	 */
	public void setPost1Vvd(String post1Vvd) {
		this.post1Vvd = post1Vvd;
	}
	
	/**
	 * Column Info
	 * @param esffRefNo
	 */
	public void setEsffRefNo(String esffRefNo) {
		this.esffRefNo = esffRefNo;
	}
	
	/**
	 * Column Info
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
	 * @param ttlGrsWgtLb
	 */
	public void setTtlGrsWgtLb(String ttlGrsWgtLb) {
		this.ttlGrsWgtLb = ttlGrsWgtLb;
	}
	
	/**
	 * Column Info
	 * @param grsWgtLb
	 */
	public void setGrsWgtLb(String grsWgtLb) {
		this.grsWgtLb = grsWgtLb;
	}
	
	/**
	 * Column Info
	 * @param cntrSealCnt
	 */
	public void setCntrSealCnt(String cntrSealCnt) {
		this.cntrSealCnt = cntrSealCnt;
	}
	
	/**
	 * Column Info
	 * @param lclPckQty
	 */
	public void setLclPckQty(String lclPckQty) {
		this.lclPckQty = lclPckQty;
	}
	
	/**
	 * Column Info
	 * @param vvd3PodNm
	 */
	public void setVvd3PodNm(String vvd3PodNm) {
		this.vvd3PodNm = vvd3PodNm;
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
	 * @param spclHndlInst
	 */
	public void setSpclHndlInst(String spclHndlInst) {
		this.spclHndlInst = spclHndlInst;
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
	 * @param slsCd
	 */
	public void setSlsCd(String slsCd) {
		this.slsCd = slsCd;
	}
	
	/**
	 * Column Info
	 * @param ttlFeu
	 */
	public void setTtlFeu(String ttlFeu) {
		this.ttlFeu = ttlFeu;
	}
	
	/**
	 * Column Info
	 * @param rfTemp
	 */
	public void setRfTemp(String rfTemp) {
		this.rfTemp = rfTemp;
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
	 * @param lastPodEtb
	 */
	public void setLastPodEtb(String lastPodEtb) {
		this.lastPodEtb = lastPodEtb;
	}
	
	/**
	 * Column Info
	 * @param rfRmk
	 */
	public void setRfRmk(String rfRmk) {
		this.rfRmk = rfRmk;
	}
	
	/**
	 * Column Info
	 * @param lastPodEta
	 */
	public void setLastPodEta(String lastPodEta) {
		this.lastPodEta = lastPodEta;
	}
	
	/**
	 * Column Info
	 * @param vvd1PolNm
	 */
	public void setVvd1PolNm(String vvd1PolNm) {
		this.vvd1PolNm = vvd1PolNm;
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
	 * @param finvRefNo
	 */
	public void setFinvRefNo(String finvRefNo) {
		this.finvRefNo = finvRefNo;
	}
	
	/**
	 * Column Info
	 * @param cgoCutoffDt
	 */
	public void setCgoCutoffDt(String cgoCutoffDt) {
		this.cgoCutoffDt = cgoCutoffDt;
	}
	
	/**
	 * Column Info
	 * @param trunkVslCd
	 */
	public void setTrunkVslCd(String trunkVslCd) {
		this.trunkVslCd = trunkVslCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param actRtnDt
	 */
	public void setActRtnDt(String actRtnDt) {
		this.actRtnDt = actRtnDt;
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
	 * @param ttlTeu
	 */
	public void setTtlTeu(String ttlTeu) {
		this.ttlTeu = ttlTeu;
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
	 * @param trunkPodCd
	 */
	public void setTrunkPodCd(String trunkPodCd) {
		this.trunkPodCd = trunkPodCd;
	}
	
	/**
	 * Column Info
	 * @param htsCd
	 */
	public void setHtsCd(String htsCd) {
		this.htsCd = htsCd;
	}
	
	/**
	 * Column Info
	 * @param dgCertiFlg
	 */
	public void setDgCertiFlg(String dgCertiFlg) {
		this.dgCertiFlg = dgCertiFlg;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibPkupYdNm
	 */
	public void setIbPkupYdNm(String ibPkupYdNm) {
		this.ibPkupYdNm = ibPkupYdNm;
	}
	
	/**
	 * Column Info
	 * @param lastPodAta
	 */
	public void setLastPodAta(String lastPodAta) {
		this.lastPodAta = lastPodAta;
	}
	
	/**
	 * Column Info
	 * @param obHlgBkg
	 */
	public void setObHlgBkg(String obHlgBkg) {
		this.obHlgBkg = obHlgBkg;
	}
	
	/**
	 * Column Info
	 * @param slsArea
	 */
	public void setSlsArea(String slsArea) {
		this.slsArea = slsArea;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
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
	 * @param cucrRefNo
	 */
	public void setCucrRefNo(String cucrRefNo) {
		this.cucrRefNo = cucrRefNo;
	}
	
	/**
	 * Column Info
	 * @param vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}
	
	/**
	 * Column Info
	 * @param fullRtnLoc
	 */
	public void setFullRtnLoc(String fullRtnLoc) {
		this.fullRtnLoc = fullRtnLoc;
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
	 * @param tVslNm
	 */
	public void setTVslNm(String tVslNm) {
		this.tVslNm = tVslNm;
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
	 * @param lclPckTpCd
	 */
	public void setLclPckTpCd(String lclPckTpCd) {
		this.lclPckTpCd = lclPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param fCntcNm
	 */
	public void setFCntcNm(String fCntcNm) {
		this.fCntcNm = fCntcNm;
	}
	
	/**
	 * Column Info
	 * @param trafModOb
	 */
	public void setTrafModOb(String trafModOb) {
		this.trafModOb = trafModOb;
	}
	
	/**
	 * Column Info
	 * @param sGrpCust
	 */
	public void setSGrpCust(String sGrpCust) {
		this.sGrpCust = sGrpCust;
	}
	
	/**
	 * Column Info
	 * @param awkNetWgt
	 */
	public void setAwkNetWgt(String awkNetWgt) {
		this.awkNetWgt = awkNetWgt;
	}
	
	/**
	 * Column Info
	 * @param rgbkRefNo
	 */
	public void setRgbkRefNo(String rgbkRefNo) {
		this.rgbkRefNo = rgbkRefNo;
	}
	
	/**
	 * Column Info
	 * @param trunkPolCd
	 */
	public void setTrunkPolCd(String trunkPolCd) {
		this.trunkPolCd = trunkPolCd;
	}
	
	/**
	 * Column Info
	 * @param pre1Vvd
	 */
	public void setPre1Vvd(String pre1Vvd) {
		this.pre1Vvd = pre1Vvd;
	}
	
	/**
	 * Column Info
	 * @param bkg1
	 */
	public void setBkg1(String bkg1) {
		this.bkg1 = bkg1;
	}
	
	/**
	 * Column Info
	 * @param totalBkg
	 */
	public void setTotalBkg(String totalBkg) {
		this.totalBkg = totalBkg;
	}
	
	/**
	 * Column Info
	 * @param xptDeclRcv
	 */
	public void setXptDeclRcv(String xptDeclRcv) {
		this.xptDeclRcv = xptDeclRcv;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param fCntcNo
	 */
	public void setFCntcNo(String fCntcNo) {
		this.fCntcNo = fCntcNo;
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
	 * @param cgoWgtLb
	 */
	public void setCgoWgtLb(String cgoWgtLb) {
		this.cgoWgtLb = cgoWgtLb;
	}
	
	/**
	 * Column Info
	 * @param lclMeasUtCd
	 */
	public void setLclMeasUtCd(String lclMeasUtCd) {
		this.lclMeasUtCd = lclMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param ebshRefNo
	 */
	public void setEbshRefNo(String ebshRefNo) {
		this.ebshRefNo = ebshRefNo;
	}
	
	/**
	 * Column Info
	 * @param post4Vvd
	 */
	public void setPost4Vvd(String post4Vvd) {
		this.post4Vvd = post4Vvd;
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
	 * @param vvd2PolCd
	 */
	public void setVvd2PolCd(String vvd2PolCd) {
		this.vvd2PolCd = vvd2PolCd;
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
	 * @param tareLbs
	 */
	public void setTareLbs(String tareLbs) {
		this.tareLbs = tareLbs;
	}
	
	/**
	 * Column Info
	 * @param ttlTareWgtKg
	 */
	public void setTtlTareWgtKg(String ttlTareWgtKg) {
		this.ttlTareWgtKg = ttlTareWgtKg;
	}
	
	/**
	 * Column Info
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
	}
	
	/**
	 * Column Info
	 * @param eqSubstTp
	 */
	public void setEqSubstTp(String eqSubstTp) {
		this.eqSubstTp = eqSubstTp;
	}
	
	/**
	 * Column Info
	 * @param exsMrn
	 */
	public void setExsMrn(String exsMrn) {
		this.exsMrn = exsMrn;
	}
	
	/**
	 * Column Info
	 * @param vvd1PodCd
	 */
	public void setVvd1PodCd(String vvd1PodCd) {
		this.vvd1PodCd = vvd1PodCd;
	}
	
	/**
	 * Column Info
	 * @param vvd3PolNm
	 */
	public void setVvd3PolNm(String vvd3PolNm) {
		this.vvd3PolNm = vvd3PolNm;
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
	 * @param ttlTareWgtLb
	 */
	public void setTtlTareWgtLb(String ttlTareWgtLb) {
		this.ttlTareWgtLb = ttlTareWgtLb;
	}
	
	/**
	 * Column Info
	 * @param ibPkupYdCd
	 */
	public void setIbPkupYdCd(String ibPkupYdCd) {
		this.ibPkupYdCd = ibPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param trunkSlanCd
	 */
	public void setTrunkSlanCd(String trunkSlanCd) {
		this.trunkSlanCd = trunkSlanCd;
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
	 * @param cCust
	 */
	public void setCCust(String cCust) {
		this.cCust = cCust;
	}
	
	/**
	 * Column Info
	 * @param awkOvrLfLen
	 */
	public void setAwkOvrLfLen(String awkOvrLfLen) {
		this.awkOvrLfLen = awkOvrLfLen;
	}
	
	/**
	 * Column Info
	 * @param awkGrsWgt
	 */
	public void setAwkGrsWgt(String awkGrsWgt) {
		this.awkGrsWgt = awkGrsWgt;
	}
	
	/**
	 * Column Info
	 * @param awkTtlDimWdt
	 */
	public void setAwkTtlDimWdt(String awkTtlDimWdt) {
		this.awkTtlDimWdt = awkTtlDimWdt;
	}
	
	/**
	 * Column Info
	 * @param awkOvrRtLen
	 */
	public void setAwkOvrRtLen(String awkOvrRtLen) {
		this.awkOvrRtLen = awkOvrRtLen;
	}
	
	/**
	 * Column Info
	 * @param cmrnRefNo
	 */
	public void setCmrnRefNo(String cmrnRefNo) {
		this.cmrnRefNo = cmrnRefNo;
	}
	
	/**
	 * Column Info
	 * @param lclMeasQty
	 */
	public void setLclMeasQty(String lclMeasQty) {
		this.lclMeasQty = lclMeasQty;
	}
	
	/**
	 * Column Info
	 * @param estPkupDt
	 */
	public void setEstPkupDt(String estPkupDt) {
		this.estPkupDt = estPkupDt;
	}
	
	/**
	 * Column Info
	 * @param esrfRefNo
	 */
	public void setEsrfRefNo(String esrfRefNo) {
		this.esrfRefNo = esrfRefNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param lclCntrMfGdsDesc
	 */
	public void setLclCntrMfGdsDesc(String lclCntrMfGdsDesc) {
		this.lclCntrMfGdsDesc = lclCntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param pre3Vvd
	 */
	public void setPre3Vvd(String pre3Vvd) {
		this.pre3Vvd = pre3Vvd;
	}
	
	/**
	 * Column Info
	 * @param sCntcNo
	 */
	public void setSCntcNo(String sCntcNo) {
		this.sCntcNo = sCntcNo;
	}
	
	/**
	 * Column Info
	 * @param cgoWgtKg
	 */
	public void setCgoWgtKg(String cgoWgtKg) {
		this.cgoWgtKg = cgoWgtKg;
	}
	
	/**
	 * Column Info
	 * @param sCntcNm
	 */
	public void setSCntcNm(String sCntcNm) {
		this.sCntcNm = sCntcNm;
	}
	
	/**
	 * Column Info
	 * @param post3Vvd
	 */
	public void setPost3Vvd(String post3Vvd) {
		this.post3Vvd = post3Vvd;
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
	 * @param modiAtmsFlg
	 */
	public void setModiAtmsFlg(String modiAtmsFlg) {
		this.modiAtmsFlg = modiAtmsFlg;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param totalCntr
	 */
	public void setTotalCntr(String totalCntr) {
		this.totalCntr = totalCntr;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param ibHlgBkg
	 */
	public void setIbHlgBkg(String ibHlgBkg) {
		this.ibHlgBkg = ibHlgBkg;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsDesc
	 */
	public void setCnmvStsDesc(String cnmvStsDesc) {
		this.cnmvStsDesc = cnmvStsDesc;
	}
	
	/**
	 * Column Info
	 * @param esshRefNo
	 */
	public void setEsshRefNo(String esshRefNo) {
		this.esshRefNo = esshRefNo;
	}
	
	/**
	 * Column Info
	 * @param ncmNo
	 */
	public void setNcmNo(String ncmNo) {
		this.ncmNo = ncmNo;
	}
	
	/**
	 * Column Info
	 * @param ctrlPty
	 */
	public void setCtrlPty(String ctrlPty) {
		this.ctrlPty = ctrlPty;
	}
	
	/**
	 * Column Info
	 * @param firstPolCutoffDt
	 */
	public void setFirstPolCutoffDt(String firstPolCutoffDt) {
		this.firstPolCutoffDt = firstPolCutoffDt;
	}
	
	/**
	 * Column Info
	 * @param rateSts
	 */
	public void setRateSts(String rateSts) {
		this.rateSts = rateSts;
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
	 * @param lastPodNm
	 */
	public void setLastPodNm(String lastPodNm) {
		this.lastPodNm = lastPodNm;
	}
	
	/**
	 * Column Info
	 * @param vvd2PodCd
	 */
	public void setVvd2PodCd(String vvd2PodCd) {
		this.vvd2PodCd = vvd2PodCd;
	}
	
	/**
	 * Column Info
	 * @param awkOvrFwrdLen
	 */
	public void setAwkOvrFwrdLen(String awkOvrFwrdLen) {
		this.awkOvrFwrdLen = awkOvrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param awkTtlDimHgt
	 */
	public void setAwkTtlDimHgt(String awkTtlDimHgt) {
		this.awkTtlDimHgt = awkTtlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsGrpCd
	 */
	public void setCmdtHsGrpCd(String cmdtHsGrpCd) {
		this.cmdtHsGrpCd = cmdtHsGrpCd;
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
	 * @param firstPolEtb
	 */
	public void setFirstPolEtb(String firstPolEtb) {
		this.firstPolEtb = firstPolEtb;
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
	 * @param cgoN
	 */
	public void setCgoN(String cgoN) {
		this.cgoN = cgoN;
	}
	
	/**
	 * Column Info
	 * @param vvd4PolNm
	 */
	public void setVvd4PolNm(String vvd4PolNm) {
		this.vvd4PolNm = vvd4PolNm;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param ttlPckQty
	 */
	public void setTtlPckQty(String ttlPckQty) {
		this.ttlPckQty = ttlPckQty;
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
	 * @param wgtBnd
	 */
	public void setWgtBnd(String wgtBnd) {
		this.wgtBnd = wgtBnd;
	}
	
	/**
	 * Column Info
	 * @param pre2Vvd
	 */
	public void setPre2Vvd(String pre2Vvd) {
		this.pre2Vvd = pre2Vvd;
	}
	
	/**
	 * Column Info
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
	}
	
	/**
	 * Column Info
	 * @param vvd2PodNm
	 */
	public void setVvd2PodNm(String vvd2PodNm) {
		this.vvd2PodNm = vvd2PodNm;
	}
	
	/**
	 * Column Info
	 * @param firstPolEtd
	 */
	public void setFirstPolEtd(String firstPolEtd) {
		this.firstPolEtd = firstPolEtd;
	}
	
	/**
	 * Column Info
	 * @param firstPolAtd
	 */
	public void setFirstPolAtd(String firstPolAtd) {
		this.firstPolAtd = firstPolAtd;
	}
	
	/**
	 * Column Info
	 * @param ensMrn
	 */
	public void setEnsMrn(String ensMrn) {
		this.ensMrn = ensMrn;
	}
	
	/**
	 * Column Info
	 * @param obCfsLoc
	 */
	public void setObCfsLoc(String obCfsLoc) {
		this.obCfsLoc = obCfsLoc;
	}
	
	/**
	 * Column Info
	 * @param ttlCgoWgtKg
	 */
	public void setTtlCgoWgtKg(String ttlCgoWgtKg) {
		this.ttlCgoWgtKg = ttlCgoWgtKg;
	}
	
	/**
	 * Column Info
	 * @param dgRmk
	 */
	public void setDgRmk(String dgRmk) {
		this.dgRmk = dgRmk;
	}
	
	/**
	 * Column Info
	 * @param trspModOb
	 */
	public void setTrspModOb(String trspModOb) {
		this.trspModOb = trspModOb;
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
	 * @param vvd3PodCd
	 */
	public void setVvd3PodCd(String vvd3PodCd) {
		this.vvd3PodCd = vvd3PodCd;
	}
	
	/**
	 * Column Info
	 * @param aesItnNo
	 */
	public void setAesItnNo(String aesItnNo) {
		this.aesItnNo = aesItnNo;
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
	 * @param post2Vvd
	 */
	public void setPost2Vvd(String post2Vvd) {
		this.post2Vvd = post2Vvd;
	}
	
	/**
	 * Column Info
	 * @param estRtnDt
	 */
	public void setEstRtnDt(String estRtnDt) {
		this.estRtnDt = estRtnDt;
	}
	
	/**
	 * Column Info
	 * @param pre4Vvd
	 */
	public void setPre4Vvd(String pre4Vvd) {
		this.pre4Vvd = pre4Vvd;
	}
	
	/**
	 * Column Info
	 * @param ibClrLocCd
	 */
	public void setIbClrLocCd(String ibClrLocCd) {
		this.ibClrLocCd = ibClrLocCd;
	}
	
	/**
	 * Column Info
	 * @param awkTtlDimLen
	 */
	public void setAwkTtlDimLen(String awkTtlDimLen) {
		this.awkTtlDimLen = awkTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @param ttlCgoWgtLb
	 */
	public void setTtlCgoWgtLb(String ttlCgoWgtLb) {
		this.ttlCgoWgtLb = ttlCgoWgtLb;
	}
	
	/**
	 * Column Info
	 * @param fCntCd
	 */
	public void setFCntCd(String fCntCd) {
		this.fCntCd = fCntCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param vvd2PolNm
	 */
	public void setVvd2PolNm(String vvd2PolNm) {
		this.vvd2PolNm = vvd2PolNm;
	}
	
	/**
	 * Column Info
	 * @param vvd4PodNm
	 */
	public void setVvd4PodNm(String vvd4PodNm) {
		this.vvd4PodNm = vvd4PodNm;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupLoc
	 */
	public void setMtyPkupLoc(String mtyPkupLoc) {
		this.mtyPkupLoc = mtyPkupLoc;
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
		setEbffRefNo(JSPUtil.getParameter(request, prefix + "ebff_ref_no", ""));
		setVvd4PodCd(JSPUtil.getParameter(request, prefix + "vvd4_pod_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFCust(JSPUtil.getParameter(request, prefix + "f_cust", ""));
		setMtyRtnLoc(JSPUtil.getParameter(request, prefix + "mty_rtn_loc", ""));
		setAwkRmk(JSPUtil.getParameter(request, prefix + "awk_rmk", ""));
		setVndrRmk(JSPUtil.getParameter(request, prefix + "vndr_rmk", ""));
		setVvd1PolCd(JSPUtil.getParameter(request, prefix + "vvd1_pol_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCgoAvalDt(JSPUtil.getParameter(request, prefix + "cgo_aval_dt", ""));
		setTrspModIb(JSPUtil.getParameter(request, prefix + "trsp_mod_ib", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setVvd3PolCd(JSPUtil.getParameter(request, prefix + "vvd3_pol_cd", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setCtrlAtmsFlg(JSPUtil.getParameter(request, prefix + "ctrl_atms_flg", ""));
		setCtrtCust(JSPUtil.getParameter(request, prefix + "ctrt_cust", ""));
		setActPkupDt(JSPUtil.getParameter(request, prefix + "act_pkup_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAwkOvrBkwdLen(JSPUtil.getParameter(request, prefix + "awk_ovr_bkwd_len", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setGrsWgtKg(JSPUtil.getParameter(request, prefix + "grs_wgt_kg", ""));
		setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setAwkOvrHgt(JSPUtil.getParameter(request, prefix + "awk_ovr_hgt", ""));
		setTrafModIb(JSPUtil.getParameter(request, prefix + "traf_mod_ib", ""));
		setVvd4PolCd(JSPUtil.getParameter(request, prefix + "vvd4_pol_cd", ""));
		setVvd1PodNm(JSPUtil.getParameter(request, prefix + "vvd1_pod_nm", ""));
		setCntr1(JSPUtil.getParameter(request, prefix + "cntr_1", ""));
		setTtlGrsWgtKg(JSPUtil.getParameter(request, prefix + "ttl_grs_wgt_kg", ""));
		setFSteCd(JSPUtil.getParameter(request, prefix + "f_ste_cd", ""));
		setEbrfRefNo(JSPUtil.getParameter(request, prefix + "ebrf_ref_no", ""));
		setPost1Vvd(JSPUtil.getParameter(request, prefix + "post1_vvd", ""));
		setEsffRefNo(JSPUtil.getParameter(request, prefix + "esff_ref_no", ""));
		setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTtlGrsWgtLb(JSPUtil.getParameter(request, prefix + "ttl_grs_wgt_lb", ""));
		setGrsWgtLb(JSPUtil.getParameter(request, prefix + "grs_wgt_lb", ""));
		setCntrSealCnt(JSPUtil.getParameter(request, prefix + "cntr_seal_cnt", ""));
		setLclPckQty(JSPUtil.getParameter(request, prefix + "lcl_pck_qty", ""));
		setVvd3PodNm(JSPUtil.getParameter(request, prefix + "vvd3_pod_nm", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setSpclHndlInst(JSPUtil.getParameter(request, prefix + "spcl_hndl_inst", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_srep_cd", ""));
		setSlsCd(JSPUtil.getParameter(request, prefix + "sls_cd", ""));
		setTtlFeu(JSPUtil.getParameter(request, prefix + "ttl_feu", ""));
		setRfTemp(JSPUtil.getParameter(request, prefix + "rf_temp", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setLastPodEtb(JSPUtil.getParameter(request, prefix + "last_pod_etb", ""));
		setRfRmk(JSPUtil.getParameter(request, prefix + "rf_rmk", ""));
		setLastPodEta(JSPUtil.getParameter(request, prefix + "last_pod_eta", ""));
		setVvd1PolNm(JSPUtil.getParameter(request, prefix + "vvd1_pol_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFinvRefNo(JSPUtil.getParameter(request, prefix + "finv_ref_no", ""));
		setCgoCutoffDt(JSPUtil.getParameter(request, prefix + "cgo_cutoff_dt", ""));
		setTrunkVslCd(JSPUtil.getParameter(request, prefix + "trunk_vsl_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setActRtnDt(JSPUtil.getParameter(request, prefix + "act_rtn_dt", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setTtlTeu(JSPUtil.getParameter(request, prefix + "ttl_teu", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setTrunkPodCd(JSPUtil.getParameter(request, prefix + "trunk_pod_cd", ""));
		setHtsCd(JSPUtil.getParameter(request, prefix + "hts_cd", ""));
		setDgCertiFlg(JSPUtil.getParameter(request, prefix + "dg_certi_flg", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setIbPkupYdNm(JSPUtil.getParameter(request, prefix + "ib_pkup_yd_nm", ""));
		setLastPodAta(JSPUtil.getParameter(request, prefix + "last_pod_ata", ""));
		setObHlgBkg(JSPUtil.getParameter(request, prefix + "ob_hlg_bkg", ""));
		setSlsArea(JSPUtil.getParameter(request, prefix + "sls_area", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setCucrRefNo(JSPUtil.getParameter(request, prefix + "cucr_ref_no", ""));
		setVent(JSPUtil.getParameter(request, prefix + "vent", ""));
		setFullRtnLoc(JSPUtil.getParameter(request, prefix + "full_rtn_loc", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setTVslNm(JSPUtil.getParameter(request, prefix + "t_vsl_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setLclPckTpCd(JSPUtil.getParameter(request, prefix + "lcl_pck_tp_cd", ""));
		setFCntcNm(JSPUtil.getParameter(request, prefix + "f_cntc_nm", ""));
		setTrafModOb(JSPUtil.getParameter(request, prefix + "traf_mod_ob", ""));
		setSGrpCust(JSPUtil.getParameter(request, prefix + "s_grp_cust", ""));
		setAwkNetWgt(JSPUtil.getParameter(request, prefix + "awk_net_wgt", ""));
		setRgbkRefNo(JSPUtil.getParameter(request, prefix + "rgbk_ref_no", ""));
		setTrunkPolCd(JSPUtil.getParameter(request, prefix + "trunk_pol_cd", ""));
		setPre1Vvd(JSPUtil.getParameter(request, prefix + "pre1_vvd", ""));
		setBkg1(JSPUtil.getParameter(request, prefix + "bkg_1", ""));
		setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
		setXptDeclRcv(JSPUtil.getParameter(request, prefix + "xpt_decl_rcv", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFCntcNo(JSPUtil.getParameter(request, prefix + "f_cntc_no", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCgoWgtLb(JSPUtil.getParameter(request, prefix + "cgo_wgt_lb", ""));
		setLclMeasUtCd(JSPUtil.getParameter(request, prefix + "lcl_meas_ut_cd", ""));
		setEbshRefNo(JSPUtil.getParameter(request, prefix + "ebsh_ref_no", ""));
		setPost4Vvd(JSPUtil.getParameter(request, prefix + "post4_vvd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setVvd2PolCd(JSPUtil.getParameter(request, prefix + "vvd2_pol_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setTareLbs(JSPUtil.getParameter(request, prefix + "tare_lbs", ""));
		setTtlTareWgtKg(JSPUtil.getParameter(request, prefix + "ttl_tare_wgt_kg", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setEqSubstTp(JSPUtil.getParameter(request, prefix + "eq_subst_tp", ""));
		setExsMrn(JSPUtil.getParameter(request, prefix + "exs_mrn", ""));
		setVvd1PodCd(JSPUtil.getParameter(request, prefix + "vvd1_pod_cd", ""));
		setVvd3PolNm(JSPUtil.getParameter(request, prefix + "vvd3_pol_nm", ""));
		setLastPodCd(JSPUtil.getParameter(request, prefix + "last_pod_cd", ""));
		setTtlTareWgtLb(JSPUtil.getParameter(request, prefix + "ttl_tare_wgt_lb", ""));
		setIbPkupYdCd(JSPUtil.getParameter(request, prefix + "ib_pkup_yd_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
		setTrunkSlanCd(JSPUtil.getParameter(request, prefix + "trunk_slan_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCCust(JSPUtil.getParameter(request, prefix + "c_cust", ""));
		setAwkOvrLfLen(JSPUtil.getParameter(request, prefix + "awk_ovr_lf_len", ""));
		setAwkGrsWgt(JSPUtil.getParameter(request, prefix + "awk_grs_wgt", ""));
		setAwkTtlDimWdt(JSPUtil.getParameter(request, prefix + "awk_ttl_dim_wdt", ""));
		setAwkOvrRtLen(JSPUtil.getParameter(request, prefix + "awk_ovr_rt_len", ""));
		setCmrnRefNo(JSPUtil.getParameter(request, prefix + "cmrn_ref_no", ""));
		setLclMeasQty(JSPUtil.getParameter(request, prefix + "lcl_meas_qty", ""));
		setEstPkupDt(JSPUtil.getParameter(request, prefix + "est_pkup_dt", ""));
		setEsrfRefNo(JSPUtil.getParameter(request, prefix + "esrf_ref_no", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLclCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "lcl_cntr_mf_gds_desc", ""));
		setPre3Vvd(JSPUtil.getParameter(request, prefix + "pre3_vvd", ""));
		setSCntcNo(JSPUtil.getParameter(request, prefix + "s_cntc_no", ""));
		setCgoWgtKg(JSPUtil.getParameter(request, prefix + "cgo_wgt_kg", ""));
		setSCntcNm(JSPUtil.getParameter(request, prefix + "s_cntc_nm", ""));
		setPost3Vvd(JSPUtil.getParameter(request, prefix + "post3_vvd", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setModiAtmsFlg(JSPUtil.getParameter(request, prefix + "modi_atms_flg", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setTotalCntr(JSPUtil.getParameter(request, prefix + "total_cntr", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setIbHlgBkg(JSPUtil.getParameter(request, prefix + "ib_hlg_bkg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setCnmvStsDesc(JSPUtil.getParameter(request, prefix + "cnmv_sts_desc", ""));
		setEsshRefNo(JSPUtil.getParameter(request, prefix + "essh_ref_no", ""));
		setNcmNo(JSPUtil.getParameter(request, prefix + "ncm_no", ""));
		setCtrlPty(JSPUtil.getParameter(request, prefix + "ctrl_pty", ""));
		setFirstPolCutoffDt(JSPUtil.getParameter(request, prefix + "first_pol_cutoff_dt", ""));
		setRateSts(JSPUtil.getParameter(request, prefix + "rate_sts", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLastPodNm(JSPUtil.getParameter(request, prefix + "last_pod_nm", ""));
		setVvd2PodCd(JSPUtil.getParameter(request, prefix + "vvd2_pod_cd", ""));
		setAwkOvrFwrdLen(JSPUtil.getParameter(request, prefix + "awk_ovr_fwrd_len", ""));
		setAwkTtlDimHgt(JSPUtil.getParameter(request, prefix + "awk_ttl_dim_hgt", ""));
		setCmdtHsGrpCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_grp_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setFirstPolEtb(JSPUtil.getParameter(request, prefix + "first_pol_etb", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCgoN(JSPUtil.getParameter(request, prefix + "cgo_n", ""));
		setVvd4PolNm(JSPUtil.getParameter(request, prefix + "vvd4_pol_nm", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setTtlPckQty(JSPUtil.getParameter(request, prefix + "ttl_pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setWgtBnd(JSPUtil.getParameter(request, prefix + "wgt_bnd", ""));
		setPre2Vvd(JSPUtil.getParameter(request, prefix + "pre2_vvd", ""));
		setPorCntCd(JSPUtil.getParameter(request, prefix + "por_cnt_cd", ""));
		setVvd2PodNm(JSPUtil.getParameter(request, prefix + "vvd2_pod_nm", ""));
		setFirstPolEtd(JSPUtil.getParameter(request, prefix + "first_pol_etd", ""));
		setFirstPolAtd(JSPUtil.getParameter(request, prefix + "first_pol_atd", ""));
		setEnsMrn(JSPUtil.getParameter(request, prefix + "ens_mrn", ""));
		setObCfsLoc(JSPUtil.getParameter(request, prefix + "ob_cfs_loc", ""));
		setTtlCgoWgtKg(JSPUtil.getParameter(request, prefix + "ttl_cgo_wgt_kg", ""));
		setDgRmk(JSPUtil.getParameter(request, prefix + "dg_rmk", ""));
		setTrspModOb(JSPUtil.getParameter(request, prefix + "trsp_mod_ob", ""));
		setTwnSoNo(JSPUtil.getParameter(request, prefix + "twn_so_no", ""));
		setVvd3PodCd(JSPUtil.getParameter(request, prefix + "vvd3_pod_cd", ""));
		setAesItnNo(JSPUtil.getParameter(request, prefix + "aes_itn_no", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setPost2Vvd(JSPUtil.getParameter(request, prefix + "post2_vvd", ""));
		setEstRtnDt(JSPUtil.getParameter(request, prefix + "est_rtn_dt", ""));
		setPre4Vvd(JSPUtil.getParameter(request, prefix + "pre4_vvd", ""));
		setIbClrLocCd(JSPUtil.getParameter(request, prefix + "ib_clr_loc_cd", ""));
		setAwkTtlDimLen(JSPUtil.getParameter(request, prefix + "awk_ttl_dim_len", ""));
		setTtlCgoWgtLb(JSPUtil.getParameter(request, prefix + "ttl_cgo_wgt_lb", ""));
		setFCntCd(JSPUtil.getParameter(request, prefix + "f_cnt_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setVvd2PolNm(JSPUtil.getParameter(request, prefix + "vvd2_pol_nm", ""));
		setVvd4PodNm(JSPUtil.getParameter(request, prefix + "vvd4_pod_nm", ""));
		setMtyPkupLoc(JSPUtil.getParameter(request, prefix + "mty_pkup_loc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BokCntrListOutVO[]
	 */
	public BokCntrListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BokCntrListOutVO[]
	 */
	public BokCntrListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BokCntrListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ebffRefNo = (JSPUtil.getParameter(request, prefix	+ "ebff_ref_no", length));
			String[] vvd4PodCd = (JSPUtil.getParameter(request, prefix	+ "vvd4_pod_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] fCust = (JSPUtil.getParameter(request, prefix	+ "f_cust", length));
			String[] mtyRtnLoc = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_loc", length));
			String[] awkRmk = (JSPUtil.getParameter(request, prefix	+ "awk_rmk", length));
			String[] vndrRmk = (JSPUtil.getParameter(request, prefix	+ "vndr_rmk", length));
			String[] vvd1PolCd = (JSPUtil.getParameter(request, prefix	+ "vvd1_pol_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cgoAvalDt = (JSPUtil.getParameter(request, prefix	+ "cgo_aval_dt", length));
			String[] trspModIb = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_ib", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] vvd3PolCd = (JSPUtil.getParameter(request, prefix	+ "vvd3_pol_cd", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] ctrlAtmsFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_atms_flg", length));
			String[] ctrtCust = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust", length));
			String[] actPkupDt = (JSPUtil.getParameter(request, prefix	+ "act_pkup_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] awkOvrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "awk_ovr_bkwd_len", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] grsWgtKg = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_kg", length));
			String[] siFlg = (JSPUtil.getParameter(request, prefix	+ "si_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] awkOvrHgt = (JSPUtil.getParameter(request, prefix	+ "awk_ovr_hgt", length));
			String[] trafModIb = (JSPUtil.getParameter(request, prefix	+ "traf_mod_ib", length));
			String[] vvd4PolCd = (JSPUtil.getParameter(request, prefix	+ "vvd4_pol_cd", length));
			String[] vvd1PodNm = (JSPUtil.getParameter(request, prefix	+ "vvd1_pod_nm", length));
			String[] cntr1 = (JSPUtil.getParameter(request, prefix	+ "cntr_1", length));
			String[] ttlGrsWgtKg = (JSPUtil.getParameter(request, prefix	+ "ttl_grs_wgt_kg", length));
			String[] fSteCd = (JSPUtil.getParameter(request, prefix	+ "f_ste_cd", length));
			String[] ebrfRefNo = (JSPUtil.getParameter(request, prefix	+ "ebrf_ref_no", length));
			String[] post1Vvd = (JSPUtil.getParameter(request, prefix	+ "post1_vvd", length));
			String[] esffRefNo = (JSPUtil.getParameter(request, prefix	+ "esff_ref_no", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ttlGrsWgtLb = (JSPUtil.getParameter(request, prefix	+ "ttl_grs_wgt_lb", length));
			String[] grsWgtLb = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_lb", length));
			String[] cntrSealCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_cnt", length));
			String[] lclPckQty = (JSPUtil.getParameter(request, prefix	+ "lcl_pck_qty", length));
			String[] vvd3PodNm = (JSPUtil.getParameter(request, prefix	+ "vvd3_pod_nm", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] spclHndlInst = (JSPUtil.getParameter(request, prefix	+ "spcl_hndl_inst", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			String[] slsCd = (JSPUtil.getParameter(request, prefix	+ "sls_cd", length));
			String[] ttlFeu = (JSPUtil.getParameter(request, prefix	+ "ttl_feu", length));
			String[] rfTemp = (JSPUtil.getParameter(request, prefix	+ "rf_temp", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] lastPodEtb = (JSPUtil.getParameter(request, prefix	+ "last_pod_etb", length));
			String[] rfRmk = (JSPUtil.getParameter(request, prefix	+ "rf_rmk", length));
			String[] lastPodEta = (JSPUtil.getParameter(request, prefix	+ "last_pod_eta", length));
			String[] vvd1PolNm = (JSPUtil.getParameter(request, prefix	+ "vvd1_pol_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] finvRefNo = (JSPUtil.getParameter(request, prefix	+ "finv_ref_no", length));
			String[] cgoCutoffDt = (JSPUtil.getParameter(request, prefix	+ "cgo_cutoff_dt", length));
			String[] trunkVslCd = (JSPUtil.getParameter(request, prefix	+ "trunk_vsl_cd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] actRtnDt = (JSPUtil.getParameter(request, prefix	+ "act_rtn_dt", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] ttlTeu = (JSPUtil.getParameter(request, prefix	+ "ttl_teu", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] trunkPodCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pod_cd", length));
			String[] htsCd = (JSPUtil.getParameter(request, prefix	+ "hts_cd", length));
			String[] dgCertiFlg = (JSPUtil.getParameter(request, prefix	+ "dg_certi_flg", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ibPkupYdNm = (JSPUtil.getParameter(request, prefix	+ "ib_pkup_yd_nm", length));
			String[] lastPodAta = (JSPUtil.getParameter(request, prefix	+ "last_pod_ata", length));
			String[] obHlgBkg = (JSPUtil.getParameter(request, prefix	+ "ob_hlg_bkg", length));
			String[] slsArea = (JSPUtil.getParameter(request, prefix	+ "sls_area", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] cucrRefNo = (JSPUtil.getParameter(request, prefix	+ "cucr_ref_no", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] fullRtnLoc = (JSPUtil.getParameter(request, prefix	+ "full_rtn_loc", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] tVslNm = (JSPUtil.getParameter(request, prefix	+ "t_vsl_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] lclPckTpCd = (JSPUtil.getParameter(request, prefix	+ "lcl_pck_tp_cd", length));
			String[] fCntcNm = (JSPUtil.getParameter(request, prefix	+ "f_cntc_nm", length));
			String[] trafModOb = (JSPUtil.getParameter(request, prefix	+ "traf_mod_ob", length));
			String[] sGrpCust = (JSPUtil.getParameter(request, prefix	+ "s_grp_cust", length));
			String[] awkNetWgt = (JSPUtil.getParameter(request, prefix	+ "awk_net_wgt", length));
			String[] rgbkRefNo = (JSPUtil.getParameter(request, prefix	+ "rgbk_ref_no", length));
			String[] trunkPolCd = (JSPUtil.getParameter(request, prefix	+ "trunk_pol_cd", length));
			String[] pre1Vvd = (JSPUtil.getParameter(request, prefix	+ "pre1_vvd", length));
			String[] bkg1 = (JSPUtil.getParameter(request, prefix	+ "bkg_1", length));
			String[] totalBkg = (JSPUtil.getParameter(request, prefix	+ "total_bkg", length));
			String[] xptDeclRcv = (JSPUtil.getParameter(request, prefix	+ "xpt_decl_rcv", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fCntcNo = (JSPUtil.getParameter(request, prefix	+ "f_cntc_no", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cgoWgtLb = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_lb", length));
			String[] lclMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "lcl_meas_ut_cd", length));
			String[] ebshRefNo = (JSPUtil.getParameter(request, prefix	+ "ebsh_ref_no", length));
			String[] post4Vvd = (JSPUtil.getParameter(request, prefix	+ "post4_vvd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] vvd2PolCd = (JSPUtil.getParameter(request, prefix	+ "vvd2_pol_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] tareLbs = (JSPUtil.getParameter(request, prefix	+ "tare_lbs", length));
			String[] ttlTareWgtKg = (JSPUtil.getParameter(request, prefix	+ "ttl_tare_wgt_kg", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] eqSubstTp = (JSPUtil.getParameter(request, prefix	+ "eq_subst_tp", length));
			String[] exsMrn = (JSPUtil.getParameter(request, prefix	+ "exs_mrn", length));
			String[] vvd1PodCd = (JSPUtil.getParameter(request, prefix	+ "vvd1_pod_cd", length));
			String[] vvd3PolNm = (JSPUtil.getParameter(request, prefix	+ "vvd3_pol_nm", length));
			String[] lastPodCd = (JSPUtil.getParameter(request, prefix	+ "last_pod_cd", length));
			String[] ttlTareWgtLb = (JSPUtil.getParameter(request, prefix	+ "ttl_tare_wgt_lb", length));
			String[] ibPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "ib_pkup_yd_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] trunkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trunk_slan_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cCust = (JSPUtil.getParameter(request, prefix	+ "c_cust", length));
			String[] awkOvrLfLen = (JSPUtil.getParameter(request, prefix	+ "awk_ovr_lf_len", length));
			String[] awkGrsWgt = (JSPUtil.getParameter(request, prefix	+ "awk_grs_wgt", length));
			String[] awkTtlDimWdt = (JSPUtil.getParameter(request, prefix	+ "awk_ttl_dim_wdt", length));
			String[] awkOvrRtLen = (JSPUtil.getParameter(request, prefix	+ "awk_ovr_rt_len", length));
			String[] cmrnRefNo = (JSPUtil.getParameter(request, prefix	+ "cmrn_ref_no", length));
			String[] lclMeasQty = (JSPUtil.getParameter(request, prefix	+ "lcl_meas_qty", length));
			String[] estPkupDt = (JSPUtil.getParameter(request, prefix	+ "est_pkup_dt", length));
			String[] esrfRefNo = (JSPUtil.getParameter(request, prefix	+ "esrf_ref_no", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] lclCntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "lcl_cntr_mf_gds_desc", length));
			String[] pre3Vvd = (JSPUtil.getParameter(request, prefix	+ "pre3_vvd", length));
			String[] sCntcNo = (JSPUtil.getParameter(request, prefix	+ "s_cntc_no", length));
			String[] cgoWgtKg = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt_kg", length));
			String[] sCntcNm = (JSPUtil.getParameter(request, prefix	+ "s_cntc_nm", length));
			String[] post3Vvd = (JSPUtil.getParameter(request, prefix	+ "post3_vvd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] modiAtmsFlg = (JSPUtil.getParameter(request, prefix	+ "modi_atms_flg", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] totalCntr = (JSPUtil.getParameter(request, prefix	+ "total_cntr", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] ibHlgBkg = (JSPUtil.getParameter(request, prefix	+ "ib_hlg_bkg", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] cnmvStsDesc = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_desc", length));
			String[] esshRefNo = (JSPUtil.getParameter(request, prefix	+ "essh_ref_no", length));
			String[] ncmNo = (JSPUtil.getParameter(request, prefix	+ "ncm_no", length));
			String[] ctrlPty = (JSPUtil.getParameter(request, prefix	+ "ctrl_pty", length));
			String[] firstPolCutoffDt = (JSPUtil.getParameter(request, prefix	+ "first_pol_cutoff_dt", length));
			String[] rateSts = (JSPUtil.getParameter(request, prefix	+ "rate_sts", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] lastPodNm = (JSPUtil.getParameter(request, prefix	+ "last_pod_nm", length));
			String[] vvd2PodCd = (JSPUtil.getParameter(request, prefix	+ "vvd2_pod_cd", length));
			String[] awkOvrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "awk_ovr_fwrd_len", length));
			String[] awkTtlDimHgt = (JSPUtil.getParameter(request, prefix	+ "awk_ttl_dim_hgt", length));
			String[] cmdtHsGrpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_grp_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] firstPolEtb = (JSPUtil.getParameter(request, prefix	+ "first_pol_etb", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoN = (JSPUtil.getParameter(request, prefix	+ "cgo_n", length));
			String[] vvd4PolNm = (JSPUtil.getParameter(request, prefix	+ "vvd4_pol_nm", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] wgtBnd = (JSPUtil.getParameter(request, prefix	+ "wgt_bnd", length));
			String[] pre2Vvd = (JSPUtil.getParameter(request, prefix	+ "pre2_vvd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] vvd2PodNm = (JSPUtil.getParameter(request, prefix	+ "vvd2_pod_nm", length));
			String[] firstPolEtd = (JSPUtil.getParameter(request, prefix	+ "first_pol_etd", length));
			String[] firstPolAtd = (JSPUtil.getParameter(request, prefix	+ "first_pol_atd", length));
			String[] ensMrn = (JSPUtil.getParameter(request, prefix	+ "ens_mrn", length));
			String[] obCfsLoc = (JSPUtil.getParameter(request, prefix	+ "ob_cfs_loc", length));
			String[] ttlCgoWgtKg = (JSPUtil.getParameter(request, prefix	+ "ttl_cgo_wgt_kg", length));
			String[] dgRmk = (JSPUtil.getParameter(request, prefix	+ "dg_rmk", length));
			String[] trspModOb = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_ob", length));
			String[] twnSoNo = (JSPUtil.getParameter(request, prefix	+ "twn_so_no", length));
			String[] vvd3PodCd = (JSPUtil.getParameter(request, prefix	+ "vvd3_pod_cd", length));
			String[] aesItnNo = (JSPUtil.getParameter(request, prefix	+ "aes_itn_no", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] post2Vvd = (JSPUtil.getParameter(request, prefix	+ "post2_vvd", length));
			String[] estRtnDt = (JSPUtil.getParameter(request, prefix	+ "est_rtn_dt", length));
			String[] pre4Vvd = (JSPUtil.getParameter(request, prefix	+ "pre4_vvd", length));
			String[] ibClrLocCd = (JSPUtil.getParameter(request, prefix	+ "ib_clr_loc_cd", length));
			String[] awkTtlDimLen = (JSPUtil.getParameter(request, prefix	+ "awk_ttl_dim_len", length));
			String[] ttlCgoWgtLb = (JSPUtil.getParameter(request, prefix	+ "ttl_cgo_wgt_lb", length));
			String[] fCntCd = (JSPUtil.getParameter(request, prefix	+ "f_cnt_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] vvd2PolNm = (JSPUtil.getParameter(request, prefix	+ "vvd2_pol_nm", length));
			String[] vvd4PodNm = (JSPUtil.getParameter(request, prefix	+ "vvd4_pod_nm", length));
			String[] mtyPkupLoc = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_loc", length));
			
			for (int i = 0; i < length; i++) {
				model = new BokCntrListOutVO();
				if (ebffRefNo[i] != null)
					model.setEbffRefNo(ebffRefNo[i]);
				if (vvd4PodCd[i] != null)
					model.setVvd4PodCd(vvd4PodCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (fCust[i] != null)
					model.setFCust(fCust[i]);
				if (mtyRtnLoc[i] != null)
					model.setMtyRtnLoc(mtyRtnLoc[i]);
				if (awkRmk[i] != null)
					model.setAwkRmk(awkRmk[i]);
				if (vndrRmk[i] != null)
					model.setVndrRmk(vndrRmk[i]);
				if (vvd1PolCd[i] != null)
					model.setVvd1PolCd(vvd1PolCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cgoAvalDt[i] != null)
					model.setCgoAvalDt(cgoAvalDt[i]);
				if (trspModIb[i] != null)
					model.setTrspModIb(trspModIb[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (vvd3PolCd[i] != null)
					model.setVvd3PolCd(vvd3PolCd[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (ctrlAtmsFlg[i] != null)
					model.setCtrlAtmsFlg(ctrlAtmsFlg[i]);
				if (ctrtCust[i] != null)
					model.setCtrtCust(ctrtCust[i]);
				if (actPkupDt[i] != null)
					model.setActPkupDt(actPkupDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (awkOvrBkwdLen[i] != null)
					model.setAwkOvrBkwdLen(awkOvrBkwdLen[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (grsWgtKg[i] != null)
					model.setGrsWgtKg(grsWgtKg[i]);
				if (siFlg[i] != null)
					model.setSiFlg(siFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (awkOvrHgt[i] != null)
					model.setAwkOvrHgt(awkOvrHgt[i]);
				if (trafModIb[i] != null)
					model.setTrafModIb(trafModIb[i]);
				if (vvd4PolCd[i] != null)
					model.setVvd4PolCd(vvd4PolCd[i]);
				if (vvd1PodNm[i] != null)
					model.setVvd1PodNm(vvd1PodNm[i]);
				if (cntr1[i] != null)
					model.setCntr1(cntr1[i]);
				if (ttlGrsWgtKg[i] != null)
					model.setTtlGrsWgtKg(ttlGrsWgtKg[i]);
				if (fSteCd[i] != null)
					model.setFSteCd(fSteCd[i]);
				if (ebrfRefNo[i] != null)
					model.setEbrfRefNo(ebrfRefNo[i]);
				if (post1Vvd[i] != null)
					model.setPost1Vvd(post1Vvd[i]);
				if (esffRefNo[i] != null)
					model.setEsffRefNo(esffRefNo[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ttlGrsWgtLb[i] != null)
					model.setTtlGrsWgtLb(ttlGrsWgtLb[i]);
				if (grsWgtLb[i] != null)
					model.setGrsWgtLb(grsWgtLb[i]);
				if (cntrSealCnt[i] != null)
					model.setCntrSealCnt(cntrSealCnt[i]);
				if (lclPckQty[i] != null)
					model.setLclPckQty(lclPckQty[i]);
				if (vvd3PodNm[i] != null)
					model.setVvd3PodNm(vvd3PodNm[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (spclHndlInst[i] != null)
					model.setSpclHndlInst(spclHndlInst[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (slsCd[i] != null)
					model.setSlsCd(slsCd[i]);
				if (ttlFeu[i] != null)
					model.setTtlFeu(ttlFeu[i]);
				if (rfTemp[i] != null)
					model.setRfTemp(rfTemp[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (lastPodEtb[i] != null)
					model.setLastPodEtb(lastPodEtb[i]);
				if (rfRmk[i] != null)
					model.setRfRmk(rfRmk[i]);
				if (lastPodEta[i] != null)
					model.setLastPodEta(lastPodEta[i]);
				if (vvd1PolNm[i] != null)
					model.setVvd1PolNm(vvd1PolNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (finvRefNo[i] != null)
					model.setFinvRefNo(finvRefNo[i]);
				if (cgoCutoffDt[i] != null)
					model.setCgoCutoffDt(cgoCutoffDt[i]);
				if (trunkVslCd[i] != null)
					model.setTrunkVslCd(trunkVslCd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (actRtnDt[i] != null)
					model.setActRtnDt(actRtnDt[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (ttlTeu[i] != null)
					model.setTtlTeu(ttlTeu[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (trunkPodCd[i] != null)
					model.setTrunkPodCd(trunkPodCd[i]);
				if (htsCd[i] != null)
					model.setHtsCd(htsCd[i]);
				if (dgCertiFlg[i] != null)
					model.setDgCertiFlg(dgCertiFlg[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ibPkupYdNm[i] != null)
					model.setIbPkupYdNm(ibPkupYdNm[i]);
				if (lastPodAta[i] != null)
					model.setLastPodAta(lastPodAta[i]);
				if (obHlgBkg[i] != null)
					model.setObHlgBkg(obHlgBkg[i]);
				if (slsArea[i] != null)
					model.setSlsArea(slsArea[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (cucrRefNo[i] != null)
					model.setCucrRefNo(cucrRefNo[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (fullRtnLoc[i] != null)
					model.setFullRtnLoc(fullRtnLoc[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (tVslNm[i] != null)
					model.setTVslNm(tVslNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (lclPckTpCd[i] != null)
					model.setLclPckTpCd(lclPckTpCd[i]);
				if (fCntcNm[i] != null)
					model.setFCntcNm(fCntcNm[i]);
				if (trafModOb[i] != null)
					model.setTrafModOb(trafModOb[i]);
				if (sGrpCust[i] != null)
					model.setSGrpCust(sGrpCust[i]);
				if (awkNetWgt[i] != null)
					model.setAwkNetWgt(awkNetWgt[i]);
				if (rgbkRefNo[i] != null)
					model.setRgbkRefNo(rgbkRefNo[i]);
				if (trunkPolCd[i] != null)
					model.setTrunkPolCd(trunkPolCd[i]);
				if (pre1Vvd[i] != null)
					model.setPre1Vvd(pre1Vvd[i]);
				if (bkg1[i] != null)
					model.setBkg1(bkg1[i]);
				if (totalBkg[i] != null)
					model.setTotalBkg(totalBkg[i]);
				if (xptDeclRcv[i] != null)
					model.setXptDeclRcv(xptDeclRcv[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fCntcNo[i] != null)
					model.setFCntcNo(fCntcNo[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cgoWgtLb[i] != null)
					model.setCgoWgtLb(cgoWgtLb[i]);
				if (lclMeasUtCd[i] != null)
					model.setLclMeasUtCd(lclMeasUtCd[i]);
				if (ebshRefNo[i] != null)
					model.setEbshRefNo(ebshRefNo[i]);
				if (post4Vvd[i] != null)
					model.setPost4Vvd(post4Vvd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (vvd2PolCd[i] != null)
					model.setVvd2PolCd(vvd2PolCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (tareLbs[i] != null)
					model.setTareLbs(tareLbs[i]);
				if (ttlTareWgtKg[i] != null)
					model.setTtlTareWgtKg(ttlTareWgtKg[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (eqSubstTp[i] != null)
					model.setEqSubstTp(eqSubstTp[i]);
				if (exsMrn[i] != null)
					model.setExsMrn(exsMrn[i]);
				if (vvd1PodCd[i] != null)
					model.setVvd1PodCd(vvd1PodCd[i]);
				if (vvd3PolNm[i] != null)
					model.setVvd3PolNm(vvd3PolNm[i]);
				if (lastPodCd[i] != null)
					model.setLastPodCd(lastPodCd[i]);
				if (ttlTareWgtLb[i] != null)
					model.setTtlTareWgtLb(ttlTareWgtLb[i]);
				if (ibPkupYdCd[i] != null)
					model.setIbPkupYdCd(ibPkupYdCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (trunkSlanCd[i] != null)
					model.setTrunkSlanCd(trunkSlanCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cCust[i] != null)
					model.setCCust(cCust[i]);
				if (awkOvrLfLen[i] != null)
					model.setAwkOvrLfLen(awkOvrLfLen[i]);
				if (awkGrsWgt[i] != null)
					model.setAwkGrsWgt(awkGrsWgt[i]);
				if (awkTtlDimWdt[i] != null)
					model.setAwkTtlDimWdt(awkTtlDimWdt[i]);
				if (awkOvrRtLen[i] != null)
					model.setAwkOvrRtLen(awkOvrRtLen[i]);
				if (cmrnRefNo[i] != null)
					model.setCmrnRefNo(cmrnRefNo[i]);
				if (lclMeasQty[i] != null)
					model.setLclMeasQty(lclMeasQty[i]);
				if (estPkupDt[i] != null)
					model.setEstPkupDt(estPkupDt[i]);
				if (esrfRefNo[i] != null)
					model.setEsrfRefNo(esrfRefNo[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lclCntrMfGdsDesc[i] != null)
					model.setLclCntrMfGdsDesc(lclCntrMfGdsDesc[i]);
				if (pre3Vvd[i] != null)
					model.setPre3Vvd(pre3Vvd[i]);
				if (sCntcNo[i] != null)
					model.setSCntcNo(sCntcNo[i]);
				if (cgoWgtKg[i] != null)
					model.setCgoWgtKg(cgoWgtKg[i]);
				if (sCntcNm[i] != null)
					model.setSCntcNm(sCntcNm[i]);
				if (post3Vvd[i] != null)
					model.setPost3Vvd(post3Vvd[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (modiAtmsFlg[i] != null)
					model.setModiAtmsFlg(modiAtmsFlg[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (totalCntr[i] != null)
					model.setTotalCntr(totalCntr[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (ibHlgBkg[i] != null)
					model.setIbHlgBkg(ibHlgBkg[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (cnmvStsDesc[i] != null)
					model.setCnmvStsDesc(cnmvStsDesc[i]);
				if (esshRefNo[i] != null)
					model.setEsshRefNo(esshRefNo[i]);
				if (ncmNo[i] != null)
					model.setNcmNo(ncmNo[i]);
				if (ctrlPty[i] != null)
					model.setCtrlPty(ctrlPty[i]);
				if (firstPolCutoffDt[i] != null)
					model.setFirstPolCutoffDt(firstPolCutoffDt[i]);
				if (rateSts[i] != null)
					model.setRateSts(rateSts[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (lastPodNm[i] != null)
					model.setLastPodNm(lastPodNm[i]);
				if (vvd2PodCd[i] != null)
					model.setVvd2PodCd(vvd2PodCd[i]);
				if (awkOvrFwrdLen[i] != null)
					model.setAwkOvrFwrdLen(awkOvrFwrdLen[i]);
				if (awkTtlDimHgt[i] != null)
					model.setAwkTtlDimHgt(awkTtlDimHgt[i]);
				if (cmdtHsGrpCd[i] != null)
					model.setCmdtHsGrpCd(cmdtHsGrpCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (firstPolEtb[i] != null)
					model.setFirstPolEtb(firstPolEtb[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoN[i] != null)
					model.setCgoN(cgoN[i]);
				if (vvd4PolNm[i] != null)
					model.setVvd4PolNm(vvd4PolNm[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (wgtBnd[i] != null)
					model.setWgtBnd(wgtBnd[i]);
				if (pre2Vvd[i] != null)
					model.setPre2Vvd(pre2Vvd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (vvd2PodNm[i] != null)
					model.setVvd2PodNm(vvd2PodNm[i]);
				if (firstPolEtd[i] != null)
					model.setFirstPolEtd(firstPolEtd[i]);
				if (firstPolAtd[i] != null)
					model.setFirstPolAtd(firstPolAtd[i]);
				if (ensMrn[i] != null)
					model.setEnsMrn(ensMrn[i]);
				if (obCfsLoc[i] != null)
					model.setObCfsLoc(obCfsLoc[i]);
				if (ttlCgoWgtKg[i] != null)
					model.setTtlCgoWgtKg(ttlCgoWgtKg[i]);
				if (dgRmk[i] != null)
					model.setDgRmk(dgRmk[i]);
				if (trspModOb[i] != null)
					model.setTrspModOb(trspModOb[i]);
				if (twnSoNo[i] != null)
					model.setTwnSoNo(twnSoNo[i]);
				if (vvd3PodCd[i] != null)
					model.setVvd3PodCd(vvd3PodCd[i]);
				if (aesItnNo[i] != null)
					model.setAesItnNo(aesItnNo[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (post2Vvd[i] != null)
					model.setPost2Vvd(post2Vvd[i]);
				if (estRtnDt[i] != null)
					model.setEstRtnDt(estRtnDt[i]);
				if (pre4Vvd[i] != null)
					model.setPre4Vvd(pre4Vvd[i]);
				if (ibClrLocCd[i] != null)
					model.setIbClrLocCd(ibClrLocCd[i]);
				if (awkTtlDimLen[i] != null)
					model.setAwkTtlDimLen(awkTtlDimLen[i]);
				if (ttlCgoWgtLb[i] != null)
					model.setTtlCgoWgtLb(ttlCgoWgtLb[i]);
				if (fCntCd[i] != null)
					model.setFCntCd(fCntCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (vvd2PolNm[i] != null)
					model.setVvd2PolNm(vvd2PolNm[i]);
				if (vvd4PodNm[i] != null)
					model.setVvd4PodNm(vvd4PodNm[i]);
				if (mtyPkupLoc[i] != null)
					model.setMtyPkupLoc(mtyPkupLoc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBokCntrListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BokCntrListOutVO[]
	 */
	public BokCntrListOutVO[] getBokCntrListOutVOs(){
		BokCntrListOutVO[] vos = (BokCntrListOutVO[])models.toArray(new BokCntrListOutVO[models.size()]);
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
		this.ebffRefNo = this.ebffRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4PodCd = this.vvd4PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCust = this.fCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnLoc = this.mtyRtnLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkRmk = this.awkRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrRmk = this.vndrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1PolCd = this.vvd1PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoAvalDt = this.cgoAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModIb = this.trspModIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3PolCd = this.vvd3PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAtmsFlg = this.ctrlAtmsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCust = this.ctrtCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPkupDt = this.actPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkOvrBkwdLen = this.awkOvrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtKg = this.grsWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siFlg = this.siFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkOvrHgt = this.awkOvrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trafModIb = this.trafModIb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4PolCd = this.vvd4PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1PodNm = this.vvd1PodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1 = this.cntr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlGrsWgtKg = this.ttlGrsWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSteCd = this.fSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebrfRefNo = this.ebrfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post1Vvd = this.post1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esffRefNo = this.esffRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlGrsWgtLb = this.ttlGrsWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtLb = this.grsWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealCnt = this.cntrSealCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclPckQty = this.lclPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3PodNm = this.vvd3PodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHndlInst = this.spclHndlInst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsCd = this.slsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlFeu = this.ttlFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTemp = this.rfTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodEtb = this.lastPodEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRmk = this.rfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodEta = this.lastPodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1PolNm = this.vvd1PolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finvRefNo = this.finvRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCutoffDt = this.cgoCutoffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVslCd = this.trunkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRtnDt = this.actRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTeu = this.ttlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPodCd = this.trunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htsCd = this.htsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCertiFlg = this.dgCertiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPkupYdNm = this.ibPkupYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodAta = this.lastPodAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obHlgBkg = this.obHlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsArea = this.slsArea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cucrRefNo = this.cucrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnLoc = this.fullRtnLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVslNm = this.tVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclPckTpCd = this.lclPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntcNm = this.fCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trafModOb = this.trafModOb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGrpCust = this.sGrpCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkNetWgt = this.awkNetWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgbkRefNo = this.rgbkRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkPolCd = this.trunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre1Vvd = this.pre1Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg1 = this.bkg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBkg = this.totalBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptDeclRcv = this.xptDeclRcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntcNo = this.fCntcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtLb = this.cgoWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclMeasUtCd = this.lclMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebshRefNo = this.ebshRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post4Vvd = this.post4Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2PolCd = this.vvd2PolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareLbs = this.tareLbs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTareWgtKg = this.ttlTareWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstTp = this.eqSubstTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsMrn = this.exsMrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1PodCd = this.vvd1PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3PolNm = this.vvd3PolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodCd = this.lastPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTareWgtLb = this.ttlTareWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPkupYdCd = this.ibPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkSlanCd = this.trunkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCust = this.cCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkOvrLfLen = this.awkOvrLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkGrsWgt = this.awkGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkTtlDimWdt = this.awkTtlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkOvrRtLen = this.awkOvrRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmrnRefNo = this.cmrnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclMeasQty = this.lclMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estPkupDt = this.estPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esrfRefNo = this.esrfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCntrMfGdsDesc = this.lclCntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre3Vvd = this.pre3Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntcNo = this.sCntcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgtKg = this.cgoWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntcNm = this.sCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post3Vvd = this.post3Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiAtmsFlg = this.modiAtmsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCntr = this.totalCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibHlgBkg = this.ibHlgBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsDesc = this.cnmvStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esshRefNo = this.esshRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmNo = this.ncmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlPty = this.ctrlPty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolCutoffDt = this.firstPolCutoffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateSts = this.rateSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPodNm = this.lastPodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2PodCd = this.vvd2PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkOvrFwrdLen = this.awkOvrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkTtlDimHgt = this.awkTtlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsGrpCd = this.cmdtHsGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolEtb = this.firstPolEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoN = this.cgoN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4PolNm = this.vvd4PolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtBnd = this.wgtBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre2Vvd = this.pre2Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2PodNm = this.vvd2PodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolEtd = this.firstPolEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstPolAtd = this.firstPolAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensMrn = this.ensMrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCfsLoc = this.obCfsLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCgoWgtKg = this.ttlCgoWgtKg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRmk = this.dgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModOb = this.trspModOb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twnSoNo = this.twnSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3PodCd = this.vvd3PodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesItnNo = this.aesItnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post2Vvd = this.post2Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estRtnDt = this.estRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre4Vvd = this.pre4Vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibClrLocCd = this.ibClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkTtlDimLen = this.awkTtlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCgoWgtLb = this.ttlCgoWgtLb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntCd = this.fCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2PolNm = this.vvd2PolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4PodNm = this.vvd4PodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupLoc = this.mtyPkupLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
