/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtBCImpl.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2010.10.20 김태균 [CHM-201006557-01] [EES-DMT] DEM/DET에서 OFFICE TRANSFER의 표시기능을 A/R INTERFACE 전송 요청
* 2010.11.05 김태균 [CHM-201006838-01] [EES-DMT] [DMDT] DMDT Invoice의 Cust Ref 정보 입력 ---  BKG의 P/O number
* 2010.11.26 김태균 [] [EES-DMT] A/R I/F시 INVOICE CURRECY 없을 경우 에러 처리함
* 2010.12.28 김태균 [] [EES-DMT] THRBA OFFICE 사용자 invoice issue 시 invoice currency ERROR로 인하여 에러로그 추가
* 2011.03.07 김태균 [CHM-201109126-01] [EES-DMT] [DET] DR 삭제로 인한 Invoice 삭제에 따른 Credit Note 생성/인쇄 기능 지원
* 2011.04.24 김태균 [] Invoice 생성시 rcv_term_cd, de_term_cd 컬럼 추가 저장(issueInvoice,issueInvoiceByGroup)
* 2011.05.20 김태균[CHM-201110830-01] [DMT] Issued Invoice Inquiry 화면 보완 요청
* 2011.11.14 권   민[CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발 
* 2012.05.18 김현화 [CHM-201217803] 인도용 DMT Invoice format 구성 - GST 적용.
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AftBkgCxlInvCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARActualPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceCreationCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.BookingCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCrTermOptVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvNoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.EDIContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ExchangeNTaxRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IndiaFiscalYearVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IndiaInvoiceNo;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InterfaceChargeCalculationVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceAmtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailAmountVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailTaxVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDPreviewVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceMainAmountVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceNoGenCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceNoGenVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceSumByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByBookingVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByChargeVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanDetailExcelListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanOfficeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial2VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParm2VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsPayRcvVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionMasterSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListDwVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-InvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-InvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4001EventResponse,InvoiceIssueCollectionMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InvoiceIssueCollectionMgtBCImpl extends BasicCommandSupport implements InvoiceIssueCollectionMgtBC {

    // Database Access Object
    private transient InvoiceIssueCollectionMgtDBDAO dbDao = null;

    DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
    
    ChargeCalculationBC chgCalcBC = new ChargeCalculationBCImpl();
    
    /**
     * InvoiceIssueCollectionMgtBCImpl 객체 생성<br>
     * InvoiceIssueCollectionMgtDBDAO를 생성한다.<br>
     */
    public InvoiceIssueCollectionMgtBCImpl() {
        dbDao = new InvoiceIssueCollectionMgtDBDAO();
    }
    
    /**
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<ConfirmChargeListVO>
     * @exception EventException
     */
    public List<ConfirmChargeListVO> searchChargeInvoiceList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException {
        String fm_cfm_dt = "";
        String to_cfm_dt = "";        
        String s_fm_dt = "";
        String s_to_dt = "";
        List<ConfirmChargeListVO> confirmChargeListVOs = null;
        try {
        	fm_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getFmCfmDt(), "-", "");
        	to_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getToCfmDt(), "-", "");
        	s_fm_dt = JSPUtil.replace(issuedInvoiceParamVO.getSFmDt(), "-", "");
        	s_to_dt = JSPUtil.replace(issuedInvoiceParamVO.getSToDt(), "-", "");
        	
        	issuedInvoiceParamVO.setFmCfmDt(fm_cfm_dt);
        	issuedInvoiceParamVO.setToCfmDt(to_cfm_dt);
        	issuedInvoiceParamVO.setSFmDt(s_fm_dt);
        	issuedInvoiceParamVO.setSToDt(s_to_dt);
        	issuedInvoiceParamVO.setOfcCd(account.getOfc_cd());	//추가.2010.04.20
        	
            if ("1".equals(issuedInvoiceParamVO.getSGroupBy())) {
            	confirmChargeListVOs = dbDao.searchConfirmChargeByBooking(issuedInvoiceParamVO);        //B/L No.
            } 
            else {
            	confirmChargeListVOs = dbDao.searchConfirmChargeByContainer(issuedInvoiceParamVO);      //CNTR No.
            }
            for (int i = 0; i < confirmChargeListVOs.size(); i++) {
            	ConfirmChargeListVO confirmChargeListVO = (ConfirmChargeListVO)confirmChargeListVOs.get(i);
            		
            	double exchangeRate = 1;
            	double invChgTotAmt = 0;
            		
            	if(!confirmChargeListVO.getBzcTrfCurrCd().equals(confirmChargeListVO.getArCurrCd())) {
	           		//xch_rate 조회
	           		ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
	           		exchangeRateParmVO.setVslCd(confirmChargeListVO.getVslCd());
	           		exchangeRateParmVO.setSkdVoyageNo(confirmChargeListVO.getSkdVoyNo());
	           		exchangeRateParmVO.setSkdDirCd(confirmChargeListVO.getSkdDirCd());
	           		exchangeRateParmVO.setIoBnd(confirmChargeListVO.getDmdtTrfCd().substring(2,3));
	           		exchangeRateParmVO.setPodLoc(confirmChargeListVO.getPodCd());
	           		exchangeRateParmVO.setPolLoc(confirmChargeListVO.getPolCd());
	           		exchangeRateParmVO.setFmCurCd(confirmChargeListVO.getBzcTrfCurrCd());
	           		exchangeRateParmVO.setToCurCd(confirmChargeListVO.getArCurrCd());
	            		
	           		exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
            	}
            	//INV_AMT 계산
            	invChgTotAmt = exchangeRate * NumberUtils.toDouble(confirmChargeListVO.getBilAmt());
            	invChgTotAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVO.getArCurrCd(), invChgTotAmt);
            		
            	confirmChargeListVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));
            	confirmChargeListVO.setInvAmt(JSPUtil.toDecimalFormat(invChgTotAmt, "#.##"));
            	
            	SearchIndiaGstRateVO indiaGstRateVO = dbDao.searchIndiaGstRate("");
            	confirmChargeListVO.setIdaExpnTaxRt(indiaGstRateVO.getIdaExpnTaxRt());
            	confirmChargeListVO.setIdaEduTaxRt(indiaGstRateVO.getIdaEduTaxRt());
            	confirmChargeListVO.setIdaHighEduTaxRt(indiaGstRateVO.getIdaHighEduTaxRt());
            	confirmChargeListVO.setIdaLoclTaxRt(indiaGstRateVO.getIdaLoclTaxRt());
            	confirmChargeListVO.setIdaN2ndLoclTaxRt(indiaGstRateVO.getIdaN2ndLoclTaxRt());
            		
            	confirmChargeListVOs.set(i, confirmChargeListVO);
            }
        } 
        catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } 
        catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}    		
        return confirmChargeListVOs;
    }

    /**
     * PartialPayment의 의한 Invoice 정보를 수정합니다.<br>
     * 
     * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
     * @param SignOnUserAccount account																																																																																																																																														
     * @return DmtResultVO
     * @exception EventException
     */
    public DmtResultVO modifyInvoiceByPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
            throws EventException {

        try {
            DmtResultVO resultVO = new DmtResultVO();
            
            ChargeCalculationContainerVO chgCalcCntrVO = null;
            
            for ( int i=0; i < chargeCalculationContainerVOs.length; i++ ) {
                chgCalcCntrVO = chargeCalculationContainerVOs[i];
                
                if(chgCalcCntrVO.getDmdtInvNo().length() > 0) {
                    
                    // Invoice Patial이 아닌 경우는 Skip
                    if(chgCalcCntrVO.getPartialMark().equals("N")) continue;
                    
                    String arIfFlag = dbDao.searcARIFFlag(chgCalcCntrVO.getDmdtInvNo());
                    if(arIfFlag.equals("Y")) {
                        // "Already interfaced Invoice No!"
                        resultVO.setResultCode("DMT03022");
                        return resultVO;
                    }
                    
                    DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
                    dmtInvDtlVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                    dmtInvDtlVO.setCreOfcCd(chgCalcCntrVO.getCreOfcCd());
                    dmtInvDtlVO.setInvDtlSeq(chgCalcCntrVO.getInvDtlSeq());
                    dmtInvDtlVO.setSvrId(chgCalcCntrVO.getSvrId());
                    dmtInvDtlVO.setCntrNo(chgCalcCntrVO.getCntrNo());
                    dmtInvDtlVO.setCntrCycNo(chgCalcCntrVO.getCntrCycNo());
                    dmtInvDtlVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
                    dmtInvDtlVO.setDmdtChgLocDivCd(chgCalcCntrVO.getDmdtChgLocDivCd());
                    dmtInvDtlVO.setChgSeq(chgCalcCntrVO.getChgSeq());
                    dmtInvDtlVO.setFmMvmtDt(chgCalcCntrVO.getFmMvmtDt());
                    dmtInvDtlVO.setToMvmtDt(chgCalcCntrVO.getToMvmtDt());
                    dmtInvDtlVO.setFtDys(chgCalcCntrVO.getFtDys());
                    dmtInvDtlVO.setFtCmncDt(chgCalcCntrVO.getFtCmncDt());
                    dmtInvDtlVO.setFtEndDt(chgCalcCntrVO.getFtEndDt());
                    dmtInvDtlVO.setFxFtOvrDys(chgCalcCntrVO.getFxFtOvrDys());
                    dmtInvDtlVO.setOrgChgAmt(chgCalcCntrVO.getOrgChgAmt());
                    dmtInvDtlVO.setScRfaExptAmt(chgCalcCntrVO.getScRfaExptAmt());
                    dmtInvDtlVO.setAftExptDcAmt(chgCalcCntrVO.getAftExptDcAmt());
                    dmtInvDtlVO.setBilAmt(chgCalcCntrVO.getBilAmt());
                    dmtInvDtlVO.setInvPrtFlg("Y");
                    dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
                    dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
                    
                    dbDao.modifyInvoiceDetailByPartialPayment(dmtInvDtlVO);
                        
                    if(chgCalcCntrVO.getInvDtlSeq().equals("1")) {
                        dbDao.deleteInvoiceRate(chgCalcCntrVO.getDmdtInvNo());
                    }
                    
                    // Free Time을 초과한 일수를 계산한다(get_overday_div)
                    OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
                    overdayNDivParmVO.setSvrId(chgCalcCntrVO.getSvrId());
                    overdayNDivParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
                    overdayNDivParmVO.setCnmvCycNo(chgCalcCntrVO.getCntrCycNo());
                    overdayNDivParmVO.setDttCode(chgCalcCntrVO.getDmdtTrfCd());
                    overdayNDivParmVO.setLocDiv(chgCalcCntrVO.getDmdtChgLocDivCd());
                    overdayNDivParmVO.setDccSeq(chgCalcCntrVO.getChgSeq());
                    overdayNDivParmVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                    
                    //------------- DivOverDay 조회 -----------
                    OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
                    
                    String cntrTpszCd = dbDao.searchContainerTypeSizeByPartialPayment(overdayNDivParmVO);
                    chgCalcCntrVO.setCntrTpszCd(cntrTpszCd);
                    
                    CalculationParmVO calculationParmVO = new CalculationParmVO();
                    calculationParmVO.setSvrId(chgCalcCntrVO.getSvrId());
                    calculationParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
                    calculationParmVO.setTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
                    calculationParmVO.setDmdtDeTermCd(chgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
                    calculationParmVO.setTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
                    calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
                    calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
                    calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
                    calculationParmVO.setCurCd(chgCalcCntrVO.getBzcTrfCurrCd());
                    calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
                                            
                    ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
                    chargeCalculationContainerVO = dbDao.searchChargeStatusCd(dmtInvDtlVO);
                    calculationParmVO.setFtDys(chargeCalculationContainerVO.getFtDys());						// 2014.03.12
                    calculationParmVO.setFmMvmtYdCd(chargeCalculationContainerVO.getFmMvmtYdCd());				// 2014.03.12
                    calculationParmVO.setTrfAplyDt(chargeCalculationContainerVO.getBzcTrfAplyDt());				// 2014.03.12
                    calculationParmVO.setOrgFtOvrDys(chargeCalculationContainerVO.getOrgFtOvrDys());			// 2014.03.12
                    
                    if (!StringUtils.isEmpty(chargeCalculationContainerVO.getScRfaExptAplyDt())) {
						calculationParmVO.setDmdtTrfAplyTpCd("B");
						calculationParmVO.setTrfAplyDt(chargeCalculationContainerVO.getScRfaExptAplyDt());			// 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
					} 
                    else {
						calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
					}
                    CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
                    List<ChrgDtlVO> list = calculationAMTVO.getChrgDtlVOS();

                    if (list != null && list.size() > 0) {
                        DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
                        
                        for(int k=0; k < list.size(); k++) {
                            ChrgDtlVO chrgDtlVO = list.get(k);
                            
                            dmtInvRtVO.setSvrId(chgCalcCntrVO.getSvrId());
                            dmtInvRtVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                            dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
                            dmtInvRtVO.setInvDtlSeq(chgCalcCntrVO.getInvDtlSeq());
                            dmtInvRtVO.setInvRtSeq("");
                            dmtInvRtVO.setBzcDmdtTrfCd("");
                            dmtInvRtVO.setBzcTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
                            dmtInvRtVO.setBzcDmdtDeTermCd(chgCalcCntrVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
                            dmtInvRtVO.setBzcTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
                            dmtInvRtVO.setBzcTrfRtSeq("");
                            dmtInvRtVO.setFtOvrDys(chgCalcCntrVO.getFxFtOvrDys());
                            dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder()); 
                            dmtInvRtVO.setInvRtAmt(chgCalcCntrVO.getInvChgAmt()); // 이부분 체크 필요!!!
                            dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtOver());
                            dmtInvRtVO.setRtOvrChgAmt(chrgDtlVO.getRtOver());
                            dmtInvRtVO.setBzcCurrCd(chrgDtlVO.getRtCurCd());
                            dmtInvRtVO.setCreUsrId(account.getUsr_id());
                            dmtInvRtVO.setUpdUsrId(account.getUsr_id());
                            dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
                            
                            dbDao.createInvoiceRateByPartialPayment(dmtInvRtVO);
                        }
                    }
                    String nextInvDtlSeq = "";
                    
                    if (i+1 < chargeCalculationContainerVOs.length) {
                        nextInvDtlSeq = chargeCalculationContainerVOs[i+1].getInvDtlSeq();
                    }

                    // Container No가 바뀔 경우 AND Discount Amount 가 존재하는 경우에만 Insert
                    if (!chgCalcCntrVO.getInvDtlSeq().equals(nextInvDtlSeq)) {
                        
                        double aftExptDcAmt = 0.0d;
                        double scRfaExptAmt = 0.0d;
                        
                        aftExptDcAmt = NumberUtils.toDouble(chgCalcCntrVO.getAftExptDcAmt(), 0.0d);
                        scRfaExptAmt = NumberUtils.toDouble(chgCalcCntrVO.getScRfaExptAmt(), 0.0d);
                        
                        if (aftExptDcAmt + scRfaExptAmt != 0) {
                            DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
                            
                            aftExptDcAmt = 0 - (aftExptDcAmt + scRfaExptAmt);   /*  (-) Charge  */
                            dmtInvRtVO.setSvrId(chgCalcCntrVO.getSvrId());
                            dmtInvRtVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                            dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
                            dmtInvRtVO.setInvDtlSeq(chgCalcCntrVO.getInvDtlSeq());
                            dmtInvRtVO.setInvRtSeq("");
                            dmtInvRtVO.setBzcDmdtTrfCd("");
                            dmtInvRtVO.setBzcTrfSeq("");
                            dmtInvRtVO.setBzcDmdtDeTermCd("");
                            dmtInvRtVO.setBzcTrfGrpSeq("");
                            dmtInvRtVO.setBzcTrfRtSeq("");
                            dmtInvRtVO.setFtOvrDys("0");
                            dmtInvRtVO.setFtUndDys("0");
                            dmtInvRtVO.setInvRtAmt("0");
                            dmtInvRtVO.setRtOvrDys("0");
                            dmtInvRtVO.setRtOvrChgAmt(String.valueOf(aftExptDcAmt));
                            dmtInvRtVO.setBzcCurrCd(chgCalcCntrVO.getBzcTrfCurrCd());
                            dmtInvRtVO.setCreUsrId(account.getUsr_id());
                            dmtInvRtVO.setUpdUsrId(account.getUsr_id());
                            dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
                            
                            dbDao.createInvoiceRateByPartialPayment(dmtInvRtVO);
                        }
                    }
                    
                    ExchangeNTaxRateVO exchgNTaxRateVO = dbDao.searchExchangeNTaxRate(chgCalcCntrVO.getDmdtInvNo());
                    
                    List<InvoiceDetailListVO> invDtlListVOs = null;
                    invDtlListVOs = dbDao.searchInvoiceDetailListByPartialPayment(chgCalcCntrVO.getDmdtInvNo());
                    
                    double sumOrgChgAmt = 0.0d;
                    double sumScRfaExptAmt = 0.0d;
                    double sumAftExptDcAmt = 0.0d;
                    double sumBilAmt = 0.0d;
                    
                    double orgChgAmt = 0.0d;
                    double scRfaExptAmt = 0.0d;
                    double aftExptDcAmt = 0.0d;
                    double bilAmt = 0.0d;
                    double invXchRt = 0.0d;
                    double cntrInvAmt = 0.0d;
                    double invChgAmt = 0.0d;
                    
                    invXchRt = NumberUtils.toDouble(exchgNTaxRateVO.getInvXchRt(), 0.0d);
                    String invCurrCd = "";
                    
                    // ******** InvoiceDetailListVO Loop 처리 - START *********
                    for(int m=0; m < invDtlListVOs.size(); m++) {
                        InvoiceDetailListVO invDtlVO = invDtlListVOs.get(m);
                        
                        orgChgAmt = NumberUtils.toDouble(invDtlVO.getOrgChgAmt(), 0.0d);
                        scRfaExptAmt = NumberUtils.toDouble(invDtlVO.getScRfaExptAmt(), 0.0d);
                        aftExptDcAmt = NumberUtils.toDouble(invDtlVO.getAftExptDcAmt(), 0.0d);
                        bilAmt = NumberUtils.toDouble(invDtlVO.getBilAmt(), 0.0d);
                        
                        // 조회된 금액 Summary
                        sumOrgChgAmt += orgChgAmt;
                        sumScRfaExptAmt += scRfaExptAmt;
                        sumAftExptDcAmt += aftExptDcAmt;
                        sumBilAmt += bilAmt;
                        
                        // Invoice 금액 계산
                        cntrInvAmt = bilAmt * invXchRt;
                        
                        // Trim Amount : Currency 에 따라  Amount 의 소숫점 이하 자리수 결정
                        invCurrCd = invDtlVO.getInvCurrCd();
                        cntrInvAmt = dmtCalculationUtil.trimCurrencyAmount(invCurrCd, cntrInvAmt);
                        
                        // Invoice 금액 Summary 
                        invChgAmt += cntrInvAmt;
                        
                        InvoiceDetailAmountVO invDtlAmtVO = new InvoiceDetailAmountVO();
                        invDtlAmtVO.setCntrInvAmt(String.valueOf(cntrInvAmt));
                        invDtlAmtVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                        invDtlAmtVO.setInvDtlSeq(invDtlVO.getInvDtlSeq());
                        
                        dbDao.modifyInvoiceDetailAmountByPartialPayment(invDtlAmtVO);
                    }
                    // ******** InvoiceDetailListVO Loop 처리 - END *********
                    
                    double taxAmt = 0.0d;
                    double taxRto = NumberUtils.toDouble(exchgNTaxRateVO.getTaxRto(), 0.0d);
                    
                    taxAmt = invChgAmt * taxRto;
                    taxAmt = dmtCalculationUtil.trimCurrencyAmount(invCurrCd, taxAmt);
                    
                    // [Invoice금액 + Tax금액]
                    double invAmt = taxAmt + invChgAmt;
    
                    InvoiceMainAmountVO invMainAmtVO = new InvoiceMainAmountVO();
                    invMainAmtVO.setOrgChgAmt(String.valueOf(sumOrgChgAmt));
                    invMainAmtVO.setDmdtExptAmt(String.valueOf(sumScRfaExptAmt));
                    invMainAmtVO.setDcAmt(String.valueOf(sumAftExptDcAmt));
                    invMainAmtVO.setBilAmt(String.valueOf(sumBilAmt));
                    invMainAmtVO.setInvChgAmt(String.valueOf(invChgAmt));
                    invMainAmtVO.setInvAmt(String.valueOf(invAmt));
                    invMainAmtVO.setTaxAmt(String.valueOf(taxAmt));
                    invMainAmtVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                    invMainAmtVO.setCreOfcCd(account.getOfc_cd());
                    
                    dbDao.modifyInvoiceMainByPartialPayment(invMainAmtVO);
                } // if - end
            } // for - end
            
            return resultVO;
            
        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    
    }
    
    
    /**
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException {
        InvoiceIssueMgtVO invoiceIssueMgtVO     = new InvoiceIssueMgtVO();
        List<InvoiceIssueVO> invoiceIssueList   = null;
        List<ChargeBookingInvoiceVO> chargeBookingInvoiceList = null;
        
        String curr_ofc_date = "";
        
        try {
        	curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());
        	
            // searchChargeBookingInvoice
            chargeBookingInvoiceList = dbDao.searchChargeBookingInvoice(issuedInvoiceParamVO);
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();

            for( int i = 0 ; i < chargeBookingInvoiceList.size() ; i++) {
                chargeBookingInvoiceVO = (ChargeBookingInvoiceVO)chargeBookingInvoiceList.get(i);
            }

            PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
            PayerNameVO rePayerNameVO = new PayerNameVO();
            
//log.debug("\n--------------------------------1-1--------------------------");         
            
            //Payer가 없을때
            if(chargeBookingInvoiceVO.getPayerCd() == null 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("") 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("00000000") 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("000000")) {
//log.debug("\n--------------------------------1-2--------------------------");         
                chargeBookingInvoiceVO.setPayerCd("");
                chargeBookingInvoiceVO.setPayerNm("");
            }else{
//log.debug("\n--------------------------------1-3--------------------------");         
            
                payerNameParamVO.setSCustCd(chargeBookingInvoiceVO.getPayerCd());
                
                //VENDOR
                if(chargeBookingInvoiceVO.getPayerCd().substring(0,2).equals("00")) {
                	payerNameParamVO.setSCustGubun("1");
                	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
                //CUSTOMER
                }else{
                	payerNameParamVO.setSCustGubun("2");
                	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
                }
                
                chargeBookingInvoiceVO.setPayerCd(rePayerNameVO.getCustCd());
                chargeBookingInvoiceVO.setPayerNm(rePayerNameVO.getCustName());
                
            }
                
            // set Invoice Cur
            if(chargeBookingInvoiceVO.getOfcCd().equals("XMNBS") && account.getUsr_id().equals("XMN0030") && account.getOfc_cd().equals("XMNSC")) {
                chargeBookingInvoiceVO.setInvCurrCd("HKD");
            }
            
            if(chargeBookingInvoiceVO.getOfcCd().equals("SZPSC") && account.getUsr_id().equals("MODC01") && account.getOfc_cd().equals("MACBA")) {
                chargeBookingInvoiceVO.setInvCurrCd("HKD");
            }
            
            List<BookingCustomerVO> bookingCustomerList = null;
            
            // searchBookingCustomer 
            BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
            BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
            
            inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
            
            // searchBookingCustomer 조회
            bookingCustomerList = dbDao.searchBookingCustomer(inBookingCustomerVO);
            
//log.debug("\n--------------------------------1-4--------------------------");         
            if(bookingCustomerList == null || bookingCustomerList.size() == 0) {
                chargeBookingInvoiceVO.setBkgCustCd("");
                chargeBookingInvoiceVO.setBkgCustNm("");
            }else{
                for( int i = 0 ; i < bookingCustomerList.size(); i++) {
                    bookingCustomerVO = (BookingCustomerVO)bookingCustomerList.get(i);
            
                    if(issuedInvoiceParamVO.getSDmdtTrfCd().equals("DMOF") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("DTOC") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("CTOC")) {
                        chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdS());
                        chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmS());
                    }else if(issuedInvoiceParamVO.getSDmdtTrfCd().equals("DMIF") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("DTIC") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("CTIC")) {
                        chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdC());
                        chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmC());
                        
                        if(bookingCustomerVO.getCustCdC() == null || bookingCustomerVO.getCustCdC().length() != 8) {
                            chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdN());
                            chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmN());
                        }
                    }
                }
            }
            // searchSheetOption
            SheetOptionVO iSheetOptionVO = new SheetOptionVO();
            iSheetOptionVO.setDmdtTrfCd(issuedInvoiceParamVO.getSDmdtTrfCd());
            iSheetOptionVO.setOfcCd(issuedInvoiceParamVO.getOfcCd());			//session office
            
            List<SheetOptionVO> listSheetOption = dbDao.searchSheetOption(iSheetOptionVO);
//log.debug("\n--------------------------------1-5--------------------------");         
            // 존재하지 않으면 Due Date = 현재일자, Credit Term = 0 으로 설정함.
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("0");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(curr_ofc_date);//현재일자
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT 출력 L/R
            }else{
                for(int i = 0; i < listSheetOption.size() ; i++) {
                    chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT 출력 L/R
                    
                    if(listSheetOption.get(i).getDfltTaxRto() == null || listSheetOption.get(i).getDfltTaxRto().equals("")) {
                    	chargeBookingInvoiceVO.setTaxRto("0");
                    }else{
                    	chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    }
                    
                    //sheet Option에 Credit Term = 0 이면
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//Due Date가 "Issue Date"를 선택하면 Due Date=현재일자,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(curr_ofc_date);
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//Due Date가 "*******"를 선택하면 Due Date: ********, Credit Term: 공백
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //sheet Option에 Credit Term > 0 이면
                    }else if(!chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	String due_date = DateTime.addDays(curr_ofc_date, Integer.parseInt(chargeBookingInvoiceVO.getCrTermDys()));
                    	chargeBookingInvoiceVO.setDueDate(due_date);
                    }
                }
            }
            // searchARActualPayer(bookingNo, dmdtTrfCd)
            List<ARActualPayerVO> listARActualPayer = dbDao.searchARActualPayer(issuedInvoiceParamVO.getSBkgNo(), issuedInvoiceParamVO.getSDmdtTrfCd());
//log.debug("\n--------------------------------1-6--------------------------");         
            
            if(listARActualPayer == null || listARActualPayer.size() == 0) {
                chargeBookingInvoiceVO.setActCustCd("");
                chargeBookingInvoiceVO.setActCustNm("");

                //Charge의 PayerCode를 ActualPayerCode로 변경함 -- 4002번에 적용함
                chargeBookingInvoiceVO.setPayerCd("");
                chargeBookingInvoiceVO.setPayerNm("");
            }else{
                for(int i = 0; i < listARActualPayer.size() ; i++) {
                    chargeBookingInvoiceVO.setActCustCd(listARActualPayer.get(i).getActCustCd());
                    chargeBookingInvoiceVO.setActCustNm(listARActualPayer.get(i).getActCustNm());
                    
                    //Charge의 PayerCode를 ActualPayerCode로 변경함 -- 4002번에 적용함
                    chargeBookingInvoiceVO.setPayerCd(listARActualPayer.get(i).getActCustCd());
                    chargeBookingInvoiceVO.setPayerNm(listARActualPayer.get(i).getActCustNm());
                }
            }
            if(chargeBookingInvoiceVO.getTruckerCd().equals("000000")) {
                chargeBookingInvoiceVO.setTruckerCd("");
                chargeBookingInvoiceVO.setTruckerNm("");
            }else{
                // searchServiceProviderName
            	VendorNameVO vendorNameVO = dbDao.searchServiceProviderName(chargeBookingInvoiceVO.getTruckerCd());
                
                chargeBookingInvoiceVO.setTruckerNm(vendorNameVO.getVndrNm());
            }
//log.debug("\n--------------------------------1-7--------------------------");         

            // searchExchangeRate
            ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
            
            exchangeRateParmVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0,4));
            exchangeRateParmVO.setSkdVoyageNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
            exchangeRateParmVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8));
            exchangeRateParmVO.setIoBnd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
            exchangeRateParmVO.setPolLoc(chargeBookingInvoiceVO.getPolCd());
            exchangeRateParmVO.setPodLoc(chargeBookingInvoiceVO.getPodCd()); 
            exchangeRateParmVO.setFmCurCd(chargeBookingInvoiceVO.getChgCurrCd());
            exchangeRateParmVO.setToCurCd(chargeBookingInvoiceVO.getInvCurrCd());  
            exchangeRateParmVO.setOfcCd(chargeBookingInvoiceVO.getOfcCd());			//session office

            //Invoice ExchangeRate 
            double exchangeRate = 0;
            if(chargeBookingInvoiceVO.getInvCurrCd().equals(chargeBookingInvoiceVO.getChgCurrCd())) {
                exchangeRate = 1;
            }else{
                exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
            }
            chargeBookingInvoiceVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));//Double 형 소숫점 이하 6자리 포맷팅 꼭 해줘야 함.
            
log.debug("\n--------------------------------1---ex_rate-----------------------"+exchangeRate);         
            //Total Amt
            double totAmt = 0;			//tot_amt
            double totBillAmt = 0;		//tot_bill_amt
            double inv_bill_amt = 0;
            double inv_chg_tot = 0;
            //BKG의 PO NUMBER
            String bkg_no = "";
            String cntr_nos = "";
            String po_number = "";
            
            StringBuffer sb_cntr_no = new StringBuffer();

            // searchChargeBookingInvoiceDetail
            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
            
            for(int i= 0; i < invoiceIssueList.size() ; i++) {
            	InvoiceIssueVO tempInvoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
            	bkg_no = tempInvoiceIssueVO.getBkgNo();
            	sb_cntr_no.append(tempInvoiceIssueVO.getCntrNo()).append(",");
            	
            	//invoice charge amt
            	inv_bill_amt = exchangeRate * NumberUtils.toDouble(tempInvoiceIssueVO.getBilAmt());
            	inv_bill_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_bill_amt);
            	tempInvoiceIssueVO.setInvBillAmt(JSPUtil.toDecimalFormat(inv_bill_amt, "#.##"));
            	
            	totBillAmt += inv_bill_amt;
            	
            	OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
                overdayNDivParmVO.setSvrId(tempInvoiceIssueVO.getSvrId());
                overdayNDivParmVO.setCntrNo(tempInvoiceIssueVO.getCntrNo());
                overdayNDivParmVO.setCnmvCycNo(tempInvoiceIssueVO.getCntrCycNo());
                overdayNDivParmVO.setDttCode(tempInvoiceIssueVO.getDmdtTrfCd());
                overdayNDivParmVO.setLocDiv(tempInvoiceIssueVO.getDmdtChgLocDivCd());
                overdayNDivParmVO.setDccSeq(tempInvoiceIssueVO.getChgSeq());
                
                // DivOverDay 조회
                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);            	
            	
                String trfAplyTpCd = tempInvoiceIssueVO.getDmdtTrfAplyTpCd();
				
				CalculationParmVO calculationParmVO = new CalculationParmVO();
				calculationParmVO.setDcApplRate(trfAplyTpCd);
				calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
				calculationParmVO.setFtDys(tempInvoiceIssueVO.getFtDys());				// 2014.03.12
				calculationParmVO.setFmMvmtYdCd(tempInvoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
				calculationParmVO.setOrgFtOvrDys(tempInvoiceIssueVO.getOrgFtOvrDys());	// 2014.03.12
				
				/*
				Charge에 적용된 Tariff에 따라 Charge금액을 계산한다.
			    A) "G"(Basic Tariff)인 경우 Basic Tariff의 Rate별 계산금액을 조회한다
			    B) "B"(Before Exception)인 경우 Before Exception Tariff의 Rate별 계산금액을 조회하고 Before Exception의 Currency를 조회한다
			    C) "S"(S/C Exception)인 경우 S/C Exception Tariff의 Rate별 계산금액을 조회하고 S/C Exception의 Currency를 조회한다
			    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
			         1) 적용된 CurrencyExchange Rate를 조회하여 Charge 계산금액을 Exchange Rate를 곱한다
			         2) 1)에서 계산한 금액을 Currency별로 반올림처리 한다
				*/
				if(trfAplyTpCd.equals("G")) {
					String firstSvrID = null;
					
					//office transfer check
	            	if(tempInvoiceIssueVO.getOfcTrnsFlg().equals("Y")){
	            		
	            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	            		chargeCalculationParmVO.setDmdtTrfCd(tempInvoiceIssueVO.getDmdtTrfCd());
	            		chargeCalculationParmVO.setDmdtChgLocDivCd(tempInvoiceIssueVO.getDmdtChgLocDivCd());
	            		chargeCalculationParmVO.setCntrNo(tempInvoiceIssueVO.getCntrNo());
	            		chargeCalculationParmVO.setCntrCycNo(tempInvoiceIssueVO.getCntrCycNo());
	            		chargeCalculationParmVO.setSvrId(tempInvoiceIssueVO.getSvrId());
	            		chargeCalculationParmVO.setBkgNo(tempInvoiceIssueVO.getBkgNo());
	            		chargeCalculationParmVO.setFmMvmtYdCd(tempInvoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
	            		
	    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	            	}else{
	            		firstSvrID = tempInvoiceIssueVO.getSvrId();
	            	}
					
					// basicCalculation - Baisc Tariff
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(tempInvoiceIssueVO.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(tempInvoiceIssueVO.getBzcTrfSeq());
					calculationParmVO.setDmdtDeTermCd(tempInvoiceIssueVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					calculationParmVO.setTrfGrpSeq(tempInvoiceIssueVO.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
					calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
					calculationParmVO.setCurCd(tempInvoiceIssueVO.getBzcTrfCurrCd());
					calculationParmVO.setTrfAplyDt(tempInvoiceIssueVO.getBzcTrfAplyDt());			// 2014.03.12
					if (!"".equals(tempInvoiceIssueVO.getScRfaExptAplyDt())) {		// 2014.03.12
						calculationParmVO.setDmdtTrfAplyTpCd("B");									
						calculationParmVO.setTrfAplyDt(tempInvoiceIssueVO.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
					} else {
						calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
					}
				} else if(trfAplyTpCd.equals("B")) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(tempInvoiceIssueVO.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(tempInvoiceIssueVO.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(tempInvoiceIssueVO.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(tempInvoiceIssueVO.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
					calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
					calculationParmVO.setTrfAplyDt(tempInvoiceIssueVO.getScRfaExptAplyDt());// 2014.03.12
				} else if(trfAplyTpCd.equals("S")) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(tempInvoiceIssueVO.getScNo());
					calculationParmVO.setVerSeq(tempInvoiceIssueVO.getScExptVerSeq());
					calculationParmVO.setGrpSeq(tempInvoiceIssueVO.getScExptGrpSeq());
					calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
					calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());					
					calculationParmVO.setTrfAplyDt(tempInvoiceIssueVO.getScRfaExptAplyDt());// 2014.03.12
				}
				
				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
	            
	            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
	            String rateCurrCd = calculationAMTVO.getRateCurCd();
	            double rtExchangeRate 	= 0;
	            inv_chg_tot 			= 0;
	            
	            if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
	            	
	            	//Total Amt
	            	inv_chg_tot = NumberUtils.toDouble(calculationAMTVO.getTotal());
	            	
	            	//rate CurrCd와 charge CurrCd가 다르면 rateCrrCd를 곱해서 charge amt를 구한다.
	            	if(!rateCurrCd.equals(chargeBookingInvoiceVO.getChgCurrCd())){
	            		exchangeRateParmVO = new ExchangeRateParmVO();
	                    
	                    exchangeRateParmVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0,4));
	                    exchangeRateParmVO.setSkdVoyageNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
	                    exchangeRateParmVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8));
	                    exchangeRateParmVO.setIoBnd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
	                    exchangeRateParmVO.setPolLoc(chargeBookingInvoiceVO.getPolCd());
	                    exchangeRateParmVO.setPodLoc(chargeBookingInvoiceVO.getPodCd()); 
	                    exchangeRateParmVO.setFmCurCd(rateCurrCd);								//rate currency
	                    exchangeRateParmVO.setToCurCd(chargeBookingInvoiceVO.getChgCurrCd());	//chg currency
	                    exchangeRateParmVO.setOfcCd(issuedInvoiceParamVO.getSOfcCd());		//charge office
	                    log.debug("---VSLCD -->"+chargeBookingInvoiceVO.getVvdCd().substring(0,4));
	                    log.debug("---SKDVOYAGENO -->"+chargeBookingInvoiceVO.getVvdCd().substring(4,8));
	                    log.debug("---SKDDIRCD -->"+chargeBookingInvoiceVO.getVvdCd().substring(8));
	                    log.debug("---IOBND -->"+chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
	                    log.debug("---POLLOC -->"+chargeBookingInvoiceVO.getPolCd());
	                    log.debug("---PODLOC -->"+chargeBookingInvoiceVO.getPolCd());
	                    log.debug("---FMCURCD -->"+rateCurrCd);
	                    log.debug("---TOCURCD -->"+chargeBookingInvoiceVO.getChgCurrCd());
	                    log.debug("---OFCCD -->"+chargeBookingInvoiceVO.getChgCurrCd());
	                    
	                    rtExchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
	            		
	                    inv_chg_tot = rtExchangeRate * inv_chg_tot;
	                    inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(rateCurrCd,inv_chg_tot);
	                    
	                    log.debug("---rate Currency -->"+rateCurrCd);
	                    log.debug("---rate Exchange Rate-->"+rtExchangeRate);
	                    log.debug("---org_chg_tot-->"+inv_chg_tot);
	            	}
	            }
	            //charge total amt
	            
            	//invoice total amt
	            inv_chg_tot = exchangeRate * inv_chg_tot;
	            inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_chg_tot);
            	tempInvoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(inv_chg_tot, "#.##"));
            	
                log.debug("---exchangeRate-->"+exchangeRate);
                log.debug("---inv_chg_tot-->"+inv_chg_tot);

                totAmt += inv_chg_tot;
            	
            	//inv_chg_tot, inv_bill_amt 저장
            	invoiceIssueList.set(i, tempInvoiceIssueVO);
            }
            
            //Cust. Ref 정보 조회(2010.11.04)
            if(invoiceIssueList.size() > 0) {
	            //cntr_no list
	            cntr_nos = sb_cntr_no.toString();
	            
	            List<String> po_numbers = dbDao.searchBookingContainerPONumber(bkg_no, cntr_nos);
	            
	            if(po_numbers.size() == 1) {
	            	po_number = po_numbers.get(0).toString();
	            } else { //size == 0 OR size > 1 
	            	po_number = "";
	            }
            }
            chargeBookingInvoiceVO.setInvRefNo(po_number);
            
            totAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totAmt);
			chargeBookingInvoiceVO.setTotAmt(JSPUtil.toDecimalFormat(totAmt, "#.##"));
log.debug("\n--------------------------------2------Total Amt--------------------"+totAmt);         
			
			totBillAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totBillAmt);
			chargeBookingInvoiceVO.setInvChgAmt(JSPUtil.toDecimalFormat(totBillAmt, "#.##"));

log.debug("\n--------------------------------3----------Billing amt----------------"+totBillAmt);         

			//D/C by Amt
			double dcAmt = 0;
			
			dcAmt = totAmt - totBillAmt;
			
			dcAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),dcAmt);
			chargeBookingInvoiceVO.setDcAmt(JSPUtil.toDecimalFormat(dcAmt, "#.##"));
log.debug("\n--------------------4----------D/C by Amt----------------"+dcAmt);         

            //Tax Amt
            double taxAmt = 0;
            double taxRto = Double.parseDouble(chargeBookingInvoiceVO.getTaxRto());
log.debug("\n--------------------------------5----------tax_rto----------------"+taxRto);         
            
            //베트남 이면
            if(account.getCnt_cd().equals("VN")) {
                taxAmt = (totBillAmt / (1 - taxRto * 0.01)) * (taxRto * 0.01);
            }else{
                taxAmt = (totBillAmt * (taxRto * 0.01)) ;
            }
            taxAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),taxAmt);
            
log.debug("\n--------------------------------6----------tax_amt----------------"+taxAmt);         
            
			chargeBookingInvoiceVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));
            
            //Payable Amt
            double invAmt = 0;
            invAmt = totBillAmt + taxAmt;
            
            invAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),invAmt);
            chargeBookingInvoiceVO.setInvAmt(JSPUtil.toDecimalFormat(invAmt, "#.##"));

log.debug("\n--------------------------------7-----------Payable Amt---------------"+invAmt);         
            
//log.debug("\n--------------------------------8--------------------------");         

            //Invoice Data 초기화
            chargeBookingInvoiceVO.setDmdtInvNo("");
            chargeBookingInvoiceVO.setCreDt("");
            chargeBookingInvoiceVO.setCreOfcCd("");
            chargeBookingInvoiceVO.setCreUsrId("");
            chargeBookingInvoiceVO.setCreUsrNm("");
            chargeBookingInvoiceVO.setUpdUsrId("");
            chargeBookingInvoiceVO.setUpdUsrNm("");
            chargeBookingInvoiceVO.setDmdtInvStsCd("");
            chargeBookingInvoiceVO.setDmdtInvStsNm("");
            chargeBookingInvoiceVO.setDmdtArIfCd("");
            chargeBookingInvoiceVO.setArIfDt("");
            chargeBookingInvoiceVO.setArIfOfcCd("");
            chargeBookingInvoiceVO.setArIfUsrId("");
            chargeBookingInvoiceVO.setArIfUsrNm("");
            chargeBookingInvoiceVO.setCrInvNo("");
            chargeBookingInvoiceVO.setInvRmk("");
            chargeBookingInvoiceVO.setInvRmk1("");
            chargeBookingInvoiceVO.setInvRmk2("");
            chargeBookingInvoiceVO.setPayrCntcPntPhnNo("");
            chargeBookingInvoiceVO.setPayrCntcPntFaxNo("");
            chargeBookingInvoiceVO.setPayrCntcPntEml("");
            chargeBookingInvoiceVO.setOverDay("");
            chargeBookingInvoiceVO.setAftInvAdjAmt("0");
            chargeBookingInvoiceVO.setCrArYn("");
            chargeBookingInvoiceVO.setInvPrtFlg("");
            chargeBookingInvoiceVO.setCustCntcPntSeq("");
            chargeBookingInvoiceVO.setDmdtPayrCntcPntNm("");
            chargeBookingInvoiceVO.setColDate("");
//            chargeBookingInvoiceVO.setTaaNo("");
            chargeBookingInvoiceVO.setColAmt(String.valueOf(invAmt));
            chargeBookingInvoiceVO.setColCharge("0");
            chargeBookingInvoiceVO.setColTax("0");
            
            // Mgt Setting
            invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
            invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);

        } 
        catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
        catch(Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        return invoiceIssueMgtVO;
        
    }

    /**
    * [Outstanding Inquiry by Customer N Issue]을 [SEARCH] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryBySummaryVO>
    * @exception EventException
    */
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryBySummaryList ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    }
    
    
    /**
     * [Outstanding Inquiry by Customer N Issue for Sales Rep]을 [SEARCH] 합니다.<br>
     * 
     * @param OtsInquiryParm2VO otsInquiryParm2VO
     * @return List<OtsInquiryBySummaryVO>
     * @exception EventException
     */
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList2 ( OtsInquiryParm2VO otsInquiryParm2VO ) throws EventException {
    	try {
    		return dbDao.searchOTSInquiryBySummaryList2 ( otsInquiryParm2VO );
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
    		throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
    	} catch (Exception ex) {
    		log.error("[Exception]"+ex.getMessage());
    		throw new EventException(ex.getMessage(),ex);
    	}
    }
    
   /**
    * [TAB1:A/R Interface Status Inquiry By DMT]을 [조회]합니다.<br>
    * 
    * @param ARInterfaceParmVO arInterfaceParmVO
    * @return List<ARInterfaceStatusVO>
    * @exception EventException
    */
	public List<ARInterfaceStatusVO> searchARInterfaceStatusByDMT ( ARInterfaceParmVO arInterfaceParmVO ) throws EventException {
         try {
             arInterfaceParmVO.setFmDt(arInterfaceParmVO.getFmDt().replaceAll("-", ""));
             arInterfaceParmVO.setToDt(arInterfaceParmVO.getToDt().replaceAll("-", ""));
             return dbDao.searchARInterfaceStatusByDMT ( arInterfaceParmVO );
         } catch (DAOException ex) {
        	 log.error("[DAOException]"+ex.getMessage());
             throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
         } catch (Exception ex) {
        	 log.error("[Exception]"+ex.getMessage());
        	 throw new EventException(ex.getMessage(),ex);
 		}
     }
     
   /**
    * [TAB2:A/R Interface Status Inquiry By BKG]을 [조회]합니다.<br>
    * 
    * @param ARInterfaceParmVO arInterfaceParmVO
    * @return List<ARInterfaceStatusVO>
    * @exception EventException
    */
	public List<ARInterfaceStatusVO> searchARInterfaceStatusByBKG ( ARInterfaceParmVO arInterfaceParmVO ) throws EventException {
		try {
			arInterfaceParmVO.setFmDtT2(arInterfaceParmVO.getFmDtT2().replaceAll("-", ""));
			arInterfaceParmVO.setToDtT2(arInterfaceParmVO.getToDtT2().replaceAll("-", ""));
          	
			return dbDao.searchARInterfaceStatusByBKG ( arInterfaceParmVO );
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
      
   /**
    * [Invoice Interface to A/R]을 [조회]합니다.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @return List<InvoiceInterfaceARBySummaryVO>
    * @exception EventException
    */
	public List<InvoiceInterfaceARBySummaryVO> searchInvoiceInterfaceARBySummary (InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO) throws EventException {
        try {
        	invoiceInterfaceARParmVO.setFmDt(invoiceInterfaceARParmVO.getFmDt().replaceAll("-", ""));
        	invoiceInterfaceARParmVO.setToDt(invoiceInterfaceARParmVO.getToDt().replaceAll("-", ""));
            return dbDao.searchInvoiceInterfaceARBySummary ( invoiceInterfaceARParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
        
   /**
	* [Invoice Interface to A/R - Detail]을 [조회]합니다.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @param SignOnUserAccount account
    * @return List<InvoiceInterfaceARByDetailVO>
    * @exception EventException
    */
	public List<InvoiceInterfaceARByDetailVO> searchInvoiceInterfaceARByDetail (InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchInvoiceInterfaceARByDetail ( invoiceInterfaceARParmVO, account );
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}        
    
    /**
     * [Invoice]을 [ISSUE] 합니다.<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException {
        ChargeBookingInvoiceVO chgBkgInvVO = new ChargeBookingInvoiceVO();
        List<InvoiceIssueVO> invoiceIssueList = null;
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
    	
        try {
        	String currOfcDt = dbDao.searchCurrentDateByOffice(account.getOfc_cd());
        	
            chgBkgInvVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();

            if (StringUtils.isEmpty(chgBkgInvVO.getInvCurrCd())) {
            	dmtInvMnVO.setErrCode("DMT02002");
            	log.error("\n BC session office cd >>>>"+account.getOfc_cd()+"<<<<");
            	log.error("\n BC InvCurrCd >>>>"+chgBkgInvVO.getInvCurrCd()+"<<<<");
            	log.error("\n BC DMT02002 ERROR [Inv Cur. is missing !]");

            	return dmtInvMnVO;
            }
          
            if (StringUtils.isEmpty(chgBkgInvVO.getBlNo())) {
             	 String bl_no = dbDao.searchBKGBlNo(chgBkgInvVO.getBkgNo());
             	 
             	 if (StringUtils.isEmpty(bl_no)) {
             		 dmtInvMnVO.setErrCode("DMT01152");
             		 log.error("\n BC bkg_no >>>>"+chgBkgInvVO.getBkgNo()+"<<<<");
             		 log.error("\n BC DMT01152 ERROR [There is no B/L No.]");
             		 return dmtInvMnVO;
             	 }
             	 else {
             		chgBkgInvVO.setBlNo(bl_no);
             	 }
            }
            
            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
            invoiceNoGenCondVO.setDmdtTrfCd(chgBkgInvVO.getDmdtTrfCd());
            // [ Invoice No. 채번 로직 실행 ]==========================================================
            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
            // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
            if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
            	dmtInvMnVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
            	
            	return dmtInvMnVO;
            }
            //=========================================================================================
            String dmdtInvNo = invoiceNoGenVO.getDmdtInvNo();
            
            // addInvoiceMain
            dmtInvMnVO.setDmdtInvNo(dmdtInvNo);
            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
            dmtInvMnVO.setDmdtTrfCd(chgBkgInvVO.getDmdtTrfCd());
            dmtInvMnVO.setIoBndCd(chgBkgInvVO.getDmdtTrfCd().substring(2, 3));//dmif
            dmtInvMnVO.setDmdtChgTpCd(chgBkgInvVO.getChgType());
            dmtInvMnVO.setMnlInpFlg("N");
            dmtInvMnVO.setMnlInvSndFlg("N");
            dmtInvMnVO.setMnlInvRmk("");
            dmtInvMnVO.setDmdtMnlInvRsnCd("");
            dmtInvMnVO.setBkgNo(chgBkgInvVO.getBkgNo());
            dmtInvMnVO.setBlNo(chgBkgInvVO.getBlNo()); 

			String vvdCd = chgBkgInvVO.getVvdCd();
			if (StringUtils.isEmpty(vvdCd)) {
				dmtInvMnVO.setVslCd("");
				dmtInvMnVO.setSkdVoyNo("");
				dmtInvMnVO.setSkdDirCd("");			
			}
			else if (vvdCd.startsWith("HJXX") || vvdCd.startsWith("HJYY") || vvdCd.startsWith("HJZZ")) {
                dmtInvMnVO.setVslCd("CFDR");
                dmtInvMnVO.setSkdVoyNo(currOfcDt.substring(2,6));
                dmtInvMnVO.setSkdDirCd("E");
			}
			else {
				dmtInvMnVO.setVslCd(chgBkgInvVO.getVvdCd().substring(0,4));
				dmtInvMnVO.setSkdVoyNo(chgBkgInvVO.getVvdCd().substring(4,8));
				dmtInvMnVO.setSkdDirCd(chgBkgInvVO.getVvdCd().substring(8));
			}
			
            dmtInvMnVO.setDmdtPayrTpCd("");
        	if (chgBkgInvVO.getPayerCd().length() <= 6) {
                dmtInvMnVO.setActPayrCntCd("00");
                dmtInvMnVO.setActPayrSeq(chgBkgInvVO.getPayerCd());
                
                //cust
                dmtInvMnVO.setCustCntCd("00");
                dmtInvMnVO.setCustSeq(chgBkgInvVO.getPayerCd());
        	}
			else {
                dmtInvMnVO.setActPayrCntCd(chgBkgInvVO.getPayerCd().substring(0, 2));
                dmtInvMnVO.setActPayrSeq(chgBkgInvVO.getPayerCd().substring(2));
                
                //cust
                dmtInvMnVO.setCustCntCd(chgBkgInvVO.getPayerCd().substring(0, 2));
                dmtInvMnVO.setCustSeq(chgBkgInvVO.getPayerCd().substring(2));
        	}
            
            dmtInvMnVO.setDmdtPayrCntcPntNm(JSPUtil.getNull(chgBkgInvVO.getDmdtPayrCntcPntNm()));
            dmtInvMnVO.setCustCntcPntSeq(JSPUtil.getNull(chgBkgInvVO.getCustCntcPntSeq()));
            dmtInvMnVO.setPorCd(chgBkgInvVO.getPorCd());
            dmtInvMnVO.setPolCd(chgBkgInvVO.getPolCd());
            dmtInvMnVO.setPodCd(chgBkgInvVO.getPodCd());
            dmtInvMnVO.setDelCd(chgBkgInvVO.getDelCd());
            dmtInvMnVO.setScNo(chgBkgInvVO.getScNo());
            dmtInvMnVO.setRfaNo(chgBkgInvVO.getRfaNo());
            dmtInvMnVO.setChgCurrCd(chgBkgInvVO.getChgCurrCd());
            dmtInvMnVO.setOrgChgAmt(chgBkgInvVO.getMnOrgChgAmt());
            dmtInvMnVO.setDmdtExptAmt(chgBkgInvVO.getDmdtExptAmt());
            dmtInvMnVO.setDcAmt(chgBkgInvVO.getChgDcAmt());
            dmtInvMnVO.setBilAmt(chgBkgInvVO.getMnBilAmt());
            dmtInvMnVO.setBkgCntrQty(chgBkgInvVO.getCntrCnt());
            dmtInvMnVO.setInvCurrCd(chgBkgInvVO.getInvCurrCd());
            dmtInvMnVO.setInvXchRt(chgBkgInvVO.getInvXchRt());
            dmtInvMnVO.setInvChgAmt(chgBkgInvVO.getInvChgAmt());
            dmtInvMnVO.setTaxRto(chgBkgInvVO.getTaxRto());
            dmtInvMnVO.setTaxAmt(chgBkgInvVO.getTaxAmt());
            dmtInvMnVO.setInvAmt(chgBkgInvVO.getInvAmt());
            dmtInvMnVO.setAftExptAproNo("");
            dmtInvMnVO.setAftInvAdjAmt(chgBkgInvVO.getAftInvAdjAmt());
            dmtInvMnVO.setCrInvNo("");
            dmtInvMnVO.setInvRmk1(chgBkgInvVO.getInvRmk1());
            dmtInvMnVO.setInvRmk2(chgBkgInvVO.getInvRmk2());
            dmtInvMnVO.setDmdtArIfCd("N");
            dmtInvMnVO.setArIfNo("");
            dmtInvMnVO.setArIfDt("");
            dmtInvMnVO.setArIfUsrId("");
            dmtInvMnVO.setArIfOfcCd("");
            dmtInvMnVO.setDmdtInvStsCd("I");
            dmtInvMnVO.setDmdtCxlRsnCd("");
            dmtInvMnVO.setCxlRmk("");
            dmtInvMnVO.setInvHldRsnCd("");
            dmtInvMnVO.setInvHldRmk("");
            dmtInvMnVO.setInvPrtFlg("");
            dmtInvMnVO.setInvRefNo(chgBkgInvVO.getInvRefNo());
            dmtInvMnVO.setCreUsrId(account.getUsr_id());
            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
            dmtInvMnVO.setNtcKntCd(chgBkgInvVO.getNtcKntCd());
            
            log.debug(">>>>>>>>>>>>>[rd]"+chgBkgInvVO.getRd());
            
            if (!chgBkgInvVO.getRd().equals("/")) {
	            dmtInvMnVO.setRcvTermCd(chgBkgInvVO.getRd().substring(0, 1)); // Y/Y
	            dmtInvMnVO.setDeTermCd(chgBkgInvVO.getRd().substring(2));
            }
            dmtInvMnVO.setInvNewRptFlg(chgBkgInvVO.getInvNewRptFlg());
            
            String usrCntCd = new CommonFinderBCImpl().searchUserCntCode(account.getOfc_cd());
            if ("IN".equals(usrCntCd)) {
            	// 인도 OFC 에서 발행하는 invoice 는 Tax Ratio 를 OFC 단위로 가지지 않고, 지정된 아래 Ratio 를 사용한다.
            	dmtInvMnVO.setTaxRto("");
            	
	            // [ INDIA TAX 변경 전 ]            
	            if ("B".equals(chgBkgInvVO.getIdaTaxApplTm())) {
		            dmtInvMnVO.setIdaExpnTaxRt(chgBkgInvVO.getIdaExpnTaxRt());
		            dmtInvMnVO.setIdaExpnTax(chgBkgInvVO.getIdaExpnTax());
		            dmtInvMnVO.setIdaEduTaxRt(chgBkgInvVO.getIdaEduTaxRt());
		            dmtInvMnVO.setIdaEduTax(chgBkgInvVO.getIdaEduTax());
		            dmtInvMnVO.setIdaHighEduTaxRt(chgBkgInvVO.getIdaHighEduTaxRt());
		            dmtInvMnVO.setIdaHighEduTax(chgBkgInvVO.getIdaHighEduTax());
		            dmtInvMnVO.setIdaLoclTaxRt(chgBkgInvVO.getIdaLoclTaxRt());
		            dmtInvMnVO.setIdaLoclTax(chgBkgInvVO.getIdaLoclTax());
		            dmtInvMnVO.setIdaN2ndLoclTaxRt(chgBkgInvVO.getIdaN2ndLoclTaxRt());
		            dmtInvMnVO.setIdaN2ndLoclTax(chgBkgInvVO.getIdaN2ndLoclTax());
	            }
	            // [ INDIA TAX 변경 후 ]
		        else { 
		            dmtInvMnVO.setIdaCgstRto(chgBkgInvVO.getIdaCgstRto());
		            dmtInvMnVO.setIdaCgstAmt(chgBkgInvVO.getIdaCgstAmt());
		            dmtInvMnVO.setIdaSgstRto(chgBkgInvVO.getIdaSgstRto());
		            dmtInvMnVO.setIdaSgstAmt(chgBkgInvVO.getIdaSgstAmt());
		            dmtInvMnVO.setIdaIgstRto(chgBkgInvVO.getIdaIgstRto());
		            dmtInvMnVO.setIdaIgstAmt(chgBkgInvVO.getIdaIgstAmt());
		            dmtInvMnVO.setIdaUgstRto(chgBkgInvVO.getIdaUgstRto());
		            dmtInvMnVO.setIdaUgstAmt(chgBkgInvVO.getIdaUgstAmt());
		        }
            }
            dmtInvMnVO.setTaaNo(chgBkgInvVO.getTaaNo());

            dbDao.addInvoiceMain(dmtInvMnVO);
            
            //addInvoiceDetail
            invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            String	ftDys = "0";
        	String	fmMvmtYdCd = "";
        	String	bzcTrfAplyDt = "";
        	
            for (int i = 0 ; i < invoiceIssueList.size() ; i++) {
                InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
                
                if (!"U".equals(invoiceIssueParam.getIbflag())) continue;
                
                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
                dmtInvDtlVO.setSvrId(invoiceIssueParam.getSvrId());
                dmtInvDtlVO.setCntrNo(invoiceIssueParam.getCntrNo());
                dmtInvDtlVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
                dmtInvDtlVO.setChgSeq(invoiceIssueParam.getChgSeq());
                
                ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
                chargeCalculationContainerVO = dbDao.searchChargeStatusCd(dmtInvDtlVO);
                String chgStsCd = chargeCalculationContainerVO.getDmdtChgStsCd();
                ftDys = chargeCalculationContainerVO.getFtDys();
                fmMvmtYdCd = chargeCalculationContainerVO.getFmMvmtYdCd();
                bzcTrfAplyDt = chargeCalculationContainerVO.getBzcTrfAplyDt();	
                if ("I".equals(chgStsCd)) {
                	dmtInvMnVO.setErrCode("DMT01068");//It's already invoiced. You can't [Value] it !
                	return dmtInvMnVO;
                }
                int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(dmdtInvNo, account.getOfc_cd());

                double cntr_inv_amt = 0;
                cntr_inv_amt = Double.parseDouble(chgBkgInvVO.getInvXchRt()) * Double.parseDouble(invoiceIssueParam.getBilAmt());
                cntr_inv_amt = dmtCalculationUtil.trimCurrencyAmount(chgBkgInvVO.getInvCurrCd(), cntr_inv_amt);
                double taxAmt = 0;
                double taxRto = Double.parseDouble(chgBkgInvVO.getTaxRto());
                
                if ("VN".equals(account.getCnt_cd())) {
                	taxAmt = (cntr_inv_amt / (1 - taxRto * 0.01)) * (taxRto * 0.01);
                } 
                else {
                    taxAmt = cntr_inv_amt * taxRto * 0.01;
                }
                taxAmt = dmtCalculationUtil.trimCurrencyAmount(chgBkgInvVO.getInvCurrCd(), taxAmt);
                
                dmtInvDtlVO.setDmdtInvNo(dmdtInvNo);
                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
                dmtInvDtlVO.setInvDtlSeq(String.valueOf(inv_dtl_seq));
                dmtInvDtlVO.setCntrTpszCd(invoiceIssueParam.getCntrTpszCd());
                dmtInvDtlVO.setFmMvmtDt(invoiceIssueParam.getFmMvmtDt());
                dmtInvDtlVO.setToMvmtDt(invoiceIssueParam.getToMvmtDt());
                dmtInvDtlVO.setFtDys(invoiceIssueParam.getFtDys());
                dmtInvDtlVO.setFtCmncDt(invoiceIssueParam.getFtCmncDt());
                dmtInvDtlVO.setFtEndDt(invoiceIssueParam.getFtEndDt());
                dmtInvDtlVO.setFxFtOvrDys(invoiceIssueParam.getFxFtOvrDys());
                dmtInvDtlVO.setOrgChgAmt(invoiceIssueParam.getOrgChgAmt());
                dmtInvDtlVO.setScRfaExptAmt(invoiceIssueParam.getExptAmt());
                dmtInvDtlVO.setAftExptDcAmt(invoiceIssueParam.getAftExptDcAmt());
                dmtInvDtlVO.setBilAmt(invoiceIssueParam.getBilAmt());
                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntr_inv_amt, "#.##"));
                dmtInvDtlVO.setTaxRto(chgBkgInvVO.getTaxRto());
                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));
                dmtInvDtlVO.setInvPrtFlg("");
                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
                
                dbDao.addInvoiceDetail(dmtInvDtlVO);
                
                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
                overdayNDivParmVO.setSvrId(invoiceIssueParam.getSvrId());
                overdayNDivParmVO.setCntrNo(invoiceIssueParam.getCntrNo());
                overdayNDivParmVO.setCnmvCycNo(invoiceIssueParam.getCntrCycNo());
                overdayNDivParmVO.setDttCode(invoiceIssueParam.getDmdtTrfCd());
                overdayNDivParmVO.setLocDiv(invoiceIssueParam.getDmdtChgLocDivCd());
                overdayNDivParmVO.setDccSeq(invoiceIssueParam.getChgSeq());
                
                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
                
				CalculationParmVO calculationParmVO = new CalculationParmVO();
				
				String trfAplyTpCd = invoiceIssueParam.getDmdtTrfAplyTpCd();
				calculationParmVO.setDcApplRate(trfAplyTpCd);
				
				calculationParmVO.setSvrId(invoiceIssueParam.getSvrId());
				calculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
				calculationParmVO.setTrfSeq(invoiceIssueParam.getBzcTrfSeq());
				calculationParmVO.setDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
				calculationParmVO.setTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
				calculationParmVO.setOverDay(invoiceIssueParam.getOrgFtOvrDys());
				calculationParmVO.setCurCd(invoiceIssueParam.getBzcTrfCurrCd());
				
				calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
				calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
				calculationParmVO.setFtDys(ftDys);											// 2014.03.12
				calculationParmVO.setFmMvmtYdCd(fmMvmtYdCd);								// 2014.03.12
				calculationParmVO.setTrfAplyDt(bzcTrfAplyDt);								// 2014.03.12
				calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);									// 2014.03.12
				
				calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());

				/*
				Charge에 적용된 Tariff에 따라 Charge금액을 계산한다.
			    A) "G"(Basic Tariff)인 경우 Basic Tariff의 Rate별 계산금액을 조회한다
			    B) "B"(Before Exception)인 경우 Before Exception Tariff의 Rate별 계산금액을 조회하고 Before Exception의 Currency를 조회한다
			    C) "S"(S/C Exception)인 경우 S/C Exception Tariff의 Rate별 계산금액을 조회하고 S/C Exception의 Currency를 조회한다
			    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
			         1) 적용된 CurrencyExchange Rate를 조회하여 Charge 계산금액을 Exchange Rate를 곱한다
			         2) 1)에서 계산한 금액을 Currency별로 반올림처리 한다
				*/
				if ("G".equals(trfAplyTpCd)) {
					String firstSvrID = null;
					
					//office transfer check
	            	if ("Y".equals(invoiceIssueParam.getOfcTrnsFlg())) {
	            		
	            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
	            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
	            		chargeCalculationParmVO.setCntrNo(invoiceIssueParam.getCntrNo());
	            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
	            		chargeCalculationParmVO.setSvrId(invoiceIssueParam.getSvrId());
	            		chargeCalculationParmVO.setBkgNo(invoiceIssueParam.getBkgNo());
	            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueParam.getFmMvmtYdCd()); //2011.10.28
	            		
	    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	            	} 
	            	else {
	            		firstSvrID = invoiceIssueParam.getSvrId();
	            	}
					
					// basicCalculation - Baisc Tariff
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(invoiceIssueParam.getBzcTrfSeq());
					calculationParmVO.setDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					calculationParmVO.setTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
					calculationParmVO.setCurCd(invoiceIssueParam.getBzcTrfCurrCd());
					calculationParmVO.setTrfAplyDt(invoiceIssueParam.getBzcTrfAplyDt());			// 2014.03.12
					if (!"".equals(invoiceIssueParam.getScRfaExptAplyDt())) {		// 2014.03.12
						calculationParmVO.setDmdtTrfAplyTpCd("B");									
						calculationParmVO.setTrfAplyDt(invoiceIssueParam.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
					} 
					else {
						calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
					}
				} 
				else if ("B".equals(trfAplyTpCd)) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(invoiceIssueParam.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(invoiceIssueParam.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(invoiceIssueParam.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(invoiceIssueParam.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
					calculationParmVO.setTrfAplyDt(invoiceIssueParam.getScRfaExptAplyDt());// 2014.03.12
				} 
				else if ("S".equals(trfAplyTpCd)) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(invoiceIssueParam.getScNo());
					calculationParmVO.setVerSeq(invoiceIssueParam.getScExptVerSeq());
					calculationParmVO.setGrpSeq(invoiceIssueParam.getScExptGrpSeq());
					calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());					
					calculationParmVO.setTrfAplyDt(invoiceIssueParam.getScRfaExptAplyDt());// 2014.03.12
				}

				//bbsChargeCalulation Input
				log.debug("\n basicCalculation.......................");				
				log.debug("\n svr_id 			= "+invoiceIssueParam.getSvrId());				
				log.debug("\n dmdt_trf_cd 		= "+invoiceIssueParam.getDmdtTrfCd());				
				log.debug("\n bzc_trf_seq 		= "+invoiceIssueParam.getBzcTrfSeq());
				log.debug("\n dmdt_de_term_cd 	= "+invoiceIssueParam.getBzcDmdtDeTermCd());
				log.debug("\n bzc_trf_grp_seq 	= "+invoiceIssueParam.getBzcTrfGrpSeq());				
				log.debug("\n cntr_tpsz_cd 		= "+invoiceIssueParam.getCntrTpszCd());				
				log.debug("\n org_ft_ovr_dys 	= "+invoiceIssueParam.getOrgFtOvrDys());				
				log.debug("\n div_over_day 		= "+overdayNDivVO.getDivOverDay());				
				log.debug("\n bzc_trf_curr_cd 	= "+invoiceIssueParam.getBzcTrfCurrCd());
				log.debug("\n getFtDys 			= "+ftDys);									// 2014.03.12
				log.debug("\n getFmMvmtYdCd 	= "+fmMvmtYdCd);							// 2014.03.12
				log.debug("\n getBzcTrfAplyDt	= "+bzcTrfAplyDt);							// 2014.03.12
				log.debug("\n setDmdtTrfAplyTpCd= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
				

				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);      
                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
	                
                if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
                	
                	//addInvoiceRate
                	for (ChrgDtlVO chrgDtlVO : chrgDtlVOS) {
	                    
	                    if (Double.parseDouble(chrgDtlVO.getRtDay()) == 0) continue;
	                    
	                    DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
	                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
	                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
	                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
	                    
	                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
	                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
	                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
	                    dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
	                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
	                    dmtInvRtVO.setBzcTrfRtSeq("");
	                    
	                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
	                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
	                    
	                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());

	                    double inv_rt_amt = 0;
	                    inv_rt_amt = Double.parseDouble(chrgDtlVO.getRtRate());
	                    dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(inv_rt_amt, "#.##"));
	                    
	                    double rt_ovr_chg_amt = 0;
	                    rt_ovr_chg_amt = Double.parseDouble(chrgDtlVO.getRtChrg());
	                    dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));
	                    
	                    dmtInvRtVO.setBzcCurrCd(invoiceIssueParam.getBzcTrfCurrCd());
	                    
	                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
	                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
	                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
	                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
	                    
	                    dbDao.addInvoiceRate(dmtInvRtVO);
                	}
                }
	                
                //======================================================
                //Discount Amount + Exception Amount > 0
                double dScRfaExptAmt = Double.parseDouble(invoiceIssueParam.getExptAmt());
                double dAftExptDcAmt = Double.parseDouble(invoiceIssueParam.getAftExptDcAmt());
                double dCmdtExptAmt  = Double.parseDouble(invoiceIssueParam.getCmdtExptAmt());
	                
                if(( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt != 0) && trfAplyTpCd.equals("G")) {
                	double rt_ovr_chg_amt = 0;
                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
                
	                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
	                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
	                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
	                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
	                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
	                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
	                dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
	                dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
	                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
	                dmtInvRtVO.setBzcTrfRtSeq("");
	                dmtInvRtVO.setFtOvrDys("0");
	                dmtInvRtVO.setFtUndDys("0");
	                dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));
	                dmtInvRtVO.setRtOvrDys("1");
	                dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));
	                dmtInvRtVO.setBzcCurrCd(invoiceIssueParam.getBzcTrfCurrCd());
	                dmtInvRtVO.setCreUsrId(account.getUsr_id());
	                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
	                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
	                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
	                
	                dbDao.addInvoiceRate(dmtInvRtVO);
                }
   			}

            dmtInvMnVO.setErrCode("DMT03064");
            
            return dmtInvMnVO;
        } 
		catch (DAOException ex) {
        	log.error("BC DAOException ERROR " + ex.toString());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } 
		catch (Exception de) {
            log.error("BC Exception ERROR " + de.toString());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    }       
       
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO>
    * @exception EventException
    */
    public List<OtsInquiryByDetialVO> searchOTSInquiryByDetailList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
    	List<OtsInquiryByDetialVO> OtsInquiryByDetialVOList = null;
    	
        try {
        	OtsInquiryByDetialVOList = dbDao.searchOTSInquiryByDetailList ( otsInquiryParmVO );
        	
        	// 揶쏉옙Invoice 占쏙옙占쎈뗀�껓옙占썼퉪�곷연雅뚯눘占�占쎈봾�쀯옙占�2015.01.22 揶쏉옙nvoice 占쏙옙占쎈뗀�껓옙占썹빊�뺤젾占쎌꼶猷꾣에占쏙옙�륁젟占쎈뗄猿뚳옙占�
//        	if (OtsInquiryByDetialVOList != null && OtsInquiryByDetialVOList.size() > 0) {
//        		for (OtsInquiryByDetialVO detialVO : OtsInquiryByDetialVOList) {
//        			if ("Y".equals(detialVO.getDmdtVtInvYn())) {
//        				detialVO.setInvnoo("");
//        			}
//        		}
//        	}
        } 
        catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
        catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    	return OtsInquiryByDetialVOList;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO2>
    * @exception EventException
    */
    public List<OtsInquiryByDetial2VO> searchOTSInquiryByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryByDetailList2 ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryByDetailListRemark ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListRemark2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryByDetailListRemark2 ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String updateOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException {
        try {
            return dbDao.updateOTSInquiryByDetailListRemark ( otsInquiryParmVO , account );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }    

    
    /**
     * [Invoice Create & Issue(Invoice Issue 占쏙옙]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
		InvoiceIssueMgtVO invoiceIssueMgtVO		= new InvoiceIssueMgtVO();
		List<InvoiceIssueVO> invoiceIssueList	= null;
		
		try {
			ChargeBookingInvoiceVO chgBkgInvVO = new ChargeBookingInvoiceVO();
			
			// searchChargeBookingInvoice
			if ("Y".equals(issuedInvoiceParamVO.getDmdtVtInvYn())) { // Virtual Invoice 鈺곌퀬�띰옙占썲칰�뚯뒭
				chgBkgInvVO = dbDao.searchBookingVtInvoice(issuedInvoiceParamVO);
			}
			else {
				chgBkgInvVO = dbDao.searchBookingInvoice(issuedInvoiceParamVO);
			}
			chgBkgInvVO.setCustCntcPntSeq(StringUtils.defaultString(chgBkgInvVO.getCustCntcPntSeq(), "0"));

			log.debug("\nlcb searchIssuedInvoice : 0001 ");
			PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
			PayerNameVO rePayerNameVO = new PayerNameVO();
			
			payerNameParamVO.setSCustCd(chgBkgInvVO.getPayerCd());
			
            if (chgBkgInvVO.getPayerCd().substring(0,2).equals("00")) {
            	payerNameParamVO.setSCustGubun("1");
            	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
            }
            else {
            	payerNameParamVO.setSCustGubun("2");
            	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
            }
            log.debug("\nlcb searchIssuedInvoice : 0002 ");
			chgBkgInvVO.setPayerCd(StringUtils.defaultString(rePayerNameVO.getCustCd()));
			chgBkgInvVO.setPayerNm(StringUtils.defaultString(rePayerNameVO.getCustName()));
				
			List<BookingCustomerVO> bookingCustomerList = null;
			
			// searchBookingCustomer 
			BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();

			inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
			
			// searchBookingCustomer 鈺곌퀬��
			bookingCustomerList = dbDao.searchBookingCustomer(inBookingCustomerVO);
			log.debug("\nlcb searchIssuedInvoice : 0003 ");
			if (bookingCustomerList == null || bookingCustomerList.size() == 0) {
				chgBkgInvVO.setBkgCustCd("");
				chgBkgInvVO.setBkgCustNm("");
			} 
			else {
				String ioBnd = issuedInvoiceParamVO.getSDmdtTrfCd().substring(2, 3);

				for (BookingCustomerVO bkgCustomerVO : bookingCustomerList) {

					if ("O".equals(ioBnd)) {
						// SHIPPER
						chgBkgInvVO.setBkgCustCd(bkgCustomerVO.getCustCdS());
						chgBkgInvVO.setBkgCustNm(bkgCustomerVO.getCustNmS());							
					}
					else if ("I".equals(ioBnd)) {
						
						if (bkgCustomerVO.getCustCdC() == null || bkgCustomerVO.getCustCdC().length() != 8) {
							// NOTIFY
							chgBkgInvVO.setBkgCustCd(bkgCustomerVO.getCustCdN());
							chgBkgInvVO.setBkgCustNm(bkgCustomerVO.getCustNmN());							
						}
						else {
							// CONSIGNEE
							chgBkgInvVO.setBkgCustCd(bkgCustomerVO.getCustCdC());
							chgBkgInvVO.setBkgCustNm(bkgCustomerVO.getCustNmC());								
						}
					}
				}
			}
			log.debug("\nlcb searchIssuedInvoice : 0004 ");
			// searchSheetOption
			SheetOptionVO iSheetOptionVO = new SheetOptionVO();
			iSheetOptionVO.setDmdtTrfCd(issuedInvoiceParamVO.getSDmdtTrfCd());
			iSheetOptionVO.setOfcCd(chgBkgInvVO.getCreOfcCd());		//invoice 占쏙옙cre_ofc_cd
			
			List<SheetOptionVO> listSheetOption = dbDao.searchSheetOption(iSheetOptionVO);
			log.debug("\nlcb searchIssuedInvoice : 0005 ");
            // 鈺곕똻�깍옙�륅옙 占쎈봿�앾쭖占폛ue Date = 占쎄쑴�깍옙�깆쁽, Credit Term = 0 占쎌눖以�占썬끉�숋옙占�
            if (listSheetOption == null || listSheetOption.size() == 0) {
            	log.debug("\nlcb searchIssuedInvoice : 0005-1-S");
                chgBkgInvVO.setIssDtPrnFlg("");
                chgBkgInvVO.setCrTermDys("0");
                chgBkgInvVO.setTaxRto("0");
                chgBkgInvVO.setDueDate(chgBkgInvVO.getIssueDay());//Issue占쎌눘��
                chgBkgInvVO.setBilToLocDivCd("");//PRINT �곗뮆��L/R
                log.debug("\nlcb searchIssuedInvoice : 0005-1-E");
            }
            else {
            	log.debug("\nlcb searchIssuedInvoice : 0005-2-S");
                for (int i = 0; i < listSheetOption.size() ; i++) {
                    chgBkgInvVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chgBkgInvVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chgBkgInvVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT �곗뮆��L/R
                    
                    if (listSheetOption.get(i).getDfltTaxRto() == null || listSheetOption.get(i).getDfltTaxRto().equals("")) {
                    	chgBkgInvVO.setTaxRto("0");
                    }
                    else {
                    	chgBkgInvVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    }
                    log.debug("\nlcb searchIssuedInvoice : 0005-2-1");
                    //sheet Option占쏙옙Credit Term = 0 占쎈���
                    if ("0".equals(chgBkgInvVO.getCrTermDys())) {
                    	log.debug("\nlcb searchIssuedInvoice : 0005-2-1");
                    	//Due Date揶쏉옙"Issue Date"�쒙옙占쎌쥚源�옙�롢늺 Due Date=占쎄쑴�깍옙�깆쁽,Credit Term=0
                    	if ("Y".equals(chgBkgInvVO.getIssDtPrnFlg())) {
                    		log.debug("\nlcb searchIssuedInvoice : 0005-2-3");
                    		chgBkgInvVO.setDueDate(chgBkgInvVO.getIssueDay());
                    		chgBkgInvVO.setCrTermDys("0");
                    		log.debug("\nlcb searchIssuedInvoice : 0005-2-4");
                       	//Due Date揶쏉옙"*******"�쒙옙占쎌쥚源�옙�롢늺 Due Date: ********, Credit Term: �⑤벉媛�
                    	}
                    	else if ("N".equals(chgBkgInvVO.getIssDtPrnFlg())) {
                    		log.debug("\nlcb searchIssuedInvoice : 0005-2-5");
                    		chgBkgInvVO.setDueDate("********");
                    		chgBkgInvVO.setCrTermDys("");
                    		log.debug("\nlcb searchIssuedInvoice : 0005-2-6");
                    	}
                    //sheet Option占쏙옙Credit Term > 0 占쎈���
                    }
                    else if (!"0".equals(chgBkgInvVO.getCrTermDys())) {
                    	log.debug("\nlcb searchIssuedInvoice : 0005-2-7(issueDay : " + chgBkgInvVO.getIssueDay() + ")");
                    	String due_date = DateTime.addDays(chgBkgInvVO.getIssueDay(), Integer.parseInt(chgBkgInvVO.getCrTermDys()));
                    	log.debug("\nlcb searchIssuedInvoice : 0005-2-7-1(due_date : "+ due_date + ")");
                    	chgBkgInvVO.setDueDate(due_date);
                    	log.debug("\nlcb searchIssuedInvoice : 0005-2-8");
                    }
                    log.debug("\nlcb searchIssuedInvoice : 0005-2-9");
                }
                log.debug("\nlcb searchIssuedInvoice : 0005-2-E");
            }
            log.debug("\nlcb searchIssuedInvoice : 0006 ");
			List<ARActualPayerVO> listARActualPayer = dbDao.searchARActualPayer(issuedInvoiceParamVO.getSBkgNo(), issuedInvoiceParamVO.getSDmdtTrfCd());
			log.debug("\nlcb searchIssuedInvoice : 0007 ");
			if (listARActualPayer == null || listARActualPayer.size() == 0) {
				chgBkgInvVO.setActCustCd("");
				chgBkgInvVO.setActCustNm("");
			}
			else {
				for (int i = 0; i < listARActualPayer.size() ; i++) {
					chgBkgInvVO.setActCustCd(listARActualPayer.get(i).getActCustCd());
					chgBkgInvVO.setActCustNm(listARActualPayer.get(i).getActCustNm());
				}
			}
			
			log.debug("\nlcb searchIssuedInvoice : 0008 ");
			if (chgBkgInvVO.getTruckerCd().equals("000000")) {
				chgBkgInvVO.setTruckerCd("");
				chgBkgInvVO.setTruckerNm("");
			}
			else {
				// searchServiceProviderName
				VendorNameVO vendorNameVO = dbDao.searchServiceProviderName(chgBkgInvVO.getTruckerCd());
				
				chgBkgInvVO.setTruckerNm(vendorNameVO.getVndrNm());
			}
			log.debug("\nlcb searchIssuedInvoice : 0009 ");
			
			//INV OVER DAY CALC
			int inv_over_day = 0;
			String issue_day 	= chgBkgInvVO.getIssueDay();	//invoice create date
			String today 		= DateTime.getShortDateString();		//占쎄쑴�깍옙�깆쁽
			String ar_if_day	= JSPUtil.replace(chgBkgInvVO.getArIfDt(), "-","");
//			log.debug("\n[issue_day]"+issue_day);
//			log.debug("\n[today]"+today);
//			log.debug("\n[ar_if_day]"+ar_if_day);
//			log.debug("\n[today - issue_day]"+DateTime.daysBetween(issue_day, today));
			
			if (ar_if_day == null || ar_if_day.equals("")) {
				
				if ("Y".equals(issuedInvoiceParamVO.getDmdtVtInvYn())) {
					inv_over_day = 0;
				}
				else {
					inv_over_day = DateTime.daysBetween(issue_day, today);
				}
			}
			else {
				if (DateTime.daysBetween(issue_day, ar_if_day) > 0) {
					inv_over_day = DateTime.daysBetween(issue_day, today);
				}
				else {
					inv_over_day = DateTime.daysBetween(issue_day, ar_if_day);
				}
			}
			log.debug("\nlcb searchIssuedInvoice : 0010");
//			log.debug("\n[inv_over_day]"+inv_over_day);
			chgBkgInvVO.setOverDay(String.valueOf(inv_over_day));
			
			String colDate	= JSPUtil.replace(chgBkgInvVO.getColDate(), "-","");
			String otsCltFlg = chgBkgInvVO.getOtsCltFlg();
			int col_over_day = 0;
			if(StringUtils.equals(otsCltFlg , "Y")){
				//�꾨텋�덉쓣寃쎌슦 Collected DT - INV 諛쒗뻾��
				col_over_day = DateTime.daysBetween(issue_day,colDate );
			}else{
				//�꾨텋�덊뻽�꾧꼍��議고쉶��- INV 諛쒗뻾��
				col_over_day = DateTime.daysBetween(issue_day,today);				
			}
			chgBkgInvVO.setColOverDay(String.valueOf(col_over_day));
			
            //Total Amt
            double totAmt = 0;			//tot_amt
            //double inv_bill_amt = 0;
            double inv_chg_tot = 0;
            double chg_dc_amt = 0;
            String billAmt = null;

 			//2010.02.25. Cancel, Credit Note 占쏙옙野껋럩��charge data揶쏉옙占쎈냱�ｏ옙占쏙옙�됱몵沃섓옙以�invoice data 筌랃옙鈺곌퀬�띰옙�뺣뼄.
			if (!"Y".equals(issuedInvoiceParamVO.getDmdtVtInvYn()) // 揶쏉옙湲폠nvoice 揶쏉옙占쎄쑬�꿩�占�Invoice 占쎄낱源�첎占썹뿆�λ꺖占쏙옙Credit 占쏙옙野껋럩��
				&& (chgBkgInvVO.getDmdtInvStsCd().equals("X") || chgBkgInvVO.getDmdtInvStsCd().equals("C"))) {
				log.debug("\nlcb searchIssuedInvoice : 0011-2 ");
				invoiceIssueList = dbDao.searchInvoiceCancelDetail(chgBkgInvVO);	
				
				for (InvoiceIssueVO invoiceIssueVO : invoiceIssueList) {
					billAmt = this.toInvoiceChargeAmount(invoiceIssueVO.getBilAmt(), chgBkgInvVO.getInvXchRt(), chgBkgInvVO.getInvCurrCd());
					invoiceIssueVO.setInvBillAmt(billAmt);
					invoiceIssueVO.setInvChgTot(billAmt);
					totAmt = totAmt + NumberUtils.toDouble(billAmt);
					chg_dc_amt = chg_dc_amt + NumberUtils.toDouble(invoiceIssueVO.getAftExptDcAmt());
				}			
				totAmt = totAmt + chg_dc_amt ;
				
				log.debug("\nlcb searchIssuedInvoice : 0012 ");
			}
			else {
				log.debug("\nlcb searchIssuedInvoice : 0013 ");
				// searchInvoiceDetail
				if ("Y".equals(issuedInvoiceParamVO.getDmdtVtInvYn())) {
					log.debug("\nlcb searchIssuedInvoice : 0013-1 ");
					invoiceIssueList = dbDao.searchVtInvoiceCancelDetail(chgBkgInvVO);
					
					//揶쏉옙湲폠nvoice 占쎈�占썸에占�Invoice No. �쒙옙�⑤벉媛싷옙�곗쨮 �λ뜃由곤옙酉�립占쏙옙(占쎈뗀�껓옙占썼퉪�곷연餓ο옙占쎄쑴�귛첎占쏙옙�곸벉.)
					chgBkgInvVO.setDmdtInvNo("");
					chgBkgInvVO.setCreDt("");
					chgBkgInvVO.setCreOfcCd("");
					chgBkgInvVO.setCreUsrNm("");					
				}
				else {
					log.debug("\nlcb searchIssuedInvoice : 0013-2 ");
					invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
				}
				
	            ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
	            
	            for (InvoiceIssueVO invoiceIssueVO : invoiceIssueList) {
	            	//invoice charge amt
	            	
	            	billAmt = this.toInvoiceChargeAmount(invoiceIssueVO.getBilAmt(), chgBkgInvVO.getInvXchRt(), chgBkgInvVO.getInvCurrCd());
	            	invoiceIssueVO.setInvBillAmt(billAmt);
	            	log.debug("\nlcb searchIssuedInvoice : 0014 (BILL_AMT : " + billAmt + ")");
	            	//totBillAmt += inv_bill_amt;
	            	
	            	OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
	                overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
	                overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
	                overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
	                overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
	                overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
	                overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
	                
	                // DivOverDay 鈺곌퀬��
	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);  
	                log.debug("\nlcb searchIssuedInvoice : 0014-1 (DivOverDay 鈺곌퀬�띰옙袁⑥┷ ::> DivOverDay : " + overdayNDivVO.getDivOverDay() + ", OrgFtOvrDys : " + overdayNDivVO.getOrgFtOvrDys() + ")");
	                String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
					
					CalculationParmVO calculationParmVO = new CalculationParmVO();
					calculationParmVO.setDcApplRate(trfAplyTpCd);

					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setFtDys(invoiceIssueVO.getFtDys());				// 2014.03.12
                    calculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
                    calculationParmVO.setOrgFtOvrDys(invoiceIssueVO.getOrgFtOvrDys());	// 2014.03.12
                    
                    calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
					/*
					Charge占쏙옙占쎄낯�쒙옙占폯ariff占쏙옙占쎄퀡��Charge疫뀀뜆釉몌옙占썸�袁⑷텦占쎌뮆��
				    A) "G"(Basic Tariff)占쏙옙野껋럩��Basic Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�뺣뼄
				    B) "B"(Before Exception)占쏙옙野껋럩��Before Exception Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�랁� Before Exception占쏙옙Currency�쒙옙鈺곌퀬�띰옙�뺣뼄
				    C) "S"(S/C Exception)占쏙옙野껋럩��S/C Exception Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�랁� S/C Exception占쏙옙Currency�쒙옙鈺곌퀬�띰옙�뺣뼄
				    D) Charge占쏙옙占쎄낯�쒙옙占폚urrency占쏙옙A), B), C)占쎈Ŋ苑��④쑴沅쏉옙占폚urrency揶쏉옙占썬끇�ⓨ칰�뚯뒭
				         1) 占쎄낯�쒙옙占폚urrencyExchange Rate�쒙옙鈺곌퀬�띰옙�뤿연 Charge �④쑴沅쎿묾�됰만占쏙옙Exchange Rate�쒙옙�④퉲釉놂옙占�
				         2) 1)占쎈Ŋ苑��④쑴沅쏉옙占썸묾�됰만占쏙옙Currency癰귢쑬以�獄쏆꼷�긺뵳�깆퓗�깍옙占쎌뮆��
					*/
                    
                    log.debug("\nlcb searchIssuedInvoice : 0015 (trfAplyTpCd : " + trfAplyTpCd + ")");
					if ("G".equals(trfAplyTpCd)) {
						String firstSvrID = null;
						
						//office transfer check
		            	if ("Y".equals(invoiceIssueVO.getOfcTrnsFlg())) {
		            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
		            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
		            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
		            		chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
		            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
		            		chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
		            		chargeCalculationParmVO.setBkgNo(invoiceIssueVO.getBkgNo());
		            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
	
		    				log.debug(" iss searchIssuedInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		

		            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
		            	}
		            	else {
		            		firstSvrID = invoiceIssueVO.getSvrId();
		            	}
		            	log.debug("\nlcb searchIssuedInvoice : 0015-1 (firstSvrID : " + firstSvrID + ", ScRfaExptAplyDt : " + invoiceIssueVO.getScRfaExptAplyDt() + ")");
						// basicCalculation - Baisc Tariff
						calculationParmVO.setSvrId(firstSvrID);
						calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
						calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
						calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
						calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
						calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
						calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());		
						calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());			
						calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());				// 2014.03.12
						if (!"".equals(invoiceIssueVO.getScRfaExptAplyDt())) {
							calculationParmVO.setDmdtTrfAplyTpCd("B");					
							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());				// 獄쎻뫕占쏙옙�곕쑓占쏙옙嚥≪뮇彛�占쎈슢揆占쏙옙�곕떽占� ("B" 占쎈Ŧ��"S"嚥∽옙占쏙퐡由곤쭖占쏙옙占�
						} 
					} 
					else if ("B".equals(trfAplyTpCd)) {
						// beforeCalculation - Before BKG Exception
						calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
						calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
						calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
						calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
						calculationParmVO.setCmbSeq("1");
						calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
						calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
						calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());			// 2014.03.12
					} 
					else if ("S".equals(trfAplyTpCd)) {
						// scCalculation - SC Exception
						calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
						calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
						calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
						calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
						calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
						calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());			// 2014.03.12
					}
					log.debug("\nlcb searchIssuedInvoice : 0015-2 (OverDay : " + calculationParmVO.getOverDay() + ", DivOverDay : " + calculationParmVO.getDivOverDay() + ")");
					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
		            
		            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
		            String rateCurrCd = calculationAMTVO.getRateCurCd();
		            double rtExchangeRate 	= 0;
		            inv_chg_tot 			= 0;
		            
		            if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {

		            	//Total Amt
		            	inv_chg_tot = NumberUtils.toDouble(calculationAMTVO.getTotal());
		            	log.debug("\nlcb searchIssuedInvoice : 0016 (inv_chg_tot : " + inv_chg_tot + ", rateCurrCd : " + rateCurrCd + ", ChgCurrCd : " + chgBkgInvVO.getChgCurrCd() + ")");
		            	
		            	//rate CurrCd占쏙옙charge CurrCd揶쏉옙占썬끇�ㅿ쭖占퐎ateCrrCd�쒙옙�④퉲鍮먲옙占폺harge amt�쒙옙�닌뗫립占쏙옙
		            	if (!rateCurrCd.equals(chgBkgInvVO.getChgCurrCd())) {
		            		exchangeRateParmVO = new ExchangeRateParmVO();
		                    
		                    exchangeRateParmVO.setVslCd(chgBkgInvVO.getVvdCd().substring(0,4));
		                    exchangeRateParmVO.setSkdVoyageNo(chgBkgInvVO.getVvdCd().substring(4,8));
		                    exchangeRateParmVO.setSkdDirCd(chgBkgInvVO.getVvdCd().substring(8));
		                    exchangeRateParmVO.setIoBnd(chgBkgInvVO.getDmdtTrfCd().substring(2,3));
		                    exchangeRateParmVO.setPolLoc(chgBkgInvVO.getPolCd());
		                    exchangeRateParmVO.setPodLoc(chgBkgInvVO.getPodCd()); 
		                    exchangeRateParmVO.setFmCurCd(rateCurrCd);								//rate currency
		                    exchangeRateParmVO.setToCurCd(chgBkgInvVO.getChgCurrCd());	//chg currency
		                    exchangeRateParmVO.setOfcCd(invoiceIssueVO.getChgOfcCd());			//charge office
		                    
		                    log.debug("\n---VSLCD -->"+chgBkgInvVO.getVvdCd().substring(0,4));
		                    log.debug("\n---SKDVOYAGENO -->"+chgBkgInvVO.getVvdCd().substring(4,8));
		                    log.debug("\n---SKDDIRCD -->"+chgBkgInvVO.getVvdCd().substring(8));
		                    log.debug("\n---IOBND -->"+chgBkgInvVO.getDmdtTrfCd().substring(2,3));
		                    log.debug("\n---POLLOC -->"+chgBkgInvVO.getPolCd());
		                    log.debug("\n---PODLOC -->"+chgBkgInvVO.getPolCd());
		                    log.debug("\n---FMCURCD -->"+rateCurrCd);
		                    log.debug("\n---TOCURCD -->"+chgBkgInvVO.getChgCurrCd());
		                    log.debug("\n---OFCCD -->"+invoiceIssueVO.getChgOfcCd());
		                    
		                    rtExchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
		            		
		                    inv_chg_tot = rtExchangeRate * inv_chg_tot;
		                    inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(rateCurrCd, inv_chg_tot);
		                    
		                    log.debug("\n---rate Currency -->"+rateCurrCd);
		                    log.debug("\n---rate Exchange Rate-->"+rtExchangeRate);
		                    log.debug("\n---org_chg_tot-->"+inv_chg_tot);
		                    log.debug("\nlcb searchIssuedInvoice : 0021 ");
		            	}
		            }
		            log.debug("\nlcb searchIssuedInvoice : 0022 ");
	            	//invoice total amt
		            billAmt = this.toInvoiceChargeAmount(String.valueOf(inv_chg_tot), chgBkgInvVO.getInvXchRt(), chgBkgInvVO.getInvCurrCd());
		            invoiceIssueVO.setInvChgTot(billAmt);
		            log.debug("\n---inv_chg_tot-->"+billAmt);
//		            inv_chg_tot = NumberUtils.toDouble(chgBkgInvVO.getInvXchRt())  * inv_chg_tot;
//		            inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(chgBkgInvVO.getInvCurrCd(),inv_chg_tot);
//		            invoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(inv_chg_tot, "#.##"));
	            	
	                log.debug("\n---exchangeRate-->"+NumberUtils.toDouble(chgBkgInvVO.getInvXchRt()));
	                log.debug("\n---inv_chg_tot-->"+billAmt);
	
	                totAmt = totAmt + NumberUtils.toDouble(billAmt);
	                
	                //chg_dc_amt sum
	                chg_dc_amt += NumberUtils.toDouble(invoiceIssueVO.getAftExptDcAmt());
	            	
	            	//inv_chg_tot, inv_bill_amt 占쏙옙��
	            }
	            log.debug("\nlcb searchIssuedInvoice : 0023 ");
			}
			
			log.debug("\nlcb searchIssuedInvoice : 0024 ");
            totAmt = dmtCalculationUtil.trimCurrencyAmount(chgBkgInvVO.getInvCurrCd(), totAmt);
			chgBkgInvVO.setTotAmt(JSPUtil.toDecimalFormat(totAmt, "#.##"));		//tot_amt calc
			log.debug("\n--------------------------------2------Total Amt--------------------"+totAmt);         
			log.debug("\n--------------------------------3----------Billing amt----------------"+NumberUtils.toDouble(chgBkgInvVO.getInvChgAmt()));         

			//D/C by Amt
			double dcAmt = 0;
			
			dcAmt = totAmt - NumberUtils.toDouble(chgBkgInvVO.getInvChgAmt());
			log.debug("\nlcb searchIssuedInvoice : DC Amount : " + dcAmt + ", Total Amount : " + totAmt);			
			dcAmt = dmtCalculationUtil.trimCurrencyAmount(chgBkgInvVO.getInvCurrCd(),dcAmt);
			log.debug("\nlcb searchIssuedInvoice : 0025 ");
			chgBkgInvVO.setDcAmt(JSPUtil.toDecimalFormat(dcAmt, "#.##"));		//dc_amt calc
			
			//CHG_DC_AMT
			chg_dc_amt = dmtCalculationUtil.trimCurrencyAmount(chgBkgInvVO.getInvCurrCd(),chg_dc_amt);
			log.debug("\nlcb searchIssuedInvoice : 0026 ");
			chgBkgInvVO.setChgDcAmt(JSPUtil.toDecimalFormat(chg_dc_amt, "#.##"));		//chg_dc_amt calc
			
			// Mgt Setting
			invoiceIssueMgtVO.setChargeBookingInvoiceVO(chgBkgInvVO);
			invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);
			log.debug("\nlcb searchIssuedInvoice : 0027 ");
		} 
		catch(DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Invoice Creation & Issue - Booking"}).getMessage()); 
		} 
		catch(Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Invoice Creation & Issue - Booking"}).getMessage()); 
		}
		return invoiceIssueMgtVO;    	   
    }

    
    /**
     * [Invoice Create & Issue]占쏙옙[占쎌꼷�� 占썩뫖�뀐옙占�br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public DmtInvMnVO modifyInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException{
    	ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
        
    	// modifyInvoice
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        List<InvoiceIssueVO> list = null;
        
        try {
            chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            dmtInvMnVO.setDmdtInvNo(chargeBookingInvoiceVO.getDmdtInvNo());
            dmtInvMnVO.setCreOfcCd(chargeBookingInvoiceVO.getCreOfcCd());

        	//VENDOR 占쏙옙野껋럩��
        	if (chargeBookingInvoiceVO.getPayerCd().length() <= 6) {
                dmtInvMnVO.setActPayrCntCd("00");
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd());
                
                //cust
                dmtInvMnVO.setCustCntCd("00");
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd());
        	//CUSTOMER 占쏙옙野껋럩��
        	} 
        	else {
                dmtInvMnVO.setActPayrCntCd(chargeBookingInvoiceVO.getPayerCd().substring(0, 2));
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd().substring(2));
                
                //cust
                dmtInvMnVO.setCustCntCd(chargeBookingInvoiceVO.getPayerCd().substring(0, 2));
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd().substring(2));
        	}
            dmtInvMnVO.setDmdtPayrCntcPntNm(JSPUtil.getNull(chargeBookingInvoiceVO.getDmdtPayrCntcPntNm()));
            dmtInvMnVO.setCustCntcPntSeq(JSPUtil.getNull(chargeBookingInvoiceVO.getCustCntcPntSeq()));
            //dmtInvMnVO.setOrgChgAmt(chargeBookingInvoiceVO.getOrgChgAmt());
            dmtInvMnVO.setOrgChgAmt(chargeBookingInvoiceVO.getMnOrgChgAmt());
            dmtInvMnVO.setDmdtExptAmt(chargeBookingInvoiceVO.getDmdtExptAmt());
            dmtInvMnVO.setDcAmt(chargeBookingInvoiceVO.getDcAmt());
            //dmtInvMnVO.setBilAmt(chargeBookingInvoiceVO.getBilAmt());
            dmtInvMnVO.setBilAmt(chargeBookingInvoiceVO.getMnBilAmt());
            dmtInvMnVO.setInvXchRt(chargeBookingInvoiceVO.getInvXchRt());
            dmtInvMnVO.setInvChgAmt(chargeBookingInvoiceVO.getInvChgAmt());
            dmtInvMnVO.setTaxRto(chargeBookingInvoiceVO.getTaxRto());
            dmtInvMnVO.setTaxAmt(chargeBookingInvoiceVO.getTaxAmt());
            dmtInvMnVO.setInvAmt(chargeBookingInvoiceVO.getInvAmt());
            //dmtInvMnVO.setInvRmk(chargeBookingInvoiceVO.getInvRmk());
            dmtInvMnVO.setInvRmk1(chargeBookingInvoiceVO.getInvRmk1());
            dmtInvMnVO.setInvRmk2(chargeBookingInvoiceVO.getInvRmk2());
            dmtInvMnVO.setInvRefNo(chargeBookingInvoiceVO.getInvRefNo());
            dmtInvMnVO.setCreUsrId(account.getUsr_id());
            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
            dmtInvMnVO.setNtcKntCd(chargeBookingInvoiceVO.getNtcKntCd());
            dmtInvMnVO.setCaller(chargeBookingInvoiceVO.getCaller());
            dmtInvMnVO.setMnlInvRmk(chargeBookingInvoiceVO.getMnlInvRmk());
            dmtInvMnVO.setVndrSeq(chargeBookingInvoiceVO.getVndrSeq());
            dmtInvMnVO.setInvNewRptFlg(chargeBookingInvoiceVO.getInvNewRptFlg());
            dmtInvMnVO.setErrCode("0");	//占쎄퉫�э쭖遺용뻻筌욑옙
            dmtInvMnVO.setIdaCgstAmt(chargeBookingInvoiceVO.getIdaCgstAmt());
            dmtInvMnVO.setIdaSgstAmt(chargeBookingInvoiceVO.getIdaSgstAmt());
            dmtInvMnVO.setIdaIgstAmt(chargeBookingInvoiceVO.getIdaIgstAmt());
            dmtInvMnVO.setIdaUgstAmt(chargeBookingInvoiceVO.getIdaUgstAmt());
            
            dbDao.modifyInvoice(dmtInvMnVO);
            
            //detail 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
            
            
            //detail 占쎈베�ョ몴占퐑pdate占쎌뮆��(tax占쎈베�ョ몴占�/TaxRto
            //List<InvoiceIssueVO> searchInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO)
            IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
            issuedInvoiceParamVO.setSInvoiceNo(chargeBookingInvoiceVO.getDmdtInvNo());
            issuedInvoiceParamVO.setOfcCd(chargeBookingInvoiceVO.getCreOfcCd());
            
            list = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
            
            if(list != null && list.size() > 0) {
            	for(int i = 0 ; i < list.size() ; i++) {
            		InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)list.get(i);
            		
            		//�④쑴沅�
            		InvoiceDetailTaxVO invoiceDetailTaxVO = new InvoiceDetailTaxVO();
            		invoiceDetailTaxVO.setInvoiceNo(chargeBookingInvoiceVO.getDmdtInvNo());
            		invoiceDetailTaxVO.setCreOfcCd(chargeBookingInvoiceVO.getCreOfcCd());
            		invoiceDetailTaxVO.setInvDtlSeq(invoiceIssueVO.getRtDtlGrp());
            		invoiceDetailTaxVO.setDtlTaxRto(chargeBookingInvoiceVO.getTaxRto());
            		
            		double tax_amt = dbDao.searchInvoiceDetailTaxAmt(invoiceDetailTaxVO);	//tax_amt 揶쏉옙�④쑴沅�
            		tax_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), tax_amt);
            		
            		invoiceDetailTaxVO.setDtlTaxAmt(JSPUtil.toDecimalFormat(tax_amt, "#.##"));
            		
            		dbDao.modifyInvoiceDetailByInvoiceMain(invoiceDetailTaxVO, account);	//Invoice Detail (tax_rto, tax_amt) 占쎌꼷��
            	}
            }
            
            return dmtInvMnVO;
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        }       
    }
    
    /**
     * [Exchange Rate]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
     * 
     * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
     * @return double
     * @exception EventException
     */
    public double searchExchangeRate(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws EventException{
        double exchangeRate = 0;
        
        ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
        try{
            exchangeRateParmVO.setOfcCd(chargeBookingInvoiceVO.getOfcCd());
            
            if (chargeBookingInvoiceVO.getVvdCd() != null && chargeBookingInvoiceVO.getVvdCd().length() == 9) {
            	exchangeRateParmVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0, 4));
            	exchangeRateParmVO.setSkdVoyageNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
            	exchangeRateParmVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8,9));
            }
            exchangeRateParmVO.setIoBnd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
            exchangeRateParmVO.setFmCurCd(chargeBookingInvoiceVO.getChgCurrCd());
            exchangeRateParmVO.setToCurCd(chargeBookingInvoiceVO.getInvCurrCd());
            exchangeRateParmVO.setPodLoc(chargeBookingInvoiceVO.getPodCd());
            exchangeRateParmVO.setPolLoc(chargeBookingInvoiceVO.getPolCd());
            
            StringBuffer sbLog = new StringBuffer();
            sbLog.append("\n\n==========================================================================\n");
            sbLog.append("[VSL CD]: " + chargeBookingInvoiceVO.getVvdCd().substring(0,4) + "\n");
            sbLog.append("[SKD VOYAGE NO]: " + chargeBookingInvoiceVO.getVvdCd().substring(4,8) + "\n");
            sbLog.append("[SKD DIR CD]: " + chargeBookingInvoiceVO.getVvdCd().substring(8) + "\n");
            sbLog.append("[IO BND]: " + chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3) + "\n");
            sbLog.append("[POL LOC]: " + chargeBookingInvoiceVO.getPolCd() + "\n");
            sbLog.append("[POD LOC]: " + chargeBookingInvoiceVO.getPodCd() + "\n");
            sbLog.append("[CHAGE CURR CD]: " + chargeBookingInvoiceVO.getChgCurrCd() + "\n");
            sbLog.append("[INVOICE CURR CD]: " + chargeBookingInvoiceVO.getInvCurrCd() + "\n");
            sbLog.append("\n\n==========================================================================\n");
            log.debug(sbLog.toString());
            
            exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
            
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        }  catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
        return exchangeRate;
    }
    
    
    
    /**
    * [Remark(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchInvoiceRemark ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Remark(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSRemark ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Remark(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException {
        try {
            return dbDao.modifyInvoiceRemark ( otsInquiryParmVO , account );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Remark(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyOTSRemark ( OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws EventException {
        try {
            return dbDao.modifyOTSRemark ( otsInquiryParmVO , account );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }

    /**
     * Office癰귨옙Tax Ratio 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
     * 
     * @param SheetOptionVO sheetOptionVO
     * @return String
     * @throws EventException
     */
    public String searchEnvironmentByOffice ( SheetOptionVO sheetOptionVO) throws EventException{
    	String tax_rto = "";
        try {
        	tax_rto = dbDao.searchEnvironmentByOffice ( sheetOptionVO );
        	if(tax_rto == null || tax_rto.equals("")) {
        		tax_rto = "0";
        	}
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}   	
        return tax_rto;
    }

    /**
    * [Sheet Option]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionMasterSetVO sheetOptionMasterSetVO
    * @return SheetOptionMasterSetVO
    * @exception EventException
    */
    public SheetOptionMasterSetVO searchSheetOption ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionMasterSetVO sheetOptionMasterSetVO ) throws EventException {
        try {
            List<SheetOptionTermTitleListUpVO> sheetOptionTermTitleListUpVO = new ArrayList<SheetOptionTermTitleListUpVO>();
            List<SheetOptionTermTitleListDwVO> sheetOptionTermTitleListDwVO = new ArrayList<SheetOptionTermTitleListDwVO>();
            sheetOptionTermTitleListUpVO = dbDao.searchSheetOptionUp   ( sheetOptionSearchOptionVO );
            sheetOptionTermTitleListDwVO = dbDao.searchSheetOptionDw   ( sheetOptionSearchOptionVO );
            String shOptInfo             = dbDao.searchSheetOptionInfo ( sheetOptionSearchOptionVO );
            sheetOptionMasterSetVO.setSheetOptionTermTitleListUpVO(sheetOptionTermTitleListUpVO);
            sheetOptionMasterSetVO.setSheetOptionTermTitleListDwVO(sheetOptionTermTitleListDwVO);
            sheetOptionMasterSetVO.setShOptInfo(shOptInfo);
            return sheetOptionMasterSetVO;
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Sheet Option]占쏙옙[DELETE/INSERT] 占썩뫖�뀐옙占�br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String manageSheetOption ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionTermTitleListUpVO[] sheetOptionTermTitleListUpVOs , SignOnUserAccount account ) throws EventException {
        int rCnt = 0;
        try {
            
            log.debug("\n ####### 4103 value issoff : [" + sheetOptionSearchOptionVO.getIsof()   + "]");
            log.debug("\n ####### 4103 value toloca : [" + sheetOptionSearchOptionVO.getToloca() + "]");
            log.debug("\n ####### 4103 value cusref : [" + sheetOptionSearchOptionVO.getCusref() + "]");
            log.debug("\n ####### 4103 value telfax : [" + sheetOptionSearchOptionVO.getTelfax() + "]");
            log.debug("\n ####### 4103 value cusvat : [" + sheetOptionSearchOptionVO.getCusvat() + "]");
            log.debug("\n ####### 4103 value taxrto : [" + sheetOptionSearchOptionVO.getTaxrto() + "]");
            log.debug("\n ####### 4103 value rtovat : [" + sheetOptionSearchOptionVO.getRtovat() + "]");
            log.debug("\n ####### 4103 value dcamtr : [" + sheetOptionSearchOptionVO.getDcamtr() + "]");
            
            dbDao.removeSheetOptionByOffice ( sheetOptionSearchOptionVO );
            log.debug("\n ####### Sheep Option Delete Done");
            
            String shOptInfo = dbDao.searchSheetOptionInfo ( sheetOptionSearchOptionVO );
            
            if ( !StringUtils.isEmpty(shOptInfo) ) {
                
                dbDao.updateDmtOfcShOptData ( sheetOptionSearchOptionVO , account );
                log.debug("\n ####### Sheep Option DMT_OFC_SH_OPT Update Done");
                
            } else {
                
                dbDao.insertDmtOfcShOptData ( sheetOptionSearchOptionVO , account );
                log.debug("\n ####### Sheep Option DMT_OFC_SH_OPT Insert Done");
                
            }

            if( sheetOptionTermTitleListUpVOs.length > 0){
                for(int i = 0 ; i < sheetOptionTermTitleListUpVOs.length ; i++){
                    if ( !(sheetOptionTermTitleListUpVOs[i].getIbflag()).equals("D") ) {
                        log.debug("\n ####### 4103                [" + i + "] ================================================ ");
                        log.debug("\n ####### 4103 value ibflag : [" + sheetOptionTermTitleListUpVOs[i].getIbflag() + "]");
                        log.debug("\n ####### 4103 value seqq   : [" + sheetOptionTermTitleListUpVOs[i].getSeqq() + "]");
                        log.debug("\n ####### 4103 value alll   : [" + sheetOptionTermTitleListUpVOs[i].getAlll() + "]");
                        log.debug("\n ####### 4103 value dmif   : [" + sheetOptionTermTitleListUpVOs[i].getDmif() + "]");
                        log.debug("\n ####### 4103 value dtic   : [" + sheetOptionTermTitleListUpVOs[i].getDtic() + "]");
                        log.debug("\n ####### 4103 value dmof   : [" + sheetOptionTermTitleListUpVOs[i].getDmof() + "]");
                        log.debug("\n ####### 4103 value dtoc   : [" + sheetOptionTermTitleListUpVOs[i].getDtoc() + "]");
                        log.debug("\n ####### 4103 value ctic   : [" + sheetOptionTermTitleListUpVOs[i].getCtic() + "]");
                        log.debug("\n ####### 4103 value ctoc   : [" + sheetOptionTermTitleListUpVOs[i].getCtoc() + "]");
                        log.debug("\n ####### 4103 value term   : [" + sheetOptionTermTitleListUpVOs[i].getTerm() + "]");
                        log.debug("\n ####### 4103 value issd   : [" + sheetOptionTermTitleListUpVOs[i].getIssd() + "]");
                        log.debug("\n ####### 4103 value shtp   : [" + sheetOptionTermTitleListUpVOs[i].getShtp() + "]");
                        log.debug("\n ####### 4103 value titl   : [" + sheetOptionTermTitleListUpVOs[i].getTitl() + "]");
                        
                        if ( sheetOptionTermTitleListUpVOs[i].getTitl().equals("") ) {
                            dbDao.insertDmtCrTermData ( sheetOptionSearchOptionVO , sheetOptionTermTitleListUpVOs[i] , account );
                            log.debug("\n ####### Sheep Option DMT_CR_TERM_OPT Insert Done");
                            if ( sheetOptionTermTitleListUpVOs[i].getDmif().equals("1") ) {
                                dbDao.insertDmtCrTermTrfData ( sheetOptionSearchOptionVO , "DMIF" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CR_TERM_TRF_OPT DMIF Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getDtic().equals("1") ) {
                                dbDao.insertDmtCrTermTrfData ( sheetOptionSearchOptionVO , "DTIC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CR_TERM_TRF_OPT DTIC Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getDmof().equals("1") ) {
                                dbDao.insertDmtCrTermTrfData ( sheetOptionSearchOptionVO , "DMOF" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CR_TERM_TRF_OPT DMOF Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getDtoc().equals("1") ) {
                                dbDao.insertDmtCrTermTrfData ( sheetOptionSearchOptionVO , "DTOC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CR_TERM_TRF_OPT DTOC Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getCtic().equals("1") ) {
                                dbDao.insertDmtCrTermTrfData ( sheetOptionSearchOptionVO , "CTIC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CR_TERM_TRF_OPT CTIC Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getCtoc().equals("1") ) {
                                dbDao.insertDmtCrTermTrfData ( sheetOptionSearchOptionVO , "CTOC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CR_TERM_TRF_OPT CTOC Insert Done");
                            }                            
                        } else {
                            dbDao.insertDmtCstmzTitData ( sheetOptionSearchOptionVO , sheetOptionTermTitleListUpVOs[i] , account );
                            log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_OPT Insert Done");
                            if ( sheetOptionTermTitleListUpVOs[i].getDmif().equals("1") ) {
                                dbDao.insertDmtCstmzTitTrfData ( sheetOptionSearchOptionVO , "DMIF" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_TRF_OPT DMIF Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getDtic().equals("1") ) {
                                dbDao.insertDmtCstmzTitTrfData ( sheetOptionSearchOptionVO , "DTIC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_TRF_OPT DTIC Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getDmof().equals("1") ) {
                                dbDao.insertDmtCstmzTitTrfData ( sheetOptionSearchOptionVO , "DMOF" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_TRF_OPT DMOF Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getDtoc().equals("1") ) {
                                dbDao.insertDmtCstmzTitTrfData ( sheetOptionSearchOptionVO , "DTOC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_TRF_OPT DTOC Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getCtic().equals("1") ) {
                                dbDao.insertDmtCstmzTitTrfData ( sheetOptionSearchOptionVO , "CTIC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_TRF_OPT CTIC Insert Done");
                            }
                            if ( sheetOptionTermTitleListUpVOs[i].getCtoc().equals("1") ) {
                                dbDao.insertDmtCstmzTitTrfData ( sheetOptionSearchOptionVO , "CTOC" , sheetOptionTermTitleListUpVOs[i].getSeqq() , account );
                                log.debug("\n ####### Sheep Option DMT_CSTMZ_TIT_TRF_OPT CTOC Insert Done");
                            }                             
                        }
                        
                        rCnt++;
                    } // IF
                } // FOR

            }
//        } catch (DAOException ex) {
//            throw new EventException(ex.getMessage(),ex);
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        }
        return rCnt+"" ;
    }

    


    /**
    * [Sheet Setting Screen]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @return String
    * @exception EventException
    */
    public String searchSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO ) throws EventException {
        try {
            return dbDao.searchSheetSet ( sheetSetSearchOptionVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Sheet Setting Screen]占쏙옙[DELETE/INSERT] 占썩뫖�뀐옙占�br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String saveSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws EventException {
        try {
            dbDao.removeSheetSet ( sheetSetSearchOptionVO , account );
            return dbDao.saveSheetSet ( sheetSetSearchOptionVO , account );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Sheet Setting Screen]占쏙옙[DELETE] 占썩뫖�뀐옙占�br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String removeSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws EventException {
        try {
            return dbDao.removeSheetSet ( sheetSetSearchOptionVO , account );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }

    /**
     * Group Invoice �쒙옙Create 占쎌뮆��
     * @param InvoiceGroupParamVO invoiceGroupParamVO
     * @param ConfirmChargeListVO[] confirmChargeListVOs
     * @param SignOnUserAccount account
     * @return InvoiceGroupMgtVO
     * @throws EventException
     */
    public InvoiceGroupMgtVO issueInvoiceByGroup(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException {
    	String sBkgNo = "";
    	String invoice_no 	= "";
    	String inv_sts_cd	= "";
    	String ar_if_cd		= "";
    	
    	InvoiceGroupMgtVO reInvoiceGroupMgtVO = new InvoiceGroupMgtVO();
    	List<ConfirmChargeListVO> reConfirmChargeListVOs = new ArrayList<ConfirmChargeListVO>();
    	ConfirmChargeListVO reConfirmChargeListVO = new ConfirmChargeListVO();
    	InvoiceGroupParamVO reInvoiceGroupParamVO = new InvoiceGroupParamVO();
    	
    	IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
    	List<InvoiceIssueVO> invoiceIssueList	  = null;
    	List<ManualKeyByBookingVO> manualKeyByBookingVOS 	= null;
    	
    	int inv_qty = 0;
    	String issue_date = "";

    	double grpOrgChgAmt = 0;
    	double grpScRfaExptAmt = 0; 
    	double grpAftExptDcAmt = 0;
    	double grpBilAmt = 0;
    	int grpCntrCnt = 0;

    	double grpInvAmt = 0;
   	
    	String curr_ofc_date = "";

		String grpDmdtTrfCd = "";
		String grpBkgNo = "";

//		String dmdt_inv_no = "";

		String DmdtInvStsCd = "";
		String DmdtArIfCd = "";
		
		String InvCurrCd = "";
		String InvChgAmt = "";
		String TaxRto = "";
		String TaxAmt = "";
		String InvAmt = "";
		
		String InvNewRptFlg = "N";
		
		// 인도세법 변경 후 사용되는 Tax AMT 변수
		double idaCgstAmt = 0;
		double idaSgstAmt = 0;
		double idaIgstAmt = 0;
		double idaUgstAmt = 0;
		
		ConfirmChargeListVO confirmChargeVO = new ConfirmChargeListVO();
    	
    	try {
    		curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());//占쎄쑴�깍옙�깆쁽
    		grpBkgNo = invoiceGroupParamVO.getGrpBkgNo();
    		grpDmdtTrfCd = invoiceGroupParamVO.getGrpDmdtTrfCd();
    		InvNewRptFlg = invoiceGroupParamVO.getInvNewRptFlg();
    		
    		log.debug("\n\n[ GROUP INVOICE] SGroupBy :: " + invoiceGroupParamVO.getSGroupBy());
    		//#########################################################
    		// Group by (B/L No(BKG No)) 로직 실행
    		//#########################################################
    		if ("1".equals(invoiceGroupParamVO.getSGroupBy())) {
    		
	    		for (int i = 0; i < confirmChargeListVOs.length; i++) {
	        		log.debug("confirmChargeListVOs check_box["+i+"]==>"+confirmChargeListVOs[i].getCheckBox());

		    		if (confirmChargeListVOs[i].getBlNo().equals("")) {
		    		    String bl_no = dbDao.searchBKGBlNo(confirmChargeListVOs[i].getBkgNo());
		    		    if (StringUtils.isEmpty(bl_no)) {
		    		    	reInvoiceGroupParamVO.setErrCode("DMT01152");
		    		        log.error("\n BC bkg_no >>>>"+confirmChargeListVOs[i].getBkgNo()+"<<<<");
		               		log.error("\n BC DMT01152 ERROR [There is no B/L No.]");
		    		     } 
		    		     else {
		    		    	 confirmChargeListVOs[i].setBlNo(bl_no);
		    		     }
		    		}	
		    		
		    		// B/L No. 가 존재할 경우
		    		if (!StringUtils.isEmpty(confirmChargeListVOs[i].getBlNo())) {  
		    		   
		    			// CHG 가 미선택된 경우
		    			if ("0".equals(confirmChargeListVOs[i].getCheckBox())) {

		    				reConfirmChargeListVO = new ConfirmChargeListVO();
		    				reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
		    				reConfirmChargeListVO.setDmdtInvNo(confirmChargeListVOs[i].getDmdtInvNo());
		    				reConfirmChargeListVO.setDmdtInvStsCd(confirmChargeListVOs[i].getDmdtInvStsCd());
		    				reConfirmChargeListVO.setDmdtArIfCd(confirmChargeListVOs[i].getDmdtArIfCd());
		    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
		    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
		    				reConfirmChargeListVO.setCntrCnt(confirmChargeListVOs[i].getCntrCnt());
		    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
		    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
		    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
		    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
		    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
		    				reConfirmChargeListVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
		    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
		    				reConfirmChargeListVO.setArCurrCd(confirmChargeListVOs[i].getArCurrCd());
		    				reConfirmChargeListVO.setInvAmt(confirmChargeListVOs[i].getInvAmt());
		    				reConfirmChargeListVO.setInvTaxRto(confirmChargeListVOs[i].getInvTaxRto());
		    				reConfirmChargeListVO.setInvTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
		    				reConfirmChargeListVO.setInvPayableAmt(confirmChargeListVOs[i].getInvPayableAmt());
		    				reConfirmChargeListVO.setBzcTrfCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
		    				reConfirmChargeListVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
		    				reConfirmChargeListVO.setScRfaExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
		    				reConfirmChargeListVO.setAftExptDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
		    				reConfirmChargeListVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
		    				reConfirmChargeListVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
		    				reConfirmChargeListVO.setVslCd(confirmChargeListVOs[i].getVslCd());
		    				reConfirmChargeListVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
		    				reConfirmChargeListVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
		    				reConfirmChargeListVO.setPodCd(confirmChargeListVOs[i].getPodCd());
		    				reConfirmChargeListVO.setPolCd(confirmChargeListVOs[i].getPolCd());
		    				reConfirmChargeListVO.setPorCd(confirmChargeListVOs[i].getPorCd());
		    				reConfirmChargeListVO.setDelCd(confirmChargeListVOs[i].getDelCd());
		    				
		    				reConfirmChargeListVO.setIdaLoclTax(confirmChargeListVOs[i].getIdaLoclTax());
		    				reConfirmChargeListVO.setIdaLoclTaxRt(confirmChargeListVOs[i].getIdaLoclTaxRt());
		    				reConfirmChargeListVO.setIdaN2ndLoclTax(confirmChargeListVOs[i].getIdaN2ndLoclTax());
		    				reConfirmChargeListVO.setIdaN2ndLoclTaxRt(confirmChargeListVOs[i].getIdaN2ndLoclTaxRt());
	
		    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
		    				
		    				continue;
		    			}
		    			// CHG 가 선택된 경우
		    			else {
		    				
		    				//==================================================================================================================================================
		    				// 1. Invoice nbr 생성을 Combined Invoice nbr for selected BKGs 방식으로 처리.
		    				//    다수개의 BKG 을 1개의 Invoice 로 생성한다.
		    				//==================================================================================================================================================
		    				if ("GRP".equals(invoiceGroupParamVO.getSGroupInv())) {
		    					// 첫번재 CHG 일 경우에 대한 처리
		    					if (i == 0) {
		    						
		    			            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
		    			            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
		    			            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
		    			            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
		    			            invoiceNoGenCondVO.setDmdtTrfCd(grpDmdtTrfCd);
		    			            // [ Invoice No. 채번 로직 실행 ]==========================================================
		    			            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
		    			            // [ Invoice No. 채번 로직 실행후 결과처리 ]===============================================		
			    		            if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
				    					reInvoiceGroupParamVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
				    					reInvoiceGroupParamVO.setErrMsg(invoiceNoGenVO.getErrMsg());			    		            	
				    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
				    					return reInvoiceGroupMgtVO;
			    		            }
			    		            invoice_no = invoiceNoGenVO.getDmdtInvNo();		    			            
		    			            //=========================================================================================
			    					String grpBkgFlg = "N";
			    					for (ConfirmChargeListVO confirmChargeListVO : confirmChargeListVOs) {
				    					grpOrgChgAmt = grpOrgChgAmt + Double.parseDouble(confirmChargeListVO.getOrgChgAmt());
				    					grpScRfaExptAmt = grpScRfaExptAmt + Double.parseDouble(confirmChargeListVO.getScRfaExptAmt());
				    					grpAftExptDcAmt = grpAftExptDcAmt + Double.parseDouble(confirmChargeListVO.getAftExptDcAmt());
				    					grpBilAmt = grpBilAmt + Double.parseDouble(confirmChargeListVO.getBilAmt());
				    					grpCntrCnt = grpCntrCnt + Integer.parseInt(confirmChargeListVO.getCntrCnt());
					    				grpInvAmt = grpInvAmt + Double.parseDouble(confirmChargeListVO.getInvAmt());
					
				    					if (grpBkgNo.equals(confirmChargeListVO.getBkgNo()) && grpBkgFlg.equals("N")) {
				    						confirmChargeVO = confirmChargeListVO;
				    						grpBkgFlg = "Y";
				    					}
				    				}
	
				    	            // addInvoiceMain
				    	            DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
				    	            dmtInvMnVO.setDmdtInvNo(invoice_no);
				    	            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setDmdtTrfCd(confirmChargeVO.getDmdtTrfCd());
				    	            dmtInvMnVO.setIoBndCd(confirmChargeVO.getDmdtTrfCd().substring(2, 3));//dmif
				    	            dmtInvMnVO.setDmdtChgTpCd(invoiceGroupParamVO.getSChargeType());
				    	            dmtInvMnVO.setMnlInpFlg("N");
				    	            dmtInvMnVO.setMnlInvSndFlg("N");
				    	            dmtInvMnVO.setMnlInvRmk("");
				    	            dmtInvMnVO.setDmdtMnlInvRsnCd("");
				    	            dmtInvMnVO.setBkgNo(confirmChargeVO.getBkgNo());
				    	            dmtInvMnVO.setBlNo(confirmChargeVO.getBlNo());
				    	            dmtInvMnVO.setVslCd(confirmChargeVO.getVslCd());
				    	            dmtInvMnVO.setSkdVoyNo(confirmChargeVO.getSkdVoyNo());
				    	            dmtInvMnVO.setSkdDirCd(confirmChargeVO.getSkdDirCd());
				    	            dmtInvMnVO.setDmdtPayrTpCd("");
				    	            // Vendor
				    	            if (confirmChargeVO.getCustCd().length() <= 6) {
				    	            	//ActPayr
				    	                dmtInvMnVO.setActPayrCntCd("00");
				    	                dmtInvMnVO.setActPayrSeq(confirmChargeVO.getCustCd());
				    	                
				    	                //Cust
				    	                dmtInvMnVO.setCustCntCd("00");
				    	                dmtInvMnVO.setCustSeq(confirmChargeVO.getCustCd());
				    	            }
				    	            // Customer
				    	            else {
				    	            	//ActPayr
					    	           	dmtInvMnVO.setActPayrCntCd(confirmChargeVO.getCustCd().substring(0, 2));
					    	            dmtInvMnVO.setActPayrSeq(confirmChargeVO.getCustCd().substring(2));
					    	            
					    	            //Cust
				    	                dmtInvMnVO.setCustCntCd(confirmChargeVO.getCustCd().substring(0, 2));
				    	                dmtInvMnVO.setCustSeq(confirmChargeVO.getCustCd().substring(2));
				    	            }
	
				    	            if (confirmChargeVO.getVslCd().equals("HJXX") 
				    	            		|| confirmChargeVO.getVslCd().equals("HJYY")
				    	            		|| confirmChargeVO.getVslCd().equals("HJZZ")) {
				    	                dmtInvMnVO.setVslCd("CFDR");
				    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
				    	                dmtInvMnVO.setSkdDirCd("E");
				    	            } 
				    	            else {
				    	                dmtInvMnVO.setVslCd(confirmChargeVO.getVslCd());
				    	                dmtInvMnVO.setSkdVoyNo(confirmChargeVO.getSkdVoyNo());
				    	                dmtInvMnVO.setSkdDirCd(confirmChargeVO.getSkdDirCd());
				    	            }
				    	            
				    	            dmtInvMnVO.setDmdtPayrCntcPntNm("");
				    	            dmtInvMnVO.setPorCd(confirmChargeVO.getPorCd());
				    	            dmtInvMnVO.setPolCd(confirmChargeVO.getPolCd());
				    	            dmtInvMnVO.setPodCd(confirmChargeVO.getPodCd());
				    	            dmtInvMnVO.setDelCd(confirmChargeVO.getDelCd());
				    	            dmtInvMnVO.setScNo(confirmChargeVO.getScNo());
				    	            dmtInvMnVO.setRfaNo(confirmChargeVO.getRfaNo());
				    	            dmtInvMnVO.setTaaNo(confirmChargeVO.getTaaNo());
				    	            dmtInvMnVO.setChgCurrCd(confirmChargeVO.getBzcTrfCurrCd());
				    	            
				    	            dmtInvMnVO.setOrgChgAmt(JSPUtil.toDecimalFormat(grpOrgChgAmt, "#.##"));
				    	            dmtInvMnVO.setDmdtExptAmt(JSPUtil.toDecimalFormat(grpScRfaExptAmt, "#.##"));
				    	            dmtInvMnVO.setDcAmt(JSPUtil.toDecimalFormat(grpAftExptDcAmt, "#.##"));
				    	            dmtInvMnVO.setBilAmt(JSPUtil.toDecimalFormat(grpBilAmt, "#.##"));
				    	            dmtInvMnVO.setBkgCntrQty(String.valueOf(grpCntrCnt));
				    	            dmtInvMnVO.setInvCurrCd(confirmChargeVO.getArCurrCd());
				    	            dmtInvMnVO.setInvXchRt(confirmChargeVO.getInvXchRt());
				    	            dmtInvMnVO.setInvChgAmt(JSPUtil.toDecimalFormat(grpInvAmt, "#.##"));
				    	            String taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : invoiceGroupParamVO.getTaxRto();
				    	            dmtInvMnVO.setTaxRto(taxRto);
				    	            dmtInvMnVO.setTaxAmt(invoiceGroupParamVO.getTaxAmt());
				    	            dmtInvMnVO.setInvAmt(invoiceGroupParamVO.getInvAmt());
				    	            
				    	            dmtInvMnVO.setAftExptAproNo("");
				    	            dmtInvMnVO.setAftInvAdjAmt("");
				    	            dmtInvMnVO.setCrInvNo("");
				    	            dmtInvMnVO.setInvRmk("");
				    	            dmtInvMnVO.setDmdtArIfCd("N");
				    	            dmtInvMnVO.setArIfNo("");
				    	            dmtInvMnVO.setArIfDt("");
				    	            dmtInvMnVO.setArIfUsrId("");
				    	            dmtInvMnVO.setArIfOfcCd("");
				    	            dmtInvMnVO.setDmdtInvStsCd("I");
				    	            dmtInvMnVO.setDmdtCxlRsnCd("");
				    	            dmtInvMnVO.setCxlRmk("");
				    	            dmtInvMnVO.setInvHldRsnCd("");
				    	            dmtInvMnVO.setInvHldRmk("");
				    	            dmtInvMnVO.setInvPrtFlg("");
				    	            dmtInvMnVO.setInvRefNo("");
				    	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setNtcKntCd("");
	
				    	            // 인도세법 변경 전
				    	            dmtInvMnVO.setIdaCgstRto(invoiceGroupParamVO.getIdaCgstRto());
			    	            	dmtInvMnVO.setIdaCgstAmt(invoiceGroupParamVO.getIdaCgstAmt());
			    	            	dmtInvMnVO.setIdaSgstRto(invoiceGroupParamVO.getIdaSgstRto());
			    	            	dmtInvMnVO.setIdaSgstAmt(invoiceGroupParamVO.getIdaSgstAmt());		
			    	            	dmtInvMnVO.setIdaIgstRto(invoiceGroupParamVO.getIdaIgstRto());
			    	            	dmtInvMnVO.setIdaIgstAmt(invoiceGroupParamVO.getIdaIgstAmt());
			    	            	dmtInvMnVO.setIdaUgstRto(invoiceGroupParamVO.getIdaUgstRto());
			    	            	dmtInvMnVO.setIdaUgstAmt(invoiceGroupParamVO.getIdaUgstAmt());			    	            	
				    	            
				    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeVO.getBkgNo());
				    	            
				    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
				    	            	dmtInvMnVO.setRcvTermCd("");
				    	            	dmtInvMnVO.setDeTermCd("");
				    	            } 
				    	            else {
				    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
				    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
				    	            }
				    	            
				    	            dmtInvMnVO.setInvNewRptFlg(InvNewRptFlg);
				    	            dbDao.addInvoiceMain(dmtInvMnVO);		    	            
	
				    	            issue_date = dmtInvMnVO.getCreDt();					    	            
				    				DmdtInvStsCd = dmtInvMnVO.getDmdtInvStsCd();
				    				DmdtArIfCd = dmtInvMnVO.getDmdtArIfCd();
	
				    				InvCurrCd = dmtInvMnVO.getInvCurrCd();
				    				InvChgAmt = dmtInvMnVO.getInvChgAmt();
				    				TaxRto = dmtInvMnVO.getTaxRto();
				    				TaxAmt = dmtInvMnVO.getTaxAmt();
				    				InvAmt = dmtInvMnVO.getInvAmt();
		    					}	// 첫번재 CHG 일 경우에 대한 처리로직 종료    					
		    				} 
		    				//==================================================================================================================================================
		    				// 2. Invoice nbr 생성을 Individual Invoice nbr for selected BKGs 방식으로 처리.
		    				//    다수개의 BKG 을 각각의 Invoice 로 생성한다.
		    				// ==================================================================================================================================================
		    				else {
		    					
	    			            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
	    			            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
	    			            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
	    			            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
	    			            invoiceNoGenCondVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	    			            // [ Invoice No. 채번 로직 실행 ]==========================================================
	    			            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
	    			            // [ Invoice No. 채번 로직 실행후 결과처리 ]===============================================		
		    		            if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
			    					reInvoiceGroupParamVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
			    					reInvoiceGroupParamVO.setErrMsg(invoiceNoGenVO.getErrMsg());			    		            	
			    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
			    					return reInvoiceGroupMgtVO;
		    		            }
		    		            invoice_no = invoiceNoGenVO.getDmdtInvNo();	    			            
	    			            //=========================================================================================		    					
		    					
			    	            // addInvoiceMain
			    	            DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
			    	            dmtInvMnVO.setDmdtInvNo(invoice_no);
			    	            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
			    	            dmtInvMnVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            dmtInvMnVO.setIoBndCd(confirmChargeListVOs[i].getDmdtTrfCd().substring(2, 3));//dmif
			    	            dmtInvMnVO.setDmdtChgTpCd(invoiceGroupParamVO.getSChargeType());
			    	            dmtInvMnVO.setMnlInpFlg("N");
			    	            dmtInvMnVO.setMnlInvSndFlg("N");
			    	            dmtInvMnVO.setMnlInvRmk("");
			    	            dmtInvMnVO.setDmdtMnlInvRsnCd("");
			    	            dmtInvMnVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            dmtInvMnVO.setBlNo(confirmChargeListVOs[i].getBlNo());
			    	            dmtInvMnVO.setVslCd(confirmChargeListVOs[i].getVslCd());
			    	            dmtInvMnVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
			    	            dmtInvMnVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
			    	            dmtInvMnVO.setDmdtPayrTpCd("");
			    	            
			    	            // Vendor
			    	            if (confirmChargeListVOs[i].getCustCd().length() <= 6) {
			    	            	//ActPayr
			    	                dmtInvMnVO.setActPayrCntCd("00");
			    	                dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd());
			    	                
			    	                //Cust
			    	                dmtInvMnVO.setCustCntCd("00");
			    	                dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd());
			    	            }
			    	            // Customer
			    	            else {
			    	            	//ActPayr
				    	           	dmtInvMnVO.setActPayrCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
				    	            dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd().substring(2));
				    	            
				    	            //Cust
			    	                dmtInvMnVO.setCustCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
			    	                dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd().substring(2));
			    	            }
	
			    	            if (confirmChargeListVOs[i].getVslCd().equals("HJXX") 
			    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJYY")
			    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJZZ")) {
			    	                dmtInvMnVO.setVslCd("CFDR");
			    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
			    	                dmtInvMnVO.setSkdDirCd("E");
			    	            }
			    	            else {
			    	                dmtInvMnVO.setVslCd(confirmChargeListVOs[i].getVslCd());
			    	                dmtInvMnVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
			    	                dmtInvMnVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
			    	            }
			    	            
			    	            dmtInvMnVO.setDmdtPayrCntcPntNm("");
			    	            dmtInvMnVO.setPorCd(confirmChargeListVOs[i].getPorCd());
			    	            dmtInvMnVO.setPolCd(confirmChargeListVOs[i].getPolCd());
			    	            dmtInvMnVO.setPodCd(confirmChargeListVOs[i].getPodCd());
			    	            dmtInvMnVO.setDelCd(confirmChargeListVOs[i].getDelCd());
			    	            dmtInvMnVO.setScNo(confirmChargeListVOs[i].getScNo());
			    	            dmtInvMnVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
			    	            dmtInvMnVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
			    	            dmtInvMnVO.setChgCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
			    	            dmtInvMnVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
			    	            dmtInvMnVO.setDmdtExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
			    	            dmtInvMnVO.setDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
			    	            dmtInvMnVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
			    	            dmtInvMnVO.setBkgCntrQty(confirmChargeListVOs[i].getCntrCnt());
			    	            dmtInvMnVO.setInvCurrCd(confirmChargeListVOs[i].getArCurrCd());
			    	            dmtInvMnVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
			    	            dmtInvMnVO.setInvChgAmt(confirmChargeListVOs[i].getInvAmt());
			    	            String taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : confirmChargeListVOs[i].getInvTaxRto();
			    	            dmtInvMnVO.setTaxRto(taxRto);				    	            
			    	            dmtInvMnVO.setTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
			    	            dmtInvMnVO.setInvAmt(confirmChargeListVOs[i].getInvPayableAmt());
			    	            dmtInvMnVO.setAftExptAproNo("");
			    	            dmtInvMnVO.setAftInvAdjAmt("");
			    	            dmtInvMnVO.setCrInvNo("");
			    	            dmtInvMnVO.setInvRmk("");
			    	            dmtInvMnVO.setDmdtArIfCd("N");
			    	            dmtInvMnVO.setArIfNo("");
			    	            dmtInvMnVO.setArIfDt("");
			    	            dmtInvMnVO.setArIfUsrId("");
			    	            dmtInvMnVO.setArIfOfcCd("");
			    	            dmtInvMnVO.setDmdtInvStsCd("I");
			    	            dmtInvMnVO.setDmdtCxlRsnCd("");
			    	            dmtInvMnVO.setCxlRmk("");
			    	            dmtInvMnVO.setInvHldRsnCd("");
			    	            dmtInvMnVO.setInvHldRmk("");
			    	            dmtInvMnVO.setInvPrtFlg("");
			    	            dmtInvMnVO.setInvRefNo("");
			    	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
			    	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
			    	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
			    	            dmtInvMnVO.setNtcKntCd("");
	
			    	            // 인도세법 변경 전( Ratio 는 모두 동일하지만 Amount 는 Row ( BKG ) 당, 다르므로 아래와 같이 달리 처리한다. )
			    	            // 인도세법 변경 후, 적용될 새로운 Tax Ratio & Tax Amount
			    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {				    	            
			    	            	idaCgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaCgstAmt());
			    	            	idaSgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaSgstAmt());
			    	            	idaIgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaIgstAmt());
			    	            	idaUgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaUgstAmt());
			    	        		
			    	            	dmtInvMnVO.setIdaCgstRto(invoiceGroupParamVO.getIdaCgstRto());
			    	            	dmtInvMnVO.setIdaCgstAmt(confirmChargeListVOs[i].getIdaCgstAmt());
			    	            	dmtInvMnVO.setIdaSgstRto(invoiceGroupParamVO.getIdaSgstRto());
			    	            	dmtInvMnVO.setIdaSgstAmt(confirmChargeListVOs[i].getIdaSgstAmt());		
			    	            	dmtInvMnVO.setIdaIgstRto(invoiceGroupParamVO.getIdaIgstRto());
			    	            	dmtInvMnVO.setIdaIgstAmt(confirmChargeListVOs[i].getIdaIgstAmt());
			    	            	dmtInvMnVO.setIdaUgstRto(invoiceGroupParamVO.getIdaUgstRto());
			    	            	dmtInvMnVO.setIdaUgstAmt(confirmChargeListVOs[i].getIdaUgstAmt());
			    	            }	
			    	            
			    	            //2011.04.25. 占쎄쑬�ヨ�����곕떽占�issueInvoiceByGroup
			    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeListVOs[i].getBkgNo());
			    	            
			    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
			    	            	dmtInvMnVO.setRcvTermCd("");
			    	            	dmtInvMnVO.setDeTermCd("");
			    	            } 
			    	            else {
			    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
			    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
			    	            }
			    	            
			    	            dmtInvMnVO.setInvNewRptFlg(InvNewRptFlg);
			    	            dbDao.addInvoiceMain(dmtInvMnVO);		    	            
	
			    	            issue_date = dmtInvMnVO.getCreDt();
	
			    				DmdtInvStsCd = dmtInvMnVO.getDmdtInvStsCd();
			    				DmdtArIfCd = dmtInvMnVO.getDmdtArIfCd();
	
			    				InvCurrCd = dmtInvMnVO.getInvCurrCd();
			    				InvChgAmt = dmtInvMnVO.getInvChgAmt();
			    				TaxRto = dmtInvMnVO.getTaxRto();
			    				TaxAmt = dmtInvMnVO.getTaxAmt();
			    				InvAmt = dmtInvMnVO.getInvAmt();
		    				} // Invoice nbr 생성 로직 종료
	    				
		    	            inv_qty++;
		    	            
		    	            //// List Setting
		    	            reConfirmChargeListVO = new ConfirmChargeListVO();
		    	            
		    	            reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
		    	            reConfirmChargeListVO.setDmdtInvNo(invoice_no);			//invoice no
		    				reConfirmChargeListVO.setDmdtInvStsCd(DmdtInvStsCd);
		    				reConfirmChargeListVO.setDmdtArIfCd(DmdtArIfCd);
		    				
		    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
		    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
		    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
		    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
		    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
		    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
		    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
		    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
		    				reConfirmChargeListVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
		    				
		    				reConfirmChargeListVO.setArCurrCd(InvCurrCd);	
		    				reConfirmChargeListVO.setInvAmt(InvChgAmt);
		    				reConfirmChargeListVO.setInvTaxRto(TaxRto);
		    				reConfirmChargeListVO.setInvTaxAmt(TaxAmt);
		    				reConfirmChargeListVO.setInvPayableAmt(InvAmt);
		    				
		    				reConfirmChargeListVO.setBzcTrfCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
		    				reConfirmChargeListVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
		    				reConfirmChargeListVO.setScRfaExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
		    				reConfirmChargeListVO.setAftExptDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
		    				reConfirmChargeListVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
		    				
		    				reConfirmChargeListVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());	//Ex.Rate
		    				
		    				reConfirmChargeListVO.setVslCd(confirmChargeListVOs[i].getVslCd());
		    				reConfirmChargeListVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
		    				reConfirmChargeListVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
		    				reConfirmChargeListVO.setPodCd(confirmChargeListVOs[i].getPodCd());
		    				reConfirmChargeListVO.setPolCd(confirmChargeListVOs[i].getPolCd());
		    				reConfirmChargeListVO.setPorCd(confirmChargeListVOs[i].getPorCd());
		    				reConfirmChargeListVO.setDelCd(confirmChargeListVOs[i].getDelCd());
	
		    				issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());		//charge office code
		    	            issuedInvoiceParamVO.setSFmDt(invoiceGroupParamVO.getSFmDt());
		    	            issuedInvoiceParamVO.setSToDt(invoiceGroupParamVO.getSToDt());
		    	            
		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
		    	            if (invoiceIssueList == null || invoiceIssueList.size() == 0) {
		    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
		    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
	    	            		message = JSPUtil.replace(message, "[Value]", "Save");
		    					reInvoiceGroupParamVO.setErrMsg(message);
		    					
		    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
		    					return reInvoiceGroupMgtVO;
		    	            }
		    	            reConfirmChargeListVO.setCntrCnt(""+invoiceIssueList.size());		//占썬끉��INVOICE 占쎌빘苑�옙占폚NTR CNT嚥∽옙占쎌꼷�숋옙�뤿연 筌ｌ꼶��
		    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
		    	            for (int j = 0; j<invoiceIssueList.size(); j++) {
		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
		    	            	
		    	            	DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
	
		    	                dmtInvDtlVO.setSvrId(invoiceIssueDetail.getSvrId());
		    	                dmtInvDtlVO.setCntrNo(invoiceIssueDetail.getCntrNo());
		    	                dmtInvDtlVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
		    	                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
		    	                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
		    	                dmtInvDtlVO.setChgSeq(invoiceIssueDetail.getChgSeq());
		    	                
		    	                ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
		    	                chargeCalculationContainerVO = dbDao.searchChargeStatusCd(dmtInvDtlVO);
		    	                String chg_sts_cd = chargeCalculationContainerVO.getDmdtChgStsCd();
		    	                		
		    	            	if ("I".equals(chg_sts_cd)) {
			    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
			    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
		    	            		message = JSPUtil.replace(message, "[Value]", "Save");
			    					reInvoiceGroupParamVO.setErrMsg(message);
			    					
			    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
			    					return reInvoiceGroupMgtVO;	    	            		
		    	            	}
		    	            	
		    	            	int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
		    	            	
		    	            	// [ Container Invoice Amount ]
		    	                double cntrInvAmt = 0;
		    	                cntrInvAmt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
		    	                cntrInvAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), cntrInvAmt);

		    	                // [ Tax Amount ]
		    	                InvoiceAmtVO invoiceAmtVO = this.calculateInvoiceAmt(invoiceGroupParamVO, cntrInvAmt);
		    	                double taxAmt = Double.parseDouble(invoiceAmtVO.getTaxAmt());
		    	                taxAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), taxAmt);
		    	                dmtInvDtlVO.setDmdtInvNo(invoice_no);
		    	                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
		    	                dmtInvDtlVO.setInvDtlSeq(String.valueOf(inv_dtl_seq));
		    	                dmtInvDtlVO.setCntrTpszCd(invoiceIssueDetail.getCntrTpszCd());
		    	                dmtInvDtlVO.setFmMvmtDt(invoiceIssueDetail.getFmMvmtDt());
		    	                dmtInvDtlVO.setToMvmtDt(invoiceIssueDetail.getToMvmtDt());
		    	                dmtInvDtlVO.setFtDys(invoiceIssueDetail.getFtDys());
		    	                dmtInvDtlVO.setFtCmncDt(invoiceIssueDetail.getFtCmncDt());
		    	                dmtInvDtlVO.setFtEndDt(invoiceIssueDetail.getFtEndDt());
		    	                dmtInvDtlVO.setFxFtOvrDys(invoiceIssueDetail.getFxFtOvrDys());
		    	                dmtInvDtlVO.setOrgChgAmt(invoiceIssueDetail.getOrgChgAmt());
		    	                dmtInvDtlVO.setScRfaExptAmt(invoiceIssueDetail.getExptAmt());
		    	                dmtInvDtlVO.setAftExptDcAmt(invoiceIssueDetail.getAftExptDcAmt());
		    	                dmtInvDtlVO.setBilAmt(invoiceIssueDetail.getBilAmt());
		    	                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntrInvAmt, "#.##"));
		    	                dmtInvDtlVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
		    	                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));
		    	                dmtInvDtlVO.setInvPrtFlg("");
		    	                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
		    	                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
		    	                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
		    	                dbDao.addInvoiceDetail(dmtInvDtlVO);
	    	                
		    	                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
		    	                overdayNDivParmVO.setSvrId(invoiceIssueDetail.getSvrId());
		    	                overdayNDivParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
		    	                overdayNDivParmVO.setCnmvCycNo(invoiceIssueDetail.getCntrCycNo());
		    	                overdayNDivParmVO.setDttCode(invoiceIssueDetail.getDmdtTrfCd());
		    	                overdayNDivParmVO.setLocDiv(invoiceIssueDetail.getDmdtChgLocDivCd());
		    	                overdayNDivParmVO.setDccSeq(invoiceIssueDetail.getChgSeq());
		    	                
		    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
		    	                
		    	                CalculationParmVO calculationParmVO = new CalculationParmVO();
		    	                
		    	                String trfAplyTpCd = invoiceIssueDetail.getDmdtTrfAplyTpCd();
		    	                calculationParmVO.setDcApplRate(trfAplyTpCd);
		    	                
	    						// basicCalculation - Baisc Tariff
	    						calculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
	    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
	    						calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());
	    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
	    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
	    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());
	    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
	    						calculationParmVO.setFtDys(invoiceIssueDetail.getFtDys());						// 2014.03.12
	    						calculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd());			// 2014.03.12
	    						calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());			// 2014.03.12
	    						calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);										// 2014.03.12
	    						
	    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
	
	    						/*
	    						Charge에 적용된 Tariff에 따라 Charge금액을 계산한다.
	    					    A) "G"(Basic Tariff)인 경우 Basic Tariff의 Rate별 계산금액을 조회한다
	    					    B) "B"(Before Exception)인 경우 Before Exception Tariff의 Rate별 계산금액을 조회하고 Before Exception의 Currency를 조회한다
	    					    C) "S"(S/C Exception)인 경우 S/C Exception Tariff의 Rate별 계산금액을 조회하고 S/C Exception의 Currency를 조회한다
	    					    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
	    					         1) 적용된 CurrencyExchange Rate를 조회하여 Charge 계산금액을 Exchange Rate를 곱한다
	    					         2) 1)에서 계산한 금액을 Currency별로 반올림처리 한다
	    						*/
	    						//======================================================
	    						// 1. CHG 계산시 적용된 Rate 가 Basic Tariff 일 경우
	    						//======================================================    						
	    						if ("G".equals(trfAplyTpCd)) {
	    							String firstSvrID = null;
	    							
	    							//office transfer check
	    			            	if ("Y".equals(invoiceIssueDetail.getOfcTrnsFlg())) {
	    			            		
	    			            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	    			            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	    			            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
	    			            		chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
	    			            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
	    			            		chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
	    			            		chargeCalculationParmVO.setBkgNo(invoiceIssueDetail.getBkgNo());
	    			            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd()); //2011.10.28
	    			            		
	    			    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
	    			            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	    			            	} 
	    			            	else {
	    			            		firstSvrID = invoiceIssueDetail.getSvrId();
	    			            	}
    							
	    							// basicCalculation - Baisc Tariff
	    							calculationParmVO.setSvrId(firstSvrID);
	    							calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	    							calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
	    							calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
	    							calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
	    							calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
	    							calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
	    							calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
	    							calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());			// 2014.03.12
	    							if (!StringUtils.isEmpty(invoiceIssueDetail.getScRfaExptAplyDt())) {		// 2014.03.12
	    								calculationParmVO.setDmdtTrfAplyTpCd("B");									
	    								calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
	    							} 
	    							else {
	    								calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
	    							}
	    						} 
	    						//======================================================
	    						// 2. CHG 계산시 적용된 Rate 가 RFA Exception 일 경우
	    						//======================================================
	    						else if ("B".equals(trfAplyTpCd)) {
	    							// beforeCalculation - Before BKG Exception
	    							calculationParmVO.setDarNo(invoiceIssueDetail.getRfaExptDarNo());
	    							calculationParmVO.setMapgSeq(invoiceIssueDetail.getRfaExptMapgSeq());
	    							calculationParmVO.setVerSeq(invoiceIssueDetail.getRfaExptVerSeq());
	    							calculationParmVO.setDtlSeq(invoiceIssueDetail.getRfaRqstDtlSeq());
	    							calculationParmVO.setCmbSeq("1");
	    							calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
	    							calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
	    							calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
	    						}
	    						//======================================================
	    						// 3. CHG 계산시 적용된 Rate 가 S/C Exception 일 경우
	    						//======================================================    						
	    						else if ("S".equals(trfAplyTpCd)) {
	    							// scCalculation - SC Exception
	    							calculationParmVO.setPropNo(invoiceIssueDetail.getScNo());
	    							calculationParmVO.setVerSeq(invoiceIssueDetail.getScExptVerSeq());
	    							calculationParmVO.setGrpSeq(invoiceIssueDetail.getScExptGrpSeq());
	    							calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
	    							calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());					
	    							calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
	    						}
    						                   					    
						    	//bbsChargeCalulation Input
						    	log.debug("\n basicCalculation.......................");				
						    	log.debug("\n svr_id 		      	= "+invoiceIssueDetail.getSvrId());				
						    	log.debug("\n dmdt_trf_cd 		  	= "+invoiceIssueDetail.getDmdtTrfCd());				
						    	log.debug("\n bzc_trf_seq 		  	= "+invoiceIssueDetail.getBzcTrfSeq());
						    	log.debug("\n bzc_dmdt_de_term_cd 	= "+invoiceIssueDetail.getBzcDmdtDeTermCd());
						    	log.debug("\n bzc_trf_grp_seq     	= "+invoiceIssueDetail.getBzcTrfGrpSeq());				
						    	log.debug("\n cntr_tpsz_cd 	      	= "+invoiceIssueDetail.getCntrTpszCd());				
						    	log.debug("\n org_ft_ovr_dys      	= "+invoiceIssueDetail.getOrgFtOvrDys());				
						    	log.debug("\n div_over_day 	      	= "+overdayNDivVO.getDivOverDay());				
						    	log.debug("\n bzc_trf_curr_cd     	= "+invoiceIssueDetail.getBzcTrfCurrCd());				
						    	log.debug("\n getFtDys 				= "+invoiceIssueDetail.getFtDys());			// 2014.03.12
								log.debug("\n getFmMvmtYdCd 		= "+invoiceIssueDetail.getFmMvmtYdCd());	// 2014.03.12
								log.debug("\n getBzcTrfAplyDt		= "+invoiceIssueDetail.getBzcTrfAplyDt());	// 2014.03.12
								log.debug("\n setDmdtTrfAplyTpCd	= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
	    						
	
	    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO); 
						        List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
					        
						        if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
						        	
						        	//addInvoiceRate
						        	for (int k = 0; k < chrgDtlVOS.size() ; k++) {
						                ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(k);
						                
						                //over_day > 0 占쏙옙野껋럩��쭕占쏙옙占쎌삢占쎌뮆��
						                if(Double.parseDouble(chrgDtlVO.getRtDay()) == 0 ) {
						                	continue;
						                }
						                
						                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
						                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
						                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
						                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
						                
						                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
						                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
						                dmtInvRtVO.setBzcTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
						                dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());
						                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
						                dmtInvRtVO.setBzcTrfRtSeq("");
						                
						                dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
						                dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
						                
						                dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
						                
		    		                    double inv_rt_amt = 0;
		    		                    double rt_ovr_chg_amt = 0;
		    		                    
	    		                    	inv_rt_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtRate());
	    		                    	inv_rt_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), inv_rt_amt);
	    		                    	rt_ovr_chg_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtChrg());
	    		                    	rt_ovr_chg_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), rt_ovr_chg_amt);
						                
		    		                    dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(inv_rt_amt, "#.##"));
		    		                    dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));
		    		                    
						                dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());
						                dmtInvRtVO.setCreUsrId(account.getUsr_id());
						                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
						                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
						                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
						                
						                dbDao.addInvoiceRate(dmtInvRtVO);
						        	}
						        }
					        
						        //======================================================
						        //Discount Amount + Exception Amount > 0
						        double dScRfaExptAmt = Double.parseDouble(invoiceIssueDetail.getExptAmt());
						        double dAftExptDcAmt = Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
						        double dCmdtExptAmt  = Double.parseDouble(invoiceIssueDetail.getCmdtExptAmt());
						        if(( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt != 0) && trfAplyTpCd.equals("G")) {
						        	double rt_ovr_chg_amt = 0;
						            rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
						        
						            DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
						            dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
						            dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
						            dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
						            dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
						            dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
						            dmtInvRtVO.setBzcTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
						            dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());
						            dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
						            dmtInvRtVO.setBzcTrfRtSeq("");
						            dmtInvRtVO.setFtOvrDys("0");
						            dmtInvRtVO.setFtUndDys("0");
						            dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) 疫뀀뜆釉�
						            dmtInvRtVO.setRtOvrDys("1");
						            dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) 疫뀀뜆釉�
						            dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());
						            dmtInvRtVO.setCreUsrId(account.getUsr_id());
						            dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
						            dmtInvRtVO.setUpdUsrId(account.getUsr_id());
						            dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
						            
						            dbDao.addInvoiceRate(dmtInvRtVO);
						        }
		    	            } // for 문 종료
		    			} // CHG 가 선택된 경우 Logic 종료
		    		} // B/L No. 가 존재할 경우 Logic 종료
	    		} // for 문 종료	
	    		
				//reInvoiceGroupParamVO Setting
				reInvoiceGroupParamVO = new InvoiceGroupParamVO();
	    		
				reInvoiceGroupParamVO.setInvQty(String.valueOf(inv_qty));
				reInvoiceGroupParamVO.setIssueDate(issue_date);
				reInvoiceGroupParamVO.setErrCode("");
				reInvoiceGroupParamVO.setErrMsg("");
	    	
    		} // Group by (B/L No(BKG No)) 로직 종료
    		//#########################################################
    		// Group by (Container) 로직 실행
    		//#########################################################
    		else {
    			log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> 시작");
	            double tot_org_chg_amt 		= 0;	//Charge Incurrend AMT
	            double tot_sc_rfa_expt_amt 	= 0;	//Charge Exception AMT
	            double tot_aft_expt_dc_amt 	= 0;	//Charge D/C AMT
	            double tot_bil_amt 			= 0;	//Charge Billable AMT
	            double tot_inv_amt 			= 0;	//Invoice Billing AMT
	            double tot_inv_tax_rto 		= 0;	//Invoice Tax(%)
	            double tot_inv_tax_amt 		= 0;	//Invoice Tax AMT
	            double tot_inv_payable_amt 	= 0;	//Invoice Payable AMT
	            int cntr_cnt 	= 0;
	            int sel_cntr	= 0;
	            
    			for (int i = 0; i < confirmChargeListVOs.length; i++) {
    				
    				log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " 처리 시작!!");
    				
		    		if (StringUtils.isEmpty(confirmChargeListVOs[i].getBlNo())) {
		    		   String bl_no = dbDao.searchBKGBlNo(confirmChargeListVOs[i].getBkgNo());
		    		    if (StringUtils.isEmpty(bl_no)) {
		    		        reInvoiceGroupParamVO.setErrCode("DMT01152");
		    		        log.error("\n BC bkg_no >>>>"+confirmChargeListVOs[i].getBkgNo()+"<<<<");
		              	    log.error("\n BC DMT01152 ERROR [There is no B/L No.]");
		    		    } 
		    		    else {
		    		    	confirmChargeListVOs[i].setBlNo(bl_no);
		    		    }
		    	    }	    				
		    		
		    		if (!StringUtils.isEmpty(confirmChargeListVOs[i].getBlNo())) {
		    			
		    			// CHG 가 미선택된 경우
		    			if ("0".equals(confirmChargeListVOs[i].getCheckBox())) {
		    				
		    				reConfirmChargeListVO = new ConfirmChargeListVO();
		    				reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
		    				reConfirmChargeListVO.setDmdtInvNo(confirmChargeListVOs[i].getDmdtInvNo());
		    				reConfirmChargeListVO.setDmdtInvStsCd(confirmChargeListVOs[i].getDmdtInvStsCd());
		    				reConfirmChargeListVO.setDmdtArIfCd(confirmChargeListVOs[i].getDmdtArIfCd());
		    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
		    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
		    				reConfirmChargeListVO.setCntrCnt(confirmChargeListVOs[i].getCntrCnt());
		    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
		    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
		    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
		    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
		    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
		    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
		    				reConfirmChargeListVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
		    				reConfirmChargeListVO.setArCurrCd(confirmChargeListVOs[i].getArCurrCd());
		    				reConfirmChargeListVO.setInvAmt(confirmChargeListVOs[i].getInvAmt());
		    				reConfirmChargeListVO.setInvTaxRto(confirmChargeListVOs[i].getInvTaxRto());
		    				reConfirmChargeListVO.setInvTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
		    				reConfirmChargeListVO.setInvPayableAmt(confirmChargeListVOs[i].getInvPayableAmt());
		    				reConfirmChargeListVO.setBzcTrfCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
		    				reConfirmChargeListVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
		    				reConfirmChargeListVO.setScRfaExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
		    				reConfirmChargeListVO.setAftExptDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
		    				reConfirmChargeListVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
		    				reConfirmChargeListVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
		    				reConfirmChargeListVO.setVslCd(confirmChargeListVOs[i].getVslCd());
		    				reConfirmChargeListVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
		    				reConfirmChargeListVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
		    				reConfirmChargeListVO.setPodCd(confirmChargeListVOs[i].getPodCd());
		    				reConfirmChargeListVO.setPolCd(confirmChargeListVOs[i].getPolCd());
		    				reConfirmChargeListVO.setPorCd(confirmChargeListVOs[i].getPorCd());
		    				reConfirmChargeListVO.setDelCd(confirmChargeListVOs[i].getDelCd());
		    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
		    			} 
		    			// CHG 가 선택된 경우
		    			else {
		    				log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 >> 처리 시작!!");
		    				
		    				//================================================
		    				//<< 첫번째 항목일 경우에만 실행되는 로직 시작 >>
		    				//================================================
	    					if (sel_cntr == 0) {
	    						log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 일 경우 ) >> 처리 시작!!");
	    						
			    				/*====================================================================
	 				               	   		[ Invoice nbr 선택에 따른 처리 로직 ]
				 				 =====================================================================
									   		1. Combined Invoice nbr for selected BKGs   실행
				 				 =====================================================================*/			    				
			    				if ("GRP".equals(invoiceGroupParamVO.getSGroupInv())) {

			    		            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
			    		            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
			    		            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
			    		            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
			    		            invoiceNoGenCondVO.setDmdtTrfCd(grpDmdtTrfCd);
			    		            // [ Invoice No. 채번 로직 실행 ]==========================================================
			    		            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
			    		            // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
			    		            if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
				    					reInvoiceGroupParamVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
				    					reInvoiceGroupParamVO.setErrMsg(invoiceNoGenVO.getErrMsg());			    		            	
				    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
				    					return reInvoiceGroupMgtVO;
			    		            }
			    		            invoice_no = invoiceNoGenVO.getDmdtInvNo(); 
			    		            //=========================================================================================	    					
			    					
			    					String grpBkgFlg = "N";
				    				for (int j=0; j<confirmChargeListVOs.length; j++) {

				    					grpOrgChgAmt = grpOrgChgAmt + Double.parseDouble(confirmChargeListVOs[j].getOrgChgAmt());
				    					grpScRfaExptAmt = grpScRfaExptAmt + Double.parseDouble(confirmChargeListVOs[j].getScRfaExptAmt());
				    					grpAftExptDcAmt = grpAftExptDcAmt + Double.parseDouble(confirmChargeListVOs[j].getAftExptDcAmt());
				    					grpBilAmt = grpBilAmt + Double.parseDouble(confirmChargeListVOs[j].getBilAmt());
					    				grpInvAmt = grpInvAmt + Double.parseDouble(confirmChargeListVOs[j].getInvAmt());
					    				
				    					if (grpBkgNo.equals(confirmChargeListVOs[j].getBkgNo()) && "N".equals(grpBkgFlg)) {
				    						confirmChargeVO = (ConfirmChargeListVO)confirmChargeListVOs[j];
				    						grpBkgFlg = "Y";
				    					}
				    				}

				    	            DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
				    	            dmtInvMnVO.setDmdtInvNo(invoice_no);
				    	            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setDmdtTrfCd(confirmChargeVO.getDmdtTrfCd());
				    	            dmtInvMnVO.setIoBndCd(confirmChargeVO.getDmdtTrfCd().substring(2, 3));//dmif
				    	            dmtInvMnVO.setDmdtChgTpCd(invoiceGroupParamVO.getSChargeType());
				    	            dmtInvMnVO.setMnlInpFlg("N");
				    	            dmtInvMnVO.setMnlInvSndFlg("N");
				    	            dmtInvMnVO.setMnlInvRmk("");
				    	            dmtInvMnVO.setDmdtMnlInvRsnCd("");
				    	            dmtInvMnVO.setBkgNo(confirmChargeVO.getBkgNo());
				    	            dmtInvMnVO.setBlNo(confirmChargeVO.getBlNo());
				    	            dmtInvMnVO.setVslCd(confirmChargeVO.getVslCd());
				    	            dmtInvMnVO.setSkdVoyNo(confirmChargeVO.getSkdVoyNo());
				    	            dmtInvMnVO.setSkdDirCd(confirmChargeVO.getSkdDirCd());
				    	            dmtInvMnVO.setDmdtPayrTpCd("");
				    	            
				    	            // Vendor
				    	            if(confirmChargeVO.getCustCd().length() <= 6) {
				    	            	//ActPayr
				    	                dmtInvMnVO.setActPayrCntCd("00");
				    	                dmtInvMnVO.setActPayrSeq(confirmChargeVO.getCustCd());
				    	                
				    	                //Cust
				    	                dmtInvMnVO.setCustCntCd("00");
				    	                dmtInvMnVO.setCustSeq(confirmChargeVO.getCustCd());

				    	            } 
				    	            // Customer
				    	            else {
				    	            	//ActPayr
					    	           	dmtInvMnVO.setActPayrCntCd(confirmChargeVO.getCustCd().substring(0, 2));
					    	            dmtInvMnVO.setActPayrSeq(confirmChargeVO.getCustCd().substring(2));
					    	            
					    	            //Cust
				    	                dmtInvMnVO.setCustCntCd(confirmChargeVO.getCustCd().substring(0, 2));
				    	                dmtInvMnVO.setCustSeq(confirmChargeVO.getCustCd().substring(2));
				    	            }

				    	            if (confirmChargeVO.getVslCd().equals("HJXX") 
				    	            		|| confirmChargeVO.getVslCd().equals("HJYY")
				    	            		|| confirmChargeVO.getVslCd().equals("HJZZ")) {
				    	                dmtInvMnVO.setVslCd("CFDR");
				    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
				    	                dmtInvMnVO.setSkdDirCd("E");
				    	            } 
				    	            else {
				    	                dmtInvMnVO.setVslCd(confirmChargeVO.getVslCd());
				    	                dmtInvMnVO.setSkdVoyNo(confirmChargeVO.getSkdVoyNo());
				    	                dmtInvMnVO.setSkdDirCd(confirmChargeVO.getSkdDirCd());
				    	            }
				    	            
				    	            dmtInvMnVO.setDmdtPayrCntcPntNm("");
				    	            dmtInvMnVO.setPorCd(confirmChargeVO.getPorCd());
				    	            dmtInvMnVO.setPolCd(confirmChargeVO.getPolCd());
				    	            dmtInvMnVO.setPodCd(confirmChargeVO.getPodCd());
				    	            dmtInvMnVO.setDelCd(confirmChargeVO.getDelCd());
				    	            dmtInvMnVO.setScNo(confirmChargeVO.getScNo());
				    	            dmtInvMnVO.setRfaNo(confirmChargeVO.getRfaNo());
				    	            dmtInvMnVO.setTaaNo(confirmChargeVO.getTaaNo());
				    	            dmtInvMnVO.setChgCurrCd(confirmChargeVO.getBzcTrfCurrCd());

				    	            dmtInvMnVO.setOrgChgAmt(JSPUtil.toDecimalFormat(grpOrgChgAmt, "#.##"));
				    	            dmtInvMnVO.setDmdtExptAmt(JSPUtil.toDecimalFormat(grpScRfaExptAmt, "#.##"));
				    	            dmtInvMnVO.setDcAmt(JSPUtil.toDecimalFormat(grpAftExptDcAmt, "#.##"));
				    	            dmtInvMnVO.setBilAmt(JSPUtil.toDecimalFormat(grpBilAmt, "#.##"));

				    	            dmtInvMnVO.setInvCurrCd(confirmChargeVO.getArCurrCd());
				    	            dmtInvMnVO.setInvXchRt(confirmChargeVO.getInvXchRt());
				    	            
				    	            dmtInvMnVO.setInvChgAmt(JSPUtil.toDecimalFormat(grpInvAmt, "#.##"));
				    	            String taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : invoiceGroupParamVO.getTaxRto();
				    	            dmtInvMnVO.setTaxRto(taxRto);
				    	            dmtInvMnVO.setTaxAmt(invoiceGroupParamVO.getTaxAmt());
				    	            dmtInvMnVO.setInvAmt(invoiceGroupParamVO.getInvAmt());
				    	            dmtInvMnVO.setAftExptAproNo("");
				    	            dmtInvMnVO.setAftInvAdjAmt("");
				    	            dmtInvMnVO.setCrInvNo("");
				    	            dmtInvMnVO.setInvRmk("");
				    	            dmtInvMnVO.setDmdtArIfCd("N");
				    	            dmtInvMnVO.setArIfNo("");
				    	            dmtInvMnVO.setArIfDt("");
				    	            dmtInvMnVO.setArIfUsrId("");
				    	            dmtInvMnVO.setArIfOfcCd("");
				    	            dmtInvMnVO.setDmdtInvStsCd("I");
				    	            dmtInvMnVO.setDmdtCxlRsnCd("");
				    	            dmtInvMnVO.setCxlRmk("");
				    	            dmtInvMnVO.setInvHldRsnCd("");
				    	            dmtInvMnVO.setInvHldRmk("");
				    	            dmtInvMnVO.setInvPrtFlg("");
				    	            dmtInvMnVO.setInvRefNo("");
				    	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setNtcKntCd("");

				    	            // 인도세법 변경 후, 적용될 새로운 Tax Ratio & Tax Amount
				    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {
				    	            	dmtInvMnVO.setIdaCgstRto(invoiceGroupParamVO.getIdaCgstRto());
				    	            	dmtInvMnVO.setIdaCgstAmt(invoiceGroupParamVO.getIdaCgstAmt());
				    	            	dmtInvMnVO.setIdaSgstRto(invoiceGroupParamVO.getIdaSgstRto());
				    	            	dmtInvMnVO.setIdaSgstAmt(invoiceGroupParamVO.getIdaSgstAmt());		
				    	            	dmtInvMnVO.setIdaIgstRto(invoiceGroupParamVO.getIdaIgstRto());
				    	            	dmtInvMnVO.setIdaIgstAmt(invoiceGroupParamVO.getIdaIgstAmt());
				    	            	dmtInvMnVO.setIdaUgstRto(invoiceGroupParamVO.getIdaUgstRto());
				    	            	dmtInvMnVO.setIdaUgstAmt(invoiceGroupParamVO.getIdaUgstAmt());
				    	            }

				    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeVO.getBkgNo());
				    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
				    	            	dmtInvMnVO.setRcvTermCd("");
				    	            	dmtInvMnVO.setDeTermCd("");
				    	            } 
				    	            else {
				    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
				    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
				    	            }

				    	            dmtInvMnVO.setInvNewRptFlg(InvNewRptFlg);
				    	            
				    	            dbDao.addInvoiceMain(dmtInvMnVO);		

				    	            inv_sts_cd	= dmtInvMnVO.getDmdtInvStsCd();
				    	            ar_if_cd	= dmtInvMnVO.getDmdtArIfCd();
			    				} 
			    				/*====================================================================
			    				        [ Invoice nbr 선택에 따른 처리 로직 ]
			    				 =====================================================================
								   		1. Combined Invoice nbr for selected BKGs   종료
								   		2. Individual Invoice nbr for selected BKGs 실행
			    				 =====================================================================*/
			    				else {
			    		            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
			    		            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
			    		            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
			    		            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
			    		            invoiceNoGenCondVO.setDmdtTrfCd(grpDmdtTrfCd);
			    		            // [ Invoice No. 채번 로직 실행 ]==========================================================
			    		            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
			    		            // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
			    		            if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
				    					reInvoiceGroupParamVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
				    					reInvoiceGroupParamVO.setErrMsg(invoiceNoGenVO.getErrMsg());			    		            	
				    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
				    					return reInvoiceGroupMgtVO;
			    		            }
			    		            invoice_no = invoiceNoGenVO.getDmdtInvNo();
			    		            //=========================================================================================			    					
			    					
				    	            // addInvoiceMain
				    	            DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
				    	            dmtInvMnVO.setDmdtInvNo(invoice_no);
				    	            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
				    	            dmtInvMnVO.setIoBndCd(confirmChargeListVOs[i].getDmdtTrfCd().substring(2, 3));//dmif
				    	            dmtInvMnVO.setDmdtChgTpCd(invoiceGroupParamVO.getSChargeType());
				    	            dmtInvMnVO.setMnlInpFlg("N");
				    	            dmtInvMnVO.setMnlInvSndFlg("N");
				    	            dmtInvMnVO.setMnlInvRmk("");
				    	            dmtInvMnVO.setDmdtMnlInvRsnCd("");
				    	            dmtInvMnVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
				    	            dmtInvMnVO.setBlNo(confirmChargeListVOs[i].getBlNo());
				    	            dmtInvMnVO.setVslCd(confirmChargeListVOs[i].getVslCd());
				    	            dmtInvMnVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
				    	            dmtInvMnVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
				    	            dmtInvMnVO.setDmdtPayrTpCd("");
				    	            
				    	            // Vendor
			    	            	if (confirmChargeListVOs[i].getCustCd().length() <= 6) {
			    	    	            //ActPayr
			    	            	    dmtInvMnVO.setActPayrCntCd("00");
			    	            	    dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd());
			    	            	    //cust
			    	            	    dmtInvMnVO.setCustCntCd("00");
			    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd());
			    	            	} 
			    	            	// Customer
			    	            	else {
				    	            	dmtInvMnVO.setActPayrCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
				    	                dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd().substring(2));
			    	            	    //cust
			    	            	    dmtInvMnVO.setCustCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
			    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd().substring(2));
			    	            	}
				    	            	
				    	            if (confirmChargeListVOs[i].getVslCd().equals("HJXX") 
				    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJYY")
				    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJZZ")) {
				    	                dmtInvMnVO.setVslCd("CFDR");
				    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
				    	                dmtInvMnVO.setSkdDirCd("E");
				    	            } 
				    	            else {
				    	                dmtInvMnVO.setVslCd(confirmChargeListVOs[i].getVslCd());
				    	                dmtInvMnVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
				    	                dmtInvMnVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
				    	            }    	            	
				    	            
				    	            dmtInvMnVO.setDmdtPayrCntcPntNm("");
				    	            dmtInvMnVO.setPorCd(confirmChargeListVOs[i].getPorCd());
				    	            dmtInvMnVO.setPolCd(confirmChargeListVOs[i].getPolCd());
				    	            dmtInvMnVO.setPodCd(confirmChargeListVOs[i].getPodCd());
				    	            dmtInvMnVO.setDelCd(confirmChargeListVOs[i].getDelCd());
				    	            dmtInvMnVO.setScNo(confirmChargeListVOs[i].getScNo());
				    	            dmtInvMnVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
				    	            dmtInvMnVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
				    	            dmtInvMnVO.setChgCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
				    	            dmtInvMnVO.setInvCurrCd(confirmChargeListVOs[i].getArCurrCd());
				    	            dmtInvMnVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
				    	            dmtInvMnVO.setInvChgAmt(confirmChargeListVOs[i].getInvAmt());
				    	            String taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : confirmChargeListVOs[i].getInvTaxRto();
				    	            dmtInvMnVO.setTaxRto(taxRto);	
				    	            dmtInvMnVO.setTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
				    	            dmtInvMnVO.setInvAmt(confirmChargeListVOs[i].getInvPayableAmt());
				    	            dmtInvMnVO.setAftExptAproNo("");
				    	            dmtInvMnVO.setAftInvAdjAmt("");
				    	            dmtInvMnVO.setCrInvNo("");
				    	            dmtInvMnVO.setInvRmk("");
				    	            dmtInvMnVO.setDmdtArIfCd("N");
				    	            dmtInvMnVO.setArIfNo("");
				    	            dmtInvMnVO.setArIfDt("");
				    	            dmtInvMnVO.setArIfUsrId("");
				    	            dmtInvMnVO.setArIfOfcCd("");
				    	            dmtInvMnVO.setDmdtInvStsCd("I");
				    	            dmtInvMnVO.setDmdtCxlRsnCd("");
				    	            dmtInvMnVO.setCxlRmk("");
				    	            dmtInvMnVO.setInvHldRsnCd("");
				    	            dmtInvMnVO.setInvHldRmk("");
				    	            dmtInvMnVO.setInvPrtFlg("");
				    	            dmtInvMnVO.setInvRefNo("");
				    	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setNtcKntCd("");
				    	            
				    	            // 인도세법 변경 전( Ratio 는 모두 동일하지만 Amount 는 Row ( BKG ) 당, 다르므로 아래와 같이 달리 처리한다. )
				    	            // 인도세법 변경 후, 적용될 새로운 Tax Ratio & Tax Amount
				    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {				    	            
				    	            	idaCgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaCgstAmt());
				    	            	idaSgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaSgstAmt());
				    	            	idaIgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaIgstAmt());
				    	            	idaUgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaUgstAmt());
				    	        		
				    	            	dmtInvMnVO.setIdaCgstRto(invoiceGroupParamVO.getIdaCgstRto());
				    	            	dmtInvMnVO.setIdaCgstAmt(confirmChargeListVOs[i].getIdaCgstAmt());
				    	            	dmtInvMnVO.setIdaSgstRto(invoiceGroupParamVO.getIdaSgstRto());
				    	            	dmtInvMnVO.setIdaSgstAmt(confirmChargeListVOs[i].getIdaSgstAmt());		
				    	            	dmtInvMnVO.setIdaIgstRto(invoiceGroupParamVO.getIdaIgstRto());
				    	            	dmtInvMnVO.setIdaIgstAmt(confirmChargeListVOs[i].getIdaIgstAmt());
				    	            	dmtInvMnVO.setIdaUgstRto(invoiceGroupParamVO.getIdaUgstRto());
				    	            	dmtInvMnVO.setIdaUgstAmt(confirmChargeListVOs[i].getIdaUgstAmt());
				    	            }
				    	            
				    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeListVOs[i].getBkgNo());
				    	            
				    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
				    	            	dmtInvMnVO.setRcvTermCd("");
				    	            	dmtInvMnVO.setDeTermCd("");
				    	            }
				    	            else {
				    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
				    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
				    	            }
	
				    	            dmtInvMnVO.setInvNewRptFlg(InvNewRptFlg);
				    	            dbDao.addInvoiceMain(dmtInvMnVO);	//疫뀀뜆釉몌옙占쏙옙�뽰뇚占쏙옙invoice 占쎈베�ョ몴占쏙옙占쎌삢占쎌뮆��
				    	            
				    	            inv_sts_cd	= dmtInvMnVO.getDmdtInvStsCd();
				    	            ar_if_cd	= dmtInvMnVO.getDmdtArIfCd();
			    				} 
			    				/*====================================================================
			    				        [ Invoice nbr 선택에 따른 처리 로직 ]
				 				 =====================================================================
			    				        2. Individual Invoice nbr for selected BKGs 종료
				 				 =====================================================================*/
			    				
			    	            inv_qty++;
			    	           
			    	            
			    	            //#####< 반복CASE - START >#####################################################################################################################################			    	            
			    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
			    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());	//charge office code
			    	            issuedInvoiceParamVO.setSFmDt(invoiceGroupParamVO.getSFmDt());
			    	            issuedInvoiceParamVO.setSToDt(invoiceGroupParamVO.getSToDt());
			    	            
			    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
			    	            
			    	            if (invoiceIssueList != null) {
				    	            for (int j=0; j<invoiceIssueList.size(); j++) {
				    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
			    	            	
				    	            	if (invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
						    	            reConfirmChargeListVO = new ConfirmChargeListVO();
						    	            
						    	            reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
						    	            reConfirmChargeListVO.setDmdtInvNo(invoice_no);
						    				reConfirmChargeListVO.setDmdtInvStsCd(inv_sts_cd);
						    				reConfirmChargeListVO.setDmdtArIfCd(ar_if_cd);
						    				
						    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
						    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
						    				reConfirmChargeListVO.setCntrCnt(confirmChargeListVOs[i].getCntrCnt());
						    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
						    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
						    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
						    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
						    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
						    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
						    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
						    				reConfirmChargeListVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
						    				
						    				reConfirmChargeListVO.setArCurrCd(confirmChargeListVOs[i].getArCurrCd());	//Invoice
						    				reConfirmChargeListVO.setInvAmt(confirmChargeListVOs[i].getInvAmt());
						    				reConfirmChargeListVO.setInvTaxRto(confirmChargeListVOs[i].getInvTaxRto());
						    				reConfirmChargeListVO.setInvTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
						    				reConfirmChargeListVO.setInvPayableAmt(confirmChargeListVOs[i].getInvPayableAmt());
						    				
						    				reConfirmChargeListVO.setBzcTrfCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
						    				reConfirmChargeListVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
						    				reConfirmChargeListVO.setScRfaExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
						    				reConfirmChargeListVO.setAftExptDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
						    				reConfirmChargeListVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
						    				
						    				reConfirmChargeListVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());	//Ex.Rate
						    				
						    				reConfirmChargeListVO.setVslCd(confirmChargeListVOs[i].getVslCd());
						    				reConfirmChargeListVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
						    				reConfirmChargeListVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
						    				reConfirmChargeListVO.setPodCd(confirmChargeListVOs[i].getPodCd());
						    				reConfirmChargeListVO.setPolCd(confirmChargeListVOs[i].getPolCd());
						    				reConfirmChargeListVO.setPorCd(confirmChargeListVOs[i].getPorCd());
						    				reConfirmChargeListVO.setDelCd(confirmChargeListVOs[i].getDelCd());
						    				
						    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
				    	            		
				    	            		break;
				    	            	}
				    	            }
			    	            }
		    				
	    						tot_org_chg_amt 		= 0;	//Charge Incurrend AMT
	    			            tot_sc_rfa_expt_amt 	= 0;	//Charge Exception AMT
	    			            tot_aft_expt_dc_amt 	= 0;	//Charge D/C AMT
	    			            tot_bil_amt 			= 0;	//Charge Billable AMT
	    			            tot_inv_amt 			= 0;	//Invoice Billing AMT
	    			            tot_inv_tax_rto 		= 0;	//Invoice Tax(%)
	    			            tot_inv_tax_amt 		= 0;	//Invoice Tax AMT
	    			            tot_inv_payable_amt 	= 0;	//Invoice Payable AMT
	    			            cntr_cnt = 0;
			    				
			    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
			    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
			    	            
			    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
		    	            
			    	            if (invoiceIssueList == null || invoiceIssueList.size() == 0) {
			    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
			    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
		    	            		message = JSPUtil.replace(message, "[Value]", "Save");
			    					reInvoiceGroupParamVO.setErrMsg(message);
			    					
			    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
			    					return reInvoiceGroupMgtVO;
			    	            }
		    	            		    	        	
			    	            for (int j=0; j<invoiceIssueList.size(); j++) {
			    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
			    	            	
			    	            	if (invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
			    	            		DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
	
			    	            		dmtInvDtlVO.setSvrId(invoiceIssueDetail.getSvrId());
			    	            		dmtInvDtlVO.setCntrNo(invoiceIssueDetail.getCntrNo());
			    	            		dmtInvDtlVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
			    	            		dmtInvDtlVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
			    	            		dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
			    	            		dmtInvDtlVO.setChgSeq(invoiceIssueDetail.getChgSeq());
				    	                
			    	            		ChargeCalculationContainerVO chargeCalculationContainerVO = new ChargeCalculationContainerVO();
				    	                chargeCalculationContainerVO = dbDao.searchChargeStatusCd(dmtInvDtlVO);
			    	                    String chg_sts_cd = chargeCalculationContainerVO.getDmdtChgStsCd();
			    	                    			    	                
			    	                    if ("I".equals(chg_sts_cd)) {
			    	                    	reInvoiceGroupParamVO.setErrCode("DMT01068");
					    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
				    	            		message = JSPUtil.replace(message, "[Value]", "Save");
					    					reInvoiceGroupParamVO.setErrMsg(message);
					    					
					    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
					    					return reInvoiceGroupMgtVO;
			    	                    }

			    	            		//Charge AMT
				    	            	tot_org_chg_amt 	+= Double.parseDouble(invoiceIssueDetail.getOrgChgAmt());
				    	            	tot_sc_rfa_expt_amt += Double.parseDouble(invoiceIssueDetail.getExptAmt());
				    	            	tot_aft_expt_dc_amt	+= Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
				    	            	tot_bil_amt			+= Double.parseDouble(invoiceIssueDetail.getBilAmt());

				    	                //INV_CHG_AMT
				    	                double temp_inv_chg_amt = 0;
				    	                temp_inv_chg_amt 	= Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
				    	                // Billing AMT
				    	                temp_inv_chg_amt 	= dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), temp_inv_chg_amt);
				    	                tot_inv_amt			+= temp_inv_chg_amt;
				    	                //===========================================================================================================================================
				    	                // Tax Rate/ AMT, Payable AMT 계산
				    	                //===========================================================================================================================================				    	                
				    	                InvoiceAmtVO invoiceAmtVO = this.calculateInvoiceAmt(invoiceGroupParamVO, temp_inv_chg_amt);
				    	                //===========================================================================================================================================
				    	                tot_inv_tax_rto     = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? 0 : Double.parseDouble(invoiceGroupParamVO.getTaxRto());
				    	                tot_inv_tax_amt     += Double.parseDouble(invoiceAmtVO.getTaxAmt());
				    	                tot_inv_payable_amt += Double.parseDouble(invoiceAmtVO.getInvAmt());
				    	                //===========================================================================================================================================
				    	                //Cntr count
				    	                cntr_cnt++;
				    	                
				    	                break;
			    	            	}
			    	            }
			    	            //#####< 반복CASE -END >#####################################################################################################################################
			    	            
			    				issuedInvoiceParamVO = new IssuedInvoiceParamVO();
			    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
			    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
			    	            
			    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);

			    	            if (invoiceIssueList != null && invoiceIssueList.size() > 0) {
			    	            	
				    	            for (InvoiceIssueVO invoiceIssueVO : invoiceIssueList) {
				    	            	
				    	            	if (!invoiceIssueVO.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) continue;
				    	            	
				    	            	int invDtlSeq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
				    	            	
				    	            	// [ Container Invoice Amount ]
				    	                double cntrInvAmt = 0;
				    	                cntrInvAmt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueVO.getBilAmt());
				    	                cntrInvAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), cntrInvAmt);
	
				    	                // [ Tax Amount ]
				    	                InvoiceAmtVO invoiceAmtVO = this.calculateInvoiceAmt(invoiceGroupParamVO, cntrInvAmt);
				    	                double taxAmt = Double.parseDouble(invoiceAmtVO.getTaxAmt());
				    	                taxAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), taxAmt);
	
				    	                // [ 생성 Invoice Detail ]
				    	                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
				    	                dmtInvDtlVO.setDmdtInvNo(invoice_no);
				    	                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
				    	                dmtInvDtlVO.setInvDtlSeq(String.valueOf(invDtlSeq));
				    	                dmtInvDtlVO.setSvrId(invoiceIssueVO.getSvrId());
				    	                dmtInvDtlVO.setCntrNo(invoiceIssueVO.getCntrNo());
				    	                dmtInvDtlVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
				    	                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
				    	                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
				    	                dmtInvDtlVO.setChgSeq(invoiceIssueVO.getChgSeq());
				    	                dmtInvDtlVO.setCntrTpszCd(invoiceIssueVO.getCntrTpszCd());
				    	                dmtInvDtlVO.setFmMvmtDt(invoiceIssueVO.getFmMvmtDt());
				    	                dmtInvDtlVO.setToMvmtDt(invoiceIssueVO.getToMvmtDt());
				    	                dmtInvDtlVO.setFtDys(invoiceIssueVO.getFtDys());
				    	                dmtInvDtlVO.setFtCmncDt(invoiceIssueVO.getFtCmncDt());
				    	                dmtInvDtlVO.setFtEndDt(invoiceIssueVO.getFtEndDt());
				    	                dmtInvDtlVO.setFxFtOvrDys(invoiceIssueVO.getFxFtOvrDys());
				    	                dmtInvDtlVO.setOrgChgAmt(invoiceIssueVO.getOrgChgAmt());
				    	                dmtInvDtlVO.setScRfaExptAmt(invoiceIssueVO.getExptAmt());
				    	                dmtInvDtlVO.setAftExptDcAmt(invoiceIssueVO.getAftExptDcAmt());
				    	                dmtInvDtlVO.setBilAmt(invoiceIssueVO.getBilAmt());
				    	                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntrInvAmt, "#.##"));
				    	                dmtInvDtlVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
				    	                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));
				    	                dmtInvDtlVO.setInvPrtFlg("");
				    	                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
				    	                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
				    	                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
				    	                
				    	                dbDao.addInvoiceDetail(dmtInvDtlVO);
				    	                
				    	                // [ 생성 Invoice Rate ]
				    	                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
				    	                overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
				    	                overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
				    	                overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
				    	                overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
				    	                overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
				    	                overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
				    	                
				    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
				    	                
				    					CalculationParmVO calculationParmVO = new CalculationParmVO();
				    					String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
				    					calculationParmVO.setDcApplRate(trfAplyTpCd);

			    						// basicCalculation - Baisc Tariff
			    						String firstSvrID = null;
			    						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
			    						chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    						chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
			    						chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
			    						chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
			    						chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
			    						chargeCalculationParmVO.setBkgNo(invoiceIssueVO.getBkgNo());
			    						chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
		
			    						log.debug(" iss issueInvoiceByGroup  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
		
			    						//office transfer 占쏙옙野껋럩��癰귨옙瑗랃옙占퐏vr_id�쒙옙鈺곌퀬�띰옙�뤿연 占쎈뿮�울옙�뺣뼄.
			    						if ("Y".equals(invoiceIssueVO.getOfcTrnsFlg())) {
			    							firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			    						} 
			    						else {
			    							firstSvrID = invoiceIssueVO.getSvrId();
			    						}
		
			    						calculationParmVO.setSvrId(firstSvrID);		
			    						calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    						calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
			    						calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
			    						calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
			    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
			    						calculationParmVO.setOverDay(invoiceIssueVO.getOrgFtOvrDys());		//org_ft_ovr_dys
			    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
			    						calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
			    						calculationParmVO.setFtDys(invoiceIssueVO.getFtDys());
			    						calculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
			    						calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());	// 2014.03.12
			    						calculationParmVO.setDmdtTrfAplyTpCd("G");								// 2014.03.12
			    						
			    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
			    						
		
			    						calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);										// 2014.03.12
			    						
			    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
		
			    						/*
			    						Charge에 적용된 Tariff에 따라 Charge금액을 계산한다.
			    					    A) "G"(Basic Tariff)인 경우 Basic Tariff의 Rate별 계산금액을 조회한다
			    					    B) "B"(Before Exception)인 경우 Before Exception Tariff의 Rate별 계산금액을 조회하고 Before Exception의 Currency를 조회한다
			    					    C) "S"(S/C Exception)인 경우 S/C Exception Tariff의 Rate별 계산금액을 조회하고 S/C Exception의 Currency를 조회한다
			    					    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
			    					         1) 적용된 CurrencyExchange Rate를 조회하여 Charge 계산금액을 Exchange Rate를 곱한다
			    					         2) 1)에서 계산한 금액을 Currency별로 반올림처리 한다
			    						*/
			    						if ("G".equals(trfAplyTpCd)) {
		//	    							String firstSvrID = null;
			    							
			    							//office transfer check
			    			            	if ("Y".equals(invoiceIssueVO.getOfcTrnsFlg())) {
			    			            		
		//	    			            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
			    			            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    			            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
			    			            		chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
			    			            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
			    			            		chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
			    			            		chargeCalculationParmVO.setBkgNo(invoiceIssueVO.getBkgNo());
			    			            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
			    			            		
			    			    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
			    			            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			    			            	} 
			    			            	else {
			    			            		firstSvrID = invoiceIssueVO.getSvrId();
			    			            	}
			    							
			    							// basicCalculation - Baisc Tariff
			    							calculationParmVO.setSvrId(firstSvrID);
			    							calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    							calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
			    							calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
			    							calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
			    							calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
			    							calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
			    							calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
			    							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());			// 2014.03.12
			    							if (!"".equals(invoiceIssueVO.getScRfaExptAplyDt())) {		// 2014.03.12
			    								calculationParmVO.setDmdtTrfAplyTpCd("B");									
			    								calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
			    							} else {
			    								calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
			    							}
			    						} 
			    						else if ("B".equals(trfAplyTpCd)) {
			    							// beforeCalculation - Before BKG Exception
			    							calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
			    							calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
			    							calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
			    							calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
			    							calculationParmVO.setCmbSeq("1");
			    							calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
			    							calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
			    							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());// 2014.03.12
			    						} 
			    						else if ("S".equals(trfAplyTpCd)) {
			    							// scCalculation - SC Exception
			    							calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
			    							calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
			    							calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
			    							calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
			    							calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());					
			    							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());// 2014.03.12
			    						}
			    						                   					    
								    	//bbsChargeCalulation Input
								    	log.debug("\n basicCalculation.......................");				
								    	log.debug("\n svr_id 		      	= "+invoiceIssueVO.getSvrId());				
								    	log.debug("\n dmdt_trf_cd 		  	= "+invoiceIssueVO.getDmdtTrfCd());				
								    	log.debug("\n bzc_trf_seq 		  	= "+invoiceIssueVO.getBzcTrfSeq());
								    	log.debug("\n bzc_dmdt_de_term_cd 	= "+invoiceIssueVO.getBzcDmdtDeTermCd());
								    	log.debug("\n bzc_trf_grp_seq     	= "+invoiceIssueVO.getBzcTrfGrpSeq());				
								    	log.debug("\n cntr_tpsz_cd 	      	= "+invoiceIssueVO.getCntrTpszCd());				
								    	log.debug("\n org_ft_ovr_dys      	= "+invoiceIssueVO.getOrgFtOvrDys());				
								    	log.debug("\n div_over_day 	      	= "+overdayNDivVO.getDivOverDay());				
								    	log.debug("\n bzc_trf_curr_cd     	= "+invoiceIssueVO.getBzcTrfCurrCd());				
								    	log.debug("\n getFtDys 				= "+invoiceIssueVO.getFtDys());			// 2014.03.12
										log.debug("\n getFmMvmtYdCd 		= "+invoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
										log.debug("\n getBzcTrfAplyDt		= "+invoiceIssueVO.getBzcTrfAplyDt());	// 2014.03.12
										log.debug("\n setDmdtTrfAplyTpCd	= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
  
			    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
				    	                
				    	                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
				    	                if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
				    	                	
				    	                	//addInvoiceRate
				    	                	for ( int k = 0; k < chrgDtlVOS.size() ; k++) {
				    		                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(k);
				    		                    
				    		                    if (Double.parseDouble(chrgDtlVO.getRtDay()) == 0) continue;
				    		                    
				    		                    DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
				    		                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
				    		                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
				    		                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
				    		                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
				    		                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
				    		                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueVO.getBzcTrfSeq());
				    		                    dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
				    		                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
				    		                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
				    		                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
				    		                    
				    		                    double inv_rt_amt = 0;
				    		                    double rt_ovr_chg_amt = 0;
			    		                    	inv_rt_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtRate());
			    		                    	inv_rt_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), inv_rt_amt);
			    		                    	rt_ovr_chg_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtChrg());
			    		                    	rt_ovr_chg_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), rt_ovr_chg_amt);
				    		                    
				    		                    dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(inv_rt_amt, "#.##"));
				    		                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
				    		                    dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));
				    		                    dmtInvRtVO.setBzcCurrCd(invoiceIssueVO.getBzcTrfCurrCd());
				    		                    //dmtInvRtVO.setBzcCurrCd(chrgDtlVO.getRtCurCd());
				    		                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
				    		                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
				    		                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
				    		                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
				    		                    
				    		                    dbDao.addInvoiceRate(dmtInvRtVO);
				    	                	}
				    	                }
				    	                
				    	                //======================================================
				    	                //Discount Amount + Exception Amount > 0
				    	                double dScRfaExptAmt = Double.parseDouble(invoiceIssueVO.getExptAmt());
				    	                double dAftExptDcAmt = Double.parseDouble(invoiceIssueVO.getAftExptDcAmt());
				    	                double dCmdtExptAmt  = Double.parseDouble(invoiceIssueVO.getCmdtExptAmt());
				    	                
				    	                if(( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt != 0) && "G".equals(trfAplyTpCd)) {
				    	                	double rt_ovr_chg_amt = 0;
				    	                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
				    	                
				    		                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
				    		                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
				    		                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
				    		                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
				    		                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
				    		                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
				    		                dmtInvRtVO.setBzcTrfSeq(invoiceIssueVO.getBzcTrfSeq());
				    		                dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
				    		                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
				    		                dmtInvRtVO.setBzcTrfRtSeq("");
				    		                dmtInvRtVO.setFtOvrDys("0");
				    		                dmtInvRtVO.setFtUndDys("0");
				    		                dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) 疫뀀뜆釉�
				    		                dmtInvRtVO.setRtOvrDys("1");
				    		                dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) 疫뀀뜆釉�
				    		                dmtInvRtVO.setBzcCurrCd(invoiceIssueVO.getBzcTrfCurrCd());				//Basic Currency
				    		                dmtInvRtVO.setCreUsrId(account.getUsr_id());
				    		                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
				    		                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
				    		                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
				    		                
				    		                dbDao.addInvoiceRate(dmtInvRtVO);
				    	                }
				    	            }
			    	            }
			    	            log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 일 경우 ) >> 처리 종료!!");
	    					}
	    					//================================================
		    				//<< 첫번째 항목일 경우에만 실행되는 로직 종료 >>
	    					//================================================
	    					//================================================
	    					//<< 두번째 항목부터 실행되는 로직 실행 >>
	    					//================================================
	    					else {
	    						log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 초과일 경우 ) >> 처리 시작!!");
	    						
			    				/*====================================================================
			               	   				[ Invoice nbr 선택에 따른 처리 로직 ]
				 				 =====================================================================
									   		2. Individual Invoice nbr for selected BKGs   실행
				 				 =====================================================================*/	
								if (!sBkgNo.equals(confirmChargeListVOs[i].getBkgNo()) && !"GRP".equals(invoiceGroupParamVO.getSGroupInv())) {
									
									log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 초과일 경우 ) >> BKG No. 가 이전 건과 다르고, INV No. 를 각각 생성하는 경우 >> 처리 시작!!");	
									//UPDATE INV_MN
									DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
									dmtInvMnVO.setDmdtInvNo(invoice_no);
									dmtInvMnVO.setCreCntCd(invoiceGroupParamVO.getUsrCntCd());
				    	            dmtInvMnVO.setOrgChgAmt(JSPUtil.toDecimalFormat(tot_org_chg_amt, "#.##"));
				    	            dmtInvMnVO.setDmdtExptAmt(JSPUtil.toDecimalFormat(tot_sc_rfa_expt_amt, "#.##"));
				    	            dmtInvMnVO.setDcAmt(JSPUtil.toDecimalFormat(tot_aft_expt_dc_amt, "#.##"));
				    	            dmtInvMnVO.setBilAmt(JSPUtil.toDecimalFormat(tot_bil_amt, "#.##"));
				    	            dmtInvMnVO.setBkgCntrQty(String.valueOf(cntr_cnt));
	
				    	            dmtInvMnVO.setInvChgAmt(JSPUtil.toDecimalFormat(tot_inv_amt, "#.##"));
				    	            dmtInvMnVO.setTaxAmt(JSPUtil.toDecimalFormat(tot_inv_tax_amt, "#.##"));
				    	            dmtInvMnVO.setInvAmt(JSPUtil.toDecimalFormat(tot_inv_payable_amt, "#.##"));								
				    	            String taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : String.valueOf(tot_inv_tax_rto);
				    	            dmtInvMnVO.setTaxRto(taxRto);
				    	            
				    	         	// 인도세법 변경 후, 적용될 새로운 Tax Ratio & Tax Amount
				    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {
					    	            //=====================================================================================================================================
					    	            // Individual Invoice nbr for selected BKGs 으로 생성한 경우, BKG 별로 invoice 를 생성하므로, 
					    	            // 동일한 BKG 에 묶인 모든 Tax Amount 구해서 Update 해줘야 합니다.
					    	            //=====================================================================================================================================					    	            
					    	            dmtInvMnVO.setIdaCgstAmt(JSPUtil.toDecimalFormat(idaCgstAmt, "#.##"));
					    	            dmtInvMnVO.setIdaSgstAmt(JSPUtil.toDecimalFormat(idaSgstAmt, "#.##"));
					    	            dmtInvMnVO.setIdaIgstAmt(JSPUtil.toDecimalFormat(idaIgstAmt, "#.##"));
					    	            dmtInvMnVO.setIdaUgstAmt(JSPUtil.toDecimalFormat(idaUgstAmt, "#.##"));
					    	            //=====================================================================================================================================
				    	            }
				    	            
				    	            dbDao.modifyInvoiceMainByGroupContainer(dmtInvMnVO);
									
				    	            //=====================================================================================================================================
				    	            // Individual Invoice nbr for selected BKGs 으로 생성한 경우, 다시 신규 invoice 생성을 하게 되므로 인도 Tax Amount 를 초기화 합니다.
				    	            //=====================================================================================================================================				    	            
				    	            idaCgstAmt = 0;
				    	            idaSgstAmt = 0;
				    	            idaIgstAmt = 0;
				    	            idaUgstAmt = 0;
				    	            //=====================================================================================================================================
				    	            
				    	            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
				    	            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
				    	            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
				    	            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
				    	            invoiceNoGenCondVO.setDmdtTrfCd(grpDmdtTrfCd);
				    	            // [ Invoice No. 채번 로직 실행 ]==========================================================
				    	            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
				    	            // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
				    	    		if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
				    	    			reInvoiceGroupParamVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
				    	    			reInvoiceGroupParamVO.setErrMsg(invoiceNoGenVO.getErrMsg());			    		            	
				    	    			reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
				    	    			return reInvoiceGroupMgtVO;
				    	    		}
				    	    		invoice_no = invoiceNoGenVO.getDmdtInvNo();
				    	            //=========================================================================================		    						
		    						
				    	            // addInvoiceMain
				    	            dmtInvMnVO = new DmtInvMnVO();
				    	            dmtInvMnVO.setDmdtInvNo(invoice_no);
				    	            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
				    	            dmtInvMnVO.setIoBndCd(confirmChargeListVOs[i].getDmdtTrfCd().substring(2, 3));//dmif
				    	            dmtInvMnVO.setDmdtChgTpCd(invoiceGroupParamVO.getSChargeType());
				    	            dmtInvMnVO.setMnlInpFlg("N");
				    	            dmtInvMnVO.setMnlInvSndFlg("N");
				    	            dmtInvMnVO.setMnlInvRmk("");
				    	            dmtInvMnVO.setDmdtMnlInvRsnCd("");
				    	            dmtInvMnVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
				    	            dmtInvMnVO.setBlNo(confirmChargeListVOs[i].getBlNo());
				    	            dmtInvMnVO.setVslCd(confirmChargeListVOs[i].getVslCd());
				    	            dmtInvMnVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
				    	            dmtInvMnVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
				    	            dmtInvMnVO.setDmdtPayrTpCd("");
				    	            
				    	            // Vendor
			    	            	if (confirmChargeListVOs[i].getCustCd().length() <= 6) {
			    	    	            //ActPayr
			    	            	    dmtInvMnVO.setActPayrCntCd("00");
			    	            	    dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd());
			    	            	    //cust
			    	            	    dmtInvMnVO.setCustCntCd("00");
			    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd());
			    	            	} 
			    	            	// Customer
			    	            	else {
				    	            	dmtInvMnVO.setActPayrCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
				    	                dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd().substring(2));
			    	            	    //cust
			    	            	    dmtInvMnVO.setCustCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
			    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd().substring(2));
			    	            	}
			    	            	
				    	            if (confirmChargeListVOs[i].getVslCd().equals("HJXX") 
				    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJYY")
				    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJZZ")) {
				    	                dmtInvMnVO.setVslCd("CFDR");
				    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
				    	                dmtInvMnVO.setSkdDirCd("E");
				    	            } 
				    	            else {
				    	                dmtInvMnVO.setVslCd(confirmChargeListVOs[i].getVslCd());
				    	                dmtInvMnVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
				    	                dmtInvMnVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
				    	            }    	            	

				    	            dmtInvMnVO.setDmdtPayrCntcPntNm("");
				    	            dmtInvMnVO.setPorCd(confirmChargeListVOs[i].getPorCd());
				    	            dmtInvMnVO.setPolCd(confirmChargeListVOs[i].getPolCd());
				    	            dmtInvMnVO.setPodCd(confirmChargeListVOs[i].getPodCd());
				    	            dmtInvMnVO.setDelCd(confirmChargeListVOs[i].getDelCd());
				    	            dmtInvMnVO.setScNo(confirmChargeListVOs[i].getScNo());
				    	            dmtInvMnVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
				    	            dmtInvMnVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
				    	            dmtInvMnVO.setChgCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
				    	            dmtInvMnVO.setInvCurrCd(confirmChargeListVOs[i].getArCurrCd());
				    	            dmtInvMnVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());	
				    	            dmtInvMnVO.setInvChgAmt(confirmChargeListVOs[i].getInvAmt());
				    	            taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : confirmChargeListVOs[i].getInvTaxRto();
				    	            dmtInvMnVO.setTaxRto(taxRto);	
				    	            dmtInvMnVO.setTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
				    	            dmtInvMnVO.setInvAmt(confirmChargeListVOs[i].getInvPayableAmt());
				    	            dmtInvMnVO.setAftExptAproNo("");
				    	            dmtInvMnVO.setAftInvAdjAmt("");
				    	            dmtInvMnVO.setCrInvNo("");
				    	            dmtInvMnVO.setInvRmk("");
				    	            dmtInvMnVO.setDmdtArIfCd("N");
				    	            dmtInvMnVO.setArIfNo("");
				    	            dmtInvMnVO.setArIfDt("");
				    	            dmtInvMnVO.setArIfUsrId("");
				    	            dmtInvMnVO.setArIfOfcCd("");
				    	            dmtInvMnVO.setDmdtInvStsCd("I");
				    	            dmtInvMnVO.setDmdtCxlRsnCd("");
				    	            dmtInvMnVO.setCxlRmk("");
				    	            dmtInvMnVO.setInvHldRsnCd("");
				    	            dmtInvMnVO.setInvHldRmk("");
				    	            dmtInvMnVO.setInvPrtFlg("");
				    	            dmtInvMnVO.setInvRefNo("");
				    	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				    	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				    	            dmtInvMnVO.setNtcKntCd("");
				    	             
				    	            // 인도세법 변경 전( Ratio 는 모두 동일하지만 Amount 는 Row ( BKG ) 당, 다르므로 아래와 같이 달리 처리한다. )
				    	            // 인도세법 변경 후, 적용될 새로운 Tax Ratio & Tax Amount
				    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {
				    	            	idaCgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaCgstAmt());
				    	            	idaSgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaSgstAmt());
				    	            	idaIgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaIgstAmt());
				    	            	idaUgstAmt += Double.parseDouble(confirmChargeListVOs[i].getIdaUgstAmt());				    	            	
				    	            	
				    	            	dmtInvMnVO.setIdaCgstRto(invoiceGroupParamVO.getIdaCgstRto());
				    	            	dmtInvMnVO.setIdaCgstAmt(confirmChargeListVOs[i].getIdaCgstAmt());
				    	            	dmtInvMnVO.setIdaSgstRto(invoiceGroupParamVO.getIdaSgstRto());
				    	            	dmtInvMnVO.setIdaSgstAmt(confirmChargeListVOs[i].getIdaSgstAmt());		
				    	            	dmtInvMnVO.setIdaIgstRto(invoiceGroupParamVO.getIdaIgstRto());
				    	            	dmtInvMnVO.setIdaIgstAmt(confirmChargeListVOs[i].getIdaIgstAmt());
				    	            	dmtInvMnVO.setIdaUgstRto(invoiceGroupParamVO.getIdaUgstRto());
				    	            	dmtInvMnVO.setIdaUgstAmt(confirmChargeListVOs[i].getIdaUgstAmt());	
				    	            }
			    	            
				    	            //2011.04.25. 占쎄쑬�ヨ�����곕떽占�issueInvoiceByGroup
				    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeListVOs[i].getBkgNo());
				    	            
				    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
				    	            	dmtInvMnVO.setRcvTermCd("");
				    	            	dmtInvMnVO.setDeTermCd("");
				    	            } 
				    	            else {
				    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
				    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
				    	            }
			    	            
				    	            dmtInvMnVO.setInvNewRptFlg(InvNewRptFlg);
				    	            dbDao.addInvoiceMain(dmtInvMnVO);
				    	            inv_qty++;
				    	            
				    	            inv_sts_cd	= dmtInvMnVO.getDmdtInvStsCd();
				    	            ar_if_cd	= dmtInvMnVO.getDmdtArIfCd();	    					
				    	            
		    			            //#####< 반복CASE - START >#####################################################################################################################################
				    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
				    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
				    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
				    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
				    	            
				    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
			    	            
				    	            if (invoiceIssueList != null) {
					    	            for (int j=0; j<invoiceIssueList.size() ; j++) {
					    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
				    	            	
					    	            	if (invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
				    		    	            reConfirmChargeListVO = new ConfirmChargeListVO();
				    		    	            
				    		    	            reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
				    		    	            reConfirmChargeListVO.setDmdtInvNo(invoice_no);
				    		    				reConfirmChargeListVO.setDmdtInvStsCd(inv_sts_cd);
				    		    				reConfirmChargeListVO.setDmdtArIfCd(ar_if_cd);
				    		    				
				    		    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
				    		    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
				    		    				reConfirmChargeListVO.setCntrCnt(confirmChargeListVOs[i].getCntrCnt());
				    		    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
				    		    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
				    		    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
				    		    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
				    		    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
				    		    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
				    		    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
				    		    				reConfirmChargeListVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
				    		    				
				    		    				reConfirmChargeListVO.setArCurrCd(confirmChargeListVOs[i].getArCurrCd());	//Invoice
				    		    				reConfirmChargeListVO.setInvAmt(confirmChargeListVOs[i].getInvAmt());
				    		    				reConfirmChargeListVO.setInvTaxRto(confirmChargeListVOs[i].getInvTaxRto());
				    		    				reConfirmChargeListVO.setInvTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
				    		    				reConfirmChargeListVO.setInvPayableAmt(confirmChargeListVOs[i].getInvPayableAmt());
				    		    				
				    		    				reConfirmChargeListVO.setBzcTrfCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
				    		    				reConfirmChargeListVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
				    		    				reConfirmChargeListVO.setScRfaExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
				    		    				reConfirmChargeListVO.setAftExptDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
				    		    				reConfirmChargeListVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
				    		    				
				    		    				reConfirmChargeListVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());	//Ex.Rate
				    		    				
				    		    				reConfirmChargeListVO.setVslCd(confirmChargeListVOs[i].getVslCd());
				    		    				reConfirmChargeListVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
				    		    				reConfirmChargeListVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
				    		    				reConfirmChargeListVO.setPodCd(confirmChargeListVOs[i].getPodCd());
				    		    				reConfirmChargeListVO.setPolCd(confirmChargeListVOs[i].getPolCd());
				    		    				reConfirmChargeListVO.setPorCd(confirmChargeListVOs[i].getPorCd());
				    		    				reConfirmChargeListVO.setDelCd(confirmChargeListVOs[i].getDelCd());
				    		    				//reConfirmChargeListVO.setChgCustCntCd(confirmChargeListVOs[i].getChgCustCntCd());
				    		    				//reConfirmChargeListVO.setChgCustSeq(confirmChargeListVOs[i].getChgCustSeq());
				    		    				
				    		    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
					    	            	}
					    	            }
				    	            }
    		    				
		    						tot_org_chg_amt 		= 0;	//Charge Incurrend AMT
		    			            tot_sc_rfa_expt_amt 	= 0;	//Charge Exception AMT
		    			            tot_aft_expt_dc_amt 	= 0;	//Charge D/C AMT
		    			            tot_bil_amt 			= 0;	//Charge Billable AMT
		    			            tot_inv_amt 			= 0;	//Invoice Billing AMT
		    			            tot_inv_tax_rto 		= 0;	//Invoice Tax(%)
		    			            tot_inv_tax_amt 		= 0;	//Invoice Tax AMT
		    			            tot_inv_payable_amt 	= 0;	//Invoice Payable AMT
		    			            cntr_cnt = 0;
	
	    		    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	    		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	    		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
	    		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());

	    		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	    		    	            if (invoiceIssueList == null || invoiceIssueList.size() == 0) {
	    		    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
	    		    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
	    	    	            		message = JSPUtil.replace(message, "[Value]", "Save");
	    		    					reInvoiceGroupParamVO.setErrMsg(message);
	    		    					
	    		    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
	    		    					return reInvoiceGroupMgtVO;
	    		    	            }    		    	            

	    		    	            for (int j=0; j<invoiceIssueList.size(); j++) {
	    		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
	    		    	            	if (invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
	    		    	            		//Charge AMT
	    			    	            	tot_org_chg_amt 	+= Double.parseDouble(invoiceIssueDetail.getOrgChgAmt());
	    			    	            	tot_sc_rfa_expt_amt += Double.parseDouble(invoiceIssueDetail.getExptAmt());
	    			    	            	tot_aft_expt_dc_amt	+= Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
	    			    	            	tot_bil_amt			+= Double.parseDouble(invoiceIssueDetail.getBilAmt());
	    			    	            	
	    			    	            	//Invoice AMT
	    			    	                double temp_inv_chg_amt = 0;
	    			    	                temp_inv_chg_amt 	= Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
	    			    	                // Billing AMT
	    			    	                temp_inv_chg_amt 	= dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), temp_inv_chg_amt);
	    			    	                tot_inv_amt			+= temp_inv_chg_amt;

					    	                //===========================================================================================================================================
					    	                // Tax Rate/ AMT, Payable AMT 계산
					    	                //===========================================================================================================================================				    	                
					    	                InvoiceAmtVO invoiceAmtVO = this.calculateInvoiceAmt(invoiceGroupParamVO, temp_inv_chg_amt);
					    	                //===========================================================================================================================================
					    	                tot_inv_tax_rto     = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? 0 : Double.parseDouble(invoiceGroupParamVO.getTaxRto());
					    	                tot_inv_tax_amt     += Double.parseDouble(invoiceAmtVO.getTaxAmt());
					    	                tot_inv_payable_amt += Double.parseDouble(invoiceAmtVO.getInvAmt());
					    	                //===========================================================================================================================================

	    			    	                //Cntr count
	    			    	                cntr_cnt++;
	    			    	                
	    			    	                break;
	    		    	            	}
	    		    	            }
	    		    	            
	    		    	            log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 초과일 경우 ) >> BKG No. 가 이전 건과 다르고, INV No. 를 각각 생성하는 경우 >> 처리 종료!!");
	    		    	            //#####< 반복CASE - END >#####################################################################################################################################
								} 
			    				/*====================================================================
			               	   				[ Invoice nbr 선택에 따른 처리 로직 ]
				 				 =====================================================================
									   		2. Individual Invoice nbr for selected BKGs   종료
				 				 =====================================================================*/								
								else {
									log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 초과일 경우 ) >> BKG No. 가 이전 건과 동일하거나, INV No. 를 GROUP 으로 생성하는 경우 >> 처리 시작!!");
				    	            //#####< 반복CASE - START >#####################################################################################################################################
	    							//// List Setting
				    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
				    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
				    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
				    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
				    	            
				    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
			    	            
				    	            if (invoiceIssueList != null) {
					    	            for (int j=0; j<invoiceIssueList.size() ; j++) {
					    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
				    	            	
					    	            	if (invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
				    		    	            reConfirmChargeListVO = new ConfirmChargeListVO();
				    		    	            
				    		    	            reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
				    		    	            reConfirmChargeListVO.setDmdtInvNo(invoice_no);
				    		    				reConfirmChargeListVO.setDmdtInvStsCd(inv_sts_cd);
				    		    				reConfirmChargeListVO.setDmdtArIfCd(ar_if_cd);
				    		    				
				    		    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
				    		    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
				    		    				reConfirmChargeListVO.setCntrCnt(confirmChargeListVOs[i].getCntrCnt());
				    		    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
				    		    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
				    		    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
				    		    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
				    		    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
				    		    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
				    		    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
				    		    				reConfirmChargeListVO.setTaaNo(confirmChargeListVOs[i].getTaaNo());
				    		    				reConfirmChargeListVO.setArCurrCd(confirmChargeListVOs[i].getArCurrCd());	//Invoice
				    		    				reConfirmChargeListVO.setInvAmt(confirmChargeListVOs[i].getInvAmt());
				    		    				reConfirmChargeListVO.setInvTaxRto(confirmChargeListVOs[i].getInvTaxRto());
				    		    				reConfirmChargeListVO.setInvTaxAmt(confirmChargeListVOs[i].getInvTaxAmt());
				    		    				reConfirmChargeListVO.setInvPayableAmt(confirmChargeListVOs[i].getInvPayableAmt());
				    		    				reConfirmChargeListVO.setBzcTrfCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
				    		    				reConfirmChargeListVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
				    		    				reConfirmChargeListVO.setScRfaExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
				    		    				reConfirmChargeListVO.setAftExptDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
				    		    				reConfirmChargeListVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
				    		    				reConfirmChargeListVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());	//Ex.Rate
				    		    				reConfirmChargeListVO.setVslCd(confirmChargeListVOs[i].getVslCd());
				    		    				reConfirmChargeListVO.setSkdVoyNo(confirmChargeListVOs[i].getSkdVoyNo());
				    		    				reConfirmChargeListVO.setSkdDirCd(confirmChargeListVOs[i].getSkdDirCd());
				    		    				reConfirmChargeListVO.setPodCd(confirmChargeListVOs[i].getPodCd());
				    		    				reConfirmChargeListVO.setPolCd(confirmChargeListVOs[i].getPolCd());
				    		    				reConfirmChargeListVO.setPorCd(confirmChargeListVOs[i].getPorCd());
				    		    				reConfirmChargeListVO.setDelCd(confirmChargeListVOs[i].getDelCd());
				    		    				
				    		    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
					    	            	}
					    	            }
				    	            }    							
    							
	    		    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	    		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	    		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
	    		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	    		    	            
	    		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	    		    	            
	    		    	            for (InvoiceIssueVO invoiceIssueVO : invoiceIssueList) {

	    		    	            	if (invoiceIssueVO.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
	    		    	            		//Charge AMT
	    			    	            	tot_org_chg_amt 	+= Double.parseDouble(invoiceIssueVO.getOrgChgAmt());
	    			    	            	tot_sc_rfa_expt_amt += Double.parseDouble(invoiceIssueVO.getExptAmt());
	    			    	            	tot_aft_expt_dc_amt	+= Double.parseDouble(invoiceIssueVO.getAftExptDcAmt());
	    			    	            	tot_bil_amt			+= Double.parseDouble(invoiceIssueVO.getBilAmt());
	    			    	            	
	    			    	            	// Invoice AMT
	    			    	                double temp_inv_chg_amt = 0;
	    			    	                temp_inv_chg_amt 	= Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueVO.getBilAmt());
	    			    	                // Billing AMT
	    			    	                temp_inv_chg_amt 	= dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), temp_inv_chg_amt);
	    			    	                tot_inv_amt			+= temp_inv_chg_amt;
	    			    	                
					    	                //===========================================================================================================================================
					    	                // Tax Rate/ AMT, Payable AMT 계산
					    	                //===========================================================================================================================================				    	                
					    	                InvoiceAmtVO invoiceAmtVO = this.calculateInvoiceAmt(invoiceGroupParamVO, temp_inv_chg_amt);
					    	                //===========================================================================================================================================
					    	                tot_inv_tax_rto     = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? 0 : Double.parseDouble(invoiceGroupParamVO.getTaxRto());
					    	                tot_inv_tax_amt     += Double.parseDouble(invoiceAmtVO.getTaxAmt());
					    	                tot_inv_payable_amt += Double.parseDouble(invoiceAmtVO.getInvAmt());
					    	                //===========================================================================================================================================
	    			    	                
	    			    	                //Cntr count
	    			    	                cntr_cnt++;
	    			    	                
	    			    	                break;
	    		    	            	}
	    		    	            }
	    		    	          //#####< 반복CASE - END >#####################################################################################################################################
	    		    	            
	    		    	            log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 초과일 경우 ) >> BKG No. 가 이전 건과 동일하거나, INV No. 를 GROUP 으로 생성하는 경우 >> 처리 종료!!");
								}
							
			    				issuedInvoiceParamVO = new IssuedInvoiceParamVO();
			    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
			    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
			    	            
			    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
		    	            
			    	            for (InvoiceIssueVO invoiceIssueVO : invoiceIssueList) {
	
									log.debug("[search_cntr_no]"+invoiceIssueVO.getCntrNo());
									log.debug("[list_cntr_no]"+confirmChargeListVOs[i].getCntrNo());
									
			    	            	if (invoiceIssueVO.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
			    	            	
				    	            	int invDtlSeq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
				    	            	
				    	            	// [ Container Invoice Amount ]
				    	                double cntrInvAmt = 0;
				    	                cntrInvAmt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueVO.getBilAmt());
				    	                cntrInvAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), cntrInvAmt);
	
				    	                // [ Tax Amount ]
				    	                InvoiceAmtVO invoiceAmtVO = this.calculateInvoiceAmt(invoiceGroupParamVO, cntrInvAmt);
				    	                double taxAmt = Double.parseDouble(invoiceAmtVO.getTaxAmt());
				    	                taxAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), taxAmt);
			    	                
				    	                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
				    	                dmtInvDtlVO.setDmdtInvNo(invoice_no);
				    	                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
				    	                dmtInvDtlVO.setInvDtlSeq(String.valueOf(invDtlSeq));
				    	                dmtInvDtlVO.setSvrId(invoiceIssueVO.getSvrId());
				    	                dmtInvDtlVO.setCntrNo(invoiceIssueVO.getCntrNo());
				    	                dmtInvDtlVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
				    	                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
				    	                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
				    	                dmtInvDtlVO.setChgSeq(invoiceIssueVO.getChgSeq());
				    	                dmtInvDtlVO.setCntrTpszCd(invoiceIssueVO.getCntrTpszCd());
				    	                dmtInvDtlVO.setFmMvmtDt(invoiceIssueVO.getFmMvmtDt());
				    	                dmtInvDtlVO.setToMvmtDt(invoiceIssueVO.getToMvmtDt());
				    	                dmtInvDtlVO.setFtDys(invoiceIssueVO.getFtDys());
				    	                dmtInvDtlVO.setFtCmncDt(invoiceIssueVO.getFtCmncDt());
				    	                dmtInvDtlVO.setFtEndDt(invoiceIssueVO.getFtEndDt());
				    	                dmtInvDtlVO.setFxFtOvrDys(invoiceIssueVO.getFxFtOvrDys());
				    	                dmtInvDtlVO.setOrgChgAmt(invoiceIssueVO.getOrgChgAmt());
				    	                dmtInvDtlVO.setScRfaExptAmt(invoiceIssueVO.getExptAmt());
				    	                dmtInvDtlVO.setAftExptDcAmt(invoiceIssueVO.getAftExptDcAmt());
				    	                dmtInvDtlVO.setBilAmt(invoiceIssueVO.getBilAmt());
				    	                //dmtInvDtlVO.setCntrInvAmt(String.valueOf(cntr_inv_amt));
				    	                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntrInvAmt, "#.##"));
				    	                dmtInvDtlVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
				    	                //dmtInvDtlVO.setTaxAmt(String.valueOf(tax_amt));
				    	                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));
				    	                dmtInvDtlVO.setInvPrtFlg("");
				    	                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
				    	                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
				    	                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
			    	                
				    	                dbDao.addInvoiceDetail(dmtInvDtlVO);
				    	                
				    	                //addInvoiceRate
				    	                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
				    	                overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
				    	                overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
				    	                overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
				    	                overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
				    	                overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
				    	                overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
				    	                
				    	                // ********** DivOverDay 鈺곌퀬��
				    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
				    	                
				    					CalculationParmVO calculationParmVO = new CalculationParmVO();
				    					
				    					String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
				    					calculationParmVO.setDcApplRate(trfAplyTpCd);
			    					
			    						// basicCalculation - Baisc Tariff
			    						String firstSvrID = null;
			    						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
			    						chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    						chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
			    						chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
			    						chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
			    						chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
			    						chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
	
			    	    				log.debug(" iss issueInvoiceByGroup FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
		    						
			    						if ("Y".equals(invoiceIssueVO.getOfcTrnsFlg())) {
			    							firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			    						} 
			    						else {
			    							firstSvrID = invoiceIssueVO.getSvrId();
			    						}

			    						calculationParmVO.setSvrId(firstSvrID);		
			    						calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    						calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
			    						calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
			    						calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
			    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
			    						calculationParmVO.setOverDay(invoiceIssueVO.getOrgFtOvrDys());
			    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
			    						calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
			    						calculationParmVO.setFtDys(invoiceIssueVO.getFtDys());
			    						calculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
			    						calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());	// 2014.03.12
			    						calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);										// 2014.03.12
			    						
			    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());

			    						/*
			    						Charge에 적용된 Tariff에 따라 Charge금액을 계산한다.
			    					    A) "G"(Basic Tariff)인 경우 Basic Tariff의 Rate별 계산금액을 조회한다
			    					    B) "B"(Before Exception)인 경우 Before Exception Tariff의 Rate별 계산금액을 조회하고 Before Exception의 Currency를 조회한다
			    					    C) "S"(S/C Exception)인 경우 S/C Exception Tariff의 Rate별 계산금액을 조회하고 S/C Exception의 Currency를 조회한다
			    					    D) Charge에 적용된 Currency와 A), B), C)에서 계산한 Currency가 다른경우
			    					         1) 적용된 CurrencyExchange Rate를 조회하여 Charge 계산금액을 Exchange Rate를 곱한다
			    					         2) 1)에서 계산한 금액을 Currency별로 반올림처리 한다
			    						*/
			    						if ("G".equals(trfAplyTpCd)) {
	//		    							String firstSvrID = null;
			    							
			    							//office transfer check
			    			            	if ("Y".equals(invoiceIssueVO.getOfcTrnsFlg())) {
			    			            		
	//		    			            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
			    			            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    			            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
			    			            		chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
			    			            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
			    			            		chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
			    			            		chargeCalculationParmVO.setBkgNo(invoiceIssueVO.getBkgNo());
			    			            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
			    			            		
			    			    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
			    			            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			    			            	} 
			    			            	else {
			    			            		firstSvrID = invoiceIssueVO.getSvrId();
			    			            	}
		    							
			    							// basicCalculation - Baisc Tariff
			    							calculationParmVO.setSvrId(firstSvrID);
			    							calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
			    							calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
			    							calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
			    							calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
			    							calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
			    							calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
			    							calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
			    							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());			// 2014.03.12
			    							if (!"".equals(invoiceIssueVO.getScRfaExptAplyDt())) {		// 2014.03.12
			    								calculationParmVO.setDmdtTrfAplyTpCd("B");									
			    								calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
			    							} 
			    							else {
			    								calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
			    							}
			    						} 
			    						else if ("B".equals(trfAplyTpCd)) {
			    							// beforeCalculation - Before BKG Exception
			    							calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
			    							calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
			    							calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
			    							calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
			    							calculationParmVO.setCmbSeq("1");
			    							calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
			    							calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
			    							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());// 2014.03.12
			    						} 
			    						else if ("S".equals(trfAplyTpCd)) {
			    							// scCalculation - SC Exception
			    							calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
			    							calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
			    							calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
			    							calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
			    							calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());					
			    							calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());// 2014.03.12
			    						}
		    						                   					    
								    	//bbsChargeCalulation Input
								    	log.debug("\n basicCalculation.......................");				
								    	log.debug("\n svr_id 		      	= "+invoiceIssueVO.getSvrId());				
								    	log.debug("\n dmdt_trf_cd 		  	= "+invoiceIssueVO.getDmdtTrfCd());				
								    	log.debug("\n bzc_trf_seq 		  	= "+invoiceIssueVO.getBzcTrfSeq());
								    	log.debug("\n bzc_dmdt_de_term_cd 	= "+invoiceIssueVO.getBzcDmdtDeTermCd());
								    	log.debug("\n bzc_trf_grp_seq     	= "+invoiceIssueVO.getBzcTrfGrpSeq());				
								    	log.debug("\n cntr_tpsz_cd 	      	= "+invoiceIssueVO.getCntrTpszCd());				
								    	log.debug("\n org_ft_ovr_dys      	= "+invoiceIssueVO.getOrgFtOvrDys());				
								    	log.debug("\n div_over_day 	      	= "+overdayNDivVO.getDivOverDay());				
								    	log.debug("\n bzc_trf_curr_cd     	= "+invoiceIssueVO.getBzcTrfCurrCd());				
								    	log.debug("\n getFtDys 				= "+invoiceIssueVO.getFtDys());			// 2014.03.12
										log.debug("\n getFmMvmtYdCd 		= "+invoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
										log.debug("\n getBzcTrfAplyDt		= "+invoiceIssueVO.getBzcTrfAplyDt());	// 2014.03.12
										log.debug("\n setDmdtTrfAplyTpCd	= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
			    						
	
	//		    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);     
			    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);  
			    						
				    	                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
				    	                double inv_rt_amt = 0;
				    	                double rt_ovr_chg_amt = 0;
	
				    	                if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
				    	                	
				    	                	//addInvoiceRate
				    	                	for (int k=0; k<chrgDtlVOS.size(); k++) {
				    		                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(k);
				    		                    
				    		                    //over_day > 0 占쏙옙野껋럩��쭕占쏙옙占쎌삢占쎌뮆��
				    		                    if (Double.parseDouble(chrgDtlVO.getRtDay()) == 0) continue;
				    		                    
				    		                    DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
				    		                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
				    		                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
				    		                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
				    		                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
				    		                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
				    		                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueVO.getBzcTrfSeq());
				    		                    dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
				    		                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
				    		                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
				    		                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
				    		                    
		    		                    		inv_rt_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtRate());
		    		                    		inv_rt_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), inv_rt_amt);
		    		                    		rt_ovr_chg_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtChrg());
		    		                    		rt_ovr_chg_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), rt_ovr_chg_amt);
				    		                    
				    		                    dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(inv_rt_amt, "#.##"));
				    		                    dmtInvRtVO.setRtOvrChgAmt(String.valueOf(rt_ovr_chg_amt));
				    		                    
				    		                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
				    		                    dmtInvRtVO.setBzcCurrCd(invoiceIssueVO.getBzcTrfCurrCd());	//Basic Curr
				    		                    
				    		                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
				    		                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
				    		                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
				    		                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
				    		                    
				    		                    dbDao.addInvoiceRate(dmtInvRtVO);
				    	                	}
				    	                }
				    	              //======================================================
				    	                
				    	                //Discount Amount + Exception Amount > 0
				    	                double dScRfaExptAmt = Double.parseDouble(invoiceIssueVO.getExptAmt());
				    	                double dAftExptDcAmt = Double.parseDouble(invoiceIssueVO.getAftExptDcAmt());
				    	                double dCmdtExptAmt  = Double.parseDouble(invoiceIssueVO.getCmdtExptAmt());
				    	                
				    	                if(( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt != 0) && trfAplyTpCd.equals("G")) {
				    	                	rt_ovr_chg_amt = 0;
				    	                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
				    	                
				    		                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
				    		                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
				    		                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
				    		                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
				    		                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
				    		                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
				    		                dmtInvRtVO.setBzcTrfSeq(invoiceIssueVO.getBzcTrfSeq());
				    		                dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
				    		                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
				    		                dmtInvRtVO.setBzcTrfRtSeq("");
				    		                dmtInvRtVO.setFtOvrDys("0");
				    		                dmtInvRtVO.setFtUndDys("0");
				    		                dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) 疫뀀뜆釉�
				    		                dmtInvRtVO.setRtOvrDys("1");
				    		                dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) 疫뀀뜆釉�
				    		                dmtInvRtVO.setBzcCurrCd(invoiceIssueVO.getBzcTrfCurrCd());
				    		                dmtInvRtVO.setCreUsrId(account.getUsr_id());
				    		                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
				    		                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
				    		                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
				    		                
				    		                dbDao.addInvoiceRate(dmtInvRtVO);
				    	                }			    	                
				    	            }
			    	            }
			    	            log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 ( 첫번째 초과일 경우 ) >> 처리 종료!!");
	    					}
	    					//================================================
	    					//<< 두번째 항목부터 실행되는 로직 종료 >>
	    					//================================================
	    					sBkgNo = confirmChargeListVOs[i].getBkgNo();
	    					sel_cntr++;	// 항목수 COUNT
	    					log.debug("[BKGNO.........]"+sBkgNo+"[INVOICE_NO]"+invoice_no+"[sel_cntr]"+sel_cntr);
	    					log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " << 선택된 경우 >> 처리 종료!!");
		    			}
		    			
		    			if (i == (confirmChargeListVOs.length - 1)) {
		    				// Update Invoice Main
							DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
							dmtInvMnVO.setDmdtInvNo(invoice_no);
							dmtInvMnVO.setCreCntCd(invoiceGroupParamVO.getUsrCntCd());
		    	            dmtInvMnVO.setOrgChgAmt(String.valueOf(tot_org_chg_amt));
		    	            dmtInvMnVO.setDmdtExptAmt(JSPUtil.toDecimalFormat(tot_sc_rfa_expt_amt, "#.##"));
		    	            dmtInvMnVO.setDcAmt(JSPUtil.toDecimalFormat(tot_aft_expt_dc_amt, "#.##"));
		    	            dmtInvMnVO.setBilAmt(JSPUtil.toDecimalFormat(tot_bil_amt, "#.##"));
		    	            dmtInvMnVO.setBkgCntrQty(String.valueOf(cntr_cnt));
		    	            dmtInvMnVO.setInvChgAmt(JSPUtil.toDecimalFormat(tot_inv_amt, "#.##"));
		    	            String taxRto = "IN".equals(invoiceGroupParamVO.getUsrCntCd()) ? "" : String.valueOf(tot_inv_tax_rto);
		    	            dmtInvMnVO.setTaxRto(taxRto);
	
		    	            if ("GRP".equals(invoiceGroupParamVO.getSGroupInv())) {	
			    	            dmtInvMnVO.setTaxAmt(invoiceGroupParamVO.getTaxAmt());
			    	            dmtInvMnVO.setInvAmt(invoiceGroupParamVO.getInvAmt());	
			    	            
			    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {
			    	            	dmtInvMnVO.setIdaCgstAmt(invoiceGroupParamVO.getIdaCgstAmt());
			    	            	dmtInvMnVO.setIdaSgstAmt(invoiceGroupParamVO.getIdaSgstAmt());
			    	            	dmtInvMnVO.setIdaIgstAmt(invoiceGroupParamVO.getIdaIgstAmt());
			    	            	dmtInvMnVO.setIdaUgstAmt(invoiceGroupParamVO.getIdaUgstAmt());				    	            	
			    	            }
		    	            } 
		    	            else {
			    	            dmtInvMnVO.setTaxAmt(JSPUtil.toDecimalFormat(tot_inv_tax_amt, "#.##"));
			    	            dmtInvMnVO.setInvAmt(JSPUtil.toDecimalFormat(tot_inv_payable_amt, "#.##"));		
			    	            
			    	            if ("IN".equals(invoiceGroupParamVO.getUsrCntCd())) {
				    	            //=====================================================================================================================================
				    	            // Individual Invoice nbr for selected BKGs 으로 생성한 경우, BKG 별로 invoice 를 생성하므로, 
				    	            // 동일한 BKG 에 묶인 모든 Tax Amount 구해서 Update 해줘야 합니다.
				    	            //=====================================================================================================================================					    	            
				    	            dmtInvMnVO.setIdaCgstAmt(JSPUtil.toDecimalFormat(idaCgstAmt, "#.##"));
				    	            dmtInvMnVO.setIdaSgstAmt(JSPUtil.toDecimalFormat(idaSgstAmt, "#.##"));
				    	            dmtInvMnVO.setIdaIgstAmt(JSPUtil.toDecimalFormat(idaIgstAmt, "#.##"));
				    	            dmtInvMnVO.setIdaUgstAmt(JSPUtil.toDecimalFormat(idaUgstAmt, "#.##"));
				    	            //=====================================================================================================================================			    	            	
			    	            }			    	            
		    	            }
							
		    	            dbDao.modifyInvoiceMainByGroupContainer(dmtInvMnVO);
		    			}
		    		}//BL check
		    		log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> " + (i+1) + " 번째 CNTR No. :: " + confirmChargeListVOs[i].getCntrNo() + " 처리 종료!!");
    			}// 
				//reInvoiceGroupParamVO Setting
				reInvoiceGroupParamVO = new InvoiceGroupParamVO();
	    		
				reInvoiceGroupParamVO.setInvQty(String.valueOf(inv_qty));
				reInvoiceGroupParamVO.setIssueDate(issue_date);
				reInvoiceGroupParamVO.setErrCode("");
				reInvoiceGroupParamVO.setErrMsg("");
				
				
				log.debug("\n\n[ INVOICE 발행 ] << GROUP BY CONTAINER >> STEP :::::> 종료");
	    	}// cntr
    		reInvoiceGroupParamVO.setTotBilAmt(invoiceGroupParamVO.getTotBilAmt());
    		reInvoiceGroupParamVO.setTotTaxAmt(invoiceGroupParamVO.getTotTaxAmt());
    		reInvoiceGroupParamVO.setTotPayableAmt(invoiceGroupParamVO.getTotPayableAmt());
    		reInvoiceGroupParamVO.setSGroupBy(invoiceGroupParamVO.getSGroupBy());
    		reInvoiceGroupParamVO.setSChargeType(invoiceGroupParamVO.getSChargeType());
    		
    		reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
    		reInvoiceGroupMgtVO.setConfirmChargeList(reConfirmChargeListVOs);
        } 
    	catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        } 
    	catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
        	throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        }
        
        return reInvoiceGroupMgtVO;
    }                         
    
    
    /**
    * [Manual Invoice Report by Office]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceSummaryVO>
    * @exception EventException
    */
    public List<ManualInvoiceSummaryVO> searchManualInvoiceBySummaryList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws EventException {
        try {
            return dbDao.searchManualInvoiceBySummaryList ( manualInvoiceIssueParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
        	throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        }
    }
    
    /**
    * [Manual Invoice Report by Office - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceIssuedListVO>
    * @exception EventException
    */
    public List<ManualInvoiceIssuedListVO> searchManualInvoiceByDetailList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws EventException {
        try {
            return dbDao.searchManualInvoiceByDetailList ( manualInvoiceIssueParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO3>
    * @exception EventException
    */
    public List<OtsInquiryByDetial3VO> searchOTSInquiryByDetailList3 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryByDetailList3 ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Manual Invoice Report by Office]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @return String
    * @exception EventException
    */
    public String searchManualInvoiceReasonList() throws EventException {
        try {
            return dbDao.searchManualInvoiceReasonList();
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * [Issued Invoice Inquiry]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceListVO>
     * @exception EventException
     */
    public List<IssuedInvoiceListVO> searchIssuedInvoiceList ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws EventException{
        try {
        	issuedInvoiceParamVO.setSIssueFm(JSPUtil.replace(issuedInvoiceParamVO.getSIssueFm(), "-",""));
        	issuedInvoiceParamVO.setSIssueTo(JSPUtil.replace(issuedInvoiceParamVO.getSIssueTo(), "-",""));
        	
        	
        	log.debug("\n [bc] s_inv_check==>"+issuedInvoiceParamVO.getSInvCheck());
            return dbDao.searchIssuedInvoiceList(issuedInvoiceParamVO);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    /**
     * [Invoice Create & Issue]占쏙옙[Retrieve] 占썩뫖�뀐옙占�br>
     * 
     * @param String invoiceNo
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
     public InvoiceIssueMgtVO searchManualInvoiceByBooking(String invoiceNo) throws EventException {
    	 InvoiceIssueMgtVO invoiceIssueMgtVO = new InvoiceIssueMgtVO();
    	 
    	 DmtInvMnVO dmtInvMnVO = null;
    	 
         try {
        	 //1.Manual Invoice �쒙옙鈺곌퀬�띰옙�뺣뼄.
        	 List<DmtInvMnVO> dmtInvMnVOS = dbDao.searchManualInvoiceMain(invoiceNo);
        	 if (dmtInvMnVOS != null && dmtInvMnVOS.size() > 0) {
        		 dmtInvMnVO = dmtInvMnVOS.get(0);

        		 //==================================================================================================
        		 // BKG Cust. 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
        		 //==================================================================================================
        		 List<BookingCustomerVO> bkgCustomerVOS = dbDao.searchBookingCustomerByManual(dmtInvMnVO.getBkgNo(), dmtInvMnVO.getDmdtTrfCd());	
        		 if (bkgCustomerVOS != null && bkgCustomerVOS.size() > 0) {
        			 dmtInvMnVO.setBkgCustCd(bkgCustomerVOS.get(0).getCustCd());
        			 dmtInvMnVO.setBkgCustNm(bkgCustomerVOS.get(0).getCustNm());
        		 }
        		 
        		 //==================================================================================================
            	 // A/R Cust. 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
        		 //==================================================================================================
            	 List<ARActualPayerVO> arActualPayerVOS = dbDao.searchARActualPayer(dmtInvMnVO.getBkgNo(), dmtInvMnVO.getDmdtTrfCd());
            	 if (arActualPayerVOS != null && arActualPayerVOS.size() > 0) {
            		 dmtInvMnVO.setActCustCd(arActualPayerVOS.get(0).getActCustCd());
            		 dmtInvMnVO.setActCustNm(arActualPayerVOS.get(0).getActCustNm());
            	 }

        		 //==================================================================================================
        		 // Due Date, Credit Term, Tax Rate 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
        		 //==================================================================================================
        		 List<DmtCrTermOptVO> dmtCrTermOptVOS = dbDao.searchInvoiceTermOption(dmtInvMnVO.getIssueOfcCd(), dmtInvMnVO.getIssueDt(), dmtInvMnVO.getDmdtTrfCd());
        		 if (dmtCrTermOptVOS != null && dmtCrTermOptVOS.size() > 0) {
        			 dmtInvMnVO.setDueDt(dmtCrTermOptVOS.get(0).getDueDt());
        			 dmtInvMnVO.setCrTermDys(dmtCrTermOptVOS.get(0).getCrTermDys());
        			 dmtInvMnVO.setIssDtPrnFlg(dmtCrTermOptVOS.get(0).getIssDtPrnFlg());
        			 dmtInvMnVO.setDfltTaxRto(dmtCrTermOptVOS.get(0).getDfltTaxRto());
        		 } 
	        	
        		 //==================================================================================================
        		 // Manual Invoice Detail(Charge) �쒙옙鈺곌퀬�띰옙�뺣뼄.
        		 //==================================================================================================
	        	 List<DmtInvDtlVO> dmtInvDtlVOS = dbDao.searchManualInvoiceDetail(invoiceNo);
	        	 
        		 //==================================================================================================
        		 // Manual Invoice Rate Detail �쒙옙鈺곌퀬�띰옙�뺣뼄.
        		 //==================================================================================================	        	 
	        	 List<DmtInvRtVO> dmtInvRtVOS = dbDao.searchManualInvoiceRate(invoiceNo);
	        	 
	        	 //SC 占쏙옙Return 占쎈똻竊쒏묾怨쀬맄占쏙옙域밸챶竊셑O 占쏙옙鈺곌퀬�띰옙占썲칰怨뚮궢�쒙옙占썬끉�숋옙�곻옙占쏙옙
	        	 invoiceIssueMgtVO.setDmtInvMnVOS(dmtInvMnVOS);
	        	 invoiceIssueMgtVO.setDmtInvDtlVOS(dmtInvDtlVOS);
	        	 invoiceIssueMgtVO.setDmtInvRtVOS(dmtInvRtVOS);
        	 }
         } catch (DAOException ex) {
        	 log.error("[DAOException]"+ex.getMessage());
             throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
         } catch (Exception ex) {
        	 log.error("[Exception]"+ex.getMessage());
        	 throw new EventException(ex.getMessage(),ex);
 		}
         return invoiceIssueMgtVO;
     }    
     /**
      * [Invoice Create & Issue]占쏙옙[Retrieve] 占썩뫖�뀐옙占�br>
      * 
      * @param String bookingNo
      * @param String officeCode
      * @param String tariffType
      * @param String cntrDtlFlg
      * @return InvoiceIssueMgtVO
      * @exception EventException
      */
     public InvoiceIssueMgtVO searchManualKeyByBooking(String bookingNo, 
    		 String officeCode, String tariffType, String cntrDtlFlg) throws EventException {
    	 
    	 InvoiceIssueMgtVO 			invoiceIssueMgtVO 		= new InvoiceIssueMgtVO();
    	 List<ManualKeyByChargeVO> 	manualKeyByChargeVOS 	= null;
    	 List<ManualKeyByBookingVO> manualKeyByBookingVOS 	= null;
    	 
    	 try {
    		 //==================================================================================================
        	 // Charge Booking Container 占쎈슣�좈뇡遺용퓠占쏙옙Booking No. 占쏙옙占쏙옙釉�占쎈베�ョ몴占썼�怨좎돳占쎌뮆��(Payer, Trucker 占싼뗫맙)
    		 //==================================================================================================    		 
    		 manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingData(bookingNo, tariffType);
    		 
    		 //==================================================================================================
        	 // 鈺곌퀬�띰옙占썲칰怨뚮궢揶쏉옙占쎈냱��野껋럩��Booking 占쎈슣�좈뇡遺용퓠占쏙옙Booking No. 占쏙옙占쏙옙釉�占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
    		 //==================================================================================================    		 
    		 if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
    			 manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(bookingNo);
    		 }
    		 
    		 //==================================================================================================
        	 // Container Detail 占쏙옙'Y' 嚥∽옙占쎌쥚源�옙�뤿선  占쎈뜃�� Booking 占쎈베�ュ첎占썼��곸삺占쎌뮆�롳쭖占�Charge 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
    		 //==================================================================================================    		 
    		 if (manualKeyByBookingVOS != null && manualKeyByBookingVOS.size() > 0 && "Y".equals(cntrDtlFlg)) {
    			 //占쎄낱源�첎占�Deleted', 'Error' 占쏙옙Manual Invoice Detail(Charge) �쒙옙鈺곌퀬�띰옙�뺣뼄.
    			 manualKeyByChargeVOS = dbDao.searchManualInvoiceChargeData(bookingNo, officeCode, tariffType);
    		 }
    		 
    		 //==================================================================================================
        	 // BKG 占쎈베�ュ첎占쏙옙�용뼄筌롳옙 BKG Cust., A/R Cust., Due Date, Credit Term, Tax Rate 占쎈베��占쏙옙�ｏ옙占쏙옙袁る퉸占쏙옙揶쏆빘猿쒐몴占쏙옙�밴쉐
    		 //==================================================================================================    		 
    		 if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
    			 manualKeyByBookingVOS = new ArrayList<ManualKeyByBookingVO>();
    			 manualKeyByBookingVOS.add(new ManualKeyByBookingVO());
    		 }

    		 //==================================================================================================
        	 // BKG Cust. 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
    		 //==================================================================================================
        	 List<BookingCustomerVO> bkgCustomerVOS = dbDao.searchBookingCustomerByManual(bookingNo, tariffType);
        	 if (bkgCustomerVOS != null && bkgCustomerVOS.size() > 0) {
        		 manualKeyByBookingVOS.get(0).setBkgCustCd(bkgCustomerVOS.get(0).getCustCd());
        		 manualKeyByBookingVOS.get(0).setBkgCustNm(bkgCustomerVOS.get(0).getCustNm());
        	 }

    		 //==================================================================================================
        	 // A/R Cust. 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
    		 //==================================================================================================
        	 List<ARActualPayerVO> arActualPayerVOS = dbDao.searchARActualPayer(bookingNo, tariffType);
        	 if (arActualPayerVOS != null && arActualPayerVOS.size() > 0) {
        		 manualKeyByBookingVOS.get(0).setActCustCd(arActualPayerVOS.get(0).getActCustCd());
        		 manualKeyByBookingVOS.get(0).setActCustNm(arActualPayerVOS.get(0).getActCustNm());
        	 }

    		 //==================================================================================================
        	 // Due Date, Credit Term, Tax Rate 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
    		 //==================================================================================================
        	 List<DmtCrTermOptVO> dmtCrTermOptVOS = dbDao.searchInvoiceTermOption(officeCode, "", tariffType);
        	 if (dmtCrTermOptVOS != null && dmtCrTermOptVOS.size() > 0) {
        		 manualKeyByBookingVOS.get(0).setDueDt(dmtCrTermOptVOS.get(0).getDueDt());
        		 manualKeyByBookingVOS.get(0).setCrTermDys(dmtCrTermOptVOS.get(0).getCrTermDys());
        		 manualKeyByBookingVOS.get(0).setIssDtPrnFlg(dmtCrTermOptVOS.get(0).getIssDtPrnFlg());
        		 manualKeyByBookingVOS.get(0).setDfltTaxRto(dmtCrTermOptVOS.get(0).getDfltTaxRto());
        	 }    		 

    		 //==================================================================================================
        	 // Data Display 甕곌쑵��占쎈��껓옙占썼�怨좎돳占쏙옙野껉퀗�든몴占폞roup VO 揶쏆빘猿쒙옙占쏙옙�쇱젟占쎈똻占쏙옙占�
    		 //==================================================================================================
       		 invoiceIssueMgtVO.setManualKeyByBookingVOS(manualKeyByBookingVOS);
        	 if (manualKeyByChargeVOS != null && manualKeyByChargeVOS.size() > 0) {
        		 invoiceIssueMgtVO.setManualKeyByChargeVOS(manualKeyByChargeVOS);
        	 }
        	 
	     } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
	    	 log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	     } catch (Exception ex) {
	    	 log.error("[Exception]"+ex.getMessage());
	    	 throw new EventException(ex.getMessage(),ex);
		 } 
	     return invoiceIssueMgtVO;
    } 
     /**
      * [CNTR No. 占쎈벤�쀯옙占쏙옙占�Retrieve] 占썩뫖�뀐옙占�br>
      * 
      * @param String cntrNo
      * @return String
      * @exception EventException
      */
     public String checkContainerNo(String cntrNo) throws EventException {
    	 
    	 try {
    		 return dbDao.checkContainerNo(cntrNo);
    	 } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
    		 log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	     } catch (Exception ex) {
	    	 log.error("[Exception]"+ex.getMessage());
	    	 throw new EventException(ex.getMessage(),ex);
	     }
     }
     /**
      * [VVD CD. Calling Port]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
      * 
      * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
      * @return boolean
      * @exception EventException
      */
     public boolean checkCallingPort(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws EventException {
    	 
    	 try {
    		 return dbDao.checkCallingPort(chargeBookingInvoiceVO);
    	 } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
    		 log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler(ex).getMessage());
	     } catch (Exception ex) {
	    	 log.error("[Exception]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	     }
     }
     /**
      * [VVD CD. 揶쏉옙鈺곕똻�깍옙�롫뮉筌욑옙�쒙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
      * 
      * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
      * @return boolean
      * @exception EventException
      */
     public boolean checkVVD(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws EventException {
    	 
    	 try {
    		 return dbDao.checkVVD(chargeBookingInvoiceVO);
    	 } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
    		 log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	     } catch (Exception ex) {
	    	 log.error("[Exception]"+ex.getMessage());
	    	 throw new EventException(ex.getMessage(),ex);
	     }
     }
     /**
      * [Manual Invoice Creation & Issue [Invoice Issue 占쏙옙]占쏙옙[Save] 占썩뫖�뀐옙占�br>
      * 
      * @param manualInvoiceIssueVO ManualInvoiceIssueVO
      * @param SignOnUserAccount account
      * @exception EventException
      */
     public void modifyInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException {
     	 
     	 try {
 			//1.Group VO 揶쏆빘猿쒙옙癒�퐣 Client 揶쏉옙 占쎄쑴�싷옙占쏙옙類ｋ궖�쒙옙筌ｌ꼶�곻옙�띾┛ 占쎄쑵鍮먲옙占썲첎占쏙옙諭�쉐癰귢쑬以�占쎈베�ョ몴占썽겫袁⑥첒占쎌뮆�� 
     		//Update 占쏙옙Booking 占쎈베�ョ몴占폞roup VO 占쎈Ŋ苑��곕뗄�㏆옙�뺣뼄.
     		 DmtInvMnVO invMnVO = manualInvoiceIssueVO.getDmtInvMnVO();
  			
  			//Insert, Update, Delete 占쏙옙Charge, Rate 占쎈베�ョ몴占폞roup VO 占쎈Ŋ苑��곕뗄�㏆옙�뺣뼄.
  			List<DmtInvDtlVO> invDtlVOS = manualInvoiceIssueVO.getDmtInvDtlVOS();
  			List<DmtInvRtVO> invRtVOS = manualInvoiceIssueVO.getDmtInvRtVOS();
 			//############################################################################################################
 			
  			//1.Booking 占쎈베�ワ옙占쏙옙袁⑸땾占쎈베�ョ몴占썹빊遺쏙옙占쎈똻占쏙옙占�
   			if (invMnVO != null) {
   				invMnVO.setUpdUsrId(account.getUsr_id());
   				invMnVO.setUpdOfcCd(account.getOfc_cd());
   			} 			
 			
 			//2.Charge 占쎈베�ョ몴占폠nsert, Update, Delete 筌ｌ꼶�곭몴占쏙옙袁る퉸 �브쑬�곻옙�쀪텚占쏙옙
 			List<DmtInvDtlVO> insInvDtlVOS = new ArrayList<DmtInvDtlVO>();
 			List<DmtInvDtlVO> updInvDtlVOS = new ArrayList<DmtInvDtlVO>();
 			List<DmtInvDtlVO> delInvDtlVOS = new ArrayList<DmtInvDtlVO>();

 			if (invDtlVOS != null) {
 				for (int i = 0 ; i < invDtlVOS.size(); i++) {
 					if (invDtlVOS.get(i).getIbflag().equals("I")) {
 						invDtlVOS.get(i).setCreUsrId(account.getUsr_id());
 						invDtlVOS.get(i).setCreOfcCd(account.getOfc_cd());
 						invDtlVOS.get(i).setUpdUsrId(account.getUsr_id());
 						invDtlVOS.get(i).setUpdOfcCd(account.getOfc_cd());
 						insInvDtlVOS.add(invDtlVOS.get(i));
 					} else if (invDtlVOS.get(i).getIbflag().equals("U")) {
 						invDtlVOS.get(i).setUpdUsrId(account.getUsr_id());
 						invDtlVOS.get(i).setUpdOfcCd(account.getOfc_cd());
 						updInvDtlVOS.add(invDtlVOS.get(i));
 					} else if (invDtlVOS.get(i).getIbflag().equals("D")) {
 						delInvDtlVOS.add(invDtlVOS.get(i));
 					}
 				}
 			}			
 			
 			//3.Rate 占쎈베�ョ몴占폠nsert, Update, Delete 筌ｌ꼶�곭몴占쏙옙袁る퉸 �브쑬�곻옙�쀪텚占쏙옙
 			List<DmtInvRtVO> insInvRtVOS = new ArrayList<DmtInvRtVO>();
 			List<DmtInvRtVO> updInvRtVOS = new ArrayList<DmtInvRtVO>();
 			List<DmtInvRtVO> delInvRtVOS = new ArrayList<DmtInvRtVO>();
 			
 			if (invRtVOS != null) {
 				for (int i = 0 ; i < invRtVOS.size(); i++) {
 					if (invRtVOS.get(i).getIbflag().equals("I")) {
 						invRtVOS.get(i).setCreUsrId(account.getUsr_id());
 						invRtVOS.get(i).setCreOfcCd(account.getOfc_cd());
 						invRtVOS.get(i).setUpdUsrId(account.getUsr_id());
 						invRtVOS.get(i).setUpdOfcCd(account.getOfc_cd()); 						
 						insInvRtVOS.add(invRtVOS.get(i));
 					} else if (invRtVOS.get(i).getIbflag().equals("U")) {
 						invRtVOS.get(i).setUpdUsrId(account.getUsr_id());
 						invRtVOS.get(i).setUpdOfcCd(account.getOfc_cd());
 						updInvRtVOS.add(invRtVOS.get(i));
 					} else if (invRtVOS.get(i).getIbflag().equals("D")) {
 						delInvRtVOS.add(invRtVOS.get(i));
 					}
 				}
 			}
 			
 			//1.[Delete Action] * 獄쏆꼶諭띰옙占쏙옙占쎌젫 Action 占쏙옙�믪눘占�占썬끋六억옙�뤿선占쏙옙占쎌뮆�� *
 			if (delInvRtVOS.size() > 0) {
 				dbDao.removeInvoiceRate(delInvRtVOS);
 			}			
 			if (delInvDtlVOS.size() > 0) {
 				dbDao.removeInvoiceDetail(delInvDtlVOS);
 			}

 			//2.[Insert Action]
 			if (insInvDtlVOS.size() > 0) {
 				dbDao.addInvoiceDetailByManual(insInvDtlVOS);
 			}
 			if (insInvRtVOS.size() > 0) {
 				dbDao.addInvoiceRateByManual(insInvRtVOS);
 			}

 			//3.[Update Action]
 			if (invMnVO != null) {
 				//dbDao.modifyInvoice(invMnVO);----- 占쎈슣�わ옙占썸꽴占쏀�嚥∽옙癰귨옙瑗랃옙�몃빍占쏙옙 繹먲옙源�뉩占�
 				dbDao.modifyInvoiceManual(invMnVO);
 			}
 			if (updInvDtlVOS.size() > 0) {
 				dbDao.modifyInvoiceDetail(updInvDtlVOS);
 			}
 			if (updInvRtVOS.size() > 0) {
 				dbDao.modifyInvoiceRate(updInvRtVOS);
 			}
 			
     	 } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
     		 log.error("[DAOException]"+ex.getMessage());
 	         throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
 	     } catch (Exception ex) {
 	    	 log.error("[Exception]"+ex.getMessage());
 	         throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
 	     }
     }
     /**
      * [Manual Invoice Creation & Issue [Invoice Issue 占쏙옙]占쏙옙[Save] 占썩뫖�뀐옙占�br>
      * 
      * @param ManualInvoiceIssueVO manualInvoiceIssueVO
      * @param SignOnUserAccount account
      * @return DmtInvMnVO
      * @exception EventException
      */
     public DmtInvMnVO issueInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException {
    	 
     	 // 반환 객체
    	 DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
     	 
     	 try {
      		 DmtInvMnVO 		invMnVO 	= manualInvoiceIssueVO.getDmtInvMnVO();
   			List<DmtInvDtlVO> 	invDtlVOS 	= manualInvoiceIssueVO.getDmtInvDtlVOS();
   			List<DmtInvRtVO> 	invRtVOS 	= manualInvoiceIssueVO.getDmtInvRtVOS();
   			
    		if (invMnVO != null) {
    				
                // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
                InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
                invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
                invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
                invoiceNoGenCondVO.setDmdtInvTpCd("M");					// manual invoice
                // [ Invoice No. 채번 로직 실행 ]==========================================================
                InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
                // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
                if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
                	throw new EventException(new ErrorHandler(invoiceNoGenVO.getErrMsgCd()).getUserMessage());
                }
                //=========================================================================================
                String invoiceNo = invoiceNoGenVO.getDmdtInvNo();
                
    			if (	"HJXX".equals(invMnVO.getVvdCd().substring(0,4)) 
    				|| 	"HJYY".equals(invMnVO.getVvdCd().substring(0,4)) 
    				|| 	"HJZZ".equals(invMnVO.getVvdCd().substring(0,4))	
    				||  "CFDR".equals(invMnVO.getVvdCd().substring(0,4))) {
    				invMnVO.setVslCd("CFDR");
    				invMnVO.setSkdVoyNo(dbDao.searchDateFormatYYMM(account.getOfc_cd()));
    				invMnVO.setSkdDirCd("E");
    			}
    			else {
    				invMnVO.setVslCd(invMnVO.getVvdCd().substring(0,4));
    				invMnVO.setSkdVoyNo(invMnVO.getVvdCd().substring(4,8));
    				invMnVO.setSkdDirCd(invMnVO.getVvdCd().substring(8));
                }
    			
    			invMnVO.setDmdtInvNo(invoiceNo);
    			invMnVO.setIoBndCd(invMnVO.getDmdtTrfCd().substring(2, 3));
    			invMnVO.setDmdtChgTpCd("G"); //G:GENERAL, B:BALANCE
    			invMnVO.setMnlInpFlg("Y");
                invMnVO.setDmdtArIfCd("N");
                invMnVO.setDmdtInvStsCd("I");
    			invMnVO.setCreUsrId(account.getUsr_id());
    			invMnVO.setCreOfcCd(account.getOfc_cd());
    			invMnVO.setUpdUsrId(account.getUsr_id());
    			invMnVO.setUpdOfcCd(account.getOfc_cd());    			

	    		//2.Charge 占쎈베�ワ옙占쏙옙袁⑸땾占쎈베�ョ몴占썹빊遺쏙옙占쎈똻占쏙옙占�
	  			if (invDtlVOS != null) {
	  				for (int i = 0 ; i < invDtlVOS.size(); i++) {
	  					//Invoice No. �쒙옙占썬끉�숋옙�곻옙占쏙옙
	  					invDtlVOS.get(i).setDmdtInvNo(invMnVO.getDmdtInvNo());
	  					invDtlVOS.get(i).setCreUsrId(account.getUsr_id());
	  					invDtlVOS.get(i).setCreOfcCd(account.getOfc_cd());
	  					invDtlVOS.get(i).setUpdUsrId(account.getUsr_id());
	  					invDtlVOS.get(i).setUpdOfcCd(account.getOfc_cd());  					
	  				}
	  			} 			
	  			
	  			//3.Rate 占쎈베�ワ옙占쏙옙袁⑸땾占쎈베�ョ몴占썹빊遺쏙옙占쎈똻占쏙옙占�
	  			if (invRtVOS != null) {
	  				for (int i = 0 ; i < invRtVOS.size(); i++) {
	  					//Invoice No. �쒙옙占썬끉�숋옙�곻옙占쏙옙
	  					invRtVOS.get(i).setDmdtInvNo(invMnVO.getDmdtInvNo());
	  					invRtVOS.get(i).setCreUsrId(account.getUsr_id());
	  					invRtVOS.get(i).setCreOfcCd(account.getOfc_cd());
	  					invRtVOS.get(i).setUpdUsrId(account.getUsr_id());
	  					invRtVOS.get(i).setUpdOfcCd(account.getOfc_cd());  					
	  				}
	  			}
	  			
	  			// 신규채번된 Invoice No. 설정
	  			dmtInvMnVO.setDmdtInvNo(invoiceNo);
	  			dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
    		}

  			//4.[Insert Action]
  			if (invMnVO != null) {
  				dbDao.addInvoiceMain(invMnVO);
  			}
  			if (invDtlVOS != null && invDtlVOS.size() > 0) {
  				dbDao.addInvoiceDetailByManual(invDtlVOS);
  			}
  			if (invRtVOS != null && invRtVOS.size() > 0) {
  				dbDao.addInvoiceRateByManual(invRtVOS);
  			}

     	 } 
     	 catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
     		 log.error("[DAOException]"+ex.getMessage());
     		 throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
     	 } 
     	 catch(EventException ex) {
     		 log.error("[EventException]"+ex.getMessage());
     		 throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
 	     } 
     	 catch (Exception ex) {
 	    	 log.error("[Exception]"+ex.getMessage());
 	         throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
 	     }
     	 
     	 // Manual Invoice 정상 발행!!
     	 dmtInvMnVO.setErrCode("DMT03064");  // Invoice was created successfully.
     	 
 	     return dmtInvMnVO;
     }           
     /**
      * Invoice Cancel 占싼딆��쒙옙鈺곌퀬�띰옙�롫뮉 占쎈뗀��
      * @return List<DmtCommonReturnDataVO>
      * @throws EventException
      */
     public List<DmtCommonReturnDataVO> searchCancelReason() throws EventException {
         try {
         	
        	 return dbDao.searchCancelReason();        
             
         } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
        	 log.error("[DAOException]"+ex.getMessage());
             throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
         } catch (Exception ex) {
        	 log.error("[Exception]"+ex.getMessage());
        	 throw new EventException(ex.getMessage(),ex);
         }       

     }
     
     
     
    /**
    * [Hold Reason Entry]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param String invoiceNo
    * @return String
    * @exception EventException
    */
    public String searchHoldReason ( String invoiceNo ) throws EventException {
        try {
            return dbDao.searchHoldReason( invoiceNo );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * [Hold Reason Entry]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
     * 
     * @return List<DmtCommonReturnDataVO>
     * @exception EventException
     */
    public List<DmtCommonReturnDataVO> searchHoldReasonCdList() throws EventException{
        try {
            return dbDao.searchHoldReasonCdList();
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [Hold Reason Entry]占쏙옙[UPDATE] 占썩뫖�뀐옙占�br>
    * 
    * @param String invoiceNo
    * @param String holdReasn
    * @param String holdRemrk
    * @param SignOnUserAccount account
    * @return String
    * @exception EventException
    */
    public String modifyInvoiceByHold ( String invoiceNo , String holdReasn , String holdRemrk , SignOnUserAccount account ) throws EventException {
        try {
            String tRtnVal = "";
            StringTokenizer st1 = new StringTokenizer(invoiceNo, ",");
            while (st1.hasMoreTokens()) {
                tRtnVal = dbDao.modifyInvoiceByHold ( st1.nextToken() , holdReasn , holdRemrk , account );
            }            
            return tRtnVal;
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }

    /**
     * [Invoice]占쏙옙[Cancel] 占썩뫖�뀐옙占�br>
     * 
     * @param cancelInvoiceParamVO
     * @param SignOnUserAccount account
     * @return String
     * @throws EventException
     */
    public List<ChargeArgumentVO> cancelInvoice(CancelInvoiceParamVO cancelInvoiceParamVO, SignOnUserAccount account) throws EventException {
   	 
		String oldInvoiceNo 	= "";
		String invoice_no 		= "";
		String creOfcCd 		= "";
		
		DmtInvMnVO dmtInvMnVO 	= new DmtInvMnVO();
		DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
		DmtInvRtVO dmtInvRtVO 	= new DmtInvRtVO();
		
		DmtInvMnVO arIFCheckInvMn = new DmtInvMnVO();
		List<ChargeArgumentVO> chargeArgumentVOList = new ArrayList<ChargeArgumentVO>();
		ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
		String message = "";
 
		try {
			oldInvoiceNo = cancelInvoiceParamVO.getDmdtInvNo();
			creOfcCd 	 = cancelInvoiceParamVO.getCreOfcCd();

			String invNo = dbDao.checkCreditInvoice(oldInvoiceNo, creOfcCd);
			
			if (StringUtils.isEmpty(invNo)) {
				chargeArgumentVO.setErrCode("DMT03024");
				//Message = "Only Issue Office("+cancelInvoiceParamVO.getCreOfcCd()+") can cancel the invoice. Please recheck your login Office code.");
				message = new ErrorHandler("DMT03024").getUserMessage();
				message = JSPUtil.replace(message, "XXXXX", cancelInvoiceParamVO.getCreOfcCd());
				chargeArgumentVO.setErrMsg(message);
				chargeArgumentVOList.add(chargeArgumentVO);
				return chargeArgumentVOList;
			}
			
			// [ invoice 유형 조회 ]==========================================================================================================
			// invoice 가 인도지역에서 발행된 경우, 신규세법적용으로 인해서 invoice no. 체계가 달라져 invoice 유형을 가져오는 방법이 달라짐.
			//================================================================================================================================			
			String invTpCd = this.searchInvoiceType(invNo);
			//================================================================================================================================
			cancelInvoiceParamVO.setInvTpCd(invTpCd);
			
			if (!"M".equals(invTpCd)) {

				String purgedBkgFlg = dbDao.searchPurgedBkgFlg(invNo);
				
				if (StringUtils.isEmpty(purgedBkgFlg)) {
					chargeArgumentVO.setErrCode("DMT03024");
					message = "This invoice cannot cancel because this BKG was already purged. If you should cancel this invoice, please request BKG Re-instate via SR.";
					chargeArgumentVO.setErrMsg(message);
					chargeArgumentVOList.add(chargeArgumentVO);
					return chargeArgumentVOList;
				}
			}
			
			//================================================================================================================================
			boolean isArIf = false;
			if ("Y".equals(cancelInvoiceParamVO.getAutoArIfYn()) || StringUtils.isEmpty(cancelInvoiceParamVO.getAutoArIfYn())) {

				//checkARIF
				arIFCheckInvMn = dbDao.checkARIF(oldInvoiceNo, creOfcCd);
				
				if (arIFCheckInvMn != null && arIFCheckInvMn.getDmdtArIfCd() != null) {
					if ("Y".equals(arIFCheckInvMn.getDmdtArIfCd())) {
						isArIf = true;
					}
				}
			}
			//================================================================================================================================
			
			if (!isArIf) {
				dmtInvMnVO.setCrInvNo("");
				dmtInvMnVO.setDmdtInvStsCd("X");	
				dmtInvMnVO.setDmdtCxlRsnCd(cancelInvoiceParamVO.getIntgCdValCtnt());
				dmtInvMnVO.setCxlRmk(cancelInvoiceParamVO.getIntgCdValDpDesc()+":"+cancelInvoiceParamVO.getCxlRmk());//占싼딆�筌륅옙:+Remark
				dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				dmtInvMnVO.setOldDmdtInvNo(cancelInvoiceParamVO.getDmdtInvNo());
				dmtInvMnVO.setCreOfcCd(cancelInvoiceParamVO.getCreOfcCd());
   		 
				dbDao.modifyInvoiceMain(dmtInvMnVO);

				// searchInvoiceCharge
				chargeArgumentVOList = dbDao.searchInvoiceCharge(cancelInvoiceParamVO.getDmdtInvNo(), cancelInvoiceParamVO.getCreOfcCd());
				
				if (chargeArgumentVOList == null || chargeArgumentVOList.size() == 0) {
					chargeArgumentVOList = new ArrayList<ChargeArgumentVO>();
					ChargeArgumentVO tempVO = new ChargeArgumentVO();
					tempVO.setErrCode("");
					tempVO.setErrMsg("");
					tempVO.setCrInvNo("");
					chargeArgumentVOList.add(tempVO);
				}
				else {
					ChargeArgumentVO tempVO = chargeArgumentVOList.get(0);
					tempVO.setErrCode("");
					tempVO.setErrMsg("");
					tempVO.setCrInvNo("");
					chargeArgumentVOList.set(0, tempVO);
				}
			}
			else {
	            // AFT BKG 승인 및 승인취소로 인해서 Credit INV. 발행시에는 기존 INV. 의 OFC 를 사용함
	            String ofcCd =  ("Y".equals(cancelInvoiceParamVO.getAftBkgCxlYn())) ? creOfcCd : account.getOfc_cd();	
	            String cxlRmk = cancelInvoiceParamVO.getCxlRmk();
	            if (!"Y".equals(cancelInvoiceParamVO.getAftBkgCxlYn())) {
	            	cxlRmk = cancelInvoiceParamVO.getIntgCdValDpDesc().concat(":").concat(cxlRmk);
	            }
	            
                // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
                InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
                invoiceNoGenCondVO.setOfcCd(ofcCd);						// invoice 생성 office code
               	invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
                invoiceNoGenCondVO.setDmdtInvTpCd(invTpCd);	
                // [ Invoice No. 채번 로직 실행 ]==========================================================
                InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
                // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
                if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
	            	chargeArgumentVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
	            	chargeArgumentVO.setErrMsg(invoiceNoGenVO.getErrMsg());
	            	chargeArgumentVOList.add(chargeArgumentVO);
	            	return chargeArgumentVOList;                	
                }
                //=========================================================================================				
                invoice_no = invoiceNoGenVO.getDmdtInvNo();
                		
				dmtInvMnVO.setCrInvNo(invoice_no);
				dmtInvMnVO.setDmdtInvStsCd("X");	
				dmtInvMnVO.setDmdtCxlRsnCd(cancelInvoiceParamVO.getIntgCdValCtnt());
				dmtInvMnVO.setCxlRmk(cxlRmk);
				dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				dmtInvMnVO.setOldDmdtInvNo(cancelInvoiceParamVO.getDmdtInvNo());
				dmtInvMnVO.setCreOfcCd(cancelInvoiceParamVO.getCreOfcCd());
				dbDao.modifyInvoiceMain(dmtInvMnVO);
	            
	            dmtInvMnVO = new DmtInvMnVO();
	            dmtInvMnVO.setCrInvNo(cancelInvoiceParamVO.getDmdtInvNo());	//old invoice no( cr_inv_no )
				dmtInvMnVO.setDmdtCxlRsnCd(cancelInvoiceParamVO.getIntgCdValCtnt());
				dmtInvMnVO.setCxlRmk(cxlRmk);
	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
	            dmtInvMnVO.setCreOfcCd(ofcCd);
	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
	            dmtInvMnVO.setDmdtInvNo(invoice_no);								//new invoice no(create note)
	            dmtInvMnVO.setOldDmdtInvNo(cancelInvoiceParamVO.getDmdtInvNo());	//old invoice no(cancelled invoice)
	            dmtInvMnVO.setIdaTaxApplTm(cancelInvoiceParamVO.getIdaTaxApplTm());
	            dbDao.addCreditInvoiceMain(dmtInvMnVO);
 
	            // addCreditInvoiceDetail
	            dmtInvDtlVO = new DmtInvDtlVO();
	            dmtInvDtlVO.setDmdtInvNo(invoice_no);								//new invoice no(create note)		
	            dmtInvDtlVO.setCreOfcCd(ofcCd);
	            dmtInvDtlVO.setCreUsrId(account.getUsr_id());
	            dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
	            dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
	            dmtInvDtlVO.setOldDmtInvNo(cancelInvoiceParamVO.getDmdtInvNo());	//old invoice no(cancelled invoice)
	            dbDao.addCreditInvoiceDetail(dmtInvDtlVO);
 
	            // addCreditInvoiceRate
	            dmtInvRtVO = new DmtInvRtVO();
	            dmtInvRtVO.setDmdtInvNo(invoice_no);								//new invoice no(create note)
	            dmtInvRtVO.setOldDmtInvNo(cancelInvoiceParamVO.getDmdtInvNo());		//old invoice no(cancelled invoice)
	            dmtInvRtVO.setCreOfcCd(ofcCd);
	            dmtInvRtVO.setCreUsrId(account.getUsr_id());
	            dmtInvRtVO.setUpdUsrId(account.getUsr_id());
	            dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
	            dbDao.addCreditInvoiceRate(dmtInvRtVO);
	            
	            chargeArgumentVOList = dbDao.searchInvoiceCharge(cancelInvoiceParamVO.getDmdtInvNo(), cancelInvoiceParamVO.getCreOfcCd());

	            String err_cd = "";
				if (arIFCheckInvMn.getArIfOfcCd().equals(cancelInvoiceParamVO.getCreOfcCd())) {
					//messageArgumentVO.setErrCode("DMT03062");	//AR-IF�쒙옙占쎌빘苑�옙占폺reate note)
					err_cd = "DMT03062";
					message = new ErrorHandler("DMT03062").getUserMessage();
					message = JSPUtil.replace(message, "XXX123456", invoice_no);//Credit Note
					//messageArgumentVO.setErrMsg(message);
					//messageArgumentVO.setCrInvNo(invoice_no);	//AR-IF�쒙옙占쏙옙create note)
				}
				else {
					err_cd = "DMT03061";
					message = new ErrorHandler("DMT03061").getUserMessage();
					message = JSPUtil.replace(message, "XXXXX", arIFCheckInvMn.getArIfOfcCd());//A/R I/F Office Code
					message = JSPUtil.replace(message, "XXX123456", invoice_no);//Credit Note
				}
				
				if (chargeArgumentVOList == null || chargeArgumentVOList.size() == 0) {
					ChargeArgumentVO tempVO = new ChargeArgumentVO();
					tempVO.setErrCode(err_cd);
					tempVO.setErrMsg(message);
					tempVO.setCrInvNo(invoice_no);
					chargeArgumentVOList.add(tempVO);
				}
				else {
					ChargeArgumentVO tempVO = chargeArgumentVOList.get(0);
					tempVO.setErrCode(err_cd);
					tempVO.setErrMsg(message);
					tempVO.setCrInvNo(invoice_no);
					chargeArgumentVOList.set(0, tempVO);
				}
			}
		} 
		catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		return chargeArgumentVOList;
    }
    
    /**
    * [ Fax/E-mail Sending History ]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO
    * @return List<DmtFaxEmlSndHisVO>
    * @exception EventException
    */
    public List<DmtFaxEmlSndHisVO> searchFaxEmailHistory ( DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO ) throws EventException {
        try {
            return dbDao.searchFaxEmailHistory ( dmtFaxEmlSndHisParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     * Payer占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
     * 
     * @param PayerInfoParamVO payerInfoParamVO
     * @return PayerInformationVO
     * @throws EventException
     */
    public PayerInformationVO searchPayerInformation ( PayerInfoParamVO payerInfoParamVO) throws EventException {
    	PayerInformationVO rePayerInformationVO = new PayerInformationVO();
    	DmtPayrInfoVO reDmtPayrInfoVO 			= new DmtPayrInfoVO();
    	List<DmtPayrCntcPntVO> list 			= null;
    	String s_ofc_cd 	= "";
    	String s_cust_cd 	= "";
    	String s_payr_yn	= "";
    	String s_cust_gubun	= "";
    	String s_vndr_flg	= "";
    	String svr_id = "";
    	
    	try {
    		svr_id		= payerInfoParamVO.getSvrId();
    		s_ofc_cd 	= payerInfoParamVO.getSOfcCd();
    		s_cust_cd 	= payerInfoParamVO.getSCustCd();
    		s_cust_gubun= payerInfoParamVO.getSCustGubun();
    		if(s_cust_gubun.equals("1")) {
    			s_vndr_flg = "Y";
    		} else if(s_cust_gubun.equals("2")) {
    			s_vndr_flg = "N";
    		}
    		
    		//PayerInfo 占쎈베��揶쏉옙�붺몴占썼�怨좎돳占쎌뮆��
    		s_payr_yn	= dbDao.checkPayerInfo(s_ofc_cd, s_cust_cd, s_vndr_flg, svr_id);
    		
log.debug("\n #### s_ofc_cd ==> "+s_ofc_cd);    		
log.debug("\n #### s_cust_cd ==> "+s_cust_cd);    		
log.debug("\n #### s_payr_yn ==> "+s_payr_yn);    		
log.debug("\n #### s_cust_gubun ==> "+s_cust_gubun);    		
    		
    		reDmtPayrInfoVO = dbDao.searchPayerInformation(s_ofc_cd, s_cust_cd, s_payr_yn, s_cust_gubun, svr_id);
    		list 			= dbDao.searchPayerContactPoint(s_ofc_cd, s_cust_cd, s_cust_gubun, svr_id);
    		
    		//MDM CUSTOMER占쎈Ŋ苑�占쎈베�ョ몴占썼�怨좎돳 占쎌꼷肉�癰귣똻肉т빳占쎈뼄.
    		if(list == null || list.size() == 0) {
   				list = dbDao.searchPayerContactPointMdm(s_ofc_cd, s_cust_cd, s_cust_gubun);
    		}
    		
    		rePayerInformationVO.setDmtPayrInfoVO(reDmtPayrInfoVO);
    		rePayerInformationVO.setDmtPayrCntcPntVOList(list);
    		
    	} catch(DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
    	return rePayerInformationVO;
    }
    
	/**
	 * Payer Name 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerName ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
	/**
	 * Payer Address 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerAddress ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
	/**
	 * Payer Contact Point 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
    public List<DmtPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerContactPointName ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
	/**
	 * Payer Phone No 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerPhoneNo ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
    
	/**
	 * Payer Fax No 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerFaxNo ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Payer Email 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws EventException
	 */
	public List<DmtPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws EventException{
        try {
        	if(payerInfoParamVO.getSPodCd() == null || payerInfoParamVO.getSPodCd().equals("")){
        		payerInfoParamVO.setSPodCntCd("");
        	}else{
        		payerInfoParamVO.setSPodCntCd(payerInfoParamVO.getSPodCd().substring(0, 2));
        	}
            return dbDao.searchPayerEmail ( payerInfoParamVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Payer Info 占쎈베�ョ몴占쏙옙占쎌삢占쎌뮆��<br>
	 * 
	 * @param PayerInformationVO payerInformationVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePayerInformation(PayerInformationVO payerInformationVO, SignOnUserAccount account) throws EventException{
		DmtPayrInfoVO dmtPayrInfoVO = new DmtPayrInfoVO();
		List<DmtPayrCntcPntVO> dmtPayrCntcPntVOs = null;
		DmtPayrCntcPntVO dmtPayrCntcPntVO = new DmtPayrCntcPntVO();
		String s_payr_yn = "";
		try{
			dmtPayrInfoVO 		= payerInformationVO.getDmtPayrInfoVO();
			dmtPayrCntcPntVOs 	= payerInformationVO.getDmtPayrCntcPntVOs();
			
			//vendor占쏙옙野껋럩��
			if(dmtPayrInfoVO.getCustCd().length() == 6){
				dmtPayrInfoVO.setCustCntCd("00");
				dmtPayrInfoVO.setCustSeq(dmtPayrInfoVO.getCustCd());
				dmtPayrInfoVO.setDmdtPayrVndrFlg("Y");
			}else{
				dmtPayrInfoVO.setCustCntCd(dmtPayrInfoVO.getCustCd().substring(0, 2));
				dmtPayrInfoVO.setCustSeq(dmtPayrInfoVO.getCustCd().substring(2));
				dmtPayrInfoVO.setDmdtPayrVndrFlg("N");
			}
			
			//Payer Info 占쏙옙��
			s_payr_yn	= dbDao.checkPayerInfo(dmtPayrInfoVO.getOfcCd(), dmtPayrInfoVO.getCustCd(), dmtPayrInfoVO.getDmdtPayrVndrFlg(), "");
			
			dmtPayrInfoVO.setCreOfcCd(account.getOfc_cd());
			dmtPayrInfoVO.setCreUsrId(account.getUsr_id());
			dmtPayrInfoVO.setUpdOfcCd(account.getOfc_cd());
			dmtPayrInfoVO.setUpdUsrId(account.getUsr_id());
			
			
			//update
			if(s_payr_yn.equals("Y")){
				dbDao.modifyPayerInfomation(dmtPayrInfoVO);
			}else if(s_payr_yn.equals("N")){
				dbDao.addPayerInfomation(dmtPayrInfoVO);
			}
			
			//if(dmtPayrCntcPntVOs == null || dmtPayrCntcPntVOs.size() == 0) {
			//	
			//}else{
			if(dmtPayrCntcPntVOs != null && dmtPayrCntcPntVOs.size() > 0) {
			
				//Payer contact point 占쏙옙��
				for(int i = 0; i < dmtPayrCntcPntVOs.size(); i++) {
					dmtPayrCntcPntVO = (DmtPayrCntcPntVO)dmtPayrCntcPntVOs.get(i);
					
					if(dmtPayrCntcPntVO.getIbflag().equals("R"))
						continue;
					
					//s_payr_yn = dbDao.checkPayerContactPoint(dmtPayrInfoVO.getOfcCd(), dmtPayrInfoVO.getCustCd(), dmtPayrCntcPntVO.getCustCntcPntSeq(), dmtPayrInfoVO.getDmdtPayrVndrFlg());
					
					log.info("\nCustCntcPntSeq=["+i+"]=>"+dmtPayrCntcPntVO.getCustCntcPntSeq()+"<<");
					
					if(dmtPayrCntcPntVO.getCustCntcPntSeq() == null || dmtPayrCntcPntVO.getCustCntcPntSeq().equals("")){
						s_payr_yn = "N";
					}else{
						s_payr_yn = "Y";
					}
					log.info("\nIbflag=["+i+"]=>"+dmtPayrCntcPntVO.getIbflag()+"<<");
					log.info("\ns_payr_yn=["+i+"]=>"+s_payr_yn+"<<");
					
					dmtPayrCntcPntVO.setCreOfcCd(account.getOfc_cd());
					dmtPayrCntcPntVO.setCreUsrId(account.getUsr_id());
					dmtPayrCntcPntVO.setUpdOfcCd(account.getOfc_cd());
					dmtPayrCntcPntVO.setUpdUsrId(account.getUsr_id());
					
					//svr_id, cust_cd CHECK
					dmtPayrCntcPntVO.setSvrId(dmtPayrInfoVO.getSvrId());
					dmtPayrCntcPntVO.setCustCntCd(dmtPayrInfoVO.getCustCntCd());
					dmtPayrCntcPntVO.setCustSeq(dmtPayrInfoVO.getCustSeq());
					
					//dmdt_payr_cntc_pnt_nm
					dmtPayrCntcPntVO.setDmdtPayrCntcPntNm(dmtPayrCntcPntVO.getPayrCntcPntNm());
					
					///////////////////////////////////////////////////////////
					//占쎄낱源�筌ｋ똾寃�占쏙옙占쏙옙��占쎄낱源�옙占썲칰�뚯뒭占쏙옙�얜똻�쒎쳞占쏙옙占쎌젫 占쎌뮆��
					if(dmtPayrCntcPntVO.getIbflag().equals("D")){
						dbDao.removePayerContactPoint(dmtPayrCntcPntVO);
					}else{
						
						if(s_payr_yn.equals("Y")) {
							dbDao.modifyPayerContactPoint(dmtPayrCntcPntVO);
						}else if(s_payr_yn.equals("N")){
							dbDao.addPayerContactPoint(dmtPayrCntcPntVO);
						}
					}
				}
			}
			
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
	}
	
	
	/**
     * Finished占쏙옙Booking癰귨옙 Tariff Type癰귨옙 "SZPBB"癰귨옙Charge �④쑴沅쏉옙占쏙옙類ｋ궖�쒙옙鈺곌퀬�띰옙�뺣뼄.(Invoice Issue 占쏙옙鈺곌퀬��
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException {
        
    	InvoiceIssueMgtVO invoiceIssueMgtVO	= new InvoiceIssueMgtVO();
        List<InvoiceIssueVO> invoiceIssueList   = null;
        
        //List<VVDCheckDataVO> vVDCheckDataList   = null;
        //VVDNEtaVO vVDNEtaVO                     = new VVDNEtaVO();
        
        List<ChargeBookingInvoiceVO> chargeBookingInvoiceList = null;
        String curr_ofc_date = "";
        
        try {
        	curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());
        	
        	/*
            vVDCheckDataList = dbDao.searchVVDCheckData(issuedInvoiceParamVO);
            
            if(vVDCheckDataList != null && vVDCheckDataList.size() > 0) {
            	VVDCheckDataVO vVDCheckDataVO = vVDCheckDataList.get(0);
                vVDNEtaVO = dmtCalculationUtil.searchVVDNEta(vVDCheckDataVO.getBkgNo(), vVDCheckDataVO.getPolCd(), vVDCheckDataVO.getPodCd(), vVDCheckDataVO.getIoBnd());
                // modifyBookingContainerVVD
                dbDao.modifyBookingContainerVVD(vVDNEtaVO);
            }*/
            
            // searchChargeBookingInvoice
            chargeBookingInvoiceList = dbDao.searchChargeBookingInvoice(issuedInvoiceParamVO);
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
            
            if(chargeBookingInvoiceList != null && chargeBookingInvoiceList.size() > 0)
            	 chargeBookingInvoiceVO = chargeBookingInvoiceList.get(0);
            else {
            	//manualChargeContainerVO.setResultMsg("ChargeBookingInvoice 占쎈베��鈺곌퀬��占썬끇履�);
            	//return manualChargeContainerVO;
            	//throw new EventException("ChargeBookingInvoice 占쎈베��鈺곌퀬��占썬끇履�);
            	throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Billing"}).getMessage());
            }

            PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
            PayerNameVO rePayerNameVO = new PayerNameVO();
            
            //Payer揶쏉옙占쎈냱�ｏ옙占�
            if(chargeBookingInvoiceVO.getPayerCd() == null 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("") 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("00000000") 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("000000")) {
                chargeBookingInvoiceVO.setPayerCd("");
                chargeBookingInvoiceVO.setPayerNm("");
                
            }else{
                payerNameParamVO.setSCustCd(chargeBookingInvoiceVO.getPayerCd());
                
                if(chargeBookingInvoiceVO.getPayerCd().substring(0,2).equals("00")) {
                	payerNameParamVO.setSCustGubun("1");
                	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
                }else{
                	payerNameParamVO.setSCustGubun("2");
                	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
                }
                
                chargeBookingInvoiceVO.setPayerCd(rePayerNameVO.getCustCd());
                chargeBookingInvoiceVO.setPayerNm(rePayerNameVO.getCustName());
            }
            
                
            // set Invoice Cur
            if(chargeBookingInvoiceVO.getOfcCd().equals("XMNBS") && account.getUsr_id().equals("XMN0030") && account.getOfc_cd().equals("XMNSC")) {
                chargeBookingInvoiceVO.setInvCurrCd("HKD");
            }
            
            if(chargeBookingInvoiceVO.getOfcCd().equals("SZPSC") && account.getUsr_id().equals("MODC01") && account.getOfc_cd().equals("MACBA")) {
                chargeBookingInvoiceVO.setInvCurrCd("HKD");
            }
            
            List<BookingCustomerVO> bookingCustomerList = null;
            
            // searchBookingCustomer 
            BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
            BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
            
            inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
            
            // searchBookingCustomer 鈺곌퀬��
            bookingCustomerList = dbDao.searchBookingCustomer(inBookingCustomerVO);
            
            if(bookingCustomerList == null || bookingCustomerList.size() == 0) {
                chargeBookingInvoiceVO.setBkgCustCd("");
                chargeBookingInvoiceVO.setBkgCustNm("");
            }else{
                for( int i = 0 ; i < bookingCustomerList.size(); i++) {
                    bookingCustomerVO = (BookingCustomerVO)bookingCustomerList.get(i);
            
                    if(issuedInvoiceParamVO.getSDmdtTrfCd().equals("DMOF") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("DTOC") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("CTOC")) {
                        chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdS());
                        chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmS());
                    }else if(issuedInvoiceParamVO.getSDmdtTrfCd().equals("DMIF") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("DTIC") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("CTIC")) {
                        chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdC());
                        chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmC());
                        
                        if(bookingCustomerVO.getCustCdC() == null || bookingCustomerVO.getCustCdC().length() != 8) {
                            chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdN());
                            chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmN());
                        }
                    }
                }
            }
            // searchSheetOption
            SheetOptionVO iSheetOptionVO = new SheetOptionVO();
            iSheetOptionVO.setDmdtTrfCd(issuedInvoiceParamVO.getSDmdtTrfCd());
            iSheetOptionVO.setOfcCd(issuedInvoiceParamVO.getOfcCd());
            
            List<SheetOptionVO> listSheetOption = dbDao.searchSheetOption(iSheetOptionVO);
            
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(curr_ofc_date);//占쎄쑴�깍옙�깆쁽
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT �곗뮆��L/R
            } else {
                for(int i = 0; i < listSheetOption.size() ; i++) {
                	chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT �곗뮆��L/R
                    
                    if(listSheetOption.get(i).getDfltTaxRto() == null || listSheetOption.get(i).getDfltTaxRto().equals("")) {
                    	chargeBookingInvoiceVO.setTaxRto("0");
                    }else{
                    	chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    }
                    
                    //sheet Option占쏙옙Credit Term = 0 占쎈���
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//Due Date揶쏉옙"Issue Date"�쒙옙占쎌쥚源�옙�롢늺 Due Date=占쎄쑴�깍옙�깆쁽,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(curr_ofc_date);
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//Due Date揶쏉옙"*******"�쒙옙占쎌쥚源�옙�롢늺 Due Date: ********, Credit Term: �⑤벉媛�
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //sheet Option占쏙옙Credit Term > 0 占쎈���
                    }else if(!chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	String due_date = DateTime.addDays(curr_ofc_date, Integer.parseInt(chargeBookingInvoiceVO.getCrTermDys()));
                    	chargeBookingInvoiceVO.setDueDate(due_date);
                    }
                }
            }
            
            // searchARActualPayer(bookingNo, dmdtTrfCd)
            List<ARActualPayerVO> listARActualPayer = dbDao.searchARActualPayer(issuedInvoiceParamVO.getSBkgNo(), issuedInvoiceParamVO.getSDmdtTrfCd());
            
            if(listARActualPayer == null || listARActualPayer.size() == 0) {
                chargeBookingInvoiceVO.setActCustCd("");
                chargeBookingInvoiceVO.setActCustNm("");
            }else{
                for(int i = 0; i < listARActualPayer.size() ; i++) {
                    chargeBookingInvoiceVO.setActCustCd(listARActualPayer.get(i).getActCustCd());
                    chargeBookingInvoiceVO.setActCustNm(listARActualPayer.get(i).getActCustNm());
                }
            }
            if(chargeBookingInvoiceVO.getTruckerCd().equals("000000")) {
                chargeBookingInvoiceVO.setTruckerCd("");
                chargeBookingInvoiceVO.setTruckerNm("");
            }else{
                // searchServiceProviderName
            	VendorNameVO vendorNameVO = dbDao.searchServiceProviderName(chargeBookingInvoiceVO.getTruckerCd());
                
                chargeBookingInvoiceVO.setTruckerNm(vendorNameVO.getVndrNm());
            }

            // searchExchangeRate
            ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
            
            exchangeRateParmVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0,4));
            exchangeRateParmVO.setSkdVoyageNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
            exchangeRateParmVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8));
            exchangeRateParmVO.setIoBnd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
            exchangeRateParmVO.setPolLoc(chargeBookingInvoiceVO.getPolCd());
            exchangeRateParmVO.setPodLoc(chargeBookingInvoiceVO.getPodCd()); 
            exchangeRateParmVO.setFmCurCd(chargeBookingInvoiceVO.getChgCurrCd());
            exchangeRateParmVO.setToCurCd(chargeBookingInvoiceVO.getInvCurrCd());  
            exchangeRateParmVO.setOfcCd(chargeBookingInvoiceVO.getOfcCd());

            //Invoice
            double exchangeRate = 0;
            
            if(chargeBookingInvoiceVO.getInvCurrCd().equals(chargeBookingInvoiceVO.getChgCurrCd())) {
                exchangeRate = 1;
            }else{
                exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
            }
            
            //Double 占쏙옙占쎈슣�쏙옙占쏙옙�꾨릭 6占쎈Ŧ��占싼됥럫占쏙옙�쀯옙占쎈똻夷억옙占쏙옙占�
            chargeBookingInvoiceVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));
           
            
            double totAmt = 0;
            
            // Charge Grid 占쎄퀣�좑옙占썼�怨좎돳
            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
            
            //******************* Rate Detail  START *******************
            OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
            List<ChrgDtlVO> chrgDtlVOList = new ArrayList<ChrgDtlVO>();
            
            for(int i = 0 ; i< invoiceIssueList.size() ; i++) {
				InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
				
				// Rate Detail Grid 占쎄퀣�좑옙占썸뤃���占쎈챷��疫꿸퀡�ワ옙占쏙옙袁る맙.
				invoiceIssueVO.setRtDtlGrp(String.valueOf(i+1));
	            
	            overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
	            overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
	            overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
	            overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
	            overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
	            overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
	
	            //------------- DivOverDay 鈺곌퀬��-----------
	            OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
	
	            String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
	            
	            CalculationParmVO calculationParmVO = new CalculationParmVO();
	            calculationParmVO.setDcApplRate(trfAplyTpCd);
	            calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	            calculationParmVO.setFtDys(invoiceIssueVO.getFtDys());				// 2014.03.12
	            calculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd());	// 2014.03.12
	            calculationParmVO.setOrgFtOvrDys(invoiceIssueVO.getOrgFtOvrDys());	// 2014.03.12
	            
	            calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
	            
	            if(trfAplyTpCd.equals("G")) {
	            	// basicCalculation - Baisc Tariff
	                calculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
	                calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
	                calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
	                calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());
	                calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
	                calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	                calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	                calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
	                calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());			// 2014.03.12
	                if (!"".equals(invoiceIssueVO.getScRfaExptAplyDt())) {		// 2014.03.12
	                	calculationParmVO.setDmdtTrfAplyTpCd("B");				// 獄쎻뫕占쏙옙�곕쑓占쏙옙嚥≪뮇彛�占쎈슢揆占쏙옙�곕떽占� ("B" 占쎈Ŧ��"S"嚥∽옙占쏙퐡由곤쭖占쏙옙占�
		                calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());	// 2014.03.12
	                }
	            } else if(trfAplyTpCd.equals("B")) {
	            	// beforeCalculation - Before BKG Exception
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptMapgSeq());
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptVerSeq());
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaRqstDtlSeq());
	                calculationParmVO.setDarNo(invoiceIssueVO.getCntrTpszCd());
	                calculationParmVO.setDarNo(invoiceIssueVO.getFxFtOvrDys());
	                calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());	// 2014.03.12
	            } else if(trfAplyTpCd.equals("S")) {
	            	// scCalculation - SC Exception
	                calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
	                calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
	                calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
	                calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	                calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());	// 2014.03.12
	            }
	            
	            double invChgTotAmt = 0;
	            CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
	            
	            // Rate Detail 占쎈베��
	            List<ChrgDtlVO> chrgDtlVOs = calculationAMTVO.getChrgDtlVOS();
				
	            // Rate Detail 占쎈베�ュ첎占썼��곸삺占쏙옙野껋럩��-- START
				if(chrgDtlVOs != null && chrgDtlVOs.size() > 0) {
					for(int k=0; k < chrgDtlVOs.size(); k++) {
						ChrgDtlVO vo = chrgDtlVOs.get(k);
						vo.setRtCurCd(String.valueOf(i+1));	// Grid 占쎄퀣�좑옙占썸뤃���占쎈챷�㎪묾怨뺣뮟占쏙옙占쎄쑵釉� Group No. 占썬끉��
					}
					
					chrgDtlVOList.addAll(chrgDtlVOs);
					
					//Total Amt
	            	invChgTotAmt = NumberUtils.toDouble(calculationAMTVO.getTotal());
				}
				// Rate Detail 占쎈베�ュ첎占썼��곸삺占쏙옙野껋럩��-- END

                totAmt += invChgTotAmt;
            	
            	//inv_chg_tot, inv_bill_amt 占쏙옙��
            	invoiceIssueList.set(i, invoiceIssueVO);
				
            } // for - end
            
            invoiceIssueMgtVO.setChrgDtlVOs(chrgDtlVOList);
            
            totAmt = exchangeRate * totAmt;
            totAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totAmt);
			chargeBookingInvoiceVO.setTotAmt(JSPUtil.toDecimalFormat(totAmt, "#.##"));
			
			//Billing Amt
			double invChgAmt = 0;
			invChgAmt = exchangeRate * Double.parseDouble(chargeBookingInvoiceVO.getMnBilAmt());
			//invChgAmt = totAmt - dcAmt;

			invChgAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),invChgAmt);
			chargeBookingInvoiceVO.setInvChgAmt(JSPUtil.toDecimalFormat(invChgAmt, "#.##"));


			//D/C by Amt
			double dcAmt = 0;
			dcAmt = totAmt - invChgAmt;

			dcAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),dcAmt);
			chargeBookingInvoiceVO.setDcAmt(JSPUtil.toDecimalFormat(dcAmt, "#.##"));

            //Tax Amt
            double taxAmt = 0;
            double taxRto = Double.parseDouble(chargeBookingInvoiceVO.getTaxRto());

            //甕곗쥚�껓옙占쏙옙��늺
            if(account.getCnt_cd().equals("VN")) {
                taxAmt = (invChgAmt / (1 - taxRto * 0.01)) * (taxRto * 0.01);
            }else{
                taxAmt = (invChgAmt * (taxRto * 0.01)) ;
            }
            
            taxAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),taxAmt);
            chargeBookingInvoiceVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));

            //Payable Amt
            double invAmt = 0;
            invAmt = invChgAmt + taxAmt;

            invAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),invAmt);
            chargeBookingInvoiceVO.setInvAmt(JSPUtil.toDecimalFormat(invAmt, "#.##"));
            
            //******************* Rate Detail  END *******************
            
            
            //Invoice Data �λ뜃由곤옙占�
            chargeBookingInvoiceVO.setAftInvAdjAmt("0");
//            chargeBookingInvoiceVO.setDmdtInvNo("");
//            chargeBookingInvoiceVO.setCreDt("");
//            chargeBookingInvoiceVO.setCreOfcCd("");
//            chargeBookingInvoiceVO.setCreUsrNm("");
//            chargeBookingInvoiceVO.setUpdUsrId("");
//            chargeBookingInvoiceVO.setUpdUsrNm("");
//            chargeBookingInvoiceVO.setDmdtInvStsCd("");
//            chargeBookingInvoiceVO.setDmdtInvStsNm("");
//            chargeBookingInvoiceVO.setDmdtArIfCd("");
//            chargeBookingInvoiceVO.setArIfDt("");
//            chargeBookingInvoiceVO.setArIfOfcCd("");
//            chargeBookingInvoiceVO.setArIfUsrId("");
//            chargeBookingInvoiceVO.setArIfUsrNm("");
//            chargeBookingInvoiceVO.setCrInvNo("");
//            chargeBookingInvoiceVO.setInvRefNo("");
//            chargeBookingInvoiceVO.setInvRmk("");
//            chargeBookingInvoiceVO.setInvRmk1("");
//            chargeBookingInvoiceVO.setInvRmk2("");
//            chargeBookingInvoiceVO.setDmdtPayrCntcPntNm("");
//            chargeBookingInvoiceVO.setPayrCntcPntPhnNo("");
//            chargeBookingInvoiceVO.setPayrCntcPntFaxNo("");
//            chargeBookingInvoiceVO.setPayrCntcPntEml("");
//            chargeBookingInvoiceVO.setOverDay("");
//            chargeBookingInvoiceVO.setMnlInvRmk("");
//            chargeBookingInvoiceVO.setCrArYn("");
//            chargeBookingInvoiceVO.setVndrSeq("");
//            chargeBookingInvoiceVO.setVndrNm("");

            // Mgt Setting
            invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
            invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);

        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Billing"}).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Billing"}).getMessage());	
        }
        return invoiceIssueMgtVO;
    }
    
    
    /**
     * [Invoice Create & Issue]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�Invoice Issue 占쏙옙<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
		InvoiceIssueMgtVO invoiceIssueMgtVO		= new InvoiceIssueMgtVO();
		List<InvoiceIssueVO> invoiceIssueList	= null;
		
		try {
			// searchChargeBookingInvoice
			ChargeBookingInvoiceVO chargeBookingInvoiceVO = dbDao.searchBookingInvoice(issuedInvoiceParamVO);
			
			PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
			PayerNameVO rePayerNameVO = new PayerNameVO();
			
			payerNameParamVO.setSCustCd(chargeBookingInvoiceVO.getPayerCd());
			
            if(chargeBookingInvoiceVO.getPayerCd().substring(0,2).equals("00")) {
            	payerNameParamVO.setSCustGubun("1");
            	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
            }else{
            	payerNameParamVO.setSCustGubun("2");
            	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
            }
//    			if(chargeBookingInvoiceVO.getPayerCd().length() == 6) {
//    				payerNameParamVO.setSCustGubun("1");
//    				rePayerNameVO = dbDaoCommon.searchPayerName(payerNameParamVO);
//    			}else if(chargeBookingInvoiceVO.getPayerCd().length() > 6){
//    				payerNameParamVO.setSCustGubun("2");
//    				rePayerNameVO = dbDaoCommon.searchPayerName(payerNameParamVO);
//    			}
			
			chargeBookingInvoiceVO.setPayerCd(rePayerNameVO.getCustCd());
			chargeBookingInvoiceVO.setPayerNm(rePayerNameVO.getCustName());
				
			List<BookingCustomerVO> bookingCustomerList = null;
			
			// searchBookingCustomer 
			BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
			BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
			
			inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
			
			// searchBookingCustomer 鈺곌퀬��
			bookingCustomerList = dbDao.searchBookingCustomer(inBookingCustomerVO);
			
			if(bookingCustomerList == null || bookingCustomerList.size() == 0) {
				chargeBookingInvoiceVO.setBkgCustCd("");
				chargeBookingInvoiceVO.setBkgCustNm("");
			}else{
				for( int i = 0 ; i < bookingCustomerList.size(); i++) {
					bookingCustomerVO = (BookingCustomerVO)bookingCustomerList.get(i);
			
					if(issuedInvoiceParamVO.getSDmdtTrfCd().equals("DMOF") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("DTOC") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("CTOC")) {
						chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdS());
						chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmS());
					}else if(issuedInvoiceParamVO.getSDmdtTrfCd().equals("DMIF") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("DTIC") || issuedInvoiceParamVO.getSDmdtTrfCd().equals("CTIC")) {
						chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdC());
						chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmC());
						
						if(bookingCustomerVO.getCustCdC() == null || bookingCustomerVO.getCustCdC().length() != 8) {
							chargeBookingInvoiceVO.setBkgCustCd(bookingCustomerVO.getCustCdN());
							chargeBookingInvoiceVO.setBkgCustNm(bookingCustomerVO.getCustNmN());
						}
					}
				}
			}
			// searchSheetOption
			SheetOptionVO iSheetOptionVO = new SheetOptionVO();
			iSheetOptionVO.setDmdtTrfCd(issuedInvoiceParamVO.getSDmdtTrfCd());
			iSheetOptionVO.setOfcCd(issuedInvoiceParamVO.getOfcCd());
			
			List<SheetOptionVO> listSheetOption = dbDao.searchSheetOption(iSheetOptionVO);

            // 鈺곕똻�깍옙�륅옙 占쎈봿�앾쭖占폛ue Date = 占쎄쑴�깍옙�깆쁽, Credit Term = 0 占쎌눖以�占썬끉�숋옙占�
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("0");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(chargeBookingInvoiceVO.getIssueDay());//Issue占쎌눘��
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT �곗뮆��L/R
            }else{
                for(int i = 0; i < listSheetOption.size() ; i++) {
                    chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT �곗뮆��L/R
                    
                    //sheet Option占쏙옙Credit Term = 0 占쎈���
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//Due Date揶쏉옙"Issue Date"�쒙옙占쎌쥚源�옙�롢늺 Due Date=占쎄쑴�깍옙�깆쁽,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(chargeBookingInvoiceVO.getIssueDay());
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//Due Date揶쏉옙"*******"�쒙옙占쎌쥚源�옙�롢늺 Due Date: ********, Credit Term: �⑤벉媛�
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //sheet Option占쏙옙Credit Term > 0 占쎈���
                    }else if(!chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	String due_date = DateTime.addDays(chargeBookingInvoiceVO.getIssueDay(), Integer.parseInt(chargeBookingInvoiceVO.getCrTermDys()));
                    	chargeBookingInvoiceVO.setDueDate(due_date);
                    }
                }
            }
			
//    			if(listSheetOption == null || listSheetOption.size() == 0) {
//    				chargeBookingInvoiceVO.setIssDtPrnFlg("");
//    				chargeBookingInvoiceVO.setCrTermDys("");
//    				chargeBookingInvoiceVO.setTaxRto("0");
//    				chargeBookingInvoiceVO.setBilToLocDivCd("");
//    			}else{
//    				for(int i = 0; i < listSheetOption.size() ; i++) {
//    					chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
//    					chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
//    					chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
//    					chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());
//    				}
//    			}
			// searchARActualPayer(bookingNo)
			List<ARActualPayerVO> listARActualPayer = dbDao.searchARActualPayer(issuedInvoiceParamVO.getSBkgNo(), issuedInvoiceParamVO.getSDmdtTrfCd());
			
			if(listARActualPayer == null || listARActualPayer.size() == 0) {
				chargeBookingInvoiceVO.setActCustCd("");
				chargeBookingInvoiceVO.setActCustNm("");
			}else{
				for(int i = 0; i < listARActualPayer.size() ; i++) {
					chargeBookingInvoiceVO.setActCustCd(listARActualPayer.get(i).getActCustCd());
					chargeBookingInvoiceVO.setActCustNm(listARActualPayer.get(i).getActCustNm());
				}
			}
			
			if(chargeBookingInvoiceVO.getTruckerCd().equals("000000")) {
				chargeBookingInvoiceVO.setTruckerCd("");
				chargeBookingInvoiceVO.setTruckerNm("");
			} else {
				// searchServiceProviderName
				VendorNameVO vendorNameVO = dbDao.searchServiceProviderName(chargeBookingInvoiceVO.getTruckerCd());
				
				chargeBookingInvoiceVO.setTruckerNm(vendorNameVO.getVndrNm());
			}
			
			//INV OVER DAY CALC
			int inv_over_day = 0;
			String issue_day 	= chargeBookingInvoiceVO.getIssueDay();	//invoice create date
			String today 		= DateTime.getShortDateString();		//占쎄쑴�깍옙�깆쁽
			String ar_if_day	= JSPUtil.replace(chargeBookingInvoiceVO.getArIfDt(), "-","");

			if(ar_if_day == null || ar_if_day.equals("")) {
				inv_over_day = DateTime.daysBetween(issue_day, today);
			}else{
				if(DateTime.daysBetween(issue_day, ar_if_day) > 0) {
					inv_over_day = DateTime.daysBetween(issue_day, today);
				}else{
					inv_over_day = DateTime.daysBetween(issue_day, ar_if_day);
				}
			}
			
			chargeBookingInvoiceVO.setOverDay(String.valueOf(inv_over_day));
			
			// searchChargeBookingInvoiceDetail
			invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
			
			//double tot_amt = 0;
			double inv_dc_amt = 0;
			double inv_xch_rt = Double.parseDouble(chargeBookingInvoiceVO.getInvXchRt());
			double chg_dc_amt = 0;

			inv_dc_amt = inv_xch_rt * Double.parseDouble(chargeBookingInvoiceVO.getDcAmt());
			inv_dc_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), inv_dc_amt);

			//tot_amt = inv_dc_amt + Double.parseDouble(chargeBookingInvoiceVO.getInvChgAmt());
			//tot_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), tot_amt);
			//chargeBookingInvoiceVO.setTotAmt(JSPUtil.toDecimalFormat(tot_amt, "#.##"));
			
			chargeBookingInvoiceVO.setTotAmt(chargeBookingInvoiceVO.getMnBilAmt());
			
			//chg_dc_amt 鈺곌퀬��
			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
				chg_dc_amt += Double.parseDouble(invoiceIssueList.get(i).getAftExptDcAmt());
			}
			chg_dc_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), chg_dc_amt);
			chargeBookingInvoiceVO.setChgDcAmt(JSPUtil.toDecimalFormat(chg_dc_amt, "#.##"));
			
			
			// Invoice Rate Detail �쒙옙鈺곌퀬�띰옙�뺣뼄.	 
       	 	List<DmtInvRtVO> dmtInvRtVOs = dbDao.searchManualInvoiceRate(issuedInvoiceParamVO.getSInvoiceNo());
			
       	 	if(dmtInvRtVOs != null && dmtInvRtVOs.size() > 0) {
       	 		List<ChrgDtlVO> chrgDtlVOList = new ArrayList<ChrgDtlVO>();
       	 		
       	 		for(int i=0; i < dmtInvRtVOs.size(); i++) {
       	 			DmtInvRtVO dmtInvRtVO = dmtInvRtVOs.get(i);
       	 			ChrgDtlVO chrgDtlVO = new ChrgDtlVO();
       	 			
       	 			chrgDtlVO.setRtOver(dmtInvRtVO.getFtOvrDys());
       	 			chrgDtlVO.setRtUnder(dmtInvRtVO.getFtUndDys());
       	 			chrgDtlVO.setRtRate(dmtInvRtVO.getInvRtAmt());
       	 			chrgDtlVO.setRtDay(dmtInvRtVO.getRtOvrDys());
       	 			chrgDtlVO.setRtChrg(dmtInvRtVO.getRtOvrChgAmt());
       	 			chrgDtlVO.setRtCurCd(dmtInvRtVO.getInvDtlSeq());
       	 			
       	 			chrgDtlVOList.add(chrgDtlVO);
       	 		}
       	 		
       	 		invoiceIssueMgtVO.setChrgDtlVOs(chrgDtlVOList);
       	 	}
       	 	
       	 	// Mgt Setting
			invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
			invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);
       	 	

		} catch(DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Billing"}).getMessage());	
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Billing"}).getMessage());	
		}
		return invoiceIssueMgtVO;    	   
    }
    
    
    /**
     * [Invoice]占쏙옙[ISSUE] 占썩뫖�뀐옙占�br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoiceBySZPBB(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException {
        ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
        List<InvoiceIssueVO> invoiceIssueList = null;
        List<ChrgDtlVO> chrgDtlList = null;
        
        DmtInvNoVO dmtInvNoVO = new DmtInvNoVO();
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        String invoice_no = "";
        String curr_ofc_date = "";
        
        try{
        	curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());
            chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
		   //2011.06.03 BL NO 筌ｋ똾寃�by KHH
		   //BL NO揶쏉옙占쎈끏��野껋럩��BKG占쏙옙BL NO嚥∽옙占쏙옙猿쒙옙占�
		    if(chargeBookingInvoiceVO.getBlNo().equals("")){
		       String bl_no = dbDao.searchBKGBlNo(chargeBookingInvoiceVO.getBkgNo());
		       if(bl_no == null || bl_no.equals("")) {
		    	    dmtInvMnVO.setErrCode("DMT01152");
		          	 log.error("\n BC bkg_no >>>>"+chargeBookingInvoiceVO.getBkgNo()+"<<<<");
              		 log.error("\n BC DMT01152 ERROR [There is no B/L No.]");
		          	 return dmtInvMnVO;
		        }else{
		        	chargeBookingInvoiceVO.setBlNo(bl_no);
		        }
		   }
           
            // [ Invoice No. 채번 로직 실행을 위한 매개변수 설정 ]======================================
            InvoiceNoGenCondVO invoiceNoGenCondVO = new InvoiceNoGenCondVO();
            invoiceNoGenCondVO.setOfcCd(account.getOfc_cd());		// invoice 생성 office code
            invoiceNoGenCondVO.setUsrId(account.getUsr_id());		// invoice 생성 사용자 id
            invoiceNoGenCondVO.setDmdtInvTpCd("M");					// manual invoice
            // [ Invoice No. 채번 로직 실행 ]==========================================================
            InvoiceNoGenVO invoiceNoGenVO = this.generateInvoiceNo(invoiceNoGenCondVO);
            // [ Invoice No. 채번 로직 실행 후 처리로직 ]==============================================
            if (StringUtils.isNotEmpty(invoiceNoGenVO.getErrMsgCd())) {
            	dmtInvMnVO.setErrCode(invoiceNoGenVO.getErrMsgCd());
            	return dmtInvMnVO;
            }
            //=========================================================================================		    
            invoice_no = invoiceNoGenVO.getDmdtInvNo();
		    
            // addInvoiceMain
            dmtInvMnVO.setDmdtInvNo(invoice_no);
            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
            dmtInvMnVO.setDmdtTrfCd(chargeBookingInvoiceVO.getDmdtTrfCd());
            dmtInvMnVO.setIoBndCd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2, 3));//dmif
            dmtInvMnVO.setDmdtChgTpCd(chargeBookingInvoiceVO.getChgType());
            dmtInvMnVO.setMnlInpFlg("Y");
            dmtInvMnVO.setMnlInvSndFlg("Y");
            dmtInvMnVO.setMnlInvRmk(chargeBookingInvoiceVO.getMnlInvRmk());
            dmtInvMnVO.setDmdtMnlInvRsnCd("SCM");
            dmtInvMnVO.setBkgNo(chargeBookingInvoiceVO.getBkgNo());
            dmtInvMnVO.setBlNo(chargeBookingInvoiceVO.getBlNo());
            
            //VslCd = HJXX, HJYY, HJZZ 占쏙옙野껋럩���⑤벏�삼옙占쎄컧嚥∽옙癰귨옙�싷옙占폚FDR+YYMM+E)
            String vslCd = chargeBookingInvoiceVO.getVvdCd().substring(0,4);
            if(vslCd.equals("HJXX") || vslCd.equals("HJYY") || vslCd.equals("HJZZ")) {
                dmtInvMnVO.setVslCd("CFDR");
                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
                dmtInvMnVO.setSkdDirCd("E");
            } else {
                dmtInvMnVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0,4));
                dmtInvMnVO.setSkdVoyNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
                dmtInvMnVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8));
            }
            
            dmtInvMnVO.setDmdtPayrTpCd("");
            
            //VENDOR 占쏙옙野껋럩��
        	if(chargeBookingInvoiceVO.getPayerCd().length() <= 6) {
                dmtInvMnVO.setActPayrCntCd("00");
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd());
                
                //cust
                dmtInvMnVO.setCustCntCd("00");
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd());
           	//CUSTOMER 占쏙옙野껋럩��
        	}else{
                dmtInvMnVO.setActPayrCntCd(chargeBookingInvoiceVO.getPayerCd().substring(0, 2));
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd().substring(2));
                
                //cust
                dmtInvMnVO.setCustCntCd(chargeBookingInvoiceVO.getPayerCd().substring(0, 2));
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd().substring(2));
        	}
           
            
            dmtInvMnVO.setDmdtPayrCntcPntNm(JSPUtil.getNull(chargeBookingInvoiceVO.getDmdtPayrCntcPntNm()));
            dmtInvMnVO.setCustCntcPntSeq(JSPUtil.getNull(chargeBookingInvoiceVO.getCustCntcPntSeq()));
            dmtInvMnVO.setPorCd(chargeBookingInvoiceVO.getPorCd());
            dmtInvMnVO.setPolCd(chargeBookingInvoiceVO.getPolCd());
            dmtInvMnVO.setPodCd(chargeBookingInvoiceVO.getPodCd());
            dmtInvMnVO.setDelCd(chargeBookingInvoiceVO.getDelCd());
            dmtInvMnVO.setScNo(chargeBookingInvoiceVO.getScNo());
            dmtInvMnVO.setRfaNo(chargeBookingInvoiceVO.getRfaNo());
            dmtInvMnVO.setChgCurrCd(chargeBookingInvoiceVO.getChgCurrCd());
            dmtInvMnVO.setOrgChgAmt(chargeBookingInvoiceVO.getMnBilAmt());
            dmtInvMnVO.setDmdtExptAmt(chargeBookingInvoiceVO.getDmdtExptAmt());
            dmtInvMnVO.setDcAmt(chargeBookingInvoiceVO.getDcAmt());
            dmtInvMnVO.setBilAmt(chargeBookingInvoiceVO.getTotAmt());	//Manual Invoice占쏙옙占쎌늿�わ옙占썸에�뽰춦 占쎄낯��
            dmtInvMnVO.setBkgCntrQty(chargeBookingInvoiceVO.getCntrCnt());
            dmtInvMnVO.setInvCurrCd(chargeBookingInvoiceVO.getInvCurrCd());
            dmtInvMnVO.setInvXchRt(chargeBookingInvoiceVO.getInvXchRt());
            dmtInvMnVO.setInvChgAmt(chargeBookingInvoiceVO.getInvChgAmt());
            dmtInvMnVO.setTaxRto(chargeBookingInvoiceVO.getTaxRto());
            dmtInvMnVO.setTaxAmt(chargeBookingInvoiceVO.getTaxAmt());
            dmtInvMnVO.setInvAmt(chargeBookingInvoiceVO.getInvAmt());
            dmtInvMnVO.setAftExptAproNo("");
            dmtInvMnVO.setAftInvAdjAmt(chargeBookingInvoiceVO.getAftInvAdjAmt());
            dmtInvMnVO.setCrInvNo("");
            dmtInvMnVO.setInvRmk(chargeBookingInvoiceVO.getInvRmk());
            dmtInvMnVO.setDmdtArIfCd("N");
            dmtInvMnVO.setArIfNo("");
            dmtInvMnVO.setArIfDt("");
            dmtInvMnVO.setArIfUsrId("");
            dmtInvMnVO.setArIfOfcCd("");
            dmtInvMnVO.setDmdtInvStsCd("I");
            dmtInvMnVO.setDmdtCxlRsnCd("");
            dmtInvMnVO.setCxlRmk("");
            dmtInvMnVO.setInvHldRsnCd("");
            dmtInvMnVO.setInvHldRmk("");
            dmtInvMnVO.setInvPrtFlg("");
            dmtInvMnVO.setInvRefNo(chargeBookingInvoiceVO.getInvRefNo());
            dmtInvMnVO.setCreUsrId(account.getUsr_id());
            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
            dmtInvMnVO.setNtcKntCd(chargeBookingInvoiceVO.getNtcKntCd());
            dmtInvMnVO.setInvRmk1(chargeBookingInvoiceVO.getInvRmk1());
            dmtInvMnVO.setInvRmk2(chargeBookingInvoiceVO.getInvRmk2());
            dmtInvMnVO.setVndrSeq(chargeBookingInvoiceVO.getVndrSeq());
            dmtInvMnVO.setNtcKntCd(chargeBookingInvoiceVO.getNtcKntCd());
            dmtInvMnVO.setCaller("4016");
            
            if(!chargeBookingInvoiceVO.getRd().equals("/")) {
	            dmtInvMnVO.setRcvTermCd(chargeBookingInvoiceVO.getRd().substring(0, 1)); // Y/Y
	            dmtInvMnVO.setDeTermCd(chargeBookingInvoiceVO.getRd().substring(2));
            }
            
            dbDao.addInvoiceMain(dmtInvMnVO);
            
            invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            
            for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
            	InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
            	int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
	            DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
	            
	            dmtInvDtlVO.setDmdtInvNo(invoice_no);
	            dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
	            dmtInvDtlVO.setInvDtlSeq(String.valueOf(inv_dtl_seq));
	            dmtInvDtlVO.setSvrId(invoiceIssueParam.getSvrId());
	            dmtInvDtlVO.setCntrNo(invoiceIssueParam.getCntrNo());
	            dmtInvDtlVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
	            dmtInvDtlVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
	            dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
	            dmtInvDtlVO.setChgSeq(invoiceIssueParam.getChgSeq());
	            dmtInvDtlVO.setCntrTpszCd(invoiceIssueParam.getCntrTpszCd());
	            dmtInvDtlVO.setFmMvmtDt(invoiceIssueParam.getFmMvmtDt());
	            dmtInvDtlVO.setToMvmtDt(invoiceIssueParam.getToMvmtDt());
	            dmtInvDtlVO.setFtDys(invoiceIssueParam.getFtDys());
	            dmtInvDtlVO.setFtCmncDt(invoiceIssueParam.getFtCmncDt());
	            dmtInvDtlVO.setFtEndDt(invoiceIssueParam.getFtEndDt());
	            dmtInvDtlVO.setFxFtOvrDys(invoiceIssueParam.getFxFtOvrDys());
	            dmtInvDtlVO.setOrgChgAmt("0");
	            dmtInvDtlVO.setScRfaExptAmt(invoiceIssueParam.getExptAmt());
	            dmtInvDtlVO.setAftExptDcAmt(invoiceIssueParam.getAftExptDcAmt());
	            dmtInvDtlVO.setBilAmt("0");
	            dmtInvDtlVO.setCntrInvAmt("0");
	            dmtInvDtlVO.setTaxRto("0");
	            dmtInvDtlVO.setTaxAmt("0");
	            dmtInvDtlVO.setInvPrtFlg("");
	            dmtInvDtlVO.setCreUsrId(account.getUsr_id());
	            dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
	            dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());	            
	            
	            log.debug("============dmdt_inv_dtl=================================");
	            log.debug("[dmdt_inv_no]"+dmtInvDtlVO.getDmdtInvNo());
	            log.debug("[cre_ofc_cd]"+dmtInvDtlVO.getCreOfcCd());
	            log.debug("[inv_dtl_seq]"+dmtInvDtlVO.getInvDtlSeq());
	            dbDao.addInvoiceDetail(dmtInvDtlVO);
	            
	            chrgDtlList = invoiceIssueMgtVO.getChrgDtlVOs();
	            
	            int cnt = 0;
	            
	            for(int j = 0 ; j < chrgDtlList.size() ; j++) {
	            	ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlList.get(j);
		            if(invoiceIssueParam.getRtDtlGrp().equals(chrgDtlVO.getRtCurCd())) {
		            	DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
		            	
		            	cnt++;

	                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
	                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
	                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
	                    dmtInvRtVO.setInvRtSeq(String.valueOf(cnt));
	                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
	                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
	                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
	                    dmtInvRtVO.setBzcDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());
	                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
	                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
	                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
	                    dmtInvRtVO.setInvRtAmt(chrgDtlVO.getRtRate());
	                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
	                    dmtInvRtVO.setRtOvrChgAmt(chrgDtlVO.getRtChrg());
	                    dmtInvRtVO.setBzcCurrCd(chargeBookingInvoiceVO.getChgCurrCd());
	                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
	                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
	                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
	                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
	                    
			            log.debug("============dmdt_inv_rt=================================");
	                    log.debug("[dmdt_inv_no]"+dmtInvRtVO.getDmdtInvNo());
	                    log.debug("[cre_ofc_cd]"+dmtInvRtVO.getCreOfcCd());
	                    log.debug("[inv_dtl_seq]"+dmtInvRtVO.getInvDtlSeq());
	                    log.debug("[inv_rt_seq]"+dmtInvRtVO.getInvRtSeq());
			            log.debug("============dmdt_inv_rt=================================");
			            
	                    dbDao.addInvoiceRate(dmtInvRtVO);		            	
		            }else{
		            	continue;
		            }
	            }
            
            }
            
            dmtInvMnVO.setErrCode("DMT03064");//占쎄퉫�э쭖遺용뻻筌욑옙
            
            return dmtInvMnVO;
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003", new String[]{"Manual Billing"}).getMessage());
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00003", new String[]{"Manual Billing"}).getMessage());	
        }
    }
    
    /**
     * [AR Interface no]占쏙옙占쎄쑬�뽳옙占쏙옙�곸뒠占쏙옙[占쏙옙��占쎌뮆��
     * @param SignOnUserAccount account
     * @param String arIfNo
     * @param String invoiceNo
     * @param String creOfcCd
     * @throws EventException
     */
    public void modifyARInterface(SignOnUserAccount account, String arIfNo, String invoiceNo, String creOfcCd) throws EventException{
    	try{
    		dbDao.modifyARInterface(arIfNo, account.getOfc_cd(), account.getUsr_id(), invoiceNo, creOfcCd);
        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    }

    /**
     * [AR Interface]占쏙옙占쎄쑬�뽳옙占쏙옙�곸뒠占쏙옙[鈺곌퀬��占쎌뮆��
     * @param ARInterfaceCreationCondVO condVO
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
    public ARInterfaceCreationVO searchARInterfaceInvoice(ARInterfaceCreationCondVO condVO) throws EventException {
    	ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
    	InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
    	List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>() ;
    	List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>() ;
    	
    	List<InterfaceChargeCalculationVO> list = null;
    	
    	String chg_seq 	 = "";
    	String arOfcCd = "";
    	
    	try {
    		invArIfMnVO 	= dbDao.searchInterfaceInvoice(condVO.getUsrOfcCd(), condVO.getDmdtInvNo(), condVO.getCreOfcCd());		
    		invArIfCntrVOs	= dbDao.searchInterfaceContainer(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
    		
    		//---- OFC_TRNS_FLG �곕떽占�
        	IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
    		issuedInvoiceParamVO.setSInvoiceNo(condVO.getDmdtInvNo());
    		issuedInvoiceParamVO.setOfcCd(condVO.getCreOfcCd());

        	String ofc_trns_flg = "N";
    		
        	List<InvoiceIssueVO> invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
    		if (invoiceIssueList != null && invoiceIssueList.size() > 0) {
    			ofc_trns_flg = invoiceIssueList.get(0).getOfcTrnsFlg();
    		}
    		invArIfMnVO.setOfcTrnsFlg(ofc_trns_flg);
    		//-------------------------------------
    		
			// [ invoice 유형 조회 ]==========================================================================================================
			// invoice 가 인도지역에서 발행된 경우, 신규세법적용으로 인해서 invoice no. 체계가 달라져 invoice 유형을 가져오는 방법이 달라짐.
			//================================================================================================================================			
    		String invTpCd = this.searchInvoiceType(condVO.getDmdtInvNo());
			//================================================================================================================================
    		
    		//1. Manual Invoice
    		if ("M".equals(invTpCd)) {
    			String tempValue = dbDao.checkDmtInvDtl(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
    			if (!"Y".equals(tempValue)) {
    				InvArIfChgVO invArIfChgAddVO = dbDao.searchInterfaceManualCharge(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
    				invArIfChgVOs.add(invArIfChgAddVO);
    				invArIfCntrVOs = dbDao.searchInterfaceManualContainer(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
    			} 
    			else {
    				invArIfChgVOs = dbDao.searchInterfaceCharge(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
    			}
    			
        		//-- Manual Invoice 占쎌눖釉�Discount揶쏅���鈺곕똻�깍옙�롢늺 占쏙옙餓κ쑴��占쏙옙占쎌빘苑�占쎌꼷肉�AR-IF 占쎌뮉沅볩옙占�BIL_AMT - INV_CHG_AMT = 0)
    			String[] r_data = dbDao.checkManualARIFAmt(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
    			double d_amt = Double.parseDouble(r_data[0]);
    			if (d_amt != 0) {
    				InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
    				
    				invArIfChgVO.setSrcIfDt("");
    				invArIfChgVO.setSrcIfSeq("");
    				invArIfChgVO.setChgSeq(String.valueOf(invArIfChgVOs.size() + 1));
    				invArIfChgVO.setCurrCd(r_data[1]);
    				invArIfChgVO.setChgCd(invArIfChgVOs.get(0).getChgCd());
    				invArIfChgVO.setPerTpCd(invArIfChgVOs.get(0).getPerTpCd());
    				
    				d_amt 		= dmtCalculationUtil.trimCurrencyAmount(r_data[1], d_amt);	//trf_rt_amt 疫뀀뜆釉�筌ｌ꼶��curr_cd)
					invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(d_amt, "#.##"));
					invArIfChgVO.setRatAsCntrQty("1");
					invArIfChgVO.setChgAmt(JSPUtil.toDecimalFormat(d_amt * -1, "#.##"));
					invArIfChgVO.setTrfNo(invArIfChgVOs.get(0).getTrfNo());
					invArIfChgVO.setTvaFlg(invArIfChgVOs.get(0).getTvaFlg());
                    invArIfChgVO.setSbcFlg(invArIfChgVOs.get(0).getSbcFlg());
					invArIfChgVO.setCreUsrId(invArIfChgVOs.get(0).getCreUsrId());
					invArIfChgVO.setCreDt(invArIfChgVOs.get(0).getCreDt());
					invArIfChgVO.setUpdUsrId(invArIfChgVOs.get(0).getUpdUsrId());
					invArIfChgVO.setUpdDt(invArIfChgVOs.get(0).getUpdDt());
		       
					invArIfChgVOs.add(invArIfChgVO);
    			}
    		} 
    		else {
    			arOfcCd = dbDao.searchAROfficeCd(condVO.getUsrOfcCd());
    			
    			//LEHBB占쎈���dmtCalculationUtil揶쏅���鈺곌퀬�띰옙�뤿연 RT�쒙옙占쎌빘苑�옙�뺣뼄.
    			if (!"LEHSC".equals(arOfcCd)) {
    				
    				//2010.07.23 INVOICE_STATUS揶쏉옙I占쎈���OVER DAY揶쏉옙0 占쎈���AR-IF�쒙옙占쎌꼷占�占쎈봾�쀯옙占�
    				//			 INVOICE_STATUS揶쏉옙C占쎈���OVER DAY揶쏉옙0 占쏙옙CHARGE�쒙옙占쎌뮇�낉옙�랁� AR-IF�쒙옙占쎌뮆��
    				if ("Y".equals(condVO.getCrInvFlg())) {
        				invArIfChgVOs = dbDao.searchInterfaceChargeCreateNoteByInvoiceDetail(condVO.getDmdtInvNo(), condVO.getCreOfcCd(), condVO.getIdaTaxApplTm());
    				} 
    				else {
   						invArIfChgVOs = dbDao.searchInterfaceChargeByInvoiceDetail(condVO.getDmdtInvNo(), condVO.getCreOfcCd(), condVO.getIdaTaxApplTm());
    				}
    				
    				if (invArIfChgVOs != null && invArIfChgVOs.size() > 0) {
    					InvArIfChgVO invArIfChgVO 	= new InvArIfChgVO();
    					double trf_rt_amt 			= 0;
    					String curr_cd 				= "";
    					
    					for(int i = 0 ; i < invArIfChgVOs.size() ; i++) {
    						invArIfChgVO 	= (InvArIfChgVO)invArIfChgVOs.get(i);
    						trf_rt_amt 		= Double.parseDouble(invArIfChgVO.getTrfRtAmt());
    						curr_cd 		= invArIfChgVO.getCurrCd();
    						
    						trf_rt_amt 		= dmtCalculationUtil.trimCurrencyAmount(curr_cd, trf_rt_amt);	//trf_rt_amt 疫뀀뜆釉�筌ｌ꼶��curr_cd)
    						invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(trf_rt_amt, "#.##"));
    						invArIfChgVOs.set(i, invArIfChgVO);
    					}
    				}
    			} 
    			else {
    				//Credit Note 占쏙옙野껋럩��RT疫뀀뜆釉몌옙占썸�袁⑷텦占쎌꼷肉�interface占쎌뮆��
    				if ("Y".equals(condVO.getCrInvFlg())) {
    					invArIfChgVOs 	= dbDao.searchInterfaceChargeByInvoiceRate(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
        				
    				} 
    				else {
		    			list = dbDao.searchInterfaceChargeCalculation(condVO.getDmdtInvNo(), condVO.getCreOfcCd());
		    			if (list != null && list.size() > 0) {
		    				invArIfChgVOs = new ArrayList<InvArIfChgVO>() ;
		    				
		    				for (int i = 0 ; i < list.size() ; i++) {
		    					InterfaceChargeCalculationVO ifCalcuVO = list.get(i);
		    					
		    					if ("Y".equals(ifCalcuVO.getDulTpExptFlg())) {
		    						
		        					if (ifCalcuVO.getFxFtOvrDys().equals("0")) {//DETAIL占쏙옙OVER DAY 揶쏉옙0 占쎈��� 占쎈Ŧ��筌ｌ꼶��占쎌뮆�� 
		        						String message = new ErrorHandler("DMT03071").getUserMessage();
		        						message = JSPUtil.replace(message, "$1", ifCalcuVO.getCntrNo());
		        						
		        						invArIfChgVOs = null;
		        						invArIfMnVO = new InvArIfMnVO();
		        						invArIfMnVO.setArIfNo(message);	//占쎌뮆苡�占쎈Ŧ��筌롫뗄�놅쭪占썲첎占�
		        						arInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
		        						return arInterfaceCreationVO;
		        					}
		        					
		    						//bbsCharge Calculation 嚥≪뮇彛낉옙占쏙옙占쏙옙 占쎈봽��dtl->rt嚥∽옙筌띾슢諭억옙�곴퐣 占쎄쑬�뽳옙�뺣뼄.
		    						//basic tariff揶쏉옙鈺곕똻�깍옙�륅옙 占쎈봿釉섓옙占�..
		    						invArIfChgVOs = dbDao.searchInterfaceChargeByInvoiceDetail(condVO.getDmdtInvNo(), condVO.getCreOfcCd(), condVO.getIdaTaxApplTm());
		    						
		    	    				if (invArIfChgVOs != null && invArIfChgVOs.size() > 0) {
		    	    					InvArIfChgVO invArIfChgVO 	= new InvArIfChgVO();
		    	    					double trf_rt_amt 			= 0;
		    	    					String curr_cd 				= "";
		    	    					for (int j = 0 ; j < invArIfChgVOs.size() ; j++) {
		    	    						invArIfChgVO = (InvArIfChgVO)invArIfChgVOs.get(j);
		    	    						trf_rt_amt = Double.parseDouble(invArIfChgVO.getTrfRtAmt());
		    	    						curr_cd = invArIfChgVO.getCurrCd();
		    	    						
		    	    						trf_rt_amt = dmtCalculationUtil.trimCurrencyAmount(curr_cd, trf_rt_amt);	//trf_rt_amt 疫뀀뜆釉�筌ｌ꼶��curr_cd)
		    	    						invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(trf_rt_amt, "#.##"));
		    	    						invArIfChgVOs.set(j, invArIfChgVO);
		    	    					}
		    	    				}
		    					} 
		    					else {
		    						String firstSvrID = null;
		    						
			    	                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
			    	                overdayNDivParmVO.setSvrId(ifCalcuVO.getSvrId());
			    	                overdayNDivParmVO.setCntrNo(ifCalcuVO.getCntrNo());
			    	                overdayNDivParmVO.setCnmvCycNo(ifCalcuVO.getCntrCycNo());
			    	                overdayNDivParmVO.setDttCode(ifCalcuVO.getDmdtTrfCd());
			    	                overdayNDivParmVO.setLocDiv(ifCalcuVO.getDmdtChgLocDivCd());
			    	                overdayNDivParmVO.setDccSeq(ifCalcuVO.getChgSeq());
			    	                
			    	                // ********** DivOverDay 鈺곌퀬��
			    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
			    	                
			    	                //office transfer check
			    	                if ("Y".equals(ifCalcuVO.getOfcTrnsFlg())) {
			    	                	ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
			    	                	chargeCalculationParmVO.setDmdtTrfCd(ifCalcuVO.getDmdtTrfCd());
			    	                	chargeCalculationParmVO.setDmdtChgLocDivCd(ifCalcuVO.getDmdtChgLocDivCd());
			    	                	chargeCalculationParmVO.setCntrNo(ifCalcuVO.getCntrNo());
			    	                	chargeCalculationParmVO.setCntrCycNo(ifCalcuVO.getCntrCycNo());
			    	                	chargeCalculationParmVO.setSvrId(ifCalcuVO.getSvrId());
			    	                	chargeCalculationParmVO.setBkgNo(ifCalcuVO.getBkgNo());
			    	                	chargeCalculationParmVO.setFmMvmtYdCd(ifCalcuVO.getFmMvmtYdCd()); //2011.10.28
			    	               
			    	    				log.debug(" iss searchARInterfaceInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		

			    	                	firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
			    	                } 
			    	                else {
			    	                	firstSvrID = ifCalcuVO.getSvrId();
			    	                }
			    	                
			    	                CalculationParmVO calculationParmVO = new CalculationParmVO();
			    	                
			    					String trfAplyTpCd = ifCalcuVO.getDmdtTrfAplyTpCd();
			    					calculationParmVO.setDcApplRate(trfAplyTpCd);
			    					
			    					//嚥≪뮇彛�癰귨옙瑗�G嚥≪뮆彛�野껋럩��쭕占쏙㎗�롡봺占쎌꼵��	Discount Amount + Exception Amount > 0 占쎌눊瑗랃옙占쏙쭕�됱뵠占쎈뜆��疫뀀뜆釉몌옙�곗쨮 占쏙옙揶쏉옙占쏙옙占쎌빘苑�
			    					//占쏙옙��嚥≪뮇彛낉옙占쏙옙占쎌찈占쎌꼵苡�筌ｌ꼶��占쎄쑴��
			    					/*
			    						Charge占쏙옙占쎄낯�쒙옙占폯ariff占쏙옙占쎄퀡��Charge疫뀀뜆釉몌옙占썸�袁⑷텦占쎌뮆��
			    					    A) "G"(Basic Tariff)占쏙옙野껋럩��Basic Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�뺣뼄
			    					*/
		    						// basicCalculation - Baisc Tariff
		    						calculationParmVO.setSvrId(firstSvrID);				//svr_id
		    						calculationParmVO.setDmdtTrfCd(ifCalcuVO.getDmdtTrfCd());		//dmdt_trf_cd
		    						calculationParmVO.setTrfSeq(ifCalcuVO.getBzcTrfSeq());			//bzc_trf_seq
		    						calculationParmVO.setDmdtDeTermCd(ifCalcuVO.getBzcDmdtDeTermCd());//dmdt_de_term_cd
		    						calculationParmVO.setTrfGrpSeq(ifCalcuVO.getBzcTrfGrpSeq());	//bzc_trf_grp_seq
		    						calculationParmVO.setCntrts(ifCalcuVO.getCntrTpszCd());			//cntr_tpsz_cd
		    						calculationParmVO.setOverDay(ifCalcuVO.getOrgFtOvrDys());		//org_ft_ovr_dys
		    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());	//div_over_day
		    						calculationParmVO.setCurCd(ifCalcuVO.getBzcTrfCurrCd());		//bzc_trf_curr_cd
		    						calculationParmVO.setFtDys(ifCalcuVO.getFxFtOvrDys());			// 2014.03.12
		    						calculationParmVO.setFmMvmtYdCd(ifCalcuVO.getFmMvmtYdCd());		// 2014.03.12
		    						calculationParmVO.setTrfAplyDt(ifCalcuVO.getBzcTrfAplyDt());	// 2014.03.12
		    						calculationParmVO.setDmdtTrfAplyTpCd("G");						// 2014.03.12
		    						calculationParmVO.setOrgFtOvrDys(ifCalcuVO.getOrgFtOvrDys());	// 2014.03.12
		    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
		    						
		    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
			    	                
			    	                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
			    	                
			    	                if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
			    	                	
			    	                	int chgSeq = 1;
			    	                	for (ChrgDtlVO chrgDtlVO : chrgDtlVOS) {
			    	                		
			    		                    if (Double.parseDouble(chrgDtlVO.getRtDay()) == 0) continue;
			    		                    
			    		                    InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
			    		                    
			    		                    double rt_ovr_chg_amt = 0;
			    		                    rt_ovr_chg_amt = Double.parseDouble(chrgDtlVO.getRtChrg());
			    		                    
				        	                log.debug("\nrt_ovr_chg_amt ====>"+rt_ovr_chg_amt);
			    		                    
			    		                    double inv_rt_amt = 0;
			    		                    inv_rt_amt = Double.parseDouble(chrgDtlVO.getRtRate());
			    		                    
				        	                log.debug("\ninv_rt_amt ====>"+inv_rt_amt);
			    		                    
			    		                    String curr_cd = "";
			    		                    curr_cd = ifCalcuVO.getBzcTrfCurrCd();
			    		                    
			    		                    invArIfChgVO.setChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));
			    		                    
			    		                    invArIfChgVO.setChgCd(ifCalcuVO.getChgCd());
			    		                    invArIfChgVO.setChgFullNm("");
			    		                    invArIfChgVO.setChgSeq(String.valueOf(chgSeq));
			    		                    invArIfChgVO.setCreDt(ifCalcuVO.getCreDt());
			    		                    invArIfChgVO.setCreUsrId(ifCalcuVO.getCreUsrId());
			    		                    invArIfChgVO.setCurrCd(curr_cd);
			    		                    invArIfChgVO.setInvXchRt(ifCalcuVO.getInvXchRt());
			    		                    invArIfChgVO.setPerTpCd(ifCalcuVO.getPerTpCd());
			    		                    invArIfChgVO.setRatAsCntrQty(chrgDtlVO.getRtDay());
			    		                    invArIfChgVO.setSrcIfDt(ifCalcuVO.getSrcIfDt());
			    		                    invArIfChgVO.setSrcIfSeq(ifCalcuVO.getSrcIfSeq());
			    		                    invArIfChgVO.setTrfNo(ifCalcuVO.getTrfNo());
			    		                    invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(inv_rt_amt, "#.##"));
			    		                    invArIfChgVO.setTvaFlg(ifCalcuVO.getTvaFlg());
			    		                    invArIfChgVO.setSbcFlg(ifCalcuVO.getSbcFlg());
			    		                    invArIfChgVO.setKkcFlg(ifCalcuVO.getKkcFlg());
			    		                    invArIfChgVO.setUpdDt(ifCalcuVO.getUpdDt());
			    		                    invArIfChgVO.setUpdUsrId(ifCalcuVO.getUpdUsrId());
			    		                    
			    		                    //invArIfChgVOs 占쏙옙占쏙옙��
			    		                    invArIfChgVOs.add(invArIfChgVO);
			    		                    
			    		                    chgSeq++;// charge sequence
			    	                	}
			    	                } 
			    	                
		    	                	//======================================================
			    	                //Discount Amount + Exception Amount + Commdity Amount > 0 占쎈���- 揶쏅���占쎄쑬�뽳옙�뺣뼄.
			    	                double dScRfaExptAmt = Double.parseDouble(ifCalcuVO.getScRfaExptAmt());
			    	                double dAftExptDcAmt = Double.parseDouble(ifCalcuVO.getAftExptDcAmt());
			    	                double dCmdtExptAmt  = Double.parseDouble(ifCalcuVO.getCmdtExptAmt());
			    	                
			    	                //invoice 占쎌빘苑�
			    	                if( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt != 0) {
			    	                	InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
			    	                	double rt_ovr_chg_amt = 0;
		    		                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
		    		                    
			    	                	invArIfChgVO.setChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));	
		    		                    invArIfChgVO.setChgCd(ifCalcuVO.getChgCd());		//chgCd
		    		                    invArIfChgVO.setChgFullNm("");
		    		                    invArIfChgVO.setCurrCd(ifCalcuVO.getCurrCd());
		    		                    invArIfChgVO.setChgSeq(String.valueOf(invArIfChgVOs.size()+1));
		    		                    invArIfChgVO.setCreDt(ifCalcuVO.getCreDt());
		    		                    invArIfChgVO.setCreUsrId(ifCalcuVO.getCreUsrId());
		    		                    invArIfChgVO.setInvXchRt(ifCalcuVO.getInvXchRt());
		    		                    invArIfChgVO.setPerTpCd(ifCalcuVO.getPerTpCd());
		    		                    invArIfChgVO.setRatAsCntrQty("1");
		    		                    invArIfChgVO.setSrcIfDt(ifCalcuVO.getSrcIfDt());
		    		                    invArIfChgVO.setSrcIfSeq(ifCalcuVO.getSrcIfSeq());
		    		                    invArIfChgVO.setTrfNo(ifCalcuVO.getTrfNo());
		    		                    invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * -1, "#.##"));//(+)疫뀀뜆釉�
		    		                    invArIfChgVO.setTvaFlg(ifCalcuVO.getTvaFlg());
		    		                    invArIfChgVO.setSbcFlg(ifCalcuVO.getSbcFlg());
		    		                    invArIfChgVO.setKkcFlg(ifCalcuVO.getKkcFlg());
		    		                    invArIfChgVO.setUpdDt(ifCalcuVO.getUpdDt());
		    		                    invArIfChgVO.setUpdUsrId(ifCalcuVO.getUpdUsrId());
		    		                    
		    		                    //invArIfChgVOs 占쏙옙占쏙옙��
		    		                    invArIfChgVOs.add(invArIfChgVO);
			    	                }
			    				}
		    				}
		    			}
    				}
	    		}
    		}
    		
    		//======================================================
    		
    		if (invArIfChgVOs != null && invArIfChgVOs.size() > 0) {

        		boolean isTva = false;
        		boolean isSbc = false;
        		boolean isKkc = false;
        		
    			for (InvArIfChgVO invArIfChgVO : invArIfChgVOs) {
    				if ("Y".equals(invArIfChgVO.getTvaFlg())) isTva = true;
    				if ("Y".equals(invArIfChgVO.getSbcFlg())) isSbc = true;
    				if ("Y".equals(invArIfChgVO.getKkcFlg())) isKkc = true;
    			}

	    		
	    		log.debug("\n==========isTva ====>"+ isTva);
	    		if (isTva) {
	    			chg_seq = String.valueOf(invArIfChgVOs.size() + 1);
	    			InvArIfChgVO invArIfChgAddVO1 = dbDao.searchInterfaceTaxAmt(condVO.getUsrOfcCd(), condVO.getDmdtInvNo(), chg_seq, condVO.getCreOfcCd(), "T");
	    			invArIfChgVOs.add(invArIfChgAddVO1);
	    		}
    		
	    		log.debug("\n==========isSbc ====>"+ isSbc);
	    		if (isSbc) {
	    			chg_seq = String.valueOf(invArIfChgVOs.size() + 1);
	    			InvArIfChgVO invArIfChgAddVO2 = dbDao.searchInterfaceTaxAmt(condVO.getUsrOfcCd(), condVO.getDmdtInvNo(), chg_seq, condVO.getCreOfcCd(), "S");
	    			invArIfChgVOs.add(invArIfChgAddVO2);
	    		}

	    		log.debug("\n==========isKkc ====>"+ isKkc);
	    		if (isKkc) {
	    			chg_seq = String.valueOf(invArIfChgVOs.size() + 1);
	    			InvArIfChgVO invArIfChgAddVO2 = dbDao.searchInterfaceTaxAmt(condVO.getUsrOfcCd(), condVO.getDmdtInvNo(), chg_seq, condVO.getCreOfcCd(), "K");
	    			invArIfChgVOs.add(invArIfChgAddVO2);
	    		}
    		}
    		
    		//test............................
    		log.debug("\n##################### IN INTERFACE ###############################");
    		invArIfMnVO.setApArOffstNo("");
    		invArIfMnVO.setArIfNo("");
    		invArIfMnVO.setBkgCorrDt("");
    		invArIfMnVO.setBkgCorrNo("");
    		invArIfMnVO.setBkgRefNo("");
    		invArIfMnVO.setBlInvIfDt("");
    		invArIfMnVO.setBlInvIfFlg("");
    		invArIfMnVO.setBlTpCd("");
    		invArIfMnVO.setCgoMeasQty("");
    		invArIfMnVO.setCgoWgt("");
    		//invArIfMnVO.setDestTrnsSvcModCd(""); // 2010-08-13 占쎌꼷��
    		invArIfMnVO.setDueDt("");
    		invArIfMnVO.setFrtFwrdCntCd("");
    		invArIfMnVO.setFrtFwrdCustSeq("");
    		invArIfMnVO.setGlEffDt("");
    		//invArIfMnVO.setInvRefNo("");
    		//invArIfMnVO.setInvRmk("");
    		invArIfMnVO.setMstBlNo("");
    		invArIfMnVO.setRfaNo("");
    		invArIfMnVO.setSailArrDt("");
    		invArIfMnVO.setSailDt("");
    		invArIfMnVO.setScNo("");
    		invArIfMnVO.setSiRefNo("");
    		invArIfMnVO.setSlanCd("");
    		invArIfMnVO.setSrcIfDt("");
    		invArIfMnVO.setSrcIfSeq("");
    		invArIfMnVO.setSrepCd("");
    		invArIfMnVO.setSvcScpCd("");
    		invArIfMnVO.setTrspRqstOrdFlg("");
    		invArIfMnVO.setVvdTrnsFlg("");
    		invArIfMnVO.setWhfDeclCfmDt("");
    		invArIfMnVO.setWhfDeclDirCd("");
    		invArIfMnVO.setWhfDeclNo("");
    		invArIfMnVO.setWhfDeclOfcCd("");
    		invArIfMnVO.setWhfDeclVoyNo("");
    		invArIfMnVO.setWhfDeclVslCd("");
    		invArIfMnVO.setWhfMrnNo("");
    		
    		// 로그 출력!!
    		StringBuilder sbLog = new StringBuilder();
    		sbLog.append("\n##################### IN INTERFACE MAIN ###############################");
    		sbLog.append("\n####[AP_APR_OFFST_NO	]"+invArIfMnVO.getApArOffstNo());
    		sbLog.append("\n####[AP_AR_IF_NO		]"+invArIfMnVO.getArIfNo());
    		sbLog.append("\n####[BKG_CORR_DT		]"+invArIfMnVO.getBkgCorrDt());
    		sbLog.append("\n####[BKG_CORR_NO		]"+invArIfMnVO.getBkgCorrNo());
    		sbLog.append("\n####[BKG_FEU_QTY		]"+invArIfMnVO.getBkgFeuQty());
    		sbLog.append("\n####[BKG_NO				]"+invArIfMnVO.getBkgNo());
    		sbLog.append("\n####[BKG_REF_NO			]"+invArIfMnVO.getBkgRefNo());
    		sbLog.append("\n####[BKG_TEU_QTY		]"+invArIfMnVO.getBkgTeuQty());
    		sbLog.append("\n####[BL_INV_IF_DT		]"+invArIfMnVO.getBlInvIfDt());
    		sbLog.append("\n####[BL_INV_IFFLG		]"+invArIfMnVO.getBlInvIfFlg());
    		sbLog.append("\n####[BL_NO				]"+invArIfMnVO.getBlNo());
    		sbLog.append("\n####[BL_SRC_NO			]"+invArIfMnVO.getBlSrcNo());
    		sbLog.append("\n####[BL_TP_CD			]"+invArIfMnVO.getBlTpCd());
    		sbLog.append("\n####[CGO_MEAS_QTY		]"+invArIfMnVO.getCgoMeasQty());
    		sbLog.append("\n####[CGO_WGT			]"+invArIfMnVO.getCgoWgt());
    		sbLog.append("\n####[CRE_DT				]"+invArIfMnVO.getCreDt());
    		sbLog.append("\n####[CRE_USR_ID			]"+invArIfMnVO.getCreUsrId());
    		sbLog.append("\n####[CUST_CNT_CD		]"+invArIfMnVO.getCustCntCd());
    		sbLog.append("\n####[CUST_SEQ			]"+invArIfMnVO.getCustSeq());
    		sbLog.append("\n####[DEL_CD				]"+invArIfMnVO.getDelCd());
    		sbLog.append("\n####[DEST_TRNS_SVC_MOD_CD]"+invArIfMnVO.getDestTrnsSvcModCd());
    		sbLog.append("\n####[DUE_DT				]"+invArIfMnVO.getDueDt());
    		sbLog.append("\n####[FRT_FWRD_CNT_CD	]"+invArIfMnVO.getFrtFwrdCntCd());
    		sbLog.append("\n####[FRT_FWRD_CUST_SEQ	]"+invArIfMnVO.getFrtFwrdCustSeq());
    		sbLog.append("\n####[GL_EFF_DT			]"+invArIfMnVO.getGlEffDt());
    		sbLog.append("\n####[IF_SRC_CD			]"+invArIfMnVO.getIfSrcCd());
    		sbLog.append("\n####[INV_REF_NO			]"+invArIfMnVO.getInvRefNo());
    		sbLog.append("\n####[INV_RMK			]"+invArIfMnVO.getInvRmk());
    		sbLog.append("\n####[INV_SRC_NO			]"+invArIfMnVO.getInvSrcNo());
    		sbLog.append("\n####[IO_BND_CD			]"+invArIfMnVO.getIoBndCd());
    		sbLog.append("\n####[MST_BL_NO			]"+invArIfMnVO.getMstBlNo());
    		sbLog.append("\n####[OFC_CD				]"+invArIfMnVO.getOfcCd());
    		sbLog.append("\n####[POD_CD				]"+invArIfMnVO.getPodCd());
    		sbLog.append("\n####[POL_CD				]"+invArIfMnVO.getPolCd());
    		sbLog.append("\n####[POR_CD				]"+invArIfMnVO.getPorCd());
    		sbLog.append("\n####[RFA_NO				]"+invArIfMnVO.getRfaNo());
    		sbLog.append("\n####[SAIL_ART_DT		]"+invArIfMnVO.getSailArrDt());
    		sbLog.append("\n####[SAIL_DT			]"+invArIfMnVO.getSailDt());
    		sbLog.append("\n####[SC_NO				]"+invArIfMnVO.getScNo());
    		sbLog.append("\n####[SI_REF_NO			]"+invArIfMnVO.getSiRefNo());
    		sbLog.append("\n####[SKD_DIR_CD			]"+invArIfMnVO.getSkdDirCd());
    		sbLog.append("\n####[SKD_VOY_NO			]"+invArIfMnVO.getSkdVoyNo());
    		sbLog.append("\n####[SLAN_CD			]"+invArIfMnVO.getSlanCd());
    		sbLog.append("\n####[SLS_OFC_CD			]"+invArIfMnVO.getSlsOfcCd());
    		sbLog.append("\n####[SRC_IF_DT			]"+invArIfMnVO.getSrcIfDt());
    		sbLog.append("\n####[SRC_IF_SEQ			]"+invArIfMnVO.getSrcIfSeq());
    		sbLog.append("\n####[SREP_CD			]"+invArIfMnVO.getSrepCd());
    		sbLog.append("\n####[SVC_SCP_CD			]"+invArIfMnVO.getSvcScpCd());
    		sbLog.append("\n####[TRNK_SKD_DIR_CD	]"+invArIfMnVO.getTrnkSkdDirCd());
    		sbLog.append("\n####[TRNK_SKD_VOY_NO	]"+invArIfMnVO.getTrnkSkdVoyNo());
    		sbLog.append("\n####[TRNK_VSL_CD		]"+invArIfMnVO.getTrnkVslCd());
    		sbLog.append("\n####[TRSP_RQST_ORD_FLG	]"+invArIfMnVO.getTrspRqstOrdFlg());
    		sbLog.append("\n####[UPD_DT				]"+invArIfMnVO.getUpdDt());
    		sbLog.append("\n####[UPD_USR_ID			]"+invArIfMnVO.getUpdUsrId());
    		sbLog.append("\n####[VSL_CD				]"+invArIfMnVO.getVslCd());
    		sbLog.append("\n####[VVD_TRNS_FLG		]"+invArIfMnVO.getVvdTrnsFlg());
    		sbLog.append("\n####[WHF_DECL_CFM_DT	]"+invArIfMnVO.getWhfDeclCfmDt());
    		sbLog.append("\n####[WHF_DECL_DIR_CD	]"+invArIfMnVO.getWhfDeclDirCd());
    		sbLog.append("\n####[WHF_DECL_NO		]"+invArIfMnVO.getWhfDeclNo());
    		sbLog.append("\n####[WHF_DECL_OFC_CD	]"+invArIfMnVO.getWhfDeclOfcCd());
    		sbLog.append("\n####[WHF_DECL_VOY_NO	]"+invArIfMnVO.getWhfDeclVoyNo());
    		sbLog.append("\n####[WHF_DECL_VSL_CD	]"+invArIfMnVO.getWhfDeclVslCd());
    		sbLog.append("\n####[WHF_MRN_NO			]"+invArIfMnVO.getWhfMrnNo());
    		sbLog.append("\n####[OFC_TRNS_FLG		]"+invArIfMnVO.getOfcTrnsFlg());
    		log.debug(sbLog.toString());
    		sbLog.setLength(0);
    		
    		sbLog.append("\n##################### IN INTERFACE CHARGE ###############################");
    		if (invArIfChgVOs != null) {
	    		for (int i = 0 ; i < invArIfChgVOs.size() ; i++) {
	    			sbLog.append("\n####[-- row ----"+i+"------]");
	    			invArIfChgVOs.get(i).setChgFullNm("");
	    			invArIfChgVOs.get(i).setChgRmk("");
	    			invArIfChgVOs.get(i).setInvXchRt("");
	    			invArIfChgVOs.get(i).setRepChgCd("");
	    			
	    			sbLog.append("\n####[CHG_AMT		]"+invArIfChgVOs.get(i).getChgAmt());
	    			sbLog.append("\n####[CHG_CD			]"+invArIfChgVOs.get(i).getChgCd());
	    			sbLog.append("\n####[CHG_FULL_NM	]"+invArIfChgVOs.get(i).getChgFullNm());
	    			sbLog.append("\n####[CHG_RMK		]"+invArIfChgVOs.get(i).getChgRmk());
	    			sbLog.append("\n####[CHG_SEQ		]"+invArIfChgVOs.get(i).getChgSeq());
	    			sbLog.append("\n####[CRE_DT			]"+invArIfChgVOs.get(i).getCreDt());
	    			sbLog.append("\n####[CRE_USR_ID		]"+invArIfChgVOs.get(i).getCreUsrId());
	    			sbLog.append("\n####[CURR_CD		]"+invArIfChgVOs.get(i).getCurrCd());
	    			sbLog.append("\n####[INV_XCH_RT		]"+invArIfChgVOs.get(i).getInvXchRt());
	    			sbLog.append("\n####[PER_TP_CD		]"+invArIfChgVOs.get(i).getPerTpCd());
	    			sbLog.append("\n####[RAT_AS_CNTR_QTY]"+invArIfChgVOs.get(i).getRatAsCntrQty());
	    			sbLog.append("\n####[REP_CHG_CD		]"+invArIfChgVOs.get(i).getRepChgCd());
	    			sbLog.append("\n####[SRC_IF_DT		]"+invArIfChgVOs.get(i).getSrcIfDt());
	    			sbLog.append("\n####[SRC_IF_SEQ		]"+invArIfChgVOs.get(i).getSrcIfSeq());
	    			sbLog.append("\n####[TRF_NO			]"+invArIfChgVOs.get(i).getTrfNo());
	    			sbLog.append("\n####[TRF_RT_AMT		]"+invArIfChgVOs.get(i).getTrfRtAmt());
	    			sbLog.append("\n####[TVA_FLG		]"+invArIfChgVOs.get(i).getTvaFlg());
	    			sbLog.append("\n####[SBC_FLG		]"+invArIfChgVOs.get(i).getSbcFlg());
	    			sbLog.append("\n####[UPD_DT			]"+invArIfChgVOs.get(i).getUpdDt());
	    			sbLog.append("\n####[UPD_USR_ID		]"+invArIfChgVOs.get(i).getUpdUsrId());
	    		}
    		}
    		else {
    			sbLog.append("\n####[-- There is no result!! --]");
    		}
    		log.debug(sbLog.toString());
    		sbLog.setLength(0);
    		
    		sbLog.append("\n##################### IN INTERFACE CONTAINER ###############################");
    		if (invArIfChgVOs != null) {
	    		for(int i = 0 ; i < invArIfCntrVOs.size() ; i++) {
	    			sbLog.append("\n####[---row--"+i+"------]");
	    			sbLog.append("\n####[CNTR_NO		]"+invArIfCntrVOs.get(i).getCntrNo());
	    			sbLog.append("\n####[CNTR_SEQ		]"+invArIfCntrVOs.get(i).getCntrSeq());
	    			sbLog.append("\n####[CNTR_TPSZ_CD	]"+invArIfCntrVOs.get(i).getCntrTpszCd());
	    			sbLog.append("\n####[CRE_DT			]"+invArIfCntrVOs.get(i).getCreDt());
	    			sbLog.append("\n####[CRE_USR_ID		]"+invArIfCntrVOs.get(i).getCreUsrId());
	    			sbLog.append("\n####[SRC_IF_DT		]"+invArIfCntrVOs.get(i).getSrcIfDt());
	    			sbLog.append("\n####[SRC_IF_SEQ		]"+invArIfCntrVOs.get(i).getSrcIfSeq());
	    			sbLog.append("\n####[UPD_DT			]"+invArIfCntrVOs.get(i).getUpdDt());
	    			sbLog.append("\n####[UPD_USR_ID		]"+invArIfCntrVOs.get(i).getUpdUsrId());
	    		}
    		}
    		else {
    			sbLog.append("\n####[-- There is no result!! --]");
    		}
    		log.debug(sbLog.toString());
    		sbLog.setLength(0);
    		
    		arInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
    		arInterfaceCreationVO.setInvArIfChgVOs(invArIfChgVOs);
    		arInterfaceCreationVO.setInvArIfCntrVOs(invArIfCntrVOs);
        } 
    	catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    	return arInterfaceCreationVO;
    }       
    
    
    /**
     * [group invoice�쒙옙占쎌빘苑�占쏙옙charge]占쏙옙占쎈베�ョ몴占�占쏙옙��占쎌뮆��
     * @param InvoiceGroupMgtVO invoiceGroupMgtVO
     * @return List<InvoiceIssueVO>
     * @throws EventException
     */
    public List<InvoiceIssueVO> searchChargeBookingGroupInvoiceDetail(InvoiceGroupMgtVO invoiceGroupMgtVO) throws EventException{
		IssuedInvoiceParamVO issuedInvoiceParamVO 	= new IssuedInvoiceParamVO();
		List<InvoiceIssueVO> invoiceIssueList 		= new ArrayList<InvoiceIssueVO>();
		List<InvoiceIssueVO> tempList				= null;
        List<ConfirmChargeListVO> list 				= null;
        InvoiceGroupParamVO groupVO					= new InvoiceGroupParamVO();
		
		try {
			log.debug("-----------------1------------------");
			list 	= invoiceGroupMgtVO.getConfirmChargeListVOs();
			log.debug("-----------------2------------------");
			groupVO = invoiceGroupMgtVO.getInvoiceGroupParamVO();
			
			log.debug("-----------------3------------------");
			
			
    		if(groupVO.getSGroupBy().equals("1")){//Group by (B/L No(BKG No))
   			log.debug("-----------------4------------------");
	    		for(int i = 0; i < list.size(); i++) {
	    			ConfirmChargeListVO confirmChargeListVO = (ConfirmChargeListVO)list.get(i);
	    			//CheckBox 沃섎챷苑묕옙�밸뻻 占쏙옙�ｏ옙占쏙옙�륅옙 占쎈봾�쀯옙占�
	    			if(confirmChargeListVO.getCheckBox().equals("1")) {
		    			String invoice_no = confirmChargeListVO.getDmdtInvNo();
	    				
	    				
	    				issuedInvoiceParamVO = new IssuedInvoiceParamVO();
	    				issuedInvoiceParamVO.setSBkgNo(confirmChargeListVO.getBkgNo());
	    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVO.getDmdtTrfCd());
	    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
	    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVO.getOfcCd());		//charge office code
	    	            
	    	            
	    	            tempList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	    	            
	    	            for(int j=0 ; j < tempList.size() ; j++) {
	    	            	InvoiceIssueVO tempVO = (InvoiceIssueVO)tempList.get(j);
	    	            	tempVO.setDmdtInvNo(invoice_no);
	    	            	
	    	            	invoiceIssueList.add(tempVO);
	    	            }
	    			}
	    		}
    		}else{//Group by (Cntr No) 占쏙옙野껋럩��옙占쏙옙醫뤾문占쏙옙CONTAINER筌랃옙占쎌쥓�ゅ첎占�
   			log.debug("-----------------5------------------");
   				
    			for(int i = 0; i < list.size(); i++) {
    				ConfirmChargeListVO confirmChargeListVO = (ConfirmChargeListVO)list.get(i);
    	   			log.debug("-----------------5---check_box---------------"+confirmChargeListVO.getCheckBox());
    	   			log.debug("-----------------5---inv_no---------------"+confirmChargeListVO.getDmdtInvNo());
    	   			log.debug("-----------------5---bkg_no---------------"+confirmChargeListVO.getBkgNo());
    	   			log.debug("-----------------5---dmdt_trf_cd---------------"+confirmChargeListVO.getDmdtTrfCd());
    	   			log.debug("-----------------5---cntr_no---------------"+confirmChargeListVO.getCntrNo());

    	   			//CheckBox 沃섎챷苑묕옙�밸뻻 占쏙옙�ｏ옙占쏙옙�륅옙 占쎈봾�쀯옙占�
	    			if(confirmChargeListVO.getCheckBox().equals("1")) {
	    				String invoice_no = confirmChargeListVO.getDmdtInvNo();
	    				
	    				issuedInvoiceParamVO.setSBkgNo(confirmChargeListVO.getBkgNo());
	    				issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVO.getDmdtTrfCd());
	    				issuedInvoiceParamVO.setDmdtChgStsCds("C");
	    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVO.getOfcCd());		//charge office code
	    				
	    				tempList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	    	            
	    	            for(int j=0 ; j < tempList.size() ; j++) {
	    	            	InvoiceIssueVO tempVO = (InvoiceIssueVO)tempList.get(j);
	    	            	//container no揶쏉옙鈺곕똻�깍옙�롫뮉 野껋럩��쭕占폺harge嚥∽옙占쎄퀣�좑옙怨뺧옙 占쎄쑴�싷옙�뺣뼄.
	    	            	if(!tempVO.getCntrNo().equals(confirmChargeListVO.getCntrNo())) {
	    	            		continue;
	    	            	}
	    	            	
	    	            	tempVO.setDmdtInvNo(invoice_no);
	    	            	
	    	            	invoiceIssueList.add(tempVO);
	    	            }
	    			}
	    		}
    		}
			log.debug("-----------------6------------------");
    		return invoiceIssueList;
		
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
		}		    	
    }
    
    
    /**
     * Bkg癰귨옙cntr 揶쏉옙�붺몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return int
     * @throws DAOException
     */
    public int searchBookingContainerCount(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
    	int cntr_cnt = 0;
        
        try{
        	cntr_cnt = dbDao.searchBookingContainerCount(issuedInvoiceParamVO);
            
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[DAOException]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        return cntr_cnt;
    }
    
    /**
     * VVD 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return VVDCheckDataVO
     * @throws EventException
     */
    public VVDCheckDataVO searchVVDCheckData(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
    	VVDCheckDataVO vVDCheckDataVO   = new VVDCheckDataVO();
    	try{
    		vVDCheckDataVO = dbDao.searchVVDCheckData(issuedInvoiceParamVO, "1");
    		
    		if(!vVDCheckDataVO.getBkgNo().equals("")){
    			vVDCheckDataVO = dbDao.searchVVDCheckData(issuedInvoiceParamVO, "2");
    		}else{
            	vVDCheckDataVO.setBkgNo("");
            	vVDCheckDataVO.setPolCd("");
            	vVDCheckDataVO.setPodCd("");
            	vVDCheckDataVO.setIoBnd("");
    		}
    		
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        return vVDCheckDataVO;
    }
    
    /**
     * Payer癰귨옙fax甕곕뜇��email占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�
     * @param FAXEmailByPayerVO fAXEmailByPayerVO
     * @return FAXEmailByPayerVO
     * @throws EventException
     */
    public FAXEmailByPayerVO searchFAXEmailByPayer(FAXEmailByPayerVO fAXEmailByPayerVO) throws EventException {
    	FAXEmailByPayerVO refAXEmailByPayerVO   = new FAXEmailByPayerVO();
    	List<FAXEmailByPayerVO> list = null;
    	String email = "";
    	String fax = "";
    	
    	try{
    		//Customer
    		if(fAXEmailByPayerVO.getPayerCd().length() == 6) {
    			fAXEmailByPayerVO.setPayerGubun("V");
    		//Vendor
    		}else if(fAXEmailByPayerVO.getPayerCd().length() == 8) {
    			fAXEmailByPayerVO.setPayerGubun("C");
    		}
    		
    		String io_bnd_cd = "";
    		//io_bnd_cd
    		if(fAXEmailByPayerVO.getDmdtTrfCd() == null || fAXEmailByPayerVO.getDmdtTrfCd().equals("")) {
    			io_bnd_cd = "";
    		}else{
    			io_bnd_cd = fAXEmailByPayerVO.getDmdtTrfCd().substring(2,3);
    		}
    		fAXEmailByPayerVO.setIoBndCd(io_bnd_cd);
    		
    		FAXEmailByPayerVO tempVO   = new FAXEmailByPayerVO();
    		//1. email 鈺곌퀬��
    		list = dbDao.searchEmailByPayer(fAXEmailByPayerVO);
    		
    		int email_cnt = 0;
    		StringBuffer sb_email = new StringBuffer();
    		
    		if(list == null || list.size() == 0) {
    			email = "";
    		}else{
    			for( int i = 0 ; i < list.size(); i++) {
    				tempVO = (FAXEmailByPayerVO)list.get(i);
    				
    				if(StringUtils.trimToEmpty(tempVO.getEmail()).equals(""))  					
    					continue;
    				
    				
    				if(email_cnt > 0)	
    					sb_email.append(";");
    				
    				sb_email.append(StringUtils.trimToEmpty(tempVO.getEmail()));
    				email_cnt++;
    			}
    		}
    		email = sb_email.toString();
    		
    		
    		//2. fax 鈺곌퀬��
    		list = dbDao.searchFAXByPayer(fAXEmailByPayerVO);
    		int fax_cnt = 0;
    		StringBuffer sb_fax = new StringBuffer();
    		
    		if(list == null || list.size() == 0) {
    			fax = "";
    		}else{
    			for( int i = 0 ; i < list.size(); i++) {
    				tempVO = (FAXEmailByPayerVO)list.get(i);
    				
    				if(StringUtils.trimToEmpty(tempVO.getFax()).equals(""))
    					continue;
    				
    				if(fax_cnt > 0)
    					sb_fax.append(";");
    				
    				sb_fax.append(StringUtils.trimToEmpty(tempVO.getFax()));
    				fax_cnt++;
    			}
    		}
    		fax = sb_fax.toString();
    		
    		log.debug("----------------email->"+email+"<<");
    		log.debug("----------------fax->"+fax+"<<");
    		
    		refAXEmailByPayerVO.setEmailNos(email);
    		refAXEmailByPayerVO.setFaxNos(fax);
    		
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        return refAXEmailByPayerVO;
    	
    }
    
    /**
     * INVOICE RD占쏙옙manual invoice MASTER 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws EventException
     */
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreview(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException {
    	InvoiceIssueMasterPreviewVO reInvoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();
    	List<InvoiceIssueVO> invoiceIssueList	= null;
		IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
    	
    	try {
    		reInvoiceIssueMasterPreviewVO = dbDao.searchInvoiceIssueMasterPreview(invoiceIssueRDParamVO);
    		
    		if ("4002".equals(invoiceIssueRDParamVO.getJspno()))	{
    			issuedInvoiceParamVO.setSInvoiceNo(invoiceIssueRDParamVO.getInvoiceNo());
    			issuedInvoiceParamVO.setOfcCd(invoiceIssueRDParamVO.getCreOfcCd());
    			double tot_sub_amt = 0;
                //Discount Amount + Exception Amount > 0
                double dScRfaExptAmt = 0;
                double dAftExptDcAmt = 0;
                double dCmdtExptAmt  = 0;
                
                double tot_amt = 0;
                double discount_amt = 0;

    			
    			//detail 鈺곌퀬��
    			invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
    			
    			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
    				InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
    				
    				//OVER DAY鈺곌퀬��
    				OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
                    overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
                    overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
                    overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
                    overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
                    overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
                    overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
                    
                    //DivOverDay 鈺곌퀬��
                    OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);            	
                	
                    String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
    				
    				CalculationParmVO calculationParmVO = new CalculationParmVO();
    				calculationParmVO.setDcApplRate(trfAplyTpCd);
    				calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
    				calculationParmVO.setFtDys(invoiceIssueVO.getFtDys());					// 2014.03.12
					calculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd());		// 2014.03.12
					calculationParmVO.setOrgFtOvrDys(invoiceIssueVO.getOrgFtOvrDys());		// 2014.03.12
					
					calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
    				/*
    				Charge占쏙옙占쎄낯�쒙옙占폯ariff占쏙옙占쎄퀡��Charge疫뀀뜆釉몌옙占썸�袁⑷텦占쎌뮆��
    			    A) "G"(Basic Tariff)占쏙옙野껋럩��Basic Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�뺣뼄
    			    B) "B"(Before Exception)占쏙옙野껋럩��Before Exception Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�랁� Before Exception占쏙옙Currency�쒙옙鈺곌퀬�띰옙�뺣뼄
    			    C) "S"(S/C Exception)占쏙옙野껋럩��S/C Exception Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�랁� S/C Exception占쏙옙Currency�쒙옙鈺곌퀬�띰옙�뺣뼄
    			    D) Charge占쏙옙占쎄낯�쒙옙占폚urrency占쏙옙A), B), C)占쎈Ŋ苑��④쑴沅쏉옙占폚urrency揶쏉옙占썬끇�ⓨ칰�뚯뒭
    			         1) 占쎄낯�쒙옙占폚urrencyExchange Rate�쒙옙鈺곌퀬�띰옙�뤿연 Charge �④쑴沅쎿묾�됰만占쏙옙Exchange Rate�쒙옙�④퉲釉놂옙占�
    			         2) 1)占쎈Ŋ苑��④쑴沅쏉옙占썸묾�됰만占쏙옙Currency癰귢쑬以�獄쏆꼷�긺뵳�깆퓗�깍옙占쎌뮆��
    				*/
    				if ("G".equals(trfAplyTpCd)) {
    					String firstSvrID = null;
    					
    					//office transfer check
    	            	if ("Y".equals(invoiceIssueVO.getOfcTrnsFlg())) {
    	            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
    	            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
    	            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
    	            		chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
    	            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
    	            		chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
    	            		chargeCalculationParmVO.setBkgNo(invoiceIssueVO.getBkgNo());
    	            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
    	            	
    	    				log.debug(" iss searchInvoiceIssueMasterPreview FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		

    	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
    	            	} 
    	            	else {
    	            		firstSvrID = invoiceIssueVO.getSvrId();
    	            	}
    					
    					// basicCalculation - Baisc Tariff
    					calculationParmVO.setSvrId(firstSvrID);
    					calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
    					calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
    					calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
    					calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
    					calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());			// 2014.03.12    					
    					if (!"".equals(invoiceIssueVO.getScRfaExptAplyDt())) {	// 2014.03.12
    						calculationParmVO.setDmdtTrfAplyTpCd("B");				// 獄쎻뫕占쏙옙�곕쑓占쏙옙嚥≪뮇彛�占쎈슢揆占쏙옙�곕떽占� ("B" 占쎈Ŧ��"S"嚥∽옙占쏙퐡由곤쭖占쏙옙占�
        					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());		// 2014.03.12
    					}
    				} 
    				else if ("B".equals(trfAplyTpCd)) {
    					// beforeCalculation - Before BKG Exception
    					calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
    					calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
    					calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
    					calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
    					calculationParmVO.setCmbSeq("1");
    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());		// 2014.03.12    					
    				} 
    				else if ("S".equals(trfAplyTpCd)) {
    					// scCalculation - SC Exception
    					calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
    					calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
    					calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());		// 2014.03.12
    				} 
    				
    				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
    	            
    	            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
    	            String rateCurrCd = calculationAMTVO.getRateCurCd();
    	            ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
    	            double rtExchangeRate 	= 0;
    	            double amount			= 0;
    	            
    	            if (chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
    	            	//addInvoiceRate
                    	for ( int j = 0; j < chrgDtlVOS.size() ; j++) {
    	                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(j);
    	                    
    	                    //over_day > 0 占쏙옙野껋럩��쭕占쏙옙占쎌삢占쎌뮆��
    	                    if (Double.parseDouble(chrgDtlVO.getRtDay()) == 0) continue;
    	                    
    	                    //rate CurrCd占쏙옙charge CurrCd揶쏉옙占썬끇�ㅿ쭖占퐎ateCrrCd�쒙옙�④퉲鍮먲옙占폺harge amt�쒙옙�닌뗫립占쏙옙
    	                    if (!rateCurrCd.equals(invoiceIssueVO.getBzcTrfCurrCd())) {
    	                    	exchangeRateParmVO = new ExchangeRateParmVO();
    		                    
    		                    exchangeRateParmVO.setVslCd(reInvoiceIssueMasterPreviewVO.getRdVvdCd().substring(0,4));
    		                    exchangeRateParmVO.setSkdVoyageNo(reInvoiceIssueMasterPreviewVO.getRdVvdCd().substring(4,8));
    		                    exchangeRateParmVO.setSkdDirCd(reInvoiceIssueMasterPreviewVO.getRdVvdCd().substring(8));
    		                    exchangeRateParmVO.setIoBnd(reInvoiceIssueMasterPreviewVO.getRdDmdtTrfCd().substring(2,3));
    		                    exchangeRateParmVO.setPolLoc(reInvoiceIssueMasterPreviewVO.getPolCd());
    		                    exchangeRateParmVO.setPodLoc(reInvoiceIssueMasterPreviewVO.getPodCd()); 
    		                    exchangeRateParmVO.setFmCurCd(rateCurrCd);										//rate currency
    		                    exchangeRateParmVO.setToCurCd(reInvoiceIssueMasterPreviewVO.getRdOrgCurrCd());	//chg currency
    		                    exchangeRateParmVO.setOfcCd(invoiceIssueVO.getChgOfcCd());						//charge office
    		                    
    		                    rtExchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
        	    				amount = Double.parseDouble(chrgDtlVO.getRtChrg());
    		            		
        	    				amount = rtExchangeRate * amount;
    		                    
    		                    log.debug("---rate Currency -->"+rateCurrCd);
    		                    log.debug("---rate Exchange Rate-->"+rtExchangeRate);
    		                    log.debug("---amount-->"+amount);
    	                    } 
    	                    else {
    	                    	amount = Double.parseDouble(chrgDtlVO.getRtChrg());
    	                    }
    	                    
    	    				tot_sub_amt += amount;
                    	}
    	            }
    	            dScRfaExptAmt += Double.parseDouble(invoiceIssueVO.getExptAmt());
                    dAftExptDcAmt += Double.parseDouble(invoiceIssueVO.getAftExptDcAmt());
                    dCmdtExptAmt  += Double.parseDouble(invoiceIssueVO.getCmdtExptAmt());
    			}
    			
    			tot_sub_amt = dmtCalculationUtil.trimCurrencyAmount(reInvoiceIssueMasterPreviewVO.getRdOrgCurrCd(), tot_sub_amt);
    			if(reInvoiceIssueMasterPreviewVO.getRdDmdtInvStsCd().equals("C")){	//Credit Note
    				tot_sub_amt = tot_sub_amt * (-1);
    			}
    			reInvoiceIssueMasterPreviewVO.setRdOrgChgAmt(JSPUtil.toDecimalFormat(tot_sub_amt,"#,##0.00"));
    			
    			log.debug("--exRate-->"+reInvoiceIssueMasterPreviewVO.getRdInvXchRt());
    			//�곕떽占�TOT_AMT 占쎌꼷��
    			tot_amt = tot_sub_amt * Double.parseDouble(reInvoiceIssueMasterPreviewVO.getRdInvXchRt());
    			reInvoiceIssueMasterPreviewVO.setRdTotAmt(JSPUtil.toDecimalFormat(tot_amt,"#,##0.00"));
    			
    			log.debug("--inv_chg_amt-->"+reInvoiceIssueMasterPreviewVO.getRdInvChgAmt());
    			//DISCOUNT AMT 占쎌꼷��
    			discount_amt = tot_amt - Double.parseDouble(JSPUtil.replace(reInvoiceIssueMasterPreviewVO.getRdInvChgAmt(), ",", ""));// number type占쏙옙占쎄쑬�귨옙�곗쨮 占쎈Ŧ��옙占�
    			reInvoiceIssueMasterPreviewVO.setRdDcAmt(JSPUtil.toDecimalFormat(discount_amt,"#,##0.00"));
    		}
    	} catch(DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
    	return reInvoiceIssueMasterPreviewVO;
    }
    
    /**
     * INVOICE RD占쏙옙incCntlDtail 揶쏅���No 占쏙옙manual invoice MASTER 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws EventException
     */
    
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreviewNo(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException {
    	InvoiceIssueMasterPreviewVO reInvoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();

    	try {
    		reInvoiceIssueMasterPreviewVO = dbDao.searchInvoiceIssueMasterPreviewNo(invoiceIssueRDParamVO);
    	} 
    	catch(DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
    	
    	return reInvoiceIssueMasterPreviewVO;
    }
    
    /**
     * INVOICE RD占쏙옙invoice DETAIL 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return String
     * @throws EventException
     */
    public String searchInvoiceIssueRD(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException {
    	log.debug("=================> [BCImpl]searchInvoiceIssueRD");
    	StringBuffer textForRD = new StringBuffer();
		String dl = "|&&|";
		List<InvoiceIssueRDPreviewVO> list = null;
		InvoiceIssueRDPreviewVO invoiceIssueRDPreviewVO = new InvoiceIssueRDPreviewVO();
		List<InvoiceIssueVO> invoiceIssueList	= null;
		String cancel_yn =  "";
		String invoice_status = "";
    	
    	try {
    		
    		
    		if(invoiceIssueRDParamVO.getJspno().equals("4002")) {
    			//2011.02.24 invoice status 筌ｋ똾寃�
    			invoice_status = dbDao.searchInvoiceStatus(invoiceIssueRDParamVO.getInvoiceNo(), invoiceIssueRDParamVO.getCreOfcCd());
    			if(invoice_status.equals("X") || invoice_status.equals("C")){
    				log.debug("------------------------0---------------------");
        			list = dbDao.searchInvoiceIssueManualRD(invoiceIssueRDParamVO);
        			log.debug("------------------------1---------------------");
        			for(int i = 0 ; i < list.size() ; i++) {
            			log.debug("------------------------2---------------------"+i);
        				invoiceIssueRDPreviewVO = (InvoiceIssueRDPreviewVO)list.get(i);
        				textForRD.append(invoiceIssueRDPreviewVO.getCntrNo() + dl); 			//CNTR
        				textForRD.append(invoiceIssueRDPreviewVO.getCntrTpszCd() + dl); 		//TS
        				
        				int dFmMvmtDt = Integer.parseInt(invoiceIssueRDPreviewVO.getFmMvmtDt());
//        				int dToMvmtDt = Integer.parseInt(invoiceIssueRDPreviewVO.getToMvmtDt());
//        				int dFtCmncDt = Integer.parseInt(invoiceIssueRDPreviewVO.getFtCmncDt());
        				String sFtCmncDt = invoiceIssueRDPreviewVO.getFtCmncDt();
        				//int dFtEndDt  = Integer.parseInt(invoiceIssueRDPreviewVO.getFtEndDt());

        				int dFtEndDt = 99991231; //dFmMvmtDt 占쏙옙��쑨���븝옙�뉛옙���옙占쏙옙袁⑸뻻嚥∽옙setting占쏙옙
        				String sFtEndDt  = invoiceIssueRDPreviewVO.getFtEndDt();
        				//log.debug("<ftEndDt   check>======11111======"+sFtEndDt+"<<");
        				if (sFtEndDt.length() > 0){
        					dFtEndDt  = Integer.parseInt(invoiceIssueRDPreviewVO.getFtEndDt());
        				}
        					
//        				textForRD.append(dFmMvmtDt + dl); 			//FROM
//        				textForRD.append(dToMvmtDt + dl); 			//TO
//        				
           				textForRD.append(invoiceIssueRDPreviewVO.getFmMvmtDt() + dl); 			//FROM
        				textForRD.append(invoiceIssueRDPreviewVO.getToMvmtDt() + dl); 			//TO       				
        				
        				
        				//Cancel 占쎄낱源�옙占썲칰�뚯뒭
        				if(dFtEndDt < dFmMvmtDt) {
        					log.debug("<1>"+sFtEndDt+":"+sFtCmncDt+"<<");
        					textForRD.append("" + dl); 			//CMNC
        					textForRD.append("" + dl); 			//CMPLT
        				}else{
        					log.debug("<2>"+sFtEndDt+":"+sFtCmncDt+"<<");
        					textForRD.append(sFtCmncDt + dl); 			//CMNC
        					textForRD.append(sFtEndDt + dl); 			//CMPLT
        				}

        				//cancel占쎄낱源�占쎈���
//        				if(cancel_yn.equals("Y")){
//    	    				textForRD.append("" + dl); 			//CMNC
//    	    				textForRD.append("" + dl); 			//CMPLT
//        				}else{
//        					textForRD.append(StringUtils.replace(invoiceIssueRDPreviewVO.getFtCmncDt(),"-", "") + dl); 			//CMNC
//        					textForRD.append(StringUtils.replace(invoiceIssueRDPreviewVO.getFtEndDt(),"-", "") + dl); 			//CMPLT
//        				}
        				
        				textForRD.append(invoiceIssueRDPreviewVO.getFtDys() + dl); 				//FREE DAY
        				textForRD.append(invoiceIssueRDPreviewVO.getFtOvrUndDys() + dl); 		//DAYS
        				textForRD.append(invoiceIssueRDPreviewVO.getInvRtAmt() + dl); 			//RATE
        				textForRD.append(invoiceIssueRDPreviewVO.getRtOvrDys() + dl); 			//OVER DAY
        				textForRD.append(invoiceIssueRDPreviewVO.getInvAmount() + dl); 			//AMOUNT
        				textForRD.append(invoiceIssueRDPreviewVO.getChgCurrCd() + dl + "\n"); 	//CUR
        			}
    			}else{
    			
	        		cancel_yn = dbDao.checkInvoiceCancel(invoiceIssueRDParamVO.getInvoiceNo(), invoiceIssueRDParamVO.getCreOfcCd());	//Invoice Cancel占쎄낱源�占싼됵옙
	
	        		IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
	    			issuedInvoiceParamVO.setSInvoiceNo(invoiceIssueRDParamVO.getInvoiceNo());
	    			issuedInvoiceParamVO.setOfcCd(invoiceIssueRDParamVO.getCreOfcCd());
	    			
	    			//detail 鈺곌퀬��
	    			invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
	    			
	    			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
	    				InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
	    				
	    				//OVER DAY鈺곌퀬��
	    				OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
	                    overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
	                    overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
	                    overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
	                    overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
	                    overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
	                    overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
	                    
	                    // DivOverDay 鈺곌퀬��
	                    OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);            	
	                	
	                    String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
	    				
	    				CalculationParmVO calculationParmVO = new CalculationParmVO();
	    				calculationParmVO.setDcApplRate(trfAplyTpCd);
	    				calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
    					calculationParmVO.setFtDys(invoiceIssueVO.getFtDys());					// 2014.03.12
    					calculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd());		// 2014.03.12
    					calculationParmVO.setOrgFtOvrDys(invoiceIssueVO.getOrgFtOvrDys());		// 2014.03.12
    					
    					calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
    					
	    				/*
	    				Charge占쏙옙占쎄낯�쒙옙占폯ariff占쏙옙占쎄퀡��Charge疫뀀뜆釉몌옙占썸�袁⑷텦占쎌뮆��
	    			    A) "G"(Basic Tariff)占쏙옙野껋럩��Basic Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�뺣뼄
	    			    B) "B"(Before Exception)占쏙옙野껋럩��Before Exception Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�랁� Before Exception占쏙옙Currency�쒙옙鈺곌퀬�띰옙�뺣뼄
	    			    C) "S"(S/C Exception)占쏙옙野껋럩��S/C Exception Tariff占쏙옙Rate癰귨옙�④쑴沅쎿묾�됰만占쏙옙鈺곌퀬�띰옙�랁� S/C Exception占쏙옙Currency�쒙옙鈺곌퀬�띰옙�뺣뼄
	    			    D) Charge占쏙옙占쎄낯�쒙옙占폚urrency占쏙옙A), B), C)占쎈Ŋ苑��④쑴沅쏉옙占폚urrency揶쏉옙占썬끇�ⓨ칰�뚯뒭
	    			         1) 占쎄낯�쒙옙占폚urrencyExchange Rate�쒙옙鈺곌퀬�띰옙�뤿연 Charge �④쑴沅쎿묾�됰만占쏙옙Exchange Rate�쒙옙�④퉲釉놂옙占�
	    			         2) 1)占쎈Ŋ苑��④쑴沅쏉옙占썸묾�됰만占쏙옙Currency癰귢쑬以�獄쏆꼷�긺뵳�깆퓗�깍옙占쎌뮆��
	    				*/
	    				if(trfAplyTpCd.equals("G")) {
	    					String firstSvrID = null;
	    					
	    					//office transfer check
	    	            	if(invoiceIssueVO.getOfcTrnsFlg().equals("Y")){
	    	            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	    	            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
	    	            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueVO.getDmdtChgLocDivCd());
	    	            		chargeCalculationParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
	    	            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueVO.getCntrCycNo());
	    	            		chargeCalculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
	    	            		chargeCalculationParmVO.setBkgNo(invoiceIssueVO.getBkgNo());
	    	            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueVO.getFmMvmtYdCd()); //2011.10.28
	    	            	
	    	    				log.debug(" iss searchInvoiceIssueRD  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
	
	    	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	    	            	}else{
	    	            		firstSvrID = invoiceIssueVO.getSvrId();
	    	            	}
	    					
	    					// basicCalculation - Baisc Tariff
	    					calculationParmVO.setSvrId(firstSvrID);
	    					calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
	    					calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
	    					calculationParmVO.setDmdtDeTermCd(invoiceIssueVO.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
	    					calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
	    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	    					calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
	    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getBzcTrfAplyDt());			// 2014.03.12
	    					if (!"".equals(invoiceIssueVO.getScRfaExptAplyDt())) {		// 2014.03.12
	    						calculationParmVO.setDmdtTrfAplyTpCd("B");								// 獄쎻뫕占쏙옙�곕쑓占쏙옙嚥≪뮇彛�占쎈슢揆占쏙옙�곕떽占� ("B" 占쎈Ŧ��"S"嚥∽옙占쏙퐡由곤쭖占쏙옙占�
		    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());	// 2014.03.12
	    					} 
	    				} else if(trfAplyTpCd.equals("B")) {
	    					// beforeCalculation - Before BKG Exception
	    					calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
	    					calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
	    					calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
	    					calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
	    					calculationParmVO.setCmbSeq("1");
	    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());	// 2014.03.12
	    				} else if(trfAplyTpCd.equals("S")) {
	    					// scCalculation - SC Exception
	    					calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
	    					calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
	    					calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
	    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	    					calculationParmVO.setTrfAplyDt(invoiceIssueVO.getScRfaExptAplyDt());	// 2014.03.12
	    				}                    
	                    
	    				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
	    	            
	    	            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
	    	            String rateCurrCd = calculationAMTVO.getRateCurCd();
	                    
	    	            if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
	    	            	//addInvoiceRate
	                    	for ( int j = 0; j < chrgDtlVOS.size() ; j++) {
	    	                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(j);
	    	                    
	    	                    //over_day > 0 占쏙옙野껋럩��쭕占쏙옙占쎌삢占쎌뮆��
	    	                    if(Double.parseDouble(chrgDtlVO.getRtDay()) == 0 ) {
	    	                    	continue;
	    	                    }
	    	                    
	    	    				invoiceIssueRDPreviewVO = new InvoiceIssueRDPreviewVO();
	    	    				invoiceIssueRDPreviewVO.setCntrNo(invoiceIssueVO.getCntrNo());			
	    	    				invoiceIssueRDPreviewVO.setCntrTpszCd(invoiceIssueVO.getCntrTpszCd());	
	    	    				invoiceIssueRDPreviewVO.setFmMvmtDt(StringUtils.replace(invoiceIssueVO.getFmMvmtDt(), "-", ""));		
	    	    				invoiceIssueRDPreviewVO.setToMvmtDt(StringUtils.replace(invoiceIssueVO.getToMvmtDt(), "-", ""));		
	    	    				invoiceIssueRDPreviewVO.setFtCmncDt(StringUtils.replace(invoiceIssueVO.getFtCmncDt(), "-", ""));		
	    	    				invoiceIssueRDPreviewVO.setFtEndDt(StringUtils.replace(invoiceIssueVO.getFtEndDt(), "-", ""));		
	    	    				invoiceIssueRDPreviewVO.setFtDys(invoiceIssueVO.getFtDys());			
	    	    				
	    	    				//
	    	    				invoiceIssueRDPreviewVO.setFtOvrUndDys(chrgDtlVO.getRtOver() + "-" + chrgDtlVO.getRtUnder());
	    	    				invoiceIssueRDPreviewVO.setRtOvrDys(chrgDtlVO.getRtDay());
	
	    	    				//rate
	    	    				double rt_rate = Double.parseDouble(chrgDtlVO.getRtRate());
	    	    				invoiceIssueRDPreviewVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_rate,"#.##"));
	    	    				
	    	    				double amount = Double.parseDouble(chrgDtlVO.getRtChrg());
	    	    				dmtCalculationUtil.trimCurrencyAmount(rateCurrCd, amount);
	    	    				invoiceIssueRDPreviewVO.setInvAmount(JSPUtil.toDecimalFormat(amount,"#.##"));
	    	    				invoiceIssueRDPreviewVO.setChgCurrCd(rateCurrCd);
	    	    				
	    	    				//
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getCntrNo() + dl); 			//CNTR
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getCntrTpszCd() + dl); 		//TS
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getFmMvmtDt() + dl); 			//FROM
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getToMvmtDt() + dl); 			//TO
	    	    				//cancel占쎄낱源�占쎈���
	    	    				if(cancel_yn.equals("Y") 
	    	    						&& invoiceIssueVO.getFtDys().equals("0") 
	    	    						&& !invoiceIssueVO.getSvrId().equals("KOR")){
	        	    				textForRD.append("" + dl); 			//CMNC
	        	    				textForRD.append("" + dl); 			//CMPLT
	    	    				}else{
	        	    				textForRD.append(invoiceIssueRDPreviewVO.getFtCmncDt() + dl); 			//CMNC
	        	    				textForRD.append(invoiceIssueRDPreviewVO.getFtEndDt() + dl); 			//CMPLT
	    	    				}
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getFtDys() + dl); 				//FREE DAY
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getFtOvrUndDys() + dl); 		//DAYS
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getInvRtAmt() + dl); 			//RATE
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getRtOvrDys() + dl); 			//OVER DAY
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getInvAmount() + dl); 			//AMOUNT
	    	    				textForRD.append(invoiceIssueRDPreviewVO.getChgCurrCd() + dl + "\n"); 	//CUR	  
	    	    				
	                    	}
	    	            }
	                    //** end of rt **//
	    			}
    			}
    		}else{
    			log.debug("------------------------0---------------------");
    			list = dbDao.searchInvoiceIssueManualRD(invoiceIssueRDParamVO);
    			log.debug("------------------------1---------------------");
    			for(int i = 0 ; i < list.size() ; i++) {
        			log.debug("------------------------2---------------------"+i);
    				invoiceIssueRDPreviewVO = (InvoiceIssueRDPreviewVO)list.get(i);
    				textForRD.append(invoiceIssueRDPreviewVO.getCntrNo() + dl); 			//CNTR
    				textForRD.append(invoiceIssueRDPreviewVO.getCntrTpszCd() + dl); 		//TS
    				
    				int dFmMvmtDt = Integer.parseInt(invoiceIssueRDPreviewVO.getFmMvmtDt());
//   				int dToMvmtDt = Integer.parseInt(invoiceIssueRDPreviewVO.getToMvmtDt());
//    				int dFtCmncDt = Integer.parseInt(invoiceIssueRDPreviewVO.getFtCmncDt());
    				String sFtCmncDt = invoiceIssueRDPreviewVO.getFtCmncDt();
//    				int dFtEndDt  = Integer.parseInt(invoiceIssueRDPreviewVO.getFtEndDt());
    				
    				int dFtEndDt = 99991231; //dFmMvmtDt 占쏙옙��쑨���븝옙�뉛옙���옙占쏙옙袁⑸뻻嚥∽옙setting占쏙옙
    				
    				String sFtEndDt  = invoiceIssueRDPreviewVO.getFtEndDt();
//    				log.debug("<ftEndDt   check>======11111======"+sFtEndDt+"<<");
    				if (sFtEndDt.length() > 0){
    					dFtEndDt  = Integer.parseInt(invoiceIssueRDPreviewVO.getFtEndDt());
    				}
	
       				textForRD.append(invoiceIssueRDPreviewVO.getFmMvmtDt() + dl); 			//FROM
    				textForRD.append(invoiceIssueRDPreviewVO.getToMvmtDt() + dl); 			//TO   			
   				
    				
    				//Cancel 占쎄낱源�옙占썲칰�뚯뒭
    				if(dFtEndDt < dFmMvmtDt) {
    					log.debug("<1>"+sFtEndDt+":"+sFtCmncDt+"<<");
    					textForRD.append("" + dl); 			//CMNC
    					textForRD.append("" + dl); 			//CMPLT
    				}else{
    					log.debug("<2>"+sFtEndDt+":"+sFtCmncDt+"<<");
    					textForRD.append(sFtCmncDt + dl); 			//CMNC
    					textForRD.append(sFtEndDt + dl); 			//CMPLT
    				}

    				//cancel占쎄낱源�占쎈���
//    				if(cancel_yn.equals("Y")){
//	    				textForRD.append("" + dl); 			//CMNC
//	    				textForRD.append("" + dl); 			//CMPLT
//    				}else{
//    					textForRD.append(StringUtils.replace(invoiceIssueRDPreviewVO.getFtCmncDt(),"-", "") + dl); 			//CMNC
//    					textForRD.append(StringUtils.replace(invoiceIssueRDPreviewVO.getFtEndDt(),"-", "") + dl); 			//CMPLT
//    				}
    				
    				textForRD.append(invoiceIssueRDPreviewVO.getFtDys() + dl); 				//FREE DAY
    				textForRD.append(invoiceIssueRDPreviewVO.getFtOvrUndDys() + dl); 		//DAYS
    				textForRD.append(invoiceIssueRDPreviewVO.getInvRtAmt() + dl); 			//RATE
    				textForRD.append(invoiceIssueRDPreviewVO.getRtOvrDys() + dl); 			//OVER DAY
    				textForRD.append(invoiceIssueRDPreviewVO.getInvAmount() + dl); 			//AMOUNT
    				textForRD.append(invoiceIssueRDPreviewVO.getChgCurrCd() + dl + "\n"); 	//CUR
    			}
    		}
    		
    	} catch(DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        
        log.debug("\n[data]"+textForRD.toString());
        return textForRD.toString();
    }
    
    /**
     * AR-IF 占쏙옙EDI嚥∽옙占쎄쑴�싷옙占쏙옙怨쀬뵠占쎄퀡占�鈺곌퀬�띰옙�뺣뼄.<br>
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<EDIContainerVO>
     * @throws EventException
     */
    public List<EDIContainerVO> searchEDIContainerInfoByInvoice(String invoiceNo, String creOfcCd) throws EventException {
    	List<EDIContainerVO> eDIContainerVOs   = null;
    	try{
	    	// searchVVDCheckData
    		eDIContainerVOs = dbDao.searchEDIContainerInfoByInvoice(invoiceNo, creOfcCd);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        return eDIContainerVOs;
    }
    
    /**
 	 * SZPBB�쒙옙占쎈벏鍮�INVOICE 占쎌빘苑�占싼됵옙 占쎈벡��
 	 * 
 	 * @param String invoiceNo
 	 * @return String
 	 * @throws DAOException
 	 */
    public String checkSZPBBInvoice(String invoiceNo) throws EventException {
    	String suth_chn_iss_flg = "";
    	try{
    		suth_chn_iss_flg = dbDao.checkSZPBBInvoice(invoiceNo);
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
    	
    	return suth_chn_iss_flg;
    }
    
    /**
 	 * 占쎈���Back End Job占쏙옙占썬끋六억옙�쀪텚占쏙옙
 	 * 
 	 * @param InvoiceGroupParamVO invoiceGroupParamVO
 	 * @param ConfirmChargeListVO[] confirmChargeListVOs
 	 * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
    public String doBackEndJob(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException {
		try {
			InvoiceIssueCollectionMgtBackEndJob	backEndJob	= new InvoiceIssueCollectionMgtBackEndJob();
			BackEndJobManager			backEndJobManager 	= new BackEndJobManager();
			
			String backendjobId = invoiceGroupParamVO.getBackendjobId();
			
			//BackEndJob 筌ｌ꼶�곭몴占쏙옙袁る퉸占쏙옙占쎄쑴�귨옙占쏙옙類ｋ궖�쒙옙筌띲끆而삭퉪占쎈땾嚥∽옙占썬끉�숋옙�곻옙占쏙옙
			backEndJob.setJobCommand(backendjobId);
			backEndJob.setInvoiceGroupParamVO(invoiceGroupParamVO);
			backEndJob.setConfirmChargeListVOs(confirmChargeListVOs);
			backEndJob.setSignOnUserAccount(account);
			
			String jobMessage = "DMT " + backendjobId + " Back End";
			
			//BackEndJob 筌뤴뫀諭�옙占쏙옙紐꾪뀱占쎌뮆��
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), jobMessage);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"execute group invoice save backend job"}).getMessage());
		}
    }
    
	/**
	 * 占쎈���Back End Job占쏙옙占쎄낱源�몴占썹뵳�苑⑼옙�뺣뼄.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException {
		DBRowSet rowSet;
		try {
			String[] result = new String[2];
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			
			if(rowSet.next()) {
				//Thread.sleep(1000);
				result[0] = rowSet.getString("jb_sts_flg");
				result[1] = rowSet.getString("jb_usr_err_msg");
			}
			return result;
		} catch(Exception e){
			log.error("[Exception]"+e.getMessage());
			throw new EventException(new ErrorHandler("DMT0006", new String[]{"BackEndJob Status"}).getUserMessage(),e);
		}
	}    
	
 	/**
 	 * AR-IF 筌욊낯��INVOICE占쏙옙占쏙옙釉�AR-IF 占썬끋六�占싼됵옙 筌ｋ똾寃�
 	 * @param String[] invoiceNos
 	 * @param String creOfcCd
 	 * @param String flg
 	 * @return List<String>
 	 * @throws EventException
 	 */
	public List<String> searchARIFCount(String[] invoiceNos, String creOfcCd, String flg) throws EventException {
		List<String> invoiceNoList = new ArrayList<String>();
    	try{
    		invoiceNoList = dbDao.searchARIFCount(invoiceNos, creOfcCd, flg);
    	} catch (DAOException ex) {
    		log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
    	
    	return invoiceNoList;		
	}
	
	/**
	 * [ 삭제 대상 메소드 ]
	 * Group Invoice占쏙옙Detail 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
	 *
	 * @param InvoiceGroupParamVO invoiceGroupParamVO
	 * @param ConfirmChargeListVO[] confirmChargeListVOs
	 * @return List<VVDCheckDataVO>
	 * @exception EventException
	 */
	public List<VVDCheckDataVO> searchChargeBookingGroupInvoiceVVDDetail(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs) throws EventException {
		List<VVDCheckDataVO> vVDCheckDataList   = null;
		IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
		List<InvoiceIssueVO> invoiceIssueVOList = null;
		boolean chg_loc_div_cd_flag = false;
		
		try{
			vVDCheckDataList = new ArrayList<VVDCheckDataVO>();
			
			if(invoiceGroupParamVO.getSGroupBy().equals("1")){//Group by (B/L No(BKG No))
			
				//Grid占쏙옙Bkg占쏙옙鈺곌퀬�띰옙�뺣뼄.
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//筌ｋ똾寃뺟몴占쏙옙�륅옙 占쎈봿�앾쭖占쏙옙�쎄땁
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                
	                //charge detail占쎈베�ョ몴占썼�怨좎돳占쎌뮆��		s_dmdt_trf_cd, s_bkg_no, s_ofc_cd, s_chg_type, dmdt_chg_sts_cd
	                issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	                issuedInvoiceParamVO.setSChgType("");
	                issuedInvoiceParamVO.setDmdtChgStsCds("C");
	                
	                invoiceIssueVOList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	                
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	                
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                //DMDT_CHG_LOC_DIV_CD占쏙옙揶쏅���'TSP', 'SZP' 揶쏉옙占쎄쑬�뀐쭖占�searchVVDNEta�쒙옙CALL占쎌꼷肉�VVD CD�쒙옙Setting占쎌뮆��
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                for(int j = 0 ; j < invoiceIssueVOList.size() ;  j++) {
	                	InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueVOList.get(j);
	                	if(invoiceIssueVO.getDmdtChgLocDivCd().equals("TSP") || invoiceIssueVO.getDmdtChgLocDivCd().equals("SZP")) {
	                		chg_loc_div_cd_flag = true;
	                		break;
	                	}
	                }
	                if(!chg_loc_div_cd_flag) {
	                	//占썬끉��UPDATE占쏙옙vvd_check_data
                		vVDCheckDataVO = dbDao.searchVVDCheckData(issuedInvoiceParamVO, "2");
                		if(!vVDCheckDataVO.getBkgNo().equals("")){
                			vVDCheckDataList.add(vVDCheckDataVO);
                		}
	                }
				}
			}else{
				//Grid占쏙옙Cntr占쏙옙鈺곌퀬�띰옙�뺣뼄.
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//筌ｋ똾寃뺟몴占쏙옙�륅옙 占쎈봿�앾쭖占쏙옙�쎄땁
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	            	
	            	issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	            	
	            	///////////////////////////////////////////////////////////////////////////////////////////////
	                //DMDT_CHG_LOC_DIV_CD占쏙옙揶쏅���'TSP', 'SZP' 揶쏉옙占쎄쑬�뀐쭖占�searchVVDNEta�쒙옙CALL占쎌꼷肉�VVD CD�쒙옙Setting占쎌뮆��
	                ///////////////////////////////////////////////////////////////////////////////////////////////
                	if(confirmChargeListVOs[i].getDmdtChgLocDivCd().equals("TSP") || confirmChargeListVOs[i].getDmdtChgLocDivCd().equals("SZP")) {
                		continue;
                	}else{
                		//占썬끉��UPDATE占쏙옙vvd_check_data
                		vVDCheckDataVO = dbDao.searchVVDCheckData(issuedInvoiceParamVO, "2");
                		if(!vVDCheckDataVO.getBkgNo().equals("")){
                			vVDCheckDataList.add(vVDCheckDataVO);
                		}
                		
                	}
				}
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
    	
    	return vVDCheckDataList;	
		
	}
	
	/**
	 * CalculationUtil占쏙옙searchVVDNEta 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
	 *
	 * @param VVDCheckDataVO vVDCheckDataVO
	 * @return VVDNEtaVO
	 * @exception EventException
	 */
    public VVDNEtaVO searchIssueInvoiceVVD(VVDCheckDataVO vVDCheckDataVO) throws EventException {
		VVDNEtaVO vVDNEtaVO = new VVDNEtaVO();
		try{
			// searchVVDNEta
            vVDNEtaVO = dmtCalculationUtil.searchVVDNEta(vVDCheckDataVO.getBkgNo(), vVDCheckDataVO.getPolCd(), vVDCheckDataVO.getPodCd(), vVDCheckDataVO.getIoBnd());

		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"searchIssueInvoiceVVD"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"searchIssueInvoiceVVD"}).getMessage());
		}
		return vVDNEtaVO;
    }
    
	/**
	 * [ 삭제 대상 메소드 ]
	 * CalculationUtil占쏙옙searchVVDNEta 占쎈베�ョ몴占썼�怨좎돳占쎌꼷肉�占쎈뜄以덌옙占폲VD揶쏅���占쎈뿮�울옙�뤿연 占쎌꼵爰쇌빳占쎈뼄.
	 *
	 * @param InvoiceGroupParamVO invoiceGroupParamVO
	 * @param ConfirmChargeListVO[] confirmChargeListVOs
	 * @return ConfirmChargeListVO[]
	 * @exception EventException
	 */
    public ConfirmChargeListVO[] searchIssueInvoiceByGroupVVD(InvoiceGroupParamVO invoiceGroupParamVO, ConfirmChargeListVO[] confirmChargeListVOs) throws EventException {
    	ConfirmChargeListVO[] reConfirmChargeListVOs = null;
		IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
		List<InvoiceIssueVO> invoiceIssueVOList = null;
		boolean chg_loc_div_cd_flag = false;
		
		try{
			if(invoiceGroupParamVO.getSGroupBy().equals("1")){//Group by (B/L No(BKG No))
				
				//Grid占쏙옙Bkg占쏙옙鈺곌퀬�띰옙�뺣뼄.
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//筌ｋ똾寃뺟몴占쏙옙�륅옙 占쎈봿�앾쭖占쏙옙�쎄땁
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                
	                issuedInvoiceParamVO = new IssuedInvoiceParamVO();
	                //charge detail占쎈베�ョ몴占썼�怨좎돳占쎌뮆��		s_dmdt_trf_cd, s_bkg_no, s_ofc_cd, s_chg_type, dmdt_chg_sts_cd
	                issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	                issuedInvoiceParamVO.setSChgType("");
	                issuedInvoiceParamVO.setDmdtChgStsCds("C");
	                invoiceIssueVOList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	                
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	                
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                //DMDT_CHG_LOC_DIV_CD占쏙옙揶쏅���'TSP', 'SZP' 揶쏉옙占쎄쑬�뀐쭖占�searchVVDNEta�쒙옙CALL占쎌꼷肉�VVD CD�쒙옙Setting占쎌뮆��
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                for(int j = 0 ; j < invoiceIssueVOList.size() ;  j++) {
	                	InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueVOList.get(j);
	                	if(invoiceIssueVO.getDmdtChgLocDivCd().equals("TSP") || invoiceIssueVO.getDmdtChgLocDivCd().equals("SZP")) {
	                		chg_loc_div_cd_flag = true;
	                		break;
	                	}
	                }
	                if(!chg_loc_div_cd_flag) {
	                	vVDCheckDataVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
	                	vVDCheckDataVO.setPodCd(confirmChargeListVOs[i].getPodCd());
	                	vVDCheckDataVO.setPolCd(confirmChargeListVOs[i].getPolCd());
	                	vVDCheckDataVO.setIoBnd(confirmChargeListVOs[i].getDmdtTrfCd().substring(2,3));
	
	                	VVDNEtaVO vVDNEtaVO = dmtCalculationUtil.searchVVDNEta(vVDCheckDataVO.getBkgNo(), vVDCheckDataVO.getPolCd(), vVDCheckDataVO.getPodCd(), vVDCheckDataVO.getIoBnd());
	                	
	                	if(vVDNEtaVO.getVslCd().equals("") 
		                		&& vVDNEtaVO.getSkdVoyNo().equals("")
		                		&& vVDNEtaVO.getSkdDirCd().equals(""))
		                {
		                	continue;
		                }else{
		                    confirmChargeListVOs[i].setVslCd(vVDNEtaVO.getVslCd());
		                    confirmChargeListVOs[i].setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
		                    confirmChargeListVOs[i].setSkdDirCd(vVDNEtaVO.getSkdDirCd());
		                    confirmChargeListVOs[i].setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
		                }
	                }
				}
			}
			else {
				//Grid占쏙옙Cntr占쏙옙鈺곌퀬�띰옙�뺣뼄.
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//筌ｋ똾寃뺟몴占쏙옙�륅옙 占쎈봿�앾쭖占쏙옙�쎄땁
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	            	
	            	///////////////////////////////////////////////////////////////////////////////////////////////
	                //DMDT_CHG_LOC_DIV_CD占쏙옙揶쏅���'TSP', 'SZP' 揶쏉옙占쎄쑬�뀐쭖占�searchVVDNEta�쒙옙CALL占쎌꼷肉�VVD CD�쒙옙Setting占쎌뮆��
	                ///////////////////////////////////////////////////////////////////////////////////////////////
                	if(confirmChargeListVOs[i].getDmdtChgLocDivCd().equals("TSP") || confirmChargeListVOs[i].getDmdtChgLocDivCd().equals("SZP")) {
                		continue;
                	}else{
	                	vVDCheckDataVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
	                	vVDCheckDataVO.setPodCd(confirmChargeListVOs[i].getPodCd());
	                	vVDCheckDataVO.setPolCd(confirmChargeListVOs[i].getPolCd());
	                	vVDCheckDataVO.setIoBnd(confirmChargeListVOs[i].getDmdtTrfCd().substring(2,3));
	
	                	VVDNEtaVO vVDNEtaVO = dmtCalculationUtil.searchVVDNEta(vVDCheckDataVO.getBkgNo(), vVDCheckDataVO.getPolCd(), vVDCheckDataVO.getPodCd(), vVDCheckDataVO.getIoBnd());
	                	
	                	if(vVDNEtaVO.getVslCd().equals("") 
		                		&& vVDNEtaVO.getSkdVoyNo().equals("")
		                		&& vVDNEtaVO.getSkdDirCd().equals(""))
		                {
		                	continue;
		                }else{
		                    confirmChargeListVOs[i].setVslCd(vVDNEtaVO.getVslCd());
		                    confirmChargeListVOs[i].setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
		                    confirmChargeListVOs[i].setSkdDirCd(vVDNEtaVO.getSkdDirCd());
		                    confirmChargeListVOs[i].setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
		                }
                	}
				}
			}
			
			reConfirmChargeListVOs = confirmChargeListVOs;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"searchIssueInvoiceByGroupVVD"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"searchIssueInvoiceByGroupVVD"}).getMessage());
		}
		return reConfirmChargeListVOs;
    	
    }
    
	/**
	 * Invoice 占쎌빘苑�옙癒�벥 Office Code �쒙옙鈺곌퀬��占썩뫖�뀐옙占�
	 *
	 * @param String invoiceNo
	 * @return String
	 * @exception EventException
	 */
    public String searchInvoiceCreteOfficeCode(String invoiceNo) throws EventException {
    
	    try {
	    	 return dbDao.searchInvoiceCreteOfficeCode(invoiceNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
	/**
	 * BKG No., Tariff 占쏙옙占쎈���옙�롫뮉 Rate Currency �쒙옙鈺곌퀬��占썩뫖�뀐옙占�<br>
	 *
	 * @param String bkgNo
	 * @param String trfCd
	 * @return String
	 * @exception EventException
	 */
    public String searchRateCurrency(String bkgNo, String trfCd) throws EventException {
    	String rateCurCd = null;
    	
	    try {
			//占쎄낱源�첎占�Deleted', 'Error' 占쏙옙Manual Invoice Detail(Charge) �쒙옙鈺곌퀬�띰옙�뺣뼄.
			List<ManualKeyByChargeVO> manualKeyByChargeVOS = dbDao.searchManualInvoiceChargeData(bkgNo, null, trfCd);
			 
			 //Charge 占쎄퀣�좑옙怨뚳옙 占쎈뜆��野껋럩��Charge Currency �쒙옙鈺곌퀬�띰옙�뺣뼄.
			if (manualKeyByChargeVOS != null && manualKeyByChargeVOS.size() > 0) {
				 
				ManualKeyByChargeVO		manualKeyByChargeVO		= manualKeyByChargeVOS.get(0);
				CalculationParmVO 		calculationParmVO 		= new CalculationParmVO();
				ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
				OverdayNDivParmVO 		overdayNDivParmVO 		= new OverdayNDivParmVO();
	   		 
				chargeCalculationParmVO.setDmdtTrfCd(		manualKeyByChargeVO.getDmdtTrfCd()			);
				chargeCalculationParmVO.setDmdtChgLocDivCd(	manualKeyByChargeVO.getDmdtChgLocDivCd()	);
				chargeCalculationParmVO.setBkgNo(			manualKeyByChargeVO.getBkgNo()				);
				chargeCalculationParmVO.setCntrCycNo(		manualKeyByChargeVO.getCntrCycNo()			);
				chargeCalculationParmVO.setCntrNo(			manualKeyByChargeVO.getCntrNo()				);
				chargeCalculationParmVO.setFmMvmtYdCd(      manualKeyByChargeVO.getFmMvmtYdCd()         ); //2011.10.28

				log.debug(" iss   FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
				
				calculationParmVO.setDcApplRate(		manualKeyByChargeVO.getDmdtTrfAplyTpCd()	);
	   		 
				//鈺곌퀬��占쎄퀣�좑옙怨뚳옙 鈺곕똻�깍옙�롫뮉 野껋럩�� 占쎈���嚥≪뮇彛낉옙占쏙㎗�롡봺占쎌뮆��
				overdayNDivParmVO.setSvrId(				manualKeyByChargeVO.getSysAreaGrpId()		);
	   		 	overdayNDivParmVO.setCntrNo(			manualKeyByChargeVO.getCntrNo()				);
	   		 	overdayNDivParmVO.setCnmvCycNo(			manualKeyByChargeVO.getCntrCycNo()			);
	   		 	overdayNDivParmVO.setDttCode(			manualKeyByChargeVO.getDmdtTrfCd()			);
	   		 	overdayNDivParmVO.setLocDiv(			manualKeyByChargeVO.getDmdtChgLocDivCd()	);
	   		 	overdayNDivParmVO.setDccSeq(			manualKeyByChargeVO.getChgSeq()				);
	   		 
				//------------- DivOverDay 鈺곌퀬��----------------------------------------------------
	   		 	OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
				//---------------------------------------------------------------------------------
	   		 	calculationParmVO.setDivOverDay(	overdayNDivVO.getDivOverDay()				);
		   		calculationParmVO.setFtDys(manualKeyByChargeVO.getFtDys());								// 2014.03.12
	            calculationParmVO.setFmMvmtYdCd(manualKeyByChargeVO.getFmMvmtYdCd());					// 2014.03.12
	            calculationParmVO.setOrgFtOvrDys(manualKeyByChargeVO.getOrgFtOvrDys());						// 2014.03.12
	            
	            calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
	            
	   			//Charge 占쎈베�ュ첎占쏙옙�됱뱽 野껋럩��Charge Currency �쒙옙�닌뗫립占쏙옙
	    		if ("G".equals(manualKeyByChargeVO.getDmdtTrfAplyTpCd())) {
					// basicCalculation - Baisc Tariff
					String firstSvrID = null;

					if ("Y".equals(manualKeyByChargeVO.getOfcTrnsFlg())) {
						firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
					} 
					else {
						firstSvrID = manualKeyByChargeVO.getSysAreaGrpId();
					}
						
					calculationParmVO.setSvrId(			firstSvrID									);
					calculationParmVO.setDmdtTrfCd(		manualKeyByChargeVO.getDmdtTrfCd()			);
					calculationParmVO.setTrfSeq(		manualKeyByChargeVO.getBzcTrfSeq()			);
					calculationParmVO.setDmdtDeTermCd(	manualKeyByChargeVO.getBzcDmdtDeTermCd()	);
					calculationParmVO.setTrfGrpSeq(		manualKeyByChargeVO.getBzcTrfGrpSeq()		);
					calculationParmVO.setCntrts(		manualKeyByChargeVO.getCntrTpszCd()			);
					calculationParmVO.setOverDay(		manualKeyByChargeVO.getFxFtOvrDys()			);
					calculationParmVO.setCurCd(			manualKeyByChargeVO.getBzcTrfCurrCd()		);
					calculationParmVO.setTrfAplyDt(manualKeyByChargeVO.getBzcTrfAplyDt());					// 2014.03.12
					if (!"".equals(manualKeyByChargeVO.getScRfaExptAplyDt())) {		// 2014.03.12
						calculationParmVO.setDmdtTrfAplyTpCd("B");											// 獄쎻뫕占쏙옙�곕쑓占쏙옙嚥≪뮇彛�占쎈슢揆占쏙옙�곕떽占� ("B" 占쎈Ŧ��"S"嚥∽옙占쏙퐡由곤쭖占쏙옙占�
						calculationParmVO.setTrfAplyDt(manualKeyByChargeVO.getScRfaExptAplyDt());				// 2014.03.12
					} 
				} 
	    		else if ("B".equals(manualKeyByChargeVO.getDmdtTrfAplyTpCd())) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(			manualKeyByChargeVO.getRfaExptDarNo()		);
					calculationParmVO.setMapgSeq(		manualKeyByChargeVO.getRfaExptMapgSeq()		);
					calculationParmVO.setVerSeq(		manualKeyByChargeVO.getRfaExptVerSeq()		);
					calculationParmVO.setDtlSeq(		manualKeyByChargeVO.getRfaRqstDtlSeq()		);
					calculationParmVO.setCmbSeq(		"1"											);
					calculationParmVO.setCntrts(		manualKeyByChargeVO.getCntrTpszCd()			);
					calculationParmVO.setOverDay(		manualKeyByChargeVO.getFxFtOvrDys()			);
					calculationParmVO.setTrfAplyDt(manualKeyByChargeVO.getScRfaExptAplyDt());				// 2014.03.12
				} 
	    		else if ("S".equals(manualKeyByChargeVO.getDmdtTrfAplyTpCd())) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(		manualKeyByChargeVO.getScNo()				);
					calculationParmVO.setVerSeq(		manualKeyByChargeVO.getScExptVerSeq()		);
					calculationParmVO.setGrpSeq(		manualKeyByChargeVO.getScExptGrpSeq()		);
					calculationParmVO.setCntrts(		manualKeyByChargeVO.getCntrTpszCd()			);
					calculationParmVO.setOverDay(		manualKeyByChargeVO.getFxFtOvrDys()			);
					calculationParmVO.setTrfAplyDt(manualKeyByChargeVO.getScRfaExptAplyDt());				// 2014.03.12
				}
	    		
				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
				
				rateCurCd = calculationAMTVO.getRateCurCd();
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		}
		
	    return rateCurCd;
    }
    
	/**
     * VVD 占쎄퀣�좑옙占퐇ist�쒙옙鈺곌퀬�띰옙�뺣뼄.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<VVDCheckDataVO>
     * @throws EventException
	 */
    public List<VVDCheckDataVO> searchVVDCheckDataList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException{
    	List<VVDCheckDataVO> vVDCheckDataVOs = new ArrayList<VVDCheckDataVO>();

        String fm_cfm_dt = "";
        String to_cfm_dt = "";
        List<ConfirmChargeListVO> confirmChargeListVOs = null;

        try{
    		//1. Bkg list�쒙옙鈺곌퀬�띰옙�뺣뼄.
        	fm_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getFmCfmDt(), "-", "");
        	to_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getToCfmDt(), "-", "");
        	
        	issuedInvoiceParamVO.setFmCfmDt(fm_cfm_dt);
        	issuedInvoiceParamVO.setToCfmDt(to_cfm_dt);
        	issuedInvoiceParamVO.setOfcCd(account.getOfc_cd());	//�곕떽占�2010.04.20
        	
            if(issuedInvoiceParamVO.getSGroupBy().equals("1")){
            	confirmChargeListVOs = dbDao.searchConfirmChargeByBooking(issuedInvoiceParamVO);        //B/L No.
            }else {
            	confirmChargeListVOs = dbDao.searchConfirmChargeByContainer(issuedInvoiceParamVO);      //CNTR No.
            }    
            
            for(int i = 0 ; i < confirmChargeListVOs.size() ; i++) {
            	ConfirmChargeListVO confirmChargeListVO = (ConfirmChargeListVO)confirmChargeListVOs.get(i);
            	IssuedInvoiceParamVO inIssuedInvoiceParamVO = new IssuedInvoiceParamVO();
            	
            	inIssuedInvoiceParamVO.setSBkgNo(confirmChargeListVO.getBkgNo());
            	inIssuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVO.getDmdtTrfCd());
            	inIssuedInvoiceParamVO.setSOfcCd(account.getOfc_cd());
            	
            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
            	
            	vVDCheckDataVO = dbDao.searchVVDCheckData(inIssuedInvoiceParamVO, "1");
            	if(!vVDCheckDataVO.getBkgNo().equals("")){
        			vVDCheckDataVO = dbDao.searchVVDCheckData(inIssuedInvoiceParamVO, "2");
                	vVDCheckDataVOs.add(vVDCheckDataVO);
        		}
            }
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        }
        
        return vVDCheckDataVOs;
    }
    
    
    /**
     * After Booking 占쎈��ㅿ옙占썸�袁⑷텦占쏙옙占쎌꼹六억옙占쏙옙占폠nvoice 占쎈베�ョ몴占썲첎源녿뻿占쎌뮆��<br>
     * 
     * @param String darNo
     * @throws EventException
     */
	public void modifyInvoiceAdjustAmount(String darNo) throws EventException {
		try {
			dbDao.modifyInvoiceAdjustAmount(darNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Invoice Adjust Amount"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Invoice Adjust Amount"}).getMessage());
		}
	}
    
 	/**
 	 * DMT_INV_MN占쏙옙DMDT_INV_STS_CD�쒙옙鈺곌퀬�띰옙�뺣뼄.
 	 * @param String invoiceNo
 	 * @param String creOfcCd
 	 * @return String
 	 * @throws DAOException
 	 */
	public String searchInvoiceStatus(String invoiceNo, String creOfcCd) throws EventException {
	    try {
	    	 return dbDao.searchInvoiceStatus(invoiceNo, creOfcCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}		
	}
	
    /**
     * Invoice占쏙옙占쏙옙釉�After Invoice Adjustment Amt�쒙옙鈺곌퀬��占썩뫖�뀐옙占�br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param String lgnOfcCd
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    public ChargeBookingInvoiceVO checkAftInvAdjAmtByInvoiceNo(String invoiceNo, String creOfcCd, String lgnOfcCd) throws EventException {
	    try {
	    	 return dbDao.checkAftInvAdjAmtByInvoiceNo(invoiceNo, creOfcCd, lgnOfcCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	    	
    }
    
    /**
     * Issued Invoice(Payer癰귨옙Currency占쏙옙占쏙옙釉�占썩뫕�롦묾�됰만) �쒙옙鈺곌퀬��占쎌뮆��
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceSumByPayerVO>
     * @throws EventException
     */
    public List<IssuedInvoiceSumByPayerVO> searchIssuedInvoiceSumByPayer ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws EventException {
    	List<IssuedInvoiceSumByPayerVO> list = null;
    	List<IssuedInvoiceSumByPayerVO> list1 = null;
    	String chk_name = "";
    	String chk_charge = "";
    	String chk_cur = "";
    	String chk_amt1 = "";
    	String chk_amt2 = "";
    	String chk_amt3 = "";
    	String chk_amt4 = "";
    	IssuedInvoiceSumByPayerVO tmpVO = null;
    	
        try {
        	issuedInvoiceParamVO.setSIssueFm(JSPUtil.replace(issuedInvoiceParamVO.getSIssueFm(), "-",""));
        	issuedInvoiceParamVO.setSIssueTo(JSPUtil.replace(issuedInvoiceParamVO.getSIssueTo(), "-",""));
        	issuedInvoiceParamVO.setInvFlg("N");
        	
        	list = dbDao.searchIssuedInvoiceSumByPayer(issuedInvoiceParamVO);
        	for(int i = 0 ; i < list.size() ; i ++){
        		tmpVO = (IssuedInvoiceSumByPayerVO)list.get(i);
        		
        		if(i == 0){
            		chk_name = tmpVO.getTName();
            		chk_charge = tmpVO.getTCharges();
            		chk_cur = tmpVO.getTCurr();
            		chk_amt1 = tmpVO.getTIncurredAmt();
            		chk_amt2 = tmpVO.getTExptAmt();
            		chk_amt3 = tmpVO.getTDcAmt();
            		chk_amt4 = tmpVO.getTBilAmt();
        			continue;
        		}
        		
        		if(chk_name.equals(tmpVO.getTName())){
        			tmpVO.setTName("");
        		}else{
        			chk_name = tmpVO.getTName();
        		}
        		
        		if(chk_charge.equals(tmpVO.getTCharges()) 
        				&& chk_cur.equals(tmpVO.getTCurr()) 
        				&& chk_amt1.equals(tmpVO.getTIncurredAmt()) 
           				&& chk_amt2.equals(tmpVO.getTExptAmt())
           				&& chk_amt3.equals(tmpVO.getTDcAmt())
           				&& chk_amt4.equals(tmpVO.getTBilAmt()) 
        			){
        			tmpVO.setTCharges("");	
        			tmpVO.setTCurr("");	
        			tmpVO.setTIncurredAmt("");	
        			tmpVO.setTExptAmt("");	
        			tmpVO.setTDcAmt("");	
        			tmpVO.setTBilAmt("");	
        		}else{
            		chk_charge = tmpVO.getTCharges();
            		chk_cur = tmpVO.getTCurr();
            		chk_amt1 = tmpVO.getTIncurredAmt();
            		chk_amt2 = tmpVO.getTExptAmt();
            		chk_amt3 = tmpVO.getTDcAmt();
            		chk_amt4 = tmpVO.getTBilAmt();
        		}
        		list.set(i, tmpVO);
        		
        	}
        	
        	issuedInvoiceParamVO.setInvFlg("M");
        	list1 = dbDao.searchIssuedInvoiceSumByPayer(issuedInvoiceParamVO);
        	
        	for(int i = 0 ; i < list1.size() ; i ++){
        		tmpVO = (IssuedInvoiceSumByPayerVO)list1.get(i);
        		
        		if(i == 0){
            		chk_name = tmpVO.getTName();
            		chk_charge = tmpVO.getTCharges();
            		chk_cur = tmpVO.getTCurr();
            		chk_amt1 = tmpVO.getTIncurredAmt();
            		chk_amt2 = tmpVO.getTExptAmt();
            		chk_amt3 = tmpVO.getTDcAmt();
            		chk_amt4 = tmpVO.getTBilAmt();
        			continue;
        		}
        		
        		if(chk_name.equals(tmpVO.getTName())){
        			tmpVO.setTName("");
        		}else{
        			chk_name = tmpVO.getTName();
        		}
        		
        		if(chk_charge.equals(tmpVO.getTCharges()) 
        				&& chk_cur.equals(tmpVO.getTCurr()) 
        				&& chk_amt1.equals(tmpVO.getTIncurredAmt()) 
           				&& chk_amt2.equals(tmpVO.getTExptAmt())
           				&& chk_amt3.equals(tmpVO.getTDcAmt())
           				&& chk_amt4.equals(tmpVO.getTBilAmt()) 
        			){
        			tmpVO.setTCharges("");	
        			tmpVO.setTCurr("");	
        			tmpVO.setTIncurredAmt("");	
        			tmpVO.setTExptAmt("");	
        			tmpVO.setTDcAmt("");	
        			tmpVO.setTBilAmt("");	
        		}else{
            		chk_charge = tmpVO.getTCharges();
            		chk_cur = tmpVO.getTCurr();
            		chk_amt1 = tmpVO.getTIncurredAmt();
            		chk_amt2 = tmpVO.getTExptAmt();
            		chk_amt3 = tmpVO.getTDcAmt();
            		chk_amt4 = tmpVO.getTBilAmt();
        		}
        		list1.set(i, tmpVO);
        		
        	}
        
        	list.addAll(list1);
        	return list;
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }    
	
    /**
     *  占쎈챶猷�GST �울옙��Tax rate�쒙옙鈺곌퀬�띰옙�몃빍占쏙옙<br>
     * @param  String iss_dt
     * @return SearchIndiaGstRateVO
     * @exception EventException 
     */
    public SearchIndiaGstRateVO searchIndiaGstRate(String iss_dt) throws EventException {
	    try {
	    	 return dbDao.searchIndiaGstRate(iss_dt);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	    	
    }

    /**
    * OTS Clean 占쎈뗀��鈺곌퀬��List <br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanListVO>
    * @exception EventException
    */
    public List<OTSCleanListVO> searchOTSCleanList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSCleanList ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    }

    /**
    * OTS Clean 占쎈뗀��鈺곌퀬��(Office Summary)<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanOfficeListVO>
    * @exception EventException
    */
    public List<OTSCleanOfficeListVO> searchOTSCleanOfficeList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSCleanOfficeList ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    }
    

    /**
    * EES_DMT_4017 : [Detailed down Excel 甕곌쑵��<br>
    * OTS Clean Detail Excel 占썬끉�ユ에�뺣굡<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanDetailExcelListVO>
    * @exception EventException
    */
    public List<OTSCleanDetailExcelListVO> searchOTSCleanDetailExcelList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSCleanDetailExcelList ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    }
    

    /**
     * Sales Team, Sales Rep. 占쏙옙��<br>
     * 
     * @param OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
	public void updateOTSCleanDetailListSales(OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs, SignOnUserAccount account ) throws EventException {
		try {
			for ( int i=0; i < oTSCleanDetailExcelListVOs.length; i++ ) {
				dbDao.updateOTSCleanDetailListSales(oTSCleanDetailExcelListVOs[i], account);
			}
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Invoice Adjust Amount"}).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"modify Invoice Adjust Amount"}).getMessage());
		}
	}
	

    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OTSCleanDetailExcelListVO>
    * @exception EventException
    */
    public List<OTSCleanDetailExcelListVO> searchOTSCleanByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSCleanByDetailList2 ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    

    /**
 	 * 占쎈���OTS Back End Job占쏙옙占썬끋六억옙�쀪텚占쏙옙
 	 * 
 	 * @param OtsInquiryParmVO otsInquiryParmVO
     * @param SignOnUserAccount account
 	 * @return String
 	 * @throws EventException
 	 */
    public String dobackEndJobOTS(OtsInquiryParmVO otsInquiryParmVO, SignOnUserAccount account) throws EventException {
		try {
			InvoiceIssueCollectionMgtBackEndJobOTS	backEndJob	= new InvoiceIssueCollectionMgtBackEndJobOTS();
			BackEndJobManager			backEndJobManager 	= new BackEndJobManager();
			
			backEndJob.setPgmNo("EES_DMT_4017");	
			backEndJob.setOtsInquiryParmVO(otsInquiryParmVO);
			
			//BackEndJob 筌뤴뫀諭�옙占쏙옙紐꾪뀱占쎌뮆��
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "OTS Search.");
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"execute group invoice save backend job"}).getMessage());
		}
    }
    
    /**
 	 * 揶쏉옙湲�Invoice 占쏙옙占쎄낱源�몴占쏙옙�륁젟占쎌뮆��
 	 * 
 	 * @param String dmdtInvNo
 	 * @param String dmdtVtInvStsCd
 	 * @param String creOfcCd
 	 * @throws EventException
 	 */
    public void modifyVirtualInvoiceStatus(String dmdtInvNo, String dmdtVtInvStsCd, String creOfcCd) throws EventException {
        
    	try {
            dbDao.modifyVirtualInvoiceStatus(dmdtInvNo, dmdtVtInvStsCd, creOfcCd);
        } 
    	catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
 	 * BKG No., Tariff Type 占쏙옙占쎈���옙�롫뮉 Virtual Invoice 揶쏉옙鈺곕똻�깍옙�롫뮉筌욑옙鈺곌퀬�띰옙�뺣뼄.
 	 * 
 	 * @param String bkgNo
 	 * @param String dmdtTrfCd
 	 * @return String
 	 * @throws EventException
 	 */
    public String searchExistsVirtualInvoice(String bkgNo, String dmdtTrfCd) throws EventException {
    	
        try {
            return dbDao.searchExistsVirtualInvoice(bkgNo, dmdtTrfCd);
        } 
        catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
        catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}    	
    }
    
    /**
 	 * BKG No., Tariff Type 占쏙옙占쎈���옙�롫뮉 Virtual Invoice �쒙옙Cancel 占쎌뮆��
 	 * 
 	 * @param String bkgNo
 	 * @param String dmdtTrfCd
 	 * @throws EventException
 	 */    
    public void cancelVirtualInvoice(String bkgNo, String dmdtTrfCd) throws EventException {
        
    	try {
            dbDao.cancelVirtualInvoice(bkgNo, dmdtTrfCd);
        } 
    	catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
 	 * Invoice Charge Amount �쒙옙�④쑴沅쏉옙�곴퐣 占쎌눘�숋옙類ㅻ뻼占쏙옙筌띿쉳苡�癰귨옙�싷옙�뽱룖占쏙옙獄쏆꼹�싷옙�곻옙占쏙옙
 	 * 
 	 * @param String invBilAmt
     * @param String invXchRt
     * @param String invCurrCd
 	 * @return String
 	 * @throws EventException
 	 */    
    private String toInvoiceChargeAmount(String invBilAmt, String invXchRt, String invCurrCd) throws EventException {
    	String strInvChgAmount = null;
    	
    	double dInvBillAmount = dmtCalculationUtil.trimCurrencyAmount(invCurrCd, NumberUtils.toDouble(invBilAmt) * NumberUtils.toDouble(invXchRt));
    	strInvChgAmount = JSPUtil.toDecimalFormat(dInvBillAmount, "#.##");
    	log.debug("[toInvoiceChargeAmount] BILL_AMT : " + invBilAmt + ", INV_XCH_RT : " + invXchRt + ", INV_CURR_CD : " + invCurrCd + ", INVOICE_CHARGE_AMOUNT : " + strInvChgAmount);
    	
    	return strInvChgAmount;
    }
    

    /**
     * [Invoice Create & Issue]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<DmtInvMnVO>
     * @exception EventException
     */
    public List<DmtInvMnVO> searchChargeInvoiceGrpBkgNo(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException {
        String fm_cfm_dt = "";
        String to_cfm_dt = "";
        try {
        	fm_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getFmCfmDt(), "-", "");
        	to_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getToCfmDt(), "-", "");
        	
        	issuedInvoiceParamVO.setFmCfmDt(fm_cfm_dt);
        	issuedInvoiceParamVO.setToCfmDt(to_cfm_dt);
        	issuedInvoiceParamVO.setOfcCd(account.getOfc_cd());	//�곕떽占�2010.04.20
        	
            if ("1".equals(issuedInvoiceParamVO.getSGroupBy())) {
            	return dbDao.searchConfirmGrpBkgNo(issuedInvoiceParamVO);
            } 
            else {
            	return dbDao.searchConfirmGrpBkgNoContainer(issuedInvoiceParamVO);
            }
        } 
        catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } 
        catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}    		
    }
    
    /**
     * [INV. �쒙옙占쎌빘苑�옙占폨ffice 揶쏉옙占쎈Ŧ猷�A/R I/F 占쏙옙湲쏙옙紐꾬옙 占싼됵옙]�쒙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
     * 
     * @param String dmtOfcCd
     * @return String
     * @exception EventException
     */
    public String searchAutoARInfYnByOffice(String dmtOfcCd) throws EventException {
    	
 		try {
 			return dbDao.searchAutoARInfYnByOffice(dmtOfcCd);
 		} 
 		catch (DAOException ex) {
 			log.error("[DAOException]"+ex.getMessage());
 			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
 		catch (Exception ex) {
         	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}    	
    }
    
    /**
     * [ERP 으로부터 수신한 OTS 미수금 수신정보]를 [저장] 합니다.<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @exception EventException
     */
    public void addOtsInfo(OtsPayRcvVO otsPayRcvVO) throws EventException {
    	
 		try {
 			dbDao.addOtsInfo(otsPayRcvVO);
 		} 
 		catch (DAOException ex) {
 			log.error("[DAOException]"+ex.getMessage());
 			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
 		catch (Exception ex) {
         	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}    	
    }
    
    /**
     * [ERP 으로부터 수신한 OTS 미수금 납부한 금액이 청구한 금액과 동일한지 여부]를 [조회] 합니다.<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @return boolean
     * @exception EventException
     */
    public boolean isOtsCollected(OtsPayRcvVO otsPayRcvVO) throws EventException {
    	boolean result = false;
    	
 		try {
 			if ("Y".equals(dbDao.searchOtsCollectedYn(otsPayRcvVO))) {
 				result = true;
 			}
 		} 
 		catch (DAOException ex) {
 			log.error("[DAOException]"+ex.getMessage());
 			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
 		catch (Exception ex) {
         	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}  
 		return result;
    }
    
    /**
     * [ERP 으로부터 수신한 OTS 미수금이 완납된 경우 미수금 완납 FLAG]를 [수정] 합니다.<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @exception EventException
     */
    public void modifyOtsCollected(OtsPayRcvVO otsPayRcvVO) throws EventException {
    	
 		try {
 			dbDao.modifyOtsCollected(otsPayRcvVO);
 		} 
 		catch (DAOException ex) {
 			log.error("[DAOException]"+ex.getMessage());
 			throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
 		catch (Exception ex) {
         	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}    	
    }    
    
    /**
     * [TAB3:A/R Interface Status Inquiry By ERP]을 [조회]합니다.<br>
     * 
     * @param ARInterfaceParmVO arInterfaceParmVO
     * @return List<ARInterfaceStatusVO>
     * @exception EventException
     */
     public List<ARInterfaceStatusVO> searchARInterfaceStatusByERP( ARInterfaceParmVO arInterfaceParmVO ) throws EventException {
          try {
              return dbDao.searchARInterfaceStatusByERP(arInterfaceParmVO);
          } catch (DAOException ex) {
         	 log.error("[DAOException]"+ex.getMessage());
              throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
          } catch (Exception ex) {
         	 log.error("[Exception]"+ex.getMessage());
         	 throw new EventException(ex.getMessage(),ex);
  		}
      }
	
     /**
 	 * Payer Info 기본 정보 목록을 조회한다.<br>
 	 * 
 	 * @param payerInfoListVO
 	 * @return List<PayerInfoListVO>
 	 * @throws EventException
 	 */
 	public List<PayerInfoListVO> searchPayerInfoList(PayerInfoListVO payerInfoListVO) throws EventException {
	
 		try {
 			return dbDao.searchPayerInfoList(payerInfoListVO);
 		} catch (DAOException ex) {
        	 log.error("[DAOException]"+ex.getMessage());
             throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
         } catch (Exception ex) {
        	 log.error("[Exception]"+ex.getMessage());
        	 throw new EventException(ex.getMessage(),ex);
         }
	}
 	
    /**
     * Invoice 발행시 DMT_PAYR_INFO 테이블에 해당 Payer가 등록되어있는지 확인 후 존재하지 않는다면 해당 Payer 정보를 저장한다.
     * 
     * @param String custCd
     * @param SignOnUserAccount account
     * @return boolean
     * @exception EventException
     */
    public boolean checkPayerAndSave(String custCd, SignOnUserAccount account) throws EventException {
    	
    	boolean result = false;
    	
		try{
			DmtPayrInfoVO dmtPayrInfoVO = new DmtPayrInfoVO();
			
			// Customer Code에서 vendor 여부 확인
			if(custCd.length() == 6){
				dmtPayrInfoVO.setCustCntCd("00");
				dmtPayrInfoVO.setCustSeq(custCd);
				dmtPayrInfoVO.setDmdtPayrVndrFlg("Y");
			}else{
				dmtPayrInfoVO.setCustCntCd(custCd.substring(0, 2));
				dmtPayrInfoVO.setCustSeq(custCd.substring(2));
				dmtPayrInfoVO.setDmdtPayrVndrFlg("N");
			}
			
			// Payer Info 확인
			String s_payr_yn = dbDao.checkPayerInfo(account.getOfc_cd(), custCd, dmtPayrInfoVO.getDmdtPayrVndrFlg(), "");
			
			// 체크한 Payer 정보가 'N'이라면 DB에 저장
			if(s_payr_yn.equals("N")){
				// Payer 에 대한 기본 정보를 MDM으로부터 조회한다.
				String s_cust_gubun = dmtPayrInfoVO.getDmdtPayrVndrFlg().equals("Y") ? "1" : "2";				
				DmtPayrInfoVO fromMDM = dbDao.searchPayerInformation(account.getOfc_cd(), custCd, s_payr_yn, s_cust_gubun, "");
				// 조회한 정보를 기존 VO객체에 담아 신규 생성한다.
				dmtPayrInfoVO.setSvrId(fromMDM.getSvrId());
				dmtPayrInfoVO.setCustRgstNo(fromMDM.getCustRgstNo());
				dmtPayrInfoVO.setIssDivNm(fromMDM.getIssDivNm());
				dmtPayrInfoVO.setDmdtPayrNm(fromMDM.getDmdtPayrNm());
				dmtPayrInfoVO.setDmdtPayrAddr(fromMDM.getDmdtPayrAddr());
				dmtPayrInfoVO.setDmdtPayrCntcPntNm(fromMDM.getDmdtPayrCntcPntNm());
				dmtPayrInfoVO.setDmdtPayrPhnNo(fromMDM.getDmdtPayrPhnNo());
				dmtPayrInfoVO.setDmdtPayrFaxNo(fromMDM.getDmdtPayrFaxNo());
				dmtPayrInfoVO.setDmdtPayrN1stEml(fromMDM.getDmdtPayrN1stEml());
				
				dmtPayrInfoVO.setCreOfcCd(account.getOfc_cd());
				dmtPayrInfoVO.setCreUsrId(account.getUsr_id());
				dmtPayrInfoVO.setUpdOfcCd(account.getOfc_cd());
				dmtPayrInfoVO.setUpdUsrId(account.getUsr_id());
				
				dbDao.addPayerInfomation(dmtPayrInfoVO);
				log.info("[checkPayerAndSave] addPayerInfomation");
			}
			// 오류가 없이 수행되었다면 true
			result = true;
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
		
		return result;		
    }	

    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s)]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @exception EventException
    */
    public String searchOTSInquiryByDetailListInternalRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryByDetailListInternalRemark ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [변경된 인도 Tax 적용시점 ( A : After, B : Before )]을 [SEARCH] 합니다.<br>
    * 
    * @param String invNo
    * @return String
    * @exception EventException
    */     
    public String searchIdaTaxApplTm(String invNo) throws EventException {
    	
        try {
            return dbDao.searchIdaTaxApplTm(invNo);
        } 
        catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
        catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [인도OFC 에서 발행된 INVOICE 의 은행계좌정보]를 [SEARCH] 합니다.<br>
    * 
    * @return IdaGstRtoVO
    * @exception EventException
    */     
    public IdaGstRtoVO searchIdaBankInfo() throws EventException {
    	
        try {
        	return dbDao.searchIdaBankInfo();
        } 
        catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
        catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}    	
    }
    
    /**
    * [변경된 인도 Tax Ratio]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return IdaGstRtoVO
    * @exception EventException
    */     
    public IdaGstRtoVO searchIdaTaxRto(IdaGstRtoCondVO condVO) throws EventException {
    	IdaGstRtoVO idaGstRtoVO = new IdaGstRtoVO();
    	
        try {
            // 1. GST Division Code 조회
        	String idaTaxDivCd = dbDao.searchIdaTaxDivCd(condVO);
        	condVO.setIdaTaxDivCd(idaTaxDivCd);
        	
        	// 2. GST Ratio 조회
        	idaGstRtoVO = dbDao.searchIdaTaxRto(condVO);
        	
        	// 3. GST Customer / Vendor 조회
        	IdaGstRtoVO idaGstVO = this.searchIdaGstInfo(condVO);
        	if (idaGstVO != null) {
        		idaGstRtoVO.setIdaGstRgstNo(idaGstVO.getIdaGstRgstNo());
        		idaGstRtoVO.setIdaGstRgstStsNm(idaGstVO.getIdaGstRgstStsNm());
        		idaGstRtoVO.setIdaSteCd(idaGstVO.getIdaSteCd());
        		idaGstRtoVO.setIdaSteNm(idaGstVO.getIdaSteNm());
        		idaGstRtoVO.setIdaSacCd(idaGstVO.getIdaSacCd());
        		idaGstRtoVO.setIdaSacNm(idaGstVO.getIdaSacNm());
        	}        	
        } 
        catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } 
        catch(Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
        return idaGstRtoVO;
    } 
    
    /**
    * [인도 invoice 발행시 사용되는 Payer 정보]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return IdaGstRtoVO
    * @exception EventException
    */       
    public IdaGstRtoVO searchIdaGstInfo(IdaGstRtoCondVO condVO) throws EventException {
    	try {
       		return dbDao.searchGstInfo(condVO);
    	}
	    catch(DAOException ex) {
	    	log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	    } 
	    catch(Exception ex) {
	    	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
    * [인도 invoice 발행시 사용되는 SM상선 인도 Office 정보]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return IdaGstRtoVO
    * @exception EventException
    */       
    public IdaGstRtoVO searchIdaGstInfoByOffice(IdaGstRtoCondVO condVO) throws EventException {
    	try {
       		return dbDao.searchGstInfoByOffice(condVO);
    	}
	    catch(DAOException ex) {
	    	log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	    } 
	    catch(Exception ex) {
	    	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
   /**
    * [인도 Tax 관련정보]를 [SEARCH] 합니다.<br>
    * 
    * @param ChargeBookingInvoiceVO chgBkgInvVO
    * @param String usrCntCd
    * @exception EventException
    */
    public void setIdaTaxInfo(ChargeBookingInvoiceVO chgBkgInvVO, String usrCntCd) throws EventException {
    	
        try {
	    	 // 로그인 사용자 Office 가 INDIA 일 경우, Tax Ratio 를 조회한다.
	         if ("IN".equals(usrCntCd)) {

		         // 인도 TAX 변경 전 / 후 인지 조회 ( A : After, B : Before )
		         String idaTaxApplTm = this.searchIdaTaxApplTm("");
		         chgBkgInvVO.setIdaTaxApplTm(idaTaxApplTm);
		         
	             // Bank Account 조회
    			 IdaGstRtoVO idaGstRtoVO = dbDao.searchIdaBankInfo();
    			 if (idaGstRtoVO != null) {
    				chgBkgInvVO.setIdaBankAcctNo(idaGstRtoVO.getIdaBankAcctNo());
    				chgBkgInvVO.setIdaBankIfscCd(idaGstRtoVO.getIdaBankIfscCd());
    			}
    			 
		         // 인도 TAX 변경 전 일 경우 ( 변경 후 일 경우에는 Payer 정보를 입력하는 시점에 조회 함 )
	             if ("B".equals(idaTaxApplTm)) {
	                 SearchIndiaGstRateVO indiaGstRateVO = this.searchIndiaGstRate("");
	                 chgBkgInvVO.setIdaExpnTaxRt(indiaGstRateVO.getIdaExpnTaxRt());
	                 chgBkgInvVO.setIdaEduTaxRt(indiaGstRateVO.getIdaEduTaxRt());
	                 chgBkgInvVO.setIdaHighEduTaxRt(indiaGstRateVO.getIdaHighEduTaxRt());
	                 chgBkgInvVO.setIdaLoclTaxRt(indiaGstRateVO.getIdaLoclTaxRt());
	                 chgBkgInvVO.setIdaN2ndLoclTaxRt(indiaGstRateVO.getIdaN2ndLoclTaxRt());
	    	        	
	                 // Demand Note Issue - Booking ( EES_DMT_3109 ) 에서 사용됨.
	                 chgBkgInvVO.setTaxRgstNo(indiaGstRateVO.getTaxRgstNo());
	                 chgBkgInvVO.setPmntAcctNo(indiaGstRateVO.getPmntAcctNo());
	                 chgBkgInvVO.setSvcCateRmk(indiaGstRateVO.getSvcCateRmk());
	             }
	         }   
        }
        catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
        catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }    	         
    } 
    
    
    /**
     * [Tax Amount]를 [Calculate] 합니다.<br>
     * 
     * @param InvoiceGroupParamVO invGrpVO
     * @param double cntrInvAmt  ( Charge Billaing Amt * 환율 )
     * @return InvoiceAmtVO
     * @exception EventException
     */    
    private InvoiceAmtVO calculateInvoiceAmt(InvoiceGroupParamVO invGrpVO, double cntrInvAmt) throws Exception {
    	
        //TAX_AMT
    	InvoiceAmtVO invoiceAmtVO = new InvoiceAmtVO();
        
    	double taxAmt = 0;
    	double invAmt = 0;
    	
        if ("IN".equals(invGrpVO.getUsrCntCd())) {
        	
    		// CGST AMT
    		double idaCgstRto = Double.parseDouble(invGrpVO.getIdaCgstRto());
    		double idaCgstAmt = Math.round(cntrInvAmt * idaCgstRto * 0.01 * 100d) / 100d;
    		
    		// SGST AMT
    		double idaSgstRto = Double.parseDouble(invGrpVO.getIdaSgstRto());
    		double idaSgstAmt = Math.round(cntrInvAmt * idaSgstRto * 0.01 * 100d) / 100d;
    		
    		// IGST AMT
    		double idaIgstRto = Double.parseDouble(invGrpVO.getIdaIgstRto());
    		double idaIgstAmt = Math.round(cntrInvAmt * idaIgstRto * 0.01 * 100d) / 100d;
    		
    		// UGST AMT
    		double idaUgstRto = Double.parseDouble(invGrpVO.getIdaUgstRto());
    		double idaUgstAmt = Math.round(cntrInvAmt * idaUgstRto * 0.01 * 100d) / 100d;
    		
			// Tax Amount
    		taxAmt = idaCgstAmt + idaSgstAmt + idaIgstAmt + idaUgstAmt;
    		invAmt = cntrInvAmt + taxAmt;
        }
        else {
        	double taxRto = Double.parseDouble(invGrpVO.getTaxRto());
        	
			// 베트남일 경우
			if ("VN".equals(invGrpVO.getUsrCntCd())) {
				taxAmt = (cntrInvAmt / (1 - taxRto * 0.01)) * (taxRto * 0.01);
			}
			else {
				taxAmt = taxRto * 0.01 * cntrInvAmt;
			}
			
			invAmt = cntrInvAmt + taxAmt;
        }    	
    	
        invoiceAmtVO.setTaxAmt(String.valueOf(taxAmt));
        invoiceAmtVO.setInvAmt(String.valueOf(invAmt));
        
        return invoiceAmtVO;
    }
    
    /**
     * [ Invoice No. ]를 [ Generate ] 합니다.<br>
     * 
     * @param InvoiceNoGenVO condVO
     * @return InvoiceNoGenVO
     * @exception EventException
     */  
    public InvoiceNoGenVO generateInvoiceNo(InvoiceNoGenCondVO condVO) throws EventException {
    	CommonFinderBC common = new CommonFinderBCImpl();
    	
    	InvoiceNoGenVO invoiceNoGenVO = new InvoiceNoGenVO();
    	
    	//로그인 사용자가 OFFICE 를 변경하더라도 세션에 COUNTRY CODE 는 변경되지 않음. 그래서 직접 조회서 사용해야 됨 
    	String usrCntCd = common.searchUserCntCode(condVO.getOfcCd());
    	
    	if ("IN".equals(usrCntCd)) {
    		invoiceNoGenVO = this.generateIndiaInvoiceNo(condVO);
    	}
    	else {
    		invoiceNoGenVO = this.generateGeneralInvoiceNo(condVO);
    	}
    	
    	return invoiceNoGenVO;
    }
    
    /**
     * [ Invoice No. ]를 [ Generate ] 합니다.<br>
     * 
     * @param InvoiceNoGenVO condVO
     * @return InvoiceNoGenVO
     * @exception EventException
     */  
    private InvoiceNoGenVO generateGeneralInvoiceNo(InvoiceNoGenCondVO condVO) throws EventException {
    	
    	InvoiceNoGenVO invoiceNoGenVO = new InvoiceNoGenVO();
    	
    	try {
			String invPfxCd = dbDao.searchInvPfxCd(condVO.getOfcCd());

			if (StringUtils.isEmpty(invPfxCd)) {
				invoiceNoGenVO.setErrMsgCd("DMT03063");
				invoiceNoGenVO.setErrMsg("Invoice Prefix code missing for your login office");
				
				return invoiceNoGenVO;
			}
			
			// Manual Invoice 일 경우, 무조건 Sub Code 는 'M' 이 된다.
			// Manual Invoice 가 아닐 경우, Demurrage 인 경우 'R', Detention 인 경우 'T' 가 된다.
			String dmdtInvTpCd = condVO.getDmdtInvTpCd();
			if (StringUtils.isEmpty(dmdtInvTpCd)) {	
				dmdtInvTpCd = condVO.getDmdtTrfCd().startsWith("DM") ? "R" : "T";
			}
			
			DmtInvNoVO dmtInvNoVO = new DmtInvNoVO();
			dmtInvNoVO.setInvOfcPfxCd(invPfxCd);
			dmtInvNoVO.setDmdtInvTpCd(dmdtInvTpCd);
			
			String dmdtInvSeq = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
			String dmdtInvNo  = invPfxCd + dmdtInvTpCd + JSPUtil.getLPAD(dmdtInvSeq, 6, "0");
			
			dmtInvNoVO.setDmdtInvNo(dmdtInvNo);
			dmtInvNoVO.setDmdtInvSeq(dmdtInvSeq);
			dmtInvNoVO.setDmdtInvTpCd(dmdtInvTpCd);
			dmtInvNoVO.setInvOfcPfxCd(invPfxCd);
			dmtInvNoVO.setCreOfcCd(condVO.getOfcCd());
			dmtInvNoVO.setCreUsrId(condVO.getUsrId());			
			dmtInvNoVO.setUpdOfcCd(condVO.getOfcCd());
			dmtInvNoVO.setUpdUsrId(condVO.getUsrId());

			if ("1".equals(dmdtInvSeq)) {
				dbDao.createInvoiceNo(dmtInvNoVO);
				dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
			} 
			else {
				dbDao.modifyInvoiceNo(dmtInvNoVO);
			}    	
			
			invoiceNoGenVO.setDmdtInvNo(dmdtInvNo);
    	}
    	catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    	
    	return invoiceNoGenVO;
    } 
    
    /**
     * [ 인도지역의 Invoice No. ]를 [ Generate ] 합니다.<br>
     * 
     * @param InvoiceNoGenVO condVO
     * @return InvoiceNoGenVO
     * @exception EventException
     */  
    private InvoiceNoGenVO generateIndiaInvoiceNo(InvoiceNoGenCondVO condVO) throws EventException {
    	
    	InvoiceNoGenVO invoiceNoGenVO = new InvoiceNoGenVO();
    	
    	try {
    		String dmdtInvNo = "";
    		// [ INDIA INVOICE NO 채번 RULE ]============================================================================================= 
			// OFFICE CITY CODE ( OFC 앞 3자리 ) + DMT INVOICE TYPE CODE ( 1자리 ) + 1708 (YYMM, 4자리) + 0001 (Serial Number – 4자리)
    		// ===========================================================================================================================
    		
    		// 1. OFFICE CITY CODE
    		String ofcCtyCd = condVO.getOfcCd().substring(0, 3);
    		
    		// 2. DMT INVOICE TYPE CODE
    		String dmdtInvTpCd = condVO.getDmdtInvTpCd();
			if (StringUtils.isEmpty(dmdtInvTpCd)) {	
				dmdtInvTpCd = condVO.getDmdtTrfCd().startsWith("DM") ? "R" : "T";
			}
			
			// 3. YYMM ( 인도지역의 년월 YYMM ) 및 Invoice No. 채번에 필요한 회계년도 조회
			//    인도지역의 회계년도는 당해년도 04월 ~ 다음년도 03월까지임 
			IndiaFiscalYearVO indiaFiscalYearVO = dbDao.searchIndiaFiscalYear(condVO.getOfcCd());
			String crntYrMon = indiaFiscalYearVO.getCrntYrMon();
			String fscYr = indiaFiscalYearVO.getFscYr();
			
			// 4. Serial Number
			IndiaInvoiceNo invNoCondVO = new IndiaInvoiceNo();
			invNoCondVO.setOfcCtyCd(ofcCtyCd);
			invNoCondVO.setFscYr(fscYr);
			IndiaInvoiceNo indiaInvoiceNo = dbDao.searchIndiaInvoiceNo(invNoCondVO);
			if (indiaInvoiceNo == null) {
				String serNoSeq = "1";
				
				indiaInvoiceNo = new IndiaInvoiceNo();
				indiaInvoiceNo.setOfcCtyCd(ofcCtyCd);
				indiaInvoiceNo.setFscYr(fscYr);
				indiaInvoiceNo.setSerNoSeq(serNoSeq);
				indiaInvoiceNo.setUsrId(condVO.getUsrId());

				dmdtInvNo = ofcCtyCd.concat(dmdtInvTpCd).concat(crntYrMon).concat(JSPUtil.getLPAD(serNoSeq, 4, "0"));
				indiaInvoiceNo.setDmdtInvNo(dmdtInvNo);
				dbDao.createIndiaInvoiceNo(indiaInvoiceNo);
			}
			else {
				String serNoSeq = String.valueOf(Integer.parseInt(indiaInvoiceNo.getSerNoSeq()) + 1);
				
				indiaInvoiceNo.setSerNoSeq(serNoSeq);
				indiaInvoiceNo.setUsrId(condVO.getUsrId());
				
				dmdtInvNo = ofcCtyCd.concat(dmdtInvTpCd).concat(crntYrMon).concat(JSPUtil.getLPAD(serNoSeq, 4, "0"));
				indiaInvoiceNo.setDmdtInvNo(dmdtInvNo);
				dbDao.modifyIndiaInvoiceNo(indiaInvoiceNo);
			}
			
			// Invoice Number
			invoiceNoGenVO.setDmdtInvNo(dmdtInvNo);
    	}
    	catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    	
    	return invoiceNoGenVO;
    }
    
    /**
     * [ Invoice 의 종류 ]를 [ 판별 ] 합니다.<br>
     * 
     * @param String invoiceNo
     * @return String
     * @exception EventException
     */  
    public String searchInvoiceType(String invoiceNo) throws EventException {
    	
    	try {
    		return dbDao.searchInvoiceType(invoiceNo);
    	}
    	catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    }
    
    /**
     * [ 변경된 인도세법의 시스템 적용일 ]을 [ 조회 ] 합니다.<br>
     * 
     * @return String
     * @exception EventException
     */   
    public String searchIdaTaxApplDt() throws EventException {
    	
    	try {
    		return dbDao.searchIdaTaxApplDt();
    	}
    	catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
    	}
    }
    
    /**
     * [ Invoice ]을(를) [ 발행 ] 합니다.<br>
     * 
     * @param InvoiceGroupMgtVO invoiceGroupMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoice(InvoiceGroupMgtVO invoiceGroupMgtVO, SignOnUserAccount account) throws EventException {
    	final String SUCCESS = "DMT03064";
    	
    	log.debug("\n\n[ INVOICE ][ CREATION ] ***************< START >***************\n\n");
    	
    	// 반환 객체
    	DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
    	
    	ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceGroupMgtVO.getChargeBookingInvoiceVO();
    	IssuedInvoiceParamVO issuedInvoiceParamVO = invoiceGroupMgtVO.getIssuedInvoiceParamVO();
    	
        InvoiceIssueMgtVO invoiceIssueMgtVO	= new InvoiceIssueMgtVO();
        invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
        invoiceIssueMgtVO.setInvoiceIssueList(invoiceGroupMgtVO.getInvoiceIssueVOs());
        
    	try {
	    	//===================================================================================================================
	    	// 1. DMT Booking Container VVD 갱신
	    	//===================================================================================================================
    		log.debug("\n\n[ INVOICE ][ CREATION ] 1. UPDATE VVD INFO. FOR BOOKING CONTAINER\n\n");
    		this.modifyVslOfChgBkgCntr(invoiceIssueMgtVO);
	    	
	    	
	    	//==================================================================================================================
	    	// 2. Invoice 생성시 입력한 Payer 정보가 DMT Payer 정보에 등록되어 있지 않은 경우 등록해 줍니다.
	    	//==================================================================================================================
	    	log.debug("\n\n[ INVOICE ][ CREATION ] 2. REGIST PAYER !! (Payer Code :: " + issuedInvoiceParamVO.getSCustCd() + ")\n\n");
            if (!this.checkPayerAndSave(issuedInvoiceParamVO.getSCustCd(), account)) {
            	throw new Exception("Error! - Payer Check and Save");
            }
            

            //==================================================================================================================
	    	// 3. Invoice 생성 및 후 처리
	    	//==================================================================================================================
            log.debug("\n\n[ INVOICE ][ CREATION ] 3. CREATE INVOICE \n\n");
            dmtInvMnVO = this.issueInvoice(invoiceIssueMgtVO, account);
            
            chargeBookingInvoiceVO.setDmdtInvNo(dmtInvMnVO.getDmdtInvNo());
            
            if (SUCCESS.equals(dmtInvMnVO.getErrCode())) {
            	//=============================================================================================
            	// 3.1 Invoice 로 발행된 Charge 상태 변경
            	//=============================================================================================              	
            	chgCalcBC.changeChargeStatusForInvoice(invoiceIssueMgtVO, account);
            	
            	//=============================================================================================
            	// 3.2 가상 Invoice 처리
            	//=============================================================================================     	
            	// 1) 가상 Invoice 로 신규 Invoice 를 생성할 경우
                if ("Y".equals(issuedInvoiceParamVO.getDmdtVtInvYn())) {
                	// 가상 Invoice 의 상태를 'I'(Invoice) 로 변경한다.
                	dbDao.modifyVirtualInvoiceStatus(issuedInvoiceParamVO.getDmdtVtInvNo() , "I", issuedInvoiceParamVO.getSOfcCd());
                }
                // 2) 신규 Invoice 생성할 경우, 동일한 BKG No., Tariff Type 을 갖는 가상 Invoice 존재여부를 체크해서 존재할 경우, 가상 Invoice 를 Cancel 한다.
                else {
                	String bkgNo     = chargeBookingInvoiceVO.getBkgNo();
                	String dmdtTrfCd = chargeBookingInvoiceVO.getDmdtTrfCd();
                	
                	if ("Y".equals(this.searchExistsVirtualInvoice(bkgNo, dmdtTrfCd))) {
                		this.cancelVirtualInvoice(bkgNo, dmdtTrfCd);
                	}
                }
            }
    	}
    	catch(Exception ex) {
    		log.error(ex.getMessage());
    		
    		throw new EventException("DMT04002");	// A system problem occurred while creating the invoice
    	}
    	log.debug("\n\n[ INVOICE ][ CREATION ] ***************< END >***************\n\n");
    	
    	return dmtInvMnVO;
    }
    
    /**
     * [ Invoice ]을(를) [ 전송 ] 합니다.<br>
     * 
     * @param DmtInvMnVO dmdtInvMnVO
     * @param SignOnUserAccount account
     * @return boolean
     * @exception EventException
     */
    public boolean sendInvoiceToAr(DmtInvMnVO dmdtInvMnVO, SignOnUserAccount account) throws EventException {
    	GeneralARInvoiceCreationBC commandAR = new GeneralARInvoiceCreationBCImpl("DEFAULTXA");
    	
        List<ARInterfaceCreationVO> genIfVOs  = new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		
    	final String SUCCESS = "S";
    	
    	log.debug("\n\n[ INVOICE ][ A/R I/F ] ***************< START >***************\n\n");
    	try {
    		//===============================================================================================
    		// 1. 유효성 CHECK 로직
    		//===============================================================================================
    		log.debug("\n\n[ INVOICE ][ A/R I/F ] 1. CHECK VALIDATION OF INVOICE\n\n");
    		boolean isCheckFail = false;
    		
    		String[] invoiceNos = dmdtInvMnVO.getDmdtInvNo().split(",");	// GROUP INVOICE 인 경우
    		
    		// 1) 이미 A/R I/F 처리된 Invoice 가 존재하는지 체크
			List<String> chkInvoiceNos = dbDao.searchARIFCount(invoiceNos, dmdtInvMnVO.getCreOfcCd(), "1");
    		for (String chkInvoiceNo : chkInvoiceNos) {
				if (!StringUtils.isEmpty(chkInvoiceNo)) {	// 이미 A/R I/F 된 경우, Invoice No. 가 존재함. 
					isCheckFail = true;
					break;
				}
			}
    		// 1.1) 존재할 경우, 에러처리
    		if (isCheckFail) {
    			log.error("\n\n[ INVOICE ][ A/R I/F ] 1. CHECK VALIDATION OF INVOICE ::> It's already interfaced to A/R. Please check again ! ( DMT01024 )\n\n");
    			dmdtInvMnVO.setErrCode("DMT01024");	// It's already interfaced to A/R. Please check again !
    			dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode()));
    			return false;
    		}
    		
    		// 2) Invoice Currency 존재하는지 체크
    		chkInvoiceNos = dbDao.searchARIFCount(invoiceNos, dmdtInvMnVO.getCreOfcCd(), "2");    		
    		for (String chkInvNo : chkInvoiceNos) {
				if ("N".equals(chkInvNo)) {		// Invoice Currency 가 없는 경우, 'N'
					isCheckFail = true;
					break;
				}
			}
    		// 2.1) 존재하지 않을 경우, 에러처리
    		if (isCheckFail) {
    			log.error("\n\n[ INVOICE ][ A/R I/F ] 1. CHECK VALIDATION OF INVOICE ::> INV Cur. is missing ( DMT02002 )\n\n");
    			dmdtInvMnVO.setErrCode("DMT02002");	// INV Cur. is missing !
    			dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode()));
    			return false;
    		}
    		
    		for (String invoiceNo : invoiceNos) {
    			
	    		// 3) A/R 지점이 'LEHSC' 일 경우, DC 금액이 존재하는지 체크한다.
	    		String creditNoteYn = dbDao.searchCreditNoteYn(invoiceNo, dmdtInvMnVO.getCreOfcCd());
				//==========================================================================================================================
				// [ 유럽지역 서비스 개시할 경우 적용할 로직 - 유럽 서비스 개시할 경우 주석 해제할 것!! ]
				//  로직내용 : AR OFC 가 'LEHSC' 인 경우에는 Invoice 발행 후 After BKG Exception 을 통핸 조정금액이 존재하면 안된다. ]
				//==========================================================================================================================
	    		/*
	    		if ("N".equals(creditNoteYn)) {
	    			ChargeBookingInvoiceVO chargeBookingInvoiceVO = dbDao.checkAftInvAdjAmtByInvoiceNo(invoiceNo, dmdtInvMnVO.getCreOfcCd(), account.getOfc_cd());
	    			if ("LEHSC".equals(chargeBookingInvoiceVO.getArIfOfcCd()) && !"0".equals(chargeBookingInvoiceVO.getAftInvAdjAmt())) {
	    				dmdtInvMnVO.setErrCode("DMT03070");	// 미존재하는 에러코드임..
	    				return false;
	    			}
	    		}
	    		*/
	    		//==========================================================================================================================
	    		
	    		//===============================================================================================
	    		// 2. A/R I/F 전송
	    		//===============================================================================================
				log.debug("\n\n[ INVOICE ][ A/R I/F ] 2. SEND INVOICE TO A/R\n\n");
	    		ARInterfaceCreationCondVO arInfCondVO = new ARInterfaceCreationCondVO();
	    		arInfCondVO.setUsrOfcCd(account.getOfc_cd());
	    		arInfCondVO.setDmdtInvNo(invoiceNo);
	    		arInfCondVO.setCrInvFlg(creditNoteYn);
	    		arInfCondVO.setCreOfcCd(dmdtInvMnVO.getCreOfcCd());
	
	    		// 2.1) A/R I/F 전송 데이터 조회 >----------------------------------------------------------------------------------------
	    		ARInterfaceCreationVO arInterfaceCreationVO = searchARInterfaceInvoice(arInfCondVO);
	    		
	    		// 2.2) A/R I/F 전송 데이터 유효성 체크 >---------------------------------------------------------------------------------
	    		if (arInterfaceCreationVO.getInvArIfChgVOs() == null) {
	    			log.error("\n\n[ INVOICE ][ A/R I/F ] 2.2 CHECK DATA FOR SENDING TO A/R ::> Required data for sending to AR does not exist. ( DMT04003 )\n\n");
	    			dmdtInvMnVO.setErrCode("DMT04003");	// Required data for sending to AR does not exist.
	    			dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode()));
	    			return false;    			
	    		}
	    		
	    		// 2.3) A/R I/F 실행 >-----------------------------------------------------------------------------------------------------
	            genIfVOs = new ArrayList<ARInterfaceCreationVO>();	
	    		genIfVOs.add(arInterfaceCreationVO);
	    		
	    		rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
	    		String arIfNo = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
	    		log.error("\n\n[ INVOICE ][ A/R I/F ] 2.3 A/R I/F 반환 값 ::> " + arIfNo + "\n\n");
	    		
	    		// 2.4) A/R I/F 실행 후처리 >----------------------------------------------------------------------------------------------
	    		if (StringUtils.isEmpty(arIfNo)) {
	    			log.error("\n\n[ INVOICE ][ A/R I/F ] 2.4 A/R I/F failed! (The response message does not exist.) \n\n");
	    			dmdtInvMnVO.setErrCode("DMT03075");	// A/R I/F failed! (XXXXXXXXX) XXXXXXXXX -> 아래 지정된 메시지로 변환됨
	    			dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode(), "The response message does not exist."));
	    			return false; 	
	    		}
	    		
	    		String arIfRslt[] = arIfNo.split("::");
	    		// A/R I/F 실패할 경우
	    		if (!SUCCESS.equals(arIfRslt[0])) {
	    			log.error("\n\n[ INVOICE ][ A/R I/F ] 2.4 A/R I/F failed! \n\n");
	    			dmdtInvMnVO.setErrCode("DMT03075");	// A/R I/F failed! (XXXXXXXXX) XXXXXXXXX -> 아래 지정된 메시지로 변환됨
	    			dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode(), arIfRslt[1]));
	    			return false;     			
	    		}
	    		// A/R I/F 성공한 경우
	    		dmdtInvMnVO.setArIfNo(arIfRslt[1]);
	    		
	   			// Invoice 정보에서 A/R I/F 관련 컬럼정보를 갱신합니다.
	   			dbDao.modifyARInterface(arIfRslt[1], account.getOfc_cd(), account.getUsr_id(), invoiceNo, dmdtInvMnVO.getCreOfcCd());
	
	   			// EDI 전송 실행 ( 단, Inbound 인 경우에만 )
	   			InvArIfMnVO invArIfMnVO = arInterfaceCreationVO.getInvArIfMnVO();
	   			if ("I".equals(invArIfMnVO.getIoBndCd())) {
	   				List<EDIVO> eDIVOs = dbDao.searchToEdiList(invoiceNo, dmdtInvMnVO.getCreOfcCd());
					
					if (eDIVOs != null && !eDIVOs.isEmpty()) {
						//공통모듈을 통해서 EDI 전송을 수행한다.
						chgCalcBC.sendToEDI(eDIVOs);
					}
	   			}
	
	    		//===============================================================================================
	    		// 3. ERP 전송
	    		//===============================================================================================
	   			log.debug("\n\n[ INVOICE ][ A/R I/F ] 3. SEND INVOICE TO ERP (" + arIfRslt[1] + ")\n\n");
	   			commandAR.interfaceARInvoiceToERPAR(arIfRslt[1]);
    		}
    	}
    	catch(EventException ex) {
    		log.error(ex.getMessage());
    		
    		throw ex;
    	}
    	catch(Exception ex) {
    		log.error(ex.getMessage());
    		
    		dmdtInvMnVO.setErrCode("DMT03066");	// A/R I/F failed! Invoice No:XXXXXXXXX
    		dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode(), dmdtInvMnVO.getDmdtInvNo()));
    		return false;
    	}
    	
    	log.debug("\n\n[ INVOICE ][ A/R I/F ] ********************< END >********************\n\n");
    	dmdtInvMnVO.setErrCode("DMT03074"); 	// "A/R I/F Success! Invoice No:XXXXXXXXX ( """"XXXXXXXXX"""" => Invoice No)"
    	dmdtInvMnVO.setErrMsg(getErrMsgByArIf(dmdtInvMnVO.getErrCode(), dmdtInvMnVO.getDmdtInvNo()));

    	return true;
    }
    
    /**
     * [ Vessel 정보 ]을(를) [ 갱신(수정) ] 합니다.<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @exception EventException
     */   
    public void modifyVslOfChgBkgCntr(InvoiceIssueMgtVO invoiceIssueMgtVO) throws EventException {
    	
    	try {
	    	boolean isVvdUpdFlg = true;
	    	
	    	// 1.1 DMT Booking Container 에 등록된 VVD 갱신여부를 체크한다.
	    	for (InvoiceIssueVO invoiceIssueVO : invoiceIssueMgtVO.getInvoiceIssueVOs()) {
	            //체크를 하지 않으면 스킵
	            if (!"U".equals(invoiceIssueVO.getIbflag())) continue;
	            
	            if ("TSP".equals(invoiceIssueVO.getDmdtChgLocDivCd()) && "N".equals(invoiceIssueVO.getOfcTrnsFlg())) {
	            	isVvdUpdFlg = false;
	            	break;
	            }
	            else if ("SZP".equals(invoiceIssueVO.getDmdtChgLocDivCd())) {
	            	isVvdUpdFlg = false;
	            	break;
	            }    		
	    	}
	
	    	// 1.2 DMT Booking Container 에 등록된 VVD 를 갱신한다.
	    	if (isVvdUpdFlg) {
	    		ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
	    		
	    		// 조회조건 설정
	    		VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	    		vVDCheckDataVO.setBkgNo(chargeBookingInvoiceVO.getBkgNo());
	    		vVDCheckDataVO.setPolCd(chargeBookingInvoiceVO.getPolCd());
	    		vVDCheckDataVO.setPodCd(chargeBookingInvoiceVO.getPodCd());
	    		vVDCheckDataVO.setIoBnd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
	    		
	    		// 조회실행
	    		VVDNEtaVO vVDNEtaVO = searchIssueInvoiceVVD(vVDCheckDataVO);
	    		
	    		// 조회결과 처리
	    		if (vVDNEtaVO != null) {
	    			
	    			if (!StringUtils.isEmpty(vVDNEtaVO.getVslCd()) 
	    					&& !StringUtils.isEmpty(vVDNEtaVO.getSkdVoyNo()) 
	    					&& !StringUtils.isEmpty(vVDNEtaVO.getSkdDirCd())) {
	    			
	    				chgCalcBC.modifyBookingContainerVVD(vVDCheckDataVO);
	    				
	    				chargeBookingInvoiceVO.setVslCd(vVDNEtaVO.getVslCd());
	    				chargeBookingInvoiceVO.setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
	    				chargeBookingInvoiceVO.setSkdDirCd(vVDNEtaVO.getSkdDirCd());
	    				chargeBookingInvoiceVO.setVvdCd(vVDNEtaVO.getVslCd() + vVDNEtaVO.getSkdVoyNo() + vVDNEtaVO.getSkdDirCd());
	    			}
	    		}
	    	}    		
    	}
    	catch(EventException ex) {
    		log.error(ex.getMessage());
    		
    		throw ex;
    	}
    	catch(Exception ex) {
    		log.error(ex.getMessage());
    		
    		throw new EventException(ex.getMessage());
    	}    	
    }
    
    /**
     * [ Booking 에 속한 Charge 목록 ]을(를) [ 조회 ] 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<InvoiceIssueVO>
     * @exception EventException
     */
    public List<InvoiceIssueVO> searchChargeBookingInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
    	
    	try {
    		return dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
    	}
	    catch(DAOException ex) {
	    	log.error("[DAOException]"+ex.getMessage());
	        throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
	    } 
	    catch(Exception ex) {
	    	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
    }
    
    /**
     *[  Invoice 를 AR 로 전송 후 반환된 IF No. ]를 [ 수정 ] 합니다.
     * @param String arIfNo
     * @param String invNo
     * @throws EventException
     */
    public void modifyARInterfaceByManual(String arIfNo, String invNo) throws EventException {
    	
    	try {
    		dbDao.modifyARInterfaceByManual(arIfNo, invNo);
        } 
    	catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    }
    
    /**
     *[  AR 로 전송하기 위해서 필요한 Dummy Invoice No. ]를 [ 조회 ] 합니다.
     * @param String invNo
     * @return String
     * @throws EventException
     */
    public String searchDummyInvSrcNo(String invNo) throws EventException {
    	
    	try {
    		return dbDao.searchDummyInvSrcNo(invNo);
        } 
    	catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    }
    
  	/**
  	 * [ AFT BKG 승인으로 인해 발행되었던 관련 Invoice 건 ]을 [ 취소 ] 합니다. <br>
  	 * 
  	 * @param AftBkgCxlInvCondVO aftBkgCxlInvCondVO
  	 * @param SignOnUserAccount account
  	 * @return List<AftBkgCxlInvVO>
  	 * @exception EventException
  	 */	
  	public List<CancelInvoiceParamVO> cancelInvoiceByAftBkg(AftBkgCxlInvCondVO aftBkgCxlInvCondVO, SignOnUserAccount account) throws EventException {
  		
  		List<CancelInvoiceParamVO> cxlInvList = new ArrayList<CancelInvoiceParamVO>();
  		
    	try {
    		// AFT BKG 이 승인되었거나, 승인취소된 경우 발행되었던 Invoice 를 취소합니다.
    		cxlInvList = dbDao.searchCxlInvList(aftBkgCxlInvCondVO.getAftExptDarNo());
    		
    		// 대상이 존재할 경우
    		if (cxlInvList != null && cxlInvList.size() > 0) {
    			log.debug("\n\n[ cancelInvoiceByAftBkg ] cancel invoice count :: " + cxlInvList.size());
    			
    			// Invoice 단위로 취소처리를 실행합니다.
    			for (CancelInvoiceParamVO cxlInvVO : cxlInvList) {
    				
    				// 1. [ INV. 취소 ]============================================================================================================
    				// 1) INV. 취소 사유 설정
    				cxlInvVO.setIntgCdValCtnt("WAI");	// AFT BKG 승인 및 승인취소시 INV. 취소 사유코드 (WAI : 'Billing Correction due to After Booking Approval')
    				cxlInvVO.setAftExptDarNo(aftBkgCxlInvCondVO.getAftExptDarNo());
    				String cxlInvRmk = dbDao.searchInvoiceCancelRmk(cxlInvVO);
    				cxlInvVO.setCxlRmk(cxlInvRmk);
    				cxlInvVO.setAftBkgCxlYn("Y");		// INV. 취소는 AFT BKG 승인 및 승인취소로 인해서 야기 되었음. ( Credit INV. 생성시 어떤 OFC 를 사용할지에 따라서 Prefix 설정에 영향을 준다 )
    				
    				// 2) INV. 취소
    				log.debug("\n\n[ cancelInvoiceByAftBkg ] execute >> cancel invoice (inv no. : " + cxlInvVO.getDmdtInvNo() + ")");
    				List<ChargeArgumentVO> chargeArgumentVOList = this.cancelInvoice(cxlInvVO, account);
    				
    				// 3) INV. 취소 처리 중 발생된 오류 체크
    				ChargeArgumentVO rsltVO = chargeArgumentVOList.get(0);
    				log.debug("\n\n[ cancelInvoiceByAftBkg ] complete >> cancel invoice (inv no. : " + cxlInvVO.getDmdtInvNo() + ") >> result code :: " + rsltVO.getErrCode());
    				if ("DMT03024".equals(rsltVO.getErrCode()) || "DMT03063".equals(rsltVO.getErrCode())) {
    					// DMT03024 : INV. 가 존재하지 않을 경우 ( Credit or Cancel 된 INV. 가 아니어야 함 )
    					// DMT03063 : INV. 생성에 필요한 PREFIX 조회시 해당 정보가 존재하지 않을 경우
    					throw new EventException(rsltVO.getErrMsg());
    				}
    				//=================================================================================================================================
    				
    				
    				// 2. [ INV 취소에 따른 CHG 상태변경 ]=============================================================================================
        			// 1) CHG 를 기반으로 발행된 INV 인지 여부 판단 ( Manual 로 생성된 INV 는 CHG 하고는 별개이다. )
        			boolean isUpdChgSts = "M".equals(cxlInvVO.getInvTpCd()) ? false : true;

        			if (!isUpdChgSts) {
        				// SZPSC Dem Billing 에서 발행한 INV 는 모두 INV. Type Code 가 'M'
        				// 실제, CHG 를 기반으로 생성되기 때문에 아래와 같이 체크해서 처리해 줘야 됨
        				String suthChnIssFlg = this.checkSZPBBInvoice(cxlInvVO.getDmdtInvNo());
        				
        				if ("Y".equals(suthChnIssFlg)) isUpdChgSts = true;
        			}
        			
        			// 2) CHG 기반으로 발행된 INV. 인 경우, CHG 상태 변경
        			if (isUpdChgSts) {
        				log.debug("\n\n[ cancelInvoiceByAftBkg ] execute >> change charge status code (inv no. : " + cxlInvVO.getDmdtInvNo() + ")");
        				chgCalcBC.changeChargeStatusForInvoiceByCancel(chargeArgumentVOList, account);
        				log.debug("\n\n[ cancelInvoiceByAftBkg ] complete >> change charge status code (inv no. : " + cxlInvVO.getDmdtInvNo() + ")");
        			}
        			//=================================================================================================================================
        			
        			
    				// 3. A/R I/F 된 경우, CREDIT INV. 전송 ===========================================================================================
    				if ("DMT03062".equals(rsltVO.getErrCode())) {
    					
    					// 1) A/R I/F 를 위한 매개변수 설정
    	    			DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
    					dmtInvMnVO.setDmdtInvNo(rsltVO.getCrInvNo());
    					dmtInvMnVO.setCreOfcCd(cxlInvVO.getCreOfcCd());
    					
    					// 2) A/R I/F 실행
    					log.debug("\n\n[ cancelInvoiceByAftBkg ] execute >> send invoice to ar & erp (credit inv no. : " + rsltVO.getCrInvNo() + ")");
    		    		boolean isResult = this.sendInvoiceToAr(dmtInvMnVO, account);
    		    		log.debug("\n\n[ cancelInvoiceByAftBkg ] complete >> send invoice to ar & erp (credit inv no. : " + rsltVO.getCrInvNo() + ") >> result :: " + isResult);
    		    		
    		    		if (!isResult) {
    		    			// Transaction rollback for send invoice to A/R!!
    		    			throw new EventException(dmtInvMnVO.getErrMsg());
    		    		}   					
    				}
    				//=================================================================================================================================
    				
    				// 4. Virtual INV. 생성 Logic 에서 사용함.
    				cxlInvVO.setUpdOfcCd(account.getOfc_cd());
    				cxlInvVO.setUpdUsrId(account.getUsr_id());
    			}
    		}
        } 
    	catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } 
    	catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } 
    	
    	return cxlInvList;
  	}
  	
  	/**
  	 * [ Cancel 된 Invoice 를 Virtual 상태 ]로 [ 수정 ] 합니다. <br>
  	 * 
  	 * @param List<CancelInvoiceParamVO> cxlInvList
  	 * @exception EventException
  	 */	  	
  	public void modifyInvStsToVtByAftBkg(List<CancelInvoiceParamVO> cxlInvList) throws EventException {
  		
		try {
			for (CancelInvoiceParamVO cxlInvVO : cxlInvList) {
				dbDao.updateInvStsToVtByAftBkg(cxlInvVO);
			}
		}
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}  		
  	}
  	
  	/**
  	 * [ Biz Error Code 에 대한 Error Message ] 를 [ 조회 ] 합니다. <br>
  	 * 
  	 * @param String errMsgCd
  	 * @param String... errParams
  	 * @return String
  	 * @exception EventException
  	 */	  	
    private String getErrMsgByArIf(String errMsgCd, String...errParams) {
    	
    	String errMsg = "";

    	if ("DMT01024".equals(errMsgCd)) {	
    		// It's already interfaced to A/R. Please check again !
    		errMsg = new ErrorHandler(errMsgCd).getUserMessage();
    	}
    	else if ("DMT02002".equals(errMsgCd)) {
    		// INV Cur. is missing !
    		errMsg = new ErrorHandler(errMsgCd).getUserMessage();    		
    	}
    	else if ("DMT03066".equals(errMsgCd)) {
    		// A/R I/F failed! Invoice No:XXXXXXXXX
    		errMsg = new ErrorHandler(errMsgCd).getUserMessage();
    		errMsg = errMsg.replaceAll("XXXXXXXXX", errParams[0]);
    	}    	
    	else if ("DMT03074".equals(errMsgCd)) {
    		// DMT03074 : "A/R I/F Success! Invoice No:XXXXXXXXX
            // ( """"XXXXXXXXX"""" => Invoice No)"
    		errMsg = new ErrorHandler(errMsgCd).getUserMessage();
    		errMsg = errMsg.replaceAll("XXXXXXXXX", errParams[0]);
    	}   
    	
    	else if ("DMT03075".equals(errMsgCd)) {
    		// A/R I/F failed!
			// $1
    		errMsg = new ErrorHandler(errMsgCd, errParams[0]).getUserMessage();
    	}    	
    	else if ("DMT04003".equals(errMsgCd)) {
    		// Required data for sending to AR does not exist.
    		errMsg = new ErrorHandler(errMsgCd).getUserMessage();   
    	}

    	
    	return errMsg;
    }
}
