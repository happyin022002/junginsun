/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchRfaOftAutoratingListVO.java
*@FileTitle : SearchRfaOftAutoratingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRfaOftAutoratingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRfaOftAutoratingListVO> models = new ArrayList<SearchRfaOftAutoratingListVO>();
	
	/* Column Info */
	private String rtRcvTermCd = null;
	/* Column Info */
	private String daCalcFrtRtAmt = null;
	/* Column Info */
	private String oaRacConvCtnt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String oaPrcTrspModCd = null;
	/* Column Info */
	private String diPrcTrspModCd = null;
	/* Column Info */
	private String daAddChgSeq = null;
	/* Column Info */
	private String oiFnlFdrRtAmt = null;
	/* Column Info */
	private String diFdrRcvDeTermCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oaRcvDeTermCd = null;
	/* Column Info */
	private String diFnlIhcRtAmt = null;
	/* Column Info */
	private String rtRasConvCtnt = null;
	/* Column Info */
	private String oaPrcCgoTpCd = null;
	/* Column Info */
	private String oiFnlIhcRtAmt = null;
	/* Column Info */
	private String daRacConvCtnt = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String ovRoutViaPortDefCd = null;
	/* Column Info */
	private String oiRoutPntLocDefCd = null;
	/* Column Info */
	private String daMaxCgoWgt = null;
	/* Column Info */
	private String oaCurrCd = null;
	/* Column Info */
	private String oihFlg = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String daFnlFrtRtAmt = null;
	/* Column Info */
	private String bqPodApplFlg = null;
	/* Column Info */
	private String bqSeq = null;
	/* Column Info */
	private String rtAppBkgConvTpCd = null;
	/* Column Info */
	private String dpPrcTrspModCd = null;
	/* Column Info */
	private String opPrcTrspModCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String diCalcFrtRtAmt = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String diRcvDeTermCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String oftCmbSeq = null;
	/* Column Info */
	private String diRatUtCd = null;
	/* Column Info */
	private String daRatUtCd = null;
	/* Column Info */
	private String oaFnlFrtRtAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmPrcCmdtTpCd = null;
	/* Column Info */
	private String prcRtSeq = null;
	/* Column Info */
	private String rtCalcFrtRtAmt = null;
	/* Column Info */
	private String rtAppNoteConvMapgId = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String diCurrCd = null;
	/* Column Info */
	private String diFdrCurrCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String rtRasBkgConvTpCd = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtRarConvCtnt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String rtRacConvCtnt = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String oiRatUtCd = null;
	/* Column Info */
	private String daPrcCgoTpCd = null;
	/* Column Info */
	private String prcCmdtHdrSeq = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String oaCalcFrtRtAmt = null;
	/* Column Info */
	private String rtRasNoteConvRuleCd = null;
	/* Column Info */
	private String rtRasCurrCd = null;
	/* Column Info */
	private String rtAppNoteConvSeq = null;
	/* Column Info */
	private String oiFdrRcvDeTermCd = null;
	/* Column Info */
	private String rtRasNoteConvTpCd = null;
	/* Column Info */
	private String rtPrcCgoTpCd = null;
	/* Column Info */
	private String rtDorConvCtnt = null;
	/* Column Info */
	private String oaAddChgSeq = null;
	/* Column Info */
	private String note = null;
	/* Column Info */
	private String oaMinCgoWgt = null;
	/* Column Info */
	private String daTypConvCtnt = null;
	/* Column Info */
	private String bkgBqOccrSeq = null;
	/* Column Info */
	private String bqDelApplFlg = null;
	/* Column Info */
	private String daRcvDeTermCd = null;
	/* Column Info */
	private String calcCtrtTpCd = null;
	/* Column Info */
	private String oiCalcFrtRtAmt = null;
	/* Column Info */
	private String daMinCgoWgt = null;
	/* Column Info */
	private String inclOftFlg = null;
	/* Column Info */
	private String oaTypConvCtnt = null;
	/* Column Info */
	private String diAddChgSeq = null;
	/* Column Info */
	private String bqPorRlyPortApplFlg = null;
	/* Column Info */
	private String daRoutPntLocDefCd = null;
	/* Column Info */
	private String rtCurrCd = null;
	/* Column Info */
	private String oaBsePortDefCd = null;
	/* Column Info */
	private String prcHngrBarTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String oiCurrCd = null;
	/* Column Info */
	private String oiFdrCurrCd = null;
	/* Column Info */
	private String oiFnlFrtRtAmt = null;
	/* Column Info */
	private String cmPrcCmdtDefCd = null;
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String bqPorApplFlg = null;
	/* Column Info */
	private String orgTrspModCd = null;
	/* Column Info */
	private String diPrcCgoTpCd = null;
	/* Column Info */
	private String porMtchFlg = null;
	/* Column Info */
	private String rtDeTermCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dtl = null;
	/* Column Info */
	private String bqPolApplFlg = null;
	/* Column Info */
	private String cgoCateCd = null;
	/* Column Info */
	private String destTrspModCd = null;
	/* Column Info */
	private String rtRasRtOpCd = null;
	/* Column Info */
	private String rtMtchPattCd = null;
	/* Column Info */
	private String prcGenSpclRtTpCd = null;
	/* Column Info */
	private String daCurrCd = null;
	/* Column Info */
	private String diFnlFrtRtAmt = null;
	/* Column Info */
	private String rtAppNoteConvRuleCd = null;
	/* Column Info */
	private String inGaFlg = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oiPrcCgoTpCd = null;
	/* Column Info */
	private String diRoutPntLocDefCd = null;
	/* Column Info */
	private String diFnlFdrRtAmt = null;
	/* Column Info */
	private String rtRapConvCtnt = null;
	/* Column Info */
	private String prcRtMtchPattCd = null;
	/* Column Info */
	private String oiAddChgSeq = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String bqPstRlyPortApplFlg = null;
	/* Column Info */
	private String dpRoutPntLocDefCd = null;
	/* Column Info */
	private String daPrcTrspModCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String oiRcvDeTermCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dihFlg = null;
	/* Column Info */
	private String rtAppCurrCd = null;
	/* Column Info */
	private String rtRasNoteConvSeq = null;
	/* Column Info */
	private String oaRoutPntLocDefCd = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String oaRatUtCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtFnlFrtRtAmt = null;
	/* Column Info */
	private String dvRoutViaPortDefCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rtRasFrtRtAmt = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String rtRasNoteConvMapgId = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String rtTypConvCtnt = null;
	/* Column Info */
	private String diBsePortDefCd = null;
	/* Column Info */
	private String daBsePortDefCd = null;
	/* Column Info */
	private String rtAppNoteConvTpCd = null;
	/* Column Info */
	private String ctrtCntrTpszCd = null;
	/* Column Info */
	private String prcRoutSeq = null;
	/* Column Info */
	private String oiPrcTrspModCd = null;
	/* Column Info */
	private String oaMaxCgoWgt = null;
	/* Column Info */
	private String delMtchFlg = null;
	/* Column Info */
	private String oiBsePortDefCd = null;
	/* Column Info */
	private String opRoutPntLocDefCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;
	/* Column Info */
	private String eqSubstCntrTpszCd = null;
	/* Column Info */
	private String oiViaPortDefCd = null;
	/* Column Info */
	private String bkgBqSeq = null;
	/* Column Info */
	private String trnsModCd = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String rtRatUtCd = null;
	/* Column Info */
	private String diViaPortDefCd = null;
	/* Column Info */
	private String rtAppFrtRtAmt = null;
	/* Column Info */
	private String rtAppRtOpCd = null;
	/* Column Info */
	private String rtroFlg = null;
	/* Column Info */
	private String mstRfaRoutId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRfaOftAutoratingListVO() {}

	public SearchRfaOftAutoratingListVO(String ibflag, String pagerows, String oaRacConvCtnt, String daCalcFrtRtAmt, String diCalcFrtRtAmt, String svcScpCd, String cgoTpCd, String oaPrcTrspModCd, String daAddChgSeq, String oaRcvDeTermCd, String rtRasConvCtnt, String oaPrcCgoTpCd, String daRacConvCtnt, String chgAmt, String cntrTpszCd, String rcvDeTermCd, String ovRoutViaPortDefCd, String daMaxCgoWgt, String oaCurrCd, String oihFlg, String cntrWgt, String daFnlFrtRtAmt, String bqPodApplFlg, String bqSeq, String dpPrcTrspModCd, String rtAppBkgConvTpCd, String opPrcTrspModCd, String ratUtCd, String rtSeq, String routSeq, String oftCmbSeq, String podCd, String oaFnlFrtRtAmt, String daRatUtCd, String bkgNo, String cmPrcCmdtTpCd, String rtCalcFrtRtAmt, String prcRtSeq, String rtAppNoteConvMapgId, String opCntrQty, String rcFlg, String imdgClssCd, String rtRasBkgConvTpCd, String rtRarConvCtnt, String dpSeq, String rtRacConvCtnt, String prcCgoTpCd, String daPrcCgoTpCd, String prcCmdtHdrSeq, String fnlFrtRtAmt, String oaCalcFrtRtAmt, String oiCalcFrtRtAmt, String rtRasNoteConvRuleCd, String rtRasCurrCd, String rtAppNoteConvSeq, String rtRasNoteConvTpCd, String rtPrcCgoTpCd, String rtDorConvCtnt, String rtRcvTermCd, String rtDeTermCd, String oaAddChgSeq, String note, String oaMinCgoWgt, String daTypConvCtnt, String bkgBqOccrSeq, String bqDelApplFlg, String daRcvDeTermCd, String daMinCgoWgt, String inclOftFlg, String oaTypConvCtnt, String bqPorRlyPortApplFlg, String daRoutPntLocDefCd, String rtCurrCd, String oaBsePortDefCd, String prcHngrBarTpCd, String propNo, String cmPrcCmdtDefCd, String dryCgoFlg, String amdtSeq, String bqPorApplFlg, String orgTrspModCd, String porMtchFlg, String chgCd, String ctrtNo, String polCd, String dtl, String bqPolApplFlg, String cgoCateCd, String destTrspModCd, String rtRasRtOpCd, String rtMtchPattCd, String prcGenSpclRtTpCd, String daCurrCd, String rtAppNoteConvRuleCd, String inGaFlg, String delCntCd, String awkCgoFlg, String frtTermCd, String delCd, String rtRapConvCtnt, String prcRtMtchPattCd, String ratAsQty, String bqPstRlyPortApplFlg, String dpRoutPntLocDefCd, String daPrcTrspModCd, String porCd, String dihFlg, String currCd, String rtAppCurrCd, String rtRasNoteConvSeq, String oaRoutPntLocDefCd, String noteCtnt, String oaRatUtCd, String rtFnlFrtRtAmt, String bbCgoFlg, String dvRoutViaPortDefCd, String dcgoFlg, String rcvTermCd, String porCntCd, String rtRasFrtRtAmt, String rtRasNoteConvMapgId, String chgUtAmt, String rtTypConvCtnt, String cmdtHdrSeq, String daBsePortDefCd, String prcRoutSeq, String ctrtCntrTpszCd, String rtAppNoteConvTpCd, String oaMaxCgoWgt, String delMtchFlg, String opRoutPntLocDefCd, String cmdtNm, String socFlg, String eqSubstCntrTpszCd, String frtInclXcldDivCd, String deTermCd, String trnsModCd, String bkgBqSeq, String frtRtAmt, String rtRatUtCd, String rtAppFrtRtAmt, String rtAppRtOpCd, String calcCtrtTpCd, String oiAddChgSeq, String diAddChgSeq, String oiRoutPntLocDefCd, String oiBsePortDefCd, String oiViaPortDefCd, String oiRatUtCd, String oiPrcCgoTpCd, String oiPrcTrspModCd, String oiRcvDeTermCd, String oiFdrRcvDeTermCd, String oiCurrCd, String oiFdrCurrCd, String oiFnlFdrRtAmt, String oiFnlIhcRtAmt, String oiFnlFrtRtAmt, String diRoutPntLocDefCd, String diBsePortDefCd, String diViaPortDefCd, String diRatUtCd, String diPrcCgoTpCd, String diPrcTrspModCd, String diRcvDeTermCd, String diFdrRcvDeTermCd, String diCurrCd, String diFdrCurrCd, String diFnlFdrRtAmt, String diFnlIhcRtAmt, String diFnlFrtRtAmt, String rtroFlg, String mstRfaRoutId ) {
		this.rtRcvTermCd = rtRcvTermCd;
		this.daCalcFrtRtAmt = daCalcFrtRtAmt;
		this.oaRacConvCtnt = oaRacConvCtnt;
		this.svcScpCd = svcScpCd;
		this.cgoTpCd = cgoTpCd;
		this.oaPrcTrspModCd = oaPrcTrspModCd;
		this.diPrcTrspModCd = diPrcTrspModCd;
		this.daAddChgSeq = daAddChgSeq;
		this.oiFnlFdrRtAmt = oiFnlFdrRtAmt;
		this.diFdrRcvDeTermCd = diFdrRcvDeTermCd;
		this.pagerows = pagerows;
		this.oaRcvDeTermCd = oaRcvDeTermCd;
		this.diFnlIhcRtAmt = diFnlIhcRtAmt;
		this.rtRasConvCtnt = rtRasConvCtnt;
		this.oaPrcCgoTpCd = oaPrcCgoTpCd;
		this.oiFnlIhcRtAmt = oiFnlIhcRtAmt;
		this.daRacConvCtnt = daRacConvCtnt;
		this.chgAmt = chgAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
		this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
		this.daMaxCgoWgt = daMaxCgoWgt;
		this.oaCurrCd = oaCurrCd;
		this.oihFlg = oihFlg;
		this.cntrWgt = cntrWgt;
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
		this.bqPodApplFlg = bqPodApplFlg;
		this.bqSeq = bqSeq;
		this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
		this.dpPrcTrspModCd = dpPrcTrspModCd;
		this.opPrcTrspModCd = opPrcTrspModCd;
		this.ratUtCd = ratUtCd;
		this.rtSeq = rtSeq;
		this.diCalcFrtRtAmt = diCalcFrtRtAmt;
		this.routSeq = routSeq;
		this.diRcvDeTermCd = diRcvDeTermCd;
		this.podCd = podCd;
		this.oftCmbSeq = oftCmbSeq;
		this.diRatUtCd = diRatUtCd;
		this.daRatUtCd = daRatUtCd;
		this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
		this.bkgNo = bkgNo;
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
		this.prcRtSeq = prcRtSeq;
		this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
		this.rtAppNoteConvMapgId = rtAppNoteConvMapgId;
		this.opCntrQty = opCntrQty;
		this.diCurrCd = diCurrCd;
		this.diFdrCurrCd = diFdrCurrCd;
		this.rcFlg = rcFlg;
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
		this.imdgClssCd = imdgClssCd;
		this.rtRarConvCtnt = rtRarConvCtnt;
		this.dpSeq = dpSeq;
		this.rtRacConvCtnt = rtRacConvCtnt;
		this.prcCgoTpCd = prcCgoTpCd;
		this.oiRatUtCd = oiRatUtCd;
		this.daPrcCgoTpCd = daPrcCgoTpCd;
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
		this.rtRasNoteConvRuleCd = rtRasNoteConvRuleCd;
		this.rtRasCurrCd = rtRasCurrCd;
		this.rtAppNoteConvSeq = rtAppNoteConvSeq;
		this.oiFdrRcvDeTermCd = oiFdrRcvDeTermCd;
		this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
		this.rtPrcCgoTpCd = rtPrcCgoTpCd;
		this.rtDorConvCtnt = rtDorConvCtnt;
		this.oaAddChgSeq = oaAddChgSeq;
		this.note = note;
		this.oaMinCgoWgt = oaMinCgoWgt;
		this.daTypConvCtnt = daTypConvCtnt;
		this.bkgBqOccrSeq = bkgBqOccrSeq;
		this.bqDelApplFlg = bqDelApplFlg;
		this.daRcvDeTermCd = daRcvDeTermCd;
		this.calcCtrtTpCd = calcCtrtTpCd;
		this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
		this.daMinCgoWgt = daMinCgoWgt;
		this.inclOftFlg = inclOftFlg;
		this.oaTypConvCtnt = oaTypConvCtnt;
		this.diAddChgSeq = diAddChgSeq;
		this.bqPorRlyPortApplFlg = bqPorRlyPortApplFlg;
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
		this.rtCurrCd = rtCurrCd;
		this.oaBsePortDefCd = oaBsePortDefCd;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.propNo = propNo;
		this.oiCurrCd = oiCurrCd;
		this.oiFdrCurrCd = oiFdrCurrCd;
		this.oiFnlFrtRtAmt = oiFnlFrtRtAmt;
		this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
		this.dryCgoFlg = dryCgoFlg;
		this.amdtSeq = amdtSeq;
		this.bqPorApplFlg = bqPorApplFlg;
		this.orgTrspModCd = orgTrspModCd;
		this.diPrcCgoTpCd = diPrcCgoTpCd;
		this.porMtchFlg = porMtchFlg;
		this.rtDeTermCd = rtDeTermCd;
		this.chgCd = chgCd;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.dtl = dtl;
		this.bqPolApplFlg = bqPolApplFlg;
		this.cgoCateCd = cgoCateCd;
		this.destTrspModCd = destTrspModCd;
		this.rtRasRtOpCd = rtRasRtOpCd;
		this.rtMtchPattCd = rtMtchPattCd;
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
		this.daCurrCd = daCurrCd;
		this.diFnlFrtRtAmt = diFnlFrtRtAmt;
		this.rtAppNoteConvRuleCd = rtAppNoteConvRuleCd;
		this.inGaFlg = inGaFlg;
		this.delCntCd = delCntCd;
		this.awkCgoFlg = awkCgoFlg;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.oiPrcCgoTpCd = oiPrcCgoTpCd;
		this.diRoutPntLocDefCd = diRoutPntLocDefCd;
		this.diFnlFdrRtAmt = diFnlFdrRtAmt;
		this.rtRapConvCtnt = rtRapConvCtnt;
		this.prcRtMtchPattCd = prcRtMtchPattCd;
		this.oiAddChgSeq = oiAddChgSeq;
		this.ratAsQty = ratAsQty;
		this.bqPstRlyPortApplFlg = bqPstRlyPortApplFlg;
		this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
		this.daPrcTrspModCd = daPrcTrspModCd;
		this.porCd = porCd;
		this.oiRcvDeTermCd = oiRcvDeTermCd;
		this.currCd = currCd;
		this.dihFlg = dihFlg;
		this.rtAppCurrCd = rtAppCurrCd;
		this.rtRasNoteConvSeq = rtRasNoteConvSeq;
		this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
		this.noteCtnt = noteCtnt;
		this.oaRatUtCd = oaRatUtCd;
		this.ibflag = ibflag;
		this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
		this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.rcvTermCd = rcvTermCd;
		this.rtRasFrtRtAmt = rtRasFrtRtAmt;
		this.porCntCd = porCntCd;
		this.rtRasNoteConvMapgId = rtRasNoteConvMapgId;
		this.chgUtAmt = chgUtAmt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.rtTypConvCtnt = rtTypConvCtnt;
		this.diBsePortDefCd = diBsePortDefCd;
		this.daBsePortDefCd = daBsePortDefCd;
		this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
		this.prcRoutSeq = prcRoutSeq;
		this.oiPrcTrspModCd = oiPrcTrspModCd;
		this.oaMaxCgoWgt = oaMaxCgoWgt;
		this.delMtchFlg = delMtchFlg;
		this.oiBsePortDefCd = oiBsePortDefCd;
		this.opRoutPntLocDefCd = opRoutPntLocDefCd;
		this.cmdtNm = cmdtNm;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
		this.oiViaPortDefCd = oiViaPortDefCd;
		this.bkgBqSeq = bkgBqSeq;
		this.trnsModCd = trnsModCd;
		this.frtRtAmt = frtRtAmt;
		this.rtRatUtCd = rtRatUtCd;
		this.diViaPortDefCd = diViaPortDefCd;
		this.rtAppFrtRtAmt = rtAppFrtRtAmt;
		this.rtAppRtOpCd = rtAppRtOpCd;
		this.rtroFlg = rtroFlg;
		this.mstRfaRoutId = mstRfaRoutId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rt_rcv_term_cd", getRtRcvTermCd());
		this.hashColumns.put("da_calc_frt_rt_amt", getDaCalcFrtRtAmt());
		this.hashColumns.put("oa_rac_conv_ctnt", getOaRacConvCtnt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("oa_prc_trsp_mod_cd", getOaPrcTrspModCd());
		this.hashColumns.put("di_prc_trsp_mod_cd", getDiPrcTrspModCd());
		this.hashColumns.put("da_add_chg_seq", getDaAddChgSeq());
		this.hashColumns.put("oi_fnl_fdr_rt_amt", getOiFnlFdrRtAmt());
		this.hashColumns.put("di_fdr_rcv_de_term_cd", getDiFdrRcvDeTermCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("oa_rcv_de_term_cd", getOaRcvDeTermCd());
		this.hashColumns.put("di_fnl_ihc_rt_amt", getDiFnlIhcRtAmt());
		this.hashColumns.put("rt_ras_conv_ctnt", getRtRasConvCtnt());
		this.hashColumns.put("oa_prc_cgo_tp_cd", getOaPrcCgoTpCd());
		this.hashColumns.put("oi_fnl_ihc_rt_amt", getOiFnlIhcRtAmt());
		this.hashColumns.put("da_rac_conv_ctnt", getDaRacConvCtnt());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("ov_rout_via_port_def_cd", getOvRoutViaPortDefCd());
		this.hashColumns.put("oi_rout_pnt_loc_def_cd", getOiRoutPntLocDefCd());
		this.hashColumns.put("da_max_cgo_wgt", getDaMaxCgoWgt());
		this.hashColumns.put("oa_curr_cd", getOaCurrCd());
		this.hashColumns.put("oih_flg", getOihFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("da_fnl_frt_rt_amt", getDaFnlFrtRtAmt());
		this.hashColumns.put("bq_pod_appl_flg", getBqPodApplFlg());
		this.hashColumns.put("bq_seq", getBqSeq());
		this.hashColumns.put("rt_app_bkg_conv_tp_cd", getRtAppBkgConvTpCd());
		this.hashColumns.put("dp_prc_trsp_mod_cd", getDpPrcTrspModCd());
		this.hashColumns.put("op_prc_trsp_mod_cd", getOpPrcTrspModCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("di_calc_frt_rt_amt", getDiCalcFrtRtAmt());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("di_rcv_de_term_cd", getDiRcvDeTermCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("oft_cmb_seq", getOftCmbSeq());
		this.hashColumns.put("di_rat_ut_cd", getDiRatUtCd());
		this.hashColumns.put("da_rat_ut_cd", getDaRatUtCd());
		this.hashColumns.put("oa_fnl_frt_rt_amt", getOaFnlFrtRtAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cm_prc_cmdt_tp_cd", getCmPrcCmdtTpCd());
		this.hashColumns.put("prc_rt_seq", getPrcRtSeq());
		this.hashColumns.put("rt_calc_frt_rt_amt", getRtCalcFrtRtAmt());
		this.hashColumns.put("rt_app_note_conv_mapg_id", getRtAppNoteConvMapgId());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("di_curr_cd", getDiCurrCd());
		this.hashColumns.put("di_fdr_curr_cd", getDiFdrCurrCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("rt_ras_bkg_conv_tp_cd", getRtRasBkgConvTpCd());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_rar_conv_ctnt", getRtRarConvCtnt());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("rt_rac_conv_ctnt", getRtRacConvCtnt());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("oi_rat_ut_cd", getOiRatUtCd());
		this.hashColumns.put("da_prc_cgo_tp_cd", getDaPrcCgoTpCd());
		this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("oa_calc_frt_rt_amt", getOaCalcFrtRtAmt());
		this.hashColumns.put("rt_ras_note_conv_rule_cd", getRtRasNoteConvRuleCd());
		this.hashColumns.put("rt_ras_curr_cd", getRtRasCurrCd());
		this.hashColumns.put("rt_app_note_conv_seq", getRtAppNoteConvSeq());
		this.hashColumns.put("oi_fdr_rcv_de_term_cd", getOiFdrRcvDeTermCd());
		this.hashColumns.put("rt_ras_note_conv_tp_cd", getRtRasNoteConvTpCd());
		this.hashColumns.put("rt_prc_cgo_tp_cd", getRtPrcCgoTpCd());
		this.hashColumns.put("rt_dor_conv_ctnt", getRtDorConvCtnt());
		this.hashColumns.put("oa_add_chg_seq", getOaAddChgSeq());
		this.hashColumns.put("note", getNote());
		this.hashColumns.put("oa_min_cgo_wgt", getOaMinCgoWgt());
		this.hashColumns.put("da_typ_conv_ctnt", getDaTypConvCtnt());
		this.hashColumns.put("bkg_bq_occr_seq", getBkgBqOccrSeq());
		this.hashColumns.put("bq_del_appl_flg", getBqDelApplFlg());
		this.hashColumns.put("da_rcv_de_term_cd", getDaRcvDeTermCd());
		this.hashColumns.put("calc_ctrt_tp_cd", getCalcCtrtTpCd());
		this.hashColumns.put("oi_calc_frt_rt_amt", getOiCalcFrtRtAmt());
		this.hashColumns.put("da_min_cgo_wgt", getDaMinCgoWgt());
		this.hashColumns.put("incl_oft_flg", getInclOftFlg());
		this.hashColumns.put("oa_typ_conv_ctnt", getOaTypConvCtnt());
		this.hashColumns.put("di_add_chg_seq", getDiAddChgSeq());
		this.hashColumns.put("bq_por_rly_port_appl_flg", getBqPorRlyPortApplFlg());
		this.hashColumns.put("da_rout_pnt_loc_def_cd", getDaRoutPntLocDefCd());
		this.hashColumns.put("rt_curr_cd", getRtCurrCd());
		this.hashColumns.put("oa_bse_port_def_cd", getOaBsePortDefCd());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("oi_curr_cd", getOiCurrCd());
		this.hashColumns.put("oi_fdr_curr_cd", getOiFdrCurrCd());
		this.hashColumns.put("oi_fnl_frt_rt_amt", getOiFnlFrtRtAmt());
		this.hashColumns.put("cm_prc_cmdt_def_cd", getCmPrcCmdtDefCd());
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("bq_por_appl_flg", getBqPorApplFlg());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("di_prc_cgo_tp_cd", getDiPrcCgoTpCd());
		this.hashColumns.put("por_mtch_flg", getPorMtchFlg());
		this.hashColumns.put("rt_de_term_cd", getRtDeTermCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dtl", getDtl());
		this.hashColumns.put("bq_pol_appl_flg", getBqPolApplFlg());
		this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
		this.hashColumns.put("dest_trsp_mod_cd", getDestTrspModCd());
		this.hashColumns.put("rt_ras_rt_op_cd", getRtRasRtOpCd());
		this.hashColumns.put("rt_mtch_patt_cd", getRtMtchPattCd());
		this.hashColumns.put("prc_gen_spcl_rt_tp_cd", getPrcGenSpclRtTpCd());
		this.hashColumns.put("da_curr_cd", getDaCurrCd());
		this.hashColumns.put("di_fnl_frt_rt_amt", getDiFnlFrtRtAmt());
		this.hashColumns.put("rt_app_note_conv_rule_cd", getRtAppNoteConvRuleCd());
		this.hashColumns.put("in_ga_flg", getInGaFlg());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("oi_prc_cgo_tp_cd", getOiPrcCgoTpCd());
		this.hashColumns.put("di_rout_pnt_loc_def_cd", getDiRoutPntLocDefCd());
		this.hashColumns.put("di_fnl_fdr_rt_amt", getDiFnlFdrRtAmt());
		this.hashColumns.put("rt_rap_conv_ctnt", getRtRapConvCtnt());
		this.hashColumns.put("prc_rt_mtch_patt_cd", getPrcRtMtchPattCd());
		this.hashColumns.put("oi_add_chg_seq", getOiAddChgSeq());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("bq_pst_rly_port_appl_flg", getBqPstRlyPortApplFlg());
		this.hashColumns.put("dp_rout_pnt_loc_def_cd", getDpRoutPntLocDefCd());
		this.hashColumns.put("da_prc_trsp_mod_cd", getDaPrcTrspModCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("oi_rcv_de_term_cd", getOiRcvDeTermCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dih_flg", getDihFlg());
		this.hashColumns.put("rt_app_curr_cd", getRtAppCurrCd());
		this.hashColumns.put("rt_ras_note_conv_seq", getRtRasNoteConvSeq());
		this.hashColumns.put("oa_rout_pnt_loc_def_cd", getOaRoutPntLocDefCd());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("oa_rat_ut_cd", getOaRatUtCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_fnl_frt_rt_amt", getRtFnlFrtRtAmt());
		this.hashColumns.put("dv_rout_via_port_def_cd", getDvRoutViaPortDefCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rt_ras_frt_rt_amt", getRtRasFrtRtAmt());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("rt_ras_note_conv_mapg_id", getRtRasNoteConvMapgId());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("rt_typ_conv_ctnt", getRtTypConvCtnt());
		this.hashColumns.put("di_bse_port_def_cd", getDiBsePortDefCd());
		this.hashColumns.put("da_bse_port_def_cd", getDaBsePortDefCd());
		this.hashColumns.put("rt_app_note_conv_tp_cd", getRtAppNoteConvTpCd());
		this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
		this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
		this.hashColumns.put("oi_prc_trsp_mod_cd", getOiPrcTrspModCd());
		this.hashColumns.put("oa_max_cgo_wgt", getOaMaxCgoWgt());
		this.hashColumns.put("del_mtch_flg", getDelMtchFlg());
		this.hashColumns.put("oi_bse_port_def_cd", getOiBsePortDefCd());
		this.hashColumns.put("op_rout_pnt_loc_def_cd", getOpRoutPntLocDefCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
		this.hashColumns.put("oi_via_port_def_cd", getOiViaPortDefCd());
		this.hashColumns.put("bkg_bq_seq", getBkgBqSeq());
		this.hashColumns.put("trns_mod_cd", getTrnsModCd());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("rt_rat_ut_cd", getRtRatUtCd());
		this.hashColumns.put("di_via_port_def_cd", getDiViaPortDefCd());
		this.hashColumns.put("rt_app_frt_rt_amt", getRtAppFrtRtAmt());
		this.hashColumns.put("rt_app_rt_op_cd", getRtAppRtOpCd());
		this.hashColumns.put("rtro_flg", getRtroFlg());
		this.hashColumns.put("mst_rfa_rout_id", getMstRfaRoutId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rt_rcv_term_cd", "rtRcvTermCd");
		this.hashFields.put("da_calc_frt_rt_amt", "daCalcFrtRtAmt");
		this.hashFields.put("oa_rac_conv_ctnt", "oaRacConvCtnt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("oa_prc_trsp_mod_cd", "oaPrcTrspModCd");
		this.hashFields.put("di_prc_trsp_mod_cd", "diPrcTrspModCd");
		this.hashFields.put("da_add_chg_seq", "daAddChgSeq");
		this.hashFields.put("oi_fnl_fdr_rt_amt", "oiFnlFdrRtAmt");
		this.hashFields.put("di_fdr_rcv_de_term_cd", "diFdrRcvDeTermCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oa_rcv_de_term_cd", "oaRcvDeTermCd");
		this.hashFields.put("di_fnl_ihc_rt_amt", "diFnlIhcRtAmt");
		this.hashFields.put("rt_ras_conv_ctnt", "rtRasConvCtnt");
		this.hashFields.put("oa_prc_cgo_tp_cd", "oaPrcCgoTpCd");
		this.hashFields.put("oi_fnl_ihc_rt_amt", "oiFnlIhcRtAmt");
		this.hashFields.put("da_rac_conv_ctnt", "daRacConvCtnt");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("ov_rout_via_port_def_cd", "ovRoutViaPortDefCd");
		this.hashFields.put("oi_rout_pnt_loc_def_cd", "oiRoutPntLocDefCd");
		this.hashFields.put("da_max_cgo_wgt", "daMaxCgoWgt");
		this.hashFields.put("oa_curr_cd", "oaCurrCd");
		this.hashFields.put("oih_flg", "oihFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("da_fnl_frt_rt_amt", "daFnlFrtRtAmt");
		this.hashFields.put("bq_pod_appl_flg", "bqPodApplFlg");
		this.hashFields.put("bq_seq", "bqSeq");
		this.hashFields.put("rt_app_bkg_conv_tp_cd", "rtAppBkgConvTpCd");
		this.hashFields.put("dp_prc_trsp_mod_cd", "dpPrcTrspModCd");
		this.hashFields.put("op_prc_trsp_mod_cd", "opPrcTrspModCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("di_calc_frt_rt_amt", "diCalcFrtRtAmt");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("di_rcv_de_term_cd", "diRcvDeTermCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("oft_cmb_seq", "oftCmbSeq");
		this.hashFields.put("di_rat_ut_cd", "diRatUtCd");
		this.hashFields.put("da_rat_ut_cd", "daRatUtCd");
		this.hashFields.put("oa_fnl_frt_rt_amt", "oaFnlFrtRtAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cm_prc_cmdt_tp_cd", "cmPrcCmdtTpCd");
		this.hashFields.put("prc_rt_seq", "prcRtSeq");
		this.hashFields.put("rt_calc_frt_rt_amt", "rtCalcFrtRtAmt");
		this.hashFields.put("rt_app_note_conv_mapg_id", "rtAppNoteConvMapgId");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("di_curr_cd", "diCurrCd");
		this.hashFields.put("di_fdr_curr_cd", "diFdrCurrCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("rt_ras_bkg_conv_tp_cd", "rtRasBkgConvTpCd");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_rar_conv_ctnt", "rtRarConvCtnt");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("rt_rac_conv_ctnt", "rtRacConvCtnt");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("oi_rat_ut_cd", "oiRatUtCd");
		this.hashFields.put("da_prc_cgo_tp_cd", "daPrcCgoTpCd");
		this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("oa_calc_frt_rt_amt", "oaCalcFrtRtAmt");
		this.hashFields.put("rt_ras_note_conv_rule_cd", "rtRasNoteConvRuleCd");
		this.hashFields.put("rt_ras_curr_cd", "rtRasCurrCd");
		this.hashFields.put("rt_app_note_conv_seq", "rtAppNoteConvSeq");
		this.hashFields.put("oi_fdr_rcv_de_term_cd", "oiFdrRcvDeTermCd");
		this.hashFields.put("rt_ras_note_conv_tp_cd", "rtRasNoteConvTpCd");
		this.hashFields.put("rt_prc_cgo_tp_cd", "rtPrcCgoTpCd");
		this.hashFields.put("rt_dor_conv_ctnt", "rtDorConvCtnt");
		this.hashFields.put("oa_add_chg_seq", "oaAddChgSeq");
		this.hashFields.put("note", "note");
		this.hashFields.put("oa_min_cgo_wgt", "oaMinCgoWgt");
		this.hashFields.put("da_typ_conv_ctnt", "daTypConvCtnt");
		this.hashFields.put("bkg_bq_occr_seq", "bkgBqOccrSeq");
		this.hashFields.put("bq_del_appl_flg", "bqDelApplFlg");
		this.hashFields.put("da_rcv_de_term_cd", "daRcvDeTermCd");
		this.hashFields.put("calc_ctrt_tp_cd", "calcCtrtTpCd");
		this.hashFields.put("oi_calc_frt_rt_amt", "oiCalcFrtRtAmt");
		this.hashFields.put("da_min_cgo_wgt", "daMinCgoWgt");
		this.hashFields.put("incl_oft_flg", "inclOftFlg");
		this.hashFields.put("oa_typ_conv_ctnt", "oaTypConvCtnt");
		this.hashFields.put("di_add_chg_seq", "diAddChgSeq");
		this.hashFields.put("bq_por_rly_port_appl_flg", "bqPorRlyPortApplFlg");
		this.hashFields.put("da_rout_pnt_loc_def_cd", "daRoutPntLocDefCd");
		this.hashFields.put("rt_curr_cd", "rtCurrCd");
		this.hashFields.put("oa_bse_port_def_cd", "oaBsePortDefCd");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("oi_curr_cd", "oiCurrCd");
		this.hashFields.put("oi_fdr_curr_cd", "oiFdrCurrCd");
		this.hashFields.put("oi_fnl_frt_rt_amt", "oiFnlFrtRtAmt");
		this.hashFields.put("cm_prc_cmdt_def_cd", "cmPrcCmdtDefCd");
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("bq_por_appl_flg", "bqPorApplFlg");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("di_prc_cgo_tp_cd", "diPrcCgoTpCd");
		this.hashFields.put("por_mtch_flg", "porMtchFlg");
		this.hashFields.put("rt_de_term_cd", "rtDeTermCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dtl", "dtl");
		this.hashFields.put("bq_pol_appl_flg", "bqPolApplFlg");
		this.hashFields.put("cgo_cate_cd", "cgoCateCd");
		this.hashFields.put("dest_trsp_mod_cd", "destTrspModCd");
		this.hashFields.put("rt_ras_rt_op_cd", "rtRasRtOpCd");
		this.hashFields.put("rt_mtch_patt_cd", "rtMtchPattCd");
		this.hashFields.put("prc_gen_spcl_rt_tp_cd", "prcGenSpclRtTpCd");
		this.hashFields.put("da_curr_cd", "daCurrCd");
		this.hashFields.put("di_fnl_frt_rt_amt", "diFnlFrtRtAmt");
		this.hashFields.put("rt_app_note_conv_rule_cd", "rtAppNoteConvRuleCd");
		this.hashFields.put("in_ga_flg", "inGaFlg");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("oi_prc_cgo_tp_cd", "oiPrcCgoTpCd");
		this.hashFields.put("di_rout_pnt_loc_def_cd", "diRoutPntLocDefCd");
		this.hashFields.put("di_fnl_fdr_rt_amt", "diFnlFdrRtAmt");
		this.hashFields.put("rt_rap_conv_ctnt", "rtRapConvCtnt");
		this.hashFields.put("prc_rt_mtch_patt_cd", "prcRtMtchPattCd");
		this.hashFields.put("oi_add_chg_seq", "oiAddChgSeq");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("bq_pst_rly_port_appl_flg", "bqPstRlyPortApplFlg");
		this.hashFields.put("dp_rout_pnt_loc_def_cd", "dpRoutPntLocDefCd");
		this.hashFields.put("da_prc_trsp_mod_cd", "daPrcTrspModCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("oi_rcv_de_term_cd", "oiRcvDeTermCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dih_flg", "dihFlg");
		this.hashFields.put("rt_app_curr_cd", "rtAppCurrCd");
		this.hashFields.put("rt_ras_note_conv_seq", "rtRasNoteConvSeq");
		this.hashFields.put("oa_rout_pnt_loc_def_cd", "oaRoutPntLocDefCd");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("oa_rat_ut_cd", "oaRatUtCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_fnl_frt_rt_amt", "rtFnlFrtRtAmt");
		this.hashFields.put("dv_rout_via_port_def_cd", "dvRoutViaPortDefCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rt_ras_frt_rt_amt", "rtRasFrtRtAmt");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("rt_ras_note_conv_mapg_id", "rtRasNoteConvMapgId");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("rt_typ_conv_ctnt", "rtTypConvCtnt");
		this.hashFields.put("di_bse_port_def_cd", "diBsePortDefCd");
		this.hashFields.put("da_bse_port_def_cd", "daBsePortDefCd");
		this.hashFields.put("rt_app_note_conv_tp_cd", "rtAppNoteConvTpCd");
		this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
		this.hashFields.put("prc_rout_seq", "prcRoutSeq");
		this.hashFields.put("oi_prc_trsp_mod_cd", "oiPrcTrspModCd");
		this.hashFields.put("oa_max_cgo_wgt", "oaMaxCgoWgt");
		this.hashFields.put("del_mtch_flg", "delMtchFlg");
		this.hashFields.put("oi_bse_port_def_cd", "oiBsePortDefCd");
		this.hashFields.put("op_rout_pnt_loc_def_cd", "opRoutPntLocDefCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
		this.hashFields.put("oi_via_port_def_cd", "oiViaPortDefCd");
		this.hashFields.put("bkg_bq_seq", "bkgBqSeq");
		this.hashFields.put("trns_mod_cd", "trnsModCd");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("rt_rat_ut_cd", "rtRatUtCd");
		this.hashFields.put("di_via_port_def_cd", "diViaPortDefCd");
		this.hashFields.put("rt_app_frt_rt_amt", "rtAppFrtRtAmt");
		this.hashFields.put("rt_app_rt_op_cd", "rtAppRtOpCd");
		this.hashFields.put("rtro_flg", "rtroFlg");
		this.hashFields.put("mst_rfa_rout_id", "mstRfaRoutId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rtRcvTermCd
	 */
	public String getRtRcvTermCd() {
		return this.rtRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return daCalcFrtRtAmt
	 */
	public String getDaCalcFrtRtAmt() {
		return this.daCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return oaRacConvCtnt
	 */
	public String getOaRacConvCtnt() {
		return this.oaRacConvCtnt;
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
	 * @return mstRfaRoutId
	 */
	public String getMstRfaRoutId() {
		return this.mstRfaRoutId;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return oaPrcTrspModCd
	 */
	public String getOaPrcTrspModCd() {
		return this.oaPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return diPrcTrspModCd
	 */
	public String getDiPrcTrspModCd() {
		return this.diPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return daAddChgSeq
	 */
	public String getDaAddChgSeq() {
		return this.daAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return oiFnlFdrRtAmt
	 */
	public String getOiFnlFdrRtAmt() {
		return this.oiFnlFdrRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diFdrRcvDeTermCd
	 */
	public String getDiFdrRcvDeTermCd() {
		return this.diFdrRcvDeTermCd;
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
	 * @return oaRcvDeTermCd
	 */
	public String getOaRcvDeTermCd() {
		return this.oaRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return diFnlIhcRtAmt
	 */
	public String getDiFnlIhcRtAmt() {
		return this.diFnlIhcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRasConvCtnt
	 */
	public String getRtRasConvCtnt() {
		return this.rtRasConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return oaPrcCgoTpCd
	 */
	public String getOaPrcCgoTpCd() {
		return this.oaPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return oiFnlIhcRtAmt
	 */
	public String getOiFnlIhcRtAmt() {
		return this.oiFnlIhcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return daRacConvCtnt
	 */
	public String getDaRacConvCtnt() {
		return this.daRacConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return ovRoutViaPortDefCd
	 */
	public String getOvRoutViaPortDefCd() {
		return this.ovRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return oiRoutPntLocDefCd
	 */
	public String getOiRoutPntLocDefCd() {
		return this.oiRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return daMaxCgoWgt
	 */
	public String getDaMaxCgoWgt() {
		return this.daMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return oaCurrCd
	 */
	public String getOaCurrCd() {
		return this.oaCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oihFlg
	 */
	public String getOihFlg() {
		return this.oihFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return daFnlFrtRtAmt
	 */
	public String getDaFnlFrtRtAmt() {
		return this.daFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return bqPodApplFlg
	 */
	public String getBqPodApplFlg() {
		return this.bqPodApplFlg;
	}
	
	/**
	 * Column Info
	 * @return bqSeq
	 */
	public String getBqSeq() {
		return this.bqSeq;
	}
	
	/**
	 * Column Info
	 * @return rtAppBkgConvTpCd
	 */
	public String getRtAppBkgConvTpCd() {
		return this.rtAppBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return dpPrcTrspModCd
	 */
	public String getDpPrcTrspModCd() {
		return this.dpPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return opPrcTrspModCd
	 */
	public String getOpPrcTrspModCd() {
		return this.opPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return diCalcFrtRtAmt
	 */
	public String getDiCalcFrtRtAmt() {
		return this.diCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return diRcvDeTermCd
	 */
	public String getDiRcvDeTermCd() {
		return this.diRcvDeTermCd;
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
	 * @return oftCmbSeq
	 */
	public String getOftCmbSeq() {
		return this.oftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return diRatUtCd
	 */
	public String getDiRatUtCd() {
		return this.diRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return daRatUtCd
	 */
	public String getDaRatUtCd() {
		return this.daRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return oaFnlFrtRtAmt
	 */
	public String getOaFnlFrtRtAmt() {
		return this.oaFnlFrtRtAmt;
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
	 * @return cmPrcCmdtTpCd
	 */
	public String getCmPrcCmdtTpCd() {
		return this.cmPrcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcRtSeq
	 */
	public String getPrcRtSeq() {
		return this.prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @return rtCalcFrtRtAmt
	 */
	public String getRtCalcFrtRtAmt() {
		return this.rtCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvMapgId
	 */
	public String getRtAppNoteConvMapgId() {
		return this.rtAppNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return diCurrCd
	 */
	public String getDiCurrCd() {
		return this.diCurrCd;
	}
	
	/**
	 * Column Info
	 * @return diFdrCurrCd
	 */
	public String getDiFdrCurrCd() {
		return this.diFdrCurrCd;
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
	 * @return rtRasBkgConvTpCd
	 */
	public String getRtRasBkgConvTpCd() {
		return this.rtRasBkgConvTpCd;
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
	 * @return rtRarConvCtnt
	 */
	public String getRtRarConvCtnt() {
		return this.rtRarConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return rtRacConvCtnt
	 */
	public String getRtRacConvCtnt() {
		return this.rtRacConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return oiRatUtCd
	 */
	public String getOiRatUtCd() {
		return this.oiRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return daPrcCgoTpCd
	 */
	public String getDaPrcCgoTpCd() {
		return this.daPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtHdrSeq
	 */
	public String getPrcCmdtHdrSeq() {
		return this.prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return oaCalcFrtRtAmt
	 */
	public String getOaCalcFrtRtAmt() {
		return this.oaCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvRuleCd
	 */
	public String getRtRasNoteConvRuleCd() {
		return this.rtRasNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasCurrCd
	 */
	public String getRtRasCurrCd() {
		return this.rtRasCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvSeq
	 */
	public String getRtAppNoteConvSeq() {
		return this.rtAppNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return oiFdrRcvDeTermCd
	 */
	public String getOiFdrRcvDeTermCd() {
		return this.oiFdrRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvTpCd
	 */
	public String getRtRasNoteConvTpCd() {
		return this.rtRasNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtPrcCgoTpCd
	 */
	public String getRtPrcCgoTpCd() {
		return this.rtPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtDorConvCtnt
	 */
	public String getRtDorConvCtnt() {
		return this.rtDorConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return oaAddChgSeq
	 */
	public String getOaAddChgSeq() {
		return this.oaAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return note
	 */
	public String getNote() {
		return this.note;
	}
	
	/**
	 * Column Info
	 * @return oaMinCgoWgt
	 */
	public String getOaMinCgoWgt() {
		return this.oaMinCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return daTypConvCtnt
	 */
	public String getDaTypConvCtnt() {
		return this.daTypConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return bkgBqOccrSeq
	 */
	public String getBkgBqOccrSeq() {
		return this.bkgBqOccrSeq;
	}
	
	/**
	 * Column Info
	 * @return bqDelApplFlg
	 */
	public String getBqDelApplFlg() {
		return this.bqDelApplFlg;
	}
	
	/**
	 * Column Info
	 * @return daRcvDeTermCd
	 */
	public String getDaRcvDeTermCd() {
		return this.daRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return calcCtrtTpCd
	 */
	public String getCalcCtrtTpCd() {
		return this.calcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return oiCalcFrtRtAmt
	 */
	public String getOiCalcFrtRtAmt() {
		return this.oiCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return daMinCgoWgt
	 */
	public String getDaMinCgoWgt() {
		return this.daMinCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return inclOftFlg
	 */
	public String getInclOftFlg() {
		return this.inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return oaTypConvCtnt
	 */
	public String getOaTypConvCtnt() {
		return this.oaTypConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return diAddChgSeq
	 */
	public String getDiAddChgSeq() {
		return this.diAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return bqPorRlyPortApplFlg
	 */
	public String getBqPorRlyPortApplFlg() {
		return this.bqPorRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @return daRoutPntLocDefCd
	 */
	public String getDaRoutPntLocDefCd() {
		return this.daRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtCurrCd
	 */
	public String getRtCurrCd() {
		return this.rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oaBsePortDefCd
	 */
	public String getOaBsePortDefCd() {
		return this.oaBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return prcHngrBarTpCd
	 */
	public String getPrcHngrBarTpCd() {
		return this.prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return oiCurrCd
	 */
	public String getOiCurrCd() {
		return this.oiCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oiFdrCurrCd
	 */
	public String getOiFdrCurrCd() {
		return this.oiFdrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oiFnlFrtRtAmt
	 */
	public String getOiFnlFrtRtAmt() {
		return this.oiFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cmPrcCmdtDefCd
	 */
	public String getCmPrcCmdtDefCd() {
		return this.cmPrcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return dryCgoFlg
	 */
	public String getDryCgoFlg() {
		return this.dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return bqPorApplFlg
	 */
	public String getBqPorApplFlg() {
		return this.bqPorApplFlg;
	}
	
	/**
	 * Column Info
	 * @return orgTrspModCd
	 */
	public String getOrgTrspModCd() {
		return this.orgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return diPrcCgoTpCd
	 */
	public String getDiPrcCgoTpCd() {
		return this.diPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return porMtchFlg
	 */
	public String getPorMtchFlg() {
		return this.porMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return rtDeTermCd
	 */
	public String getRtDeTermCd() {
		return this.rtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return dtl
	 */
	public String getDtl() {
		return this.dtl;
	}
	
	/**
	 * Column Info
	 * @return bqPolApplFlg
	 */
	public String getBqPolApplFlg() {
		return this.bqPolApplFlg;
	}
	
	/**
	 * Column Info
	 * @return cgoCateCd
	 */
	public String getCgoCateCd() {
		return this.cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return destTrspModCd
	 */
	public String getDestTrspModCd() {
		return this.destTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasRtOpCd
	 */
	public String getRtRasRtOpCd() {
		return this.rtRasRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return rtMtchPattCd
	 */
	public String getRtMtchPattCd() {
		return this.rtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @return prcGenSpclRtTpCd
	 */
	public String getPrcGenSpclRtTpCd() {
		return this.prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return daCurrCd
	 */
	public String getDaCurrCd() {
		return this.daCurrCd;
	}
	
	/**
	 * Column Info
	 * @return diFnlFrtRtAmt
	 */
	public String getDiFnlFrtRtAmt() {
		return this.diFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvRuleCd
	 */
	public String getRtAppNoteConvRuleCd() {
		return this.rtAppNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return inGaFlg
	 */
	public String getInGaFlg() {
		return this.inGaFlg;
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
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return oiPrcCgoTpCd
	 */
	public String getOiPrcCgoTpCd() {
		return this.oiPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return diRoutPntLocDefCd
	 */
	public String getDiRoutPntLocDefCd() {
		return this.diRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return diFnlFdrRtAmt
	 */
	public String getDiFnlFdrRtAmt() {
		return this.diFnlFdrRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRapConvCtnt
	 */
	public String getRtRapConvCtnt() {
		return this.rtRapConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return prcRtMtchPattCd
	 */
	public String getPrcRtMtchPattCd() {
		return this.prcRtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @return oiAddChgSeq
	 */
	public String getOiAddChgSeq() {
		return this.oiAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return bqPstRlyPortApplFlg
	 */
	public String getBqPstRlyPortApplFlg() {
		return this.bqPstRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @return dpRoutPntLocDefCd
	 */
	public String getDpRoutPntLocDefCd() {
		return this.dpRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return daPrcTrspModCd
	 */
	public String getDaPrcTrspModCd() {
		return this.daPrcTrspModCd;
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
	 * @return oiRcvDeTermCd
	 */
	public String getOiRcvDeTermCd() {
		return this.oiRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return dihFlg
	 */
	public String getDihFlg() {
		return this.dihFlg;
	}
	
	/**
	 * Column Info
	 * @return rtAppCurrCd
	 */
	public String getRtAppCurrCd() {
		return this.rtAppCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasNoteConvSeq
	 */
	public String getRtRasNoteConvSeq() {
		return this.rtRasNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return oaRoutPntLocDefCd
	 */
	public String getOaRoutPntLocDefCd() {
		return this.oaRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return oaRatUtCd
	 */
	public String getOaRatUtCd() {
		return this.oaRatUtCd;
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
	 * @return rtFnlFrtRtAmt
	 */
	public String getRtFnlFrtRtAmt() {
		return this.rtFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return dvRoutViaPortDefCd
	 */
	public String getDvRoutViaPortDefCd() {
		return this.dvRoutViaPortDefCd;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return rtRasFrtRtAmt
	 */
	public String getRtRasFrtRtAmt() {
		return this.rtRasFrtRtAmt;
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
	 * @return rtRasNoteConvMapgId
	 */
	public String getRtRasNoteConvMapgId() {
		return this.rtRasNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return rtTypConvCtnt
	 */
	public String getRtTypConvCtnt() {
		return this.rtTypConvCtnt;
	}
	
	/**
	 * Column Info
	 * @return diBsePortDefCd
	 */
	public String getDiBsePortDefCd() {
		return this.diBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return daBsePortDefCd
	 */
	public String getDaBsePortDefCd() {
		return this.daBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppNoteConvTpCd
	 */
	public String getRtAppNoteConvTpCd() {
		return this.rtAppNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCntrTpszCd
	 */
	public String getCtrtCntrTpszCd() {
		return this.ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return prcRoutSeq
	 */
	public String getPrcRoutSeq() {
		return this.prcRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return oiPrcTrspModCd
	 */
	public String getOiPrcTrspModCd() {
		return this.oiPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return oaMaxCgoWgt
	 */
	public String getOaMaxCgoWgt() {
		return this.oaMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return delMtchFlg
	 */
	public String getDelMtchFlg() {
		return this.delMtchFlg;
	}
	
	/**
	 * Column Info
	 * @return oiBsePortDefCd
	 */
	public String getOiBsePortDefCd() {
		return this.oiBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return opRoutPntLocDefCd
	 */
	public String getOpRoutPntLocDefCd() {
		return this.opRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return frtInclXcldDivCd
	 */
	public String getFrtInclXcldDivCd() {
		return this.frtInclXcldDivCd;
	}
	
	/**
	 * Column Info
	 * @return eqSubstCntrTpszCd
	 */
	public String getEqSubstCntrTpszCd() {
		return this.eqSubstCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return oiViaPortDefCd
	 */
	public String getOiViaPortDefCd() {
		return this.oiViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgBqSeq
	 */
	public String getBkgBqSeq() {
		return this.bkgBqSeq;
	}
	
	/**
	 * Column Info
	 * @return trnsModCd
	 */
	public String getTrnsModCd() {
		return this.trnsModCd;
	}
	
	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRatUtCd
	 */
	public String getRtRatUtCd() {
		return this.rtRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return diViaPortDefCd
	 */
	public String getDiViaPortDefCd() {
		return this.diViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtAppFrtRtAmt
	 */
	public String getRtAppFrtRtAmt() {
		return this.rtAppFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtAppRtOpCd
	 */
	public String getRtAppRtOpCd() {
		return this.rtAppRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return rtroFlg
	 */
	public String getRtroFlg() {
		return this.rtroFlg;
	}
	

	/**
	 * Column Info
	 * @param rtRcvTermCd
	 */
	public void setRtRcvTermCd(String rtRcvTermCd) {
		this.rtRcvTermCd = rtRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param daCalcFrtRtAmt
	 */
	public void setDaCalcFrtRtAmt(String daCalcFrtRtAmt) {
		this.daCalcFrtRtAmt = daCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param oaRacConvCtnt
	 */
	public void setOaRacConvCtnt(String oaRacConvCtnt) {
		this.oaRacConvCtnt = oaRacConvCtnt;
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
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param oaPrcTrspModCd
	 */
	public void setOaPrcTrspModCd(String oaPrcTrspModCd) {
		this.oaPrcTrspModCd = oaPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param diPrcTrspModCd
	 */
	public void setDiPrcTrspModCd(String diPrcTrspModCd) {
		this.diPrcTrspModCd = diPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param mstRfaRoutId
	 */
	public void setMstRfaRoutId(String mstRfaRoutId) {
		this.mstRfaRoutId = mstRfaRoutId;
	}
	
	/**
	 * Column Info
	 * @param daAddChgSeq
	 */
	public void setDaAddChgSeq(String daAddChgSeq) {
		this.daAddChgSeq = daAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param oiFnlFdrRtAmt
	 */
	public void setOiFnlFdrRtAmt(String oiFnlFdrRtAmt) {
		this.oiFnlFdrRtAmt = oiFnlFdrRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diFdrRcvDeTermCd
	 */
	public void setDiFdrRcvDeTermCd(String diFdrRcvDeTermCd) {
		this.diFdrRcvDeTermCd = diFdrRcvDeTermCd;
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
	 * @param oaRcvDeTermCd
	 */
	public void setOaRcvDeTermCd(String oaRcvDeTermCd) {
		this.oaRcvDeTermCd = oaRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param diFnlIhcRtAmt
	 */
	public void setDiFnlIhcRtAmt(String diFnlIhcRtAmt) {
		this.diFnlIhcRtAmt = diFnlIhcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRasConvCtnt
	 */
	public void setRtRasConvCtnt(String rtRasConvCtnt) {
		this.rtRasConvCtnt = rtRasConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param oaPrcCgoTpCd
	 */
	public void setOaPrcCgoTpCd(String oaPrcCgoTpCd) {
		this.oaPrcCgoTpCd = oaPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param oiFnlIhcRtAmt
	 */
	public void setOiFnlIhcRtAmt(String oiFnlIhcRtAmt) {
		this.oiFnlIhcRtAmt = oiFnlIhcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param daRacConvCtnt
	 */
	public void setDaRacConvCtnt(String daRacConvCtnt) {
		this.daRacConvCtnt = daRacConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param ovRoutViaPortDefCd
	 */
	public void setOvRoutViaPortDefCd(String ovRoutViaPortDefCd) {
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param oiRoutPntLocDefCd
	 */
	public void setOiRoutPntLocDefCd(String oiRoutPntLocDefCd) {
		this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param daMaxCgoWgt
	 */
	public void setDaMaxCgoWgt(String daMaxCgoWgt) {
		this.daMaxCgoWgt = daMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param oaCurrCd
	 */
	public void setOaCurrCd(String oaCurrCd) {
		this.oaCurrCd = oaCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oihFlg
	 */
	public void setOihFlg(String oihFlg) {
		this.oihFlg = oihFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param daFnlFrtRtAmt
	 */
	public void setDaFnlFrtRtAmt(String daFnlFrtRtAmt) {
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param bqPodApplFlg
	 */
	public void setBqPodApplFlg(String bqPodApplFlg) {
		this.bqPodApplFlg = bqPodApplFlg;
	}
	
	/**
	 * Column Info
	 * @param bqSeq
	 */
	public void setBqSeq(String bqSeq) {
		this.bqSeq = bqSeq;
	}
	
	/**
	 * Column Info
	 * @param rtAppBkgConvTpCd
	 */
	public void setRtAppBkgConvTpCd(String rtAppBkgConvTpCd) {
		this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param dpPrcTrspModCd
	 */
	public void setDpPrcTrspModCd(String dpPrcTrspModCd) {
		this.dpPrcTrspModCd = dpPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param opPrcTrspModCd
	 */
	public void setOpPrcTrspModCd(String opPrcTrspModCd) {
		this.opPrcTrspModCd = opPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param diCalcFrtRtAmt
	 */
	public void setDiCalcFrtRtAmt(String diCalcFrtRtAmt) {
		this.diCalcFrtRtAmt = diCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param diRcvDeTermCd
	 */
	public void setDiRcvDeTermCd(String diRcvDeTermCd) {
		this.diRcvDeTermCd = diRcvDeTermCd;
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
	 * @param oftCmbSeq
	 */
	public void setOftCmbSeq(String oftCmbSeq) {
		this.oftCmbSeq = oftCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param diRatUtCd
	 */
	public void setDiRatUtCd(String diRatUtCd) {
		this.diRatUtCd = diRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param daRatUtCd
	 */
	public void setDaRatUtCd(String daRatUtCd) {
		this.daRatUtCd = daRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param oaFnlFrtRtAmt
	 */
	public void setOaFnlFrtRtAmt(String oaFnlFrtRtAmt) {
		this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
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
	 * @param cmPrcCmdtTpCd
	 */
	public void setCmPrcCmdtTpCd(String cmPrcCmdtTpCd) {
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcRtSeq
	 */
	public void setPrcRtSeq(String prcRtSeq) {
		this.prcRtSeq = prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @param rtCalcFrtRtAmt
	 */
	public void setRtCalcFrtRtAmt(String rtCalcFrtRtAmt) {
		this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvMapgId
	 */
	public void setRtAppNoteConvMapgId(String rtAppNoteConvMapgId) {
		this.rtAppNoteConvMapgId = rtAppNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param diCurrCd
	 */
	public void setDiCurrCd(String diCurrCd) {
		this.diCurrCd = diCurrCd;
	}
	
	/**
	 * Column Info
	 * @param diFdrCurrCd
	 */
	public void setDiFdrCurrCd(String diFdrCurrCd) {
		this.diFdrCurrCd = diFdrCurrCd;
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
	 * @param rtRasBkgConvTpCd
	 */
	public void setRtRasBkgConvTpCd(String rtRasBkgConvTpCd) {
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
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
	 * @param rtRarConvCtnt
	 */
	public void setRtRarConvCtnt(String rtRarConvCtnt) {
		this.rtRarConvCtnt = rtRarConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param rtRacConvCtnt
	 */
	public void setRtRacConvCtnt(String rtRacConvCtnt) {
		this.rtRacConvCtnt = rtRacConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param oiRatUtCd
	 */
	public void setOiRatUtCd(String oiRatUtCd) {
		this.oiRatUtCd = oiRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param daPrcCgoTpCd
	 */
	public void setDaPrcCgoTpCd(String daPrcCgoTpCd) {
		this.daPrcCgoTpCd = daPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtHdrSeq
	 */
	public void setPrcCmdtHdrSeq(String prcCmdtHdrSeq) {
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param oaCalcFrtRtAmt
	 */
	public void setOaCalcFrtRtAmt(String oaCalcFrtRtAmt) {
		this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvRuleCd
	 */
	public void setRtRasNoteConvRuleCd(String rtRasNoteConvRuleCd) {
		this.rtRasNoteConvRuleCd = rtRasNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasCurrCd
	 */
	public void setRtRasCurrCd(String rtRasCurrCd) {
		this.rtRasCurrCd = rtRasCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvSeq
	 */
	public void setRtAppNoteConvSeq(String rtAppNoteConvSeq) {
		this.rtAppNoteConvSeq = rtAppNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param oiFdrRcvDeTermCd
	 */
	public void setOiFdrRcvDeTermCd(String oiFdrRcvDeTermCd) {
		this.oiFdrRcvDeTermCd = oiFdrRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvTpCd
	 */
	public void setRtRasNoteConvTpCd(String rtRasNoteConvTpCd) {
		this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtPrcCgoTpCd
	 */
	public void setRtPrcCgoTpCd(String rtPrcCgoTpCd) {
		this.rtPrcCgoTpCd = rtPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtDorConvCtnt
	 */
	public void setRtDorConvCtnt(String rtDorConvCtnt) {
		this.rtDorConvCtnt = rtDorConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param oaAddChgSeq
	 */
	public void setOaAddChgSeq(String oaAddChgSeq) {
		this.oaAddChgSeq = oaAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * Column Info
	 * @param oaMinCgoWgt
	 */
	public void setOaMinCgoWgt(String oaMinCgoWgt) {
		this.oaMinCgoWgt = oaMinCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param daTypConvCtnt
	 */
	public void setDaTypConvCtnt(String daTypConvCtnt) {
		this.daTypConvCtnt = daTypConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param bkgBqOccrSeq
	 */
	public void setBkgBqOccrSeq(String bkgBqOccrSeq) {
		this.bkgBqOccrSeq = bkgBqOccrSeq;
	}
	
	/**
	 * Column Info
	 * @param bqDelApplFlg
	 */
	public void setBqDelApplFlg(String bqDelApplFlg) {
		this.bqDelApplFlg = bqDelApplFlg;
	}
	
	/**
	 * Column Info
	 * @param daRcvDeTermCd
	 */
	public void setDaRcvDeTermCd(String daRcvDeTermCd) {
		this.daRcvDeTermCd = daRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param calcCtrtTpCd
	 */
	public void setCalcCtrtTpCd(String calcCtrtTpCd) {
		this.calcCtrtTpCd = calcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param oiCalcFrtRtAmt
	 */
	public void setOiCalcFrtRtAmt(String oiCalcFrtRtAmt) {
		this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param daMinCgoWgt
	 */
	public void setDaMinCgoWgt(String daMinCgoWgt) {
		this.daMinCgoWgt = daMinCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param inclOftFlg
	 */
	public void setInclOftFlg(String inclOftFlg) {
		this.inclOftFlg = inclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param oaTypConvCtnt
	 */
	public void setOaTypConvCtnt(String oaTypConvCtnt) {
		this.oaTypConvCtnt = oaTypConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param diAddChgSeq
	 */
	public void setDiAddChgSeq(String diAddChgSeq) {
		this.diAddChgSeq = diAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param bqPorRlyPortApplFlg
	 */
	public void setBqPorRlyPortApplFlg(String bqPorRlyPortApplFlg) {
		this.bqPorRlyPortApplFlg = bqPorRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @param daRoutPntLocDefCd
	 */
	public void setDaRoutPntLocDefCd(String daRoutPntLocDefCd) {
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtCurrCd
	 */
	public void setRtCurrCd(String rtCurrCd) {
		this.rtCurrCd = rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oaBsePortDefCd
	 */
	public void setOaBsePortDefCd(String oaBsePortDefCd) {
		this.oaBsePortDefCd = oaBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param prcHngrBarTpCd
	 */
	public void setPrcHngrBarTpCd(String prcHngrBarTpCd) {
		this.prcHngrBarTpCd = prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param oiCurrCd
	 */
	public void setOiCurrCd(String oiCurrCd) {
		this.oiCurrCd = oiCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oiFdrCurrCd
	 */
	public void setOiFdrCurrCd(String oiFdrCurrCd) {
		this.oiFdrCurrCd = oiFdrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oiFnlFrtRtAmt
	 */
	public void setOiFnlFrtRtAmt(String oiFnlFrtRtAmt) {
		this.oiFnlFrtRtAmt = oiFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cmPrcCmdtDefCd
	 */
	public void setCmPrcCmdtDefCd(String cmPrcCmdtDefCd) {
		this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param dryCgoFlg
	 */
	public void setDryCgoFlg(String dryCgoFlg) {
		this.dryCgoFlg = dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param bqPorApplFlg
	 */
	public void setBqPorApplFlg(String bqPorApplFlg) {
		this.bqPorApplFlg = bqPorApplFlg;
	}
	
	/**
	 * Column Info
	 * @param orgTrspModCd
	 */
	public void setOrgTrspModCd(String orgTrspModCd) {
		this.orgTrspModCd = orgTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param diPrcCgoTpCd
	 */
	public void setDiPrcCgoTpCd(String diPrcCgoTpCd) {
		this.diPrcCgoTpCd = diPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param porMtchFlg
	 */
	public void setPorMtchFlg(String porMtchFlg) {
		this.porMtchFlg = porMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param rtDeTermCd
	 */
	public void setRtDeTermCd(String rtDeTermCd) {
		this.rtDeTermCd = rtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param dtl
	 */
	public void setDtl(String dtl) {
		this.dtl = dtl;
	}
	
	/**
	 * Column Info
	 * @param bqPolApplFlg
	 */
	public void setBqPolApplFlg(String bqPolApplFlg) {
		this.bqPolApplFlg = bqPolApplFlg;
	}
	
	/**
	 * Column Info
	 * @param cgoCateCd
	 */
	public void setCgoCateCd(String cgoCateCd) {
		this.cgoCateCd = cgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param destTrspModCd
	 */
	public void setDestTrspModCd(String destTrspModCd) {
		this.destTrspModCd = destTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasRtOpCd
	 */
	public void setRtRasRtOpCd(String rtRasRtOpCd) {
		this.rtRasRtOpCd = rtRasRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param rtMtchPattCd
	 */
	public void setRtMtchPattCd(String rtMtchPattCd) {
		this.rtMtchPattCd = rtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @param prcGenSpclRtTpCd
	 */
	public void setPrcGenSpclRtTpCd(String prcGenSpclRtTpCd) {
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param daCurrCd
	 */
	public void setDaCurrCd(String daCurrCd) {
		this.daCurrCd = daCurrCd;
	}
	
	/**
	 * Column Info
	 * @param diFnlFrtRtAmt
	 */
	public void setDiFnlFrtRtAmt(String diFnlFrtRtAmt) {
		this.diFnlFrtRtAmt = diFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvRuleCd
	 */
	public void setRtAppNoteConvRuleCd(String rtAppNoteConvRuleCd) {
		this.rtAppNoteConvRuleCd = rtAppNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param inGaFlg
	 */
	public void setInGaFlg(String inGaFlg) {
		this.inGaFlg = inGaFlg;
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
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param oiPrcCgoTpCd
	 */
	public void setOiPrcCgoTpCd(String oiPrcCgoTpCd) {
		this.oiPrcCgoTpCd = oiPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param diRoutPntLocDefCd
	 */
	public void setDiRoutPntLocDefCd(String diRoutPntLocDefCd) {
		this.diRoutPntLocDefCd = diRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param diFnlFdrRtAmt
	 */
	public void setDiFnlFdrRtAmt(String diFnlFdrRtAmt) {
		this.diFnlFdrRtAmt = diFnlFdrRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRapConvCtnt
	 */
	public void setRtRapConvCtnt(String rtRapConvCtnt) {
		this.rtRapConvCtnt = rtRapConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param prcRtMtchPattCd
	 */
	public void setPrcRtMtchPattCd(String prcRtMtchPattCd) {
		this.prcRtMtchPattCd = prcRtMtchPattCd;
	}
	
	/**
	 * Column Info
	 * @param oiAddChgSeq
	 */
	public void setOiAddChgSeq(String oiAddChgSeq) {
		this.oiAddChgSeq = oiAddChgSeq;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param bqPstRlyPortApplFlg
	 */
	public void setBqPstRlyPortApplFlg(String bqPstRlyPortApplFlg) {
		this.bqPstRlyPortApplFlg = bqPstRlyPortApplFlg;
	}
	
	/**
	 * Column Info
	 * @param dpRoutPntLocDefCd
	 */
	public void setDpRoutPntLocDefCd(String dpRoutPntLocDefCd) {
		this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param daPrcTrspModCd
	 */
	public void setDaPrcTrspModCd(String daPrcTrspModCd) {
		this.daPrcTrspModCd = daPrcTrspModCd;
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
	 * @param oiRcvDeTermCd
	 */
	public void setOiRcvDeTermCd(String oiRcvDeTermCd) {
		this.oiRcvDeTermCd = oiRcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param dihFlg
	 */
	public void setDihFlg(String dihFlg) {
		this.dihFlg = dihFlg;
	}
	
	/**
	 * Column Info
	 * @param rtAppCurrCd
	 */
	public void setRtAppCurrCd(String rtAppCurrCd) {
		this.rtAppCurrCd = rtAppCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasNoteConvSeq
	 */
	public void setRtRasNoteConvSeq(String rtRasNoteConvSeq) {
		this.rtRasNoteConvSeq = rtRasNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param oaRoutPntLocDefCd
	 */
	public void setOaRoutPntLocDefCd(String oaRoutPntLocDefCd) {
		this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param oaRatUtCd
	 */
	public void setOaRatUtCd(String oaRatUtCd) {
		this.oaRatUtCd = oaRatUtCd;
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
	 * @param rtFnlFrtRtAmt
	 */
	public void setRtFnlFrtRtAmt(String rtFnlFrtRtAmt) {
		this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param dvRoutViaPortDefCd
	 */
	public void setDvRoutViaPortDefCd(String dvRoutViaPortDefCd) {
		this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param rtRasFrtRtAmt
	 */
	public void setRtRasFrtRtAmt(String rtRasFrtRtAmt) {
		this.rtRasFrtRtAmt = rtRasFrtRtAmt;
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
	 * @param rtRasNoteConvMapgId
	 */
	public void setRtRasNoteConvMapgId(String rtRasNoteConvMapgId) {
		this.rtRasNoteConvMapgId = rtRasNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param rtTypConvCtnt
	 */
	public void setRtTypConvCtnt(String rtTypConvCtnt) {
		this.rtTypConvCtnt = rtTypConvCtnt;
	}
	
	/**
	 * Column Info
	 * @param diBsePortDefCd
	 */
	public void setDiBsePortDefCd(String diBsePortDefCd) {
		this.diBsePortDefCd = diBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param daBsePortDefCd
	 */
	public void setDaBsePortDefCd(String daBsePortDefCd) {
		this.daBsePortDefCd = daBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppNoteConvTpCd
	 */
	public void setRtAppNoteConvTpCd(String rtAppNoteConvTpCd) {
		this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCntrTpszCd
	 */
	public void setCtrtCntrTpszCd(String ctrtCntrTpszCd) {
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param prcRoutSeq
	 */
	public void setPrcRoutSeq(String prcRoutSeq) {
		this.prcRoutSeq = prcRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param oiPrcTrspModCd
	 */
	public void setOiPrcTrspModCd(String oiPrcTrspModCd) {
		this.oiPrcTrspModCd = oiPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param oaMaxCgoWgt
	 */
	public void setOaMaxCgoWgt(String oaMaxCgoWgt) {
		this.oaMaxCgoWgt = oaMaxCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param delMtchFlg
	 */
	public void setDelMtchFlg(String delMtchFlg) {
		this.delMtchFlg = delMtchFlg;
	}
	
	/**
	 * Column Info
	 * @param oiBsePortDefCd
	 */
	public void setOiBsePortDefCd(String oiBsePortDefCd) {
		this.oiBsePortDefCd = oiBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param opRoutPntLocDefCd
	 */
	public void setOpRoutPntLocDefCd(String opRoutPntLocDefCd) {
		this.opRoutPntLocDefCd = opRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param frtInclXcldDivCd
	 */
	public void setFrtInclXcldDivCd(String frtInclXcldDivCd) {
		this.frtInclXcldDivCd = frtInclXcldDivCd;
	}
	
	/**
	 * Column Info
	 * @param eqSubstCntrTpszCd
	 */
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param oiViaPortDefCd
	 */
	public void setOiViaPortDefCd(String oiViaPortDefCd) {
		this.oiViaPortDefCd = oiViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgBqSeq
	 */
	public void setBkgBqSeq(String bkgBqSeq) {
		this.bkgBqSeq = bkgBqSeq;
	}
	
	/**
	 * Column Info
	 * @param trnsModCd
	 */
	public void setTrnsModCd(String trnsModCd) {
		this.trnsModCd = trnsModCd;
	}
	
	/**
	 * Column Info
	 * @param frtRtAmt
	 */
	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRatUtCd
	 */
	public void setRtRatUtCd(String rtRatUtCd) {
		this.rtRatUtCd = rtRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param diViaPortDefCd
	 */
	public void setDiViaPortDefCd(String diViaPortDefCd) {
		this.diViaPortDefCd = diViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtAppFrtRtAmt
	 */
	public void setRtAppFrtRtAmt(String rtAppFrtRtAmt) {
		this.rtAppFrtRtAmt = rtAppFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtAppRtOpCd
	 */
	public void setRtAppRtOpCd(String rtAppRtOpCd) {
		this.rtAppRtOpCd = rtAppRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param rtroFlg
	 */
	public void setRtroFlg(String rtroFlg) {
		this.rtroFlg = rtroFlg;
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
		setRtRcvTermCd(JSPUtil.getParameter(request, prefix + "rt_rcv_term_cd", ""));
		setDaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_calc_frt_rt_amt", ""));
		setOaRacConvCtnt(JSPUtil.getParameter(request, prefix + "oa_rac_conv_ctnt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setOaPrcTrspModCd(JSPUtil.getParameter(request, prefix + "oa_prc_trsp_mod_cd", ""));
		setDiPrcTrspModCd(JSPUtil.getParameter(request, prefix + "di_prc_trsp_mod_cd", ""));
		setDaAddChgSeq(JSPUtil.getParameter(request, prefix + "da_add_chg_seq", ""));
		setOiFnlFdrRtAmt(JSPUtil.getParameter(request, prefix + "oi_fnl_fdr_rt_amt", ""));
		setDiFdrRcvDeTermCd(JSPUtil.getParameter(request, prefix + "di_fdr_rcv_de_term_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOaRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oa_rcv_de_term_cd", ""));
		setDiFnlIhcRtAmt(JSPUtil.getParameter(request, prefix + "di_fnl_ihc_rt_amt", ""));
		setRtRasConvCtnt(JSPUtil.getParameter(request, prefix + "rt_ras_conv_ctnt", ""));
		setOaPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "oa_prc_cgo_tp_cd", ""));
		setOiFnlIhcRtAmt(JSPUtil.getParameter(request, prefix + "oi_fnl_ihc_rt_amt", ""));
		setDaRacConvCtnt(JSPUtil.getParameter(request, prefix + "da_rac_conv_ctnt", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setOvRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "ov_rout_via_port_def_cd", ""));
		setOiRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "oi_rout_pnt_loc_def_cd", ""));
		setDaMaxCgoWgt(JSPUtil.getParameter(request, prefix + "da_max_cgo_wgt", ""));
		setOaCurrCd(JSPUtil.getParameter(request, prefix + "oa_curr_cd", ""));
		setOihFlg(JSPUtil.getParameter(request, prefix + "oih_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setDaFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_fnl_frt_rt_amt", ""));
		setBqPodApplFlg(JSPUtil.getParameter(request, prefix + "bq_pod_appl_flg", ""));
		setBqSeq(JSPUtil.getParameter(request, prefix + "bq_seq", ""));
		setRtAppBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_app_bkg_conv_tp_cd", ""));
		setDpPrcTrspModCd(JSPUtil.getParameter(request, prefix + "dp_prc_trsp_mod_cd", ""));
		setOpPrcTrspModCd(JSPUtil.getParameter(request, prefix + "op_prc_trsp_mod_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setDiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_calc_frt_rt_amt", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setDiRcvDeTermCd(JSPUtil.getParameter(request, prefix + "di_rcv_de_term_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOftCmbSeq(JSPUtil.getParameter(request, prefix + "oft_cmb_seq", ""));
		setDiRatUtCd(JSPUtil.getParameter(request, prefix + "di_rat_ut_cd", ""));
		setDaRatUtCd(JSPUtil.getParameter(request, prefix + "da_rat_ut_cd", ""));
		setOaFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_fnl_frt_rt_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCmPrcCmdtTpCd(JSPUtil.getParameter(request, prefix + "cm_prc_cmdt_tp_cd", ""));
		setPrcRtSeq(JSPUtil.getParameter(request, prefix + "prc_rt_seq", ""));
		setRtCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_calc_frt_rt_amt", ""));
		setRtAppNoteConvMapgId(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_mapg_id", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setDiCurrCd(JSPUtil.getParameter(request, prefix + "di_curr_cd", ""));
		setDiFdrCurrCd(JSPUtil.getParameter(request, prefix + "di_fdr_curr_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setRtRasBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_ras_bkg_conv_tp_cd", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setRtRarConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rar_conv_ctnt", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setRtRacConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rac_conv_ctnt", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setOiRatUtCd(JSPUtil.getParameter(request, prefix + "oi_rat_ut_cd", ""));
		setDaPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "da_prc_cgo_tp_cd", ""));
		setPrcCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "prc_cmdt_hdr_seq", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setOaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_calc_frt_rt_amt", ""));
		setRtRasNoteConvRuleCd(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_rule_cd", ""));
		setRtRasCurrCd(JSPUtil.getParameter(request, prefix + "rt_ras_curr_cd", ""));
		setRtAppNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_seq", ""));
		setOiFdrRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oi_fdr_rcv_de_term_cd", ""));
		setRtRasNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_tp_cd", ""));
		setRtPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "rt_prc_cgo_tp_cd", ""));
		setRtDorConvCtnt(JSPUtil.getParameter(request, prefix + "rt_dor_conv_ctnt", ""));
		setOaAddChgSeq(JSPUtil.getParameter(request, prefix + "oa_add_chg_seq", ""));
		setNote(JSPUtil.getParameter(request, prefix + "note", ""));
		setOaMinCgoWgt(JSPUtil.getParameter(request, prefix + "oa_min_cgo_wgt", ""));
		setDaTypConvCtnt(JSPUtil.getParameter(request, prefix + "da_typ_conv_ctnt", ""));
		setBkgBqOccrSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_occr_seq", ""));
		setBqDelApplFlg(JSPUtil.getParameter(request, prefix + "bq_del_appl_flg", ""));
		setDaRcvDeTermCd(JSPUtil.getParameter(request, prefix + "da_rcv_de_term_cd", ""));
		setCalcCtrtTpCd(JSPUtil.getParameter(request, prefix + "calc_ctrt_tp_cd", ""));
		setOiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_calc_frt_rt_amt", ""));
		setDaMinCgoWgt(JSPUtil.getParameter(request, prefix + "da_min_cgo_wgt", ""));
		setInclOftFlg(JSPUtil.getParameter(request, prefix + "incl_oft_flg", ""));
		setOaTypConvCtnt(JSPUtil.getParameter(request, prefix + "oa_typ_conv_ctnt", ""));
		setDiAddChgSeq(JSPUtil.getParameter(request, prefix + "di_add_chg_seq", ""));
		setBqPorRlyPortApplFlg(JSPUtil.getParameter(request, prefix + "bq_por_rly_port_appl_flg", ""));
		setDaRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "da_rout_pnt_loc_def_cd", ""));
		setRtCurrCd(JSPUtil.getParameter(request, prefix + "rt_curr_cd", ""));
		setOaBsePortDefCd(JSPUtil.getParameter(request, prefix + "oa_bse_port_def_cd", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setOiCurrCd(JSPUtil.getParameter(request, prefix + "oi_curr_cd", ""));
		setOiFdrCurrCd(JSPUtil.getParameter(request, prefix + "oi_fdr_curr_cd", ""));
		setOiFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_fnl_frt_rt_amt", ""));
		setCmPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "cm_prc_cmdt_def_cd", ""));
		setDryCgoFlg(JSPUtil.getParameter(request, prefix + "dry_cgo_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setBqPorApplFlg(JSPUtil.getParameter(request, prefix + "bq_por_appl_flg", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request, prefix + "org_trsp_mod_cd", ""));
		setDiPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "di_prc_cgo_tp_cd", ""));
		setPorMtchFlg(JSPUtil.getParameter(request, prefix + "por_mtch_flg", ""));
		setRtDeTermCd(JSPUtil.getParameter(request, prefix + "rt_de_term_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDtl(JSPUtil.getParameter(request, prefix + "dtl", ""));
		setBqPolApplFlg(JSPUtil.getParameter(request, prefix + "bq_pol_appl_flg", ""));
		setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
		setDestTrspModCd(JSPUtil.getParameter(request, prefix + "dest_trsp_mod_cd", ""));
		setRtRasRtOpCd(JSPUtil.getParameter(request, prefix + "rt_ras_rt_op_cd", ""));
		setRtMtchPattCd(JSPUtil.getParameter(request, prefix + "rt_mtch_patt_cd", ""));
		setPrcGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "prc_gen_spcl_rt_tp_cd", ""));
		setDaCurrCd(JSPUtil.getParameter(request, prefix + "da_curr_cd", ""));
		setDiFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_fnl_frt_rt_amt", ""));
		setRtAppNoteConvRuleCd(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_rule_cd", ""));
		setInGaFlg(JSPUtil.getParameter(request, prefix + "in_ga_flg", ""));
		setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setOiPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "oi_prc_cgo_tp_cd", ""));
		setDiRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "di_rout_pnt_loc_def_cd", ""));
		setDiFnlFdrRtAmt(JSPUtil.getParameter(request, prefix + "di_fnl_fdr_rt_amt", ""));
		setRtRapConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rap_conv_ctnt", ""));
		setPrcRtMtchPattCd(JSPUtil.getParameter(request, prefix + "prc_rt_mtch_patt_cd", ""));
		setOiAddChgSeq(JSPUtil.getParameter(request, prefix + "oi_add_chg_seq", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setBqPstRlyPortApplFlg(JSPUtil.getParameter(request, prefix + "bq_pst_rly_port_appl_flg", ""));
		setDpRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dp_rout_pnt_loc_def_cd", ""));
		setDaPrcTrspModCd(JSPUtil.getParameter(request, prefix + "da_prc_trsp_mod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setOiRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oi_rcv_de_term_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDihFlg(JSPUtil.getParameter(request, prefix + "dih_flg", ""));
		setRtAppCurrCd(JSPUtil.getParameter(request, prefix + "rt_app_curr_cd", ""));
		setRtRasNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_seq", ""));
		setOaRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "oa_rout_pnt_loc_def_cd", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setOaRatUtCd(JSPUtil.getParameter(request, prefix + "oa_rat_ut_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_fnl_frt_rt_amt", ""));
		setDvRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dv_rout_via_port_def_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setRtRasFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_ras_frt_rt_amt", ""));
		setPorCntCd(JSPUtil.getParameter(request, prefix + "por_cnt_cd", ""));
		setRtRasNoteConvMapgId(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_mapg_id", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setRtTypConvCtnt(JSPUtil.getParameter(request, prefix + "rt_typ_conv_ctnt", ""));
		setDiBsePortDefCd(JSPUtil.getParameter(request, prefix + "di_bse_port_def_cd", ""));
		setDaBsePortDefCd(JSPUtil.getParameter(request, prefix + "da_bse_port_def_cd", ""));
		setRtAppNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_tp_cd", ""));
		setCtrtCntrTpszCd(JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd", ""));
		setPrcRoutSeq(JSPUtil.getParameter(request, prefix + "prc_rout_seq", ""));
		setOiPrcTrspModCd(JSPUtil.getParameter(request, prefix + "oi_prc_trsp_mod_cd", ""));
		setOaMaxCgoWgt(JSPUtil.getParameter(request, prefix + "oa_max_cgo_wgt", ""));
		setDelMtchFlg(JSPUtil.getParameter(request, prefix + "del_mtch_flg", ""));
		setOiBsePortDefCd(JSPUtil.getParameter(request, prefix + "oi_bse_port_def_cd", ""));
		setOpRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "op_rout_pnt_loc_def_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
		setEqSubstCntrTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", ""));
		setOiViaPortDefCd(JSPUtil.getParameter(request, prefix + "oi_via_port_def_cd", ""));
		setBkgBqSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_seq", ""));
		setTrnsModCd(JSPUtil.getParameter(request, prefix + "trns_mod_cd", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setRtRatUtCd(JSPUtil.getParameter(request, prefix + "rt_rat_ut_cd", ""));
		setDiViaPortDefCd(JSPUtil.getParameter(request, prefix + "di_via_port_def_cd", ""));
		setRtAppFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_app_frt_rt_amt", ""));
		setRtAppRtOpCd(JSPUtil.getParameter(request, prefix + "rt_app_rt_op_cd", ""));
		setRtroFlg(JSPUtil.getParameter(request, prefix + "rtro_flg", ""));
		setMstRfaRoutId(JSPUtil.getParameter(request, prefix + "mst_rfa_rout_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRfaOftAutoratingListVO[]
	 */
	public SearchRfaOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRfaOftAutoratingListVO[]
	 */
	public SearchRfaOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRfaOftAutoratingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rtRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rt_rcv_term_cd", length));
			String[] daCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_calc_frt_rt_amt", length));
			String[] oaRacConvCtnt = (JSPUtil.getParameter(request, prefix	+ "oa_rac_conv_ctnt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] oaPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_trsp_mod_cd", length));
			String[] diPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_trsp_mod_cd", length));
			String[] daAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "da_add_chg_seq", length));
			String[] oiFnlFdrRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_fnl_fdr_rt_amt", length));
			String[] diFdrRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "di_fdr_rcv_de_term_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oaRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oa_rcv_de_term_cd", length));
			String[] diFnlIhcRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_fnl_ihc_rt_amt", length));
			String[] rtRasConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_ras_conv_ctnt", length));
			String[] oaPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_cgo_tp_cd", length));
			String[] oiFnlIhcRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_fnl_ihc_rt_amt", length));
			String[] daRacConvCtnt = (JSPUtil.getParameter(request, prefix	+ "da_rac_conv_ctnt", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ovRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ov_rout_via_port_def_cd", length));
			String[] oiRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_rout_pnt_loc_def_cd", length));
			String[] daMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "da_max_cgo_wgt", length));
			String[] oaCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_curr_cd", length));
			String[] oihFlg = (JSPUtil.getParameter(request, prefix	+ "oih_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] daFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_fnl_frt_rt_amt", length));
			String[] bqPodApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pod_appl_flg", length));
			String[] bqSeq = (JSPUtil.getParameter(request, prefix	+ "bq_seq", length));
			String[] rtAppBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_bkg_conv_tp_cd", length));
			String[] dpPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dp_prc_trsp_mod_cd", length));
			String[] opPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "op_prc_trsp_mod_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] diCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_calc_frt_rt_amt", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] diRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "di_rcv_de_term_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] oftCmbSeq = (JSPUtil.getParameter(request, prefix	+ "oft_cmb_seq", length));
			String[] diRatUtCd = (JSPUtil.getParameter(request, prefix	+ "di_rat_ut_cd", length));
			String[] daRatUtCd = (JSPUtil.getParameter(request, prefix	+ "da_rat_ut_cd", length));
			String[] oaFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_fnl_frt_rt_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmPrcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_tp_cd", length));
			String[] prcRtSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rt_seq", length));
			String[] rtCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_calc_frt_rt_amt", length));
			String[] rtAppNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_mapg_id", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] diCurrCd = (JSPUtil.getParameter(request, prefix	+ "di_curr_cd", length));
			String[] diFdrCurrCd = (JSPUtil.getParameter(request, prefix	+ "di_fdr_curr_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] rtRasBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_bkg_conv_tp_cd", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rtRarConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_rar_conv_ctnt", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] rtRacConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_rac_conv_ctnt", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] oiRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oi_rat_ut_cd", length));
			String[] daPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_cgo_tp_cd", length));
			String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_hdr_seq", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] oaCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_calc_frt_rt_amt", length));
			String[] rtRasNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_rule_cd", length));
			String[] rtRasCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_curr_cd", length));
			String[] rtAppNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_seq", length));
			String[] oiFdrRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oi_fdr_rcv_de_term_cd", length));
			String[] rtRasNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_tp_cd", length));
			String[] rtPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_prc_cgo_tp_cd", length));
			String[] rtDorConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_dor_conv_ctnt", length));
			String[] oaAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "oa_add_chg_seq", length));
			String[] note = (JSPUtil.getParameter(request, prefix	+ "note", length));
			String[] oaMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oa_min_cgo_wgt", length));
			String[] daTypConvCtnt = (JSPUtil.getParameter(request, prefix	+ "da_typ_conv_ctnt", length));
			String[] bkgBqOccrSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_occr_seq", length));
			String[] bqDelApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_del_appl_flg", length));
			String[] daRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "da_rcv_de_term_cd", length));
			String[] calcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_ctrt_tp_cd", length));
			String[] oiCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_calc_frt_rt_amt", length));
			String[] daMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "da_min_cgo_wgt", length));
			String[] inclOftFlg = (JSPUtil.getParameter(request, prefix	+ "incl_oft_flg", length));
			String[] oaTypConvCtnt = (JSPUtil.getParameter(request, prefix	+ "oa_typ_conv_ctnt", length));
			String[] diAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "di_add_chg_seq", length));
			String[] bqPorRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_rly_port_appl_flg", length));
			String[] daRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "da_rout_pnt_loc_def_cd", length));
			String[] rtCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_curr_cd", length));
			String[] oaBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_bse_port_def_cd", length));
			String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] oiCurrCd = (JSPUtil.getParameter(request, prefix	+ "oi_curr_cd", length));
			String[] oiFdrCurrCd = (JSPUtil.getParameter(request, prefix	+ "oi_fdr_curr_cd", length));
			String[] oiFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_fnl_frt_rt_amt", length));
			String[] cmPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_def_cd", length));
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] bqPorApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_appl_flg", length));
			String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_mod_cd", length));
			String[] diPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_cgo_tp_cd", length));
			String[] porMtchFlg = (JSPUtil.getParameter(request, prefix	+ "por_mtch_flg", length));
			String[] rtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rt_de_term_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dtl = (JSPUtil.getParameter(request, prefix	+ "dtl", length));
			String[] bqPolApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pol_appl_flg", length));
			String[] cgoCateCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cate_cd", length));
			String[] destTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trsp_mod_cd", length));
			String[] rtRasRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_rt_op_cd", length));
			String[] rtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "rt_mtch_patt_cd", length));
			String[] prcGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_gen_spcl_rt_tp_cd", length));
			String[] daCurrCd = (JSPUtil.getParameter(request, prefix	+ "da_curr_cd", length));
			String[] diFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_fnl_frt_rt_amt", length));
			String[] rtAppNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_rule_cd", length));
			String[] inGaFlg = (JSPUtil.getParameter(request, prefix	+ "in_ga_flg", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oiPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_cgo_tp_cd", length));
			String[] diRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "di_rout_pnt_loc_def_cd", length));
			String[] diFnlFdrRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_fnl_fdr_rt_amt", length));
			String[] rtRapConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_rap_conv_ctnt", length));
			String[] prcRtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd", length));
			String[] oiAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "oi_add_chg_seq", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] bqPstRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pst_rly_port_appl_flg", length));
			String[] dpRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dp_rout_pnt_loc_def_cd", length));
			String[] daPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_trsp_mod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] oiRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oi_rcv_de_term_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dihFlg = (JSPUtil.getParameter(request, prefix	+ "dih_flg", length));
			String[] rtAppCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_curr_cd", length));
			String[] rtRasNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_seq", length));
			String[] oaRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_rout_pnt_loc_def_cd", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] oaRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oa_rat_ut_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_fnl_frt_rt_amt", length));
			String[] dvRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dv_rout_via_port_def_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rtRasFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_ras_frt_rt_amt", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] rtRasNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_mapg_id", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] rtTypConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_typ_conv_ctnt", length));
			String[] diBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "di_bse_port_def_cd", length));
			String[] daBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "da_bse_port_def_cd", length));
			String[] rtAppNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_tp_cd", length));
			String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd", length));
			String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rout_seq", length));
			String[] oiPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_trsp_mod_cd", length));
			String[] oaMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oa_max_cgo_wgt", length));
			String[] delMtchFlg = (JSPUtil.getParameter(request, prefix	+ "del_mtch_flg", length));
			String[] oiBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_bse_port_def_cd", length));
			String[] opRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "op_rout_pnt_loc_def_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cntr_tpsz_cd", length));
			String[] oiViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_via_port_def_cd", length));
			String[] bkgBqSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_seq", length));
			String[] trnsModCd = (JSPUtil.getParameter(request, prefix	+ "trns_mod_cd", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] rtRatUtCd = (JSPUtil.getParameter(request, prefix	+ "rt_rat_ut_cd", length));
			String[] diViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "di_via_port_def_cd", length));
			String[] rtAppFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_app_frt_rt_amt", length));
			String[] rtAppRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_rt_op_cd", length));
			String[] rtroFlg = (JSPUtil.getParameter(request, prefix	+ "rtro_flg", length));
			String[] mstRfaRoutId = (JSPUtil.getParameter(request, prefix	+ "mst_rfa_rout_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRfaOftAutoratingListVO();
				if (rtRcvTermCd[i] != null)
					model.setRtRcvTermCd(rtRcvTermCd[i]);
				if (daCalcFrtRtAmt[i] != null)
					model.setDaCalcFrtRtAmt(daCalcFrtRtAmt[i]);
				if (oaRacConvCtnt[i] != null)
					model.setOaRacConvCtnt(oaRacConvCtnt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (oaPrcTrspModCd[i] != null)
					model.setOaPrcTrspModCd(oaPrcTrspModCd[i]);
				if (diPrcTrspModCd[i] != null)
					model.setDiPrcTrspModCd(diPrcTrspModCd[i]);
				if (daAddChgSeq[i] != null)
					model.setDaAddChgSeq(daAddChgSeq[i]);
				if (oiFnlFdrRtAmt[i] != null)
					model.setOiFnlFdrRtAmt(oiFnlFdrRtAmt[i]);
				if (diFdrRcvDeTermCd[i] != null)
					model.setDiFdrRcvDeTermCd(diFdrRcvDeTermCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oaRcvDeTermCd[i] != null)
					model.setOaRcvDeTermCd(oaRcvDeTermCd[i]);
				if (diFnlIhcRtAmt[i] != null)
					model.setDiFnlIhcRtAmt(diFnlIhcRtAmt[i]);
				if (rtRasConvCtnt[i] != null)
					model.setRtRasConvCtnt(rtRasConvCtnt[i]);
				if (oaPrcCgoTpCd[i] != null)
					model.setOaPrcCgoTpCd(oaPrcCgoTpCd[i]);
				if (oiFnlIhcRtAmt[i] != null)
					model.setOiFnlIhcRtAmt(oiFnlIhcRtAmt[i]);
				if (daRacConvCtnt[i] != null)
					model.setDaRacConvCtnt(daRacConvCtnt[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (ovRoutViaPortDefCd[i] != null)
					model.setOvRoutViaPortDefCd(ovRoutViaPortDefCd[i]);
				if (oiRoutPntLocDefCd[i] != null)
					model.setOiRoutPntLocDefCd(oiRoutPntLocDefCd[i]);
				if (daMaxCgoWgt[i] != null)
					model.setDaMaxCgoWgt(daMaxCgoWgt[i]);
				if (oaCurrCd[i] != null)
					model.setOaCurrCd(oaCurrCd[i]);
				if (oihFlg[i] != null)
					model.setOihFlg(oihFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (daFnlFrtRtAmt[i] != null)
					model.setDaFnlFrtRtAmt(daFnlFrtRtAmt[i]);
				if (bqPodApplFlg[i] != null)
					model.setBqPodApplFlg(bqPodApplFlg[i]);
				if (bqSeq[i] != null)
					model.setBqSeq(bqSeq[i]);
				if (rtAppBkgConvTpCd[i] != null)
					model.setRtAppBkgConvTpCd(rtAppBkgConvTpCd[i]);
				if (dpPrcTrspModCd[i] != null)
					model.setDpPrcTrspModCd(dpPrcTrspModCd[i]);
				if (opPrcTrspModCd[i] != null)
					model.setOpPrcTrspModCd(opPrcTrspModCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (diCalcFrtRtAmt[i] != null)
					model.setDiCalcFrtRtAmt(diCalcFrtRtAmt[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (diRcvDeTermCd[i] != null)
					model.setDiRcvDeTermCd(diRcvDeTermCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (oftCmbSeq[i] != null)
					model.setOftCmbSeq(oftCmbSeq[i]);
				if (diRatUtCd[i] != null)
					model.setDiRatUtCd(diRatUtCd[i]);
				if (daRatUtCd[i] != null)
					model.setDaRatUtCd(daRatUtCd[i]);
				if (oaFnlFrtRtAmt[i] != null)
					model.setOaFnlFrtRtAmt(oaFnlFrtRtAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmPrcCmdtTpCd[i] != null)
					model.setCmPrcCmdtTpCd(cmPrcCmdtTpCd[i]);
				if (prcRtSeq[i] != null)
					model.setPrcRtSeq(prcRtSeq[i]);
				if (rtCalcFrtRtAmt[i] != null)
					model.setRtCalcFrtRtAmt(rtCalcFrtRtAmt[i]);
				if (rtAppNoteConvMapgId[i] != null)
					model.setRtAppNoteConvMapgId(rtAppNoteConvMapgId[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (diCurrCd[i] != null)
					model.setDiCurrCd(diCurrCd[i]);
				if (diFdrCurrCd[i] != null)
					model.setDiFdrCurrCd(diFdrCurrCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (rtRasBkgConvTpCd[i] != null)
					model.setRtRasBkgConvTpCd(rtRasBkgConvTpCd[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtRarConvCtnt[i] != null)
					model.setRtRarConvCtnt(rtRarConvCtnt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (rtRacConvCtnt[i] != null)
					model.setRtRacConvCtnt(rtRacConvCtnt[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (oiRatUtCd[i] != null)
					model.setOiRatUtCd(oiRatUtCd[i]);
				if (daPrcCgoTpCd[i] != null)
					model.setDaPrcCgoTpCd(daPrcCgoTpCd[i]);
				if (prcCmdtHdrSeq[i] != null)
					model.setPrcCmdtHdrSeq(prcCmdtHdrSeq[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (oaCalcFrtRtAmt[i] != null)
					model.setOaCalcFrtRtAmt(oaCalcFrtRtAmt[i]);
				if (rtRasNoteConvRuleCd[i] != null)
					model.setRtRasNoteConvRuleCd(rtRasNoteConvRuleCd[i]);
				if (rtRasCurrCd[i] != null)
					model.setRtRasCurrCd(rtRasCurrCd[i]);
				if (rtAppNoteConvSeq[i] != null)
					model.setRtAppNoteConvSeq(rtAppNoteConvSeq[i]);
				if (oiFdrRcvDeTermCd[i] != null)
					model.setOiFdrRcvDeTermCd(oiFdrRcvDeTermCd[i]);
				if (rtRasNoteConvTpCd[i] != null)
					model.setRtRasNoteConvTpCd(rtRasNoteConvTpCd[i]);
				if (rtPrcCgoTpCd[i] != null)
					model.setRtPrcCgoTpCd(rtPrcCgoTpCd[i]);
				if (rtDorConvCtnt[i] != null)
					model.setRtDorConvCtnt(rtDorConvCtnt[i]);
				if (oaAddChgSeq[i] != null)
					model.setOaAddChgSeq(oaAddChgSeq[i]);
				if (note[i] != null)
					model.setNote(note[i]);
				if (oaMinCgoWgt[i] != null)
					model.setOaMinCgoWgt(oaMinCgoWgt[i]);
				if (daTypConvCtnt[i] != null)
					model.setDaTypConvCtnt(daTypConvCtnt[i]);
				if (bkgBqOccrSeq[i] != null)
					model.setBkgBqOccrSeq(bkgBqOccrSeq[i]);
				if (bqDelApplFlg[i] != null)
					model.setBqDelApplFlg(bqDelApplFlg[i]);
				if (daRcvDeTermCd[i] != null)
					model.setDaRcvDeTermCd(daRcvDeTermCd[i]);
				if (calcCtrtTpCd[i] != null)
					model.setCalcCtrtTpCd(calcCtrtTpCd[i]);
				if (oiCalcFrtRtAmt[i] != null)
					model.setOiCalcFrtRtAmt(oiCalcFrtRtAmt[i]);
				if (daMinCgoWgt[i] != null)
					model.setDaMinCgoWgt(daMinCgoWgt[i]);
				if (inclOftFlg[i] != null)
					model.setInclOftFlg(inclOftFlg[i]);
				if (oaTypConvCtnt[i] != null)
					model.setOaTypConvCtnt(oaTypConvCtnt[i]);
				if (diAddChgSeq[i] != null)
					model.setDiAddChgSeq(diAddChgSeq[i]);
				if (bqPorRlyPortApplFlg[i] != null)
					model.setBqPorRlyPortApplFlg(bqPorRlyPortApplFlg[i]);
				if (daRoutPntLocDefCd[i] != null)
					model.setDaRoutPntLocDefCd(daRoutPntLocDefCd[i]);
				if (rtCurrCd[i] != null)
					model.setRtCurrCd(rtCurrCd[i]);
				if (oaBsePortDefCd[i] != null)
					model.setOaBsePortDefCd(oaBsePortDefCd[i]);
				if (prcHngrBarTpCd[i] != null)
					model.setPrcHngrBarTpCd(prcHngrBarTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (oiCurrCd[i] != null)
					model.setOiCurrCd(oiCurrCd[i]);
				if (oiFdrCurrCd[i] != null)
					model.setOiFdrCurrCd(oiFdrCurrCd[i]);
				if (oiFnlFrtRtAmt[i] != null)
					model.setOiFnlFrtRtAmt(oiFnlFrtRtAmt[i]);
				if (cmPrcCmdtDefCd[i] != null)
					model.setCmPrcCmdtDefCd(cmPrcCmdtDefCd[i]);
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (bqPorApplFlg[i] != null)
					model.setBqPorApplFlg(bqPorApplFlg[i]);
				if (orgTrspModCd[i] != null)
					model.setOrgTrspModCd(orgTrspModCd[i]);
				if (diPrcCgoTpCd[i] != null)
					model.setDiPrcCgoTpCd(diPrcCgoTpCd[i]);
				if (porMtchFlg[i] != null)
					model.setPorMtchFlg(porMtchFlg[i]);
				if (rtDeTermCd[i] != null)
					model.setRtDeTermCd(rtDeTermCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dtl[i] != null)
					model.setDtl(dtl[i]);
				if (bqPolApplFlg[i] != null)
					model.setBqPolApplFlg(bqPolApplFlg[i]);
				if (cgoCateCd[i] != null)
					model.setCgoCateCd(cgoCateCd[i]);
				if (destTrspModCd[i] != null)
					model.setDestTrspModCd(destTrspModCd[i]);
				if (rtRasRtOpCd[i] != null)
					model.setRtRasRtOpCd(rtRasRtOpCd[i]);
				if (rtMtchPattCd[i] != null)
					model.setRtMtchPattCd(rtMtchPattCd[i]);
				if (prcGenSpclRtTpCd[i] != null)
					model.setPrcGenSpclRtTpCd(prcGenSpclRtTpCd[i]);
				if (daCurrCd[i] != null)
					model.setDaCurrCd(daCurrCd[i]);
				if (diFnlFrtRtAmt[i] != null)
					model.setDiFnlFrtRtAmt(diFnlFrtRtAmt[i]);
				if (rtAppNoteConvRuleCd[i] != null)
					model.setRtAppNoteConvRuleCd(rtAppNoteConvRuleCd[i]);
				if (inGaFlg[i] != null)
					model.setInGaFlg(inGaFlg[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oiPrcCgoTpCd[i] != null)
					model.setOiPrcCgoTpCd(oiPrcCgoTpCd[i]);
				if (diRoutPntLocDefCd[i] != null)
					model.setDiRoutPntLocDefCd(diRoutPntLocDefCd[i]);
				if (diFnlFdrRtAmt[i] != null)
					model.setDiFnlFdrRtAmt(diFnlFdrRtAmt[i]);
				if (rtRapConvCtnt[i] != null)
					model.setRtRapConvCtnt(rtRapConvCtnt[i]);
				if (prcRtMtchPattCd[i] != null)
					model.setPrcRtMtchPattCd(prcRtMtchPattCd[i]);
				if (oiAddChgSeq[i] != null)
					model.setOiAddChgSeq(oiAddChgSeq[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (bqPstRlyPortApplFlg[i] != null)
					model.setBqPstRlyPortApplFlg(bqPstRlyPortApplFlg[i]);
				if (dpRoutPntLocDefCd[i] != null)
					model.setDpRoutPntLocDefCd(dpRoutPntLocDefCd[i]);
				if (daPrcTrspModCd[i] != null)
					model.setDaPrcTrspModCd(daPrcTrspModCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (oiRcvDeTermCd[i] != null)
					model.setOiRcvDeTermCd(oiRcvDeTermCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dihFlg[i] != null)
					model.setDihFlg(dihFlg[i]);
				if (rtAppCurrCd[i] != null)
					model.setRtAppCurrCd(rtAppCurrCd[i]);
				if (rtRasNoteConvSeq[i] != null)
					model.setRtRasNoteConvSeq(rtRasNoteConvSeq[i]);
				if (oaRoutPntLocDefCd[i] != null)
					model.setOaRoutPntLocDefCd(oaRoutPntLocDefCd[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (oaRatUtCd[i] != null)
					model.setOaRatUtCd(oaRatUtCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtFnlFrtRtAmt[i] != null)
					model.setRtFnlFrtRtAmt(rtFnlFrtRtAmt[i]);
				if (dvRoutViaPortDefCd[i] != null)
					model.setDvRoutViaPortDefCd(dvRoutViaPortDefCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rtRasFrtRtAmt[i] != null)
					model.setRtRasFrtRtAmt(rtRasFrtRtAmt[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (rtRasNoteConvMapgId[i] != null)
					model.setRtRasNoteConvMapgId(rtRasNoteConvMapgId[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (rtTypConvCtnt[i] != null)
					model.setRtTypConvCtnt(rtTypConvCtnt[i]);
				if (diBsePortDefCd[i] != null)
					model.setDiBsePortDefCd(diBsePortDefCd[i]);
				if (daBsePortDefCd[i] != null)
					model.setDaBsePortDefCd(daBsePortDefCd[i]);
				if (rtAppNoteConvTpCd[i] != null)
					model.setRtAppNoteConvTpCd(rtAppNoteConvTpCd[i]);
				if (ctrtCntrTpszCd[i] != null)
					model.setCtrtCntrTpszCd(ctrtCntrTpszCd[i]);
				if (prcRoutSeq[i] != null)
					model.setPrcRoutSeq(prcRoutSeq[i]);
				if (oiPrcTrspModCd[i] != null)
					model.setOiPrcTrspModCd(oiPrcTrspModCd[i]);
				if (oaMaxCgoWgt[i] != null)
					model.setOaMaxCgoWgt(oaMaxCgoWgt[i]);
				if (delMtchFlg[i] != null)
					model.setDelMtchFlg(delMtchFlg[i]);
				if (oiBsePortDefCd[i] != null)
					model.setOiBsePortDefCd(oiBsePortDefCd[i]);
				if (opRoutPntLocDefCd[i] != null)
					model.setOpRoutPntLocDefCd(opRoutPntLocDefCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				if (eqSubstCntrTpszCd[i] != null)
					model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (oiViaPortDefCd[i] != null)
					model.setOiViaPortDefCd(oiViaPortDefCd[i]);
				if (bkgBqSeq[i] != null)
					model.setBkgBqSeq(bkgBqSeq[i]);
				if (trnsModCd[i] != null)
					model.setTrnsModCd(trnsModCd[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (rtRatUtCd[i] != null)
					model.setRtRatUtCd(rtRatUtCd[i]);
				if (diViaPortDefCd[i] != null)
					model.setDiViaPortDefCd(diViaPortDefCd[i]);
				if (rtAppFrtRtAmt[i] != null)
					model.setRtAppFrtRtAmt(rtAppFrtRtAmt[i]);
				if (rtAppRtOpCd[i] != null)
					model.setRtAppRtOpCd(rtAppRtOpCd[i]);
				if (rtroFlg[i] != null)
					model.setRtroFlg(rtroFlg[i]);
				if (mstRfaRoutId[i] != null)
					model.setMstRfaRoutId(mstRfaRoutId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRfaOftAutoratingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRfaOftAutoratingListVO[]
	 */
	public SearchRfaOftAutoratingListVO[] getSearchRfaOftAutoratingListVOs(){
		SearchRfaOftAutoratingListVO[] vos = (SearchRfaOftAutoratingListVO[])models.toArray(new SearchRfaOftAutoratingListVO[models.size()]);
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
		this.rtRcvTermCd = this.rtRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCalcFrtRtAmt = this.daCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacConvCtnt = this.oaRacConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcTrspModCd = this.oaPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcTrspModCd = this.diPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daAddChgSeq = this.daAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFnlFdrRtAmt = this.oiFnlFdrRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFdrRcvDeTermCd = this.diFdrRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRcvDeTermCd = this.oaRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFnlIhcRtAmt = this.diFnlIhcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasConvCtnt = this.rtRasConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcCgoTpCd = this.oaPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFnlIhcRtAmt = this.oiFnlIhcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacConvCtnt = this.daRacConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRoutViaPortDefCd = this.ovRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRoutPntLocDefCd = this.oiRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daMaxCgoWgt = this.daMaxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCurrCd = this.oaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oihFlg = this.oihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daFnlFrtRtAmt = this.daFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPodApplFlg = this.bqPodApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqSeq = this.bqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppBkgConvTpCd = this.rtAppBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcTrspModCd = this.dpPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opPrcTrspModCd = this.opPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCalcFrtRtAmt = this.diCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRcvDeTermCd = this.diRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCmbSeq = this.oftCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRatUtCd = this.diRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRatUtCd = this.daRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaFnlFrtRtAmt = this.oaFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtTpCd = this.cmPrcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtSeq = this.prcRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCalcFrtRtAmt = this.rtCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvMapgId = this.rtAppNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCurrCd = this.diCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFdrCurrCd = this.diFdrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasBkgConvTpCd = this.rtRasBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarConvCtnt = this.rtRarConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacConvCtnt = this.rtRacConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRatUtCd = this.oiRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcCgoTpCd = this.daPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtHdrSeq = this.prcCmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCalcFrtRtAmt = this.oaCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvRuleCd = this.rtRasNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasCurrCd = this.rtRasCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvSeq = this.rtAppNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFdrRcvDeTermCd = this.oiFdrRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvTpCd = this.rtRasNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPrcCgoTpCd = this.rtPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorConvCtnt = this.rtDorConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaAddChgSeq = this.oaAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.note = this.note .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaMinCgoWgt = this.oaMinCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypConvCtnt = this.daTypConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqOccrSeq = this.bkgBqOccrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqDelApplFlg = this.bqDelApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRcvDeTermCd = this.daRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCtrtTpCd = this.calcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCalcFrtRtAmt = this.oiCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daMinCgoWgt = this.daMinCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclOftFlg = this.inclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypConvCtnt = this.oaTypConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diAddChgSeq = this.diAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorRlyPortApplFlg = this.bqPorRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRoutPntLocDefCd = this.daRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurrCd = this.rtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaBsePortDefCd = this.oaBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd = this.prcHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCurrCd = this.oiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFdrCurrCd = this.oiFdrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFnlFrtRtAmt = this.oiFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtDefCd = this.cmPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorApplFlg = this.bqPorApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd = this.orgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcCgoTpCd = this.diPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porMtchFlg = this.porMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDeTermCd = this.rtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtl = this.dtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPolApplFlg = this.bqPolApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCateCd = this.cgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrspModCd = this.destTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasRtOpCd = this.rtRasRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtMtchPattCd = this.rtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGenSpclRtTpCd = this.prcGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCurrCd = this.daCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFnlFrtRtAmt = this.diFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvRuleCd = this.rtAppNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inGaFlg = this.inGaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcCgoTpCd = this.oiPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRoutPntLocDefCd = this.diRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFnlFdrRtAmt = this.diFnlFdrRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapConvCtnt = this.rtRapConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd = this.prcRtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiAddChgSeq = this.oiAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPstRlyPortApplFlg = this.bqPstRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpRoutPntLocDefCd = this.dpRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcTrspModCd = this.daPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRcvDeTermCd = this.oiRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dihFlg = this.dihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppCurrCd = this.rtAppCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvSeq = this.rtRasNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRoutPntLocDefCd = this.oaRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRatUtCd = this.oaRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFnlFrtRtAmt = this.rtFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvRoutViaPortDefCd = this.dvRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasFrtRtAmt = this.rtRasFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvMapgId = this.rtRasNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypConvCtnt = this.rtTypConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diBsePortDefCd = this.diBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daBsePortDefCd = this.daBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvTpCd = this.rtAppNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd = this.ctrtCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRoutSeq = this.prcRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcTrspModCd = this.oiPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaMaxCgoWgt = this.oaMaxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delMtchFlg = this.delMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiBsePortDefCd = this.oiBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opRoutPntLocDefCd = this.opRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiViaPortDefCd = this.oiViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqSeq = this.bkgBqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModCd = this.trnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRatUtCd = this.rtRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diViaPortDefCd = this.diViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppFrtRtAmt = this.rtAppFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppRtOpCd = this.rtAppRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroFlg = this.rtroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstRfaRoutId = this.mstRfaRoutId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
