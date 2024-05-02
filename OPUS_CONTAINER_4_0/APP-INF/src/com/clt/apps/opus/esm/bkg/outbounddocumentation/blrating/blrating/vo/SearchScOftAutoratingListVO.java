/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchScOftAutoratingListVO.java
*@FileTitle : SearchScOftAutoratingListVO
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
public class SearchScOftAutoratingListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchScOftAutoratingListVO> models = new ArrayList<SearchScOftAutoratingListVO>();

    /* Column Info */
    private String oaTypBkgConvTpCd = null;

    /* Column Info */
    private String oaRacConvCtnt = null;

    /* Column Info */
    private String oaPrcTrspModCd = null;

    /* Column Info */
    private String diPrcTrspModCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String oaRcvDeTermCd = null;

    /* Column Info */
    private String daTypBkgConvTpCd = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
//    private String daTypNoteConvSeq = null;

    /* Column Info */
    private String ovRoutViaPortDefCd = null;

    /* Column Info */
//    private String oaRarFrtRtAmt = null;//need to check

    /* Column Info */
//    private String oaDorNoteConvTpCd = null;//need to check

    /* Column Info */
    private String oaCurrCd = null;

    /* Column Info */
//    private String oaRarBkgConvTpCd = null;//need to check

    /* Column Info */
    private String cntrWgt = null;//need to check

    /* Column Info */
    private String daFnlFrtRtAmt = null;

    /* Column Info */
    private String rtRarBkgConvTpCd = null;

    /* Column Info */
    private String daRacDaOpCd = null;

    /* Column Info */
    private String rtAppBkgConvTpCd = null;

    /* Column Info */
    private String oaRapBkgConvTpCd = null;//need to check

    /* Column Info */
//    private String oaRapNoteConvSeq = null;//need to check

    /* Column Info */
    private String oaRacFrtRtAmt = null;

    /* Column Info */
//    private String daRarFrtRtAmt = null;//need to check

    /* Column Info */
    private String diRcvDeTermCd = null;

    /* Column Info */
    private String rtCalcFrtRtAmt = null;

    /* Column Info */
    private String oaTypRtOpCd = null;

    /* Column Info */
    private String daRapCurrCd = null;//need to check

    /* Column Info */
    private String oaRacBkgConvTpCd = null;

    /* Column Info */
    private String rtRarCurrCd = null;

    /* Column Info */
//    private String daRarBkgConvTpCd = null;//need to check

    /* Column Info */
    private String diCurrCd = null;

    /* Column Info */
//    private String daRapNoteConvSeq = null;//need to check

    /* Column Info */
    private String rcFlg = null;

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
    private String oaCalcFrtRtAmt = null;

    /* Column Info */
//    private String daRarNoteConvTpCd = null;//need to check

    /* Column Info */
    private String daRapDaOpCd = null;//need to check

    /* Column Info */
//    private String rtAppNoteConvSeq = null;

    /* Column Info */
    private String rtRasNoteConvTpCd = null;

    /* Column Info */
    private String rtRacFrtRtAmt = null;

    /* Column Info */
    private String rtPrcCgoTpCd = null;

    /* Column Info */
    private String rtAddRtOpCd = null;

    /* Column Info */
    private String diDirCallFlg = null;

    /* Column Info */
    private String rtDorConvCtnt = null;

    /* Column Info */
    private String daTypConvCtnt = null;

    /* Column Info */
    private String rtRapFrtRtAmt = null;

    /* Column Info */
//    private String rtRacNoteConvSeq = null;

    /* Column Info */
//    private String oaRarNoteConvTpCd = null;//need to check

    /* Column Info */
    private String cnt = null;//need to check

    /* Column Info */
    private String daRcvDeTermCd = null;

    /* Column Info */
    private String daTypFrtRtAmt = null;

    /* Column Info */
    private String oiCalcFrtRtAmt = null;

    /* Column Info */
    private String rtArbRtOpCd = null;

    /* Column Info */
    private String propNo = null;

    /* Column Info */
    private String daRapNoteConvTpCd = null;//need to check

    /* Column Info */
    private String rtRapBkgConvTpCd = null;

    /* Column Info */
    private String rtAplyDt = null;//need to check

    /* Column Info */
    private String diPrcCgoTpCd = null;

    /* Column Info */
    private String porMtchFlg = null;

    /* Column Info */
    private String chgCd = null;

    /* Column Info */
//    private String daRarCurrCd = null;//need to check

    /* Column Info */
    private String dtl = null;

    /* Column Info */
//    private String daDorNoteConvSeq = null;//need to check

    /* Column Info */
    private String destTrspModCd = null;

    /* Column Info */
    private String rtRasRtOpCd = null;

    /* Column Info */
    private String prcGenSpclRtTpCd = null;

    /* Column Info */
    private String rtRarNoteConvTpCd = null;

    /* Column Info */
    private String diFnlFrtRtAmt = null;

    /* Column Info */
    private String oiPrcCmdtDefCd = null;

    /* Column Info */
    private String oaDorFrtRtAmt = null;//need to check

    /* Column Info */
    private String inGaFlg = null;//need to check

    /* Column Info */
    private String delCntCd = null;//need to check

    /* Column Info */
    private String frtTermCd = null;

    /* Column Info */
    private String oiPrcCgoTpCd = null;

    /* Column Info */
    private String rtRapConvCtnt = null;

    /* Column Info */
    private String daPrcTrspModCd = null;

    /* Column Info */
    private String rtRarRtOpCd = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String rtAppCurrCd = null;

    /* Column Info */
//    private String rtRasNoteConvSeq = null;

    /* Column Info */
    private String daDirCallFlg = null;

    /* Column Info */
    private String daRapFrtRtAmt = null;//need to check

    /* Column Info */
    private String oaRoutPntLocDefCd = null;

    /* Column Info */
    private String rtTypFrtRtAmt = null;

    /* Column Info */
    private String noteCtnt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String oaRatUtCd = null;

    /* Column Info */
    private String rtFnlFrtRtAmt = null;

    /* Column Info */
    private String oaTypNoteConvTpCd = null;

    /* Column Info */
    private String dvRoutViaPortDefCd = null;

    /* Column Info */
//    private String rtDorNoteConvSeq = null;

    /* Column Info */
    private String rtArbNoteConvTpCd = null;

    /* Column Info */
    private String chgUtAmt = null;

    /* Column Info */
    private String rtTypConvCtnt = null;

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
    private String delMtchFlg = null;

    /* Column Info */
    private String opRoutPntLocDefCd = null;

    /* Column Info */
    private String daDorNoteConvTpCd = null;//need to check

    /* Column Info */
    private String cmdtNm = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String daPrcCmdtDefCd = null;

    /* Column Info */
    private String daTypCurrCd = null;

    /* Column Info */
    private String frtInclXcldDivCd = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String trnsModCd = null;

    /* Column Info */
    private String oaTypCurrCd = null;

    /* Column Info */
    private String frtRtAmt = null;//need to check

    /* Column Info */
    private String rtRatUtCd = null;

    /* Column Info */
    private String rtAddBkgConvTpCd = null;

    /* Column Info */
    private String daTypNoteConvTpCd = null;

    /* Column Info */
    private String rtAppFrtRtAmt = null;

    /* Column Info */
    private String daCalcFrtRtAmt = null;

    /* Column Info */
//    private String oaRacNoteConvSeq = null;

    /* Column Info */
//    private String oaRarCurrCd = null;//need to check

    /* Column Info */
    private String svcScpCd = null;

    /* Column Info */
    private String rtDorFrtRtAmt = null;

    /* Column Info */
    private String cgoTpCd = null;

    /* Column Info */
    private String oaDorCurrCd = null;//need to check

    /* Column Info */
    private String rtRasConvCtnt = null;

    /* Column Info */
    private String oaPrcCgoTpCd = null;

    /* Column Info */
    private String daRacConvCtnt = null;

    /* Column Info */
    private String chgAmt = null;

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
    private String ratUtCd = null;

    /* Column Info */
    private String diCalcFrtRtAmt = null;

    /* Column Info */
//    private String daRarNoteConvSeq = null;//need to check

    /* Column Info */
    private String oftCmbSeq = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String daViaPortDefCd = null;

    /* Column Info */
    private String diRatUtCd = null;

    /* Column Info */
    private String oaFnlFrtRtAmt = null;

    /* Column Info */
    private String daRatUtCd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String prcRtSeq = null;

    /* Column Info */
    private String rtRarFrtRtAmt = null;

    /* Column Info */
    private String oaDirCallFlg = null;

    /* Column Info */
    private String opCntrQty = null;

    /* Column Info */
    private String daRapBkgConvTpCd = null;//need to check

    /* Column Info */
    private String rtArbFrtRtAmt = null;

    /* Column Info */
    private String pctBseCd = null;

    /* Column Info */
    private String imdgClssCd = null;

    /* Column Info */
    private String rtRarConvCtnt = null;

    /* Column Info */
    private String dpSeq = null;

    /* Column Info */
    private String rtRacNoteConvTpCd = null;

    /* Column Info */
    private String rtDorCurrCd = null;

    /* Column Info */
    private String rtRacConvCtnt = null;

    /* Column Info */
    private String daPrcCgoTpCd = null;

    /* Column Info */
    private String prcCmdtHdrSeq = null;

    /* Column Info */
    private String fnlFrtRtAmt = null;

    /* Column Info */
    private String rtRasCurrCd = null;

    /* Column Info */
//    private String oaRarRtOpCd = null;//need to check

    /* Column Info */
    private String oaRapRtOpCd = null;//need to check

    /* Column Info */
    private String usrId = null;

    /* Column Info */
//    private String rtArbNoteConvSeq = null;

    /* Column Info */
//    private String daRacNoteConvSeq = null;

    /* Column Info */
//    private String rtTypNoteConvSeq = null;

    /* Column Info */
    private String note = null;

    /* Column Info */
    private String rtAddNoteConvTpCd = null;

    /* Column Info */
    private String rtTypCurrCd = null;

    /* Column Info */
//    private String rtAddNoteConvSeq = null;

    /* Column Info */
    private String rtDorRtOpCd = null;

    /* Column Info */
//    private String rtRarNoteConvSeq = null;

    /* Column Info */
    private String inclOftFlg = null;//need to check

    /* Column Info */
    private String oaTypConvCtnt = null;

    /* Column Info */
    private String rtArbCurrCd = null;

    /* Column Info */
    private String daRoutPntLocDefCd = null;

    /* Column Info */
    private String oaBsePortDefCd = null;

    /* Column Info */
    private String prcHngrBarTpCd = null;//need to check

    /* Column Info */
    private String rtRacBkgConvTpCd = null;

    /* Column Info */
    private String oiCurrCd = null;

    /* Column Info */
    private String oiFnlFrtRtAmt = null;

    /* Column Info */
    private String rtTypNoteConvTpCd = null;

    /* Column Info */
    private String dryCgoFlg = null;

    /* Column Info */
    private String rtAddFrtRtAmt = null;

    /* Column Info */
    private String amdtSeq = null;

    /* Column Info */
//    private String rtRapNoteConvSeq = null;

    /* Column Info */
    private String orgTrspModCd = null;

    /* Column Info */
    private String oaRapCurrCd = null;//need to check

    /* Column Info */
    private String daDorCurrCd = null;//need to check

    /* Column Info */
    private String daDorBkgConvTpCd = null;//need to check

    /* Column Info */
//    private String oaRarNoteConvSeq = null;//need to check

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String cgoCateCd = null;

    /* Column Info */
    private String rtAddCurrCd = null;

    /* Column Info */
    private String oaRacNoteConvTpCd = null;

    /* Column Info */
    private String rtMtchPattCd = null;

    /* Column Info */
    private String oaDorBkgConvTpCd = null;//need to check

    /* Column Info */
    private String daCurrCd = null;

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
//    private String daRarDaOpCd = null;//need to check

    /* Column Info */
    private String oaTypFrtRtAmt = null;

    /* Column Info */
    private String ratAsQty = null;

    /* Column Info */
    private String dpRoutPntLocDefCd = null;

    /* Column Info */
    private String rtTypRtOpCd = null;

    /* Column Info */
    private String oiRcvDeTermCd = null;

    /* Column Info */
    private String currCd = null;

    /* Column Info */
    private String triPropNo = null;

    /* Column Info */
//    private String oaTypNoteConvSeq = null;

    /* Column Info */
    private String rtRapRtOpCd = null;

    /* Column Info */
    private String daRacCurrCd = null;

    /* Column Info */
    private String oaRapFrtRtAmt = null;//need to check

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String rtDorBkgConvTpCd = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
//    private String oaDorNoteConvSeq = null;//need to check

    /* Column Info */
    private String daDorDaOpCd = null;//need to check

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String porCntCd = null;

    /* Column Info */
    private String rtRasFrtRtAmt = null;

    /* Column Info */
    private String diBsePortDefCd = null;

    /* Column Info */
    private String diPrcCmdtDefCd = null;

    /* Column Info */
    private String rtAppNoteConvTpCd = null;

    /* Column Info */
    private String rtArbBkgConvTpCd = null;

    /* Column Info */
    private String daDorFrtRtAmt = null;//need to check

    /* Column Info */
    private String oiBsePortDefCd = null;

    /* Column Info */
    private String daRacNoteConvTpCd = null;

    /* Column Info */
    private String oaRapNoteConvTpCd = null;//need to check

    /* Column Info */
    private String eqSubstCntrTpszCd = null;

    /* Column Info */
    private String oiViaPortDefCd = null;

    /* Column Info */
    private String oaDorRtOpCd = null;//need to check

    /* Column Info */
    private String oaViaPortDefCd = null;

    /* Column Info */
    private String rtTypBkgConvTpCd = null;

    /* Column Info */
    private String diViaPortDefCd = null;

    /* Column Info */
    private String rtAppRtOpCd = null;

    /* Column Info */
    private String cmPrcCmdtDefCd = null;

    /* Column Info */
    private String cmdtSeq = null;//need to check

    /* Column Info */
    private String autoRatFlg = null;
    /* Column Info */
    private String pctlNo = null;
    /* Column Info */
	private String bqSeq = null;
	/* Column Info */
	private String bkgBqSeq = null;
	/* Column Info */
	private String bkgBqOccrSeq = null;
	/* Column Info */
	private String calcCtrtTpCd = null;//need to check
	/* Column Info */
	private String prnHdnFlg = null;//need to check
	/* Column Info */
	private String fxRtFlg = null;//need to check
	private String cnoteCtnt = null; 
	private String snoteCtnt = null; 
	private String arbNoteCtnt = null;
	private String cnote = null; //need to check
	private String snote = null; //need to check
	private String arbNote = null;//need to check
	private String oiFm = null; 
	private String oaFm = null; 
	private String daFm = null; 
	private String diFm = null;
	private String oiMinCgoWgt = null;
	private String oiMaxCgoWgt = null;
	private String oaMinCgoWgt = null;
	private String oaMaxCgoWgt = null;
	private String daMinCgoWgt = null;
	private String daMaxCgoWgt = null;
	private String diMinCgoWgt = null;
	private String diMaxCgoWgt = null;
	private String taxFlg = null;
	private String taxCntCd = null;
	private String inclTaxFlg = null;
	private String oiFrtTermCd = null; 
	private String oaFrtTermCd = null; 
	private String daFrtTermCd = null; 
	private String diFrtTermCd = null;
	private String n3ptyRcvOfcCd = null;
	
	
    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchScOftAutoratingListVO() {
    }

    public SearchScOftAutoratingListVO(String ibflag, String pagerows, String rtMtchPattCd, String cmdtNm, String porCd, String polCd, String podCd, String delCd, String dirCallFlg, String rcvDeTermCd, String deTermCd, String ratUtCd, String prcCgoTpCd, String currCd, String orgTrspModCd, String destTrspModCd, String fnlFrtRtAmt, String trnsModCd, String opCntrQty, String noteCtnt, String dtl, String note, String oiRoutPntLocDefCd, String oiBsePortDefCd, String oiViaPortDefCd, String oiDirCallFlg, String oiRatUtCd, String oiPrcCgoTpCd, String oiPrcTrspModCd, String oiRcvDeTermCd, String oiPrcCmdtDefCd, String oiCurrCd, String oiFnlFrtRtAmt, String oaRoutPntLocDefCd, String oaBsePortDefCd, String oaViaPortDefCd, String oaDirCallFlg, String oaRatUtCd, String oaPrcCgoTpCd, String oaPrcTrspModCd, String oaRcvDeTermCd, String oaPrcCmdtDefCd, String oaCurrCd, String oaFnlFrtRtAmt, String daRoutPntLocDefCd, String daBsePortDefCd, String daViaPortDefCd, String daDirCallFlg, String daRatUtCd, String daPrcCgoTpCd, String daPrcTrspModCd, String daRcvDeTermCd, String daPrcCmdtDefCd, String daCurrCd, String daFnlFrtRtAmt, String diRoutPntLocDefCd, String diBsePortDefCd, String diViaPortDefCd, String diDirCallFlg, String diRatUtCd, String diPrcCgoTpCd, String diPrcTrspModCd, String diRcvDeTermCd, String diPrcCmdtDefCd, String diCurrCd, String diFnlFrtRtAmt, String chgCd, String chgUtAmt, String frtRtAmt, String ratAsQty, String chgAmt, String inclOftFlg, String frtTermCd, String cgoTpCd, String prcHngrBarTpCd, String inGaFlg, String cntrWgt, String bkgNo, String usrId, String cntrTpszCd, String ctrtCntrTpszCd, String rcvTermCd, String dryCgoFlg, String awkCgoFlg, String dcgoFlg, String rcFlg, String bbCgoFlg, String socFlg, String imdgClssCd, String propNo, String amdtSeq, String svcScpCd, String prcGenSpclRtTpCd, String prcCmdtHdrSeq, String prcRoutSeq, String prcRtSeq, String rtPrcCgoTpCd, String rtFnlFrtRtAmt, String rtRapBkgConvTpCd, 
//    		String rtRapNoteConvSeq, 
    		String rtRapNoteConvTpCd, String rtRapRtOpCd, String rtRapCurrCd, String rtRapFrtRtAmt, String rtRarBkgConvTpCd, 
//    		String rtRarNoteConvSeq, 
    		String rtRarNoteConvTpCd, String rtRarRtOpCd, String rtRarCurrCd, String rtRarFrtRtAmt, String rtDorBkgConvTpCd, 
//    		String rtDorNoteConvSeq, 
    		String rtDorNoteConvTpCd, String rtDorRtOpCd, String rtDorCurrCd, String rtDorFrtRtAmt, String rtTypBkgConvTpCd, 
//    		String rtTypNoteConvSeq, 
    		String rtTypNoteConvTpCd, String rtTypRtOpCd, String rtTypCurrCd, String rtTypFrtRtAmt, String rtAppBkgConvTpCd, 
//    		String rtAppNoteConvSeq, 
    		String rtAppNoteConvTpCd, String rtAppRtOpCd, String rtAppCurrCd, String rtAppFrtRtAmt, String rtRasBkgConvTpCd, 
//    		String rtRasNoteConvSeq, 
    		String rtRasNoteConvTpCd, String rtRasRtOpCd, String rtRasCurrCd, String rtRasFrtRtAmt, String rtArbBkgConvTpCd, 
//    		String rtArbNoteConvSeq, 
    		String rtArbNoteConvTpCd, String rtArbRtOpCd, String rtArbCurrCd, String rtArbFrtRtAmt, String rtAddBkgConvTpCd, 
//    		String rtAddNoteConvSeq, 
    		String rtAddNoteConvTpCd, String rtAddRtOpCd, String rtAddCurrCd, String rtAddFrtRtAmt, String oaRapBkgConvTpCd, 
//    		String oaRapNoteConvSeq, 
    		String oaRapNoteConvTpCd, String oaRapRtOpCd, String oaRapCurrCd, String oaRapFrtRtAmt, 
//    		String oaRarBkgConvTpCd, 
//    		String oaRarNoteConvSeq, 
//    		String oaRarNoteConvTpCd, String oaRarRtOpCd, String oaRarCurrCd, String oaRarFrtRtAmt, 
    		String oaDorBkgConvTpCd, 
//    		String oaDorNoteConvSeq,
//    		String oaDorNoteConvTpCd,
    		String oaDorRtOpCd, String oaDorCurrCd, String oaDorFrtRtAmt, String oaTypBkgConvTpCd, 
//    		String oaTypNoteConvSeq, 
    		String oaTypNoteConvTpCd, String oaTypRtOpCd, String oaTypCurrCd, String oaTypFrtRtAmt, String daRapBkgConvTpCd, 
//    		String daRapNoteConvSeq, 
    		String daRapNoteConvTpCd, String daRapDaOpCd, String daRapCurrCd, String daRapFrtRtAmt, 
//    		String daRarBkgConvTpCd, 
//    		String daRarNoteConvSeq, 
//    		String daRarNoteConvTpCd, String daRarDaOpCd, String daRarCurrCd, String daRarFrtRtAmt, 
    		String daDorBkgConvTpCd, 
//    		String daDorNoteConvSeq, 
    		String daDorNoteConvTpCd, String daDorDaOpCd, String daDorCurrCd, String daDorFrtRtAmt, String daTypBkgConvTpCd, 
//    		String daTypNoteConvSeq, 
    		String daTypNoteConvTpCd, String daTypDaOpCd, String daTypCurrCd, String daTypFrtRtAmt, String oaRacBkgConvTpCd, 
//    		String oaRacNoteConvSeq, 
    		String oaRacNoteConvTpCd, String oaRacRtOpCd, String oaRacCurrCd, String oaRacFrtRtAmt, String rtRacBkgConvTpCd, 
//    		String rtRacNoteConvSeq, 
    		String rtRacNoteConvTpCd, String rtRacRtOpCd, String rtRacCurrCd, String rtRacFrtRtAmt, String daRacBkgConvTpCd, 
//    		String daRacNoteConvSeq, 
    		String daRacNoteConvTpCd, String daRacDaOpCd, String daRacCurrCd, String daRacFrtRtAmt, String rtRatUtCd, String opRoutPntLocDefCd, String ovRoutViaPortDefCd, String dvRoutViaPortDefCd, String dpRoutPntLocDefCd, String rtAplyDt, String pctBseCd, String cnt, String porMtchFlg, String delMtchFlg, String rtCalcFrtRtAmt, String oiCalcFrtRtAmt, String oaCalcFrtRtAmt, String daCalcFrtRtAmt, String diCalcFrtRtAmt, String oftCmbSeq, String rtRapConvCtnt, String rtRarConvCtnt, String rtDorConvCtnt, String rtTypConvCtnt, String rtRacConvCtnt, String rtRasConvCtnt, String oaTypConvCtnt, String oaRacConvCtnt, String daTypConvCtnt, String daRacConvCtnt, String frtInclXcldDivCd, String dpSeq, String porCntCd, String delCntCd, String cgoCateCd, String triPropNo, String eqSubstCntrTpszCd, String cmPrcCmdtDefCd, String cmdtSeq, String autoRatFlg, String pctlNo, String bqSeq, String bkgBqSeq, String bkgBqOccrSeq, String calcCtrtTpCd, String prnHdnFlg, String fxRtFlg,
    		String cnoteCtnt, String snoteCtnt, String arbNoteCtnt, String cnote, String snote, String arbNote, String oiFm, String oaFm, String daFm, String diFm,
    		String oiMinCgoWgt, String oiMaxCgoWgt, String oaMinCgoWgt, String oaMaxCgoWgt, String daMinCgoWgt, String daMaxCgoWgt, String diMinCgoWgt, String diMaxCgoWgt, String taxFlg, String taxCntCd, String inclTaxFlg, String oiFrtTermCd, String oaFrtTermCd, String daFrtTermCd, String diFrtTermCd, String n3ptyRcvOfcCd) {
        this.oaTypBkgConvTpCd = oaTypBkgConvTpCd;
        this.oaRacConvCtnt = oaRacConvCtnt;
        this.oaPrcTrspModCd = oaPrcTrspModCd;
        this.diPrcTrspModCd = diPrcTrspModCd;
        this.pagerows = pagerows;
        this.oaRcvDeTermCd = oaRcvDeTermCd;
        this.daTypBkgConvTpCd = daTypBkgConvTpCd;
        this.cntrTpszCd = cntrTpszCd;
//        this.daTypNoteConvSeq = daTypNoteConvSeq;
        this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
//        this.oaRarFrtRtAmt = oaRarFrtRtAmt;
//        this.oaDorNoteConvTpCd = oaDorNoteConvTpCd;
        this.oaCurrCd = oaCurrCd;
//        this.oaRarBkgConvTpCd = oaRarBkgConvTpCd;
        this.cntrWgt = cntrWgt;
        this.daFnlFrtRtAmt = daFnlFrtRtAmt;
        this.rtRarBkgConvTpCd = rtRarBkgConvTpCd;
        this.daRacDaOpCd = daRacDaOpCd;
        this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
        this.oaRapBkgConvTpCd = oaRapBkgConvTpCd;
//        this.oaRapNoteConvSeq = oaRapNoteConvSeq;
        this.oaRacFrtRtAmt = oaRacFrtRtAmt;
//        this.daRarFrtRtAmt = daRarFrtRtAmt;
        this.diRcvDeTermCd = diRcvDeTermCd;
        this.rtCalcFrtRtAmt = rtCalcFrtRtAmt;
        this.oaTypRtOpCd = oaTypRtOpCd;
        this.daRapCurrCd = daRapCurrCd;
        this.oaRacBkgConvTpCd = oaRacBkgConvTpCd;
        this.rtRarCurrCd = rtRarCurrCd;
//        this.daRarBkgConvTpCd = daRarBkgConvTpCd;
        this.diCurrCd = diCurrCd;
//        this.daRapNoteConvSeq = daRapNoteConvSeq;
        this.rcFlg = rcFlg;
        this.rtRasBkgConvTpCd = rtRasBkgConvTpCd;
        this.rtRapCurrCd = rtRapCurrCd;
        this.prcCgoTpCd = prcCgoTpCd;
        this.oiRatUtCd = oiRatUtCd;
        this.rtRacCurrCd = rtRacCurrCd;
        this.oaRacCurrCd = oaRacCurrCd;
        this.daTypDaOpCd = daTypDaOpCd;
        this.rtDorNoteConvTpCd = rtDorNoteConvTpCd;
        this.daRacBkgConvTpCd = daRacBkgConvTpCd;
        this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
//        this.daRarNoteConvTpCd = daRarNoteConvTpCd;
        this.daRapDaOpCd = daRapDaOpCd;
//        this.rtAppNoteConvSeq = rtAppNoteConvSeq;
        this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
        this.rtRacFrtRtAmt = rtRacFrtRtAmt;
        this.rtPrcCgoTpCd = rtPrcCgoTpCd;
        this.rtAddRtOpCd = rtAddRtOpCd;
        this.diDirCallFlg = diDirCallFlg;
        this.rtDorConvCtnt = rtDorConvCtnt;
        this.daTypConvCtnt = daTypConvCtnt;
        this.rtRapFrtRtAmt = rtRapFrtRtAmt;
//        this.rtRacNoteConvSeq = rtRacNoteConvSeq;
//        this.oaRarNoteConvTpCd = oaRarNoteConvTpCd;
        this.cnt = cnt;
        this.daRcvDeTermCd = daRcvDeTermCd;
        this.daTypFrtRtAmt = daTypFrtRtAmt;
        this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
        this.rtArbRtOpCd = rtArbRtOpCd;
        this.propNo = propNo;
        this.daRapNoteConvTpCd = daRapNoteConvTpCd;
        this.rtRapBkgConvTpCd = rtRapBkgConvTpCd;
        this.rtAplyDt = rtAplyDt;
        this.diPrcCgoTpCd = diPrcCgoTpCd;
        this.porMtchFlg = porMtchFlg;
        this.chgCd = chgCd;
//        this.daRarCurrCd = daRarCurrCd;
        this.dtl = dtl;
//        this.daDorNoteConvSeq = daDorNoteConvSeq;
        this.destTrspModCd = destTrspModCd;
        this.rtRasRtOpCd = rtRasRtOpCd;
        this.prcGenSpclRtTpCd = prcGenSpclRtTpCd;
        this.rtRarNoteConvTpCd = rtRarNoteConvTpCd;
        this.diFnlFrtRtAmt = diFnlFrtRtAmt;
        this.oiPrcCmdtDefCd = oiPrcCmdtDefCd;
        this.oaDorFrtRtAmt = oaDorFrtRtAmt;
        this.inGaFlg = inGaFlg;
        this.delCntCd = delCntCd;
        this.frtTermCd = frtTermCd;
        this.oiPrcCgoTpCd = oiPrcCgoTpCd;
        this.rtRapConvCtnt = rtRapConvCtnt;
        this.daPrcTrspModCd = daPrcTrspModCd;
        this.rtRarRtOpCd = rtRarRtOpCd;
        this.porCd = porCd;
        this.rtAppCurrCd = rtAppCurrCd;
//        this.rtRasNoteConvSeq = rtRasNoteConvSeq;
        this.daDirCallFlg = daDirCallFlg;
        this.daRapFrtRtAmt = daRapFrtRtAmt;
        this.oaRoutPntLocDefCd = oaRoutPntLocDefCd;
        this.rtTypFrtRtAmt = rtTypFrtRtAmt;
        this.noteCtnt = noteCtnt;
        this.ibflag = ibflag;
        this.oaRatUtCd = oaRatUtCd;
        this.rtFnlFrtRtAmt = rtFnlFrtRtAmt;
        this.oaTypNoteConvTpCd = oaTypNoteConvTpCd;
        this.dvRoutViaPortDefCd = dvRoutViaPortDefCd;
//        this.rtDorNoteConvSeq = rtDorNoteConvSeq;
        this.rtArbNoteConvTpCd = rtArbNoteConvTpCd;
        this.chgUtAmt = chgUtAmt;
        this.rtTypConvCtnt = rtTypConvCtnt;
        this.daBsePortDefCd = daBsePortDefCd;
        this.daRacFrtRtAmt = daRacFrtRtAmt;
        this.prcRoutSeq = prcRoutSeq;
        this.ctrtCntrTpszCd = ctrtCntrTpszCd;
        this.oiPrcTrspModCd = oiPrcTrspModCd;
        this.delMtchFlg = delMtchFlg;
        this.opRoutPntLocDefCd = opRoutPntLocDefCd;
        this.daDorNoteConvTpCd = daDorNoteConvTpCd;
        this.cmdtNm = cmdtNm;
        this.socFlg = socFlg;
        this.daPrcCmdtDefCd = daPrcCmdtDefCd;
        this.daTypCurrCd = daTypCurrCd;
        this.frtInclXcldDivCd = frtInclXcldDivCd;
        this.deTermCd = deTermCd;
        this.trnsModCd = trnsModCd;
        this.oaTypCurrCd = oaTypCurrCd;
        this.frtRtAmt = frtRtAmt;
        this.rtRatUtCd = rtRatUtCd;
        this.rtAddBkgConvTpCd = rtAddBkgConvTpCd;
        this.daTypNoteConvTpCd = daTypNoteConvTpCd;
        this.rtAppFrtRtAmt = rtAppFrtRtAmt;
        this.daCalcFrtRtAmt = daCalcFrtRtAmt;
//        this.oaRacNoteConvSeq = oaRacNoteConvSeq;
//        this.oaRarCurrCd = oaRarCurrCd;
        this.svcScpCd = svcScpCd;
        this.rtDorFrtRtAmt = rtDorFrtRtAmt;
        this.cgoTpCd = cgoTpCd;
        this.oaDorCurrCd = oaDorCurrCd;
        this.rtRasConvCtnt = rtRasConvCtnt;
        this.oaPrcCgoTpCd = oaPrcCgoTpCd;
        this.daRacConvCtnt = daRacConvCtnt;
        this.chgAmt = chgAmt;
        this.oaPrcCmdtDefCd = oaPrcCmdtDefCd;
        this.rcvDeTermCd = rcvDeTermCd;
        this.oiRoutPntLocDefCd = oiRoutPntLocDefCd;
        this.oiDirCallFlg = oiDirCallFlg;
        this.dirCallFlg = dirCallFlg;
        this.ratUtCd = ratUtCd;
        this.diCalcFrtRtAmt = diCalcFrtRtAmt;
//        this.daRarNoteConvSeq = daRarNoteConvSeq;
        this.oftCmbSeq = oftCmbSeq;
        this.podCd = podCd;
        this.daViaPortDefCd = daViaPortDefCd;
        this.diRatUtCd = diRatUtCd;
        this.oaFnlFrtRtAmt = oaFnlFrtRtAmt;
        this.daRatUtCd = daRatUtCd;
        this.bkgNo = bkgNo;
        this.prcRtSeq = prcRtSeq;
        this.rtRarFrtRtAmt = rtRarFrtRtAmt;
        this.oaDirCallFlg = oaDirCallFlg;
        this.opCntrQty = opCntrQty;
        this.daRapBkgConvTpCd = daRapBkgConvTpCd;
        this.rtArbFrtRtAmt = rtArbFrtRtAmt;
        this.pctBseCd = pctBseCd;
        this.imdgClssCd = imdgClssCd;
        this.rtRarConvCtnt = rtRarConvCtnt;
        this.dpSeq = dpSeq;
        this.rtRacNoteConvTpCd = rtRacNoteConvTpCd;
        this.rtDorCurrCd = rtDorCurrCd;
        this.rtRacConvCtnt = rtRacConvCtnt;
        this.daPrcCgoTpCd = daPrcCgoTpCd;
        this.prcCmdtHdrSeq = prcCmdtHdrSeq;
        this.fnlFrtRtAmt = fnlFrtRtAmt;
        this.rtRasCurrCd = rtRasCurrCd;
//        this.oaRarRtOpCd = oaRarRtOpCd;
        this.oaRapRtOpCd = oaRapRtOpCd;
        this.usrId = usrId;
//        this.rtArbNoteConvSeq = rtArbNoteConvSeq;
//        this.daRacNoteConvSeq = daRacNoteConvSeq;
//        this.rtTypNoteConvSeq = rtTypNoteConvSeq;
        this.note = note;
        this.rtAddNoteConvTpCd = rtAddNoteConvTpCd;
        this.rtTypCurrCd = rtTypCurrCd;
//        this.rtAddNoteConvSeq = rtAddNoteConvSeq;
        this.rtDorRtOpCd = rtDorRtOpCd;
//        this.rtRarNoteConvSeq = rtRarNoteConvSeq;
        this.inclOftFlg = inclOftFlg;
        this.oaTypConvCtnt = oaTypConvCtnt;
        this.rtArbCurrCd = rtArbCurrCd;
        this.daRoutPntLocDefCd = daRoutPntLocDefCd;
        this.oaBsePortDefCd = oaBsePortDefCd;
        this.prcHngrBarTpCd = prcHngrBarTpCd;
        this.rtRacBkgConvTpCd = rtRacBkgConvTpCd;
        this.oiCurrCd = oiCurrCd;
        this.oiFnlFrtRtAmt = oiFnlFrtRtAmt;
        this.rtTypNoteConvTpCd = rtTypNoteConvTpCd;
        this.dryCgoFlg = dryCgoFlg;
        this.rtAddFrtRtAmt = rtAddFrtRtAmt;
        this.amdtSeq = amdtSeq;
//        this.rtRapNoteConvSeq = rtRapNoteConvSeq;
        this.orgTrspModCd = orgTrspModCd;
        this.oaRapCurrCd = oaRapCurrCd;
        this.daDorCurrCd = daDorCurrCd;
        this.daDorBkgConvTpCd = daDorBkgConvTpCd;
//        this.oaRarNoteConvSeq = oaRarNoteConvSeq;
        this.polCd = polCd;
        this.cgoCateCd = cgoCateCd;
        this.rtAddCurrCd = rtAddCurrCd;
        this.oaRacNoteConvTpCd = oaRacNoteConvTpCd;
        this.rtMtchPattCd = rtMtchPattCd;
        this.oaDorBkgConvTpCd = oaDorBkgConvTpCd;
        this.daCurrCd = daCurrCd;
        this.awkCgoFlg = awkCgoFlg;
        this.delCd = delCd;
        this.rtRacRtOpCd = rtRacRtOpCd;
        this.oaRacRtOpCd = oaRacRtOpCd;
        this.rtRapNoteConvTpCd = rtRapNoteConvTpCd;
        this.diRoutPntLocDefCd = diRoutPntLocDefCd;
//        this.daRarDaOpCd = daRarDaOpCd;
        this.oaTypFrtRtAmt = oaTypFrtRtAmt;
        this.ratAsQty = ratAsQty;
        this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
        this.rtTypRtOpCd = rtTypRtOpCd;
        this.oiRcvDeTermCd = oiRcvDeTermCd;
        this.currCd = currCd;
        this.triPropNo = triPropNo;
//        this.oaTypNoteConvSeq = oaTypNoteConvSeq;
        this.rtRapRtOpCd = rtRapRtOpCd;
        this.daRacCurrCd = daRacCurrCd;
        this.oaRapFrtRtAmt = oaRapFrtRtAmt;
        this.bbCgoFlg = bbCgoFlg;
        this.rtDorBkgConvTpCd = rtDorBkgConvTpCd;
        this.dcgoFlg = dcgoFlg;
//        this.oaDorNoteConvSeq = oaDorNoteConvSeq;
        this.daDorDaOpCd = daDorDaOpCd;
        this.rcvTermCd = rcvTermCd;
        this.porCntCd = porCntCd;
        this.rtRasFrtRtAmt = rtRasFrtRtAmt;
        this.diBsePortDefCd = diBsePortDefCd;
        this.diPrcCmdtDefCd = diPrcCmdtDefCd;
        this.rtAppNoteConvTpCd = rtAppNoteConvTpCd;
        this.rtArbBkgConvTpCd = rtArbBkgConvTpCd;
        this.daDorFrtRtAmt = daDorFrtRtAmt;
        this.oiBsePortDefCd = oiBsePortDefCd;
        this.daRacNoteConvTpCd = daRacNoteConvTpCd;
        this.oaRapNoteConvTpCd = oaRapNoteConvTpCd;
        this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
        this.oiViaPortDefCd = oiViaPortDefCd;
        this.oaDorRtOpCd = oaDorRtOpCd;
        this.oaViaPortDefCd = oaViaPortDefCd;
        this.rtTypBkgConvTpCd = rtTypBkgConvTpCd;
        this.diViaPortDefCd = diViaPortDefCd;
        this.rtAppRtOpCd = rtAppRtOpCd;
        this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
        this.cmdtSeq = cmdtSeq;
        this.autoRatFlg = autoRatFlg;
        this.pctlNo = pctlNo;
		this.bqSeq = bqSeq;
		this.bkgBqSeq = bkgBqSeq;
		this.bkgBqOccrSeq = bkgBqOccrSeq;
		this.calcCtrtTpCd = calcCtrtTpCd;
		this.prnHdnFlg = prnHdnFlg;
		this.fxRtFlg = fxRtFlg;
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
		this.oaMinCgoWgt = oaMinCgoWgt;
		this.oaMaxCgoWgt = oaMaxCgoWgt;
		this.daMinCgoWgt = daMinCgoWgt;
		this.daMaxCgoWgt = daMaxCgoWgt;
		this.diMinCgoWgt = diMinCgoWgt;
		this.diMaxCgoWgt = diMaxCgoWgt;
		this.taxFlg = taxFlg;
		this.taxCntCd = taxCntCd;
		this.inclTaxFlg = inclTaxFlg;
		this.oiFrtTermCd = oiFrtTermCd;
		this.oaFrtTermCd = oaFrtTermCd;
		this.daFrtTermCd = daFrtTermCd;
		this.diFrtTermCd = diFrtTermCd;
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("oa_typ_bkg_conv_tp_cd", getOaTypBkgConvTpCd());
        this.hashColumns.put("oa_rac_conv_ctnt", getOaRacConvCtnt());
        this.hashColumns.put("oa_prc_trsp_mod_cd", getOaPrcTrspModCd());
        this.hashColumns.put("di_prc_trsp_mod_cd", getDiPrcTrspModCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("oa_rcv_de_term_cd", getOaRcvDeTermCd());
        this.hashColumns.put("da_typ_bkg_conv_tp_cd", getDaTypBkgConvTpCd());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
//        this.hashColumns.put("da_typ_note_conv_seq", getDaTypNoteConvSeq());
        this.hashColumns.put("ov_rout_via_port_def_cd", getOvRoutViaPortDefCd());
//        this.hashColumns.put("oa_rar_frt_rt_amt", getOaRarFrtRtAmt());
//        this.hashColumns.put("oa_dor_note_conv_tp_cd", getOaDorNoteConvTpCd());
        this.hashColumns.put("oa_curr_cd", getOaCurrCd());
//        this.hashColumns.put("oa_rar_bkg_conv_tp_cd", getOaRarBkgConvTpCd());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        this.hashColumns.put("da_fnl_frt_rt_amt", getDaFnlFrtRtAmt());
        this.hashColumns.put("rt_rar_bkg_conv_tp_cd", getRtRarBkgConvTpCd());
        this.hashColumns.put("da_rac_da_op_cd", getDaRacDaOpCd());
        this.hashColumns.put("rt_app_bkg_conv_tp_cd", getRtAppBkgConvTpCd());
        this.hashColumns.put("oa_rap_bkg_conv_tp_cd", getOaRapBkgConvTpCd());
//        this.hashColumns.put("oa_rap_note_conv_seq", getOaRapNoteConvSeq());
        this.hashColumns.put("oa_rac_frt_rt_amt", getOaRacFrtRtAmt());
//        this.hashColumns.put("da_rar_frt_rt_amt", getDaRarFrtRtAmt());
        this.hashColumns.put("di_rcv_de_term_cd", getDiRcvDeTermCd());
        this.hashColumns.put("rt_calc_frt_rt_amt", getRtCalcFrtRtAmt());
        this.hashColumns.put("oa_typ_rt_op_cd", getOaTypRtOpCd());
        this.hashColumns.put("da_rap_curr_cd", getDaRapCurrCd());
        this.hashColumns.put("oa_rac_bkg_conv_tp_cd", getOaRacBkgConvTpCd());
        this.hashColumns.put("rt_rar_curr_cd", getRtRarCurrCd());
//        this.hashColumns.put("da_rar_bkg_conv_tp_cd", getDaRarBkgConvTpCd());
        this.hashColumns.put("di_curr_cd", getDiCurrCd());
//        this.hashColumns.put("da_rap_note_conv_seq", getDaRapNoteConvSeq());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("rt_ras_bkg_conv_tp_cd", getRtRasBkgConvTpCd());
        this.hashColumns.put("rt_rap_curr_cd", getRtRapCurrCd());
        this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
        this.hashColumns.put("oi_rat_ut_cd", getOiRatUtCd());
        this.hashColumns.put("rt_rac_curr_cd", getRtRacCurrCd());
        this.hashColumns.put("oa_rac_curr_cd", getOaRacCurrCd());
        this.hashColumns.put("da_typ_da_op_cd", getDaTypDaOpCd());
        this.hashColumns.put("rt_dor_note_conv_tp_cd", getRtDorNoteConvTpCd());
        this.hashColumns.put("da_rac_bkg_conv_tp_cd", getDaRacBkgConvTpCd());
        this.hashColumns.put("oa_calc_frt_rt_amt", getOaCalcFrtRtAmt());
//        this.hashColumns.put("da_rar_note_conv_tp_cd", getDaRarNoteConvTpCd());
        this.hashColumns.put("da_rap_da_op_cd", getDaRapDaOpCd());
//        this.hashColumns.put("rt_app_note_conv_seq", getRtAppNoteConvSeq());
        this.hashColumns.put("rt_ras_note_conv_tp_cd", getRtRasNoteConvTpCd());
        this.hashColumns.put("rt_rac_frt_rt_amt", getRtRacFrtRtAmt());
        this.hashColumns.put("rt_prc_cgo_tp_cd", getRtPrcCgoTpCd());
        this.hashColumns.put("rt_add_rt_op_cd", getRtAddRtOpCd());
        this.hashColumns.put("di_dir_call_flg", getDiDirCallFlg());
        this.hashColumns.put("rt_dor_conv_ctnt", getRtDorConvCtnt());
        this.hashColumns.put("da_typ_conv_ctnt", getDaTypConvCtnt());
        this.hashColumns.put("rt_rap_frt_rt_amt", getRtRapFrtRtAmt());
//        this.hashColumns.put("rt_rac_note_conv_seq", getRtRacNoteConvSeq());
//        this.hashColumns.put("oa_rar_note_conv_tp_cd", getOaRarNoteConvTpCd());
        this.hashColumns.put("cnt", getCnt());
        this.hashColumns.put("da_rcv_de_term_cd", getDaRcvDeTermCd());
        this.hashColumns.put("da_typ_frt_rt_amt", getDaTypFrtRtAmt());
        this.hashColumns.put("oi_calc_frt_rt_amt", getOiCalcFrtRtAmt());
        this.hashColumns.put("rt_arb_rt_op_cd", getRtArbRtOpCd());
        this.hashColumns.put("prop_no", getPropNo());
        this.hashColumns.put("da_rap_note_conv_tp_cd", getDaRapNoteConvTpCd());
        this.hashColumns.put("rt_rap_bkg_conv_tp_cd", getRtRapBkgConvTpCd());
        this.hashColumns.put("rt_aply_dt", getRtAplyDt());
        this.hashColumns.put("di_prc_cgo_tp_cd", getDiPrcCgoTpCd());
        this.hashColumns.put("por_mtch_flg", getPorMtchFlg());
        this.hashColumns.put("chg_cd", getChgCd());
//        this.hashColumns.put("da_rar_curr_cd", getDaRarCurrCd());
        this.hashColumns.put("dtl", getDtl());
//        this.hashColumns.put("da_dor_note_conv_seq", getDaDorNoteConvSeq());
        this.hashColumns.put("dest_trsp_mod_cd", getDestTrspModCd());
        this.hashColumns.put("rt_ras_rt_op_cd", getRtRasRtOpCd());
        this.hashColumns.put("prc_gen_spcl_rt_tp_cd", getPrcGenSpclRtTpCd());
        this.hashColumns.put("rt_rar_note_conv_tp_cd", getRtRarNoteConvTpCd());
        this.hashColumns.put("di_fnl_frt_rt_amt", getDiFnlFrtRtAmt());
        this.hashColumns.put("oi_prc_cmdt_def_cd", getOiPrcCmdtDefCd());
        this.hashColumns.put("oa_dor_frt_rt_amt", getOaDorFrtRtAmt());
        this.hashColumns.put("in_ga_flg", getInGaFlg());
        this.hashColumns.put("del_cnt_cd", getDelCntCd());
        this.hashColumns.put("frt_term_cd", getFrtTermCd());
        this.hashColumns.put("oi_prc_cgo_tp_cd", getOiPrcCgoTpCd());
        this.hashColumns.put("rt_rap_conv_ctnt", getRtRapConvCtnt());
        this.hashColumns.put("da_prc_trsp_mod_cd", getDaPrcTrspModCd());
        this.hashColumns.put("rt_rar_rt_op_cd", getRtRarRtOpCd());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("rt_app_curr_cd", getRtAppCurrCd());
//        this.hashColumns.put("rt_ras_note_conv_seq", getRtRasNoteConvSeq());
        this.hashColumns.put("da_dir_call_flg", getDaDirCallFlg());
        this.hashColumns.put("da_rap_frt_rt_amt", getDaRapFrtRtAmt());
        this.hashColumns.put("oa_rout_pnt_loc_def_cd", getOaRoutPntLocDefCd());
        this.hashColumns.put("rt_typ_frt_rt_amt", getRtTypFrtRtAmt());
        this.hashColumns.put("note_ctnt", getNoteCtnt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("oa_rat_ut_cd", getOaRatUtCd());
        this.hashColumns.put("rt_fnl_frt_rt_amt", getRtFnlFrtRtAmt());
        this.hashColumns.put("oa_typ_note_conv_tp_cd", getOaTypNoteConvTpCd());
        this.hashColumns.put("dv_rout_via_port_def_cd", getDvRoutViaPortDefCd());
//        this.hashColumns.put("rt_dor_note_conv_seq", getRtDorNoteConvSeq());
        this.hashColumns.put("rt_arb_note_conv_tp_cd", getRtArbNoteConvTpCd());
        this.hashColumns.put("chg_ut_amt", getChgUtAmt());
        this.hashColumns.put("rt_typ_conv_ctnt", getRtTypConvCtnt());
        this.hashColumns.put("da_bse_port_def_cd", getDaBsePortDefCd());
        this.hashColumns.put("da_rac_frt_rt_amt", getDaRacFrtRtAmt());
        this.hashColumns.put("prc_rout_seq", getPrcRoutSeq());
        this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
        this.hashColumns.put("oi_prc_trsp_mod_cd", getOiPrcTrspModCd());
        this.hashColumns.put("del_mtch_flg", getDelMtchFlg());
        this.hashColumns.put("op_rout_pnt_loc_def_cd", getOpRoutPntLocDefCd());
        this.hashColumns.put("da_dor_note_conv_tp_cd", getDaDorNoteConvTpCd());
        this.hashColumns.put("cmdt_nm", getCmdtNm());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("da_prc_cmdt_def_cd", getDaPrcCmdtDefCd());
        this.hashColumns.put("da_typ_curr_cd", getDaTypCurrCd());
        this.hashColumns.put("frt_incl_xcld_div_cd", getFrtInclXcldDivCd());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("trns_mod_cd", getTrnsModCd());
        this.hashColumns.put("oa_typ_curr_cd", getOaTypCurrCd());
        this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
        this.hashColumns.put("rt_rat_ut_cd", getRtRatUtCd());
        this.hashColumns.put("rt_add_bkg_conv_tp_cd", getRtAddBkgConvTpCd());
        this.hashColumns.put("da_typ_note_conv_tp_cd", getDaTypNoteConvTpCd());
        this.hashColumns.put("rt_app_frt_rt_amt", getRtAppFrtRtAmt());
        this.hashColumns.put("da_calc_frt_rt_amt", getDaCalcFrtRtAmt());
//        this.hashColumns.put("oa_rac_note_conv_seq", getOaRacNoteConvSeq());
//        this.hashColumns.put("oa_rar_curr_cd", getOaRarCurrCd());
        this.hashColumns.put("svc_scp_cd", getSvcScpCd());
        this.hashColumns.put("rt_dor_frt_rt_amt", getRtDorFrtRtAmt());
        this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
        this.hashColumns.put("oa_dor_curr_cd", getOaDorCurrCd());
        this.hashColumns.put("rt_ras_conv_ctnt", getRtRasConvCtnt());
        this.hashColumns.put("oa_prc_cgo_tp_cd", getOaPrcCgoTpCd());
        this.hashColumns.put("da_rac_conv_ctnt", getDaRacConvCtnt());
        this.hashColumns.put("chg_amt", getChgAmt());
        this.hashColumns.put("oa_prc_cmdt_def_cd", getOaPrcCmdtDefCd());
        this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
        this.hashColumns.put("oi_rout_pnt_loc_def_cd", getOiRoutPntLocDefCd());
        this.hashColumns.put("oi_dir_call_flg", getOiDirCallFlg());
        this.hashColumns.put("dir_call_flg", getDirCallFlg());
        this.hashColumns.put("rat_ut_cd", getRatUtCd());
        this.hashColumns.put("di_calc_frt_rt_amt", getDiCalcFrtRtAmt());
//        this.hashColumns.put("da_rar_note_conv_seq", getDaRarNoteConvSeq());
        this.hashColumns.put("oft_cmb_seq", getOftCmbSeq());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("da_via_port_def_cd", getDaViaPortDefCd());
        this.hashColumns.put("di_rat_ut_cd", getDiRatUtCd());
        this.hashColumns.put("oa_fnl_frt_rt_amt", getOaFnlFrtRtAmt());
        this.hashColumns.put("da_rat_ut_cd", getDaRatUtCd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("prc_rt_seq", getPrcRtSeq());
        this.hashColumns.put("rt_rar_frt_rt_amt", getRtRarFrtRtAmt());
        this.hashColumns.put("oa_dir_call_flg", getOaDirCallFlg());
        this.hashColumns.put("op_cntr_qty", getOpCntrQty());
        this.hashColumns.put("da_rap_bkg_conv_tp_cd", getDaRapBkgConvTpCd());
        this.hashColumns.put("rt_arb_frt_rt_amt", getRtArbFrtRtAmt());
        this.hashColumns.put("pct_bse_cd", getPctBseCd());
        this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
        this.hashColumns.put("rt_rar_conv_ctnt", getRtRarConvCtnt());
        this.hashColumns.put("dp_seq", getDpSeq());
        this.hashColumns.put("rt_rac_note_conv_tp_cd", getRtRacNoteConvTpCd());
        this.hashColumns.put("rt_dor_curr_cd", getRtDorCurrCd());
        this.hashColumns.put("rt_rac_conv_ctnt", getRtRacConvCtnt());
        this.hashColumns.put("da_prc_cgo_tp_cd", getDaPrcCgoTpCd());
        this.hashColumns.put("prc_cmdt_hdr_seq", getPrcCmdtHdrSeq());
        this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
        this.hashColumns.put("rt_ras_curr_cd", getRtRasCurrCd());
//        this.hashColumns.put("oa_rar_rt_op_cd", getOaRarRtOpCd());
        this.hashColumns.put("oa_rap_rt_op_cd", getOaRapRtOpCd());
        this.hashColumns.put("usr_id", getUsrId());
//        this.hashColumns.put("rt_arb_note_conv_seq", getRtArbNoteConvSeq());
//        this.hashColumns.put("da_rac_note_conv_seq", getDaRacNoteConvSeq());
//        this.hashColumns.put("rt_typ_note_conv_seq", getRtTypNoteConvSeq());
        this.hashColumns.put("note", getNote());
        this.hashColumns.put("rt_add_note_conv_tp_cd", getRtAddNoteConvTpCd());
        this.hashColumns.put("rt_typ_curr_cd", getRtTypCurrCd());
//        this.hashColumns.put("rt_add_note_conv_seq", getRtAddNoteConvSeq());
        this.hashColumns.put("rt_dor_rt_op_cd", getRtDorRtOpCd());
//        this.hashColumns.put("rt_rar_note_conv_seq", getRtRarNoteConvSeq());
        this.hashColumns.put("incl_oft_flg", getInclOftFlg());
        this.hashColumns.put("oa_typ_conv_ctnt", getOaTypConvCtnt());
        this.hashColumns.put("rt_arb_curr_cd", getRtArbCurrCd());
        this.hashColumns.put("da_rout_pnt_loc_def_cd", getDaRoutPntLocDefCd());
        this.hashColumns.put("oa_bse_port_def_cd", getOaBsePortDefCd());
        this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
        this.hashColumns.put("rt_rac_bkg_conv_tp_cd", getRtRacBkgConvTpCd());
        this.hashColumns.put("oi_curr_cd", getOiCurrCd());
        this.hashColumns.put("oi_fnl_frt_rt_amt", getOiFnlFrtRtAmt());
        this.hashColumns.put("rt_typ_note_conv_tp_cd", getRtTypNoteConvTpCd());
        this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
        this.hashColumns.put("rt_add_frt_rt_amt", getRtAddFrtRtAmt());
        this.hashColumns.put("amdt_seq", getAmdtSeq());
//        this.hashColumns.put("rt_rap_note_conv_seq", getRtRapNoteConvSeq());
        this.hashColumns.put("org_trsp_mod_cd", getOrgTrspModCd());
        this.hashColumns.put("oa_rap_curr_cd", getOaRapCurrCd());
        this.hashColumns.put("da_dor_curr_cd", getDaDorCurrCd());
        this.hashColumns.put("da_dor_bkg_conv_tp_cd", getDaDorBkgConvTpCd());
//        this.hashColumns.put("oa_rar_note_conv_seq", getOaRarNoteConvSeq());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("cgo_cate_cd", getCgoCateCd());
        this.hashColumns.put("rt_add_curr_cd", getRtAddCurrCd());
        this.hashColumns.put("oa_rac_note_conv_tp_cd", getOaRacNoteConvTpCd());
        this.hashColumns.put("rt_mtch_patt_cd", getRtMtchPattCd());
        this.hashColumns.put("oa_dor_bkg_conv_tp_cd", getOaDorBkgConvTpCd());
        this.hashColumns.put("da_curr_cd", getDaCurrCd());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("rt_rac_rt_op_cd", getRtRacRtOpCd());
        this.hashColumns.put("oa_rac_rt_op_cd", getOaRacRtOpCd());
        this.hashColumns.put("rt_rap_note_conv_tp_cd", getRtRapNoteConvTpCd());
        this.hashColumns.put("di_rout_pnt_loc_def_cd", getDiRoutPntLocDefCd());
//        this.hashColumns.put("da_rar_da_op_cd", getDaRarDaOpCd());
        this.hashColumns.put("oa_typ_frt_rt_amt", getOaTypFrtRtAmt());
        this.hashColumns.put("rat_as_qty", getRatAsQty());
        this.hashColumns.put("dp_rout_pnt_loc_def_cd", getDpRoutPntLocDefCd());
        this.hashColumns.put("rt_typ_rt_op_cd", getRtTypRtOpCd());
        this.hashColumns.put("oi_rcv_de_term_cd", getOiRcvDeTermCd());
        this.hashColumns.put("curr_cd", getCurrCd());
        this.hashColumns.put("tri_prop_no", getTriPropNo());
//        this.hashColumns.put("oa_typ_note_conv_seq", getOaTypNoteConvSeq());
        this.hashColumns.put("rt_rap_rt_op_cd", getRtRapRtOpCd());
        this.hashColumns.put("da_rac_curr_cd", getDaRacCurrCd());
        this.hashColumns.put("oa_rap_frt_rt_amt", getOaRapFrtRtAmt());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("rt_dor_bkg_conv_tp_cd", getRtDorBkgConvTpCd());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
//        this.hashColumns.put("oa_dor_note_conv_seq", getOaDorNoteConvSeq());
        this.hashColumns.put("da_dor_da_op_cd", getDaDorDaOpCd());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("por_cnt_cd", getPorCntCd());
        this.hashColumns.put("rt_ras_frt_rt_amt", getRtRasFrtRtAmt());
        this.hashColumns.put("di_bse_port_def_cd", getDiBsePortDefCd());
        this.hashColumns.put("di_prc_cmdt_def_cd", getDiPrcCmdtDefCd());
        this.hashColumns.put("rt_app_note_conv_tp_cd", getRtAppNoteConvTpCd());
        this.hashColumns.put("rt_arb_bkg_conv_tp_cd", getRtArbBkgConvTpCd());
        this.hashColumns.put("da_dor_frt_rt_amt", getDaDorFrtRtAmt());
        this.hashColumns.put("oi_bse_port_def_cd", getOiBsePortDefCd());
        this.hashColumns.put("da_rac_note_conv_tp_cd", getDaRacNoteConvTpCd());
        this.hashColumns.put("oa_rap_note_conv_tp_cd", getOaRapNoteConvTpCd());
        this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
        this.hashColumns.put("oi_via_port_def_cd", getOiViaPortDefCd());
        this.hashColumns.put("oa_dor_rt_op_cd", getOaDorRtOpCd());
        this.hashColumns.put("oa_via_port_def_cd", getOaViaPortDefCd());
        this.hashColumns.put("rt_typ_bkg_conv_tp_cd", getRtTypBkgConvTpCd());
        this.hashColumns.put("di_via_port_def_cd", getDiViaPortDefCd());
        this.hashColumns.put("rt_app_rt_op_cd", getRtAppRtOpCd());
        this.hashColumns.put("cm_prc_cmdt_def_cd", getCmPrcCmdtDefCd());
        this.hashColumns.put("cmdt_seq", getCmdtSeq());
        this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
        this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("bq_seq", getBqSeq());
		this.hashColumns.put("bkg_bq_seq", getBkgBqSeq());
		this.hashColumns.put("bkg_bq_occr_seq", getBkgBqOccrSeq());
		this.hashColumns.put("calc_ctrt_tp_cd", getCalcCtrtTpCd());
		this.hashColumns.put("prn_hdn_flg", getPrnHdnFlg());
		this.hashColumns.put("fx_rt_flg", getFxRtFlg());
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
		this.hashColumns.put("oa_min_cgo_wgt", getOaMinCgoWgt());
		this.hashColumns.put("oa_max_cgo_wgt", getOaMaxCgoWgt());
		this.hashColumns.put("da_min_cgo_wgt", getDaMinCgoWgt());
		this.hashColumns.put("da_max_cgo_wgt", getDaMaxCgoWgt());
		this.hashColumns.put("di_min_cgo_wgt", getDiMinCgoWgt());
		this.hashColumns.put("di_max_cgo_wgt", getDiMaxCgoWgt());
		this.hashColumns.put("tax_flg", getTaxFlg());
		this.hashColumns.put("tax_cnt_cd", getTaxCntCd());
		this.hashColumns.put("incl_tax_flg", getInclTaxFlg());
		this.hashColumns.put("oi_frt_term_cd", getOiFrtTermCd());
		this.hashColumns.put("oa_frt_term_cd", getOaFrtTermCd());
		this.hashColumns.put("da_frt_term_cd", getDaFrtTermCd());
		this.hashColumns.put("di_frt_term_cd", getDiFrtTermCd());
		this.hashColumns.put("n3pty_rcv_ofc_cd", getN3ptyRcvOfcCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("oa_typ_bkg_conv_tp_cd", "oaTypBkgConvTpCd");
        this.hashFields.put("oa_rac_conv_ctnt", "oaRacConvCtnt");
        this.hashFields.put("oa_prc_trsp_mod_cd", "oaPrcTrspModCd");
        this.hashFields.put("di_prc_trsp_mod_cd", "diPrcTrspModCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("oa_rcv_de_term_cd", "oaRcvDeTermCd");
        this.hashFields.put("da_typ_bkg_conv_tp_cd", "daTypBkgConvTpCd");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
//        this.hashFields.put("da_typ_note_conv_seq", "daTypNoteConvSeq");
        this.hashFields.put("ov_rout_via_port_def_cd", "ovRoutViaPortDefCd");
//        this.hashFields.put("oa_rar_frt_rt_amt", "oaRarFrtRtAmt");
//        this.hashFields.put("oa_dor_note_conv_tp_cd", "oaDorNoteConvTpCd");
        this.hashFields.put("oa_curr_cd", "oaCurrCd");
//        this.hashFields.put("oa_rar_bkg_conv_tp_cd", "oaRarBkgConvTpCd");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        this.hashFields.put("da_fnl_frt_rt_amt", "daFnlFrtRtAmt");
        this.hashFields.put("rt_rar_bkg_conv_tp_cd", "rtRarBkgConvTpCd");
        this.hashFields.put("da_rac_da_op_cd", "daRacDaOpCd");
        this.hashFields.put("rt_app_bkg_conv_tp_cd", "rtAppBkgConvTpCd");
        this.hashFields.put("oa_rap_bkg_conv_tp_cd", "oaRapBkgConvTpCd");
//        this.hashFields.put("oa_rap_note_conv_seq", "oaRapNoteConvSeq");
        this.hashFields.put("oa_rac_frt_rt_amt", "oaRacFrtRtAmt");
//        this.hashFields.put("da_rar_frt_rt_amt", "daRarFrtRtAmt");
        this.hashFields.put("di_rcv_de_term_cd", "diRcvDeTermCd");
        this.hashFields.put("rt_calc_frt_rt_amt", "rtCalcFrtRtAmt");
        this.hashFields.put("oa_typ_rt_op_cd", "oaTypRtOpCd");
        this.hashFields.put("da_rap_curr_cd", "daRapCurrCd");
        this.hashFields.put("oa_rac_bkg_conv_tp_cd", "oaRacBkgConvTpCd");
        this.hashFields.put("rt_rar_curr_cd", "rtRarCurrCd");
//        this.hashFields.put("da_rar_bkg_conv_tp_cd", "daRarBkgConvTpCd");
        this.hashFields.put("di_curr_cd", "diCurrCd");
//        this.hashFields.put("da_rap_note_conv_seq", "daRapNoteConvSeq");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("rt_ras_bkg_conv_tp_cd", "rtRasBkgConvTpCd");
        this.hashFields.put("rt_rap_curr_cd", "rtRapCurrCd");
        this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
        this.hashFields.put("oi_rat_ut_cd", "oiRatUtCd");
        this.hashFields.put("rt_rac_curr_cd", "rtRacCurrCd");
        this.hashFields.put("oa_rac_curr_cd", "oaRacCurrCd");
        this.hashFields.put("da_typ_da_op_cd", "daTypDaOpCd");
        this.hashFields.put("rt_dor_note_conv_tp_cd", "rtDorNoteConvTpCd");
        this.hashFields.put("da_rac_bkg_conv_tp_cd", "daRacBkgConvTpCd");
        this.hashFields.put("oa_calc_frt_rt_amt", "oaCalcFrtRtAmt");
//        this.hashFields.put("da_rar_note_conv_tp_cd", "daRarNoteConvTpCd");
        this.hashFields.put("da_rap_da_op_cd", "daRapDaOpCd");
//        this.hashFields.put("rt_app_note_conv_seq", "rtAppNoteConvSeq");
        this.hashFields.put("rt_ras_note_conv_tp_cd", "rtRasNoteConvTpCd");
        this.hashFields.put("rt_rac_frt_rt_amt", "rtRacFrtRtAmt");
        this.hashFields.put("rt_prc_cgo_tp_cd", "rtPrcCgoTpCd");
        this.hashFields.put("rt_add_rt_op_cd", "rtAddRtOpCd");
        this.hashFields.put("di_dir_call_flg", "diDirCallFlg");
        this.hashFields.put("rt_dor_conv_ctnt", "rtDorConvCtnt");
        this.hashFields.put("da_typ_conv_ctnt", "daTypConvCtnt");
        this.hashFields.put("rt_rap_frt_rt_amt", "rtRapFrtRtAmt");
//        this.hashFields.put("rt_rac_note_conv_seq", "rtRacNoteConvSeq");
//        this.hashFields.put("oa_rar_note_conv_tp_cd", "oaRarNoteConvTpCd");
        this.hashFields.put("cnt", "cnt");
        this.hashFields.put("da_rcv_de_term_cd", "daRcvDeTermCd");
        this.hashFields.put("da_typ_frt_rt_amt", "daTypFrtRtAmt");
        this.hashFields.put("oi_calc_frt_rt_amt", "oiCalcFrtRtAmt");
        this.hashFields.put("rt_arb_rt_op_cd", "rtArbRtOpCd");
        this.hashFields.put("prop_no", "propNo");
        this.hashFields.put("da_rap_note_conv_tp_cd", "daRapNoteConvTpCd");
        this.hashFields.put("rt_rap_bkg_conv_tp_cd", "rtRapBkgConvTpCd");
        this.hashFields.put("rt_aply_dt", "rtAplyDt");
        this.hashFields.put("di_prc_cgo_tp_cd", "diPrcCgoTpCd");
        this.hashFields.put("por_mtch_flg", "porMtchFlg");
        this.hashFields.put("chg_cd", "chgCd");
//        this.hashFields.put("da_rar_curr_cd", "daRarCurrCd");
        this.hashFields.put("dtl", "dtl");
//        this.hashFields.put("da_dor_note_conv_seq", "daDorNoteConvSeq");
        this.hashFields.put("dest_trsp_mod_cd", "destTrspModCd");
        this.hashFields.put("rt_ras_rt_op_cd", "rtRasRtOpCd");
        this.hashFields.put("prc_gen_spcl_rt_tp_cd", "prcGenSpclRtTpCd");
        this.hashFields.put("rt_rar_note_conv_tp_cd", "rtRarNoteConvTpCd");
        this.hashFields.put("di_fnl_frt_rt_amt", "diFnlFrtRtAmt");
        this.hashFields.put("oi_prc_cmdt_def_cd", "oiPrcCmdtDefCd");
        this.hashFields.put("oa_dor_frt_rt_amt", "oaDorFrtRtAmt");
        this.hashFields.put("in_ga_flg", "inGaFlg");
        this.hashFields.put("del_cnt_cd", "delCntCd");
        this.hashFields.put("frt_term_cd", "frtTermCd");
        this.hashFields.put("oi_prc_cgo_tp_cd", "oiPrcCgoTpCd");
        this.hashFields.put("rt_rap_conv_ctnt", "rtRapConvCtnt");
        this.hashFields.put("da_prc_trsp_mod_cd", "daPrcTrspModCd");
        this.hashFields.put("rt_rar_rt_op_cd", "rtRarRtOpCd");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("rt_app_curr_cd", "rtAppCurrCd");
//        this.hashFields.put("rt_ras_note_conv_seq", "rtRasNoteConvSeq");
        this.hashFields.put("da_dir_call_flg", "daDirCallFlg");
        this.hashFields.put("da_rap_frt_rt_amt", "daRapFrtRtAmt");
        this.hashFields.put("oa_rout_pnt_loc_def_cd", "oaRoutPntLocDefCd");
        this.hashFields.put("rt_typ_frt_rt_amt", "rtTypFrtRtAmt");
        this.hashFields.put("note_ctnt", "noteCtnt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("oa_rat_ut_cd", "oaRatUtCd");
        this.hashFields.put("rt_fnl_frt_rt_amt", "rtFnlFrtRtAmt");
        this.hashFields.put("oa_typ_note_conv_tp_cd", "oaTypNoteConvTpCd");
        this.hashFields.put("dv_rout_via_port_def_cd", "dvRoutViaPortDefCd");
//        this.hashFields.put("rt_dor_note_conv_seq", "rtDorNoteConvSeq");
        this.hashFields.put("rt_arb_note_conv_tp_cd", "rtArbNoteConvTpCd");
        this.hashFields.put("chg_ut_amt", "chgUtAmt");
        this.hashFields.put("rt_typ_conv_ctnt", "rtTypConvCtnt");
        this.hashFields.put("da_bse_port_def_cd", "daBsePortDefCd");
        this.hashFields.put("da_rac_frt_rt_amt", "daRacFrtRtAmt");
        this.hashFields.put("prc_rout_seq", "prcRoutSeq");
        this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
        this.hashFields.put("oi_prc_trsp_mod_cd", "oiPrcTrspModCd");
        this.hashFields.put("del_mtch_flg", "delMtchFlg");
        this.hashFields.put("op_rout_pnt_loc_def_cd", "opRoutPntLocDefCd");
        this.hashFields.put("da_dor_note_conv_tp_cd", "daDorNoteConvTpCd");
        this.hashFields.put("cmdt_nm", "cmdtNm");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("da_prc_cmdt_def_cd", "daPrcCmdtDefCd");
        this.hashFields.put("da_typ_curr_cd", "daTypCurrCd");
        this.hashFields.put("frt_incl_xcld_div_cd", "frtInclXcldDivCd");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("trns_mod_cd", "trnsModCd");
        this.hashFields.put("oa_typ_curr_cd", "oaTypCurrCd");
        this.hashFields.put("frt_rt_amt", "frtRtAmt");
        this.hashFields.put("rt_rat_ut_cd", "rtRatUtCd");
        this.hashFields.put("rt_add_bkg_conv_tp_cd", "rtAddBkgConvTpCd");
        this.hashFields.put("da_typ_note_conv_tp_cd", "daTypNoteConvTpCd");
        this.hashFields.put("rt_app_frt_rt_amt", "rtAppFrtRtAmt");
        this.hashFields.put("da_calc_frt_rt_amt", "daCalcFrtRtAmt");
//        this.hashFields.put("oa_rac_note_conv_seq", "oaRacNoteConvSeq");
//        this.hashFields.put("oa_rar_curr_cd", "oaRarCurrCd");
        this.hashFields.put("svc_scp_cd", "svcScpCd");
        this.hashFields.put("rt_dor_frt_rt_amt", "rtDorFrtRtAmt");
        this.hashFields.put("cgo_tp_cd", "cgoTpCd");
        this.hashFields.put("oa_dor_curr_cd", "oaDorCurrCd");
        this.hashFields.put("rt_ras_conv_ctnt", "rtRasConvCtnt");
        this.hashFields.put("oa_prc_cgo_tp_cd", "oaPrcCgoTpCd");
        this.hashFields.put("da_rac_conv_ctnt", "daRacConvCtnt");
        this.hashFields.put("chg_amt", "chgAmt");
        this.hashFields.put("oa_prc_cmdt_def_cd", "oaPrcCmdtDefCd");
        this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
        this.hashFields.put("oi_rout_pnt_loc_def_cd", "oiRoutPntLocDefCd");
        this.hashFields.put("oi_dir_call_flg", "oiDirCallFlg");
        this.hashFields.put("dir_call_flg", "dirCallFlg");
        this.hashFields.put("rat_ut_cd", "ratUtCd");
        this.hashFields.put("di_calc_frt_rt_amt", "diCalcFrtRtAmt");
//        this.hashFields.put("da_rar_note_conv_seq", "daRarNoteConvSeq");
        this.hashFields.put("oft_cmb_seq", "oftCmbSeq");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("da_via_port_def_cd", "daViaPortDefCd");
        this.hashFields.put("di_rat_ut_cd", "diRatUtCd");
        this.hashFields.put("oa_fnl_frt_rt_amt", "oaFnlFrtRtAmt");
        this.hashFields.put("da_rat_ut_cd", "daRatUtCd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("prc_rt_seq", "prcRtSeq");
        this.hashFields.put("rt_rar_frt_rt_amt", "rtRarFrtRtAmt");
        this.hashFields.put("oa_dir_call_flg", "oaDirCallFlg");
        this.hashFields.put("op_cntr_qty", "opCntrQty");
        this.hashFields.put("da_rap_bkg_conv_tp_cd", "daRapBkgConvTpCd");
        this.hashFields.put("rt_arb_frt_rt_amt", "rtArbFrtRtAmt");
        this.hashFields.put("pct_bse_cd", "pctBseCd");
        this.hashFields.put("imdg_clss_cd", "imdgClssCd");
        this.hashFields.put("rt_rar_conv_ctnt", "rtRarConvCtnt");
        this.hashFields.put("dp_seq", "dpSeq");
        this.hashFields.put("rt_rac_note_conv_tp_cd", "rtRacNoteConvTpCd");
        this.hashFields.put("rt_dor_curr_cd", "rtDorCurrCd");
        this.hashFields.put("rt_rac_conv_ctnt", "rtRacConvCtnt");
        this.hashFields.put("da_prc_cgo_tp_cd", "daPrcCgoTpCd");
        this.hashFields.put("prc_cmdt_hdr_seq", "prcCmdtHdrSeq");
        this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
        this.hashFields.put("rt_ras_curr_cd", "rtRasCurrCd");
//        this.hashFields.put("oa_rar_rt_op_cd", "oaRarRtOpCd");
        this.hashFields.put("oa_rap_rt_op_cd", "oaRapRtOpCd");
        this.hashFields.put("usr_id", "usrId");
//        this.hashFields.put("rt_arb_note_conv_seq", "rtArbNoteConvSeq");
//        this.hashFields.put("da_rac_note_conv_seq", "daRacNoteConvSeq");
//        this.hashFields.put("rt_typ_note_conv_seq", "rtTypNoteConvSeq");
        this.hashFields.put("note", "note");
        this.hashFields.put("rt_add_note_conv_tp_cd", "rtAddNoteConvTpCd");
        this.hashFields.put("rt_typ_curr_cd", "rtTypCurrCd");
//        this.hashFields.put("rt_add_note_conv_seq", "rtAddNoteConvSeq");
        this.hashFields.put("rt_dor_rt_op_cd", "rtDorRtOpCd");
//        this.hashFields.put("rt_rar_note_conv_seq", "rtRarNoteConvSeq");
        this.hashFields.put("incl_oft_flg", "inclOftFlg");
        this.hashFields.put("oa_typ_conv_ctnt", "oaTypConvCtnt");
        this.hashFields.put("rt_arb_curr_cd", "rtArbCurrCd");
        this.hashFields.put("da_rout_pnt_loc_def_cd", "daRoutPntLocDefCd");
        this.hashFields.put("oa_bse_port_def_cd", "oaBsePortDefCd");
        this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
        this.hashFields.put("rt_rac_bkg_conv_tp_cd", "rtRacBkgConvTpCd");
        this.hashFields.put("oi_curr_cd", "oiCurrCd");
        this.hashFields.put("oi_fnl_frt_rt_amt", "oiFnlFrtRtAmt");
        this.hashFields.put("rt_typ_note_conv_tp_cd", "rtTypNoteConvTpCd");
        this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
        this.hashFields.put("rt_add_frt_rt_amt", "rtAddFrtRtAmt");
        this.hashFields.put("amdt_seq", "amdtSeq");
//        this.hashFields.put("rt_rap_note_conv_seq", "rtRapNoteConvSeq");
        this.hashFields.put("org_trsp_mod_cd", "orgTrspModCd");
        this.hashFields.put("oa_rap_curr_cd", "oaRapCurrCd");
        this.hashFields.put("da_dor_curr_cd", "daDorCurrCd");
        this.hashFields.put("da_dor_bkg_conv_tp_cd", "daDorBkgConvTpCd");
//        this.hashFields.put("oa_rar_note_conv_seq", "oaRarNoteConvSeq");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("cgo_cate_cd", "cgoCateCd");
        this.hashFields.put("rt_add_curr_cd", "rtAddCurrCd");
        this.hashFields.put("oa_rac_note_conv_tp_cd", "oaRacNoteConvTpCd");
        this.hashFields.put("rt_mtch_patt_cd", "rtMtchPattCd");
        this.hashFields.put("oa_dor_bkg_conv_tp_cd", "oaDorBkgConvTpCd");
        this.hashFields.put("da_curr_cd", "daCurrCd");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("rt_rac_rt_op_cd", "rtRacRtOpCd");
        this.hashFields.put("oa_rac_rt_op_cd", "oaRacRtOpCd");
        this.hashFields.put("rt_rap_note_conv_tp_cd", "rtRapNoteConvTpCd");
        this.hashFields.put("di_rout_pnt_loc_def_cd", "diRoutPntLocDefCd");
//        this.hashFields.put("da_rar_da_op_cd", "daRarDaOpCd");
        this.hashFields.put("oa_typ_frt_rt_amt", "oaTypFrtRtAmt");
        this.hashFields.put("rat_as_qty", "ratAsQty");
        this.hashFields.put("dp_rout_pnt_loc_def_cd", "dpRoutPntLocDefCd");
        this.hashFields.put("rt_typ_rt_op_cd", "rtTypRtOpCd");
        this.hashFields.put("oi_rcv_de_term_cd", "oiRcvDeTermCd");
        this.hashFields.put("curr_cd", "currCd");
        this.hashFields.put("tri_prop_no", "triPropNo");
//        this.hashFields.put("oa_typ_note_conv_seq", "oaTypNoteConvSeq");
        this.hashFields.put("rt_rap_rt_op_cd", "rtRapRtOpCd");
        this.hashFields.put("da_rac_curr_cd", "daRacCurrCd");
        this.hashFields.put("oa_rap_frt_rt_amt", "oaRapFrtRtAmt");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("rt_dor_bkg_conv_tp_cd", "rtDorBkgConvTpCd");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
//        this.hashFields.put("oa_dor_note_conv_seq", "oaDorNoteConvSeq");
        this.hashFields.put("da_dor_da_op_cd", "daDorDaOpCd");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("por_cnt_cd", "porCntCd");
        this.hashFields.put("rt_ras_frt_rt_amt", "rtRasFrtRtAmt");
        this.hashFields.put("di_bse_port_def_cd", "diBsePortDefCd");
        this.hashFields.put("di_prc_cmdt_def_cd", "diPrcCmdtDefCd");
        this.hashFields.put("rt_app_note_conv_tp_cd", "rtAppNoteConvTpCd");
        this.hashFields.put("rt_arb_bkg_conv_tp_cd", "rtArbBkgConvTpCd");
        this.hashFields.put("da_dor_frt_rt_amt", "daDorFrtRtAmt");
        this.hashFields.put("oi_bse_port_def_cd", "oiBsePortDefCd");
        this.hashFields.put("da_rac_note_conv_tp_cd", "daRacNoteConvTpCd");
        this.hashFields.put("oa_rap_note_conv_tp_cd", "oaRapNoteConvTpCd");
        this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
        this.hashFields.put("oi_via_port_def_cd", "oiViaPortDefCd");
        this.hashFields.put("oa_dor_rt_op_cd", "oaDorRtOpCd");
        this.hashFields.put("oa_via_port_def_cd", "oaViaPortDefCd");
        this.hashFields.put("rt_typ_bkg_conv_tp_cd", "rtTypBkgConvTpCd");
        this.hashFields.put("di_via_port_def_cd", "diViaPortDefCd");
        this.hashFields.put("rt_app_rt_op_cd", "rtAppRtOpCd");
        this.hashFields.put("cm_prc_cmdt_def_cd", "cmPrcCmdtDefCd");
        this.hashFields.put("cmdt_seq", "cmdtSeq");
        this.hashFields.put("auto_rat_flg", "autoRatFlg");
        this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("bq_seq", "bqSeq");
		this.hashFields.put("bkg_bq_seq", "bkgBqSeq");
		this.hashFields.put("bkg_bq_occr_seq", "bkgBqOccrSeq");
		this.hashFields.put("calc_ctrt_tp_cd", "calcCtrtTpCd");
		this.hashFields.put("prn_hdn_flg", "prnHdnFlg");
		this.hashFields.put("fx_rt_flg", "fxRtFlg");
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
		this.hashFields.put("oa_min_cgo_wgt", "oaMinCgoWgt");
		this.hashFields.put("oa_max_cgo_wgt", "oaMaxCgoWgt");
		this.hashFields.put("da_min_cgo_wgt", "daMinCgoWgt");
		this.hashFields.put("da_max_cgo_wgt", "daMaxCgoWgt");
		this.hashFields.put("di_min_cgo_wgt", "diMinCgoWgt");
		this.hashFields.put("di_max_cgo_wgt", "diMaxCgoWgt");
		this.hashFields.put("tax_flg", "taxFlg");
		this.hashFields.put("tax_cnt_cd", "taxCntCd");
		this.hashFields.put("incl_tax_flg", "inclTaxFlg");
		this.hashFields.put("oi_frt_term_cd", "oiFrtTermCd");
		this.hashFields.put("oa_frt_term_cd", "oaFrtTermCd");
		this.hashFields.put("da_frt_term_cd", "daFrtTermCd");
		this.hashFields.put("di_frt_term_cd", "diFrtTermCd");
		this.hashFields.put("n3pty_rcv_ofc_cd", "n3ptyRcvOfcCd");
		
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
	 * @return oaRacConvCtnt
	 */
    public String getOaRacConvCtnt() {
        return this.oaRacConvCtnt;
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
	 * @return daTypBkgConvTpCd
	 */
    public String getDaTypBkgConvTpCd() {
        return this.daTypBkgConvTpCd;
    }

    /**
	 * Column Info
	 * @return cntrTpszCd
	 */
    public String getCntrTpszCd() {
        return this.cntrTpszCd;
    }

//    /**
//	 * Column Info
//	 * @return daTypNoteConvSeq
//	 */
//    public String getDaTypNoteConvSeq() {
//        return this.daTypNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return ovRoutViaPortDefCd
	 */
    public String getOvRoutViaPortDefCd() {
        return this.ovRoutViaPortDefCd;
    }

//    /**
//	 * Column Info
//	 * @return oaRarFrtRtAmt
//	 */
//    public String getOaRarFrtRtAmt() {
//        return this.oaRarFrtRtAmt;
//    }

//    /**
//	 * Column Info
//	 * @return oaDorNoteConvTpCd
//	 */
//    public String getOaDorNoteConvTpCd() {
//        return this.oaDorNoteConvTpCd;
//    }

    /**
	 * Column Info
	 * @return oaCurrCd
	 */
    public String getOaCurrCd() {
        return this.oaCurrCd;
    }

//    /**
//	 * Column Info
//	 * @return oaRarBkgConvTpCd
//	 */
//    public String getOaRarBkgConvTpCd() {
//        return this.oaRarBkgConvTpCd;
//    }

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
	 * @return rtAppBkgConvTpCd
	 */
    public String getRtAppBkgConvTpCd() {
        return this.rtAppBkgConvTpCd;
    }

    /**
	 * Column Info
	 * @return oaRapBkgConvTpCd
	 */
    public String getOaRapBkgConvTpCd() {
        return this.oaRapBkgConvTpCd;
    }

//    /**
//	 * Column Info
//	 * @return oaRapNoteConvSeq
//	 */
//    public String getOaRapNoteConvSeq() {
//        return this.oaRapNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return oaRacFrtRtAmt
	 */
    public String getOaRacFrtRtAmt() {
        return this.oaRacFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @return daRarFrtRtAmt
//	 */
//    public String getDaRarFrtRtAmt() {
//        return this.daRarFrtRtAmt;
//    }

    /**
	 * Column Info
	 * @return diRcvDeTermCd
	 */
    public String getDiRcvDeTermCd() {
        return this.diRcvDeTermCd;
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
	 * @return oaTypRtOpCd
	 */
    public String getOaTypRtOpCd() {
        return this.oaTypRtOpCd;
    }

    /**
	 * Column Info
	 * @return daRapCurrCd
	 */
    public String getDaRapCurrCd() {
        return this.daRapCurrCd;
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

//    /**
//	 * Column Info
//	 * @return daRarBkgConvTpCd
//	 */
//    public String getDaRarBkgConvTpCd() {
//        return this.daRarBkgConvTpCd;
//    }

    /**
	 * Column Info
	 * @return diCurrCd
	 */
    public String getDiCurrCd() {
        return this.diCurrCd;
    }

//    /**
//	 * Column Info
//	 * @return daRapNoteConvSeq
//	 */
//    public String getDaRapNoteConvSeq() {
//        return this.daRapNoteConvSeq;
//    }

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
	 * @return oaCalcFrtRtAmt
	 */
    public String getOaCalcFrtRtAmt() {
        return this.oaCalcFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @return daRarNoteConvTpCd
//	 */
//    public String getDaRarNoteConvTpCd() {
//        return this.daRarNoteConvTpCd;
//    }

    /**
	 * Column Info
	 * @return daRapDaOpCd
	 */
    public String getDaRapDaOpCd() {
        return this.daRapDaOpCd;
    }

//    /**
//	 * Column Info
//	 * @return rtAppNoteConvSeq
//	 */
//    public String getRtAppNoteConvSeq() {
//        return this.rtAppNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return rtRasNoteConvTpCd
	 */
    public String getRtRasNoteConvTpCd() {
        return this.rtRasNoteConvTpCd;
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
	 * @return rtPrcCgoTpCd
	 */
    public String getRtPrcCgoTpCd() {
        return this.rtPrcCgoTpCd;
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
	 * @return rtDorConvCtnt
	 */
    public String getRtDorConvCtnt() {
        return this.rtDorConvCtnt;
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
	 * @return rtRapFrtRtAmt
	 */
    public String getRtRapFrtRtAmt() {
        return this.rtRapFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @return rtRacNoteConvSeq
//	 */
//    public String getRtRacNoteConvSeq() {
//        return this.rtRacNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @return oaRarNoteConvTpCd
//	 */
//    public String getOaRarNoteConvTpCd() {
//        return this.oaRarNoteConvTpCd;
//    }

    /**
	 * Column Info
	 * @return cnt
	 */
    public String getCnt() {
        return this.cnt;
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
	 * @return oiCalcFrtRtAmt
	 */
    public String getOiCalcFrtRtAmt() {
        return this.oiCalcFrtRtAmt;
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
	 * @return propNo
	 */
    public String getPropNo() {
        return this.propNo;
    }

    /**
	 * Column Info
	 * @return daRapNoteConvTpCd
	 */
    public String getDaRapNoteConvTpCd() {
        return this.daRapNoteConvTpCd;
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
	 * @return rtAplyDt
	 */
    public String getRtAplyDt() {
        return this.rtAplyDt;
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
	 * @return chgCd
	 */
    public String getChgCd() {
        return this.chgCd;
    }

//    /**
//	 * Column Info
//	 * @return daRarCurrCd
//	 */
//    public String getDaRarCurrCd() {
//        return this.daRarCurrCd;
//    }

    /**
	 * Column Info
	 * @return dtl
	 */
    public String getDtl() {
        return this.dtl;
    }

//    /**
//	 * Column Info
//	 * @return daDorNoteConvSeq
//	 */
//    public String getDaDorNoteConvSeq() {
//        return this.daDorNoteConvSeq;
//    }

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
	 * @return diFnlFrtRtAmt
	 */
    public String getDiFnlFrtRtAmt() {
        return this.diFnlFrtRtAmt;
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
	 * @return oaDorFrtRtAmt
	 */
    public String getOaDorFrtRtAmt() {
        return this.oaDorFrtRtAmt;
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
	 * @return frtTermCd
	 */
    public String getFrtTermCd() {
        return this.frtTermCd;
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
	 * @return rtRapConvCtnt
	 */
    public String getRtRapConvCtnt() {
        return this.rtRapConvCtnt;
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
	 * @return rtAppCurrCd
	 */
    public String getRtAppCurrCd() {
        return this.rtAppCurrCd;
    }

//    /**
//	 * Column Info
//	 * @return rtRasNoteConvSeq
//	 */
//    public String getRtRasNoteConvSeq() {
//        return this.rtRasNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return daDirCallFlg
	 */
    public String getDaDirCallFlg() {
        return this.daDirCallFlg;
    }

    /**
	 * Column Info
	 * @return daRapFrtRtAmt
	 */
    public String getDaRapFrtRtAmt() {
        return this.daRapFrtRtAmt;
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

//    /**
//	 * Column Info
//	 * @return rtDorNoteConvSeq
//	 */
//    public String getRtDorNoteConvSeq() {
//        return this.rtDorNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return rtArbNoteConvTpCd
	 */
    public String getRtArbNoteConvTpCd() {
        return this.rtArbNoteConvTpCd;
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
	 * @return daDorNoteConvTpCd
	 */
    public String getDaDorNoteConvTpCd() {
        return this.daDorNoteConvTpCd;
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
	 * @return daPrcCmdtDefCd
	 */
    public String getDaPrcCmdtDefCd() {
        return this.daPrcCmdtDefCd;
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
	 * @return oaTypCurrCd
	 */
    public String getOaTypCurrCd() {
        return this.oaTypCurrCd;
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
	 * @return rtAddBkgConvTpCd
	 */
    public String getRtAddBkgConvTpCd() {
        return this.rtAddBkgConvTpCd;
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
	 * @return rtAppFrtRtAmt
	 */
    public String getRtAppFrtRtAmt() {
        return this.rtAppFrtRtAmt;
    }

    /**
	 * Column Info
	 * @return daCalcFrtRtAmt
	 */
    public String getDaCalcFrtRtAmt() {
        return this.daCalcFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @return oaRacNoteConvSeq
//	 */
//    public String getOaRacNoteConvSeq() {
//        return this.oaRacNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @return oaRarCurrCd
//	 */
//    public String getOaRarCurrCd() {
//        return this.oaRarCurrCd;
//    }

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
	 * @return cgoTpCd
	 */
    public String getCgoTpCd() {
        return this.cgoTpCd;
    }

    /**
	 * Column Info
	 * @return oaDorCurrCd
	 */
    public String getOaDorCurrCd() {
        return this.oaDorCurrCd;
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
	 * @return ratUtCd
	 */
    public String getRatUtCd() {
        return this.ratUtCd;
    }

    /**
	 * Column Info
	 * @return diCalcFrtRtAmt
	 */
    public String getDiCalcFrtRtAmt() {
        return this.diCalcFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @return daRarNoteConvSeq
//	 */
//    public String getDaRarNoteConvSeq() {
//        return this.daRarNoteConvSeq;
//    }

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
	 * @return daViaPortDefCd
	 */
    public String getDaViaPortDefCd() {
        return this.daViaPortDefCd;
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
	 * @return opCntrQty
	 */
    public String getOpCntrQty() {
        return this.opCntrQty;
    }

    /**
	 * Column Info
	 * @return daRapBkgConvTpCd
	 */
    public String getDaRapBkgConvTpCd() {
        return this.daRapBkgConvTpCd;
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
	 * @return pctBseCd
	 */
    public String getPctBseCd() {
        return this.pctBseCd;
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
	 * @return rtRacNoteConvTpCd
	 */
    public String getRtRacNoteConvTpCd() {
        return this.rtRacNoteConvTpCd;
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
	 * @return rtRacConvCtnt
	 */
    public String getRtRacConvCtnt() {
        return this.rtRacConvCtnt;
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
	 * @return rtRasCurrCd
	 */
    public String getRtRasCurrCd() {
        return this.rtRasCurrCd;
    }

//    /**
//	 * Column Info
//	 * @return oaRarRtOpCd
//	 */
//    public String getOaRarRtOpCd() {
//        return this.oaRarRtOpCd;
//    }

    /**
	 * Column Info
	 * @return oaRapRtOpCd
	 */
    public String getOaRapRtOpCd() {
        return this.oaRapRtOpCd;
    }

    /**
	 * Column Info
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

//    /**
//	 * Column Info
//	 * @return rtArbNoteConvSeq
//	 */
//    public String getRtArbNoteConvSeq() {
//        return this.rtArbNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @return daRacNoteConvSeq
//	 */
//    public String getDaRacNoteConvSeq() {
//        return this.daRacNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @return rtTypNoteConvSeq
//	 */
//    public String getRtTypNoteConvSeq() {
//        return this.rtTypNoteConvSeq;
//    }

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

//    /**
//	 * Column Info
//	 * @return rtAddNoteConvSeq
//	 */
//    public String getRtAddNoteConvSeq() {
//        return this.rtAddNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return rtDorRtOpCd
	 */
    public String getRtDorRtOpCd() {
        return this.rtDorRtOpCd;
    }

//    /**
//	 * Column Info
//	 * @return rtRarNoteConvSeq
//	 */
//    public String getRtRarNoteConvSeq() {
//        return this.rtRarNoteConvSeq;
//    }

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
	 * @return rtArbCurrCd
	 */
    public String getRtArbCurrCd() {
        return this.rtArbCurrCd;
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
	 * @return prcHngrBarTpCd
	 */
    public String getPrcHngrBarTpCd() {
        return this.prcHngrBarTpCd;
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
	 * @return oiCurrCd
	 */
    public String getOiCurrCd() {
        return this.oiCurrCd;
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

//    /**
//	 * Column Info
//	 * @return rtRapNoteConvSeq
//	 */
//    public String getRtRapNoteConvSeq() {
//        return this.rtRapNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return orgTrspModCd
	 */
    public String getOrgTrspModCd() {
        return this.orgTrspModCd;
    }

    /**
	 * Column Info
	 * @return oaRapCurrCd
	 */
    public String getOaRapCurrCd() {
        return this.oaRapCurrCd;
    }

    /**
	 * Column Info
	 * @return daDorCurrCd
	 */
    public String getDaDorCurrCd() {
        return this.daDorCurrCd;
    }

    /**
	 * Column Info
	 * @return daDorBkgConvTpCd
	 */
    public String getDaDorBkgConvTpCd() {
        return this.daDorBkgConvTpCd;
    }

//    /**
//	 * Column Info
//	 * @return oaRarNoteConvSeq
//	 */
//    public String getOaRarNoteConvSeq() {
//        return this.oaRarNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return polCd
	 */
    public String getPolCd() {
        return this.polCd;
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
	 * @return oaDorBkgConvTpCd
	 */
    public String getOaDorBkgConvTpCd() {
        return this.oaDorBkgConvTpCd;
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

//    /**
//	 * Column Info
//	 * @return daRarDaOpCd
//	 */
//    public String getDaRarDaOpCd() {
//        return this.daRarDaOpCd;
//    }

    /**
	 * Column Info
	 * @return oaTypFrtRtAmt
	 */
    public String getOaTypFrtRtAmt() {
        return this.oaTypFrtRtAmt;
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
	 * @return dpRoutPntLocDefCd
	 */
    public String getDpRoutPntLocDefCd() {
        return this.dpRoutPntLocDefCd;
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
	 * @return triPropNo
	 */
    public String getTriPropNo() {
        return this.triPropNo;
    }

//    /**
//	 * Column Info
//	 * @return oaTypNoteConvSeq
//	 */
//    public String getOaTypNoteConvSeq() {
//        return this.oaTypNoteConvSeq;
//    }

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
	 * @return oaRapFrtRtAmt
	 */
    public String getOaRapFrtRtAmt() {
        return this.oaRapFrtRtAmt;
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
	 * @return dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
    }

//    /**
//	 * Column Info
//	 * @return oaDorNoteConvSeq
//	 */
//    public String getOaDorNoteConvSeq() {
//        return this.oaDorNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @return daDorDaOpCd
	 */
    public String getDaDorDaOpCd() {
        return this.daDorDaOpCd;
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
	 * @return daDorFrtRtAmt
	 */
    public String getDaDorFrtRtAmt() {
        return this.daDorFrtRtAmt;
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
	 * @return oaRapNoteConvTpCd
	 */
    public String getOaRapNoteConvTpCd() {
        return this.oaRapNoteConvTpCd;
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
	 * @return oaDorRtOpCd
	 */
    public String getOaDorRtOpCd() {
        return this.oaDorRtOpCd;
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
	 * @return cmPrcCmdtDefCd
	 */
    public String getCmPrcCmdtDefCd() {
        return this.cmPrcCmdtDefCd;
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
	 * @return bqSeq
	 */
	public String getBqSeq() {
		return this.bqSeq;
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
	 * @return bkgBqOccrSeq
	 */
	public String getBkgBqOccrSeq() {
		return this.bkgBqOccrSeq;
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
	 * @return prnHdnFlg
	 */
	public String getPrnHdnFlg() {
		return this.prnHdnFlg;
	}
	
	/**
	 * Column Info
	 * @return fxRtFlg
	 */
	public String getFxRtFlg() {
		return this.fxRtFlg;
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
	 * @param oaRacConvCtnt
	 */
    public void setOaRacConvCtnt(String oaRacConvCtnt) {
        this.oaRacConvCtnt = oaRacConvCtnt;
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
	 * @param daTypBkgConvTpCd
	 */
    public void setDaTypBkgConvTpCd(String daTypBkgConvTpCd) {
        this.daTypBkgConvTpCd = daTypBkgConvTpCd;
    }

    /**
	 * Column Info
	 * @param cntrTpszCd
	 */
    public void setCntrTpszCd(String cntrTpszCd) {
        this.cntrTpszCd = cntrTpszCd;
    }

//    /**
//	 * Column Info
//	 * @param daTypNoteConvSeq
//	 */
//    public void setDaTypNoteConvSeq(String daTypNoteConvSeq) {
//        this.daTypNoteConvSeq = daTypNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param ovRoutViaPortDefCd
	 */
    public void setOvRoutViaPortDefCd(String ovRoutViaPortDefCd) {
        this.ovRoutViaPortDefCd = ovRoutViaPortDefCd;
    }

//    /**
//	 * Column Info
//	 * @param oaRarFrtRtAmt
//	 */
//    public void setOaRarFrtRtAmt(String oaRarFrtRtAmt) {
//        this.oaRarFrtRtAmt = oaRarFrtRtAmt;
//    }

//    /**
//	 * Column Info
//	 * @param oaDorNoteConvTpCd
//	 */
//    public void setOaDorNoteConvTpCd(String oaDorNoteConvTpCd) {
//        this.oaDorNoteConvTpCd = oaDorNoteConvTpCd;
//    }

    /**
	 * Column Info
	 * @param oaCurrCd
	 */
    public void setOaCurrCd(String oaCurrCd) {
        this.oaCurrCd = oaCurrCd;
    }

//    /**
//	 * Column Info
//	 * @param oaRarBkgConvTpCd
//	 */
//    public void setOaRarBkgConvTpCd(String oaRarBkgConvTpCd) {
//        this.oaRarBkgConvTpCd = oaRarBkgConvTpCd;
//    }

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
	 * @param rtAppBkgConvTpCd
	 */
    public void setRtAppBkgConvTpCd(String rtAppBkgConvTpCd) {
        this.rtAppBkgConvTpCd = rtAppBkgConvTpCd;
    }

    /**
	 * Column Info
	 * @param oaRapBkgConvTpCd
	 */
    public void setOaRapBkgConvTpCd(String oaRapBkgConvTpCd) {
        this.oaRapBkgConvTpCd = oaRapBkgConvTpCd;
    }

//    /**
//	 * Column Info
//	 * @param oaRapNoteConvSeq
//	 */
//    public void setOaRapNoteConvSeq(String oaRapNoteConvSeq) {
//        this.oaRapNoteConvSeq = oaRapNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param oaRacFrtRtAmt
	 */
    public void setOaRacFrtRtAmt(String oaRacFrtRtAmt) {
        this.oaRacFrtRtAmt = oaRacFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @param daRarFrtRtAmt
//	 */
//    public void setDaRarFrtRtAmt(String daRarFrtRtAmt) {
//        this.daRarFrtRtAmt = daRarFrtRtAmt;
//    }

    /**
	 * Column Info
	 * @param diRcvDeTermCd
	 */
    public void setDiRcvDeTermCd(String diRcvDeTermCd) {
        this.diRcvDeTermCd = diRcvDeTermCd;
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
	 * @param oaTypRtOpCd
	 */
    public void setOaTypRtOpCd(String oaTypRtOpCd) {
        this.oaTypRtOpCd = oaTypRtOpCd;
    }

    /**
	 * Column Info
	 * @param daRapCurrCd
	 */
    public void setDaRapCurrCd(String daRapCurrCd) {
        this.daRapCurrCd = daRapCurrCd;
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

//    /**
//	 * Column Info
//	 * @param daRarBkgConvTpCd
//	 */
//    public void setDaRarBkgConvTpCd(String daRarBkgConvTpCd) {
//        this.daRarBkgConvTpCd = daRarBkgConvTpCd;
//    }

    /**
	 * Column Info
	 * @param diCurrCd
	 */
    public void setDiCurrCd(String diCurrCd) {
        this.diCurrCd = diCurrCd;
    }

//    /**
//	 * Column Info
//	 * @param daRapNoteConvSeq
//	 */
//    public void setDaRapNoteConvSeq(String daRapNoteConvSeq) {
//        this.daRapNoteConvSeq = daRapNoteConvSeq;
//    }

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
	 * @param oaCalcFrtRtAmt
	 */
    public void setOaCalcFrtRtAmt(String oaCalcFrtRtAmt) {
        this.oaCalcFrtRtAmt = oaCalcFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @param daRarNoteConvTpCd
//	 */
//    public void setDaRarNoteConvTpCd(String daRarNoteConvTpCd) {
//        this.daRarNoteConvTpCd = daRarNoteConvTpCd;
//    }

    /**
	 * Column Info
	 * @param daRapDaOpCd
	 */
    public void setDaRapDaOpCd(String daRapDaOpCd) {
        this.daRapDaOpCd = daRapDaOpCd;
    }

//    /**
//	 * Column Info
//	 * @param rtAppNoteConvSeq
//	 */
//    public void setRtAppNoteConvSeq(String rtAppNoteConvSeq) {
//        this.rtAppNoteConvSeq = rtAppNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param rtRasNoteConvTpCd
	 */
    public void setRtRasNoteConvTpCd(String rtRasNoteConvTpCd) {
        this.rtRasNoteConvTpCd = rtRasNoteConvTpCd;
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
	 * @param rtPrcCgoTpCd
	 */
    public void setRtPrcCgoTpCd(String rtPrcCgoTpCd) {
        this.rtPrcCgoTpCd = rtPrcCgoTpCd;
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
	 * @param rtDorConvCtnt
	 */
    public void setRtDorConvCtnt(String rtDorConvCtnt) {
        this.rtDorConvCtnt = rtDorConvCtnt;
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
	 * @param rtRapFrtRtAmt
	 */
    public void setRtRapFrtRtAmt(String rtRapFrtRtAmt) {
        this.rtRapFrtRtAmt = rtRapFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @param rtRacNoteConvSeq
//	 */
//    public void setRtRacNoteConvSeq(String rtRacNoteConvSeq) {
//        this.rtRacNoteConvSeq = rtRacNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @param oaRarNoteConvTpCd
//	 */
//    public void setOaRarNoteConvTpCd(String oaRarNoteConvTpCd) {
//        this.oaRarNoteConvTpCd = oaRarNoteConvTpCd;
//    }

    /**
	 * Column Info
	 * @param cnt
	 */
    public void setCnt(String cnt) {
        this.cnt = cnt;
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
	 * @param oiCalcFrtRtAmt
	 */
    public void setOiCalcFrtRtAmt(String oiCalcFrtRtAmt) {
        this.oiCalcFrtRtAmt = oiCalcFrtRtAmt;
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
	 * @param propNo
	 */
    public void setPropNo(String propNo) {
        this.propNo = propNo;
    }

    /**
	 * Column Info
	 * @param daRapNoteConvTpCd
	 */
    public void setDaRapNoteConvTpCd(String daRapNoteConvTpCd) {
        this.daRapNoteConvTpCd = daRapNoteConvTpCd;
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
	 * @param rtAplyDt
	 */
    public void setRtAplyDt(String rtAplyDt) {
        this.rtAplyDt = rtAplyDt;
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
	 * @param chgCd
	 */
    public void setChgCd(String chgCd) {
        this.chgCd = chgCd;
    }

//    /**
//	 * Column Info
//	 * @param daRarCurrCd
//	 */
//    public void setDaRarCurrCd(String daRarCurrCd) {
//        this.daRarCurrCd = daRarCurrCd;
//    }

    /**
	 * Column Info
	 * @param dtl
	 */
    public void setDtl(String dtl) {
        this.dtl = dtl;
    }

//    /**
//	 * Column Info
//	 * @param daDorNoteConvSeq
//	 */
//    public void setDaDorNoteConvSeq(String daDorNoteConvSeq) {
//        this.daDorNoteConvSeq = daDorNoteConvSeq;
//    }

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
	 * @param diFnlFrtRtAmt
	 */
    public void setDiFnlFrtRtAmt(String diFnlFrtRtAmt) {
        this.diFnlFrtRtAmt = diFnlFrtRtAmt;
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
	 * @param oaDorFrtRtAmt
	 */
    public void setOaDorFrtRtAmt(String oaDorFrtRtAmt) {
        this.oaDorFrtRtAmt = oaDorFrtRtAmt;
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
	 * @param frtTermCd
	 */
    public void setFrtTermCd(String frtTermCd) {
        this.frtTermCd = frtTermCd;
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
	 * @param rtRapConvCtnt
	 */
    public void setRtRapConvCtnt(String rtRapConvCtnt) {
        this.rtRapConvCtnt = rtRapConvCtnt;
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
	 * @param rtAppCurrCd
	 */
    public void setRtAppCurrCd(String rtAppCurrCd) {
        this.rtAppCurrCd = rtAppCurrCd;
    }

//    /**
//	 * Column Info
//	 * @param rtRasNoteConvSeq
//	 */
//    public void setRtRasNoteConvSeq(String rtRasNoteConvSeq) {
//        this.rtRasNoteConvSeq = rtRasNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param daDirCallFlg
	 */
    public void setDaDirCallFlg(String daDirCallFlg) {
        this.daDirCallFlg = daDirCallFlg;
    }

    /**
	 * Column Info
	 * @param daRapFrtRtAmt
	 */
    public void setDaRapFrtRtAmt(String daRapFrtRtAmt) {
        this.daRapFrtRtAmt = daRapFrtRtAmt;
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

//    /**
//	 * Column Info
//	 * @param rtDorNoteConvSeq
//	 */
//    public void setRtDorNoteConvSeq(String rtDorNoteConvSeq) {
//        this.rtDorNoteConvSeq = rtDorNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param rtArbNoteConvTpCd
	 */
    public void setRtArbNoteConvTpCd(String rtArbNoteConvTpCd) {
        this.rtArbNoteConvTpCd = rtArbNoteConvTpCd;
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
	 * @param daDorNoteConvTpCd
	 */
    public void setDaDorNoteConvTpCd(String daDorNoteConvTpCd) {
        this.daDorNoteConvTpCd = daDorNoteConvTpCd;
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
	 * @param daPrcCmdtDefCd
	 */
    public void setDaPrcCmdtDefCd(String daPrcCmdtDefCd) {
        this.daPrcCmdtDefCd = daPrcCmdtDefCd;
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
	 * @param oaTypCurrCd
	 */
    public void setOaTypCurrCd(String oaTypCurrCd) {
        this.oaTypCurrCd = oaTypCurrCd;
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
	 * @param rtAddBkgConvTpCd
	 */
    public void setRtAddBkgConvTpCd(String rtAddBkgConvTpCd) {
        this.rtAddBkgConvTpCd = rtAddBkgConvTpCd;
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
	 * @param rtAppFrtRtAmt
	 */
    public void setRtAppFrtRtAmt(String rtAppFrtRtAmt) {
        this.rtAppFrtRtAmt = rtAppFrtRtAmt;
    }

    /**
	 * Column Info
	 * @param daCalcFrtRtAmt
	 */
    public void setDaCalcFrtRtAmt(String daCalcFrtRtAmt) {
        this.daCalcFrtRtAmt = daCalcFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @param oaRacNoteConvSeq
//	 */
//    public void setOaRacNoteConvSeq(String oaRacNoteConvSeq) {
//        this.oaRacNoteConvSeq = oaRacNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @param oaRarCurrCd
//	 */
//    public void setOaRarCurrCd(String oaRarCurrCd) {
//        this.oaRarCurrCd = oaRarCurrCd;
//    }

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
	 * @param cgoTpCd
	 */
    public void setCgoTpCd(String cgoTpCd) {
        this.cgoTpCd = cgoTpCd;
    }

    /**
	 * Column Info
	 * @param oaDorCurrCd
	 */
    public void setOaDorCurrCd(String oaDorCurrCd) {
        this.oaDorCurrCd = oaDorCurrCd;
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
	 * @param ratUtCd
	 */
    public void setRatUtCd(String ratUtCd) {
        this.ratUtCd = ratUtCd;
    }

    /**
	 * Column Info
	 * @param diCalcFrtRtAmt
	 */
    public void setDiCalcFrtRtAmt(String diCalcFrtRtAmt) {
        this.diCalcFrtRtAmt = diCalcFrtRtAmt;
    }

//    /**
//	 * Column Info
//	 * @param daRarNoteConvSeq
//	 */
//    public void setDaRarNoteConvSeq(String daRarNoteConvSeq) {
//        this.daRarNoteConvSeq = daRarNoteConvSeq;
//    }

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
	 * @param daViaPortDefCd
	 */
    public void setDaViaPortDefCd(String daViaPortDefCd) {
        this.daViaPortDefCd = daViaPortDefCd;
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
	 * @param opCntrQty
	 */
    public void setOpCntrQty(String opCntrQty) {
        this.opCntrQty = opCntrQty;
    }

    /**
	 * Column Info
	 * @param daRapBkgConvTpCd
	 */
    public void setDaRapBkgConvTpCd(String daRapBkgConvTpCd) {
        this.daRapBkgConvTpCd = daRapBkgConvTpCd;
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
	 * @param pctBseCd
	 */
    public void setPctBseCd(String pctBseCd) {
        this.pctBseCd = pctBseCd;
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
	 * @param rtRacNoteConvTpCd
	 */
    public void setRtRacNoteConvTpCd(String rtRacNoteConvTpCd) {
        this.rtRacNoteConvTpCd = rtRacNoteConvTpCd;
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
	 * @param rtRacConvCtnt
	 */
    public void setRtRacConvCtnt(String rtRacConvCtnt) {
        this.rtRacConvCtnt = rtRacConvCtnt;
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
	 * @param rtRasCurrCd
	 */
    public void setRtRasCurrCd(String rtRasCurrCd) {
        this.rtRasCurrCd = rtRasCurrCd;
    }

//    /**
//	 * Column Info
//	 * @param oaRarRtOpCd
//	 */
//    public void setOaRarRtOpCd(String oaRarRtOpCd) {
//        this.oaRarRtOpCd = oaRarRtOpCd;
//    }

    /**
	 * Column Info
	 * @param oaRapRtOpCd
	 */
    public void setOaRapRtOpCd(String oaRapRtOpCd) {
        this.oaRapRtOpCd = oaRapRtOpCd;
    }

    /**
	 * Column Info
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

//    /**
//	 * Column Info
//	 * @param rtArbNoteConvSeq
//	 */
//    public void setRtArbNoteConvSeq(String rtArbNoteConvSeq) {
//        this.rtArbNoteConvSeq = rtArbNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @param daRacNoteConvSeq
//	 */
//    public void setDaRacNoteConvSeq(String daRacNoteConvSeq) {
//        this.daRacNoteConvSeq = daRacNoteConvSeq;
//    }

//    /**
//	 * Column Info
//	 * @param rtTypNoteConvSeq
//	 */
//    public void setRtTypNoteConvSeq(String rtTypNoteConvSeq) {
//        this.rtTypNoteConvSeq = rtTypNoteConvSeq;
//    }

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

//    /**
//	 * Column Info
//	 * @param rtAddNoteConvSeq
//	 */
//    public void setRtAddNoteConvSeq(String rtAddNoteConvSeq) {
//        this.rtAddNoteConvSeq = rtAddNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param rtDorRtOpCd
	 */
    public void setRtDorRtOpCd(String rtDorRtOpCd) {
        this.rtDorRtOpCd = rtDorRtOpCd;
    }

//    /**
//	 * Column Info
//	 * @param rtRarNoteConvSeq
//	 */
//    public void setRtRarNoteConvSeq(String rtRarNoteConvSeq) {
//        this.rtRarNoteConvSeq = rtRarNoteConvSeq;
//    }

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
	 * @param rtArbCurrCd
	 */
    public void setRtArbCurrCd(String rtArbCurrCd) {
        this.rtArbCurrCd = rtArbCurrCd;
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
	 * @param prcHngrBarTpCd
	 */
    public void setPrcHngrBarTpCd(String prcHngrBarTpCd) {
        this.prcHngrBarTpCd = prcHngrBarTpCd;
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
	 * @param oiCurrCd
	 */
    public void setOiCurrCd(String oiCurrCd) {
        this.oiCurrCd = oiCurrCd;
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

//    /**
//	 * Column Info
//	 * @param rtRapNoteConvSeq
//	 */
//    public void setRtRapNoteConvSeq(String rtRapNoteConvSeq) {
//        this.rtRapNoteConvSeq = rtRapNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param orgTrspModCd
	 */
    public void setOrgTrspModCd(String orgTrspModCd) {
        this.orgTrspModCd = orgTrspModCd;
    }

    /**
	 * Column Info
	 * @param oaRapCurrCd
	 */
    public void setOaRapCurrCd(String oaRapCurrCd) {
        this.oaRapCurrCd = oaRapCurrCd;
    }

    /**
	 * Column Info
	 * @param daDorCurrCd
	 */
    public void setDaDorCurrCd(String daDorCurrCd) {
        this.daDorCurrCd = daDorCurrCd;
    }

    /**
	 * Column Info
	 * @param daDorBkgConvTpCd
	 */
    public void setDaDorBkgConvTpCd(String daDorBkgConvTpCd) {
        this.daDorBkgConvTpCd = daDorBkgConvTpCd;
    }

//    /**
//	 * Column Info
//	 * @param oaRarNoteConvSeq
//	 */
//    public void setOaRarNoteConvSeq(String oaRarNoteConvSeq) {
//        this.oaRarNoteConvSeq = oaRarNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param polCd
	 */
    public void setPolCd(String polCd) {
        this.polCd = polCd;
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
	 * @param oaDorBkgConvTpCd
	 */
    public void setOaDorBkgConvTpCd(String oaDorBkgConvTpCd) {
        this.oaDorBkgConvTpCd = oaDorBkgConvTpCd;
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

//    /**
//	 * Column Info
//	 * @param daRarDaOpCd
//	 */
//    public void setDaRarDaOpCd(String daRarDaOpCd) {
//        this.daRarDaOpCd = daRarDaOpCd;
//    }

    /**
	 * Column Info
	 * @param oaTypFrtRtAmt
	 */
    public void setOaTypFrtRtAmt(String oaTypFrtRtAmt) {
        this.oaTypFrtRtAmt = oaTypFrtRtAmt;
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
	 * @param dpRoutPntLocDefCd
	 */
    public void setDpRoutPntLocDefCd(String dpRoutPntLocDefCd) {
        this.dpRoutPntLocDefCd = dpRoutPntLocDefCd;
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
	 * @param triPropNo
	 */
    public void setTriPropNo(String triPropNo) {
        this.triPropNo = triPropNo;
    }

//    /**
//	 * Column Info
//	 * @param oaTypNoteConvSeq
//	 */
//    public void setOaTypNoteConvSeq(String oaTypNoteConvSeq) {
//        this.oaTypNoteConvSeq = oaTypNoteConvSeq;
//    }

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
	 * @param oaRapFrtRtAmt
	 */
    public void setOaRapFrtRtAmt(String oaRapFrtRtAmt) {
        this.oaRapFrtRtAmt = oaRapFrtRtAmt;
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
	 * @param dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
    }

//    /**
//	 * Column Info
//	 * @param oaDorNoteConvSeq
//	 */
//    public void setOaDorNoteConvSeq(String oaDorNoteConvSeq) {
//        this.oaDorNoteConvSeq = oaDorNoteConvSeq;
//    }

    /**
	 * Column Info
	 * @param daDorDaOpCd
	 */
    public void setDaDorDaOpCd(String daDorDaOpCd) {
        this.daDorDaOpCd = daDorDaOpCd;
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
	 * @param daDorFrtRtAmt
	 */
    public void setDaDorFrtRtAmt(String daDorFrtRtAmt) {
        this.daDorFrtRtAmt = daDorFrtRtAmt;
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
	 * @param oaRapNoteConvTpCd
	 */
    public void setOaRapNoteConvTpCd(String oaRapNoteConvTpCd) {
        this.oaRapNoteConvTpCd = oaRapNoteConvTpCd;
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
	 * @param oaDorRtOpCd
	 */
    public void setOaDorRtOpCd(String oaDorRtOpCd) {
        this.oaDorRtOpCd = oaDorRtOpCd;
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
	 * Column Info
	 * @param cmPrcCmdtDefCd
	 */
    public void setCmPrcCmdtDefCd(String cmPrcCmdtDefCd) {
        this.cmPrcCmdtDefCd = cmPrcCmdtDefCd;
    }

    /**
	 * Column Info
	 * @param cmdtSeq
	 */
    public void setCmdtSeq(String cmdtSeq) {
        this.cmdtSeq = cmdtSeq;
    }

    public void setAutoRatFlg(String autoRatFlg) {
        this.autoRatFlg = autoRatFlg;
    }

    public String getAutoRatFlg() {
        return this.autoRatFlg;
    }

    public void setPctlNo(String pctlNo) {
        this.pctlNo = pctlNo;
    }

    public String getPctlNo() {
        return this.pctlNo;
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
	 * @param bkgBqSeq
	 */
	public void setBkgBqSeq(String bkgBqSeq) {
		this.bkgBqSeq = bkgBqSeq;
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
	 * @param calcCtrtTpCd
	 */
	public void setCalcCtrtTpCd(String calcCtrtTpCd) {
		this.calcCtrtTpCd = calcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param prnHdnFlg
	 */
	public void setPrnHdnFlg(String prnHdnFlg) {
		this.prnHdnFlg = prnHdnFlg;
	}
	
	/**
	 * Column Info
	 * @param fxRtFlg
	 */
	public void setFxRtFlg(String fxRtFlg) {
		this.fxRtFlg = fxRtFlg;
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
	
	public String getOaMinCgoWgt() {
		return oaMinCgoWgt;
	}

	public void setOaMinCgoWgt(String oaMinCgoWgt) {
		this.oaMinCgoWgt = oaMinCgoWgt;
	}

	public String getOaMaxCgoWgt() {
		return oaMaxCgoWgt;
	}

	public void setOaMaxCgoWgt(String oaMaxCgoWgt) {
		this.oaMaxCgoWgt = oaMaxCgoWgt;
	}

	public String getDaMinCgoWgt() {
		return daMinCgoWgt;
	}

	public void setDaMinCgoWgt(String daMinCgoWgt) {
		this.daMinCgoWgt = daMinCgoWgt;
	}

	public String getDaMaxCgoWgt() {
		return daMaxCgoWgt;
	}

	public void setDaMaxCgoWgt(String daMaxCgoWgt) {
		this.daMaxCgoWgt = daMaxCgoWgt;
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

	public String getTaxFlg() {
		return taxFlg;
	}
	
	public void setTaxFlg(String taxFlg) {
		this.taxFlg = taxFlg;
	}

	public String getTaxCntCd() {
		return taxCntCd;
	}

	public void setTaxCntCd(String taxCntCd) {
		this.taxCntCd = taxCntCd;
	}

	/**
	 * @return the inclTaxFlg
	 */
	public String getInclTaxFlg() {
		return inclTaxFlg;
	}

	/**
	 * @param inclTaxFlg the inclTaxFlg to set
	 */
	public void setInclTaxFlg(String inclTaxFlg) {
		this.inclTaxFlg = inclTaxFlg;
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
	 * @return the n3ptyRcvOfcCd
	 */
	public String getN3ptyRcvOfcCd() {
		return n3ptyRcvOfcCd;
	}

	/**
	 * @param n3ptyRcvOfcCd the n3ptyRcvOfcCd to set
	 */
	public void setN3ptyRcvOfcCd(String n3ptyRcvOfcCd) {
		this.n3ptyRcvOfcCd = n3ptyRcvOfcCd;
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
        setOaTypBkgConvTpCd(JSPUtil.getParameter(request, prefix + "oa_typ_bkg_conv_tp_cd", ""));
        setOaRacConvCtnt(JSPUtil.getParameter(request, prefix + "oa_rac_conv_ctnt", ""));
        setOaPrcTrspModCd(JSPUtil.getParameter(request, prefix + "oa_prc_trsp_mod_cd", ""));
        setDiPrcTrspModCd(JSPUtil.getParameter(request, prefix + "di_prc_trsp_mod_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOaRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oa_rcv_de_term_cd", ""));
        setDaTypBkgConvTpCd(JSPUtil.getParameter(request, prefix + "da_typ_bkg_conv_tp_cd", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
//        setDaTypNoteConvSeq(JSPUtil.getParameter(request, prefix + "da_typ_note_conv_seq", ""));
        setOvRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "ov_rout_via_port_def_cd", ""));
//        setOaRarFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_rar_frt_rt_amt", ""));
//        setOaDorNoteConvTpCd(JSPUtil.getParameter(request, prefix + "oa_dor_note_conv_tp_cd", ""));
        setOaCurrCd(JSPUtil.getParameter(request, prefix + "oa_curr_cd", ""));
//        setOaRarBkgConvTpCd(JSPUtil.getParameter(request, prefix + "oa_rar_bkg_conv_tp_cd", ""));
        setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
        setDaFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_fnl_frt_rt_amt", ""));
        setRtRarBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_rar_bkg_conv_tp_cd", ""));
        setDaRacDaOpCd(JSPUtil.getParameter(request, prefix + "da_rac_da_op_cd", ""));
        setRtAppBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_app_bkg_conv_tp_cd", ""));
        setOaRapBkgConvTpCd(JSPUtil.getParameter(request, prefix + "oa_rap_bkg_conv_tp_cd", ""));
//        setOaRapNoteConvSeq(JSPUtil.getParameter(request, prefix + "oa_rap_note_conv_seq", ""));
        setOaRacFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_rac_frt_rt_amt", ""));
//        setDaRarFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_rar_frt_rt_amt", ""));
        setDiRcvDeTermCd(JSPUtil.getParameter(request, prefix + "di_rcv_de_term_cd", ""));
        setRtCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_calc_frt_rt_amt", ""));
        setOaTypRtOpCd(JSPUtil.getParameter(request, prefix + "oa_typ_rt_op_cd", ""));
        setDaRapCurrCd(JSPUtil.getParameter(request, prefix + "da_rap_curr_cd", ""));
        setOaRacBkgConvTpCd(JSPUtil.getParameter(request, prefix + "oa_rac_bkg_conv_tp_cd", ""));
        setRtRarCurrCd(JSPUtil.getParameter(request, prefix + "rt_rar_curr_cd", ""));
//        setDaRarBkgConvTpCd(JSPUtil.getParameter(request, prefix + "da_rar_bkg_conv_tp_cd", ""));
        setDiCurrCd(JSPUtil.getParameter(request, prefix + "di_curr_cd", ""));
//        setDaRapNoteConvSeq(JSPUtil.getParameter(request, prefix + "da_rap_note_conv_seq", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setRtRasBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_ras_bkg_conv_tp_cd", ""));
        setRtRapCurrCd(JSPUtil.getParameter(request, prefix + "rt_rap_curr_cd", ""));
        setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
        setOiRatUtCd(JSPUtil.getParameter(request, prefix + "oi_rat_ut_cd", ""));
        setRtRacCurrCd(JSPUtil.getParameter(request, prefix + "rt_rac_curr_cd", ""));
        setOaRacCurrCd(JSPUtil.getParameter(request, prefix + "oa_rac_curr_cd", ""));
        setDaTypDaOpCd(JSPUtil.getParameter(request, prefix + "da_typ_da_op_cd", ""));
        setRtDorNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_dor_note_conv_tp_cd", ""));
        setDaRacBkgConvTpCd(JSPUtil.getParameter(request, prefix + "da_rac_bkg_conv_tp_cd", ""));
        setOaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_calc_frt_rt_amt", ""));
//        setDaRarNoteConvTpCd(JSPUtil.getParameter(request, prefix + "da_rar_note_conv_tp_cd", ""));
        setDaRapDaOpCd(JSPUtil.getParameter(request, prefix + "da_rap_da_op_cd", ""));
//        setRtAppNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_seq", ""));
        setRtRasNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_tp_cd", ""));
        setRtRacFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_rac_frt_rt_amt", ""));
        setRtPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "rt_prc_cgo_tp_cd", ""));
        setRtAddRtOpCd(JSPUtil.getParameter(request, prefix + "rt_add_rt_op_cd", ""));
        setDiDirCallFlg(JSPUtil.getParameter(request, prefix + "di_dir_call_flg", ""));
        setRtDorConvCtnt(JSPUtil.getParameter(request, prefix + "rt_dor_conv_ctnt", ""));
        setDaTypConvCtnt(JSPUtil.getParameter(request, prefix + "da_typ_conv_ctnt", ""));
        setRtRapFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_rap_frt_rt_amt", ""));
//        setRtRacNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_rac_note_conv_seq", ""));
//        setOaRarNoteConvTpCd(JSPUtil.getParameter(request, prefix + "oa_rar_note_conv_tp_cd", ""));
        setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
        setDaRcvDeTermCd(JSPUtil.getParameter(request, prefix + "da_rcv_de_term_cd", ""));
        setDaTypFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_typ_frt_rt_amt", ""));
        setOiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_calc_frt_rt_amt", ""));
        setRtArbRtOpCd(JSPUtil.getParameter(request, prefix + "rt_arb_rt_op_cd", ""));
        setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
        setDaRapNoteConvTpCd(JSPUtil.getParameter(request, prefix + "da_rap_note_conv_tp_cd", ""));
        setRtRapBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_rap_bkg_conv_tp_cd", ""));
        setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
        setDiPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "di_prc_cgo_tp_cd", ""));
        setPorMtchFlg(JSPUtil.getParameter(request, prefix + "por_mtch_flg", ""));
        setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
//        setDaRarCurrCd(JSPUtil.getParameter(request, prefix + "da_rar_curr_cd", ""));
        setDtl(JSPUtil.getParameter(request, prefix + "dtl", ""));
//        setDaDorNoteConvSeq(JSPUtil.getParameter(request, prefix + "da_dor_note_conv_seq", ""));
        setDestTrspModCd(JSPUtil.getParameter(request, prefix + "dest_trsp_mod_cd", ""));
        setRtRasRtOpCd(JSPUtil.getParameter(request, prefix + "rt_ras_rt_op_cd", ""));
        setPrcGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "prc_gen_spcl_rt_tp_cd", ""));
        setRtRarNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_rar_note_conv_tp_cd", ""));
        setDiFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_fnl_frt_rt_amt", ""));
        setOiPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "oi_prc_cmdt_def_cd", ""));
        setOaDorFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_dor_frt_rt_amt", ""));
        setInGaFlg(JSPUtil.getParameter(request, prefix + "in_ga_flg", ""));
        setDelCntCd(JSPUtil.getParameter(request, prefix + "del_cnt_cd", ""));
        setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
        setOiPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "oi_prc_cgo_tp_cd", ""));
        setRtRapConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rap_conv_ctnt", ""));
        setDaPrcTrspModCd(JSPUtil.getParameter(request, prefix + "da_prc_trsp_mod_cd", ""));
        setRtRarRtOpCd(JSPUtil.getParameter(request, prefix + "rt_rar_rt_op_cd", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setRtAppCurrCd(JSPUtil.getParameter(request, prefix + "rt_app_curr_cd", ""));
//        setRtRasNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_seq", ""));
        setDaDirCallFlg(JSPUtil.getParameter(request, prefix + "da_dir_call_flg", ""));
        setDaRapFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_rap_frt_rt_amt", ""));
        setOaRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "oa_rout_pnt_loc_def_cd", ""));
        setRtTypFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_typ_frt_rt_amt", ""));
        setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setOaRatUtCd(JSPUtil.getParameter(request, prefix + "oa_rat_ut_cd", ""));
        setRtFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_fnl_frt_rt_amt", ""));
        setOaTypNoteConvTpCd(JSPUtil.getParameter(request, prefix + "oa_typ_note_conv_tp_cd", ""));
        setDvRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dv_rout_via_port_def_cd", ""));
//        setRtDorNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_dor_note_conv_seq", ""));
        setRtArbNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_arb_note_conv_tp_cd", ""));
        setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
        setRtTypConvCtnt(JSPUtil.getParameter(request, prefix + "rt_typ_conv_ctnt", ""));
        setDaBsePortDefCd(JSPUtil.getParameter(request, prefix + "da_bse_port_def_cd", ""));
        setDaRacFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_rac_frt_rt_amt", ""));
        setPrcRoutSeq(JSPUtil.getParameter(request, prefix + "prc_rout_seq", ""));
        setCtrtCntrTpszCd(JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd", ""));
        setOiPrcTrspModCd(JSPUtil.getParameter(request, prefix + "oi_prc_trsp_mod_cd", ""));
        setDelMtchFlg(JSPUtil.getParameter(request, prefix + "del_mtch_flg", ""));
        setOpRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "op_rout_pnt_loc_def_cd", ""));
        setDaDorNoteConvTpCd(JSPUtil.getParameter(request, prefix + "da_dor_note_conv_tp_cd", ""));
        setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setDaPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "da_prc_cmdt_def_cd", ""));
        setDaTypCurrCd(JSPUtil.getParameter(request, prefix + "da_typ_curr_cd", ""));
        setFrtInclXcldDivCd(JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setTrnsModCd(JSPUtil.getParameter(request, prefix + "trns_mod_cd", ""));
        setOaTypCurrCd(JSPUtil.getParameter(request, prefix + "oa_typ_curr_cd", ""));
        setFrtRtAmt(JSPUtil.getParameter(request, prefix + "frt_rt_amt", ""));
        setRtRatUtCd(JSPUtil.getParameter(request, prefix + "rt_rat_ut_cd", ""));
        setRtAddBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_add_bkg_conv_tp_cd", ""));
        setDaTypNoteConvTpCd(JSPUtil.getParameter(request, prefix + "da_typ_note_conv_tp_cd", ""));
        setRtAppFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_app_frt_rt_amt", ""));
        setDaCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_calc_frt_rt_amt", ""));
//        setOaRacNoteConvSeq(JSPUtil.getParameter(request, prefix + "oa_rac_note_conv_seq", ""));
//        setOaRarCurrCd(JSPUtil.getParameter(request, prefix + "oa_rar_curr_cd", ""));
        setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
        setRtDorFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_dor_frt_rt_amt", ""));
        setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
        setOaDorCurrCd(JSPUtil.getParameter(request, prefix + "oa_dor_curr_cd", ""));
        setRtRasConvCtnt(JSPUtil.getParameter(request, prefix + "rt_ras_conv_ctnt", ""));
        setOaPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "oa_prc_cgo_tp_cd", ""));
        setDaRacConvCtnt(JSPUtil.getParameter(request, prefix + "da_rac_conv_ctnt", ""));
        setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
        setOaPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "oa_prc_cmdt_def_cd", ""));
        setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
        setOiRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "oi_rout_pnt_loc_def_cd", ""));
        setOiDirCallFlg(JSPUtil.getParameter(request, prefix + "oi_dir_call_flg", ""));
        setDirCallFlg(JSPUtil.getParameter(request, prefix + "dir_call_flg", ""));
        setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
        setDiCalcFrtRtAmt(JSPUtil.getParameter(request, prefix + "di_calc_frt_rt_amt", ""));
//        setDaRarNoteConvSeq(JSPUtil.getParameter(request, prefix + "da_rar_note_conv_seq", ""));
        setOftCmbSeq(JSPUtil.getParameter(request, prefix + "oft_cmb_seq", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setDaViaPortDefCd(JSPUtil.getParameter(request, prefix + "da_via_port_def_cd", ""));
        setDiRatUtCd(JSPUtil.getParameter(request, prefix + "di_rat_ut_cd", ""));
        setOaFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_fnl_frt_rt_amt", ""));
        setDaRatUtCd(JSPUtil.getParameter(request, prefix + "da_rat_ut_cd", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setPrcRtSeq(JSPUtil.getParameter(request, prefix + "prc_rt_seq", ""));
        setRtRarFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_rar_frt_rt_amt", ""));
        setOaDirCallFlg(JSPUtil.getParameter(request, prefix + "oa_dir_call_flg", ""));
        setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
        setDaRapBkgConvTpCd(JSPUtil.getParameter(request, prefix + "da_rap_bkg_conv_tp_cd", ""));
        setRtArbFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_arb_frt_rt_amt", ""));
        setPctBseCd(JSPUtil.getParameter(request, prefix + "pct_bse_cd", ""));
        setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
        setRtRarConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rar_conv_ctnt", ""));
        setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
        setRtRacNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_rac_note_conv_tp_cd", ""));
        setRtDorCurrCd(JSPUtil.getParameter(request, prefix + "rt_dor_curr_cd", ""));
        setRtRacConvCtnt(JSPUtil.getParameter(request, prefix + "rt_rac_conv_ctnt", ""));
        setDaPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "da_prc_cgo_tp_cd", ""));
        setPrcCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "prc_cmdt_hdr_seq", ""));
        setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
        setRtRasCurrCd(JSPUtil.getParameter(request, prefix + "rt_ras_curr_cd", ""));
//        setOaRarRtOpCd(JSPUtil.getParameter(request, prefix + "oa_rar_rt_op_cd", ""));
        setOaRapRtOpCd(JSPUtil.getParameter(request, prefix + "oa_rap_rt_op_cd", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
//        setRtArbNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_arb_note_conv_seq", ""));
//        setDaRacNoteConvSeq(JSPUtil.getParameter(request, prefix + "da_rac_note_conv_seq", ""));
//        setRtTypNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_typ_note_conv_seq", ""));
        setNote(JSPUtil.getParameter(request, prefix + "note", ""));
        setRtAddNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_add_note_conv_tp_cd", ""));
        setRtTypCurrCd(JSPUtil.getParameter(request, prefix + "rt_typ_curr_cd", ""));
//        setRtAddNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_add_note_conv_seq", ""));
        setRtDorRtOpCd(JSPUtil.getParameter(request, prefix + "rt_dor_rt_op_cd", ""));
//        setRtRarNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_rar_note_conv_seq", ""));
        setInclOftFlg(JSPUtil.getParameter(request, prefix + "incl_oft_flg", ""));
        setOaTypConvCtnt(JSPUtil.getParameter(request, prefix + "oa_typ_conv_ctnt", ""));
        setRtArbCurrCd(JSPUtil.getParameter(request, prefix + "rt_arb_curr_cd", ""));
        setDaRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "da_rout_pnt_loc_def_cd", ""));
        setOaBsePortDefCd(JSPUtil.getParameter(request, prefix + "oa_bse_port_def_cd", ""));
        setPrcHngrBarTpCd(JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_cd", ""));
        setRtRacBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_rac_bkg_conv_tp_cd", ""));
        setOiCurrCd(JSPUtil.getParameter(request, prefix + "oi_curr_cd", ""));
        setOiFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "oi_fnl_frt_rt_amt", ""));
        setRtTypNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_typ_note_conv_tp_cd", ""));
        setDryCgoFlg(JSPUtil.getParameter(request, prefix + "dry_cgo_flg", ""));
        setRtAddFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_add_frt_rt_amt", ""));
        setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
//        setRtRapNoteConvSeq(JSPUtil.getParameter(request, prefix + "rt_rap_note_conv_seq", ""));
        setOrgTrspModCd(JSPUtil.getParameter(request, prefix + "org_trsp_mod_cd", ""));
        setOaRapCurrCd(JSPUtil.getParameter(request, prefix + "oa_rap_curr_cd", ""));
        setDaDorCurrCd(JSPUtil.getParameter(request, prefix + "da_dor_curr_cd", ""));
        setDaDorBkgConvTpCd(JSPUtil.getParameter(request, prefix + "da_dor_bkg_conv_tp_cd", ""));
//        setOaRarNoteConvSeq(JSPUtil.getParameter(request, prefix + "oa_rar_note_conv_seq", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setCgoCateCd(JSPUtil.getParameter(request, prefix + "cgo_cate_cd", ""));
        setRtAddCurrCd(JSPUtil.getParameter(request, prefix + "rt_add_curr_cd", ""));
        setOaRacNoteConvTpCd(JSPUtil.getParameter(request, prefix + "oa_rac_note_conv_tp_cd", ""));
        setRtMtchPattCd(JSPUtil.getParameter(request, prefix + "rt_mtch_patt_cd", ""));
        setOaDorBkgConvTpCd(JSPUtil.getParameter(request, prefix + "oa_dor_bkg_conv_tp_cd", ""));
        setDaCurrCd(JSPUtil.getParameter(request, prefix + "da_curr_cd", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setRtRacRtOpCd(JSPUtil.getParameter(request, prefix + "rt_rac_rt_op_cd", ""));
        setOaRacRtOpCd(JSPUtil.getParameter(request, prefix + "oa_rac_rt_op_cd", ""));
        setRtRapNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_rap_note_conv_tp_cd", ""));
        setDiRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "di_rout_pnt_loc_def_cd", ""));
//        setDaRarDaOpCd(JSPUtil.getParameter(request, prefix + "da_rar_da_op_cd", ""));
        setOaTypFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_typ_frt_rt_amt", ""));
        setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
        setDpRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dp_rout_pnt_loc_def_cd", ""));
        setRtTypRtOpCd(JSPUtil.getParameter(request, prefix + "rt_typ_rt_op_cd", ""));
        setOiRcvDeTermCd(JSPUtil.getParameter(request, prefix + "oi_rcv_de_term_cd", ""));
        setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
        setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
//        setOaTypNoteConvSeq(JSPUtil.getParameter(request, prefix + "oa_typ_note_conv_seq", ""));
        setRtRapRtOpCd(JSPUtil.getParameter(request, prefix + "rt_rap_rt_op_cd", ""));
        setDaRacCurrCd(JSPUtil.getParameter(request, prefix + "da_rac_curr_cd", ""));
        setOaRapFrtRtAmt(JSPUtil.getParameter(request, prefix + "oa_rap_frt_rt_amt", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setRtDorBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_dor_bkg_conv_tp_cd", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
//        setOaDorNoteConvSeq(JSPUtil.getParameter(request, prefix + "oa_dor_note_conv_seq", ""));
        setDaDorDaOpCd(JSPUtil.getParameter(request, prefix + "da_dor_da_op_cd", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPorCntCd(JSPUtil.getParameter(request, prefix + "por_cnt_cd", ""));
        setRtRasFrtRtAmt(JSPUtil.getParameter(request, prefix + "rt_ras_frt_rt_amt", ""));
        setDiBsePortDefCd(JSPUtil.getParameter(request, prefix + "di_bse_port_def_cd", ""));
        setDiPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "di_prc_cmdt_def_cd", ""));
        setRtAppNoteConvTpCd(JSPUtil.getParameter(request, prefix + "rt_app_note_conv_tp_cd", ""));
        setRtArbBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_arb_bkg_conv_tp_cd", ""));
        setDaDorFrtRtAmt(JSPUtil.getParameter(request, prefix + "da_dor_frt_rt_amt", ""));
        setOiBsePortDefCd(JSPUtil.getParameter(request, prefix + "oi_bse_port_def_cd", ""));
        setDaRacNoteConvTpCd(JSPUtil.getParameter(request, prefix + "da_rac_note_conv_tp_cd", ""));
        setOaRapNoteConvTpCd(JSPUtil.getParameter(request, prefix + "oa_rap_note_conv_tp_cd", ""));
        setEqSubstCntrTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", ""));
        setOiViaPortDefCd(JSPUtil.getParameter(request, prefix + "oi_via_port_def_cd", ""));
        setOaDorRtOpCd(JSPUtil.getParameter(request, prefix + "oa_dor_rt_op_cd", ""));
        setOaViaPortDefCd(JSPUtil.getParameter(request, prefix + "oa_via_port_def_cd", ""));
        setRtTypBkgConvTpCd(JSPUtil.getParameter(request, prefix + "rt_typ_bkg_conv_tp_cd", ""));
        setDiViaPortDefCd(JSPUtil.getParameter(request, prefix + "di_via_port_def_cd", ""));
        setRtAppRtOpCd(JSPUtil.getParameter(request, prefix + "rt_app_rt_op_cd", ""));
        setCmPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "cm_prc_cmdt_def_cd", ""));
        setCmdtSeq(JSPUtil.getParameter(request, prefix + "cmdt_seq", ""));
        setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
        setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
        setBqSeq(JSPUtil.getParameter(request, prefix + "bq_seq", ""));
		setBkgBqOccrSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_occr_seq", ""));
		setBkgBqSeq(JSPUtil.getParameter(request, prefix + "bkg_bq_seq", ""));
		setCalcCtrtTpCd(JSPUtil.getParameter(request, prefix + "calc_ctrt_tp_cd", ""));
		setPrnHdnFlg(JSPUtil.getParameter(request, prefix + "prn_hdn_flg", ""));
		setFxRtFlg(JSPUtil.getParameter(request, prefix + "fx_rt_flg", ""));
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
		setOaMinCgoWgt(JSPUtil.getParameter(request, prefix + "oa_min_cgo_wgt", ""));
		setOaMaxCgoWgt(JSPUtil.getParameter(request, prefix + "oa_max_cgo_wgt", ""));
		setDaMinCgoWgt(JSPUtil.getParameter(request, prefix + "da_min_cgo_wgt", ""));
		setDaMaxCgoWgt(JSPUtil.getParameter(request, prefix + "da_max_cgo_wgt", ""));
		setDiMinCgoWgt(JSPUtil.getParameter(request, prefix + "di_min_cgo_wgt", ""));
		setDiMaxCgoWgt(JSPUtil.getParameter(request, prefix + "di_max_cgo_wgt", ""));
		setTaxFlg(JSPUtil.getParameter(request, prefix + "tax_flg", ""));
		setTaxCntCd(JSPUtil.getParameter(request, prefix + "tax_cnt_cd", ""));
		setInclTaxFlg(JSPUtil.getParameter(request, prefix + "incl_tax_flg", ""));
		setOiFrtTermCd(JSPUtil.getParameter(request, prefix + "oi_frt_term_cd", ""));
		setOaFrtTermCd(JSPUtil.getParameter(request, prefix + "oa_frt_term_cd", ""));
		setDaFrtTermCd(JSPUtil.getParameter(request, prefix + "da_frt_term_cd", ""));
		setDiFrtTermCd(JSPUtil.getParameter(request, prefix + "di_frt_term_cd", ""));
		setN3ptyRcvOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_rcv_ofc_cd", ""));
    }
    
    

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScOftAutoratingListVO[]
	 */
    public SearchScOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScOftAutoratingListVO[]
	 */
    public SearchScOftAutoratingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchScOftAutoratingListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] oaTypBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_typ_bkg_conv_tp_cd", length));
            String[] oaRacConvCtnt = (JSPUtil.getParameter(request, prefix + "oa_rac_conv_ctnt", length));
            String[] oaPrcTrspModCd = (JSPUtil.getParameter(request, prefix + "oa_prc_trsp_mod_cd", length));
            String[] diPrcTrspModCd = (JSPUtil.getParameter(request, prefix + "di_prc_trsp_mod_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] oaRcvDeTermCd = (JSPUtil.getParameter(request, prefix + "oa_rcv_de_term_cd", length));
            String[] daTypBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "da_typ_bkg_conv_tp_cd", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
//            String[] daTypNoteConvSeq = (JSPUtil.getParameter(request, prefix + "da_typ_note_conv_seq", length));
            String[] ovRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix + "ov_rout_via_port_def_cd", length));
//            String[] oaRarFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_rar_frt_rt_amt", length));
//            String[] oaDorNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_dor_note_conv_tp_cd", length));
            String[] oaCurrCd = (JSPUtil.getParameter(request, prefix + "oa_curr_cd", length));
//            String[] oaRarBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_rar_bkg_conv_tp_cd", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
            String[] daFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_fnl_frt_rt_amt", length));
            String[] rtRarBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_rar_bkg_conv_tp_cd", length));
            String[] daRacDaOpCd = (JSPUtil.getParameter(request, prefix + "da_rac_da_op_cd", length));
            String[] rtAppBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_app_bkg_conv_tp_cd", length));
            String[] oaRapBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_rap_bkg_conv_tp_cd", length));
//            String[] oaRapNoteConvSeq = (JSPUtil.getParameter(request, prefix + "oa_rap_note_conv_seq", length));
            String[] oaRacFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_rac_frt_rt_amt", length));
//            String[] daRarFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_rar_frt_rt_amt", length));
            String[] diRcvDeTermCd = (JSPUtil.getParameter(request, prefix + "di_rcv_de_term_cd", length));
            String[] rtCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_calc_frt_rt_amt", length));
            String[] oaTypRtOpCd = (JSPUtil.getParameter(request, prefix + "oa_typ_rt_op_cd", length));
            String[] daRapCurrCd = (JSPUtil.getParameter(request, prefix + "da_rap_curr_cd", length));
            String[] oaRacBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_rac_bkg_conv_tp_cd", length));
            String[] rtRarCurrCd = (JSPUtil.getParameter(request, prefix + "rt_rar_curr_cd", length));
//            String[] daRarBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "da_rar_bkg_conv_tp_cd", length));
            String[] diCurrCd = (JSPUtil.getParameter(request, prefix + "di_curr_cd", length));
//            String[] daRapNoteConvSeq = (JSPUtil.getParameter(request, prefix + "da_rap_note_conv_seq", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] rtRasBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_ras_bkg_conv_tp_cd", length));
            String[] rtRapCurrCd = (JSPUtil.getParameter(request, prefix + "rt_rap_curr_cd", length));
            String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", length));
            String[] oiRatUtCd = (JSPUtil.getParameter(request, prefix + "oi_rat_ut_cd", length));
            String[] rtRacCurrCd = (JSPUtil.getParameter(request, prefix + "rt_rac_curr_cd", length));
            String[] oaRacCurrCd = (JSPUtil.getParameter(request, prefix + "oa_rac_curr_cd", length));
            String[] daTypDaOpCd = (JSPUtil.getParameter(request, prefix + "da_typ_da_op_cd", length));
            String[] rtDorNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_dor_note_conv_tp_cd", length));
            String[] daRacBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "da_rac_bkg_conv_tp_cd", length));
            String[] oaCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_calc_frt_rt_amt", length));
//            String[] daRarNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "da_rar_note_conv_tp_cd", length));
            String[] daRapDaOpCd = (JSPUtil.getParameter(request, prefix + "da_rap_da_op_cd", length));
//            String[] rtAppNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_app_note_conv_seq", length));
            String[] rtRasNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_tp_cd", length));
            String[] rtRacFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_rac_frt_rt_amt", length));
            String[] rtPrcCgoTpCd = (JSPUtil.getParameter(request, prefix + "rt_prc_cgo_tp_cd", length));
            String[] rtAddRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_add_rt_op_cd", length));
            String[] diDirCallFlg = (JSPUtil.getParameter(request, prefix + "di_dir_call_flg", length));
            String[] rtDorConvCtnt = (JSPUtil.getParameter(request, prefix + "rt_dor_conv_ctnt", length));
            String[] daTypConvCtnt = (JSPUtil.getParameter(request, prefix + "da_typ_conv_ctnt", length));
            String[] rtRapFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_rap_frt_rt_amt", length));
//            String[] rtRacNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_rac_note_conv_seq", length));
//            String[] oaRarNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_rar_note_conv_tp_cd", length));
            String[] cnt = (JSPUtil.getParameter(request, prefix + "cnt", length));
            String[] daRcvDeTermCd = (JSPUtil.getParameter(request, prefix + "da_rcv_de_term_cd", length));
            String[] daTypFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_typ_frt_rt_amt", length));
            String[] oiCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oi_calc_frt_rt_amt", length));
            String[] rtArbRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_arb_rt_op_cd", length));
            String[] propNo = (JSPUtil.getParameter(request, prefix + "prop_no", length));
            String[] daRapNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "da_rap_note_conv_tp_cd", length));
            String[] rtRapBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_rap_bkg_conv_tp_cd", length));
            String[] rtAplyDt = (JSPUtil.getParameter(request, prefix + "rt_aply_dt", length));
            String[] diPrcCgoTpCd = (JSPUtil.getParameter(request, prefix + "di_prc_cgo_tp_cd", length));
            String[] porMtchFlg = (JSPUtil.getParameter(request, prefix + "por_mtch_flg", length));
            String[] chgCd = (JSPUtil.getParameter(request, prefix + "chg_cd", length));
//            String[] daRarCurrCd = (JSPUtil.getParameter(request, prefix + "da_rar_curr_cd", length));
            String[] dtl = (JSPUtil.getParameter(request, prefix + "dtl", length));
//            String[] daDorNoteConvSeq = (JSPUtil.getParameter(request, prefix + "da_dor_note_conv_seq", length));
            String[] destTrspModCd = (JSPUtil.getParameter(request, prefix + "dest_trsp_mod_cd", length));
            String[] rtRasRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_ras_rt_op_cd", length));
            String[] prcGenSpclRtTpCd = (JSPUtil.getParameter(request, prefix + "prc_gen_spcl_rt_tp_cd", length));
            String[] rtRarNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_rar_note_conv_tp_cd", length));
            String[] diFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix + "di_fnl_frt_rt_amt", length));
            String[] oiPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "oi_prc_cmdt_def_cd", length));
            String[] oaDorFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_dor_frt_rt_amt", length));
            String[] inGaFlg = (JSPUtil.getParameter(request, prefix + "in_ga_flg", length));
            String[] delCntCd = (JSPUtil.getParameter(request, prefix + "del_cnt_cd", length));
            String[] frtTermCd = (JSPUtil.getParameter(request, prefix + "frt_term_cd", length));
            String[] oiPrcCgoTpCd = (JSPUtil.getParameter(request, prefix + "oi_prc_cgo_tp_cd", length));
            String[] rtRapConvCtnt = (JSPUtil.getParameter(request, prefix + "rt_rap_conv_ctnt", length));
            String[] daPrcTrspModCd = (JSPUtil.getParameter(request, prefix + "da_prc_trsp_mod_cd", length));
            String[] rtRarRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_rar_rt_op_cd", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] rtAppCurrCd = (JSPUtil.getParameter(request, prefix + "rt_app_curr_cd", length));
//            String[] rtRasNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_ras_note_conv_seq", length));
            String[] daDirCallFlg = (JSPUtil.getParameter(request, prefix + "da_dir_call_flg", length));
            String[] daRapFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_rap_frt_rt_amt", length));
            String[] oaRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "oa_rout_pnt_loc_def_cd", length));
            String[] rtTypFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_typ_frt_rt_amt", length));
            String[] noteCtnt = (JSPUtil.getParameter(request, prefix + "note_ctnt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] oaRatUtCd = (JSPUtil.getParameter(request, prefix + "oa_rat_ut_cd", length));
            String[] rtFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_fnl_frt_rt_amt", length));
            String[] oaTypNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_typ_note_conv_tp_cd", length));
            String[] dvRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix + "dv_rout_via_port_def_cd", length));
//            String[] rtDorNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_dor_note_conv_seq", length));
            String[] rtArbNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_arb_note_conv_tp_cd", length));
            String[] chgUtAmt = (JSPUtil.getParameter(request, prefix + "chg_ut_amt", length));
            String[] rtTypConvCtnt = (JSPUtil.getParameter(request, prefix + "rt_typ_conv_ctnt", length));
            String[] daBsePortDefCd = (JSPUtil.getParameter(request, prefix + "da_bse_port_def_cd", length));
            String[] daRacFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_rac_frt_rt_amt", length));
            String[] prcRoutSeq = (JSPUtil.getParameter(request, prefix + "prc_rout_seq", length));
            String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd", length));
            String[] oiPrcTrspModCd = (JSPUtil.getParameter(request, prefix + "oi_prc_trsp_mod_cd", length));
            String[] delMtchFlg = (JSPUtil.getParameter(request, prefix + "del_mtch_flg", length));
            String[] opRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "op_rout_pnt_loc_def_cd", length));
            String[] daDorNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "da_dor_note_conv_tp_cd", length));
            String[] cmdtNm = (JSPUtil.getParameter(request, prefix + "cmdt_nm", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] daPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "da_prc_cmdt_def_cd", length));
            String[] daTypCurrCd = (JSPUtil.getParameter(request, prefix + "da_typ_curr_cd", length));
            String[] frtInclXcldDivCd = (JSPUtil.getParameter(request, prefix + "frt_incl_xcld_div_cd", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] trnsModCd = (JSPUtil.getParameter(request, prefix + "trns_mod_cd", length));
            String[] oaTypCurrCd = (JSPUtil.getParameter(request, prefix + "oa_typ_curr_cd", length));
            String[] frtRtAmt = (JSPUtil.getParameter(request, prefix + "frt_rt_amt", length));
            String[] rtRatUtCd = (JSPUtil.getParameter(request, prefix + "rt_rat_ut_cd", length));
            String[] rtAddBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_add_bkg_conv_tp_cd", length));
            String[] daTypNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "da_typ_note_conv_tp_cd", length));
            String[] rtAppFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_app_frt_rt_amt", length));
            String[] daCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_calc_frt_rt_amt", length));
//            String[] oaRacNoteConvSeq = (JSPUtil.getParameter(request, prefix + "oa_rac_note_conv_seq", length));
//            String[] oaRarCurrCd = (JSPUtil.getParameter(request, prefix + "oa_rar_curr_cd", length));
            String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
            String[] rtDorFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_dor_frt_rt_amt", length));
            String[] cgoTpCd = (JSPUtil.getParameter(request, prefix + "cgo_tp_cd", length));
            String[] oaDorCurrCd = (JSPUtil.getParameter(request, prefix + "oa_dor_curr_cd", length));
            String[] rtRasConvCtnt = (JSPUtil.getParameter(request, prefix + "rt_ras_conv_ctnt", length));
            String[] oaPrcCgoTpCd = (JSPUtil.getParameter(request, prefix + "oa_prc_cgo_tp_cd", length));
            String[] daRacConvCtnt = (JSPUtil.getParameter(request, prefix + "da_rac_conv_ctnt", length));
            String[] chgAmt = (JSPUtil.getParameter(request, prefix + "chg_amt", length));
            String[] oaPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "oa_prc_cmdt_def_cd", length));
            String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", length));
            String[] oiRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "oi_rout_pnt_loc_def_cd", length));
            String[] oiDirCallFlg = (JSPUtil.getParameter(request, prefix + "oi_dir_call_flg", length));
            String[] dirCallFlg = (JSPUtil.getParameter(request, prefix + "dir_call_flg", length));
            String[] ratUtCd = (JSPUtil.getParameter(request, prefix + "rat_ut_cd", length));
            String[] diCalcFrtRtAmt = (JSPUtil.getParameter(request, prefix + "di_calc_frt_rt_amt", length));
//            String[] daRarNoteConvSeq = (JSPUtil.getParameter(request, prefix + "da_rar_note_conv_seq", length));
            String[] oftCmbSeq = (JSPUtil.getParameter(request, prefix + "oft_cmb_seq", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] daViaPortDefCd = (JSPUtil.getParameter(request, prefix + "da_via_port_def_cd", length));
            String[] diRatUtCd = (JSPUtil.getParameter(request, prefix + "di_rat_ut_cd", length));
            String[] oaFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_fnl_frt_rt_amt", length));
            String[] daRatUtCd = (JSPUtil.getParameter(request, prefix + "da_rat_ut_cd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] prcRtSeq = (JSPUtil.getParameter(request, prefix + "prc_rt_seq", length));
            String[] rtRarFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_rar_frt_rt_amt", length));
            String[] oaDirCallFlg = (JSPUtil.getParameter(request, prefix + "oa_dir_call_flg", length));
            String[] opCntrQty = (JSPUtil.getParameter(request, prefix + "op_cntr_qty", length));
            String[] daRapBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "da_rap_bkg_conv_tp_cd", length));
            String[] rtArbFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_arb_frt_rt_amt", length));
            String[] pctBseCd = (JSPUtil.getParameter(request, prefix + "pct_bse_cd", length));
            String[] imdgClssCd = (JSPUtil.getParameter(request, prefix + "imdg_clss_cd", length));
            String[] rtRarConvCtnt = (JSPUtil.getParameter(request, prefix + "rt_rar_conv_ctnt", length));
            String[] dpSeq = (JSPUtil.getParameter(request, prefix + "dp_seq", length));
            String[] rtRacNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_rac_note_conv_tp_cd", length));
            String[] rtDorCurrCd = (JSPUtil.getParameter(request, prefix + "rt_dor_curr_cd", length));
            String[] rtRacConvCtnt = (JSPUtil.getParameter(request, prefix + "rt_rac_conv_ctnt", length));
            String[] daPrcCgoTpCd = (JSPUtil.getParameter(request, prefix + "da_prc_cgo_tp_cd", length));
            String[] prcCmdtHdrSeq = (JSPUtil.getParameter(request, prefix + "prc_cmdt_hdr_seq", length));
            String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", length));
            String[] rtRasCurrCd = (JSPUtil.getParameter(request, prefix + "rt_ras_curr_cd", length));
//            String[] oaRarRtOpCd = (JSPUtil.getParameter(request, prefix + "oa_rar_rt_op_cd", length));
            String[] oaRapRtOpCd = (JSPUtil.getParameter(request, prefix + "oa_rap_rt_op_cd", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
//            String[] rtArbNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_arb_note_conv_seq", length));
//            String[] daRacNoteConvSeq = (JSPUtil.getParameter(request, prefix + "da_rac_note_conv_seq", length));
//            String[] rtTypNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_typ_note_conv_seq", length));
            String[] note = (JSPUtil.getParameter(request, prefix + "note", length));
            String[] rtAddNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_add_note_conv_tp_cd", length));
            String[] rtTypCurrCd = (JSPUtil.getParameter(request, prefix + "rt_typ_curr_cd", length));
//            String[] rtAddNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_add_note_conv_seq", length));
            String[] rtDorRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_dor_rt_op_cd", length));
//            String[] rtRarNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_rar_note_conv_seq", length));
            String[] inclOftFlg = (JSPUtil.getParameter(request, prefix + "incl_oft_flg", length));
            String[] oaTypConvCtnt = (JSPUtil.getParameter(request, prefix + "oa_typ_conv_ctnt", length));
            String[] rtArbCurrCd = (JSPUtil.getParameter(request, prefix + "rt_arb_curr_cd", length));
            String[] daRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "da_rout_pnt_loc_def_cd", length));
            String[] oaBsePortDefCd = (JSPUtil.getParameter(request, prefix + "oa_bse_port_def_cd", length));
            String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_cd", length));
            String[] rtRacBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_rac_bkg_conv_tp_cd", length));
            String[] oiCurrCd = (JSPUtil.getParameter(request, prefix + "oi_curr_cd", length));
            String[] oiFnlFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oi_fnl_frt_rt_amt", length));
            String[] rtTypNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_typ_note_conv_tp_cd", length));
            String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix + "dry_cgo_flg", length));
            String[] rtAddFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_add_frt_rt_amt", length));
            String[] amdtSeq = (JSPUtil.getParameter(request, prefix + "amdt_seq", length));
//            String[] rtRapNoteConvSeq = (JSPUtil.getParameter(request, prefix + "rt_rap_note_conv_seq", length));
            String[] orgTrspModCd = (JSPUtil.getParameter(request, prefix + "org_trsp_mod_cd", length));
            String[] oaRapCurrCd = (JSPUtil.getParameter(request, prefix + "oa_rap_curr_cd", length));
            String[] daDorCurrCd = (JSPUtil.getParameter(request, prefix + "da_dor_curr_cd", length));
            String[] daDorBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "da_dor_bkg_conv_tp_cd", length));
//            String[] oaRarNoteConvSeq = (JSPUtil.getParameter(request, prefix + "oa_rar_note_conv_seq", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] cgoCateCd = (JSPUtil.getParameter(request, prefix + "cgo_cate_cd", length));
            String[] rtAddCurrCd = (JSPUtil.getParameter(request, prefix + "rt_add_curr_cd", length));
            String[] oaRacNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_rac_note_conv_tp_cd", length));
            String[] rtMtchPattCd = (JSPUtil.getParameter(request, prefix + "rt_mtch_patt_cd", length));
            String[] oaDorBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_dor_bkg_conv_tp_cd", length));
            String[] daCurrCd = (JSPUtil.getParameter(request, prefix + "da_curr_cd", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] rtRacRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_rac_rt_op_cd", length));
            String[] oaRacRtOpCd = (JSPUtil.getParameter(request, prefix + "oa_rac_rt_op_cd", length));
            String[] rtRapNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_rap_note_conv_tp_cd", length));
            String[] diRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "di_rout_pnt_loc_def_cd", length));
//            String[] daRarDaOpCd = (JSPUtil.getParameter(request, prefix + "da_rar_da_op_cd", length));
            String[] oaTypFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_typ_frt_rt_amt", length));
            String[] ratAsQty = (JSPUtil.getParameter(request, prefix + "rat_as_qty", length));
            String[] dpRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "dp_rout_pnt_loc_def_cd", length));
            String[] rtTypRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_typ_rt_op_cd", length));
            String[] oiRcvDeTermCd = (JSPUtil.getParameter(request, prefix + "oi_rcv_de_term_cd", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
            String[] triPropNo = (JSPUtil.getParameter(request, prefix + "tri_prop_no", length));
//            String[] oaTypNoteConvSeq = (JSPUtil.getParameter(request, prefix + "oa_typ_note_conv_seq", length));
            String[] rtRapRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_rap_rt_op_cd", length));
            String[] daRacCurrCd = (JSPUtil.getParameter(request, prefix + "da_rac_curr_cd", length));
            String[] oaRapFrtRtAmt = (JSPUtil.getParameter(request, prefix + "oa_rap_frt_rt_amt", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] rtDorBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_dor_bkg_conv_tp_cd", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
//            String[] oaDorNoteConvSeq = (JSPUtil.getParameter(request, prefix + "oa_dor_note_conv_seq", length));
            String[] daDorDaOpCd = (JSPUtil.getParameter(request, prefix + "da_dor_da_op_cd", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] porCntCd = (JSPUtil.getParameter(request, prefix + "por_cnt_cd", length));
            String[] rtRasFrtRtAmt = (JSPUtil.getParameter(request, prefix + "rt_ras_frt_rt_amt", length));
            String[] diBsePortDefCd = (JSPUtil.getParameter(request, prefix + "di_bse_port_def_cd", length));
            String[] diPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "di_prc_cmdt_def_cd", length));
            String[] rtAppNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_app_note_conv_tp_cd", length));
            String[] rtArbBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_arb_bkg_conv_tp_cd", length));
            String[] daDorFrtRtAmt = (JSPUtil.getParameter(request, prefix + "da_dor_frt_rt_amt", length));
            String[] oiBsePortDefCd = (JSPUtil.getParameter(request, prefix + "oi_bse_port_def_cd", length));
            String[] daRacNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "da_rac_note_conv_tp_cd", length));
            String[] oaRapNoteConvTpCd = (JSPUtil.getParameter(request, prefix + "oa_rap_note_conv_tp_cd", length));
            String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix + "eq_subst_cntr_tpsz_cd", length));
            String[] oiViaPortDefCd = (JSPUtil.getParameter(request, prefix + "oi_via_port_def_cd", length));
            String[] oaDorRtOpCd = (JSPUtil.getParameter(request, prefix + "oa_dor_rt_op_cd", length));
            String[] oaViaPortDefCd = (JSPUtil.getParameter(request, prefix + "oa_via_port_def_cd", length));
            String[] rtTypBkgConvTpCd = (JSPUtil.getParameter(request, prefix + "rt_typ_bkg_conv_tp_cd", length));
            String[] diViaPortDefCd = (JSPUtil.getParameter(request, prefix + "di_via_port_def_cd", length));
            String[] rtAppRtOpCd = (JSPUtil.getParameter(request, prefix + "rt_app_rt_op_cd", length));
            String[] cmPrcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "cm_prc_cmdt_def_cd", length));
            String[] cmdtSeq = (JSPUtil.getParameter(request, prefix + "cmdt_seq", length));
            String[] autoRatFlg = (JSPUtil.getParameter(request, prefix + "auto_rat_flg", length));
			String[] bqSeq = (JSPUtil.getParameter(request, prefix	+ "bq_seq", length));
			String[] bkgBqSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_seq", length));
			String[] bkgBqOccrSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_bq_occr_seq", length));
			String[] calcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_ctrt_tp_cd", length));
			String[] prnHdnFlg = (JSPUtil.getParameter(request, prefix	+ "prn_hdn_flg", length));
			String[] fxRtFlg = (JSPUtil.getParameter(request, prefix	+ "fx_rt_flg", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
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
			String[] oaMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oa_min_cgo_wgt", length));
			String[] oaMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "oa_max_cgo_wgt", length));
			String[] daMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "da_min_cgo_wgt", length));
			String[] daMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "da_max_cgo_wgt", length));
			String[] diMinCgoWgt = (JSPUtil.getParameter(request, prefix	+ "di_min_cgo_wgt", length));
			String[] diMaxCgoWgt = (JSPUtil.getParameter(request, prefix	+ "di_max_cgo_wgt", length));
			String[] taxFlg = (JSPUtil.getParameter(request, prefix	+ "tax_flg", length));
			String[] taxCntCd = (JSPUtil.getParameter(request, prefix + "tax_cnt_cd", length));
			String[] inclTaxFlg = (JSPUtil.getParameter(request, prefix	+ "incl_tax_flg", length));
			String[] oiFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "oi_frt_term_cd", length));
			String[] oaFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "oa_frt_term_cd", length));
			String[] daFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "da_frt_term_cd", length));
			String[] diFrtTermCd = (JSPUtil.getParameter(request, prefix	+ "di_frt_term_cd", length));
			String[] n3ptyRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_rcv_ofc_cd", length));

			for (int i = 0; i < length; i++) {
                model = new SearchScOftAutoratingListVO();
                if (oaTypBkgConvTpCd[i] != null)
                    model.setOaTypBkgConvTpCd(oaTypBkgConvTpCd[i]);
                if (oaRacConvCtnt[i] != null)
                    model.setOaRacConvCtnt(oaRacConvCtnt[i]);
                if (oaPrcTrspModCd[i] != null)
                    model.setOaPrcTrspModCd(oaPrcTrspModCd[i]);
                if (diPrcTrspModCd[i] != null)
                    model.setDiPrcTrspModCd(diPrcTrspModCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (oaRcvDeTermCd[i] != null)
                    model.setOaRcvDeTermCd(oaRcvDeTermCd[i]);
                if (daTypBkgConvTpCd[i] != null)
                    model.setDaTypBkgConvTpCd(daTypBkgConvTpCd[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
//                if (daTypNoteConvSeq[i] != null)
//                    model.setDaTypNoteConvSeq(daTypNoteConvSeq[i]);
                if (ovRoutViaPortDefCd[i] != null)
                    model.setOvRoutViaPortDefCd(ovRoutViaPortDefCd[i]);
//                if (oaRarFrtRtAmt[i] != null)
//                    model.setOaRarFrtRtAmt(oaRarFrtRtAmt[i]);
//                if (oaDorNoteConvTpCd[i] != null)
//                    model.setOaDorNoteConvTpCd(oaDorNoteConvTpCd[i]);
                if (oaCurrCd[i] != null)
                    model.setOaCurrCd(oaCurrCd[i]);
//                if (oaRarBkgConvTpCd[i] != null)
//                    model.setOaRarBkgConvTpCd(oaRarBkgConvTpCd[i]);
                if (cntrWgt[i] != null)
                    model.setCntrWgt(cntrWgt[i]);
                if (daFnlFrtRtAmt[i] != null)
                    model.setDaFnlFrtRtAmt(daFnlFrtRtAmt[i]);
                if (rtRarBkgConvTpCd[i] != null)
                    model.setRtRarBkgConvTpCd(rtRarBkgConvTpCd[i]);
                if (daRacDaOpCd[i] != null)
                    model.setDaRacDaOpCd(daRacDaOpCd[i]);
                if (rtAppBkgConvTpCd[i] != null)
                    model.setRtAppBkgConvTpCd(rtAppBkgConvTpCd[i]);
                if (oaRapBkgConvTpCd[i] != null)
                    model.setOaRapBkgConvTpCd(oaRapBkgConvTpCd[i]);
//                if (oaRapNoteConvSeq[i] != null)
//                    model.setOaRapNoteConvSeq(oaRapNoteConvSeq[i]);
                if (oaRacFrtRtAmt[i] != null)
                    model.setOaRacFrtRtAmt(oaRacFrtRtAmt[i]);
//                if (daRarFrtRtAmt[i] != null)
//                    model.setDaRarFrtRtAmt(daRarFrtRtAmt[i]);
                if (diRcvDeTermCd[i] != null)
                    model.setDiRcvDeTermCd(diRcvDeTermCd[i]);
                if (rtCalcFrtRtAmt[i] != null)
                    model.setRtCalcFrtRtAmt(rtCalcFrtRtAmt[i]);
                if (oaTypRtOpCd[i] != null)
                    model.setOaTypRtOpCd(oaTypRtOpCd[i]);
                if (daRapCurrCd[i] != null)
                    model.setDaRapCurrCd(daRapCurrCd[i]);
                if (oaRacBkgConvTpCd[i] != null)
                    model.setOaRacBkgConvTpCd(oaRacBkgConvTpCd[i]);
                if (rtRarCurrCd[i] != null)
                    model.setRtRarCurrCd(rtRarCurrCd[i]);
//                if (daRarBkgConvTpCd[i] != null)
//                    model.setDaRarBkgConvTpCd(daRarBkgConvTpCd[i]);
                if (diCurrCd[i] != null)
                    model.setDiCurrCd(diCurrCd[i]);
//                if (daRapNoteConvSeq[i] != null)
//                    model.setDaRapNoteConvSeq(daRapNoteConvSeq[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
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
                if (oaCalcFrtRtAmt[i] != null)
                    model.setOaCalcFrtRtAmt(oaCalcFrtRtAmt[i]);
//                if (daRarNoteConvTpCd[i] != null)
//                    model.setDaRarNoteConvTpCd(daRarNoteConvTpCd[i]);
                if (daRapDaOpCd[i] != null)
                    model.setDaRapDaOpCd(daRapDaOpCd[i]);
//                if (rtAppNoteConvSeq[i] != null)
//                    model.setRtAppNoteConvSeq(rtAppNoteConvSeq[i]);
                if (rtRasNoteConvTpCd[i] != null)
                    model.setRtRasNoteConvTpCd(rtRasNoteConvTpCd[i]);
                if (rtRacFrtRtAmt[i] != null)
                    model.setRtRacFrtRtAmt(rtRacFrtRtAmt[i]);
                if (rtPrcCgoTpCd[i] != null)
                    model.setRtPrcCgoTpCd(rtPrcCgoTpCd[i]);
                if (rtAddRtOpCd[i] != null)
                    model.setRtAddRtOpCd(rtAddRtOpCd[i]);
                if (diDirCallFlg[i] != null)
                    model.setDiDirCallFlg(diDirCallFlg[i]);
                if (rtDorConvCtnt[i] != null)
                    model.setRtDorConvCtnt(rtDorConvCtnt[i]);
                if (daTypConvCtnt[i] != null)
                    model.setDaTypConvCtnt(daTypConvCtnt[i]);
                if (rtRapFrtRtAmt[i] != null)
                    model.setRtRapFrtRtAmt(rtRapFrtRtAmt[i]);
//                if (rtRacNoteConvSeq[i] != null)
//                    model.setRtRacNoteConvSeq(rtRacNoteConvSeq[i]);
//                if (oaRarNoteConvTpCd[i] != null)
//                    model.setOaRarNoteConvTpCd(oaRarNoteConvTpCd[i]);
                if (cnt[i] != null)
                    model.setCnt(cnt[i]);
                if (daRcvDeTermCd[i] != null)
                    model.setDaRcvDeTermCd(daRcvDeTermCd[i]);
                if (daTypFrtRtAmt[i] != null)
                    model.setDaTypFrtRtAmt(daTypFrtRtAmt[i]);
                if (oiCalcFrtRtAmt[i] != null)
                    model.setOiCalcFrtRtAmt(oiCalcFrtRtAmt[i]);
                if (rtArbRtOpCd[i] != null)
                    model.setRtArbRtOpCd(rtArbRtOpCd[i]);
                if (propNo[i] != null)
                    model.setPropNo(propNo[i]);
                if (daRapNoteConvTpCd[i] != null)
                    model.setDaRapNoteConvTpCd(daRapNoteConvTpCd[i]);
                if (rtRapBkgConvTpCd[i] != null)
                    model.setRtRapBkgConvTpCd(rtRapBkgConvTpCd[i]);
                if (rtAplyDt[i] != null)
                    model.setRtAplyDt(rtAplyDt[i]);
                if (diPrcCgoTpCd[i] != null)
                    model.setDiPrcCgoTpCd(diPrcCgoTpCd[i]);
                if (porMtchFlg[i] != null)
                    model.setPorMtchFlg(porMtchFlg[i]);
                if (chgCd[i] != null)
                    model.setChgCd(chgCd[i]);
//                if (daRarCurrCd[i] != null)
//                    model.setDaRarCurrCd(daRarCurrCd[i]);
                if (dtl[i] != null)
                    model.setDtl(dtl[i]);
//                if (daDorNoteConvSeq[i] != null)
//                    model.setDaDorNoteConvSeq(daDorNoteConvSeq[i]);
                if (destTrspModCd[i] != null)
                    model.setDestTrspModCd(destTrspModCd[i]);
                if (rtRasRtOpCd[i] != null)
                    model.setRtRasRtOpCd(rtRasRtOpCd[i]);
                if (prcGenSpclRtTpCd[i] != null)
                    model.setPrcGenSpclRtTpCd(prcGenSpclRtTpCd[i]);
                if (rtRarNoteConvTpCd[i] != null)
                    model.setRtRarNoteConvTpCd(rtRarNoteConvTpCd[i]);
                if (diFnlFrtRtAmt[i] != null)
                    model.setDiFnlFrtRtAmt(diFnlFrtRtAmt[i]);
                if (oiPrcCmdtDefCd[i] != null)
                    model.setOiPrcCmdtDefCd(oiPrcCmdtDefCd[i]);
                if (oaDorFrtRtAmt[i] != null)
                    model.setOaDorFrtRtAmt(oaDorFrtRtAmt[i]);
                if (inGaFlg[i] != null)
                    model.setInGaFlg(inGaFlg[i]);
                if (delCntCd[i] != null)
                    model.setDelCntCd(delCntCd[i]);
                if (frtTermCd[i] != null)
                    model.setFrtTermCd(frtTermCd[i]);
                if (oiPrcCgoTpCd[i] != null)
                    model.setOiPrcCgoTpCd(oiPrcCgoTpCd[i]);
                if (rtRapConvCtnt[i] != null)
                    model.setRtRapConvCtnt(rtRapConvCtnt[i]);
                if (daPrcTrspModCd[i] != null)
                    model.setDaPrcTrspModCd(daPrcTrspModCd[i]);
                if (rtRarRtOpCd[i] != null)
                    model.setRtRarRtOpCd(rtRarRtOpCd[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (rtAppCurrCd[i] != null)
                    model.setRtAppCurrCd(rtAppCurrCd[i]);
//                if (rtRasNoteConvSeq[i] != null)
//                    model.setRtRasNoteConvSeq(rtRasNoteConvSeq[i]);
                if (daDirCallFlg[i] != null)
                    model.setDaDirCallFlg(daDirCallFlg[i]);
                if (daRapFrtRtAmt[i] != null)
                    model.setDaRapFrtRtAmt(daRapFrtRtAmt[i]);
                if (oaRoutPntLocDefCd[i] != null)
                    model.setOaRoutPntLocDefCd(oaRoutPntLocDefCd[i]);
                if (rtTypFrtRtAmt[i] != null)
                    model.setRtTypFrtRtAmt(rtTypFrtRtAmt[i]);
                if (noteCtnt[i] != null)
                    model.setNoteCtnt(noteCtnt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (oaRatUtCd[i] != null)
                    model.setOaRatUtCd(oaRatUtCd[i]);
                if (rtFnlFrtRtAmt[i] != null)
                    model.setRtFnlFrtRtAmt(rtFnlFrtRtAmt[i]);
                if (oaTypNoteConvTpCd[i] != null)
                    model.setOaTypNoteConvTpCd(oaTypNoteConvTpCd[i]);
                if (dvRoutViaPortDefCd[i] != null)
                    model.setDvRoutViaPortDefCd(dvRoutViaPortDefCd[i]);
//                if (rtDorNoteConvSeq[i] != null)
//                    model.setRtDorNoteConvSeq(rtDorNoteConvSeq[i]);
                if (rtArbNoteConvTpCd[i] != null)
                    model.setRtArbNoteConvTpCd(rtArbNoteConvTpCd[i]);
                if (chgUtAmt[i] != null)
                    model.setChgUtAmt(chgUtAmt[i]);
                if (rtTypConvCtnt[i] != null)
                    model.setRtTypConvCtnt(rtTypConvCtnt[i]);
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
                if (delMtchFlg[i] != null)
                    model.setDelMtchFlg(delMtchFlg[i]);
                if (opRoutPntLocDefCd[i] != null)
                    model.setOpRoutPntLocDefCd(opRoutPntLocDefCd[i]);
                if (daDorNoteConvTpCd[i] != null)
                    model.setDaDorNoteConvTpCd(daDorNoteConvTpCd[i]);
                if (cmdtNm[i] != null)
                    model.setCmdtNm(cmdtNm[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (daPrcCmdtDefCd[i] != null)
                    model.setDaPrcCmdtDefCd(daPrcCmdtDefCd[i]);
                if (daTypCurrCd[i] != null)
                    model.setDaTypCurrCd(daTypCurrCd[i]);
                if (frtInclXcldDivCd[i] != null)
                    model.setFrtInclXcldDivCd(frtInclXcldDivCd[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (trnsModCd[i] != null)
                    model.setTrnsModCd(trnsModCd[i]);
                if (oaTypCurrCd[i] != null)
                    model.setOaTypCurrCd(oaTypCurrCd[i]);
                if (frtRtAmt[i] != null)
                    model.setFrtRtAmt(frtRtAmt[i]);
                if (rtRatUtCd[i] != null)
                    model.setRtRatUtCd(rtRatUtCd[i]);
                if (rtAddBkgConvTpCd[i] != null)
                    model.setRtAddBkgConvTpCd(rtAddBkgConvTpCd[i]);
                if (daTypNoteConvTpCd[i] != null)
                    model.setDaTypNoteConvTpCd(daTypNoteConvTpCd[i]);
                if (rtAppFrtRtAmt[i] != null)
                    model.setRtAppFrtRtAmt(rtAppFrtRtAmt[i]);
                if (daCalcFrtRtAmt[i] != null)
                    model.setDaCalcFrtRtAmt(daCalcFrtRtAmt[i]);
//                if (oaRacNoteConvSeq[i] != null)
//                    model.setOaRacNoteConvSeq(oaRacNoteConvSeq[i]);
//                if (oaRarCurrCd[i] != null)
//                    model.setOaRarCurrCd(oaRarCurrCd[i]);
                if (svcScpCd[i] != null)
                    model.setSvcScpCd(svcScpCd[i]);
                if (rtDorFrtRtAmt[i] != null)
                    model.setRtDorFrtRtAmt(rtDorFrtRtAmt[i]);
                if (cgoTpCd[i] != null)
                    model.setCgoTpCd(cgoTpCd[i]);
                if (oaDorCurrCd[i] != null)
                    model.setOaDorCurrCd(oaDorCurrCd[i]);
                if (rtRasConvCtnt[i] != null)
                    model.setRtRasConvCtnt(rtRasConvCtnt[i]);
                if (oaPrcCgoTpCd[i] != null)
                    model.setOaPrcCgoTpCd(oaPrcCgoTpCd[i]);
                if (daRacConvCtnt[i] != null)
                    model.setDaRacConvCtnt(daRacConvCtnt[i]);
                if (chgAmt[i] != null)
                    model.setChgAmt(chgAmt[i]);
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
                if (ratUtCd[i] != null)
                    model.setRatUtCd(ratUtCd[i]);
                if (diCalcFrtRtAmt[i] != null)
                    model.setDiCalcFrtRtAmt(diCalcFrtRtAmt[i]);
//                if (daRarNoteConvSeq[i] != null)
//                    model.setDaRarNoteConvSeq(daRarNoteConvSeq[i]);
                if (oftCmbSeq[i] != null)
                    model.setOftCmbSeq(oftCmbSeq[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (daViaPortDefCd[i] != null)
                    model.setDaViaPortDefCd(daViaPortDefCd[i]);
                if (diRatUtCd[i] != null)
                    model.setDiRatUtCd(diRatUtCd[i]);
                if (oaFnlFrtRtAmt[i] != null)
                    model.setOaFnlFrtRtAmt(oaFnlFrtRtAmt[i]);
                if (daRatUtCd[i] != null)
                    model.setDaRatUtCd(daRatUtCd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (prcRtSeq[i] != null)
                    model.setPrcRtSeq(prcRtSeq[i]);
                if (rtRarFrtRtAmt[i] != null)
                    model.setRtRarFrtRtAmt(rtRarFrtRtAmt[i]);
                if (oaDirCallFlg[i] != null)
                    model.setOaDirCallFlg(oaDirCallFlg[i]);
                if (opCntrQty[i] != null)
                    model.setOpCntrQty(opCntrQty[i]);
                if (daRapBkgConvTpCd[i] != null)
                    model.setDaRapBkgConvTpCd(daRapBkgConvTpCd[i]);
                if (rtArbFrtRtAmt[i] != null)
                    model.setRtArbFrtRtAmt(rtArbFrtRtAmt[i]);
                if (pctBseCd[i] != null)
                    model.setPctBseCd(pctBseCd[i]);
                if (imdgClssCd[i] != null)
                    model.setImdgClssCd(imdgClssCd[i]);
                if (rtRarConvCtnt[i] != null)
                    model.setRtRarConvCtnt(rtRarConvCtnt[i]);
                if (dpSeq[i] != null)
                    model.setDpSeq(dpSeq[i]);
                if (rtRacNoteConvTpCd[i] != null)
                    model.setRtRacNoteConvTpCd(rtRacNoteConvTpCd[i]);
                if (rtDorCurrCd[i] != null)
                    model.setRtDorCurrCd(rtDorCurrCd[i]);
                if (rtRacConvCtnt[i] != null)
                    model.setRtRacConvCtnt(rtRacConvCtnt[i]);
                if (daPrcCgoTpCd[i] != null)
                    model.setDaPrcCgoTpCd(daPrcCgoTpCd[i]);
                if (prcCmdtHdrSeq[i] != null)
                    model.setPrcCmdtHdrSeq(prcCmdtHdrSeq[i]);
                if (fnlFrtRtAmt[i] != null)
                    model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
                if (rtRasCurrCd[i] != null)
                    model.setRtRasCurrCd(rtRasCurrCd[i]);
//                if (oaRarRtOpCd[i] != null)
//                    model.setOaRarRtOpCd(oaRarRtOpCd[i]);
                if (oaRapRtOpCd[i] != null)
                    model.setOaRapRtOpCd(oaRapRtOpCd[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
//                if (rtArbNoteConvSeq[i] != null)
//                    model.setRtArbNoteConvSeq(rtArbNoteConvSeq[i]);
//                if (daRacNoteConvSeq[i] != null)
//                    model.setDaRacNoteConvSeq(daRacNoteConvSeq[i]);
//                if (rtTypNoteConvSeq[i] != null)
//                    model.setRtTypNoteConvSeq(rtTypNoteConvSeq[i]);
                if (note[i] != null)
                    model.setNote(note[i]);
                if (rtAddNoteConvTpCd[i] != null)
                    model.setRtAddNoteConvTpCd(rtAddNoteConvTpCd[i]);
                if (rtTypCurrCd[i] != null)
                    model.setRtTypCurrCd(rtTypCurrCd[i]);
//                if (rtAddNoteConvSeq[i] != null)
//                    model.setRtAddNoteConvSeq(rtAddNoteConvSeq[i]);
                if (rtDorRtOpCd[i] != null)
                    model.setRtDorRtOpCd(rtDorRtOpCd[i]);
//                if (rtRarNoteConvSeq[i] != null)
//                    model.setRtRarNoteConvSeq(rtRarNoteConvSeq[i]);
                if (inclOftFlg[i] != null)
                    model.setInclOftFlg(inclOftFlg[i]);
                if (oaTypConvCtnt[i] != null)
                    model.setOaTypConvCtnt(oaTypConvCtnt[i]);
                if (rtArbCurrCd[i] != null)
                    model.setRtArbCurrCd(rtArbCurrCd[i]);
                if (daRoutPntLocDefCd[i] != null)
                    model.setDaRoutPntLocDefCd(daRoutPntLocDefCd[i]);
                if (oaBsePortDefCd[i] != null)
                    model.setOaBsePortDefCd(oaBsePortDefCd[i]);
                if (prcHngrBarTpCd[i] != null)
                    model.setPrcHngrBarTpCd(prcHngrBarTpCd[i]);
                if (rtRacBkgConvTpCd[i] != null)
                    model.setRtRacBkgConvTpCd(rtRacBkgConvTpCd[i]);
                if (oiCurrCd[i] != null)
                    model.setOiCurrCd(oiCurrCd[i]);
                if (oiFnlFrtRtAmt[i] != null)
                    model.setOiFnlFrtRtAmt(oiFnlFrtRtAmt[i]);
                if (rtTypNoteConvTpCd[i] != null)
                    model.setRtTypNoteConvTpCd(rtTypNoteConvTpCd[i]);
                if (dryCgoFlg[i] != null)
                    model.setDryCgoFlg(dryCgoFlg[i]);
                if (rtAddFrtRtAmt[i] != null)
                    model.setRtAddFrtRtAmt(rtAddFrtRtAmt[i]);
                if (amdtSeq[i] != null)
                    model.setAmdtSeq(amdtSeq[i]);
//                if (rtRapNoteConvSeq[i] != null)
//                    model.setRtRapNoteConvSeq(rtRapNoteConvSeq[i]);
                if (orgTrspModCd[i] != null)
                    model.setOrgTrspModCd(orgTrspModCd[i]);
                if (oaRapCurrCd[i] != null)
                    model.setOaRapCurrCd(oaRapCurrCd[i]);
                if (daDorCurrCd[i] != null)
                    model.setDaDorCurrCd(daDorCurrCd[i]);
                if (daDorBkgConvTpCd[i] != null)
                    model.setDaDorBkgConvTpCd(daDorBkgConvTpCd[i]);
//                if (oaRarNoteConvSeq[i] != null)
//                    model.setOaRarNoteConvSeq(oaRarNoteConvSeq[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (cgoCateCd[i] != null)
                    model.setCgoCateCd(cgoCateCd[i]);
                if (rtAddCurrCd[i] != null)
                    model.setRtAddCurrCd(rtAddCurrCd[i]);
                if (oaRacNoteConvTpCd[i] != null)
                    model.setOaRacNoteConvTpCd(oaRacNoteConvTpCd[i]);
                if (rtMtchPattCd[i] != null)
                    model.setRtMtchPattCd(rtMtchPattCd[i]);
                if (oaDorBkgConvTpCd[i] != null)
                    model.setOaDorBkgConvTpCd(oaDorBkgConvTpCd[i]);
                if (daCurrCd[i] != null)
                    model.setDaCurrCd(daCurrCd[i]);
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
//                if (daRarDaOpCd[i] != null)
//                    model.setDaRarDaOpCd(daRarDaOpCd[i]);
                if (oaTypFrtRtAmt[i] != null)
                    model.setOaTypFrtRtAmt(oaTypFrtRtAmt[i]);
                if (ratAsQty[i] != null)
                    model.setRatAsQty(ratAsQty[i]);
                if (dpRoutPntLocDefCd[i] != null)
                    model.setDpRoutPntLocDefCd(dpRoutPntLocDefCd[i]);
                if (rtTypRtOpCd[i] != null)
                    model.setRtTypRtOpCd(rtTypRtOpCd[i]);
                if (oiRcvDeTermCd[i] != null)
                    model.setOiRcvDeTermCd(oiRcvDeTermCd[i]);
                if (currCd[i] != null)
                    model.setCurrCd(currCd[i]);
                if (triPropNo[i] != null)
                    model.setTriPropNo(triPropNo[i]);
//                if (oaTypNoteConvSeq[i] != null)
//                    model.setOaTypNoteConvSeq(oaTypNoteConvSeq[i]);
                if (rtRapRtOpCd[i] != null)
                    model.setRtRapRtOpCd(rtRapRtOpCd[i]);
                if (daRacCurrCd[i] != null)
                    model.setDaRacCurrCd(daRacCurrCd[i]);
                if (oaRapFrtRtAmt[i] != null)
                    model.setOaRapFrtRtAmt(oaRapFrtRtAmt[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (rtDorBkgConvTpCd[i] != null)
                    model.setRtDorBkgConvTpCd(rtDorBkgConvTpCd[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
//                if (oaDorNoteConvSeq[i] != null)
//                    model.setOaDorNoteConvSeq(oaDorNoteConvSeq[i]);
                if (daDorDaOpCd[i] != null)
                    model.setDaDorDaOpCd(daDorDaOpCd[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (porCntCd[i] != null)
                    model.setPorCntCd(porCntCd[i]);
                if (rtRasFrtRtAmt[i] != null)
                    model.setRtRasFrtRtAmt(rtRasFrtRtAmt[i]);
                if (diBsePortDefCd[i] != null)
                    model.setDiBsePortDefCd(diBsePortDefCd[i]);
                if (diPrcCmdtDefCd[i] != null)
                    model.setDiPrcCmdtDefCd(diPrcCmdtDefCd[i]);
                if (rtAppNoteConvTpCd[i] != null)
                    model.setRtAppNoteConvTpCd(rtAppNoteConvTpCd[i]);
                if (rtArbBkgConvTpCd[i] != null)
                    model.setRtArbBkgConvTpCd(rtArbBkgConvTpCd[i]);
                if (daDorFrtRtAmt[i] != null)
                    model.setDaDorFrtRtAmt(daDorFrtRtAmt[i]);
                if (oiBsePortDefCd[i] != null)
                    model.setOiBsePortDefCd(oiBsePortDefCd[i]);
                if (daRacNoteConvTpCd[i] != null)
                    model.setDaRacNoteConvTpCd(daRacNoteConvTpCd[i]);
                if (oaRapNoteConvTpCd[i] != null)
                    model.setOaRapNoteConvTpCd(oaRapNoteConvTpCd[i]);
                if (eqSubstCntrTpszCd[i] != null)
                    model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
                if (oiViaPortDefCd[i] != null)
                    model.setOiViaPortDefCd(oiViaPortDefCd[i]);
                if (oaDorRtOpCd[i] != null)
                    model.setOaDorRtOpCd(oaDorRtOpCd[i]);
                if (oaViaPortDefCd[i] != null)
                    model.setOaViaPortDefCd(oaViaPortDefCd[i]);
                if (rtTypBkgConvTpCd[i] != null)
                    model.setRtTypBkgConvTpCd(rtTypBkgConvTpCd[i]);
                if (diViaPortDefCd[i] != null)
                    model.setDiViaPortDefCd(diViaPortDefCd[i]);
                if (rtAppRtOpCd[i] != null)
                    model.setRtAppRtOpCd(rtAppRtOpCd[i]);
                if (cmPrcCmdtDefCd[i] != null)
                    model.setCmPrcCmdtDefCd(cmPrcCmdtDefCd[i]);
                if (cmdtSeq[i] != null)
                    model.setCmdtSeq(cmdtSeq[i]);
                if (autoRatFlg[i] != null)
                    model.setAutoRatFlg(autoRatFlg[i]);
                if (bqSeq[i] != null)
					model.setBqSeq(bqSeq[i]);
				if (bkgBqOccrSeq[i] != null)
					model.setBkgBqOccrSeq(bkgBqOccrSeq[i]);
				if (bkgBqSeq[i] != null)
					model.setBkgBqSeq(bkgBqSeq[i]);
				if (calcCtrtTpCd[i] != null)
					model.setCalcCtrtTpCd(calcCtrtTpCd[i]);
				if (prnHdnFlg[i] != null)
					model.setPrnHdnFlg(prnHdnFlg[i]);
				if (fxRtFlg[i] != null)
					model.setFxRtFlg(fxRtFlg[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);

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
				if (oaMinCgoWgt[i] != null)
					model.setOaMinCgoWgt(oaMinCgoWgt[i]);
				if (oaMaxCgoWgt[i] != null)
					model.setOaMaxCgoWgt(oaMaxCgoWgt[i]);
				if (daMinCgoWgt[i] != null)
					model.setDaMinCgoWgt(daMinCgoWgt[i]);
				if (daMaxCgoWgt[i] != null)
					model.setDaMaxCgoWgt(daMaxCgoWgt[i]);
				if (diMinCgoWgt[i] != null)
					model.setDiMinCgoWgt(diMinCgoWgt[i]);
				if (diMaxCgoWgt[i] != null)
					model.setDiMaxCgoWgt(diMaxCgoWgt[i]);
				if (taxFlg[i] != null)
					model.setTaxFlg(taxFlg[i]);
				if (taxCntCd[i] != null)
					model.setTaxCntCd(taxCntCd[i]);
				if (inclTaxFlg[i] != null)
					model.setInclTaxFlg(inclTaxFlg[i]);
				if (oiFrtTermCd[i] != null)
					model.setOiFrtTermCd(oiFrtTermCd[i]);
				if (oaFrtTermCd[i] != null)
					model.setOaFrtTermCd(oaFrtTermCd[i]);
				if (daFrtTermCd[i] != null)
					model.setDaFrtTermCd(daFrtTermCd[i]);
				if (diFrtTermCd[i] != null)
					model.setDiFrtTermCd(diFrtTermCd[i]);
				if (n3ptyRcvOfcCd[i] != null)
					model.setN3ptyRcvOfcCd(n3ptyRcvOfcCd[i]);
				
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchScOftAutoratingListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchScOftAutoratingListVO[]
	 */
    public SearchScOftAutoratingListVO[] getSearchScOftAutoratingListVOs() {
        SearchScOftAutoratingListVO[] vos = (SearchScOftAutoratingListVO[]) models.toArray(new SearchScOftAutoratingListVO[models.size()]);
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
        this.oaTypBkgConvTpCd = this.oaTypBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRacConvCtnt = this.oaRacConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaPrcTrspModCd = this.oaPrcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diPrcTrspModCd = this.diPrcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRcvDeTermCd = this.oaRcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daTypBkgConvTpCd = this.daTypBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daTypNoteConvSeq = this.daTypNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ovRoutViaPortDefCd = this.ovRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRarFrtRtAmt = this.oaRarFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaDorNoteConvTpCd = this.oaDorNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaCurrCd = this.oaCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRarBkgConvTpCd = this.oaRarBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daFnlFrtRtAmt = this.daFnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRarBkgConvTpCd = this.rtRarBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRacDaOpCd = this.daRacDaOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAppBkgConvTpCd = this.rtAppBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRapBkgConvTpCd = this.oaRapBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRapNoteConvSeq = this.oaRapNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRacFrtRtAmt = this.oaRacFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRarFrtRtAmt = this.daRarFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diRcvDeTermCd = this.diRcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtCalcFrtRtAmt = this.rtCalcFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaTypRtOpCd = this.oaTypRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRapCurrCd = this.daRapCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRacBkgConvTpCd = this.oaRacBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRarCurrCd = this.rtRarCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRarBkgConvTpCd = this.daRarBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diCurrCd = this.diCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRapNoteConvSeq = this.daRapNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRasBkgConvTpCd = this.rtRasBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRapCurrCd = this.rtRapCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcCgoTpCd = this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiRatUtCd = this.oiRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRacCurrCd = this.rtRacCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRacCurrCd = this.oaRacCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daTypDaOpCd = this.daTypDaOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtDorNoteConvTpCd = this.rtDorNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRacBkgConvTpCd = this.daRacBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaCalcFrtRtAmt = this.oaCalcFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRarNoteConvTpCd = this.daRarNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRapDaOpCd = this.daRapDaOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtAppNoteConvSeq = this.rtAppNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRasNoteConvTpCd = this.rtRasNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRacFrtRtAmt = this.rtRacFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtPrcCgoTpCd = this.rtPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAddRtOpCd = this.rtAddRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diDirCallFlg = this.diDirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtDorConvCtnt = this.rtDorConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daTypConvCtnt = this.daTypConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRapFrtRtAmt = this.rtRapFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtRacNoteConvSeq = this.rtRacNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRarNoteConvTpCd = this.oaRarNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnt = this.cnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRcvDeTermCd = this.daRcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daTypFrtRtAmt = this.daTypFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiCalcFrtRtAmt = this.oiCalcFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtArbRtOpCd = this.rtArbRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.propNo = this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRapNoteConvTpCd = this.daRapNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRapBkgConvTpCd = this.rtRapBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAplyDt = this.rtAplyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diPrcCgoTpCd = this.diPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porMtchFlg = this.porMtchFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgCd = this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRarCurrCd = this.daRarCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dtl = this.dtl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daDorNoteConvSeq = this.daDorNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.destTrspModCd = this.destTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRasRtOpCd = this.rtRasRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcGenSpclRtTpCd = this.prcGenSpclRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRarNoteConvTpCd = this.rtRarNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diFnlFrtRtAmt = this.diFnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiPrcCmdtDefCd = this.oiPrcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaDorFrtRtAmt = this.oaDorFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inGaFlg = this.inGaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCntCd = this.delCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtTermCd = this.frtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiPrcCgoTpCd = this.oiPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRapConvCtnt = this.rtRapConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daPrcTrspModCd = this.daPrcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRarRtOpCd = this.rtRarRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAppCurrCd = this.rtAppCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtRasNoteConvSeq = this.rtRasNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daDirCallFlg = this.daDirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRapFrtRtAmt = this.daRapFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRoutPntLocDefCd = this.oaRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtTypFrtRtAmt = this.rtTypFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.noteCtnt = this.noteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRatUtCd = this.oaRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtFnlFrtRtAmt = this.rtFnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaTypNoteConvTpCd = this.oaTypNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dvRoutViaPortDefCd = this.dvRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtDorNoteConvSeq = this.rtDorNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtArbNoteConvTpCd = this.rtArbNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgUtAmt = this.chgUtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtTypConvCtnt = this.rtTypConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daBsePortDefCd = this.daBsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRacFrtRtAmt = this.daRacFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcRoutSeq = this.prcRoutSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ctrtCntrTpszCd = this.ctrtCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiPrcTrspModCd = this.oiPrcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delMtchFlg = this.delMtchFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opRoutPntLocDefCd = this.opRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daDorNoteConvTpCd = this.daDorNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtNm = this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daPrcCmdtDefCd = this.daPrcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daTypCurrCd = this.daTypCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtInclXcldDivCd = this.frtInclXcldDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trnsModCd = this.trnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaTypCurrCd = this.oaTypCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.frtRtAmt = this.frtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRatUtCd = this.rtRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAddBkgConvTpCd = this.rtAddBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daTypNoteConvTpCd = this.daTypNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAppFrtRtAmt = this.rtAppFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daCalcFrtRtAmt = this.daCalcFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRacNoteConvSeq = this.oaRacNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRarCurrCd = this.oaRarCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtDorFrtRtAmt = this.rtDorFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoTpCd = this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaDorCurrCd = this.oaDorCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRasConvCtnt = this.rtRasConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaPrcCgoTpCd = this.oaPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRacConvCtnt = this.daRacConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.chgAmt = this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaPrcCmdtDefCd = this.oaPrcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvDeTermCd = this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiRoutPntLocDefCd = this.oiRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiDirCallFlg = this.oiDirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirCallFlg = this.dirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratUtCd = this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diCalcFrtRtAmt = this.diCalcFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRarNoteConvSeq = this.daRarNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oftCmbSeq = this.oftCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daViaPortDefCd = this.daViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diRatUtCd = this.diRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaFnlFrtRtAmt = this.oaFnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRatUtCd = this.daRatUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcRtSeq = this.prcRtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRarFrtRtAmt = this.rtRarFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaDirCallFlg = this.oaDirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.opCntrQty = this.opCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRapBkgConvTpCd = this.daRapBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtArbFrtRtAmt = this.rtArbFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctBseCd = this.pctBseCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imdgClssCd = this.imdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRarConvCtnt = this.rtRarConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpSeq = this.dpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRacNoteConvTpCd = this.rtRacNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtDorCurrCd = this.rtDorCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRacConvCtnt = this.rtRacConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daPrcCgoTpCd = this.daPrcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcCmdtHdrSeq = this.prcCmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fnlFrtRtAmt = this.fnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRasCurrCd = this.rtRasCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRarRtOpCd = this.oaRarRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRapRtOpCd = this.oaRapRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtArbNoteConvSeq = this.rtArbNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRacNoteConvSeq = this.daRacNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtTypNoteConvSeq = this.rtTypNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.note = this.note.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAddNoteConvTpCd = this.rtAddNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtTypCurrCd = this.rtTypCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtAddNoteConvSeq = this.rtAddNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtDorRtOpCd = this.rtDorRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtRarNoteConvSeq = this.rtRarNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inclOftFlg = this.inclOftFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaTypConvCtnt = this.oaTypConvCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtArbCurrCd = this.rtArbCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRoutPntLocDefCd = this.daRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaBsePortDefCd = this.oaBsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prcHngrBarTpCd = this.prcHngrBarTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRacBkgConvTpCd = this.rtRacBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiCurrCd = this.oiCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiFnlFrtRtAmt = this.oiFnlFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtTypNoteConvTpCd = this.rtTypNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dryCgoFlg = this.dryCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAddFrtRtAmt = this.rtAddFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.amdtSeq = this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.rtRapNoteConvSeq = this.rtRapNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgTrspModCd = this.orgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRapCurrCd = this.oaRapCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daDorCurrCd = this.daDorCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daDorBkgConvTpCd = this.daDorBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaRarNoteConvSeq = this.oaRarNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cgoCateCd = this.cgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAddCurrCd = this.rtAddCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRacNoteConvTpCd = this.oaRacNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtMtchPattCd = this.rtMtchPattCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaDorBkgConvTpCd = this.oaDorBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daCurrCd = this.daCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRacRtOpCd = this.rtRacRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRacRtOpCd = this.oaRacRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRapNoteConvTpCd = this.rtRapNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diRoutPntLocDefCd = this.diRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.daRarDaOpCd = this.daRarDaOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaTypFrtRtAmt = this.oaTypFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ratAsQty = this.ratAsQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dpRoutPntLocDefCd = this.dpRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtTypRtOpCd = this.rtTypRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiRcvDeTermCd = this.oiRcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.triPropNo = this.triPropNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaTypNoteConvSeq = this.oaTypNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRapRtOpCd = this.rtRapRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRacCurrCd = this.daRacCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRapFrtRtAmt = this.oaRapFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtDorBkgConvTpCd = this.rtDorBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//        this.oaDorNoteConvSeq = this.oaDorNoteConvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daDorDaOpCd = this.daDorDaOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCntCd = this.porCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtRasFrtRtAmt = this.rtRasFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diBsePortDefCd = this.diBsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diPrcCmdtDefCd = this.diPrcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAppNoteConvTpCd = this.rtAppNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtArbBkgConvTpCd = this.rtArbBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daDorFrtRtAmt = this.daDorFrtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiBsePortDefCd = this.oiBsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daRacNoteConvTpCd = this.daRacNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaRapNoteConvTpCd = this.oaRapNoteConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiViaPortDefCd = this.oiViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaDorRtOpCd = this.oaDorRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaViaPortDefCd = this.oaViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtTypBkgConvTpCd = this.rtTypBkgConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diViaPortDefCd = this.diViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rtAppRtOpCd = this.rtAppRtOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmPrcCmdtDefCd = this.cmPrcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtSeq = this.cmdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.autoRatFlg = this.autoRatFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
        this.oaMinCgoWgt = this.oaMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaMaxCgoWgt = this.oaMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daMinCgoWgt = this.daMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daMaxCgoWgt = this.daMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diMinCgoWgt = this.diMinCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diMaxCgoWgt = this.diMaxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxFlg = this.taxFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.taxCntCd = this.taxCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.inclTaxFlg = this.inclTaxFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oiFrtTermCd = this.oiFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oaFrtTermCd = this.oaFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.daFrtTermCd = this.daFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.diFrtTermCd = this.diFrtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.n3ptyRcvOfcCd = this.n3ptyRcvOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

    }
}
