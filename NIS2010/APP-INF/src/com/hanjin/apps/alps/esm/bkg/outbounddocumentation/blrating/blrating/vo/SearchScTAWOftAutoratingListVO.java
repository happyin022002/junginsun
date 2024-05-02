/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchScTAWOftAutoratingListVO.java
*@FileTitle : SearchScTAWOftAutoratingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.04  
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

public class SearchScTAWOftAutoratingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScTAWOftAutoratingListVO> models = new ArrayList<SearchScTAWOftAutoratingListVO>();
	
	/* Column Info */
	private String oaTypBkgConvTpCd = null;
	/* Column Info */
	private String daTypNoteConvMapgId = null;
	/* Column Info */
	private String oaPrcTrspModCd = null;
	/* Column Info */
	private String daAddChgSeq = null;
	/* Column Info */
	private String diPrcTrspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String daTypBkgConvTpCd = null;
	/* Column Info */
	private String oaRcvDeTermCd = null;
	/* Column Info */
	private String rtTypNoteConvRuleCd = null;
	/* Column Info */
	private String daTypNoteConvSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ovRoutViaPortDefCd = null;
	/* Column Info */
	private String oaCurrCd = null;
	/* Column Info */
	private String daFnlFrtRtAmt = null;
	/* Column Info */
	private String rtRarBkgConvTpCd = null;
	/* Column Info */
	private String daRacDaOpCd = null;
	/* Column Info */
	private String bqSeq = null;
	/* Column Info */
	private String dpPrcTrspModCd = null;
	/* Column Info */
	private String rtAppBkgConvTpCd = null;
	/* Column Info */
	private String opPrcTrspModCd = null;
	/* Column Info */
	private String oaRacFrtRtAmt = null;
	/* Column Info */
	private String diRcvDeTermCd = null;
	/* Column Info */
	private String cmPrcCmdtTpCd = null;
	/* Column Info */
	private String oaTypRtOpCd = null;
	/* Column Info */
	private String oaRacBkgConvTpCd = null;
	/* Column Info */
	private String rtRarCurrCd = null;
	/* Column Info */
	private String diCurrCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String oaTypNoteConvRuleCd = null;
	/* Column Info */
	private String rtRasBkgConvTpCd = null;
	/* Column Info */
	private String rtRapCurrCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String oiRatUtCd = null;
	/* Column Info */
	private String rtRacCurrCd = null;
	/* Column Info */
	private String oaRacCurrCd = null;
	/* Column Info */
	private String daTypDaOpCd = null;
	/* Column Info */
	private String rtDorNoteConvTpCd = null;
	/* Column Info */
	private String daRacBkgConvTpCd = null;
	/* Column Info */
	private String oaRacNoteConvMapgId = null;
	/* Column Info */
	private String daRacNoteConvRuleCd = null;
	/* Column Info */
	private String rtAppNoteConvSeq = null;
	/* Column Info */
	private String rtRasNoteConvTpCd = null;
	/* Column Info */
	private String rtPrcCgoTpCd = null;
	/* Column Info */
	private String rtRacFrtRtAmt = null;
	/* Column Info */
	private String rtAddRtOpCd = null;
	/* Column Info */
	private String diDirCallFlg = null;
	/* Column Info */
	private String rtRapFrtRtAmt = null;
	/* Column Info */
	private String rtRacNoteConvSeq = null;
	/* Column Info */
	private String bqDelApplFlg = null;
	/* Column Info */
	private String daRcvDeTermCd = null;
	/* Column Info */
	private String daTypFrtRtAmt = null;
	/* Column Info */
	private String rtDorNoteConvRuleCd = null;
	/* Column Info */
	private String oaTypNoteConvMapgId = null;
	/* Column Info */
	private String rtArbRtOpCd = null;
	/* Column Info */
	private String bqPorRlyPortApplFlg = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String cmPrcCmdtDefCd = null;
	/* Column Info */
	private String rtRapBkgConvTpCd = null;
	/* Column Info */
	private String bqPorApplFlg = null;
	/* Column Info */
	private String diPrcCgoTpCd = null;
	/* Column Info */
	private String rtArbNoteConvMapgId = null;
	/* Column Info */
	private String dtl = null;
	/* Column Info */
	private String bqPolApplFlg = null;
	/* Column Info */
	private String destTrspModCd = null;
	/* Column Info */
	private String rtRasRtOpCd = null;
	/* Column Info */
	private String prcGenSpclRtTpCd = null;
	/* Column Info */
	private String rtRarNoteConvTpCd = null;
	/* Column Info */
	private String oiPrcCmdtDefCd = null;
	/* Column Info */
	private String diFnlFrtRtAmt = null;
	/* Column Info */
	private String rtAppNoteConvRuleCd = null;
	/* Column Info */
	private String oaRacNoteConvRuleCd = null;
	/* Column Info */
	private String oiPrcCgoTpCd = null;
	/* Column Info */
	private String oiAddChgSeq = null;
	/* Column Info */
	private String daPrcTrspModCd = null;
	/* Column Info */
	private String rtRarRtOpCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rtRapNoteConvRuleCd = null;
	/* Column Info */
	private String rtAppCurrCd = null;
	/* Column Info */
	private String rtRasNoteConvSeq = null;
	/* Column Info */
	private String daDirCallFlg = null;
	/* Column Info */
	private String oaRoutPntLocDefCd = null;
	/* Column Info */
	private String rtTypFrtRtAmt = null;
	/* Column Info */
	private String rtTypNoteConvMapgId = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String oaRatUtCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtFnlFrtRtAmt = null;
	/* Column Info */
	private String oaTypNoteConvTpCd = null;
	/* Column Info */
	private String dvRoutViaPortDefCd = null;
	/* Column Info */
	private String rtDorNoteConvSeq = null;
	/* Column Info */
	private String rtArbNoteConvTpCd = null;
	/* Column Info */
	private String rtRasNoteConvMapgId = null;
	/* Column Info */
	private String daBsePortDefCd = null;
	/* Column Info */
	private String daRacFrtRtAmt = null;
	/* Column Info */
	private String prcRoutSeq = null;
	/* Column Info */
	private String ctrtCntrTpszCd = null;
	/* Column Info */
	private String oiPrcTrspModCd = null;
	/* Column Info */
	private String rtRarNoteConvMapgId = null;
	/* Column Info */
	private String opRoutPntLocDefCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String daTypCurrCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String daPrcCmdtDefCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgBqSeq = null;
	/* Column Info */
	private String trnsModCd = null;
	/* Column Info */
	private String oaTypCurrCd = null;
	/* Column Info */
	private String rtRatUtCd = null;
	/* Column Info */
	private String daTypNoteConvTpCd = null;
	/* Column Info */
	private String rtAddBkgConvTpCd = null;
	/* Column Info */
	private String rtAppFrtRtAmt = null;
	/* Column Info */
	private String oaRacNoteConvSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtDorFrtRtAmt = null;
	/* Column Info */
	private String oaPrcCgoTpCd = null;
	/* Column Info */
	private String oaPrcCmdtDefCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String oiRoutPntLocDefCd = null;
	/* Column Info */
	private String oiDirCallFlg = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String bqPodApplFlg = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String daViaPortDefCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String daRatUtCd = null;
	/* Column Info */
	private String oaFnlFrtRtAmt = null;
	/* Column Info */
	private String diRatUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String prcRtSeq = null;
	/* Column Info */
	private String rtRarFrtRtAmt = null;
	/* Column Info */
	private String oaDirCallFlg = null;
	/* Column Info */
	private String rtAppNoteConvMapgId = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String rtArbFrtRtAmt = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtDorCurrCd = null;
	/* Column Info */
	private String rtRacNoteConvTpCd = null;
	/* Column Info */
	private String daPrcCgoTpCd = null;
	/* Column Info */
	private String prcCmdtHdrSeq = null;
	/* Column Info */
	private String rtRarNoteConvRuleCd = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String rtRasNoteConvRuleCd = null;
	/* Column Info */
	private String rtRasCurrCd = null;
	/* Column Info */
	private String rtArbNoteConvSeq = null;
	/* Column Info */
	private String daRacNoteConvSeq = null;
	/* Column Info */
	private String rtTypNoteConvSeq = null;
	/* Column Info */
	private String oaAddChgSeq = null;
	/* Column Info */
	private String note = null;
	/* Column Info */
	private String rtAddNoteConvTpCd = null;
	/* Column Info */
	private String rtTypCurrCd = null;
	/* Column Info */
	private String rtAddNoteConvSeq = null;
	/* Column Info */
	private String rtDorRtOpCd = null;
	/* Column Info */
	private String rtRarNoteConvSeq = null;
	/* Column Info */
	private String rtDorNoteConvMapgId = null;
	/* Column Info */
	private String rtArbCurrCd = null;
	/* Column Info */
	private String diAddChgSeq = null;
	/* Column Info */
	private String daRoutPntLocDefCd = null;
	/* Column Info */
	private String oaBsePortDefCd = null;
	/* Column Info */
	private String rtCurrCd = null;
	/* Column Info */
	private String rtAddNoteConvRuleCd = null;
	/* Column Info */
	private String oiCurrCd = null;
	/* Column Info */
	private String rtRacBkgConvTpCd = null;
	/* Column Info */
	private String oiFnlFrtRtAmt = null;
	/* Column Info */
	private String rtTypNoteConvTpCd = null;
	/* Column Info */
	private String rtRacNoteConvMapgId = null;
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String rtAddFrtRtAmt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String rtRapNoteConvSeq = null;
	/* Column Info */
	private String orgTrspModCd = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rtAddCurrCd = null;
	/* Column Info */
	private String oaRacNoteConvTpCd = null;
	/* Column Info */
	private String rtMtchPattCd = null;
	/* Column Info */
	private String daCurrCd = null;
	/* Column Info */
	private String rtArbNoteConvRuleCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rtRacRtOpCd = null;
	/* Column Info */
	private String oaRacRtOpCd = null;
	/* Column Info */
	private String rtRapNoteConvTpCd = null;
	/* Column Info */
	private String diRoutPntLocDefCd = null;
	/* Column Info */
	private String oaTypFrtRtAmt = null;
	/* Column Info */
	private String prcRtMtchPattCd = null;
	/* Column Info */
	private String bqPstRlyPortApplFlg = null;
	/* Column Info */
	private String dpRoutPntLocDefCd = null;
	/* Column Info */
	private String daRacNoteConvMapgId = null;
	/* Column Info */
	private String rtTypRtOpCd = null;
	/* Column Info */
	private String rdDirCallFlg = null;
	/* Column Info */
	private String oiRcvDeTermCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String oaTypNoteConvSeq = null;
	/* Column Info */
	private String rtRapRtOpCd = null;
	/* Column Info */
	private String daRacCurrCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String rtDorBkgConvTpCd = null;
	/* Column Info */
	private String rtRacNoteConvRuleCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rtRasFrtRtAmt = null;
	/* Column Info */
	private String diBsePortDefCd = null;
	/* Column Info */
	private String diPrcCmdtDefCd = null;
	/* Column Info */
	private String rtRapNoteConvMapgId = null;
	/* Column Info */
	private String daTypNoteConvRuleCd = null;
	/* Column Info */
	private String rtAddNoteConvMapgId = null;
	/* Column Info */
	private String rtAppNoteConvTpCd = null;
	/* Column Info */
	private String rtArbBkgConvTpCd = null;
	/* Column Info */
	private String oiBsePortDefCd = null;
	/* Column Info */
	private String daRacNoteConvTpCd = null;
	/* Column Info */
	private String oiViaPortDefCd = null;
	/* Column Info */
	private String oaViaPortDefCd = null;
	/* Column Info */
	private String rtTypBkgConvTpCd = null;
	/* Column Info */
	private String bqPrcCgoTpCd = null;
	/* Column Info */
	private String diViaPortDefCd = null;
	/* Column Info */
	private String rtAppRtOpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScTAWOftAutoratingListVO() {}

	public SearchScTAWOftAutoratingListVO(String ibflag, String pagerows, String bkgNo, String ctrtNo, String prcRtMtchPattCd, String propNo, String amdtSeq, String svcScpCd, String bqSeq, String bkgBqSeq, String cntrTpszCd, String ctrtCntrTpszCd, String rcvTermCd, String deTermCd, String dryCgoFlg, String awkCgoFlg, String dcgoFlg, String rcFlg, String bbCgoFlg, String socFlg, String imdgClssCd, String prcGenSpclRtTpCd, String prcCmdtHdrSeq, String prcRoutSeq, String prcRtSeq, String rtMtchPattCd, String cmdtNm, String porCd, String polCd, String podCd, String delCd, String dirCallFlg, String rcvDeTermCd, String ratUtCd, String prcCgoTpCd, String currCd, String orgTrspModCd, String destTrspModCd, String fnlFrtRtAmt, String trnsModCd, String opCntrQty, String noteCtnt, String note, String dtl, String bqPrcCgoTpCd, String bqPorApplFlg, String bqPolApplFlg, String bqPodApplFlg, String bqDelApplFlg, String bqPorRlyPortApplFlg, String bqPstRlyPortApplFlg, String oiAddChgSeq, String oaAddChgSeq, String daAddChgSeq, String diAddChgSeq, String cmPrcCmdtTpCd, String cmPrcCmdtDefCd, String opRoutPntLocDefCd, String ovRoutViaPortDefCd, String dvRoutViaPortDefCd, String dpRoutPntLocDefCd, String rdDirCallFlg, String opPrcTrspModCd, String dpPrcTrspModCd, String rtRatUtCd, String rtPrcCgoTpCd, String rtCurrCd, String rtFnlFrtRtAmt, String oiRoutPntLocDefCd, String oiBsePortDefCd, String oiViaPortDefCd, String oiDirCallFlg, String oiRatUtCd, String oiPrcCgoTpCd, String oiPrcTrspModCd, String oiRcvDeTermCd, String oiPrcCmdtDefCd, String oiCurrCd, String oiFnlFrtRtAmt, String oaRoutPntLocDefCd, String oaBsePortDefCd, String oaViaPortDefCd, String oaDirCallFlg, String oaRatUtCd, String oaPrcCgoTpCd, String oaPrcTrspModCd, String oaRcvDeTermCd, String oaPrcCmdtDefCd, String oaCurrCd, String oaFnlFrtRtAmt, String daRoutPntLocDefCd, String daBsePortDefCd, String daViaPortDefCd, String daDirCallFlg, String daRatUtCd, String daPrcCgoTpCd, String daPrcTrspModCd, String daRcvDeTermCd, String daPrcCmdtDefCd, String daCurrCd, String daFnlFrtRtAmt, String diRoutPntLocDefCd, String diBsePortDefCd, String diViaPortDefCd, String diDirCallFlg, String diRatUtCd, String diPrcCgoTpCd, String diPrcTrspModCd, String diRcvDeTermCd, String diPrcCmdtDefCd, String diCurrCd, String diFnlFrtRtAmt, String rtRapBkgConvTpCd, String rtRapNoteConvMapgId, String rtRapNoteConvSeq, String rtRapNoteConvRuleCd, String rtRapNoteConvTpCd, String rtRapRtOpCd, String rtRapCurrCd, String rtRapFrtRtAmt, String rtRarBkgConvTpCd, String rtRarNoteConvMapgId, String rtRarNoteConvSeq, String rtRarNoteConvRuleCd, String rtRarNoteConvTpCd, String rtRarRtOpCd, String rtRarCurrCd, String rtRarFrtRtAmt, String rtDorBkgConvTpCd, String rtDorNoteConvMapgId, String rtDorNoteConvSeq, String rtDorNoteConvRuleCd, String rtDorNoteConvTpCd, String rtDorRtOpCd, String rtDorCurrCd, String rtDorFrtRtAmt, String rtTypBkgConvTpCd, String rtTypNoteConvMapgId, String rtTypNoteConvSeq, String rtTypNoteConvRuleCd, String rtTypNoteConvTpCd, String rtTypRtOpCd, String rtTypCurrCd, String rtTypFrtRtAmt, String rtRacBkgConvTpCd, String rtRacNoteConvMapgId, String rtRacNoteConvSeq, String rtRacNoteConvRuleCd, String rtRacNoteConvTpCd, String rtRacRtOpCd, String rtRacCurrCd, String rtRacFrtRtAmt, String rtAppBkgConvTpCd, String rtAppNoteConvMapgId, String rtAppNoteConvSeq, String rtAppNoteConvRuleCd, String rtAppNoteConvTpCd, String rtAppRtOpCd, String rtAppCurrCd, String rtAppFrtRtAmt, String rtRasBkgConvTpCd, String rtRasNoteConvMapgId, String rtRasNoteConvSeq, String rtRasNoteConvRuleCd, String rtRasNoteConvTpCd, String rtRasRtOpCd, String rtRasCurrCd, String rtRasFrtRtAmt, String rtArbBkgConvTpCd, String rtArbNoteConvMapgId, String rtArbNoteConvSeq, String rtArbNoteConvRuleCd, String rtArbNoteConvTpCd, String rtArbRtOpCd, String rtArbCurrCd, String rtArbFrtRtAmt, String rtAddBkgConvTpCd, String rtAddNoteConvMapgId, String rtAddNoteConvSeq, String rtAddNoteConvRuleCd, String rtAddNoteConvTpCd, String rtAddRtOpCd, String rtAddCurrCd, String rtAddFrtRtAmt, String oaTypBkgConvTpCd, String oaTypNoteConvMapgId, String oaTypNoteConvSeq, String oaTypNoteConvRuleCd, String oaTypNoteConvTpCd, String oaTypRtOpCd, String oaTypCurrCd, String oaTypFrtRtAmt, String oaRacBkgConvTpCd, String oaRacNoteConvMapgId, String oaRacNoteConvSeq, String oaRacNoteConvRuleCd, String oaRacNoteConvTpCd, String oaRacRtOpCd, String oaRacCurrCd, String oaRacFrtRtAmt, String daTypBkgConvTpCd, String daTypNoteConvMapgId, String daTypNoteConvSeq, String daTypNoteConvRuleCd, String daTypNoteConvTpCd, String daTypDaOpCd, String daTypCurrCd, String daTypFrtRtAmt, String daRacBkgConvTpCd, String daRacNoteConvMapgId, String daRacNoteConvSeq, String daRacNoteConvRuleCd, String daRacNoteConvTpCd, String daRacDaOpCd, String daRacCurrCd, String daRacFrtRtAmt) {
		this.oaTypBkgConvTpCd = oaTypBkgConvTpCd;
		this.daTypNoteConvMapgId = daTypNoteConvMapgId;
		this.oaPrcTrspModCd = oaPrcTrspModCd;
		this.daAddChgSeq = daAddChgSeq;
		this.diPrcTrspModCd = diPrcTrspModCd;
		this.pagerows = pagerows;
		this.daTypBkgConvTpCd = daTypBkgConvTpCd;
		this.oaRcvDeTermCd = oaRcvDeTermCd;
		this.rtTypNoteConvRuleCd = rtTypNoteConvRuleCd;
		this.daTypNoteConvSeq = daTypNoteConvSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
		this.oaCurrCd = oaCurrCd;
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
		this.rtRarBkgConvTpCd = rtRarBkgConvTpCd;
		this.daRacDaOpCd = daRacDaOpCd;
		this.bqSeq = bqSeq;
		this.dpPrcTrspModCd = dpPrcTrspModCd;
		this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
		this.opPrcTrspModCd = opPrcTrspModCd;
		this.oaRacFrtRtAmt = oaRacFrtRtAmt;
		this.diRcvDeTermCd = diRcvDeTermCd;
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
		this.oaTypRtOpCd = oaTypRtOpCd;
		this.oaRacBkgConvTpCd = oaRacBkgConvTpCd;
		this.rtRarCurrCd = rtRarCurrCd;
		this.diCurrCd = diCurrCd;
		this.rcFlg = rcFlg;
		this.oaTypNoteConvRuleCd = oaTypNoteConvRuleCd;
		this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
		this.rtRapCurrCd = rtRapCurrCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.oiRatUtCd = oiRatUtCd;
		this.rtRacCurrCd = rtRacCurrCd;
		this.oaRacCurrCd = oaRacCurrCd;
		this.daTypDaOpCd = daTypDaOpCd;
		this.rtDorNoteConvTpCd = rtDorNoteConvTpCd;
		this.daRacBkgConvTpCd = daRacBkgConvTpCd;
		this.oaRacNoteConvMapgId = oaRacNoteConvMapgId;
		this.daRacNoteConvRuleCd = daRacNoteConvRuleCd;
		this.rtAppNoteConvSeq = rtAppNoteConvSeq;
		this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
		this.rtPrcCgoTpCd = rtPrcCgoTpCd;
		this.rtRacFrtRtAmt = rtRacFrtRtAmt;
		this.rtAddRtOpCd = rtAddRtOpCd;
		this.diDirCallFlg = diDirCallFlg;
		this.rtRapFrtRtAmt = rtRapFrtRtAmt;
		this.rtRacNoteConvSeq = rtRacNoteConvSeq;
		this.bqDelApplFlg = bqDelApplFlg;
		this.daRcvDeTermCd = daRcvDeTermCd;
		this.daTypFrtRtAmt = daTypFrtRtAmt;
		this.rtDorNoteConvRuleCd = rtDorNoteConvRuleCd;
		this.oaTypNoteConvMapgId = oaTypNoteConvMapgId;
		this.rtArbRtOpCd = rtArbRtOpCd;
		this.bqPorRlyPortApplFlg = bqPorRlyPortApplFlg;
		this.propNo = propNo;
		this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
		this.rtRapBkgConvTpCd = rtRapBkgConvTpCd;
		this.bqPorApplFlg = bqPorApplFlg;
		this.diPrcCgoTpCd = diPrcCgoTpCd;
		this.rtArbNoteConvMapgId = rtArbNoteConvMapgId;
		this.dtl = dtl;
		this.bqPolApplFlg = bqPolApplFlg;
		this.destTrspModCd = destTrspModCd;
		this.rtRasRtOpCd = rtRasRtOpCd;
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
		this.rtRarNoteConvTpCd = rtRarNoteConvTpCd;
		this.oiPrcCmdtDefCd = oiPrcCmdtDefCd;
		this.diFnlFrtRtAmt = diFnlFrtRtAmt;
		this.rtAppNoteConvRuleCd = rtAppNoteConvRuleCd;
		this.oaRacNoteConvRuleCd = oaRacNoteConvRuleCd;
		this.oiPrcCgoTpCd = oiPrcCgoTpCd;
		this.oiAddChgSeq = oiAddChgSeq;
		this.daPrcTrspModCd = daPrcTrspModCd;
		this.rtRarRtOpCd = rtRarRtOpCd;
		this.porCd = porCd;
		this.rtRapNoteConvRuleCd = rtRapNoteConvRuleCd;
		this.rtAppCurrCd = rtAppCurrCd;
		this.rtRasNoteConvSeq = rtRasNoteConvSeq;
		this.daDirCallFlg = daDirCallFlg;
		this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
		this.rtTypFrtRtAmt = rtTypFrtRtAmt;
		this.rtTypNoteConvMapgId = rtTypNoteConvMapgId;
		this.noteCtnt = noteCtnt;
		this.oaRatUtCd = oaRatUtCd;
		this.ibflag = ibflag;
		this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
		this.oaTypNoteConvTpCd = oaTypNoteConvTpCd;
		this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
		this.rtDorNoteConvSeq = rtDorNoteConvSeq;
		this.rtArbNoteConvTpCd = rtArbNoteConvTpCd;
		this.rtRasNoteConvMapgId = rtRasNoteConvMapgId;
		this.daBsePortDefCd = daBsePortDefCd;
		this.daRacFrtRtAmt = daRacFrtRtAmt;
		this.prcRoutSeq = prcRoutSeq;
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
		this.oiPrcTrspModCd = oiPrcTrspModCd;
		this.rtRarNoteConvMapgId = rtRarNoteConvMapgId;
		this.opRoutPntLocDefCd = opRoutPntLocDefCd;
		this.cmdtNm = cmdtNm;
		this.daTypCurrCd = daTypCurrCd;
		this.socFlg = socFlg;
		this.daPrcCmdtDefCd = daPrcCmdtDefCd;
		this.deTermCd = deTermCd;
		this.bkgBqSeq = bkgBqSeq;
		this.trnsModCd = trnsModCd;
		this.oaTypCurrCd = oaTypCurrCd;
		this.rtRatUtCd = rtRatUtCd;
		this.daTypNoteConvTpCd = daTypNoteConvTpCd;
		this.rtAddBkgConvTpCd = rtAddBkgConvTpCd;
		this.rtAppFrtRtAmt = rtAppFrtRtAmt;
		this.oaRacNoteConvSeq = oaRacNoteConvSeq;
		this.svcScpCd = svcScpCd;
		this.rtDorFrtRtAmt = rtDorFrtRtAmt;
		this.oaPrcCgoTpCd = oaPrcCgoTpCd;
		this.oaPrcCmdtDefCd = oaPrcCmdtDefCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
		this.oiDirCallFlg = oiDirCallFlg;
		this.dirCallFlg = dirCallFlg;
		this.bqPodApplFlg = bqPodApplFlg;
		this.ratUtCd = ratUtCd;
		this.daViaPortDefCd = daViaPortDefCd;
		this.podCd = podCd;
		this.daRatUtCd = daRatUtCd;
		this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
		this.diRatUtCd = diRatUtCd;
		this.bkgNo = bkgNo;
		this.prcRtSeq = prcRtSeq;
		this.rtRarFrtRtAmt = rtRarFrtRtAmt;
		this.oaDirCallFlg = oaDirCallFlg;
		this.rtAppNoteConvMapgId = rtAppNoteConvMapgId;
		this.opCntrQty = opCntrQty;
		this.rtArbFrtRtAmt = rtArbFrtRtAmt;
		this.imdgClssCd = imdgClssCd;
		this.rtDorCurrCd = rtDorCurrCd;
		this.rtRacNoteConvTpCd = rtRacNoteConvTpCd;
		this.daPrcCgoTpCd = daPrcCgoTpCd;
		this.prcCmdtHdrSeq = prcCmdtHdrSeq;
		this.rtRarNoteConvRuleCd = rtRarNoteConvRuleCd;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.rtRasNoteConvRuleCd = rtRasNoteConvRuleCd;
		this.rtRasCurrCd = rtRasCurrCd;
		this.rtArbNoteConvSeq = rtArbNoteConvSeq;
		this.daRacNoteConvSeq = daRacNoteConvSeq;
		this.rtTypNoteConvSeq = rtTypNoteConvSeq;
		this.oaAddChgSeq = oaAddChgSeq;
		this.note = note;
		this.rtAddNoteConvTpCd = rtAddNoteConvTpCd;
		this.rtTypCurrCd = rtTypCurrCd;
		this.rtAddNoteConvSeq = rtAddNoteConvSeq;
		this.rtDorRtOpCd = rtDorRtOpCd;
		this.rtRarNoteConvSeq = rtRarNoteConvSeq;
		this.rtDorNoteConvMapgId = rtDorNoteConvMapgId;
		this.rtArbCurrCd = rtArbCurrCd;
		this.diAddChgSeq = diAddChgSeq;
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
		this.oaBsePortDefCd = oaBsePortDefCd;
		this.rtCurrCd = rtCurrCd;
		this.rtAddNoteConvRuleCd = rtAddNoteConvRuleCd;
		this.oiCurrCd = oiCurrCd;
		this.rtRacBkgConvTpCd = rtRacBkgConvTpCd;
		this.oiFnlFrtRtAmt = oiFnlFrtRtAmt;
		this.rtTypNoteConvTpCd = rtTypNoteConvTpCd;
		this.rtRacNoteConvMapgId = rtRacNoteConvMapgId;
		this.dryCgoFlg = dryCgoFlg;
		this.rtAddFrtRtAmt = rtAddFrtRtAmt;
		this.amdtSeq = amdtSeq;
		this.rtRapNoteConvSeq = rtRapNoteConvSeq;
		this.orgTrspModCd = orgTrspModCd;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.rtAddCurrCd = rtAddCurrCd;
		this.oaRacNoteConvTpCd = oaRacNoteConvTpCd;
		this.rtMtchPattCd = rtMtchPattCd;
		this.daCurrCd = daCurrCd;
		this.rtArbNoteConvRuleCd = rtArbNoteConvRuleCd;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.rtRacRtOpCd = rtRacRtOpCd;
		this.oaRacRtOpCd = oaRacRtOpCd;
		this.rtRapNoteConvTpCd = rtRapNoteConvTpCd;
		this.diRoutPntLocDefCd = diRoutPntLocDefCd;
		this.oaTypFrtRtAmt = oaTypFrtRtAmt;
		this.prcRtMtchPattCd = prcRtMtchPattCd;
		this.bqPstRlyPortApplFlg = bqPstRlyPortApplFlg;
		this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
		this.daRacNoteConvMapgId = daRacNoteConvMapgId;
		this.rtTypRtOpCd = rtTypRtOpCd;
		this.rdDirCallFlg = rdDirCallFlg;
		this.oiRcvDeTermCd = oiRcvDeTermCd;
		this.currCd = currCd;
		this.oaTypNoteConvSeq = oaTypNoteConvSeq;
		this.rtRapRtOpCd = rtRapRtOpCd;
		this.daRacCurrCd = daRacCurrCd;
		this.bbCgoFlg = bbCgoFlg;
		this.rtDorBkgConvTpCd = rtDorBkgConvTpCd;
		this.rtRacNoteConvRuleCd = rtRacNoteConvRuleCd;
		this.dcgoFlg = dcgoFlg;
		this.rcvTermCd = rcvTermCd;
		this.rtRasFrtRtAmt = rtRasFrtRtAmt;
		this.diBsePortDefCd = diBsePortDefCd;
		this.diPrcCmdtDefCd = diPrcCmdtDefCd;
		this.rtRapNoteConvMapgId = rtRapNoteConvMapgId;
		this.daTypNoteConvRuleCd = daTypNoteConvRuleCd;
		this.rtAddNoteConvMapgId = rtAddNoteConvMapgId;
		this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
		this.rtArbBkgConvTpCd = rtArbBkgConvTpCd;
		this.oiBsePortDefCd = oiBsePortDefCd;
		this.daRacNoteConvTpCd = daRacNoteConvTpCd;
		this.oiViaPortDefCd = oiViaPortDefCd;
		this.oaViaPortDefCd = oaViaPortDefCd;
		this.rtTypBkgConvTpCd = rtTypBkgConvTpCd;
		this.bqPrcCgoTpCd = bqPrcCgoTpCd;
		this.diViaPortDefCd = diViaPortDefCd;
		this.rtAppRtOpCd = rtAppRtOpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oa_typ_bkg_conv_tp_cd", getOaTypBkgConvTpCd());
		this.hashColumns.put("da_typ_note_conv_mapg_id", getDaTypNoteConvMapgId());
		this.hashColumns.put("oa_prc_trsp_mod_cd", getOaPrcTrspModCd());
		this.hashColumns.put("da_add_chg_seq", getDaAddChgSeq());
		this.hashColumns.put("di_prc_trsp_mod_cd", getDiPrcTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("da_typ_bkg_conv_tp_cd", getDaTypBkgConvTpCd());
		this.hashColumns.put("oa_rcv_de_term_cd", getOaRcvDeTermCd());
		this.hashColumns.put("rt_typ_note_conv_rule_cd", getRtTypNoteConvRuleCd());
		this.hashColumns.put("da_typ_note_conv_seq", getDaTypNoteConvSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ov_rout_via_port_def_cd", getOvRoutViaPortDefCd());
		this.hashColumns.put("oa_curr_cd", getOaCurrCd());
		this.hashColumns.put("da_fnl_frt_rt_amt", getDaFnlFrtRtAmt());
		this.hashColumns.put("rt_rar_bkg_conv_tp_cd", getRtRarBkgConvTpCd());
		this.hashColumns.put("da_rac_da_op_cd", getDaRacDaOpCd());
		this.hashColumns.put("bq_seq", getBqSeq());
		this.hashColumns.put("dp_prc_trsp_mod_cd", getDpPrcTrspModCd());
		this.hashColumns.put("rt_app_bkg_conv_tp_cd", getRtAppBkgConvTpCd());
		this.hashColumns.put("op_prc_trsp_mod_cd", getOpPrcTrspModCd());
		this.hashColumns.put("oa_rac_frt_rt_amt", getOaRacFrtRtAmt());
		this.hashColumns.put("di_rcv_de_term_cd", getDiRcvDeTermCd());
		this.hashColumns.put("cm_prc_cmdt_tp_cd", getCmPrcCmdtTpCd());
		this.hashColumns.put("oa_typ_rt_op_cd", getOaTypRtOpCd());
		this.hashColumns.put("oa_rac_bkg_conv_tp_cd", getOaRacBkgConvTpCd());
		this.hashColumns.put("rt_rar_curr_cd", getRtRarCurrCd());
		this.hashColumns.put("di_curr_cd", getDiCurrCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("oa_typ_note_conv_rule_cd", getOaTypNoteConvRuleCd());
		this.hashColumns.put("rt_ras_bkg_conv_tp_cd", getRtRasBkgConvTpCd());
		this.hashColumns.put("rt_rap_curr_cd", getRtRapCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("oi_rat_ut_cd", getOiRatUtCd());
		this.hashColumns.put("rt_rac_curr_cd", getRtRacCurrCd());
		this.hashColumns.put("oa_rac_curr_cd", getOaRacCurrCd());
		this.hashColumns.put("da_typ_da_op_cd", getDaTypDaOpCd());
		this.hashColumns.put("rt_dor_note_conv_tp_cd", getRtDorNoteConvTpCd());
		this.hashColumns.put("da_rac_bkg_conv_tp_cd", getDaRacBkgConvTpCd());
		this.hashColumns.put("oa_rac_note_conv_mapg_id", getOaRacNoteConvMapgId());
		this.hashColumns.put("da_rac_note_conv_rule_cd", getDaRacNoteConvRuleCd());
		this.hashColumns.put("rt_app_note_conv_seq", getRtAppNoteConvSeq());
		this.hashColumns.put("rt_ras_note_conv_tp_cd", getRtRasNoteConvTpCd());
		this.hashColumns.put("rt_prc_cgo_tp_cd", getRtPrcCgoTpCd());
		this.hashColumns.put("rt_rac_frt_rt_amt", getRtRacFrtRtAmt());
		this.hashColumns.put("rt_add_rt_op_cd", getRtAddRtOpCd());
		this.hashColumns.put("di_dir_call_flg", getDiDirCallFlg());
		this.hashColumns.put("rt_rap_frt_rt_amt", getRtRapFrtRtAmt());
		this.hashColumns.put("rt_rac_note_conv_seq", getRtRacNoteConvSeq());
		this.hashColumns.put("bq_del_appl_flg", getBqDelApplFlg());
		this.hashColumns.put("da_rcv_de_term_cd", getDaRcvDeTermCd());
		this.hashColumns.put("da_typ_frt_rt_amt", getDaTypFrtRtAmt());
		this.hashColumns.put("rt_dor_note_conv_rule_cd", getRtDorNoteConvRuleCd());
		this.hashColumns.put("oa_typ_note_conv_mapg_id", getOaTypNoteConvMapgId());
		this.hashColumns.put("rt_arb_rt_op_cd", getRtArbRtOpCd());
		this.hashColumns.put("bq_por_rly_port_appl_flg", getBqPorRlyPortApplFlg());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cm_prc_cmdt_def_cd", getCmPrcCmdtDefCd());
		this.hashColumns.put("rt_rap_bkg_conv_tp_cd", getRtRapBkgConvTpCd());
		this.hashColumns.put("bq_por_appl_flg", getBqPorApplFlg());
		this.hashColumns.put("di_prc_cgo_tp_cd", getDiPrcCgoTpCd());
		this.hashColumns.put("rt_arb_note_conv_mapg_id", getRtArbNoteConvMapgId());
		this.hashColumns.put("dtl", getDtl());
		this.hashColumns.put("bq_pol_appl_flg", getBqPolApplFlg());
		this.hashColumns.put("dest_trsp_mod_cd", getDestTrspModCd());
		this.hashColumns.put("rt_ras_rt_op_cd", getRtRasRtOpCd());
		this.hashColumns.put("prc_gen_spcl_rt_tp_cd", getPrcGenSpclRtTpCd());
		this.hashColumns.put("rt_rar_note_conv_tp_cd", getRtRarNoteConvTpCd());
		this.hashColumns.put("oi_prc_cmdt_def_cd", getOiPrcCmdtDefCd());
		this.hashColumns.put("di_fnl_frt_rt_amt", getDiFnlFrtRtAmt());
		this.hashColumns.put("rt_app_note_conv_rule_cd", getRtAppNoteConvRuleCd());
		this.hashColumns.put("oa_rac_note_conv_rule_cd", getOaRacNoteConvRuleCd());
		this.hashColumns.put("oi_prc_cgo_tp_cd", getOiPrcCgoTpCd());
		this.hashColumns.put("oi_add_chg_seq", getOiAddChgSeq());
		this.hashColumns.put("da_prc_trsp_mod_cd", getDaPrcTrspModCd());
		this.hashColumns.put("rt_rar_rt_op_cd", getRtRarRtOpCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rt_rap_note_conv_rule_cd", getRtRapNoteConvRuleCd());
		this.hashColumns.put("rt_app_curr_cd", getRtAppCurrCd());
		this.hashColumns.put("rt_ras_note_conv_seq", getRtRasNoteConvSeq());
		this.hashColumns.put("da_dir_call_flg", getDaDirCallFlg());
		this.hashColumns.put("oa_rout_pnt_loc_def_cd", getOaRoutPntLocDefCd());
		this.hashColumns.put("rt_typ_frt_rt_amt", getRtTypFrtRtAmt());
		this.hashColumns.put("rt_typ_note_conv_mapg_id", getRtTypNoteConvMapgId());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("oa_rat_ut_cd", getOaRatUtCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_fnl_frt_rt_amt", getRtFnlFrtRtAmt());
		this.hashColumns.put("oa_typ_note_conv_tp_cd", getOaTypNoteConvTpCd());
		this.hashColumns.put("dv_rout_via_port_def_cd", getDvRoutViaPortDefCd());
		this.hashColumns.put("rt_dor_note_conv_seq", getRtDorNoteConvSeq());
		this.hashColumns.put("rt_arb_note_conv_tp_cd", getRtArbNoteConvTpCd());
		this.hashColumns.put("rt_ras_note_conv_mapg_id", getRtRasNoteConvMapgId());
		this.hashColumns.put("da_bse_port_def_cd", getDaBsePortDefCd());
		this.hashColumns.put("da_rac_frt_rt_amt", getDaRacFrtRtAmt());
		this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
		this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
		this.hashColumns.put("oi_prc_trsp_mod_cd", getOiPrcTrspModCd());
		this.hashColumns.put("rt_rar_note_conv_mapg_id", getRtRarNoteConvMapgId());
		this.hashColumns.put("op_rout_pnt_loc_def_cd", getOpRoutPntLocDefCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("da_typ_curr_cd", getDaTypCurrCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("da_prc_cmdt_def_cd", getDaPrcCmdtDefCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_bq_seq", getBkgBqSeq());
		this.hashColumns.put("trns_mod_cd", getTrnsModCd());
		this.hashColumns.put("oa_typ_curr_cd", getOaTypCurrCd());
		this.hashColumns.put("rt_rat_ut_cd", getRtRatUtCd());
		this.hashColumns.put("da_typ_note_conv_tp_cd", getDaTypNoteConvTpCd());
		this.hashColumns.put("rt_add_bkg_conv_tp_cd", getRtAddBkgConvTpCd());
		this.hashColumns.put("rt_app_frt_rt_amt", getRtAppFrtRtAmt());
		this.hashColumns.put("oa_rac_note_conv_seq", getOaRacNoteConvSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_dor_frt_rt_amt", getRtDorFrtRtAmt());
		this.hashColumns.put("oa_prc_cgo_tp_cd", getOaPrcCgoTpCd());
		this.hashColumns.put("oa_prc_cmdt_def_cd", getOaPrcCmdtDefCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("oi_rout_pnt_loc_def_cd", getOiRoutPntLocDefCd());
		this.hashColumns.put("oi_dir_call_flg", getOiDirCallFlg());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("bq_pod_appl_flg", getBqPodApplFlg());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("da_via_port_def_cd", getDaViaPortDefCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("da_rat_ut_cd", getDaRatUtCd());
		this.hashColumns.put("oa_fnl_frt_rt_amt", getOaFnlFrtRtAmt());
		this.hashColumns.put("di_rat_ut_cd", getDiRatUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prc_rt_seq", getPrcRtSeq());
		this.hashColumns.put("rt_rar_frt_rt_amt", getRtRarFrtRtAmt());
		this.hashColumns.put("oa_dir_call_flg", getOaDirCallFlg());
		this.hashColumns.put("rt_app_note_conv_mapg_id", getRtAppNoteConvMapgId());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("rt_arb_frt_rt_amt", getRtArbFrtRtAmt());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_dor_curr_cd", getRtDorCurrCd());
		this.hashColumns.put("rt_rac_note_conv_tp_cd", getRtRacNoteConvTpCd());
		this.hashColumns.put("da_prc_cgo_tp_cd", getDaPrcCgoTpCd());
		this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
		this.hashColumns.put("rt_rar_note_conv_rule_cd", getRtRarNoteConvRuleCd());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("rt_ras_note_conv_rule_cd", getRtRasNoteConvRuleCd());
		this.hashColumns.put("rt_ras_curr_cd", getRtRasCurrCd());
		this.hashColumns.put("rt_arb_note_conv_seq", getRtArbNoteConvSeq());
		this.hashColumns.put("da_rac_note_conv_seq", getDaRacNoteConvSeq());
		this.hashColumns.put("rt_typ_note_conv_seq", getRtTypNoteConvSeq());
		this.hashColumns.put("oa_add_chg_seq", getOaAddChgSeq());
		this.hashColumns.put("note", getNote());
		this.hashColumns.put("rt_add_note_conv_tp_cd", getRtAddNoteConvTpCd());
		this.hashColumns.put("rt_typ_curr_cd", getRtTypCurrCd());
		this.hashColumns.put("rt_add_note_conv_seq", getRtAddNoteConvSeq());
		this.hashColumns.put("rt_dor_rt_op_cd", getRtDorRtOpCd());
		this.hashColumns.put("rt_rar_note_conv_seq", getRtRarNoteConvSeq());
		this.hashColumns.put("rt_dor_note_conv_mapg_id", getRtDorNoteConvMapgId());
		this.hashColumns.put("rt_arb_curr_cd", getRtArbCurrCd());
		this.hashColumns.put("di_add_chg_seq", getDiAddChgSeq());
		this.hashColumns.put("da_rout_pnt_loc_def_cd", getDaRoutPntLocDefCd());
		this.hashColumns.put("oa_bse_port_def_cd", getOaBsePortDefCd());
		this.hashColumns.put("rt_curr_cd", getRtCurrCd());
		this.hashColumns.put("rt_add_note_conv_rule_cd", getRtAddNoteConvRuleCd());
		this.hashColumns.put("oi_curr_cd", getOiCurrCd());
		this.hashColumns.put("rt_rac_bkg_conv_tp_cd", getRtRacBkgConvTpCd());
		this.hashColumns.put("oi_fnl_frt_rt_amt", getOiFnlFrtRtAmt());
		this.hashColumns.put("rt_typ_note_conv_tp_cd", getRtTypNoteConvTpCd());
		this.hashColumns.put("rt_rac_note_conv_mapg_id", getRtRacNoteConvMapgId());
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("rt_add_frt_rt_amt", getRtAddFrtRtAmt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("rt_rap_note_conv_seq", getRtRapNoteConvSeq());
		this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rt_add_curr_cd", getRtAddCurrCd());
		this.hashColumns.put("oa_rac_note_conv_tp_cd", getOaRacNoteConvTpCd());
		this.hashColumns.put("rt_mtch_patt_cd", getRtMtchPattCd());
		this.hashColumns.put("da_curr_cd", getDaCurrCd());
		this.hashColumns.put("rt_arb_note_conv_rule_cd", getRtArbNoteConvRuleCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rt_rac_rt_op_cd", getRtRacRtOpCd());
		this.hashColumns.put("oa_rac_rt_op_cd", getOaRacRtOpCd());
		this.hashColumns.put("rt_rap_note_conv_tp_cd", getRtRapNoteConvTpCd());
		this.hashColumns.put("di_rout_pnt_loc_def_cd", getDiRoutPntLocDefCd());
		this.hashColumns.put("oa_typ_frt_rt_amt", getOaTypFrtRtAmt());
		this.hashColumns.put("prc_rt_mtch_patt_cd", getPrcRtMtchPattCd());
		this.hashColumns.put("bq_pst_rly_port_appl_flg", getBqPstRlyPortApplFlg());
		this.hashColumns.put("dp_rout_pnt_loc_def_cd", getDpRoutPntLocDefCd());
		this.hashColumns.put("da_rac_note_conv_mapg_id", getDaRacNoteConvMapgId());
		this.hashColumns.put("rt_typ_rt_op_cd", getRtTypRtOpCd());
		this.hashColumns.put("rd_dir_call_flg", getRdDirCallFlg());
		this.hashColumns.put("oi_rcv_de_term_cd", getOiRcvDeTermCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("oa_typ_note_conv_seq", getOaTypNoteConvSeq());
		this.hashColumns.put("rt_rap_rt_op_cd", getRtRapRtOpCd());
		this.hashColumns.put("da_rac_curr_cd", getDaRacCurrCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("rt_dor_bkg_conv_tp_cd", getRtDorBkgConvTpCd());
		this.hashColumns.put("rt_rac_note_conv_rule_cd", getRtRacNoteConvRuleCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rt_ras_frt_rt_amt", getRtRasFrtRtAmt());
		this.hashColumns.put("di_bse_port_def_cd", getDiBsePortDefCd());
		this.hashColumns.put("di_prc_cmdt_def_cd", getDiPrcCmdtDefCd());
		this.hashColumns.put("rt_rap_note_conv_mapg_id", getRtRapNoteConvMapgId());
		this.hashColumns.put("da_typ_note_conv_rule_cd", getDaTypNoteConvRuleCd());
		this.hashColumns.put("rt_add_note_conv_mapg_id", getRtAddNoteConvMapgId());
		this.hashColumns.put("rt_app_note_conv_tp_cd", getRtAppNoteConvTpCd());
		this.hashColumns.put("rt_arb_bkg_conv_tp_cd", getRtArbBkgConvTpCd());
		this.hashColumns.put("oi_bse_port_def_cd", getOiBsePortDefCd());
		this.hashColumns.put("da_rac_note_conv_tp_cd", getDaRacNoteConvTpCd());
		this.hashColumns.put("oi_via_port_def_cd", getOiViaPortDefCd());
		this.hashColumns.put("oa_via_port_def_cd", getOaViaPortDefCd());
		this.hashColumns.put("rt_typ_bkg_conv_tp_cd", getRtTypBkgConvTpCd());
		this.hashColumns.put("bq_prc_cgo_tp_cd", getBqPrcCgoTpCd());
		this.hashColumns.put("di_via_port_def_cd", getDiViaPortDefCd());
		this.hashColumns.put("rt_app_rt_op_cd", getRtAppRtOpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oa_typ_bkg_conv_tp_cd", "oaTypBkgConvTpCd");
		this.hashFields.put("da_typ_note_conv_mapg_id", "daTypNoteConvMapgId");
		this.hashFields.put("oa_prc_trsp_mod_cd", "oaPrcTrspModCd");
		this.hashFields.put("da_add_chg_seq", "daAddChgSeq");
		this.hashFields.put("di_prc_trsp_mod_cd", "diPrcTrspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("da_typ_bkg_conv_tp_cd", "daTypBkgConvTpCd");
		this.hashFields.put("oa_rcv_de_term_cd", "oaRcvDeTermCd");
		this.hashFields.put("rt_typ_note_conv_rule_cd", "rtTypNoteConvRuleCd");
		this.hashFields.put("da_typ_note_conv_seq", "daTypNoteConvSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ov_rout_via_port_def_cd", "ovRoutViaPortDefCd");
		this.hashFields.put("oa_curr_cd", "oaCurrCd");
		this.hashFields.put("da_fnl_frt_rt_amt", "daFnlFrtRtAmt");
		this.hashFields.put("rt_rar_bkg_conv_tp_cd", "rtRarBkgConvTpCd");
		this.hashFields.put("da_rac_da_op_cd", "daRacDaOpCd");
		this.hashFields.put("bq_seq", "bqSeq");
		this.hashFields.put("dp_prc_trsp_mod_cd", "dpPrcTrspModCd");
		this.hashFields.put("rt_app_bkg_conv_tp_cd", "rtAppBkgConvTpCd");
		this.hashFields.put("op_prc_trsp_mod_cd", "opPrcTrspModCd");
		this.hashFields.put("oa_rac_frt_rt_amt", "oaRacFrtRtAmt");
		this.hashFields.put("di_rcv_de_term_cd", "diRcvDeTermCd");
		this.hashFields.put("cm_prc_cmdt_tp_cd", "cmPrcCmdtTpCd");
		this.hashFields.put("oa_typ_rt_op_cd", "oaTypRtOpCd");
		this.hashFields.put("oa_rac_bkg_conv_tp_cd", "oaRacBkgConvTpCd");
		this.hashFields.put("rt_rar_curr_cd", "rtRarCurrCd");
		this.hashFields.put("di_curr_cd", "diCurrCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("oa_typ_note_conv_rule_cd", "oaTypNoteConvRuleCd");
		this.hashFields.put("rt_ras_bkg_conv_tp_cd", "rtRasBkgConvTpCd");
		this.hashFields.put("rt_rap_curr_cd", "rtRapCurrCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("oi_rat_ut_cd", "oiRatUtCd");
		this.hashFields.put("rt_rac_curr_cd", "rtRacCurrCd");
		this.hashFields.put("oa_rac_curr_cd", "oaRacCurrCd");
		this.hashFields.put("da_typ_da_op_cd", "daTypDaOpCd");
		this.hashFields.put("rt_dor_note_conv_tp_cd", "rtDorNoteConvTpCd");
		this.hashFields.put("da_rac_bkg_conv_tp_cd", "daRacBkgConvTpCd");
		this.hashFields.put("oa_rac_note_conv_mapg_id", "oaRacNoteConvMapgId");
		this.hashFields.put("da_rac_note_conv_rule_cd", "daRacNoteConvRuleCd");
		this.hashFields.put("rt_app_note_conv_seq", "rtAppNoteConvSeq");
		this.hashFields.put("rt_ras_note_conv_tp_cd", "rtRasNoteConvTpCd");
		this.hashFields.put("rt_prc_cgo_tp_cd", "rtPrcCgoTpCd");
		this.hashFields.put("rt_rac_frt_rt_amt", "rtRacFrtRtAmt");
		this.hashFields.put("rt_add_rt_op_cd", "rtAddRtOpCd");
		this.hashFields.put("di_dir_call_flg", "diDirCallFlg");
		this.hashFields.put("rt_rap_frt_rt_amt", "rtRapFrtRtAmt");
		this.hashFields.put("rt_rac_note_conv_seq", "rtRacNoteConvSeq");
		this.hashFields.put("bq_del_appl_flg", "bqDelApplFlg");
		this.hashFields.put("da_rcv_de_term_cd", "daRcvDeTermCd");
		this.hashFields.put("da_typ_frt_rt_amt", "daTypFrtRtAmt");
		this.hashFields.put("rt_dor_note_conv_rule_cd", "rtDorNoteConvRuleCd");
		this.hashFields.put("oa_typ_note_conv_mapg_id", "oaTypNoteConvMapgId");
		this.hashFields.put("rt_arb_rt_op_cd", "rtArbRtOpCd");
		this.hashFields.put("bq_por_rly_port_appl_flg", "bqPorRlyPortApplFlg");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cm_prc_cmdt_def_cd", "cmPrcCmdtDefCd");
		this.hashFields.put("rt_rap_bkg_conv_tp_cd", "rtRapBkgConvTpCd");
		this.hashFields.put("bq_por_appl_flg", "bqPorApplFlg");
		this.hashFields.put("di_prc_cgo_tp_cd", "diPrcCgoTpCd");
		this.hashFields.put("rt_arb_note_conv_mapg_id", "rtArbNoteConvMapgId");
		this.hashFields.put("dtl", "dtl");
		this.hashFields.put("bq_pol_appl_flg", "bqPolApplFlg");
		this.hashFields.put("dest_trsp_mod_cd", "destTrspModCd");
		this.hashFields.put("rt_ras_rt_op_cd", "rtRasRtOpCd");
		this.hashFields.put("prc_gen_spcl_rt_tp_cd", "prcGenSpclRtTpCd");
		this.hashFields.put("rt_rar_note_conv_tp_cd", "rtRarNoteConvTpCd");
		this.hashFields.put("oi_prc_cmdt_def_cd", "oiPrcCmdtDefCd");
		this.hashFields.put("di_fnl_frt_rt_amt", "diFnlFrtRtAmt");
		this.hashFields.put("rt_app_note_conv_rule_cd", "rtAppNoteConvRuleCd");
		this.hashFields.put("oa_rac_note_conv_rule_cd", "oaRacNoteConvRuleCd");
		this.hashFields.put("oi_prc_cgo_tp_cd", "oiPrcCgoTpCd");
		this.hashFields.put("oi_add_chg_seq", "oiAddChgSeq");
		this.hashFields.put("da_prc_trsp_mod_cd", "daPrcTrspModCd");
		this.hashFields.put("rt_rar_rt_op_cd", "rtRarRtOpCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rt_rap_note_conv_rule_cd", "rtRapNoteConvRuleCd");
		this.hashFields.put("rt_app_curr_cd", "rtAppCurrCd");
		this.hashFields.put("rt_ras_note_conv_seq", "rtRasNoteConvSeq");
		this.hashFields.put("da_dir_call_flg", "daDirCallFlg");
		this.hashFields.put("oa_rout_pnt_loc_def_cd", "oaRoutPntLocDefCd");
		this.hashFields.put("rt_typ_frt_rt_amt", "rtTypFrtRtAmt");
		this.hashFields.put("rt_typ_note_conv_mapg_id", "rtTypNoteConvMapgId");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("oa_rat_ut_cd", "oaRatUtCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_fnl_frt_rt_amt", "rtFnlFrtRtAmt");
		this.hashFields.put("oa_typ_note_conv_tp_cd", "oaTypNoteConvTpCd");
		this.hashFields.put("dv_rout_via_port_def_cd", "dvRoutViaPortDefCd");
		this.hashFields.put("rt_dor_note_conv_seq", "rtDorNoteConvSeq");
		this.hashFields.put("rt_arb_note_conv_tp_cd", "rtArbNoteConvTpCd");
		this.hashFields.put("rt_ras_note_conv_mapg_id", "rtRasNoteConvMapgId");
		this.hashFields.put("da_bse_port_def_cd", "daBsePortDefCd");
		this.hashFields.put("da_rac_frt_rt_amt", "daRacFrtRtAmt");
		this.hashFields.put("prc_rout_seq", "prcRoutSeq");
		this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
		this.hashFields.put("oi_prc_trsp_mod_cd", "oiPrcTrspModCd");
		this.hashFields.put("rt_rar_note_conv_mapg_id", "rtRarNoteConvMapgId");
		this.hashFields.put("op_rout_pnt_loc_def_cd", "opRoutPntLocDefCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("da_typ_curr_cd", "daTypCurrCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("da_prc_cmdt_def_cd", "daPrcCmdtDefCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_bq_seq", "bkgBqSeq");
		this.hashFields.put("trns_mod_cd", "trnsModCd");
		this.hashFields.put("oa_typ_curr_cd", "oaTypCurrCd");
		this.hashFields.put("rt_rat_ut_cd", "rtRatUtCd");
		this.hashFields.put("da_typ_note_conv_tp_cd", "daTypNoteConvTpCd");
		this.hashFields.put("rt_add_bkg_conv_tp_cd", "rtAddBkgConvTpCd");
		this.hashFields.put("rt_app_frt_rt_amt", "rtAppFrtRtAmt");
		this.hashFields.put("oa_rac_note_conv_seq", "oaRacNoteConvSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_dor_frt_rt_amt", "rtDorFrtRtAmt");
		this.hashFields.put("oa_prc_cgo_tp_cd", "oaPrcCgoTpCd");
		this.hashFields.put("oa_prc_cmdt_def_cd", "oaPrcCmdtDefCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("oi_rout_pnt_loc_def_cd", "oiRoutPntLocDefCd");
		this.hashFields.put("oi_dir_call_flg", "oiDirCallFlg");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("bq_pod_appl_flg", "bqPodApplFlg");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("da_via_port_def_cd", "daViaPortDefCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("da_rat_ut_cd", "daRatUtCd");
		this.hashFields.put("oa_fnl_frt_rt_amt", "oaFnlFrtRtAmt");
		this.hashFields.put("di_rat_ut_cd", "diRatUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prc_rt_seq", "prcRtSeq");
		this.hashFields.put("rt_rar_frt_rt_amt", "rtRarFrtRtAmt");
		this.hashFields.put("oa_dir_call_flg", "oaDirCallFlg");
		this.hashFields.put("rt_app_note_conv_mapg_id", "rtAppNoteConvMapgId");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("rt_arb_frt_rt_amt", "rtArbFrtRtAmt");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_dor_curr_cd", "rtDorCurrCd");
		this.hashFields.put("rt_rac_note_conv_tp_cd", "rtRacNoteConvTpCd");
		this.hashFields.put("da_prc_cgo_tp_cd", "daPrcCgoTpCd");
		this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
		this.hashFields.put("rt_rar_note_conv_rule_cd", "rtRarNoteConvRuleCd");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("rt_ras_note_conv_rule_cd", "rtRasNoteConvRuleCd");
		this.hashFields.put("rt_ras_curr_cd", "rtRasCurrCd");
		this.hashFields.put("rt_arb_note_conv_seq", "rtArbNoteConvSeq");
		this.hashFields.put("da_rac_note_conv_seq", "daRacNoteConvSeq");
		this.hashFields.put("rt_typ_note_conv_seq", "rtTypNoteConvSeq");
		this.hashFields.put("oa_add_chg_seq", "oaAddChgSeq");
		this.hashFields.put("note", "note");
		this.hashFields.put("rt_add_note_conv_tp_cd", "rtAddNoteConvTpCd");
		this.hashFields.put("rt_typ_curr_cd", "rtTypCurrCd");
		this.hashFields.put("rt_add_note_conv_seq", "rtAddNoteConvSeq");
		this.hashFields.put("rt_dor_rt_op_cd", "rtDorRtOpCd");
		this.hashFields.put("rt_rar_note_conv_seq", "rtRarNoteConvSeq");
		this.hashFields.put("rt_dor_note_conv_mapg_id", "rtDorNoteConvMapgId");
		this.hashFields.put("rt_arb_curr_cd", "rtArbCurrCd");
		this.hashFields.put("di_add_chg_seq", "diAddChgSeq");
		this.hashFields.put("da_rout_pnt_loc_def_cd", "daRoutPntLocDefCd");
		this.hashFields.put("oa_bse_port_def_cd", "oaBsePortDefCd");
		this.hashFields.put("rt_curr_cd", "rtCurrCd");
		this.hashFields.put("rt_add_note_conv_rule_cd", "rtAddNoteConvRuleCd");
		this.hashFields.put("oi_curr_cd", "oiCurrCd");
		this.hashFields.put("rt_rac_bkg_conv_tp_cd", "rtRacBkgConvTpCd");
		this.hashFields.put("oi_fnl_frt_rt_amt", "oiFnlFrtRtAmt");
		this.hashFields.put("rt_typ_note_conv_tp_cd", "rtTypNoteConvTpCd");
		this.hashFields.put("rt_rac_note_conv_mapg_id", "rtRacNoteConvMapgId");
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("rt_add_frt_rt_amt", "rtAddFrtRtAmt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("rt_rap_note_conv_seq", "rtRapNoteConvSeq");
		this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rt_add_curr_cd", "rtAddCurrCd");
		this.hashFields.put("oa_rac_note_conv_tp_cd", "oaRacNoteConvTpCd");
		this.hashFields.put("rt_mtch_patt_cd", "rtMtchPattCd");
		this.hashFields.put("da_curr_cd", "daCurrCd");
		this.hashFields.put("rt_arb_note_conv_rule_cd", "rtArbNoteConvRuleCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rt_rac_rt_op_cd", "rtRacRtOpCd");
		this.hashFields.put("oa_rac_rt_op_cd", "oaRacRtOpCd");
		this.hashFields.put("rt_rap_note_conv_tp_cd", "rtRapNoteConvTpCd");
		this.hashFields.put("di_rout_pnt_loc_def_cd", "diRoutPntLocDefCd");
		this.hashFields.put("oa_typ_frt_rt_amt", "oaTypFrtRtAmt");
		this.hashFields.put("prc_rt_mtch_patt_cd", "prcRtMtchPattCd");
		this.hashFields.put("bq_pst_rly_port_appl_flg", "bqPstRlyPortApplFlg");
		this.hashFields.put("dp_rout_pnt_loc_def_cd", "dpRoutPntLocDefCd");
		this.hashFields.put("da_rac_note_conv_mapg_id", "daRacNoteConvMapgId");
		this.hashFields.put("rt_typ_rt_op_cd", "rtTypRtOpCd");
		this.hashFields.put("rd_dir_call_flg", "rdDirCallFlg");
		this.hashFields.put("oi_rcv_de_term_cd", "oiRcvDeTermCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("oa_typ_note_conv_seq", "oaTypNoteConvSeq");
		this.hashFields.put("rt_rap_rt_op_cd", "rtRapRtOpCd");
		this.hashFields.put("da_rac_curr_cd", "daRacCurrCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("rt_dor_bkg_conv_tp_cd", "rtDorBkgConvTpCd");
		this.hashFields.put("rt_rac_note_conv_rule_cd", "rtRacNoteConvRuleCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rt_ras_frt_rt_amt", "rtRasFrtRtAmt");
		this.hashFields.put("di_bse_port_def_cd", "diBsePortDefCd");
		this.hashFields.put("di_prc_cmdt_def_cd", "diPrcCmdtDefCd");
		this.hashFields.put("rt_rap_note_conv_mapg_id", "rtRapNoteConvMapgId");
		this.hashFields.put("da_typ_note_conv_rule_cd", "daTypNoteConvRuleCd");
		this.hashFields.put("rt_add_note_conv_mapg_id", "rtAddNoteConvMapgId");
		this.hashFields.put("rt_app_note_conv_tp_cd", "rtAppNoteConvTpCd");
		this.hashFields.put("rt_arb_bkg_conv_tp_cd", "rtArbBkgConvTpCd");
		this.hashFields.put("oi_bse_port_def_cd", "oiBsePortDefCd");
		this.hashFields.put("da_rac_note_conv_tp_cd", "daRacNoteConvTpCd");
		this.hashFields.put("oi_via_port_def_cd", "oiViaPortDefCd");
		this.hashFields.put("oa_via_port_def_cd", "oaViaPortDefCd");
		this.hashFields.put("rt_typ_bkg_conv_tp_cd", "rtTypBkgConvTpCd");
		this.hashFields.put("bq_prc_cgo_tp_cd", "bqPrcCgoTpCd");
		this.hashFields.put("di_via_port_def_cd", "diViaPortDefCd");
		this.hashFields.put("rt_app_rt_op_cd", "rtAppRtOpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oaTypBkgConvTpCd
	 */
	public String getOaTypBkgConvTpCd() {
		return this.oaTypBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return daTypNoteConvMapgId
	 */
	public String getDaTypNoteConvMapgId() {
		return this.daTypNoteConvMapgId;
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
	 * Column Info
	 * @return diPrcTrspModCd
	 */
	public String getDiPrcTrspModCd() {
		return this.diPrcTrspModCd;
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
	 * @return daTypBkgConvTpCd
	 */
	public String getDaTypBkgConvTpCd() {
		return this.daTypBkgConvTpCd;
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
	 * @return rtTypNoteConvRuleCd
	 */
	public String getRtTypNoteConvRuleCd() {
		return this.rtTypNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return daTypNoteConvSeq
	 */
	public String getDaTypNoteConvSeq() {
		return this.daTypNoteConvSeq;
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
	 * @return ovRoutViaPortDefCd
	 */
	public String getOvRoutViaPortDefCd() {
		return this.ovRoutViaPortDefCd;
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
	 * @return daFnlFrtRtAmt
	 */
	public String getDaFnlFrtRtAmt() {
		return this.daFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRarBkgConvTpCd
	 */
	public String getRtRarBkgConvTpCd() {
		return this.rtRarBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return daRacDaOpCd
	 */
	public String getDaRacDaOpCd() {
		return this.daRacDaOpCd;
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
	 * @return oaRacFrtRtAmt
	 */
	public String getOaRacFrtRtAmt() {
		return this.oaRacFrtRtAmt;
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
	 * @return cmPrcCmdtTpCd
	 */
	public String getCmPrcCmdtTpCd() {
		return this.cmPrcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return oaTypRtOpCd
	 */
	public String getOaTypRtOpCd() {
		return this.oaTypRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return oaRacBkgConvTpCd
	 */
	public String getOaRacBkgConvTpCd() {
		return this.oaRacBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtRarCurrCd
	 */
	public String getRtRarCurrCd() {
		return this.rtRarCurrCd;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return oaTypNoteConvRuleCd
	 */
	public String getOaTypNoteConvRuleCd() {
		return this.oaTypNoteConvRuleCd;
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
	 * @return rtRapCurrCd
	 */
	public String getRtRapCurrCd() {
		return this.rtRapCurrCd;
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
	 * @return rtRacCurrCd
	 */
	public String getRtRacCurrCd() {
		return this.rtRacCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oaRacCurrCd
	 */
	public String getOaRacCurrCd() {
		return this.oaRacCurrCd;
	}
	
	/**
	 * Column Info
	 * @return daTypDaOpCd
	 */
	public String getDaTypDaOpCd() {
		return this.daTypDaOpCd;
	}
	
	/**
	 * Column Info
	 * @return rtDorNoteConvTpCd
	 */
	public String getRtDorNoteConvTpCd() {
		return this.rtDorNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return daRacBkgConvTpCd
	 */
	public String getDaRacBkgConvTpCd() {
		return this.daRacBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return oaRacNoteConvMapgId
	 */
	public String getOaRacNoteConvMapgId() {
		return this.oaRacNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return daRacNoteConvRuleCd
	 */
	public String getDaRacNoteConvRuleCd() {
		return this.daRacNoteConvRuleCd;
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
	 * @return rtRacFrtRtAmt
	 */
	public String getRtRacFrtRtAmt() {
		return this.rtRacFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtAddRtOpCd
	 */
	public String getRtAddRtOpCd() {
		return this.rtAddRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return diDirCallFlg
	 */
	public String getDiDirCallFlg() {
		return this.diDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return rtRapFrtRtAmt
	 */
	public String getRtRapFrtRtAmt() {
		return this.rtRapFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtRacNoteConvSeq
	 */
	public String getRtRacNoteConvSeq() {
		return this.rtRacNoteConvSeq;
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
	 * @return daTypFrtRtAmt
	 */
	public String getDaTypFrtRtAmt() {
		return this.daTypFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtDorNoteConvRuleCd
	 */
	public String getRtDorNoteConvRuleCd() {
		return this.rtDorNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return oaTypNoteConvMapgId
	 */
	public String getOaTypNoteConvMapgId() {
		return this.oaTypNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return rtArbRtOpCd
	 */
	public String getRtArbRtOpCd() {
		return this.rtArbRtOpCd;
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
	 * @return rtRapBkgConvTpCd
	 */
	public String getRtRapBkgConvTpCd() {
		return this.rtRapBkgConvTpCd;
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
	 * @return diPrcCgoTpCd
	 */
	public String getDiPrcCgoTpCd() {
		return this.diPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtArbNoteConvMapgId
	 */
	public String getRtArbNoteConvMapgId() {
		return this.rtArbNoteConvMapgId;
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
	 * @return prcGenSpclRtTpCd
	 */
	public String getPrcGenSpclRtTpCd() {
		return this.prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtRarNoteConvTpCd
	 */
	public String getRtRarNoteConvTpCd() {
		return this.rtRarNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return oiPrcCmdtDefCd
	 */
	public String getOiPrcCmdtDefCd() {
		return this.oiPrcCmdtDefCd;
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
	 * @return oaRacNoteConvRuleCd
	 */
	public String getOaRacNoteConvRuleCd() {
		return this.oaRacNoteConvRuleCd;
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
	 * @return oiAddChgSeq
	 */
	public String getOiAddChgSeq() {
		return this.oiAddChgSeq;
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
	 * @return rtRarRtOpCd
	 */
	public String getRtRarRtOpCd() {
		return this.rtRarRtOpCd;
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
	 * @return rtRapNoteConvRuleCd
	 */
	public String getRtRapNoteConvRuleCd() {
		return this.rtRapNoteConvRuleCd;
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
	 * @return daDirCallFlg
	 */
	public String getDaDirCallFlg() {
		return this.daDirCallFlg;
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
	 * @return rtTypFrtRtAmt
	 */
	public String getRtTypFrtRtAmt() {
		return this.rtTypFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rtTypNoteConvMapgId
	 */
	public String getRtTypNoteConvMapgId() {
		return this.rtTypNoteConvMapgId;
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
	 * @return oaTypNoteConvTpCd
	 */
	public String getOaTypNoteConvTpCd() {
		return this.oaTypNoteConvTpCd;
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
	 * @return rtDorNoteConvSeq
	 */
	public String getRtDorNoteConvSeq() {
		return this.rtDorNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtArbNoteConvTpCd
	 */
	public String getRtArbNoteConvTpCd() {
		return this.rtArbNoteConvTpCd;
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
	 * @return daBsePortDefCd
	 */
	public String getDaBsePortDefCd() {
		return this.daBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return daRacFrtRtAmt
	 */
	public String getDaRacFrtRtAmt() {
		return this.daRacFrtRtAmt;
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
	 * @return oiPrcTrspModCd
	 */
	public String getOiPrcTrspModCd() {
		return this.oiPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return rtRarNoteConvMapgId
	 */
	public String getRtRarNoteConvMapgId() {
		return this.rtRarNoteConvMapgId;
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
	 * @return daTypCurrCd
	 */
	public String getDaTypCurrCd() {
		return this.daTypCurrCd;
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
	 * @return daPrcCmdtDefCd
	 */
	public String getDaPrcCmdtDefCd() {
		return this.daPrcCmdtDefCd;
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
	 * @return oaTypCurrCd
	 */
	public String getOaTypCurrCd() {
		return this.oaTypCurrCd;
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
	 * @return daTypNoteConvTpCd
	 */
	public String getDaTypNoteConvTpCd() {
		return this.daTypNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtAddBkgConvTpCd
	 */
	public String getRtAddBkgConvTpCd() {
		return this.rtAddBkgConvTpCd;
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
	 * @return oaRacNoteConvSeq
	 */
	public String getOaRacNoteConvSeq() {
		return this.oaRacNoteConvSeq;
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
	 * @return rtDorFrtRtAmt
	 */
	public String getRtDorFrtRtAmt() {
		return this.rtDorFrtRtAmt;
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
	 * @return oaPrcCmdtDefCd
	 */
	public String getOaPrcCmdtDefCd() {
		return this.oaPrcCmdtDefCd;
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
	 * @return oiRoutPntLocDefCd
	 */
	public String getOiRoutPntLocDefCd() {
		return this.oiRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return oiDirCallFlg
	 */
	public String getOiDirCallFlg() {
		return this.oiDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
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
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return daViaPortDefCd
	 */
	public String getDaViaPortDefCd() {
		return this.daViaPortDefCd;
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
	 * @return diRatUtCd
	 */
	public String getDiRatUtCd() {
		return this.diRatUtCd;
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
	 * @return prcRtSeq
	 */
	public String getPrcRtSeq() {
		return this.prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @return rtRarFrtRtAmt
	 */
	public String getRtRarFrtRtAmt() {
		return this.rtRarFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return oaDirCallFlg
	 */
	public String getOaDirCallFlg() {
		return this.oaDirCallFlg;
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
	 * @return rtArbFrtRtAmt
	 */
	public String getRtArbFrtRtAmt() {
		return this.rtArbFrtRtAmt;
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
	 * @return rtDorCurrCd
	 */
	public String getRtDorCurrCd() {
		return this.rtDorCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtRacNoteConvTpCd
	 */
	public String getRtRacNoteConvTpCd() {
		return this.rtRacNoteConvTpCd;
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
	 * @return rtRarNoteConvRuleCd
	 */
	public String getRtRarNoteConvRuleCd() {
		return this.rtRarNoteConvRuleCd;
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
	 * @return rtArbNoteConvSeq
	 */
	public String getRtArbNoteConvSeq() {
		return this.rtArbNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return daRacNoteConvSeq
	 */
	public String getDaRacNoteConvSeq() {
		return this.daRacNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtTypNoteConvSeq
	 */
	public String getRtTypNoteConvSeq() {
		return this.rtTypNoteConvSeq;
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
	 * @return rtAddNoteConvTpCd
	 */
	public String getRtAddNoteConvTpCd() {
		return this.rtAddNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtTypCurrCd
	 */
	public String getRtTypCurrCd() {
		return this.rtTypCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtAddNoteConvSeq
	 */
	public String getRtAddNoteConvSeq() {
		return this.rtAddNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtDorRtOpCd
	 */
	public String getRtDorRtOpCd() {
		return this.rtDorRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return rtRarNoteConvSeq
	 */
	public String getRtRarNoteConvSeq() {
		return this.rtRarNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtDorNoteConvMapgId
	 */
	public String getRtDorNoteConvMapgId() {
		return this.rtDorNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return rtArbCurrCd
	 */
	public String getRtArbCurrCd() {
		return this.rtArbCurrCd;
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
	 * @return daRoutPntLocDefCd
	 */
	public String getDaRoutPntLocDefCd() {
		return this.daRoutPntLocDefCd;
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
	 * @return rtCurrCd
	 */
	public String getRtCurrCd() {
		return this.rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtAddNoteConvRuleCd
	 */
	public String getRtAddNoteConvRuleCd() {
		return this.rtAddNoteConvRuleCd;
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
	 * @return rtRacBkgConvTpCd
	 */
	public String getRtRacBkgConvTpCd() {
		return this.rtRacBkgConvTpCd;
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
	 * @return rtTypNoteConvTpCd
	 */
	public String getRtTypNoteConvTpCd() {
		return this.rtTypNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtRacNoteConvMapgId
	 */
	public String getRtRacNoteConvMapgId() {
		return this.rtRacNoteConvMapgId;
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
	 * @return rtAddFrtRtAmt
	 */
	public String getRtAddFrtRtAmt() {
		return this.rtAddFrtRtAmt;
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
	 * @return rtRapNoteConvSeq
	 */
	public String getRtRapNoteConvSeq() {
		return this.rtRapNoteConvSeq;
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
	 * @return rtAddCurrCd
	 */
	public String getRtAddCurrCd() {
		return this.rtAddCurrCd;
	}
	
	/**
	 * Column Info
	 * @return oaRacNoteConvTpCd
	 */
	public String getOaRacNoteConvTpCd() {
		return this.oaRacNoteConvTpCd;
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
	 * @return daCurrCd
	 */
	public String getDaCurrCd() {
		return this.daCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rtArbNoteConvRuleCd
	 */
	public String getRtArbNoteConvRuleCd() {
		return this.rtArbNoteConvRuleCd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rtRacRtOpCd
	 */
	public String getRtRacRtOpCd() {
		return this.rtRacRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return oaRacRtOpCd
	 */
	public String getOaRacRtOpCd() {
		return this.oaRacRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return rtRapNoteConvTpCd
	 */
	public String getRtRapNoteConvTpCd() {
		return this.rtRapNoteConvTpCd;
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
	 * @return oaTypFrtRtAmt
	 */
	public String getOaTypFrtRtAmt() {
		return this.oaTypFrtRtAmt;
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
	 * @return daRacNoteConvMapgId
	 */
	public String getDaRacNoteConvMapgId() {
		return this.daRacNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return rtTypRtOpCd
	 */
	public String getRtTypRtOpCd() {
		return this.rtTypRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return rdDirCallFlg
	 */
	public String getRdDirCallFlg() {
		return this.rdDirCallFlg;
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
	 * @return oaTypNoteConvSeq
	 */
	public String getOaTypNoteConvSeq() {
		return this.oaTypNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return rtRapRtOpCd
	 */
	public String getRtRapRtOpCd() {
		return this.rtRapRtOpCd;
	}
	
	/**
	 * Column Info
	 * @return daRacCurrCd
	 */
	public String getDaRacCurrCd() {
		return this.daRacCurrCd;
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
	 * @return rtDorBkgConvTpCd
	 */
	public String getRtDorBkgConvTpCd() {
		return this.rtDorBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtRacNoteConvRuleCd
	 */
	public String getRtRacNoteConvRuleCd() {
		return this.rtRacNoteConvRuleCd;
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
	 * @return diBsePortDefCd
	 */
	public String getDiBsePortDefCd() {
		return this.diBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @return diPrcCmdtDefCd
	 */
	public String getDiPrcCmdtDefCd() {
		return this.diPrcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtRapNoteConvMapgId
	 */
	public String getRtRapNoteConvMapgId() {
		return this.rtRapNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return daTypNoteConvRuleCd
	 */
	public String getDaTypNoteConvRuleCd() {
		return this.daTypNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @return rtAddNoteConvMapgId
	 */
	public String getRtAddNoteConvMapgId() {
		return this.rtAddNoteConvMapgId;
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
	 * @return rtArbBkgConvTpCd
	 */
	public String getRtArbBkgConvTpCd() {
		return this.rtArbBkgConvTpCd;
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
	 * @return daRacNoteConvTpCd
	 */
	public String getDaRacNoteConvTpCd() {
		return this.daRacNoteConvTpCd;
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
	 * @return oaViaPortDefCd
	 */
	public String getOaViaPortDefCd() {
		return this.oaViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return rtTypBkgConvTpCd
	 */
	public String getRtTypBkgConvTpCd() {
		return this.rtTypBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return bqPrcCgoTpCd
	 */
	public String getBqPrcCgoTpCd() {
		return this.bqPrcCgoTpCd;
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
	 * @return rtAppRtOpCd
	 */
	public String getRtAppRtOpCd() {
		return this.rtAppRtOpCd;
	}
	

	/**
	 * Column Info
	 * @param oaTypBkgConvTpCd
	 */
	public void setOaTypBkgConvTpCd(String oaTypBkgConvTpCd) {
		this.oaTypBkgConvTpCd = oaTypBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param daTypNoteConvMapgId
	 */
	public void setDaTypNoteConvMapgId(String daTypNoteConvMapgId) {
		this.daTypNoteConvMapgId = daTypNoteConvMapgId;
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
	 * Column Info
	 * @param diPrcTrspModCd
	 */
	public void setDiPrcTrspModCd(String diPrcTrspModCd) {
		this.diPrcTrspModCd = diPrcTrspModCd;
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
	 * @param daTypBkgConvTpCd
	 */
	public void setDaTypBkgConvTpCd(String daTypBkgConvTpCd) {
		this.daTypBkgConvTpCd = daTypBkgConvTpCd;
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
	 * @param rtTypNoteConvRuleCd
	 */
	public void setRtTypNoteConvRuleCd(String rtTypNoteConvRuleCd) {
		this.rtTypNoteConvRuleCd = rtTypNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param daTypNoteConvSeq
	 */
	public void setDaTypNoteConvSeq(String daTypNoteConvSeq) {
		this.daTypNoteConvSeq = daTypNoteConvSeq;
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
	 * @param ovRoutViaPortDefCd
	 */
	public void setOvRoutViaPortDefCd(String ovRoutViaPortDefCd) {
		this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
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
	 * @param daFnlFrtRtAmt
	 */
	public void setDaFnlFrtRtAmt(String daFnlFrtRtAmt) {
		this.daFnlFrtRtAmt = daFnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRarBkgConvTpCd
	 */
	public void setRtRarBkgConvTpCd(String rtRarBkgConvTpCd) {
		this.rtRarBkgConvTpCd = rtRarBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param daRacDaOpCd
	 */
	public void setDaRacDaOpCd(String daRacDaOpCd) {
		this.daRacDaOpCd = daRacDaOpCd;
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
	 * @param oaRacFrtRtAmt
	 */
	public void setOaRacFrtRtAmt(String oaRacFrtRtAmt) {
		this.oaRacFrtRtAmt = oaRacFrtRtAmt;
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
	 * @param cmPrcCmdtTpCd
	 */
	public void setCmPrcCmdtTpCd(String cmPrcCmdtTpCd) {
		this.cmPrcCmdtTpCd = cmPrcCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param oaTypRtOpCd
	 */
	public void setOaTypRtOpCd(String oaTypRtOpCd) {
		this.oaTypRtOpCd = oaTypRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param oaRacBkgConvTpCd
	 */
	public void setOaRacBkgConvTpCd(String oaRacBkgConvTpCd) {
		this.oaRacBkgConvTpCd = oaRacBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtRarCurrCd
	 */
	public void setRtRarCurrCd(String rtRarCurrCd) {
		this.rtRarCurrCd = rtRarCurrCd;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param oaTypNoteConvRuleCd
	 */
	public void setOaTypNoteConvRuleCd(String oaTypNoteConvRuleCd) {
		this.oaTypNoteConvRuleCd = oaTypNoteConvRuleCd;
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
	 * @param rtRapCurrCd
	 */
	public void setRtRapCurrCd(String rtRapCurrCd) {
		this.rtRapCurrCd = rtRapCurrCd;
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
	 * @param rtRacCurrCd
	 */
	public void setRtRacCurrCd(String rtRacCurrCd) {
		this.rtRacCurrCd = rtRacCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oaRacCurrCd
	 */
	public void setOaRacCurrCd(String oaRacCurrCd) {
		this.oaRacCurrCd = oaRacCurrCd;
	}
	
	/**
	 * Column Info
	 * @param daTypDaOpCd
	 */
	public void setDaTypDaOpCd(String daTypDaOpCd) {
		this.daTypDaOpCd = daTypDaOpCd;
	}
	
	/**
	 * Column Info
	 * @param rtDorNoteConvTpCd
	 */
	public void setRtDorNoteConvTpCd(String rtDorNoteConvTpCd) {
		this.rtDorNoteConvTpCd = rtDorNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param daRacBkgConvTpCd
	 */
	public void setDaRacBkgConvTpCd(String daRacBkgConvTpCd) {
		this.daRacBkgConvTpCd = daRacBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param oaRacNoteConvMapgId
	 */
	public void setOaRacNoteConvMapgId(String oaRacNoteConvMapgId) {
		this.oaRacNoteConvMapgId = oaRacNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param daRacNoteConvRuleCd
	 */
	public void setDaRacNoteConvRuleCd(String daRacNoteConvRuleCd) {
		this.daRacNoteConvRuleCd = daRacNoteConvRuleCd;
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
	 * @param rtRacFrtRtAmt
	 */
	public void setRtRacFrtRtAmt(String rtRacFrtRtAmt) {
		this.rtRacFrtRtAmt = rtRacFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtAddRtOpCd
	 */
	public void setRtAddRtOpCd(String rtAddRtOpCd) {
		this.rtAddRtOpCd = rtAddRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param diDirCallFlg
	 */
	public void setDiDirCallFlg(String diDirCallFlg) {
		this.diDirCallFlg = diDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param rtRapFrtRtAmt
	 */
	public void setRtRapFrtRtAmt(String rtRapFrtRtAmt) {
		this.rtRapFrtRtAmt = rtRapFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtRacNoteConvSeq
	 */
	public void setRtRacNoteConvSeq(String rtRacNoteConvSeq) {
		this.rtRacNoteConvSeq = rtRacNoteConvSeq;
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
	 * @param daTypFrtRtAmt
	 */
	public void setDaTypFrtRtAmt(String daTypFrtRtAmt) {
		this.daTypFrtRtAmt = daTypFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtDorNoteConvRuleCd
	 */
	public void setRtDorNoteConvRuleCd(String rtDorNoteConvRuleCd) {
		this.rtDorNoteConvRuleCd = rtDorNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param oaTypNoteConvMapgId
	 */
	public void setOaTypNoteConvMapgId(String oaTypNoteConvMapgId) {
		this.oaTypNoteConvMapgId = oaTypNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param rtArbRtOpCd
	 */
	public void setRtArbRtOpCd(String rtArbRtOpCd) {
		this.rtArbRtOpCd = rtArbRtOpCd;
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
	 * @param rtRapBkgConvTpCd
	 */
	public void setRtRapBkgConvTpCd(String rtRapBkgConvTpCd) {
		this.rtRapBkgConvTpCd = rtRapBkgConvTpCd;
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
	 * @param diPrcCgoTpCd
	 */
	public void setDiPrcCgoTpCd(String diPrcCgoTpCd) {
		this.diPrcCgoTpCd = diPrcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtArbNoteConvMapgId
	 */
	public void setRtArbNoteConvMapgId(String rtArbNoteConvMapgId) {
		this.rtArbNoteConvMapgId = rtArbNoteConvMapgId;
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
	 * @param prcGenSpclRtTpCd
	 */
	public void setPrcGenSpclRtTpCd(String prcGenSpclRtTpCd) {
		this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtRarNoteConvTpCd
	 */
	public void setRtRarNoteConvTpCd(String rtRarNoteConvTpCd) {
		this.rtRarNoteConvTpCd = rtRarNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param oiPrcCmdtDefCd
	 */
	public void setOiPrcCmdtDefCd(String oiPrcCmdtDefCd) {
		this.oiPrcCmdtDefCd = oiPrcCmdtDefCd;
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
	 * @param oaRacNoteConvRuleCd
	 */
	public void setOaRacNoteConvRuleCd(String oaRacNoteConvRuleCd) {
		this.oaRacNoteConvRuleCd = oaRacNoteConvRuleCd;
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
	 * @param oiAddChgSeq
	 */
	public void setOiAddChgSeq(String oiAddChgSeq) {
		this.oiAddChgSeq = oiAddChgSeq;
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
	 * @param rtRarRtOpCd
	 */
	public void setRtRarRtOpCd(String rtRarRtOpCd) {
		this.rtRarRtOpCd = rtRarRtOpCd;
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
	 * @param rtRapNoteConvRuleCd
	 */
	public void setRtRapNoteConvRuleCd(String rtRapNoteConvRuleCd) {
		this.rtRapNoteConvRuleCd = rtRapNoteConvRuleCd;
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
	 * @param daDirCallFlg
	 */
	public void setDaDirCallFlg(String daDirCallFlg) {
		this.daDirCallFlg = daDirCallFlg;
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
	 * @param rtTypFrtRtAmt
	 */
	public void setRtTypFrtRtAmt(String rtTypFrtRtAmt) {
		this.rtTypFrtRtAmt = rtTypFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rtTypNoteConvMapgId
	 */
	public void setRtTypNoteConvMapgId(String rtTypNoteConvMapgId) {
		this.rtTypNoteConvMapgId = rtTypNoteConvMapgId;
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
	 * @param oaTypNoteConvTpCd
	 */
	public void setOaTypNoteConvTpCd(String oaTypNoteConvTpCd) {
		this.oaTypNoteConvTpCd = oaTypNoteConvTpCd;
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
	 * @param rtDorNoteConvSeq
	 */
	public void setRtDorNoteConvSeq(String rtDorNoteConvSeq) {
		this.rtDorNoteConvSeq = rtDorNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtArbNoteConvTpCd
	 */
	public void setRtArbNoteConvTpCd(String rtArbNoteConvTpCd) {
		this.rtArbNoteConvTpCd = rtArbNoteConvTpCd;
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
	 * @param daBsePortDefCd
	 */
	public void setDaBsePortDefCd(String daBsePortDefCd) {
		this.daBsePortDefCd = daBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param daRacFrtRtAmt
	 */
	public void setDaRacFrtRtAmt(String daRacFrtRtAmt) {
		this.daRacFrtRtAmt = daRacFrtRtAmt;
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
	 * @param oiPrcTrspModCd
	 */
	public void setOiPrcTrspModCd(String oiPrcTrspModCd) {
		this.oiPrcTrspModCd = oiPrcTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param rtRarNoteConvMapgId
	 */
	public void setRtRarNoteConvMapgId(String rtRarNoteConvMapgId) {
		this.rtRarNoteConvMapgId = rtRarNoteConvMapgId;
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
	 * @param daTypCurrCd
	 */
	public void setDaTypCurrCd(String daTypCurrCd) {
		this.daTypCurrCd = daTypCurrCd;
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
	 * @param daPrcCmdtDefCd
	 */
	public void setDaPrcCmdtDefCd(String daPrcCmdtDefCd) {
		this.daPrcCmdtDefCd = daPrcCmdtDefCd;
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
	 * @param oaTypCurrCd
	 */
	public void setOaTypCurrCd(String oaTypCurrCd) {
		this.oaTypCurrCd = oaTypCurrCd;
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
	 * @param daTypNoteConvTpCd
	 */
	public void setDaTypNoteConvTpCd(String daTypNoteConvTpCd) {
		this.daTypNoteConvTpCd = daTypNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtAddBkgConvTpCd
	 */
	public void setRtAddBkgConvTpCd(String rtAddBkgConvTpCd) {
		this.rtAddBkgConvTpCd = rtAddBkgConvTpCd;
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
	 * @param oaRacNoteConvSeq
	 */
	public void setOaRacNoteConvSeq(String oaRacNoteConvSeq) {
		this.oaRacNoteConvSeq = oaRacNoteConvSeq;
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
	 * @param rtDorFrtRtAmt
	 */
	public void setRtDorFrtRtAmt(String rtDorFrtRtAmt) {
		this.rtDorFrtRtAmt = rtDorFrtRtAmt;
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
	 * @param oaPrcCmdtDefCd
	 */
	public void setOaPrcCmdtDefCd(String oaPrcCmdtDefCd) {
		this.oaPrcCmdtDefCd = oaPrcCmdtDefCd;
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
	 * @param oiRoutPntLocDefCd
	 */
	public void setOiRoutPntLocDefCd(String oiRoutPntLocDefCd) {
		this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param oiDirCallFlg
	 */
	public void setOiDirCallFlg(String oiDirCallFlg) {
		this.oiDirCallFlg = oiDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
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
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param daViaPortDefCd
	 */
	public void setDaViaPortDefCd(String daViaPortDefCd) {
		this.daViaPortDefCd = daViaPortDefCd;
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
	 * @param diRatUtCd
	 */
	public void setDiRatUtCd(String diRatUtCd) {
		this.diRatUtCd = diRatUtCd;
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
	 * @param prcRtSeq
	 */
	public void setPrcRtSeq(String prcRtSeq) {
		this.prcRtSeq = prcRtSeq;
	}
	
	/**
	 * Column Info
	 * @param rtRarFrtRtAmt
	 */
	public void setRtRarFrtRtAmt(String rtRarFrtRtAmt) {
		this.rtRarFrtRtAmt = rtRarFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param oaDirCallFlg
	 */
	public void setOaDirCallFlg(String oaDirCallFlg) {
		this.oaDirCallFlg = oaDirCallFlg;
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
	 * @param rtArbFrtRtAmt
	 */
	public void setRtArbFrtRtAmt(String rtArbFrtRtAmt) {
		this.rtArbFrtRtAmt = rtArbFrtRtAmt;
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
	 * @param rtDorCurrCd
	 */
	public void setRtDorCurrCd(String rtDorCurrCd) {
		this.rtDorCurrCd = rtDorCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtRacNoteConvTpCd
	 */
	public void setRtRacNoteConvTpCd(String rtRacNoteConvTpCd) {
		this.rtRacNoteConvTpCd = rtRacNoteConvTpCd;
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
	 * @param rtRarNoteConvRuleCd
	 */
	public void setRtRarNoteConvRuleCd(String rtRarNoteConvRuleCd) {
		this.rtRarNoteConvRuleCd = rtRarNoteConvRuleCd;
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
	 * @param rtArbNoteConvSeq
	 */
	public void setRtArbNoteConvSeq(String rtArbNoteConvSeq) {
		this.rtArbNoteConvSeq = rtArbNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param daRacNoteConvSeq
	 */
	public void setDaRacNoteConvSeq(String daRacNoteConvSeq) {
		this.daRacNoteConvSeq = daRacNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtTypNoteConvSeq
	 */
	public void setRtTypNoteConvSeq(String rtTypNoteConvSeq) {
		this.rtTypNoteConvSeq = rtTypNoteConvSeq;
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
	 * @param rtAddNoteConvTpCd
	 */
	public void setRtAddNoteConvTpCd(String rtAddNoteConvTpCd) {
		this.rtAddNoteConvTpCd = rtAddNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtTypCurrCd
	 */
	public void setRtTypCurrCd(String rtTypCurrCd) {
		this.rtTypCurrCd = rtTypCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtAddNoteConvSeq
	 */
	public void setRtAddNoteConvSeq(String rtAddNoteConvSeq) {
		this.rtAddNoteConvSeq = rtAddNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtDorRtOpCd
	 */
	public void setRtDorRtOpCd(String rtDorRtOpCd) {
		this.rtDorRtOpCd = rtDorRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param rtRarNoteConvSeq
	 */
	public void setRtRarNoteConvSeq(String rtRarNoteConvSeq) {
		this.rtRarNoteConvSeq = rtRarNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtDorNoteConvMapgId
	 */
	public void setRtDorNoteConvMapgId(String rtDorNoteConvMapgId) {
		this.rtDorNoteConvMapgId = rtDorNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param rtArbCurrCd
	 */
	public void setRtArbCurrCd(String rtArbCurrCd) {
		this.rtArbCurrCd = rtArbCurrCd;
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
	 * @param daRoutPntLocDefCd
	 */
	public void setDaRoutPntLocDefCd(String daRoutPntLocDefCd) {
		this.daRoutPntLocDefCd = daRoutPntLocDefCd;
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
	 * @param rtCurrCd
	 */
	public void setRtCurrCd(String rtCurrCd) {
		this.rtCurrCd = rtCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtAddNoteConvRuleCd
	 */
	public void setRtAddNoteConvRuleCd(String rtAddNoteConvRuleCd) {
		this.rtAddNoteConvRuleCd = rtAddNoteConvRuleCd;
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
	 * @param rtRacBkgConvTpCd
	 */
	public void setRtRacBkgConvTpCd(String rtRacBkgConvTpCd) {
		this.rtRacBkgConvTpCd = rtRacBkgConvTpCd;
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
	 * @param rtTypNoteConvTpCd
	 */
	public void setRtTypNoteConvTpCd(String rtTypNoteConvTpCd) {
		this.rtTypNoteConvTpCd = rtTypNoteConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtRacNoteConvMapgId
	 */
	public void setRtRacNoteConvMapgId(String rtRacNoteConvMapgId) {
		this.rtRacNoteConvMapgId = rtRacNoteConvMapgId;
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
	 * @param rtAddFrtRtAmt
	 */
	public void setRtAddFrtRtAmt(String rtAddFrtRtAmt) {
		this.rtAddFrtRtAmt = rtAddFrtRtAmt;
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
	 * @param rtRapNoteConvSeq
	 */
	public void setRtRapNoteConvSeq(String rtRapNoteConvSeq) {
		this.rtRapNoteConvSeq = rtRapNoteConvSeq;
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
	 * @param rtAddCurrCd
	 */
	public void setRtAddCurrCd(String rtAddCurrCd) {
		this.rtAddCurrCd = rtAddCurrCd;
	}
	
	/**
	 * Column Info
	 * @param oaRacNoteConvTpCd
	 */
	public void setOaRacNoteConvTpCd(String oaRacNoteConvTpCd) {
		this.oaRacNoteConvTpCd = oaRacNoteConvTpCd;
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
	 * @param daCurrCd
	 */
	public void setDaCurrCd(String daCurrCd) {
		this.daCurrCd = daCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rtArbNoteConvRuleCd
	 */
	public void setRtArbNoteConvRuleCd(String rtArbNoteConvRuleCd) {
		this.rtArbNoteConvRuleCd = rtArbNoteConvRuleCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rtRacRtOpCd
	 */
	public void setRtRacRtOpCd(String rtRacRtOpCd) {
		this.rtRacRtOpCd = rtRacRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param oaRacRtOpCd
	 */
	public void setOaRacRtOpCd(String oaRacRtOpCd) {
		this.oaRacRtOpCd = oaRacRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param rtRapNoteConvTpCd
	 */
	public void setRtRapNoteConvTpCd(String rtRapNoteConvTpCd) {
		this.rtRapNoteConvTpCd = rtRapNoteConvTpCd;
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
	 * @param oaTypFrtRtAmt
	 */
	public void setOaTypFrtRtAmt(String oaTypFrtRtAmt) {
		this.oaTypFrtRtAmt = oaTypFrtRtAmt;
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
	 * @param daRacNoteConvMapgId
	 */
	public void setDaRacNoteConvMapgId(String daRacNoteConvMapgId) {
		this.daRacNoteConvMapgId = daRacNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param rtTypRtOpCd
	 */
	public void setRtTypRtOpCd(String rtTypRtOpCd) {
		this.rtTypRtOpCd = rtTypRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param rdDirCallFlg
	 */
	public void setRdDirCallFlg(String rdDirCallFlg) {
		this.rdDirCallFlg = rdDirCallFlg;
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
	 * @param oaTypNoteConvSeq
	 */
	public void setOaTypNoteConvSeq(String oaTypNoteConvSeq) {
		this.oaTypNoteConvSeq = oaTypNoteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param rtRapRtOpCd
	 */
	public void setRtRapRtOpCd(String rtRapRtOpCd) {
		this.rtRapRtOpCd = rtRapRtOpCd;
	}
	
	/**
	 * Column Info
	 * @param daRacCurrCd
	 */
	public void setDaRacCurrCd(String daRacCurrCd) {
		this.daRacCurrCd = daRacCurrCd;
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
	 * @param rtDorBkgConvTpCd
	 */
	public void setRtDorBkgConvTpCd(String rtDorBkgConvTpCd) {
		this.rtDorBkgConvTpCd = rtDorBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtRacNoteConvRuleCd
	 */
	public void setRtRacNoteConvRuleCd(String rtRacNoteConvRuleCd) {
		this.rtRacNoteConvRuleCd = rtRacNoteConvRuleCd;
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
	 * @param diBsePortDefCd
	 */
	public void setDiBsePortDefCd(String diBsePortDefCd) {
		this.diBsePortDefCd = diBsePortDefCd;
	}
	
	/**
	 * Column Info
	 * @param diPrcCmdtDefCd
	 */
	public void setDiPrcCmdtDefCd(String diPrcCmdtDefCd) {
		this.diPrcCmdtDefCd = diPrcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtRapNoteConvMapgId
	 */
	public void setRtRapNoteConvMapgId(String rtRapNoteConvMapgId) {
		this.rtRapNoteConvMapgId = rtRapNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param daTypNoteConvRuleCd
	 */
	public void setDaTypNoteConvRuleCd(String daTypNoteConvRuleCd) {
		this.daTypNoteConvRuleCd = daTypNoteConvRuleCd;
	}
	
	/**
	 * Column Info
	 * @param rtAddNoteConvMapgId
	 */
	public void setRtAddNoteConvMapgId(String rtAddNoteConvMapgId) {
		this.rtAddNoteConvMapgId = rtAddNoteConvMapgId;
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
	 * @param rtArbBkgConvTpCd
	 */
	public void setRtArbBkgConvTpCd(String rtArbBkgConvTpCd) {
		this.rtArbBkgConvTpCd = rtArbBkgConvTpCd;
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
	 * @param daRacNoteConvTpCd
	 */
	public void setDaRacNoteConvTpCd(String daRacNoteConvTpCd) {
		this.daRacNoteConvTpCd = daRacNoteConvTpCd;
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
	 * @param oaViaPortDefCd
	 */
	public void setOaViaPortDefCd(String oaViaPortDefCd) {
		this.oaViaPortDefCd = oaViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param rtTypBkgConvTpCd
	 */
	public void setRtTypBkgConvTpCd(String rtTypBkgConvTpCd) {
		this.rtTypBkgConvTpCd = rtTypBkgConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param bqPrcCgoTpCd
	 */
	public void setBqPrcCgoTpCd(String bqPrcCgoTpCd) {
		this.bqPrcCgoTpCd = bqPrcCgoTpCd;
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
	 * @param rtAppRtOpCd
	 */
	public void setRtAppRtOpCd(String rtAppRtOpCd) {
		this.rtAppRtOpCd = rtAppRtOpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOaTypBkgConvTpCd(JSPUtil.getParameter(request, "oa_typ_bkg_conv_tp_cd", ""));
		setDaTypNoteConvMapgId(JSPUtil.getParameter(request, "da_typ_note_conv_mapg_id", ""));
		setOaPrcTrspModCd(JSPUtil.getParameter(request, "oa_prc_trsp_mod_cd", ""));
		setDaAddChgSeq(JSPUtil.getParameter(request, "da_add_chg_seq", ""));
		setDiPrcTrspModCd(JSPUtil.getParameter(request, "di_prc_trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDaTypBkgConvTpCd(JSPUtil.getParameter(request, "da_typ_bkg_conv_tp_cd", ""));
		setOaRcvDeTermCd(JSPUtil.getParameter(request, "oa_rcv_de_term_cd", ""));
		setRtTypNoteConvRuleCd(JSPUtil.getParameter(request, "rt_typ_note_conv_rule_cd", ""));
		setDaTypNoteConvSeq(JSPUtil.getParameter(request, "da_typ_note_conv_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOvRoutViaPortDefCd(JSPUtil.getParameter(request, "ov_rout_via_port_def_cd", ""));
		setOaCurrCd(JSPUtil.getParameter(request, "oa_curr_cd", ""));
		setDaFnlFrtRtAmt(JSPUtil.getParameter(request, "da_fnl_frt_rt_amt", ""));
		setRtRarBkgConvTpCd(JSPUtil.getParameter(request, "rt_rar_bkg_conv_tp_cd", ""));
		setDaRacDaOpCd(JSPUtil.getParameter(request, "da_rac_da_op_cd", ""));
		setBqSeq(JSPUtil.getParameter(request, "bq_seq", ""));
		setDpPrcTrspModCd(JSPUtil.getParameter(request, "dp_prc_trsp_mod_cd", ""));
		setRtAppBkgConvTpCd(JSPUtil.getParameter(request, "rt_app_bkg_conv_tp_cd", ""));
		setOpPrcTrspModCd(JSPUtil.getParameter(request, "op_prc_trsp_mod_cd", ""));
		setOaRacFrtRtAmt(JSPUtil.getParameter(request, "oa_rac_frt_rt_amt", ""));
		setDiRcvDeTermCd(JSPUtil.getParameter(request, "di_rcv_de_term_cd", ""));
		setCmPrcCmdtTpCd(JSPUtil.getParameter(request, "cm_prc_cmdt_tp_cd", ""));
		setOaTypRtOpCd(JSPUtil.getParameter(request, "oa_typ_rt_op_cd", ""));
		setOaRacBkgConvTpCd(JSPUtil.getParameter(request, "oa_rac_bkg_conv_tp_cd", ""));
		setRtRarCurrCd(JSPUtil.getParameter(request, "rt_rar_curr_cd", ""));
		setDiCurrCd(JSPUtil.getParameter(request, "di_curr_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setOaTypNoteConvRuleCd(JSPUtil.getParameter(request, "oa_typ_note_conv_rule_cd", ""));
		setRtRasBkgConvTpCd(JSPUtil.getParameter(request, "rt_ras_bkg_conv_tp_cd", ""));
		setRtRapCurrCd(JSPUtil.getParameter(request, "rt_rap_curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setOiRatUtCd(JSPUtil.getParameter(request, "oi_rat_ut_cd", ""));
		setRtRacCurrCd(JSPUtil.getParameter(request, "rt_rac_curr_cd", ""));
		setOaRacCurrCd(JSPUtil.getParameter(request, "oa_rac_curr_cd", ""));
		setDaTypDaOpCd(JSPUtil.getParameter(request, "da_typ_da_op_cd", ""));
		setRtDorNoteConvTpCd(JSPUtil.getParameter(request, "rt_dor_note_conv_tp_cd", ""));
		setDaRacBkgConvTpCd(JSPUtil.getParameter(request, "da_rac_bkg_conv_tp_cd", ""));
		setOaRacNoteConvMapgId(JSPUtil.getParameter(request, "oa_rac_note_conv_mapg_id", ""));
		setDaRacNoteConvRuleCd(JSPUtil.getParameter(request, "da_rac_note_conv_rule_cd", ""));
		setRtAppNoteConvSeq(JSPUtil.getParameter(request, "rt_app_note_conv_seq", ""));
		setRtRasNoteConvTpCd(JSPUtil.getParameter(request, "rt_ras_note_conv_tp_cd", ""));
		setRtPrcCgoTpCd(JSPUtil.getParameter(request, "rt_prc_cgo_tp_cd", ""));
		setRtRacFrtRtAmt(JSPUtil.getParameter(request, "rt_rac_frt_rt_amt", ""));
		setRtAddRtOpCd(JSPUtil.getParameter(request, "rt_add_rt_op_cd", ""));
		setDiDirCallFlg(JSPUtil.getParameter(request, "di_dir_call_flg", ""));
		setRtRapFrtRtAmt(JSPUtil.getParameter(request, "rt_rap_frt_rt_amt", ""));
		setRtRacNoteConvSeq(JSPUtil.getParameter(request, "rt_rac_note_conv_seq", ""));
		setBqDelApplFlg(JSPUtil.getParameter(request, "bq_del_appl_flg", ""));
		setDaRcvDeTermCd(JSPUtil.getParameter(request, "da_rcv_de_term_cd", ""));
		setDaTypFrtRtAmt(JSPUtil.getParameter(request, "da_typ_frt_rt_amt", ""));
		setRtDorNoteConvRuleCd(JSPUtil.getParameter(request, "rt_dor_note_conv_rule_cd", ""));
		setOaTypNoteConvMapgId(JSPUtil.getParameter(request, "oa_typ_note_conv_mapg_id", ""));
		setRtArbRtOpCd(JSPUtil.getParameter(request, "rt_arb_rt_op_cd", ""));
		setBqPorRlyPortApplFlg(JSPUtil.getParameter(request, "bq_por_rly_port_appl_flg", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCmPrcCmdtDefCd(JSPUtil.getParameter(request, "cm_prc_cmdt_def_cd", ""));
		setRtRapBkgConvTpCd(JSPUtil.getParameter(request, "rt_rap_bkg_conv_tp_cd", ""));
		setBqPorApplFlg(JSPUtil.getParameter(request, "bq_por_appl_flg", ""));
		setDiPrcCgoTpCd(JSPUtil.getParameter(request, "di_prc_cgo_tp_cd", ""));
		setRtArbNoteConvMapgId(JSPUtil.getParameter(request, "rt_arb_note_conv_mapg_id", ""));
		setDtl(JSPUtil.getParameter(request, "dtl", ""));
		setBqPolApplFlg(JSPUtil.getParameter(request, "bq_pol_appl_flg", ""));
		setDestTrspModCd(JSPUtil.getParameter(request, "dest_trsp_mod_cd", ""));
		setRtRasRtOpCd(JSPUtil.getParameter(request, "rt_ras_rt_op_cd", ""));
		setPrcGenSpclRtTpCd(JSPUtil.getParameter(request, "prc_gen_spcl_rt_tp_cd", ""));
		setRtRarNoteConvTpCd(JSPUtil.getParameter(request, "rt_rar_note_conv_tp_cd", ""));
		setOiPrcCmdtDefCd(JSPUtil.getParameter(request, "oi_prc_cmdt_def_cd", ""));
		setDiFnlFrtRtAmt(JSPUtil.getParameter(request, "di_fnl_frt_rt_amt", ""));
		setRtAppNoteConvRuleCd(JSPUtil.getParameter(request, "rt_app_note_conv_rule_cd", ""));
		setOaRacNoteConvRuleCd(JSPUtil.getParameter(request, "oa_rac_note_conv_rule_cd", ""));
		setOiPrcCgoTpCd(JSPUtil.getParameter(request, "oi_prc_cgo_tp_cd", ""));
		setOiAddChgSeq(JSPUtil.getParameter(request, "oi_add_chg_seq", ""));
		setDaPrcTrspModCd(JSPUtil.getParameter(request, "da_prc_trsp_mod_cd", ""));
		setRtRarRtOpCd(JSPUtil.getParameter(request, "rt_rar_rt_op_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setRtRapNoteConvRuleCd(JSPUtil.getParameter(request, "rt_rap_note_conv_rule_cd", ""));
		setRtAppCurrCd(JSPUtil.getParameter(request, "rt_app_curr_cd", ""));
		setRtRasNoteConvSeq(JSPUtil.getParameter(request, "rt_ras_note_conv_seq", ""));
		setDaDirCallFlg(JSPUtil.getParameter(request, "da_dir_call_flg", ""));
		setOaRoutPntLocDefCd(JSPUtil.getParameter(request, "oa_rout_pnt_loc_def_cd", ""));
		setRtTypFrtRtAmt(JSPUtil.getParameter(request, "rt_typ_frt_rt_amt", ""));
		setRtTypNoteConvMapgId(JSPUtil.getParameter(request, "rt_typ_note_conv_mapg_id", ""));
		setNoteCtnt(JSPUtil.getParameter(request, "note_ctnt", ""));
		setOaRatUtCd(JSPUtil.getParameter(request, "oa_rat_ut_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRtFnlFrtRtAmt(JSPUtil.getParameter(request, "rt_fnl_frt_rt_amt", ""));
		setOaTypNoteConvTpCd(JSPUtil.getParameter(request, "oa_typ_note_conv_tp_cd", ""));
		setDvRoutViaPortDefCd(JSPUtil.getParameter(request, "dv_rout_via_port_def_cd", ""));
		setRtDorNoteConvSeq(JSPUtil.getParameter(request, "rt_dor_note_conv_seq", ""));
		setRtArbNoteConvTpCd(JSPUtil.getParameter(request, "rt_arb_note_conv_tp_cd", ""));
		setRtRasNoteConvMapgId(JSPUtil.getParameter(request, "rt_ras_note_conv_mapg_id", ""));
		setDaBsePortDefCd(JSPUtil.getParameter(request, "da_bse_port_def_cd", ""));
		setDaRacFrtRtAmt(JSPUtil.getParameter(request, "da_rac_frt_rt_amt", ""));
		setPrcRoutSeq(JSPUtil.getParameter(request, "prc_rout_seq", ""));
		setCtrtCntrTpszCd(JSPUtil.getParameter(request, "ctrt_cntr_tpsz_cd", ""));
		setOiPrcTrspModCd(JSPUtil.getParameter(request, "oi_prc_trsp_mod_cd", ""));
		setRtRarNoteConvMapgId(JSPUtil.getParameter(request, "rt_rar_note_conv_mapg_id", ""));
		setOpRoutPntLocDefCd(JSPUtil.getParameter(request, "op_rout_pnt_loc_def_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setDaTypCurrCd(JSPUtil.getParameter(request, "da_typ_curr_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setDaPrcCmdtDefCd(JSPUtil.getParameter(request, "da_prc_cmdt_def_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgBqSeq(JSPUtil.getParameter(request, "bkg_bq_seq", ""));
		setTrnsModCd(JSPUtil.getParameter(request, "trns_mod_cd", ""));
		setOaTypCurrCd(JSPUtil.getParameter(request, "oa_typ_curr_cd", ""));
		setRtRatUtCd(JSPUtil.getParameter(request, "rt_rat_ut_cd", ""));
		setDaTypNoteConvTpCd(JSPUtil.getParameter(request, "da_typ_note_conv_tp_cd", ""));
		setRtAddBkgConvTpCd(JSPUtil.getParameter(request, "rt_add_bkg_conv_tp_cd", ""));
		setRtAppFrtRtAmt(JSPUtil.getParameter(request, "rt_app_frt_rt_amt", ""));
		setOaRacNoteConvSeq(JSPUtil.getParameter(request, "oa_rac_note_conv_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRtDorFrtRtAmt(JSPUtil.getParameter(request, "rt_dor_frt_rt_amt", ""));
		setOaPrcCgoTpCd(JSPUtil.getParameter(request, "oa_prc_cgo_tp_cd", ""));
		setOaPrcCmdtDefCd(JSPUtil.getParameter(request, "oa_prc_cmdt_def_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setOiRoutPntLocDefCd(JSPUtil.getParameter(request, "oi_rout_pnt_loc_def_cd", ""));
		setOiDirCallFlg(JSPUtil.getParameter(request, "oi_dir_call_flg", ""));
		setDirCallFlg(JSPUtil.getParameter(request, "dir_call_flg", ""));
		setBqPodApplFlg(JSPUtil.getParameter(request, "bq_pod_appl_flg", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setDaViaPortDefCd(JSPUtil.getParameter(request, "da_via_port_def_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDaRatUtCd(JSPUtil.getParameter(request, "da_rat_ut_cd", ""));
		setOaFnlFrtRtAmt(JSPUtil.getParameter(request, "oa_fnl_frt_rt_amt", ""));
		setDiRatUtCd(JSPUtil.getParameter(request, "di_rat_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPrcRtSeq(JSPUtil.getParameter(request, "prc_rt_seq", ""));
		setRtRarFrtRtAmt(JSPUtil.getParameter(request, "rt_rar_frt_rt_amt", ""));
		setOaDirCallFlg(JSPUtil.getParameter(request, "oa_dir_call_flg", ""));
		setRtAppNoteConvMapgId(JSPUtil.getParameter(request, "rt_app_note_conv_mapg_id", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setRtArbFrtRtAmt(JSPUtil.getParameter(request, "rt_arb_frt_rt_amt", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setRtDorCurrCd(JSPUtil.getParameter(request, "rt_dor_curr_cd", ""));
		setRtRacNoteConvTpCd(JSPUtil.getParameter(request, "rt_rac_note_conv_tp_cd", ""));
		setDaPrcCgoTpCd(JSPUtil.getParameter(request, "da_prc_cgo_tp_cd", ""));
		setPrcCmdtHdrSeq(JSPUtil.getParameter(request, "prc_cmdt_hdr_seq", ""));
		setRtRarNoteConvRuleCd(JSPUtil.getParameter(request, "rt_rar_note_conv_rule_cd", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, "fnl_frt_rt_amt", ""));
		setRtRasNoteConvRuleCd(JSPUtil.getParameter(request, "rt_ras_note_conv_rule_cd", ""));
		setRtRasCurrCd(JSPUtil.getParameter(request, "rt_ras_curr_cd", ""));
		setRtArbNoteConvSeq(JSPUtil.getParameter(request, "rt_arb_note_conv_seq", ""));
		setDaRacNoteConvSeq(JSPUtil.getParameter(request, "da_rac_note_conv_seq", ""));
		setRtTypNoteConvSeq(JSPUtil.getParameter(request, "rt_typ_note_conv_seq", ""));
		setOaAddChgSeq(JSPUtil.getParameter(request, "oa_add_chg_seq", ""));
		setNote(JSPUtil.getParameter(request, "note", ""));
		setRtAddNoteConvTpCd(JSPUtil.getParameter(request, "rt_add_note_conv_tp_cd", ""));
		setRtTypCurrCd(JSPUtil.getParameter(request, "rt_typ_curr_cd", ""));
		setRtAddNoteConvSeq(JSPUtil.getParameter(request, "rt_add_note_conv_seq", ""));
		setRtDorRtOpCd(JSPUtil.getParameter(request, "rt_dor_rt_op_cd", ""));
		setRtRarNoteConvSeq(JSPUtil.getParameter(request, "rt_rar_note_conv_seq", ""));
		setRtDorNoteConvMapgId(JSPUtil.getParameter(request, "rt_dor_note_conv_mapg_id", ""));
		setRtArbCurrCd(JSPUtil.getParameter(request, "rt_arb_curr_cd", ""));
		setDiAddChgSeq(JSPUtil.getParameter(request, "di_add_chg_seq", ""));
		setDaRoutPntLocDefCd(JSPUtil.getParameter(request, "da_rout_pnt_loc_def_cd", ""));
		setOaBsePortDefCd(JSPUtil.getParameter(request, "oa_bse_port_def_cd", ""));
		setRtCurrCd(JSPUtil.getParameter(request, "rt_curr_cd", ""));
		setRtAddNoteConvRuleCd(JSPUtil.getParameter(request, "rt_add_note_conv_rule_cd", ""));
		setOiCurrCd(JSPUtil.getParameter(request, "oi_curr_cd", ""));
		setRtRacBkgConvTpCd(JSPUtil.getParameter(request, "rt_rac_bkg_conv_tp_cd", ""));
		setOiFnlFrtRtAmt(JSPUtil.getParameter(request, "oi_fnl_frt_rt_amt", ""));
		setRtTypNoteConvTpCd(JSPUtil.getParameter(request, "rt_typ_note_conv_tp_cd", ""));
		setRtRacNoteConvMapgId(JSPUtil.getParameter(request, "rt_rac_note_conv_mapg_id", ""));
		setDryCgoFlg(JSPUtil.getParameter(request, "dry_cgo_flg", ""));
		setRtAddFrtRtAmt(JSPUtil.getParameter(request, "rt_add_frt_rt_amt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setRtRapNoteConvSeq(JSPUtil.getParameter(request, "rt_rap_note_conv_seq", ""));
		setOrgTrspModCd(JSPUtil.getParameter(request, "org_trsp_mod_cd", ""));
		setCtrtNo(JSPUtil.getParameter(request, "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setRtAddCurrCd(JSPUtil.getParameter(request, "rt_add_curr_cd", ""));
		setOaRacNoteConvTpCd(JSPUtil.getParameter(request, "oa_rac_note_conv_tp_cd", ""));
		setRtMtchPattCd(JSPUtil.getParameter(request, "rt_mtch_patt_cd", ""));
		setDaCurrCd(JSPUtil.getParameter(request, "da_curr_cd", ""));
		setRtArbNoteConvRuleCd(JSPUtil.getParameter(request, "rt_arb_note_conv_rule_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setRtRacRtOpCd(JSPUtil.getParameter(request, "rt_rac_rt_op_cd", ""));
		setOaRacRtOpCd(JSPUtil.getParameter(request, "oa_rac_rt_op_cd", ""));
		setRtRapNoteConvTpCd(JSPUtil.getParameter(request, "rt_rap_note_conv_tp_cd", ""));
		setDiRoutPntLocDefCd(JSPUtil.getParameter(request, "di_rout_pnt_loc_def_cd", ""));
		setOaTypFrtRtAmt(JSPUtil.getParameter(request, "oa_typ_frt_rt_amt", ""));
		setPrcRtMtchPattCd(JSPUtil.getParameter(request, "prc_rt_mtch_patt_cd", ""));
		setBqPstRlyPortApplFlg(JSPUtil.getParameter(request, "bq_pst_rly_port_appl_flg", ""));
		setDpRoutPntLocDefCd(JSPUtil.getParameter(request, "dp_rout_pnt_loc_def_cd", ""));
		setDaRacNoteConvMapgId(JSPUtil.getParameter(request, "da_rac_note_conv_mapg_id", ""));
		setRtTypRtOpCd(JSPUtil.getParameter(request, "rt_typ_rt_op_cd", ""));
		setRdDirCallFlg(JSPUtil.getParameter(request, "rd_dir_call_flg", ""));
		setOiRcvDeTermCd(JSPUtil.getParameter(request, "oi_rcv_de_term_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setOaTypNoteConvSeq(JSPUtil.getParameter(request, "oa_typ_note_conv_seq", ""));
		setRtRapRtOpCd(JSPUtil.getParameter(request, "rt_rap_rt_op_cd", ""));
		setDaRacCurrCd(JSPUtil.getParameter(request, "da_rac_curr_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setRtDorBkgConvTpCd(JSPUtil.getParameter(request, "rt_dor_bkg_conv_tp_cd", ""));
		setRtRacNoteConvRuleCd(JSPUtil.getParameter(request, "rt_rac_note_conv_rule_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setRtRasFrtRtAmt(JSPUtil.getParameter(request, "rt_ras_frt_rt_amt", ""));
		setDiBsePortDefCd(JSPUtil.getParameter(request, "di_bse_port_def_cd", ""));
		setDiPrcCmdtDefCd(JSPUtil.getParameter(request, "di_prc_cmdt_def_cd", ""));
		setRtRapNoteConvMapgId(JSPUtil.getParameter(request, "rt_rap_note_conv_mapg_id", ""));
		setDaTypNoteConvRuleCd(JSPUtil.getParameter(request, "da_typ_note_conv_rule_cd", ""));
		setRtAddNoteConvMapgId(JSPUtil.getParameter(request, "rt_add_note_conv_mapg_id", ""));
		setRtAppNoteConvTpCd(JSPUtil.getParameter(request, "rt_app_note_conv_tp_cd", ""));
		setRtArbBkgConvTpCd(JSPUtil.getParameter(request, "rt_arb_bkg_conv_tp_cd", ""));
		setOiBsePortDefCd(JSPUtil.getParameter(request, "oi_bse_port_def_cd", ""));
		setDaRacNoteConvTpCd(JSPUtil.getParameter(request, "da_rac_note_conv_tp_cd", ""));
		setOiViaPortDefCd(JSPUtil.getParameter(request, "oi_via_port_def_cd", ""));
		setOaViaPortDefCd(JSPUtil.getParameter(request, "oa_via_port_def_cd", ""));
		setRtTypBkgConvTpCd(JSPUtil.getParameter(request, "rt_typ_bkg_conv_tp_cd", ""));
		setBqPrcCgoTpCd(JSPUtil.getParameter(request, "bq_prc_cgo_tp_cd", ""));
		setDiViaPortDefCd(JSPUtil.getParameter(request, "di_via_port_def_cd", ""));
		setRtAppRtOpCd(JSPUtil.getParameter(request, "rt_app_rt_op_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScTAWOftAutoratingListVO[]
	 */
	public SearchScTAWOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScTAWOftAutoratingListVO[]
	 */
	public SearchScTAWOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScTAWOftAutoratingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oaTypBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_typ_bkg_conv_tp_cd", length));
			String[] daTypNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "da_typ_note_conv_mapg_id", length));
			String[] oaPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_trsp_mod_cd", length));
			String[] daAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "da_add_chg_seq", length));
			String[] diPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] daTypBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "da_typ_bkg_conv_tp_cd", length));
			String[] oaRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oa_rcv_de_term_cd", length));
			String[] rtTypNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_typ_note_conv_rule_cd", length));
			String[] daTypNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "da_typ_note_conv_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ovRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "ov_rout_via_port_def_cd", length));
			String[] oaCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_curr_cd", length));
			String[] daFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_fnl_frt_rt_amt", length));
			String[] rtRarBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rar_bkg_conv_tp_cd", length));
			String[] daRacDaOpCd = (JSPUtil.getParameter(request, prefix	+ "da_rac_da_op_cd", length));
			String[] bqSeq = (JSPUtil.getParameter(request, prefix	+ "bq_seq", length));
			String[] dpPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dp_prc_trsp_mod_cd", length));
			String[] rtAppBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_bkg_conv_tp_cd", length));
			String[] opPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "op_prc_trsp_mod_cd", length));
			String[] oaRacFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_rac_frt_rt_amt", length));
			String[] diRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "di_rcv_de_term_cd", length));
			String[] cmPrcCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_tp_cd", length));
			String[] oaTypRtOpCd = (JSPUtil.getParameter(request, prefix	+ "oa_typ_rt_op_cd", length));
			String[] oaRacBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_rac_bkg_conv_tp_cd", length));
			String[] rtRarCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_rar_curr_cd", length));
			String[] diCurrCd = (JSPUtil.getParameter(request, prefix	+ "di_curr_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] oaTypNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "oa_typ_note_conv_rule_cd", length));
			String[] rtRasBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_bkg_conv_tp_cd", length));
			String[] rtRapCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_rap_curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] oiRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oi_rat_ut_cd", length));
			String[] rtRacCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_rac_curr_cd", length));
			String[] oaRacCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_rac_curr_cd", length));
			String[] daTypDaOpCd = (JSPUtil.getParameter(request, prefix	+ "da_typ_da_op_cd", length));
			String[] rtDorNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_dor_note_conv_tp_cd", length));
			String[] daRacBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "da_rac_bkg_conv_tp_cd", length));
			String[] oaRacNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "oa_rac_note_conv_mapg_id", length));
			String[] daRacNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "da_rac_note_conv_rule_cd", length));
			String[] rtAppNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_seq", length));
			String[] rtRasNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_tp_cd", length));
			String[] rtPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_prc_cgo_tp_cd", length));
			String[] rtRacFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_rac_frt_rt_amt", length));
			String[] rtAddRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_add_rt_op_cd", length));
			String[] diDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "di_dir_call_flg", length));
			String[] rtRapFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_rap_frt_rt_amt", length));
			String[] rtRacNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_rac_note_conv_seq", length));
			String[] bqDelApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_del_appl_flg", length));
			String[] daRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "da_rcv_de_term_cd", length));
			String[] daTypFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_typ_frt_rt_amt", length));
			String[] rtDorNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_dor_note_conv_rule_cd", length));
			String[] oaTypNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "oa_typ_note_conv_mapg_id", length));
			String[] rtArbRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_arb_rt_op_cd", length));
			String[] bqPorRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_rly_port_appl_flg", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] cmPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "cm_prc_cmdt_def_cd", length));
			String[] rtRapBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rap_bkg_conv_tp_cd", length));
			String[] bqPorApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_por_appl_flg", length));
			String[] diPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_cgo_tp_cd", length));
			String[] rtArbNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_arb_note_conv_mapg_id", length));
			String[] dtl = (JSPUtil.getParameter(request, prefix	+ "dtl", length));
			String[] bqPolApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pol_appl_flg", length));
			String[] destTrspModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trsp_mod_cd", length));
			String[] rtRasRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_rt_op_cd", length));
			String[] prcGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_gen_spcl_rt_tp_cd", length));
			String[] rtRarNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rar_note_conv_tp_cd", length));
			String[] oiPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_cmdt_def_cd", length));
			String[] diFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "di_fnl_frt_rt_amt", length));
			String[] rtAppNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_rule_cd", length));
			String[] oaRacNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "oa_rac_note_conv_rule_cd", length));
			String[] oiPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_cgo_tp_cd", length));
			String[] oiAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "oi_add_chg_seq", length));
			String[] daPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_trsp_mod_cd", length));
			String[] rtRarRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rar_rt_op_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rtRapNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_rap_note_conv_rule_cd", length));
			String[] rtAppCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_curr_cd", length));
			String[] rtRasNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_seq", length));
			String[] daDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "da_dir_call_flg", length));
			String[] oaRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_rout_pnt_loc_def_cd", length));
			String[] rtTypFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_typ_frt_rt_amt", length));
			String[] rtTypNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_typ_note_conv_mapg_id", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] oaRatUtCd = (JSPUtil.getParameter(request, prefix	+ "oa_rat_ut_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_fnl_frt_rt_amt", length));
			String[] oaTypNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_typ_note_conv_tp_cd", length));
			String[] dvRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dv_rout_via_port_def_cd", length));
			String[] rtDorNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_dor_note_conv_seq", length));
			String[] rtArbNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_arb_note_conv_tp_cd", length));
			String[] rtRasNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_mapg_id", length));
			String[] daBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "da_bse_port_def_cd", length));
			String[] daRacFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "da_rac_frt_rt_amt", length));
			String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rout_seq", length));
			String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd", length));
			String[] oiPrcTrspModCd = (JSPUtil.getParameter(request, prefix	+ "oi_prc_trsp_mod_cd", length));
			String[] rtRarNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_rar_note_conv_mapg_id", length));
			String[] opRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "op_rout_pnt_loc_def_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] daTypCurrCd = (JSPUtil.getParameter(request, prefix	+ "da_typ_curr_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] daPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_cmdt_def_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgBqSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_seq", length));
			String[] trnsModCd = (JSPUtil.getParameter(request, prefix	+ "trns_mod_cd", length));
			String[] oaTypCurrCd = (JSPUtil.getParameter(request, prefix	+ "oa_typ_curr_cd", length));
			String[] rtRatUtCd = (JSPUtil.getParameter(request, prefix	+ "rt_rat_ut_cd", length));
			String[] daTypNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "da_typ_note_conv_tp_cd", length));
			String[] rtAddBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_add_bkg_conv_tp_cd", length));
			String[] rtAppFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_app_frt_rt_amt", length));
			String[] oaRacNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "oa_rac_note_conv_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtDorFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_dor_frt_rt_amt", length));
			String[] oaPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_cgo_tp_cd", length));
			String[] oaPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_prc_cmdt_def_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] oiRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_rout_pnt_loc_def_cd", length));
			String[] oiDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "oi_dir_call_flg", length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix	+ "dir_call_flg", length));
			String[] bqPodApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pod_appl_flg", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] daViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "da_via_port_def_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] daRatUtCd = (JSPUtil.getParameter(request, prefix	+ "da_rat_ut_cd", length));
			String[] oaFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_fnl_frt_rt_amt", length));
			String[] diRatUtCd = (JSPUtil.getParameter(request, prefix	+ "di_rat_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] prcRtSeq = (JSPUtil.getParameter(request, prefix	+ "prc_rt_seq", length));
			String[] rtRarFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_rar_frt_rt_amt", length));
			String[] oaDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "oa_dir_call_flg", length));
			String[] rtAppNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_mapg_id", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] rtArbFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_arb_frt_rt_amt", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rtDorCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_dor_curr_cd", length));
			String[] rtRacNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rac_note_conv_tp_cd", length));
			String[] daPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "da_prc_cgo_tp_cd", length));
			String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_hdr_seq", length));
			String[] rtRarNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_rar_note_conv_rule_cd", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] rtRasNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_note_conv_rule_cd", length));
			String[] rtRasCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_ras_curr_cd", length));
			String[] rtArbNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_arb_note_conv_seq", length));
			String[] daRacNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "da_rac_note_conv_seq", length));
			String[] rtTypNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_typ_note_conv_seq", length));
			String[] oaAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "oa_add_chg_seq", length));
			String[] note = (JSPUtil.getParameter(request, prefix	+ "note", length));
			String[] rtAddNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_add_note_conv_tp_cd", length));
			String[] rtTypCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_typ_curr_cd", length));
			String[] rtAddNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_add_note_conv_seq", length));
			String[] rtDorRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_dor_rt_op_cd", length));
			String[] rtRarNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_rar_note_conv_seq", length));
			String[] rtDorNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_dor_note_conv_mapg_id", length));
			String[] rtArbCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_arb_curr_cd", length));
			String[] diAddChgSeq = (JSPUtil.getParameter(request, prefix	+ "di_add_chg_seq", length));
			String[] daRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "da_rout_pnt_loc_def_cd", length));
			String[] oaBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_bse_port_def_cd", length));
			String[] rtCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_curr_cd", length));
			String[] rtAddNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_add_note_conv_rule_cd", length));
			String[] oiCurrCd = (JSPUtil.getParameter(request, prefix	+ "oi_curr_cd", length));
			String[] rtRacBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rac_bkg_conv_tp_cd", length));
			String[] oiFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oi_fnl_frt_rt_amt", length));
			String[] rtTypNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_typ_note_conv_tp_cd", length));
			String[] rtRacNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_rac_note_conv_mapg_id", length));
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] rtAddFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_add_frt_rt_amt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] rtRapNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "rt_rap_note_conv_seq", length));
			String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix	+ "org_trsp_mod_cd", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rtAddCurrCd = (JSPUtil.getParameter(request, prefix	+ "rt_add_curr_cd", length));
			String[] oaRacNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "oa_rac_note_conv_tp_cd", length));
			String[] rtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "rt_mtch_patt_cd", length));
			String[] daCurrCd = (JSPUtil.getParameter(request, prefix	+ "da_curr_cd", length));
			String[] rtArbNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_arb_note_conv_rule_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rtRacRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rac_rt_op_cd", length));
			String[] oaRacRtOpCd = (JSPUtil.getParameter(request, prefix	+ "oa_rac_rt_op_cd", length));
			String[] rtRapNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rap_note_conv_tp_cd", length));
			String[] diRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "di_rout_pnt_loc_def_cd", length));
			String[] oaTypFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "oa_typ_frt_rt_amt", length));
			String[] prcRtMtchPattCd = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd", length));
			String[] bqPstRlyPortApplFlg = (JSPUtil.getParameter(request, prefix	+ "bq_pst_rly_port_appl_flg", length));
			String[] dpRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dp_rout_pnt_loc_def_cd", length));
			String[] daRacNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "da_rac_note_conv_mapg_id", length));
			String[] rtTypRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_typ_rt_op_cd", length));
			String[] rdDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "rd_dir_call_flg", length));
			String[] oiRcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "oi_rcv_de_term_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] oaTypNoteConvSeq = (JSPUtil.getParameter(request, prefix	+ "oa_typ_note_conv_seq", length));
			String[] rtRapRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_rap_rt_op_cd", length));
			String[] daRacCurrCd = (JSPUtil.getParameter(request, prefix	+ "da_rac_curr_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] rtDorBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_dor_bkg_conv_tp_cd", length));
			String[] rtRacNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "rt_rac_note_conv_rule_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rtRasFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "rt_ras_frt_rt_amt", length));
			String[] diBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "di_bse_port_def_cd", length));
			String[] diPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "di_prc_cmdt_def_cd", length));
			String[] rtRapNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_rap_note_conv_mapg_id", length));
			String[] daTypNoteConvRuleCd = (JSPUtil.getParameter(request, prefix	+ "da_typ_note_conv_rule_cd", length));
			String[] rtAddNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "rt_add_note_conv_mapg_id", length));
			String[] rtAppNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_note_conv_tp_cd", length));
			String[] rtArbBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_arb_bkg_conv_tp_cd", length));
			String[] oiBsePortDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_bse_port_def_cd", length));
			String[] daRacNoteConvTpCd = (JSPUtil.getParameter(request, prefix	+ "da_rac_note_conv_tp_cd", length));
			String[] oiViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "oi_via_port_def_cd", length));
			String[] oaViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "oa_via_port_def_cd", length));
			String[] rtTypBkgConvTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_typ_bkg_conv_tp_cd", length));
			String[] bqPrcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bq_prc_cgo_tp_cd", length));
			String[] diViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "di_via_port_def_cd", length));
			String[] rtAppRtOpCd = (JSPUtil.getParameter(request, prefix	+ "rt_app_rt_op_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScTAWOftAutoratingListVO();
				if (oaTypBkgConvTpCd[i] != null)
					model.setOaTypBkgConvTpCd(oaTypBkgConvTpCd[i]);
				if (daTypNoteConvMapgId[i] != null)
					model.setDaTypNoteConvMapgId(daTypNoteConvMapgId[i]);
				if (oaPrcTrspModCd[i] != null)
					model.setOaPrcTrspModCd(oaPrcTrspModCd[i]);
				if (daAddChgSeq[i] != null)
					model.setDaAddChgSeq(daAddChgSeq[i]);
				if (diPrcTrspModCd[i] != null)
					model.setDiPrcTrspModCd(diPrcTrspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (daTypBkgConvTpCd[i] != null)
					model.setDaTypBkgConvTpCd(daTypBkgConvTpCd[i]);
				if (oaRcvDeTermCd[i] != null)
					model.setOaRcvDeTermCd(oaRcvDeTermCd[i]);
				if (rtTypNoteConvRuleCd[i] != null)
					model.setRtTypNoteConvRuleCd(rtTypNoteConvRuleCd[i]);
				if (daTypNoteConvSeq[i] != null)
					model.setDaTypNoteConvSeq(daTypNoteConvSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ovRoutViaPortDefCd[i] != null)
					model.setOvRoutViaPortDefCd(ovRoutViaPortDefCd[i]);
				if (oaCurrCd[i] != null)
					model.setOaCurrCd(oaCurrCd[i]);
				if (daFnlFrtRtAmt[i] != null)
					model.setDaFnlFrtRtAmt(daFnlFrtRtAmt[i]);
				if (rtRarBkgConvTpCd[i] != null)
					model.setRtRarBkgConvTpCd(rtRarBkgConvTpCd[i]);
				if (daRacDaOpCd[i] != null)
					model.setDaRacDaOpCd(daRacDaOpCd[i]);
				if (bqSeq[i] != null)
					model.setBqSeq(bqSeq[i]);
				if (dpPrcTrspModCd[i] != null)
					model.setDpPrcTrspModCd(dpPrcTrspModCd[i]);
				if (rtAppBkgConvTpCd[i] != null)
					model.setRtAppBkgConvTpCd(rtAppBkgConvTpCd[i]);
				if (opPrcTrspModCd[i] != null)
					model.setOpPrcTrspModCd(opPrcTrspModCd[i]);
				if (oaRacFrtRtAmt[i] != null)
					model.setOaRacFrtRtAmt(oaRacFrtRtAmt[i]);
				if (diRcvDeTermCd[i] != null)
					model.setDiRcvDeTermCd(diRcvDeTermCd[i]);
				if (cmPrcCmdtTpCd[i] != null)
					model.setCmPrcCmdtTpCd(cmPrcCmdtTpCd[i]);
				if (oaTypRtOpCd[i] != null)
					model.setOaTypRtOpCd(oaTypRtOpCd[i]);
				if (oaRacBkgConvTpCd[i] != null)
					model.setOaRacBkgConvTpCd(oaRacBkgConvTpCd[i]);
				if (rtRarCurrCd[i] != null)
					model.setRtRarCurrCd(rtRarCurrCd[i]);
				if (diCurrCd[i] != null)
					model.setDiCurrCd(diCurrCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (oaTypNoteConvRuleCd[i] != null)
					model.setOaTypNoteConvRuleCd(oaTypNoteConvRuleCd[i]);
				if (rtRasBkgConvTpCd[i] != null)
					model.setRtRasBkgConvTpCd(rtRasBkgConvTpCd[i]);
				if (rtRapCurrCd[i] != null)
					model.setRtRapCurrCd(rtRapCurrCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (oiRatUtCd[i] != null)
					model.setOiRatUtCd(oiRatUtCd[i]);
				if (rtRacCurrCd[i] != null)
					model.setRtRacCurrCd(rtRacCurrCd[i]);
				if (oaRacCurrCd[i] != null)
					model.setOaRacCurrCd(oaRacCurrCd[i]);
				if (daTypDaOpCd[i] != null)
					model.setDaTypDaOpCd(daTypDaOpCd[i]);
				if (rtDorNoteConvTpCd[i] != null)
					model.setRtDorNoteConvTpCd(rtDorNoteConvTpCd[i]);
				if (daRacBkgConvTpCd[i] != null)
					model.setDaRacBkgConvTpCd(daRacBkgConvTpCd[i]);
				if (oaRacNoteConvMapgId[i] != null)
					model.setOaRacNoteConvMapgId(oaRacNoteConvMapgId[i]);
				if (daRacNoteConvRuleCd[i] != null)
					model.setDaRacNoteConvRuleCd(daRacNoteConvRuleCd[i]);
				if (rtAppNoteConvSeq[i] != null)
					model.setRtAppNoteConvSeq(rtAppNoteConvSeq[i]);
				if (rtRasNoteConvTpCd[i] != null)
					model.setRtRasNoteConvTpCd(rtRasNoteConvTpCd[i]);
				if (rtPrcCgoTpCd[i] != null)
					model.setRtPrcCgoTpCd(rtPrcCgoTpCd[i]);
				if (rtRacFrtRtAmt[i] != null)
					model.setRtRacFrtRtAmt(rtRacFrtRtAmt[i]);
				if (rtAddRtOpCd[i] != null)
					model.setRtAddRtOpCd(rtAddRtOpCd[i]);
				if (diDirCallFlg[i] != null)
					model.setDiDirCallFlg(diDirCallFlg[i]);
				if (rtRapFrtRtAmt[i] != null)
					model.setRtRapFrtRtAmt(rtRapFrtRtAmt[i]);
				if (rtRacNoteConvSeq[i] != null)
					model.setRtRacNoteConvSeq(rtRacNoteConvSeq[i]);
				if (bqDelApplFlg[i] != null)
					model.setBqDelApplFlg(bqDelApplFlg[i]);
				if (daRcvDeTermCd[i] != null)
					model.setDaRcvDeTermCd(daRcvDeTermCd[i]);
				if (daTypFrtRtAmt[i] != null)
					model.setDaTypFrtRtAmt(daTypFrtRtAmt[i]);
				if (rtDorNoteConvRuleCd[i] != null)
					model.setRtDorNoteConvRuleCd(rtDorNoteConvRuleCd[i]);
				if (oaTypNoteConvMapgId[i] != null)
					model.setOaTypNoteConvMapgId(oaTypNoteConvMapgId[i]);
				if (rtArbRtOpCd[i] != null)
					model.setRtArbRtOpCd(rtArbRtOpCd[i]);
				if (bqPorRlyPortApplFlg[i] != null)
					model.setBqPorRlyPortApplFlg(bqPorRlyPortApplFlg[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (cmPrcCmdtDefCd[i] != null)
					model.setCmPrcCmdtDefCd(cmPrcCmdtDefCd[i]);
				if (rtRapBkgConvTpCd[i] != null)
					model.setRtRapBkgConvTpCd(rtRapBkgConvTpCd[i]);
				if (bqPorApplFlg[i] != null)
					model.setBqPorApplFlg(bqPorApplFlg[i]);
				if (diPrcCgoTpCd[i] != null)
					model.setDiPrcCgoTpCd(diPrcCgoTpCd[i]);
				if (rtArbNoteConvMapgId[i] != null)
					model.setRtArbNoteConvMapgId(rtArbNoteConvMapgId[i]);
				if (dtl[i] != null)
					model.setDtl(dtl[i]);
				if (bqPolApplFlg[i] != null)
					model.setBqPolApplFlg(bqPolApplFlg[i]);
				if (destTrspModCd[i] != null)
					model.setDestTrspModCd(destTrspModCd[i]);
				if (rtRasRtOpCd[i] != null)
					model.setRtRasRtOpCd(rtRasRtOpCd[i]);
				if (prcGenSpclRtTpCd[i] != null)
					model.setPrcGenSpclRtTpCd(prcGenSpclRtTpCd[i]);
				if (rtRarNoteConvTpCd[i] != null)
					model.setRtRarNoteConvTpCd(rtRarNoteConvTpCd[i]);
				if (oiPrcCmdtDefCd[i] != null)
					model.setOiPrcCmdtDefCd(oiPrcCmdtDefCd[i]);
				if (diFnlFrtRtAmt[i] != null)
					model.setDiFnlFrtRtAmt(diFnlFrtRtAmt[i]);
				if (rtAppNoteConvRuleCd[i] != null)
					model.setRtAppNoteConvRuleCd(rtAppNoteConvRuleCd[i]);
				if (oaRacNoteConvRuleCd[i] != null)
					model.setOaRacNoteConvRuleCd(oaRacNoteConvRuleCd[i]);
				if (oiPrcCgoTpCd[i] != null)
					model.setOiPrcCgoTpCd(oiPrcCgoTpCd[i]);
				if (oiAddChgSeq[i] != null)
					model.setOiAddChgSeq(oiAddChgSeq[i]);
				if (daPrcTrspModCd[i] != null)
					model.setDaPrcTrspModCd(daPrcTrspModCd[i]);
				if (rtRarRtOpCd[i] != null)
					model.setRtRarRtOpCd(rtRarRtOpCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rtRapNoteConvRuleCd[i] != null)
					model.setRtRapNoteConvRuleCd(rtRapNoteConvRuleCd[i]);
				if (rtAppCurrCd[i] != null)
					model.setRtAppCurrCd(rtAppCurrCd[i]);
				if (rtRasNoteConvSeq[i] != null)
					model.setRtRasNoteConvSeq(rtRasNoteConvSeq[i]);
				if (daDirCallFlg[i] != null)
					model.setDaDirCallFlg(daDirCallFlg[i]);
				if (oaRoutPntLocDefCd[i] != null)
					model.setOaRoutPntLocDefCd(oaRoutPntLocDefCd[i]);
				if (rtTypFrtRtAmt[i] != null)
					model.setRtTypFrtRtAmt(rtTypFrtRtAmt[i]);
				if (rtTypNoteConvMapgId[i] != null)
					model.setRtTypNoteConvMapgId(rtTypNoteConvMapgId[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (oaRatUtCd[i] != null)
					model.setOaRatUtCd(oaRatUtCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtFnlFrtRtAmt[i] != null)
					model.setRtFnlFrtRtAmt(rtFnlFrtRtAmt[i]);
				if (oaTypNoteConvTpCd[i] != null)
					model.setOaTypNoteConvTpCd(oaTypNoteConvTpCd[i]);
				if (dvRoutViaPortDefCd[i] != null)
					model.setDvRoutViaPortDefCd(dvRoutViaPortDefCd[i]);
				if (rtDorNoteConvSeq[i] != null)
					model.setRtDorNoteConvSeq(rtDorNoteConvSeq[i]);
				if (rtArbNoteConvTpCd[i] != null)
					model.setRtArbNoteConvTpCd(rtArbNoteConvTpCd[i]);
				if (rtRasNoteConvMapgId[i] != null)
					model.setRtRasNoteConvMapgId(rtRasNoteConvMapgId[i]);
				if (daBsePortDefCd[i] != null)
					model.setDaBsePortDefCd(daBsePortDefCd[i]);
				if (daRacFrtRtAmt[i] != null)
					model.setDaRacFrtRtAmt(daRacFrtRtAmt[i]);
				if (prcRoutSeq[i] != null)
					model.setPrcRoutSeq(prcRoutSeq[i]);
				if (ctrtCntrTpszCd[i] != null)
					model.setCtrtCntrTpszCd(ctrtCntrTpszCd[i]);
				if (oiPrcTrspModCd[i] != null)
					model.setOiPrcTrspModCd(oiPrcTrspModCd[i]);
				if (rtRarNoteConvMapgId[i] != null)
					model.setRtRarNoteConvMapgId(rtRarNoteConvMapgId[i]);
				if (opRoutPntLocDefCd[i] != null)
					model.setOpRoutPntLocDefCd(opRoutPntLocDefCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (daTypCurrCd[i] != null)
					model.setDaTypCurrCd(daTypCurrCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (daPrcCmdtDefCd[i] != null)
					model.setDaPrcCmdtDefCd(daPrcCmdtDefCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgBqSeq[i] != null)
					model.setBkgBqSeq(bkgBqSeq[i]);
				if (trnsModCd[i] != null)
					model.setTrnsModCd(trnsModCd[i]);
				if (oaTypCurrCd[i] != null)
					model.setOaTypCurrCd(oaTypCurrCd[i]);
				if (rtRatUtCd[i] != null)
					model.setRtRatUtCd(rtRatUtCd[i]);
				if (daTypNoteConvTpCd[i] != null)
					model.setDaTypNoteConvTpCd(daTypNoteConvTpCd[i]);
				if (rtAddBkgConvTpCd[i] != null)
					model.setRtAddBkgConvTpCd(rtAddBkgConvTpCd[i]);
				if (rtAppFrtRtAmt[i] != null)
					model.setRtAppFrtRtAmt(rtAppFrtRtAmt[i]);
				if (oaRacNoteConvSeq[i] != null)
					model.setOaRacNoteConvSeq(oaRacNoteConvSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtDorFrtRtAmt[i] != null)
					model.setRtDorFrtRtAmt(rtDorFrtRtAmt[i]);
				if (oaPrcCgoTpCd[i] != null)
					model.setOaPrcCgoTpCd(oaPrcCgoTpCd[i]);
				if (oaPrcCmdtDefCd[i] != null)
					model.setOaPrcCmdtDefCd(oaPrcCmdtDefCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (oiRoutPntLocDefCd[i] != null)
					model.setOiRoutPntLocDefCd(oiRoutPntLocDefCd[i]);
				if (oiDirCallFlg[i] != null)
					model.setOiDirCallFlg(oiDirCallFlg[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (bqPodApplFlg[i] != null)
					model.setBqPodApplFlg(bqPodApplFlg[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (daViaPortDefCd[i] != null)
					model.setDaViaPortDefCd(daViaPortDefCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (daRatUtCd[i] != null)
					model.setDaRatUtCd(daRatUtCd[i]);
				if (oaFnlFrtRtAmt[i] != null)
					model.setOaFnlFrtRtAmt(oaFnlFrtRtAmt[i]);
				if (diRatUtCd[i] != null)
					model.setDiRatUtCd(diRatUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (prcRtSeq[i] != null)
					model.setPrcRtSeq(prcRtSeq[i]);
				if (rtRarFrtRtAmt[i] != null)
					model.setRtRarFrtRtAmt(rtRarFrtRtAmt[i]);
				if (oaDirCallFlg[i] != null)
					model.setOaDirCallFlg(oaDirCallFlg[i]);
				if (rtAppNoteConvMapgId[i] != null)
					model.setRtAppNoteConvMapgId(rtAppNoteConvMapgId[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (rtArbFrtRtAmt[i] != null)
					model.setRtArbFrtRtAmt(rtArbFrtRtAmt[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtDorCurrCd[i] != null)
					model.setRtDorCurrCd(rtDorCurrCd[i]);
				if (rtRacNoteConvTpCd[i] != null)
					model.setRtRacNoteConvTpCd(rtRacNoteConvTpCd[i]);
				if (daPrcCgoTpCd[i] != null)
					model.setDaPrcCgoTpCd(daPrcCgoTpCd[i]);
				if (prcCmdtHdrSeq[i] != null)
					model.setPrcCmdtHdrSeq(prcCmdtHdrSeq[i]);
				if (rtRarNoteConvRuleCd[i] != null)
					model.setRtRarNoteConvRuleCd(rtRarNoteConvRuleCd[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (rtRasNoteConvRuleCd[i] != null)
					model.setRtRasNoteConvRuleCd(rtRasNoteConvRuleCd[i]);
				if (rtRasCurrCd[i] != null)
					model.setRtRasCurrCd(rtRasCurrCd[i]);
				if (rtArbNoteConvSeq[i] != null)
					model.setRtArbNoteConvSeq(rtArbNoteConvSeq[i]);
				if (daRacNoteConvSeq[i] != null)
					model.setDaRacNoteConvSeq(daRacNoteConvSeq[i]);
				if (rtTypNoteConvSeq[i] != null)
					model.setRtTypNoteConvSeq(rtTypNoteConvSeq[i]);
				if (oaAddChgSeq[i] != null)
					model.setOaAddChgSeq(oaAddChgSeq[i]);
				if (note[i] != null)
					model.setNote(note[i]);
				if (rtAddNoteConvTpCd[i] != null)
					model.setRtAddNoteConvTpCd(rtAddNoteConvTpCd[i]);
				if (rtTypCurrCd[i] != null)
					model.setRtTypCurrCd(rtTypCurrCd[i]);
				if (rtAddNoteConvSeq[i] != null)
					model.setRtAddNoteConvSeq(rtAddNoteConvSeq[i]);
				if (rtDorRtOpCd[i] != null)
					model.setRtDorRtOpCd(rtDorRtOpCd[i]);
				if (rtRarNoteConvSeq[i] != null)
					model.setRtRarNoteConvSeq(rtRarNoteConvSeq[i]);
				if (rtDorNoteConvMapgId[i] != null)
					model.setRtDorNoteConvMapgId(rtDorNoteConvMapgId[i]);
				if (rtArbCurrCd[i] != null)
					model.setRtArbCurrCd(rtArbCurrCd[i]);
				if (diAddChgSeq[i] != null)
					model.setDiAddChgSeq(diAddChgSeq[i]);
				if (daRoutPntLocDefCd[i] != null)
					model.setDaRoutPntLocDefCd(daRoutPntLocDefCd[i]);
				if (oaBsePortDefCd[i] != null)
					model.setOaBsePortDefCd(oaBsePortDefCd[i]);
				if (rtCurrCd[i] != null)
					model.setRtCurrCd(rtCurrCd[i]);
				if (rtAddNoteConvRuleCd[i] != null)
					model.setRtAddNoteConvRuleCd(rtAddNoteConvRuleCd[i]);
				if (oiCurrCd[i] != null)
					model.setOiCurrCd(oiCurrCd[i]);
				if (rtRacBkgConvTpCd[i] != null)
					model.setRtRacBkgConvTpCd(rtRacBkgConvTpCd[i]);
				if (oiFnlFrtRtAmt[i] != null)
					model.setOiFnlFrtRtAmt(oiFnlFrtRtAmt[i]);
				if (rtTypNoteConvTpCd[i] != null)
					model.setRtTypNoteConvTpCd(rtTypNoteConvTpCd[i]);
				if (rtRacNoteConvMapgId[i] != null)
					model.setRtRacNoteConvMapgId(rtRacNoteConvMapgId[i]);
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (rtAddFrtRtAmt[i] != null)
					model.setRtAddFrtRtAmt(rtAddFrtRtAmt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (rtRapNoteConvSeq[i] != null)
					model.setRtRapNoteConvSeq(rtRapNoteConvSeq[i]);
				if (orgTrspModCd[i] != null)
					model.setOrgTrspModCd(orgTrspModCd[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rtAddCurrCd[i] != null)
					model.setRtAddCurrCd(rtAddCurrCd[i]);
				if (oaRacNoteConvTpCd[i] != null)
					model.setOaRacNoteConvTpCd(oaRacNoteConvTpCd[i]);
				if (rtMtchPattCd[i] != null)
					model.setRtMtchPattCd(rtMtchPattCd[i]);
				if (daCurrCd[i] != null)
					model.setDaCurrCd(daCurrCd[i]);
				if (rtArbNoteConvRuleCd[i] != null)
					model.setRtArbNoteConvRuleCd(rtArbNoteConvRuleCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rtRacRtOpCd[i] != null)
					model.setRtRacRtOpCd(rtRacRtOpCd[i]);
				if (oaRacRtOpCd[i] != null)
					model.setOaRacRtOpCd(oaRacRtOpCd[i]);
				if (rtRapNoteConvTpCd[i] != null)
					model.setRtRapNoteConvTpCd(rtRapNoteConvTpCd[i]);
				if (diRoutPntLocDefCd[i] != null)
					model.setDiRoutPntLocDefCd(diRoutPntLocDefCd[i]);
				if (oaTypFrtRtAmt[i] != null)
					model.setOaTypFrtRtAmt(oaTypFrtRtAmt[i]);
				if (prcRtMtchPattCd[i] != null)
					model.setPrcRtMtchPattCd(prcRtMtchPattCd[i]);
				if (bqPstRlyPortApplFlg[i] != null)
					model.setBqPstRlyPortApplFlg(bqPstRlyPortApplFlg[i]);
				if (dpRoutPntLocDefCd[i] != null)
					model.setDpRoutPntLocDefCd(dpRoutPntLocDefCd[i]);
				if (daRacNoteConvMapgId[i] != null)
					model.setDaRacNoteConvMapgId(daRacNoteConvMapgId[i]);
				if (rtTypRtOpCd[i] != null)
					model.setRtTypRtOpCd(rtTypRtOpCd[i]);
				if (rdDirCallFlg[i] != null)
					model.setRdDirCallFlg(rdDirCallFlg[i]);
				if (oiRcvDeTermCd[i] != null)
					model.setOiRcvDeTermCd(oiRcvDeTermCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (oaTypNoteConvSeq[i] != null)
					model.setOaTypNoteConvSeq(oaTypNoteConvSeq[i]);
				if (rtRapRtOpCd[i] != null)
					model.setRtRapRtOpCd(rtRapRtOpCd[i]);
				if (daRacCurrCd[i] != null)
					model.setDaRacCurrCd(daRacCurrCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (rtDorBkgConvTpCd[i] != null)
					model.setRtDorBkgConvTpCd(rtDorBkgConvTpCd[i]);
				if (rtRacNoteConvRuleCd[i] != null)
					model.setRtRacNoteConvRuleCd(rtRacNoteConvRuleCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rtRasFrtRtAmt[i] != null)
					model.setRtRasFrtRtAmt(rtRasFrtRtAmt[i]);
				if (diBsePortDefCd[i] != null)
					model.setDiBsePortDefCd(diBsePortDefCd[i]);
				if (diPrcCmdtDefCd[i] != null)
					model.setDiPrcCmdtDefCd(diPrcCmdtDefCd[i]);
				if (rtRapNoteConvMapgId[i] != null)
					model.setRtRapNoteConvMapgId(rtRapNoteConvMapgId[i]);
				if (daTypNoteConvRuleCd[i] != null)
					model.setDaTypNoteConvRuleCd(daTypNoteConvRuleCd[i]);
				if (rtAddNoteConvMapgId[i] != null)
					model.setRtAddNoteConvMapgId(rtAddNoteConvMapgId[i]);
				if (rtAppNoteConvTpCd[i] != null)
					model.setRtAppNoteConvTpCd(rtAppNoteConvTpCd[i]);
				if (rtArbBkgConvTpCd[i] != null)
					model.setRtArbBkgConvTpCd(rtArbBkgConvTpCd[i]);
				if (oiBsePortDefCd[i] != null)
					model.setOiBsePortDefCd(oiBsePortDefCd[i]);
				if (daRacNoteConvTpCd[i] != null)
					model.setDaRacNoteConvTpCd(daRacNoteConvTpCd[i]);
				if (oiViaPortDefCd[i] != null)
					model.setOiViaPortDefCd(oiViaPortDefCd[i]);
				if (oaViaPortDefCd[i] != null)
					model.setOaViaPortDefCd(oaViaPortDefCd[i]);
				if (rtTypBkgConvTpCd[i] != null)
					model.setRtTypBkgConvTpCd(rtTypBkgConvTpCd[i]);
				if (bqPrcCgoTpCd[i] != null)
					model.setBqPrcCgoTpCd(bqPrcCgoTpCd[i]);
				if (diViaPortDefCd[i] != null)
					model.setDiViaPortDefCd(diViaPortDefCd[i]);
				if (rtAppRtOpCd[i] != null)
					model.setRtAppRtOpCd(rtAppRtOpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScTAWOftAutoratingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScTAWOftAutoratingListVO[]
	 */
	public SearchScTAWOftAutoratingListVO[] getSearchScTAWOftAutoratingListVOs(){
		SearchScTAWOftAutoratingListVO[] vos = (SearchScTAWOftAutoratingListVO[])models.toArray(new SearchScTAWOftAutoratingListVO[models.size()]);
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
		this.oaTypBkgConvTpCd = this.oaTypBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypNoteConvMapgId = this.daTypNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcTrspModCd = this.oaPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daAddChgSeq = this.daAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcTrspModCd = this.diPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypBkgConvTpCd = this.daTypBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRcvDeTermCd = this.oaRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypNoteConvRuleCd = this.rtTypNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypNoteConvSeq = this.daTypNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRoutViaPortDefCd = this.ovRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaCurrCd = this.oaCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daFnlFrtRtAmt = this.daFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarBkgConvTpCd = this.rtRarBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacDaOpCd = this.daRacDaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqSeq = this.bqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcTrspModCd = this.dpPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppBkgConvTpCd = this.rtAppBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opPrcTrspModCd = this.opPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacFrtRtAmt = this.oaRacFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRcvDeTermCd = this.diRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtTpCd = this.cmPrcCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypRtOpCd = this.oaTypRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacBkgConvTpCd = this.oaRacBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarCurrCd = this.rtRarCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diCurrCd = this.diCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypNoteConvRuleCd = this.oaTypNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasBkgConvTpCd = this.rtRasBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapCurrCd = this.rtRapCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRatUtCd = this.oiRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacCurrCd = this.rtRacCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacCurrCd = this.oaRacCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypDaOpCd = this.daTypDaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorNoteConvTpCd = this.rtDorNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacBkgConvTpCd = this.daRacBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacNoteConvMapgId = this.oaRacNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacNoteConvRuleCd = this.daRacNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvSeq = this.rtAppNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvTpCd = this.rtRasNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtPrcCgoTpCd = this.rtPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacFrtRtAmt = this.rtRacFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddRtOpCd = this.rtAddRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diDirCallFlg = this.diDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapFrtRtAmt = this.rtRapFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacNoteConvSeq = this.rtRacNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqDelApplFlg = this.bqDelApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRcvDeTermCd = this.daRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypFrtRtAmt = this.daTypFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorNoteConvRuleCd = this.rtDorNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypNoteConvMapgId = this.oaTypNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbRtOpCd = this.rtArbRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorRlyPortApplFlg = this.bqPorRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPrcCmdtDefCd = this.cmPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapBkgConvTpCd = this.rtRapBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPorApplFlg = this.bqPorApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcCgoTpCd = this.diPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbNoteConvMapgId = this.rtArbNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtl = this.dtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPolApplFlg = this.bqPolApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrspModCd = this.destTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasRtOpCd = this.rtRasRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGenSpclRtTpCd = this.prcGenSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarNoteConvTpCd = this.rtRarNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcCmdtDefCd = this.oiPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFnlFrtRtAmt = this.diFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvRuleCd = this.rtAppNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacNoteConvRuleCd = this.oaRacNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcCgoTpCd = this.oiPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiAddChgSeq = this.oiAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcTrspModCd = this.daPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarRtOpCd = this.rtRarRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapNoteConvRuleCd = this.rtRapNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppCurrCd = this.rtAppCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvSeq = this.rtRasNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daDirCallFlg = this.daDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRoutPntLocDefCd = this.oaRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypFrtRtAmt = this.rtTypFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypNoteConvMapgId = this.rtTypNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRatUtCd = this.oaRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFnlFrtRtAmt = this.rtFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypNoteConvTpCd = this.oaTypNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvRoutViaPortDefCd = this.dvRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorNoteConvSeq = this.rtDorNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbNoteConvTpCd = this.rtArbNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvMapgId = this.rtRasNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daBsePortDefCd = this.daBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacFrtRtAmt = this.daRacFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRoutSeq = this.prcRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd = this.ctrtCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiPrcTrspModCd = this.oiPrcTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarNoteConvMapgId = this.rtRarNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opRoutPntLocDefCd = this.opRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypCurrCd = this.daTypCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcCmdtDefCd = this.daPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBqSeq = this.bkgBqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsModCd = this.trnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypCurrCd = this.oaTypCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRatUtCd = this.rtRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypNoteConvTpCd = this.daTypNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddBkgConvTpCd = this.rtAddBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppFrtRtAmt = this.rtAppFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacNoteConvSeq = this.oaRacNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorFrtRtAmt = this.rtDorFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcCgoTpCd = this.oaPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaPrcCmdtDefCd = this.oaPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRoutPntLocDefCd = this.oiRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiDirCallFlg = this.oiDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCallFlg = this.dirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPodApplFlg = this.bqPodApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daViaPortDefCd = this.daViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRatUtCd = this.daRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaFnlFrtRtAmt = this.oaFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRatUtCd = this.diRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtSeq = this.prcRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarFrtRtAmt = this.rtRarFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaDirCallFlg = this.oaDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvMapgId = this.rtAppNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbFrtRtAmt = this.rtArbFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorCurrCd = this.rtDorCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacNoteConvTpCd = this.rtRacNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daPrcCgoTpCd = this.daPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtHdrSeq = this.prcCmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarNoteConvRuleCd = this.rtRarNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasNoteConvRuleCd = this.rtRasNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasCurrCd = this.rtRasCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbNoteConvSeq = this.rtArbNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacNoteConvSeq = this.daRacNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypNoteConvSeq = this.rtTypNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaAddChgSeq = this.oaAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.note = this.note .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddNoteConvTpCd = this.rtAddNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypCurrCd = this.rtTypCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddNoteConvSeq = this.rtAddNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorRtOpCd = this.rtDorRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRarNoteConvSeq = this.rtRarNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorNoteConvMapgId = this.rtDorNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbCurrCd = this.rtArbCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diAddChgSeq = this.diAddChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRoutPntLocDefCd = this.daRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaBsePortDefCd = this.oaBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCurrCd = this.rtCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddNoteConvRuleCd = this.rtAddNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiCurrCd = this.oiCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacBkgConvTpCd = this.rtRacBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiFnlFrtRtAmt = this.oiFnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypNoteConvTpCd = this.rtTypNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacNoteConvMapgId = this.rtRacNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddFrtRtAmt = this.rtAddFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapNoteConvSeq = this.rtRapNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrspModCd = this.orgTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddCurrCd = this.rtAddCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacNoteConvTpCd = this.oaRacNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtMtchPattCd = this.rtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daCurrCd = this.daCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbNoteConvRuleCd = this.rtArbNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacRtOpCd = this.rtRacRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRacRtOpCd = this.oaRacRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapNoteConvTpCd = this.rtRapNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diRoutPntLocDefCd = this.diRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypFrtRtAmt = this.oaTypFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd = this.prcRtMtchPattCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPstRlyPortApplFlg = this.bqPstRlyPortApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpRoutPntLocDefCd = this.dpRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacNoteConvMapgId = this.daRacNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypRtOpCd = this.rtTypRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdDirCallFlg = this.rdDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiRcvDeTermCd = this.oiRcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaTypNoteConvSeq = this.oaTypNoteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapRtOpCd = this.rtRapRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacCurrCd = this.daRacCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtDorBkgConvTpCd = this.rtDorBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRacNoteConvRuleCd = this.rtRacNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRasFrtRtAmt = this.rtRasFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diBsePortDefCd = this.diBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diPrcCmdtDefCd = this.diPrcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtRapNoteConvMapgId = this.rtRapNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daTypNoteConvRuleCd = this.daTypNoteConvRuleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAddNoteConvMapgId = this.rtAddNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppNoteConvTpCd = this.rtAppNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtArbBkgConvTpCd = this.rtArbBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiBsePortDefCd = this.oiBsePortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.daRacNoteConvTpCd = this.daRacNoteConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oiViaPortDefCd = this.oiViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaViaPortDefCd = this.oaViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtTypBkgConvTpCd = this.rtTypBkgConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bqPrcCgoTpCd = this.bqPrcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diViaPortDefCd = this.diViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAppRtOpCd = this.rtAppRtOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
