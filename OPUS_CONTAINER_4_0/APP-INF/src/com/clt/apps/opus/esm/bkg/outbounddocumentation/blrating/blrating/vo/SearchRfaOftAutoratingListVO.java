/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchRfaOftAutoratingListVO.java
*@FileTitle : SearchRfaOftAutoratingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.04.07 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRfaOftAutoratingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchRfaOftAutoratingListVO> models = new ArrayList<SearchRfaOftAutoratingListVO>();
	
	/* Column Info */
	private String oaRacConvCtnt = null;
	/* Column Info */
	private String daCalcFrtRtAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String oaPrcTrspModCd = null;
	/* Column Info */
	private String daAddChgSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oaRcvDeTermCd = null;
	/* Column Info */
	private String rtRasConvCtnt = null;
	/* Column Info */
	private String oaPrcCgoTpCd = null;
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
	private String dpPrcTrspModCd = null;
	/* Column Info */
	private String rtAppBkgConvTpCd = null;
	/* Column Info */
	private String opPrcTrspModCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String oftCmbSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String oaFnlFrtRtAmt = null;
	/* Column Info */
	private String daRatUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmPrcCmdtTpCd = null;
	/* Column Info */
	private String rtCalcFrtRtAmt = null;
	/* Column Info */
	private String prcRtSeq = null;
	/* Column Info */
	private String rtAppNoteConvMapgId = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtRasBkgConvTpCd = null;
	/* Column Info */
	private String rtRarConvCtnt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String rtRacConvCtnt = null;
	/* Column Info */
	private String prcCgoTpCd = null;
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
	private String daMinCgoWgt = null;
	/* Column Info */
	private String inclOftFlg = null;
	/* Column Info */
	private String oaTypConvCtnt = null;
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
	private String porMtchFlg = null;
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
	private String rtRapConvCtnt = null;
	/* Column Info */
	private String prcRtMtchPattCd = null;
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
	private String dihFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rtAppCurrCd = null;
	/* Column Info */
	private String rtRasNoteConvSeq = null;
	/* Column Info */
	private String oaRoutPntLocDefCd = null;
	/* Column Info */
	private String noteCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oaRatUtCd = null;
	/* Column Info */
	private String rtFnlFrtRtAmt = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dvRoutViaPortDefCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String rtRasFrtRtAmt = null;
	/* Column Info */
	private String rtRasNoteConvMapgId = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String rtTypConvCtnt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String daBsePortDefCd = null;
	/* Column Info */
	private String prcRoutSeq = null;
	/* Column Info */
	private String ctrtCntrTpszCd = null;
	/* Column Info */
	private String rtAppNoteConvTpCd = null;
	/* Column Info */
	private String oaMaxCgoWgt = null;
	/* Column Info */
	private String delMtchFlg = null;
	/* Column Info */
	private String opRoutPntLocDefCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String eqSubstCntrTpszCd = null;
	/* Column Info */
	private String frtInclXcldDivCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String trnsModCd = null;
	/* Column Info */
	private String bkgBqSeq = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String rtRatUtCd = null;
	/* Column Info */
	private String rtAppFrtRtAmt = null;
	/* Column Info */
	private String rtAppRtOpCd = null;
	/* Column Info */
	private String cmdtSeq = null;
	/* Column Info */
	private String oiFnlFrtRtAmt = null;
	/* Column Info */
	private String diFnlFrtRtAmt = null;
	/* Column Info */
	private String oiRoutPntLocDefCd = null;
	/* Column Info */
	private String oiBsePortDefCd = null;
	/* Column Info */
	private String oiRatUtCd = null;
	/* Column Info */
	private String oiPrcCgoTpCd = null;
	/* Column Info */
	private String oiPrcTrspModCd = null;
	/* Column Info */
	private String oiRcvDeTermCd = null;
	/* Column Info */
	private String oiCurrCd = null;
	/* Column Info */
	private String oiCalcFrtRtAmt = null;
	/* Column Info */
	private String diRoutPntLocDefCd = null;
	/* Column Info */
	private String diBsePortDefCd = null;
	/* Column Info */
	private String diRatUtCd = null;
	/* Column Info */
	private String diPrcCgoTpCd = null;
	/* Column Info */
	private String diPrcTrspModCd = null;
	/* Column Info */
	private String diRcvDeTermCd = null;
	/* Column Info */
	private String diCurrCd = null;
	/* Column Info */
	private String diCalcFrtRtAmt = null;
    /* Column Info */
    private String autoRatFlg = null;
	private String cnoteCtnt = null; 
	private String snoteCtnt = null; 
	private String arbNoteCtnt = null;
	private String cnote = null; 
	private String snote = null; 
	private String arbNote = null;
	private String oiFm = null; 
	private String oaFm = null; 
	private String daFm = null; 
	private String diFm = null;    
	private String oiMinCgoWgt = null;
	private String oiMaxCgoWgt = null;
	private String diMinCgoWgt = null;
	private String diMaxCgoWgt = null;
	private String oiFrtTermCd = null; 
	private String oaFrtTermCd = null; 
	private String daFrtTermCd = null; 
	private String diFrtTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRfaOftAutoratingListVO() {}

	public SearchRfaOftAutoratingListVO(String ibflag, String pagerows, String ctrtNo, String prcRtMtchPattCd, String propNo, String amdtSeq, String svcScpCd, String bqSeq, String bkgBqSeq, String cntrTpszCd, String ctrtCntrTpszCd, String rcvTermCd, String deTermCd, String dryCgoFlg, String awkCgoFlg, String dcgoFlg, String rcFlg, String bbCgoFlg, String socFlg, String imdgClssCd, String cmdtHdrSeq, String routSeq, String rtSeq, String rtMtchPattCd, String cmdtNm, String porCd, String polCd, String podCd, String delCd, String rcvDeTermCd, String ratUtCd, String prcCgoTpCd, String currCd, String orgTrspModCd, String destTrspModCd, String fnlFrtRtAmt, String trnsModCd, String opCntrQty, String noteCtnt, String note, String dtl, String cgoCateCd, String bqPorApplFlg, String bqPolApplFlg, String bqPodApplFlg, String bqDelApplFlg, String bqPorRlyPortApplFlg, String bqPstRlyPortApplFlg, String oaAddChgSeq, String daAddChgSeq, String cmPrcCmdtTpCd, String cmPrcCmdtDefCd, String opRoutPntLocDefCd, String ovRoutViaPortDefCd, String dvRoutViaPortDefCd, String dpRoutPntLocDefCd, String opPrcTrspModCd, String dpPrcTrspModCd, String rtRatUtCd, String rtPrcCgoTpCd, String rtCurrCd, String rtFnlFrtRtAmt, String oaRoutPntLocDefCd, String oaBsePortDefCd, String oaRatUtCd, String oaPrcCgoTpCd, String oaPrcTrspModCd, String oaRcvDeTermCd, String oaCurrCd, String oaFnlFrtRtAmt, String daRoutPntLocDefCd, String daBsePortDefCd, String daRatUtCd, String daPrcCgoTpCd, String daPrcTrspModCd, String daRcvDeTermCd, String daCurrCd, String daFnlFrtRtAmt, String rtAppBkgConvTpCd, String rtAppNoteConvMapgId, String rtAppNoteConvSeq, String rtAppNoteConvRuleCd, String rtAppNoteConvTpCd, String rtAppRtOpCd, String rtAppCurrCd, String rtAppFrtRtAmt, String rtRasBkgConvTpCd, String rtRasNoteConvMapgId, String rtRasNoteConvSeq, String rtRasNoteConvRuleCd, String rtRasNoteConvTpCd, String rtRasRtOpCd, String rtRasCurrCd, String rtRasFrtRtAmt, String porMtchFlg, String delMtchFlg, String oihFlg, String dihFlg, String chgCd, String chgUtAmt, String frtRtAmt, String ratAsQty, String chgAmt, String inclOftFlg, String frtTermCd, String cgoTpCd, String prcHngrBarTpCd, String inGaFlg, String cntrWgt, String bkgNo, String prcGenSpclRtTpCd, String prcCmdtHdrSeq, String prcRoutSeq, String prcRtSeq, String rtCalcFrtRtAmt, String oaCalcFrtRtAmt, String daCalcFrtRtAmt, String bkgBqOccrSeq, String oftCmbSeq, String rtRapConvCtnt, String rtRarConvCtnt, String rtDorConvCtnt, String rtTypConvCtnt, String rtRacConvCtnt, String rtRasConvCtnt, String oaTypConvCtnt, String oaRacConvCtnt, String daTypConvCtnt, String daRacConvCtnt, String oaMinCgoWgt, String oaMaxCgoWgt, String daMinCgoWgt, String daMaxCgoWgt, String frtInclXcldDivCd, String dpSeq, String porCntCd, String delCntCd, String eqSubstCntrTpszCd, String cmdtSeq, String autoRatFlg, String oiFnlFrtRtAmt, String diFnlFrtRtAmt, String oiRoutPntLocDefCd, String oiBsePortDefCd, String oiRatUtCd, String oiPrcCgoTpCd, String oiPrcTrspModCd, String oiRcvDeTermCd, String oiCurrCd, String oiCalcFrtRtAmt, String diRoutPntLocDefCd, String diBsePortDefCd, String diRatUtCd, String diPrcCgoTpCd, String diPrcTrspModCd, String diRcvDeTermCd, String diCurrCd, String diCalcFrtRtAmt, String cnoteCtnt, String snoteCtnt, String arbNoteCtnt,String cnote, String snote, String arbNote, String oiFm, String oaFm, String daFm, String diFm, String oiMinCgoWgt, String oiMaxCgoWgt, String diMinCgoWgt, String diMaxCgoWgt, String oiFrtTermCd, String oaFrtTermCd, String daFrtTermCd, String diFrtTermCd) {
		this.oaRacConvCtnt = oaRacConvCtnt;
		this.daCalcFrtRtAmt = daCalcFrtRtAmt;
		this.svcScpCd = svcScpCd;
		this.cgoTpCd = cgoTpCd;
		this.oaPrcTrspModCd = oaPrcTrspModCd;
		this.daAddChgSeq = daAddChgSeq;
		this.pagerows = pagerows;
		this.oaRcvDeTermCd = oaRcvDeTermCd;
		this.rtRasConvCtnt = rtRasConvCtnt;
		this.oaPrcCgoTpCd = oaPrcCgoTpCd;
		this.daRacConvCtnt = daRacConvCtnt;
		this.chgAmt = chgAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
		this.daMaxCgoWgt = daMaxCgoWgt;
		this.oaCurrCd = oaCurrCd;
		this.oihFlg = oihFlg;
		this.cntrWgt = cntrWgt;
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
		this.bqPodApplFlg = bqPodApplFlg;
		this.bqSeq = bqSeq;
		this.dpPrcTrspModCd = dpPrcTrspModCd;
		this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
		this.opPrcTrspModCd = opPrcTrspModCd;
		this.ratUtCd = ratUtCd;
		this.rtSeq = rtSeq;
		this.routSeq = routSeq;
		this.oftCmbSeq = oftCmbSeq;
		this.podCd = podCd;
		this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
		this.daRatUtCd = daRatUtCd;
		this.bkgNo = bkgNo;
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
		this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
		this.prcRtSeq = prcRtSeq;
		this.rtAppNoteConvMapgId = rtAppNoteConvMapgId;
		this.opCntrQty = opCntrQty;
		this.rcFlg = rcFlg;
		this.imdgClssCd = imdgClssCd;
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
		this.rtRarConvCtnt = rtRarConvCtnt;
		this.dpSeq = dpSeq;
		this.rtRacConvCtnt = rtRacConvCtnt;
		this.prcCgoTpCd = prcCgoTpCd;
		this.daPrcCgoTpCd = daPrcCgoTpCd;
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
		this.rtRasNoteConvRuleCd = rtRasNoteConvRuleCd;
		this.rtRasCurrCd = rtRasCurrCd;
		this.rtAppNoteConvSeq = rtAppNoteConvSeq;
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
		this.daMinCgoWgt = daMinCgoWgt;
		this.inclOftFlg = inclOftFlg;
		this.oaTypConvCtnt = oaTypConvCtnt;
		this.bqPorRlyPortApplFlg = bqPorRlyPortApplFlg;
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
		this.rtCurrCd = rtCurrCd;
		this.oaBsePortDefCd = oaBsePortDefCd;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.propNo = propNo;
		this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
		this.dryCgoFlg = dryCgoFlg;
		this.amdtSeq = amdtSeq;
		this.bqPorApplFlg = bqPorApplFlg;
		this.orgTrspModCd = orgTrspModCd;
		this.porMtchFlg = porMtchFlg;
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
		this.rtAppNoteConvRuleCd = rtAppNoteConvRuleCd;
		this.inGaFlg = inGaFlg;
		this.delCntCd = delCntCd;
		this.awkCgoFlg = awkCgoFlg;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.rtRapConvCtnt = rtRapConvCtnt;
		this.prcRtMtchPattCd = prcRtMtchPattCd;
		this.ratAsQty = ratAsQty;
		this.bqPstRlyPortApplFlg = bqPstRlyPortApplFlg;
		this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
		this.daPrcTrspModCd = daPrcTrspModCd;
		this.porCd = porCd;
		this.dihFlg = dihFlg;
		this.currCd = currCd;
		this.rtAppCurrCd = rtAppCurrCd;
		this.rtRasNoteConvSeq = rtRasNoteConvSeq;
		this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
		this.noteCtnt = noteCtnt;
		this.ibflag = ibflag;
		this.oaRatUtCd = oaRatUtCd;
		this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
		this.bbCgoFlg = bbCgoFlg;
		this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
		this.dcgoFlg = dcgoFlg;
		this.rcvTermCd = rcvTermCd;
		this.porCntCd = porCntCd;
		this.rtRasFrtRtAmt = rtRasFrtRtAmt;
		this.rtRasNoteConvMapgId = rtRasNoteConvMapgId;
		this.chgUtAmt = chgUtAmt;
		this.rtTypConvCtnt = rtTypConvCtnt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.daBsePortDefCd = daBsePortDefCd;
		this.prcRoutSeq = prcRoutSeq;
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
		this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
		this.oaMaxCgoWgt = oaMaxCgoWgt;
		this.delMtchFlg = delMtchFlg;
		this.opRoutPntLocDefCd = opRoutPntLocDefCd;
		this.cmdtNm = cmdtNm;
		this.socFlg = socFlg;
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
		this.frtInclXcldDivCd = frtInclXcldDivCd;
		this.deTermCd = deTermCd;
		this.trnsModCd = trnsModCd;
		this.bkgBqSeq = bkgBqSeq;
		this.frtRtAmt = frtRtAmt;
		this.rtRatUtCd = rtRatUtCd;
		this.rtAppFrtRtAmt = rtAppFrtRtAmt;
		this.rtAppRtOpCd = rtAppRtOpCd;
		this.cmdtSeq = cmdtSeq;
        this.autoRatFlg = autoRatFlg;
		this.oiFnlFrtRtAmt = oiFnlFrtRtAmt;
		this.diFnlFrtRtAmt = diFnlFrtRtAmt;
		this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
		this.oiBsePortDefCd = oiBsePortDefCd;
		this.oiRatUtCd = oiRatUtCd;
		this.oiPrcCgoTpCd = oiPrcCgoTpCd;
		this.oiPrcTrspModCd = oiPrcTrspModCd;
		this.oiRcvDeTermCd = oiRcvDeTermCd;
		this.oiCurrCd = oiCurrCd;
		this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
		this.diRoutPntLocDefCd = diRoutPntLocDefCd;
		this.diBsePortDefCd = diBsePortDefCd;
		this.diRatUtCd = diRatUtCd;
		this.diPrcCgoTpCd = diPrcCgoTpCd;
		this.diPrcTrspModCd = diPrcTrspModCd;
		this.diRcvDeTermCd = diRcvDeTermCd;
		this.diCurrCd = diCurrCd;
		this.diCalcFrtRtAmt = diCalcFrtRtAmt;
		this.cnoteCtnt = cnoteCtnt;
		this.snoteCtnt = snoteCtnt;
		this.arbNoteCtnt = arbNoteCtnt;
		this.cnote = cnote;
		this.snote = snote;
		this.arbNote = arbNote;
		this.oiFm = oiFm;
		this.oaFm = oaFm;
		this.daFm = daFm;
		this.diFm = diFm;
		this.oiMinCgoWgt = oiMinCgoWgt;
		this.oiMaxCgoWgt = oiMaxCgoWgt;
		this.diMinCgoWgt = diMinCgoWgt;
		this.diMaxCgoWgt = diMaxCgoWgt;
		this.oiFrtTermCd = oiFrtTermCd;
		this.oaFrtTermCd = oaFrtTermCd;
		this.daFrtTermCd = daFrtTermCd;
		this.diFrtTermCd = diFrtTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oa_rac_conv_ctnt", getOaRacConvCtnt());
		this.hashColumns.put("da_calc_frt_rt_amt", getDaCalcFrtRtAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("oa_prc_trsp_mod_cd", getOaPrcTrspModCd());
		this.hashColumns.put("da_add_chg_seq", getDaAddChgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("oa_rcv_de_term_cd", getOaRcvDeTermCd());
		this.hashColumns.put("rt_ras_conv_ctnt", getRtRasConvCtnt());
		this.hashColumns.put("oa_prc_cgo_tp_cd", getOaPrcCgoTpCd());
		this.hashColumns.put("da_rac_conv_ctnt", getDaRacConvCtnt());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("ov_rout_via_port_def_cd", getOvRoutViaPortDefCd());
		this.hashColumns.put("da_max_cgo_wgt", getDaMaxCgoWgt());
		this.hashColumns.put("oa_curr_cd", getOaCurrCd());
		this.hashColumns.put("oih_flg", getOihFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("da_fnl_frt_rt_amt", getDaFnlFrtRtAmt());
		this.hashColumns.put("bq_pod_appl_flg", getBqPodApplFlg());
		this.hashColumns.put("bq_seq", getBqSeq());
		this.hashColumns.put("dp_prc_trsp_mod_cd", getDpPrcTrspModCd());
		this.hashColumns.put("rt_app_bkg_conv_tp_cd", getRtAppBkgConvTpCd());
		this.hashColumns.put("op_prc_trsp_mod_cd", getOpPrcTrspModCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("oft_cmb_seq", getOftCmbSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("oa_fnl_frt_rt_amt", getOaFnlFrtRtAmt());
		this.hashColumns.put("da_rat_ut_cd", getDaRatUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cm_prc_cmdt_tp_cd", getCmPrcCmdtTpCd());
		this.hashColumns.put("rt_calc_frt_rt_amt", getRtCalcFrtRtAmt());
		this.hashColumns.put("prc_rt_seq", getPrcRtSeq());
		this.hashColumns.put("rt_app_note_conv_mapg_id", getRtAppNoteConvMapgId());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_ras_bkg_conv_tp_cd", getRtRasBkgConvTpCd());
		this.hashColumns.put("rt_rar_conv_ctnt", getRtRarConvCtnt());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("rt_rac_conv_ctnt", getRtRacConvCtnt());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("da_prc_cgo_tp_cd", getDaPrcCgoTpCd());
		this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("oa_calc_frt_rt_amt", getOaCalcFrtRtAmt());
		this.hashColumns.put("rt_ras_note_conv_rule_cd", getRtRasNoteConvRuleCd());
		this.hashColumns.put("rt_ras_curr_cd", getRtRasCurrCd());
		this.hashColumns.put("rt_app_note_conv_seq", getRtAppNoteConvSeq());
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
		this.hashColumns.put("da_min_cgo_wgt", getDaMinCgoWgt());
		this.hashColumns.put("incl_oft_flg", getInclOftFlg());
		this.hashColumns.put("oa_typ_conv_ctnt", getOaTypConvCtnt());
		this.hashColumns.put("bq_por_rly_port_appl_flg", getBqPorRlyPortApplFlg());
		this.hashColumns.put("da_rout_pnt_loc_def_cd", getDaRoutPntLocDefCd());
		this.hashColumns.put("rt_curr_cd", getRtCurrCd());
		this.hashColumns.put("oa_bse_port_def_cd", getOaBsePortDefCd());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cm_prc_cmdt_def_cd", getCmPrcCmdtDefCd());
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("bq_por_appl_flg", getBqPorApplFlg());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("por_mtch_flg", getPorMtchFlg());
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
		this.hashColumns.put("rt_app_note_conv_rule_cd", getRtAppNoteConvRuleCd());
		this.hashColumns.put("in_ga_flg", getInGaFlg());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rt_rap_conv_ctnt", getRtRapConvCtnt());
		this.hashColumns.put("prc_rt_mtch_patt_cd", getPrcRtMtchPattCd());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("bq_pst_rly_port_appl_flg", getBqPstRlyPortApplFlg());
		this.hashColumns.put("dp_rout_pnt_loc_def_cd", getDpRoutPntLocDefCd());
		this.hashColumns.put("da_prc_trsp_mod_cd", getDaPrcTrspModCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("dih_flg", getDihFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rt_app_curr_cd", getRtAppCurrCd());
		this.hashColumns.put("rt_ras_note_conv_seq", getRtRasNoteConvSeq());
		this.hashColumns.put("oa_rout_pnt_loc_def_cd", getOaRoutPntLocDefCd());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oa_rat_ut_cd", getOaRatUtCd());
		this.hashColumns.put("rt_fnl_frt_rt_amt", getRtFnlFrtRtAmt());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dv_rout_via_port_def_cd", getDvRoutViaPortDefCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("rt_ras_frt_rt_amt", getRtRasFrtRtAmt());
		this.hashColumns.put("rt_ras_note_conv_mapg_id", getRtRasNoteConvMapgId());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("rt_typ_conv_ctnt", getRtTypConvCtnt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("da_bse_port_def_cd", getDaBsePortDefCd());
		this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
		this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
		this.hashColumns.put("rt_app_note_conv_tp_cd", getRtAppNoteConvTpCd());
		this.hashColumns.put("oa_max_cgo_wgt", getOaMaxCgoWgt());
		this.hashColumns.put("del_mtch_flg", getDelMtchFlg());
		this.hashColumns.put("op_rout_pnt_loc_def_cd", getOpRoutPntLocDefCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
		this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("trns_mod_cd", getTrnsModCd());
		this.hashColumns.put("bkg_bq_seq", getBkgBqSeq());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("rt_rat_ut_cd", getRtRatUtCd());
		this.hashColumns.put("rt_app_frt_rt_amt", getRtAppFrtRtAmt());
		this.hashColumns.put("rt_app_rt_op_cd", getRtAppRtOpCd());
		this.hashColumns.put("cmdt_seq", getCmdtSeq());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("oi_fnl_frt_rt_amt", getOiFnlFrtRtAmt());
		this.hashColumns.put("di_fnl_frt_rt_amt", getDiFnlFrtRtAmt());
		this.hashColumns.put("oi_rout_pnt_loc_def_cd", getOiRoutPntLocDefCd());
		this.hashColumns.put("oi_bse_port_def_cd", getOiBsePortDefCd());
		this.hashColumns.put("oi_rat_ut_cd", getOiRatUtCd());
		this.hashColumns.put("oi_prt_cgo_tp_cd", getOiPrcCgoTpCd());
		this.hashColumns.put("oi_prc_trsp_mod_cd", getOiPrcTrspModCd());
		this.hashColumns.put("oi_rcv_de_term_cd", getOiRcvDeTermCd());
		this.hashColumns.put("oi_curr_cd", getOiCurrCd());
		this.hashColumns.put("oi_calc_frt_rt_amt", getOiCalcFrtRtAmt());
		this.hashColumns.put("di_rout_pnt_loc_def_cd", getDiRoutPntLocDefCd());
		this.hashColumns.put("di_bse_port_def_cd", getDiBsePortDefCd());
		this.hashColumns.put("di_rat_ut_cd", getDiRatUtCd());
		this.hashColumns.put("di_prt_cgo_tp_cd", getDiPrcCgoTpCd());
		this.hashColumns.put("di_prc_trsp_mod_cd", getDiPrcTrspModCd());
		this.hashColumns.put("di_rcv_de_term_cd", getDiRcvDeTermCd());
		this.hashColumns.put("di_curr_cd", getDiCurrCd());
		this.hashColumns.put("di_calc_frt_rt_amt", getDiCalcFrtRtAmt());
		this.hashColumns.put("cnote_ctnt", getCnoteCtnt());
		this.hashColumns.put("snote_ctnt", getSnoteCtnt());
		this.hashColumns.put("arb_note_ctnt", getArbNoteCtnt());
		this.hashColumns.put("cnote", getCnote());
		this.hashColumns.put("snote", getSnote());
		this.hashColumns.put("arb_note", getArbNote());
		this.hashColumns.put("oi_fm", getOiFm());
		this.hashColumns.put("oa_fm", getOaFm());
		this.hashColumns.put("da_fm", getDaFm());
		this.hashColumns.put("di_fm", getDiFm());
		this.hashColumns.put("oi_min_cgo_wgt", getOiMinCgoWgt());
		this.hashColumns.put("oi_max_cgo_wgt", getOiMaxCgoWgt());
		this.hashColumns.put("di_min_cgo_wgt", getDiMinCgoWgt());
		this.hashColumns.put("di_max_cgo_wgt", getDiMaxCgoWgt());
		this.hashColumns.put("oi_frt_term_cd", getOiFrtTermCd());
		this.hashColumns.put("oa_frt_term_cd", getOaFrtTermCd());
		this.hashColumns.put("da_frt_term_cd", getDaFrtTermCd());
		this.hashColumns.put("di_frt_term_cd", getDiFrtTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oa_rac_conv_ctnt", "oaRacConvCtnt");
		this.hashFields.put("da_calc_frt_rt_amt", "daCalcFrtRtAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("oa_prc_trsp_mod_cd", "oaPrcTrspModCd");
		this.hashFields.put("da_add_chg_seq", "daAddChgSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oa_rcv_de_term_cd", "oaRcvDeTermCd");
		this.hashFields.put("rt_ras_conv_ctnt", "rtRasConvCtnt");
		this.hashFields.put("oa_prc_cgo_tp_cd", "oaPrcCgoTpCd");
		this.hashFields.put("da_rac_conv_ctnt", "daRacConvCtnt");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("ov_rout_via_port_def_cd", "ovRoutViaPortDefCd");
		this.hashFields.put("da_max_cgo_wgt", "daMaxCgoWgt");
		this.hashFields.put("oa_curr_cd", "oaCurrCd");
		this.hashFields.put("oih_flg", "oihFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("da_fnl_frt_rt_amt", "daFnlFrtRtAmt");
		this.hashFields.put("bq_pod_appl_flg", "bqPodApplFlg");
		this.hashFields.put("bq_seq", "bqSeq");
		this.hashFields.put("dp_prc_trsp_mod_cd", "dpPrcTrspModCd");
		this.hashFields.put("rt_app_bkg_conv_tp_cd", "rtAppBkgConvTpCd");
		this.hashFields.put("op_prc_trsp_mod_cd", "opPrcTrspModCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("oft_cmb_seq", "oftCmbSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("oa_fnl_frt_rt_amt", "oaFnlFrtRtAmt");
		this.hashFields.put("da_rat_ut_cd", "daRatUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cm_prc_cmdt_tp_cd", "cmPrcCmdtTpCd");
		this.hashFields.put("rt_calc_frt_rt_amt", "rtCalcFrtRtAmt");
		this.hashFields.put("prc_rt_seq", "prcRtSeq");
		this.hashFields.put("rt_app_note_conv_mapg_id", "rtAppNoteConvMapgId");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_ras_bkg_conv_tp_cd", "rtRasBkgConvTpCd");
		this.hashFields.put("rt_rar_conv_ctnt", "rtRarConvCtnt");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("rt_rac_conv_ctnt", "rtRacConvCtnt");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("da_prc_cgo_tp_cd", "daPrcCgoTpCd");
		this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("oa_calc_frt_rt_amt", "oaCalcFrtRtAmt");
		this.hashFields.put("rt_ras_note_conv_rule_cd", "rtRasNoteConvRuleCd");
		this.hashFields.put("rt_ras_curr_cd", "rtRasCurrCd");
		this.hashFields.put("rt_app_note_conv_seq", "rtAppNoteConvSeq");
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
		this.hashFields.put("da_min_cgo_wgt", "daMinCgoWgt");
		this.hashFields.put("incl_oft_flg", "inclOftFlg");
		this.hashFields.put("oa_typ_conv_ctnt", "oaTypConvCtnt");
		this.hashFields.put("bq_por_rly_port_appl_flg", "bqPorRlyPortApplFlg");
		this.hashFields.put("da_rout_pnt_loc_def_cd", "daRoutPntLocDefCd");
		this.hashFields.put("rt_curr_cd", "rtCurrCd");
		this.hashFields.put("oa_bse_port_def_cd", "oaBsePortDefCd");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cm_prc_cmdt_def_cd", "cmPrcCmdtDefCd");
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("bq_por_appl_flg", "bqPorApplFlg");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("por_mtch_flg", "porMtchFlg");
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
		this.hashFields.put("rt_app_note_conv_rule_cd", "rtAppNoteConvRuleCd");
		this.hashFields.put("in_ga_flg", "inGaFlg");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rt_rap_conv_ctnt", "rtRapConvCtnt");
		this.hashFields.put("prc_rt_mtch_patt_cd", "prcRtMtchPattCd");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("bq_pst_rly_port_appl_flg", "bqPstRlyPortApplFlg");
		this.hashFields.put("dp_rout_pnt_loc_def_cd", "dpRoutPntLocDefCd");
		this.hashFields.put("da_prc_trsp_mod_cd", "daPrcTrspModCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("dih_flg", "dihFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rt_app_curr_cd", "rtAppCurrCd");
		this.hashFields.put("rt_ras_note_conv_seq", "rtRasNoteConvSeq");
		this.hashFields.put("oa_rout_pnt_loc_def_cd", "oaRoutPntLocDefCd");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oa_rat_ut_cd", "oaRatUtCd");
		this.hashFields.put("rt_fnl_frt_rt_amt", "rtFnlFrtRtAmt");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dv_rout_via_port_def_cd", "dvRoutViaPortDefCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("rt_ras_frt_rt_amt", "rtRasFrtRtAmt");
		this.hashFields.put("rt_ras_note_conv_mapg_id", "rtRasNoteConvMapgId");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("rt_typ_conv_ctnt", "rtTypConvCtnt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("da_bse_port_def_cd", "daBsePortDefCd");
		this.hashFields.put("prc_rout_seq", "prcRoutSeq");
		this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
		this.hashFields.put("rt_app_note_conv_tp_cd", "rtAppNoteConvTpCd");
		this.hashFields.put("oa_max_cgo_wgt", "oaMaxCgoWgt");
		this.hashFields.put("del_mtch_flg", "delMtchFlg");
		this.hashFields.put("op_rout_pnt_loc_def_cd", "opRoutPntLocDefCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
		this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("trns_mod_cd", "trnsModCd");
		this.hashFields.put("bkg_bq_seq", "bkgBqSeq");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("rt_rat_ut_cd", "rtRatUtCd");
		this.hashFields.put("rt_app_frt_rt_amt", "rtAppFrtRtAmt");
		this.hashFields.put("rt_app_rt_op_cd", "rtAppRtOpCd");
		this.hashFields.put("cmdt_seq", "cmdtSeq");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("oi_fnl_frt_rt_amt", "oiFnlFrtRtAmt");
		this.hashFields.put("di_fnl_frt_rt_amt", "diFnlFrtRtAmt");
		this.hashFields.put("oi_rout_pnt_loc_def_cd", "oiRoutPntLocDefCd");
		this.hashFields.put("oi_bse_port_def_cd", "oiBsePortDefCd");
		this.hashFields.put("oi_rat_ut_cd", "oiRatUtCd");
		this.hashFields.put("oi_prt_cgo_tp_cd", "oiPrcCgoTpCd");
		this.hashFields.put("oi_prc_trsp_mod_cd", "oiPrcTrspModCd");
		this.hashFields.put("oi_rcv_de_term_cd", "oiRcvDeTermCd");
		this.hashFields.put("oi_curr_cd","oiCurrCd");
		this.hashFields.put("oi_calc_frt_rt_amt", "oiCalcFrtRtAmt");
		this.hashFields.put("di_rout_pnt_loc_def_cd", "diRoutPntLocDefCd");
		this.hashFields.put("di_bse_port_def_cd", "diBsePortDefCd");
		this.hashFields.put("di_rat_ut_cd", "diRatUtCd");
		this.hashFields.put("di_prt_cgo_tp_cd", "diPrcCgoTpCd");
		this.hashFields.put("di_prc_trsp_mod_cd", "diPrcTrspModCd");
		this.hashFields.put("di_rcv_de_term_cd", "diRcvDeTermCd");
		this.hashFields.put("di_curr_cd","diCurrCd");
		this.hashFields.put("di_calc_frt_rt_amt", "diCalcFrtRtAmt");
		this.hashFields.put("cnote_ctnt", "cnoteCtnt");
		this.hashFields.put("snote_ctnt", "snoteCtnt");
		this.hashFields.put("arb_note_ctnt", "arbNoteCtnt");
		this.hashFields.put("cnote", "cnote");
		this.hashFields.put("snote", "snote");
		this.hashFields.put("arb_note", "arbNote");
		this.hashFields.put("oi_fm", "oiFm");
		this.hashFields.put("oa_fm", "oaFm");
		this.hashFields.put("da_fm", "daFm");
		this.hashFields.put("di_fm", "diFm");
		this.hashFields.put("oi_min_cgo_wgt", "oiMinCgoWgt");
		this.hashFields.put("oi_max_cgo_wgt", "oiMaxCgoWgt");
		this.hashFields.put("di_min_cgo_wgt", "diMinCgoWgt");
		this.hashFields.put("di_max_cgo_wgt", "diMaxCgoWgt");
		this.hashFields.put("oi_frt_term_cd", "oiFrtTermCd");
		this.hashFields.put("oa_frt_term_cd", "oaFrtTermCd");
		this.hashFields.put("da_frt_term_cd", "daFrtTermCd");
		this.hashFields.put("di_frt_term_cd", "diFrtTermCd");
		return this.hashFields;
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
	 * @return daCalcFrtRtAmt
	 */
	public String getDaCalcFrtRtAmt() {
		return this.daCalcFrtRtAmt;
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
	 * @return daAddChgSeq
	 */
	public String getDaAddChgSeq() {
		return this.daAddChgSeq;
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
	 * @return dpPrcTrspModCd
	 */
	public String getDpPrcTrspModCd() {
		return this.dpPrcTrspModCd;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return daRatUtCd
	 */
	public String getDaRatUtCd() {
		return this.daRatUtCd;
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
	 * @return rtCalcFrtRtAmt
	 */
	public String getRtCalcFrtRtAmt() {
		return this.rtCalcFrtRtAmt;
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
	 * @return rtRasBkgConvTpCd
	 */
	public String getRtRasBkgConvTpCd() {
		return this.rtRasBkgConvTpCd;
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
	 * @return porMtchFlg
	 */
	public String getPorMtchFlg() {
		return this.porMtchFlg;
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
	 * @return dihFlg
	 */
	public String getDihFlg() {
		return this.dihFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return oaRatUtCd
	 */
	public String getOaRatUtCd() {
		return this.oaRatUtCd;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
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
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
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
	 * @return rtTypConvCtnt
	 */
	public String getRtTypConvCtnt() {
		return this.rtTypConvCtnt;
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
	 * @return daBsePortDefCd
	 */
	public String getDaBsePortDefCd() {
		return this.daBsePortDefCd;
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
	 * @return ctrtCntrTpszCd
	 */
	public String getCtrtCntrTpszCd() {
		return this.ctrtCntrTpszCd;
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
	 * @return eqSubstCntrTpszCd
	 */
	public String getEqSubstCntrTpszCd() {
		return this.eqSubstCntrTpszCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return bkgBqSeq
	 */
	public String getBkgBqSeq() {
		return this.bkgBqSeq;
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
	 * @return cmdtSeq
	 */
	public String getCmdtSeq() {
		return this.cmdtSeq;
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
	 * @return diFnlFrtRtAmt
	 */
	public String getDiFnlFrtRtAmt() {
		return this.diFnlFrtRtAmt;
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
	 * @return oiBsePortDefCd
	 */
	public String getOiBsePortDefCd() {
		return this.oiBsePortDefCd;
	}
	/**
	 * Column Info
	 * @return oiRatUtCd
	 */
	public String getOiRatUtCd() {
		return this.oiRatUtCd;
	}	/**
	 * Column Info
	 * @return oiPrcCgoTpCd
	 */
	public String getOiPrcCgoTpCd() {
		return this.oiPrcCgoTpCd;
	}	/**
	 * Column Info
	 * @return oiPrcTrspModCd
	 */
	public String getOiPrcTrspModCd() {
		return this.oiPrcTrspModCd;
	}	/**
	 * Column Info
	 * @return oiRcvDeTermCd
	 */
	public String getOiRcvDeTermCd() {
		return this.oiRcvDeTermCd;
	}	/**
	 * Column Info
	 * @return oiCurrCd
	 */
	public String getOiCurrCd() {
		return this.oiCurrCd;
	}	/**
	 * Column Info
	 * @return oiCalcFrtRtAmt
	 */
	public String getOiCalcFrtRtAmt() {
		return this.oiCalcFrtRtAmt;
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
	 * @return diBsePortDefCd
	 */
	public String getDiBsePortDefCd() {
		return this.diBsePortDefCd;
	}
	/**
	 * Column Info
	 * @return diRatUtCd
	 */
	public String getDiRatUtCd() {
		return this.diRatUtCd;
	}	/**
	 * Column Info
	 * @return diPrcCgoTpCd
	 */
	public String getDiPrcCgoTpCd() {
		return this.diPrcCgoTpCd;
	}	/**
	 * Column Info
	 * @return diPrcTrspModCd
	 */
	public String getDiPrcTrspModCd() {
		return this.diPrcTrspModCd;
	}	/**
	 * Column Info
	 * @return diRcvDeTermCd
	 */
	public String getDiRcvDeTermCd() {
		return this.diRcvDeTermCd;
	}	/**
	 * Column Info
	 * @return diCurrCd
	 */
	public String getDiCurrCd() {
		return this.diCurrCd;
	}	/**
	 * Column Info
	 * @return diCalcFrtRtAmt
	 */
	public String getDiCalcFrtRtAmt() {
		return this.diCalcFrtRtAmt;
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
	 * @param daCalcFrtRtAmt
	 */
	public void setDaCalcFrtRtAmt(String daCalcFrtRtAmt) {
		this.daCalcFrtRtAmt = daCalcFrtRtAmt;
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
	 * @param daAddChgSeq
	 */
	public void setDaAddChgSeq(String daAddChgSeq) {
		this.daAddChgSeq = daAddChgSeq;
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
	 * @param dpPrcTrspModCd
	 */
	public void setDpPrcTrspModCd(String dpPrcTrspModCd) {
		this.dpPrcTrspModCd = dpPrcTrspModCd;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param daRatUtCd
	 */
	public void setDaRatUtCd(String daRatUtCd) {
		this.daRatUtCd = daRatUtCd;
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
	 * @param rtCalcFrtRtAmt
	 */
	public void setRtCalcFrtRtAmt(String rtCalcFrtRtAmt) {
		this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
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
	 * @param rtRasBkgConvTpCd
	 */
	public void setRtRasBkgConvTpCd(String rtRasBkgConvTpCd) {
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
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
	 * @param porMtchFlg
	 */
	public void setPorMtchFlg(String porMtchFlg) {
		this.porMtchFlg = porMtchFlg;
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
	 * @param dihFlg
	 */
	public void setDihFlg(String dihFlg) {
		this.dihFlg = dihFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param oaRatUtCd
	 */
	public void setOaRatUtCd(String oaRatUtCd) {
		this.oaRatUtCd = oaRatUtCd;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
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
	 * @param rtTypConvCtnt
	 */
	public void setRtTypConvCtnt(String rtTypConvCtnt) {
		this.rtTypConvCtnt = rtTypConvCtnt;
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
	 * @param daBsePortDefCd
	 */
	public void setDaBsePortDefCd(String daBsePortDefCd) {
		this.daBsePortDefCd = daBsePortDefCd;
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
	 * @param ctrtCntrTpszCd
	 */
	public void setCtrtCntrTpszCd(String ctrtCntrTpszCd) {
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
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
	 * @param eqSubstCntrTpszCd
	 */
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param bkgBqSeq
	 */
	public void setBkgBqSeq(String bkgBqSeq) {
		this.bkgBqSeq = bkgBqSeq;
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
	 * @param cmdtSeq
	 */
	public void setCmdtSeq(String cmdtSeq) {
		this.cmdtSeq = cmdtSeq;
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
	 * @param diFnlFrtRtAmt
	 */
	public void setDiFnlFrtRtAmt(String diFnlFrtRtAmt) {
		this.diFnlFrtRtAmt = diFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return oiRoutPntLocDefCd
	 */
	public void setOiRoutPntLocDefCd(String oiRoutPntLocDefCd) {
		this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
	}
	/**
	 * Column Info
	 * @return oiBsePortDefCd
	 */
	public void setOiBsePortDefCd(String oiBsePortDefCd) {
		this.oiBsePortDefCd = oiBsePortDefCd;
	}
	/**
	 * Column Info
	 * @return oiRatUtCd
	 */
	public void setOiRatUtCd(String oiRatUtCd) {
		this.oiRatUtCd = oiRatUtCd;
	}	/**
	 * Column Info
	 * @return oiPrcCgoTpCd
	 */
	public void setOiPrcCgoTpCd(String oiPrcCgoTpCd) {
		this.oiPrcCgoTpCd = oiPrcCgoTpCd;
	}	/**
	 * Column Info
	 * @return oiPrcTrspModCd
	 */
	public void setOiPrcTrspModCd(String oiPrcTrspModCd) {
		this.oiPrcTrspModCd = oiPrcTrspModCd;
	}	/**
	 * Column Info
	 * @return oiRcvDeTermCd
	 */
	public void setOiRcvDeTermCd(String oiRcvDeTermCd) {
		this.oiRcvDeTermCd = oiRcvDeTermCd;
	}	/**
	 * Column Info
	 * @return oiCurrCd
	 */
	public void setOiCurrCd(String oiCurrCd) {
		this.oiCurrCd = oiCurrCd;
	}	/**
	 * Column Info
	 * @oiCalcFrtRtAmt
	 */
	public void setOiCalcFrtRtAmt(String oiCalcFrtRtAmt) {
		this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @diRoutPntLocDefCd
	 */
	public void setDiRoutPntLocDefCd(String diRoutPntLocDefCd) {
		this.diRoutPntLocDefCd = diRoutPntLocDefCd;
	}
	/**
	 * Column Info
	 * @diBsePortDefCd
	 */
	public void setDiBsePortDefCd(String diBsePortDefCd) {
		this.diBsePortDefCd = diBsePortDefCd;
	}
	/**
	 * Column Info
	 * @diRatUtCd
	 */
	public void setDiRatUtCd(String diRatUtCd) {
		this.diRatUtCd = diRatUtCd;
	}	/**
	 * Column Info
	 * @diPrcCgoTpCd
	 */
	public void setDiPrcCgoTpCd(String diPrcCgoTpCd) {
		this.diPrcCgoTpCd = diPrcCgoTpCd;
	}	/**
	 * Column Info
	 * @diPrcTrspModCd
	 */
	public void setDiPrcTrspModCd(String diPrcTrspModCd) {
		this.diPrcTrspModCd = diPrcTrspModCd;
	}	/**
	 * Column Info
	 * @diRcvDeTermCd
	 */
	public void setDiRcvDeTermCd(String diRcvDeTermCd) {
		this.diRcvDeTermCd = diRcvDeTermCd;
	}	/**
	 * Column Info
	 * @diCurrCd
	 */
	public void setDiCurrCd(String diCurrCd ) {
		this.diCurrCd = diCurrCd;
	}	/**
	 * Column Info
	 * @diCalcFrtRtAmt
	 */
	public void setDiCalcFrtRtAmt(String diCalcFrtRtAmt) {
		this.diCalcFrtRtAmt = diCalcFrtRtAmt;
	}
	
    public void setAutoRatFlg(String autoRatFlg) {
        this.autoRatFlg = autoRatFlg;
    }

    public String getAutoRatFlg() {
        return this.autoRatFlg;
    }
    
    /**
	 * @return the cnoteCtnt
	 */
	public String getCnoteCtnt() {
		return cnoteCtnt;
	}

	/**
	 * @param cnoteCtnt the cnoteCtnt to set
	 */
	public void setCnoteCtnt(String cnoteCtnt) {
		this.cnoteCtnt = cnoteCtnt;
	}

	/**
	 * @return the snoteCtnt
	 */
	public String getSnoteCtnt() {
		return snoteCtnt;
	}

	/**
	 * @param snoteCtnt the snoteCtnt to set
	 */
	public void setSnoteCtnt(String snoteCtnt) {
		this.snoteCtnt = snoteCtnt;
	}

	/**
	 * @return the arbNoteCtnt
	 */
	public String getArbNoteCtnt() {
		return arbNoteCtnt;
	}

	/**
	 * @param arbNoteCtnt the arbNoteCtnt to set
	 */
	public void setArbNoteCtnt(String arbNoteCtnt) {
		this.arbNoteCtnt = arbNoteCtnt;
	}

	/**
	 * @return the oiFm
	 */
	public String getOiFm() {
		return oiFm;
	}

	/**
	 * @param oiFm the oiFm to set
	 */
	public void setOiFm(String oiFm) {
		this.oiFm = oiFm;
	}

	/**
	 * @return the oaFm
	 */
	public String getOaFm() {
		return oaFm;
	}

	/**
	 * @param oaFm the oaFm to set
	 */
	public void setOaFm(String oaFm) {
		this.oaFm = oaFm;
	}

	/**
	 * @return the daFm
	 */
	public String getDaFm() {
		return daFm;
	}

	/**
	 * @param daFm the daFm to set
	 */
	public void setDaFm(String daFm) {
		this.daFm = daFm;
	}

	/**
	 * @return the diFm
	 */
	public String getDiFm() {
		return diFm;
	}

	/**
	 * @param diFm the diFm to set
	 */
	public void setDiFm(String diFm) {
		this.diFm = diFm;
	}
	
	/**
	 * @return the cnote
	 */
	public String getCnote() {
		return cnote;
	}

	/**
	 * @param cnote the cnote to set
	 */
	public void setCnote(String cnote) {
		this.cnote = cnote;
	}

	/**
	 * @return the snote
	 */
	public String getSnote() {
		return snote;
	}

	/**
	 * @param snote the snote to set
	 */
	public void setSnote(String snote) {
		this.snote = snote;
	}

	/**
	 * @return the arbNote
	 */
	public String getArbNote() {
		return arbNote;
	}

	/**
	 * @param arbNote the arbNote to set
	 */
	public void setArbNote(String arbNote) {
		this.arbNote = arbNote;
	}    

	public String getOiMinCgoWgt() {
		return oiMinCgoWgt;
	}

	public void setOiMinCgoWgt(String oiMinCgoWgt) {
		this.oiMinCgoWgt = oiMinCgoWgt;
	}

	public String getOiMaxCgoWgt() {
		return oiMaxCgoWgt;
	}

	public void setOiMaxCgoWgt(String oiMaxCgoWgt) {
		this.oiMaxCgoWgt = oiMaxCgoWgt;
	}

	public String getDiMinCgoWgt() {
		return diMinCgoWgt;
	}

	public void setDiMinCgoWgt(String diMinCgoWgt) {
		this.diMinCgoWgt = diMinCgoWgt;
	}

	public String getDiMaxCgoWgt() {
		return diMaxCgoWgt;
	}

	public void setDiMaxCgoWgt(String diMaxCgoWgt) {
		this.diMaxCgoWgt = diMaxCgoWgt;
	}
	
	/**
	 * @return the oiFrtTermCd
	 */
	public String getOiFrtTermCd() {
		return oiFrtTermCd;
	}

	/**
	 * @param oiFrtTermCd the oiFrtTermCd to set
	 */
	public void setOiFrtTermCd(String oiFrtTermCd) {
		this.oiFrtTermCd = oiFrtTermCd;
	}
	
	/**
	 * @return the oaFrtTermCd
	 */
	public String getOaFrtTermCd() {
		return oaFrtTermCd;
	}
	
	/**
	 * @param oaFrtTermCd the oaFrtTermCd to set
	 */
	public void setOaFrtTermCd(String oaFrtTermCd) {
		this.oaFrtTermCd = oaFrtTermCd;
	}
	
	/**
	 * @return the daFrtTermCd
	 */
	public String getDaFrtTermCd() {
		return daFrtTermCd;
	}
	
	/**
	 * @param daFrtTermCd the daFrtTermCd to set
	 */
	public void setDaFrtTermCd(String daFrtTermCd) {
		this.daFrtTermCd = daFrtTermCd;
	}
	
	/**
	 * @return the diFrtTermCd
	 */
	public String getDiFrtTermCd() {
		return diFrtTermCd;
	}
	
	/**
	 * @param diFrtTermCd the diFrtTermCd to set
	 */
	public void setDiFrtTermCd(String diFrtTermCd) {
		this.diFrtTermCd = diFrtTermCd;
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
		setOaRacConvCtnt(JSPUtil.getParameter(request, prefix + "oa_rac_conv_ctnt", ""));
		setDaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_calc_frt_rt_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setOaPrcTrspModCd(JSPUtil.getParameter(request, prefix + "oa_prc_trsp_mod_cd", ""));
		setDaAddChgSeq(JSPUtil.getParameter(request, prefix + "da_add_chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOaRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oa_rcv_de_term_cd", ""));
		setRtRasConvCtnt(JSPUtil.getParameter(request, prefix + "rt_ras_conv_ctnt", ""));
		setOaPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "oa_prc_cgo_tp_cd", ""));
		setDaRacConvCtnt(JSPUtil.getParameter(request, prefix + "da_rac_conv_ctnt", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setOvRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "ov_rout_via_port_def_cd", ""));
		setDaMaxCgoWgt(JSPUtil.getParameter(request, prefix + "da_max_cgo_wgt", ""));
		setOaCurrCd(JSPUtil.getParameter(request, prefix + "oa_curr_cd", ""));
		setOihFlg(JSPUtil.getParameter(request, prefix + "oih_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setDaFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_fnl_frt_rt_amt", ""));
		setBqPodApplFlg(JSPUtil.getParameter(request, prefix + "bq_pod_appl_flg", ""));
		setBqSeq(JSPUtil.getParameter(request, prefix + "bq_seq", ""));
		setDpPrcTrspModCd(JSPUtil.getParameter(request, prefix + "dp_prc_trsp_mod_cd", ""));
		setRtAppBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_app_bkg_conv_tp_cd", ""));
		setOpPrcTrspModCd(JSPUtil.getParameter(request, prefix + "op_prc_trsp_mod_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setOftCmbSeq(JSPUtil.getParameter(request, prefix + "oft_cmb_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOaFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_fnl_frt_rt_amt", ""));
		setDaRatUtCd(JSPUtil.getParameter(request, prefix + "da_rat_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCmPrcCmdtTpCd(JSPUtil.getParameter(request, prefix + "cm_prc_cmdt_tp_cd", ""));
		setRtCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_calc_frt_rt_amt", ""));
		setPrcRtSeq(JSPUtil.getParameter(request, prefix + "prc_rt_seq", ""));
		setRtAppNoteConvMapgId(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_mapg_id", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setRtRasBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_ras_bkg_conv_tp_cd", ""));
		setRtRarConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rar_conv_ctnt", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setRtRacConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rac_conv_ctnt", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setDaPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "da_prc_cgo_tp_cd", ""));
		setPrcCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "prc_cmdt_hdr_seq", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setOaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_calc_frt_rt_amt", ""));
		setRtRasNoteConvRuleCd(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_rule_cd", ""));
		setRtRasCurrCd(JSPUtil.getParameter(request, prefix + "rt_ras_curr_cd", ""));
		setRtAppNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_seq", ""));
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
		setDaMinCgoWgt(JSPUtil.getParameter(request, prefix + "da_min_cgo_wgt", ""));
		setInclOftFlg(JSPUtil.getParameter(request, prefix + "incl_oft_flg", ""));
		setOaTypConvCtnt(JSPUtil.getParameter(request, prefix + "oa_typ_conv_ctnt", ""));
		setBqPorRlyPortApplFlg(JSPUtil.getParameter(request, prefix + "bq_por_rly_port_appl_flg", ""));
		setDaRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "da_rout_pnt_loc_def_cd", ""));
		setRtCurrCd(JSPUtil.getParameter(request, prefix + "rt_curr_cd", ""));
		setOaBsePortDefCd(JSPUtil.getParameter(request, prefix + "oa_bse_port_def_cd", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCmPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "cm_prc_cmdt_def_cd", ""));
		setDryCgoFlg(JSPUtil.getParameter(request, prefix + "dry_cgo_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setBqPorApplFlg(JSPUtil.getParameter(request, prefix + "bq_por_appl_flg", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request, prefix + "org_trsp_mod_cd", ""));
		setPorMtchFlg(JSPUtil.getParameter(request, prefix + "por_mtch_flg", ""));
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
		setRtAppNoteConvRuleCd(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_rule_cd", ""));
		setInGaFlg(JSPUtil.getParameter(request, prefix + "in_ga_flg", ""));
		setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRtRapConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rap_conv_ctnt", ""));
		setPrcRtMtchPattCd(JSPUtil.getParameter(request, prefix + "prc_rt_mtch_patt_cd", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setBqPstRlyPortApplFlg(JSPUtil.getParameter(request, prefix + "bq_pst_rly_port_appl_flg", ""));
		setDpRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dp_rout_pnt_loc_def_cd", ""));
		setDaPrcTrspModCd(JSPUtil.getParameter(request, prefix + "da_prc_trsp_mod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDihFlg(JSPUtil.getParameter(request, prefix + "dih_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRtAppCurrCd(JSPUtil.getParameter(request, prefix + "rt_app_curr_cd", ""));
		setRtRasNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_seq", ""));
		setOaRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "oa_rout_pnt_loc_def_cd", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOaRatUtCd(JSPUtil.getParameter(request, prefix + "oa_rat_ut_cd", ""));
		setRtFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_fnl_frt_rt_amt", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDvRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dv_rout_via_port_def_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setPorCntCd(JSPUtil.getParameter(request, prefix + "por_cnt_cd", ""));
		setRtRasFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_ras_frt_rt_amt", ""));
		setRtRasNoteConvMapgId(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_mapg_id", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setRtTypConvCtnt(JSPUtil.getParameter(request, prefix + "rt_typ_conv_ctnt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setDaBsePortDefCd(JSPUtil.getParameter(request, prefix + "da_bse_port_def_cd", ""));
		setPrcRoutSeq(JSPUtil.getParameter(request, prefix + "prc_rout_seq", ""));
		setCtrtCntrTpszCd(JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd", ""));
		setRtAppNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_tp_cd", ""));
		setOaMaxCgoWgt(JSPUtil.getParameter(request, prefix + "oa_max_cgo_wgt", ""));
		setDelMtchFlg(JSPUtil.getParameter(request, prefix + "del_mtch_flg", ""));
		setOpRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "op_rout_pnt_loc_def_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setEqSubstCntrTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", ""));
		setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setTrnsModCd(JSPUtil.getParameter(request, prefix + "trns_mod_cd", ""));
		setBkgBqSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_seq", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
		setRtRatUtCd(JSPUtil.getParameter(request, prefix + "rt_rat_ut_cd", ""));
		setRtAppFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_app_frt_rt_amt", ""));
		setRtAppRtOpCd(JSPUtil.getParameter(request, prefix + "rt_app_rt_op_cd", ""));
		setCmdtSeq(JSPUtil.getParameter(request, prefix + "cmdt_seq", ""));
		setDiFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_fnl_frt_rt_amt", ""));
		setOiFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_fnl_frt_rt_amt", ""));
		setOiRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "oi_rout_pnt_loc_def_cd", ""));
		setOiBsePortDefCd(JSPUtil.getParameter(request, prefix + "oi_bse_port_def_cd", ""));
		setOiRatUtCd(JSPUtil.getParameter(request, prefix + "oi_rat_ut_cd", ""));
		setOiPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "oi_prc_cgo_tp_cd", ""));
		setOiPrcTrspModCd(JSPUtil.getParameter(request, prefix + "oi_prc_trsp_mod_cd", ""));
		setOiRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oi_rcv_de_term_cd", ""));
		setOiCurrCd(JSPUtil.getParameter(request, prefix + "oi_curr_cd", ""));
		setOiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_calc_frt_rt_amt", ""));
		setDiRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "di_rout_pnt_loc_def_cd", ""));
		setDiBsePortDefCd(JSPUtil.getParameter(request, prefix + "di_bse_port_def_cd", ""));
		setDiRatUtCd(JSPUtil.getParameter(request, prefix + "di_rat_ut_cd", ""));
		setDiPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "di_prc_cgo_tp_cd", ""));
		setDiPrcTrspModCd(JSPUtil.getParameter(request, prefix + "di_prc_trsp_mod_cd", ""));
		setDiRcvDeTermCd(JSPUtil.getParameter(request, prefix + "di_rcv_de_term_cd", ""));
		setDiCurrCd(JSPUtil.getParameter(request, prefix + "di_curr_cd", ""));
		setDiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_calc_frt_rt_amt", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setCnoteCtnt(JSPUtil.getParameter(request, prefix + "cnote_ctnt", ""));
		setSnoteCtnt(JSPUtil.getParameter(request, prefix + "snote_ctnt", ""));
		setArbNoteCtnt(JSPUtil.getParameter(request, prefix + "arb_note_ctnt", ""));
		setCnote(JSPUtil.getParameter(request, prefix + "cnote", ""));
		setSnote(JSPUtil.getParameter(request, prefix + "snote", ""));
		setArbNote(JSPUtil.getParameter(request, prefix + "arb_note", ""));
		setOiFm(JSPUtil.getParameter(request, prefix + "oi_fm", ""));
		setOaFm(JSPUtil.getParameter(request, prefix + "oa_fm", ""));
		setDaFm(JSPUtil.getParameter(request, prefix + "da_fm", ""));
		setDiFm(JSPUtil.getParameter(request, prefix + "di_fm", ""));
		setOiMinCgoWgt(JSPUtil.getParameter(request, prefix + "oi_min_cgo_wgt", ""));
		setOiMaxCgoWgt(JSPUtil.getParameter(request, prefix + "oi_max_cgo_wgt", ""));
		setDiMinCgoWgt(JSPUtil.getParameter(request, prefix + "di_min_cgo_wgt", ""));
		setDiMaxCgoWgt(JSPUtil.getParameter(request, prefix + "di_max_cgo_wgt", ""));
		setOiFrtTermCd(JSPUtil.getParameter(request, prefix + "oi_frt_term_cd", ""));
		setOaFrtTermCd(JSPUtil.getParameter(request, prefix + "oa_frt_term_cd", ""));
		setDaFrtTermCd(JSPUtil.getParameter(request, prefix + "da_frt_term_cd", ""));
		setDiFrtTermCd(JSPUtil.getParameter(request, prefix + "di_frt_term_cd", ""));
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
			String[] oaRacConvCtnt = (JSPUtil.getParameter(request, prefix	+ "oa_rac_conv_ctnt", length));
			String[] daCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_calc_frt_rt_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] oaPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_trsp_mod_cd", length));
			String[] daAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "da_add_chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oaRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oa_rcv_de_term_cd", length));
			String[] rtRasConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_ras_conv_ctnt", length));
			String[] oaPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_cgo_tp_cd", length));
			String[] daRacConvCtnt = (JSPUtil.getParameter(request, prefix	+ "da_rac_conv_ctnt", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ovRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ov_rout_via_port_def_cd", length));
			String[] daMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "da_max_cgo_wgt", length));
			String[] oaCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_curr_cd", length));
			String[] oihFlg = (JSPUtil.getParameter(request, prefix	+ "oih_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] daFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_fnl_frt_rt_amt", length));
			String[] bqPodApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pod_appl_flg", length));
			String[] bqSeq = (JSPUtil.getParameter(request, prefix	+ "bq_seq", length));
			String[] dpPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dp_prc_trsp_mod_cd", length));
			String[] rtAppBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_bkg_conv_tp_cd", length));
			String[] opPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "op_prc_trsp_mod_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] oftCmbSeq = (JSPUtil.getParameter(request, prefix	+ "oft_cmb_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] oaFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_fnl_frt_rt_amt", length));
			String[] daRatUtCd = (JSPUtil.getParameter(request, prefix	+ "da_rat_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmPrcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_tp_cd", length));
			String[] rtCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_calc_frt_rt_amt", length));
			String[] prcRtSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rt_seq", length));
			String[] rtAppNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_mapg_id", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rtRasBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_bkg_conv_tp_cd", length));
			String[] rtRarConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_rar_conv_ctnt", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] rtRacConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_rac_conv_ctnt", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] daPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_cgo_tp_cd", length));
			String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_hdr_seq", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] oaCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_calc_frt_rt_amt", length));
			String[] rtRasNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_rule_cd", length));
			String[] rtRasCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_curr_cd", length));
			String[] rtAppNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_seq", length));
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
			String[] daMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "da_min_cgo_wgt", length));
			String[] inclOftFlg = (JSPUtil.getParameter(request, prefix	+ "incl_oft_flg", length));
			String[] oaTypConvCtnt = (JSPUtil.getParameter(request, prefix	+ "oa_typ_conv_ctnt", length));
			String[] bqPorRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_rly_port_appl_flg", length));
			String[] daRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "da_rout_pnt_loc_def_cd", length));
			String[] rtCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_curr_cd", length));
			String[] oaBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_bse_port_def_cd", length));
			String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] cmPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_def_cd", length));
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] bqPorApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_appl_flg", length));
			String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_mod_cd", length));
			String[] porMtchFlg = (JSPUtil.getParameter(request, prefix	+ "por_mtch_flg", length));
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
			String[] rtAppNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_rule_cd", length));
			String[] inGaFlg = (JSPUtil.getParameter(request, prefix	+ "in_ga_flg", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rtRapConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_rap_conv_ctnt", length));
			String[] prcRtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] bqPstRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pst_rly_port_appl_flg", length));
			String[] dpRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dp_rout_pnt_loc_def_cd", length));
			String[] daPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_trsp_mod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] dihFlg = (JSPUtil.getParameter(request, prefix	+ "dih_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rtAppCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_curr_cd", length));
			String[] rtRasNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_seq", length));
			String[] oaRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_rout_pnt_loc_def_cd", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oaRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oa_rat_ut_cd", length));
			String[] rtFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_fnl_frt_rt_amt", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dvRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dv_rout_via_port_def_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] rtRasFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_ras_frt_rt_amt", length));
			String[] rtRasNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_mapg_id", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] rtTypConvCtnt = (JSPUtil.getParameter(request, prefix	+ "rt_typ_conv_ctnt", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] daBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "da_bse_port_def_cd", length));
			String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rout_seq", length));
			String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd", length));
			String[] rtAppNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_tp_cd", length));
			String[] oaMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oa_max_cgo_wgt", length));
			String[] delMtchFlg = (JSPUtil.getParameter(request, prefix	+ "del_mtch_flg", length));
			String[] opRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "op_rout_pnt_loc_def_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cntr_tpsz_cd", length));
			String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix	+ "frt_incl_xcld_div_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] trnsModCd = (JSPUtil.getParameter(request, prefix	+ "trns_mod_cd", length));
			String[] bkgBqSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_seq", length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix	+ "frt_rt_amt", length));
			String[] rtRatUtCd = (JSPUtil.getParameter(request, prefix	+ "rt_rat_ut_cd", length));
			String[] rtAppFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_app_frt_rt_amt", length));
			String[] rtAppRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_rt_op_cd", length));
			String[] cmdtSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_seq", length));
			String[] diFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_fnl_frt_rt_amt", length));
			String[] oiFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_fnl_frt_rt_amt", length));
			
			String[] oiRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_rout_pnt_loc_def_cd", length));
			String[] oiBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_bse_port_def_cd", length));
			String[] oiRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oi_rat_ut_cd", length));
			String[] oiPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_cgo_tp_cd", length));
			String[] oiPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_trsp_mod_cd", length));
			String[] oiRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oi_rcv_de_term_cd", length));
			String[] oiCurrCd = (JSPUtil.getParameter(request, prefix	+ "oi_curr_cd", length));
			String[] oiCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_calc_frt_rt_amt", length));
			
			String[] diRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "di_rout_pnt_loc_def_cd", length));
			String[] diBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "di_bse_port_def_cd", length));
			String[] diRatUtCd = (JSPUtil.getParameter(request, prefix	+ "di_rat_ut_cd", length));
			String[] diPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_cgo_tp_cd", length));
			String[] diPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_trsp_mod_cd", length));
			String[] diRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "di_rcv_de_term_cd", length));
			String[] diCurrCd = (JSPUtil.getParameter(request, prefix	+ "di_curr_cd", length));
			String[] diCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_calc_frt_rt_amt", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] cnoteCtnt = (JSPUtil.getParameter(request, prefix	+ "cnote_ctnt", length));
			String[] snoteCtnt = (JSPUtil.getParameter(request, prefix	+ "snote_ctnt", length));
			String[] arbNoteCtnt = (JSPUtil.getParameter(request, prefix	+ "arb_note_ctnt", length));
			String[] cnote = (JSPUtil.getParameter(request, prefix	+ "cnote", length));
			String[] snote = (JSPUtil.getParameter(request, prefix	+ "snote", length));
			String[] arbNote = (JSPUtil.getParameter(request, prefix	+ "arb_note", length));
			String[] oiFm = (JSPUtil.getParameter(request, prefix	+ "oi_fm", length));
			String[] oaFm = (JSPUtil.getParameter(request, prefix	+ "oa_fm", length));
			String[] daFm = (JSPUtil.getParameter(request, prefix	+ "da_fm", length));
			String[] diFm = (JSPUtil.getParameter(request, prefix	+ "di_fm", length));
			String[] oiMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oi_min_cgo_wgt", length));
			String[] oiMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oi_max_cgo_wgt", length));
			String[] diMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "di_min_cgo_wgt", length));
			String[] diMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "di_max_cgo_wgt", length));
			String[] oiFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "oi_frt_term_cd", length));
			String[] oaFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "oa_frt_term_cd", length));
			String[] daFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "da_frt_term_cd", length));
			String[] diFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "di_frt_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRfaOftAutoratingListVO();
				if (oaRacConvCtnt[i] != null)
					model.setOaRacConvCtnt(oaRacConvCtnt[i]);
				if (daCalcFrtRtAmt[i] != null)
					model.setDaCalcFrtRtAmt(daCalcFrtRtAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (oaPrcTrspModCd[i] != null)
					model.setOaPrcTrspModCd(oaPrcTrspModCd[i]);
				if (daAddChgSeq[i] != null)
					model.setDaAddChgSeq(daAddChgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oaRcvDeTermCd[i] != null)
					model.setOaRcvDeTermCd(oaRcvDeTermCd[i]);
				if (rtRasConvCtnt[i] != null)
					model.setRtRasConvCtnt(rtRasConvCtnt[i]);
				if (oaPrcCgoTpCd[i] != null)
					model.setOaPrcCgoTpCd(oaPrcCgoTpCd[i]);
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
				if (dpPrcTrspModCd[i] != null)
					model.setDpPrcTrspModCd(dpPrcTrspModCd[i]);
				if (rtAppBkgConvTpCd[i] != null)
					model.setRtAppBkgConvTpCd(rtAppBkgConvTpCd[i]);
				if (opPrcTrspModCd[i] != null)
					model.setOpPrcTrspModCd(opPrcTrspModCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (oftCmbSeq[i] != null)
					model.setOftCmbSeq(oftCmbSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (oaFnlFrtRtAmt[i] != null)
					model.setOaFnlFrtRtAmt(oaFnlFrtRtAmt[i]);
				if (daRatUtCd[i] != null)
					model.setDaRatUtCd(daRatUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmPrcCmdtTpCd[i] != null)
					model.setCmPrcCmdtTpCd(cmPrcCmdtTpCd[i]);
				if (rtCalcFrtRtAmt[i] != null)
					model.setRtCalcFrtRtAmt(rtCalcFrtRtAmt[i]);
				if (prcRtSeq[i] != null)
					model.setPrcRtSeq(prcRtSeq[i]);
				if (rtAppNoteConvMapgId[i] != null)
					model.setRtAppNoteConvMapgId(rtAppNoteConvMapgId[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtRasBkgConvTpCd[i] != null)
					model.setRtRasBkgConvTpCd(rtRasBkgConvTpCd[i]);
				if (rtRarConvCtnt[i] != null)
					model.setRtRarConvCtnt(rtRarConvCtnt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (rtRacConvCtnt[i] != null)
					model.setRtRacConvCtnt(rtRacConvCtnt[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
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
				if (daMinCgoWgt[i] != null)
					model.setDaMinCgoWgt(daMinCgoWgt[i]);
				if (inclOftFlg[i] != null)
					model.setInclOftFlg(inclOftFlg[i]);
				if (oaTypConvCtnt[i] != null)
					model.setOaTypConvCtnt(oaTypConvCtnt[i]);
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
				if (porMtchFlg[i] != null)
					model.setPorMtchFlg(porMtchFlg[i]);
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
				if (rtRapConvCtnt[i] != null)
					model.setRtRapConvCtnt(rtRapConvCtnt[i]);
				if (prcRtMtchPattCd[i] != null)
					model.setPrcRtMtchPattCd(prcRtMtchPattCd[i]);
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
				if (dihFlg[i] != null)
					model.setDihFlg(dihFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rtAppCurrCd[i] != null)
					model.setRtAppCurrCd(rtAppCurrCd[i]);
				if (rtRasNoteConvSeq[i] != null)
					model.setRtRasNoteConvSeq(rtRasNoteConvSeq[i]);
				if (oaRoutPntLocDefCd[i] != null)
					model.setOaRoutPntLocDefCd(oaRoutPntLocDefCd[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oaRatUtCd[i] != null)
					model.setOaRatUtCd(oaRatUtCd[i]);
				if (rtFnlFrtRtAmt[i] != null)
					model.setRtFnlFrtRtAmt(rtFnlFrtRtAmt[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dvRoutViaPortDefCd[i] != null)
					model.setDvRoutViaPortDefCd(dvRoutViaPortDefCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (rtRasFrtRtAmt[i] != null)
					model.setRtRasFrtRtAmt(rtRasFrtRtAmt[i]);
				if (rtRasNoteConvMapgId[i] != null)
					model.setRtRasNoteConvMapgId(rtRasNoteConvMapgId[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (rtTypConvCtnt[i] != null)
					model.setRtTypConvCtnt(rtTypConvCtnt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (daBsePortDefCd[i] != null)
					model.setDaBsePortDefCd(daBsePortDefCd[i]);
				if (prcRoutSeq[i] != null)
					model.setPrcRoutSeq(prcRoutSeq[i]);
				if (ctrtCntrTpszCd[i] != null)
					model.setCtrtCntrTpszCd(ctrtCntrTpszCd[i]);
				if (rtAppNoteConvTpCd[i] != null)
					model.setRtAppNoteConvTpCd(rtAppNoteConvTpCd[i]);
				if (oaMaxCgoWgt[i] != null)
					model.setOaMaxCgoWgt(oaMaxCgoWgt[i]);
				if (delMtchFlg[i] != null)
					model.setDelMtchFlg(delMtchFlg[i]);
				if (opRoutPntLocDefCd[i] != null)
					model.setOpRoutPntLocDefCd(opRoutPntLocDefCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (eqSubstCntrTpszCd[i] != null)
					model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (frtInclXcldDivCd[i] != null)
					model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (trnsModCd[i] != null)
					model.setTrnsModCd(trnsModCd[i]);
				if (bkgBqSeq[i] != null)
					model.setBkgBqSeq(bkgBqSeq[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (rtRatUtCd[i] != null)
					model.setRtRatUtCd(rtRatUtCd[i]);
				if (rtAppFrtRtAmt[i] != null)
					model.setRtAppFrtRtAmt(rtAppFrtRtAmt[i]);
				if (rtAppRtOpCd[i] != null)
					model.setRtAppRtOpCd(rtAppRtOpCd[i]);
				if (cmdtSeq[i] != null)
					model.setCmdtSeq(cmdtSeq[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (oiFnlFrtRtAmt[i] != null)
					model.setOiFnlFrtRtAmt(oiFnlFrtRtAmt[i]);
				if (oiFnlFrtRtAmt[i] != null)
					model.setOiFnlFrtRtAmt(diFnlFrtRtAmt[i]);
				if (oiRoutPntLocDefCd[i] != null)
					model.setOiRoutPntLocDefCd(oiRoutPntLocDefCd[i]);
				if (oiBsePortDefCd[i] != null)
					model.setOiBsePortDefCd(oiBsePortDefCd[i]);
				if (oiRatUtCd[i] != null)
					model.setOiRatUtCd(oiRatUtCd[i]);
				if (oiPrcCgoTpCd[i] != null)
					model.setOiPrcCgoTpCd(oiPrcCgoTpCd[i]);
				if (oiPrcTrspModCd[i] != null)
					model.setOiPrcTrspModCd(oiPrcTrspModCd[i]);
				if (oiRcvDeTermCd[i] != null)
					model.setOiFnlFrtRtAmt(oiRcvDeTermCd[i]);
				if (oiCurrCd[i] != null)
					model.setOiCurrCd(oiCurrCd[i]);
				if (oiCalcFrtRtAmt[i] != null)
					model.setOiCalcFrtRtAmt(oiCalcFrtRtAmt[i]);
				if (diFnlFrtRtAmt[i] != null)
					model.setDiFnlFrtRtAmt(diFnlFrtRtAmt[i]);
				if (diRoutPntLocDefCd[i] != null)
					model.setDiRoutPntLocDefCd(diRoutPntLocDefCd[i]);
				if (diBsePortDefCd[i] != null)
					model.setDiBsePortDefCd(diBsePortDefCd[i]);
				if (diRatUtCd[i] != null)
					model.setDiRatUtCd(diRatUtCd[i]);
				if (diPrcCgoTpCd[i] != null)
					model.setDiPrcCgoTpCd(diPrcCgoTpCd[i]);
				if (diPrcTrspModCd[i] != null)
					model.setDiPrcTrspModCd(diPrcTrspModCd[i]);
				if (diRcvDeTermCd[i] != null)
					model.setDiFnlFrtRtAmt(diRcvDeTermCd[i]);
				if (diCurrCd[i] != null)
					model.setDiCurrCd(diCurrCd[i]);
				if (diCalcFrtRtAmt[i] != null)
					model.setDiCalcFrtRtAmt(diCalcFrtRtAmt[i]);
				if (cnoteCtnt[i] != null)
					model.setCnoteCtnt(cnoteCtnt[i]);
				if (snoteCtnt[i] != null)
					model.setSnoteCtnt(snoteCtnt[i]);
				if (arbNoteCtnt[i] != null)
					model.setArbNoteCtnt(arbNoteCtnt[i]);
				if (cnote[i] != null)
					model.setCnote(cnote[i]);
				if (snote[i] != null)
					model.setSnote(snote[i]);
				if (arbNote[i] != null)
					model.setArbNote(arbNote[i]);
				if (oiFm[i] != null)
					model.setOiFm(oiFm[i]);
				if (oaFm[i] != null)
					model.setOaFm(oaFm[i]);
				if (daFm[i] != null)
					model.setDaFm(daFm[i]);
				if (diFm[i] != null)
					model.setDiFm(diFm[i]);
				if (oiMinCgoWgt[i] != null)
					model.setOiMinCgoWgt(oiMinCgoWgt[i]);
				if (oiMaxCgoWgt[i] != null)
					model.setOiMaxCgoWgt(oiMaxCgoWgt[i]);
				if (diMinCgoWgt[i] != null)
					model.setDiMinCgoWgt(diMinCgoWgt[i]);
				if (diMaxCgoWgt[i] != null)
					model.setDiMaxCgoWgt(diMaxCgoWgt[i]);
				if (oiFrtTermCd[i] != null)
					model.setOiFrtTermCd(oiFrtTermCd[i]);
				if (oaFrtTermCd[i] != null)
					model.setOaFrtTermCd(oaFrtTermCd[i]);
				if (daFrtTermCd[i] != null)
					model.setDaFrtTermCd(daFrtTermCd[i]);
				if (diFrtTermCd[i] != null)
					model.setDiFrtTermCd(diFrtTermCd[i]);
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
		this.oaRacConvCtnt = this.oaRacConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCalcFrtRtAmt = this.daCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcTrspModCd = this.oaPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daAddChgSeq = this.daAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRcvDeTermCd = this.oaRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasConvCtnt = this.rtRasConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcCgoTpCd = this.oaPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacConvCtnt = this.daRacConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRoutViaPortDefCd = this.ovRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daMaxCgoWgt = this.daMaxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCurrCd = this.oaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oihFlg = this.oihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daFnlFrtRtAmt = this.daFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPodApplFlg = this.bqPodApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqSeq = this.bqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcTrspModCd = this.dpPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppBkgConvTpCd = this.rtAppBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opPrcTrspModCd = this.opPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCmbSeq = this.oftCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaFnlFrtRtAmt = this.oaFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRatUtCd = this.daRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtTpCd = this.cmPrcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCalcFrtRtAmt = this.rtCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtSeq = this.prcRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvMapgId = this.rtAppNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasBkgConvTpCd = this.rtRasBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarConvCtnt = this.rtRarConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacConvCtnt = this.rtRacConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcCgoTpCd = this.daPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtHdrSeq = this.prcCmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCalcFrtRtAmt = this.oaCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvRuleCd = this.rtRasNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasCurrCd = this.rtRasCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvSeq = this.rtAppNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.daMinCgoWgt = this.daMinCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inclOftFlg = this.inclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypConvCtnt = this.oaTypConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorRlyPortApplFlg = this.bqPorRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRoutPntLocDefCd = this.daRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurrCd = this.rtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaBsePortDefCd = this.oaBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd = this.prcHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtDefCd = this.cmPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorApplFlg = this.bqPorApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd = this.orgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porMtchFlg = this.porMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.rtAppNoteConvRuleCd = this.rtAppNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inGaFlg = this.inGaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapConvCtnt = this.rtRapConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd = this.prcRtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPstRlyPortApplFlg = this.bqPstRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpRoutPntLocDefCd = this.dpRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcTrspModCd = this.daPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dihFlg = this.dihFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppCurrCd = this.rtAppCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvSeq = this.rtRasNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRoutPntLocDefCd = this.oaRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRatUtCd = this.oaRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFnlFrtRtAmt = this.rtFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvRoutViaPortDefCd = this.dvRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasFrtRtAmt = this.rtRasFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvMapgId = this.rtRasNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypConvCtnt = this.rtTypConvCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daBsePortDefCd = this.daBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRoutSeq = this.prcRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd = this.ctrtCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvTpCd = this.rtAppNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaMaxCgoWgt = this.oaMaxCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delMtchFlg = this.delMtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opRoutPntLocDefCd = this.opRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInclXcldDivCd = this.frtInclXcldDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModCd = this.trnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqSeq = this.bkgBqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRatUtCd = this.rtRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppFrtRtAmt = this.rtAppFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppRtOpCd = this.rtAppRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtSeq = this.cmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFnlFrtRtAmt = this.oiFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFnlFrtRtAmt = this.diFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRoutPntLocDefCd = this.oiRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiBsePortDefCd = this.oiBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRatUtCd = this.oiRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcCgoTpCd = this.oiPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcTrspModCd = this.oiPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRcvDeTermCd = this.oiRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCurrCd = this.oiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCalcFrtRtAmt = this.oiCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRoutPntLocDefCd = this.diRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diBsePortDefCd = this.diBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRatUtCd = this.diRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcCgoTpCd = this.diPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcTrspModCd = this.diPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRcvDeTermCd = this.diRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCurrCd = this.diCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCalcFrtRtAmt = this.diCalcFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnoteCtnt = this.cnoteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.snoteCtnt = this.snoteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arbNoteCtnt = this.arbNoteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnote = this.cnote.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.snote = this.snote.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.arbNote = this.arbNote.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiFm = this.oiFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaFm = this.oaFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daFm = this.daFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diFm = this.diFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiMinCgoWgt = this.oiMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiMaxCgoWgt = this.oiMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diMinCgoWgt = this.diMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diMaxCgoWgt = this.diMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiFrtTermCd = this.oiFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaFrtTermCd = this.oaFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daFrtTermCd = this.daFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diFrtTermCd = this.diFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
